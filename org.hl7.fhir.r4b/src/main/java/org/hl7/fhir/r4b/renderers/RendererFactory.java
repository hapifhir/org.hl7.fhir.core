package org.hl7.fhir.r4b.renderers;

import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;

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

  public static ResourceRenderer factory(ResourceWrapper resource, RenderingContext context,
      ResourceContext resourceContext) {
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

}