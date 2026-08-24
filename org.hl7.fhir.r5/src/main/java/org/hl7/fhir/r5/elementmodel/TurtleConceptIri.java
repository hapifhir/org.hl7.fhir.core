package org.hl7.fhir.r5.elementmodel;

import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemType;
import org.hl7.fhir.r5.terminologies.NamingSystemUtilities;
import org.hl7.fhir.utilities.Utilities;

/**
 * An RDF (Turtle) Concept IRI is the RDF-equivalent of a FHIR Coding 
 * as specified by the IRI stem registered in the NamingSystem that corresponds to the Coding.system.
 * <p>
 * This class also serves as a registry of well-known concept IRIs (SNOMED CT, LOINC, MeSH)
 * via {@link #forSystem(String)} and {@link #forIriStem(String)}.
 */
class TurtleConceptIri {

  private static final String SNOMED_SYSTEM = "http://snomed.info/sct";

  /** Known code systems and how to render their codes as RDF concept IRIs in Turtle. */
  private static final List<TurtleConceptIri> KNOWN_CONCEPT_IRIS = List.of(
      new TurtleConceptIri(SNOMED_SYSTEM, "http://snomed.info/id/", "sct", false),
      new TurtleConceptIri("http://loinc.org", "https://loinc.org/rdf/", "loinc", true),
      new TurtleConceptIri("https://www.nlm.nih.gov/mesh", "http://id.nlm.nih.gov/mesh/", "mesh", false));

  final String system;
  final String iriStem;
  final String prefix;
  final boolean upperCaseCode;

  TurtleConceptIri(String system, String iriStem, String prefix, boolean upperCaseCode) {
    this.system = system;
    this.iriStem = iriStem;
    this.prefix = prefix;
    this.upperCaseCode = upperCaseCode;
  }

  /** Concept IRI with only a stem — used when a NamingSystem declares a stem we don't recognize. */
  static TurtleConceptIri stemOnly(String iriStem) {
    return new TurtleConceptIri(null, iriStem, null, false);
  }

  /** Returns the known concept IRI for the given code system URL, or {@code null} if unknown. */
  static TurtleConceptIri forSystem(String system) {
    for (TurtleConceptIri iri : KNOWN_CONCEPT_IRIS) {
      if (iri.system.equals(system)) {
        return iri;
      }
    }
    return null;
  }

  /** Returns the known concept IRI whose stem matches, or {@code null} if none does. */
  static TurtleConceptIri forIriStem(String iriStem) {
    for (TurtleConceptIri iri : KNOWN_CONCEPT_IRIS) {
      if (iri.iriStem.equals(iriStem)) {
        return iri;
      }
    }
    return null;
  }

  /** Resolves the built-in concept IRI to use for {@code system}, or {@code null} if none applies. */
  static TurtleConceptIri resolve(IWorkerContext context, String system) {
    return resolve(context, system, false);
  }

  /** Resolves the concept IRI to use for {@code system}, or {@code null} if none applies. */
  static TurtleConceptIri resolve(IWorkerContext context, String system, boolean lookupNamingSystem) {
    TurtleConceptIri known = forSystem(system);
    if (known != null || !lookupNamingSystem) {
      return known;
    }
    String iriStem = iriStemFrom(NamingSystemUtilities.getNamingSystem(context, system));
    if (Utilities.noString(iriStem)) {
      return null;
    }
    TurtleConceptIri byStem = forIriStem(iriStem);
    return byStem != null ? byStem : stemOnly(iriStem);
  }

  /** Returns the IRI stem declared on a code-system {@link NamingSystem}, or {@code null} if none. */
  static String iriStemFrom(NamingSystem namingSystem) {
    if (namingSystem == null || namingSystem.getKind() != NamingSystemType.CODESYSTEM) {
      return null;
    }
    for (NamingSystem.NamingSystemUniqueIdComponent uniqueId : namingSystem.getUniqueId()) {
      if (uniqueId.getType() == NamingSystemIdentifierType.IRISTEM && uniqueId.hasValue()) {
        return uniqueId.getValue();
      }
    }
    return null;
  }

  /** Renders {@code code} as a concept IRI, or {@code null} if this IRI cannot render it. */
  String render(String code) {
    // Post-coordinated codes not supported, but could be translate to OWL in some cases
    if (SNOMED_SYSTEM.equals(system) && (code.contains(":") || code.contains("="))) {
      return null;
    }
    String renderedCode = upperCaseCode ? TurtleParserBase.urlescape(code).toUpperCase() : TurtleParserBase.urlescape(code);
    if (prefix != null) {
      return prefix + ":" + renderedCode;
    }
    return "<" + iriStem + renderedCode + ">";
  }
}
