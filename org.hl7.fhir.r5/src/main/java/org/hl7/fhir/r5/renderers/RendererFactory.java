package org.hl7.fhir.r5.renderers;

import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;

@MarkedToMoveToAdjunctPackage
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
      return clss.getConstructor(RenderingContext.class).newInstance(context).withRendererFactory(this);
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
    case "ActorDefinition": return new ActorDefinitionRenderer(context).withRendererFactory(this);
    case "Bundle": return new BundleRenderer(context).withRendererFactory(this);
    case "CapabilityStatement": return new CapabilityStatementRenderer(context).withRendererFactory(this);
    case "CodeSystem": return new CodeSystemRenderer(context).withRendererFactory(this);
    case "CompartmentDefinition":  return new CompartmentDefinitionRenderer(context).withRendererFactory(this);
    case "Consent": return new ConsentRenderer(context).withRendererFactory(this);
    case "ConceptMap": return new ConceptMapRenderer(context).withRendererFactory(this);
    case "DiagnosticReport": return new DiagnosticReportRenderer(context).withRendererFactory(this);
    case "ExampleScenario": return new ExampleScenarioRenderer(context).withRendererFactory(this);
    case "ImplementationGuide": return new ImplementationGuideRenderer(context).withRendererFactory(this);
    case "Library": return new LibraryRenderer(context).withRendererFactory(this);
    case "List": return new ListRenderer(context).withRendererFactory(this);
    case "NamingSystem": return new NamingSystemRenderer(context).withRendererFactory(this);
    case "OperationDefinition": return new OperationDefinitionRenderer(context).withRendererFactory(this);
    case "OperationOutcome": return new OperationOutcomeRenderer(context).withRendererFactory(this);
    case "Parameters": return new ParametersRenderer(context).withRendererFactory(this);
    case "Patient": return new PatientRenderer(context).withRendererFactory(this);
    case "Provenance": return new ProvenanceRenderer(context).withRendererFactory(this);
    case "Questionnaire": return new QuestionnaireRenderer(context).withRendererFactory(this);
    case "QuestionnaireResponse": return new QuestionnaireResponseRenderer(context).withRendererFactory(this);
    case "Requirements": return new RequirementsRenderer(context).withRendererFactory(this);
    case "SearchParameter": return new SearchParameterRenderer(context).withRendererFactory(this);
    case "StructureDefinition": return new StructureDefinitionRenderer(context).withRendererFactory(this);
    case "StructureMap": return new StructureMapRenderer(context).withRendererFactory(this);
    case "SubscriptionTopic": return new SubscriptionTopicRenderer(context).withRendererFactory(this);
    case "TestPlan": return new TestPlanRenderer(context).withRendererFactory(this);
    case "ValueSet": return new ValueSetRenderer(context).withRendererFactory(this);
    case "ViewDefinition": return new ViewDefinitionRenderer(context).withRendererFactory(this);
      case "FeatureDefinition" : return new FeatureDefinitionRenderer(context).withRendererFactory(this);
    case "WebTemplate": return new WebTemplateRenderer(context).withRendererFactory(this);
    }
    return new ProfileDrivenRenderer(context).withRendererFactory(this);
  }

  public ResourceRenderer factory(Resource resource, RenderingContext context) {

    if (context.getTemplateProvider() != null && resource instanceof DomainResource) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, (DomainResource) resource);
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate).withRendererFactory(this);
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
    case "DiagnosticReport": return new DiagnosticReportRenderer(context).withRendererFactory(this);
    case "Library": return new LibraryRenderer(context).withRendererFactory(this);
    case "Consent": return new ConsentRenderer(context).withRendererFactory(this);
    case "ViewDefinition": return new ViewDefinitionRenderer(context).withRendererFactory(this);
    case "WebTemplate": return new WebTemplateRenderer(context).withRendererFactory(this);
    case "FeatureDefinition": return new FeatureDefinitionRenderer(context).withRendererFactory(this);
    case "List": return new ListRenderer(context).withRendererFactory(this);
    case "Patient": return new PatientRenderer(context).withRendererFactory(this);
    case "Provenance": return new ProvenanceRenderer(context).withRendererFactory(this);
    case "Parameters": return new ParametersRenderer(context).withRendererFactory(this);
    case "Questionnaire": return new QuestionnaireRenderer(context).withRendererFactory(this);
    case "QuestionnaireResponse": return new QuestionnaireResponseRenderer(context).withRendererFactory(this);
    }
    if (resource.isDirect()) {
      switch (resource.fhirType()) {

      case "ActorDefinition": return new ActorDefinitionRenderer(context).withRendererFactory(this);
      case "Bundle": return new BundleRenderer(context).withRendererFactory(this);
      case "CapabilityStatement": return new CapabilityStatementRenderer(context).withRendererFactory(this);
      case "CodeSystem": return new CodeSystemRenderer(context).withRendererFactory(this);
      case "CompartmentDefinition":  return new CompartmentDefinitionRenderer(context).withRendererFactory(this);
      case "ConceptMap": return new ConceptMapRenderer(context).withRendererFactory(this);
      case "ExampleScenario": return new ExampleScenarioRenderer(context).withRendererFactory(this);
      case "ImplementationGuide": return new ImplementationGuideRenderer(context).withRendererFactory(this);
      case "NamingSystem": return new NamingSystemRenderer(context).withRendererFactory(this);
      case "OperationDefinition": return new OperationDefinitionRenderer(context).withRendererFactory(this);
      case "OperationOutcome": return new OperationOutcomeRenderer(context).withRendererFactory(this);
      case "Requirements": return new RequirementsRenderer(context).withRendererFactory(this);
      case "SearchParameter": return new SearchParameterRenderer(context).withRendererFactory(this);
      case "StructureDefinition": return new StructureDefinitionRenderer(context).withRendererFactory(this);
      case "StructureMap": return new StructureMapRenderer(context).withRendererFactory(this);
      case "SubscriptionTopic": return new SubscriptionTopicRenderer(context).withRendererFactory(this);
      case "TestPlan": return new TestPlanRenderer(context).withRendererFactory(this);
      case "ValueSet": return new ValueSetRenderer(context).withRendererFactory(this);
      }
    }

    return new ProfileDrivenRenderer(context).withRendererFactory(this);
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
