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

// Generated on Tue, Dec 13, 2022 17:53+1100 for FHIR vcurrent

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
 * A Genomic Study is a set of analysis performed to analyze and generate genomic data.
 */
@ResourceDef(name="GenomicStudy", profile="http://hl7.org/fhir/StructureDefinition/GenomicStudy")
public class GenomicStudy extends DomainResource {

    @Block()
    public static class GenomicStudyAnalysisComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifiers for the analysis event.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Identifiers for the analysis event", formalDefinition="Identifiers for the analysis event." )
        protected List<Identifier> identifier;

        /**
         * Type of the methods used in the analysis, e.g., Fluorescence in situ hybridization (FISH), Karyotyping, or Microsatellite instability testing (MSI).
         */
        @Child(name = "methodType", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Type of the methods used in the analysis (e.g., FISH, Karyotyping, MSI)", formalDefinition="Type of the methods used in the analysis, e.g., Fluorescence in situ hybridization (FISH), Karyotyping, or Microsatellite instability testing (MSI)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/genomicstudy-methodtype")
        protected List<CodeableConcept> methodType;

        /**
         * Type of the genomic changes studied in the analysis, e.g., DNA, RNA, or amino acid change.
         */
        @Child(name = "changeType", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Type of the genomic changes studied in the analysis (e.g., DNA, RNA, or AA change)", formalDefinition="Type of the genomic changes studied in the analysis, e.g., DNA, RNA, or amino acid change." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/genomicstudy-changetype")
        protected List<CodeableConcept> changeType;

        /**
         * The reference genome build that is used in this analysis.
         */
        @Child(name = "genomeBuild", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Genome build that is used in this analysis", formalDefinition="The reference genome build that is used in this analysis." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://loinc.org/vs/LL1040-6")
        protected CodeableConcept genomeBuild;

        /**
         * The defined protocol that describes the analysis.
         */
        @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The defined protocol that describes the analysis", formalDefinition="The defined protocol that describes the analysis." )
        protected CanonicalType instantiatesCanonical;

        /**
         * The URL pointing to an externally maintained protocol that describes the analysis.
         */
        @Child(name = "instantiatesUri", type = {UriType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The URL pointing to an externally maintained protocol that describes the analysis", formalDefinition="The URL pointing to an externally maintained protocol that describes the analysis." )
        protected UriType instantiatesUri;

        /**
         * Name of the analysis event (human friendly).
         */
        @Child(name = "title", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the analysis event (human friendly)", formalDefinition="Name of the analysis event (human friendly)." )
        protected StringType title;

        /**
         * The subject of the analysis event.
         */
        @Child(name = "subject", type = {Patient.class, Group.class, Device.class, Location.class, Organization.class, Procedure.class, Practitioner.class, Medication.class, Substance.class, BiologicallyDerivedProduct.class, NutritionProduct.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The subject of the analysis event", formalDefinition="The subject of the analysis event." )
        protected Reference subject;

        /**
         * The specimen used in the analysis event.
         */
        @Child(name = "specimen", type = {Specimen.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The specimen used in the analysis event", formalDefinition="The specimen used in the analysis event." )
        protected List<Reference> specimen;

        /**
         * The date of the analysis event.
         */
        @Child(name = "date", type = {DateTimeType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date of the analysis event", formalDefinition="The date of the analysis event." )
        protected DateTimeType date;

        /**
         * Any notes capture with the analysis event.
         */
        @Child(name = "note", type = {Annotation.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Any notes capture with the analysis event", formalDefinition="Any notes capture with the analysis event." )
        protected List<Annotation> note;

        /**
         * The protocol that was performed for the analysis event.
         */
        @Child(name = "protocolPerformed", type = {Procedure.class, Task.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The protocol that was performed for the analysis event", formalDefinition="The protocol that was performed for the analysis event." )
        protected Reference protocolPerformed;

        /**
         * The genomic regions to be studied in the analysis (BED file).
         */
        @Child(name = "regionsStudied", type = {DocumentReference.class, Observation.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The genomic regions to be studied in the analysis (BED file)", formalDefinition="The genomic regions to be studied in the analysis (BED file)." )
        protected List<Reference> regionsStudied;

        /**
         * Genomic regions actually called in the analysis event (BED file).
         */
        @Child(name = "regionsCalled", type = {DocumentReference.class, Observation.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Genomic regions actually called in the analysis event (BED file)", formalDefinition="Genomic regions actually called in the analysis event (BED file)." )
        protected List<Reference> regionsCalled;

        /**
         * Inputs for the analysis event.
         */
        @Child(name = "input", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Inputs for the analysis event", formalDefinition="Inputs for the analysis event." )
        protected List<GenomicStudyAnalysisInputComponent> input;

        /**
         * Outputs for the analysis event.
         */
        @Child(name = "output", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Outputs for the analysis event", formalDefinition="Outputs for the analysis event." )
        protected List<GenomicStudyAnalysisOutputComponent> output;

        /**
         * Performer for the analysis event.
         */
        @Child(name = "performer", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Performer for the analysis event", formalDefinition="Performer for the analysis event." )
        protected List<GenomicStudyAnalysisPerformerComponent> performer;

        /**
         * Devices used for the analysis (e.g., instruments, software), with settings and parameters.
         */
        @Child(name = "device", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Devices used for the analysis (e.g., instruments, software), with settings and parameters", formalDefinition="Devices used for the analysis (e.g., instruments, software), with settings and parameters." )
        protected List<GenomicStudyAnalysisDeviceComponent> device;

        private static final long serialVersionUID = 400268376L;

    /**
     * Constructor
     */
      public GenomicStudyAnalysisComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (Identifiers for the analysis event.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public GenomicStudyAnalysisComponent addIdentifier(Identifier t) { //3
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
         * @return {@link #methodType} (Type of the methods used in the analysis, e.g., Fluorescence in situ hybridization (FISH), Karyotyping, or Microsatellite instability testing (MSI).)
         */
        public List<CodeableConcept> getMethodType() { 
          if (this.methodType == null)
            this.methodType = new ArrayList<CodeableConcept>();
          return this.methodType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setMethodType(List<CodeableConcept> theMethodType) { 
          this.methodType = theMethodType;
          return this;
        }

        public boolean hasMethodType() { 
          if (this.methodType == null)
            return false;
          for (CodeableConcept item : this.methodType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addMethodType() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.methodType == null)
            this.methodType = new ArrayList<CodeableConcept>();
          this.methodType.add(t);
          return t;
        }

        public GenomicStudyAnalysisComponent addMethodType(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.methodType == null)
            this.methodType = new ArrayList<CodeableConcept>();
          this.methodType.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #methodType}, creating it if it does not already exist {3}
         */
        public CodeableConcept getMethodTypeFirstRep() { 
          if (getMethodType().isEmpty()) {
            addMethodType();
          }
          return getMethodType().get(0);
        }

        /**
         * @return {@link #changeType} (Type of the genomic changes studied in the analysis, e.g., DNA, RNA, or amino acid change.)
         */
        public List<CodeableConcept> getChangeType() { 
          if (this.changeType == null)
            this.changeType = new ArrayList<CodeableConcept>();
          return this.changeType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setChangeType(List<CodeableConcept> theChangeType) { 
          this.changeType = theChangeType;
          return this;
        }

        public boolean hasChangeType() { 
          if (this.changeType == null)
            return false;
          for (CodeableConcept item : this.changeType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addChangeType() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.changeType == null)
            this.changeType = new ArrayList<CodeableConcept>();
          this.changeType.add(t);
          return t;
        }

        public GenomicStudyAnalysisComponent addChangeType(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.changeType == null)
            this.changeType = new ArrayList<CodeableConcept>();
          this.changeType.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #changeType}, creating it if it does not already exist {3}
         */
        public CodeableConcept getChangeTypeFirstRep() { 
          if (getChangeType().isEmpty()) {
            addChangeType();
          }
          return getChangeType().get(0);
        }

        /**
         * @return {@link #genomeBuild} (The reference genome build that is used in this analysis.)
         */
        public CodeableConcept getGenomeBuild() { 
          if (this.genomeBuild == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisComponent.genomeBuild");
            else if (Configuration.doAutoCreate())
              this.genomeBuild = new CodeableConcept(); // cc
          return this.genomeBuild;
        }

        public boolean hasGenomeBuild() { 
          return this.genomeBuild != null && !this.genomeBuild.isEmpty();
        }

        /**
         * @param value {@link #genomeBuild} (The reference genome build that is used in this analysis.)
         */
        public GenomicStudyAnalysisComponent setGenomeBuild(CodeableConcept value) { 
          this.genomeBuild = value;
          return this;
        }

        /**
         * @return {@link #instantiatesCanonical} (The defined protocol that describes the analysis.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesCanonical" gives direct access to the value
         */
        public CanonicalType getInstantiatesCanonicalElement() { 
          if (this.instantiatesCanonical == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisComponent.instantiatesCanonical");
            else if (Configuration.doAutoCreate())
              this.instantiatesCanonical = new CanonicalType(); // bb
          return this.instantiatesCanonical;
        }

        public boolean hasInstantiatesCanonicalElement() { 
          return this.instantiatesCanonical != null && !this.instantiatesCanonical.isEmpty();
        }

        public boolean hasInstantiatesCanonical() { 
          return this.instantiatesCanonical != null && !this.instantiatesCanonical.isEmpty();
        }

        /**
         * @param value {@link #instantiatesCanonical} (The defined protocol that describes the analysis.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesCanonical" gives direct access to the value
         */
        public GenomicStudyAnalysisComponent setInstantiatesCanonicalElement(CanonicalType value) { 
          this.instantiatesCanonical = value;
          return this;
        }

        /**
         * @return The defined protocol that describes the analysis.
         */
        public String getInstantiatesCanonical() { 
          return this.instantiatesCanonical == null ? null : this.instantiatesCanonical.getValue();
        }

        /**
         * @param value The defined protocol that describes the analysis.
         */
        public GenomicStudyAnalysisComponent setInstantiatesCanonical(String value) { 
          if (Utilities.noString(value))
            this.instantiatesCanonical = null;
          else {
            if (this.instantiatesCanonical == null)
              this.instantiatesCanonical = new CanonicalType();
            this.instantiatesCanonical.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol that describes the analysis.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesUri" gives direct access to the value
         */
        public UriType getInstantiatesUriElement() { 
          if (this.instantiatesUri == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisComponent.instantiatesUri");
            else if (Configuration.doAutoCreate())
              this.instantiatesUri = new UriType(); // bb
          return this.instantiatesUri;
        }

        public boolean hasInstantiatesUriElement() { 
          return this.instantiatesUri != null && !this.instantiatesUri.isEmpty();
        }

        public boolean hasInstantiatesUri() { 
          return this.instantiatesUri != null && !this.instantiatesUri.isEmpty();
        }

        /**
         * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol that describes the analysis.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesUri" gives direct access to the value
         */
        public GenomicStudyAnalysisComponent setInstantiatesUriElement(UriType value) { 
          this.instantiatesUri = value;
          return this;
        }

        /**
         * @return The URL pointing to an externally maintained protocol that describes the analysis.
         */
        public String getInstantiatesUri() { 
          return this.instantiatesUri == null ? null : this.instantiatesUri.getValue();
        }

        /**
         * @param value The URL pointing to an externally maintained protocol that describes the analysis.
         */
        public GenomicStudyAnalysisComponent setInstantiatesUri(String value) { 
          if (Utilities.noString(value))
            this.instantiatesUri = null;
          else {
            if (this.instantiatesUri == null)
              this.instantiatesUri = new UriType();
            this.instantiatesUri.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #title} (Name of the analysis event (human friendly).). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisComponent.title");
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
         * @param value {@link #title} (Name of the analysis event (human friendly).). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public GenomicStudyAnalysisComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return Name of the analysis event (human friendly).
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value Name of the analysis event (human friendly).
         */
        public GenomicStudyAnalysisComponent setTitle(String value) { 
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
         * @return {@link #subject} (The subject of the analysis event.)
         */
        public Reference getSubject() { 
          if (this.subject == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisComponent.subject");
            else if (Configuration.doAutoCreate())
              this.subject = new Reference(); // cc
          return this.subject;
        }

        public boolean hasSubject() { 
          return this.subject != null && !this.subject.isEmpty();
        }

        /**
         * @param value {@link #subject} (The subject of the analysis event.)
         */
        public GenomicStudyAnalysisComponent setSubject(Reference value) { 
          this.subject = value;
          return this;
        }

        /**
         * @return {@link #specimen} (The specimen used in the analysis event.)
         */
        public List<Reference> getSpecimen() { 
          if (this.specimen == null)
            this.specimen = new ArrayList<Reference>();
          return this.specimen;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setSpecimen(List<Reference> theSpecimen) { 
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

        public GenomicStudyAnalysisComponent addSpecimen(Reference t) { //3
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
         * @return {@link #date} (The date of the analysis event.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public DateTimeType getDateElement() { 
          if (this.date == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisComponent.date");
            else if (Configuration.doAutoCreate())
              this.date = new DateTimeType(); // bb
          return this.date;
        }

        public boolean hasDateElement() { 
          return this.date != null && !this.date.isEmpty();
        }

        public boolean hasDate() { 
          return this.date != null && !this.date.isEmpty();
        }

        /**
         * @param value {@link #date} (The date of the analysis event.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public GenomicStudyAnalysisComponent setDateElement(DateTimeType value) { 
          this.date = value;
          return this;
        }

        /**
         * @return The date of the analysis event.
         */
        public Date getDate() { 
          return this.date == null ? null : this.date.getValue();
        }

        /**
         * @param value The date of the analysis event.
         */
        public GenomicStudyAnalysisComponent setDate(Date value) { 
          if (value == null)
            this.date = null;
          else {
            if (this.date == null)
              this.date = new DateTimeType();
            this.date.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #note} (Any notes capture with the analysis event.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setNote(List<Annotation> theNote) { 
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

        public GenomicStudyAnalysisComponent addNote(Annotation t) { //3
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
         * @return {@link #protocolPerformed} (The protocol that was performed for the analysis event.)
         */
        public Reference getProtocolPerformed() { 
          if (this.protocolPerformed == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisComponent.protocolPerformed");
            else if (Configuration.doAutoCreate())
              this.protocolPerformed = new Reference(); // cc
          return this.protocolPerformed;
        }

        public boolean hasProtocolPerformed() { 
          return this.protocolPerformed != null && !this.protocolPerformed.isEmpty();
        }

        /**
         * @param value {@link #protocolPerformed} (The protocol that was performed for the analysis event.)
         */
        public GenomicStudyAnalysisComponent setProtocolPerformed(Reference value) { 
          this.protocolPerformed = value;
          return this;
        }

        /**
         * @return {@link #regionsStudied} (The genomic regions to be studied in the analysis (BED file).)
         */
        public List<Reference> getRegionsStudied() { 
          if (this.regionsStudied == null)
            this.regionsStudied = new ArrayList<Reference>();
          return this.regionsStudied;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setRegionsStudied(List<Reference> theRegionsStudied) { 
          this.regionsStudied = theRegionsStudied;
          return this;
        }

        public boolean hasRegionsStudied() { 
          if (this.regionsStudied == null)
            return false;
          for (Reference item : this.regionsStudied)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addRegionsStudied() { //3
          Reference t = new Reference();
          if (this.regionsStudied == null)
            this.regionsStudied = new ArrayList<Reference>();
          this.regionsStudied.add(t);
          return t;
        }

        public GenomicStudyAnalysisComponent addRegionsStudied(Reference t) { //3
          if (t == null)
            return this;
          if (this.regionsStudied == null)
            this.regionsStudied = new ArrayList<Reference>();
          this.regionsStudied.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #regionsStudied}, creating it if it does not already exist {3}
         */
        public Reference getRegionsStudiedFirstRep() { 
          if (getRegionsStudied().isEmpty()) {
            addRegionsStudied();
          }
          return getRegionsStudied().get(0);
        }

        /**
         * @return {@link #regionsCalled} (Genomic regions actually called in the analysis event (BED file).)
         */
        public List<Reference> getRegionsCalled() { 
          if (this.regionsCalled == null)
            this.regionsCalled = new ArrayList<Reference>();
          return this.regionsCalled;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setRegionsCalled(List<Reference> theRegionsCalled) { 
          this.regionsCalled = theRegionsCalled;
          return this;
        }

        public boolean hasRegionsCalled() { 
          if (this.regionsCalled == null)
            return false;
          for (Reference item : this.regionsCalled)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addRegionsCalled() { //3
          Reference t = new Reference();
          if (this.regionsCalled == null)
            this.regionsCalled = new ArrayList<Reference>();
          this.regionsCalled.add(t);
          return t;
        }

        public GenomicStudyAnalysisComponent addRegionsCalled(Reference t) { //3
          if (t == null)
            return this;
          if (this.regionsCalled == null)
            this.regionsCalled = new ArrayList<Reference>();
          this.regionsCalled.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #regionsCalled}, creating it if it does not already exist {3}
         */
        public Reference getRegionsCalledFirstRep() { 
          if (getRegionsCalled().isEmpty()) {
            addRegionsCalled();
          }
          return getRegionsCalled().get(0);
        }

        /**
         * @return {@link #input} (Inputs for the analysis event.)
         */
        public List<GenomicStudyAnalysisInputComponent> getInput() { 
          if (this.input == null)
            this.input = new ArrayList<GenomicStudyAnalysisInputComponent>();
          return this.input;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setInput(List<GenomicStudyAnalysisInputComponent> theInput) { 
          this.input = theInput;
          return this;
        }

        public boolean hasInput() { 
          if (this.input == null)
            return false;
          for (GenomicStudyAnalysisInputComponent item : this.input)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public GenomicStudyAnalysisInputComponent addInput() { //3
          GenomicStudyAnalysisInputComponent t = new GenomicStudyAnalysisInputComponent();
          if (this.input == null)
            this.input = new ArrayList<GenomicStudyAnalysisInputComponent>();
          this.input.add(t);
          return t;
        }

        public GenomicStudyAnalysisComponent addInput(GenomicStudyAnalysisInputComponent t) { //3
          if (t == null)
            return this;
          if (this.input == null)
            this.input = new ArrayList<GenomicStudyAnalysisInputComponent>();
          this.input.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #input}, creating it if it does not already exist {3}
         */
        public GenomicStudyAnalysisInputComponent getInputFirstRep() { 
          if (getInput().isEmpty()) {
            addInput();
          }
          return getInput().get(0);
        }

        /**
         * @return {@link #output} (Outputs for the analysis event.)
         */
        public List<GenomicStudyAnalysisOutputComponent> getOutput() { 
          if (this.output == null)
            this.output = new ArrayList<GenomicStudyAnalysisOutputComponent>();
          return this.output;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setOutput(List<GenomicStudyAnalysisOutputComponent> theOutput) { 
          this.output = theOutput;
          return this;
        }

        public boolean hasOutput() { 
          if (this.output == null)
            return false;
          for (GenomicStudyAnalysisOutputComponent item : this.output)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public GenomicStudyAnalysisOutputComponent addOutput() { //3
          GenomicStudyAnalysisOutputComponent t = new GenomicStudyAnalysisOutputComponent();
          if (this.output == null)
            this.output = new ArrayList<GenomicStudyAnalysisOutputComponent>();
          this.output.add(t);
          return t;
        }

        public GenomicStudyAnalysisComponent addOutput(GenomicStudyAnalysisOutputComponent t) { //3
          if (t == null)
            return this;
          if (this.output == null)
            this.output = new ArrayList<GenomicStudyAnalysisOutputComponent>();
          this.output.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #output}, creating it if it does not already exist {3}
         */
        public GenomicStudyAnalysisOutputComponent getOutputFirstRep() { 
          if (getOutput().isEmpty()) {
            addOutput();
          }
          return getOutput().get(0);
        }

        /**
         * @return {@link #performer} (Performer for the analysis event.)
         */
        public List<GenomicStudyAnalysisPerformerComponent> getPerformer() { 
          if (this.performer == null)
            this.performer = new ArrayList<GenomicStudyAnalysisPerformerComponent>();
          return this.performer;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setPerformer(List<GenomicStudyAnalysisPerformerComponent> thePerformer) { 
          this.performer = thePerformer;
          return this;
        }

        public boolean hasPerformer() { 
          if (this.performer == null)
            return false;
          for (GenomicStudyAnalysisPerformerComponent item : this.performer)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public GenomicStudyAnalysisPerformerComponent addPerformer() { //3
          GenomicStudyAnalysisPerformerComponent t = new GenomicStudyAnalysisPerformerComponent();
          if (this.performer == null)
            this.performer = new ArrayList<GenomicStudyAnalysisPerformerComponent>();
          this.performer.add(t);
          return t;
        }

        public GenomicStudyAnalysisComponent addPerformer(GenomicStudyAnalysisPerformerComponent t) { //3
          if (t == null)
            return this;
          if (this.performer == null)
            this.performer = new ArrayList<GenomicStudyAnalysisPerformerComponent>();
          this.performer.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
         */
        public GenomicStudyAnalysisPerformerComponent getPerformerFirstRep() { 
          if (getPerformer().isEmpty()) {
            addPerformer();
          }
          return getPerformer().get(0);
        }

        /**
         * @return {@link #device} (Devices used for the analysis (e.g., instruments, software), with settings and parameters.)
         */
        public List<GenomicStudyAnalysisDeviceComponent> getDevice() { 
          if (this.device == null)
            this.device = new ArrayList<GenomicStudyAnalysisDeviceComponent>();
          return this.device;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public GenomicStudyAnalysisComponent setDevice(List<GenomicStudyAnalysisDeviceComponent> theDevice) { 
          this.device = theDevice;
          return this;
        }

        public boolean hasDevice() { 
          if (this.device == null)
            return false;
          for (GenomicStudyAnalysisDeviceComponent item : this.device)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public GenomicStudyAnalysisDeviceComponent addDevice() { //3
          GenomicStudyAnalysisDeviceComponent t = new GenomicStudyAnalysisDeviceComponent();
          if (this.device == null)
            this.device = new ArrayList<GenomicStudyAnalysisDeviceComponent>();
          this.device.add(t);
          return t;
        }

        public GenomicStudyAnalysisComponent addDevice(GenomicStudyAnalysisDeviceComponent t) { //3
          if (t == null)
            return this;
          if (this.device == null)
            this.device = new ArrayList<GenomicStudyAnalysisDeviceComponent>();
          this.device.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #device}, creating it if it does not already exist {3}
         */
        public GenomicStudyAnalysisDeviceComponent getDeviceFirstRep() { 
          if (getDevice().isEmpty()) {
            addDevice();
          }
          return getDevice().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "Identifiers for the analysis event.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("methodType", "CodeableConcept", "Type of the methods used in the analysis, e.g., Fluorescence in situ hybridization (FISH), Karyotyping, or Microsatellite instability testing (MSI).", 0, java.lang.Integer.MAX_VALUE, methodType));
          children.add(new Property("changeType", "CodeableConcept", "Type of the genomic changes studied in the analysis, e.g., DNA, RNA, or amino acid change.", 0, java.lang.Integer.MAX_VALUE, changeType));
          children.add(new Property("genomeBuild", "CodeableConcept", "The reference genome build that is used in this analysis.", 0, 1, genomeBuild));
          children.add(new Property("instantiatesCanonical", "canonical(PlanDefinition|ActivityDefinition)", "The defined protocol that describes the analysis.", 0, 1, instantiatesCanonical));
          children.add(new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol that describes the analysis.", 0, 1, instantiatesUri));
          children.add(new Property("title", "string", "Name of the analysis event (human friendly).", 0, 1, title));
          children.add(new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct|NutritionProduct)", "The subject of the analysis event.", 0, 1, subject));
          children.add(new Property("specimen", "Reference(Specimen)", "The specimen used in the analysis event.", 0, java.lang.Integer.MAX_VALUE, specimen));
          children.add(new Property("date", "dateTime", "The date of the analysis event.", 0, 1, date));
          children.add(new Property("note", "Annotation", "Any notes capture with the analysis event.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("protocolPerformed", "Reference(Procedure|Task)", "The protocol that was performed for the analysis event.", 0, 1, protocolPerformed));
          children.add(new Property("regionsStudied", "Reference(DocumentReference|Observation)", "The genomic regions to be studied in the analysis (BED file).", 0, java.lang.Integer.MAX_VALUE, regionsStudied));
          children.add(new Property("regionsCalled", "Reference(DocumentReference|Observation)", "Genomic regions actually called in the analysis event (BED file).", 0, java.lang.Integer.MAX_VALUE, regionsCalled));
          children.add(new Property("input", "", "Inputs for the analysis event.", 0, java.lang.Integer.MAX_VALUE, input));
          children.add(new Property("output", "", "Outputs for the analysis event.", 0, java.lang.Integer.MAX_VALUE, output));
          children.add(new Property("performer", "", "Performer for the analysis event.", 0, java.lang.Integer.MAX_VALUE, performer));
          children.add(new Property("device", "", "Devices used for the analysis (e.g., instruments, software), with settings and parameters.", 0, java.lang.Integer.MAX_VALUE, device));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers for the analysis event.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case -722961477: /*methodType*/  return new Property("methodType", "CodeableConcept", "Type of the methods used in the analysis, e.g., Fluorescence in situ hybridization (FISH), Karyotyping, or Microsatellite instability testing (MSI).", 0, java.lang.Integer.MAX_VALUE, methodType);
          case -2131902710: /*changeType*/  return new Property("changeType", "CodeableConcept", "Type of the genomic changes studied in the analysis, e.g., DNA, RNA, or amino acid change.", 0, java.lang.Integer.MAX_VALUE, changeType);
          case 1061239735: /*genomeBuild*/  return new Property("genomeBuild", "CodeableConcept", "The reference genome build that is used in this analysis.", 0, 1, genomeBuild);
          case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(PlanDefinition|ActivityDefinition)", "The defined protocol that describes the analysis.", 0, 1, instantiatesCanonical);
          case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol that describes the analysis.", 0, 1, instantiatesUri);
          case 110371416: /*title*/  return new Property("title", "string", "Name of the analysis event (human friendly).", 0, 1, title);
          case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct|NutritionProduct)", "The subject of the analysis event.", 0, 1, subject);
          case -2132868344: /*specimen*/  return new Property("specimen", "Reference(Specimen)", "The specimen used in the analysis event.", 0, java.lang.Integer.MAX_VALUE, specimen);
          case 3076014: /*date*/  return new Property("date", "dateTime", "The date of the analysis event.", 0, 1, date);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Any notes capture with the analysis event.", 0, java.lang.Integer.MAX_VALUE, note);
          case -1565516792: /*protocolPerformed*/  return new Property("protocolPerformed", "Reference(Procedure|Task)", "The protocol that was performed for the analysis event.", 0, 1, protocolPerformed);
          case 391791385: /*regionsStudied*/  return new Property("regionsStudied", "Reference(DocumentReference|Observation)", "The genomic regions to be studied in the analysis (BED file).", 0, java.lang.Integer.MAX_VALUE, regionsStudied);
          case -2125803428: /*regionsCalled*/  return new Property("regionsCalled", "Reference(DocumentReference|Observation)", "Genomic regions actually called in the analysis event (BED file).", 0, java.lang.Integer.MAX_VALUE, regionsCalled);
          case 100358090: /*input*/  return new Property("input", "", "Inputs for the analysis event.", 0, java.lang.Integer.MAX_VALUE, input);
          case -1005512447: /*output*/  return new Property("output", "", "Outputs for the analysis event.", 0, java.lang.Integer.MAX_VALUE, output);
          case 481140686: /*performer*/  return new Property("performer", "", "Performer for the analysis event.", 0, java.lang.Integer.MAX_VALUE, performer);
          case -1335157162: /*device*/  return new Property("device", "", "Devices used for the analysis (e.g., instruments, software), with settings and parameters.", 0, java.lang.Integer.MAX_VALUE, device);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -722961477: /*methodType*/ return this.methodType == null ? new Base[0] : this.methodType.toArray(new Base[this.methodType.size()]); // CodeableConcept
        case -2131902710: /*changeType*/ return this.changeType == null ? new Base[0] : this.changeType.toArray(new Base[this.changeType.size()]); // CodeableConcept
        case 1061239735: /*genomeBuild*/ return this.genomeBuild == null ? new Base[0] : new Base[] {this.genomeBuild}; // CodeableConcept
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : new Base[] {this.instantiatesCanonical}; // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : new Base[] {this.instantiatesUri}; // UriType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -2132868344: /*specimen*/ return this.specimen == null ? new Base[0] : this.specimen.toArray(new Base[this.specimen.size()]); // Reference
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1565516792: /*protocolPerformed*/ return this.protocolPerformed == null ? new Base[0] : new Base[] {this.protocolPerformed}; // Reference
        case 391791385: /*regionsStudied*/ return this.regionsStudied == null ? new Base[0] : this.regionsStudied.toArray(new Base[this.regionsStudied.size()]); // Reference
        case -2125803428: /*regionsCalled*/ return this.regionsCalled == null ? new Base[0] : this.regionsCalled.toArray(new Base[this.regionsCalled.size()]); // Reference
        case 100358090: /*input*/ return this.input == null ? new Base[0] : this.input.toArray(new Base[this.input.size()]); // GenomicStudyAnalysisInputComponent
        case -1005512447: /*output*/ return this.output == null ? new Base[0] : this.output.toArray(new Base[this.output.size()]); // GenomicStudyAnalysisOutputComponent
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // GenomicStudyAnalysisPerformerComponent
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : this.device.toArray(new Base[this.device.size()]); // GenomicStudyAnalysisDeviceComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -722961477: // methodType
          this.getMethodType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -2131902710: // changeType
          this.getChangeType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1061239735: // genomeBuild
          this.genomeBuild = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 8911915: // instantiatesCanonical
          this.instantiatesCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.instantiatesUri = TypeConvertor.castToUri(value); // UriType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case -2132868344: // specimen
          this.getSpecimen().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1565516792: // protocolPerformed
          this.protocolPerformed = TypeConvertor.castToReference(value); // Reference
          return value;
        case 391791385: // regionsStudied
          this.getRegionsStudied().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -2125803428: // regionsCalled
          this.getRegionsCalled().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 100358090: // input
          this.getInput().add((GenomicStudyAnalysisInputComponent) value); // GenomicStudyAnalysisInputComponent
          return value;
        case -1005512447: // output
          this.getOutput().add((GenomicStudyAnalysisOutputComponent) value); // GenomicStudyAnalysisOutputComponent
          return value;
        case 481140686: // performer
          this.getPerformer().add((GenomicStudyAnalysisPerformerComponent) value); // GenomicStudyAnalysisPerformerComponent
          return value;
        case -1335157162: // device
          this.getDevice().add((GenomicStudyAnalysisDeviceComponent) value); // GenomicStudyAnalysisDeviceComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("methodType")) {
          this.getMethodType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("changeType")) {
          this.getChangeType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("genomeBuild")) {
          this.genomeBuild = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("instantiatesCanonical")) {
          this.instantiatesCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("instantiatesUri")) {
          this.instantiatesUri = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("specimen")) {
          this.getSpecimen().add(TypeConvertor.castToReference(value));
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("protocolPerformed")) {
          this.protocolPerformed = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("regionsStudied")) {
          this.getRegionsStudied().add(TypeConvertor.castToReference(value));
        } else if (name.equals("regionsCalled")) {
          this.getRegionsCalled().add(TypeConvertor.castToReference(value));
        } else if (name.equals("input")) {
          this.getInput().add((GenomicStudyAnalysisInputComponent) value);
        } else if (name.equals("output")) {
          this.getOutput().add((GenomicStudyAnalysisOutputComponent) value);
        } else if (name.equals("performer")) {
          this.getPerformer().add((GenomicStudyAnalysisPerformerComponent) value);
        } else if (name.equals("device")) {
          this.getDevice().add((GenomicStudyAnalysisDeviceComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -722961477:  return addMethodType(); 
        case -2131902710:  return addChangeType(); 
        case 1061239735:  return getGenomeBuild();
        case 8911915:  return getInstantiatesCanonicalElement();
        case -1926393373:  return getInstantiatesUriElement();
        case 110371416:  return getTitleElement();
        case -1867885268:  return getSubject();
        case -2132868344:  return addSpecimen(); 
        case 3076014:  return getDateElement();
        case 3387378:  return addNote(); 
        case -1565516792:  return getProtocolPerformed();
        case 391791385:  return addRegionsStudied(); 
        case -2125803428:  return addRegionsCalled(); 
        case 100358090:  return addInput(); 
        case -1005512447:  return addOutput(); 
        case 481140686:  return addPerformer(); 
        case -1335157162:  return addDevice(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -722961477: /*methodType*/ return new String[] {"CodeableConcept"};
        case -2131902710: /*changeType*/ return new String[] {"CodeableConcept"};
        case 1061239735: /*genomeBuild*/ return new String[] {"CodeableConcept"};
        case 8911915: /*instantiatesCanonical*/ return new String[] {"canonical"};
        case -1926393373: /*instantiatesUri*/ return new String[] {"uri"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -2132868344: /*specimen*/ return new String[] {"Reference"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1565516792: /*protocolPerformed*/ return new String[] {"Reference"};
        case 391791385: /*regionsStudied*/ return new String[] {"Reference"};
        case -2125803428: /*regionsCalled*/ return new String[] {"Reference"};
        case 100358090: /*input*/ return new String[] {};
        case -1005512447: /*output*/ return new String[] {};
        case 481140686: /*performer*/ return new String[] {};
        case -1335157162: /*device*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("methodType")) {
          return addMethodType();
        }
        else if (name.equals("changeType")) {
          return addChangeType();
        }
        else if (name.equals("genomeBuild")) {
          this.genomeBuild = new CodeableConcept();
          return this.genomeBuild;
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type GenomicStudy.analysis.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type GenomicStudy.analysis.instantiatesUri");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type GenomicStudy.analysis.title");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("specimen")) {
          return addSpecimen();
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type GenomicStudy.analysis.date");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("protocolPerformed")) {
          this.protocolPerformed = new Reference();
          return this.protocolPerformed;
        }
        else if (name.equals("regionsStudied")) {
          return addRegionsStudied();
        }
        else if (name.equals("regionsCalled")) {
          return addRegionsCalled();
        }
        else if (name.equals("input")) {
          return addInput();
        }
        else if (name.equals("output")) {
          return addOutput();
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("device")) {
          return addDevice();
        }
        else
          return super.addChild(name);
      }

      public GenomicStudyAnalysisComponent copy() {
        GenomicStudyAnalysisComponent dst = new GenomicStudyAnalysisComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GenomicStudyAnalysisComponent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (methodType != null) {
          dst.methodType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : methodType)
            dst.methodType.add(i.copy());
        };
        if (changeType != null) {
          dst.changeType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : changeType)
            dst.changeType.add(i.copy());
        };
        dst.genomeBuild = genomeBuild == null ? null : genomeBuild.copy();
        dst.instantiatesCanonical = instantiatesCanonical == null ? null : instantiatesCanonical.copy();
        dst.instantiatesUri = instantiatesUri == null ? null : instantiatesUri.copy();
        dst.title = title == null ? null : title.copy();
        dst.subject = subject == null ? null : subject.copy();
        if (specimen != null) {
          dst.specimen = new ArrayList<Reference>();
          for (Reference i : specimen)
            dst.specimen.add(i.copy());
        };
        dst.date = date == null ? null : date.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.protocolPerformed = protocolPerformed == null ? null : protocolPerformed.copy();
        if (regionsStudied != null) {
          dst.regionsStudied = new ArrayList<Reference>();
          for (Reference i : regionsStudied)
            dst.regionsStudied.add(i.copy());
        };
        if (regionsCalled != null) {
          dst.regionsCalled = new ArrayList<Reference>();
          for (Reference i : regionsCalled)
            dst.regionsCalled.add(i.copy());
        };
        if (input != null) {
          dst.input = new ArrayList<GenomicStudyAnalysisInputComponent>();
          for (GenomicStudyAnalysisInputComponent i : input)
            dst.input.add(i.copy());
        };
        if (output != null) {
          dst.output = new ArrayList<GenomicStudyAnalysisOutputComponent>();
          for (GenomicStudyAnalysisOutputComponent i : output)
            dst.output.add(i.copy());
        };
        if (performer != null) {
          dst.performer = new ArrayList<GenomicStudyAnalysisPerformerComponent>();
          for (GenomicStudyAnalysisPerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        if (device != null) {
          dst.device = new ArrayList<GenomicStudyAnalysisDeviceComponent>();
          for (GenomicStudyAnalysisDeviceComponent i : device)
            dst.device.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisComponent))
          return false;
        GenomicStudyAnalysisComponent o = (GenomicStudyAnalysisComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(methodType, o.methodType, true)
           && compareDeep(changeType, o.changeType, true) && compareDeep(genomeBuild, o.genomeBuild, true)
           && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true) && compareDeep(instantiatesUri, o.instantiatesUri, true)
           && compareDeep(title, o.title, true) && compareDeep(subject, o.subject, true) && compareDeep(specimen, o.specimen, true)
           && compareDeep(date, o.date, true) && compareDeep(note, o.note, true) && compareDeep(protocolPerformed, o.protocolPerformed, true)
           && compareDeep(regionsStudied, o.regionsStudied, true) && compareDeep(regionsCalled, o.regionsCalled, true)
           && compareDeep(input, o.input, true) && compareDeep(output, o.output, true) && compareDeep(performer, o.performer, true)
           && compareDeep(device, o.device, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisComponent))
          return false;
        GenomicStudyAnalysisComponent o = (GenomicStudyAnalysisComponent) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(title, o.title, true) && compareValues(date, o.date, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, methodType, changeType
          , genomeBuild, instantiatesCanonical, instantiatesUri, title, subject, specimen
          , date, note, protocolPerformed, regionsStudied, regionsCalled, input, output
          , performer, device);
      }

  public String fhirType() {
    return "GenomicStudy.analysis";

  }

  }

    @Block()
    public static class GenomicStudyAnalysisInputComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * File containing input data.
         */
        @Child(name = "file", type = {DocumentReference.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="File containing input data", formalDefinition="File containing input data." )
        protected Reference file;

        /**
         * Type of input data, e.g., BAM, CRAM, or FASTA.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of input data (e.g., BAM, CRAM, or FASTA)", formalDefinition="Type of input data, e.g., BAM, CRAM, or FASTA." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/genomicstudy-dataformat")
        protected CodeableConcept type;

        /**
         * The analysis event or other GenomicStudy that generated this input file.
         */
        @Child(name = "generatedBy", type = {Identifier.class, GenomicStudy.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The analysis event or other GenomicStudy that generated this input file", formalDefinition="The analysis event or other GenomicStudy that generated this input file." )
        protected DataType generatedBy;

        private static final long serialVersionUID = -650883036L;

    /**
     * Constructor
     */
      public GenomicStudyAnalysisInputComponent() {
        super();
      }

        /**
         * @return {@link #file} (File containing input data.)
         */
        public Reference getFile() { 
          if (this.file == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisInputComponent.file");
            else if (Configuration.doAutoCreate())
              this.file = new Reference(); // cc
          return this.file;
        }

        public boolean hasFile() { 
          return this.file != null && !this.file.isEmpty();
        }

        /**
         * @param value {@link #file} (File containing input data.)
         */
        public GenomicStudyAnalysisInputComponent setFile(Reference value) { 
          this.file = value;
          return this;
        }

        /**
         * @return {@link #type} (Type of input data, e.g., BAM, CRAM, or FASTA.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisInputComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Type of input data, e.g., BAM, CRAM, or FASTA.)
         */
        public GenomicStudyAnalysisInputComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #generatedBy} (The analysis event or other GenomicStudy that generated this input file.)
         */
        public DataType getGeneratedBy() { 
          return this.generatedBy;
        }

        /**
         * @return {@link #generatedBy} (The analysis event or other GenomicStudy that generated this input file.)
         */
        public Identifier getGeneratedByIdentifier() throws FHIRException { 
          if (this.generatedBy == null)
            this.generatedBy = new Identifier();
          if (!(this.generatedBy instanceof Identifier))
            throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.generatedBy.getClass().getName()+" was encountered");
          return (Identifier) this.generatedBy;
        }

        public boolean hasGeneratedByIdentifier() { 
          return this != null && this.generatedBy instanceof Identifier;
        }

        /**
         * @return {@link #generatedBy} (The analysis event or other GenomicStudy that generated this input file.)
         */
        public Reference getGeneratedByReference() throws FHIRException { 
          if (this.generatedBy == null)
            this.generatedBy = new Reference();
          if (!(this.generatedBy instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.generatedBy.getClass().getName()+" was encountered");
          return (Reference) this.generatedBy;
        }

        public boolean hasGeneratedByReference() { 
          return this != null && this.generatedBy instanceof Reference;
        }

        public boolean hasGeneratedBy() { 
          return this.generatedBy != null && !this.generatedBy.isEmpty();
        }

        /**
         * @param value {@link #generatedBy} (The analysis event or other GenomicStudy that generated this input file.)
         */
        public GenomicStudyAnalysisInputComponent setGeneratedBy(DataType value) { 
          if (value != null && !(value instanceof Identifier || value instanceof Reference))
            throw new Error("Not the right type for GenomicStudy.analysis.input.generatedBy[x]: "+value.fhirType());
          this.generatedBy = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("file", "Reference(DocumentReference)", "File containing input data.", 0, 1, file));
          children.add(new Property("type", "CodeableConcept", "Type of input data, e.g., BAM, CRAM, or FASTA.", 0, 1, type));
          children.add(new Property("generatedBy[x]", "Identifier|Reference(GenomicStudy)", "The analysis event or other GenomicStudy that generated this input file.", 0, 1, generatedBy));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3143036: /*file*/  return new Property("file", "Reference(DocumentReference)", "File containing input data.", 0, 1, file);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Type of input data, e.g., BAM, CRAM, or FASTA.", 0, 1, type);
          case -1669563270: /*generatedBy[x]*/  return new Property("generatedBy[x]", "Identifier|Reference(GenomicStudy)", "The analysis event or other GenomicStudy that generated this input file.", 0, 1, generatedBy);
          case 886733382: /*generatedBy*/  return new Property("generatedBy[x]", "Identifier|Reference(GenomicStudy)", "The analysis event or other GenomicStudy that generated this input file.", 0, 1, generatedBy);
          case 913138575: /*generatedByIdentifier*/  return new Property("generatedBy[x]", "Identifier", "The analysis event or other GenomicStudy that generated this input file.", 0, 1, generatedBy);
          case -1397681243: /*generatedByReference*/  return new Property("generatedBy[x]", "Reference(GenomicStudy)", "The analysis event or other GenomicStudy that generated this input file.", 0, 1, generatedBy);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3143036: /*file*/ return this.file == null ? new Base[0] : new Base[] {this.file}; // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 886733382: /*generatedBy*/ return this.generatedBy == null ? new Base[0] : new Base[] {this.generatedBy}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3143036: // file
          this.file = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 886733382: // generatedBy
          this.generatedBy = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("file")) {
          this.file = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("generatedBy[x]")) {
          this.generatedBy = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3143036:  return getFile();
        case 3575610:  return getType();
        case -1669563270:  return getGeneratedBy();
        case 886733382:  return getGeneratedBy();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3143036: /*file*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 886733382: /*generatedBy*/ return new String[] {"Identifier", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("file")) {
          this.file = new Reference();
          return this.file;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("generatedByIdentifier")) {
          this.generatedBy = new Identifier();
          return this.generatedBy;
        }
        else if (name.equals("generatedByReference")) {
          this.generatedBy = new Reference();
          return this.generatedBy;
        }
        else
          return super.addChild(name);
      }

      public GenomicStudyAnalysisInputComponent copy() {
        GenomicStudyAnalysisInputComponent dst = new GenomicStudyAnalysisInputComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GenomicStudyAnalysisInputComponent dst) {
        super.copyValues(dst);
        dst.file = file == null ? null : file.copy();
        dst.type = type == null ? null : type.copy();
        dst.generatedBy = generatedBy == null ? null : generatedBy.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisInputComponent))
          return false;
        GenomicStudyAnalysisInputComponent o = (GenomicStudyAnalysisInputComponent) other_;
        return compareDeep(file, o.file, true) && compareDeep(type, o.type, true) && compareDeep(generatedBy, o.generatedBy, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisInputComponent))
          return false;
        GenomicStudyAnalysisInputComponent o = (GenomicStudyAnalysisInputComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(file, type, generatedBy
          );
      }

  public String fhirType() {
    return "GenomicStudy.analysis.input";

  }

  }

    @Block()
    public static class GenomicStudyAnalysisOutputComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * File containing output data.
         */
        @Child(name = "file", type = {DocumentReference.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="File containing output data", formalDefinition="File containing output data." )
        protected Reference file;

        /**
         * Type of output data, e.g., VCF, MAF, or BAM.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of output data (e.g., VCF, MAF, or BAM)", formalDefinition="Type of output data, e.g., VCF, MAF, or BAM." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/genomicstudy-dataformat")
        protected CodeableConcept type;

        private static final long serialVersionUID = -2075265800L;

    /**
     * Constructor
     */
      public GenomicStudyAnalysisOutputComponent() {
        super();
      }

        /**
         * @return {@link #file} (File containing output data.)
         */
        public Reference getFile() { 
          if (this.file == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisOutputComponent.file");
            else if (Configuration.doAutoCreate())
              this.file = new Reference(); // cc
          return this.file;
        }

        public boolean hasFile() { 
          return this.file != null && !this.file.isEmpty();
        }

        /**
         * @param value {@link #file} (File containing output data.)
         */
        public GenomicStudyAnalysisOutputComponent setFile(Reference value) { 
          this.file = value;
          return this;
        }

        /**
         * @return {@link #type} (Type of output data, e.g., VCF, MAF, or BAM.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisOutputComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Type of output data, e.g., VCF, MAF, or BAM.)
         */
        public GenomicStudyAnalysisOutputComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("file", "Reference(DocumentReference)", "File containing output data.", 0, 1, file));
          children.add(new Property("type", "CodeableConcept", "Type of output data, e.g., VCF, MAF, or BAM.", 0, 1, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3143036: /*file*/  return new Property("file", "Reference(DocumentReference)", "File containing output data.", 0, 1, file);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Type of output data, e.g., VCF, MAF, or BAM.", 0, 1, type);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3143036: /*file*/ return this.file == null ? new Base[0] : new Base[] {this.file}; // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3143036: // file
          this.file = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("file")) {
          this.file = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3143036:  return getFile();
        case 3575610:  return getType();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3143036: /*file*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("file")) {
          this.file = new Reference();
          return this.file;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else
          return super.addChild(name);
      }

      public GenomicStudyAnalysisOutputComponent copy() {
        GenomicStudyAnalysisOutputComponent dst = new GenomicStudyAnalysisOutputComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GenomicStudyAnalysisOutputComponent dst) {
        super.copyValues(dst);
        dst.file = file == null ? null : file.copy();
        dst.type = type == null ? null : type.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisOutputComponent))
          return false;
        GenomicStudyAnalysisOutputComponent o = (GenomicStudyAnalysisOutputComponent) other_;
        return compareDeep(file, o.file, true) && compareDeep(type, o.type, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisOutputComponent))
          return false;
        GenomicStudyAnalysisOutputComponent o = (GenomicStudyAnalysisOutputComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(file, type);
      }

  public String fhirType() {
    return "GenomicStudy.analysis.output";

  }

  }

    @Block()
    public static class GenomicStudyAnalysisPerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The organization, healthcare professional, or others who participated in performing this analysis.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, Device.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The organization, healthcare professional, or others who participated in performing this analysis", formalDefinition="The organization, healthcare professional, or others who participated in performing this analysis." )
        protected Reference actor;

        /**
         * Role of the actor for this analysis.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Role of the actor for this analysis", formalDefinition="Role of the actor for this analysis." )
        protected CodeableConcept role;

        private static final long serialVersionUID = 827444743L;

    /**
     * Constructor
     */
      public GenomicStudyAnalysisPerformerComponent() {
        super();
      }

        /**
         * @return {@link #actor} (The organization, healthcare professional, or others who participated in performing this analysis.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisPerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (The organization, healthcare professional, or others who participated in performing this analysis.)
         */
        public GenomicStudyAnalysisPerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        /**
         * @return {@link #role} (Role of the actor for this analysis.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisPerformerComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Role of the actor for this analysis.)
         */
        public GenomicStudyAnalysisPerformerComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|Device)", "The organization, healthcare professional, or others who participated in performing this analysis.", 0, 1, actor));
          children.add(new Property("role", "CodeableConcept", "Role of the actor for this analysis.", 0, 1, role));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|Device)", "The organization, healthcare professional, or others who participated in performing this analysis.", 0, 1, actor);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Role of the actor for this analysis.", 0, 1, role);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 92645877:  return getActor();
        case 3506294:  return getRole();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 92645877: /*actor*/ return new String[] {"Reference"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else
          return super.addChild(name);
      }

      public GenomicStudyAnalysisPerformerComponent copy() {
        GenomicStudyAnalysisPerformerComponent dst = new GenomicStudyAnalysisPerformerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GenomicStudyAnalysisPerformerComponent dst) {
        super.copyValues(dst);
        dst.actor = actor == null ? null : actor.copy();
        dst.role = role == null ? null : role.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisPerformerComponent))
          return false;
        GenomicStudyAnalysisPerformerComponent o = (GenomicStudyAnalysisPerformerComponent) other_;
        return compareDeep(actor, o.actor, true) && compareDeep(role, o.role, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisPerformerComponent))
          return false;
        GenomicStudyAnalysisPerformerComponent o = (GenomicStudyAnalysisPerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(actor, role);
      }

  public String fhirType() {
    return "GenomicStudy.analysis.performer";

  }

  }

    @Block()
    public static class GenomicStudyAnalysisDeviceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Device used for the analysis.
         */
        @Child(name = "device", type = {Device.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Device used for the analysis", formalDefinition="Device used for the analysis." )
        protected Reference device;

        /**
         * Specific function for the device used for the analysis.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specific function for the device used for the analysis", formalDefinition="Specific function for the device used for the analysis." )
        protected CodeableConcept function;

        private static final long serialVersionUID = 1643933108L;

    /**
     * Constructor
     */
      public GenomicStudyAnalysisDeviceComponent() {
        super();
      }

        /**
         * @return {@link #device} (Device used for the analysis.)
         */
        public Reference getDevice() { 
          if (this.device == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisDeviceComponent.device");
            else if (Configuration.doAutoCreate())
              this.device = new Reference(); // cc
          return this.device;
        }

        public boolean hasDevice() { 
          return this.device != null && !this.device.isEmpty();
        }

        /**
         * @param value {@link #device} (Device used for the analysis.)
         */
        public GenomicStudyAnalysisDeviceComponent setDevice(Reference value) { 
          this.device = value;
          return this;
        }

        /**
         * @return {@link #function} (Specific function for the device used for the analysis.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GenomicStudyAnalysisDeviceComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Specific function for the device used for the analysis.)
         */
        public GenomicStudyAnalysisDeviceComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("device", "Reference(Device)", "Device used for the analysis.", 0, 1, device));
          children.add(new Property("function", "CodeableConcept", "Specific function for the device used for the analysis.", 0, 1, function));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1335157162: /*device*/  return new Property("device", "Reference(Device)", "Device used for the analysis.", 0, 1, device);
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Specific function for the device used for the analysis.", 0, 1, function);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1380938712: // function
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1335157162:  return getDevice();
        case 1380938712:  return getFunction();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("function")) {
          this.function = new CodeableConcept();
          return this.function;
        }
        else
          return super.addChild(name);
      }

      public GenomicStudyAnalysisDeviceComponent copy() {
        GenomicStudyAnalysisDeviceComponent dst = new GenomicStudyAnalysisDeviceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GenomicStudyAnalysisDeviceComponent dst) {
        super.copyValues(dst);
        dst.device = device == null ? null : device.copy();
        dst.function = function == null ? null : function.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisDeviceComponent))
          return false;
        GenomicStudyAnalysisDeviceComponent o = (GenomicStudyAnalysisDeviceComponent) other_;
        return compareDeep(device, o.device, true) && compareDeep(function, o.function, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GenomicStudyAnalysisDeviceComponent))
          return false;
        GenomicStudyAnalysisDeviceComponent o = (GenomicStudyAnalysisDeviceComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(device, function);
      }

  public String fhirType() {
    return "GenomicStudy.analysis.device";

  }

  }

    /**
     * Identifiers for this genomic study.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Identifiers for this genomic study", formalDefinition="Identifiers for this genomic study." )
    protected List<Identifier> identifier;

    /**
     * The status of the genomic study.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="The status of the genomic study", formalDefinition="The status of the genomic study." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/genomicstudy-status")
    protected CodeableConcept status;

    /**
     * The type of the study, e.g., Familial variant segregation, Functional variation detection, or Gene expression profiling.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The type of the study (e.g., Familial variant segregation, Functional variation detection, or Gene expression profiling)", formalDefinition="The type of the study, e.g., Familial variant segregation, Functional variation detection, or Gene expression profiling." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/genomicstudy-type")
    protected List<CodeableConcept> type;

    /**
     * The primary subject of the genomic study.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Device.class, Location.class, Organization.class, Procedure.class, Practitioner.class, Medication.class, Substance.class, BiologicallyDerivedProduct.class, NutritionProduct.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The primary subject of the genomic study", formalDefinition="The primary subject of the genomic study." )
    protected Reference subject;

    /**
     * The healthcare event with which this genomics study is associated.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The healthcare event with which this genomics study is associated", formalDefinition="The healthcare event with which this genomics study is associated." )
    protected Reference encounter;

    /**
     * When the genomic study was started.
     */
    @Child(name = "startDate", type = {DateTimeType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the genomic study was started", formalDefinition="When the genomic study was started." )
    protected DateTimeType startDate;

    /**
     * Event resources that the genomic study is based on.
     */
    @Child(name = "basedOn", type = {ServiceRequest.class, Task.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Event resources that the genomic study is based on", formalDefinition="Event resources that the genomic study is based on." )
    protected List<Reference> basedOn;

    /**
     * Healthcare professional who requested or referred the genomic study.
     */
    @Child(name = "referrer", type = {Practitioner.class, PractitionerRole.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Healthcare professional who requested or referred the genomic study", formalDefinition="Healthcare professional who requested or referred the genomic study." )
    protected Reference referrer;

    /**
     * Healthcare professionals who interpreted the genomic study.
     */
    @Child(name = "interpreter", type = {Practitioner.class, PractitionerRole.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Healthcare professionals who interpreted the genomic study", formalDefinition="Healthcare professionals who interpreted the genomic study." )
    protected List<Reference> interpreter;

    /**
     * Why the genomic study was performed.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Why the genomic study was performed", formalDefinition="Why the genomic study was performed." )
    protected List<CodeableReference> reason;

    /**
     * The defined protocol that describes the study.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The defined protocol that describes the study", formalDefinition="The defined protocol that describes the study." )
    protected CanonicalType instantiatesCanonical;

    /**
     * The URL pointing to an externally maintained protocol that describes the study.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The URL pointing to an externally maintained protocol that describes the study", formalDefinition="The URL pointing to an externally maintained protocol that describes the study." )
    protected UriType instantiatesUri;

    /**
     * Comments related to the genomic study.
     */
    @Child(name = "note", type = {Annotation.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments related to the genomic study", formalDefinition="Comments related to the genomic study." )
    protected List<Annotation> note;

    /**
     * Description of the genomic study.
     */
    @Child(name = "description", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of the genomic study", formalDefinition="Description of the genomic study." )
    protected StringType description;

    /**
     * The details about a specific analysis that was performed in this GenomicStudy.
     */
    @Child(name = "analysis", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Genomic Analysis Event", formalDefinition="The details about a specific analysis that was performed in this GenomicStudy." )
    protected List<GenomicStudyAnalysisComponent> analysis;

    private static final long serialVersionUID = -345111606L;

  /**
   * Constructor
   */
    public GenomicStudy() {
      super();
    }

  /**
   * Constructor
   */
    public GenomicStudy(CodeableConcept status, Reference subject) {
      super();
      this.setStatus(status);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Identifiers for this genomic study.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GenomicStudy setIdentifier(List<Identifier> theIdentifier) { 
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

    public GenomicStudy addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The status of the genomic study.)
     */
    public CodeableConcept getStatus() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GenomicStudy.status");
        else if (Configuration.doAutoCreate())
          this.status = new CodeableConcept(); // cc
      return this.status;
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the genomic study.)
     */
    public GenomicStudy setStatus(CodeableConcept value) { 
      this.status = value;
      return this;
    }

    /**
     * @return {@link #type} (The type of the study, e.g., Familial variant segregation, Functional variation detection, or Gene expression profiling.)
     */
    public List<CodeableConcept> getType() { 
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GenomicStudy setType(List<CodeableConcept> theType) { 
      this.type = theType;
      return this;
    }

    public boolean hasType() { 
      if (this.type == null)
        return false;
      for (CodeableConcept item : this.type)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return t;
    }

    public GenomicStudy addType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTypeFirstRep() { 
      if (getType().isEmpty()) {
        addType();
      }
      return getType().get(0);
    }

    /**
     * @return {@link #subject} (The primary subject of the genomic study.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GenomicStudy.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The primary subject of the genomic study.)
     */
    public GenomicStudy setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The healthcare event with which this genomics study is associated.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GenomicStudy.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The healthcare event with which this genomics study is associated.)
     */
    public GenomicStudy setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #startDate} (When the genomic study was started.). This is the underlying object with id, value and extensions. The accessor "getStartDate" gives direct access to the value
     */
    public DateTimeType getStartDateElement() { 
      if (this.startDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GenomicStudy.startDate");
        else if (Configuration.doAutoCreate())
          this.startDate = new DateTimeType(); // bb
      return this.startDate;
    }

    public boolean hasStartDateElement() { 
      return this.startDate != null && !this.startDate.isEmpty();
    }

    public boolean hasStartDate() { 
      return this.startDate != null && !this.startDate.isEmpty();
    }

    /**
     * @param value {@link #startDate} (When the genomic study was started.). This is the underlying object with id, value and extensions. The accessor "getStartDate" gives direct access to the value
     */
    public GenomicStudy setStartDateElement(DateTimeType value) { 
      this.startDate = value;
      return this;
    }

    /**
     * @return When the genomic study was started.
     */
    public Date getStartDate() { 
      return this.startDate == null ? null : this.startDate.getValue();
    }

    /**
     * @param value When the genomic study was started.
     */
    public GenomicStudy setStartDate(Date value) { 
      if (value == null)
        this.startDate = null;
      else {
        if (this.startDate == null)
          this.startDate = new DateTimeType();
        this.startDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #basedOn} (Event resources that the genomic study is based on.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GenomicStudy setBasedOn(List<Reference> theBasedOn) { 
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

    public GenomicStudy addBasedOn(Reference t) { //3
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
     * @return {@link #referrer} (Healthcare professional who requested or referred the genomic study.)
     */
    public Reference getReferrer() { 
      if (this.referrer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GenomicStudy.referrer");
        else if (Configuration.doAutoCreate())
          this.referrer = new Reference(); // cc
      return this.referrer;
    }

    public boolean hasReferrer() { 
      return this.referrer != null && !this.referrer.isEmpty();
    }

    /**
     * @param value {@link #referrer} (Healthcare professional who requested or referred the genomic study.)
     */
    public GenomicStudy setReferrer(Reference value) { 
      this.referrer = value;
      return this;
    }

    /**
     * @return {@link #interpreter} (Healthcare professionals who interpreted the genomic study.)
     */
    public List<Reference> getInterpreter() { 
      if (this.interpreter == null)
        this.interpreter = new ArrayList<Reference>();
      return this.interpreter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GenomicStudy setInterpreter(List<Reference> theInterpreter) { 
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

    public GenomicStudy addInterpreter(Reference t) { //3
      if (t == null)
        return this;
      if (this.interpreter == null)
        this.interpreter = new ArrayList<Reference>();
      this.interpreter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #interpreter}, creating it if it does not already exist {3}
     */
    public Reference getInterpreterFirstRep() { 
      if (getInterpreter().isEmpty()) {
        addInterpreter();
      }
      return getInterpreter().get(0);
    }

    /**
     * @return {@link #reason} (Why the genomic study was performed.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GenomicStudy setReason(List<CodeableReference> theReason) { 
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

    public GenomicStudy addReason(CodeableReference t) { //3
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
     * @return {@link #instantiatesCanonical} (The defined protocol that describes the study.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesCanonical" gives direct access to the value
     */
    public CanonicalType getInstantiatesCanonicalElement() { 
      if (this.instantiatesCanonical == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GenomicStudy.instantiatesCanonical");
        else if (Configuration.doAutoCreate())
          this.instantiatesCanonical = new CanonicalType(); // bb
      return this.instantiatesCanonical;
    }

    public boolean hasInstantiatesCanonicalElement() { 
      return this.instantiatesCanonical != null && !this.instantiatesCanonical.isEmpty();
    }

    public boolean hasInstantiatesCanonical() { 
      return this.instantiatesCanonical != null && !this.instantiatesCanonical.isEmpty();
    }

    /**
     * @param value {@link #instantiatesCanonical} (The defined protocol that describes the study.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesCanonical" gives direct access to the value
     */
    public GenomicStudy setInstantiatesCanonicalElement(CanonicalType value) { 
      this.instantiatesCanonical = value;
      return this;
    }

    /**
     * @return The defined protocol that describes the study.
     */
    public String getInstantiatesCanonical() { 
      return this.instantiatesCanonical == null ? null : this.instantiatesCanonical.getValue();
    }

    /**
     * @param value The defined protocol that describes the study.
     */
    public GenomicStudy setInstantiatesCanonical(String value) { 
      if (Utilities.noString(value))
        this.instantiatesCanonical = null;
      else {
        if (this.instantiatesCanonical == null)
          this.instantiatesCanonical = new CanonicalType();
        this.instantiatesCanonical.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol that describes the study.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesUri" gives direct access to the value
     */
    public UriType getInstantiatesUriElement() { 
      if (this.instantiatesUri == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GenomicStudy.instantiatesUri");
        else if (Configuration.doAutoCreate())
          this.instantiatesUri = new UriType(); // bb
      return this.instantiatesUri;
    }

    public boolean hasInstantiatesUriElement() { 
      return this.instantiatesUri != null && !this.instantiatesUri.isEmpty();
    }

    public boolean hasInstantiatesUri() { 
      return this.instantiatesUri != null && !this.instantiatesUri.isEmpty();
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol that describes the study.). This is the underlying object with id, value and extensions. The accessor "getInstantiatesUri" gives direct access to the value
     */
    public GenomicStudy setInstantiatesUriElement(UriType value) { 
      this.instantiatesUri = value;
      return this;
    }

    /**
     * @return The URL pointing to an externally maintained protocol that describes the study.
     */
    public String getInstantiatesUri() { 
      return this.instantiatesUri == null ? null : this.instantiatesUri.getValue();
    }

    /**
     * @param value The URL pointing to an externally maintained protocol that describes the study.
     */
    public GenomicStudy setInstantiatesUri(String value) { 
      if (Utilities.noString(value))
        this.instantiatesUri = null;
      else {
        if (this.instantiatesUri == null)
          this.instantiatesUri = new UriType();
        this.instantiatesUri.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #note} (Comments related to the genomic study.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GenomicStudy setNote(List<Annotation> theNote) { 
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

    public GenomicStudy addNote(Annotation t) { //3
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
     * @return {@link #description} (Description of the genomic study.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GenomicStudy.description");
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
     * @param value {@link #description} (Description of the genomic study.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public GenomicStudy setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Description of the genomic study.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Description of the genomic study.
     */
    public GenomicStudy setDescription(String value) { 
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
     * @return {@link #analysis} (The details about a specific analysis that was performed in this GenomicStudy.)
     */
    public List<GenomicStudyAnalysisComponent> getAnalysis() { 
      if (this.analysis == null)
        this.analysis = new ArrayList<GenomicStudyAnalysisComponent>();
      return this.analysis;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GenomicStudy setAnalysis(List<GenomicStudyAnalysisComponent> theAnalysis) { 
      this.analysis = theAnalysis;
      return this;
    }

    public boolean hasAnalysis() { 
      if (this.analysis == null)
        return false;
      for (GenomicStudyAnalysisComponent item : this.analysis)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public GenomicStudyAnalysisComponent addAnalysis() { //3
      GenomicStudyAnalysisComponent t = new GenomicStudyAnalysisComponent();
      if (this.analysis == null)
        this.analysis = new ArrayList<GenomicStudyAnalysisComponent>();
      this.analysis.add(t);
      return t;
    }

    public GenomicStudy addAnalysis(GenomicStudyAnalysisComponent t) { //3
      if (t == null)
        return this;
      if (this.analysis == null)
        this.analysis = new ArrayList<GenomicStudyAnalysisComponent>();
      this.analysis.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #analysis}, creating it if it does not already exist {3}
     */
    public GenomicStudyAnalysisComponent getAnalysisFirstRep() { 
      if (getAnalysis().isEmpty()) {
        addAnalysis();
      }
      return getAnalysis().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers for this genomic study.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "CodeableConcept", "The status of the genomic study.", 0, 1, status));
        children.add(new Property("type", "CodeableConcept", "The type of the study, e.g., Familial variant segregation, Functional variation detection, or Gene expression profiling.", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct|NutritionProduct)", "The primary subject of the genomic study.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The healthcare event with which this genomics study is associated.", 0, 1, encounter));
        children.add(new Property("startDate", "dateTime", "When the genomic study was started.", 0, 1, startDate));
        children.add(new Property("basedOn", "Reference(ServiceRequest|Task)", "Event resources that the genomic study is based on.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("referrer", "Reference(Practitioner|PractitionerRole)", "Healthcare professional who requested or referred the genomic study.", 0, 1, referrer));
        children.add(new Property("interpreter", "Reference(Practitioner|PractitionerRole)", "Healthcare professionals who interpreted the genomic study.", 0, java.lang.Integer.MAX_VALUE, interpreter));
        children.add(new Property("reason", "CodeableReference(Condition|Observation)", "Why the genomic study was performed.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("instantiatesCanonical", "canonical(PlanDefinition)", "The defined protocol that describes the study.", 0, 1, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol that describes the study.", 0, 1, instantiatesUri));
        children.add(new Property("note", "Annotation", "Comments related to the genomic study.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("description", "string", "Description of the genomic study.", 0, 1, description));
        children.add(new Property("analysis", "", "The details about a specific analysis that was performed in this GenomicStudy.", 0, java.lang.Integer.MAX_VALUE, analysis));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers for this genomic study.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status of the genomic study.", 0, 1, status);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of the study, e.g., Familial variant segregation, Functional variation detection, or Gene expression profiling.", 0, java.lang.Integer.MAX_VALUE, type);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct|NutritionProduct)", "The primary subject of the genomic study.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The healthcare event with which this genomics study is associated.", 0, 1, encounter);
        case -2129778896: /*startDate*/  return new Property("startDate", "dateTime", "When the genomic study was started.", 0, 1, startDate);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(ServiceRequest|Task)", "Event resources that the genomic study is based on.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -722568161: /*referrer*/  return new Property("referrer", "Reference(Practitioner|PractitionerRole)", "Healthcare professional who requested or referred the genomic study.", 0, 1, referrer);
        case -2008009094: /*interpreter*/  return new Property("interpreter", "Reference(Practitioner|PractitionerRole)", "Healthcare professionals who interpreted the genomic study.", 0, java.lang.Integer.MAX_VALUE, interpreter);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation)", "Why the genomic study was performed.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(PlanDefinition)", "The defined protocol that describes the study.", 0, 1, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol that describes the study.", 0, 1, instantiatesUri);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Comments related to the genomic study.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1724546052: /*description*/  return new Property("description", "string", "Description of the genomic study.", 0, 1, description);
        case -1024445732: /*analysis*/  return new Property("analysis", "", "The details about a specific analysis that was performed in this GenomicStudy.", 0, java.lang.Integer.MAX_VALUE, analysis);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -2129778896: /*startDate*/ return this.startDate == null ? new Base[0] : new Base[] {this.startDate}; // DateTimeType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -722568161: /*referrer*/ return this.referrer == null ? new Base[0] : new Base[] {this.referrer}; // Reference
        case -2008009094: /*interpreter*/ return this.interpreter == null ? new Base[0] : this.interpreter.toArray(new Base[this.interpreter.size()]); // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : new Base[] {this.instantiatesCanonical}; // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : new Base[] {this.instantiatesUri}; // UriType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1024445732: /*analysis*/ return this.analysis == null ? new Base[0] : this.analysis.toArray(new Base[this.analysis.size()]); // GenomicStudyAnalysisComponent
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
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -2129778896: // startDate
          this.startDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -722568161: // referrer
          this.referrer = TypeConvertor.castToReference(value); // Reference
          return value;
        case -2008009094: // interpreter
          this.getInterpreter().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 8911915: // instantiatesCanonical
          this.instantiatesCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.instantiatesUri = TypeConvertor.castToUri(value); // UriType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1024445732: // analysis
          this.getAnalysis().add((GenomicStudyAnalysisComponent) value); // GenomicStudyAnalysisComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("startDate")) {
          this.startDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("referrer")) {
          this.referrer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("interpreter")) {
          this.getInterpreter().add(TypeConvertor.castToReference(value));
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("instantiatesCanonical")) {
          this.instantiatesCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("instantiatesUri")) {
          this.instantiatesUri = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("analysis")) {
          this.getAnalysis().add((GenomicStudyAnalysisComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatus();
        case 3575610:  return addType(); 
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -2129778896:  return getStartDateElement();
        case -332612366:  return addBasedOn(); 
        case -722568161:  return getReferrer();
        case -2008009094:  return addInterpreter(); 
        case -934964668:  return addReason(); 
        case 8911915:  return getInstantiatesCanonicalElement();
        case -1926393373:  return getInstantiatesUriElement();
        case 3387378:  return addNote(); 
        case -1724546052:  return getDescriptionElement();
        case -1024445732:  return addAnalysis(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -2129778896: /*startDate*/ return new String[] {"dateTime"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -722568161: /*referrer*/ return new String[] {"Reference"};
        case -2008009094: /*interpreter*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 8911915: /*instantiatesCanonical*/ return new String[] {"canonical"};
        case -1926393373: /*instantiatesUri*/ return new String[] {"uri"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1024445732: /*analysis*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("startDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type GenomicStudy.startDate");
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
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type GenomicStudy.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type GenomicStudy.instantiatesUri");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type GenomicStudy.description");
        }
        else if (name.equals("analysis")) {
          return addAnalysis();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "GenomicStudy";

  }

      public GenomicStudy copy() {
        GenomicStudy dst = new GenomicStudy();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GenomicStudy dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.startDate = startDate == null ? null : startDate.copy();
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
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        dst.instantiatesCanonical = instantiatesCanonical == null ? null : instantiatesCanonical.copy();
        dst.instantiatesUri = instantiatesUri == null ? null : instantiatesUri.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (analysis != null) {
          dst.analysis = new ArrayList<GenomicStudyAnalysisComponent>();
          for (GenomicStudyAnalysisComponent i : analysis)
            dst.analysis.add(i.copy());
        };
      }

      protected GenomicStudy typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GenomicStudy))
          return false;
        GenomicStudy o = (GenomicStudy) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(type, o.type, true)
           && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true) && compareDeep(startDate, o.startDate, true)
           && compareDeep(basedOn, o.basedOn, true) && compareDeep(referrer, o.referrer, true) && compareDeep(interpreter, o.interpreter, true)
           && compareDeep(reason, o.reason, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(note, o.note, true) && compareDeep(description, o.description, true)
           && compareDeep(analysis, o.analysis, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GenomicStudy))
          return false;
        GenomicStudy o = (GenomicStudy) other_;
        return compareValues(startDate, o.startDate, true) && compareValues(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareValues(instantiatesUri, o.instantiatesUri, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, type
          , subject, encounter, startDate, basedOn, referrer, interpreter, reason, instantiatesCanonical
          , instantiatesUri, note, description, analysis);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.GenomicStudy;
   }

 /**
   * Search parameter: <b>analysis-patient</b>
   * <p>
   * Description: <b>Who the analysis is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>GenomicStudy.analysis.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="analysis-patient", path="GenomicStudy.analysis.subject.where(resolve() is Patient)", description="Who the analysis is about", type="reference", target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_ANALYSIS_PATIENT = "analysis-patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>analysis-patient</b>
   * <p>
   * Description: <b>Who the analysis is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>GenomicStudy.analysis.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ANALYSIS_PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ANALYSIS_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>GenomicStudy:analysis-patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ANALYSIS_PATIENT = new ca.uhn.fhir.model.api.Include("GenomicStudy:analysis-patient").toLocked();

 /**
   * Search parameter: <b>analysis-subject</b>
   * <p>
   * Description: <b>Who the analysis is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>GenomicStudy.analysis.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="analysis-subject", path="GenomicStudy.analysis.subject", description="Who the analysis is about", type="reference", target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_ANALYSIS_SUBJECT = "analysis-subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>analysis-subject</b>
   * <p>
   * Description: <b>Who the analysis is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>GenomicStudy.analysis.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ANALYSIS_SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ANALYSIS_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>GenomicStudy:analysis-subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ANALYSIS_SUBJECT = new ca.uhn.fhir.model.api.Include("GenomicStudy:analysis-subject").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Identifiers for the Study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>GenomicStudy.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="GenomicStudy.identifier", description="Identifiers for the Study", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Identifiers for the Study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>GenomicStudy.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>GenomicStudy.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="GenomicStudy.subject.where(resolve() is Patient)", description="Who the study is about", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>GenomicStudy.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>GenomicStudy:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("GenomicStudy:patient").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>GenomicStudy.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="GenomicStudy.status", description="The status of the study", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>GenomicStudy.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>GenomicStudy.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="GenomicStudy.subject", description="Who the study is about", type="reference", target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Who the study is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>GenomicStudy.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>GenomicStudy:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("GenomicStudy:subject").toLocked();


}

