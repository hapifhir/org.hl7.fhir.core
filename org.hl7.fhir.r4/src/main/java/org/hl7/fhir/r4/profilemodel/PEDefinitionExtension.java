package org.hl7.fhir.r4.profilemodel;

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

import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r4.profilemodel.PEDefinition.PEDefinitionElementMode;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r4.model.StructureDefinition;

public class PEDefinitionExtension extends PEDefinition {

  private StructureDefinition extension;
  private ElementDefinition sliceDefinition;
  private ElementDefinition eed;
  private ElementDefinition ved;

  public PEDefinitionExtension(PEBuilder builder, String name, StructureDefinition profile, ElementDefinition definition, ElementDefinition sliceDefinition, StructureDefinition extension, String ppath) {
    super(builder, name, profile, definition, ppath);
    this.sliceDefinition = sliceDefinition;
    this.extension= extension;
    eed = extension.getSnapshot().getElementByPath("Extension.extension");
    ved = extension.getSnapshot().getElementByPath("Extension.value[x]"); 
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
    } else if (ProfileUtilities.isComplexExtension(extension)) {
      types.add(builder.makeType(extension.getName(), extension.getUrl()));
    } else {
      types.add(builder.makeType("Extension"));
    }
  }

  @Override
  protected void makeChildren(String typeUrl, List<PEDefinition> children, boolean allFixed) {
    if (ved.isRequired() || eed.isProhibited()) {
      children.addAll(builder.listChildren(allFixed, this, extension, ved, typeUrl));
    } else {
      List<PEDefinition> slices = builder.listSlices(extension, eed, this);
      if (eed.getSlicing().getRules() != SlicingRules.CLOSED) {
        children.addAll(builder.listChildren(allFixed, this, extension, eed, "http://hl7.org/fhir/StructureDefinition/Extension", "value[x]", "url"));
        if (!children.isEmpty()) {
           children.get(0).setSlices(slices);
        }
      }      
      children.addAll(slices);
    }
  }

  @Override
  public String fhirpath() {
    if (ved.isRequired() || eed.isProhibited()) {
      return "extension('"+extension.getUrl()+"').value";
    } else {
      return "extension('"+extension.getUrl()+"')";      
    }
  }

  public PEDefinitionElementMode mode() {
    return PEDefinitionElementMode.Extension;
  }
  
  public List<PEDefinition> directChildren(boolean allFixed) {
    List<PEDefinition> children = new ArrayList<>();
    children.addAll(builder.listChildren(allFixed, this, extension, extension.getSnapshot().getElementFirstRep(), "http://hl7.org/fhir/StructureDefinition/Extension"));
    return children;
  }
  

  public boolean isExtension() {
    return true;
  }


  public String getExtensionUrl() {
    return extension.getUrl();
  }

}
