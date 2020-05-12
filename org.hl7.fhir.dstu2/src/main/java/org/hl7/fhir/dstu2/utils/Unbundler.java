package org.hl7.fhir.dstu2.utils;

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



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.model.Bundle;
import org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.dstu2.model.ValueSet;
import org.hl7.fhir.utilities.Utilities;

public class Unbundler {

  public static void main(String[] args) throws Exception {
    unbundle(args[0]);
  }

  private static void unbundle(String src) throws FHIRFormatError, FileNotFoundException, IOException {
    String folder = Utilities.getDirectoryForFile(src);
    Bundle bnd = (Bundle) new JsonParser().parse(new FileInputStream(src));
    for (BundleEntryComponent be : bnd.getEntry()) {
      Resource r = be.getResource();
      if (r != null) {
        if (StringUtils.isBlank(r.getId())) {
          if (r instanceof ValueSet)
            r.setId(tail((ValueSet) r));
        }
        if (!StringUtils.isBlank(r.getId())) {
          String tgt = Utilities.path(folder, r.fhirType()+"-"+r.getId()+".json");
          new JsonParser().compose(new FileOutputStream(tgt), r);
        }
      }
    }
  }

  private static String tail(ValueSet r) {
    return r.getUrl().contains("/") ? r.getUrl().substring(r.getUrl().lastIndexOf("/")+1) : null;
  }

}