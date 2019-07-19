package org.hl7.fhir.r5.openapi;

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



import org.hl7.fhir.utilities.Utilities;

import com.google.gson.JsonObject;

public class InfoWriter extends BaseWriter {


  public InfoWriter(JsonObject object) {
    super(object);
  }

  public InfoWriter title(String value) {
    if (!Utilities.noString(value))
      object.addProperty("title", value);
    return this;            
  }

  public InfoWriter description(String value) {
    if (!Utilities.noString(value))
      object.addProperty("description", value);
    return this;            
  }
  
  public InfoWriter termsOfService(String value) {
    if (!Utilities.noString(value))
      object.addProperty("termsOfService", value);
    return this;            
  }

  public InfoWriter version(String value) {
    if (!Utilities.noString(value))
      object.addProperty("version", value);
    return this;            
  }

  public InfoWriter contact(String name, String email, String url) {
    if (name != null && !object.has("contact")) {
      JsonObject person = new JsonObject();
      person.addProperty("name", name);
      if (!Utilities.noString(email))
        person.addProperty("email", email);
      if (!Utilities.noString(url))
        person.addProperty("url", url);
      object.add("contact", person);
    }
    return this;            
  }
  
  public InfoWriter license(String name, String url) {
    JsonObject license = new JsonObject();
    license.addProperty("name", name);
    if (!Utilities.noString(url))
      license.addProperty("url", url);
    object.add("license", license);
    return this;            
  }
  
  
}
