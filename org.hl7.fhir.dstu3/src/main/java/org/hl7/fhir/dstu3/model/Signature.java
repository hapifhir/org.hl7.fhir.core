package org.hl7.fhir.dstu3.model;



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

// Generated on Fri, Mar 16, 2018 15:21+1100 for FHIR v3.0.x
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.instance.model.api.ICompositeType;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
/**
 * A digital signature along with supporting context. The signature may be electronic/cryptographic in nature, or a graphical image representing a hand-written signature, or a signature process. Different signature approaches have different utilities.
 */
@DatatypeDef(name="Signature")
public class Signature extends Type implements ICompositeType {

    /**
     * An indication of the reason that the entity signed this document. This may be explicitly included as part of the signature information and can be used when determining accountability for various actions concerning the document.
     */
    @Child(name = "type", type = {Coding.class}, order=0, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Indication of the reason the entity signed the object(s)", formalDefinition="An indication of the reason that the entity signed this document. This may be explicitly included as part of the signature information and can be used when determining accountability for various actions concerning the document." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/signature-type")
    protected List<Coding> type;

    /**
     * When the digital signature was signed.
     */
    @Child(name = "when", type = {InstantType.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the signature was created", formalDefinition="When the digital signature was signed." )
    protected InstantType when;

    /**
     * A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).
     */
    @Child(name = "who", type = {UriType.class, Practitioner.class, RelatedPerson.class, Patient.class, Device.class, Organization.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who signed", formalDefinition="A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key)." )
    protected Type who;

    /**
     * A reference to an application-usable description of the identity that is represented by the signature.
     */
    @Child(name = "onBehalfOf", type = {UriType.class, Practitioner.class, RelatedPerson.class, Patient.class, Device.class, Organization.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The party represented", formalDefinition="A reference to an application-usable description of the identity that is represented by the signature." )
    protected Type onBehalfOf;

    /**
     * A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.
     */
    @Child(name = "contentType", type = {CodeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The technical format of the signature", formalDefinition="A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc." )
    protected CodeType contentType;

    /**
     * The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.
     */
    @Child(name = "blob", type = {Base64BinaryType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The actual signature content (XML DigSig. JWT, picture, etc.)", formalDefinition="The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty." )
    protected Base64BinaryType blob;

    private static final long serialVersionUID = 1133697310L;

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
     * @return {@link #type} (An indication of the reason that the entity signed this document. This may be explicitly included as part of the signature information and can be used when determining accountability for various actions concerning the document.)
     */
    public List<Coding> getType() { 
      if (this.type == null)
        this.type = new ArrayList<Coding>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Signature setType(List<Coding> theType) { 
      this.type = theType;
      return this;
    }

    public boolean hasType() { 
      if (this.type == null)
        return false;
      for (Coding item : this.type)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Coding addType() { //3
      Coding t = new Coding();
      if (this.type == null)
        this.type = new ArrayList<Coding>();
      this.type.add(t);
      return t;
    }

    public Signature addType(Coding t) { //3
      if (t == null)
        return this;
      if (this.type == null)
        this.type = new ArrayList<Coding>();
      this.type.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist
     */
    public Coding getTypeFirstRep() { 
      if (getType().isEmpty()) {
        addType();
      }
      return getType().get(0);
    }

    /**
     * @return {@link #when} (When the digital signature was signed.). This is the underlying object with id, value and extensions. The accessor "getWhen" gives direct access to the value
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
     * @param value {@link #when} (When the digital signature was signed.). This is the underlying object with id, value and extensions. The accessor "getWhen" gives direct access to the value
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
     * @return {@link #who} (A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).)
     */
    public Type getWho() { 
      return this.who;
    }

    /**
     * @return {@link #who} (A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).)
     */
    public UriType getWhoUriType() throws FHIRException { 
      if (this.who == null)
        return null;
      if (!(this.who instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.who.getClass().getName()+" was encountered");
      return (UriType) this.who;
    }

    public boolean hasWhoUriType() {
        return this.who instanceof UriType;
    }

    /**
     * @return {@link #who} (A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).)
     */
    public Reference getWhoReference() throws FHIRException { 
      if (this.who == null)
        return null;
      if (!(this.who instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.who.getClass().getName()+" was encountered");
      return (Reference) this.who;
    }

    public boolean hasWhoReference() {
        return this.who instanceof Reference;
    }

    public boolean hasWho() { 
      return this.who != null && !this.who.isEmpty();
    }

    /**
     * @param value {@link #who} (A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).)
     */
    public Signature setWho(Type value) throws FHIRFormatError { 
      if (value != null && !(value instanceof UriType || value instanceof Reference))
        throw new FHIRFormatError("Not the right type for Signature.who[x]: "+value.fhirType());
      this.who = value;
      return this;
    }

    /**
     * @return {@link #onBehalfOf} (A reference to an application-usable description of the identity that is represented by the signature.)
     */
    public Type getOnBehalfOf() { 
      return this.onBehalfOf;
    }

    /**
     * @return {@link #onBehalfOf} (A reference to an application-usable description of the identity that is represented by the signature.)
     */
    public UriType getOnBehalfOfUriType() throws FHIRException { 
      if (this.onBehalfOf == null)
        return null;
      if (!(this.onBehalfOf instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.onBehalfOf.getClass().getName()+" was encountered");
      return (UriType) this.onBehalfOf;
    }

    public boolean hasOnBehalfOfUriType() {
        return this.onBehalfOf instanceof UriType;
    }

    /**
     * @return {@link #onBehalfOf} (A reference to an application-usable description of the identity that is represented by the signature.)
     */
    public Reference getOnBehalfOfReference() throws FHIRException { 
      if (this.onBehalfOf == null)
        return null;
      if (!(this.onBehalfOf instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.onBehalfOf.getClass().getName()+" was encountered");
      return (Reference) this.onBehalfOf;
    }

    public boolean hasOnBehalfOfReference() {
        return this.onBehalfOf instanceof Reference;
    }

    public boolean hasOnBehalfOf() { 
      return this.onBehalfOf != null && !this.onBehalfOf.isEmpty();
    }

    /**
     * @param value {@link #onBehalfOf} (A reference to an application-usable description of the identity that is represented by the signature.)
     */
    public Signature setOnBehalfOf(Type value) throws FHIRFormatError { 
      if (value != null && !(value instanceof UriType || value instanceof Reference))
        throw new FHIRFormatError("Not the right type for Signature.onBehalfOf[x]: "+value.fhirType());
      this.onBehalfOf = value;
      return this;
    }

    /**
     * @return {@link #contentType} (A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
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
     * @param value {@link #contentType} (A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
     */
    public Signature setContentTypeElement(CodeType value) { 
      this.contentType = value;
      return this;
    }

    /**
     * @return A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.
     */
    public String getContentType() { 
      return this.contentType == null ? null : this.contentType.getValue();
    }

    /**
     * @param value A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.
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
     * @return {@link #blob} (The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.). This is the underlying object with id, value and extensions. The accessor "getBlob" gives direct access to the value
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
     * @param value {@link #blob} (The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.). This is the underlying object with id, value and extensions. The accessor "getBlob" gives direct access to the value
     */
    public Signature setBlobElement(Base64BinaryType value) { 
      this.blob = value;
      return this;
    }

    /**
     * @return The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.
     */
    public byte[] getBlob() { 
      return this.blob == null ? null : this.blob.getValue();
    }

    /**
     * @param value The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.
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

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("type", "Coding", "An indication of the reason that the entity signed this document. This may be explicitly included as part of the signature information and can be used when determining accountability for various actions concerning the document.", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("when", "instant", "When the digital signature was signed.", 0, 1, when));
        children.add(new Property("who[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).", 0, 1, who));
        children.add(new Property("onBehalfOf[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that is represented by the signature.", 0, 1, onBehalfOf));
        children.add(new Property("contentType", "code", "A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.", 0, 1, contentType));
        children.add(new Property("blob", "base64Binary", "The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.", 0, 1, blob));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3575610: /*type*/  return new Property("type", "Coding", "An indication of the reason that the entity signed this document. This may be explicitly included as part of the signature information and can be used when determining accountability for various actions concerning the document.", 0, java.lang.Integer.MAX_VALUE, type);
        case 3648314: /*when*/  return new Property("when", "instant", "When the digital signature was signed.", 0, 1, when);
        case -788654078: /*who[x]*/  return new Property("who[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).", 0, 1, who);
        case 117694: /*who*/  return new Property("who[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).", 0, 1, who);
        case -788660018: /*whoUri*/  return new Property("who[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).", 0, 1, who);
        case 1017243949: /*whoReference*/  return new Property("who[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that signed  (e.g. the signature used their private key).", 0, 1, who);
        case 418120340: /*onBehalfOf[x]*/  return new Property("onBehalfOf[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that is represented by the signature.", 0, 1, onBehalfOf);
        case -14402964: /*onBehalfOf*/  return new Property("onBehalfOf[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that is represented by the signature.", 0, 1, onBehalfOf);
        case 418114400: /*onBehalfOfUri*/  return new Property("onBehalfOf[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that is represented by the signature.", 0, 1, onBehalfOf);
        case -1136255425: /*onBehalfOfReference*/  return new Property("onBehalfOf[x]", "uri|Reference(Practitioner|RelatedPerson|Patient|Device|Organization)", "A reference to an application-usable description of the identity that is represented by the signature.", 0, 1, onBehalfOf);
        case -389131437: /*contentType*/  return new Property("contentType", "code", "A mime type that indicates the technical format of the signature. Important mime types are application/signature+xml for X ML DigSig, application/jwt for JWT, and image/* for a graphical image of a signature, etc.", 0, 1, contentType);
        case 3026845: /*blob*/  return new Property("blob", "base64Binary", "The base64 encoding of the Signature content. When signature is not recorded electronically this element would be empty.", 0, 1, blob);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // Coding
        case 3648314: /*when*/ return this.when == null ? new Base[0] : new Base[] {this.when}; // InstantType
        case 117694: /*who*/ return this.who == null ? new Base[0] : new Base[] {this.who}; // Type
        case -14402964: /*onBehalfOf*/ return this.onBehalfOf == null ? new Base[0] : new Base[] {this.onBehalfOf}; // Type
        case -389131437: /*contentType*/ return this.contentType == null ? new Base[0] : new Base[] {this.contentType}; // CodeType
        case 3026845: /*blob*/ return this.blob == null ? new Base[0] : new Base[] {this.blob}; // Base64BinaryType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.getType().add(castToCoding(value)); // Coding
          return value;
        case 3648314: // when
          this.when = castToInstant(value); // InstantType
          return value;
        case 117694: // who
          this.who = castToType(value); // Type
          return value;
        case -14402964: // onBehalfOf
          this.onBehalfOf = castToType(value); // Type
          return value;
        case -389131437: // contentType
          this.contentType = castToCode(value); // CodeType
          return value;
        case 3026845: // blob
          this.blob = castToBase64Binary(value); // Base64BinaryType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.getType().add(castToCoding(value));
        } else if (name.equals("when")) {
          this.when = castToInstant(value); // InstantType
        } else if (name.equals("who[x]")) {
          this.who = castToType(value); // Type
        } else if (name.equals("onBehalfOf[x]")) {
          this.onBehalfOf = castToType(value); // Type
        } else if (name.equals("contentType")) {
          this.contentType = castToCode(value); // CodeType
        } else if (name.equals("blob")) {
          this.blob = castToBase64Binary(value); // Base64BinaryType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return addType(); 
        case 3648314:  return getWhenElement();
        case -788654078:  return getWho(); 
        case 117694:  return getWho(); 
        case 418120340:  return getOnBehalfOf(); 
        case -14402964:  return getOnBehalfOf(); 
        case -389131437:  return getContentTypeElement();
        case 3026845:  return getBlobElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"Coding"};
        case 3648314: /*when*/ return new String[] {"instant"};
        case 117694: /*who*/ return new String[] {"uri", "Reference"};
        case -14402964: /*onBehalfOf*/ return new String[] {"uri", "Reference"};
        case -389131437: /*contentType*/ return new String[] {"code"};
        case 3026845: /*blob*/ return new String[] {"base64Binary"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("when")) {
          throw new FHIRException("Cannot call addChild on a singleton property Signature.when");
        }
        else if (name.equals("whoUri")) {
          this.who = new UriType();
          return this.who;
        }
        else if (name.equals("whoReference")) {
          this.who = new Reference();
          return this.who;
        }
        else if (name.equals("onBehalfOfUri")) {
          this.onBehalfOf = new UriType();
          return this.onBehalfOf;
        }
        else if (name.equals("onBehalfOfReference")) {
          this.onBehalfOf = new Reference();
          return this.onBehalfOf;
        }
        else if (name.equals("contentType")) {
          throw new FHIRException("Cannot call addChild on a singleton property Signature.contentType");
        }
        else if (name.equals("blob")) {
          throw new FHIRException("Cannot call addChild on a singleton property Signature.blob");
        }
        else
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
        };
        dst.when = when == null ? null : when.copy();
        dst.who = who == null ? null : who.copy();
        dst.onBehalfOf = onBehalfOf == null ? null : onBehalfOf.copy();
        dst.contentType = contentType == null ? null : contentType.copy();
        dst.blob = blob == null ? null : blob.copy();
        return dst;
      }

      protected Signature typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Signature))
          return false;
        Signature o = (Signature) other_;
        return compareDeep(type, o.type, true) && compareDeep(when, o.when, true) && compareDeep(who, o.who, true)
           && compareDeep(onBehalfOf, o.onBehalfOf, true) && compareDeep(contentType, o.contentType, true)
           && compareDeep(blob, o.blob, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Signature))
          return false;
        Signature o = (Signature) other_;
        return compareValues(when, o.when, true) && compareValues(contentType, o.contentType, true) && compareValues(blob, o.blob, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, when, who, onBehalfOf
          , contentType, blob);
      }


}