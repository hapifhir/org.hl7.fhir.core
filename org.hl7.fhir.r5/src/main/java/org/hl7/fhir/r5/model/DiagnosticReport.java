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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR v5.0.0-snapshot2

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
 * The findings and interpretation of diagnostic tests performed on patients, groups of patients, products, substances, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports. The report also includes non-clinical context such as batch analysis and stability reporting of products and substances.
 */
@ResourceDef(name="DiagnosticReport", profile="http://hl7.org/fhir/StructureDefinition/DiagnosticReport")
public class DiagnosticReport extends DomainResource {

    public enum DiagnosticReportStatus {
        /**
         * The existence of the report is registered, but there is nothing yet available.
         */
        REGISTERED, 
        /**
         * This is a partial (e.g. initial, interim or preliminary) report: data in the report may be incomplete or unverified.
         */
        PARTIAL, 
        /**
         * Verified early results are available, but not all  results are final.
         */
        PRELIMINARY, 
        /**
         * The report is complete and verified by an authorized person.
         */
        FINAL, 
        /**
         * Subsequent to being final, the report has been modified.  This includes any change in the results, diagnosis, narrative text, or other content of a report that has been issued.
         */
        AMENDED, 
        /**
         * Subsequent to being final, the report has been modified  to correct an error in the report or referenced results.
         */
        CORRECTED, 
        /**
         * Subsequent to being final, the report has been modified by adding new content. The existing content is unchanged.
         */
        APPENDED, 
        /**
         * The report is unavailable because the measurement was not started or not completed (also sometimes called \"aborted\").
         */
        CANCELLED, 
        /**
         * The report has been withdrawn following a previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).
         */
        ENTEREDINERROR, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DiagnosticReportStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return REGISTERED;
        if ("partial".equals(codeString))
          return PARTIAL;
        if ("preliminary".equals(codeString))
          return PRELIMINARY;
        if ("final".equals(codeString))
          return FINAL;
        if ("amended".equals(codeString))
          return AMENDED;
        if ("corrected".equals(codeString))
          return CORRECTED;
        if ("appended".equals(codeString))
          return APPENDED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DiagnosticReportStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REGISTERED: return "registered";
            case PARTIAL: return "partial";
            case PRELIMINARY: return "preliminary";
            case FINAL: return "final";
            case AMENDED: return "amended";
            case CORRECTED: return "corrected";
            case APPENDED: return "appended";
            case CANCELLED: return "cancelled";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REGISTERED: return "http://hl7.org/fhir/diagnostic-report-status";
            case PARTIAL: return "http://hl7.org/fhir/diagnostic-report-status";
            case PRELIMINARY: return "http://hl7.org/fhir/diagnostic-report-status";
            case FINAL: return "http://hl7.org/fhir/diagnostic-report-status";
            case AMENDED: return "http://hl7.org/fhir/diagnostic-report-status";
            case CORRECTED: return "http://hl7.org/fhir/diagnostic-report-status";
            case APPENDED: return "http://hl7.org/fhir/diagnostic-report-status";
            case CANCELLED: return "http://hl7.org/fhir/diagnostic-report-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/diagnostic-report-status";
            case UNKNOWN: return "http://hl7.org/fhir/diagnostic-report-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REGISTERED: return "The existence of the report is registered, but there is nothing yet available.";
            case PARTIAL: return "This is a partial (e.g. initial, interim or preliminary) report: data in the report may be incomplete or unverified.";
            case PRELIMINARY: return "Verified early results are available, but not all  results are final.";
            case FINAL: return "The report is complete and verified by an authorized person.";
            case AMENDED: return "Subsequent to being final, the report has been modified.  This includes any change in the results, diagnosis, narrative text, or other content of a report that has been issued.";
            case CORRECTED: return "Subsequent to being final, the report has been modified  to correct an error in the report or referenced results.";
            case APPENDED: return "Subsequent to being final, the report has been modified by adding new content. The existing content is unchanged.";
            case CANCELLED: return "The report is unavailable because the measurement was not started or not completed (also sometimes called \"aborted\").";
            case ENTEREDINERROR: return "The report has been withdrawn following a previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REGISTERED: return "Registered";
            case PARTIAL: return "Partial";
            case PRELIMINARY: return "Preliminary";
            case FINAL: return "Final";
            case AMENDED: return "Amended";
            case CORRECTED: return "Corrected";
            case APPENDED: return "Appended";
            case CANCELLED: return "Cancelled";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DiagnosticReportStatusEnumFactory implements EnumFactory<DiagnosticReportStatus> {
    public DiagnosticReportStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return DiagnosticReportStatus.REGISTERED;
        if ("partial".equals(codeString))
          return DiagnosticReportStatus.PARTIAL;
        if ("preliminary".equals(codeString))
          return DiagnosticReportStatus.PRELIMINARY;
        if ("final".equals(codeString))
          return DiagnosticReportStatus.FINAL;
        if ("amended".equals(codeString))
          return DiagnosticReportStatus.AMENDED;
        if ("corrected".equals(codeString))
          return DiagnosticReportStatus.CORRECTED;
        if ("appended".equals(codeString))
          return DiagnosticReportStatus.APPENDED;
        if ("cancelled".equals(codeString))
          return DiagnosticReportStatus.CANCELLED;
        if ("entered-in-error".equals(codeString))
          return DiagnosticReportStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return DiagnosticReportStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown DiagnosticReportStatus code '"+codeString+"'");
        }
        public Enumeration<DiagnosticReportStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DiagnosticReportStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("registered".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.REGISTERED);
        if ("partial".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.PARTIAL);
        if ("preliminary".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.PRELIMINARY);
        if ("final".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.FINAL);
        if ("amended".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.AMENDED);
        if ("corrected".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.CORRECTED);
        if ("appended".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.APPENDED);
        if ("cancelled".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.CANCELLED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<DiagnosticReportStatus>(this, DiagnosticReportStatus.UNKNOWN);
        throw new FHIRException("Unknown DiagnosticReportStatus code '"+codeString+"'");
        }
    public String toCode(DiagnosticReportStatus code) {
      if (code == DiagnosticReportStatus.REGISTERED)
        return "registered";
      if (code == DiagnosticReportStatus.PARTIAL)
        return "partial";
      if (code == DiagnosticReportStatus.PRELIMINARY)
        return "preliminary";
      if (code == DiagnosticReportStatus.FINAL)
        return "final";
      if (code == DiagnosticReportStatus.AMENDED)
        return "amended";
      if (code == DiagnosticReportStatus.CORRECTED)
        return "corrected";
      if (code == DiagnosticReportStatus.APPENDED)
        return "appended";
      if (code == DiagnosticReportStatus.CANCELLED)
        return "cancelled";
      if (code == DiagnosticReportStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == DiagnosticReportStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(DiagnosticReportStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class DiagnosticReportMediaComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A comment about the image or data. Typically, this is used to provide an explanation for why the image or data is included, or to draw the viewer's attention to important features.
         */
        @Child(name = "comment", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Comment about the image or data (e.g. explanation)", formalDefinition="A comment about the image or data. Typically, this is used to provide an explanation for why the image or data is included, or to draw the viewer's attention to important features." )
        protected StringType comment;

        /**
         * Reference to the image or data source.
         */
        @Child(name = "link", type = {DocumentReference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reference to the image or data source", formalDefinition="Reference to the image or data source." )
        protected Reference link;

        private static final long serialVersionUID = 1827561947L;

    /**
     * Constructor
     */
      public DiagnosticReportMediaComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DiagnosticReportMediaComponent(Reference link) {
        super();
        this.setLink(link);
      }

        /**
         * @return {@link #comment} (A comment about the image or data. Typically, this is used to provide an explanation for why the image or data is included, or to draw the viewer's attention to important features.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public StringType getCommentElement() { 
          if (this.comment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DiagnosticReportMediaComponent.comment");
            else if (Configuration.doAutoCreate())
              this.comment = new StringType(); // bb
          return this.comment;
        }

        public boolean hasCommentElement() { 
          return this.comment != null && !this.comment.isEmpty();
        }

        public boolean hasComment() { 
          return this.comment != null && !this.comment.isEmpty();
        }

        /**
         * @param value {@link #comment} (A comment about the image or data. Typically, this is used to provide an explanation for why the image or data is included, or to draw the viewer's attention to important features.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public DiagnosticReportMediaComponent setCommentElement(StringType value) { 
          this.comment = value;
          return this;
        }

        /**
         * @return A comment about the image or data. Typically, this is used to provide an explanation for why the image or data is included, or to draw the viewer's attention to important features.
         */
        public String getComment() { 
          return this.comment == null ? null : this.comment.getValue();
        }

        /**
         * @param value A comment about the image or data. Typically, this is used to provide an explanation for why the image or data is included, or to draw the viewer's attention to important features.
         */
        public DiagnosticReportMediaComponent setComment(String value) { 
          if (Utilities.noString(value))
            this.comment = null;
          else {
            if (this.comment == null)
              this.comment = new StringType();
            this.comment.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #link} (Reference to the image or data source.)
         */
        public Reference getLink() { 
          if (this.link == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DiagnosticReportMediaComponent.link");
            else if (Configuration.doAutoCreate())
              this.link = new Reference(); // cc
          return this.link;
        }

        public boolean hasLink() { 
          return this.link != null && !this.link.isEmpty();
        }

        /**
         * @param value {@link #link} (Reference to the image or data source.)
         */
        public DiagnosticReportMediaComponent setLink(Reference value) { 
          this.link = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("comment", "string", "A comment about the image or data. Typically, this is used to provide an explanation for why the image or data is included, or to draw the viewer's attention to important features.", 0, 1, comment));
          children.add(new Property("link", "Reference(DocumentReference)", "Reference to the image or data source.", 0, 1, link));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 950398559: /*comment*/  return new Property("comment", "string", "A comment about the image or data. Typically, this is used to provide an explanation for why the image or data is included, or to draw the viewer's attention to important features.", 0, 1, comment);
          case 3321850: /*link*/  return new Property("link", "Reference(DocumentReference)", "Reference to the image or data source.", 0, 1, link);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // StringType
        case 3321850: /*link*/ return this.link == null ? new Base[0] : new Base[] {this.link}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 950398559: // comment
          this.comment = TypeConvertor.castToString(value); // StringType
          return value;
        case 3321850: // link
          this.link = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("comment")) {
          this.comment = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("link")) {
          this.link = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 950398559:  return getCommentElement();
        case 3321850:  return getLink();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 950398559: /*comment*/ return new String[] {"string"};
        case 3321850: /*link*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type DiagnosticReport.media.comment");
        }
        else if (name.equals("link")) {
          this.link = new Reference();
          return this.link;
        }
        else
          return super.addChild(name);
      }

      public DiagnosticReportMediaComponent copy() {
        DiagnosticReportMediaComponent dst = new DiagnosticReportMediaComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DiagnosticReportMediaComponent dst) {
        super.copyValues(dst);
        dst.comment = comment == null ? null : comment.copy();
        dst.link = link == null ? null : link.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DiagnosticReportMediaComponent))
          return false;
        DiagnosticReportMediaComponent o = (DiagnosticReportMediaComponent) other_;
        return compareDeep(comment, o.comment, true) && compareDeep(link, o.link, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DiagnosticReportMediaComponent))
          return false;
        DiagnosticReportMediaComponent o = (DiagnosticReportMediaComponent) other_;
        return compareValues(comment, o.comment, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(comment, link);
      }

  public String fhirType() {
    return "DiagnosticReport.media";

  }

  }

    /**
     * Identifiers assigned to this report by the performer or other systems.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for report", formalDefinition="Identifiers assigned to this report by the performer or other systems." )
    protected List<Identifier> identifier;

    /**
     * Details concerning a service requested.
     */
    @Child(name = "basedOn", type = {CarePlan.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, ServiceRequest.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What was requested", formalDefinition="Details concerning a service requested." )
    protected List<Reference> basedOn;

    /**
     * The status of the diagnostic report.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="registered | partial | preliminary | final +", formalDefinition="The status of the diagnostic report." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/diagnostic-report-status")
    protected Enumeration<DiagnosticReportStatus> status;

    /**
     * A code that classifies the clinical discipline, department or diagnostic service that created the report (e.g. cardiology, biochemistry, hematology, MRI). This is used for searching, sorting and display purposes.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Service category", formalDefinition="A code that classifies the clinical discipline, department or diagnostic service that created the report (e.g. cardiology, biochemistry, hematology, MRI). This is used for searching, sorting and display purposes." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/diagnostic-service-sections")
    protected List<CodeableConcept> category;

    /**
     * A code or name that describes this diagnostic report.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name/Code for this diagnostic report", formalDefinition="A code or name that describes this diagnostic report." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/report-codes")
    protected CodeableConcept code;

    /**
     * The subject of the report. Usually, but not always, this is a patient. However, diagnostic services also perform analyses on specimens collected from a variety of other sources.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Device.class, Location.class, Organization.class, Procedure.class, Practitioner.class, Medication.class, Substance.class, BiologicallyDerivedProduct.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The subject of the report - usually, but not always, the patient", formalDefinition="The subject of the report. Usually, but not always, this is a patient. However, diagnostic services also perform analyses on specimens collected from a variety of other sources." )
    protected Reference subject;

    /**
     * The healthcare event  (e.g. a patient and healthcare provider interaction) which this DiagnosticReport is about.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Health care event when test ordered", formalDefinition="The healthcare event  (e.g. a patient and healthcare provider interaction) which this DiagnosticReport is about." )
    protected Reference encounter;

    /**
     * The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.
     */
    @Child(name = "effective", type = {DateTimeType.class, Period.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Clinically relevant time/time-period for report", formalDefinition="The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself." )
    protected DataType effective;

    /**
     * The date and time that this version of the report was made available to providers, typically after the report was reviewed and verified.
     */
    @Child(name = "issued", type = {InstantType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="DateTime this version was made", formalDefinition="The date and time that this version of the report was made available to providers, typically after the report was reviewed and verified." )
    protected InstantType issued;

    /**
     * The diagnostic service that is responsible for issuing the report.
     */
    @Child(name = "performer", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Responsible Diagnostic Service", formalDefinition="The diagnostic service that is responsible for issuing the report." )
    protected List<Reference> performer;

    /**
     * The practitioner or organization that is responsible for the report's conclusions and interpretations.
     */
    @Child(name = "resultsInterpreter", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Primary result interpreter", formalDefinition="The practitioner or organization that is responsible for the report's conclusions and interpretations." )
    protected List<Reference> resultsInterpreter;

    /**
     * Details about the specimens on which this diagnostic report is based.
     */
    @Child(name = "specimen", type = {Specimen.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Specimens this report is based on", formalDefinition="Details about the specimens on which this diagnostic report is based." )
    protected List<Reference> specimen;

    /**
     * [Observations](observation.html)  that are part of this diagnostic report.
     */
    @Child(name = "result", type = {Observation.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Observations", formalDefinition="[Observations](observation.html)  that are part of this diagnostic report." )
    protected List<Reference> result;

    /**
     * Comments about the diagnostic report.
     */
    @Child(name = "note", type = {Annotation.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments about the diagnostic report", formalDefinition="Comments about the diagnostic report." )
    protected List<Annotation> note;

    /**
     * One or more links to full details of any imaging performed during the diagnostic investigation. Typically, this is imaging performed by DICOM enabled modalities, but this is not required. A fully enabled PACS viewer can use this information to provide views of the source images.
     */
    @Child(name = "imagingStudy", type = {ImagingStudy.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reference to full details of imaging associated with the diagnostic report", formalDefinition="One or more links to full details of any imaging performed during the diagnostic investigation. Typically, this is imaging performed by DICOM enabled modalities, but this is not required. A fully enabled PACS viewer can use this information to provide views of the source images." )
    protected List<Reference> imagingStudy;

    /**
     * A list of key images or data associated with this report. The images or data are generally created during the diagnostic process, and may be directly of the patient, or of treated specimens (i.e. slides of interest).
     */
    @Child(name = "media", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Key images or data associated with this report", formalDefinition="A list of key images or data associated with this report. The images or data are generally created during the diagnostic process, and may be directly of the patient, or of treated specimens (i.e. slides of interest)." )
    protected List<DiagnosticReportMediaComponent> media;

    /**
     * Reference to a Composition resource instance that provides structure for organizing the contents of the DiagnosticReport.
     */
    @Child(name = "composition", type = {Composition.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to a Composition resource for the DiagnosticReport structure", formalDefinition="Reference to a Composition resource instance that provides structure for organizing the contents of the DiagnosticReport." )
    protected Reference composition;

    /**
     * Concise and clinically contextualized summary conclusion (interpretation/impression) of the diagnostic report.
     */
    @Child(name = "conclusion", type = {StringType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Clinical conclusion (interpretation) of test results", formalDefinition="Concise and clinically contextualized summary conclusion (interpretation/impression) of the diagnostic report." )
    protected StringType conclusion;

    /**
     * One or more codes that represent the summary conclusion (interpretation/impression) of the diagnostic report.
     */
    @Child(name = "conclusionCode", type = {CodeableConcept.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Codes for the clinical conclusion of test results", formalDefinition="One or more codes that represent the summary conclusion (interpretation/impression) of the diagnostic report." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-findings")
    protected List<CodeableConcept> conclusionCode;

    /**
     * Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they SHALL be semantically equivalent.
     */
    @Child(name = "presentedForm", type = {Attachment.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Entire report as issued", formalDefinition="Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they SHALL be semantically equivalent." )
    protected List<Attachment> presentedForm;

    private static final long serialVersionUID = -491814069L;

  /**
   * Constructor
   */
    public DiagnosticReport() {
      super();
    }

  /**
   * Constructor
   */
    public DiagnosticReport(DiagnosticReportStatus status, CodeableConcept code) {
      super();
      this.setStatus(status);
      this.setCode(code);
    }

    /**
     * @return {@link #identifier} (Identifiers assigned to this report by the performer or other systems.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setIdentifier(List<Identifier> theIdentifier) { 
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

    public DiagnosticReport addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (Details concerning a service requested.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setBasedOn(List<Reference> theBasedOn) { 
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

    public DiagnosticReport addBasedOn(Reference t) { //3
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
     * @return {@link #status} (The status of the diagnostic report.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<DiagnosticReportStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DiagnosticReport.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<DiagnosticReportStatus>(new DiagnosticReportStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the diagnostic report.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public DiagnosticReport setStatusElement(Enumeration<DiagnosticReportStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the diagnostic report.
     */
    public DiagnosticReportStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the diagnostic report.
     */
    public DiagnosticReport setStatus(DiagnosticReportStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<DiagnosticReportStatus>(new DiagnosticReportStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (A code that classifies the clinical discipline, department or diagnostic service that created the report (e.g. cardiology, biochemistry, hematology, MRI). This is used for searching, sorting and display purposes.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public DiagnosticReport addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #code} (A code or name that describes this diagnostic report.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DiagnosticReport.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code or name that describes this diagnostic report.)
     */
    public DiagnosticReport setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (The subject of the report. Usually, but not always, this is a patient. However, diagnostic services also perform analyses on specimens collected from a variety of other sources.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DiagnosticReport.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The subject of the report. Usually, but not always, this is a patient. However, diagnostic services also perform analyses on specimens collected from a variety of other sources.)
     */
    public DiagnosticReport setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The healthcare event  (e.g. a patient and healthcare provider interaction) which this DiagnosticReport is about.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DiagnosticReport.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The healthcare event  (e.g. a patient and healthcare provider interaction) which this DiagnosticReport is about.)
     */
    public DiagnosticReport setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #effective} (The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.)
     */
    public DataType getEffective() { 
      return this.effective;
    }

    /**
     * @return {@link #effective} (The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.)
     */
    public DateTimeType getEffectiveDateTimeType() throws FHIRException { 
      if (this.effective == null)
        this.effective = new DateTimeType();
      if (!(this.effective instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (DateTimeType) this.effective;
    }

    public boolean hasEffectiveDateTimeType() { 
      return this != null && this.effective instanceof DateTimeType;
    }

    /**
     * @return {@link #effective} (The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.)
     */
    public Period getEffectivePeriod() throws FHIRException { 
      if (this.effective == null)
        this.effective = new Period();
      if (!(this.effective instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (Period) this.effective;
    }

    public boolean hasEffectivePeriod() { 
      return this != null && this.effective instanceof Period;
    }

    public boolean hasEffective() { 
      return this.effective != null && !this.effective.isEmpty();
    }

    /**
     * @param value {@link #effective} (The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.)
     */
    public DiagnosticReport setEffective(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period))
        throw new Error("Not the right type for DiagnosticReport.effective[x]: "+value.fhirType());
      this.effective = value;
      return this;
    }

    /**
     * @return {@link #issued} (The date and time that this version of the report was made available to providers, typically after the report was reviewed and verified.). This is the underlying object with id, value and extensions. The accessor "getIssued" gives direct access to the value
     */
    public InstantType getIssuedElement() { 
      if (this.issued == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DiagnosticReport.issued");
        else if (Configuration.doAutoCreate())
          this.issued = new InstantType(); // bb
      return this.issued;
    }

    public boolean hasIssuedElement() { 
      return this.issued != null && !this.issued.isEmpty();
    }

    public boolean hasIssued() { 
      return this.issued != null && !this.issued.isEmpty();
    }

    /**
     * @param value {@link #issued} (The date and time that this version of the report was made available to providers, typically after the report was reviewed and verified.). This is the underlying object with id, value and extensions. The accessor "getIssued" gives direct access to the value
     */
    public DiagnosticReport setIssuedElement(InstantType value) { 
      this.issued = value;
      return this;
    }

    /**
     * @return The date and time that this version of the report was made available to providers, typically after the report was reviewed and verified.
     */
    public Date getIssued() { 
      return this.issued == null ? null : this.issued.getValue();
    }

    /**
     * @param value The date and time that this version of the report was made available to providers, typically after the report was reviewed and verified.
     */
    public DiagnosticReport setIssued(Date value) { 
      if (value == null)
        this.issued = null;
      else {
        if (this.issued == null)
          this.issued = new InstantType();
        this.issued.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #performer} (The diagnostic service that is responsible for issuing the report.)
     */
    public List<Reference> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<Reference>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setPerformer(List<Reference> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (Reference item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPerformer() { //3
      Reference t = new Reference();
      if (this.performer == null)
        this.performer = new ArrayList<Reference>();
      this.performer.add(t);
      return t;
    }

    public DiagnosticReport addPerformer(Reference t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<Reference>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public Reference getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #resultsInterpreter} (The practitioner or organization that is responsible for the report's conclusions and interpretations.)
     */
    public List<Reference> getResultsInterpreter() { 
      if (this.resultsInterpreter == null)
        this.resultsInterpreter = new ArrayList<Reference>();
      return this.resultsInterpreter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setResultsInterpreter(List<Reference> theResultsInterpreter) { 
      this.resultsInterpreter = theResultsInterpreter;
      return this;
    }

    public boolean hasResultsInterpreter() { 
      if (this.resultsInterpreter == null)
        return false;
      for (Reference item : this.resultsInterpreter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addResultsInterpreter() { //3
      Reference t = new Reference();
      if (this.resultsInterpreter == null)
        this.resultsInterpreter = new ArrayList<Reference>();
      this.resultsInterpreter.add(t);
      return t;
    }

    public DiagnosticReport addResultsInterpreter(Reference t) { //3
      if (t == null)
        return this;
      if (this.resultsInterpreter == null)
        this.resultsInterpreter = new ArrayList<Reference>();
      this.resultsInterpreter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #resultsInterpreter}, creating it if it does not already exist {3}
     */
    public Reference getResultsInterpreterFirstRep() { 
      if (getResultsInterpreter().isEmpty()) {
        addResultsInterpreter();
      }
      return getResultsInterpreter().get(0);
    }

    /**
     * @return {@link #specimen} (Details about the specimens on which this diagnostic report is based.)
     */
    public List<Reference> getSpecimen() { 
      if (this.specimen == null)
        this.specimen = new ArrayList<Reference>();
      return this.specimen;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setSpecimen(List<Reference> theSpecimen) { 
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

    public DiagnosticReport addSpecimen(Reference t) { //3
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
     * @return {@link #result} ([Observations](observation.html)  that are part of this diagnostic report.)
     */
    public List<Reference> getResult() { 
      if (this.result == null)
        this.result = new ArrayList<Reference>();
      return this.result;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setResult(List<Reference> theResult) { 
      this.result = theResult;
      return this;
    }

    public boolean hasResult() { 
      if (this.result == null)
        return false;
      for (Reference item : this.result)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addResult() { //3
      Reference t = new Reference();
      if (this.result == null)
        this.result = new ArrayList<Reference>();
      this.result.add(t);
      return t;
    }

    public DiagnosticReport addResult(Reference t) { //3
      if (t == null)
        return this;
      if (this.result == null)
        this.result = new ArrayList<Reference>();
      this.result.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #result}, creating it if it does not already exist {3}
     */
    public Reference getResultFirstRep() { 
      if (getResult().isEmpty()) {
        addResult();
      }
      return getResult().get(0);
    }

    /**
     * @return {@link #note} (Comments about the diagnostic report.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setNote(List<Annotation> theNote) { 
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

    public DiagnosticReport addNote(Annotation t) { //3
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
     * @return {@link #imagingStudy} (One or more links to full details of any imaging performed during the diagnostic investigation. Typically, this is imaging performed by DICOM enabled modalities, but this is not required. A fully enabled PACS viewer can use this information to provide views of the source images.)
     */
    public List<Reference> getImagingStudy() { 
      if (this.imagingStudy == null)
        this.imagingStudy = new ArrayList<Reference>();
      return this.imagingStudy;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setImagingStudy(List<Reference> theImagingStudy) { 
      this.imagingStudy = theImagingStudy;
      return this;
    }

    public boolean hasImagingStudy() { 
      if (this.imagingStudy == null)
        return false;
      for (Reference item : this.imagingStudy)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addImagingStudy() { //3
      Reference t = new Reference();
      if (this.imagingStudy == null)
        this.imagingStudy = new ArrayList<Reference>();
      this.imagingStudy.add(t);
      return t;
    }

    public DiagnosticReport addImagingStudy(Reference t) { //3
      if (t == null)
        return this;
      if (this.imagingStudy == null)
        this.imagingStudy = new ArrayList<Reference>();
      this.imagingStudy.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #imagingStudy}, creating it if it does not already exist {3}
     */
    public Reference getImagingStudyFirstRep() { 
      if (getImagingStudy().isEmpty()) {
        addImagingStudy();
      }
      return getImagingStudy().get(0);
    }

    /**
     * @return {@link #media} (A list of key images or data associated with this report. The images or data are generally created during the diagnostic process, and may be directly of the patient, or of treated specimens (i.e. slides of interest).)
     */
    public List<DiagnosticReportMediaComponent> getMedia() { 
      if (this.media == null)
        this.media = new ArrayList<DiagnosticReportMediaComponent>();
      return this.media;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setMedia(List<DiagnosticReportMediaComponent> theMedia) { 
      this.media = theMedia;
      return this;
    }

    public boolean hasMedia() { 
      if (this.media == null)
        return false;
      for (DiagnosticReportMediaComponent item : this.media)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DiagnosticReportMediaComponent addMedia() { //3
      DiagnosticReportMediaComponent t = new DiagnosticReportMediaComponent();
      if (this.media == null)
        this.media = new ArrayList<DiagnosticReportMediaComponent>();
      this.media.add(t);
      return t;
    }

    public DiagnosticReport addMedia(DiagnosticReportMediaComponent t) { //3
      if (t == null)
        return this;
      if (this.media == null)
        this.media = new ArrayList<DiagnosticReportMediaComponent>();
      this.media.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #media}, creating it if it does not already exist {3}
     */
    public DiagnosticReportMediaComponent getMediaFirstRep() { 
      if (getMedia().isEmpty()) {
        addMedia();
      }
      return getMedia().get(0);
    }

    /**
     * @return {@link #composition} (Reference to a Composition resource instance that provides structure for organizing the contents of the DiagnosticReport.)
     */
    public Reference getComposition() { 
      if (this.composition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DiagnosticReport.composition");
        else if (Configuration.doAutoCreate())
          this.composition = new Reference(); // cc
      return this.composition;
    }

    public boolean hasComposition() { 
      return this.composition != null && !this.composition.isEmpty();
    }

    /**
     * @param value {@link #composition} (Reference to a Composition resource instance that provides structure for organizing the contents of the DiagnosticReport.)
     */
    public DiagnosticReport setComposition(Reference value) { 
      this.composition = value;
      return this;
    }

    /**
     * @return {@link #conclusion} (Concise and clinically contextualized summary conclusion (interpretation/impression) of the diagnostic report.). This is the underlying object with id, value and extensions. The accessor "getConclusion" gives direct access to the value
     */
    public StringType getConclusionElement() { 
      if (this.conclusion == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DiagnosticReport.conclusion");
        else if (Configuration.doAutoCreate())
          this.conclusion = new StringType(); // bb
      return this.conclusion;
    }

    public boolean hasConclusionElement() { 
      return this.conclusion != null && !this.conclusion.isEmpty();
    }

    public boolean hasConclusion() { 
      return this.conclusion != null && !this.conclusion.isEmpty();
    }

    /**
     * @param value {@link #conclusion} (Concise and clinically contextualized summary conclusion (interpretation/impression) of the diagnostic report.). This is the underlying object with id, value and extensions. The accessor "getConclusion" gives direct access to the value
     */
    public DiagnosticReport setConclusionElement(StringType value) { 
      this.conclusion = value;
      return this;
    }

    /**
     * @return Concise and clinically contextualized summary conclusion (interpretation/impression) of the diagnostic report.
     */
    public String getConclusion() { 
      return this.conclusion == null ? null : this.conclusion.getValue();
    }

    /**
     * @param value Concise and clinically contextualized summary conclusion (interpretation/impression) of the diagnostic report.
     */
    public DiagnosticReport setConclusion(String value) { 
      if (Utilities.noString(value))
        this.conclusion = null;
      else {
        if (this.conclusion == null)
          this.conclusion = new StringType();
        this.conclusion.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #conclusionCode} (One or more codes that represent the summary conclusion (interpretation/impression) of the diagnostic report.)
     */
    public List<CodeableConcept> getConclusionCode() { 
      if (this.conclusionCode == null)
        this.conclusionCode = new ArrayList<CodeableConcept>();
      return this.conclusionCode;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setConclusionCode(List<CodeableConcept> theConclusionCode) { 
      this.conclusionCode = theConclusionCode;
      return this;
    }

    public boolean hasConclusionCode() { 
      if (this.conclusionCode == null)
        return false;
      for (CodeableConcept item : this.conclusionCode)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addConclusionCode() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.conclusionCode == null)
        this.conclusionCode = new ArrayList<CodeableConcept>();
      this.conclusionCode.add(t);
      return t;
    }

    public DiagnosticReport addConclusionCode(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.conclusionCode == null)
        this.conclusionCode = new ArrayList<CodeableConcept>();
      this.conclusionCode.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #conclusionCode}, creating it if it does not already exist {3}
     */
    public CodeableConcept getConclusionCodeFirstRep() { 
      if (getConclusionCode().isEmpty()) {
        addConclusionCode();
      }
      return getConclusionCode().get(0);
    }

    /**
     * @return {@link #presentedForm} (Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they SHALL be semantically equivalent.)
     */
    public List<Attachment> getPresentedForm() { 
      if (this.presentedForm == null)
        this.presentedForm = new ArrayList<Attachment>();
      return this.presentedForm;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DiagnosticReport setPresentedForm(List<Attachment> thePresentedForm) { 
      this.presentedForm = thePresentedForm;
      return this;
    }

    public boolean hasPresentedForm() { 
      if (this.presentedForm == null)
        return false;
      for (Attachment item : this.presentedForm)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Attachment addPresentedForm() { //3
      Attachment t = new Attachment();
      if (this.presentedForm == null)
        this.presentedForm = new ArrayList<Attachment>();
      this.presentedForm.add(t);
      return t;
    }

    public DiagnosticReport addPresentedForm(Attachment t) { //3
      if (t == null)
        return this;
      if (this.presentedForm == null)
        this.presentedForm = new ArrayList<Attachment>();
      this.presentedForm.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #presentedForm}, creating it if it does not already exist {3}
     */
    public Attachment getPresentedFormFirstRep() { 
      if (getPresentedForm().isEmpty()) {
        addPresentedForm();
      }
      return getPresentedForm().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers assigned to this report by the performer or other systems.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(CarePlan|ImmunizationRecommendation|MedicationRequest|NutritionOrder|ServiceRequest)", "Details concerning a service requested.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("status", "code", "The status of the diagnostic report.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "A code that classifies the clinical discipline, department or diagnostic service that created the report (e.g. cardiology, biochemistry, hematology, MRI). This is used for searching, sorting and display purposes.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableConcept", "A code or name that describes this diagnostic report.", 0, 1, code));
        children.add(new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct)", "The subject of the report. Usually, but not always, this is a patient. However, diagnostic services also perform analyses on specimens collected from a variety of other sources.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The healthcare event  (e.g. a patient and healthcare provider interaction) which this DiagnosticReport is about.", 0, 1, encounter));
        children.add(new Property("effective[x]", "dateTime|Period", "The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective));
        children.add(new Property("issued", "instant", "The date and time that this version of the report was made available to providers, typically after the report was reviewed and verified.", 0, 1, issued));
        children.add(new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam)", "The diagnostic service that is responsible for issuing the report.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("resultsInterpreter", "Reference(Practitioner|PractitionerRole|Organization|CareTeam)", "The practitioner or organization that is responsible for the report's conclusions and interpretations.", 0, java.lang.Integer.MAX_VALUE, resultsInterpreter));
        children.add(new Property("specimen", "Reference(Specimen)", "Details about the specimens on which this diagnostic report is based.", 0, java.lang.Integer.MAX_VALUE, specimen));
        children.add(new Property("result", "Reference(Observation)", "[Observations](observation.html)  that are part of this diagnostic report.", 0, java.lang.Integer.MAX_VALUE, result));
        children.add(new Property("note", "Annotation", "Comments about the diagnostic report.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("imagingStudy", "Reference(ImagingStudy)", "One or more links to full details of any imaging performed during the diagnostic investigation. Typically, this is imaging performed by DICOM enabled modalities, but this is not required. A fully enabled PACS viewer can use this information to provide views of the source images.", 0, java.lang.Integer.MAX_VALUE, imagingStudy));
        children.add(new Property("media", "", "A list of key images or data associated with this report. The images or data are generally created during the diagnostic process, and may be directly of the patient, or of treated specimens (i.e. slides of interest).", 0, java.lang.Integer.MAX_VALUE, media));
        children.add(new Property("composition", "Reference(Composition)", "Reference to a Composition resource instance that provides structure for organizing the contents of the DiagnosticReport.", 0, 1, composition));
        children.add(new Property("conclusion", "string", "Concise and clinically contextualized summary conclusion (interpretation/impression) of the diagnostic report.", 0, 1, conclusion));
        children.add(new Property("conclusionCode", "CodeableConcept", "One or more codes that represent the summary conclusion (interpretation/impression) of the diagnostic report.", 0, java.lang.Integer.MAX_VALUE, conclusionCode));
        children.add(new Property("presentedForm", "Attachment", "Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they SHALL be semantically equivalent.", 0, java.lang.Integer.MAX_VALUE, presentedForm));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers assigned to this report by the performer or other systems.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|ImmunizationRecommendation|MedicationRequest|NutritionOrder|ServiceRequest)", "Details concerning a service requested.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the diagnostic report.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A code that classifies the clinical discipline, department or diagnostic service that created the report (e.g. cardiology, biochemistry, hematology, MRI). This is used for searching, sorting and display purposes.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code or name that describes this diagnostic report.", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct)", "The subject of the report. Usually, but not always, this is a patient. However, diagnostic services also perform analyses on specimens collected from a variety of other sources.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The healthcare event  (e.g. a patient and healthcare provider interaction) which this DiagnosticReport is about.", 0, 1, encounter);
        case 247104889: /*effective[x]*/  return new Property("effective[x]", "dateTime|Period", "The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -1468651097: /*effective*/  return new Property("effective[x]", "dateTime|Period", "The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -275306910: /*effectiveDateTime*/  return new Property("effective[x]", "dateTime", "The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -403934648: /*effectivePeriod*/  return new Property("effective[x]", "Period", "The time or time-period the observed values are related to. When the subject of the report is a patient, this is usually either the time of the procedure or of specimen collection(s), but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -1179159893: /*issued*/  return new Property("issued", "instant", "The date and time that this version of the report was made available to providers, typically after the report was reviewed and verified.", 0, 1, issued);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam)", "The diagnostic service that is responsible for issuing the report.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 2134944932: /*resultsInterpreter*/  return new Property("resultsInterpreter", "Reference(Practitioner|PractitionerRole|Organization|CareTeam)", "The practitioner or organization that is responsible for the report's conclusions and interpretations.", 0, java.lang.Integer.MAX_VALUE, resultsInterpreter);
        case -2132868344: /*specimen*/  return new Property("specimen", "Reference(Specimen)", "Details about the specimens on which this diagnostic report is based.", 0, java.lang.Integer.MAX_VALUE, specimen);
        case -934426595: /*result*/  return new Property("result", "Reference(Observation)", "[Observations](observation.html)  that are part of this diagnostic report.", 0, java.lang.Integer.MAX_VALUE, result);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Comments about the diagnostic report.", 0, java.lang.Integer.MAX_VALUE, note);
        case -814900911: /*imagingStudy*/  return new Property("imagingStudy", "Reference(ImagingStudy)", "One or more links to full details of any imaging performed during the diagnostic investigation. Typically, this is imaging performed by DICOM enabled modalities, but this is not required. A fully enabled PACS viewer can use this information to provide views of the source images.", 0, java.lang.Integer.MAX_VALUE, imagingStudy);
        case 103772132: /*media*/  return new Property("media", "", "A list of key images or data associated with this report. The images or data are generally created during the diagnostic process, and may be directly of the patient, or of treated specimens (i.e. slides of interest).", 0, java.lang.Integer.MAX_VALUE, media);
        case -838923862: /*composition*/  return new Property("composition", "Reference(Composition)", "Reference to a Composition resource instance that provides structure for organizing the contents of the DiagnosticReport.", 0, 1, composition);
        case -1731259873: /*conclusion*/  return new Property("conclusion", "string", "Concise and clinically contextualized summary conclusion (interpretation/impression) of the diagnostic report.", 0, 1, conclusion);
        case -1731523412: /*conclusionCode*/  return new Property("conclusionCode", "CodeableConcept", "One or more codes that represent the summary conclusion (interpretation/impression) of the diagnostic report.", 0, java.lang.Integer.MAX_VALUE, conclusionCode);
        case 230090366: /*presentedForm*/  return new Property("presentedForm", "Attachment", "Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they SHALL be semantically equivalent.", 0, java.lang.Integer.MAX_VALUE, presentedForm);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<DiagnosticReportStatus>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1468651097: /*effective*/ return this.effective == null ? new Base[0] : new Base[] {this.effective}; // DataType
        case -1179159893: /*issued*/ return this.issued == null ? new Base[0] : new Base[] {this.issued}; // InstantType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // Reference
        case 2134944932: /*resultsInterpreter*/ return this.resultsInterpreter == null ? new Base[0] : this.resultsInterpreter.toArray(new Base[this.resultsInterpreter.size()]); // Reference
        case -2132868344: /*specimen*/ return this.specimen == null ? new Base[0] : this.specimen.toArray(new Base[this.specimen.size()]); // Reference
        case -934426595: /*result*/ return this.result == null ? new Base[0] : this.result.toArray(new Base[this.result.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -814900911: /*imagingStudy*/ return this.imagingStudy == null ? new Base[0] : this.imagingStudy.toArray(new Base[this.imagingStudy.size()]); // Reference
        case 103772132: /*media*/ return this.media == null ? new Base[0] : this.media.toArray(new Base[this.media.size()]); // DiagnosticReportMediaComponent
        case -838923862: /*composition*/ return this.composition == null ? new Base[0] : new Base[] {this.composition}; // Reference
        case -1731259873: /*conclusion*/ return this.conclusion == null ? new Base[0] : new Base[] {this.conclusion}; // StringType
        case -1731523412: /*conclusionCode*/ return this.conclusionCode == null ? new Base[0] : this.conclusionCode.toArray(new Base[this.conclusionCode.size()]); // CodeableConcept
        case 230090366: /*presentedForm*/ return this.presentedForm == null ? new Base[0] : this.presentedForm.toArray(new Base[this.presentedForm.size()]); // Attachment
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new DiagnosticReportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DiagnosticReportStatus>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1468651097: // effective
          this.effective = TypeConvertor.castToType(value); // DataType
          return value;
        case -1179159893: // issued
          this.issued = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 481140686: // performer
          this.getPerformer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 2134944932: // resultsInterpreter
          this.getResultsInterpreter().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -2132868344: // specimen
          this.getSpecimen().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -934426595: // result
          this.getResult().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -814900911: // imagingStudy
          this.getImagingStudy().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 103772132: // media
          this.getMedia().add((DiagnosticReportMediaComponent) value); // DiagnosticReportMediaComponent
          return value;
        case -838923862: // composition
          this.composition = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1731259873: // conclusion
          this.conclusion = TypeConvertor.castToString(value); // StringType
          return value;
        case -1731523412: // conclusionCode
          this.getConclusionCode().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 230090366: // presentedForm
          this.getPresentedForm().add(TypeConvertor.castToAttachment(value)); // Attachment
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new DiagnosticReportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DiagnosticReportStatus>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("effective[x]")) {
          this.effective = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("issued")) {
          this.issued = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("performer")) {
          this.getPerformer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("resultsInterpreter")) {
          this.getResultsInterpreter().add(TypeConvertor.castToReference(value));
        } else if (name.equals("specimen")) {
          this.getSpecimen().add(TypeConvertor.castToReference(value));
        } else if (name.equals("result")) {
          this.getResult().add(TypeConvertor.castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("imagingStudy")) {
          this.getImagingStudy().add(TypeConvertor.castToReference(value));
        } else if (name.equals("media")) {
          this.getMedia().add((DiagnosticReportMediaComponent) value);
        } else if (name.equals("composition")) {
          this.composition = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("conclusion")) {
          this.conclusion = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("conclusionCode")) {
          this.getConclusionCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("presentedForm")) {
          this.getPresentedForm().add(TypeConvertor.castToAttachment(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -892481550:  return getStatusElement();
        case 50511102:  return addCategory(); 
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case 247104889:  return getEffective();
        case -1468651097:  return getEffective();
        case -1179159893:  return getIssuedElement();
        case 481140686:  return addPerformer(); 
        case 2134944932:  return addResultsInterpreter(); 
        case -2132868344:  return addSpecimen(); 
        case -934426595:  return addResult(); 
        case 3387378:  return addNote(); 
        case -814900911:  return addImagingStudy(); 
        case 103772132:  return addMedia(); 
        case -838923862:  return getComposition();
        case -1731259873:  return getConclusionElement();
        case -1731523412:  return addConclusionCode(); 
        case 230090366:  return addPresentedForm(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1468651097: /*effective*/ return new String[] {"dateTime", "Period"};
        case -1179159893: /*issued*/ return new String[] {"instant"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case 2134944932: /*resultsInterpreter*/ return new String[] {"Reference"};
        case -2132868344: /*specimen*/ return new String[] {"Reference"};
        case -934426595: /*result*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -814900911: /*imagingStudy*/ return new String[] {"Reference"};
        case 103772132: /*media*/ return new String[] {};
        case -838923862: /*composition*/ return new String[] {"Reference"};
        case -1731259873: /*conclusion*/ return new String[] {"string"};
        case -1731523412: /*conclusionCode*/ return new String[] {"CodeableConcept"};
        case 230090366: /*presentedForm*/ return new String[] {"Attachment"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type DiagnosticReport.status");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("effectiveDateTime")) {
          this.effective = new DateTimeType();
          return this.effective;
        }
        else if (name.equals("effectivePeriod")) {
          this.effective = new Period();
          return this.effective;
        }
        else if (name.equals("issued")) {
          throw new FHIRException("Cannot call addChild on a primitive type DiagnosticReport.issued");
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("resultsInterpreter")) {
          return addResultsInterpreter();
        }
        else if (name.equals("specimen")) {
          return addSpecimen();
        }
        else if (name.equals("result")) {
          return addResult();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("imagingStudy")) {
          return addImagingStudy();
        }
        else if (name.equals("media")) {
          return addMedia();
        }
        else if (name.equals("composition")) {
          this.composition = new Reference();
          return this.composition;
        }
        else if (name.equals("conclusion")) {
          throw new FHIRException("Cannot call addChild on a primitive type DiagnosticReport.conclusion");
        }
        else if (name.equals("conclusionCode")) {
          return addConclusionCode();
        }
        else if (name.equals("presentedForm")) {
          return addPresentedForm();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DiagnosticReport";

  }

      public DiagnosticReport copy() {
        DiagnosticReport dst = new DiagnosticReport();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DiagnosticReport dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.effective = effective == null ? null : effective.copy();
        dst.issued = issued == null ? null : issued.copy();
        if (performer != null) {
          dst.performer = new ArrayList<Reference>();
          for (Reference i : performer)
            dst.performer.add(i.copy());
        };
        if (resultsInterpreter != null) {
          dst.resultsInterpreter = new ArrayList<Reference>();
          for (Reference i : resultsInterpreter)
            dst.resultsInterpreter.add(i.copy());
        };
        if (specimen != null) {
          dst.specimen = new ArrayList<Reference>();
          for (Reference i : specimen)
            dst.specimen.add(i.copy());
        };
        if (result != null) {
          dst.result = new ArrayList<Reference>();
          for (Reference i : result)
            dst.result.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (imagingStudy != null) {
          dst.imagingStudy = new ArrayList<Reference>();
          for (Reference i : imagingStudy)
            dst.imagingStudy.add(i.copy());
        };
        if (media != null) {
          dst.media = new ArrayList<DiagnosticReportMediaComponent>();
          for (DiagnosticReportMediaComponent i : media)
            dst.media.add(i.copy());
        };
        dst.composition = composition == null ? null : composition.copy();
        dst.conclusion = conclusion == null ? null : conclusion.copy();
        if (conclusionCode != null) {
          dst.conclusionCode = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : conclusionCode)
            dst.conclusionCode.add(i.copy());
        };
        if (presentedForm != null) {
          dst.presentedForm = new ArrayList<Attachment>();
          for (Attachment i : presentedForm)
            dst.presentedForm.add(i.copy());
        };
      }

      protected DiagnosticReport typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DiagnosticReport))
          return false;
        DiagnosticReport o = (DiagnosticReport) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(status, o.status, true)
           && compareDeep(category, o.category, true) && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(effective, o.effective, true) && compareDeep(issued, o.issued, true)
           && compareDeep(performer, o.performer, true) && compareDeep(resultsInterpreter, o.resultsInterpreter, true)
           && compareDeep(specimen, o.specimen, true) && compareDeep(result, o.result, true) && compareDeep(note, o.note, true)
           && compareDeep(imagingStudy, o.imagingStudy, true) && compareDeep(media, o.media, true) && compareDeep(composition, o.composition, true)
           && compareDeep(conclusion, o.conclusion, true) && compareDeep(conclusionCode, o.conclusionCode, true)
           && compareDeep(presentedForm, o.presentedForm, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DiagnosticReport))
          return false;
        DiagnosticReport o = (DiagnosticReport) other_;
        return compareValues(status, o.status, true) && compareValues(issued, o.issued, true) && compareValues(conclusion, o.conclusion, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, status
          , category, code, subject, encounter, effective, issued, performer, resultsInterpreter
          , specimen, result, note, imagingStudy, media, composition, conclusion, conclusionCode
          , presentedForm);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DiagnosticReport;
   }


}

