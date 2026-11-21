package org.hl7.fhir.utilities;

/**
 * The context of a run of an expression language or template engine (FHIRPath's ExecutionContext, Liquid's
 * LiquidEngineContext), which carries the run's {@link ExecutionLimits}.
 * <p/>
 * When one engine runs another, it passes its context as the app context (Liquid does this whenever it evaluates
 * FHIRPath), and the engine it runs uses the limits it finds there, so that the whole run has one budget. An app
 * context that isn't one of these gets a budget of its own.
 */
public abstract class LimitedExecutionContext {

  private final ExecutionLimits executionLimits;

  protected LimitedExecutionContext(ExecutionLimits executionLimits) {
    this.executionLimits = executionLimits;
  }

  public ExecutionLimits getExecutionLimits() {
    return executionLimits;
  }

  /**
   * The limits of the run an app context belongs to, if it's the context of an engine's run; null if it isn't
   */
  public static ExecutionLimits limitsOf(Object appContext) {
    return appContext instanceof LimitedExecutionContext ? ((LimitedExecutionContext) appContext).getExecutionLimits() : null;
  }
}
