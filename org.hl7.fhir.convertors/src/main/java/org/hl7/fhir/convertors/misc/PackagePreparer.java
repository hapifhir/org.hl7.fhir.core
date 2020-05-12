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



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.utilities.Utilities;

/*
 * load reosurces in xml format, and sve them in package format (json, with correct name
 * 
 * C:\work\fhirserver\resources\resources\dicom
 * 
 */
public class PackagePreparer {


  public static void main(String[] args) {
    for (File f : new File("C:\\work\\fhirserver\\resources\\mihin").listFiles()) {
      try {
        org.hl7.fhir.dstu3.model.Resource r = new org.hl7.fhir.dstu3.formats.JsonParser().parse(new FileInputStream(f));
        if (r instanceof Bundle) {
          Bundle b = (Bundle) r;
          for (BundleEntryComponent be : b.getEntry()) {
            try {
              org.hl7.fhir.r4.model.Resource r4 = VersionConvertor_30_40.convertResource(be.getResource(), false);
              if (r4.getId().startsWith(r4.fhirType()+"-"))
                be.getResource().setId(r4.getId().substring(r4.fhirType().length()+1));
              if (be.getResource().hasId())
                new org.hl7.fhir.r4.formats.JsonParser().compose(new FileOutputStream(Utilities.path("C:\\work\\fhirserver\\resources\\fhir.test.data\\3.5.0\\package", be.getResource().fhirType()+"-"+be.getResource().getId()+".json")), r4);
              else
                System.out.println(f.getName()+" bundle entry has no id");
            } catch (Exception e) {
              System.out.println(f.getName()+": "+e.getMessage()); 
            }
          }
        } else if (r.hasId())
          new org.hl7.fhir.r4.formats.JsonParser().compose(new FileOutputStream(Utilities.path(Utilities.getDirectoryForFile(f.getAbsolutePath()), r.fhirType()+"-"+r.getId()+".json")), VersionConvertor_30_40.convertResource(r, false));
        else
          System.out.println(f.getName()+" has no id");
      } catch (Exception e) {
        System.out.println(f.getName()+": "+e.getMessage()); 
        e.printStackTrace();
      }
    }

    System.out.println("Completed OK");
  }

}