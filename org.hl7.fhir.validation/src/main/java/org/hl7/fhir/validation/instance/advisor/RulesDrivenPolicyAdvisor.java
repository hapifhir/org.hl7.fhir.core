package org.hl7.fhir.validation.instance.advisor;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IMessagingServices;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.AdditionalBindingPurpose;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.CodedContentValidationAction;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.ElementValidationAction;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.ResourceValidationAction;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.CodedContentValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class RulesDrivenPolicyAdvisor extends BasePolicyAdvisorForFullValidation {

  private IValidationPolicyAdvisor base;
  
  public RulesDrivenPolicyAdvisor(ReferenceValidationPolicy refpol) {
    super(refpol);
    base = null;
  }

  public RulesDrivenPolicyAdvisor(IValidationPolicyAdvisor base) {
    super(base.getReferencePolicy());
    this.base = base;
  }

  private class SuppressMessageRule {
    private String id;
    private String path;
    protected SuppressMessageRule(String id, String path) {
      super();
      this.id = id;
      this.path = path;
    }
    public String getId() {
      return id;
    }
    public String getPath() {
      return path;
    }
    public boolean matches(String mid, String p) {
      if (((id == null) || id.equals(mid)) && ((path == null) || path.equals(p))) {
        suppressed++;
        return true;
      } else if (((id == null) || mid.matches(id)) && ((path == null) || p.matches(path))) {
        suppressed++;
        return true;
      } else {
        return false;
      }
    }
  }
  
  private List<SuppressMessageRule> suppressMessageRules = new ArrayList<>();
  private int suppressed = 0;

  protected void addSuppressMessageRule(String id, String path) {
    suppressMessageRules.add(new SuppressMessageRule(id, path));
  }
  
  @Override
  public boolean suppressMessageId(String path, String messageId) {
    for (SuppressMessageRule rule : suppressMessageRules) {
      if (rule.matches(messageId, path)) {
        return true;
      }
    }
    if (base != null) {
      return base.suppressMessageId(path, messageId);      
    } else {
      return super.suppressMessageId(path, messageId);
    }
  }

  
  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator,
                                               Object appContext,
                                               String path,
                                               String url) {
    if (base != null) {
      return base.policyForReference(validator, appContext, path, url);      
    } else {
      return super.policyForReference(validator, appContext, path, url);
    }
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator,
                                                        Object appContext,
                                                        StructureDefinition structure,
                                                        ElementDefinition element,
                                                        String containerType,
                                                        String containerId,
                                                        Element.SpecialElement containingResourceType,
                                                        String path,
                                                        String url) {
    if (base != null) {
      return base.policyForContained(validator, appContext, structure, element, containerType, containerId, containingResourceType, path, url);      
    } else {
      return super.policyForContained(validator, appContext, structure, element, containerType, containerId, containingResourceType, path, url);
    }
  }

  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator,
      Object appContext,
      StructureDefinition type,
      String path) {
    if (base != null) {
      return base.policyForResource(validator, appContext, type, path);      
    } else {
      return super.policyForResource(validator, appContext, type, path);
    }
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator,
                                                      Object appContext,
                                                      StructureDefinition structure,
                                                      ElementDefinition element,
                                                      String path) {
    if (base != null) {
      return base.policyForElement(validator, appContext, structure, element, path);      
    } else {
      return super.policyForElement(validator, appContext, structure, element, path);
    }
  }
  
  @Override
  public EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator,
                                                        Object appContext,
                                                        String stackPath,
                                                        ElementDefinition definition,
                                                        StructureDefinition structure,
                                                        BindingKind kind,
                                                        AdditionalBindingPurpose purpose,
                                                        ValueSet valueSet,
                                                        List<String> systems) {
    if (base != null) {
      return base.policyForCodedContent(validator, appContext, stackPath, definition, structure, kind, purpose, valueSet, systems);      
    } else {
      return super.policyForCodedContent(validator, appContext, stackPath, definition, structure, kind, purpose, valueSet, systems);
    }
  }

  @Override
  public List<StructureDefinition> getImpliedProfilesForResource(IResourceValidator validator,
                                                        Object appContext,
                                                        String stackPath,
                                                        ElementDefinition definition,
                                                        StructureDefinition structure,
                                                        Element resource,
                                                        boolean valid,
                                                        IMessagingServices msgServices,
                                                        List<ValidationMessage> messages) {
    if (base != null) {
      return base.getImpliedProfilesForResource(validator, appContext, stackPath, definition, structure, resource, valid, msgServices, messages);      
    } else {
      return super.getImpliedProfilesForResource(validator, appContext, stackPath, definition, structure, resource, valid, msgServices, messages);
    }
  }

  
}
