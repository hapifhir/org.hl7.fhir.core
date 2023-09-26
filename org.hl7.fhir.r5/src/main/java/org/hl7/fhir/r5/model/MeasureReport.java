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
 * The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.
 */
@ResourceDef(name="MeasureReport", profile="http://hl7.org/fhir/StructureDefinition/MeasureReport")
public class MeasureReport extends DomainResource {

    public enum MeasureReportStatus {
        /**
         * The report is complete and ready for use.
         */
        COMPLETE, 
        /**
         * The report is currently being generated.
         */
        PENDING, 
        /**
         * An error occurred attempting to generate the report.
         */
        ERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MeasureReportStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("complete".equals(codeString))
          return COMPLETE;
        if ("pending".equals(codeString))
          return PENDING;
        if ("error".equals(codeString))
          return ERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown MeasureReportStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case COMPLETE: return "complete";
            case PENDING: return "pending";
            case ERROR: return "error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case COMPLETE: return "http://hl7.org/fhir/measure-report-status";
            case PENDING: return "http://hl7.org/fhir/measure-report-status";
            case ERROR: return "http://hl7.org/fhir/measure-report-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case COMPLETE: return "The report is complete and ready for use.";
            case PENDING: return "The report is currently being generated.";
            case ERROR: return "An error occurred attempting to generate the report.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case COMPLETE: return "Complete";
            case PENDING: return "Pending";
            case ERROR: return "Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class MeasureReportStatusEnumFactory implements EnumFactory<MeasureReportStatus> {
    public MeasureReportStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("complete".equals(codeString))
          return MeasureReportStatus.COMPLETE;
        if ("pending".equals(codeString))
          return MeasureReportStatus.PENDING;
        if ("error".equals(codeString))
          return MeasureReportStatus.ERROR;
        throw new IllegalArgumentException("Unknown MeasureReportStatus code '"+codeString+"'");
        }
        public Enumeration<MeasureReportStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MeasureReportStatus>(this, MeasureReportStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<MeasureReportStatus>(this, MeasureReportStatus.NULL, code);
        if ("complete".equals(codeString))
          return new Enumeration<MeasureReportStatus>(this, MeasureReportStatus.COMPLETE, code);
        if ("pending".equals(codeString))
          return new Enumeration<MeasureReportStatus>(this, MeasureReportStatus.PENDING, code);
        if ("error".equals(codeString))
          return new Enumeration<MeasureReportStatus>(this, MeasureReportStatus.ERROR, code);
        throw new FHIRException("Unknown MeasureReportStatus code '"+codeString+"'");
        }
    public String toCode(MeasureReportStatus code) {
      if (code == MeasureReportStatus.COMPLETE)
        return "complete";
      if (code == MeasureReportStatus.PENDING)
        return "pending";
      if (code == MeasureReportStatus.ERROR)
        return "error";
      return "?";
      }
    public String toSystem(MeasureReportStatus code) {
      return code.getSystem();
      }
    }

    public enum MeasureReportType {
        /**
         * An individual report that provides information on the performance for a given measure with respect to a single subject.
         */
        INDIVIDUAL, 
        /**
         * A subject list report that includes a listing of subjects that satisfied each population criteria in the measure.
         */
        SUBJECTLIST, 
        /**
         * A summary report that returns the number of members in each population criteria for the measure.
         */
        SUMMARY, 
        /**
         * A data exchange report that contains data-of-interest for the measure (i.e. data that is needed to calculate the measure)
         */
        DATAEXCHANGE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MeasureReportType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("individual".equals(codeString))
          return INDIVIDUAL;
        if ("subject-list".equals(codeString))
          return SUBJECTLIST;
        if ("summary".equals(codeString))
          return SUMMARY;
        if ("data-exchange".equals(codeString))
          return DATAEXCHANGE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown MeasureReportType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INDIVIDUAL: return "individual";
            case SUBJECTLIST: return "subject-list";
            case SUMMARY: return "summary";
            case DATAEXCHANGE: return "data-exchange";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INDIVIDUAL: return "http://hl7.org/fhir/measure-report-type";
            case SUBJECTLIST: return "http://hl7.org/fhir/measure-report-type";
            case SUMMARY: return "http://hl7.org/fhir/measure-report-type";
            case DATAEXCHANGE: return "http://hl7.org/fhir/measure-report-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INDIVIDUAL: return "An individual report that provides information on the performance for a given measure with respect to a single subject.";
            case SUBJECTLIST: return "A subject list report that includes a listing of subjects that satisfied each population criteria in the measure.";
            case SUMMARY: return "A summary report that returns the number of members in each population criteria for the measure.";
            case DATAEXCHANGE: return "A data exchange report that contains data-of-interest for the measure (i.e. data that is needed to calculate the measure)";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INDIVIDUAL: return "Individual";
            case SUBJECTLIST: return "Subject List";
            case SUMMARY: return "Summary";
            case DATAEXCHANGE: return "Data Exchange";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class MeasureReportTypeEnumFactory implements EnumFactory<MeasureReportType> {
    public MeasureReportType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("individual".equals(codeString))
          return MeasureReportType.INDIVIDUAL;
        if ("subject-list".equals(codeString))
          return MeasureReportType.SUBJECTLIST;
        if ("summary".equals(codeString))
          return MeasureReportType.SUMMARY;
        if ("data-exchange".equals(codeString))
          return MeasureReportType.DATAEXCHANGE;
        throw new IllegalArgumentException("Unknown MeasureReportType code '"+codeString+"'");
        }
        public Enumeration<MeasureReportType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MeasureReportType>(this, MeasureReportType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<MeasureReportType>(this, MeasureReportType.NULL, code);
        if ("individual".equals(codeString))
          return new Enumeration<MeasureReportType>(this, MeasureReportType.INDIVIDUAL, code);
        if ("subject-list".equals(codeString))
          return new Enumeration<MeasureReportType>(this, MeasureReportType.SUBJECTLIST, code);
        if ("summary".equals(codeString))
          return new Enumeration<MeasureReportType>(this, MeasureReportType.SUMMARY, code);
        if ("data-exchange".equals(codeString))
          return new Enumeration<MeasureReportType>(this, MeasureReportType.DATAEXCHANGE, code);
        throw new FHIRException("Unknown MeasureReportType code '"+codeString+"'");
        }
    public String toCode(MeasureReportType code) {
      if (code == MeasureReportType.INDIVIDUAL)
        return "individual";
      if (code == MeasureReportType.SUBJECTLIST)
        return "subject-list";
      if (code == MeasureReportType.SUMMARY)
        return "summary";
      if (code == MeasureReportType.DATAEXCHANGE)
        return "data-exchange";
      return "?";
      }
    public String toSystem(MeasureReportType code) {
      return code.getSystem();
      }
    }

    public enum SubmitDataUpdateType {
        /**
         * In contrast to the Snapshot Update, the FHIR Parameters resource used in a Submit Data or the Collect Data scenario contains only the new and updated DEQM and QI Core Profiles since the last transaction. If the Consumer supports incremental updates, the contents of the updated payload updates the previous payload data.
         */
        INCREMENTAL, 
        /**
         * In contrast to the Incremental Update, the FHIR Parameters resource used in a Submit Data or the Collect Data scenario contains all the DEQM and QI Core Profiles for each transaction.  If the Consumer supports snapshot updates, the contents of the updated payload entirely replaces the previous payload
         */
        SNAPSHOT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SubmitDataUpdateType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("incremental".equals(codeString))
          return INCREMENTAL;
        if ("snapshot".equals(codeString))
          return SNAPSHOT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SubmitDataUpdateType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INCREMENTAL: return "incremental";
            case SNAPSHOT: return "snapshot";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INCREMENTAL: return "http://hl7.org/fhir/CodeSystem/submit-data-update-type";
            case SNAPSHOT: return "http://hl7.org/fhir/CodeSystem/submit-data-update-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INCREMENTAL: return "In contrast to the Snapshot Update, the FHIR Parameters resource used in a Submit Data or the Collect Data scenario contains only the new and updated DEQM and QI Core Profiles since the last transaction. If the Consumer supports incremental updates, the contents of the updated payload updates the previous payload data.";
            case SNAPSHOT: return "In contrast to the Incremental Update, the FHIR Parameters resource used in a Submit Data or the Collect Data scenario contains all the DEQM and QI Core Profiles for each transaction.  If the Consumer supports snapshot updates, the contents of the updated payload entirely replaces the previous payload";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INCREMENTAL: return "Incremental";
            case SNAPSHOT: return "Snapshot";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SubmitDataUpdateTypeEnumFactory implements EnumFactory<SubmitDataUpdateType> {
    public SubmitDataUpdateType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("incremental".equals(codeString))
          return SubmitDataUpdateType.INCREMENTAL;
        if ("snapshot".equals(codeString))
          return SubmitDataUpdateType.SNAPSHOT;
        throw new IllegalArgumentException("Unknown SubmitDataUpdateType code '"+codeString+"'");
        }
        public Enumeration<SubmitDataUpdateType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SubmitDataUpdateType>(this, SubmitDataUpdateType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<SubmitDataUpdateType>(this, SubmitDataUpdateType.NULL, code);
        if ("incremental".equals(codeString))
          return new Enumeration<SubmitDataUpdateType>(this, SubmitDataUpdateType.INCREMENTAL, code);
        if ("snapshot".equals(codeString))
          return new Enumeration<SubmitDataUpdateType>(this, SubmitDataUpdateType.SNAPSHOT, code);
        throw new FHIRException("Unknown SubmitDataUpdateType code '"+codeString+"'");
        }
    public String toCode(SubmitDataUpdateType code) {
      if (code == SubmitDataUpdateType.INCREMENTAL)
        return "incremental";
      if (code == SubmitDataUpdateType.SNAPSHOT)
        return "snapshot";
      return "?";
      }
    public String toSystem(SubmitDataUpdateType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class MeasureReportGroupComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The group from the Measure that corresponds to this group in the MeasureReport resource.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pointer to specific group from Measure", formalDefinition="The group from the Measure that corresponds to this group in the MeasureReport resource." )
        protected StringType linkId;

        /**
         * The meaning of the population group as defined in the measure definition.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Meaning of the group", formalDefinition="The meaning of the population group as defined in the measure definition." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measure-group-example")
        protected CodeableConcept code;

        /**
         * Optional subject identifying the individual or individuals the report is for.
         */
        @Child(name = "subject", type = {CareTeam.class, Device.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="What individual(s) the report is for", formalDefinition="Optional subject identifying the individual or individuals the report is for." )
        protected Reference subject;

        /**
         * The populations that make up the population group, one for each type of population appropriate for the measure.
         */
        @Child(name = "population", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The populations in the group", formalDefinition="The populations that make up the population group, one for each type of population appropriate for the measure." )
        protected List<MeasureReportGroupPopulationComponent> population;

        /**
         * The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.
         */
        @Child(name = "measureScore", type = {Quantity.class, DateTimeType.class, CodeableConcept.class, Period.class, Range.class, Duration.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="What score this group achieved", formalDefinition="The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group." )
        protected DataType measureScore;

        /**
         * When a measure includes multiple stratifiers, there will be a stratifier group for each stratifier defined by the measure.
         */
        @Child(name = "stratifier", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Stratification results", formalDefinition="When a measure includes multiple stratifiers, there will be a stratifier group for each stratifier defined by the measure." )
        protected List<MeasureReportGroupStratifierComponent> stratifier;

        private static final long serialVersionUID = 438553747L;

    /**
     * Constructor
     */
      public MeasureReportGroupComponent() {
        super();
      }

        /**
         * @return {@link #linkId} (The group from the Measure that corresponds to this group in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupComponent.linkId");
            else if (Configuration.doAutoCreate())
              this.linkId = new StringType(); // bb
          return this.linkId;
        }

        public boolean hasLinkIdElement() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        public boolean hasLinkId() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        /**
         * @param value {@link #linkId} (The group from the Measure that corresponds to this group in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public MeasureReportGroupComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return The group from the Measure that corresponds to this group in the MeasureReport resource.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value The group from the Measure that corresponds to this group in the MeasureReport resource.
         */
        public MeasureReportGroupComponent setLinkId(String value) { 
          if (Utilities.noString(value))
            this.linkId = null;
          else {
            if (this.linkId == null)
              this.linkId = new StringType();
            this.linkId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #code} (The meaning of the population group as defined in the measure definition.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The meaning of the population group as defined in the measure definition.)
         */
        public MeasureReportGroupComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #subject} (Optional subject identifying the individual or individuals the report is for.)
         */
        public Reference getSubject() { 
          if (this.subject == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupComponent.subject");
            else if (Configuration.doAutoCreate())
              this.subject = new Reference(); // cc
          return this.subject;
        }

        public boolean hasSubject() { 
          return this.subject != null && !this.subject.isEmpty();
        }

        /**
         * @param value {@link #subject} (Optional subject identifying the individual or individuals the report is for.)
         */
        public MeasureReportGroupComponent setSubject(Reference value) { 
          this.subject = value;
          return this;
        }

        /**
         * @return {@link #population} (The populations that make up the population group, one for each type of population appropriate for the measure.)
         */
        public List<MeasureReportGroupPopulationComponent> getPopulation() { 
          if (this.population == null)
            this.population = new ArrayList<MeasureReportGroupPopulationComponent>();
          return this.population;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MeasureReportGroupComponent setPopulation(List<MeasureReportGroupPopulationComponent> thePopulation) { 
          this.population = thePopulation;
          return this;
        }

        public boolean hasPopulation() { 
          if (this.population == null)
            return false;
          for (MeasureReportGroupPopulationComponent item : this.population)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MeasureReportGroupPopulationComponent addPopulation() { //3
          MeasureReportGroupPopulationComponent t = new MeasureReportGroupPopulationComponent();
          if (this.population == null)
            this.population = new ArrayList<MeasureReportGroupPopulationComponent>();
          this.population.add(t);
          return t;
        }

        public MeasureReportGroupComponent addPopulation(MeasureReportGroupPopulationComponent t) { //3
          if (t == null)
            return this;
          if (this.population == null)
            this.population = new ArrayList<MeasureReportGroupPopulationComponent>();
          this.population.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #population}, creating it if it does not already exist {3}
         */
        public MeasureReportGroupPopulationComponent getPopulationFirstRep() { 
          if (getPopulation().isEmpty()) {
            addPopulation();
          }
          return getPopulation().get(0);
        }

        /**
         * @return {@link #measureScore} (The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.)
         */
        public DataType getMeasureScore() { 
          return this.measureScore;
        }

        /**
         * @return {@link #measureScore} (The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.)
         */
        public Quantity getMeasureScoreQuantity() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new Quantity();
          if (!(this.measureScore instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (Quantity) this.measureScore;
        }

        public boolean hasMeasureScoreQuantity() { 
          return this != null && this.measureScore instanceof Quantity;
        }

        /**
         * @return {@link #measureScore} (The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.)
         */
        public DateTimeType getMeasureScoreDateTimeType() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new DateTimeType();
          if (!(this.measureScore instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (DateTimeType) this.measureScore;
        }

        public boolean hasMeasureScoreDateTimeType() { 
          return this != null && this.measureScore instanceof DateTimeType;
        }

        /**
         * @return {@link #measureScore} (The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.)
         */
        public CodeableConcept getMeasureScoreCodeableConcept() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new CodeableConcept();
          if (!(this.measureScore instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (CodeableConcept) this.measureScore;
        }

        public boolean hasMeasureScoreCodeableConcept() { 
          return this != null && this.measureScore instanceof CodeableConcept;
        }

        /**
         * @return {@link #measureScore} (The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.)
         */
        public Period getMeasureScorePeriod() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new Period();
          if (!(this.measureScore instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (Period) this.measureScore;
        }

        public boolean hasMeasureScorePeriod() { 
          return this != null && this.measureScore instanceof Period;
        }

        /**
         * @return {@link #measureScore} (The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.)
         */
        public Range getMeasureScoreRange() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new Range();
          if (!(this.measureScore instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (Range) this.measureScore;
        }

        public boolean hasMeasureScoreRange() { 
          return this != null && this.measureScore instanceof Range;
        }

        /**
         * @return {@link #measureScore} (The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.)
         */
        public Duration getMeasureScoreDuration() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new Duration();
          if (!(this.measureScore instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (Duration) this.measureScore;
        }

        public boolean hasMeasureScoreDuration() { 
          return this != null && this.measureScore instanceof Duration;
        }

        public boolean hasMeasureScore() { 
          return this.measureScore != null && !this.measureScore.isEmpty();
        }

        /**
         * @param value {@link #measureScore} (The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.)
         */
        public MeasureReportGroupComponent setMeasureScore(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof DateTimeType || value instanceof CodeableConcept || value instanceof Period || value instanceof Range || value instanceof Duration))
            throw new FHIRException("Not the right type for MeasureReport.group.measureScore[x]: "+value.fhirType());
          this.measureScore = value;
          return this;
        }

        /**
         * @return {@link #stratifier} (When a measure includes multiple stratifiers, there will be a stratifier group for each stratifier defined by the measure.)
         */
        public List<MeasureReportGroupStratifierComponent> getStratifier() { 
          if (this.stratifier == null)
            this.stratifier = new ArrayList<MeasureReportGroupStratifierComponent>();
          return this.stratifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MeasureReportGroupComponent setStratifier(List<MeasureReportGroupStratifierComponent> theStratifier) { 
          this.stratifier = theStratifier;
          return this;
        }

        public boolean hasStratifier() { 
          if (this.stratifier == null)
            return false;
          for (MeasureReportGroupStratifierComponent item : this.stratifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MeasureReportGroupStratifierComponent addStratifier() { //3
          MeasureReportGroupStratifierComponent t = new MeasureReportGroupStratifierComponent();
          if (this.stratifier == null)
            this.stratifier = new ArrayList<MeasureReportGroupStratifierComponent>();
          this.stratifier.add(t);
          return t;
        }

        public MeasureReportGroupComponent addStratifier(MeasureReportGroupStratifierComponent t) { //3
          if (t == null)
            return this;
          if (this.stratifier == null)
            this.stratifier = new ArrayList<MeasureReportGroupStratifierComponent>();
          this.stratifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #stratifier}, creating it if it does not already exist {3}
         */
        public MeasureReportGroupStratifierComponent getStratifierFirstRep() { 
          if (getStratifier().isEmpty()) {
            addStratifier();
          }
          return getStratifier().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "The group from the Measure that corresponds to this group in the MeasureReport resource.", 0, 1, linkId));
          children.add(new Property("code", "CodeableConcept", "The meaning of the population group as defined in the measure definition.", 0, 1, code));
          children.add(new Property("subject", "Reference(CareTeam|Device|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "Optional subject identifying the individual or individuals the report is for.", 0, 1, subject));
          children.add(new Property("population", "", "The populations that make up the population group, one for each type of population appropriate for the measure.", 0, java.lang.Integer.MAX_VALUE, population));
          children.add(new Property("measureScore[x]", "Quantity|dateTime|CodeableConcept|Period|Range|Duration", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore));
          children.add(new Property("stratifier", "", "When a measure includes multiple stratifiers, there will be a stratifier group for each stratifier defined by the measure.", 0, java.lang.Integer.MAX_VALUE, stratifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "The group from the Measure that corresponds to this group in the MeasureReport resource.", 0, 1, linkId);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The meaning of the population group as defined in the measure definition.", 0, 1, code);
          case -1867885268: /*subject*/  return new Property("subject", "Reference(CareTeam|Device|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "Optional subject identifying the individual or individuals the report is for.", 0, 1, subject);
          case -2023558323: /*population*/  return new Property("population", "", "The populations that make up the population group, one for each type of population appropriate for the measure.", 0, java.lang.Integer.MAX_VALUE, population);
          case 1854115884: /*measureScore[x]*/  return new Property("measureScore[x]", "Quantity|dateTime|CodeableConcept|Period|Range|Duration", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore);
          case -386313260: /*measureScore*/  return new Property("measureScore[x]", "Quantity|dateTime|CodeableConcept|Period|Range|Duration", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore);
          case -1880815489: /*measureScoreQuantity*/  return new Property("measureScore[x]", "Quantity", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore);
          case 1196938127: /*measureScoreDateTime*/  return new Property("measureScore[x]", "dateTime", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore);
          case -1193234131: /*measureScoreCodeableConcept*/  return new Property("measureScore[x]", "CodeableConcept", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore);
          case -1939831115: /*measureScorePeriod*/  return new Property("measureScore[x]", "Period", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore);
          case -615040567: /*measureScoreRange*/  return new Property("measureScore[x]", "Range", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore);
          case 1707143560: /*measureScoreDuration*/  return new Property("measureScore[x]", "Duration", "The measure score for this population group, calculated as appropriate for the measure type and scoring method, and based on the contents of the populations defined in the group.", 0, 1, measureScore);
          case 90983669: /*stratifier*/  return new Property("stratifier", "", "When a measure includes multiple stratifiers, there will be a stratifier group for each stratifier defined by the measure.", 0, java.lang.Integer.MAX_VALUE, stratifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // StringType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -2023558323: /*population*/ return this.population == null ? new Base[0] : this.population.toArray(new Base[this.population.size()]); // MeasureReportGroupPopulationComponent
        case -386313260: /*measureScore*/ return this.measureScore == null ? new Base[0] : new Base[] {this.measureScore}; // DataType
        case 90983669: /*stratifier*/ return this.stratifier == null ? new Base[0] : this.stratifier.toArray(new Base[this.stratifier.size()]); // MeasureReportGroupStratifierComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case -2023558323: // population
          this.getPopulation().add((MeasureReportGroupPopulationComponent) value); // MeasureReportGroupPopulationComponent
          return value;
        case -386313260: // measureScore
          this.measureScore = TypeConvertor.castToType(value); // DataType
          return value;
        case 90983669: // stratifier
          this.getStratifier().add((MeasureReportGroupStratifierComponent) value); // MeasureReportGroupStratifierComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("population")) {
          this.getPopulation().add((MeasureReportGroupPopulationComponent) value);
        } else if (name.equals("measureScore[x]")) {
          this.measureScore = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("stratifier")) {
          this.getStratifier().add((MeasureReportGroupStratifierComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("population")) {
          this.getPopulation().add((MeasureReportGroupPopulationComponent) value);
        } else if (name.equals("measureScore[x]")) {
          this.measureScore = null;
        } else if (name.equals("stratifier")) {
          this.getStratifier().add((MeasureReportGroupStratifierComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case -2023558323:  return addPopulation(); 
        case 1854115884:  return getMeasureScore();
        case -386313260:  return getMeasureScore();
        case 90983669:  return addStratifier(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"string"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -2023558323: /*population*/ return new String[] {};
        case -386313260: /*measureScore*/ return new String[] {"Quantity", "dateTime", "CodeableConcept", "Period", "Range", "Duration"};
        case 90983669: /*stratifier*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.group.linkId");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("population")) {
          return addPopulation();
        }
        else if (name.equals("measureScoreQuantity")) {
          this.measureScore = new Quantity();
          return this.measureScore;
        }
        else if (name.equals("measureScoreDateTime")) {
          this.measureScore = new DateTimeType();
          return this.measureScore;
        }
        else if (name.equals("measureScoreCodeableConcept")) {
          this.measureScore = new CodeableConcept();
          return this.measureScore;
        }
        else if (name.equals("measureScorePeriod")) {
          this.measureScore = new Period();
          return this.measureScore;
        }
        else if (name.equals("measureScoreRange")) {
          this.measureScore = new Range();
          return this.measureScore;
        }
        else if (name.equals("measureScoreDuration")) {
          this.measureScore = new Duration();
          return this.measureScore;
        }
        else if (name.equals("stratifier")) {
          return addStratifier();
        }
        else
          return super.addChild(name);
      }

      public MeasureReportGroupComponent copy() {
        MeasureReportGroupComponent dst = new MeasureReportGroupComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MeasureReportGroupComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        if (population != null) {
          dst.population = new ArrayList<MeasureReportGroupPopulationComponent>();
          for (MeasureReportGroupPopulationComponent i : population)
            dst.population.add(i.copy());
        };
        dst.measureScore = measureScore == null ? null : measureScore.copy();
        if (stratifier != null) {
          dst.stratifier = new ArrayList<MeasureReportGroupStratifierComponent>();
          for (MeasureReportGroupStratifierComponent i : stratifier)
            dst.stratifier.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MeasureReportGroupComponent))
          return false;
        MeasureReportGroupComponent o = (MeasureReportGroupComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true)
           && compareDeep(population, o.population, true) && compareDeep(measureScore, o.measureScore, true)
           && compareDeep(stratifier, o.stratifier, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MeasureReportGroupComponent))
          return false;
        MeasureReportGroupComponent o = (MeasureReportGroupComponent) other_;
        return compareValues(linkId, o.linkId, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, code, subject, population
          , measureScore, stratifier);
      }

  public String fhirType() {
    return "MeasureReport.group";

  }

  }

    @Block()
    public static class MeasureReportGroupPopulationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The population from the Measure that corresponds to this population in the MeasureReport resource.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pointer to specific population from Measure", formalDefinition="The population from the Measure that corresponds to this population in the MeasureReport resource." )
        protected StringType linkId;

        /**
         * The type of the population.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="initial-population | numerator | numerator-exclusion | denominator | denominator-exclusion | denominator-exception | measure-population | measure-population-exclusion | measure-observation", formalDefinition="The type of the population." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measure-population")
        protected CodeableConcept code;

        /**
         * The number of members of the population.
         */
        @Child(name = "count", type = {IntegerType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Size of the population", formalDefinition="The number of members of the population." )
        protected IntegerType count;

        /**
         * This element refers to a List of individual level MeasureReport resources, one for each subject in this population.
         */
        @Child(name = "subjectResults", type = {ListResource.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="For subject-list reports, the subject results in this population", formalDefinition="This element refers to a List of individual level MeasureReport resources, one for each subject in this population." )
        protected Reference subjectResults;

        /**
         * A reference to an individual level MeasureReport resource for a member of the population.
         */
        @Child(name = "subjectReport", type = {MeasureReport.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="For subject-list reports, a subject result in this population", formalDefinition="A reference to an individual level MeasureReport resource for a member of the population." )
        protected List<Reference> subjectReport;

        /**
         * Optional Group identifying the individuals that make up the population.
         */
        @Child(name = "subjects", type = {Group.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What individual(s) in the population", formalDefinition="Optional Group identifying the individuals that make up the population." )
        protected Reference subjects;

        private static final long serialVersionUID = -203678073L;

    /**
     * Constructor
     */
      public MeasureReportGroupPopulationComponent() {
        super();
      }

        /**
         * @return {@link #linkId} (The population from the Measure that corresponds to this population in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupPopulationComponent.linkId");
            else if (Configuration.doAutoCreate())
              this.linkId = new StringType(); // bb
          return this.linkId;
        }

        public boolean hasLinkIdElement() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        public boolean hasLinkId() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        /**
         * @param value {@link #linkId} (The population from the Measure that corresponds to this population in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public MeasureReportGroupPopulationComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return The population from the Measure that corresponds to this population in the MeasureReport resource.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value The population from the Measure that corresponds to this population in the MeasureReport resource.
         */
        public MeasureReportGroupPopulationComponent setLinkId(String value) { 
          if (Utilities.noString(value))
            this.linkId = null;
          else {
            if (this.linkId == null)
              this.linkId = new StringType();
            this.linkId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #code} (The type of the population.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupPopulationComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The type of the population.)
         */
        public MeasureReportGroupPopulationComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #count} (The number of members of the population.). This is the underlying object with id, value and extensions. The accessor "getCount" gives direct access to the value
         */
        public IntegerType getCountElement() { 
          if (this.count == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupPopulationComponent.count");
            else if (Configuration.doAutoCreate())
              this.count = new IntegerType(); // bb
          return this.count;
        }

        public boolean hasCountElement() { 
          return this.count != null && !this.count.isEmpty();
        }

        public boolean hasCount() { 
          return this.count != null && !this.count.isEmpty();
        }

        /**
         * @param value {@link #count} (The number of members of the population.). This is the underlying object with id, value and extensions. The accessor "getCount" gives direct access to the value
         */
        public MeasureReportGroupPopulationComponent setCountElement(IntegerType value) { 
          this.count = value;
          return this;
        }

        /**
         * @return The number of members of the population.
         */
        public int getCount() { 
          return this.count == null || this.count.isEmpty() ? 0 : this.count.getValue();
        }

        /**
         * @param value The number of members of the population.
         */
        public MeasureReportGroupPopulationComponent setCount(int value) { 
            if (this.count == null)
              this.count = new IntegerType();
            this.count.setValue(value);
          return this;
        }

        /**
         * @return {@link #subjectResults} (This element refers to a List of individual level MeasureReport resources, one for each subject in this population.)
         */
        public Reference getSubjectResults() { 
          if (this.subjectResults == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupPopulationComponent.subjectResults");
            else if (Configuration.doAutoCreate())
              this.subjectResults = new Reference(); // cc
          return this.subjectResults;
        }

        public boolean hasSubjectResults() { 
          return this.subjectResults != null && !this.subjectResults.isEmpty();
        }

        /**
         * @param value {@link #subjectResults} (This element refers to a List of individual level MeasureReport resources, one for each subject in this population.)
         */
        public MeasureReportGroupPopulationComponent setSubjectResults(Reference value) { 
          this.subjectResults = value;
          return this;
        }

        /**
         * @return {@link #subjectReport} (A reference to an individual level MeasureReport resource for a member of the population.)
         */
        public List<Reference> getSubjectReport() { 
          if (this.subjectReport == null)
            this.subjectReport = new ArrayList<Reference>();
          return this.subjectReport;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MeasureReportGroupPopulationComponent setSubjectReport(List<Reference> theSubjectReport) { 
          this.subjectReport = theSubjectReport;
          return this;
        }

        public boolean hasSubjectReport() { 
          if (this.subjectReport == null)
            return false;
          for (Reference item : this.subjectReport)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSubjectReport() { //3
          Reference t = new Reference();
          if (this.subjectReport == null)
            this.subjectReport = new ArrayList<Reference>();
          this.subjectReport.add(t);
          return t;
        }

        public MeasureReportGroupPopulationComponent addSubjectReport(Reference t) { //3
          if (t == null)
            return this;
          if (this.subjectReport == null)
            this.subjectReport = new ArrayList<Reference>();
          this.subjectReport.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #subjectReport}, creating it if it does not already exist {3}
         */
        public Reference getSubjectReportFirstRep() { 
          if (getSubjectReport().isEmpty()) {
            addSubjectReport();
          }
          return getSubjectReport().get(0);
        }

        /**
         * @return {@link #subjects} (Optional Group identifying the individuals that make up the population.)
         */
        public Reference getSubjects() { 
          if (this.subjects == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupPopulationComponent.subjects");
            else if (Configuration.doAutoCreate())
              this.subjects = new Reference(); // cc
          return this.subjects;
        }

        public boolean hasSubjects() { 
          return this.subjects != null && !this.subjects.isEmpty();
        }

        /**
         * @param value {@link #subjects} (Optional Group identifying the individuals that make up the population.)
         */
        public MeasureReportGroupPopulationComponent setSubjects(Reference value) { 
          this.subjects = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "The population from the Measure that corresponds to this population in the MeasureReport resource.", 0, 1, linkId));
          children.add(new Property("code", "CodeableConcept", "The type of the population.", 0, 1, code));
          children.add(new Property("count", "integer", "The number of members of the population.", 0, 1, count));
          children.add(new Property("subjectResults", "Reference(List)", "This element refers to a List of individual level MeasureReport resources, one for each subject in this population.", 0, 1, subjectResults));
          children.add(new Property("subjectReport", "Reference(MeasureReport)", "A reference to an individual level MeasureReport resource for a member of the population.", 0, java.lang.Integer.MAX_VALUE, subjectReport));
          children.add(new Property("subjects", "Reference(Group)", "Optional Group identifying the individuals that make up the population.", 0, 1, subjects));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "The population from the Measure that corresponds to this population in the MeasureReport resource.", 0, 1, linkId);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The type of the population.", 0, 1, code);
          case 94851343: /*count*/  return new Property("count", "integer", "The number of members of the population.", 0, 1, count);
          case 2136184106: /*subjectResults*/  return new Property("subjectResults", "Reference(List)", "This element refers to a List of individual level MeasureReport resources, one for each subject in this population.", 0, 1, subjectResults);
          case 68814208: /*subjectReport*/  return new Property("subjectReport", "Reference(MeasureReport)", "A reference to an individual level MeasureReport resource for a member of the population.", 0, java.lang.Integer.MAX_VALUE, subjectReport);
          case -2069868345: /*subjects*/  return new Property("subjects", "Reference(Group)", "Optional Group identifying the individuals that make up the population.", 0, 1, subjects);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // StringType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 94851343: /*count*/ return this.count == null ? new Base[0] : new Base[] {this.count}; // IntegerType
        case 2136184106: /*subjectResults*/ return this.subjectResults == null ? new Base[0] : new Base[] {this.subjectResults}; // Reference
        case 68814208: /*subjectReport*/ return this.subjectReport == null ? new Base[0] : this.subjectReport.toArray(new Base[this.subjectReport.size()]); // Reference
        case -2069868345: /*subjects*/ return this.subjects == null ? new Base[0] : new Base[] {this.subjects}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 94851343: // count
          this.count = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 2136184106: // subjectResults
          this.subjectResults = TypeConvertor.castToReference(value); // Reference
          return value;
        case 68814208: // subjectReport
          this.getSubjectReport().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -2069868345: // subjects
          this.subjects = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("count")) {
          this.count = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("subjectResults")) {
          this.subjectResults = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("subjectReport")) {
          this.getSubjectReport().add(TypeConvertor.castToReference(value));
        } else if (name.equals("subjects")) {
          this.subjects = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("count")) {
          this.count = null;
        } else if (name.equals("subjectResults")) {
          this.subjectResults = null;
        } else if (name.equals("subjectReport")) {
          this.getSubjectReport().remove(value);
        } else if (name.equals("subjects")) {
          this.subjects = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case 3059181:  return getCode();
        case 94851343:  return getCountElement();
        case 2136184106:  return getSubjectResults();
        case 68814208:  return addSubjectReport(); 
        case -2069868345:  return getSubjects();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"string"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 94851343: /*count*/ return new String[] {"integer"};
        case 2136184106: /*subjectResults*/ return new String[] {"Reference"};
        case 68814208: /*subjectReport*/ return new String[] {"Reference"};
        case -2069868345: /*subjects*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.group.population.linkId");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("count")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.group.population.count");
        }
        else if (name.equals("subjectResults")) {
          this.subjectResults = new Reference();
          return this.subjectResults;
        }
        else if (name.equals("subjectReport")) {
          return addSubjectReport();
        }
        else if (name.equals("subjects")) {
          this.subjects = new Reference();
          return this.subjects;
        }
        else
          return super.addChild(name);
      }

      public MeasureReportGroupPopulationComponent copy() {
        MeasureReportGroupPopulationComponent dst = new MeasureReportGroupPopulationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MeasureReportGroupPopulationComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.code = code == null ? null : code.copy();
        dst.count = count == null ? null : count.copy();
        dst.subjectResults = subjectResults == null ? null : subjectResults.copy();
        if (subjectReport != null) {
          dst.subjectReport = new ArrayList<Reference>();
          for (Reference i : subjectReport)
            dst.subjectReport.add(i.copy());
        };
        dst.subjects = subjects == null ? null : subjects.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MeasureReportGroupPopulationComponent))
          return false;
        MeasureReportGroupPopulationComponent o = (MeasureReportGroupPopulationComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(code, o.code, true) && compareDeep(count, o.count, true)
           && compareDeep(subjectResults, o.subjectResults, true) && compareDeep(subjectReport, o.subjectReport, true)
           && compareDeep(subjects, o.subjects, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MeasureReportGroupPopulationComponent))
          return false;
        MeasureReportGroupPopulationComponent o = (MeasureReportGroupPopulationComponent) other_;
        return compareValues(linkId, o.linkId, true) && compareValues(count, o.count, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, code, count, subjectResults
          , subjectReport, subjects);
      }

  public String fhirType() {
    return "MeasureReport.group.population";

  }

  }

    @Block()
    public static class MeasureReportGroupStratifierComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The stratifier from the Measure that corresponds to this stratifier in the MeasureReport resource.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pointer to specific stratifier from Measure", formalDefinition="The stratifier from the Measure that corresponds to this stratifier in the MeasureReport resource." )
        protected StringType linkId;

        /**
         * The meaning of this stratifier, as defined in the measure definition.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What stratifier of the group", formalDefinition="The meaning of this stratifier, as defined in the measure definition." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measure-stratifier-example")
        protected CodeableConcept code;

        /**
         * This element contains the results for a single stratum within the stratifier. For example, when stratifying on administrative gender, there will be four strata, one for each possible gender value.
         */
        @Child(name = "stratum", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Stratum results, one for each unique value, or set of values, in the stratifier, or stratifier components", formalDefinition="This element contains the results for a single stratum within the stratifier. For example, when stratifying on administrative gender, there will be four strata, one for each possible gender value." )
        protected List<StratifierGroupComponent> stratum;

        private static final long serialVersionUID = 1021076195L;

    /**
     * Constructor
     */
      public MeasureReportGroupStratifierComponent() {
        super();
      }

        /**
         * @return {@link #linkId} (The stratifier from the Measure that corresponds to this stratifier in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupStratifierComponent.linkId");
            else if (Configuration.doAutoCreate())
              this.linkId = new StringType(); // bb
          return this.linkId;
        }

        public boolean hasLinkIdElement() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        public boolean hasLinkId() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        /**
         * @param value {@link #linkId} (The stratifier from the Measure that corresponds to this stratifier in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public MeasureReportGroupStratifierComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return The stratifier from the Measure that corresponds to this stratifier in the MeasureReport resource.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value The stratifier from the Measure that corresponds to this stratifier in the MeasureReport resource.
         */
        public MeasureReportGroupStratifierComponent setLinkId(String value) { 
          if (Utilities.noString(value))
            this.linkId = null;
          else {
            if (this.linkId == null)
              this.linkId = new StringType();
            this.linkId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #code} (The meaning of this stratifier, as defined in the measure definition.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MeasureReportGroupStratifierComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The meaning of this stratifier, as defined in the measure definition.)
         */
        public MeasureReportGroupStratifierComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #stratum} (This element contains the results for a single stratum within the stratifier. For example, when stratifying on administrative gender, there will be four strata, one for each possible gender value.)
         */
        public List<StratifierGroupComponent> getStratum() { 
          if (this.stratum == null)
            this.stratum = new ArrayList<StratifierGroupComponent>();
          return this.stratum;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MeasureReportGroupStratifierComponent setStratum(List<StratifierGroupComponent> theStratum) { 
          this.stratum = theStratum;
          return this;
        }

        public boolean hasStratum() { 
          if (this.stratum == null)
            return false;
          for (StratifierGroupComponent item : this.stratum)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StratifierGroupComponent addStratum() { //3
          StratifierGroupComponent t = new StratifierGroupComponent();
          if (this.stratum == null)
            this.stratum = new ArrayList<StratifierGroupComponent>();
          this.stratum.add(t);
          return t;
        }

        public MeasureReportGroupStratifierComponent addStratum(StratifierGroupComponent t) { //3
          if (t == null)
            return this;
          if (this.stratum == null)
            this.stratum = new ArrayList<StratifierGroupComponent>();
          this.stratum.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #stratum}, creating it if it does not already exist {3}
         */
        public StratifierGroupComponent getStratumFirstRep() { 
          if (getStratum().isEmpty()) {
            addStratum();
          }
          return getStratum().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "The stratifier from the Measure that corresponds to this stratifier in the MeasureReport resource.", 0, 1, linkId));
          children.add(new Property("code", "CodeableConcept", "The meaning of this stratifier, as defined in the measure definition.", 0, 1, code));
          children.add(new Property("stratum", "", "This element contains the results for a single stratum within the stratifier. For example, when stratifying on administrative gender, there will be four strata, one for each possible gender value.", 0, java.lang.Integer.MAX_VALUE, stratum));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "The stratifier from the Measure that corresponds to this stratifier in the MeasureReport resource.", 0, 1, linkId);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The meaning of this stratifier, as defined in the measure definition.", 0, 1, code);
          case -1881991236: /*stratum*/  return new Property("stratum", "", "This element contains the results for a single stratum within the stratifier. For example, when stratifying on administrative gender, there will be four strata, one for each possible gender value.", 0, java.lang.Integer.MAX_VALUE, stratum);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // StringType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1881991236: /*stratum*/ return this.stratum == null ? new Base[0] : this.stratum.toArray(new Base[this.stratum.size()]); // StratifierGroupComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1881991236: // stratum
          this.getStratum().add((StratifierGroupComponent) value); // StratifierGroupComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("stratum")) {
          this.getStratum().add((StratifierGroupComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("stratum")) {
          this.getStratum().add((StratifierGroupComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case 3059181:  return getCode();
        case -1881991236:  return addStratum(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"string"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1881991236: /*stratum*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.group.stratifier.linkId");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("stratum")) {
          return addStratum();
        }
        else
          return super.addChild(name);
      }

      public MeasureReportGroupStratifierComponent copy() {
        MeasureReportGroupStratifierComponent dst = new MeasureReportGroupStratifierComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MeasureReportGroupStratifierComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.code = code == null ? null : code.copy();
        if (stratum != null) {
          dst.stratum = new ArrayList<StratifierGroupComponent>();
          for (StratifierGroupComponent i : stratum)
            dst.stratum.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MeasureReportGroupStratifierComponent))
          return false;
        MeasureReportGroupStratifierComponent o = (MeasureReportGroupStratifierComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(code, o.code, true) && compareDeep(stratum, o.stratum, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MeasureReportGroupStratifierComponent))
          return false;
        MeasureReportGroupStratifierComponent o = (MeasureReportGroupStratifierComponent) other_;
        return compareValues(linkId, o.linkId, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, code, stratum);
      }

  public String fhirType() {
    return "MeasureReport.group.stratifier";

  }

  }

    @Block()
    public static class StratifierGroupComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.
         */
        @Child(name = "value", type = {CodeableConcept.class, BooleanType.class, Quantity.class, Range.class, Reference.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The stratum value, e.g. male", formalDefinition="The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measurereport-stratifier-value-example")
        protected DataType value;

        /**
         * A stratifier component value.
         */
        @Child(name = "component", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Stratifier component values", formalDefinition="A stratifier component value." )
        protected List<StratifierGroupComponentComponent> component;

        /**
         * The populations that make up the stratum, one for each type of population appropriate to the measure.
         */
        @Child(name = "population", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Population results in this stratum", formalDefinition="The populations that make up the stratum, one for each type of population appropriate to the measure." )
        protected List<StratifierGroupPopulationComponent> population;

        /**
         * The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.
         */
        @Child(name = "measureScore", type = {Quantity.class, DateTimeType.class, CodeableConcept.class, Period.class, Range.class, Duration.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What score this stratum achieved", formalDefinition="The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum." )
        protected DataType measureScore;

        private static final long serialVersionUID = -1713783491L;

    /**
     * Constructor
     */
      public StratifierGroupComponent() {
        super();
      }

        /**
         * @return {@link #value} (The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.)
         */
        public Reference getValueReference() throws FHIRException { 
          if (this.value == null)
            this.value = new Reference();
          if (!(this.value instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Reference) this.value;
        }

        public boolean hasValueReference() { 
          return this != null && this.value instanceof Reference;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.)
         */
        public StratifierGroupComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof BooleanType || value instanceof Quantity || value instanceof Range || value instanceof Reference))
            throw new FHIRException("Not the right type for MeasureReport.group.stratifier.stratum.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #component} (A stratifier component value.)
         */
        public List<StratifierGroupComponentComponent> getComponent() { 
          if (this.component == null)
            this.component = new ArrayList<StratifierGroupComponentComponent>();
          return this.component;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StratifierGroupComponent setComponent(List<StratifierGroupComponentComponent> theComponent) { 
          this.component = theComponent;
          return this;
        }

        public boolean hasComponent() { 
          if (this.component == null)
            return false;
          for (StratifierGroupComponentComponent item : this.component)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StratifierGroupComponentComponent addComponent() { //3
          StratifierGroupComponentComponent t = new StratifierGroupComponentComponent();
          if (this.component == null)
            this.component = new ArrayList<StratifierGroupComponentComponent>();
          this.component.add(t);
          return t;
        }

        public StratifierGroupComponent addComponent(StratifierGroupComponentComponent t) { //3
          if (t == null)
            return this;
          if (this.component == null)
            this.component = new ArrayList<StratifierGroupComponentComponent>();
          this.component.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #component}, creating it if it does not already exist {3}
         */
        public StratifierGroupComponentComponent getComponentFirstRep() { 
          if (getComponent().isEmpty()) {
            addComponent();
          }
          return getComponent().get(0);
        }

        /**
         * @return {@link #population} (The populations that make up the stratum, one for each type of population appropriate to the measure.)
         */
        public List<StratifierGroupPopulationComponent> getPopulation() { 
          if (this.population == null)
            this.population = new ArrayList<StratifierGroupPopulationComponent>();
          return this.population;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StratifierGroupComponent setPopulation(List<StratifierGroupPopulationComponent> thePopulation) { 
          this.population = thePopulation;
          return this;
        }

        public boolean hasPopulation() { 
          if (this.population == null)
            return false;
          for (StratifierGroupPopulationComponent item : this.population)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StratifierGroupPopulationComponent addPopulation() { //3
          StratifierGroupPopulationComponent t = new StratifierGroupPopulationComponent();
          if (this.population == null)
            this.population = new ArrayList<StratifierGroupPopulationComponent>();
          this.population.add(t);
          return t;
        }

        public StratifierGroupComponent addPopulation(StratifierGroupPopulationComponent t) { //3
          if (t == null)
            return this;
          if (this.population == null)
            this.population = new ArrayList<StratifierGroupPopulationComponent>();
          this.population.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #population}, creating it if it does not already exist {3}
         */
        public StratifierGroupPopulationComponent getPopulationFirstRep() { 
          if (getPopulation().isEmpty()) {
            addPopulation();
          }
          return getPopulation().get(0);
        }

        /**
         * @return {@link #measureScore} (The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.)
         */
        public DataType getMeasureScore() { 
          return this.measureScore;
        }

        /**
         * @return {@link #measureScore} (The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.)
         */
        public Quantity getMeasureScoreQuantity() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new Quantity();
          if (!(this.measureScore instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (Quantity) this.measureScore;
        }

        public boolean hasMeasureScoreQuantity() { 
          return this != null && this.measureScore instanceof Quantity;
        }

        /**
         * @return {@link #measureScore} (The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.)
         */
        public DateTimeType getMeasureScoreDateTimeType() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new DateTimeType();
          if (!(this.measureScore instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (DateTimeType) this.measureScore;
        }

        public boolean hasMeasureScoreDateTimeType() { 
          return this != null && this.measureScore instanceof DateTimeType;
        }

        /**
         * @return {@link #measureScore} (The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.)
         */
        public CodeableConcept getMeasureScoreCodeableConcept() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new CodeableConcept();
          if (!(this.measureScore instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (CodeableConcept) this.measureScore;
        }

        public boolean hasMeasureScoreCodeableConcept() { 
          return this != null && this.measureScore instanceof CodeableConcept;
        }

        /**
         * @return {@link #measureScore} (The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.)
         */
        public Period getMeasureScorePeriod() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new Period();
          if (!(this.measureScore instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (Period) this.measureScore;
        }

        public boolean hasMeasureScorePeriod() { 
          return this != null && this.measureScore instanceof Period;
        }

        /**
         * @return {@link #measureScore} (The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.)
         */
        public Range getMeasureScoreRange() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new Range();
          if (!(this.measureScore instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (Range) this.measureScore;
        }

        public boolean hasMeasureScoreRange() { 
          return this != null && this.measureScore instanceof Range;
        }

        /**
         * @return {@link #measureScore} (The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.)
         */
        public Duration getMeasureScoreDuration() throws FHIRException { 
          if (this.measureScore == null)
            this.measureScore = new Duration();
          if (!(this.measureScore instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.measureScore.getClass().getName()+" was encountered");
          return (Duration) this.measureScore;
        }

        public boolean hasMeasureScoreDuration() { 
          return this != null && this.measureScore instanceof Duration;
        }

        public boolean hasMeasureScore() { 
          return this.measureScore != null && !this.measureScore.isEmpty();
        }

        /**
         * @param value {@link #measureScore} (The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.)
         */
        public StratifierGroupComponent setMeasureScore(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof DateTimeType || value instanceof CodeableConcept || value instanceof Period || value instanceof Range || value instanceof Duration))
            throw new FHIRException("Not the right type for MeasureReport.group.stratifier.stratum.measureScore[x]: "+value.fhirType());
          this.measureScore = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.", 0, 1, value));
          children.add(new Property("component", "", "A stratifier component value.", 0, java.lang.Integer.MAX_VALUE, component));
          children.add(new Property("population", "", "The populations that make up the stratum, one for each type of population appropriate to the measure.", 0, java.lang.Integer.MAX_VALUE, population));
          children.add(new Property("measureScore[x]", "Quantity|dateTime|CodeableConcept|Period|Range|Duration", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on complex values, the value must be rendered such that the value for each stratum within the stratifier is unique.", 0, 1, value);
          case -1399907075: /*component*/  return new Property("component", "", "A stratifier component value.", 0, java.lang.Integer.MAX_VALUE, component);
          case -2023558323: /*population*/  return new Property("population", "", "The populations that make up the stratum, one for each type of population appropriate to the measure.", 0, java.lang.Integer.MAX_VALUE, population);
          case 1854115884: /*measureScore[x]*/  return new Property("measureScore[x]", "Quantity|dateTime|CodeableConcept|Period|Range|Duration", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore);
          case -386313260: /*measureScore*/  return new Property("measureScore[x]", "Quantity|dateTime|CodeableConcept|Period|Range|Duration", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore);
          case -1880815489: /*measureScoreQuantity*/  return new Property("measureScore[x]", "Quantity", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore);
          case 1196938127: /*measureScoreDateTime*/  return new Property("measureScore[x]", "dateTime", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore);
          case -1193234131: /*measureScoreCodeableConcept*/  return new Property("measureScore[x]", "CodeableConcept", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore);
          case -1939831115: /*measureScorePeriod*/  return new Property("measureScore[x]", "Period", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore);
          case -615040567: /*measureScoreRange*/  return new Property("measureScore[x]", "Range", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore);
          case 1707143560: /*measureScoreDuration*/  return new Property("measureScore[x]", "Duration", "The measure score for this stratum, calculated as appropriate for the measure type and scoring method, and based on only the members of this stratum.", 0, 1, measureScore);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case -1399907075: /*component*/ return this.component == null ? new Base[0] : this.component.toArray(new Base[this.component.size()]); // StratifierGroupComponentComponent
        case -2023558323: /*population*/ return this.population == null ? new Base[0] : this.population.toArray(new Base[this.population.size()]); // StratifierGroupPopulationComponent
        case -386313260: /*measureScore*/ return this.measureScore == null ? new Base[0] : new Base[] {this.measureScore}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case -1399907075: // component
          this.getComponent().add((StratifierGroupComponentComponent) value); // StratifierGroupComponentComponent
          return value;
        case -2023558323: // population
          this.getPopulation().add((StratifierGroupPopulationComponent) value); // StratifierGroupPopulationComponent
          return value;
        case -386313260: // measureScore
          this.measureScore = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("component")) {
          this.getComponent().add((StratifierGroupComponentComponent) value);
        } else if (name.equals("population")) {
          this.getPopulation().add((StratifierGroupPopulationComponent) value);
        } else if (name.equals("measureScore[x]")) {
          this.measureScore = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("value[x]")) {
          this.value = null;
        } else if (name.equals("component")) {
          this.getComponent().add((StratifierGroupComponentComponent) value);
        } else if (name.equals("population")) {
          this.getPopulation().add((StratifierGroupPopulationComponent) value);
        } else if (name.equals("measureScore[x]")) {
          this.measureScore = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case -1399907075:  return addComponent(); 
        case -2023558323:  return addPopulation(); 
        case 1854115884:  return getMeasureScore();
        case -386313260:  return getMeasureScore();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "boolean", "Quantity", "Range", "Reference"};
        case -1399907075: /*component*/ return new String[] {};
        case -2023558323: /*population*/ return new String[] {};
        case -386313260: /*measureScore*/ return new String[] {"Quantity", "dateTime", "CodeableConcept", "Period", "Range", "Duration"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("component")) {
          return addComponent();
        }
        else if (name.equals("population")) {
          return addPopulation();
        }
        else if (name.equals("measureScoreQuantity")) {
          this.measureScore = new Quantity();
          return this.measureScore;
        }
        else if (name.equals("measureScoreDateTime")) {
          this.measureScore = new DateTimeType();
          return this.measureScore;
        }
        else if (name.equals("measureScoreCodeableConcept")) {
          this.measureScore = new CodeableConcept();
          return this.measureScore;
        }
        else if (name.equals("measureScorePeriod")) {
          this.measureScore = new Period();
          return this.measureScore;
        }
        else if (name.equals("measureScoreRange")) {
          this.measureScore = new Range();
          return this.measureScore;
        }
        else if (name.equals("measureScoreDuration")) {
          this.measureScore = new Duration();
          return this.measureScore;
        }
        else
          return super.addChild(name);
      }

      public StratifierGroupComponent copy() {
        StratifierGroupComponent dst = new StratifierGroupComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StratifierGroupComponent dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        if (component != null) {
          dst.component = new ArrayList<StratifierGroupComponentComponent>();
          for (StratifierGroupComponentComponent i : component)
            dst.component.add(i.copy());
        };
        if (population != null) {
          dst.population = new ArrayList<StratifierGroupPopulationComponent>();
          for (StratifierGroupPopulationComponent i : population)
            dst.population.add(i.copy());
        };
        dst.measureScore = measureScore == null ? null : measureScore.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StratifierGroupComponent))
          return false;
        StratifierGroupComponent o = (StratifierGroupComponent) other_;
        return compareDeep(value, o.value, true) && compareDeep(component, o.component, true) && compareDeep(population, o.population, true)
           && compareDeep(measureScore, o.measureScore, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StratifierGroupComponent))
          return false;
        StratifierGroupComponent o = (StratifierGroupComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, component, population
          , measureScore);
      }

  public String fhirType() {
    return "MeasureReport.group.stratifier.stratum";

  }

  }

    @Block()
    public static class StratifierGroupComponentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The stratifier component from the Measure that corresponds to this stratifier component in the MeasureReport resource.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pointer to specific stratifier component from Measure", formalDefinition="The stratifier component from the Measure that corresponds to this stratifier component in the MeasureReport resource." )
        protected StringType linkId;

        /**
         * The code for the stratum component value.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What stratifier component of the group", formalDefinition="The code for the stratum component value." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measure-stratifier-example")
        protected CodeableConcept code;

        /**
         * The stratum component value.
         */
        @Child(name = "value", type = {CodeableConcept.class, BooleanType.class, Quantity.class, Range.class, Reference.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The stratum component value, e.g. male", formalDefinition="The stratum component value." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measurereport-stratifier-value-example")
        protected DataType value;

        private static final long serialVersionUID = 368088311L;

    /**
     * Constructor
     */
      public StratifierGroupComponentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public StratifierGroupComponentComponent(CodeableConcept code, DataType value) {
        super();
        this.setCode(code);
        this.setValue(value);
      }

        /**
         * @return {@link #linkId} (The stratifier component from the Measure that corresponds to this stratifier component in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StratifierGroupComponentComponent.linkId");
            else if (Configuration.doAutoCreate())
              this.linkId = new StringType(); // bb
          return this.linkId;
        }

        public boolean hasLinkIdElement() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        public boolean hasLinkId() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        /**
         * @param value {@link #linkId} (The stratifier component from the Measure that corresponds to this stratifier component in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StratifierGroupComponentComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return The stratifier component from the Measure that corresponds to this stratifier component in the MeasureReport resource.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value The stratifier component from the Measure that corresponds to this stratifier component in the MeasureReport resource.
         */
        public StratifierGroupComponentComponent setLinkId(String value) { 
          if (Utilities.noString(value))
            this.linkId = null;
          else {
            if (this.linkId == null)
              this.linkId = new StringType();
            this.linkId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #code} (The code for the stratum component value.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StratifierGroupComponentComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The code for the stratum component value.)
         */
        public StratifierGroupComponentComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #value} (The stratum component value.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The stratum component value.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The stratum component value.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The stratum component value.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (The stratum component value.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The stratum component value.)
         */
        public Reference getValueReference() throws FHIRException { 
          if (this.value == null)
            this.value = new Reference();
          if (!(this.value instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Reference) this.value;
        }

        public boolean hasValueReference() { 
          return this != null && this.value instanceof Reference;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The stratum component value.)
         */
        public StratifierGroupComponentComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof BooleanType || value instanceof Quantity || value instanceof Range || value instanceof Reference))
            throw new FHIRException("Not the right type for MeasureReport.group.stratifier.stratum.component.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "The stratifier component from the Measure that corresponds to this stratifier component in the MeasureReport resource.", 0, 1, linkId));
          children.add(new Property("code", "CodeableConcept", "The code for the stratum component value.", 0, 1, code));
          children.add(new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The stratum component value.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "The stratifier component from the Measure that corresponds to this stratifier component in the MeasureReport resource.", 0, 1, linkId);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The code for the stratum component value.", 0, 1, code);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The stratum component value.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference", "The stratum component value.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The stratum component value.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The stratum component value.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The stratum component value.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The stratum component value.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "The stratum component value.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // StringType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("value[x]")) {
          this.value = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case 3059181:  return getCode();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"string"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "boolean", "Quantity", "Range", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.group.stratifier.stratum.component.linkId");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public StratifierGroupComponentComponent copy() {
        StratifierGroupComponentComponent dst = new StratifierGroupComponentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StratifierGroupComponentComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StratifierGroupComponentComponent))
          return false;
        StratifierGroupComponentComponent o = (StratifierGroupComponentComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(code, o.code, true) && compareDeep(value, o.value, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StratifierGroupComponentComponent))
          return false;
        StratifierGroupComponentComponent o = (StratifierGroupComponentComponent) other_;
        return compareValues(linkId, o.linkId, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, code, value);
      }

  public String fhirType() {
    return "MeasureReport.group.stratifier.stratum.component";

  }

  }

    @Block()
    public static class StratifierGroupPopulationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The population from the Measure that corresponds to this population in the MeasureReport resource.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pointer to specific population from Measure", formalDefinition="The population from the Measure that corresponds to this population in the MeasureReport resource." )
        protected StringType linkId;

        /**
         * The type of the population.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="initial-population | numerator | numerator-exclusion | denominator | denominator-exclusion | denominator-exception | measure-population | measure-population-exclusion | measure-observation", formalDefinition="The type of the population." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measure-population")
        protected CodeableConcept code;

        /**
         * The number of members of the population in this stratum.
         */
        @Child(name = "count", type = {IntegerType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Size of the population", formalDefinition="The number of members of the population in this stratum." )
        protected IntegerType count;

        /**
         * This element refers to a List of individual level MeasureReport resources, one for each subject in this population in this stratum.
         */
        @Child(name = "subjectResults", type = {ListResource.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="For subject-list reports, the subject results in this population", formalDefinition="This element refers to a List of individual level MeasureReport resources, one for each subject in this population in this stratum." )
        protected Reference subjectResults;

        /**
         * A reference to an individual level MeasureReport resource for a member of the population.
         */
        @Child(name = "subjectReport", type = {MeasureReport.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="For subject-list reports, a subject result in this population", formalDefinition="A reference to an individual level MeasureReport resource for a member of the population." )
        protected List<Reference> subjectReport;

        /**
         * Optional Group identifying the individuals that make up the population.
         */
        @Child(name = "subjects", type = {Group.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What individual(s) in the population", formalDefinition="Optional Group identifying the individuals that make up the population." )
        protected Reference subjects;

        private static final long serialVersionUID = -203678073L;

    /**
     * Constructor
     */
      public StratifierGroupPopulationComponent() {
        super();
      }

        /**
         * @return {@link #linkId} (The population from the Measure that corresponds to this population in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StratifierGroupPopulationComponent.linkId");
            else if (Configuration.doAutoCreate())
              this.linkId = new StringType(); // bb
          return this.linkId;
        }

        public boolean hasLinkIdElement() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        public boolean hasLinkId() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        /**
         * @param value {@link #linkId} (The population from the Measure that corresponds to this population in the MeasureReport resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StratifierGroupPopulationComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return The population from the Measure that corresponds to this population in the MeasureReport resource.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value The population from the Measure that corresponds to this population in the MeasureReport resource.
         */
        public StratifierGroupPopulationComponent setLinkId(String value) { 
          if (Utilities.noString(value))
            this.linkId = null;
          else {
            if (this.linkId == null)
              this.linkId = new StringType();
            this.linkId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #code} (The type of the population.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StratifierGroupPopulationComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The type of the population.)
         */
        public StratifierGroupPopulationComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #count} (The number of members of the population in this stratum.). This is the underlying object with id, value and extensions. The accessor "getCount" gives direct access to the value
         */
        public IntegerType getCountElement() { 
          if (this.count == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StratifierGroupPopulationComponent.count");
            else if (Configuration.doAutoCreate())
              this.count = new IntegerType(); // bb
          return this.count;
        }

        public boolean hasCountElement() { 
          return this.count != null && !this.count.isEmpty();
        }

        public boolean hasCount() { 
          return this.count != null && !this.count.isEmpty();
        }

        /**
         * @param value {@link #count} (The number of members of the population in this stratum.). This is the underlying object with id, value and extensions. The accessor "getCount" gives direct access to the value
         */
        public StratifierGroupPopulationComponent setCountElement(IntegerType value) { 
          this.count = value;
          return this;
        }

        /**
         * @return The number of members of the population in this stratum.
         */
        public int getCount() { 
          return this.count == null || this.count.isEmpty() ? 0 : this.count.getValue();
        }

        /**
         * @param value The number of members of the population in this stratum.
         */
        public StratifierGroupPopulationComponent setCount(int value) { 
            if (this.count == null)
              this.count = new IntegerType();
            this.count.setValue(value);
          return this;
        }

        /**
         * @return {@link #subjectResults} (This element refers to a List of individual level MeasureReport resources, one for each subject in this population in this stratum.)
         */
        public Reference getSubjectResults() { 
          if (this.subjectResults == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StratifierGroupPopulationComponent.subjectResults");
            else if (Configuration.doAutoCreate())
              this.subjectResults = new Reference(); // cc
          return this.subjectResults;
        }

        public boolean hasSubjectResults() { 
          return this.subjectResults != null && !this.subjectResults.isEmpty();
        }

        /**
         * @param value {@link #subjectResults} (This element refers to a List of individual level MeasureReport resources, one for each subject in this population in this stratum.)
         */
        public StratifierGroupPopulationComponent setSubjectResults(Reference value) { 
          this.subjectResults = value;
          return this;
        }

        /**
         * @return {@link #subjectReport} (A reference to an individual level MeasureReport resource for a member of the population.)
         */
        public List<Reference> getSubjectReport() { 
          if (this.subjectReport == null)
            this.subjectReport = new ArrayList<Reference>();
          return this.subjectReport;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StratifierGroupPopulationComponent setSubjectReport(List<Reference> theSubjectReport) { 
          this.subjectReport = theSubjectReport;
          return this;
        }

        public boolean hasSubjectReport() { 
          if (this.subjectReport == null)
            return false;
          for (Reference item : this.subjectReport)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSubjectReport() { //3
          Reference t = new Reference();
          if (this.subjectReport == null)
            this.subjectReport = new ArrayList<Reference>();
          this.subjectReport.add(t);
          return t;
        }

        public StratifierGroupPopulationComponent addSubjectReport(Reference t) { //3
          if (t == null)
            return this;
          if (this.subjectReport == null)
            this.subjectReport = new ArrayList<Reference>();
          this.subjectReport.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #subjectReport}, creating it if it does not already exist {3}
         */
        public Reference getSubjectReportFirstRep() { 
          if (getSubjectReport().isEmpty()) {
            addSubjectReport();
          }
          return getSubjectReport().get(0);
        }

        /**
         * @return {@link #subjects} (Optional Group identifying the individuals that make up the population.)
         */
        public Reference getSubjects() { 
          if (this.subjects == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StratifierGroupPopulationComponent.subjects");
            else if (Configuration.doAutoCreate())
              this.subjects = new Reference(); // cc
          return this.subjects;
        }

        public boolean hasSubjects() { 
          return this.subjects != null && !this.subjects.isEmpty();
        }

        /**
         * @param value {@link #subjects} (Optional Group identifying the individuals that make up the population.)
         */
        public StratifierGroupPopulationComponent setSubjects(Reference value) { 
          this.subjects = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "The population from the Measure that corresponds to this population in the MeasureReport resource.", 0, 1, linkId));
          children.add(new Property("code", "CodeableConcept", "The type of the population.", 0, 1, code));
          children.add(new Property("count", "integer", "The number of members of the population in this stratum.", 0, 1, count));
          children.add(new Property("subjectResults", "Reference(List)", "This element refers to a List of individual level MeasureReport resources, one for each subject in this population in this stratum.", 0, 1, subjectResults));
          children.add(new Property("subjectReport", "Reference(MeasureReport)", "A reference to an individual level MeasureReport resource for a member of the population.", 0, java.lang.Integer.MAX_VALUE, subjectReport));
          children.add(new Property("subjects", "Reference(Group)", "Optional Group identifying the individuals that make up the population.", 0, 1, subjects));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "The population from the Measure that corresponds to this population in the MeasureReport resource.", 0, 1, linkId);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The type of the population.", 0, 1, code);
          case 94851343: /*count*/  return new Property("count", "integer", "The number of members of the population in this stratum.", 0, 1, count);
          case 2136184106: /*subjectResults*/  return new Property("subjectResults", "Reference(List)", "This element refers to a List of individual level MeasureReport resources, one for each subject in this population in this stratum.", 0, 1, subjectResults);
          case 68814208: /*subjectReport*/  return new Property("subjectReport", "Reference(MeasureReport)", "A reference to an individual level MeasureReport resource for a member of the population.", 0, java.lang.Integer.MAX_VALUE, subjectReport);
          case -2069868345: /*subjects*/  return new Property("subjects", "Reference(Group)", "Optional Group identifying the individuals that make up the population.", 0, 1, subjects);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // StringType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 94851343: /*count*/ return this.count == null ? new Base[0] : new Base[] {this.count}; // IntegerType
        case 2136184106: /*subjectResults*/ return this.subjectResults == null ? new Base[0] : new Base[] {this.subjectResults}; // Reference
        case 68814208: /*subjectReport*/ return this.subjectReport == null ? new Base[0] : this.subjectReport.toArray(new Base[this.subjectReport.size()]); // Reference
        case -2069868345: /*subjects*/ return this.subjects == null ? new Base[0] : new Base[] {this.subjects}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 94851343: // count
          this.count = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 2136184106: // subjectResults
          this.subjectResults = TypeConvertor.castToReference(value); // Reference
          return value;
        case 68814208: // subjectReport
          this.getSubjectReport().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -2069868345: // subjects
          this.subjects = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("count")) {
          this.count = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("subjectResults")) {
          this.subjectResults = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("subjectReport")) {
          this.getSubjectReport().add(TypeConvertor.castToReference(value));
        } else if (name.equals("subjects")) {
          this.subjects = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("count")) {
          this.count = null;
        } else if (name.equals("subjectResults")) {
          this.subjectResults = null;
        } else if (name.equals("subjectReport")) {
          this.getSubjectReport().remove(value);
        } else if (name.equals("subjects")) {
          this.subjects = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case 3059181:  return getCode();
        case 94851343:  return getCountElement();
        case 2136184106:  return getSubjectResults();
        case 68814208:  return addSubjectReport(); 
        case -2069868345:  return getSubjects();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"string"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 94851343: /*count*/ return new String[] {"integer"};
        case 2136184106: /*subjectResults*/ return new String[] {"Reference"};
        case 68814208: /*subjectReport*/ return new String[] {"Reference"};
        case -2069868345: /*subjects*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.group.stratifier.stratum.population.linkId");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("count")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.group.stratifier.stratum.population.count");
        }
        else if (name.equals("subjectResults")) {
          this.subjectResults = new Reference();
          return this.subjectResults;
        }
        else if (name.equals("subjectReport")) {
          return addSubjectReport();
        }
        else if (name.equals("subjects")) {
          this.subjects = new Reference();
          return this.subjects;
        }
        else
          return super.addChild(name);
      }

      public StratifierGroupPopulationComponent copy() {
        StratifierGroupPopulationComponent dst = new StratifierGroupPopulationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StratifierGroupPopulationComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.code = code == null ? null : code.copy();
        dst.count = count == null ? null : count.copy();
        dst.subjectResults = subjectResults == null ? null : subjectResults.copy();
        if (subjectReport != null) {
          dst.subjectReport = new ArrayList<Reference>();
          for (Reference i : subjectReport)
            dst.subjectReport.add(i.copy());
        };
        dst.subjects = subjects == null ? null : subjects.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StratifierGroupPopulationComponent))
          return false;
        StratifierGroupPopulationComponent o = (StratifierGroupPopulationComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(code, o.code, true) && compareDeep(count, o.count, true)
           && compareDeep(subjectResults, o.subjectResults, true) && compareDeep(subjectReport, o.subjectReport, true)
           && compareDeep(subjects, o.subjects, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StratifierGroupPopulationComponent))
          return false;
        StratifierGroupPopulationComponent o = (StratifierGroupPopulationComponent) other_;
        return compareValues(linkId, o.linkId, true) && compareValues(count, o.count, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, code, count, subjectResults
          , subjectReport, subjects);
      }

  public String fhirType() {
    return "MeasureReport.group.stratifier.stratum.population";

  }

  }

    /**
     * A formal identifier that is used to identify this MeasureReport when it is represented in other formats or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the MeasureReport", formalDefinition="A formal identifier that is used to identify this MeasureReport when it is represented in other formats or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The MeasureReport status. No data will be available until the MeasureReport status is complete.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="complete | pending | error", formalDefinition="The MeasureReport status. No data will be available until the MeasureReport status is complete." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measure-report-status")
    protected Enumeration<MeasureReportStatus> status;

    /**
     * The type of measure report. This may be an individual report, which provides the score for the measure for an individual member of the population; a subject-listing, which returns the list of members that meet the various criteria in the measure; a summary report, which returns a population count for each of the criteria in the measure; or a data-collection, which enables the MeasureReport to be used to exchange the data-of-interest for a quality measure.
     */
    @Child(name = "type", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="individual | subject-list | summary | data-exchange", formalDefinition="The type of measure report. This may be an individual report, which provides the score for the measure for an individual member of the population; a subject-listing, which returns the list of members that meet the various criteria in the measure; a summary report, which returns a population count for each of the criteria in the measure; or a data-collection, which enables the MeasureReport to be used to exchange the data-of-interest for a quality measure." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measure-report-type")
    protected Enumeration<MeasureReportType> type;

    /**
     * Indicates whether the data submitted in a data-exchange report represents a snapshot or incremental update. A snapshot update replaces all previously submitted data for the receiver, whereas an incremental update represents only updated and/or changed data and should be applied as a differential update to the existing submitted data for the receiver.
     */
    @Child(name = "dataUpdateType", type = {CodeType.class}, order=3, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="incremental | snapshot", formalDefinition="Indicates whether the data submitted in a data-exchange report represents a snapshot or incremental update. A snapshot update replaces all previously submitted data for the receiver, whereas an incremental update represents only updated and/or changed data and should be applied as a differential update to the existing submitted data for the receiver." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/submit-data-update-type")
    protected Enumeration<SubmitDataUpdateType> dataUpdateType;

    /**
     * A reference to the Measure that was calculated to produce this report.
     */
    @Child(name = "measure", type = {CanonicalType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What measure was calculated", formalDefinition="A reference to the Measure that was calculated to produce this report." )
    protected CanonicalType measure;

    /**
     * Optional subject identifying the individual or individuals the report is for.
     */
    @Child(name = "subject", type = {CareTeam.class, Device.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What individual(s) the report is for", formalDefinition="Optional subject identifying the individual or individuals the report is for." )
    protected Reference subject;

    /**
     * The date this measure was calculated.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the measure was calculated", formalDefinition="The date this measure was calculated." )
    protected DateTimeType date;

    /**
     * The individual or organization that is reporting the data.
     */
    @Child(name = "reporter", type = {Practitioner.class, PractitionerRole.class, Organization.class, Group.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who is reporting the data", formalDefinition="The individual or organization that is reporting the data." )
    protected Reference reporter;

    /**
     * A reference to the vendor who queried the data, calculated results and/or generated the report. The ‘reporting vendor’ is intended to represent the submitting entity when it is not the same as the reporting entity. This extension is used when the Receiver is interested in getting vendor information in the report.
     */
    @Child(name = "reportingVendor", type = {Organization.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What vendor prepared the data", formalDefinition="A reference to the vendor who queried the data, calculated results and/or generated the report. The ‘reporting vendor’ is intended to represent the submitting entity when it is not the same as the reporting entity. This extension is used when the Receiver is interested in getting vendor information in the report." )
    protected Reference reportingVendor;

    /**
     * A reference to the location for which the data is being reported.
     */
    @Child(name = "location", type = {Location.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the reported data is from", formalDefinition="A reference to the location for which the data is being reported." )
    protected Reference location;

    /**
     * The reporting period for which the report was calculated.
     */
    @Child(name = "period", type = {Period.class}, order=10, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What period the report covers", formalDefinition="The reporting period for which the report was calculated." )
    protected Period period;

    /**
     * A reference to a Parameters resource (typically represented using a contained resource) that represents any input parameters that were provided to the operation that generated the report.
     */
    @Child(name = "inputParameters", type = {Parameters.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What parameters were provided to the report", formalDefinition="A reference to a Parameters resource (typically represented using a contained resource) that represents any input parameters that were provided to the operation that generated the report." )
    protected Reference inputParameters;

    /**
     * Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented. It is expected to be the same as the scoring element on the referenced Measure.
     */
    @Child(name = "scoring", type = {CodeableConcept.class}, order=12, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="What scoring method (e.g. proportion, ratio, continuous-variable)", formalDefinition="Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented. It is expected to be the same as the scoring element on the referenced Measure." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/measure-scoring")
    protected CodeableConcept scoring;

    /**
     * Whether improvement in the measure is noted by an increase or decrease in the measure score.
     */
    @Child(name = "improvementNotation", type = {CodeableConcept.class}, order=13, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="increase | decrease", formalDefinition="Whether improvement in the measure is noted by an increase or decrease in the measure score." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/measure-improvement-notation")
    protected CodeableConcept improvementNotation;

    /**
     * The results of the calculation, one for each population group in the measure.
     */
    @Child(name = "group", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Measure results for each group", formalDefinition="The results of the calculation, one for each population group in the measure." )
    protected List<MeasureReportGroupComponent> group;

    /**
     * A reference to a Resource that represents additional information collected for the report. If the value of the supplemental data is not a Resource (i.e. evaluating the supplementalData expression for this case in the measure results in a value that is not a FHIR Resource), it is reported as a reference to a contained Observation resource.
     */
    @Child(name = "supplementalData", type = {Reference.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional information collected for the report", formalDefinition="A reference to a Resource that represents additional information collected for the report. If the value of the supplemental data is not a Resource (i.e. evaluating the supplementalData expression for this case in the measure results in a value that is not a FHIR Resource), it is reported as a reference to a contained Observation resource." )
    protected List<Reference> supplementalData;

    /**
     * Evaluated resources are used to capture what data was involved in the calculation of a measure. This usage is only allowed for individual reports to ensure that the size of the MeasureReport resource is bounded.
     */
    @Child(name = "evaluatedResource", type = {Reference.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What data was used to calculate the measure score", formalDefinition="Evaluated resources are used to capture what data was involved in the calculation of a measure. This usage is only allowed for individual reports to ensure that the size of the MeasureReport resource is bounded." )
    protected List<Reference> evaluatedResource;

    private static final long serialVersionUID = 962133374L;

  /**
   * Constructor
   */
    public MeasureReport() {
      super();
    }

  /**
   * Constructor
   */
    public MeasureReport(MeasureReportStatus status, MeasureReportType type, Period period) {
      super();
      this.setStatus(status);
      this.setType(type);
      this.setPeriod(period);
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this MeasureReport when it is represented in other formats or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MeasureReport setIdentifier(List<Identifier> theIdentifier) { 
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

    public MeasureReport addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The MeasureReport status. No data will be available until the MeasureReport status is complete.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<MeasureReportStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<MeasureReportStatus>(new MeasureReportStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The MeasureReport status. No data will be available until the MeasureReport status is complete.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public MeasureReport setStatusElement(Enumeration<MeasureReportStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The MeasureReport status. No data will be available until the MeasureReport status is complete.
     */
    public MeasureReportStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The MeasureReport status. No data will be available until the MeasureReport status is complete.
     */
    public MeasureReport setStatus(MeasureReportStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<MeasureReportStatus>(new MeasureReportStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #type} (The type of measure report. This may be an individual report, which provides the score for the measure for an individual member of the population; a subject-listing, which returns the list of members that meet the various criteria in the measure; a summary report, which returns a population count for each of the criteria in the measure; or a data-collection, which enables the MeasureReport to be used to exchange the data-of-interest for a quality measure.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<MeasureReportType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<MeasureReportType>(new MeasureReportTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The type of measure report. This may be an individual report, which provides the score for the measure for an individual member of the population; a subject-listing, which returns the list of members that meet the various criteria in the measure; a summary report, which returns a population count for each of the criteria in the measure; or a data-collection, which enables the MeasureReport to be used to exchange the data-of-interest for a quality measure.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public MeasureReport setTypeElement(Enumeration<MeasureReportType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return The type of measure report. This may be an individual report, which provides the score for the measure for an individual member of the population; a subject-listing, which returns the list of members that meet the various criteria in the measure; a summary report, which returns a population count for each of the criteria in the measure; or a data-collection, which enables the MeasureReport to be used to exchange the data-of-interest for a quality measure.
     */
    public MeasureReportType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value The type of measure report. This may be an individual report, which provides the score for the measure for an individual member of the population; a subject-listing, which returns the list of members that meet the various criteria in the measure; a summary report, which returns a population count for each of the criteria in the measure; or a data-collection, which enables the MeasureReport to be used to exchange the data-of-interest for a quality measure.
     */
    public MeasureReport setType(MeasureReportType value) { 
        if (this.type == null)
          this.type = new Enumeration<MeasureReportType>(new MeasureReportTypeEnumFactory());
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #dataUpdateType} (Indicates whether the data submitted in a data-exchange report represents a snapshot or incremental update. A snapshot update replaces all previously submitted data for the receiver, whereas an incremental update represents only updated and/or changed data and should be applied as a differential update to the existing submitted data for the receiver.). This is the underlying object with id, value and extensions. The accessor "getDataUpdateType" gives direct access to the value
     */
    public Enumeration<SubmitDataUpdateType> getDataUpdateTypeElement() { 
      if (this.dataUpdateType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.dataUpdateType");
        else if (Configuration.doAutoCreate())
          this.dataUpdateType = new Enumeration<SubmitDataUpdateType>(new SubmitDataUpdateTypeEnumFactory()); // bb
      return this.dataUpdateType;
    }

    public boolean hasDataUpdateTypeElement() { 
      return this.dataUpdateType != null && !this.dataUpdateType.isEmpty();
    }

    public boolean hasDataUpdateType() { 
      return this.dataUpdateType != null && !this.dataUpdateType.isEmpty();
    }

    /**
     * @param value {@link #dataUpdateType} (Indicates whether the data submitted in a data-exchange report represents a snapshot or incremental update. A snapshot update replaces all previously submitted data for the receiver, whereas an incremental update represents only updated and/or changed data and should be applied as a differential update to the existing submitted data for the receiver.). This is the underlying object with id, value and extensions. The accessor "getDataUpdateType" gives direct access to the value
     */
    public MeasureReport setDataUpdateTypeElement(Enumeration<SubmitDataUpdateType> value) { 
      this.dataUpdateType = value;
      return this;
    }

    /**
     * @return Indicates whether the data submitted in a data-exchange report represents a snapshot or incremental update. A snapshot update replaces all previously submitted data for the receiver, whereas an incremental update represents only updated and/or changed data and should be applied as a differential update to the existing submitted data for the receiver.
     */
    public SubmitDataUpdateType getDataUpdateType() { 
      return this.dataUpdateType == null ? null : this.dataUpdateType.getValue();
    }

    /**
     * @param value Indicates whether the data submitted in a data-exchange report represents a snapshot or incremental update. A snapshot update replaces all previously submitted data for the receiver, whereas an incremental update represents only updated and/or changed data and should be applied as a differential update to the existing submitted data for the receiver.
     */
    public MeasureReport setDataUpdateType(SubmitDataUpdateType value) { 
      if (value == null)
        this.dataUpdateType = null;
      else {
        if (this.dataUpdateType == null)
          this.dataUpdateType = new Enumeration<SubmitDataUpdateType>(new SubmitDataUpdateTypeEnumFactory());
        this.dataUpdateType.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #measure} (A reference to the Measure that was calculated to produce this report.). This is the underlying object with id, value and extensions. The accessor "getMeasure" gives direct access to the value
     */
    public CanonicalType getMeasureElement() { 
      if (this.measure == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.measure");
        else if (Configuration.doAutoCreate())
          this.measure = new CanonicalType(); // bb
      return this.measure;
    }

    public boolean hasMeasureElement() { 
      return this.measure != null && !this.measure.isEmpty();
    }

    public boolean hasMeasure() { 
      return this.measure != null && !this.measure.isEmpty();
    }

    /**
     * @param value {@link #measure} (A reference to the Measure that was calculated to produce this report.). This is the underlying object with id, value and extensions. The accessor "getMeasure" gives direct access to the value
     */
    public MeasureReport setMeasureElement(CanonicalType value) { 
      this.measure = value;
      return this;
    }

    /**
     * @return A reference to the Measure that was calculated to produce this report.
     */
    public String getMeasure() { 
      return this.measure == null ? null : this.measure.getValue();
    }

    /**
     * @param value A reference to the Measure that was calculated to produce this report.
     */
    public MeasureReport setMeasure(String value) { 
      if (Utilities.noString(value))
        this.measure = null;
      else {
        if (this.measure == null)
          this.measure = new CanonicalType();
        this.measure.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subject} (Optional subject identifying the individual or individuals the report is for.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Optional subject identifying the individual or individuals the report is for.)
     */
    public MeasureReport setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #date} (The date this measure was calculated.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.date");
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
     * @param value {@link #date} (The date this measure was calculated.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public MeasureReport setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date this measure was calculated.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date this measure was calculated.
     */
    public MeasureReport setDate(Date value) { 
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
     * @return {@link #reporter} (The individual or organization that is reporting the data.)
     */
    public Reference getReporter() { 
      if (this.reporter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.reporter");
        else if (Configuration.doAutoCreate())
          this.reporter = new Reference(); // cc
      return this.reporter;
    }

    public boolean hasReporter() { 
      return this.reporter != null && !this.reporter.isEmpty();
    }

    /**
     * @param value {@link #reporter} (The individual or organization that is reporting the data.)
     */
    public MeasureReport setReporter(Reference value) { 
      this.reporter = value;
      return this;
    }

    /**
     * @return {@link #reportingVendor} (A reference to the vendor who queried the data, calculated results and/or generated the report. The ‘reporting vendor’ is intended to represent the submitting entity when it is not the same as the reporting entity. This extension is used when the Receiver is interested in getting vendor information in the report.)
     */
    public Reference getReportingVendor() { 
      if (this.reportingVendor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.reportingVendor");
        else if (Configuration.doAutoCreate())
          this.reportingVendor = new Reference(); // cc
      return this.reportingVendor;
    }

    public boolean hasReportingVendor() { 
      return this.reportingVendor != null && !this.reportingVendor.isEmpty();
    }

    /**
     * @param value {@link #reportingVendor} (A reference to the vendor who queried the data, calculated results and/or generated the report. The ‘reporting vendor’ is intended to represent the submitting entity when it is not the same as the reporting entity. This extension is used when the Receiver is interested in getting vendor information in the report.)
     */
    public MeasureReport setReportingVendor(Reference value) { 
      this.reportingVendor = value;
      return this;
    }

    /**
     * @return {@link #location} (A reference to the location for which the data is being reported.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (A reference to the location for which the data is being reported.)
     */
    public MeasureReport setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #period} (The reporting period for which the report was calculated.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The reporting period for which the report was calculated.)
     */
    public MeasureReport setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #inputParameters} (A reference to a Parameters resource (typically represented using a contained resource) that represents any input parameters that were provided to the operation that generated the report.)
     */
    public Reference getInputParameters() { 
      if (this.inputParameters == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.inputParameters");
        else if (Configuration.doAutoCreate())
          this.inputParameters = new Reference(); // cc
      return this.inputParameters;
    }

    public boolean hasInputParameters() { 
      return this.inputParameters != null && !this.inputParameters.isEmpty();
    }

    /**
     * @param value {@link #inputParameters} (A reference to a Parameters resource (typically represented using a contained resource) that represents any input parameters that were provided to the operation that generated the report.)
     */
    public MeasureReport setInputParameters(Reference value) { 
      this.inputParameters = value;
      return this;
    }

    /**
     * @return {@link #scoring} (Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented. It is expected to be the same as the scoring element on the referenced Measure.)
     */
    public CodeableConcept getScoring() { 
      if (this.scoring == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.scoring");
        else if (Configuration.doAutoCreate())
          this.scoring = new CodeableConcept(); // cc
      return this.scoring;
    }

    public boolean hasScoring() { 
      return this.scoring != null && !this.scoring.isEmpty();
    }

    /**
     * @param value {@link #scoring} (Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented. It is expected to be the same as the scoring element on the referenced Measure.)
     */
    public MeasureReport setScoring(CodeableConcept value) { 
      this.scoring = value;
      return this;
    }

    /**
     * @return {@link #improvementNotation} (Whether improvement in the measure is noted by an increase or decrease in the measure score.)
     */
    public CodeableConcept getImprovementNotation() { 
      if (this.improvementNotation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MeasureReport.improvementNotation");
        else if (Configuration.doAutoCreate())
          this.improvementNotation = new CodeableConcept(); // cc
      return this.improvementNotation;
    }

    public boolean hasImprovementNotation() { 
      return this.improvementNotation != null && !this.improvementNotation.isEmpty();
    }

    /**
     * @param value {@link #improvementNotation} (Whether improvement in the measure is noted by an increase or decrease in the measure score.)
     */
    public MeasureReport setImprovementNotation(CodeableConcept value) { 
      this.improvementNotation = value;
      return this;
    }

    /**
     * @return {@link #group} (The results of the calculation, one for each population group in the measure.)
     */
    public List<MeasureReportGroupComponent> getGroup() { 
      if (this.group == null)
        this.group = new ArrayList<MeasureReportGroupComponent>();
      return this.group;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MeasureReport setGroup(List<MeasureReportGroupComponent> theGroup) { 
      this.group = theGroup;
      return this;
    }

    public boolean hasGroup() { 
      if (this.group == null)
        return false;
      for (MeasureReportGroupComponent item : this.group)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MeasureReportGroupComponent addGroup() { //3
      MeasureReportGroupComponent t = new MeasureReportGroupComponent();
      if (this.group == null)
        this.group = new ArrayList<MeasureReportGroupComponent>();
      this.group.add(t);
      return t;
    }

    public MeasureReport addGroup(MeasureReportGroupComponent t) { //3
      if (t == null)
        return this;
      if (this.group == null)
        this.group = new ArrayList<MeasureReportGroupComponent>();
      this.group.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #group}, creating it if it does not already exist {3}
     */
    public MeasureReportGroupComponent getGroupFirstRep() { 
      if (getGroup().isEmpty()) {
        addGroup();
      }
      return getGroup().get(0);
    }

    /**
     * @return {@link #supplementalData} (A reference to a Resource that represents additional information collected for the report. If the value of the supplemental data is not a Resource (i.e. evaluating the supplementalData expression for this case in the measure results in a value that is not a FHIR Resource), it is reported as a reference to a contained Observation resource.)
     */
    public List<Reference> getSupplementalData() { 
      if (this.supplementalData == null)
        this.supplementalData = new ArrayList<Reference>();
      return this.supplementalData;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MeasureReport setSupplementalData(List<Reference> theSupplementalData) { 
      this.supplementalData = theSupplementalData;
      return this;
    }

    public boolean hasSupplementalData() { 
      if (this.supplementalData == null)
        return false;
      for (Reference item : this.supplementalData)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupplementalData() { //3
      Reference t = new Reference();
      if (this.supplementalData == null)
        this.supplementalData = new ArrayList<Reference>();
      this.supplementalData.add(t);
      return t;
    }

    public MeasureReport addSupplementalData(Reference t) { //3
      if (t == null)
        return this;
      if (this.supplementalData == null)
        this.supplementalData = new ArrayList<Reference>();
      this.supplementalData.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supplementalData}, creating it if it does not already exist {3}
     */
    public Reference getSupplementalDataFirstRep() { 
      if (getSupplementalData().isEmpty()) {
        addSupplementalData();
      }
      return getSupplementalData().get(0);
    }

    /**
     * @return {@link #evaluatedResource} (Evaluated resources are used to capture what data was involved in the calculation of a measure. This usage is only allowed for individual reports to ensure that the size of the MeasureReport resource is bounded.)
     */
    public List<Reference> getEvaluatedResource() { 
      if (this.evaluatedResource == null)
        this.evaluatedResource = new ArrayList<Reference>();
      return this.evaluatedResource;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MeasureReport setEvaluatedResource(List<Reference> theEvaluatedResource) { 
      this.evaluatedResource = theEvaluatedResource;
      return this;
    }

    public boolean hasEvaluatedResource() { 
      if (this.evaluatedResource == null)
        return false;
      for (Reference item : this.evaluatedResource)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEvaluatedResource() { //3
      Reference t = new Reference();
      if (this.evaluatedResource == null)
        this.evaluatedResource = new ArrayList<Reference>();
      this.evaluatedResource.add(t);
      return t;
    }

    public MeasureReport addEvaluatedResource(Reference t) { //3
      if (t == null)
        return this;
      if (this.evaluatedResource == null)
        this.evaluatedResource = new ArrayList<Reference>();
      this.evaluatedResource.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #evaluatedResource}, creating it if it does not already exist {3}
     */
    public Reference getEvaluatedResourceFirstRep() { 
      if (getEvaluatedResource().isEmpty()) {
        addEvaluatedResource();
      }
      return getEvaluatedResource().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this MeasureReport when it is represented in other formats or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The MeasureReport status. No data will be available until the MeasureReport status is complete.", 0, 1, status));
        children.add(new Property("type", "code", "The type of measure report. This may be an individual report, which provides the score for the measure for an individual member of the population; a subject-listing, which returns the list of members that meet the various criteria in the measure; a summary report, which returns a population count for each of the criteria in the measure; or a data-collection, which enables the MeasureReport to be used to exchange the data-of-interest for a quality measure.", 0, 1, type));
        children.add(new Property("dataUpdateType", "code", "Indicates whether the data submitted in a data-exchange report represents a snapshot or incremental update. A snapshot update replaces all previously submitted data for the receiver, whereas an incremental update represents only updated and/or changed data and should be applied as a differential update to the existing submitted data for the receiver.", 0, 1, dataUpdateType));
        children.add(new Property("measure", "canonical(Measure)", "A reference to the Measure that was calculated to produce this report.", 0, 1, measure));
        children.add(new Property("subject", "Reference(CareTeam|Device|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "Optional subject identifying the individual or individuals the report is for.", 0, 1, subject));
        children.add(new Property("date", "dateTime", "The date this measure was calculated.", 0, 1, date));
        children.add(new Property("reporter", "Reference(Practitioner|PractitionerRole|Organization|Group)", "The individual or organization that is reporting the data.", 0, 1, reporter));
        children.add(new Property("reportingVendor", "Reference(Organization)", "A reference to the vendor who queried the data, calculated results and/or generated the report. The ‘reporting vendor’ is intended to represent the submitting entity when it is not the same as the reporting entity. This extension is used when the Receiver is interested in getting vendor information in the report.", 0, 1, reportingVendor));
        children.add(new Property("location", "Reference(Location)", "A reference to the location for which the data is being reported.", 0, 1, location));
        children.add(new Property("period", "Period", "The reporting period for which the report was calculated.", 0, 1, period));
        children.add(new Property("inputParameters", "Reference(Parameters)", "A reference to a Parameters resource (typically represented using a contained resource) that represents any input parameters that were provided to the operation that generated the report.", 0, 1, inputParameters));
        children.add(new Property("scoring", "CodeableConcept", "Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented. It is expected to be the same as the scoring element on the referenced Measure.", 0, 1, scoring));
        children.add(new Property("improvementNotation", "CodeableConcept", "Whether improvement in the measure is noted by an increase or decrease in the measure score.", 0, 1, improvementNotation));
        children.add(new Property("group", "", "The results of the calculation, one for each population group in the measure.", 0, java.lang.Integer.MAX_VALUE, group));
        children.add(new Property("supplementalData", "Reference(Any)", "A reference to a Resource that represents additional information collected for the report. If the value of the supplemental data is not a Resource (i.e. evaluating the supplementalData expression for this case in the measure results in a value that is not a FHIR Resource), it is reported as a reference to a contained Observation resource.", 0, java.lang.Integer.MAX_VALUE, supplementalData));
        children.add(new Property("evaluatedResource", "Reference(Any)", "Evaluated resources are used to capture what data was involved in the calculation of a measure. This usage is only allowed for individual reports to ensure that the size of the MeasureReport resource is bounded.", 0, java.lang.Integer.MAX_VALUE, evaluatedResource));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this MeasureReport when it is represented in other formats or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The MeasureReport status. No data will be available until the MeasureReport status is complete.", 0, 1, status);
        case 3575610: /*type*/  return new Property("type", "code", "The type of measure report. This may be an individual report, which provides the score for the measure for an individual member of the population; a subject-listing, which returns the list of members that meet the various criteria in the measure; a summary report, which returns a population count for each of the criteria in the measure; or a data-collection, which enables the MeasureReport to be used to exchange the data-of-interest for a quality measure.", 0, 1, type);
        case -425890067: /*dataUpdateType*/  return new Property("dataUpdateType", "code", "Indicates whether the data submitted in a data-exchange report represents a snapshot or incremental update. A snapshot update replaces all previously submitted data for the receiver, whereas an incremental update represents only updated and/or changed data and should be applied as a differential update to the existing submitted data for the receiver.", 0, 1, dataUpdateType);
        case 938321246: /*measure*/  return new Property("measure", "canonical(Measure)", "A reference to the Measure that was calculated to produce this report.", 0, 1, measure);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(CareTeam|Device|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "Optional subject identifying the individual or individuals the report is for.", 0, 1, subject);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date this measure was calculated.", 0, 1, date);
        case -427039519: /*reporter*/  return new Property("reporter", "Reference(Practitioner|PractitionerRole|Organization|Group)", "The individual or organization that is reporting the data.", 0, 1, reporter);
        case 581336342: /*reportingVendor*/  return new Property("reportingVendor", "Reference(Organization)", "A reference to the vendor who queried the data, calculated results and/or generated the report. The ‘reporting vendor’ is intended to represent the submitting entity when it is not the same as the reporting entity. This extension is used when the Receiver is interested in getting vendor information in the report.", 0, 1, reportingVendor);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "A reference to the location for which the data is being reported.", 0, 1, location);
        case -991726143: /*period*/  return new Property("period", "Period", "The reporting period for which the report was calculated.", 0, 1, period);
        case -812039852: /*inputParameters*/  return new Property("inputParameters", "Reference(Parameters)", "A reference to a Parameters resource (typically represented using a contained resource) that represents any input parameters that were provided to the operation that generated the report.", 0, 1, inputParameters);
        case 1924005583: /*scoring*/  return new Property("scoring", "CodeableConcept", "Indicates how the calculation is performed for the measure, including proportion, ratio, continuous-variable, and cohort. The value set is extensible, allowing additional measure scoring types to be represented. It is expected to be the same as the scoring element on the referenced Measure.", 0, 1, scoring);
        case -2085456136: /*improvementNotation*/  return new Property("improvementNotation", "CodeableConcept", "Whether improvement in the measure is noted by an increase or decrease in the measure score.", 0, 1, improvementNotation);
        case 98629247: /*group*/  return new Property("group", "", "The results of the calculation, one for each population group in the measure.", 0, java.lang.Integer.MAX_VALUE, group);
        case 1447496814: /*supplementalData*/  return new Property("supplementalData", "Reference(Any)", "A reference to a Resource that represents additional information collected for the report. If the value of the supplemental data is not a Resource (i.e. evaluating the supplementalData expression for this case in the measure results in a value that is not a FHIR Resource), it is reported as a reference to a contained Observation resource.", 0, java.lang.Integer.MAX_VALUE, supplementalData);
        case -1056771047: /*evaluatedResource*/  return new Property("evaluatedResource", "Reference(Any)", "Evaluated resources are used to capture what data was involved in the calculation of a measure. This usage is only allowed for individual reports to ensure that the size of the MeasureReport resource is bounded.", 0, java.lang.Integer.MAX_VALUE, evaluatedResource);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<MeasureReportStatus>
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<MeasureReportType>
        case -425890067: /*dataUpdateType*/ return this.dataUpdateType == null ? new Base[0] : new Base[] {this.dataUpdateType}; // Enumeration<SubmitDataUpdateType>
        case 938321246: /*measure*/ return this.measure == null ? new Base[0] : new Base[] {this.measure}; // CanonicalType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case -427039519: /*reporter*/ return this.reporter == null ? new Base[0] : new Base[] {this.reporter}; // Reference
        case 581336342: /*reportingVendor*/ return this.reportingVendor == null ? new Base[0] : new Base[] {this.reportingVendor}; // Reference
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case -812039852: /*inputParameters*/ return this.inputParameters == null ? new Base[0] : new Base[] {this.inputParameters}; // Reference
        case 1924005583: /*scoring*/ return this.scoring == null ? new Base[0] : new Base[] {this.scoring}; // CodeableConcept
        case -2085456136: /*improvementNotation*/ return this.improvementNotation == null ? new Base[0] : new Base[] {this.improvementNotation}; // CodeableConcept
        case 98629247: /*group*/ return this.group == null ? new Base[0] : this.group.toArray(new Base[this.group.size()]); // MeasureReportGroupComponent
        case 1447496814: /*supplementalData*/ return this.supplementalData == null ? new Base[0] : this.supplementalData.toArray(new Base[this.supplementalData.size()]); // Reference
        case -1056771047: /*evaluatedResource*/ return this.evaluatedResource == null ? new Base[0] : this.evaluatedResource.toArray(new Base[this.evaluatedResource.size()]); // Reference
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
          value = new MeasureReportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MeasureReportStatus>
          return value;
        case 3575610: // type
          value = new MeasureReportTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<MeasureReportType>
          return value;
        case -425890067: // dataUpdateType
          value = new SubmitDataUpdateTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.dataUpdateType = (Enumeration) value; // Enumeration<SubmitDataUpdateType>
          return value;
        case 938321246: // measure
          this.measure = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -427039519: // reporter
          this.reporter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 581336342: // reportingVendor
          this.reportingVendor = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -812039852: // inputParameters
          this.inputParameters = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1924005583: // scoring
          this.scoring = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2085456136: // improvementNotation
          this.improvementNotation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 98629247: // group
          this.getGroup().add((MeasureReportGroupComponent) value); // MeasureReportGroupComponent
          return value;
        case 1447496814: // supplementalData
          this.getSupplementalData().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1056771047: // evaluatedResource
          this.getEvaluatedResource().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new MeasureReportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MeasureReportStatus>
        } else if (name.equals("type")) {
          value = new MeasureReportTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<MeasureReportType>
        } else if (name.equals("dataUpdateType")) {
          value = new SubmitDataUpdateTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.dataUpdateType = (Enumeration) value; // Enumeration<SubmitDataUpdateType>
        } else if (name.equals("measure")) {
          this.measure = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("reporter")) {
          this.reporter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reportingVendor")) {
          this.reportingVendor = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("inputParameters")) {
          this.inputParameters = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("scoring")) {
          this.scoring = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("improvementNotation")) {
          this.improvementNotation = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("group")) {
          this.getGroup().add((MeasureReportGroupComponent) value);
        } else if (name.equals("supplementalData")) {
          this.getSupplementalData().add(TypeConvertor.castToReference(value));
        } else if (name.equals("evaluatedResource")) {
          this.getEvaluatedResource().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("status")) {
          value = new MeasureReportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MeasureReportStatus>
        } else if (name.equals("type")) {
          value = new MeasureReportTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<MeasureReportType>
        } else if (name.equals("dataUpdateType")) {
          value = new SubmitDataUpdateTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.dataUpdateType = (Enumeration) value; // Enumeration<SubmitDataUpdateType>
        } else if (name.equals("measure")) {
          this.measure = null;
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("reporter")) {
          this.reporter = null;
        } else if (name.equals("reportingVendor")) {
          this.reportingVendor = null;
        } else if (name.equals("location")) {
          this.location = null;
        } else if (name.equals("period")) {
          this.period = null;
        } else if (name.equals("inputParameters")) {
          this.inputParameters = null;
        } else if (name.equals("scoring")) {
          this.scoring = null;
        } else if (name.equals("improvementNotation")) {
          this.improvementNotation = null;
        } else if (name.equals("group")) {
          this.getGroup().add((MeasureReportGroupComponent) value);
        } else if (name.equals("supplementalData")) {
          this.getSupplementalData().remove(value);
        } else if (name.equals("evaluatedResource")) {
          this.getEvaluatedResource().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 3575610:  return getTypeElement();
        case -425890067:  return getDataUpdateTypeElement();
        case 938321246:  return getMeasureElement();
        case -1867885268:  return getSubject();
        case 3076014:  return getDateElement();
        case -427039519:  return getReporter();
        case 581336342:  return getReportingVendor();
        case 1901043637:  return getLocation();
        case -991726143:  return getPeriod();
        case -812039852:  return getInputParameters();
        case 1924005583:  return getScoring();
        case -2085456136:  return getImprovementNotation();
        case 98629247:  return addGroup(); 
        case 1447496814:  return addSupplementalData(); 
        case -1056771047:  return addEvaluatedResource(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -425890067: /*dataUpdateType*/ return new String[] {"code"};
        case 938321246: /*measure*/ return new String[] {"canonical"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case -427039519: /*reporter*/ return new String[] {"Reference"};
        case 581336342: /*reportingVendor*/ return new String[] {"Reference"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case -812039852: /*inputParameters*/ return new String[] {"Reference"};
        case 1924005583: /*scoring*/ return new String[] {"CodeableConcept"};
        case -2085456136: /*improvementNotation*/ return new String[] {"CodeableConcept"};
        case 98629247: /*group*/ return new String[] {};
        case 1447496814: /*supplementalData*/ return new String[] {"Reference"};
        case -1056771047: /*evaluatedResource*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.status");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.type");
        }
        else if (name.equals("dataUpdateType")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.dataUpdateType");
        }
        else if (name.equals("measure")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.measure");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property MeasureReport.date");
        }
        else if (name.equals("reporter")) {
          this.reporter = new Reference();
          return this.reporter;
        }
        else if (name.equals("reportingVendor")) {
          this.reportingVendor = new Reference();
          return this.reportingVendor;
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("inputParameters")) {
          this.inputParameters = new Reference();
          return this.inputParameters;
        }
        else if (name.equals("scoring")) {
          this.scoring = new CodeableConcept();
          return this.scoring;
        }
        else if (name.equals("improvementNotation")) {
          this.improvementNotation = new CodeableConcept();
          return this.improvementNotation;
        }
        else if (name.equals("group")) {
          return addGroup();
        }
        else if (name.equals("supplementalData")) {
          return addSupplementalData();
        }
        else if (name.equals("evaluatedResource")) {
          return addEvaluatedResource();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MeasureReport";

  }

      public MeasureReport copy() {
        MeasureReport dst = new MeasureReport();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MeasureReport dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.type = type == null ? null : type.copy();
        dst.dataUpdateType = dataUpdateType == null ? null : dataUpdateType.copy();
        dst.measure = measure == null ? null : measure.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.date = date == null ? null : date.copy();
        dst.reporter = reporter == null ? null : reporter.copy();
        dst.reportingVendor = reportingVendor == null ? null : reportingVendor.copy();
        dst.location = location == null ? null : location.copy();
        dst.period = period == null ? null : period.copy();
        dst.inputParameters = inputParameters == null ? null : inputParameters.copy();
        dst.scoring = scoring == null ? null : scoring.copy();
        dst.improvementNotation = improvementNotation == null ? null : improvementNotation.copy();
        if (group != null) {
          dst.group = new ArrayList<MeasureReportGroupComponent>();
          for (MeasureReportGroupComponent i : group)
            dst.group.add(i.copy());
        };
        if (supplementalData != null) {
          dst.supplementalData = new ArrayList<Reference>();
          for (Reference i : supplementalData)
            dst.supplementalData.add(i.copy());
        };
        if (evaluatedResource != null) {
          dst.evaluatedResource = new ArrayList<Reference>();
          for (Reference i : evaluatedResource)
            dst.evaluatedResource.add(i.copy());
        };
      }

      protected MeasureReport typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MeasureReport))
          return false;
        MeasureReport o = (MeasureReport) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(type, o.type, true)
           && compareDeep(dataUpdateType, o.dataUpdateType, true) && compareDeep(measure, o.measure, true)
           && compareDeep(subject, o.subject, true) && compareDeep(date, o.date, true) && compareDeep(reporter, o.reporter, true)
           && compareDeep(reportingVendor, o.reportingVendor, true) && compareDeep(location, o.location, true)
           && compareDeep(period, o.period, true) && compareDeep(inputParameters, o.inputParameters, true)
           && compareDeep(scoring, o.scoring, true) && compareDeep(improvementNotation, o.improvementNotation, true)
           && compareDeep(group, o.group, true) && compareDeep(supplementalData, o.supplementalData, true)
           && compareDeep(evaluatedResource, o.evaluatedResource, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MeasureReport))
          return false;
        MeasureReport o = (MeasureReport) other_;
        return compareValues(status, o.status, true) && compareValues(type, o.type, true) && compareValues(dataUpdateType, o.dataUpdateType, true)
           && compareValues(measure, o.measure, true) && compareValues(date, o.date, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, type
          , dataUpdateType, measure, subject, date, reporter, reportingVendor, location
          , period, inputParameters, scoring, improvementNotation, group, supplementalData
          , evaluatedResource);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MeasureReport;
   }

 /**
   * Search parameter: <b>evaluated-resource</b>
   * <p>
   * Description: <b>An evaluated resource referenced by the measure report</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.evaluatedResource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="evaluated-resource", path="MeasureReport.evaluatedResource", description="An evaluated resource referenced by the measure report", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_EVALUATED_RESOURCE = "evaluated-resource";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>evaluated-resource</b>
   * <p>
   * Description: <b>An evaluated resource referenced by the measure report</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.evaluatedResource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam EVALUATED_RESOURCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_EVALUATED_RESOURCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MeasureReport:evaluated-resource</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_EVALUATED_RESOURCE = new ca.uhn.fhir.model.api.Include("MeasureReport:evaluated-resource").toLocked();

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>The location to return measure report results for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.location</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="MeasureReport.location", description="The location to return measure report results for", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>The location to return measure report results for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.location</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MeasureReport:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("MeasureReport:location").toLocked();

 /**
   * Search parameter: <b>measure</b>
   * <p>
   * Description: <b>The measure to return measure report results for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.measure</b><br>
   * </p>
   */
  @SearchParamDefinition(name="measure", path="MeasureReport.measure", description="The measure to return measure report results for", type="reference", target={Measure.class } )
  public static final String SP_MEASURE = "measure";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>measure</b>
   * <p>
   * Description: <b>The measure to return measure report results for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.measure</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MEASURE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MEASURE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MeasureReport:measure</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MEASURE = new ca.uhn.fhir.model.api.Include("MeasureReport:measure").toLocked();

 /**
   * Search parameter: <b>period</b>
   * <p>
   * Description: <b>The period of the measure report</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MeasureReport.period</b><br>
   * </p>
   */
  @SearchParamDefinition(name="period", path="MeasureReport.period", description="The period of the measure report", type="date" )
  public static final String SP_PERIOD = "period";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>period</b>
   * <p>
   * Description: <b>The period of the measure report</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MeasureReport.period</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam PERIOD = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_PERIOD);

 /**
   * Search parameter: <b>reporter</b>
   * <p>
   * Description: <b>The reporter to return measure report results for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.reporter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="reporter", path="MeasureReport.reporter", description="The reporter to return measure report results for", type="reference", target={Group.class, Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_REPORTER = "reporter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>reporter</b>
   * <p>
   * Description: <b>The reporter to return measure report results for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.reporter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REPORTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REPORTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MeasureReport:reporter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REPORTER = new ca.uhn.fhir.model.api.Include("MeasureReport:reporter").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the measure report</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MeasureReport.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="MeasureReport.status", description="The status of the measure report", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the measure report</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MeasureReport.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a subject to search for individual measure report results for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="MeasureReport.subject", description="The identity of a subject to search for individual measure report results for", type="reference", target={CareTeam.class, Device.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The identity of a subject to search for individual measure report results for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MeasureReport.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MeasureReport:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("MeasureReport:subject").toLocked();

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): When the event occurred
* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [Appointment](appointment.html): Appointment date/time.
* [AuditEvent](auditevent.html): Time when the event was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [DocumentReference](documentreference.html): When this document reference was created
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated
* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created
* [Invoice](invoice.html): Invoice date / posting date
* [List](list.html): When the list was prepared
* [MeasureReport](measurereport.html): The date of the measure report
* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication
* [Observation](observation.html): Clinically relevant time/time-period for observation
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): When the event occurred\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [Appointment](appointment.html): Appointment date/time.\r\n* [AuditEvent](auditevent.html): Time when the event was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [DocumentReference](documentreference.html): When this document reference was created\r\n* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created\r\n* [Invoice](invoice.html): Invoice date / posting date\r\n* [List](list.html): When the list was prepared\r\n* [MeasureReport](measurereport.html): The date of the measure report\r\n* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication\r\n* [Observation](observation.html): Clinically relevant time/time-period for observation\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [ResearchSubject](researchsubject.html): Start and end of participation\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): When the event occurred
* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [Appointment](appointment.html): Appointment date/time.
* [AuditEvent](auditevent.html): Time when the event was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [DocumentReference](documentreference.html): When this document reference was created
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated
* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created
* [Invoice](invoice.html): Invoice date / posting date
* [List](list.html): When the list was prepared
* [MeasureReport](measurereport.html): The date of the measure report
* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication
* [Observation](observation.html): Clinically relevant time/time-period for observation
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

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
   * the path value of "<b>MeasureReport:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("MeasureReport:patient").toLocked();


}

