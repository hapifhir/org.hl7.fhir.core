package org.hl7.fhir.validation.cli.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import org.apache.http.HttpStatus;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.jetbrains.annotations.NotNull;

public class CliContextController {

  private final String JSON_MIME_TYPE = "application/json";

  private CliContext myCliContext;

  public CliContextController(CliContext cliContext) {
    this.myCliContext = cliContext;
  }

  public void handleGetCurrentCliContext(@NotNull Context ctx) throws JsonProcessingException {
    ObjectMapper Obj = new ObjectMapper();
    String jsonStr = Obj.writeValueAsString(myCliContext);
    ctx.result(jsonStr).contentType(JSON_MIME_TYPE).status(HttpStatus.SC_OK);
  }

  public void handleSetCurrentCliContext(@NotNull Context ctx) {
    myCliContext = ctx.bodyAsClass(CliContext.class);
    ctx.status(HttpStatus.SC_OK);
  }
}