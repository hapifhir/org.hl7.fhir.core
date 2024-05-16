package org.hl7.fhir.utilities.http;

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



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.Utilities;

/**
 * see security.md - manages access to the local file system by the FHIR HAPI Core library
 * 
 * By using accessPolicy, allowedDomains and accessor, a host java application can control 
 * whether this library has direct access to the web (and which domains it is allowed to access),
 * or whether the host application provides controlled access, or whether no access is allowed at all
 * (in which case other information providers need to be provided)
 *  
 * @author Grahame
 *
 */
public class ManagedWebAccess {
  
  public interface IWebAccessor {
    HTTPResult get(String url, String accept, String userAgent, String authenticationHeader) throws IOException;
    HTTPResult post(String url, byte[] bytes, String contentType, String accept, String userAgent, String authenticationHeader) throws IOException;
    HTTPResult put(String url, byte[] bytes, String contentType, String accept, String userAgent, String authenticationHeader) throws IOException;
  }

  public enum WebAccessPolicy {
    DIRECT, // open access to the local file system, though access can be restricted only to files under the paths in AllowedPaths
    MANAGED, // no access except by the FileSystemProxyProvider
    PROHIBITED, // no access at all to File() services
  }

  private static WebAccessPolicy accessPolicy = WebAccessPolicy.DIRECT; // for legacy reasons
  private static List<String> allowedDomains = new ArrayList<>();
  private static IWebAccessor accessor;
  private static String userAgent;
  
  
  public static WebAccessPolicy getAccessPolicy() {
    return accessPolicy;
  }

  public static void setAccessPolicy(WebAccessPolicy accessPolicy) {
    ManagedWebAccess.accessPolicy = accessPolicy;
  }

  private static boolean inAllowedPaths(String pathname) {
    if (allowedDomains.isEmpty()) {
      return true;
    }
    for (String s : allowedDomains) {
      if (pathname.startsWith(s)) {
        return true;
      }
    }
    return false;
  }

  public static String getUserAgent() {
    return userAgent;
  }

  public static void setUserAgent(String userAgent) {
    ManagedWebAccess.userAgent = userAgent;
  }

  public static HTTPResult get(String url) throws IOException {
    return get(url, null, null, null);
  }

  public static HTTPResult get(String url, String accept) throws IOException {
    return get(url, accept, null, null);
  }
  
  public static HTTPResult get(String url, String accept, String userAgent, String authenticationHeader) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(url)) {
        throw new IOException("The pathname '"+url+"' cannot be accessed by policy");
      }
      return new SimpleHTTPClient().get(url, accept);
    case MANAGED:
      return accessor.get(url, accept, userAgent, authenticationHeader);
    case PROHIBITED:
      throw new IOException("Access the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public static HTTPResult post(String url, byte[] content, String contentType, String accept) throws IOException {
    return post(url, content, contentType, accept, null, null);
  }
  
  public static HTTPResult post(String url, byte[] content, String contentType, String accept, String userAgent, String authenticationHeader) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(url)) {
        throw new IOException("The pathname '"+url+"' cannot be accessed by policy");
      }
      return new SimpleHTTPClient().post(url, contentType, content, accept);
    case MANAGED:
      return accessor.get(url, accept, userAgent, authenticationHeader);
    case PROHIBITED:
      throw new IOException("Access the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public static HTTPResult put(String url, byte[] content, String contentType, String accept, String userAgent, String authenticationHeader) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(url)) {
        throw new IOException("The pathname '"+url+"' cannot be accessed by policy");
      }
      return new SimpleHTTPClient().put(url, contentType, content, accept);
    case MANAGED:
      return accessor.get(url, accept, userAgent, authenticationHeader);
    case PROHIBITED:
      throw new IOException("Access the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }
}