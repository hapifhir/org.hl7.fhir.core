package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/** 
 * This class is used to walk through the resources when rendering, whether
 * the resource is a native resource or loaded by the element model
 */
@MarkedToMoveToAdjunctPackage
public abstract class ResourceWrapper {

  public enum ElementKind {
    PrimitiveType,
    DataType,
    BackboneElement,
    ContainedResource,
    InlineResource,
    BundleEntry,
    IndependentResource
  }
  
  public static class NamedResourceWrapperList {
    private String name;
    private String url; // for extension definitions
    private List<ResourceWrapper> values = new ArrayList<ResourceWrapper>();

    public NamedResourceWrapperList(String name) {
      super();
      this.name = name;
    }

    public NamedResourceWrapperList(String name, String url) {
      super();
      this.name = name;
      this.url = url;
    }
    
    public String getName() {
      return name;
    }
    
    public String getUrl() {
      return url;
    }

    public List<ResourceWrapper> getValues() {
      return values;
    }
//    public ElementDefinition getPropertyDefinition() {
//      return values.isEmpty() ? null : values.get(0).getPropertyDefinition();
//    }
//    public StructureDefinition getClassDefinition() {
//      return values.isEmpty() ? null : values.get(0).getClassDefinition();
//    }
  }

  protected ContextUtilities contextUtils;
  protected ResourceWrapper parent;
  protected String name; // null at root
  protected int index; // -1 if not repeating
  protected ElementKind kind;

  protected List<ResourceWrapper> children;

  // -- Constructors ------------------------------------------------------------------
  
  protected ResourceWrapper() {
    // TODO Auto-generated constructor stub
  }

  public static ResourceWrapper forResource(ContextUtilities contextUtils, Resource resource) {
    ResourceWrapperNative self = new ResourceWrapperNative();
    self.contextUtils = contextUtils;
    self.parent = null;
    self.name = null;
    self.index = -1;
    self.kind = ElementKind.IndependentResource;
    self.element = resource;
    return self;
  }

  public static ResourceWrapper forResource(ContextUtilities contextUtils, Element resource) {
    ResourceWrapperModel self = new ResourceWrapperModel();
    self.contextUtils = contextUtils;
    self.parent = null;
    self.name = null;
    self.index = -1;
    self.kind = ElementKind.IndependentResource;
    self.model = resource;
    return self;
  }

  public static ResourceWrapper forResource(RenderingContext context, Resource resource) {
    return forResource(context.getContextUtilities(), resource);
  }
  
  public static ResourceWrapper forResource(RenderingContext context, Element resource) {
    return forResource(context.getContextUtilities(), resource);
  }
  
  public static ResourceWrapper forType(ContextUtilities contextUtils, Element resource) {
    ResourceWrapperModel self = new ResourceWrapperModel();
    self.contextUtils = contextUtils;
    self.parent = null;
    self.name = null;
    self.index = -1;
    self.kind = ElementKind.DataType;
    self.model = resource;
    return self;
  }

  public static ResourceWrapper forType(ContextUtilities contextUtils, DataType type) {
    ResourceWrapperNative self = new ResourceWrapperNative();
    self.contextUtils = contextUtils;
    self.parent = null;
    self.name = null;
    self.index = -1;
    self.kind = null;
    self.element = type;
    return self;
  }
  
  public static ResourceWrapper forType(ContextUtilities contextUtils, ResourceWrapper parent, DataType type) {
    ResourceWrapperNative self = new ResourceWrapperNative();
    self.contextUtils = contextUtils;
    self.parent = parent;
    self.name = null;
    self.index = -1;
    self.kind = null;
    self.element = type;
    return self;
  }

  
  public String path() {
    if (parent == null) {
      return fhirType();
    } else {
      return parent.path()+"." + (index == -1 ? name : name+"["+index+"]");
    }
  }

  protected String basePath() {
    if (parent == null || this.isResource()) {
      return this.fhirType();
    } else {
      return parent.basePath()+"."+name;
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

  public boolean isPrimitive(String name) {
    ResourceWrapper child = child(name);
    return child != null && child.isPrimitive();
  }

  public boolean hasPrimitiveValue(String name) {
    ResourceWrapper child = child(name);
    return child != null && child.hasPrimitiveValue();
  }

  public String primitiveValue(String name) {
    ResourceWrapper child = child(name);
    return child == null ? null : child.primitiveValue();
  }

  public String primitiveValueMN(String... names) {
    ResourceWrapper child = childMN(names);
    return child == null ? null : child.primitiveValue();
  }

  public String firstPrimitiveValue(String name) {
    ResourceWrapper child = firstChild(name);
    return child == null ? null : child.primitiveValue();
  }

  private void loadChildren() {
    if (children == null) {
      children = new ArrayList<>();
      loadTheChildren();
    }
  }


  public List<ResourceWrapper> children() {
    loadChildren();
    return children;
  }

  public List<NamedResourceWrapperList> childrenInGroups() {
    loadChildren();
    List<NamedResourceWrapperList> list = new ArrayList<ResourceWrapper.NamedResourceWrapperList>(); 
    for (ResourceWrapper e : children) {
      NamedResourceWrapperList nl = null;
      for (NamedResourceWrapperList t : list) {
        if (t.name.equals(e.name())) {
          nl = t;
        }
      }
      if (nl == null) {
        nl = new NamedResourceWrapperList(e.name());
        list.add(nl);
      }
      nl.values.add(e);
    }
    return list;
  }

  public List<ResourceWrapper> children(String name) {
    loadChildren();
    List<ResourceWrapper> list = new ArrayList<ResourceWrapper>();
    for (ResourceWrapper e : children) {
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
  public List<ResourceWrapper> childrenMN(String... names) {
    loadChildren();
    List<ResourceWrapper> list = new ArrayList<ResourceWrapper>();
    for (ResourceWrapper e : children) {
      for (String name : names) {
        if (name.equals(e.name())) {
          list.add(e);
        }
      }
    }
    return list;
  }

  public ResourceWrapper child(String name) {
    loadChildren();
    
    ResourceWrapper res = null;

    for (ResourceWrapper e : children) {
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
  public ResourceWrapper childMN(String... names) {
    loadChildren();

    ResourceWrapper res = null;

    for (ResourceWrapper e : children) {
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
    loadChildren();
    for (ResourceWrapper e : children) {
      if (name.equals(e.name()) || (name+"[x]").equals(e.name())) {
        return true;
      }
    }
    return false;
  }

  public boolean hasMN(String... names) {
    loadChildren();
    for (ResourceWrapper e : children) {
      for (String name : names) {
        if (name.equals(e.name()) || (name+"[x]").equals(e.name())) {
          return true;
        }
      }
    }
    return false;
  }

  public ResourceWrapper resource() {
    ResourceWrapper e = this.parent;
    while (e != null && !e.isResource()) {
      e = e.parent;
    }
    return e;
  }

  public boolean hasChildren() {
    loadChildren();
    return !children.isEmpty();
  }

  public boolean hasExtension(String url) {
    loadChildren();
    for (ResourceWrapper e : children) {
      if ("Extension".equals(e.fhirType()) && url.equals(e.primitiveValue("url"))) {
        return true;
      }
    }
    return false;
  }
  
  public ResourceWrapper extension(String url) {
    ResourceWrapper res = null;
    loadChildren();
    for (ResourceWrapper e : children) {
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
    
  public ResourceWrapper extensionValue(String url) {
    ResourceWrapper res = null;
    loadChildren();
    for (ResourceWrapper e : children) {
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
  
  public List<ResourceWrapper> extensions(String url) {
    List<ResourceWrapper> res = new ArrayList<ResourceWrapper>();
    loadChildren();
    for (ResourceWrapper e : children) {
      if ("Extension".equals(e.fhirType()) && url.equals(e.primitiveValue("url"))) {
        res.add(e);
      }
    }
    return res;
  }
  
  public List<ResourceWrapper> extensions() {
    List<ResourceWrapper> res = new ArrayList<ResourceWrapper>();
    loadChildren();
    for (ResourceWrapper e : children) {
      if ("Extension".equals(e.fhirType())) {
        res.add(e);
      }
    }
    return res;
  }
  
  public List<ResourceWrapper> extensionValues(String url) {
    List<ResourceWrapper> res = new ArrayList<ResourceWrapper>();
    loadChildren();
    for (ResourceWrapper e : children) {
      if ("Extension".equals(e.fhirType()) && url.equals(e.primitiveValue("url"))) {
        if (e.has("value")) {
          res.add(e.child("value"));
        }
      }
    }
    return res;
  }

  public abstract Resource getResourceNative();  
  public abstract boolean canHaveNarrative();
  public abstract XhtmlNode getNarrative();  
  public abstract boolean hasNarrative();
  public abstract void setNarrative(XhtmlNode x, String status, boolean multiLangMode, Locale locale, boolean isPretty) throws IOException;
  public abstract String getId();
  public abstract boolean hasId();
  public abstract ResourceWrapper setId(String id);

  public void markLanguage(XhtmlNode x, Locale locale) {
    x.setAttribute("lang", locale.toLanguageTag());
    x.setAttribute("xml:lang", locale.toLanguageTag());
    x.addTag(0, "hr");
    x.addTag(0, "p").b().tx(locale.getDisplayName());
    x.addTag(0, "hr");
  }
  

  public boolean matches(ResourceWrapper b) {
    if (isEmpty() || b.isEmpty()) {
      return isEmpty() && b.isEmpty();
    } else {
      if (hasPrimitiveValue() || b.hasPrimitiveValue()) {
        if (!hasPrimitiveValue() || !b.hasPrimitiveValue() || !primitiveValue().equals(b.primitiveValue())) {
          return false;
        }
      }
      if (children().size() != b.children().size()) {
        return false;
      } else {
        for (int i = 0; i < children().size(); i++) {
          if (!children().get(i).matches(b.children().get(i))) {
            return false;
          }
        }
        return true;
      }
    }
  }

  public String extensionString(String url) {
    ResourceWrapper re = extensionValue(url);
    return re == null ?  null : re.primitiveValue();
  }

  public boolean isEmpty() {
    if (hasChildren()) {
      for (ResourceWrapper c : children) {
        if (!c.isEmpty()) {
          return false;
        }
      }
    }
    return !isPrimitive() || !hasPrimitiveValue();
  }

  
  public ResourceWrapper getResourceWrapper() {
    ResourceWrapper focus = this;
    while (focus != null && !focus.isResource()) {
      focus = focus.parent;
    }
    return focus;
  }

  public ResourceWrapper firstChild(String name) {
    List<ResourceWrapper> list = children(name);
    return list.size() == 0 ? null : list.get(0);
  }

  public ContextUtilities getContextUtilities() {
    return contextUtils;
  }

  public String getScopedId() {
    if (!isResource()) {
      return null;
    } else {
      String res = getId();
      if (parent != null) {
        res = parent.getResourceWrapper().getScopedId()+"/"+getId();
      }
      return res;
    }
  }

  public ResourceWrapper parent() {
    return parent;
  }

  public ResourceWrapper getContained(String id) {
    if (isResource()) {
      List<ResourceWrapper> contained = children("contained");
      for (ResourceWrapper e : contained) {
        if (id.equals(e.getId())) {
          return e;
        }
      }
    }
    return null;
  }


  public abstract String getCodeSystemUri();
  public abstract boolean hasFormatComment();
  public abstract Collection<String> getFormatCommentsPre();
  public abstract XhtmlNode getXhtml();
  public abstract Base getBase();
  public abstract String getWebPath();
  public abstract boolean isDirect();
  protected abstract void loadTheChildren();
  public abstract String fhirVersion();
  public abstract String fhirType();
  public abstract boolean isPrimitive();
  public abstract boolean hasPrimitiveValue();
  public abstract String primitiveValue();
  public abstract boolean isResource();
  public abstract boolean hasUserData(String name);
  public abstract Object getUserData(String name);


}