package org.hl7.fhir.utilities;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPReply;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FTPClient {

  private final org.apache.commons.net.ftp.FTPClient clientImpl;

  final String server;

  final String path;

  final String user;

  final String password;

  final int port;

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
    if (path.endsWith("/")) {
      this.path = path;
    } else {
      this.path = path + "/";
    }
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

  private String resolveRemotePath(String path) {
    return String.join("", this.path, path);
  }

  /**
   * Upload a file from the local system to the FTP Server
   * @param source - absolute path on local system
   * @param path - relative to the path provided in the constructor
   */
  public void upload(String source, String path) throws IOException {
    String resolvedPath = resolveRemotePath(path);
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
