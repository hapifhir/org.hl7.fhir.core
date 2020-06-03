package org.hl7.fhir.r5.model;




import org.hl7.fhir.instance.model.api.ICompositeType;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * Base StructureDefinition for Distance Type: A length - a value with a unit that is a physical distance.
 */
@DatatypeDef(name="Distance")
public class Distance extends Quantity implements ICompositeType {

    private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
    public Distance() {
      super();
    }

  public String fhirType() {
    return "Distance";

  }

      public Distance copy() {
        Distance dst = new Distance();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Distance dst) {
        super.copyValues(dst);
      }

      protected Distance typedCopy() {
        return copy();
      }


}