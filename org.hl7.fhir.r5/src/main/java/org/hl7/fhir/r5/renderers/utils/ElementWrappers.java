package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.XmlParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.RendererWrapperImpl;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.WrapperBaseImpl;
import org.hl7.fhir.r5.utils.NarrativeGenerator;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ElementWrappers {

  public static class BaseWrapperMetaElement extends WrapperBaseImpl implements BaseWrapper {
    private Element element;
    private String type;
    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<ElementDefinition> children;
    private List<PropertyWrapper> list;

    public BaseWrapperMetaElement(ResourceRenderer renderer, Element element, String type, StructureDefinition structure, ElementDefinition definition) {
      super(renderer);
      this.element = element;
      this.type = type;
      this.structure = structure;
      this.definition = definition;
    }

    @Override
    public Base getBase() throws UnsupportedEncodingException, IOException, FHIRException {
      if (type == null || type.equals("Resource") || type.equals("BackboneElement") || type.equals("Element"))
        return null;

      if (element.hasElementProperty())
        return null;
      ByteArrayOutputStream xml = new ByteArrayOutputStream();
      try {
        new XmlParser(renderer.getContext().getWorker()).compose(element, xml, OutputStyle.PRETTY, null);
      } catch (Exception e) {
        throw new FHIRException(e.getMessage(), e);
      }
      return renderer.parseType(xml.toString(), type); 
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list == null) {
        children = renderer.getContext().getProfileUtilities().getChildList(structure, definition);
        list = new ArrayList<PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          String name = tail(child.getPath());
          if (name.endsWith("[x]"))
            element.getNamedChildrenWithWildcard(name, elements);
          else
            element.getNamedChildren(name, elements);
          list.add(new PropertyWrapperMetaElement(renderer, structure, child, elements));
        }
      }
      return list;
    }

    @Override
    public PropertyWrapper getChildByName(String name) {
      for (PropertyWrapper p : children())
        if (p.getName().equals(name))
          return p;
      return null;
    }

  }

  public static class ResourceWrapperMetaElement extends WrapperBaseImpl implements ResourceWrapper {
    private Element wrapped;
    private List<ResourceWrapper> list;
    private List<PropertyWrapper> list2;
    private StructureDefinition definition;
    public ResourceWrapperMetaElement(ResourceRenderer renderer, Element wrapped) {
      super(renderer);
      this.wrapped = wrapped;
      this.definition = wrapped.getProperty().getStructure();
    }

    @Override
    public List<ResourceWrapper> getContained() {
      if (list == null) {
        List<Element> children = wrapped.getChildrenByName("contained");
        list = new ArrayList<ResourceWrapper>();
        for (Element e : children) {
          list.add(new ResourceWrapperMetaElement(renderer, e));
        }
      }
      return list;
    }

    @Override
    public String getId() {
      return wrapped.getNamedChildValue("id");
    }

    @Override
    public XhtmlNode getNarrative() throws FHIRFormatError, IOException, FHIRException {
      Element txt = wrapped.getNamedChild("text");
      if (txt == null)
        return null;
      Element div = txt.getNamedChild("div");
      if (div == null)
        return null;
      else
        return div.getXhtml();
    }

    @Override
    public String getName() {
      return wrapped.getName();
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list2 == null) {
        List<ElementDefinition> children = renderer.getContext().getProfileUtilities().getChildList(definition, definition.getSnapshot().getElement().get(0));
        list2 = new ArrayList<PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          if (child.getPath().endsWith("[x]"))
            wrapped.getNamedChildrenWithWildcard(tail(child.getPath()), elements);
          else
            wrapped.getNamedChildren(tail(child.getPath()), elements);
          list2.add(new PropertyWrapperMetaElement(renderer, definition, child, elements));
        }
      }
      return list2;
    }

    @Override
    public void describe(XhtmlNode x) {
      if (wrapped.hasChild("title") && wrapped.getChildValue("title") != null) {
        x.tx(wrapped.getChildValue("title"));
      } else if (wrapped.hasChild("name") && wrapped.getChildValue("name") != null) {
        x.tx(wrapped.getChildValue("name"));       
      } else {
        x.tx("?ngen-1?");
      }
    }
  }

  public static class PropertyWrapperMetaElement extends RendererWrapperImpl implements PropertyWrapper {

    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<Element> values;
    private List<BaseWrapper> list;

    public PropertyWrapperMetaElement(ResourceRenderer renderer, StructureDefinition structure, ElementDefinition definition, List<Element> values) {
      super(renderer);
      this.structure = structure;
      this.definition = definition;
      this.values = values;
    }

    @Override
    public String getName() {
      return tail(definition.getPath());
    }

    @Override
    public boolean hasValues() {
      return values.size() > 0;
    }

    @Override
    public List<BaseWrapper> getValues() {
      if (list == null) {
        list = new ArrayList<BaseWrapper>();
        for (Element e : values)
          list.add(new BaseWrapperMetaElement(renderer, e, e.fhirType(), structure, definition));
      }
      return list;
    }

    @Override
    public String getTypeCode() {
      return definition.typeSummary();
    }

    @Override
    public String getDefinition() {
      return definition.getDefinition();
    }

    @Override
    public int getMinCardinality() {
      return definition.getMin();
    }

    @Override
    public int getMaxCardinality() {
      return "*".equals(definition.getMax()) ? Integer.MAX_VALUE : Integer.valueOf(definition.getMax());
    }

    @Override
    public StructureDefinition getStructure() {
      return structure;
    }

    @Override
    public BaseWrapper value() {
      if (getValues().size() != 1)
        throw new Error("Access single value, but value count is "+getValues().size());
      return getValues().get(0);
    }

  }

}