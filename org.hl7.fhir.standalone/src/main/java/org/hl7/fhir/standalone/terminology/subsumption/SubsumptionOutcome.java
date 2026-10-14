package org.hl7.fhir.standalone.terminology.subsumption;

import org.hl7.fhir.exceptions.FHIRException;

/**
 * The possible outcomes of a subsumption test between two codings A and B, as defined
 * by http://hl7.org/fhir/ValueSet/concept-subsumption-outcome (the outcome parameter of
 * the CodeSystem $subsumes operation).
 * <p>
 * Note that the outcome is always stated from the point of view of A: A subsumes B, 
 * A is subsumed by B, etc.
 */
public enum SubsumptionOutcome {

  /**
   * A and B are the same concept
   */
  EQUIVALENT, 

  /**
   * A subsumes B - that is, A is an ancestor of B
   */
  SUBSUMES, 

  /**
   * A is subsumed by B - that is, B is an ancestor of A
   */
  SUBSUMEDBY, 

  /**
   * neither concept subsumes the other
   */
  NOTSUBSUMED;

  public String toCode() {
    switch (this) {
    case EQUIVALENT: return "equivalent";
    case SUBSUMES: return "subsumes";
    case SUBSUMEDBY: return "subsumed-by";
    case NOTSUBSUMED: return "not-subsumed";
    default: return null;
    }
  }

  public static SubsumptionOutcome fromCode(String code) throws FHIRException {
    if (code == null) {
      return null;
    }
    switch (code) {
    case "equivalent": return EQUIVALENT;
    case "subsumes": return SUBSUMES;
    case "subsumed-by": return SUBSUMEDBY;
    case "not-subsumed": return NOTSUBSUMED;
    default: throw new FHIRException("Unknown subsumption outcome code '"+code+"'");
    }
  }

  /**
   * @return the outcome that would be returned if A and B were swapped
   */
  public SubsumptionOutcome reverse() {
    switch (this) {
    case SUBSUMES: return SUBSUMEDBY;
    case SUBSUMEDBY: return SUBSUMES;
    default: return this;
    }
  }
}
