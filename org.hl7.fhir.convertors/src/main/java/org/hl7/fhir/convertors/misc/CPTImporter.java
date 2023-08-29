package org.hl7.fhir.convertors.misc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

public class CPTImporter {

  public static void main(String[] args) throws FHIRException, FileNotFoundException, IOException, ClassNotFoundException, SQLException {
    new CPTImporter().doImport(args[0], args[1], args[2]);

  }


  private void doImport(String src, String version, String dst) throws FHIRException, FileNotFoundException, IOException, ClassNotFoundException, SQLException {

    CodeSystem cs = new CodeSystem();
    cs.setId("cpt");
    cs.setUrl("http://www.ama-assn.org/go/cpt");
    cs.setVersion(version);
    cs.setName("AmaCPT");
    cs.setTitle("AMA CPT");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setDate(new Date());
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.setCompositional(true);
    cs.setPublisher("AMA");
    cs.setValueSet("http://hl7.org/fhir/ValueSet/cpt-all");
    cs.setCopyright("CPT © Copyright 2019 American Medical Association. All rights reserved. AMA and CPT are registered trademarks of the American Medical Association.");
    cs.addProperty().setCode("modifier").setDescription("Whether code is a modifier code").setType(PropertyType.BOOLEAN);
    cs.addProperty().setCode("modified").setDescription("Whether code has been modified (all base codes are not modified)").setType(PropertyType.BOOLEAN);
    cs.addProperty().setCode("orthopox").setDescription("Whether code is one of the Pathology and Laboratory and Immunization Code(s) for Orthopoxvirus").setType(PropertyType.BOOLEAN);
    cs.addProperty().setCode("telemedicine").setDescription("Whether code is appropriate for use with telemedicine (and the telemedicine modifier)").setType(PropertyType.BOOLEAN);
    cs.addProperty().setCode("kind").setDescription("Kind of Code (see metadata)").setType(PropertyType.CODE);

    defineMetadata(cs);
    
    System.out.println("LONGULT: "+readCodes(cs, Utilities.path(src, "LONGULT.txt"), false, null, null, null));
    System.out.println("LONGUT: "+readCodes(cs, Utilities.path(src, "LONGUT.txt"), false, "upper", null, null));
    System.out.println("MEDU: "+readCodes(cs, Utilities.path(src, "MEDU.txt"), false, "med", null, null));
    System.out.println("SHORTU: "+readCodes(cs, Utilities.path(src, "SHORTU.txt"), false, "short", null, null));
    System.out.println("ConsumerDescriptor: "+readCodes(cs, Utilities.path(src, "ConsumerDescriptor.txt"), true, "consumer", null, null));
    System.out.println("ClinicianDescriptor: "+readCodes(cs, Utilities.path(src, "ClinicianDescriptor.txt"), true, "clinician", null, null));
    System.out.println("OrthopoxvirusCodes: "+readCodes(cs, Utilities.path(src, "OrthopoxvirusCodes.txt"), false, null, null, "orthopox"));
  
    System.out.println("modifiers: "+processModifiers(cs, Utilities.path(src, "modifiers.csv")));
    System.out.println("appendix P: "+processAppendixP(cs));
    
    
    System.out.println("-------------------");
    System.out.println(cs.getConcept().size());
    int c = 0;
    int k = 0;
    for (ConceptDefinitionComponent cc: cs.getConcept()) {
      c = Integer.max(c, cc.getProperty().size());
      if (cc.getProperty().size() > 3) {
        k++;
      }
    }
    System.out.println(c);
    System.out.println(k);
    
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dst), cs); 
    produceDB(Utilities.changeFileExt(dst, ".db"), cs);
    
    cs.setContent(CodeSystemContentMode.FRAGMENT);
    cs.getConcept().removeIf(cc -> !Utilities.existsInList(cc.getCode(), "metadata-kinds", "metadata-designations", "99202", "99203", "0001A", "99252", "25", "P1", "1P", "F1", "95"));
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.changeFileExt(dst, "-fragment.json")), cs); 
    produceDB(Utilities.changeFileExt(dst, "-fragment.db"), cs);
  }

  private String processAppendixP(CodeSystem cs) {
    List<String> tcodes = new ArrayList<>();
    tcodes.add("90785");
    tcodes.add("90791");
    tcodes.add("90792");
    tcodes.add("90832");
    tcodes.add("90833");
    tcodes.add("90834");
    tcodes.add("90836");
    tcodes.add("90837");
    tcodes.add("90838");
    tcodes.add("90839");
    tcodes.add("90840");
    tcodes.add("90845");
    tcodes.add("90846");
    tcodes.add("90847");
    tcodes.add("92507");
    tcodes.add("92508");
    tcodes.add("92521");
    tcodes.add("92522");
    tcodes.add("92523");
    tcodes.add("92524");
    tcodes.add("96040");
    tcodes.add("96110");
    tcodes.add("96116");
    tcodes.add("96160");
    tcodes.add("96161");
    tcodes.add("97802");
    tcodes.add("97803");
    tcodes.add("97804");
    tcodes.add("99406");
    tcodes.add("99407");
    tcodes.add("99408");
    tcodes.add("99409");
    tcodes.add("99497");
    tcodes.add("99498");

    for (String c : tcodes) { 
      ConceptDefinitionComponent cc = CodeSystemUtilities.findCode(cs.getConcept(), c);
      if (cc == null) {
        throw new Error("unable to find tcode "+c);
      }
      cc.addProperty().setCode("telemedicine").setValue(new BooleanType(true));
    }    
    return String.valueOf(tcodes.size());
  }


  private void produceDB(String path, CodeSystem cs) throws ClassNotFoundException, SQLException {
    Connection con = connect(path);

    Statement stmt = con.createStatement();
    stmt.execute("insert into Information (name, value) values ('version', "+cs.getVersion()+")");        
    for (ConceptDefinitionComponent cc: cs.getConcept()) {
      if (!cc.getCode().startsWith("metadata")) {
        stmt.execute("insert into Concepts (code, modifier) values ('"+cc.getCode()+"', "+isModifier(cc)+")");
        int i = 0;
        if (cc.hasDisplay()) {
          stmt.execute("insert into Designations (code, type, sequence, value) values ('"+cc.getCode()+"', 'display', 0, '"+Utilities.escapeSql(cc.getDisplay())+"')");
          i++;
        }
        for (ConceptDefinitionDesignationComponent d : cc.getDesignation()) {
          stmt.execute("insert into Designations (code, type, sequence, value) values ('"+cc.getCode()+"', '"+d.getUse().getCode()+"', "+i+", '"+Utilities.escapeSql(d.getValue())+"')");
          i++;
        }
        i = 0;
        for (ConceptPropertyComponent p : cc.getProperty()) {
          if (!Utilities.existsInList(p.getCode(), "modified", "modifier")) {
            stmt.execute("insert into Properties (code, name, sequence, value) values ('"+cc.getCode()+"', '"+p.getCode()+"', "+i+", '"+p.getValue().primitiveValue()+"')");
            i++;
          }
        }    
      }
    }

  }

  private String isModifier(ConceptDefinitionComponent cc) {
    for (ConceptPropertyComponent p : cc.getProperty()) {
      if (p.getCode().equals("modifier")) {
        return p.getValue().primitiveValue().equals("true") ? "1" : "0";
      }
    }
    return "0";
  }


  private Connection connect(String dest) throws SQLException, ClassNotFoundException {
    //    Class.forName("com.mysql.jdbc.Driver");  
    //    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omop?useSSL=false","root",{pwd}); 
    new File(dest).delete();
    Connection con = DriverManager.getConnection("jdbc:sqlite:"+dest); 
    makeMetadataTable(con);
    makeConceptsTable(con);
    makeDesignationsTable(con);
    makePropertiesTable(con);
    return con;    
  }
  
  private void makeDesignationsTable(Connection con) throws SQLException {
    Statement stmt = con.createStatement();
    stmt.execute("CREATE TABLE Designations (\r\n"+
        "`code` varchar(15) NOT NULL,\r\n"+
        "`type` varchar(15) NOT NULL,\r\n"+
        "`sequence` int NOT NULL,\r\n"+
        "`value` text NOT NULL,\r\n"+
        "PRIMARY KEY (`code`, `type`, `sequence`))\r\n");
  }


  private void makePropertiesTable(Connection con) throws SQLException {

    Statement stmt = con.createStatement();
    stmt.execute("CREATE TABLE Properties (\r\n"+
        "`code` varchar(15) NOT NULL,\r\n"+
        "`name` varchar(15) NOT NULL,\r\n"+
        "`sequence` int NOT NULL,\r\n"+
        "`value` varchar(15) NOT NULL,\r\n"+
        "PRIMARY KEY (`code`, `name`, `sequence`))\r\n");

  }


  private void makeConceptsTable(Connection con) throws SQLException {

    Statement stmt = con.createStatement();
    stmt.execute("CREATE TABLE Concepts (\r\n"+
        "`code` varchar(15) NOT NULL,\r\n"+
        "`modifier` int DEFAULT NULL,\r\n"+
        "PRIMARY KEY (`code`))\r\n");

  }


  private void makeMetadataTable(Connection con) throws SQLException {

    Statement stmt = con.createStatement();
    stmt.execute("CREATE TABLE Information (\r\n"+
        "`name` varchar(64) NOT NULL,\r\n"+
        "`value` varchar(64) DEFAULT NULL,\r\n"+
        "PRIMARY KEY (`name`))\r\n");

  }


  private void defineMetadata(CodeSystem cs) {
    ConceptDefinitionComponent pc = mm(cs.addConcept().setCode("metadata-kinds"));
    mm(pc.addConcept()).setCode("code").setDisplay("A normal CPT code");
    mm(pc.addConcept()).setCode("cat-1").setDisplay("CPT Level I Modifiers");
    mm(pc.addConcept()).setCode("cat-2").setDisplay("A Category II code or modifier");
    mm(pc.addConcept()).setCode("physical-status").setDisplay("Anesthesia Physical Status Modifiers");
    mm(pc.addConcept()).setCode("general").setDisplay("A general modifier");
    mm(pc.addConcept()).setCode("hcpcs").setDisplay("Level II (HCPCS/National) Modifiers");
    mm(pc.addConcept()).setCode("metadata").setDisplay("A kind of code or designation");

    ConceptDefinitionComponent dc = mm(cs.addConcept().setCode("metadata-designations"));
    mm(dc.addConcept()).setCode("upper").setDisplay("Uppercase variant of the display");
    mm(dc.addConcept()).setCode("med").setDisplay("Medium length variant of the display (all uppercase)");
    mm(dc.addConcept()).setCode("short").setDisplay("Short length variant of the display (all uppercase)");
    mm(dc.addConcept()).setCode("consumer").setDisplay("Consumer Friendly representation for the concept");
    mm(dc.addConcept()).setCode("clinician").setDisplay("Clinician Friendly representation for the concept (can be more than one per concept)");
  }

  private ConceptDefinitionComponent mm(ConceptDefinitionComponent cc) {
    cc.addProperty().setCode("kind").setValue(new CodeType("metadata"));
    return cc;
  }

  private int processModifiers(CodeSystem cs, String path) throws FHIRException, FileNotFoundException, IOException {
    CSVReader csv = new CSVReader(new FileInputStream(path));
    csv.readHeaders();

    int res = 0;
    while (csv.line()) {
      String code = csv.cell("Code");
      String general = csv.cell("General");
      String physicalStatus = csv.cell("PhysicalStatus");
      String levelOne = csv.cell("LevelOne");
      String levelTwo = csv.cell("LevelTwo");
      String hcpcs = csv.cell("HCPCS");
      String defn = csv.cell("Definition");

      res = Integer.max(res, defn.length());
      ConceptDefinitionComponent cc = cs.addConcept().setCode(code);
      cc.setDisplay(defn);    
      cc.addProperty().setCode("modified").setValue(new BooleanType(false));
      cc.addProperty().setCode("modifier").setValue(new BooleanType(true));
      if ("1".equals(general)) { 
        cc.addProperty().setCode("kind").setValue(new CodeType("general"));
      }
      if ("1".equals(physicalStatus)) { 
        cc.addProperty().setCode("kind").setValue(new CodeType("physical-status"));
      }
      if ("1".equals(levelOne)) { 
        cc.addProperty().setCode("kind").setValue(new CodeType("cat-1"));
      }
      if ("1".equals(levelTwo)) { 
        cc.addProperty().setCode("kind").setValue(new CodeType("cat-2"));
      }
      if ("1".equals(hcpcs)) { 
        cc.addProperty().setCode("kind").setValue(new CodeType("hcpcs"));
      }
    }
    return res;
  }

  private int readCodes(CodeSystem cs, String path, boolean hasConceptId, String use, String type, String boolProp) throws IOException {
    int res = 0;
    FileInputStream inputStream = null;
    Scanner sc = null;
    try {
        inputStream = new FileInputStream(path);
        sc = new Scanner(inputStream, "UTF-8");
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          if (hasConceptId) {
            line = line.substring(7).trim();
          }
          String code = line.substring(0, 5);
          String desc = line.substring(6);
          if (desc.contains("\t")) {
            desc = desc.substring(desc.indexOf("\t")+1);
          }
          res = Integer.max(res, desc.length());
          ConceptDefinitionComponent cc = CodeSystemUtilities.getCode(cs, code);
          if (cc == null) {
            cc = cs.addConcept().setCode(code);
            cc.addProperty().setCode("modifier").setValue(new BooleanType(false));
            cc.addProperty().setCode("modified").setValue(new BooleanType(false));
            if (type == null) {
              if (Utilities.isInteger(code)) {
                cc.addProperty().setCode("kind").setValue(new CodeType("code"));              
              } else {
                cc.addProperty().setCode("kind").setValue(new CodeType("cat-2"));                            
              }
            } else { 
              cc.addProperty().setCode("kind").setValue(new CodeType(type));
            }
          } else if (type != null) {
            cc.addProperty().setCode("kind").setValue(new CodeType(type));
          }
          if (boolProp != null) {
            cc.addProperty().setCode(boolProp).setValue(new BooleanType(true));
          }
          if (use == null) {
            if (cc.hasDisplay()) {
              System.err.println("?");
            }
            cc.setDisplay(desc);            
          } else {
            cc.addDesignation().setUse(new Coding("http://www.ama-assn.org/go/cpt", use, null)).setValue(desc);
          }
        }
        // note that Scanner suppresses exceptions
        if (sc.ioException() != null) {
          throw sc.ioException();
        }
    } finally {
        if (inputStream != null) {
            inputStream.close();
        }
        if (sc != null) {
            sc.close();
        }
    }
    return res;
  }


}
