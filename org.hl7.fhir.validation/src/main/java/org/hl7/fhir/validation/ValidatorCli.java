package org.hl7.fhir.validation;

import java.io.File;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.utilities.FileFormat;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ComparisonService;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.utils.Display;
import org.hl7.fhir.validation.cli.utils.EngineMode;
import org.hl7.fhir.validation.cli.utils.Params;
import org.hl7.fhir.validation.testexecutor.TestExecutor;
import org.hl7.fhir.validation.testexecutor.TestExecutorParams;

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
public class ValidatorCli {

  public static final String HTTP_PROXY_HOST = "http.proxyHost";
  public static final String HTTP_PROXY_PORT = "http.proxyPort";
  public static final String HTTP_PROXY_USER = "http.proxyUser";
  public static final String HTTP_PROXY_PASS = "http.proxyPassword";
  public static final String JAVA_DISABLED_TUNNELING_SCHEMES = "jdk.http.auth.tunneling.disabledSchemes";
  public static final String JAVA_DISABLED_PROXY_SCHEMES = "jdk.http.auth.proxying.disabledSchemes";
  public static final String JAVA_USE_SYSTEM_PROXIES = "java.net.useSystemProxies";

  private static ValidationService validationService = new ValidationService();

  public static void main(String[] args) throws Exception {
    TimeTracker tt = new TimeTracker();
    TimeTracker.Session tts = tt.start("Loading");

    args = preProcessArgs(args);
    
    Display.displayVersion();
    Display.displaySystemInfo();

    if (Params.hasParam(args, Params.PROXY)) {
      assert Params.getParam(args, Params.PROXY) != null : "PROXY arg passed in was NULL";
      String[] p = Params.getParam(args, Params.PROXY).split(":");
      System.setProperty(HTTP_PROXY_HOST, p[0]);
      System.setProperty(HTTP_PROXY_PORT, p[1]);
    }

    if (Params.hasParam(args, Params.PROXY_AUTH)) {
      assert Params.getParam(args, Params.PROXY) != null : "Cannot set PROXY_AUTH without setting PROXY...";
      assert Params.getParam(args, Params.PROXY_AUTH) != null : "PROXY_AUTH arg passed in was NULL...";
      String[] p = Params.getParam(args, Params.PROXY_AUTH).split(":");
      String authUser = p[0];
      String authPass = p[1];

      /*
       * For authentication, use java.net.Authenticator to set proxy's configuration and set the system properties
       * http.proxyUser and http.proxyPassword
       */
      Authenticator.setDefault(
        new Authenticator() {
          @Override
          public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(authUser, authPass.toCharArray());
          }
        }
      );

      System.setProperty(HTTP_PROXY_USER, authUser);
      System.setProperty(HTTP_PROXY_PASS, authPass);
      System.setProperty(JAVA_USE_SYSTEM_PROXIES, "true");

      /*
       * For Java 1.8 and higher you must set
       * -Djdk.http.auth.tunneling.disabledSchemes=
       * to make proxies with Basic Authorization working with https along with Authenticator
       */
      System.setProperty(JAVA_DISABLED_TUNNELING_SCHEMES, "");
      System.setProperty(JAVA_DISABLED_PROXY_SCHEMES, "");
    }

    CliContext cliContext = Params.loadCliContext(args);

    FileFormat.checkCharsetAndWarnIfNotUTF8(System.out);

    if (shouldDisplayHelpToUser(args)) {
      Display.displayHelpDetails();
    } else if (Params.hasParam(args, Params.COMPARE)) {
      if (destinationDirectoryValid(Params.getParam(args, Params.DESTINATION))) {
        doLeftRightComparison(args, cliContext, tt);
      }
    } else if (Params.hasParam(args, Params.TEST)) {
      parseTestParamsAndExecute(args);
    }
    else {
      Display.printCliArgumentsAndInfo(args);
      doValidation(tt, tts, cliContext);
    }
  }

  protected static void parseTestParamsAndExecute(String[] args) {
    final String testModuleParam = Params.getParam(args, Params.TEST_MODULES);
    final String testClassnameFilter = Params.getParam(args, Params.TEST_NAME_FILTER);
    final String testCasesDirectory = Params.getParam(args, Params.TEST);
    final String txCacheDirectory = Params.getParam(args, Params.TERMINOLOGY_CACHE);
    assert TestExecutorParams.isValidModuleParam(testModuleParam) : "Invalid test module param: " + testModuleParam;
    final String[] moduleNamesArg = TestExecutorParams.parseModuleParam(testModuleParam);

    assert TestExecutorParams.isValidClassnameFilterParam(testClassnameFilter) : "Invalid regex for test classname filter: " + testClassnameFilter;

    new TestExecutor(moduleNamesArg).executeTests(testClassnameFilter, txCacheDirectory, testCasesDirectory);

    System.exit(0);
  }

  private static String[] preProcessArgs(String[] args) {
    // ips$branch --> -version 4.0 -ig hl7.fhir.uv.ips#current$connectathon-2 -profile http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips
    List<String> res = new ArrayList<>();
    for (String a : args) {
      if (a.equals("-ips")) {
        res.add("-version");
        res.add("4.0");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#current");
        res.add("-profile");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");
      } else if (a.startsWith("-ips$")) {
        res.add("-version");
        res.add("4.0");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#current$"+a.substring(5));
        res.add("-profile");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");        
      } else {
        res.add(a);
      }
    }
    String[] r = new String[res.size()];
    for (int i = 0; i < res.size(); i++) {
      r[i] = res.get(i);
    }
    return r;
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
      cliContext.setSv(validationService.determineVersion(cliContext));
    }
    String v = VersionUtilities.getCurrentVersion(cliContext.getSv());
    String definitions = VersionUtilities.packageForVersion(v) + "#" + v;
    ValidationEngine validator = validationService.initializeValidator(cliContext, definitions, tt);
    validator.loadPackage(CommonPackages.ID_PUBPACK, null);
    ComparisonService.doLeftRightComparison(args, Params.getParam(args, Params.DESTINATION), validator);
  }

  private static void doValidation(TimeTracker tt, TimeTracker.Session tts, CliContext cliContext) throws Exception {
    if (cliContext.getSv() == null) {
      cliContext.setSv(validationService.determineVersion(cliContext));
    }
    if (cliContext.getJurisdiction() == null) {
      System.out.println("  Jurisdiction: None specified (locale = "+Locale.getDefault().getCountry()+")");      
      System.out.println("  Note that exceptions and validation failures may happen in the absense of a locale");      
    } else {
      System.out.println("  Jurisdiction: "+JurisdictionUtilities.displayJurisdiction(cliContext.getJurisdiction()));
    }

    System.out.println("Loading");
    // Comment this out because definitions filename doesn't necessarily contain version (and many not even be 14 characters long).
    // Version gets spit out a couple of lines later after we've loaded the context
    String definitions = "dev".equals(cliContext.getSv()) ? "hl7.fhir.r5.core#current" : VersionUtilities.packageForVersion(cliContext.getSv()) + "#" + VersionUtilities.getCurrentVersion(cliContext.getSv());
    ValidationEngine validator = validationService.initializeValidator(cliContext, definitions, tt);
    tts.end();
    switch (cliContext.getMode()) {
      case TRANSFORM:
        validationService.transform(cliContext, validator);
        break;
      case COMPILE:
        validationService.compile(cliContext, validator);
        break;
      case NARRATIVE:
        validationService.generateNarrative(cliContext, validator);
        break;
      case SNAPSHOT:
        validationService.generateSnapshot(cliContext, validator);
        break;
      case SPREADSHEET:
        validationService.generateSpreadsheet(cliContext, validator);
        break;
      case CONVERT:
        validationService.convertSources(cliContext, validator);
        break;
      case FHIRPATH:
        validationService.evaluateFhirpath(cliContext, validator);
        break;
      case VERSION:
        validationService.transformVersion(cliContext, validator);
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
          Scanner validationScanner = new Scanner(validator.getContext(), validator.getValidator(null), validator.getIgLoader(), validator.getFhirPathEngine());
          validationScanner.validateScan(cliContext.getOutput(), cliContext.getSources());
        } else {
          validationService.validateSources(cliContext, validator);
        }
        break;
    }
    System.out.println("Done. " + tt.report()+". Max Memory = "+Utilities.describeSize(Runtime.getRuntime().maxMemory()));
  }
}