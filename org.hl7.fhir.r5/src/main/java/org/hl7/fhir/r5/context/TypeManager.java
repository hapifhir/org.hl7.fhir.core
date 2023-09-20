package org.hl7.fhir.r5.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

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
    primitiveNames.clear();
    dataTypeNames.clear();
    for (CanonicalResourceManager<StructureDefinition>.CachedCanonicalResource<StructureDefinition> cr : structures.getCachedList()) {
      if (!"constraint".equals(cr.getDerivation())) {
        see(cr.getResource());
      }
    }    
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
      if (sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/")) {
        types = fhirTypeDefinitions.get(type);
        if (types == null) {
          types = new HashSet<>();
          fhirTypeDefinitions.put(type, types);
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
      } else if (types.size() != 1) {
        throw new FHIRException("Ambiguous type "+typeName+" ("+types.toString()+") (contact Grahame Grieve for investigation)");
      } else  {
        return types.iterator().next(); 
      }
    }
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
  
}
