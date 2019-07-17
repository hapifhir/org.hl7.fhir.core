package org.hl7.fhir.r5.patterns;

/*-
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


import java.util.List;

import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;

public class PatternBaseImpl implements PatternBase {

  private Base wrapped;
  
  public PatternBaseImpl(Base wrapped) {
    super();
    this.wrapped = wrapped;
  }

  @Override
  public String getId() {
    if (wrapped instanceof Element)
      return ((Element) wrapped).getId();
    if (wrapped instanceof Resource)
      return ((Resource) wrapped).getId();
    return null;
  }

  @Override
  public PatternBase setId(String value) {
    if (wrapped instanceof Element)
      ((Element) wrapped).setId(value);
    else if (wrapped instanceof Resource)
      ((Resource) wrapped).setId(value);
    else
      throw new Error("this should not happen? wrapped = "+wrapped.getClass().getName());
    return this;
  }

  @Override
  public List<Extension> getExtension() {
    if (wrapped instanceof Element)
      return ((Element) wrapped).getExtension();
    if (wrapped instanceof DomainResource)
      return ((DomainResource) wrapped).getExtension();
    return null;
  }


  protected Annotation convertStringToAnnotation(String value) {
    if (value == null)
      return null;
    else
      return new Annotation().setText(value);
  }
  
  protected String convertAnnotationToString(Annotation value) {
    if (value == null)
      return null;
    else
      return value.getText();
  }


}
