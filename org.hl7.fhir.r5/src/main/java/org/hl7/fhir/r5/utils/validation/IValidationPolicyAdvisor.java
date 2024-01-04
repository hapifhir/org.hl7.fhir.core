package org.hl7.fhir.r5.utils.validation;

import java.util.EnumSet;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.CodedContentValidationPolicy;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.ElementValidationAction;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;

public interface IValidationPolicyAdvisor {

  /**
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
                                               String url);

  /**
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

  
}