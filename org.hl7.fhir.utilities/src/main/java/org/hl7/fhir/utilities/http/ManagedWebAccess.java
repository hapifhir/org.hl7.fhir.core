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



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

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

  public enum WebAccessPolicy {
    DIRECT, // open access to the web, though access can be restricted only to domains in AllowedDomains
    MANAGED, // no access except by the IWebAccessor
    PROHIBITED, // no access at all to the web
  }

  @Getter
  private static WebAccessPolicy accessPolicy = WebAccessPolicy.DIRECT; // for legacy reasons

  @Getter
  private static List<String> allowedDomains = new ArrayList<>();

  @Getter
  private static IWebAccessorSimple accessor;
  @Getter
  private static String userAgent;
  @Getter
  private static List<ServerDetailsPOJO> serverAuthDetails;

  public static void setAccessPolicy(WebAccessPolicy accessPolicy) {
    ManagedWebAccess.accessPolicy = accessPolicy;
  }

  static boolean inAllowedPaths(String pathname) {
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

  public static void setUserAgent(String userAgent) {
    ManagedWebAccess.userAgent = userAgent;
  }

  public static ManagedWebAccessBuilder builder() {
    return new ManagedWebAccessBuilder(getUserAgent(), getServerAuthDetails());
  }

  public static HTTPResult get(String url) throws IOException {
    return builder().get(url);
  }

  public static HTTPResult get(String url, String accept) throws IOException {
    return builder().withAccept(accept).get(url);
  }

  public static HTTPResult post(String url, byte[] content, String contentType, String accept) throws IOException {
    return builder().withAccept(accept).post(url, content, contentType);
  }
  

  public static HTTPResult put(String url, byte[] content, String contentType, String accept) throws IOException {
    return builder().withAccept(accept).put(url, content, contentType);
  }

}