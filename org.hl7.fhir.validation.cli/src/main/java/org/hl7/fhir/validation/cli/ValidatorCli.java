package org.hl7.fhir.validation.cli;

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
import org.hl7.fhir.r5.formats.ParserFactory;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.utilities.ENoDump;
import org.hl7.fhir.utilities.FileFormat;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess.WebAccessPolicy;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.tasks.*;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.utils.Display;
import org.hl7.fhir.validation.cli.param.Params;


/**
 * A executable providing a Command Line Interface primarily for validating one or more FHIR resources against
 * the specification.
 * <p/>
 * The CLI also supports other functionality, as documented in the CLI help:
 * <code>src/main/resources/help/help.txt</code>
 * <p/>
 * Alternatively, the <a href="https://github.com/hapifhir/org.hl7.fhir.validator-wrapper.git">validator-wrapper</a>
 * project provides similar functionality via a web-hosted service.
 * <p/>
 * For lower level use of FHIR validation in your own code, @ValidationEngine can be used directly. See the
 * <a href="https://github.com/FHIR/fhir-core-examples">fhir-core-examples</a>  project for examples of this. Note that
 * this is not the recommended path, and we are not able to guarantee support for this use case.
 * <p/>
 * todo: find a home for this:
 *
 * @author Grahame
 */
public class ValidatorCli {

  private final static ValidationService validationService = new ValidationService();
  
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
      new PreloadCacheTask(),
      new ScanTask(),
      new SnapshotTask(),
      new SpecialTask(),
      new SpreadsheetTask(),
      new TestsTask(),
      new TxTestsTask(),
      new AiTestsTask(),
      new TransformTask(),
      new VersionTask(),
      new CodeGenTask(),
      new RePackageTask(),
      new InstanceFactoryTask(),
      defaultCliTask);
  }

  protected void readParamsAndExecuteTask(ValidationContext validationContext, String[] args) throws Exception {
    TimeTracker tt = new TimeTracker();
    TimeTracker.Session tts = tt.start("Loading");

    if (validationContext.getLocale() != null) {
      Locale.setDefault(validationContext.getLocale());
    }
    if (Params.hasParam(args, Params.NO_HTTP_ACCESS)) {
      ManagedWebAccess.setAccessPolicy(WebAccessPolicy.PROHIBITED);
    }

    if (Params.hasParam(args, Params.AUTH_NONCONFORMANT_SERVERS)) {
      TerminologyClientContext.setAllowNonConformantServers(true);
    }      
    TerminologyClientContext.setCanAllowNonConformantServers(true);
    setJavaSystemProxyParamsFromParams(args);

    Display.displayVersion(System.out);
    Display.displaySystemInfo(System.out);

    if (validationContext.getFhirSettingsFile() != null) {
      FhirSettings.setExplicitFilePath(validationContext.getFhirSettingsFile());
    }
    ManagedWebAccess.loadFromFHIRSettings();

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

    readParamsAndExecuteTask(tt, tts, validationContext, args);
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
    // Prevents SLF4J(I) from printing unnecessary info to the console.
    System.setProperty("slf4j.internal.verbosity", "WARN");
    ParserFactory.registerCustomResources();

    final ValidatorCli validatorCli = new ValidatorCli(validationService);

    args = addAdditionalParamsForIpsParam(args);
    final ValidationContext validationContext = Params.loadValidationContext(args);
    try {
      validatorCli.readParamsAndExecuteTask(validationContext, args);
    } catch (ENoDump e) {
      System.out.println(e.getMessage());
    }
  }

  private static void setJavaSystemProxyParamsFromParams(String[] args) {

    final String proxy = Params.hasParam(args, Params.PROXY) ? Params.getParam(args, Params.PROXY) : null;
    final String httpsProxy = Params.hasParam(args, Params.HTTPS_PROXY) ? Params.getParam(args, Params.HTTPS_PROXY) : null;
    final String proxyAuth = Params.hasParam(args, Params.PROXY_AUTH) ? Params.getParam(args, Params.PROXY_AUTH) : null;
    JavaSystemProxyParamSetter.setJavaSystemProxyParams(proxy, httpsProxy, proxyAuth);
  }

  private static String[] addAdditionalParamsForIpsParam(String[] args) {
    List<String> res = new ArrayList<>();
    for (String a : args) {
      if (a.equals("-ips")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#2.0.0");
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
      } else if (a.startsWith("-ips#")) {
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
        res.add("hl7.cda.uv.core#2.0.0-sd-snapshot1");
      } else if (a.equals("-ccda")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("hl7.cda.us.ccda#3.0.0-ballot");
      } else if (a.equals("-view-definition")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("hl7.fhir.uv.sql-on-fhir#current");
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

  private void readParamsAndExecuteTask(TimeTracker tt, TimeTracker.Session tts, ValidationContext validationContext, String[] params) throws Exception {
    Display.printCliParamsAndInfo(params);

    final CliTask cliTask = selectCliTask(validationContext, params);

    if (cliTask instanceof ValidationEngineTask) {
      if (validationContext.getSv() == null) {
        validationContext.setSv(myValidationService.determineVersion(validationContext));
      }
      ValidationEngine validationEngine = getValidationEngine(tt, validationContext);
      tts.end();
      ((ValidationEngineTask) cliTask).executeTask(myValidationService, validationEngine, validationContext, params, tt, tts);
    } else if (cliTask instanceof StandaloneTask) {
      ((StandaloneTask) cliTask).executeTask(validationContext,params,tt,tts);
    }

    if (validationContext.getAdvisorFile() != null) {
      System.out.println("Note: Some validation issues might be hidden by the advisor settings in the file "+ validationContext.getAdvisorFile());
    }
    System.out.println("Done. " + tt.report()+". Max Memory = "+Utilities.describeSize(Runtime.getRuntime().maxMemory()));
    SystemExitManager.finish();
  }

  private CliTask selectCliTask(ValidationContext validationContext, String[] params) {
    CliTask cliTask = null;
    for(CliTask candidateTask : cliTasks) {
      if (candidateTask.shouldExecuteTask(validationContext, params)) {
        cliTask = candidateTask;
      }
    }
    if (cliTask == null)
      cliTask = defaultCliTask;
    return cliTask;
  }

  private ValidationEngine getValidationEngine(TimeTracker tt, ValidationContext validationContext) throws Exception {
    ValidationEngine validationEngine;
    System.out.println("  Locale: "+Locale.getDefault().getDisplayCountry()+"/"+Locale.getDefault().getCountry());
    if (validationContext.getJurisdiction() == null) {
      System.out.println("  Jurisdiction: None specified (locale = "+Locale.getDefault().getCountry()+")");
      System.out.println("  Note that exceptions and validation failures may happen in the absense of a locale");
    } else {
      System.out.println("  Jurisdiction: "+JurisdictionUtilities.displayJurisdiction(validationContext.getJurisdiction()));
    }

    System.out.println("Loading");
    String definitions = "dev".equals(validationContext.getSv()) ? "hl7.fhir.r5.core#current" : VersionUtilities.packageForVersion(validationContext.getSv()) + "#" + VersionUtilities.getCurrentVersion(validationContext.getSv());
    validationEngine = myValidationService.initializeValidator(validationContext, definitions, tt);
    return validationEngine;
  }

}