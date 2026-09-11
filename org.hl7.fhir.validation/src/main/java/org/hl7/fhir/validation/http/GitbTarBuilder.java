package org.hl7.fhir.validation.http;

import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.time.Instant;
import java.util.UUID;

/**
 * Builds GITB Test Assertion Report (TAR) JSON for the validator's validation
 * services (FHIRValidator, MatchetypeValidator, FHIRPathAssertion).
 * <p>
 * Methods here return a TAR {@link JsonObject} ({@code {id, date, result,
 * counters, overview, items[], context[]}}); the base handler wraps it in
 * {@code {report: ...}} per the GITB ValidationResponse shape.
 */
final class GitbTarBuilder {

  static final String VALIDATOR_NAME = "HL7 FHIR Validator";

  private GitbTarBuilder() {}

  /**
   * Build a TAR for a successful FHIR validation run.
   *
   * @param outcome      the FHIR OperationOutcome produced by the engine
   * @param outcomeJson  the OperationOutcome serialised to FHIR+JSON (echoed in {@code context})
   * @param content      the validated payload (when {@code includeContentInReport} is true; null otherwise)
   * @param contentMime  MIME type of {@code content} (defaults to {@code application/fhir+json} when null)
   * @param failOn       severity threshold: {@code error}|{@code warning}|{@code information}
   * @param sessionId    optional Gitb-Test-Session-Identifier; copied to {@code overview.note}
   * @param engineVersion validator version, copied to {@code overview.version}
   */
  static JsonObject buildValidationTar(OperationOutcome outcome,
                                       String outcomeJson,
                                       String content,
                                       String contentMime,
                                       String failOn,
                                       String sessionId,
                                       String engineVersion) {
    int errors = 0;
    int warnings = 0;
    int infos = 0;
    JsonArray items = new JsonArray();

    for (OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      IssueSeverity sev = issue.getSeverity();
      if (sev == IssueSeverity.FATAL || sev == IssueSeverity.ERROR) errors++;
      else if (sev == IssueSeverity.WARNING) warnings++;
      else if (sev == IssueSeverity.INFORMATION) infos++;
      items.add(reportItem(issue));
    }

    String tarResult = deriveResult(errors, warnings, infos, failOn);

    JsonObject report = baseReport(tarResult, sessionId, engineVersion);
    report.add("counters", counters(errors, warnings, infos));
    report.add("items", items);

    // The TAR context is what the ITB stores in test-session state when the caller writes
    // <verify ... output="$ctx">. Anything callers want to post-process — counts, severity,
    // the OperationOutcome — has to be put in here as an AnyContent item. forReport=false
    // hides the item from the rendered report while still making it available to the test.
    JsonArray context = new JsonArray();
    context.add(hiddenContext("errorCount",       String.valueOf(errors),   "text/plain"));
    context.add(hiddenContext("warningCount",     String.valueOf(warnings), "text/plain"));
    context.add(hiddenContext("informationCount", String.valueOf(infos),    "text/plain"));
    context.add(hiddenContext("severity",         severityCode(highestSeverity(outcome)), "text/plain"));
    if (outcomeJson != null) {
      context.add(GitbServiceHandler.anyContent("operationOutcome", outcomeJson, "application/fhir+json"));
    }
    if (content != null) {
      context.add(GitbServiceHandler.anyContent("content", content,
        contentMime != null ? contentMime : "application/fhir+json"));
    }
    report.add("context", context);

    return report;
  }

  /** AnyContent that's available to the test session but suppressed from the rendered report. */
  private static JsonObject hiddenContext(String name, String value, String mimeType) {
    JsonObject ac = GitbServiceHandler.anyContent(name, value, mimeType);
    ac.remove("forReport");
    ac.add("forReport", false);
    return ac;
  }

  private static IssueSeverity highestSeverity(OperationOutcome outcome) {
    IssueSeverity highest = null;
    for (OperationOutcomeIssueComponent issue : outcome.getIssue()) {
      IssueSeverity sev = issue.getSeverity();
      if (sev == null) continue;
      if (highest == null || sev.ordinal() < highest.ordinal()) {
        // Lower ordinal = more severe (FATAL=0, ERROR=1, WARNING=2, INFORMATION=3, NULL=4)
        highest = sev;
      }
    }
    return highest;
  }

  private static String severityCode(IssueSeverity sev) {
    if (sev == null) return "information";
    switch (sev) {
      case FATAL: return "fatal";
      case ERROR: return "error";
      case WARNING: return "warning";
      case INFORMATION: return "information";
      default: return "information";
    }
  }

  /** TAR for a non-FHIR pass/fail check (e.g. FHIRPathAssertion or matchetype mismatch). */
  static JsonObject buildSimpleTar(String result, String description, String level,
                                   JsonArray contextItems, String sessionId, String engineVersion) {
    JsonObject report = baseReport(result, sessionId, engineVersion);
    int errors = "FAILURE".equals(result) && "ERROR".equalsIgnoreCase(level) ? 1 : 0;
    int warnings = "WARNING".equals(result) ? 1 : 0;
    int infos = "SUCCESS".equals(result) ? 1 : 0;
    report.add("counters", counters(errors, warnings, infos));

    JsonArray items = new JsonArray();
    if (description != null) {
      JsonObject item = new JsonObject();
      item.add("level", level != null ? level : ("FAILURE".equals(result) ? "ERROR" : "INFO"));
      item.add("description", description);
      items.add(item);
    }
    report.add("items", items);

    // Always surface counts and result level in the TAR context so test authors can
    // capture them via <verify ... output="$ctx"> and post-process.
    JsonArray context = new JsonArray();
    context.add(hiddenContext("errorCount",       String.valueOf(errors),   "text/plain"));
    context.add(hiddenContext("warningCount",     String.valueOf(warnings), "text/plain"));
    context.add(hiddenContext("informationCount", String.valueOf(infos),    "text/plain"));
    context.add(hiddenContext("result",           result,                   "text/plain"));
    if (contextItems != null) {
      for (org.hl7.fhir.utilities.json.model.JsonElement el : contextItems) {
        context.add(el);
      }
    }
    report.add("context", context);
    return report;
  }

  /** TAR for an engine-level error (parse failure etc.) — UNDEFINED result. */
  static JsonObject buildUndefinedTar(String engineErrorMessage, String sessionId, String engineVersion) {
    JsonObject report = baseReport("UNDEFINED", sessionId, engineVersion);
    report.add("counters", counters(0, 0, 0));

    JsonArray items = new JsonArray();
    JsonObject errItem = new JsonObject();
    errItem.add("level", "ERROR");
    errItem.add("description", engineErrorMessage != null ? engineErrorMessage : "Engine error");
    errItem.add("type", "exception");
    items.add(errItem);
    report.add("items", items);
    report.add("context", new JsonArray());
    return report;
  }

  // ------------------------------------------------------------------
  // Internals
  // ------------------------------------------------------------------

  private static JsonObject baseReport(String result, String sessionId, String engineVersion) {
    JsonObject report = new JsonObject();
    report.add("id", UUID.randomUUID().toString());
    report.add("date", Instant.now().toString());
    report.add("result", result);
    JsonObject overview = new JsonObject();
    overview.add("name", VALIDATOR_NAME);
    if (engineVersion != null) overview.add("version", engineVersion);
    if (sessionId != null && !sessionId.isEmpty()) overview.add("note", "session=" + sessionId);
    report.add("overview", overview);
    return report;
  }

  private static JsonObject counters(int errors, int warnings, int infos) {
    JsonObject c = new JsonObject();
    c.add("nrOfErrors", errors);
    c.add("nrOfWarnings", warnings);
    c.add("nrOfAssertions", infos);
    return c;
  }

  private static JsonObject reportItem(OperationOutcomeIssueComponent issue) {
    JsonObject item = new JsonObject();
    item.add("level", levelFor(issue.getSeverity()));
    String description = issue.getDetails() != null && issue.getDetails().hasText()
      ? issue.getDetails().getText()
      : (issue.hasDiagnostics() ? issue.getDiagnostics() : "");
    item.add("description", description);
    String location = locationFor(issue);
    if (location != null && !location.isEmpty()) item.add("location", location);
    if (issue.hasCode()) item.add("type", issue.getCode().toCode());
    if (issue.hasDiagnostics() && issue.getDiagnostics() != null && !issue.getDiagnostics().isEmpty()) {
      item.add("value", issue.getDiagnostics());
    }
    return item;
  }

  private static String locationFor(OperationOutcomeIssueComponent issue) {
    if (issue.hasExpression()) {
      return joinSemicolon(issue.getExpression().stream().map(s -> s.getValue()).toArray(String[]::new));
    }
    if (issue.hasLocation()) {
      return joinSemicolon(issue.getLocation().stream().map(s -> s.getValue()).toArray(String[]::new));
    }
    return null;
  }

  private static String joinSemicolon(String[] parts) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < parts.length; i++) {
      if (i > 0) sb.append("; ");
      if (parts[i] != null) sb.append(parts[i]);
    }
    return sb.toString();
  }

  private static String levelFor(IssueSeverity severity) {
    if (severity == null) return "INFO";
    switch (severity) {
      case FATAL:
      case ERROR:
        return "ERROR";
      case WARNING:
        return "WARNING";
      case INFORMATION:
      default:
        return "INFO";
    }
  }

  /**
   * Compute the TAR {@code result} from issue counts and the caller's {@code failOn} threshold.
   * Mirrors the table in §3.2 of documentation/itb-rest-spec.md.
   */
  static String deriveResult(int errors, int warnings, int infos, String failOn) {
    String threshold = failOn == null || failOn.isEmpty() ? "error" : failOn.toLowerCase();
    switch (threshold) {
      case "warning":
        if (errors > 0 || warnings > 0) return "FAILURE";
        return "SUCCESS";
      case "information":
        if (errors > 0 || warnings > 0 || infos > 0) return "FAILURE";
        return "SUCCESS";
      case "error":
      default:
        if (errors > 0) return "FAILURE";
        if (warnings > 0) return "WARNING";
        return "SUCCESS";
    }
  }
}
