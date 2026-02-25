package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;

@MarkedToMoveToAdjunctPackage
public class RendererFactory {

  public static ResourceRenderer factory(String resourceName, RenderingContext context) {

    if (context.getTemplateProvider() != null) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, resourceName);
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
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
    case "WebTemplate": return new WebTemplateRenderer(context);
    }
    return new ProfileDrivenRenderer(context);    
  }

  public static ResourceRenderer factory(Resource resource, RenderingContext context) {

    if (context.getTemplateProvider() != null && resource instanceof DomainResource) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, (DomainResource) resource);
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }

    return factory(resource.fhirType(), context);
  }


  public static ResourceRenderer factory(ResourceWrapper resource, RenderingContext context) {
    if (context.getTemplateProvider() != null) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, resource.fhirType());
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
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

  public static boolean hasSpecificRenderer(String rt) {

    return Utilities.existsInList(rt, 
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
  public static boolean hasIGSpecificRenderer(String rt) {

    return Utilities.existsInList(rt, "ValueSet", "CapabilityStatement", "Questionnaire");
  }


}