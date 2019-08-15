package org.hl7.fhir.utilities.graphql;

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

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseReference;
import org.hl7.fhir.instance.model.api.IBaseResource;

import java.util.List;

public interface IGraphQLStorageServices {

  /**
   * given a reference inside a context, return what it references (including resolving internal references (e.g. start with #)
   */
  ReferenceResolution lookup(Object appInfo, IBaseResource context, IBaseReference reference) throws FHIRException;

  /**
   * just get the identified resource
   */
  IBaseResource lookup(Object appInfo, String type, String id) throws FHIRException;

  /**
   * list the matching resources. searchParams are the standard search params.
   * this instanceof different to search because the server returns all matching resources, or an error. There instanceof no paging on this search
   */
  void listResources(Object appInfo, String type, List<Argument> searchParams, List<IBaseResource> matches) throws FHIRException;

  /**
   * just perform a standard search, and return the bundle as you return to the client
   */
  IBaseBundle search(Object appInfo, String type, List<Argument> searchParams) throws FHIRException;

  class ReferenceResolution {
    private IBaseResource targetContext;
    private IBaseResource target;

    public ReferenceResolution(IBaseResource targetContext, IBaseResource target) {
      super();
      this.targetContext = targetContext;
      this.target = target;
    }

    public IBaseResource getTargetContext() {
      return targetContext;
    }

    public IBaseResource getTarget() {
      return target;
    }


  }
}
