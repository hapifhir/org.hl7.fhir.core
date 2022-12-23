package org.hl7.fhir.r5.profiles;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.profilemodel.ProfiledElement;
import org.hl7.fhir.r5.profilemodel.ProfiledElementBuilder;
import org.hl7.fhir.r5.test.utils.TestPackageLoader;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfiledElementTests {


  @Test
  public void testPatientCore() throws IOException {
    IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
    FilesystemPackageCacheManager pc = new FilesystemPackageCacheManager(true);
    NpmPackage npm = pc.loadPackage("hl7.fhir.us.core", "5.0.0");
    ctxt.loadFromPackage(npm, new TestPackageLoader(new String[] { "StructureDefinition" }));
    
    ProfiledElement pe = new ProfiledElementBuilder(ctxt).buildProfileElement("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
    
    Assertions.assertEquals("USCorePatientProfile", pe.name());
    Assertions.assertEquals("Patient", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(Integer.MAX_VALUE, pe.max());
    Assertions.assertEquals("Patient", pe.types().get(0));
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Information about an individual or animal receiving health care services", pe.shortDocumentation());
    Assertions.assertEquals("\\-", pe.documentation());

    List<ProfiledElement> children = pe.children("Patient");
    Assertions.assertEquals(27, children.size());
    
    pe = children.get(8);
    Assertions.assertEquals("us-core-birthsex", pe.name());
    Assertions.assertEquals("extension", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(1, pe.max());
    Assertions.assertEquals("code", pe.types().get(0));
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Information about an individual or animal receiving health care services", pe.shortDocumentation());
    Assertions.assertEquals("\\-", pe.documentation());

    pe = children.get(7);
    
    Assertions.assertEquals("ethnicity", pe.name());
    Assertions.assertEquals("extension", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(1, pe.max());
    Assertions.assertEquals("extension", pe.types().get(0));
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Information about an individual or animal receiving health care services", pe.shortDocumentation());
    Assertions.assertEquals("\\-", pe.documentation());

    
  }
}
