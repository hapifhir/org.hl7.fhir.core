package org.hl7.fhir.validation;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */

/*
Copyright (c) 2011+, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to
   endorse or promote products derived from this software without specific
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.

*/

import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine.VersionSourceInformation;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ComparisonService;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.utils.Common;
import org.hl7.fhir.validation.cli.utils.Display;
import org.hl7.fhir.validation.cli.utils.EngineMode;
import org.hl7.fhir.validation.cli.utils.Params;

import java.io.File;

/**
 * A executable class that will validate one or more FHIR resources against
 * the specification
 * <p>
 * todo: schema validation (w3c xml, json schema, shex?)
 * <p>
 * if you want to host validation inside a process, skip this class, and look at
 * ValidationEngine
 * <p>
 * todo: find a home for this:
 *
 * @author Grahame
 */
public class Validator {

  public static final String HTTP_PROXY_HOST = "http.proxyHost";
  public static final String HTTP_PROXY_PORT = "http.proxyPort";

  public static void main(String[] args) throws Exception {
    TimeTracker tt = new TimeTracker();
    TimeTracker.Session tts = tt.start("Loading");

    Display.displayVersion();
    Display.displaySystemInfo();

    if (Params.hasParam(args, Params.PROXY)) {
      String[] p = Params.getParam(args, Params.PROXY).split("\\:");
      System.setProperty(HTTP_PROXY_HOST, p[0]);
      System.setProperty(HTTP_PROXY_PORT, p[1]);
    }

    CliContext cliContext = Params.loadCliContext(args);

    if (Params.hasParam(args, Params.TEST)) {
      Common.runValidationEngineTests();
    } else if (shouldDisplayHelpToUser(args)) {
      Display.displayHelpDetails();
    } else if (Params.hasParam(args, Params.COMPARE)) {
      if (destinationDirectoryValid(Params.getParam(args, Params.DESTINATION))) {
        doLeftRightComparison(args, cliContext, tt);
      }
    } else {
      Display.printCliArgumentsAndInfo(args);
      doValidation(tt, tts, cliContext);
    }
  }

  private static boolean destinationDirectoryValid(String dest) {
    if (dest == null) {
      System.out.println("no -dest parameter provided");
      return false;
    } else if (!new File(dest).isDirectory()) {
      System.out.println("Specified destination (-dest parameter) is not valid: \"" + dest + "\")");
      return false;
    } else {
      System.out.println("Valid destination directory provided: \"" + dest + "\")");
      return true;
    }
  }

  private static boolean shouldDisplayHelpToUser(String[] args) {
    return (args.length == 0
      || Params.hasParam(args, Params.HELP)
      || Params.hasParam(args, "?")
      || Params.hasParam(args, "-?")
      || Params.hasParam(args, "/?"));
  }

  private static void doLeftRightComparison(String[] args, CliContext cliContext, TimeTracker tt) throws Exception {
    Display.printCliArgumentsAndInfo(args);
    if (cliContext.getSv() == null) {
      cliContext.setSv(determineVersion(cliContext));
    }
    String v = VersionUtilities.getCurrentVersion(cliContext.getSv());
    String definitions = VersionUtilities.packageForVersion(v) + "#" + v;
    ValidationEngine validator = ValidationService.getValidator(cliContext, definitions, tt);
    ComparisonService.doLeftRightComparison(args, Params.getParam(args, Params.DESTINATION), validator);
  }

  private static void doValidation(TimeTracker tt, TimeTracker.Session tts, CliContext cliContext) throws Exception {
    if (cliContext.getSv() == null) {
      cliContext.setSv(determineVersion(cliContext));
    }
    System.out.println("Loading");
    // Comment this out because definitions filename doesn't necessarily contain version (and many not even be 14 characters long).
    // Version gets spit out a couple of lines later after we've loaded the context
    String definitions = VersionUtilities.packageForVersion(cliContext.getSv()) + "#" + VersionUtilities.getCurrentVersion(cliContext.getSv());
    ValidationEngine validator = ValidationService.getValidator(cliContext, definitions, tt);
    tts.end();
    switch (cliContext.getMode()) {
      case TRANSFORM:
        ValidationService.transform(cliContext, validator);
        break;
      case NARRATIVE:
        ValidationService.generateNarrative(cliContext, validator);
        break;
      case SNAPSHOT:
        ValidationService.generateSnapshot(cliContext, validator);
        break;
      case CONVERT:
        ValidationService.convertSources(cliContext, validator);
        break;
      case FHIRPATH:
        ValidationService.evaluateFhirpath(cliContext, validator);
        break;
      case VERSION:
        ValidationService.transformVersion(cliContext, validator);
        break;
      case VALIDATION:
      case SCAN:
      default:
        for (String s : cliContext.getProfiles()) {
          if (!validator.getContext().hasResource(StructureDefinition.class, s) && !validator.getContext().hasResource(ImplementationGuide.class, s)) {
            System.out.println("  Fetch Profile from " + s);
            validator.loadProfile(cliContext.getLocations().getOrDefault(s, s));
          }
        }
        System.out.println("Validating");
        if (cliContext.getMode() == EngineMode.SCAN) {
          ValidationService.validateScan(cliContext, validator);
        } else {
          ValidationService.validateSources(cliContext, validator);
        }
        break;
    }
    System.out.println("Done. " + tt.report());
  }

  public static String determineVersion(CliContext cliContext) throws Exception {
    if (cliContext.getMode() != EngineMode.VALIDATION) {
      return "current";
    }
    System.out.println("Scanning for versions (no -version parameter):");
    VersionSourceInformation versions = ValidationService.scanForVersions(cliContext);
    for (String s : versions.getReport()) {
      System.out.println("  " + s);
    }
    if (versions.isEmpty()) {
      System.out.println("-> Using Default version '" + VersionUtilities.CURRENT_VERSION + "'");
      return "current";
    }
    if (versions.size() == 1) {
      System.out.println("-> use version " + versions.version());
      return versions.version();
    }
    throw new Exception("-> Multiple versions found. Specify a particular version using the -version parameter");
  }

}