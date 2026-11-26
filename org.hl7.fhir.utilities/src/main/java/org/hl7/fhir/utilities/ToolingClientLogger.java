package org.hl7.fhir.utilities;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.util.List;
import java.util.Locale;

public interface ToolingClientLogger {

  /**
   * A header (of a request or a response) as it can be logged: the value of anything that authenticates a request or a
   * session is masked (see isSecretHeader). Logs can be published (the IG publisher's qa-tx.html), and a server
   * configured with token or basic authentication sends an Authorization header, not an Api-Key, and can set cookies
   */
  static String presentHeader(String header) {
    int i = header == null ? -1 : header.indexOf(':');
    if (i < 0) {
      return header;
    }
    String name = header.substring(0, i).trim();
    return isSecretHeader(name) ? name + ": xxxxxxxxxxxxxxxx" : header;
  }

  /**
   * Whether a header's value is (or carries) a secret: Authorization, Proxy-Authorization, Cookie, Set-Cookie, Api-Key,
   * and any header whose name says it is about authentication, a session, credentials, a key, a token, a secret or a
   * password - servers make up their own names, so they're matched loosely. The challenges a server sends
   * (WWW-Authenticate, Proxy-Authenticate) aren't secrets, and say why a request was refused, so they're kept
   */
  static boolean isSecretHeader(String name) {
    // Locale.ROOT: in a Turkish locale, "COOKIE".toLowerCase() has a dotless i in it, and matches nothing
    String n = name.trim().toLowerCase(Locale.ROOT);
    if (n.endsWith("-authenticate")) {
      return false;
    }
    return n.contains("auth") || n.contains("cookie") || n.contains("session") || n.contains("credential")
        || n.contains("key") || n.contains("token") || n.contains("secret") || n.contains("password");
  }

  void logRequest(String method, String url, List<String> headers, byte[] body);
  void logResponse(String outcome, List<String> headers, byte[] body, long length);

  /**
   * The request logged by logRequest() got no response: the connection failed, or timed out
   * waiting for one. Without this the log shows the request and nothing else, and a call that
   * held things up for a minute is easily missed.
   *
   * @param error what went wrong (the exception's class and message)
   * @param elapsed how long the request ran before it failed, in milliseconds
   */
  default void logFailure(String error, long elapsed) {
  }
  String getLastId();
  void clearLastId();

}