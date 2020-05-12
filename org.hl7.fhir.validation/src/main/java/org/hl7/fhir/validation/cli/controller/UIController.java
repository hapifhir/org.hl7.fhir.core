package org.hl7.fhir.validation.cli.controller;

import io.javalin.http.Handler;

public class UIController {

  public UIController() {}

  public Handler renderLandingPage = ctx -> {
    ctx.render("/public/index.html");
  };

}