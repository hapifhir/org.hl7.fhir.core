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
 * Representation of a molecular sequence.
 */
@ResourceDef(name="MolecularSequence", profile="http://hl7.org/fhir/StructureDefinition/MolecularSequence")
public class MolecularSequence extends DomainResource {

    public enum OrientationType {
        /**
         * Sense orientation of reference sequence.
         */
        SENSE, 
        /**
         * Antisense orientation of reference sequence.
         */
        ANTISENSE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static OrientationType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sense".equals(codeString))
          return SENSE;
        if ("antisense".equals(codeString))
          return ANTISENSE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown OrientationType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SENSE: return "sense";
            case ANTISENSE: return "antisense";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SENSE: return "http://hl7.org/fhir/orientation-type";
            case ANTISENSE: return "http://hl7.org/fhir/orientation-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SENSE: return "Sense orientation of reference sequence.";
            case ANTISENSE: return "Antisense orientation of reference sequence.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SENSE: return "Sense orientation of referenceSeq";
            case ANTISENSE: return "Antisense orientation of referenceSeq";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class OrientationTypeEnumFactory implements EnumFactory<OrientationType> {
    public OrientationType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sense".equals(codeString))
          return OrientationType.SENSE;
        if ("antisense".equals(codeString))
          return OrientationType.ANTISENSE;
        throw new IllegalArgumentException("Unknown OrientationType code '"+codeString+"'");
        }
        public Enumeration<OrientationType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<OrientationType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("sense".equals(codeString))
          return new Enumeration<OrientationType>(this, OrientationType.SENSE);
        if ("antisense".equals(codeString))
          return new Enumeration<OrientationType>(this, OrientationType.ANTISENSE);
        throw new FHIRException("Unknown OrientationType code '"+codeString+"'");
        }
    public String toCode(OrientationType code) {
      if (code == OrientationType.SENSE)
        return "sense";
      if (code == OrientationType.ANTISENSE)
        return "antisense";
      return "?";
      }
    public String toSystem(OrientationType code) {
      return code.getSystem();
      }
    }

    public enum SequenceType {
        /**
         * Amino acid sequence.
         */
        AA, 
        /**
         * DNA Sequence.
         */
        DNA, 
        /**
         * RNA Sequence.
         */
        RNA, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SequenceType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("aa".equals(codeString))
          return AA;
        if ("dna".equals(codeString))
          return DNA;
        if ("rna".equals(codeString))
          return RNA;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SequenceType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case AA: return "aa";
            case DNA: return "dna";
            case RNA: return "rna";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case AA: return "http://hl7.org/fhir/sequence-type";
            case DNA: return "http://hl7.org/fhir/sequence-type";
            case RNA: return "http://hl7.org/fhir/sequence-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case AA: return "Amino acid sequence.";
            case DNA: return "DNA Sequence.";
            case RNA: return "RNA Sequence.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case AA: return "AA Sequence";
            case DNA: return "DNA Sequence";
            case RNA: return "RNA Sequence";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SequenceTypeEnumFactory implements EnumFactory<SequenceType> {
    public SequenceType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("aa".equals(codeString))
          return SequenceType.AA;
        if ("dna".equals(codeString))
          return SequenceType.DNA;
        if ("rna".equals(codeString))
          return SequenceType.RNA;
        throw new IllegalArgumentException("Unknown SequenceType code '"+codeString+"'");
        }
        public Enumeration<SequenceType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SequenceType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("aa".equals(codeString))
          return new Enumeration<SequenceType>(this, SequenceType.AA);
        if ("dna".equals(codeString))
          return new Enumeration<SequenceType>(this, SequenceType.DNA);
        if ("rna".equals(codeString))
          return new Enumeration<SequenceType>(this, SequenceType.RNA);
        throw new FHIRException("Unknown SequenceType code '"+codeString+"'");
        }
    public String toCode(SequenceType code) {
      if (code == SequenceType.AA)
        return "aa";
      if (code == SequenceType.DNA)
        return "dna";
      if (code == SequenceType.RNA)
        return "rna";
      return "?";
      }
    public String toSystem(SequenceType code) {
      return code.getSystem();
      }
    }

    public enum StrandType {
        /**
         * Watson strand of starting sequence.
         */
        WATSON, 
        /**
         * Crick strand of starting sequence.
         */
        CRICK, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static StrandType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("watson".equals(codeString))
          return WATSON;
        if ("crick".equals(codeString))
          return CRICK;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown StrandType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case WATSON: return "watson";
            case CRICK: return "crick";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case WATSON: return "http://hl7.org/fhir/strand-type";
            case CRICK: return "http://hl7.org/fhir/strand-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case WATSON: return "Watson strand of starting sequence.";
            case CRICK: return "Crick strand of starting sequence.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case WATSON: return "Watson strand of starting sequence";
            case CRICK: return "Crick strand of starting sequence";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class StrandTypeEnumFactory implements EnumFactory<StrandType> {
    public StrandType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("watson".equals(codeString))
          return StrandType.WATSON;
        if ("crick".equals(codeString))
          return StrandType.CRICK;
        throw new IllegalArgumentException("Unknown StrandType code '"+codeString+"'");
        }
        public Enumeration<StrandType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<StrandType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("watson".equals(codeString))
          return new Enumeration<StrandType>(this, StrandType.WATSON);
        if ("crick".equals(codeString))
          return new Enumeration<StrandType>(this, StrandType.CRICK);
        throw new FHIRException("Unknown StrandType code '"+codeString+"'");
        }
    public String toCode(StrandType code) {
      if (code == StrandType.WATSON)
        return "watson";
      if (code == StrandType.CRICK)
        return "crick";
      return "?";
      }
    public String toSystem(StrandType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class MolecularSequenceRelativeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.
         */
        @Child(name = "coordinateSystem", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Ways of identifying nucleotides or amino acids within a sequence", formalDefinition="These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://loinc.org/LL5323-2/")
        protected CodeableConcept coordinateSystem;

        /**
         * Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.
         */
        @Child(name = "ordinalPosition", type = {IntegerType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together", formalDefinition="Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together." )
        protected IntegerType ordinalPosition;

        /**
         * Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.
         */
        @Child(name = "sequenceRange", type = {Range.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together", formalDefinition="Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together." )
        protected Range sequenceRange;

        /**
         * A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.
         */
        @Child(name = "startingSequence", type = {}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A sequence used as starting sequence", formalDefinition="A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed." )
        protected MolecularSequenceRelativeStartingSequenceComponent startingSequence;

        /**
         * Changes in sequence from the starting sequence.
         */
        @Child(name = "edit", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Changes in sequence from the starting sequence", formalDefinition="Changes in sequence from the starting sequence." )
        protected List<MolecularSequenceRelativeEditComponent> edit;

        private static final long serialVersionUID = -1455983973L;

    /**
     * Constructor
     */
      public MolecularSequenceRelativeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MolecularSequenceRelativeComponent(CodeableConcept coordinateSystem) {
        super();
        this.setCoordinateSystem(coordinateSystem);
      }

        /**
         * @return {@link #coordinateSystem} (These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.)
         */
        public CodeableConcept getCoordinateSystem() { 
          if (this.coordinateSystem == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeComponent.coordinateSystem");
            else if (Configuration.doAutoCreate())
              this.coordinateSystem = new CodeableConcept(); // cc
          return this.coordinateSystem;
        }

        public boolean hasCoordinateSystem() { 
          return this.coordinateSystem != null && !this.coordinateSystem.isEmpty();
        }

        /**
         * @param value {@link #coordinateSystem} (These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.)
         */
        public MolecularSequenceRelativeComponent setCoordinateSystem(CodeableConcept value) { 
          this.coordinateSystem = value;
          return this;
        }

        /**
         * @return {@link #ordinalPosition} (Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.). This is the underlying object with id, value and extensions. The accessor "getOrdinalPosition" gives direct access to the value
         */
        public IntegerType getOrdinalPositionElement() { 
          if (this.ordinalPosition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeComponent.ordinalPosition");
            else if (Configuration.doAutoCreate())
              this.ordinalPosition = new IntegerType(); // bb
          return this.ordinalPosition;
        }

        public boolean hasOrdinalPositionElement() { 
          return this.ordinalPosition != null && !this.ordinalPosition.isEmpty();
        }

        public boolean hasOrdinalPosition() { 
          return this.ordinalPosition != null && !this.ordinalPosition.isEmpty();
        }

        /**
         * @param value {@link #ordinalPosition} (Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.). This is the underlying object with id, value and extensions. The accessor "getOrdinalPosition" gives direct access to the value
         */
        public MolecularSequenceRelativeComponent setOrdinalPositionElement(IntegerType value) { 
          this.ordinalPosition = value;
          return this;
        }

        /**
         * @return Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.
         */
        public int getOrdinalPosition() { 
          return this.ordinalPosition == null || this.ordinalPosition.isEmpty() ? 0 : this.ordinalPosition.getValue();
        }

        /**
         * @param value Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.
         */
        public MolecularSequenceRelativeComponent setOrdinalPosition(int value) { 
            if (this.ordinalPosition == null)
              this.ordinalPosition = new IntegerType();
            this.ordinalPosition.setValue(value);
          return this;
        }

        /**
         * @return {@link #sequenceRange} (Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.)
         */
        public Range getSequenceRange() { 
          if (this.sequenceRange == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeComponent.sequenceRange");
            else if (Configuration.doAutoCreate())
              this.sequenceRange = new Range(); // cc
          return this.sequenceRange;
        }

        public boolean hasSequenceRange() { 
          return this.sequenceRange != null && !this.sequenceRange.isEmpty();
        }

        /**
         * @param value {@link #sequenceRange} (Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.)
         */
        public MolecularSequenceRelativeComponent setSequenceRange(Range value) { 
          this.sequenceRange = value;
          return this;
        }

        /**
         * @return {@link #startingSequence} (A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.)
         */
        public MolecularSequenceRelativeStartingSequenceComponent getStartingSequence() { 
          if (this.startingSequence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeComponent.startingSequence");
            else if (Configuration.doAutoCreate())
              this.startingSequence = new MolecularSequenceRelativeStartingSequenceComponent(); // cc
          return this.startingSequence;
        }

        public boolean hasStartingSequence() { 
          return this.startingSequence != null && !this.startingSequence.isEmpty();
        }

        /**
         * @param value {@link #startingSequence} (A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.)
         */
        public MolecularSequenceRelativeComponent setStartingSequence(MolecularSequenceRelativeStartingSequenceComponent value) { 
          this.startingSequence = value;
          return this;
        }

        /**
         * @return {@link #edit} (Changes in sequence from the starting sequence.)
         */
        public List<MolecularSequenceRelativeEditComponent> getEdit() { 
          if (this.edit == null)
            this.edit = new ArrayList<MolecularSequenceRelativeEditComponent>();
          return this.edit;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MolecularSequenceRelativeComponent setEdit(List<MolecularSequenceRelativeEditComponent> theEdit) { 
          this.edit = theEdit;
          return this;
        }

        public boolean hasEdit() { 
          if (this.edit == null)
            return false;
          for (MolecularSequenceRelativeEditComponent item : this.edit)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MolecularSequenceRelativeEditComponent addEdit() { //3
          MolecularSequenceRelativeEditComponent t = new MolecularSequenceRelativeEditComponent();
          if (this.edit == null)
            this.edit = new ArrayList<MolecularSequenceRelativeEditComponent>();
          this.edit.add(t);
          return t;
        }

        public MolecularSequenceRelativeComponent addEdit(MolecularSequenceRelativeEditComponent t) { //3
          if (t == null)
            return this;
          if (this.edit == null)
            this.edit = new ArrayList<MolecularSequenceRelativeEditComponent>();
          this.edit.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #edit}, creating it if it does not already exist {3}
         */
        public MolecularSequenceRelativeEditComponent getEditFirstRep() { 
          if (getEdit().isEmpty()) {
            addEdit();
          }
          return getEdit().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("coordinateSystem", "CodeableConcept", "These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.", 0, 1, coordinateSystem));
          children.add(new Property("ordinalPosition", "integer", "Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.", 0, 1, ordinalPosition));
          children.add(new Property("sequenceRange", "Range", "Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.", 0, 1, sequenceRange));
          children.add(new Property("startingSequence", "", "A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.", 0, 1, startingSequence));
          children.add(new Property("edit", "", "Changes in sequence from the starting sequence.", 0, java.lang.Integer.MAX_VALUE, edit));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 354212295: /*coordinateSystem*/  return new Property("coordinateSystem", "CodeableConcept", "These are different ways of identifying nucleotides or amino acids within a sequence. Different databases and file types may use different systems. For detail definitions, see https://loinc.org/92822-6/ for more detail.", 0, 1, coordinateSystem);
          case 626439866: /*ordinalPosition*/  return new Property("ordinalPosition", "integer", "Indicates the order in which the sequence should be considered when putting multiple 'relative' elements together.", 0, 1, ordinalPosition);
          case -733314564: /*sequenceRange*/  return new Property("sequenceRange", "Range", "Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are used together.", 0, 1, sequenceRange);
          case 1493400609: /*startingSequence*/  return new Property("startingSequence", "", "A sequence that is used as a starting sequence to describe variants that are present in a sequence analyzed.", 0, 1, startingSequence);
          case 3108362: /*edit*/  return new Property("edit", "", "Changes in sequence from the starting sequence.", 0, java.lang.Integer.MAX_VALUE, edit);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 354212295: /*coordinateSystem*/ return this.coordinateSystem == null ? new Base[0] : new Base[] {this.coordinateSystem}; // CodeableConcept
        case 626439866: /*ordinalPosition*/ return this.ordinalPosition == null ? new Base[0] : new Base[] {this.ordinalPosition}; // IntegerType
        case -733314564: /*sequenceRange*/ return this.sequenceRange == null ? new Base[0] : new Base[] {this.sequenceRange}; // Range
        case 1493400609: /*startingSequence*/ return this.startingSequence == null ? new Base[0] : new Base[] {this.startingSequence}; // MolecularSequenceRelativeStartingSequenceComponent
        case 3108362: /*edit*/ return this.edit == null ? new Base[0] : this.edit.toArray(new Base[this.edit.size()]); // MolecularSequenceRelativeEditComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 354212295: // coordinateSystem
          this.coordinateSystem = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 626439866: // ordinalPosition
          this.ordinalPosition = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -733314564: // sequenceRange
          this.sequenceRange = TypeConvertor.castToRange(value); // Range
          return value;
        case 1493400609: // startingSequence
          this.startingSequence = (MolecularSequenceRelativeStartingSequenceComponent) value; // MolecularSequenceRelativeStartingSequenceComponent
          return value;
        case 3108362: // edit
          this.getEdit().add((MolecularSequenceRelativeEditComponent) value); // MolecularSequenceRelativeEditComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("coordinateSystem")) {
          this.coordinateSystem = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("ordinalPosition")) {
          this.ordinalPosition = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("sequenceRange")) {
          this.sequenceRange = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("startingSequence")) {
          this.startingSequence = (MolecularSequenceRelativeStartingSequenceComponent) value; // MolecularSequenceRelativeStartingSequenceComponent
        } else if (name.equals("edit")) {
          this.getEdit().add((MolecularSequenceRelativeEditComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 354212295:  return getCoordinateSystem();
        case 626439866:  return getOrdinalPositionElement();
        case -733314564:  return getSequenceRange();
        case 1493400609:  return getStartingSequence();
        case 3108362:  return addEdit(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 354212295: /*coordinateSystem*/ return new String[] {"CodeableConcept"};
        case 626439866: /*ordinalPosition*/ return new String[] {"integer"};
        case -733314564: /*sequenceRange*/ return new String[] {"Range"};
        case 1493400609: /*startingSequence*/ return new String[] {};
        case 3108362: /*edit*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("coordinateSystem")) {
          this.coordinateSystem = new CodeableConcept();
          return this.coordinateSystem;
        }
        else if (name.equals("ordinalPosition")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.ordinalPosition");
        }
        else if (name.equals("sequenceRange")) {
          this.sequenceRange = new Range();
          return this.sequenceRange;
        }
        else if (name.equals("startingSequence")) {
          this.startingSequence = new MolecularSequenceRelativeStartingSequenceComponent();
          return this.startingSequence;
        }
        else if (name.equals("edit")) {
          return addEdit();
        }
        else
          return super.addChild(name);
      }

      public MolecularSequenceRelativeComponent copy() {
        MolecularSequenceRelativeComponent dst = new MolecularSequenceRelativeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MolecularSequenceRelativeComponent dst) {
        super.copyValues(dst);
        dst.coordinateSystem = coordinateSystem == null ? null : coordinateSystem.copy();
        dst.ordinalPosition = ordinalPosition == null ? null : ordinalPosition.copy();
        dst.sequenceRange = sequenceRange == null ? null : sequenceRange.copy();
        dst.startingSequence = startingSequence == null ? null : startingSequence.copy();
        if (edit != null) {
          dst.edit = new ArrayList<MolecularSequenceRelativeEditComponent>();
          for (MolecularSequenceRelativeEditComponent i : edit)
            dst.edit.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeComponent))
          return false;
        MolecularSequenceRelativeComponent o = (MolecularSequenceRelativeComponent) other_;
        return compareDeep(coordinateSystem, o.coordinateSystem, true) && compareDeep(ordinalPosition, o.ordinalPosition, true)
           && compareDeep(sequenceRange, o.sequenceRange, true) && compareDeep(startingSequence, o.startingSequence, true)
           && compareDeep(edit, o.edit, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeComponent))
          return false;
        MolecularSequenceRelativeComponent o = (MolecularSequenceRelativeComponent) other_;
        return compareValues(ordinalPosition, o.ordinalPosition, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(coordinateSystem, ordinalPosition
          , sequenceRange, startingSequence, edit);
      }

  public String fhirType() {
    return "MolecularSequence.relative";

  }

  }

    @Block()
    public static class MolecularSequenceRelativeStartingSequenceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The genome assembly used for starting sequence, e.g. GRCh38.
         */
        @Child(name = "genomeAssembly", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The genome assembly used for starting sequence, e.g. GRCh38", formalDefinition="The genome assembly used for starting sequence, e.g. GRCh38." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://loinc.org/LL1040-6/")
        protected CodeableConcept genomeAssembly;

        /**
         * Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).
         */
        @Child(name = "chromosome", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Chromosome Identifier", formalDefinition="Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340))." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://loinc.org/LL2938-0/")
        protected CodeableConcept chromosome;

        /**
         * The reference sequence that represents the starting sequence.
         */
        @Child(name = "sequence", type = {CodeableConcept.class, StringType.class, MolecularSequence.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The reference sequence that represents the starting sequence", formalDefinition="The reference sequence that represents the starting sequence." )
        protected DataType sequence;

        /**
         * Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.
         */
        @Child(name = "windowStart", type = {IntegerType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Start position of the window on the starting sequence", formalDefinition="Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem." )
        protected IntegerType windowStart;

        /**
         * End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.
         */
        @Child(name = "windowEnd", type = {IntegerType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="End position of the window on the starting sequence", formalDefinition="End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem." )
        protected IntegerType windowEnd;

        /**
         * A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.
         */
        @Child(name = "orientation", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="sense | antisense", formalDefinition="A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the \"sense\" strand, and the opposite complementary strand is the \"antisense\" strand." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/orientation-type")
        protected Enumeration<OrientationType> orientation;

        /**
         * An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.
         */
        @Child(name = "strand", type = {CodeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="watson | crick", formalDefinition="An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/strand-type")
        protected Enumeration<StrandType> strand;

        private static final long serialVersionUID = 502438613L;

    /**
     * Constructor
     */
      public MolecularSequenceRelativeStartingSequenceComponent() {
        super();
      }

        /**
         * @return {@link #genomeAssembly} (The genome assembly used for starting sequence, e.g. GRCh38.)
         */
        public CodeableConcept getGenomeAssembly() { 
          if (this.genomeAssembly == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.genomeAssembly");
            else if (Configuration.doAutoCreate())
              this.genomeAssembly = new CodeableConcept(); // cc
          return this.genomeAssembly;
        }

        public boolean hasGenomeAssembly() { 
          return this.genomeAssembly != null && !this.genomeAssembly.isEmpty();
        }

        /**
         * @param value {@link #genomeAssembly} (The genome assembly used for starting sequence, e.g. GRCh38.)
         */
        public MolecularSequenceRelativeStartingSequenceComponent setGenomeAssembly(CodeableConcept value) { 
          this.genomeAssembly = value;
          return this;
        }

        /**
         * @return {@link #chromosome} (Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).)
         */
        public CodeableConcept getChromosome() { 
          if (this.chromosome == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.chromosome");
            else if (Configuration.doAutoCreate())
              this.chromosome = new CodeableConcept(); // cc
          return this.chromosome;
        }

        public boolean hasChromosome() { 
          return this.chromosome != null && !this.chromosome.isEmpty();
        }

        /**
         * @param value {@link #chromosome} (Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).)
         */
        public MolecularSequenceRelativeStartingSequenceComponent setChromosome(CodeableConcept value) { 
          this.chromosome = value;
          return this;
        }

        /**
         * @return {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public DataType getSequence() { 
          return this.sequence;
        }

        /**
         * @return {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public CodeableConcept getSequenceCodeableConcept() throws FHIRException { 
          if (this.sequence == null)
            this.sequence = new CodeableConcept();
          if (!(this.sequence instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.sequence.getClass().getName()+" was encountered");
          return (CodeableConcept) this.sequence;
        }

        public boolean hasSequenceCodeableConcept() { 
          return this != null && this.sequence instanceof CodeableConcept;
        }

        /**
         * @return {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public StringType getSequenceStringType() throws FHIRException { 
          if (this.sequence == null)
            this.sequence = new StringType();
          if (!(this.sequence instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.sequence.getClass().getName()+" was encountered");
          return (StringType) this.sequence;
        }

        public boolean hasSequenceStringType() { 
          return this != null && this.sequence instanceof StringType;
        }

        /**
         * @return {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public Reference getSequenceReference() throws FHIRException { 
          if (this.sequence == null)
            this.sequence = new Reference();
          if (!(this.sequence instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.sequence.getClass().getName()+" was encountered");
          return (Reference) this.sequence;
        }

        public boolean hasSequenceReference() { 
          return this != null && this.sequence instanceof Reference;
        }

        public boolean hasSequence() { 
          return this.sequence != null && !this.sequence.isEmpty();
        }

        /**
         * @param value {@link #sequence} (The reference sequence that represents the starting sequence.)
         */
        public MolecularSequenceRelativeStartingSequenceComponent setSequence(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof StringType || value instanceof Reference))
            throw new Error("Not the right type for MolecularSequence.relative.startingSequence.sequence[x]: "+value.fhirType());
          this.sequence = value;
          return this;
        }

        /**
         * @return {@link #windowStart} (Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.). This is the underlying object with id, value and extensions. The accessor "getWindowStart" gives direct access to the value
         */
        public IntegerType getWindowStartElement() { 
          if (this.windowStart == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.windowStart");
            else if (Configuration.doAutoCreate())
              this.windowStart = new IntegerType(); // bb
          return this.windowStart;
        }

        public boolean hasWindowStartElement() { 
          return this.windowStart != null && !this.windowStart.isEmpty();
        }

        public boolean hasWindowStart() { 
          return this.windowStart != null && !this.windowStart.isEmpty();
        }

        /**
         * @param value {@link #windowStart} (Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.). This is the underlying object with id, value and extensions. The accessor "getWindowStart" gives direct access to the value
         */
        public MolecularSequenceRelativeStartingSequenceComponent setWindowStartElement(IntegerType value) { 
          this.windowStart = value;
          return this;
        }

        /**
         * @return Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.
         */
        public int getWindowStart() { 
          return this.windowStart == null || this.windowStart.isEmpty() ? 0 : this.windowStart.getValue();
        }

        /**
         * @param value Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.
         */
        public MolecularSequenceRelativeStartingSequenceComponent setWindowStart(int value) { 
            if (this.windowStart == null)
              this.windowStart = new IntegerType();
            this.windowStart.setValue(value);
          return this;
        }

        /**
         * @return {@link #windowEnd} (End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.). This is the underlying object with id, value and extensions. The accessor "getWindowEnd" gives direct access to the value
         */
        public IntegerType getWindowEndElement() { 
          if (this.windowEnd == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.windowEnd");
            else if (Configuration.doAutoCreate())
              this.windowEnd = new IntegerType(); // bb
          return this.windowEnd;
        }

        public boolean hasWindowEndElement() { 
          return this.windowEnd != null && !this.windowEnd.isEmpty();
        }

        public boolean hasWindowEnd() { 
          return this.windowEnd != null && !this.windowEnd.isEmpty();
        }

        /**
         * @param value {@link #windowEnd} (End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.). This is the underlying object with id, value and extensions. The accessor "getWindowEnd" gives direct access to the value
         */
        public MolecularSequenceRelativeStartingSequenceComponent setWindowEndElement(IntegerType value) { 
          this.windowEnd = value;
          return this;
        }

        /**
         * @return End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.
         */
        public int getWindowEnd() { 
          return this.windowEnd == null || this.windowEnd.isEmpty() ? 0 : this.windowEnd.getValue();
        }

        /**
         * @param value End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.
         */
        public MolecularSequenceRelativeStartingSequenceComponent setWindowEnd(int value) { 
            if (this.windowEnd == null)
              this.windowEnd = new IntegerType();
            this.windowEnd.setValue(value);
          return this;
        }

        /**
         * @return {@link #orientation} (A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.). This is the underlying object with id, value and extensions. The accessor "getOrientation" gives direct access to the value
         */
        public Enumeration<OrientationType> getOrientationElement() { 
          if (this.orientation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.orientation");
            else if (Configuration.doAutoCreate())
              this.orientation = new Enumeration<OrientationType>(new OrientationTypeEnumFactory()); // bb
          return this.orientation;
        }

        public boolean hasOrientationElement() { 
          return this.orientation != null && !this.orientation.isEmpty();
        }

        public boolean hasOrientation() { 
          return this.orientation != null && !this.orientation.isEmpty();
        }

        /**
         * @param value {@link #orientation} (A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.). This is the underlying object with id, value and extensions. The accessor "getOrientation" gives direct access to the value
         */
        public MolecularSequenceRelativeStartingSequenceComponent setOrientationElement(Enumeration<OrientationType> value) { 
          this.orientation = value;
          return this;
        }

        /**
         * @return A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.
         */
        public OrientationType getOrientation() { 
          return this.orientation == null ? null : this.orientation.getValue();
        }

        /**
         * @param value A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the "sense" strand, and the opposite complementary strand is the "antisense" strand.
         */
        public MolecularSequenceRelativeStartingSequenceComponent setOrientation(OrientationType value) { 
          if (value == null)
            this.orientation = null;
          else {
            if (this.orientation == null)
              this.orientation = new Enumeration<OrientationType>(new OrientationTypeEnumFactory());
            this.orientation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #strand} (An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.). This is the underlying object with id, value and extensions. The accessor "getStrand" gives direct access to the value
         */
        public Enumeration<StrandType> getStrandElement() { 
          if (this.strand == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeStartingSequenceComponent.strand");
            else if (Configuration.doAutoCreate())
              this.strand = new Enumeration<StrandType>(new StrandTypeEnumFactory()); // bb
          return this.strand;
        }

        public boolean hasStrandElement() { 
          return this.strand != null && !this.strand.isEmpty();
        }

        public boolean hasStrand() { 
          return this.strand != null && !this.strand.isEmpty();
        }

        /**
         * @param value {@link #strand} (An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.). This is the underlying object with id, value and extensions. The accessor "getStrand" gives direct access to the value
         */
        public MolecularSequenceRelativeStartingSequenceComponent setStrandElement(Enumeration<StrandType> value) { 
          this.strand = value;
          return this;
        }

        /**
         * @return An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.
         */
        public StrandType getStrand() { 
          return this.strand == null ? null : this.strand.getValue();
        }

        /**
         * @param value An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.
         */
        public MolecularSequenceRelativeStartingSequenceComponent setStrand(StrandType value) { 
          if (value == null)
            this.strand = null;
          else {
            if (this.strand == null)
              this.strand = new Enumeration<StrandType>(new StrandTypeEnumFactory());
            this.strand.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("genomeAssembly", "CodeableConcept", "The genome assembly used for starting sequence, e.g. GRCh38.", 0, 1, genomeAssembly));
          children.add(new Property("chromosome", "CodeableConcept", "Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).", 0, 1, chromosome));
          children.add(new Property("sequence[x]", "CodeableConcept|string|Reference(MolecularSequence)", "The reference sequence that represents the starting sequence.", 0, 1, sequence));
          children.add(new Property("windowStart", "integer", "Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.", 0, 1, windowStart));
          children.add(new Property("windowEnd", "integer", "End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.", 0, 1, windowEnd));
          children.add(new Property("orientation", "code", "A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the \"sense\" strand, and the opposite complementary strand is the \"antisense\" strand.", 0, 1, orientation));
          children.add(new Property("strand", "code", "An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.", 0, 1, strand));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1196021757: /*genomeAssembly*/  return new Property("genomeAssembly", "CodeableConcept", "The genome assembly used for starting sequence, e.g. GRCh38.", 0, 1, genomeAssembly);
          case -1499470472: /*chromosome*/  return new Property("chromosome", "CodeableConcept", "Structural unit composed of a nucleic acid molecule which controls its own replication through the interaction of specific proteins at one or more origins of replication ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).", 0, 1, chromosome);
          case -805222113: /*sequence[x]*/  return new Property("sequence[x]", "CodeableConcept|string|Reference(MolecularSequence)", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case 1349547969: /*sequence*/  return new Property("sequence[x]", "CodeableConcept|string|Reference(MolecularSequence)", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case 1508480416: /*sequenceCodeableConcept*/  return new Property("sequence[x]", "CodeableConcept", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case -1211617486: /*sequenceString*/  return new Property("sequence[x]", "string", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case -1127149430: /*sequenceReference*/  return new Property("sequence[x]", "Reference(MolecularSequence)", "The reference sequence that represents the starting sequence.", 0, 1, sequence);
          case 1903685202: /*windowStart*/  return new Property("windowStart", "integer", "Start position of the window on the starting sequence. This value should honor the rules of the coordinateSystem.", 0, 1, windowStart);
          case -217026869: /*windowEnd*/  return new Property("windowEnd", "integer", "End position of the window on the starting sequence. This value should honor the rules of the  coordinateSystem.", 0, 1, windowEnd);
          case -1439500848: /*orientation*/  return new Property("orientation", "code", "A relative reference to a DNA strand based on gene orientation. The strand that contains the open reading frame of the gene is the \"sense\" strand, and the opposite complementary strand is the \"antisense\" strand.", 0, 1, orientation);
          case -891993594: /*strand*/  return new Property("strand", "code", "An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long arm.", 0, 1, strand);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1196021757: /*genomeAssembly*/ return this.genomeAssembly == null ? new Base[0] : new Base[] {this.genomeAssembly}; // CodeableConcept
        case -1499470472: /*chromosome*/ return this.chromosome == null ? new Base[0] : new Base[] {this.chromosome}; // CodeableConcept
        case 1349547969: /*sequence*/ return this.sequence == null ? new Base[0] : new Base[] {this.sequence}; // DataType
        case 1903685202: /*windowStart*/ return this.windowStart == null ? new Base[0] : new Base[] {this.windowStart}; // IntegerType
        case -217026869: /*windowEnd*/ return this.windowEnd == null ? new Base[0] : new Base[] {this.windowEnd}; // IntegerType
        case -1439500848: /*orientation*/ return this.orientation == null ? new Base[0] : new Base[] {this.orientation}; // Enumeration<OrientationType>
        case -891993594: /*strand*/ return this.strand == null ? new Base[0] : new Base[] {this.strand}; // Enumeration<StrandType>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1196021757: // genomeAssembly
          this.genomeAssembly = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1499470472: // chromosome
          this.chromosome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1349547969: // sequence
          this.sequence = TypeConvertor.castToType(value); // DataType
          return value;
        case 1903685202: // windowStart
          this.windowStart = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -217026869: // windowEnd
          this.windowEnd = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -1439500848: // orientation
          value = new OrientationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.orientation = (Enumeration) value; // Enumeration<OrientationType>
          return value;
        case -891993594: // strand
          value = new StrandTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strand = (Enumeration) value; // Enumeration<StrandType>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("genomeAssembly")) {
          this.genomeAssembly = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("chromosome")) {
          this.chromosome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("sequence[x]")) {
          this.sequence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("windowStart")) {
          this.windowStart = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("windowEnd")) {
          this.windowEnd = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("orientation")) {
          value = new OrientationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.orientation = (Enumeration) value; // Enumeration<OrientationType>
        } else if (name.equals("strand")) {
          value = new StrandTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strand = (Enumeration) value; // Enumeration<StrandType>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1196021757:  return getGenomeAssembly();
        case -1499470472:  return getChromosome();
        case -805222113:  return getSequence();
        case 1349547969:  return getSequence();
        case 1903685202:  return getWindowStartElement();
        case -217026869:  return getWindowEndElement();
        case -1439500848:  return getOrientationElement();
        case -891993594:  return getStrandElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1196021757: /*genomeAssembly*/ return new String[] {"CodeableConcept"};
        case -1499470472: /*chromosome*/ return new String[] {"CodeableConcept"};
        case 1349547969: /*sequence*/ return new String[] {"CodeableConcept", "string", "Reference"};
        case 1903685202: /*windowStart*/ return new String[] {"integer"};
        case -217026869: /*windowEnd*/ return new String[] {"integer"};
        case -1439500848: /*orientation*/ return new String[] {"code"};
        case -891993594: /*strand*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("genomeAssembly")) {
          this.genomeAssembly = new CodeableConcept();
          return this.genomeAssembly;
        }
        else if (name.equals("chromosome")) {
          this.chromosome = new CodeableConcept();
          return this.chromosome;
        }
        else if (name.equals("sequenceCodeableConcept")) {
          this.sequence = new CodeableConcept();
          return this.sequence;
        }
        else if (name.equals("sequenceString")) {
          this.sequence = new StringType();
          return this.sequence;
        }
        else if (name.equals("sequenceReference")) {
          this.sequence = new Reference();
          return this.sequence;
        }
        else if (name.equals("windowStart")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.startingSequence.windowStart");
        }
        else if (name.equals("windowEnd")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.startingSequence.windowEnd");
        }
        else if (name.equals("orientation")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.startingSequence.orientation");
        }
        else if (name.equals("strand")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.startingSequence.strand");
        }
        else
          return super.addChild(name);
      }

      public MolecularSequenceRelativeStartingSequenceComponent copy() {
        MolecularSequenceRelativeStartingSequenceComponent dst = new MolecularSequenceRelativeStartingSequenceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MolecularSequenceRelativeStartingSequenceComponent dst) {
        super.copyValues(dst);
        dst.genomeAssembly = genomeAssembly == null ? null : genomeAssembly.copy();
        dst.chromosome = chromosome == null ? null : chromosome.copy();
        dst.sequence = sequence == null ? null : sequence.copy();
        dst.windowStart = windowStart == null ? null : windowStart.copy();
        dst.windowEnd = windowEnd == null ? null : windowEnd.copy();
        dst.orientation = orientation == null ? null : orientation.copy();
        dst.strand = strand == null ? null : strand.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeStartingSequenceComponent))
          return false;
        MolecularSequenceRelativeStartingSequenceComponent o = (MolecularSequenceRelativeStartingSequenceComponent) other_;
        return compareDeep(genomeAssembly, o.genomeAssembly, true) && compareDeep(chromosome, o.chromosome, true)
           && compareDeep(sequence, o.sequence, true) && compareDeep(windowStart, o.windowStart, true) && compareDeep(windowEnd, o.windowEnd, true)
           && compareDeep(orientation, o.orientation, true) && compareDeep(strand, o.strand, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeStartingSequenceComponent))
          return false;
        MolecularSequenceRelativeStartingSequenceComponent o = (MolecularSequenceRelativeStartingSequenceComponent) other_;
        return compareValues(windowStart, o.windowStart, true) && compareValues(windowEnd, o.windowEnd, true)
           && compareValues(orientation, o.orientation, true) && compareValues(strand, o.strand, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(genomeAssembly, chromosome
          , sequence, windowStart, windowEnd, orientation, strand);
      }

  public String fhirType() {
    return "MolecularSequence.relative.startingSequence";

  }

  }

    @Block()
    public static class MolecularSequenceRelativeEditComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.
         */
        @Child(name = "start", type = {IntegerType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Start position of the edit on the starting sequence", formalDefinition="Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive." )
        protected IntegerType start;

        /**
         * End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.
         */
        @Child(name = "end", type = {IntegerType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="End position of the edit on the starting sequence", formalDefinition="End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position." )
        protected IntegerType end;

        /**
         * Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        @Child(name = "replacementSequence", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Allele that was observed", formalDefinition="Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end." )
        protected StringType replacementSequence;

        /**
         * Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        @Child(name = "replacedSequence", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Allele in the starting sequence", formalDefinition="Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end." )
        protected StringType replacedSequence;

        private static final long serialVersionUID = 550127909L;

    /**
     * Constructor
     */
      public MolecularSequenceRelativeEditComponent() {
        super();
      }

        /**
         * @return {@link #start} (Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
         */
        public IntegerType getStartElement() { 
          if (this.start == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeEditComponent.start");
            else if (Configuration.doAutoCreate())
              this.start = new IntegerType(); // bb
          return this.start;
        }

        public boolean hasStartElement() { 
          return this.start != null && !this.start.isEmpty();
        }

        public boolean hasStart() { 
          return this.start != null && !this.start.isEmpty();
        }

        /**
         * @param value {@link #start} (Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
         */
        public MolecularSequenceRelativeEditComponent setStartElement(IntegerType value) { 
          this.start = value;
          return this;
        }

        /**
         * @return Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.
         */
        public int getStart() { 
          return this.start == null || this.start.isEmpty() ? 0 : this.start.getValue();
        }

        /**
         * @param value Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.
         */
        public MolecularSequenceRelativeEditComponent setStart(int value) { 
            if (this.start == null)
              this.start = new IntegerType();
            this.start.setValue(value);
          return this;
        }

        /**
         * @return {@link #end} (End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
         */
        public IntegerType getEndElement() { 
          if (this.end == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeEditComponent.end");
            else if (Configuration.doAutoCreate())
              this.end = new IntegerType(); // bb
          return this.end;
        }

        public boolean hasEndElement() { 
          return this.end != null && !this.end.isEmpty();
        }

        public boolean hasEnd() { 
          return this.end != null && !this.end.isEmpty();
        }

        /**
         * @param value {@link #end} (End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
         */
        public MolecularSequenceRelativeEditComponent setEndElement(IntegerType value) { 
          this.end = value;
          return this;
        }

        /**
         * @return End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.
         */
        public int getEnd() { 
          return this.end == null || this.end.isEmpty() ? 0 : this.end.getValue();
        }

        /**
         * @param value End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.
         */
        public MolecularSequenceRelativeEditComponent setEnd(int value) { 
            if (this.end == null)
              this.end = new IntegerType();
            this.end.setValue(value);
          return this;
        }

        /**
         * @return {@link #replacementSequence} (Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.). This is the underlying object with id, value and extensions. The accessor "getReplacementSequence" gives direct access to the value
         */
        public StringType getReplacementSequenceElement() { 
          if (this.replacementSequence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeEditComponent.replacementSequence");
            else if (Configuration.doAutoCreate())
              this.replacementSequence = new StringType(); // bb
          return this.replacementSequence;
        }

        public boolean hasReplacementSequenceElement() { 
          return this.replacementSequence != null && !this.replacementSequence.isEmpty();
        }

        public boolean hasReplacementSequence() { 
          return this.replacementSequence != null && !this.replacementSequence.isEmpty();
        }

        /**
         * @param value {@link #replacementSequence} (Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.). This is the underlying object with id, value and extensions. The accessor "getReplacementSequence" gives direct access to the value
         */
        public MolecularSequenceRelativeEditComponent setReplacementSequenceElement(StringType value) { 
          this.replacementSequence = value;
          return this;
        }

        /**
         * @return Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        public String getReplacementSequence() { 
          return this.replacementSequence == null ? null : this.replacementSequence.getValue();
        }

        /**
         * @param value Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        public MolecularSequenceRelativeEditComponent setReplacementSequence(String value) { 
          if (Utilities.noString(value))
            this.replacementSequence = null;
          else {
            if (this.replacementSequence == null)
              this.replacementSequence = new StringType();
            this.replacementSequence.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #replacedSequence} (Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.). This is the underlying object with id, value and extensions. The accessor "getReplacedSequence" gives direct access to the value
         */
        public StringType getReplacedSequenceElement() { 
          if (this.replacedSequence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MolecularSequenceRelativeEditComponent.replacedSequence");
            else if (Configuration.doAutoCreate())
              this.replacedSequence = new StringType(); // bb
          return this.replacedSequence;
        }

        public boolean hasReplacedSequenceElement() { 
          return this.replacedSequence != null && !this.replacedSequence.isEmpty();
        }

        public boolean hasReplacedSequence() { 
          return this.replacedSequence != null && !this.replacedSequence.isEmpty();
        }

        /**
         * @param value {@link #replacedSequence} (Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.). This is the underlying object with id, value and extensions. The accessor "getReplacedSequence" gives direct access to the value
         */
        public MolecularSequenceRelativeEditComponent setReplacedSequenceElement(StringType value) { 
          this.replacedSequence = value;
          return this;
        }

        /**
         * @return Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        public String getReplacedSequence() { 
          return this.replacedSequence == null ? null : this.replacedSequence.getValue();
        }

        /**
         * @param value Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.
         */
        public MolecularSequenceRelativeEditComponent setReplacedSequence(String value) { 
          if (Utilities.noString(value))
            this.replacedSequence = null;
          else {
            if (this.replacedSequence == null)
              this.replacedSequence = new StringType();
            this.replacedSequence.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("start", "integer", "Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.", 0, 1, start));
          children.add(new Property("end", "integer", "End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.", 0, 1, end));
          children.add(new Property("replacementSequence", "string", "Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.", 0, 1, replacementSequence));
          children.add(new Property("replacedSequence", "string", "Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.", 0, 1, replacedSequence));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 109757538: /*start*/  return new Property("start", "integer", "Start position of the edit on the starting sequence. If the coordinate system is either 0-based or 1-based, then start position is inclusive.", 0, 1, start);
          case 100571: /*end*/  return new Property("end", "integer", "End position of the edit on the starting sequence. If the coordinate system is 0-based then end is exclusive and does not include the last position. If the coordinate system is 1-base, then end is inclusive and includes the last position.", 0, 1, end);
          case -1784940557: /*replacementSequence*/  return new Property("replacementSequence", "string", "Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the observed sequence. When the sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.", 0, 1, replacementSequence);
          case 1972719633: /*replacedSequence*/  return new Property("replacedSequence", "string", "Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence to stop position of sequence on the positive (+) strand of the starting sequence. When the sequence  type is DNA, it should be the sequence on the positive (+) strand. This will lay in the range between variant.start and variant.end.", 0, 1, replacedSequence);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 109757538: /*start*/ return this.start == null ? new Base[0] : new Base[] {this.start}; // IntegerType
        case 100571: /*end*/ return this.end == null ? new Base[0] : new Base[] {this.end}; // IntegerType
        case -1784940557: /*replacementSequence*/ return this.replacementSequence == null ? new Base[0] : new Base[] {this.replacementSequence}; // StringType
        case 1972719633: /*replacedSequence*/ return this.replacedSequence == null ? new Base[0] : new Base[] {this.replacedSequence}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 109757538: // start
          this.start = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 100571: // end
          this.end = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -1784940557: // replacementSequence
          this.replacementSequence = TypeConvertor.castToString(value); // StringType
          return value;
        case 1972719633: // replacedSequence
          this.replacedSequence = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("start")) {
          this.start = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("end")) {
          this.end = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("replacementSequence")) {
          this.replacementSequence = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("replacedSequence")) {
          this.replacedSequence = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109757538:  return getStartElement();
        case 100571:  return getEndElement();
        case -1784940557:  return getReplacementSequenceElement();
        case 1972719633:  return getReplacedSequenceElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109757538: /*start*/ return new String[] {"integer"};
        case 100571: /*end*/ return new String[] {"integer"};
        case -1784940557: /*replacementSequence*/ return new String[] {"string"};
        case 1972719633: /*replacedSequence*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("start")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.edit.start");
        }
        else if (name.equals("end")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.edit.end");
        }
        else if (name.equals("replacementSequence")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.edit.replacementSequence");
        }
        else if (name.equals("replacedSequence")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.relative.edit.replacedSequence");
        }
        else
          return super.addChild(name);
      }

      public MolecularSequenceRelativeEditComponent copy() {
        MolecularSequenceRelativeEditComponent dst = new MolecularSequenceRelativeEditComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MolecularSequenceRelativeEditComponent dst) {
        super.copyValues(dst);
        dst.start = start == null ? null : start.copy();
        dst.end = end == null ? null : end.copy();
        dst.replacementSequence = replacementSequence == null ? null : replacementSequence.copy();
        dst.replacedSequence = replacedSequence == null ? null : replacedSequence.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeEditComponent))
          return false;
        MolecularSequenceRelativeEditComponent o = (MolecularSequenceRelativeEditComponent) other_;
        return compareDeep(start, o.start, true) && compareDeep(end, o.end, true) && compareDeep(replacementSequence, o.replacementSequence, true)
           && compareDeep(replacedSequence, o.replacedSequence, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MolecularSequenceRelativeEditComponent))
          return false;
        MolecularSequenceRelativeEditComponent o = (MolecularSequenceRelativeEditComponent) other_;
        return compareValues(start, o.start, true) && compareValues(end, o.end, true) && compareValues(replacementSequence, o.replacementSequence, true)
           && compareValues(replacedSequence, o.replacedSequence, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(start, end, replacementSequence
          , replacedSequence);
      }

  public String fhirType() {
    return "MolecularSequence.relative.edit";

  }

  }

    /**
     * A unique identifier for this particular sequence instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique ID for this particular sequence", formalDefinition="A unique identifier for this particular sequence instance." )
    protected List<Identifier> identifier;

    /**
     * Amino Acid Sequence/ DNA Sequence / RNA Sequence.
     */
    @Child(name = "type", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="aa | dna | rna", formalDefinition="Amino Acid Sequence/ DNA Sequence / RNA Sequence." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/sequence-type")
    protected Enumeration<SequenceType> type;

    /**
     * Indicates the subject this sequence is associated too.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Device.class, Location.class, Organization.class, Procedure.class, Practitioner.class, Medication.class, Substance.class, BiologicallyDerivedProduct.class, NutritionProduct.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Subject this sequence is associated too", formalDefinition="Indicates the subject this sequence is associated too." )
    protected Reference subject;

    /**
     * Specimen used for sequencing.
     */
    @Child(name = "specimen", type = {Specimen.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specimen used for sequencing", formalDefinition="Specimen used for sequencing." )
    protected Reference specimen;

    /**
     * The method for sequencing, for example, chip information.
     */
    @Child(name = "device", type = {Device.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The method for sequencing", formalDefinition="The method for sequencing, for example, chip information." )
    protected Reference device;

    /**
     * The organization or lab that should be responsible for this result.
     */
    @Child(name = "performer", type = {Organization.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who should be responsible for test result", formalDefinition="The organization or lab that should be responsible for this result." )
    protected Reference performer;

    /**
     * Sequence that was observed.
     */
    @Child(name = "literal", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Sequence that was observed", formalDefinition="Sequence that was observed." )
    protected StringType literal;

    /**
     * Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system.
     */
    @Child(name = "formatted", type = {Attachment.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Embedded file or a link (URL) which contains content to represent the sequence", formalDefinition="Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system." )
    protected List<Attachment> formatted;

    /**
     * A sequence defined relative to another sequence.
     */
    @Child(name = "relative", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A sequence defined relative to another sequence", formalDefinition="A sequence defined relative to another sequence." )
    protected List<MolecularSequenceRelativeComponent> relative;

    private static final long serialVersionUID = -191255113L;

  /**
   * Constructor
   */
    public MolecularSequence() {
      super();
    }

    /**
     * @return {@link #identifier} (A unique identifier for this particular sequence instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MolecularSequence setIdentifier(List<Identifier> theIdentifier) { 
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

    public MolecularSequence addIdentifier(Identifier t) { //3
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
     * @return {@link #type} (Amino Acid Sequence/ DNA Sequence / RNA Sequence.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<SequenceType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<SequenceType>(new SequenceTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Amino Acid Sequence/ DNA Sequence / RNA Sequence.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public MolecularSequence setTypeElement(Enumeration<SequenceType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return Amino Acid Sequence/ DNA Sequence / RNA Sequence.
     */
    public SequenceType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value Amino Acid Sequence/ DNA Sequence / RNA Sequence.
     */
    public MolecularSequence setType(SequenceType value) { 
      if (value == null)
        this.type = null;
      else {
        if (this.type == null)
          this.type = new Enumeration<SequenceType>(new SequenceTypeEnumFactory());
        this.type.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subject} (Indicates the subject this sequence is associated too.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Indicates the subject this sequence is associated too.)
     */
    public MolecularSequence setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #specimen} (Specimen used for sequencing.)
     */
    public Reference getSpecimen() { 
      if (this.specimen == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.specimen");
        else if (Configuration.doAutoCreate())
          this.specimen = new Reference(); // cc
      return this.specimen;
    }

    public boolean hasSpecimen() { 
      return this.specimen != null && !this.specimen.isEmpty();
    }

    /**
     * @param value {@link #specimen} (Specimen used for sequencing.)
     */
    public MolecularSequence setSpecimen(Reference value) { 
      this.specimen = value;
      return this;
    }

    /**
     * @return {@link #device} (The method for sequencing, for example, chip information.)
     */
    public Reference getDevice() { 
      if (this.device == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.device");
        else if (Configuration.doAutoCreate())
          this.device = new Reference(); // cc
      return this.device;
    }

    public boolean hasDevice() { 
      return this.device != null && !this.device.isEmpty();
    }

    /**
     * @param value {@link #device} (The method for sequencing, for example, chip information.)
     */
    public MolecularSequence setDevice(Reference value) { 
      this.device = value;
      return this;
    }

    /**
     * @return {@link #performer} (The organization or lab that should be responsible for this result.)
     */
    public Reference getPerformer() { 
      if (this.performer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.performer");
        else if (Configuration.doAutoCreate())
          this.performer = new Reference(); // cc
      return this.performer;
    }

    public boolean hasPerformer() { 
      return this.performer != null && !this.performer.isEmpty();
    }

    /**
     * @param value {@link #performer} (The organization or lab that should be responsible for this result.)
     */
    public MolecularSequence setPerformer(Reference value) { 
      this.performer = value;
      return this;
    }

    /**
     * @return {@link #literal} (Sequence that was observed.). This is the underlying object with id, value and extensions. The accessor "getLiteral" gives direct access to the value
     */
    public StringType getLiteralElement() { 
      if (this.literal == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MolecularSequence.literal");
        else if (Configuration.doAutoCreate())
          this.literal = new StringType(); // bb
      return this.literal;
    }

    public boolean hasLiteralElement() { 
      return this.literal != null && !this.literal.isEmpty();
    }

    public boolean hasLiteral() { 
      return this.literal != null && !this.literal.isEmpty();
    }

    /**
     * @param value {@link #literal} (Sequence that was observed.). This is the underlying object with id, value and extensions. The accessor "getLiteral" gives direct access to the value
     */
    public MolecularSequence setLiteralElement(StringType value) { 
      this.literal = value;
      return this;
    }

    /**
     * @return Sequence that was observed.
     */
    public String getLiteral() { 
      return this.literal == null ? null : this.literal.getValue();
    }

    /**
     * @param value Sequence that was observed.
     */
    public MolecularSequence setLiteral(String value) { 
      if (Utilities.noString(value))
        this.literal = null;
      else {
        if (this.literal == null)
          this.literal = new StringType();
        this.literal.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #formatted} (Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system.)
     */
    public List<Attachment> getFormatted() { 
      if (this.formatted == null)
        this.formatted = new ArrayList<Attachment>();
      return this.formatted;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MolecularSequence setFormatted(List<Attachment> theFormatted) { 
      this.formatted = theFormatted;
      return this;
    }

    public boolean hasFormatted() { 
      if (this.formatted == null)
        return false;
      for (Attachment item : this.formatted)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Attachment addFormatted() { //3
      Attachment t = new Attachment();
      if (this.formatted == null)
        this.formatted = new ArrayList<Attachment>();
      this.formatted.add(t);
      return t;
    }

    public MolecularSequence addFormatted(Attachment t) { //3
      if (t == null)
        return this;
      if (this.formatted == null)
        this.formatted = new ArrayList<Attachment>();
      this.formatted.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #formatted}, creating it if it does not already exist {3}
     */
    public Attachment getFormattedFirstRep() { 
      if (getFormatted().isEmpty()) {
        addFormatted();
      }
      return getFormatted().get(0);
    }

    /**
     * @return {@link #relative} (A sequence defined relative to another sequence.)
     */
    public List<MolecularSequenceRelativeComponent> getRelative() { 
      if (this.relative == null)
        this.relative = new ArrayList<MolecularSequenceRelativeComponent>();
      return this.relative;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MolecularSequence setRelative(List<MolecularSequenceRelativeComponent> theRelative) { 
      this.relative = theRelative;
      return this;
    }

    public boolean hasRelative() { 
      if (this.relative == null)
        return false;
      for (MolecularSequenceRelativeComponent item : this.relative)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MolecularSequenceRelativeComponent addRelative() { //3
      MolecularSequenceRelativeComponent t = new MolecularSequenceRelativeComponent();
      if (this.relative == null)
        this.relative = new ArrayList<MolecularSequenceRelativeComponent>();
      this.relative.add(t);
      return t;
    }

    public MolecularSequence addRelative(MolecularSequenceRelativeComponent t) { //3
      if (t == null)
        return this;
      if (this.relative == null)
        this.relative = new ArrayList<MolecularSequenceRelativeComponent>();
      this.relative.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relative}, creating it if it does not already exist {3}
     */
    public MolecularSequenceRelativeComponent getRelativeFirstRep() { 
      if (getRelative().isEmpty()) {
        addRelative();
      }
      return getRelative().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier for this particular sequence instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("type", "code", "Amino Acid Sequence/ DNA Sequence / RNA Sequence.", 0, 1, type));
        children.add(new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct|NutritionProduct)", "Indicates the subject this sequence is associated too.", 0, 1, subject));
        children.add(new Property("specimen", "Reference(Specimen)", "Specimen used for sequencing.", 0, 1, specimen));
        children.add(new Property("device", "Reference(Device)", "The method for sequencing, for example, chip information.", 0, 1, device));
        children.add(new Property("performer", "Reference(Organization)", "The organization or lab that should be responsible for this result.", 0, 1, performer));
        children.add(new Property("literal", "string", "Sequence that was observed.", 0, 1, literal));
        children.add(new Property("formatted", "Attachment", "Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system.", 0, java.lang.Integer.MAX_VALUE, formatted));
        children.add(new Property("relative", "", "A sequence defined relative to another sequence.", 0, java.lang.Integer.MAX_VALUE, relative));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier for this particular sequence instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3575610: /*type*/  return new Property("type", "code", "Amino Acid Sequence/ DNA Sequence / RNA Sequence.", 0, 1, type);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct|NutritionProduct)", "Indicates the subject this sequence is associated too.", 0, 1, subject);
        case -2132868344: /*specimen*/  return new Property("specimen", "Reference(Specimen)", "Specimen used for sequencing.", 0, 1, specimen);
        case -1335157162: /*device*/  return new Property("device", "Reference(Device)", "The method for sequencing, for example, chip information.", 0, 1, device);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Organization)", "The organization or lab that should be responsible for this result.", 0, 1, performer);
        case 182460591: /*literal*/  return new Property("literal", "string", "Sequence that was observed.", 0, 1, literal);
        case 1811591356: /*formatted*/  return new Property("formatted", "Attachment", "Sequence that was observed as file content. Can be an actual file contents, or referenced by a URL to an external system.", 0, java.lang.Integer.MAX_VALUE, formatted);
        case -554435892: /*relative*/  return new Property("relative", "", "A sequence defined relative to another sequence.", 0, java.lang.Integer.MAX_VALUE, relative);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<SequenceType>
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -2132868344: /*specimen*/ return this.specimen == null ? new Base[0] : new Base[] {this.specimen}; // Reference
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : new Base[] {this.performer}; // Reference
        case 182460591: /*literal*/ return this.literal == null ? new Base[0] : new Base[] {this.literal}; // StringType
        case 1811591356: /*formatted*/ return this.formatted == null ? new Base[0] : this.formatted.toArray(new Base[this.formatted.size()]); // Attachment
        case -554435892: /*relative*/ return this.relative == null ? new Base[0] : this.relative.toArray(new Base[this.relative.size()]); // MolecularSequenceRelativeComponent
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
          value = new SequenceTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SequenceType>
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case -2132868344: // specimen
          this.specimen = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case 481140686: // performer
          this.performer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 182460591: // literal
          this.literal = TypeConvertor.castToString(value); // StringType
          return value;
        case 1811591356: // formatted
          this.getFormatted().add(TypeConvertor.castToAttachment(value)); // Attachment
          return value;
        case -554435892: // relative
          this.getRelative().add((MolecularSequenceRelativeComponent) value); // MolecularSequenceRelativeComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("type")) {
          value = new SequenceTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SequenceType>
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("specimen")) {
          this.specimen = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("performer")) {
          this.performer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("literal")) {
          this.literal = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("formatted")) {
          this.getFormatted().add(TypeConvertor.castToAttachment(value));
        } else if (name.equals("relative")) {
          this.getRelative().add((MolecularSequenceRelativeComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3575610:  return getTypeElement();
        case -1867885268:  return getSubject();
        case -2132868344:  return getSpecimen();
        case -1335157162:  return getDevice();
        case 481140686:  return getPerformer();
        case 182460591:  return getLiteralElement();
        case 1811591356:  return addFormatted(); 
        case -554435892:  return addRelative(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -2132868344: /*specimen*/ return new String[] {"Reference"};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case 182460591: /*literal*/ return new String[] {"string"};
        case 1811591356: /*formatted*/ return new String[] {"Attachment"};
        case -554435892: /*relative*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.type");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("specimen")) {
          this.specimen = new Reference();
          return this.specimen;
        }
        else if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("performer")) {
          this.performer = new Reference();
          return this.performer;
        }
        else if (name.equals("literal")) {
          throw new FHIRException("Cannot call addChild on a primitive type MolecularSequence.literal");
        }
        else if (name.equals("formatted")) {
          return addFormatted();
        }
        else if (name.equals("relative")) {
          return addRelative();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MolecularSequence";

  }

      public MolecularSequence copy() {
        MolecularSequence dst = new MolecularSequence();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MolecularSequence dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.specimen = specimen == null ? null : specimen.copy();
        dst.device = device == null ? null : device.copy();
        dst.performer = performer == null ? null : performer.copy();
        dst.literal = literal == null ? null : literal.copy();
        if (formatted != null) {
          dst.formatted = new ArrayList<Attachment>();
          for (Attachment i : formatted)
            dst.formatted.add(i.copy());
        };
        if (relative != null) {
          dst.relative = new ArrayList<MolecularSequenceRelativeComponent>();
          for (MolecularSequenceRelativeComponent i : relative)
            dst.relative.add(i.copy());
        };
      }

      protected MolecularSequence typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MolecularSequence))
          return false;
        MolecularSequence o = (MolecularSequence) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(subject, o.subject, true)
           && compareDeep(specimen, o.specimen, true) && compareDeep(device, o.device, true) && compareDeep(performer, o.performer, true)
           && compareDeep(literal, o.literal, true) && compareDeep(formatted, o.formatted, true) && compareDeep(relative, o.relative, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MolecularSequence))
          return false;
        MolecularSequence o = (MolecularSequence) other_;
        return compareValues(type, o.type, true) && compareValues(literal, o.literal, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, subject
          , specimen, device, performer, literal, formatted, relative);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MolecularSequence;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The unique identity for a particular sequence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MolecularSequence.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="MolecularSequence.identifier", description="The unique identity for a particular sequence", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The unique identity for a particular sequence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MolecularSequence.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>The subject that the sequence is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MolecularSequence.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="MolecularSequence.subject", description="The subject that the sequence is about", type="reference", target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>The subject that the sequence is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MolecularSequence.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MolecularSequence:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("MolecularSequence:patient").toLocked();

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The subject that the sequence is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MolecularSequence.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="MolecularSequence.subject", description="The subject that the sequence is about", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The subject that the sequence is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MolecularSequence.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MolecularSequence:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("MolecularSequence:subject").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Amino Acid Sequence/ DNA Sequence / RNA Sequence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MolecularSequence.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="MolecularSequence.type", description="Amino Acid Sequence/ DNA Sequence / RNA Sequence", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Amino Acid Sequence/ DNA Sequence / RNA Sequence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MolecularSequence.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

