package org.hl7.fhir.validation.cli.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.javalin.http.Context;

class HttpPutContextTest {

  public CliContextController myCliContextController;

  public HttpPutContextTest() {
    this.myCliContextController = new CliContextController(null);
  }
  
  @Disabled
  @Test
  void handleSetCurrentCliContext() {
    Context context = mock(Context.class);
    this.myCliContextController.handleSetCurrentCliContext(context);
    verify(context).status(200);
  }
}