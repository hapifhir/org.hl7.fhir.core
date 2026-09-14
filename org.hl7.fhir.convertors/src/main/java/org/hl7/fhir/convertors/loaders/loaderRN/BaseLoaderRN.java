package org.hl7.fhir.convertors.loaders.loaderRN;

import com.google.gson.JsonSyntaxException;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.services.context.IContextResourceLoaderN;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Accessors(chain = true)
public abstract class BaseLoaderRN implements IContextResourceLoaderN {

  protected final String URL_BASE = "http://hl7.org/fhir/";

  protected boolean patchUrls;
  @Getter @Setter protected boolean killPrimitives;
  @Getter protected Set<String> types = new HashSet<>();
  protected ILoaderKnowledgeProviderRN lkp;
  private boolean loadProfiles = true;
  protected Set<String> tags = new HashSet<>();
  protected IModelContext context;

  public BaseLoaderRN(IModelContext context, Set<String> types, ILoaderKnowledgeProviderRN lkp) {
    super();
    this.context = context;
    this.types.addAll(types);
    this.lkp = lkp;
  }

  public String getResourcePath(Resource resource) {
    return lkp.getResourcePath(resource);
  }

  public void setPath(Resource r) {
    String path = lkp.getResourcePath(r);
    if (lkp.getWebRoot() != null) { 
      r.setUserData(UserDataNames.render_webroot, lkp.getWebRoot());
    } else {
      r.setUserData(UserDataNames.render_webroot, "");      
    }
    if (path != null) {
      r.setWebPath(path);
    }
  }

  public IContextResourceLoaderN getNewLoader(NpmPackage npm) throws JsonSyntaxException, IOException {
    BaseLoaderRN ret = loaderFactory(npm);
    ret.patchUrls = patchUrls;
    ret.killPrimitives = killPrimitives;
    return ret;
  }

  protected BaseLoaderRN loaderFactory(NpmPackage npm) throws JsonSyntaxException, IOException {
    if (VersionUtilities.isR5Plus(npm.fhirVersion())) {
      return new R5ToRNLoader(context, types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR4BVer(npm.fhirVersion())) {
      return new R4BToRNLoader(context, types, lkp.forNewPackage(npm), npm.fhirVersion());
    } else if (VersionUtilities.isR4Ver(npm.fhirVersion())) {
      return new R4ToRNLoader(context, types, lkp.forNewPackage(npm), npm.fhirVersion());
    } else if (VersionUtilities.isR3Ver(npm.fhirVersion())) {
      return new R3ToRNLoader(context, types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR2Ver(npm.fhirVersion())) {
      return new R2ToRNLoader(context, types, lkp.forNewPackage(npm));
    } else if (VersionUtilities.isR2BVer(npm.fhirVersion())) {
      return new R2016MayToRNLoader(context, types, lkp.forNewPackage(npm));
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
    resource.setUserData(UserDataNames.loader_urls_patched, true);
    if (resource instanceof CanonicalResource) {
      CanonicalResource cr = (CanonicalResource) resource;
      cr.setUrl(patchUrl(cr.getUrl(), cr.fhirType()));
      if (cr instanceof StructureDefinition) {
        StructureDefinition sd = (StructureDefinition) cr;
        sd.setBaseDefinition(patchUrl(sd.getBaseDefinition(), sd.fhirType()));
        new ProfileUtilities(null, null, null, null).setIds(sd, false);
        sd.addExtension().setUrl(ExtensionDefinitions.EXT_XML_NAMESPACE).setValue(new UriType(URL_BASE));
        for (ElementDefinition ed : sd.getSnapshot().getElementList())
          patchUrl(ed);
        for (ElementDefinition ed : sd.getDifferential().getElementList())
          patchUrl(ed);
      }

      if (cr instanceof ValueSet) {
        ValueSet vs = (ValueSet) cr;
        for (ValueSet.ConceptSetComponent inc : vs.getCompose().getIncludeList()) {
          inc.setSystem(patchUrl(inc.getSystem(), "CodeSystem"));
        }
        for (ValueSet.ConceptSetComponent inc : vs.getCompose().getExcludeList()) {
          inc.setSystem(patchUrl(inc.getSystem(), "CodeSystem"));
        }        
      }
      if (cr instanceof OperationDefinition) {
        OperationDefinition od = (OperationDefinition) cr;
        for (OperationDefinition.OperationDefinitionParameterComponent param : od.getParameterList()) {
          patchUrls(param);
        }        
      }
    }
  }
  
  private void patchUrls(OperationDefinition.OperationDefinitionParameterComponent param) {
    if (param.hasBinding()) {
      param.getBinding().setValueSet(patchUrl(param.getBinding().getValueSet(), "ValueSet"));      
    }
    for (OperationDefinition.OperationDefinitionParameterComponent p : param.getPartList()) {
      patchUrls(p);
    }
  }

  private void patchUrl(ElementDefinition ed) {
    for (ElementDefinition.TypeRefComponent tr : ed.getTypeList()) {
      if (!Utilities.isAbsoluteUrl(tr.getCode())) {
        tr.setCode(URL_BASE+versionString()+"/StructureDefinition/"+tr.getCode());
      }
      for (CanonicalType s : tr.getTargetProfileList()) {
        s.setValue(patchUrl(s.getValue(), "StructureDefinition"));
      }
      if (tr.hasExtension(ExtensionDefinitions.EXT_FHIR_TYPE)) {
        String code = ExtensionUtilities.readStringExtension(tr, ExtensionDefinitions.EXT_FHIR_TYPE);
        String url = URL_BASE+versionString()+"/StructureDefinition/"+code;
        ExtensionUtilities.setUrlExtension(tr, ExtensionDefinitions.EXT_FHIR_TYPE, url);
      }
      for (CanonicalType c : tr.getProfileList()) {
        c.setValue(patchUrl(c.getValue(), "StructureDefinition"));
      }
      for (CanonicalType c : tr.getTargetProfileList()) {
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

  public IContextResourceLoaderN setLoadProfiles(boolean value) {
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
    } else if (pi.isCore() && "CodeSystem".equals(pri.getResourceType()) && "spdx-license".equals(pri.getId())) {
      return false;
    } else {
      return true;
    }
  }

  public BaseLoaderRN addTag(String tag) {
    if (tag != null) {
      tags.add(tag);
    }
    return this;
  }

  protected void inspectResource(Resource res) {
    for (String t : tags) {
      res.setUserData(t, true);
    }
  }
}
