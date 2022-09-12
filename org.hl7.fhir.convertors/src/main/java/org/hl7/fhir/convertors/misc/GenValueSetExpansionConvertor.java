package org.hl7.fhir.convertors.misc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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


import org.hl7.fhir.dstu2.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.formats.XmlParser;
import org.hl7.fhir.dstu2.model.Bundle;
import org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.dstu2.model.ValueSet;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;

public class GenValueSetExpansionConvertor {

  public static void main(String[] args) throws FHIRFormatError, IOException {
    String src = args[0];
    String tgt = args[1];
    Bundle bundle = (Bundle) new XmlParser().parse(new FileInputStream(src));
    for (BundleEntryComponent be : bundle.getEntry()) {
      Resource res = be.getResource();
      if (res != null) {
        String id = res.getId();
        if (Utilities.noString(id))
          id = tail(((ValueSet) res).getUrl());
        String dst = Utilities.path(tgt, res.fhirType() + "-" + id + ".json");
        System.out.println(dst);
        new JsonParser().setOutputStyle(OutputStyle.NORMAL).compose(new FileOutputStream(dst), res);
      }
    }
  }

  private static String tail(String url) {
    return url.substring(url.lastIndexOf("/") + 1);
  }

}