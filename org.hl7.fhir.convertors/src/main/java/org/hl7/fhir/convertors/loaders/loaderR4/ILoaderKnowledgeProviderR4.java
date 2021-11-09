package org.hl7.fhir.convertors.loaders.loaderR4;

import org.hl7.fhir.r4.model.Resource;

public interface ILoaderKnowledgeProviderR4 {
  /**
   * get the path for references to this resource.
   *
   * @param resource
   * @return null if not tracking paths
   */
  String getResourcePath(Resource resource);
}
