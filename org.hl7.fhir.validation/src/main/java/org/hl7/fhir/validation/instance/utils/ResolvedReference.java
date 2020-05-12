package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.validation.instance.InstanceValidator;

public class ResolvedReference {

    private Element resource;
    private Element focus;
    private boolean external;
    private NodeStack stack;

    public ResolvedReference setResource(Element resource) {
        this.resource = resource;
        return this;
    }

    public Element getResource() {
        return resource;
    }

    public ResolvedReference setFocus(Element focus) {
        this.focus = focus;
        return this;
    }

    public boolean isExternal() {
        return external;
    }

    public ResolvedReference setExternal(boolean external) {
        this.external = external;
        return this;
    }

    public ResolvedReference setStack(NodeStack stack) {
        this.stack = stack;
        return this;
    }

    public NodeStack getStack() {
        return stack;
    }

    public String getType() {
        return focus.fhirType();
    }

    public Element getFocus() {
        return focus;
    }

    public ValidatorHostContext hostContext(ValidatorHostContext hostContext, StructureDefinition profile) {
        if (external) {
            return hostContext.forRemoteReference(profile, resource);
        } else {
            return hostContext.forLocalReference(profile, resource);
        }
    }
}