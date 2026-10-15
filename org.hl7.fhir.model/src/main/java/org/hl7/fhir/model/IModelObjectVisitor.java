package org.hl7.fhir.model;

/**
 * Receives the children of a FHIR object one at a time - see Base.forEachChild() and
 * Base.visitDescendants(). This is the fast way to walk a tree: the generated classes hand over
 * their fields directly, so nothing is allocated, and absent elements cost nothing. Walking
 * listChildren()/getChildren() instead builds a Property for every defined element of every
 * node, whether it has a value or not.
 */
@FunctionalInterface
public interface IModelObjectVisitor {

  /**
   * @param parent the object that the child belongs to
   * @param name the name of the element, as defined - so a choice element is e.g. "value[x]",
   *   whatever the type of the value (use child.fhirType() for that)
   * @param index the position of the value in the list for a repeating element (from 0), or
   *   -1 for an element that can only have one value
   * @param child the value (never null)
   * @return for Base.visitDescendants(), whether to go on to visit the children of this child.
   *   Ignored by Base.forEachChild()
   */
  boolean visit(Base parent, String name, int index, Base child);
}
