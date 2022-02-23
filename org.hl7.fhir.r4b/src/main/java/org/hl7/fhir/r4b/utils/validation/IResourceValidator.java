package org.hl7.fhir.r4b.utils.validation;

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


import com.google.gson.JsonObject;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r4b.utils.validation.constants.CheckDisplayOption;
import org.hl7.fhir.r4b.utils.validation.constants.IdStatus;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Interface to the instance validator. This takes a resource, in one of many forms, and 
 * checks whether it is valid
   *  
   * @author Grahame Grieve
   *
   */
public interface IResourceValidator {

  /**
   * how much to check displays for coded elements 
   */
  CheckDisplayOption getCheckDisplay();
  void setCheckDisplay(CheckDisplayOption checkDisplay);

  /**
   * whether the resource must have an id or not (depends on context)
   */
	IdStatus getResourceIdRule();
	void setResourceIdRule(IdStatus resourceIdRule);
  
  /**
   * whether the validator should enforce best practice guidelines
   * as defined by various HL7 committees 
   */
  BestPracticeWarningLevel getBestPracticeWarningLevel();
  IResourceValidator setBestPracticeWarningLevel(BestPracticeWarningLevel value);

  IValidatorResourceFetcher getFetcher();
  IResourceValidator setFetcher(IValidatorResourceFetcher value);

  IValidationPolicyAdvisor getPolicyAdvisor();
  IResourceValidator setPolicyAdvisor(IValidationPolicyAdvisor advisor);

  IValidationProfileUsageTracker getTracker();
  IResourceValidator setTracker(IValidationProfileUsageTracker value);

  boolean isNoBindingMsgSuppressed();
  IResourceValidator setNoBindingMsgSuppressed(boolean noBindingMsgSuppressed);
  
  boolean isNoInvariantChecks();
  IResourceValidator setNoInvariantChecks(boolean value) ;

  boolean isWantInvariantInMessage();
  IResourceValidator setWantInvariantInMessage(boolean wantInvariantInMessage);

  boolean isNoTerminologyChecks();
  IResourceValidator setNoTerminologyChecks(boolean noTerminologyChecks);

  boolean isNoExtensibleWarnings();
  IResourceValidator setNoExtensibleWarnings(boolean noExtensibleWarnings);
  
  boolean isNoUnicodeBiDiControlChars();
  void setNoUnicodeBiDiControlChars(boolean noUnicodeBiDiControlChars);
  
  /**
   * Whether being unable to resolve a profile in found in Resource.meta.profile or ElementDefinition.type.profile or targetProfile is an error or just a warning
   */
  boolean isErrorForUnknownProfiles();
  void setErrorForUnknownProfiles(boolean errorForUnknownProfiles);

  boolean isShowMessagesFromReferences();
  void setShowMessagesFromReferences(boolean value);

  /** 
   * this is used internally in the publishing stack to ensure that everything is water tight, but 
   * this check is not necessary or appropriate at run time when the validator is hosted in HAPI
   * @return
   */
  boolean isWantCheckSnapshotUnchanged();
  void setWantCheckSnapshotUnchanged(boolean wantCheckSnapshotUnchanged);
  
  /**
   * It's common to see references such as Patient/234234 - these usually mean a reference to a Patient resource. 
   * But there's no actual technical rule that it does, so the validator doesn't enforce that unless this setting is 
   * set to true
   * 
   * @return
   */
  boolean isAssumeValidRestReferences();
  void setAssumeValidRestReferences(boolean value);
  
  /** 
   * if this is true, the validator will accept extensions and references to example.org and acme.com as 
   * valid, on the basis that they are understood to be references to content that could exist in priniple but can't in practice
   */
  boolean isAllowExamples();
  void setAllowExamples(boolean value) ;
 
  boolean isNoCheckAggregation();
  void setNoCheckAggregation(boolean value);

  /**
   * CrumbTrail - whether the validator creates hints to 
   * @return
   */
  boolean isCrumbTrails();
  void setCrumbTrails(boolean crumbTrails);

  boolean isValidateValueSetCodesOnTxServer();
  void setValidateValueSetCodesOnTxServer(boolean value);

  /** 
   * Bundle validation rules allow for requesting particular entries in a bundle get validated against particular profiles
   * Typically this is used from the command line to avoid having to construct profile just to validate a particular resource 
   * in a bundle against a particular profile 
   *  
   * @return
   */
  List<BundleValidationRule> getBundleValidationRules();
  
  /**
   * Validate suite
   *  
   * you can validate one of the following representations of resources:
   *  
   * stream - provide a format - this is the preferred choice
   * 
   * Use one of these two if the content is known to be valid XML/JSON, and already parsed
   * - a DOM element or Document
   * - a Json Object
   *  
   * In order to use these, the content must already be parsed - e.g. it must syntactically valid    
   * - a native resource
   * - a elementmodel resource  
   * 
   * in addition, you can pass one or more profiles ti validate beyond the base standard - as structure definitions or canonical URLs 
   * @throws IOException 
   */
  void validate(Object Context, List<ValidationMessage> errors, String initialPath, org.hl7.fhir.r4b.elementmodel.Element element) throws FHIRException;
  void validate(Object Context, List<ValidationMessage> errors, String initialPath, org.hl7.fhir.r4b.elementmodel.Element element, String profile) throws FHIRException;
  void validate(Object Context, List<ValidationMessage> errors, String initialPath, org.hl7.fhir.r4b.elementmodel.Element element, List<StructureDefinition> profiles) throws FHIRException;
  
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, InputStream stream, FhirFormat format) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, InputStream stream, FhirFormat format, String profile) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, InputStream stream, FhirFormat format, List<StructureDefinition> profiles) throws FHIRException;

  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.hl7.fhir.r4b.model.Resource resource) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.hl7.fhir.r4b.model.Resource resource, String profile) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.hl7.fhir.r4b.model.Resource resource, List<StructureDefinition> profiles) throws FHIRException;

  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.w3c.dom.Element element) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.w3c.dom.Element element, String profile) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.w3c.dom.Element element, List<StructureDefinition> profile) throws FHIRException;

  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.w3c.dom.Document document) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.w3c.dom.Document document, String profile) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, org.w3c.dom.Document document, List<StructureDefinition> profile) throws FHIRException;

  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, JsonObject object) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, JsonObject object, String profile) throws FHIRException;
  org.hl7.fhir.r4b.elementmodel.Element validate(Object Context, List<ValidationMessage> errors, JsonObject object, List<StructureDefinition> profile) throws FHIRException;


}