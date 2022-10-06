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
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.NoTerminologyServiceException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.PackageDetails;
import org.hl7.fhir.r5.context.IWorkerContext.PackageVersion;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.ValueSetChecker.ValidationProcessInfo;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier.ValidationContextResourceProxy;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.PackageInfo;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.validation.ValidationOptions.ValueSetMode;

public class ValueSetCheckerSimple extends ValueSetWorker implements ValueSetChecker {

  private ValueSet valueset;
  private IWorkerContext context;
  private Map<String, ValueSetCheckerSimple> inner = new HashMap<>();
  private ValidationOptions options;
  private ValidationContextCarrier localContext;
  private List<CodeSystem> localSystems = new ArrayList<>();

  public ValueSetCheckerSimple(ValidationOptions options, ValueSet source, IWorkerContext context) {
    this.valueset = source;
    this.context = context;
    this.options = options;
  }
  
  public ValueSetCheckerSimple(ValidationOptions options, ValueSet source, IWorkerContext context, ValidationContextCarrier ctxt) {
    this.valueset = source;
    this.context = context;
    this.options = options;
    this.localContext = ctxt;
    analyseValueSet();
  }

  private void analyseValueSet() {
    if (localContext != null) {
      if (valueset != null) {
        for (ConceptSetComponent i : valueset.getCompose().getInclude()) {
          analyseComponent(i);
        }
        for (ConceptSetComponent i : valueset.getCompose().getExclude()) {
          analyseComponent(i);
        }
      }
    }
  }

  private void analyseComponent(ConceptSetComponent i) {
    if (i.getSystemElement().hasExtension(ToolingExtensions.EXT_VALUESET_SYSTEM)) {
      String ref = i.getSystemElement().getExtensionString(ToolingExtensions.EXT_VALUESET_SYSTEM);
      if (ref.startsWith("#")) {
        String id = ref.substring(1);
        for (ValidationContextResourceProxy t : localContext.getResources()) {
          CodeSystem cs = (CodeSystem) t.loadContainedResource(id, CodeSystem.class);
          if (cs != null) {
            localSystems.add(cs);
          }
        }
      } else {        
        throw new Error("Not done yet #2: "+ref);
      }
    }    
  }

  public ValidationResult validateCode(CodeableConcept code) throws FHIRException {
    // first, we validate the codings themselves
    List<String> errors = new ArrayList<String>();
    ValidationProcessInfo info = new ValidationProcessInfo();
    if (options.getValueSetMode() != ValueSetMode.CHECK_MEMERSHIP_ONLY) {
      for (Coding c : code.getCoding()) {
        if (!c.hasSystem()) {
          info.getWarnings().add(context.formatMessage(I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE));
        }
        CodeSystem cs = resolveCodeSystem(c.getSystem());
        ValidationResult res = null;
        if (cs == null || cs.getContent() != CodeSystemContentMode.COMPLETE) {
          res = context.validateCode(options.noClient(), c, null);
        } else {
          res = validateCode(c, cs);
        }
        if (!res.isOk()) {
          errors.add(res.getMessage());
        } else if (res.getMessage() != null) {
          info.getWarnings().add(res.getMessage());
        }
      }
    }
    Coding foundCoding = null;
    if (valueset != null && options.getValueSetMode() != ValueSetMode.NO_MEMBERSHIP_CHECK) {
      Boolean result = false;
      for (Coding c : code.getCoding()) {
        Boolean ok = codeInValueSet(c.getSystem(), c.getCode(), info);
        if (ok == null && result == false) {
          result = null;
        } else if (ok) {
          result = true;
          foundCoding = c;
        }
      }
      if (result == null) {
        info.getWarnings().add(0, context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getUrl()));        
      } else if (!result) {
        errors.add(0, context.formatMessage(I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getUrl()));
      }
    }
    if (errors.size() > 0) {
      return new ValidationResult(IssueSeverity.ERROR, errors.toString());
    } else if (info.getWarnings().size() > 0) {
      return new ValidationResult(IssueSeverity.WARNING, info.getWarnings().toString());
    } else {
      ConceptDefinitionComponent cd = new ConceptDefinitionComponent(foundCoding.getCode());
      cd.setDisplay(foundCoding.getDisplay());
      return new ValidationResult(foundCoding.getSystem(), cd);
    }
  }

  public CodeSystem resolveCodeSystem(String system) {
    for (CodeSystem t : localSystems) {
      if (t.getUrl().equals(system)) {
        return t;
      }
    }
    CodeSystem cs = context.fetchCodeSystem(system);
    if (cs == null) {
      cs = findSpecialCodeSystem(system);
    }
    return cs;
  }

  public ValidationResult validateCode(Coding code) throws FHIRException {
    String warningMessage = null;
    // first, we validate the concept itself

    ValidationResult res = null;
    boolean inExpansion = false;
    boolean inInclude = false;
    String system = code.hasSystem() ? code.getSystem() : getValueSetSystemOrNull();
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
      inInclude = checkInclude(code);
      CodeSystem cs = resolveCodeSystem(system);
      if (cs == null) {
        warningMessage = "Unable to resolve system "+system;
        if (!inExpansion) {
          if (valueset != null && valueset.hasExpansion()) {
            return new ValidationResult(IssueSeverity.ERROR, context.formatMessage(I18nConstants.CODESYSTEM_CS_UNK_EXPANSION, valueset.getUrl(), code.getCode().toString(), code.getSystem()));
          } else {
            throw new FHIRException(warningMessage);
          }
        }
      }
      if (cs != null && cs.hasSupplements()) {
        return new ValidationResult(IssueSeverity.ERROR, context.formatMessage(I18nConstants.CODESYSTEM_CS_NO_SUPPLEMENT, cs.getUrl()));        
      }
      if (cs!=null && cs.getContent() != CodeSystemContentMode.COMPLETE) {
        warningMessage = "Resolved system "+system+", but the definition is not complete";
        if (!inExpansion && cs.getContent() != CodeSystemContentMode.FRAGMENT) { // we're going to give it a go if it's a fragment
          throw new FHIRException(warningMessage);
        }
      }

      if (cs != null /*&& (cs.getContent() == CodeSystemContentMode.COMPLETE || cs.getContent() == CodeSystemContentMode.FRAGMENT)*/) {
        if (!(cs.getContent() == CodeSystemContentMode.COMPLETE || cs.getContent() == CodeSystemContentMode.FRAGMENT)) {
          // we can't validate that here. 
          throw new FHIRException("Unable to evaluate based on empty code system");
        }
        res = validateCode(code, cs);
      } else if (cs == null && valueset.hasExpansion() && inExpansion) {
        // we just take the value set as face value then
        res = new ValidationResult(system, new ConceptDefinitionComponent().setCode(code.getCode()).setDisplay(code.getDisplay()));
      } else {
        // well, we didn't find a code system - try the expansion? 
        // disabled waiting for discussion
        throw new FHIRException("No try the server");
      }
    } else {
      inExpansion = checkExpansion(code);
      inInclude = checkInclude(code);
    }

    ValidationProcessInfo info = new ValidationProcessInfo();
    
    // then, if we have a value set, we check it's in the value set
    if (valueset != null && options.getValueSetMode() != ValueSetMode.NO_MEMBERSHIP_CHECK) {
      if ((res==null || res.isOk())) { 
        Boolean ok = codeInValueSet(system, code.getCode(), info);
        if (ok == null || !ok) {
          if (res == null) {
            res = new ValidationResult((IssueSeverity) null, null);
          }
          if (info.getErr() != null) {
            res.setErrorClass(info.getErr());
          }
          if (ok == null) {
            res.setMessage("Unable to check whether code is in value set "+valueset.getUrl()+": "+info.getWarnings()).setSeverity(IssueSeverity.WARNING);
          } else if (!inExpansion && !inInclude) {
            if (!info.getWarnings().isEmpty()) {
              res.setMessage("Not in value set "+valueset.getUrl()+": "+info.getWarnings()).setSeverity(IssueSeverity.ERROR);              
            } else {
              res.setMessage("Not in value set "+valueset.getUrl()).setSeverity(IssueSeverity.ERROR);
            }
          } else if (warningMessage!=null) {
            res = new ValidationResult(IssueSeverity.WARNING, context.formatMessage(I18nConstants.CODE_FOUND_IN_EXPANSION_HOWEVER_, warningMessage));
          } else if (inExpansion) {
            res.setMessage("Code found in expansion, however: " + res.getMessage());
          } else if (inInclude) {
            res.setMessage("Code found in include, however: " + res.getMessage());
          }
        }
      }
    }
    return res;
  }

  private boolean checkInclude(Coding code) {
    if (valueset == null || code.getSystem() == null || code.getCode() == null) {
      return false;
    }
    for (ConceptSetComponent inc : valueset.getCompose().getExclude()) {
      if (inc.hasSystem() && inc.getSystem().equals(code.getSystem())) {
        for (ConceptReferenceComponent cc : inc.getConcept()) {
          if (cc.hasCode() && cc.getCode().equals(code.getCode())) {
            return false;
          }
        }
      }
    }
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (inc.hasSystem() && inc.getSystem().equals(code.getSystem())) {
        for (ConceptReferenceComponent cc : inc.getConcept()) {
          if (cc.hasCode() && cc.getCode().equals(code.getCode())) {
            return true;
          }
        }
      }
    }
    return false;
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

  private ValidationResult findCodeInExpansion(Coding code) {
    if (valueset==null || !valueset.hasExpansion())
      return null;
    return findCodeInExpansion(code, valueset.getExpansion().getContains());
  }

  private ValidationResult findCodeInExpansion(Coding code, List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent containsComponent: contains) {
      if (containsComponent.getSystem().equals(code.getSystem()) && containsComponent.getCode().equals(code.getCode())) {
        ConceptDefinitionComponent ccd = new ConceptDefinitionComponent();
        ccd.setCode(containsComponent.getCode());
        ccd.setDisplay(containsComponent.getDisplay());
        ValidationResult res = new ValidationResult(code.getSystem(), ccd);
        return res;
      }
      if (containsComponent.hasContains()) {
        ValidationResult res = findCodeInExpansion(code, containsComponent.getContains());
        if (res != null) {
          return res;
        }
      }
    }
    return null;
  }

  private boolean checkExpansion(Coding code) {
    if (valueset==null || !valueset.hasExpansion()) {
      return false;
    }
    return checkExpansion(code, valueset.getExpansion().getContains());
  }

  private boolean checkExpansion(Coding code, List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent containsComponent: contains) {
      if (containsComponent.getSystem().equals(code.getSystem()) && containsComponent.getCode().equals(code.getCode())) {
        return true;
      }
      if (containsComponent.hasContains() && checkExpansion(code, containsComponent.getContains())) {
        return true;
      }
    }
    return false;
  }

  private ValidationResult validateCode(Coding code, CodeSystem cs) {
    ConceptDefinitionComponent cc = cs.hasUserData("tx.cs.special") ? ((SpecialCodeSystem) cs.getUserData("tx.cs.special")).findConcept(code) : findCodeInConcept(cs.getConcept(), code.getCode());
    if (cc == null) {
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        return new ValidationResult(IssueSeverity.WARNING, context.formatMessage(I18nConstants.UNKNOWN_CODE__IN_FRAGMENT, gen(code), cs.getUrl()));        
      } else {
        return new ValidationResult(IssueSeverity.ERROR, context.formatMessage(I18nConstants.UNKNOWN_CODE__IN_, gen(code), cs.getUrl()));
      }
    }
    if (code.getDisplay() == null) {
      return new ValidationResult(code.getSystem(), cc);
    }
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (cc.hasDisplay()) {
      b.append(cc.getDisplay());
      if (code.getDisplay().equalsIgnoreCase(cc.getDisplay())) {
        return new ValidationResult(code.getSystem(), cc);
      }
    }
    for (ConceptDefinitionDesignationComponent ds : cc.getDesignation()) {
      b.append(ds.getValue());
      if (code.getDisplay().equalsIgnoreCase(ds.getValue())) {
        return new ValidationResult(code.getSystem(), cc);
      }
    }
    // also check to see if the value set has another display
    ConceptReferenceComponent vs = findValueSetRef(code.getSystem(), code.getCode());
    if (vs != null && (vs.hasDisplay() ||vs.hasDesignation())) {
      if (vs.hasDisplay()) {
        b.append(vs.getDisplay());
        if (code.getDisplay().equalsIgnoreCase(vs.getDisplay())) {
          return new ValidationResult(code.getSystem(), cc);
        }
      }
      for (ConceptReferenceDesignationComponent ds : vs.getDesignation()) {
        b.append(ds.getValue());
        if (code.getDisplay().equalsIgnoreCase(ds.getValue())) {
          return new ValidationResult(code.getSystem(), cc);
        }
      }
    }
    return new ValidationResult(IssueSeverity.WARNING, context.formatMessage(I18nConstants.DISPLAY_NAME_FOR__SHOULD_BE_ONE_OF__INSTEAD_OF_, code.getSystem(), code.getCode(), b.toString(), code.getDisplay()), code.getSystem(), cc);
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
          if (cc.getCode().equals(code)) {
            return cc;
          }
        }
      }
      for (CanonicalType url : inc.getValueSet()) {
        ConceptReferenceComponent cc = getVs(url.asStringValue()).findValueSetRef(system, code);
        if (cc != null) {
          return cc;
        }
      }
    }
    return null;
  }

  private String gen(Coding code) {
    if (code.hasSystem()) {
      return code.getSystem()+"#"+code.getCode();
    } else {
      return null;
    }
  }

  private String getValueSetSystem() throws FHIRException {
    if (valueset == null) {
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__NO_VALUE_SET));
    }
    if (valueset.getCompose().getInclude().size() == 0) {
      if (!valueset.hasExpansion() || valueset.getExpansion().getContains().size() == 0) {
        throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_NO_INCLUDES_OR_EXPANSION));
      } else {
        String cs = valueset.getExpansion().getContains().get(0).getSystem();
        if (cs != null && checkSystem(valueset.getExpansion().getContains(), cs)) {
          return cs;
        } else {
          throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_EXPANSION_HAS_MULTIPLE_SYSTEMS));
        }
      }
    }
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (inc.hasValueSet()) {
        throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_IMPORTS));
      }
      if (!inc.hasSystem()) {
        throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_NO_SYSTEM));
      }
    }
    if (valueset.getCompose().getInclude().size() == 1) {
      return valueset.getCompose().getInclude().get(0).getSystem();
    }

    return null;
  }

  private String getValueSetSystemOrNull() throws FHIRException {
    if (valueset == null) {
      return null;
    }
    if (valueset.getCompose().getInclude().size() == 0) {
      if (!valueset.hasExpansion() || valueset.getExpansion().getContains().size() == 0) {
        return null;
      } else {
        String cs = valueset.getExpansion().getContains().get(0).getSystem();
        if (cs != null && checkSystem(valueset.getExpansion().getContains(), cs)) {
          return cs;
        } else {
          return null;
        }
      }
    }
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (inc.hasValueSet()) {
        return null;
      }
      if (!inc.hasSystem()) {
        return null;
      }
    }
    if (valueset.getCompose().getInclude().size() == 1) {
      return valueset.getCompose().getInclude().get(0).getSystem();
    }

    return null;
  }

  /*
   * Check that all system values within an expansion correspond to the specified system value
   */
  private boolean checkSystem(List<ValueSetExpansionContainsComponent> containsList, String system) {
    for (ValueSetExpansionContainsComponent contains : containsList) {
      if (!contains.getSystem().equals(system) || (contains.hasContains() && !checkSystem(contains.getContains(), system))) {
        return false;
      }
    }
    return true;
  }

  private ConceptDefinitionComponent findCodeInConcept(ConceptDefinitionComponent concept, String code) {
    if (code.equals(concept.getCode())) {
      return concept;
    }
    ConceptDefinitionComponent cc = findCodeInConcept(concept.getConcept(), code);
    if (cc != null) {
      return cc;
    }
    if (concept.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
      List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) concept.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
      for (ConceptDefinitionComponent c : children) {
        cc = findCodeInConcept(c, code);
        if (cc != null) {
          return cc;
        }
      }
    }
    return null;
  }
  
  private ConceptDefinitionComponent findCodeInConcept(List<ConceptDefinitionComponent> concept, String code) {
    for (ConceptDefinitionComponent cc : concept) {
      if (code.equals(cc.getCode())) {
        return cc;
      }
      ConceptDefinitionComponent c = findCodeInConcept(cc, code);
      if (c != null) {
        return c;
      }
    }
    return null;
  }


  private String systemForCodeInValueSet(String code) {
    Set<String> sys = new HashSet<>();
    if (!scanForCodeInValueSet(code, sys)) {
      return null;
    }
    if (sys.size() != 1) {
      return null;
    } else {
      return sys.iterator().next();
    }
  }
  
  private boolean scanForCodeInValueSet(String code, Set<String> sys) {
    if (valueset.hasCompose()) {
      //  not sure what to do with the 
//      if (valueset.getCompose().hasExclude()) {
//        return false;
//      }
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        if (vsi.hasValueSet()) {
          for (CanonicalType u : vsi.getValueSet()) {
            if (!checkForCodeInValueSet(code, u.getValue(), sys)) {
              return false;
            }
          }
        } else if (!vsi.hasSystem()) { 
          return false;
        }
        if (vsi.hasSystem()) {
          if (vsi.hasFilter()) {
            return false;
          }
          CodeSystem cs = resolveCodeSystem(vsi.getSystem());
          if (cs != null && cs.getContent() == CodeSystemContentMode.COMPLETE) {

            if (vsi.hasConcept()) {
              for (ConceptReferenceComponent cc : vsi.getConcept()) {
                boolean match = cs.getCaseSensitive() ? cc.getCode().equals(code) : cc.getCode().equalsIgnoreCase(code);
                if (match) {
                  sys.add(vsi.getSystem());
                }
              }
            } else {
              ConceptDefinitionComponent cc = findCodeInConcept(cs.getConcept(), code);
              if (cc != null) {
                sys.add(vsi.getSystem());
              }
            }
          } else if (vsi.hasConcept()) {
            for (ConceptReferenceComponent cc : vsi.getConcept()) {
              boolean match = cc.getCode().equals(code);
              if (match) {
                sys.add(vsi.getSystem());
              }
            }
          } else {
            return false;
          }
        }
      }
    } else if (valueset.hasExpansion()) {
      // Retrieve a list of all systems associated with this code in the expansion
      if (!checkSystems(valueset.getExpansion().getContains(), code, sys)) {
        return false;
      }
    }
    return true;
  }

  private boolean checkForCodeInValueSet(String code, String uri, Set<String> sys) {
    ValueSetCheckerSimple vs = getVs(uri);
    return vs.scanForCodeInValueSet(code, sys);
  }

  /*
   * Recursively go through all codes in the expansion and for any coding that matches the specified code, add the system for that coding
   * to the passed list. 
   */
  private boolean checkSystems(List<ValueSetExpansionContainsComponent> contains, String code, Set<String> systems) {
    for (ValueSetExpansionContainsComponent c: contains) {
      if (c.getCode().equals(code)) {
        systems.add(c.getSystem());
      }
      if (c.hasContains())
        checkSystems(c.getContains(), code, systems);
    }
    return true;
  }
  
  @Override
  public Boolean codeInValueSet(String system, String code, ValidationProcessInfo info) throws FHIRException {
    if (valueset == null) {
      return false;
    }
    Boolean result = false;
      
    if (valueset.hasExpansion()) {
      return checkExpansion(new Coding(system, code, null));
    } else if (valueset.hasCompose()) {
      int i = 0;
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        Boolean ok = inComponent(vsi, i, system, code, valueset.getCompose().getInclude().size() == 1, info);
        i++;
        if (ok == null && result == false) {
          result = null;
        } else if (ok) {
          result = true;
          break;
        }
      }
      i = valueset.getCompose().getInclude().size();
      for (ConceptSetComponent vsi : valueset.getCompose().getExclude()) {
        Boolean nok = inComponent(vsi, i, system, code, valueset.getCompose().getInclude().size() == 1, info);
        i++;
        if (nok == null && result == false) {
          result = null;
        } else if (nok != null && nok) {
          result = false;
        }
      }
    } 

    return result;
  }

  private Boolean inComponent(ConceptSetComponent vsi, int vsiIndex, String system, String code, boolean only, ValidationProcessInfo info) throws FHIRException {
    boolean ok = true;
    
    if (vsi.hasValueSet()) {
      if (isValueSetUnionImports()) {
        ok = false;
        for (UriType uri : vsi.getValueSet()) {
          if (inImport(uri.getValue(), system, code)) {
            return true;
          }
        }
      } else {
        ok = inImport(vsi.getValueSet().get(0).getValue(), system, code);
        for (int i = 1; i < vsi.getValueSet().size(); i++) {
          UriType uri = vsi.getValueSet().get(i);
          ok = ok && inImport(uri.getValue(), system, code); 
        }
      }
    }

    if (!vsi.hasSystem() || !ok) {
      return ok;
    }
    
    if (only && system == null) {
      // whether we know the system or not, we'll accept the stated codes at face value
      for (ConceptReferenceComponent cc : vsi.getConcept()) {
        if (cc.getCode().equals(code)) {
          return true;
        }
      }
    }

    if (!system.equals(vsi.getSystem()))
      return false;
    // ok, we need the code system
    CodeSystem cs = resolveCodeSystem(system);
    if (cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT)) {
      // make up a transient value set with
      ValueSet vs = new ValueSet();
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.setUrl(valueset.getUrl()+"--"+vsiIndex);
      vs.setVersion(valueset.getVersion());
      vs.getCompose().addInclude(vsi);
      ValidationResult res = context.validateCode(options.noClient(), new Coding(system, code, null), vs);
      if (res.getErrorClass() == TerminologyServiceErrorClass.UNKNOWN || res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED || res.getErrorClass() == TerminologyServiceErrorClass.VALUESET_UNSUPPORTED) {
        if (info != null && res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
          info.getWarnings().add(context.formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_NOTKNOWN, system));
          info.setErr(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
        }
        return null;
      }
      if (res.getErrorClass() == TerminologyServiceErrorClass.NOSERVICE) {
        throw new NoTerminologyServiceException();
      }
      return res.isOk();
    } else {
      if (vsi.hasFilter()) {
        ok = true;
        for (ConceptSetFilterComponent f : vsi.getFilter()) {
          if (!codeInFilter(cs, system, f, code)) {
            return false;
          }
        }
      }

      List<ConceptDefinitionComponent> list = cs.getConcept();
      ok = validateCodeInConceptList(code, cs, list);
      if (ok && vsi.hasConcept()) {
        for (ConceptReferenceComponent cc : vsi.getConcept()) {
          if (cc.getCode().equals(code)) { 
            return true;
          }
        }
        return false;
      } else {
        return ok;
      }
    }
  }

  protected boolean isValueSetUnionImports() {
    PackageVersion p = (PackageVersion) valueset.getUserData("package");
    if (p != null) {
      return p.getDate().before(new GregorianCalendar(2022, Calendar.MARCH, 31).getTime());
    } else {
      return false;
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
    case ISA: return codeInConceptIsAFilter(cs, f, code, false);
    case ISNOTA: return !codeInConceptIsAFilter(cs, f, code, false);
    case DESCENDENTOF: return codeInConceptIsAFilter(cs, f, code, true); 
    default:
      System.out.println("todo: handle concept filters with op = "+f.getOp()); 
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__CONCEPT_FILTER_WITH_OP__, cs.getUrl(), f.getOp()));
    }
  }

  private boolean codeInConceptIsAFilter(CodeSystem cs, ConceptSetFilterComponent f, String code, boolean rootOnly) {
    if (!rootOnly && code.equals(f.getProperty())) {
      return true;
    }
    ConceptDefinitionComponent cc = findCodeInConcept(cs.getConcept(), f.getValue());
    if (cc == null) {
      return false;
    }
    cc = findCodeInConcept(cc, code);
    return cc != null;
  }

  public boolean validateCodeInConceptList(String code, CodeSystem def, List<ConceptDefinitionComponent> list) {
    if (def.getCaseSensitive()) {
      for (ConceptDefinitionComponent cc : list) {
        if (cc.getCode().equals(code)) { 
          return true;
        }
        if (cc.hasConcept() && validateCodeInConceptList(code, def, cc.getConcept())) {
          return true;
        }
      }
    } else {
      for (ConceptDefinitionComponent cc : list) {
        if (cc.getCode().equalsIgnoreCase(code)) { 
          return true;
        }
        if (cc.hasConcept() && validateCodeInConceptList(code, def, cc.getConcept())) {
          return true;
        }
      }
    }
    return false;
  }

  private ValueSetCheckerSimple getVs(String url) {
    if (inner.containsKey(url)) {
      return inner.get(url);
    }
    ValueSet vs = context.fetchResource(ValueSet.class, url);
    ValueSetCheckerSimple vsc = new ValueSetCheckerSimple(options, vs, context, localContext);
    inner.put(url, vsc);
    return vsc;
  }

  private boolean inImport(String uri, String system, String code) throws FHIRException {
    ValueSetCheckerSimple vs = getVs(uri);
    if (vs == null) {
      return false;
    } else {
      Boolean ok = vs.codeInValueSet(system, code, null);
      return ok != null && ok;
    }
  }

}