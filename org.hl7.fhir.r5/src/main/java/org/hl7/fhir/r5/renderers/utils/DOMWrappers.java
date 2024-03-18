package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.RendererWrapperImpl;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.WrapperBaseImpl;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.utilities.xml.XmlGenerator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMWrappers {


  public static class BaseWrapperElement extends WrapperBaseImpl implements BaseWrapper {
    private Element element;
    private String type;
    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<ElementDefinition> children;
    private List<PropertyWrapper> list;

    public BaseWrapperElement(RenderingContext context, Element element, String type, StructureDefinition structure, ElementDefinition definition) {
      super(context);
      this.element = element;
      this.type = type;
      this.structure = structure;
      this.definition = definition;
    }

    @Override
    public Base getBase() throws UnsupportedEncodingException, IOException, FHIRException {
      if (Utilities.noString(type) || type.equals("Resource") || type.equals("BackboneElement") || type.equals("Element"))
        return null;

      String xml;
      try {
        xml = new XmlGenerator().generate(element);
      } catch (org.hl7.fhir.exceptions.FHIRException e) {
        throw new FHIRException(e.getMessage(), e);
      }
      Node n = element.getPreviousSibling();
      Base ret = context.getParser().parseType(xml, type);
      while (n != null && (n.getNodeType() == Node.COMMENT_NODE || n.getNodeType() == Node.TEXT_NODE)) {
        if (n.getNodeType() == Node.COMMENT_NODE) {
          ret.getFormatCommentsPre().add(0, n.getTextContent());
        }
        n = n.getPreviousSibling();
      }
      return ret;
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list == null) {
        children = context.getProfileUtilities().getChildList(structure, definition);
        if (children.isEmpty() && type != null) {
          StructureDefinition sdt = context.getWorker().fetchTypeDefinition(type);
          children = context.getProfileUtilities().getChildList(sdt, sdt.getSnapshot().getElementFirstRep());          
        }
        list = new ArrayList<PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          XMLUtil.getNamedChildrenWithWildcard(element, tail(child.getPath()), elements);
          list.add(new PropertyWrapperElement(context, structure, child, elements));
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
      return type;
    }

    @Override
    public ResourceWrapper getResource() throws UnsupportedEncodingException, IOException, FHIRException {
      Element r = XMLUtil.getFirstChild(element);
      StructureDefinition sd = getContext().getContext().fetchTypeDefinition(r.getLocalName());
      if (sd == null) {
        throw new FHIRException("Unable to find definition for type "+type+" @ "+definition.getPath());
      }
      if (sd.getKind() != StructureDefinitionKind.RESOURCE) {
        throw new FHIRException("Definition for type "+type+" is not for a resource @ "+definition.getPath());
      }
      return new ResourceWrapperElement(context, r, sd);
    }

  }

  public static class PropertyWrapperElement extends RendererWrapperImpl implements PropertyWrapper {

    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<Element> values;
    private List<BaseWrapper> list;

    public PropertyWrapperElement(RenderingContext context, StructureDefinition structure, ElementDefinition definition, List<Element> values) {
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
        for (Element e : values)
          list.add(new BaseWrapperElement(context, e, determineType(e), structure, definition));
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
      StructureDefinition sd = context.getWorker().fetchTypeDefinition(code);
      return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
    }

    @Override
    public String getTypeCode() {
      if (definition == null || definition.getType().size() != 1) {
        if (values.size() != 1) {
          throw new Error("not handled");
        }
        String tn = values.get(0).getLocalName().substring(tail(definition.getPath()).replace("[x]", "").length());
        if (isPrimitive(Utilities.uncapitalize(tn))) {
          return Utilities.uncapitalize(tn);
        } else {
          return tn;
        }
      }
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

    @Override
    public ResourceWrapper getAsResource() {
     throw new Error("Not implemented yet");
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

  public static class ResourceWrapperElement extends WrapperBaseImpl implements ResourceWrapper {

    private Element wrapped;
    private StructureDefinition definition;
    private List<ResourceWrapper> list;
    private List<PropertyWrapper> list2;

    public ResourceWrapperElement(RenderingContext context, Element wrapped, StructureDefinition definition) {
      super(context);
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
          list.add(new ResourceWrapperElement(context, c, context.getWorker().fetchTypeDefinition(c.getNodeName())));
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
    public String getNameFromResource() {
      Element e = XMLUtil.getNamedChild(wrapped, "name");
      if (e != null) {
        if (e.hasAttribute("value")) {
          return e.getAttribute("value");
        }
        if (XMLUtil.hasNamedChild(e, "text")) {
          return XMLUtil.getNamedChildValue(e, "text");
        }
        if (XMLUtil.hasNamedChild(e, "family") || XMLUtil.hasNamedChild(e, "given")) {
          Element family = XMLUtil.getNamedChild(e, "family");
          Element given = XMLUtil.getNamedChild(e, "given");
          String s = given != null && given.hasAttribute("value") ? given.getAttribute("value") : "";
          if (family != null && family.hasAttribute("value"))
            s = s + " " + family.getAttribute("value").toUpperCase();
          return s;
        }
        return null;
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
          XMLUtil.getNamedChildrenWithWildcard(wrapped, tail(child.getPath()), elements);
          list2.add(new PropertyWrapperElement(context, definition, child, elements));
        }
      }
      return list2;
    }



    @Override
    public void describe(XhtmlNode x) {
      throw new Error("Not done yet");      
    }

    @Override
    public void injectNarrative(XhtmlNode x, NarrativeStatus status) {
      if (!x.hasAttribute("xmlns"))
        x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
      Element le = XMLUtil.getNamedChild(wrapped, "language");
      String l = le == null ? null : le.getAttribute("value");
      if (!Utilities.noString(l)) {
        // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
        x.setAttribute("lang", l);
        x.setAttribute("xml:lang", l);
      }
      Element txt = XMLUtil.getNamedChild(wrapped, "text");
      if (txt == null) {
        txt = wrapped.getOwnerDocument().createElementNS(FormatUtilities.FHIR_NS, "text");
        Element n = XMLUtil.getFirstChild(wrapped);
        while (n != null && (n.getNodeName().equals("id") || n.getNodeName().equals("meta") || n.getNodeName().equals("implicitRules") || n.getNodeName().equals("language")))
          n = XMLUtil.getNextSibling(n);
        if (n == null)
          wrapped.appendChild(txt);
        else
          wrapped.insertBefore(txt, n);
      }
      Element st = XMLUtil.getNamedChild(txt, "status");
      if (st == null) {
        st = wrapped.getOwnerDocument().createElementNS(FormatUtilities.FHIR_NS, "status");
        Element n = XMLUtil.getFirstChild(txt);
        if (n == null)
          txt.appendChild(st);
        else
          txt.insertBefore(st, n);
      }
      st.setAttribute("value", status.toCode());
      Element div = XMLUtil.getNamedChild(txt, "div");
      if (div == null) {
        div = wrapped.getOwnerDocument().createElementNS(FormatUtilities.XHTML_NS, "div");
        div.setAttribute("xmlns", FormatUtilities.XHTML_NS);
        txt.appendChild(div);
      }
      if (div.hasChildNodes())
        div.appendChild(wrapped.getOwnerDocument().createElementNS(FormatUtilities.XHTML_NS, "hr"));
      new XhtmlComposer(XhtmlComposer.XML, context.isPretty()).compose(div, x);
    }

    @Override
    public BaseWrapper root() {
      return new BaseWrapperElement(context, wrapped, getName(), definition, definition.getSnapshot().getElementFirstRep());
    }

    @Override
    public StructureDefinition getDefinition() {
      return definition;
    }

    @Override
    public Base getBase() {
      throw new Error("Not Implemented yet");
    }

    @Override
    public boolean hasNarrative() {
      StructureDefinition sd = definition;
      while (sd != null) {
        if ("DomainResource".equals(sd.getType())) {
          return true;
        }
        sd = context.getWorker().fetchResource(StructureDefinition.class, sd.getBaseDefinition(), sd);
      }
      return false;
    }

    @Override
    public String fhirType() {
      return wrapped.getNodeName();
    }
    
    @Override
    public PropertyWrapper getChildByName(String name) {
      for (PropertyWrapper p : children())
        if (p.getName().equals(name))
          return p;
      return null;
    }

    @Override
    public Resource getResource() {
      return null;
    }


  }

}