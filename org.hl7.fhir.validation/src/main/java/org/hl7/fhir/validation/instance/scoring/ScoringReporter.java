package org.hl7.fhir.validation.instance.scoring;

import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Generates HTML reports from FHIR resource element scoring data
 */
public class ScoringReporter {

  private static final String TEMPLATE_PLACEHOLDER_TITLE = "[%title%]";
  private static final String TEMPLATE_PLACEHOLDER_CONTENT = "[%content%]";

  private final DecimalFormat scoreFormat = new DecimalFormat("#0.0");
  private final DecimalFormat percentFormat = new DecimalFormat("#0.0%");

  /**
   * Generate a complete HTML report from scoring data for a single FHIR resource
   *
   * @param rootElement The root scored element (typically the resource itself)
   * @param template HTML template string
   * @param reportTitle Title for the report
   * @return Complete HTML report
   */
  public String generateReport(ScoredElement rootElement, String template, String reportTitle) {
    if (template == null || template.isEmpty()) {
      throw new IllegalArgumentException("Template cannot be null or empty");
    }

    String content = generateReportContent(rootElement);

    return template
      .replace(TEMPLATE_PLACEHOLDER_TITLE, reportTitle != null ? reportTitle : "FHIR Resource Quality Scoring Report")
      .replace(TEMPLATE_PLACEHOLDER_CONTENT, content);
  }

  /**
   * Generate just the content portion of the report (without HTML template wrapper)
   *
   * @param rootElement The root scored element
   * @return HTML content string
   */
  public String generateReportContent(ScoredElement rootElement) {
    if (rootElement == null) {
      return generateEmptyReport();
    }

    StringBuilder html = new StringBuilder();

    // Report header with overall resource summary
    html.append(generateReportHeader(rootElement));

    // Concise summary table
    html.append(generateSummarySection(rootElement));

    // Two hierarchical breakdowns - filtered and complete
    html.append(generateHierarchicalSection(rootElement));

    return html.toString();
  }

  private String generateEmptyReport() {
    return """
            <div class="alert alert-warning">
                <h4>No Scoring Data Available</h4>
                <p>No FHIR resource scoring data was found to generate a report.</p>
            </div>
            """;
  }

  private String generateReportHeader(ScoredElement rootElement) {
    LocalDateTime now = LocalDateTime.now();
    String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    ElementStats stats = calculateElementStats(rootElement);
    double overallQuality = rootElement.getPossibleScore() > 0 ?
      rootElement.getScore() / rootElement.getPossibleScore() : 0.0;

    return String.format("""
            <div class="row mb-4">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="mb-0">FHIR Resource Quality Scoring Report</h3>
                            <small class="text-muted">Generated on %s</small>
                        </div>
                        <div class="card-body">
                            <div class="row mb-3">
                                <div class="col-12">
                                    <h5>Resource: <span class="text-primary">%s</span> <small class="text-muted">(%s)</small></h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="text-center">
                                        <h4 class="text-info">%d</h4>
                                        <small>Total Elements</small>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="text-center">
                                        <h4 class="text-success">%s</h4>
                                        <small>Total Score</small>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="text-center">
                                        <h4 class="text-secondary">%s</h4>
                                        <small>Possible Score</small>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="text-center">
                                        <h4 class="%s">%s</h4>
                                        <small>Overall Quality</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            """,
      timestamp,
      rootElement.getName(),
      rootElement.getFhirType(),
      stats.totalElements,
      scoreFormat.format(rootElement.getScore()),
      scoreFormat.format(rootElement.getPossibleScore()),
      getQualityColorClass(overallQuality),
      percentFormat.format(overallQuality)
    );
  }

  private String generateSummarySection(ScoredElement rootElement) {
    ElementStats stats = calculateElementStats(rootElement);
    double overallQuality = rootElement.getPossibleScore() > 0 ?
      rootElement.getScore() / rootElement.getPossibleScore() : 0.0;

    return String.format("""
            <div class="row mb-4">
                <div class="col-12">
                    <h4>Scoring Summary</h4>
                    <div class="table-responsive">
                        <table class="table table-sm">
                            <tr>
                                <td><strong>Overall Quality</strong></td>
                                <td class="text-end"><span class="badge %s">%s</span></td>
                            </tr>
                            <tr>
                                <td>Total Score</td>
                                <td class="text-end">%s / %s</td>
                            </tr>
                            <tr>
                                <td>Elements Evaluated</td>
                                <td class="text-end">%d total</td>
                            </tr>
                            <tr>
                                <td>Perfect Scores</td>
                                <td class="text-end"><span class="text-success">%d elements</span></td>
                            </tr>
                            <tr>
                                <td>Partial Scores</td>
                                <td class="text-end"><span class="text-warning">%d elements</span></td>
                            </tr>
                            <tr>
                                <td>Zero Scores</td>
                                <td class="text-end"><span class="text-danger">%d elements</span></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            """,
      getQualityBadgeClass(overallQuality),
      percentFormat.format(overallQuality),
      scoreFormat.format(rootElement.getScore()),
      scoreFormat.format(rootElement.getPossibleScore()),
      stats.totalElements,
      stats.perfectElements,
      stats.partialElements,
      stats.zeroElements
    );
  }

  private String generateHierarchicalSection(ScoredElement rootElement) {
    StringBuilder html = new StringBuilder();

    // First breakdown - filtered (only scored elements and parents of scored elements)
    html.append("""
            <div class="row mb-4">
                <div class="col-12">
                    <h4>Scored Elements Breakdown</h4>
                    <p class="text-muted">Elements with scores or containing scored child elements</p>
                    <div class="card">
                        <div class="card-body p-0">
            """);

    html.append(generateElementTree(rootElement, 0, true)); // filtered = true

    html.append("""
                        </div>
                    </div>
                </div>
            </div>
            """);

    // Second breakdown - complete structure
    html.append("""
            <div class="row">
                <div class="col-12">
                    <h4>Complete Element Structure</h4>
                    <p class="text-muted">All elements in the resource hierarchy</p>
                    <div class="card">
                        <div class="card-body p-0">
            """);

    html.append(generateElementTree(rootElement, 0, false)); // filtered = false

    html.append("""
                        </div>
                    </div>
                </div>
            </div>
            """);

    return html.toString();
  }

  private String generateElementTree(ScoredElement element, int level, boolean filtered) {
    StringBuilder html = new StringBuilder();

    // If filtering, skip elements with no score and no scored children
    if (filtered && !hasScoreOrScoredChildren(element)) {
      return "";
    }

    double quality = element.getPossibleScore() > 0 ?
      element.getScore() / element.getPossibleScore() : 0.0;

    // Generate indentation for hierarchy
    String indent = "&nbsp;".repeat(level * 4);
    String levelIndicator = generateLevelIndicator(level);

    // Build rules information inline
    String rulesInfo = "";
    if (element.getRules() != null && !element.getRules().isEmpty()) {
      StringBuilder rules = new StringBuilder();
      rules.append(" <small class=\"text-info\">[");

      for (int i = 0; i < element.getRules().size(); i++) {
        if (i > 0) rules.append(", ");
        Extension rule = element.getRules().get(i);

        // Extract points from the rule
        String points = extractPointsFromRule(rule);
        String ruleCode = extractRuleCodeFromRule(rule);
        String condition = extractConditionFromRule(rule);

        rules.append(points).append("pts for ").append(ruleCode);
        if (condition != null && !condition.isEmpty()) {
          rules.append(" (condition: ").append(condition).append(")");
        }
      }
      rules.append("]</small>");
      rulesInfo = rules.toString();
    }

    // Build reasons information inline
    String reasonsInfo = "";
    if (element.getReasons() != null && !element.getReasons().isEmpty()) {
      StringBuilder reasons = new StringBuilder();
      reasons.append(" <small class=\"text-muted\">[");
      for (int i = 0; i < element.getReasons().size(); i++) {
        if (i > 0) reasons.append("; ");
        reasons.append(escapeHtml(element.getReasons().get(i)));
      }
      reasons.append("]</small>");
      reasonsInfo = reasons.toString();
    }

    html.append(String.format("""
            <div class="p-2 border-bottom" style="font-family: monospace;">
                %s%s <strong>%s</strong> <span class="text-muted">(%s)</span> 
                <span class="text-end float-end">
                    <span class="text-muted">%s / %s</span> 
                    <span class="badge %s ms-2">%s</span>
                </span>%s%s
            </div>
            """,
      indent,
      levelIndicator,
      escapeHtml(element.getName()),
      escapeHtml(element.getFhirType()),
      scoreFormat.format(element.getScore()),
      scoreFormat.format(element.getPossibleScore()),
      getQualityBadgeClass(quality),
      percentFormat.format(quality),
      rulesInfo,
      reasonsInfo
    ));

    // Recursively add children
    if (element.getChildren() != null && !element.getChildren().isEmpty()) {
      for (ScoredElement child : element.getChildren()) {
        html.append(generateElementTree(child, level + 1, filtered));
      }
    }

    return html.toString();
  }

  private String generateLevelIndicator(int level) {
    if (level == 0) {
      return "📋"; // Resource root
    } else {
      return "├─"; // Single tree branch for all levels
    }
  }

  private boolean hasScoreOrScoredChildren(ScoredElement element) {
    // Element has a score if it has non-zero possible score
    if (element.getPossibleScore() > 0) {
      return true;
    }

    // Check if any children have scores
    if (element.getChildren() != null) {
      for (ScoredElement child : element.getChildren()) {
        if (hasScoreOrScoredChildren(child)) {
          return true;
        }
      }
    }

    return false;
  }

  private String extractPointsFromRule(Extension rule) {
    // Extract the points value from the extension
    // You may need to adjust this based on your Extension structure
    if (rule.hasValue() && rule.getValue().primitiveValue() != null) {
      return rule.getValue().primitiveValue();
    }
    return "0";
  }

  private String extractRuleCodeFromRule(Extension rule) {
      List<String> codes = new ArrayList<>();
      for (Extension se : rule.getExtensionsByUrl("rule")) {
        codes.add(se.getValue().primitiveValue());
      }
      if (codes.isEmpty()) {
        return "{existing}";
      }
      Collections.sort(codes);
      return CommaSeparatedStringBuilder.join(",", codes);

  }

  private String extractConditionFromRule(Extension rule) {
    // Extract condition from extension if present
    // This is a placeholder - you may need to look for specific sub-extensions
    if (rule.hasExtension("condition")) {
      return rule.getExtensionString("condition");
    }
    return null;
  }

  private ElementStats calculateElementStats(ScoredElement rootElement) {
    ElementStats stats = new ElementStats();
    calculateStatsRecursively(rootElement, stats);
    return stats;
  }

  private void calculateStatsRecursively(ScoredElement element, ElementStats stats) {
    stats.totalElements++;

    if (element.getPossibleScore() > 0) {
      double quality = element.getScore() / element.getPossibleScore();
      if (quality >= 1.0) {
        stats.perfectElements++;
      } else if (quality > 0.0) {
        stats.partialElements++;
      } else {
        stats.zeroElements++;
      }
    } else {
      stats.zeroElements++;
    }

    if (element.getChildren() != null) {
      for (ScoredElement child : element.getChildren()) {
        calculateStatsRecursively(child, stats);
      }
    }
  }

  private String getQualityColorClass(double qualityPercentage) {
    if (qualityPercentage >= 0.9) return "text-success";
    if (qualityPercentage >= 0.7) return "text-warning";
    return "text-danger";
  }

  private String getQualityBadgeClass(double qualityPercentage) {
    if (qualityPercentage >= 0.9) return "bg-success";
    if (qualityPercentage >= 0.7) return "bg-warning";
    return "bg-danger";
  }

  private String escapeHtml(String text) {
    if (text == null) return "";
    return text.replace("&", "&amp;")
      .replace("<", "&lt;")
      .replace(">", "&gt;")
      .replace("\"", "&quot;")
      .replace("'", "&#x27;");
  }

  private static class ElementStats {
    int totalElements = 0;
    int perfectElements = 0;
    int partialElements = 0;
    int zeroElements = 0;
  }
}