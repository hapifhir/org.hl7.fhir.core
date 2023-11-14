package org.hl7.fhir.r5.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

import com.google.gson.JsonSyntaxException;

public interface IContextResourceLoader {
  /** 
   * @return List of the resource types that should be loaded
   */
  List<String> getTypes();

  /**
   * Request to actually load the resources and do whatever is required
   *  
   * @param stream
   * @param isJson
   * @return A bundle because some single resources become multiple resources after loading
   * @throws FHIRException
   * @throws IOException
   */
  Bundle loadBundle(InputStream stream, boolean isJson) throws FHIRException, IOException;

  /**
   * Load a single resources (lazy load)
   * 
   * @param stream
   * @param isJson
   * @return
   * @throws FHIRException - throw this if you a single resource can't be returned - can't lazy load in this circumstance   
   * @throws IOException
   */
  Resource loadResource(InputStream stream, boolean isJson) throws FHIRException, IOException;

  /** 
   * get the path for references to this resource.
   * @param resource
   * @return null if not tracking paths
   */
  String getResourcePath(Resource resource);

  /**
   * called when a new package is being loaded
   * 
   * this is called by loadPackageAndDependencies when a new package is loaded
   * @param npm
   * @return
   * @throws IOException 
   * @throws JsonSyntaxException 
   */
  IContextResourceLoader getNewLoader(NpmPackage npm) throws JsonSyntaxException, IOException;

  /**
   * called when processing R2 for implicit code systems in ValueSets 
   * 
   * @return
   */
  List<CodeSystem> getCodeSystems();  
  
  /**
   * if this is true, then the loader will patch canonical URLs and cross-links 
   * to add /X.X/ into the URL so that different versions can be loaded safely 
   * 
   * default is false
   */
  void setPatchUrls(boolean value);

  /**
   * patch the URL if necessary
   * 
   * @param url
   * @return
   */
  String patchUrl(String url, String resourceType);
  
  /** 
   * set this to false (default is true) if you don't want profiles loaded
   * @param value
   * @return
   */
  IContextResourceLoader setLoadProfiles(boolean value);
  
  /**
   * Called during the loading process - the loader can decide which resources to load. 
   * At this point, only the .index.json is being read 
   *  
   * @param pi
   * @param pri
   * @return
   */
  boolean wantLoad(NpmPackage pi, PackageResourceInformation pri);
}