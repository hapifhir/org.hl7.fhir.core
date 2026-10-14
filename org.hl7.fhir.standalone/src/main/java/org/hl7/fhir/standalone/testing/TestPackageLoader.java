package org.hl7.fhir.standalone.testing;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.services.context.IContextResourceLoaderN;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.Bundle;
import org.hl7.fhir.model.core.Bundle.BundleType;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.services.client.ITerminologyClientFactoryN;
import org.hl7.fhir.services.client.TerminologyClientR6;
import org.hl7.fhir.services.context.PackageResourceLoader;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TestPackageLoader implements IContextResourceLoaderN {

  private Set<String> types;
  private IWorkerContext context;
  private IModelContext modelContext;
  private String webRoot;
  private boolean core;

  /**
   * Loads resources with no web path - the loaded resources have nothing to link to
   */
  public TestPackageLoader(Set<String> types,  IWorkerContext context) {
    this.types = types;
    this.context = context;
  }

  /**
   * Loads resources with web paths (as the real loaders do), so that renderers produce links
   * rather than null#... hrefs. Core packages use their web location and the core spec's page
   * naming (codesystem-x.html, patient.html); other packages use their canonical - not the
   * version specific web location, since some (THO) float to the latest version - and the IG
   * page naming (CodeSystem-x.html)
   */
  public TestPackageLoader(Set<String> types,  IWorkerContext context, NpmPackage npm) {
    this.types = types;
    this.context = context;
    this.core = npm.isCore();
    this.webRoot = core ? npm.getWebLocation() : npm.canonical();
  }

  /**
   * For loading a package into a context that doesn't exist yet (i.e. the core package)
   */
  public TestPackageLoader(Set<String> types,  IModelContext modelContext, NpmPackage npm) {
    this.types = types;
    this.modelContext = modelContext;
    this.core = npm.isCore();
    this.webRoot = core ? npm.getWebLocation() : npm.canonical();
  }

  private IModelContext modelContext() {
    return context != null ? context.getModelContext() : modelContext;
  }

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    // used when a package can't be lazy loaded (e.g. one read from a stream). A single resource is
    // wrapped in a bundle; returning null here would silently drop it
    Resource r = isJson ? new JsonParser(modelContext()).parse(stream) : new XmlParser(modelContext()).parse(stream);
    if (r instanceof Bundle) {
      return (Bundle) r;
    }
    Bundle b = new Bundle();
    b.setType(BundleType.COLLECTION);
    b.addEntry().setResource(r);
    return b;
  }

  @Override
  public Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException {
    return setWebPath(isJson ? new JsonParser(modelContext()).parse(stream) : new XmlParser(modelContext()).parse(stream));
  }

  @Override
  public Set<String> getTypes() {
    return types;
  }

  @Override
  public String getResourcePath(Resource resource) {
    if (webRoot == null) {
      return resource.fhirType().toLowerCase()+"-"+resource.getId()+".html";
    }
    String page;
    if (!core) {
      page = resource.fhirType()+"-"+resource.getId()+".html";
    } else if (resource instanceof StructureDefinition && ((StructureDefinition) resource).getDerivation() == TypeDerivationRule.SPECIALIZATION) {
      page = resource.getId().toLowerCase()+".html";
    } else {
      page = resource.fhirType().toLowerCase()+"-"+resource.getId()+".html";
    }
    return Utilities.pathURL(webRoot, page);
  }

  private Resource setWebPath(Resource r) {
    if (webRoot != null && r != null) {
      r.setWebPath(getResourcePath(r));
    }
    return r;
  }

  @Override
  public IContextResourceLoaderN getNewLoader(NpmPackage npm) {
    if (webRoot == null) {
      return this;
    }
    return context != null ? new TestPackageLoader(types, context, npm) : new TestPackageLoader(types, modelContext, npm);
  }

  @Override
  public List<CodeSystem> getCodeSystems() {
    return new ArrayList<>();
  }

  @Override
  public void setPatchUrls(boolean value) {
    
  }

  @Override
  public String patchUrl(String url, String resourceType) {
    return url;
  }

  @Override
  public IContextResourceLoaderN setLoadProfiles(boolean value) {
    return this;
  }

  @Override
  public boolean wantLoad(NpmPackage pi, PackageResourceInformation pri) {
    return true;
  }

  @Override
  public ITerminologyClientFactoryN txFactory() {
    return new TerminologyClientR6.TerminologyClientR6Factory();
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
