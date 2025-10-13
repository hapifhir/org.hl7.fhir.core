package org.hl7.fhir.r5.terminologies.expansion;

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



import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;

/*
 * Copyright (c) 2011+, HL7, Inc
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific
 * prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 */

import java.util.*;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.NoTerminologyServiceException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.BaseWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.LanguageUtils;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.providers.CodeSystemProvider;
import org.hl7.fhir.r5.terminologies.providers.CodeSystemProviderExtension;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.r5.terminologies.validation.VSCheckerException;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValueSetProcessBase;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader.LanguagePreference;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.i18n.I18nConstants;

import javax.annotation.Nonnull;

@MarkedToMoveToAdjunctPackage
public class ValueSetExpander extends ValueSetProcessBase {

  public class Token {
    private String system;
    private String code;
    public Token(String system, String code) {
      super();
      this.system = system;
      this.code = code;
    }
    public String getSystem() {
      return system;
    }
    public String getCode() {
      return code;
    }
    public boolean matches(Coding use) {
      return system.equals(use.getSystem()) && code.equals(use.getCode());
    }
    public boolean matchesLang(String language) {
      return system.equals("urn:ietf:bcp:47") && code.equals(language);
    }
  }

  private static final boolean REPORT_VERSION_ANYWAY = true;

  private static final String VS_EXP_IMPORT_ERROR_TOO_COSTLY = null;
  
  private ValueSet focus;
  private int maxExpansionSize = 1000;
  private WorkingContext dwc = new WorkingContext();

  @Getter @Setter
  private boolean noTerminologyServer;
  private boolean checkCodesWhenExpanding;
  private boolean includeAbstract = true;
  private boolean debug;
  private boolean reportingOnVersionsInContains;
  private Set<String> sources = new HashSet<>();

  private AcceptLanguageHeader langs;
  private List<Token> designations = new ArrayList<>();

  public ValueSetExpander(BaseWorkerContext context, TerminologyOperationContext opContext) {
    super(context, opContext);
  }

  public ValueSetExpander(BaseWorkerContext context, TerminologyOperationContext opContext, List<String> allErrors) {
    super(context, opContext);
    this.allErrors = allErrors;
  }

  public void setMaxExpansionSize(int theMaxExpansionSize) {
    maxExpansionSize = theMaxExpansionSize;
  }
  
  private ValueSetExpansionContainsComponent addCode(WorkingContext wc, String system, String version, String code, String display, String dispLang, ValueSetExpansionContainsComponent parent, List<ConceptDefinitionDesignationComponent> designations, Parameters expParams,
      boolean isAbstract, boolean inactive, List<ValueSet> filters, boolean noInactive, boolean deprecated, List<ValueSetExpansionPropertyComponent> vsProp,
      List<ConceptPropertyComponent> csProps, CodeSystem cs, List<org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent> expProps,
      List<Extension> csExtList, List<Extension> vsExtList, ValueSetExpansionComponent exp, String vstatus) throws OperationIsTooCostly {
    opContext.deadCheck("addCode"+code);
    
    if (filters != null && !filters.isEmpty() && !filterContainsCode(filters, system, code, exp))
      return null;
    if (noInactive && inactive) {
      return null;
    }
    
    ValueSetExpansionContainsComponent n = new ValueSet.ValueSetExpansionContainsComponent();
    n.setSystem(system);
    n.setCode(code);
    n.setVersion(version);
    if (isAbstract) {
      n.setAbstract(true);
    }
    if (inactive) {
      n.setInactive(true);
      ValueSetUtilities.addCodeProperty(focus, n, "http://hl7.org/fhir/concept-properties#status", "status", vstatus);
    } else if (!Utilities.noString(vstatus) && !Utilities.existsInList(vstatus.toLowerCase(), "active")) {
      ValueSetUtilities.addCodeProperty(focus, n, "http://hl7.org/fhir/concept-properties#status", "status", vstatus);
    } else if (deprecated) {
      ValueSetUtilities.setDeprecated(vsProp, n);
    }
    if (ExtensionUtilities.hasExtension(csExtList, "http://hl7.org/fhir/StructureDefinition/codesystem-label")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#label", "label", ExtensionUtilities.getExtensionValue(csExtList, "http://hl7.org/fhir/StructureDefinition/codesystem-label"));
    }
    if (ExtensionUtilities.hasExtension(vsExtList, "http://hl7.org/fhir/StructureDefinition/valueset-label")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#label", "label", ExtensionUtilities.getExtensionValue(vsExtList, "http://hl7.org/fhir/StructureDefinition/valueset-label"));
    }
    if (ExtensionUtilities.hasExtension(csExtList, "http://hl7.org/fhir/StructureDefinition/codesystem-conceptOrder")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#order", "order", convertToDecimal(ExtensionUtilities.getExtensionValue(csExtList, "http://hl7.org/fhir/StructureDefinition/codesystem-conceptOrder")));
    }
    if (ExtensionUtilities.hasExtension(vsExtList, "http://hl7.org/fhir/StructureDefinition/valueset-conceptOrder")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#order", "order", convertToDecimal(ExtensionUtilities.getExtensionValue(vsExtList, "http://hl7.org/fhir/StructureDefinition/valueset-conceptOrder")));
    }
    if (ExtensionUtilities.hasExtension(csExtList, "http://hl7.org/fhir/StructureDefinition/itemWeight")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#itemWeight", "weight", ExtensionUtilities.getExtensionValue(csExtList, "http://hl7.org/fhir/StructureDefinition/itemWeight"));
    }
    if (ExtensionUtilities.hasExtension(vsExtList, "http://hl7.org/fhir/StructureDefinition/itemWeight")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#itemWeight", "weight", ExtensionUtilities.getExtensionValue(vsExtList, "http://hl7.org/fhir/StructureDefinition/itemWeight"));
    }
    ExtensionUtilities.copyExtensions(csExtList, n.getExtension(),
        "http://hl7.org/fhir/StructureDefinition/coding-sctdescid", 
        "http://hl7.org/fhir/StructureDefinition/rendering-style", 
        "http://hl7.org/fhir/StructureDefinition/rendering-xhtml",
        "http://hl7.org/fhir/StructureDefinition/codesystem-alternate");

    ExtensionUtilities.copyExtensions(vsExtList, n.getExtension(),
        "http://hl7.org/fhir/StructureDefinition/valueset-supplement", 
        "http://hl7.org/fhir/StructureDefinition/valueset-deprecated",
        "http://hl7.org/fhir/StructureDefinition/valueset-concept-definition",
        "http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status",
        "http://hl7.org/fhir/StructureDefinition/coding-sctdescid", 
        "http://hl7.org/fhir/StructureDefinition/rendering-style", 
        "http://hl7.org/fhir/StructureDefinition/rendering-xhtml");
    
    // display and designations
    ConceptDefinitionDesignationComponent pref = null;
    if (langs == null) {
      n.setDisplay(display);
    } else {
      if (designations == null) {
        designations = new ArrayList<>();
      }
      designations.add(new ConceptDefinitionDesignationComponent().setLanguage(dispLang).setValue(display).setUse(new Coding().setSystem("http://terminology.hl7.org/CodeSystem/hl7TermMaintInfra").setCode("preferredForLanguage")));
      pref = findMatchingDesignation(designations);
      if (pref != null) {
        n.setDisplay(pref.getValue());
      }
    }
    if (!n.hasDisplay() && display != null && langs != null && (langs.matches(dispLang) || Utilities.existsInList(langs.getSource(), "en", "en-US"))) {
      n.setDisplay(display);      
    }

    if (expParams.getParameterBool("includeDesignations") && designations != null) {
      
      for (ConceptDefinitionDesignationComponent t : designations) {
        if (t != pref && (t.hasLanguage() || t.hasUse()) && t.getValue() != null && passesDesignationFilter(t)) {
          ConceptReferenceDesignationComponent d = n.addDesignation();
          if (t.getLanguage() != null) {
            d.setLanguage(t.getLanguage().trim());
          }
          if (t.getValue() != null) {
            d.setValue(t.getValue().trim());
          }
          if (t.getUse() != null) {
            d.setUse(t.getUse());
          }
          for (Extension ext : t.getExtension()) {
            if (Utilities.existsInList(ext.getUrl(), "http://hl7.org/fhir/StructureDefinition/coding-sctdescid", "http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status")) {
              d.addExtension(ext);
            }
          }
        }
      }
    }
    for (ParametersParameterComponent p : expParams.getParameter()) {
      if ("property".equals(p.getName())) {
        if (csProps != null && p.hasValue()) {
          for (ConceptPropertyComponent cp : csProps) {
            if (p.getValue().primitiveValue().equals(cp.getCode())) {
              PropertyComponent pd = cs.getProperty(cp.getCode());
              String url = pd == null ? null : pd.getUri();
              if (url == null) {
                if ("definition".equals(cp.getCode())) {
                  url = "http://hl7.org/fhir/concept-properties#definition";
                } else {
                  // ??
                }
              }
              ValueSetUtilities.addProperty(focus, n, url, cp.getCode(), cp.getValue()).copyExtensions(cp, "http://hl7.org/fhir/StructureDefinition/alternate-code-use", "http://hl7.org/fhir/StructureDefinition/alternate-code-status");
            }
          }
        }
        if (expProps != null && p.hasValue()) {
          for (org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent cp : expProps) {
            if (p.getValue().primitiveValue().equals(cp.getCode())) {
              String url = null;
              for (ValueSetExpansionPropertyComponent t : vsProp) {
                if (t.hasCode() && t.getCode().equals(cp.getCode())) {
                  url = t.getUri();
                }
              }
              if (url == null) {
                if ("definition".equals(cp.getCode())) {
                  url = "http://hl7.org/fhir/concept-properties#definition";
                } else {
                  // TODO: try looking it up from the code system
                }
              }
              ValueSetUtilities.addProperty(focus, n, url, cp.getCode(), cp.getValue()).copyExtensions(cp, "http://hl7.org/fhir/StructureDefinition/alternate-code-use", "http://hl7.org/fhir/StructureDefinition/alternate-code-status");
            }
          }
        }        
      }
    }

    String s = key(n);
    if (wc.getExcludeKeys().contains(s)) {
      return null;
    } else if (wc.getMap().containsKey(s)) {
      wc.setCanBeHierarchy(false);
    } else {
      wc.getCodes().add(n);
      wc.getMap().put(s, n);
//      if (wc == dwc && wc.getTotal() > maxExpansionSize) {
//        if (wc.getOffset()+wc.getCount() > 0 && wc.getTotal() > wc.getOffset()+wc.getCount()) {
//          wc.setTotal(-1);
//          throw new EFinished();
//        }
//        throw failCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY, focus.getUrl(), ">" + Integer.toString(maxExpansionSize)));
//      }
    }
    if (wc.isCanBeHierarchy() && parent != null) {
      parent.getContains().add(n);
    } else if (!wc.getRootMap().containsKey(s)) {
      wc.getRootMap().put(s, n);
      wc.getRoots().add(n);
    }
    return n;
  }

  private String findParamValue(List<ValueSetExpansionParameterComponent> list, String name) {
    for (ValueSetExpansionParameterComponent p : list) {
      if (name.equals(p.getName())) {
        return p.getValue().primitiveValue();
      }
    }
    return null;
  }

  private DataType convertToDecimal(DataType v) {
    if (v == null) {
      return null;
    } 
    if (v instanceof DecimalType) {
      return v;
    } 
    if (v instanceof IntegerType) {
      return new DecimalType(((IntegerType) v).asStringValue());
    }
    return null;
  }

  private boolean passesDesignationFilter(ConceptDefinitionDesignationComponent d) {
    if (designations.isEmpty()) {
      return true;
    }
    for (Token t : designations) {
      if ((d.hasUse() && t.matches(d.getUse())) || t.matchesLang(d.getLanguage())) {
        return true;
      }
      for (Coding c : d.getAdditionalUse()) {
        if (t.matches(c)) {
          return true;
        }
      }
    }
    return false;
  }

  private ConceptDefinitionDesignationComponent findMatchingDesignation(List<ConceptDefinitionDesignationComponent> designations) {
    if (langs == null) {
      return null;
    }
    // we have a list of languages in priority order 
    // we have a list of designations in no order 
    // language exact match is preferred
    // display is always preferred
    
    for (LanguagePreference lang : langs.getLangs()) {
      if (lang.getValue() > 0) {
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (isDisplay(cd, false) && LanguageUtils.langsMatchExact(cd.getLanguage(), lang.getLang())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (isDisplay(cd, false) && LanguageUtils.langsMatch(lang.getLang(), cd.getLanguage())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (isDisplay(cd, false) && LanguageUtils.langsMatch(cd.getLanguage(), lang.getLang())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (isDisplay(cd, true) && LanguageUtils.langsMatchExact(cd.getLanguage(), lang.getLang())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (isDisplay(cd, true) && LanguageUtils.langsMatch(cd.getLanguage(), lang.getLang())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (isDisplay(cd, true) && LanguageUtils.langsMatch(lang.getLang(), cd.getLanguage())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (LanguageUtils.langsMatchExact(cd.getLanguage(), lang.getLang())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (LanguageUtils.langsMatch(cd.getLanguage(), lang.getLang())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (LanguageUtils.langsMatch(lang.getLang(), cd.getLanguage())) {
            return cd;
          }
        }
      }
    }
    return null;
  }

  private boolean isDisplay(ConceptDefinitionDesignationComponent cd, boolean def) {
    return (def && !cd.hasUse())
      || (cd.hasUse() && cd.getUse().is("http://terminology.hl7.org/CodeSystem/hl7TermMaintInfra", "preferredForLanguage"))
      || (cd.hasUse() && cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "display"));
  }

  private boolean filterContainsCode(List<ValueSet> filters, String system, String code, ValueSetExpansionComponent exp) {
    for (ValueSet vse : filters) {
      checkCanonical(exp, vse, focus);
      if (expansionContainsCode(vse.getExpansion().getContains(), system, code))
        return true;
    }
    return false;
  }

  private boolean expansionContainsCode(List<ValueSetExpansionContainsComponent> contains, String system, String code) {
    for (ValueSetExpansionContainsComponent cc : contains) {
      if (system.equals(cc.getSystem()) && code.equals(cc.getCode()))
        return true;
      if (expansionContainsCode(cc.getContains(), system, code))
        return true;
    }
    return false;
  }

  private ConceptDefinitionDesignationComponent getMatchingLang(List<ConceptDefinitionDesignationComponent> list, AcceptLanguageHeader langs) {
    for (ConceptDefinitionDesignationComponent t : list) {
      if (LanguageUtils.langsMatchExact(langs, t.getLanguage())) {
        return t;
      }
    }
    for (ConceptDefinitionDesignationComponent t : list) {
      if (LanguageUtils.langsMatch(langs, t.getLanguage())) {
        return t;
      }
    }
    return null;
  }

  private void addCodeAndDescendents(WorkingContext wc, ValueSetExpansionContainsComponent focus, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filters, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc, ValueSetExpansionComponent exp, String langDisplay)  throws FHIRException, OperationIsTooCostly {
    opContext.deadCheck("addCodeAndDescendents");
    focus.checkNoModifiers("Expansion.contains", "expanding");
    ValueSetExpansionContainsComponent np = null;
    for (String code : getCodesForConcept(focus, expParams)) {
      String vstatus = determineStatus(vsSrc, focus);
      ValueSetExpansionContainsComponent t = addCode(wc, focus.getSystem(), focus.getVersion(), code, focus.getDisplay(), langDisplay, parent,
           convert(focus.getDesignation()), expParams, focus.getAbstract(), focus.getInactive(), filters, noInactive, false,
        vsProps, makeCSProps(focus.getExtensionString(ExtensionDefinitions.EXT_DEFINITION), null), null, focus.getProperty(), null, focus.getExtension(), exp, vstatus);
      if (np == null) {
        np = t;
      }
    }
    for (ValueSetExpansionContainsComponent c : focus.getContains())
      addCodeAndDescendents(wc, c, np, expParams, filters, noInactive, vsProps, vsSrc, exp, langDisplay);
  }

  private String determineStatus(ValueSet vs, ValueSetExpansionContainsComponent focus) {
    String vstatus = ValueSetUtilities.getProperty(vs.getExpansion().getProperty(), focus, "status", "http://hl7.org/fhir/concept-properties#status");
    if (vstatus == null) {
      vstatus = focus.getExtensionString(ExtensionDefinitions.EXT_STANDARDS_STATUS);
    }
    if (Utilities.existsInList(vstatus, "retired")) {
      return null;
    }
    return vstatus;
  }

  private String getLang(ValueSet vsSrc) {
    if (vsSrc.hasLanguage()) {
      return vsSrc.getLanguage();
    }
    for (ValueSetExpansionParameterComponent p : vsSrc.getExpansion().getParameter()) {
      if ("displayLanguage".equals(p.getName())) {
        return p.getValue().primitiveValue();
      }
    }
    return null;
  }

  private List<ConceptPropertyComponent> makeCSProps(String definition, List<ConceptPropertyComponent> list) {
    List<ConceptPropertyComponent> res = new ArrayList<>();
    if (!Utilities.noString(definition)) {
      res.add(new ConceptPropertyComponent("definition", new StringType(definition)));
    }
    if (list != null) {
      res.addAll(list);
    }
    return res;
  }

  private List<String> getCodesForConcept(ValueSetExpansionContainsComponent focus, Parameters expParams) {
    List<String> codes = new ArrayList<>();
    codes.add(focus.getCode());
    for (org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent p : focus.getProperty()) {
      if ("alternateCode".equals(p.getCode()) && (altCodeParams.passes(p.getExtension())) && p.getValue().isPrimitive()) {
        codes.add(p.getValue().primitiveValue());        
      }
    }
    return codes;
  }

  private List<ConceptDefinitionDesignationComponent> convert(List<ConceptReferenceDesignationComponent> designations) {
    List<ConceptDefinitionDesignationComponent> list = new ArrayList<ConceptDefinitionDesignationComponent>();
    for (ConceptReferenceDesignationComponent d : designations) {
      ConceptDefinitionDesignationComponent n = new ConceptDefinitionDesignationComponent();
      n.setLanguage(d.getLanguage());
      if (d.hasUse()) {
        n.setUse(d.getUse());
      }
      n.setValue(d.getValue());
      list.add(n);
    }
    return list;
  }

  private void addCodeAndDescendents(WorkingContext wc, CodeSystem cs, String system, String version, ConceptDefinitionComponent def, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filters,
        ConceptDefinitionComponent exclusion, ConceptFilter filterFunc, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, List<WorkingContext> otherFilters, ValueSetExpansionComponent exp)  throws FHIRException, OperationIsTooCostly {
    opContext.deadCheck("addCodeAndDescendents");
    def.checkNoModifiers("Code in Code System", "expanding");
    if (exclusion != null) {
      if (exclusion.getCode().equals(def.getCode()))
        return; // excluded.
    }
    ValueSetExpansionContainsComponent np = null;
    boolean abs = CodeSystemUtilities.isNotSelectable(cs, def);
    boolean inc = CodeSystemUtilities.isInactive(cs, def);
    boolean dep = CodeSystemUtilities.isDeprecated(cs, def, false);
    String vstatus = determineStatus(cs, def);
    if ((includeAbstract || !abs)  && filterFunc.includeConcept(cs, def) && passesOtherFilters(otherFilters, cs, def.getCode())) {
      for (String code : getCodesForConcept(def, expParams)) {
        ValueSetExpansionContainsComponent t = addCode(wc, system, version, code, def.getDisplay(), cs.getLanguage(), parent, def.getDesignation(), expParams,
          abs, inc, filters, noInactive, dep, vsProps, makeCSProps(def.getDefinition(), def.getProperty()), cs,
          null, def.getExtension(), null, exp, vstatus) ;
        if (np == null) {
          np = t;
        }
      }
    }
    for (ConceptDefinitionComponent c : def.getConcept()) {
      addCodeAndDescendents(wc, cs, system, version, c, np, expParams, filters, exclusion, filterFunc, noInactive, vsProps, otherFilters, exp);
    }
    if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
      List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
      for (ConceptDefinitionComponent c : children)
        addCodeAndDescendents(wc, cs, system, version, c, np, expParams, filters, exclusion, filterFunc, noInactive, vsProps, otherFilters, exp);
    }
  }

  private String determineStatus(CodeSystem cs, ConceptDefinitionComponent def) {
    String vstatus = CodeSystemUtilities.getStatus(cs, def);
    if (vstatus == null) {
      vstatus = def.getExtensionString(ExtensionDefinitions.EXT_STANDARDS_STATUS);
    }
    if (Utilities.existsInList(vstatus, "retired")) {
      return null;
    }
    return vstatus;
  }

  private void excludeCodeAndDescendents(WorkingContext wc, CodeSystem cs, String system, ConceptDefinitionComponent def, Parameters expParams, List<ValueSet> filters, 
      ConceptDefinitionComponent exclusion, ConceptFilter filterFunc, List<WorkingContext> otherFilters, ValueSetExpansionComponent exp)  throws FHIRException, OperationIsTooCostly {
    opContext.deadCheck("excludeCodeAndDescendents");
    def.checkNoModifiers("Code in Code System", "expanding");
    if (exclusion != null) {
      if (exclusion.getCode().equals(def.getCode()))
        return; // excluded.
    }
    boolean abs = CodeSystemUtilities.isNotSelectable(cs, def);
    if ((includeAbstract || !abs)  && filterFunc.includeConcept(cs, def) && passesOtherFilters(otherFilters, cs, def.getCode())) {
      for (String code : getCodesForConcept(def, expParams)) {
        if (!(filters != null && !filters.isEmpty() && !filterContainsCode(filters, system, code, exp)))
          excludeCode(wc, system, code);
      }
    }
    for (ConceptDefinitionComponent c : def.getConcept()) {
      excludeCodeAndDescendents(wc, cs, system, c, expParams, filters, exclusion, filterFunc, otherFilters, exp);
    }
    if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
      List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
      for (ConceptDefinitionComponent c : children)
        excludeCodeAndDescendents(wc, cs, system, c, expParams, filters, exclusion, filterFunc, otherFilters, exp);
    }
  }

  private List<String> getCodesForConcept(ConceptDefinitionComponent focus, Parameters expParams) {
    List<String> codes = new ArrayList<>();
    codes.add(focus.getCode());
    for (ConceptPropertyComponent p : focus.getProperty()) {
      if ("alternateCode".equals(p.getCode()) && (altCodeParams.passes(p.getExtension())) && p.getValue().isPrimitive()) {
        codes.add(p.getValue().primitiveValue());        
      }
    }
    return codes;
  }

  private static boolean hasUse(ConceptPropertyComponent p, List<String> uses) {
    for (Extension ext : p.getExtensionsByUrl(ExtensionDefinitions.EXT_CS_ALTERNATE_USE)) {
      if (ext.hasValueCoding() && Utilities.existsInList(ext.getValueCoding().getCode(), uses)) {
        return true;
      }
    }
    return false;
  }

  

  private void addCodes(ValueSetExpansionComponent expand, List<ValueSetExpansionParameterComponent> params, Parameters expParams, List<ValueSet> filters, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc, ValueSetExpansionComponent exp) throws OperationIsTooCostly, FHIRException {
    if (expand != null) {
      if (expand.getContains().size() > maxExpansionSize)
        throw failAsTooCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY, vsSrc.getUrl(), ">" + Integer.toString(expand.getContains().size())));
      for (ValueSetExpansionParameterComponent p : expand.getParameter()) {
        if (!existsInParams(params, p.getName(), p.getValue()))
          params.add(p);
      }
      
      copyImportContains(expand.getContains(), null, expParams, filters, noInactive, vsProps, vsSrc, exp);
    }
  }

  private void excludeCode(WorkingContext wc, String theSystem, String theCode) {
    ValueSetExpansionContainsComponent n = new ValueSet.ValueSetExpansionContainsComponent();
    n.setSystem(theSystem);
    n.setCode(theCode);
    String s = key(n);
    wc.getExcludeKeys().add(s);
  }

  private void excludeCodes(WorkingContext wc, ConceptSetComponent exc, Parameters expParams, ValueSetExpansionComponent exp, ValueSet vs, String vspath) throws FHIRException, FileNotFoundException, OperationIsTooCostly, IOException {
    opContext.deadCheck("excludeCodes");
    exc.checkNoModifiers("Compose.exclude", "expanding");
    if (exc.hasSystem() && exc.getConcept().size() == 0 && exc.getFilter().size() == 0) {
      wc.getExcludeSystems().add(exc.getSystem());
    }

    for (UriType imp : exc.getValueSet()) {
      excludeCodes(wc, importValueSetForExclude(wc, imp.getValue(), exp, expParams, false, vs).getExpansion());
    }
    
    if (exc.hasSystem()) {
      String sv = exc.getSystem()+(exc.hasVersion() ? "#"+exc.getVersion(): "");
      if (dwc.getCountIncompleteSystems().contains(sv)) {
        dwc.setNoTotal(true);
      }

      CodeSystem cs = context.fetchSupplementedCodeSystem(exc.getSystem());
      if ((cs == null || cs.getContent() != CodeSystemContentMode.COMPLETE) && context.getTxSupportInfo(exc.getSystem(), exc.getVersion()).isSupported()) {
        ValueSetExpansionOutcome vse = context.expandVS(new TerminologyOperationDetails(requiredSupplements), exc, false, false);
        ValueSet valueset = vse.getValueset();
        if (valueset.hasUserData(UserDataNames.VS_EXPANSION_SOURCE)) {
          sources.add(valueset.getUserString(UserDataNames.VS_EXPANSION_SOURCE));
        }
        if (valueset == null)
          throw failTSE("Error Expanding ValueSet: "+vse.getError());
        excludeCodes(wc, valueset.getExpansion());
        return;
      }

      for (ConceptReferenceComponent c : exc.getConcept()) {
        excludeCode(wc, exc.getSystem(), c.getCode());
      }

      if (exc.getFilter().size() > 0) {
        if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
          addFragmentWarning(exp, cs);
        }
        List<WorkingContext> filters = new ArrayList<>();
        for (int i = 1; i < exc.getFilter().size(); i++) {
          WorkingContext wc1 = new WorkingContext();
          filters.add(wc1);
          processFilter(exc, exp, expParams, null, cs, false, exc.getFilter().get(i), wc1, null, true, vspath+".filter["+i+"]");
        }
        ConceptSetFilterComponent fc = exc.getFilter().get(0);
        WorkingContext wc1 = dwc;
        processFilter(exc, exp, expParams, null, cs, false, fc, wc1, filters, true, vspath+".filter[0]");
      }
    }
  }

  private void excludeCodes(WorkingContext wc, ValueSetExpansionComponent expand) {
    opContext.deadCheck("excludeCodes");
    for (ValueSetExpansionContainsComponent c : expand.getContains()) {
      excludeCode(wc, c.getSystem(), c.getCode());
    }
  }

  private boolean existsInParams(List<ValueSetExpansionParameterComponent> params, String name, DataType value) {
    for (ValueSetExpansionParameterComponent p : params) {
      if (p.getName().equals(name) && PrimitiveType.compareDeep(p.getValue(), value, false)) {
        return true;
      }
    }
    return false;
  }

  public ValueSetExpansionOutcome expand(ValueSet source, Parameters expParams) {
    allErrors.clear();
    try {
      opContext.seeContext(source.getVersionedUrl());
      
      return expandInternal(source, expParams);
    } catch (NoTerminologyServiceException e) {
      // well, we couldn't expand, so we'll return an interface to a checker that can check membership of the set
      // that might fail too, but it might not, later.
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.NOSERVICE, allErrors, false);
    } catch (CodeSystemProviderExtension e) {
      // well, we couldn't expand, so we'll return an interface to a checker that can check membership of the set
      // that might fail too, but it might not, later.
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.INTERNAL_ERROR, allErrors, false);
    } catch (TerminologyServiceProtectionException e) {
      if (opContext.isOriginal()) {
        return new ValueSetExpansionOutcome(e.getMessage(), e.getError(), allErrors, false);
      } else {
        throw e;
      }
    } catch (OperationIsTooCostly e) {
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.TOO_COSTLY, allErrors, false);
    } catch (UnknownValueSetException e) {
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.VALUESET_UNKNOWN, allErrors, false);
    } catch (VSCheckerException e) {
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.UNKNOWN, allErrors, e.getIssues());      
    } catch (Exception e) {
      if (debug) {
        e.printStackTrace();
      }
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.UNKNOWN, allErrors, e instanceof EFhirClientException || e instanceof TerminologyServiceException);
    }
  }

  public ValueSetExpansionOutcome expandInternal(ValueSet source, Parameters expParams) throws FHIRException, FileNotFoundException, OperationIsTooCostly, IOException, CodeSystemProviderExtension {
    if (expParams == null)
      expParams = makeDefaultExpansion();
    altCodeParams.seeParameters(expParams);
    altCodeParams.seeValueSet(source);
    source.checkNoModifiers("ValueSet", "expanding");
    focus = source.copy();
    focus.setIdBase(null);
    focus.setExpansion(new ValueSet.ValueSetExpansionComponent());
    focus.getExpansion().setTimestampElement(DateTimeType.now());
    focus.getExpansion().setIdentifier(Factory.createUUID()); 
    checkCanonical(focus.getExpansion(), focus, focus);
    for (Extension ext : focus.getCompose().getExtensionsByUrl(ExtensionDefinitions.EXT_VS_EXP_PARAM_NEW, ExtensionDefinitions.EXT_VS_EXP_PARAM_OLD)) {
      processParameter(ext.getExtensionString("name"), ext.getExtensionByUrl("value").getValue());
    }
    for (ParametersParameterComponent p : expParams.getParameter()) {
      processParameter(p.getName(), p.getValue());
    }
    for (Extension s : focus.getExtensionsByUrl(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED)) {
      requiredSupplements.add(s.getValue().primitiveValue());
    }
    if (langs == null && focus.hasLanguage()) {
      langs = new AcceptLanguageHeader(focus.getLanguage(), true);
    }

    try {
      if (source.hasCompose()) {
        //        ExtensionsUtils.stripExtensions(focus.getCompose()); - disabled 23/05/2023 GDG - why was this ever thought to be a good idea?
        handleCompose(source.getCompose(), focus.getExpansion(), expParams, source.getUrl(), focus.getExpansion().getExtension(), source);
      }
    } catch (EFinished e) {
      // nothing - we intended to trap this here
    }

    if (dwc.getCount() > maxExpansionSize && dwc.getOffsetParam() + dwc.getCountParam() == 0) {
      if (dwc.isNoTotal()) {
        throw failAsTooCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY, focus.getVersionedUrl(), ">" + MessageFormat.format("{0,number,#}", maxExpansionSize)));
      } else {
        throw failAsTooCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY_COUNT, focus.getVersionedUrl(), ">" + MessageFormat.format("{0,number,#}", maxExpansionSize), MessageFormat.format("{0,number,#}", dwc.getCount())));
      }
    } else if (dwc.isCanBeHierarchy() && ((dwc.getCountParam() == 0) || dwc.getCountParam() > dwc.getCodes().size())) {
      for (ValueSetExpansionContainsComponent c : dwc.getRoots()) {
        focus.getExpansion().getContains().add(c);
      }
    } else {
      int i = 0;
      int cc = 0;
      for (ValueSetExpansionContainsComponent c : dwc.getCodes()) {
        c.getContains().clear(); // make sure any hierarchy is wiped
        if (dwc.getMap().containsKey(key(c)) && (includeAbstract || !c.getAbstract())) { // we may have added abstract codes earlier while we still thought it might be heirarchical, but later we gave up, so now ignore them
          if (dwc.getOffsetParam() == 0 || i >= dwc.getOffsetParam()) {
            focus.getExpansion().getContains().add(c);
            cc++;
            if (cc == dwc.getCountParam()) {
              break;
            }
          }
          i++;
        }
      }
    }

    if (!reportingOnVersionsInContains) {
      stripVersions(focus.getExpansion().getContains());
    }

    if (dwc.hasOffsetParam()) {
      focus.getExpansion().setOffset(dwc.getOffsetParam());
    }
    if (!dwc.isNoTotal()) {
      focus.getExpansion().setTotal(dwc.getStatedTotal());
    }
    if (!requiredSupplements.isEmpty()) {      
      return new ValueSetExpansionOutcome(context.formatMessagePlural(requiredSupplements.size(), I18nConstants.VALUESET_SUPPLEMENT_MISSING, CommaSeparatedStringBuilder.build(requiredSupplements)), TerminologyServiceErrorClass.BUSINESS_RULE, allErrors, false);
    }
    if (!expParams.hasParameter("includeDefinition") || !expParams.getParameterBool("includeDefinition")) {
      focus.setCompose(null);
      focus.getExtension().clear();
      focus.setPublisher(null);
      focus.setDescription(null);
      focus.setPurpose(null);
      focus.getContact().clear();
      focus.setCopyright(null);
      focus.setText(null);
    }
    return new ValueSetExpansionOutcome(focus);
  }

  private void processParameter(String name, DataType value) {
    if (Utilities.existsInList(name, "includeDesignations", "excludeNested", "activeOnly", "offset", "count")) {
      focus.getExpansion().getParameter().removeIf(p -> p.getName().equals(name));
      focus.getExpansion().addParameter().setName(name).setValue(value);
    }
    if ("displayLanguage".equals(name)) {
      this.langs = new AcceptLanguageHeader(value.primitiveValue(), true);
      focus.getExpansion().getParameter().removeIf(p -> p.getName().equals(name));
      focus.getExpansion().addParameter().setName(name).setValue(new CodeType(value.primitiveValue()));
    }
    if ("designation".equals(name)) {
      String[] v = value.primitiveValue().split("\\|");
      if (v.length != 2 || !Utilities.isAbsoluteUrl(v[0]) || Utilities.noString(v[1])) {
        throw new NoTerminologyServiceException("Unable to understand designation parameter "+value.primitiveValue());
      }
      this.designations.add(new Token(v[0], v[1]));
      focus.getExpansion().addParameter().setName(name).setValue(new StringType(value.primitiveValue()));
    }
    if ("offset".equals(name) && value instanceof IntegerType) {
      focus.getExpansion().getParameter().removeIf(p -> p.getName().equals(name));
      focus.getExpansion().addParameter().setName(name).setValue(value);
      dwc.setOffsetParam(((IntegerType) value).getValue());
      if (dwc.getOffsetParam() < 0) {
        dwc.setOffsetParam(0);
      }
    }
    if ("count".equals(name)) {
      focus.getExpansion().getParameter().removeIf(p -> p.getName().equals(name));
      focus.getExpansion().addParameter().setName(name).setValue(value);
      dwc.setCountParam(((IntegerType) value).getValue());
      if (dwc.getCountParam() < 0) {
        dwc.setCountParam(0);
      }
    }
  }
  
  public ValueSetExpansionOutcome doExpand(ValueSet source, Parameters expParams) throws FHIRException, OperationIsTooCostly, FileNotFoundException, IOException, CodeSystemProviderExtension {
    if (expParams == null)
      expParams = makeDefaultExpansion();
    altCodeParams.seeParameters(expParams);
    altCodeParams.seeValueSet(source);
    source.checkNoModifiers("ValueSet", "expanding");
    focus = source.copy();
    focus.setIdBase(null);
    focus.setExpansion(new ValueSet.ValueSetExpansionComponent());
    focus.getExpansion().setTimestampElement(DateTimeType.now());
    focus.getExpansion().setIdentifier(Factory.createUUID()); 
    checkCanonical(focus.getExpansion(), focus, focus);
    for (Extension ext : focus.getCompose().getExtensionsByUrl(ExtensionDefinitions.EXT_VS_EXP_PARAM_NEW, ExtensionDefinitions.EXT_VS_EXP_PARAM_OLD)) {
      processParameter(ext.getExtensionString("name"), ext.getExtensionByUrl("value").getValue());
    }
    for (ParametersParameterComponent p : expParams.getParameter()) {
      processParameter(p.getName(), p.getValue());
    }
    for (Extension s : focus.getExtensionsByUrl(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED)) {
      requiredSupplements.add(s.getValue().primitiveValue());
    }
    if (langs == null && focus.hasLanguage()) {
      langs = new AcceptLanguageHeader(focus.getLanguage(), true);
    }

    try {
      if (source.hasCompose()) {
//        ExtensionsUtils.stripExtensions(focus.getCompose()); - disabled 23/05/2023 GDG - why was this ever thought to be a good idea?
        handleCompose(source.getCompose(), focus.getExpansion(), expParams, source.getUrl(), focus.getExpansion().getExtension(), source);
      }
    } catch (EFinished e) {
      // nothing - we intended to trap this here
    }

    if (dwc.getCount() > maxExpansionSize && dwc.getOffsetParam() + dwc.getCountParam() == 0) {
      if (dwc.isNoTotal()) {
        throw failAsTooCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY, focus.getVersionedUrl(), ">" + MessageFormat.format("{0,number,#}", maxExpansionSize)));
      } else {
        throw failAsTooCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY_COUNT, focus.getVersionedUrl(), ">" + MessageFormat.format("{0,number,#}", maxExpansionSize), MessageFormat.format("{0,number,#}", dwc.getCount())));
      }
    } else if (dwc.isCanBeHierarchy() && ((dwc.getCountParam() == 0) || dwc.getCountParam() > dwc.getCodes().size())) {
      for (ValueSetExpansionContainsComponent c : dwc.getRoots()) {
        focus.getExpansion().getContains().add(c);
      }
    } else {
      int i = 0;
      int cc = 0;
      for (ValueSetExpansionContainsComponent c : dwc.getCodes()) {
        c.getContains().clear(); // make sure any hierarchy is wiped
        if (dwc.getMap().containsKey(key(c)) && (includeAbstract || !c.getAbstract())) { // we may have added abstract codes earlier while we still thought it might be heirarchical, but later we gave up, so now ignore them
          if (dwc.getOffsetParam() == 0 || i >= dwc.getOffsetParam()) {
            focus.getExpansion().getContains().add(c);
            cc++;
            if (cc == dwc.getCountParam()) {
              break;
            }
          }
          i++;
        }
      }
    }
    if (!reportingOnVersionsInContains) {
      stripVersions(focus.getExpansion().getContains());
    }

    if (dwc.hasOffsetParam()) {
      focus.getExpansion().setOffset(dwc.getOffsetParam());
    }
    if (!dwc.isNoTotal()) {
      focus.getExpansion().setTotal(dwc.getStatedTotal());
    }
    if (!requiredSupplements.isEmpty()) {      
      return new ValueSetExpansionOutcome(context.formatMessagePlural(requiredSupplements.size(), I18nConstants.VALUESET_SUPPLEMENT_MISSING, CommaSeparatedStringBuilder.build(requiredSupplements)), TerminologyServiceErrorClass.BUSINESS_RULE, allErrors, false);
    }
    if (!expParams.hasParameter("includeDefinition") || !expParams.getParameterBool("includeDefinition")) {
      focus.setCompose(null);
      focus.getExtension().clear();
      focus.setPublisher(null);
      focus.setDescription(null);
      focus.setPurpose(null);
      focus.getContact().clear();
      focus.setCopyright(null);
      focus.setText(null);
    }
    return new ValueSetExpansionOutcome(focus);
  }

  private void stripVersions(List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent c : contains) {
      c.setVersion(null);
      stripVersions(c.getContains());
    }
  }


  private Parameters makeDefaultExpansion() {
    Parameters res = new Parameters();
    res.addParameter("excludeNested", true);
    res.addParameter("includeDesignations", false);
    return res;
  }

  private ConceptDefinitionComponent getConceptForCode(List<ConceptDefinitionComponent> clist, String code) {
    for (ConceptDefinitionComponent c : clist) {
      if (code.equals(c.getCode()))
        return c;
      ConceptDefinitionComponent v = getConceptForCode(c.getConcept(), code);
      if (v != null)
        return v;
    }
    return null;
  }

  private void handleCompose(ValueSetComposeComponent compose, ValueSetExpansionComponent exp, Parameters expParams, String ctxt, List<Extension> extensions, ValueSet valueSet)
      throws OperationIsTooCostly, FileNotFoundException, IOException, FHIRException, CodeSystemProviderExtension {
    compose.checkNoModifiers("ValueSet.compose", "expanding");
    String vspath = "ValueSet["+valueSet.getVersionedUrl()+"].compose";

    // scan first to see if we need to report versions
    reportingOnVersionsInContains = checkForDifferingVersions(compose);

    // Exclude comes first because we build up a map of things to exclude
    int c = 0;
    for (ConceptSetComponent inc : compose.getExclude()) {
      excludeCodes(dwc, inc, expParams, exp, valueSet, vspath+".include["+c+"]");
      c++;
    }
    dwc.setCanBeHierarchy(!expParams.getParameterBool("excludeNested") && dwc.getExcludeKeys().isEmpty() && dwc.getExcludeSystems().isEmpty() && dwc.getOffsetParam() == 0);
    includeAbstract = !expParams.getParameterBool("excludeNotForUI");
    boolean first = true;
    c = 0;
    for (ConceptSetComponent inc : compose.getInclude()) {
      if (first == true)
        first = false;
      else
        dwc.setCanBeHierarchy(false);
      includeCodes(inc, exp, expParams, dwc.isCanBeHierarchy(), compose.hasInactive() ? !compose.getInactive() : checkNoInActiveFromParam(expParams), extensions, valueSet, vspath+".include["+c+"]");
      c++;
    }
  }

  private boolean checkForDifferingVersions(ValueSetComposeComponent compose) {
    Map<String, String> vlist = new HashMap<>();
    for (ConceptSetComponent inc : compose.getExclude()) {
      if (checkForVersionDuplicates(vlist, inc)) {
        return true;
      }
    }
    for (ConceptSetComponent inc : compose.getInclude()) {
      if (checkForVersionDuplicates(vlist, inc)) {
        return true;
      }
    }
    return false;
  }

  private boolean checkForVersionDuplicates(Map<String, String> vlist, ConceptSetComponent inc) {
    if (vlist.containsKey(inc.getSystem())) {
      String v = vlist.get(inc.getSystem());
      if ((v == null && inc.getVersion() != null) || (v != null && !v.equals(inc.getVersion()))) {
        return true;
      }
    } else {
      vlist.put(inc.getSystem(), inc.getVersion());
    }
    return false;
  }

  /**
   * returns true if activeOnly = true 
   * @param expParams
   * @return
   */
  private boolean checkNoInActiveFromParam(Parameters expParams) {
    for (ParametersParameterComponent p : expParams.getParameter()) {
      if (p.getName().equals("activeOnly")) {
        return p.getValueBooleanType().getValue();
      }
    }
    return false;
  }

  private ValueSet importValueSet(WorkingContext wc, String value, ValueSetExpansionComponent exp, Parameters expParams, boolean noInactive, ValueSet valueSet) throws OperationIsTooCostly, TerminologyServiceException, FileNotFoundException, IOException, FHIRFormatError {
    if (value == null)
      throw fail(I18nConstants.VS_EXP_IMPORT_NULL);
    String url = getCu().pinValueSet(value, expParams);
    ValueSet vs = context.findTxResource(ValueSet.class, url, null, valueSet);
    if (vs == null) {
      boolean pinned = !url.equals(value);
      String ver = pinned ? url.substring(value.length()+1) : null;
      if (context.fetchResource(CodeSystem.class, url, null, valueSet) != null) {
        throw failWithUnknownVSException(pinned ? I18nConstants.VS_EXP_IMPORT_CS_PINNED : I18nConstants.VS_EXP_IMPORT_CS, true, value, ver);
      } else  {
        throw failWithUnknownVSException(pinned ? I18nConstants.VS_EXP_IMPORT_UNK_PINNED : I18nConstants.VS_EXP_IMPORT_UNK, true, value, ver);
      }
    }
    checkCanonical(exp, vs, focus);
    if (noInactive) {
      expParams = expParams.copy();
      expParams.addParameter("activeOnly", true);
    }
    ValueSetExpander expander = new ValueSetExpander(context, opContext.copy(), allErrors);
    ValueSetExpansionOutcome vso = expander.expand(vs, expParams);
    if (vso.getError() != null) {
      addErrors(vso.getAllErrors());
      if (vso.getErrorClass() == TerminologyServiceErrorClass.VALUESET_UNKNOWN) {  
        throw failWithUnknownVSException(I18nConstants.VS_EXP_IMPORT_ERROR, true, vs.getUrl(), vso.getError());
      } else {
        throw fail(I18nConstants.VS_EXP_IMPORT_ERROR, vs.getUrl(), vso.getError());
      }
    } else if (vso.getValueset() == null) {
      throw fail(I18nConstants.VS_EXP_IMPORT_FAIL, vs.getUrl());
    }
    sources.addAll(expander.sources);
    if (vs.hasVersion() || REPORT_VERSION_ANYWAY) {
      UriType u = new UriType(vs.getUrl() + (vs.hasVersion() ? "|"+vs.getVersion() : ""));
      if (!existsInParams(exp.getParameter(), "used-valueset", u))
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("used-valueset").setValue(u));
    }
    ValueSetExpansionComponent evs = vso.getValueset().getExpansion();
    for (Extension ex : evs.getExtension()) {
      if (ex.getUrl().equals(ExtensionDefinitions.EXT_EXP_TOOCOSTLY)) {
        if (ex.getValue() instanceof BooleanType) {
          exp.getExtension().add(new Extension(ExtensionDefinitions.EXT_EXP_TOOCOSTLY).setValue(new CanonicalType(value)));
        } else {
          exp.getExtension().add(ex);
        }
      } 
    }
    if (!evs.hasTotal()) {
      // because if there's no total, we can't know if we got everything
      dwc.setNoTotal(true);
    }
    for (ValueSetExpansionParameterComponent p : evs.getParameter()) {
      if (!existsInParams(exp.getParameter(), p.getName(), p.getValue()))
        exp.getParameter().add(p);
    }
    if (isValueSetUnionImports(valueSet)) {
      copyExpansion(wc, evs.getContains());
    }
    wc.setCanBeHierarchy(false); // if we're importing a value set, we have to be combining, so we won't try for a hierarchy
    return vso.getValueset();
  }
  


  private ValueSet importValueSetForExclude(WorkingContext wc, String value, ValueSetExpansionComponent exp, Parameters expParams, boolean noInactive, ValueSet valueSet) throws OperationIsTooCostly, TerminologyServiceException, FileNotFoundException, IOException, FHIRFormatError {
    if (value == null)
      throw fail(I18nConstants.VS_EXP_IMPORT_NULL_X);
    String url = getCu().pinValueSet(value, expParams);
    ValueSet vs = context.findTxResource(ValueSet.class, url, null, valueSet);
    if (vs == null) {
      boolean pinned = !url.equals(value);
      String ver = pinned ? url.substring(value.length()+1) : null;
      if (context.fetchResource(CodeSystem.class, url, null, valueSet) != null) {
        throw fail(pinned ? I18nConstants.VS_EXP_IMPORT_CS_PINNED_X : I18nConstants.VS_EXP_IMPORT_CS_X, value, ver);
      } else  {
        throw fail(pinned ? I18nConstants.VS_EXP_IMPORT_UNK_PINNED_X : I18nConstants.VS_EXP_IMPORT_UNK_X, value, ver);
      }
    }
    checkCanonical(exp, vs, focus);
    if (noInactive) {
      expParams = expParams.copy();
      expParams.addParameter("activeOnly", true);
    }
    ValueSetExpander expander = new ValueSetExpander(context, opContext.copy(), allErrors);
    ValueSetExpansionOutcome vso = expander.expand(vs, expParams);
    sources.addAll(expander.sources);
    if (vso.getError() != null) {
      addErrors(vso.getAllErrors());
      throw fail(I18nConstants.VS_EXP_IMPORT_ERROR_X, vs.getUrl(), vso.getError());
    } else if (vso.getValueset() == null) {
      throw fail(I18nConstants.VS_EXP_IMPORT_FAIL_X, vs.getUrl());
    }
    
    if (vs.hasVersion() || REPORT_VERSION_ANYWAY) {
      UriType u = new UriType(vs.getUrl() + (vs.hasVersion() ? "|"+vs.getVersion() : ""));
      if (!existsInParams(exp.getParameter(), "used-valueset", u))
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("used-valueset").setValue(u));
    }
    for (Extension ex : vso.getValueset().getExpansion().getExtension()) {
      if (ex.getUrl().equals(ExtensionDefinitions.EXT_EXP_TOOCOSTLY)) {
        throw fail(VS_EXP_IMPORT_ERROR_TOO_COSTLY, vs.getUrl());
      } 
    }
    return vso.getValueset();
  }
  
  protected boolean isValueSetUnionImports(ValueSet valueSet) {
    PackageInformation p = valueSet.getSourcePackage();
    if (p != null) {
      return p.getDate().before(new GregorianCalendar(2022, Calendar.MARCH, 31).getTime());
    } else {
      return false;
    }
  }

  public void copyExpansion(WorkingContext wc,List<ValueSetExpansionContainsComponent> list) {
    opContext.deadCheck("copyExpansion");
    for (ValueSetExpansionContainsComponent cc : list) {
       ValueSetExpansionContainsComponent n = new ValueSet.ValueSetExpansionContainsComponent();
       n.setSystem(cc.getSystem());
       n.setCode(cc.getCode());
       n.setAbstract(cc.getAbstract());
       n.setInactive(cc.getInactive());
       n.setDisplay(cc.getDisplay());
       n.getDesignation().addAll(cc.getDesignation());

       String s = key(n);
       if (!wc.getMap().containsKey(s) && !wc.getExcludeKeys().contains(s)) {
         wc.getCodes().add(n);
         wc.getMap().put(s, n);
       }
       copyExpansion(wc, cc.getContains());
    }
  }

  private void addErrors(List<String> errs) {
    for (String s : errs) {
      if (!allErrors.contains(s)) {
        allErrors.add(s);
      }
    }
  }

  private int copyImportContains(List<ValueSetExpansionContainsComponent> list, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filter, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc, ValueSetExpansionComponent exp) throws FHIRException, OperationIsTooCostly {
    int count = 0;
    opContext.deadCheck("copyImportContains");
    
    String lang = vsSrc.getLanguage();
    if (lang == null) { 
      lang = findParamValue(vsSrc.getExpansion().getParameter(), "displayLanguage");
    }
    for (ValueSetExpansionContainsComponent c : list) {
      c.checkNoModifiers("Imported Expansion in Code System", "expanding");
      String vstatus = determineStatus(vsSrc, c);
      ValueSetExpansionContainsComponent np = addCode(dwc, c.getSystem(), c.getVersion(), c.getCode(), c.getDisplay(), lang, parent, translateDesignations(c), expParams,
            c.getAbstract(), c.getInactive(), filter, noInactive, false, vsProps, makeCSProps(c.getExtensionString(ExtensionDefinitions.EXT_DEFINITION), null),
        null, c.getProperty(), null, c.getExtension(), exp, vstatus);
      if (np != null) {
        count++;
      }
      count = count + copyImportContains(c.getContains(), np, expParams, filter, noInactive, vsProps, vsSrc, exp);
    }
    return count;
  }

  private List<ConceptDefinitionDesignationComponent> translateDesignations(ValueSetExpansionContainsComponent c) {
    if (!c.hasDesignation()) {
      return null;
    }
    List<ConceptDefinitionDesignationComponent> list = new ArrayList<>();
    for (ConceptReferenceDesignationComponent d : c.getDesignation()) {
      ConceptDefinitionDesignationComponent d2 = new ConceptDefinitionDesignationComponent();
      d2.setLanguage(d.getLanguage());
      d2.setUse(d.getUse());
      d2.setAdditionalUse(d.getAdditionalUse());
      d2.setValue(d.getValue());
      list.add(d2);
    }
    return list;
  }

  private void includeCodes(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, boolean heirarchical, boolean noInactive, List<Extension> extensions, ValueSet valueSet, String vspath) throws OperationIsTooCostly, FileNotFoundException, IOException, FHIRException, CodeSystemProviderExtension {
    opContext.deadCheck("includeCodes");
    inc.checkNoModifiers("Compose.include", "expanding");
    List<ValueSet> imports = new ArrayList<ValueSet>();
    for (CanonicalType imp : inc.getValueSet()) {
      imports.add(importValueSet(dwc, imp.getValue(), exp, expParams, noInactive, valueSet));
    }

    if (!inc.hasSystem()) {
      if (imports.isEmpty()) // though this is not supposed to be the case
        return;
      ValueSet base = imports.get(0);
      checkCanonical(exp, base, focus);
      imports.remove(0);
      base.checkNoModifiers("Imported ValueSet", "expanding");
      copyImportContains(base.getExpansion().getContains(), null, expParams, imports, noInactive, base.getExpansion().getProperty(), base, exp);
    } else {
      String sv = inc.getSystem()+(inc.hasVersion() ? "#"+inc.getVersion(): "");
      if (dwc.getCountIncompleteSystems().contains(sv)) {
        dwc.setNoTotal(true);
      }
      String version = determineVersion(inc.getSystem(), inc.getVersion(), exp, expParams);
      CodeSystem cs = context.fetchSupplementedCodeSystem(inc.getSystem(), version, valueSet);
      if (cs != null) {
        checkVersion(inc.getSystem(), cs.getVersion(), exp, expParams);
      }
      if (cs == null && noTerminologyServer) {
        if (version == null) {
          throw failWithIssue(IssueType.NOTFOUND, OpIssueCode.NotFound, null, I18nConstants.UNKNOWN_CODESYSTEM_EXP, inc.getSystem());
        } else {
          List<CodeSystem> list = context.fetchResourceVersions(CodeSystem.class, inc.getSystem());
          if (list.size() == 0) {
            throw failWithIssue(IssueType.NOTFOUND, OpIssueCode.NotFound, null, I18nConstants.UNKNOWN_CODESYSTEM_VERSION_EXP_NONE, inc.getSystem(), version);
          } else {
            List<String> versions = new ArrayList<>();
            for (CodeSystem c : list) {
              versions.add(c.getVersion());
            }
            Collections.sort(versions);
            throw failWithIssue(IssueType.NOTFOUND, OpIssueCode.NotFound, null, I18nConstants.UNKNOWN_CODESYSTEM_VERSION_EXP, inc.getSystem(), version, CommaSeparatedStringBuilder.join(",", versions));
          }
        }
      } else if (ValueSetUtilities.isServerSide(inc.getSystem()) || (cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT))) {
        doServerIncludeCodes(inc, heirarchical, exp, imports, expParams, extensions, noInactive, valueSet.getExpansion().getProperty());
      } else {
        if (cs.hasUserData(UserDataNames.tx_known_supplements)) {
          for (String s : cs.getUserString(UserDataNames.tx_known_supplements).split("\\,")) {
            requiredSupplements.remove(s);
          }
        }
        if (!requiredSupplements.isEmpty()) {
          List<CodeSystem> additionalSupplements = new ArrayList<>();
          for (String s : requiredSupplements) {
            CodeSystem scs = context.findTxResource(CodeSystem.class, s);
            if (scs != null && cs.getUrl().equals(scs.getSupplements())) {
              additionalSupplements.add(scs);
            }
          }
          if (!additionalSupplements.isEmpty()) {
            cs = CodeSystemUtilities.mergeSupplements(cs, additionalSupplements);
          }
        }
        doInternalIncludeCodes(inc, exp, expParams, imports, cs, noInactive, valueSet, vspath);
      }
    }
  }

  private String determineVersion(@Nonnull String system, @Nonnull String version, @Nonnull ValueSetExpansionComponent exp, @Nonnull Parameters expParams) {
    String result = version;
    List<ParametersParameterComponent> rules = new ArrayList<>();
    for (ParametersParameterComponent p : expParams.getParameter()) {
      if ("force-system-version".equalsIgnoreCase(p.getName()) && p.getValue().primitiveValue() != null && p.getValue().primitiveValue().startsWith(system+"|")) {
        rules.add(p);
      }
      if ("system-version".equalsIgnoreCase(p.getName()) && p.getValue().primitiveValue() != null && p.getValue().primitiveValue().startsWith(system+"|")) {
        rules.add(p);
      }
      if ("check-system-version".equalsIgnoreCase(p.getName()) && p.getValue().primitiveValue() != null && p.getValue().primitiveValue().startsWith(system+"|")) {
        rules.add(p);
      }
    }
    boolean b = false;
    for (ParametersParameterComponent t : rules) {
      if ("force-system-version".equals(t.getName())) {
        String tv = t.getValue().primitiveValue().substring(system.length() + 1);
        if (!b) {
          result = tv;
          if (!hasParam(exp, t.getName(), t.getValue().primitiveValue())) {
            exp.addParameter(t.getName(), new UriType(t.getValue().primitiveValue()));
          }
        } else if (!tv.equals(result)) {
          throw failWithIssue(IssueType.EXCEPTION, OpIssueCode.VersionError, null, I18nConstants.SYSTEM_VERSION_MULTIPLE_OVERRIDE, system, result, tv);
        }
      }
    }
    if (Utilities.noString(result)) {
      b = false;
      for (ParametersParameterComponent t : rules) {
        if ("system-version".equals(t.getName())) {
          String tv = t.getValue().primitiveValue().substring(system.length() + 1);
          if (!b) {
            result = tv;
            if (!hasParam(exp, t.getName(), t.getValue().primitiveValue())) {
              exp.addParameter(t.getName(), new UriType(t.getValue().primitiveValue()));
            }
          } else if (!tv.equals(result)) {
            throw failWithIssue(IssueType.EXCEPTION, OpIssueCode.VersionError, null, I18nConstants.SYSTEM_VERSION_MULTIPLE_DEFAULT, system, result, tv);
          }
        }
      }
    }
    for (ParametersParameterComponent t : rules) {
      if ("check-system-version".equals(t.getName())) {
        String tv = t.getValue().primitiveValue().substring(system.length() + 1);
        if (Utilities.noString(result)) {
          result = tv;
          if (!hasParam(exp, t.getName(), t.getValue().primitiveValue())) {
            exp.addParameter(t.getName(), new UriType(t.getValue().primitiveValue()));
          }
        }
      }
    }
    return result;
  }

  private void checkVersion(@Nonnull String system, @Nonnull String version, @Nonnull ValueSetExpansionComponent exp, @Nonnull Parameters expParams) {
    String result = version;
    List<ParametersParameterComponent> rules = new ArrayList<>();
    for (ParametersParameterComponent p : expParams.getParameter()) {
      if ("check-system-version".equalsIgnoreCase(p.getName()) && p.getValue().primitiveValue() != null && p.getValue().primitiveValue().startsWith(system+"|")) {
        rules.add(p);
      }
    }
    for (ParametersParameterComponent t : rules) {
      String tv = t.getValue().primitiveValue().substring(system.length() + 1);
      if (Utilities.noString(result)) {
        result = tv;
        if (!hasParam(exp, t.getName(), t.getValue().primitiveValue())) {
          exp.addParameter(t.getName(), new UriType(t.getValue().primitiveValue()));
        }
      } else if (!versionsMatch(system, result, tv)) {
        throw failWithIssue(IssueType.EXCEPTION, OpIssueCode.VersionError, null, I18nConstants.VALUESET_VERSION_CHECK, system, result, tv);
      }
    }
  }

  private boolean hasParam(ValueSetExpansionComponent exp, String name, String s) {
    for (ValueSetExpansionParameterComponent t : exp.getParameter()) {
      if (t.getName().equals(name) && t.getValue().primitiveValue() != null && t.getValue().primitiveValue().equals(s)) {
        return true;
      }
    }
    return false;
  }

  private void doServerIncludeCodes(ConceptSetComponent inc, boolean heirarchical, ValueSetExpansionComponent exp, List<ValueSet> imports, Parameters expParams, List<Extension> extensions, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps) throws FHIRException, CodeSystemProviderExtension, OperationIsTooCostly {
    opContext.deadCheck("doServerIncludeCodes");
    CodeSystemProvider csp = CodeSystemProvider.factory(inc.getSystem());
    if (csp != null) {
      csp.includeCodes(inc, heirarchical, exp, imports, expParams, extensions, noInactive, vsProps);
      return;
    }
    
    ValueSetExpansionOutcome vso = context.expandVS(new TerminologyOperationDetails(requiredSupplements), inc, heirarchical, noInactive);
    if (vso.getError() != null) {
      throw failTSE("Unable to expand imported value set: " + vso.getError());
    }
    ValueSet vs = vso.getValueset();
    if (vs.hasUserData(UserDataNames.VS_EXPANSION_SOURCE)) {
      sources.add(vs.getUserString(UserDataNames.VS_EXPANSION_SOURCE));
    }
    if (vs.hasVersion() || REPORT_VERSION_ANYWAY) {
      UriType u = new UriType(vs.getUrl() + (vs.hasVersion() ? "|"+vs.getVersion() : ""));
      if (!existsInParams(exp.getParameter(), "used-valueset", u)) {
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("used-valueset").setValue(u));
      }
    }
    if (vs.getExpansion().hasTotal()) {
      dwc.incExtraCount(vs.getExpansion().getTotal() - countContains(vs.getExpansion().getContains()));
      dwc.getCountIncompleteSystems().add(inc.getSystem()+(inc.hasVersion() ? "#"+inc.getVersion(): ""));
    } else {
      dwc.setNoTotal(true);
    }
    for (ValueSetExpansionParameterComponent p : vso.getValueset().getExpansion().getParameter()) {
      if (!existsInParams(exp.getParameter(), p.getName(), p.getValue())) {
        exp.getParameter().add(p);
      }
    }
    for (Extension ex : vs.getExpansion().getExtension()) {
      if (Utilities.existsInList(ex.getUrl(), ExtensionDefinitions.EXT_EXP_TOOCOSTLY, "http://hl7.org/fhir/StructureDefinition/valueset-unclosed")) {
        if (!ExtensionUtilities.hasExtension(extensions, ex.getUrl())) {
          extensions.add(ex);
        }
      }
    }
    for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContains()) {
      addCodeAndDescendents(dwc, cc, null, expParams, imports, noInactive, vsProps, vs, exp, getLang(vs));
    }
  }


  private int countContains(List<ValueSetExpansionContainsComponent> contains) {
    int count = contains.size();
    for (ValueSetExpansionContainsComponent cc : contains) {
      if (cc.hasContains()) {
        count += countContains(cc.getContains());
      }
    }
    return count;
  }

  public void doInternalIncludeCodes(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, List<ValueSet> imports, CodeSystem cs, boolean noInactive, Resource vsSrc, String vspath) throws NoTerminologyServiceException, TerminologyServiceException, FHIRException, OperationIsTooCostly {
    opContext.deadCheck("doInternalIncludeCodes");
    if (cs == null) {
      if (context.isNoTerminologyServer())
        throw failTSE("Unable to find code system " + inc.getSystem().toString());
      else
        throw failTSE("Unable to find code system " + inc.getSystem().toString());
    }
    checkCanonical(exp, cs, focus);
    cs.checkNoModifiers("Code System", "expanding");
    if (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT)
      throw failTSE("Code system " + inc.getSystem().toString() + " is incomplete");
    if (cs.hasVersion() || REPORT_VERSION_ANYWAY) {
      UriType u = new UriType(cs.getUrl() + (cs.hasVersion() ? "|"+cs.getVersion() : ""));
      if (!existsInParams(exp.getParameter(), "used-codesystem", u))
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("used-codesystem").setValue(u));
      if (cs.hasUserData(UserDataNames.tx_known_supplements)) {
        for (String s : cs.getUserString(UserDataNames.tx_known_supplements).split("\\,")) {
          u = new UriType(s);
          if (!existsInParams(exp.getParameter(), "used-supplement", u)) {
            exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("used-supplement").setValue(u));
          }
        }
      }
    }
    if (inc.getConcept().size() == 0 && inc.getFilter().size() == 0) {
      // special case - add all the code system
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        addCodeAndDescendents(dwc, cs, inc.getSystem(), cs.getVersion(), def, null, expParams, imports, null, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), null, exp);
      }
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        addFragmentWarning(exp, cs);
      }
      if (cs.getContent() == CodeSystemContentMode.EXAMPLE) {
        addExampleWarning(exp, cs);
      }      
    }

    if (!inc.getConcept().isEmpty()) {
      dwc.setCanBeHierarchy(false);
      for (ConceptReferenceComponent c : inc.getConcept()) {
        c.checkNoModifiers("Code in Value Set", "expanding");
        ConceptDefinitionComponent def = CodeSystemUtilities.findCodeOrAltCode(cs.getConcept(), c.getCode(), null);
        boolean inactive = false; // default is true if we're a fragment and  
        boolean isAbstract = false;
        if (def == null) {
          if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
            addFragmentWarning(exp, cs);
          } else if (cs.getContent() == CodeSystemContentMode.EXAMPLE) {
              addExampleWarning(exp, cs);
          } else {
            if (checkCodesWhenExpanding) {
              throw failTSE("Unable to find code '" + c.getCode() + "' in code system " + cs.getUrl());
            }
          }
        } else {
          def.checkNoModifiers("Code in Code System", "expanding");
          inactive = CodeSystemUtilities.isInactive(cs, def);
          isAbstract = CodeSystemUtilities.isNotSelectable(cs, def);
          String vstatus = determineStatus(cs, def);
          addCode(dwc, inc.getSystem(), cs.getVersion(), c.getCode(), !Utilities.noString(c.getDisplay()) ? c.getDisplay() : def.getDisplay(), c.hasDisplay() ? vsSrc.getLanguage() : cs.getLanguage(),
            null, mergeDesignations(def, convertDesignations(c.getDesignation())), expParams, isAbstract, inactive, imports, noInactive, false,
            exp.getProperty(), makeCSProps(def.getDefinition(), def.getProperty()), cs, null, def.getExtension(), c.getExtension(), exp, vstatus);
        }
      }
    }
    if (inc.getFilter().size() > 0) {
      if (inc.getFilter().size() > 1) {
        dwc.setCanBeHierarchy(false); // which will be the case if we get around to supporting this
      }
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        addFragmentWarning(exp, cs);
      }
      List<WorkingContext> filters = new ArrayList<>();
      for (int i = 1; i < inc.getFilter().size(); i++) {
        WorkingContext wc = new WorkingContext();
        filters.add(wc);
        processFilter(inc, exp, expParams, imports, cs, noInactive, inc.getFilter().get(i), wc, null, false, vspath+".filter["+i+"]");
      }
      ConceptSetFilterComponent fc = inc.getFilter().get(0);
      WorkingContext wc = dwc;
      processFilter(inc, exp, expParams, imports, cs, noInactive, fc, wc, filters, false, vspath+".filter[0]");
    }
  }

  private void processFilter(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, List<ValueSet> imports, CodeSystem cs, boolean noInactive, 
      ConceptSetFilterComponent fc, WorkingContext wc, List<WorkingContext> filters, boolean exclude, String vspath)
      throws OperationIsTooCostly {
    
    if (!fc.hasValue() || fc.getValue() == null) {
      List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
      issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, vspath+".value", context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM_FILTER_WITH_NO_VALUE,
        cs.getUrl(), fc.getProperty(), fc.getOp().toCode()), OpIssueCode.VSProcessing, null, I18nConstants.UNABLE_TO_HANDLE_SYSTEM_FILTER_WITH_NO_VALUE));
      throw new VSCheckerException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM_FILTER_WITH_NO_VALUE, cs.getUrl(), fc.getProperty(), fc.getOp().toCode()), issues, TerminologyServiceErrorClass.INTERNAL_ERROR);
    }
    opContext.deadCheck("processFilter");
    if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.ISA) {
      // special: all codes in the target code system under the value
      ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
      if (def == null)
        throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
      if (exclude) {
        excludeCodeAndDescendents(wc, cs, inc.getSystem(), def, null, imports, null, new AllConceptsFilter(allErrors), filters, exp);
      } else {
        addCodeAndDescendents(wc, cs, inc.getSystem(), cs.getVersion(), def, null, expParams, imports, null, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), filters, exp);
      }
    } else if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.ISNOTA) {
      // special: all codes in the target code system that are not under the value
      ConceptDefinitionComponent defEx = getConceptForCode(cs.getConcept(), fc.getValue());
      if (defEx == null)
        throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        if (exclude) {
          excludeCodeAndDescendents(wc, cs, inc.getSystem(), def, null, imports, defEx, new AllConceptsFilter(allErrors), filters, exp);
        } else {
          addCodeAndDescendents(wc, cs, inc.getSystem(), cs.getVersion(), def, null, expParams, imports, defEx, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), filters, exp);
        }
      }
    } else if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.DESCENDENTOF) {
      // special: all codes in the target code system under the value
      ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
      if (def == null)
        throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
      for (ConceptDefinitionComponent c : def.getConcept())
        if (exclude) {
          excludeCodeAndDescendents(wc, cs, inc.getSystem(), c, null, imports, null, new AllConceptsFilter(allErrors), filters, exp);
        } else {
          addCodeAndDescendents(wc, cs, inc.getSystem(), cs.getVersion(), c, null, expParams, imports, null, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), filters, exp);
        }
      if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
        List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
        for (ConceptDefinitionComponent c : children) {
          if (exclude) {
            excludeCodeAndDescendents(wc, cs, inc.getSystem(), c, null, imports, null, new AllConceptsFilter(allErrors), filters, exp);
          } else {
            addCodeAndDescendents(wc, cs, inc.getSystem(), cs.getVersion(), c, null, expParams, imports, null, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), filters, exp);
          }
        }
      }

    } else if ("display".equals(fc.getProperty()) && fc.getOp() == FilterOperator.EQUAL) {
      // gg; note: wtf is this: if the filter is display=v, look up the code 'v', and see if it's display is 'v'?
      dwc.setCanBeHierarchy(false);
      ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
      if (def != null) {
        if (isNotBlank(def.getDisplay()) && isNotBlank(fc.getValue())) {
          if (def.getDisplay().contains(fc.getValue()) && passesOtherFilters(filters, cs, def.getCode())) {
            for (String code : getCodesForConcept(def, expParams)) {
              opContext.deadCheck("processFilter2");
              if (exclude) {
                excludeCode(wc, inc.getSystem(), code);
              } else {
                String vstatus = determineStatus(cs, def);
                addCode(wc, inc.getSystem(), inc.getVersion(), code, def.getDisplay(), cs.getLanguage(), null, def.getDesignation(), expParams, CodeSystemUtilities.isNotSelectable(cs, def), CodeSystemUtilities.isInactive(cs, def),
                  imports, noInactive, false, exp.getProperty(), makeCSProps(def.getDefinition(), def.getProperty()), cs, null, def.getExtension(), null, exp, vstatus);
              }
            }
          }
        }
      }
    } else if (CodeSystemUtilities.isDefinedProperty(cs, fc.getProperty())) {
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        PropertyFilter pf = new PropertyFilter(allErrors, fc, CodeSystemUtilities.getPropertyDefinition(cs, fc.getProperty()));
        if (exclude) {
          excludeCodeAndDescendents(wc, cs, inc.getSystem(), def, null, imports, null, pf, filters, exp);
        } else {
          addCodeAndDescendents(wc, cs, inc.getSystem(), cs.getVersion(), def, null, expParams, imports, null, pf, noInactive, exp.getProperty(), filters, exp);
        }
      }
    } else if (isKnownProperty(fc.getProperty(), cs)) {
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        KnownPropertyFilter pf = new KnownPropertyFilter(allErrors, fc, fc.getProperty());
        if (exclude) {
          excludeCodeAndDescendents(wc, cs, inc.getSystem(), def, null, imports, null, pf, filters, exp);
        } else {
          addCodeAndDescendents(wc, cs, inc.getSystem(), cs.getVersion(), def, null, expParams, imports, null, pf, noInactive, exp.getProperty(), filters, exp);
        }
      }
    } else if ("code".equals(fc.getProperty()) && fc.getOp() == FilterOperator.REGEX) {
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        if (exclude) {
          excludeCodeAndDescendents(wc, cs, inc.getSystem(), def, null, imports, null, new RegexFilter(allErrors, fc.getValue()), filters, exp);
        } else {
          addCodeAndDescendents(wc, cs, inc.getSystem(), cs.getVersion(), def, null, expParams, imports, null, new RegexFilter(allErrors, fc.getValue()), noInactive, exp.getProperty(), filters, exp);
        }
      }
    } else {
      throw fail(I18nConstants.VS_EXP_FILTER_UNK, true, focus.getVersionedUrl(), fc.getProperty(), fc.getOp());
    }
  }

  private boolean isKnownProperty(String property, CodeSystem cs) {
    return Utilities.existsInList(property, "notSelectable");
  }

  private List<ConceptDefinitionDesignationComponent> mergeDesignations(ConceptDefinitionComponent def,
      List<ConceptDefinitionDesignationComponent> list) {
    List<ConceptDefinitionDesignationComponent> res = new ArrayList<>();
    if (def != null) {
      res.addAll(def.getDesignation());
    }
    res.addAll(list);
    return res;
  }

 

  private void addFragmentWarning(ValueSetExpansionComponent exp, CodeSystem cs) {
    String url = cs.getVersionedUrl();
    for (ValueSetExpansionParameterComponent p : exp.getParameter()) {
      if ("fragment".equals(p.getName()) && p.hasValueUriType() && url.equals(p.getValue().primitiveValue())) { 
        return;
      }     
    }
    exp.addParameter().setName("fragment").setValue(new CanonicalType(url));
  }

  private void addExampleWarning(ValueSetExpansionComponent exp, CodeSystem cs) {
    String url = cs.getVersionedUrl();
    for (ValueSetExpansionParameterComponent p : exp.getParameter()) {
      if ("example".equals(p.getName()) && p.hasValueUriType() && url.equals(p.getValue().primitiveValue())) { 
        return;
      }     
    }
    exp.addParameter().setName("example").setValue(new CanonicalType(url));
  }
  
  private List<ConceptDefinitionDesignationComponent> convertDesignations(List<ConceptReferenceDesignationComponent> list) {
    List<ConceptDefinitionDesignationComponent> res = new ArrayList<CodeSystem.ConceptDefinitionDesignationComponent>();
    for (ConceptReferenceDesignationComponent t : list) {
      ConceptDefinitionDesignationComponent c = new ConceptDefinitionDesignationComponent();
      c.setLanguage(t.getLanguage());
      if (t.hasUse()) {
        c.setUse(t.getUse());
      }
      c.setValue(t.getValue());
      c.getExtension().addAll(t.getExtension());
      res.add(c);
    }
    return res;
  }

  private String key(String uri, String code) {
    return "{" + uri + "}" + code;
  }

  private String key(ValueSetExpansionContainsComponent c) {
    return key(c.getSystem(), c.getCode());
  }

  public boolean isCheckCodesWhenExpanding() {
    return checkCodesWhenExpanding;
  }

  public void setCheckCodesWhenExpanding(boolean checkCodesWhenExpanding) {
    this.checkCodesWhenExpanding = checkCodesWhenExpanding;
  }

  private boolean passesOtherFilters(List<WorkingContext> otherFilters, CodeSystem cs, String code) {
    if (otherFilters == null) {
      return true;
    }
    String key = key(cs.getUrl(), code);
    for (WorkingContext wc : otherFilters) {
      if (!wc.getMap().containsKey(key)) {
        return false;
      }
    }
    return true;
  }

  public boolean isDebug() {
    return debug;
  }

  public ValueSetExpander setDebug(boolean debug) {
    this.debug = debug;
    return this;
  }

  public String getSource() {
    if (sources.isEmpty()) {
      return "internal";
    } else {
      return CommaSeparatedStringBuilder.join(", ", Utilities.sorted(sources));
    }
  }
  
  
}