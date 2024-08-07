package org.hl7.fhir.r4.model.codesystems;

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

// Generated on Wed, Jan 30, 2019 16:19-0500 for FHIR v4.0.0

import org.hl7.fhir.r4.model.EnumFactory;

public class MetricColorEnumFactory implements EnumFactory<MetricColor> {

  public MetricColor fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("black".equals(codeString))
      return MetricColor.BLACK;
    if ("red".equals(codeString))
      return MetricColor.RED;
    if ("green".equals(codeString))
      return MetricColor.GREEN;
    if ("yellow".equals(codeString))
      return MetricColor.YELLOW;
    if ("blue".equals(codeString))
      return MetricColor.BLUE;
    if ("magenta".equals(codeString))
      return MetricColor.MAGENTA;
    if ("cyan".equals(codeString))
      return MetricColor.CYAN;
    if ("white".equals(codeString))
      return MetricColor.WHITE;
    throw new IllegalArgumentException("Unknown MetricColor code '" + codeString + "'");
  }

  public String toCode(MetricColor code) {
       if (code == MetricColor.NULL)
           return null;
       if (code == MetricColor.BLACK)
      return "black";
    if (code == MetricColor.RED)
      return "red";
    if (code == MetricColor.GREEN)
      return "green";
    if (code == MetricColor.YELLOW)
      return "yellow";
    if (code == MetricColor.BLUE)
      return "blue";
    if (code == MetricColor.MAGENTA)
      return "magenta";
    if (code == MetricColor.CYAN)
      return "cyan";
    if (code == MetricColor.WHITE)
      return "white";
    return "?";
   }

  public String toSystem(MetricColor code) {
    return code.getSystem();
  }

}