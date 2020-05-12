package org.hl7.fhir.r5.context;

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



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.r5.utils.client.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

public class TextClientLogger implements ToolingClientLogger {

  private PrintStream file;
  private int id = 0;
  private String lastId;
  
  public TextClientLogger(String log) {
    if (log != null) {
      try {
        file = new PrintStream(new FileOutputStream(log));
      } catch (FileNotFoundException e) {
      }
    }
  }

  @Override
  public void logRequest(String method, String url, List<String> headers, byte[] body) {
    if (file == null)
      return;
    id++;
    lastId = Integer.toString(id);
    file.println("\r\n--- "+lastId+" -----------------\r\nRequest: \r\n");
    file.println(method+" "+url+" HTTP/1.0");
    for (String s : headers)  
      file.println(Utilities.escapeXml(s));
    if (body != null) {
      file.println("");
      try {
        file.println(Utilities.escapeXml(new String(body, "UTF-8")));
      } catch (UnsupportedEncodingException e) {
      }
    }
  }

  @Override
  public void logResponse(String outcome, List<String> headers, byte[] body) {
    if (file == null)
      return;
    file.println("\r\n\r\nResponse: \r\n");
    file.println(outcome);
    for (String s : headers)  
      file.println(Utilities.escapeXml(s));
    if (body != null) {
      file.println("");
      try {
        file.println(Utilities.escapeXml(new String(body, "UTF-8")));
      } catch (UnsupportedEncodingException e) {
      }
    }
  }

  public String getLastId() {
    return lastId;
  }

  public void clearLastId() {
    lastId = null;    
  }

}