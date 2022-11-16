package org.hl7.fhir.convertors.loaders.loaderR5;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.NpmPackage;

import com.google.gson.JsonSyntaxException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public abstract class BaseLoaderR5 implements IContextResourceLoader {

  protected final String URL_BASE = "http://hl7.org/fhir/";
  protected final String URL_DSTU2 = "http://hl7.org/fhir/1.0/";
  protected final String URL_DSTU2016MAY = "http://hl7.org/fhir/1.4/";
  protected final String URL_DSTU3 = "http://hl7.org/fhir/3.0/";
  protected final String URL_R4 = "http://hl7.org/fhir/4.0/";
  protected final String URL_ELEMENT_DEF_NAMESPACE = "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace";
  @Getter @Setter protected boolean patchUrls;
  @Getter @Setter protected boolean killPrimitives;
  @Getter protected String[] types;
  protected ILoaderKnowledgeProviderR5 lkp;

  public BaseLoaderR5(String[] types, ILoaderKnowledgeProviderR5 lkp) {
    super();
    this.types = types;
    this.lkp = lkp;
  }

  public String getResourcePath(Resource resource) {
    return lkp.getResourcePath(resource);
  }

  public void setPath(Resource r) {
    String path = lkp.getResourcePath(r);
    if (lkp.getWebRoot() != null) { 
      r.setUserData("webroot", lkp.getWebRoot());
    } else {
      r.setUserData("webroot", "");      
    }
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
      return new R4ToR5Loader(types, lkp.forNewPackage(npm), npm.version());
    } else if (VersionUtilities.isR3Ver(npm.fhirVersion())) {
      return new R3ToR5Loader(types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR2Ver(npm.fhirVersion())) {
      return new R2ToR5Loader(types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR2BVer(npm.fhirVersion())) {
      return new R2016MayToR5Loader(types, lkp.forNewPackage(npm));
    } else {
      throw new FHIRException("Unsupported FHIR Version " + npm.fhirVersion());
    }
  }

}