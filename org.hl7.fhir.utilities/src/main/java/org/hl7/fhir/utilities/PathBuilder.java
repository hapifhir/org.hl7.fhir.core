package org.hl7.fhir.utilities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.With;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PathBuilder {

  @With
  private final String requiredTarget;

  @With
  private final boolean requireNonNullNonEmptyFirstEntry;

  @With
  private final boolean requireNonRootFirstEntry;

  @With
  private final boolean requirePathIsChildOfTarget;

  public static PathBuilder getPathBuilder() {
    return new PathBuilder(null, true, true, true);
  }

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
      throw new RuntimeException("First entry cannot be root: " + args[0]);
    }
  }

  private void checkNonNullNonEmptyFirstEntry(String[] args) {
    if (!requireNonNullNonEmptyFirstEntry) {
      return;
    }
    if (args[0] == null || Utilities.noString(args[0].trim())) {
      throw new RuntimeException("First entry cannot be null or empty");
    }
  }


  private String replaceVariables(String a) {
    if ("[tmp]".equals(a)) {
      if (hasCTempDir()) {
        return Utilities.C_TEMP_DIR;
      } else if (ToolGlobalSettings.hasTempPath()) {
        return ToolGlobalSettings.getTempPath();
      } else {
        return System.getProperty("java.io.tmpdir");
      }
    } else if ("[user]".equals(a)) {
      return System.getProperty("user.home");
    } else if (a.startsWith("[") && a.endsWith("]")) {
      String ev = System.getenv(a.replace("[", "").replace("]", ""));
      if (ev != null) {
        return ev;
      } else {
        return "null";
      }
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
