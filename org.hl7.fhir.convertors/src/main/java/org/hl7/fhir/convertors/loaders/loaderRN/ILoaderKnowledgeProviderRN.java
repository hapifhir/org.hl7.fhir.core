package org.hl7.fhir.convertors.loaders.loaderRN;

import com.google.gson.JsonSyntaxException;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.utilities.npm.NpmPackage;

import java.io.IOException;

public interface ILoaderKnowledgeProviderRN {
  /**
   * get the path for references to this resource.
   *
   * @param resource
   * @return null if not tracking paths
   */
  String getResourcePath(Resource resource);

  ILoaderKnowledgeProviderRN forNewPackage(NpmPackage npm) throws JsonSyntaxException, IOException;

  String getWebRoot();
}
