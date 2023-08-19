package org.hl7.fhir.r5.terminologies.utilities;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.utilities.i18n.I18nConstants;

import java.util.ArrayList;

public class TerminologyOperationContext {

  public static class TerminologyServiceProtectionException extends FHIRException {

    private TerminologyServiceErrorClass error;
    private IssueType type;

    public TerminologyServiceProtectionException(String message, TerminologyServiceErrorClass error, IssueType type) {
      super(message);
      this.error = error;
      this.type = type;
    }

    public TerminologyServiceErrorClass getError() {
      return error;
    }

    public IssueType getType() {
      return type;
    }

  }

  public static boolean debugging = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
  private static final int EXPANSION_DEAD_TIME_SECS = 60;
  private long deadTime;
  private List<String> contexts = new ArrayList<>();
  private IWorkerContext worker;
  private boolean original;
  
  public TerminologyOperationContext(IWorkerContext worker) {
    super();
    this.worker = worker;
    this.original = true;
    
    if (EXPANSION_DEAD_TIME_SECS == 0 || debugging) {
      deadTime = 0;
    } else {
      deadTime = System.currentTimeMillis() + (EXPANSION_DEAD_TIME_SECS * 1000);      
    }
  }
  
  private TerminologyOperationContext() {
    super();
  }

  public TerminologyOperationContext copy() {
    TerminologyOperationContext ret = new TerminologyOperationContext();
    ret.worker = worker;
    ret.contexts.addAll(contexts);
    ret.deadTime = deadTime;
    return ret;
  }
  
  public void deadCheck() {
    if (deadTime != 0 &&  System.currentTimeMillis() > deadTime) {
      throw new TerminologyServiceProtectionException(worker.formatMessage(I18nConstants.VALUESET_TOO_COSTLY_TIME, contexts.get(0), EXPANSION_DEAD_TIME_SECS), TerminologyServiceErrorClass.TOO_COSTLY, IssueType.TOOCOSTLY);
    }
  }
  
  public void seeContext(String context) {
    if (contexts.contains(context)) {
      throw new TerminologyServiceProtectionException(worker.formatMessage(I18nConstants.VALUESET_CIRCULAR_REFERENCE, context, contexts.toString()), TerminologyServiceErrorClass.BUSINESS_RULE, IssueType.BUSINESSRULE);
    }
    contexts.add(context);
  }

  public boolean isOriginal() {
    return original;
  }

  
}
