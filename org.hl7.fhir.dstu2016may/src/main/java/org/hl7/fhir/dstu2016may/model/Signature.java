package org.hl7.fhir.dstu2016may.model;

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

// Generated on Sun, May 8, 2016 03:05+1000 for FHIR v1.4.0
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;

/**
 * A digital signature along with supporting context. The signature may be
 * electronic/cryptographic in nature, or a graphical image representing a
 * hand-written signature, or a signature process. Different Signature
 * approaches have different utilities.
 */
@DatatypeDef(name = "Signature")
public class Signature extends Type implements ICompositeType {

  /**
   * An indication of the reason that the entity signed this document. This may be
   * explicitly included as part of the signature information and can be used when
   * determining accountability for various actions concerning the document.
   */
  @Child(name = "type", type = {
      Coding.class }, order = 0, min = 1, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Indication of the reason the entity signed the object(s)", formalDefinition = "An indication of the reason that the entity signed this document. This may be explicitly included as part of the signature information and can be used when determining accountability for various actions concerning the document.")
  protected List<Coding> type;

  /**
   * When the digital signature was signed.
   */
  @Child(name = "when", type = { InstantType.class }, order = 1, min = 1, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "When the signature was created", formalDefinition = "When the digital signature was signed.")
  protected InstantType when;

  /**
   * A reference to an application-usable description of the person that signed
   * the certificate (e.g. the signature used their private key).
   */
  @Child(name = "who", type = { UriType.class, Practitioner.class, RelatedPerson.class, Patient.class, Device.class,
      Organization.class }, order = 2, min = 1, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Who signed the signature", formalDefinition = "A reference to an application-usable description of the person that signed the certificate (e.g. the signature used their private key).")
  protected Type who;

  /**
   * A mime type that indicates the technical format of the signature. Important
   * mime types are application/signature+xml for X ML DigSig, application/jwt for
   * JWT, and image/* for a graphical image of a signature, etc.
   */
  @Child(name = "contentType", type = { CodeType.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "The technical format of the signature", formalDefinition = "A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.")
  protected CodeType contentType;

  /**
   * The base64 encoding of the Signature content. When signature is not recorded
   * electronically this element would be empty.
   */
  @Child(name = "blob", type = {
      Base64BinaryType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "The actual signature content (XML DigSig. JWT, picture, etc.)", formalDefinition = "The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.")
  protected Base64BinaryType blob;

  private static final long serialVersionUID = -452432714L;

  /**
   * Constructor
   */
  public Signature() {
    super();
  }

  /**
   * Constructor
   */
  public Signature(InstantType when, Type who) {
    super();
    this.when = when;
    this.who = who;
  }

  /**
   * @return {@link #type} (An indication of the reason that the entity signed
   *         this document. This may be explicitly included as part of the
   *         signature information and can be used when determining accountability
   *         for various actions concerning the document.)
   */
  public List<Coding> getType() {
    if (this.type == null)
      this.type = new ArrayList<Coding>();
    return this.type;
  }

  public boolean hasType() {
    if (this.type == null)
      return false;
    for (Coding item : this.type)
      if (!item.isEmpty())
        return true;
    return false;
  }

  /**
   * @return {@link #type} (An indication of the reason that the entity signed
   *         this document. This may be explicitly included as part of the
   *         signature information and can be used when determining accountability
   *         for various actions concerning the document.)
   */
  // syntactic sugar
  public Coding addType() { // 3
    Coding t = new Coding();
    if (this.type == null)
      this.type = new ArrayList<Coding>();
    this.type.add(t);
    return t;
  }

  // syntactic sugar
  public Signature addType(Coding t) { // 3
    if (t == null)
      return this;
    if (this.type == null)
      this.type = new ArrayList<Coding>();
    this.type.add(t);
    return this;
  }

  /**
   * @return {@link #when} (When the digital signature was signed.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getWhen" gives direct access to the value
   */
  public InstantType getWhenElement() {
    if (this.when == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Signature.when");
      else if (Configuration.doAutoCreate())
        this.when = new InstantType(); // bb
    return this.when;
  }

  public boolean hasWhenElement() {
    return this.when != null && !this.when.isEmpty();
  }

  public boolean hasWhen() {
    return this.when != null && !this.when.isEmpty();
  }

  /**
   * @param value {@link #when} (When the digital signature was signed.). This is
   *              the underlying object with id, value and extensions. The
   *              accessor "getWhen" gives direct access to the value
   */
  public Signature setWhenElement(InstantType value) {
    this.when = value;
    return this;
  }

  /**
   * @return When the digital signature was signed.
   */
  public Date getWhen() {
    return this.when == null ? null : this.when.getValue();
  }

  /**
   * @param value When the digital signature was signed.
   */
  public Signature setWhen(Date value) {
    if (this.when == null)
      this.when = new InstantType();
    this.when.setValue(value);
    return this;
  }

  /**
   * @return {@link #who} (A reference to an application-usable description of the
   *         person that signed the certificate (e.g. the signature used their
   *         private key).)
   */
  public Type getWho() {
    return this.who;
  }

  /**
   * @return {@link #who} (A reference to an application-usable description of the
   *         person that signed the certificate (e.g. the signature used their
   *         private key).)
   */
  public UriType getWhoUriType() throws FHIRException {
    if (!(this.who instanceof UriType))
      throw new FHIRException(
          "Type mismatch: the type UriType was expected, but " + this.who.getClass().getName() + " was encountered");
    return (UriType) this.who;
  }

  public boolean hasWhoUriType() {
    return this.who instanceof UriType;
  }

  /**
   * @return {@link #who} (A reference to an application-usable description of the
   *         person that signed the certificate (e.g. the signature used their
   *         private key).)
   */
  public Reference getWhoReference() throws FHIRException {
    if (!(this.who instanceof Reference))
      throw new FHIRException(
          "Type mismatch: the type Reference was expected, but " + this.who.getClass().getName() + " was encountered");
    return (Reference) this.who;
  }

  public boolean hasWhoReference() {
    return this.who instanceof Reference;
  }

  public boolean hasWho() {
    return this.who != null && !this.who.isEmpty();
  }

  /**
   * @param value {@link #who} (A reference to an application-usable description
   *              of the person that signed the certificate (e.g. the signature
   *              used their private key).)
   */
  public Signature setWho(Type value) {
    this.who = value;
    return this;
  }

  /**
   * @return {@link #contentType} (A mime type that indicates the technical format
   *         of the signature. Important mime types are application/signature+xml
   *         for X ML DigSig, application/jwt for JWT, and image/* for a graphical
   *         image of a signature, etc.). This is the underlying object with id,
   *         value and extensions. The accessor "getContentType" gives direct
   *         access to the value
   */
  public CodeType getContentTypeElement() {
    if (this.contentType == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Signature.contentType");
      else if (Configuration.doAutoCreate())
        this.contentType = new CodeType(); // bb
    return this.contentType;
  }

  public boolean hasContentTypeElement() {
    return this.contentType != null && !this.contentType.isEmpty();
  }

  public boolean hasContentType() {
    return this.contentType != null && !this.contentType.isEmpty();
  }

  /**
   * @param value {@link #contentType} (A mime type that indicates the technical
   *              format of the signature. Important mime types are
   *              application/signature+xml for X ML DigSig, application/jwt for
   *              JWT, and image/* for a graphical image of a signature, etc.).
   *              This is the underlying object with id, value and extensions. The
   *              accessor "getContentType" gives direct access to the value
   */
  public Signature setContentTypeElement(CodeType value) {
    this.contentType = value;
    return this;
  }

  /**
   * @return A mime type that indicates the technical format of the signature.
   *         Important mime types are application/signature+xml for X ML DigSig,
   *         application/jwt for JWT, and image/* for a graphical image of a
   *         signature, etc.
   */
  public String getContentType() {
    return this.contentType == null ? null : this.contentType.getValue();
  }

  /**
   * @param value A mime type that indicates the technical format of the
   *              signature. Important mime types are application/signature+xml
   *              for X ML DigSig, application/jwt for JWT, and image/* for a
   *              graphical image of a signature, etc.
   */
  public Signature setContentType(String value) {
    if (Utilities.noString(value))
      this.contentType = null;
    else {
      if (this.contentType == null)
        this.contentType = new CodeType();
      this.contentType.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #blob} (The base64 encoding of the Signature content. When
   *         signature is not recorded electronically this element would be
   *         empty.). This is the underlying object with id, value and extensions.
   *         The accessor "getBlob" gives direct access to the value
   */
  public Base64BinaryType getBlobElement() {
    if (this.blob == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Signature.blob");
      else if (Configuration.doAutoCreate())
        this.blob = new Base64BinaryType(); // bb
    return this.blob;
  }

  public boolean hasBlobElement() {
    return this.blob != null && !this.blob.isEmpty();
  }

  public boolean hasBlob() {
    return this.blob != null && !this.blob.isEmpty();
  }

  /**
   * @param value {@link #blob} (The base64 encoding of the Signature content.
   *              When signature is not recorded electronically this element would
   *              be empty.). This is the underlying object with id, value and
   *              extensions. The accessor "getBlob" gives direct access to the
   *              value
   */
  public Signature setBlobElement(Base64BinaryType value) {
    this.blob = value;
    return this;
  }

  /**
   * @return The base64 encoding of the Signature content. When signature is not
   *         recorded electronically this element would be empty.
   */
  public byte[] getBlob() {
    return this.blob == null ? null : this.blob.getValue();
  }

  /**
   * @param value The base64 encoding of the Signature content. When signature is
   *              not recorded electronically this element would be empty.
   */
  public Signature setBlob(byte[] value) {
    if (value == null)
      this.blob = null;
    else {
      if (this.blob == null)
        this.blob = new Base64BinaryType();
      this.blob.setValue(value);
    }
    return this;
  }

  protected void listChildren(List<Property> childrenList) {
    super.listChildren(childrenList);
    childrenList.add(new Property("type", "Coding",
        "An indication of the reason that the entity signed this document. This may be explicitly included as part of the signature information and can be used when determining accountability for various actions concerning the document.",
        0, java.lang.Integer.MAX_VALUE, type));
    childrenList.add(new Property("when", "instant", "When the digital signature was signed.", 0,
        java.lang.Integer.MAX_VALUE, when));
    childrenList.add(new Property("who[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)",
        "A reference to an application-usable description of the person that signed the certificate (e.g. the signature used their private key).",
        0, java.lang.Integer.MAX_VALUE, who));
    childrenList.add(new Property("contentType", "code",
        "A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.",
        0, java.lang.Integer.MAX_VALUE, contentType));
    childrenList.add(new Property("blob", "base64Binary",
        "The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.",
        0, java.lang.Integer.MAX_VALUE, blob));
  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case 3575610:
      /* type */ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // Coding
    case 3648314:
      /* when */ return this.when == null ? new Base[0] : new Base[] { this.when }; // InstantType
    case 117694:
      /* who */ return this.who == null ? new Base[0] : new Base[] { this.who }; // Type
    case -389131437:
      /* contentType */ return this.contentType == null ? new Base[0] : new Base[] { this.contentType }; // CodeType
    case 3026845:
      /* blob */ return this.blob == null ? new Base[0] : new Base[] { this.blob }; // Base64BinaryType
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public void setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case 3575610: // type
      this.getType().add(castToCoding(value)); // Coding
      break;
    case 3648314: // when
      this.when = castToInstant(value); // InstantType
      break;
    case 117694: // who
      this.who = (Type) value; // Type
      break;
    case -389131437: // contentType
      this.contentType = castToCode(value); // CodeType
      break;
    case 3026845: // blob
      this.blob = castToBase64Binary(value); // Base64BinaryType
      break;
    default:
      super.setProperty(hash, name, value);
    }

  }

  @Override
  public void setProperty(String name, Base value) throws FHIRException {
    if (name.equals("type"))
      this.getType().add(castToCoding(value));
    else if (name.equals("when"))
      this.when = castToInstant(value); // InstantType
    else if (name.equals("who[x]"))
      this.who = (Type) value; // Type
    else if (name.equals("contentType"))
      this.contentType = castToCode(value); // CodeType
    else if (name.equals("blob"))
      this.blob = castToBase64Binary(value); // Base64BinaryType
    else
      super.setProperty(name, value);
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 3575610:
      return addType(); // Coding
    case 3648314:
      throw new FHIRException("Cannot make property when as it is not a complex type"); // InstantType
    case -788654078:
      return getWho(); // Type
    case -389131437:
      throw new FHIRException("Cannot make property contentType as it is not a complex type"); // CodeType
    case 3026845:
      throw new FHIRException("Cannot make property blob as it is not a complex type"); // Base64BinaryType
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("type")) {
      return addType();
    } else if (name.equals("when")) {
      throw new FHIRException("Cannot call addChild on a singleton property Signature.when");
    } else if (name.equals("whoUri")) {
      this.who = new UriType();
      return this.who;
    } else if (name.equals("whoReference")) {
      this.who = new Reference();
      return this.who;
    } else if (name.equals("contentType")) {
      throw new FHIRException("Cannot call addChild on a singleton property Signature.contentType");
    } else if (name.equals("blob")) {
      throw new FHIRException("Cannot call addChild on a singleton property Signature.blob");
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "Signature";

  }

  public Signature copy() {
    Signature dst = new Signature();
    copyValues(dst);
    if (type != null) {
      dst.type = new ArrayList<Coding>();
      for (Coding i : type)
        dst.type.add(i.copy());
    }
    ;
    dst.when = when == null ? null : when.copy();
    dst.who = who == null ? null : who.copy();
    dst.contentType = contentType == null ? null : contentType.copy();
    dst.blob = blob == null ? null : blob.copy();
    return dst;
  }

  protected Signature typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other) {
    if (!super.equalsDeep(other))
      return false;
    if (!(other instanceof Signature))
      return false;
    Signature o = (Signature) other;
    return compareDeep(type, o.type, true) && compareDeep(when, o.when, true) && compareDeep(who, o.who, true)
        && compareDeep(contentType, o.contentType, true) && compareDeep(blob, o.blob, true);
  }

  @Override
  public boolean equalsShallow(Base other) {
    if (!super.equalsShallow(other))
      return false;
    if (!(other instanceof Signature))
      return false;
    Signature o = (Signature) other;
    return compareValues(when, o.when, true) && compareValues(contentType, o.contentType, true)
        && compareValues(blob, o.blob, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && (type == null || type.isEmpty()) && (when == null || when.isEmpty())
        && (who == null || who.isEmpty()) && (contentType == null || contentType.isEmpty())
        && (blob == null || blob.isEmpty());
  }

}