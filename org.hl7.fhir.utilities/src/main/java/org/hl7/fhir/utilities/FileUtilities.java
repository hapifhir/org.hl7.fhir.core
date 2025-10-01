package org.hl7.fhir.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FileNotifier.FileNotifier2;
import org.hl7.fhir.utilities.filesystem.CSFile;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;


public class FileUtilities {

  public static String bytesToString(final byte[] bs) throws IOException {
    return new String(bs, StandardCharsets.UTF_8);
  }

  public static String bytesToString(final byte[] bs, final boolean removeBOM) throws IOException {
    final String read = new String(bs, StandardCharsets.UTF_8);
    if (removeBOM)
      return read.replace("\uFEFF", "");
    else
      return read;
  }

  public static void bytesToFile(final byte[] bytes, final String path) throws IOException {
    try (final OutputStream sw = ManagedFileAccess.outStream(ManagedFileAccess.csfile(path))) {
      if (bytes != null) {
        sw.write(bytes);
      }
    }
  }
  
  public static void bytesToFile(final byte[] bytes, final File f) throws IOException {
    try (final OutputStream sw = ManagedFileAccess.outStream(f)) {
      sw.write(bytes);
    }
  }
  
  public static void appendBytesToFile(final byte[] bytes, final String path) throws IOException {
    byte[] linebreak = new byte[] {13, 10};
    Files.write(Paths.get(path), linebreak, StandardOpenOption.APPEND);
    Files.write(Paths.get(path), bytes, StandardOpenOption.APPEND);
  }

  public static void stringToStream(final String content, final OutputStream stream) throws IOException {
    stream.write(content.getBytes(StandardCharsets.UTF_8));
  }
  
  public static byte[] stringToBytes(final String content) throws IOException {
    return content.getBytes(StandardCharsets.UTF_8);
  }

  public static void stringToFile(final String content, final String path) throws IOException  {
    final File file = ManagedFileAccess.csfile(path);
    stringToFile(content, file);
  }

  public static void stringToFileIfDifferent(final String content, final String path) throws IOException  {
    final File file = ManagedFileAccess.csfile(path);
    String current = file.exists() ? fileToString(file) : null;
    if (current == null || !current.equals(content)) {
      stringToFile(content, file);
    }
  }

  public static void stringToFile(final String content, final File file) throws IOException {
    try (final OutputStream output = Files.newOutputStream(file.toPath())) {
      output.write(content.getBytes(StandardCharsets.UTF_8));
    }
  }  
  
  public static void stringToFileWithBOM(final String content, final File file) throws IOException  {
    try (final OutputStream output = Files.newOutputStream(file.toPath())) {
      output.write(new byte[]{(byte)239, (byte)187, (byte)191});
      output.write(content.getBytes(StandardCharsets.UTF_8));
    }
  }
  
  public static void stringToFileWithBOM(final String content, final String path) throws IOException  {
    final File file = ManagedFileAccess.csfile(path);
    stringToFileWithBOM(content, file);
  }
  
  public static String fileToString(final File f) throws FileNotFoundException, IOException {
    // Files.readString(Path) will fail on invalid UTF-8 byte sequences, so we use Files.readAllBytes() instead.
    // This would happen when reading an XSLX file, for example.
    return new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
  }
  
  public static String fileToString(final String src) throws FileNotFoundException, IOException  {
    final CSFile f = ManagedFileAccess.csfile(src);
    if (!f.exists()) {
      throw new IOException("File "+src+" not found");
    }
    return fileToString(f);
  }

  public static byte[] fileToBytes(final String srcFile) throws FileNotFoundException, IOException {
    final File f = ManagedFileAccess.csfile(srcFile);
    return Files.readAllBytes(f.toPath());
  }

  public static byte[] fileToBytes(final File file) throws FileNotFoundException, IOException {
    return Files.readAllBytes(file.toPath());
  }

  /**
   * 
   * fileToBytes insists in case correctness to ensure that stuff works across linux and windows, but it's not always appropriate to check case (e.g. validator parameters)
   * 
   * @param srcFile
   * @return
   * @throws FileNotFoundException
   * @throws IOException
   */
  public static byte[] fileToBytesNCS(final String srcFile) throws FileNotFoundException, IOException {
    return Files.readAllBytes(Path.of(srcFile));
  }

  public static List<String> fileToLines(String file) throws FileNotFoundException, IOException {
    Pattern LINE_SEP_PATTERN = Pattern.compile("\\R");
    List<String> res = new ArrayList<String>();
    for (String s : LINE_SEP_PATTERN.split(fileToString(file))) {
      res.add(s);
    }
    return res;
  }

  public static String[] fileToLines(File file) throws FileNotFoundException, IOException {
    Pattern LINE_SEP_PATTERN = Pattern.compile("\\R");
    return LINE_SEP_PATTERN.split(fileToString(file));
  }

  public static String[] streamToLines(InputStream stream) throws FileNotFoundException, IOException {
    Pattern LINE_SEP_PATTERN = Pattern.compile("\\R");
    return LINE_SEP_PATTERN.split(streamToString(stream));
  }

  public static String streamToString(final InputStream input) throws IOException  {
    return new String(input.readAllBytes(), StandardCharsets.UTF_8).replace("\uFEFF", "");
  }

  public static byte[] streamToBytes(final InputStream input) throws IOException  {
    if (input == null) {
      return null;
    }
    final byte[] read = input.readAllBytes();
    input.close();
    return read;
  }

  public static byte[] streamToBytesNoClose(final InputStream input) throws IOException  {
    if (input == null) {
      return null;
    }
    return input.readAllBytes();
  }

  public static void streamToFile(final InputStream stream, final String filename) throws IOException {
    Files.copy(stream, Path.of(filename), StandardCopyOption.REPLACE_EXISTING);
    stream.close();
  }

  public static void streamToFileNoClose(final InputStream stream, final String filename) throws IOException {
    Files.copy(stream, Path.of(filename), StandardCopyOption.REPLACE_EXISTING);
  }
  	
  public static void linesToFile(File f, String[] lines) throws IOException {
    Files.write(f.toPath(), List.of(lines), StandardCharsets.UTF_8);
  }
  
  public static void linesToFile(String path, String[] lines) throws IOException  {
    final File file = ManagedFileAccess.csfile(path);
    Files.write(file.toPath(), List.of(lines), StandardCharsets.UTF_8);
  }
  
  public static void linesToFile(String path, List<String> lines) throws IOException  {
    final File file = ManagedFileAccess.csfile(path);
    Files.write(file.toPath(), lines, StandardCharsets.UTF_8);
  }
  
  public static String fileTitle(String file) throws IOException {
    if (file == null)
      return null;
    String s = ManagedFileAccess.file(file).getName();
    return s.indexOf(".") == -1 ? s : s.substring(0, s.indexOf("."));
  }

  public static String getDirectoryForFile(String filepath) throws IOException {
    File f = ManagedFileAccess.file(filepath);
    return f.getParent();
  }

  public static String getDirectoryForFile(File file) throws IOException {
    return file.getParent();
  }

  public static String getRelativePath(String root, String path) {
    String res = path.substring(root.length());
    if (res.startsWith(File.separator)) {
      res = res.substring(1);
    }
    return res;
  }

  public static File createDirectory(String path) throws IOException {
    ManagedFileAccess.csfile(path).mkdirs();
    return ManagedFileAccess.file(path);
  }

  public static File createDirectoryNC(String path) throws IOException {
    ManagedFileAccess.file(path).mkdirs();
    return ManagedFileAccess.file(path);
  }

  public static void copyFile(File sourceFile, File destFile) throws IOException {
    if (!destFile.exists()) {
      if (!ManagedFileAccess.csfile(destFile.getParent()).exists()) {
        createDirectory(destFile.getParent());
      }
      destFile.createNewFile();
    } else if (!destFile.getCanonicalFile().getName().equals(destFile.getName())) {
      // case mismatch
      destFile.delete();
      destFile.createNewFile();
    }
  
    FileInputStream source = null;
    FileOutputStream destination = null;
  
    try {
      source = ManagedFileAccess.inStream(sourceFile);
      destination = ManagedFileAccess.outStream(destFile);
      destination.getChannel().transferFrom(source.getChannel(), 0, source.getChannel().size());
    } finally {
      if (source != null) {
        source.close();
      }
      if (destination != null) {
        destination.close();
      }
    }
  }

  public static void copyFile(String source, String dest) throws IOException {
    copyFile(ManagedFileAccess.file(source), ManagedFileAccess.file(dest));
  }

  public static void copyDirectory(String sourceFolder, String destFolder, FileNotifier notifier) throws IOException, FHIRException {
    CSFile src = ManagedFileAccess.csfile(sourceFolder);
    if (!src.exists())
      throw new FHIRException("Folder " + sourceFolder + " not found");
    File dst = ManagedFileAccess.file(destFolder);
    if(!dst.getCanonicalFile().getName().equals(dst.getName())) {
      File tmp = ManagedFileAccess.file(destFolder+System.currentTimeMillis());
      if (!dst.renameTo(tmp)) {
        throw new IOException("fixing case from "+dst.getCanonicalFile().getName()+" to "+tmp.getName()+" failed");
      }
      if (!tmp.renameTo(dst)) {
        throw new IOException("fixing case from "+tmp.getCanonicalFile().getName()+" to "+dst.getName()+" failed");
      }
    } else if (!dst.exists()) {    
      createDirectory(destFolder);
    }
  
    String[] files = src.list();
    for (String f : files) {
      if (ManagedFileAccess.csfile(sourceFolder + File.separator + f).isDirectory()) {
        if (!f.startsWith(".")) { // ignore .git files...
          copyDirectory(sourceFolder + File.separator + f, destFolder + File.separator + f, notifier);
        }
      } else {
        if (notifier != null)
          notifier.copyFile(sourceFolder + File.separator + f, destFolder + File.separator + f);
        FileUtilities.copyFile(ManagedFileAccess.csfile(sourceFolder + File.separator + f), new /*CS*/File(destFolder + File.separator + f)); // case doesn't have to match on the target
      }
    }
  }

  public static void copyDirectory2(String sourceFolder, String destFolder, FileNotifier2 notifier) throws IOException, FHIRException {
    CSFile src = ManagedFileAccess.csfile(sourceFolder);
    if (!src.exists())
      throw new FHIRException("Folder " + sourceFolder + " not found");
    createDirectory(destFolder);
  
    String[] files = src.list();
    for (String f : files) {
      if (ManagedFileAccess.csfile(sourceFolder + File.separator + f).isDirectory()) {
        if (!f.startsWith(".")) { // ignore .git files...
          boolean doCopy = notifier != null ? notifier.copyFolder(sourceFolder + File.separator + f, destFolder + File.separator + f) : true;
          if (doCopy) {
            copyDirectory2(sourceFolder + File.separator + f, destFolder + File.separator + f, notifier);
          }
        }
      } else {
        boolean doCopy = notifier != null ? notifier.copyFile(sourceFolder + File.separator + f, destFolder + File.separator + f) : true;
        if (doCopy) {
          FileUtilities.copyFile(ManagedFileAccess.csfile(sourceFolder + File.separator + f), ManagedFileAccess.csfile(destFolder + File.separator + f));
        }
      }
    }
  }

  public static void copyFileToDirectory(File source, File destDir) throws IOException {
    FileUtilities.copyFile(source, ManagedFileAccess.file(Utilities.path(destDir.getAbsolutePath(), source.getName())));
  }

  public static void renameDirectory(String source, String dest) throws FHIRException, IOException {
    File src = ManagedFileAccess.file(source);
    File dst = ManagedFileAccess.file(dest);
    if (!src.renameTo(dst)) {
      int i = 0;
      do {
        try {
          Thread.sleep(20);
        } catch (Exception e) {
          // nothing
        }
        System.gc();
        i++;
      } while (!src.renameTo(dst) && i < 10);
      if (src.exists()) {
        copyDirectory(source, dest, null);
        try {
          src.delete(); 
        } catch (Exception e) {
          // nothing
        }
      }
    }
  
  }

  public static List<String> listAllFiles(String path, List<String> ignoreList) throws IOException {
    List<String> res = new ArrayList<>();
    scanForFiles(res, path, ManagedFileAccess.file(path), ignoreList);
    return res;
  }
  
  private static void scanForFiles(List<String> res, String root, File dir, List<String> ignoreList) {
    for (File f : dir.listFiles()) {
      if (ignoreList == null || !ignoreList.contains(f.getAbsolutePath())) {
        if (f.isDirectory()) {
          scanForFiles(res, root, f, ignoreList);
        } else if (!f.getName().equals(".DS_Store")) {
          res.add(getRelativePath(root, f.getAbsolutePath()));
        }
      }
    }
  }

  /**
   * Delete a directory atomically by first renaming it to a temp directory in
   * its parent, and then deleting its contents.
   *
   * @param path The directory to delete.
   */
  public static void atomicDeleteDirectory(String path) throws IOException {

      File directory = ManagedFileAccess.file(path);

      String tempDirectoryPath = Utilities.generateUniqueRandomUUIDPath(directory.getParent());
      File tempDirectory = ManagedFileAccess.file(tempDirectoryPath);
     if (!directory.renameTo(tempDirectory)) {
       throw new IOException("Unable to rename directory " + path + " to " + tempDirectory +" for atomic delete");
     }
     clearDirectory(tempDirectory.getAbsolutePath());
     if (!tempDirectory.delete()) {
       throw new IOException("Unable to delete temp directory " + tempDirectory + " when atomically deleting " + path);
     }
  }

  public interface FileVisitor {
    void visitFile(File file) throws FileNotFoundException, IOException;
  }

  public static void visitFiles(String folder, String extension, FileVisitor visitor) throws FileNotFoundException, IOException {
    visitFiles(ManagedFileAccess.file(folder), extension, visitor);
  }

  public static void visitFiles(File folder, String extension, FileVisitor visitor) throws FileNotFoundException, IOException {
    for (File file : folder.listFiles()) {
      if (file.isDirectory())
        visitFiles(file, extension, visitor);
      else if (extension == null || file.getName().endsWith(extension))
        visitor.visitFile(file);
    }
  }

  public static int countFilesInDirectory(String dirName) throws IOException {
    File dir = ManagedFileAccess.file(dirName);
    if (dir.exists() == false) {
      return 0;
    }
    int i = 0;
    for (File f : dir.listFiles())
      if (!f.isDirectory())
        i++;
    return i;
  }

  public static boolean checkFileExists(String purpose, String dir, String file, List<String> errors)
      throws IOException {
    if (!ManagedFileAccess.csfile(dir + file).exists()) {
      if (errors != null)
        errors.add("Unable to find " + purpose + " file " + file + " in " + dir);
      return false;
    } else {
      return true;
    }
  }

  public static boolean checkFolderExists(String dir, List<String> errors)
      throws IOException {
    if (!ManagedFileAccess.csfile(dir).exists()) {
      errors.add("Unable to find directory " + dir);
      return false;
    } else {
      return true;
    }
  }

  public static File createTempFile(String prefix, String suffix) throws IOException {
    // this allows use to eaily identify all our dtemp files and delete them, since delete on Exit doesn't really work.
    File file = File.createTempFile("ohfu-" + prefix, suffix);
    file.deleteOnExit();
    return file;
  }

  public static void deleteTempFiles() throws IOException {
    File file = createTempFile("test", "test");
    String folder = getDirectoryForFile(file.getAbsolutePath());
    String[] list = ManagedFileAccess.file(folder).list(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.startsWith("ohfu-");
      }
    });
    if (list != null) {
      for (String n : list) {
        ManagedFileAccess.file(Utilities.path(folder, n)).delete();
      }
    }
  }

  public static void clearDirectory(String folder, String... exemptions) throws IOException {
    File dir = ManagedFileAccess.file(folder);
    if (dir.exists()) {
      if (exemptions.length == 0)
        FileUtils.cleanDirectory(dir);
      else {
        String[] files = ManagedFileAccess.csfile(folder).list();
        if (files != null) {
          for (String f : files) {
            if (!Utilities.existsInList(f, exemptions)) {
              File fh = ManagedFileAccess.csfile(folder + File.separatorChar + f);
              if (fh.isDirectory())
                clearDirectory(fh.getAbsolutePath());
              fh.delete();
            }
          }
        }
      }
    }
  }
  
  public static void deleteAllFiles(String folder, String type) throws IOException {
    File src = ManagedFileAccess.file(folder);
    String[] files = src.list();
    for (String f : files) {
      if (ManagedFileAccess.file(folder + File.separator + f).isDirectory()) {
        deleteAllFiles(folder + File.separator + f, type);
      } else if (f.endsWith(type)) {
        ManagedFileAccess.file(folder + File.separator + f).delete();
      }
    }
  
  }

  public static String changeFileExt(String name, String ext) {
    if (name.lastIndexOf('.') > -1)
      return name.substring(0, name.lastIndexOf('.')) + ext;
    else
      return name + ext;
  }

  public static boolean isIgnorableFile(File file) {
    return Utilities.existsInList(file.getName(), ".DS_Store");
  }

  public static void deleteEmptyFolders(File df) {
    for (File f : df.listFiles()) {
      if (f.isDirectory()) {
        deleteEmptyFolders(f);
      }
    }
    boolean empty = true;
    for (File f : df.listFiles()) {
      empty = false;
      break;
    }
    if (empty) {
      df.delete();
    }
  }

  public static String cleanFileName(String badFileName) {
    StringBuilder cleanName = new StringBuilder();
    int len = badFileName.codePointCount(0, badFileName.length());
    for (int i=0; i<len; i++) {
      int c = badFileName.codePointAt(i);
      if (Arrays.binarySearch(Utilities.illegalChars, c) < 0) {
        cleanName.appendCodePoint(c);
      }
    }
    return cleanName.toString();
  }

  public static void copyFiles(String source, String dest, String... extensions) throws IOException {
    for (File f : new File(source).listFiles()) {
      boolean copy = false;
      for (String e : extensions) {
        if (f.getName().endsWith(e)) {
          copy = true;
        }
      }
      if (copy) {
        FileUtilities.copyFile(f.getAbsolutePath(), Utilities.path(dest, f.getName()));
      }
    }
    
  }

  public static boolean isEmptyDirectory(File dst) {
    File[] files = dst.listFiles();
    return files == null || files.length == 0;
  }

}