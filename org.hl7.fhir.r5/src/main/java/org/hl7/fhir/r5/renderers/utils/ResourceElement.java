package org.hl7.fhir.r5.renderers.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;

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

  private ContextUtilities context;
  private ResourceElement parent;
  private String name; // null at root
  private int index; // -1 if not repeating
  private ElementKind kind;

  private Base element;
  private Element model;

  private List<ResourceElement> children;

  public ResourceElement(ContextUtilities context, Resource resource) {
    this.context = context;
    this.parent = null;
    this.name = null;
    this.index = -1;
    this.kind = ElementKind.IndependentResource;
    this.element = resource;
  }

  public ResourceElement(ContextUtilities context, ResourceElement parent, String name, int index, ElementKind kind, Base element) {
    this.context = context;
    this.parent = parent;
    this.name = name;
    this.index = index;
    this.kind = kind;
    this.element = element;
  }

  public ResourceElement(ContextUtilities context, Element resource) {
    this.context = context;
    this.parent = null;
    this.name = null;
    this.index = -1;
    this.kind = ElementKind.IndependentResource;
    this.model = resource;
  }
  
  public ResourceElement(ContextUtilities context, ResourceElement parent, String name, int index, ElementKind kind, Element em) {
    this.context = context;
    this.parent = parent;
    this.name = name;
    this.index = index;
    this.kind = kind;
    this.model = em;
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
      children.add(new ResourceElement(context, this, name, index, kind, child));
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
    for (Property p : element.children()) {
      String name = p.getName();
      int i = 0;
      for (Base v : p.getValues()) {
        ElementKind kind = determineModelKind(p, v);      
        int index = p.isList() ? i : -1;
        children.add(new ResourceElement(context, this, name, index, kind, v));
        i++;
      }
    }
  }

  private ElementKind determineModelKind(Property p, Base v) {
    if (v.isPrimitive()) {
      return ElementKind.PrimitiveType;
    } else if (context.isDatatype(v.fhirType())) {
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


}