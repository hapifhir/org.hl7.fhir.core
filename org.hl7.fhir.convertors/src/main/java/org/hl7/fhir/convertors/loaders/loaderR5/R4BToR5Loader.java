package org.hl7.fhir.convertors.loaders.loaderR5;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Basic;
import org.hl7.fhir.r4b.formats.JsonParser;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r5.conformance.StructureDefinitionHacker;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.r5.context.SimpleWorkerContext.PackageResourceLoader;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientManager.ITerminologyClientFactory;
import org.hl7.fhir.utilities.Utilities;

public class R4BToR5Loader extends BaseLoaderR5 implements IContextResourceLoader {

  private final BaseAdvisor_43_50 advisor = new BaseAdvisor_43_50();
  private String version;

  public R4BToR5Loader(Set<String> types, ILoaderKnowledgeProviderR5 lkp, String version) { // might be 4B
    super(types, lkp);
    this.version = version;
  }

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r4 = null;
    if (isJson)
      r4 = new JsonParser().parse(stream);
    else
      r4 = new XmlParser().parse(stream);
    org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_43_50.convertResource(r4, advisor);

    Bundle b;
    if (r5 instanceof Bundle)
      b = (Bundle) r5;
    else {
      b = new Bundle();
      b.setId(UUID.randomUUID().toString().toLowerCase());
      b.setType(BundleType.COLLECTION);
      b.addEntry().setResource(r5).setFullUrl(r5 instanceof CanonicalResource ? ((CanonicalResource) r5).getUrl() : null);
    }
    for (CodeSystem cs : advisor.getCslist()) {
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
        if (be.hasResource()) {
          doPatchUrls(be.getResource());
        }
      }
    }
    return b;
  }

  @Override
  public org.hl7.fhir.r5.model.Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException {
    Resource r4 = null;
    if (isJson)
      r4 = new JsonParser().parse(stream);
    else
      r4 = new XmlParser().parse(stream);
    org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_43_50.convertResource(r4);
    setPath(r5);

    if (!advisor.getCslist().isEmpty()) {
      throw new FHIRException("Error: Cannot have included code systems");
    }
    if (killPrimitives) {
      throw new FHIRException("Cannot kill primitives when using deferred loading");
    }
    if (r5 instanceof StructureDefinition) {
      r5 = new StructureDefinitionHacker(version).fixSD((StructureDefinition) r5);
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
    return "4.3";
  }


  @Override
  public ITerminologyClientFactory txFactory() {
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
          org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_43_50.convertResource(b);
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