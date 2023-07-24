package org.hl7.fhir.validation.instance.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class ValidatorHostContext {

    private Object appContext;

    // the resource we are actually validating right now
    private Element resource; 
    // the resource that is the scope of id resolution - either the same as resource, or the resource the contains that resource. This can only be one level deep.
    private Element rootResource;
    private Element groupingResource; // either a bundle or a parameters that holds the rootResource (for reference resolution)
    
    private StructureDefinition profile; // the profile that contains the content being validated
    private boolean checkSpecials = true;
    private Map<String, List<ValidationMessage>> sliceRecords;

    public ValidatorHostContext(Object appContext) {
        this.appContext = appContext;
    }

    public ValidatorHostContext(Object appContext, Element element) {
      this.appContext = appContext;
      this.resource = element;
      this.rootResource = element;
      check();
      
      // no groupingResource (Bundle or Parameters)
      dump("creating");
  }

    private void check() {
      if (!rootResource.hasParentForValidator()) {
        throw new Error("No parent on root resource");
      }
    }

    public ValidatorHostContext(Object appContext, Element element, Element root) {
      this.appContext = appContext;
      this.resource = element;
      this.rootResource = root;
      check();
      // no groupingResource (Bundle or Parameters)
      dump("creating");
  }

    public ValidatorHostContext(Object appContext, Element element, Element root, Element groupingResource) {
      this.appContext = appContext;
      this.resource = element;
      this.rootResource = root;
      this.groupingResource = groupingResource;
      check();
      dump("creating");
  }

    public Object getAppContext() {
        return appContext;
    }

    public ValidatorHostContext setAppContext(Object appContext) {
        this.appContext = appContext;
        return this;
    }

    public ValidatorHostContext setResource(Element resource) {
        this.resource = resource;
        return this;
    }

    public Element getRootResource() {
        return rootResource;
    }

    public ValidatorHostContext setRootResource(Element rootResource) {
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

    public ValidatorHostContext setProfile(StructureDefinition profile) {
        this.profile = profile;
        return this;
    }

    public Map<String, List<ValidationMessage>> getSliceRecords() {
        return sliceRecords;
    }

    public ValidatorHostContext setSliceRecords(Map<String, List<ValidationMessage>> sliceRecords) {
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

    public ValidatorHostContext forContained(Element element) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.rootResource = resource;
        res.resource = element;
        res.profile = profile;
        res.groupingResource = groupingResource;
        res.dump("forContained");
        return res;
    }

    public ValidatorHostContext forEntry(Element element, Element groupingResource) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.rootResource = element;
        res.resource = element;
        res.profile = profile;
        res.groupingResource = groupingResource;
        res.dump("forEntry");
        return res;
    }

    public ValidatorHostContext forProfile(StructureDefinition profile) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.resource = resource;
        res.rootResource = rootResource;
        res.profile = profile;
        res.groupingResource = groupingResource;
        res.sliceRecords = sliceRecords != null ? sliceRecords : new HashMap<String, List<ValidationMessage>>();
        res.dump("forProfile "+profile.getUrl());
        return res;
    }

    public ValidatorHostContext forLocalReference(StructureDefinition profile, Element resource) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.profile = profile;
        res.groupingResource = groupingResource;
        res.checkSpecials = false;
        res.dump("forLocalReference "+profile.getUrl());
        return res;
    }

    private void dump(String ctxt) {
//      System.out.println("** app = "+(appContext == null ? "(null)" : appContext.toString())+", res = "+resource.toString()+", root = "+rootResource.toString()+" ("+ctxt+")");
//      if (rootResource.getName().equals("contained")) {
//        System.out.println("** something is wrong!");        
//      }
    }

    public ValidatorHostContext forRemoteReference(StructureDefinition profile, Element resource) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.profile = profile;
        res.groupingResource = null;
        res.checkSpecials = false;
        res.dump("forRemoteReference "+profile.getUrl());
        return res;
    }

    public ValidatorHostContext forSlicing() {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.groupingResource = groupingResource;
        res.profile = profile;
        res.checkSpecials = false;
        res.sliceRecords = new HashMap<String, List<ValidationMessage>>();
        res.dump("forSlicing");
        return res;
    }


}