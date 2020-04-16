package org.hl7.fhir.validation.cli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;
import org.apache.http.HttpStatus;
import org.hl7.fhir.validation.cli.model.CliContext;

public class CliContextController {

  private CliContext myCliContext;

  public CliContextController(CliContext cliContext) {
    this.myCliContext = cliContext;
  }

  public Handler getCurrentCliContext = ctx -> {
    ObjectMapper Obj = new ObjectMapper();
    String jsonStr = Obj.writeValueAsString(myCliContext);
    ctx.result(jsonStr);
  };

  public Handler setCurrentCliContext = ctx -> {
    myCliContext = ctx.bodyAsClass(CliContext.class);
    ctx.status(HttpStatus.SC_CREATED);
  };

}
