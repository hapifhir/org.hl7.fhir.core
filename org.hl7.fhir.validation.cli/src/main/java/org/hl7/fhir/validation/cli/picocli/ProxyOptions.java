package org.hl7.fhir.validation.cli.picocli;

import picocli.CommandLine;

public class ProxyOptions {

  @CommandLine.Option(names = {"-proxy"}, description = "An http proxy address [address]:[port]")
  String proxy;

  @CommandLine.Option(names = {"-https-proxy"}, description = "An https proxy address [address]:[port]")
  String httpsProxy;

  @CommandLine.Option(names = {"-auth"}, description = "Basic proxy authentication using [username]:[password]")
  String proxyAuth;


}
