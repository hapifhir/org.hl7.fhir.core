package org.hl7.fhir.r5.renderers.utils;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContextType;
import org.w3c.dom.Element;

public class Resolver {

  public enum ResourceContextType {
    PARAMETERS, BUNDLE
  }

  public interface IReferenceResolver {
    ResourceWithReference resolve(RenderingContext context, String url);
  }

  public static class ResourceContext {
    private ResourceContextType type;
    private Resource containerResource;
    private org.hl7.fhir.r5.elementmodel.Element containerElement;

    DomainResource resourceResource;
    org.hl7.fhir.r5.elementmodel.Element resourceElement;

    public ResourceContext(ResourceContextType type, Resource bundle, DomainResource dr) {
      super();
      this.type = type;
      this.containerResource = bundle;
      this.resourceResource = dr;
    }

    public ResourceContext(ResourceContextType type, org.hl7.fhir.r5.elementmodel.Element bundle, org.hl7.fhir.r5.elementmodel.Element dr) {
      super();
      this.type = type;
      this.containerElement = bundle;
      this.resourceElement = dr;
    }

//    public ResourceContext(Object bundle, Element doc) {
//      // TODO Auto-generated constructor stub
//    }

//    public Bundle getBundleResource() {
//      return containerResource;
//    }


    //    public org.hl7.fhir.r5.elementmodel.Element getBundleElement() {
//      return containerElement;
//    }
//
    public DomainResource getResourceResource() {
      return resourceResource;
    }

    public org.hl7.fhir.r5.elementmodel.Element getResourceElement() {
      return resourceElement;
    }

    public BundleEntryComponent resolve(String value) {
      if (value.startsWith("#")) {
        if (resourceResource != null) {
          for (Resource r : resourceResource.getContained()) {
            if (r.getId().equals(value.substring(1))) {
              BundleEntryComponent be = new BundleEntryComponent();
              be.setResource(r);
              return be;
            }
          }
        }
        return null;
      }
      if (type == ResourceContextType.BUNDLE) {
        if (containerResource != null) {
          for (BundleEntryComponent be : ((Bundle) containerResource).getEntry()) {
            if (be.getFullUrl().equals(value))
              return be;
            if (value.equals(be.getResource().fhirType()+"/"+be.getResource().getId()))
              return be;
          }
        } 
      }
      if (type == ResourceContextType.PARAMETERS) {
        if (containerResource != null) {
          for (ParametersParameterComponent p : ((Parameters) containerResource).getParameter()) {
            if (p.getResource() != null && value.equals(p.getResource().fhirType()+"/"+p.getResource().getId())) {
              BundleEntryComponent be = new BundleEntryComponent();
              be.setResource(p.getResource());
              return be;
              
            }
          }
        } 
      }
      return null;
    }

    public org.hl7.fhir.r5.elementmodel.Element resolveElement(String value) {
      if (value.startsWith("#")) {
        if (resourceElement != null) {
          for (org.hl7.fhir.r5.elementmodel.Element r : resourceElement.getChildrenByName("contained")) {
            if (r.getChildValue("id").equals(value.substring(1)))
              return r;
          }          
        }
        return null;
      }
      if (type == ResourceContextType.BUNDLE) {
        if (containerElement != null) {
          for (org.hl7.fhir.r5.elementmodel.Element be : containerElement.getChildren("entry")) {
            org.hl7.fhir.r5.elementmodel.Element res = be.getNamedChild("resource");
            if (value.equals(be.getChildValue("fullUrl")))
              return be;
            if (value.equals(res.fhirType()+"/"+res.getChildValue("id")))
              return be;
          }
        }
      }
      if (type == ResourceContextType.PARAMETERS) {
        if (containerElement != null) {
          for (org.hl7.fhir.r5.elementmodel.Element p : containerElement.getChildren("parameter")) {
            org.hl7.fhir.r5.elementmodel.Element res = p.getNamedChild("resource");
            if (res != null && value.equals(res.fhirType()+"/"+res.getChildValue("id")))
              return p;
          }
        }
      }
      return null;
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