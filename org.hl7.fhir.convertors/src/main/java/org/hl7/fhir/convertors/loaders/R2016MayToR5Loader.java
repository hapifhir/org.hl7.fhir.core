package org.hl7.fhir.convertors.loaders;

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



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.convertors.VersionConvertorAdvisor50;
import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.dstu2016may.formats.JsonParser;
import org.hl7.fhir.dstu2016may.formats.XmlParser;
import org.hl7.fhir.dstu2016may.model.Resource;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;

import com.google.gson.JsonSyntaxException;

public class R2016MayToR5Loader extends BaseLoaderR5 implements VersionConvertorAdvisor50 {

  public R2016MayToR5Loader(String[] types, ILoaderKnowledgeProvider lkp) {
    super(types, lkp);
  }

  private List<CodeSystem> cslist = new ArrayList<>();

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r2016may = null;
    if (isJson)
      r2016may = new JsonParser().parse(stream);
    else
      r2016may = new XmlParser().parse(stream);
    org.hl7.fhir.r5.model.Resource r5 = VersionConvertor_14_50.convertResource(r2016may);
    
    Bundle b;
    if (r5 instanceof Bundle)
      b = (Bundle) r5;
    else {
      b = new Bundle();
      b.setId(UUID.randomUUID().toString().toLowerCase());
      b.setType(BundleType.COLLECTION);
      b.addEntry().setResource(r5).setFullUrl(r5 instanceof CanonicalResource ? ((CanonicalResource) r5).getUrl() : null);
    }
    
    for (CodeSystem cs : cslist) {
      BundleEntryComponent be = b.addEntry();
      be.setFullUrl(cs.getUrl());
      be.setResource(cs);
    }
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
    for (BundleEntryComponent be : b.getEntry()) {
      if (be.hasResource() && be.getResource() instanceof StructureDefinition) {
        StructureDefinition sd = (StructureDefinition) be.getResource();
        new ProfileUtilities(null, null, null).setIds(sd, false);
        if (patchUrls) {
          sd.setUrl(sd.getUrl().replace(URL_BASE, URL_DSTU2016MAY));
          sd.addExtension().setUrl(URL_ELEMENT_DEF_NAMESPACE).setValue(new UriType(URL_BASE));
        }
      }
    }
    return b;
  }
  
  @Override
  public org.hl7.fhir.r5.model.Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r2016may = null;
    if (isJson)
      r2016may = new JsonParser().parse(stream);
    else
      r2016may = new XmlParser().parse(stream);
    org.hl7.fhir.r5.model.Resource r5 = VersionConvertor_14_50.convertResource(r2016may);
    setPath(r5);

    if (!cslist.isEmpty()) {
      throw new FHIRException("Error: Cannot have included code systems");
    }
    if (killPrimitives) {
      throw new FHIRException("Cannot kill primitives when using deferred loading");      
    }
    if (patchUrls) {
      if (r5 instanceof StructureDefinition) {
        StructureDefinition sd = (StructureDefinition) r5;
        sd.setUrl(sd.getUrl().replace(URL_BASE, URL_R4));
        sd.addExtension().setUrl(URL_ELEMENT_DEF_NAMESPACE).setValue(new UriType(URL_BASE));
        for (ElementDefinition ed : sd.getSnapshot().getElement()) 
          patchUrl(ed);
        for (ElementDefinition ed : sd.getDifferential().getElement()) 
          patchUrl(ed);
      }
    }
    return r5;
  }

  private void patchUrl(ElementDefinition ed) {
    for (TypeRefComponent tr : ed.getType()) {
      for (CanonicalType s : tr.getTargetProfile()) {
        s.setValue(s.getValue().replace(URL_BASE, URL_DSTU2016MAY));
      }
      for (CanonicalType s : tr.getProfile()) {
        s.setValue(s.getValue().replace(URL_BASE, URL_DSTU2016MAY));
      }
    }    
  }
  
  @Override
  public boolean ignoreEntry(BundleEntryComponent src) {
    return false;
  }

  @Override
  public org.hl7.fhir.dstu2.model.Resource convertR2(org.hl7.fhir.r5.model.Resource resource) throws FHIRException {
    return null;
  }

  @Override
  public Resource convertR2016May(org.hl7.fhir.r5.model.Resource resource) throws FHIRException {
    return null;
  }

  @Override
  public org.hl7.fhir.dstu3.model.Resource convertR3(org.hl7.fhir.r5.model.Resource resource) throws FHIRException {
    return null;
  }

  @Override
  public void handleCodeSystem(CodeSystem cs, ValueSet vs) {
    cs.setId(vs.getId());
    cs.setValueSet(vs.getUrl());
    cslist.add(cs);
    
  }

  @Override
  public CodeSystem getCodeSystem(ValueSet src) {
    return null;
  }

  @Override
  public org.hl7.fhir.r4.model.Resource convertR4(org.hl7.fhir.r5.model.Resource resource) throws FHIRException {
    return null;
  }

 

}