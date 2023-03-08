package org.hl7.fhir.utilities;


import org.apache.commons.io.IOUtils;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FTPClientTest implements ResourceLoaderTests {

  public static final String DUMMY_PASSWORD = "dummyPassword123";
  public static final String DUMMY_USER = "dummyUser";
  public static final String RELATIVE_PATH_1 = "relativePath1";

  public static final String RELATIVE_PATH_2 = "relativePath2";
  public static final String DUMMY_FILE_TO_DELETE = "dummyFileToDelete";

  public static final String DUMMY_FILE_TO_UPLOAD = "dummyFileToUpload";
  public static final int FAKE_FTP_PORT = 8022;
  public static final String DUMMY_FILE_CONTENT = "Dummy file content\nMore content\n";
  public static final String LOCALHOST = "localhost";


  FakeFtpServer fakeFtpServer;

  Path fakeFtpDirectory;

  Path relativePath1;

  Path relativePath2;


  Path dummyFileToDeletePath;


  Path dummyFileToUploadPath;
  Path dummyUploadedFilePath;

  String dummyFileContent;

  @BeforeEach
  public void setup() throws IOException {
    setupDummyFileToUpload();
    setupFakeFtpDirectory();
    setupFakeFtpServer();
  }

  private void setupDummyFileToUpload() throws IOException {
    dummyFileContent = createDummyFileContent();

    dummyFileToUploadPath = Files.createTempFile("dummyFtpFileToUpload", "dummy");
    Files.write(dummyFileToUploadPath, DUMMY_FILE_CONTENT.getBytes(StandardCharsets.UTF_8));
  }

  private String createDummyFileContent() {
    return DUMMY_FILE_CONTENT;
  }

  public void setupFakeFtpServer() throws IOException {
    fakeFtpServer = new FakeFtpServer();
    fakeFtpServer.setServerControlPort(FAKE_FTP_PORT);
    fakeFtpServer.addUserAccount(new UserAccount(DUMMY_USER, DUMMY_PASSWORD, fakeFtpDirectory.toFile().getAbsolutePath()));

    FileSystem fileSystem = useWindowsFileSystem()
      ? new WindowsFakeFileSystem()
      : new UnixFakeFileSystem();
    fileSystem.add(new DirectoryEntry(fakeFtpDirectory.toFile().getAbsolutePath()));
    fileSystem.add(new DirectoryEntry(relativePath1.toFile().getAbsolutePath()));
    fileSystem.add(new DirectoryEntry(relativePath2.toFile().getAbsolutePath()));
    fileSystem.add(new FileEntry(dummyFileToDeletePath.toFile().getAbsolutePath()));
    //fileSystem.add(new FileEntry("c:\\data\\run.exe"));
    fakeFtpServer.setFileSystem(fileSystem);

    fakeFtpServer.start();
  }

  private static boolean useWindowsFileSystem() {
    return System.getProperty("os.name") != null && System.getProperty("os.name").startsWith("Windows");
  }

  private void setupFakeFtpDirectory() throws IOException {
    fakeFtpDirectory = Files.createTempDirectory("fakeFtp");
    relativePath1 = fakeFtpDirectory.resolve(RELATIVE_PATH_1);
    relativePath2 = relativePath1.resolve(RELATIVE_PATH_2);
    Files.createDirectory(relativePath1);
    Files.createDirectory(relativePath2);

    dummyFileToDeletePath = Files.createFile(relativePath2.resolve(DUMMY_FILE_TO_DELETE));
    dummyUploadedFilePath = relativePath2.resolve(DUMMY_FILE_TO_UPLOAD);
  }

  @AfterEach
  public void tearDownFakeFtpServer() {
    fakeFtpServer.stop();
  }

  @ParameterizedTest
  @CsvSource({"/", "/test", "/test", "/test/", "/test1/test2", "/test1/test2", "test", "test/", "test1/test2"})
  public void testValidRelativePaths(String path) {
    FTPClient client = new FTPClient("localhost", path, DUMMY_USER, DUMMY_PASSWORD);
    assertTrue(path.length() == client.getPath().length() || path.length() + 1 == client.getPath().length());
    assertTrue(client.getPath().startsWith(path));
    assertTrue(client.getPath().endsWith("/"));
  }

  @Test
  public void testEmptyRelativePath() {
    FTPClient client = new FTPClient("localhost", "", DUMMY_USER, DUMMY_PASSWORD);
    assertEquals("", client.getPath());
  }

  @Test
 public void testDelete() throws IOException {

    FTPClient client = connectToFTPClient();

    String deleteFilePath = dummyFileToDeletePath.toFile().getAbsolutePath();
    assertTrue(fakeFtpServer.getFileSystem().exists(deleteFilePath));

    client.delete( RELATIVE_PATH_2 + "/" + DUMMY_FILE_TO_DELETE);
    assertFalse(fakeFtpServer.getFileSystem().exists(deleteFilePath));

    assertTrue(client.getDeleteFileTimeMillis() >= 0);
    assertTrue(client.getStoreFileTimeMillis() == 0);
    assertTrue(client.getCreateRemotePathIfNotExistsMillis() == 0);
 }

  private  FTPClient connectToFTPClient() throws IOException {
    FTPClient client = new FTPClient(LOCALHOST, FAKE_FTP_PORT,  RELATIVE_PATH_1, DUMMY_USER, DUMMY_PASSWORD);
    client.connect();

    assertAllMillisFieldsAreZero(client);
    return client;
  }

  @Test
 public void testDelete2() throws IOException {

    FTPClient client = connectToFTPClient();

    String deleteFilePath = dummyFileToDeletePath.toFile().getAbsolutePath();
    assertTrue(fakeFtpServer.getFileSystem().exists(deleteFilePath));

    client.delete( RELATIVE_PATH_2 + "/" + DUMMY_FILE_TO_DELETE);
    assertFalse(fakeFtpServer.getFileSystem().exists(deleteFilePath));
    client.disconnect();

    assertTrue(client.getDeleteFileTimeMillis() >= 0);
    assertTrue(client.getStoreFileTimeMillis() == 0);
    assertTrue(client.getCreateRemotePathIfNotExistsMillis() == 0);
 }


  @Test
  public void testUpload() throws IOException {

    FTPClient client = connectToFTPClient();

    String uploadFilePath = dummyUploadedFilePath.toFile().getAbsolutePath();
    assertFalse(fakeFtpServer.getFileSystem().exists(uploadFilePath));

    client.upload(dummyFileToUploadPath.toFile().getAbsolutePath(), RELATIVE_PATH_2 + "/" + DUMMY_FILE_TO_UPLOAD);

    assertUploadedFileCorrect(uploadFilePath);

    assertTrue(client.getDeleteFileTimeMillis() == 0);
    assertTrue(client.getStoreFileTimeMillis() > 0);
    assertTrue(client.getCreateRemotePathIfNotExistsMillis() == 0);
  }

  private void assertUploadedFileCorrect(String uploadedFilePath) throws IOException {
    assertTrue(fakeFtpServer.getFileSystem().exists(uploadedFilePath));
    FileEntry fileEntry = (FileEntry)fakeFtpServer.getFileSystem().getEntry(uploadedFilePath);
    assertNotNull(fileEntry);
    InputStream inputStream = fileEntry.createInputStream();
    byte[] bytes = IOUtils.toByteArray(inputStream);
    String actualContent = new String(bytes, StandardCharsets.UTF_8);
    assertEquals(DUMMY_FILE_CONTENT,actualContent);
  }

  @Test
  public void testCreateRemotePathDoesntExist() throws IOException {
    FTPClient client = connectToFTPClient();

    Path newPath1 = relativePath2.resolve("newPath1");
    Path newPath2 = newPath1.resolve("newPath2");

    assertFalse(fakeFtpServer.getFileSystem().exists(newPath1.toFile().getAbsolutePath()));
    assertFalse(fakeFtpServer.getFileSystem().exists(newPath2.toFile().getAbsolutePath()));

    client.createRemotePathIfNotExists(RELATIVE_PATH_2 + "/newPath1/newPath2/newFile.txt");

    assertTrue(fakeFtpServer.getFileSystem().exists(newPath1.toFile().getAbsolutePath()));
    assertTrue(fakeFtpServer.getFileSystem().exists(newPath2.toFile().getAbsolutePath()));

    assertTrue(client.getDeleteFileTimeMillis() == 0);
    assertTrue(client.getStoreFileTimeMillis() == 0);
    assertTrue(client.getCreateRemotePathIfNotExistsMillis() >= 0);
  }

  private void assertAllMillisFieldsAreZero(FTPClient client) {
    assertTrue(client.getDeleteFileTimeMillis() == 0);
    assertTrue(client.getStoreFileTimeMillis() == 0);
    assertTrue(client.getCreateRemotePathIfNotExistsMillis() == 0);
  }

  @Test
  public void testUploadWherePathDoesntExist() throws IOException {

    Path newPath1 = relativePath2.resolve("newPath1");
    Path newPath2 = newPath1.resolve("newPath2");

    FTPClient client = connectToFTPClient();

    Path uploadFilePath = newPath2.resolve(DUMMY_FILE_TO_UPLOAD);
    assertFalse(fakeFtpServer.getFileSystem().exists(uploadFilePath.toFile().getAbsolutePath()));

    assertFalse(fakeFtpServer.getFileSystem().exists(newPath1.toFile().getAbsolutePath()));
    assertFalse(fakeFtpServer.getFileSystem().exists(newPath2.toFile().getAbsolutePath()));

    client.upload(dummyFileToUploadPath.toFile().getAbsolutePath(),RELATIVE_PATH_2 + "/newPath1/newPath2/" + DUMMY_FILE_TO_UPLOAD);

    assertTrue(fakeFtpServer.getFileSystem().exists(newPath1.toFile().getAbsolutePath()));
    assertTrue(fakeFtpServer.getFileSystem().exists(newPath2.toFile().getAbsolutePath()));

    assertUploadedFileCorrect(uploadFilePath.toFile().getAbsolutePath());

    assertTrue(client.getDeleteFileTimeMillis() == 0);
    assertTrue(client.getStoreFileTimeMillis() > 0);
    assertTrue(client.getCreateRemotePathIfNotExistsMillis() > 0);
  }
}
