package org.hl7.fhir.validation.cli;

import io.javalin.Javalin;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.utils.Common;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ValidatorGui {

  private static final int GUI_FRONTEND_PORT = 8081;
  private static final String PAGE_ADDRESS = "http://localhost:" + GUI_FRONTEND_PORT + "/home";
  private static final String WEB_APP_FILE_LOCATION = "/public";
  private static Javalin app;

  private ValidatorGui(){}

  /**
   * N.B. this entry point, is only for testing. Please start from command line using the argument {@code -gui} for
   * actual use.
   */
  public static void main(String[] args) throws Exception {
    CliContext cliContext = new CliContext();
    String v = Common.getVersion(args);
    String definitions = VersionUtilities.packageForVersion(v) + "#" + v;
    ValidationEngine validationEngine = Common.getValidationEngine(v, definitions, cliContext.getTxLog());
    start(new CliContext(), validationEngine, false);
  }

  public static int getPort() {
    return GUI_FRONTEND_PORT;
  }

  public static void start(CliContext currentContext, ValidationEngine validationEngine, boolean bootBrowser) {
    app = Javalin.create();
    new RestEndpoints().initRestEndpoints(app, currentContext, validationEngine);
    app.config.addStaticFiles(WEB_APP_FILE_LOCATION);
    app.start(GUI_FRONTEND_PORT);
    if (bootBrowser) {
      openBrowser();
    }
  }

  public static void openBrowser() {
    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
      try {
        Desktop.getDesktop().browse(new URI(PAGE_ADDRESS));
      } catch (Exception e) {
        System.out.println("Error opening web browser to validator GUI.\nYou can try to open the page manually at:: "
          + PAGE_ADDRESS + "\nError:: " + e.getMessage());
      }
    }
  }

  public static void stop() {
    app.stop();
  }

}