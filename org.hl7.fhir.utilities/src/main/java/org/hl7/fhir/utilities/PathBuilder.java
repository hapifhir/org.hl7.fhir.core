package org.hl7.fhir.utilities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hl7.fhir.utilities.settings.FhirSettings;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.With;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PathBuilder {

  /**
   * By default, the normalized built path must be a child of the first entry of the buildPath arguments. If a
   * different parent is desired, this can be set via <code>withRequiredTarget</code>
   */
  @With
  private final String requiredTarget;

  /**
   * By default, the first entry of the buildPath argument cannot be null or an empty string. Setting this to false will
   * disable this check.
   */
  @With
  private final boolean requireNonNullNonEmptyFirstEntry;

  /**
   * By default, the first entry of the buildPath argument cannot be a root directory (<code>"/", "C:\", etc. </code>. Setting this to false will disable this check.
   */
  @With
  private final boolean requireNonRootFirstEntry;

  /**
   * By default, the normalized built path must be a child of the first entry of the buildPath arguments. Setting this
   * to false will disable this check.
   */
  @With
  private final boolean requirePathIsChildOfTarget;

  /**
   * Returns an instance of PathBuilder with all checks enabled (recommended).
   *
   * @return
   */
  public static PathBuilder getPathBuilder() {
    return new PathBuilder(null, true, true, true);
  }

  /**
   * <p>Builds a path from the passed argument strings. This path will be compatible with the local filesystem.
   * </p>
   *
   * <p>
   * If the args contain variables enclosed in square brackets (<code>[ ]</code>), they will be replaced with values in
   * the built path. There are several built-in variables available, listed below. Any text between square brackets that
   * does not match these will be replaced by a matching System environment variable if one is available.
   * </p>
   *
   * <p>
   * Built-in variables include:
   * <ul>
   *  <li><i>[tmp]</i> An available temp directory (Java Temp directory, <code>c:\\temp, $TMPDIR, %TEMP%</code>, etc.) </li>
   *  <li><i>[user]</i> The OS user directory (~, user.home, etc) </li>
   * </ul>
   * </p>
   *
   * <p>
   * This method will run several checks by default to ensure that the built path does not point to unintended areas of
   * the filesystem. If these checks are violated, a RuntimeException will be thrown. If needed in special cases, the
   * behavior of these checks can be modified via the linked fluent constructor methods below.
   * </p>
   *
   * @param args entries with which to construct the filesystem path
   * @throws RuntimeException
   * @return a local filesystem path
   *
   * @see this#withRequiredTarget(String)
   * @see this#withRequireNonNullNonEmptyFirstEntry(boolean)
   * @see this#withRequireNonRootFirstEntry(boolean)
   * @see this#withRequirePathIsChildOfTarget(boolean)
   */
  public String buildPath(String... args) {

    checkNonNullNonEmptyFirstEntry(args);
    checkNonRootFirstEntry(args);

    StringBuilder stringBuilder = new StringBuilder();
    boolean argIsNotEmptyOrNull = false;

    boolean first = true;
    for (String arg : args) {
      if (first && arg == null)
        continue;
      first = false;
      if (!argIsNotEmptyOrNull)
        argIsNotEmptyOrNull = !Utilities.noString(arg);
      else if (!stringBuilder.toString().endsWith(File.separator))
        stringBuilder.append(File.separator);
      String a = arg;
      if (stringBuilder.length() == 0) {
        a = replaceVariables(a);
      }
      a = a.replace("\\", File.separator);
      a = a.replace("/", File.separator);
      if (stringBuilder.length() > 0 && a.startsWith(File.separator))
        a = a.substring(File.separator.length());

      while (a.startsWith(".." + File.separator)) {
        if (stringBuilder.length() == 0) {
          stringBuilder = new StringBuilder(Paths.get(".").toAbsolutePath().normalize().toString());
        } else {
          String p = stringBuilder.toString().substring(0, stringBuilder.length() - 1);
          if (!p.contains(File.separator)) {
            stringBuilder = new StringBuilder();
          } else {
            stringBuilder = new StringBuilder(p.substring(0, p.lastIndexOf(File.separator)) + File.separator);
          }
        }
        a = a.substring(3);
      }
      if ("..".equals(a)) {
        int i = stringBuilder.substring(0, stringBuilder.length() - 1).lastIndexOf(File.separator);
        stringBuilder = new StringBuilder(stringBuilder.substring(0, i + 1));
      } else
        stringBuilder.append(a);
    }
    checkPathIsChildOfTarget(stringBuilder.toString(), args);
    return stringBuilder.toString();
  }

  private void checkPathIsChildOfTarget(String path, String[] args) {
    if (!requirePathIsChildOfTarget) {
      return;
    }

    final String target = requiredTarget != null
      ? requiredTarget
      : args[0];

    if (!Path.of(path).normalize().startsWith(Path.of(replaceVariables(target)).normalize())) {
      throw new RuntimeException("Computed path does not start with first element: " + String.join(", ", args));
    }
  }

  private void checkNonRootFirstEntry(String[] args) {
    if (!requireNonRootFirstEntry) {
      return;
    }
    if (isPathRoot(args[0])) {
      throw new RuntimeException("First entry in file path cannot be root: " + args[0]+", full path = "+String.join(", ", args));
    }
  }

  private void checkNonNullNonEmptyFirstEntry(String[] args) {
    if (!requireNonNullNonEmptyFirstEntry) {
      return;
    }
    if (args[0] == null || Utilities.noString(args[0].trim())) {
      throw new RuntimeException("First entry in file path cannot be null or empty, full path = "+String.join(", ", args));
    }
  }


  private String replaceVariables(String a) {
    if ("[tmp]".equals(a)) {
      if (hasCTempDir()) {
        return Utilities.C_TEMP_DIR;
      } else if (FhirSettings.hasTempPath()) {
        return FhirSettings.getTempPath();
      } else {
        return System.getProperty("java.io.tmpdir");
      }
    } else if ("[user]".equals(a)) {
      return System.getProperty("user.home");
    }
    return a;
  }

  protected static boolean hasCTempDir() {
    if (!System.getProperty("os.name").toLowerCase().contains("win")) {
      return false;
    }
    File tmp = new File(Utilities.C_TEMP_DIR);
    return tmp.exists() && tmp.isDirectory() && tmp.canWrite();
  }

  protected static boolean isPathRoot(String pathString) {
    boolean actual;
    Path path = Path.of(pathString);
    Path normalizedPath = path.normalize();
    actual = normalizedPath.equals(path.getRoot());
    return actual;
  }
}
