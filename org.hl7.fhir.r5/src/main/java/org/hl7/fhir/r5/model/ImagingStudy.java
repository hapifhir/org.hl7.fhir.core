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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

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
         * The imaging study is unavailable because the imaging study was not started or not completed (also sometimes called \"aborted\").
         */
        CANCELLED, 
        /**
         * The imaging study has been withdrawn following a previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).
         */
        ENTEREDINERROR, 
        /**
         * The system does not know which of the status values currently applies for this request. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, it's just not known which one.
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
            case NULL: return null;
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
            case NULL: return null;
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
            case NULL: return null;
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
            case NULL: return null;
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
        public Enumeration<ImagingStudyStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.NULL, code);
        if ("registered".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.REGISTERED, code);
        if ("available".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.AVAILABLE, code);
        if ("cancelled".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.CANCELLED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.ENTEREDINERROR, code);
        if ("unknown".equals(codeString))
          return new Enumeration<ImagingStudyStatus>(this, ImagingStudyStatus.UNKNOWN, code);
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
         * The distinct modality for this series. This may include both acquisition and non-acquisition modalities.
         */
        @Child(name = "modality", type = {CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The modality used for this series", formalDefinition="The distinct modality for this series. This may include both acquisition and non-acquisition modalities." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_33.html")
        protected CodeableConcept modality;

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
         * The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.
         */
        @Child(name = "bodySite", type = {CodeableReference.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Body part examined", formalDefinition="The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
        protected CodeableReference bodySite;

        /**
         * The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.
         */
        @Child(name = "laterality", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Body part laterality", formalDefinition="The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_244.html")
        protected CodeableConcept laterality;

        /**
         * The specimen imaged, e.g., for whole slide imaging of a biopsy.
         */
        @Child(name = "specimen", type = {Specimen.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Specimen imaged", formalDefinition="The specimen imaged, e.g., for whole slide imaging of a biopsy." )
        protected List<Reference> specimen;

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

        private static final long serialVersionUID = 755136591L;

    /**
     * Constructor
     */
      public ImagingStudySeriesComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ImagingStudySeriesComponent(String uid, CodeableConcept modality) {
        super();
        this.setUid(uid);
        this.setModality(modality);
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
         * @return {@link #modality} (The distinct modality for this series. This may include both acquisition and non-acquisition modalities.)
         */
        public CodeableConcept getModality() { 
          if (this.modality == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.modality");
            else if (Configuration.doAutoCreate())
              this.modality = new CodeableConcept(); // cc
          return this.modality;
        }

        public boolean hasModality() { 
          return this.modality != null && !this.modality.isEmpty();
        }

        /**
         * @param value {@link #modality} (The distinct modality for this series. This may include both acquisition and non-acquisition modalities.)
         */
        public ImagingStudySeriesComponent setModality(CodeableConcept value) { 
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
         * @return The first repetition of repeating field {@link #endpoint}, creating it if it does not already exist {3}
         */
        public Reference getEndpointFirstRep() { 
          if (getEndpoint().isEmpty()) {
            addEndpoint();
          }
          return getEndpoint().get(0);
        }

        /**
         * @return {@link #bodySite} (The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.)
         */
        public CodeableReference getBodySite() { 
          if (this.bodySite == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.bodySite");
            else if (Configuration.doAutoCreate())
              this.bodySite = new CodeableReference(); // cc
          return this.bodySite;
        }

        public boolean hasBodySite() { 
          return this.bodySite != null && !this.bodySite.isEmpty();
        }

        /**
         * @param value {@link #bodySite} (The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.)
         */
        public ImagingStudySeriesComponent setBodySite(CodeableReference value) { 
          this.bodySite = value;
          return this;
        }

        /**
         * @return {@link #laterality} (The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.)
         */
        public CodeableConcept getLaterality() { 
          if (this.laterality == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ImagingStudySeriesComponent.laterality");
            else if (Configuration.doAutoCreate())
              this.laterality = new CodeableConcept(); // cc
          return this.laterality;
        }

        public boolean hasLaterality() { 
          return this.laterality != null && !this.laterality.isEmpty();
        }

        /**
         * @param value {@link #laterality} (The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.)
         */
        public ImagingStudySeriesComponent setLaterality(CodeableConcept value) { 
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
         * @return The first repetition of repeating field {@link #specimen}, creating it if it does not already exist {3}
         */
        public Reference getSpecimenFirstRep() { 
          if (getSpecimen().isEmpty()) {
            addSpecimen();
          }
          return getSpecimen().get(0);
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
         * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
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
         * @return The first repetition of repeating field {@link #instance}, creating it if it does not already exist {3}
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
          children.add(new Property("modality", "CodeableConcept", "The distinct modality for this series. This may include both acquisition and non-acquisition modalities.", 0, 1, modality));
          children.add(new Property("description", "string", "A description of the series.", 0, 1, description));
          children.add(new Property("numberOfInstances", "unsignedInt", "Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.", 0, 1, numberOfInstances));
          children.add(new Property("endpoint", "Reference(Endpoint)", "The network service providing access (e.g., query, view, or retrieval) for this series. See implementation notes for information about using DICOM endpoints. A series-level endpoint, if present, has precedence over a study-level endpoint with the same Endpoint.connectionType.", 0, java.lang.Integer.MAX_VALUE, endpoint));
          children.add(new Property("bodySite", "CodeableReference(BodyStructure)", "The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.", 0, 1, bodySite));
          children.add(new Property("laterality", "CodeableConcept", "The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.", 0, 1, laterality));
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
          case -622722335: /*modality*/  return new Property("modality", "CodeableConcept", "The distinct modality for this series. This may include both acquisition and non-acquisition modalities.", 0, 1, modality);
          case -1724546052: /*description*/  return new Property("description", "string", "A description of the series.", 0, 1, description);
          case -1043544226: /*numberOfInstances*/  return new Property("numberOfInstances", "unsignedInt", "Number of SOP Instances in the Study. The value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.", 0, 1, numberOfInstances);
          case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "The network service providing access (e.g., query, view, or retrieval) for this series. See implementation notes for information about using DICOM endpoints. A series-level endpoint, if present, has precedence over a study-level endpoint with the same Endpoint.connectionType.", 0, java.lang.Integer.MAX_VALUE, endpoint);
          case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableReference(BodyStructure)", "The anatomic structures examined. See DICOM Part 16 Annex L (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it shall be consistent with any content of ImagingStudy.series.laterality.", 0, 1, bodySite);
          case -170291817: /*laterality*/  return new Property("laterality", "CodeableConcept", "The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee, both lungs, or unpaired abdomen. If present, shall be consistent with any laterality information indicated in ImagingStudy.series.bodySite.", 0, 1, laterality);
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
        case -622722335: /*modality*/ return this.modality == null ? new Base[0] : new Base[] {this.modality}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1043544226: /*numberOfInstances*/ return this.numberOfInstances == null ? new Base[0] : new Base[] {this.numberOfInstances}; // UnsignedIntType
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // CodeableReference
        case -170291817: /*laterality*/ return this.laterality == null ? new Base[0] : new Base[] {this.laterality}; // CodeableConcept
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
          this.uid = TypeConvertor.castToId(value); // IdType
          return value;
        case -1034364087: // number
          this.number = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -622722335: // modality
          this.modality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1043544226: // numberOfInstances
          this.numberOfInstances = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1702620169: // bodySite
          this.bodySite = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -170291817: // laterality
          this.laterality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2132868344: // specimen
          this.getSpecimen().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1897185151: // started
          this.started = TypeConvertor.castToDateTime(value); // DateTimeType
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
          this.uid = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("number")) {
          this.number = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("modality")) {
          this.modality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("numberOfInstances")) {
          this.numberOfInstances = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(TypeConvertor.castToReference(value));
        } else if (name.equals("bodySite")) {
          this.bodySite = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("laterality")) {
          this.laterality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("specimen")) {
          this.getSpecimen().add(TypeConvertor.castToReference(value));
        } else if (name.equals("started")) {
          this.started = TypeConvertor.castToDateTime(value); // DateTimeType
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
        case -622722335: /*modality*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1043544226: /*numberOfInstances*/ return new String[] {"unsignedInt"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableReference"};
        case -170291817: /*laterality*/ return new String[] {"CodeableConcept"};
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
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.series.uid");
        }
        else if (name.equals("number")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.series.number");
        }
        else if (name.equals("modality")) {
          this.modality = new CodeableConcept();
          return this.modality;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.series.description");
        }
        else if (name.equals("numberOfInstances")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.series.numberOfInstances");
        }
        else if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new CodeableReference();
          return this.bodySite;
        }
        else if (name.equals("laterality")) {
          this.laterality = new CodeableConcept();
          return this.laterality;
        }
        else if (name.equals("specimen")) {
          return addSpecimen();
        }
        else if (name.equals("started")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.series.started");
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
        return dst;
      }

      public void copyValues(ImagingStudySeriesComponent dst) {
        super.copyValues(dst);
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
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, Device.class, RelatedPerson.class, HealthcareService.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who performed the series", formalDefinition="Indicates who or what performed the series." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

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
        this.setActor(actor);
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

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the performer in the series.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson|HealthcareService)", "Indicates who or what performed the series.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the performer in the series.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson|HealthcareService)", "Indicates who or what performed the series.", 0, 1, actor);
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
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
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
        return dst;
      }

      public void copyValues(ImagingStudySeriesPerformerComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
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
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part04/sect_B.5.html#table_B.5-1")
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
      public ImagingStudySeriesInstanceComponent(String uid, Coding sopClass) {
        super();
        this.setUid(uid);
        this.setSopClass(sopClass);
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
          this.uid = TypeConvertor.castToId(value); // IdType
          return value;
        case 1560041540: // sopClass
          this.sopClass = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -1034364087: // number
          this.number = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uid")) {
          this.uid = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("sopClass")) {
          this.sopClass = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("number")) {
          this.number = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
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
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.series.instance.uid");
        }
        else if (name.equals("sopClass")) {
          this.sopClass = new Coding();
          return this.sopClass;
        }
        else if (name.equals("number")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.series.instance.number");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.series.instance.title");
        }
        else
          return super.addChild(name);
      }

      public ImagingStudySeriesInstanceComponent copy() {
        ImagingStudySeriesInstanceComponent dst = new ImagingStudySeriesInstanceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ImagingStudySeriesInstanceComponent dst) {
        super.copyValues(dst);
        dst.uid = uid == null ? null : uid.copy();
        dst.sopClass = sopClass == null ? null : sopClass.copy();
        dst.number = number == null ? null : number.copy();
        dst.title = title == null ? null : title.copy();
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
     * Identifiers for the ImagingStudy such as DICOM Study Instance UID.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifiers for the whole study", formalDefinition="Identifiers for the ImagingStudy such as DICOM Study Instance UID." )
    protected List<Identifier> identifier;

    /**
     * The current state of the ImagingStudy resource. This is not the status of any ServiceRequest or Task resources associated with the ImagingStudy.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="registered | available | cancelled | entered-in-error | unknown", formalDefinition="The current state of the ImagingStudy resource. This is not the status of any ServiceRequest or Task resources associated with the ImagingStudy." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/imagingstudy-status")
    protected Enumeration<ImagingStudyStatus> status;

    /**
     * A list of all the distinct values of series.modality. This may include both acquisition and non-acquisition modalities.
     */
    @Child(name = "modality", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="All of the distinct values for series' modalities", formalDefinition="A list of all the distinct values of series.modality. This may include both acquisition and non-acquisition modalities." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://dicom.nema.org/medical/dicom/current/output/chtml/part16/sect_CID_33.html")
    protected List<CodeableConcept> modality;

    /**
     * The subject, typically a patient, of the imaging study.
     */
    @Child(name = "subject", type = {Patient.class, Device.class, Group.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who or what is the subject of the study", formalDefinition="The subject, typically a patient, of the imaging study." )
    protected Reference subject;

    /**
     * The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter with which this imaging study is associated", formalDefinition="The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made." )
    protected Reference encounter;

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
     * A larger event of which this particular ImagingStudy is a component or step.  For example,  an ImagingStudy as part of a procedure.
     */
    @Child(name = "partOf", type = {Procedure.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular ImagingStudy is a component or step.  For example,  an ImagingStudy as part of a procedure." )
    protected List<Reference> partOf;

    /**
     * The requesting/referring physician.
     */
    @Child(name = "referrer", type = {Practitioner.class, PractitionerRole.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Referring physician", formalDefinition="The requesting/referring physician." )
    protected Reference referrer;

    /**
     * The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType.
     */
    @Child(name = "endpoint", type = {Endpoint.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Study access endpoint", formalDefinition="The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType." )
    protected List<Reference> endpoint;

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
     * This field corresponds to the DICOM Procedure Code Sequence (0008,1032). This is different from the FHIR Procedure resource that may include the ImagingStudy.
     */
    @Child(name = "procedure", type = {CodeableReference.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The performed procedure or code", formalDefinition="This field corresponds to the DICOM Procedure Code Sequence (0008,1032). This is different from the FHIR Procedure resource that may include the ImagingStudy." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://loinc.org/vs/loinc-rsna-radiology-playbook")
    protected List<CodeableReference> procedure;

    /**
     * The principal physical location where the ImagingStudy was performed.
     */
    @Child(name = "location", type = {Location.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where ImagingStudy occurred", formalDefinition="The principal physical location where the ImagingStudy was performed." )
    protected Reference location;

    /**
     * Description of clinical condition indicating why the ImagingStudy was requested, and/or Indicates another resource whose existence justifies this Study.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Why the study was requested / performed", formalDefinition="Description of clinical condition indicating why the ImagingStudy was requested, and/or Indicates another resource whose existence justifies this Study." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-reason")
    protected List<CodeableReference> reason;

    /**
     * Per the recommended DICOM mapping, this element is derived from the Study Description attribute (0008,1030). Observations or findings about the imaging study should be recorded in another resource, e.g. Observation, and not in this element.
     */
    @Child(name = "note", type = {Annotation.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="User-defined comments", formalDefinition="Per the recommended DICOM mapping, this element is derived from the Study Description attribute (0008,1030). Observations or findings about the imaging study should be recorded in another resource, e.g. Observation, and not in this element." )
    protected List<Annotation> note;

    /**
     * The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.
     */
    @Child(name = "description", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Institution-generated description", formalDefinition="The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed." )
    protected StringType description;

    /**
     * Each study has one or more series of images or other content.
     */
    @Child(name = "series", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Each study has one or more series of instances", formalDefinition="Each study has one or more series of images or other content." )
    protected List<ImagingStudySeriesComponent> series;

    private static final long serialVersionUID = -1519153867L;

  /**
   * Constructor
   */
    public ImagingStudy() {
      super();
    }

  /**
   * Constructor
   */
    public ImagingStudy(ImagingStudyStatus status, Reference subject) {
      super();
      this.setStatus(status);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Identifiers for the ImagingStudy such as DICOM Study Instance UID.)
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
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #status} (The current state of the ImagingStudy resource. This is not the status of any ServiceRequest or Task resources associated with the ImagingStudy.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
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
     * @param value {@link #status} (The current state of the ImagingStudy resource. This is not the status of any ServiceRequest or Task resources associated with the ImagingStudy.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ImagingStudy setStatusElement(Enumeration<ImagingStudyStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the ImagingStudy resource. This is not the status of any ServiceRequest or Task resources associated with the ImagingStudy.
     */
    public ImagingStudyStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the ImagingStudy resource. This is not the status of any ServiceRequest or Task resources associated with the ImagingStudy.
     */
    public ImagingStudy setStatus(ImagingStudyStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<ImagingStudyStatus>(new ImagingStudyStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #modality} (A list of all the distinct values of series.modality. This may include both acquisition and non-acquisition modalities.)
     */
    public List<CodeableConcept> getModality() { 
      if (this.modality == null)
        this.modality = new ArrayList<CodeableConcept>();
      return this.modality;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setModality(List<CodeableConcept> theModality) { 
      this.modality = theModality;
      return this;
    }

    public boolean hasModality() { 
      if (this.modality == null)
        return false;
      for (CodeableConcept item : this.modality)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addModality() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.modality == null)
        this.modality = new ArrayList<CodeableConcept>();
      this.modality.add(t);
      return t;
    }

    public ImagingStudy addModality(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.modality == null)
        this.modality = new ArrayList<CodeableConcept>();
      this.modality.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #modality}, creating it if it does not already exist {3}
     */
    public CodeableConcept getModalityFirstRep() { 
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
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #partOf} (A larger event of which this particular ImagingStudy is a component or step.  For example,  an ImagingStudy as part of a procedure.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setPartOf(List<Reference> thePartOf) { 
      this.partOf = thePartOf;
      return this;
    }

    public boolean hasPartOf() { 
      if (this.partOf == null)
        return false;
      for (Reference item : this.partOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPartOf() { //3
      Reference t = new Reference();
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return t;
    }

    public ImagingStudy addPartOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist {3}
     */
    public Reference getPartOfFirstRep() { 
      if (getPartOf().isEmpty()) {
        addPartOf();
      }
      return getPartOf().get(0);
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
     * @return The first repetition of repeating field {@link #endpoint}, creating it if it does not already exist {3}
     */
    public Reference getEndpointFirstRep() { 
      if (getEndpoint().isEmpty()) {
        addEndpoint();
      }
      return getEndpoint().get(0);
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
     * @return {@link #procedure} (This field corresponds to the DICOM Procedure Code Sequence (0008,1032). This is different from the FHIR Procedure resource that may include the ImagingStudy.)
     */
    public List<CodeableReference> getProcedure() { 
      if (this.procedure == null)
        this.procedure = new ArrayList<CodeableReference>();
      return this.procedure;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setProcedure(List<CodeableReference> theProcedure) { 
      this.procedure = theProcedure;
      return this;
    }

    public boolean hasProcedure() { 
      if (this.procedure == null)
        return false;
      for (CodeableReference item : this.procedure)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addProcedure() { //3
      CodeableReference t = new CodeableReference();
      if (this.procedure == null)
        this.procedure = new ArrayList<CodeableReference>();
      this.procedure.add(t);
      return t;
    }

    public ImagingStudy addProcedure(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.procedure == null)
        this.procedure = new ArrayList<CodeableReference>();
      this.procedure.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #procedure}, creating it if it does not already exist {3}
     */
    public CodeableReference getProcedureFirstRep() { 
      if (getProcedure().isEmpty()) {
        addProcedure();
      }
      return getProcedure().get(0);
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
     * @return {@link #reason} (Description of clinical condition indicating why the ImagingStudy was requested, and/or Indicates another resource whose existence justifies this Study.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImagingStudy setReason(List<CodeableReference> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (CodeableReference item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addReason() { //3
      CodeableReference t = new CodeableReference();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return t;
    }

    public ImagingStudy addReason(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public CodeableReference getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
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
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
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
     * @return The first repetition of repeating field {@link #series}, creating it if it does not already exist {3}
     */
    public ImagingStudySeriesComponent getSeriesFirstRep() { 
      if (getSeries().isEmpty()) {
        addSeries();
      }
      return getSeries().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers for the ImagingStudy such as DICOM Study Instance UID.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The current state of the ImagingStudy resource. This is not the status of any ServiceRequest or Task resources associated with the ImagingStudy.", 0, 1, status));
        children.add(new Property("modality", "CodeableConcept", "A list of all the distinct values of series.modality. This may include both acquisition and non-acquisition modalities.", 0, java.lang.Integer.MAX_VALUE, modality));
        children.add(new Property("subject", "Reference(Patient|Device|Group)", "The subject, typically a patient, of the imaging study.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.", 0, 1, encounter));
        children.add(new Property("started", "dateTime", "Date and time the study started.", 0, 1, started));
        children.add(new Property("basedOn", "Reference(CarePlan|ServiceRequest|Appointment|AppointmentResponse|Task)", "A list of the diagnostic requests that resulted in this imaging study being performed.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(Procedure)", "A larger event of which this particular ImagingStudy is a component or step.  For example,  an ImagingStudy as part of a procedure.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("referrer", "Reference(Practitioner|PractitionerRole)", "The requesting/referring physician.", 0, 1, referrer));
        children.add(new Property("endpoint", "Reference(Endpoint)", "The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType.", 0, java.lang.Integer.MAX_VALUE, endpoint));
        children.add(new Property("numberOfSeries", "unsignedInt", "Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.", 0, 1, numberOfSeries));
        children.add(new Property("numberOfInstances", "unsignedInt", "Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.", 0, 1, numberOfInstances));
        children.add(new Property("procedure", "CodeableReference(PlanDefinition|ActivityDefinition)", "This field corresponds to the DICOM Procedure Code Sequence (0008,1032). This is different from the FHIR Procedure resource that may include the ImagingStudy.", 0, java.lang.Integer.MAX_VALUE, procedure));
        children.add(new Property("location", "Reference(Location)", "The principal physical location where the ImagingStudy was performed.", 0, 1, location));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Description of clinical condition indicating why the ImagingStudy was requested, and/or Indicates another resource whose existence justifies this Study.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("note", "Annotation", "Per the recommended DICOM mapping, this element is derived from the Study Description attribute (0008,1030). Observations or findings about the imaging study should be recorded in another resource, e.g. Observation, and not in this element.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("description", "string", "The Imaging Manager description of the study. Institution-generated description or classification of the Study (component) performed.", 0, 1, description));
        children.add(new Property("series", "", "Each study has one or more series of images or other content.", 0, java.lang.Integer.MAX_VALUE, series));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers for the ImagingStudy such as DICOM Study Instance UID.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the ImagingStudy resource. This is not the status of any ServiceRequest or Task resources associated with the ImagingStudy.", 0, 1, status);
        case -622722335: /*modality*/  return new Property("modality", "CodeableConcept", "A list of all the distinct values of series.modality. This may include both acquisition and non-acquisition modalities.", 0, java.lang.Integer.MAX_VALUE, modality);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Device|Group)", "The subject, typically a patient, of the imaging study.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The healthcare event (e.g. a patient and healthcare provider interaction) during which this ImagingStudy is made.", 0, 1, encounter);
        case -1897185151: /*started*/  return new Property("started", "dateTime", "Date and time the study started.", 0, 1, started);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|ServiceRequest|Appointment|AppointmentResponse|Task)", "A list of the diagnostic requests that resulted in this imaging study being performed.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Procedure)", "A larger event of which this particular ImagingStudy is a component or step.  For example,  an ImagingStudy as part of a procedure.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -722568161: /*referrer*/  return new Property("referrer", "Reference(Practitioner|PractitionerRole)", "The requesting/referring physician.", 0, 1, referrer);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "The network service providing access (e.g., query, view, or retrieval) for the study. See implementation notes for information about using DICOM endpoints. A study-level endpoint applies to each series in the study, unless overridden by a series-level endpoint with the same Endpoint.connectionType.", 0, java.lang.Integer.MAX_VALUE, endpoint);
        case 1920000407: /*numberOfSeries*/  return new Property("numberOfSeries", "unsignedInt", "Number of Series in the Study. This value given may be larger than the number of series elements this Resource contains due to resource availability, security, or other factors. This element should be present if any series elements are present.", 0, 1, numberOfSeries);
        case -1043544226: /*numberOfInstances*/  return new Property("numberOfInstances", "unsignedInt", "Number of SOP Instances in Study. This value given may be larger than the number of instance elements this resource contains due to resource availability, security, or other factors. This element should be present if any instance elements are present.", 0, 1, numberOfInstances);
        case -1095204141: /*procedure*/  return new Property("procedure", "CodeableReference(PlanDefinition|ActivityDefinition)", "This field corresponds to the DICOM Procedure Code Sequence (0008,1032). This is different from the FHIR Procedure resource that may include the ImagingStudy.", 0, java.lang.Integer.MAX_VALUE, procedure);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The principal physical location where the ImagingStudy was performed.", 0, 1, location);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Description of clinical condition indicating why the ImagingStudy was requested, and/or Indicates another resource whose existence justifies this Study.", 0, java.lang.Integer.MAX_VALUE, reason);
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
        case -622722335: /*modality*/ return this.modality == null ? new Base[0] : this.modality.toArray(new Base[this.modality.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1897185151: /*started*/ return this.started == null ? new Base[0] : new Base[] {this.started}; // DateTimeType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -722568161: /*referrer*/ return this.referrer == null ? new Base[0] : new Base[] {this.referrer}; // Reference
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
        case 1920000407: /*numberOfSeries*/ return this.numberOfSeries == null ? new Base[0] : new Base[] {this.numberOfSeries}; // UnsignedIntType
        case -1043544226: /*numberOfInstances*/ return this.numberOfInstances == null ? new Base[0] : new Base[] {this.numberOfInstances}; // UnsignedIntType
        case -1095204141: /*procedure*/ return this.procedure == null ? new Base[0] : this.procedure.toArray(new Base[this.procedure.size()]); // CodeableReference
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
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
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new ImagingStudyStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ImagingStudyStatus>
          return value;
        case -622722335: // modality
          this.getModality().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1897185151: // started
          this.started = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -722568161: // referrer
          this.referrer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1920000407: // numberOfSeries
          this.numberOfSeries = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -1043544226: // numberOfInstances
          this.numberOfInstances = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -1095204141: // procedure
          this.getProcedure().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
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
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new ImagingStudyStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ImagingStudyStatus>
        } else if (name.equals("modality")) {
          this.getModality().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("started")) {
          this.started = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("referrer")) {
          this.referrer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(TypeConvertor.castToReference(value));
        } else if (name.equals("numberOfSeries")) {
          this.numberOfSeries = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("numberOfInstances")) {
          this.numberOfInstances = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("procedure")) {
          this.getProcedure().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
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
        case -995410646:  return addPartOf(); 
        case -722568161:  return getReferrer();
        case 1741102485:  return addEndpoint(); 
        case 1920000407:  return getNumberOfSeriesElement();
        case -1043544226:  return getNumberOfInstancesElement();
        case -1095204141:  return addProcedure(); 
        case 1901043637:  return getLocation();
        case -934964668:  return addReason(); 
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
        case -622722335: /*modality*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1897185151: /*started*/ return new String[] {"dateTime"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -722568161: /*referrer*/ return new String[] {"Reference"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        case 1920000407: /*numberOfSeries*/ return new String[] {"unsignedInt"};
        case -1043544226: /*numberOfInstances*/ return new String[] {"unsignedInt"};
        case -1095204141: /*procedure*/ return new String[] {"CodeableReference"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
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
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.status");
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
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.started");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("referrer")) {
          this.referrer = new Reference();
          return this.referrer;
        }
        else if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else if (name.equals("numberOfSeries")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.numberOfSeries");
        }
        else if (name.equals("numberOfInstances")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.numberOfInstances");
        }
        else if (name.equals("procedure")) {
          return addProcedure();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ImagingStudy.description");
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
        return dst;
      }

      public void copyValues(ImagingStudy dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (modality != null) {
          dst.modality = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : modality)
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
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.referrer = referrer == null ? null : referrer.copy();
        if (endpoint != null) {
          dst.endpoint = new ArrayList<Reference>();
          for (Reference i : endpoint)
            dst.endpoint.add(i.copy());
        };
        dst.numberOfSeries = numberOfSeries == null ? null : numberOfSeries.copy();
        dst.numberOfInstances = numberOfInstances == null ? null : numberOfInstances.copy();
        if (procedure != null) {
          dst.procedure = new ArrayList<CodeableReference>();
          for (CodeableReference i : procedure)
            dst.procedure.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
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
           && compareDeep(basedOn, o.basedOn, true) && compareDeep(partOf, o.partOf, true) && compareDeep(referrer, o.referrer, true)
           && compareDeep(endpoint, o.endpoint, true) && compareDeep(numberOfSeries, o.numberOfSeries, true)
           && compareDeep(numberOfInstances, o.numberOfInstances, true) && compareDeep(procedure, o.procedure, true)
           && compareDeep(location, o.location, true) && compareDeep(reason, o.reason, true) && compareDeep(note, o.note, true)
           && compareDeep(description, o.description, true) && compareDeep(series, o.series, true);
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
          , subject, encounter, started, basedOn, partOf, referrer, endpoint, numberOfSeries
          , numberOfInstances, procedure, location, reason, note, description, series);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ImagingStudy;
   }

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>The order for the image, such as Accession Number associated with a ServiceRequest</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="ImagingStudy.basedOn", description="The order for the image, such as Accession Number associated with a ServiceRequest", type="reference", target={Appointment.class, AppointmentResponse.class, CarePlan.class, ServiceRequest.class, Task.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>The order for the image, such as Accession Number associated with a ServiceRequest</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("ImagingStudy:based-on").toLocked();

 /**
   * Search parameter: <b>body-site</b>
   * <p>
   * Description: <b>The body site code studied</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.bodySite.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="body-site", path="ImagingStudy.series.bodySite.concept", description="The body site code studied", type="token" )
  public static final String SP_BODY_SITE = "body-site";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>body-site</b>
   * <p>
   * Description: <b>The body site code studied</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ImagingStudy.series.bodySite.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BODY_SITE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_BODY_SITE);

 /**
   * Search parameter: <b>body-structure</b>
   * <p>
   * Description: <b>The body structure resource associated with the ImagingStudy</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.series.bodySite.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="body-structure", path="ImagingStudy.series.bodySite.reference", description="The body structure resource associated with the ImagingStudy", type="reference", target={BodyStructure.class } )
  public static final String SP_BODY_STRUCTURE = "body-structure";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>body-structure</b>
   * <p>
   * Description: <b>The body structure resource associated with the ImagingStudy</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.series.bodySite.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BODY_STRUCTURE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BODY_STRUCTURE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:body-structure</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BODY_STRUCTURE = new ca.uhn.fhir.model.api.Include("ImagingStudy:body-structure").toLocked();

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
   * Search parameter: <b>endpoint</b>
   * <p>
   * Description: <b>The endpoint for the study or series</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.endpoint | ImagingStudy.series.endpoint</b><br>
   * </p>
   */
  @SearchParamDefinition(name="endpoint", path="ImagingStudy.endpoint | ImagingStudy.series.endpoint", description="The endpoint for the study or series", type="reference", target={Endpoint.class } )
  public static final String SP_ENDPOINT = "endpoint";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>endpoint</b>
   * <p>
   * Description: <b>The endpoint for the study or series</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.endpoint | ImagingStudy.series.endpoint</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENDPOINT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENDPOINT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:endpoint</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENDPOINT = new ca.uhn.fhir.model.api.Include("ImagingStudy:endpoint").toLocked();

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
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>The person who performed the study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ImagingStudy.series.performer.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer", path="ImagingStudy.series.performer.actor", description="The person who performed the study", type="reference", target={CareTeam.class, Device.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
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
   * Search parameter: <b>reason</b>
   * <p>
   * Description: <b>The reason for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  @SearchParamDefinition(name="reason", path="", description="The reason for the study", type="token" )
  public static final String SP_REASON = "reason";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>reason</b>
   * <p>
   * Description: <b>The reason for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam REASON = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_REASON);

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
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent\r\n* [CarePlan](careplan.html): The Encounter during which this CarePlan was created\r\n* [ChargeItem](chargeitem.html): Encounter associated with event\r\n* [Claim](claim.html): Encounters associated with a billed line item\r\n* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created\r\n* [Communication](communication.html): The Encounter during which this Communication was created\r\n* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created\r\n* [Composition](composition.html): Context of the Composition\r\n* [Condition](condition.html): The Encounter during which this Condition was created\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values\r\n* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [ImagingStudy](imagingstudy.html): The context of the study\r\n* [List](list.html): Context in which list created\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [Provenance](provenance.html): Encounter related to the Provenance\r\n* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response\r\n* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [Task](task.html): Search by encounter\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("ImagingStudy:encounter").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [Account](account.html): Account number\r\n* [AdverseEvent](adverseevent.html): Business identifier for the event\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [Appointment](appointment.html): An Identifier of the Appointment\r\n* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response\r\n* [Basic](basic.html): Business identifier\r\n* [BodyStructure](bodystructure.html): Bodystructure identifier\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [ChargeItem](chargeitem.html): Business Identifier for item\r\n* [Claim](claim.html): The primary identifier of the financial resource\r\n* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse\r\n* [ClinicalImpression](clinicalimpression.html): Business identifier\r\n* [Communication](communication.html): Unique identifier\r\n* [CommunicationRequest](communicationrequest.html): Unique identifier\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [Contract](contract.html): The identity of the contract\r\n* [Coverage](coverage.html): The primary identifier of the insured and the coverage\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DeviceUsage](deviceusage.html): Search by identifier\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Flag](flag.html): Business identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response\r\n* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier\r\n* [Invoice](invoice.html): Business Identifier for item\r\n* [List](list.html): Business identifier\r\n* [MeasureReport](measurereport.html): External identifier of the measure report to be returned\r\n* [Medication](medication.html): Returns medications with this external identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationStatement](medicationstatement.html): Return statements with this external identifier\r\n* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence\r\n* [NutritionIntake](nutritionintake.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Person](person.html): A person Identifier\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response\r\n* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson\r\n* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration\r\n* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [Specimen](specimen.html): The unique identifier associated with the specimen\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [Task](task.html): Search for a task instance by its business identifier\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ImagingStudy:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("ImagingStudy:patient").toLocked();


}

