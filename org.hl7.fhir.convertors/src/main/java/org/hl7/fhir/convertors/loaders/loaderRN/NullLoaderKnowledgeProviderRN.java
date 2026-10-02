package org.hl7.fhir.convertors.loaders.loaderRN;

import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class NullLoaderKnowledgeProviderRN implements ILoaderKnowledgeProviderRN {
  @Override
  public String getResourcePath(Resource resource) {
    return null;
  }

  @Override
  public ILoaderKnowledgeProviderRN forNewPackage(NpmPackage npm) {
    return this;
  }

  @Override
  public String getWebRoot() {
     return null;
  }
}
