package org.hl7.fhir.r5.renderers.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.function.BooleanSupplier;

import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.SourcedChildDefinitions;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Narrative;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/** 
 * This class is used to walk through the resources when rendering, whether
 * the resource is a native resource or loaded by the element model
 */
public class ResourceElement {

  public enum ElementKind {
    PrimitiveType,
    DataType,
    BackboneElement,
    ContainedResource,
    InlineResource,
    BundleEntry,
    IndependentResource
  }
  
  public static class NamedResourceElementList {
    private String name;
    private List<ResourceElement> values = new ArrayList<ResourceElement>();
    
    public NamedResourceElementList(String name) {
      super();
      this.name = name;
    }
    
    public String getName() {
      return name;
    }
    public List<ResourceElement> getValues() {
      return values;
    }
    public ElementDefinition getPropertyDefinition() {
      return values.isEmpty() ? null : values.get(0).getPropertyDefinition();
    }
  }

  private ContextUtilities contextUtils;
  private ProfileUtilities profileUtils;
  private ResourceElement parent;
  private String name; // null at root
  private int index; // -1 if not repeating
  private ElementKind kind;
  private StructureDefinition classDefinition;
  private ElementDefinition propertyDefinition;

  private Base element;
  private Element model;

  private List<ResourceElement> children;

  public ResourceElement(ContextUtilities contextUtils, ProfileUtilities profileUtils, Resource resource) {
    this.contextUtils = contextUtils;
    this.profileUtils = profileUtils;
    this.parent = null;
    this.name = null;
    this.index = -1;
    this.kind = ElementKind.IndependentResource;
    this.element = resource;
    this.classDefinition = profileUtils.getContext().fetchTypeDefinition(resource.fhirType());
    this.propertyDefinition = this.classDefinition.getSnapshot().getElementFirstRep();
  }

  public ResourceElement(ContextUtilities contextUtils, ProfileUtilities profileUtils, DataType type) {
    this.contextUtils = parent.contextUtils;
    this.profileUtils = parent.profileUtils;
    this.parent = null;
    this.name = null;
    this.index = -1;
    this.kind = null;
    this.element = type;
    this.classDefinition = profileUtils.getContext().fetchTypeDefinition(type.fhirType());
    this.propertyDefinition = this.classDefinition.getSnapshot().getElementFirstRep();
  }

  public ResourceElement(ResourceElement parent, String name, int index, ElementKind kind, Base element, StructureDefinition classDefinition, ElementDefinition propertyDefinition) {
    this.contextUtils = contextUtils;
    this.profileUtils = profileUtils;
    this.parent = parent;
    this.name = name;
    this.index = index;
    this.kind = kind;
    this.element = element;
    this.classDefinition = classDefinition;
    this.propertyDefinition = propertyDefinition;
  }

  public ResourceElement(ContextUtilities contextUtils, ProfileUtilities profileUtils, Element resource) {
    this.contextUtils = contextUtils;
    this.profileUtils = profileUtils;
    this.parent = null;
    this.name = null;
    this.index = -1;
    this.kind = ElementKind.IndependentResource;
    this.model = resource;
  }
  
  public ResourceElement(ResourceElement parent, String name, int index, ElementKind kind, Element em) {
    this.contextUtils = parent.contextUtils;
    this.profileUtils = parent.profileUtils;
    this.parent = parent;
    this.name = name;
    this.index = index;
    this.kind = kind;
    this.model = em;
    this.classDefinition = em.getProperty().getStructure();
    this.propertyDefinition = em.getProperty().getDefinition();
  }

  public String fhirVersion() {
    if (element != null) {
      return element.getFHIRPublicationVersion().toCode();
    } else {
      return model.getFHIRPublicationVersion().toCode();
    }
  }
  public String path() {
    if (parent == null) {
      return fhirType();
    } else {
      return parent.path()+"." + (index == -1 ? name : name+"["+index+"]");
    }
  }

  public ElementKind kind() {
    return kind;
  }

  public String name() {
    return name;
  }

  public int index() {
    return index;
  }

  public String fhirType() {
    if (kind == ElementKind.BackboneElement) {
      return basePath();
    } else  if (element != null) {
      return element.fhirType();
    } else {
      return model.fhirType();
    }
  }

  private String basePath() {
    if (parent == null || this.isResource()) {
      return this.fhirType();
    } else {
      return parent.basePath()+"."+name;
    }
  }

  public boolean isPrimitive() {
    if (element != null) {
      return element.isPrimitive();
    } else {
      return model.isPrimitive();
    }
  }

  public boolean hasPrimitiveValue() {
    if (element != null) {
      return element.hasPrimitiveValue();
    } else {
      return model.hasPrimitiveValue();        
    }
  }

  public String primitiveValue() {
    if (element != null) {
      return element.primitiveValue();
    } else {
      return model.primitiveValue();
    }
  }

  public boolean isPrimitive(String name) {
    ResourceElement child = child(name);
    return child != null && child.isPrimitive();
  }

  public boolean hasPrimitiveValue(String name) {
    ResourceElement child = child(name);
    return child != null && child.hasPrimitiveValue();
  }

  public String primitiveValue(String name) {
    ResourceElement child = child(name);
    return child == null ? null : child.primitiveValue();
  }

  public String primitiveValueMN(String... names) {
    ResourceElement child = childMN(names);
    return child == null ? null : child.primitiveValue();
  }

  public String firstPrimitiveValue(String name) {
    ResourceElement child = firstChild(name);
    return child == null ? null : child.primitiveValue();
  }

  private void loadChildren() {
    if (children == null) {
      children = new ArrayList<>();
      if (element != null) {
        loadElementChildren();
      } else {
        loadModelChildren();
      }
    }
  }

  private void loadModelChildren() {
    for (Element child : model.getChildren()) {
      String name = child.getProperty().isChoice() ? child.getProperty().getName() : child.getName();
      int index = child.isList() ? child.getIndex() : -1;
      ElementKind kind = determineModelKind(child);
      children.add(new ResourceElement(this, name, index, kind, child));
    }
  }

  private ElementKind determineModelKind(Element child) {
    if (child.isPrimitive()) {
      return ElementKind.PrimitiveType;
    } else if (child.fhirType().contains("Backbone")) {
      return ElementKind.BackboneElement;
    } else if (child.getProperty().getContextUtils().isDatatype(child.fhirType())) {
      return ElementKind.DataType;
    } else if (!child.isResource()) {
      return ElementKind.BackboneElement;
    } else if (parent == null) {
      return ElementKind.IndependentResource;
    } else switch (child.getSpecial()) {
    case BUNDLE_ENTRY:
      return ElementKind.BundleEntry;
    case BUNDLE_ISSUES:
      return ElementKind.InlineResource;
    case BUNDLE_OUTCOME:
      return ElementKind.InlineResource;
    case CONTAINED:
      return ElementKind.ContainedResource;
    case PARAMETER:
      return ElementKind.InlineResource;
    default:
      return ElementKind.IndependentResource;
    }
  }

  private void loadElementChildren() {
    SourcedChildDefinitions childDefs = propertyDefinition == null ? null : profileUtils.getChildMap(classDefinition, propertyDefinition);
    for (Property p : element.children()) {
      String name = p.getName();
      int i = 0;
      for (Base v : p.getValues()) {
        ElementKind kind = determineModelKind(p, v);      
        int index = p.isList() ? i : -1;
        ElementDefinition ed = null;
        if (childDefs != null) {
          for (ElementDefinition t : childDefs.getList()) {
            if (t.getName().equals(name)) {
              ed = t;
              break;
            }
          }
        }
        if (ed != null) {
          children.add(new ResourceElement(this, name, index, kind, v, childDefs.getSource(), ed));
        } else {
          StructureDefinition sd = profileUtils.getContext().fetchTypeDefinition(v.fhirType());
          ElementDefinition ted = sd.getSnapshot().getElementFirstRep();
          children.add(new ResourceElement(this, name, index, kind, v, sd, ted));          
        }
        i++;
      }
    }
  }

  private ElementKind determineModelKind(Property p, Base v) {
    if (v.isPrimitive()) {
      return ElementKind.PrimitiveType;
    } else if (contextUtils.isDatatype(v.fhirType())) {
      return ElementKind.DataType;
    } else if (!v.isResource()) {
      return ElementKind.BackboneElement;
    } else if (parent == null) {
      return ElementKind.IndependentResource;
    } else if ("Bundle.entry".equals(fhirType()) && "resource".equals(p.getName())) {
      return ElementKind.BundleEntry;
    } else if ("Bundle".equals(fhirType()) && "outcome".equals(p.getName())) {
      return ElementKind.InlineResource;
    } else if ("Bundle".equals(fhirType()) && "issues".equals(p.getName())) {
      return ElementKind.InlineResource;
    } else if (isResource() && "contained".equals(p.getName())) {
      return ElementKind.ContainedResource;
    } else {
      return ElementKind.InlineResource;
    }
  }

  public List<ResourceElement> children() {
    loadChildren();
    return children;
  }

  public List<NamedResourceElementList> childrenInGroups() {
    loadChildren();
    List<NamedResourceElementList> list = new ArrayList<ResourceElement.NamedResourceElementList>(); 
    for (ResourceElement e : children) {
      NamedResourceElementList nl = null;
      for (NamedResourceElementList t : list) {
        if (t.name.equals(e.name())) {
          nl = t;
        }
      }
      if (nl == null) {
        nl = new NamedResourceElementList(e.name());
        list.add(nl);
      }
      nl.values.add(e);
    }
    return list;
  }

  public List<ResourceElement> children(String name) {
    loadChildren();
    List<ResourceElement> list = new ArrayList<ResourceElement>();
    for (ResourceElement e : children) {
      if (name.equals(e.name())) {
        list.add(e);
      }
    }
    return list;
  }

  /**
   * For when an item has been renamed - find by any of the names
   * @param name
   * @return
   */
  public List<ResourceElement> childrenMN(String... names) {
    loadChildren();
    List<ResourceElement> list = new ArrayList<ResourceElement>();
    for (ResourceElement e : children) {
      for (String name : names) {
        if (name.equals(e.name())) {
          list.add(e);
        }
      }
    }
    return list;
  }

  public ResourceElement child(String name) {
    loadChildren();
    
    ResourceElement res = null;

    for (ResourceElement e : children) {
      if (name.equals(e.name()) || (name+"[x]").equals(e.name())) {
        if (res == null) {
          res = e;
        } else {
          throw new Error("Duplicated element '"+name+"' @ '"+path()+"'");
        }
      }
    }
    return res;
  }

  /** 
   * For when an item has been renamed - find by any of the names
   * @param names
   * @return
   */
  public ResourceElement childMN(String... names) {
    loadChildren();

    ResourceElement res = null;

    for (ResourceElement e : children) {
      for (String name : names) {
        if (name.equals(e.name()) || (name+"[x]").equals(e.name())) {
          if (res == null) {
            res = e;
          } else {
            throw new Error("Duplicated element '"+name+"' @ '"+path()+"'");
          }
        }
      }
    }
    return res;
  }

  public boolean has(String name) {
    for (ResourceElement e : children) {
      if (name.equals(e.name())) {
        return true;
      }
    }
    return false;
  }

  public ResourceElement resource() {
    ResourceElement e = this.parent;
    while (e != null && !e.isResource()) {
      e = e.parent;
    }
    return e;
  }

  public boolean isResource() {
    if (element != null) {
      return element.isResource();
    } else {
      return model.isResource();
    }
  }

  public boolean hasChildren() {
    loadChildren();
    return !children.isEmpty();
  }

  public boolean hasExtension(String url) {
    loadChildren();
    for (ResourceElement e : children) {
      if ("Extension".equals(e.fhirType()) && url.equals(e.primitiveValue("url"))) {
        return true;
      }
    }
    return false;
  }
  
  public ResourceElement extension(String url) {
    ResourceElement res = null;
    loadChildren();
    for (ResourceElement e : children) {
      if ("Extension".equals(e.fhirType()) && url.equals(e.primitiveValue("url"))) {
        if (res == null) {
          res = e;
        } else {
          throw new Error("Duplicated extension '"+url+"' @ '"+path()+"'");
        }
      }
    }
    return res;
  }
    
  public ResourceElement extensionValue(String url) {
    ResourceElement res = null;
    loadChildren();
    for (ResourceElement e : children) {
      if ("Extension".equals(e.fhirType()) && url.equals(e.primitiveValue("url"))) {
        if (res == null) {
          res = e.child("value");
        } else {
          throw new Error("Duplicated extension '"+url+"' @ '"+path()+"'");
        }
      }
    }
    return res;
  }
  
  public List<ResourceElement> extensions(String url) {
    List<ResourceElement> res = new ArrayList<ResourceElement>();
    loadChildren();
    for (ResourceElement e : children) {
      if ("Extension".equals(e.fhirType()) && url.equals(e.primitiveValue("url"))) {
        res.add(e);
      }
    }
    return res;
  }
  
  public List<ResourceElement> extensions() {
    List<ResourceElement> res = new ArrayList<ResourceElement>();
    loadChildren();
    for (ResourceElement e : children) {
      if ("Extension".equals(e.fhirType())) {
        res.add(e);
      }
    }
    return res;
  }
  
  public List<ResourceElement> extensionValues(String url) {
    List<ResourceElement> res = new ArrayList<ResourceElement>();
    loadChildren();
    for (ResourceElement e : children) {
      if ("Extension".equals(e.fhirType()) && url.equals(e.primitiveValue("url"))) {
        if (e.has("value")) {
          res.add(e.child("value"));
        }
      }
    }
    return res;
  }

  public boolean canHaveNarrative() {
    if (!isResource()) {
      return false;
    }
    if (element != null) {
      return element instanceof DomainResource;
    } else {
      return contextUtils.isDomainResource(fhirType()); 
    }
  }
  
  public XhtmlNode getNarrative() {
    if (!canHaveNarrative()) {
      return null;
    }
    ResourceElement text = child("text");
    if (text == null) {
      return null;
    }
    ResourceElement div = text.child("div");
    if (div == null) {
      return null;
    }
    if (div.element != null) {
      return div.element.getXhtml();
    } else {
      return div.model.getXhtml(); 
    }
  }
  
  public boolean hasNarrative() {
    if (!canHaveNarrative()) {
      return false;
    }
    ResourceElement text = child("text");
    if (text == null) {
      return false;
    }
    ResourceElement div = text.child("div");
    if (div == null) {
      return false;
    }
    if (div.element != null) {
      return div.element.getXhtml() != null;
    } else {
      return div.model.getXhtml() != null; 
    }
  }
  
  public void setNarrative(XhtmlNode x, String status, boolean multiLangMode, Locale locale) {
    if (element != null) {
      if (element instanceof DomainResource) {
        DomainResource r = (DomainResource) element;    
        r.getText().setUserData("renderer.generated", true);
        if (!r.hasText() || !r.getText().hasDiv()) {
          r.setText(new Narrative());
          r.getText().setStatusAsString(status);      
        }
        if (multiLangMode) {
          if (!r.getText().hasDiv()) { 
            XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
            div.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
            r.getText().setDiv(div);
          } else {
            r.getText().getDiv().getChildNodes().removeIf(c -> !"div".equals(c.getName()) || !c.hasAttribute("xml:lang"));
          }
          markLanguage(x, locale);
          r.getText().getDiv().getChildNodes().add(x);
        } else {
          if (!x.hasAttribute("xmlns"))
            x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
          if (r.hasLanguage()) {
            // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
            x.setAttribute("lang", r.getLanguage());
            x.setAttribute("xml:lang", r.getLanguage());
          }
          r.getText().setDiv(x);
        }
      } else {
        throw new Error("Cannot call setNarrative on a "+element.fhirType());
      }
    }
  }

  public void markLanguage(XhtmlNode x, Locale locale) {
    x.setAttribute("lang", locale.toString());
    x.setAttribute("xml:lang", locale.toString());
    x.addTag(0, "hr");
    x.addTag(0, "p").b().tx(locale.getDisplayName());
    x.addTag(0, "hr");
  }
  

  public String getId() {
    if (element != null) {
      return element.getIdBase();
    } else {
      return model.getIdBase(); 
    }
  }
  
  @Override
  public String toString() {
    return name + (index == -1 ? "" : "["+index+"]")+": "+fhirType()+" ("+kind+")";
  }

  public boolean matches(ResourceElement b) {
  }

  public String extensionString(String url) {
    ResourceElement re = extensionValue(url);
    return re == null ?  null : re.primitiveValue();
  }

  public boolean isEmpty() {
    if (hasChildren()) {
      for (ResourceElement c : children) {
        if (!c.isEmpty()) {
          return false;
        }
      }
    }
    return !isPrimitive() || !hasPrimitiveValue();
  }

  public Resource getResource() {
    return element == null ? null : (Resource) element;
  }

  public ResourceElement firstChild(String name) {
    List<ResourceElement> list = children(name);
    return list.size() == 0 ? null : list.get(0);
  }

  public ContextUtilities getContextUtilities() {
    return contextUtils;
  }

  public boolean hasFormatComment() {
    if (element != null) {
      return element.hasFormatComment();
    } else {
      return model.hasFormatComment();
    }
  }

  public Collection<String> getFormatCommentsPre() {
    if (element != null) {
      return element.getFormatCommentsPre();
    } else {
      return model.getFormatCommentsPre();
    }
  }

  public StructureDefinition getClassDefinition() {
    return classDefinition;
  }

  public ElementDefinition getPropertyDefinition() {
    return propertyDefinition;
  }

  public List<XhtmlNode> getXhtml() {
  }

  public Base getBase() {
  }

  
}