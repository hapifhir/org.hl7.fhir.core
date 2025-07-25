package org.hl7.fhir.r5.model;

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



import java.net.URI;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;


import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * Primitive type "canonical" in FHIR: an OID represented as urn:oid:0.1.2.3.4...
 */
@DatatypeDef(name="canonical", profileOf=UriType.class)
public class CanonicalType extends UriType {

	private static final long serialVersionUID = 4L;

	/**
	 * Constructor
	 */
	public CanonicalType() {
		super();
	}

	/**
	 * Constructor
	 */
	public CanonicalType(String theValue) {
		super(theValue);
	}

	/**
	 * Constructor
	 */
	public CanonicalType(URI theValue) {
		super(theValue);
	}

  public static boolean matches(String canonical, String url, String version) {
    String u = canonical.contains("|") ? canonical.substring(0, canonical.indexOf("|")) : canonical;
    String v = canonical.contains("|") ? canonical.substring(canonical.indexOf("|")+1) : null;
    if (version == null) {
      return u.equals(url);
    } else {
      return u.equals(url) && (v == null || v.equals(version));
    }
  }


  /**
	 * Constructor
	 */
	@Override
	public CanonicalType copy() {
		CanonicalType ret = new CanonicalType(getValue());
    copyValues(ret);
    return ret;
	}

	public String fhirType() {
		return "canonical";		
	}

  public String baseUrl() {
    var s = primitiveValue();
    return s == null || !s.contains("|") ? s : s.substring(0, s.indexOf("|"));
  }

  public String version() {
    var s = primitiveValue();
    return s == null || !s.contains("|") ? null : s.substring(s.indexOf("|")+1);
  }

  public String getCanonical() {
    if (hasPrimitiveValue()) {
      return primitiveValue();
    }
    if (hasExtension(ExtensionDefinitions.EXT_ALTERNATE_CANONICAL)) {
      return getExtensionString(ExtensionDefinitions.EXT_ALTERNATE_CANONICAL);
    }
    return null;
  }

  public boolean hasVersion() {
    return getValue() != null && getValue().contains("|");
  }

  public void addVersion(String version) {
    if (version != null) {
      setValue(getValue()+"|"+version);
    }
  }

  public static String urlWithVersion(String system, String version) {
    return system+(version == null ? "" : "|"+version);
  }

  public boolean matches(String system, String version) {
    if (version == null) {
      return this.primitiveValue().equals(system) || this.primitiveValue().startsWith(system+"|");
    } else {
      return this.primitiveValue().equals(urlWithVersion(system, version));
    }
  }

}