package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class OIDAssigner {


  public static void main(String[] args) throws Exception {
    new OIDAssigner().execute(args[0], args[1], args[2]);
  }

  private void execute(String oidSource, String folder, String version) throws IOException {
   IniFile oids = new IniFile(oidSource);
   File f = ManagedFileAccess.file(folder);
   process(oids, f, version);
  }

  private void process(IniFile oids, File folder, String version) {
    for (File f : folder.listFiles()) {
      if (f.isDirectory()) {
        if (!Utilities.existsInList(f.getName(), "invariant-tests")) {
          process(oids, f, version);
        }
      } else if (f.getName().endsWith(".xml")) {
        processFile(oids, f, version, FhirFormat.XML);
      } else if (f.getName().endsWith(".json")) {
        processFile(oids, f, version, FhirFormat.JSON);
      }
    }    
  }

  private void processFile(IniFile oids, File f, String version, FhirFormat fmt) {
    switch (VersionUtilities.getMajMin(version)) {
    case "1.0" : processFileR2(oids, f, fmt);
    case "3.0" : processFileR3(oids, f, fmt);
    case "4.0" : processFileR4(oids, f, fmt);
    case "4.3" : processFileR4B(oids, f, fmt);
    case "5.0" : processFileR5(oids, f, fmt);
    }    
  }

  private void processFileR2(IniFile oids, File f, FhirFormat fmt) {
    org.hl7.fhir.dstu2.formats.IParser parser = fmt == FhirFormat.JSON ? new  org.hl7.fhir.dstu2.formats.JsonParser() : new org.hl7.fhir.dstu2.formats.XmlParser();
    try {
      boolean save = false;
      org.hl7.fhir.dstu2.model.Resource r = parser.parse(ManagedFileAccess.inStream(f));
      if (r instanceof org.hl7.fhir.dstu2.model.ValueSet) { 
        org.hl7.fhir.dstu2.model.ValueSet vs = (org.hl7.fhir.dstu2.model.ValueSet) r;
        boolean hasOid = isOid(vs.getIdentifier());
        if (!hasOid) {
          String oid = getOid(oids, "ValueSet", vs.getUrl());
          vs.setIdentifier(new org.hl7.fhir.dstu2.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (r instanceof org.hl7.fhir.dstu2.model.ConceptMap) { 
        org.hl7.fhir.dstu2.model.ConceptMap cm = (org.hl7.fhir.dstu2.model.ConceptMap) r;
        boolean hasOid = isOid(cm.getIdentifier());
        if (!hasOid) {
          String oid = getOid(oids, "ConceptMap", cm.getUrl());
          cm.setIdentifier(new org.hl7.fhir.dstu2.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (r instanceof org.hl7.fhir.dstu2.model.StructureDefinition) { 
        org.hl7.fhir.dstu2.model.StructureDefinition sd = (org.hl7.fhir.dstu2.model.StructureDefinition) r;
        boolean hasOid = false;
        for (org.hl7.fhir.dstu2.model.Identifier id : sd.getIdentifier()) {
          if (isOid(id)) {
            hasOid = true;
          }
        }
        if (!hasOid) {
          String oid = getOid(oids, "StructureDefinition", sd.getUrl());
          sd.getIdentifier().add(new org.hl7.fhir.dstu2.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (save) {
        parser.setOutputStyle(org.hl7.fhir.dstu2.formats.IParser.OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(f), r);
      }
    } catch (Exception e) {
      if (!e.getMessage().contains("wrong namespace")) {
        System.out.println("Error processing "+f.getAbsolutePath()+": "+e.getMessage());
        e.printStackTrace();
      }
    }    
  }


  private void processFileR3(IniFile oids, File f, FhirFormat fmt) {
    org.hl7.fhir.dstu3.formats.IParser parser = fmt == FhirFormat.JSON ? new  org.hl7.fhir.dstu3.formats.JsonParser() : new org.hl7.fhir.dstu3.formats.XmlParser();
    try {
      boolean save = false;
      org.hl7.fhir.dstu3.model.Resource r = parser.parse(ManagedFileAccess.inStream(f));
      if (r instanceof org.hl7.fhir.dstu3.model.CodeSystem) { 
        org.hl7.fhir.dstu3.model.CodeSystem cs = (org.hl7.fhir.dstu3.model.CodeSystem) r;
        boolean hasOid = isOid(cs.getIdentifier());
        if (!hasOid) {
          String oid = getOid(oids, "CodeSystem", cs.getUrl());
          cs.setIdentifier(new org.hl7.fhir.dstu3.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (r instanceof org.hl7.fhir.dstu3.model.ValueSet) { 
        org.hl7.fhir.dstu3.model.ValueSet vs = (org.hl7.fhir.dstu3.model.ValueSet) r;
        boolean hasOid = false;
        for (org.hl7.fhir.dstu3.model.Identifier id : vs.getIdentifier()) {
          if (isOid(id)) {
            hasOid = true;
          }
        }
        if (!hasOid) {
          String oid = getOid(oids, "ValueSet", vs.getUrl());
          vs.getIdentifier().add(new org.hl7.fhir.dstu3.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (r instanceof org.hl7.fhir.dstu3.model.ConceptMap) { 
        org.hl7.fhir.dstu3.model.ConceptMap cm = (org.hl7.fhir.dstu3.model.ConceptMap) r;
        boolean hasOid = isOid(cm.getIdentifier());
        if (!hasOid) {
          String oid = getOid(oids, "ConceptMap", cm.getUrl());
          cm.setIdentifier(new org.hl7.fhir.dstu3.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (r instanceof org.hl7.fhir.dstu3.model.StructureDefinition) { 
        org.hl7.fhir.dstu3.model.StructureDefinition sd = (org.hl7.fhir.dstu3.model.StructureDefinition) r;
        boolean hasOid = false;
        for (org.hl7.fhir.dstu3.model.Identifier id : sd.getIdentifier()) {
          if (isOid(id)) {
            hasOid = true;
          }
        }
        if (!hasOid) {
          String oid = getOid(oids, "StructureDefinition", sd.getUrl());
          sd.getIdentifier().add(new org.hl7.fhir.dstu3.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (save) {
        parser.setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(f), r);
      }
    } catch (Exception e) {
      if (!e.getMessage().contains("wrong namespace")) {
        System.out.println("Error processing "+f.getAbsolutePath()+": "+e.getMessage());
        e.printStackTrace();
      }
    }    
  }


  private void processFileR4(IniFile oids, File f, FhirFormat fmt) {
    org.hl7.fhir.r4.formats.IParser parser = fmt == FhirFormat.JSON ? new  org.hl7.fhir.r4.formats.JsonParser() : new org.hl7.fhir.r4.formats.XmlParser();
    try {
      boolean save = false;
      org.hl7.fhir.r4.model.Resource r = parser.parse(ManagedFileAccess.inStream(f));
      if (r instanceof org.hl7.fhir.r4.model.CodeSystem) { 
        org.hl7.fhir.r4.model.CodeSystem cs = (org.hl7.fhir.r4.model.CodeSystem) r;
        boolean hasOid = false;
        for (org.hl7.fhir.r4.model.Identifier id : cs.getIdentifier()) {
          if (isOid(id)) {
            hasOid = true;
          }
        }
        if (!hasOid) {
          String oid = getOid(oids, "CodeSystem", cs.getUrl());
          cs.getIdentifier().add(new org.hl7.fhir.r4.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (r instanceof org.hl7.fhir.r4.model.ValueSet) { 
        org.hl7.fhir.r4.model.ValueSet vs = (org.hl7.fhir.r4.model.ValueSet) r;
        boolean hasOid = false;
        for (org.hl7.fhir.r4.model.Identifier id : vs.getIdentifier()) {
          if (isOid(id)) {
            hasOid = true;
          }
        }
        if (!hasOid) {
          String oid = getOid(oids, "ValueSet", vs.getUrl());
          vs.getIdentifier().add(new org.hl7.fhir.r4.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (r instanceof org.hl7.fhir.r4.model.ConceptMap) { 
        org.hl7.fhir.r4.model.ConceptMap cm = (org.hl7.fhir.r4.model.ConceptMap) r;
        boolean hasOid = isOid(cm.getIdentifier());
        if (!hasOid) {
          String oid = getOid(oids, "ConceptMap", cm.getUrl());
          cm.setIdentifier(new org.hl7.fhir.r4.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (r instanceof org.hl7.fhir.r4.model.StructureDefinition) { 
        org.hl7.fhir.r4.model.StructureDefinition sd = (org.hl7.fhir.r4.model.StructureDefinition) r;
        boolean hasOid = false;
        for (org.hl7.fhir.r4.model.Identifier id : sd.getIdentifier()) {
          if (isOid(id)) {
            hasOid = true;
          }
        }
        if (!hasOid) {
          String oid = getOid(oids, "StructureDefinition", sd.getUrl());
          sd.getIdentifier().add(new org.hl7.fhir.r4.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (save) {
        parser.setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(f), r);
      }
    } catch (Exception e) {
      if (!e.getMessage().contains("wrong namespace")) {
        System.out.println("Error processing "+f.getAbsolutePath()+": "+e.getMessage());
        e.printStackTrace();
      }
    }    
  }

  private void processFileR4B(IniFile oids, File f, FhirFormat fmt) {
    org.hl7.fhir.r4b.formats.IParser parser = fmt == FhirFormat.JSON ? new  org.hl7.fhir.r4b.formats.JsonParser() : new org.hl7.fhir.r4b.formats.XmlParser();
    try {
      boolean save = false;
      org.hl7.fhir.r4b.model.Resource r = parser.parse(ManagedFileAccess.inStream(f));
      if (r instanceof org.hl7.fhir.r4b.model.CanonicalResource) { 
        org.hl7.fhir.r4b.model.CanonicalResource cs = (org.hl7.fhir.r4b.model.CanonicalResource) r;
        boolean hasOid = false;
        for (org.hl7.fhir.r4b.model.Identifier id : cs.getIdentifier()) {
          if (isOid(id)) {
            hasOid = true;
          }
        }
        if (!hasOid) {
          String oid = getOid(oids, r.fhirType(), cs.getUrl());
          cs.getIdentifier().add(new org.hl7.fhir.r4b.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (save) {
        parser.setOutputStyle(org.hl7.fhir.r4b.formats.IParser.OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(f), r);
      }
    } catch (Exception e) {
      if (!e.getMessage().contains("wrong namespace")) {
        System.out.println("Error processing "+f.getAbsolutePath()+": "+e.getMessage());
        e.printStackTrace();
      }
    }    
  }


  private void processFileR5(IniFile oids, File f, FhirFormat fmt) {
    org.hl7.fhir.r5.formats.IParser parser = fmt == FhirFormat.JSON ? new  org.hl7.fhir.r5.formats.JsonParser() : new org.hl7.fhir.r5.formats.XmlParser();
    try {
      boolean save = false;
      org.hl7.fhir.r5.model.Resource r = parser.parse(ManagedFileAccess.inStream(f));
      if (r instanceof org.hl7.fhir.r5.model.CanonicalResource) { 
        org.hl7.fhir.r5.model.CanonicalResource cs = (org.hl7.fhir.r5.model.CanonicalResource) r;
        cs.getIdentifier().removeIf(id -> Utilities.existsInList(id.getValue(), 
            "urn:oid:2.16.840.1.113883.4.642.3.3343","urn:oid:2.16.840.1.113883.4.642.8.4","urn:oid:2.16.840.1.113883.4.642.10.7","urn:oid:2.16.840.1.113883.4.642.11.11","urn:oid:2.16.840.1.113883.4.642.17.4","urn:oid:2.16.840.1.113883.4.642.30.5","urn:oid:2.16.840.1.113883.4.642.34.1"));
        boolean hasOid = false;
        for (org.hl7.fhir.r5.model.Identifier id : cs.getIdentifier()) {
          if (isOid(id)) {
            hasOid = true;
          }
        }
        String url = cs.getUrl();
        if (url == null) {
          String id = cs.getId();
          if (id == null && Utilities.existsInList(cs.fhirType(), "CodeSystem", "ValueSet")) {
            id = f.getName();
            id = id.substring(0, id.lastIndexOf("."));
            id = id.replace(cs.fhirType().toLowerCase()+"-", "");
          }
          if (id != null) {
            url = "http://hl7.org/fhir/"+cs.fhirType()+"/"+id;
          }
        }
        if (!hasOid && url != null) {
          String oid = getOid(oids, r.fhirType(), url);
          cs.getIdentifier().add(new org.hl7.fhir.r5.model.Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:oid:"+oid));
          save = true;
        }
      }
      if (save) {
        parser.setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(f), r);
      }
    } catch (Exception e) {
      if (!e.getMessage().contains("wrong namespace")) {
        System.out.println("Error processing "+f.getAbsolutePath()+": "+e.getMessage());
        e.printStackTrace();
      }
    }    
  }
 
  private boolean isOid(org.hl7.fhir.dstu2.model.Identifier id) {
    return "urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:");
  }

  private boolean isOid(org.hl7.fhir.dstu3.model.Identifier id) {
    return "urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:");
  }

  private boolean isOid(org.hl7.fhir.r4.model.Identifier id) {
    return "urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:");
  }

  private boolean isOid(org.hl7.fhir.r4b.model.Identifier id) {
    return "urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:");
  }

  private boolean isOid(org.hl7.fhir.r5.model.Identifier id) {
    return "urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:");
  }

  private String getOid(IniFile oids, String rt, String url) {
    String root = oids.getStringProperty("Roots", rt);
    if (root == null) {
      throw new Error("no OID.ini entry for "+rt);
    }
    String oid = oids.getStringProperty(rt, url);
    if (oid != null) {
      return oid;
    }
    int key = oids.hasProperty("Key", rt) ? oids.getIntegerProperty("Key", rt) : 0;
    key++;
    oid = root+"."+key;
    oids.setIntegerProperty("Key", rt, key, null);
    oids.setStringProperty(rt, url, oid, null);
    oids.save();
    return oid;
  }
}
