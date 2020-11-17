package org.hl7.fhir.convertors.loaders;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.NpmPackage;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLoaderR5 implements IContextResourceLoader  {

  public interface ILoaderKnowledgeProvider {
    /** 
     * get the path for references to this resource.
     * @param resource
     * @return null if not tracking paths
     */
    String getResourcePath(Resource resource);
    ILoaderKnowledgeProvider forNewPackage(NpmPackage npm) throws JsonSyntaxException, IOException;
  }
  
  public static class NullLoaderKnowledgeProvider implements ILoaderKnowledgeProvider {
    @Override
    public String getResourcePath(Resource resource) {
      return null;
    }

    @Override
    public ILoaderKnowledgeProvider forNewPackage(NpmPackage npm) {
      return this;
    }
  }
  protected final String URL_BASE = "http://hl7.org/fhir/";
  protected final String URL_DSTU2 = "http://hl7.org/fhir/1.0/";
  protected final String URL_DSTU2016MAY = "http://hl7.org/fhir/1.4/";
  protected final String URL_DSTU3 = "http://hl7.org/fhir/3.0/";
  protected final String URL_R4 = "http://hl7.org/fhir/4.0/";

  protected final String URL_ELEMENT_DEF_NAMESPACE = "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace";

  protected boolean patchUrls;
  protected boolean killPrimitives;;

  protected String[] types;
  protected ILoaderKnowledgeProvider lkp;

  public BaseLoaderR5(String[] types, ILoaderKnowledgeProvider lkp) {
    super();
    this.types = types;
    this.lkp = lkp;
  }
  
  public String[] getTypes() {
    return types;
  }

  public boolean isPatchUrls() {
    return patchUrls;
  }

  public BaseLoaderR5 setPatchUrls(boolean patchUrls) {
    this.patchUrls = patchUrls;
    return this;
  }

  public boolean isKillPrimitives() {
    return killPrimitives;
  }

  public BaseLoaderR5 setKillPrimitives(boolean killPrimitives) {
    this.killPrimitives = killPrimitives;
    return this;
  }

  public String getResourcePath(Resource resource) {
    return lkp.getResourcePath(resource);
  }

  public void setPath(Resource r) {
    String path = lkp.getResourcePath(r);
    if (path != null) {
      r.setUserData("path", path);
    }
  }

  public IContextResourceLoader getNewLoader(NpmPackage npm) throws JsonSyntaxException, IOException {
    BaseLoaderR5 ret = loaderFactory(npm);
    ret.patchUrls = patchUrls;
    ret.killPrimitives = killPrimitives;
    return ret;
  }

  protected BaseLoaderR5 loaderFactory(NpmPackage npm) throws JsonSyntaxException, IOException {
    if (VersionUtilities.isR5Ver(npm.fhirVersion())) {
      return new R5ToR5Loader(types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR4Ver(npm.fhirVersion())) {
      return new R4ToR5Loader(types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR3Ver(npm.fhirVersion())) {
      return new R3ToR5Loader(types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR2Ver(npm.fhirVersion())) {
      return new R2ToR5Loader(types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR2BVer(npm.fhirVersion())) {
      return new R2016MayToR5Loader(types, lkp.forNewPackage(npm));
    } else {
      throw new FHIRException("Unsupported FHIR Version "+npm.fhirVersion());
    }
  }


}