package org.hl7.fhir.convertors.misc;

/*-
 * #%L
 * org.hl7.fhir.convertors
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


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.dstu2.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.formats.XmlParser;
import org.hl7.fhir.dstu2.model.Bundle;
import org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.dstu2.model.ValueSet;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;

public class GenValueSetExpansionConvertor {

  public static void main(String[] args) throws FHIRFormatError, FileNotFoundException, IOException {
    String src = args[0];
    String tgt = args[1];
    Bundle bundle = (Bundle) new XmlParser().parse(new FileInputStream(src));
    for (BundleEntryComponent be : bundle.getEntry()) {
      Resource res = be.getResource();
      if (res != null) {
        String id = res.getId();
        if (Utilities.noString(id))
          id = tail(((ValueSet) res).getUrl());
        String dst = Utilities.path(tgt, res.fhirType()+"-"+id+".json");
        System.out.println(dst);
        new JsonParser().setOutputStyle(OutputStyle.NORMAL).compose(new FileOutputStream(dst), res);
      }
    }
  }

  private static String tail(String url) {
    return url.substring(url.lastIndexOf("/")+1);
  }

}
