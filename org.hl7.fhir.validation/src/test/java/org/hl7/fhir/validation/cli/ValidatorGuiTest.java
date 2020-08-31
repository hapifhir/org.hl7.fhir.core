package org.hl7.fhir.validation.cli;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.model.FileInfo;
import org.hl7.fhir.validation.cli.model.ValidationRequest;
import org.hl7.fhir.validation.cli.model.ValidationResponse;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;

class ValidatorGuiTest {

  private static final String DEF_TX = "http://tx.fhir.org";
  private final String HTML_TITLE_TAG = "<title>FHIR HL7 Resrouce Validator GUI</title>";

  @Test
  @DisplayName("Page boots correctly, and displays index.html")
  public void UI_contains_correct_heading() throws IOException {
    ValidatorGui.start(new CliContext(), null, false);
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--disable-gpu");
    WebDriver driver = new ChromeDriver(options);
    driver.get("http://localhost:" + ValidatorGui.getPort() + "/home");

    Assertions.assertTrue(driver.getPageSource().contains(HTML_TITLE_TAG));
    driver.quit();
    ValidatorGui.stop();
  }
}