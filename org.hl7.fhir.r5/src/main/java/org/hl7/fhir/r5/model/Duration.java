package org.hl7.fhir.r5.model;




import org.hl7.fhir.instance.model.api.ICompositeType;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * Base StructureDefinition for Duration Type: A length of time.
 */
@DatatypeDef(name="Duration")
public class Duration extends Quantity implements ICompositeType {

    private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
    public Duration() {
      super();
    }

  public String fhirType() {
    return "Duration";

  }

      public Duration copy() {
        Duration dst = new Duration();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Duration dst) {
        super.copyValues(dst);
      }

      protected Duration typedCopy() {
        return copy();
      }


}