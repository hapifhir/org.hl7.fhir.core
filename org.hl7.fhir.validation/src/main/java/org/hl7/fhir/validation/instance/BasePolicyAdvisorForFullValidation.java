package org.hl7.fhir.validation.instance;

import java.util.EnumSet;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class BasePolicyAdvisorForFullValidation implements IValidationPolicyAdvisor {

  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path,
      String url) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String containerType, String containerId,
      SpecialElement containingResourceType, String path, String url) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator, Object appContext,
      StructureDefinition type, String path) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String path) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator, Object appContext,
      String stackPath, ElementDefinition definition, StructureDefinition structure, BindingKind kind,
      AdditionalBindingPurpose purpose, ValueSet valueSet, List<String> systems) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<StructureDefinition> getImpliedProfilesForInstance(IResourceValidator validator, Object appContext,
      String stackPath, ElementDefinition definition, StructureDefinition structure, Element resource, boolean valid,
      List<ValidationMessage> messages) {
    // TODO Auto-generated method stub
    return null;
  }

}
