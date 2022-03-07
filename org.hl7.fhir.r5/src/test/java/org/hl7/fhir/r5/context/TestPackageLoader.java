package org.hl7.fhir.r5.context;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class TestPackageLoader implements IContextResourceLoader {

  private String[] types;

  public TestPackageLoader(String[] types) {
    this.types = types;
  }

  @Override
  public Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException {
    return null;
  }

  @Override
  public Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException {
    return isJson ? new JsonParser().parse(stream) : new XmlParser().parse(stream);
  }

  @Override
  public String[] getTypes() {
    return types;
  }

  @Override
  public String getResourcePath(Resource resource) {
    return null;
  }

  @Override
  public IContextResourceLoader getNewLoader(NpmPackage npm) {
    return this;
  }
}
