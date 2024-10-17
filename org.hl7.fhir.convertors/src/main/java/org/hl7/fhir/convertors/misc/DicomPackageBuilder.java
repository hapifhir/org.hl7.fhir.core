package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.utils.NPMPackageGenerator;
import org.hl7.fhir.r4.utils.NPMPackageGenerator.Category;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DicomPackageBuilder {
  
  private String version;
  private String dest;
  private String source;
  private String pattern = "fhir.dicom#{version}.tgz";

  public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
    if (args.length == 0 || args[0].equals("-help")) {
      System.out.println("Dicom Package Builder");
      System.out.println("");
      System.out.println("Before running, use FTP get the latest copy of ftp://medical.nema.org/MEDICAL/Dicom/Resources");
      System.out.println("Then run with the following parameters (in order):");
      System.out.println("1. the local folder that contains the copy of the FTP folder");
      System.out.println("2. the local folder to put the package when it's created");
      System.out.println("");
      System.out.println("For help, see ");
      return;      
    }
    String source = args[0];
    String dest = args[1];
    
    DicomPackageBuilder self = new DicomPackageBuilder();
    self.setSource(source);
    self.setDest(dest);
    self.setPattern("{version}/package.tgz");
    self.execute();
  }

  public void execute() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
    CodeSystem cs = buildCodeSystem();
    String fn = Utilities.path(dest, pattern.replace("{version}", version));
    Utilities.createDirectory(Utilities.getDirectoryForFile(fn));
    
    NPMPackageGenerator gen = new NPMPackageGenerator(fn, buildPackage());
    int i = 2;
    gen.addFile(Category.RESOURCE, "CodeSystem-"+cs.getId()+".json", new JsonParser().setOutputStyle(OutputStyle.NORMAL).composeBytes(cs));
    ValueSet vs = buildAllValueSet();
    gen.addFile(Category.RESOURCE, "ValueSet-"+vs.getId()+".json", new JsonParser().setOutputStyle(OutputStyle.NORMAL).composeBytes(vs));
    Set<String> ids = new HashSet<>();
    ids.add(vs.getId());
    
    for (File f : ManagedFileAccess.file(Utilities.path(source, "Resources", "valuesets", "fhir", "json")).listFiles()) {
      vs = (ValueSet) JsonParser.loadFile(ManagedFileAccess.inStream(f));
      vs.setVersion(version);
      if (vs.getId().length() > 64) {
        vs.setId(vs.getId().substring(0, 64));
      }
      if (ids.contains(vs.getId())) {
        throw new Error("Duplicate Id (note Ids cut off at 64 char): "+vs.getId());
      }
      ids.add(vs.getId());
      gen.addFile(Category.RESOURCE, "ValueSet-"+vs.getId()+".json", new JsonParser().setOutputStyle(OutputStyle.NORMAL).composeBytes(vs));
      i++;
    }
    gen.finish();
    System.out.println("Finished - "+i+" resources");
    
  }

  private ValueSet buildAllValueSet() {
    ValueSet vs = new ValueSet();
    vs.setId("all");
    vs.setUrl("http://dicom.nema.org/resources/ValueSet/all");
    vs.setVersion(version);
    vs.setName("AllDICOMTerminologyDefinitions");
    vs.setTitle("All DICOM Controlled Terminology Definitions");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.setExperimental(false);
    vs.setPublisher("FHIR Project on behalf of DICOM");
    vs.setDate(new Date());
    vs.setDescription("All DICOM Code Definitions (Coding Scheme Designator \"DCM\" Coding Scheme Version "+version);
    vs.setPurpose("This value set is published as part of FHIR in order to make the codes available to FHIR terminology services and so implementers can easily leverage the codes");
    vs.setCopyright("These codes are excerpted from Digital Imaging and Communications in Medicine (DICOM) Standard, Part 16: Content Mapping Resource, Copyright Â© 2011 by the National Electrical Manufacturers Association.");

    vs.getCompose().getIncludeFirstRep().setSystem("http://dicom.nema.org/resources/ontology/DCM");
    return vs;
  }

  private JsonObject buildPackage() {
    JsonObject npm = new JsonObject();
    npm.addProperty("tools-version", 3);
    npm.addProperty("type", "Conformance");
    npm.addProperty("license", "free");
    npm.addProperty("author", "FHIR Project for DICOM");
    npm.addProperty("name", "fhir.dicom");
    npm.addProperty("url", "http://fhir.org/packages/fhir.dicom");
    npm.addProperty("canonical", "http://fhir.org/packages/fhir.dicom");
    npm.addProperty("version", version);
    JsonArray fv = new JsonArray();
    npm.add("fhirVersions", fv);
    fv.add("4.0.1");
    JsonObject dep = new JsonObject();
    npm.add("dependencies", dep);
    dep.addProperty("hl7.fhir.r4.core", "4.0.1");
    return npm;
  }

  private CodeSystem buildCodeSystem() throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
    DocumentBuilderFactory factory = XMLUtil.newXXEProtectedDocumentBuilderFactory();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(ManagedFileAccess.inStream(Utilities.path(source, "Resources", "Ontology", "DCM", "dcm.owl")));
    Element rdf = doc.getDocumentElement();
    Element d = XMLUtil.getFirstChild(rdf);
    version = processVersion(XMLUtil.getNamedChildText(d, "versionInfo"));
    
    CodeSystem cs = new CodeSystem();
    cs.setId("DCM");
    cs.setUrl("http://dicom.nema.org/resources/ontology/DCM");
    cs.setVersion(version);
    cs.setName("DICOMTerminologyDefinitions");
    cs.setTitle("DICOM Controlled Terminology Definitions");
    cs.getIdentifier().add(new Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:1.2.840.10008.2.16.4"));
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setExperimental(false);
    cs.setPublisher("FHIR Project on behalf of DICOM");
    cs.setDate(new Date());
    cs.setDescription("DICOM Code Definitions (Coding Scheme Designator \"DCM\" Coding Scheme Version "+version);
    cs.setPurpose("This code system is published as part of FHIR in order to make the codes available to FHIR terminology services and so implementers can easily leverage the codes");
    cs.setCopyright("These codes are excerpted from Digital Imaging and Communications in Medicine (DICOM) Standard, Part 16: Content Mapping Resource, Copyright Â© 2011 by the National Electrical Manufacturers Association.");
    cs.setCaseSensitive(true);
    cs.setValueSet("http://dicom.nema.org/resources/ValueSet/all");
    cs.setContent(CodeSystemContentMode.COMPLETE);
    
    d = XMLUtil.getNextSibling(d);
    while (d != null) {
      String code = XMLUtil.getNamedChildText(d, "notation");
      String display = XMLUtil.getNamedChildText(d, "prefLabel");
      String definition = XMLUtil.getNamedChildText(d, "definition");
      ConceptDefinitionComponent cc = new ConceptDefinitionComponent();
      cs.getConcept().add(cc);
      cc.setCode(code);
      cc.setDisplay(display);
      cc.setDefinition(definition);
      d = XMLUtil.getNextSibling(d);
    }
    return cs;
  }

  private String processVersion(String s) {
    String[] p = s.split("\\_");
    return p[0].substring(0, 4)+"."+(1+(p[0].charAt(4) - 'a'))+"."+p[1];
  }

  public void setDest(String dest) {
    this.dest = dest;    
  }

  public void setSource(String source) {
    this.source = source;
  }

  public void setPattern(String pattern) {
    this.pattern  = pattern;
    
  }
}
