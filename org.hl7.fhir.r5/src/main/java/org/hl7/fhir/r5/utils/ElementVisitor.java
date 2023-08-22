package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.ElementVisitor.ElementVisitorInstruction;

public class ElementVisitor {

  public enum ElementVisitorInstruction {
    VISIT_CHILDREN, NO_VISIT_CHILDREN;
  }

  public interface IElementVisitor {
    public ElementVisitorInstruction visit(Object context, Resource resource);
    public ElementVisitorInstruction visit(Object context, Element element);
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
    ElementVisitorInstruction c = visitor.visit(context, res);
    if (c == ElementVisitorInstruction.VISIT_CHILDREN) {
      visitBase(context, res);
    }
  }

  public void visit(Object context, Element e) {
    ElementVisitorInstruction c = visitor.visit(context, e);
    if (c == ElementVisitorInstruction.VISIT_CHILDREN) {
      visitBase(context, e);
    }
  }

}
