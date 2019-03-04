package org.hl7.fhir.r5.model.api;

/*
 * #%L
 * org.hl7.fhir.r5
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


public interface IBaseBundle extends IBaseResource {

	/**
	 * Constant for links provided in the bundle. This constant is used in the
	 * link.type field to indicate that the given link is for
	 * the next page of results.  
	 */
	public static final String LINK_NEXT = "next";
	
	/**
	 * Constant for links provided in the bundle. This constant is used in the
	 * link.type field to indicate that the given link is for
	 * the previous page of results.  
	 */
	public static final String LINK_PREV = "prev";

	/**
	 * Constant for links provided in the bundle. This constant is used in the
	 * link.type field to indicate that the given link is for
	 * this bundle.  
	 */
	public static final String LINK_SELF = "self";
	

}
