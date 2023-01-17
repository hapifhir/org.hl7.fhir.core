package org.hl7.fhir.utilities;

import lombok.Getter;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FTPClient {

  private final org.apache.commons.net.ftp.FTPClient clientImpl;

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

  private final String remoteSeparator;

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
    this.path = path.endsWith(remoteSeparator)
      ? path
      : path + remoteSeparator;

    this.user = user;
    this.password = password;

    clientImpl = new org.apache.commons.net.ftp.FTPClient();
  }

  /**
   * Connect to the server, throw an exception if it fails
   */
  public void connect() throws IOException {
    if (port != -1) {
      clientImpl.connect(server, port);
    }
    else {
      clientImpl.connect(server);
    }

    clientImpl.login(user, password);

    checkForPositiveCompletionAndLogErrors("FTP server could not connect.", true);

    System.out.println("Working directory:  " + clientImpl.printWorkingDirectory());

    clientImpl.changeWorkingDirectory(path);

    checkForPositiveCompletionAndLogErrors("FTP server could not establish default working directory", true);

    resolvedPath = clientImpl.printWorkingDirectory();
  }

  /**
   * Delete a file on the FTP server
   * 
   * @param path - relative to the path provided in the constructor 
   */
  public void delete(String path) throws IOException {
    String resolvedPath = resolveRemotePath(path);
    clientImpl.deleteFile(resolvedPath);

    checkForPositiveCompletionAndLogErrors("Error deleting file.", false);
  }

  protected void createRemotePathIfNotExists(String path) throws IOException {
    String[] subPath = path.split(remoteSeparator);
    try {
    for (int i = 0 ; i < subPath.length - 1; i++){
      boolean exists = clientImpl.changeWorkingDirectory(subPath[i]);
      System.out.println(clientImpl.printWorkingDirectory());
      if (!exists) {
        clientImpl.makeDirectory(subPath[i]);
        clientImpl.changeWorkingDirectory(subPath[i]);
      }
    }} catch (IOException e) {
      e.printStackTrace();
    } finally {
      clientImpl.changeWorkingDirectory(this.resolvedPath);
      System.out.println(clientImpl.printWorkingDirectory());
    }
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

  private String resolveRemotePath(String... path) {
    return String.join(remoteSeparator, path);
  }

  /**
   * Upload a file from the local system to the FTP Server
   * @param source - absolute path on local system
   * @param path - relative to the path provided in the constructor
   */
  public void upload(String source, String path) throws IOException {
    if (path.startsWith(remoteSeparator)) {
      throw new IllegalArgumentException("Absolute remote path is not permitted. Path: " + path);
    }
    String resolvedPath = resolveRemotePath(path);

    createRemotePathIfNotExists(path);

    FileInputStream localStream = new FileInputStream(source);
    clientImpl.setFileType(FTP.BINARY_FILE_TYPE);
    clientImpl.storeFile( resolvedPath, localStream);
    localStream.close();

    checkForPositiveCompletionAndLogErrors("Error uploading file.", false);
  }

  private void checkForPositiveCompletionAndLogErrors(String localErrorMessage, boolean disconnectOnError) throws IOException {
    int reply = clientImpl.getReplyCode();

    if (FTPReply.isPositiveCompletion(reply)) {
      return;
    }

    String remoteErrorMessage = clientImpl.getReplyString();
    if (disconnectOnError) {
      clientImpl.disconnect();
    }
    throw new IOException(localErrorMessage + " Reply code: " + reply + " Message: " + remoteErrorMessage);


  }

  public void disconnect() throws IOException {
    clientImpl.disconnect();
  }

}
