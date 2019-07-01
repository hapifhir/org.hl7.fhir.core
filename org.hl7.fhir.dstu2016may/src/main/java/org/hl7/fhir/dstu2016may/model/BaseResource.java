package org.hl7.fhir.dstu2016may.model;

/*-
 * #%L
 * org.hl7.fhir.dstu2016may
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.hl7.fhir.instance.model.api.IAnyResource;
import org.hl7.fhir.instance.model.api.IIdType;

import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.model.api.IElement;

public abstract class BaseResource extends Base implements IAnyResource, IElement {

	private static final long serialVersionUID = 1L;

	/**
     * @param value The logical id of the resource, as used in the url for the resoure. Once assigned, this value never changes.
     */
    public BaseResource setId(IIdType value) {
        if (value == null) {
                setIdElement((IdType)null);
        } else if (value instanceof IdType) {
                setIdElement((IdType) value);
        } else {
                setIdElement(new IdType(value.getValue()));
        }
        return this;
    }

	public abstract BaseResource setIdElement(IdType theIdType);
    
	@Override
  public FhirVersionEnum getStructureFhirVersionEnum() {
    return FhirVersionEnum.DSTU2_1;
  }
}
