package org.hl7.fhir.convertors.conv43_50.resources43_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Id43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Url43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

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
public class ImplementationGuide43_50 {

  static final String EXT_IG_DEFINITION_PARAMETER = "http://hl7.org/fhir/tools/StructureDefinition/ig-parameter";

  public static org.hl7.fhir.r5.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4b.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide tgt = new org.hl7.fhir.r5.model.ImplementationGuide();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_50.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations43_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn())
      tgt.addDependsOn(convertImplementationGuideDependsOnComponent(t));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasDefinition())
      tgt.setDefinition(convertImplementationGuideDefinitionComponent(src.getDefinition()));
    if (src.hasManifest())
      tgt.setManifest(convertImplementationGuideManifestComponent(src.getManifest()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r5.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide tgt = new org.hl7.fhir.r4b.model.ImplementationGuide();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_50.convertId(src.getPackageIdElement()));
    if (src.hasLicense())
      tgt.setLicenseElement(convertSPDXLicense(src.getLicenseElement()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations43_50::convertFHIRVersion)
      .collect(Collectors.toList()));
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTOPENSOURCE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NOTOPENSOURCE);
        break;
      case _0BSD:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense._0BSD);
        break;
      case AAL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AAL);
        break;
      case ABSTYLES:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ABSTYLES);
        break;
      case ADOBE2006:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ADOBE2006);
        break;
      case ADOBEGLYPH:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ADOBEGLYPH);
        break;
      case ADSL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ADSL);
        break;
      case AFL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL1_1);
        break;
      case AFL1_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL1_2);
        break;
      case AFL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL2_0);
        break;
      case AFL2_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL2_1);
        break;
      case AFL3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFL3_0);
        break;
      case AFMPARSE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AFMPARSE);
        break;
      case AGPL1_0ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AGPL1_0ONLY);
        break;
      case AGPL1_0ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AGPL1_0ORLATER);
        break;
      case AGPL3_0ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AGPL3_0ONLY);
        break;
      case AGPL3_0ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AGPL3_0ORLATER);
        break;
      case ALADDIN:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ALADDIN);
        break;
      case AMDPLPA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AMDPLPA);
        break;
      case AML:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AML);
        break;
      case AMPAS:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.AMPAS);
        break;
      case ANTLRPD:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ANTLRPD);
        break;
      case APACHE1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APACHE1_0);
        break;
      case APACHE1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APACHE1_1);
        break;
      case APACHE2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APACHE2_0);
        break;
      case APAFML:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APAFML);
        break;
      case APL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APL1_0);
        break;
      case APSL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APSL1_0);
        break;
      case APSL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APSL1_1);
        break;
      case APSL1_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APSL1_2);
        break;
      case APSL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.APSL2_0);
        break;
      case ARTISTIC1_0CL8:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0CL8);
        break;
      case ARTISTIC1_0PERL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0PERL);
        break;
      case ARTISTIC1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0);
        break;
      case ARTISTIC2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ARTISTIC2_0);
        break;
      case BAHYPH:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BAHYPH);
        break;
      case BARR:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BARR);
        break;
      case BEERWARE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BEERWARE);
        break;
      case BITTORRENT1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BITTORRENT1_0);
        break;
      case BITTORRENT1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BITTORRENT1_1);
        break;
      case BORCEUX:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BORCEUX);
        break;
      case BSD1CLAUSE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD1CLAUSE);
        break;
      case BSD2CLAUSEFREEBSD:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD2CLAUSEFREEBSD);
        break;
      case BSD2CLAUSENETBSD:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD2CLAUSENETBSD);
        break;
      case BSD2CLAUSEPATENT:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD2CLAUSEPATENT);
        break;
      case BSD2CLAUSE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD2CLAUSE);
        break;
      case BSD3CLAUSEATTRIBUTION:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSEATTRIBUTION);
        break;
      case BSD3CLAUSECLEAR:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSECLEAR);
        break;
      case BSD3CLAUSELBNL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSELBNL);
        break;
      case BSD3CLAUSENONUCLEARLICENSE2014:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARLICENSE2014);
        break;
      case BSD3CLAUSENONUCLEARLICENSE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARLICENSE);
        break;
      case BSD3CLAUSENONUCLEARWARRANTY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARWARRANTY);
        break;
      case BSD3CLAUSE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD3CLAUSE);
        break;
      case BSD4CLAUSEUC:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD4CLAUSEUC);
        break;
      case BSD4CLAUSE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSD4CLAUSE);
        break;
      case BSDPROTECTION:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSDPROTECTION);
        break;
      case BSDSOURCECODE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSDSOURCECODE);
        break;
      case BSL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BSL1_0);
        break;
      case BZIP21_0_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BZIP21_0_5);
        break;
      case BZIP21_0_6:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.BZIP21_0_6);
        break;
      case CALDERA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CALDERA);
        break;
      case CATOSL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CATOSL1_1);
        break;
      case CCBY1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY1_0);
        break;
      case CCBY2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY2_0);
        break;
      case CCBY2_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY2_5);
        break;
      case CCBY3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY3_0);
        break;
      case CCBY4_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBY4_0);
        break;
      case CCBYNC1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC1_0);
        break;
      case CCBYNC2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC2_0);
        break;
      case CCBYNC2_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC2_5);
        break;
      case CCBYNC3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC3_0);
        break;
      case CCBYNC4_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNC4_0);
        break;
      case CCBYNCND1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND1_0);
        break;
      case CCBYNCND2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND2_0);
        break;
      case CCBYNCND2_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND2_5);
        break;
      case CCBYNCND3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND3_0);
        break;
      case CCBYNCND4_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCND4_0);
        break;
      case CCBYNCSA1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA1_0);
        break;
      case CCBYNCSA2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA2_0);
        break;
      case CCBYNCSA2_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA2_5);
        break;
      case CCBYNCSA3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA3_0);
        break;
      case CCBYNCSA4_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYNCSA4_0);
        break;
      case CCBYND1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND1_0);
        break;
      case CCBYND2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND2_0);
        break;
      case CCBYND2_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND2_5);
        break;
      case CCBYND3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND3_0);
        break;
      case CCBYND4_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYND4_0);
        break;
      case CCBYSA1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA1_0);
        break;
      case CCBYSA2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA2_0);
        break;
      case CCBYSA2_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA2_5);
        break;
      case CCBYSA3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA3_0);
        break;
      case CCBYSA4_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CCBYSA4_0);
        break;
      case CC01_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CC01_0);
        break;
      case CDDL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CDDL1_0);
        break;
      case CDDL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CDDL1_1);
        break;
      case CDLAPERMISSIVE1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CDLAPERMISSIVE1_0);
        break;
      case CDLASHARING1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CDLASHARING1_0);
        break;
      case CECILL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILL1_0);
        break;
      case CECILL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILL1_1);
        break;
      case CECILL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILL2_0);
        break;
      case CECILL2_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILL2_1);
        break;
      case CECILLB:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILLB);
        break;
      case CECILLC:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CECILLC);
        break;
      case CLARTISTIC:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CLARTISTIC);
        break;
      case CNRIJYTHON:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CNRIJYTHON);
        break;
      case CNRIPYTHONGPLCOMPATIBLE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CNRIPYTHONGPLCOMPATIBLE);
        break;
      case CNRIPYTHON:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CNRIPYTHON);
        break;
      case CONDOR1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CONDOR1_1);
        break;
      case CPAL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CPAL1_0);
        break;
      case CPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CPL1_0);
        break;
      case CPOL1_02:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CPOL1_02);
        break;
      case CROSSWORD:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CROSSWORD);
        break;
      case CRYSTALSTACKER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CRYSTALSTACKER);
        break;
      case CUAOPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CUAOPL1_0);
        break;
      case CUBE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CUBE);
        break;
      case CURL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.CURL);
        break;
      case DFSL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DFSL1_0);
        break;
      case DIFFMARK:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DIFFMARK);
        break;
      case DOC:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DOC);
        break;
      case DOTSEQN:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DOTSEQN);
        break;
      case DSDP:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DSDP);
        break;
      case DVIPDFM:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.DVIPDFM);
        break;
      case ECL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ECL1_0);
        break;
      case ECL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ECL2_0);
        break;
      case EFL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EFL1_0);
        break;
      case EFL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EFL2_0);
        break;
      case EGENIX:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EGENIX);
        break;
      case ENTESSA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ENTESSA);
        break;
      case EPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EPL1_0);
        break;
      case EPL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EPL2_0);
        break;
      case ERLPL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ERLPL1_1);
        break;
      case EUDATAGRID:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUDATAGRID);
        break;
      case EUPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUPL1_0);
        break;
      case EUPL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUPL1_1);
        break;
      case EUPL1_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUPL1_2);
        break;
      case EUROSYM:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.EUROSYM);
        break;
      case FAIR:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FAIR);
        break;
      case FRAMEWORX1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FRAMEWORX1_0);
        break;
      case FREEIMAGE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FREEIMAGE);
        break;
      case FSFAP:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FSFAP);
        break;
      case FSFUL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FSFUL);
        break;
      case FSFULLR:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FSFULLR);
        break;
      case FTL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.FTL);
        break;
      case GFDL1_1ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_1ONLY);
        break;
      case GFDL1_1ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_1ORLATER);
        break;
      case GFDL1_2ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_2ONLY);
        break;
      case GFDL1_2ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_2ORLATER);
        break;
      case GFDL1_3ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_3ONLY);
        break;
      case GFDL1_3ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GFDL1_3ORLATER);
        break;
      case GIFTWARE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GIFTWARE);
        break;
      case GL2PS:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GL2PS);
        break;
      case GLIDE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GLIDE);
        break;
      case GLULXE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GLULXE);
        break;
      case GNUPLOT:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GNUPLOT);
        break;
      case GPL1_0ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL1_0ONLY);
        break;
      case GPL1_0ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL1_0ORLATER);
        break;
      case GPL2_0ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL2_0ONLY);
        break;
      case GPL2_0ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL2_0ORLATER);
        break;
      case GPL3_0ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL3_0ONLY);
        break;
      case GPL3_0ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GPL3_0ORLATER);
        break;
      case GSOAP1_3B:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.GSOAP1_3B);
        break;
      case HASKELLREPORT:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.HASKELLREPORT);
        break;
      case HPND:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.HPND);
        break;
      case IBMPIBS:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IBMPIBS);
        break;
      case ICU:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ICU);
        break;
      case IJG:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IJG);
        break;
      case IMAGEMAGICK:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IMAGEMAGICK);
        break;
      case IMATIX:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IMATIX);
        break;
      case IMLIB2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IMLIB2);
        break;
      case INFOZIP:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.INFOZIP);
        break;
      case INTELACPI:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.INTELACPI);
        break;
      case INTEL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.INTEL);
        break;
      case INTERBASE1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.INTERBASE1_0);
        break;
      case IPA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IPA);
        break;
      case IPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.IPL1_0);
        break;
      case ISC:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ISC);
        break;
      case JASPER2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.JASPER2_0);
        break;
      case JSON:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.JSON);
        break;
      case LAL1_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LAL1_2);
        break;
      case LAL1_3:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LAL1_3);
        break;
      case LATEX2E:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LATEX2E);
        break;
      case LEPTONICA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LEPTONICA);
        break;
      case LGPL2_0ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL2_0ONLY);
        break;
      case LGPL2_0ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL2_0ORLATER);
        break;
      case LGPL2_1ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL2_1ONLY);
        break;
      case LGPL2_1ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL2_1ORLATER);
        break;
      case LGPL3_0ONLY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL3_0ONLY);
        break;
      case LGPL3_0ORLATER:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPL3_0ORLATER);
        break;
      case LGPLLR:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LGPLLR);
        break;
      case LIBPNG:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LIBPNG);
        break;
      case LIBTIFF:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LIBTIFF);
        break;
      case LILIQP1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LILIQP1_1);
        break;
      case LILIQR1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LILIQR1_1);
        break;
      case LILIQRPLUS1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LILIQRPLUS1_1);
        break;
      case LINUXOPENIB:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LINUXOPENIB);
        break;
      case LPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPL1_0);
        break;
      case LPL1_02:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPL1_02);
        break;
      case LPPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_0);
        break;
      case LPPL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_1);
        break;
      case LPPL1_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_2);
        break;
      case LPPL1_3A:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_3A);
        break;
      case LPPL1_3C:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.LPPL1_3C);
        break;
      case MAKEINDEX:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MAKEINDEX);
        break;
      case MIROS:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MIROS);
        break;
      case MIT0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MIT0);
        break;
      case MITADVERTISING:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITADVERTISING);
        break;
      case MITCMU:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITCMU);
        break;
      case MITENNA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITENNA);
        break;
      case MITFEH:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITFEH);
        break;
      case MIT:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MIT);
        break;
      case MITNFA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MITNFA);
        break;
      case MOTOSOTO:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MOTOSOTO);
        break;
      case MPICH2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPICH2);
        break;
      case MPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPL1_0);
        break;
      case MPL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPL1_1);
        break;
      case MPL2_0NOCOPYLEFTEXCEPTION:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPL2_0NOCOPYLEFTEXCEPTION);
        break;
      case MPL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MPL2_0);
        break;
      case MSPL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MSPL);
        break;
      case MSRL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MSRL);
        break;
      case MTLL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MTLL);
        break;
      case MULTICS:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MULTICS);
        break;
      case MUP:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.MUP);
        break;
      case NASA1_3:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NASA1_3);
        break;
      case NAUMEN:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NAUMEN);
        break;
      case NBPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NBPL1_0);
        break;
      case NCSA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NCSA);
        break;
      case NETSNMP:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NETSNMP);
        break;
      case NETCDF:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NETCDF);
        break;
      case NEWSLETR:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NEWSLETR);
        break;
      case NGPL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NGPL);
        break;
      case NLOD1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NLOD1_0);
        break;
      case NLPL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NLPL);
        break;
      case NOKIA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NOKIA);
        break;
      case NOSL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NOSL);
        break;
      case NOWEB:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NOWEB);
        break;
      case NPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NPL1_0);
        break;
      case NPL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NPL1_1);
        break;
      case NPOSL3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NPOSL3_0);
        break;
      case NRL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NRL);
        break;
      case NTP:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NTP);
        break;
      case OCCTPL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OCCTPL);
        break;
      case OCLC2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OCLC2_0);
        break;
      case ODBL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ODBL1_0);
        break;
      case OFL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OFL1_0);
        break;
      case OFL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OFL1_1);
        break;
      case OGTSL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OGTSL);
        break;
      case OLDAP1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP1_1);
        break;
      case OLDAP1_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP1_2);
        break;
      case OLDAP1_3:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP1_3);
        break;
      case OLDAP1_4:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP1_4);
        break;
      case OLDAP2_0_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_0_1);
        break;
      case OLDAP2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_0);
        break;
      case OLDAP2_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_1);
        break;
      case OLDAP2_2_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_2_1);
        break;
      case OLDAP2_2_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_2_2);
        break;
      case OLDAP2_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_2);
        break;
      case OLDAP2_3:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_3);
        break;
      case OLDAP2_4:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_4);
        break;
      case OLDAP2_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_5);
        break;
      case OLDAP2_6:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_6);
        break;
      case OLDAP2_7:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_7);
        break;
      case OLDAP2_8:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OLDAP2_8);
        break;
      case OML:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OML);
        break;
      case OPENSSL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OPENSSL);
        break;
      case OPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OPL1_0);
        break;
      case OSETPL2_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSETPL2_1);
        break;
      case OSL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL1_0);
        break;
      case OSL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL1_1);
        break;
      case OSL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL2_0);
        break;
      case OSL2_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL2_1);
        break;
      case OSL3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.OSL3_0);
        break;
      case PDDL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PDDL1_0);
        break;
      case PHP3_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PHP3_0);
        break;
      case PHP3_01:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PHP3_01);
        break;
      case PLEXUS:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PLEXUS);
        break;
      case POSTGRESQL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.POSTGRESQL);
        break;
      case PSFRAG:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PSFRAG);
        break;
      case PSUTILS:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PSUTILS);
        break;
      case PYTHON2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.PYTHON2_0);
        break;
      case QHULL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.QHULL);
        break;
      case QPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.QPL1_0);
        break;
      case RDISC:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RDISC);
        break;
      case RHECOS1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RHECOS1_1);
        break;
      case RPL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RPL1_1);
        break;
      case RPL1_5:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RPL1_5);
        break;
      case RPSL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RPSL1_0);
        break;
      case RSAMD:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RSAMD);
        break;
      case RSCPL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RSCPL);
        break;
      case RUBY:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.RUBY);
        break;
      case SAXPD:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SAXPD);
        break;
      case SAXPATH:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SAXPATH);
        break;
      case SCEA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SCEA);
        break;
      case SENDMAIL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SENDMAIL);
        break;
      case SGIB1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SGIB1_0);
        break;
      case SGIB1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SGIB1_1);
        break;
      case SGIB2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SGIB2_0);
        break;
      case SIMPL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SIMPL2_0);
        break;
      case SISSL1_2:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SISSL1_2);
        break;
      case SISSL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SISSL);
        break;
      case SLEEPYCAT:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SLEEPYCAT);
        break;
      case SMLNJ:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SMLNJ);
        break;
      case SMPPL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SMPPL);
        break;
      case SNIA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SNIA);
        break;
      case SPENCER86:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SPENCER86);
        break;
      case SPENCER94:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SPENCER94);
        break;
      case SPENCER99:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SPENCER99);
        break;
      case SPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SPL1_0);
        break;
      case SUGARCRM1_1_3:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SUGARCRM1_1_3);
        break;
      case SWL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.SWL);
        break;
      case TCL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TCL);
        break;
      case TCPWRAPPERS:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TCPWRAPPERS);
        break;
      case TMATE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TMATE);
        break;
      case TORQUE1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TORQUE1_1);
        break;
      case TOSL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.TOSL);
        break;
      case UNICODEDFS2015:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UNICODEDFS2015);
        break;
      case UNICODEDFS2016:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UNICODEDFS2016);
        break;
      case UNICODETOU:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UNICODETOU);
        break;
      case UNLICENSE:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UNLICENSE);
        break;
      case UPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.UPL1_0);
        break;
      case VIM:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.VIM);
        break;
      case VOSTROM:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.VOSTROM);
        break;
      case VSL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.VSL1_0);
        break;
      case W3C19980720:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.W3C19980720);
        break;
      case W3C20150513:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.W3C20150513);
        break;
      case W3C:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.W3C);
        break;
      case WATCOM1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.WATCOM1_0);
        break;
      case WSUIPA:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.WSUIPA);
        break;
      case WTFPL:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.WTFPL);
        break;
      case X11:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.X11);
        break;
      case XEROX:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XEROX);
        break;
      case XFREE861_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XFREE861_1);
        break;
      case XINETD:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XINETD);
        break;
      case XNET:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XNET);
        break;
      case XPP:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XPP);
        break;
      case XSKAT:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.XSKAT);
        break;
      case YPL1_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.YPL1_0);
        break;
      case YPL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.YPL1_1);
        break;
      case ZED:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZED);
        break;
      case ZEND2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZEND2_0);
        break;
      case ZIMBRA1_3:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZIMBRA1_3);
        break;
      case ZIMBRA1_4:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZIMBRA1_4);
        break;
      case ZLIBACKNOWLEDGEMENT:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZLIBACKNOWLEDGEMENT);
        break;
      case ZLIB:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZLIB);
        break;
      case ZPL1_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZPL1_1);
        break;
      case ZPL2_0:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZPL2_0);
        break;
      case ZPL2_1:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.ZPL2_1);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> convertSPDXLicense(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicenseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTOPENSOURCE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NOTOPENSOURCE);
        break;
      case _0BSD:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense._0BSD);
        break;
      case AAL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AAL);
        break;
      case ABSTYLES:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ABSTYLES);
        break;
      case ADOBE2006:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ADOBE2006);
        break;
      case ADOBEGLYPH:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ADOBEGLYPH);
        break;
      case ADSL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ADSL);
        break;
      case AFL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AFL1_1);
        break;
      case AFL1_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AFL1_2);
        break;
      case AFL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AFL2_0);
        break;
      case AFL2_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AFL2_1);
        break;
      case AFL3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AFL3_0);
        break;
      case AFMPARSE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AFMPARSE);
        break;
      case AGPL1_0ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AGPL1_0ONLY);
        break;
      case AGPL1_0ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AGPL1_0ORLATER);
        break;
      case AGPL3_0ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AGPL3_0ONLY);
        break;
      case AGPL3_0ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AGPL3_0ORLATER);
        break;
      case ALADDIN:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ALADDIN);
        break;
      case AMDPLPA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AMDPLPA);
        break;
      case AML:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AML);
        break;
      case AMPAS:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.AMPAS);
        break;
      case ANTLRPD:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ANTLRPD);
        break;
      case APACHE1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APACHE1_0);
        break;
      case APACHE1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APACHE1_1);
        break;
      case APACHE2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APACHE2_0);
        break;
      case APAFML:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APAFML);
        break;
      case APL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APL1_0);
        break;
      case APSL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APSL1_0);
        break;
      case APSL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APSL1_1);
        break;
      case APSL1_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APSL1_2);
        break;
      case APSL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.APSL2_0);
        break;
      case ARTISTIC1_0CL8:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0CL8);
        break;
      case ARTISTIC1_0PERL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0PERL);
        break;
      case ARTISTIC1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ARTISTIC1_0);
        break;
      case ARTISTIC2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ARTISTIC2_0);
        break;
      case BAHYPH:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BAHYPH);
        break;
      case BARR:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BARR);
        break;
      case BEERWARE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BEERWARE);
        break;
      case BITTORRENT1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BITTORRENT1_0);
        break;
      case BITTORRENT1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BITTORRENT1_1);
        break;
      case BORCEUX:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BORCEUX);
        break;
      case BSD1CLAUSE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD1CLAUSE);
        break;
      case BSD2CLAUSEFREEBSD:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD2CLAUSEFREEBSD);
        break;
      case BSD2CLAUSENETBSD:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD2CLAUSENETBSD);
        break;
      case BSD2CLAUSEPATENT:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD2CLAUSEPATENT);
        break;
      case BSD2CLAUSE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD2CLAUSE);
        break;
      case BSD3CLAUSEATTRIBUTION:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD3CLAUSEATTRIBUTION);
        break;
      case BSD3CLAUSECLEAR:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD3CLAUSECLEAR);
        break;
      case BSD3CLAUSELBNL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD3CLAUSELBNL);
        break;
      case BSD3CLAUSENONUCLEARLICENSE2014:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARLICENSE2014);
        break;
      case BSD3CLAUSENONUCLEARLICENSE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARLICENSE);
        break;
      case BSD3CLAUSENONUCLEARWARRANTY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD3CLAUSENONUCLEARWARRANTY);
        break;
      case BSD3CLAUSE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD3CLAUSE);
        break;
      case BSD4CLAUSEUC:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD4CLAUSEUC);
        break;
      case BSD4CLAUSE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSD4CLAUSE);
        break;
      case BSDPROTECTION:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSDPROTECTION);
        break;
      case BSDSOURCECODE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSDSOURCECODE);
        break;
      case BSL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BSL1_0);
        break;
      case BZIP21_0_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BZIP21_0_5);
        break;
      case BZIP21_0_6:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.BZIP21_0_6);
        break;
      case CALDERA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CALDERA);
        break;
      case CATOSL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CATOSL1_1);
        break;
      case CCBY1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBY1_0);
        break;
      case CCBY2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBY2_0);
        break;
      case CCBY2_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBY2_5);
        break;
      case CCBY3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBY3_0);
        break;
      case CCBY4_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBY4_0);
        break;
      case CCBYNC1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNC1_0);
        break;
      case CCBYNC2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNC2_0);
        break;
      case CCBYNC2_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNC2_5);
        break;
      case CCBYNC3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNC3_0);
        break;
      case CCBYNC4_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNC4_0);
        break;
      case CCBYNCND1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCND1_0);
        break;
      case CCBYNCND2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCND2_0);
        break;
      case CCBYNCND2_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCND2_5);
        break;
      case CCBYNCND3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCND3_0);
        break;
      case CCBYNCND4_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCND4_0);
        break;
      case CCBYNCSA1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCSA1_0);
        break;
      case CCBYNCSA2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCSA2_0);
        break;
      case CCBYNCSA2_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCSA2_5);
        break;
      case CCBYNCSA3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCSA3_0);
        break;
      case CCBYNCSA4_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYNCSA4_0);
        break;
      case CCBYND1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYND1_0);
        break;
      case CCBYND2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYND2_0);
        break;
      case CCBYND2_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYND2_5);
        break;
      case CCBYND3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYND3_0);
        break;
      case CCBYND4_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYND4_0);
        break;
      case CCBYSA1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYSA1_0);
        break;
      case CCBYSA2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYSA2_0);
        break;
      case CCBYSA2_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYSA2_5);
        break;
      case CCBYSA3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYSA3_0);
        break;
      case CCBYSA4_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CCBYSA4_0);
        break;
      case CC01_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CC01_0);
        break;
      case CDDL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CDDL1_0);
        break;
      case CDDL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CDDL1_1);
        break;
      case CDLAPERMISSIVE1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CDLAPERMISSIVE1_0);
        break;
      case CDLASHARING1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CDLASHARING1_0);
        break;
      case CECILL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CECILL1_0);
        break;
      case CECILL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CECILL1_1);
        break;
      case CECILL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CECILL2_0);
        break;
      case CECILL2_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CECILL2_1);
        break;
      case CECILLB:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CECILLB);
        break;
      case CECILLC:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CECILLC);
        break;
      case CLARTISTIC:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CLARTISTIC);
        break;
      case CNRIJYTHON:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CNRIJYTHON);
        break;
      case CNRIPYTHONGPLCOMPATIBLE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CNRIPYTHONGPLCOMPATIBLE);
        break;
      case CNRIPYTHON:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CNRIPYTHON);
        break;
      case CONDOR1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CONDOR1_1);
        break;
      case CPAL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CPAL1_0);
        break;
      case CPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CPL1_0);
        break;
      case CPOL1_02:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CPOL1_02);
        break;
      case CROSSWORD:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CROSSWORD);
        break;
      case CRYSTALSTACKER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CRYSTALSTACKER);
        break;
      case CUAOPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CUAOPL1_0);
        break;
      case CUBE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CUBE);
        break;
      case CURL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.CURL);
        break;
      case DFSL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.DFSL1_0);
        break;
      case DIFFMARK:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.DIFFMARK);
        break;
      case DOC:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.DOC);
        break;
      case DOTSEQN:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.DOTSEQN);
        break;
      case DSDP:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.DSDP);
        break;
      case DVIPDFM:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.DVIPDFM);
        break;
      case ECL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ECL1_0);
        break;
      case ECL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ECL2_0);
        break;
      case EFL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EFL1_0);
        break;
      case EFL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EFL2_0);
        break;
      case EGENIX:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EGENIX);
        break;
      case ENTESSA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ENTESSA);
        break;
      case EPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EPL1_0);
        break;
      case EPL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EPL2_0);
        break;
      case ERLPL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ERLPL1_1);
        break;
      case EUDATAGRID:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EUDATAGRID);
        break;
      case EUPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EUPL1_0);
        break;
      case EUPL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EUPL1_1);
        break;
      case EUPL1_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EUPL1_2);
        break;
      case EUROSYM:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.EUROSYM);
        break;
      case FAIR:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.FAIR);
        break;
      case FRAMEWORX1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.FRAMEWORX1_0);
        break;
      case FREEIMAGE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.FREEIMAGE);
        break;
      case FSFAP:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.FSFAP);
        break;
      case FSFUL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.FSFUL);
        break;
      case FSFULLR:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.FSFULLR);
        break;
      case FTL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.FTL);
        break;
      case GFDL1_1ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GFDL1_1ONLY);
        break;
      case GFDL1_1ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GFDL1_1ORLATER);
        break;
      case GFDL1_2ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GFDL1_2ONLY);
        break;
      case GFDL1_2ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GFDL1_2ORLATER);
        break;
      case GFDL1_3ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GFDL1_3ONLY);
        break;
      case GFDL1_3ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GFDL1_3ORLATER);
        break;
      case GIFTWARE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GIFTWARE);
        break;
      case GL2PS:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GL2PS);
        break;
      case GLIDE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GLIDE);
        break;
      case GLULXE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GLULXE);
        break;
      case GNUPLOT:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GNUPLOT);
        break;
      case GPL1_0ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GPL1_0ONLY);
        break;
      case GPL1_0ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GPL1_0ORLATER);
        break;
      case GPL2_0ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GPL2_0ONLY);
        break;
      case GPL2_0ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GPL2_0ORLATER);
        break;
      case GPL3_0ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GPL3_0ONLY);
        break;
      case GPL3_0ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GPL3_0ORLATER);
        break;
      case GSOAP1_3B:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.GSOAP1_3B);
        break;
      case HASKELLREPORT:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.HASKELLREPORT);
        break;
      case HPND:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.HPND);
        break;
      case IBMPIBS:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.IBMPIBS);
        break;
      case ICU:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ICU);
        break;
      case IJG:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.IJG);
        break;
      case IMAGEMAGICK:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.IMAGEMAGICK);
        break;
      case IMATIX:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.IMATIX);
        break;
      case IMLIB2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.IMLIB2);
        break;
      case INFOZIP:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.INFOZIP);
        break;
      case INTELACPI:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.INTELACPI);
        break;
      case INTEL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.INTEL);
        break;
      case INTERBASE1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.INTERBASE1_0);
        break;
      case IPA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.IPA);
        break;
      case IPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.IPL1_0);
        break;
      case ISC:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ISC);
        break;
      case JASPER2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.JASPER2_0);
        break;
      case JSON:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.JSON);
        break;
      case LAL1_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LAL1_2);
        break;
      case LAL1_3:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LAL1_3);
        break;
      case LATEX2E:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LATEX2E);
        break;
      case LEPTONICA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LEPTONICA);
        break;
      case LGPL2_0ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LGPL2_0ONLY);
        break;
      case LGPL2_0ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LGPL2_0ORLATER);
        break;
      case LGPL2_1ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LGPL2_1ONLY);
        break;
      case LGPL2_1ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LGPL2_1ORLATER);
        break;
      case LGPL3_0ONLY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LGPL3_0ONLY);
        break;
      case LGPL3_0ORLATER:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LGPL3_0ORLATER);
        break;
      case LGPLLR:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LGPLLR);
        break;
      case LIBPNG:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LIBPNG);
        break;
      case LIBTIFF:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LIBTIFF);
        break;
      case LILIQP1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LILIQP1_1);
        break;
      case LILIQR1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LILIQR1_1);
        break;
      case LILIQRPLUS1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LILIQRPLUS1_1);
        break;
      case LINUXOPENIB:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LINUXOPENIB);
        break;
      case LPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LPL1_0);
        break;
      case LPL1_02:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LPL1_02);
        break;
      case LPPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LPPL1_0);
        break;
      case LPPL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LPPL1_1);
        break;
      case LPPL1_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LPPL1_2);
        break;
      case LPPL1_3A:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LPPL1_3A);
        break;
      case LPPL1_3C:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.LPPL1_3C);
        break;
      case MAKEINDEX:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MAKEINDEX);
        break;
      case MIROS:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MIROS);
        break;
      case MIT0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MIT0);
        break;
      case MITADVERTISING:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MITADVERTISING);
        break;
      case MITCMU:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MITCMU);
        break;
      case MITENNA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MITENNA);
        break;
      case MITFEH:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MITFEH);
        break;
      case MIT:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MIT);
        break;
      case MITNFA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MITNFA);
        break;
      case MOTOSOTO:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MOTOSOTO);
        break;
      case MPICH2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MPICH2);
        break;
      case MPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MPL1_0);
        break;
      case MPL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MPL1_1);
        break;
      case MPL2_0NOCOPYLEFTEXCEPTION:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MPL2_0NOCOPYLEFTEXCEPTION);
        break;
      case MPL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MPL2_0);
        break;
      case MSPL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MSPL);
        break;
      case MSRL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MSRL);
        break;
      case MTLL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MTLL);
        break;
      case MULTICS:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MULTICS);
        break;
      case MUP:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.MUP);
        break;
      case NASA1_3:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NASA1_3);
        break;
      case NAUMEN:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NAUMEN);
        break;
      case NBPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NBPL1_0);
        break;
      case NCSA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NCSA);
        break;
      case NETSNMP:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NETSNMP);
        break;
      case NETCDF:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NETCDF);
        break;
      case NEWSLETR:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NEWSLETR);
        break;
      case NGPL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NGPL);
        break;
      case NLOD1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NLOD1_0);
        break;
      case NLPL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NLPL);
        break;
      case NOKIA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NOKIA);
        break;
      case NOSL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NOSL);
        break;
      case NOWEB:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NOWEB);
        break;
      case NPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NPL1_0);
        break;
      case NPL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NPL1_1);
        break;
      case NPOSL3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NPOSL3_0);
        break;
      case NRL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NRL);
        break;
      case NTP:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NTP);
        break;
      case OCCTPL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OCCTPL);
        break;
      case OCLC2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OCLC2_0);
        break;
      case ODBL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ODBL1_0);
        break;
      case OFL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OFL1_0);
        break;
      case OFL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OFL1_1);
        break;
      case OGTSL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OGTSL);
        break;
      case OLDAP1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP1_1);
        break;
      case OLDAP1_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP1_2);
        break;
      case OLDAP1_3:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP1_3);
        break;
      case OLDAP1_4:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP1_4);
        break;
      case OLDAP2_0_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_0_1);
        break;
      case OLDAP2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_0);
        break;
      case OLDAP2_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_1);
        break;
      case OLDAP2_2_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_2_1);
        break;
      case OLDAP2_2_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_2_2);
        break;
      case OLDAP2_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_2);
        break;
      case OLDAP2_3:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_3);
        break;
      case OLDAP2_4:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_4);
        break;
      case OLDAP2_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_5);
        break;
      case OLDAP2_6:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_6);
        break;
      case OLDAP2_7:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_7);
        break;
      case OLDAP2_8:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OLDAP2_8);
        break;
      case OML:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OML);
        break;
      case OPENSSL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OPENSSL);
        break;
      case OPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OPL1_0);
        break;
      case OSETPL2_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OSETPL2_1);
        break;
      case OSL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OSL1_0);
        break;
      case OSL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OSL1_1);
        break;
      case OSL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OSL2_0);
        break;
      case OSL2_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OSL2_1);
        break;
      case OSL3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.OSL3_0);
        break;
      case PDDL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.PDDL1_0);
        break;
      case PHP3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.PHP3_0);
        break;
      case PHP3_01:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.PHP3_01);
        break;
      case PLEXUS:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.PLEXUS);
        break;
      case POSTGRESQL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.POSTGRESQL);
        break;
      case PSFRAG:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.PSFRAG);
        break;
      case PSUTILS:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.PSUTILS);
        break;
      case PYTHON2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.PYTHON2_0);
        break;
      case QHULL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.QHULL);
        break;
      case QPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.QPL1_0);
        break;
      case RDISC:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.RDISC);
        break;
      case RHECOS1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.RHECOS1_1);
        break;
      case RPL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.RPL1_1);
        break;
      case RPL1_5:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.RPL1_5);
        break;
      case RPSL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.RPSL1_0);
        break;
      case RSAMD:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.RSAMD);
        break;
      case RSCPL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.RSCPL);
        break;
      case RUBY:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.RUBY);
        break;
      case SAXPD:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SAXPD);
        break;
      case SAXPATH:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SAXPATH);
        break;
      case SCEA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SCEA);
        break;
      case SENDMAIL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SENDMAIL);
        break;
      case SGIB1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SGIB1_0);
        break;
      case SGIB1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SGIB1_1);
        break;
      case SGIB2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SGIB2_0);
        break;
      case SIMPL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SIMPL2_0);
        break;
      case SISSL1_2:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SISSL1_2);
        break;
      case SISSL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SISSL);
        break;
      case SLEEPYCAT:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SLEEPYCAT);
        break;
      case SMLNJ:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SMLNJ);
        break;
      case SMPPL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SMPPL);
        break;
      case SNIA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SNIA);
        break;
      case SPENCER86:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SPENCER86);
        break;
      case SPENCER94:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SPENCER94);
        break;
      case SPENCER99:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SPENCER99);
        break;
      case SPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SPL1_0);
        break;
      case SUGARCRM1_1_3:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SUGARCRM1_1_3);
        break;
      case SWL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.SWL);
        break;
      case TCL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.TCL);
        break;
      case TCPWRAPPERS:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.TCPWRAPPERS);
        break;
      case TMATE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.TMATE);
        break;
      case TORQUE1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.TORQUE1_1);
        break;
      case TOSL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.TOSL);
        break;
      case UNICODEDFS2015:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.UNICODEDFS2015);
        break;
      case UNICODEDFS2016:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.UNICODEDFS2016);
        break;
      case UNICODETOU:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.UNICODETOU);
        break;
      case UNLICENSE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.UNLICENSE);
        break;
      case UPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.UPL1_0);
        break;
      case VIM:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.VIM);
        break;
      case VOSTROM:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.VOSTROM);
        break;
      case VSL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.VSL1_0);
        break;
      case W3C19980720:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.W3C19980720);
        break;
      case W3C20150513:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.W3C20150513);
        break;
      case W3C:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.W3C);
        break;
      case WATCOM1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.WATCOM1_0);
        break;
      case WSUIPA:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.WSUIPA);
        break;
      case WTFPL:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.WTFPL);
        break;
      case X11:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.X11);
        break;
      case XEROX:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.XEROX);
        break;
      case XFREE861_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.XFREE861_1);
        break;
      case XINETD:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.XINETD);
        break;
      case XNET:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.XNET);
        break;
      case XPP:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.XPP);
        break;
      case XSKAT:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.XSKAT);
        break;
      case YPL1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.YPL1_0);
        break;
      case YPL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.YPL1_1);
        break;
      case ZED:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZED);
        break;
      case ZEND2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZEND2_0);
        break;
      case ZIMBRA1_3:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZIMBRA1_3);
        break;
      case ZIMBRA1_4:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZIMBRA1_4);
        break;
      case ZLIBACKNOWLEDGEMENT:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZLIBACKNOWLEDGEMENT);
        break;
      case ZLIB:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZLIB);
        break;
      case ZPL1_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZPL1_1);
        break;
      case ZPL2_0:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZPL2_0);
        break;
      case ZPL2_1:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.ZPL2_1);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.SPDXLicense.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_50.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_50.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependsOnComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUri())
      tgt.setUriElement(Canonical43_50.convertCanonical(src.getUriElement()));
    if (src.hasPackageId())
      tgt.setPackageIdElement(Id43_50.convertId(src.getPackageIdElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Code43_50.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Code43_50.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4b.model.Extension e : org.hl7.fhir.r4b.utils.ToolingExtensions.getExtensions(src, EXT_IG_DEFINITION_PARAMETER)) {
      org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent p = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
      p.getCode().setCode(org.hl7.fhir.r4b.utils.ToolingExtensions.readStringExtension(e, "code"));
      p.setValue(org.hl7.fhir.r4b.utils.ToolingExtensions.readStringExtension(e, "Value"));
      tgt.addParameter(p);
    }
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent convertImplementationGuideDefinitionComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getGrouping())
      tgt.addGrouping(convertImplementationGuideDefinitionGroupingComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuideDefinitionResourceComponent(t));
    if (src.hasPage())
      tgt.setPage(convertImplementationGuideDefinitionPageComponent(src.getPage()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent t : src.getParameter()) {
      if (Utilities.existsInList(t.getCode().getCode(), "apply", "path-resource", "path-pages", "path-tx-cache", "expansion-parameter", "rule-broken-links", "generate-xml", "generate-json", "generate-turtle", "html-template"))
        tgt.addParameter(convertImplementationGuideDefinitionParameterComponent(t));
      else {
        org.hl7.fhir.r4b.model.Extension e = new org.hl7.fhir.r4b.model.Extension(EXT_IG_DEFINITION_PARAMETER);
        org.hl7.fhir.r4b.model.Extension eCode = new org.hl7.fhir.r4b.model.Extension("code", new org.hl7.fhir.r4b.model.CodeType(t.getCode().getCode()));
        org.hl7.fhir.r4b.model.Extension eValue = new org.hl7.fhir.r4b.model.Extension("value", new org.hl7.fhir.r4b.model.StringType(t.getValue()));
        e.addExtension(eCode);
        e.addExtension(eValue);
        tgt.addExtension(e);
      }
    }
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent t : src.getTemplate())
      tgt.addTemplate(convertImplementationGuideDefinitionTemplateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuideDefinitionGroupingComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations43_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean43_50.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType())
      tgt.getProfile().add(Canonical43_50.convertCanonical(src.getExampleCanonicalType()));
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id43_50.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuideDefinitionResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    tgt.setFhirVersion(src.getFhirVersion().stream()
      .map(Enumerations43_50::convertFHIRVersion)
      .collect(Collectors.toList()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasIsExample())
      tgt.setExample(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getIsExampleElement()));
    if (src.hasProfile())
      tgt.setExample(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProfile().get(0)));
    if (src.hasGroupingId())
      tgt.setGroupingIdElement(Id43_50.convertId(src.getGroupingIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNameReference())
      tgt.setName(src.getNameReference().getReference());
    else if (src.hasNameUrlType())
      tgt.setName(src.getNameUrlType().getValue());
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuideDefinitionPageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setName(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setGenerationElement(convertGuidePageGeneration(src.getGenerationElement()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuideDefinitionPageComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGenerationEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case HTML:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.HTML);
        break;
      case MARKDOWN:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.MARKDOWN);
        break;
      case XML:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.XML);
        break;
      case GENERATED:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.GENERATED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> convertGuidePageGeneration(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGenerationEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case HTML:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.HTML);
        break;
      case MARKDOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.MARKDOWN);
        break;
      case XML:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.XML);
        break;
      case GENERATED:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.GENERATED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ImplementationGuide.GuidePageGeneration.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.getCode().setCode(src.getCode());
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent convertImplementationGuideDefinitionParameterComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.getCodeElement().setValueAsString(src.getCode().getCode());
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.utils.GuideParameterCode convertGuideParameterCode(org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case APPLY:
        return org.hl7.fhir.r5.utils.GuideParameterCode.APPLY;
      case PATHRESOURCE:
        return org.hl7.fhir.r5.utils.GuideParameterCode.PATHRESOURCE;
      case PATHPAGES:
        return org.hl7.fhir.r5.utils.GuideParameterCode.PATHPAGES;
      case PATHTXCACHE:
        return org.hl7.fhir.r5.utils.GuideParameterCode.PATHTXCACHE;
      case EXPANSIONPARAMETER:
        return org.hl7.fhir.r5.utils.GuideParameterCode.EXPANSIONPARAMETER;
      case RULEBROKENLINKS:
        return org.hl7.fhir.r5.utils.GuideParameterCode.RULEBROKENLINKS;
      case GENERATEXML:
        return org.hl7.fhir.r5.utils.GuideParameterCode.GENERATEXML;
      case GENERATEJSON:
        return org.hl7.fhir.r5.utils.GuideParameterCode.GENERATEJSON;
      case GENERATETURTLE:
        return org.hl7.fhir.r5.utils.GuideParameterCode.GENERATETURTLE;
      case HTMLTEMPLATE:
        return org.hl7.fhir.r5.utils.GuideParameterCode.HTMLTEMPLATE;
      default:
        return org.hl7.fhir.r5.utils.GuideParameterCode.NULL;
    }
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode convertGuideParameterCode(org.hl7.fhir.r5.utils.GuideParameterCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case APPLY:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.APPLY;
      case PATHRESOURCE:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.PATHRESOURCE;
      case PATHPAGES:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.PATHPAGES;
      case PATHTXCACHE:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.PATHTXCACHE;
      case EXPANSIONPARAMETER:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.EXPANSIONPARAMETER;
      case RULEBROKENLINKS:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.RULEBROKENLINKS;
      case GENERATEXML:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.GENERATEXML;
      case GENERATEJSON:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.GENERATEJSON;
      case GENERATETURTLE:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.GENERATETURTLE;
      case HTMLTEMPLATE:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.HTMLTEMPLATE;
      default:
        return org.hl7.fhir.r4b.model.ImplementationGuide.GuideParameterCode.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String43_50.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String43_50.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent convertImplementationGuideDefinitionTemplateComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideDefinitionTemplateComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasSource())
      tgt.setSourceElement(String43_50.convertString(src.getSourceElement()));
    if (src.hasScope())
      tgt.setScopeElement(String43_50.convertString(src.getScopeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url43_50.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getImage()) tgt.getImage().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getOther()) tgt.getOther().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent convertImplementationGuideManifestComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideManifestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ImplementationGuideManifestComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRendering())
      tgt.setRenderingElement(Url43_50.convertUrl(src.getRenderingElement()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent t : src.getResource())
      tgt.addResource(convertManifestResourceComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent t : src.getPage())
      tgt.addPage(convertManifestPageComponent(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getImage()) tgt.getImage().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getOther()) tgt.getOther().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    if (src.hasExampleBooleanType())
      tgt.setIsExampleElement(Boolean43_50.convertBoolean(src.getExampleBooleanType()));
    if (src.hasExampleCanonicalType())
      tgt.getProfile().add((Canonical43_50.convertCanonical(src.getExampleCanonicalType())));
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url43_50.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent convertManifestResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ManifestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ManifestResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    if (src.hasIsExample())
      tgt.setExample(Boolean43_50.convertBoolean(src.getIsExampleElement()));
    if (src.hasProfile())
      tgt.setExample(Canonical43_50.convertCanonical(src.getProfile().get(0)));
    if (src.hasRelativePath())
      tgt.setRelativePathElement(Url43_50.convertUrl(src.getRelativePathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getAnchor()) tgt.getAnchor().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent convertManifestPageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ManifestPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent tgt = new org.hl7.fhir.r4b.model.ImplementationGuide.ManifestPageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAnchor()) tgt.getAnchor().add(String43_50.convertString(t));
    return tgt;
  }
}