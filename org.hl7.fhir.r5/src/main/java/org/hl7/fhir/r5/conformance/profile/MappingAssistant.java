package org.hl7.fhir.r5.conformance.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

@MarkedToMoveToAdjunctPackage
public class MappingAssistant {


  public enum MappingMergeModeOption {
    DUPLICATE, // if there's more than one mapping for the same URI, just keep them all
    IGNORE, // if there's more than one, keep the first 
    OVERWRITE, // if there's more than one, keep the last 
    APPEND, // if there's more than one, append them with ';' 
  }
  
  private MappingMergeModeOption mappingMergeMode = MappingMergeModeOption.APPEND;
  private StructureDefinition base;
  private StructureDefinition derived;
  
  private List<StructureDefinitionMappingComponent> masterList= new ArrayList<StructureDefinition.StructureDefinitionMappingComponent>();
  private Map<String, String> renames = new HashMap<>();
  private String version;
  private List<String> suppressedMappings= new ArrayList<>();
  
  public MappingAssistant(MappingMergeModeOption mappingMergeMode, StructureDefinition base, StructureDefinition derived, String version, List<String> suppressedMappings) {
    this.mappingMergeMode = mappingMergeMode;
    this.base = base;
    this.derived = derived;
    this.version = version;
    if (suppressedMappings != null) {
      this.suppressedMappings = suppressedMappings;
    }
    
    // figure out where we're going to be: 
    // mappings declared in derived get priority; we do not change them either 
    for (StructureDefinitionMappingComponent m : derived.getMapping()) {
      masterList.add(m);
      if (!isSuppressed(m)) {
        m.setUserData(UserDataNames.mappings_inherited, true);
      }
    }
    
    // now, look at the base profile. If mappings in there match one in the derived, then we use that, otherwise, we add it to the list 
    for (StructureDefinitionMappingComponent m : base.getMapping()) {
      if (notExcluded(m)) {
        StructureDefinitionMappingComponent md = findMatchInDerived(m);
        if (md == null) {
          if (nameExists(m.getIdentity())) {
            int i = 1;
            String n = m.getIdentity() + i;
            while (nameExists(n)) {
              i++;
              n = m.getIdentity() + i;
            }
            renames.put(m.getIdentity(), n);
            masterList.add(m.copy().setName(n));
          } else {
            masterList.add(m.copy());
          }
        } else {
          if (!md.hasName() && m.hasName()) {
            md.setName(m.getName());
          }
          if (!md.hasUri() && m.hasUri()) {
            md.setUri(m.getUri());
          }
          if (!md.hasComment() && m.hasComment()) {
            md.setComment(m.getComment());
          }
          if (!m.getIdentity().equals(md.getIdentity())) {
            renames.put(m.getIdentity(), md.getIdentity());
          }
        }
      }
    }
  }

  private boolean notExcluded(StructureDefinitionMappingComponent m) {
    if (!m.hasUri()) {
      return true;
    }
    return !Utilities.existsInList(m.getUri(), suppressedMappings);
  }

  private boolean notExcluded(ElementDefinitionMappingComponent m) {
    if (!m.hasIdentity()) {
      return false;
    }
    StructureDefinitionMappingComponent mm = null;
    for (StructureDefinitionMappingComponent t : base.getMapping()) {
      if (m.getIdentity().equals(t.getIdentity())) {
        mm = t;
        break;
      }
    }
    if (mm == null) {
      return false;
    } else {
      return notExcluded(mm);
    }
  }
  
  private boolean nameExists(String n) {
    for (StructureDefinitionMappingComponent md : masterList) {
      if (n.equals(md.getIdentity())) {
        return true;
      }      
    }
    return false;
  }

  private StructureDefinitionMappingComponent findMatchInDerived(StructureDefinitionMappingComponent m) {
    for (StructureDefinitionMappingComponent md : derived.getMapping()) {
      // if the URIs match, they match, irregardless of anything else
      if (md.hasUri() && m.hasUri() && md.getUri().equals(m.getUri())) {
        return md;
      }
      // if the codes match
      if (md.hasIdentity() && m.hasIdentity() && md.getIdentity().equals(m.getIdentity())) {
        // the names have to match if present
        if (!md.hasName() || !m.hasName() || md.getName().equals(m.getName())) {
          return md;
        }
      }
      
    }
    return null;
  }

  public void update() {

    Set<StructureDefinitionMappingComponent> usedList= new HashSet<StructureDefinition.StructureDefinitionMappingComponent>();
    for (ElementDefinition ed : derived.getSnapshot().getElement()) {
      for (ElementDefinitionMappingComponent m : ed.getMapping()) {
        StructureDefinitionMappingComponent def = findDefinition(m.getIdentity());
        if (def != null && notExcluded(m)) {
          usedList.add(def);
        } else {
          // not sure what to do?
        }
      }
    }
    
    derived.getMapping().clear();
    for (StructureDefinitionMappingComponent t : masterList) {
      if (usedList.contains(t) || t.hasUserData(UserDataNames.mappings_inherited)) {
        derived.getMapping().add(t);
      }
    }
  }


  public void merge(ElementDefinition base, ElementDefinition derived) {
    List<ElementDefinitionMappingComponent> list = new ArrayList<>();
    addMappings(list, base.getMapping(), renames);
    if (derived.hasMapping()) {
      addMappings(list, derived.getMapping(), null);
    }
    derived.setMapping(list);
    
    // trim anything
    for (ElementDefinitionMappingComponent m : base.getMapping()) {
      if (m.hasMap()) {
        m.setMap(m.getMap().trim());
      }
    }

  }

  private void addMappings(List<ElementDefinitionMappingComponent> destination, List<ElementDefinitionMappingComponent> source, Map<String, String> renames2) {
    for (ElementDefinitionMappingComponent s : source) {
      if (!isSuppressed(s)) {
        String name = s.getIdentity();
        if (!isSuppressed(name)) {
          if (renames2 != null && renames2.containsKey(name)) {
            name = renames2.get(name);
          }

          boolean found = false;
          for (ElementDefinitionMappingComponent d : destination) {
            if (compareMaps(name, s, d)) {
              found = true;
              d.setUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS, true);
              break;
            }
          }
          if (!found) {
            destination.add(s.setIdentity(name));
          }
        }
      }
    }
  }

  private boolean isSuppressed(String name) {
    StructureDefinitionMappingComponent m = findDefinition(name);
    return m != null && isSuppressed(m);
  }

  private boolean isSuppressed(Element s) {
    return ToolingExtensions.readBoolExtension(s, ToolingExtensions.EXT_SUPPRESSED);
  }

  private StructureDefinitionMappingComponent findDefinition(String name) {
    for (StructureDefinitionMappingComponent t : masterList) {
      if (t.getIdentity().equals(name)) {
        return t;
      }
    }
    return null;
  }

  private boolean compareMaps(String name, ElementDefinitionMappingComponent s, ElementDefinitionMappingComponent d) {
    
    if (d.getIdentity().equals(name) && d.getMap().equals(s.getMap())) {
      return true;
    }
    if (VersionUtilities.isR5Plus(version)) {
      if (d.getIdentity().equals(name)) {
        switch (mappingMergeMode) {
        case APPEND:
          if (!Utilities.splitStrings(d.getMap(), "\\,").contains(s.getMap())) {
            d.setMap(mergeMaps(d.getMap(), s.getMap()));
          }
          return true;
        case DUPLICATE:
          return false;
        case IGNORE:
          d.setMap(s.getMap());
          return true;
        case OVERWRITE:
          return true;
        default:
          return false;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  private String mergeMaps(String map, String map2) {
    List<String> csv1 = CSVReader.splitString(map);
    List<String> csv2 = CSVReader.splitString(map2);
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(",");
    for (String s : csv1) {
      b.append(s);
    }
    for (String s : csv2) {
      if (!csv1.contains(s)) {
        b.append(s);
      }
    }
    return b.toString();
  }

}
