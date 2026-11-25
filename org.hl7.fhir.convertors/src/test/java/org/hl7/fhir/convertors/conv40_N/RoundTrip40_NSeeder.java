package org.hl7.fhir.convertors.conv40_N;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Populates the resource folders used by {@link RoundTrip40_NTest} from the examples of the two
 * specifications. Not a test - run it by hand when the examples change:
 * <pre>
 *   RoundTrip40_NSeeder r4 ~/.fhir/packages/hl7.fhir.r4.examples#4.0.1/package
 *   RoundTrip40_NSeeder r6 [r6 publish folder]/examples-json.zip
 * </pre>
 * (the source can be a folder or a zip of json files). An optional third parameter is the
 * roundtrip40_N folder; the default is conversion/roundtrip40_N in the local fhir-test-cases checkout.
 * <p>
 * Each example is parsed and re-composed (so resource/ is in the same format as converted/ and returned/,
 * and folder diffs only show real differences), and written to [version]/resource. Examples are left out
 * if they can't be parsed, if the convertors say they don't handle them (including Bundles with entries
 * they don't handle), or if they're too big or are the specification's own definitions (non-example
 * StructureDefinitions, SearchParameters, CodeSystems and ValueSets) - there's thousands of those, and
 * the test resources would be several hundred MB.
 * <p>
 * Existing files are overwritten; files are never deleted, so to drop a case, delete its files by hand.
 */
public class RoundTrip40_NSeeder {

  private static final Logger log = LoggerFactory.getLogger(RoundTrip40_NSeeder.class);

  private static final long MAX_SIZE = 1_000_000;
  private static final Set<String> DEFINITION_TYPES = Set.of("StructureDefinition", "SearchParameter", "CodeSystem", "ValueSet");

  private int added;
  private final TreeMap<String, String> skipped = new TreeMap<>();

  public static void main(String[] args) throws IOException {
    if (args.length < 2 || !(args[0].equals("r4") || args[0].equals("r6"))) {
      log.info("Usage: RoundTrip40_NSeeder r4|r6 [source folder or zip] [roundtrip40_N folder]");
      return;
    }
    Path target = (args.length > 2 ? Paths.get(args[2]) : RoundTrip40_NTest.root()).resolve(args[0]).resolve("resource");
    Files.createDirectories(target);
    new RoundTrip40_NSeeder().seed(args[0].equals("r4"), Paths.get(args[1]), target);
  }

  private void seed(boolean r4, Path source, Path target) throws IOException {
    if (Files.isDirectory(source)) {
      try (Stream<Path> files = Files.list(source)) {
        for (Path f : (Iterable<Path>) files.sorted()::iterator) {
          String name = f.getFileName().toString();
          if (name.endsWith(".json") && !name.startsWith(".")) {
            process(r4, name, Files.size(f), Files.readAllBytes(f), target);
          }
        }
      }
    } else {
      try (ZipFile zip = new ZipFile(source.toFile())) {
        TreeMap<String, ZipEntry> entries = new TreeMap<>();
        for (Enumeration<? extends ZipEntry> e = zip.entries(); e.hasMoreElements(); ) {
          ZipEntry ze = e.nextElement();
          if (!ze.isDirectory() && ze.getName().endsWith(".json") && !ze.getName().contains("/")) {
            entries.put(ze.getName(), ze);
          }
        }
        for (ZipEntry ze : entries.values()) {
          try (InputStream in = zip.getInputStream(ze)) {
            process(r4, ze.getName(), ze.getSize(), in.readAllBytes(), target);
          }
        }
      }
    }
    log.info("Added {}, skipped {}", added, skipped.size());
    skipped.forEach((n, r) -> log.info("  {}: {}", n, r));
  }

  private void process(boolean r4, String name, long size, byte[] content, Path target) {
    if (size > MAX_SIZE) {
      skipped.put(name, "too big");
      return;
    }
    try {
      String type;
      String json;
      if (r4) {
        org.hl7.fhir.r4.model.Resource res = RoundTrip40_NTest.r4Parser().parse(content);
        type = res.fhirType();
        if (isDefinition(type, name)) {
          return;
        }
        json = RoundTrip40_NTest.r4Parser().composeString(res);
        if (!convertible(() -> VersionConvertorFactory_40_N.convertResource(res), name)) {
          return;
        }
      } else {
        org.hl7.fhir.model.core.Resource res = RoundTrip40_NTest.r6Parser().parse(content);
        type = res.fhirType();
        if (isDefinition(type, name)) {
          return;
        }
        json = RoundTrip40_NTest.r6Parser().composeString(res);
        if (!convertible(() -> VersionConvertorFactory_40_N.convertResource(res), name)) {
          return;
        }
      }
      Files.write(target.resolve(name), json.getBytes(StandardCharsets.UTF_8));
      added++;
    } catch (Exception e) {
      skipped.put(name, "can't parse: " + e.getMessage());
    }
  }

  private boolean isDefinition(String type, String name) {
    return DEFINITION_TYPES.contains(type) && !name.toLowerCase().contains("example");
  }

  /**
   * other errors are kept: they're things the test should report
   */
  private boolean convertible(Runnable conversion, String name) {
    try {
      conversion.run();
    } catch (Throwable e) {
      // the convertors throw Errors as well as Exceptions
      if (e instanceof Exception && RoundTrip40_NTest.isUnsupported((Exception) e)) {
        skipped.put(name, "not supported: " + e.getMessage());
        return false;
      }
    }
    return true;
  }
}
