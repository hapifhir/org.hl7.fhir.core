package org.hl7.fhir.convertors.loaders.loaderR4;

import org.hl7.fhir.r4.model.Resource;

public class NullLoaderKnowledgeProviderR4 implements ILoaderKnowledgeProviderR4 {
  @Override
  public String getResourcePath(Resource resource) {
    return null;
  }
}
