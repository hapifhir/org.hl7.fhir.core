package org.hl7.fhir.validation.cli.picocli;


import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.io.Writer;

class CLIToSlf4jLoggerWriter extends Writer {
  private final Logger logger;
  private final Level level;
  private final StringBuilder buffer = new StringBuilder();

  public CLIToSlf4jLoggerWriter(Logger logger, Level level) {
    this.logger = logger;
    this.level = level;
  }

  @Override
  public void write(char[] cbuf, int off, int len) {
    buffer.append(cbuf, off, len);
  }

  @Override
  public void flush() {

    if (buffer.isEmpty()) {
      return;
    }

    logMessage(buffer.toString());
    buffer.setLength(0); // Clear the buffer
  }

  @Override
  public void close() {
    flush(); // Ensure any buffered content is logged on close
  }

  private void logMessage(String message) {
    if (level == Level.INFO) {
      logger.info(message.trim());
    } else if (level == Level.ERROR) {
      logger.error(message.trim());
    }
  }
}
