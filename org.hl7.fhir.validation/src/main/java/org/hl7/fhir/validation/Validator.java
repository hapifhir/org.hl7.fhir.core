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

import java.io.File;
import java.net.URI;

import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.cli.ValidatorGui;
import org.hl7.fhir.validation.cli.services.ComparisonService;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.utils.*;

/**
 * A executable class that will validate one or more FHIR resources against
 * the specification
 * <p>
 * todo: schema validation (w3c xml, json schema, shex?)
 * <p>
 * if you want to host validation inside a process, skip this class, and look at
 * ValidationEngine
 * <p>
 * todo: find a gome for this:
 *
 * @author Grahame
 */
public class Validator {

  public enum EngineMode {
    VALIDATION, TRANSFORM, NARRATIVE, SNAPSHOT, SCAN, CONVERT, FHIRPATH, VERSION
  }

  private static CliContext cliContext;

  private static String getNamedParam(String[] args, String param) {
    boolean found = false;
    for (String a : args) {
      if (found)
        return a;
      if (a.equals(param)) {
        found = true;
      }
    }
    return null;
  }

  private static String toMB(long maxMemory) {
    return Long.toString(maxMemory / (1024 * 1024));
  }

  private static CliContext getCliContext() {
    if (cliContext == null) {
      cliContext = new CliContext();
    }
    return cliContext;
  }

  private static void goToWebPage(String url) {
    try {

      URI uri= new URI(url);

      java.awt.Desktop.getDesktop().browse(uri);
      System.out.println("Web page opened in browser");

    } catch (Exception e) {

      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {

    System.out.println("FHIR Validation tool " + VersionUtil.getVersionString());
    System.out.println("Detected Java version: " + System.getProperty("java.version") + " from " + System.getProperty("java.home") + " on " + System.getProperty("os.arch") + " (" + System.getProperty("sun.arch.data.model") + "bit). " + toMB(Runtime.getRuntime().maxMemory()) + "MB available");
    String proxy = getNamedParam(args, Params.PROXY);
    if (!Utilities.noString(proxy)) {
      String[] p = proxy.split("\\:");
      System.setProperty("http.proxyHost", p[0]);
      System.setProperty("http.proxyPort", p[1]);
    }

    if (Params.hasParam(args, Params.GUI)) {
      cliContext = Params.loadCliContext(args);
      String v = Common.getVersion(args);
      String definitions = VersionUtilities.packageForVersion(v) + "#" + v;
      ValidationEngine validationEngine = Common.getValidationEngine(v, definitions, cliContext.getTxLog());
      ValidatorGui.start(cliContext, validationEngine, true);
    } else if (Params.hasParam(args, Params.TEST)) {
      Common.runValidationEngineTests();
    } else if (args.length == 0 || Params.hasParam(args, Params.HELP) || Params.hasParam(args, "?") || Params.hasParam(args, "-?") || Params.hasParam(args, "/?")) {
      Display.displayHelpDetails();
    } else if (Params.hasParam(args, Params.COMPARE)) {
      Display.printCliArgumentsAndInfo(args);
      String dest = Params.getParam(args, Params.DESTINATION);
      if (dest == null)
        System.out.println("no -dest parameter provided");
      else if (!new File(dest).isDirectory())
        System.out.println("Specified destination (-dest parameter) is not valid: \"" + dest + "\")");
      else {
        // first, prepare the context
        String txLog = Params.getTerminologyServerLog(args);
        String v = Common.getVersion(args);
        String definitions = VersionUtilities.packageForVersion(v) + "#" + v;
        ValidationEngine validator = Common.getValidationEngine(v, definitions, txLog);
        Params.checkIGFileReferences(args);
        ComparisonService.doLeftRightComparison(args, dest, validator);
      }
    } else {
      Display.printCliArgumentsAndInfo(args);
      cliContext = Params.loadCliContext(args);

      // Comment this out because definitions filename doesn't necessarily contain version (and many not even be 14 characters long).  Version gets spit out a couple of lines later after we've loaded the context
      String definitions = VersionUtilities.packageForVersion(cliContext.getSv()) + "#" + VersionUtilities.getCurrentVersion(cliContext.getSv());
      ValidationEngine validator = ValidationService.getValidator(cliContext, definitions);
      if (cliContext.getMode() == EngineMode.VERSION) {

        ValidationService.transformVersion(cliContext, validator);
      } else if (cliContext.getMode() == EngineMode.TRANSFORM) {
        ValidationService.transform(cliContext, validator);
      } else if (cliContext.getMode() == EngineMode.NARRATIVE) {
        ValidationService.generateNarrative(cliContext, validator);
      } else if (cliContext.getMode() == EngineMode.SNAPSHOT) {
        ValidationService.generateSnapshot(cliContext, validator);
      } else if (cliContext.getMode() == EngineMode.CONVERT) {
        ValidationService.convertSources(cliContext, validator);
      } else if (cliContext.getMode() == EngineMode.FHIRPATH) {
        ValidationService.evaluateFhirpath(cliContext, validator);
      } else {
        if (definitions == null) {
          throw new Exception("Must provide a defn when doing validation");
        }
        for (String s : cliContext.getProfiles()) {
          if (!validator.getContext().hasResource(StructureDefinition.class, s) && !validator.getContext().hasResource(ImplementationGuide.class, s)) {
            System.out.println("Fetch Profile from " + s);
            validator.loadProfile(cliContext.getLocations().getOrDefault(s, s));
          }
        }
        if (cliContext.getMode() == EngineMode.SCAN) {
          ValidationService.validateScan(cliContext, validator);
        } else {
          ValidationService.validateSources(cliContext, validator);
        }
      }
    }
  }
}