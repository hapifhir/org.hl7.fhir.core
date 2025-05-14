package org.hl7.fhir.r5.openehr;


/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.openehr.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * A specialisation of DV_ENCAPSULATED for audiovisual and bio-signal types. Includes further metadata relating to multimedia types which are not applicable to other subtypes of DV_ENCAPSULATED.
 */
@DatatypeDef(name="DV_MULTIMEDIA")
public class DV_MULTIMEDIA extends DV_ENCAPSULATED implements ICompositeType {

    /**
     * Text to display in lieu of multimedia display/replay.
     */
    @Child(name = "alternate_text", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Text to display in lieu of multimedia display/replay", formalDefinition="Text to display in lieu of multimedia display/replay." )
    protected StringType alternate_text;

    /**
     * URI reference to electronic information stored outside the record as a file, database entry etc, if supplied as a reference.
     */
    @Child(name = "uri", type = {DV_URI.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="URI reference to electronic information stored outside the record as a file, database entry etc, if supplied as a reference", formalDefinition="URI reference to electronic information stored outside the record as a file, database entry etc, if supplied as a reference." )
    protected DV_URI uri;

    /**
     * The actual data found at uri, if supplied inline.
     */
    @Child(name = "data", type = {Base64BinaryType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The actual data found at uri, if supplied inline", formalDefinition="The actual data found at uri, if supplied inline." )
    protected Base64BinaryType data;

    /**
     * Data media type coded from openEHR code set media types (interface for the IANA MIME types code set).
     */
    @Child(name = "media_type", type = {CODE_PHRASE.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Data media type coded from openEHR code set media types: IANA MIME types", formalDefinition="Data media type coded from openEHR code set media types (interface for the IANA MIME types code set)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
    protected CODE_PHRASE media_type;

    /**
     * Compression type, a coded value from the openEHR Integrity check code set. Void means no compression.
     */
    @Child(name = "compression_algorithm", type = {CODE_PHRASE.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Compression type, a coded value from the openEHR Integrity check code set. Absence means no compression", formalDefinition="Compression type, a coded value from the openEHR Integrity check code set. Void means no compression." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-compression_algorithms")
    protected CODE_PHRASE compression_algorithm;

    /**
     * Binary cryptographic integrity checksum.
     */
    @Child(name = "integrity_check", type = {Base64BinaryType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Binary cryptographic integrity checksum", formalDefinition="Binary cryptographic integrity checksum." )
    protected Base64BinaryType integrity_check;

    /**
     * Type of integrity check, a coded value from the openEHR Integrity check code set.
     */
    @Child(name = "integrity_check_algorithm", type = {CODE_PHRASE.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Type of integrity check, a coded value from the openEHR Integrity check code set", formalDefinition="Type of integrity check, a coded value from the openEHR Integrity check code set." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-integrity_check_algorithms")
    protected CODE_PHRASE integrity_check_algorithm;

    /**
     * The thumbnail for this item, if one exists; mainly for graphics formats.
     */
    @Child(name = "thumbnail", type = {DV_MULTIMEDIA.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The thumbnail for this item, if one exists; mainly for graphics formats", formalDefinition="The thumbnail for this item, if one exists; mainly for graphics formats." )
    protected DV_MULTIMEDIA thumbnail;

    /**
     * Original size in bytes of unencoded encapsulated data. I.e. encodings such as base64, hexadecimal etc do not change the value of this attribute.
     */
    @Child(name = "size", type = {IntegerType.class}, order=8, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Original size in bytes of unencoded encapsulated data", formalDefinition="Original size in bytes of unencoded encapsulated data. I.e. encodings such as base64, hexadecimal etc do not change the value of this attribute." )
    protected IntegerType size;

    private static final long serialVersionUID = 271994043L;

  /**
   * Constructor
   */
    public DV_MULTIMEDIA() {
      super();
    }

  /**
   * Constructor
   */
    public DV_MULTIMEDIA(String alternate_text, CODE_PHRASE media_type, int size) {
      super();
      this.setAlternate_text(alternate_text);
      this.setMedia_type(media_type);
      this.setSize(size);
    }

    /**
     * @return {@link #alternate_text} (Text to display in lieu of multimedia display/replay.). This is the underlying object with id, value and extensions. The accessor "getAlternate_text" gives direct access to the value
     */
    public StringType getAlternate_textElement() { 
      if (this.alternate_text == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.alternate_text");
        else if (Configuration.doAutoCreate())
          this.alternate_text = new StringType(); // bb
      return this.alternate_text;
    }

    public boolean hasAlternate_textElement() { 
      return this.alternate_text != null && !this.alternate_text.isEmpty();
    }

    public boolean hasAlternate_text() { 
      return this.alternate_text != null && !this.alternate_text.isEmpty();
    }

    /**
     * @param value {@link #alternate_text} (Text to display in lieu of multimedia display/replay.). This is the underlying object with id, value and extensions. The accessor "getAlternate_text" gives direct access to the value
     */
    public DV_MULTIMEDIA setAlternate_textElement(StringType value) { 
      this.alternate_text = value;
      return this;
    }

    /**
     * @return Text to display in lieu of multimedia display/replay.
     */
    public String getAlternate_text() { 
      return this.alternate_text == null ? null : this.alternate_text.getValue();
    }

    /**
     * @param value Text to display in lieu of multimedia display/replay.
     */
    public DV_MULTIMEDIA setAlternate_text(String value) { 
        if (this.alternate_text == null)
          this.alternate_text = new StringType();
        this.alternate_text.setValue(value);
      return this;
    }

    /**
     * @return {@link #uri} (URI reference to electronic information stored outside the record as a file, database entry etc, if supplied as a reference.)
     */
    public DV_URI getUri() { 
      if (this.uri == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.uri");
        else if (Configuration.doAutoCreate())
          this.uri = new DV_URI(); // cc
      return this.uri;
    }

    public boolean hasUri() { 
      return this.uri != null && !this.uri.isEmpty();
    }

    /**
     * @param value {@link #uri} (URI reference to electronic information stored outside the record as a file, database entry etc, if supplied as a reference.)
     */
    public DV_MULTIMEDIA setUri(DV_URI value) { 
      this.uri = value;
      return this;
    }

    /**
     * @return {@link #data} (The actual data found at uri, if supplied inline.). This is the underlying object with id, value and extensions. The accessor "getData" gives direct access to the value
     */
    public Base64BinaryType getDataElement() { 
      if (this.data == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.data");
        else if (Configuration.doAutoCreate())
          this.data = new Base64BinaryType(); // bb
      return this.data;
    }

    public boolean hasDataElement() { 
      return this.data != null && !this.data.isEmpty();
    }

    public boolean hasData() { 
      return this.data != null && !this.data.isEmpty();
    }

    /**
     * @param value {@link #data} (The actual data found at uri, if supplied inline.). This is the underlying object with id, value and extensions. The accessor "getData" gives direct access to the value
     */
    public DV_MULTIMEDIA setDataElement(Base64BinaryType value) { 
      this.data = value;
      return this;
    }

    /**
     * @return The actual data found at uri, if supplied inline.
     */
    public byte[] getData() { 
      return this.data == null ? null : this.data.getValue();
    }

    /**
     * @param value The actual data found at uri, if supplied inline.
     */
    public DV_MULTIMEDIA setData(byte[] value) { 
      if (value == null)
        this.data = null;
      else {
        if (this.data == null)
          this.data = new Base64BinaryType();
        this.data.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #media_type} (Data media type coded from openEHR code set media types (interface for the IANA MIME types code set).)
     */
    public CODE_PHRASE getMedia_type() { 
      if (this.media_type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.media_type");
        else if (Configuration.doAutoCreate())
          this.media_type = new CODE_PHRASE(); // cc
      return this.media_type;
    }

    public boolean hasMedia_type() { 
      return this.media_type != null && !this.media_type.isEmpty();
    }

    /**
     * @param value {@link #media_type} (Data media type coded from openEHR code set media types (interface for the IANA MIME types code set).)
     */
    public DV_MULTIMEDIA setMedia_type(CODE_PHRASE value) { 
      this.media_type = value;
      return this;
    }

    /**
     * @return {@link #compression_algorithm} (Compression type, a coded value from the openEHR Integrity check code set. Void means no compression.)
     */
    public CODE_PHRASE getCompression_algorithm() { 
      if (this.compression_algorithm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.compression_algorithm");
        else if (Configuration.doAutoCreate())
          this.compression_algorithm = new CODE_PHRASE(); // cc
      return this.compression_algorithm;
    }

    public boolean hasCompression_algorithm() { 
      return this.compression_algorithm != null && !this.compression_algorithm.isEmpty();
    }

    /**
     * @param value {@link #compression_algorithm} (Compression type, a coded value from the openEHR Integrity check code set. Void means no compression.)
     */
    public DV_MULTIMEDIA setCompression_algorithm(CODE_PHRASE value) { 
      this.compression_algorithm = value;
      return this;
    }

    /**
     * @return {@link #integrity_check} (Binary cryptographic integrity checksum.). This is the underlying object with id, value and extensions. The accessor "getIntegrity_check" gives direct access to the value
     */
    public Base64BinaryType getIntegrity_checkElement() { 
      if (this.integrity_check == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.integrity_check");
        else if (Configuration.doAutoCreate())
          this.integrity_check = new Base64BinaryType(); // bb
      return this.integrity_check;
    }

    public boolean hasIntegrity_checkElement() { 
      return this.integrity_check != null && !this.integrity_check.isEmpty();
    }

    public boolean hasIntegrity_check() { 
      return this.integrity_check != null && !this.integrity_check.isEmpty();
    }

    /**
     * @param value {@link #integrity_check} (Binary cryptographic integrity checksum.). This is the underlying object with id, value and extensions. The accessor "getIntegrity_check" gives direct access to the value
     */
    public DV_MULTIMEDIA setIntegrity_checkElement(Base64BinaryType value) { 
      this.integrity_check = value;
      return this;
    }

    /**
     * @return Binary cryptographic integrity checksum.
     */
    public byte[] getIntegrity_check() { 
      return this.integrity_check == null ? null : this.integrity_check.getValue();
    }

    /**
     * @param value Binary cryptographic integrity checksum.
     */
    public DV_MULTIMEDIA setIntegrity_check(byte[] value) { 
      if (value == null)
        this.integrity_check = null;
      else {
        if (this.integrity_check == null)
          this.integrity_check = new Base64BinaryType();
        this.integrity_check.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #integrity_check_algorithm} (Type of integrity check, a coded value from the openEHR Integrity check code set.)
     */
    public CODE_PHRASE getIntegrity_check_algorithm() { 
      if (this.integrity_check_algorithm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.integrity_check_algorithm");
        else if (Configuration.doAutoCreate())
          this.integrity_check_algorithm = new CODE_PHRASE(); // cc
      return this.integrity_check_algorithm;
    }

    public boolean hasIntegrity_check_algorithm() { 
      return this.integrity_check_algorithm != null && !this.integrity_check_algorithm.isEmpty();
    }

    /**
     * @param value {@link #integrity_check_algorithm} (Type of integrity check, a coded value from the openEHR Integrity check code set.)
     */
    public DV_MULTIMEDIA setIntegrity_check_algorithm(CODE_PHRASE value) { 
      this.integrity_check_algorithm = value;
      return this;
    }

    /**
     * @return {@link #thumbnail} (The thumbnail for this item, if one exists; mainly for graphics formats.)
     */
    public DV_MULTIMEDIA getThumbnail() { 
      if (this.thumbnail == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.thumbnail");
        else if (Configuration.doAutoCreate())
          this.thumbnail = new DV_MULTIMEDIA(); // cc
      return this.thumbnail;
    }

    public boolean hasThumbnail() { 
      return this.thumbnail != null && !this.thumbnail.isEmpty();
    }

    /**
     * @param value {@link #thumbnail} (The thumbnail for this item, if one exists; mainly for graphics formats.)
     */
    public DV_MULTIMEDIA setThumbnail(DV_MULTIMEDIA value) { 
      this.thumbnail = value;
      return this;
    }

    /**
     * @return {@link #size} (Original size in bytes of unencoded encapsulated data. I.e. encodings such as base64, hexadecimal etc do not change the value of this attribute.). This is the underlying object with id, value and extensions. The accessor "getSize" gives direct access to the value
     */
    public IntegerType getSizeElement() { 
      if (this.size == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_MULTIMEDIA.size");
        else if (Configuration.doAutoCreate())
          this.size = new IntegerType(); // bb
      return this.size;
    }

    public boolean hasSizeElement() { 
      return this.size != null && !this.size.isEmpty();
    }

    public boolean hasSize() { 
      return this.size != null && !this.size.isEmpty();
    }

    /**
     * @param value {@link #size} (Original size in bytes of unencoded encapsulated data. I.e. encodings such as base64, hexadecimal etc do not change the value of this attribute.). This is the underlying object with id, value and extensions. The accessor "getSize" gives direct access to the value
     */
    public DV_MULTIMEDIA setSizeElement(IntegerType value) { 
      this.size = value;
      return this;
    }

    /**
     * @return Original size in bytes of unencoded encapsulated data. I.e. encodings such as base64, hexadecimal etc do not change the value of this attribute.
     */
    public int getSize() { 
      return this.size == null || this.size.isEmpty() ? 0 : this.size.getValue();
    }

    /**
     * @param value Original size in bytes of unencoded encapsulated data. I.e. encodings such as base64, hexadecimal etc do not change the value of this attribute.
     */
    public DV_MULTIMEDIA setSize(int value) { 
        if (this.size == null)
          this.size = new IntegerType();
        this.size.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("alternate_text", "string", "Text to display in lieu of multimedia display/replay.", 0, 1, alternate_text));
        children.add(new Property("uri", "http://openehr.org/fhir/StructureDefinition/DV-URI", "URI reference to electronic information stored outside the record as a file, database entry etc, if supplied as a reference.", 0, 1, uri));
        children.add(new Property("data", "base64Binary", "The actual data found at uri, if supplied inline.", 0, 1, data));
        children.add(new Property("media_type", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Data media type coded from openEHR code set media types (interface for the IANA MIME types code set).", 0, 1, media_type));
        children.add(new Property("compression_algorithm", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Compression type, a coded value from the openEHR Integrity check code set. Void means no compression.", 0, 1, compression_algorithm));
        children.add(new Property("integrity_check", "base64Binary", "Binary cryptographic integrity checksum.", 0, 1, integrity_check));
        children.add(new Property("integrity_check_algorithm", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Type of integrity check, a coded value from the openEHR Integrity check code set.", 0, 1, integrity_check_algorithm));
        children.add(new Property("thumbnail", "http://openehr.org/fhir/StructureDefinition/DV-MULTIMEDIA", "The thumbnail for this item, if one exists; mainly for graphics formats.", 0, 1, thumbnail));
        children.add(new Property("size", "integer", "Original size in bytes of unencoded encapsulated data. I.e. encodings such as base64, hexadecimal etc do not change the value of this attribute.", 0, 1, size));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -208340526: /*alternate_text*/  return new Property("alternate_text", "string", "Text to display in lieu of multimedia display/replay.", 0, 1, alternate_text);
        case 116076: /*uri*/  return new Property("uri", "http://openehr.org/fhir/StructureDefinition/DV-URI", "URI reference to electronic information stored outside the record as a file, database entry etc, if supplied as a reference.", 0, 1, uri);
        case 3076010: /*data*/  return new Property("data", "base64Binary", "The actual data found at uri, if supplied inline.", 0, 1, data);
        case 1939875509: /*media_type*/  return new Property("media_type", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Data media type coded from openEHR code set media types (interface for the IANA MIME types code set).", 0, 1, media_type);
        case 1993343190: /*compression_algorithm*/  return new Property("compression_algorithm", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Compression type, a coded value from the openEHR Integrity check code set. Void means no compression.", 0, 1, compression_algorithm);
        case 1076156822: /*integrity_check*/  return new Property("integrity_check", "base64Binary", "Binary cryptographic integrity checksum.", 0, 1, integrity_check);
        case 828114182: /*integrity_check_algorithm*/  return new Property("integrity_check_algorithm", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Type of integrity check, a coded value from the openEHR Integrity check code set.", 0, 1, integrity_check_algorithm);
        case 1330532588: /*thumbnail*/  return new Property("thumbnail", "http://openehr.org/fhir/StructureDefinition/DV-MULTIMEDIA", "The thumbnail for this item, if one exists; mainly for graphics formats.", 0, 1, thumbnail);
        case 3530753: /*size*/  return new Property("size", "integer", "Original size in bytes of unencoded encapsulated data. I.e. encodings such as base64, hexadecimal etc do not change the value of this attribute.", 0, 1, size);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -208340526: /*alternate_text*/ return this.alternate_text == null ? new Base[0] : new Base[] {this.alternate_text}; // StringType
        case 116076: /*uri*/ return this.uri == null ? new Base[0] : new Base[] {this.uri}; // DV_URI
        case 3076010: /*data*/ return this.data == null ? new Base[0] : new Base[] {this.data}; // Base64BinaryType
        case 1939875509: /*media_type*/ return this.media_type == null ? new Base[0] : new Base[] {this.media_type}; // CODE_PHRASE
        case 1993343190: /*compression_algorithm*/ return this.compression_algorithm == null ? new Base[0] : new Base[] {this.compression_algorithm}; // CODE_PHRASE
        case 1076156822: /*integrity_check*/ return this.integrity_check == null ? new Base[0] : new Base[] {this.integrity_check}; // Base64BinaryType
        case 828114182: /*integrity_check_algorithm*/ return this.integrity_check_algorithm == null ? new Base[0] : new Base[] {this.integrity_check_algorithm}; // CODE_PHRASE
        case 1330532588: /*thumbnail*/ return this.thumbnail == null ? new Base[0] : new Base[] {this.thumbnail}; // DV_MULTIMEDIA
        case 3530753: /*size*/ return this.size == null ? new Base[0] : new Base[] {this.size}; // IntegerType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -208340526: // alternate_text
          this.alternate_text = TypeConvertor.castToString(value); // StringType
          return value;
        case 116076: // uri
          this.uri = (DV_URI) value; // DV_URI
          return value;
        case 3076010: // data
          this.data = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
          return value;
        case 1939875509: // media_type
          this.media_type = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case 1993343190: // compression_algorithm
          this.compression_algorithm = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case 1076156822: // integrity_check
          this.integrity_check = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
          return value;
        case 828114182: // integrity_check_algorithm
          this.integrity_check_algorithm = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case 1330532588: // thumbnail
          this.thumbnail = (DV_MULTIMEDIA) value; // DV_MULTIMEDIA
          return value;
        case 3530753: // size
          this.size = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("alternate_text")) {
          this.alternate_text = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("uri")) {
          this.uri = (DV_URI) value; // DV_URI
        } else if (name.equals("data")) {
          this.data = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
        } else if (name.equals("media_type")) {
          this.media_type = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("compression_algorithm")) {
          this.compression_algorithm = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("integrity_check")) {
          this.integrity_check = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
        } else if (name.equals("integrity_check_algorithm")) {
          this.integrity_check_algorithm = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("thumbnail")) {
          this.thumbnail = (DV_MULTIMEDIA) value; // DV_MULTIMEDIA
        } else if (name.equals("size")) {
          this.size = TypeConvertor.castToInteger(value); // IntegerType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -208340526:  return getAlternate_textElement();
        case 116076:  return getUri();
        case 3076010:  return getDataElement();
        case 1939875509:  return getMedia_type();
        case 1993343190:  return getCompression_algorithm();
        case 1076156822:  return getIntegrity_checkElement();
        case 828114182:  return getIntegrity_check_algorithm();
        case 1330532588:  return getThumbnail();
        case 3530753:  return getSizeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -208340526: /*alternate_text*/ return new String[] {"string"};
        case 116076: /*uri*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-URI"};
        case 3076010: /*data*/ return new String[] {"base64Binary"};
        case 1939875509: /*media_type*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case 1993343190: /*compression_algorithm*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case 1076156822: /*integrity_check*/ return new String[] {"base64Binary"};
        case 828114182: /*integrity_check_algorithm*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case 1330532588: /*thumbnail*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-MULTIMEDIA"};
        case 3530753: /*size*/ return new String[] {"integer"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("alternate_text")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_MULTIMEDIA.alternate_text");
        }
        else if (name.equals("uri")) {
          this.uri = new DV_URI();
          return this.uri;
        }
        else if (name.equals("data")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_MULTIMEDIA.data");
        }
        else if (name.equals("media_type")) {
          this.media_type = new CODE_PHRASE();
          return this.media_type;
        }
        else if (name.equals("compression_algorithm")) {
          this.compression_algorithm = new CODE_PHRASE();
          return this.compression_algorithm;
        }
        else if (name.equals("integrity_check")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_MULTIMEDIA.integrity_check");
        }
        else if (name.equals("integrity_check_algorithm")) {
          this.integrity_check_algorithm = new CODE_PHRASE();
          return this.integrity_check_algorithm;
        }
        else if (name.equals("thumbnail")) {
          this.thumbnail = new DV_MULTIMEDIA();
          return this.thumbnail;
        }
        else if (name.equals("size")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_MULTIMEDIA.size");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_MULTIMEDIA";

  }

      public DV_MULTIMEDIA copy() {
        DV_MULTIMEDIA dst = new DV_MULTIMEDIA();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_MULTIMEDIA dst) {
        super.copyValues(dst);
        dst.alternate_text = alternate_text == null ? null : alternate_text.copy();
        dst.uri = uri == null ? null : uri.copy();
        dst.data = data == null ? null : data.copy();
        dst.media_type = media_type == null ? null : media_type.copy();
        dst.compression_algorithm = compression_algorithm == null ? null : compression_algorithm.copy();
        dst.integrity_check = integrity_check == null ? null : integrity_check.copy();
        dst.integrity_check_algorithm = integrity_check_algorithm == null ? null : integrity_check_algorithm.copy();
        dst.thumbnail = thumbnail == null ? null : thumbnail.copy();
        dst.size = size == null ? null : size.copy();
      }

      protected DV_MULTIMEDIA typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_MULTIMEDIA))
          return false;
        DV_MULTIMEDIA o = (DV_MULTIMEDIA) other_;
        return compareDeep(alternate_text, o.alternate_text, true) && compareDeep(uri, o.uri, true) && compareDeep(data, o.data, true)
           && compareDeep(media_type, o.media_type, true) && compareDeep(compression_algorithm, o.compression_algorithm, true)
           && compareDeep(integrity_check, o.integrity_check, true) && compareDeep(integrity_check_algorithm, o.integrity_check_algorithm, true)
           && compareDeep(thumbnail, o.thumbnail, true) && compareDeep(size, o.size, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_MULTIMEDIA))
          return false;
        DV_MULTIMEDIA o = (DV_MULTIMEDIA) other_;
        return compareValues(alternate_text, o.alternate_text, true) && compareValues(data, o.data, true) && compareValues(integrity_check, o.integrity_check, true)
           && compareValues(size, o.size, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(alternate_text, uri, data
          , media_type, compression_algorithm, integrity_check, integrity_check_algorithm, thumbnail
          , size);
      }


}

