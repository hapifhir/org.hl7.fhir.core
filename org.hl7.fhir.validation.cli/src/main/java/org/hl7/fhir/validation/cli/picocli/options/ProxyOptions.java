package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.cli.JavaSystemProxyParamSetter;
import org.hl7.fhir.validation.cli.param.Params;
import picocli.CommandLine;

public class ProxyOptions implements GlobalOptions{

  @CommandLine.Option(names = {"-proxy"}, description = "An http proxy address [address]:[port]")
  String proxy;

  @CommandLine.Option(names = {"-https-proxy"}, description = "An https proxy address [address]:[port]")
  String httpsProxy;

  @CommandLine.Option(names = {"-auth"}, description = "Basic proxy authentication using [username]:[password]")
  String proxyAuth;

  @Override
  public void apply(CommandLine.ParseResult parseResult) {
    final String proxy = parseResult.matchedOptionValue(Params.PROXY, null);
    final String httpsProxy = parseResult.matchedOptionValue(Params.HTTPS_PROXY, null);
    final String proxyAuth = parseResult.matchedOptionValue(Params.PROXY_AUTH, null);

    JavaSystemProxyParamSetter.setJavaSystemProxyParams(proxy, httpsProxy, proxyAuth);
  }
}
