package org.hl7.fhir.r5.model;




import org.hl7.fhir.instance.model.api.ICompositeType;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * Base StructureDefinition for Count Type: A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.
 */
@DatatypeDef(name="Count")
public class Count extends Quantity implements ICompositeType {

    private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
    public Count() {
      super();
    }

  public String fhirType() {
    return "Count";

  }

      public Count copy() {
        Count dst = new Count();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Count dst) {
        super.copyValues(dst);
      }

      protected Count typedCopy() {
        return copy();
      }


}