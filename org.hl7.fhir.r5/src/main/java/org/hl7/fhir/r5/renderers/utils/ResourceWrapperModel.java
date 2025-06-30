package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.util.Collection;
import java.util.Locale;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/** 
 * This class is used to walk through the resources when rendering, whether
 * the resource is a native resource or loaded by the element model
 */
@MarkedToMoveToAdjunctPackage
public class ResourceWrapperModel extends ResourceWrapper {

  protected Element model;

  ResourceWrapperModel() {
    super();
  }
  
  private ResourceWrapperModel makeChild(String name, int index, ElementKind kind, Element em) {
    ResourceWrapperModel self = new ResourceWrapperModel();
    self.contextUtils = this.contextUtils;
    self.parent = this;
    self.name = name;
    self.index = index;
    self.kind = kind;
    self.model = em;
    return self;
  }
  
  public String fhirVersion() {
    return model.getFHIRPublicationVersion().toCode();
  }
  
  public String fhirType() {
    if (kind == ElementKind.BackboneElement) {
      return basePath();
    } else {
      return model.fhirType();
    }
  }

  public boolean isPrimitive() {
    return model.isPrimitive();
  }

  public boolean hasPrimitiveValue() {
    return model.hasPrimitiveValue();        
  }

  public String primitiveValue() {
    return model.primitiveValue();
  }

  protected void loadTheChildren() {
    for (Element child : model.getChildren()) {
      String name = child.getProperty().isChoice() ? child.getProperty().getName() : child.getName();
      int index = child.isList() ? child.getIndex() : -1;
      ElementKind kind = determineModelKind(child);
      children.add(makeChild(name, index, kind, child));
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
    } else {
      switch (child.getSpecial()) {
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
  }


  public boolean isResource() {
    return model.isResource();
  }

  public boolean canHaveNarrative() {
    if (!isResource()) {
      return false;
    }
    return contextUtils.isDomainResource(fhirType()); 
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
      return ((ResourceWrapperModel) div).model.getXhtml(); 
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
    return ((ResourceWrapperModel) div).model.getXhtml() != null; 
  }
  
  @Override
  public void setNarrative(XhtmlNode x, String status, boolean multiLangMode, Locale locale, boolean isPretty) throws IOException {
    org.hl7.fhir.r5.elementmodel.Element txt = model.getNamedChild("text");
    if (txt == null) {
      txt = new org.hl7.fhir.r5.elementmodel.Element("text", model.getProperty().getChild(null, "text"));
      int i = 0;
      while (i < model.getChildren().size() && (model.getChildren().get(i).getName().equals("id") || model.getChildren().get(i).getName().equals("meta") || model.getChildren().get(i).getName().equals("implicitRules") || model.getChildren().get(i).getName().equals("language"))) {
        i++;
      }
      if (i >= model.getChildren().size())
        model.getChildren().add(txt);
      else
        model.getChildren().add(i, txt);
    }
    org.hl7.fhir.r5.elementmodel.Element st = txt.getNamedChild("status");
    if (st == null) {
      st = new org.hl7.fhir.r5.elementmodel.Element("status", txt.getProperty().getChild(null, "status"));
      txt.getChildren().add(0, st);
    }
    st.setValue(status);
    org.hl7.fhir.r5.elementmodel.Element div = txt.getNamedChild("div");
    if (div == null) {
      div = new org.hl7.fhir.r5.elementmodel.Element("div", txt.getProperty().getChild(null, "div"));
      txt.getChildren().add(div);
    } 
    // now process the xhtml
    if (multiLangMode) {
      XhtmlNode xd = div.getXhtml();
      if (xd == null) { 
        xd = new XhtmlNode(NodeType.Element, "div");
        xd.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
        div.setXhtml(xd);
      } else {
        xd.getChildNodes().removeIf(c -> !"div".equals(c.getName()) || !c.hasAttribute("xml:lang"));
      }
      markLanguage(x, locale);
      xd.addChildNode(x);
    } else {
      if (!x.hasAttribute("xmlns")) {
        x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
      }
      String l = model.getChildValue("language");
      if (!Utilities.noString(l)) {
        // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
        x.setAttribute("lang", l);
        x.setAttribute("xml:lang", l);
      }
      div.setXhtml(x);
    }
    div.setValue(new XhtmlComposer(XhtmlComposer.XML, isPretty).compose(div.getXhtml()));
  }

  public void markLanguage(XhtmlNode x, Locale locale) {
    x.setAttribute("lang", locale.toLanguageTag());
    x.setAttribute("xml:lang", locale.toLanguageTag());
    x.addTag(0, "hr");
    x.addTag(0, "p").b().tx(locale.getDisplayName());
    x.addTag(0, "hr");
  }
  

  public String getId() {
    return model.getIdBase(); 
  }
  public boolean hasId() {
    return model.getIdBase() != null; 
  }
  
  public ResourceWrapper setId(String id) {
    model.setIdBase(id);
    return this;
  }
  
  @Override
  public String toString() {
    return name + (index == -1 ? "" : "["+index+"]")+": "+fhirType()+" ("+kind+"/"+path()+"): element = "+model.fhirType()+" -> "+model.toString();
  }

  public boolean matches(ResourceWrapperModel b) {
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

  public Resource getResourceNative() {
    return null;
  }

  public boolean hasFormatComment() {
   return model.hasFormatComment();
  }

  public Collection<String> getFormatCommentsPre() {
   return model.getFormatCommentsPre();
  }

  public XhtmlNode getXhtml() {
   return model.getXhtml();
  }

  public Base getBase() {
   return model;
  }

  public boolean isDirect() {
    return false;
  }

  public String getWebPath() {
    return model.getWebPath();
  }

  public String getCodeSystemUri() {
    ElementDefinition pd = model.getProperty().getDefinition(); 
    if (pd != null && pd.hasBinding() && pd.getBinding().hasValueSet()) { 
      ValueSet vs = contextUtils.getWorker().fetchResource(ValueSet.class, pd.getBinding().getValueSet()); 
      if (vs != null && vs.hasCompose() && !vs.getCompose().hasExclude() && vs.getCompose().getInclude().size() == 1) { 
        return vs.getCompose().getIncludeFirstRep().getSystem(); 
      } 
    }
    return null;
  }

  @Override
  public boolean hasUserData(String name) {
    return model.hasUserData(name);
  }
  
  @Override
  public Object getUserData(String name) {
    return model.getUserData(name);
  }


}