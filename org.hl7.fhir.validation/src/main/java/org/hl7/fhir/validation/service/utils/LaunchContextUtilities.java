package org.hl7.fhir.validation.service.utils;

import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;

/**
 * Parses the launch contexts named on the command line.
 *
 * <p>The syntax is {@code name:reference}, where the name is the one the Questionnaire declares in
 * its launchContext, and the reference says where to get the resource:
 * <pre>
 *   patient:patient-example.json
 *   patient:/data/fhir/patient-example.json
 *   user:http://example.org/fhir/Practitioner/1
 * </pre>
 *
 * <p>Only the shape is checked here - that there is a name and a reference to go with it. Whether
 * the reference resolves, and what it resolves to, is settled when the launch context is used.
 *
 * <p>Splitting on the first colon is what makes both a URL and a Windows path work: everything after
 * the first colon is the reference, colons and all.
 */
public class LaunchContextUtilities {

  /**
   * Parse one {@code name:reference} pair and add it to the launch contexts collected so far.
   *
   * @throws FHIRException if it isn't a name and a reference, or if that name is already taken -
   *   a map would quietly keep only one of them, and a launch context that silently went missing
   *   would make every expression that used it wrong without saying so
   */
  public static void addLaunchContext(Map<String, String> launchContexts, String src) {
    if (src == null) {
      throw new FHIRException("Unable to understand the launch context 'null'");
    }
    int i = src.indexOf(":");
    if (i < 1 || i == src.length() - 1) {
      throw new FHIRException("Unable to understand the launch context '" + src + "': it must have the form name:reference, "
          + "e.g. patient:patient-example.json, or user:http://example.org/fhir/Practitioner/1");
    }
    String name = src.substring(0, i);
    if (launchContexts.containsKey(name)) {
      throw new FHIRException("There is more than one launch context named '" + name + "'");
    }
    launchContexts.put(name, src.substring(i + 1));
  }
}
