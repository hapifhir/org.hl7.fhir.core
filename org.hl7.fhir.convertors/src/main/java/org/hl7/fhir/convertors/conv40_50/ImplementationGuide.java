package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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

// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0


public class ImplementationGuide extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide tgt = new org.hl7.fhir.r5.model.ImplementationGuide();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicense(convertSPDXLicense(src.getLicense()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.FHIRVersion> t : src.getFhirVersion())
      tgt.addFhirVersion(Enumerations.convertFHIRVersion(t.getValue()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn())
      tgt.addDependsOn(convertImplementationGuideDependsOnComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertImplementationGuideDefinitionComponent(src.getDefinition()));
    if (src.hasManifest())
      tgt.setManifest(convertImplementationGuideManifestComponent(src.getManifest()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r5.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide tgt = new org.hl7.fhir.r4.model.ImplementationGuide();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicense(convertSPDXLicense(src.getLicense()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> t : src.getFhirVersion())
      tgt.addFhirVersion(Enumerations.convertFHIRVersion(t.getValue()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn())
      tgt.addDependsOn(convertImplementationGuideDependsOnComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertImplementationGuideDefinitionComponent(src.getDefinition()));
    if (src.hasManifest())
      tgt.setManifest(convertImplementationGuideManifestComponent(src.getManifest()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense convertSPDXLicense(org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTOPENSOURCE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NOTOPENSOURCE;
    case _0BSD: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense._0BSD;
    case AAL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AAL;
    case ABSTYLES: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ABSTYLES;
    case ADOBE2006: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ADOBE2006;
    case ADOBEGLYPH: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ADOBEGLYPH;
    case ADSL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ADSL;
    case AFL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL1_1;
    case AFL1_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL1_2;
    case AFL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL2_0;
    case AFL2_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL2_1;
    case AFL3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL3_0;
    case AFMPARSE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFMPARSE;
    case AGPL1_0ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AGPL1_0ONLY;
    case AGPL1_0ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AGPL1_0ORLATER;
    case AGPL3_0ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AGPL3_0ONLY;
    case AGPL3_0ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AGPL3_0ORLATER;
    case ALADDIN: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ALADDIN;
    case AMDPLPA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AMDPLPA;
    case AML: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AML;
    case AMPAS: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AMPAS;
    case ANTLRPD: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ANTLRPD;
    case APACHE1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APACHE1_0;
    case APACHE1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APACHE1_1;
    case APACHE2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APACHE2_0;
    case APAFML: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APAFML;
    case APL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APL1_0;
    case APSL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APSL1_0;
    case APSL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APSL1_1;
    case APSL1_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APSL1_2;
    case APSL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APSL2_0;
    case ARTISTIC1_0CL8: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0CL8;
    case ARTISTIC1_0PERL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0PERL;
    case ARTISTIC1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0;
    case ARTISTIC2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ARTISTIC2_0;
    case BAHYPH: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BAHYPH;
    case BARR: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BARR;
    case BEERWARE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BEERWARE;
    case BITTORRENT1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BITTORRENT1_0;
    case BITTORRENT1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BITTORRENT1_1;
    case BORCEUX: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BORCEUX;
    case BSD1CLAUSE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD1CLAUSE;
    case BSD2CLAUSEFREEBSD: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD2CLAUSEFREEBSD;
    case BSD2CLAUSENETBSD: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD2CLAUSENETBSD;
    case BSD2CLAUSEPATENT: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD2CLAUSEPATENT;
    case BSD2CLAUSE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD2CLAUSE;
    case BSD3CLAUSEATTRIBUTION: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSEATTRIBUTION;
    case BSD3CLAUSECLEAR: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSECLEAR;
    case BSD3CLAUSELBNL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSELBNL;
    case BSD3CLAUSENONUCLEARLICENSE2014: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARLICENSE2014;
    case BSD3CLAUSENONUCLEARLICENSE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARLICENSE;
    case BSD3CLAUSENONUCLEARWARRANTY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARWARRANTY;
    case BSD3CLAUSE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSE;
    case BSD4CLAUSEUC: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD4CLAUSEUC;
    case BSD4CLAUSE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD4CLAUSE;
    case BSDPROTECTION: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSDPROTECTION;
    case BSDSOURCECODE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSDSOURCECODE;
    case BSL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSL1_0;
    case BZIP21_0_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BZIP21_0_5;
    case BZIP21_0_6: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BZIP21_0_6;
    case CALDERA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CALDERA;
    case CATOSL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CATOSL1_1;
    case CCBY1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY1_0;
    case CCBY2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY2_0;
    case CCBY2_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY2_5;
    case CCBY3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY3_0;
    case CCBY4_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY4_0;
    case CCBYNC1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC1_0;
    case CCBYNC2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC2_0;
    case CCBYNC2_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC2_5;
    case CCBYNC3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC3_0;
    case CCBYNC4_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC4_0;
    case CCBYNCND1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND1_0;
    case CCBYNCND2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND2_0;
    case CCBYNCND2_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND2_5;
    case CCBYNCND3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND3_0;
    case CCBYNCND4_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND4_0;
    case CCBYNCSA1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA1_0;
    case CCBYNCSA2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA2_0;
    case CCBYNCSA2_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA2_5;
    case CCBYNCSA3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA3_0;
    case CCBYNCSA4_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA4_0;
    case CCBYND1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND1_0;
    case CCBYND2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND2_0;
    case CCBYND2_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND2_5;
    case CCBYND3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND3_0;
    case CCBYND4_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND4_0;
    case CCBYSA1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA1_0;
    case CCBYSA2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA2_0;
    case CCBYSA2_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA2_5;
    case CCBYSA3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA3_0;
    case CCBYSA4_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA4_0;
    case CC01_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CC01_0;
    case CDDL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CDDL1_0;
    case CDDL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CDDL1_1;
    case CDLAPERMISSIVE1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CDLAPERMISSIVE1_0;
    case CDLASHARING1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CDLASHARING1_0;
    case CECILL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILL1_0;
    case CECILL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILL1_1;
    case CECILL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILL2_0;
    case CECILL2_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILL2_1;
    case CECILLB: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILLB;
    case CECILLC: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILLC;
    case CLARTISTIC: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CLARTISTIC;
    case CNRIJYTHON: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CNRIJYTHON;
    case CNRIPYTHONGPLCOMPATIBLE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CNRIPYTHONGPLCOMPATIBLE;
    case CNRIPYTHON: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CNRIPYTHON;
    case CONDOR1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CONDOR1_1;
    case CPAL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CPAL1_0;
    case CPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CPL1_0;
    case CPOL1_02: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CPOL1_02;
    case CROSSWORD: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CROSSWORD;
    case CRYSTALSTACKER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CRYSTALSTACKER;
    case CUAOPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CUAOPL1_0;
    case CUBE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CUBE;
    case CURL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CURL;
    case DFSL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DFSL1_0;
    case DIFFMARK: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DIFFMARK;
    case DOC: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DOC;
    case DOTSEQN: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DOTSEQN;
    case DSDP: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DSDP;
    case DVIPDFM: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DVIPDFM;
    case ECL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ECL1_0;
    case ECL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ECL2_0;
    case EFL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EFL1_0;
    case EFL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EFL2_0;
    case EGENIX: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EGENIX;
    case ENTESSA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ENTESSA;
    case EPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EPL1_0;
    case EPL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EPL2_0;
    case ERLPL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ERLPL1_1;
    case EUDATAGRID: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUDATAGRID;
    case EUPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUPL1_0;
    case EUPL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUPL1_1;
    case EUPL1_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUPL1_2;
    case EUROSYM: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUROSYM;
    case FAIR: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FAIR;
    case FRAMEWORX1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FRAMEWORX1_0;
    case FREEIMAGE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FREEIMAGE;
    case FSFAP: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FSFAP;
    case FSFUL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FSFUL;
    case FSFULLR: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FSFULLR;
    case FTL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FTL;
    case GFDL1_1ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_1ONLY;
    case GFDL1_1ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_1ORLATER;
    case GFDL1_2ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_2ONLY;
    case GFDL1_2ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_2ORLATER;
    case GFDL1_3ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_3ONLY;
    case GFDL1_3ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_3ORLATER;
    case GIFTWARE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GIFTWARE;
    case GL2PS: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GL2PS;
    case GLIDE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GLIDE;
    case GLULXE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GLULXE;
    case GNUPLOT: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GNUPLOT;
    case GPL1_0ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL1_0ONLY;
    case GPL1_0ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL1_0ORLATER;
    case GPL2_0ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL2_0ONLY;
    case GPL2_0ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL2_0ORLATER;
    case GPL3_0ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL3_0ONLY;
    case GPL3_0ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL3_0ORLATER;
    case GSOAP1_3B: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GSOAP1_3B;
    case HASKELLREPORT: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.HASKELLREPORT;
    case HPND: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.HPND;
    case IBMPIBS: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IBMPIBS;
    case ICU: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ICU;
    case IJG: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IJG;
    case IMAGEMAGICK: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IMAGEMAGICK;
    case IMATIX: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IMATIX;
    case IMLIB2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IMLIB2;
    case INFOZIP: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.INFOZIP;
    case INTELACPI: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.INTELACPI;
    case INTEL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.INTEL;
    case INTERBASE1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.INTERBASE1_0;
    case IPA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IPA;
    case IPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IPL1_0;
    case ISC: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ISC;
    case JASPER2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.JASPER2_0;
    case JSON: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.JSON;
    case LAL1_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LAL1_2;
    case LAL1_3: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LAL1_3;
    case LATEX2E: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LATEX2E;
    case LEPTONICA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LEPTONICA;
    case LGPL2_0ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL2_0ONLY;
    case LGPL2_0ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL2_0ORLATER;
    case LGPL2_1ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL2_1ONLY;
    case LGPL2_1ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL2_1ORLATER;
    case LGPL3_0ONLY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL3_0ONLY;
    case LGPL3_0ORLATER: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL3_0ORLATER;
    case LGPLLR: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPLLR;
    case LIBPNG: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LIBPNG;
    case LIBTIFF: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LIBTIFF;
    case LILIQP1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LILIQP1_1;
    case LILIQR1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LILIQR1_1;
    case LILIQRPLUS1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LILIQRPLUS1_1;
    case LINUXOPENIB: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LINUXOPENIB;
    case LPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPL1_0;
    case LPL1_02: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPL1_02;
    case LPPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_0;
    case LPPL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_1;
    case LPPL1_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_2;
    case LPPL1_3A: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_3A;
    case LPPL1_3C: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_3C;
    case MAKEINDEX: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MAKEINDEX;
    case MIROS: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MIROS;
    case MIT0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MIT0;
    case MITADVERTISING: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITADVERTISING;
    case MITCMU: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITCMU;
    case MITENNA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITENNA;
    case MITFEH: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITFEH;
    case MIT: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MIT;
    case MITNFA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITNFA;
    case MOTOSOTO: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MOTOSOTO;
    case MPICH2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPICH2;
    case MPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPL1_0;
    case MPL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPL1_1;
    case MPL2_0NOCOPYLEFTEXCEPTION: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPL2_0NOCOPYLEFTEXCEPTION;
    case MPL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPL2_0;
    case MSPL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MSPL;
    case MSRL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MSRL;
    case MTLL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MTLL;
    case MULTICS: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MULTICS;
    case MUP: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MUP;
    case NASA1_3: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NASA1_3;
    case NAUMEN: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NAUMEN;
    case NBPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NBPL1_0;
    case NCSA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NCSA;
    case NETSNMP: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NETSNMP;
    case NETCDF: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NETCDF;
    case NEWSLETR: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NEWSLETR;
    case NGPL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NGPL;
    case NLOD1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NLOD1_0;
    case NLPL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NLPL;
    case NOKIA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NOKIA;
    case NOSL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NOSL;
    case NOWEB: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NOWEB;
    case NPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NPL1_0;
    case NPL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NPL1_1;
    case NPOSL3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NPOSL3_0;
    case NRL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NRL;
    case NTP: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NTP;
    case OCCTPL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OCCTPL;
    case OCLC2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OCLC2_0;
    case ODBL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ODBL1_0;
    case OFL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OFL1_0;
    case OFL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OFL1_1;
    case OGTSL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OGTSL;
    case OLDAP1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP1_1;
    case OLDAP1_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP1_2;
    case OLDAP1_3: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP1_3;
    case OLDAP1_4: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP1_4;
    case OLDAP2_0_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_0_1;
    case OLDAP2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_0;
    case OLDAP2_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_1;
    case OLDAP2_2_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_2_1;
    case OLDAP2_2_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_2_2;
    case OLDAP2_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_2;
    case OLDAP2_3: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_3;
    case OLDAP2_4: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_4;
    case OLDAP2_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_5;
    case OLDAP2_6: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_6;
    case OLDAP2_7: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_7;
    case OLDAP2_8: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_8;
    case OML: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OML;
    case OPENSSL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OPENSSL;
    case OPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OPL1_0;
    case OSETPL2_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSETPL2_1;
    case OSL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL1_0;
    case OSL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL1_1;
    case OSL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL2_0;
    case OSL2_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL2_1;
    case OSL3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL3_0;
    case PDDL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PDDL1_0;
    case PHP3_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PHP3_0;
    case PHP3_01: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PHP3_01;
    case PLEXUS: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PLEXUS;
    case POSTGRESQL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.POSTGRESQL;
    case PSFRAG: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PSFRAG;
    case PSUTILS: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PSUTILS;
    case PYTHON2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PYTHON2_0;
    case QHULL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.QHULL;
    case QPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.QPL1_0;
    case RDISC: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RDISC;
    case RHECOS1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RHECOS1_1;
    case RPL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RPL1_1;
    case RPL1_5: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RPL1_5;
    case RPSL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RPSL1_0;
    case RSAMD: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RSAMD;
    case RSCPL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RSCPL;
    case RUBY: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RUBY;
    case SAXPD: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SAXPD;
    case SAXPATH: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SAXPATH;
    case SCEA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SCEA;
    case SENDMAIL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SENDMAIL;
    case SGIB1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SGIB1_0;
    case SGIB1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SGIB1_1;
    case SGIB2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SGIB2_0;
    case SIMPL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SIMPL2_0;
    case SISSL1_2: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SISSL1_2;
    case SISSL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SISSL;
    case SLEEPYCAT: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SLEEPYCAT;
    case SMLNJ: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SMLNJ;
    case SMPPL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SMPPL;
    case SNIA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SNIA;
    case SPENCER86: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SPENCER86;
    case SPENCER94: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SPENCER94;
    case SPENCER99: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SPENCER99;
    case SPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SPL1_0;
    case SUGARCRM1_1_3: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SUGARCRM1_1_3;
    case SWL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SWL;
    case TCL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TCL;
    case TCPWRAPPERS: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TCPWRAPPERS;
    case TMATE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TMATE;
    case TORQUE1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TORQUE1_1;
    case TOSL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TOSL;
    case UNICODEDFS2015: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UNICODEDFS2015;
    case UNICODEDFS2016: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UNICODEDFS2016;
    case UNICODETOU: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UNICODETOU;
    case UNLICENSE: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UNLICENSE;
    case UPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UPL1_0;
    case VIM: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.VIM;
    case VOSTROM: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.VOSTROM;
    case VSL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.VSL1_0;
    case W3C19980720: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.W3C19980720;
    case W3C20150513: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.W3C20150513;
    case W3C: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.W3C;
    case WATCOM1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.WATCOM1_0;
    case WSUIPA: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.WSUIPA;
    case WTFPL: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.WTFPL;
    case X11: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.X11;
    case XEROX: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XEROX;
    case XFREE861_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XFREE861_1;
    case XINETD: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XINETD;
    case XNET: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XNET;
    case XPP: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XPP;
    case XSKAT: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XSKAT;
    case YPL1_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.YPL1_0;
    case YPL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.YPL1_1;
    case ZED: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZED;
    case ZEND2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZEND2_0;
    case ZIMBRA1_3: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZIMBRA1_3;
    case ZIMBRA1_4: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZIMBRA1_4;
    case ZLIBACKNOWLEDGEMENT: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZLIBACKNOWLEDGEMENT;
    case ZLIB: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZLIB;
    case ZPL1_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZPL1_1;
    case ZPL2_0: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZPL2_0;
    case ZPL2_1: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZPL2_1;
    default: return org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense convertSPDXLicense(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTOPENSOURCE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NOTOPENSOURCE;
    case _0BSD: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense._0BSD;
    case AAL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AAL;
    case ABSTYLES: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ABSTYLES;
    case ADOBE2006: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ADOBE2006;
    case ADOBEGLYPH: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ADOBEGLYPH;
    case ADSL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ADSL;
    case AFL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AFL1_1;
    case AFL1_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AFL1_2;
    case AFL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AFL2_0;
    case AFL2_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AFL2_1;
    case AFL3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AFL3_0;
    case AFMPARSE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AFMPARSE;
    case AGPL1_0ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AGPL1_0ONLY;
    case AGPL1_0ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AGPL1_0ORLATER;
    case AGPL3_0ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AGPL3_0ONLY;
    case AGPL3_0ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AGPL3_0ORLATER;
    case ALADDIN: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ALADDIN;
    case AMDPLPA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AMDPLPA;
    case AML: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AML;
    case AMPAS: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.AMPAS;
    case ANTLRPD: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ANTLRPD;
    case APACHE1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APACHE1_0;
    case APACHE1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APACHE1_1;
    case APACHE2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APACHE2_0;
    case APAFML: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APAFML;
    case APL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APL1_0;
    case APSL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APSL1_0;
    case APSL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APSL1_1;
    case APSL1_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APSL1_2;
    case APSL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.APSL2_0;
    case ARTISTIC1_0CL8: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0CL8;
    case ARTISTIC1_0PERL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0PERL;
    case ARTISTIC1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0;
    case ARTISTIC2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ARTISTIC2_0;
    case BAHYPH: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BAHYPH;
    case BARR: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BARR;
    case BEERWARE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BEERWARE;
    case BITTORRENT1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BITTORRENT1_0;
    case BITTORRENT1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BITTORRENT1_1;
    case BORCEUX: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BORCEUX;
    case BSD1CLAUSE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD1CLAUSE;
    case BSD2CLAUSEFREEBSD: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD2CLAUSEFREEBSD;
    case BSD2CLAUSENETBSD: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD2CLAUSENETBSD;
    case BSD2CLAUSEPATENT: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD2CLAUSEPATENT;
    case BSD2CLAUSE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD2CLAUSE;
    case BSD3CLAUSEATTRIBUTION: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD3CLAUSEATTRIBUTION;
    case BSD3CLAUSECLEAR: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD3CLAUSECLEAR;
    case BSD3CLAUSELBNL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD3CLAUSELBNL;
    case BSD3CLAUSENONUCLEARLICENSE2014: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARLICENSE2014;
    case BSD3CLAUSENONUCLEARLICENSE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARLICENSE;
    case BSD3CLAUSENONUCLEARWARRANTY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARWARRANTY;
    case BSD3CLAUSE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD3CLAUSE;
    case BSD4CLAUSEUC: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD4CLAUSEUC;
    case BSD4CLAUSE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSD4CLAUSE;
    case BSDPROTECTION: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSDPROTECTION;
    case BSDSOURCECODE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSDSOURCECODE;
    case BSL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BSL1_0;
    case BZIP21_0_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BZIP21_0_5;
    case BZIP21_0_6: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.BZIP21_0_6;
    case CALDERA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CALDERA;
    case CATOSL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CATOSL1_1;
    case CCBY1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBY1_0;
    case CCBY2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBY2_0;
    case CCBY2_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBY2_5;
    case CCBY3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBY3_0;
    case CCBY4_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBY4_0;
    case CCBYNC1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNC1_0;
    case CCBYNC2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNC2_0;
    case CCBYNC2_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNC2_5;
    case CCBYNC3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNC3_0;
    case CCBYNC4_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNC4_0;
    case CCBYNCND1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCND1_0;
    case CCBYNCND2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCND2_0;
    case CCBYNCND2_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCND2_5;
    case CCBYNCND3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCND3_0;
    case CCBYNCND4_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCND4_0;
    case CCBYNCSA1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCSA1_0;
    case CCBYNCSA2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCSA2_0;
    case CCBYNCSA2_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCSA2_5;
    case CCBYNCSA3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCSA3_0;
    case CCBYNCSA4_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYNCSA4_0;
    case CCBYND1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYND1_0;
    case CCBYND2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYND2_0;
    case CCBYND2_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYND2_5;
    case CCBYND3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYND3_0;
    case CCBYND4_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYND4_0;
    case CCBYSA1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYSA1_0;
    case CCBYSA2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYSA2_0;
    case CCBYSA2_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYSA2_5;
    case CCBYSA3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYSA3_0;
    case CCBYSA4_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CCBYSA4_0;
    case CC01_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CC01_0;
    case CDDL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CDDL1_0;
    case CDDL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CDDL1_1;
    case CDLAPERMISSIVE1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CDLAPERMISSIVE1_0;
    case CDLASHARING1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CDLASHARING1_0;
    case CECILL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CECILL1_0;
    case CECILL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CECILL1_1;
    case CECILL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CECILL2_0;
    case CECILL2_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CECILL2_1;
    case CECILLB: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CECILLB;
    case CECILLC: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CECILLC;
    case CLARTISTIC: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CLARTISTIC;
    case CNRIJYTHON: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CNRIJYTHON;
    case CNRIPYTHONGPLCOMPATIBLE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CNRIPYTHONGPLCOMPATIBLE;
    case CNRIPYTHON: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CNRIPYTHON;
    case CONDOR1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CONDOR1_1;
    case CPAL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CPAL1_0;
    case CPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CPL1_0;
    case CPOL1_02: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CPOL1_02;
    case CROSSWORD: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CROSSWORD;
    case CRYSTALSTACKER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CRYSTALSTACKER;
    case CUAOPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CUAOPL1_0;
    case CUBE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CUBE;
    case CURL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.CURL;
    case DFSL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.DFSL1_0;
    case DIFFMARK: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.DIFFMARK;
    case DOC: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.DOC;
    case DOTSEQN: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.DOTSEQN;
    case DSDP: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.DSDP;
    case DVIPDFM: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.DVIPDFM;
    case ECL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ECL1_0;
    case ECL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ECL2_0;
    case EFL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EFL1_0;
    case EFL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EFL2_0;
    case EGENIX: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EGENIX;
    case ENTESSA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ENTESSA;
    case EPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EPL1_0;
    case EPL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EPL2_0;
    case ERLPL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ERLPL1_1;
    case EUDATAGRID: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EUDATAGRID;
    case EUPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EUPL1_0;
    case EUPL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EUPL1_1;
    case EUPL1_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EUPL1_2;
    case EUROSYM: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.EUROSYM;
    case FAIR: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.FAIR;
    case FRAMEWORX1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.FRAMEWORX1_0;
    case FREEIMAGE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.FREEIMAGE;
    case FSFAP: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.FSFAP;
    case FSFUL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.FSFUL;
    case FSFULLR: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.FSFULLR;
    case FTL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.FTL;
    case GFDL1_1ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GFDL1_1ONLY;
    case GFDL1_1ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GFDL1_1ORLATER;
    case GFDL1_2ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GFDL1_2ONLY;
    case GFDL1_2ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GFDL1_2ORLATER;
    case GFDL1_3ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GFDL1_3ONLY;
    case GFDL1_3ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GFDL1_3ORLATER;
    case GIFTWARE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GIFTWARE;
    case GL2PS: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GL2PS;
    case GLIDE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GLIDE;
    case GLULXE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GLULXE;
    case GNUPLOT: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GNUPLOT;
    case GPL1_0ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GPL1_0ONLY;
    case GPL1_0ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GPL1_0ORLATER;
    case GPL2_0ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GPL2_0ONLY;
    case GPL2_0ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GPL2_0ORLATER;
    case GPL3_0ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GPL3_0ONLY;
    case GPL3_0ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GPL3_0ORLATER;
    case GSOAP1_3B: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.GSOAP1_3B;
    case HASKELLREPORT: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.HASKELLREPORT;
    case HPND: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.HPND;
    case IBMPIBS: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.IBMPIBS;
    case ICU: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ICU;
    case IJG: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.IJG;
    case IMAGEMAGICK: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.IMAGEMAGICK;
    case IMATIX: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.IMATIX;
    case IMLIB2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.IMLIB2;
    case INFOZIP: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.INFOZIP;
    case INTELACPI: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.INTELACPI;
    case INTEL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.INTEL;
    case INTERBASE1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.INTERBASE1_0;
    case IPA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.IPA;
    case IPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.IPL1_0;
    case ISC: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ISC;
    case JASPER2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.JASPER2_0;
    case JSON: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.JSON;
    case LAL1_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LAL1_2;
    case LAL1_3: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LAL1_3;
    case LATEX2E: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LATEX2E;
    case LEPTONICA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LEPTONICA;
    case LGPL2_0ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LGPL2_0ONLY;
    case LGPL2_0ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LGPL2_0ORLATER;
    case LGPL2_1ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LGPL2_1ONLY;
    case LGPL2_1ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LGPL2_1ORLATER;
    case LGPL3_0ONLY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LGPL3_0ONLY;
    case LGPL3_0ORLATER: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LGPL3_0ORLATER;
    case LGPLLR: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LGPLLR;
    case LIBPNG: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LIBPNG;
    case LIBTIFF: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LIBTIFF;
    case LILIQP1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LILIQP1_1;
    case LILIQR1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LILIQR1_1;
    case LILIQRPLUS1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LILIQRPLUS1_1;
    case LINUXOPENIB: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LINUXOPENIB;
    case LPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LPL1_0;
    case LPL1_02: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LPL1_02;
    case LPPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LPPL1_0;
    case LPPL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LPPL1_1;
    case LPPL1_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LPPL1_2;
    case LPPL1_3A: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LPPL1_3A;
    case LPPL1_3C: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.LPPL1_3C;
    case MAKEINDEX: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MAKEINDEX;
    case MIROS: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MIROS;
    case MIT0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MIT0;
    case MITADVERTISING: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MITADVERTISING;
    case MITCMU: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MITCMU;
    case MITENNA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MITENNA;
    case MITFEH: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MITFEH;
    case MIT: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MIT;
    case MITNFA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MITNFA;
    case MOTOSOTO: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MOTOSOTO;
    case MPICH2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MPICH2;
    case MPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MPL1_0;
    case MPL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MPL1_1;
    case MPL2_0NOCOPYLEFTEXCEPTION: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MPL2_0NOCOPYLEFTEXCEPTION;
    case MPL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MPL2_0;
    case MSPL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MSPL;
    case MSRL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MSRL;
    case MTLL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MTLL;
    case MULTICS: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MULTICS;
    case MUP: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.MUP;
    case NASA1_3: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NASA1_3;
    case NAUMEN: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NAUMEN;
    case NBPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NBPL1_0;
    case NCSA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NCSA;
    case NETSNMP: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NETSNMP;
    case NETCDF: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NETCDF;
    case NEWSLETR: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NEWSLETR;
    case NGPL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NGPL;
    case NLOD1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NLOD1_0;
    case NLPL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NLPL;
    case NOKIA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NOKIA;
    case NOSL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NOSL;
    case NOWEB: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NOWEB;
    case NPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NPL1_0;
    case NPL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NPL1_1;
    case NPOSL3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NPOSL3_0;
    case NRL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NRL;
    case NTP: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NTP;
    case OCCTPL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OCCTPL;
    case OCLC2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OCLC2_0;
    case ODBL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ODBL1_0;
    case OFL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OFL1_0;
    case OFL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OFL1_1;
    case OGTSL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OGTSL;
    case OLDAP1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP1_1;
    case OLDAP1_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP1_2;
    case OLDAP1_3: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP1_3;
    case OLDAP1_4: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP1_4;
    case OLDAP2_0_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_0_1;
    case OLDAP2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_0;
    case OLDAP2_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_1;
    case OLDAP2_2_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_2_1;
    case OLDAP2_2_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_2_2;
    case OLDAP2_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_2;
    case OLDAP2_3: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_3;
    case OLDAP2_4: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_4;
    case OLDAP2_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_5;
    case OLDAP2_6: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_6;
    case OLDAP2_7: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_7;
    case OLDAP2_8: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OLDAP2_8;
    case OML: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OML;
    case OPENSSL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OPENSSL;
    case OPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OPL1_0;
    case OSETPL2_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OSETPL2_1;
    case OSL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OSL1_0;
    case OSL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OSL1_1;
    case OSL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OSL2_0;
    case OSL2_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OSL2_1;
    case OSL3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.OSL3_0;
    case PDDL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.PDDL1_0;
    case PHP3_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.PHP3_0;
    case PHP3_01: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.PHP3_01;
    case PLEXUS: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.PLEXUS;
    case POSTGRESQL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.POSTGRESQL;
    case PSFRAG: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.PSFRAG;
    case PSUTILS: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.PSUTILS;
    case PYTHON2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.PYTHON2_0;
    case QHULL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.QHULL;
    case QPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.QPL1_0;
    case RDISC: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.RDISC;
    case RHECOS1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.RHECOS1_1;
    case RPL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.RPL1_1;
    case RPL1_5: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.RPL1_5;
    case RPSL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.RPSL1_0;
    case RSAMD: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.RSAMD;
    case RSCPL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.RSCPL;
    case RUBY: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.RUBY;
    case SAXPD: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SAXPD;
    case SAXPATH: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SAXPATH;
    case SCEA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SCEA;
    case SENDMAIL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SENDMAIL;
    case SGIB1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SGIB1_0;
    case SGIB1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SGIB1_1;
    case SGIB2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SGIB2_0;
    case SIMPL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SIMPL2_0;
    case SISSL1_2: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SISSL1_2;
    case SISSL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SISSL;
    case SLEEPYCAT: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SLEEPYCAT;
    case SMLNJ: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SMLNJ;
    case SMPPL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SMPPL;
    case SNIA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SNIA;
    case SPENCER86: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SPENCER86;
    case SPENCER94: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SPENCER94;
    case SPENCER99: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SPENCER99;
    case SPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SPL1_0;
    case SUGARCRM1_1_3: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SUGARCRM1_1_3;
    case SWL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.SWL;
    case TCL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.TCL;
    case TCPWRAPPERS: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.TCPWRAPPERS;
    case TMATE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.TMATE;
    case TORQUE1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.TORQUE1_1;
    case TOSL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.TOSL;
    case UNICODEDFS2015: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.UNICODEDFS2015;
    case UNICODEDFS2016: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.UNICODEDFS2016;
    case UNICODETOU: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.UNICODETOU;
    case UNLICENSE: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.UNLICENSE;
    case UPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.UPL1_0;
    case VIM: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.VIM;
    case VOSTROM: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.VOSTROM;
    case VSL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.VSL1_0;
    case W3C19980720: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.W3C19980720;
    case W3C20150513: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.W3C20150513;
    case W3C: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.W3C;
    case WATCOM1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.WATCOM1_0;
    case WSUIPA: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.WSUIPA;
    case WTFPL: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.WTFPL;
    case X11: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.X11;
    case XEROX: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.XEROX;
    case XFREE861_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.XFREE861_1;
    case XINETD: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.XINETD;
    case XNET: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.XNET;
    case XPP: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.XPP;
    case XSKAT: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.XSKAT;
    case YPL1_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.YPL1_0;
    case YPL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.YPL1_1;
    case ZED: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZED;
    case ZEND2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZEND2_0;
    case ZIMBRA1_3: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZIMBRA1_3;
    case ZIMBRA1_4: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZIMBRA1_4;
    case ZLIBACKNOWLEDGEMENT: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZLIBACKNOWLEDGEMENT;
    case ZLIB: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZLIB;
    case ZPL1_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZPL1_1;
    case ZPL2_0: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZPL2_0;
    case ZPL2_1: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.ZPL2_1;
    default: return org.hl7.fhir.r4.model.ImplementationGuide.SPDXLicense.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    copyElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    copyElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.FHIRVersion> t : src.getFhirVersion())
      tgt.addFhirVersion(Enumerations.convertFHIRVersion(t.getValue()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasExample())
      tgt.setExample(convertType(src.getExample()));
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> t : src.getFhirVersion())
      tgt.addFhirVersion(Enumerations.convertFHIRVersion(t.getValue()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasExample())
      tgt.setExample(convertType(src.getExample()));
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setName(convertType(src.getName()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGeneration(convertGuidePageGeneration(src.getGeneration()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setName(convertType(src.getName()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGeneration(convertGuidePageGeneration(src.getGeneration()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration convertGuidePageGeneration(org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case HTML: return org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.HTML;
    case MARKDOWN: return org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.MARKDOWN;
    case XML: return org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.XML;
    case GENERATED: return org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.GENERATED;
    default: return org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration convertGuidePageGeneration(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case HTML: return org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.HTML;
    case MARKDOWN: return org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.MARKDOWN;
    case XML: return org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.XML;
    case GENERATED: return org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.GENERATED;
    default: return org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertGuideParameterCode(src.getCode()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertGuideParameterCode(src.getCode()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode convertGuideParameterCode(org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case APPLY: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.APPLY;
    case PATHRESOURCE: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.PATHRESOURCE;
    case PATHPAGES: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.PATHPAGES;
    case PATHTXCACHE: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.PATHTXCACHE;
    case EXPANSIONPARAMETER: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.EXPANSIONPARAMETER;
    case RULEBROKENLINKS: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.RULEBROKENLINKS;
    case GENERATEXML: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.GENERATEXML;
    case GENERATEJSON: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.GENERATEJSON;
    case GENERATETURTLE: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.GENERATETURTLE;
    case HTMLTEMPLATE: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.HTMLTEMPLATE;
    default: return org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode convertGuideParameterCode(org.hl7.fhir.r5.model.ImplementationGuide.GuideParameterCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case APPLY: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.APPLY;
    case PATHRESOURCE: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.PATHRESOURCE;
    case PATHPAGES: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.PATHPAGES;
    case PATHTXCACHE: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.PATHTXCACHE;
    case EXPANSIONPARAMETER: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.EXPANSIONPARAMETER;
    case RULEBROKENLINKS: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.RULEBROKENLINKS;
    case GENERATEXML: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.GENERATEXML;
    case GENERATEJSON: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.GENERATEJSON;
    case GENERATETURTLE: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.GENERATETURTLE;
    case HTMLTEMPLATE: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.HTMLTEMPLATE;
    default: return org.hl7.fhir.r4.model.ImplementationGuide.GuideParameterCode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent();
    copyElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getImage())
      tgt.getImage().add(convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getOther())
      tgt.getOther().add(convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideManifestComponent();
    copyElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getImage())
      tgt.getImage().add(convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getOther())
      tgt.getOther().add(convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent();
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    if (src.hasExample())
      tgt.setExample(convertType(src.getExample()));
    if (src.hasRelativePath())
      tgt.setRelativePathElement(convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ManifestResourceComponent();
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    if (src.hasExample())
      tgt.setExample(convertType(src.getExample()));
    if (src.hasRelativePath())
      tgt.setRelativePathElement(convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAnchor())
      tgt.getAnchor().add(convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ManifestPageComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAnchor())
      tgt.getAnchor().add(convertString(t));
    return tgt;
  }


}
