package org.hl7.fhir.convertors.loaders.loaderR3;

import org.hl7.fhir.dstu3.context.SimpleWorkerContext.IContextResourceLoader;
import org.hl7.fhir.dstu3.model.Resource;

public abstract class BaseLoaderR3 implements IContextResourceLoader {

  protected final String URL_BASE = "http://hl7.org/fhir/";
  protected final String URL_DSTU2 = "http://hl7.org/fhir/1.0/";
  protected final String URL_DSTU2016MAY = "http://hl7.org/fhir/1.4/";
  protected final String URL_DSTU3 = "http://hl7.org/fhir/3.0/";
  protected final String URL_R4 = "http://hl7.org/fhir/4.0/";
  protected final String URL_ELEMENT_DEF_NAMESPACE = "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace";
  private final String[] types;
  private final ILoaderKnowledgeProvider lkp;
  protected boolean patchUrls;
  protected boolean killPrimitives;

  public BaseLoaderR3(String[] types, ILoaderKnowledgeProvider lkp) {
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

  public BaseLoaderR3 setPatchUrls(boolean patchUrls) {
    this.patchUrls = patchUrls;
    return this;
  }

  public boolean isKillPrimitives() {
    return killPrimitives;
  }

  public BaseLoaderR3 setKillPrimitives(boolean killPrimitives) {
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

  public interface ILoaderKnowledgeProvider {
    /**
     * get the path for references to this resource.
     *
     * @param resource
     * @return null if not tracking paths
     */
    String getResourcePath(Resource resource);
  }

  public static class NullLoaderKnowledgeProvider implements ILoaderKnowledgeProvider {
    @Override
    public String getResourcePath(Resource resource) {
      return null;
    }
  }
}