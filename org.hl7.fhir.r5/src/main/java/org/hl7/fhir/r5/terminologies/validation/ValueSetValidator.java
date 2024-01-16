package org.hl7.fhir.r5.terminologies.validation;

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
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.NoTerminologyServiceException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.LanguageUtils;
import org.hl7.fhir.r5.extensions.ExtensionConstants;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.Transport.ParameterComponent;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.providers.CodeSystemProvider;
import org.hl7.fhir.r5.terminologies.providers.SpecialCodeSystem;
import org.hl7.fhir.r5.terminologies.providers.URICodeSystem;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.r5.terminologies.utilities.ValueSetProcessBase.OpIssueCode;
import org.hl7.fhir.r5.terminologies.validation.ValueSetValidator.StringWithCode;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.terminologies.utilities.ValueSetProcessBase;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier.ValidationContextResourceProxy;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import com.google.j2objc.annotations.ReflectionSupport.Level;

public class ValueSetValidator extends ValueSetProcessBase {

  public static final String NO_TRY_THE_SERVER = "The local terminology server cannot handle this request";


  public class StringWithCode {
    private OpIssueCode code;
    private String message;
    protected StringWithCode(OpIssueCode code, String message) {
      super();
      this.code = code;
      this.message = message;
    }
    public OpIssueCode getCode() {
      return code;
    }
    public String getMessage() {
      return message;
    }
    
  }


  private ValueSet valueset;
  private Map<String, ValueSetValidator> inner = new HashMap<>();
  private ValidationOptions options;
  private ValidationContextCarrier localContext;
  private List<CodeSystem> localSystems = new ArrayList<>();
  protected Parameters expansionProfile;
  private TerminologyCapabilities txCaps;
  private Set<String> unknownSystems;
  private Set<String> unknownValueSets = new HashSet<>();
  private boolean throwToServer;

  public ValueSetValidator(IWorkerContext context, TerminologyOperationContext opContext, ValidationOptions options, ValueSet source, Parameters expansionProfile, TerminologyCapabilities txCaps) {
    super(context, opContext);
    this.valueset = source;
    this.options = options;
    this.expansionProfile = expansionProfile;
    this.txCaps = txCaps;
    analyseValueSet();
  }
  
  public ValueSetValidator(IWorkerContext context, TerminologyOperationContext opContext, ValidationOptions options, ValueSet source, ValidationContextCarrier ctxt, Parameters expansionProfile, TerminologyCapabilities txCaps) {
    super(context, opContext);
    this.valueset = source;
    this.options = options.copy();
    this.options.setEnglishOk(true);
    this.localContext = ctxt;
    this.expansionProfile = expansionProfile;
    this.txCaps = txCaps;
    analyseValueSet();
  }

  public Set<String> getUnknownSystems() {
    return unknownSystems;
  }

  public void setUnknownSystems(Set<String> unknownSystems) {
    this.unknownSystems = unknownSystems;
  }

  public boolean isThrowToServer() {
    return throwToServer;
  }

  public void setThrowToServer(boolean throwToServer) {
    this.throwToServer = throwToServer;
  }

  private void analyseValueSet() {
    if (valueset != null) {
      opContext.seeContext(valueset.getVersionedUrl());
      for (Extension s : valueset.getExtensionsByUrl(ExtensionConstants.EXT_VSSUPPLEMENT)) {
        requiredSupplements.add(s.getValue().primitiveValue());
      }
    }

    altCodeParams.seeParameters(expansionProfile);
    altCodeParams.seeValueSet(valueset);
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
    opContext.deadCheck();
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
    return validateCode("CodeableConcept", code);
  }
  
  public ValidationResult validateCode(String path, CodeableConcept code) throws FHIRException {
    opContext.deadCheck();
    checkValueSetOptions();

    // first, we validate the codings themselves
    ValidationProcessInfo info = new ValidationProcessInfo();

    CodeableConcept vcc = new CodeableConcept();
    List<ValidationResult> resList = new ArrayList<>();
    
    if (!options.isMembershipOnly()) {
      int i = 0;
      for (Coding c : code.getCoding()) {
        if (!c.hasSystem() && !c.hasUserData("val.sys.error")) {
          c.setUserData("val.sys.error", true);
          info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.INVALID, path+".coding["+i+"]", context.formatMessage(I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE), OpIssueCode.InvalidData, null));
        } else {
          VersionInfo vi = new VersionInfo(this);
          checkExpansion(c, vi);
          checkInclude(c, vi);
          CodeSystem cs = resolveCodeSystem(c.getSystem(), vi.getVersion(c.getSystem(), c.getVersion()));
          ValidationResult res = null;
          if (cs == null || cs.getContent() != CodeSystemContentMode.COMPLETE) {
            if (context.isNoTerminologyServer()) {
              if (c.hasVersion()) {
                String msg = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM_VERSION, c.getSystem(), c.getVersion() , resolveCodeSystemVersions(c.getSystem()).toString());
                unknownSystems.add(c.getSystem()+"|"+c.getVersion());
                res = new ValidationResult(IssueSeverity.ERROR, msg, makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, path+".coding["+i+"].system", msg, OpIssueCode.NotFound, null)).setUnknownSystems(unknownSystems);
              } else {
                String msg = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM, c.getSystem(), c.getVersion());
                unknownSystems.add(c.getSystem());
                res = new ValidationResult(IssueSeverity.ERROR, msg, makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, path+".coding["+i+"].system", msg, OpIssueCode.NotFound, null)).setUnknownSystems(unknownSystems);
              }
            } else {
              res = context.validateCode(options.withNoClient(), c, null);
              if (res.isOk()) {
                vcc.addCoding(new Coding().setCode(res.getCode()).setVersion(res.getVersion()).setSystem(res.getSystem()).setDisplay(res.getDisplay()));
              }
              for (OperationOutcomeIssueComponent iss : res.getIssues()) {
                if (iss.getSeverity() == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR && iss.getDetails().hasCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "not-found")) {
                  iss.setSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.WARNING);
                  res.setSeverity(IssueSeverity.WARNING);
                }
                iss.resetPath("Coding", path+".coding["+i+"]");
              }
              if (res.isInactive()) {
                String msg = context.formatMessage(I18nConstants.STATUS_CODE_WARNING_CODE, "not active", c.getCode());
                res.getIssues().addAll(makeIssue(IssueSeverity.INFORMATION, IssueType.INVALID, path+".coding["+i+"].code", msg, OpIssueCode.CodeRule, res.getServer()));
              }
            }
          } else {
            c.setUserData("cs", cs);

            checkCanonical(info.getIssues(), path, cs, valueset);
            res = validateCode(path+".coding["+i+"]", c, cs, vcc, info);
          }
          info.getIssues().addAll(res.getIssues());
          if (res != null) {
            resList.add(res);
            if (!res.isOk() && !res.messageIsInIssues()) {
              if (res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {                
                info.getIssues().addAll(makeIssue(res.getSeverity(), IssueType.NOTFOUND, path+".coding["+i+"]", res.getMessage(), OpIssueCode.NotFound, res.getServer()));
              } else {
                info.getIssues().addAll(makeIssue(res.getSeverity(), IssueType.CODEINVALID, path+".coding["+i+"]", res.getMessage(), OpIssueCode.InvalidCode, res.getServer()));
              }
            }
          } 
        }
        i++;
      }
    }
    Coding foundCoding = null;
    String msg = null;
    Boolean result = false;
    if (valueset != null) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(", ");
      List<String> cpath = new ArrayList<>();
      
      int i = 0;
      for (Coding c : code.getCoding()) {
        String cs = "'"+c.getSystem()+(c.hasVersion() ? "|"+c.getVersion() : "")+"#"+c.getCode()+(c.hasDisplay() ? " ('"+c.getDisplay()+"')" : "")+"'";
        String cs2 = c.getSystem()+(c.hasVersion() ? "|"+c.getVersion() : "");
        cpath.add(path+".coding["+i+"]");
        b.append(cs2);
        Boolean ok = codeInValueSet(path, c.getSystem(), c.getVersion(), c.getCode(), info);
        if (ok == null && result != null && result == false) {
          result = null;
        } else if (ok != null && ok) {
          result = true;
          foundCoding = c;
          if (!options.isMembershipOnly()) {
            vcc.addCoding().setSystem(c.getSystem()).setVersion(c.getVersion()).setCode(c.getCode());
          }
        }
        if (ok == null || !ok) {
          vcc.removeCoding(c.getSystem(), c.getVersion(), c.getCode());          
        }
        if (ok != null && !ok) {
          msg = context.formatMessage(I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_ONE, null, valueset.getVersionedUrl(), cs);
          info.getIssues().addAll(makeIssue(IssueSeverity.INFORMATION, IssueType.CODEINVALID, path+".coding["+i+"].code", msg, OpIssueCode.ThisNotInVS, null));
        }
        i++;
      }
      if (result == null) {
        if (!unknownValueSets.isEmpty()) {
          msg = context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_VS, valueset.getVersionedUrl(), CommaSeparatedStringBuilder.join(", ", unknownValueSets));
        } else {
          msg = context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_CS, valueset.getVersionedUrl(), b.toString());
        }
        info.getIssues().addAll(makeIssue(IssueSeverity.WARNING, unknownSystems.isEmpty() && unknownValueSets.isEmpty() ? IssueType.CODEINVALID : IssueType.NOTFOUND, null, msg, OpIssueCode.VSProcessing, null));
      } else if (!result) {
        // to match Ontoserver
        OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR, org.hl7.fhir.r5.model.OperationOutcome.IssueType.CODEINVALID);
        iss.getDetails().setText(context.formatMessage(I18nConstants.TX_GENERAL_CC_ERROR_MESSAGE, valueset.getVersionedUrl()));
        iss.getDetails().addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", OpIssueCode.NotInVS.toCode(), null);
        info.getIssues().add(iss);

//        msg = context.formatMessagePlural(code.getCoding().size(), I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getVersionedUrl(), b.toString());
//        info.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.CODEINVALID, code.getCoding().size() == 1 ? path+".coding[0].code" : path, msg));
      }
    }

    if (vcc.hasCoding() && code.hasText()) {
      vcc.setText(code.getText());
    }
    if (!checkRequiredSupplements(info)) {
      return new ValidationResult(IssueSeverity.ERROR, info.getIssues().get(info.getIssues().size()-1).getDetails().getText(), info.getIssues());
    } else if (info.hasErrors()) {
      ValidationResult res = new ValidationResult(IssueSeverity.ERROR, info.summary(), info.getIssues());
      if (foundCoding != null) {
        ConceptDefinitionComponent cd = new ConceptDefinitionComponent(foundCoding.getCode());
        cd.setDisplay(lookupDisplay(foundCoding));
        res.setDefinition(cd);
        res.setSystem(foundCoding.getSystem());
        res.setVersion(foundCoding.hasVersion() ? foundCoding.getVersion() : foundCoding.hasUserData("cs") ? ((CodeSystem) foundCoding.getUserData("cs")).getVersion() : null);
        res.setDisplay(cd.getDisplay());
      }
      res.setUnknownSystems(unknownSystems);
      res.addCodeableConcept(vcc);
      return res;
    } else if (result == null) {
      return new ValidationResult(IssueSeverity.WARNING, info.summary(), info.getIssues());
    } else if (foundCoding == null && valueset != null) {
      return new ValidationResult(IssueSeverity.ERROR, "Internal Error that should not happen", makeIssue(IssueSeverity.FATAL, IssueType.EXCEPTION, path, "Internal Error that should not happen", OpIssueCode.VSProcessing, null));
    } else if (info.getIssues().size() > 0) {
      if (foundCoding == null) {
        IssueSeverity lvl = IssueSeverity.INFORMATION; 
        for (OperationOutcomeIssueComponent iss : info.getIssues()) {
          lvl = IssueSeverity.max(lvl, OperationOutcomeUtilities.convert(iss.getSeverity()));
        }
        return new ValidationResult(lvl, info.summary(), info.getIssues());        
      } else {
        String disp = lookupDisplay(foundCoding);
        ConceptDefinitionComponent cd = new ConceptDefinitionComponent(foundCoding.getCode());
        cd.setDisplay(disp);
        return new ValidationResult(IssueSeverity.WARNING, info.summaryList(), foundCoding.getSystem(), getVersion(foundCoding), cd, disp, info.getIssues()).addCodeableConcept(vcc);
      }
    } else if (!result) {
      if (valueset != null) {
        throw new Error("what?");
      } else if (vcc.hasCoding()) {
        return new ValidationResult(vcc.getCodingFirstRep().getSystem(), getVersion(vcc.getCodingFirstRep()), new ConceptDefinitionComponent(vcc.getCodingFirstRep().getCode()).setDisplay(vcc.getCodingFirstRep().getDisplay()), vcc.getCodingFirstRep().getDisplay()).addCodeableConcept(vcc);
      } else {
        throw new Error("what?");
      }
    } else if (foundCoding != null) {
      ConceptDefinitionComponent cd = new ConceptDefinitionComponent(foundCoding.getCode());
      cd.setDisplay(lookupDisplay(foundCoding));
      return new ValidationResult(foundCoding.getSystem(), getVersion(foundCoding), cd, getPreferredDisplay(cd, null)).addCodeableConcept(vcc);
    } else {
      throw new Error("what?");
    }
  }

  private boolean checkRequiredSupplements(ValidationProcessInfo info) {
    if (!requiredSupplements.isEmpty()) {
      String msg= context.formatMessagePlural(requiredSupplements.size(), I18nConstants.VALUESET_SUPPLEMENT_MISSING, CommaSeparatedStringBuilder.build(requiredSupplements));
      throw new TerminologyServiceProtectionException(msg, TerminologyServiceErrorClass.BUSINESS_RULE, IssueType.NOTFOUND);
    }
    return requiredSupplements.isEmpty();
  }

  private boolean valueSetDependsOn(String system, String version) {
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (system.equals(inc.getSystem()) && (version == null || inc.getVersion() == null || version.equals(inc.getVersion()))) {
        return true;
      }
    }
    return false;
  }

  private String getVersion(Coding c) {
    if (c.hasVersion()) {
      return c.getVersion();
    } else if (c.hasUserData("cs")) {
      return ((CodeSystem) c.getUserData("cs")).getVersion();
    } else {
      return null;
    }
  }

  private String lookupDisplay(Coding c) {
    CodeSystem cs = resolveCodeSystem(c.getSystem(), c.getVersion());
    if (cs != null) {
      ConceptDefinitionComponent cd = CodeSystemUtilities.findCodeOrAltCode(cs.getConcept(), c.getCode(), null);
      if (cd != null) {
        return getPreferredDisplay(cd, cs); 
      }
    }
    return null;
  }

  public CodeSystem resolveCodeSystem(String system, String version) {
    for (CodeSystem t : localSystems) {
      if (t.getUrl().equals(system) && versionsMatch(version, t.getVersion())) {
        return t;
      }
    }
    CodeSystem cs = context.fetchSupplementedCodeSystem(system, version);
    if (cs == null) {
      cs = findSpecialCodeSystem(system, version);
    }
    return cs;
  }

  public List<String> resolveCodeSystemVersions(String system) {
    List<String> res = new ArrayList<>();
    for (CodeSystem t : localSystems) {
      if (t.getUrl().equals(system) && t.hasVersion()) {
        res.add(t.getVersion());
      }
    }
    res.addAll(new ContextUtilities(context).fetchCodeSystemVersions(system));
    return res;
  }

  private boolean versionsMatch(String versionTest, String versionActual) {
    return versionTest == null && VersionUtilities.versionsMatch(versionTest, versionActual);
  }

  public ValidationResult validateCode(Coding code) throws FHIRException {
    return validateCode("Coding", code); 
  }
  
  public ValidationResult validateCode(String path, Coding code) throws FHIRException {
    opContext.deadCheck();
    checkValueSetOptions();
    
    String warningMessage = null;
    // first, we validate the concept itself

    ValidationResult res = null;
    boolean inExpansion = false;
    boolean inInclude = false;
    List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
    ValidationProcessInfo info = new ValidationProcessInfo(issues);
    VersionInfo vi = new VersionInfo(this);
    checkCanonical(issues, path, valueset, valueset);

    String system = code.hasSystem() ? code.getSystem() : getValueSetSystemOrNull();
    if (!options.isMembershipOnly()) {
      if (system == null && !code.hasDisplay() && options.isGuessSystem()) { // dealing with just a plain code (enum)
        List<StringWithCode> problems = new ArrayList<>();
        system = systemForCodeInValueSet(code.getCode(), problems);
        if (system == null) {
          if (problems.size() == 0) {
            throw new Error("Unable to resolve systems but no reason why"); // this is an error in the java code
          } else if (problems.size() == 1) {
            return new ValidationResult(IssueSeverity.ERROR, problems.get(0).getMessage(), makeIssue(IssueSeverity.ERROR, IssueType.UNKNOWN, path, problems.get(0).getMessage(), problems.get(0).getCode(), null));
          } else {
            CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("; ");
            for (StringWithCode s : problems) {
              b.append(s.getMessage());
            }            
            ValidationResult vr = new ValidationResult(IssueSeverity.ERROR, b.toString(), null);
            for (StringWithCode s : problems) {
              vr.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.UNKNOWN, path, s.getMessage(), s.getCode(), vr.getServer()));
            }
            return vr;
          }
        }
      }
      if (!code.hasSystem()) {
        if (options.isGuessSystem() && system == null && Utilities.isAbsoluteUrl(code.getCode())) {
          system = "urn:ietf:rfc:3986"; // this arises when using URIs bound to value sets
        }
        code.setSystem(system);
      }
      if (!code.hasSystem()) {
        res = new ValidationResult(IssueSeverity.WARNING, context.formatMessage(I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE), null);
        if (!code.hasUserData("val.sys.error")) {
          code.setUserData("val.sys.error", true);
          res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.INVALID, path, context.formatMessage(I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE), OpIssueCode.InvalidData, null));
        }
      } else {
        if (!Utilities.isAbsoluteUrl(system)) {
          String msg = context.formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_RELATIVE);
          issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, path+".system", msg, OpIssueCode.InvalidData, null));                
        }
        inExpansion = checkExpansion(code, vi);
        inInclude = checkInclude(code, vi);
        String wv = vi.getVersion(system, code.getVersion());
        CodeSystem cs = resolveCodeSystem(system, wv);
        if (cs == null) {
          OpIssueCode oic = OpIssueCode.NotFound;
          IssueType itype = IssueType.NOTFOUND;
          ValueSet vs = context.findTxResource(ValueSet.class, system);
          if (vs != null) {
            warningMessage = context.formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_VALUESET2, system);  
            oic = OpIssueCode.InvalidData;
            itype = IssueType.INVALID;
          } else if (wv == null) {
            warningMessage = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM, system);
            unknownSystems.add(system);
          } else {
            warningMessage = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM_VERSION, system, wv, resolveCodeSystemVersions(system).toString());
            unknownSystems.add(system+"|"+wv);
          }
          if (!inExpansion) {
            if (valueset != null && valueset.hasExpansion()) {
              String msg = context.formatMessage(I18nConstants.CODESYSTEM_CS_UNK_EXPANSION,
                  valueset.getUrl(), 
                  code.getSystem(), 
                  code.getCode().toString());
              issues.addAll(makeIssue(IssueSeverity.ERROR, itype, path, msg, OpIssueCode.VSProcessing, null));
              throw new VSCheckerException(msg, issues, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
            } else {
              issues.addAll(makeIssue(IssueSeverity.ERROR, itype, path+".system", warningMessage, oic, null));
              res = new ValidationResult(IssueSeverity.WARNING, warningMessage, issues);              
              if (valueset == null) {
                throw new VSCheckerException(warningMessage, issues, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
              } else {
                //              String msg = context.formatMessagePlural(1, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getUrl(), code.toString());
                //              issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, path, msg));
                // we don't do this yet
                // throw new VSCheckerException(warningMessage, issues); 
              }
            }
          }
        } else {
          checkCanonical(issues, path, cs, valueset);
        }
        if (cs != null && cs.hasSupplements()) {
          String msg = context.formatMessage(I18nConstants.CODESYSTEM_CS_NO_SUPPLEMENT, cs.getUrl());
          return new ValidationResult(IssueSeverity.ERROR, msg, makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, path, msg, OpIssueCode.VSProcessing, null));        
        }
        if (cs!=null && cs.getContent() != CodeSystemContentMode.COMPLETE) {
          warningMessage = "Resolved system "+system+(cs.hasVersion() ? " (v"+cs.getVersion()+")" : "")+", but the definition ";
          switch (cs.getContent()) {
          case EXAMPLE:
            warningMessage = warningMessage +"only has example content";
            break;
          case FRAGMENT:
            warningMessage = warningMessage + "is only a fragment";
            break;
          case NOTPRESENT:
            warningMessage = warningMessage + "doesn't include any codes";
            break;
          case SUPPLEMENT:
            warningMessage = warningMessage + " is for a supplement to "+cs.getSupplements();
            break;
          default:
            break;
          }
          warningMessage = warningMessage + ", so the code has not been validated";
          if (!inExpansion && cs.getContent() != CodeSystemContentMode.FRAGMENT) { // we're going to give it a go if it's a fragment
            throw new VSCheckerException(warningMessage, null, true);
          }
        }

        if (cs != null /*&& (cs.getContent() == CodeSystemContentMode.COMPLETE || cs.getContent() == CodeSystemContentMode.FRAGMENT)*/) {
          if (!(cs.getContent() == CodeSystemContentMode.COMPLETE || cs.getContent() == CodeSystemContentMode.FRAGMENT)) {
            if (inInclude) {
              ConceptReferenceComponent cc = findInInclude(code);
              if (cc != null) {
                // we'll take it on faith
                String disp = getPreferredDisplay(cc);
                res = new ValidationResult(system, cs.getVersion(), new ConceptDefinitionComponent().setCode(cc.getCode()).setDisplay(disp), disp);
                res.addMessage("Resolved system "+system+", but the definition is not complete, so assuming value set include is correct");
                return res;
              }
            }
            // we can't validate that here. 
            throw new FHIRException("Unable to evaluate based on empty code system");
          }
          res = validateCode(path, code, cs, null, info);
          res.setIssues(issues);
        } else if (cs == null && valueset.hasExpansion() && inExpansion) {
          // we just take the value set as face value then
          res = new ValidationResult(system, wv, new ConceptDefinitionComponent().setCode(code.getCode()).setDisplay(code.getDisplay()), code.getDisplay());
          if (!preferServerSide(system)) {
            res.addMessage("Code System unknown, so assuming value set expansion is correct ("+warningMessage+")");
          }
        } else {
          // well, we didn't find a code system - try the expansion? 
          // disabled waiting for discussion
          if (throwToServer) {
            throw new FHIRException(NO_TRY_THE_SERVER);
          }
        }
      }
    } else {
      inExpansion = checkExpansion(code, vi);
      inInclude = checkInclude(code, vi);
    }
    String wv = vi.getVersion(system, code.getVersion());
    if (!checkRequiredSupplements(info)) {
      return new ValidationResult(IssueSeverity.ERROR, issues.get(issues.size()-1).getDetails().getText(), issues);
    }

    
    // then, if we have a value set, we check it's in the value set
    if (valueset != null) {
      if ((res==null || res.isOk())) { 
        Boolean ok = codeInValueSet(path, system, wv, code.getCode(), info);
        if (ok == null || !ok) {
          if (res == null) {
            res = new ValidationResult((IssueSeverity) null, null, info.getIssues());
          }
          if (info.getErr() != null) {
            res.setErrorClass(info.getErr());
          }
          if (ok == null) {
            String m = null;
            if (!unknownSystems.isEmpty()) {
              m = context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_CS, valueset.getVersionedUrl(), CommaSeparatedStringBuilder.join(",", unknownSystems));
            } else if (!unknownValueSets.isEmpty()) {
              res.addMessage(info.getIssues().get(0).getDetails().getText());
              m = context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_VS, valueset.getVersionedUrl(), CommaSeparatedStringBuilder.join(",", unknownValueSets));
            } else {
              // not sure why we'd get to here?
              m = context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getVersionedUrl());
            }
            res.addMessage(m);
            res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.NOTFOUND, null, m, OpIssueCode.VSProcessing, null));
            res.setUnknownSystems(unknownSystems);
            res.setSeverity(IssueSeverity.ERROR); // back patching for display logic issue
            res.setErrorClass(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
          } else if (!inExpansion && !inInclude) {
//            if (!info.getIssues().isEmpty()) {
//              res.setMessage("Not in value set "+valueset.getUrl()+": "+info.summary()).setSeverity(IssueSeverity.ERROR);              
//              res.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, path, res.getMessage()));
//            } else
//            {
              String msg = context.formatMessagePlural(1, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getVersionedUrl(), "'"+code.toString()+"'");
              res.addMessage(msg).setSeverity(IssueSeverity.ERROR);
              res.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.CODEINVALID, path+".code", msg, OpIssueCode.NotInVS, null));
              res.setDefinition(null);
              res.setSystem(null);
              res.setDisplay(null);
              res.setUnknownSystems(unknownSystems);
//            }
          } else if (warningMessage!=null) {
            String msg = context.formatMessage(I18nConstants.CODE_FOUND_IN_EXPANSION_HOWEVER_, warningMessage);
            res = new ValidationResult(IssueSeverity.WARNING, msg, makeIssue(IssueSeverity.WARNING, IssueType.EXCEPTION, path, msg, OpIssueCode.VSProcessing, null));
          } else if (inExpansion) {
            res.setMessage("Code found in expansion, however: " + res.getMessage());
            res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.EXCEPTION, path, res.getMessage(), OpIssueCode.VSProcessing, null));
          } else if (inInclude) {
            res.setMessage("Code found in include, however: " + res.getMessage());
            res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.EXCEPTION, path, res.getMessage(), OpIssueCode.VSProcessing, null));
          }
        } else if (res == null) {
          res = new ValidationResult(system, wv, null, null);
        }
      } else if ((res != null && !res.isOk())) {
        String msg = context.formatMessagePlural(1, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getVersionedUrl(), "'"+code.toString()+"'");
        res.addMessage(msg);
        res.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.CODEINVALID, path+".code", msg, OpIssueCode.NotInVS, null));
      }
    }
    if (res != null && res.getSeverity() == IssueSeverity.INFORMATION) {
      res.setSeverity(IssueSeverity.ERROR); // back patching for display logic issue
    }
    return res;
  }

  private void checkValueSetOptions() {
    if (valueset != null) {
      for (Extension ext : valueset.getCompose().getExtensionsByUrl("http://hl7.org/fhir/tools/StructureDefinion/valueset-expansion-param")) {
        var name = ext.getExtensionString("name");
        var value = ext.getExtensionByUrl("value").getValue();
        if ("displayLanguage".equals(name)) {
          options.setLanguages(value.primitiveValue());
        }
      }
      if (!options.hasLanguages() && valueset.hasLanguage()) {
        options.addLanguage(valueset.getLanguage());
      }
    }
  }

  private static final Set<String> SERVER_SIDE_LIST = new HashSet<>(Arrays.asList("http://fdasis.nlm.nih.gov", "http://hl7.org/fhir/sid/ndc", "http://loinc.org", "http://snomed.info/sct", "http://unitsofmeasure.org", 
      "http://unstats.un.org/unsd/methods/m49/m49.htm", "http://varnomen.hgvs.org", "http://www.nlm.nih.gov/research/umls/rxnorm", "https://www.usps.com/",
      "urn:ietf:bcp:13","urn:ietf:bcp:47","urn:ietf:rfc:3986", "urn:iso:std:iso:3166","urn:iso:std:iso:4217", "urn:oid:1.2.36.1.2001.1005.17"));
  
  private boolean preferServerSide(String system) {
    if (SERVER_SIDE_LIST.contains(system)) {
      return true;
    }
  
    if (txCaps != null) {
      for (TerminologyCapabilitiesCodeSystemComponent tccs : txCaps.getCodeSystem()) {
        if (system.equals(tccs.getUri())) {
          return true;
        }
      }
    }
    return false;    
  }

  private boolean checkInclude(Coding code, VersionInfo vi) {
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
        vi.setComposeVersion(inc.getVersion());
        for (ConceptReferenceComponent cc : inc.getConcept()) {
          if (cc.hasCode() && cc.getCode().equals(code.getCode())) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private ConceptReferenceComponent findInInclude(Coding code) {
    if (valueset == null || code.getSystem() == null || code.getCode() == null) {
      return null;
    }
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (inc.hasSystem() && inc.getSystem().equals(code.getSystem())) {
        for (ConceptReferenceComponent cc : inc.getConcept()) {
          if (cc.hasCode() && cc.getCode().equals(code.getCode())) {
            return cc;
          }
        }
      }
    }
    return null;
  }

  private CodeSystem findSpecialCodeSystem(String system, String version) {
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
      opContext.deadCheck();
      if (containsComponent.getSystem().equals(code.getSystem()) && containsComponent.getCode().equals(code.getCode())) {
        ConceptDefinitionComponent ccd = new ConceptDefinitionComponent();
        ccd.setCode(containsComponent.getCode());
        ccd.setDisplay(containsComponent.getDisplay());
        ValidationResult res = new ValidationResult(code.getSystem(), code.hasVersion() ? code.getVersion() : containsComponent.getVersion(), ccd, getPreferredDisplay(ccd, null));
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

  private boolean checkExpansion(Coding code, VersionInfo vi) {
    if (valueset==null || !valueset.hasExpansion()) {
      return false;
    }
    return checkExpansion(code, valueset.getExpansion().getContains(), vi);
  }

  private boolean checkExpansion(Coding code, List<ValueSetExpansionContainsComponent> contains, VersionInfo vi) {
    for (ValueSetExpansionContainsComponent containsComponent: contains) {
      opContext.deadCheck();
      if (containsComponent.hasSystem() && containsComponent.hasCode() && containsComponent.getSystem().equals(code.getSystem()) && containsComponent.getCode().equals(code.getCode())) {
        vi.setExpansionVersion(containsComponent.getVersion());
        return true;
      }
      if (containsComponent.hasContains() && checkExpansion(code, containsComponent.getContains(), vi)) {
        return true;
      }
    }
    return false;
  }

  private ValidationResult validateCode(String path, Coding code, CodeSystem cs, CodeableConcept vcc, ValidationProcessInfo info) {
    ConceptDefinitionComponent cc = cs.hasUserData("tx.cs.special") ? ((SpecialCodeSystem) cs.getUserData("tx.cs.special")).findConcept(code) : findCodeInConcept(cs.getConcept(), code.getCode(), allAltCodes);
    if (cc == null) {
      cc = findSpecialConcept(code, cs);
    }
    if (cc == null) {
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        String msg = context.formatMessage(I18nConstants.UNKNOWN_CODE_IN_FRAGMENT, code.getCode(), cs.getUrl(),  cs.getVersion());
        return new ValidationResult(IssueSeverity.WARNING, msg, makeIssue(IssueSeverity.WARNING, IssueType.CODEINVALID, path+".code", msg, OpIssueCode.InvalidCode, null));        
      } else {
        String msg = context.formatMessage(I18nConstants.UNKNOWN_CODE_IN_VERSION, code.getCode(), cs.getUrl(), cs.getVersion());
        return new ValidationResult(IssueSeverity.ERROR, msg, makeIssue(IssueSeverity.ERROR, IssueType.CODEINVALID, path+".code", msg, OpIssueCode.InvalidCode, null));
      }
    }
    Coding vc = new Coding().setCode(cc.getCode()).setSystem(cs.getUrl()).setVersion(cs.getVersion()).setDisplay(getPreferredDisplay(cc, cs));
    if (vcc != null) {
      vcc.addCoding(vc);
    }

    boolean inactive = (CodeSystemUtilities.isInactive(cs, cc));
    String status = inactive ? (CodeSystemUtilities.getStatus(cs, cc)) : null;

    boolean ws = false;     
    if (code.getDisplay() == null) {
      return new ValidationResult(code.getSystem(), cs.getVersion(), cc, vc.getDisplay()).setStatus(inactive, status);
    }
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(", ", " or ");
    if (cc.hasDisplay() && isOkLanguage(cs.getLanguage())) {
      b.append("'"+cc.getDisplay()+"'"+(cs.hasLanguage() ? " ("+cs.getLanguage()+")" : ""));
      if (code.getDisplay().equalsIgnoreCase(cc.getDisplay())) {
        return new ValidationResult(code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs)).setStatus(inactive, status);
      } else if (Utilities.normalize(code.getDisplay()).equals(Utilities.normalize(cc.getDisplay()))) {
        ws = true;
      }
    }
    
    for (ConceptDefinitionDesignationComponent ds : cc.getDesignation()) {
      opContext.deadCheck();
      if (isOkLanguage(ds.getLanguage())) {
        b.append("'"+ds.getValue()+"'");
        if (code.getDisplay().equalsIgnoreCase(ds.getValue())) {
          return new ValidationResult(code.getSystem(),cs.getVersion(),  cc, getPreferredDisplay(cc, cs)).setStatus(inactive, status);
        }
        if (Utilities.normalize(code.getDisplay()).equalsIgnoreCase(Utilities.normalize(ds.getValue()))) {
          ws = true;
        }
      }
    }
    // also check to see if the value set has another display
    if (options.isUseValueSetDisplays()) {
      ConceptReferencePair vs = findValueSetRef(code.getSystem(), code.getCode());
      if (vs != null && (vs.getCc().hasDisplay() ||vs.getCc().hasDesignation())) {
        if (vs.getCc().hasDisplay() && isOkLanguage(vs.getValueset().getLanguage())) {
          b.append("'"+vs.getCc().getDisplay()+"'");
          if (code.getDisplay().equalsIgnoreCase(vs.getCc().getDisplay())) {
            return new ValidationResult(code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs)).setStatus(inactive, status);
          }
        }
        for (ConceptReferenceDesignationComponent ds : vs.getCc().getDesignation()) {
          opContext.deadCheck();
          if (isOkLanguage(ds.getLanguage())) {
            b.append("'"+ds.getValue()+"'");
            if (code.getDisplay().equalsIgnoreCase(ds.getValue())) {
              return new ValidationResult(code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs)).setStatus(inactive, status);
            }
          }
        }
      }
    }
    if (b.count() == 0) {
      String msg = context.formatMessagePlural(options.getLanguages().getLangs().size(), I18nConstants.NO_VALID_DISPLAY_FOUND, code.getSystem(), code.getCode(), code.getDisplay(), options.langSummary());
      return new ValidationResult(IssueSeverity.WARNING, msg, code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs), makeIssue(IssueSeverity.WARNING, IssueType.INVALID, path+".display", msg, OpIssueCode.Display, null)).setStatus(inactive, status);      
    } else {
      String msg = context.formatMessagePlural(b.count(), ws ? I18nConstants.DISPLAY_NAME_WS_FOR__SHOULD_BE_ONE_OF__INSTEAD_OF : I18nConstants.DISPLAY_NAME_FOR__SHOULD_BE_ONE_OF__INSTEAD_OF, code.getSystem(), code.getCode(), b.toString(), code.getDisplay(), options.langSummary());
      return new ValidationResult(dispWarningStatus(), msg, code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs), makeIssue(dispWarning(), IssueType.INVALID, path+".display", msg, OpIssueCode.Display, null)).setStatus(inactive, status);
    }
  }

  private ConceptDefinitionComponent findSpecialConcept(Coding c, CodeSystem cs) {
    // handling weird special cases in v2 code systems 
    if ("http://terminology.hl7.org/CodeSystem/v2-0203".equals(cs.getUrl())) {
      String code = c.getCode();
      if (code != null && code.startsWith("NN") && code.length() > 3) {
        ConceptDefinitionComponent cd = findCountryCode(code.substring(2));
        if (cd != null) {
          return new ConceptDefinitionComponent(code).setDisplay("National Identifier for "+cd.getDisplay());
        }
      }      
    }
//    0396: HL7nnnn, IBTnnnn, ISOnnnn, X12Dennnn, 99zzz
//    0335: PRNxxx
    return null;
  }

  
  private ConceptDefinitionComponent findCountryCode(String code) {
    ValidationResult vr = context.validateCode(new ValidationOptions(FhirPublication.R5), "urn:iso:std:iso:3166", null, code, null);
    return vr == null || !vr.isOk() ? null : new ConceptDefinitionComponent(code).setDisplay(vr.getDisplay()).setDefinition(vr.getDefinition());
  }

  private IssueSeverity dispWarning() {
    return options.isDisplayWarningMode() ? IssueSeverity.WARNING : IssueSeverity.ERROR; 
  }
  
  private IssueSeverity dispWarningStatus() {
    return options.isDisplayWarningMode() ? IssueSeverity.WARNING : IssueSeverity.INFORMATION; // information -> error later
  }

  private boolean isOkLanguage(String language) {
    if (!options.hasLanguages()) {
      return true;
    }
    if (LanguageUtils.langsMatch(options.getLanguages(), language)) {
      return true;
    }
    if (language == null && (options.langSummary().contains("en") || options.langSummary().contains("en-US") || options.isEnglishOk())) {
      return true;
    }
    return false;
  }

  private ConceptReferencePair findValueSetRef(String system, String code) {
    if (valueset == null)
      return null;
    // if it has an expansion
    for (ValueSetExpansionContainsComponent exp : valueset.getExpansion().getContains()) {
      opContext.deadCheck();
      if (system.equals(exp.getSystem()) && code.equals(exp.getCode())) {
        ConceptReferenceComponent cc = new ConceptReferenceComponent();
        cc.setDisplay(exp.getDisplay());
        cc.setDesignation(exp.getDesignation());
        return new ConceptReferencePair(valueset, cc);
      }
    }
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (system.equals(inc.getSystem())) {
        for (ConceptReferenceComponent cc : inc.getConcept()) {
          if (cc.getCode().equals(code)) {
            return new ConceptReferencePair(valueset, cc);
          }
        }
      }
      for (CanonicalType url : inc.getValueSet()) {
        ConceptReferencePair cc = getVs(url.asStringValue(), null).findValueSetRef(system, code);
        if (cc != null) {
          return cc;
        }
      }
    }
    return null;
  }

  private String getValueSetSystemOrNull() throws FHIRException {
    if (valueset == null) {
      return null;
    }
    if (!options.isGuessSystem()) {
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

  private ConceptDefinitionComponent findCodeInConcept(ConceptDefinitionComponent concept, String code, AlternateCodesProcessingRules altCodeRules) {
    opContext.deadCheck();
    if (code.equals(concept.getCode())) {
      return concept;
    }
    ConceptDefinitionComponent cc = findCodeInConcept(concept.getConcept(), code, altCodeRules);
    if (cc != null) {
      return cc;
    }
    if (concept.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
      List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) concept.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
      for (ConceptDefinitionComponent c : children) {
        cc = findCodeInConcept(c, code, altCodeRules);
        if (cc != null) {
          return cc;
        }
      }
    }
    return null;
  }
  
  private ConceptDefinitionComponent findCodeInConcept(List<ConceptDefinitionComponent> concept, String code, AlternateCodesProcessingRules altCodeRules) {
    for (ConceptDefinitionComponent cc : concept) {
      if (code.equals(cc.getCode())) {
        return cc;
      }
      if (Utilities.existsInList(code, alternateCodes(cc, altCodeRules))) {
        return cc;
      }
      ConceptDefinitionComponent c = findCodeInConcept(cc, code, altCodeRules);
      if (c != null) {
        return c;
      }
    }
    return null;
  }


  private List<String> alternateCodes(ConceptDefinitionComponent focus, AlternateCodesProcessingRules altCodeRules) {
    List<String> codes = new ArrayList<>();
    for (ConceptPropertyComponent p : focus.getProperty()) {
      if ("alternateCode".equals(p.getCode()) && (altCodeRules.passes(p.getExtension())) && p.getValue().isPrimitive()) {
        codes.add(p.getValue().primitiveValue());        
      }
    }
    return codes;
  }

  
  private String systemForCodeInValueSet(String code, List<StringWithCode> problems) {
    Set<String> sys = new HashSet<>();
    if (!scanForCodeInValueSet(code, sys, problems)) {
      return null;
    }
    if (sys.size() == 0) {
      problems.add(new StringWithCode(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_NO_MATCHES, code)));
      return null;
    } else if (sys.size() > 1) {
      problems.add(new StringWithCode(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_MULTIPLE_MATCHES, sys.toString())));
      return null;
    } else {
      return sys.iterator().next();
    }
  }
  
  private boolean scanForCodeInValueSet(String code, Set<String> sys, List<StringWithCode> problems) {
    if (valueset.hasCompose()) {
      //  ignore excludes - they can't make any difference
      if (!valueset.getCompose().hasInclude() && !valueset.getExpansion().hasContains()) {
        problems.add(new StringWithCode(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_NO_INCLUDES_OR_EXPANSION, valueset.getVersionedUrl())));
      }

      int i = 0;
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        opContext.deadCheck();
        if (vsi.hasValueSet()) {
          for (CanonicalType u : vsi.getValueSet()) {
            if (!checkForCodeInValueSet(code, u.getValue(), sys, problems)) {
              return false;
            }
          }
        } else if (!vsi.hasSystem()) { 
          problems.add(new StringWithCode(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_NO_SYSTEM, valueset.getVersionedUrl(), i)));
          return false;
        }
        if (vsi.hasSystem()) {
          if (vsi.hasFilter()) {
            problems.add(new StringWithCode(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_FILTER, valueset.getVersionedUrl(), i, vsi.getSystem())));
            return false;
          }
          CodeSystemProvider csp = CodeSystemProvider.factory(vsi.getSystem());
          if (csp != null) {
            Boolean ok = csp.checkCode(code);
            if (ok == null) {
              problems.add(new StringWithCode(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM_SYSTEM_IS_INDETERMINATE, valueset.getVersionedUrl(), vsi.getSystem())));
              sys.add(vsi.getSystem());
            } else if (ok) {
              sys.add(vsi.getSystem());
            }
          } else {
            CodeSystem cs = resolveCodeSystem(vsi.getSystem(), vsi.getVersion());
            if (cs != null && cs.getContent() == CodeSystemContentMode.COMPLETE) {

              if (vsi.hasConcept()) {
                for (ConceptReferenceComponent cc : vsi.getConcept()) {
                  boolean match = cs.getCaseSensitive() ? cc.getCode().equals(code) : cc.getCode().equalsIgnoreCase(code);
                  if (match) {
                    sys.add(vsi.getSystem());
                  }
                }
              } else {
                ConceptDefinitionComponent cc = findCodeInConcept(cs.getConcept(), code, allAltCodes);
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
              // we'll try to expand this one then 
              ValueSetExpansionOutcome vse = context.expandVS(vsi, false, false);
              if (vse.isOk()) {
                if (!checkSystems(vse.getValueset().getExpansion().getContains(), code, sys, problems)) {
                  return false;
                }
              } else {
                problems.add(new StringWithCode(OpIssueCode.NotFound, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_UNKNOWN_SYSTEM, valueset.getVersionedUrl(), i, vsi.getSystem(), vse.getAllErrors().toString())));              
                return false;
              }
            }
          }
        }
        i++;
      }
    } else if (valueset.hasExpansion()) {
      // Retrieve a list of all systems associated with this code in the expansion
      if (!checkSystems(valueset.getExpansion().getContains(), code, sys, problems)) {
        return false;
      }
    }
    return true;
  }

  private boolean checkForCodeInValueSet(String code, String uri, Set<String> sys, List<StringWithCode> problems) {
    ValueSetValidator vs = getVs(uri, null);
    return vs.scanForCodeInValueSet(code, sys, problems);
  }

  /*
   * Recursively go through all codes in the expansion and for any coding that matches the specified code, add the system for that coding
   * to the passed list. 
   */
  private boolean checkSystems(List<ValueSetExpansionContainsComponent> contains, String code, Set<String> systems, List<StringWithCode> problems) {
    for (ValueSetExpansionContainsComponent c: contains) {
      opContext.deadCheck();
      if (c.getCode().equals(code)) {
        systems.add(c.getSystem());
      }
      if (c.hasContains())
        checkSystems(c.getContains(), code, systems, problems);
    }
    return true;
  }
  
  public Boolean codeInValueSet(String path, String system, String version, String code, ValidationProcessInfo info) throws FHIRException {
    if (valueset == null) {
      return null;
    }
    opContext.deadCheck();
    checkCanonical(info.getIssues(), path, valueset, valueset);
    Boolean result = false;
    VersionInfo vi = new VersionInfo(this);
      
    if (valueset.hasExpansion()) {
      return checkExpansion(new Coding(system, code, null), vi);
    } else if (valueset.hasCompose()) {
      int i = 0;
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        Boolean ok = inComponent(path, vsi, i, system, version, code, valueset.getCompose().getInclude().size() == 1, info);
        i++;
        if (ok == null && result != null && result == false) {
          result = null;
        } else if (ok != null && ok) {
          result = true;
          break;
        }
      }
      i = valueset.getCompose().getInclude().size();
      for (ConceptSetComponent vsi : valueset.getCompose().getExclude()) {
        Boolean nok = inComponent(path, vsi, i, system, version, code, valueset.getCompose().getInclude().size() == 1, info);
        i++;
        if (nok == null && result != null && result == false) {
          result = null;
        } else if (nok != null && nok) {
          result = false;
        }
      }
    } 

    return result;
  }

  private Boolean inComponent(String path, ConceptSetComponent vsi, int vsiIndex, String system, String version, String code, boolean only, ValidationProcessInfo info) throws FHIRException {
    opContext.deadCheck();
    boolean ok = true;
    
    if (vsi.hasValueSet()) {
      if (isValueSetUnionImports()) {
        ok = false;
        for (UriType uri : vsi.getValueSet()) {
          if (inImport(path, uri.getValue(), system, version, code, info)) {
            return true;
          }
        }
      } else {
        Boolean bok = inImport(path, vsi.getValueSet().get(0).getValue(), system, version, code, info);
        if (bok == null) {
          return bok;
        }
        ok = bok;
        for (int i = 1; i < vsi.getValueSet().size(); i++) {
          UriType uri = vsi.getValueSet().get(i);
          ok = ok && inImport(path, uri.getValue(), system, version, code, info); 
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

    if (system == null || !system.equals(vsi.getSystem()))
      return false;
    // ok, we need the code system
    CodeSystem cs = resolveCodeSystem(system, version);
    if (cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT)) {
      if (throwToServer) {
        // make up a transient value set with
        ValueSet vs = new ValueSet();
        vs.setStatus(PublicationStatus.ACTIVE);
        vs.setUrl(valueset.getUrl()+"--"+vsiIndex);
        vs.setVersion(valueset.getVersion());
        vs.getCompose().addInclude(vsi);
        ValidationResult res = context.validateCode(options.withNoClient(), new Coding(system, code, null), vs);
        if (res.getErrorClass() == TerminologyServiceErrorClass.UNKNOWN || res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED || res.getErrorClass() == TerminologyServiceErrorClass.VALUESET_UNSUPPORTED) {
          if (info != null && res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
            // server didn't know the code system either - we'll take it face value
            if (!info.hasNotFound(system)) {
              String msg = context.formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_NOTKNOWN, system);
              info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.UNKNOWN, path, msg, OpIssueCode.NotFound, null));
              for (ConceptReferenceComponent cc : vsi.getConcept()) {
                if (cc.getCode().equals(code)) {
                  return true;
                }
              }
            }
            info.setErr(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
            return null;
          }
          return false;
        }
        if (res.getErrorClass() == TerminologyServiceErrorClass.NOSERVICE) {
          throw new NoTerminologyServiceException();
        }
        return res.isOk();
      } else {
        if (unknownSystems != null) {
          if (version == null) {
            unknownSystems.add(system);
          } else {
            unknownSystems.add(system+"|"+version);          
          }
        }
        return null;
      }
    } else {
      checkCanonical(info.getIssues(), path, cs, valueset);
      if ((valueset.getCompose().hasInactive() && !valueset.getCompose().getInactive()) || options.isActiveOnly()) {
        if (CodeSystemUtilities.isInactive(cs, code)) {
          info.addIssue(makeIssue(IssueSeverity.ERROR, IssueType.BUSINESSRULE, path+".code", context.formatMessage(I18nConstants.STATUS_CODE_WARNING_CODE, "not active", code), OpIssueCode.CodeRule, null));        
          return false;
        }
      }
      
      if (vsi.hasFilter()) {
        ok = true;
        for (ConceptSetFilterComponent f : vsi.getFilter()) {
          if (!codeInFilter(cs, system, f, code)) {
            return false;
          }
        }
      }

      List<ConceptDefinitionComponent> list = cs.getConcept();
      ok = validateCodeInConceptList(code, cs, list, allAltCodes);
      if (ok && vsi.hasConcept()) {
        for (ConceptReferenceComponent cc : vsi.getConcept()) {
          if (cc.getCode().equals(code)) { 
            return true;
          }
        }
        return false;
      } else {
        // recheck that this is a valid alternate code
        ok = validateCodeInConceptList(code, cs, list, altCodeParams);
        return ok;
      }
    }
  }

  protected boolean isValueSetUnionImports() {
    PackageInformation p = (PackageInformation) valueset.getSourcePackage();
    if (p != null) {
      return p.getDate().before(new GregorianCalendar(2022, Calendar.MARCH, 31).getTime());
    } else {
      return false;
    }
  }

  private boolean codeInFilter(CodeSystem cs, String system, ConceptSetFilterComponent f, String code) throws FHIRException {
    if ("concept".equals(f.getProperty()))
      return codeInConceptFilter(cs, f, code);
    else if ("code".equals(f.getProperty()) && f.getOp() == FilterOperator.REGEX)
      return codeInRegexFilter(cs, f, code);
    else if (CodeSystemUtilities.hasPropertyDef(cs, f.getProperty())) {
      return codeInPropertyFilter(cs, f, code);
    } else {
      System.out.println("todo: handle filters with property = "+f.getProperty()+" "+f.getOp().toCode()); 
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__FILTER_WITH_PROPERTY__, cs.getUrl(), f.getProperty(), f.getOp().toCode()));
    }
  }

  private boolean codeInPropertyFilter(CodeSystem cs, ConceptSetFilterComponent f, String code) {
    switch (f.getOp()) {
    case EQUAL:
      if (f.getValue() == null) {
        return false;
      }
      DataType d = CodeSystemUtilities.getProperty(cs, code, f.getProperty());
      return d != null && f.getValue().equals(d.primitiveValue());
    case EXISTS: 
      return CodeSystemUtilities.getProperty(cs, code, f.getProperty()) != null;
    case REGEX:
      if (f.getValue() == null) {
        return false;
      }
      d = CodeSystemUtilities.getProperty(cs, code, f.getProperty());
      return d != null && d.primitiveValue() != null && d.primitiveValue().matches(f.getValue());
    default:
      System.out.println("todo: handle property filters with op = "+f.getOp()); 
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__PROPERTY_FILTER_WITH_OP__, cs.getUrl(), f.getOp()));
    }
  }

  private boolean codeInRegexFilter(CodeSystem cs, ConceptSetFilterComponent f, String code) {
    return code.matches(f.getValue());
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

  private boolean codeInConceptIsAFilter(CodeSystem cs, ConceptSetFilterComponent f, String code, boolean excludeRoot) {
    if (!excludeRoot && code.equals(f.getValue())) {
      return true;
    }
    ConceptDefinitionComponent cc = findCodeInConcept(cs.getConcept(), f.getValue(), altCodeParams);
    if (cc == null) {
      return false;
    }
    ConceptDefinitionComponent cc2 = findCodeInConcept(cc, code, altCodeParams);
    return cc2 != null && cc2 != cc;
  }

  public boolean validateCodeInConceptList(String code, CodeSystem def, List<ConceptDefinitionComponent> list, AlternateCodesProcessingRules altCodeRules) {
    opContext.deadCheck();
    if (def.hasUserData("tx.cs.special")) {
      return ((SpecialCodeSystem) def.getUserData("tx.cs.special")).findConcept(new Coding().setCode(code)) != null; 
    } else if (def.getCaseSensitive()) {
      for (ConceptDefinitionComponent cc : list) {
        if (cc.getCode().equals(code)) { 
          return true;
        }
        if (Utilities.existsInList(code, alternateCodes(cc, altCodeRules))) {
          return true;
        }
        if (cc.hasConcept() && validateCodeInConceptList(code, def, cc.getConcept(), altCodeRules)) {
          return true;
        }
      }
    } else {
      for (ConceptDefinitionComponent cc : list) {
        if (cc.getCode().equalsIgnoreCase(code)) { 
          return true;
        }
        if (cc.hasConcept() && validateCodeInConceptList(code, def, cc.getConcept(), altCodeRules)) {
          return true;
        }
      }
    }
    return false;
  }

  private ValueSetValidator getVs(String url, ValidationProcessInfo info) {
    if (inner.containsKey(url)) {
      return inner.get(url);
    }
    ValueSet vs = context.findTxResource(ValueSet.class, url, valueset);
    if (vs == null && info != null) {
      unknownValueSets.add(url);
      info.addIssue(makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, null, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_, url), OpIssueCode.NotFound, null));
    }
    ValueSetValidator vsc = new ValueSetValidator(context, opContext.copy(), options, vs, localContext, expansionProfile, txCaps);
    vsc.setThrowToServer(throwToServer);
    inner.put(url, vsc);
    return vsc;
  }

  private Boolean inImport(String path, String uri, String system, String version, String code, ValidationProcessInfo info) throws FHIRException {
    ValueSetValidator vs = getVs(uri, info);
    if (vs == null) {
      return false;
    } else {
      Boolean ok = vs.codeInValueSet(path, system, version, code, info);
      return ok;
    }
  }


  private String getPreferredDisplay(ConceptReferenceComponent cc) {
    if (!options.hasLanguages()) {
      return cc.getDisplay();
    }
    if (LanguageUtils.langsMatch(options.getLanguages(), valueset.getLanguage())) {
      return cc.getDisplay();
    }
    // if there's no language, we default to accepting the displays as (US) English
    if (valueset.getLanguage() == null && (options.langSummary().contains("en") || options.langSummary().contains("en-US"))) {
      return cc.getDisplay();
    }
    for (ConceptReferenceDesignationComponent d : cc.getDesignation()) {
      if (!d.hasUse() && LanguageUtils.langsMatch(options.getLanguages(), d.getLanguage())) {
        return d.getValue();
      }
    }
    for (ConceptReferenceDesignationComponent d : cc.getDesignation()) {
      if (LanguageUtils.langsMatch(options.getLanguages(), d.getLanguage())) {
        return d.getValue();
      }
    }
    return cc.getDisplay();
  }


  private String getPreferredDisplay(ConceptDefinitionComponent cc, CodeSystem cs) {
    if (!options.hasLanguages()) {
      return cc.getDisplay();
    }
    if (cs != null && LanguageUtils.langsMatch(options.getLanguages(), cs.getLanguage())) {
      return cc.getDisplay();
    }
    // if there's no language, we default to accepting the displays as (US) English
    if ((cs == null || cs.getLanguage() == null) && (options.langSummary().contains("en") || options.langSummary().contains("en-US"))) {
      return cc.getDisplay();
    }
    for (ConceptDefinitionDesignationComponent d : cc.getDesignation()) {
      if (!d.hasUse() && LanguageUtils.langsMatch(options.getLanguages(), d.getLanguage())) {
        return d.getValue();
      }
    }
    for (ConceptDefinitionDesignationComponent d : cc.getDesignation()) {
      if (LanguageUtils.langsMatch(options.getLanguages(), d.getLanguage())) {
        return d.getValue();
      }
    }
    return cc.getDisplay();
  }

}