package org.hl7.fhir.standalone.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.standalone.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.UserDataNames;

import org.hl7.fhir.utilities.Utilities;

import java.util.*;


public class TypeManager {

  
  private CanonicalResourceManager<StructureDefinition> structures;
  private Map<String, Set<StructureDefinition>> typeDefinitions = new HashMap<>();
  private Map<String, Set<StructureDefinition>> fhirTypeDefinitions = new HashMap<>();
  private Set<String> primitiveNames = new HashSet<>();
  private Set<String> dataTypeNames = new HashSet<>();
  
  public TypeManager(CanonicalResourceManager<StructureDefinition> structures) {
    super();
    this.structures = structures;
    reload();
  }

  public void reload() {
    typeDefinitions.clear();
    fhirTypeDefinitions.clear();
    primitiveNames.clear();
    dataTypeNames.clear();
    for (CanonicalResourceManager<StructureDefinition>.CachedCanonicalResource<StructureDefinition> cr : structures.getCachedList()) {
      if (!"constraint".equals(cr.getDerivation())) {
        see(cr.getResource());
      }
    }    
  }

  protected Iterable<String> getTypeNames() {
    return typeDefinitions.keySet();
  }

  public void see(CanonicalResourceProxy r) {
    if (!"constraint".equals(r.getDerivation())) {
      see((StructureDefinition) r.getResource());
    }
  }

  public void see(StructureDefinition sd) {
    if (sd.getDerivation() != TypeDerivationRule.CONSTRAINT && (sd.getSourcePackage() == null || !sd.getSourcePackage().isExamplesPackage())) {
      String type = sd.getType();
      Set<StructureDefinition> types = typeDefinitions.get(type);
      if (types == null) {
        types = new HashSet<>();
        typeDefinitions.put(type, types);
      }
      types.add(sd);
      if (sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/") || "true".equals(sd.getUserString(UserDataNames.loader_custom_resource))) {
        types = fhirTypeDefinitions.get(type);
        if (types == null) {
          types = new HashSet<>();
          fhirTypeDefinitions.put(type, types);
        }
        types.add(sd);
      }
      if (Utilities.isAbsoluteUrl(type)) {
        type = sd.getTypeTail();
        types = typeDefinitions.get(type);
        if (types == null) {
          types = new HashSet<>();
          typeDefinitions.put(type, types);
        }
        types.add(sd);
      }
      if (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
        primitiveNames.add(sd.getType());
      } else if (sd.getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        dataTypeNames.add(sd.getType());
      }
    }
  }


  public List<StructureDefinition> getDefinitions(String typeName) {
    List<StructureDefinition> list = new ArrayList<>();
    Set<StructureDefinition> defined = typeDefinitions.get(typeName);
    if (defined != null) {
      list.addAll(defined);
    }
    return list;
  }

  public StructureDefinition fetchTypeDefinition(String typeName) {
    Set<StructureDefinition> types = typeDefinitions.get(typeName);
    if (types == null) {
      return null; // throw new FHIRException("Unresolved type "+typeName+" (0)");
    } else if (types.size() == 1) {
      return types.iterator().next(); 
    } else { 
      types = fhirTypeDefinitions.get(typeName);
      if (types == null) {
        return null;
      } else if (types.size() == 1) {
        return types.iterator().next(); 
      } else {
        // More than one definition in the FHIR namespace for this type name. This happens when an
        // additional/incubator module (loaded as a "master" package) overrides a base-specification
        // resource: the base and the override share the same canonical URL but differ by version.
        // Prefer the master (overriding) definition - exactly as a version-less canonical lookup
        // does - rather than treating this as a genuine ambiguity.
        StructureDefinition master = pickMasterDefinition(types);
        if (master != null) {
          return master;
        }
        throw new FHIRException("Ambiguous type "+typeName+" ("+types.toString()+") (contact Grahame Grieve for investigation)");
      }
    }
  }

  /**
   * When a type name resolves to more than one definition in the FHIR namespace, decide whether the
   * collision is really an incubator override (a base resource plus a "master" definition that
   * overrides it, sharing the canonical URL) rather than a true ambiguity. If every candidate agrees
   * on the same master-preferred, version-less resolution and that resolution is one of the
   * candidates, it is returned; otherwise null (a genuine ambiguity, left for the caller to report).
   */
  private StructureDefinition pickMasterDefinition(Set<StructureDefinition> types) {
    StructureDefinition master = null;
    for (StructureDefinition sd : types) {
      StructureDefinition m = structures.get(sd.getUrl()); // master-aware, version-less resolution
      if (m == null) {
        return null;
      } else if (master == null) {
        master = m;
      } else if (!master.getUrl().equals(m.getUrl()) || !Objects.equals(master.getVersion(), m.getVersion())) {
        return null;
      }
    }
    if (master != null) {
      for (StructureDefinition sd : types) {
        if (master.getUrl().equals(sd.getUrl()) && Objects.equals(master.getVersion(), sd.getVersion())) {
          return sd;
        }
      }
    }
    return null;
  }

  public boolean isPrimitive(String type) {
    if (primitiveNames.contains(type) || Utilities.existsInList(type, "boolean", "integer", "integer64", "string", "decimal", "uri", "base64Binary", "instant", "date", "dateTime", "time", "code", "oid", "id", "markdown", "unsignedInt", "positiveInt", "uuid", "xhtml", "url", "canonical")) {
      return true;
    } else {
      StructureDefinition sd = structures.get(type);
      return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
    }
  }

  public boolean isDataType(String type) {
    if (dataTypeNames.contains(type) || Utilities.existsInList(type, "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "Reference", "SampledData", "Signature", "Timing", 
        "ContactDetail", "Contributor", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext")) {
      return true;
    } else {
      StructureDefinition sd = structures.get(type);
      return sd != null && sd.getKind() == StructureDefinitionKind.COMPLEXTYPE;      
    }
  }

  public void unload() {

    structures.unload();
    typeDefinitions.clear(); 
    fhirTypeDefinitions.clear();
    primitiveNames.clear();
    dataTypeNames.clear();
  }
  
}
