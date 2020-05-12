package org.hl7.fhir.convertors;

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



public class VersionConvertorConstants {

  public final static String IG_DEPENDSON_PACKAGE_EXTENSION = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ImplementationGuide.dependsOn.packageId";
  public final static String IG_DEPENDSON_VERSION_EXTENSION = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ImplementationGuide.dependsOn.version";
  public final static String MODIFIER_REASON_EXTENSION = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ElementDefinition.isModifierReason";
  public final static String MODIFIER_TAKEN = "http://hl7.org/fhir/4.0/StructureDefinition/extension-MedicationStatment.taken";
  public final static String MODIFIER_REASON_LEGACY = "No Modifier Reason provideed in previous versions of FHIR";
  public final static String PROFILE_EXTENSION = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ElementDefinition.type.profile";
  public final static String IG_CONFORMANCE_MESSAGE_EVENT = "http://hl7.org/fhir/1.0/StructureDefinition/extension-Conformance.messaging.event";
  
  public static String refToVS(String url) {
    if (url == null)
      return null;
    if (url.equals("http://www.genenames.org"))
      return "http://hl7.org/fhir/ValueSet/genenames";
    else if (url.equals("http://varnomen.hgvs.org/"))
      return "http://hl7.org/fhir/ValueSet/variants";
    else if (url.equals("http://www.ncbi.nlm.nih.gov/nuccore?db=nuccore"))
      return "http://hl7.org/fhir/ValueSet/ref-sequences";
    else if (url.equals("http://www.ensembl.org/"))
      return "http://hl7.org/fhir/ValueSet/ensembl";
    else if (url.equals("http://www.ncbi.nlm.nih.gov/clinvar/variation"))
      return "http://hl7.org/fhir/ValueSet/clinvar";
    else if (url.equals("http://cancer.sanger.ac.uk/cancergenome/projects/cosmic/"))
      return "http://hl7.org/fhir/ValueSet/cosmic";
    else if (url.equals("http://www.ncbi.nlm.nih.gov/projects/SNP/"))
      return "http://hl7.org/fhir/ValueSet/bbsnp";
    else if (url.equals("http://www.sequenceontology.org/"))
      return "http://hl7.org/fhir/ValueSet/sequenceontology";
    else if (url.equals("http://www.ebi.ac.uk/"))
      return "http://hl7.org/fhir/ValueSet/allelename";
    else if (url.equals("https://www.iso.org/iso-4217-currency-codes.html"))
      return "http://hl7.org/fhir/ValueSet/currencies";
    else if (url.equals("http://www.rfc-editor.org/bcp/bcp13.txt"))
      return "http://hl7.org/fhir/ValueSet/mimetypes";
    else
      return url;
  }
    
  public static String vsToRef(String url) {
    if (url == null)
      return null;
    if (url.equals("http://hl7.org/fhir/ValueSet/genenames"))
      return "http://www.genenames.org";
    else if (url.equals("http://hl7.org/fhir/ValueSet/variants"))
      return "http://varnomen.hgvs.org/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/ref-sequences"))
      return "http://www.ncbi.nlm.nih.gov/nuccore?db=nuccore";
    else if (url.equals("http://hl7.org/fhir/ValueSet/ensembl"))
      return "http://www.ensembl.org/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/clinvar"))
      return "http://www.ncbi.nlm.nih.gov/clinvar/variation";
    else if (url.equals("http://hl7.org/fhir/ValueSet/cosmic"))
      return "http://cancer.sanger.ac.uk/cancergenome/projects/cosmic/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/bbsnp"))
      return "http://www.ncbi.nlm.nih.gov/projects/SNP/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/sequenceontology"))
      return "http://www.sequenceontology.org/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/allelename"))
      return "http://www.ebi.ac.uk/";
    else if (url.equals("http://hl7.org/fhir/ValueSet/currencies"))
      return "https://www.iso.org/iso-4217-currency-codes.html";
    else if (url.equals("http://hl7.org/fhir/ValueSet/mimetypes"))
      return "http://www.rfc-editor.org/bcp/bcp13.txt";
    else
      return null;
  }

  public static final String EXT_OLD_CONCEPTMAP_EQUIVALENCE = "http://hl7.org/fhir/1.0/StructureDefinition/extension-ConceptMap.element.target.equivalence";
}