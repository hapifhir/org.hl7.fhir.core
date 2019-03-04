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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
/**
 * Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.
 */
@ResourceDef(name="ImagingStudy", profile="http://hl7.org/fhir/StructureDefinition/ImagingStudy")
public class ImagingStudy extends DomainResource {

    public enum ImagingStudyStatus {
        /**
         * The existence of the imaging study is registered, but there is nothing yet available.
         */
        REGISTERED, 
        /**
         * At least one instance has been associated with this imaging study.
         */
        AVAILABLE, 
        /**
         * The imaging study is unavailable because the imaging study was not started or not completed (also sometimes called "aborted").
         */
        CANCELLED, 
        /**
         * The imaging study has been withdrawn following a previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be "cancelled" rather than "entered-in-error".).
         */
        ENTEREDINERROR, 
        /**
         * The system does not know which of the status values currently applies for this request. Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply, it's just not known which one.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ImagingStudyStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return REGISTERED;
        if ("available".equals(codeString))
          return AVAILABLE;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ImagingStudyStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REGISTERED: return "registered";
            case AVAILABLE: return "available";
            case CANCELLED: return "cancelled";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REGISTERED: return "http://hl7.org/fhir/imagingstudy-status";
            case AVAILABLE: return "http://hl7.org/fhir/imagingstudy-status";
            case CANCELLED: return "http://hl7.org/fhir/imagingstudy-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/imagingstudy-status";
            case UNKNOWN: return "http://hl7.org/fhir/imagingstudy-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REGISTERED: return "The existence of the imaging study is registered, but there is nothing yet available.";
            case AVAILABLE: return "At least one instance has been associated with this imaging study.";
            case CANCELLED: return "The imaging study is unavailable because the imaging study was not started or not completed (also sometimes called \"aborted\").";
            case ENTEREDINERROR: return "The imaging study has been withdrawn following a previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The system does not know which of the status values currently applies for this request. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, it's just not known which one.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REGISTERED: return "Registered";
            case AVAILABLE: return "Available";
            case CANCELLED: return "Cancelled";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            default: return "?";
          }
        }
    }

  public static class ImagingStudyStatusEnumFactory implements EnumFactory<ImagingStudyStatus> {
    public ImagingStudyStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return ImagingStudyStatus.REGISTERED;
        if ("available".equals(codeString))
          return ImagingStudyStatus.AVAILABLE;
        if ("cancelled".equals(codeString))
          return ImagingStudyStatus.CANCELLED;
        if ("entered-in-error".equals(codeString))
          return ImagingStudyStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return ImagingStudyStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown ImagingStudyStatus code '"+codeString+"'");
        }
        public Enumeration<ImagingStudyStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ImagingStudyStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("registered".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.REGISTERED);
        if ("available".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.AVAILABLE);
        if ("cancelled".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.CANCELLED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.UNKNOWN);
        throw new FHIRException("Unknown ImagingStudyStatus code '"+codeString+"'");
        }
    public String toCode(ImagingStudyStatus code) {
      if (code == ImagingStudyStatus.REGISTERED)
        return "registered";
      if (code == ImagingStudyStatus.AVAILABLE)
        return "available";
      if (code == ImagingStudyStatus.CANCELLED)
        return "cancelled";
      if (code == ImagingStudyStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == ImagingStudyStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(ImagingStudyStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ImagingStudySeriesComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The DICOM Series Instance UID for the series.
         */
        @Child(name = "uid", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="DICOM Series Instance UID for the series", formalDefinition="The DICOM Series Instance UID for the series." )
        protected IdType uid;

        /**
         * The numeric identifier of this series in the study.
         */
        @Child(name = "number", type = {UnsignedIntType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Numeric identifier of this series", formalDefinition="The numeric identifier of this series in the study." )
        protected UnsignedIntType number;

        /**
         * The modality of this series sequence.
         */
        @Child(name = "modality", type = {Coding.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The modality of the instances in the series", formalDefinition="The modality of this series sequence." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_29.html")
        protected Coding modality;

        /**
         * A description of the series.
         */
        @Child(name = "description", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A short human readable summary of the series", formalDefinition="A description of the series." )
        protected StringType description;

        /**
         * Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.
         */
        @Child(name = "numberOfInstances", type = {UnsignedIntType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Number of Series Related Instances", formalDefinition="Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present." )
        protected UnsignedIntType numberOfInstances;

        /**
         * The network service providing access (e.g., query, view, or retrieval) for this series. See implementation notes for information about using DICOM endpoints. A series-level endpoint, if present, has precedence over a study-level endpoint with the same Endpoint.connectionType.
         */
        @Child(name = "endpoint", type = {Endpoint.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Series access endpoint", formalDefinition="The network service providing access (e.g., query, view, or retrieval) for this series. See implementation notes for information about using DICOM endpoints. A series-level endpoint, if present, has precedence over a study-level endpoint with the same Endpoint.connectionType." )
        protected List<Reference> endpoint;
        /**
         * The actual objects that are the target of the reference (The network service providing access (e.g., query, view, or retrieval) for this series. See implementation notes for information about using DICOM endpoints. A series-level endpoint, if present, has precedence over a study-level endpoint with the same Endpoint.connectionType.)
         */
        protected List<Endpoint> endpointTarget;


        /**
         * The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.
         */
        @Child(name = "bodySite", type = {Coding.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Body part examined", formalDefinition="The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
        protected Coding bodySite;

        /**
         * The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.
         */
        @Child(name = "laterality", type = {Coding.class}, order=8, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Body part laterality", formalDefinition="The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/bodysite-laterality")
        protected Coding laterality;

        /**
         * The specimen imaged, e.g., for whole slide imaging of a biopsy.
         */
        @Child(name = "specimen", type = {Specimen.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Specimen imaged", formalDefinition="The specimen imaged, e.g., for whole slide imaging of a biopsy." )
        protected List<Reference> specimen;
        /**
         * The actual objects that are the target of the reference (The specimen imaged, e.g., for whole slide imaging of a biopsy.)
         */
        protected List<Specimen> specimenTarget;


        /**
         * The date and time the series was started.
         */
        @Child(name = "started", type = {DateTimeType.class}, order=10, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="When the series started", formalDefinition="The date and time the series was started." )
        protected DateTimeType started;

        /**
         * Indicates who or what performed the series and how they were involved.
         */
        @Child(name = "performer", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Who performed the series", formalDefinition="Indicates who or what performed the series and how they were involved." )
        protected List<ImagingStudySeriesPerformerComponent> performer;

        /**
         * A single SOP instance within the series, e.g. an image, or presentation state.
         */
        @Child(name = "instance", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A single SOP instance from the series", formalDefinition="A single SOP instance within the series, e.g. an image, or presentation state." )
        protected List<ImagingStudySeriesInstanceComponent> instance;

        private static final long serialVersionUID = -11423429L;

    /**
     * Constructor
     */
      public ImagingStudySeriesComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ImagingStudySeriesComponent(IdType uid, Coding modality) {
        super();
        this.uid = uid;
        this.modality = modality;
      }

        /**
         * @return {@link #uid} (The DICOM Series Instance UID for the series.). This is the underlying object with id, value and extensions. The accessor "getUid" gives direct access to the value
         */
        public IdType getUidElement() { 
          if (this.uid == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.uid");
            else if (Configuration.doAutoCreate())
              this.uid = new IdType(); // bb
          return this.uid;
        }

        public boolean hasUidElement() { 
          return this.uid != null && !this.uid.isEmpty();
        }

        public boolean hasUid() { 
          return this.uid != null && !this.uid.isEmpty();
        }

        /**
         * @param value {@link #uid} (The DICOM Series Instance UID for the series.). This is the underlying object with id, value and extensions. The accessor "getUid" gives direct access to the value
         */
        public ImagingStudySeriesComponent setUidElement(IdType value) { 
          this.uid = value;
          return this;
        }

        /**
         * @return The DICOM Series Instance UID for the series.
         */
        public String getUid() { 
          return this.uid == null ? null : this.uid.getValue();
        }

        /**
         * @param value The DICOM Series Instance UID for the series.
         */
        public ImagingStudySeriesComponent setUid(String value) { 
            if (this.uid == null)
              this.uid = new IdType();
            this.uid.setValue(value);
          return this;
        }

        /**
         * @return {@link #number} (The numeric identifier of this series in the study.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public UnsignedIntType getNumberElement() { 
          if (this.number == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.number");
            else if (Configuration.doAutoCreate())
              this.number = new UnsignedIntType(); // bb
          return this.number;
        }

        public boolean hasNumberElement() { 
          return this.number != null && !this.number.isEmpty();
        }

        public boolean hasNumber() { 
          return this.number != null && !this.number.isEmpty();
        }

        /**
         * @param value {@link #number} (The numeric identifier of this series in the study.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public ImagingStudySeriesComponent setNumberElement(UnsignedIntType value) { 
          this.number = value;
          return this;
        }

        /**
         * @return The numeric identifier of this series in the study.
         */
        public int getNumber() { 
          return this.number == null || this.number.isEmpty() ? 0 : this.number.getValue();
        }

        /**
         * @param value The numeric identifier of this series in the study.
         */
        public ImagingStudySeriesComponent setNumber(int value) { 
            if (this.number == null)
              this.number = new UnsignedIntType();
            this.number.setValue(value);
          return this;
        }

        /**
         * @return {@link #modality} (The modality of this series sequence.)
         */
        public Coding getModality() { 
          if (this.modality == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.modality");
            else if (Configuration.doAutoCreate())
              this.modality = new Coding(); // cc
          return this.modality;
        }

        public boolean hasModality() { 
          return this.modality != null && !this.modality.isEmpty();
        }

        /**
         * @param value {@link #modality} (The modality of this series sequence.)
         */
        public ImagingStudySeriesComponent setModality(Coding value) { 
          this.modality = value;
          return this;
        }

        /**
         * @return {@link #description} (A description of the series.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.description");
            else if (Configuration.doAutoCreate())
              this.description = new StringType(); // bb
          return this.description;
        }

        public boolean hasDescriptionElement() { 
          return this.description != null && !this.description.isEmpty();
        }

        public boolean hasDescription() { 
          return this.description != null && !this.description.isEmpty();
        }

        /**
         * @param value {@link #description} (A description of the series.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ImagingStudySeriesComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A description of the series.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A description of the series.
         */
        public ImagingStudySeriesComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #numberOfInstances} (Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.). This is the underlying object with id, value and extensions. The accessor "getNumberOfInstances" gives direct access to the value
         */
        public UnsignedIntType getNumberOfInstancesElement() { 
          if (this.numberOfInstances == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.numberOfInstances");
            else if (Configuration.doAutoCreate())
              this.numberOfInstances = new UnsignedIntType(); // bb
          return this.numberOfInstances;
        }

        public boolean hasNumberOfInstancesElement() { 
          return this.numberOfInstances != null && !this.numberOfInstances.isEmpty();
        }

        public boolean hasNumberOfInstances() { 
          return this.numberOfInstances != null && !this.numberOfInstances.isEmpty();
        }

        /**
         * @param value {@link #numberOfInstances} (Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.). This is the underlying object with id, value and extensions. The accessor "getNumberOfInstances" gives direct access to the value
         */
        public ImagingStudySeriesComponent setNumberOfInstancesElement(UnsignedIntType value) { 
          this.numberOfInstances = value;
          return this;
        }

        /**
         * @return Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.
         */
        public int getNumberOfInstances() { 
          return this.numberOfInstances == null || this.numberOfInstances.isEmpty() ? 0 : this.numberOfInstances.getValue();
        }

        /**
         * @param value Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.
         */
        public ImagingStudySeriesComponent setNumberOfInstances(int value) { 
            if (this.numberOfInstances == null)
              this.numberOfInstances = new UnsignedIntType();
            this.numberOfInstances.setValue(value);
          return this;
        }

        /**
         * @return {@link #endpoint} (The network service providing access (e.g., query, view, or retrieval) for this series. See implementation notes for information about using DICOM endpoints. A series-level endpoint, if present, has precedence over a study-level endpoint with the same Endpoint.connectionType.)
         */
        public List<Reference> getEndpoint() { 
          if (this.endpoint == null)
            this.endpoint = new ArrayList<Reference>();
          return this.endpoint;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingStudySeriesComponent setEndpoint(List<Reference> theEndpoint) { 
          this.endpoint = theEndpoint;
          return this;
        }

        public boolean hasEndpoint() { 
          if (this.endpoint == null)
            return false;
          for (Reference item : this.endpoint)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addEndpoint() { //3
          Reference t = new Reference();
          if (this.endpoint == null)
            this.endpoint = new ArrayList<Reference>();
          this.endpoint.add(t);
          return t;
        }

        public ImagingStudySeriesComponent addEndpoint(Reference t) { //3
          if (t == null)
            return this;
          if (this.endpoint == null)
            this.endpoint = new ArrayList<Reference>();
          this.endpoint.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #endpoint}, creating it if it does not already exist
         */
        public Reference getEndpointFirstRep() { 
          if (getEndpoint().isEmpty()) {
            addEndpoint();
          }
          return getEndpoint().get(0);
        }

        /**
         * @deprecated Use Reference#setResource(IBaseResource) instead
         */
        @Deprecated
        public List<Endpoint> getEndpointTarget() { 
          if (this.endpointTarget == null)
            this.endpointTarget = new ArrayList<Endpoint>();
          return this.endpointTarget;
        }

        /**
         * @deprecated Use Reference#setResource(IBaseResource) instead
         */
        @Deprecated
        public Endpoint addEndpointTarget() { 
          Endpoint r = new Endpoint();
          if (this.endpointTarget == null)
            this.endpointTarget = new ArrayList<Endpoint>();
          this.endpointTarget.add(r);
          return r;
        }

        /**
         * @return {@link #bodySite} (The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.)
         */
        public Coding getBodySite() { 
          if (this.bodySite == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.bodySite");
            else if (Configuration.doAutoCreate())
              this.bodySite = new Coding(); // cc
          return this.bodySite;
        }

        public boolean hasBodySite() { 
          return this.bodySite != null && !this.bodySite.isEmpty();
        }

        /**
         * @param value {@link #bodySite} (The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.)
         */
        public ImagingStudySeriesComponent setBodySite(Coding value) { 
          this.bodySite = value;
          return this;
        }

        /**
         * @return {@link #laterality} (The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.)
         */
        public Coding getLaterality() { 
          if (this.laterality == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.laterality");
            else if (Configuration.doAutoCreate())
              this.laterality = new Coding(); // cc
          return this.laterality;
        }

        public boolean hasLaterality() { 
          return this.laterality != null && !this.laterality.isEmpty();
        }

        /**
         * @param value {@link #laterality} (The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.)
         */
        public ImagingStudySeriesComponent setLaterality(Coding value) { 
          this.laterality = value;
          return this;
        }

        /**
         * @return {@link #specimen} (The specimen imaged, e.g., for whole slide imaging of a biopsy.)
         */
        public List<Reference> getSpecimen() { 
          if (this.specimen == null)
            this.specimen = new ArrayList<Reference>();
          return this.specimen;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingStudySeriesComponent setSpecimen(List<Reference> theSpecimen) { 
          this.specimen = theSpecimen;
          return this;
        }

        public boolean hasSpecimen() { 
          if (this.specimen == null)
            return false;
          for (Reference item : this.specimen)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSpecimen() { //3
          Reference t = new Reference();
          if (this.specimen == null)
            this.specimen = new ArrayList<Reference>();
          this.specimen.add(t);
          return t;
        }

        public ImagingStudySeriesComponent addSpecimen(Reference t) { //3
          if (t == null)
            return this;
          if (this.specimen == null)
            this.specimen = new ArrayList<Reference>();
          this.specimen.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #specimen}, creating it if it does not already exist
         */
        public Reference getSpecimenFirstRep() { 
          if (getSpecimen().isEmpty()) {
            addSpecimen();
          }
          return getSpecimen().get(0);
        }

        /**
         * @deprecated Use Reference#setResource(IBaseResource) instead
         */
        @Deprecated
        public List<Specimen> getSpecimenTarget() { 
          if (this.specimenTarget == null)
            this.specimenTarget = new ArrayList<Specimen>();
          return this.specimenTarget;
        }

        /**
         * @deprecated Use Reference#setResource(IBaseResource) instead
         */
        @Deprecated
        public Specimen addSpecimenTarget() { 
          Specimen r = new Specimen();
          if (this.specimenTarget == null)
            this.specimenTarget = new ArrayList<Specimen>();
          this.specimenTarget.add(r);
          return r;
        }

        /**
         * @return {@link #started} (The date and time the series was started.). This is the underlying object with id, value and extensions. The accessor "getStarted" gives direct access to the value
         */
        public DateTimeType getStartedElement() { 
          if (this.started == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.started");
            else if (Configuration.doAutoCreate())
              this.started = new DateTimeType(); // bb
          return this.started;
        }

        public boolean hasStartedElement() { 
          return this.started != null && !this.started.isEmpty();
        }

        public boolean hasStarted() { 
          return this.started != null && !this.started.isEmpty();
        }

        /**
         * @param value {@link #started} (The date and time the series was started.). This is the underlying object with id, value and extensions. The accessor "getStarted" gives direct access to the value
         */
        public ImagingStudySeriesComponent setStartedElement(DateTimeType value) { 
          this.started = value;
          return this;
        }

        /**
         * @return The date and time the series was started.
         */
        public Date getStarted() { 
          return this.started == null ? null : this.started.getValue();
        }

        /**
         * @param value The date and time the series was started.
         */
        public ImagingStudySeriesComponent setStarted(Date value) { 
          if (value == null)
            this.started = null;
          else {
            if (this.started == null)
              this.started = new DateTimeType();
            this.started.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #performer} (Indicates who or what performed the series and how they were involved.)
         */
        public List<ImagingStudySeriesPerformerComponent> getPerformer() { 
          if (this.performer == null)
            this.performer = new ArrayList<ImagingStudySeriesPerformerComponent>();
          return this.performer;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingStudySeriesComponent setPerformer(List<ImagingStudySeriesPerformerComponent> thePerformer) { 
          this.performer = thePerformer;
          return this;
        }

        public boolean hasPerformer() { 
          if (this.performer == null)
            return false;
          for (ImagingStudySeriesPerformerComponent item : this.performer)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ImagingStudySeriesPerformerComponent addPerformer() { //3
          ImagingStudySeriesPerformerComponent t = new ImagingStudySeriesPerformerComponent();
          if (this.performer == null)
            this.performer = new ArrayList<ImagingStudySeriesPerformerComponent>();
          this.performer.add(t);
          return t;
        }

        public ImagingStudySeriesComponent addPerformer(ImagingStudySeriesPerformerComponent t) { //3
          if (t == null)
            return this;
          if (this.performer == null)
            this.performer = new ArrayList<ImagingStudySeriesPerformerComponent>();
          this.performer.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist
         */
        public ImagingStudySeriesPerformerComponent getPerformerFirstRep() { 
          if (getPerformer().isEmpty()) {
            addPerformer();
          }
          return getPerformer().get(0);
        }

        /**
         * @return {@link #instance} (A single SOP instance within the series, e.g. an image, or presentation state.)
         */
        public List<ImagingStudySeriesInstanceComponent> getInstance() { 
          if (this.instance == null)
            this.instance = new ArrayList<ImagingStudySeriesInstanceComponent>();
          return this.instance;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ImagingStudySeriesComponent setInstance(List<ImagingStudySeriesInstanceComponent> theInstance) { 
          this.instance = theInstance;
          return this;
        }

        public boolean hasInstance() { 
          if (this.instance == null)
            return false;
          for (ImagingStudySeriesInstanceComponent item : this.instance)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ImagingStudySeriesInstanceComponent addInstance() { //3
          ImagingStudySeriesInstanceComponent t = new ImagingStudySeriesInstanceComponent();
          if (this.instance == null)
            this.instance = new ArrayList<ImagingStudySeriesInstanceComponent>();
          this.instance.add(t);
          return t;
        }

        public ImagingStudySeriesComponent addInstance(ImagingStudySeriesInstanceComponent t) { //3
          if (t == null)
            return this;
          if (this.instance == null)
            this.instance = new ArrayList<ImagingStudySeriesInstanceComponent>();
          this.instance.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #instance}, creating it if it does not already exist
         */
        public ImagingStudySeriesInstanceComponent getInstanceFirstRep() { 
          if (getInstance().isEmpty()) {
            addInstance();
          }
          return getInstance().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("uid", "id", "The DICOM Series Instance UID for the series.", 0, 1, uid));
          children.add(new Property("number", "unsignedInt", "The numeric identifier of this series in the study.", 0, 1, number));
          children.add(new Property("modality", "Coding", "The modality of this series sequence.", 0, 1, modality));
          children.add(new Property("description", "string", "A description of the series.", 0, 1, description));
          children.add(new Property("numberOfInstances", "unsignedInt", "Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.", 0, 1, numberOfInstances));
          children.add(new Property("endpoint", "Reference(Endpoint)", "The network service providing access (e.g., query, view, or retrieval) for this series. See implementation notes for information about using DICOM endpoints. A series-level endpoint, if present, has precedence over a study-level endpoint with the same Endpoint.connectionType.", 0, java.lang.Integer.MAX_VALUE, endpoint));
          children.add(new Property("bodySite", "Coding", "The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.", 0, 1, bodySite));
          children.add(new Property("laterality", "Coding", "The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.", 0, 1, laterality));
          children.add(new Property("specimen", "Reference(Specimen)", "The specimen imaged, e.g., for whole slide imaging of a biopsy.", 0, java.lang.Integer.MAX_VALUE, specimen));
          children.add(new Property("started", "dateTime", "The date and time the series was started.", 0, 1, started));
          children.add(new Property("performer", "", "Indicates who or what performed the series and how they were involved.", 0, java.lang.Integer.MAX_VALUE, performer));
          children.add(new Property("instance", "", "A single SOP instance within the series, e.g. an image, or presentation state.", 0, java.lang.Integer.MAX_VALUE, instance));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 115792: /*uid*/  return new Property("uid", "id", "The DICOM Series Instance UID for the series.", 0, 1, uid);
          case -1034364087: /*number*/  return new Property("number", "unsignedInt", "The numeric identifier of this series in the study.", 0, 1, number);
          case -622722335: /*modality*/  return new Property("modality", "Coding", "The modality of this series sequence.", 0, 1, modality);
          case -1724546052: /*description*/  return new Property("description", "string", "A description of the series.", 0, 1, description);
          case -1043544226: /*numberOfInstances*/  return new Property("numberOfInstances", "unsignedInt", "Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.", 0, 1, numberOfInstances);
          case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "The network service providing access (e.g., query, view, or retrieval) for this series. See implementation notes for information about using DICOM endpoints. A series-level endpoint, if present, has precedence over a study-level endpoint with the same Endpoint.connectionType.", 0, java.lang.Integer.MAX_VALUE, endpoint);
          case 1702620169: /*bodySite*/  return new Property("bodySite", "Coding", "The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.", 0, 1, bodySite);
          case -170291817: /*laterality*/  return new Property("laterality", "Coding", "The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.", 0, 1, laterality);
          case -2132868344: /*specimen*/  return new Property("specimen", "Reference(Specimen)", "The specimen imaged, e.g., for whole slide imaging of a biopsy.", 0, java.lang.Integer.MAX_VALUE, specimen);
          case -1897185151: /*started*/  return new Property("started", "dateTime", "The date and time the series was started.", 0, 1, started);
          case 481140686: /*performer*/  return new Property("performer", "", "Indicates who or what performed the series and how they were involved.", 0, java.lang.Integer.MAX_VALUE, performer);
          case 555127957: /*instance*/  return new Property("instance", "", "A single SOP instance within the series, e.g. an image, or presentation state.", 0, java.lang.Integer.MAX_VALUE, instance);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return this.uid == null ? new Base[0] : new Base[] {this.uid}; // IdType
        case -1034364087: /*number*/ return this.number == null ? new Base[0] : new Base[] {this.number}; // UnsignedIntType
        case -622722335: /*modality*/ return this.modality == null ? new Base[0] : new Base[] {this.modality}; // Coding
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1043544226: /*numberOfInstances*/ return this.numberOfInstances == null ? new Base[0] : new Base[] {this.numberOfInstances}; // UnsignedIntType
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // Coding
        case -170291817: /*laterality*/ return this.laterality == null ? new Base[0] : new Base[] {this.laterality}; // Coding
        case -2132868344: /*specimen*/ return this.specimen == null ? new Base[0] : this.specimen.toArray(new Base[this.specimen.size()]); // Reference
        case -1897185151: /*started*/ return this.started == null ? new Base[0] : new Base[] {this.started}; // DateTimeType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // ImagingStudySeriesPerformerComponent
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : this.instance.toArray(new Base[this.instance.size()]); // ImagingStudySeriesInstanceComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 115792: // uid
          this.uid = castToId(value); // IdType
          return value;
        case -1034364087: // number
          this.number = castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -622722335: // modality
          this.modality = castToCoding(value); // Coding
          return value;
        case -1724546052: // description
          this.description = castToString(value); // StringType
          return value;
        case -1043544226: // numberOfInstances
          this.numberOfInstances = castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(castToReference(value)); // Reference
          return value;
        case 1702620169: // bodySite
          this.bodySite = castToCoding(value); // Coding
          return value;
        case -170291817: // laterality
          this.laterality = castToCoding(value); // Coding
          return value;
        case -2132868344: // specimen
          this.getSpecimen().add(castToReference(value)); // Reference
          return value;
        case -1897185151: // started
          this.started = castToDateTime(value); // DateTimeType
          return value;
        case 481140686: // performer
          this.getPerformer().add((ImagingStudySeriesPerformerComponent) value); // ImagingStudySeriesPerformerComponent
          return value;
        case 555127957: // instance
          this.getInstance().add((ImagingStudySeriesInstanceComponent) value); // ImagingStudySeriesInstanceComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = castToId(value); // IdType
        } else if (name.equals("number")) {
          this.number = castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("modality")) {
          this.modality = castToCoding(value); // Coding
        } else if (name.equals("description")) {
          this.description = castToString(value); // StringType
        } else if (name.equals("numberOfInstances")) {
          this.numberOfInstances = castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(castToReference(value));
        } else if (name.equals("bodySite")) {
          this.bodySite = castToCoding(value); // Coding
        } else if (name.equals("laterality")) {
          this.laterality = castToCoding(value); // Coding
        } else if (name.equals("specimen")) {
          this.getSpecimen().add(castToReference(value));
        } else if (name.equals("started")) {
          this.started = castToDateTime(value); // DateTimeType
        } else if (name.equals("performer")) {
          this.getPerformer().add((ImagingStudySeriesPerformerComponent) value);
        } else if (name.equals("instance")) {
          this.getInstance().add((ImagingStudySeriesInstanceComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792:  return getUidElement();
        case -1034364087:  return getNumberElement();
        case -622722335:  return getModality(); 
        case -1724546052:  return getDescriptionElement();
        case -1043544226:  return getNumberOfInstancesElement();
        case 1741102485:  return addEndpoint(); 
        case 1702620169:  return getBodySite(); 
        case -170291817:  return getLaterality(); 
        case -2132868344:  return addSpecimen(); 
        case -1897185151:  return getStartedElement();
        case 481140686:  return addPerformer(); 
        case 555127957:  return addInstance(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return new String[] {"id"};
        case -1034364087: /*number*/ return new String[] {"unsignedInt"};
        case -622722335: /*modality*/ return new String[] {"Coding"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1043544226: /*numberOfInstances*/ return new String[] {"unsignedInt"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        case 1702620169: /*bodySite*/ return new String[] {"Coding"};
        case -170291817: /*laterality*/ return new String[] {"Coding"};
        case -2132868344: /*specimen*/ return new String[] {"Reference"};
        case -1897185151: /*started*/ return new String[] {"dateTime"};
        case 481140686: /*performer*/ return new String[] {};
        case 555127957: /*instance*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.uid");
        }
        else if (name.equals("number")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.number");
        }
        else if (name.equals("modality")) {
          this.modality = new Coding();
          return this.modality;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.description");
        }
        else if (name.equals("numberOfInstances")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.numberOfInstances");
        }
        else if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new Coding();
          return this.bodySite;
        }
        else if (name.equals("laterality")) {
          this.laterality = new Coding();
          return this.laterality;
        }
        else if (name.equals("specimen")) {
          return addSpecimen();
        }
        else if (name.equals("started")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.started");
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("instance")) {
          return addInstance();
        }
        else
          return super.addChild(name);
      }

      public ImagingStudySeriesComponent copy() {
        ImagingStudySeriesComponent dst = new ImagingStudySeriesComponent();
        copyValues(dst);
        dst.uid = uid == null ? null : uid.copy();
        dst.number = number == null ? null : number.copy();
        dst.modality = modality == null ? null : modality.copy();
        dst.description = description == null ? null : description.copy();
        dst.numberOfInstances = numberOfInstances == null ? null : numberOfInstances.copy();
        if (endpoint != null) {
          dst.endpoint = new ArrayList<Reference>();
          for (Reference i : endpoint)
            dst.endpoint.add(i.copy());
        };
        dst.bodySite = bodySite == null ? null : bodySite.copy();
        dst.laterality = laterality == null ? null : laterality.copy();
        if (specimen != null) {
          dst.specimen = new ArrayList<Reference>();
          for (Reference i : specimen)
            dst.specimen.add(i.copy());
        };
        dst.started = started == null ? null : started.copy();
        if (performer != null) {
          dst.performer = new ArrayList<ImagingStudySeriesPerformerComponent>();
          for (ImagingStudySeriesPerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        if (instance != null) {
          dst.instance = new ArrayList<ImagingStudySeriesInstanceComponent>();
          for (ImagingStudySeriesInstanceComponent i : instance)
            dst.instance.add(i.copy());
        };
        return dst;
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingStudySeriesComponent))
          return false;
        ImagingStudySeriesComponent o = (ImagingStudySeriesComponent) other_;
        return compareDeep(uid, o.uid, true) && compareDeep(number, o.number, true) && compareDeep(modality, o.modality, true)
           && compareDeep(description, o.description, true) && compareDeep(numberOfInstances, o.numberOfInstances, true)
           && compareDeep(endpoint, o.endpoint, true) && compareDeep(bodySite, o.bodySite, true) && compareDeep(laterality, o.laterality, true)
           && compareDeep(specimen, o.specimen, true) && compareDeep(started, o.started, true) && compareDeep(performer, o.performer, true)
           && compareDeep(instance, o.instance, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingStudySeriesComponent))
          return false;
        ImagingStudySeriesComponent o = (ImagingStudySeriesComponent) other_;
        return compareValues(uid, o.uid, true) && compareValues(number, o.number, true) && compareValues(description, o.description, true)
           && compareValues(numberOfInstances, o.numberOfInstances, true) && compareValues(started, o.started, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uid, number, modality, description
          , numberOfInstances, endpoint, bodySite, laterality, specimen, started, performer
          , instance);
      }

  public String fhirType() {
    return "ImagingStudy.series";

  }

  }

    @Block()
    public static class ImagingStudySeriesPerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distinguishes the type of involvement of the performer in the series.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of performance", formalDefinition="Distinguishes the type of involvement of the performer in the series." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/series-performer-function")
        protected CodeableConcept function;

        /**
         * Indicates who or what performed the series.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, Device.class, RelatedPerson.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who performed the series", formalDefinition="Indicates who or what performed the series." )
        protected Reference actor;

        /**
         * The actual object that is the target of the reference (Indicates who or what performed the series.)
         */
        protected Resource actorTarget;

        private static final long serialVersionUID = 1424001049L;

    /**
     * Constructor
     */
      public ImagingStudySeriesPerformerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ImagingStudySeriesPerformerComponent(Reference actor) {
        super();
        this.actor = actor;
      }

        /**
         * @return {@link #function} (Distinguishes the type of involvement of the performer in the series.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesPerformerComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Distinguishes the type of involvement of the performer in the series.)
         */
        public ImagingStudySeriesPerformerComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (Indicates who or what performed the series.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesPerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Indicates who or what performed the series.)
         */
        public ImagingStudySeriesPerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        /**
         * @return {@link #actor} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Indicates who or what performed the series.)
         */
        public Resource getActorTarget() { 
          return this.actorTarget;
        }

        /**
         * @param value {@link #actor} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Indicates who or what performed the series.)
         */
        public ImagingStudySeriesPerformerComponent setActorTarget(Resource value) { 
          this.actorTarget = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the performer in the series.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Indicates who or what performed the series.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the performer in the series.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Indicates who or what performed the series.", 0, 1, actor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1380938712: // function
          this.function = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor")) {
          this.actor = castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712:  return getFunction(); 
        case 92645877:  return getActor(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("function")) {
          this.function = new CodeableConcept();
          return this.function;
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else
          return super.addChild(name);
      }

      public ImagingStudySeriesPerformerComponent copy() {
        ImagingStudySeriesPerformerComponent dst = new ImagingStudySeriesPerformerComponent();
        copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
        return dst;
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingStudySeriesPerformerComponent))
          return false;
        ImagingStudySeriesPerformerComponent o = (ImagingStudySeriesPerformerComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingStudySeriesPerformerComponent))
          return false;
        ImagingStudySeriesPerformerComponent o = (ImagingStudySeriesPerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "ImagingStudy.series.performer";

  }

  }

    @Block()
    public static class ImagingStudySeriesInstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The DICOM SOP Instance UID for this image or other DICOM content.
         */
        @Child(name = "uid", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="DICOM SOP Instance UID", formalDefinition="The DICOM SOP Instance UID for this image or other DICOM content." )
        protected IdType uid;

        /**
         * DICOM instance  type.
         */
        @Child(name = "sopClass", type = {Coding.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="DICOM class type", formalDefinition="DICOM instance  type." )
        protected Coding sopClass;

        /**
         * The number of instance in the series.
         */
        @Child(name = "number", type = {UnsignedIntType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The number of this instance in the series", formalDefinition="The number of instance in the series." )
        protected UnsignedIntType number;

        /**
         * The description of the instance.
         */
        @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of instance", formalDefinition="The description of the instance." )
        protected StringType title;

        private static final long serialVersionUID = -888152445L;

    /**
     * Constructor
     */
      public ImagingStudySeriesInstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ImagingStudySeriesInstanceComponent(IdType uid, Coding sopClass) {
        super();
        this.uid = uid;
        this.sopClass = sopClass;
      }

        /**
         * @return {@link #uid} (The DICOM SOP Instance UID for this image or other DICOM content.). This is the underlying object with id, value and extensions. The accessor "getUid" gives direct access to the value
         */
        public IdType getUidElement() { 
          if (this.uid == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesInstanceComponent.uid");
            else if (Configuration.doAutoCreate())
              this.uid = new IdType(); // bb
          return this.uid;
        }

        public boolean hasUidElement() { 
          return this.uid != null && !this.uid.isEmpty();
        }

        public boolean hasUid() { 
          return this.uid != null && !this.uid.isEmpty();
        }

        /**
         * @param value {@link #uid} (The DICOM SOP Instance UID for this image or other DICOM content.). This is the underlying object with id, value and extensions. The accessor "getUid" gives direct access to the value
         */
        public ImagingStudySeriesInstanceComponent setUidElement(IdType value) { 
          this.uid = value;
          return this;
        }

        /**
         * @return The DICOM SOP Instance UID for this image or other DICOM content.
         */
        public String getUid() { 
          return this.uid == null ? null : this.uid.getValue();
        }

        /**
         * @param value The DICOM SOP Instance UID for this image or other DICOM content.
         */
        public ImagingStudySeriesInstanceComponent setUid(String value) { 
            if (this.uid == null)
              this.uid = new IdType();
            this.uid.setValue(value);
          return this;
        }

        /**
         * @return {@link #sopClass} (DICOM instance  type.)
         */
        public Coding getSopClass() { 
          if (this.sopClass == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesInstanceComponent.sopClass");
            else if (Configuration.doAutoCreate())
              this.sopClass = new Coding(); // cc
          return this.sopClass;
        }

        public boolean hasSopClass() { 
          return this.sopClass != null && !this.sopClass.isEmpty();
        }

        /**
         * @param value {@link #sopClass} (DICOM instance  type.)
         */
        public ImagingStudySeriesInstanceComponent setSopClass(Coding value) { 
          this.sopClass = value;
          return this;
        }

        /**
         * @return {@link #number} (The number of instance in the series.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public UnsignedIntType getNumberElement() { 
          if (this.number == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesInstanceComponent.number");
            else if (Configuration.doAutoCreate())
              this.number = new UnsignedIntType(); // bb
          return this.number;
        }

        public boolean hasNumberElement() { 
          return this.number != null && !this.number.isEmpty();
        }

        public boolean hasNumber() { 
          return this.number != null && !this.number.isEmpty();
        }

        /**
         * @param value {@link #number} (The number of instance in the series.). This is the underlying object with id, value and extensions. The accessor "getNumber" gives direct access to the value
         */
        public ImagingStudySeriesInstanceComponent setNumberElement(UnsignedIntType value) { 
          this.number = value;
          return this;
        }

        /**
         * @return The number of instance in the series.
         */
        public int getNumber() { 
          return this.number == null || this.number.isEmpty() ? 0 : this.number.getValue();
        }

        /**
         * @param value The number of instance in the series.
         */
        public ImagingStudySeriesInstanceComponent setNumber(int value) { 
            if (this.number == null)
              this.number = new UnsignedIntType();
            this.number.setValue(value);
          return this;
        }

        /**
         * @return {@link #title} (The description of the instance.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesInstanceComponent.title");
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
         * @param value {@link #title} (The description of the instance.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public ImagingStudySeriesInstanceComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return The description of the instance.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value The description of the instance.
         */
        public ImagingStudySeriesInstanceComponent setTitle(String value) { 
          if (Utilities.noString(value))
            this.title = null;
          else {
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("uid", "id", "The DICOM SOP Instance UID for this image or other DICOM content.", 0, 1, uid));
          children.add(new Property("sopClass", "Coding", "DICOM instance  type.", 0, 1, sopClass));
          children.add(new Property("number", "unsignedInt", "The number of instance in the series.", 0, 1, number));
          children.add(new Property("title", "string", "The description of the instance.", 0, 1, title));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 115792: /*uid*/  return new Property("uid", "id", "The DICOM SOP Instance UID for this image or other DICOM content.", 0, 1, uid);
          case 1560041540: /*sopClass*/  return new Property("sopClass", "Coding", "DICOM instance  type.", 0, 1, sopClass);
          case -1034364087: /*number*/  return new Property("number", "unsignedInt", "The number of instance in the series.", 0, 1, number);
          case 110371416: /*title*/  return new Property("title", "string", "The description of the instance.", 0, 1, title);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return this.uid == null ? new Base[0] : new Base[] {this.uid}; // IdType
        case 1560041540: /*sopClass*/ return this.sopClass == null ? new Base[0] : new Base[] {this.sopClass}; // Coding
        case -1034364087: /*number*/ return this.number == null ? new Base[0] : new Base[] {this.number}; // UnsignedIntType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 115792: // uid
          this.uid = castToId(value); // IdType
          return value;
        case 1560041540: // sopClass
          this.sopClass = castToCoding(value); // Coding
          return value;
        case -1034364087: // number
          this.number = castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 110371416: // title
          this.title = castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = castToId(value); // IdType
        } else if (name.equals("sopClass")) {
          this.sopClass = castToCoding(value); // Coding
        } else if (name.equals("number")) {
          this.number = castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("title")) {
          this.title = castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792:  return getUidElement();
        case 1560041540:  return getSopClass(); 
        case -1034364087:  return getNumberElement();
        case 110371416:  return getTitleElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 115792: /*uid*/ return new String[] {"id"};
        case 1560041540: /*sopClass*/ return new String[] {"Coding"};
        case -1034364087: /*number*/ return new String[] {"unsignedInt"};
        case 110371416: /*title*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uid")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.uid");
        }
        else if (name.equals("sopClass")) {
          this.sopClass = new Coding();
          return this.sopClass;
        }
        else if (name.equals("number")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.number");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.title");
        }
        else
          return super.addChild(name);
      }

      public ImagingStudySeriesInstanceComponent copy() {
        ImagingStudySeriesInstanceComponent dst = new ImagingStudySeriesInstanceComponent();
        copyValues(dst);
        dst.uid = uid == null ? null : uid.copy();
        dst.sopClass = sopClass == null ? null : sopClass.copy();
        dst.number = number == null ? null : number.copy();
        dst.title = title == null ? null : title.copy();
        return dst;
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingStudySeriesInstanceComponent))
          return false;
        ImagingStudySeriesInstanceComponent o = (ImagingStudySeriesInstanceComponent) other_;
        return compareDeep(uid, o.uid, true) && compareDeep(sopClass, o.sopClass, true) && compareDeep(number, o.number, true)
           && compareDeep(title, o.title, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingStudySeriesInstanceComponent))
          return false;
        ImagingStudySeriesInstanceComponent o = (ImagingStudySeriesInstanceComponent) other_;
        return compareValues(uid, o.uid, true) && compareValues(number, o.number, true) && compareValues(title, o.title, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uid, sopClass, number, title
          );
      }

  public String fhirType() {
    return "ImagingStudy.series.instance";

  }

  }

    /**
     * Identifiers for the ImagingStudy such as DICOM Study Instance UID, and Accession Number.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifiers for the whole study", formalDefinition="Identifiers for the ImagingStudy such as DICOM Study Instance UID, and Accession Number." )
    protected List<Identifier> identifier;

    /**
     * The current state of the ImagingStudy.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="registered | available | cancelled | entered-in-error | unknown", formalDefinition="The current state of the ImagingStudy." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/imagingstudy-status")
    protected Enumeration<ImagingStudyStatus> status;

    /**
     * A list of all the series.modality values that are actual acquisition modalities, i.e. those in the DICOM Context Group 29 (value set OID 1.2.840.10008.6.1.19).
     */
    @Child(name = "modality", type = {Coding.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="All series modality if actual acquisition modalities", formalDefinition="A list of all the series.modality values that are actual acquisition modalities, i.e. those in the DICOM Context Group 29 (value set OID 1.2.840.10008.6.1.19)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_29.html")
    protected List<Coding> modality;

    /**
     * The subject, typically a patient, of the imaging study.
     */
    @Child(name = "subject", type = {Patient.class, Device.class, Group.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who or what is the subject of the study", formalDefinition="The subject, typically a patient, of the imaging study." )
    protected Reference subject;

    /**
     * The actual object that is the target of the reference (The subject, typically a patient, of the imaging study.)
     */
    protected Resource subjectTarget;

    /**
     * The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter with which this imaging study is associated", formalDefinition="The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made." )
    protected Reference encounter;

    /**
     * The actual object that is the target of the reference (The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.)
     */
    protected Encounter encounterTarget;

    /**
     * Date and time the study started.
     */
    @Child(name = "started", type = {DateTimeType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the study was started", formalDefinition="Date and time the study started." )
    protected DateTimeType started;

    /**
     * A list of the diagnostic requests that resulted in this imaging study being performed.
     */
    @Child(name = "basedOn", type = {CarePlan.class, ServiceRequest.class, Appointment.class, AppointmentResponse.class, Task.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Request fulfilled", formalDefinition="A list of the diagnostic requests that resulted in this imaging study being performed." )
    protected List<Reference> basedOn;
    /**
     * The actual objects that are the target of the reference (A list of the diagnostic requests that resulted in this imaging study being performed.)
     */
    protected List<Resource> basedOnTarget;


    /**
     * The requesting/referring physician.
     */
    @Child(name = "referrer", type = {Practitioner.class, PractitionerRole.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Referring physician", formalDefinition="The requesting/referring physician." )
    protected Reference referrer;

    /**
     * The actual object that is the target of the reference (The requesting/referring physician.)
     */
    protected Resource referrerTarget;

    /**
     * Who read the study and interpreted the images or other content.
     */
    @Child(name = "interpreter", type = {Practitioner.class, PractitionerRole.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who interpreted images", formalDefinition="Who read the study and interpreted the images or other content." )
    protected List<Reference> interpreter;
    /**
     * The actual objects that are the target of the reference (Who read the study and interpreted the images or other content.)
     */
    protected List<Resource> interpreterTarget;


    /**
     * The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType.
     */
    @Child(name = "endpoint", type = {Endpoint.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Study access endpoint", formalDefinition="The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType." )
    protected List<Reference> endpoint;
    /**
     * The actual objects that are the target of the reference (The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType.)
     */
    protected List<Endpoint> endpointTarget;


    /**
     * Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.
     */
    @Child(name = "numberOfSeries", type = {UnsignedIntType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of Study Related Series", formalDefinition="Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present." )
    protected UnsignedIntType numberOfSeries;

    /**
     * Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.
     */
    @Child(name = "numberOfInstances", type = {UnsignedIntType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of Study Related Instances", formalDefinition="Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present." )
    protected UnsignedIntType numberOfInstances;

    /**
     * The procedure which this ImagingStudy was part of.
     */
    @Child(name = "procedureReference", type = {Procedure.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The performed Procedure reference", formalDefinition="The procedure which this ImagingStudy was part of." )
    protected Reference procedureReference;

    /**
     * The actual object that is the target of the reference (The procedure which this ImagingStudy was part of.)
     */
    protected Procedure procedureReferenceTarget;

    /**
     * The code for the performed procedure type.
     */
    @Child(name = "procedureCode", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The performed procedure code", formalDefinition="The code for the performed procedure type." )
    protected List<CodeableConcept> procedureCode;

    /**
     * The principal physical location where the ImagingStudy was performed.
     */
    @Child(name = "location", type = {Location.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where ImagingStudy occurred", formalDefinition="The principal physical location where the ImagingStudy was performed." )
    protected Reference location;

    /**
     * The actual object that is the target of the reference (The principal physical location where the ImagingStudy was performed.)
     */
    protected Location locationTarget;

    /**
     * Description of clinical condition indicating why the ImagingStudy was requested.
     */
    @Child(name = "reasonCode", type = {CodeableConcept.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Why the study was requested", formalDefinition="Description of clinical condition indicating why the ImagingStudy was requested." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-reason")
    protected List<CodeableConcept> reasonCode;

    /**
     * Indicates another resource whose existence justifies this Study.
     */
    @Child(name = "reasonReference", type = {Condition.class, Observation.class, Media.class, DiagnosticReport.class, DocumentReference.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Why was study performed", formalDefinition="Indicates another resource whose existence justifies this Study." )
    protected List<Reference> reasonReference;
    /**
     * The actual objects that are the target of the reference (Indicates another resource whose existence justifies this Study.)
     */
    protected List<Resource> reasonReferenceTarget;


    /**
     * Per the recommended DICOM mapping, this element is derived from the Study Description attribute (0008,1030). Observations or findings about the imaging study should be recorded in another resource, e.g. Observation, and not in this element.
     */
    @Child(name = "note", type = {Annotation.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="User-defined comments", formalDefinition="Per the recommended DICOM mapping, this element is derived from the Study Description attribute (0008,1030). Observations or findings about the imaging study should be recorded in another resource, e.g. Observation, and not in this element." )
    protected List<Annotation> note;

    /**
     * The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.
     */
    @Child(name = "description", type = {StringType.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Institution-generated description", formalDefinition="The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed." )
    protected StringType description;

    /**
     * Each study has one or more series of images or other content.
     */
    @Child(name = "series", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Each study has one or more series of instances", formalDefinition="Each study has one or more series of images or other content." )
    protected List<ImagingStudySeriesComponent> series;

    private static final long serialVersionUID = -647973361L;

  /**
   * Constructor
   */
    public ImagingStudy() {
      super();
    }

  /**
   * Constructor
   */
    public ImagingStudy(Enumeration<ImagingStudyStatus> status, Reference subject) {
      super();
      this.status = status;
      this.subject = subject;
    }

    /**
     * @return {@link #identifier} (Identifiers for the ImagingStudy such as DICOM Study Instance UID, and Accession Number.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public ImagingStudy addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #status} (The current state of the ImagingStudy.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<ImagingStudyStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<ImagingStudyStatus>(new ImagingStudyStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The current state of the ImagingStudy.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ImagingStudy setStatusElement(Enumeration<ImagingStudyStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the ImagingStudy.
     */
    public ImagingStudyStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the ImagingStudy.
     */
    public ImagingStudy setStatus(ImagingStudyStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<ImagingStudyStatus>(new ImagingStudyStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #modality} (A list of all the series.modality values that are actual acquisition modalities, i.e. those in the DICOM Context Group 29 (value set OID 1.2.840.10008.6.1.19).)
     */
    public List<Coding> getModality() { 
      if (this.modality == null)
        this.modality = new ArrayList<Coding>();
      return this.modality;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setModality(List<Coding> theModality) { 
      this.modality = theModality;
      return this;
    }

    public boolean hasModality() { 
      if (this.modality == null)
        return false;
      for (Coding item : this.modality)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Coding addModality() { //3
      Coding t = new Coding();
      if (this.modality == null)
        this.modality = new ArrayList<Coding>();
      this.modality.add(t);
      return t;
    }

    public ImagingStudy addModality(Coding t) { //3
      if (t == null)
        return this;
      if (this.modality == null)
        this.modality = new ArrayList<Coding>();
      this.modality.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #modality}, creating it if it does not already exist
     */
    public Coding getModalityFirstRep() { 
      if (getModality().isEmpty()) {
        addModality();
      }
      return getModality().get(0);
    }

    /**
     * @return {@link #subject} (The subject, typically a patient, of the imaging study.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The subject, typically a patient, of the imaging study.)
     */
    public ImagingStudy setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #subject} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The subject, typically a patient, of the imaging study.)
     */
    public Resource getSubjectTarget() { 
      return this.subjectTarget;
    }

    /**
     * @param value {@link #subject} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The subject, typically a patient, of the imaging study.)
     */
    public ImagingStudy setSubjectTarget(Resource value) { 
      this.subjectTarget = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.)
     */
    public ImagingStudy setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #encounter} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.)
     */
    public Encounter getEncounterTarget() { 
      if (this.encounterTarget == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.encounter");
        else if (Configuration.doAutoCreate())
          this.encounterTarget = new Encounter(); // aa
      return this.encounterTarget;
    }

    /**
     * @param value {@link #encounter} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.)
     */
    public ImagingStudy setEncounterTarget(Encounter value) { 
      this.encounterTarget = value;
      return this;
    }

    /**
     * @return {@link #started} (Date and time the study started.). This is the underlying object with id, value and extensions. The accessor "getStarted" gives direct access to the value
     */
    public DateTimeType getStartedElement() { 
      if (this.started == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.started");
        else if (Configuration.doAutoCreate())
          this.started = new DateTimeType(); // bb
      return this.started;
    }

    public boolean hasStartedElement() { 
      return this.started != null && !this.started.isEmpty();
    }

    public boolean hasStarted() { 
      return this.started != null && !this.started.isEmpty();
    }

    /**
     * @param value {@link #started} (Date and time the study started.). This is the underlying object with id, value and extensions. The accessor "getStarted" gives direct access to the value
     */
    public ImagingStudy setStartedElement(DateTimeType value) { 
      this.started = value;
      return this;
    }

    /**
     * @return Date and time the study started.
     */
    public Date getStarted() { 
      return this.started == null ? null : this.started.getValue();
    }

    /**
     * @param value Date and time the study started.
     */
    public ImagingStudy setStarted(Date value) { 
      if (value == null)
        this.started = null;
      else {
        if (this.started == null)
          this.started = new DateTimeType();
        this.started.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #basedOn} (A list of the diagnostic requests that resulted in this imaging study being performed.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public ImagingStudy addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @deprecated Use Reference#setResource(IBaseResource) instead
     */
    @Deprecated
    public List<Resource> getBasedOnTarget() { 
      if (this.basedOnTarget == null)
        this.basedOnTarget = new ArrayList<Resource>();
      return this.basedOnTarget;
    }

    /**
     * @return {@link #referrer} (The requesting/referring physician.)
     */
    public Reference getReferrer() { 
      if (this.referrer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.referrer");
        else if (Configuration.doAutoCreate())
          this.referrer = new Reference(); // cc
      return this.referrer;
    }

    public boolean hasReferrer() { 
      return this.referrer != null && !this.referrer.isEmpty();
    }

    /**
     * @param value {@link #referrer} (The requesting/referring physician.)
     */
    public ImagingStudy setReferrer(Reference value) { 
      this.referrer = value;
      return this;
    }

    /**
     * @return {@link #referrer} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The requesting/referring physician.)
     */
    public Resource getReferrerTarget() { 
      return this.referrerTarget;
    }

    /**
     * @param value {@link #referrer} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The requesting/referring physician.)
     */
    public ImagingStudy setReferrerTarget(Resource value) { 
      this.referrerTarget = value;
      return this;
    }

    /**
     * @return {@link #interpreter} (Who read the study and interpreted the images or other content.)
     */
    public List<Reference> getInterpreter() { 
      if (this.interpreter == null)
        this.interpreter = new ArrayList<Reference>();
      return this.interpreter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setInterpreter(List<Reference> theInterpreter) { 
      this.interpreter = theInterpreter;
      return this;
    }

    public boolean hasInterpreter() { 
      if (this.interpreter == null)
        return false;
      for (Reference item : this.interpreter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addInterpreter() { //3
      Reference t = new Reference();
      if (this.interpreter == null)
        this.interpreter = new ArrayList<Reference>();
      this.interpreter.add(t);
      return t;
    }

    public ImagingStudy addInterpreter(Reference t) { //3
      if (t == null)
        return this;
      if (this.interpreter == null)
        this.interpreter = new ArrayList<Reference>();
      this.interpreter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #interpreter}, creating it if it does not already exist
     */
    public Reference getInterpreterFirstRep() { 
      if (getInterpreter().isEmpty()) {
        addInterpreter();
      }
      return getInterpreter().get(0);
    }

    /**
     * @deprecated Use Reference#setResource(IBaseResource) instead
     */
    @Deprecated
    public List<Resource> getInterpreterTarget() { 
      if (this.interpreterTarget == null)
        this.interpreterTarget = new ArrayList<Resource>();
      return this.interpreterTarget;
    }

    /**
     * @return {@link #endpoint} (The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType.)
     */
    public List<Reference> getEndpoint() { 
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      return this.endpoint;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setEndpoint(List<Reference> theEndpoint) { 
      this.endpoint = theEndpoint;
      return this;
    }

    public boolean hasEndpoint() { 
      if (this.endpoint == null)
        return false;
      for (Reference item : this.endpoint)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEndpoint() { //3
      Reference t = new Reference();
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      this.endpoint.add(t);
      return t;
    }

    public ImagingStudy addEndpoint(Reference t) { //3
      if (t == null)
        return this;
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      this.endpoint.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endpoint}, creating it if it does not already exist
     */
    public Reference getEndpointFirstRep() { 
      if (getEndpoint().isEmpty()) {
        addEndpoint();
      }
      return getEndpoint().get(0);
    }

    /**
     * @deprecated Use Reference#setResource(IBaseResource) instead
     */
    @Deprecated
    public List<Endpoint> getEndpointTarget() { 
      if (this.endpointTarget == null)
        this.endpointTarget = new ArrayList<Endpoint>();
      return this.endpointTarget;
    }

    /**
     * @deprecated Use Reference#setResource(IBaseResource) instead
     */
    @Deprecated
    public Endpoint addEndpointTarget() { 
      Endpoint r = new Endpoint();
      if (this.endpointTarget == null)
        this.endpointTarget = new ArrayList<Endpoint>();
      this.endpointTarget.add(r);
      return r;
    }

    /**
     * @return {@link #numberOfSeries} (Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.). This is the underlying object with id, value and extensions. The accessor "getNumberOfSeries" gives direct access to the value
     */
    public UnsignedIntType getNumberOfSeriesElement() { 
      if (this.numberOfSeries == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.numberOfSeries");
        else if (Configuration.doAutoCreate())
          this.numberOfSeries = new UnsignedIntType(); // bb
      return this.numberOfSeries;
    }

    public boolean hasNumberOfSeriesElement() { 
      return this.numberOfSeries != null && !this.numberOfSeries.isEmpty();
    }

    public boolean hasNumberOfSeries() { 
      return this.numberOfSeries != null && !this.numberOfSeries.isEmpty();
    }

    /**
     * @param value {@link #numberOfSeries} (Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.). This is the underlying object with id, value and extensions. The accessor "getNumberOfSeries" gives direct access to the value
     */
    public ImagingStudy setNumberOfSeriesElement(UnsignedIntType value) { 
      this.numberOfSeries = value;
      return this;
    }

    /**
     * @return Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.
     */
    public int getNumberOfSeries() { 
      return this.numberOfSeries == null || this.numberOfSeries.isEmpty() ? 0 : this.numberOfSeries.getValue();
    }

    /**
     * @param value Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.
     */
    public ImagingStudy setNumberOfSeries(int value) { 
        if (this.numberOfSeries == null)
          this.numberOfSeries = new UnsignedIntType();
        this.numberOfSeries.setValue(value);
      return this;
    }

    /**
     * @return {@link #numberOfInstances} (Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.). This is the underlying object with id, value and extensions. The accessor "getNumberOfInstances" gives direct access to the value
     */
    public UnsignedIntType getNumberOfInstancesElement() { 
      if (this.numberOfInstances == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.numberOfInstances");
        else if (Configuration.doAutoCreate())
          this.numberOfInstances = new UnsignedIntType(); // bb
      return this.numberOfInstances;
    }

    public boolean hasNumberOfInstancesElement() { 
      return this.numberOfInstances != null && !this.numberOfInstances.isEmpty();
    }

    public boolean hasNumberOfInstances() { 
      return this.numberOfInstances != null && !this.numberOfInstances.isEmpty();
    }

    /**
     * @param value {@link #numberOfInstances} (Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.). This is the underlying object with id, value and extensions. The accessor "getNumberOfInstances" gives direct access to the value
     */
    public ImagingStudy setNumberOfInstancesElement(UnsignedIntType value) { 
      this.numberOfInstances = value;
      return this;
    }

    /**
     * @return Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.
     */
    public int getNumberOfInstances() { 
      return this.numberOfInstances == null || this.numberOfInstances.isEmpty() ? 0 : this.numberOfInstances.getValue();
    }

    /**
     * @param value Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.
     */
    public ImagingStudy setNumberOfInstances(int value) { 
        if (this.numberOfInstances == null)
          this.numberOfInstances = new UnsignedIntType();
        this.numberOfInstances.setValue(value);
      return this;
    }

    /**
     * @return {@link #procedureReference} (The procedure which this ImagingStudy was part of.)
     */
    public Reference getProcedureReference() { 
      if (this.procedureReference == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.procedureReference");
        else if (Configuration.doAutoCreate())
          this.procedureReference = new Reference(); // cc
      return this.procedureReference;
    }

    public boolean hasProcedureReference() { 
      return this.procedureReference != null && !this.procedureReference.isEmpty();
    }

    /**
     * @param value {@link #procedureReference} (The procedure which this ImagingStudy was part of.)
     */
    public ImagingStudy setProcedureReference(Reference value) { 
      this.procedureReference = value;
      return this;
    }

    /**
     * @return {@link #procedureReference} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The procedure which this ImagingStudy was part of.)
     */
    public Procedure getProcedureReferenceTarget() { 
      if (this.procedureReferenceTarget == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.procedureReference");
        else if (Configuration.doAutoCreate())
          this.procedureReferenceTarget = new Procedure(); // aa
      return this.procedureReferenceTarget;
    }

    /**
     * @param value {@link #procedureReference} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The procedure which this ImagingStudy was part of.)
     */
    public ImagingStudy setProcedureReferenceTarget(Procedure value) { 
      this.procedureReferenceTarget = value;
      return this;
    }

    /**
     * @return {@link #procedureCode} (The code for the performed procedure type.)
     */
    public List<CodeableConcept> getProcedureCode() { 
      if (this.procedureCode == null)
        this.procedureCode = new ArrayList<CodeableConcept>();
      return this.procedureCode;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setProcedureCode(List<CodeableConcept> theProcedureCode) { 
      this.procedureCode = theProcedureCode;
      return this;
    }

    public boolean hasProcedureCode() { 
      if (this.procedureCode == null)
        return false;
      for (CodeableConcept item : this.procedureCode)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addProcedureCode() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.procedureCode == null)
        this.procedureCode = new ArrayList<CodeableConcept>();
      this.procedureCode.add(t);
      return t;
    }

    public ImagingStudy addProcedureCode(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.procedureCode == null)
        this.procedureCode = new ArrayList<CodeableConcept>();
      this.procedureCode.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #procedureCode}, creating it if it does not already exist
     */
    public CodeableConcept getProcedureCodeFirstRep() { 
      if (getProcedureCode().isEmpty()) {
        addProcedureCode();
      }
      return getProcedureCode().get(0);
    }

    /**
     * @return {@link #location} (The principal physical location where the ImagingStudy was performed.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The principal physical location where the ImagingStudy was performed.)
     */
    public ImagingStudy setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #location} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The principal physical location where the ImagingStudy was performed.)
     */
    public Location getLocationTarget() { 
      if (this.locationTarget == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.location");
        else if (Configuration.doAutoCreate())
          this.locationTarget = new Location(); // aa
      return this.locationTarget;
    }

    /**
     * @param value {@link #location} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The principal physical location where the ImagingStudy was performed.)
     */
    public ImagingStudy setLocationTarget(Location value) { 
      this.locationTarget = value;
      return this;
    }

    /**
     * @return {@link #reasonCode} (Description of clinical condition indicating why the ImagingStudy was requested.)
     */
    public List<CodeableConcept> getReasonCode() { 
      if (this.reasonCode == null)
        this.reasonCode = new ArrayList<CodeableConcept>();
      return this.reasonCode;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setReasonCode(List<CodeableConcept> theReasonCode) { 
      this.reasonCode = theReasonCode;
      return this;
    }

    public boolean hasReasonCode() { 
      if (this.reasonCode == null)
        return false;
      for (CodeableConcept item : this.reasonCode)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addReasonCode() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.reasonCode == null)
        this.reasonCode = new ArrayList<CodeableConcept>();
      this.reasonCode.add(t);
      return t;
    }

    public ImagingStudy addReasonCode(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.reasonCode == null)
        this.reasonCode = new ArrayList<CodeableConcept>();
      this.reasonCode.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reasonCode}, creating it if it does not already exist
     */
    public CodeableConcept getReasonCodeFirstRep() { 
      if (getReasonCode().isEmpty()) {
        addReasonCode();
      }
      return getReasonCode().get(0);
    }

    /**
     * @return {@link #reasonReference} (Indicates another resource whose existence justifies this Study.)
     */
    public List<Reference> getReasonReference() { 
      if (this.reasonReference == null)
        this.reasonReference = new ArrayList<Reference>();
      return this.reasonReference;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setReasonReference(List<Reference> theReasonReference) { 
      this.reasonReference = theReasonReference;
      return this;
    }

    public boolean hasReasonReference() { 
      if (this.reasonReference == null)
        return false;
      for (Reference item : this.reasonReference)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addReasonReference() { //3
      Reference t = new Reference();
      if (this.reasonReference == null)
        this.reasonReference = new ArrayList<Reference>();
      this.reasonReference.add(t);
      return t;
    }

    public ImagingStudy addReasonReference(Reference t) { //3
      if (t == null)
        return this;
      if (this.reasonReference == null)
        this.reasonReference = new ArrayList<Reference>();
      this.reasonReference.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reasonReference}, creating it if it does not already exist
     */
    public Reference getReasonReferenceFirstRep() { 
      if (getReasonReference().isEmpty()) {
        addReasonReference();
      }
      return getReasonReference().get(0);
    }

    /**
     * @deprecated Use Reference#setResource(IBaseResource) instead
     */
    @Deprecated
    public List<Resource> getReasonReferenceTarget() { 
      if (this.reasonReferenceTarget == null)
        this.reasonReferenceTarget = new ArrayList<Resource>();
      return this.reasonReferenceTarget;
    }

    /**
     * @return {@link #note} (Per the recommended DICOM mapping, this element is derived from the Study Description attribute (0008,1030). Observations or findings about the imaging study should be recorded in another resource, e.g. Observation, and not in this element.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public ImagingStudy addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #description} (The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImagingStudy.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ImagingStudy setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.
     */
    public ImagingStudy setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #series} (Each study has one or more series of images or other content.)
     */
    public List<ImagingStudySeriesComponent> getSeries() { 
      if (this.series == null)
        this.series = new ArrayList<ImagingStudySeriesComponent>();
      return this.series;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setSeries(List<ImagingStudySeriesComponent> theSeries) { 
      this.series = theSeries;
      return this;
    }

    public boolean hasSeries() { 
      if (this.series == null)
        return false;
      for (ImagingStudySeriesComponent item : this.series)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ImagingStudySeriesComponent addSeries() { //3
      ImagingStudySeriesComponent t = new ImagingStudySeriesComponent();
      if (this.series == null)
        this.series = new ArrayList<ImagingStudySeriesComponent>();
      this.series.add(t);
      return t;
    }

    public ImagingStudy addSeries(ImagingStudySeriesComponent t) { //3
      if (t == null)
        return this;
      if (this.series == null)
        this.series = new ArrayList<ImagingStudySeriesComponent>();
      this.series.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #series}, creating it if it does not already exist
     */
    public ImagingStudySeriesComponent getSeriesFirstRep() { 
      if (getSeries().isEmpty()) {
        addSeries();
      }
      return getSeries().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers for the ImagingStudy such as DICOM Study Instance UID, and Accession Number.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The current state of the ImagingStudy.", 0, 1, status));
        children.add(new Property("modality", "Coding", "A list of all the series.modality values that are actual acquisition modalities, i.e. those in the DICOM Context Group 29 (value set OID 1.2.840.10008.6.1.19).", 0, java.lang.Integer.MAX_VALUE, modality));
        children.add(new Property("subject", "Reference(Patient|Device|Group)", "The subject, typically a patient, of the imaging study.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.", 0, 1, encounter));
        children.add(new Property("started", "dateTime", "Date and time the study started.", 0, 1, started));
        children.add(new Property("basedOn", "Reference(CarePlan|ServiceRequest|Appointment|AppointmentResponse|Task)", "A list of the diagnostic requests that resulted in this imaging study being performed.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("referrer", "Reference(Practitioner|PractitionerRole)", "The requesting/referring physician.", 0, 1, referrer));
        children.add(new Property("interpreter", "Reference(Practitioner|PractitionerRole)", "Who read the study and interpreted the images or other content.", 0, java.lang.Integer.MAX_VALUE, interpreter));
        children.add(new Property("endpoint", "Reference(Endpoint)", "The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType.", 0, java.lang.Integer.MAX_VALUE, endpoint));
        children.add(new Property("numberOfSeries", "unsignedInt", "Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.", 0, 1, numberOfSeries));
        children.add(new Property("numberOfInstances", "unsignedInt", "Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.", 0, 1, numberOfInstances));
        children.add(new Property("procedureReference", "Reference(Procedure)", "The procedure which this ImagingStudy was part of.", 0, 1, procedureReference));
        children.add(new Property("procedureCode", "CodeableConcept", "The code for the performed procedure type.", 0, java.lang.Integer.MAX_VALUE, procedureCode));
        children.add(new Property("location", "Reference(Location)", "The principal physical location where the ImagingStudy was performed.", 0, 1, location));
        children.add(new Property("reasonCode", "CodeableConcept", "Description of clinical condition indicating why the ImagingStudy was requested.", 0, java.lang.Integer.MAX_VALUE, reasonCode));
        children.add(new Property("reasonReference", "Reference(Condition|Observation|Media|DiagnosticReport|DocumentReference)", "Indicates another resource whose existence justifies this Study.", 0, java.lang.Integer.MAX_VALUE, reasonReference));
        children.add(new Property("note", "Annotation", "Per the recommended DICOM mapping, this element is derived from the Study Description attribute (0008,1030). Observations or findings about the imaging study should be recorded in another resource, e.g. Observation, and not in this element.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("description", "string", "The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.", 0, 1, description));
        children.add(new Property("series", "", "Each study has one or more series of images or other content.", 0, java.lang.Integer.MAX_VALUE, series));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers for the ImagingStudy such as DICOM Study Instance UID, and Accession Number.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the ImagingStudy.", 0, 1, status);
        case -622722335: /*modality*/  return new Property("modality", "Coding", "A list of all the series.modality values that are actual acquisition modalities, i.e. those in the DICOM Context Group 29 (value set OID 1.2.840.10008.6.1.19).", 0, java.lang.Integer.MAX_VALUE, modality);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Device|Group)", "The subject, typically a patient, of the imaging study.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.", 0, 1, encounter);
        case -1897185151: /*started*/  return new Property("started", "dateTime", "Date and time the study started.", 0, 1, started);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|ServiceRequest|Appointment|AppointmentResponse|Task)", "A list of the diagnostic requests that resulted in this imaging study being performed.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -722568161: /*referrer*/  return new Property("referrer", "Reference(Practitioner|PractitionerRole)", "The requesting/referring physician.", 0, 1, referrer);
        case -2008009094: /*interpreter*/  return new Property("interpreter", "Reference(Practitioner|PractitionerRole)", "Who read the study and interpreted the images or other content.", 0, java.lang.Integer.MAX_VALUE, interpreter);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType.", 0, java.lang.Integer.MAX_VALUE, endpoint);
        case 1920000407: /*numberOfSeries*/  return new Property("numberOfSeries", "unsignedInt", "Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.", 0, 1, numberOfSeries);
        case -1043544226: /*numberOfInstances*/  return new Property("numberOfInstances", "unsignedInt", "Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.", 0, 1, numberOfInstances);
        case 881809848: /*procedureReference*/  return new Property("procedureReference", "Reference(Procedure)", "The procedure which this ImagingStudy was part of.", 0, 1, procedureReference);
        case -698023072: /*procedureCode*/  return new Property("procedureCode", "CodeableConcept", "The code for the performed procedure type.", 0, java.lang.Integer.MAX_VALUE, procedureCode);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The principal physical location where the ImagingStudy was performed.", 0, 1, location);
        case 722137681: /*reasonCode*/  return new Property("reasonCode", "CodeableConcept", "Description of clinical condition indicating why the ImagingStudy was requested.", 0, java.lang.Integer.MAX_VALUE, reasonCode);
        case -1146218137: /*reasonReference*/  return new Property("reasonReference", "Reference(Condition|Observation|Media|DiagnosticReport|DocumentReference)", "Indicates another resource whose existence justifies this Study.", 0, java.lang.Integer.MAX_VALUE, reasonReference);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Per the recommended DICOM mapping, this element is derived from the Study Description attribute (0008,1030). Observations or findings about the imaging study should be recorded in another resource, e.g. Observation, and not in this element.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1724546052: /*description*/  return new Property("description", "string", "The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.", 0, 1, description);
        case -905838985: /*series*/  return new Property("series", "", "Each study has one or more series of images or other content.", 0, java.lang.Integer.MAX_VALUE, series);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<ImagingStudyStatus>
        case -622722335: /*modality*/ return this.modality == null ? new Base[0] : this.modality.toArray(new Base[this.modality.size()]); // Coding
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1897185151: /*started*/ return this.started == null ? new Base[0] : new Base[] {this.started}; // DateTimeType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -722568161: /*referrer*/ return this.referrer == null ? new Base[0] : new Base[] {this.referrer}; // Reference
        case -2008009094: /*interpreter*/ return this.interpreter == null ? new Base[0] : this.interpreter.toArray(new Base[this.interpreter.size()]); // Reference
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
        case 1920000407: /*numberOfSeries*/ return this.numberOfSeries == null ? new Base[0] : new Base[] {this.numberOfSeries}; // UnsignedIntType
        case -1043544226: /*numberOfInstances*/ return this.numberOfInstances == null ? new Base[0] : new Base[] {this.numberOfInstances}; // UnsignedIntType
        case 881809848: /*procedureReference*/ return this.procedureReference == null ? new Base[0] : new Base[] {this.procedureReference}; // Reference
        case -698023072: /*procedureCode*/ return this.procedureCode == null ? new Base[0] : this.procedureCode.toArray(new Base[this.procedureCode.size()]); // CodeableConcept
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 722137681: /*reasonCode*/ return this.reasonCode == null ? new Base[0] : this.reasonCode.toArray(new Base[this.reasonCode.size()]); // CodeableConcept
        case -1146218137: /*reasonReference*/ return this.reasonReference == null ? new Base[0] : this.reasonReference.toArray(new Base[this.reasonReference.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -905838985: /*series*/ return this.series == null ? new Base[0] : this.series.toArray(new Base[this.series.size()]); // ImagingStudySeriesComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new ImagingStudyStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ImagingStudyStatus>
          return value;
        case -622722335: // modality
          this.getModality().add(castToCoding(value)); // Coding
          return value;
        case -1867885268: // subject
          this.subject = castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = castToReference(value); // Reference
          return value;
        case -1897185151: // started
          this.started = castToDateTime(value); // DateTimeType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(castToReference(value)); // Reference
          return value;
        case -722568161: // referrer
          this.referrer = castToReference(value); // Reference
          return value;
        case -2008009094: // interpreter
          this.getInterpreter().add(castToReference(value)); // Reference
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(castToReference(value)); // Reference
          return value;
        case 1920000407: // numberOfSeries
          this.numberOfSeries = castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -1043544226: // numberOfInstances
          this.numberOfInstances = castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 881809848: // procedureReference
          this.procedureReference = castToReference(value); // Reference
          return value;
        case -698023072: // procedureCode
          this.getProcedureCode().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1901043637: // location
          this.location = castToReference(value); // Reference
          return value;
        case 722137681: // reasonCode
          this.getReasonCode().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1146218137: // reasonReference
          this.getReasonReference().add(castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(castToAnnotation(value)); // Annotation
          return value;
        case -1724546052: // description
          this.description = castToString(value); // StringType
          return value;
        case -905838985: // series
          this.getSeries().add((ImagingStudySeriesComponent) value); // ImagingStudySeriesComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new ImagingStudyStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ImagingStudyStatus>
        } else if (name.equals("modality")) {
          this.getModality().add(castToCoding(value));
        } else if (name.equals("subject")) {
          this.subject = castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = castToReference(value); // Reference
        } else if (name.equals("started")) {
          this.started = castToDateTime(value); // DateTimeType
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(castToReference(value));
        } else if (name.equals("referrer")) {
          this.referrer = castToReference(value); // Reference
        } else if (name.equals("interpreter")) {
          this.getInterpreter().add(castToReference(value));
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(castToReference(value));
        } else if (name.equals("numberOfSeries")) {
          this.numberOfSeries = castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("numberOfInstances")) {
          this.numberOfInstances = castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("procedureReference")) {
          this.procedureReference = castToReference(value); // Reference
        } else if (name.equals("procedureCode")) {
          this.getProcedureCode().add(castToCodeableConcept(value));
        } else if (name.equals("location")) {
          this.location = castToReference(value); // Reference
        } else if (name.equals("reasonCode")) {
          this.getReasonCode().add(castToCodeableConcept(value));
        } else if (name.equals("reasonReference")) {
          this.getReasonReference().add(castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(castToAnnotation(value));
        } else if (name.equals("description")) {
          this.description = castToString(value); // StringType
        } else if (name.equals("series")) {
          this.getSeries().add((ImagingStudySeriesComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -622722335:  return addModality(); 
        case -1867885268:  return getSubject(); 
        case 1524132147:  return getEncounter(); 
        case -1897185151:  return getStartedElement();
        case -332612366:  return addBasedOn(); 
        case -722568161:  return getReferrer(); 
        case -2008009094:  return addInterpreter(); 
        case 1741102485:  return addEndpoint(); 
        case 1920000407:  return getNumberOfSeriesElement();
        case -1043544226:  return getNumberOfInstancesElement();
        case 881809848:  return getProcedureReference(); 
        case -698023072:  return addProcedureCode(); 
        case 1901043637:  return getLocation(); 
        case 722137681:  return addReasonCode(); 
        case -1146218137:  return addReasonReference(); 
        case 3387378:  return addNote(); 
        case -1724546052:  return getDescriptionElement();
        case -905838985:  return addSeries(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -622722335: /*modality*/ return new String[] {"Coding"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1897185151: /*started*/ return new String[] {"dateTime"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -722568161: /*referrer*/ return new String[] {"Reference"};
        case -2008009094: /*interpreter*/ return new String[] {"Reference"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        case 1920000407: /*numberOfSeries*/ return new String[] {"unsignedInt"};
        case -1043544226: /*numberOfInstances*/ return new String[] {"unsignedInt"};
        case 881809848: /*procedureReference*/ return new String[] {"Reference"};
        case -698023072: /*procedureCode*/ return new String[] {"CodeableConcept"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 722137681: /*reasonCode*/ return new String[] {"CodeableConcept"};
        case -1146218137: /*reasonReference*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -905838985: /*series*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.status");
        }
        else if (name.equals("modality")) {
          return addModality();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("started")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.started");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("referrer")) {
          this.referrer = new Reference();
          return this.referrer;
        }
        else if (name.equals("interpreter")) {
          return addInterpreter();
        }
        else if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else if (name.equals("numberOfSeries")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.numberOfSeries");
        }
        else if (name.equals("numberOfInstances")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.numberOfInstances");
        }
        else if (name.equals("procedureReference")) {
          this.procedureReference = new Reference();
          return this.procedureReference;
        }
        else if (name.equals("procedureCode")) {
          return addProcedureCode();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("reasonCode")) {
          return addReasonCode();
        }
        else if (name.equals("reasonReference")) {
          return addReasonReference();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImagingStudy.description");
        }
        else if (name.equals("series")) {
          return addSeries();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ImagingStudy";

  }

      public ImagingStudy copy() {
        ImagingStudy dst = new ImagingStudy();
        copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (modality != null) {
          dst.modality = new ArrayList<Coding>();
          for (Coding i : modality)
            dst.modality.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.started = started == null ? null : started.copy();
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.referrer = referrer == null ? null : referrer.copy();
        if (interpreter != null) {
          dst.interpreter = new ArrayList<Reference>();
          for (Reference i : interpreter)
            dst.interpreter.add(i.copy());
        };
        if (endpoint != null) {
          dst.endpoint = new ArrayList<Reference>();
          for (Reference i : endpoint)
            dst.endpoint.add(i.copy());
        };
        dst.numberOfSeries = numberOfSeries == null ? null : numberOfSeries.copy();
        dst.numberOfInstances = numberOfInstances == null ? null : numberOfInstances.copy();
        dst.procedureReference = procedureReference == null ? null : procedureReference.copy();
        if (procedureCode != null) {
          dst.procedureCode = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : procedureCode)
            dst.procedureCode.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        if (reasonCode != null) {
          dst.reasonCode = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : reasonCode)
            dst.reasonCode.add(i.copy());
        };
        if (reasonReference != null) {
          dst.reasonReference = new ArrayList<Reference>();
          for (Reference i : reasonReference)
            dst.reasonReference.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (series != null) {
          dst.series = new ArrayList<ImagingStudySeriesComponent>();
          for (ImagingStudySeriesComponent i : series)
            dst.series.add(i.copy());
        };
        return dst;
      }

      protected ImagingStudy typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImagingStudy))
          return false;
        ImagingStudy o = (ImagingStudy) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(modality, o.modality, true)
           && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true) && compareDeep(started, o.started, true)
           && compareDeep(basedOn, o.basedOn, true) && compareDeep(referrer, o.referrer, true) && compareDeep(interpreter, o.interpreter, true)
           && compareDeep(endpoint, o.endpoint, true) && compareDeep(numberOfSeries, o.numberOfSeries, true)
           && compareDeep(numberOfInstances, o.numberOfInstances, true) && compareDeep(procedureReference, o.procedureReference, true)
           && compareDeep(procedureCode, o.procedureCode, true) && compareDeep(location, o.location, true)
           && compareDeep(reasonCode, o.reasonCode, true) && compareDeep(reasonReference, o.reasonReference, true)
           && compareDeep(note, o.note, true) && compareDeep(description, o.description, true) && compareDeep(series, o.series, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImagingStudy))
          return false;
        ImagingStudy o = (ImagingStudy) other_;
        return compareValues(status, o.status, true) && compareValues(started, o.started, true) && compareValues(numberOfSeries, o.numberOfSeries, true)
           && compareValues(numberOfInstances, o.numberOfInstances, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, modality
          , subject, encounter, started, basedOn, referrer, interpreter, endpoint, numberOfSeries
          , numberOfInstances, procedureReference, procedureCode, location, reasonCode, reasonReference
          , note, description, series);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ImagingStudy;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Identifiers for the Study, such as DICOM Study Instance UID and Accession number</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ImagingStudy.identifier", description="Identifiers for the Study, such as DICOM Study Instance UID and Accession number", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Identifiers for the Study, such as DICOM Study Instance UID and Accession number</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>reason</b>
   * <p>
   * Description: <b>The reason for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.reasonCode</b><br>
   * </p>
   */
  @SearchParamDefinition(name="reason", path="ImagingStudy.reasonCode", description="The reason for the study", type="token" )
  public static final String SP_REASON = "reason";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>reason</b>
   * <p>
   * Description: <b>The reason for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.reasonCode</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam REASON = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_REASON);

 /**
   * Search parameter: <b>dicom-class</b>
   * <p>
   * Description: <b>The type of the instance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.instance.sopClass</b><br>
   * </p>
   */
  @SearchParamDefinition(name="dicom-class", path="ImagingStudy.series.instance.sopClass", description="The type of the instance", type="token" )
  public static final String SP_DICOM_CLASS = "dicom-class";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>dicom-class</b>
   * <p>
   * Description: <b>The type of the instance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.instance.sopClass</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DICOM_CLASS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DICOM_CLASS);

 /**
   * Search parameter: <b>modality</b>
   * <p>
   * Description: <b>The modality of the series</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.modality</b><br>
   * </p>
   */
  @SearchParamDefinition(name="modality", path="ImagingStudy.series.modality", description="The modality of the series", type="token" )
  public static final String SP_MODALITY = "modality";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>modality</b>
   * <p>
   * Description: <b>The modality of the series</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.modality</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MODALITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MODALITY);

 /**
   * Search parameter: <b>bodysite</b>
   * <p>
   * Description: <b>The body site studied</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.bodySite</b><br>
   * </p>
   */
  @SearchParamDefinition(name="bodysite", path="ImagingStudy.series.bodySite", description="The body site studied", type="token" )
  public static final String SP_BODYSITE = "bodysite";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>bodysite</b>
   * <p>
   * Description: <b>The body site studied</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.bodySite</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BODYSITE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_BODYSITE);

 /**
   * Search parameter: <b>instance</b>
   * <p>
   * Description: <b>SOP Instance UID for an instance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.instance.uid</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instance", path="ImagingStudy.series.instance.uid", description="SOP Instance UID for an instance", type="token" )
  public static final String SP_INSTANCE = "instance";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instance</b>
   * <p>
   * Description: <b>SOP Instance UID for an instance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.instance.uid</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INSTANCE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INSTANCE);

 /**
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>The person who performed the study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.series.performer.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer", path="ImagingStudy.series.performer.actor", description="The person who performed the study", type="reference", target={CareTeam.class, Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PERFORMER = "performer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer</b>
   * <p>
   * Description: <b>The person who performed the study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.series.performer.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:performer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER = new ca.uhn.fhir.model.api.Include("ImagingStudy:performer").toLocked();

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="ImagingStudy.subject", description="Who the study is about", type="reference", target={Device.class, Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("ImagingStudy:subject").toLocked();

 /**
   * Search parameter: <b>started</b>
   * <p>
   * Description: <b>When the study was started</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ImagingStudy.started</b><br>
   * </p>
   */
  @SearchParamDefinition(name="started", path="ImagingStudy.started", description="When the study was started", type="date" )
  public static final String SP_STARTED = "started";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>started</b>
   * <p>
   * Description: <b>When the study was started</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ImagingStudy.started</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam STARTED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_STARTED);

 /**
   * Search parameter: <b>interpreter</b>
   * <p>
   * Description: <b>Who interpreted the images</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.interpreter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="interpreter", path="ImagingStudy.interpreter", description="Who interpreted the images", type="reference", target={Practitioner.class, PractitionerRole.class } )
  public static final String SP_INTERPRETER = "interpreter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>interpreter</b>
   * <p>
   * Description: <b>Who interpreted the images</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.interpreter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INTERPRETER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INTERPRETER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:interpreter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INTERPRETER = new ca.uhn.fhir.model.api.Include("ImagingStudy:interpreter").toLocked();

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>The context of the study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="ImagingStudy.encounter", description="The context of the study", type="reference", target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>The context of the study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("ImagingStudy:encounter").toLocked();

 /**
   * Search parameter: <b>referrer</b>
   * <p>
   * Description: <b>The referring physician</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.referrer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="referrer", path="ImagingStudy.referrer", description="The referring physician", type="reference", target={Practitioner.class, PractitionerRole.class } )
  public static final String SP_REFERRER = "referrer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>referrer</b>
   * <p>
   * Description: <b>The referring physician</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.referrer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REFERRER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REFERRER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:referrer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REFERRER = new ca.uhn.fhir.model.api.Include("ImagingStudy:referrer").toLocked();

 /**
   * Search parameter: <b>endpoint</b>
   * <p>
   * Description: <b>The endpoint for the study or series</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.endpoint, ImagingStudy.series.endpoint</b><br>
   * </p>
   */
  @SearchParamDefinition(name="endpoint", path="ImagingStudy.endpoint | ImagingStudy.series.endpoint", description="The endpoint for the study or series", type="reference", target={Endpoint.class } )
  public static final String SP_ENDPOINT = "endpoint";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>endpoint</b>
   * <p>
   * Description: <b>The endpoint for the study or series</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.endpoint, ImagingStudy.series.endpoint</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENDPOINT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENDPOINT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:endpoint</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENDPOINT = new ca.uhn.fhir.model.api.Include("ImagingStudy:endpoint").toLocked();

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="ImagingStudy.subject.where(resolve() is Patient)", description="Who the study is about", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("ImagingStudy:patient").toLocked();

 /**
   * Search parameter: <b>series</b>
   * <p>
   * Description: <b>DICOM Series Instance UID for a series</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.uid</b><br>
   * </p>
   */
  @SearchParamDefinition(name="series", path="ImagingStudy.series.uid", description="DICOM Series Instance UID for a series", type="token" )
  public static final String SP_SERIES = "series";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>series</b>
   * <p>
   * Description: <b>DICOM Series Instance UID for a series</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.uid</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SERIES = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SERIES);

 /**
   * Search parameter: <b>basedon</b>
   * <p>
   * Description: <b>The order for the image</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="basedon", path="ImagingStudy.basedOn", description="The order for the image", type="reference", target={Appointment.class, AppointmentResponse.class, CarePlan.class, ServiceRequest.class, Task.class } )
  public static final String SP_BASEDON = "basedon";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>basedon</b>
   * <p>
   * Description: <b>The order for the image</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASEDON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASEDON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:basedon</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASEDON = new ca.uhn.fhir.model.api.Include("ImagingStudy:basedon").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ImagingStudy.status", description="The status of the study", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

