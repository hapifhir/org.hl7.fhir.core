package org.hl7.fhir.standalone.testing;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.services.context.IContextResourceLoader;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.standalone.context.PackageResourceLoader;
import org.hl7.fhir.model.core.Bundle;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.services.terminology.ITerminologyClientFactory;
import org.hl7.fhir.standalone.terminology.client.TerminologyClientR6;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TestPackageLoader implements IContextResourceLoader {

  private Set<String> types;
  private IWorkerContext context;


  public TestPackageLoader(Set<String> types,  IWorkerContext context) {
    this.types = types;
    this.context = context;
  }

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    return null;
  }

  @Override
  public Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException {
    return isJson ? new JsonParser(context).parse(stream) : new XmlParser(context).parse(stream);
  }

  @Override
  public Set<String> getTypes() {
    return types;
  }

  @Override
  public String getResourcePath(Resource resource) {
    return resource.fhirType().toLowerCase()+"-"+resource.getId()+".html";
  }

  @Override
  public IContextResourceLoader getNewLoader(NpmPackage npm) {
    return this;
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
  public ITerminologyClientFactory txFactory() {
    return new TerminologyClientR6.TerminologyClientR6Factory();
  }

  @Override
  public Set<String> reviewActualTypes(Set<String> types) {
    return types;
  }

}
