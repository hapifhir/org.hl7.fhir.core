package org.hl7.fhir.validation.instance.advisor;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Element;
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

@Slf4j
public class RulesDrivenPolicyAdvisor extends BasePolicyAdvisorForFullValidation {

  private IValidationPolicyAdvisor base;
  
  public RulesDrivenPolicyAdvisor(ReferenceValidationPolicy refpol, Set<String> referencesTo) {
    super(refpol, referencesTo);
    base = null;
  }

  public RulesDrivenPolicyAdvisor(IValidationPolicyAdvisor base) {
    super(base.getReferencePolicy(), base.getCheckReferencesTo());
    this.base = base;
  }

  private class SuppressMessageRule {
    private String id;
    private String path;
    private String[] pathSegments;
    private boolean regex;
    
    protected SuppressMessageRule(@Nonnull String id, String path, boolean regex) {
      super();
      this.id = id;
      this.path = path;
      this.pathSegments = path.split("\\.");
      this.regex = regex;
    }

    protected SuppressMessageRule(@Nonnull String id) {
      super();
      this.id = id;
    }

    public boolean matches(@Nonnull String mid, @Nonnull String path, String[] p) {
      if (regex) {
        return stringMatches(id, mid) && regexMatches(this.path, path);
      } else {
        return stringMatches(id, mid) && pathMatches(pathSegments, p);
      }
    }
  }
  
  // string matching 

  boolean pathMatches(String[] specifier, String[] actual) {
    if (specifier == null) {
      return true;
    }
    for (int i = 0; i < specifier.length; i++) {
      if (i == actual.length) {
        return false;
      } else if (!pathSegmentMatches(specifier[i], actual[i])) {
        return false;
      }
    }
    if (actual.length > specifier.length) {
      return specifier[specifier.length-1].equals("*");
    } else {
      return true;
    }
  }

  boolean pathSegmentMatches(String specifier, String actual) {
    if ("*".equals(specifier)) {
      return true;
    } else if (!specifier.contains("[")) {
      if (actual.contains("[")) {
        actual = actual.substring(0, actual.indexOf("["));
      }
      return specifier.equals(actual);
    } else {      
      return specifier.equals(actual);
    }
  }

  boolean stringMatches(String specifier, @Nonnull String actual) {
    if (specifier == null) {
      return true;
    } else if (specifier.endsWith("*")) {
      return specifier.substring(0, specifier.length()-1).equalsIgnoreCase(actual.substring(0, Integer.min(specifier.length()-1, actual.length())));      
    } else {
      return specifier.equalsIgnoreCase(actual);
    }
  }
  
  boolean regexMatches(String specifier, @Nonnull String actual) {
    if (specifier == null) {
      return true;
    } else {
      return actual.matches(specifier);
    }
  }
  
  private List<SuppressMessageRule> suppressMessageRules = new ArrayList<>();
  private int suppressed = 0;

  protected void addSuppressMessageRule(@Nonnull String id, String path, boolean regex) {
    log.debug("SuppressingRule was added for: " + id + " at path " + path + " as regex?: " + regex);
    suppressMessageRules.add(new SuppressMessageRule(id, path, regex));
  }
  
  protected void addSuppressMessageRule(@Nonnull String id) {
    log.debug("SuppressingRule was added for: " + id);
    suppressMessageRules.add(new SuppressMessageRule(id));
  }
  
  @Override
  public boolean isSuppressMessageId(String path, String messageId) {
    String[] p = path.split("\\.");
    for (SuppressMessageRule rule : suppressMessageRules) {
      if (rule.matches(messageId, path, p)) {
        log.debug("Suppressed: " + messageId + " at path " + path + " with rule-path: " + rule.path);
        return true;
      }
    }
    if (base != null) {
      return base.isSuppressMessageId(path, messageId);      
    } else {
      return super.isSuppressMessageId(path, messageId);
    }
  }

  
  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator,
                                               Object appContext,
                                               String path,
                                               String url,
                                               ReferenceDestinationType destinationType) {
    if (base != null) {
      return base.policyForReference(validator, appContext, path, url, destinationType);      
    } else {
      return super.policyForReference(validator, appContext, path, url, destinationType);
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
