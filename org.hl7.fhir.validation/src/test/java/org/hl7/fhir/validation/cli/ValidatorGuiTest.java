package org.hl7.fhir.validation.cli;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

class ValidatorGuiTest {

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