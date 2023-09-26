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
 * A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.
 */
@ResourceDef(name="ClinicalUseDefinition", profile="http://hl7.org/fhir/StructureDefinition/ClinicalUseDefinition")
public class ClinicalUseDefinition extends DomainResource {

    public enum ClinicalUseDefinitionType {
        /**
         * A reason for giving the medication.
         */
        INDICATION, 
        /**
         * A reason for not giving the medication.
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
        public static ClinicalUseDefinitionType fromCode(String codeString) throws FHIRException {
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
          throw new FHIRException("Unknown ClinicalUseDefinitionType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INDICATION: return "indication";
            case CONTRAINDICATION: return "contraindication";
            case INTERACTION: return "interaction";
            case UNDESIRABLEEFFECT: return "undesirable-effect";
            case WARNING: return "warning";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INDICATION: return "http://hl7.org/fhir/clinical-use-definition-type";
            case CONTRAINDICATION: return "http://hl7.org/fhir/clinical-use-definition-type";
            case INTERACTION: return "http://hl7.org/fhir/clinical-use-definition-type";
            case UNDESIRABLEEFFECT: return "http://hl7.org/fhir/clinical-use-definition-type";
            case WARNING: return "http://hl7.org/fhir/clinical-use-definition-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INDICATION: return "A reason for giving the medication.";
            case CONTRAINDICATION: return "A reason for not giving the medication.";
            case INTERACTION: return "Interactions between the medication and other substances.";
            case UNDESIRABLEEFFECT: return "Side effects or adverse effects associated with the medication.";
            case WARNING: return "A general warning or issue that is not specifically one of the other types.";
            case NULL: return null;
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
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ClinicalUseDefinitionTypeEnumFactory implements EnumFactory<ClinicalUseDefinitionType> {
    public ClinicalUseDefinitionType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("indication".equals(codeString))
          return ClinicalUseDefinitionType.INDICATION;
        if ("contraindication".equals(codeString))
          return ClinicalUseDefinitionType.CONTRAINDICATION;
        if ("interaction".equals(codeString))
          return ClinicalUseDefinitionType.INTERACTION;
        if ("undesirable-effect".equals(codeString))
          return ClinicalUseDefinitionType.UNDESIRABLEEFFECT;
        if ("warning".equals(codeString))
          return ClinicalUseDefinitionType.WARNING;
        throw new IllegalArgumentException("Unknown ClinicalUseDefinitionType code '"+codeString+"'");
        }
        public Enumeration<ClinicalUseDefinitionType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ClinicalUseDefinitionType>(this, ClinicalUseDefinitionType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ClinicalUseDefinitionType>(this, ClinicalUseDefinitionType.NULL, code);
        if ("indication".equals(codeString))
          return new Enumeration<ClinicalUseDefinitionType>(this, ClinicalUseDefinitionType.INDICATION, code);
        if ("contraindication".equals(codeString))
          return new Enumeration<ClinicalUseDefinitionType>(this, ClinicalUseDefinitionType.CONTRAINDICATION, code);
        if ("interaction".equals(codeString))
          return new Enumeration<ClinicalUseDefinitionType>(this, ClinicalUseDefinitionType.INTERACTION, code);
        if ("undesirable-effect".equals(codeString))
          return new Enumeration<ClinicalUseDefinitionType>(this, ClinicalUseDefinitionType.UNDESIRABLEEFFECT, code);
        if ("warning".equals(codeString))
          return new Enumeration<ClinicalUseDefinitionType>(this, ClinicalUseDefinitionType.WARNING, code);
        throw new FHIRException("Unknown ClinicalUseDefinitionType code '"+codeString+"'");
        }
    public String toCode(ClinicalUseDefinitionType code) {
      if (code == ClinicalUseDefinitionType.INDICATION)
        return "indication";
      if (code == ClinicalUseDefinitionType.CONTRAINDICATION)
        return "contraindication";
      if (code == ClinicalUseDefinitionType.INTERACTION)
        return "interaction";
      if (code == ClinicalUseDefinitionType.UNDESIRABLEEFFECT)
        return "undesirable-effect";
      if (code == ClinicalUseDefinitionType.WARNING)
        return "warning";
      return "?";
      }
    public String toSystem(ClinicalUseDefinitionType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ClinicalUseDefinitionContraindicationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The situation that is being documented as contraindicating against this item.
         */
        @Child(name = "diseaseSymptomProcedure", type = {CodeableReference.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The situation that is being documented as contraindicating against this item", formalDefinition="The situation that is being documented as contraindicating against this item." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/disease-symptom-procedure")
        protected CodeableReference diseaseSymptomProcedure;

        /**
         * The status of the disease or symptom for the contraindication, for example "chronic" or "metastatic".
         */
        @Child(name = "diseaseStatus", type = {CodeableReference.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status of the disease or symptom for the contraindication", formalDefinition="The status of the disease or symptom for the contraindication, for example \"chronic\" or \"metastatic\"." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/disease-status")
        protected CodeableReference diseaseStatus;

        /**
         * A comorbidity (concurrent condition) or coinfection.
         */
        @Child(name = "comorbidity", type = {CodeableReference.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A comorbidity (concurrent condition) or coinfection", formalDefinition="A comorbidity (concurrent condition) or coinfection." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/disease-symptom-procedure")
        protected List<CodeableReference> comorbidity;

        /**
         * The indication which this is a contraidication for.
         */
        @Child(name = "indication", type = {ClinicalUseDefinition.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The indication which this is a contraidication for", formalDefinition="The indication which this is a contraidication for." )
        protected List<Reference> indication;

        /**
         * An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.
         */
        @Child(name = "applicability", type = {Expression.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements", formalDefinition="An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements." )
        protected Expression applicability;

        /**
         * Information about the use of the medicinal product in relation to other therapies described as part of the contraindication.
         */
        @Child(name = "otherTherapy", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Information about use of the product in relation to other therapies described as part of the contraindication", formalDefinition="Information about the use of the medicinal product in relation to other therapies described as part of the contraindication." )
        protected List<ClinicalUseDefinitionContraindicationOtherTherapyComponent> otherTherapy;

        private static final long serialVersionUID = 1942194420L;

    /**
     * Constructor
     */
      public ClinicalUseDefinitionContraindicationComponent() {
        super();
      }

        /**
         * @return {@link #diseaseSymptomProcedure} (The situation that is being documented as contraindicating against this item.)
         */
        public CodeableReference getDiseaseSymptomProcedure() { 
          if (this.diseaseSymptomProcedure == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionContraindicationComponent.diseaseSymptomProcedure");
            else if (Configuration.doAutoCreate())
              this.diseaseSymptomProcedure = new CodeableReference(); // cc
          return this.diseaseSymptomProcedure;
        }

        public boolean hasDiseaseSymptomProcedure() { 
          return this.diseaseSymptomProcedure != null && !this.diseaseSymptomProcedure.isEmpty();
        }

        /**
         * @param value {@link #diseaseSymptomProcedure} (The situation that is being documented as contraindicating against this item.)
         */
        public ClinicalUseDefinitionContraindicationComponent setDiseaseSymptomProcedure(CodeableReference value) { 
          this.diseaseSymptomProcedure = value;
          return this;
        }

        /**
         * @return {@link #diseaseStatus} (The status of the disease or symptom for the contraindication, for example "chronic" or "metastatic".)
         */
        public CodeableReference getDiseaseStatus() { 
          if (this.diseaseStatus == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionContraindicationComponent.diseaseStatus");
            else if (Configuration.doAutoCreate())
              this.diseaseStatus = new CodeableReference(); // cc
          return this.diseaseStatus;
        }

        public boolean hasDiseaseStatus() { 
          return this.diseaseStatus != null && !this.diseaseStatus.isEmpty();
        }

        /**
         * @param value {@link #diseaseStatus} (The status of the disease or symptom for the contraindication, for example "chronic" or "metastatic".)
         */
        public ClinicalUseDefinitionContraindicationComponent setDiseaseStatus(CodeableReference value) { 
          this.diseaseStatus = value;
          return this;
        }

        /**
         * @return {@link #comorbidity} (A comorbidity (concurrent condition) or coinfection.)
         */
        public List<CodeableReference> getComorbidity() { 
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableReference>();
          return this.comorbidity;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseDefinitionContraindicationComponent setComorbidity(List<CodeableReference> theComorbidity) { 
          this.comorbidity = theComorbidity;
          return this;
        }

        public boolean hasComorbidity() { 
          if (this.comorbidity == null)
            return false;
          for (CodeableReference item : this.comorbidity)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addComorbidity() { //3
          CodeableReference t = new CodeableReference();
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableReference>();
          this.comorbidity.add(t);
          return t;
        }

        public ClinicalUseDefinitionContraindicationComponent addComorbidity(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableReference>();
          this.comorbidity.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #comorbidity}, creating it if it does not already exist {3}
         */
        public CodeableReference getComorbidityFirstRep() { 
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
        public ClinicalUseDefinitionContraindicationComponent setIndication(List<Reference> theIndication) { 
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

        public ClinicalUseDefinitionContraindicationComponent addIndication(Reference t) { //3
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
         * @return {@link #applicability} (An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.)
         */
        public Expression getApplicability() { 
          if (this.applicability == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionContraindicationComponent.applicability");
            else if (Configuration.doAutoCreate())
              this.applicability = new Expression(); // cc
          return this.applicability;
        }

        public boolean hasApplicability() { 
          return this.applicability != null && !this.applicability.isEmpty();
        }

        /**
         * @param value {@link #applicability} (An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.)
         */
        public ClinicalUseDefinitionContraindicationComponent setApplicability(Expression value) { 
          this.applicability = value;
          return this;
        }

        /**
         * @return {@link #otherTherapy} (Information about the use of the medicinal product in relation to other therapies described as part of the contraindication.)
         */
        public List<ClinicalUseDefinitionContraindicationOtherTherapyComponent> getOtherTherapy() { 
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseDefinitionContraindicationOtherTherapyComponent>();
          return this.otherTherapy;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseDefinitionContraindicationComponent setOtherTherapy(List<ClinicalUseDefinitionContraindicationOtherTherapyComponent> theOtherTherapy) { 
          this.otherTherapy = theOtherTherapy;
          return this;
        }

        public boolean hasOtherTherapy() { 
          if (this.otherTherapy == null)
            return false;
          for (ClinicalUseDefinitionContraindicationOtherTherapyComponent item : this.otherTherapy)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ClinicalUseDefinitionContraindicationOtherTherapyComponent addOtherTherapy() { //3
          ClinicalUseDefinitionContraindicationOtherTherapyComponent t = new ClinicalUseDefinitionContraindicationOtherTherapyComponent();
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseDefinitionContraindicationOtherTherapyComponent>();
          this.otherTherapy.add(t);
          return t;
        }

        public ClinicalUseDefinitionContraindicationComponent addOtherTherapy(ClinicalUseDefinitionContraindicationOtherTherapyComponent t) { //3
          if (t == null)
            return this;
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseDefinitionContraindicationOtherTherapyComponent>();
          this.otherTherapy.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #otherTherapy}, creating it if it does not already exist {3}
         */
        public ClinicalUseDefinitionContraindicationOtherTherapyComponent getOtherTherapyFirstRep() { 
          if (getOtherTherapy().isEmpty()) {
            addOtherTherapy();
          }
          return getOtherTherapy().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("diseaseSymptomProcedure", "CodeableReference(ObservationDefinition)", "The situation that is being documented as contraindicating against this item.", 0, 1, diseaseSymptomProcedure));
          children.add(new Property("diseaseStatus", "CodeableReference(ObservationDefinition)", "The status of the disease or symptom for the contraindication, for example \"chronic\" or \"metastatic\".", 0, 1, diseaseStatus));
          children.add(new Property("comorbidity", "CodeableReference(ObservationDefinition)", "A comorbidity (concurrent condition) or coinfection.", 0, java.lang.Integer.MAX_VALUE, comorbidity));
          children.add(new Property("indication", "Reference(ClinicalUseDefinition)", "The indication which this is a contraidication for.", 0, java.lang.Integer.MAX_VALUE, indication));
          children.add(new Property("applicability", "Expression", "An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.", 0, 1, applicability));
          children.add(new Property("otherTherapy", "", "Information about the use of the medicinal product in relation to other therapies described as part of the contraindication.", 0, java.lang.Integer.MAX_VALUE, otherTherapy));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1497395130: /*diseaseSymptomProcedure*/  return new Property("diseaseSymptomProcedure", "CodeableReference(ObservationDefinition)", "The situation that is being documented as contraindicating against this item.", 0, 1, diseaseSymptomProcedure);
          case -505503602: /*diseaseStatus*/  return new Property("diseaseStatus", "CodeableReference(ObservationDefinition)", "The status of the disease or symptom for the contraindication, for example \"chronic\" or \"metastatic\".", 0, 1, diseaseStatus);
          case -406395211: /*comorbidity*/  return new Property("comorbidity", "CodeableReference(ObservationDefinition)", "A comorbidity (concurrent condition) or coinfection.", 0, java.lang.Integer.MAX_VALUE, comorbidity);
          case -597168804: /*indication*/  return new Property("indication", "Reference(ClinicalUseDefinition)", "The indication which this is a contraidication for.", 0, java.lang.Integer.MAX_VALUE, indication);
          case -1526770491: /*applicability*/  return new Property("applicability", "Expression", "An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.", 0, 1, applicability);
          case -544509127: /*otherTherapy*/  return new Property("otherTherapy", "", "Information about the use of the medicinal product in relation to other therapies described as part of the contraindication.", 0, java.lang.Integer.MAX_VALUE, otherTherapy);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1497395130: /*diseaseSymptomProcedure*/ return this.diseaseSymptomProcedure == null ? new Base[0] : new Base[] {this.diseaseSymptomProcedure}; // CodeableReference
        case -505503602: /*diseaseStatus*/ return this.diseaseStatus == null ? new Base[0] : new Base[] {this.diseaseStatus}; // CodeableReference
        case -406395211: /*comorbidity*/ return this.comorbidity == null ? new Base[0] : this.comorbidity.toArray(new Base[this.comorbidity.size()]); // CodeableReference
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : this.indication.toArray(new Base[this.indication.size()]); // Reference
        case -1526770491: /*applicability*/ return this.applicability == null ? new Base[0] : new Base[] {this.applicability}; // Expression
        case -544509127: /*otherTherapy*/ return this.otherTherapy == null ? new Base[0] : this.otherTherapy.toArray(new Base[this.otherTherapy.size()]); // ClinicalUseDefinitionContraindicationOtherTherapyComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1497395130: // diseaseSymptomProcedure
          this.diseaseSymptomProcedure = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -505503602: // diseaseStatus
          this.diseaseStatus = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -406395211: // comorbidity
          this.getComorbidity().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -597168804: // indication
          this.getIndication().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1526770491: // applicability
          this.applicability = TypeConvertor.castToExpression(value); // Expression
          return value;
        case -544509127: // otherTherapy
          this.getOtherTherapy().add((ClinicalUseDefinitionContraindicationOtherTherapyComponent) value); // ClinicalUseDefinitionContraindicationOtherTherapyComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("comorbidity")) {
          this.getComorbidity().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("indication")) {
          this.getIndication().add(TypeConvertor.castToReference(value));
        } else if (name.equals("applicability")) {
          this.applicability = TypeConvertor.castToExpression(value); // Expression
        } else if (name.equals("otherTherapy")) {
          this.getOtherTherapy().add((ClinicalUseDefinitionContraindicationOtherTherapyComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = null;
        } else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = null;
        } else if (name.equals("comorbidity")) {
          this.getComorbidity().remove(value);
        } else if (name.equals("indication")) {
          this.getIndication().remove(value);
        } else if (name.equals("applicability")) {
          this.applicability = null;
        } else if (name.equals("otherTherapy")) {
          this.getOtherTherapy().add((ClinicalUseDefinitionContraindicationOtherTherapyComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1497395130:  return getDiseaseSymptomProcedure();
        case -505503602:  return getDiseaseStatus();
        case -406395211:  return addComorbidity(); 
        case -597168804:  return addIndication(); 
        case -1526770491:  return getApplicability();
        case -544509127:  return addOtherTherapy(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1497395130: /*diseaseSymptomProcedure*/ return new String[] {"CodeableReference"};
        case -505503602: /*diseaseStatus*/ return new String[] {"CodeableReference"};
        case -406395211: /*comorbidity*/ return new String[] {"CodeableReference"};
        case -597168804: /*indication*/ return new String[] {"Reference"};
        case -1526770491: /*applicability*/ return new String[] {"Expression"};
        case -544509127: /*otherTherapy*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = new CodeableReference();
          return this.diseaseSymptomProcedure;
        }
        else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = new CodeableReference();
          return this.diseaseStatus;
        }
        else if (name.equals("comorbidity")) {
          return addComorbidity();
        }
        else if (name.equals("indication")) {
          return addIndication();
        }
        else if (name.equals("applicability")) {
          this.applicability = new Expression();
          return this.applicability;
        }
        else if (name.equals("otherTherapy")) {
          return addOtherTherapy();
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseDefinitionContraindicationComponent copy() {
        ClinicalUseDefinitionContraindicationComponent dst = new ClinicalUseDefinitionContraindicationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseDefinitionContraindicationComponent dst) {
        super.copyValues(dst);
        dst.diseaseSymptomProcedure = diseaseSymptomProcedure == null ? null : diseaseSymptomProcedure.copy();
        dst.diseaseStatus = diseaseStatus == null ? null : diseaseStatus.copy();
        if (comorbidity != null) {
          dst.comorbidity = new ArrayList<CodeableReference>();
          for (CodeableReference i : comorbidity)
            dst.comorbidity.add(i.copy());
        };
        if (indication != null) {
          dst.indication = new ArrayList<Reference>();
          for (Reference i : indication)
            dst.indication.add(i.copy());
        };
        dst.applicability = applicability == null ? null : applicability.copy();
        if (otherTherapy != null) {
          dst.otherTherapy = new ArrayList<ClinicalUseDefinitionContraindicationOtherTherapyComponent>();
          for (ClinicalUseDefinitionContraindicationOtherTherapyComponent i : otherTherapy)
            dst.otherTherapy.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionContraindicationComponent))
          return false;
        ClinicalUseDefinitionContraindicationComponent o = (ClinicalUseDefinitionContraindicationComponent) other_;
        return compareDeep(diseaseSymptomProcedure, o.diseaseSymptomProcedure, true) && compareDeep(diseaseStatus, o.diseaseStatus, true)
           && compareDeep(comorbidity, o.comorbidity, true) && compareDeep(indication, o.indication, true)
           && compareDeep(applicability, o.applicability, true) && compareDeep(otherTherapy, o.otherTherapy, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionContraindicationComponent))
          return false;
        ClinicalUseDefinitionContraindicationComponent o = (ClinicalUseDefinitionContraindicationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(diseaseSymptomProcedure, diseaseStatus
          , comorbidity, indication, applicability, otherTherapy);
      }

  public String fhirType() {
    return "ClinicalUseDefinition.contraindication";

  }

  }

    @Block()
    public static class ClinicalUseDefinitionContraindicationOtherTherapyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of relationship between the medicinal product indication or contraindication and another therapy.
         */
        @Child(name = "relationshipType", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of relationship between the product indication/contraindication and another therapy", formalDefinition="The type of relationship between the medicinal product indication or contraindication and another therapy." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/therapy-relationship-type")
        protected CodeableConcept relationshipType;

        /**
         * Reference to a specific medication (active substance, medicinal product or class of products, biological, food etc.) as part of an indication or contraindication.
         */
        @Child(name = "treatment", type = {CodeableReference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reference to a specific medication, substance etc. as part of an indication or contraindication", formalDefinition="Reference to a specific medication (active substance, medicinal product or class of products, biological, food etc.) as part of an indication or contraindication." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/therapy")
        protected CodeableReference treatment;

        private static final long serialVersionUID = -1638121853L;

    /**
     * Constructor
     */
      public ClinicalUseDefinitionContraindicationOtherTherapyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ClinicalUseDefinitionContraindicationOtherTherapyComponent(CodeableConcept relationshipType, CodeableReference treatment) {
        super();
        this.setRelationshipType(relationshipType);
        this.setTreatment(treatment);
      }

        /**
         * @return {@link #relationshipType} (The type of relationship between the medicinal product indication or contraindication and another therapy.)
         */
        public CodeableConcept getRelationshipType() { 
          if (this.relationshipType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionContraindicationOtherTherapyComponent.relationshipType");
            else if (Configuration.doAutoCreate())
              this.relationshipType = new CodeableConcept(); // cc
          return this.relationshipType;
        }

        public boolean hasRelationshipType() { 
          return this.relationshipType != null && !this.relationshipType.isEmpty();
        }

        /**
         * @param value {@link #relationshipType} (The type of relationship between the medicinal product indication or contraindication and another therapy.)
         */
        public ClinicalUseDefinitionContraindicationOtherTherapyComponent setRelationshipType(CodeableConcept value) { 
          this.relationshipType = value;
          return this;
        }

        /**
         * @return {@link #treatment} (Reference to a specific medication (active substance, medicinal product or class of products, biological, food etc.) as part of an indication or contraindication.)
         */
        public CodeableReference getTreatment() { 
          if (this.treatment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionContraindicationOtherTherapyComponent.treatment");
            else if (Configuration.doAutoCreate())
              this.treatment = new CodeableReference(); // cc
          return this.treatment;
        }

        public boolean hasTreatment() { 
          return this.treatment != null && !this.treatment.isEmpty();
        }

        /**
         * @param value {@link #treatment} (Reference to a specific medication (active substance, medicinal product or class of products, biological, food etc.) as part of an indication or contraindication.)
         */
        public ClinicalUseDefinitionContraindicationOtherTherapyComponent setTreatment(CodeableReference value) { 
          this.treatment = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("relationshipType", "CodeableConcept", "The type of relationship between the medicinal product indication or contraindication and another therapy.", 0, 1, relationshipType));
          children.add(new Property("treatment", "CodeableReference(MedicinalProductDefinition|Medication|Substance|SubstanceDefinition|NutritionProduct|BiologicallyDerivedProduct|ActivityDefinition)", "Reference to a specific medication (active substance, medicinal product or class of products, biological, food etc.) as part of an indication or contraindication.", 0, 1, treatment));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1602839150: /*relationshipType*/  return new Property("relationshipType", "CodeableConcept", "The type of relationship between the medicinal product indication or contraindication and another therapy.", 0, 1, relationshipType);
          case -63342472: /*treatment*/  return new Property("treatment", "CodeableReference(MedicinalProductDefinition|Medication|Substance|SubstanceDefinition|NutritionProduct|BiologicallyDerivedProduct|ActivityDefinition)", "Reference to a specific medication (active substance, medicinal product or class of products, biological, food etc.) as part of an indication or contraindication.", 0, 1, treatment);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1602839150: /*relationshipType*/ return this.relationshipType == null ? new Base[0] : new Base[] {this.relationshipType}; // CodeableConcept
        case -63342472: /*treatment*/ return this.treatment == null ? new Base[0] : new Base[] {this.treatment}; // CodeableReference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1602839150: // relationshipType
          this.relationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -63342472: // treatment
          this.treatment = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("relationshipType")) {
          this.relationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("treatment")) {
          this.treatment = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("relationshipType")) {
          this.relationshipType = null;
        } else if (name.equals("treatment")) {
          this.treatment = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1602839150:  return getRelationshipType();
        case -63342472:  return getTreatment();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1602839150: /*relationshipType*/ return new String[] {"CodeableConcept"};
        case -63342472: /*treatment*/ return new String[] {"CodeableReference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("relationshipType")) {
          this.relationshipType = new CodeableConcept();
          return this.relationshipType;
        }
        else if (name.equals("treatment")) {
          this.treatment = new CodeableReference();
          return this.treatment;
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseDefinitionContraindicationOtherTherapyComponent copy() {
        ClinicalUseDefinitionContraindicationOtherTherapyComponent dst = new ClinicalUseDefinitionContraindicationOtherTherapyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseDefinitionContraindicationOtherTherapyComponent dst) {
        super.copyValues(dst);
        dst.relationshipType = relationshipType == null ? null : relationshipType.copy();
        dst.treatment = treatment == null ? null : treatment.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionContraindicationOtherTherapyComponent))
          return false;
        ClinicalUseDefinitionContraindicationOtherTherapyComponent o = (ClinicalUseDefinitionContraindicationOtherTherapyComponent) other_;
        return compareDeep(relationshipType, o.relationshipType, true) && compareDeep(treatment, o.treatment, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionContraindicationOtherTherapyComponent))
          return false;
        ClinicalUseDefinitionContraindicationOtherTherapyComponent o = (ClinicalUseDefinitionContraindicationOtherTherapyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(relationshipType, treatment
          );
      }

  public String fhirType() {
    return "ClinicalUseDefinition.contraindication.otherTherapy";

  }

  }

    @Block()
    public static class ClinicalUseDefinitionIndicationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The situation that is being documented as an indicaton for this item.
         */
        @Child(name = "diseaseSymptomProcedure", type = {CodeableReference.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The situation that is being documented as an indicaton for this item", formalDefinition="The situation that is being documented as an indicaton for this item." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/disease-symptom-procedure")
        protected CodeableReference diseaseSymptomProcedure;

        /**
         * The status of the disease or symptom for the indication, for example "chronic" or "metastatic".
         */
        @Child(name = "diseaseStatus", type = {CodeableReference.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status of the disease or symptom for the indication", formalDefinition="The status of the disease or symptom for the indication, for example \"chronic\" or \"metastatic\"." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/disease-status")
        protected CodeableReference diseaseStatus;

        /**
         * A comorbidity (concurrent condition) or coinfection as part of the indication.
         */
        @Child(name = "comorbidity", type = {CodeableReference.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A comorbidity or coinfection as part of the indication", formalDefinition="A comorbidity (concurrent condition) or coinfection as part of the indication." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/disease-symptom-procedure")
        protected List<CodeableReference> comorbidity;

        /**
         * The intended effect, aim or strategy to be achieved.
         */
        @Child(name = "intendedEffect", type = {CodeableReference.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The intended effect, aim or strategy to be achieved", formalDefinition="The intended effect, aim or strategy to be achieved." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/product-intended-use")
        protected CodeableReference intendedEffect;

        /**
         * Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).
         */
        @Child(name = "duration", type = {Range.class, StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Timing or duration information", formalDefinition="Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months)." )
        protected DataType duration;

        /**
         * An unwanted side effect or negative outcome that may happen if you use the drug (or other subject of this resource) for this indication.
         */
        @Child(name = "undesirableEffect", type = {ClinicalUseDefinition.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="An unwanted side effect or negative outcome of the subject of this resource when being used for this indication", formalDefinition="An unwanted side effect or negative outcome that may happen if you use the drug (or other subject of this resource) for this indication." )
        protected List<Reference> undesirableEffect;

        /**
         * An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.
         */
        @Child(name = "applicability", type = {Expression.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements", formalDefinition="An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements." )
        protected Expression applicability;

        /**
         * Information about the use of the medicinal product in relation to other therapies described as part of the indication.
         */
        @Child(name = "otherTherapy", type = {ClinicalUseDefinitionContraindicationOtherTherapyComponent.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The use of the medicinal product in relation to other therapies described as part of the indication", formalDefinition="Information about the use of the medicinal product in relation to other therapies described as part of the indication." )
        protected List<ClinicalUseDefinitionContraindicationOtherTherapyComponent> otherTherapy;

        private static final long serialVersionUID = 809598459L;

    /**
     * Constructor
     */
      public ClinicalUseDefinitionIndicationComponent() {
        super();
      }

        /**
         * @return {@link #diseaseSymptomProcedure} (The situation that is being documented as an indicaton for this item.)
         */
        public CodeableReference getDiseaseSymptomProcedure() { 
          if (this.diseaseSymptomProcedure == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionIndicationComponent.diseaseSymptomProcedure");
            else if (Configuration.doAutoCreate())
              this.diseaseSymptomProcedure = new CodeableReference(); // cc
          return this.diseaseSymptomProcedure;
        }

        public boolean hasDiseaseSymptomProcedure() { 
          return this.diseaseSymptomProcedure != null && !this.diseaseSymptomProcedure.isEmpty();
        }

        /**
         * @param value {@link #diseaseSymptomProcedure} (The situation that is being documented as an indicaton for this item.)
         */
        public ClinicalUseDefinitionIndicationComponent setDiseaseSymptomProcedure(CodeableReference value) { 
          this.diseaseSymptomProcedure = value;
          return this;
        }

        /**
         * @return {@link #diseaseStatus} (The status of the disease or symptom for the indication, for example "chronic" or "metastatic".)
         */
        public CodeableReference getDiseaseStatus() { 
          if (this.diseaseStatus == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionIndicationComponent.diseaseStatus");
            else if (Configuration.doAutoCreate())
              this.diseaseStatus = new CodeableReference(); // cc
          return this.diseaseStatus;
        }

        public boolean hasDiseaseStatus() { 
          return this.diseaseStatus != null && !this.diseaseStatus.isEmpty();
        }

        /**
         * @param value {@link #diseaseStatus} (The status of the disease or symptom for the indication, for example "chronic" or "metastatic".)
         */
        public ClinicalUseDefinitionIndicationComponent setDiseaseStatus(CodeableReference value) { 
          this.diseaseStatus = value;
          return this;
        }

        /**
         * @return {@link #comorbidity} (A comorbidity (concurrent condition) or coinfection as part of the indication.)
         */
        public List<CodeableReference> getComorbidity() { 
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableReference>();
          return this.comorbidity;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseDefinitionIndicationComponent setComorbidity(List<CodeableReference> theComorbidity) { 
          this.comorbidity = theComorbidity;
          return this;
        }

        public boolean hasComorbidity() { 
          if (this.comorbidity == null)
            return false;
          for (CodeableReference item : this.comorbidity)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addComorbidity() { //3
          CodeableReference t = new CodeableReference();
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableReference>();
          this.comorbidity.add(t);
          return t;
        }

        public ClinicalUseDefinitionIndicationComponent addComorbidity(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.comorbidity == null)
            this.comorbidity = new ArrayList<CodeableReference>();
          this.comorbidity.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #comorbidity}, creating it if it does not already exist {3}
         */
        public CodeableReference getComorbidityFirstRep() { 
          if (getComorbidity().isEmpty()) {
            addComorbidity();
          }
          return getComorbidity().get(0);
        }

        /**
         * @return {@link #intendedEffect} (The intended effect, aim or strategy to be achieved.)
         */
        public CodeableReference getIntendedEffect() { 
          if (this.intendedEffect == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionIndicationComponent.intendedEffect");
            else if (Configuration.doAutoCreate())
              this.intendedEffect = new CodeableReference(); // cc
          return this.intendedEffect;
        }

        public boolean hasIntendedEffect() { 
          return this.intendedEffect != null && !this.intendedEffect.isEmpty();
        }

        /**
         * @param value {@link #intendedEffect} (The intended effect, aim or strategy to be achieved.)
         */
        public ClinicalUseDefinitionIndicationComponent setIntendedEffect(CodeableReference value) { 
          this.intendedEffect = value;
          return this;
        }

        /**
         * @return {@link #duration} (Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).)
         */
        public DataType getDuration() { 
          return this.duration;
        }

        /**
         * @return {@link #duration} (Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).)
         */
        public Range getDurationRange() throws FHIRException { 
          if (this.duration == null)
            this.duration = new Range();
          if (!(this.duration instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.duration.getClass().getName()+" was encountered");
          return (Range) this.duration;
        }

        public boolean hasDurationRange() { 
          return this != null && this.duration instanceof Range;
        }

        /**
         * @return {@link #duration} (Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).)
         */
        public StringType getDurationStringType() throws FHIRException { 
          if (this.duration == null)
            this.duration = new StringType();
          if (!(this.duration instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.duration.getClass().getName()+" was encountered");
          return (StringType) this.duration;
        }

        public boolean hasDurationStringType() { 
          return this != null && this.duration instanceof StringType;
        }

        public boolean hasDuration() { 
          return this.duration != null && !this.duration.isEmpty();
        }

        /**
         * @param value {@link #duration} (Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).)
         */
        public ClinicalUseDefinitionIndicationComponent setDuration(DataType value) { 
          if (value != null && !(value instanceof Range || value instanceof StringType))
            throw new FHIRException("Not the right type for ClinicalUseDefinition.indication.duration[x]: "+value.fhirType());
          this.duration = value;
          return this;
        }

        /**
         * @return {@link #undesirableEffect} (An unwanted side effect or negative outcome that may happen if you use the drug (or other subject of this resource) for this indication.)
         */
        public List<Reference> getUndesirableEffect() { 
          if (this.undesirableEffect == null)
            this.undesirableEffect = new ArrayList<Reference>();
          return this.undesirableEffect;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseDefinitionIndicationComponent setUndesirableEffect(List<Reference> theUndesirableEffect) { 
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

        public ClinicalUseDefinitionIndicationComponent addUndesirableEffect(Reference t) { //3
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
         * @return {@link #applicability} (An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.)
         */
        public Expression getApplicability() { 
          if (this.applicability == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionIndicationComponent.applicability");
            else if (Configuration.doAutoCreate())
              this.applicability = new Expression(); // cc
          return this.applicability;
        }

        public boolean hasApplicability() { 
          return this.applicability != null && !this.applicability.isEmpty();
        }

        /**
         * @param value {@link #applicability} (An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.)
         */
        public ClinicalUseDefinitionIndicationComponent setApplicability(Expression value) { 
          this.applicability = value;
          return this;
        }

        /**
         * @return {@link #otherTherapy} (Information about the use of the medicinal product in relation to other therapies described as part of the indication.)
         */
        public List<ClinicalUseDefinitionContraindicationOtherTherapyComponent> getOtherTherapy() { 
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseDefinitionContraindicationOtherTherapyComponent>();
          return this.otherTherapy;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseDefinitionIndicationComponent setOtherTherapy(List<ClinicalUseDefinitionContraindicationOtherTherapyComponent> theOtherTherapy) { 
          this.otherTherapy = theOtherTherapy;
          return this;
        }

        public boolean hasOtherTherapy() { 
          if (this.otherTherapy == null)
            return false;
          for (ClinicalUseDefinitionContraindicationOtherTherapyComponent item : this.otherTherapy)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ClinicalUseDefinitionContraindicationOtherTherapyComponent addOtherTherapy() { //3
          ClinicalUseDefinitionContraindicationOtherTherapyComponent t = new ClinicalUseDefinitionContraindicationOtherTherapyComponent();
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseDefinitionContraindicationOtherTherapyComponent>();
          this.otherTherapy.add(t);
          return t;
        }

        public ClinicalUseDefinitionIndicationComponent addOtherTherapy(ClinicalUseDefinitionContraindicationOtherTherapyComponent t) { //3
          if (t == null)
            return this;
          if (this.otherTherapy == null)
            this.otherTherapy = new ArrayList<ClinicalUseDefinitionContraindicationOtherTherapyComponent>();
          this.otherTherapy.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #otherTherapy}, creating it if it does not already exist {3}
         */
        public ClinicalUseDefinitionContraindicationOtherTherapyComponent getOtherTherapyFirstRep() { 
          if (getOtherTherapy().isEmpty()) {
            addOtherTherapy();
          }
          return getOtherTherapy().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("diseaseSymptomProcedure", "CodeableReference(ObservationDefinition)", "The situation that is being documented as an indicaton for this item.", 0, 1, diseaseSymptomProcedure));
          children.add(new Property("diseaseStatus", "CodeableReference(ObservationDefinition)", "The status of the disease or symptom for the indication, for example \"chronic\" or \"metastatic\".", 0, 1, diseaseStatus));
          children.add(new Property("comorbidity", "CodeableReference(ObservationDefinition)", "A comorbidity (concurrent condition) or coinfection as part of the indication.", 0, java.lang.Integer.MAX_VALUE, comorbidity));
          children.add(new Property("intendedEffect", "CodeableReference(ObservationDefinition)", "The intended effect, aim or strategy to be achieved.", 0, 1, intendedEffect));
          children.add(new Property("duration[x]", "Range|string", "Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).", 0, 1, duration));
          children.add(new Property("undesirableEffect", "Reference(ClinicalUseDefinition)", "An unwanted side effect or negative outcome that may happen if you use the drug (or other subject of this resource) for this indication.", 0, java.lang.Integer.MAX_VALUE, undesirableEffect));
          children.add(new Property("applicability", "Expression", "An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.", 0, 1, applicability));
          children.add(new Property("otherTherapy", "@ClinicalUseDefinition.contraindication.otherTherapy", "Information about the use of the medicinal product in relation to other therapies described as part of the indication.", 0, java.lang.Integer.MAX_VALUE, otherTherapy));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1497395130: /*diseaseSymptomProcedure*/  return new Property("diseaseSymptomProcedure", "CodeableReference(ObservationDefinition)", "The situation that is being documented as an indicaton for this item.", 0, 1, diseaseSymptomProcedure);
          case -505503602: /*diseaseStatus*/  return new Property("diseaseStatus", "CodeableReference(ObservationDefinition)", "The status of the disease or symptom for the indication, for example \"chronic\" or \"metastatic\".", 0, 1, diseaseStatus);
          case -406395211: /*comorbidity*/  return new Property("comorbidity", "CodeableReference(ObservationDefinition)", "A comorbidity (concurrent condition) or coinfection as part of the indication.", 0, java.lang.Integer.MAX_VALUE, comorbidity);
          case 1587112348: /*intendedEffect*/  return new Property("intendedEffect", "CodeableReference(ObservationDefinition)", "The intended effect, aim or strategy to be achieved.", 0, 1, intendedEffect);
          case -478069140: /*duration[x]*/  return new Property("duration[x]", "Range|string", "Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).", 0, 1, duration);
          case -1992012396: /*duration*/  return new Property("duration[x]", "Range|string", "Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).", 0, 1, duration);
          case 128079881: /*durationRange*/  return new Property("duration[x]", "Range", "Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).", 0, 1, duration);
          case -278193467: /*durationString*/  return new Property("duration[x]", "string", "Timing or duration information, that may be associated with use with the indicated condition e.g. Adult patients suffering from myocardial infarction (from a few days until less than 35 days), ischaemic stroke (from 7 days until less than 6 months).", 0, 1, duration);
          case 444367565: /*undesirableEffect*/  return new Property("undesirableEffect", "Reference(ClinicalUseDefinition)", "An unwanted side effect or negative outcome that may happen if you use the drug (or other subject of this resource) for this indication.", 0, java.lang.Integer.MAX_VALUE, undesirableEffect);
          case -1526770491: /*applicability*/  return new Property("applicability", "Expression", "An expression that returns true or false, indicating whether the indication is applicable or not, after having applied its other elements.", 0, 1, applicability);
          case -544509127: /*otherTherapy*/  return new Property("otherTherapy", "@ClinicalUseDefinition.contraindication.otherTherapy", "Information about the use of the medicinal product in relation to other therapies described as part of the indication.", 0, java.lang.Integer.MAX_VALUE, otherTherapy);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1497395130: /*diseaseSymptomProcedure*/ return this.diseaseSymptomProcedure == null ? new Base[0] : new Base[] {this.diseaseSymptomProcedure}; // CodeableReference
        case -505503602: /*diseaseStatus*/ return this.diseaseStatus == null ? new Base[0] : new Base[] {this.diseaseStatus}; // CodeableReference
        case -406395211: /*comorbidity*/ return this.comorbidity == null ? new Base[0] : this.comorbidity.toArray(new Base[this.comorbidity.size()]); // CodeableReference
        case 1587112348: /*intendedEffect*/ return this.intendedEffect == null ? new Base[0] : new Base[] {this.intendedEffect}; // CodeableReference
        case -1992012396: /*duration*/ return this.duration == null ? new Base[0] : new Base[] {this.duration}; // DataType
        case 444367565: /*undesirableEffect*/ return this.undesirableEffect == null ? new Base[0] : this.undesirableEffect.toArray(new Base[this.undesirableEffect.size()]); // Reference
        case -1526770491: /*applicability*/ return this.applicability == null ? new Base[0] : new Base[] {this.applicability}; // Expression
        case -544509127: /*otherTherapy*/ return this.otherTherapy == null ? new Base[0] : this.otherTherapy.toArray(new Base[this.otherTherapy.size()]); // ClinicalUseDefinitionContraindicationOtherTherapyComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1497395130: // diseaseSymptomProcedure
          this.diseaseSymptomProcedure = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -505503602: // diseaseStatus
          this.diseaseStatus = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -406395211: // comorbidity
          this.getComorbidity().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 1587112348: // intendedEffect
          this.intendedEffect = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1992012396: // duration
          this.duration = TypeConvertor.castToType(value); // DataType
          return value;
        case 444367565: // undesirableEffect
          this.getUndesirableEffect().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1526770491: // applicability
          this.applicability = TypeConvertor.castToExpression(value); // Expression
          return value;
        case -544509127: // otherTherapy
          this.getOtherTherapy().add((ClinicalUseDefinitionContraindicationOtherTherapyComponent) value); // ClinicalUseDefinitionContraindicationOtherTherapyComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("comorbidity")) {
          this.getComorbidity().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("intendedEffect")) {
          this.intendedEffect = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("duration[x]")) {
          this.duration = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("undesirableEffect")) {
          this.getUndesirableEffect().add(TypeConvertor.castToReference(value));
        } else if (name.equals("applicability")) {
          this.applicability = TypeConvertor.castToExpression(value); // Expression
        } else if (name.equals("otherTherapy")) {
          this.getOtherTherapy().add((ClinicalUseDefinitionContraindicationOtherTherapyComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = null;
        } else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = null;
        } else if (name.equals("comorbidity")) {
          this.getComorbidity().remove(value);
        } else if (name.equals("intendedEffect")) {
          this.intendedEffect = null;
        } else if (name.equals("duration[x]")) {
          this.duration = null;
        } else if (name.equals("undesirableEffect")) {
          this.getUndesirableEffect().remove(value);
        } else if (name.equals("applicability")) {
          this.applicability = null;
        } else if (name.equals("otherTherapy")) {
          this.getOtherTherapy().add((ClinicalUseDefinitionContraindicationOtherTherapyComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1497395130:  return getDiseaseSymptomProcedure();
        case -505503602:  return getDiseaseStatus();
        case -406395211:  return addComorbidity(); 
        case 1587112348:  return getIntendedEffect();
        case -478069140:  return getDuration();
        case -1992012396:  return getDuration();
        case 444367565:  return addUndesirableEffect(); 
        case -1526770491:  return getApplicability();
        case -544509127:  return addOtherTherapy(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1497395130: /*diseaseSymptomProcedure*/ return new String[] {"CodeableReference"};
        case -505503602: /*diseaseStatus*/ return new String[] {"CodeableReference"};
        case -406395211: /*comorbidity*/ return new String[] {"CodeableReference"};
        case 1587112348: /*intendedEffect*/ return new String[] {"CodeableReference"};
        case -1992012396: /*duration*/ return new String[] {"Range", "string"};
        case 444367565: /*undesirableEffect*/ return new String[] {"Reference"};
        case -1526770491: /*applicability*/ return new String[] {"Expression"};
        case -544509127: /*otherTherapy*/ return new String[] {"@ClinicalUseDefinition.contraindication.otherTherapy"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("diseaseSymptomProcedure")) {
          this.diseaseSymptomProcedure = new CodeableReference();
          return this.diseaseSymptomProcedure;
        }
        else if (name.equals("diseaseStatus")) {
          this.diseaseStatus = new CodeableReference();
          return this.diseaseStatus;
        }
        else if (name.equals("comorbidity")) {
          return addComorbidity();
        }
        else if (name.equals("intendedEffect")) {
          this.intendedEffect = new CodeableReference();
          return this.intendedEffect;
        }
        else if (name.equals("durationRange")) {
          this.duration = new Range();
          return this.duration;
        }
        else if (name.equals("durationString")) {
          this.duration = new StringType();
          return this.duration;
        }
        else if (name.equals("undesirableEffect")) {
          return addUndesirableEffect();
        }
        else if (name.equals("applicability")) {
          this.applicability = new Expression();
          return this.applicability;
        }
        else if (name.equals("otherTherapy")) {
          return addOtherTherapy();
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseDefinitionIndicationComponent copy() {
        ClinicalUseDefinitionIndicationComponent dst = new ClinicalUseDefinitionIndicationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseDefinitionIndicationComponent dst) {
        super.copyValues(dst);
        dst.diseaseSymptomProcedure = diseaseSymptomProcedure == null ? null : diseaseSymptomProcedure.copy();
        dst.diseaseStatus = diseaseStatus == null ? null : diseaseStatus.copy();
        if (comorbidity != null) {
          dst.comorbidity = new ArrayList<CodeableReference>();
          for (CodeableReference i : comorbidity)
            dst.comorbidity.add(i.copy());
        };
        dst.intendedEffect = intendedEffect == null ? null : intendedEffect.copy();
        dst.duration = duration == null ? null : duration.copy();
        if (undesirableEffect != null) {
          dst.undesirableEffect = new ArrayList<Reference>();
          for (Reference i : undesirableEffect)
            dst.undesirableEffect.add(i.copy());
        };
        dst.applicability = applicability == null ? null : applicability.copy();
        if (otherTherapy != null) {
          dst.otherTherapy = new ArrayList<ClinicalUseDefinitionContraindicationOtherTherapyComponent>();
          for (ClinicalUseDefinitionContraindicationOtherTherapyComponent i : otherTherapy)
            dst.otherTherapy.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionIndicationComponent))
          return false;
        ClinicalUseDefinitionIndicationComponent o = (ClinicalUseDefinitionIndicationComponent) other_;
        return compareDeep(diseaseSymptomProcedure, o.diseaseSymptomProcedure, true) && compareDeep(diseaseStatus, o.diseaseStatus, true)
           && compareDeep(comorbidity, o.comorbidity, true) && compareDeep(intendedEffect, o.intendedEffect, true)
           && compareDeep(duration, o.duration, true) && compareDeep(undesirableEffect, o.undesirableEffect, true)
           && compareDeep(applicability, o.applicability, true) && compareDeep(otherTherapy, o.otherTherapy, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionIndicationComponent))
          return false;
        ClinicalUseDefinitionIndicationComponent o = (ClinicalUseDefinitionIndicationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(diseaseSymptomProcedure, diseaseStatus
          , comorbidity, intendedEffect, duration, undesirableEffect, applicability, otherTherapy
          );
      }

  public String fhirType() {
    return "ClinicalUseDefinition.indication";

  }

  }

    @Block()
    public static class ClinicalUseDefinitionInteractionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The specific medication, product, food, substance etc. or laboratory test that interacts.
         */
        @Child(name = "interactant", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The specific medication, product, food etc. or laboratory test that interacts", formalDefinition="The specific medication, product, food, substance etc. or laboratory test that interacts." )
        protected List<ClinicalUseDefinitionInteractionInteractantComponent> interactant;

        /**
         * The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of the interaction e.g. drug-drug interaction, drug-lab test interaction", formalDefinition="The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/interaction-type")
        protected CodeableConcept type;

        /**
         * The effect of the interaction, for example "reduced gastric absorption of primary medication".
         */
        @Child(name = "effect", type = {CodeableReference.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The effect of the interaction, for example \"reduced gastric absorption of primary medication\"", formalDefinition="The effect of the interaction, for example \"reduced gastric absorption of primary medication\"." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/interaction-effect")
        protected CodeableReference effect;

        /**
         * The incidence of the interaction, e.g. theoretical, observed.
         */
        @Child(name = "incidence", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The incidence of the interaction, e.g. theoretical, observed", formalDefinition="The incidence of the interaction, e.g. theoretical, observed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/interaction-incidence")
        protected CodeableConcept incidence;

        /**
         * Actions for managing the interaction.
         */
        @Child(name = "management", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Actions for managing the interaction", formalDefinition="Actions for managing the interaction." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/interaction-management")
        protected List<CodeableConcept> management;

        private static final long serialVersionUID = 2072955553L;

    /**
     * Constructor
     */
      public ClinicalUseDefinitionInteractionComponent() {
        super();
      }

        /**
         * @return {@link #interactant} (The specific medication, product, food, substance etc. or laboratory test that interacts.)
         */
        public List<ClinicalUseDefinitionInteractionInteractantComponent> getInteractant() { 
          if (this.interactant == null)
            this.interactant = new ArrayList<ClinicalUseDefinitionInteractionInteractantComponent>();
          return this.interactant;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseDefinitionInteractionComponent setInteractant(List<ClinicalUseDefinitionInteractionInteractantComponent> theInteractant) { 
          this.interactant = theInteractant;
          return this;
        }

        public boolean hasInteractant() { 
          if (this.interactant == null)
            return false;
          for (ClinicalUseDefinitionInteractionInteractantComponent item : this.interactant)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ClinicalUseDefinitionInteractionInteractantComponent addInteractant() { //3
          ClinicalUseDefinitionInteractionInteractantComponent t = new ClinicalUseDefinitionInteractionInteractantComponent();
          if (this.interactant == null)
            this.interactant = new ArrayList<ClinicalUseDefinitionInteractionInteractantComponent>();
          this.interactant.add(t);
          return t;
        }

        public ClinicalUseDefinitionInteractionComponent addInteractant(ClinicalUseDefinitionInteractionInteractantComponent t) { //3
          if (t == null)
            return this;
          if (this.interactant == null)
            this.interactant = new ArrayList<ClinicalUseDefinitionInteractionInteractantComponent>();
          this.interactant.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #interactant}, creating it if it does not already exist {3}
         */
        public ClinicalUseDefinitionInteractionInteractantComponent getInteractantFirstRep() { 
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
              throw new Error("Attempt to auto-create ClinicalUseDefinitionInteractionComponent.type");
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
        public ClinicalUseDefinitionInteractionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #effect} (The effect of the interaction, for example "reduced gastric absorption of primary medication".)
         */
        public CodeableReference getEffect() { 
          if (this.effect == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionInteractionComponent.effect");
            else if (Configuration.doAutoCreate())
              this.effect = new CodeableReference(); // cc
          return this.effect;
        }

        public boolean hasEffect() { 
          return this.effect != null && !this.effect.isEmpty();
        }

        /**
         * @param value {@link #effect} (The effect of the interaction, for example "reduced gastric absorption of primary medication".)
         */
        public ClinicalUseDefinitionInteractionComponent setEffect(CodeableReference value) { 
          this.effect = value;
          return this;
        }

        /**
         * @return {@link #incidence} (The incidence of the interaction, e.g. theoretical, observed.)
         */
        public CodeableConcept getIncidence() { 
          if (this.incidence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionInteractionComponent.incidence");
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
        public ClinicalUseDefinitionInteractionComponent setIncidence(CodeableConcept value) { 
          this.incidence = value;
          return this;
        }

        /**
         * @return {@link #management} (Actions for managing the interaction.)
         */
        public List<CodeableConcept> getManagement() { 
          if (this.management == null)
            this.management = new ArrayList<CodeableConcept>();
          return this.management;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ClinicalUseDefinitionInteractionComponent setManagement(List<CodeableConcept> theManagement) { 
          this.management = theManagement;
          return this;
        }

        public boolean hasManagement() { 
          if (this.management == null)
            return false;
          for (CodeableConcept item : this.management)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addManagement() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.management == null)
            this.management = new ArrayList<CodeableConcept>();
          this.management.add(t);
          return t;
        }

        public ClinicalUseDefinitionInteractionComponent addManagement(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.management == null)
            this.management = new ArrayList<CodeableConcept>();
          this.management.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #management}, creating it if it does not already exist {3}
         */
        public CodeableConcept getManagementFirstRep() { 
          if (getManagement().isEmpty()) {
            addManagement();
          }
          return getManagement().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("interactant", "", "The specific medication, product, food, substance etc. or laboratory test that interacts.", 0, java.lang.Integer.MAX_VALUE, interactant));
          children.add(new Property("type", "CodeableConcept", "The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction.", 0, 1, type));
          children.add(new Property("effect", "CodeableReference(ObservationDefinition)", "The effect of the interaction, for example \"reduced gastric absorption of primary medication\".", 0, 1, effect));
          children.add(new Property("incidence", "CodeableConcept", "The incidence of the interaction, e.g. theoretical, observed.", 0, 1, incidence));
          children.add(new Property("management", "CodeableConcept", "Actions for managing the interaction.", 0, java.lang.Integer.MAX_VALUE, management));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1844097009: /*interactant*/  return new Property("interactant", "", "The specific medication, product, food, substance etc. or laboratory test that interacts.", 0, java.lang.Integer.MAX_VALUE, interactant);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction.", 0, 1, type);
          case -1306084975: /*effect*/  return new Property("effect", "CodeableReference(ObservationDefinition)", "The effect of the interaction, for example \"reduced gastric absorption of primary medication\".", 0, 1, effect);
          case -1598467132: /*incidence*/  return new Property("incidence", "CodeableConcept", "The incidence of the interaction, e.g. theoretical, observed.", 0, 1, incidence);
          case -1799980989: /*management*/  return new Property("management", "CodeableConcept", "Actions for managing the interaction.", 0, java.lang.Integer.MAX_VALUE, management);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1844097009: /*interactant*/ return this.interactant == null ? new Base[0] : this.interactant.toArray(new Base[this.interactant.size()]); // ClinicalUseDefinitionInteractionInteractantComponent
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1306084975: /*effect*/ return this.effect == null ? new Base[0] : new Base[] {this.effect}; // CodeableReference
        case -1598467132: /*incidence*/ return this.incidence == null ? new Base[0] : new Base[] {this.incidence}; // CodeableConcept
        case -1799980989: /*management*/ return this.management == null ? new Base[0] : this.management.toArray(new Base[this.management.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1844097009: // interactant
          this.getInteractant().add((ClinicalUseDefinitionInteractionInteractantComponent) value); // ClinicalUseDefinitionInteractionInteractantComponent
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1306084975: // effect
          this.effect = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1598467132: // incidence
          this.incidence = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1799980989: // management
          this.getManagement().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("interactant")) {
          this.getInteractant().add((ClinicalUseDefinitionInteractionInteractantComponent) value);
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("effect")) {
          this.effect = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("incidence")) {
          this.incidence = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("management")) {
          this.getManagement().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("interactant")) {
          this.getInteractant().add((ClinicalUseDefinitionInteractionInteractantComponent) value);
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("effect")) {
          this.effect = null;
        } else if (name.equals("incidence")) {
          this.incidence = null;
        } else if (name.equals("management")) {
          this.getManagement().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1844097009:  return addInteractant(); 
        case 3575610:  return getType();
        case -1306084975:  return getEffect();
        case -1598467132:  return getIncidence();
        case -1799980989:  return addManagement(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1844097009: /*interactant*/ return new String[] {};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1306084975: /*effect*/ return new String[] {"CodeableReference"};
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
          this.effect = new CodeableReference();
          return this.effect;
        }
        else if (name.equals("incidence")) {
          this.incidence = new CodeableConcept();
          return this.incidence;
        }
        else if (name.equals("management")) {
          return addManagement();
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseDefinitionInteractionComponent copy() {
        ClinicalUseDefinitionInteractionComponent dst = new ClinicalUseDefinitionInteractionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseDefinitionInteractionComponent dst) {
        super.copyValues(dst);
        if (interactant != null) {
          dst.interactant = new ArrayList<ClinicalUseDefinitionInteractionInteractantComponent>();
          for (ClinicalUseDefinitionInteractionInteractantComponent i : interactant)
            dst.interactant.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.effect = effect == null ? null : effect.copy();
        dst.incidence = incidence == null ? null : incidence.copy();
        if (management != null) {
          dst.management = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : management)
            dst.management.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionInteractionComponent))
          return false;
        ClinicalUseDefinitionInteractionComponent o = (ClinicalUseDefinitionInteractionComponent) other_;
        return compareDeep(interactant, o.interactant, true) && compareDeep(type, o.type, true) && compareDeep(effect, o.effect, true)
           && compareDeep(incidence, o.incidence, true) && compareDeep(management, o.management, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionInteractionComponent))
          return false;
        ClinicalUseDefinitionInteractionComponent o = (ClinicalUseDefinitionInteractionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(interactant, type, effect
          , incidence, management);
      }

  public String fhirType() {
    return "ClinicalUseDefinition.interaction";

  }

  }

    @Block()
    public static class ClinicalUseDefinitionInteractionInteractantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The specific medication, product, food, substance etc. or laboratory test that interacts.
         */
        @Child(name = "item", type = {MedicinalProductDefinition.class, Medication.class, Substance.class, NutritionProduct.class, BiologicallyDerivedProduct.class, ObservationDefinition.class, CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The specific medication, product, food etc. or laboratory test that interacts", formalDefinition="The specific medication, product, food, substance etc. or laboratory test that interacts." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/interactant")
        protected DataType item;

        private static final long serialVersionUID = 1847936859L;

    /**
     * Constructor
     */
      public ClinicalUseDefinitionInteractionInteractantComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ClinicalUseDefinitionInteractionInteractantComponent(DataType item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (The specific medication, product, food, substance etc. or laboratory test that interacts.)
         */
        public DataType getItem() { 
          return this.item;
        }

        /**
         * @return {@link #item} (The specific medication, product, food, substance etc. or laboratory test that interacts.)
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
         * @return {@link #item} (The specific medication, product, food, substance etc. or laboratory test that interacts.)
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
         * @param value {@link #item} (The specific medication, product, food, substance etc. or laboratory test that interacts.)
         */
        public ClinicalUseDefinitionInteractionInteractantComponent setItem(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new FHIRException("Not the right type for ClinicalUseDefinition.interaction.interactant.item[x]: "+value.fhirType());
          this.item = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item[x]", "Reference(MedicinalProductDefinition|Medication|Substance|NutritionProduct|BiologicallyDerivedProduct|ObservationDefinition)|CodeableConcept", "The specific medication, product, food, substance etc. or laboratory test that interacts.", 0, 1, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2116201613: /*item[x]*/  return new Property("item[x]", "Reference(MedicinalProductDefinition|Medication|Substance|NutritionProduct|BiologicallyDerivedProduct|ObservationDefinition)|CodeableConcept", "The specific medication, product, food, substance etc. or laboratory test that interacts.", 0, 1, item);
          case 3242771: /*item*/  return new Property("item[x]", "Reference(MedicinalProductDefinition|Medication|Substance|NutritionProduct|BiologicallyDerivedProduct|ObservationDefinition)|CodeableConcept", "The specific medication, product, food, substance etc. or laboratory test that interacts.", 0, 1, item);
          case 1376364920: /*itemReference*/  return new Property("item[x]", "Reference(MedicinalProductDefinition|Medication|Substance|NutritionProduct|BiologicallyDerivedProduct|ObservationDefinition)", "The specific medication, product, food, substance etc. or laboratory test that interacts.", 0, 1, item);
          case 106644494: /*itemCodeableConcept*/  return new Property("item[x]", "CodeableConcept", "The specific medication, product, food, substance etc. or laboratory test that interacts.", 0, 1, item);
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("item[x]")) {
          this.item = null;
        } else
          super.removeChild(name, value);
        
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

      public ClinicalUseDefinitionInteractionInteractantComponent copy() {
        ClinicalUseDefinitionInteractionInteractantComponent dst = new ClinicalUseDefinitionInteractionInteractantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseDefinitionInteractionInteractantComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionInteractionInteractantComponent))
          return false;
        ClinicalUseDefinitionInteractionInteractantComponent o = (ClinicalUseDefinitionInteractionInteractantComponent) other_;
        return compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionInteractionInteractantComponent))
          return false;
        ClinicalUseDefinitionInteractionInteractantComponent o = (ClinicalUseDefinitionInteractionInteractantComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item);
      }

  public String fhirType() {
    return "ClinicalUseDefinition.interaction.interactant";

  }

  }

    @Block()
    public static class ClinicalUseDefinitionUndesirableEffectComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The situation in which the undesirable effect may manifest.
         */
        @Child(name = "symptomConditionEffect", type = {CodeableReference.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The situation in which the undesirable effect may manifest", formalDefinition="The situation in which the undesirable effect may manifest." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/undesirable-effect-symptom")
        protected CodeableReference symptomConditionEffect;

        /**
         * High level classification of the effect.
         */
        @Child(name = "classification", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="High level classification of the effect", formalDefinition="High level classification of the effect." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/undesirable-effect-classification")
        protected CodeableConcept classification;

        /**
         * How often the effect is seen.
         */
        @Child(name = "frequencyOfOccurrence", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="How often the effect is seen", formalDefinition="How often the effect is seen." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/undesirable-effect-frequency")
        protected CodeableConcept frequencyOfOccurrence;

        private static final long serialVersionUID = -55472609L;

    /**
     * Constructor
     */
      public ClinicalUseDefinitionUndesirableEffectComponent() {
        super();
      }

        /**
         * @return {@link #symptomConditionEffect} (The situation in which the undesirable effect may manifest.)
         */
        public CodeableReference getSymptomConditionEffect() { 
          if (this.symptomConditionEffect == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionUndesirableEffectComponent.symptomConditionEffect");
            else if (Configuration.doAutoCreate())
              this.symptomConditionEffect = new CodeableReference(); // cc
          return this.symptomConditionEffect;
        }

        public boolean hasSymptomConditionEffect() { 
          return this.symptomConditionEffect != null && !this.symptomConditionEffect.isEmpty();
        }

        /**
         * @param value {@link #symptomConditionEffect} (The situation in which the undesirable effect may manifest.)
         */
        public ClinicalUseDefinitionUndesirableEffectComponent setSymptomConditionEffect(CodeableReference value) { 
          this.symptomConditionEffect = value;
          return this;
        }

        /**
         * @return {@link #classification} (High level classification of the effect.)
         */
        public CodeableConcept getClassification() { 
          if (this.classification == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionUndesirableEffectComponent.classification");
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
        public ClinicalUseDefinitionUndesirableEffectComponent setClassification(CodeableConcept value) { 
          this.classification = value;
          return this;
        }

        /**
         * @return {@link #frequencyOfOccurrence} (How often the effect is seen.)
         */
        public CodeableConcept getFrequencyOfOccurrence() { 
          if (this.frequencyOfOccurrence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionUndesirableEffectComponent.frequencyOfOccurrence");
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
        public ClinicalUseDefinitionUndesirableEffectComponent setFrequencyOfOccurrence(CodeableConcept value) { 
          this.frequencyOfOccurrence = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("symptomConditionEffect", "CodeableReference(ObservationDefinition)", "The situation in which the undesirable effect may manifest.", 0, 1, symptomConditionEffect));
          children.add(new Property("classification", "CodeableConcept", "High level classification of the effect.", 0, 1, classification));
          children.add(new Property("frequencyOfOccurrence", "CodeableConcept", "How often the effect is seen.", 0, 1, frequencyOfOccurrence));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -650549981: /*symptomConditionEffect*/  return new Property("symptomConditionEffect", "CodeableReference(ObservationDefinition)", "The situation in which the undesirable effect may manifest.", 0, 1, symptomConditionEffect);
          case 382350310: /*classification*/  return new Property("classification", "CodeableConcept", "High level classification of the effect.", 0, 1, classification);
          case 791175812: /*frequencyOfOccurrence*/  return new Property("frequencyOfOccurrence", "CodeableConcept", "How often the effect is seen.", 0, 1, frequencyOfOccurrence);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -650549981: /*symptomConditionEffect*/ return this.symptomConditionEffect == null ? new Base[0] : new Base[] {this.symptomConditionEffect}; // CodeableReference
        case 382350310: /*classification*/ return this.classification == null ? new Base[0] : new Base[] {this.classification}; // CodeableConcept
        case 791175812: /*frequencyOfOccurrence*/ return this.frequencyOfOccurrence == null ? new Base[0] : new Base[] {this.frequencyOfOccurrence}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -650549981: // symptomConditionEffect
          this.symptomConditionEffect = TypeConvertor.castToCodeableReference(value); // CodeableReference
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
          this.symptomConditionEffect = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("classification")) {
          this.classification = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("frequencyOfOccurrence")) {
          this.frequencyOfOccurrence = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("symptomConditionEffect")) {
          this.symptomConditionEffect = null;
        } else if (name.equals("classification")) {
          this.classification = null;
        } else if (name.equals("frequencyOfOccurrence")) {
          this.frequencyOfOccurrence = null;
        } else
          super.removeChild(name, value);
        
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
        case -650549981: /*symptomConditionEffect*/ return new String[] {"CodeableReference"};
        case 382350310: /*classification*/ return new String[] {"CodeableConcept"};
        case 791175812: /*frequencyOfOccurrence*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("symptomConditionEffect")) {
          this.symptomConditionEffect = new CodeableReference();
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

      public ClinicalUseDefinitionUndesirableEffectComponent copy() {
        ClinicalUseDefinitionUndesirableEffectComponent dst = new ClinicalUseDefinitionUndesirableEffectComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseDefinitionUndesirableEffectComponent dst) {
        super.copyValues(dst);
        dst.symptomConditionEffect = symptomConditionEffect == null ? null : symptomConditionEffect.copy();
        dst.classification = classification == null ? null : classification.copy();
        dst.frequencyOfOccurrence = frequencyOfOccurrence == null ? null : frequencyOfOccurrence.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionUndesirableEffectComponent))
          return false;
        ClinicalUseDefinitionUndesirableEffectComponent o = (ClinicalUseDefinitionUndesirableEffectComponent) other_;
        return compareDeep(symptomConditionEffect, o.symptomConditionEffect, true) && compareDeep(classification, o.classification, true)
           && compareDeep(frequencyOfOccurrence, o.frequencyOfOccurrence, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionUndesirableEffectComponent))
          return false;
        ClinicalUseDefinitionUndesirableEffectComponent o = (ClinicalUseDefinitionUndesirableEffectComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(symptomConditionEffect, classification
          , frequencyOfOccurrence);
      }

  public String fhirType() {
    return "ClinicalUseDefinition.undesirableEffect";

  }

  }

    @Block()
    public static class ClinicalUseDefinitionWarningComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A textual definition of this warning, with formatting.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A textual definition of this warning, with formatting", formalDefinition="A textual definition of this warning, with formatting." )
        protected MarkdownType description;

        /**
         * A coded or unformatted textual definition of this warning.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A coded or unformatted textual definition of this warning", formalDefinition="A coded or unformatted textual definition of this warning." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/warning-type")
        protected CodeableConcept code;

        private static final long serialVersionUID = 213710553L;

    /**
     * Constructor
     */
      public ClinicalUseDefinitionWarningComponent() {
        super();
      }

        /**
         * @return {@link #description} (A textual definition of this warning, with formatting.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionWarningComponent.description");
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
         * @param value {@link #description} (A textual definition of this warning, with formatting.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ClinicalUseDefinitionWarningComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A textual definition of this warning, with formatting.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A textual definition of this warning, with formatting.
         */
        public ClinicalUseDefinitionWarningComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new MarkdownType();
            this.description.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #code} (A coded or unformatted textual definition of this warning.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalUseDefinitionWarningComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A coded or unformatted textual definition of this warning.)
         */
        public ClinicalUseDefinitionWarningComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "A textual definition of this warning, with formatting.", 0, 1, description));
          children.add(new Property("code", "CodeableConcept", "A coded or unformatted textual definition of this warning.", 0, 1, code));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "A textual definition of this warning, with formatting.", 0, 1, description);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A coded or unformatted textual definition of this warning.", 0, 1, code);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3059181:  return getCode();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ClinicalUseDefinition.warning.description");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else
          return super.addChild(name);
      }

      public ClinicalUseDefinitionWarningComponent copy() {
        ClinicalUseDefinitionWarningComponent dst = new ClinicalUseDefinitionWarningComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseDefinitionWarningComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.code = code == null ? null : code.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionWarningComponent))
          return false;
        ClinicalUseDefinitionWarningComponent o = (ClinicalUseDefinitionWarningComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(code, o.code, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinitionWarningComponent))
          return false;
        ClinicalUseDefinitionWarningComponent o = (ClinicalUseDefinitionWarningComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, code);
      }

  public String fhirType() {
    return "ClinicalUseDefinition.warning";

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
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-use-definition-type")
    protected Enumeration<ClinicalUseDefinitionType> type;

    /**
     * A categorisation of the issue, primarily for dividing warnings into subject heading areas such as "Pregnancy and Lactation", "Overdose", "Effects on Ability to Drive and Use Machines".
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A categorisation of the issue, primarily for dividing warnings into subject heading areas such as \"Pregnancy\", \"Overdose\"", formalDefinition="A categorisation of the issue, primarily for dividing warnings into subject heading areas such as \"Pregnancy and Lactation\", \"Overdose\", \"Effects on Ability to Drive and Use Machines\"." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-use-definition-category")
    protected List<CodeableConcept> category;

    /**
     * The medication, product, substance, device, procedure etc. for which this is an indication.
     */
    @Child(name = "subject", type = {MedicinalProductDefinition.class, Medication.class, ActivityDefinition.class, PlanDefinition.class, Device.class, DeviceDefinition.class, Substance.class, NutritionProduct.class, BiologicallyDerivedProduct.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The medication, product, substance, device, procedure etc. for which this is an indication", formalDefinition="The medication, product, substance, device, procedure etc. for which this is an indication." )
    protected List<Reference> subject;

    /**
     * Whether this is a current issue or one that has been retired etc.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Whether this is a current issue or one that has been retired etc", formalDefinition="Whether this is a current issue or one that has been retired etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected CodeableConcept status;

    /**
     * Specifics for when this is a contraindication.
     */
    @Child(name = "contraindication", type = {}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specifics for when this is a contraindication", formalDefinition="Specifics for when this is a contraindication." )
    protected ClinicalUseDefinitionContraindicationComponent contraindication;

    /**
     * Specifics for when this is an indication.
     */
    @Child(name = "indication", type = {}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specifics for when this is an indication", formalDefinition="Specifics for when this is an indication." )
    protected ClinicalUseDefinitionIndicationComponent indication;

    /**
     * Specifics for when this is an interaction.
     */
    @Child(name = "interaction", type = {}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specifics for when this is an interaction", formalDefinition="Specifics for when this is an interaction." )
    protected ClinicalUseDefinitionInteractionComponent interaction;

    /**
     * The population group to which this applies.
     */
    @Child(name = "population", type = {Group.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The population group to which this applies", formalDefinition="The population group to which this applies." )
    protected List<Reference> population;

    /**
     * Logic used by the clinical use definition.
     */
    @Child(name = "library", type = {CanonicalType.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Logic used by the clinical use definition", formalDefinition="Logic used by the clinical use definition." )
    protected List<CanonicalType> library;

    /**
     * Describe the possible undesirable effects (negative outcomes) from the use of the medicinal product as treatment.
     */
    @Child(name = "undesirableEffect", type = {}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A possible negative outcome from the use of this treatment", formalDefinition="Describe the possible undesirable effects (negative outcomes) from the use of the medicinal product as treatment." )
    protected ClinicalUseDefinitionUndesirableEffectComponent undesirableEffect;

    /**
     * A critical piece of information about environmental, health or physical risks or hazards that serve as caution to the user. For example 'Do not operate heavy machinery', 'May cause drowsiness', or 'Get medical advice/attention if you feel unwell'.
     */
    @Child(name = "warning", type = {}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Critical environmental, health or physical risks or hazards. For example 'Do not operate heavy machinery', 'May cause drowsiness'", formalDefinition="A critical piece of information about environmental, health or physical risks or hazards that serve as caution to the user. For example 'Do not operate heavy machinery', 'May cause drowsiness', or 'Get medical advice/attention if you feel unwell'." )
    protected ClinicalUseDefinitionWarningComponent warning;

    private static final long serialVersionUID = -539149948L;

  /**
   * Constructor
   */
    public ClinicalUseDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public ClinicalUseDefinition(ClinicalUseDefinitionType type) {
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
    public ClinicalUseDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public ClinicalUseDefinition addIdentifier(Identifier t) { //3
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
    public Enumeration<ClinicalUseDefinitionType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseDefinition.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<ClinicalUseDefinitionType>(new ClinicalUseDefinitionTypeEnumFactory()); // bb
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
    public ClinicalUseDefinition setTypeElement(Enumeration<ClinicalUseDefinitionType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return indication | contraindication | interaction | undesirable-effect | warning.
     */
    public ClinicalUseDefinitionType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value indication | contraindication | interaction | undesirable-effect | warning.
     */
    public ClinicalUseDefinition setType(ClinicalUseDefinitionType value) { 
        if (this.type == null)
          this.type = new Enumeration<ClinicalUseDefinitionType>(new ClinicalUseDefinitionTypeEnumFactory());
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (A categorisation of the issue, primarily for dividing warnings into subject heading areas such as "Pregnancy and Lactation", "Overdose", "Effects on Ability to Drive and Use Machines".)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalUseDefinition setCategory(List<CodeableConcept> theCategory) { 
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

    public ClinicalUseDefinition addCategory(CodeableConcept t) { //3
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
     * @return {@link #subject} (The medication, product, substance, device, procedure etc. for which this is an indication.)
     */
    public List<Reference> getSubject() { 
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      return this.subject;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalUseDefinition setSubject(List<Reference> theSubject) { 
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

    public ClinicalUseDefinition addSubject(Reference t) { //3
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
     * @return {@link #status} (Whether this is a current issue or one that has been retired etc.)
     */
    public CodeableConcept getStatus() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseDefinition.status");
        else if (Configuration.doAutoCreate())
          this.status = new CodeableConcept(); // cc
      return this.status;
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Whether this is a current issue or one that has been retired etc.)
     */
    public ClinicalUseDefinition setStatus(CodeableConcept value) { 
      this.status = value;
      return this;
    }

    /**
     * @return {@link #contraindication} (Specifics for when this is a contraindication.)
     */
    public ClinicalUseDefinitionContraindicationComponent getContraindication() { 
      if (this.contraindication == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseDefinition.contraindication");
        else if (Configuration.doAutoCreate())
          this.contraindication = new ClinicalUseDefinitionContraindicationComponent(); // cc
      return this.contraindication;
    }

    public boolean hasContraindication() { 
      return this.contraindication != null && !this.contraindication.isEmpty();
    }

    /**
     * @param value {@link #contraindication} (Specifics for when this is a contraindication.)
     */
    public ClinicalUseDefinition setContraindication(ClinicalUseDefinitionContraindicationComponent value) { 
      this.contraindication = value;
      return this;
    }

    /**
     * @return {@link #indication} (Specifics for when this is an indication.)
     */
    public ClinicalUseDefinitionIndicationComponent getIndication() { 
      if (this.indication == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseDefinition.indication");
        else if (Configuration.doAutoCreate())
          this.indication = new ClinicalUseDefinitionIndicationComponent(); // cc
      return this.indication;
    }

    public boolean hasIndication() { 
      return this.indication != null && !this.indication.isEmpty();
    }

    /**
     * @param value {@link #indication} (Specifics for when this is an indication.)
     */
    public ClinicalUseDefinition setIndication(ClinicalUseDefinitionIndicationComponent value) { 
      this.indication = value;
      return this;
    }

    /**
     * @return {@link #interaction} (Specifics for when this is an interaction.)
     */
    public ClinicalUseDefinitionInteractionComponent getInteraction() { 
      if (this.interaction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseDefinition.interaction");
        else if (Configuration.doAutoCreate())
          this.interaction = new ClinicalUseDefinitionInteractionComponent(); // cc
      return this.interaction;
    }

    public boolean hasInteraction() { 
      return this.interaction != null && !this.interaction.isEmpty();
    }

    /**
     * @param value {@link #interaction} (Specifics for when this is an interaction.)
     */
    public ClinicalUseDefinition setInteraction(ClinicalUseDefinitionInteractionComponent value) { 
      this.interaction = value;
      return this;
    }

    /**
     * @return {@link #population} (The population group to which this applies.)
     */
    public List<Reference> getPopulation() { 
      if (this.population == null)
        this.population = new ArrayList<Reference>();
      return this.population;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalUseDefinition setPopulation(List<Reference> thePopulation) { 
      this.population = thePopulation;
      return this;
    }

    public boolean hasPopulation() { 
      if (this.population == null)
        return false;
      for (Reference item : this.population)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPopulation() { //3
      Reference t = new Reference();
      if (this.population == null)
        this.population = new ArrayList<Reference>();
      this.population.add(t);
      return t;
    }

    public ClinicalUseDefinition addPopulation(Reference t) { //3
      if (t == null)
        return this;
      if (this.population == null)
        this.population = new ArrayList<Reference>();
      this.population.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #population}, creating it if it does not already exist {3}
     */
    public Reference getPopulationFirstRep() { 
      if (getPopulation().isEmpty()) {
        addPopulation();
      }
      return getPopulation().get(0);
    }

    /**
     * @return {@link #library} (Logic used by the clinical use definition.)
     */
    public List<CanonicalType> getLibrary() { 
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      return this.library;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalUseDefinition setLibrary(List<CanonicalType> theLibrary) { 
      this.library = theLibrary;
      return this;
    }

    public boolean hasLibrary() { 
      if (this.library == null)
        return false;
      for (CanonicalType item : this.library)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #library} (Logic used by the clinical use definition.)
     */
    public CanonicalType addLibraryElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      this.library.add(t);
      return t;
    }

    /**
     * @param value {@link #library} (Logic used by the clinical use definition.)
     */
    public ClinicalUseDefinition addLibrary(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      this.library.add(t);
      return this;
    }

    /**
     * @param value {@link #library} (Logic used by the clinical use definition.)
     */
    public boolean hasLibrary(String value) { 
      if (this.library == null)
        return false;
      for (CanonicalType v : this.library)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #undesirableEffect} (Describe the possible undesirable effects (negative outcomes) from the use of the medicinal product as treatment.)
     */
    public ClinicalUseDefinitionUndesirableEffectComponent getUndesirableEffect() { 
      if (this.undesirableEffect == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseDefinition.undesirableEffect");
        else if (Configuration.doAutoCreate())
          this.undesirableEffect = new ClinicalUseDefinitionUndesirableEffectComponent(); // cc
      return this.undesirableEffect;
    }

    public boolean hasUndesirableEffect() { 
      return this.undesirableEffect != null && !this.undesirableEffect.isEmpty();
    }

    /**
     * @param value {@link #undesirableEffect} (Describe the possible undesirable effects (negative outcomes) from the use of the medicinal product as treatment.)
     */
    public ClinicalUseDefinition setUndesirableEffect(ClinicalUseDefinitionUndesirableEffectComponent value) { 
      this.undesirableEffect = value;
      return this;
    }

    /**
     * @return {@link #warning} (A critical piece of information about environmental, health or physical risks or hazards that serve as caution to the user. For example 'Do not operate heavy machinery', 'May cause drowsiness', or 'Get medical advice/attention if you feel unwell'.)
     */
    public ClinicalUseDefinitionWarningComponent getWarning() { 
      if (this.warning == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalUseDefinition.warning");
        else if (Configuration.doAutoCreate())
          this.warning = new ClinicalUseDefinitionWarningComponent(); // cc
      return this.warning;
    }

    public boolean hasWarning() { 
      return this.warning != null && !this.warning.isEmpty();
    }

    /**
     * @param value {@link #warning} (A critical piece of information about environmental, health or physical risks or hazards that serve as caution to the user. For example 'Do not operate heavy machinery', 'May cause drowsiness', or 'Get medical advice/attention if you feel unwell'.)
     */
    public ClinicalUseDefinition setWarning(ClinicalUseDefinitionWarningComponent value) { 
      this.warning = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this issue.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("type", "code", "indication | contraindication | interaction | undesirable-effect | warning.", 0, 1, type));
        children.add(new Property("category", "CodeableConcept", "A categorisation of the issue, primarily for dividing warnings into subject heading areas such as \"Pregnancy and Lactation\", \"Overdose\", \"Effects on Ability to Drive and Use Machines\".", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("subject", "Reference(MedicinalProductDefinition|Medication|ActivityDefinition|PlanDefinition|Device|DeviceDefinition|Substance|NutritionProduct|BiologicallyDerivedProduct)", "The medication, product, substance, device, procedure etc. for which this is an indication.", 0, java.lang.Integer.MAX_VALUE, subject));
        children.add(new Property("status", "CodeableConcept", "Whether this is a current issue or one that has been retired etc.", 0, 1, status));
        children.add(new Property("contraindication", "", "Specifics for when this is a contraindication.", 0, 1, contraindication));
        children.add(new Property("indication", "", "Specifics for when this is an indication.", 0, 1, indication));
        children.add(new Property("interaction", "", "Specifics for when this is an interaction.", 0, 1, interaction));
        children.add(new Property("population", "Reference(Group)", "The population group to which this applies.", 0, java.lang.Integer.MAX_VALUE, population));
        children.add(new Property("library", "canonical(Library)", "Logic used by the clinical use definition.", 0, java.lang.Integer.MAX_VALUE, library));
        children.add(new Property("undesirableEffect", "", "Describe the possible undesirable effects (negative outcomes) from the use of the medicinal product as treatment.", 0, 1, undesirableEffect));
        children.add(new Property("warning", "", "A critical piece of information about environmental, health or physical risks or hazards that serve as caution to the user. For example 'Do not operate heavy machinery', 'May cause drowsiness', or 'Get medical advice/attention if you feel unwell'.", 0, 1, warning));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this issue.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3575610: /*type*/  return new Property("type", "code", "indication | contraindication | interaction | undesirable-effect | warning.", 0, 1, type);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A categorisation of the issue, primarily for dividing warnings into subject heading areas such as \"Pregnancy and Lactation\", \"Overdose\", \"Effects on Ability to Drive and Use Machines\".", 0, java.lang.Integer.MAX_VALUE, category);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(MedicinalProductDefinition|Medication|ActivityDefinition|PlanDefinition|Device|DeviceDefinition|Substance|NutritionProduct|BiologicallyDerivedProduct)", "The medication, product, substance, device, procedure etc. for which this is an indication.", 0, java.lang.Integer.MAX_VALUE, subject);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "Whether this is a current issue or one that has been retired etc.", 0, 1, status);
        case 107135229: /*contraindication*/  return new Property("contraindication", "", "Specifics for when this is a contraindication.", 0, 1, contraindication);
        case -597168804: /*indication*/  return new Property("indication", "", "Specifics for when this is an indication.", 0, 1, indication);
        case 1844104722: /*interaction*/  return new Property("interaction", "", "Specifics for when this is an interaction.", 0, 1, interaction);
        case -2023558323: /*population*/  return new Property("population", "Reference(Group)", "The population group to which this applies.", 0, java.lang.Integer.MAX_VALUE, population);
        case 166208699: /*library*/  return new Property("library", "canonical(Library)", "Logic used by the clinical use definition.", 0, java.lang.Integer.MAX_VALUE, library);
        case 444367565: /*undesirableEffect*/  return new Property("undesirableEffect", "", "Describe the possible undesirable effects (negative outcomes) from the use of the medicinal product as treatment.", 0, 1, undesirableEffect);
        case 1124446108: /*warning*/  return new Property("warning", "", "A critical piece of information about environmental, health or physical risks or hazards that serve as caution to the user. For example 'Do not operate heavy machinery', 'May cause drowsiness', or 'Get medical advice/attention if you feel unwell'.", 0, 1, warning);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ClinicalUseDefinitionType>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : this.subject.toArray(new Base[this.subject.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 107135229: /*contraindication*/ return this.contraindication == null ? new Base[0] : new Base[] {this.contraindication}; // ClinicalUseDefinitionContraindicationComponent
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : new Base[] {this.indication}; // ClinicalUseDefinitionIndicationComponent
        case 1844104722: /*interaction*/ return this.interaction == null ? new Base[0] : new Base[] {this.interaction}; // ClinicalUseDefinitionInteractionComponent
        case -2023558323: /*population*/ return this.population == null ? new Base[0] : this.population.toArray(new Base[this.population.size()]); // Reference
        case 166208699: /*library*/ return this.library == null ? new Base[0] : this.library.toArray(new Base[this.library.size()]); // CanonicalType
        case 444367565: /*undesirableEffect*/ return this.undesirableEffect == null ? new Base[0] : new Base[] {this.undesirableEffect}; // ClinicalUseDefinitionUndesirableEffectComponent
        case 1124446108: /*warning*/ return this.warning == null ? new Base[0] : new Base[] {this.warning}; // ClinicalUseDefinitionWarningComponent
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
          value = new ClinicalUseDefinitionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ClinicalUseDefinitionType>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.getSubject().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 107135229: // contraindication
          this.contraindication = (ClinicalUseDefinitionContraindicationComponent) value; // ClinicalUseDefinitionContraindicationComponent
          return value;
        case -597168804: // indication
          this.indication = (ClinicalUseDefinitionIndicationComponent) value; // ClinicalUseDefinitionIndicationComponent
          return value;
        case 1844104722: // interaction
          this.interaction = (ClinicalUseDefinitionInteractionComponent) value; // ClinicalUseDefinitionInteractionComponent
          return value;
        case -2023558323: // population
          this.getPopulation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 166208699: // library
          this.getLibrary().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 444367565: // undesirableEffect
          this.undesirableEffect = (ClinicalUseDefinitionUndesirableEffectComponent) value; // ClinicalUseDefinitionUndesirableEffectComponent
          return value;
        case 1124446108: // warning
          this.warning = (ClinicalUseDefinitionWarningComponent) value; // ClinicalUseDefinitionWarningComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("type")) {
          value = new ClinicalUseDefinitionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ClinicalUseDefinitionType>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("subject")) {
          this.getSubject().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("contraindication")) {
          this.contraindication = (ClinicalUseDefinitionContraindicationComponent) value; // ClinicalUseDefinitionContraindicationComponent
        } else if (name.equals("indication")) {
          this.indication = (ClinicalUseDefinitionIndicationComponent) value; // ClinicalUseDefinitionIndicationComponent
        } else if (name.equals("interaction")) {
          this.interaction = (ClinicalUseDefinitionInteractionComponent) value; // ClinicalUseDefinitionInteractionComponent
        } else if (name.equals("population")) {
          this.getPopulation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("library")) {
          this.getLibrary().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("undesirableEffect")) {
          this.undesirableEffect = (ClinicalUseDefinitionUndesirableEffectComponent) value; // ClinicalUseDefinitionUndesirableEffectComponent
        } else if (name.equals("warning")) {
          this.warning = (ClinicalUseDefinitionWarningComponent) value; // ClinicalUseDefinitionWarningComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("type")) {
          value = new ClinicalUseDefinitionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ClinicalUseDefinitionType>
        } else if (name.equals("category")) {
          this.getCategory().remove(value);
        } else if (name.equals("subject")) {
          this.getSubject().remove(value);
        } else if (name.equals("status")) {
          this.status = null;
        } else if (name.equals("contraindication")) {
          this.contraindication = (ClinicalUseDefinitionContraindicationComponent) value; // ClinicalUseDefinitionContraindicationComponent
        } else if (name.equals("indication")) {
          this.indication = (ClinicalUseDefinitionIndicationComponent) value; // ClinicalUseDefinitionIndicationComponent
        } else if (name.equals("interaction")) {
          this.interaction = (ClinicalUseDefinitionInteractionComponent) value; // ClinicalUseDefinitionInteractionComponent
        } else if (name.equals("population")) {
          this.getPopulation().remove(value);
        } else if (name.equals("library")) {
          this.getLibrary().remove(value);
        } else if (name.equals("undesirableEffect")) {
          this.undesirableEffect = (ClinicalUseDefinitionUndesirableEffectComponent) value; // ClinicalUseDefinitionUndesirableEffectComponent
        } else if (name.equals("warning")) {
          this.warning = (ClinicalUseDefinitionWarningComponent) value; // ClinicalUseDefinitionWarningComponent
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3575610:  return getTypeElement();
        case 50511102:  return addCategory(); 
        case -1867885268:  return addSubject(); 
        case -892481550:  return getStatus();
        case 107135229:  return getContraindication();
        case -597168804:  return getIndication();
        case 1844104722:  return getInteraction();
        case -2023558323:  return addPopulation(); 
        case 166208699:  return addLibraryElement();
        case 444367565:  return getUndesirableEffect();
        case 1124446108:  return getWarning();
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
        case 107135229: /*contraindication*/ return new String[] {};
        case -597168804: /*indication*/ return new String[] {};
        case 1844104722: /*interaction*/ return new String[] {};
        case -2023558323: /*population*/ return new String[] {"Reference"};
        case 166208699: /*library*/ return new String[] {"canonical"};
        case 444367565: /*undesirableEffect*/ return new String[] {};
        case 1124446108: /*warning*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property ClinicalUseDefinition.type");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("subject")) {
          return addSubject();
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("contraindication")) {
          this.contraindication = new ClinicalUseDefinitionContraindicationComponent();
          return this.contraindication;
        }
        else if (name.equals("indication")) {
          this.indication = new ClinicalUseDefinitionIndicationComponent();
          return this.indication;
        }
        else if (name.equals("interaction")) {
          this.interaction = new ClinicalUseDefinitionInteractionComponent();
          return this.interaction;
        }
        else if (name.equals("population")) {
          return addPopulation();
        }
        else if (name.equals("library")) {
          throw new FHIRException("Cannot call addChild on a singleton property ClinicalUseDefinition.library");
        }
        else if (name.equals("undesirableEffect")) {
          this.undesirableEffect = new ClinicalUseDefinitionUndesirableEffectComponent();
          return this.undesirableEffect;
        }
        else if (name.equals("warning")) {
          this.warning = new ClinicalUseDefinitionWarningComponent();
          return this.warning;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ClinicalUseDefinition";

  }

      public ClinicalUseDefinition copy() {
        ClinicalUseDefinition dst = new ClinicalUseDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalUseDefinition dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        if (subject != null) {
          dst.subject = new ArrayList<Reference>();
          for (Reference i : subject)
            dst.subject.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.contraindication = contraindication == null ? null : contraindication.copy();
        dst.indication = indication == null ? null : indication.copy();
        dst.interaction = interaction == null ? null : interaction.copy();
        if (population != null) {
          dst.population = new ArrayList<Reference>();
          for (Reference i : population)
            dst.population.add(i.copy());
        };
        if (library != null) {
          dst.library = new ArrayList<CanonicalType>();
          for (CanonicalType i : library)
            dst.library.add(i.copy());
        };
        dst.undesirableEffect = undesirableEffect == null ? null : undesirableEffect.copy();
        dst.warning = warning == null ? null : warning.copy();
      }

      protected ClinicalUseDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinition))
          return false;
        ClinicalUseDefinition o = (ClinicalUseDefinition) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(category, o.category, true)
           && compareDeep(subject, o.subject, true) && compareDeep(status, o.status, true) && compareDeep(contraindication, o.contraindication, true)
           && compareDeep(indication, o.indication, true) && compareDeep(interaction, o.interaction, true)
           && compareDeep(population, o.population, true) && compareDeep(library, o.library, true) && compareDeep(undesirableEffect, o.undesirableEffect, true)
           && compareDeep(warning, o.warning, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalUseDefinition))
          return false;
        ClinicalUseDefinition o = (ClinicalUseDefinition) other_;
        return compareValues(type, o.type, true) && compareValues(library, o.library, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, category
          , subject, status, contraindication, indication, interaction, population, library
          , undesirableEffect, warning);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ClinicalUseDefinition;
   }

 /**
   * Search parameter: <b>contraindication-reference</b>
   * <p>
   * Description: <b>The situation that is being documented as contraindicating against this item, as a reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contraindication-reference", path="ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.reference", description="The situation that is being documented as contraindicating against this item, as a reference", type="reference", target={ObservationDefinition.class } )
  public static final String SP_CONTRAINDICATION_REFERENCE = "contraindication-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contraindication-reference</b>
   * <p>
   * Description: <b>The situation that is being documented as contraindicating against this item, as a reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONTRAINDICATION_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CONTRAINDICATION_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalUseDefinition:contraindication-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONTRAINDICATION_REFERENCE = new ca.uhn.fhir.model.api.Include("ClinicalUseDefinition:contraindication-reference").toLocked();

 /**
   * Search parameter: <b>contraindication</b>
   * <p>
   * Description: <b>The situation that is being documented as contraindicating against this item, as a code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contraindication", path="ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.concept", description="The situation that is being documented as contraindicating against this item, as a code", type="token" )
  public static final String SP_CONTRAINDICATION = "contraindication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contraindication</b>
   * <p>
   * Description: <b>The situation that is being documented as contraindicating against this item, as a code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.contraindication.diseaseSymptomProcedure.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTRAINDICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTRAINDICATION);

 /**
   * Search parameter: <b>effect-reference</b>
   * <p>
   * Description: <b>The situation in which the undesirable effect may manifest, as a reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effect-reference", path="ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.reference", description="The situation in which the undesirable effect may manifest, as a reference", type="reference", target={ObservationDefinition.class } )
  public static final String SP_EFFECT_REFERENCE = "effect-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effect-reference</b>
   * <p>
   * Description: <b>The situation in which the undesirable effect may manifest, as a reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam EFFECT_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_EFFECT_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalUseDefinition:effect-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_EFFECT_REFERENCE = new ca.uhn.fhir.model.api.Include("ClinicalUseDefinition:effect-reference").toLocked();

 /**
   * Search parameter: <b>effect</b>
   * <p>
   * Description: <b>The situation in which the undesirable effect may manifest, as a code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effect", path="ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.concept", description="The situation in which the undesirable effect may manifest, as a code", type="token" )
  public static final String SP_EFFECT = "effect";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effect</b>
   * <p>
   * Description: <b>The situation in which the undesirable effect may manifest, as a code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.undesirableEffect.symptomConditionEffect.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EFFECT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EFFECT);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for this issue</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ClinicalUseDefinition.identifier", description="Business identifier for this issue", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for this issue</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>indication-reference</b>
   * <p>
   * Description: <b>The situation that is being documented as an indicaton for this item, as a reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.indication.diseaseSymptomProcedure.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="indication-reference", path="ClinicalUseDefinition.indication.diseaseSymptomProcedure.reference", description="The situation that is being documented as an indicaton for this item, as a reference", type="reference", target={ObservationDefinition.class } )
  public static final String SP_INDICATION_REFERENCE = "indication-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>indication-reference</b>
   * <p>
   * Description: <b>The situation that is being documented as an indicaton for this item, as a reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.indication.diseaseSymptomProcedure.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INDICATION_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INDICATION_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalUseDefinition:indication-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INDICATION_REFERENCE = new ca.uhn.fhir.model.api.Include("ClinicalUseDefinition:indication-reference").toLocked();

 /**
   * Search parameter: <b>indication</b>
   * <p>
   * Description: <b>The situation that is being documented as an indicaton for this item, as a code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.indication.diseaseSymptomProcedure.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="indication", path="ClinicalUseDefinition.indication.diseaseSymptomProcedure.concept", description="The situation that is being documented as an indicaton for this item, as a code", type="token" )
  public static final String SP_INDICATION = "indication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>indication</b>
   * <p>
   * Description: <b>The situation that is being documented as an indicaton for this item, as a code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.indication.diseaseSymptomProcedure.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INDICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INDICATION);

 /**
   * Search parameter: <b>interaction</b>
   * <p>
   * Description: <b>The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.interaction.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="interaction", path="ClinicalUseDefinition.interaction.type", description="The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction", type="token" )
  public static final String SP_INTERACTION = "interaction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>interaction</b>
   * <p>
   * Description: <b>The type of the interaction e.g. drug-drug interaction, drug-food interaction, drug-lab test interaction</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.interaction.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INTERACTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INTERACTION);

 /**
   * Search parameter: <b>product</b>
   * <p>
   * Description: <b>The medicinal product for which this is a clinical usage issue</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.subject.where(resolve() is MedicinalProductDefinition)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="product", path="ClinicalUseDefinition.subject.where(resolve() is MedicinalProductDefinition)", description="The medicinal product for which this is a clinical usage issue", type="reference", target={MedicinalProductDefinition.class } )
  public static final String SP_PRODUCT = "product";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>product</b>
   * <p>
   * Description: <b>The medicinal product for which this is a clinical usage issue</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.subject.where(resolve() is MedicinalProductDefinition)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRODUCT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRODUCT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalUseDefinition:product</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRODUCT = new ca.uhn.fhir.model.api.Include("ClinicalUseDefinition:product").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Whether this is a current issue or one that has been retired etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ClinicalUseDefinition.status", description="Whether this is a current issue or one that has been retired etc.", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Whether this is a current issue or one that has been retired etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The resource for which this is a clinical usage issue</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="ClinicalUseDefinition.subject", description="The resource for which this is a clinical usage issue", type="reference", target={ActivityDefinition.class, BiologicallyDerivedProduct.class, Device.class, DeviceDefinition.class, Medication.class, MedicinalProductDefinition.class, NutritionProduct.class, PlanDefinition.class, Substance.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The resource for which this is a clinical usage issue</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalUseDefinition.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalUseDefinition:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("ClinicalUseDefinition:subject").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>indication | contraindication | interaction | undesirable-effect | warning</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="ClinicalUseDefinition.type", description="indication | contraindication | interaction | undesirable-effect | warning", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>indication | contraindication | interaction | undesirable-effect | warning</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalUseDefinition.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

