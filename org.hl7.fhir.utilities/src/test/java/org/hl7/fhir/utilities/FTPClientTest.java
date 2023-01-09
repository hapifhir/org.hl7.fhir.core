package org.hl7.fhir.utilities;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.*;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hl7.fhir.utilities.tests.ResourceLoaderTests.getResourceAsInputStream;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FTPClientTest implements ResourceLoaderTests {

  public static final String DUMMY_PASSWORD = "dummyPassword123";
  public static final String DUMMY_USER = "dummyUser";
  public static final String RELATIVE_PATH_1 = "relativePath1";

  public static final String RELATIVE_PATH_2 = "relativePath2";
  public static final String DUMMY_FILE_TO_DELETE = "dummyFileToDelete";

  public static final String DUMMY_FILE_TO_UPLOAD = "dummyFileToUpload";


  FakeFtpServer fakeFtpServer;

  Path fakeFtpDirectory;

  Path relativePath1;

  Path relativePath2;


  Path dummyFileToDeletePath;

  Path dummyFileToUploadPath;

  @BeforeAll
  public void setupFakeFtpServer() throws IOException {
    setupFakeFtpDirectory();

    fakeFtpServer = new FakeFtpServer();
    fakeFtpServer.addUserAccount(new UserAccount(DUMMY_USER, DUMMY_PASSWORD, fakeFtpDirectory.toFile().getAbsolutePath()));

    FileSystem fileSystem = new UnixFakeFileSystem();
    fileSystem.add(new DirectoryEntry(fakeFtpDirectory.toFile().getAbsolutePath()));
    fileSystem.add(new DirectoryEntry(relativePath1.toFile().getAbsolutePath()));
    fileSystem.add(new DirectoryEntry(relativePath2.toFile().getAbsolutePath()));
    fileSystem.add(new FileEntry(dummyFileToDeletePath.toFile().getAbsolutePath()));
    //fileSystem.add(new FileEntry("c:\\data\\run.exe"));
    fakeFtpServer.setFileSystem(fileSystem);
    fakeFtpServer.start();
  }

  private void setupFakeFtpDirectory() throws IOException {
    fakeFtpDirectory = Files.createTempDirectory("fakeFtp");
    relativePath1 = fakeFtpDirectory.resolve(RELATIVE_PATH_1);
    relativePath2 = relativePath1.resolve(RELATIVE_PATH_2);
    Files.createDirectory(relativePath1);
    Files.createDirectory(relativePath2);

    dummyFileToDeletePath = Files.createFile(relativePath2.resolve(DUMMY_FILE_TO_DELETE));
    dummyFileToUploadPath = relativePath2.resolve(DUMMY_FILE_TO_UPLOAD);
  }

  @AfterAll
  public void tearDownFakeFtpServer() {
    fakeFtpServer.stop();
  }

  @Test
 public void testDelete() throws IOException {

    FTPClient client = new FTPClient();
    client.connect("localhost");
    boolean loginSuccess = client.login(DUMMY_USER, DUMMY_PASSWORD);

    int reply = client.getReplyCode();

    if(!FTPReply.isPositiveCompletion(reply)) {
      client.disconnect();
      System.err.println("FTP server refused connection.");
      System.exit(1);
    }

    assertTrue(loginSuccess);

    String deleteFilePath = dummyFileToDeletePath.toFile().getAbsolutePath();

    assertTrue(fakeFtpServer.getFileSystem().exists(deleteFilePath));

    client.deleteFile(RELATIVE_PATH_1 + "/"+ RELATIVE_PATH_2 + "/" + DUMMY_FILE_TO_DELETE);

    assertFalse(fakeFtpServer.getFileSystem().exists(deleteFilePath));

    client.disconnect();

 }

  @Test
  public void testUpload() throws IOException {

    FTPClient client = new FTPClient();
    client.connect("localhost");
    boolean loginSuccess = client.login(DUMMY_USER, DUMMY_PASSWORD);

    int reply = client.getReplyCode();

    if(!FTPReply.isPositiveCompletion(reply)) {
      client.disconnect();
      System.err.println("FTP server refused connection.");
      System.exit(1);
    }

    assertTrue(loginSuccess);

    String uploadFilePath = dummyFileToUploadPath.toFile().getAbsolutePath();

    InputStream localStream = getResourceAsInputStream("npm", "PackageClient-testCaseWithId.json");

    assertFalse(fakeFtpServer.getFileSystem().exists(uploadFilePath));

    client.appendFile(RELATIVE_PATH_1 + "/"+ RELATIVE_PATH_2 + "/" + DUMMY_FILE_TO_UPLOAD, localStream);

    assertTrue(fakeFtpServer.getFileSystem().exists(uploadFilePath));

    client.disconnect();

  }

}
