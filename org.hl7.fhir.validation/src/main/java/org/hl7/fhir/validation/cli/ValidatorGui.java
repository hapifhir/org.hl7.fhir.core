package org.hl7.fhir.validation.cli;

import io.javalin.Javalin;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.utils.Common;

public class ValidatorGui {

  private static final String WEB_APP_FILE_LOCATION = "/public";
  private static Javalin app;

  /**
   * N.B. this entry point, is only for testing. Please start from command line using the argument {@code -gui} for
   * actual use.
   */
  public static void main(String[] args) throws Exception {
    CliContext cliContext = new CliContext();
    String v = Common.getVersion(args);
    String definitions = VersionUtilities.packageForVersion(v) + "#" + v;
    ValidationEngine validationEngine = Common.getValidationEngine(v, definitions, cliContext.getTxLog());
    start(new CliContext(), validationEngine);
  }

  public static void start(CliContext currentContext, ValidationEngine validationEngine) {
    app = Javalin.create();
    new RestEndpoints().initRestEndpoints(app, new CliContext(), validationEngine);
    app.config.addStaticFiles(WEB_APP_FILE_LOCATION);
    app.start(8080);
  }

  public static void stop() {
    app.stop();
  }

}
