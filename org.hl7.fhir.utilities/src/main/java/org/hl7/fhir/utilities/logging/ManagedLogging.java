package org.hl7.fhir.utilities.logging;

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

import javax.annotation.Nonnull;

/**
 * see security.md - manages logging by the FHIR HAPI Core library
 *  
 * @author Grahame
 *
 */
public class ManagedLogging {
  
  public interface ILoggingProvider {
    public void log(String msg);
  }

  public enum LoggingPolicy {
    CONSOLE, // log messages go to System.out (default)
    IGNORED, // log messages don't go anywhere
    SLF4J, // log messages go to SLF4J
    CUSTOM, // log messages to an ILoggingProvider implementation
  }

  private static LoggingPolicy logPolicy = LoggingPolicy.CONSOLE; // for legacy reasons
  private static ILoggingProvider provider;
  
  
  public static LoggingPolicy getLogPolicy() {
    return logPolicy;
  }

  public static void setLogPolicy(@Nonnull LoggingPolicy logPolicy) {
    ManagedLogging.logPolicy = logPolicy;
  }

  public static ILoggingProvider getProvider() {
    return provider;
  }

  public static void setProvider(ILoggingProvider provider) {
    ManagedLogging.provider = provider;
  }

  /** 
   * message
   **/
  public static void log(String message) throws IOException {
    switch (logPolicy) {
    case CONSOLE:
      System.out.println(message);
    case CUSTOM:
      if (provider != null) {
        provider.log(message);
      }
    case IGNORED:
      // nothing
      break;
    case SLF4J:
      // todo
      break;
    default:
      throw new Error("LogPolicy is not valid ");    
    }
  }


}