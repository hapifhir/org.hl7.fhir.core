package org.hl7.fhir.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CompressionUtilities {
  public static void unzip(InputStream zip, String target) throws IOException {
    unzip(zip, Path.of(target));
  }

  public static void unzip(InputStream zip, Path target) throws IOException {
    try (ZipInputStream zis = new ZipInputStream(zip)) {
      ZipEntry zipEntry = zis.getNextEntry();
      while (zipEntry != null) {
        boolean isDirectory = false;

        String n = makeOSSafe(zipEntry.getName());

        if (n.endsWith(File.separator)) {
          isDirectory = true;
        }
        Path newPath = zipSlipProtect(n, target);
        if (isDirectory) {
          Files.createDirectories(newPath);
        } else {
          if (newPath.getParent() != null) {
            if (Files.notExists(newPath.getParent())) {
              Files.createDirectories(newPath.getParent());
            }
          }
          Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);
        }
        zipEntry = zis.getNextEntry();
      }
      zis.closeEntry();
    }
  }

  public static Path zipSlipProtect(String zipName, Path targetDir)
      throws IOException {

    // test zip slip vulnerability
    // Path targetDirResolved = targetDir.resolve("../../" + zipEntry.getName());

    Path targetDirResolved = targetDir.resolve(zipName);

    // make sure normalized file still has targetDir as its prefix
    // else throws exception
    Path normalizePath = targetDirResolved.normalize();
    if (!normalizePath.startsWith(targetDir)) {
      throw new IOException("Bad zip entry: " + zipName);
    }

    return normalizePath;
  }

  public static String makeOSSafe(String name) {
    return name.replace("\\", File.separator).replace("/", File.separator);
  }
}
