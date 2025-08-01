package org.hl7.fhir.convertors.loaders.loaderR3;

import javax.annotation.Nonnull;

import org.hl7.fhir.dstu3.support.context.SimpleWorkerContext;
import org.hl7.fhir.dstu3.model.Resource;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public abstract class BaseLoaderR3 implements SimpleWorkerContext.IContextResourceLoader {

  protected final String URL_BASE = "http://hl7.org/fhir/";
  protected final String URL_DSTU2 = "http://hl7.org/fhir/1.0/";
  protected final String URL_DSTU2016MAY = "http://hl7.org/fhir/1.4/";
  protected final String URL_DSTU3 = "http://hl7.org/fhir/3.0/";
  protected final String URL_R4 = "http://hl7.org/fhir/4.0/";
  @Getter private final String[] types;
  private final ILoaderKnowledgeProviderR3 lkp;

  @Getter @Setter protected boolean patchUrls;
  @Getter @Setter protected boolean killPrimitives;

  public BaseLoaderR3(@Nonnull String[] types, @Nonnull ILoaderKnowledgeProviderR3 lkp) {
    super();
    this.types = types;
    this.lkp = lkp;
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

}