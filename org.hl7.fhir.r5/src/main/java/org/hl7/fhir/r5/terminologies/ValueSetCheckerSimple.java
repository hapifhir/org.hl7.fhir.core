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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.validation.ValidationOptions.ValueSetMode;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;

public class ValueSetCheckerSimple implements ValueSetChecker {

  private ValueSet valueset;
  private IWorkerContext context;
  private Map<String, ValueSetCheckerSimple> inner = new HashMap<>();
  private ValidationOptions options;

  public ValueSetCheckerSimple(ValidationOptions options, ValueSet source, IWorkerContext context) {
    this.valueset = source;
    this.context = context;
    this.options = options;
  }

  public ValidationResult validateCode(CodeableConcept code) throws FHIRException {
    // first, we validate the codings themselves
    List<String> errors = new ArrayList<String>();
    List<String> warnings = new ArrayList<String>();
    if (options.getValueSetMode() != ValueSetMode.CHECK_MEMERSHIP_ONLY) {
      for (Coding c : code.getCoding()) {
        if (!c.hasSystem())
          warnings.add(context.formatMessage(I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE));
        CodeSystem cs = context.fetchCodeSystem(c.getSystem());
        ValidationResult res = null;
        if (cs == null || cs.getContent() != CodeSystemContentMode.COMPLETE) {
          res = context.validateCode(options.noClient(), c, null);
        } else {
          res = validateCode(c, cs);
        }
        if (!res.isOk())
          errors.add(res.getMessage());
        else if (res.getMessage() != null)
          warnings.add(res.getMessage());
      }
    }
    if (valueset != null && options.getValueSetMode() != ValueSetMode.NO_MEMBERSHIP_CHECK) {
      boolean ok = false;
      for (Coding c : code.getCoding()) {
        ok = ok || codeInValueSet(c.getSystem(), c.getCode());
      }
      if (!ok)
        errors.add(0, context.formatMessage(I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getUrl()));
    }
    if (errors.size() > 0)
      return new ValidationResult(IssueSeverity.ERROR, errors.toString());
    else if (warnings.size() > 0)
      return new ValidationResult(IssueSeverity.WARNING, warnings.toString());
    else 
      return new ValidationResult(IssueSeverity.INFORMATION, null);
  }

  public ValidationResult validateCode(Coding code) throws FHIRException {
    String warningMessage = null;
    // first, we validate the concept itself

    ValidationResult res =null;
    boolean inExpansion = false;
    String system = code.hasSystem() ? code.getSystem() : getValueSetSystem();
    if (options.getValueSetMode() != ValueSetMode.CHECK_MEMERSHIP_ONLY) {
      if (system == null && !code.hasDisplay()) { // dealing with just a plain code (enum)
        system = systemForCodeInValueSet(code.getCode());
      }
      if (!code.hasSystem()) {
        if (options.isGuessSystem() && system == null && Utilities.isAbsoluteUrl(code.getCode())) {
          system = "urn:ietf:rfc:3986"; // this arises when using URIs bound to value sets
        }
        code.setSystem(system);
      }
      inExpansion = checkExpansion(code);
      CodeSystem cs = context.fetchCodeSystem(system);
      if (cs == null) {
        cs = findSpecialCodeSystem(system);
      }
      if (cs == null) {
        warningMessage = "Unable to resolve system "+system+" - system is not specified or implicit";
        if (!inExpansion)
          throw new FHIRException(warningMessage);
      }
      if (cs!=null && cs.getContent() != CodeSystemContentMode.COMPLETE) {
        warningMessage = "Unable to resolve system "+system+" - system is not complete";
        if (!inExpansion && cs.getContent() != CodeSystemContentMode.FRAGMENT) // we're going to give it a go if it's a fragment
          throw new FHIRException(warningMessage);
      }

      if (cs!=null)
        res = validateCode(code, cs);
    } else {
      inExpansion = checkExpansion(code);
    }

    // then, if we have a value set, we check it's in the value set
    if (valueset != null && options.getValueSetMode() != ValueSetMode.NO_MEMBERSHIP_CHECK) {
      if ((res==null || res.isOk()) && !codeInValueSet(system, code.getCode())) {
        if (!inExpansion)
          res.setMessage("Not in value set "+valueset.getUrl()).setSeverity(IssueSeverity.ERROR);
        else if (warningMessage!=null)
          res = new ValidationResult(IssueSeverity.WARNING, context.formatMessage(I18nConstants.CODE_FOUND_IN_EXPANSION_HOWEVER_, warningMessage));
        else
          res.setMessage("Code found in expansion, however: " + res.getMessage());
      }
    }
    return res;
  }

  private CodeSystem findSpecialCodeSystem(String system) {
    if ("urn:ietf:rfc:3986".equals(system)) {
      CodeSystem cs = new CodeSystem();
      cs.setUrl(system);
      cs.setUserData("tx.cs.special", new URICodeSystem());
      cs.setContent(CodeSystemContentMode.COMPLETE);
      return cs; 
    }
    return null;
  }

  boolean checkExpansion(Coding code) {
    if (valueset==null || !valueset.hasExpansion())
      return false;
    return checkExpansion(code, valueset.getExpansion().getContains());
  }

  boolean checkExpansion(Coding code, List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent containsComponent: contains) {
      if (containsComponent.getSystem().equals(code.getSystem()) && containsComponent.getCode().equals(code.getCode()))
        return true;
      if (containsComponent.hasContains() && checkExpansion(code, containsComponent.getContains()))
        return true;
    }
    return false;
  }

  private ValidationResult validateCode(Coding code, CodeSystem cs) {
    ConceptDefinitionComponent cc = cs.hasUserData("tx.cs.special") ? ((SpecialCodeSystem) cs.getUserData("tx.cs.special")).findConcept(code) : findCodeInConcept(cs.getConcept(), code.getCode());
    if (cc == null) {
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        return new ValidationResult(IssueSeverity.ERROR, context.formatMessage(I18nConstants.UNKNOWN_CODE__IN_FRAGMENT, gen(code), cs.getUrl()));        
      } else {
        return new ValidationResult(IssueSeverity.ERROR, context.formatMessage(I18nConstants.UNKNOWN_CODE__IN_, gen(code), cs.getUrl()));
      }
    }
    if (code.getDisplay() == null)
      return new ValidationResult(cc);
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (cc.hasDisplay()) {
      b.append(cc.getDisplay());
      if (code.getDisplay().equalsIgnoreCase(cc.getDisplay()))
        return new ValidationResult(cc);
    }
    for (ConceptDefinitionDesignationComponent ds : cc.getDesignation()) {
      b.append(ds.getValue());
      if (code.getDisplay().equalsIgnoreCase(ds.getValue()))
        return new ValidationResult(cc);
    }
    // also check to see if the value set has another display
    ConceptReferenceComponent vs = findValueSetRef(code.getSystem(), code.getCode());
    if (vs != null && (vs.hasDisplay() ||vs.hasDesignation())) {
      if (vs.hasDisplay()) {
        b.append(vs.getDisplay());
        if (code.getDisplay().equalsIgnoreCase(vs.getDisplay()))
          return new ValidationResult(cc);
      }
      for (ConceptReferenceDesignationComponent ds : vs.getDesignation()) {
        b.append(ds.getValue());
        if (code.getDisplay().equalsIgnoreCase(ds.getValue()))
          return new ValidationResult(cc);
      }
    }
    return new ValidationResult(IssueSeverity.WARNING, context.formatMessage(I18nConstants.DISPLAY_NAME_FOR__SHOULD_BE_ONE_OF__INSTEAD_OF_, code.getSystem(), code.getCode(), b.toString(), code.getDisplay()), cc);
  }

  private ConceptReferenceComponent findValueSetRef(String system, String code) {
    if (valueset == null)
      return null;
    // if it has an expansion
    for (ValueSetExpansionContainsComponent exp : valueset.getExpansion().getContains()) {
      if (system.equals(exp.getSystem()) && code.equals(exp.getCode())) {
        ConceptReferenceComponent cc = new ConceptReferenceComponent();
        cc.setDisplay(exp.getDisplay());
        cc.setDesignation(exp.getDesignation());
        return cc;
      }
    }
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (system.equals(inc.getSystem())) {
        for (ConceptReferenceComponent cc : inc.getConcept()) {
          if (cc.getCode().equals(code))
            return cc;
        }
      }
      for (CanonicalType url : inc.getValueSet()) {
        ConceptReferenceComponent cc = getVs(url.asStringValue()).findValueSetRef(system, code);
        if (cc != null)
          return cc;
      }
    }
    return null;
  }

  private String gen(Coding code) {
    if (code.hasSystem())
      return code.getSystem()+"#"+code.getCode();
    else
      return null;
  }

  private String getValueSetSystem() throws FHIRException {
    if (valueset == null)
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__NO_VALUE_SET));
    if (valueset.getCompose().getInclude().size() == 0) {
      if (!valueset.hasExpansion() || valueset.getExpansion().getContains().size() == 0)
        throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_NO_INCLUDES_OR_EXPANSION));
      else {
        String cs = valueset.getExpansion().getContains().get(0).getSystem();
        if (cs != null && checkSystem(valueset.getExpansion().getContains(), cs))
          return cs;
        else
          throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_EXPANSION_HAS_MULTIPLE_SYSTEMS));
      }
    }
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (inc.hasValueSet())
        throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_IMPORTS));
      if (!inc.hasSystem())
        throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_NO_SYSTEM));
    }
    if (valueset.getCompose().getInclude().size() == 1)
      return valueset.getCompose().getInclude().get(0).getSystem();
    
    return null;
  }

  /*
   * Check that all system values within an expansion correspond to the specified system value
   */
  private boolean checkSystem(List<ValueSetExpansionContainsComponent> containsList, String system) {
    for (ValueSetExpansionContainsComponent contains : containsList) {
      if (!contains.getSystem().equals(system) || (contains.hasContains() && !checkSystem(contains.getContains(), system)))
        return false;
    }
    return true;
  }
  private ConceptDefinitionComponent findCodeInConcept(List<ConceptDefinitionComponent> concept, String code) {
    for (ConceptDefinitionComponent cc : concept) {
      if (code.equals(cc.getCode()))
        return cc;
      ConceptDefinitionComponent c = findCodeInConcept(cc.getConcept(), code);
      if (c != null)
        return c;
    }
    return null;
  }

  
  private String systemForCodeInValueSet(String code) {
    String sys = null;
    if (valueset.hasCompose()) {
      if (valueset.getCompose().hasExclude())
        return null;
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        if (vsi.hasValueSet())
          return null;
        if (!vsi.hasSystem()) 
          return null;
        if (vsi.hasFilter())
          return null;
        CodeSystem cs = context.fetchCodeSystem(vsi.getSystem());
        if (cs == null)
          return null;
        if (vsi.hasConcept()) {
          for (ConceptReferenceComponent cc : vsi.getConcept()) {
            boolean match = cs.getCaseSensitive() ? cc.getCode().equals(code) : cc.getCode().equalsIgnoreCase(code);
            if (match) {
              if (sys == null)
                sys = vsi.getSystem();
              else if (!sys.equals(vsi.getSystem()))
                return null;
            }
          }
        } else {
          ConceptDefinitionComponent cc = findCodeInConcept(cs.getConcept(), code);
          if (cc != null) {
            if (sys == null)
              sys = vsi.getSystem();
            else if (!sys.equals(vsi.getSystem()))
              return null;
          }
        }
      }
    }
    
    return sys;  
  }
  
  @Override
  public boolean codeInValueSet(String system, String code) throws FHIRException {
    if (valueset.hasExpansion()) {
      return checkExpansion(new Coding(system, code, null));
    } else if (valueset.hasCompose()) {
      boolean ok = false;
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        ok = ok || inComponent(vsi, system, code, valueset.getCompose().getInclude().size() == 1);
      }
      for (ConceptSetComponent vsi : valueset.getCompose().getExclude()) {
        ok = ok && !inComponent(vsi, system, code, valueset.getCompose().getInclude().size() == 1);
      }
      return ok;
    } 
    
    return false;
  }

  private boolean inComponent(ConceptSetComponent vsi, String system, String code, boolean only) throws FHIRException {
    for (UriType uri : vsi.getValueSet()) {
      if (inImport(uri.getValue(), system, code))
        return true;
    }

    if (!vsi.hasSystem())
      return false;
    
    if (only && system == null) {
      // whether we know the system or not, we'll accept the stated codes at face value
      for (ConceptReferenceComponent cc : vsi.getConcept())
        if (cc.getCode().equals(code)) 
          return true;
    }
    
    if (!system.equals(vsi.getSystem()))
      return false;
    // ok, we need the code system
    CodeSystem cs = context.fetchCodeSystem(system);
    if (cs == null || cs.getContent() != CodeSystemContentMode.COMPLETE) {
      // make up a transient value set with
      ValueSet vs = new ValueSet();
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.setUrl(Utilities.makeUuidUrn());
      vs.getCompose().addInclude(vsi);
      ValidationResult res = context.validateCode(options.noClient(), new Coding(system, code, null), vs);
      return res.isOk();
    } else {
      if (vsi.hasFilter()) {
        boolean ok = true;
        for (ConceptSetFilterComponent f : vsi.getFilter())
          if (!codeInFilter(cs, system, f, code)) {
            ok = false;
            break;
          }
        if (ok)
          return true;
      }
      
      List<ConceptDefinitionComponent> list = cs.getConcept();
      boolean ok = validateCodeInConceptList(code, cs, list);
      if (ok && vsi.hasConcept()) {
        for (ConceptReferenceComponent cc : vsi.getConcept())
          if (cc.getCode().equals(code)) 
            return true;
        return false;
      } else
        return ok;
    }
  }

  private boolean codeInFilter(CodeSystem cs, String system, ConceptSetFilterComponent f, String code) throws FHIRException {
    if ("concept".equals(f.getProperty()))
      return codeInConceptFilter(cs, f, code);
    else {
      System.out.println("todo: handle filters with property = "+f.getProperty()); 
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__FILTER_WITH_PROPERTY__, cs.getUrl(), f.getProperty()));
    }
  }

  private boolean codeInConceptFilter(CodeSystem cs, ConceptSetFilterComponent f, String code) throws FHIRException {
    switch (f.getOp()) {
    case ISA: return codeInConceptIsAFilter(cs, f, code);
    case ISNOTA: return !codeInConceptIsAFilter(cs, f, code);
    default:
      System.out.println("todo: handle concept filters with op = "+f.getOp()); 
        throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__CONCEPT_FILTER_WITH_OP__, cs.getUrl(), f.getOp()));
    }
  }

  private boolean codeInConceptIsAFilter(CodeSystem cs, ConceptSetFilterComponent f, String code) {
    if (code.equals(f.getProperty()))
      return true;
   ConceptDefinitionComponent cc = findCodeInConcept(cs.getConcept(), f.getValue());
   if (cc == null)
     return false;
   cc = findCodeInConcept(cc.getConcept(), code);
   return cc != null;
  }

  public boolean validateCodeInConceptList(String code, CodeSystem def, List<ConceptDefinitionComponent> list) {
    if (def.getCaseSensitive()) {
      for (ConceptDefinitionComponent cc : list) {
        if (cc.getCode().equals(code)) 
          return true;
        if (cc.hasConcept() && validateCodeInConceptList(code, def, cc.getConcept()))
          return true;
      }
    } else {
      for (ConceptDefinitionComponent cc : list) {
        if (cc.getCode().equalsIgnoreCase(code)) 
          return true;
        if (cc.hasConcept() && validateCodeInConceptList(code, def, cc.getConcept()))
          return true;
      }
    }
    return false;
  }

  private ValueSetCheckerSimple getVs(String url) {
    if (inner.containsKey(url)) {
      return inner.get(url);
    }
    ValueSet vs = context.fetchResource(ValueSet.class, url);
    ValueSetCheckerSimple vsc = new ValueSetCheckerSimple(options, vs, context);
    inner.put(url, vsc);
    return vsc;
  }
  
  private boolean inImport(String uri, String system, String code) throws FHIRException {
    return getVs(uri).codeInValueSet(system, code);
  }

}