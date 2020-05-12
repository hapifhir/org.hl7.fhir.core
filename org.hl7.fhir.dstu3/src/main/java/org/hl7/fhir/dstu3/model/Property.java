package org.hl7.fhir.dstu3.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.util.ArrayList;
import java.util.List;

/**
 * A child element or property defined by the FHIR specification
 * This class is defined as a helper class when iterating the 
 * children of an element in a generic fashion
 * 
 * At present, iteration is only based on the specification, but 
 * this may be changed to allow profile based expression at a
 * later date
 * 
 * note: there's no point in creating one of these classes outside this package
 */
public class Property {

	/**
	 * The name of the property as found in the FHIR specification
	 */
	private String name;
	
	/**
	 * The type of the property as specified in the FHIR specification (e.g. type|type|Reference(Name|Name)
	 */
	private String typeCode;
	
	/**
	 * The formal definition of the element given in the FHIR specification
	 */
	private String definition;
	
	/**
	 * The minimum allowed cardinality - 0 or 1 when based on the specification
	 */
	private int minCardinality;
	
	/** 
	 * The maximum allowed cardinality - 1 or MAX_INT when based on the specification
	 */
	private int maxCardinality;
	
	/**
	 * The actual elements that exist on this instance
	 */
	private List<Base> values = new ArrayList<Base>();

	/**
	 * For run time, if/once a property is hooked up to it's definition
	 */
	private StructureDefinition structure; 

	/**
	 * Internal constructor
	 */
	public Property(String name, String typeCode, String definition, int minCardinality, int maxCardinality, Base value) {
	  super();
	  this.name = name;
	  this.typeCode = typeCode;
	  this.definition = definition;
	  this.minCardinality = minCardinality;
	  this.maxCardinality = maxCardinality;
    if (value != null)
  	  this.values.add(value);
  }

	/**
	 * Internal constructor
	 */
	public Property(String name, String typeCode, String definition, int minCardinality, int maxCardinality, List<? extends Base> values) {
	  super();
	  this.name = name;
	  this.typeCode = typeCode;
	  this.definition = definition;
	  this.minCardinality = minCardinality;
	  this.maxCardinality = maxCardinality;
	  if (values != null)
	    this.values.addAll(values);
  }

	/**
	 * @return The name of this property in the FHIR Specification
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The stated type in the FHIR specification
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/** 
	 * @return The definition of this element in the FHIR spec
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * @return the minimum cardinality for this element 
	 */
	public int getMinCardinality() {
		return minCardinality;
	}

	/**
	 * @return the maximum cardinality for this element 
	 */
	public int getMaxCardinality() {
		return maxCardinality;
	}

	/**
	 * @return the actual values - will only be 1 unless maximum cardinality == MAX_INT
	 */
	public List<Base> getValues() {
		return values;
	}

  public boolean hasValues() {
    for (Base e : getValues())
      if (e != null)
        return true;
    return false;
  }

  public StructureDefinition getStructure() {
    return structure;
  }

  public void setStructure(StructureDefinition structure) {
    this.structure = structure;
  }

  public boolean isList() {
    return maxCardinality > 1;
  }

}