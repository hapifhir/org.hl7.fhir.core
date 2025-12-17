package org.hl7.fhir.r5.terminologies.validation;

import java.io.IOException;

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

import java.util.*;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.NoTerminologyServiceException;
import org.hl7.fhir.r5.context.BaseWorkerContext;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.LanguageUtils;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientManager;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.providers.CodeSystemProvider;
import org.hl7.fhir.r5.terminologies.providers.SpecialCodeSystem;
import org.hl7.fhir.r5.terminologies.providers.URICodeSystem;
import org.hl7.fhir.r5.terminologies.utilities.*;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.r5.utils.CodingUtilities;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier.ValidationContextResourceProxy;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader.LanguagePreference;
import org.hl7.fhir.utilities.i18n.subtag.LanguageSubtagRegistry;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.i18n.LanguageTag;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import javax.annotation.Nonnull;

@MarkedToMoveToAdjunctPackage
@Slf4j
public class ValueSetValidator extends ValueSetProcessBase {

  public static final String NO_TRY_THE_SERVER = "The local terminology server cannot handle this request";
  private TerminologyServiceErrorClass unknownSystemError;

  public class StringWithCodes {
    private OpIssueCode code;
    private String message;
    private String messageId;
    protected StringWithCodes(OpIssueCode code, String message, String messageId) {
      super();
      this.code = code;
      this.message = message;
      this.messageId = messageId;
    }
    public OpIssueCode getCode() {
      return code;
    }
    public String getMessage() {
      return message;
    }
    public String getMessageId() {return messageId;}
  }

  private ValueSet valueset;
  private Map<String, ValueSetValidator> inner = new HashMap<>();
  private ValidationOptions options;
  private ValidationContextCarrier localContext;
  private List<CodeSystem> localSystems = new ArrayList<>();
  protected Parameters expansionParameters;
  private TerminologyClientManager tcm;
  @Getter
  @Setter
  private Set<String> unknownSystems;
  private Set<String> unknownValueSets = new HashSet<>();
  @Setter
  @Getter
  private boolean throwToServer;
  private LanguageSubtagRegistry registry;
  private Set<String> checkedVersionCombinations = new HashSet<>();


  public ValueSetValidator(BaseWorkerContext context, TerminologyOperationContext opContext, ValidationOptions options, ValueSet source, Parameters expansionProfile, TerminologyClientManager tcm, LanguageSubtagRegistry registry) {
    super(context, opContext);
    this.valueset = source;
    this.options = options;
    this.expansionParameters = expansionProfile;
    this.tcm = tcm;
    this.registry = registry;
    analyseValueSet();
  }
  
  public ValueSetValidator(BaseWorkerContext context, TerminologyOperationContext opContext, ValidationOptions options, ValueSet source, ValidationContextCarrier ctxt, Parameters expansionProfile, TerminologyClientManager tcm, LanguageSubtagRegistry registry) {
    super(context, opContext);
    this.valueset = source;
    this.options = options.copy();
    this.options.setEnglishOk(true);
    this.localContext = ctxt;
    this.expansionParameters = expansionProfile;
    this.tcm = tcm;
    this.registry = registry;
    analyseValueSet();
  }

  private void analyseValueSet() {
    opContext.note("analyse");
    if (valueset != null) {
      opContext.note("vs = "+valueset.getVersionedUrl());
      opContext.seeContext(valueset.getVersionedUrl());
      for (Extension s : valueset.getExtensionsByUrl(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED)) {
        requiredSupplements.add(s.getValue().primitiveValue());
      }

      if (!requiredSupplements.isEmpty()) {
        for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
          if (inc.hasSystem()) {
            checkCodeSystemResolves(inc);
          }
        }
        for (ConceptSetComponent inc : valueset.getCompose().getExclude()) {
          if (inc.hasSystem()) {
            checkCodeSystemResolves(inc);
          }
        }
      }
    } else {
      opContext.note("vs = null");
    }

    altCodeParams.seeParameters(expansionParameters);
    altCodeParams.seeValueSet(valueset);
    if (localContext != null) {
      if (valueset != null) {
        for (ConceptSetComponent i : valueset.getCompose().getInclude()) {
          analyseComponent(i, "inc"+i);
        }
        for (ConceptSetComponent i : valueset.getCompose().getExclude()) {
          analyseComponent(i, "exc"+i);
        }
      }
    }
    opContext.note("analysed");
  }

  private void checkCodeSystemResolves(ConceptSetComponent c) {
    CodeSystem csa = context.fetchCodeSystem(c.getSystem());
    VersionAlgorithm va = csa == null ? VersionAlgorithm.Unknown : VersionAlgorithm.fromType(csa.getVersionAlgorithm());
    String version = determineVersion(c.getSystem(), c.getVersion(), va);
    CodeSystem cs = resolveCodeSystem(c.getSystem(), version, valueset);
    if (cs == null) {
      // well, it doesn't really matter at this point. Mainly we're triggering the supplement analysis to happen 
      opContext.note("Unable to resolve "+c.getSystem()+"#"+version);
    } else {
      checkVersion(null, c.getSystem(), cs.getVersion(), va, null);
    }
  }

  private void analyseComponent(ConceptSetComponent i, String name) {
    opContext.deadCheck("analyse Component "+name);
    if (i.getSystemElement().hasExtension(ExtensionDefinitions.EXT_VALUESET_SYSTEM)) {
      String ref = i.getSystemElement().getExtensionString(ExtensionDefinitions.EXT_VALUESET_SYSTEM);
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
    opContext.deadCheck("validate "+code.toString());
    checkValueSetOptions();

    // first, we validate the codings themselves
    ValidationProcessInfo info = new ValidationProcessInfo();
    
    if (throwToServer) {
      checkValueSetLoad(info);
    }

    CodeableConcept vcc = new CodeableConcept();
    List<ValidationResult> resList = new ArrayList<>();
    
    if (!options.isMembershipOnly()) {
      int i = 0;
      for (Coding c : code.getCoding()) {
        if (!c.hasSystem() && !c.hasUserData(UserDataNames.tx_val_sys_error)) {
          c.setUserData(UserDataNames.tx_val_sys_error, true);
          info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.INVALID, path+".coding["+i+"]",
            context.formatMessage(I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE), OpIssueCode.InvalidData, null, I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE));
        } else {
          checkExpansion(c);
          checkInclude(c);
          CodeSystem csa = context.fetchCodeSystem(c.getSystem());
          VersionAlgorithm va = csa == null ? VersionAlgorithm.Unknown : VersionAlgorithm.fromType(csa.getVersionAlgorithm());
          String version = determineVersion(c.getSystem(), c.getVersion(), va);
          CodeSystem cs = resolveCodeSystem(c.getSystem(), version, valueset);
          ValidationResult res = null;
          if (cs != null) {
            checkVersion(null, c.getSystem(), cs.getVersion(), va, null);
          }
          if (cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.SUPPLEMENT)) {
            if (context.isNoTerminologyServer()) {
              if (c.hasVersion()) {
                String msg = getUnknownCodeSystemMessage(c.getSystem(), c.getVersion());
                res = new ValidationResult(IssueSeverity.ERROR, msg,
                  makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, path+".coding["+i+"].system", msg, OpIssueCode.NotFound, null, getUnknownCodeSystemMessageId(c.getSystem(), c.getVersion()))).setUnknownSystems(unknownSystems);
              } else {
                String msg = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM, c.getSystem(), c.getVersion());
                unknownSystems.add(c.getSystem());
                res = new ValidationResult(IssueSeverity.ERROR, msg,
                  makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, path+".coding["+i+"].system", msg, OpIssueCode.NotFound, null, I18nConstants.UNKNOWN_CODESYSTEM)).setUnknownSystems(unknownSystems);
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
                String status = res.getStatus();
                if (status == null) {
                  status = "inactive";
                }
                String msg = context.formatMessage(I18nConstants.INACTIVE_CONCEPT_FOUND, status, c.getCode());
                res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.BUSINESSRULE, path, msg, OpIssueCode.CodeComment, res.getServer(), I18nConstants.INACTIVE_CONCEPT_FOUND));
                res.mineIssues(res.getIssues());
              }
            }
          } else if (cs.getContent() == CodeSystemContentMode.SUPPLEMENT || cs.hasSupplements()) {
            String msg = context.formatMessage(I18nConstants.CODESYSTEM_CS_NO_SUPPLEMENT, cs.getVersionedUrl());
            res = new ValidationResult(IssueSeverity.ERROR, msg,
              makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, path+".coding["+i+"].system", msg, OpIssueCode.InvalidData, null, I18nConstants.CODESYSTEM_CS_NO_SUPPLEMENT));
          } else {
            c.setUserData(UserDataNames.TX_ASSOCIATED_CODESYSTEM, cs);

            checkCanonical(info.getIssues(), path, cs, valueset);
            res = validateCode(path+".coding["+i+"]", c, cs, vcc, info);
          }
          info.getIssues().addAll(res.getIssues());
          if (res != null) {
            resList.add(res);
            if (!res.isOk() && !res.messageIsInIssues()) {
              // no message ids here
              if (res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
                info.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.NOTFOUND, path+".coding["+i+"]", res.getMessage(), OpIssueCode.NotFound, res.getServer(), null));
              } else {
                info.getIssues().addAll(makeIssue(res.getSeverity(), IssueType.CODEINVALID, path+".coding["+i+"]", res.getMessage(), OpIssueCode.InvalidCode, res.getServer(), null));
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
        Boolean ok = codeInValueSet(path+".coding["+i+"]", c.getSystem(), c.getVersion(), c.getCode(), info);
        if (ok == null && result != null && result == false) {
          result = null;
        } else if (ok != null && ok) {
          result = true;
          foundCoding = c.copy();
          foundCoding.setVersion(info.getFoundVersion());
          if (!options.isMembershipOnly()) {
            vcc.addCoding().setSystem(c.getSystem()).setVersion(info.getFoundVersion()).setCode(c.getCode());
          }
        }
        if (ok == null || !ok) {
          vcc.removeCoding(c.getSystem(), c.getVersion(), c.getCode());          
        }
        if (ok != null && !ok) {
          msg = context.formatMessage(I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_ONE, null, valueset.getVersionedUrl(), cs);
          info.getIssues().addAll(makeIssue(IssueSeverity.INFORMATION, IssueType.CODEINVALID, path+".coding["+i+"].code", msg, OpIssueCode.ThisNotInVS, null, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_ONE));
        }
        i++;
      }
      if (result == null) {
//        String msgid = null;
//        if (!unknownValueSets.isEmpty()) {
//          msgid = I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_VS;
//          msg = context.formatMessage(msgid, valueset.getVersionedUrl(), CommaSeparatedStringBuilder.join(", ", unknownValueSets));
//        } else {
//          msgid = I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_CS;
//          msg = context.formatMessage(msgid, valueset.getVersionedUrl(), b.toString());
//        }
//        info.getIssues().addAll(makeIssue(IssueSeverity.WARNING, unknownSystems.isEmpty() && unknownValueSets.isEmpty() ? IssueType.CODEINVALID : IssueType.NOTFOUND, null, msg, OpIssueCode.VSProcessing, null, msgid));
      } else if (!result) {
        // to match Ontoserver
        OperationOutcomeIssueComponent iss = new OperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR, org.hl7.fhir.r5.model.OperationOutcome.IssueType.CODEINVALID);
        iss.getDetails().setText(context.formatMessage(I18nConstants.TX_GENERAL_CC_ERROR_MESSAGE, valueset.getVersionedUrl()));
        iss.getDetails().addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", OpIssueCode.NotInVS.toCode(), null);
        iss.addExtension(ExtensionDefinitions.EXT_ISSUE_MSG_ID, new StringType(I18nConstants.TX_GENERAL_CC_ERROR_MESSAGE));
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
      ValidationResult res = new ValidationResult(IssueSeverity.ERROR, null, info.getIssues());
      if (foundCoding != null) {
        ConceptDefinitionComponent cd = new ConceptDefinitionComponent(foundCoding.getCode());
        cd.setDisplay(lookupDisplay(foundCoding));
        res.setDefinition(cd);
        res.setSystem(foundCoding.getSystem());
        res.setVersion(foundCoding.hasVersion() ? foundCoding.getVersion() : foundCoding.hasUserData(UserDataNames.TX_ASSOCIATED_CODESYSTEM) ? ((CodeSystem) foundCoding.getUserData(UserDataNames.TX_ASSOCIATED_CODESYSTEM)).getVersion() : null);
        res.setDisplay(cd.getDisplay());
      }
      if (info.getErr() != null) {
        res.setErrorClass(info.getErr());
      } else if (unknownSystemError != null) {
        res.setErrorClass(unknownSystemError);
      }
      res.setUnknownSystems(unknownSystems);
      res.addCodeableConcept(vcc);
      return res;
    } else if (result == null) {
      return new ValidationResult(IssueSeverity.WARNING, null, info.getIssues());
    } else if (foundCoding == null && valueset != null) {
      return new ValidationResult(IssueSeverity.ERROR, "Internal Error that should not happen",
        makeIssue(IssueSeverity.FATAL, IssueType.EXCEPTION, path, "Internal Error that should not happen", OpIssueCode.VSProcessing, null, null));
    } else if (info.getIssues().size() > 0) {
      if (foundCoding == null) {
        IssueSeverity lvl = IssueSeverity.INFORMATION; 
        for (OperationOutcomeIssueComponent iss : info.getIssues()) {
          lvl = IssueSeverity.max(lvl, OperationOutcomeUtilities.convert(iss.getSeverity()));
        }
        return new ValidationResult(lvl, null, info.getIssues());
      } else {
        String disp = lookupDisplay(foundCoding);
        ConceptDefinitionComponent cd = new ConceptDefinitionComponent(foundCoding.getCode());
        cd.setDisplay(disp);
        return new ValidationResult(IssueSeverity.WARNING, info.summaryList(), foundCoding.getSystem(), getVersion(foundCoding), cd, disp, info.getIssues()).addCodeableConcept(vcc);
      }
    } else if (!result) {
      if (valueset != null) {
        throw new Error("This should never happen: no result but is value set");
      } else if (vcc.hasCoding()) {
        return new ValidationResult(vcc.getCodingFirstRep().getSystem(), getVersion(vcc.getCodingFirstRep()), new ConceptDefinitionComponent(vcc.getCodingFirstRep().getCode()).setDisplay(vcc.getCodingFirstRep().getDisplay()), vcc.getCodingFirstRep().getDisplay()).addCodeableConcept(vcc);
      } else {
        throw new Error("This should never happen: no result, no value set, no coding");
      }
    } else if (foundCoding != null) {
      ConceptDefinitionComponent cd = new ConceptDefinitionComponent(foundCoding.getCode());
      cd.setDisplay(lookupDisplay(foundCoding));
      return new ValidationResult(foundCoding.getSystem(), getVersion(foundCoding), cd, getPreferredDisplay(cd, null)).addCodeableConcept(vcc);
    } else {
      throw new Error("This should never happen - ther response from the server could not be understood");
    }
  }

  private String getUnknownCodeSystemMessage(String system, String version) {
    Set<String> set = resolveCodeSystemVersions(system);
    String msg;
    if (set.isEmpty()) {
      msg = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM_VERSION_NONE, system, version);
      unknownSystems.add(system);
    } else {
      msg = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM_VERSION, system, version, CommaSeparatedStringBuilder.join(",", Utilities.sorted(set)));
      unknownSystemError = TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED;
      unknownSystems.add(system + "|" + version);
    }
    return msg;
  }

  private String getUnknownCodeSystemMessageId(String system, String version) {
    Set<String> set = resolveCodeSystemVersions(system);
    if (set.isEmpty()) {
      return I18nConstants.UNKNOWN_CODESYSTEM_VERSION_NONE;
    } else {
      return I18nConstants.UNKNOWN_CODESYSTEM_VERSION;
    }
  }

  private void checkValueSetLoad(ValidationProcessInfo info) {
    int serverCount = getServerLoad(info);
    // There's a trade off here: if we're going to hit the server inside the components, then
    // the amount of value set collateral we send is limited, but we pay the price of hitting 
    // the server multiple times. If, on the other hand, we give up on that, and hit the server 
    // directly, we have to send value set collateral (though we cache at the higher level)
    //
    // the cutoff value is chosen experimentally
    if (serverCount > 2) {
      throw new VSCheckerException("This value set is better processed on the server for performance reasons", null, true);
    }
  }

  private int getServerLoad(ValidationProcessInfo info) {
    int serverCount = 0;
    if (valueset != null) {
      for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
        serverCount = serverCount + checkValueSetLoad(inc, info);
      }
      for (ConceptSetComponent inc : valueset.getCompose().getExclude()) {
        serverCount = serverCount + checkValueSetLoad(inc, info);
      }
    }
    return serverCount;
  }
  
  private int checkValueSetLoad(ConceptSetComponent inc, ValidationProcessInfo info) {
    int serverCount = 0;
    for (UriType uri : inc.getValueSet()) {
      String url = getCu().pinValueSet(uri.getValue(), expansionParameters);
      ValueSetValidator vsv = getVs(url, info);
      serverCount += vsv.getServerLoad(info);
    }
    if (inc.hasSystem()) {
      CodeSystem cs = resolveCodeSystem(inc.getSystem(), inc.getVersion(), valueset);
      if (cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT)) {
        serverCount++;
      }
    }
    return serverCount;
  }

  private boolean checkRequiredSupplements(ValidationProcessInfo info) {
    if (!requiredSupplements.isEmpty()) {
      String msg = context.formatMessagePlural(requiredSupplements.size(), I18nConstants.VALUESET_SUPPLEMENT_MISSING, CommaSeparatedStringBuilder.build(requiredSupplements));
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
    } else if (c.hasUserData(UserDataNames.TX_ASSOCIATED_CODESYSTEM)) {
      return ((CodeSystem) c.getUserData(UserDataNames.TX_ASSOCIATED_CODESYSTEM)).getVersion();
    } else {
      return null;
    }
  }

  private String lookupDisplay(Coding c) {
    CodeSystem cs = resolveCodeSystem(c.getSystem(), c.getVersion(), valueset);
    if (cs != null) {
      ConceptDefinitionComponent cd = CodeSystemUtilities.findCodeOrAltCode(cs.getConcept(), c.getCode(), null);
      if (cd != null) {
        return getPreferredDisplay(cd, cs); 
      }
    }
    return null;
  }

  public CodeSystem resolveCodeSystem(String system, String version, Resource source) {
    for (CodeSystem t : localSystems) {
      if (t.getUrl().equals(system) && versionsMatch(version, t.getVersion())) {
        return t;
      }
    }
    CodeSystem cs = context.fetchSupplementedCodeSystem(system, version, source);
    if (cs == null) {
      cs = findSpecialCodeSystem(system, version);
    }
    if (cs == null) {
      cs = context.findTxResource(CodeSystem.class, system, version, source);
    }
    if (cs != null) {
      if (cs.hasUserData("supplements.installed")) {
        for (String s : cs.getUserString("supplements.installed").split("\\,")) {
          s = removeSupplement(s);
        }
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
    return cs;
  }

  public Set<String> resolveCodeSystemVersions(String system) {
    Set<String> res = new HashSet<>();
    for (CodeSystem t : localSystems) {
      if (t.getUrl().equals(system) && t.hasVersion()) {
        res.add(t.getVersion());
      }
    }
    res.addAll(new ContextUtilities(context).fetchCodeSystemVersions(system));
    return res;
  }

  private boolean versionsMatch(String versionTest, String versionActual) {
    return versionTest == null || versionActual == null || VersionUtilities.versionMatches(versionTest, versionActual);
  }

  public ValidationResult validateCode(Coding code) throws FHIRException {
    return validateCode("Coding", code); 
  }
  
  public ValidationResult validateCode(String path, Coding code) throws FHIRException {
    opContext.deadCheck("validate "+code.toString());
    checkValueSetOptions();
    
    String warningMessage = null;
    // first, we validate the concept itself

    ValidationResult res = null;
    boolean inExpansion = false;
    boolean inInclude = false;
    List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
    ValidationProcessInfo info = new ValidationProcessInfo(issues);
    checkCanonical(issues, path, valueset, valueset);

    String system = code.getSystem();
    if (!options.isMembershipOnly()) {
      if (system == null && !code.hasDisplay() && options.isGuessSystem()) { // dealing with just a plain code (enum)
        List<StringWithCodes> problems = new ArrayList<>();
        system = systemForCodeInValueSet(code.getCode(), problems);
        if (system == null) {
          if (problems.size() == 0) {
            throw new Error("Unable to resolve systems but no reason why"); // this is an error in the java code
          } else if (problems.size() == 1) {
            String msg = context.formatMessagePlural(1, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getVersionedUrl(), "'"+code.toString()+"'");
            issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.CODEINVALID, "code", msg, OpIssueCode.NotInVS, null, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_ONE));
            issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, "code", problems.get(0).getMessage(), problems.get(0).getCode(), null, problems.get(0).getMessageId()));
            return new ValidationResult(IssueSeverity.ERROR, problems.get(0).getMessage(), msg, issues);
          } else {
            CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("; ");
            for (StringWithCodes s : problems) {
              b.append(s.getMessage());
            }            
            ValidationResult vr = new ValidationResult(IssueSeverity.ERROR, b.toString(), null);
            for (StringWithCodes s : problems) {
              vr.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.UNKNOWN, path, s.getMessage(), s.getCode(), vr.getServer(), s.getMessageId()));
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
        if (!code.hasUserData(UserDataNames.tx_val_sys_error)) {
          code.setUserData(UserDataNames.tx_val_sys_error, true);
          res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.INVALID, path, context.formatMessage(I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE), OpIssueCode.InvalidData, null, I18nConstants.CODING_HAS_NO_SYSTEM__CANNOT_VALIDATE));res.mineIssues(res.getIssues());
          res.mineIssues(res.getIssues());
        }
      } else {
        if (!Utilities.isAbsoluteUrl(system)) {
          String msg = context.formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_RELATIVE);
          issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, path+".system", msg, OpIssueCode.InvalidData, null, I18nConstants.TERMINOLOGY_TX_SYSTEM_RELATIVE));
        }
        inExpansion = checkExpansion(code);
        inInclude = checkInclude(code);
        String workingVersion = getCodeSystemVersionFromValueSet(system, code.getCode());
        CodeSystem csa = context.fetchCodeSystem(system); // get the latest
        VersionAlgorithm va = csa == null ? VersionAlgorithm.Unknown : VersionAlgorithm.fromType(csa.getVersionAlgorithm());
        String wv = determineVersion(path, system, workingVersion, code.getVersion(), issues, va);
        CodeSystem cs = resolveCodeSystem(system, wv, null);
        if (cs == null) {
          if (!VersionUtilities.isR6Plus(context.getVersion()) && "urn:ietf:bcp:13".equals(system) && Utilities.existsInList(code.getCode(), "xml", "json", "ttl") && "http://hl7.org/fhir/ValueSet/mimetypes".equals(valueset.getUrl())) {
            return new ValidationResult(system, null, new ConceptDefinitionComponent(code.getCode()), "application/fhir+"+code.getCode());        
          } else {
            OpIssueCode oic = OpIssueCode.NotFound;
            IssueType itype = IssueType.NOTFOUND;
            ValueSet vs = context.fetchResource(ValueSet.class, system);
            String msgid = null;
            if (vs != null) {
              msgid = I18nConstants.TERMINOLOGY_TX_SYSTEM_VALUESET2;
              warningMessage = context.formatMessage(I18nConstants.TERMINOLOGY_TX_SYSTEM_VALUESET2, system);  
              oic = OpIssueCode.InvalidData;
              itype = IssueType.INVALID;
            } else if (wv == null) {
              msgid = I18nConstants.UNKNOWN_CODESYSTEM;
              warningMessage = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM, system);
              unknownSystems.add(system);
            } else {
              msgid = getUnknownCodeSystemMessageId(system, wv);
              warningMessage = getUnknownCodeSystemMessage(system, wv);
            }
            if (!inExpansion) {
              if (valueset != null && valueset.hasExpansion()) {
                String msg = context.formatMessage(I18nConstants.CODESYSTEM_CS_UNK_EXPANSION,
                    valueset.getUrl(), 
                    code.getSystem(), 
                    code.getCode().toString());
                issues.addAll(makeIssue(IssueSeverity.ERROR, itype, path, msg, OpIssueCode.VSProcessing, null, I18nConstants.CODESYSTEM_CS_UNK_EXPANSION));
                throw new VSCheckerException(msg, issues, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
              } else {
                issues.addAll(makeIssue(IssueSeverity.ERROR, itype, path+".system", warningMessage, oic, null, msgid));
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
          }
        } else {
          checkCanonical(issues, path, cs, valueset);
        }
        if (cs != null && (cs.hasSupplements() || cs.getContent() == CodeSystemContentMode.SUPPLEMENT)) {
          String msg = context.formatMessage(I18nConstants.CODESYSTEM_CS_NO_SUPPLEMENT, cs.getVersionedUrl());
          return new ValidationResult(IssueSeverity.ERROR, msg, makeIssue(IssueSeverity.ERROR, IssueType.INVALID, path+".system", msg, OpIssueCode.InvalidData, null, I18nConstants.CODESYSTEM_CS_NO_SUPPLEMENT));        
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
          if (cs.getContent() == CodeSystemContentMode.NOTPRESENT) {
            throw new VSCheckerException(warningMessage, null, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
          }
          if (!options.isExampleOK() && !inExpansion && cs.getContent() != CodeSystemContentMode.FRAGMENT) { // we're going to give it a go if it's a fragment
            throw new VSCheckerException(warningMessage, null, true);
          }
        }

        if (cs != null /*&& (cs.getContent() == CodeSystemContentMode.COMPLETE || cs.getContent() == CodeSystemContentMode.FRAGMENT)*/) {
          if (!(cs.getContent() == CodeSystemContentMode.COMPLETE || cs.getContent() == CodeSystemContentMode.FRAGMENT ||
              (options.isExampleOK() && cs.getContent() == CodeSystemContentMode.EXAMPLE))) {
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
            throw new FHIRException("Unable to evaluate based on code system with status = "+cs.getContent().toCode());
          }
          res = validateCode(path, code, cs, null, info);
          res.setIssues(issues);
        } else if (cs == null && valueset.hasExpansion() && inExpansion) {
          for (ValueSetExpansionParameterComponent p : valueset.getExpansion().getParameter()) {
            if ("used-supplement".equals(p.getName())) {
              removeSupplement(p.getValue().primitiveValue());
            }
          }
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
      inExpansion = checkExpansion(code);
      inInclude = checkInclude(code);
    }
    String valueSetImpliedVersion = getCodeSystemVersionFromValueSet(system, code.getCode());
    CodeSystem csa = context.fetchCodeSystem(system); // get the latest
    VersionAlgorithm va = csa == null ? VersionAlgorithm.Unknown : VersionAlgorithm.fromType(csa.getVersionAlgorithm());
    String wv = determineVersion(path, system, valueSetImpliedVersion, code.getVersion(), issues, va);
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
          } else {
            res.mineIssues(info.getIssues());
          }
          if (info.getErr() != null) {
            res.setErrorClass(info.getErr());
          }
          if (ok == null) {
            String m = null;
            String msgid = null;
            if (!unknownSystems.isEmpty()) {
//              msgid = I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_CS;
//              m = context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_CS, valueset.getVersionedUrl(), CommaSeparatedStringBuilder.join(",", unknownSystems));
            } else if (!unknownValueSets.isEmpty()) {
//              msgid = I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_VS;
//              res.addMessage(info.getIssues().get(0).getDetails().getText());
//              m = context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_VS, valueset.getVersionedUrl(), CommaSeparatedStringBuilder.join(",", unknownValueSets));
            } else {
              // not sure why we'd get to here?
//              msgid = I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_;
//              m = context.formatMessage(I18nConstants.UNABLE_TO_CHECK_IF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getVersionedUrl());
            }
            if (m != null) {
              res.addMessage(m);
              res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.NOTFOUND, null, m, OpIssueCode.VSProcessing, null, msgid));
              res.mineIssues(res.getIssues());
              res.setUnknownSystems(unknownSystems);
              res.setSeverity(IssueSeverity.ERROR); // back patching for display logic issue
              res.setErrorClass(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
            }
          } else if (!inExpansion && !inInclude) {
//            if (!info.getIssues().isEmpty()) {
//              res.setMessage("Not in value set "+valueset.getUrl()+": "+info.summary()).setSeverity(IssueSeverity.ERROR);              
//              res.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, path, res.getMessage()));
//            } else
//            {
              String msg = context.formatMessagePlural(1, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getVersionedUrl(), "'"+code.toString()+"'");
              res.addMessage(msg).setSeverity(IssueSeverity.ERROR);
              res.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.CODEINVALID, path+".code", msg, OpIssueCode.NotInVS, null, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_ONE));
              res.mineIssues(res.getIssues());
              res.setDefinition(null);
              res.setSystem(null);
              res.setDisplay(null);
              res.setUnknownSystems(unknownSystems);              
//            }
          } else if (warningMessage!=null) {
            String msg = context.formatMessage(I18nConstants.CODE_FOUND_IN_EXPANSION_HOWEVER_, warningMessage);
            res = new ValidationResult(IssueSeverity.WARNING, msg, makeIssue(IssueSeverity.WARNING, IssueType.EXCEPTION, path, msg, OpIssueCode.VSProcessing, null, I18nConstants.CODE_FOUND_IN_EXPANSION_HOWEVER_));
          } else if (inExpansion) {
            res.setMessage("Code found in expansion, however: " + res.getMessage());
            res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.EXCEPTION, path, res.getMessage(), OpIssueCode.VSProcessing, null, null)); // no message id?
            res.mineIssues(res.getIssues());
          } else if (inInclude) {
            res.setMessage("Code found in include, however: " + res.getMessage());
            res.getIssues().addAll(makeIssue(IssueSeverity.WARNING, IssueType.EXCEPTION, path, res.getMessage(), OpIssueCode.VSProcessing, null, null)); // no message id?
            res.mineIssues(res.getIssues());
          }
        } else if (res == null) {
          res = new ValidationResult(system, wv, null, null);
        }
      } else if ((res != null && !res.isOk())) {
        String msg = context.formatMessagePlural(1, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_, valueset.getVersionedUrl(), "'"+code.toString()+"'");
        res.addMessage(msg);
        res.getIssues().addAll(makeIssue(IssueSeverity.ERROR, IssueType.CODEINVALID, path+".code", msg, OpIssueCode.NotInVS, null, I18nConstants.NONE_OF_THE_PROVIDED_CODES_ARE_IN_THE_VALUE_SET_ONE));
        res.mineIssues(res.getIssues());
      }
    }
    if (res != null && res.isOk()) { // check that there aren't issues that should make it fail anyway
      List<String> msgs = new ArrayList<>();
      for (OperationOutcomeIssueComponent issue : issues) {
        if (issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR) {
          msgs.add(issue.getDetails().getText());
        }
      }
      if (!msgs.isEmpty()) {
        if (res.getMessage() == null) {
          msgs.add(0, res.getMessage());
        }
        res.setSeverity(IssueSeverity.ERROR);
        res.setMessage(CommaSeparatedStringBuilder.join("; ", msgs));
      }
    }
    if (res != null && unknownSystems != null) {
      res.setUnknownSystems(unknownSystems);
      if (unknownSystemError != null) {
        res.setErrorClass(unknownSystemError);
      }
    }

    if (res != null && res.getSeverity() == IssueSeverity.INFORMATION && res.getMessage() != null) {
      res.setSeverity(IssueSeverity.ERROR); // back patching for display logic issue
    }
    return res;
  }

  private String getCodeSystemVersionFromValueSet(String system, String code) {
    if (valueset == null) {
      return null;
    }
    for (ConceptSetComponent inc : valueset.getCompose().getInclude()) {
      if (inc.hasSystem() && inc.getSystem().equals(system) && inc.hasVersion()) {
        boolean ok = true;
        if (inc.hasConcept()) {
          ok = false;
          for (ConceptReferenceComponent c : inc.getConcept()) {
            if (code.equals(c.getCode())) {
              ok = true;
              break;
            }
          }
        }
        if (ok) {
          return inc.getVersion();
        }
      }
    }
    return null;
  }

  private void checkValueSetOptions() {
    if (valueset != null) {
      for (Extension ext : valueset.getCompose().getExtensionsByUrl(ExtensionDefinitions.EXT_VS_EXP_PARAM_NEW, ExtensionDefinitions.EXT_VS_EXP_PARAM_OLD)) {
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

    if (options.getLanguages() != null) {
      for (LanguagePreference t : options.getLanguages().getLangs()) {
        try {
          LanguageTag tag = new LanguageTag(registry, t.getLang());
        } catch (Exception e) {
          throw new TerminologyServiceProtectionException(context.formatMessage(I18nConstants.INVALID_DISPLAY_NAME, options.getLanguages().getSource()), TerminologyServiceErrorClass.PROCESSING, IssueType.PROCESSING, e.getMessage());
        }
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
    
    try {
      if (tcm.supportsSystem(system)) {
        return true;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  
    return false;    
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
      cs.setUserData(UserDataNames.tx_cs_special, new URICodeSystem());
      cs.setContent(CodeSystemContentMode.COMPLETE);
      return cs; 
    }
    if (Utilities.isAbsoluteUrl(system)) {
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, system, version, null);
      if (sd != null) {
        return CodeSystemUtilities.convertSD(sd);
      }
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
      opContext.deadCheck("findCodeInExpansion");
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

  private boolean checkExpansion(Coding code) {
    if (valueset==null || !valueset.hasExpansion()) {
      return false;
    }
    return checkExpansion(code, valueset.getExpansion().getContains());
  }

  private boolean checkExpansion(Coding code, List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent containsComponent: contains) {
      opContext.deadCheck("checkExpansion: "+code.toString());
      if (containsComponent.hasSystem() && containsComponent.hasCode() && containsComponent.getSystem().equals(code.getSystem()) && containsComponent.getCode().equals(code.getCode())) {
        return true;
      }
      if (containsComponent.hasContains() && checkExpansion(code, containsComponent.getContains())) {
        return true;
      }
    }
    return false;
  }

  private ValidationResult validateCode(String path, Coding code, CodeSystem cs, CodeableConcept vcc, ValidationProcessInfo info) {
    if (code.getCode() == null) {
      String msgid = cs.getVersion() == null ? I18nConstants.NO_CODE_PROVIDED : I18nConstants.NO_CODE_PROVIDED_VERSION;
      String msg = context.formatMessage(msgid, cs.getUrl(), cs.getVersion());
      return new ValidationResult(IssueSeverity.WARNING, msg, makeIssue(IssueSeverity.WARNING, IssueType.VALUE, path + ".code", msg, OpIssueCode.InvalidData, null, msgid));
    }
    ConceptDefinitionComponent cc = cs.hasUserData(UserDataNames.tx_cs_special) ? ((SpecialCodeSystem) cs.getUserData(UserDataNames.tx_cs_special)).findConcept(code) : findCodeInConcept(cs.getConcept(), code.getCode(), cs.getCaseSensitive(), allAltCodes);
    if (cc == null) {
      cc = findSpecialConcept(code, cs);
    }
    if (cc == null) {
      if (cs.getContent() == CodeSystemContentMode.FRAGMENT) {
        String msg = context.formatMessage(I18nConstants.UNKNOWN_CODE_IN_FRAGMENT, code.getCode(), cs.getUrl(), cs.getVersion());
        return new ValidationResult(IssueSeverity.WARNING, msg, makeIssue(IssueSeverity.WARNING, IssueType.CODEINVALID, path + ".code", msg, OpIssueCode.InvalidCode, null, I18nConstants.UNKNOWN_CODE_IN_FRAGMENT));
      } else {
        String msg = context.formatMessage(I18nConstants.UNKNOWN_CODE_IN_VERSION, code.getCode(), cs.getUrl(), cs.getVersion());
        return new ValidationResult(IssueSeverity.ERROR, msg, makeIssue(IssueSeverity.ERROR, IssueType.CODEINVALID, path + ".code", msg, OpIssueCode.InvalidCode, null, I18nConstants.UNKNOWN_CODE_IN_VERSION));
      }
    } else {
      if (!cc.getCode().equals(code.getCode())) {
        String msg = context.formatMessage(I18nConstants.CODE_CASE_DIFFERENCE, code.getCode(), cc.getCode(), cs.getVersionedUrl());
        info.addIssue(makeIssue(IssueSeverity.INFORMATION, IssueType.BUSINESSRULE, path + ".code", msg, OpIssueCode.CodeRule, null, I18nConstants.CODE_CASE_DIFFERENCE));
      }
    }
    Coding vc = new Coding().setCode(cc.getCode()).setSystem(cs.getUrl()).setVersion(cs.getVersion()).setDisplay(getPreferredDisplay(cc, cs));
    if (vcc != null) {
      vcc.addCoding(vc);
    }

    boolean inactive = (CodeSystemUtilities.isInactive(cs, cc));
    String status = CodeSystemUtilities.getStatus(cs, cc);

    String statusMessage = null;
    if (inactive) {
      statusMessage = context.formatMessage(I18nConstants.INACTIVE_CONCEPT_FOUND, status == null ? "inactive" : status, cc.getCode());
      info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.BUSINESSRULE, path, statusMessage, OpIssueCode.CodeComment, null, I18nConstants.INACTIVE_CONCEPT_FOUND));
    } else if (status != null && "deprecated".equals(status.toLowerCase())) {
      statusMessage = context.formatMessage(I18nConstants.DEPRECATED_CONCEPT_FOUND, status == null ? "inactive" : status, cc.getCode());
      info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.BUSINESSRULE, path, statusMessage, OpIssueCode.CodeComment, null, I18nConstants.DEPRECATED_CONCEPT_FOUND));
    }
    boolean isDefaultLang = false;
    boolean ws = false;     
    if (code.getDisplay() == null) {
      if (statusMessage == null) {
        return new ValidationResult(code.getSystem(), cs.getVersion(), cc, vc.getDisplay()).setStatus(inactive, status);
      } else {
        return new ValidationResult(IssueSeverity.WARNING, statusMessage, code.getSystem(), cs.getVersion(), cc, vc.getDisplay(), null).setStatus(inactive, status);
      }
    }
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(", ", " or ");
    if (cc.hasDisplay() && isOkLanguage(cs.getLanguage())) {
      b.append("'"+cc.getDisplay()+"'"+(cs.hasLanguage() ? " ("+cs.getLanguage()+")" : ""));
      if (code.getDisplay().equalsIgnoreCase(cc.getDisplay())) {
        return new ValidationResult(code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs)).setStatus(inactive, status);
      } else if (Utilities.normalize(code.getDisplay()).equals(Utilities.normalize(cc.getDisplay()))) {
        ws = true;
      }
    } else if (cc.hasDisplay() && code.getDisplay().equalsIgnoreCase(cc.getDisplay())) {
      isDefaultLang = true;
    }
    
    for (ConceptDefinitionDesignationComponent ds : cc.getDesignation()) {
      opContext.deadCheck("validateCode1 "+ds.toString());
      if (isOkLanguage(ds.getLanguage())) {
        b.append("'"+ds.getValue()+"' ("+ds.getLanguage()+")");
        if (code.getDisplay().equalsIgnoreCase(ds.getValue())) {
          if (ds.hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status")) {
            String dstatus = ds.getExtensionString("http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status");
            List<String> ok = new ArrayList<>();
            ok.add(cc.getDisplay());
            for (ConceptDefinitionDesignationComponent ds1 : cc.getDesignation()) {
              if (isOkLanguage(ds.getLanguage()) && !ds.hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status")) {
                ok.add(ds.getValue());
              }
            }
            Collections.sort(ok);
            String msg = context.formatMessagePlural(ok.size(), I18nConstants.INACTIVE_DISPLAY_FOUND, code.getDisplay(), cc.getCode(), CommaSeparatedStringBuilder.join(", ", ok), dstatus);
            info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.INVALID, path+".display", msg, OpIssueCode.DisplayComment, null, I18nConstants.INACTIVE_DISPLAY_FOUND));
          }
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
          opContext.deadCheck("validateCode2 "+ds.toString());
          if (isOkLanguage(ds.getLanguage())) {
            b.append("'"+ds.getValue()+"'");
            if (code.getDisplay().equalsIgnoreCase(ds.getValue())) {
              return new ValidationResult(code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs)).setStatus(inactive, status);
            }
          }
        }
      }
    }
    if (b.count() > 0) {
      String msgId = ws ? I18nConstants.DISPLAY_NAME_WS_FOR__SHOULD_BE_ONE_OF__INSTEAD_OF : I18nConstants.DISPLAY_NAME_FOR__SHOULD_BE_ONE_OF__INSTEAD_OF;
      String msg = context.formatMessagePlural(b.count(), msgId, code.getSystem(), code.getCode(), b.toString(), code.getDisplay(), options.langSummary());
      return new ValidationResult(dispWarningStatus(), msg, code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs), makeIssue(dispWarning(), IssueType.INVALID, path+".display", msg, OpIssueCode.Display, null, msgId)).setStatus(inactive, status);
    } else if (isDefaultLang) {
      // we didn't find any valid displays because there aren't any, so the default language is acceptable, but we'll still add a hint about that
      boolean none = options.getLanguages().getLangs().size() == 1 && !hasLanguage(cs, options.getLanguages().getLangs().get(0));
      String msgid = none ? I18nConstants.NO_VALID_DISPLAY_FOUND_LANG_NONE : I18nConstants.NO_VALID_DISPLAY_FOUND_LANG_SOME;
      String msg = context.formatMessagePlural(options.getLanguages().getLangs().size(), msgid, code.getSystem(), code.getCode(), code.getDisplay(), options.langSummary(), code.getDisplay());
      String n = null;
      return new ValidationResult(IssueSeverity.INFORMATION, n, code.getSystem(), cs.getVersion(), cc, getPreferredDisplay(cc, cs), makeIssue(IssueSeverity.INFORMATION, IssueType.INVALID, path+".display", msg, OpIssueCode.DisplayComment, null, msgid)).setStatus(inactive, status);
    } else if (!code.getDisplay().equals(vc.getDisplay())) {
      String msg = context.formatMessage(I18nConstants.NO_VALID_DISPLAY_FOUND_NONE_FOR_LANG_ERR, code.getDisplay(), code.getSystem(), code.getCode(), options.langSummary(), vc.getDisplay());
      return new ValidationResult(IssueSeverity.ERROR, msg, code.getSystem(), cs.getVersion(), cc, cc.getDisplay(), makeIssue(dispWarning(), IssueType.INVALID, path+".display", msg, OpIssueCode.Display, null, I18nConstants.NO_VALID_DISPLAY_FOUND_NONE_FOR_LANG_ERR)).setStatus(inactive, status).setErrorIsDisplayIssue(true);
    } else {
      String msg = context.formatMessagePlural(options.getLanguages().getLangs().size(), I18nConstants.NO_VALID_DISPLAY_FOUND, code.getSystem(), code.getCode(), code.getDisplay(), options.langSummary());
      return new ValidationResult(IssueSeverity.WARNING, msg, code.getSystem(), cs.getVersion(), cc, cc.getDisplay(), makeIssue(IssueSeverity.WARNING, IssueType.INVALID, path+".display", msg, OpIssueCode.Display, null, I18nConstants.NO_VALID_DISPLAY_FOUND)).setStatus(inactive, status);
    }
  }

  private boolean hasLanguage(CodeSystem cs, LanguagePreference languagePreference) {
    String lang = languagePreference.getLang();
    if (lang == null) {
      return false;
    }
    for (ConceptDefinitionComponent cc : cs.getConcept()) {
      boolean hl = hasLanguage(cs, cc, lang);
      if (hl) {
        return true;
      }
    }
    return false;
  }

  private boolean hasLanguage(CodeSystem cs, ConceptDefinitionComponent cc, String lang) {
    if (lang.equals(cs.getLanguage()) && cc.hasDisplay()) {
      return true;
    }
    for (ConceptDefinitionDesignationComponent d : cc.getDesignation()) {
      if (lang.equals(d.getLanguage())) {
        return true;
      }
    }
    for (ConceptDefinitionComponent cc1 : cc.getConcept()) {
      boolean hl = hasLanguage(cs, cc1, lang);
      if (hl) {
        return true;
      }
    }
    return false;
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
      opContext.deadCheck("findValueSetRef "+exp.toString());
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
        ConceptReferencePair cc = getVs(getCu().pinValueSet(url.asStringValue(), expansionParameters), null).findValueSetRef(system, code);
        if (cc != null) {
          return cc;
        }
      }
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

  private ConceptDefinitionComponent findCodeInConcept(ConceptDefinitionComponent concept, String code, boolean caseSensitive, AlternateCodesProcessingRules altCodeRules) {
    opContext.deadCheck("findCodeInConcept: "+code.toString()+", "+concept.toString());
    if (code.equals(concept.getCode())) {
      return concept;
    }
    ConceptDefinitionComponent cc = findCodeInConcept(concept.getConcept(), code, caseSensitive, altCodeRules);
    if (cc != null) {
      return cc;
    }
    if (concept.hasUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK)) {
      List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) concept.getUserData(CodeSystemUtilities.USER_DATA_CROSS_LINK);
      for (ConceptDefinitionComponent c : children) {
        cc = findCodeInConcept(c, code, caseSensitive, altCodeRules);
        if (cc != null) {
          return cc;
        }
      }
    }
    return null;
  }
  
  private ConceptDefinitionComponent findCodeInConcept(List<ConceptDefinitionComponent> concept, String code, boolean caseSensitive, AlternateCodesProcessingRules altCodeRules) {
    if (code == null) {
      return null;
    }
    for (ConceptDefinitionComponent cc : concept) {
      if (code.equals(cc.getCode()) || (!caseSensitive && (code.equalsIgnoreCase(cc.getCode())))) {
        return cc;
      }
      if (Utilities.existsInList(code, alternateCodes(cc, altCodeRules))) {
        return cc;
      }
      ConceptDefinitionComponent c = findCodeInConcept(cc, code, caseSensitive, altCodeRules);
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

  
  private String systemForCodeInValueSet(String code, List<StringWithCodes> problems) {
    Set<String> sys = new HashSet<>();
    if (!scanForCodeInValueSet(code, sys, problems)) {
      return null;
    }
    if (sys.size() == 0) {
      problems.add(new StringWithCodes(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_INFER_CODESYSTEM, code, valueset.getVersionedUrl()), I18nConstants.UNABLE_TO_INFER_CODESYSTEM));
      return null;
    } else if (sys.size() > 1) {
      problems.add(new StringWithCodes(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_MULTIPLE_MATCHES, code, valueset.getVersionedUrl(), sys.toString()), I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_MULTIPLE_MATCHES));
      return null;
    } else {
      return sys.iterator().next();
    }
  }
  
  private boolean scanForCodeInValueSet(String code, Set<String> sys, List<StringWithCodes> problems) {
    if (valueset.hasCompose()) {
      //  ignore excludes - they can't make any difference
      if (!valueset.getCompose().hasInclude() && !valueset.getExpansion().hasContains()) {
        problems.add(new StringWithCodes(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_NO_INCLUDES_OR_EXPANSION, code, valueset.getVersionedUrl()), I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_NO_INCLUDES_OR_EXPANSION));
      }

      int i = 0;
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        opContext.deadCheck("scanForCodeInValueSet: "+code.toString());
        if (scanForCodeInValueSetInclude(code, sys, problems, i, vsi)) {
          return true;
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

  private boolean scanForCodeInValueSetInclude(String code, Set<String> sys, List<StringWithCodes> problems, int i, ConceptSetComponent vsi) {
    if (vsi.hasValueSet()) {
      for (CanonicalType u : vsi.getValueSet()) {
        if (!checkForCodeInValueSet(code, getCu().pinValueSet(u.getValue(), expansionParameters), sys, problems)) {
          return false;
        }
      }
    } else if (!vsi.hasSystem()) { 
      problems.add(new StringWithCodes(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_NO_SYSTEM, code, valueset.getVersionedUrl(), i), I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_NO_SYSTEM));
      return false;
    }
    if (vsi.hasSystem()) {
      if (vsi.hasFilter()) {
        ValueSet vsDummy = new ValueSet();
        vsDummy.setUrl(UUIDUtilities.makeUuidUrn());
        vsDummy.setStatus(PublicationStatus.ACTIVE);
        vsDummy.getCompose().addInclude(vsi);
        Coding c = new Coding().setCode(code).setSystem(vsi.getSystem());
        ValidationResult vr = context.validateCode(options.withGuessSystem(false), c, vsDummy);
        if (vr.isOk()) {
          sys.add(vsi.getSystem());
        } else {
          // problems.add(new StringWithCode(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_FILTER, code, valueset.getVersionedUrl(), i, vsi.getSystem(), filterSummary(vsi))));
          return false;
        }
      }
      CodeSystemProvider csp = CodeSystemProvider.factory(vsi.getSystem());
      if (csp != null) {
        Boolean ok = csp.checkCode(code);
        if (ok == null) {
          problems.add(new StringWithCodes(OpIssueCode.InferFailed, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM_SYSTEM_IS_INDETERMINATE, code, valueset.getVersionedUrl(), vsi.getSystem()), I18nConstants.UNABLE_TO_RESOLVE_SYSTEM_SYSTEM_IS_INDETERMINATE));
          sys.add(vsi.getSystem());
        } else if (ok) {
          sys.add(vsi.getSystem());
        }
      } else {
        CodeSystem cs = resolveCodeSystem(vsi.getSystem(), vsi.getVersion(), valueset);
        if (cs != null && cs.getContent() == CodeSystemContentMode.COMPLETE) {
          if (vsi.hasConcept()) {
            for (ConceptReferenceComponent cc : vsi.getConcept()) {
              boolean match = cs.getCaseSensitive() ? cc.getCode().equals(code) : cc.getCode().equalsIgnoreCase(code);
              if (match) {
                sys.add(vsi.getSystem());
              }
            }
          } else {
            ConceptDefinitionComponent cc = findCodeInConcept(cs.getConcept(), code, cs.getCaseSensitive(), allAltCodes);
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
        } else if (!VersionUtilities.isR6Plus(context.getVersion()) && Utilities.existsInList(code, "xml", "json", "ttl") && "urn:ietf:bcp:13".equals(vsi.getSystem())) {
          sys.add(vsi.getSystem());
          return true;
        } else {
          ValueSet vsDummy = new ValueSet();
          vsDummy.setUrl(UUIDUtilities.makeUuidUrn());
          vsDummy.setStatus(PublicationStatus.ACTIVE);
          vsDummy.getCompose().addInclude(vsi);
          ValidationResult vr = context.validateCode(options.withNoClient(), code, vsDummy);
          if (vr.isOk()) {
            sys.add(vsi.getSystem());
          } else {
            // ok, we'll try to expand this one then 
            ValueSetExpansionOutcome vse = context.expandVS(new TerminologyOperationDetails(requiredSupplements), vsi, false, false);
            if (vse.isOk()) {
              if (!checkSystems(vse.getValueset().getExpansion().getContains(), code, sys, problems)) {
                return false;
              }
            } else {
              problems.add(new StringWithCodes(OpIssueCode.NotFound, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_UNKNOWN_SYSTEM, code, valueset.getVersionedUrl(), i, vsi.getSystem(), vse.getAllErrors().toString()), I18nConstants.UNABLE_TO_RESOLVE_SYSTEM__VALUE_SET_HAS_INCLUDE_WITH_UNKNOWN_SYSTEM));
              return false;
            }

          }
        }
      }
    }
    return false;
  }

  private String filterSummary(ConceptSetComponent vsi) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (ConceptSetFilterComponent f : vsi.getFilter()) {
      b.append(f.getProperty()+f.getOp().toCode()+f.getValue());
    }
    return b.toString();
  }

  private boolean checkForCodeInValueSet(String code, String uri, Set<String> sys, List<StringWithCodes> problems) {
    ValueSetValidator vs = getVs(uri, null);
    return vs.scanForCodeInValueSet(code, sys, problems);
  }

  /*
   * Recursively go through all codes in the expansion and for any coding that matches the specified code, add the system for that coding
   * to the passed list. 
   */
  private boolean checkSystems(List<ValueSetExpansionContainsComponent> contains, String code, Set<String> systems, List<StringWithCodes> problems) {
    for (ValueSetExpansionContainsComponent c: contains) {
      opContext.deadCheck("checkSystems "+code.toString());
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
    opContext.deadCheck("codeInValueSet: "+system+"#"+code);
    checkCanonical(info.getIssues(), path, valueset, valueset);
    Boolean result = false;
    String vspath = "ValueSet['"+valueset.getVersionedUrl()+"].compose";
      
    if (valueset.hasExpansion()) {
      return checkExpansion(new Coding(system, code, null));
    } else if (valueset.hasCompose()) {
      int i = 0;
      int c = 0;
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        Boolean ok = inComponent(path, vsi, i, system, version, code, valueset.getCompose().getInclude().size() == 1, info, vspath+".include["+c+"]", info.getIssues());
        i++;
        c++;
        if (ok == null && result != null && result == false) {
          result = null;
        } else if (ok != null && ok) {
          result = true;
          break;
        }
      }
      i = valueset.getCompose().getInclude().size();
      c = 0;
      for (ConceptSetComponent vsi : valueset.getCompose().getExclude()) {
        Boolean nok = inComponent(path, vsi, i, system, version, code, valueset.getCompose().getInclude().size() == 1, info, vspath+".exclude["+c+"]", info.getIssues());
        i++;
        c++;
        if (nok == null && result != null && result == false) {
          result = null;
        } else if (nok != null && nok) {
          result = false;
        }
      }
    } 

    return result;
  }

  private String determineVersion(String path, @Nonnull String system, String versionVS, String versionCoding, List<OperationOutcomeIssueComponent> issues, VersionAlgorithm va) {
    Resource source = valueset;

    // phase 1: get correct system version
    String result = determineVersion(system, versionVS, va);

    if (!Utilities.noString(versionCoding)) {
      // phase 3: figure out the correct code system version
      // if versionCoding is more detailed than result, then we use that instead
      if (versionIsMoreDetailed(va, result, versionCoding)) {
        result = versionCoding;
        source = null;
      }
      String key = system+"^"+result+"^"+versionVS+"^"+versionCoding;
      if (!checkedVersionCombinations.contains(key)) {
        checkedVersionCombinations.add(key);

        // phase 4: is the determined version compatible?
        CodeSystem cs = context.fetchResource(CodeSystem.class, system, result, source);
        if (cs != null) {
          checkVersion(path, system, cs.getVersion(), va, issues);
        }
        if (cs != null && !(versionCoding.equals(cs.getVersion()) || versionIsMoreDetailed(va, versionCoding, cs.getVersion()))) {
          if (result == null) {
            issues.addAll(makeIssue(cs.getVersionNeeded() ? IssueSeverity.ERROR : IssueSeverity.WARNING, IssueType.INVALID, Utilities.noString(path) ? "version" : path + "." + "version",
              context.formatMessage(I18nConstants.VALUESET_VALUE_MISMATCH_DEFAULT, system, cs.getVersion(), notNull(versionVS), notNull(versionCoding)), OpIssueCode.VSProcessing, null, I18nConstants.VALUESET_VALUE_MISMATCH_DEFAULT));
          } else if (!result.equals(versionVS)) {
            issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, Utilities.noString(path) ? "version" : path + "." + "version",
              context.formatMessage(I18nConstants.VALUESET_VALUE_MISMATCH_CHANGED, system, result, notNull(versionVS), notNull(versionCoding)), OpIssueCode.VSProcessing, null, I18nConstants.VALUESET_VALUE_MISMATCH_CHANGED));
          } else if (!notNull(versionVS).equals(notNull(versionCoding))) {
            issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, Utilities.noString(path) ? "version" : path + "." + "version",
              context.formatMessage(I18nConstants.VALUESET_VALUE_MISMATCH, system, notNull(versionVS), notNull(versionCoding)), OpIssueCode.VSProcessing, null, I18nConstants.VALUESET_VALUE_MISMATCH));
          }
          CodeSystem cs2 = context.fetchCodeSystem(system, versionCoding, source);
          if (cs2 == null) {
            List<CodeSystem> list = context.fetchResourceVersions(CodeSystem.class, system);
            Set<String> versions = new HashSet<>();
            for (CodeSystem c : list) {
              versions.add(c.getVersion());
            }
            if (!unknownSystems.contains(system + '|' + versionCoding)) {
              unknownSystemError = TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED;
              unknownSystems.add(system + '|' + versionCoding);
              issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, Utilities.noString(path) ? "version" : path + "." + "system",
                context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM_VERSION, system, versionCoding, CommaSeparatedStringBuilder.join(",", Utilities.sorted(versions))), OpIssueCode.NotFound, null, I18nConstants.UNKNOWN_CODESYSTEM_VERSION));
            }
          }
        } else if (cs == null && result != null && !versionCoding.equals(result)) {
          issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, Utilities.noString(path) ? "version" : path + "." + "version",
            context.formatMessage(I18nConstants.VALUESET_VALUE_MISMATCH, system, result, versionCoding), OpIssueCode.VSProcessing, null, I18nConstants.VALUESET_VALUE_MISMATCH));
        }
      }
    }
    return result;
  }

  private Object notNull(String s) {
    return s == null ? "" : s;
  }

  private boolean versionIsMoreDetailed(VersionAlgorithm va, String criteria, String candidate) {
    if (va == VersionAlgorithm.Unknown) {
      va = VersionAlgorithm.guessFormat(candidate);
    }
    switch (va) {
      case SemVer:
        return  VersionUtilities.isSemVerWithWildcards(criteria) && VersionUtilities.isSemVer(candidate) && VersionUtilities.versionMatches(criteria, candidate);
      default:
        return candidate.startsWith(criteria);
    }
  }

  private String determineVersion(@Nonnull String system, @Nonnull String version, VersionAlgorithm va) {
    String result = version;
    List<Parameters.ParametersParameterComponent> rules = new ArrayList<>();
    for (Parameters.ParametersParameterComponent p : expansionParameters.getParameter()) {
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
    for (Parameters.ParametersParameterComponent t : rules) {
      if ("force-system-version".equals(t.getName())) {
        String tv = t.getValue().primitiveValue().substring(system.length() + 1);
        if (!b) {
          result = tv;
        } else if (!tv.equals(result)) {
          throw failWithIssue(IssueType.EXCEPTION, OpIssueCode.VersionError, null, I18nConstants.SYSTEM_VERSION_MULTIPLE_OVERRIDE, system, result, tv);
        }
      }
    }
    if (Utilities.noString(result)) {
      b = false;
      for (Parameters.ParametersParameterComponent t : rules) {
        if ("system-version".equals(t.getName())) {
          String tv = t.getValue().primitiveValue().substring(system.length() + 1);
          if (!b) {
            result = tv;
          } else if (!tv.equals(result)) {
            throw failWithIssue(IssueType.EXCEPTION, OpIssueCode.VersionError, null, I18nConstants.SYSTEM_VERSION_MULTIPLE_DEFAULT, system, result, tv);
          }
        }
      }
    }
    for (Parameters.ParametersParameterComponent t : rules) {
      if ("check-system-version".equals(t.getName())) {
        String tv = t.getValue().primitiveValue().substring(system.length() + 1);
        if (Utilities.noString(result)) {
          result = tv;
        }
      }
    }
    return result;
  }

  private void checkVersion(String path, @Nonnull String system, @Nonnull String version, VersionAlgorithm va, List<OperationOutcomeIssueComponent> issues) {
    List<Parameters.ParametersParameterComponent> rules = new ArrayList<>();
    for (Parameters.ParametersParameterComponent p : expansionParameters.getParameter()) {
      if ("check-system-version".equalsIgnoreCase(p.getName()) && p.getValue().primitiveValue() != null && p.getValue().primitiveValue().startsWith(system+"|")) {
        rules.add(p);
      }
    }
    for (Parameters.ParametersParameterComponent t : rules) {
      String tv = t.getValue().primitiveValue().substring(system.length() + 1);
      if (!versionsMatch(system, version, tv)) {
        if (issues == null) {
          throw failWithIssue(IssueType.EXCEPTION, OpIssueCode.VersionError, null, I18nConstants.VALUESET_VERSION_CHECK, system, version, tv);
        } else {
          String msg = context.formatMessage(I18nConstants.VALUESET_VERSION_CHECK, system, version, tv);
          if (!hasIssue(issues, msg)) {
             issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.EXCEPTION, Utilities.noString(path) ? "version" : path + "." + "version", msg, OpIssueCode.VersionError, null, I18nConstants.VALUESET_VERSION_CHECK));
          }
        }
      }
    }
  }

  private boolean hasIssue(List<OperationOutcomeIssueComponent> issues, String msg) {
    for (OperationOutcomeIssueComponent t : issues) {
      if (msg.equals(t.getDetails().getText())) {
        return true;
      }
    }
    return false;
  }

  private Boolean inComponent(String path, ConceptSetComponent vsi, int vsiIndex, String system, String version, String code, boolean only, ValidationProcessInfo info, String vspath, List<OperationOutcomeIssueComponent> issues) throws FHIRException {
    opContext.deadCheck("inComponent "+vsiIndex);
    boolean ok = true;
    
    if (vsi.hasValueSet()) {
      if (isValueSetUnionImports()) {
        ok = false;
        for (UriType uri : vsi.getValueSet()) {
          if (inImport(path, getCu().pinValueSet(uri.getValue(), expansionParameters), system, version, code, info)) {
            return true;
          }
        }
      } else {
        Boolean bok = inImport(path, getCu().pinValueSet(vsi.getValueSet().get(0).getValue(), expansionParameters), system, version, code, info);
        if (bok == null) {
          return bok;
        }
        ok = bok;
        for (int i = 1; i < vsi.getValueSet().size(); i++) {
          UriType uri = vsi.getValueSet().get(i);
          ok = ok && inImport(path, getCu().pinValueSet(uri.getValue(), expansionParameters), system, version, code, info); 
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
    CodeSystem csa = context.fetchCodeSystem(system); //
    VersionAlgorithm va = csa == null ? VersionAlgorithm.Unknown : VersionAlgorithm.fromType(csa.getVersionAlgorithm());
    String actualVersion = determineVersion(path, system, vsi.getVersion(), version, issues, va);
    CodeSystem cs = resolveCodeSystem(system, actualVersion, valueset);
    if (cs == null || (cs.getContent() != CodeSystemContentMode.COMPLETE && cs.getContent() != CodeSystemContentMode.FRAGMENT)) {
      if (throwToServer) {
        // make up a transient value set with
        ValueSet vs = new ValueSet();
        vs.setStatus(PublicationStatus.ACTIVE);
        vs.setUrl(valueset.getUrl()+"--"+vsiIndex);
        vs.setVersion(valueset.getVersion());
        vs.getCompose().addInclude(vsi);
        opContext.deadCheck("hit server "+vs.getVersionedUrl());
        ValidationResult res = context.validateCode(options.withNoClient(), new Coding(system, code, null), vs);
        if (res.getErrorClass() == TerminologyServiceErrorClass.UNKNOWN || res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED || res.getErrorClass() == TerminologyServiceErrorClass.VALUESET_UNSUPPORTED) {
          if (info != null && res.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
            // server didn't know the code system either - we'll take it face value
            if (!info.hasNotFound(system)) {
              String msg = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM, system);
              info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.UNKNOWN, path, msg, OpIssueCode.NotFound, null, I18nConstants.UNKNOWN_CODESYSTEM));
              for (ConceptReferenceComponent cc : vsi.getConcept()) {
                if (cc.getCode().equals(code)) {
                  opContext.deadCheck("server true");
                  return true;
                }
              }
            }
            info.setErr(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
            opContext.deadCheck("server codesystem unsupported");
            return null;
          }
          opContext.deadCheck("server not found");
          return false;
        }
        if (res.getErrorClass() == TerminologyServiceErrorClass.NOSERVICE) {
          opContext.deadCheck("server no server");
          throw new NoTerminologyServiceException();
        }
        return res.isOk();
      } else {
        info.setErr(TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED);
        if (unknownSystems != null) {
          if (actualVersion == null) {
            unknownSystems.add(system);
          } else {
             unknownSystems.add(system+"|"+actualVersion);
          }
        }
        Set<String> versions = resolveCodeSystemVersions(system);
        if (!versions.isEmpty()) {
          String msg = context.formatMessage(I18nConstants.UNKNOWN_CODESYSTEM_VERSION, system, actualVersion, CommaSeparatedStringBuilder.join(",", Utilities.sorted(versions)));
          if (!hasIssue(issues, msg)) {
            issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, Utilities.noString(path) ? "version" : path + "." + "system", msg, OpIssueCode.NotFound, null, I18nConstants.UNKNOWN_CODESYSTEM_VERSION));
          }
        }
        return null;
      }
    } else {
      info.setFoundVersion(cs.getVersion());
      checkVersion(path, vsi.getSystem(), cs.getVersion(), va, issues);
      checkCanonical(info.getIssues(), path, cs, valueset);
      if ((valueset.getCompose().hasInactive() && !valueset.getCompose().getInactive()) || options.isActiveOnly()) {
        if (CodeSystemUtilities.isInactive(cs, code)) {
          info.addIssue(makeIssue(IssueSeverity.ERROR, IssueType.BUSINESSRULE, path+".code", context.formatMessage(I18nConstants.STATUS_CODE_WARNING_CODE, "not active", code), OpIssueCode.CodeRule, null, I18nConstants.STATUS_CODE_WARNING_CODE));
          return false;
        }
      }
      
      if (vsi.hasFilter()) {
        ok = true;
        int i = 0;
        for (ConceptSetFilterComponent f : vsi.getFilter()) {
          if (!codeInFilter(cs, vspath+".filter["+i+"]", system, f, code)) {
            return false;
          }
          i++;
        }
      }

      List<ConceptDefinitionComponent> list = cs.getConcept();
      ok = validateCodeInConceptList(code, cs, list, allAltCodes);
      if (ok && vsi.hasConcept()) {
        for (ConceptReferenceComponent cc : vsi.getConcept()) {
          if (cc.getCode().equals(code)) {
            String sstatus = cc.getExtensionString(ExtensionDefinitions.EXT_STANDARDS_STATUS);
            if (Utilities.existsInList(sstatus, "withdrawn", "deprecated")) {
              String msg = context.formatMessage(I18nConstants.CONCEPT_DEPRECATED_IN_VALUESET, cs.getUrl(), cc.getCode(), sstatus, valueset.getVersionedUrl());
              info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.BUSINESSRULE, path+".code", msg, OpIssueCode.CodeComment, null, I18nConstants.CONCEPT_DEPRECATED_IN_VALUESET));
            } else if (cc.hasExtension(ExtensionDefinitions.EXT_VALUESET_DEPRECATED)) {
              String msg = context.formatMessage(I18nConstants.CONCEPT_DEPRECATED_IN_VALUESET, cs.getUrl(), cc.getCode(), "deprecated", valueset.getVersionedUrl());
              info.addIssue(makeIssue(IssueSeverity.WARNING, IssueType.BUSINESSRULE, path+".code", msg, OpIssueCode.CodeComment, null, I18nConstants.CONCEPT_DEPRECATED_IN_VALUESET));
            }
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

  private boolean codeInFilter(CodeSystem cs, String path, String system, ConceptSetFilterComponent f, String code) throws FHIRException {
    String v = f.getValue();
    if (v == null) {
      List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
      issues.addAll(makeIssue(IssueSeverity.ERROR, IssueType.INVALID, path+".value", context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM_FILTER_WITH_NO_VALUE,
        cs.getUrl(), f.getProperty(), f.getOp().toCode()), OpIssueCode.VSProcessing, null, I18nConstants.UNABLE_TO_HANDLE_SYSTEM_FILTER_WITH_NO_VALUE));
      throw new VSCheckerException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM_FILTER_WITH_NO_VALUE, cs.getUrl(), f.getProperty(), f.getOp().toCode()), issues, TerminologyServiceErrorClass.INTERNAL_ERROR);
      
    }
    if ("concept".equals(f.getProperty()))
      return codeInConceptFilter(cs, f, code);
    else if ("code".equals(f.getProperty()) && f.getOp() == FilterOperator.REGEX)
      return codeInRegexFilter(cs, f, code);
    else if ("code".equals(f.getProperty()) && f.getOp() == FilterOperator.EQUAL)
      return codeInCodeEquals(cs, f, code);
    else if (CodeSystemUtilities.isDefinedProperty(cs, f.getProperty())) {
      return codeInPropertyFilter(cs, f, code);
    } else if (isKnownProperty(f.getProperty())) {
      return codeInKnownPropertyFilter(cs, f, code);
    } else {
      log.error("todo: handle filters with property = "+f.getProperty()+" "+f.getOp().toCode());
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__FILTER_WITH_PROPERTY__, cs.getUrl(), f.getProperty(), f.getOp().toCode()));
    }
  }

  private boolean isKnownProperty(String code) {
    return Utilities.existsInList(code, "notSelectable");
  }

  private boolean codeInPropertyFilter(CodeSystem cs, ConceptSetFilterComponent f, String code) {
    switch (f.getOp()) {
    case EQUAL:
      if (f.getValue() == null) {
        return false;
      }
      DataType d = CodeSystemUtilities.getProperty(cs, code, f.getProperty());
      if (d instanceof Coding) {
        return CodingUtilities.filterEquals((Coding) d, f.getValue());
      } else {
        return d != null && f.getValue().equals(d.primitiveValue());
      }
    case EXISTS: 
      return CodeSystemUtilities.getProperty(cs, code, f.getProperty()) != null;
    case REGEX:
      if (f.getValue() == null) {
        return false;
      }
      d = CodeSystemUtilities.getProperty(cs, code, f.getProperty());
      if (d instanceof Coding) {
        return CodingUtilities.filterMatches((Coding) d, f.getValue());
      } else {
        return d != null && d.primitiveValue() != null && d.primitiveValue().matches(f.getValue());
      }
    case IN:
      if (f.getValue() == null) {
        return false;
      }
      String[] values = f.getValue().split("\\,");
      d = CodeSystemUtilities.getProperty(cs, code, f.getProperty());
      if (d != null) {
        String v = d.primitiveValue();
        for (String value : values) {
          if (v != null && v.equals(value.trim())) {
            return true;
          }
        }
      }
      return false;
    case NOTIN:
      if (f.getValue() == null) {
        return true;
      }
      values = f.getValue().split("\\,");
      d = CodeSystemUtilities.getProperty(cs, code, f.getProperty());
      if (d != null) {
        String v = d.primitiveValue();
        for (String value : values) {
          if (v != null && v.equals(value.trim())) {
            return false;
          }
        }
      }
      return true;
    default:
      log.error("todo: handle property filters with op = "+f.getOp());
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__PROPERTY_FILTER_WITH_OP__, cs.getUrl(), f.getOp()));
    }
  }
  
  private boolean codeInKnownPropertyFilter(CodeSystem cs, ConceptSetFilterComponent f, String code) {

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
      log.error("todo: handle known property filters with op = "+f.getOp());
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__PROPERTY_FILTER_WITH_OP__, cs.getUrl(), f.getOp()));
    }
  }

  private boolean codeInRegexFilter(CodeSystem cs, ConceptSetFilterComponent f, String code) {
    return code.matches(f.getValue());
  }

  private boolean codeInConceptFilter(CodeSystem cs, ConceptSetFilterComponent f, String code) throws FHIRException {
    switch (f.getOp()) {
    case ISA: return codeInConceptIsAFilter(cs, f, code, false);
    case EQUAL:
      if (f.getValue() == null) {
        return false;
      }
      DataType d = CodeSystemUtilities.getProperty(cs, code, f.getProperty());
      return d != null && f.getValue().equals(d.primitiveValue());
    case ISNOTA: return !codeInConceptIsAFilter(cs, f, code, false);
    case DESCENDENTOF: return codeInConceptIsAFilter(cs, f, code, true); 
    default:
      log.error("todo: handle concept filters with op = "+f.getOp());
      throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_HANDLE_SYSTEM__CONCEPT_FILTER_WITH_OP__, cs.getUrl(), f.getOp()));
    }
  }

  private boolean codeInCodeEquals(CodeSystem cs, ConceptSetFilterComponent f, String code) throws FHIRException {
      if (f.getValue() == null) {
        return false;
      }
      DataType d = CodeSystemUtilities.getProperty(cs, code, f.getProperty());
      return d != null && f.getValue().equals(d.primitiveValue());
  }

  private boolean codeInConceptIsAFilter(CodeSystem cs, ConceptSetFilterComponent f, String code, boolean excludeRoot) {
    if (!excludeRoot && code.equals(f.getValue())) {
      return true;
    }
    ConceptDefinitionComponent cc = findCodeInConcept(cs.getConcept(), f.getValue(), cs.getCaseSensitive(), altCodeParams);
    if (cc == null) {
      return false;
    }
    ConceptDefinitionComponent cc2 = findCodeInConcept(cc, code, cs.getCaseSensitive(), altCodeParams);
    return cc2 != null && cc2 != cc;
  }

  public boolean validateCodeInConceptList(String code, CodeSystem def, List<ConceptDefinitionComponent> list, AlternateCodesProcessingRules altCodeRules) {
    opContext.deadCheck("validateCodeInConceptList");
    if (def.hasUserData(UserDataNames.tx_cs_special)) {
      return ((SpecialCodeSystem) def.getUserData(UserDataNames.tx_cs_special)).findConcept(new Coding().setCode(code)) != null; 
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
    ValueSet vs = context.findTxResource(ValueSet.class, url, null, valueset);
    if (vs == null && info != null) {
      unknownValueSets.add(url);
      info.addIssue(makeIssue(IssueSeverity.ERROR, IssueType.NOTFOUND, null, context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_, url), OpIssueCode.NotFound, null, I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_));
    }
    ValueSetValidator vsc = new ValueSetValidator(context, opContext.copy(), options, vs, localContext, expansionParameters, tcm, registry);
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