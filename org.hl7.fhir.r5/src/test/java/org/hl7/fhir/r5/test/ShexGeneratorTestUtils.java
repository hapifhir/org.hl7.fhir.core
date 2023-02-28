package org.hl7.fhir.r5.test;

import org.hl7.fhir.r5.model.StructureDefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ShexGeneratorTestUtils
 *
 * This class provides auxiliary methos to perform testing of
 * Shape Expressions (ShEx) translation of various FHIR Resources.
 *
 * Author: Deepak Sharma
 */
public class ShexGeneratorTestUtils {
  public class resDef {
    public String name;
    public String url;
    public String info;
    public RESOURCE_CATEGORY kind;

    public resDef(String _name, String _url, String _info, RESOURCE_CATEGORY _kind){
      this.name = _name;
      this.url = _url;
      this.info = _info;
      this.kind = _kind;
    }

    @Override
    public String toString() {
      return " " + name + " (Kind: " + kind + " ) [ " + url + " ]";
    }
  }

  public enum RESOURCE_CATEGORY{
    LOGICAL_NAME, STRUCTURE_DEFINITION, EXTENSION, PROFILE, ALL, META_OR_EXAMPLE_OR_OTHER_IGNORE
  }

  /**
   * Filters Structure Definitions from a given list of
   * mixed types of StructureDefinitons based on resource categories
   * @param sds  List of StructureDefiniton of any resource type
   * @param cat  Resource category filter criteria (inclusive)
   * @return List of resDef with just Structure Definition's name, url and description.
   */
  public List<resDef> getSDs(List<StructureDefinition> sds, RESOURCE_CATEGORY cat) {
    List<resDef> selSDs = new ArrayList<resDef>();
    sds.forEach((StructureDefinition sd) -> {
      switch(cat) {
        case STRUCTURE_DEFINITION:
          if (getCategory(sd).equals(RESOURCE_CATEGORY.STRUCTURE_DEFINITION))
              selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd), RESOURCE_CATEGORY.STRUCTURE_DEFINITION));
          break;
        case LOGICAL_NAME:
          if (getCategory(sd).equals(RESOURCE_CATEGORY.LOGICAL_NAME))
            selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd), RESOURCE_CATEGORY.LOGICAL_NAME));
          break;
        case EXTENSION:
          if (getCategory(sd).equals(RESOURCE_CATEGORY.EXTENSION))
            selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd), RESOURCE_CATEGORY.EXTENSION));
          break;
        case PROFILE:
          if (getCategory(sd).equals(RESOURCE_CATEGORY.PROFILE))
            selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd), RESOURCE_CATEGORY.PROFILE));
          break;
        default:
          selSDs.add(new resDef(sd.getName(), sd.getUrl(), getSDInfo(sd), getCategory(sd)));

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

  private RESOURCE_CATEGORY getCategory(StructureDefinition sd) {
    if ("Extension".equals(sd.getType()))
      return RESOURCE_CATEGORY.EXTENSION;

    if (sd.getBaseDefinition() == null)
      return RESOURCE_CATEGORY.LOGICAL_NAME;

    if (sd.getType().trim().equals(sd.getName().trim()))
      return RESOURCE_CATEGORY.STRUCTURE_DEFINITION;

    if (!((sd.getBaseDefinition() == null) ||
      ("Extension".equals(sd.getType())) ||
      (sd.getType().trim().equals(sd.getName().trim()))))
       return RESOURCE_CATEGORY.PROFILE;

    return RESOURCE_CATEGORY.META_OR_EXAMPLE_OR_OTHER_IGNORE;
  }

  /**
   * This method is used in testing only - during Resource Constraint translation to ShEx constructs.
   * It can be used by future developers to avoid unnecessary processing of constraints
   * that belong to these Meta Level Resources of FHIR.  This list was created by FHIRCat
   * Project group for testing (fhircat.org).  It does not skip these SDs for the build.
   * @return List of StructureDefinitions at meta Level
   */
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

  /**
   * Structure Definition Information for debug/printing purpose during testing.
   * @param sd  Structure Definition
   * @return  String representation of basic SD Information
   */
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

  /**
   * Utility Print method to print interim resDef object for debug/testing purpose.
   * @param title  title of resDef types (Resources, Extensions, profiles, etc.)
   * @param items List of resDef objects
   */
  public static void printList(String title, List<ShexGeneratorTestUtils.resDef> items) {
    System.out.println("************************************************************************");
    System.out.println("Printing " + title);
    System.out.println("************************************************************************");
    items.forEach((resDef item) -> {
      System.out.println(item.name + " \t[" + item.url + "]\t" + item.info);
    });
  }
}
