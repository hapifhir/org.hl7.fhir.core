package org.hl7.fhir.dstu2016may.model.codesystems;




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

// Generated on Sun, May 8, 2016 03:05+1000 for FHIR v1.4.0


import org.hl7.fhir.exceptions.FHIRException;

public enum HspcBodytempmethoddevice {

        /**
         * The electronic thermometer that displays body temperature in numeric values.
         */
        _30277, 
        /**
         * The thermometer that measure the temperature by the intensity of infrared light emission. 
         */
        _30522, 
        /**
         * Thermoluminescent diode thermometer is a thermometer that measures the temperature of the emitted heat from the surface of an area.
         */
        _82735, 
        /**
         * MRI diffusion thermometer is an instrument that uses MRI diffusion to indicate the temperature of a substance.
         */
        _84301, 
        /**
         * added to help the parsers
         */
        NULL;
        public static HspcBodytempmethoddevice fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("30277".equals(codeString))
          return _30277;
        if ("30522".equals(codeString))
          return _30522;
        if ("82735".equals(codeString))
          return _82735;
        if ("84301".equals(codeString))
          return _84301;
        throw new FHIRException("Unknown HspcBodytempmethoddevice code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _30277: return "30277";
            case _30522: return "30522";
            case _82735: return "82735";
            case _84301: return "84301";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/hspc-bodytempmethoddevice";
        }
        public String getDefinition() {
          switch (this) {
            case _30277: return "The electronic thermometer that displays body temperature in numeric values.";
            case _30522: return "The thermometer that measure the temperature by the intensity of infrared light emission. ";
            case _82735: return "Thermoluminescent diode thermometer is a thermometer that measures the temperature of the emitted heat from the surface of an area.";
            case _84301: return "MRI diffusion thermometer is an instrument that uses MRI diffusion to indicate the temperature of a substance.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case _30277: return "Digital Thermometer";
            case _30522: return "Infrared Thermometer";
            case _82735: return "Thermoluminescent diode thermometer";
            case _84301: return "MRI diffusion thermometer";
            case NULL: return null;
            default: return "?";
          }
    }


}