package org.hl7.fhir.validation.special;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.json.model.JsonObject;

/**
 * The expected response(s) of a tx-ecosystem test case.
 *
 * A test's http-code says which status code(s) the server may return - 2xx if it doesn't say.
 * Each is an exact code (422) or a class of codes (4xx). It can offer the server a choice,
 * separated by '|': "200|4xx" means the server may either return the resource, or fail with an
 * OperationOutcome. Each choice may have its own expected response, response:{choice} (e.g.
 * response:200 and response:4xx); a choice that doesn't have one uses response.
 *
 * Mode-specific alternatives work as they always have: response:{choice}:{mode} is used ahead of
 * response:{choice}, and response:{mode} ahead of response, when the runner is in that mode.
 *
 * Which choice applies is decided by what the server did: TxTester picks the first choice that
 * matches the http code the server returned (choiceForCode). The internal terminology server
 * (TerminologyServiceTests) has no http layer, so it picks by whether it succeeded or failed
 * (choiceForOutcome).
 */
public class TxTestResponses {

  private final JsonObject test;
  private final Set<String> modes;
  private final String httpCode;
  private final List<String> choices = new ArrayList<>();

  public TxTestResponses(JsonObject test, Set<String> modes) {
    this.test = test;
    this.modes = modes;
    this.httpCode = test.has("http-code") ? test.asString("http-code") : "2xx";
    for (String c : httpCode.split("\\|")) {
      String code = c.trim();
      if (!isHttpCodeChoice(code)) {
        throw new FHIRException("Test "+test.asString("name")+": invalid http-code '"+httpCode+"'");
      }
      choices.add(code);
    }
    for (String choice : choices) {
      if (fileFor(choice) == null) {
        throw new FHIRException("Test "+test.asString("name")+": no response for http-code '"+choice+"' (needs response:"+choice+" or response)");
      }
    }
  }

  /** the expected http code(s), as the test gives them */
  public String getHttpCode() {
    return httpCode;
  }

  public List<String> getChoices() {
    return Collections.unmodifiableList(choices);
  }

  /** true if the test gives the server a choice of http codes */
  public boolean isChoice() {
    return choices.size() > 1;
  }

  /** The response file for a choice: response:{choice} if the test has one, else response */
  public String fileFor(String choice) {
    String fn = chooseParam(test, "response:"+choice, modes);
    return fn != null ? fn : chooseParam(test, "response", modes);
  }

  /** every response file the test might be compared with */
  public List<String> files() {
    List<String> res = new ArrayList<>();
    for (String choice : choices) {
      String fn = fileFor(choice);
      if (!res.contains(fn)) {
        res.add(fn);
      }
    }
    return res;
  }

  /** the first choice the http code matches, or null if it matches none */
  public String choiceForCode(int code) {
    for (String c : choices) {
      if (httpCodeOk(c, code)) {
        return c;
      }
    }
    return null;
  }

  /**
   * For a server with no http layer: the first choice that is a success (2xx), or, if the server
   * failed, the first that is an error (4xx or 5xx). null if the test doesn't allow that outcome.
   */
  public String choiceForOutcome(boolean error) {
    for (String c : choices) {
      char ch = c.charAt(0);
      if (error ? (ch == '4' || ch == '5') : ch == '2') {
        return c;
      }
    }
    return null;
  }

  /** a single http-code choice: an exact code (e.g. 200, 422), or a class of codes (2xx, 4xx) */
  public static boolean isHttpCodeChoice(String tcode) {
    return tcode.matches("[1-5][0-9][0-9]|[1-5]xx");
  }

  public static boolean httpCodeOk(String tcode, int code) {
    if (!isHttpCodeChoice(tcode)) {
      throw new FHIRException("unknown code string "+tcode);
    }
    if (tcode.endsWith("xx")) {
      return code / 100 == tcode.charAt(0) - '0';
    } else {
      return code == Integer.parseInt(tcode);
    }
  }

  /** name:{mode} for the first of the modes the test has one for, else name */
  public static String chooseParam(JsonObject test, String name, Set<String> modes) {
    for (String mode : modes) {
      if (test.has(name+":"+mode)) {
        return test.asString(name+":"+mode);
      }
    }
    return test.asString(name);
  }
}
