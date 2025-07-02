package org.hl7.fhir.dstu2016may.utils;

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

/*
Copyright (c) 2011+, HL7, Inc
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

import org.hl7.fhir.dstu2016may.model.DomainResource;
import org.hl7.fhir.dstu2016may.model.Element;
import org.hl7.fhir.dstu2016may.model.Extension;
import org.hl7.fhir.dstu2016may.model.ExtensionHelper;
import org.hl7.fhir.dstu2016may.model.StringType;
import org.hl7.fhir.dstu2016may.model.UriType;

@Deprecated
public class ToolingExtensions {

  public static boolean hasExtension(Element e, String url) {
    return getExtension(e, url) != null;
  }

  public static String readStringExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return null;
    if (ex.getValue() instanceof UriType)
      return ((UriType) ex.getValue()).getValue();
    if (!(ex.getValue() instanceof StringType))
      return null;
    return ((StringType) ex.getValue()).getValue();
  }

  /**
   * @param name the identity of the extension of interest
   * @return The extension, if on this element, else null
   */
  public static Extension getExtension(DomainResource resource, String name) {
    if (name == null)
      return null;
    if (!resource.hasExtension())
      return null;
    for (Extension e : resource.getExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    return null;
  }

  public static Extension getExtension(Element el, String name) {
    if (name == null)
      return null;
    if (!el.hasExtension())
      return null;
    for (Extension e : el.getExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    return null;
  }

  public static void setStringExtension(Element element, String uri, String value) {
    Extension ext = getExtension(element, uri);
    if (ext != null)
      ext.setValue(new StringType(value));
    else
      element.getExtension().add(new Extension(new UriType(uri)).setValue(new StringType(value)));
  }

}