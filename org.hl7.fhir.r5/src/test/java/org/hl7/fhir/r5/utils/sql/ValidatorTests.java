package org.hl7.fhir.r5.utils.sql;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.sql.Validator.TrueFalseOrUnknown;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Unit tests for {@link Validator} focused on collection-status handling
 * under {@code forEach} and {@code forEachOrNull}.
 *
 * @author John Grimes
 */
class ValidatorTests {

  private static IWorkerContext context;

  @BeforeAll
  static void setUp() throws Exception {
    context = TestingUtilities.getSharedWorkerContext();
  }

  private Validator newValidator() {
    FHIRPathEngine fpe = new FHIRPathEngine(context);
    fpe.setEmitSQLonFHIRWarning(true);
    return new Validator(context, fpe, new ArrayList<>(),
        TrueFalseOrUnknown.UNKNOWN, TrueFalseOrUnknown.UNKNOWN, TrueFalseOrUnknown.UNKNOWN);
  }

  private void assertNoIssueContains(Validator v, String substring) {
    for (ValidationMessage m : v.getIssues()) {
      assertFalse(m.getMessage() != null && m.getMessage().contains(substring),
          "Expected no issue containing '" + substring + "' but found: " + m.getMessage());
    }
  }

  private void assertIssueContains(Validator v, String substring) {
    boolean found = false;
    for (ValidationMessage m : v.getIssues()) {
      if (m.getMessage() != null && m.getMessage().contains(substring)) {
        found = true;
        break;
      }
    }
    assertTrue(found, "Expected an issue containing '" + substring + "' but found none. All issues: "
        + v.getIssues());
  }

  // A 0..1 column under forEach over a 0..* collection must not warn that the column
  // path "might return multiple values" - each iteration sees a single element.
  @Test
  void forEachWithSingletonColumnDoesNotWarn() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t1\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"address\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"use\",  \"path\": \"use\",  \"type\": \"code\" },\n"
        + "      { \"name\": \"city\", \"path\": \"city\", \"type\": \"string\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertNoIssueContains(v, "might return multiple values");
  }

  // Same as above but with forEachOrNull.
  @Test
  void forEachOrNullWithSingletonColumnDoesNotWarn() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t2\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEachOrNull\": \"address\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"use\", \"path\": \"use\", \"type\": \"code\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertNoIssueContains(v, "might return multiple values");
  }

  // A nested select underneath a forEach should also see a singleton starting type.
  @Test
  void nestedSelectUnderForEachDoesNotWarn() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t3\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"address\",\n"
        + "    \"select\": [{\n"
        + "      \"column\": [\n"
        + "        { \"name\": \"use\", \"path\": \"use\", \"type\": \"code\" }\n"
        + "      ]\n"
        + "    }]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertNoIssueContains(v, "might return multiple values");
  }

  // A genuinely collection-valued column path (line is 0..* on Address) must still warn
  // when not marked collection: true. Regression guard.
  @Test
  void collectionColumnPathUnderForEachStillWarnsWhenNotMarked() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t4\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"address\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"line\", \"path\": \"line\", \"type\": \"string\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertIssueContains(v, "might return multiple values");
  }

  // Same as above but with collection: true - no warning should fire.
  @Test
  void collectionColumnPathUnderForEachIsQuietWhenMarked() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t5\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"address\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"line\", \"path\": \"line\", \"type\": \"string\", \"collection\": true }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertNoIssueContains(v, "might return multiple values");
    assertNoIssueContains(v, "collection-is-true-but-path-is-singleton");
  }

  // A top-level multi-valued column path (no forEach) must still warn.
  @Test
  void topLevelMultiValuedColumnStillWarns() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t6\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"g\", \"path\": \"name.given\", \"type\": \"string\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertIssueContains(v, "might return multiple values");
  }

  // A column path expression that is a union literal returns a collection regardless of
  // the starting type. The warning must still fire - proves the downgrade only changes
  // the starting type, not the column-path's own returned collection status.
  @Test
  void columnPathUnionLiteralUnderForEachStillWarns() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t7\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"name.given\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"u\", \"path\": \"1 | 2 | 3\", \"type\": \"integer\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertIssueContains(v, "might return multiple values");
  }
}
