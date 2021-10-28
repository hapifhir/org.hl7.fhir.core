package org.hl7.fhir.convertors.loaders.loaderR4;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hl7.fhir.r4.context.SimpleWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r4.model.Resource;

import javax.annotation.Nonnull;

@Accessors(chain = true)
public abstract class BaseLoaderR4 implements IContextResourceLoader {

  protected final String URL_BASE = "http://hl7.org/fhir/";
  protected final String URL_DSTU2 = "http://hl7.org/fhir/1.0/";
  protected final String URL_DSTU2016MAY = "http://hl7.org/fhir/1.4/";
  protected final String URL_DSTU3 = "http://hl7.org/fhir/3.0/";
  protected final String URL_R4 = "http://hl7.org/fhir/4.0/";
  protected final String URL_ELEMENT_DEF_NAMESPACE = "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace";
  @Getter private final String[] types;
  private final ILoaderKnowledgeProviderR4 lkp;
  @Getter @Setter protected boolean patchUrls;
  @Getter @Setter protected boolean killPrimitives;

  public BaseLoaderR4(@Nonnull String[] types, @Nonnull ILoaderKnowledgeProviderR4 lkp) {
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