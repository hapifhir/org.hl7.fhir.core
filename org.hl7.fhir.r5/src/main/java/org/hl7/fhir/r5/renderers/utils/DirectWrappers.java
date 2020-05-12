package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Encounter;
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
import org.hl7.fhir.r5.utils.NarrativeGenerator;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class DirectWrappers {

  public static class PropertyWrapperDirect extends RendererWrapperImpl implements PropertyWrapper {
    private Property wrapped;
    private List<BaseWrapper> list;

    public PropertyWrapperDirect(ResourceRenderer renderer, Property wrapped) {
      super(renderer);
      if (wrapped == null)
        throw new Error("wrapped == null");
      this.wrapped = wrapped;
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
          list.add(b == null ? null : new BaseWrapperDirect(renderer, b));
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
  }

  public static class BaseWrapperDirect extends WrapperBaseImpl implements BaseWrapper {
    private Base wrapped;
    private List<PropertyWrapper> list;

    public BaseWrapperDirect(ResourceRenderer renderer, Base wrapped) {
      super(renderer);
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
          list.add(new PropertyWrapperDirect(renderer, p));
      }
      return list;

    }

    @Override
    public PropertyWrapper getChildByName(String name) {
      Property p = wrapped.getChildByName(name);
      if (p == null)
        return null;
      else
        return new PropertyWrapperDirect(renderer, p);
    }

  }

  public static class ResourceWrapperDirect extends WrapperBaseImpl implements ResourceWrapper {
    private Resource wrapped;

    public ResourceWrapperDirect(ResourceRenderer renderer, Resource wrapped) {
      super(renderer);
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
          list.add(new ResourceWrapperDirect(renderer, c));
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
    public List<PropertyWrapper> children() {
      List<PropertyWrapper> list = new ArrayList<PropertyWrapper>();
      if (wrapped.children() != null) {
        for (Property c : wrapped.children())
          list.add(new PropertyWrapperDirect(renderer, c));
      }
      return list;
    }

    @Override
    public void describe(XhtmlNode x) throws UnsupportedEncodingException, IOException {
      if (wrapped instanceof CanonicalResource) {
        x.tx(((CanonicalResource) wrapped).present());
      } else if (wrapped instanceof Patient) {
        new PatientRenderer(getRenderer().getContext()).describe(x, (Patient) wrapped);
      } else if (wrapped instanceof Encounter) {
        new EncounterRenderer(getRenderer().getContext()).describe(x, (Encounter) wrapped);
      }
    }
  }

}