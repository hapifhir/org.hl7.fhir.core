package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

/**
 * Loads an {@link NpmPackage} from a folder or a {@code .tgz} file, walks every
 * file in the {@code package/} folder, and writes a single text file containing
 * each resource as pretty-printed JSON with the top-level {@code meta} and
 * {@code date} properties stripped.
 *
 * <p>Each resource block in the output is preceded by a header line giving the
 * filename, so the result is easy to diff and easy to navigate.
 */
@SuppressWarnings("checkstyle:systemout")
//This is a standalone executable class; it is omitted from CLI logging requirements (SLF4J)
public class NpmPackageDumper {

  /** Separator written before each resource. */
  private static final String SEPARATOR = "================================================================";

  /**
   * Dump the contents of the package at {@code packageSource} into a single
   * text file at {@code outputFile}. {@code packageSource} may be either an
   * extracted package folder or a {@code .tgz} package file.
   */
  public static void dump(String packageSource, String outputFile) throws IOException {
    File f = new File(packageSource);
    if (!f.exists()) {
      throw new IOException("Package source not found: " + packageSource);
    }
    NpmPackage npm;
    if (f.isDirectory()) {
      npm = NpmPackage.fromFolder(packageSource);
    } else {
      try (InputStream is = Files.newInputStream(f.toPath())) {
        npm = NpmPackage.fromPackage(is);
      }
    }
    dump(npm, outputFile);
  }

  /**
   * Dump the contents of an already-loaded {@link NpmPackage} to a single text
   * file. Every file in the package's {@code package/} folder that parses as
   * JSON is included; non-JSON files are skipped.
   */
  public static void dump(NpmPackage npm, String outputFile) throws IOException {
    StringBuilder out = new StringBuilder();

    List<String> files = npm.list("package");
    java.util.Collections.sort(files);

    int included = 0;
    int skipped = 0;
    for (String file : files) {
      byte[] bytes;
      try (InputStream is = npm.load("package", file)) {
        bytes = readAllBytes(is);
      }

      JsonObject json;
      try {
        json = JsonParser.parseObject(bytes);
      } catch (Exception e) {
        // Not a JSON file (or not parseable) - skip it.
        skipped++;
        continue;
      }

      // Strip $.meta and $.date from the top of the resource.
      json.remove("meta");
      json.remove("date");
      json.remove("text");
      json.remove("snapshot");
      json.remove("status");
      json.remove("version");
      json.remove("experimental");
      json.remove("extension");
      json.remove("context");

      out.append(SEPARATOR).append(System.lineSeparator());
      out.append("// ").append(file).append(System.lineSeparator());
      out.append(SEPARATOR).append(System.lineSeparator());
      out.append(JsonParser.compose(json, true));
      // compose(..., true) already appends a trailing line break, but make sure
      // there's a blank line between resources for readability.
      out.append(System.lineSeparator());
      included++;
    }

    Files.write(Paths.get(outputFile), out.toString().getBytes(StandardCharsets.UTF_8));

    System.out.println("Wrote " + included + " resource(s) to " + outputFile
      + " (" + skipped + " non-JSON file(s) skipped).");
  }

  private static byte[] readAllBytes(InputStream is) throws IOException {
    java.io.ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream();
    byte[] chunk = new byte[8192];
    int n;
    while ((n = is.read(chunk)) != -1) {
      buf.write(chunk, 0, n);
    }
    return buf.toByteArray();
  }

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.err.println("Usage: NpmPackageDumper <package-folder-or-tgz> <output-file>");
      System.exit(1);
    }
    dump(args[0], args[1]);
  }
}