package org.hl7.fhir.validation.cli.controller;

import io.javalin.http.Context;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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