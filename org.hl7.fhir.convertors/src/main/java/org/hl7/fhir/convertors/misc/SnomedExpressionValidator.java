package org.hl7.fhir.convertors.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient5;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientManager;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.logging.ILoggingService;

/**
 * Follow up to {@link SnomedExpressionFinder}: takes the csv it produces, and for each 
 * entry, asks the terminology ecosystem which server is appropriate for the SNOMED CT 
 * version (if any) the code came with, runs CodeSystem/$validate-code for the expression 
 * against that server, and records the outcome and the display the server generated.
 * 
 * Columns added to the csv: 
 *  - Valid: true / false / error: ...
 *  - Display: the display the server generated, if any
 *  - Interpolated: the expression with |display| after each concept id (any terms already 
 *    in the expression are dropped first) - done whether or not the expression is valid, 
 *    so far as the concept ids can be resolved (an unresolvable id gets |?|)
 *  - Concepts: for expressions that aren't valid, the expression is split (naively) into 
 *    the concept ids it contains, and the display for each of those is listed, to give a 
 *    sense of what the author was trying to say
 *  - Message: what the server said about an expression that isn't valid (including the 
 *    reasons it gives for the expression not being valid)
 *  - VersionNote: if the SNOMED CT version the code came with isn't available on the chosen 
 *    server, the expression is validated against the server's current version of the same 
 *    edition instead, or failing that, the server's default version, and this says so (the 
 *    availability of each version is probed once, with the root concept)
 *  - Server: the server that was used
 * 
 * Results are memoised on version + code so duplicates are only validated once.
 * 
 * Usage: SnomedExpressionValidator [-tx server] [-fhir version] [-in file] [-out file]
 *   -tx: the master terminology server (default https://tx.fhir.org/r4)
 *   -fhir: the FHIR version to talk to the servers with (default 4.0.1). This matters for 
 *     routing: the ecosystem registry only offers servers that support the FHIR version 
 *     asked for, and most of the national servers that carry SNOMED CT editions are R4
 *   -in: input csv (default [tmp]/snomed-expressions.csv)
 *   -out: output csv (default [tmp]/snomed-expressions-processed.csv)
 */
@SuppressWarnings("checkstyle:systemout")
public class SnomedExpressionValidator {

  private static final String SCT = "http://snomed.info/sct";

  public static void main(String[] args) throws Exception {
    String tx = "https://tx.fhir.org/r4";
    String fhirVersion = "4.0.1";
    String in = Utilities.path("[tmp]", "snomed-expressions.csv");
    String out = Utilities.path("[tmp]", "snomed-expressions-processed.csv");
    for (int i = 0; i < args.length - 1; i++) {
      if ("-tx".equals(args[i])) {
        tx = args[i+1];
      } else if ("-fhir".equals(args[i])) {
        fhirVersion = args[i+1];
      } else if ("-in".equals(args[i])) {
        in = args[i+1];
      } else if ("-out".equals(args[i])) {
        out = args[i+1];
      }
    }
    new SnomedExpressionValidator().execute(tx, fhirVersion, in, out);
  }

  private class Outcome {
    private String valid;
    private String display;
    private String server;
    private String concepts;
    private String interpolated;
    private String message;
    private String versionNote;
    private boolean unknownVersion;
    public Outcome(String valid, String display, String server) {
      this.valid = valid;
      this.display = display;
      this.server = server;
    }
  }

  private TerminologyClientManager manager;
  private Map<String, Outcome> seen = new HashMap<>();
  private Map<String, Outcome> concepts = new HashMap<>(); // version|id -> outcome of validating the single concept
  private Map<String, String> serverForVersion = new HashMap<>();
  private Map<String, Boolean> availableVersions = new HashMap<>(); // version or edition URI -> known to the server?
  private Map<String, String> effectiveVersions = new HashMap<>(); // version -> what to actually send (may be null)

  private void execute(String tx, String fhirVersion, String in, String out) throws Exception {
    System.out.println("Master terminology server: "+tx+" (FHIR "+fhirVersion+")");
    ILoggingService logger = new ILoggingService() {
      @Override
      public void logMessage(String message) {
        System.out.println(message);
      }
      @Override
      public void logDebugMessage(LogCategory category, String message) {
      }
    };
    TerminologyClientFactory factory = new TerminologyClientFactory(fhirVersion);
    manager = new TerminologyClientManager(factory, logger);
    ITerminologyClient5 master = factory.makeClientR5("tx-server", tx, "fhir/snomed-expression-validator", null);
    manager.setMasterClient(master, true);

    CSVReader csv = new CSVReader(ManagedFileAccess.inStream(in));
    String[] headers = csv.readHeaders();
    int codeCol = indexOf(headers, "Code");
    int versionCol = indexOf(headers, "Version");
    if (codeCol == -1) {
      throw new FHIRException("No Code column in "+in);
    }

    StringBuilder b = new StringBuilder();
    for (String h : headers) {
      b.append(csvCell(h));
      b.append(",");
    }
    b.append("Valid,Display,Interpolated,Concepts,Message,VersionNote,Server\r\n");

    int rows = 0;
    int validated = 0;
    int valid = 0;
    int invalid = 0;
    int errors = 0;
    while (csv.line()) {
      String[] cells = csv.getCells();
      if (cells.length <= codeCol) {
        continue;
      }
      rows++;
      String code = cells[codeCol];
      String version = versionCol == -1 || cells.length <= versionCol ? null : cells[versionCol];
      if (Utilities.noString(version)) {
        version = null;
      }
      String key = (version == null ? "" : version)+"|"+code;
      Outcome o = seen.get(key);
      if (o == null) {
        o = validateExpression(code, version);
        seen.put(key, o);
        validated++;
        if ("true".equals(o.valid)) {
          valid++;
        } else if ("false".equals(o.valid)) {
          invalid++;
        } else {
          errors++;
        }
        System.out.println(validated+": "+code+(version == null ? "" : " ["+version+"]")+" @ "+o.server+" -> "+o.valid+(o.display == null ? "" : " / "+o.display)+(o.concepts == null ? "" : " {"+o.concepts+"}")+(o.versionNote == null ? "" : " ("+o.versionNote+")"));
      }
      for (int i = 0; i < headers.length; i++) {
        b.append(csvCell(i < cells.length ? cells[i] : null));
        b.append(",");
      }
      b.append(csvCell(o.valid));
      b.append(",");
      b.append(csvCell(o.display));
      b.append(",");
      b.append(csvCell(o.interpolated));
      b.append(",");
      b.append(csvCell(o.concepts));
      b.append(",");
      b.append(csvCell(o.message));
      b.append(",");
      b.append(csvCell(o.versionNote));
      b.append(",");
      b.append(csvCell(o.server));
      b.append("\r\n");
    }
    csv.close();
    FileUtilities.stringToFile(b.toString(), out);
    System.out.println("=====================");
    System.out.println(rows+" rows, "+validated+" distinct expressions validated: "+valid+" valid, "+invalid+" invalid, "+errors+" errors");
    System.out.println("Output written to "+out);
    manager.shutdown();
  }

  private static final String ROOT_CONCEPT = "138875005";

  /**
   * Validate an expression, falling back to the server's default version if the version 
   * the expression came with isn't available, and describing the concepts in it if it 
   * isn't valid
   */
  private Outcome validateExpression(String code, String version) {
    String effectiveVersion = effectiveVersion(version);
    Outcome o = validate(code, effectiveVersion);
    if (version != null && !version.equals(effectiveVersion)) {
      if (effectiveVersion == null) {
        o.versionNote = "version "+version+" not available on server (nor the edition); validated against the server's default version";
      } else {
        o.versionNote = "version "+version+" not available on server; validated against the server's current version of the edition ("+effectiveVersion+")";
      }
    }
    o.interpolated = interpolate(code, effectiveVersion);
    if (!"true".equals(o.valid)) {
      o.concepts = describeConcepts(code, effectiveVersion);
    }
    return o;
  }

  /**
   * Rewrite the expression with |display| after each concept id. Any terms already in the 
   * expression are dropped first, so the output is consistent. Ids that can't be resolved 
   * get |?|
   */
  private String interpolate(String code, String version) {
    String src = stripTerms(code);
    StringBuilder res = new StringBuilder();
    StringBuilder b = new StringBuilder();
    for (char ch : (src + "\u0000").toCharArray()) {
      if (Character.isDigit(ch)) {
        b.append(ch);
      } else {
        if (b.length() > 0) {
          res.append(b);
          if (b.length() >= 6 && b.length() <= 18) {
            Outcome o = lookupConcept(b.toString(), version);
            res.append("|");
            res.append("true".equals(o.valid) && o.display != null ? o.display : "?");
            res.append("|");
          }
          b.setLength(0);
        }
        if (ch != '\u0000') {
          res.append(ch);
        }
      }
    }
    return res.toString();
  }

  /** remove |term| sections (and any whitespace immediately before them) */
  private String stripTerms(String code) {
    StringBuilder res = new StringBuilder();
    boolean inTerm = false;
    for (char ch : code.toCharArray()) {
      if (ch == '|') {
        if (!inTerm) {
          // drop the whitespace between the id and the term
          while (res.length() > 0 && Character.isWhitespace(res.charAt(res.length() - 1))) {
            res.setLength(res.length() - 1);
          }
        }
        inTerm = !inTerm;
      } else if (!inTerm) {
        res.append(ch);
      }
    }
    return res.toString();
  }

  /**
   * @return the version to send to the server: the version given; or if that isn't available,
   *   the edition it belongs to (so the server uses its current version of the edition); or 
   *   null if neither is available (so the server uses its default). Each version is checked 
   *   once, using the root concept 
   */
  private String effectiveVersion(String version) {
    if (version == null) {
      return null;
    }
    if (!effectiveVersions.containsKey(version)) {
      String ev = null;
      if (isAvailable(version)) {
        ev = version;
      } else {
        String edition = editionOf(version);
        if (edition != null && isAvailable(edition)) {
          System.out.println("  using the edition "+edition+" instead");
          ev = edition;
        } else {
          System.out.println("  using the server's default version instead");
        }
      }
      effectiveVersions.put(version, ev);
    }
    return effectiveVersions.get(version);
  }

  private boolean isAvailable(String version) {
    if (!availableVersions.containsKey(version)) {
      Outcome probe = validate(ROOT_CONCEPT, version);
      if (probe.unknownVersion) {
        System.out.println("Version "+version+" is not available: "+probe.message);
      }
      availableVersions.put(version, !probe.unknownVersion);
    }
    return availableVersions.get(version);
  }

  /** http://snomed.info/sct/11000274103/version/20240515 -> http://snomed.info/sct/11000274103 */
  private String editionOf(String version) {
    int i = version.indexOf("/version/");
    return i > 0 ? version.substring(0, i) : null;
  }

  private Outcome validate(String code, String version) {
    String systemRef = version == null ? SCT : SCT+"|"+version;
    TerminologyClientContext server;
    try {
      server = chooseServer(systemRef);
    } catch (Exception e) {
      return new Outcome("error: no server: "+e.getMessage(), null, null);
    }
    if (server == null) {
      return new Outcome("error: no server", null, null);
    }
    Parameters pin = new Parameters();
    pin.addParameter("url", SCT);
    if (version != null) {
      pin.addParameter("version", version);
    }
    pin.addParameter("code", code);
    try {
      Parameters pout = server.getClient().validateCS(pin);
      String result = null;
      String display = null;
      String message = null;
      boolean unknownVersion = false;
      List<String> reasons = new ArrayList<>();
      for (ParametersParameterComponent p : pout.getParameter()) {
        if ("result".equals(p.getName()) && p.hasValue()) {
          result = p.getValue().primitiveValue();
        } else if ("display".equals(p.getName()) && p.hasValue()) {
          display = p.getValue().primitiveValue();
        } else if ("message".equals(p.getName()) && p.hasValue()) {
          message = p.getValue().primitiveValue();
        } else if ("issues".equals(p.getName()) && p.hasResource() && p.getResource() instanceof OperationOutcome) {
          for (OperationOutcomeIssueComponent issue : ((OperationOutcome) p.getResource()).getIssue()) {
            if ("UNKNOWN_CODESYSTEM_VERSION".equals(issue.getExtensionString(ExtensionDefinitions.EXT_ISSUE_MSG_ID))) {
              unknownVersion = true;
            }
            String text = issue.getDetails().getText();
            if (text != null && !text.equals(message) && !reasons.contains(text)) {
              reasons.add(text);
            }
          }
        }
      }
      Outcome o;
      if (result == null) {
        o = new Outcome("error: no result"+(message == null ? "" : ": "+message), display, server.getAddress());
      } else {
        o = new Outcome(result, display, server.getAddress());
      }
      o.unknownVersion = unknownVersion;
      if (!"true".equals(result)) {
        StringBuilder m = new StringBuilder();
        if (message != null) {
          m.append(message);
        }
        for (String r : reasons) {
          if (m.length() > 0) {
            m.append(" | ");
          }
          m.append(r);
        }
        o.message = m.length() == 0 ? null : m.toString();
      }
      return o;
    } catch (Exception e) {
      return new Outcome("error: "+e.getMessage(), null, server.getAddress());
    }
  }

  /**
   * Nothing sophisticated: pull out every run of digits that could be a concept id 
   * (SCTIDs are 6 - 18 digits), and look each one up once
   */
  private String describeConcepts(String code, String version) {
    List<String> ids = new ArrayList<>();
    StringBuilder b = new StringBuilder();
    for (char ch : (code + " ").toCharArray()) {
      if (Character.isDigit(ch)) {
        b.append(ch);
      } else {
        if (b.length() >= 6 && b.length() <= 18 && !ids.contains(b.toString())) {
          ids.add(b.toString());
        }
        b.setLength(0);
      }
    }
    if (ids.isEmpty()) {
      return null;
    }
    StringBuilder res = new StringBuilder();
    for (String id : ids) {
      if (res.length() > 0) {
        res.append("; ");
      }
      res.append(id);
      res.append(": ");
      res.append(lookupDisplay(id, version));
    }
    return res.toString();
  }

  private String lookupDisplay(String id, String version) {
    Outcome o = lookupConcept(id, version);
    if ("true".equals(o.valid)) {
      return o.display == null ? "(no display)" : o.display;
    } else if ("false".equals(o.valid)) {
      return "(not a valid concept)";
    } else {
      return "("+o.valid+")";
    }
  }

  private Outcome lookupConcept(String id, String version) {
    String key = (version == null ? "" : version)+"|"+id;
    Outcome o = concepts.get(key);
    if (o == null) {
      o = validate(id, version);
      concepts.put(key, o);
    }
    return o;
  }

  private TerminologyClientContext chooseServer(String systemRef) {
    // the manager caches the routing decision itself, but we remember the address 
    // as well so the log is informative
    Set<String> systems = new HashSet<>();
    systems.add(systemRef);
    TerminologyClientContext ctxt = manager.chooseServer(null, systems, false);
    if (ctxt != null && !serverForVersion.containsKey(systemRef)) {
      serverForVersion.put(systemRef, ctxt.getAddress());
      System.out.println("Server for "+systemRef+": "+ctxt.getAddress());
    }
    return ctxt;
  }

  private static int indexOf(String[] headers, String name) {
    for (int i = 0; i < headers.length; i++) {
      if (name.equals(headers[i].trim())) {
        return i;
      }
    }
    return -1;
  }

  private static String csvCell(String s) {
    if (s == null) {
      return "";
    }
    if (s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r")) {
      return "\""+s.replace("\"", "\"\"")+"\"";
    }
    return s;
  }
}
