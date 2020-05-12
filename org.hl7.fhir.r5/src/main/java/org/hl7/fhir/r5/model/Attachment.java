package org.hl7.fhir.r5.model;




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

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Base StructureDefinition for Attachment Type: For referring to data content defined in other formats.
 */
@DatatypeDef(name="Attachment")
public class Attachment extends DataType implements ICompositeType {

    /**
     * Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate.
     */
    @Child(name = "contentType", type = {CodeType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Mime type of the content, with charset etc.", formalDefinition="Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
    protected CodeType contentType;

    /**
     * The human language of the content. The value can be any valid value according to BCP 47.
     */
    @Child(name = "language", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human language of the content (BCP-47)", formalDefinition="The human language of the content. The value can be any valid value according to BCP 47." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
    protected CodeType language;

    /**
     * The actual data of the attachment - a sequence of bytes, base64 encoded.
     */
    @Child(name = "data", type = {Base64BinaryType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Data inline, base64ed", formalDefinition="The actual data of the attachment - a sequence of bytes, base64 encoded." )
    protected Base64BinaryType data;

    /**
     * A location where the data can be accessed.
     */
    @Child(name = "url", type = {UrlType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Uri where the data can be found", formalDefinition="A location where the data can be accessed." )
    protected UrlType url;

    /**
     * The number of bytes of data that make up this attachment (before base64 encoding, if that is done).
     */
    @Child(name = "size", type = {Integer64Type.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of bytes of content (if url provided)", formalDefinition="The number of bytes of data that make up this attachment (before base64 encoding, if that is done)." )
    protected Integer64Type size;

    /**
     * The calculated hash of the data using SHA-1. Represented using base64.
     */
    @Child(name = "hash", type = {Base64BinaryType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Hash of the data (sha-1, base64ed)", formalDefinition="The calculated hash of the data using SHA-1. Represented using base64." )
    protected Base64BinaryType hash;

    /**
     * A label or set of text to display in place of the data.
     */
    @Child(name = "title", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Label to display in place of the data", formalDefinition="A label or set of text to display in place of the data." )
    protected StringType title;

    /**
     * The date that the attachment was first created.
     */
    @Child(name = "creation", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date attachment was first created", formalDefinition="The date that the attachment was first created." )
    protected DateTimeType creation;

    /**
     * Height of the image in pixels (photo/video).
     */
    @Child(name = "height", type = {PositiveIntType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Height of the image in pixels (photo/video)", formalDefinition="Height of the image in pixels (photo/video)." )
    protected PositiveIntType height;

    /**
     * Width of the image in pixels (photo/video).
     */
    @Child(name = "width", type = {PositiveIntType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Width of the image in pixels (photo/video)", formalDefinition="Width of the image in pixels (photo/video)." )
    protected PositiveIntType width;

    /**
     * The number of frames in a photo. This is used with a multi-page fax, or an imaging acquisition context that takes multiple slices in a single image, or an animated gif. If there is more than one frame, this SHALL have a value in order to alert interface software that a multi-frame capable rendering widget is required.
     */
    @Child(name = "frames", type = {PositiveIntType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Number of frames if > 1 (photo)", formalDefinition="The number of frames in a photo. This is used with a multi-page fax, or an imaging acquisition context that takes multiple slices in a single image, or an animated gif. If there is more than one frame, this SHALL have a value in order to alert interface software that a multi-frame capable rendering widget is required." )
    protected PositiveIntType frames;

    /**
     * The duration of the recording in seconds - for audio and video.
     */
    @Child(name = "duration", type = {DecimalType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Length in seconds (audio / video)", formalDefinition="The duration of the recording in seconds - for audio and video." )
    protected DecimalType duration;

    /**
     * The number of pages when printed.
     */
    @Child(name = "pages", type = {PositiveIntType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Number of printed pages", formalDefinition="The number of pages when printed." )
    protected PositiveIntType pages;

    private static final long serialVersionUID = -1904332061L;

  /**
   * Constructor
   */
    public Attachment() {
      super();
    }

    /**
     * @return {@link #contentType} (Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
     */
    public CodeType getContentTypeElement() { 
      if (this.contentType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.contentType");
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
     * @param value {@link #contentType} (Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
     */
    public Attachment setContentTypeElement(CodeType value) { 
      this.contentType = value;
      return this;
    }

    /**
     * @return Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate.
     */
    public String getContentType() { 
      return this.contentType == null ? null : this.contentType.getValue();
    }

    /**
     * @param value Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate.
     */
    public Attachment setContentType(String value) { 
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
     * @return {@link #language} (The human language of the content. The value can be any valid value according to BCP 47.). This is the underlying object with id, value and extensions. The accessor "getLanguage" gives direct access to the value
     */
    public CodeType getLanguageElement() { 
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.language");
        else if (Configuration.doAutoCreate())
          this.language = new CodeType(); // bb
      return this.language;
    }

    public boolean hasLanguageElement() { 
      return this.language != null && !this.language.isEmpty();
    }

    public boolean hasLanguage() { 
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (The human language of the content. The value can be any valid value according to BCP 47.). This is the underlying object with id, value and extensions. The accessor "getLanguage" gives direct access to the value
     */
    public Attachment setLanguageElement(CodeType value) { 
      this.language = value;
      return this;
    }

    /**
     * @return The human language of the content. The value can be any valid value according to BCP 47.
     */
    public String getLanguage() { 
      return this.language == null ? null : this.language.getValue();
    }

    /**
     * @param value The human language of the content. The value can be any valid value according to BCP 47.
     */
    public Attachment setLanguage(String value) { 
      if (Utilities.noString(value))
        this.language = null;
      else {
        if (this.language == null)
          this.language = new CodeType();
        this.language.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #data} (The actual data of the attachment - a sequence of bytes, base64 encoded.). This is the underlying object with id, value and extensions. The accessor "getData" gives direct access to the value
     */
    public Base64BinaryType getDataElement() { 
      if (this.data == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.data");
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
     * @param value {@link #data} (The actual data of the attachment - a sequence of bytes, base64 encoded.). This is the underlying object with id, value and extensions. The accessor "getData" gives direct access to the value
     */
    public Attachment setDataElement(Base64BinaryType value) { 
      this.data = value;
      return this;
    }

    /**
     * @return The actual data of the attachment - a sequence of bytes, base64 encoded.
     */
    public byte[] getData() { 
      return this.data == null ? null : this.data.getValue();
    }

    /**
     * @param value The actual data of the attachment - a sequence of bytes, base64 encoded.
     */
    public Attachment setData(byte[] value) { 
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
     * @return {@link #url} (A location where the data can be accessed.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UrlType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.url");
        else if (Configuration.doAutoCreate())
          this.url = new UrlType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() { 
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() { 
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (A location where the data can be accessed.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Attachment setUrlElement(UrlType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return A location where the data can be accessed.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value A location where the data can be accessed.
     */
    public Attachment setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UrlType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #size} (The number of bytes of data that make up this attachment (before base64 encoding, if that is done).). This is the underlying object with id, value and extensions. The accessor "getSize" gives direct access to the value
     */
    public Integer64Type getSizeElement() { 
      if (this.size == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.size");
        else if (Configuration.doAutoCreate())
          this.size = new Integer64Type(); // bb
      return this.size;
    }

    public boolean hasSizeElement() { 
      return this.size != null && !this.size.isEmpty();
    }

    public boolean hasSize() { 
      return this.size != null && !this.size.isEmpty();
    }

    /**
     * @param value {@link #size} (The number of bytes of data that make up this attachment (before base64 encoding, if that is done).). This is the underlying object with id, value and extensions. The accessor "getSize" gives direct access to the value
     */
    public Attachment setSizeElement(Integer64Type value) { 
      this.size = value;
      return this;
    }

    /**
     * @return The number of bytes of data that make up this attachment (before base64 encoding, if that is done).
     */
    public long getSize() { 
      return this.size == null || this.size.isEmpty() ? 0 : this.size.getValue();
    }

    /**
     * @param value The number of bytes of data that make up this attachment (before base64 encoding, if that is done).
     */
    public Attachment setSize(long value) { 
          this.size = new Integer64Type();
        this.size.setValue(value);
      return this;
    }

    /**
     * @return {@link #hash} (The calculated hash of the data using SHA-1. Represented using base64.). This is the underlying object with id, value and extensions. The accessor "getHash" gives direct access to the value
     */
    public Base64BinaryType getHashElement() { 
      if (this.hash == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.hash");
        else if (Configuration.doAutoCreate())
          this.hash = new Base64BinaryType(); // bb
      return this.hash;
    }

    public boolean hasHashElement() { 
      return this.hash != null && !this.hash.isEmpty();
    }

    public boolean hasHash() { 
      return this.hash != null && !this.hash.isEmpty();
    }

    /**
     * @param value {@link #hash} (The calculated hash of the data using SHA-1. Represented using base64.). This is the underlying object with id, value and extensions. The accessor "getHash" gives direct access to the value
     */
    public Attachment setHashElement(Base64BinaryType value) { 
      this.hash = value;
      return this;
    }

    /**
     * @return The calculated hash of the data using SHA-1. Represented using base64.
     */
    public byte[] getHash() { 
      return this.hash == null ? null : this.hash.getValue();
    }

    /**
     * @param value The calculated hash of the data using SHA-1. Represented using base64.
     */
    public Attachment setHash(byte[] value) { 
      if (value == null)
        this.hash = null;
      else {
        if (this.hash == null)
          this.hash = new Base64BinaryType();
        this.hash.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #title} (A label or set of text to display in place of the data.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.title");
        else if (Configuration.doAutoCreate())
          this.title = new StringType(); // bb
      return this.title;
    }

    public boolean hasTitleElement() { 
      return this.title != null && !this.title.isEmpty();
    }

    public boolean hasTitle() { 
      return this.title != null && !this.title.isEmpty();
    }

    /**
     * @param value {@link #title} (A label or set of text to display in place of the data.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Attachment setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A label or set of text to display in place of the data.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A label or set of text to display in place of the data.
     */
    public Attachment setTitle(String value) { 
      if (Utilities.noString(value))
        this.title = null;
      else {
        if (this.title == null)
          this.title = new StringType();
        this.title.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #creation} (The date that the attachment was first created.). This is the underlying object with id, value and extensions. The accessor "getCreation" gives direct access to the value
     */
    public DateTimeType getCreationElement() { 
      if (this.creation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.creation");
        else if (Configuration.doAutoCreate())
          this.creation = new DateTimeType(); // bb
      return this.creation;
    }

    public boolean hasCreationElement() { 
      return this.creation != null && !this.creation.isEmpty();
    }

    public boolean hasCreation() { 
      return this.creation != null && !this.creation.isEmpty();
    }

    /**
     * @param value {@link #creation} (The date that the attachment was first created.). This is the underlying object with id, value and extensions. The accessor "getCreation" gives direct access to the value
     */
    public Attachment setCreationElement(DateTimeType value) { 
      this.creation = value;
      return this;
    }

    /**
     * @return The date that the attachment was first created.
     */
    public Date getCreation() { 
      return this.creation == null ? null : this.creation.getValue();
    }

    /**
     * @param value The date that the attachment was first created.
     */
    public Attachment setCreation(Date value) { 
      if (value == null)
        this.creation = null;
      else {
        if (this.creation == null)
          this.creation = new DateTimeType();
        this.creation.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #height} (Height of the image in pixels (photo/video).). This is the underlying object with id, value and extensions. The accessor "getHeight" gives direct access to the value
     */
    public PositiveIntType getHeightElement() { 
      if (this.height == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.height");
        else if (Configuration.doAutoCreate())
          this.height = new PositiveIntType(); // bb
      return this.height;
    }

    public boolean hasHeightElement() { 
      return this.height != null && !this.height.isEmpty();
    }

    public boolean hasHeight() { 
      return this.height != null && !this.height.isEmpty();
    }

    /**
     * @param value {@link #height} (Height of the image in pixels (photo/video).). This is the underlying object with id, value and extensions. The accessor "getHeight" gives direct access to the value
     */
    public Attachment setHeightElement(PositiveIntType value) { 
      this.height = value;
      return this;
    }

    /**
     * @return Height of the image in pixels (photo/video).
     */
    public int getHeight() { 
      return this.height == null || this.height.isEmpty() ? 0 : this.height.getValue();
    }

    /**
     * @param value Height of the image in pixels (photo/video).
     */
    public Attachment setHeight(int value) { 
        if (this.height == null)
          this.height = new PositiveIntType();
        this.height.setValue(value);
      return this;
    }

    /**
     * @return {@link #width} (Width of the image in pixels (photo/video).). This is the underlying object with id, value and extensions. The accessor "getWidth" gives direct access to the value
     */
    public PositiveIntType getWidthElement() { 
      if (this.width == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.width");
        else if (Configuration.doAutoCreate())
          this.width = new PositiveIntType(); // bb
      return this.width;
    }

    public boolean hasWidthElement() { 
      return this.width != null && !this.width.isEmpty();
    }

    public boolean hasWidth() { 
      return this.width != null && !this.width.isEmpty();
    }

    /**
     * @param value {@link #width} (Width of the image in pixels (photo/video).). This is the underlying object with id, value and extensions. The accessor "getWidth" gives direct access to the value
     */
    public Attachment setWidthElement(PositiveIntType value) { 
      this.width = value;
      return this;
    }

    /**
     * @return Width of the image in pixels (photo/video).
     */
    public int getWidth() { 
      return this.width == null || this.width.isEmpty() ? 0 : this.width.getValue();
    }

    /**
     * @param value Width of the image in pixels (photo/video).
     */
    public Attachment setWidth(int value) { 
        if (this.width == null)
          this.width = new PositiveIntType();
        this.width.setValue(value);
      return this;
    }

    /**
     * @return {@link #frames} (The number of frames in a photo. This is used with a multi-page fax, or an imaging acquisition context that takes multiple slices in a single image, or an animated gif. If there is more than one frame, this SHALL have a value in order to alert interface software that a multi-frame capable rendering widget is required.). This is the underlying object with id, value and extensions. The accessor "getFrames" gives direct access to the value
     */
    public PositiveIntType getFramesElement() { 
      if (this.frames == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.frames");
        else if (Configuration.doAutoCreate())
          this.frames = new PositiveIntType(); // bb
      return this.frames;
    }

    public boolean hasFramesElement() { 
      return this.frames != null && !this.frames.isEmpty();
    }

    public boolean hasFrames() { 
      return this.frames != null && !this.frames.isEmpty();
    }

    /**
     * @param value {@link #frames} (The number of frames in a photo. This is used with a multi-page fax, or an imaging acquisition context that takes multiple slices in a single image, or an animated gif. If there is more than one frame, this SHALL have a value in order to alert interface software that a multi-frame capable rendering widget is required.). This is the underlying object with id, value and extensions. The accessor "getFrames" gives direct access to the value
     */
    public Attachment setFramesElement(PositiveIntType value) { 
      this.frames = value;
      return this;
    }

    /**
     * @return The number of frames in a photo. This is used with a multi-page fax, or an imaging acquisition context that takes multiple slices in a single image, or an animated gif. If there is more than one frame, this SHALL have a value in order to alert interface software that a multi-frame capable rendering widget is required.
     */
    public int getFrames() { 
      return this.frames == null || this.frames.isEmpty() ? 0 : this.frames.getValue();
    }

    /**
     * @param value The number of frames in a photo. This is used with a multi-page fax, or an imaging acquisition context that takes multiple slices in a single image, or an animated gif. If there is more than one frame, this SHALL have a value in order to alert interface software that a multi-frame capable rendering widget is required.
     */
    public Attachment setFrames(int value) { 
        if (this.frames == null)
          this.frames = new PositiveIntType();
        this.frames.setValue(value);
      return this;
    }

    /**
     * @return {@link #duration} (The duration of the recording in seconds - for audio and video.). This is the underlying object with id, value and extensions. The accessor "getDuration" gives direct access to the value
     */
    public DecimalType getDurationElement() { 
      if (this.duration == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.duration");
        else if (Configuration.doAutoCreate())
          this.duration = new DecimalType(); // bb
      return this.duration;
    }

    public boolean hasDurationElement() { 
      return this.duration != null && !this.duration.isEmpty();
    }

    public boolean hasDuration() { 
      return this.duration != null && !this.duration.isEmpty();
    }

    /**
     * @param value {@link #duration} (The duration of the recording in seconds - for audio and video.). This is the underlying object with id, value and extensions. The accessor "getDuration" gives direct access to the value
     */
    public Attachment setDurationElement(DecimalType value) { 
      this.duration = value;
      return this;
    }

    /**
     * @return The duration of the recording in seconds - for audio and video.
     */
    public BigDecimal getDuration() { 
      return this.duration == null ? null : this.duration.getValue();
    }

    /**
     * @param value The duration of the recording in seconds - for audio and video.
     */
    public Attachment setDuration(BigDecimal value) { 
      if (value == null)
        this.duration = null;
      else {
        if (this.duration == null)
          this.duration = new DecimalType();
        this.duration.setValue(value);
      }
      return this;
    }

    /**
     * @param value The duration of the recording in seconds - for audio and video.
     */
    public Attachment setDuration(long value) { 
          this.duration = new DecimalType();
        this.duration.setValue(value);
      return this;
    }

    /**
     * @param value The duration of the recording in seconds - for audio and video.
     */
    public Attachment setDuration(double value) { 
          this.duration = new DecimalType();
        this.duration.setValue(value);
      return this;
    }

    /**
     * @return {@link #pages} (The number of pages when printed.). This is the underlying object with id, value and extensions. The accessor "getPages" gives direct access to the value
     */
    public PositiveIntType getPagesElement() { 
      if (this.pages == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Attachment.pages");
        else if (Configuration.doAutoCreate())
          this.pages = new PositiveIntType(); // bb
      return this.pages;
    }

    public boolean hasPagesElement() { 
      return this.pages != null && !this.pages.isEmpty();
    }

    public boolean hasPages() { 
      return this.pages != null && !this.pages.isEmpty();
    }

    /**
     * @param value {@link #pages} (The number of pages when printed.). This is the underlying object with id, value and extensions. The accessor "getPages" gives direct access to the value
     */
    public Attachment setPagesElement(PositiveIntType value) { 
      this.pages = value;
      return this;
    }

    /**
     * @return The number of pages when printed.
     */
    public int getPages() { 
      return this.pages == null || this.pages.isEmpty() ? 0 : this.pages.getValue();
    }

    /**
     * @param value The number of pages when printed.
     */
    public Attachment setPages(int value) { 
        if (this.pages == null)
          this.pages = new PositiveIntType();
        this.pages.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("contentType", "code", "Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate.", 0, 1, contentType));
        children.add(new Property("language", "code", "The human language of the content. The value can be any valid value according to BCP 47.", 0, 1, language));
        children.add(new Property("data", "base64Binary", "The actual data of the attachment - a sequence of bytes, base64 encoded.", 0, 1, data));
        children.add(new Property("url", "url", "A location where the data can be accessed.", 0, 1, url));
        children.add(new Property("size", "integer64", "The number of bytes of data that make up this attachment (before base64 encoding, if that is done).", 0, 1, size));
        children.add(new Property("hash", "base64Binary", "The calculated hash of the data using SHA-1. Represented using base64.", 0, 1, hash));
        children.add(new Property("title", "string", "A label or set of text to display in place of the data.", 0, 1, title));
        children.add(new Property("creation", "dateTime", "The date that the attachment was first created.", 0, 1, creation));
        children.add(new Property("height", "positiveInt", "Height of the image in pixels (photo/video).", 0, 1, height));
        children.add(new Property("width", "positiveInt", "Width of the image in pixels (photo/video).", 0, 1, width));
        children.add(new Property("frames", "positiveInt", "The number of frames in a photo. This is used with a multi-page fax, or an imaging acquisition context that takes multiple slices in a single image, or an animated gif. If there is more than one frame, this SHALL have a value in order to alert interface software that a multi-frame capable rendering widget is required.", 0, 1, frames));
        children.add(new Property("duration", "decimal", "The duration of the recording in seconds - for audio and video.", 0, 1, duration));
        children.add(new Property("pages", "positiveInt", "The number of pages when printed.", 0, 1, pages));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -389131437: /*contentType*/  return new Property("contentType", "code", "Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate.", 0, 1, contentType);
        case -1613589672: /*language*/  return new Property("language", "code", "The human language of the content. The value can be any valid value according to BCP 47.", 0, 1, language);
        case 3076010: /*data*/  return new Property("data", "base64Binary", "The actual data of the attachment - a sequence of bytes, base64 encoded.", 0, 1, data);
        case 116079: /*url*/  return new Property("url", "url", "A location where the data can be accessed.", 0, 1, url);
        case 3530753: /*size*/  return new Property("size", "integer64", "The number of bytes of data that make up this attachment (before base64 encoding, if that is done).", 0, 1, size);
        case 3195150: /*hash*/  return new Property("hash", "base64Binary", "The calculated hash of the data using SHA-1. Represented using base64.", 0, 1, hash);
        case 110371416: /*title*/  return new Property("title", "string", "A label or set of text to display in place of the data.", 0, 1, title);
        case 1820421855: /*creation*/  return new Property("creation", "dateTime", "The date that the attachment was first created.", 0, 1, creation);
        case -1221029593: /*height*/  return new Property("height", "positiveInt", "Height of the image in pixels (photo/video).", 0, 1, height);
        case 113126854: /*width*/  return new Property("width", "positiveInt", "Width of the image in pixels (photo/video).", 0, 1, width);
        case -1266514778: /*frames*/  return new Property("frames", "positiveInt", "The number of frames in a photo. This is used with a multi-page fax, or an imaging acquisition context that takes multiple slices in a single image, or an animated gif. If there is more than one frame, this SHALL have a value in order to alert interface software that a multi-frame capable rendering widget is required.", 0, 1, frames);
        case -1992012396: /*duration*/  return new Property("duration", "decimal", "The duration of the recording in seconds - for audio and video.", 0, 1, duration);
        case 106426308: /*pages*/  return new Property("pages", "positiveInt", "The number of pages when printed.", 0, 1, pages);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -389131437: /*contentType*/ return this.contentType == null ? new Base[0] : new Base[] {this.contentType}; // CodeType
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeType
        case 3076010: /*data*/ return this.data == null ? new Base[0] : new Base[] {this.data}; // Base64BinaryType
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
        case 3530753: /*size*/ return this.size == null ? new Base[0] : new Base[] {this.size}; // Integer64Type
        case 3195150: /*hash*/ return this.hash == null ? new Base[0] : new Base[] {this.hash}; // Base64BinaryType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case 1820421855: /*creation*/ return this.creation == null ? new Base[0] : new Base[] {this.creation}; // DateTimeType
        case -1221029593: /*height*/ return this.height == null ? new Base[0] : new Base[] {this.height}; // PositiveIntType
        case 113126854: /*width*/ return this.width == null ? new Base[0] : new Base[] {this.width}; // PositiveIntType
        case -1266514778: /*frames*/ return this.frames == null ? new Base[0] : new Base[] {this.frames}; // PositiveIntType
        case -1992012396: /*duration*/ return this.duration == null ? new Base[0] : new Base[] {this.duration}; // DecimalType
        case 106426308: /*pages*/ return this.pages == null ? new Base[0] : new Base[] {this.pages}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -389131437: // contentType
          this.contentType = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1613589672: // language
          this.language = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 3076010: // data
          this.data = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case 3530753: // size
          this.size = TypeConvertor.castToInteger64(value); // Integer64Type
          return value;
        case 3195150: // hash
          this.hash = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case 1820421855: // creation
          this.creation = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1221029593: // height
          this.height = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 113126854: // width
          this.width = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case -1266514778: // frames
          this.frames = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case -1992012396: // duration
          this.duration = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 106426308: // pages
          this.pages = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("contentType")) {
          this.contentType = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("language")) {
          this.language = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("data")) {
          this.data = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("size")) {
          this.size = TypeConvertor.castToInteger64(value); // Integer64Type
        } else if (name.equals("hash")) {
          this.hash = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("creation")) {
          this.creation = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("height")) {
          this.height = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("width")) {
          this.width = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("frames")) {
          this.frames = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("duration")) {
          this.duration = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("pages")) {
          this.pages = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -389131437:  return getContentTypeElement();
        case -1613589672:  return getLanguageElement();
        case 3076010:  return getDataElement();
        case 116079:  return getUrlElement();
        case 3530753:  return getSizeElement();
        case 3195150:  return getHashElement();
        case 110371416:  return getTitleElement();
        case 1820421855:  return getCreationElement();
        case -1221029593:  return getHeightElement();
        case 113126854:  return getWidthElement();
        case -1266514778:  return getFramesElement();
        case -1992012396:  return getDurationElement();
        case 106426308:  return getPagesElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -389131437: /*contentType*/ return new String[] {"code"};
        case -1613589672: /*language*/ return new String[] {"code"};
        case 3076010: /*data*/ return new String[] {"base64Binary"};
        case 116079: /*url*/ return new String[] {"url"};
        case 3530753: /*size*/ return new String[] {"integer64"};
        case 3195150: /*hash*/ return new String[] {"base64Binary"};
        case 110371416: /*title*/ return new String[] {"string"};
        case 1820421855: /*creation*/ return new String[] {"dateTime"};
        case -1221029593: /*height*/ return new String[] {"positiveInt"};
        case 113126854: /*width*/ return new String[] {"positiveInt"};
        case -1266514778: /*frames*/ return new String[] {"positiveInt"};
        case -1992012396: /*duration*/ return new String[] {"decimal"};
        case 106426308: /*pages*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("contentType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.contentType");
        }
        else if (name.equals("language")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.language");
        }
        else if (name.equals("data")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.data");
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.url");
        }
        else if (name.equals("size")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.size");
        }
        else if (name.equals("hash")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.hash");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.title");
        }
        else if (name.equals("creation")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.creation");
        }
        else if (name.equals("height")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.height");
        }
        else if (name.equals("width")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.width");
        }
        else if (name.equals("frames")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.frames");
        }
        else if (name.equals("duration")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.duration");
        }
        else if (name.equals("pages")) {
          throw new FHIRException("Cannot call addChild on a primitive type Attachment.pages");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Attachment";

  }

      public Attachment copy() {
        Attachment dst = new Attachment();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Attachment dst) {
        super.copyValues(dst);
        dst.contentType = contentType == null ? null : contentType.copy();
        dst.language = language == null ? null : language.copy();
        dst.data = data == null ? null : data.copy();
        dst.url = url == null ? null : url.copy();
        dst.size = size == null ? null : size.copy();
        dst.hash = hash == null ? null : hash.copy();
        dst.title = title == null ? null : title.copy();
        dst.creation = creation == null ? null : creation.copy();
        dst.height = height == null ? null : height.copy();
        dst.width = width == null ? null : width.copy();
        dst.frames = frames == null ? null : frames.copy();
        dst.duration = duration == null ? null : duration.copy();
        dst.pages = pages == null ? null : pages.copy();
      }

      protected Attachment typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Attachment))
          return false;
        Attachment o = (Attachment) other_;
        return compareDeep(contentType, o.contentType, true) && compareDeep(language, o.language, true)
           && compareDeep(data, o.data, true) && compareDeep(url, o.url, true) && compareDeep(size, o.size, true)
           && compareDeep(hash, o.hash, true) && compareDeep(title, o.title, true) && compareDeep(creation, o.creation, true)
           && compareDeep(height, o.height, true) && compareDeep(width, o.width, true) && compareDeep(frames, o.frames, true)
           && compareDeep(duration, o.duration, true) && compareDeep(pages, o.pages, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Attachment))
          return false;
        Attachment o = (Attachment) other_;
        return compareValues(contentType, o.contentType, true) && compareValues(language, o.language, true)
           && compareValues(data, o.data, true) && compareValues(url, o.url, true) && compareValues(size, o.size, true)
           && compareValues(hash, o.hash, true) && compareValues(title, o.title, true) && compareValues(creation, o.creation, true)
           && compareValues(height, o.height, true) && compareValues(width, o.width, true) && compareValues(frames, o.frames, true)
           && compareValues(duration, o.duration, true) && compareValues(pages, o.pages, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(contentType, language, data
          , url, size, hash, title, creation, height, width, frames, duration, pages
          );
      }


}