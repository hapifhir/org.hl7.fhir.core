package org.hl7.fhir.validation.cli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.apache.http.HttpStatus;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.ValidationRequest;
import org.hl7.fhir.validation.cli.model.ValidationResponse;
import org.hl7.fhir.validation.cli.services.ValidationService;

public class ValidationController {

  private ValidationEngine myValidationEngine;

  public ValidationController(ValidationEngine validationEngine) {
    this.myValidationEngine = validationEngine;
  }

  public void handleValidationRequest(Context ctx) {
    ValidationRequest request = ctx.bodyAsClass(ValidationRequest.class);
    ValidationResponse response = null;
    try {
      response = ValidationService.validateSources(request, myValidationEngine);
      ObjectMapper Obj = new ObjectMapper();
      /*
       * TODO
       * Write file contents to temp files to pass to validator instead of creating our own endpoint.
       * Create File => new temp file
       * Use Option => DeleteOnShutdown
       */
      String jsonStr = Obj.writeValueAsString(response);
      ctx.status(200).json(jsonStr);
    } catch (Exception e) {
      ctx.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).result(e.getLocalizedMessage());
    }
  }
}