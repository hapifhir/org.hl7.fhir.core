package org.hl7.fhir.convertors.loaders.loaderR4;

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


import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_40;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.formats.XmlParser;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import org.hl7.fhir.r4.model.MetadataResource;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4.model.UriType;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class R2ToR4Loader extends BaseLoaderR4 {

  private final BaseAdvisor_10_40 advisor = new BaseAdvisor_10_40();

  public R2ToR4Loader() {
    super(new String[0], new NullLoaderKnowledgeProviderR4());
  }

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r2 = null;
    if (isJson)
      r2 = new JsonParser().parse(stream);
    else
      r2 = new XmlParser().parse(stream);
    org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_10_40.convertResource(r2, advisor);
    Bundle b;
    if (r4 instanceof Bundle) {
      b = (Bundle) r4;
    } else {
      b = new Bundle();
      b.setId(UUID.randomUUID().toString().toLowerCase());
      b.setType(BundleType.COLLECTION);
      b.addEntry().setResource(r4).setFullUrl(r4 instanceof MetadataResource ? ((MetadataResource) r4).getUrl() : null);
    }
    // Add any code systems defined as part of processing value sets to the end of the converted Bundle
    advisor.getCslist().forEach(cs -> {
      BundleEntryComponent be = b.addEntry();
      be.setFullUrl(cs.getUrl());
      be.setResource(cs);
    });
    advisor.getCslist().clear();

    if (killPrimitives) {
      List<BundleEntryComponent> remove = new ArrayList<BundleEntryComponent>();
      for (BundleEntryComponent be : b.getEntry()) {
        if (be.hasResource() && be.getResource() instanceof StructureDefinition) {
          StructureDefinition sd = (StructureDefinition) be.getResource();
          if (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE)
            remove.add(be);
        }
      }
      b.getEntry().removeAll(remove);
    }
    if (patchUrls) {
      b.getEntry().stream()
        .filter(be -> be.hasResource() && be.getResource() instanceof StructureDefinition)
        .map(be -> (StructureDefinition) be.getResource())
        .forEach(sd -> {
          sd.setUrl(sd.getUrl().replace(URL_BASE, URL_DSTU2));
          sd.addExtension().setUrl(URL_ELEMENT_DEF_NAMESPACE).setValue(new UriType(URL_BASE));
        });
    }
    return b;
  }
}