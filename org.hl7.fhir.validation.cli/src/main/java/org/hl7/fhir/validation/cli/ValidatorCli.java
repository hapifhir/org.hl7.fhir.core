package org.hl7.fhir.validation.cli;

import java.io.IOException;
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

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.WordUtils;
import org.hl7.fhir.r5.formats.ParserFactory;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.utilities.ENoDump;
import org.hl7.fhir.utilities.FileFormat;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess.WebAccessPolicy;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.cli.logging.Level;
import org.hl7.fhir.validation.cli.logging.LogbackUtilities;
import org.hl7.fhir.validation.cli.param.parsers.GlobalParametersParser;
import org.hl7.fhir.validation.cli.tasks.*;
import org.hl7.fhir.validation.service.ValidationService;
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
@Slf4j
public class ValidatorCli {

  public static final String HELP = "help";
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
      new LangRegenerateTask(),
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
      new HTTPServerTask(),
      new HTTPClientTask(),
      defaultCliTask);
  }

  /**
   * This POJO tracks multiple params that must be extracted BEFORE ANY task is run.
   * <p/>
   * Things like locale and network proxy settings must be applied to the running system, for example, and should not
   * rely on any individual task to process them.
   */
  @NoArgsConstructor
  static class GlobalParams {
    @Setter
    @Getter
    private String localeLanguageTag = null;
    @Setter
    @Getter
    private WebAccessPolicy webAccessPolicy = null;

    @Setter
    @Getter
    private Boolean allowNonConformantTxServers = null;

    @Setter
    @Getter
    private String proxy = null;
    @Setter
    @Getter

    private String httpsProxy = null;
    @Setter
    @Getter
    private String proxyAuth = null;

    @Setter
    @Getter
    private String debugLogFile = null;

    @Setter
    @Getter
    private String traceLogFile = null;

    @Setter
    @Getter
    private String fhirSettingsFilePath = null;
  }

  public static GlobalParams readGlobalParams(String[] args) {
    GlobalParams globalParams = new GlobalParams();
    if (Params.hasParamAndValue(args, GlobalParametersParser.LOCALE)){
      final String languageTag = Params.getParam(args,  GlobalParametersParser.LOCALE);
      globalParams.setLocaleLanguageTag(languageTag);
    }

    if (Params.hasParamAndValue(args, GlobalParametersParser.DEBUG_LOG)){
      globalParams.setDebugLogFile(Params.getParam(args, GlobalParametersParser.DEBUG_LOG));
    }

    if (Params.hasParamAndValue(args, GlobalParametersParser.TRACE_LOG)){
      globalParams.setTraceLogFile(Params.getParam(args, GlobalParametersParser.TRACE_LOG));
    }

    if (Params.hasParam(args, GlobalParametersParser.NO_HTTP_ACCESS)) {
      globalParams.setWebAccessPolicy(WebAccessPolicy.PROHIBITED);
    }
    if (Params.hasParam(args, GlobalParametersParser.AUTH_NONCONFORMANT_SERVERS)) {
      globalParams.setAllowNonConformantTxServers(true);
    }

    globalParams.setProxy(Params.hasParamAndValue(args, GlobalParametersParser.PROXY) ? Params.getParam(args, GlobalParametersParser.PROXY) : null);
    globalParams.setHttpsProxy(Params.hasParamAndValue(args, GlobalParametersParser.HTTPS_PROXY) ? Params.getParam(args, GlobalParametersParser.HTTPS_PROXY) : null);
    globalParams.setProxyAuth(Params.hasParamAndValue(args, GlobalParametersParser.PROXY_AUTH) ? Params.getParam(args, GlobalParametersParser.PROXY_AUTH) : null);

    if (Params.hasParamAndValue(args, GlobalParametersParser.FHIR_SETTINGS_PARAM)) {
      final String fhirSettingsFilePath = Params.getParam(args, GlobalParametersParser.FHIR_SETTINGS_PARAM);
      try {
        if (!ManagedFileAccess.file(fhirSettingsFilePath).exists()) {
          throw new Error("Cannot find fhir-settings file: " + fhirSettingsFilePath);
        }
      } catch (IOException e) {
        throw new Error("Error checking fhir-settings file: " + fhirSettingsFilePath);
      }
      globalParams.setFhirSettingsFilePath(fhirSettingsFilePath);
    }

    return globalParams;
  }

  protected void readGlobalParamsAndExecuteTask(String[] args) throws Exception {

    GlobalParams globalParams = readGlobalParams(args);
    applyGlobalParams(globalParams);

    checkCharsetAndWarnIfNotUTF8();

    if (shouldDisplayHelpToUser(args)) {
      String helpTarget = Params.getParam(args, "-" + HELP);
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
    Display.printCliParamsAndInfo(log, args);
    readParamsAndExecuteTask(args);
  }

  private static void applyGlobalParams(GlobalParams globalParams) {
    if (globalParams.getLocaleLanguageTag() != null){
        Locale.setDefault(Locale.forLanguageTag(globalParams.getLocaleLanguageTag()));
    }

    if (globalParams.getDebugLogFile() != null){
      LogbackUtilities.setLogToFileAndConsole(Level.DEBUG, globalParams.getDebugLogFile());
    }

    if (globalParams.getTraceLogFile() != null){
      LogbackUtilities.setLogToFileAndConsole(Level.TRACE, globalParams.getTraceLogFile());
    }

    if (globalParams.getWebAccessPolicy() != null) {
      ManagedWebAccess.setAccessPolicy(globalParams.getWebAccessPolicy());
    }

    if (globalParams.getAllowNonConformantTxServers() != null) {
      TerminologyClientContext.setAllowNonConformantServers(globalParams.getAllowNonConformantTxServers());
    }
    TerminologyClientContext.setCanAllowNonConformantServers(true);

    JavaSystemProxyParamSetter.setJavaSystemProxyParams(globalParams.getProxy(), globalParams.getHttpsProxy(), globalParams.getProxyAuth());

    Display.displayVersion(log);
    Display.displaySystemInfo(log);

    if (globalParams.getFhirSettingsFilePath() != null) {
      FhirSettings.setExplicitFilePath(globalParams.getFhirSettingsFilePath());
    }
    ManagedWebAccess.loadFromFHIRSettings();
  }

  @SuppressWarnings("checkstyle:systemout")
  private static void checkCharsetAndWarnIfNotUTF8() {
    FileFormat.checkCharsetAndWarnIfNotUTF8(System.out);
  }

  private void displayHelpForDefaultTask() {
    log.info("");
    log.info(WordUtils.wrap("This is the help text for default usage of the validator. Help for other modes of operation is available by using the parameter '-help [mode]' for one of the following modes:", 80));
    log.info("");
    for (CliTask cliTask : cliTasks) {
      if (!cliTask.isHidden()) {
        log.info("  " + cliTask.getName());
      }
    }
    log.info("");
    log.info(defaultCliTask.getDisplayName() + " (default usage)");
    log.info("=".repeat(defaultCliTask.getDisplayName().length()));
    log.info("");
    defaultCliTask.logHelp(log);
  }

  private void displayHelpForTask(CliTask cliTask) {
    log.info("");

    log.info("This is the help text for '" + cliTask.getName() + "'. To display all available help options, use the '-help' or 'help' parameter.");
    log.info("");
    log.info(cliTask.getDisplayName());
    log.info("=".repeat(cliTask.getDisplayName().length()));
    log.info("");
    cliTask.logHelp(log);
  }

  public static void main(String[] args) throws Exception {
    // Prevents SLF4J(I) from printing unnecessary info to the console.
    System.setProperty("slf4j.internal.verbosity", "WARN");
    ParserFactory.registerCustomResources();

    final ValidatorCli validatorCli = new ValidatorCli(validationService);

    args = addAdditionalParamsForIpsParam(args);

    try {
      validatorCli.readGlobalParamsAndExecuteTask(args);
    } catch (ENoDump e) {
      log.info(e.getMessage());
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
        res.add("hl7.fhir.uv.ips#2.0.0-ballot");
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
        res.add("hl7.fhir.au.ps#current");
        res.add("-profile");
        res.add("http://hl7.org.au/fhir/ps/StructureDefinition/au-ps-bundle");
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org.au/fhir/ps/StructureDefinition/au-ps-composition");
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
        res.add("hl7.cda.uv.core#2.0.1-sd");
      } else if (a.equals("-ccda")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("hl7.cda.us.ccda#4.0.0");
      } else if (a.equals("-view-definition")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("org.sql-on-fhir.ig#current");
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
      || Params.hasParam(args, HELP)
      || Params.hasParam(args, "-" + HELP)
      || Params.hasParam(args, "?")
      || Params.hasParam(args, "-?")
      || Params.hasParam(args, "/?"));
  }

  private void readParamsAndExecuteTask(String[] args) throws Exception {

    final CliTask cliTask = selectCliTask(args);

    if (cliTask instanceof ValidationServiceTask) {
      ((ValidationServiceTask) cliTask).executeTask(myValidationService, args);
    } else if (cliTask instanceof StandaloneTask) {
      ((StandaloneTask) cliTask).executeTask(args);
      log.info("Done. Max Memory = "+Utilities.describeSize(Runtime.getRuntime().maxMemory()));
    }

     SystemExitManager.finish();
  }

  private CliTask selectCliTask(String[] params) {
    CliTask cliTask = null;
    for(CliTask candidateTask : cliTasks) {
      if (candidateTask.shouldExecuteTask(params)) {
        cliTask = candidateTask;
      }
    }
    if (cliTask == null)
      cliTask = defaultCliTask;
    return cliTask;
  }

}