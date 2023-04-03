package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;

public class DataTypeVisitor {

  public interface IDatatypeVisitor<T extends DataType> {
    Class<T> classT();
    boolean visit(String path, T node);
  }

  private boolean anyFalse;
  private boolean anyTrue;
  private int nodeCount;
  private int selectedCount;
  
  public <T extends DataType> void visit(Resource resource, IDatatypeVisitor<T> visitor) {
    visitNode(resource.fhirType(), resource, visitor);
  }

  @SuppressWarnings("unchecked")
  private <T extends DataType> void visitNode(String path, Base node, IDatatypeVisitor<T> visitor) {
    nodeCount++;
    if (node instanceof DataType && visitor.classT().isInstance(node)) {
      selectedCount++;
      boolean ok = visitor.visit(path, (T) node);
      if (ok) {
        anyTrue = true;
      } else {
        anyFalse = true;
      }
    }
    for (Property p : node.children()) {
      if (p.isList()) {
        int i = 0;
        for (Base b : p.getValues()) {
          visitNode(path+"."+p.getName()+"["+i+"]", b, visitor);
          i++;
        }
      } else {
        for (Base b : p.getValues()) {
          visitNode(path+"."+p.getName(), b, visitor);
        }
      }
    }
  }

  public boolean isAnyFalse() {
    return anyFalse;
  }

  public boolean isAnyTrue() {
    return anyTrue;
  }

  public int getNodeCount() {
    return nodeCount;
  }

  public int getSelectedCount() {
    return selectedCount;
  }
  
  
}
