package org.hl7.fhir.r5.model;




import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;

/**
 * Base StructureDefinition for CodeableReference Type: A reference to a resource (by instance), or instead, a reference to a cencept defined in a terminology or ontology (by class).
 */
@DatatypeDef(name="CodeableReference")
public class CodeableReference extends DataType implements ICompositeType {

    /**
     * A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.
     */
    @Child(name = "concept", type = {CodeableConcept.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to a concept (by class)", formalDefinition="A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology." )
    protected CodeableConcept concept;

    /**
     * A reference to a resource the provides exact details about the information being referenced.
     */
    @Child(name = "reference", type = {Reference.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to a resource (by instance)", formalDefinition="A reference to a resource the provides exact details about the information being referenced." )
    protected Reference reference;

    private static final long serialVersionUID = 2070287445L;

  /**
   * Constructor
   */
    public CodeableReference() {
      super();
    }

    /**
     * @return {@link #concept} (A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.)
     */
    public CodeableConcept getConcept() { 
      if (this.concept == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CodeableReference.concept");
        else if (Configuration.doAutoCreate())
          this.concept = new CodeableConcept(); // cc
      return this.concept;
    }

    public boolean hasConcept() { 
      return this.concept != null && !this.concept.isEmpty();
    }

    /**
     * @param value {@link #concept} (A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.)
     */
    public CodeableReference setConcept(CodeableConcept value) { 
      this.concept = value;
      return this;
    }

    /**
     * @return {@link #reference} (A reference to a resource the provides exact details about the information being referenced.)
     */
    public Reference getReference() { 
      if (this.reference == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CodeableReference.reference");
        else if (Configuration.doAutoCreate())
          this.reference = new Reference(); // cc
      return this.reference;
    }

    public boolean hasReference() { 
      return this.reference != null && !this.reference.isEmpty();
    }

    /**
     * @param value {@link #reference} (A reference to a resource the provides exact details about the information being referenced.)
     */
    public CodeableReference setReference(Reference value) { 
      this.reference = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("concept", "CodeableConcept", "A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.", 0, 1, concept));
        children.add(new Property("reference", "Reference", "A reference to a resource the provides exact details about the information being referenced.", 0, 1, reference));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 951024232: /*concept*/  return new Property("concept", "CodeableConcept", "A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.", 0, 1, concept);
        case -925155509: /*reference*/  return new Property("reference", "Reference", "A reference to a resource the provides exact details about the information being referenced.", 0, 1, reference);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 951024232: /*concept*/ return this.concept == null ? new Base[0] : new Base[] {this.concept}; // CodeableConcept
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 951024232: // concept
          this.concept = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("concept")) {
          this.concept = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951024232:  return getConcept();
        case -925155509:  return getReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951024232: /*concept*/ return new String[] {"CodeableConcept"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("concept")) {
          this.concept = new CodeableConcept();
          return this.concept;
        }
        else if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CodeableReference";

  }

      public CodeableReference copy() {
        CodeableReference dst = new CodeableReference();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CodeableReference dst) {
        super.copyValues(dst);
        dst.concept = concept == null ? null : concept.copy();
        dst.reference = reference == null ? null : reference.copy();
      }

      protected CodeableReference typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CodeableReference))
          return false;
        CodeableReference o = (CodeableReference) other_;
        return compareDeep(concept, o.concept, true) && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CodeableReference))
          return false;
        CodeableReference o = (CodeableReference) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(concept, reference);
      }


}