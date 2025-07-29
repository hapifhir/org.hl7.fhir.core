package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.JavaSystemProxyParamSetter;
import org.hl7.fhir.validation.cli.param.Params;
import picocli.CommandLine;

import java.util.Map;

public class CLI {

  private static String[] getBackwardCompatibleArgs(String[] args) {
      Map<String, String> argMap = Map.of(
          "-server", "server",
          "-?", "-help",
          "/?", "-help"
      );

      String[] newArgs = new String[args.length];
      for (int i = 0; i < args.length; i++) {
          if (argMap.containsKey(args[i])) {
              newArgs[i] = argMap.get(args[i]);
          } else {
              newArgs[i] = args[i];
          }
      }
      return newArgs;
  }

    public static void main(String[] args) {
      String[] backwardCompatibleArgs = getBackwardCompatibleArgs(args);
      CommandLine commandLine = new CommandLine(new DefaultCommand());

      CommandLine.ParseResult parseResult = commandLine.parseArgs(backwardCompatibleArgs);

      setJavaSystemProxyFromParsedArgs(parseResult);

      int exitCode = commandLine.execute(backwardCompatibleArgs);
      System.exit(exitCode);
    }

  private static void setJavaSystemProxyFromParsedArgs(CommandLine.ParseResult parseResult) {
    final String proxy =  parseResult.matchedOptionValue(Params.PROXY, null);
    final String httpsProxy = parseResult.matchedOptionValue( Params.HTTPS_PROXY, null);
    final String proxyAuth = parseResult.matchedOptionValue( Params.PROXY_AUTH, null);

    JavaSystemProxyParamSetter.setJavaSystemProxyParams(proxy, httpsProxy, proxyAuth);
  }

}
