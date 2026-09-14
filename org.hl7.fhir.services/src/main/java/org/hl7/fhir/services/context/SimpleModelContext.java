package org.hl7.fhir.services.context;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.ModelContextInformation;
import org.hl7.fhir.model.api.ApiRegistration;
import org.hl7.fhir.model.fml.FmlRegistration;
import org.hl7.fhir.model.testing.TestingRegistration;
import org.hl7.fhir.model.tools.ToolsRegistration;

public class SimpleModelContext implements IModelContext  {
  private @NonNull ModelContextInformation contextInformation;

  public SimpleModelContext() {
    contextInformation = new ModelContextInformation();
    ToolsRegistration.register(this, false);
    TestingRegistration.register(this, false);
    FmlRegistration.register(this, false);
    ApiRegistration.register(this, false);
  }

  @Override
  public @NonNull String getFHIRVersion() {
    return "6.0.0";
  }

  @Override
  public @NonNull ModelContextInformation getContextInformation() {
    return contextInformation;
  }

  @Override
  public boolean isCompatibleModelContext(IModelContext modelContext) {
    return contextInformation.isCompatible(modelContext.getContextInformation());
  }

  @Override
  public String describeContext() {
    return "SimpleContext";
  }
}
