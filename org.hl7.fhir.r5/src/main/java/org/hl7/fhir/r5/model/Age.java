package org.hl7.fhir.r5.model;




import org.hl7.fhir.instance.model.api.ICompositeType;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * Base StructureDefinition for Age Type: A duration of time during which an organism (or a process) has existed.
 */
@DatatypeDef(name="Age")
public class Age extends Quantity implements ICompositeType {

    private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
    public Age() {
      super();
    }

  public String fhirType() {
    return "Age";

  }

      public Age copy() {
        Age dst = new Age();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Age dst) {
        super.copyValues(dst);
      }

      protected Age typedCopy() {
        return copy();
      }


}