package org.hl7.fhir.convertors;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {
  List<String> filePaths;
  List<String> mainFolders;
  List<String> subFolders;
  List<String> generalClasses;
  List<String> metaDataClasses;
  List<String> primitiveClasses;
  List<String> specialClasses;
  List<String> datatypeClasses;

  public Generator() {
    filePaths = new ArrayList<>();
    filePaths.add("/home/mark/Documents/Projects/FHIR/temp/org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_30");
    filePaths.add("/home/mark/Documents/Projects/FHIR/temp/org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_40");
    filePaths.add("/home/mark/Documents/Projects/FHIR/temp/org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_50");
    filePaths.add("/home/mark/Documents/Projects/FHIR/temp/org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv14_30");
    filePaths.add("/home/mark/Documents/Projects/FHIR/temp/org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv14_40");
    filePaths.add("/home/mark/Documents/Projects/FHIR/temp/org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv14_50");
    filePaths.add("/home/mark/Documents/Projects/FHIR/temp/org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv30_40");
    filePaths.add("/home/mark/Documents/Projects/FHIR/temp/org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv30_50");

    mainFolders = new ArrayList<>();
    mainFolders.add("/datatypes");
    mainFolders.add("/resources");

    subFolders = new ArrayList<>();
    mainFolders.add("/general");
    mainFolders.add("/metadata");
    mainFolders.add("/primitive");
    mainFolders.add("/special");

    generalClasses = new ArrayList<>();
    generalClasses.add("Address");
    generalClasses.add("Age");
    generalClasses.add("Annotation");
    generalClasses.add("Attachment");
    generalClasses.add("CodeableConcept");
    generalClasses.add("Coding");
    generalClasses.add("ContactPoint");
    generalClasses.add("Count");
    generalClasses.add("Distance");
    generalClasses.add("Duration");
    generalClasses.add("HumanName");
    generalClasses.add("Identifier");
    generalClasses.add("Money");
    generalClasses.add("MoneyQuantity");
    generalClasses.add("Period");
    generalClasses.add("Quantity");
    generalClasses.add("Range");
    generalClasses.add("Ratio");
    generalClasses.add("SampledData");
    generalClasses.add("Signature");
    generalClasses.add("SimpleQuantity");
    generalClasses.add("Timing");

    metaDataClasses = new ArrayList<>();
    metaDataClasses.add("ContactDetail");
    metaDataClasses.add("Contributor");
    metaDataClasses.add("DataRequirement");
    metaDataClasses.add("Expression");
    metaDataClasses.add("ParameterDefinition");
    metaDataClasses.add("RelatedArtifact");
    metaDataClasses.add("TriggerDefinition");
    metaDataClasses.add("UsageContext");

    primitiveClasses = new ArrayList<>();
    primitiveClasses.add("Base64Binary");
    primitiveClasses.add("Boolean");
    primitiveClasses.add("Canonical");
    primitiveClasses.add("Code");
    primitiveClasses.add("Date");
    primitiveClasses.add("DateTime");
    primitiveClasses.add("Decimal");
    primitiveClasses.add("Id");
    primitiveClasses.add("Instant");
    primitiveClasses.add("Integer");
    primitiveClasses.add("MarkDown");
    primitiveClasses.add("Oid");
    primitiveClasses.add("PositiveInt");
    primitiveClasses.add("String");
    primitiveClasses.add("Time");
    primitiveClasses.add("UnsignedInt");
    primitiveClasses.add("Uri");
    primitiveClasses.add("Url");
    primitiveClasses.add("Uuid");

    specialClasses = new ArrayList<>();
    specialClasses.add("Dosage");
    specialClasses.add("ElementDefinition");
    specialClasses.add("Extension");
    specialClasses.add("Meta");
    specialClasses.add("Narrative");
    specialClasses.add("Reference");
    specialClasses.add("xhtml");

    datatypeClasses = new ArrayList<>();
    datatypeClasses.add("BackboneElement");
    datatypeClasses.add("Element");
    datatypeClasses.add("Type");
  }

  public static void main(String[] args) {
    Generator generator = new Generator();
    generateFoldersForVersion(generator);

  }

  public static void generateFoldersForVersion(Generator gen) {
    gen.filePaths.forEach(mainDir -> {
      gen.mainFolders.forEach(mainFolder -> {
        createDirectory(mainDir + mainFolder);
        if (mainFolder.equals("/datatypes")) {
          gen.subFolders.forEach(subFolder -> {
            createDirectory(mainDir + mainFolder + subFolder);
          });
        }
      });
    });

  }

  public static void createDirectory(String path) {
    File theDir = new File(path);
    if (!theDir.exists()){
      theDir.mkdirs();
    }
  }

  public static void listAllFilesInDirectory(String path) {
    // Creates an array in which we will store the names of files and directories
    List<File> pathnames;

    // Creates a new File instance by converting the given pathname string
    // into an abstract pathname
    File f = new File(path);

    // Populates the array with names of files and directories
    pathnames = Arrays.stream(f.listFiles()).filter(file -> file.getName().contains("conv")).filter(file -> !file.getName().equals("conv40_50")).collect(Collectors.toList());

    pathnames.forEach(System.out::println);
  }
}
