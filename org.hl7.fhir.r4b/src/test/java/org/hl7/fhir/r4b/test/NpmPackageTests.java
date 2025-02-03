package org.hl7.fhir.r4b.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.hl7.fhir.r4b.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NpmPackageTests {

  @Test
  public void testOldFolder() throws IOException {
    // extract the test
    String dst = Utilities.path("[tmp]", "npm", "test.format.old");
    FileUtilities.clearDirectory(dst);
    unzip(TestingUtilities.loadTestResourceStream("npm", "test.format.old.zip"), ManagedFileAccess.file(dst));
    dst = Utilities.path(dst, "test.format.old");
    NpmPackage npm = NpmPackage.fromFolder(dst);
    checkNpm(npm);
  }

  @Test
  public void testNewFolder() throws IOException {
    // extract the test
    String dst = Utilities.path("[tmp]", "npm", "test.format.new");
    FileUtilities.clearDirectory(dst);
    unzip(TestingUtilities.loadTestResourceStream("npm", "test.format.new.zip"), ManagedFileAccess.file(dst));
    dst = Utilities.path(dst, "test.format.new");
    NpmPackage npm = NpmPackage.fromFolder(dst);
    checkNpm(npm);
  }

  @Test
  public void testOldTgz() throws IOException {
    NpmPackage npm = NpmPackage.fromPackage(TestingUtilities.loadTestResourceStream("npm", "test.format.old.tgz"));
    checkNpm(npm);
  }

  @Test
  public void testNewTgz() throws IOException {
    NpmPackage npm = NpmPackage.fromPackage(TestingUtilities.loadTestResourceStream("npm", "test.format.new.tgz"));
    checkNpm(npm);
  }

  @Test
  public void testSave() throws IOException {
    NpmPackage npm = NpmPackage.fromPackage(TestingUtilities.loadTestResourceStream("npm", "test.format.old.tgz"));
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    npm.save(bs);
    npm = NpmPackage.fromPackage(new ByteArrayInputStream(bs.toByteArray()));
    checkNpm(npm);
  }

  private void checkNpm(NpmPackage npm) throws IOException {
    Assertions.assertEquals(1, npm.list("other").size());
    Assertions.assertEquals("help.png", npm.list("other").get(0));
    Assertions.assertEquals(1, npm.list("package").size());
    Assertions.assertEquals("StructureDefinition-Definition.json", npm.list("package").get(0));
  }

  private static void unzip(InputStream source, File destDir) throws IOException {
    FileUtilities.createDirectory(destDir.getAbsolutePath());

    byte[] buffer = new byte[1024];
    ZipInputStream zis = new ZipInputStream(source);
    ZipEntry zipEntry = zis.getNextEntry();
    while (zipEntry != null) {
      File newFile = newFile(destDir, zipEntry);
      if (zipEntry.isDirectory()) {
        FileUtilities.createDirectory(newFile.getAbsolutePath());
      } else {
        FileOutputStream fos = ManagedFileAccess.outStream(newFile);
        int len;
        while ((len = zis.read(buffer)) > 0) {
          fos.write(buffer, 0, len);
        }
        fos.close();
      }
      zipEntry = zis.getNextEntry();
    }
    zis.closeEntry();
    zis.close();
  }

  public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
    File destFile = ManagedFileAccess.file(Utilities.path(destinationDir.getAbsolutePath(), zipEntry.getName()));
    String destDirPath = destinationDir.getCanonicalPath();
    String destFilePath = destFile.getCanonicalPath();
    if (!destFilePath.startsWith(destDirPath + File.separator)) {
      throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
    }
    return destFile;
  }
}