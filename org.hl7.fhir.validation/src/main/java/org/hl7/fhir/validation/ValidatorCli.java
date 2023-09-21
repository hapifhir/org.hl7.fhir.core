package org.hl7.fhir.validation;

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

import org.apache.commons.text.WordUtils;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.utilities.FileFormat;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.tasks.CliTask;
import org.hl7.fhir.validation.cli.tasks.CompareTask;
import org.hl7.fhir.validation.cli.tasks.CompileTask;
import org.hl7.fhir.validation.cli.tasks.ConvertTask;
import org.hl7.fhir.validation.cli.tasks.FhirpathTask;
import org.hl7.fhir.validation.cli.tasks.InstallTask;
import org.hl7.fhir.validation.cli.tasks.LangTransformTask;
import org.hl7.fhir.validation.cli.tasks.NarrativeTask;
import org.hl7.fhir.validation.cli.tasks.ScanTask;
import org.hl7.fhir.validation.cli.tasks.SnapshotTask;
import org.hl7.fhir.validation.cli.tasks.SpecialTask;
import org.hl7.fhir.validation.cli.tasks.SpreadsheetTask;
import org.hl7.fhir.validation.cli.tasks.StandaloneTask;
import org.hl7.fhir.validation.cli.tasks.TestsTask;
import org.hl7.fhir.validation.cli.tasks.TransformTask;
import org.hl7.fhir.validation.cli.tasks.TxTestsTask;
import org.hl7.fhir.validation.cli.tasks.ValidateTask;
import org.hl7.fhir.validation.cli.tasks.ValidationEngineTask;
import org.hl7.fhir.validation.cli.tasks.VersionTask;
import org.hl7.fhir.validation.cli.utils.Display;
import org.hl7.fhir.validation.cli.utils.Params;

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

  public static final String HTTPS_PROXY_HOST = "https.proxyHost";

  public static final String HTTPS_PROXY_PORT = "https.proxyPort";
  public static final String HTTP_PROXY_USER = "http.proxyUser";
  public static final String HTTP_PROXY_PASS = "http.proxyPassword";
  public static final String JAVA_DISABLED_TUNNELING_SCHEMES = "jdk.http.auth.tunneling.disabledSchemes";
  public static final String JAVA_DISABLED_PROXY_SCHEMES = "jdk.http.auth.proxying.disabledSchemes";
  public static final String JAVA_USE_SYSTEM_PROXIES = "java.net.useSystemProxies";

  private static ValidationService validationService = new ValidationService();

  protected ValidationService myValidationService;

  final List<CliTask> cliTasks;

  final CliTask defaultCliTask = new ValidateTask();
  protected ValidatorCli(ValidationService validationService) {
    myValidationService = validationService;
    cliTasks = getCliTasks();
  }

  protected List<CliTask> getCliTasks() {
    return List.of(
      new CompareTask(),
      new CompileTask(),
      new ConvertTask(),
      new FhirpathTask(),
      new InstallTask(),
      new LangTransformTask(),
      new NarrativeTask(),
      new ScanTask(),
      new SnapshotTask(),
      new SpecialTask(),
      new SpreadsheetTask(),
      new TestsTask(),
      new TxTestsTask(),
      new TransformTask(),
      new VersionTask(),
      defaultCliTask);
  }

  protected void readParamsAndExecuteTask(CliContext cliContext, String[] args) throws Exception {
    TimeTracker tt = new TimeTracker();
    TimeTracker.Session tts = tt.start("Loading");

    setJavaSystemProxyParamsFromParams(args);

    Display.displayVersion(System.out);
    Display.displaySystemInfo(System.out);

    if (cliContext.getFhirSettingsFile() != null) {
      FhirSettings.setExplicitFilePath(cliContext.getFhirSettingsFile());
    }

    FileFormat.checkCharsetAndWarnIfNotUTF8(System.out);

    if (shouldDisplayHelpToUser(args)) {
      String helpTarget = Params.getParam(args, "-" + Params.HELP);
      if (helpTarget != null) {
        cliTasks.stream()
          .filter(task -> helpTarget.equals(task.getName()))
          .findFirst()
          .ifPresent(cliTask -> {
            displayHelpForTask(cliTask);
          });
      } else {
        displayHelpForDefaultTask();
      }
      return;
    }

    readParamsAndExecuteTask(tt, tts, cliContext, args);
  }

  private void displayHelpForDefaultTask() {
    System.out.println();
    System.out.println(WordUtils.wrap("This is the help text for default usage of the validator. Help for other modes of operation is available by using the parameter '-help [mode]' for one of the following modes:", 80));
    System.out.println();
    for (CliTask cliTask : cliTasks) {
      if (!cliTask.isHidden()) {
        System.out.println("  " + cliTask.getName());
      }
    }
    System.out.println();
    System.out.println(defaultCliTask.getDisplayName() + " (default usage)");
    System.out.println("=".repeat(defaultCliTask.getDisplayName().length()));
    System.out.println();
    defaultCliTask.printHelp(System.out);
  }

  private void displayHelpForTask(CliTask cliTask) {
    System.out.println();

    System.out.println("This is the help text for '" + cliTask.getName() + "'. To display all available help options, use the '-help' or 'help' parameter.");
    System.out.println();
    System.out.println(cliTask.getDisplayName());
    System.out.println("=".repeat(cliTask.getDisplayName().length()));
    System.out.println();
    cliTask.printHelp(System.out);
  }

  public static void main(String[] args) throws Exception {
    final ValidatorCli validatorCli = new ValidatorCli(validationService);

    args = addAdditionalParamsForIpsParam(args);
    final CliContext cliContext = Params.loadCliContext(args);
    validatorCli.readParamsAndExecuteTask(cliContext, args);
  }

  private static void setJavaSystemProxyParamsFromParams(String[] args) {

    setJavaSystemProxyHostFromParams(args, Params.PROXY, HTTP_PROXY_HOST, HTTP_PROXY_PORT);
    setJavaSystemProxyHostFromParams(args, Params.HTTPS_PROXY, HTTPS_PROXY_HOST, HTTPS_PROXY_PORT);

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
  }

  private static void setJavaSystemProxyHostFromParams(String[] args, String proxyParam, String proxyHostProperty, String proxyPortProperty) {
    if (Params.hasParam(args, proxyParam)) {
      assert Params.getParam(args, proxyParam) != null : "PROXY arg passed in was NULL";
      String[] p = Params.getParam(args, proxyParam).split(":");

      System.setProperty(proxyHostProperty, p[0]);
      System.setProperty(proxyPortProperty, p[1]);
    }
  }

  private static String[] addAdditionalParamsForIpsParam(String[] args) {
    List<String> res = new ArrayList<>();
    for (String a : args) {
      if (a.equals("-ips")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#1.1.0");
        res.add("-profile");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips");
      } else if (a.equals("-ips:au")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.au.ips#current");
        res.add("-profile");
        res.add("http://hl7.org.au/fhir/ips/StructureDefinition/Bundle-au-ips");
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org.au/fhir/ips/StructureDefinition/Composition-au-ips");
      } else if (a.equals("-ips#")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#"+a.substring(5));
        res.add("-profile");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips");
      } else if (a.startsWith("-ips$")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#current$"+a.substring(5));
        res.add("-profile");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");        
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips");
      } else if (a.equals("-cda")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("hl7.cda.uv.core#2.1.0-draft1");
      } else if (a.equals("-ccda")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("hl7.cda.uv.core#2.1.0-draft1");
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



  private boolean shouldDisplayHelpToUser(String[] args) {
    return (args.length == 0
      || Params.hasParam(args, Params.HELP)
      || Params.hasParam(args, "-" + Params.HELP)
      || Params.hasParam(args, "?")
      || Params.hasParam(args, "-?")
      || Params.hasParam(args, "/?"));
  }

  private void readParamsAndExecuteTask(TimeTracker tt, TimeTracker.Session tts, CliContext cliContext, String[] params) throws Exception {
    Display.printCliParamsAndInfo(params);



    final CliTask cliTask = selectCliTask(cliContext, params);

    if (cliTask instanceof ValidationEngineTask) {
      if (cliContext.getSv() == null) {
        cliContext.setSv(myValidationService.determineVersion(cliContext));
      }
        ValidationEngine validationEngine = getValidationEngine(tt, cliContext);
        tts.end();
        ((ValidationEngineTask) cliTask).executeTask(myValidationService, validationEngine, cliContext, params, tt, tts);
      } else if (cliTask instanceof StandaloneTask) {
        ((StandaloneTask) cliTask).executeTask(cliContext,params,tt,tts);
      }

    System.out.println("Done. " + tt.report()+". Max Memory = "+Utilities.describeSize(Runtime.getRuntime().maxMemory()));
    SystemExitManager.finish();
  }

  private CliTask selectCliTask(CliContext cliContext, String[] params) {
    CliTask cliTask = null;
    for(CliTask candidateTask : cliTasks) {
      if (candidateTask.shouldExecuteTask(cliContext, params)) {
        cliTask = candidateTask;
      }
    }
    if (cliTask == null)
      cliTask = defaultCliTask;
    return cliTask;
  }

  private ValidationEngine getValidationEngine(TimeTracker tt, CliContext cliContext) throws Exception {
    ValidationEngine validationEngine;
    System.out.println("  Locale: "+Locale.getDefault().getDisplayCountry()+"/"+Locale.getDefault().getCountry());
    if (cliContext.getJurisdiction() == null) {
      System.out.println("  Jurisdiction: None specified (locale = "+Locale.getDefault().getCountry()+")");
      System.out.println("  Note that exceptions and validation failures may happen in the absense of a locale");
    } else {
      System.out.println("  Jurisdiction: "+JurisdictionUtilities.displayJurisdiction(cliContext.getJurisdiction()));
    }

    System.out.println("Loading");
    String definitions = "dev".equals(cliContext.getSv()) ? "hl7.fhir.r5.core#current" : VersionUtilities.packageForVersion(cliContext.getSv()) + "#" + VersionUtilities.getCurrentVersion(cliContext.getSv());
    validationEngine = myValidationService.initializeValidator(cliContext, definitions, tt);
    return validationEngine;
  }

  protected void validateScan(CliContext cliContext, ValidationEngine validator) throws Exception {
    Scanner validationScanner = new Scanner(validator.getContext(), validator.getValidator(null), validator.getIgLoader(), validator.getFhirPathEngine());
    validationScanner.validateScan(cliContext.getOutput(), cliContext.getSources());
  }
}