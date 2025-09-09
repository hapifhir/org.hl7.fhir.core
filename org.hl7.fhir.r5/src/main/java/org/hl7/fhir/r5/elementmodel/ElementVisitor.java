package org.hl7.fhir.r5.elementmodel;


public class ElementVisitor {

  public enum ElementVisitorInstruction {
    VISIT_CHILDREN, NO_VISIT_CHILDREN;
  }

  public interface IElementVisitor {
    public ElementVisitorInstruction visit(Object context, Element element);
  }

  private IElementVisitor visitor;
  
  public ElementVisitor(IElementVisitor visitor) {
    this.visitor = visitor;
  }

  private void visitElement(Object context, Element e) {
    for (Element c : e.getChildren()) {
      visit(context, c);
    }
  }

  public void visit(Object context, Element e) {
    ElementVisitorInstruction c = visitor.visit(context, e);
    if (c == ElementVisitorInstruction.VISIT_CHILDREN) {
      visitElement(context, e);
    }
  }

}
