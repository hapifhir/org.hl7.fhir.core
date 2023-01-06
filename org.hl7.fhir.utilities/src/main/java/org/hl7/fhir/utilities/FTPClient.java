package org.hl7.fhir.utilities;

public class FTPClient {

  /**
   * Connect to an FTP server
   * @param server - the server to connect to (uusally just an IP address). It's up to the system to figure out access (VPN etc)
   * @param path - the path on the FTP server to treat all the operations as relative to 
   * @param user - username for the FTP server
   * @param password - password for the FTP server
   */
  public FTPClient(String server, String path, String user, String password) {
  }

  /**
   * Connect to the server, throw an exception if it fails
   */
  public void connect() {    
  }

  /**
   * Delete a file on the FTP server
   * 
   * @param path - relative to the path provided in the constructor 
   */
  public void delete(String path) {    
  }

  /**
   * Upload a file from the local system to the FTP Server
   * @param source - absolute path on local system
   * @param path - relative to the path provided in the constructor
   */
  public void upload(String source, String path) {

    
  }

}
