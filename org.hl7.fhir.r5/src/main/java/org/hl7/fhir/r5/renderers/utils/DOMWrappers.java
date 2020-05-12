package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.RendererWrapperImpl;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.WrapperBaseImpl;
import org.hl7.fhir.r5.utils.NarrativeGenerator;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.utilities.xml.XmlGenerator;
import org.w3c.dom.Element;

public class DOMWrappers {


  public static class BaseWrapperElement extends WrapperBaseImpl implements BaseWrapper {
    private Element element;
    private String type;
    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<ElementDefinition> children;
    private List<PropertyWrapper> list;

    public BaseWrapperElement(ResourceRenderer renderer, Element element, String type, StructureDefinition structure, ElementDefinition definition) {
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

      String xml;
      try {
        xml = new XmlGenerator().generate(element);
      } catch (org.hl7.fhir.exceptions.FHIRException e) {
        throw new FHIRException(e.getMessage(), e);
      }
      return renderer.parseType(xml, type);
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list == null) {
        children = renderer.getContext().getProfileUtilities().getChildList(structure, definition);
        list = new ArrayList<PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          XMLUtil.getNamedChildrenWithWildcard(element, tail(child.getPath()), elements);
          list.add(new PropertyWrapperElement(renderer, structure, child, elements));
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

  public static class PropertyWrapperElement extends RendererWrapperImpl implements PropertyWrapper {

    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<Element> values;
    private List<BaseWrapper> list;

    public PropertyWrapperElement(ResourceRenderer renderer, StructureDefinition structure, ElementDefinition definition, List<Element> values) {
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
          list.add(new BaseWrapperElement(renderer, e, determineType(e), structure, definition));
      }
      return list;
    }
    private String determineType(Element e) {
      if (definition.getType().isEmpty())
        return null;
      if (definition.getType().size() == 1) {
        if (definition.getType().get(0).getWorkingCode().equals("Element") || definition.getType().get(0).getWorkingCode().equals("BackboneElement"))
          return null;
        return definition.getType().get(0).getWorkingCode();
      }
      String t = e.getNodeName().substring(tail(definition.getPath()).length()-3);

      if (isPrimitive(Utilities.uncapitalize(t)))
        return Utilities.uncapitalize(t);
      else
        return t;
    }

    private boolean isPrimitive(String code) {
      StructureDefinition sd = renderer.getContext().getWorker().fetchTypeDefinition(code);
      return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
    }

    @Override
    public String getTypeCode() {
      if (definition == null || definition.getType().size() != 1)
        throw new Error("not handled");
      return definition.getType().get(0).getWorkingCode();
    }

    @Override
    public String getDefinition() {
      if (definition == null)
        throw new Error("not handled");
      return definition.getDefinition();
    }

    @Override
    public int getMinCardinality() {
      if (definition == null)
        throw new Error("not handled");
      return definition.getMin();
    }

    @Override
    public int getMaxCardinality() {
      if (definition == null)
        throw new Error("not handled");
      return definition.getMax().equals("*") ? Integer.MAX_VALUE : Integer.parseInt(definition.getMax());
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

  public static class ResourceWrapperElement extends WrapperBaseImpl implements ResourceWrapper {

    private Element wrapped;
    private StructureDefinition definition;
    private List<ResourceWrapper> list;
    private List<PropertyWrapper> list2;

    public ResourceWrapperElement(ResourceRenderer renderer, Element wrapped, StructureDefinition definition) {
      super(renderer);
      this.wrapped = wrapped;
      this.definition = definition;
    }

    @Override
    public List<ResourceWrapper> getContained() {
      if (list == null) {
        List<Element> children = new ArrayList<Element>();
        XMLUtil.getNamedChildren(wrapped, "contained", children);
        list = new ArrayList<ResourceWrapper>();
        for (Element e : children) {
          Element c = XMLUtil.getFirstChild(e);
          list.add(new ResourceWrapperElement(renderer, c, renderer.getContext().getWorker().fetchTypeDefinition(c.getNodeName())));
        }
      }
      return list;
    }

    @Override
    public String getId() {
      return XMLUtil.getNamedChildValue(wrapped, "id");
    }

    @Override
    public XhtmlNode getNarrative() throws FHIRFormatError, IOException, FHIRException {
      Element txt = XMLUtil.getNamedChild(wrapped, "text");
      if (txt == null)
        return null;
      Element div = XMLUtil.getNamedChild(txt, "div");
      if (div == null)
        return null;
      try {
        return new XhtmlParser().parse(new XmlGenerator().generate(div), "div");
      } catch (org.hl7.fhir.exceptions.FHIRFormatError e) {
        throw new FHIRFormatError(e.getMessage(), e);
      } catch (org.hl7.fhir.exceptions.FHIRException e) {
        throw new FHIRException(e.getMessage(), e);
      }
    }

    @Override
    public String getName() {
      return wrapped.getNodeName();
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list2 == null) {
        List<ElementDefinition> children = renderer.getContext().getProfileUtilities().getChildList(definition, definition.getSnapshot().getElement().get(0));
        list2 = new ArrayList<PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          XMLUtil.getNamedChildrenWithWildcard(wrapped, tail(child.getPath()), elements);
          list2.add(new PropertyWrapperElement(renderer, definition, child, elements));
        }
      }
      return list2;
    }



    @Override
    public void describe(XhtmlNode x) {
      throw new Error("Not done yet");      
    }
  }

}