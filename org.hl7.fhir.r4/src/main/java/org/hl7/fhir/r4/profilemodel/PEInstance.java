package org.hl7.fhir.r4.profilemodel;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.BaseDateTimeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.PrimitiveType;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StringType;

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
      if (defn.name().equals(name+"[x]")) {
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
    Base b = child.isBaseList() || !child.isBasePrimitive() ? data.addChild(child.schemaNameWithType()) : data.makeProperty(child.schemaNameWithType().hashCode(), child.schemaNameWithType());
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
  public void removeChild(PEInstance child) {
    data.removeChild(child.definition().schemaName(), child.data);
  }

  public void clear(String name) {
    List<PEInstance> children = children(name);
    for (PEInstance child : children) {
      removeChild(child);
    }
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
    if (data instanceof Type) {
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
  public Type asDataType() {
    return (Type) data;
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

  public boolean hasChild(String name) {
    PEDefinition child = byName(definition.children(), name);
    List<Base> instances = builder.exec(resource, data, child.fhirpath());
    return !instances.isEmpty();
  }
  
  public IWorkerContext getContext() {
    return builder.getContext();
  }

  public void addChild(String name, Type value) {
      PEDefinition child = byName(definition.children(), name);
      Base b = data.setProperty(child.schemaName(), value);
  }
  
  public void addChild(String name, String value) {
    PEDefinition child = byName(definition.children(), name);
    Base b = data.setProperty(child.schemaName(), new StringType(value));
  }

  public void addChild(String name, Date value) {
    PEDefinition child = byName(definition.children(), name);
    Base b = data.setProperty(child.schemaName(), new DateType(value));
  }
}
