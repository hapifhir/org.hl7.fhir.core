package org.hl7.fhir.convertors.loaders.loaderR3;

import org.hl7.fhir.dstu3.model.Resource;

public interface ILoaderKnowledgeProviderR3 {
  /**
   * get the path for references to this resource.
   *
   * @param resource
   * @return null if not tracking paths
   */
  String getResourcePath(Resource resource);
}
