package org.hl7.fhir.r5.renderers.utils;

import java.util.Collection;
import java.util.Locale;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Narrative;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/** 
 * This class is used to walk through the resources when rendering, whether
 * the resource is a native resource or loaded by the element model
 */
@MarkedToMoveToAdjunctPackage
public class ResourceWrapperNative extends ResourceWrapper {

  protected Base element;

  ResourceWrapperNative() {
    super();
  }
  
  private ResourceWrapper makeChild(String name, int index, ElementKind kind, Base element) {
    ResourceWrapperNative self = new ResourceWrapperNative();
    self.contextUtils = this.contextUtils;
    self.parent = this;
    self.name = name;
    self.index = index;
    self.kind = kind;
    self.element = element;
    return self;
  }

  public String fhirVersion() {
    return element.getFHIRPublicationVersion().toCode();
  }

  public String fhirType() {
    if (kind == ElementKind.BackboneElement) {
      return basePath();
    } else {
      return element.fhirType();
    }
  }

  public boolean isPrimitive() {
    return element.isPrimitive();
  }

  public boolean hasPrimitiveValue() {
    return element.hasPrimitiveValue();
  }

  public String primitiveValue() {
    return element.primitiveValue();
  }

  protected void loadTheChildren() {

    for (Property p : element.children()) {
      String name = p.getName();
      int i = 0;
      for (Base v : p.getValues()) {
        loadElementChild(p, name, i, v);
        i++;
      }
    }
  }

  private void loadElementChild(Property p, String name, int i, Base v) {
    ElementKind kind = determineModelKind(p, v);      
    int index = p.isList() ? i : -1;
    ElementDefinition ed = null;
    children.add(makeChild(name, index, kind, v));
  }

  private ElementKind determineModelKind(Property p, Base v) {
    if (v.isPrimitive()) {
      return ElementKind.PrimitiveType;
    } else if (contextUtils.isDatatype(v.fhirType())) {
      return ElementKind.DataType;
    } else if (!v.isResource()) {
      return ElementKind.BackboneElement;
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

  public boolean isResource() {
    return element.isResource();
  }

  public boolean canHaveNarrative() {
    if (!isResource()) {
      return false;
    }
    return element instanceof DomainResource;
  }

  public XhtmlNode getNarrative() {
    if (!canHaveNarrative()) {
      return null;
    }
    ResourceWrapper text = child("text");
    if (text == null) {
      return null;
    }
    ResourceWrapper div = text.child("div");
    if (div == null) {
      return null;
    }
    return ((ResourceWrapperNative) div).element.getXhtml();
  }

  public boolean hasNarrative() {
    if (!canHaveNarrative()) {
      return false;
    }
    ResourceWrapper text = child("text");
    if (text == null) {
      return false;
    }
    ResourceWrapper div = text.child("div");
    if (div == null) {
      return false;
    }
    return ((ResourceWrapperNative) div).element.getXhtml() != null;
  }

  public void setNarrative(XhtmlNode x, String status, boolean multiLangMode, Locale locale, boolean isPretty) {
    if (element instanceof DomainResource) {
      DomainResource r = (DomainResource) element;    
      r.getText().setUserData(UserDataNames.renderer_is_generated, true);
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
        r.getText().getDiv().addChildNode(x);
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

  public void markLanguage(XhtmlNode x, Locale locale) {
    x.setAttribute("lang", locale.toLanguageTag());
    x.setAttribute("xml:lang", locale.toLanguageTag());
    x.addTag(0, "hr");
    x.addTag(0, "p").b().tx(locale.getDisplayName());
    x.addTag(0, "hr");
  }


  public String getId() {
    return element.getIdBase();
  }

  public boolean hasId() {
    return element.getIdBase() != null;
  }

  public ResourceWrapper setId(String id) {
    element.setIdBase(id);
    return this;
  }

  @Override
  public String toString() {
    return name + (index == -1 ? "" : "["+index+"]")+": "+fhirType()+" ("+kind+"/"+path()+"): native = "+element.fhirType()+" -> "+element.toString();      
  }

  public Resource getResourceNative() {
    ResourceWrapper focus = getResourceWrapper();
    return focus == null ? null : (Resource) ((ResourceWrapperNative) focus).element;
  }

  public boolean hasFormatComment() {
    return element.hasFormatComment();
  }

  public Collection<String> getFormatCommentsPre() {
    return element.getFormatCommentsPre();
  }

  public XhtmlNode getXhtml() {
    return element.getXhtml();
  }

  public Base getBase() {
    return element;
  }

  public boolean isDirect() {
    return true;
  }

  public String getWebPath() {
    if (isResource()) {
      return ((Resource) element).getWebPath();
    } else {
      return null;
    }
  }

  public String getCodeSystemUri() {
    if (element instanceof Enumeration<?>) {
      return ((Enumeration<?>) element).getSystem();
    }
    return null;
  }

  @Override
  public boolean hasUserData(String name) {
    return element.hasUserData(name);
  }

  @Override
  public Object getUserData(String name) {
    return element.getUserData(name);
  }

}