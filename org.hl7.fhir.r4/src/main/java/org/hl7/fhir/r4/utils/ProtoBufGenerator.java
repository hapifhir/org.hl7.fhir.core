package org.hl7.fhir.r4.utils;

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



import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

public class ProtoBufGenerator {

  private IWorkerContext context;
  private StructureDefinition definition;
  private OutputStreamWriter destination;
  private int cursor;
  private Message message; 
  
  private class Field {
    private String name;   
    private boolean required;
    private boolean repeating;
    private String type;
  }
  
  private class Message {
    private String name;
    private List<Field> fields = new ArrayList<Field>();
    private List<Message> messages = new ArrayList<Message>();
    public Message(String name) {
      super();
      this.name = name;
    }
    
    
  }
  
  public ProtoBufGenerator(IWorkerContext context) {
    super();
    this.context = context;
  }

  public ProtoBufGenerator(IWorkerContext context, StructureDefinition definition, OutputStreamWriter destination) {
    super();
    this.context = context;
    this.definition = definition;
    this.destination = destination;
  }

  public IWorkerContext getContext() {
    return context;
  }
  
  public StructureDefinition getDefinition() {
    return definition;
  }

  public void setDefinition(StructureDefinition definition) {
    this.definition = definition;
  }

  public OutputStreamWriter getDestination() {
    return destination;
  }

  public void setDestination(OutputStreamWriter destination) {
    this.destination = destination;
  }


  public void build() throws FHIRException {
    if (definition == null)
      throw new FHIRException("A definition must be provided");
    if (destination == null)
      throw new FHIRException("A destination must be provided");
    
    if (definition.getDerivation() == TypeDerivationRule.CONSTRAINT)
      throw new FHIRException("derivation = constraint is not supported yet");
    
    message = new Message(definition.getSnapshot().getElement().get(0).getPath());
    cursor = 1;
    while (cursor < definition.getSnapshot().getElement().size()) {
      ElementDefinition ed = definition.getSnapshot().getElement().get(0);
      Field fld = new Field();
      fld.name = tail(ed.getPath());
      fld.required = (ed.getMin() == 1);
      fld.repeating = (!ed.getMax().equals("1"));
      message.fields.add(fld);
      if (ed.getType().size() != 1)
        fld.type = "Unknown";
      else {
        StructureDefinition td = context.fetchTypeDefinition(ed.getTypeFirstRep().getWorkingCode());
        if (td == null)
          fld.type = "Unresolved";
        else if (td.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
          fld.type = protoTypeForFhirType(ed.getTypeFirstRep().getWorkingCode());
          fld = new Field();
          fld.name = tail(ed.getPath())+"Extra";
          fld.repeating = (!ed.getMax().equals("1"));
          fld.type = "Primitive";
          message.fields.add(fld);
        } else
          fld.type = ed.getTypeFirstRep().getWorkingCode();
      }   
    }
  }

  private String protoTypeForFhirType(String code) {
    if (Utilities.existsInList(code, "integer", "unsignedInt", "positiveInt"))
      return "int23";
    else if (code.equals("boolean"))
      return "bool";
    else 
      return "string";
  }

  private String tail(String path) {
    return path.substring(path.lastIndexOf(".")+1);
  }
  
  
}