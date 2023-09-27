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

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.profilemodel.PEDefinition.PEDefinitionElementMode;
import org.hl7.fhir.r5.model.StructureDefinition;

public class PEDefinitionSubExtension extends PEDefinition {

  private ElementDefinition eed;
  private ElementDefinition ved;
  private ElementDefinition ued;

  public PEDefinitionSubExtension(PEBuilder builder, StructureDefinition profile, ElementDefinition definition, String ppath) {
    super(builder, definition.getSliceName(), profile, definition, ppath);
    List<ElementDefinition> childDefs = builder.getChildren(profile, definition);    
    eed = getElementByName(childDefs, "extension");
    ved = getElementByName(childDefs, "value[x]"); 
    ued = getElementByName(childDefs, "url");
  }

  @Override
  public void listTypes(List<PEType> types) {
    if (ved.isRequired() || eed.isProhibited()) {
      for (TypeRefComponent t : ved.getType()) {
        if (t.hasProfile()) {
          for (CanonicalType u : t.getProfile()) {
            types.add(builder.makeType(t, u));
          }
        } else {
          types.add(builder.makeType(t.getWorkingCode()));
        }
      }
    } else {
      types.add(builder.makeType("Extension"));
    }
  }

  private ElementDefinition getElementByName(List<ElementDefinition> children, String name) {
    for (ElementDefinition ed : children) {
      if (name.equals(ed.getName())) {
        return ed;
      }
    }
    return null;
  }
  
  public List<PEDefinition> directChildren(boolean allFixed) {
    List<PEDefinition> children = new ArrayList<>();
    children.addAll(builder.listChildren(allFixed, this, profile, definition, "http://hl7.org/fhir/StructureDefinition/Extension"));
    return children;
  }

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children, boolean allFixed) {
    if (ved.isRequired() || eed.isProhibited()) {
      children.addAll(builder.listChildren(allFixed, this, profile, ved, typeUrl));
    } else {
      if (eed.getSlicing().getRules() != SlicingRules.CLOSED) {
        children.addAll(builder.listChildren(allFixed, this, profile, eed, "http://hl7.org/fhir/StructureDefinition/Extension", "value[x]", "url"));
      } 
      children.addAll(builder.listSlices(profile, eed, this));
    }
  }

  @Override
  public String fhirpath() {
    if (ved.isRequired() || eed.isProhibited()) {
      return "extension('"+ued.getFixed().primitiveValue()+"').value";
    } else {
      return "extension('"+ued.getFixed().primitiveValue()+"')";
    }
  }

  public PEDefinitionElementMode mode() {
    return PEDefinitionElementMode.Extension;
  }

  public boolean isExtension() {
    return true;
  }


}
