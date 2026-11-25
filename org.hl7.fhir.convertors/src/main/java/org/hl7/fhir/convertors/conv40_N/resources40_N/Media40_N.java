package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DocumentReference;
import org.hl7.fhir.model.core.DocumentReference.DocumentReferenceStatus;

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
 * R4 Media is an R6 DocumentReference. Media.status is always kept as a 4.0 extension on the DocumentReference, and
 * that's what marks a DocumentReference as having been a Media, so that it comes back to R4 as a Media (see
 * {@link #isMedia(DocumentReference)}).
 *
 * Media                    DocumentReference
 * identifier, basedOn      identifier, basedOn
 * status                   4.0 extension, and status: entered-in-error, or current
 * type                     category
 * modality                 modality
 * subject                  subject
 * encounter                context
 * createdPeriod            period (createdDateTime is a 4.0 extension)
 * issued                   date
 * operator                 author
 * bodySite                 bodyStructure
 * height, width,           content.attachment.height, width, frames, duration
 *   frames, duration
 * content                  content.attachment
 * partOf, view, reasonCode, deviceName, device, note, and anything that doesn't fit: 4.0 extensions
 *
 * Going back, DocumentReference elements Media doesn't have, and the second and later values of the lists that map
 * to single Media elements, are 5.0 extensions on the Media
 */
public class Media40_N {

  public static final String STATUS_EXTENSION_URL = CrossVersionElements40_N.url("Media", "4.0", "status");
  private static final String[] R4_ONLY = {"partOf", "view", "reasonCode", "deviceName", "device", "note"};
  private static final String[] LISTS = {"category", "modality", "context", "author", "bodyStructure", "content"};
  private static final String[] DR_ONLY = {"version", "docStatus", "type", "event", "related", "facilityType", "practiceSetting",
    "attester", "custodian", "relatesTo", "description", "securityLabel"};
  private static final String[] MEDIA_SIZE = {"height", "width", "frames", "duration"};

  public static boolean isMedia(DocumentReference src) {
    return src.hasExtension(STATUS_EXTENSION_URL);
  }

  public static DocumentReference convertMedia(org.hl7.fhir.r4.model.Media src) throws FHIRException {
    if (src == null)
      return null;
    DocumentReference tgt = new DocumentReference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls("DocumentReference", "5.0", DR_ONLY, CrossVersionElements40_N.urls("DocumentReference", "5.0", LISTS,
        CrossVersionElements40_N.url("DocumentReference", "5.0", "status"), CrossVersionElements40_N.url("DocumentReference", "5.0", "period"),
        CrossVersionElements40_N.url("DocumentReference", "5.0", "date"))));
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Media", tgt.getExtension(), R4_ONLY);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(Reference40_N.convertReference(t));
    if (src.hasStatus()) {
      CrossVersionElements40_N.r4ElementsToExtensions(src, "Media", tgt.getExtension(), "status");
      tgt.setStatus(src.getStatus() == org.hl7.fhir.r4.model.Media.MediaStatus.ENTEREDINERROR ? DocumentReferenceStatus.ENTEREDINERROR : DocumentReferenceStatus.CURRENT);
    }
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "status");
    if (src.hasType())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasModality())
      tgt.addModality(CodeableConcept40_N.convertCodeableConcept(src.getModality()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.addContext(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasCreatedPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getCreatedPeriod()));
    else if (src.hasCreated())
      CrossVersionElements40_N.r4ElementsToExtensions(src, "Media", tgt.getExtension(), "created");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "period");
    if (src.hasIssued()) {
      tgt.getDateElement().setValueAsString(src.getIssuedElement().getValueAsString());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getIssuedElement(), tgt.getDateElement());
    }
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "date");
    if (src.hasOperator())
      tgt.addAuthor(Reference40_N.convertReference(src.getOperator()));
    if (src.hasBodySite())
      tgt.addBodyStructure(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getBodySite()));
    if (src.hasContent()) {
      org.hl7.fhir.model.core.Attachment att = Attachment40_N.convertAttachment(src.getContent());
      tgt.addContent().setAttachment(att);
      for (String n : MEDIA_SIZE) {
        org.hl7.fhir.r4.model.Property p = src.getChildByName(n);
        if (p.hasValues()) {
          if (att.getChildByName(n).hasValues())
            CrossVersionElements40_N.r4ElementsToExtensions(src, "Media", tgt.getExtension(), n);
          else
            att.setProperty(n, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) p.getValues().get(0)));
        }
      }
    } else
      CrossVersionElements40_N.r4ElementsToExtensions(src, "Media", tgt.getExtension(), MEDIA_SIZE);
    // the rest of the lists, and the DocumentReference elements Media doesn't have
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", LISTS);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", DR_ONLY);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Media convertMedia(DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Media tgt = new org.hl7.fhir.r4.model.Media();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls("Media", "4.0", R4_ONLY, CrossVersionElements40_N.urls("Media", "4.0", MEDIA_SIZE, STATUS_EXTENSION_URL,
        CrossVersionElements40_N.url("Media", "4.0", "created"))));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Media", R4_ONLY);
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Media", "status", "created");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList())
      tgt.addBasedOn(Reference40_N.convertReference(t));
    if (src.hasStatus() && !src.getStatusElement().equalsDeep(derivedStatus(tgt)))
      CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "status");
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      if (!tgt.hasType())
        tgt.setType(CodeableConcept40_N.convertCodeableConcept(t));
      else
        rest(tgt, "category", t);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModalityList())
      if (!tgt.hasModality())
        tgt.setModality(CodeableConcept40_N.convertCodeableConcept(t));
      else
        rest(tgt, "modality", t);
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.model.core.Reference t : src.getContextList())
      if (!tgt.hasEncounter())
        tgt.setEncounter(Reference40_N.convertReference(t));
      else
        rest(tgt, "context", t);
    if (src.hasPeriod()) {
      if (!tgt.hasCreated())
        tgt.setCreated(Period40_N.convertPeriod(src.getPeriod()));
      else
        CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "period");
    }
    if (src.hasDate()) {
      try {
        tgt.getIssuedElement().setValueAsString(src.getDateElement().getValueAsString());
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getDateElement(), tgt.getIssuedElement());
      } catch (Exception e) {
        // a dateTime that isn't an instant
        tgt.setIssuedElement(null);
        CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "date");
      }
    }
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList())
      if (!tgt.hasOperator())
        tgt.setOperator(Reference40_N.convertReference(t));
      else
        rest(tgt, "author", t);
    for (org.hl7.fhir.model.core.CodeableReference t : src.getBodyStructureList())
      if (!tgt.hasBodySite())
        tgt.setBodySite(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
      else
        rest(tgt, "bodyStructure", t);
    for (DocumentReference.DocumentReferenceContentComponent t : src.getContentList()) {
      if (!tgt.hasContent() && t.hasAttachment() && !t.hasProfile() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension()) {
        org.hl7.fhir.r4.model.Attachment att = Attachment40_N.convertAttachment(t.getAttachment());
        tgt.setContent(att);
        // the attachment's height etc. are Media's
        for (String n : MEDIA_SIZE) {
          String url = CrossVersionElements40_N.url("Attachment", "5.0", n);
          // (unless Media's own is in a 4.0 extension: then the attachment's is the attachment's)
          if (att.hasExtension(url) && !tgt.getChildByName(n).hasValues() && !src.hasExtension(CrossVersionElements40_N.url("Media", "4.0", n))) {
            tgt.setProperty(n, att.getExtensionByUrl(url).getValue());
            att.getExtension().removeIf(e -> url.equals(e.getUrl()));
          }
        }
      } else
        rest(tgt, "content", t);
    }
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Media", MEDIA_SIZE);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", DR_ONLY);
    return tgt;
  }

  // the DocumentReference status that the Media status makes
  private static org.hl7.fhir.model.core.Enumeration<DocumentReferenceStatus> derivedStatus(org.hl7.fhir.r4.model.Media tgt) {
    DocumentReference dr = new DocumentReference();
    if (tgt.hasStatus())
      dr.setStatus(tgt.getStatus() == org.hl7.fhir.r4.model.Media.MediaStatus.ENTEREDINERROR ? DocumentReferenceStatus.ENTEREDINERROR : DocumentReferenceStatus.CURRENT);
    return dr.getStatusElement();
  }

  private static void rest(org.hl7.fhir.r4.model.Media tgt, String name, org.hl7.fhir.model.Base value) throws FHIRException {
    DocumentReference holder = new DocumentReference();
    holder.setProperty(name, value);
    CrossVersionElements40_N.elementsToExtensions(holder, tgt.getExtension(), "5.0", name);
  }
}
