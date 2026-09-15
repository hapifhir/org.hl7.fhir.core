package org.hl7.fhir.convertors.loaders.loaderRN;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_N;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.services.client.ITerminologyClientFactoryN;
import org.hl7.fhir.model.core.Bundle;
import org.hl7.fhir.model.core.Bundle.*;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.context.IContextResourceLoaderN;
import org.hl7.fhir.r4b.formats.JsonParser;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.Basic;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.services.conformance.StructureDefinitionHacker;
import org.hl7.fhir.services.context.PackageResourceLoader;
import org.hl7.fhir.utilities.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class R4BToRNLoader extends BaseLoaderRN implements IContextResourceLoaderN {

  private final BaseAdvisor_43_N advisor = new BaseAdvisor_43_N();
  private String version;

  public R4BToRNLoader(IModelContext context, Set<String> types, ILoaderKnowledgeProviderRN lkp, String version) { // might be 4B
    super(context, types, lkp);
    this.version = version;
  }

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r4 = null;
    if (isJson)
      r4 = new JsonParser().parse(stream);
    else
      r4 = new XmlParser().parse(stream);
    org.hl7.fhir.model.core.Resource r5 = VersionConvertorFactory_43_N.convertResource(r4, advisor);

    Bundle b;
    if (r5 instanceof Bundle)
      b = (Bundle) r5;
    else {
      b = new Bundle();
      b.setId(UUID.randomUUID().toString().toLowerCase());
      b.setType(Bundle.BundleType.COLLECTION);
      b.addEntry().setResource(r5).setFullUrl(r5 instanceof CanonicalResource ? ((CanonicalResource) r5).getUrl() : null);
    }
    for (org.hl7.fhir.model.core.CodeSystem cs : advisor.getCslist()) {
      Bundle.BundleEntryComponent be = b.addEntry();
      be.setFullUrl(cs.getUrl());
      be.setResource(cs);
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
          inspectResource(be.getResource());
          doPatchUrls(be.getResource());
        }
      }
    }
    return b;
  }

  @Override
  public org.hl7.fhir.model.core.Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r4 = null;
    if (isJson)
      r4 = new JsonParser().parse(stream);
    else
      r4 = new XmlParser().parse(stream);
    org.hl7.fhir.model.core.Resource rN = VersionConvertorFactory_43_N.convertResource(r4);
    setPath(rN);

    if (!advisor.getCslist().isEmpty()) {
      throw new FHIRException("Error: Cannot have included code systems");
    }
    if (killPrimitives) {
      throw new FHIRException("Cannot kill primitives when using deferred loading");
    }
    if (rN instanceof StructureDefinition) {
      rN = new StructureDefinitionHacker(version).fixSD((StructureDefinition) rN);
    }
    inspectResource(rN);
    if (patchUrls) {
      doPatchUrls(rN);
    }
    return rN;
  }
  
  @Override
  public List<org.hl7.fhir.model.core.CodeSystem> getCodeSystems() {
    return new ArrayList<>();
  }

  @Override
  protected String versionString() {
    return "4.3";
  }


  @Override
  public ITerminologyClientFactoryN txFactory() {
    return new TerminologyClientFactory(versionString());
  }

  @Override  
  public Set<String> reviewActualTypes(Set<String> types) {
    Set<String> set = new HashSet<String>();
    for (String t : types) {
      if (Utilities.existsInList(t, "ActorDefinition", "Requirements", "TestPlan")) {
        set.add("Basic");
      } else {
        set.add(t);
      }      
    }    
    return set;
  }

  @Override
  public PackageResourceLoader editInfo(PackageResourceLoader pri) {

    if (pri.getType().equals("Basic")) {
      try {
        InputStream f = pri.getStream();
        try {
          Basic b = (Basic) new JsonParser().parse(f);
          org.hl7.fhir.model.core.Resource r5 = VersionConvertorFactory_43_N.convertResource(b);
          if (r5 instanceof CanonicalResource) {
            pri.setResource((CanonicalResource) r5);
            pri.updateInfo();
            setPath(r5);
          } else {
            return null;
          }
        } finally {
          f.close();
        }
      } catch (Exception e) {
        throw new FHIRException("Error loading Resource Basic/"+pri.getId()+": "+e.getMessage(), e);
      }
    }
    return pri;
  }
}