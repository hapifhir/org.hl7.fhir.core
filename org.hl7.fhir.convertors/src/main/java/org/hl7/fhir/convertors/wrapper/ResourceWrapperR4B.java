package org.hl7.fhir.convertors.wrapper;

import java.util.Collection;
import java.util.Locale;

import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.ElementDefinition;
import org.hl7.fhir.r4b.model.Enumeration;
import org.hl7.fhir.r4b.model.Narrative;
import org.hl7.fhir.r4b.model.Property;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/** 
 * An R4 wrapper for the R5 rendering framework - use this to feed R4 resources directly
 * into the R5 framework. 
 * 
 * The R5 framework is fine to render R4 resources, and has R4 (etc) specific code where 
 * appropriate (or will be modified to do so).
 * 
 * Note that in order to use this, you need an R5 IWorkerContext. You can create a 
 * R5 SimpleWorkerContext and load it with all the definitions from R4 (that's how the 
 * validator works internally, so this is well tested code). But you only need to set 
 * up the R5 context once; then you can create instances of these to wrap the objects you
 * want rendered on the fly. (is thread safe)
 * 
 */
public class ResourceWrapperR4B extends ResourceWrapper {

  protected Base element;

  ResourceWrapperR4B() {
    super();
  }
  
  private ResourceWrapper makeChild(String name, int index, ElementKind kind, Base element) {
    ResourceWrapperR4B self = new ResourceWrapperR4B();
    self.contextUtils = this.contextUtils;
    self.parent = this;
    self.name = name;
    self.index = index;
    self.kind = kind;
    self.element = element;
    return self;
  }

  public String fhirVersion() {
    return "4.0.1";
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
    return ((ResourceWrapperR4B) div).element.getXhtml();
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
    return ((ResourceWrapperR4B) div).element.getXhtml() != null;
  }

  public void setNarrative(XhtmlNode x, String status, boolean multiLangMode, Locale locale, boolean isPretty) {
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

  public org.hl7.fhir.r5.model.Resource getResourceNative() {
    return null;
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

  public org.hl7.fhir.r5.model.Base getBase() {
    return null;
  }

  public boolean isDirect() {
    return true;
  }

  public String getWebPath() {
    if (isResource()) {
      return ((Resource) element).getUserString("path");
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