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
import java.util.Map;
import java.util.Set;

public interface TranslationServices {
  /**
   * General translation functionality - given a string, translate it to a different language
   * 
   * @param context - for debugging purposes
   * @param value - the string to translate
   * @param targetLang - the target language to translate to. 
   * 
   * @return the translated string, or value if no translation is found
   */
  String translate(String context, String value, String targetLang);

  /**
   * General translation functionality - given a string, translate it to a different language, but also perform String.format on the outcome.
   * 
   * @param contest
   * @param lang
   * @param string2
   * @param args
   * @return
   */
  String translateAndFormat(String contest, String lang, String string2, Object... args);

  /** 
   * equivalent to the general translation operation, but the context that provides the transations specifies the target language
   *  
   * @param context
   * @param value
   * @return
   */
  String translate(String context, String value);

  /**
   * Get a list of all translations available for a phrase
   * 
   * @param value
   * @return
   */
  Map<String, String> translations(String value);

  /** 
   * localization for converting a decimal to language specific representation
   * 
   * @param value
   * @return
   */
  String toStr(float value);

  /** 
   * localization for converting a date to language specific representation
   * 
   * @param value
   * @return
   */
  String toStr(Date value);

  /**
   * get a list of translation codes by category
   * @param category
   * @return
   */
  Set<String> listTranslations(String category);

}