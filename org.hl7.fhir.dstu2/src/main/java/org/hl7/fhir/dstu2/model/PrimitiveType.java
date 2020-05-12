package org.hl7.fhir.dstu2.model;

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



import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hl7.fhir.instance.model.api.IBaseHasExtensions;
import org.hl7.fhir.instance.model.api.IPrimitiveType;

public abstract class PrimitiveType<T> extends Type implements IPrimitiveType<T>, IBaseHasExtensions {

	private static final long serialVersionUID = 3L;

	private T myCoercedValue;
	private String myStringValue;

	public T getValue() {
		return myCoercedValue;
	}

	public String asStringValue() {
		return myStringValue;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValue()).toHashCode();
	}

	public PrimitiveType<T> setValue(T theValue) {
		myCoercedValue = theValue;
		updateStringValue();
		return this;
	}

	protected void updateStringValue() {
		if (myCoercedValue == null) {
			myStringValue = null;
		} else {
			// NB this might be null
			myStringValue = encode(myCoercedValue);
		}
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty() && StringUtils.isBlank(getValueAsString());
	}

	public void fromStringValue(String theValue) {
		if (theValue == null) {
			myCoercedValue = null;
		} else {
			// NB this might be null
			myCoercedValue = parse(theValue);
		}
		myStringValue = theValue;
	}

	/**
	 * Subclasses must override to convert an encoded representation of this datatype into a "coerced" one
	 * 
	 * @param theValue
	 *            Will not be null
	 * @return May return null if the value does not correspond to anything
	 */
	protected abstract T parse(String theValue);

	/**
	 * Subclasses must override to convert a "coerced" value into an encoded one.
	 * 
	 * @param theValue
	 *            Will not be null
	 * @return May return null if the value does not correspond to anything
	 */
	protected abstract String encode(T theValue);

	public boolean isPrimitive() {
		return true;
	}
	
	public String primitiveValue() {
		return asStringValue();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[" + asStringValue() + "]";
	}

	public boolean hasValue() {
  	  return !StringUtils.isBlank(getValueAsString());
	}

	public String getValueAsString() {
		return asStringValue();
	}

	public void setValueAsString(String theValue) {
		fromStringValue(theValue);
	}

	protected Type typedCopy() {
		return copy();
	}

	public abstract Type copy();

	@Override
	public boolean equalsDeep(Base obj) {
		if (!super.equalsDeep(obj))
			return false;
		if (obj == null) {
			return false;
		}
		if (!(obj.getClass() == getClass())) {
			return false;
		}

		PrimitiveType<?> o = (PrimitiveType<?>) obj;

		EqualsBuilder b = new EqualsBuilder();
		b.append(getValue(), o.getValue());
		return b.isEquals();
	}

	@Override
	public boolean equalsShallow(Base obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj.getClass() == getClass())) {
			return false;
		}

		PrimitiveType<?> o = (PrimitiveType<?>) obj;

		EqualsBuilder b = new EqualsBuilder();
		b.append(getValue(), o.getValue());
		return b.isEquals();
	}


}