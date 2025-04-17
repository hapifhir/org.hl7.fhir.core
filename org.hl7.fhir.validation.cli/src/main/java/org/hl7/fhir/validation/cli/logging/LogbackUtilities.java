package org.hl7.fhir.validation.cli.logging;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class LogbackUtilities {

  public static void setLogLevel(ch.qos.logback.classic.Level level)
  {
    ch.qos.logback.classic.Logger root = getRootLogger();
    root.setLevel(level);
  }

  public static ch.qos.logback.classic.Level toLevel (Level level){
    return ch.qos.logback.classic.Level.toLevel(level.toString());
  }

  private static Logger getRootLogger() {
    return (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
  }

  public static void setLogToFile(String path) {
    ch.qos.logback.classic.Logger root = getRootLogger();

    if (root.getAppender("FILE") != null) {
      root.detachAppender("FILE");
    }

    PatternLayoutEncoder encoder = new PatternLayoutEncoder();
    encoder.setContext(root.getLoggerContext());
    encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %marker %logger{36} [%file:%line] %msg%n");
    encoder.start();

    FileAppender<ILoggingEvent> fileAppender = new FileAppender<>();
    fileAppender.setContext(root.getLoggerContext());
    fileAppender.setAppend(false);
    fileAppender.setImmediateFlush(true);
    fileAppender.setFile(path);
    fileAppender.setEncoder(encoder);
    fileAppender.setName("FILE");
    fileAppender.start();

    root.addAppender(fileAppender);
  }

  public static void setLogToFileAndConsole(Level level, String path) {
    setLogLevel(toLevel(level));
    setLogToFile(path);
  }

  public static void setLogbackConfig(InputStream configStream) throws JoranException, IOException {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    loggerContext.reset();
    JoranConfigurator configurator = new JoranConfigurator();
    configurator.setContext(loggerContext);
    configurator.doConfigure(configStream);// loads logback file
    assert configStream != null;
    configStream.close();
  }
}
