package org.hl7.fhir.utilities.i18n;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import lombok.extern.slf4j.Slf4j;

/**
 * Runtime loader for editor-supplied {@code .po} translation files. Lets a
 * translation editor try out their work against a built jar by passing
 * {@code --po <file>} (or {@code --po-dir <dir>}) on the CLI, without waiting
 * for the maintainer's import/release cycle.
 * <p>
 * For each supplied .po file the loader:
 * <ol>
 *   <li>Infers the target {@code (bundleBaseName, locale)} from the filename
 *       (e.g. {@code rendering-phrases-de.po} → {@code rendering-phrases} / {@code de},
 *       {@code validator-messages-pt_BR.po} → {@code Messages} / {@code pt_BR}).
 *       The {@code validator-messages-} prefix maps to {@code Messages} to match
 *       the convention used by {@link POGenerator}.</li>
 *   <li>Parses the .po via {@link POSource#loadPOFile(String)}.</li>
 *   <li>Loads the shipped English properties from the classpath, then runs
 *       {@link POGenerator#mergePOWithEnglish} to reconcile against version
 *       drift (new keys, removed keys, changed English).</li>
 *   <li>Reads plural-keyword ordering from the {@code # Whatever = one,other}
 *       header in the shipped {@code <bundle>_<locale>.properties}, falling back
 *       to the English file if the locale isn't shipped yet.</li>
 *   <li>Flattens the merged POObjects via
 *       {@link POGenerator#poObjectsToPropertiesMap} according to the chosen
 *       {@link POGenerator.StaleHandling}.</li>
 *   <li>Merges the result on top of any previously-shipped translations for the
 *       same locale, so untouched keys still come through.</li>
 * </ol>
 * Finally a {@link ResourceBundle.Control} is installed on {@link I18nBase} that
 * returns the merged bundle for known {@code (baseName, locale)} pairs and
 * delegates to the JDK default for everything else.
 * <p>
 * Same mechanism works for any downstream extender of {@link I18nBase} (the
 * IG Publisher's SDC translations, etc.) — just supply a .po with a matching
 * prefix, or use the explicit form on the CLI.
 */
@Slf4j
public class RuntimePOLoader {

  /** Maps the prefix used in PO filenames to the resource-bundle base name. */
  private static final Map<String, String> BUNDLE_PREFIX_TO_NAME;
  static {
    Map<String, String> m = new LinkedHashMap<>();
    m.put("validator-messages", "Messages");
    m.put("rendering-phrases", "rendering-phrases");
    BUNDLE_PREFIX_TO_NAME = Collections.unmodifiableMap(m);
  }

  /**
   * Parse a PO filename in the form {@code <prefix>-<locale>.po} and return the
   * bundle base name and locale tag (raw — not yet parsed by {@link Locale#forLanguageTag}).
   * The returned array is {@code [bundleBaseName, localeTag]}, or {@code null} if
   * the filename doesn't follow a known convention.
   * <p>
   * Locales in PO filenames use underscores (e.g. {@code pt_BR}) to match the
   * properties-file convention; {@link Locale} parsing accepts the same form via
   * its overloaded constructors.
   */
  static String[] parsePoFilename(String filename) {
    String base = filename;
    int slash = Math.max(base.lastIndexOf('/'), base.lastIndexOf('\\'));
    if (slash >= 0) {
      base = base.substring(slash + 1);
    }
    if (base.toLowerCase().endsWith(".po")) {
      base = base.substring(0, base.length() - 3);
    }
    for (Map.Entry<String, String> entry : BUNDLE_PREFIX_TO_NAME.entrySet()) {
      String prefix = entry.getKey() + "-";
      if (base.startsWith(prefix)) {
        String localeTag = base.substring(prefix.length());
        if (localeTag.isEmpty()) {
          return null;
        }
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //single literal character replace
        // Normalize to the underscore form used by Locale.toString() and the
        // shipped properties files (Messages_pt_BR.properties).
        String normalizedLocaleTag = localeTag.replace('-', '_');
        return new String[]{entry.getValue(), normalizedLocaleTag};
      }
    }
    return null;
  }

  static Locale localeFromTag(String tag) {
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //single literal character replace and split
    // Properties-file convention is underscore-separated (pt_BR). Locale.forLanguageTag
    // expects hyphens, so accept either.
    String[] parts = tag.replace('-', '_').split("_");
    switch (parts.length) {
      case 1: return new Locale(parts[0]);
      case 2: return new Locale(parts[0], parts[1]);
      default: return new Locale(parts[0], parts[1], parts[2]);
    }
  }

  /**
   * Read the {@code # ... = one,other} plural-keyword header line from a
   * properties resource on the classpath. Returns null if the resource doesn't
   * exist or doesn't have a header in the expected form.
   */
  static List<String> readPluralKeywords(String bundleName, String localeTag, ClassLoader loader) throws IOException {
    String[] candidates = localeTag == null || localeTag.isEmpty()
        ? new String[]{bundleName + ".properties"}
        : new String[]{bundleName + "_" + localeTag + ".properties", bundleName + ".properties"};
    for (String candidate : candidates) {
      try (InputStream in = loader.getResourceAsStream(candidate)) {
        if (in == null) continue;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
          String first = r.readLine();
          if (first != null && first.startsWith("#") && first.contains("=")) {
            @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
            //single literal character replace
            String[] parts = first.substring(1).trim().split("=", 2);
            if (parts.length == 2) {
              List<String> out = new ArrayList<>();
              @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
              //single literal character replace
              String[] split = parts[1].split(",");
              for (String s : split) {
                String t = s.trim();
                if (!t.isEmpty()) out.add(t);
              }
              if (!out.isEmpty()) return out;
            }
          }
        }
      }
    }
    return null;
  }

  /**
   * Load the shipped properties for the given (bundle, locale) directly as a
   * {@code key -> value} map. Returns an empty map if the resource is absent.
   * <p>
   * Unlike {@link ResourceBundle#getBundle} this does <em>not</em> walk the
   * locale fallback chain — we only want the keys that were explicitly
   * translated for this locale, so that the overlay merge result reflects
   * "keys translated previously" vs "untouched keys" cleanly.
   */
  static Map<String, String> loadShippedPropertiesFlat(String bundleName, String localeTag, ClassLoader loader) throws IOException {
    String resource = localeTag == null || localeTag.isEmpty()
        ? bundleName + ".properties"
        : bundleName + "_" + localeTag + ".properties";
    Map<String, String> out = new LinkedHashMap<>();
    try (InputStream in = loader.getResourceAsStream(resource)) {
      if (in == null) return out;
      try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
        for (String line = r.readLine(); line != null; line = r.readLine()) {
          if (line.startsWith("#") || !line.contains("=")) continue;
          int eq = line.indexOf('=');
          String k = line.substring(0, eq).trim();
          String v = line.substring(eq + 1).trim();
          out.put(k, v);
        }
      }
    }
    return out;
  }

  /**
   * Load English properties as {@link POGenerator.PropertyValue}s, suitable for
   * passing to {@link POGenerator#mergePOWithEnglish}.
   */
  static List<POGenerator.PropertyValue> loadEnglishProperties(String bundleName, ClassLoader loader) throws IOException {
    String resource = bundleName + ".properties";
    try (InputStream in = loader.getResourceAsStream(resource)) {
      if (in == null) {
        throw new IOException("No shipped English properties found for bundle '" + bundleName
            + "' (expected classpath resource " + resource + ")");
      }
      try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
        return POGenerator.loadProperties(r, false);
      }
    }
  }

  /**
   * Build the effective overlay map for one .po file: shipped translations as a
   * baseline, with the editor's reconciled .po translations layered on top.
   */
  static Map<String, String> buildOverlayMap(POSource po, String bundleName, String localeTag,
                                             POGenerator.StaleHandling staleHandling,
                                             ClassLoader loader) throws IOException {
    List<POGenerator.PropertyValue> english = loadEnglishProperties(bundleName, loader);
    POGenerator.mergePOWithEnglish(po, english);

    List<String> pluralKeywords = readPluralKeywords(bundleName, localeTag, loader);
    if (pluralKeywords == null) {
      // The shipped properties don't have a header for this locale. Use English's header
      // as a best-effort fallback (most plurals in this codebase are English-style one/other).
      pluralKeywords = readPluralKeywords(bundleName, null, loader);
    }
    if (pluralKeywords == null) {
      pluralKeywords = new ArrayList<>();
      pluralKeywords.add("one");
      pluralKeywords.add("other");
    }

    List<String> staleKeys = staleHandling == POGenerator.StaleHandling.WARN ? new ArrayList<>() : null;
    Map<String, String> poTranslations = POGenerator.poObjectsToPropertiesMap(
        po.getPOObjects(), pluralKeywords, staleHandling, staleKeys);

    if (staleKeys != null && !staleKeys.isEmpty()) {
      log.warn("PO overlay for {} ({}): {} translation(s) have stale English source: {}",
          bundleName, localeTag, staleKeys.size(), staleKeys);
    }

    // Layer: shipped translations as baseline, .po translations win on conflict.
    Map<String, String> effective = new LinkedHashMap<>(loadShippedPropertiesFlat(bundleName, localeTag, loader));
    effective.putAll(poTranslations);
    return effective;
  }

  /**
   * Install (or replace) an overlay built from the supplied .po files. Pass an
   * empty list to clear any existing overlay.
   */
  public static void install(List<File> poFiles, POGenerator.StaleHandling staleHandling) throws IOException {
    install(poFiles, staleHandling, RuntimePOLoader.class.getClassLoader());
  }

  /**
   * Same as {@link #install(List, POGenerator.StaleHandling)} but allows callers
   * to specify the classloader used to look up shipped resources (useful in tests).
   */
  public static void install(List<File> poFiles, POGenerator.StaleHandling staleHandling, ClassLoader loader) throws IOException {
    if (poFiles == null || poFiles.isEmpty()) {
      I18nBase.setOverlayControl(null);
      return;
    }
    if (staleHandling == null) {
      staleHandling = POGenerator.StaleHandling.INCLUDE;
    }

    Map<String, Map<String, String>> registry = new HashMap<>();
    for (File f : poFiles) {
      String[] parsed = parsePoFilename(f.getName());
      if (parsed == null) {
        log.warn("Skipping {}: filename doesn't match a known PO convention (expected validator-messages-<locale>.po or rendering-phrases-<locale>.po)", f.getName());
        continue;
      }
      String bundleName = parsed[0];
      String localeTag = parsed[1];
      POSource po = POSource.loadPOFile(f.getAbsolutePath());
      Map<String, String> overlay = buildOverlayMap(po, bundleName, localeTag, staleHandling, loader);
      registry.put(registryKey(bundleName, localeTag), overlay);
      log.info("Loaded PO overlay for bundle '{}' locale '{}' from {} ({} keys)",
          bundleName, localeTag, f.getName(), overlay.size());
    }

    I18nBase.setOverlayControl(new OverlayControl(registry));
  }

  /**
   * Expand a directory of .po files into a list suitable for {@link #install}.
   */
  public static List<File> expandDirectory(File dir) throws IOException {
    if (!dir.isDirectory()) {
      throw new IOException("Not a directory: " + dir);
    }
    List<File> out = new ArrayList<>();
    try (java.util.stream.Stream<java.nio.file.Path> stream = Files.list(dir.toPath())) {
      stream.filter(p -> p.toString().toLowerCase().endsWith(".po"))
            .forEach(p -> out.add(p.toFile()));
    }
    Collections.sort(out);
    return out;
  }

  private static String registryKey(String bundleName, String localeTag) {
    return bundleName + "::" + localeTag;
  }

  /**
   * {@link ResourceBundle.Control} that consults the in-memory overlay registry
   * for {@code (baseName, locale)} pairs we know about, and delegates to the
   * default Control otherwise. Returned bundles have the JDK's normal parent
   * chain (root English) so untranslated keys still fall back to English.
   */
  static final class OverlayControl extends ResourceBundle.Control {
    private final Map<String, Map<String, String>> registry;
    private final ResourceBundle.Control delegate = ResourceBundle.Control.getControl(FORMAT_DEFAULT);

    OverlayControl(Map<String, Map<String, String>> registry) {
      this.registry = registry;
    }

    @Override
    public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
        throws IllegalAccessException, InstantiationException, IOException {
      String key = registryKey(baseName, locale.toString());
      Map<String, String> entries = registry.get(key);
      if (entries != null) {
        return new MapResourceBundle(entries);
      }
      return delegate.newBundle(baseName, locale, format, loader, reload);
    }

    @Override
    public List<String> getFormats(String baseName) {
      return FORMAT_DEFAULT;
    }

    @Override
    public Locale getFallbackLocale(String baseName, Locale locale) {
      // Don't fall back to Locale.getDefault() — we want the JDK's standard
      // candidate-locale walk (locale → root) so root English remains the parent.
      return null;
    }
  }

  /**
   * {@link ResourceBundle} backed by an in-memory map. The JDK's
   * {@code ResourceBundle.getBundle} wires up the parent chain to root English
   * automatically, so unknown keys fall through to {@code <bundle>.properties}.
   */
  static final class MapResourceBundle extends ResourceBundle {
    private final Map<String, String> map;

    MapResourceBundle(Map<String, String> map) {
      this.map = map;
    }

    @Override
    protected Object handleGetObject(String key) {
      return map.get(key);
    }

    @Override
    public Enumeration<String> getKeys() {
      Set<String> keys = new TreeSet<>(map.keySet());
      if (parent != null) {
        Enumeration<String> parentKeys = parent.getKeys();
        while (parentKeys.hasMoreElements()) {
          keys.add(parentKeys.nextElement());
        }
      }
      return Collections.enumeration(keys);
    }

    @Override
    protected Set<String> handleKeySet() {
      return new java.util.HashSet<>(map.keySet());
    }
  }
}
