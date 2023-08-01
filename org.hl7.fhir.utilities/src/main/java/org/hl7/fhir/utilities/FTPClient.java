package org.hl7.fhir.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class FTPClient {

  private static final Logger logger = LoggerFactory.getLogger(FTPClient.class);

  private final org.apache.commons.net.ftp.FTPClient clientImpl;

  @Getter
  private long createRemotePathIfNotExistsNanos;

  @Getter
  private long storeFileTimeNanos;

  @Getter
  private long deleteFileTimeNanos;

  @Getter
  private final String server;

  @Getter
  private final String path;

  private String resolvedPath = null;

  @Getter
  private final String user;

  @Getter
  private final String password;

  @Getter
  private final int port;

  @Getter
  private final String remoteSeparator;

  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  private class FTPReplyCodeAndString {
    @Getter
    private final int replyCode;

    @Getter
    private final String replyString;

    public String toString()
    {
      return "Reply code: " + replyCode + " Message: " + replyString;
    }
  }

  /**
   * Connect to an FTP server
   * @param server - the server to connect to (usually just an IP address). It's up to the system to figure out access (VPN etc)
   * @param path - the path on the FTP server to treat all the operations as relative to 
   * @param user - username for the FTP server
   * @param password - password for the FTP server
   */
  public FTPClient(String server, String path, String user, String password) {
    this (server, -1, path, user, password);
  }

  protected FTPClient(String server, int port, String path, String user, String password) {
    this.server = server;
    this.port = port;
    this.remoteSeparator = "/";
    this.path = buildPath(path);

    this.user = user;
    this.password = password;

    clientImpl = new org.apache.commons.net.ftp.FTPClient();
  }

  private String buildPath(String path) {
    if (path.length() == 0) {
      return "";
    }
    if (path.endsWith(remoteSeparator))
    {
      return path;
    }
    return path + remoteSeparator;
  }

  /**
   * Connect to the server, throw an exception if it fails
   */
  public void connect() throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    
    if (port != -1) {
      logger.debug("Connecting to : " + server + ":" + port);
      clientImpl.connect(server, port);
      logger.debug("Connected");
    }
    else {
      logger.debug("Connecting to : " + server);
      clientImpl.connect(server);
      logger.debug("Connected");
    }

    clientImpl.login(user, password);

    throwExceptionForNegativeCompletion("FTP server could not connect.", true);

    resetTimers();

    clientImpl.setFileType(FTP.BINARY_FILE_TYPE);
    clientImpl.enterLocalPassiveMode();

    logger.debug("Setting initial working directory: " + clientImpl.printWorkingDirectory());

    clientImpl.changeWorkingDirectory(path);

    throwExceptionForNegativeCompletion("FTP server could not establish default working directory", true);
    logger.debug("Set initial working directory.");

    logger.debug("Resolving remote resolved path.");
    resolvedPath = clientImpl.printWorkingDirectory();

    logger.debug("Resolved remote resolved path: " + resolvedPath);
  }

  public void setBufferSize(int bufferSize) {
    clientImpl.setBufferSize(bufferSize);
  }

  public int getBufferSize() {
    return clientImpl.getBufferSize();
  }

  private void resetTimers() {
    this.createRemotePathIfNotExistsNanos = 0;
    this.storeFileTimeNanos = 0;
    this.deleteFileTimeNanos = 0;
  }

  /**
   * Delete a file on the FTP server
   * 
   * @param path - relative to the path provided in the constructor 
   */
  public void delete(String path) throws IOException {
    String resolvedPath = resolveRemotePath(path);
    logger.debug("Deleting remote file: " + resolvedPath);
    long startTime = System.nanoTime();
    clientImpl.deleteFile(resolvedPath);
    this.deleteFileTimeNanos += System.nanoTime() - startTime;
    throwExceptionForNegativeCompletion("Error deleting file.", false);
    logger.debug("Deleted remote file: " + resolvedPath);
  }

  /**
   * Takes a file path and creates all intermediate directories if they do not yet exist.
   * @param filePath relative to the path provided in the constructor and including the file name
   * @throws IOException
   */
  protected void createRemotePathIfNotExists(String filePath) throws IOException {
    long startTime = System.nanoTime();
    String[] subPath = filePath.split(remoteSeparator);
    try {
    for (int i = 0 ; i < subPath.length - 1; i++){
      if (subPath[i].isEmpty() ) {
        continue;
      }
      boolean exists = clientImpl.changeWorkingDirectory(subPath[i]);
      if (!exists) {
        logger.debug("Creating non-existent directory: " + clientImpl.printWorkingDirectory() + remoteSeparator + subPath[i] + " Creating");
        clientImpl.makeDirectory(subPath[i]);
        throwExceptionForNegativeCompletion("Creating directory:", true);
        logger.debug("Created directory: " + subPath[i]);

        logger.debug("Changing to created directory: " + subPath[i]);
        clientImpl.changeWorkingDirectory(subPath[i]);
        throwExceptionForNegativeCompletion("Changing to directory:", true);
        logger.debug("Changed to directory: " + subPath[i]);
      }
    }} catch (IOException e) {
      throw new IOException("Error creating remote path: " + filePath, e);
    } finally {
      logger.debug("Changing to original directory: " + this.resolvedPath);
      clientImpl.changeWorkingDirectory(this.resolvedPath);
      logger.debug("Changed to original directory: " + this.resolvedPath);
    }
    this.createRemotePathIfNotExistsNanos += System.nanoTime() - startTime;
  }

  protected boolean remotePathExists(String path) throws IOException {
    boolean output;
    try {
      output = clientImpl.changeWorkingDirectory(path);
    } finally {
      clientImpl.changeWorkingDirectory(this.resolvedPath);
    }
    return output;
  }

  private String resolveRemotePath(String path) {
    if (path.startsWith(remoteSeparator)) {
      throw new IllegalArgumentException("Absolute remote path is not permitted. Path: " + path);
    }
    return String.join(remoteSeparator, path.replace(File.separator, remoteSeparator));
  }

  /**
   * Upload a file from the local system to the FTP Server
   * @param source - absolute path on local system
   * @param path - relative to the path provided in the constructor
   */
  public void upload(String source, String path) throws IOException {
    String resolvedPath = resolveRemotePath(path);
    logger.debug("Uploading file to remote path: " + resolvedPath);

    attemptUpload(source, resolvedPath);

    FTPReplyCodeAndString reply = getFTPReplyCodeAndString();
    if (FTPReply.isPositiveCompletion(reply.replyCode)) {
      logger.debug("Uploaded file: " + resolvedPath);
      return;
    } else if (possibleDirectoryNotExistsCode(reply)) {
      logger.debug("Uploading failed with reply: " + reply);
      createRemotePathIfNotExists(resolvedPath);
      attemptUpload(source, resolvedPath);
      throwExceptionForNegativeCompletion("Error uploading file (second attempt).", false);
      logger.debug("Uploaded file after path creation: " + resolvedPath);
      return;
    }

    throwExceptionForNegativeCompletion(reply,"Error uploading file.", false);
    logger.debug("Remote file uploaded: " + resolvedPath);
  }


  private boolean possibleDirectoryNotExistsCode(FTPReplyCodeAndString reply) {
    /*
    Note: This code may be 550 on some servers (IIS) and 553 on others (mockftpserver).
     */
    return reply.replyCode == 550 || reply.replyCode == 553;
  }

  private void attemptUpload(String source, String resolvedPath) throws IOException {
    final long startTime = System.nanoTime();
    FileInputStream localStream = new FileInputStream(source);
    try {
      clientImpl.storeFile(resolvedPath, localStream);
    } finally {
      localStream.close();
    }
    this.storeFileTimeNanos += System.nanoTime() - startTime;
  }

  private FTPReplyCodeAndString getFTPReplyCodeAndString() {
    final int replyCode = clientImpl.getReplyCode();
    final String replyString = clientImpl.getReplyString();

    return new FTPReplyCodeAndString(replyCode, replyString);
  }

  private void throwExceptionForNegativeCompletion(String localErrorMessage, boolean disconnectOnError) throws IOException {
    FTPReplyCodeAndString reply = getFTPReplyCodeAndString();
    throwExceptionForNegativeCompletion(reply, localErrorMessage, disconnectOnError);
  }

  private void throwExceptionForNegativeCompletion(FTPReplyCodeAndString reply, String localErrorMessage, boolean disconnectOnError) throws IOException {
    if (FTPReply.isPositiveCompletion(reply.replyCode)) {
      return;
    }

    if (disconnectOnError) {
      clientImpl.disconnect();
    }
    throw new IOException(localErrorMessage + " " + reply);
  }

  public void disconnect() throws IOException {
    clientImpl.disconnect();
  }


  public static void main(String[] args) throws IOException, FHIRException {
    FTPClient ftp = new FTPClient(getNamedParam(args, "-upload-server"), getNamedParam(args, "-upload-path"), getNamedParam(args, "-upload-user"), getNamedParam(args, "-upload-password"));
    ftp.connect();
    ftp.upload("/Users/grahamegrieve/temp/test.xml", "testing/test.xml");
    ftp.delete("testing/test.xml");
    ftp.disconnect();
  }
  private static String getNamedParam(String[] args, String param) {
    boolean found = false;
    for (String a : args) {
      if (found)
        return a;
      if (a.equals(param)) {
        found = true;
      }
    }
    return null;
  }

  
}
