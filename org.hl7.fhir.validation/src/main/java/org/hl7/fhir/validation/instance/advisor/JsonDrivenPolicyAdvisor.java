package org.hl7.fhir.validation.instance.advisor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;

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
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class JsonDrivenPolicyAdvisor implements IValidationPolicyAdvisor {

  private JsonObject config;
  private IValidationPolicyAdvisor base;

  public JsonDrivenPolicyAdvisor(IValidationPolicyAdvisor base, JsonObject config) {
    this.base = base;
    this.config = config;
  }

  public JsonDrivenPolicyAdvisor(String config) throws JsonException, IOException {
    this.config = JsonParser.parseObject(config, true);
  }

  public JsonDrivenPolicyAdvisor(File config) throws JsonException, IOException {
    this.config = JsonParser.parseObject(new FileInputStream(config), true);
  }
  
  public JsonDrivenPolicyAdvisor(FileInputStream config) throws JsonException, IOException {
    this.config = JsonParser.parseObject(config, true);
  }
  
  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path, String url) {
    return base.policyForReference(validator, appContext, path, url);
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator, Object appContext, StructureDefinition structure, ElementDefinition element, String containerType, String containerId, SpecialElement containingResourceType, String path, String url) {
    return base.policyForContained(validator, appContext, structure, element, containerType, containerId, containingResourceType, path, url);
  }

  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator, Object appContext, StructureDefinition type, String path) {
    return base.policyForResource(validator, appContext, type, path);
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator, Object appContext, StructureDefinition structure, ElementDefinition element, String path) {
    return base.policyForElement(validator, appContext, structure, element, path);
  }

  @Override
  public EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator, Object appContext, String stackPath, ElementDefinition definition, StructureDefinition structure, BindingKind kind, AdditionalBindingPurpose purpose, ValueSet valueSet, List<String> systems) {
    return base.policyForCodedContent(validator, appContext, stackPath, definition, structure, kind, purpose, valueSet, systems);
  }

  @Override
  public List<StructureDefinition> getImpliedProfilesForResource(IResourceValidator validator, Object appContext, String stackPath, ElementDefinition definition, StructureDefinition structure, Element resource, boolean valid, IMessagingServices msgServices, List<ValidationMessage> messages) {
    return base.getImpliedProfilesForResource(validator, appContext, stackPath, definition, structure, resource, valid, msgServices, messages);
  }

}
