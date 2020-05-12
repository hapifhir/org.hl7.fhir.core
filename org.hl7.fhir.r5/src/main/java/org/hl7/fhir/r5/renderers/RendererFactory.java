package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;

public class RendererFactory {

  public static ResourceRenderer factory(String resourceName, RenderingContext context) {
    if ("CodeSystem".equals(resourceName)) {
      return new CodeSystemRenderer(context);
    }
    if ("ValueSet".equals(resourceName)) {
      return new ValueSetRenderer(context);
    }
  if ("ConceptMap".equals(resourceName)) {
      return new ConceptMapRenderer(context);
    }
if ("Patient".equals(resourceName)) {
      return new PatientRenderer(context);
    }
    if ("Encounter".equals(resourceName)) {
      return new EncounterRenderer(context);
    }
    if ("Provenance".equals(resourceName)) {
      return new ProvenanceRenderer(context);
    }
    return new ProfileDrivenRenderer(context);    
  }
  
  public static ResourceRenderer factory(Resource resource, RenderingContext context) {
    return factory(resource.fhirType(), context);
  }
}