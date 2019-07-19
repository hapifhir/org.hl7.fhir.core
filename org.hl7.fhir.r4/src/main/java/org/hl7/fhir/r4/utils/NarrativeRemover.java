package org.hl7.fhir.r4.utils;

/*-
 * #%L
 * org.hl7.fhir.r4
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


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Resource;

public class NarrativeRemover {

  public static void main(String[] args) {
    execute(new File(args[0]));

  }

  private static void execute(File folder) {
    for (File f : folder.listFiles()) {
      if (f.isDirectory())
        execute(f);
      else {
        System.out.println(f.getAbsolutePath());
        try {
          Resource r = new JsonParser().parse(new FileInputStream(f));
          if (r instanceof DomainResource) {
            DomainResource d = (DomainResource) r;
            d.setText(null);
            new JsonParser().compose(new FileOutputStream(f), d);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    
  }

}
