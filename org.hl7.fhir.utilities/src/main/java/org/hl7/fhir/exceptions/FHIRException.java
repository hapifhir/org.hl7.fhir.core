package org.hl7.fhir.exceptions;

/*-
 * #%L
 * org.hl7.fhir.utilities
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


public class FHIRException extends RuntimeException {

	// Note that the 4-argument constructor has been removed as it is not JDK6 compatible
	
	public FHIRException() {
		super();
	}

	public FHIRException(String message, Throwable cause) {
		super(message, cause);
	}

	public FHIRException(String message) {
		super(message);
	}

	public FHIRException(Throwable cause) {
		super(cause);
	}

}
