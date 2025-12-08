package org.hl7.fhir.r5.utils.validation;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.r5.utils.validation.constants.CodedContentValidationPolicy;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.ElementValidationAction;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.ReferenceDestinationType;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.SpecialValidationAction;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.SpecialValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;

@MarkedToMoveToAdjunctPackage
public interface IValidationPolicyAdvisor {



  public enum ReferenceDestinationType {
    CONTAINED, // the reference points to a contained resource in the resource being validated
    INTERNAL,  // the reference points to another resource in the scope of what is being validated  
    EXTERNAL;  // the reference points outside what is being validated. 
    // Note that at the point this is called, the validator has not tried to see whether the reference 
    // is resolvable based on the resources made available to it

    public String toCode() {
      switch (this) {
      case CONTAINED: return "contained";
      case EXTERNAL: return "external";
      case INTERNAL: return "internal";
      }
      return null;
    }
  }

  public IValidationPolicyAdvisor getPolicyAdvisor();
  public IValidationPolicyAdvisor setPolicyAdvisor(IValidationPolicyAdvisor policyAdvisor);

  /** 
   * Internal use, for chaining advisors - if you define an implementation, you return the default policy.
   * Usually, this is the policy for the operating policy advisor in place before your implementation is 
   * registered, so keep a reference to that and pass the value through
   * 
   * @return
   */
  ReferenceValidationPolicy getReferencePolicy();

  /**
   * a list of servers for which the ReferenceValidationPolicy will be CHECK_VALID.
   * if the reference is to a server not in this list, getReferencePolicy() applies
   */
  Set<String> getCheckReferencesTo();

  /**
   * Return true if the validation message for this message id should not be reported 
   * 
   * Note that this is generally a pretty blunt instrument. E.g. you might want to suppress 
   * errors associated with a particular code system, but this can only suppress errors associated 
   * with all code systems 
   * 
   * @param path - the current path of the element
   * @param messageId - the message id (from messages.properties)
   * @return true if the validator should ignore the message
   */
  boolean isSuppressMessageId(String path, String messageId);

  /**
   * Whether to try validating a reference, and if so, how much validation to apply
   * 
   * @param validator
   * @param appContext What was originally provided from the app for it's context
   * @param path Path that led us to this resource.
   * @param url Url of the profile the container resource is being validated against.
   * @return {@link ReferenceValidationPolicy}
   */
  ReferenceValidationPolicy policyForReference(IResourceValidator validator,
      Object appContext,
      String path,
      String url,
      ReferenceDestinationType destinationType);

  /**
   * whether to validate a contained resource. Note that if there's a reference to the
   * contained resource (and there should be), then the policyForReference will override
   * this value (e.g. if the result of policyForReference is CHECK_VALID, then the 
   * resource will be validated, irrespective of the value of policyForContained)
   * 
   * //TODO pass through the actual containing Element as opposed to the type, id
   * @param validator
   * @param appContext What was originally provided from the app for it's context
   * @param containerType Type of the resources that contains the resource being validated
   * @param containerId Id of the resources that contains the resource being validated
   * @param containingResourceType Type of the resource that will be validated (BUNDLE_ENTRY, BUNDLE_OUTCOME, CONTAINED_RESOURCE, PARAMETER)
   * @param path Path that led us to this resource.
   * @param url Url of the profile the container resource is being validated against.
   * @return {@link ReferenceValidationPolicy}
   */
  ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator,
      Object appContext,
      StructureDefinition structure,
      ElementDefinition element,
      String containerType,
      String containerId,
      Element.SpecialElement containingResourceType,
      String path,
      String url);


  public enum ResourceValidationAction {
    BaseType,
    StatedProfiles,
    MetaProfiles,
    GlobalProfiles
  }

  EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator,
      Object appContext,
      StructureDefinition type,
      String path);

  public enum ElementValidationAction {
    Cardinality, // though you can't stop slice matching cardinality checks from happening 
    Invariants, 
    Bindings,
    AdditionalBindings,
    StatusCheck
  }

  EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator,
      Object appContext,
      StructureDefinition structure,
      ElementDefinition element,
      String path);

  public enum AdditionalBindingPurpose {
    Minimum,
    Required,
    Extensible,
    Current,
    Preferred,
    Ui
  }

  public enum CodedContentValidationAction {
    VSCheck,  
    VSCheckThisCode,
    NotFound, 
    InvalidCode,
    InvalidDisplay,
    CannotInfer,
    CodeRule,
    VSInvalid,
    StatusCheck
  }

  /**
   * Called before validating a concept in an instance against the terminology sub-system
   * 
   * There's two reasons to use this policy advisor feature:
   *   - save time by not calling the terminology server for validation that don't bring value to the context calling the validation
   *   - suppressing known issues from being listed as a problem
   *   
   * Note that the terminology subsystem has two parts: a mini-terminology server running inside the 
   * validator, and then calling out to an external terminology service (usually tx.fhir.org, though you
   * run your own local copy of this - see https://confluence.hl7.org/display/FHIR/Running+your+own+copy+of+tx.fhir.org).
   * You can't tell which subsystem will handle the terminology validation directly from the content provided here which
   * subsystem will be called - you'll haev to investigate based on your set up. (matters, since it makes a huge performance 
   * difference, though it also depends on caching, and the impact of caching is also not known at this point)
   *   
   * @param validator
   * @param appContext What was originally provided from the app for it's context
   * @param stackPath The current path for the stack. Note that the because of cross-references and FHIRPath conformsTo() statements, the stack can wind through the content unpredictably. 
   * @param definition the definition being validated against (might be useful: ElementDefinition.base.path, ElementDefinition.type, ElementDefinition.binding
   * @param structure The structure definition that contains the element definition being validated against (may be from the base spec, may be from a profile)
   * @param kind The part of the binding being validated
   * @param valueSet The value set for the binding part that's being validated 
   * @param systems A list of canonical URls (including versions if known) of the systems in the instance that's being validated. Note that if a plain code is being validated, then there'll be no known system when this is called (systems will be empty, not null) 
   * @return {@link CodedContentValidationPolicy}
   */
  EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator,
      Object appContext,
      String stackPath,
      ElementDefinition definition,
      StructureDefinition structure,
      BindingKind kind,
      AdditionalBindingPurpose purpose,
      ValueSet valueSet,
      List<String> systems);

  public enum SpecialValidationAction {
    CHECK_RULE, IGNORE_RULE
  }

  public enum SpecialValidationRule {
    CODESYSTEM_METADATA_CHECKS, // check code system metadata - including count, hierarchy, etc
    CODESYSTEM_SUPPLEMENT_CHECKS, // check supplement integrity
    CODESYSTEM_VALUESET_CHECKS, // check that the designated value set actually is the right value set
    CODESYSTEM_PROPERTY_CHECKS, // check that the properties are defined properly
    CODESYSTEM_DESIGNATION_CHECKS, // check that concept designations (element = concept) 
    VALUESET_METADATA_CHECKS, // check the value set metadata (element = include/exclude)
    VALUESET_SYSTEM_CHECKS, // check that value set against the system definition (element = include/exclude) 
    VALUESET_IMPORT_CHECKS  // check the value set imports (element = include/exclude)
  }

  /**
   * This routine gives control over the execution of the advanced validator functionality that applies to particular kinds of resources
   * 
   * @param validator
   * @param appContext What was originally provided from the app for it's context
   * @param rule The rule that is to be executed (actually often a group of checks)
   * @param stackPath The current path for the stack. Note that the because of cross-references and FHIRPath conformsTo() statements, the stack can wind through the content unpredictably.
   * @param resource The resource that is being checked
   * @param element The element that is being checked (if relevant for the rule)
   * @return whether to execute the rule or not 
   */
  SpecialValidationAction policyForSpecialValidation(IResourceValidator validator,
      Object appContext,
      SpecialValidationRule rule,
      String stackPath,
      Element resource,
      Element element);

  /**
   * This is called after a resource has been validated against the base structure, 
   * but before it's validated against any profiles specified in .meta.profile or in the parameters. 
   * This can be used to determine what additional profiles should be applied, for instance
   * those derived from the http://hl7.org/fhir/tools/StructureDefinition/profile-mapping extension
   *  
   * Note that the resource is an elementModel resource, not an IBaseResource. This is less convenient to 
   * read values from, but is the way the internals of the validator works (e.g. the version of the resource 
   * might be any version from R2-R6)
   * 
   * The base implementation applies the mandatory vital signs to observations that have LOINC or SNOMED CT
   * codes that indicate that they are vital signs. Note that these profiles are not optional; all vital sign resources 
   * are required to conform to them. For this reason, if you're providing your own policy advisor, you should
   * keep a reference to the default one, or call BasePolicyAdvisorForFullValidation directly. You can choose not to,
   * but if you do, you are allowing for resources that deviate from the FHIR specification (in a way that the 
   * community considers clinically unsafe, since it means that software (probably) will miss vital signs for 
   * patients).
   * 
   * @param validator
   * @param appContext What was originally provided from the app for it's context
   * @param stackPath The current path for the stack. Note that the because of cross-references and FHIRPath conformsTo() statements, the stack can wind through the content unpredictably. 
   * @param definition the definition being validated against (might be useful: ElementDefinition.base.path, ElementDefinition.type, ElementDefinition.binding
   * @param structure The structure definition that contains the element definition being validated against (may be from the base spec, may be from a profile)
   * @param resource The actual resource (as an element model) so that the implementation can inspect the values in order to decide what profiles to apply 
   * @param valid true if the resource is so far considered valid
   * @param messages all the validation messages. Implementations can inspect this, but the real purpose is to populate the messages with information messages explaining why profiles were (or weren't) applied
   * @return
   */
  List<StructureDefinition> getImpliedProfilesForResource(IResourceValidator validator,
      Object appContext,
      String stackPath,
      ElementDefinition definition,
      StructureDefinition structure,
      Element resource,
      boolean valid,
      IMessagingServices msgServices,
      List<ValidationMessage> messages);


}