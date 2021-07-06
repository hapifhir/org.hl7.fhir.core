package org.hl7.fhir.convertors;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import javax.lang.model.element.Modifier;
import java.io.FileWriter;
import java.io.IOException;
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

  public final static String ABS_PATH_BASE = "/home/mark/Documents/Projects/FHIR/temp/";

  public Generator() {
    filePaths = new ArrayList<>();
    filePaths.add("org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_30");
    filePaths.add("org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_40");
    filePaths.add("org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_50");
    filePaths.add("org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv14_30");
    filePaths.add("org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv14_40");
    filePaths.add("org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv14_50");
    filePaths.add("org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv30_40");
    filePaths.add("org.hl7.fhir.core/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv30_50");

    mainFolders = new ArrayList<>();
    mainFolders.add("/datatypes");
    mainFolders.add("/resources");

    subFolders = new ArrayList<>();
    subFolders.add("/general");
    subFolders.add("/metadata");
    subFolders.add("/primitive");
    subFolders.add("/special");

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
      String lastFourDigits = mainDir.substring(mainDir.length() - 5);
      gen.mainFolders.forEach(mainFolder -> {
        createDirectory(mainDir + mainFolder + lastFourDigits);
        if (mainFolder.equals("/datatypes")) {
          try {
            createFile(lastFourDigits,
              mainDir + mainFolder + lastFourDigits,
              ("org/hl7/fhir.convertors/" + "conv" + lastFourDigits + mainFolder + lastFourDigits).replace("/", "."),
              "BackboneElement");
            createFile(lastFourDigits,
              mainDir + mainFolder + lastFourDigits,
              ("org/hl7/fhir.convertors/" + "conv" + lastFourDigits + mainFolder + lastFourDigits).replace("/", "."),
              "Element");
            createFile(lastFourDigits,
              mainDir + mainFolder + lastFourDigits,
              ("org/hl7/fhir.convertors/" + "conv" + lastFourDigits + mainFolder + lastFourDigits).replace("/", "."),
              "Type");
          } catch (IOException e) {
            e.printStackTrace();
          }
          gen.subFolders.forEach(subFolder -> {
            createDirectory(mainDir + mainFolder + lastFourDigits + subFolder + lastFourDigits);
            switch (subFolder) {
              case "/general":
                gen.generalClasses.forEach(className -> {
                  try {
                    createFile(lastFourDigits,
                      mainDir + mainFolder + lastFourDigits + subFolder + lastFourDigits,
                      ("org/hl7/fhir.convertors/" + "conv" + lastFourDigits + mainFolder + lastFourDigits + subFolder + lastFourDigits).replace("/", "."),
                      className);
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                });
                break;
              case "/metadata":
                gen.metaDataClasses.forEach(className -> {
                  try {
                    createFile(lastFourDigits,
                      mainDir + mainFolder + lastFourDigits + subFolder + lastFourDigits,
                      ("org/hl7/fhir.convertors/" + "conv" + lastFourDigits + mainFolder + lastFourDigits + subFolder + lastFourDigits).replace("/", "."),
                      className);
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                });
                break;
              case "/primitive":
                gen.primitiveClasses.forEach(className -> {
                  try {
                    createFile(lastFourDigits,
                      mainDir + mainFolder + lastFourDigits + subFolder + lastFourDigits,
                      ("org/hl7/fhir.convertors/" + "conv" + lastFourDigits + mainFolder + lastFourDigits + subFolder + lastFourDigits).replace("/", "."),
                      className);
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                });
                break;
              case "/special":
                gen.specialClasses.forEach(className -> {
                  try {
                    createFile(lastFourDigits,
                      mainDir + mainFolder + lastFourDigits + subFolder + lastFourDigits,
                      ("org/hl7/fhir.convertors/" + "conv" + lastFourDigits + mainFolder + lastFourDigits + subFolder + lastFourDigits).replace("/", "."),
                      className);
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                });
                break;
              default:
                break;
            }
          });
        }
      });
    });
  }

  public static void createDirectory(String path) {
    System.out.println("creating folder -> " + path);
    File theDir = new File(ABS_PATH_BASE + path);
    if (!theDir.exists()){
      theDir.mkdirs();
    }
  }

  public static void createFile(String version, String path, String packageName, String className) throws IOException {
    TypeSpec typeSpec = TypeSpec.classBuilder(className + version)
      .addModifiers(Modifier.PUBLIC)
      .build();
    JavaFile javaFile = JavaFile.builder(packageName, typeSpec)
      .build();
    FileWriter writer = new FileWriter(ABS_PATH_BASE + path + "/" + className + version + ".java");
    writer.append(javaFile.toString());
    writer.flush();
    writer.close();
    //javaFile.writeTo(new File(ABS_PATH_BASE + path + "/" + className + version));
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
