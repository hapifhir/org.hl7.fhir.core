package org.hl7.fhir.validation.cli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.ValidationRequest;
import org.hl7.fhir.validation.cli.model.ValidationResponse;
import org.hl7.fhir.validation.cli.services.ValidationService;

public class ValidationController {

  private ValidationEngine myValidationEngine;

  public ValidationController(ValidationEngine validationEngine) {
    this.myValidationEngine = validationEngine;
  }

  public Handler handleValidationRequest = ctx -> {
    ValidationRequest request = ctx.bodyAsClass(ValidationRequest.class);
    ValidationResponse response = ValidationService.validateSources(request, myValidationEngine);

//      File new temp file
//      DeleteOnShutdown

      ObjectMapper Obj = new ObjectMapper();
      String jsonStr = Obj.writeValueAsString(response);

      ctx.status(200).json(jsonStr);
  };

}
