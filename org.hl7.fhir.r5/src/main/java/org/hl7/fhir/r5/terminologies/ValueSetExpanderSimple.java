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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.NoTerminologyServiceException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;

public class ValueSetExpanderSimple implements ValueSetExpander {

  private List<ValueSetExpansionContainsComponent> codes = new ArrayList<ValueSet.ValueSetExpansionContainsComponent>();
  private List<ValueSetExpansionContainsComponent> roots = new ArrayList<ValueSet.ValueSetExpansionContainsComponent>();
  private Map<String, ValueSetExpansionContainsComponent> map = new HashMap<String, ValueSet.ValueSetExpansionContainsComponent>();
  private IWorkerContext context;
  private boolean canBeHeirarchy = true;
  private boolean includeAbstract = true;
  private Set<String> excludeKeys = new HashSet<String>();
  private Set<String> excludeSystems = new HashSet<String>();
  private ValueSet focus;
  private int maxExpansionSize = 500;

  private int total;

  public ValueSetExpanderSimple(IWorkerContext context) {
    super();
    this.context = context;
  }

  public void setMaxExpansionSize(int theMaxExpansionSize) {
    maxExpansionSize = theMaxExpansionSize;
  }
  
  private ValueSetExpansionContainsComponent addCode(String system, String code, String display, ValueSetExpansionContainsComponent parent, List<ConceptDefinitionDesignationComponent> designations, Parameters expParams, boolean isAbstract, boolean inactive, List<ValueSet> filters) {
 
    if (filters != null && !filters.isEmpty() && !filterContainsCode(filters, system, code))
      return null;
    ValueSetExpansionContainsComponent n = new ValueSet.ValueSetExpansionContainsComponent();
    n.setSystem(system);
    n.setCode(code);
    if (isAbstract)
      n.setAbstract(true);
    if (inactive)
      n.setInactive(true);

    if (expParams.getParameterBool("includeDesignations") && designations != null) {
      for (ConceptDefinitionDesignationComponent t : designations) {
        ToolingExtensions.addLanguageTranslation(n, t.getLanguage(), t.getValue());
      }
    }
    ConceptDefinitionDesignationComponent t = expParams.hasLanguage() ? getMatchingLang(designations, expParams.getLanguage()) : null;
    if (t == null)
      n.setDisplay(display);
    else
      n.setDisplay(t.getValue());

    String s = key(n);
    if (map.containsKey(s) || excludeKeys.contains(s)) {
      canBeHeirarchy = false;
    } else {
      codes.add(n);
      map.put(s, n);
      total++;
    }
    if (canBeHeirarchy && parent != null) {
      parent.getContains().add(n);
    } else {
      roots.add(n);
    }
    return n;
  }

  private boolean filterContainsCode(List<ValueSet> filters, String system, String code) {
    for (ValueSet vse : filters)
      if (expansionContainsCode(vse.getExpansion().getContains(), system, code))
        return true;
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

  private ConceptDefinitionDesignationComponent getMatchingLang(List<ConceptDefinitionDesignationComponent> list, String lang) {
    for (ConceptDefinitionDesignationComponent t : list)
      if (t.getLanguage().equals(lang))
        return t;
    for (ConceptDefinitionDesignationComponent t : list)
      if (t.getLanguage().startsWith(lang))
        return t;
    return null;
  }

  private void addCodeAndDescendents(ValueSetExpansionContainsComponent focus, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filters)  throws FHIRException {
    focus.checkNoModifiers("Expansion.contains", "expanding");
    ValueSetExpansionContainsComponent np = addCode(focus.getSystem(), focus.getCode(), focus.getDisplay(), parent, 
         convert(focus.getDesignation()), expParams, focus.getAbstract(), focus.getInactive(), filters);
    for (ValueSetExpansionContainsComponent c : focus.getContains())
      addCodeAndDescendents(focus, np, expParams, filters);
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

  private void addCodeAndDescendents(CodeSystem cs, String system, ConceptDefinitionComponent def, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filters, ConceptDefinitionComponent exclusion)  throws FHIRException {
    def.checkNoModifiers("Code in Code System", "expanding");
    if (exclusion != null) {
      if (exclusion.getCode().equals(def.getCode()))
        return; // excluded.
    }
    if (!CodeSystemUtilities.isDeprecated(cs, def)) {
      ValueSetExpansionContainsComponent np = null;
      boolean abs = CodeSystemUtilities.isNotSelectable(cs, def);
      boolean inc = CodeSystemUtilities.isInactive(cs, def);
      if (includeAbstract || !abs)
        np = addCode(system, def.getCode(), def.getDisplay(), parent, def.getDesignation(), expParams, abs, inc, filters);
      for (ConceptDefinitionComponent c : def.getConcept()) {
        addCodeAndDescendents(cs, system, c, np, expParams, filters, exclusion);
      }
      if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
        List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
        for (ConceptDefinitionComponent c : children)
          addCodeAndDescendents(cs, system, c, np, expParams, filters, exclusion);
      }
    } else {
      for (ConceptDefinitionComponent c : def.getConcept()) {
        addCodeAndDescendents(cs, system, c, null, expParams, filters, exclusion);
      }
      if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
        List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
        for (ConceptDefinitionComponent c : children)
          addCodeAndDescendents(cs, system, c, null, expParams, filters, exclusion);
      }
    }

  }

  private void addCodes(ValueSetExpansionComponent expand, List<ValueSetExpansionParameterComponent> params, Parameters expParams, List<ValueSet> filters) throws ETooCostly, FHIRException {
    if (expand != null) {
      if (expand.getContains().size() > maxExpansionSize)
        throw new ETooCostly("Too many codes to display (>" + Integer.toString(expand.getContains().size()) + ")");
      for (ValueSetExpansionParameterComponent p : expand.getParameter()) {
        if (!existsInParams(params, p.getName(), p.getValue()))
          params.add(p);
      }

      copyImportContains(expand.getContains(), null, expParams, filters);
    }
  }

  private void excludeCode(String theSystem, String theCode) {
    ValueSetExpansionContainsComponent n = new ValueSet.ValueSetExpansionContainsComponent();
    n.setSystem(theSystem);
    n.setCode(theCode);
    String s = key(n);
    excludeKeys.add(s);
  }

  private void excludeCodes(ConceptSetComponent exc, List<ValueSetExpansionParameterComponent> params, String ctxt) throws FHIRException {
    exc.checkNoModifiers("Compose.exclude", "expanding");
    if (exc.hasSystem() && exc.getConcept().size() == 0 && exc.getFilter().size() == 0) {
      excludeSystems.add(exc.getSystem());
    }

    if (exc.hasValueSet())
      throw new Error("Processing Value set references in exclude is not yet done in "+ctxt);
    // importValueSet(imp.getValue(), params, expParams);

    CodeSystem cs = context.fetchCodeSystem(exc.getSystem());
    if ((cs == null || cs.getContent() != CodeSystemContentMode.COMPLETE) && context.supportsSystem(exc.getSystem())) {
      ValueSetExpansionOutcome vse = context.expandVS(exc, false);
      ValueSet valueset = vse.getValueset();
      if (valueset == null)
        throw new TerminologyServiceException("Error Expanding ValueSet: "+vse.getError());
      excludeCodes(valueset.getExpansion(), params);
      return;
    }

    for (ConceptReferenceComponent c : exc.getConcept()) {
      excludeCode(exc.getSystem(), c.getCode());
    }

    if (exc.getFilter().size() > 0)
      throw new NotImplementedException("not done yet");
  }

  private void excludeCodes(ValueSetExpansionComponent expand, List<ValueSetExpansionParameterComponent> params) {
    for (ValueSetExpansionContainsComponent c : expand.getContains()) {
      excludeCode(c.getSystem(), c.getCode());
    }
  }

  private boolean existsInParams(List<ValueSetExpansionParameterComponent> params, String name, DataType value) {
    for (ValueSetExpansionParameterComponent p : params) {
      if (p.getName().equals(name) && PrimitiveType.compareDeep(p.getValue(), value, false))
        return true;
    }
    return false;
  }

  @Override
  public ValueSetExpansionOutcome expand(ValueSet source, Parameters expParams) {
    try {
      return doExpand(source, expParams);
    } catch (NoTerminologyServiceException e) {
      // well, we couldn't expand, so we'll return an interface to a checker that can check membership of the set
      // that might fail too, but it might not, later.
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.NOSERVICE);
    } catch (RuntimeException e) {
      // TODO: we should put something more specific instead of just Exception below, since
      // it swallows bugs.. what would be expected to be caught there?
      throw e;
    } catch (Exception e) {
      // well, we couldn't expand, so we'll return an interface to a checker that can check membership of the set
      // that might fail too, but it might not, later.
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.UNKNOWN);
    }
  }

  public ValueSetExpansionOutcome doExpand(ValueSet source, Parameters expParams) throws FHIRException, ETooCostly, FileNotFoundException, IOException {
    if (expParams == null)
      expParams = makeDefaultExpansion();
    source.checkNoModifiers("ValueSet", "expanding");
    focus = source.copy();
    focus.setExpansion(new ValueSet.ValueSetExpansionComponent());
    focus.getExpansion().setTimestampElement(DateTimeType.now());
    focus.getExpansion().setIdentifier(Factory.createUUID()); 
    for (ParametersParameterComponent p : expParams.getParameter()) {
      if (Utilities.existsInList(p.getName(), "includeDesignations", "excludeNested"))
        focus.getExpansion().addParameter().setName(p.getName()).setValue(p.getValue());
    }

    if (source.hasCompose())
      handleCompose(source.getCompose(), focus.getExpansion(), expParams, source.getUrl(), focus.getExpansion().getExtension());

    if (canBeHeirarchy) {
      for (ValueSetExpansionContainsComponent c : roots) {
        focus.getExpansion().getContains().add(c);
      }
    } else {
      for (ValueSetExpansionContainsComponent c : codes) {
        if (map.containsKey(key(c)) && (includeAbstract || !c.getAbstract())) { // we may have added abstract codes earlier while we still thought it might be heirarchical, but later we gave up, so now ignore them
          focus.getExpansion().getContains().add(c);
          c.getContains().clear(); // make sure any heirarchy is wiped
        }
      }
    }

    if (total > 0) {
      focus.getExpansion().setTotal(total);
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

  private void handleCompose(ValueSetComposeComponent compose, ValueSetExpansionComponent exp, Parameters expParams, String ctxt, List<Extension> extensions)
      throws ETooCostly, FileNotFoundException, IOException, FHIRException {
    compose.checkNoModifiers("ValueSet.compose", "expanding");
    // Exclude comes first because we build up a map of things to exclude
    for (ConceptSetComponent inc : compose.getExclude())
      excludeCodes(inc, exp.getParameter(), ctxt);
    canBeHeirarchy = !expParams.getParameterBool("excludeNested") && excludeKeys.isEmpty() && excludeSystems.isEmpty();
    includeAbstract = !expParams.getParameterBool("excludeNotForUI");
    boolean first = true;
    for (ConceptSetComponent inc : compose.getInclude()) {
      if (first == true)
        first = false;
      else
        canBeHeirarchy = false;
      includeCodes(inc, exp, expParams, canBeHeirarchy, extensions);
    }

  }

  private ValueSet importValueSet(String value, ValueSetExpansionComponent exp, Parameters expParams) throws ETooCostly, TerminologyServiceException, FileNotFoundException, IOException, FHIRFormatError {
    if (value == null)
      throw new TerminologyServiceException("unable to find value set with no identity");
    ValueSet vs = context.fetchResource(ValueSet.class, value);
    if (vs == null)
      throw new TerminologyServiceException("Unable to find imported value set " + value);
    ValueSetExpansionOutcome vso = new ValueSetExpanderSimple(context).expand(vs, expParams);
    if (vso.getError() != null)
      throw new TerminologyServiceException("Unable to expand imported value set: " + vso.getError());
    if (vs.hasVersion())
      if (!existsInParams(exp.getParameter(), "version", new UriType(vs.getUrl() + "|" + vs.getVersion())))
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("version").setValue(new UriType(vs.getUrl() + "|" + vs.getVersion())));
    for (Extension ex : vso.getValueset().getExpansion().getExtension()) {
      if (ex.getUrl().equals(ToolingExtensions.EXT_EXP_TOOCOSTLY)) {
        if (ex.getValue() instanceof BooleanType) {
          exp.getExtension().add(new Extension(ToolingExtensions.EXT_EXP_TOOCOSTLY).setValue(new UriType(value)));
        } else {
          exp.getExtension().add(ex);
        }
      } 
    }
    for (ValueSetExpansionParameterComponent p : vso.getValueset().getExpansion().getParameter()) {
      if (!existsInParams(exp.getParameter(), p.getName(), p.getValue()))
        exp.getParameter().add(p);
    }
    canBeHeirarchy = false; // if we're importing a value set, we have to be combining, so we won't try for a heirarchy
    return vso.getValueset();
  }

  private void copyImportContains(List<ValueSetExpansionContainsComponent> list, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filter) throws FHIRException {
    for (ValueSetExpansionContainsComponent c : list) {
      c.checkNoModifiers("Imported Expansion in Code System", "expanding");
      ValueSetExpansionContainsComponent np = addCode(c.getSystem(), c.getCode(), c.getDisplay(), parent, null, expParams, c.getAbstract(), c.getInactive(), filter);
      copyImportContains(c.getContains(), np, expParams, filter);
    }
  }

  private void includeCodes(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, boolean heirarchical, List<Extension> extensions) throws ETooCostly, FileNotFoundException, IOException, FHIRException {
    inc.checkNoModifiers("Compose.include", "expanding");
    List<ValueSet> imports = new ArrayList<ValueSet>();
    for (UriType imp : inc.getValueSet()) {
      imports.add(importValueSet(imp.getValue(), exp, expParams));
    }

    if (!inc.hasSystem()) {
      if (imports.isEmpty()) // though this is not supposed to be the case
        return;
      ValueSet base = imports.get(0);
      imports.remove(0);
      base.checkNoModifiers("Imported ValueSet", "expanding");
      copyImportContains(base.getExpansion().getContains(), null, expParams, imports);
    } else {
      CodeSystem cs = context.fetchCodeSystem(inc.getSystem());
      if ((cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT))) {
        doServerIncludeCodes(inc, heirarchical, exp, imports, expParams, extensions);
      } else {
        doInternalIncludeCodes(inc, exp, expParams, imports, cs);
      }
    }
  }

  private void doServerIncludeCodes(ConceptSetComponent inc, boolean heirarchical, ValueSetExpansionComponent exp, List<ValueSet> imports, Parameters expParams, List<Extension> extensions) throws FHIRException {
    ValueSetExpansionOutcome vso = context.expandVS(inc, heirarchical);
    if (vso.getError() != null) {
      throw new TerminologyServiceException("Unable to expand imported value set: " + vso.getError());
    }
    ValueSet vs = vso.getValueset();
    if (vs.hasVersion()) {
      if (!existsInParams(exp.getParameter(), "version", new UriType(vs.getUrl() + "|" + vs.getVersion()))) {
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("version").setValue(new UriType(vs.getUrl() + "|" + vs.getVersion())));
      }
    }
    for (ValueSetExpansionParameterComponent p : vso.getValueset().getExpansion().getParameter()) {
      if (!existsInParams(exp.getParameter(), p.getName(), p.getValue())) {
        exp.getParameter().add(p);
      }
    }
    for (Extension ex : vs.getExpansion().getExtension()) {
      if (Utilities.existsInList(ex.getUrl(), ToolingExtensions.EXT_EXP_TOOCOSTLY, "http://hl7.org/fhir/StructureDefinition/valueset-unclosed")) {
        if (!hasExtension(extensions, ex.getUrl())) {
          extensions.add(ex);
        }
      }
    }
    for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContains()) {
      addCodeAndDescendents(cc, null, expParams, imports);
    }
  }

  private boolean hasExtension(List<Extension> extensions, String url) {
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url)) {
        return true;
      }
    }
    return false;
  }

  public void doInternalIncludeCodes(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, List<ValueSet> imports, CodeSystem cs) throws NoTerminologyServiceException, TerminologyServiceException, FHIRException {
    if (cs == null) {
      if (context.isNoTerminologyServer())
        throw new NoTerminologyServiceException("Unable to find code system " + inc.getSystem().toString());
      else
        throw new TerminologyServiceException("Unable to find code system " + inc.getSystem().toString());
    }
    cs.checkNoModifiers("Code System", "expanding");
    if (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT)
      throw new TerminologyServiceException("Code system " + inc.getSystem().toString() + " is incomplete");
    if (cs.hasVersion())
      if (!existsInParams(exp.getParameter(), "version", new UriType(cs.getUrl() + "|" + cs.getVersion())))
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("version").setValue(new UriType(cs.getUrl() + "|" + cs.getVersion())));

    if (inc.getConcept().size() == 0 && inc.getFilter().size() == 0) {
      // special case - add all the code system
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        addCodeAndDescendents(cs, inc.getSystem(), def, null, expParams, imports, null);
      }
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        addFragmentWarning(exp, cs);
      }
    }

    if (!inc.getConcept().isEmpty()) {
      canBeHeirarchy = false;
      for (ConceptReferenceComponent c : inc.getConcept()) {
        c.checkNoModifiers("Code in Code System", "expanding");
        ConceptDefinitionComponent def = CodeSystemUtilities.findCode(cs.getConcept(), c.getCode());
        Boolean inactive = false; // default is true if we're a fragment and  
        if (def == null) {
          if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
            addFragmentWarning(exp, cs);
          } else {
            throw new TerminologyServiceException("Unable to find code '" + c.getCode() + "' in code system " + cs.getUrl());
          }
        } else {
          inactive = CodeSystemUtilities.isInactive(cs, def);
        }
        addCode(inc.getSystem(), c.getCode(), !Utilities.noString(c.getDisplay()) ? c.getDisplay() : def == null ? null : def.getDisplay(), null, convertDesignations(c.getDesignation()), expParams, false, inactive, imports);
      }
    }
    if (inc.getFilter().size() > 1) {
      canBeHeirarchy = false; // which will bt the case if we get around to supporting this
      throw new TerminologyServiceException("Multiple filters not handled yet"); // need to and them, and this isn't done yet. But this shouldn't arise in non loinc and snomed value sets
    }
    if (inc.getFilter().size() == 1) {
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        addFragmentWarning(exp, cs);
      }
      ConceptSetFilterComponent fc = inc.getFilter().get(0);
      if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.ISA) {
        // special: all codes in the target code system under the value
        ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
        if (def == null)
          throw new TerminologyServiceException("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
        addCodeAndDescendents(cs, inc.getSystem(), def, null, expParams, imports, null);
      } else if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.ISNOTA) {
        // special: all codes in the target code system that are not under the value
        ConceptDefinitionComponent defEx = getConceptForCode(cs.getConcept(), fc.getValue());
        if (defEx == null)
          throw new TerminologyServiceException("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
        for (ConceptDefinitionComponent def : cs.getConcept()) {
          addCodeAndDescendents(cs, inc.getSystem(), def, null, expParams, imports, defEx);
        }
      } else if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.DESCENDENTOF) {
        // special: all codes in the target code system under the value
        ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
        if (def == null)
          throw new TerminologyServiceException("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
        for (ConceptDefinitionComponent c : def.getConcept())
          addCodeAndDescendents(cs, inc.getSystem(), c, null, expParams, imports, null);
        if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
          List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
          for (ConceptDefinitionComponent c : children)
            addCodeAndDescendents(cs, inc.getSystem(), c, null, expParams, imports, null);
        }

      } else if ("display".equals(fc.getProperty()) && fc.getOp() == FilterOperator.EQUAL) {
        // gg; note: wtf is this: if the filter is display=v, look up the code 'v', and see if it's diplsay is 'v'?
        canBeHeirarchy = false;
        ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
        if (def != null) {
          if (isNotBlank(def.getDisplay()) && isNotBlank(fc.getValue())) {
            if (def.getDisplay().contains(fc.getValue())) {
              addCode(inc.getSystem(), def.getCode(), def.getDisplay(), null, def.getDesignation(), expParams, CodeSystemUtilities.isNotSelectable(cs, def), CodeSystemUtilities.isInactive(cs, def),
                  imports);
            }
          }
        }
      } else
        throw new NotImplementedException("Search by property[" + fc.getProperty() + "] and op[" + fc.getOp() + "] is not supported yet");
    }
  }

  private void addFragmentWarning(ValueSetExpansionComponent exp, CodeSystem cs) {
    for (Extension ex : cs.getExtensionsByUrl(ToolingExtensions.EXT_EXP_FRAGMENT)) {
      if (ex.getValue().primitiveValue().equals(cs.getUrl())) {
        return;
      }
    }
    exp.addExtension(new Extension(ToolingExtensions.EXT_EXP_FRAGMENT).setValue(new UriType(cs.getUrl())));
  }

  private List<ConceptDefinitionDesignationComponent> convertDesignations(List<ConceptReferenceDesignationComponent> list) {
    List<ConceptDefinitionDesignationComponent> res = new ArrayList<CodeSystem.ConceptDefinitionDesignationComponent>();
    for (ConceptReferenceDesignationComponent t : list) {
      ConceptDefinitionDesignationComponent c = new ConceptDefinitionDesignationComponent();
      c.setLanguage(t.getLanguage());
      c.setUse(t.getUse());
      c.setValue(t.getValue());
    }
    return res;
  }

  private String key(String uri, String code) {
    return "{" + uri + "}" + code;
  }

  private String key(ValueSetExpansionContainsComponent c) {
    return key(c.getSystem(), c.getCode());
  }

}