package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Resource;

public abstract class PEInstance {

  private PEDefinition definition;
  private Base data;
  
  protected PEInstance(PEDefinition definition, Base data) {
    super();
    this.definition = definition;
    this.data = data;
  }
  
  /**
   * @return definition information about this instance data 
   */
  public abstract PEDefinition definition();
  
  /**
   * @return the type of this element
   */
  public abstract PEType type();
  
  /**
   * @return all the children of this instance data
   */
  public abstract List<PEInstance> children();

  /**
   * @return all the children of this instance data for the named property
   */
  public abstract List<PEInstance> children(String name);

  /**
   * @return all the children of this instance data with the named property and the named type (for polymorphic
   */
  public abstract List<PEInstance> children(String name, String type);
  
  /**
   * @return make a child, and append it to existing children (if they exist)
   */
  public abstract PEInstance makeChild(String name);
  
  /**
   * remove the nominated child from the resource
   */
  public abstract void removeChild(PEInstance child);


  public enum PEInstanceDataKind {
    Resource, Complex, DataType, PrimitiveValue
  }

  /**
   * @return the kind of data behind this profiled node
   */
  public abstract PEInstanceDataKind getDataKind();
  
  /**
   * @return if dataKind = Resource, get the underlying resource, otherwise an exception
   */
  public abstract Resource asResource();
  
  /**
   * @return if dataKind = Datatype, get the underlying resource, otherwise an exception
   */
  public abstract DataType asDataType();
  
  /**
   * @return if dataKind = PrimitiveValue, get the underlying resource, otherwise an exception
   * 
   * Note that this is for e.g. String.value, not String itself
   */
  public abstract String getPrimitiveValue(); 
}
