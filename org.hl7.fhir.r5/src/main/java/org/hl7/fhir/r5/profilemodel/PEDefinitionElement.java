package org.hl7.fhir.r5.profilemodel;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
//import org.hl7.fhir.utilities.DebugUtilities;

public class PEDefinitionElement extends PEDefinition {

  public PEDefinitionElement(PEBuilder builder, StructureDefinition profile, ElementDefinition definition, String ppath) {
    super(builder, definition.getName(), profile, definition, ppath);
  }

  @Override
  public void listTypes(List<PEType> types) {
    for (TypeRefComponent t : definition.getType()) {
      if (t.hasProfile()) {
        for (CanonicalType u : t.getProfile()) {
          types.add(builder.makeType(t, u));
        }
      } else if (!t.getCode().startsWith("http://hl7.org/fhirpath/")) {
        types.add(new PEType(t.getWorkingCode(), t.getWorkingCode(), "http://hl7.org/fhir/StructureDefinition/"+t.getWorkingCode()));
      }
    }
  }

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children, boolean allFixed) {
    children.addAll(builder.listChildren(allFixed, this, profile, definition, typeUrl));            
  }

  @Override
  public String fhirpath() {
    String base = definition.getName().replace("[x]", "");
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(" or ");
    if (getSlices() != null) {
      for (PEDefinition slice : getSlices()) {
        b.append("("+builder.makeSliceExpression(slice.profile, definition.getSlicing(), slice.definition())+")");
      }
    } else if (definition.hasSlicing()) {
      List<PEDefinition> slices = builder.listSlices(profile, definition, this);
      for (PEDefinition slice : slices) {
        b.append("("+builder.makeSliceExpression(profile, definition.getSlicing(), slice.definition())+")");
      }
    }
    if (b.count() == 0)
      return base;
    else
     return base+".where(("+b.toString()+").not())";
  }


}
