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



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.CodeSystem.PropertyType;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r4.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

public class NUCCConvertor {
  
  public static void main(String[] args) throws Exception {
    new NUCCConvertor().execute();
  }
  
  public void execute() throws IOException, FHIRException {    
    CSVReader csv = new CSVReader(new FileInputStream("c:\\temp\\nucc.csv"));
    CodeSystem cs = new CodeSystem();
    cs.setId("nucc-provider-taxonomy");
    cs.setUrl("http://nucc.org/provider-taxonomy");
    cs.setName("NUCC Provider Taxonomy");
    cs.setDateElement(new DateTimeType());
    cs.setDescription("The Health Care Provider Taxonomy code is a unique alphanumeric code, ten characters in length. The code set is structured into three distinct 'Levels' including Provider Type, Classification, and Area of Specialization");
    cs.setCopyright("Vendors must request a license to include this in a product per the following: 'Vendors interested in incorporating the Health Care Provider Taxonomy code set into their commercial products must complete the license request form found on the CSV page.' Using the form at the url listed. The preamble is reproduced below: http://www.nucc.org/index.php?option=com_content&view=article&id=111&Itemid=110");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.setExperimental(false);
    cs.setValueSet("http://hl7.org/fhir/ValueSet/nucc-provider-taxonomy"); 
    cs.setHierarchyMeaning(CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
    cs.addProperty().setCode("grouping").setType(PropertyType.STRING).setDescription("A major grouping of service(s) or occupation(s) of health care providers. For example: Allopathic & Osteopathic Physicians, Dental Providers, Hospitals, etc");
    cs.addProperty().setCode("classification").setType(PropertyType.STRING).setDescription("A more specific service or occupation related to the Provider Grouping.e");
    cs.addProperty().setCode("specialization").setType(PropertyType.STRING).setDescription("A more specialized area of the Classification in which a provider chooses to practice or make services available.");
    csv.parseLine();
    while (csv.ready()) {
      String[] values = csv.parseLine();
      processLine(cs, values);
    }     
    csv.close();
    cs.sort();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("c:\\temp\\nucc.json"), cs);
  }

  private void processLine(CodeSystem cs, String[] values) throws FHIRFormatError {
    ConceptDefinitionComponent cc = new ConceptDefinitionComponent();
    cs.getConcept().add(cc);
    cc.setCode(values[0]);
    cc.setDisplay(values[4]);
    if (!Utilities.noString(values[1])) {
      cc.addProperty().setCode("grouping").setValue(new StringType(values[1]));
    }
    if (!Utilities.noString(values[2])) {
      cc.addProperty().setCode("classification").setValue(new StringType(values[2]));
    }
    if (!Utilities.noString(values[3])) {
      cc.addProperty().setCode("specialization").setValue(new StringType(values[3]));
    }
    if (values.length > 5 && !Utilities.noString(values[5]))
      cc.setDefinition(values[5]);
  }

}