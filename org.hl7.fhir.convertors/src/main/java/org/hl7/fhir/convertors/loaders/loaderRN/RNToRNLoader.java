package org.hl7.fhir.convertors.loaders.loaderRN;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.FHIRException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.client.ITerminologyClientFactoryN;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.Bundle.*;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.services.context.PackageResourceLoader;


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

public class RNToRNLoader extends BaseLoaderRN {

  public RNToRNLoader(IModelContext context, Set<String> types, ILoaderKnowledgeProviderRN lkp) {
    super(context, types, lkp);
  }

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource rN = null;
    if (isJson)
      rN = new JsonParser(context).parse(stream);
    else
      rN = new XmlParser(context).parse(stream);

    Bundle b;
    if (rN instanceof Bundle)
      b = (Bundle) rN;
    else {
      b = new Bundle();
      b.setId(UUID.randomUUID().toString().toLowerCase());
      b.setType(BundleType.COLLECTION);
      b.addEntry().setResource(rN).setFullUrl(rN instanceof CanonicalResource ? ((CanonicalResource) rN).getUrl() : null);
    }
    if (killPrimitives) {
      List<BundleEntryComponent> remove = new ArrayList<BundleEntryComponent>();
      for (BundleEntryComponent be : b.getEntryList()) {
        if (be.hasResource() && be.getResource() instanceof StructureDefinition) {
          StructureDefinition sd = (StructureDefinition) be.getResource();
          if (sd.getKind() == StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE)
            remove.add(be);
        }
      }
      b.getEntryList().removeAll(remove);
    }
    if (patchUrls) {
      for (BundleEntryComponent be : b.getEntryList()) {
        if (be.hasResource()) {
          doPatchUrls(be.getResource());
        }
      }
    }
    return b;
  }

  @Override
  public Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r5 = null;
    if (isJson)
      r5 = new JsonParser(context).parse(stream);
    else
      r5 = new XmlParser(context).parse(stream);
    setPath(r5);

    if (killPrimitives) {
      throw new FHIRException("Cannot kill primitives when using deferred loading");
    }
    if (patchUrls) {
      doPatchUrls(r5);
    }
    return r5;
  }
  
  @Override
  public List<CodeSystem> getCodeSystems() {
    return new ArrayList<>();
  }

  @Override
  protected String versionString() {
    return "5.0";
  }

  @Override
  public ITerminologyClientFactoryN txFactory() {
    return new TerminologyClientFactory(versionString());
  }

  @Override
  public Set<String> reviewActualTypes(Set<String> types) {
    return types;
  }
  

  @Override
  public PackageResourceLoader editInfo(PackageResourceLoader pri) {
    return pri;
  }
}