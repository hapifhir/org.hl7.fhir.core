package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.ProfileUtilities.ElementDefinitionResolution;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.XmlParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.RendererWrapperImpl;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.WrapperBaseImpl;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ElementWrappers {

  public static class BaseWrapperMetaElement extends WrapperBaseImpl implements BaseWrapper {
    private Element element;
    private String type;
    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<ElementDefinition> children;
    private List<PropertyWrapper> list;

    public BaseWrapperMetaElement(RenderingContext context, Element element, String type, StructureDefinition structure, ElementDefinition definition) {
      super(context);
      this.element = element;
      this.type = type;
      this.structure = structure;
      this.definition = definition;
    }

    @Override
    public Base getBase() throws UnsupportedEncodingException, IOException, FHIRException {
      if (type == null || type.equals("Resource") || type.equals("BackboneElement") || type.equals("Element"))
        return null;

      if (element.hasElementProperty()) {
        return element;
      }
      ByteArrayOutputStream xml = new ByteArrayOutputStream();
      try {
        new XmlParser(context.getWorker()).compose(element, xml, OutputStyle.PRETTY, null);
      } catch (Exception e) {
        throw new FHIRException(e.getMessage(), e);
      }
      if (context.getParser() == null) {
        System.out.println("No version specific parser provided");
      } 
      if (context.getParser() == null) {
        throw new Error("No type parser provided to renderer context");
      } else {
        try {
          return context.getParser().parseType(xml.toString(StandardCharsets.UTF_8), type);
        } catch (Exception e) {
          return new StringType("Illegal syntax: "+e.getMessage()); 
        }
      }
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list == null) {
        children = context.getProfileUtilities().getChildList(structure, definition, false, true);
        if (children.isEmpty() && !Utilities.noString(type)) {
          StructureDefinition sd = context.getWorker().fetchTypeDefinition(type);
          children = context.getProfileUtilities().getChildList(sd, sd.getSnapshot().getElementFirstRep());
        }
        list = new ArrayList<PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          String name = tail(child.getPath());
          if (name.endsWith("[x]"))
            element.getNamedChildrenWithWildcard(name, elements);
          else
            element.getNamedChildren(name, elements);
          list.add(new PropertyWrapperMetaElement(context, structure, child, elements));
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

    @Override
    public String fhirType() {
      return element.fhirType();
    }

  }

  public static class ResourceWrapperMetaElement extends WrapperBaseImpl implements ResourceWrapper {
    private Element wrapped;
    private List<ResourceWrapper> list;
    private List<PropertyWrapper> list2;
    private StructureDefinition definition;
    public ResourceWrapperMetaElement(RenderingContext context, Element wrapped) {
      super(context);
      this.wrapped = wrapped;
      this.definition = wrapped.getProperty().getStructure();
    }

    @Override
    public List<ResourceWrapper> getContained() {
      if (list == null) {
        List<Element> children = wrapped.getChildrenByName("contained");
        list = new ArrayList<ResourceWrapper>();
        for (Element e : children) {
          list.add(new ResourceWrapperMetaElement(context, e));
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
          // well, we couldn't get a name from that
          return null;
        }
      }
      return null;
    }
    
    @Override
    public List<PropertyWrapper> children() {
      if (list2 == null) {
        List<ElementDefinition> children = context.getProfileUtilities().getChildList(definition, definition.getSnapshot().getElement().get(0));
        list2 = new ArrayList<PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          if (child.getPath().endsWith("[x]"))
            wrapped.getNamedChildrenWithWildcard(tail(child.getPath()), elements);
          else
            wrapped.getNamedChildren(tail(child.getPath()), elements);
          list2.add(new PropertyWrapperMetaElement(context, definition, child, elements));
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

    @Override
    public void injectNarrative(XhtmlNode x, NarrativeStatus status) throws IOException {
      if (!x.hasAttribute("xmlns"))
        x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
      String l = wrapped.getChildValue("language");
      if (!Utilities.noString(l)) {
        // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
        x.setAttribute("lang", l);
        x.setAttribute("xml:lang", l);
      }
      org.hl7.fhir.r5.elementmodel.Element txt = wrapped.getNamedChild("text");
      if (txt == null) {
        txt = new org.hl7.fhir.r5.elementmodel.Element("text", wrapped.getProperty().getChild(null, "text"));
        int i = 0;
        while (i < wrapped.getChildren().size() && (wrapped.getChildren().get(i).getName().equals("id") || wrapped.getChildren().get(i).getName().equals("meta") || wrapped.getChildren().get(i).getName().equals("implicitRules") || wrapped.getChildren().get(i).getName().equals("language")))
          i++;
        if (i >= wrapped.getChildren().size())
          wrapped.getChildren().add(txt);
        else
          wrapped.getChildren().add(i, txt);
      }
      org.hl7.fhir.r5.elementmodel.Element st = txt.getNamedChild("status");
      if (st == null) {
        st = new org.hl7.fhir.r5.elementmodel.Element("status", txt.getProperty().getChild(null, "status"));
        txt.getChildren().add(0, st);
      }
      st.setValue(status.toCode());
      org.hl7.fhir.r5.elementmodel.Element div = txt.getNamedChild("div");
      if (div == null) {
        div = new org.hl7.fhir.r5.elementmodel.Element("div", txt.getProperty().getChild(null, "div"));
        txt.getChildren().add(div);
        div.setValue(new XhtmlComposer(XhtmlComposer.XML, context.isPretty()).compose(x));
      }
      div.setValue(x.toString());
      div.setXhtml(x);

    }

    @Override
    public BaseWrapper root() {
      return new BaseWrapperMetaElement(context, wrapped, getName(), definition, definition.getSnapshot().getElementFirstRep());
    }

    @Override
    public StructureDefinition getDefinition() {
      return definition;
    }

    @Override
    public Base getBase() {
      return wrapped;
    }

    @Override
    public boolean hasNarrative() {
      StructureDefinition sd = definition;
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
      for (PropertyWrapper p : children())
        if (p.getName().equals(name))
          return p;
      return null;
    }

    public Element getElement() {
      return wrapped;
    }

}

  public static class PropertyWrapperMetaElement extends RendererWrapperImpl implements PropertyWrapper {

    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<Element> values;
    private List<BaseWrapper> list;

    public PropertyWrapperMetaElement(RenderingContext context, StructureDefinition structure, ElementDefinition definition, List<Element> values) {
      super(context);
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
        for (Element e : values) {
           list.add(new BaseWrapperMetaElement(context, e, e.fhirType(), structure, definition));
        }
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

    @Override
    public ResourceWrapper getAsResource() {
      return new ElementWrappers.ResourceWrapperMetaElement(context, values.get(0));
    }

    @Override
    public String fhirType() {
      return getTypeCode();
    }

    @Override
    public ElementDefinition getElementDefinition() {
      return definition;
    }

  }

}