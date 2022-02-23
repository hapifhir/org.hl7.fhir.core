package org.hl7.fhir.r5.utils;

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


import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleLinkComponent;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Meta;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceType;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;

/**
 * Decoration utilities for various resource types
 * @author Grahame
 *
 */
public class ResourceUtilities {

  public final static String FHIR_LANGUAGE = "urn:ietf:bcp:47";
  private static JurisdictionLocales jl = new JurisdictionLocales(); 

	public static boolean isAnError(OperationOutcome error) {
		for (OperationOutcomeIssueComponent t : error.getIssue())
			if (t.getSeverity() == IssueSeverity.ERROR)
				return true;
			else if (t.getSeverity() == IssueSeverity.FATAL)
				return true;
		return false;
	}
	
	public static String getErrorDescription(OperationOutcome error) {  
		if (error.hasText() && error.getText().hasDiv()) {
			return new XhtmlComposer(XhtmlComposer.XML).composePlainText(error.getText().getDiv());
		}
		
		StringBuilder b = new StringBuilder();
		for (OperationOutcomeIssueComponent t : error.getIssue()) {
			if (t.getSeverity() == IssueSeverity.ERROR) {
				b.append("Error:" +t.getDetails()+"\r\n");
			} else if (t.getSeverity() == IssueSeverity.FATAL) {
				b.append("Fatal:" +t.getDetails()+"\r\n");
			} else if (t.getSeverity() == IssueSeverity.WARNING) {
				b.append("Warning:" +t.getDetails()+"\r\n");
			} else if (t.getSeverity() == IssueSeverity.INFORMATION) {
				b.append("Information:" +t.getDetails()+"\r\n");
			}
		}
		return b.toString();
  }

  public static Resource getById(Bundle feed, ResourceType type, String reference) {
    for (BundleEntryComponent item : feed.getEntry()) {
      if (item.getResource().getId().equals(reference) && item.getResource().getResourceType() == type)
        return item.getResource();
    }
    return null;
  }

  public static BundleEntryComponent getEntryById(Bundle feed, ResourceType type, String reference) {
    for (BundleEntryComponent item : feed.getEntry()) {
      if (item.getResource().getId().equals(reference) && item.getResource().getResourceType() == type)
        return item;
    }
    return null;
  }

	public static String getLink(Bundle feed, String rel) {
		for (BundleLinkComponent link : feed.getLink()) {
			if (link.getRelation().equals(rel))
				return link.getUrl();
		}
	  return null;
  }

  public static Meta meta(Resource resource) {
    if (!resource.hasMeta())
      resource.setMeta(new Meta());
    return resource.getMeta();
  }
  
  public static Locale getLocale(CanonicalResource cr) {
    return getLocale(cr.getLanguage(), cr.getJurisdiction());
  }
  
  public static Locale getLocale(String lang, List<CodeableConcept> jurisdictions) {  
    if (lang != null && lang.contains("-")) {
      return new Locale(lang);        
    }
    for (CodeableConcept cc : jurisdictions) {
      Locale locale = getLocale(lang, cc);
      if (locale != null) {
        return locale;
      }
    }
    return null;
  }


  private static Locale getLocale(String lang, CodeableConcept cc) {
    if (cc.hasCoding("http://unstats.un.org/unsd/methods/m49/m49.htm", "001")) {
      return new Locale("en-US");
    }
    String c = cc.getCode("urn:iso:std:iso:3166");
    if (c == null) {
      return null;
    }
    String l = jl.get(c);
    if (l == null) {
      return null;
    } else if (lang != null) {
      return new Locale(lang+"-"+l.substring(l.indexOf("-")+1));
    } else {
      return new Locale(l);
    }
 }
}