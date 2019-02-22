package org.hl7.fhir.utilities.liquid;

import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.instance.model.api.IBase;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseLiquidHostServices {
  private Map<String, String> environmentVariables = new HashMap<>();
  private final LiquidEngine myLiquidEngine;

  public BaseLiquidHostServices(LiquidEngine theLiquidEngine) {
    myLiquidEngine = theLiquidEngine;
  }

  public void setEnvironmentVariable(String key, String value) {
    environmentVariables.put(key, value);
    if (!key.startsWith("\"")) {
      // Support both quoted and unquoted constant names
      environmentVariables.put("\"" + key + "\"", value);
    }
  }

  protected IBase resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
    IBase retval = myLiquidEngine.resolveConstant(appContext, name, beforeContext);
    if (retval != null) {
      return retval;
    }
    String value = environmentVariables.get(name);
    if (value == null) {
      return null;
    }
    return toStringtype(environmentVariables.get(name));
  }

  protected abstract IBase toStringtype(String s);
}
