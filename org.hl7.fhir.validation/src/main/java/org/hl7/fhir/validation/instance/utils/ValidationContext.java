package org.hl7.fhir.validation.instance.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class ValidationContext {

    public static final String INTERNAL_REFERENCES_NAME = "internal.references";

    private Object appContext;

    // the version we are currently validating for right now
    // not implemented yet - this is the forerunner of a major upgrade to the validator
    private String version;
    
    // the resource we are actually validating right now
    private Element resource; 
    // the resource that is the scope of id resolution - either the same as resource, or the resource the contains that resource. This can only be one level deep.
    private Element rootResource;
    private Element groupingResource; // either a bundle or a parameters that holds the rootResource (for reference resolution)
    
    private StructureDefinition profile; // the profile that contains the content being validated
    
    private boolean checkSpecials = true;
    private Map<String, List<ValidationMessage>> sliceRecords;
    private Set<String> internalRefs;
    
    public ValidationContext(Object appContext) {
        this.appContext = appContext;
    }

    public ValidationContext(Object appContext, Element element) {
      this.appContext = appContext;
      this.resource = element;
      this.rootResource = element;
      this.internalRefs = setupInternalRefs(element);
      check();
      
      // no groupingResource (Bundle or Parameters)
      dump("creating");
  }

    private Set<String> setupInternalRefs(Element element) {
      Set<String> res = (Set<String>) element.getUserData(INTERNAL_REFERENCES_NAME);
      if (res == null) {
        res = new HashSet<String>();
        element.setUserData(INTERNAL_REFERENCES_NAME, res);       
      }
      return res;
    }

    private void check() {
      if (!rootResource.hasParentForValidator()) {
        throw new Error("No parent on root resource");
      }
    }

    public ValidationContext(Object appContext, Element element, Element root) {
      this.appContext = appContext;
      this.resource = element;
      this.rootResource = root;
      this.internalRefs = setupInternalRefs(element);
      check();
      // no groupingResource (Bundle or Parameters)
      dump("creating");
  }

    public ValidationContext(Object appContext, Element element, Element root, Element groupingResource) {
      this.appContext = appContext;
      this.resource = element;
      this.rootResource = root;
      this.groupingResource = groupingResource;
      this.internalRefs = setupInternalRefs(element);
      check();
      dump("creating");
  }

    public Object getAppContext() {
        return appContext;
    }

    public ValidationContext setAppContext(Object appContext) {
        this.appContext = appContext;
        return this;
    }

    public ValidationContext setResource(Element resource) {
        this.resource = resource;
        return this;
    }

    public Element getRootResource() {
        return rootResource;
    }

    public ValidationContext setRootResource(Element rootResource) {
        this.rootResource = rootResource;
        dump("setting root resource");
        return this;
    }

    public Element getGroupingResource() {
      return groupingResource;
    }

    public StructureDefinition getProfile() {
        return profile;
    }

    public ValidationContext setProfile(StructureDefinition profile) {
        this.profile = profile;
        return this;
    }

    public Map<String, List<ValidationMessage>> getSliceRecords() {
        return sliceRecords;
    }

    public ValidationContext setSliceRecords(Map<String, List<ValidationMessage>> sliceRecords) {
        this.sliceRecords = sliceRecords;
        return this;
    }

    public boolean isCheckSpecials() {
        return checkSpecials;
    }

    public void setCheckSpecials(boolean checkSpecials) {
        this.checkSpecials = checkSpecials;
    }

    public Element getResource() {
        return resource;
    }

    public void sliceNotes(String url, List<ValidationMessage> record) {
      if (sliceRecords != null) {  
        sliceRecords.put(url, record);
      }
    }

    public ValidationContext forContained(Element element) {
        ValidationContext res = new ValidationContext(appContext);
        res.rootResource = resource;
        res.resource = element;
        res.profile = profile;
        res.groupingResource = groupingResource;
        res.version = version;
        res.internalRefs = setupInternalRefs(element);
        res.dump("forContained");
        return res;
    }

    public ValidationContext forEntry(Element element, Element groupingResource) {
        ValidationContext res = new ValidationContext(appContext);
        res.rootResource = element;
        res.resource = element;
        res.profile = profile;
        res.groupingResource = groupingResource;
        res.version = version;
        res.internalRefs = setupInternalRefs(element);
        res.dump("forEntry");
        return res;
    }

    public ValidationContext forProfile(StructureDefinition profile) {
        ValidationContext res = new ValidationContext(appContext);
        res.resource = resource;
        res.rootResource = rootResource;
        res.profile = profile;
        res.version = version;
        res.groupingResource = groupingResource;
        res.internalRefs = internalRefs;
        res.sliceRecords = sliceRecords != null ? sliceRecords : new HashMap<String, List<ValidationMessage>>();
        res.dump("forProfile "+profile.getUrl());
        return res;
    }

    public ValidationContext forLocalReference(StructureDefinition profile, Element resource) {
        ValidationContext res = new ValidationContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.profile = profile;
        res.groupingResource = groupingResource;
        res.checkSpecials = false;
        res.internalRefs = setupInternalRefs(resource);
        res.dump("forLocalReference "+profile.getUrl());
        res.version = version;
        return res;
    }

    private void dump(String ctxt) {
//      System.out.println("** app = "+(appContext == null ? "(null)" : appContext.toString())+", res = "+resource.toString()+", root = "+rootResource.toString()+" ("+ctxt+")");
//      if (rootResource.getName().equals("contained")) {
//        System.out.println("** something is wrong!");        
//      }
    }

    public ValidationContext forRemoteReference(StructureDefinition profile, Element resource) {
        ValidationContext res = new ValidationContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.profile = profile;
        res.groupingResource = null;
        res.checkSpecials = false;
        res.version = version;
        res.internalRefs = setupInternalRefs(resource);
        res.dump("forRemoteReference "+profile.getUrl());
        return res;
    }

    public ValidationContext forSlicing() {
        ValidationContext res = new ValidationContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.groupingResource = groupingResource;
        res.profile = profile;
        res.checkSpecials = false;
        res.version = version;
        res.internalRefs = internalRefs;
        res.sliceRecords = new HashMap<String, List<ValidationMessage>>();
        res.dump("forSlicing");
        return res;
    }

    public String getVersion() {
      return version;
    }

    public ValidationContext setVersion(String version) {
      this.version = version;
      return this;
    }

    public Set<String> getInternalRefs() {
      return internalRefs;
    }


}