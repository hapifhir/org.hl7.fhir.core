package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;

public class ElementVisitor {

  public interface IElementVisitor {
    public void visit(Object context, Resource resource);
    public void visit(Object context, Element element);
  }

  private IElementVisitor visitor;
  
  public ElementVisitor(IElementVisitor visitor) {
    this.visitor = visitor;
  }

  private void visitBase(Object context, Base base) {
    for (Property p : base.children()) {
      if (p.hasValues()) {
        for (Base b : p.getValues()) {
          if (b instanceof Resource) {
            visit(context, (Resource) b);
          } else {
            visit(context, (Element) b);
          }
        }
      }
    }
  }

  public void visit(Object context, Resource res) {
    visitor.visit(context, res);
    visitBase(context, res);
  }

  public void visit(Object context, Element e) {
    visitor.visit(context, e);
    visitBase(context, e);
  }

}
