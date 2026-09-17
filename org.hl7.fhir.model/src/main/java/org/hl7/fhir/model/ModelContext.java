package org.hl7.fhir.model;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.model.api.ApiRegistration;
import org.hl7.fhir.model.fml.FmlRegistration;
import org.hl7.fhir.model.testing.TestingRegistration;
import org.hl7.fhir.model.tools.ToolsRegistration;

public class ModelContext implements IModelContext  {

  /**
   * Lazily initialised on first use of {@link #fullCoreContext()}; the class loader
   * makes that thread safe and exactly-once
   */
  private static final class FullCore {
    private static final ModelContext INSTANCE = build();

    private static ModelContext build() {
      ModelContext mc = new ModelContext();
      ToolsRegistration.register(mc, false);
      TestingRegistration.register(mc, false);
      FmlRegistration.register(mc, false);
      ApiRegistration.register(mc, false);
      return mc;
    }
  }

  private final @NonNull ModelContextInformation contextInformation;

  public ModelContext() {
    contextInformation = new ModelContextInformation();
  }

  /**
   * The shared model context for the core specification plus the packages the model
   * module carries code for (tools, testing, fml, api). This is a singleton: every
   * caller gets the same context, so objects created under any of them are usable
   * under all of them, and nothing is registered twice
   * <p>
   * Because it is shared, callers must not register anything further on it - an
   * application that needs its own registrations (e.g. custom resources generated
   * by the validator's -codegen) builds its own {@link ModelContext} instead
   *
   * @return the shared full-core model context
   */
  public static ModelContext fullCoreContext() {
    return FullCore.INSTANCE;
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
