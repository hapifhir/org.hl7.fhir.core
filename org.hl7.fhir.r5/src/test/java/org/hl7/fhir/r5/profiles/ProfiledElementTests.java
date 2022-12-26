package org.hl7.fhir.r5.profiles;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.profilemodel.PEDefinition;
import org.hl7.fhir.r5.profilemodel.PEType;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.test.utils.TestPackageLoader;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfiledElementTests {


  private IWorkerContext ctxt;


  public void load() throws IOException {
    if (ctxt == null) {
      ctxt = TestingUtilities.getSharedWorkerContext();
      FilesystemPackageCacheManager pc = new FilesystemPackageCacheManager(true);
      NpmPackage npm = pc.loadPackage("hl7.fhir.us.core", "5.0.0");
      ctxt.loadFromPackage(npm, new TestPackageLoader(new String[] { "StructureDefinition" }));
    }
  }
  
  
  @Test
  public void testUSPatientCore() throws IOException {
    load();
    
    PEDefinition pe = new PEBuilder(ctxt, true).buildPEDefinition("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
    
    Assertions.assertEquals("USCorePatientProfile", pe.name());
    Assertions.assertEquals("Patient", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(Integer.MAX_VALUE, pe.max());
    Assertions.assertEquals("Patient", pe.types().get(0).getType());
    Assertions.assertEquals("USCorePatientProfile", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Information about an individual or animal receiving health care services", pe.shortDocumentation());
    Assertions.assertEquals("\\-", pe.documentation());

    List<PEDefinition> children = pe.children("Patient");
    Assertions.assertEquals(28, children.size());
    
    pe = children.get(9);
    Assertions.assertEquals("birthsex", pe.name());
    Assertions.assertEquals("extension", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(1, pe.max());
    Assertions.assertEquals("code", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Extension", pe.shortDocumentation());
    Assertions.assertEquals("A code classifying the person's sex assigned at birth  as specified by the [Office of the National Coordinator for Health IT (ONC)](https://www.healthit.gov/newsroom/about-onc).", pe.documentation());

    pe = children.get(8);
    
    Assertions.assertEquals("ethnicity", pe.name());
    Assertions.assertEquals("extension", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(1, pe.max());
    Assertions.assertEquals("Extension", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("US Core ethnicity Extension", pe.shortDocumentation());
    Assertions.assertEquals("Concepts classifying the person into a named category of humans sharing common history, traits, geographical origin or nationality.  The ethnicity codes used to represent these concepts are based upon the [CDC ethnicity and Ethnicity Code Set Version 1.0](http://www.cdc.gov/phin/resources/vocabulary/index.html) which includes over 900 concepts for representing race and ethnicity of which 43 reference ethnicity.  The ethnicity concepts are grouped by and pre-mapped to the 2 OMB ethnicity categories: - Hispanic or Latino - Not Hispanic or Latino.", pe.documentation());

    pe = children.get(12);
    
    Assertions.assertEquals("identifier", pe.name());
    Assertions.assertEquals("identifier", pe.schemaName());
    Assertions.assertEquals(1, pe.min());
    Assertions.assertEquals(Integer.MAX_VALUE, pe.max());
    Assertions.assertEquals("Identifier", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("An identifier for this patient", pe.shortDocumentation());
    Assertions.assertEquals("An identifier for this patient.", pe.documentation());


    List<PEDefinition> iChildren = pe.children("http://hl7.org/fhir/StructureDefinition/Identifier");
    Assertions.assertEquals(8, iChildren.size());
    

    pe = iChildren.get(2);
    
    Assertions.assertEquals("use", pe.name());
    Assertions.assertEquals("use", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(1, pe.max());
    Assertions.assertEquals("code", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("usual | official | temp | secondary | old (If known)", pe.shortDocumentation());
    Assertions.assertEquals("The purpose of this identifier.", pe.documentation());

    iChildren = pe.children("http://hl7.org/fhir/StructureDefinition/code");
    Assertions.assertEquals(3, iChildren.size());

    pe = iChildren.get(2);
    Assertions.assertEquals("value", pe.name());
    Assertions.assertEquals("value", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(1, pe.max());
    Assertions.assertEquals(0, pe.types().size());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Primitive value for code", pe.shortDocumentation());
    Assertions.assertEquals("Primitive value for code", pe.documentation());

    pe = iChildren.get(0);
    Assertions.assertEquals("id", pe.name());
    Assertions.assertEquals("id", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(1, pe.max());
    Assertions.assertEquals(0, pe.types().size());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("xml:id (or equivalent in JSON)", pe.shortDocumentation());
    Assertions.assertEquals("unique id for the element within a resource (for internal references)", pe.documentation());

    // let's go down the rabbit hole
    pe = iChildren.get(1);
    Assertions.assertEquals("extension", pe.name());
    Assertions.assertEquals("extension", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(Integer.MAX_VALUE, pe.max());
    Assertions.assertEquals("Extension", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Additional content defined by implementations", pe.shortDocumentation());
    Assertions.assertEquals("May be used to represent additional information that is not part of the basic definition of the resource. To make the use of extensions safe and manageable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", pe.documentation());

    iChildren = pe.children("http://hl7.org/fhir/StructureDefinition/Extension");
    Assertions.assertEquals(4, iChildren.size());
    pe = iChildren.get(1);
    Assertions.assertEquals("extension", pe.name());
    Assertions.assertEquals("extension", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(Integer.MAX_VALUE, pe.max());
    Assertions.assertEquals("Extension", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Additional content defined by implementations", pe.shortDocumentation());
    Assertions.assertEquals("May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and manageable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", pe.documentation());


    iChildren = pe.children("http://hl7.org/fhir/StructureDefinition/Extension");
    Assertions.assertEquals(4, iChildren.size());
    pe = iChildren.get(1);
    Assertions.assertEquals("extension", pe.name());
    Assertions.assertEquals("extension", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(Integer.MAX_VALUE, pe.max());
    Assertions.assertEquals("Extension", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Additional content defined by implementations", pe.shortDocumentation());
    Assertions.assertEquals("May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and manageable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", pe.documentation());

  }

  @Test
  public void dumpUSPatientCore() throws IOException {
    load();
    
    PEDefinition pe = new PEBuilder(ctxt, false).buildPEDefinition("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
    dump(pe, "");
  }


  private void dump(PEDefinition pe, String indent) {
    System.out.println(indent+pe.toString());
    if (!pe.isRecursing() && indent.length() < 20) {
      if (pe.types().size() == 1) {
        for (PEDefinition p : pe.children(pe.types().get(0).getUrl())) {
          dump(p, indent+"  ");
        }
      } else {
        for (PEType t : pe.types()) {
          System.out.println(indent+"  +type:"+t.getName());
          for (PEDefinition p : pe.children(t.getUrl())) {
            dump(p, indent+"    ");
          }
        }
      }
    }
  }    

}
