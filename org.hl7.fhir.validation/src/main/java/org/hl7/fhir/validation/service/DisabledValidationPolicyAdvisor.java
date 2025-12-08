package org.hl7.fhir.validation.service;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IMessagingServices;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class DisabledValidationPolicyAdvisor implements IValidationPolicyAdvisor {

  private IValidationPolicyAdvisor policyAdvisor;

  @Override
  public ReferenceValidationPolicy getReferencePolicy() {
    return ReferenceValidationPolicy.CHECK_TYPE_IF_EXISTS;
  }

  @Override
  public Set<String> getCheckReferencesTo() {
    return new HashSet<>();
  }

  @Override
  public boolean isSuppressMessageId(String path, String messageId) {
    return policyAdvisor.isSuppressMessageId(path, messageId);
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String containerType, String containerId,
      SpecialElement containingResourceType, String path, String url) {
    return policyAdvisor.policyForContained(validator, appContext, structure, element, containerType, containerId, containingResourceType, path, url);
  }

  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator, Object appContext,
      StructureDefinition type, String path) {
    return policyAdvisor.policyForResource(validator, appContext, type, path);
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String path) {
    return policyAdvisor.policyForElement(validator, appContext, structure, element, path);
  }

  @Override
  public EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator, Object appContext,
      String stackPath, ElementDefinition definition, StructureDefinition structure, BindingKind kind,
      AdditionalBindingPurpose purpose, ValueSet valueSet, List<String> systems) {
    return policyAdvisor.policyForCodedContent(validator, appContext, stackPath, definition, structure, kind, purpose, valueSet, systems);
  }

  @Override
  public List<StructureDefinition> getImpliedProfilesForResource(IResourceValidator validator, Object appContext,
      String stackPath, ElementDefinition definition, StructureDefinition structure, Element resource, boolean valid,
      IMessagingServices msgServices, List<ValidationMessage> messages) {
    return policyAdvisor.getImpliedProfilesForResource(validator, appContext, stackPath, definition, structure, resource, valid, msgServices, messages);
  }

  public IValidationPolicyAdvisor getPolicyAdvisor() {
    return policyAdvisor;
  }

  public IValidationPolicyAdvisor setPolicyAdvisor(IValidationPolicyAdvisor policyAdvisor) {
    this.policyAdvisor = policyAdvisor;
    return this;
  }

  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator,
                                                      Object appContext,
                                                      String path,
                                                      String url,
                                                      ReferenceDestinationType destinationType) {
    return ReferenceValidationPolicy.IGNORE;
  }

  @Override
  public SpecialValidationAction policyForSpecialValidation(IResourceValidator validator, Object appContext, SpecialValidationRule rule, String stackPath, Element resource, Element element) {
    return policyAdvisor.policyForSpecialValidation(validator, appContext, rule, stackPath, resource, element);
  }
}
