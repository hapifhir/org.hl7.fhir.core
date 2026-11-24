package org.hl7.fhir.utilities;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FileNotifier.FileNotifier2;
import org.hl7.fhir.utilities.filesystem.CSFile;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class FileUtilities {

  private FileUtilities() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  @SuppressWarnings("checkstyle:patternUsage")
  //fixed-width, line separator character class, safe
  static final Pattern LINE_SEP_PATTERN = Pattern.compile("\\R");

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
    List<String> res = new ArrayList<String>();
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //False positive: not using String.split
    String[] splitLines = LINE_SEP_PATTERN.split(fileToString(file));
    for (String s : splitLines) {
      res.add(s);
    }
    return res;
  }

  public static String[] fileToLines(File file) throws IOException {
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //False positive: not using String.split
    String[] lines = LINE_SEP_PATTERN.split(fileToString(file));
    return lines;
  }

  public static String[] streamToLines(InputStream stream) throws IOException {
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //False positive: not using String.split
    String[] lines = LINE_SEP_PATTERN.split(streamToString(stream));
    return lines;
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
    // only works with the text of the path: no file is opened, so ManagedFileAccess's policy doesn't apply
    String s = new File(file).getName();
    return s.indexOf(".") == -1 ? s : s.substring(0, s.indexOf("."));
  }

  public static String getDirectoryForFile(String filepath) throws IOException {
    // only works with the text of the path: no file is opened, so ManagedFileAccess's policy doesn't apply (a relative
    // path would otherwise be checked against the current folder, which needn't be an allowed one)
    return new File(filepath).getParent();
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

  public static File createDirectory(File path) throws IOException {
    ManagedFileAccess.csfile(path.getAbsolutePath()).mkdirs();
    return ManagedFileAccess.file(path.getAbsolutePath());
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

  /**
   * Replace {@code dst} with {@code tmp}, atomically wherever the platform allows it.
   *
   * <p>This is the second half of the write-to-temp-then-swap idiom. Its point is that a
   * concurrent reader - another process, or another thread - never observes a half-written
   * file: it sees either the whole old content or the whole new content, and never a
   * truncated file. Writing directly over a live file gives no such guarantee, and the
   * resulting torn reads are intermittent and very hard to diagnose.
   *
   * <p>{@code tmp} must be on the same filesystem as {@code dst} (in practice: the same
   * directory), or the move cannot be atomic. Where the filesystem cannot do an atomic
   * replace at all, this falls back to a plain replacing move - still far better than
   * writing in place, since the window in which the file is incomplete shrinks from
   * "the whole write" to "the move itself".
   *
   * <p>On Windows the replace can transiently fail while another process has {@code dst}
   * open, so it is retried briefly before giving up.
   *
   * <p>Note that this says nothing about durability: no fsync is performed, so a power
   * loss may still lose the write. It is about concurrent visibility, not crash safety.
   *
   * @param tmp the fully written temporary file; it no longer exists once this returns
   * @param dst the file to replace
   */
  public static void replaceFileAtomically(File tmp, File dst) throws IOException {
    IOException last = null;
    for (int i = 0; i < 10; i++) {
      try {
        moveReplacing(tmp, dst);
        return;
      } catch (IOException e) {
        // most likely a sharing violation on Windows - back off and let the reader finish
        last = e;
        try {
          Thread.sleep(20);
        } catch (InterruptedException ie) {
          Thread.currentThread().interrupt();
          throw e;
        }
      }
    }
    throw last;
  }

  private static void moveReplacing(File tmp, File dst) throws IOException {
    try {
      Files.move(tmp.toPath(), dst.toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
    } catch (AtomicMoveNotSupportedException | UnsupportedOperationException e) {
      Files.move(tmp.toPath(), dst.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
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
      if (isLink(directory.toPath())) {
        // the link is what's deleted, not what it links to
        Files.delete(directory.toPath());
        return;
      }
      checkSafeToEmpty(directory.toPath());

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
    File file = ManagedFileAccess.createTempFile("ohfu-" + prefix, suffix);
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

  /**
   * Empties a folder. Symbolic links (and, on Windows, junctions) are never followed: a link in the folder (or anywhere
   * below it) is deleted, not what it links to, and a folder that is itself a link isn't cleared at all.
   *
   * Some folders are never cleared, whatever they are called and however they are reached - see
   * {@link #whyNotSafeToEmpty(String)}
   *
   * @param exemptions names of files directly in the folder to keep
   */
  public static void clearDirectory(String folder, String... exemptions) throws IOException {
    Path dir = ManagedFileAccess.file(folder).toPath();
    if (!Files.exists(dir, LinkOption.NOFOLLOW_LINKS)) {
      return;
    }
    if (isLink(dir)) {
      throw new IOException("The folder "+folder+" is a link to somewhere else, so it won't be cleared");
    }
    if (!Files.isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
      return;
    }
    checkSafeToEmpty(dir);
    List<String> keep = Arrays.asList(exemptions);
    for (Path e : listEntries(dir)) {
      if (!keep.contains(e.getFileName().toString())) {
        if (exemptions.length == 0) {
          deleteNoFollow(e);
        } else {
          // as it always has, with exemptions an entry that can't be deleted (e.g. a file that's open, on Windows) is
          // left, not an error: the IG publisher clears its temp folder this way. What's inside a sub-folder must go
          if (!isLink(e) && Files.isDirectory(e, LinkOption.NOFOLLOW_LINKS)) {
            for (Path c : listEntries(e)) {
              deleteNoFollow(c);
            }
          }
          try {
            Files.deleteIfExists(e);
          } catch (IOException ex) {
            // left
          }
        }
      }
    }
  }

  /**
   * Deletes all the files below the folder whose name ends with type, leaving the folders. Links aren't followed (a
   * link whose name ends with type is deleted, not what it links to)
   */
  public static void deleteAllFiles(String folder, String type) throws IOException {
    Path dir = ManagedFileAccess.file(folder).toPath();
    checkFolderToEmpty(folder, dir);
    deleteAllFilesNoFollow(dir, type);
  }

  /**
   * Deletes all the files below the folder, leaving the folders. Links aren't followed (a link is deleted, not what it
   * links to)
   */
  public static void deleteAllFiles(String folder) throws IOException {
    Path dir = ManagedFileAccess.file(folder).toPath();
    checkFolderToEmpty(folder, dir);
    deleteAllFilesNoFollow(dir, null);
  }

  private static void checkFolderToEmpty(String folder, Path dir) throws IOException {
    if (isLink(dir)) {
      throw new IOException("The folder "+folder+" is a link to somewhere else, so its files won't be deleted");
    }
    if (!Files.isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
      throw new IOException("The folder "+folder+" doesn't exist");
    }
    checkSafeToEmpty(dir);
  }

  private static void deleteAllFilesNoFollow(Path dir, String type) throws IOException {
    for (Path e : listEntries(dir)) {
      if (!isLink(e) && Files.isDirectory(e, LinkOption.NOFOLLOW_LINKS)) {
        deleteAllFilesNoFollow(e, type);
      } else if (type == null || e.getFileName().toString().endsWith(type)) {
        Files.deleteIfExists(e);
      }
    }
  }

  /** a symbolic link, or something else that isn't a plain file or folder (on Windows, a junction is one) */
  private static boolean isLink(Path p) {
    try {
      java.nio.file.attribute.BasicFileAttributes a = Files.readAttributes(p, java.nio.file.attribute.BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
      return a.isSymbolicLink() || a.isOther();
    } catch (IOException e) {
      return false;
    }
  }

  private static List<Path> listEntries(Path dir) throws IOException {
    List<Path> res = new ArrayList<>();
    try (java.nio.file.DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
      for (Path e : ds) {
        res.add(e);
      }
    }
    return res;
  }

  private static void deleteNoFollow(Path p) throws IOException {
    if (!isLink(p) && Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
      for (Path c : listEntries(p)) {
        deleteNoFollow(c);
      }
    }
    Files.deleteIfExists(p);
  }

  private static void checkSafeToEmpty(Path dir) throws IOException {
    String reason = whyNotSafeToEmpty(dir.toString());
    if (reason != null) {
      throw new IOException("Refusing to empty or delete the folder "+dir+": "+reason);
    }
  }

  // system folders at the top of a file system (/ or C:\), which aren't emptied. Other top level folders (/work,
  // C:\build - common in containers and on build servers) can be. Compared in lower case
  private static final List<String> SYSTEM_FOLDERS = Arrays.asList("applications", "bin", "boot", "cores", "dev", "etc", "home",
      "lib", "lib32", "lib64", "libx32", "library", "media", "mnt", "opt", "private", "proc", "root", "run", "sbin", "snap",
      "srv", "sys", "system", "users", "usr", "var", "volumes",
      "windows", "program files", "program files (x86)", "programdata", "$recycle.bin", "system volume information", "recovery");
  // system folders whose sub-folders are all system folders, homes or drives, so none of them is emptied either
  private static final List<String> SYSTEM_PARENT_FOLDERS = Arrays.asList("applications", "bin", "boot", "cores", "dev", "etc",
      "home", "lib", "lib32", "lib64", "libx32", "library", "media", "private", "proc", "run", "sbin", "snap", "sys", "system",
      "users", "usr", "volumes", "windows", "program files", "program files (x86)", "programdata");
  // in the other system folders, just these sub-folders (/var/ci, /opt/build and /mnt/build are often where builds are)
  private static final java.util.Map<String, List<String>> SYSTEM_SUB_FOLDERS = java.util.Map.of(
      "var", Arrays.asList("backups", "cache", "db", "empty", "folders", "lib", "local", "lock", "log", "mail", "opt", "root", "run", "spool", "tmp", "vm"),
      "opt", Arrays.asList("homebrew", "local"));
  // folders in a user's home folder that aren't emptied. compared in lower case
  private static final List<String> HOME_FOLDERS = Arrays.asList("desktop", "documents", "my documents", "downloads", "library",
      "pictures", "movies", "music", "videos", "public", "applications", "appdata", "dropbox", "google drive", "icloud drive",
      ".ssh", ".config", ".m2", ".fhir");

  /**
   * Whether a folder must never be emptied or deleted, whatever is asked: these are folders that are never scratch
   * folders, so a request to empty one is a mistake or an attack (e.g. a link, or a setting, that leads somewhere
   * else). Where the folder really is is what's looked at (links are followed to get there).
   *
   * @return null if the folder may be emptied, else why not
   */
  public static String whyNotSafeToEmpty(String folder) {
    Path realPath;
    try {
      // not normalised first: toRealPath resolves a .. after a link from where the link leads, as emptying it would
      realPath = Paths.get(folder).toAbsolutePath().toRealPath();
    } catch (Exception e) {
      return null; // it doesn't exist, so there's nothing to empty
    }
    String reason = whyNotSafeToEmptySystemFolder(realPath);
    if (reason != null) {
      return reason;
    }
    Path home = realPathOf(System.getProperty("user.home"));
    if (home != null) {
      if (home.startsWith(realPath)) {
        return "it is the user's home folder, or contains it";
      }
      String name = realPath.getFileName().toString().toLowerCase();
      if (home.equals(realPath.getParent()) && (HOME_FOLDERS.contains(name) || name.startsWith("onedrive"))) {
        return "it is one of the standard folders in the user's home folder";
      }
      if (realPath.equals(realPathOf(home.resolve(".fhir").resolve("packages").toString()))) {
        return "it is the FHIR package cache";
      }
    }
    Path tmp = realPathOf(System.getProperty("java.io.tmpdir"));
    if (tmp != null && tmp.startsWith(realPath)) {
      return "it is the system temporary folder, or contains it";
    }
    Path currentDirectory = realPathOf(Paths.get("").toAbsolutePath().toString());
    if (currentDirectory != null && currentDirectory.startsWith(realPath)) {
      return "it is the current folder, or contains it";
    }
    if (Files.exists(realPath.resolve(".git"), LinkOption.NOFOLLOW_LINKS)) {
      return "it is the root of a git repository";
    }
    return null;
  }

  /** the rules about system folders, on a path that is where the folder really is */
  static String whyNotSafeToEmptySystemFolder(Path real) {
    if (real.getNameCount() == 0) {
      return "it is the root of a file system";
    }
    String top = real.getName(0).toString().toLowerCase(java.util.Locale.ROOT);
    if (real.getNameCount() == 1 && SYSTEM_FOLDERS.contains(top)) {
      return "it is a system folder";
    }
    if (real.getNameCount() == 2) {
      String sub = real.getName(1).toString().toLowerCase(java.util.Locale.ROOT);
      if (SYSTEM_PARENT_FOLDERS.contains(top) || (SYSTEM_SUB_FOLDERS.containsKey(top) && SYSTEM_SUB_FOLDERS.get(top).contains(sub))) {
        return "it is a system folder";
      }
      if (top.equals("mnt") && sub.length() == 1) {
        return "it is a drive"; // WSL's /mnt/c
      }
    }
    return null;
  }

  private static Path realPathOf(String path) {
    if (path == null) {
      return null;
    }
    try {
      return Paths.get(path).toAbsolutePath().toRealPath();
    } catch (Exception e) {
      return null;
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

  /**
   * Deletes the empty folders below (and including) df. Links aren't followed, and aren't empty folders
   */
  public static void deleteEmptyFolders(File df) {
    Path dir = df.toPath();
    if (isLink(dir) || !Files.isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
      return;
    }
    List<Path> entries;
    try {
      entries = listEntries(dir);
    } catch (IOException e) {
      return;
    }
    for (Path e : entries) {
      deleteEmptyFolders(e.toFile());
    }
    String[] left = df.list();
    if (left != null && left.length == 0) {
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
      boolean copy = extensions.length == 0;
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