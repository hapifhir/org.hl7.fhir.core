package org.hl7.fhir.r5.renderers;

import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;

import org.hl7.fhir.utilities.Utilities;


public class RendererFactory {

  /**
   * Renderers registered for resource types that are not handled by the built-in renderers - 
   * typically resources defined by an incubator IG (see additional-resources-r5.md). A registered 
   * renderer takes precedence over the built-in renderer (and the profile-driven fallback) for the 
   * same resource name.
   * <p/>
   * The registered class must have a public constructor that takes a single RenderingContext
   * argument, as all the built-in renderers do. Registration is per RendererFactory instance (not
   * global): the application constructs the factory it hands to the RenderingContext and registers
   * the renderers it wants on that factory, so the registration is naturally scoped to that
   * rendering context and does not affect any other.
   */
  private final Map<String, Class<? extends ResourceRenderer>> registeredRenderers = new HashMap<>();

  public void registerRenderer(String name, Class<? extends ResourceRenderer> renderer) {
    registeredRenderers.put(name, renderer);
  }

  private ResourceRenderer makeRegisteredRenderer(String name, RenderingContext context) {
    Class<? extends ResourceRenderer> clss = registeredRenderers.get(name);
    if (clss == null) {
      return null;
    }
    try {
      return clss.getConstructor(RenderingContext.class).newInstance(context);
    } catch (Exception e) {
      throw new FHIRException("Unable to instantiate the registered renderer "+clss.getName()+" for '"+name+"' (it must have a public constructor that takes a RenderingContext): "+e.getMessage(), e);
    }
  }

  public ResourceRenderer factory(String resourceName, RenderingContext context) {

    if (context.getTemplateProvider() != null) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, resourceName);
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }
    if (Utilities.isAbsoluteUrl(resourceName)) {
      resourceName = Utilities.tail(resourceName);

    }
    ResourceRenderer registered = makeRegisteredRenderer(resourceName, context);
    if (registered != null) {
      return registered;
    }
    switch (resourceName) {
    case "ActorDefinition": return new ActorDefinitionRenderer(context);
    case "Bundle": return new BundleRenderer(context);
    case "CapabilityStatement": return new CapabilityStatementRenderer(context);
    case "CodeSystem": return new CodeSystemRenderer(context);
    case "CompartmentDefinition":  return new CompartmentDefinitionRenderer(context);
    case "Consent": return new ConsentRenderer(context);
    case "ConceptMap": return new ConceptMapRenderer(context);
    case "DiagnosticReport": return new DiagnosticReportRenderer(context);
    case "ExampleScenario": return new ExampleScenarioRenderer(context);
    case "ImplementationGuide": return new ImplementationGuideRenderer(context);
    case "Library": return new LibraryRenderer(context);
    case "List": return new ListRenderer(context);
    case "NamingSystem": return new NamingSystemRenderer(context);
    case "OperationDefinition": return new OperationDefinitionRenderer(context);
    case "OperationOutcome": return new OperationOutcomeRenderer(context);
    case "Parameters": return new ParametersRenderer(context);
    case "Patient": return new PatientRenderer(context);
    case "Provenance": return new ProvenanceRenderer(context);
    case "Questionnaire": return new QuestionnaireRenderer(context);
    case "QuestionnaireResponse": return new QuestionnaireResponseRenderer(context);
    case "Requirements": return new RequirementsRenderer(context);
    case "SearchParameter": return new SearchParameterRenderer(context);
    case "StructureDefinition": return new StructureDefinitionRenderer(context);
    case "StructureMap": return new StructureMapRenderer(context);
    case "SubscriptionTopic": return new SubscriptionTopicRenderer(context);
    case "TestPlan": return new TestPlanRenderer(context);
    case "ValueSet": return new ValueSetRenderer(context);
    case "ViewDefinition": return new ViewDefinitionRenderer(context);
      case "FeatureDefinition" : return new FeatureDefinitionRenderer(context);
    case "WebTemplate": return new WebTemplateRenderer(context);
    }
    return new ProfileDrivenRenderer(context);
  }

  public ResourceRenderer factory(Resource resource, RenderingContext context) {

    if (context.getTemplateProvider() != null && resource instanceof DomainResource) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, (DomainResource) resource);
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }

    return factory(resource.fhirType(), context);
  }


  public ResourceRenderer factory(ResourceWrapper resource, RenderingContext context) {
    if (context.getTemplateProvider() != null) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, resource.fhirType());
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }
    ResourceRenderer registered = makeRegisteredRenderer(resource.fhirType(), context);
    if (registered != null) {
      return registered;
    }
    switch (resource.fhirType()) {
    case "DiagnosticReport": return new DiagnosticReportRenderer(context);
    case "Library": return new LibraryRenderer(context);
    case "Consent": return new ConsentRenderer(context);
    case "ViewDefinition": return new ViewDefinitionRenderer(context);
    case "WebTemplate": return new WebTemplateRenderer(context);
    case "FeatureDefinition": return new FeatureDefinitionRenderer(context);
    case "List": return new ListRenderer(context);
    case "Patient": return new PatientRenderer(context);
    case "Provenance": return new ProvenanceRenderer(context);
    case "Parameters": return new ParametersRenderer(context);
    case "Questionnaire": return new QuestionnaireRenderer(context);
    case "QuestionnaireResponse": return new QuestionnaireResponseRenderer(context);
    }
    if (resource.isDirect()) {
      switch (resource.fhirType()) {

      case "ActorDefinition": return new ActorDefinitionRenderer(context);
      case "Bundle": return new BundleRenderer(context);
      case "CapabilityStatement": return new CapabilityStatementRenderer(context);
      case "CodeSystem": return new CodeSystemRenderer(context);
      case "CompartmentDefinition":  return new CompartmentDefinitionRenderer(context);
      case "ConceptMap": return new ConceptMapRenderer(context);
      case "ExampleScenario": return new ExampleScenarioRenderer(context);
      case "ImplementationGuide": return new ImplementationGuideRenderer(context);
      case "NamingSystem": return new NamingSystemRenderer(context);
      case "OperationDefinition": return new OperationDefinitionRenderer(context);
      case "OperationOutcome": return new OperationOutcomeRenderer(context);
      case "Requirements": return new RequirementsRenderer(context);
      case "SearchParameter": return new SearchParameterRenderer(context);
      case "StructureDefinition": return new StructureDefinitionRenderer(context);
      case "StructureMap": return new StructureMapRenderer(context);
      case "SubscriptionTopic": return new SubscriptionTopicRenderer(context);
      case "TestPlan": return new TestPlanRenderer(context);
      case "ValueSet": return new ValueSetRenderer(context);
      }
    }

    return new ProfileDrivenRenderer(context);
  }

  public boolean hasSpecificRenderer(String rt) {

    return registeredRenderers.containsKey(rt) || Utilities.existsInList(rt, 
        "CodeSystem", "ValueSet", "ConceptMap", 
        "CapabilityStatement", "CompartmentDefinition", "ImplementationGuide", "Library", "NamingSystem", "OperationDefinition", 
        "Questionnaire", "SearchParameter", "StructureDefinition", "ActorDefinition", "Requirements", "TestPlan", "ExampleScenario", "Consent");
  }

  /**
   * This is a list of renderers that return something different in IG mode, and the implementation guide 
   * publisher will regenerate the narrative for the IG mode 
   * @param rt
   * @return
   */
  public boolean hasIGSpecificRenderer(String rt) {

    return Utilities.existsInList(rt, "ValueSet", "CapabilityStatement", "Questionnaire");
  }


}
