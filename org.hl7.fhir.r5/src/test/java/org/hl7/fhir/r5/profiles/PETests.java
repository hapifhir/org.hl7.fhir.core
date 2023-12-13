package org.hl7.fhir.r5.profiles;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Observation;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.profilemodel.PEDefinition;
import org.hl7.fhir.r5.profilemodel.PEInstance;
import org.hl7.fhir.r5.profilemodel.PEType;
import org.hl7.fhir.r5.profilemodel.gen.PECodeGenerator;
import org.hl7.fhir.r5.profilemodel.gen.PECodeGenerator.ExtensionPolicy;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.profilemodel.PEInstance.PEInstanceDataKind;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestPackageLoader;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PETests {


  private IWorkerContext ctxt;


  public void load() throws IOException {
    if (ctxt == null) {
      ctxt = TestingUtilities.getSharedWorkerContext();
      FilesystemPackageCacheManager pc = new FilesystemPackageCacheManager.Builder().build();
      NpmPackage npm = pc.loadPackage("hl7.fhir.us.core", "5.0.0");
      ctxt.loadFromPackage(npm, new TestPackageLoader(Utilities.strings("StructureDefinition" )));
      
      ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResource("r5", "profiles", "pe-extension-simple.json")));
      ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResource("r5", "profiles", "pe-extension-complex.json")));
      ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResource("r5", "profiles", "pe-profile2.json")));
      ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResource("r5", "profiles", "pe-profile1.json")));
    }
  }


  @Test
  public void testProfile() throws IOException {
    load();
    PEDefinition pe = new PEBuilder(ctxt, PEElementPropertiesPolicy.EXTENSION, true).buildPEDefinition("http://hl7.org/fhir/test/StructureDefinition/pe-profile1");

    Assertions.assertEquals("TestProfile", pe.name());
    Assertions.assertEquals("Observation", pe.schemaName());
    Assertions.assertEquals(0, pe.min());
    Assertions.assertEquals(Integer.MAX_VALUE, pe.max());
    Assertions.assertEquals("Observation", pe.types().get(0).getType());
    Assertions.assertEquals("TestProfile", pe.types().get(0).getName());
    Assertions.assertNotNull(pe.definition());
    Assertions.assertNotNull(pe.baseDefinition());
    Assertions.assertEquals("Test Observation Profile", pe.shortDocumentation());
    Assertions.assertEquals("Test Observation Profile.", pe.documentation());

    List<PEDefinition> children = pe.children("Observation");
    
    checkElement(pe, "Observation", "TestProfile", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/test/StructureDefinition/pe-profile1", 18, "Observation");
    checkElement(children.get(0), "id", "id", 0, 1, false, null, 0, "id");
    checkElement(children.get(1), "meta", "meta", 0, 1, false, "http://hl7.org/fhir/StructureDefinition/Meta", 7, "meta");
    checkElement(children.get(2), "language", "language", 0, 1, false, "http://hl7.org/fhir/StructureDefinition/code", 2, "language");
    checkElement(children.get(3), "text", "text", 0, 1, false, "http://hl7.org/fhir/StructureDefinition/Narrative", 3, "text");
    checkElement(children.get(4), "contained", "contained", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/StructureDefinition/Resource", 4, "contained");
    checkElement(children.get(5), "extension", "extension", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/StructureDefinition/Extension", 3, "extension.where(((url = 'http://hl7.org/fhir/test/StructureDefinition/pe-extension-simple') or (url = 'http://hl7.org/fhir/test/StructureDefinition/pe-extension-complex')).not())");
    checkElement(children.get(6), "extension", "simple", 0, 1, false, "http://hl7.org/fhir/StructureDefinition/code", 2, "extension('http://hl7.org/fhir/test/StructureDefinition/pe-extension-simple').value");
    checkElement(children.get(7), "extension", "complex", 0, 1, false, "http://hl7.org/fhir/test/StructureDefinition/pe-extension-complex", 4, "extension('http://hl7.org/fhir/test/StructureDefinition/pe-extension-complex')");
    checkElement(children.get(8), "identifier", "identifier", 0, 1, false, "http://hl7.org/fhir/StructureDefinition/Identifier", 7, "identifier");
    checkElement(children.get(9), "status", "status", 1, 1, true, "http://hl7.org/fhir/StructureDefinition/code", 2, "status");
    checkElement(children.get(10), "category", "category", 1, 1, false, "http://hl7.org/fhir/StructureDefinition/CodeableConcept", 3, "category");
    checkElement(children.get(11), "code", "code", 1, 1, true, "http://hl7.org/fhir/StructureDefinition/CodeableConcept", 3, "code");
    checkElement(children.get(12), "subject", "subject", 1, 1, false, "http://hl7.org/fhir/StructureDefinition/Reference", 5, "subject");
    checkElement(children.get(13), "encounter", "encounter", 0, 1, false, "http://hl7.org/fhir/StructureDefinition/Reference", 5, "encounter");
    checkElement(children.get(14), "effective[x]", "effective[x]", 1, 1, false, "http://hl7.org/fhir/StructureDefinition/dateTime", 2, "effective");
    checkElement(children.get(15), "issued", "issued", 0, 1, false, "http://hl7.org/fhir/StructureDefinition/instant", 2, "issued");
    checkElement(children.get(16), "performer", "performer", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/StructureDefinition/Reference", 5, "performer");
    checkElement(children.get(17), "value[x]", "valueCodeableConcept", 0, 1, false, "http://hl7.org/fhir/test/StructureDefinition/pe-profile2", 4, "value.ofType(CodeableConcept)");

    List<PEDefinition> gchildren = children.get(11).children();
    checkElement(gchildren.get(0), "extension", "extension", 0, Integer.MAX_VALUE, true, "http://hl7.org/fhir/StructureDefinition/Extension", 3, "extension");
    checkElement(gchildren.get(1), "coding", "coding", 0, Integer.MAX_VALUE, true, "http://hl7.org/fhir/StructureDefinition/Coding", 6, "coding");
    checkElement(gchildren.get(2), "text", "text", 0, 1, true, "http://hl7.org/fhir/StructureDefinition/string", 2, "text");
    

    gchildren = children.get(17).children("http://hl7.org/fhir/test/StructureDefinition/pe-profile2");
    checkElement(gchildren.get(0), "coding", "coding", 1, 2, false, "http://hl7.org/fhir/StructureDefinition/Coding", 6, "coding.where(((system = 'http://snomed.info/sct') or (system = 'http://loinc.org')).not())");
    checkElement(gchildren.get(1), "coding", "snomedct", 1, 1, false, "http://hl7.org/fhir/StructureDefinition/Coding", 5, "coding.where(system = 'http://snomed.info/sct')");
    checkElement(gchildren.get(2), "coding", "loinc", 0, 1, false, "http://hl7.org/fhir/StructureDefinition/Coding", 5, "coding.where(system = 'http://loinc.org')");
    checkElement(gchildren.get(3), "text", "text", 1, 1, false, "http://hl7.org/fhir/StructureDefinition/string", 2, "text");
    
    List<PEDefinition> ggchildren = gchildren.get(3).children("http://hl7.org/fhir/StructureDefinition/string");
    checkElement(ggchildren.get(0), "extension", "extension", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/StructureDefinition/Extension", 3, "extension");
    checkElement(ggchildren.get(1), "value", "value", 1, 1, false, null, 3, "value");
    
    gchildren = children.get(7).children("http://hl7.org/fhir/StructureDefinition/Extension");
    checkElement(gchildren.get(0), "extension", "extension", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/StructureDefinition/Extension", 3, "extension.where(((url = 'slice1') or (url = 'slice2') or (url = 'slice3')).not())");
    checkElement(gchildren.get(1), "extension", "slice1", 0, 2, false, "http://hl7.org/fhir/StructureDefinition/Coding", 6, "extension('slice1').value");
    checkElement(gchildren.get(2), "extension", "slice2", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/StructureDefinition/string", 2, "extension('slice2').value");
    checkElement(gchildren.get(3), "extension", "slice3", 1, 1, false, "http://hl7.org/fhir/StructureDefinition/Extension", 3, "extension('slice3')");

    ggchildren = gchildren.get(3).children("http://hl7.org/fhir/StructureDefinition/Extension");
    checkElement(ggchildren.get(0), "extension", "extension", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/StructureDefinition/Extension", 3, "extension");
    checkElement(ggchildren.get(1), "extension", "slice3a", 0, 2, false, "http://hl7.org/fhir/StructureDefinition/Coding", 6, "extension('slice3a').value");
    checkElement(ggchildren.get(2), "extension", "slice3b", 0, Integer.MAX_VALUE, false, "http://hl7.org/fhir/StructureDefinition/string", 2, "extension('slice3b').value");
  }

  private void checkElement(PEDefinition pe, String schemaName, String name, int min, int max, boolean fixed, String type, int children, String fhirpath) {
    Assertions.assertEquals(name, pe.name());
    Assertions.assertEquals(schemaName, pe.schemaName());
    Assertions.assertEquals(min, pe.min());
    Assertions.assertEquals(max, pe.max());
    Assertions.assertEquals(fixed, pe.hasFixedValue() || pe.isInFixedValue());
    if (type != null) {
      Assertions.assertEquals(1, pe.types().size());
      Assertions.assertEquals(type, pe.types().get(0).getUrl());
      List<PEDefinition> children2 = pe.children(type);
      Assertions.assertEquals(children, children2.size());
    }
    Assertions.assertEquals(fhirpath, pe.fhirpath());
  }


  @Test
  public void testUSPatientCore() throws IOException {
    load();
    
    PEDefinition pe = new PEBuilder(ctxt, PEElementPropertiesPolicy.EXTENSION_ID, false).buildPEDefinition("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
    
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
    Assertions.assertEquals("USCoreEthnicityExtension", pe.types().get(0).getName());
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
    Assertions.assertEquals("May be used to represent additional information that is not part of the basic definition of the resource. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", pe.documentation());

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
    Assertions.assertEquals("May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", pe.documentation());


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
    Assertions.assertEquals("May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", pe.documentation());

  }

  @Test
  public void dumpUSPatientCore() throws IOException {
    load();
    
    PEDefinition pe = new PEBuilder(ctxt, PEElementPropertiesPolicy.NONE, false).buildPEDefinition("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
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

  @Test
  public void testCreate() throws IOException {
    load();
    
    Observation res = (Observation) new PEBuilder(ctxt, PEElementPropertiesPolicy.NONE, false).createResource("http://hl7.org/fhir/test/StructureDefinition/pe-profile1", true);
    Assertions.assertEquals("http://hl7.org/fhir/test/StructureDefinition/pe-profile1", res.getMeta().getProfile().get(0).primitiveValue());
    Assertions.assertEquals("final", res.getStatusElement().asStringValue());
    Assertions.assertEquals("76690-7", res.getCode().getCodingFirstRep().getCode());
    
    String json = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(res);
    System.out.println(json);
  }


  @Test
  public void testLoad() throws IOException {
    load();
    
    Resource res = new JsonParser().parse(TestingUtilities.loadTestResource("r5", "pe-observation-1.json"));
    PEInstance obs = new PEBuilder(ctxt, PEElementPropertiesPolicy.EXTENSION, true).buildPEInstance("http://hl7.org/fhir/test/StructureDefinition/pe-profile1", res);
    
    PEInstance status = obs.child("status");
    Assertions.assertNotNull(status);
    Assertions.assertEquals("TestProfile.status", status.getPath());
    Assertions.assertEquals(PEInstanceDataKind.Primitive, status.getDataKind());
    Assertions.assertEquals("final", status.asDataType().primitiveValue());
    Assertions.assertEquals("final", status.getPrimitiveAsString());

    PEInstance code = obs.child("code");
    Assertions.assertNotNull(code);
    Assertions.assertEquals("TestProfile.code", code.getPath());
    Assertions.assertEquals(PEInstanceDataKind.DataType, code.getDataKind());
    Assertions.assertEquals("76690-7", code.asCodeableConcept().getCodingFirstRep().getCode());

    PEInstance simple = obs.child("simple");
    Assertions.assertNotNull(simple);
    Assertions.assertEquals("TestProfile.simple", simple.getPath());
    Assertions.assertEquals(PEInstanceDataKind.Primitive, simple.getDataKind());
    Assertions.assertEquals("14647-2", simple.getPrimitiveAsString());

    PEInstance complex = obs.child("complex");
    Assertions.assertNotNull(complex);
    Assertions.assertEquals("TestProfile.complex", complex.getPath());
    Assertions.assertEquals(PEInstanceDataKind.DataType, complex.getDataKind());

    PEInstance slice1 = complex.child("slice1");
    Assertions.assertNotNull(slice1);
    Assertions.assertEquals("TestProfile.complex.slice1[0]", slice1.getPath());
    Assertions.assertEquals(PEInstanceDataKind.DataType, slice1.getDataKind());
    Assertions.assertEquals("18767-4", ((Coding) slice1.asDataType()).getCode());
    
    PEInstance slice2 = complex.child("slice2");
    Assertions.assertNotNull(slice2);
    Assertions.assertEquals("TestProfile.complex.slice2[0]", slice2.getPath());
    Assertions.assertEquals(PEInstanceDataKind.Primitive, slice2.getDataKind());
    Assertions.assertEquals("A string value", slice2.getPrimitiveAsString());
    
    PEInstance slice3 = complex.child("slice3");
    Assertions.assertNotNull(slice3);
    Assertions.assertEquals("TestProfile.complex.slice3", slice3.getPath());
  }

  @Test
  public void testGenerate() throws IOException {
    load();
    PECodeGenerator gen = new PECodeGenerator(ctxt);
    
    gen.setFolder(Utilities.path("[tmp]"));
    gen.setExtensionPolicy(ExtensionPolicy.Complexes);
    gen.setNarrative(false);
    gen.setMeta(false);
    gen.setLanguage("en-AU");
    gen.setContained(false);
    gen.setKeyElementsOnly(true);
    gen.setGenDate("{date}");
    
    gen.setCanonical("http://hl7.org/fhir/test/StructureDefinition/pe-profile1");
    gen.setPkgName("org.hl7.fhir.r5.profiles");
    gen.execute();    
    gen.setCanonical("http://hl7.org/fhir/test/StructureDefinition/pe-profile2");
    gen.execute();    
    gen.setCanonical("http://hl7.org/fhir/test/StructureDefinition/pe-extension-complex");
    gen.execute();    
    
    checkGeneratedJava("TestComplexExtension");
    checkGeneratedJava("TestDatatypeProfile");
    checkGeneratedJava("TestProfile");
  }


  private void checkGeneratedJava(String name) throws FileNotFoundException, IOException {
    String actual = Utilities.normalize(TextFile.fileToString(Utilities.path("[tmp]", name+".java")));
    String expected = Utilities.normalize(TestingUtilities.loadTestResource("r5", "profiles", name+".java"));
    String msg = CompareUtilities.checkTextIsSame(expected, actual);
    if (msg != null) {      
      Assertions.fail("Generated code for "+name+" is different: "+msg);
    }
  }

}
