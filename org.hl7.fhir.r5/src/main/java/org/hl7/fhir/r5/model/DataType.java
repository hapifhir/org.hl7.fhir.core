package org.hl7.fhir.r5.model;




import org.hl7.fhir.instance.model.api.IBaseDatatype;

import  ca.uhn.fhir.model.api.IElement;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
/**
 * Base StructureDefinition for DataType Type: The base class for all re-useable types defined as part of the FHIR Specification.
 */
@DatatypeDef(name="DataType")
public abstract class DataType extends Element implements IBaseDatatype, IElement {

    private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
    public DataType() {
      super();
    }

  public String fhirType() {
    return "DataType";

  }

      public abstract DataType copy();

      public void copyValues(DataType dst) {
        super.copyValues(dst);
      }


}