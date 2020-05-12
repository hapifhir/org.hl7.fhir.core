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
 * A single usage issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.
 */
@ResourceDef(name="ClinicalUseIssue", profile="http://hl7.org/fhir/StructureDefinition/ClinicalUseIssue")
public class ClinicalUseIssue extends DomainResource {

    public enum ClinicalUseIssueType {
        /**
         * A reason for giving the medicaton.
         */
        INDICATION, 
        /**
         * A reason for not giving the medicaition.
         */
        CONTRAINDICATION, 
        /**
         * Interactions between the medication and other substances.
         */
        INTERACTION, 
        /**
         * Side effects or adverse effects associated with the medication.
         */
        UNDESIRABLEEFFECT, 
        /**
         * A general warning or issue that is not specifically one of the other types.
         */
        WARNING, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ClinicalUseIssueType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("indication".equals(codeString))
          return INDICATION;
        if ("contraindication".equals(codeString))
          return CONTRAINDICATION;
        if ("interaction".equals(codeString))
          return INTERACTION;
        if ("undesirable-effect".equals(codeString))
          return UNDESIRABLEEFFECT;
        if ("warning".equals(codeString))
          return WARNING;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ClinicalUseIssueType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INDICATION: return "indication";
            case CONTRAINDICATION: return "contraindication";
            case INTERACTION: return "interaction";
            case UNDESIRABLEEFFECT: return "undesirable-effect";
            case WARNING: return "warning";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INDICATION: return "http://hl7.org/fhir/clinical-use-issue-type";
            case CONTRAINDICATION: return "http://hl7.org/fhir/clinical-use-issue-type";
            case INTERACTION: return "http://hl7.org/fhir/clinical-use-issue-type";
            case UNDESIRABLEEFFECT: return "http://hl7.org/fhir/clinical-use-issue-type";
            case WARNING: return "http://hl7.org/fhir/clinical-use-issue-type";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INDICATION: return "A reason for giving the medicaton.";
            case CONTRAINDICATION: return "A reason for not giving the medicaition.";
            case INTERACTION: return "Interactions between the medication and other substances.";
            case UNDESIRABLEEFFECT: return "Side effects or adverse effects associated with the medication.";
            case WARNING: return "A general warning or issue that is not specifically one of the other types.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INDICATION: return "Indication";
            case CONTRAINDICATION: return "Contraindication";
            case INTERACTION: return "Interaction";
            case UNDESIRABLEEFFECT: return "Undesirable Effect";
            case WARNING: return "Warning";
            default: return "?";
          }
        }
    }

  public static class ClinicalUseIssueTypeEnumFactory implements EnumFactory<ClinicalUseIssueType> {
    public ClinicalUseIssueType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("indication".equals(codeString))
          return ClinicalUseIssueType.INDICATION;
        if ("contraindication".equals(codeString))
          return ClinicalUseIssueType.CONTRAINDICATION;
        if ("interaction".equals(codeString))
          return ClinicalUseIssueType.INTERACTION;
        if ("undesirable-effect".equals(codeString))
          return ClinicalUseIssueType.UNDESIRABLEEFFECT;
        if ("warning".equals(codeString))
          return ClinicalUseIssueType.WARNING;
        throw new IllegalArgumentException("Unknown ClinicalUseIssueType code '"+codeString+"'");
        }
        public Enumeration<ClinicalUseIssueType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ClinicalUseIssueType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("indication".equals(codeString))
          return new Enumeration<ClinicalUseIssueType>(this, ClinicalUseIssueType.INDICATION);
        if ("contraindication".equals(codeString))
          return new Enumeration<ClinicalUseIssueType>(this, ClinicalUseIssueType.CONTRAINDICATION);
        if ("interaction".equals(codeString))
          return new Enumeration<ClinicalUseIssueType>(this, ClinicalUseIssueType.INTERACTION);
        if ("undesirable-effect".equals(codeString))
          return new Enumeration<ClinicalUseIssueType>(this, ClinicalUseIssueType.UNDESIRABLEEFFECT);
        if ("warning".equals(codeString))
          return new Enumeration<ClinicalUseIssueType>(this, ClinicalUseIssueType.WARNING);
        throw new FHIRException("Unknown ClinicalUseIssueType code '"+codeString+"'");
        }
    public String toCode(ClinicalUseIssueType code) {
      if (code == ClinicalUseIssueType.INDICATION)
        return "indication";
      if (code == ClinicalUseIssueType.CONTRAINDICATION)
        return "contraindication";
      if (code == ClinicalUseIssueType.INTERACTION)
        return "interaction";
      if (code == ClinicalUseIssueType.UNDESIRABLEEFFECT)
        return "undesirable-effect";
      if (code == ClinicalUseIssueType.WARNING)
        return "warning";
      return "?";
      }
    public String toSystem(ClinicalUseIssueType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ClinicalUseIssueContraindicationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The situation that is being documented as contraindicating against this item.
         */
        @Child(name = "diseaseSymptomProcedure", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The situation that is being documented as contraindicating against this item", formalDefinition="The situation that is being documented as contraindicating against this item." )
        protected CodeableConcept diseaseSymptomProcedure;

        /**
         * The status of the disease or symptom for the contraindication.
         */
        @Child(name = "diseaseStatus", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status of the disease or symptom for the contraindication", formalDefinition="The status of the disease or symptom for the contraindication." )
        protected CodeableConcept diseaseStatus;

        /**
         * A comorbidity (concurrent condition) or coinfection.
         */
        @Child(name = "comorbidity", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A comorbidity (concurrent condition) or coinfection", formalDefinition="A comorbidity (concurrent condition) or coinfection." )
        protected List<CodeableConcept> comorbidity;

        /**
         * The indication which this is a contraidication for.
         */
        @Child(name = "indication", type = {ClinicalUseIssue.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The indication which this is a contraidication for", formalDefinition="The indication which this is a contraidication for." )
        protected List<Reference> indication;

        /**
         * Information about the use of the medicinal product in relation to other therapies described as part of the indication.
         */
        @Child(name = "otherTherapy", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Information about the use of the medicinal product in relation to other therapies described as part of the indication", formalDefinition="Information about the use of the medicinal product in relation to other therapies described as part of the indication." )
        protected List<ClinicalUseIssueContraindicationOtherTherapyComponent> otherTherapy;

        private static final long serialVersionUID = -165584476L;

    /**
     * Constructor
     */
      public ClinicalUseIssueContraindicationComponent() {
        super();
      }

        /**
         * @return {@link #diseaseSymptomProcedure} (The situation that is being documented as contraindicating against this item.)
         */
        public CodeableConcept getDiseaseSymptomProcedure() { 
          if (this.diseaseSymptomProcedure == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueContraindicationComponent.diseaseSymptomProcedure");
            else if (Configuration.doAutoCreate())
              this.diseaseSymptomProcedure = new CodeableConcept(); // cc
          return this.diseaseSymptomProcedure;
        }

        public boolean hasDiseaseSymptomProcedure() { 
          return this.diseaseSymptomProcedure != null && !this.diseaseSymptomProcedure.isEmpty();
        }

        /**
         * @param value {@link #diseaseSymptomProcedure} (The situation that is being documented as contraindicating against this item.)
         */
        public ClinicalUseIssueContraindicationComponent setDiseaseSymptomProcedure(CodeableConcept value) { 
          this.diseaseSymptomProcedure = value;
          return this;
        }

        /**
         * @return {@link #diseaseStatus} (The status of the disease or symptom for the contraindication.)
         */
        public CodeableConcept getDiseaseStatus() { 
          if (this.diseaseStatus == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueContraindicationComponent.diseaseStatus");
            else if (Configuration.doAutoCreate())
              this.diseaseStatus = new CodeableConcept(); // cc
          return this.diseaseStatus;
        }

        public boolean hasDiseaseStatus() { 
          return this.diseaseStatus != null && !this.diseaseStatus.isEmpty();
        }

        /**
         * @param value {@link #diseaseStatus} (The status of the disease or symptom for the contraindication.)
         */
        public ClinicalUseIssueContraindicationComponent setDiseaseStatus(CodeableConcept value) { 
          this.diseaseStatus = value;
          return this;
        }

        /**
         * @return {@link #comorbidity} (A comorbidity (concurrent condition) or coinfection.)
         */
        public List<CodeableConcept> getComorbidity() { 
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableConcept>();
          return this.comorbidity;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseIssueContraindicationComponent setComorbidity(List<CodeableConcept> theComorbidity) { 
          this.comorbidity = theComorbidity;
          return this;
        }

        public boolean hasComorbidity() { 
          if (this.comorbidity == null)
            return false;
          for (CodeableConcept item : this.comorbidity)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addComorbidity() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableConcept>();
          this.comorbidity.add(t);
          return t;
        }

        public ClinicalUseIssueContraindicationComponent addComorbidity(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableConcept>();
          this.comorbidity.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #comorbidity}, creating it if it does not already exist {3}
         */
        public CodeableConcept getComorbidityFirstRep() { 
          if (getComorbidity().isEmpty()) {
            addComorbidity();
          }
          return getComorbidity().get(0);
        }

        /**
         * @return {@link #indication} (The indication which this is a contraidication for.)
         */
        public List<Reference> getIndication() { 
          if (this.indication == null)
            this.indication = new ArrayList<Reference>();
          return this.indication;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseIssueContraindicationComponent setIndication(List<Reference> theIndication) { 
          this.indication = theIndication;
          return this;
        }

        public boolean hasIndication() { 
          if (this.indication == null)
            return false;
          for (Reference item : this.indication)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addIndication() { //3
          Reference t = new Reference();
          if (this.indication == null)
            this.indication = new ArrayList<Reference>();
          this.indication.add(t);
          return t;
        }

        public ClinicalUseIssueContraindicationComponent addIndication(Reference t) { //3
          if (t == null)
            return this;
          if (this.indication == null)
            this.indication = new ArrayList<Reference>();
          this.indication.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #indication}, creating it if it does not already exist {3}
         */
        public Reference getIndicationFirstRep() { 
          if (getIndication().isEmpty()) {
            addIndication();
          }
          return getIndication().get(0);
        }

        /**
         * @return {@link #otherTherapy} (Information about the use of the medicinal product in relation to other therapies described as part of the indication.)
         */
        public List<ClinicalUseIssueContraindicationOtherTherapyComponent> getOtherTherapy() { 
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseIssueContraindicationOtherTherapyComponent>();
          return this.otherTherapy;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseIssueContraindicationComponent setOtherTherapy(List<ClinicalUseIssueContraindicationOtherTherapyComponent> theOtherTherapy) { 
          this.otherTherapy = theOtherTherapy;
          return this;
        }

        public boolean hasOtherTherapy() { 
          if (this.otherTherapy == null)
            return false;
          for (ClinicalUseIssueContraindicationOtherTherapyComponent item : this.otherTherapy)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ClinicalUseIssueContraindicationOtherTherapyComponent addOtherTherapy() { //3
          ClinicalUseIssueContraindicationOtherTherapyComponent t = new ClinicalUseIssueContraindicationOtherTherapyComponent();
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseIssueContraindicationOtherTherapyComponent>();
          this.otherTherapy.add(t);
          return t;
        }

        public ClinicalUseIssueContraindicationComponent addOtherTherapy(ClinicalUseIssueContraindicationOtherTherapyComponent t) { //3
          if (t == null)
            return this;
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseIssueContraindicationOtherTherapyComponent>();
          this.otherTherapy.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #otherTherapy}, creating it if it does not already exist {3}
         */
        public ClinicalUseIssueContraindicationOtherTherapyComponent getOtherTherapyFirstRep() { 
          if (getOtherTherapy().isEmpty()) {
            addOtherTherapy();
          }
          return getOtherTherapy().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("diseaseSymptomProcedure", "CodeableConcept", "The situation that is being documented as contraindicating against this item.", 0, 1, diseaseSymptomProcedure));
          children.add(new Property("diseaseStatus", "CodeableConcept", "The status of the disease or symptom for the contraindication.", 0, 1, diseaseStatus));
          children.add(new Property("comorbidity", "CodeableConcept", "A comorbidity (concurrent condition) or coinfection.", 0, java.lang.Integer.MAX_VALUE, comorbidity));
          children.add(new Property("indication", "Reference(ClinicalUseIssue)", "The indication which this is a contraidication for.", 0, java.lang.Integer.MAX_VALUE, indication));
          children.add(new Property("otherTherapy", "", "Information about the use of the medicinal product in relation to other therapies described as part of the indication.", 0, java.lang.Integer.MAX_VALUE, otherTherapy));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1497395130: /*diseaseSymptomProcedure*/  return new Property("diseaseSymptomProcedure", "CodeableConcept", "The situation that is being documented as contraindicating against this item.", 0, 1, diseaseSymptomProcedure);
          case -505503602: /*diseaseStatus*/  return new Property("diseaseStatus", "CodeableConcept", "The status of the disease or symptom for the contraindication.", 0, 1, diseaseStatus);
          case -406395211: /*comorbidity*/  return new Property("comorbidity", "CodeableConcept", "A comorbidity (concurrent condition) or coinfection.", 0, java.lang.Integer.MAX_VALUE, comorbidity);
          case -597168804: /*indication*/  return new Property("indication", "Reference(ClinicalUseIssue)", "The indication which this is a contraidication for.", 0, java.lang.Integer.MAX_VALUE, indication);
          case -544509127: /*otherTherapy*/  return new Property("otherTherapy", "", "Information about the use of the medicinal product in relation to other therapies described as part of the indication.", 0, java.lang.Integer.MAX_VALUE, otherTherapy);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1497395130: /*diseaseSymptomProcedure*/ return this.diseaseSymptomProcedure == null ? new Base[0] : new Base[] {this.diseaseSymptomProcedure}; // CodeableConcept
        case -505503602: /*diseaseStatus*/ return this.diseaseStatus == null ? new Base[0] : new Base[] {this.diseaseStatus}; // CodeableConcept
        case -406395211: /*comorbidity*/ return this.comorbidity == null ? new Base[0] : this.comorbidity.toArray(new Base[this.comorbidity.size()]); // CodeableConcept
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : this.indication.toArray(new Base[this.indication.size()]); // Reference
        case -544509127: /*otherTherapy*/ return this.otherTherapy == null ? new Base[0] : this.otherTherapy.toArray(new Base[this.otherTherapy.size()]); // ClinicalUseIssueContraindicationOtherTherapyComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1497395130: // diseaseSymptomProcedure
          this.diseaseSymptomProcedure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -505503602: // diseaseStatus
          this.diseaseStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -406395211: // comorbidity
          this.getComorbidity().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -597168804: // indication
          this.getIndication().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -544509127: // otherTherapy
          this.getOtherTherapy().add((ClinicalUseIssueContraindicationOtherTherapyComponent) value); // ClinicalUseIssueContraindicationOtherTherapyComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("comorbidity")) {
          this.getComorbidity().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("indication")) {
          this.getIndication().add(TypeConvertor.castToReference(value));
        } else if (name.equals("otherTherapy")) {
          this.getOtherTherapy().add((ClinicalUseIssueContraindicationOtherTherapyComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1497395130:  return getDiseaseSymptomProcedure();
        case -505503602:  return getDiseaseStatus();
        case -406395211:  return addComorbidity(); 
        case -597168804:  return addIndication(); 
        case -544509127:  return addOtherTherapy(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1497395130: /*diseaseSymptomProcedure*/ return new String[] {"CodeableConcept"};
        case -505503602: /*diseaseStatus*/ return new String[] {"CodeableConcept"};
        case -406395211: /*comorbidity*/ return new String[] {"CodeableConcept"};
        case -597168804: /*indication*/ return new String[] {"Reference"};
        case -544509127: /*otherTherapy*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = new CodeableConcept();
          return this.diseaseSymptomProcedure;
        }
        else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = new CodeableConcept();
          return this.diseaseStatus;
        }
        else if (name.equals("comorbidity")) {
          return addComorbidity();
        }
        else if (name.equals("indication")) {
          return addIndication();
        }
        else if (name.equals("otherTherapy")) {
          return addOtherTherapy();
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseIssueContraindicationComponent copy() {
        ClinicalUseIssueContraindicationComponent dst = new ClinicalUseIssueContraindicationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseIssueContraindicationComponent dst) {
        super.copyValues(dst);
        dst.diseaseSymptomProcedure = diseaseSymptomProcedure == null ? null : diseaseSymptomProcedure.copy();
        dst.diseaseStatus = diseaseStatus == null ? null : diseaseStatus.copy();
        if (comorbidity != null) {
          dst.comorbidity = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : comorbidity)
            dst.comorbidity.add(i.copy());
        };
        if (indication != null) {
          dst.indication = new ArrayList<Reference>();
          for (Reference i : indication)
            dst.indication.add(i.copy());
        };
        if (otherTherapy != null) {
          dst.otherTherapy = new ArrayList<ClinicalUseIssueContraindicationOtherTherapyComponent>();
          for (ClinicalUseIssueContraindicationOtherTherapyComponent i : otherTherapy)
            dst.otherTherapy.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueContraindicationComponent))
          return false;
        ClinicalUseIssueContraindicationComponent o = (ClinicalUseIssueContraindicationComponent) other_;
        return compareDeep(diseaseSymptomProcedure, o.diseaseSymptomProcedure, true) && compareDeep(diseaseStatus, o.diseaseStatus, true)
           && compareDeep(comorbidity, o.comorbidity, true) && compareDeep(indication, o.indication, true)
           && compareDeep(otherTherapy, o.otherTherapy, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueContraindicationComponent))
          return false;
        ClinicalUseIssueContraindicationComponent o = (ClinicalUseIssueContraindicationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(diseaseSymptomProcedure, diseaseStatus
          , comorbidity, indication, otherTherapy);
      }

  public String fhirType() {
    return "ClinicalUseIssue.contraindication";

  }

  }

    @Block()
    public static class ClinicalUseIssueContraindicationOtherTherapyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of relationship between the medicinal product indication or contraindication and another therapy.
         */
        @Child(name = "therapyRelationshipType", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of relationship between the medicinal product indication or contraindication and another therapy", formalDefinition="The type of relationship between the medicinal product indication or contraindication and another therapy." )
        protected CodeableConcept therapyRelationshipType;

        /**
         * Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.
         */
        @Child(name = "medication", type = {CodeableConcept.class, MedicinalProductDefinition.class, Medication.class, Substance.class, SubstanceDefinition.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication", formalDefinition="Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication." )
        protected DataType medication;

        private static final long serialVersionUID = -923241363L;

    /**
     * Constructor
     */
      public ClinicalUseIssueContraindicationOtherTherapyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ClinicalUseIssueContraindicationOtherTherapyComponent(CodeableConcept therapyRelationshipType, DataType medication) {
        super();
        this.setTherapyRelationshipType(therapyRelationshipType);
        this.setMedication(medication);
      }

        /**
         * @return {@link #therapyRelationshipType} (The type of relationship between the medicinal product indication or contraindication and another therapy.)
         */
        public CodeableConcept getTherapyRelationshipType() { 
          if (this.therapyRelationshipType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueContraindicationOtherTherapyComponent.therapyRelationshipType");
            else if (Configuration.doAutoCreate())
              this.therapyRelationshipType = new CodeableConcept(); // cc
          return this.therapyRelationshipType;
        }

        public boolean hasTherapyRelationshipType() { 
          return this.therapyRelationshipType != null && !this.therapyRelationshipType.isEmpty();
        }

        /**
         * @param value {@link #therapyRelationshipType} (The type of relationship between the medicinal product indication or contraindication and another therapy.)
         */
        public ClinicalUseIssueContraindicationOtherTherapyComponent setTherapyRelationshipType(CodeableConcept value) { 
          this.therapyRelationshipType = value;
          return this;
        }

        /**
         * @return {@link #medication} (Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.)
         */
        public DataType getMedication() { 
          return this.medication;
        }

        /**
         * @return {@link #medication} (Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.)
         */
        public CodeableConcept getMedicationCodeableConcept() throws FHIRException { 
          if (this.medication == null)
            this.medication = new CodeableConcept();
          if (!(this.medication instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.medication.getClass().getName()+" was encountered");
          return (CodeableConcept) this.medication;
        }

        public boolean hasMedicationCodeableConcept() { 
          return this != null && this.medication instanceof CodeableConcept;
        }

        /**
         * @return {@link #medication} (Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.)
         */
        public Reference getMedicationReference() throws FHIRException { 
          if (this.medication == null)
            this.medication = new Reference();
          if (!(this.medication instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.medication.getClass().getName()+" was encountered");
          return (Reference) this.medication;
        }

        public boolean hasMedicationReference() { 
          return this != null && this.medication instanceof Reference;
        }

        public boolean hasMedication() { 
          return this.medication != null && !this.medication.isEmpty();
        }

        /**
         * @param value {@link #medication} (Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.)
         */
        public ClinicalUseIssueContraindicationOtherTherapyComponent setMedication(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for ClinicalUseIssue.contraindication.otherTherapy.medication[x]: "+value.fhirType());
          this.medication = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("therapyRelationshipType", "CodeableConcept", "The type of relationship between the medicinal product indication or contraindication and another therapy.", 0, 1, therapyRelationshipType));
          children.add(new Property("medication[x]", "CodeableConcept|Reference(MedicinalProductDefinition|Medication|Substance|SubstanceDefinition)", "Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.", 0, 1, medication));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -551658469: /*therapyRelationshipType*/  return new Property("therapyRelationshipType", "CodeableConcept", "The type of relationship between the medicinal product indication or contraindication and another therapy.", 0, 1, therapyRelationshipType);
          case 1458402129: /*medication[x]*/  return new Property("medication[x]", "CodeableConcept|Reference(MedicinalProductDefinition|Medication|Substance|SubstanceDefinition)", "Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.", 0, 1, medication);
          case 1998965455: /*medication*/  return new Property("medication[x]", "CodeableConcept|Reference(MedicinalProductDefinition|Medication|Substance|SubstanceDefinition)", "Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.", 0, 1, medication);
          case -209845038: /*medicationCodeableConcept*/  return new Property("medication[x]", "CodeableConcept", "Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.", 0, 1, medication);
          case 2104315196: /*medicationReference*/  return new Property("medication[x]", "Reference(MedicinalProductDefinition|Medication|Substance|SubstanceDefinition)", "Reference to a specific medication (active substance, medicinal product or class of products) as part of an indication or contraindication.", 0, 1, medication);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -551658469: /*therapyRelationshipType*/ return this.therapyRelationshipType == null ? new Base[0] : new Base[] {this.therapyRelationshipType}; // CodeableConcept
        case 1998965455: /*medication*/ return this.medication == null ? new Base[0] : new Base[] {this.medication}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -551658469: // therapyRelationshipType
          this.therapyRelationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1998965455: // medication
          this.medication = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("therapyRelationshipType")) {
          this.therapyRelationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("medication[x]")) {
          this.medication = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -551658469:  return getTherapyRelationshipType();
        case 1458402129:  return getMedication();
        case 1998965455:  return getMedication();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -551658469: /*therapyRelationshipType*/ return new String[] {"CodeableConcept"};
        case 1998965455: /*medication*/ return new String[] {"CodeableConcept", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("therapyRelationshipType")) {
          this.therapyRelationshipType = new CodeableConcept();
          return this.therapyRelationshipType;
        }
        else if (name.equals("medicationCodeableConcept")) {
          this.medication = new CodeableConcept();
          return this.medication;
        }
        else if (name.equals("medicationReference")) {
          this.medication = new Reference();
          return this.medication;
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseIssueContraindicationOtherTherapyComponent copy() {
        ClinicalUseIssueContraindicationOtherTherapyComponent dst = new ClinicalUseIssueContraindicationOtherTherapyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseIssueContraindicationOtherTherapyComponent dst) {
        super.copyValues(dst);
        dst.therapyRelationshipType = therapyRelationshipType == null ? null : therapyRelationshipType.copy();
        dst.medication = medication == null ? null : medication.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueContraindicationOtherTherapyComponent))
          return false;
        ClinicalUseIssueContraindicationOtherTherapyComponent o = (ClinicalUseIssueContraindicationOtherTherapyComponent) other_;
        return compareDeep(therapyRelationshipType, o.therapyRelationshipType, true) && compareDeep(medication, o.medication, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueContraindicationOtherTherapyComponent))
          return false;
        ClinicalUseIssueContraindicationOtherTherapyComponent o = (ClinicalUseIssueContraindicationOtherTherapyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(therapyRelationshipType, medication
          );
      }

  public String fhirType() {
    return "ClinicalUseIssue.contraindication.otherTherapy";

  }

  }

    @Block()
    public static class ClinicalUseIssueIndicationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The situation that is being documented as an indicaton for this item.
         */
        @Child(name = "diseaseSymptomProcedure", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The situation that is being documented as an indicaton for this item", formalDefinition="The situation that is being documented as an indicaton for this item." )
        protected CodeableConcept diseaseSymptomProcedure;

        /**
         * The status of the disease or symptom for the indication.
         */
        @Child(name = "diseaseStatus", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status of the disease or symptom for the indication", formalDefinition="The status of the disease or symptom for the indication." )
        protected CodeableConcept diseaseStatus;

        /**
         * A comorbidity (concurrent condition) or coinfection as part of the indication.
         */
        @Child(name = "comorbidity", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A comorbidity (concurrent condition) or coinfection as part of the indication", formalDefinition="A comorbidity (concurrent condition) or coinfection as part of the indication." )
        protected List<CodeableConcept> comorbidity;

        /**
         * For an indication - the intended effect, aim or strategy to be achieved.
         */
        @Child(name = "intendedEffect", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="For an indication - the intended effect, aim or strategy to be achieved", formalDefinition="For an indication - the intended effect, aim or strategy to be achieved." )
        protected CodeableConcept intendedEffect;

        /**
         * For an indication - timing or duration information.
         */
        @Child(name = "duration", type = {Quantity.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="For an indication - timing or duration information", formalDefinition="For an indication - timing or duration information." )
        protected Quantity duration;

        /**
         * For an indicaton - the specific undesirable effects of the medicinal product.
         */
        @Child(name = "undesirableEffect", type = {ClinicalUseIssue.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="For an indicaton - the specific undesirable effects of the medicinal product", formalDefinition="For an indicaton - the specific undesirable effects of the medicinal product." )
        protected List<Reference> undesirableEffect;

        /**
         * Information about the use of the medicinal product in relation to other therapies described as part of the contraindication.
         */
        @Child(name = "otherTherapy", type = {ClinicalUseIssueContraindicationOtherTherapyComponent.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Information about the use of the medicinal product in relation to other therapies described as part of the contraindication", formalDefinition="Information about the use of the medicinal product in relation to other therapies described as part of the contraindication." )
        protected List<ClinicalUseIssueContraindicationOtherTherapyComponent> otherTherapy;

        private static final long serialVersionUID = -631720121L;

    /**
     * Constructor
     */
      public ClinicalUseIssueIndicationComponent() {
        super();
      }

        /**
         * @return {@link #diseaseSymptomProcedure} (The situation that is being documented as an indicaton for this item.)
         */
        public CodeableConcept getDiseaseSymptomProcedure() { 
          if (this.diseaseSymptomProcedure == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueIndicationComponent.diseaseSymptomProcedure");
            else if (Configuration.doAutoCreate())
              this.diseaseSymptomProcedure = new CodeableConcept(); // cc
          return this.diseaseSymptomProcedure;
        }

        public boolean hasDiseaseSymptomProcedure() { 
          return this.diseaseSymptomProcedure != null && !this.diseaseSymptomProcedure.isEmpty();
        }

        /**
         * @param value {@link #diseaseSymptomProcedure} (The situation that is being documented as an indicaton for this item.)
         */
        public ClinicalUseIssueIndicationComponent setDiseaseSymptomProcedure(CodeableConcept value) { 
          this.diseaseSymptomProcedure = value;
          return this;
        }

        /**
         * @return {@link #diseaseStatus} (The status of the disease or symptom for the indication.)
         */
        public CodeableConcept getDiseaseStatus() { 
          if (this.diseaseStatus == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueIndicationComponent.diseaseStatus");
            else if (Configuration.doAutoCreate())
              this.diseaseStatus = new CodeableConcept(); // cc
          return this.diseaseStatus;
        }

        public boolean hasDiseaseStatus() { 
          return this.diseaseStatus != null && !this.diseaseStatus.isEmpty();
        }

        /**
         * @param value {@link #diseaseStatus} (The status of the disease or symptom for the indication.)
         */
        public ClinicalUseIssueIndicationComponent setDiseaseStatus(CodeableConcept value) { 
          this.diseaseStatus = value;
          return this;
        }

        /**
         * @return {@link #comorbidity} (A comorbidity (concurrent condition) or coinfection as part of the indication.)
         */
        public List<CodeableConcept> getComorbidity() { 
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableConcept>();
          return this.comorbidity;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseIssueIndicationComponent setComorbidity(List<CodeableConcept> theComorbidity) { 
          this.comorbidity = theComorbidity;
          return this;
        }

        public boolean hasComorbidity() { 
          if (this.comorbidity == null)
            return false;
          for (CodeableConcept item : this.comorbidity)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addComorbidity() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableConcept>();
          this.comorbidity.add(t);
          return t;
        }

        public ClinicalUseIssueIndicationComponent addComorbidity(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableConcept>();
          this.comorbidity.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #comorbidity}, creating it if it does not already exist {3}
         */
        public CodeableConcept getComorbidityFirstRep() { 
          if (getComorbidity().isEmpty()) {
            addComorbidity();
          }
          return getComorbidity().get(0);
        }

        /**
         * @return {@link #intendedEffect} (For an indication - the intended effect, aim or strategy to be achieved.)
         */
        public CodeableConcept getIntendedEffect() { 
          if (this.intendedEffect == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueIndicationComponent.intendedEffect");
            else if (Configuration.doAutoCreate())
              this.intendedEffect = new CodeableConcept(); // cc
          return this.intendedEffect;
        }

        public boolean hasIntendedEffect() { 
          return this.intendedEffect != null && !this.intendedEffect.isEmpty();
        }

        /**
         * @param value {@link #intendedEffect} (For an indication - the intended effect, aim or strategy to be achieved.)
         */
        public ClinicalUseIssueIndicationComponent setIntendedEffect(CodeableConcept value) { 
          this.intendedEffect = value;
          return this;
        }

        /**
         * @return {@link #duration} (For an indication - timing or duration information.)
         */
        public Quantity getDuration() { 
          if (this.duration == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueIndicationComponent.duration");
            else if (Configuration.doAutoCreate())
              this.duration = new Quantity(); // cc
          return this.duration;
        }

        public boolean hasDuration() { 
          return this.duration != null && !this.duration.isEmpty();
        }

        /**
         * @param value {@link #duration} (For an indication - timing or duration information.)
         */
        public ClinicalUseIssueIndicationComponent setDuration(Quantity value) { 
          this.duration = value;
          return this;
        }

        /**
         * @return {@link #undesirableEffect} (For an indicaton - the specific undesirable effects of the medicinal product.)
         */
        public List<Reference> getUndesirableEffect() { 
          if (this.undesirableEffect == null)
            this.undesirableEffect = new ArrayList<Reference>();
          return this.undesirableEffect;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseIssueIndicationComponent setUndesirableEffect(List<Reference> theUndesirableEffect) { 
          this.undesirableEffect = theUndesirableEffect;
          return this;
        }

        public boolean hasUndesirableEffect() { 
          if (this.undesirableEffect == null)
            return false;
          for (Reference item : this.undesirableEffect)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addUndesirableEffect() { //3
          Reference t = new Reference();
          if (this.undesirableEffect == null)
            this.undesirableEffect = new ArrayList<Reference>();
          this.undesirableEffect.add(t);
          return t;
        }

        public ClinicalUseIssueIndicationComponent addUndesirableEffect(Reference t) { //3
          if (t == null)
            return this;
          if (this.undesirableEffect == null)
            this.undesirableEffect = new ArrayList<Reference>();
          this.undesirableEffect.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #undesirableEffect}, creating it if it does not already exist {3}
         */
        public Reference getUndesirableEffectFirstRep() { 
          if (getUndesirableEffect().isEmpty()) {
            addUndesirableEffect();
          }
          return getUndesirableEffect().get(0);
        }

        /**
         * @return {@link #otherTherapy} (Information about the use of the medicinal product in relation to other therapies described as part of the contraindication.)
         */
        public List<ClinicalUseIssueContraindicationOtherTherapyComponent> getOtherTherapy() { 
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseIssueContraindicationOtherTherapyComponent>();
          return this.otherTherapy;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseIssueIndicationComponent setOtherTherapy(List<ClinicalUseIssueContraindicationOtherTherapyComponent> theOtherTherapy) { 
          this.otherTherapy = theOtherTherapy;
          return this;
        }

        public boolean hasOtherTherapy() { 
          if (this.otherTherapy == null)
            return false;
          for (ClinicalUseIssueContraindicationOtherTherapyComponent item : this.otherTherapy)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ClinicalUseIssueContraindicationOtherTherapyComponent addOtherTherapy() { //3
          ClinicalUseIssueContraindicationOtherTherapyComponent t = new ClinicalUseIssueContraindicationOtherTherapyComponent();
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseIssueContraindicationOtherTherapyComponent>();
          this.otherTherapy.add(t);
          return t;
        }

        public ClinicalUseIssueIndicationComponent addOtherTherapy(ClinicalUseIssueContraindicationOtherTherapyComponent t) { //3
          if (t == null)
            return this;
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseIssueContraindicationOtherTherapyComponent>();
          this.otherTherapy.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #otherTherapy}, creating it if it does not already exist {3}
         */
        public ClinicalUseIssueContraindicationOtherTherapyComponent getOtherTherapyFirstRep() { 
          if (getOtherTherapy().isEmpty()) {
            addOtherTherapy();
          }
          return getOtherTherapy().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("diseaseSymptomProcedure", "CodeableConcept", "The situation that is being documented as an indicaton for this item.", 0, 1, diseaseSymptomProcedure));
          children.add(new Property("diseaseStatus", "CodeableConcept", "The status of the disease or symptom for the indication.", 0, 1, diseaseStatus));
          children.add(new Property("comorbidity", "CodeableConcept", "A comorbidity (concurrent condition) or coinfection as part of the indication.", 0, java.lang.Integer.MAX_VALUE, comorbidity));
          children.add(new Property("intendedEffect", "CodeableConcept", "For an indication - the intended effect, aim or strategy to be achieved.", 0, 1, intendedEffect));
          children.add(new Property("duration", "Quantity", "For an indication - timing or duration information.", 0, 1, duration));
          children.add(new Property("undesirableEffect", "Reference(ClinicalUseIssue)", "For an indicaton - the specific undesirable effects of the medicinal product.", 0, java.lang.Integer.MAX_VALUE, undesirableEffect));
          children.add(new Property("otherTherapy", "@ClinicalUseIssue.contraindication.otherTherapy", "Information about the use of the medicinal product in relation to other therapies described as part of the contraindication.", 0, java.lang.Integer.MAX_VALUE, otherTherapy));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1497395130: /*diseaseSymptomProcedure*/  return new Property("diseaseSymptomProcedure", "CodeableConcept", "The situation that is being documented as an indicaton for this item.", 0, 1, diseaseSymptomProcedure);
          case -505503602: /*diseaseStatus*/  return new Property("diseaseStatus", "CodeableConcept", "The status of the disease or symptom for the indication.", 0, 1, diseaseStatus);
          case -406395211: /*comorbidity*/  return new Property("comorbidity", "CodeableConcept", "A comorbidity (concurrent condition) or coinfection as part of the indication.", 0, java.lang.Integer.MAX_VALUE, comorbidity);
          case 1587112348: /*intendedEffect*/  return new Property("intendedEffect", "CodeableConcept", "For an indication - the intended effect, aim or strategy to be achieved.", 0, 1, intendedEffect);
          case -1992012396: /*duration*/  return new Property("duration", "Quantity", "For an indication - timing or duration information.", 0, 1, duration);
          case 444367565: /*undesirableEffect*/  return new Property("undesirableEffect", "Reference(ClinicalUseIssue)", "For an indicaton - the specific undesirable effects of the medicinal product.", 0, java.lang.Integer.MAX_VALUE, undesirableEffect);
          case -544509127: /*otherTherapy*/  return new Property("otherTherapy", "@ClinicalUseIssue.contraindication.otherTherapy", "Information about the use of the medicinal product in relation to other therapies described as part of the contraindication.", 0, java.lang.Integer.MAX_VALUE, otherTherapy);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1497395130: /*diseaseSymptomProcedure*/ return this.diseaseSymptomProcedure == null ? new Base[0] : new Base[] {this.diseaseSymptomProcedure}; // CodeableConcept
        case -505503602: /*diseaseStatus*/ return this.diseaseStatus == null ? new Base[0] : new Base[] {this.diseaseStatus}; // CodeableConcept
        case -406395211: /*comorbidity*/ return this.comorbidity == null ? new Base[0] : this.comorbidity.toArray(new Base[this.comorbidity.size()]); // CodeableConcept
        case 1587112348: /*intendedEffect*/ return this.intendedEffect == null ? new Base[0] : new Base[] {this.intendedEffect}; // CodeableConcept
        case -1992012396: /*duration*/ return this.duration == null ? new Base[0] : new Base[] {this.duration}; // Quantity
        case 444367565: /*undesirableEffect*/ return this.undesirableEffect == null ? new Base[0] : this.undesirableEffect.toArray(new Base[this.undesirableEffect.size()]); // Reference
        case -544509127: /*otherTherapy*/ return this.otherTherapy == null ? new Base[0] : this.otherTherapy.toArray(new Base[this.otherTherapy.size()]); // ClinicalUseIssueContraindicationOtherTherapyComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1497395130: // diseaseSymptomProcedure
          this.diseaseSymptomProcedure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -505503602: // diseaseStatus
          this.diseaseStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -406395211: // comorbidity
          this.getComorbidity().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1587112348: // intendedEffect
          this.intendedEffect = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1992012396: // duration
          this.duration = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 444367565: // undesirableEffect
          this.getUndesirableEffect().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -544509127: // otherTherapy
          this.getOtherTherapy().add((ClinicalUseIssueContraindicationOtherTherapyComponent) value); // ClinicalUseIssueContraindicationOtherTherapyComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("comorbidity")) {
          this.getComorbidity().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("intendedEffect")) {
          this.intendedEffect = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("duration")) {
          this.duration = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("undesirableEffect")) {
          this.getUndesirableEffect().add(TypeConvertor.castToReference(value));
        } else if (name.equals("otherTherapy")) {
          this.getOtherTherapy().add((ClinicalUseIssueContraindicationOtherTherapyComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1497395130:  return getDiseaseSymptomProcedure();
        case -505503602:  return getDiseaseStatus();
        case -406395211:  return addComorbidity(); 
        case 1587112348:  return getIntendedEffect();
        case -1992012396:  return getDuration();
        case 444367565:  return addUndesirableEffect(); 
        case -544509127:  return addOtherTherapy(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1497395130: /*diseaseSymptomProcedure*/ return new String[] {"CodeableConcept"};
        case -505503602: /*diseaseStatus*/ return new String[] {"CodeableConcept"};
        case -406395211: /*comorbidity*/ return new String[] {"CodeableConcept"};
        case 1587112348: /*intendedEffect*/ return new String[] {"CodeableConcept"};
        case -1992012396: /*duration*/ return new String[] {"Quantity"};
        case 444367565: /*undesirableEffect*/ return new String[] {"Reference"};
        case -544509127: /*otherTherapy*/ return new String[] {"@ClinicalUseIssue.contraindication.otherTherapy"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = new CodeableConcept();
          return this.diseaseSymptomProcedure;
        }
        else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = new CodeableConcept();
          return this.diseaseStatus;
        }
        else if (name.equals("comorbidity")) {
          return addComorbidity();
        }
        else if (name.equals("intendedEffect")) {
          this.intendedEffect = new CodeableConcept();
          return this.intendedEffect;
        }
        else if (name.equals("duration")) {
          this.duration = new Quantity();
          return this.duration;
        }
        else if (name.equals("undesirableEffect")) {
          return addUndesirableEffect();
        }
        else if (name.equals("otherTherapy")) {
          return addOtherTherapy();
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseIssueIndicationComponent copy() {
        ClinicalUseIssueIndicationComponent dst = new ClinicalUseIssueIndicationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseIssueIndicationComponent dst) {
        super.copyValues(dst);
        dst.diseaseSymptomProcedure = diseaseSymptomProcedure == null ? null : diseaseSymptomProcedure.copy();
        dst.diseaseStatus = diseaseStatus == null ? null : diseaseStatus.copy();
        if (comorbidity != null) {
          dst.comorbidity = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : comorbidity)
            dst.comorbidity.add(i.copy());
        };
        dst.intendedEffect = intendedEffect == null ? null : intendedEffect.copy();
        dst.duration = duration == null ? null : duration.copy();
        if (undesirableEffect != null) {
          dst.undesirableEffect = new ArrayList<Reference>();
          for (Reference i : undesirableEffect)
            dst.undesirableEffect.add(i.copy());
        };
        if (otherTherapy != null) {
          dst.otherTherapy = new ArrayList<ClinicalUseIssueContraindicationOtherTherapyComponent>();
          for (ClinicalUseIssueContraindicationOtherTherapyComponent i : otherTherapy)
            dst.otherTherapy.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueIndicationComponent))
          return false;
        ClinicalUseIssueIndicationComponent o = (ClinicalUseIssueIndicationComponent) other_;
        return compareDeep(diseaseSymptomProcedure, o.diseaseSymptomProcedure, true) && compareDeep(diseaseStatus, o.diseaseStatus, true)
           && compareDeep(comorbidity, o.comorbidity, true) && compareDeep(intendedEffect, o.intendedEffect, true)
           && compareDeep(duration, o.duration, true) && compareDeep(undesirableEffect, o.undesirableEffect, true)
           && compareDeep(otherTherapy, o.otherTherapy, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueIndicationComponent))
          return false;
        ClinicalUseIssueIndicationComponent o = (ClinicalUseIssueIndicationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(diseaseSymptomProcedure, diseaseStatus
          , comorbidity, intendedEffect, duration, undesirableEffect, otherTherapy);
      }

  public String fhirType() {
    return "ClinicalUseIssue.indication";

  }

  }

    @Block()
    public static class ClinicalUseIssueInteractionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The specific medication, food or laboratory test that interacts.
         */
        @Child(name = "interactant", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The specific medication, food or laboratory test that interacts", formalDefinition="The specific medication, food or laboratory test that interacts." )
        protected List<ClinicalUseIssueInteractionInteractantComponent> interactant;

        /**
         * The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction", formalDefinition="The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction." )
        protected CodeableConcept type;

        /**
         * The effect of the interaction, for example "reduced gastric absorption of primary medication".
         */
        @Child(name = "effect", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The effect of the interaction, for example \"reduced gastric absorption of primary medication\"", formalDefinition="The effect of the interaction, for example \"reduced gastric absorption of primary medication\"." )
        protected CodeableConcept effect;

        /**
         * The incidence of the interaction, e.g. theoretical, observed.
         */
        @Child(name = "incidence", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The incidence of the interaction, e.g. theoretical, observed", formalDefinition="The incidence of the interaction, e.g. theoretical, observed." )
        protected CodeableConcept incidence;

        /**
         * Actions for managing the interaction.
         */
        @Child(name = "management", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Actions for managing the interaction", formalDefinition="Actions for managing the interaction." )
        protected CodeableConcept management;

        private static final long serialVersionUID = -910262208L;

    /**
     * Constructor
     */
      public ClinicalUseIssueInteractionComponent() {
        super();
      }

        /**
         * @return {@link #interactant} (The specific medication, food or laboratory test that interacts.)
         */
        public List<ClinicalUseIssueInteractionInteractantComponent> getInteractant() { 
          if (this.interactant == null)
            this.interactant = new ArrayList<ClinicalUseIssueInteractionInteractantComponent>();
          return this.interactant;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseIssueInteractionComponent setInteractant(List<ClinicalUseIssueInteractionInteractantComponent> theInteractant) { 
          this.interactant = theInteractant;
          return this;
        }

        public boolean hasInteractant() { 
          if (this.interactant == null)
            return false;
          for (ClinicalUseIssueInteractionInteractantComponent item : this.interactant)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ClinicalUseIssueInteractionInteractantComponent addInteractant() { //3
          ClinicalUseIssueInteractionInteractantComponent t = new ClinicalUseIssueInteractionInteractantComponent();
          if (this.interactant == null)
            this.interactant = new ArrayList<ClinicalUseIssueInteractionInteractantComponent>();
          this.interactant.add(t);
          return t;
        }

        public ClinicalUseIssueInteractionComponent addInteractant(ClinicalUseIssueInteractionInteractantComponent t) { //3
          if (t == null)
            return this;
          if (this.interactant == null)
            this.interactant = new ArrayList<ClinicalUseIssueInteractionInteractantComponent>();
          this.interactant.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #interactant}, creating it if it does not already exist {3}
         */
        public ClinicalUseIssueInteractionInteractantComponent getInteractantFirstRep() { 
          if (getInteractant().isEmpty()) {
            addInteractant();
          }
          return getInteractant().get(0);
        }

        /**
         * @return {@link #type} (The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueInteractionComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction.)
         */
        public ClinicalUseIssueInteractionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #effect} (The effect of the interaction, for example "reduced gastric absorption of primary medication".)
         */
        public CodeableConcept getEffect() { 
          if (this.effect == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueInteractionComponent.effect");
            else if (Configuration.doAutoCreate())
              this.effect = new CodeableConcept(); // cc
          return this.effect;
        }

        public boolean hasEffect() { 
          return this.effect != null && !this.effect.isEmpty();
        }

        /**
         * @param value {@link #effect} (The effect of the interaction, for example "reduced gastric absorption of primary medication".)
         */
        public ClinicalUseIssueInteractionComponent setEffect(CodeableConcept value) { 
          this.effect = value;
          return this;
        }

        /**
         * @return {@link #incidence} (The incidence of the interaction, e.g. theoretical, observed.)
         */
        public CodeableConcept getIncidence() { 
          if (this.incidence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueInteractionComponent.incidence");
            else if (Configuration.doAutoCreate())
              this.incidence = new CodeableConcept(); // cc
          return this.incidence;
        }

        public boolean hasIncidence() { 
          return this.incidence != null && !this.incidence.isEmpty();
        }

        /**
         * @param value {@link #incidence} (The incidence of the interaction, e.g. theoretical, observed.)
         */
        public ClinicalUseIssueInteractionComponent setIncidence(CodeableConcept value) { 
          this.incidence = value;
          return this;
        }

        /**
         * @return {@link #management} (Actions for managing the interaction.)
         */
        public CodeableConcept getManagement() { 
          if (this.management == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueInteractionComponent.management");
            else if (Configuration.doAutoCreate())
              this.management = new CodeableConcept(); // cc
          return this.management;
        }

        public boolean hasManagement() { 
          return this.management != null && !this.management.isEmpty();
        }

        /**
         * @param value {@link #management} (Actions for managing the interaction.)
         */
        public ClinicalUseIssueInteractionComponent setManagement(CodeableConcept value) { 
          this.management = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("interactant", "", "The specific medication, food or laboratory test that interacts.", 0, java.lang.Integer.MAX_VALUE, interactant));
          children.add(new Property("type", "CodeableConcept", "The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction.", 0, 1, type));
          children.add(new Property("effect", "CodeableConcept", "The effect of the interaction, for example \"reduced gastric absorption of primary medication\".", 0, 1, effect));
          children.add(new Property("incidence", "CodeableConcept", "The incidence of the interaction, e.g. theoretical, observed.", 0, 1, incidence));
          children.add(new Property("management", "CodeableConcept", "Actions for managing the interaction.", 0, 1, management));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1844097009: /*interactant*/  return new Property("interactant", "", "The specific medication, food or laboratory test that interacts.", 0, java.lang.Integer.MAX_VALUE, interactant);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction.", 0, 1, type);
          case -1306084975: /*effect*/  return new Property("effect", "CodeableConcept", "The effect of the interaction, for example \"reduced gastric absorption of primary medication\".", 0, 1, effect);
          case -1598467132: /*incidence*/  return new Property("incidence", "CodeableConcept", "The incidence of the interaction, e.g. theoretical, observed.", 0, 1, incidence);
          case -1799980989: /*management*/  return new Property("management", "CodeableConcept", "Actions for managing the interaction.", 0, 1, management);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1844097009: /*interactant*/ return this.interactant == null ? new Base[0] : this.interactant.toArray(new Base[this.interactant.size()]); // ClinicalUseIssueInteractionInteractantComponent
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1306084975: /*effect*/ return this.effect == null ? new Base[0] : new Base[] {this.effect}; // CodeableConcept
        case -1598467132: /*incidence*/ return this.incidence == null ? new Base[0] : new Base[] {this.incidence}; // CodeableConcept
        case -1799980989: /*management*/ return this.management == null ? new Base[0] : new Base[] {this.management}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1844097009: // interactant
          this.getInteractant().add((ClinicalUseIssueInteractionInteractantComponent) value); // ClinicalUseIssueInteractionInteractantComponent
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1306084975: // effect
          this.effect = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1598467132: // incidence
          this.incidence = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1799980989: // management
          this.management = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("interactant")) {
          this.getInteractant().add((ClinicalUseIssueInteractionInteractantComponent) value);
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("effect")) {
          this.effect = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("incidence")) {
          this.incidence = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("management")) {
          this.management = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1844097009:  return addInteractant(); 
        case 3575610:  return getType();
        case -1306084975:  return getEffect();
        case -1598467132:  return getIncidence();
        case -1799980989:  return getManagement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1844097009: /*interactant*/ return new String[] {};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1306084975: /*effect*/ return new String[] {"CodeableConcept"};
        case -1598467132: /*incidence*/ return new String[] {"CodeableConcept"};
        case -1799980989: /*management*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("interactant")) {
          return addInteractant();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("effect")) {
          this.effect = new CodeableConcept();
          return this.effect;
        }
        else if (name.equals("incidence")) {
          this.incidence = new CodeableConcept();
          return this.incidence;
        }
        else if (name.equals("management")) {
          this.management = new CodeableConcept();
          return this.management;
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseIssueInteractionComponent copy() {
        ClinicalUseIssueInteractionComponent dst = new ClinicalUseIssueInteractionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseIssueInteractionComponent dst) {
        super.copyValues(dst);
        if (interactant != null) {
          dst.interactant = new ArrayList<ClinicalUseIssueInteractionInteractantComponent>();
          for (ClinicalUseIssueInteractionInteractantComponent i : interactant)
            dst.interactant.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.effect = effect == null ? null : effect.copy();
        dst.incidence = incidence == null ? null : incidence.copy();
        dst.management = management == null ? null : management.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueInteractionComponent))
          return false;
        ClinicalUseIssueInteractionComponent o = (ClinicalUseIssueInteractionComponent) other_;
        return compareDeep(interactant, o.interactant, true) && compareDeep(type, o.type, true) && compareDeep(effect, o.effect, true)
           && compareDeep(incidence, o.incidence, true) && compareDeep(management, o.management, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueInteractionComponent))
          return false;
        ClinicalUseIssueInteractionComponent o = (ClinicalUseIssueInteractionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(interactant, type, effect
          , incidence, management);
      }

  public String fhirType() {
    return "ClinicalUseIssue.interaction";

  }

  }

    @Block()
    public static class ClinicalUseIssueInteractionInteractantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The specific medication, food or laboratory test that interacts.
         */
        @Child(name = "item", type = {MedicinalProductDefinition.class, Medication.class, Substance.class, ObservationDefinition.class, CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The specific medication, food or laboratory test that interacts", formalDefinition="The specific medication, food or laboratory test that interacts." )
        protected DataType item;

        private static final long serialVersionUID = 1847936859L;

    /**
     * Constructor
     */
      public ClinicalUseIssueInteractionInteractantComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ClinicalUseIssueInteractionInteractantComponent(DataType item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (The specific medication, food or laboratory test that interacts.)
         */
        public DataType getItem() { 
          return this.item;
        }

        /**
         * @return {@link #item} (The specific medication, food or laboratory test that interacts.)
         */
        public Reference getItemReference() throws FHIRException { 
          if (this.item == null)
            this.item = new Reference();
          if (!(this.item instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.item.getClass().getName()+" was encountered");
          return (Reference) this.item;
        }

        public boolean hasItemReference() { 
          return this != null && this.item instanceof Reference;
        }

        /**
         * @return {@link #item} (The specific medication, food or laboratory test that interacts.)
         */
        public CodeableConcept getItemCodeableConcept() throws FHIRException { 
          if (this.item == null)
            this.item = new CodeableConcept();
          if (!(this.item instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.item.getClass().getName()+" was encountered");
          return (CodeableConcept) this.item;
        }

        public boolean hasItemCodeableConcept() { 
          return this != null && this.item instanceof CodeableConcept;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (The specific medication, food or laboratory test that interacts.)
         */
        public ClinicalUseIssueInteractionInteractantComponent setItem(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new Error("Not the right type for ClinicalUseIssue.interaction.interactant.item[x]: "+value.fhirType());
          this.item = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item[x]", "Reference(MedicinalProductDefinition|Medication|Substance|ObservationDefinition)|CodeableConcept", "The specific medication, food or laboratory test that interacts.", 0, 1, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2116201613: /*item[x]*/  return new Property("item[x]", "Reference(MedicinalProductDefinition|Medication|Substance|ObservationDefinition)|CodeableConcept", "The specific medication, food or laboratory test that interacts.", 0, 1, item);
          case 3242771: /*item*/  return new Property("item[x]", "Reference(MedicinalProductDefinition|Medication|Substance|ObservationDefinition)|CodeableConcept", "The specific medication, food or laboratory test that interacts.", 0, 1, item);
          case 1376364920: /*itemReference*/  return new Property("item[x]", "Reference(MedicinalProductDefinition|Medication|Substance|ObservationDefinition)", "The specific medication, food or laboratory test that interacts.", 0, 1, item);
          case 106644494: /*itemCodeableConcept*/  return new Property("item[x]", "CodeableConcept", "The specific medication, food or laboratory test that interacts.", 0, 1, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item[x]")) {
          this.item = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2116201613:  return getItem();
        case 3242771:  return getItem();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"Reference", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("itemReference")) {
          this.item = new Reference();
          return this.item;
        }
        else if (name.equals("itemCodeableConcept")) {
          this.item = new CodeableConcept();
          return this.item;
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseIssueInteractionInteractantComponent copy() {
        ClinicalUseIssueInteractionInteractantComponent dst = new ClinicalUseIssueInteractionInteractantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseIssueInteractionInteractantComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueInteractionInteractantComponent))
          return false;
        ClinicalUseIssueInteractionInteractantComponent o = (ClinicalUseIssueInteractionInteractantComponent) other_;
        return compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueInteractionInteractantComponent))
          return false;
        ClinicalUseIssueInteractionInteractantComponent o = (ClinicalUseIssueInteractionInteractantComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item);
      }

  public String fhirType() {
    return "ClinicalUseIssue.interaction.interactant";

  }

  }

    @Block()
    public static class ClinicalUseIssueUndesirableEffectComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The situation in which the undesirable effect may manifest.
         */
        @Child(name = "symptomConditionEffect", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The situation in which the undesirable effect may manifest", formalDefinition="The situation in which the undesirable effect may manifest." )
        protected CodeableConcept symptomConditionEffect;

        /**
         * High level classification of the effect.
         */
        @Child(name = "classification", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="High level classification of the effect", formalDefinition="High level classification of the effect." )
        protected CodeableConcept classification;

        /**
         * How often the effect is seen.
         */
        @Child(name = "frequencyOfOccurrence", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="How often the effect is seen", formalDefinition="How often the effect is seen." )
        protected CodeableConcept frequencyOfOccurrence;

        private static final long serialVersionUID = 503141026L;

    /**
     * Constructor
     */
      public ClinicalUseIssueUndesirableEffectComponent() {
        super();
      }

        /**
         * @return {@link #symptomConditionEffect} (The situation in which the undesirable effect may manifest.)
         */
        public CodeableConcept getSymptomConditionEffect() { 
          if (this.symptomConditionEffect == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueUndesirableEffectComponent.symptomConditionEffect");
            else if (Configuration.doAutoCreate())
              this.symptomConditionEffect = new CodeableConcept(); // cc
          return this.symptomConditionEffect;
        }

        public boolean hasSymptomConditionEffect() { 
          return this.symptomConditionEffect != null && !this.symptomConditionEffect.isEmpty();
        }

        /**
         * @param value {@link #symptomConditionEffect} (The situation in which the undesirable effect may manifest.)
         */
        public ClinicalUseIssueUndesirableEffectComponent setSymptomConditionEffect(CodeableConcept value) { 
          this.symptomConditionEffect = value;
          return this;
        }

        /**
         * @return {@link #classification} (High level classification of the effect.)
         */
        public CodeableConcept getClassification() { 
          if (this.classification == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueUndesirableEffectComponent.classification");
            else if (Configuration.doAutoCreate())
              this.classification = new CodeableConcept(); // cc
          return this.classification;
        }

        public boolean hasClassification() { 
          return this.classification != null && !this.classification.isEmpty();
        }

        /**
         * @param value {@link #classification} (High level classification of the effect.)
         */
        public ClinicalUseIssueUndesirableEffectComponent setClassification(CodeableConcept value) { 
          this.classification = value;
          return this;
        }

        /**
         * @return {@link #frequencyOfOccurrence} (How often the effect is seen.)
         */
        public CodeableConcept getFrequencyOfOccurrence() { 
          if (this.frequencyOfOccurrence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseIssueUndesirableEffectComponent.frequencyOfOccurrence");
            else if (Configuration.doAutoCreate())
              this.frequencyOfOccurrence = new CodeableConcept(); // cc
          return this.frequencyOfOccurrence;
        }

        public boolean hasFrequencyOfOccurrence() { 
          return this.frequencyOfOccurrence != null && !this.frequencyOfOccurrence.isEmpty();
        }

        /**
         * @param value {@link #frequencyOfOccurrence} (How often the effect is seen.)
         */
        public ClinicalUseIssueUndesirableEffectComponent setFrequencyOfOccurrence(CodeableConcept value) { 
          this.frequencyOfOccurrence = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("symptomConditionEffect", "CodeableConcept", "The situation in which the undesirable effect may manifest.", 0, 1, symptomConditionEffect));
          children.add(new Property("classification", "CodeableConcept", "High level classification of the effect.", 0, 1, classification));
          children.add(new Property("frequencyOfOccurrence", "CodeableConcept", "How often the effect is seen.", 0, 1, frequencyOfOccurrence));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -650549981: /*symptomConditionEffect*/  return new Property("symptomConditionEffect", "CodeableConcept", "The situation in which the undesirable effect may manifest.", 0, 1, symptomConditionEffect);
          case 382350310: /*classification*/  return new Property("classification", "CodeableConcept", "High level classification of the effect.", 0, 1, classification);
          case 791175812: /*frequencyOfOccurrence*/  return new Property("frequencyOfOccurrence", "CodeableConcept", "How often the effect is seen.", 0, 1, frequencyOfOccurrence);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -650549981: /*symptomConditionEffect*/ return this.symptomConditionEffect == null ? new Base[0] : new Base[] {this.symptomConditionEffect}; // CodeableConcept
        case 382350310: /*classification*/ return this.classification == null ? new Base[0] : new Base[] {this.classification}; // CodeableConcept
        case 791175812: /*frequencyOfOccurrence*/ return this.frequencyOfOccurrence == null ? new Base[0] : new Base[] {this.frequencyOfOccurrence}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -650549981: // symptomConditionEffect
          this.symptomConditionEffect = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 382350310: // classification
          this.classification = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 791175812: // frequencyOfOccurrence
          this.frequencyOfOccurrence = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("symptomConditionEffect")) {
          this.symptomConditionEffect = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("classification")) {
          this.classification = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("frequencyOfOccurrence")) {
          this.frequencyOfOccurrence = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -650549981:  return getSymptomConditionEffect();
        case 382350310:  return getClassification();
        case 791175812:  return getFrequencyOfOccurrence();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -650549981: /*symptomConditionEffect*/ return new String[] {"CodeableConcept"};
        case 382350310: /*classification*/ return new String[] {"CodeableConcept"};
        case 791175812: /*frequencyOfOccurrence*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("symptomConditionEffect")) {
          this.symptomConditionEffect = new CodeableConcept();
          return this.symptomConditionEffect;
        }
        else if (name.equals("classification")) {
          this.classification = new CodeableConcept();
          return this.classification;
        }
        else if (name.equals("frequencyOfOccurrence")) {
          this.frequencyOfOccurrence = new CodeableConcept();
          return this.frequencyOfOccurrence;
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseIssueUndesirableEffectComponent copy() {
        ClinicalUseIssueUndesirableEffectComponent dst = new ClinicalUseIssueUndesirableEffectComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseIssueUndesirableEffectComponent dst) {
        super.copyValues(dst);
        dst.symptomConditionEffect = symptomConditionEffect == null ? null : symptomConditionEffect.copy();
        dst.classification = classification == null ? null : classification.copy();
        dst.frequencyOfOccurrence = frequencyOfOccurrence == null ? null : frequencyOfOccurrence.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueUndesirableEffectComponent))
          return false;
        ClinicalUseIssueUndesirableEffectComponent o = (ClinicalUseIssueUndesirableEffectComponent) other_;
        return compareDeep(symptomConditionEffect, o.symptomConditionEffect, true) && compareDeep(classification, o.classification, true)
           && compareDeep(frequencyOfOccurrence, o.frequencyOfOccurrence, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssueUndesirableEffectComponent))
          return false;
        ClinicalUseIssueUndesirableEffectComponent o = (ClinicalUseIssueUndesirableEffectComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(symptomConditionEffect, classification
          , frequencyOfOccurrence);
      }

  public String fhirType() {
    return "ClinicalUseIssue.undesirableEffect";

  }

  }

    /**
     * Business identifier for this issue.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this issue", formalDefinition="Business identifier for this issue." )
    protected List<Identifier> identifier;

    /**
     * indication | contraindication | interaction | undesirable-effect | warning.
     */
    @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="indication | contraindication | interaction | undesirable-effect | warning", formalDefinition="indication | contraindication | interaction | undesirable-effect | warning." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-use-issue-type")
    protected Enumeration<ClinicalUseIssueType> type;

    /**
     * A categorisation of the issue, primarily for dividing warnings into subject heading areas such as "Pregnancy and Lactation", "Overdose", "Effects Ability to Drive and Use Machines".
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A categorisation of the issue, primarily for dividing warnings into subject heading areas such as \"Pregnancy and Lactation\", \"Overdose\", \"Effects Ability to Drive and Use Machines\"", formalDefinition="A categorisation of the issue, primarily for dividing warnings into subject heading areas such as \"Pregnancy and Lactation\", \"Overdose\", \"Effects Ability to Drive and Use Machines\"." )
    protected CodeableConcept category;

    /**
     * The medication or procedure for which this is an indication.
     */
    @Child(name = "subject", type = {MedicinalProductDefinition.class, Medication.class, ActivityDefinition.class, PlanDefinition.class, Device.class, DeviceDefinition.class, Substance.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The medication or procedure for which this is an indication", formalDefinition="The medication or procedure for which this is an indication." )
    protected List<Reference> subject;

    /**
     * General description.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="General description", formalDefinition="General description." )
    protected CodeableConcept status;

    /**
     * General description.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="General description", formalDefinition="General description." )
    protected MarkdownType description;

    /**
     * Specifics for when this is a contraindication.
     */
    @Child(name = "contraindication", type = {}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specifics for when this is a contraindication", formalDefinition="Specifics for when this is a contraindication." )
    protected ClinicalUseIssueContraindicationComponent contraindication;

    /**
     * Specifics for when this is an indication.
     */
    @Child(name = "indication", type = {}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specifics for when this is an indication", formalDefinition="Specifics for when this is an indication." )
    protected ClinicalUseIssueIndicationComponent indication;

    /**
     * Specifics for when this is an interaction.
     */
    @Child(name = "interaction", type = {}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specifics for when this is an interaction", formalDefinition="Specifics for when this is an interaction." )
    protected ClinicalUseIssueInteractionComponent interaction;

    /**
     * The population group to which this applies.
     */
    @Child(name = "population", type = {Population.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The population group to which this applies", formalDefinition="The population group to which this applies." )
    protected List<Population> population;

    /**
     * Describe the undesirable effects of the medicinal product.
     */
    @Child(name = "undesirableEffect", type = {}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A possible negative outcome from the use of this treatment", formalDefinition="Describe the undesirable effects of the medicinal product." )
    protected ClinicalUseIssueUndesirableEffectComponent undesirableEffect;

    private static final long serialVersionUID = 681484438L;

  /**
   * Constructor
   */
    public ClinicalUseIssue() {
      super();
    }

  /**
   * Constructor
   */
    public ClinicalUseIssue(ClinicalUseIssueType type) {
      super();
      this.setType(type);
    }

    /**
     * @return {@link #identifier} (Business identifier for this issue.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalUseIssue setIdentifier(List<Identifier> theIdentifier) { 
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

    public ClinicalUseIssue addIdentifier(Identifier t) { //3
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
     * @return {@link #type} (indication | contraindication | interaction | undesirable-effect | warning.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<ClinicalUseIssueType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseIssue.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<ClinicalUseIssueType>(new ClinicalUseIssueTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (indication | contraindication | interaction | undesirable-effect | warning.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public ClinicalUseIssue setTypeElement(Enumeration<ClinicalUseIssueType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return indication | contraindication | interaction | undesirable-effect | warning.
     */
    public ClinicalUseIssueType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value indication | contraindication | interaction | undesirable-effect | warning.
     */
    public ClinicalUseIssue setType(ClinicalUseIssueType value) { 
        if (this.type == null)
          this.type = new Enumeration<ClinicalUseIssueType>(new ClinicalUseIssueTypeEnumFactory());
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (A categorisation of the issue, primarily for dividing warnings into subject heading areas such as "Pregnancy and Lactation", "Overdose", "Effects Ability to Drive and Use Machines".)
     */
    public CodeableConcept getCategory() { 
      if (this.category == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseIssue.category");
        else if (Configuration.doAutoCreate())
          this.category = new CodeableConcept(); // cc
      return this.category;
    }

    public boolean hasCategory() { 
      return this.category != null && !this.category.isEmpty();
    }

    /**
     * @param value {@link #category} (A categorisation of the issue, primarily for dividing warnings into subject heading areas such as "Pregnancy and Lactation", "Overdose", "Effects Ability to Drive and Use Machines".)
     */
    public ClinicalUseIssue setCategory(CodeableConcept value) { 
      this.category = value;
      return this;
    }

    /**
     * @return {@link #subject} (The medication or procedure for which this is an indication.)
     */
    public List<Reference> getSubject() { 
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      return this.subject;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalUseIssue setSubject(List<Reference> theSubject) { 
      this.subject = theSubject;
      return this;
    }

    public boolean hasSubject() { 
      if (this.subject == null)
        return false;
      for (Reference item : this.subject)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSubject() { //3
      Reference t = new Reference();
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      this.subject.add(t);
      return t;
    }

    public ClinicalUseIssue addSubject(Reference t) { //3
      if (t == null)
        return this;
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      this.subject.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #subject}, creating it if it does not already exist {3}
     */
    public Reference getSubjectFirstRep() { 
      if (getSubject().isEmpty()) {
        addSubject();
      }
      return getSubject().get(0);
    }

    /**
     * @return {@link #status} (General description.)
     */
    public CodeableConcept getStatus() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseIssue.status");
        else if (Configuration.doAutoCreate())
          this.status = new CodeableConcept(); // cc
      return this.status;
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (General description.)
     */
    public ClinicalUseIssue setStatus(CodeableConcept value) { 
      this.status = value;
      return this;
    }

    /**
     * @return {@link #description} (General description.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseIssue.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (General description.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ClinicalUseIssue setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return General description.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value General description.
     */
    public ClinicalUseIssue setDescription(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #contraindication} (Specifics for when this is a contraindication.)
     */
    public ClinicalUseIssueContraindicationComponent getContraindication() { 
      if (this.contraindication == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseIssue.contraindication");
        else if (Configuration.doAutoCreate())
          this.contraindication = new ClinicalUseIssueContraindicationComponent(); // cc
      return this.contraindication;
    }

    public boolean hasContraindication() { 
      return this.contraindication != null && !this.contraindication.isEmpty();
    }

    /**
     * @param value {@link #contraindication} (Specifics for when this is a contraindication.)
     */
    public ClinicalUseIssue setContraindication(ClinicalUseIssueContraindicationComponent value) { 
      this.contraindication = value;
      return this;
    }

    /**
     * @return {@link #indication} (Specifics for when this is an indication.)
     */
    public ClinicalUseIssueIndicationComponent getIndication() { 
      if (this.indication == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseIssue.indication");
        else if (Configuration.doAutoCreate())
          this.indication = new ClinicalUseIssueIndicationComponent(); // cc
      return this.indication;
    }

    public boolean hasIndication() { 
      return this.indication != null && !this.indication.isEmpty();
    }

    /**
     * @param value {@link #indication} (Specifics for when this is an indication.)
     */
    public ClinicalUseIssue setIndication(ClinicalUseIssueIndicationComponent value) { 
      this.indication = value;
      return this;
    }

    /**
     * @return {@link #interaction} (Specifics for when this is an interaction.)
     */
    public ClinicalUseIssueInteractionComponent getInteraction() { 
      if (this.interaction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseIssue.interaction");
        else if (Configuration.doAutoCreate())
          this.interaction = new ClinicalUseIssueInteractionComponent(); // cc
      return this.interaction;
    }

    public boolean hasInteraction() { 
      return this.interaction != null && !this.interaction.isEmpty();
    }

    /**
     * @param value {@link #interaction} (Specifics for when this is an interaction.)
     */
    public ClinicalUseIssue setInteraction(ClinicalUseIssueInteractionComponent value) { 
      this.interaction = value;
      return this;
    }

    /**
     * @return {@link #population} (The population group to which this applies.)
     */
    public List<Population> getPopulation() { 
      if (this.population == null)
        this.population = new ArrayList<Population>();
      return this.population;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalUseIssue setPopulation(List<Population> thePopulation) { 
      this.population = thePopulation;
      return this;
    }

    public boolean hasPopulation() { 
      if (this.population == null)
        return false;
      for (Population item : this.population)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Population addPopulation() { //3
      Population t = new Population();
      if (this.population == null)
        this.population = new ArrayList<Population>();
      this.population.add(t);
      return t;
    }

    public ClinicalUseIssue addPopulation(Population t) { //3
      if (t == null)
        return this;
      if (this.population == null)
        this.population = new ArrayList<Population>();
      this.population.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #population}, creating it if it does not already exist {3}
     */
    public Population getPopulationFirstRep() { 
      if (getPopulation().isEmpty()) {
        addPopulation();
      }
      return getPopulation().get(0);
    }

    /**
     * @return {@link #undesirableEffect} (Describe the undesirable effects of the medicinal product.)
     */
    public ClinicalUseIssueUndesirableEffectComponent getUndesirableEffect() { 
      if (this.undesirableEffect == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseIssue.undesirableEffect");
        else if (Configuration.doAutoCreate())
          this.undesirableEffect = new ClinicalUseIssueUndesirableEffectComponent(); // cc
      return this.undesirableEffect;
    }

    public boolean hasUndesirableEffect() { 
      return this.undesirableEffect != null && !this.undesirableEffect.isEmpty();
    }

    /**
     * @param value {@link #undesirableEffect} (Describe the undesirable effects of the medicinal product.)
     */
    public ClinicalUseIssue setUndesirableEffect(ClinicalUseIssueUndesirableEffectComponent value) { 
      this.undesirableEffect = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this issue.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("type", "code", "indication | contraindication | interaction | undesirable-effect | warning.", 0, 1, type));
        children.add(new Property("category", "CodeableConcept", "A categorisation of the issue, primarily for dividing warnings into subject heading areas such as \"Pregnancy and Lactation\", \"Overdose\", \"Effects Ability to Drive and Use Machines\".", 0, 1, category));
        children.add(new Property("subject", "Reference(MedicinalProductDefinition|Medication|ActivityDefinition|PlanDefinition|Device|DeviceDefinition|Substance)", "The medication or procedure for which this is an indication.", 0, java.lang.Integer.MAX_VALUE, subject));
        children.add(new Property("status", "CodeableConcept", "General description.", 0, 1, status));
        children.add(new Property("description", "markdown", "General description.", 0, 1, description));
        children.add(new Property("contraindication", "", "Specifics for when this is a contraindication.", 0, 1, contraindication));
        children.add(new Property("indication", "", "Specifics for when this is an indication.", 0, 1, indication));
        children.add(new Property("interaction", "", "Specifics for when this is an interaction.", 0, 1, interaction));
        children.add(new Property("population", "Population", "The population group to which this applies.", 0, java.lang.Integer.MAX_VALUE, population));
        children.add(new Property("undesirableEffect", "", "Describe the undesirable effects of the medicinal product.", 0, 1, undesirableEffect));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this issue.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3575610: /*type*/  return new Property("type", "code", "indication | contraindication | interaction | undesirable-effect | warning.", 0, 1, type);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A categorisation of the issue, primarily for dividing warnings into subject heading areas such as \"Pregnancy and Lactation\", \"Overdose\", \"Effects Ability to Drive and Use Machines\".", 0, 1, category);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(MedicinalProductDefinition|Medication|ActivityDefinition|PlanDefinition|Device|DeviceDefinition|Substance)", "The medication or procedure for which this is an indication.", 0, java.lang.Integer.MAX_VALUE, subject);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "General description.", 0, 1, status);
        case -1724546052: /*description*/  return new Property("description", "markdown", "General description.", 0, 1, description);
        case 107135229: /*contraindication*/  return new Property("contraindication", "", "Specifics for when this is a contraindication.", 0, 1, contraindication);
        case -597168804: /*indication*/  return new Property("indication", "", "Specifics for when this is an indication.", 0, 1, indication);
        case 1844104722: /*interaction*/  return new Property("interaction", "", "Specifics for when this is an interaction.", 0, 1, interaction);
        case -2023558323: /*population*/  return new Property("population", "Population", "The population group to which this applies.", 0, java.lang.Integer.MAX_VALUE, population);
        case 444367565: /*undesirableEffect*/  return new Property("undesirableEffect", "", "Describe the undesirable effects of the medicinal product.", 0, 1, undesirableEffect);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ClinicalUseIssueType>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : this.subject.toArray(new Base[this.subject.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 107135229: /*contraindication*/ return this.contraindication == null ? new Base[0] : new Base[] {this.contraindication}; // ClinicalUseIssueContraindicationComponent
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : new Base[] {this.indication}; // ClinicalUseIssueIndicationComponent
        case 1844104722: /*interaction*/ return this.interaction == null ? new Base[0] : new Base[] {this.interaction}; // ClinicalUseIssueInteractionComponent
        case -2023558323: /*population*/ return this.population == null ? new Base[0] : this.population.toArray(new Base[this.population.size()]); // Population
        case 444367565: /*undesirableEffect*/ return this.undesirableEffect == null ? new Base[0] : new Base[] {this.undesirableEffect}; // ClinicalUseIssueUndesirableEffectComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3575610: // type
          value = new ClinicalUseIssueTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ClinicalUseIssueType>
          return value;
        case 50511102: // category
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.getSubject().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 107135229: // contraindication
          this.contraindication = (ClinicalUseIssueContraindicationComponent) value; // ClinicalUseIssueContraindicationComponent
          return value;
        case -597168804: // indication
          this.indication = (ClinicalUseIssueIndicationComponent) value; // ClinicalUseIssueIndicationComponent
          return value;
        case 1844104722: // interaction
          this.interaction = (ClinicalUseIssueInteractionComponent) value; // ClinicalUseIssueInteractionComponent
          return value;
        case -2023558323: // population
          this.getPopulation().add(TypeConvertor.castToPopulation(value)); // Population
          return value;
        case 444367565: // undesirableEffect
          this.undesirableEffect = (ClinicalUseIssueUndesirableEffectComponent) value; // ClinicalUseIssueUndesirableEffectComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("type")) {
          value = new ClinicalUseIssueTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ClinicalUseIssueType>
        } else if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.getSubject().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("contraindication")) {
          this.contraindication = (ClinicalUseIssueContraindicationComponent) value; // ClinicalUseIssueContraindicationComponent
        } else if (name.equals("indication")) {
          this.indication = (ClinicalUseIssueIndicationComponent) value; // ClinicalUseIssueIndicationComponent
        } else if (name.equals("interaction")) {
          this.interaction = (ClinicalUseIssueInteractionComponent) value; // ClinicalUseIssueInteractionComponent
        } else if (name.equals("population")) {
          this.getPopulation().add(TypeConvertor.castToPopulation(value));
        } else if (name.equals("undesirableEffect")) {
          this.undesirableEffect = (ClinicalUseIssueUndesirableEffectComponent) value; // ClinicalUseIssueUndesirableEffectComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3575610:  return getTypeElement();
        case 50511102:  return getCategory();
        case -1867885268:  return addSubject(); 
        case -892481550:  return getStatus();
        case -1724546052:  return getDescriptionElement();
        case 107135229:  return getContraindication();
        case -597168804:  return getIndication();
        case 1844104722:  return getInteraction();
        case -2023558323:  return addPopulation(); 
        case 444367565:  return getUndesirableEffect();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 107135229: /*contraindication*/ return new String[] {};
        case -597168804: /*indication*/ return new String[] {};
        case 1844104722: /*interaction*/ return new String[] {};
        case -2023558323: /*population*/ return new String[] {"Population"};
        case 444367565: /*undesirableEffect*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type ClinicalUseIssue.type");
        }
        else if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("subject")) {
          return addSubject();
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ClinicalUseIssue.description");
        }
        else if (name.equals("contraindication")) {
          this.contraindication = new ClinicalUseIssueContraindicationComponent();
          return this.contraindication;
        }
        else if (name.equals("indication")) {
          this.indication = new ClinicalUseIssueIndicationComponent();
          return this.indication;
        }
        else if (name.equals("interaction")) {
          this.interaction = new ClinicalUseIssueInteractionComponent();
          return this.interaction;
        }
        else if (name.equals("population")) {
          return addPopulation();
        }
        else if (name.equals("undesirableEffect")) {
          this.undesirableEffect = new ClinicalUseIssueUndesirableEffectComponent();
          return this.undesirableEffect;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ClinicalUseIssue";

  }

      public ClinicalUseIssue copy() {
        ClinicalUseIssue dst = new ClinicalUseIssue();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseIssue dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.category = category == null ? null : category.copy();
        if (subject != null) {
          dst.subject = new ArrayList<Reference>();
          for (Reference i : subject)
            dst.subject.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.description = description == null ? null : description.copy();
        dst.contraindication = contraindication == null ? null : contraindication.copy();
        dst.indication = indication == null ? null : indication.copy();
        dst.interaction = interaction == null ? null : interaction.copy();
        if (population != null) {
          dst.population = new ArrayList<Population>();
          for (Population i : population)
            dst.population.add(i.copy());
        };
        dst.undesirableEffect = undesirableEffect == null ? null : undesirableEffect.copy();
      }

      protected ClinicalUseIssue typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssue))
          return false;
        ClinicalUseIssue o = (ClinicalUseIssue) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(category, o.category, true)
           && compareDeep(subject, o.subject, true) && compareDeep(status, o.status, true) && compareDeep(description, o.description, true)
           && compareDeep(contraindication, o.contraindication, true) && compareDeep(indication, o.indication, true)
           && compareDeep(interaction, o.interaction, true) && compareDeep(population, o.population, true)
           && compareDeep(undesirableEffect, o.undesirableEffect, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseIssue))
          return false;
        ClinicalUseIssue o = (ClinicalUseIssue) other_;
        return compareValues(type, o.type, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, category
          , subject, status, description, contraindication, indication, interaction, population
          , undesirableEffect);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ClinicalUseIssue;
   }

 /**
   * Search parameter: <b>contraindication</b>
   * <p>
   * Description: <b>The situation that is being documented as contraindicating against this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.contraindication.diseaseSymptomProcedure</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contraindication", path="ClinicalUseIssue.contraindication.diseaseSymptomProcedure", description="The situation that is being documented as contraindicating against this item", type="token" )
  public static final String SP_CONTRAINDICATION = "contraindication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contraindication</b>
   * <p>
   * Description: <b>The situation that is being documented as contraindicating against this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.contraindication.diseaseSymptomProcedure</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTRAINDICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTRAINDICATION);

 /**
   * Search parameter: <b>effect</b>
   * <p>
   * Description: <b>The situation in which the undesirable effect may manifest</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.undesirableEffect.symptomConditionEffect</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effect", path="ClinicalUseIssue.undesirableEffect.symptomConditionEffect", description="The situation in which the undesirable effect may manifest", type="token" )
  public static final String SP_EFFECT = "effect";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effect</b>
   * <p>
   * Description: <b>The situation in which the undesirable effect may manifest</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.undesirableEffect.symptomConditionEffect</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EFFECT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EFFECT);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for this issue</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ClinicalUseIssue.identifier", description="Business identifier for this issue", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for this issue</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>indication</b>
   * <p>
   * Description: <b>The situation that is being documented as an indicaton for this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.indication.diseaseSymptomProcedure</b><br>
   * </p>
   */
  @SearchParamDefinition(name="indication", path="ClinicalUseIssue.indication.diseaseSymptomProcedure", description="The situation that is being documented as an indicaton for this item", type="token" )
  public static final String SP_INDICATION = "indication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>indication</b>
   * <p>
   * Description: <b>The situation that is being documented as an indicaton for this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.indication.diseaseSymptomProcedure</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INDICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INDICATION);

 /**
   * Search parameter: <b>interaction</b>
   * <p>
   * Description: <b>The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.interaction.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="interaction", path="ClinicalUseIssue.interaction.type", description="The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction", type="token" )
  public static final String SP_INTERACTION = "interaction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>interaction</b>
   * <p>
   * Description: <b>The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.interaction.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INTERACTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INTERACTION);

 /**
   * Search parameter: <b>product</b>
   * <p>
   * Description: <b>The medicinal product for which this is a clinical usage issue</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseIssue.subject.where(resolve() is MedicinalProductDefinition)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="product", path="ClinicalUseIssue.subject.where(resolve() is MedicinalProductDefinition)", description="The medicinal product for which this is a clinical usage issue", type="reference", target={MedicinalProductDefinition.class } )
  public static final String SP_PRODUCT = "product";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>product</b>
   * <p>
   * Description: <b>The medicinal product for which this is a clinical usage issue</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseIssue.subject.where(resolve() is MedicinalProductDefinition)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRODUCT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRODUCT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalUseIssue:product</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRODUCT = new ca.uhn.fhir.model.api.Include("ClinicalUseIssue:product").toLocked();

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The resource for which this is a clinical usage issue</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseIssue.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="ClinicalUseIssue.subject", description="The resource for which this is a clinical usage issue", type="reference", target={ActivityDefinition.class, Device.class, DeviceDefinition.class, Medication.class, MedicinalProductDefinition.class, PlanDefinition.class, Substance.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The resource for which this is a clinical usage issue</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseIssue.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalUseIssue:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("ClinicalUseIssue:subject").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>indication | contraindication | interaction | undesirable-effect | warning</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="ClinicalUseIssue.type", description="indication | contraindication | interaction | undesirable-effect | warning", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>indication | contraindication | interaction | undesirable-effect | warning</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseIssue.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}