package org.hl7.fhir.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class CompressionUtilities {
  public static void unzip(InputStream zip, String target) throws IOException {
    unzip(zip, Path.of(target));
  }

  /**
   * Unzips into the target folder. Every entry has to land in the folder: one whose name leads out of it (../..) is
   * refused, and so is one that would be written through a symbolic link (one already in the folder, or that the
   * target folder is reached by), since that could lead anywhere. Each file is checked against the file access policy
   */
  public static void unzip(InputStream zip, Path target) throws IOException {
    target = target.toAbsolutePath().normalize();
    ManagedFileAccess.fromPath(target); // the folder unzipped into has to be one that may be written to
    try (ZipInputStream zis = new ZipInputStream(zip)) {
      ZipEntry zipEntry = zis.getNextEntry();
      while (zipEntry != null) {
        boolean isDirectory = false;

        String n = makeOSSafe(zipEntry.getName());

        if (n.endsWith(File.separator)) {
          isDirectory = true;
        }
        Path newPath = zipSlipProtect(n, target);
        checkNoLinks(target, newPath, zipEntry.getName());
        ManagedFileAccess.fromPath(newPath);
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

    // both normalised, or a target with . or .. in it (or a relative one) would refuse every entry
    Path dir = targetDir.toAbsolutePath().normalize();
    Path targetDirResolved = dir.resolve(zipName);

    // make sure normalized file still has targetDir as its prefix
    // else throws exception
    Path normalizePath = targetDirResolved.normalize();
    if (!normalizePath.startsWith(dir)) {
      throw new IOException("Bad zip entry: " + zipName);
    }

    return normalizePath;
  }

  /**
   * Nothing on the way from the target folder to the entry (the entry itself included) may be a symbolic link: a link
   * left by an earlier entry, or already in the folder, would have the entry written wherever it leads. The target
   * folder itself mustn't be a link either (where it is was checked by the policy, but the entries would follow it)
   */
  private static void checkNoLinks(Path target, Path entry, String name) throws IOException {
    Path p = entry;
    while (p != null && p.startsWith(target)) {
      if (Files.isSymbolicLink(p)) {
        throw new IOException("Bad zip entry: " + name + " (it would be written through the symbolic link " + p + ")");
      }
      if (p.equals(target)) {
        break;
      }
      p = p.getParent();
    }
  }

  public static String makeOSSafe(String name) {
    return name.replace("\\", File.separator).replace("/", File.separator);
  }
}
