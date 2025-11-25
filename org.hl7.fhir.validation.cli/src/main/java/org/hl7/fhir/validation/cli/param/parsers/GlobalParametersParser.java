package org.hl7.fhir.validation.cli.param.parsers;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;

/**
 * These are special parameters that must be handled BEFORE any task is executed, usually linked to JVM or system
 * settings.
 * <p/>
 * ote that this does not produce a Parameters object at the moment. It returns null because these params are
 * meant to receive special treatment in ValidatorCli.
 */
@Slf4j
public class GlobalParametersParser implements IParamParser<Object> {
  public static final String PROXY = "-proxy";
  public static final String HTTPS_PROXY = "-https-proxy";
  public static final String PROXY_AUTH = "-auth";
  public static final String DEBUG = "-debug";
  public static final String DEBUG_LOG = "-debug-log";
  public static final String TRACE_LOG = "-trace-log";
  public static final String LOCALE = "-locale";
  public static final String FHIR_SETTINGS_PARAM = "-fhir-settings";
  public static final String NO_HTTP_ACCESS = "-no-http-access";
  public static final String AUTH_NONCONFORMANT_SERVERS = "-authorise-non-conformant-tx-servers";
  public static final String SERVER = "-server";
  public static final String RUN_TESTS = "-run-tests";
  public static final String X = "-x";

    @Override
  public Object getParameterObject() {
    return null;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].getValue().equals(GlobalParametersParser.DEBUG)) {
        log.warn("Debugging support is now provided through the -debug-log and -trace-log CLI parameters. Use the -help option for detailed instructions.");
        args[i].setProcessed(true);
      } else if (Utilities.existsInList(args[i].getValue(),
      DEBUG_LOG,
      TRACE_LOG,
      PROXY,
      PROXY_AUTH,
      HTTPS_PROXY,
      SERVER)) {
      //DO NOTHING Those params are handled outside this loop, so should be ignored along with their values.
      Arg.setProcessed(args, i, 2, true);
    } else if (Utilities.existsInList(args[i].getValue(),
      AUTH_NONCONFORMANT_SERVERS,
      NO_HTTP_ACCESS,
      FHIR_SETTINGS_PARAM,
        X, // Not used anywhere?
        RUN_TESTS // Processed by AITestsTask
      )) {
      //DO NOTHING Those params are handled outside this loop, so should be ignored.
      args[i].setProcessed(true);
    }
    }
  }
}
