package org.hl7.fhir.r5.profilemodel;

import java.util.Map;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceFactory;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.utilities.Utilities;

public class TestInstanceGenerator {

  private IWorkerContext context;
  private Map<String, String> data;
  
  protected TestInstanceGenerator(IWorkerContext context) {
    super();
    this.context = context;
  }

  public Resource generate(StructureDefinition profile) {
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.NONE, true);
    PEDefinition definition = builder.buildPEDefinition(profile);
    Resource res = ResourceFactory.createResource(definition.types().get(0).getType());
    populateByProfile(res, definition);
    
    res.getMeta().addProfile(definition.profile.getVersionedUrl());
    return res;
  }
  
  protected void populateByProfile(Base base, PEDefinition definition) {
    if (definition.types().size() == 1) {
      for (PEDefinition pe : definition.directChildren(true)) {
        if (pe.hasFixedValue()) {
          if (pe.definition().hasPattern()) {
            base.setProperty(pe.schemaName(), pe.definition().getPattern());
          } else { 
            base.setProperty(pe.schemaName(), pe.definition().getFixed());
          }
        } else if (!pe.isSlicer() && pe.max() == 1) {
          for (int i = 0; i < pe.min(); i++) {
            Base b = null;
            if (pe.schemaName().endsWith("[x]")) {
              if (pe.types().size() == 1) {
                b = base.addChild(pe.schemaName().replace("[x]", Utilities.capitalize(pe.types().get(0).getType())));
              }
            } else if (!pe.isBaseList()) {
              b = base.makeProperty(pe.schemaName().hashCode(), pe.schemaName());
            } else {
              b = base.addChild(pe.schemaName());
            }
            if (b != null) {
              populateByProfile(b, pe);
            }
          }
        }
      }
    }
  }

  
}
