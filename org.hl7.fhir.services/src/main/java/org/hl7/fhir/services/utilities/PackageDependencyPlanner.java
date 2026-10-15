package org.hl7.fhir.services.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.ImplementationGuide;
import org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;

final class PackageDependencyPlanner {

  private PackageDependencyPlanner() {
  }

  static final class Entry {
    private final String name;
    private final String value;

    Entry(String name, String value) {
      this.name = name;
      this.value = value;
    }

    String getName() {
      return name;
    }

    String getValue() {
      return value;
    }
  }

  static final class Result {
    private final boolean hasDependencies;
    private final List<Entry> entries;
    private final List<String> warnings;

    Result(boolean hasDependencies, List<Entry> entries, List<String> warnings) {
      this.hasDependencies = hasDependencies;
      this.entries = List.copyOf(entries);
      this.warnings = List.copyOf(warnings);
    }

    boolean hasDependencies() {
      return hasDependencies;
    }

    List<Entry> getEntries() {
      return entries;
    }

    List<String> getWarnings() {
      return warnings;
    }
  }

  private static final class Declaration {
    private final int index;
    private final String packageId;
    private final String version;
    private final String uri;
    private final String key;
    private final boolean hasPackageId;
    private final boolean hasVersion;
    private final boolean hasUri;
    private final boolean aliased;
    private final boolean suppressed;

    private Declaration(int index, ImplementationGuideDependsOnComponent d) {
      this.index = index;
      packageId = d.getPackageId();
      version = d.getVersion();
      uri = d.getUri();
      String id = d.getId();
      hasPackageId = d.hasPackageId();
      hasVersion = d.hasVersion();
      hasUri = d.hasUri();
      Base[] storedPackageId = d.getNamedValue("packageId", false);
      aliased = storedPackageId.length != 0 && storedPackageId[0].hasUserData(UserDataNames.IG_DEP_ALIASED);
      suppressed = d.hasExtension(ExtensionDefinitions.EXT_IGDEP_NO_SAVE);
      key = aliased ? id + "@npm:" + packageId : packageId;
    }
  }

  static Result plan(ImplementationGuide ig, List<String> fhirVersions, PackageType kind) {
    String guidePackageId = ig.getPackageId();
    List<Declaration> declarations = new ArrayList<>();
    Set<String> coreAuthorIntent = new HashSet<>();
    Set<String> persistedVersionedPackageIds = new HashSet<>();
    // Stored-node traversal keeps empty declarations and does not install absent lists/elements.
    // Ordinary scalar/presence reads retain the model's existing IdType lazy-cache behavior.
    Base[] dependsOn = ig.getNamedValue("dependsOn", false);
    for (int i = 0; i < dependsOn.length; i++) {
      Declaration d = new Declaration(i, (ImplementationGuideDependsOnComponent) dependsOn[i]);
      declarations.add(d);
      if (!d.aliased) {
        if (d.hasVersion || d.suppressed) {
          coreAuthorIntent.add(d.packageId);
        }
        if (d.hasVersion && !d.suppressed) {
          persistedVersionedPackageIds.add(d.packageId);
        }
      }
    }

    boolean hasDependencies = kind != PackageType.CORE;
    List<Entry> entries = new ArrayList<>();
    List<String> warnings = new ArrayList<>();
    Set<String> emitted = new HashSet<>();
    if (hasDependencies) {
      for (String version : fhirVersions) {
        String packageId = packageForVersion(version);
        if (packageId != null && !coreAuthorIntent.contains(packageId) && emitted.add(packageId)) {
          entries.add(new Entry(packageId, version));
        }
      }
    }
    for (Declaration d : declarations) {
      if (d.suppressed) {
        continue;
      }
      if (!d.hasVersion) {
        warnings.add(missingVersionMessage(guidePackageId, d));
      }
      if (hasDependencies) {
        if (d.hasVersion) {
          // Complete declarations, including invalid names and collisions, retain strict JSON behavior.
          entries.add(new Entry(d.key, d.version));
          emitted.add(d.key);
        } else if (d.hasPackageId && !emitted.contains(d.key) && !persistedVersionedPackageIds.contains(d.key)) {
          entries.add(new Entry(d.key, null));
          emitted.add(d.key);
        }
      }
    }
    return new Result(hasDependencies, entries, warnings);
  }

  private static String missingVersionMessage(String guidePackageId, Declaration d) {
    StringBuilder message = new StringBuilder("Implementation guide ");
    message.append(guidePackageId == null ? "(packageId not specified)" : guidePackageId);
    message.append(" dependsOn[").append(d.index).append("]");
    if (d.hasPackageId && d.packageId != null) {
      message.append(" packageId=").append(d.packageId);
    }
    if (d.hasUri && d.uri != null) {
      message.append(" uri=").append(d.uri);
    }
    return message.append(" is missing a version; specify dependsOn.version.").toString();
  }

  // Mirror org.hl7.fhir.r5/.../utils/NPMPackageGenerator.java's private version policy.
  // Services PackageDependencyPlannerTest pins its raw values, exclusions and permissive fallbacks.
  private static final Map<String, List<String>> CORE_PACKAGE_VERSION_PREFIXES = Map.of(
      "hl7.fhir.r2.core", List.of("1.0"),
      "hl7.fhir.r2b.core", List.of("1.4"),
      "hl7.fhir.r3.core", List.of("3.0"),
      "hl7.fhir.r4.core", List.of("4.0"),
      "hl7.fhir.r4b.core", List.of("4.1", "4.3"),
      "hl7.fhir.r5.core", List.of("4.5", "5.0"),
      "hl7.fhir.r6.core", List.of("6.0"));

  private static final String CI_BUILD_LABEL = "cibuild";

  private static boolean isPublishableVersion(String v) {
    int cut = labelStart(v);
    String numeric = cut < 0 ? v : v.substring(0, cut);
    // Preserve trailing empty segments: "5.0.0." must not pass as a legacy build code.
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    // Fixed literal-dot pattern, no user-supplied regex.
    String[] parts = numeric.split("\\.", -1);
    if (parts.length < 3) {
      return false;
    }
    for (String p : parts) {
      if (!Utilities.isInteger(p)) {
        return false;
      }
    }
    return !hasCiBuildLabel(v);
  }

  private static int labelStart(String v) {
    for (int i = 0; i < v.length(); i++) {
      char c = v.charAt(i);
      if (c == '-' || c == '+') {
        return i;
      }
    }
    return -1;
  }

  private static boolean hasCiBuildLabel(String v) {
    int cut = labelStart(v);
    return cut >= 0 && v.substring(cut + 1).toLowerCase(Locale.ROOT).startsWith(CI_BUILD_LABEL);
  }

  private static boolean isResolvableWildcardVersion(String v) {
    return VersionUtilities.versionHasWildcards(v)
        && VersionUtilities.isSemVerWithWildcards(v)
        && !hasCiBuildLabel(v);
  }

  private static boolean versionIsInPackageFamily(String packageId, String v) {
    List<String> prefixes = CORE_PACKAGE_VERSION_PREFIXES.get(packageId);
    if (prefixes == null) {
      return false;
    }
    for (String prefix : prefixes) {
      if (v.startsWith(prefix)) {
        return true;
      }
    }
    return false;
  }

  private static String packageFromVersionPrefix(String v) {
    for (Map.Entry<String, List<String>> e : CORE_PACKAGE_VERSION_PREFIXES.entrySet()) {
      for (String prefix : e.getValue()) {
        if (v.startsWith(prefix)) {
          return e.getKey();
        }
      }
    }
    return null;
  }

  private static String packageForVersion(String v) {
    if (v == null || "current".equals(v)) {
      return null;
    }
    if (!isPublishableVersion(v) && !isResolvableWildcardVersion(v)) {
      return null;
    }
    try {
      String vp = VersionUtilities.packageForVersion(v);
      return vp != null && versionIsInPackageFamily(vp, v) ? vp : null;
    } catch (FHIRException e) {
      // Retain historical four-part versions and the R5 policy's permissive malformed-label fallback.
      return packageFromVersionPrefix(v);
    }
  }
}
