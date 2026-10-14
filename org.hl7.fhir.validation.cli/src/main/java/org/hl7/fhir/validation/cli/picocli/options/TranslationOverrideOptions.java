package org.hl7.fhir.validation.cli.picocli.options;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.i18n.POGenerator;
import org.hl7.fhir.utilities.i18n.RuntimePOLoader;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lets a translation editor try out their .po files against an installed validator
 * without waiting for the maintainer's import/release cycle.
 * <p>
 * Filenames are expected to follow the same convention used by {@code POGenerator}:
 * {@code validator-messages-<locale>.po} feeds the {@code Messages} bundle, and
 * {@code rendering-phrases-<locale>.po} feeds the {@code rendering-phrases} bundle.
 * The same mechanism covers downstream bundles consumed by the IG Publisher (SDC, etc.)
 * provided the IG Publisher mixes this options class into its own CLI.
 * <p>
 * Setters run as picocli parses arguments. To avoid invoking the loader once per
 * flag and racing on partial state, each setter stores values; the consolidated
 * install happens via {@link #applyIfRequested()} which callers invoke after
 * parsing completes. (Picocli's {@code @ArgGroup} construction guarantees the
 * setters run before the command body executes, but not in any specific order.)
 */
@Slf4j
public class TranslationOverrideOptions {

  private final List<File> poFiles = new ArrayList<>();
  private POGenerator.StaleHandling staleHandling = POGenerator.StaleHandling.INCLUDE;
  private boolean dirty;

  @CommandLine.Option(
      names = {"-po"},
      description = "Load translations from a .po file at runtime (overrides the shipped properties for that bundle+locale). Repeatable. Filename must follow the project convention, e.g. validator-messages-de.po or rendering-phrases-pt_BR.po."
      )
  public void setPoFiles(File[] files) {
    if (files != null) {
      poFiles.addAll(Arrays.asList(files));
      dirty = true;
    }
  }

  @CommandLine.Option(
      names = {"-po-dir"},
      description = "Load every .po file under the given directory at runtime. Same naming convention as -po."
      )
  public void setPoDirectory(File dir) {
    if (dir == null) return;
    try {
      poFiles.addAll(RuntimePOLoader.expandDirectory(dir));
      dirty = true;
    } catch (IOException e) {
      throw new CommandLine.ParameterException(new CommandLine(this),
          "Cannot read --po-dir " + dir + ": " + e.getMessage(), e);
    }
  }

  @CommandLine.Option(
      names = {"-po-stale-handling"},
      description = "How to treat translations whose English source has drifted from the shipped jar. " +
                    "include (default, matches the maintainer's import): keep them. " +
                    "exclude: drop them so English is shown. " +
                    "warn: keep them and log the affected keys.",
      converter = StaleHandlingConverter.class
      )
  public void setStaleHandling(POGenerator.StaleHandling handling) {
    if (handling != null) {
      staleHandling = handling;
      dirty = true;
    }
  }

  /** Case-insensitive converter so {@code include} / {@code Include} / {@code INCLUDE} all work. */
  public static class StaleHandlingConverter implements CommandLine.ITypeConverter<POGenerator.StaleHandling> {
    @Override
    public POGenerator.StaleHandling convert(String value) {
      if (value == null) return null;
      return POGenerator.StaleHandling.valueOf(value.trim().toUpperCase());
    }
  }

  /**
   * Install the overlay if any .po sources were supplied. Safe to call when no
   * flags were passed — it's a no-op in that case.
   */
  public void applyIfRequested() {
    if (!dirty || poFiles.isEmpty()) return;
    try {
      RuntimePOLoader.install(poFiles, staleHandling);
      log.info("Runtime PO overlay installed: {} file(s), stale-handling={}",
          poFiles.size(), staleHandling);
    } catch (IOException e) {
      throw new CommandLine.ExecutionException(new CommandLine(this),
          "Failed to install PO overlay: " + e.getMessage(), e);
    }
  }

  // Visible for testing.
  List<File> getPoFiles() {
    return poFiles;
  }

  POGenerator.StaleHandling getStaleHandling() {
    return staleHandling;
  }
}
