package org.hl7.fhir.r4b.utils;

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


import org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent;
import org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent;

public class IGHelper {

  
  public static final String EXT_SPREADSHEET = ToolingExtensions.EXT_IGP_SPREADSHEET;
  public static final String EXT_MAPPING_CSV = ToolingExtensions.EXT_IGP_MAPPING_CSV;
  public static final String EXT_BUNDLE = ToolingExtensions.EXT_IGP_BUNDLE;
  public static final String EXT_RESOURCE_INFO = ToolingExtensions.EXT_IGP_RESOURCE_INFO;
//  public static final String EXT_CONTAINED_RESOURCE_INFO = ToolingExtensions.EXT_IGP_CONTAINED_RESOURCE_INFO;
  public static final String EXT_PRIVATE_BASE = ToolingExtensions.EXT_PRIVATE_BASE;

  public static String readStringParameter(ImplementationGuideDefinitionComponent ig, String name) {
    for (ImplementationGuideDefinitionParameterComponent p : ig.getParameter()) {
      if (name == p.getCode()) {
        return p.getValue();
      }
    }
    return null;
  }

  public static boolean getBooleanParameter(ImplementationGuideDefinitionComponent ig, String name, boolean defaultValue) {
    String v = readStringParameter(ig, name);
    return v == null ? false : Boolean.parseBoolean(v);
  }

  public static void setParameter(ImplementationGuideDefinitionComponent ig, String name, String value) {
    for (ImplementationGuideDefinitionParameterComponent p : ig.getParameter()) {
      if (name == p.getCode()) {
        p.setValue(value);
        return;
      }
    }
    ImplementationGuideDefinitionParameterComponent p = ig.addParameter();
    p.setCode(name);
    p.setValue(value);
  }
  
  public static void addParameter(ImplementationGuideDefinitionComponent ig, String name, String value) {
    ImplementationGuideDefinitionParameterComponent p = ig.addParameter();
    p.setCode(name);
    p.setValue(value);
  }
  
  public static void setParameter(ImplementationGuideDefinitionComponent ig, String name, boolean value) {
    setParameter(ig, name, Boolean.toString(value));
  }

}