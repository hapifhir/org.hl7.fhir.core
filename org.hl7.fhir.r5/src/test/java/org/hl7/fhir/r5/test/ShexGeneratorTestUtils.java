package org.hl7.fhir.r5.test;

import org.hl7.fhir.r5.model.StructureDefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShexGeneratorTestUtils {
  public class resDef {
    public String name;
    public String url;
    public String info;

    public resDef(String _name, String _url, String _info){
      this.name = _name;
      this.url = _url;
      this.info = _info;
    }

    @Override
    public String toString() {
      return " " + name + "[ " + url + " ] ";
    }
  }

  public enum RESOURCE_CATEGORY{
    LOGICAL_NAMES, STRUCTURE_DEFINITIONS, EXTENSIONS, PROFILES, ALL
  }
  public List<resDef> getSDs(List<StructureDefinition> sds, RESOURCE_CATEGORY cat) {
    List<resDef> selSDs = new ArrayList<resDef>();
    sds.forEach((StructureDefinition sd) -> {
      switch(cat) {
        case STRUCTURE_DEFINITIONS:
          if (sd.getType().trim().equals(sd.getName().trim()))
              selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd)));
          break;
        case LOGICAL_NAMES:
          if (sd.getBaseDefinition() == null)
            selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd)));
          break;
        case EXTENSIONS:
          if ("Extension".equals(sd.getType()))
            selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd)));
          break;
        case PROFILES:
          if (!((sd.getBaseDefinition() == null) ||
              ("Extension".equals(sd.getType())) ||
              (sd.getType().trim().equals(sd.getName().trim()))))
            selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd)));
          break;
        default:
          selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd)));
      }
    });

    Collections.sort(selSDs, new Comparator<resDef>() {
      @Override
      public int compare(resDef o1, resDef o2) {
        return o1.name.compareTo(o2.name);
      }
    });

    return selSDs;
  }
  public static List<String> getMetaStructureDefinitionsToSkip(){
    List<String> skipSDs = new ArrayList<String>();
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ActivityDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/AdministrableProductDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ChargeItemDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ClinicalUseDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/CodeSystem");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ConceptMap");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/CompartmentDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/CompartmentDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/DeviceDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ElementDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/EventDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/GraphDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/GuidanceResponse");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/Library");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ManufacturedItemDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/Measure");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/MeasureReport");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/MedicinalProductDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/MessageDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/NamingSystem");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ObservationDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/OperationDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/PackagedProductDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ParameterDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/PlanDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/SearchParameter");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/SpecimenDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/StructureDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/SubstanceDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/Task");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/TerminologyCapabilities");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/TriggerDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ValueSet");
    return skipSDs;
  }

  /**
   * This method prepares selected extensions to test the policy in which ShEx Generator
   * only translates selected resource extensions
   * @return List<String> List of selected resource extensions for testing
   */
  public static List<String> getSelectedExtensions(){
    List<String> selectedExtesnsions = new ArrayList<String>();
    selectedExtesnsions.add("http://fhir-registry.smarthealthit.org/StructureDefinition/capabilities");
    selectedExtesnsions.add("http://fhir-registry.smarthealthit.org/StructureDefinition/oauth-uris");
    return selectedExtesnsions;
  }

  public static String getSDInfo(StructureDefinition sd) {
    if (sd != null) {
      String kind = " ";
      try {
        kind = sd.getKind().name();
      } catch (Exception e) {
        System.out.println("Kind is null");
      }
      String name = " ";
      try {
        name = sd.getName();
      } catch (Exception e) {
        System.out.println("Name is null");
      }
      String type = " ";
      try {
        type = sd.getType();
      } catch (Exception e) {
        System.out.println("Type is null");
      }
      String derv = " ";
      try {
        derv = sd.getDerivation().name();
      } catch (Exception e) {
        System.out.println("Derivation is null");
      }
      String url = " ";
      try {
        url = sd.getUrl();
      } catch (Exception e) {
        System.out.println("URL is null");
      }
      String base = " ";
      try {
        base = sd.getBaseDefinition();
      } catch (Exception e) {
        System.out.println("Base is null");
      }
      return kind + "\t" + name + "\t" + type + "\t" + derv + "\t" + url + "\t" + base;
    }
    return "";
  }

  public static void printList(String title, List<ShexGeneratorTestUtils.resDef> items) {
    System.out.println("************************************************************************");
    System.out.println("Printing " + title);
    System.out.println("************************************************************************");
    items.forEach((resDef item) -> {
      System.out.println(item.name + " [" + item.url + "]");
    });
  }
}
