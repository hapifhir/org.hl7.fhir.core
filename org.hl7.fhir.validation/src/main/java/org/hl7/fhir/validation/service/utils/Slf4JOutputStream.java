package org.hl7.fhir.validation.service.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;

@Slf4j
public class Slf4JOutputStream extends OutputStream {

  private StringBuilder string = new StringBuilder();

  @Override
  public void write(int b) throws IOException {
    string.append((char) b);
    if (string.toString().endsWith(System.lineSeparator())) {
      log.info(string.toString().substring(0, string.length() - System.lineSeparator().length()));
      string = new StringBuilder();
    }
  }
}
