package org.hl7.fhir.convertors.loaders.loaderR5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

import com.google.gson.JsonSyntaxException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public abstract class BaseLoaderR5 implements IContextResourceLoader {

  protected final String URL_BASE = "http://hl7.org/fhir/";
  protected final String URL_ELEMENT_DEF_NAMESPACE = "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace";
  protected boolean patchUrls;
  @Getter @Setter protected boolean killPrimitives;
  @Getter protected List<String> types = new ArrayList<>();
  protected ILoaderKnowledgeProviderR5 lkp;
  private boolean loadProfiles = true;

  public BaseLoaderR5(List<String> types, ILoaderKnowledgeProviderR5 lkp) {
    super();
    this.types.addAll(types);
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
      r.setWebPath(path);
    }
  }

  public IContextResourceLoader getNewLoader(NpmPackage npm) throws JsonSyntaxException, IOException {
    BaseLoaderR5 ret = loaderFactory(npm);
    ret.patchUrls = patchUrls;
    ret.killPrimitives = killPrimitives;
    return ret;
  }

  protected BaseLoaderR5 loaderFactory(NpmPackage npm) throws JsonSyntaxException, IOException {
    if (VersionUtilities.isR5Plus(npm.fhirVersion())) {
      return new R5ToR5Loader(types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR4BVer(npm.fhirVersion())) {
      return new R4BToR5Loader(types, lkp.forNewPackage(npm), npm.version());
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

  public boolean isPatchUrls() {
    return patchUrls;
  }

  public void setPatchUrls(boolean patchUrls) {
    this.patchUrls = patchUrls;
  }

  protected abstract String versionString();
  

  @Override
  public String patchUrl(String url, String type) {
    if (!patchUrls || url == null) {
      return url;
    } else if (url.startsWith("http://hl7.org/fhir/"+type+"/")) {
      return "http://hl7.org/fhir/"+versionString()+"/"+url.substring(20);
    } else if ("CodeSystem".equals(type) && url.startsWith("http://hl7.org/fhir/")) {      
      return "http://hl7.org/fhir/"+versionString()+"/"+url.substring(20);
    } else {
      return url;
    }
  }

  // we don't patch everything. It's quite hard work to do that,
  // and we only patch URLs to support version transforms
  // so we just patch sd/od -> vs -> cs
  protected void doPatchUrls(Resource resource) {
    resource.setUserData("old.load.mode", true);
    if (resource instanceof CanonicalResource) {
      CanonicalResource cr = (CanonicalResource) resource;
      cr.setUrl(patchUrl(cr.getUrl(), cr.fhirType()));
      if (cr instanceof StructureDefinition) {
        StructureDefinition sd = (StructureDefinition) cr;
        sd.setBaseDefinition(patchUrl(sd.getBaseDefinition(), sd.fhirType()));
        new ProfileUtilities(null, null, null, null).setIds(sd, false);
        sd.addExtension().setUrl(URL_ELEMENT_DEF_NAMESPACE).setValue(new UriType(URL_BASE));
        for (ElementDefinition ed : sd.getSnapshot().getElement())
          patchUrl(ed);
        for (ElementDefinition ed : sd.getDifferential().getElement())
          patchUrl(ed);
      }

      if (cr instanceof ValueSet) {
        ValueSet vs = (ValueSet) cr;
        for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
          inc.setSystem(patchUrl(inc.getSystem(), "CodeSystem"));
        }
        for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
          inc.setSystem(patchUrl(inc.getSystem(), "CodeSystem"));
        }        
      }
      if (cr instanceof OperationDefinition) {
        OperationDefinition od = (OperationDefinition) cr;
        for (OperationDefinitionParameterComponent param : od.getParameter()) {
          patchUrls(param);
        }        
      }
    }
  }
  
  private void patchUrls(OperationDefinitionParameterComponent param) {
    if (param.hasBinding()) {
      param.getBinding().setValueSet(patchUrl(param.getBinding().getValueSet(), "ValueSet"));      
    }
    for (OperationDefinitionParameterComponent p : param.getPart()) {
      patchUrls(p);
    }
  }

  private void patchUrl(ElementDefinition ed) {
    for (TypeRefComponent tr : ed.getType()) {
      if (!Utilities.isAbsoluteUrl(tr.getCode())) {
        tr.setCode(URL_BASE+versionString()+"/StructureDefinition/"+tr.getCode());
      }
      for (CanonicalType s : tr.getTargetProfile()) {
        s.setValue(patchUrl(s.getValue(), "StructureDefinition"));
      }
      if (tr.hasExtension(ToolingExtensions.EXT_FHIR_TYPE)) {
        String code = ToolingExtensions.readStringExtension(tr, ToolingExtensions.EXT_FHIR_TYPE);
        String url = URL_BASE+versionString()+"/StructureDefinition/"+code;
        ToolingExtensions.setUrlExtension(tr, ToolingExtensions.EXT_FHIR_TYPE, url);
      }
      for (CanonicalType c : tr.getProfile()) {
        c.setValue(patchUrl(c.getValue(), "StructureDefinition"));
      }
      for (CanonicalType c : tr.getTargetProfile()) {
        c.setValue(patchUrl(c.getValue(), "StructureDefinition"));
      }
    }
    if (ed.hasBinding()) {
      ed.getBinding().setValueSet(patchUrl(ed.getBinding().getValueSet(), "ValueSet"));
    }
    if (ed.hasContentReference()) {
      ed.setContentReference(patchUrl(ed.getContentReference(), "StructureDefinition"));
    }
  }

  public IContextResourceLoader setLoadProfiles(boolean value) {
    loadProfiles = value;
    return this;
  }
  
  public boolean wantLoad(NpmPackage pi, PackageResourceInformation pri) {
    if (pri.getResourceType().equals("StructureDefinition")) {
      if (loadProfiles) {
        return true;
      } else {
        return pi.isCore() && Utilities.tail(pri.getUrl()).equals(pri.getStatedType());
      }
    } else if (pi.isCore() && "spdx-license".equals(pri.getId())) {
      return false;
    } else {
      return true;
    }
  }
}
