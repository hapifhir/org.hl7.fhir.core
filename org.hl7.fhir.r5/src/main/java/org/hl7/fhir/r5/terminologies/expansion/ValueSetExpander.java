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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.NoTerminologyServiceException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.LanguageUtils;
import org.hl7.fhir.r5.extensions.ExtensionConstants;
import org.hl7.fhir.r5.extensions.Extensions;
import org.hl7.fhir.r5.extensions.ExtensionsUtils;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.CanonicalType;
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
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpander.Token;
import org.hl7.fhir.r5.terminologies.providers.CodeSystemProvider;
import org.hl7.fhir.r5.terminologies.providers.CodeSystemProviderExtension;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValueSetProcessBase;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader.LanguagePreference;
import org.hl7.fhir.utilities.i18n.I18nConstants;

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
  
  private ValueSet focus;
  private List<String> allErrors = new ArrayList<>();
  private int maxExpansionSize = 1000;
  private WorkingContext dwc = new WorkingContext();
  
  private boolean checkCodesWhenExpanding;
  private boolean includeAbstract = true;

  private AcceptLanguageHeader langs;
  private List<Token> designations = new ArrayList<>();

  public ValueSetExpander(IWorkerContext context, TerminologyOperationContext opContext) {
    super(context, opContext);
  }

  public ValueSetExpander(IWorkerContext context, TerminologyOperationContext opContext, List<String> allErrors) {
    super(context, opContext);
    this.allErrors = allErrors;
  }

  public void setMaxExpansionSize(int theMaxExpansionSize) {
    maxExpansionSize = theMaxExpansionSize;
  }
  
  private ValueSetExpansionContainsComponent addCode(WorkingContext wc, String system, String code, String display, String dispLang, ValueSetExpansionContainsComponent parent, List<ConceptDefinitionDesignationComponent> designations, Parameters expParams, 
      boolean isAbstract, boolean inactive, List<ValueSet> filters, boolean noInactive, boolean deprecated, List<ValueSetExpansionPropertyComponent> vsProp, 
      List<ConceptPropertyComponent> csProps, List<org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent> expProps, List<Extension> csExtList, List<Extension> vsExtList, ValueSetExpansionComponent exp) throws ETooCostly {
    opContext.deadCheck();
    
    if (filters != null && !filters.isEmpty() && !filterContainsCode(filters, system, code, exp))
      return null;
    if (noInactive && inactive) {
      return null;
    }
    
    ValueSetExpansionContainsComponent n = new ValueSet.ValueSetExpansionContainsComponent();
    n.setSystem(system);
    n.setCode(code);
    if (isAbstract) {
      n.setAbstract(true);
    }
    if (inactive) {
      n.setInactive(true);
    }
    if (deprecated) {
      ValueSetUtilities.setDeprecated(vsProp, n);
    }
    if (ExtensionsUtils.hasExtension(csExtList, "http://hl7.org/fhir/StructureDefinition/codesystem-label")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#label", "label", ExtensionsUtils.getExtensionValue(csExtList, "http://hl7.org/fhir/StructureDefinition/codesystem-label"));
    }
    if (ExtensionsUtils.hasExtension(vsExtList, "http://hl7.org/fhir/StructureDefinition/valueset-label")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#label", "label", ExtensionsUtils.getExtensionValue(vsExtList, "http://hl7.org/fhir/StructureDefinition/valueset-label"));
    }
    if (ExtensionsUtils.hasExtension(csExtList, "http://hl7.org/fhir/StructureDefinition/codesystem-conceptOrder")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#order", "order", ExtensionsUtils.getExtensionValue(csExtList, "http://hl7.org/fhir/StructureDefinition/codesystem-conceptOrder"));
    }
    if (ExtensionsUtils.hasExtension(vsExtList, "http://hl7.org/fhir/StructureDefinition/valueset-conceptOrder")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#order", "order", ExtensionsUtils.getExtensionValue(vsExtList, "http://hl7.org/fhir/StructureDefinition/valueset-conceptOrder"));
    }
    if (ExtensionsUtils.hasExtension(csExtList, "http://hl7.org/fhir/StructureDefinition/itemWeight")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#itemWeight", "weight", ExtensionsUtils.getExtensionValue(csExtList, "http://hl7.org/fhir/StructureDefinition/itemWeight"));
    }
    if (ExtensionsUtils.hasExtension(vsExtList, "http://hl7.org/fhir/StructureDefinition/itemWeight")) {
      ValueSetUtilities.addProperty(focus, n, "http://hl7.org/fhir/concept-properties#itemWeight", "weight", ExtensionsUtils.getExtensionValue(vsExtList, "http://hl7.org/fhir/StructureDefinition/itemWeight"));
    }
    ExtensionsUtils.copyExtensions(csExtList, n.getExtension(), 
        "http://hl7.org/fhir/StructureDefinition/coding-sctdescid", 
        "http://hl7.org/fhir/StructureDefinition/rendering-style", 
        "http://hl7.org/fhir/StructureDefinition/rendering-xhtml",
        "http://hl7.org/fhir/StructureDefinition/codesystem-alternate");
    
    ExtensionsUtils.copyExtensions(vsExtList, n.getExtension(), 
        "http://hl7.org/fhir/StructureDefinition/valueset-supplement", 
        "http://hl7.org/fhir/StructureDefinition/valueset-deprecated",
        "http://hl7.org/fhir/StructureDefinition/valueset-concept-definition",
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
      designations.add(new ConceptDefinitionDesignationComponent().setLanguage(dispLang).setValue(display).setUse(new Coding().setSystem("http://terminology.hl7.org/CodeSystem/designation-usage").setCode("display")));
      pref = findMatchingDesignation(designations);
      if (pref != null) {
        n.setDisplay(pref.getValue());
      }
    }

    if (expParams.getParameterBool("includeDesignations")) {
      
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
            if (Utilities.existsInList(ext.getUrl(), "http://hl7.org/fhir/StructureDefinition/coding-sctdescid")) {
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
              n.addProperty().setCode(cp.getCode()).setValue(cp.getValue()).copyExtensions(cp, "http://hl7.org/fhir/StructureDefinition/alternate-code-use", "http://hl7.org/fhir/StructureDefinition/alternate-code-status");
            }
          }
        }
        if (expProps != null && p.hasValue()) {
          for (org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent cp : expProps) {
            if (p.getValue().primitiveValue().equals(cp.getCode())) {
              n.addProperty(cp).copyExtensions(cp, "http://hl7.org/fhir/StructureDefinition/alternate-code-use", "http://hl7.org/fhir/StructureDefinition/alternate-code-status");
            }
          }
        }        
      }
    }

    String s = key(n);
    if (wc.getMap().containsKey(s) || wc.getExcludeKeys().contains(s)) {
      wc.setCanBeHeirarchy(false);
    } else {
      wc.getCodes().add(n);
      wc.getMap().put(s, n);
      wc.incTotal();
      if (wc == dwc && wc.getTotal() > maxExpansionSize) {
        if (wc.getOffset()+wc.getCount() > 0 && wc.getTotal() > wc.getOffset()+wc.getCount()) {
          wc.setTotal(-1);
          throw new EFinished();
        }
        throw failCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY, focus.getUrl(), ">" + Integer.toString(maxExpansionSize)));
      }
    }
    if (wc.isCanBeHeirarchy() && parent != null) {
      parent.getContains().add(n);
    } else {
      wc.getRoots().add(n);
    }
    return n;
  }

  private boolean passesDesignationFilter(ConceptDefinitionDesignationComponent d) {
    if (designations.isEmpty()) {
      return true;
    }
    for (Token t : designations) {
      if (t.matches(d.getUse()) || t.matchesLang(d.getLanguage())) {
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
          if (isDisplay(cd) && LanguageUtils.langsMatchExact(cd.getLanguage(), lang.getLang())) {
            return cd;
          }
        }
        for (ConceptDefinitionDesignationComponent cd : designations) {
          if (isDisplay(cd) && LanguageUtils.langsMatch(cd.getLanguage(), lang.getLang())) {
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
      }
    }
    return null;
  }

  private boolean isDisplay(ConceptDefinitionDesignationComponent cd) {
    return cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "display");
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

  private void addCodeAndDescendents(WorkingContext wc, ValueSetExpansionContainsComponent focus, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filters, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc, ValueSetExpansionComponent exp)  throws FHIRException, ETooCostly {
    opContext.deadCheck();
    focus.checkNoModifiers("Expansion.contains", "expanding");
    ValueSetExpansionContainsComponent np = null;
    for (String code : getCodesForConcept(focus, expParams)) {
      ValueSetExpansionContainsComponent t = addCode(wc, focus.getSystem(), code, focus.getDisplay(), vsSrc.getLanguage(), parent, 
           convert(focus.getDesignation()), expParams, focus.getAbstract(), focus.getInactive(), filters, noInactive, false, vsProps, makeCSProps(focus.getExtensionString(ToolingExtensions.EXT_DEFINITION), null), focus.getProperty(), null, focus.getExtension(), exp);
      if (np == null) {
        np = t;
      }
    }
    for (ValueSetExpansionContainsComponent c : focus.getContains())
      addCodeAndDescendents(wc, c, np, expParams, filters, noInactive, vsProps, vsSrc, exp);
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
      n.setUse(d.getUse());
      n.setValue(d.getValue());
      list.add(n);
    }
    return list;
  }

  private void addCodeAndDescendents(WorkingContext wc, CodeSystem cs, String system, ConceptDefinitionComponent def, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filters, 
        ConceptDefinitionComponent exclusion, ConceptFilter filterFunc, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, List<WorkingContext> otherFilters, ValueSetExpansionComponent exp)  throws FHIRException, ETooCostly {
    opContext.deadCheck();
    def.checkNoModifiers("Code in Code System", "expanding");
    if (exclusion != null) {
      if (exclusion.getCode().equals(def.getCode()))
        return; // excluded.
    }
    ValueSetExpansionContainsComponent np = null;
    boolean abs = CodeSystemUtilities.isNotSelectable(cs, def);
    boolean inc = CodeSystemUtilities.isInactive(cs, def);
    boolean dep = CodeSystemUtilities.isDeprecated(cs, def, false);
    if ((includeAbstract || !abs)  && filterFunc.includeConcept(cs, def) && passesOtherFilters(otherFilters, cs, def.getCode())) {
      for (String code : getCodesForConcept(def, expParams)) {
        ValueSetExpansionContainsComponent t = addCode(wc, system, code, def.getDisplay(), cs.getLanguage(), parent, def.getDesignation(), expParams, abs, inc, filters, noInactive, dep, vsProps, makeCSProps(def.getDefinition(), def.getProperty()), null, def.getExtension(), null, exp);
        if (np == null) {
          np = t;
        }
      }
    }
    for (ConceptDefinitionComponent c : def.getConcept()) {
      addCodeAndDescendents(wc, cs, system, c, np, expParams, filters, exclusion, filterFunc, noInactive, vsProps, otherFilters, exp);
    }
    if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
      List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
      for (ConceptDefinitionComponent c : children)
        addCodeAndDescendents(wc, cs, system, c, np, expParams, filters, exclusion, filterFunc, noInactive, vsProps, otherFilters, exp);
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
    for (Extension ext : p.getExtensionsByUrl(ToolingExtensions.EXT_CS_ALTERNATE_USE)) {
      if (ext.hasValueCoding() && Utilities.existsInList(ext.getValueCoding().getCode(), uses)) {
        return true;
      }
    }
    return false;
  }

  

  private void addCodes(ValueSetExpansionComponent expand, List<ValueSetExpansionParameterComponent> params, Parameters expParams, List<ValueSet> filters, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc, ValueSetExpansionComponent exp) throws ETooCostly, FHIRException {
    if (expand != null) {
      if (expand.getContains().size() > maxExpansionSize)
        throw failCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY, vsSrc.getUrl(), ">" + Integer.toString(expand.getContains().size())));
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

  private void excludeCodes(WorkingContext wc, ConceptSetComponent exc, List<ValueSetExpansionParameterComponent> params, String ctxt) throws FHIRException {
    opContext.deadCheck();
    exc.checkNoModifiers("Compose.exclude", "expanding");
    if (exc.hasSystem() && exc.getConcept().size() == 0 && exc.getFilter().size() == 0) {
      wc.getExcludeSystems().add(exc.getSystem());
    }

    if (exc.hasValueSet())
      throw fail("Processing Value set references in exclude is not yet done in "+ctxt);
    // importValueSet(imp.getValue(), params, expParams);

    CodeSystem cs = context.fetchSupplementedCodeSystem(exc.getSystem());
    if ((cs == null || cs.getContent() != CodeSystemContentMode.COMPLETE) && context.supportsSystem(exc.getSystem())) {
      ValueSetExpansionOutcome vse = context.expandVS(exc, false, false);
      ValueSet valueset = vse.getValueset();
      if (valueset == null)
        throw failTSE("Error Expanding ValueSet: "+vse.getError());
      excludeCodes(wc, valueset.getExpansion(), params);
      return;
    }

    for (ConceptReferenceComponent c : exc.getConcept()) {
      excludeCode(wc, exc.getSystem(), c.getCode());
    }

    if (exc.getFilter().size() > 0)
      throw fail("not done yet - multiple filters");
  }

  private void excludeCodes(WorkingContext wc, ValueSetExpansionComponent expand, List<ValueSetExpansionParameterComponent> params) {
    opContext.deadCheck();
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
    } catch (ETooCostly e) {
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.TOO_COSTLY, allErrors, false);
    } catch (Exception e) {
      // well, we couldn't expand, so we'll return an interface to a checker that can check membership of the set
      // that might fail too, but it might not, later.
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.UNKNOWN, allErrors, e instanceof EFhirClientException || e instanceof TerminologyServiceException);
    }
  }
  
  public ValueSetExpansionOutcome expandInternal(ValueSet source, Parameters expParams) throws FHIRException, FileNotFoundException, ETooCostly, IOException, CodeSystemProviderExtension {
      return doExpand(source, expParams);
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
      dwc.setOffset(((IntegerType) value).getValue());
      if (dwc.getOffset() < 0) {
        dwc.setOffset(0);
      }
    }
    if ("count".equals(name)) {
      focus.getExpansion().getParameter().removeIf(p -> p.getName().equals(name));
      focus.getExpansion().addParameter().setName(name).setValue(value);
      dwc.setCount(((IntegerType) value).getValue());
      if (dwc.getCount() < 0) {
        dwc.setCount(0);
      }
    }
  }
  
  public ValueSetExpansionOutcome doExpand(ValueSet source, Parameters expParams) throws FHIRException, ETooCostly, FileNotFoundException, IOException, CodeSystemProviderExtension {
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
    for (Extension ext : focus.getCompose().getExtensionsByUrl("http://hl7.org/fhir/tools/StructureDefinion/valueset-expansion-param")) {
      processParameter(ext.getExtensionString("name"), ext.getExtensionByUrl("value").getValue());
    }
    for (ParametersParameterComponent p : expParams.getParameter()) {
      processParameter(p.getName(), p.getValue());
    }
    for (Extension s : focus.getExtensionsByUrl(ExtensionConstants.EXT_VSSUPPLEMENT)) {
      requiredSupplements.add(s.getValue().primitiveValue());
    }
    if (langs == null && focus.hasLanguage()) {
      langs = new AcceptLanguageHeader(focus.getLanguage(), true);
    } else if (langs != null && langs.hasChosen()) {
      focus.setLanguage(langs.getChosen());
    }

    try {
      if (source.hasCompose()) {
//        ExtensionsUtils.stripExtensions(focus.getCompose()); - disabled 23/05/2023 GDG - why was this ever thought to be a good idea?
        handleCompose(source.getCompose(), focus.getExpansion(), expParams, source.getUrl(), focus.getExpansion().getExtension(), source);
      }
    } catch (EFinished e) {
      // nothing - we intended to trap this here
    }

    if (dwc.isCanBeHeirarchy()) {
      for (ValueSetExpansionContainsComponent c : dwc.getRoots()) {
        focus.getExpansion().getContains().add(c);
      }
    } else {
      int i = 0;
      int cc = 0;
      for (ValueSetExpansionContainsComponent c : dwc.getCodes()) {
        if (dwc.getMap().containsKey(key(c)) && (includeAbstract || !c.getAbstract())) { // we may have added abstract codes earlier while we still thought it might be heirarchical, but later we gave up, so now ignore them
          if (dwc.getOffset() == 0 || i >= dwc.getOffset()) {
            focus.getExpansion().getContains().add(c);
            c.getContains().clear(); // make sure any heirarchy is wiped
            cc++;
            if (cc == dwc.getCount()) {
              break;
            }
          }
          i++;
        }
      }
    }

    if (dwc.getTotal() >= 0) {
      focus.getExpansion().setTotal(dwc.getTotal());
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
      throws ETooCostly, FileNotFoundException, IOException, FHIRException, CodeSystemProviderExtension {
    compose.checkNoModifiers("ValueSet.compose", "expanding");
    // Exclude comes first because we build up a map of things to exclude
    for (ConceptSetComponent inc : compose.getExclude())
      excludeCodes(dwc, inc, exp.getParameter(), ctxt);
    dwc.setCanBeHeirarchy(!expParams.getParameterBool("excludeNested") && dwc.getExcludeKeys().isEmpty() && dwc.getExcludeSystems().isEmpty() && dwc.getOffset()+dwc.getCount() == 0);
    includeAbstract = !expParams.getParameterBool("excludeNotForUI");
    boolean first = true;
    for (ConceptSetComponent inc : compose.getInclude()) {
      if (first == true)
        first = false;
      else
        dwc.setCanBeHeirarchy(false);
      includeCodes(inc, exp, expParams, dwc.isCanBeHeirarchy(), compose.hasInactive() ? !compose.getInactive() : checkNoInActiveFromParam(expParams), extensions, valueSet);
    }
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

  private ValueSet importValueSet(WorkingContext wc, String value, ValueSetExpansionComponent exp, Parameters expParams, boolean noInactive, ValueSet valueSet) throws ETooCostly, TerminologyServiceException, FileNotFoundException, IOException, FHIRFormatError {
    if (value == null)
      throw fail("unable to find value set with no identity");
    ValueSet vs = context.fetchResource(ValueSet.class, value, valueSet);
    if (vs == null) {
      if (context.fetchResource(CodeSystem.class, value, valueSet) != null) {
        throw fail("Cannot include value set "+value+" because it's actually a code system");
      } else {
        throw fail("Unable to find imported value set " + value);
      }
    }
    checkCanonical(exp, vs, focus);
    if (noInactive) {
      expParams = expParams.copy();
      expParams.addParameter("activeOnly", true);
    }
    ValueSetExpansionOutcome vso = new ValueSetExpander(context, opContext.copy(), allErrors).expand(vs, expParams);
    if (vso.getError() != null) {
      addErrors(vso.getAllErrors());
      throw fail("Unable to expand imported value set "+vs.getUrl()+": " + vso.getError());
    }
    if (vs.hasVersion() || REPORT_VERSION_ANYWAY) {
      UriType u = new UriType(vs.getUrl() + (vs.hasVersion() ? "|"+vs.getVersion() : ""));
      if (!existsInParams(exp.getParameter(), "used-valueset", u))
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("used-valueset").setValue(u));
    }
    for (Extension ex : vso.getValueset().getExpansion().getExtension()) {
      if (ex.getUrl().equals(ToolingExtensions.EXT_EXP_TOOCOSTLY)) {
        if (ex.getValue() instanceof BooleanType) {
          exp.getExtension().add(new Extension(ToolingExtensions.EXT_EXP_TOOCOSTLY).setValue(new CanonicalType(value)));
        } else {
          exp.getExtension().add(ex);
        }
      } 
    }
    for (ValueSetExpansionParameterComponent p : vso.getValueset().getExpansion().getParameter()) {
      if (!existsInParams(exp.getParameter(), p.getName(), p.getValue()))
        exp.getParameter().add(p);
    }
    if (isValueSetUnionImports(valueSet)) {
      copyExpansion(wc, vso.getValueset().getExpansion().getContains());
    }
    wc.setCanBeHeirarchy(false); // if we're importing a value set, we have to be combining, so we won't try for a heirarchy
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
    opContext.deadCheck();
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
         wc.incTotal();
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

  private void copyImportContains(List<ValueSetExpansionContainsComponent> list, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filter, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc, ValueSetExpansionComponent exp) throws FHIRException, ETooCostly {
    opContext.deadCheck();
    for (ValueSetExpansionContainsComponent c : list) {
      c.checkNoModifiers("Imported Expansion in Code System", "expanding");
      ValueSetExpansionContainsComponent np = addCode(dwc, c.getSystem(), c.getCode(), c.getDisplay(), vsSrc.getLanguage(), parent, null, expParams, c.getAbstract(), c.getInactive(), 
          filter, noInactive, false, vsProps, makeCSProps(c.getExtensionString(ToolingExtensions.EXT_DEFINITION), null), c.getProperty(), null, c.getExtension(), exp);
      copyImportContains(c.getContains(), np, expParams, filter, noInactive, vsProps, vsSrc, exp);
    }
  }

  private void includeCodes(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, boolean heirarchical, boolean noInactive, List<Extension> extensions, ValueSet valueSet) throws ETooCostly, FileNotFoundException, IOException, FHIRException, CodeSystemProviderExtension {
    opContext.deadCheck();
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
      CodeSystem cs = context.fetchSupplementedCodeSystem(inc.getSystem());
      if (ValueSetUtilities.isServerSide(inc.getSystem()) || (cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT))) {
        doServerIncludeCodes(inc, heirarchical, exp, imports, expParams, extensions, noInactive, valueSet.getExpansion().getProperty());
      } else {
        if (cs.hasUserData("supplements.installed")) {
          for (String s : cs.getUserString("supplements.installed").split("\\,")) {
            requiredSupplements.remove(s);
          }
        }
        doInternalIncludeCodes(inc, exp, expParams, imports, cs, noInactive, valueSet);
      }
    }
  }

  private void doServerIncludeCodes(ConceptSetComponent inc, boolean heirarchical, ValueSetExpansionComponent exp, List<ValueSet> imports, Parameters expParams, List<Extension> extensions, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps) throws FHIRException, CodeSystemProviderExtension, ETooCostly {
    opContext.deadCheck();
    CodeSystemProvider csp = CodeSystemProvider.factory(inc.getSystem());
    if (csp != null) {
      csp.includeCodes(inc, heirarchical, exp, imports, expParams, extensions, noInactive, vsProps);
      return;
    }
    
    ValueSetExpansionOutcome vso = context.expandVS(inc, heirarchical, noInactive);
    if (vso.getError() != null) {
      throw failTSE("Unable to expand imported value set: " + vso.getError());
    }
    ValueSet vs = vso.getValueset();
    if (vs.hasVersion() || REPORT_VERSION_ANYWAY) {
      UriType u = new UriType(vs.getUrl() + (vs.hasVersion() ? "|"+vs.getVersion() : ""));
      if (!existsInParams(exp.getParameter(), "used-valueset", u)) {
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("used-valueset").setValue(u));
      }
    }
    for (ValueSetExpansionParameterComponent p : vso.getValueset().getExpansion().getParameter()) {
      if (!existsInParams(exp.getParameter(), p.getName(), p.getValue())) {
        exp.getParameter().add(p);
      }
    }
    for (Extension ex : vs.getExpansion().getExtension()) {
      if (Utilities.existsInList(ex.getUrl(), ToolingExtensions.EXT_EXP_TOOCOSTLY, "http://hl7.org/fhir/StructureDefinition/valueset-unclosed")) {
        if (!ExtensionsUtils.hasExtension(extensions, ex.getUrl())) {
          extensions.add(ex);
        }
      }
    }
    for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContains()) {
      addCodeAndDescendents(dwc, cc, null, expParams, imports, noInactive, vsProps, vs, exp);
    }
  }


  public void doInternalIncludeCodes(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, List<ValueSet> imports, CodeSystem cs, boolean noInactive, Resource vsSrc) throws NoTerminologyServiceException, TerminologyServiceException, FHIRException, ETooCostly {
    opContext.deadCheck();
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
      if (cs.hasUserData("supplements.installed")) {
        for (String s : cs.getUserString("supplements.installed").split("\\,")) {
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
        addCodeAndDescendents(dwc, cs, inc.getSystem(), def, null, expParams, imports, null, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), null, exp);
      }
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        addFragmentWarning(exp, cs);
      }
      if (cs.getContent() == CodeSystemContentMode.EXAMPLE) {
        addExampleWarning(exp, cs);
      }      
    }

    if (!inc.getConcept().isEmpty()) {
      dwc.setCanBeHeirarchy(false);
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
          addCode(dwc, inc.getSystem(), c.getCode(), !Utilities.noString(c.getDisplay()) ? c.getDisplay() : def.getDisplay(), c.hasDisplay() ? vsSrc.getLanguage() : cs.getLanguage(), null, mergeDesignations(def, convertDesignations(c.getDesignation())), 
              expParams, isAbstract, inactive, imports, noInactive, false, exp.getProperty(), makeCSProps(def.getDefinition(), def.getProperty()), null, def.getExtension(), c.getExtension(), exp);
        }
      }
    }
    if (inc.getFilter().size() > 0) {
      if (inc.getFilter().size() > 1) {
        dwc.setCanBeHeirarchy(false); // which will be the case if we get around to supporting this
      }
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        addFragmentWarning(exp, cs);
      }
      List<WorkingContext> filters = new ArrayList<>();
      for (int i = 1; i < inc.getFilter().size(); i++) {
        WorkingContext wc = new WorkingContext();
        filters.add(wc);
        processFilter(inc, exp, expParams, imports, cs, noInactive, inc.getFilter().get(i), wc, null);
      }
      ConceptSetFilterComponent fc = inc.getFilter().get(0);
      WorkingContext wc = dwc;
      processFilter(inc, exp, expParams, imports, cs, noInactive, fc, wc, filters);
    }
  }

  private void processFilter(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams,
      List<ValueSet> imports, CodeSystem cs, boolean noInactive, ConceptSetFilterComponent fc, WorkingContext wc, List<WorkingContext> filters)
      throws ETooCostly {
    opContext.deadCheck();
    if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.ISA) {
      // special: all codes in the target code system under the value
      ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
      if (def == null)
        throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
      addCodeAndDescendents(wc, cs, inc.getSystem(), def, null, expParams, imports, null, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), filters, exp);
    } else if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.ISNOTA) {
      // special: all codes in the target code system that are not under the value
      ConceptDefinitionComponent defEx = getConceptForCode(cs.getConcept(), fc.getValue());
      if (defEx == null)
        throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        addCodeAndDescendents(wc, cs, inc.getSystem(), def, null, expParams, imports, defEx, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), filters, exp);
      }
    } else if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.DESCENDENTOF) {
      // special: all codes in the target code system under the value
      ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
      if (def == null)
        throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
      for (ConceptDefinitionComponent c : def.getConcept())
        addCodeAndDescendents(wc, cs, inc.getSystem(), c, null, expParams, imports, null, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), filters, exp);
      if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
        List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
        for (ConceptDefinitionComponent c : children)
          addCodeAndDescendents(wc, cs, inc.getSystem(), c, null, expParams, imports, null, new AllConceptsFilter(allErrors), noInactive, exp.getProperty(), filters, exp);
      }

    } else if ("display".equals(fc.getProperty()) && fc.getOp() == FilterOperator.EQUAL) {
      // gg; note: wtf is this: if the filter is display=v, look up the code 'v', and see if it's display is 'v'?
      dwc.setCanBeHeirarchy(false);
      ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
      if (def != null) {
        if (isNotBlank(def.getDisplay()) && isNotBlank(fc.getValue())) {
          if (def.getDisplay().contains(fc.getValue()) && passesOtherFilters(filters, cs, def.getCode())) {
            for (String code : getCodesForConcept(def, expParams)) {
              opContext.deadCheck();
              ValueSetExpansionContainsComponent t = addCode(wc, inc.getSystem(), code, def.getDisplay(), cs.getLanguage(), null, def.getDesignation(), expParams, CodeSystemUtilities.isNotSelectable(cs, def), CodeSystemUtilities.isInactive(cs, def),
                  imports, noInactive, false, exp.getProperty(), makeCSProps(def.getDefinition(), def.getProperty()), null, def.getExtension(), null, exp);
            }
          }
        }
      }
    } else if (isDefinedProperty(cs, fc.getProperty())) {
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        addCodeAndDescendents(wc, cs, inc.getSystem(), def, null, expParams, imports, null, new PropertyFilter(allErrors, fc, getPropertyDefinition(cs, fc.getProperty())), noInactive, exp.getProperty(), filters, exp);
      }
    } else if ("code".equals(fc.getProperty()) && fc.getOp() == FilterOperator.REGEX) {
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        addCodeAndDescendents(wc, cs, inc.getSystem(), def, null, expParams, imports, null, new RegexFilter(allErrors, fc.getValue()), noInactive, exp.getProperty(), filters, exp);
      }
    } else {
      throw fail("Filter by property[" + fc.getProperty() + "] and op[" + fc.getOp() + "] is not supported yet");
    }
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

  private PropertyComponent getPropertyDefinition(CodeSystem cs, String property) {
    for (PropertyComponent cp : cs.getProperty()) {
      if (cp.getCode().equals(property)) {
        return cp;
      }
    }
    return null;
  }

  private boolean isDefinedProperty(CodeSystem cs, String property) {
    for (PropertyComponent cp : cs.getProperty()) {
      if (cp.getCode().equals(property)) {
        return true;
      }
    }
    return false;
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
      c.setUse(t.getUse());
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

  private FHIRException fail(String msg) {
    allErrors.add(msg);
    return new FHIRException(msg);
  }

  private ETooCostly failCostly(String msg) {
    allErrors.add(msg);
    return new ETooCostly(msg);
  }

  private TerminologyServiceException failTSE(String msg) {
    allErrors.add(msg);
    return new TerminologyServiceException(msg);
  }

  public Collection<? extends String> getAllErrors() {
    return allErrors;
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
}