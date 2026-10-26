package org.hl7.fhir.model.utilities;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.Element;
import org.hl7.fhir.model.core.Resource;


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
    base.forEachChild((parent, name, index, child) -> {
      if (child instanceof Resource) {
        visit(context, (Resource) child);
      } else {
        visit(context, (Element) child);
      }
      return false;
    });
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
