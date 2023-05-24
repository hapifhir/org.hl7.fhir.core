package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.Utilities;

public class RendererFactory {

  public static ResourceRenderer factory(String resourceName, RenderingContext context) {

    if (context.getTemplateProvider() != null) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, resourceName);
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }

    if ("CodeSystem".equals(resourceName)) {
      return new CodeSystemRenderer(context);
    }
    if ("ValueSet".equals(resourceName)) {
      return new ValueSetRenderer(context);
    }
    if ("ConceptMap".equals(resourceName)) {
      return new ConceptMapRenderer(context);
    }

    if ("CapabilityStatement".equals(resourceName)) {
      return new CapabilityStatementRenderer(context);
    }
    if ("StructureDefinition".equals(resourceName)) {
      return new StructureDefinitionRenderer(context);
    }
    if ("OperationDefinition".equals(resourceName)) {
      return new OperationDefinitionRenderer(context);
    }
    if ("SearchParameter".equals(resourceName)) {
      return new SearchParameterRenderer(context);
    }
    if ("CompartmentDefinition".equals(resourceName)) {
      return new CompartmentDefinitionRenderer(context);
    }
    if ("ImplementationGuide".equals(resourceName)) {
      return new ImplementationGuideRenderer(context);
    }
    if ("NamingSystem".equals(resourceName)) {
      return new NamingSystemRenderer(context);
    }
    if ("Questionnaire".equals(resourceName)) {
      return new QuestionnaireRenderer(context);
    }

    if ("QuestionnaireResponse".equals(resourceName)) {
      return new QuestionnaireResponseRenderer(context);
    }

    if ("Patient".equals(resourceName)) {
      return new PatientRenderer(context);
    }
    if ("Encounter".equals(resourceName)) {
      return new EncounterRenderer(context);
    }
    if ("Library".equals(resourceName)) {
      return new LibraryRenderer(context);
    }
    if ("List".equals(resourceName)) {
      return new ListRenderer(context);
    }
    if ("DiagnosticReport".equals(resourceName)) {
      return new DiagnosticReportRenderer(context);
    }

    if ("Provenance".equals(resourceName)) {
      return new ProvenanceRenderer(context);
    }
    if ("OperationOutcome".equals(resourceName)) {
      return new OperationOutcomeRenderer(context);
    }
    if ("Parameters".equals(resourceName)) {
      return new ParametersRenderer(context);
    }
    if ("Bundle".equals(resourceName)) {
      return new BundleRenderer(context);
    }
    if ("ActorDefinition".equals(resourceName)) {
      return new ActorDefinitionRenderer(context);
    }
    if ("Requirements".equals(resourceName)) {
      return new RequirementsRenderer(context);
    }
    if ("StructureMap".equals(resourceName)) {
      return new StructureMapRenderer(context);
    }
    if ("TestPlan".equals(resourceName)) {
        return new TestPlanRenderer(context);
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


  public static ResourceRenderer factory(ResourceWrapper resource, RenderingContext context, ResourceContext resourceContext) {
    if (context.getTemplateProvider() != null) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, resource.getName());
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }

    if ("List".equals(resource.getName())) {
      return new ListRenderer(context);
    }
    if ("Library".equals(resource.getName())) {
      return new LibraryRenderer(context);
    }
    if ("Patient".equals(resource.getName())) {
      return new PatientRenderer(context);
    }
    if ("DiagnosticReport".equals(resource.getName())) {
      return new DiagnosticReportRenderer(context);
    }
    if ("QuestionnaireResponse".equals(resource.getName())) {
      return new QuestionnaireResponseRenderer(context);
    }

    return new ProfileDrivenRenderer(context, resourceContext);    
  }

  public static ResourceRenderer factory(ResourceWrapper rw, RenderingContext lrc) {
    return factory(rw, lrc, null);
  }

  public static boolean hasSpecificRenderer(String rt) {
    
    return Utilities.existsInList(rt, 
        "CodeSystem", "ValueSet", "ConceptMap", 
        "CapabilityStatement", "CompartmentDefinition", "ImplementationGuide", "Library", "NamingSystem", "OperationDefinition", 
        "Questionnaire", "SearchParameter", "StructureDefinition", "ActorDefinition", "Requirements", "TestPlan");
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