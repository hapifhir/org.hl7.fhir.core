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



import java.util.Date;

public class TranslatingUtilities {

  private TranslationServices translator;

  public TranslationServices getTranslator() {
    return translator;
  }

  public void setTranslator(TranslationServices translator) {
    this.translator = translator;
  }
  
  protected String translate(String context, String value) {
    return hasTranslator() ? translator.translate(context, value) : value;
  }

  protected boolean hasTranslator() {
    return translator != null;
  }

  public String toStr(int value) {
    return hasTranslator() ? translator.toStr(value) : Integer.toString(value);
  }
  
  public String toStr(Date value) {
    return hasTranslator() ? translator.toStr(value) : value.toString();
  }
  
  public String translate(String context, String value, Object... args) {
    if (hasTranslator()) {
      String alt = translator.translate(context, value);
      if (alt != null)
        value = alt;
    }
    return String.format(value, args);      
  }
  
  
}