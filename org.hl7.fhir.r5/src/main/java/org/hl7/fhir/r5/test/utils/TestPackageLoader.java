package org.hl7.fhir.r5.test.utils;

 import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.r5.context.PackageResourceLoader;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
 import org.hl7.fhir.r5.terminologies.client.ITerminologyClientFactory5;
 import org.hl7.fhir.r5.terminologies.client.TerminologyClient5R5.TerminologyClientR5Factory;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;


public class TestPackageLoader implements IContextResourceLoader {

  private Set<String> types;
  private String webRoot;
  private boolean core;

  /**
   * Loads resources with no web path - the loaded resources have nothing to link to
   */
  public TestPackageLoader(Set<String> types) {
    this.types = types;
  }

  /**
   * Loads resources with web paths (as the real loaders do), so that renderers produce links
   * rather than null#... hrefs. Core packages use their web location and the core spec's page
   * naming (codesystem-x.html, patient.html); other packages use their canonical - not the
   * version specific web location, since some (THO) float to the latest version - and the IG
   * page naming (CodeSystem-x.html)
   */
  public TestPackageLoader(Set<String> types, NpmPackage npm) {
    this.types = types;
    this.core = npm.isCore();
    this.webRoot = core ? npm.getWebLocation() : npm.canonical();
  }

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    // used when a package can't be lazy loaded (e.g. one read from a stream). A single resource is
    // wrapped in a bundle; returning null here would silently drop it
    Resource r = isJson ? new JsonParser().parse(stream) : new XmlParser().parse(stream);
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
    return setWebPath(isJson ? new JsonParser().parse(stream) : new XmlParser().parse(stream));
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
  public IContextResourceLoader getNewLoader(NpmPackage npm) {
    return webRoot == null ? this : new TestPackageLoader(types, npm);
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
  public IContextResourceLoader setLoadProfiles(boolean value) {
    return this;
  }

  @Override
  public boolean wantLoad(NpmPackage pi, PackageResourceInformation pri) {
    return true;
  }

  @Override
  public ITerminologyClientFactory5 txFactory() {
    return new TerminologyClientR5Factory();
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
