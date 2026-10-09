package org.hl7.fhir.validation.special;

import java.io.IOException;

import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;

/**
 * Puts a resource into the form the terminology test runner ({@link TxTester}) compares
 * against: server-specific detail scrubbed (narrative, meta, {@code diagnostics}), then every
 * array whose order carries no meaning sorted - parameters and their parts, expansion
 * contents, designations, properties, issues, capability statements.
 * <p>
 * The runner needs it because the expected files of the HL7 terminology test set are stored
 * in this form. But the rules are not specific to those tests: any comparison of a server
 * response against an expected document that should not fail on array order, or on server
 * detail, can apply them to the response first - the response only, never the expected
 * document, which is used as it is.
 * <p>
 * This is exactly what the runner does per resource type, kept in one place so that the
 * runner and other callers, such as the ITB matchetype service, cannot drift apart. An
 * OperationOutcome is scrubbed but not sorted on its own, as in the runner; the issues of an
 * OperationOutcome carried inside a Parameters are sorted along with the Parameters. Any
 * other resource type is left untouched.
 */
public class TxTesterNormalizer {

  /**
   * Scrub and sort {@code r} in place.
   *
   * @param tight the runner's "tight" mode, which scrubs more aggressively; false for the
   *              standard comparison
   */
  public static void normalize(Resource r, boolean tight) {
    if (r instanceof Parameters) {
      TxTesterScrubbers.scrubParameters((Parameters) r, tight);
      TxTesterSorters.sortParameters((Parameters) r);
    } else if (r instanceof ValueSet) {
      TxTesterScrubbers.scrubValueSet((ValueSet) r, tight);
      TxTesterSorters.sortValueSet((ValueSet) r);
    } else if (r instanceof OperationOutcome) {
      TxTesterScrubbers.scrubOperationOutcome((OperationOutcome) r, tight);
    } else if (r instanceof CapabilityStatement) {
      TxTesterScrubbers.scrubCapStmt((CapabilityStatement) r, tight);
      TxTesterSorters.sortCapStmt((CapabilityStatement) r);
    } else if (r instanceof TerminologyCapabilities) {
      TxTesterScrubbers.scrubTermCaps((TerminologyCapabilities) r, tight);
      TxTesterSorters.sortTermCaps((TerminologyCapabilities) r);
    }
  }

  /**
   * The same on a JSON resource: parse, normalize, and serialise again.
   */
  public static byte[] normalizeJson(byte[] json, boolean tight) throws IOException {
    JsonParser parser = new JsonParser();
    Resource r = parser.parse(json);
    normalize(r, tight);
    return parser.composeBytes(r);
  }
}
