package org.hl7.fhir.validation;

import com.google.common.reflect.ClassPath;
import org.hl7.fhir.utilities.UtilitiesTestExecutor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;

public class TestExecutor {

  public static void printClasspath() {

    String classpath = System.getProperty("java.class.path");
    String[] classPathValues = classpath.split(File.pathSeparator);
    System.out.println(Arrays.toString(classPathValues));
    try {

    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();


        contextClassLoader = Thread.currentThread().getContextClassLoader();


      ClassPath classPath = ClassPath.from(contextClassLoader);
      Set<ClassPath.ClassInfo> classes = classPath.getAllClasses();

      for (ClassPath.ClassInfo classInfo : classes) {
        if (classInfo.getName().contains("junit") || classInfo.getName().contains("hl7")) {
          System.out.println(" classInfo: " + classInfo.getName());
        }
      }
    }  catch (IOException e) {
      throw new RuntimeException(e);
    }


  }
  public static void main(String[] args) {
    executeTests();
  }
  public static void executeTests() {
    //printClasspath();

    System.out.println("env : " + System.getenv("java.locale.providers"));
    System.out.println("prop: " + System.getProperty("java.locale.providers"));

    PrintWriter out = new PrintWriter(System.out);
    PrintWriter err = new PrintWriter(System.err);

    //String dir = System.getenv(FHIR_TEST_CASES_ENV);
    //System.out.println("FHIR Test Cases Directory: " + dir);
    new UtilitiesTestExecutor().executeTests();

      System.exit(0);

  }
}
