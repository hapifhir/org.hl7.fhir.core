package org.hl7.fhir.r4b.comparison;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4b.comparison.ResourceComparer.MessageCounts;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;

public class StructuralMatch<T> {

  private String name; // this is used in some contexts to carry name when T is a pretty abstract type
  private T left;
  private T right;
  private List<ValidationMessage> messages = new ArrayList<>();
  private List<StructuralMatch<T>> children = new ArrayList<>();
 
  public StructuralMatch() {
    // root, just a place holder...
  }
 
  public StructuralMatch(T left, T right) {
    super();
    this.left = left;
    this.right = right;
  }
 
  public StructuralMatch(T left, T right, ValidationMessage msg) {
    super();
    this.left = left;
    this.right = right;
    if (msg != null) {
      this.messages.add(msg);
    }
  }
 
  public StructuralMatch(ValidationMessage msg, T right) {
    super();
    this.messages.add(msg);
    this.right = right;
  }

  public StructuralMatch(T left, ValidationMessage msg) {
    super();
    this.left = left;
    this.messages.add(msg);
  }
   
  public T getLeft() {
    return left;
  }
  public T getRight() {
    return right;
  }

  public List<StructuralMatch<T>> getChildren() {
    return children;
  }

  /**
   * return left if it exists, or return right (which might be null)
   *
   * This is used when accessing whatever makes the items common
   *
   * @return
   */
  public T either() {
    return left != null ? left : right;
  }

  public boolean hasLeft() {
    return left != null;
  }
 
  public boolean hasRight() {
    return right != null;
  }

  public List<ValidationMessage> getMessages() {
    return messages;
  }

  public boolean hasErrors() {
    for (ValidationMessage vm : messages) {
      if (vm.getLevel() == IssueSeverity.ERROR) {
        return true;
      }
    }
    return false;
  }

  public void countMessages(MessageCounts cnts) {
    for (ValidationMessage vm : getMessages()) {
      if (vm.getLevel() == IssueSeverity.ERROR) {
        cnts.error();
      } else if (vm.getLevel() == IssueSeverity.WARNING) {
        cnts.warning();
      } else if (vm.getLevel() == IssueSeverity.INFORMATION) {
        cnts.hint();
      } 
    }
    for (StructuralMatch<T> c : children) {
      c.countMessages(cnts);
    }
  }

  public String getName() {
    return name;
  }

  public StructuralMatch<T> setName(String name) {
    this.name = name;
    return this;
  }

  
}