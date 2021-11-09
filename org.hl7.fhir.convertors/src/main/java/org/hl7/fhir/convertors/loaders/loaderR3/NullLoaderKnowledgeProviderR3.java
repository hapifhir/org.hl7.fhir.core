package org.hl7.fhir.convertors.loaders.loaderR3;

import org.hl7.fhir.dstu3.model.Resource;

public class NullLoaderKnowledgeProviderR3 implements ILoaderKnowledgeProviderR3 {
  @Override
  public String getResourcePath(Resource resource) {
    return null;
  }
}
