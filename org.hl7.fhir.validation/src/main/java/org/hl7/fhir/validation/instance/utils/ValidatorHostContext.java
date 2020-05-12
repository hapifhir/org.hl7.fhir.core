package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidatorHostContext {

    private Object appContext;
    private Element container; // bundle, or parameters
    private Element resource;
    private Element rootResource;
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
    }

    public Object getAppContext() {
        return appContext;
    }

    public ValidatorHostContext setAppContext(Object appContext) {
        this.appContext = appContext;
        return this;
    }

    public Element getContainer() {
        return container;
    }

    public ValidatorHostContext setContainer(Element container) {
        this.container = container;
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
        return this;
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
        sliceRecords.put(url, record);
    }

    public ValidatorHostContext forContained(Element element) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.rootResource = resource;
        res.resource = element;
        res.container = resource;
        res.profile = profile;
        return res;
    }

    public ValidatorHostContext forEntry(Element element) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.rootResource = element;
        res.resource = element;
        res.container = resource;
        res.profile = profile;
        return res;
    }

    public ValidatorHostContext forProfile(StructureDefinition profile) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.resource = resource;
        res.rootResource = rootResource;
        res.container = container;
        res.profile = profile;
        res.sliceRecords = sliceRecords != null ? sliceRecords : new HashMap<String, List<ValidationMessage>>();
        return res;
    }

    public ValidatorHostContext forLocalReference(StructureDefinition profile, Element resource) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.container = container;
        res.profile = profile;
        res.checkSpecials = false;
        return res;
    }

    public ValidatorHostContext forRemoteReference(StructureDefinition profile, Element resource) {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.container = resource;
        res.profile = profile;
        res.checkSpecials = false;
        return res;
    }

    public ValidatorHostContext forSlicing() {
        ValidatorHostContext res = new ValidatorHostContext(appContext);
        res.resource = resource;
        res.rootResource = resource;
        res.container = resource;
        res.profile = profile;
        res.checkSpecials = false;
        res.sliceRecords = new HashMap<String, List<ValidationMessage>>();
        return res;
    }


}