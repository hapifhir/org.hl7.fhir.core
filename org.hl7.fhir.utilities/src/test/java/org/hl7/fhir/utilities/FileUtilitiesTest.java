package org.hl7.fhir.utilities;

 import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.*;

 import java.io.ByteArrayOutputStream;
 import java.io.File;
 import java.io.IOException;
 import java.io.OutputStream;
 import java.nio.charset.StandardCharsets;
 import java.nio.file.Files;
 import java.nio.file.NoSuchFileException;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;
 import java.util.UUID;
 import java.util.concurrent.atomic.AtomicBoolean;
 import java.util.concurrent.atomic.AtomicInteger;

 import static org.junit.jupiter.api.Assertions.*;

 /**
  * Test bench for {@link FileUtilities}.
  *
  * @author Quentin Ligier
  **/
 class FileUtilitiesTest {

   // what the tests make goes here, and is deleted after each test (JUnit doesn't follow links when it deletes)
   @org.junit.jupiter.api.io.TempDir
   java.nio.file.Path tempDir;

   private static final String SAMPLE_CONTENT = "Line 1\nLine 2\nLine 3";
   private static final List<String> SAMPLE_CONTENT_LINES = List.of("Line 1", "Line 2", "Line 3");
   private static final String BOM = "\uFEFF";
   private static final byte[] BOM_BYTES = new byte[]{(byte)239, (byte)187, (byte)191};

   private static File readFile;
   private final static List<File> createdFiles = new ArrayList<>(4);

   @BeforeAll
   static void setUp() throws IOException {
     readFile = createTempFile();
     readFile.deleteOnExit();
     Files.writeString(readFile.toPath(), SAMPLE_CONTENT);
   }

   @AfterAll
   static void tearDown() throws IOException {
     for (final var file : createdFiles) {
       Files.deleteIfExists(file.toPath());
     }
   }

   @Test
   void testReadAllLines() throws IOException {
     final var readLines = FileUtilities.fileToLines(readFile.getAbsolutePath());
     assertEquals(3, readLines.size());
     assertEquals(SAMPLE_CONTENT_LINES, readLines);
   }

   @Test
   void testBytesToString1() throws IOException {
     final var converted = FileUtilities.bytesToString(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8));
     assertEquals(SAMPLE_CONTENT, converted);
   }

   @Test
   void testBytesToString2() throws IOException {
     final var bytesWithoutBom = SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8);
     final var bomBytes = BOM.getBytes(StandardCharsets.UTF_8);
     final var bytesWithBom = Arrays.copyOf(bomBytes, bomBytes.length + bytesWithoutBom.length);
     System.arraycopy(bytesWithoutBom, 0, bytesWithBom, bomBytes.length, bytesWithoutBom.length);

     var converted = FileUtilities.bytesToString(bytesWithoutBom, true);
     assertEquals(SAMPLE_CONTENT, converted);

     converted = FileUtilities.bytesToString(bytesWithoutBom, false);
     assertEquals(SAMPLE_CONTENT, converted);

     converted = FileUtilities.bytesToString(bytesWithBom, true);
     assertEquals(SAMPLE_CONTENT, converted);

     converted = FileUtilities.bytesToString(bytesWithBom, false);
     assertEquals(BOM + SAMPLE_CONTENT, converted);
   }

   @Test
   void testFileToString1() throws IOException {
     final var read = FileUtilities.fileToString(readFile);
     assertEquals(SAMPLE_CONTENT, read);
   }

   @Test
   void testFileToString2() throws IOException {
     final var read = FileUtilities.fileToString(readFile.getAbsolutePath());
     assertEquals(SAMPLE_CONTENT, read);
   }

   @Test
   void testFileToBytes1() throws IOException {
     final var read = FileUtilities.fileToBytes(readFile);
     assertArrayEquals(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8), read);
   }

   @Test
   void testFileToBytesNCS() throws IOException {
     final var read = FileUtilities.fileToBytesNCS(readFile.getAbsolutePath());
     assertArrayEquals(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8), read);
   }

   @Test
   void testFileToBytes2() throws IOException {
     final var read = FileUtilities.fileToBytes(readFile.getAbsolutePath());
     assertArrayEquals(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8), read);
   }

   @Test
   void testBytesToFile() throws IOException {
     final var writeFile = createTempFile();
     FileUtilities.bytesToFile(BOM_BYTES, writeFile);
     assertArrayEquals(BOM_BYTES, Files.readAllBytes(writeFile.toPath()));
   }

   @Test
   void testAppendBytesToFile() throws IOException {
     final var writeFile = createTempFile();
     FileUtilities.bytesToFile(BOM_BYTES, writeFile);
     assertArrayEquals(BOM_BYTES, Files.readAllBytes(writeFile.toPath()));

     FileUtilities.appendBytesToFile(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8), writeFile.getAbsolutePath());

     ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
     outputStream.write( BOM_BYTES );
     outputStream.write(new byte[] {13, 10}); //newline
     outputStream.write( SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8) );

     byte[] expected = outputStream.toByteArray();

     byte[] actual = Files.readAllBytes(writeFile.toPath());
     assertArrayEquals(expected, actual);

   }

   @Test
   void testStringToFile() throws IOException {
     final var writeFile = createTempFile();
     FileUtilities.stringToFileWithBOM(SAMPLE_CONTENT, writeFile);
     assertEquals(BOM + SAMPLE_CONTENT, Files.readString(writeFile.toPath()));

     FileUtilities.stringToFile(SAMPLE_CONTENT, writeFile);
     assertEquals(SAMPLE_CONTENT, Files.readString(writeFile.toPath()));
   }

   @Test
   void testWriteAllLines() throws IOException {
     final var writeFile = createTempFile();
     FileUtilities.linesToFile(writeFile.getAbsolutePath(), SAMPLE_CONTENT_LINES);
     assertEquals(SAMPLE_CONTENT_LINES, Files.readAllLines(writeFile.toPath()));
   }

   private static File createTempFile() throws IOException {
     final var file = ManagedFileAccess.fromPath(Files.createTempFile("test_fhir_utilities_", ".txt"));
     file.deleteOnExit();
     createdFiles.add(file);
     return file;
   }

   @Test
   @DisplayName("directory copy case tests")
   void testFDirectoryCopy() throws IOException {
     String src = Utilities.path("[tmp]", "test", "copy-source");
     String dst = Utilities.path("[tmp]", "test", "copy-dest");
     makeDir (src);
     makeFile(Utilities.path(src, "Test.txt"), "source1");
     makeDir (Utilities.path(src, "SUB"));
     makeFile(Utilities.path(src, "SUB", "TEST.txt"), "source2");

     makeDir (dst);
     makeFile(Utilities.path(dst, "test.txt"), "dest1");
     makeDir (Utilities.path(dst, "sub"));
     makeFile(Utilities.path(dst, "sub", "test.txt"), "dest2");

     FileUtilities.copyDirectory(src, dst, null);

     checkDir (dst);
     checkFile(Utilities.path(dst, "Test.txt"), "source1");
     checkDir (Utilities.path(dst, "SUB"));
     checkFile(Utilities.path(dst, "SUB", "TEST.txt"), "source2");
   }

   private void checkFile(String path, String content) throws IOException {
     Assertions.assertTrue(ManagedFileAccess.csfile(path).exists());
     Assertions.assertEquals(content, FileUtilities.fileToString(path));
   }

   private void checkDir(String path) throws IOException {
     Assertions.assertTrue(ManagedFileAccess.csfile(path).exists());
   }

   private void makeFile(String path, String content) throws IOException {
     FileUtilities.stringToFile(content, path);
   }

   private void makeDir(String path) throws IOException {
     FileUtilities.createDirectory(path);
     FileUtilities.clearDirectory(path);
   }

   @Test
   void testReplaceFileAtomicallyOverExistingFile() throws IOException {
     final var dir = Files.createDirectories(tempDir.resolve("replace-atomically")).toFile();
     final var dst = new File(dir, "target.txt");
     Files.writeString(dst.toPath(), "old");
     final var tmp = new File(dir, "target.txt.tmp");
     Files.writeString(tmp.toPath(), "new");

     FileUtilities.replaceFileAtomically(tmp, dst);

     assertEquals("new", Files.readString(dst.toPath()));
     assertFalse(tmp.exists(), "the scratch file should be gone once it has been swapped in");
   }

   @Test
   void testReplaceFileAtomicallyWhenTargetDoesNotExist() throws IOException {
     final var dir = Files.createDirectories(tempDir.resolve("replace-atomically")).toFile();
     final var dst = new File(dir, "target.txt");
     final var tmp = new File(dir, "target.txt.tmp");
     Files.writeString(tmp.toPath(), "new");

     FileUtilities.replaceFileAtomically(tmp, dst);

     assertEquals("new", Files.readString(dst.toPath()));
   }

   /**
    * The point of the temp-then-swap idiom: a reader running alongside the writer only ever
    * sees a whole version of the file, never a half-written one. Each version here is a long
    * run of a single character, so anything torn is trivially detectable.
    *
    * <p>Writing the same file in place instead does produce torn reads, but only a couple per
    * few hundred - too rare to assert on without making the test flaky, so this asserts the
    * one direction that cannot false-fail.
    */
   @Test
   void testReplaceFileAtomicallyIsNeverSeenPartiallyWritten() throws Exception {
     final var dir = Files.createDirectories(tempDir.resolve("replace-atomically")).toFile();
     final var dst = new File(dir, "target.txt");
     Files.write(dst.toPath(), versionOfFile('A'));

     final var stop = new AtomicBoolean(false);
     final var readFailures = new AtomicInteger(0);
     final var reads = new AtomicInteger(0);
     final List<Exception> writeFailures = new ArrayList<>();

     final var writer = new Thread(() -> {
       try {
         for (int i = 0; i < 300; i++) {
           final var tmp = new File(dir, "target.txt." + UUID.randomUUID() + ".tmp");
           try (OutputStream os = ManagedFileAccess.outStream(tmp)) {
             os.write(versionOfFile(i % 2 == 0 ? 'A' : 'B'));
           }
           FileUtilities.replaceFileAtomically(tmp, dst);
         }
       } catch (Exception e) {
         synchronized (writeFailures) { writeFailures.add(e); }
       } finally {
         stop.set(true);
       }
     });

     final var reader = new Thread(() -> {
       while (!stop.get()) {
         try {
           final var read = Files.readAllBytes(dst.toPath());
           reads.incrementAndGet();
           if (!isWholeVersion(read)) {
             readFailures.incrementAndGet();
           }
         } catch (NoSuchFileException e) {
           readFailures.incrementAndGet(); // the file must never vanish either
         } catch (IOException e) {
           synchronized (writeFailures) { writeFailures.add(e); }
           return;
         }
       }
     });

     writer.start();
     reader.start();
     writer.join();
     reader.join();

     synchronized (writeFailures) {
       assertTrue(writeFailures.isEmpty(), () -> "unexpected failure: " + writeFailures.get(0));
     }
     assertTrue(reads.get() > 0, "the reader never managed to read the file");
     assertEquals(0, readFailures.get(), "reader saw a partially written file");
   }

   private static byte[] versionOfFile(char c) {
     final var b = new StringBuilder();
     for (int i = 0; i < 2000; i++) {
       for (int j = 0; j < 60; j++) {
         b.append(c);
       }
       b.append('\n');
     }
     return b.toString().getBytes(StandardCharsets.UTF_8);
   }

   private static boolean isWholeVersion(byte[] read) {
     if (read.length == 0) {
       return false;
     }
     final char c = (char) read[0];
     if (c != 'A' && c != 'B') {
       return false;
     }
     for (final byte b : read) {
       if (b != (byte) c && b != (byte) '\n') {
         return false;
       }
     }
     return read.length == versionOfFile(c).length;
   }

   /** clearing with exemptions deletes a link in the folder, not what it links to */
   @Test
   void clearDirectoryWithExemptionsDoesNotFollowLinks() throws IOException {
     java.nio.file.Path testDir = Files.createDirectories(tempDir.resolve("clear-links"));

     java.nio.file.Path precious = Files.createDirectories(testDir.resolve("precious"));
     Files.write(precious.resolve("a.txt"), "a".getBytes(StandardCharsets.UTF_8));

     java.nio.file.Path cache = Files.createDirectories(testDir.resolve("cache"));
     Files.write(cache.resolve("keep.cache"), "k".getBytes(StandardCharsets.UTF_8));
     Files.write(cache.resolve("other.cache"), "o".getBytes(StandardCharsets.UTF_8));
     Files.createSymbolicLink(cache.resolve("sub"), precious);
     FileUtilities.clearDirectory(cache.toString(), "keep.cache");
     assertArrayEquals(new String[] {"keep.cache"}, cache.toFile().list());
     assertTrue(Files.exists(precious.resolve("a.txt")));
   }

   /** clearing never follows a link, however deep in the folder it is */
   @Test
   void clearDirectoryDoesNotFollowLinks() throws IOException {
     java.nio.file.Path testDir = Files.createDirectories(tempDir.resolve("clear-deep-links"));

     java.nio.file.Path precious = Files.createDirectories(testDir.resolve("precious"));
     Files.write(precious.resolve("a.txt"), "a".getBytes(StandardCharsets.UTF_8));

     java.nio.file.Path target = Files.createDirectories(testDir.resolve("target").resolve("sub").resolve("deeper"));
     Files.createSymbolicLink(target.resolve("link-to-precious"), precious);
     Files.createSymbolicLink(testDir.resolve("target").resolve("file-link-to-precious-file"), precious.resolve("a.txt"));
     FileUtilities.clearDirectory(testDir.resolve("target").toString());
     assertArrayEquals(new String[0], testDir.resolve("target").toFile().list());
     assertTrue(Files.exists(precious.resolve("a.txt")));
   }

   /** a folder that is itself a link isn't cleared */
   @Test
   void clearDirectoryRefusesALink() throws IOException {
     java.nio.file.Path dir = Files.createDirectories(tempDir.resolve("clear-link-root"));
     java.nio.file.Path precious = Files.createDirectories(dir.resolve("precious"));
     Files.write(precious.resolve("a.txt"), "a".getBytes(StandardCharsets.UTF_8));
     java.nio.file.Path link = Files.createSymbolicLink(dir.resolve("output"), precious);
     assertThrows(IOException.class, () -> FileUtilities.clearDirectory(link.toString()));
     assertThrows(IOException.class, () -> FileUtilities.deleteAllFiles(link.toString()));
     assertTrue(Files.exists(precious.resolve("a.txt")));
   }

   static java.util.stream.Stream<String> foldersNeverEmptied() {
     String home = System.getProperty("user.home");
     return java.util.stream.Stream.of(
         File.listRoots()[0].getAbsolutePath(),
         home,
         new File(home, "Documents").getAbsolutePath(),
         new File(home, "Desktop").getAbsolutePath(),
         new File(home, ".fhir").getAbsolutePath(),
         System.getProperty("java.io.tmpdir"),
         ".",
         "..");
   }

   /**
   * Only asks whether these may be emptied: never tries to empty them, since if the check were ever broken, that would
   * empty them. That clearDirectory refuses what this says no to is tested on a folder of the test's own
   * (aGitRepositoryIsNeverEmptied)
   */
   @org.junit.jupiter.params.ParameterizedTest
   @org.junit.jupiter.params.provider.MethodSource("foldersNeverEmptied")
   void someFoldersAreNeverEmptied(String folder) {
     if (new File(folder).exists()) {
       assertNotNull(FileUtilities.whyNotSafeToEmpty(folder), folder);
     }
   }

   /** system folders are never emptied (path is relative to the file system root) */
   @org.junit.jupiter.params.ParameterizedTest
   @org.junit.jupiter.params.provider.ValueSource(strings = {
     "",
     "usr",
     "etc",
     "home",
     "Users",
     "var",
     "opt",
     "mnt",
     "Windows",
     "usr/local",
     "etc/ssl",
     "home/someone",
     "Users/someone",
     "Volumes/disk",
     "private/tmp",
     "var/lib",
     "var/log",
     "var/folders",
     "opt/homebrew",
     "mnt/c",
     "Program Files/x"})
   void whyNotSafeToEmptySystemFolder_ReturnsReason(String path) {
     java.nio.file.Path p = File.listRoots()[0].toPath().resolve(path);
     assertNotNull(FileUtilities.whyNotSafeToEmptySystemFolder(p), p.toString());
   }

   /**
    * other folders near the top (common in containers and on build servers) can be emptied (path is relative to the
    * file system root)
    */
   @org.junit.jupiter.params.ParameterizedTest
   @org.junit.jupiter.params.provider.ValueSource(strings = {
     "work",
     "build",
     "output",
     "var/ci",
     "opt/build",
     "mnt/build",
     "srv/igs",
     "usr/local/build",
     "home/someone/ig",
     "var/lib/x"})
   void whyNotSafeToEmptySystemFolder_ReturnsNull(String path) {
     java.nio.file.Path p = File.listRoots()[0].toPath().resolve(path);
     assertNull(FileUtilities.whyNotSafeToEmptySystemFolder(p), p.toString());
   }

   @Test
   void aGitRepositoryIsNeverEmptied() throws IOException {
     java.nio.file.Path dir = Files.createDirectories(tempDir.resolve("clear-git"));
     Files.createDirectories(dir.resolve(".git"));
     Files.write(dir.resolve("a.txt"), "a".getBytes(StandardCharsets.UTF_8));
     assertThrows(IOException.class, () -> FileUtilities.clearDirectory(dir.toString()));
     assertThrows(IOException.class, () -> FileUtilities.atomicDeleteDirectory(dir.toString()));
     assertTrue(Files.exists(dir.resolve("a.txt")));
   }

   /** a link to the home folder can't be used to get it emptied */
   @Test
   void aLinkDoesNotHideWhereTheFolderIs() throws IOException {
     java.nio.file.Path dir = Files.createDirectories(tempDir.resolve("clear-home-link"));
     java.nio.file.Path link = Files.createSymbolicLink(dir.resolve("home"), java.nio.file.Paths.get(System.getProperty("user.home")));
     try {
       assertNotNull(FileUtilities.whyNotSafeToEmpty(link.toString()));
       assertNull(FileUtilities.whyNotSafeToEmpty(dir.toString()));
     } finally {
       // not left for anything that cleans up the temp folder (and might follow links) to find
       Files.delete(link);
     }
   }

   /**
   * a .. after a link goes up from where the link leads, as emptying the folder would: work/link/.. is the git
   * repository the link leads into, not work (not on Windows, where the file system takes the .. off first)
   */
   @Test
   @org.junit.jupiter.api.condition.DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
   void aLinkThenDotDotDoesNotHideWhereTheFolderIs() throws IOException {
     java.nio.file.Path dir = Files.createDirectories(tempDir.resolve("clear-link-dotdot"));
     java.nio.file.Path repo = Files.createDirectories(dir.resolve("repo"));
     Files.createDirectories(repo.resolve(".git"));
     java.nio.file.Path sub = Files.createDirectories(repo.resolve("sub"));
     java.nio.file.Path work = Files.createDirectories(dir.resolve("work"));
     Files.createSymbolicLink(work.resolve("link"), sub);
     Files.write(repo.resolve("a.txt"), "a".getBytes(StandardCharsets.UTF_8));
     assertNotNull(FileUtilities.whyNotSafeToEmpty(work + File.separator + "link" + File.separator + ".."));
     assertThrows(IOException.class, () -> FileUtilities.clearDirectory(work + File.separator + "link" + File.separator + ".."));
     assertTrue(Files.exists(repo.resolve("a.txt")));
     assertNull(FileUtilities.whyNotSafeToEmpty(work.toString()));
   }

   /** deleting a folder that is a link deletes the link */
   @Test
   void atomicDeleteDirectoryOfALinkDeletesTheLink() throws IOException {
     java.nio.file.Path dir = Files.createDirectories(tempDir.resolve("delete-link"));
     java.nio.file.Path precious = Files.createDirectories(dir.resolve("precious"));
     Files.write(precious.resolve("a.txt"), "a".getBytes(StandardCharsets.UTF_8));
     java.nio.file.Path link = Files.createSymbolicLink(dir.resolve("pkg"), precious);
     FileUtilities.atomicDeleteDirectory(link.toString());
     assertFalse(Files.exists(link, java.nio.file.LinkOption.NOFOLLOW_LINKS));
     assertTrue(Files.exists(precious.resolve("a.txt")));
   }

   @Test
   void deleteAllFilesDoesNotFollowLinks() throws IOException {
     java.nio.file.Path dir = Files.createDirectories(tempDir.resolve("delete-all-links"));

     java.nio.file.Path precious = Files.createDirectories(dir.resolve("precious"));
     Files.write(precious.resolve("a.txt"), "a".getBytes(StandardCharsets.UTF_8));

     java.nio.file.Path work = Files.createDirectories(dir.resolve("work").resolve("sub"));
     Files.write(work.resolve("b.txt"), "b".getBytes(StandardCharsets.UTF_8));
     Files.write(work.resolve("c.html"), "c".getBytes(StandardCharsets.UTF_8));
     Files.createSymbolicLink(work.resolve("link"), precious);
     FileUtilities.deleteAllFiles(dir.resolve("work").toString(), ".txt");

     assertFalse(Files.exists(work.resolve("b.txt")));
     assertTrue(Files.exists(work.resolve("c.html")));
     FileUtilities.deleteAllFiles(dir.resolve("work").toString());
     assertArrayEquals(new String[0], work.toFile().list());
     assertTrue(Files.exists(precious.resolve("a.txt")));
   }

   @Test
   void deleteEmptyFoldersDoesNotFollowLinks() throws IOException {
     java.nio.file.Path dir = Files.createDirectories(tempDir.resolve("delete-empty-links"));
     java.nio.file.Path empty = Files.createDirectories(dir.resolve("elsewhere").resolve("empty"));
     java.nio.file.Path work = Files.createDirectories(dir.resolve("work").resolve("a").resolve("b"));
     Files.createSymbolicLink(dir.resolve("work").resolve("link"), dir.resolve("elsewhere"));
     FileUtilities.deleteEmptyFolders(dir.resolve("work").toFile());
     assertFalse(Files.exists(work));
     assertTrue(Files.exists(empty));
     assertTrue(Files.exists(dir.resolve("work").resolve("link"), java.nio.file.LinkOption.NOFOLLOW_LINKS));
   }
} 