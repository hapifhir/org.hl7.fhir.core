package org.hl7.fhir.convertors.loaders.loaderR5;

import com.google.gson.JsonSyntaxException;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.npm.NpmPackage;

import java.io.IOException;

public interface ILoaderKnowledgeProviderR5 {
  /**
   * get the path for references to this resource.
   *
   * @param resource
   * @return null if not tracking paths
   */
  String getResourcePath(Resource resource);

  ILoaderKnowledgeProviderR5 forNewPackage(NpmPackage npm) throws JsonSyntaxException, IOException;
}
