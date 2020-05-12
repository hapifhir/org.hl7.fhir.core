package org.hl7.fhir.r5.renderers.utils;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.w3c.dom.Element;

public class Resolver {

  public interface IReferenceResolver {
    ResourceWithReference resolve(String url);
  }

  public static class ResourceContext {
    Bundle bundleResource;
    org.hl7.fhir.r5.elementmodel.Element bundleElement;

    DomainResource resourceResource;
    org.hl7.fhir.r5.elementmodel.Element resourceElement;

    public ResourceContext(Bundle bundle, DomainResource dr) {
      super();
      this.bundleResource = bundle;
      this.resourceResource = dr;
    }

    public ResourceContext(org.hl7.fhir.r5.elementmodel.Element bundle, org.hl7.fhir.r5.elementmodel.Element dr) {
      this.bundleElement = bundle;
      this.resourceElement = dr;
    }

    public ResourceContext(Object bundle, Element doc) {
      // TODO Auto-generated constructor stub
    }

    public Bundle getBundleResource() {
      return bundleResource;
    }

    public org.hl7.fhir.r5.elementmodel.Element getBundleElement() {
      return bundleElement;
    }

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
      if (bundleResource != null) {
        for (BundleEntryComponent be : bundleResource.getEntry()) {
          if (be.getFullUrl().equals(value))
            return be;
          if (value.equals(be.getResource().fhirType()+"/"+be.getResource().getId()))
            return be;
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
      if (bundleElement != null) {
        for (org.hl7.fhir.r5.elementmodel.Element be : bundleElement.getChildren("entry")) {
          org.hl7.fhir.r5.elementmodel.Element res = be.getNamedChild("resource");
          if (value.equals(be.getChildValue("fullUrl")))
            return be;
          if (value.equals(res.fhirType()+"/"+res.getChildValue("id")))
            return be;
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