package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;

public class ElementVisitor {

  public interface IElementVisitor {
    public void visit(Resource resource);
    public void visit(Element element);
  }

  private IElementVisitor visitor;
  
  public ElementVisitor(IElementVisitor visitor) {
    this.visitor = visitor;
  }

  private void visitBase(Base base) {
    for (Property p : base.children()) {
      if (p.hasValues()) {
        for (Base b : p.getValues()) {
          if (b instanceof Resource) {
            visit((Resource) b);
          } else {
            visit((Element) b);
          }
        }
      }
    }
  }

  public void visit(Resource res) {
    visitor.visit(res);
    visitBase(res);
  }

  public void visit(Element e) {
    visitor.visit(e);
    visitBase(e);
  }

}
