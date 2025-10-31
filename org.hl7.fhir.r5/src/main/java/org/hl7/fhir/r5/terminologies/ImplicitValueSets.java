package org.hl7.fhir.r5.terminologies;

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

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;

import java.util.List;

@MarkedToMoveToAdjunctPackage
public class ImplicitValueSets {

  private Parameters expParameters;

  public ImplicitValueSets(Parameters expParameters) {
    this.expParameters = expParameters;
  }

  public ValueSet generateImplicitValueSet(String url) {
    if (Utilities.noString(url)) {
      return null;
    }
    
    if (url.startsWith("http://snomed.info/sct")) {
      return generateImplicitSnomedValueSet(url, defaultVersion("http://snomed.info/sct"));
    }
    if (url.startsWith("http://loinc.org/vs")) {
      return generateImplicitLoincValueSet(url, defaultVersion("http://loinc.org"));
    }
    if (url.equals("http://unitsofmeasure.org/vs")) {
      return allUcumValueSet();
    }
    if (url.equals("http://hl7.org/fhir/ValueSet/mimetypes")) {
      return generateImplicitMimetypesValueSet(url);
    }
    return null;
  }

  private String defaultVersion(String url) {
    for (Parameters.ParametersParameterComponent p : expParameters.getParameter()) {
      if ("default-version".equals(p.getName())) {
        String u = p.getValue().primitiveValue();
        if (u.startsWith(url+"|")) {
          return u.substring(u.indexOf(1)+1);
        }
      }
    }
    return null;
  }

  public ValueSet generateImplicitValueSet(String url, String version) {
    if (Utilities.noString(url)) {
      return null;
    }

    if (Utilities.noString(version)) {
      return generateImplicitValueSet(url);
    }

    if (url.startsWith("http://snomed.info/sct")) {
      return generateImplicitSnomedValueSet(url, version);
    } else if (url.startsWith("http://loinc.org/vs")) {
      return generateImplicitLoincValueSet(url, version);
    } else {
      return null;
    }
  }

  public boolean isImplicitValueSet(String url) {
    return isImplicitSCTValueSet(url) || isImplicitLoincValueSet(url) || isImplicitUcumValueSet(url) || isImplicitMimeTypesValueSet(url);
  }


  //-- SCT -------------------

  public boolean isImplicitSCTValueSet(String url) {
    return url.startsWith("http://snomed.info/sct") && url.contains("?fhir_vs");
  }

  private ValueSet generateImplicitSnomedValueSet(String url, String version) {
    String query = url.substring(url.indexOf("?")+1);
    if ("fhir_vs".equals(query)) {
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setVersion(version);
      vs.setName("SCTValueSetAll");
      vs.setTitle("All Codes SCT ValueSet");
      vs.setDescription("Value Set for All SNOMED CT Concepts");
      vs.setCopyright("This value set includes content from SNOMED CT, which is copyright © 2002+ International Health Terminology Standards Development Organisation (SNOMED International), and distributed by agreement between SNOMED International and HL7. Implementer use of SNOMED CT is not covered by this agreement");
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.getCompose().addInclude().setSystem("http://snomed.info/sct");
      vs.setWebPath("https://browser.ihtsdotools.org/");
      return vs;
    } else if (query.startsWith("fhir_vs=isa/")) {
      String sct = query.substring(12);
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setVersion(version);
      vs.setName("SCTValueSetFor"+sct);
      vs.setTitle("SCT ValueSet for "+sct);
      vs.setDescription("SNOMED CT Concepts that is-a "+sct);
      vs.setCopyright("This value set includes content from SNOMED CT, which is copyright © 2002+ International Health Terminology Standards Development Organisation (SNOMED International), and distributed by agreement between SNOMED International and HL7. Implementer use of SNOMED CT is not covered by this agreement");
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.getCompose().addInclude().setSystem("http://snomed.info/sct").addFilter().setProperty("concept").setOp(Enumerations.FilterOperator.ISA).setValue(sct);
      vs.setWebPath("https://browser.ihtsdotools.org/?perspective=full&conceptId1="+sct);
      return vs;
    } else if (query.equals("fhir_vs=refset")) {
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setVersion(version);
      vs.setName("SCTReferenceSetList");
      vs.setTitle("SCT Reference Set List");
      vs.setDescription("SNOMED CT Reference Sets");
      vs.setCopyright("This value set includes content from SNOMED CT, which is copyright © 2002+ International Health Terminology Standards Development Organisation (SNOMED International), and distributed by agreement between SNOMED International and HL7. Implementer use of SNOMED CT is not covered by this agreement");
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.getCompose().addInclude().setSystem("http://snomed.info/sct").addFilter().setProperty("concept").setOp(Enumerations.FilterOperator.ISA).setValue("refset-base");
      return vs;
    } else if (query.startsWith("fhir_vs=refset/")) {
      String srt = query.substring(15);
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setVersion(version);
      vs.setName("SCTRefSet"+srt);
      vs.setTitle("SCT Reference Set "+srt);
      vs.setDescription("SNOMED CT Reference Set "+srt);
      vs.setCopyright("This value set includes content from SNOMED CT, which is copyright © 2002+ International Health Terminology Standards Development Organisation (SNOMED International), and distributed by agreement between SNOMED International and HL7. Implementer use of SNOMED CT is not covered by this agreement");
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.getCompose().addInclude().setSystem("http://snomed.info/sct").addFilter().setProperty("concept").setOp(Enumerations.FilterOperator.IN).setValue(srt);
      vs.setWebPath("https://browser.ihtsdotools.org/?perspective=full&conceptId1="+srt);
      return vs;
    } else {
      return null;
    }
  }

  // -- LOINC -----------------

  public boolean isImplicitLoincValueSet(String url) {
    return url.startsWith("http://loinc.org/vs");
  }

  private ValueSet generateImplicitLoincValueSet(String url, String version) {
    if (url.startsWith("http://loinc.org/vs/LL")) {
      String c = url.substring(20);
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setVersion(version);
      vs.setName("LOINCAnswers"+c);
      vs.setTitle("LOINC Answer Codes for "+c);
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.setCopyright("This content LOINC® is copyright © 1995 Regenstrief Institute, Inc. and the LOINC Committee, and available at no cost under the license at http://loinc.org/terms-of-use");
      vs.getCompose().addInclude().setSystem("http://loinc.org").addFilter().setProperty("LIST").setOp(Enumerations.FilterOperator.EQUAL).setValue(c);
      vs.setWebPath("https://loinc.org/LL"+c);
      return vs;
    } else if (url.startsWith("http://loinc.org/vs/LP")) {
      String c = url.substring("http://loinc.org/vs/".length());
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setVersion(version);
      vs.setName("LOINCPartList"+c);
      vs.setTitle("LOINC Codes for Part "+c);
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.setCopyright("This content LOINC® is copyright © 1995 Regenstrief Institute, Inc. and the LOINC Committee, and available at no cost under the license at http://loinc.org/terms-of-use");
      vs.getCompose().addInclude().setSystem("http://loinc.org").addFilter().setProperty("ancestor").setOp(Enumerations.FilterOperator.EQUAL).setValue(c);
      vs.setWebPath("https://loinc.org/LP"+c);
      return vs;
    } else if (url.equals("http://loinc.org/vs")) {
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setVersion(version);
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.setName("LOINCCodes");
      vs.setTitle("All LOINC codes");
      vs.setCopyright("This content LOINC® is copyright © 1995 Regenstrief Institute, Inc. and the LOINC Committee, and available at no cost under the license at http://loinc.org/terms-of-use");
      vs.getCompose().addInclude().setSystem("http://loinc.org");
      vs.setWebPath("http://loinc.org/");
      return vs;
    } else if ("http://loinc.org/vs/valid-hl7-attachment-requests".equals(url)) {
      ValueSet vs = new ValueSet();
      vs.setUrl(url);
      vs.setVersion(version);
      vs.setStatus(PublicationStatus.ACTIVE);
      vs.setName("HL7AttachmentRequests");
      vs.setTitle("HL7 Attachment Requests");
      vs.setCopyright("This content LOINC® is copyright © 1995 Regenstrief Institute, Inc. and the LOINC Committee, and available at no cost under the license at http://loinc.org/terms-of-use");
      vs.getCompose().addInclude().setSystem("http://loinc.org").addFilter().setProperty("ValidHL7AttachmentRequest").setOp(Enumerations.FilterOperator.EQUAL).setValue("Y");
      vs.setWebPath("https://loinc.org/attachments/");
      return vs;
    } else {
      return null;
    }
  }

  // -- UCUM ---------

  private boolean isImplicitUcumValueSet(String url) {
    return "http://unitsofmeasure.org/vs".equals(url);
  }

  private ValueSet allUcumValueSet() {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://unitsofmeasure.org/vs");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.setName("AllUcumCodes");
    vs.setTitle("All Ucum Codes");
    vs.getCompose().addInclude().setSystem("http://unitsofmeasure.org");
    return vs;
  }

  // -- MIME Types -------

  private boolean isImplicitMimeTypesValueSet(String url) {
    return "http://hl7.org/fhir/ValueSet/mimetypes".equals(url);
  }

  private ValueSet generateImplicitMimetypesValueSet(String theUri) {
    ValueSet valueSet = new ValueSet();
    valueSet.setStatus(PublicationStatus.ACTIVE);
    valueSet.setUrl(theUri);
    valueSet.setDescription("This value set includes all possible codes from BCP-13 (http://tools.ietf.org/html/bcp13)");
    valueSet.getCompose()
      .addInclude().setSystem("urn:ietf:bcp:13");
    return valueSet;
  }


}