package org.hl7.fhir.r5.model;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

// Generated on Thu, Dec 13, 2018 14:07+1100 for FHIR v4.0.0
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
/**
 * Related artifacts such as additional documentation, justification, or bibliographic references.
 */
@DatatypeDef(name="RelatedArtifact")
public class RelatedArtifact extends Type implements ICompositeType {

    public enum RelatedArtifactType {
        /**
         * Additional documentation for the knowledge resource. This would include additional instructions on usage as well as additional information on clinical context or appropriateness.
         */
        DOCUMENTATION, 
        /**
         * A summary of the justification for the knowledge resource including supporting evidence, relevant guidelines, or other clinically important information. This information is intended to provide a way to make the justification for the knowledge resource available to the consumer of interventions or results produced by the knowledge resource.
         */
        JUSTIFICATION, 
        /**
         * Bibliographic citation for papers, references, or other relevant material for the knowledge resource. This is intended to allow for citation of related material, but that was not necessarily specifically prepared in connection with this knowledge resource.
         */
        CITATION, 
        /**
         * The previous version of the knowledge resource.
         */
        PREDECESSOR, 
        /**
         * The next version of the knowledge resource.
         */
        SUCCESSOR, 
        /**
         * The knowledge resource is derived from the related artifact. This is intended to capture the relationship in which a particular knowledge resource is based on the content of another artifact, but is modified to capture either a different set of overall requirements, or a more specific set of requirements such as those involved in a particular institution or clinical setting.
         */
        DERIVEDFROM, 
        /**
         * The knowledge resource depends on the given related artifact.
         */
        DEPENDSON, 
        /**
         * The knowledge resource is composed of the given related artifact.
         */
        COMPOSEDOF, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static RelatedArtifactType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("documentation".equals(codeString))
          return DOCUMENTATION;
        if ("justification".equals(codeString))
          return JUSTIFICATION;
        if ("citation".equals(codeString))
          return CITATION;
        if ("predecessor".equals(codeString))
          return PREDECESSOR;
        if ("successor".equals(codeString))
          return SUCCESSOR;
        if ("derived-from".equals(codeString))
          return DERIVEDFROM;
        if ("depends-on".equals(codeString))
          return DEPENDSON;
        if ("composed-of".equals(codeString))
          return COMPOSEDOF;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown RelatedArtifactType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DOCUMENTATION: return "documentation";
            case JUSTIFICATION: return "justification";
            case CITATION: return "citation";
            case PREDECESSOR: return "predecessor";
            case SUCCESSOR: return "successor";
            case DERIVEDFROM: return "derived-from";
            case DEPENDSON: return "depends-on";
            case COMPOSEDOF: return "composed-of";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DOCUMENTATION: return "http://hl7.org/fhir/related-artifact-type";
            case JUSTIFICATION: return "http://hl7.org/fhir/related-artifact-type";
            case CITATION: return "http://hl7.org/fhir/related-artifact-type";
            case PREDECESSOR: return "http://hl7.org/fhir/related-artifact-type";
            case SUCCESSOR: return "http://hl7.org/fhir/related-artifact-type";
            case DERIVEDFROM: return "http://hl7.org/fhir/related-artifact-type";
            case DEPENDSON: return "http://hl7.org/fhir/related-artifact-type";
            case COMPOSEDOF: return "http://hl7.org/fhir/related-artifact-type";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DOCUMENTATION: return "Additional documentation for the knowledge resource. This would include additional instructions on usage as well as additional information on clinical context or appropriateness.";
            case JUSTIFICATION: return "A summary of the justification for the knowledge resource including supporting evidence, relevant guidelines, or other clinically important information. This information is intended to provide a way to make the justification for the knowledge resource available to the consumer of interventions or results produced by the knowledge resource.";
            case CITATION: return "Bibliographic citation for papers, references, or other relevant material for the knowledge resource. This is intended to allow for citation of related material, but that was not necessarily specifically prepared in connection with this knowledge resource.";
            case PREDECESSOR: return "The previous version of the knowledge resource.";
            case SUCCESSOR: return "The next version of the knowledge resource.";
            case DERIVEDFROM: return "The knowledge resource is derived from the related artifact. This is intended to capture the relationship in which a particular knowledge resource is based on the content of another artifact, but is modified to capture either a different set of overall requirements, or a more specific set of requirements such as those involved in a particular institution or clinical setting.";
            case DEPENDSON: return "The knowledge resource depends on the given related artifact.";
            case COMPOSEDOF: return "The knowledge resource is composed of the given related artifact.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DOCUMENTATION: return "Documentation";
            case JUSTIFICATION: return "Justification";
            case CITATION: return "Citation";
            case PREDECESSOR: return "Predecessor";
            case SUCCESSOR: return "Successor";
            case DERIVEDFROM: return "Derived From";
            case DEPENDSON: return "Depends On";
            case COMPOSEDOF: return "Composed Of";
            default: return "?";
          }
        }
    }

  public static class RelatedArtifactTypeEnumFactory implements EnumFactory<RelatedArtifactType> {
    public RelatedArtifactType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("documentation".equals(codeString))
          return RelatedArtifactType.DOCUMENTATION;
        if ("justification".equals(codeString))
          return RelatedArtifactType.JUSTIFICATION;
        if ("citation".equals(codeString))
          return RelatedArtifactType.CITATION;
        if ("predecessor".equals(codeString))
          return RelatedArtifactType.PREDECESSOR;
        if ("successor".equals(codeString))
          return RelatedArtifactType.SUCCESSOR;
        if ("derived-from".equals(codeString))
          return RelatedArtifactType.DERIVEDFROM;
        if ("depends-on".equals(codeString))
          return RelatedArtifactType.DEPENDSON;
        if ("composed-of".equals(codeString))
          return RelatedArtifactType.COMPOSEDOF;
        throw new IllegalArgumentException("Unknown RelatedArtifactType code '"+codeString+"'");
        }
        public Enumeration<RelatedArtifactType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RelatedArtifactType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("documentation".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.DOCUMENTATION);
        if ("justification".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.JUSTIFICATION);
        if ("citation".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CITATION);
        if ("predecessor".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.PREDECESSOR);
        if ("successor".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.SUCCESSOR);
        if ("derived-from".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.DERIVEDFROM);
        if ("depends-on".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.DEPENDSON);
        if ("composed-of".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.COMPOSEDOF);
        throw new FHIRException("Unknown RelatedArtifactType code '"+codeString+"'");
        }
    public String toCode(RelatedArtifactType code) {
      if (code == RelatedArtifactType.DOCUMENTATION)
        return "documentation";
      if (code == RelatedArtifactType.JUSTIFICATION)
        return "justification";
      if (code == RelatedArtifactType.CITATION)
        return "citation";
      if (code == RelatedArtifactType.PREDECESSOR)
        return "predecessor";
      if (code == RelatedArtifactType.SUCCESSOR)
        return "successor";
      if (code == RelatedArtifactType.DERIVEDFROM)
        return "derived-from";
      if (code == RelatedArtifactType.DEPENDSON)
        return "depends-on";
      if (code == RelatedArtifactType.COMPOSEDOF)
        return "composed-of";
      return "?";
      }
    public String toSystem(RelatedArtifactType code) {
      return code.getSystem();
      }
    }

    /**
     * The type of relationship to the related artifact.
     */
    @Child(name = "type", type = {CodeType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="documentation | justification | citation | predecessor | successor | derived-from | depends-on | composed-of", formalDefinition="The type of relationship to the related artifact." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/related-artifact-type")
    protected Enumeration<RelatedArtifactType> type;

    /**
     * A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.
     */
    @Child(name = "label", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Short label", formalDefinition="A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index." )
    protected StringType label;

    /**
     * A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.
     */
    @Child(name = "display", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Brief description of the related artifact", formalDefinition="A brief description of the document or knowledge resource being referenced, suitable for display to a consumer." )
    protected StringType display;

    /**
     * A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.
     */
    @Child(name = "citation", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Bibliographic citation for the artifact", formalDefinition="A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format." )
    protected MarkdownType citation;

    /**
     * A url for the artifact that can be followed to access the actual content.
     */
    @Child(name = "url", type = {UrlType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where the artifact can be accessed", formalDefinition="A url for the artifact that can be followed to access the actual content." )
    protected UrlType url;

    /**
     * The document being referenced, represented as an attachment. This is exclusive with the resource element.
     */
    @Child(name = "document", type = {Attachment.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What document is being referenced", formalDefinition="The document being referenced, represented as an attachment. This is exclusive with the resource element." )
    protected Attachment document;

    /**
     * The related resource, such as a library, value set, profile, or other knowledge resource.
     */
    @Child(name = "resource", type = {CanonicalType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What resource is being referenced", formalDefinition="The related resource, such as a library, value set, profile, or other knowledge resource." )
    protected CanonicalType resource;

    private static final long serialVersionUID = -695743528L;

  /**
   * Constructor
   */
    public RelatedArtifact() {
      super();
    }

  /**
   * Constructor
   */
    public RelatedArtifact(Enumeration<RelatedArtifactType> type) {
      super();
      this.type = type;
    }

    /**
     * @return {@link #type} (The type of relationship to the related artifact.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<RelatedArtifactType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<RelatedArtifactType>(new RelatedArtifactTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The type of relationship to the related artifact.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public RelatedArtifact setTypeElement(Enumeration<RelatedArtifactType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return The type of relationship to the related artifact.
     */
    public RelatedArtifactType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value The type of relationship to the related artifact.
     */
    public RelatedArtifact setType(RelatedArtifactType value) { 
        if (this.type == null)
          this.type = new Enumeration<RelatedArtifactType>(new RelatedArtifactTypeEnumFactory());
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #label} (A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
     */
    public StringType getLabelElement() { 
      if (this.label == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.label");
        else if (Configuration.doAutoCreate())
          this.label = new StringType(); // bb
      return this.label;
    }

    public boolean hasLabelElement() { 
      return this.label != null && !this.label.isEmpty();
    }

    public boolean hasLabel() { 
      return this.label != null && !this.label.isEmpty();
    }

    /**
     * @param value {@link #label} (A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
     */
    public RelatedArtifact setLabelElement(StringType value) { 
      this.label = value;
      return this;
    }

    /**
     * @return A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.
     */
    public String getLabel() { 
      return this.label == null ? null : this.label.getValue();
    }

    /**
     * @param value A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.
     */
    public RelatedArtifact setLabel(String value) { 
      if (Utilities.noString(value))
        this.label = null;
      else {
        if (this.label == null)
          this.label = new StringType();
        this.label.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #display} (A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
     */
    public StringType getDisplayElement() { 
      if (this.display == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.display");
        else if (Configuration.doAutoCreate())
          this.display = new StringType(); // bb
      return this.display;
    }

    public boolean hasDisplayElement() { 
      return this.display != null && !this.display.isEmpty();
    }

    public boolean hasDisplay() { 
      return this.display != null && !this.display.isEmpty();
    }

    /**
     * @param value {@link #display} (A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
     */
    public RelatedArtifact setDisplayElement(StringType value) { 
      this.display = value;
      return this;
    }

    /**
     * @return A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.
     */
    public String getDisplay() { 
      return this.display == null ? null : this.display.getValue();
    }

    /**
     * @param value A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.
     */
    public RelatedArtifact setDisplay(String value) { 
      if (Utilities.noString(value))
        this.display = null;
      else {
        if (this.display == null)
          this.display = new StringType();
        this.display.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #citation} (A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.). This is the underlying object with id, value and extensions. The accessor "getCitation" gives direct access to the value
     */
    public MarkdownType getCitationElement() { 
      if (this.citation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.citation");
        else if (Configuration.doAutoCreate())
          this.citation = new MarkdownType(); // bb
      return this.citation;
    }

    public boolean hasCitationElement() { 
      return this.citation != null && !this.citation.isEmpty();
    }

    public boolean hasCitation() { 
      return this.citation != null && !this.citation.isEmpty();
    }

    /**
     * @param value {@link #citation} (A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.). This is the underlying object with id, value and extensions. The accessor "getCitation" gives direct access to the value
     */
    public RelatedArtifact setCitationElement(MarkdownType value) { 
      this.citation = value;
      return this;
    }

    /**
     * @return A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.
     */
    public String getCitation() { 
      return this.citation == null ? null : this.citation.getValue();
    }

    /**
     * @param value A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.
     */
    public RelatedArtifact setCitation(String value) { 
      if (value == null)
        this.citation = null;
      else {
        if (this.citation == null)
          this.citation = new MarkdownType();
        this.citation.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #url} (A url for the artifact that can be followed to access the actual content.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UrlType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.url");
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
     * @param value {@link #url} (A url for the artifact that can be followed to access the actual content.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public RelatedArtifact setUrlElement(UrlType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return A url for the artifact that can be followed to access the actual content.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value A url for the artifact that can be followed to access the actual content.
     */
    public RelatedArtifact setUrl(String value) { 
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
     * @return {@link #document} (The document being referenced, represented as an attachment. This is exclusive with the resource element.)
     */
    public Attachment getDocument() { 
      if (this.document == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.document");
        else if (Configuration.doAutoCreate())
          this.document = new Attachment(); // cc
      return this.document;
    }

    public boolean hasDocument() { 
      return this.document != null && !this.document.isEmpty();
    }

    /**
     * @param value {@link #document} (The document being referenced, represented as an attachment. This is exclusive with the resource element.)
     */
    public RelatedArtifact setDocument(Attachment value) { 
      this.document = value;
      return this;
    }

    /**
     * @return {@link #resource} (The related resource, such as a library, value set, profile, or other knowledge resource.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
     */
    public CanonicalType getResourceElement() { 
      if (this.resource == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.resource");
        else if (Configuration.doAutoCreate())
          this.resource = new CanonicalType(); // bb
      return this.resource;
    }

    public boolean hasResourceElement() { 
      return this.resource != null && !this.resource.isEmpty();
    }

    public boolean hasResource() { 
      return this.resource != null && !this.resource.isEmpty();
    }

    /**
     * @param value {@link #resource} (The related resource, such as a library, value set, profile, or other knowledge resource.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
     */
    public RelatedArtifact setResourceElement(CanonicalType value) { 
      this.resource = value;
      return this;
    }

    /**
     * @return The related resource, such as a library, value set, profile, or other knowledge resource.
     */
    public String getResource() { 
      return this.resource == null ? null : this.resource.getValue();
    }

    /**
     * @param value The related resource, such as a library, value set, profile, or other knowledge resource.
     */
    public RelatedArtifact setResource(String value) { 
      if (Utilities.noString(value))
        this.resource = null;
      else {
        if (this.resource == null)
          this.resource = new CanonicalType();
        this.resource.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("type", "code", "The type of relationship to the related artifact.", 0, 1, type));
        children.add(new Property("label", "string", "A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.", 0, 1, label));
        children.add(new Property("display", "string", "A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.", 0, 1, display));
        children.add(new Property("citation", "markdown", "A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.", 0, 1, citation));
        children.add(new Property("url", "url", "A url for the artifact that can be followed to access the actual content.", 0, 1, url));
        children.add(new Property("document", "Attachment", "The document being referenced, represented as an attachment. This is exclusive with the resource element.", 0, 1, document));
        children.add(new Property("resource", "canonical(Any)", "The related resource, such as a library, value set, profile, or other knowledge resource.", 0, 1, resource));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3575610: /*type*/  return new Property("type", "code", "The type of relationship to the related artifact.", 0, 1, type);
        case 102727412: /*label*/  return new Property("label", "string", "A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.", 0, 1, label);
        case 1671764162: /*display*/  return new Property("display", "string", "A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.", 0, 1, display);
        case -1442706713: /*citation*/  return new Property("citation", "markdown", "A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.", 0, 1, citation);
        case 116079: /*url*/  return new Property("url", "url", "A url for the artifact that can be followed to access the actual content.", 0, 1, url);
        case 861720859: /*document*/  return new Property("document", "Attachment", "The document being referenced, represented as an attachment. This is exclusive with the resource element.", 0, 1, document);
        case -341064690: /*resource*/  return new Property("resource", "canonical(Any)", "The related resource, such as a library, value set, profile, or other knowledge resource.", 0, 1, resource);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<RelatedArtifactType>
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case 1671764162: /*display*/ return this.display == null ? new Base[0] : new Base[] {this.display}; // StringType
        case -1442706713: /*citation*/ return this.citation == null ? new Base[0] : new Base[] {this.citation}; // MarkdownType
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
        case 861720859: /*document*/ return this.document == null ? new Base[0] : new Base[] {this.document}; // Attachment
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new RelatedArtifactTypeEnumFactory().fromType(castToCode(value));
          this.type = (Enumeration) value; // Enumeration<RelatedArtifactType>
          return value;
        case 102727412: // label
          this.label = castToString(value); // StringType
          return value;
        case 1671764162: // display
          this.display = castToString(value); // StringType
          return value;
        case -1442706713: // citation
          this.citation = castToMarkdown(value); // MarkdownType
          return value;
        case 116079: // url
          this.url = castToUrl(value); // UrlType
          return value;
        case 861720859: // document
          this.document = castToAttachment(value); // Attachment
          return value;
        case -341064690: // resource
          this.resource = castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new RelatedArtifactTypeEnumFactory().fromType(castToCode(value));
          this.type = (Enumeration) value; // Enumeration<RelatedArtifactType>
        } else if (name.equals("label")) {
          this.label = castToString(value); // StringType
        } else if (name.equals("display")) {
          this.display = castToString(value); // StringType
        } else if (name.equals("citation")) {
          this.citation = castToMarkdown(value); // MarkdownType
        } else if (name.equals("url")) {
          this.url = castToUrl(value); // UrlType
        } else if (name.equals("document")) {
          this.document = castToAttachment(value); // Attachment
        } else if (name.equals("resource")) {
          this.resource = castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 102727412:  return getLabelElement();
        case 1671764162:  return getDisplayElement();
        case -1442706713:  return getCitationElement();
        case 116079:  return getUrlElement();
        case 861720859:  return getDocument(); 
        case -341064690:  return getResourceElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 102727412: /*label*/ return new String[] {"string"};
        case 1671764162: /*display*/ return new String[] {"string"};
        case -1442706713: /*citation*/ return new String[] {"markdown"};
        case 116079: /*url*/ return new String[] {"url"};
        case 861720859: /*document*/ return new String[] {"Attachment"};
        case -341064690: /*resource*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.type");
        }
        else if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.label");
        }
        else if (name.equals("display")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.display");
        }
        else if (name.equals("citation")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.citation");
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.url");
        }
        else if (name.equals("document")) {
          this.document = new Attachment();
          return this.document;
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.resource");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RelatedArtifact";

  }

      public RelatedArtifact copy() {
        RelatedArtifact dst = new RelatedArtifact();
        copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.label = label == null ? null : label.copy();
        dst.display = display == null ? null : display.copy();
        dst.citation = citation == null ? null : citation.copy();
        dst.url = url == null ? null : url.copy();
        dst.document = document == null ? null : document.copy();
        dst.resource = resource == null ? null : resource.copy();
        return dst;
      }

      protected RelatedArtifact typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RelatedArtifact))
          return false;
        RelatedArtifact o = (RelatedArtifact) other_;
        return compareDeep(type, o.type, true) && compareDeep(label, o.label, true) && compareDeep(display, o.display, true)
           && compareDeep(citation, o.citation, true) && compareDeep(url, o.url, true) && compareDeep(document, o.document, true)
           && compareDeep(resource, o.resource, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RelatedArtifact))
          return false;
        RelatedArtifact o = (RelatedArtifact) other_;
        return compareValues(type, o.type, true) && compareValues(label, o.label, true) && compareValues(display, o.display, true)
           && compareValues(citation, o.citation, true) && compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, label, display, citation
          , url, document, resource);
      }


}

