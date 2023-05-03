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
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
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
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Resource;
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
import org.hl7.fhir.r5.terminologies.ValueSetExpanderSimple.EFinished;
import org.hl7.fhir.r5.terminologies.providers.CodeSystemProviderExtension;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;

import com.google.errorprone.annotations.NoAllocation;

public class ValueSetExpanderSimple extends ValueSetWorker implements ValueSetExpander {

  public class EFinished extends FHIRException {

  }

  public interface IConceptFilter {

    boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def);

  }

  public class PropertyFilter implements IConceptFilter {

    private ConceptSetFilterComponent filter;
    private PropertyComponent property;

    public PropertyFilter(ConceptSetFilterComponent fc, PropertyComponent propertyDefinition) {
      this.filter = fc;
      this.property = propertyDefinition;
    }

    @Override
    public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
      ConceptPropertyComponent pc = getPropertyForConcept(def);
      if (pc != null) {
        String v = pc.getValue().isPrimitive() ? pc.getValue().primitiveValue() : null;
        switch (filter.getOp()) {
        case DESCENDENTOF: throw fail("not supported yet: "+filter.getOp().toCode());
        case EQUAL: return filter.getValue().equals(v);
        case EXISTS: throw fail("not supported yet: "+filter.getOp().toCode());
        case GENERALIZES: throw fail("not supported yet: "+filter.getOp().toCode());
        case IN: throw fail("not supported yet: "+filter.getOp().toCode());
        case ISA: throw fail("not supported yet: "+filter.getOp().toCode());
        case ISNOTA: throw fail("not supported yet: "+filter.getOp().toCode());
        case NOTIN: throw fail("not supported yet: "+filter.getOp().toCode());
        case NULL: throw fail("not supported yet: "+filter.getOp().toCode());
        case REGEX: throw fail("not supported yet: "+filter.getOp().toCode());
        default:
          throw fail("Shouldn't get here");        
        }            
      } else if (property.getType() == PropertyType.BOOLEAN && filter.getOp() == FilterOperator.EQUAL) {
        return "false".equals(filter.getValue()); 
      } else {
        return false;
      }
    }

    private ConceptPropertyComponent getPropertyForConcept(ConceptDefinitionComponent def) {
      for (ConceptPropertyComponent pc : def.getProperty()) {
        if (pc.getCode().equals(property.getCode())) {
          return pc;
        }
      }
      return null;
    }

  }

  public class AllConceptsFilter implements IConceptFilter {

    @Override
    public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
      return true;
    }
  }

  public class RegexFilter implements IConceptFilter {

    private String regex;
    
    protected RegexFilter(String regex) {
      super();
      this.regex = regex;
    }

    @Override
    public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
      return def.getCode().matches(regex);
    }
  }
  private static final boolean REPORT_VERSION_ANYWAY = false;
  
  private List<ValueSetExpansionContainsComponent> codes = new ArrayList<ValueSet.ValueSetExpansionContainsComponent>();
  private List<ValueSetExpansionContainsComponent> roots = new ArrayList<ValueSet.ValueSetExpansionContainsComponent>();
  private Map<String, ValueSetExpansionContainsComponent> map = new HashMap<String, ValueSet.ValueSetExpansionContainsComponent>();
  private IWorkerContext context;
  private boolean canBeHeirarchy = true;
  private boolean includeAbstract = true;
  private Set<String> excludeKeys = new HashSet<String>();
  private Set<String> excludeSystems = new HashSet<String>();
  private ValueSet focus;
  private int maxExpansionSize = 1000;
  private int offset;
  private int count;
  private List<String> allErrors = new ArrayList<>();
  private List<String> requiredSupplements = new ArrayList<>();

  private int total;
  private boolean checkCodesWhenExpanding;

  public ValueSetExpanderSimple(IWorkerContext context) {
    super();
    this.context = context;
  }

  public ValueSetExpanderSimple(IWorkerContext context, List<String> allErrors) {
    super();
    this.context = context;
    this.allErrors = allErrors;
  }

  public void setMaxExpansionSize(int theMaxExpansionSize) {
    maxExpansionSize = theMaxExpansionSize;
  }
  
  private ValueSetExpansionContainsComponent addCode(String system, String code, String display, String dispLang, ValueSetExpansionContainsComponent parent, List<ConceptDefinitionDesignationComponent> designations, Parameters expParams, 
      boolean isAbstract, boolean inactive, String definition, List<ValueSet> filters, boolean noInactive, boolean deprecated, List<ValueSetExpansionPropertyComponent> vsProp, 
      List<ConceptPropertyComponent> csProps, List<org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent> expProps, List<Extension> csExtList, List<Extension> vsExtList) throws ETooCostly {
 
    if (filters != null && !filters.isEmpty() && !filterContainsCode(filters, system, code))
      return null;
    if (noInactive && inactive) {
      return null;
    }
    
    ValueSetExpansionContainsComponent n = new ValueSet.ValueSetExpansionContainsComponent();
    n.setSystem(system);
    n.setCode(code);
    if (isAbstract)
      n.setAbstract(true);
    if (inactive)
      n.setInactive(true);
    if (deprecated) {
      ValueSetUtilities.setDeprecated(vsProp, n);
    }
    if (expParams.getParameterBool("includeDefinition") && definition != null) {
      n.addExtension(Extensions.makeVSConceptDefinition(definition)); 
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
    String srcLang = dispLang;
    String dstLang = focus.getLanguage();
    
    boolean usedDisplay = false;
    ConceptDefinitionDesignationComponent tu = expParams.hasParameter("displayLanguage") ? getMatchingLang(designations, expParams.getParameterString("displayLanguage")) : null;
    if (tu != null) {
      n.setDisplay(tu.getValue());        
    } else if (display != null && (srcLang == null || dstLang == null || LanguageUtils.langsMatch(dstLang, srcLang))) {
      n.setDisplay(display);
      usedDisplay = true;
    } else {
      // we don't have a usable display
    }

    if (expParams.getParameterBool("includeDesignations") && designations != null) {
      if (!usedDisplay && display != null) {
        n.addDesignation().setLanguage(srcLang).setValue(display);
      }
      for (ConceptDefinitionDesignationComponent t : designations) {
        if (t != tu && (t.hasLanguage() || t.hasUse()) && t.getValue() != null) {
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
              n.addProperty().setCode(cp.getCode()).setValue(cp.getValue());
            }
          }
        }
        if (expProps != null && p.hasValue()) {
          for (org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent cp : expProps) {
            if (p.getValue().primitiveValue().equals(cp.getCode())) {
              n.addProperty(cp);
            }
          }
        }        
      }
    }

    

    String s = key(n);
    if (map.containsKey(s) || excludeKeys.contains(s)) {
      canBeHeirarchy = false;
    } else {
      codes.add(n);
      map.put(s, n);
      total++;
      if (total > maxExpansionSize) {
        if (offset+count > 0 && total > offset+count) {
          total = -1;
          throw new EFinished();
        }
        throw failCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY, focus.getUrl(), ">" + Integer.toString(maxExpansionSize)));
      }
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

  private void addCodeAndDescendents(ValueSetExpansionContainsComponent focus, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filters, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc)  throws FHIRException, ETooCostly {
    focus.checkNoModifiers("Expansion.contains", "expanding");
    ValueSetExpansionContainsComponent np = addCode(focus.getSystem(), focus.getCode(), focus.getDisplay(), vsSrc.getLanguage(), parent, 
         convert(focus.getDesignation()), expParams, focus.getAbstract(), focus.getInactive(), focus.getExtensionString(ToolingExtensions.EXT_DEFINITION), filters, noInactive, false, vsProps, null, focus.getProperty(), null, focus.getExtension());
    for (ValueSetExpansionContainsComponent c : focus.getContains())
      addCodeAndDescendents(c, np, expParams, filters, noInactive, vsProps, vsSrc);
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

  private void addCodeAndDescendents(CodeSystem cs, String system, ConceptDefinitionComponent def, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filters, 
        ConceptDefinitionComponent exclusion, IConceptFilter filterFunc, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps)  throws FHIRException, ETooCostly {
    def.checkNoModifiers("Code in Code System", "expanding");
    if (exclusion != null) {
      if (exclusion.getCode().equals(def.getCode()))
        return; // excluded.
    }
    ValueSetExpansionContainsComponent np = null;
    boolean abs = CodeSystemUtilities.isNotSelectable(cs, def);
    boolean inc = CodeSystemUtilities.isInactive(cs, def);
    boolean dep = CodeSystemUtilities.isDeprecated(cs, def, false);
    if ((includeAbstract || !abs)  && filterFunc.includeConcept(cs, def)) {
      np = addCode(system, def.getCode(), def.getDisplay(), cs.getLanguage(), parent, def.getDesignation(), expParams, abs, inc, def.getDefinition(), filters, noInactive, dep, vsProps, def.getProperty(), null, def.getExtension(), null);
    }
    for (ConceptDefinitionComponent c : def.getConcept()) {
      addCodeAndDescendents(cs, system, c, np, expParams, filters, exclusion, filterFunc, noInactive, vsProps);
    }
    if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
      List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
      for (ConceptDefinitionComponent c : children)
        addCodeAndDescendents(cs, system, c, np, expParams, filters, exclusion, filterFunc, noInactive, vsProps);
    }

  }

  private void addCodes(ValueSetExpansionComponent expand, List<ValueSetExpansionParameterComponent> params, Parameters expParams, List<ValueSet> filters, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc) throws ETooCostly, FHIRException {
    if (expand != null) {
      if (expand.getContains().size() > maxExpansionSize)
        throw failCostly(context.formatMessage(I18nConstants.VALUESET_TOO_COSTLY, vsSrc.getUrl(), ">" + Integer.toString(expand.getContains().size())));
      for (ValueSetExpansionParameterComponent p : expand.getParameter()) {
        if (!existsInParams(params, p.getName(), p.getValue()))
          params.add(p);
      }

      copyImportContains(expand.getContains(), null, expParams, filters, noInactive, vsProps, vsSrc);
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
      throw fail("Processing Value set references in exclude is not yet done in "+ctxt);
    // importValueSet(imp.getValue(), params, expParams);

    CodeSystem cs = context.fetchSupplementedCodeSystem(exc.getSystem());
    if ((cs == null || cs.getContent() != CodeSystemContentMode.COMPLETE) && context.supportsSystem(exc.getSystem())) {
      ValueSetExpansionOutcome vse = context.expandVS(exc, false, false);
      ValueSet valueset = vse.getValueset();
      if (valueset == null)
        throw failTSE("Error Expanding ValueSet: "+vse.getError());
      excludeCodes(valueset.getExpansion(), params);
      return;
    }

    for (ConceptReferenceComponent c : exc.getConcept()) {
      excludeCode(exc.getSystem(), c.getCode());
    }

    if (exc.getFilter().size() > 0)
      throw fail("not done yet - multiple filters");
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
    allErrors.clear();
    try {
      return expandInternal(source, expParams);
    } catch (NoTerminologyServiceException e) {
      // well, we couldn't expand, so we'll return an interface to a checker that can check membership of the set
      // that might fail too, but it might not, later.
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.NOSERVICE, allErrors);
    } catch (CodeSystemProviderExtension e) {
      // well, we couldn't expand, so we'll return an interface to a checker that can check membership of the set
      // that might fail too, but it might not, later.
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.INTERNAL_ERROR, allErrors);
    } catch (ETooCostly e) {
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.TOO_COSTLY, allErrors);
    } catch (Exception e) {
      // well, we couldn't expand, so we'll return an interface to a checker that can check membership of the set
      // that might fail too, but it might not, later.
      return new ValueSetExpansionOutcome(e.getMessage(), TerminologyServiceErrorClass.UNKNOWN, allErrors);
    }
  }
  
  public ValueSetExpansionOutcome expandInternal(ValueSet source, Parameters expParams) throws FHIRException, FileNotFoundException, ETooCostly, IOException, CodeSystemProviderExtension {
      return doExpand(source, expParams);
  }

  public ValueSetExpansionOutcome doExpand(ValueSet source, Parameters expParams) throws FHIRException, ETooCostly, FileNotFoundException, IOException, CodeSystemProviderExtension {
    if (expParams == null)
      expParams = makeDefaultExpansion();
    source.checkNoModifiers("ValueSet", "expanding");
    focus = source.copy();
    focus.setIdBase(null);
    focus.setExpansion(new ValueSet.ValueSetExpansionComponent());
    focus.getExpansion().setTimestampElement(DateTimeType.now());
    focus.getExpansion().setIdentifier(Factory.createUUID()); 
    for (ParametersParameterComponent p : expParams.getParameter()) {
      if (Utilities.existsInList(p.getName(), "includeDesignations", "excludeNested", "activeOnly", "offset", "count")) {
        focus.getExpansion().addParameter().setName(p.getName()).setValue(p.getValue());
      }
      if ("displayLanguage".equals(p.getName()) && (!expParams.hasLanguage() || !expParams.getLanguage().equals(p.getValue().primitiveValue()))) {
        focus.getExpansion().addParameter().setName(p.getName()).setValue(p.getValue());
      }
      if ("offset".equals(p.getName()) && p.hasValueIntegerType()) {
        offset = p.getValueIntegerType().getValue();
        if (offset < 0) {
          offset = 0;
        }
      }
      if ("count".equals(p.getName()) && p.hasValueIntegerType()) {
        count = p.getValueIntegerType().getValue();
        if (count < 0) {
          count = 0;
        }
      }
    }
    for (Extension s : focus.getExtensionsByUrl(ExtensionConstants.EXT_VSSUPPLEMENT)) {
      requiredSupplements.add(s.getValue().primitiveValue());
    }
    if (expParams.hasLanguage()) {
      focus.setLanguage(expParams.getLanguage());
    }
    

    try {
      if (source.hasCompose()) {
        ExtensionsUtils.stripExtensions(focus.getCompose());
        handleCompose(source.getCompose(), focus.getExpansion(), expParams, source.getUrl(), focus.getExpansion().getExtension(), source);
      }
    } catch (EFinished e) {
      // nothing - we intended to trap this here
    }

    if (canBeHeirarchy) {
      for (ValueSetExpansionContainsComponent c : roots) {
        focus.getExpansion().getContains().add(c);
      }
    } else {
      int i = 0;
      int cc = 0;
      for (ValueSetExpansionContainsComponent c : codes) {
        if (map.containsKey(key(c)) && (includeAbstract || !c.getAbstract())) { // we may have added abstract codes earlier while we still thought it might be heirarchical, but later we gave up, so now ignore them
          if (offset == 0 || i >= offset) {
            focus.getExpansion().getContains().add(c);
            c.getContains().clear(); // make sure any heirarchy is wiped
            cc++;
            if (cc == count) {
              break;
            }
          }
          i++;
        }
      }
    }

    if (total >= 0) {
      focus.getExpansion().setTotal(total);
    }
    if (!requiredSupplements.isEmpty()) {
      return new ValueSetExpansionOutcome("Required supplements not found: "+requiredSupplements.toString(), TerminologyServiceErrorClass.BUSINESS_RULE, allErrors);
    }
    if (!expParams.hasParameter("includeDefinition") || !expParams.getParameterBool("includeDefinition")) {
      focus.setCompose(null);
      focus.getExtension().clear();
      focus.setPublisher(null);
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
      excludeCodes(inc, exp.getParameter(), ctxt);
    canBeHeirarchy = !expParams.getParameterBool("excludeNested") && excludeKeys.isEmpty() && excludeSystems.isEmpty() && offset+count == 0;
    includeAbstract = !expParams.getParameterBool("excludeNotForUI");
    boolean first = true;
    for (ConceptSetComponent inc : compose.getInclude()) {
      if (first == true)
        first = false;
      else
        canBeHeirarchy = false;
      includeCodes(inc, exp, expParams, canBeHeirarchy, compose.hasInactive() ? !compose.getInactive() : checkNoInActiveFromParam(expParams), extensions, valueSet);
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

  private ValueSet importValueSet(String value, ValueSetExpansionComponent exp, Parameters expParams, boolean noInactive, ValueSet valueSet) throws ETooCostly, TerminologyServiceException, FileNotFoundException, IOException, FHIRFormatError {
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
    if (noInactive) {
      expParams = expParams.copy();
      expParams.addParameter("activeOnly", true);
    }
    ValueSetExpansionOutcome vso = new ValueSetExpanderSimple(context, allErrors).expand(vs, expParams);
    if (vso.getError() != null) {
      addErrors(vso.getAllErrors());
      throw fail("Unable to expand imported value set "+vs.getUrl()+": " + vso.getError());
    }
    if (vs.hasVersion() || REPORT_VERSION_ANYWAY) {
      UriType u = new UriType(vs.getUrl() + (vs.hasVersion() ? "|"+vs.getVersion() : ""));
      if (!existsInParams(exp.getParameter(), "version", u))
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("version").setValue(u));
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
      copyExpansion(vso.getValueset().getExpansion().getContains());
    }
    canBeHeirarchy = false; // if we're importing a value set, we have to be combining, so we won't try for a heirarchy
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

  public void copyExpansion(List<ValueSetExpansionContainsComponent> list) {
    for (ValueSetExpansionContainsComponent cc : list) {
       ValueSetExpansionContainsComponent n = new ValueSet.ValueSetExpansionContainsComponent();
       n.setSystem(cc.getSystem());
       n.setCode(cc.getCode());
       n.setAbstract(cc.getAbstract());
       n.setInactive(cc.getInactive());
       n.setDisplay(cc.getDisplay());
       n.getDesignation().addAll(cc.getDesignation());

       String s = key(n);
       if (!map.containsKey(s) && !excludeKeys.contains(s)) {
         codes.add(n);
         map.put(s, n);
         total++;
       }
       copyExpansion(cc.getContains());
    }
  }

  private void addErrors(List<String> errs) {
    for (String s : errs) {
      if (!allErrors.contains(s)) {
        allErrors.add(s);
      }
    }
  }

  private void copyImportContains(List<ValueSetExpansionContainsComponent> list, ValueSetExpansionContainsComponent parent, Parameters expParams, List<ValueSet> filter, boolean noInactive, List<ValueSetExpansionPropertyComponent> vsProps, ValueSet vsSrc) throws FHIRException, ETooCostly {
    for (ValueSetExpansionContainsComponent c : list) {
      c.checkNoModifiers("Imported Expansion in Code System", "expanding");
      ValueSetExpansionContainsComponent np = addCode(c.getSystem(), c.getCode(), c.getDisplay(), vsSrc.getLanguage(), parent, null, expParams, c.getAbstract(), c.getInactive(), c.getExtensionString(ToolingExtensions.EXT_DEFINITION), 
          filter, noInactive, false, vsProps, null, c.getProperty(), null, c.getExtension());
      copyImportContains(c.getContains(), np, expParams, filter, noInactive, vsProps, vsSrc);
    }
  }

  private void includeCodes(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, boolean heirarchical, boolean noInactive, List<Extension> extensions, ValueSet valueSet) throws ETooCostly, FileNotFoundException, IOException, FHIRException, CodeSystemProviderExtension {
    inc.checkNoModifiers("Compose.include", "expanding");
    List<ValueSet> imports = new ArrayList<ValueSet>();
    for (CanonicalType imp : inc.getValueSet()) {
      imports.add(importValueSet(imp.getValue(), exp, expParams, noInactive, valueSet));
    }

    if (!inc.hasSystem()) {
      if (imports.isEmpty()) // though this is not supposed to be the case
        return;
      ValueSet base = imports.get(0);
      imports.remove(0);
      base.checkNoModifiers("Imported ValueSet", "expanding");
      copyImportContains(base.getExpansion().getContains(), null, expParams, imports, noInactive, base.getExpansion().getProperty(), base);
    } else {
      CodeSystem cs = context.fetchSupplementedCodeSystem(inc.getSystem());
      if (isServerSide(inc.getSystem()) || (cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT))) {
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
      if (!existsInParams(exp.getParameter(), "version", u)) {
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("version").setValue(u));
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
      addCodeAndDescendents(cc, null, expParams, imports, noInactive, vsProps, vs);
    }
  }


  public void doInternalIncludeCodes(ConceptSetComponent inc, ValueSetExpansionComponent exp, Parameters expParams, List<ValueSet> imports, CodeSystem cs, boolean noInactive, Resource vsSrc) throws NoTerminologyServiceException, TerminologyServiceException, FHIRException, ETooCostly {
    if (cs == null) {
      if (context.isNoTerminologyServer())
        throw failTSE("Unable to find code system " + inc.getSystem().toString());
      else
        throw failTSE("Unable to find code system " + inc.getSystem().toString());
    }
    cs.checkNoModifiers("Code System", "expanding");
    if (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT)
      throw failTSE("Code system " + inc.getSystem().toString() + " is incomplete");
    if (cs.hasVersion() || REPORT_VERSION_ANYWAY) {
      UriType u = new UriType(cs.getUrl() + (cs.hasVersion() ? "|"+cs.getVersion() : ""));
      if (!existsInParams(exp.getParameter(), "version", u))
        exp.getParameter().add(new ValueSetExpansionParameterComponent().setName("version").setValue(u));
    }
    if (inc.getConcept().size() == 0 && inc.getFilter().size() == 0) {
      // special case - add all the code system
      for (ConceptDefinitionComponent def : cs.getConcept()) {
        addCodeAndDescendents(cs, inc.getSystem(), def, null, expParams, imports, null, new AllConceptsFilter(), noInactive, exp.getProperty());
      }
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        addFragmentWarning(exp, cs);
      }
      if (cs.getContent() == CodeSystemContentMode.EXAMPLE) {
        addExampleWarning(exp, cs);
      }      
    }

    if (!inc.getConcept().isEmpty()) {
      canBeHeirarchy = false;
      for (ConceptReferenceComponent c : inc.getConcept()) {
        c.checkNoModifiers("Code in Value Set", "expanding");
        ConceptDefinitionComponent def = CodeSystemUtilities.findCode(cs.getConcept(), c.getCode());
        boolean inactive = false; // default is true if we're a fragment and  
        boolean isAbstract = false;
        if (def == null) {
          def.checkNoModifiers("Code in Code System", "expanding");
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
          inactive = CodeSystemUtilities.isInactive(cs, def);
          isAbstract = CodeSystemUtilities.isNotSelectable(cs, def);
        }
        addCode(inc.getSystem(), c.getCode(), !Utilities.noString(c.getDisplay()) ? c.getDisplay() : def == null ? null : def.getDisplay(), c.hasDisplay() ? vsSrc.getLanguage() : cs.getLanguage(), null, mergeDesignations(def, convertDesignations(c.getDesignation())), 
            expParams, isAbstract, inactive, def == null ? null : def.getDefinition(), imports, noInactive, false, exp.getProperty(), def != null ? def.getProperty() : null, null, def == null ? null : def.getExtension(), c.getExtension());
      }
    }
    if (inc.getFilter().size() > 1) {
      canBeHeirarchy = false; // which will bt the case if we get around to supporting this
      throw failTSE("Multiple filters not handled yet"); // need to and them, and this isn't done yet. But this shouldn't arise in non loinc and snomed value sets
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
          throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
        addCodeAndDescendents(cs, inc.getSystem(), def, null, expParams, imports, null, new AllConceptsFilter(), noInactive, exp.getProperty());
      } else if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.ISNOTA) {
        // special: all codes in the target code system that are not under the value
        ConceptDefinitionComponent defEx = getConceptForCode(cs.getConcept(), fc.getValue());
        if (defEx == null)
          throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
        for (ConceptDefinitionComponent def : cs.getConcept()) {
          addCodeAndDescendents(cs, inc.getSystem(), def, null, expParams, imports, defEx, new AllConceptsFilter(), noInactive, exp.getProperty());
        }
      } else if ("concept".equals(fc.getProperty()) && fc.getOp() == FilterOperator.DESCENDENTOF) {
        // special: all codes in the target code system under the value
        ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
        if (def == null)
          throw failTSE("Code '" + fc.getValue() + "' not found in system '" + inc.getSystem() + "'");
        for (ConceptDefinitionComponent c : def.getConcept())
          addCodeAndDescendents(cs, inc.getSystem(), c, null, expParams, imports, null, new AllConceptsFilter(), noInactive, exp.getProperty());
        if (def.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
          List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) def.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
          for (ConceptDefinitionComponent c : children)
            addCodeAndDescendents(cs, inc.getSystem(), c, null, expParams, imports, null, new AllConceptsFilter(), noInactive, exp.getProperty());
        }

      } else if ("display".equals(fc.getProperty()) && fc.getOp() == FilterOperator.EQUAL) {
        // gg; note: wtf is this: if the filter is display=v, look up the code 'v', and see if it's diplsay is 'v'?
        canBeHeirarchy = false;
        ConceptDefinitionComponent def = getConceptForCode(cs.getConcept(), fc.getValue());
        if (def != null) {
          if (isNotBlank(def.getDisplay()) && isNotBlank(fc.getValue())) {
            if (def.getDisplay().contains(fc.getValue())) {
              addCode(inc.getSystem(), def.getCode(), def.getDisplay(), cs.getLanguage(), null, def.getDesignation(), expParams, CodeSystemUtilities.isNotSelectable(cs, def), CodeSystemUtilities.isInactive(cs, def),
                 def.getDefinition(), imports, noInactive, false, exp.getProperty(), def.getProperty(), null, def.getExtension(), null);
            }
          }
        }
      } else if (isDefinedProperty(cs, fc.getProperty())) {
        for (ConceptDefinitionComponent def : cs.getConcept()) {
          addCodeAndDescendents(cs, inc.getSystem(), def, null, expParams, imports, null, new PropertyFilter(fc, getPropertyDefinition(cs, fc.getProperty())), noInactive, exp.getProperty());
        }
      } else if ("code".equals(fc.getProperty()) && fc.getOp() == FilterOperator.REGEX) {
        for (ConceptDefinitionComponent def : cs.getConcept()) {
          addCodeAndDescendents(cs, inc.getSystem(), def, null, expParams, imports, null, new RegexFilter(fc.getValue()), noInactive, exp.getProperty());
        }
      } else {
        throw fail("Search by property[" + fc.getProperty() + "] and op[" + fc.getOp() + "] is not supported yet");
      }
    }
  }

  private List<ConceptDefinitionDesignationComponent> mergeDesignations(ConceptDefinitionComponent def,
      List<ConceptDefinitionDesignationComponent> list) {
    List<ConceptDefinitionDesignationComponent> res = new ArrayList<>();
    res.addAll(def.getDesignation());
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

}