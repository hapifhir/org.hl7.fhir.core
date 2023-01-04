package org.hl7.fhir.r5.profilemodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BaseDateTimeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.HumanName;
import org.hl7.fhir.r5.model.Address;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;

/**
 * This class provides a profile centric view of a resource, as driven by a profile
 * 
 * This class is also suitable to be used as the base of a POJO 
 * @author grahamegrieve
 *
 */
public class PEInstance {

  private PEBuilder builder;
  private PEDefinition definition;
  private Resource resource; // for FHIRPath
  private Base data;
  private String path;
  
  protected PEInstance(PEBuilder builder, PEDefinition definition, Resource resource, Base data, String path) {
    super();
    this.builder = builder;
    this.definition = definition;
    this.resource = resource; 
    this.data = data;
    this.path = path;
  }
  
  /**
   * @return definition information about this instance data 
   */
  public PEDefinition definition() {
    return definition;
  }
  
  /**
   * @return the type of this element
   */
  public PEType type() {
    return definition.types().get(0);
  }
  
  /**
   * @return all the children of this instance data
   */
  public List<PEInstance> children() {
    List<PEInstance> res = new ArrayList<>();
    for (PEDefinition child : definition.children()) {
      List<Base> instances = builder.exec(resource, data, child.fhirpath());
      int i = 0;
      for (Base b : instances) {
        res.add(new PEInstance(builder, child, resource, b, path+"."+child.name()+(child.repeats() ? "["+i+"]": "")));
        i++;
      }
    }
    return res;
  }

  /**
   * @return all the single children of this instance data for the named property. An exception if there's more than one, null if there's none
   */
  public PEInstance child(String name) {
    PEDefinition child = byName(definition.children(), name);
    List<Base> instances = builder.exec(resource, data, child.fhirpath());
    if (instances.isEmpty()) {
      return null;
    } else if (instances.size() == 1) {
      return new PEInstance(builder, child, resource, instances.get(0), path+"."+child.name()+(child.repeats() ? "[0]": ""));      
    } else {
      throw new FHIRException("Found multiple instances for "+name+"@ "+path);
    }
  }

  /**
   * @return all the children of this instance data for the named property
   */
  public List<PEInstance> children(String name) {
    PEDefinition child = byName(definition.children(), name);
    List<PEInstance> res = new ArrayList<>();
    List<Base> instances = builder.exec(resource, data, child.fhirpath());
    int i = 0;
    for (Base b : instances) {
      res.add(new PEInstance(builder, child, resource, b, path+"."+child.name()+(child.repeats() ? "["+i+"]": "")));
      i++;
    }
    return res;
  }

  private PEDefinition byName(List<PEDefinition> children, String name) {
    for (PEDefinition defn : children) {
      if (defn.name().equals(name)) {
        return defn;
      }
    }
    throw new FHIRException("No children with the name '"+name+"'");
  }

  /**
   * @return make a child, and append it to existing children (if they exist)
   */
  public PEInstance makeChild(String name) {
    PEDefinition child = byName(definition.children(), name);
    Base b = data.addChild(child.schemaName());
    builder.populateByProfile(b, child);
    return new PEInstance(builder, child, resource, b, path+"."+child.name());
  }
  
  /**
   * @return get a child. if it doesn't exist, make one
   */
  public PEInstance forceChild(String name) {
    PEDefinition child = byName(definition.children(), name);
    List<Base> instances = builder.exec(resource, data, child.fhirpath());
    if (instances.isEmpty()) {
      Base b = data.addChild(child.schemaName());
      builder.populateByProfile(b, child);
      return new PEInstance(builder, child, resource, b, path+"."+child.name()+(child.isList() ? "[0]": ""));
    } else {
      return new PEInstance(builder, child, resource, instances.get(0), path+"."+child.name()+(child.repeats() ? "[0]": ""));
    }
  }
  
  /**
   * remove the nominated child from the resource
   */
  public boolean removeChild(PEInstance child) {
    return data.removeChild(child.definition().schemaName(), child.data);
  }


  public enum PEInstanceDataKind {
    Resource, Complex, DataType, Primitive
  }

  /**
   * @return the kind of data behind this profiled node
   */
  public PEInstanceDataKind getDataKind() {
    if (data instanceof Resource) {
      return PEInstanceDataKind.Resource;
    }
    if (data instanceof PrimitiveType) {
      return PEInstanceDataKind.Primitive;
    }
    if (data instanceof DataType) {
      return PEInstanceDataKind.DataType;
    }
    return PEInstanceDataKind.Complex;
  }
  
  public Base data() {
    return data;
  }
  
  /**
   * @return if dataKind = Resource, get the underlying resource, otherwise an exception
   */
  public Resource asResource() {
    return (Resource) data;
  }
  
  /**
   * @return if dataKind = Datatype, get the underlying resource, otherwise an exception
   */
  public DataType asDataType() {
    return (DataType) data;
  }
  
  public CodeableConcept asCodeableConcept() {
    return (CodeableConcept) asDataType();
  }
  
  public Identifier Identifier() {
    return (Identifier) asDataType();
  }
  
  public Quantity asQuantity() {
    return (Quantity) asDataType();
  }
  
  public HumanName asHumanName() {
    return (HumanName) asDataType();
  }
  
  public Address Address() {
    return (Address) asDataType();
  }
  
  public ContactPoint asContactPoint() {
    return (ContactPoint) asDataType();
  }
  
  public Reference asReference() {
    return (Reference) asDataType();
  }
  
  
  /**
   * @return if dataKind = PrimitiveValue, get the underlying resource, otherwise an exception
   * 
   * Note that this is for e.g. String.value, not String itself
   */
  public String getPrimitiveAsString() {
    return data.primitiveValue();
  }
  
  public Date getPrimitiveAsDate() {
    if (data instanceof BaseDateTimeType) {
      return ((DateTimeType) data).getValue();
    }
    return null;
  }
  
  public void setPrimitiveValue(String value) {
    PrimitiveType<?> pt = (PrimitiveType<?>) data;
    pt.setValueAsString(value);
  }

  public String getPath() {
    return path;
  }

  public Base getBase() {
    return data;
  }
}
