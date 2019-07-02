package org.hl7.fhir.convertors;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.MetadataResource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;

public class R3ToR5Loader implements IContextResourceLoader, VersionConvertorAdvisor50 {

  private List<CodeSystem> cslist = new ArrayList<>();
  private boolean patchUrls;
  private boolean killPrimitives;;
  
  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r3 = null;
    if (isJson)
      r3 = new JsonParser().parse(stream);
    else
      r3 = new XmlParser().parse(stream);
    org.hl7.fhir.r5.model.Resource r5 = VersionConvertor_30_50.convertResource(r3, false);
    
    Bundle b;
    if (r5 instanceof Bundle)
      b = (Bundle) r5;
    else {
      b = new Bundle();
      b.setId(UUID.randomUUID().toString().toLowerCase());
      b.setType(BundleType.COLLECTION);
      b.addEntry().setResource(r5).setFullUrl(r5 instanceof MetadataResource ? ((MetadataResource) r5).getUrl() : null);
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
    if (patchUrls) {
      for (BundleEntryComponent be : b.getEntry()) {
        if (be.hasResource() && be.getResource() instanceof StructureDefinition) {
          StructureDefinition sd = (StructureDefinition) be.getResource();
          sd.setUrl(sd.getUrl().replace("http://hl7.org/fhir/", "http://hl7.org/fhir/3.0/"));
          sd.addExtension().setUrl("http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace").setValue(new UriType("http://hl7.org/fhir"));
          for (ElementDefinition ed : sd.getSnapshot().getElement()) 
            patchUrl(ed);
          for (ElementDefinition ed : sd.getDifferential().getElement()) 
            patchUrl(ed);
        }
      }
    }
    return b;
  }

  private void patchUrl(ElementDefinition ed) {
    for (TypeRefComponent tr : ed.getType()) {
      for (CanonicalType s : tr.getTargetProfile()) {
        s.setValue(s.getValue().replace("http://hl7.org/fhir/", "http://hl7.org/fhir/3.0/"));
      }
      for (CanonicalType s : tr.getProfile()) {
        s.setValue(s.getValue().replace("http://hl7.org/fhir/", "http://hl7.org/fhir/3.0/"));
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
  public org.hl7.fhir.dstu2016may.model.Resource convertR2016May(org.hl7.fhir.r5.model.Resource resource) throws FHIRException {
    return null;
  }

  @Override
  public Resource convertR3(org.hl7.fhir.r5.model.Resource resource) throws FHIRException {
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

  public boolean isPatchUrls() {
    return patchUrls;
  }

  public R3ToR5Loader setPatchUrls(boolean patchUrls) {
    this.patchUrls = patchUrls;
    return this;
  }

  public boolean isKillPrimitives() {
    return killPrimitives;
  }

  public R3ToR5Loader setKillPrimitives(boolean killPrimitives) {
    this.killPrimitives = killPrimitives;
    return this;
  }

  @Override
  public org.hl7.fhir.r4.model.Resource convertR4(org.hl7.fhir.r5.model.Resource resource) throws FHIRException {
    return null;
  }

}
