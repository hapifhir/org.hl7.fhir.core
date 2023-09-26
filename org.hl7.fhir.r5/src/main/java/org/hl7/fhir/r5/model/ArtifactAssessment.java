package org.hl7.fhir.r5.model;


/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution and rights management metadata for the added content.
 */
@ResourceDef(name="ArtifactAssessment", profile="http://hl7.org/fhir/StructureDefinition/ArtifactAssessment")
public class ArtifactAssessment extends DomainResource {

    public enum ArtifactAssessmentDisposition {
        /**
         * The comment is unresolved
         */
        UNRESOLVED, 
        /**
         * The comment is not persuasive (rejected in full)
         */
        NOTPERSUASIVE, 
        /**
         * The comment is persuasive (accepted in full)
         */
        PERSUASIVE, 
        /**
         * The comment is persuasive with modification (partially accepted)
         */
        PERSUASIVEWITHMODIFICATION, 
        /**
         * The comment is not persuasive with modification (partially rejected)
         */
        NOTPERSUASIVEWITHMODIFICATION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ArtifactAssessmentDisposition fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("unresolved".equals(codeString))
          return UNRESOLVED;
        if ("not-persuasive".equals(codeString))
          return NOTPERSUASIVE;
        if ("persuasive".equals(codeString))
          return PERSUASIVE;
        if ("persuasive-with-modification".equals(codeString))
          return PERSUASIVEWITHMODIFICATION;
        if ("not-persuasive-with-modification".equals(codeString))
          return NOTPERSUASIVEWITHMODIFICATION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ArtifactAssessmentDisposition code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case UNRESOLVED: return "unresolved";
            case NOTPERSUASIVE: return "not-persuasive";
            case PERSUASIVE: return "persuasive";
            case PERSUASIVEWITHMODIFICATION: return "persuasive-with-modification";
            case NOTPERSUASIVEWITHMODIFICATION: return "not-persuasive-with-modification";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case UNRESOLVED: return "http://hl7.org/fhir/artifactassessment-disposition";
            case NOTPERSUASIVE: return "http://hl7.org/fhir/artifactassessment-disposition";
            case PERSUASIVE: return "http://hl7.org/fhir/artifactassessment-disposition";
            case PERSUASIVEWITHMODIFICATION: return "http://hl7.org/fhir/artifactassessment-disposition";
            case NOTPERSUASIVEWITHMODIFICATION: return "http://hl7.org/fhir/artifactassessment-disposition";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case UNRESOLVED: return "The comment is unresolved";
            case NOTPERSUASIVE: return "The comment is not persuasive (rejected in full)";
            case PERSUASIVE: return "The comment is persuasive (accepted in full)";
            case PERSUASIVEWITHMODIFICATION: return "The comment is persuasive with modification (partially accepted)";
            case NOTPERSUASIVEWITHMODIFICATION: return "The comment is not persuasive with modification (partially rejected)";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case UNRESOLVED: return "Unresolved";
            case NOTPERSUASIVE: return "Not Persuasive";
            case PERSUASIVE: return "Persuasive";
            case PERSUASIVEWITHMODIFICATION: return "Persuasive with Modification";
            case NOTPERSUASIVEWITHMODIFICATION: return "Not Persuasive with Modification";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ArtifactAssessmentDispositionEnumFactory implements EnumFactory<ArtifactAssessmentDisposition> {
    public ArtifactAssessmentDisposition fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("unresolved".equals(codeString))
          return ArtifactAssessmentDisposition.UNRESOLVED;
        if ("not-persuasive".equals(codeString))
          return ArtifactAssessmentDisposition.NOTPERSUASIVE;
        if ("persuasive".equals(codeString))
          return ArtifactAssessmentDisposition.PERSUASIVE;
        if ("persuasive-with-modification".equals(codeString))
          return ArtifactAssessmentDisposition.PERSUASIVEWITHMODIFICATION;
        if ("not-persuasive-with-modification".equals(codeString))
          return ArtifactAssessmentDisposition.NOTPERSUASIVEWITHMODIFICATION;
        throw new IllegalArgumentException("Unknown ArtifactAssessmentDisposition code '"+codeString+"'");
        }
        public Enumeration<ArtifactAssessmentDisposition> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ArtifactAssessmentDisposition>(this, ArtifactAssessmentDisposition.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ArtifactAssessmentDisposition>(this, ArtifactAssessmentDisposition.NULL, code);
        if ("unresolved".equals(codeString))
          return new Enumeration<ArtifactAssessmentDisposition>(this, ArtifactAssessmentDisposition.UNRESOLVED, code);
        if ("not-persuasive".equals(codeString))
          return new Enumeration<ArtifactAssessmentDisposition>(this, ArtifactAssessmentDisposition.NOTPERSUASIVE, code);
        if ("persuasive".equals(codeString))
          return new Enumeration<ArtifactAssessmentDisposition>(this, ArtifactAssessmentDisposition.PERSUASIVE, code);
        if ("persuasive-with-modification".equals(codeString))
          return new Enumeration<ArtifactAssessmentDisposition>(this, ArtifactAssessmentDisposition.PERSUASIVEWITHMODIFICATION, code);
        if ("not-persuasive-with-modification".equals(codeString))
          return new Enumeration<ArtifactAssessmentDisposition>(this, ArtifactAssessmentDisposition.NOTPERSUASIVEWITHMODIFICATION, code);
        throw new FHIRException("Unknown ArtifactAssessmentDisposition code '"+codeString+"'");
        }
    public String toCode(ArtifactAssessmentDisposition code) {
      if (code == ArtifactAssessmentDisposition.UNRESOLVED)
        return "unresolved";
      if (code == ArtifactAssessmentDisposition.NOTPERSUASIVE)
        return "not-persuasive";
      if (code == ArtifactAssessmentDisposition.PERSUASIVE)
        return "persuasive";
      if (code == ArtifactAssessmentDisposition.PERSUASIVEWITHMODIFICATION)
        return "persuasive-with-modification";
      if (code == ArtifactAssessmentDisposition.NOTPERSUASIVEWITHMODIFICATION)
        return "not-persuasive-with-modification";
      return "?";
      }
    public String toSystem(ArtifactAssessmentDisposition code) {
      return code.getSystem();
      }
    }

    public enum ArtifactAssessmentInformationType {
        /**
         * A comment on the artifact
         */
        COMMENT, 
        /**
         * A classifier of the artifact
         */
        CLASSIFIER, 
        /**
         * A rating of the artifact
         */
        RATING, 
        /**
         * A container for multiple components
         */
        CONTAINER, 
        /**
         * A response to a comment
         */
        RESPONSE, 
        /**
         * A change request for the artifact
         */
        CHANGEREQUEST, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ArtifactAssessmentInformationType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("comment".equals(codeString))
          return COMMENT;
        if ("classifier".equals(codeString))
          return CLASSIFIER;
        if ("rating".equals(codeString))
          return RATING;
        if ("container".equals(codeString))
          return CONTAINER;
        if ("response".equals(codeString))
          return RESPONSE;
        if ("change-request".equals(codeString))
          return CHANGEREQUEST;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ArtifactAssessmentInformationType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case COMMENT: return "comment";
            case CLASSIFIER: return "classifier";
            case RATING: return "rating";
            case CONTAINER: return "container";
            case RESPONSE: return "response";
            case CHANGEREQUEST: return "change-request";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case COMMENT: return "http://hl7.org/fhir/artifactassessment-information-type";
            case CLASSIFIER: return "http://hl7.org/fhir/artifactassessment-information-type";
            case RATING: return "http://hl7.org/fhir/artifactassessment-information-type";
            case CONTAINER: return "http://hl7.org/fhir/artifactassessment-information-type";
            case RESPONSE: return "http://hl7.org/fhir/artifactassessment-information-type";
            case CHANGEREQUEST: return "http://hl7.org/fhir/artifactassessment-information-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case COMMENT: return "A comment on the artifact";
            case CLASSIFIER: return "A classifier of the artifact";
            case RATING: return "A rating of the artifact";
            case CONTAINER: return "A container for multiple components";
            case RESPONSE: return "A response to a comment";
            case CHANGEREQUEST: return "A change request for the artifact";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case COMMENT: return "Comment";
            case CLASSIFIER: return "Classifier";
            case RATING: return "Rating";
            case CONTAINER: return "Container";
            case RESPONSE: return "Response";
            case CHANGEREQUEST: return "Change Request";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ArtifactAssessmentInformationTypeEnumFactory implements EnumFactory<ArtifactAssessmentInformationType> {
    public ArtifactAssessmentInformationType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("comment".equals(codeString))
          return ArtifactAssessmentInformationType.COMMENT;
        if ("classifier".equals(codeString))
          return ArtifactAssessmentInformationType.CLASSIFIER;
        if ("rating".equals(codeString))
          return ArtifactAssessmentInformationType.RATING;
        if ("container".equals(codeString))
          return ArtifactAssessmentInformationType.CONTAINER;
        if ("response".equals(codeString))
          return ArtifactAssessmentInformationType.RESPONSE;
        if ("change-request".equals(codeString))
          return ArtifactAssessmentInformationType.CHANGEREQUEST;
        throw new IllegalArgumentException("Unknown ArtifactAssessmentInformationType code '"+codeString+"'");
        }
        public Enumeration<ArtifactAssessmentInformationType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ArtifactAssessmentInformationType>(this, ArtifactAssessmentInformationType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ArtifactAssessmentInformationType>(this, ArtifactAssessmentInformationType.NULL, code);
        if ("comment".equals(codeString))
          return new Enumeration<ArtifactAssessmentInformationType>(this, ArtifactAssessmentInformationType.COMMENT, code);
        if ("classifier".equals(codeString))
          return new Enumeration<ArtifactAssessmentInformationType>(this, ArtifactAssessmentInformationType.CLASSIFIER, code);
        if ("rating".equals(codeString))
          return new Enumeration<ArtifactAssessmentInformationType>(this, ArtifactAssessmentInformationType.RATING, code);
        if ("container".equals(codeString))
          return new Enumeration<ArtifactAssessmentInformationType>(this, ArtifactAssessmentInformationType.CONTAINER, code);
        if ("response".equals(codeString))
          return new Enumeration<ArtifactAssessmentInformationType>(this, ArtifactAssessmentInformationType.RESPONSE, code);
        if ("change-request".equals(codeString))
          return new Enumeration<ArtifactAssessmentInformationType>(this, ArtifactAssessmentInformationType.CHANGEREQUEST, code);
        throw new FHIRException("Unknown ArtifactAssessmentInformationType code '"+codeString+"'");
        }
    public String toCode(ArtifactAssessmentInformationType code) {
      if (code == ArtifactAssessmentInformationType.COMMENT)
        return "comment";
      if (code == ArtifactAssessmentInformationType.CLASSIFIER)
        return "classifier";
      if (code == ArtifactAssessmentInformationType.RATING)
        return "rating";
      if (code == ArtifactAssessmentInformationType.CONTAINER)
        return "container";
      if (code == ArtifactAssessmentInformationType.RESPONSE)
        return "response";
      if (code == ArtifactAssessmentInformationType.CHANGEREQUEST)
        return "change-request";
      return "?";
      }
    public String toSystem(ArtifactAssessmentInformationType code) {
      return code.getSystem();
      }
    }

    public enum ArtifactAssessmentWorkflowStatus {
        /**
         * The comment has been submitted, but the responsible party has not yet been determined, or the responsible party has not yet determined the next steps to be taken.
         */
        SUBMITTED, 
        /**
         * The comment has been triaged, meaning the responsible party has been determined and next steps have been identified to address the comment.
         */
        TRIAGED, 
        /**
         * The comment is waiting for input from a specific party before next steps can be taken.
         */
        WAITINGFORINPUT, 
        /**
         * The comment has been resolved and no changes resulted from the resolution
         */
        RESOLVEDNOCHANGE, 
        /**
         * The comment has been resolved and changes are required to address the comment
         */
        RESOLVEDCHANGEREQUIRED, 
        /**
         * The comment is acceptable, but resolution of the comment and application of any associated changes have been deferred
         */
        DEFERRED, 
        /**
         * The comment is a duplicate of another comment already received
         */
        DUPLICATE, 
        /**
         * The comment is resolved and any necessary changes have been applied
         */
        APPLIED, 
        /**
         * The necessary changes to the artifact have been published in a new version of the artifact
         */
        PUBLISHED, 
        /**
         * The assessment was entered in error
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ArtifactAssessmentWorkflowStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("submitted".equals(codeString))
          return SUBMITTED;
        if ("triaged".equals(codeString))
          return TRIAGED;
        if ("waiting-for-input".equals(codeString))
          return WAITINGFORINPUT;
        if ("resolved-no-change".equals(codeString))
          return RESOLVEDNOCHANGE;
        if ("resolved-change-required".equals(codeString))
          return RESOLVEDCHANGEREQUIRED;
        if ("deferred".equals(codeString))
          return DEFERRED;
        if ("duplicate".equals(codeString))
          return DUPLICATE;
        if ("applied".equals(codeString))
          return APPLIED;
        if ("published".equals(codeString))
          return PUBLISHED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ArtifactAssessmentWorkflowStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SUBMITTED: return "submitted";
            case TRIAGED: return "triaged";
            case WAITINGFORINPUT: return "waiting-for-input";
            case RESOLVEDNOCHANGE: return "resolved-no-change";
            case RESOLVEDCHANGEREQUIRED: return "resolved-change-required";
            case DEFERRED: return "deferred";
            case DUPLICATE: return "duplicate";
            case APPLIED: return "applied";
            case PUBLISHED: return "published";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SUBMITTED: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case TRIAGED: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case WAITINGFORINPUT: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case RESOLVEDNOCHANGE: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case RESOLVEDCHANGEREQUIRED: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case DEFERRED: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case DUPLICATE: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case APPLIED: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case PUBLISHED: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/artifactassessment-workflow-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SUBMITTED: return "The comment has been submitted, but the responsible party has not yet been determined, or the responsible party has not yet determined the next steps to be taken.";
            case TRIAGED: return "The comment has been triaged, meaning the responsible party has been determined and next steps have been identified to address the comment.";
            case WAITINGFORINPUT: return "The comment is waiting for input from a specific party before next steps can be taken.";
            case RESOLVEDNOCHANGE: return "The comment has been resolved and no changes resulted from the resolution";
            case RESOLVEDCHANGEREQUIRED: return "The comment has been resolved and changes are required to address the comment";
            case DEFERRED: return "The comment is acceptable, but resolution of the comment and application of any associated changes have been deferred";
            case DUPLICATE: return "The comment is a duplicate of another comment already received";
            case APPLIED: return "The comment is resolved and any necessary changes have been applied";
            case PUBLISHED: return "The necessary changes to the artifact have been published in a new version of the artifact";
            case ENTEREDINERROR: return "The assessment was entered in error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SUBMITTED: return "Submitted";
            case TRIAGED: return "Triaged";
            case WAITINGFORINPUT: return "Waiting for Input";
            case RESOLVEDNOCHANGE: return "Resolved - No Change";
            case RESOLVEDCHANGEREQUIRED: return "Resolved - Change Required";
            case DEFERRED: return "Deferred";
            case DUPLICATE: return "Duplicate";
            case APPLIED: return "Applied";
            case PUBLISHED: return "Published";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ArtifactAssessmentWorkflowStatusEnumFactory implements EnumFactory<ArtifactAssessmentWorkflowStatus> {
    public ArtifactAssessmentWorkflowStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("submitted".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.SUBMITTED;
        if ("triaged".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.TRIAGED;
        if ("waiting-for-input".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.WAITINGFORINPUT;
        if ("resolved-no-change".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.RESOLVEDNOCHANGE;
        if ("resolved-change-required".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.RESOLVEDCHANGEREQUIRED;
        if ("deferred".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.DEFERRED;
        if ("duplicate".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.DUPLICATE;
        if ("applied".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.APPLIED;
        if ("published".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.PUBLISHED;
        if ("entered-in-error".equals(codeString))
          return ArtifactAssessmentWorkflowStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown ArtifactAssessmentWorkflowStatus code '"+codeString+"'");
        }
        public Enumeration<ArtifactAssessmentWorkflowStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.NULL, code);
        if ("submitted".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.SUBMITTED, code);
        if ("triaged".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.TRIAGED, code);
        if ("waiting-for-input".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.WAITINGFORINPUT, code);
        if ("resolved-no-change".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.RESOLVEDNOCHANGE, code);
        if ("resolved-change-required".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.RESOLVEDCHANGEREQUIRED, code);
        if ("deferred".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.DEFERRED, code);
        if ("duplicate".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.DUPLICATE, code);
        if ("applied".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.APPLIED, code);
        if ("published".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.PUBLISHED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ArtifactAssessmentWorkflowStatus>(this, ArtifactAssessmentWorkflowStatus.ENTEREDINERROR, code);
        throw new FHIRException("Unknown ArtifactAssessmentWorkflowStatus code '"+codeString+"'");
        }
    public String toCode(ArtifactAssessmentWorkflowStatus code) {
      if (code == ArtifactAssessmentWorkflowStatus.SUBMITTED)
        return "submitted";
      if (code == ArtifactAssessmentWorkflowStatus.TRIAGED)
        return "triaged";
      if (code == ArtifactAssessmentWorkflowStatus.WAITINGFORINPUT)
        return "waiting-for-input";
      if (code == ArtifactAssessmentWorkflowStatus.RESOLVEDNOCHANGE)
        return "resolved-no-change";
      if (code == ArtifactAssessmentWorkflowStatus.RESOLVEDCHANGEREQUIRED)
        return "resolved-change-required";
      if (code == ArtifactAssessmentWorkflowStatus.DEFERRED)
        return "deferred";
      if (code == ArtifactAssessmentWorkflowStatus.DUPLICATE)
        return "duplicate";
      if (code == ArtifactAssessmentWorkflowStatus.APPLIED)
        return "applied";
      if (code == ArtifactAssessmentWorkflowStatus.PUBLISHED)
        return "published";
      if (code == ArtifactAssessmentWorkflowStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(ArtifactAssessmentWorkflowStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ArtifactAssessmentContentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of information this component of the content represents.
         */
        @Child(name = "informationType", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="comment | classifier | rating | container | response | change-request", formalDefinition="The type of information this component of the content represents." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/artifactassessment-information-type")
        protected Enumeration<ArtifactAssessmentInformationType> informationType;

        /**
         * A brief summary of the content of this component.
         */
        @Child(name = "summary", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Brief summary of the content", formalDefinition="A brief summary of the content of this component." )
        protected MarkdownType summary;

        /**
         * Indicates what type of content this component represents.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What type of content", formalDefinition="Indicates what type of content this component represents." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/certainty-type")
        protected CodeableConcept type;

        /**
         * Represents a rating, classifier, or assessment of the artifact.
         */
        @Child(name = "classifier", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Rating, classifier, or assessment", formalDefinition="Represents a rating, classifier, or assessment of the artifact." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/certainty-rating")
        protected List<CodeableConcept> classifier;

        /**
         * A quantitative rating of the artifact.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Quantitative rating", formalDefinition="A quantitative rating of the artifact." )
        protected Quantity quantity;

        /**
         * Indicates who or what authored the content.
         */
        @Child(name = "author", type = {Patient.class, Practitioner.class, PractitionerRole.class, Organization.class, Device.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who authored the content", formalDefinition="Indicates who or what authored the content." )
        protected Reference author;

        /**
         * A URI that points to what the comment is about, such as a line of text in the CQL, or a specific element in a resource.
         */
        @Child(name = "path", type = {UriType.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What the comment is directed to", formalDefinition="A URI that points to what the comment is about, such as a line of text in the CQL, or a specific element in a resource." )
        protected List<UriType> path;

        /**
         * Additional related artifacts that provide supporting documentation, additional evidence, or further information related to the content.
         */
        @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Additional information", formalDefinition="Additional related artifacts that provide supporting documentation, additional evidence, or further information related to the content." )
        protected List<RelatedArtifact> relatedArtifact;

        /**
         * Acceptable to publicly share the comment, classifier or rating.
         */
        @Child(name = "freeToShare", type = {BooleanType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Acceptable to publicly share the resource content", formalDefinition="Acceptable to publicly share the comment, classifier or rating." )
        protected BooleanType freeToShare;

        /**
         * If the informationType is container, the components of the content.
         */
        @Child(name = "component", type = {ArtifactAssessmentContentComponent.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Contained content", formalDefinition="If the informationType is container, the components of the content." )
        protected List<ArtifactAssessmentContentComponent> component;

        private static final long serialVersionUID = -111630435L;

    /**
     * Constructor
     */
      public ArtifactAssessmentContentComponent() {
        super();
      }

        /**
         * @return {@link #informationType} (The type of information this component of the content represents.). This is the underlying object with id, value and extensions. The accessor "getInformationType" gives direct access to the value
         */
        public Enumeration<ArtifactAssessmentInformationType> getInformationTypeElement() { 
          if (this.informationType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ArtifactAssessmentContentComponent.informationType");
            else if (Configuration.doAutoCreate())
              this.informationType = new Enumeration<ArtifactAssessmentInformationType>(new ArtifactAssessmentInformationTypeEnumFactory()); // bb
          return this.informationType;
        }

        public boolean hasInformationTypeElement() { 
          return this.informationType != null && !this.informationType.isEmpty();
        }

        public boolean hasInformationType() { 
          return this.informationType != null && !this.informationType.isEmpty();
        }

        /**
         * @param value {@link #informationType} (The type of information this component of the content represents.). This is the underlying object with id, value and extensions. The accessor "getInformationType" gives direct access to the value
         */
        public ArtifactAssessmentContentComponent setInformationTypeElement(Enumeration<ArtifactAssessmentInformationType> value) { 
          this.informationType = value;
          return this;
        }

        /**
         * @return The type of information this component of the content represents.
         */
        public ArtifactAssessmentInformationType getInformationType() { 
          return this.informationType == null ? null : this.informationType.getValue();
        }

        /**
         * @param value The type of information this component of the content represents.
         */
        public ArtifactAssessmentContentComponent setInformationType(ArtifactAssessmentInformationType value) { 
          if (value == null)
            this.informationType = null;
          else {
            if (this.informationType == null)
              this.informationType = new Enumeration<ArtifactAssessmentInformationType>(new ArtifactAssessmentInformationTypeEnumFactory());
            this.informationType.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #summary} (A brief summary of the content of this component.). This is the underlying object with id, value and extensions. The accessor "getSummary" gives direct access to the value
         */
        public MarkdownType getSummaryElement() { 
          if (this.summary == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ArtifactAssessmentContentComponent.summary");
            else if (Configuration.doAutoCreate())
              this.summary = new MarkdownType(); // bb
          return this.summary;
        }

        public boolean hasSummaryElement() { 
          return this.summary != null && !this.summary.isEmpty();
        }

        public boolean hasSummary() { 
          return this.summary != null && !this.summary.isEmpty();
        }

        /**
         * @param value {@link #summary} (A brief summary of the content of this component.). This is the underlying object with id, value and extensions. The accessor "getSummary" gives direct access to the value
         */
        public ArtifactAssessmentContentComponent setSummaryElement(MarkdownType value) { 
          this.summary = value;
          return this;
        }

        /**
         * @return A brief summary of the content of this component.
         */
        public String getSummary() { 
          return this.summary == null ? null : this.summary.getValue();
        }

        /**
         * @param value A brief summary of the content of this component.
         */
        public ArtifactAssessmentContentComponent setSummary(String value) { 
          if (Utilities.noString(value))
            this.summary = null;
          else {
            if (this.summary == null)
              this.summary = new MarkdownType();
            this.summary.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #type} (Indicates what type of content this component represents.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ArtifactAssessmentContentComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Indicates what type of content this component represents.)
         */
        public ArtifactAssessmentContentComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #classifier} (Represents a rating, classifier, or assessment of the artifact.)
         */
        public List<CodeableConcept> getClassifier() { 
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          return this.classifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ArtifactAssessmentContentComponent setClassifier(List<CodeableConcept> theClassifier) { 
          this.classifier = theClassifier;
          return this;
        }

        public boolean hasClassifier() { 
          if (this.classifier == null)
            return false;
          for (CodeableConcept item : this.classifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addClassifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return t;
        }

        public ArtifactAssessmentContentComponent addClassifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #classifier}, creating it if it does not already exist {3}
         */
        public CodeableConcept getClassifierFirstRep() { 
          if (getClassifier().isEmpty()) {
            addClassifier();
          }
          return getClassifier().get(0);
        }

        /**
         * @return {@link #quantity} (A quantitative rating of the artifact.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ArtifactAssessmentContentComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (A quantitative rating of the artifact.)
         */
        public ArtifactAssessmentContentComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #author} (Indicates who or what authored the content.)
         */
        public Reference getAuthor() { 
          if (this.author == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ArtifactAssessmentContentComponent.author");
            else if (Configuration.doAutoCreate())
              this.author = new Reference(); // cc
          return this.author;
        }

        public boolean hasAuthor() { 
          return this.author != null && !this.author.isEmpty();
        }

        /**
         * @param value {@link #author} (Indicates who or what authored the content.)
         */
        public ArtifactAssessmentContentComponent setAuthor(Reference value) { 
          this.author = value;
          return this;
        }

        /**
         * @return {@link #path} (A URI that points to what the comment is about, such as a line of text in the CQL, or a specific element in a resource.)
         */
        public List<UriType> getPath() { 
          if (this.path == null)
            this.path = new ArrayList<UriType>();
          return this.path;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ArtifactAssessmentContentComponent setPath(List<UriType> thePath) { 
          this.path = thePath;
          return this;
        }

        public boolean hasPath() { 
          if (this.path == null)
            return false;
          for (UriType item : this.path)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #path} (A URI that points to what the comment is about, such as a line of text in the CQL, or a specific element in a resource.)
         */
        public UriType addPathElement() {//2 
          UriType t = new UriType();
          if (this.path == null)
            this.path = new ArrayList<UriType>();
          this.path.add(t);
          return t;
        }

        /**
         * @param value {@link #path} (A URI that points to what the comment is about, such as a line of text in the CQL, or a specific element in a resource.)
         */
        public ArtifactAssessmentContentComponent addPath(String value) { //1
          UriType t = new UriType();
          t.setValue(value);
          if (this.path == null)
            this.path = new ArrayList<UriType>();
          this.path.add(t);
          return this;
        }

        /**
         * @param value {@link #path} (A URI that points to what the comment is about, such as a line of text in the CQL, or a specific element in a resource.)
         */
        public boolean hasPath(String value) { 
          if (this.path == null)
            return false;
          for (UriType v : this.path)
            if (v.getValue().equals(value)) // uri
              return true;
          return false;
        }

        /**
         * @return {@link #relatedArtifact} (Additional related artifacts that provide supporting documentation, additional evidence, or further information related to the content.)
         */
        public List<RelatedArtifact> getRelatedArtifact() { 
          if (this.relatedArtifact == null)
            this.relatedArtifact = new ArrayList<RelatedArtifact>();
          return this.relatedArtifact;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ArtifactAssessmentContentComponent setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
          this.relatedArtifact = theRelatedArtifact;
          return this;
        }

        public boolean hasRelatedArtifact() { 
          if (this.relatedArtifact == null)
            return false;
          for (RelatedArtifact item : this.relatedArtifact)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RelatedArtifact addRelatedArtifact() { //3
          RelatedArtifact t = new RelatedArtifact();
          if (this.relatedArtifact == null)
            this.relatedArtifact = new ArrayList<RelatedArtifact>();
          this.relatedArtifact.add(t);
          return t;
        }

        public ArtifactAssessmentContentComponent addRelatedArtifact(RelatedArtifact t) { //3
          if (t == null)
            return this;
          if (this.relatedArtifact == null)
            this.relatedArtifact = new ArrayList<RelatedArtifact>();
          this.relatedArtifact.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
         */
        public RelatedArtifact getRelatedArtifactFirstRep() { 
          if (getRelatedArtifact().isEmpty()) {
            addRelatedArtifact();
          }
          return getRelatedArtifact().get(0);
        }

        /**
         * @return {@link #freeToShare} (Acceptable to publicly share the comment, classifier or rating.). This is the underlying object with id, value and extensions. The accessor "getFreeToShare" gives direct access to the value
         */
        public BooleanType getFreeToShareElement() { 
          if (this.freeToShare == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ArtifactAssessmentContentComponent.freeToShare");
            else if (Configuration.doAutoCreate())
              this.freeToShare = new BooleanType(); // bb
          return this.freeToShare;
        }

        public boolean hasFreeToShareElement() { 
          return this.freeToShare != null && !this.freeToShare.isEmpty();
        }

        public boolean hasFreeToShare() { 
          return this.freeToShare != null && !this.freeToShare.isEmpty();
        }

        /**
         * @param value {@link #freeToShare} (Acceptable to publicly share the comment, classifier or rating.). This is the underlying object with id, value and extensions. The accessor "getFreeToShare" gives direct access to the value
         */
        public ArtifactAssessmentContentComponent setFreeToShareElement(BooleanType value) { 
          this.freeToShare = value;
          return this;
        }

        /**
         * @return Acceptable to publicly share the comment, classifier or rating.
         */
        public boolean getFreeToShare() { 
          return this.freeToShare == null || this.freeToShare.isEmpty() ? false : this.freeToShare.getValue();
        }

        /**
         * @param value Acceptable to publicly share the comment, classifier or rating.
         */
        public ArtifactAssessmentContentComponent setFreeToShare(boolean value) { 
            if (this.freeToShare == null)
              this.freeToShare = new BooleanType();
            this.freeToShare.setValue(value);
          return this;
        }

        /**
         * @return {@link #component} (If the informationType is container, the components of the content.)
         */
        public List<ArtifactAssessmentContentComponent> getComponent() { 
          if (this.component == null)
            this.component = new ArrayList<ArtifactAssessmentContentComponent>();
          return this.component;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ArtifactAssessmentContentComponent setComponent(List<ArtifactAssessmentContentComponent> theComponent) { 
          this.component = theComponent;
          return this;
        }

        public boolean hasComponent() { 
          if (this.component == null)
            return false;
          for (ArtifactAssessmentContentComponent item : this.component)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ArtifactAssessmentContentComponent addComponent() { //3
          ArtifactAssessmentContentComponent t = new ArtifactAssessmentContentComponent();
          if (this.component == null)
            this.component = new ArrayList<ArtifactAssessmentContentComponent>();
          this.component.add(t);
          return t;
        }

        public ArtifactAssessmentContentComponent addComponent(ArtifactAssessmentContentComponent t) { //3
          if (t == null)
            return this;
          if (this.component == null)
            this.component = new ArrayList<ArtifactAssessmentContentComponent>();
          this.component.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #component}, creating it if it does not already exist {3}
         */
        public ArtifactAssessmentContentComponent getComponentFirstRep() { 
          if (getComponent().isEmpty()) {
            addComponent();
          }
          return getComponent().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("informationType", "code", "The type of information this component of the content represents.", 0, 1, informationType));
          children.add(new Property("summary", "markdown", "A brief summary of the content of this component.", 0, 1, summary));
          children.add(new Property("type", "CodeableConcept", "Indicates what type of content this component represents.", 0, 1, type));
          children.add(new Property("classifier", "CodeableConcept", "Represents a rating, classifier, or assessment of the artifact.", 0, java.lang.Integer.MAX_VALUE, classifier));
          children.add(new Property("quantity", "Quantity", "A quantitative rating of the artifact.", 0, 1, quantity));
          children.add(new Property("author", "Reference(Patient|Practitioner|PractitionerRole|Organization|Device)", "Indicates who or what authored the content.", 0, 1, author));
          children.add(new Property("path", "uri", "A URI that points to what the comment is about, such as a line of text in the CQL, or a specific element in a resource.", 0, java.lang.Integer.MAX_VALUE, path));
          children.add(new Property("relatedArtifact", "RelatedArtifact", "Additional related artifacts that provide supporting documentation, additional evidence, or further information related to the content.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
          children.add(new Property("freeToShare", "boolean", "Acceptable to publicly share the comment, classifier or rating.", 0, 1, freeToShare));
          children.add(new Property("component", "@ArtifactAssessment.content", "If the informationType is container, the components of the content.", 0, java.lang.Integer.MAX_VALUE, component));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1302856326: /*informationType*/  return new Property("informationType", "code", "The type of information this component of the content represents.", 0, 1, informationType);
          case -1857640538: /*summary*/  return new Property("summary", "markdown", "A brief summary of the content of this component.", 0, 1, summary);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Indicates what type of content this component represents.", 0, 1, type);
          case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "Represents a rating, classifier, or assessment of the artifact.", 0, java.lang.Integer.MAX_VALUE, classifier);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "A quantitative rating of the artifact.", 0, 1, quantity);
          case -1406328437: /*author*/  return new Property("author", "Reference(Patient|Practitioner|PractitionerRole|Organization|Device)", "Indicates who or what authored the content.", 0, 1, author);
          case 3433509: /*path*/  return new Property("path", "uri", "A URI that points to what the comment is about, such as a line of text in the CQL, or a specific element in a resource.", 0, java.lang.Integer.MAX_VALUE, path);
          case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Additional related artifacts that provide supporting documentation, additional evidence, or further information related to the content.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
          case -1268656616: /*freeToShare*/  return new Property("freeToShare", "boolean", "Acceptable to publicly share the comment, classifier or rating.", 0, 1, freeToShare);
          case -1399907075: /*component*/  return new Property("component", "@ArtifactAssessment.content", "If the informationType is container, the components of the content.", 0, java.lang.Integer.MAX_VALUE, component);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1302856326: /*informationType*/ return this.informationType == null ? new Base[0] : new Base[] {this.informationType}; // Enumeration<ArtifactAssessmentInformationType>
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : new Base[] {this.summary}; // MarkdownType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : new Base[] {this.author}; // Reference
        case 3433509: /*path*/ return this.path == null ? new Base[0] : this.path.toArray(new Base[this.path.size()]); // UriType
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case -1268656616: /*freeToShare*/ return this.freeToShare == null ? new Base[0] : new Base[] {this.freeToShare}; // BooleanType
        case -1399907075: /*component*/ return this.component == null ? new Base[0] : this.component.toArray(new Base[this.component.size()]); // ArtifactAssessmentContentComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1302856326: // informationType
          value = new ArtifactAssessmentInformationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.informationType = (Enumeration) value; // Enumeration<ArtifactAssessmentInformationType>
          return value;
        case -1857640538: // summary
          this.summary = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -281470431: // classifier
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1406328437: // author
          this.author = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3433509: // path
          this.getPath().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case -1268656616: // freeToShare
          this.freeToShare = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1399907075: // component
          this.getComponent().add((ArtifactAssessmentContentComponent) value); // ArtifactAssessmentContentComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("informationType")) {
          value = new ArtifactAssessmentInformationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.informationType = (Enumeration) value; // Enumeration<ArtifactAssessmentInformationType>
        } else if (name.equals("summary")) {
          this.summary = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("author")) {
          this.author = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("path")) {
          this.getPath().add(TypeConvertor.castToUri(value));
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("freeToShare")) {
          this.freeToShare = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("component")) {
          this.getComponent().add((ArtifactAssessmentContentComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("informationType")) {
          value = new ArtifactAssessmentInformationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.informationType = (Enumeration) value; // Enumeration<ArtifactAssessmentInformationType>
        } else if (name.equals("summary")) {
          this.summary = null;
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("classifier")) {
          this.getClassifier().remove(value);
        } else if (name.equals("quantity")) {
          this.quantity = null;
        } else if (name.equals("author")) {
          this.author = null;
        } else if (name.equals("path")) {
          this.getPath().remove(value);
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().remove(value);
        } else if (name.equals("freeToShare")) {
          this.freeToShare = null;
        } else if (name.equals("component")) {
          this.getComponent().add((ArtifactAssessmentContentComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1302856326:  return getInformationTypeElement();
        case -1857640538:  return getSummaryElement();
        case 3575610:  return getType();
        case -281470431:  return addClassifier(); 
        case -1285004149:  return getQuantity();
        case -1406328437:  return getAuthor();
        case 3433509:  return addPathElement();
        case 666807069:  return addRelatedArtifact(); 
        case -1268656616:  return getFreeToShareElement();
        case -1399907075:  return addComponent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1302856326: /*informationType*/ return new String[] {"code"};
        case -1857640538: /*summary*/ return new String[] {"markdown"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        case 3433509: /*path*/ return new String[] {"uri"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case -1268656616: /*freeToShare*/ return new String[] {"boolean"};
        case -1399907075: /*component*/ return new String[] {"@ArtifactAssessment.content"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("informationType")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.content.informationType");
        }
        else if (name.equals("summary")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.content.summary");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("classifier")) {
          return addClassifier();
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("author")) {
          this.author = new Reference();
          return this.author;
        }
        else if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.content.path");
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("freeToShare")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.content.freeToShare");
        }
        else if (name.equals("component")) {
          return addComponent();
        }
        else
          return super.addChild(name);
      }

      public ArtifactAssessmentContentComponent copy() {
        ArtifactAssessmentContentComponent dst = new ArtifactAssessmentContentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ArtifactAssessmentContentComponent dst) {
        super.copyValues(dst);
        dst.informationType = informationType == null ? null : informationType.copy();
        dst.summary = summary == null ? null : summary.copy();
        dst.type = type == null ? null : type.copy();
        if (classifier != null) {
          dst.classifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classifier)
            dst.classifier.add(i.copy());
        };
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.author = author == null ? null : author.copy();
        if (path != null) {
          dst.path = new ArrayList<UriType>();
          for (UriType i : path)
            dst.path.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        dst.freeToShare = freeToShare == null ? null : freeToShare.copy();
        if (component != null) {
          dst.component = new ArrayList<ArtifactAssessmentContentComponent>();
          for (ArtifactAssessmentContentComponent i : component)
            dst.component.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ArtifactAssessmentContentComponent))
          return false;
        ArtifactAssessmentContentComponent o = (ArtifactAssessmentContentComponent) other_;
        return compareDeep(informationType, o.informationType, true) && compareDeep(summary, o.summary, true)
           && compareDeep(type, o.type, true) && compareDeep(classifier, o.classifier, true) && compareDeep(quantity, o.quantity, true)
           && compareDeep(author, o.author, true) && compareDeep(path, o.path, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
           && compareDeep(freeToShare, o.freeToShare, true) && compareDeep(component, o.component, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ArtifactAssessmentContentComponent))
          return false;
        ArtifactAssessmentContentComponent o = (ArtifactAssessmentContentComponent) other_;
        return compareValues(informationType, o.informationType, true) && compareValues(summary, o.summary, true)
           && compareValues(path, o.path, true) && compareValues(freeToShare, o.freeToShare, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(informationType, summary, type
          , classifier, quantity, author, path, relatedArtifact, freeToShare, component
          );
      }

  public String fhirType() {
    return "ArtifactAssessment.content";

  }

  }

    /**
     * A formal identifier that is used to identify this artifact assessment when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the artifact assessment", formalDefinition="A formal identifier that is used to identify this artifact assessment when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * A short title for the assessment for use in displaying and selecting.
     */
    @Child(name = "title", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A short title for the assessment for use in displaying and selecting", formalDefinition="A short title for the assessment for use in displaying and selecting." )
    protected StringType title;

    /**
     * Display of or reference to the bibliographic citation of the comment, classifier, or rating.
     */
    @Child(name = "citeAs", type = {Citation.class, MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="How to cite the comment or rating", formalDefinition="Display of or reference to the bibliographic citation of the comment, classifier, or rating." )
    protected DataType citeAs;

    /**
     * The date  (and optionally time) when the artifact assessment was published. The date must change when the disposition changes and it must change if the workflow status code changes. In addition, it should change when the substantive content of the artifact assessment changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the artifact assessment was published. The date must change when the disposition changes and it must change if the workflow status code changes. In addition, it should change when the substantive content of the artifact assessment changes." )
    protected DateTimeType date;

    /**
     * A copyright statement relating to the artifact assessment and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the artifact assessment.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the artifact assessment and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the artifact assessment." )
    protected MarkdownType copyright;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the artifact assessment was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the artifact assessment was last reviewed by the publisher", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.
     */
    @Child(name = "artifact", type = {Reference.class, CanonicalType.class, UriType.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The artifact assessed, commented upon or rated", formalDefinition="A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about." )
    protected DataType artifact;

    /**
     * A component comment, classifier, or rating of the artifact.
     */
    @Child(name = "content", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comment, classifier, or rating content", formalDefinition="A component comment, classifier, or rating of the artifact." )
    protected List<ArtifactAssessmentContentComponent> content;

    /**
     * Indicates the workflow status of the comment or change request.
     */
    @Child(name = "workflowStatus", type = {CodeType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="submitted | triaged | waiting-for-input | resolved-no-change | resolved-change-required | deferred | duplicate | applied | published | entered-in-error", formalDefinition="Indicates the workflow status of the comment or change request." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/artifactassessment-workflow-status")
    protected Enumeration<ArtifactAssessmentWorkflowStatus> workflowStatus;

    /**
     * Indicates the disposition of the responsible party to the comment or change request.
     */
    @Child(name = "disposition", type = {CodeType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="unresolved | not-persuasive | persuasive | persuasive-with-modification | not-persuasive-with-modification", formalDefinition="Indicates the disposition of the responsible party to the comment or change request." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/artifactassessment-disposition")
    protected Enumeration<ArtifactAssessmentDisposition> disposition;

    private static final long serialVersionUID = 525457507L;

  /**
   * Constructor
   */
    public ArtifactAssessment() {
      super();
    }

  /**
   * Constructor
   */
    public ArtifactAssessment(DataType artifact) {
      super();
      this.setArtifact(artifact);
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this artifact assessment when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ArtifactAssessment setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public ArtifactAssessment addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #title} (A short title for the assessment for use in displaying and selecting.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ArtifactAssessment.title");
        else if (Configuration.doAutoCreate())
          this.title = new StringType(); // bb
      return this.title;
    }

    public boolean hasTitleElement() { 
      return this.title != null && !this.title.isEmpty();
    }

    public boolean hasTitle() { 
      return this.title != null && !this.title.isEmpty();
    }

    /**
     * @param value {@link #title} (A short title for the assessment for use in displaying and selecting.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public ArtifactAssessment setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short title for the assessment for use in displaying and selecting.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short title for the assessment for use in displaying and selecting.
     */
    public ArtifactAssessment setTitle(String value) { 
      if (Utilities.noString(value))
        this.title = null;
      else {
        if (this.title == null)
          this.title = new StringType();
        this.title.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #citeAs} (Display of or reference to the bibliographic citation of the comment, classifier, or rating.)
     */
    public DataType getCiteAs() { 
      return this.citeAs;
    }

    /**
     * @return {@link #citeAs} (Display of or reference to the bibliographic citation of the comment, classifier, or rating.)
     */
    public Reference getCiteAsReference() throws FHIRException { 
      if (this.citeAs == null)
        this.citeAs = new Reference();
      if (!(this.citeAs instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.citeAs.getClass().getName()+" was encountered");
      return (Reference) this.citeAs;
    }

    public boolean hasCiteAsReference() { 
      return this != null && this.citeAs instanceof Reference;
    }

    /**
     * @return {@link #citeAs} (Display of or reference to the bibliographic citation of the comment, classifier, or rating.)
     */
    public MarkdownType getCiteAsMarkdownType() throws FHIRException { 
      if (this.citeAs == null)
        this.citeAs = new MarkdownType();
      if (!(this.citeAs instanceof MarkdownType))
        throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.citeAs.getClass().getName()+" was encountered");
      return (MarkdownType) this.citeAs;
    }

    public boolean hasCiteAsMarkdownType() { 
      return this != null && this.citeAs instanceof MarkdownType;
    }

    public boolean hasCiteAs() { 
      return this.citeAs != null && !this.citeAs.isEmpty();
    }

    /**
     * @param value {@link #citeAs} (Display of or reference to the bibliographic citation of the comment, classifier, or rating.)
     */
    public ArtifactAssessment setCiteAs(DataType value) { 
      if (value != null && !(value instanceof Reference || value instanceof MarkdownType))
        throw new FHIRException("Not the right type for ArtifactAssessment.citeAs[x]: "+value.fhirType());
      this.citeAs = value;
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the artifact assessment was published. The date must change when the disposition changes and it must change if the workflow status code changes. In addition, it should change when the substantive content of the artifact assessment changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ArtifactAssessment.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateTimeType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (The date  (and optionally time) when the artifact assessment was published. The date must change when the disposition changes and it must change if the workflow status code changes. In addition, it should change when the substantive content of the artifact assessment changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ArtifactAssessment setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the artifact assessment was published. The date must change when the disposition changes and it must change if the workflow status code changes. In addition, it should change when the substantive content of the artifact assessment changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the artifact assessment was published. The date must change when the disposition changes and it must change if the workflow status code changes. In addition, it should change when the substantive content of the artifact assessment changes.
     */
    public ArtifactAssessment setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (A copyright statement relating to the artifact assessment and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the artifact assessment.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ArtifactAssessment.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new MarkdownType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the artifact assessment and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the artifact assessment.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public ArtifactAssessment setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the artifact assessment and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the artifact assessment.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the artifact assessment and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the artifact assessment.
     */
    public ArtifactAssessment setCopyright(String value) { 
      if (Utilities.noString(value))
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ArtifactAssessment.approvalDate");
        else if (Configuration.doAutoCreate())
          this.approvalDate = new DateType(); // bb
      return this.approvalDate;
    }

    public boolean hasApprovalDateElement() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    public boolean hasApprovalDate() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public ArtifactAssessment setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public ArtifactAssessment setApprovalDate(Date value) { 
      if (value == null)
        this.approvalDate = null;
      else {
        if (this.approvalDate == null)
          this.approvalDate = new DateType();
        this.approvalDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ArtifactAssessment.lastReviewDate");
        else if (Configuration.doAutoCreate())
          this.lastReviewDate = new DateType(); // bb
      return this.lastReviewDate;
    }

    public boolean hasLastReviewDateElement() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    public boolean hasLastReviewDate() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public ArtifactAssessment setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public ArtifactAssessment setLastReviewDate(Date value) { 
      if (value == null)
        this.lastReviewDate = null;
      else {
        if (this.lastReviewDate == null)
          this.lastReviewDate = new DateType();
        this.lastReviewDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #artifact} (A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.)
     */
    public DataType getArtifact() { 
      return this.artifact;
    }

    /**
     * @return {@link #artifact} (A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.)
     */
    public Reference getArtifactReference() throws FHIRException { 
      if (this.artifact == null)
        this.artifact = new Reference();
      if (!(this.artifact instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.artifact.getClass().getName()+" was encountered");
      return (Reference) this.artifact;
    }

    public boolean hasArtifactReference() { 
      return this != null && this.artifact instanceof Reference;
    }

    /**
     * @return {@link #artifact} (A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.)
     */
    public CanonicalType getArtifactCanonicalType() throws FHIRException { 
      if (this.artifact == null)
        this.artifact = new CanonicalType();
      if (!(this.artifact instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.artifact.getClass().getName()+" was encountered");
      return (CanonicalType) this.artifact;
    }

    public boolean hasArtifactCanonicalType() { 
      return this != null && this.artifact instanceof CanonicalType;
    }

    /**
     * @return {@link #artifact} (A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.)
     */
    public UriType getArtifactUriType() throws FHIRException { 
      if (this.artifact == null)
        this.artifact = new UriType();
      if (!(this.artifact instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.artifact.getClass().getName()+" was encountered");
      return (UriType) this.artifact;
    }

    public boolean hasArtifactUriType() { 
      return this != null && this.artifact instanceof UriType;
    }

    public boolean hasArtifact() { 
      return this.artifact != null && !this.artifact.isEmpty();
    }

    /**
     * @param value {@link #artifact} (A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.)
     */
    public ArtifactAssessment setArtifact(DataType value) { 
      if (value != null && !(value instanceof Reference || value instanceof CanonicalType || value instanceof UriType))
        throw new FHIRException("Not the right type for ArtifactAssessment.artifact[x]: "+value.fhirType());
      this.artifact = value;
      return this;
    }

    /**
     * @return {@link #content} (A component comment, classifier, or rating of the artifact.)
     */
    public List<ArtifactAssessmentContentComponent> getContent() { 
      if (this.content == null)
        this.content = new ArrayList<ArtifactAssessmentContentComponent>();
      return this.content;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ArtifactAssessment setContent(List<ArtifactAssessmentContentComponent> theContent) { 
      this.content = theContent;
      return this;
    }

    public boolean hasContent() { 
      if (this.content == null)
        return false;
      for (ArtifactAssessmentContentComponent item : this.content)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ArtifactAssessmentContentComponent addContent() { //3
      ArtifactAssessmentContentComponent t = new ArtifactAssessmentContentComponent();
      if (this.content == null)
        this.content = new ArrayList<ArtifactAssessmentContentComponent>();
      this.content.add(t);
      return t;
    }

    public ArtifactAssessment addContent(ArtifactAssessmentContentComponent t) { //3
      if (t == null)
        return this;
      if (this.content == null)
        this.content = new ArrayList<ArtifactAssessmentContentComponent>();
      this.content.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #content}, creating it if it does not already exist {3}
     */
    public ArtifactAssessmentContentComponent getContentFirstRep() { 
      if (getContent().isEmpty()) {
        addContent();
      }
      return getContent().get(0);
    }

    /**
     * @return {@link #workflowStatus} (Indicates the workflow status of the comment or change request.). This is the underlying object with id, value and extensions. The accessor "getWorkflowStatus" gives direct access to the value
     */
    public Enumeration<ArtifactAssessmentWorkflowStatus> getWorkflowStatusElement() { 
      if (this.workflowStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ArtifactAssessment.workflowStatus");
        else if (Configuration.doAutoCreate())
          this.workflowStatus = new Enumeration<ArtifactAssessmentWorkflowStatus>(new ArtifactAssessmentWorkflowStatusEnumFactory()); // bb
      return this.workflowStatus;
    }

    public boolean hasWorkflowStatusElement() { 
      return this.workflowStatus != null && !this.workflowStatus.isEmpty();
    }

    public boolean hasWorkflowStatus() { 
      return this.workflowStatus != null && !this.workflowStatus.isEmpty();
    }

    /**
     * @param value {@link #workflowStatus} (Indicates the workflow status of the comment or change request.). This is the underlying object with id, value and extensions. The accessor "getWorkflowStatus" gives direct access to the value
     */
    public ArtifactAssessment setWorkflowStatusElement(Enumeration<ArtifactAssessmentWorkflowStatus> value) { 
      this.workflowStatus = value;
      return this;
    }

    /**
     * @return Indicates the workflow status of the comment or change request.
     */
    public ArtifactAssessmentWorkflowStatus getWorkflowStatus() { 
      return this.workflowStatus == null ? null : this.workflowStatus.getValue();
    }

    /**
     * @param value Indicates the workflow status of the comment or change request.
     */
    public ArtifactAssessment setWorkflowStatus(ArtifactAssessmentWorkflowStatus value) { 
      if (value == null)
        this.workflowStatus = null;
      else {
        if (this.workflowStatus == null)
          this.workflowStatus = new Enumeration<ArtifactAssessmentWorkflowStatus>(new ArtifactAssessmentWorkflowStatusEnumFactory());
        this.workflowStatus.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #disposition} (Indicates the disposition of the responsible party to the comment or change request.). This is the underlying object with id, value and extensions. The accessor "getDisposition" gives direct access to the value
     */
    public Enumeration<ArtifactAssessmentDisposition> getDispositionElement() { 
      if (this.disposition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ArtifactAssessment.disposition");
        else if (Configuration.doAutoCreate())
          this.disposition = new Enumeration<ArtifactAssessmentDisposition>(new ArtifactAssessmentDispositionEnumFactory()); // bb
      return this.disposition;
    }

    public boolean hasDispositionElement() { 
      return this.disposition != null && !this.disposition.isEmpty();
    }

    public boolean hasDisposition() { 
      return this.disposition != null && !this.disposition.isEmpty();
    }

    /**
     * @param value {@link #disposition} (Indicates the disposition of the responsible party to the comment or change request.). This is the underlying object with id, value and extensions. The accessor "getDisposition" gives direct access to the value
     */
    public ArtifactAssessment setDispositionElement(Enumeration<ArtifactAssessmentDisposition> value) { 
      this.disposition = value;
      return this;
    }

    /**
     * @return Indicates the disposition of the responsible party to the comment or change request.
     */
    public ArtifactAssessmentDisposition getDisposition() { 
      return this.disposition == null ? null : this.disposition.getValue();
    }

    /**
     * @param value Indicates the disposition of the responsible party to the comment or change request.
     */
    public ArtifactAssessment setDisposition(ArtifactAssessmentDisposition value) { 
      if (value == null)
        this.disposition = null;
      else {
        if (this.disposition == null)
          this.disposition = new Enumeration<ArtifactAssessmentDisposition>(new ArtifactAssessmentDispositionEnumFactory());
        this.disposition.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this artifact assessment when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("title", "string", "A short title for the assessment for use in displaying and selecting.", 0, 1, title));
        children.add(new Property("citeAs[x]", "Reference(Citation)|markdown", "Display of or reference to the bibliographic citation of the comment, classifier, or rating.", 0, 1, citeAs));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the artifact assessment was published. The date must change when the disposition changes and it must change if the workflow status code changes. In addition, it should change when the substantive content of the artifact assessment changes.", 0, 1, date));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the artifact assessment and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the artifact assessment.", 0, 1, copyright));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("artifact[x]", "Reference(Any)|canonical|uri", "A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.", 0, 1, artifact));
        children.add(new Property("content", "", "A component comment, classifier, or rating of the artifact.", 0, java.lang.Integer.MAX_VALUE, content));
        children.add(new Property("workflowStatus", "code", "Indicates the workflow status of the comment or change request.", 0, 1, workflowStatus));
        children.add(new Property("disposition", "code", "Indicates the disposition of the responsible party to the comment or change request.", 0, 1, disposition));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this artifact assessment when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 110371416: /*title*/  return new Property("title", "string", "A short title for the assessment for use in displaying and selecting.", 0, 1, title);
        case -1706539017: /*citeAs[x]*/  return new Property("citeAs[x]", "Reference(Citation)|markdown", "Display of or reference to the bibliographic citation of the comment, classifier, or rating.", 0, 1, citeAs);
        case -1360156695: /*citeAs*/  return new Property("citeAs[x]", "Reference(Citation)|markdown", "Display of or reference to the bibliographic citation of the comment, classifier, or rating.", 0, 1, citeAs);
        case 1269009762: /*citeAsReference*/  return new Property("citeAs[x]", "Reference(Citation)", "Display of or reference to the bibliographic citation of the comment, classifier, or rating.", 0, 1, citeAs);
        case 456265720: /*citeAsMarkdown*/  return new Property("citeAs[x]", "markdown", "Display of or reference to the bibliographic citation of the comment, classifier, or rating.", 0, 1, citeAs);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the artifact assessment was published. The date must change when the disposition changes and it must change if the workflow status code changes. In addition, it should change when the substantive content of the artifact assessment changes.", 0, 1, date);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the artifact assessment and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the artifact assessment.", 0, 1, copyright);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case -1130056338: /*artifact[x]*/  return new Property("artifact[x]", "Reference(Any)|canonical|uri", "A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.", 0, 1, artifact);
        case -1228798510: /*artifact*/  return new Property("artifact[x]", "Reference(Any)|canonical|uri", "A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.", 0, 1, artifact);
        case -683686503: /*artifactReference*/  return new Property("artifact[x]", "Reference(Any)", "A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.", 0, 1, artifact);
        case 1069820738: /*artifactCanonical*/  return new Property("artifact[x]", "canonical", "A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.", 0, 1, artifact);
        case -1130062278: /*artifactUri*/  return new Property("artifact[x]", "uri", "A reference to a resource, canonical resource, or non-FHIR resource which the comment or assessment is about.", 0, 1, artifact);
        case 951530617: /*content*/  return new Property("content", "", "A component comment, classifier, or rating of the artifact.", 0, java.lang.Integer.MAX_VALUE, content);
        case 697796753: /*workflowStatus*/  return new Property("workflowStatus", "code", "Indicates the workflow status of the comment or change request.", 0, 1, workflowStatus);
        case 583380919: /*disposition*/  return new Property("disposition", "code", "Indicates the disposition of the responsible party to the comment or change request.", 0, 1, disposition);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1360156695: /*citeAs*/ return this.citeAs == null ? new Base[0] : new Base[] {this.citeAs}; // DataType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -1228798510: /*artifact*/ return this.artifact == null ? new Base[0] : new Base[] {this.artifact}; // DataType
        case 951530617: /*content*/ return this.content == null ? new Base[0] : this.content.toArray(new Base[this.content.size()]); // ArtifactAssessmentContentComponent
        case 697796753: /*workflowStatus*/ return this.workflowStatus == null ? new Base[0] : new Base[] {this.workflowStatus}; // Enumeration<ArtifactAssessmentWorkflowStatus>
        case 583380919: /*disposition*/ return this.disposition == null ? new Base[0] : new Base[] {this.disposition}; // Enumeration<ArtifactAssessmentDisposition>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1360156695: // citeAs
          this.citeAs = TypeConvertor.castToType(value); // DataType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 223539345: // approvalDate
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1228798510: // artifact
          this.artifact = TypeConvertor.castToType(value); // DataType
          return value;
        case 951530617: // content
          this.getContent().add((ArtifactAssessmentContentComponent) value); // ArtifactAssessmentContentComponent
          return value;
        case 697796753: // workflowStatus
          value = new ArtifactAssessmentWorkflowStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.workflowStatus = (Enumeration) value; // Enumeration<ArtifactAssessmentWorkflowStatus>
          return value;
        case 583380919: // disposition
          value = new ArtifactAssessmentDispositionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.disposition = (Enumeration) value; // Enumeration<ArtifactAssessmentDisposition>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("citeAs[x]")) {
          this.citeAs = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("artifact[x]")) {
          this.artifact = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("content")) {
          this.getContent().add((ArtifactAssessmentContentComponent) value);
        } else if (name.equals("workflowStatus")) {
          value = new ArtifactAssessmentWorkflowStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.workflowStatus = (Enumeration) value; // Enumeration<ArtifactAssessmentWorkflowStatus>
        } else if (name.equals("disposition")) {
          value = new ArtifactAssessmentDispositionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.disposition = (Enumeration) value; // Enumeration<ArtifactAssessmentDisposition>
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("citeAs[x]")) {
          this.citeAs = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("copyright")) {
          this.copyright = null;
        } else if (name.equals("approvalDate")) {
          this.approvalDate = null;
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = null;
        } else if (name.equals("artifact[x]")) {
          this.artifact = null;
        } else if (name.equals("content")) {
          this.getContent().add((ArtifactAssessmentContentComponent) value);
        } else if (name.equals("workflowStatus")) {
          value = new ArtifactAssessmentWorkflowStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.workflowStatus = (Enumeration) value; // Enumeration<ArtifactAssessmentWorkflowStatus>
        } else if (name.equals("disposition")) {
          value = new ArtifactAssessmentDispositionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.disposition = (Enumeration) value; // Enumeration<ArtifactAssessmentDisposition>
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 110371416:  return getTitleElement();
        case -1706539017:  return getCiteAs();
        case -1360156695:  return getCiteAs();
        case 3076014:  return getDateElement();
        case 1522889671:  return getCopyrightElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -1130056338:  return getArtifact();
        case -1228798510:  return getArtifact();
        case 951530617:  return addContent(); 
        case 697796753:  return getWorkflowStatusElement();
        case 583380919:  return getDispositionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1360156695: /*citeAs*/ return new String[] {"Reference", "markdown"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -1228798510: /*artifact*/ return new String[] {"Reference", "canonical", "uri"};
        case 951530617: /*content*/ return new String[] {};
        case 697796753: /*workflowStatus*/ return new String[] {"code"};
        case 583380919: /*disposition*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.title");
        }
        else if (name.equals("citeAsReference")) {
          this.citeAs = new Reference();
          return this.citeAs;
        }
        else if (name.equals("citeAsMarkdown")) {
          this.citeAs = new MarkdownType();
          return this.citeAs;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.date");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.copyright");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.lastReviewDate");
        }
        else if (name.equals("artifactReference")) {
          this.artifact = new Reference();
          return this.artifact;
        }
        else if (name.equals("artifactCanonical")) {
          this.artifact = new CanonicalType();
          return this.artifact;
        }
        else if (name.equals("artifactUri")) {
          this.artifact = new UriType();
          return this.artifact;
        }
        else if (name.equals("content")) {
          return addContent();
        }
        else if (name.equals("workflowStatus")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.workflowStatus");
        }
        else if (name.equals("disposition")) {
          throw new FHIRException("Cannot call addChild on a singleton property ArtifactAssessment.disposition");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ArtifactAssessment";

  }

      public ArtifactAssessment copy() {
        ArtifactAssessment dst = new ArtifactAssessment();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ArtifactAssessment dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.title = title == null ? null : title.copy();
        dst.citeAs = citeAs == null ? null : citeAs.copy();
        dst.date = date == null ? null : date.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.artifact = artifact == null ? null : artifact.copy();
        if (content != null) {
          dst.content = new ArrayList<ArtifactAssessmentContentComponent>();
          for (ArtifactAssessmentContentComponent i : content)
            dst.content.add(i.copy());
        };
        dst.workflowStatus = workflowStatus == null ? null : workflowStatus.copy();
        dst.disposition = disposition == null ? null : disposition.copy();
      }

      protected ArtifactAssessment typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ArtifactAssessment))
          return false;
        ArtifactAssessment o = (ArtifactAssessment) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(title, o.title, true) && compareDeep(citeAs, o.citeAs, true)
           && compareDeep(date, o.date, true) && compareDeep(copyright, o.copyright, true) && compareDeep(approvalDate, o.approvalDate, true)
           && compareDeep(lastReviewDate, o.lastReviewDate, true) && compareDeep(artifact, o.artifact, true)
           && compareDeep(content, o.content, true) && compareDeep(workflowStatus, o.workflowStatus, true)
           && compareDeep(disposition, o.disposition, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ArtifactAssessment))
          return false;
        ArtifactAssessment o = (ArtifactAssessment) other_;
        return compareValues(title, o.title, true) && compareValues(date, o.date, true) && compareValues(copyright, o.copyright, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
           && compareValues(workflowStatus, o.workflowStatus, true) && compareValues(disposition, o.disposition, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, title, citeAs
          , date, copyright, approvalDate, lastReviewDate, artifact, content, workflowStatus
          , disposition);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ArtifactAssessment;
   }

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The artifact assessment publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ArtifactAssessment.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ArtifactAssessment.date", description="The artifact assessment publication date", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The artifact assessment publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ArtifactAssessment.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The artifact assessment identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ArtifactAssessment.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ArtifactAssessment.identifier", description="The artifact assessment identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The artifact assessment identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ArtifactAssessment.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);


}

