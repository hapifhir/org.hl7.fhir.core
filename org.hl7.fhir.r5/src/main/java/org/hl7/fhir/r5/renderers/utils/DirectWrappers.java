package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Encounter;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.EncounterRenderer;
import org.hl7.fhir.r5.renderers.PatientRenderer;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.RendererWrapperImpl;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.WrapperBaseImpl;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class DirectWrappers {

  public static class PropertyWrapperDirect extends RendererWrapperImpl implements PropertyWrapper {
    private Property wrapped;
    private List<BaseWrapper> list;
    private ElementDefinition ed;

    public PropertyWrapperDirect(RenderingContext context, Property wrapped) {
      super(context);
      if (wrapped == null)
        throw new Error("wrapped == null");
      this.wrapped = wrapped;
    }

    public PropertyWrapperDirect(RenderingContext context, Property wrapped, ElementDefinition ed) {
      super(context);
      if (wrapped == null)
        throw new Error("wrapped == null");
      this.wrapped = wrapped;
      this.ed = ed;
    }

    @Override
    public String getName() {
      return wrapped.getName();
    }

    public Property getWrapped() {
      return wrapped;
    }

    @Override
    public boolean hasValues() {
      return wrapped.hasValues();
    }

    @Override
    public List<BaseWrapper> getValues() {
      if (list == null) {
        list = new ArrayList<BaseWrapper>();
        for (Base b : wrapped.getValues())
          list.add(b == null ? null : new BaseWrapperDirect(context, b));
      }
      return list;
    }

    @Override
    public String getTypeCode() {
      return wrapped.getTypeCode();
    }

    @Override
    public String getDefinition() {
      return wrapped.getDefinition();
    }

    @Override
    public int getMinCardinality() {
      return wrapped.getMinCardinality();
    }

    @Override
    public int getMaxCardinality() {
      return wrapped.getMinCardinality();
    }

    @Override
    public StructureDefinition getStructure() {
      return wrapped.getStructure();
    }

    @Override
    public BaseWrapper value() {
      if (getValues().size() != 1)
        throw new Error("Access single value, but value count is "+getValues().size());
      return getValues().get(0);
    }

    public String toString() {
      return "#."+wrapped.toString();
    }

    @Override
    public ResourceWrapper getAsResource() {
      throw new Error("Not implemented yet");
    }

    @Override
    public String fhirType() {
      return wrapped.getTypeCode();
    }

    @Override
    public ElementDefinition getElementDefinition() {
      return ed;
    }
  }

  public static class BaseWrapperDirect extends WrapperBaseImpl implements BaseWrapper {
    private Base wrapped;
    private List<PropertyWrapper> list;

    public BaseWrapperDirect(RenderingContext context, Base wrapped) {
      super(context);
      if (wrapped == null)
        throw new Error("wrapped == null");
      this.wrapped = wrapped;
    }

    @Override
    public Base getBase() {
      return wrapped;
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list == null) {
        list = new ArrayList<PropertyWrapper>();
        for (Property p : wrapped.children())
          list.add(new PropertyWrapperDirect(context, p));
      }
      return list;

    }

    @Override
    public PropertyWrapper getChildByName(String name) {
      Property p = wrapped.getChildByName(name);
      if (p == null)
        return null;
      else
        return new PropertyWrapperDirect(context, p);
    }

    @Override
    public String fhirType() {
      return wrapped.fhirType();
    }

  }

  public static class ResourceWrapperDirect extends WrapperBaseImpl implements ResourceWrapper {
    private Resource wrapped;

    public ResourceWrapperDirect(RenderingContext context, Resource wrapped) {
      super(context);
      if (wrapped == null)
        throw new Error("wrapped == null");
      this.wrapped = wrapped;
    }

    @Override
    public List<ResourceWrapper> getContained() {
      List<ResourceWrapper> list = new ArrayList<ResourceWrapper>();
      if (wrapped instanceof DomainResource) {
        DomainResource dr = (DomainResource) wrapped;
        for (Resource c : dr.getContained()) {
          list.add(new ResourceWrapperDirect(context, c));
        }
      }
      return list;
    }

    @Override
    public String getId() {
      return wrapped.getId();
    }

    @Override
    public XhtmlNode getNarrative() {
      if (wrapped instanceof DomainResource) {
        DomainResource dr = (DomainResource) wrapped;
        if (dr.hasText() && dr.getText().hasDiv())
          return dr.getText().getDiv();
      }
      return null;
    }

    @Override
    public String getName() {
      return wrapped.getResourceType().toString();
    }

    @Override
    public String getNameFromResource() {
      Property name = wrapped.getChildByName("name");
      if (name != null && name.hasValues()) {
        Base b = name.getValues().get(0);
        if (b.isPrimitive()) {
          return b.primitiveValue();          
        } else if (b.fhirType().equals("HumanName")) {
          Property family = b.getChildByName("family");
          Property given = wrapped.getChildByName("given");
          String s = given != null && given.hasValues() ? given.getValues().get(0).primitiveValue() : "";
          if (family != null && family.hasValues())
            s = s + " " + family.getValues().get(0).primitiveValue().toUpperCase();
          return s;
        } else {
          // it might be a human name?
          throw new Error("What to do?");
        }
      }
      return null;
    }

    @Override
    public List<PropertyWrapper> children() {
      List<PropertyWrapper> list = new ArrayList<PropertyWrapper>();
      if (wrapped.children() != null) {
        for (Property c : wrapped.children())
          list.add(new PropertyWrapperDirect(context, c));
      }
      return list;
    }

    @Override
    public void describe(XhtmlNode x) throws UnsupportedEncodingException, IOException {
      if (wrapped instanceof CanonicalResource) {
        x.tx(((CanonicalResource) wrapped).present());
      } else if (wrapped instanceof Patient) {
        new PatientRenderer(getContext()).describe(x, (Patient) wrapped);
      } else if (wrapped instanceof Encounter) {
        new EncounterRenderer(getContext()).describe(x, (Encounter) wrapped);
      }
    }

    @Override
    public void injectNarrative(XhtmlNode x, NarrativeStatus status) {
      ResourceRenderer.inject((DomainResource) wrapped, x, status);
      
    }

    @Override
    public BaseWrapper root() {
      return new BaseWrapperDirect(context, wrapped);
    }

    @Override
    public StructureDefinition getDefinition() {
      return context.getWorker().fetchTypeDefinition(wrapped.fhirType());
    }

    @Override
    public Base getBase() {
      return wrapped;
    }

    @Override
    public boolean hasNarrative() {
      StructureDefinition sd = context.getWorker().fetchTypeDefinition(wrapped.fhirType());
      while (sd != null) {
        if ("DomainResource".equals(sd.getType())) {
          return true;
        }
        sd = context.getWorker().fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      }
      return false;

    }

    @Override
    public String fhirType() {
      return wrapped.fhirType();
    }
    
    @Override
    public PropertyWrapper getChildByName(String name) {
      Property p = wrapped.getChildByName(name);
      if (p == null)
        return null;
      else
        return new PropertyWrapperDirect(context, p);
    }

    public Resource getResource() {
      return wrapped;
    }

  }

}