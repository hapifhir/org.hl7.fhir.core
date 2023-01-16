package org.hl7.fhir.utilities;


import org.apache.commons.io.IOUtils;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;

import org.junit.jupiter.api.*;
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
  public static final int FAKE_FTP_PORT = 8021;
  public static final String DUMMY_FILE_CONTENT = "Dummy file content\nMore content\n";


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

  @Test
 public void testDelete() throws IOException {

    FTPClient client = connectToFTPClient(RELATIVE_PATH_1 + "/");

    String deleteFilePath = dummyFileToDeletePath.toFile().getAbsolutePath();
    assertTrue(fakeFtpServer.getFileSystem().exists(deleteFilePath));

    client.delete( RELATIVE_PATH_2 + "/" + DUMMY_FILE_TO_DELETE);
    assertFalse(fakeFtpServer.getFileSystem().exists(deleteFilePath));
 }

  private static FTPClient connectToFTPClient(String defaultPath) throws IOException {
    FTPClient client = new FTPClient("localhost", FAKE_FTP_PORT, defaultPath, DUMMY_USER, DUMMY_PASSWORD);
    client.connect();
    return client;
  }

  @Test
 public void testDelete2() throws IOException {

    FTPClient client = connectToFTPClient(RELATIVE_PATH_1);

    String deleteFilePath = dummyFileToDeletePath.toFile().getAbsolutePath();
    assertTrue(fakeFtpServer.getFileSystem().exists(deleteFilePath));

    client.delete( RELATIVE_PATH_2 + "/" + DUMMY_FILE_TO_DELETE);
    assertFalse(fakeFtpServer.getFileSystem().exists(deleteFilePath));
    client.disconnect();
 }


  @Test
  public void testUpload() throws IOException {

    FTPClient client = connectToFTPClient(RELATIVE_PATH_1 + "/");

    String uploadFilePath = dummyUploadedFilePath.toFile().getAbsolutePath();

    assertFalse(fakeFtpServer.getFileSystem().exists(uploadFilePath));

    client.upload(dummyFileToUploadPath.toFile().getAbsolutePath(), RELATIVE_PATH_2 + "/" + DUMMY_FILE_TO_UPLOAD);

    assertTrue(fakeFtpServer.getFileSystem().exists(uploadFilePath));

    FileEntry fileEntry = (FileEntry)fakeFtpServer.getFileSystem().getEntry(uploadFilePath);
    InputStream inputStream = fileEntry.createInputStream();
    byte[] bytes = IOUtils.toByteArray(inputStream);
    String actualContent = new String(bytes, StandardCharsets.UTF_8);
    assertEquals(DUMMY_FILE_CONTENT,actualContent);
  }

 
}
