package org.hl7.fhir.r5.renderers.utils;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.w3c.dom.Element;

public class Resolver {

  public interface IReferenceResolver {
    ResourceWithReference resolve(RenderingContext context, String url);
    
    // returns null if contained resource is inlined 
    String urlForContained(RenderingContext context, String containingType, String containingId, String containedType, String containedId);
  }

  public static class ResourceContext {
    private ResourceContext container;

    Resource resource;
    org.hl7.fhir.r5.elementmodel.Element element;

    public ResourceContext(ResourceContext container, Resource dr) {
      super();
      this.container = container;
      this.resource = dr;
    }

    public ResourceContext(ResourceContext container, org.hl7.fhir.r5.elementmodel.Element dr) {
      super();
      this.container = container;
      this.element = dr;
    }

    
//    public ResourceContext(Object bundle, Element doc) {
//      // TODO Auto-generated constructor stub
//    }

//    public Bundle getBundleResource() {
//      return containerResource;
//    }


    public ResourceContext(ResourceContext container, ResourceWrapper rw) {
      super();
      this.container = container;
      // todo: howto do this better?
      
      if (rw instanceof DirectWrappers.ResourceWrapperDirect) {
        this.resource = ((DirectWrappers.ResourceWrapperDirect) rw).getResource();
      } else if (rw instanceof ElementWrappers.ResourceWrapperMetaElement) {
        this.element = ((ElementWrappers.ResourceWrapperMetaElement) rw).getElement();
      } else {
        throw new Error("Not supported yet");
      }
    }

    public ResourceContext getContainer() {
      return container;
    }

    public void setContainer(ResourceContext container) {
      this.container = container;
    }

    //    public org.hl7.fhir.r5.elementmodel.Element getBundleElement() {
//      return containerElement;
//    }
//
    public Resource getResource() {
      return resource;
    }

    public org.hl7.fhir.r5.elementmodel.Element getElement() {
      return element;
    }

    public BundleEntryComponent resolve(String value) {
      if (value.startsWith("#")) {
        if (resource instanceof DomainResource) {
          DomainResource dr = (DomainResource) resource;
          for (Resource r : dr.getContained()) {
            if (r.getId().equals(value.substring(1))) {
              BundleEntryComponent be = new BundleEntryComponent();
              be.setResource(r);
              return be;
            }
          }
        }
        return null;
      }
      
      if (resource instanceof Bundle) {
        Bundle b = (Bundle) resource;
        for (BundleEntryComponent be : b.getEntry()) {
          if (be.getFullUrl().equals(value))
            return be;
          if (value.equals(be.getResource().fhirType()+"/"+be.getResource().getId()))
            return be;
        }
      } 

      if (resource instanceof Parameters) {
        Parameters pp = (Parameters) resource;
        for (ParametersParameterComponent p : pp.getParameter()) {
          if (p.getResource() != null && value.equals(p.getResource().fhirType()+"/"+p.getResource().getId())) {
            BundleEntryComponent be = new BundleEntryComponent();
            be.setResource(p.getResource());
            return be;

          }
        }
      } 

      return container != null ? container.resolve(value) : null;
    }

    public org.hl7.fhir.r5.elementmodel.Element resolveElement(String value, String version) {
      if (value.startsWith("#")) {
        if (element != null) {
          for (org.hl7.fhir.r5.elementmodel.Element r : element.getChildrenByName("contained")) {
            if (r.getChildValue("id").equals(value.substring(1)))
              return r;
          }          
        }
        return null;
      }
      if (element != null) {
        if (element.fhirType().equals("Bundle")) {
          for (org.hl7.fhir.r5.elementmodel.Element be : element.getChildren("entry")) {
            org.hl7.fhir.r5.elementmodel.Element res = be.getNamedChild("resource");
            if (res != null) { 
              if (value.equals(be.getChildValue("fullUrl"))) {
                if (checkVersion(version, res)) {
                  return be;
                }
              }
              if (value.equals(res.fhirType()+"/"+res.getChildValue("id"))) {
                if (checkVersion(version, res)) {
                  return be;
                }
              }
            }
          }
        }
        if (element.fhirType().equals("Parameters")) {
          for (org.hl7.fhir.r5.elementmodel.Element p : element.getChildren("parameter")) {
            org.hl7.fhir.r5.elementmodel.Element res = p.getNamedChild("resource");
            if (res != null && value.equals(res.fhirType()+"/"+res.getChildValue("id"))) {
              if (checkVersion(version, res)) {
                return p;
              }
            }
          }
        }
      }
      return container != null ? container.resolveElement(value, version) : null;
    }

    private boolean checkVersion(String version, org.hl7.fhir.r5.elementmodel.Element res) {
      if (version == null) {
        return true;
      } else if (!res.hasChild("meta")) {
        return false;
      } else {
        org.hl7.fhir.r5.elementmodel.Element meta = res.getNamedChild("meta");
        return version.equals(meta.getChildValue("version"));
      }
    }
  }

  public static class ResourceWithReference {

    private String reference;
    private ResourceWrapper resource;

    public ResourceWithReference(String reference, ResourceWrapper resource) {
      this.reference = reference;
      this.resource = resource;
    }

    public String getReference() {
      return reference;
    }

    public ResourceWrapper getResource() {
      return resource;
    }
  }



}