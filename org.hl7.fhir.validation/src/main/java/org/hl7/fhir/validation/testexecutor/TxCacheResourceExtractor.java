package org.hl7.fhir.validation.testexecutor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TxCacheResourceExtractor {
  public static void extractTxCacheResources(String targetDirectory) throws IOException {
    Path targetPath = Paths.get(targetDirectory);

    URL jar = TestExecutor.class.getProtectionDomain().getCodeSource().getLocation();
    ZipInputStream zip = new ZipInputStream(jar.openStream());
    while(true) {
      ZipEntry e = zip.getNextEntry();
      if (e == null)
        break;
      processZipEntry(zip, targetPath, e);
    }
  }

  private static void processZipEntry(ZipInputStream zip, Path targetPath, ZipEntry e) throws IOException {
    String name = e.getName();
    if (!name.startsWith(TestExecutor.TX_CACHE)) {
      zip.closeEntry();
      return;
    }

    Path sourcePath = Paths.get(name);
    if (sourcePath.getNameCount() <= 1) {
      zip.closeEntry();
      return;
    }

    if (e.isDirectory()) {
      zip.closeEntry();
      return;
    }
    extractFileFromZipInputStream(zip, sourcePath, targetPath);
  }

  private static void extractFileFromZipInputStream(ZipInputStream zip, Path sourcePath, Path targetPath) throws IOException {
    Path fileTargetPath = targetPath.resolve(sourcePath.subpath(1, sourcePath.getNameCount()));

    makeFileParentDirsIfNotExist(fileTargetPath);

    FileOutputStream fileOutputStream = new FileOutputStream(fileTargetPath.toFile());
    for (int c = zip.read(); c != -1; c = zip.read()) {
      fileOutputStream.write(c);
    }
    zip.closeEntry();
    fileOutputStream.close();
  }

  private static void makeFileParentDirsIfNotExist(Path filePath) {
    Path parent = filePath.getParent();
    if (!parent.toFile().exists()) {
      parent.toFile().mkdirs();
    }
  }
}
