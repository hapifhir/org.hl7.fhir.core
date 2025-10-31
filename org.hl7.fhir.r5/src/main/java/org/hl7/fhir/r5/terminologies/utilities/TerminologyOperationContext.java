package org.hl7.fhir.r5.terminologies.utilities;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import java.util.ArrayList;

@MarkedToMoveToAdjunctPackage
@Slf4j
public class TerminologyOperationContext {

  public static class TerminologyServiceProtectionException extends FHIRException {

    private TerminologyServiceErrorClass error;
    private IssueType type;
    private String diagnostics;

    public TerminologyServiceProtectionException(String message, TerminologyServiceErrorClass error, IssueType type) {
      super(message);
      this.error = error;
      this.type = type;
    }
    public TerminologyServiceProtectionException(String message, TerminologyServiceErrorClass error, IssueType type, String diagnostics) {
      super(message);
      this.error = error;
      this.type = type;
      this.diagnostics = diagnostics;
    }

    public TerminologyServiceErrorClass getError() {
      return error;
    }

    public IssueType getType() {
      return type;
    }
    public String getDiagnostics() {
      return diagnostics;
    }

  }

  public static boolean debugging = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
  private static final int EXPANSION_DEAD_TIME_SECS = 60;
  private long deadTime;
  private int nestCount = 0;
  private long startTime;
  private List<String> contexts = new ArrayList<>();
  private IWorkerContext worker;
  private boolean original;
  private ValidationOptions options;
  private String name;
  private List<String> notes = new ArrayList<>();
  
  public TerminologyOperationContext(IWorkerContext worker, ValidationOptions options, String name) {
    super();
    this.worker = worker;
    this.original = true;
    this.options = options;
    this.name = name;
    this.startTime = System.currentTimeMillis();
    
    if (EXPANSION_DEAD_TIME_SECS == 0 || debugging) {
      deadTime = 0;
    } else {
      deadTime = System.currentTimeMillis() + (EXPANSION_DEAD_TIME_SECS * 1000);      
    }
  }
  
  private TerminologyOperationContext(ValidationOptions options, String name) {
    super();
    this.options = options;
    this.name = name;
    this.startTime = System.currentTimeMillis();
  }

  public TerminologyOperationContext copy() {
    TerminologyOperationContext ret = new TerminologyOperationContext(this.options, name);
    ret.worker = worker;
    ret.contexts.addAll(contexts);
    ret.deadTime = deadTime;
    ret.notes = notes;
    ret.startTime = startTime;
    ret.nestCount = nestCount + 1;
    return ret;
  }
  
  public void deadCheck(String note) {
    note(note);
    if (deadTime != 0 &&  System.currentTimeMillis() > deadTime) {
     log.error("Operation took too long - longer than "+(deadTime - startTime)+"ms");
     int i = 0;
     for (String s : notes) {
       log.error(s);
       if (i == 100) {
         log.error("more...");
         break; // no point dumping more
       }
     }
     throw new TerminologyServiceProtectionException(worker.formatMessage(I18nConstants.VALUESET_TOO_COSTLY_TIME, contexts.get(0), EXPANSION_DEAD_TIME_SECS, name+" (local)"), TerminologyServiceErrorClass.TOO_COSTLY, IssueType.TOOCOSTLY);
    }
  }
  
  public void seeContext(String context) {
    if (contexts.contains(context)) {
      throw new TerminologyServiceProtectionException(worker.formatMessage(I18nConstants.VALUESET_CIRCULAR_REFERENCE, context, contexts.toString()), TerminologyServiceErrorClass.PROCESSING, IssueType.PROCESSING);
    }
    contexts.add(context);
  }

  public boolean isOriginal() {
    return original;
  }

  public ValidationOptions getOptions() {
    return options;
  }

  public void note(String s) {
    s = Utilities.padLeft("", ' ', nestCount)+" "+(System.currentTimeMillis() - startTime)+" "+s;
    notes.add(s);
  }
}
