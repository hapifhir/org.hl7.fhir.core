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

import org.hl7.fhir.dstu3.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.CodeSystem;
import org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus;
import org.hl7.fhir.dstu3.terminologies.CodeSystemUtilities;
import org.hl7.fhir.dstu3.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

public class NUCCConvertor {
  private String[] last = new String[2];
  private ConceptDefinitionComponent[] concepts = new ConceptDefinitionComponent[2];
  
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
    cs.setCopyright("See NUCC copyright statement");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.setExperimental(false);
    cs.setValueSet("http://hl7.org/fhir/ValueSet/nucc-provider-taxonomy"); 
    cs.setHierarchyMeaning(CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
    csv.parseLine();
    while (csv.ready())
    {
      String[] values = csv.parseLine();
      processLine(cs, values);
    }     
    csv.close();
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("c:\\temp\\nucc.xml"), cs);
  }

  private void processLine(CodeSystem cs, String[] values) throws FHIRFormatError {
    if (!values[1].equals(last[0])) {
      last[1] = "";
      last[0] = values[1];
      concepts[0] = new ConceptDefinitionComponent();
      cs.getConcept().add(concepts[0]);
      concepts[0].setDisplay(values[1]);
      concepts[0].setCode("base-"+Integer.toString(cs.getConcept().size()));
      CodeSystemUtilities.setNotSelectable(cs, concepts[0]);
    }
    if (!values[2].equals(last[1])) {
      last[1] = values[2];
      concepts[1] = new ConceptDefinitionComponent();
      concepts[0].getConcept().add(concepts[1]);
      concepts[1].setCode(values[0]);
      concepts[1].setDisplay(values[2]);
      concepts[1].setDefinition(values[4]);
      if (values.length > 5 && !Utilities.noString(values[5]))
        ToolingExtensions.addCSComment(concepts[1], values[5]);
    } else if (!Utilities.noString(values[3])) {
      ConceptDefinitionComponent cc = new ConceptDefinitionComponent();
      concepts[1].getConcept().add(cc);
      cc.setCode(values[0]);
      cc.setDisplay(values[3]);
      cc.setDefinition(values[4]);
      if (values.length > 5 && !Utilities.noString(values[5]))
        ToolingExtensions.addCSComment(cc, values[5]);
    }
  }
  
}