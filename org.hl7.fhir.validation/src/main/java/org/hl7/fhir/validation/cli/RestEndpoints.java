package org.hl7.fhir.validation.cli;

import io.javalin.Javalin;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.controller.CliContextController;
import org.hl7.fhir.validation.cli.controller.ValidationController;
import org.hl7.fhir.validation.cli.controller.UIController;
import org.hl7.fhir.validation.cli.model.CliContext;

public class RestEndpoints {

  public UIController myUIController;
  public CliContextController myCliContextController;
  public ValidationController myValidationController;

  public void initRestEndpoints(Javalin app, CliContext cliContext, ValidationEngine validationEngine) {

    myUIController = new UIController();
    myCliContextController = new CliContextController(cliContext);
    myValidationController = new ValidationController(validationEngine);

    app.get("/home", myUIController.renderLandingPage);

    app.get("/context", myCliContextController::handleGetCurrentCliContext);
    app.post("/context", myCliContextController::handleSetCurrentCliContext);

    app.post("/validate", myValidationController::handleValidationRequest);
  }
}