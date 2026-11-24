package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;

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

/**
 * R4 BiologicallyDerivedProduct <-> R6 BiologicallyDerivedProduct
 *
 * productCategory    R4 code <-> R6 CodeableConcept (http://hl7.org/fhir/product-category); R6 has many: the first
 *                    whose code R4 knows, and the rest as 6.0 extensions. The R6 concept is kept (6.0 extension on the
 *                    code) when the code can't make it again
 * productCode        the same
 * status             R4 code <-> R6 productStatus Coding (http://hl7.org/fhir/product-status); the Coding is kept (5.0
 *                    extension on the code) when the code can't make it again
 * request, parent    the same
 * collection.source  R6 sourcePatient or sourceOrganization, by the reference type
 * quantity, processing, manipulation, storage: 4.0 extensions
 * R6 therapyIdentifier, biologicalSourceEvent, processingFacility, division, expirationDate, storageTempRequirements,
 * property, collection.procedure: cross-version extensions
 */
public class BiologicallyDerivedProduct40_N {

  public static final String CATEGORY_SYSTEM = "http://hl7.org/fhir/product-category";
  public static final String STATUS_SYSTEM = "http://hl7.org/fhir/product-status";
  private static final String BDP = "BiologicallyDerivedProduct";
  private static final String[] R4_ONLY = {"quantity", "processing", "manipulation", "storage"};
  private static final String[] V5 = {"biologicalSourceEvent", "processingFacility", "division", "expirationDate", "storageTempRequirements", "property"};
  private static final String[] V6 = {"therapyIdentifier"};
  private static final String CATEGORY_URL = CrossVersionElements40_N.url(BDP, "6.0", "productCategory");
  private static final String STATUS_URL = CrossVersionElements40_N.url(BDP, "5.0", "productStatus");

  public static org.hl7.fhir.model.core.BiologicallyDerivedProduct convertBiologicallyDerivedProduct(org.hl7.fhir.r4.model.BiologicallyDerivedProduct src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.BiologicallyDerivedProduct tgt = new org.hl7.fhir.model.core.BiologicallyDerivedProduct();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls(BDP, "5.0", V5, CrossVersionElements40_N.urls(BDP, "6.0", V6, CATEGORY_URL, STATUS_URL)));
    CrossVersionElements40_N.r4ElementsToExtensions(src, BDP, tgt.getExtension(), R4_ONLY);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", V6);
    if (src.hasProductCategory()) {
      org.hl7.fhir.model.core.CodeableConcept kept = CodeableConcept40_N.keptCodeableConcept(src.getProductCategoryElement(), CATEGORY_URL);
      tgt.addProductCategory(kept != null ? kept : categoryFor(src.getProductCategoryElement()));
    }
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "productCategory");
    if (src.hasProductCode())
      tgt.setProductCode(CodeableConcept40_N.convertCodeableConcept(src.getProductCode()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "biologicalSourceEvent", "processingFacility", "division");
    if (src.hasStatus()) {
      org.hl7.fhir.r4.model.Extension kept = src.getStatusElement().getExtensionByUrl(STATUS_URL);
      if (kept != null)
        tgt.setProductStatus(Coding40_N.convertCoding((org.hl7.fhir.r4.model.Coding) kept.getValue()));
      else
        tgt.setProductStatus(statusFor(src.getStatusElement()));
    } else
      // a status R4 doesn't have (see below)
      CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "productStatus");
    tgt.getExtension().removeIf(e -> STATUS_URL.equals(e.getUrl()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRequest())
      tgt.addRequest(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getParent())
      tgt.addParent(Reference40_N.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertBiologicallyDerivedProductCollectionComponent(src.getCollection()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "expirationDate", "storageTempRequirements", "property");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct convertBiologicallyDerivedProduct(org.hl7.fhir.model.core.BiologicallyDerivedProduct src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls(BDP, "4.0", R4_ONLY));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, BDP, R4_ONLY);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", V6);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProductCategoryList()) {
      String code = tgt.hasProductCategory() ? null : codeIn(t, CATEGORY_SYSTEM, "organ", "tissue", "fluid", "cells", "biologicalAgent");
      if (code != null) {
        tgt.getProductCategoryElement().setValueAsString(code);
        CodeableConcept40_N.keepCodeableConcept(t, tgt.getProductCategoryElement(), categoryFor(tgt.getProductCategoryElement()), CATEGORY_URL);
      } else
        tgt.addExtension(CATEGORY_URL, CodeableConcept40_N.convertCodeableConcept(t));
    }
    if (src.hasProductCode())
      tgt.setProductCode(CodeableConcept40_N.convertCodeableConcept(src.getProductCode()));
    if (src.hasProductStatus()) {
      org.hl7.fhir.model.core.Coding c = src.getProductStatus();
      if ((!c.hasSystem() || STATUS_SYSTEM.equals(c.getSystem())) && ("available".equals(c.getCode()) || "unavailable".equals(c.getCode()))) {
        tgt.getStatusElement().setValueAsString(c.getCode());
        if (!c.equalsDeep(statusFor(tgt.getStatusElement())))
          tgt.getStatusElement().addExtension(STATUS_URL, Coding40_N.convertCoding(c));
      } else
        CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "productStatus");
    }
    for (org.hl7.fhir.model.core.Reference t : src.getRequestList())
      tgt.addRequest(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getParentList())
      tgt.addParent(Reference40_N.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertBiologicallyDerivedProductCollectionComponent(src.getCollection()));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    return tgt;
  }

  // the code (in system, or with no system) that R4 has, if there is one
  private static String codeIn(org.hl7.fhir.model.core.CodeableConcept cc, String system, String... codes) {
    for (org.hl7.fhir.model.core.Coding c : cc.getCodingList())
      if ((!c.hasSystem() || system.equals(c.getSystem())) && java.util.Arrays.asList(codes).contains(c.getCode()))
        return c.getCode();
    return null;
  }

  private static org.hl7.fhir.model.core.CodeableConcept categoryFor(org.hl7.fhir.r4.model.Enumeration<?> src) throws FHIRException {
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, CATEGORY_URL);
    tgt.addCoding().setSystem(CATEGORY_SYSTEM).setCode(src.getValueAsString());
    return tgt;
  }

  private static org.hl7.fhir.model.core.Coding statusFor(org.hl7.fhir.r4.model.Enumeration<?> src) throws FHIRException {
    org.hl7.fhir.model.core.Coding tgt = new org.hl7.fhir.model.core.Coding();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, STATUS_URL);
    tgt.setSystem(STATUS_SYSTEM).setCode(src.getValueAsString());
    return tgt;
  }

  private static final String COLLECTION = "BiologicallyDerivedProduct.collection";

  public static org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent convertBiologicallyDerivedProductCollectionComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent tgt = new org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt,
      CrossVersionElements40_N.urls(COLLECTION, "6.0", new String[] {"sourcePatient", "sourceOrganization", "procedure"}));
    if (src.hasCollector())
      tgt.setCollector(Reference40_N.convertReference(src.getCollector()));
    if (src.hasSource()) {
      // decided by the reference type
      if (src.getSource().getReference() != null && src.getSource().getReference().contains("Organization/"))
        tgt.setSourceOrganization(Reference40_N.convertReference(src.getSource()));
      else
        tgt.setSourcePatient(Reference40_N.convertReference(src.getSource()));
    }
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, COLLECTION, "6.0", "sourcePatient", "sourceOrganization", "procedure");
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "collected", tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent convertBiologicallyDerivedProductCollectionComponent(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference40_N.convertReference(src.getCollector()));
    // one source in R4: the patient, else the organization; if there are both, the organization is an extension
    if (src.hasSourcePatient()) {
      tgt.setSource(Reference40_N.convertReference(src.getSourcePatient()));
      if (!isType(src.getSourcePatient(), false))
        CrossVersionElements40_N.elementsToExtensionsForPath(src, COLLECTION, tgt.getExtension(), "6.0", "sourcePatient");
      if (src.hasSourceOrganization())
        CrossVersionElements40_N.elementsToExtensionsForPath(src, COLLECTION, tgt.getExtension(), "6.0", "sourceOrganization");
    } else if (src.hasSourceOrganization()) {
      tgt.setSource(Reference40_N.convertReference(src.getSourceOrganization()));
      if (!isType(src.getSourceOrganization(), true))
        CrossVersionElements40_N.elementsToExtensionsForPath(src, COLLECTION, tgt.getExtension(), "6.0", "sourceOrganization");
    }
    CrossVersionElements40_N.elementsToExtensionsForPath(src, COLLECTION, tgt.getExtension(), "6.0", "procedure");
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "collected", tgt, tgt.getExtension());
    return tgt;
  }

  // whether R4 -> R6 would put this reference back where it came from
  private static boolean isType(org.hl7.fhir.model.core.Reference ref, boolean organization) {
    boolean org = ref.getReference() != null && ref.getReference().contains("Organization/");
    return org == organization;
  }
}
