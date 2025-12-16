package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.i18n.POGenerator;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Internal development command for Java internationalization (i18n) regeneration.
 *
 * This hidden command manages translation files across three FHIR-related repositories,
 * validates and synchronizes i18n constants across Java properties files and code constants,
 * and generates/updates .po (Portable Object) translation source files.
 *
 * @deprecated This is an internal development tool, not meant for general CLI usage.
 *             Use at your own risk. Marked as deprecated to discourage external use.
 * @since 2025-12-16
 */
@Slf4j
@Deprecated(since = "2025-12-16")
@CommandLine.Command(
  name = "lang-regen",
  description = """
    (Internal Development Tool) Java internationalization (i18n) regeneration.

    Validates and synchronizes i18n constants across Java properties files and code constants,
    then generates/updates .po translation source files for three FHIR repositories.

    This command is hidden - it is an internal tool for FHIR core developers only.
    """,
  hidden = true
)
public class LangRegenerateCommand extends ValidationServiceCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    index = "0",
    description = "Path to local copy of FHIR HAPI core repository (https://github.com/hapifhir/org.hl7.fhir.core)"
  )
  private String corePath;

  @CommandLine.Parameters(
    index = "1",
    description = "Path to local copy of IG Publisher repository (https://github.com/HL7/fhir-ig-publisher)"
  )
  private String igpubPath;

  @CommandLine.Parameters(
    index = "2",
    description = "Path to local copy of Pascal FHIR Server repository (https://github.com/HealthIntersections/fhirserver)"
  )
  private String pascalPath;

  @Override
  public Integer call() {
    try {
      validatePaths();

      log.info("Executing language regeneration with POGenerator");
      log.info("  Core: " + corePath);
      log.info("  IGPub: " + igpubPath);
      log.info("  Pascal: " + pascalPath);

      new POGenerator().execute(corePath, igpubPath, pascalPath);

      log.info("Language regeneration completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error performing language regeneration", e);
      return 1;
    }
  }

  private void validatePaths() throws IOException {
    validatePath(corePath, "FHIR HAPI core", "https://github.com/hapifhir/org.hl7.fhir.core");
    validatePath(igpubPath, "IG Publisher", "https://github.com/HL7/fhir-ig-publisher");
    validatePath(pascalPath, "Pascal FHIR Server", "https://github.com/HealthIntersections/fhirserver");
  }

  private void validatePath(String path, String repoName, String repoUrl) throws IOException {
    File file = ManagedFileAccess.file(path);
    if (!file.exists()) {
      String message = String.format(
        "Path does not exist for %s repository: %s%n" +
        "Expected local clone of %s at: %s",
        repoName, path, repoUrl, path
      );
      throw new IOException(message);
    }
    if (!file.isDirectory()) {
      String message = String.format(
        "Path is not a directory for %s repository: %s",
        repoName, path
      );
      throw new IOException(message);
    }
    log.info("Validated {} repository path: {}", repoName, path);
  }
}
