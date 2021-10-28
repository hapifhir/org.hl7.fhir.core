package org.hl7.fhir.convertors.loaders.loaderR5;

import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class NullLoaderKnowledgeProviderR5 implements ILoaderKnowledgeProviderR5 {
  @Override
  public String getResourcePath(Resource resource) {
    return null;
  }

  @Override
  public ILoaderKnowledgeProviderR5 forNewPackage(NpmPackage npm) {
    return this;
  }
}
