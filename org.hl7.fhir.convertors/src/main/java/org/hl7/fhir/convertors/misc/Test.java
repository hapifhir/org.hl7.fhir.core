package org.hl7.fhir.convertors.misc;





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

import org.fhir.ucum.UcumEssenceService;
import org.hl7.fhir.convertors.misc.ccda.CCDAConverter;
import org.hl7.fhir.dstu3.context.SimpleWorkerContext;
import org.hl7.fhir.dstu3.formats.IParser;
import org.hl7.fhir.dstu3.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.utilities.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {
  public final static String DEF_TS_SERVER = "http://fhir-dev.healthintersections.com.au/open";
  public final static String DEV_TS_SERVER = "http://local.fhir.org:960/open";


  public static final String DEF_PATH = "c:\\work\\org.hl7.fhir\\build\\implementations\\java\\org.hl7.fhir.convertors\\samples\\";
  public static final String UCUM_PATH = "c:\\work\\org.hl7.fhir\\build\\implementations\\java\\org.hl7.fhir.convertors\\samples\\ucum-essence.xml";
  public static final String SRC_PATH = "c:\\work\\org.hl7.fhir\\build\\publish\\";

  public static void main(String[] args) {
    try {
      CCDAConverter c = new CCDAConverter(new UcumEssenceService(UCUM_PATH), SimpleWorkerContext.fromPack(Utilities.path(SRC_PATH, "validation.zip")));
      Bundle a = c.convert(new FileInputStream(DEF_PATH + "ccda.xml"));
      String fx = DEF_PATH + "output.xml";
      IParser x = new XmlParser().setOutputStyle(OutputStyle.PRETTY);
      x.compose(new FileOutputStream(fx), a);
      String fj = DEF_PATH + "output.json";
      IParser j = new JsonParser().setOutputStyle(OutputStyle.PRETTY);
      j.compose(new FileOutputStream(fj), a);
      System.out.println("done. save as " + fx + " and " + fj);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}