package org.hl7.fhir.convertors.misc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;

import org.hl7.fhir.convertors.misc.OMOPImporter.Tracker;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

public class OMOPImporter {

  public class Tracker {
    private int blip;
    private long start;
    private int counter = 0;
    boolean processed = false;

    public Tracker(String name, int estimate) {
      this.start = System.currentTimeMillis();
      this.blip = estimate < 100 ? 1 : estimate / 80;
      System.out.print(name);
    }

    public void skip() {
      System.out.println(" ... skipped");
    }
    
    public void scan() {
      System.out.println("");
      System.out.print(" Scan :");
      counter = 0;
    }

    public void process() {
      System.out.println("");
      System.out.print(" Build:");
      counter = 0;
      processed = true;
    }

    public void step() {
      counter++;
      if (counter % blip == 0) {
        System.out.print(".");
      }
    }

    public void done() {
      if (counter > 0) {
        System.out.println("");        
      }
      if (processed) {
        long elapsed = System.currentTimeMillis()-start; 
        if (elapsed > 3000) {
          System.out.println(" Finished: "+counter+" rows, "+Utilities.describeDuration(elapsed)+" ("+(counter/(elapsed/1000))+" rows/msec)");
        } else {
          System.out.println(" Finished: "+counter+" rows, "+Utilities.describeDuration(elapsed));
        }
      } else {
        System.out.println(" Finished: "+counter+" rows");        
      }
    }


    public void error(String e) {
      System.out.println("error: "+e);
      System.out.println("row: "+counter);        
      throw new Error(e);
    }

  }

  private Connection con;
  private Map<String, String> relationships = new HashMap<>();
  private Map<String, String> vocabularies = new HashMap<>();
  private Map<String, String> domains = new HashMap<>();
  private Map<String, String> classes = new HashMap<>();

  public static void main(String[] args) throws Exception {
    new OMOPImporter().process(args[0], args[1]); 
    // "/Users/grahamegrieve/Downloads/vocabulary_download_v5_{97cc5432-0dc9-4f14-9da2-d0624129d2f7}_1688068174909");
    // /Users/grahamegrieve/temp/omop/omop.db
  }

  private void process(String folder, String dest) throws ClassNotFoundException, SQLException, FHIRException, FileNotFoundException, IOException {
    connect(dest);

    processRelationships(folder, true);
    processVocabularies(folder, true);
    processDomains(folder, true);
    processConceptClasses(folder, true);
    processConcepts(folder, true);
    processConceptSynonyms(folder, true);
    processConceptRelationships(folder, true);
    // disabled - don't consume space that isn't required
    processDrugStrength(folder, false);
    processConceptAncestors(folder, false);
  }


  private void connect(String dest) throws SQLException, ClassNotFoundException {
    //    Class.forName("com.mysql.jdbc.Driver");  
    //    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omop?useSSL=false","root",{pwd}); 
    new File("/Users/grahamegrieve/temp/omop/omop.db").delete();
    con = DriverManager.getConnection("jdbc:sqlite:"+dest); 
  }
  private void processRelationships(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("Relationships", 700);
    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "RELATIONSHIP.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int lid = 0;
    int lname = 0;

    t.scan();
    while (csv.line()) {
      relationships.put(csv.cell("relationship_id"), csv.cell("relationship_concept_id"));

      lid = max(lid, csv.cell("relationship_id"));
      lname = max(lname, csv.cell("relationship_name"));
      t.step();
    }

    csv.close();   
    if (process) {
      t.process();
      Statement stmt = con.createStatement();
      stmt.execute("CREATE TABLE Relationships (\r\n"+
          "`relationship_concept_id` bigint NOT NULL,\r\n"+
          "`relationship_id` varchar("+lid+") DEFAULT NULL,\r\n"+
          "`relationship_name` varchar("+lname+") DEFAULT NULL,\r\n"+
          "`is_hierarchical` int DEFAULT NULL,\r\n"+
          "`defines_ancestry` int DEFAULT NULL,\r\n"+
          "`reverse_relationship_id` varchar(45) DEFAULT NULL,\r\n"+
          "PRIMARY KEY (`relationship_concept_id`))\r\n");

      stmt.execute("Create Index `RelationshipsId` on Relationships  (`relationship_id`)");
      stmt.execute("Create Index`RelationshipsReverse` on Relationships (`reverse_relationship_id`)");

      csv = new CSVReader(new FileInputStream(Utilities.path(folder, "RELATIONSHIP.csv")));
      csv.setDelimiter('\t');
      csv.readHeaders();
      csv.setDoingQuotes(false);

      while (csv.line()) {
        relationships.put(csv.cell("relationship_id"), csv.cell("relationship_concept_id"));
        if (process) {
          String sql = "INSERT INTO `Relationships` (`relationship_concept_id`, `relationship_id`, `relationship_name`, `is_hierarchical`, `defines_ancestry`, `reverse_relationship_id`) VALUES ("+
              sw(csv.cell("relationship_concept_id"))+", "+
              sw(csv.cell("relationship_id"))+", "+
              sw(csv.cell("relationship_name"))+", "+
              sw(csv.cell("is_hierarchical"))+", "+
              sw(csv.cell("defines_ancestry"))+", "+
              sw(csv.cell("reverse_relationship_id"))+")";
          try {
            stmt.executeUpdate(sql);
          } catch (Exception e) {
            t.error(e.getMessage());
          }
        }
        t.step();
      }
      csv.close();    
    }
    t.done();
  }

  private int max(int lid, String cell) {
    int i = cell == null? 0 : cell.length();
    return i > lid ? i : lid;
  }

  private void processVocabularies(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("Vocabularies", 60);
    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "VOCABULARY.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int lid = 0;
    int lname = 0;
    int lref = 0;
    int lver = 0;
    t.scan();
    while (csv.line()) {
      vocabularies.put(csv.cell("vocabulary_id"), csv.cell("vocabulary_concept_id"));

      lid = max(lid, csv.cell("vocabulary_id"));
      lname = max(lname, csv.cell("vocabulary_name"));
      lref = max(lref, csv.cell("vocabulary_reference"));
      lver = max(lver, csv.cell("vocabulary_version"));
      t.step();
    }
    csv.close(); 

    if (process) {
      t.process();
      Statement stmt = con.createStatement();

      stmt.execute("CREATE TABLE `Vocabularies` (\r\n"+
          "  `vocabulary_concept_id` bigint NOT NULL,\r\n"+
          "  `vocabulary_id` varchar("+lid+") DEFAULT NULL,\r\n"+
          "  `vocabulary_name` varchar("+lname+") DEFAULT NULL,\r\n"+
          "  `vocabulary_reference` varchar("+lref+") DEFAULT NULL,\r\n"+
          "  `vocabulary_version` varchar("+lver+") DEFAULT NULL,\r\n"+
          "  PRIMARY KEY (`vocabulary_concept_id`)\r\n"+
          ") \r\n"+
          "\r\n");
      stmt.execute("CREATE INDEX `VocabulariesId` on Vocabularies (`vocabulary_id`)");

      csv = new CSVReader(new FileInputStream(Utilities.path(folder, "VOCABULARY.csv")));
      csv.setDelimiter('\t');
      csv.readHeaders();
      csv.setDoingQuotes(false);
      while (csv.line()) {
        String sql = "INSERT INTO `Vocabularies` (`vocabulary_concept_id`, `vocabulary_id`, `vocabulary_name`, `vocabulary_reference`, `vocabulary_version`) VALUES ("+
            sw(csv.cell("vocabulary_concept_id"))+", "+
            sw(csv.cell("vocabulary_id"))+", "+
            sw(csv.cell("vocabulary_name"))+", "+
            sw(csv.cell("vocabulary_reference"))+", "+
            sw(csv.cell("vocabulary_version"))+")";
        try {
          stmt.executeUpdate(sql);
        } catch (Exception e) {
          t.error(e.getMessage());
        }
        t.step();
      }
      csv.close(); 
    }
    t.done();
  }


  private void processDomains(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("Domains", 50);

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "DOMAIN.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int lid = 0;
    int lname = 0;
    t.scan();
    while (csv.line()) {

      domains.put(csv.cell("domain_id"), csv.cell("domain_concept_id"));

      lid = max(lid, csv.cell("domain_id"));
      lname = max(lname, csv.cell("domain_name"));
      t.step();
    }
    csv.close();

    if (process) {
      t.process();
      Statement stmt = con.createStatement();

      stmt.execute("CREATE TABLE `Domains` (\r\n"+
          "  `domain_concept_id` bigint NOT NULL,\r\n"+
          "  `domain_id` varchar("+lid+") DEFAULT NULL,\r\n"+
          "  `domain_name` varchar("+lname+") DEFAULT NULL,\r\n"+
          "  PRIMARY KEY (`domain_concept_id`)\r\n"+
          ") \r\n"+
          "\r\n");

      stmt.execute("CREATE INDEX `DomainId` on Domains (`domain_id`)");

      csv = new CSVReader(new FileInputStream(Utilities.path(folder, "DOMAIN.csv")));
      csv.setDelimiter('\t');
      csv.readHeaders();
      csv.setDoingQuotes(false);
      while (csv.line()) {
        String sql = "INSERT INTO `Domains` (`domain_concept_id`, `domain_id`, `domain_name`) VALUES ("+
            sw(csv.cell("domain_concept_id"))+", "+
            sw(csv.cell("domain_id"))+", "+
            sw(csv.cell("domain_name"))+")";
        try {
          stmt.executeUpdate(sql);
        } catch (Exception e) {
          t.error(e.getMessage());
        }
        t.step();
      }
      csv.close();
    }
    t.done();
  }

  private void processConceptClasses(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("ConceptClasses", 400);

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_CLASS.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int lid = 0;
    int lname = 0;
    t.scan();
    while (csv.line()) {
      classes.put(csv.cell("concept_class_id"), csv.cell("concept_class_concept_id"));

      lid = max(lid, csv.cell("concept_class_id"));
      lname = max(lname, csv.cell("concept_class_name"));
      t.step();
    }
    csv.close(); 

    if (process) {
      t.process();
      Statement stmt = con.createStatement();
      stmt.execute("CREATE TABLE `ConceptClasses` (\r\n"+
          "  `concept_class_concept_id` bigint NOT NULL,\r\n"+
          "  `concept_class_id` varchar("+lid+") DEFAULT NULL,\r\n"+
          "  `concept_class_name` varchar("+lname+") DEFAULT NULL,\r\n"+
          "  PRIMARY KEY (`concept_class_concept_id`)\r\n"+
          ") \r\n"+
          "\r\n");
      csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_CLASS.csv")));
      csv.setDelimiter('\t');
      csv.readHeaders();
      csv.setDoingQuotes(false);

      while (csv.line()) {
        String sql = "INSERT INTO `ConceptClasses` (`concept_class_concept_id`, `concept_class_id`, `concept_class_name`) VALUES ("+
            sw(csv.cell("concept_class_concept_id"))+", "+
            sw(csv.cell("concept_class_id"))+", "+
            sw(csv.cell("concept_class_name"))+")";
        try {
          stmt.executeUpdate(sql);
        } catch (Exception e) {
          t.error(e.getMessage());
        }
        t.step();
      }
      csv.close();
    }
    t.done();

  }


  private void processDrugStrength(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("DrugStrengths", 3000000);
    if (!process) {
      t.skip();
      return;
    }

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "DRUG_STRENGTH.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int lreason = 0;
    int lamount1 = 0;
    int lnum1 = 0;
    int lden1 = 0;
    int lamount2 = 0;
    int lnum2 = 0;
    int lden2 = 0;
    t.scan();
    while (csv.line()) {
      lreason = max(lreason, csv.cell("invalid_reason"));
      lamount1 = dmax1(lamount1, csv.cell("amount_value"));
      lamount2 = dmax2(lamount2, csv.cell("amount_value"));
      lnum1 = dmax1(lnum1, csv.cell("numerator_value"));
      lnum2 = dmax2(lnum2, csv.cell("numerator_value"));
      lden1 = dmax1(lden1, csv.cell("denominator_value"));
      lden2 = dmax2(lden2, csv.cell("denominator_value"));
      t.step();
    }
    csv.close();
    t.process();

    Statement stmt = con.createStatement();
    stmt.execute("CREATE TABLE `DrugStrengths` (\r\n"+
        "  `drug_concept_id` bigint NOT NULL,\r\n"+
        "  `ingredient_concept_id` bigint NOT NULL,\r\n"+
        "  `amount_value` decimal("+lamount1+","+lamount2+") DEFAULT NULL,\r\n"+
        "  `amount_unit_concept_id` bigint DEFAULT NULL,\r\n"+
        "  `numerator_value` decimal("+lnum1+","+lnum2+") DEFAULT NULL,\r\n"+
        "  `numerator_unit_concept_id` bigint DEFAULT NULL,\r\n"+
        "  `denominator_value` decimal("+lden1+","+lden2+") DEFAULT NULL,\r\n"+
        "  `denominator_unit_concept_id` bigint DEFAULT NULL,\r\n"+
        "  `box_size` int DEFAULT NULL,\r\n"+
        "  `valid_start_date` date DEFAULT NULL,\r\n"+
        "  `valid_end_date` date DEFAULT NULL,\r\n"+
        "  `invalid_reason` varchar("+lreason+") DEFAULT NULL,\r\n"+
        "  PRIMARY KEY (`drug_concept_id`,`ingredient_concept_id`)\r\n"+
        ") \r\n"+
        "\r\n");
    csv = new CSVReader(new FileInputStream(Utilities.path(folder, "DRUG_STRENGTH.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    PreparedStatement pstmt = con.prepareStatement("INSERT INTO `DrugStrengths` (`drug_concept_id`, `ingredient_concept_id`, `amount_value`, `amount_unit_concept_id`, `numerator_value`, `numerator_unit_concept_id`, `denominator_value`, "
        + "`denominator_unit_concept_id`, `box_size`, `valid_start_date`, `valid_end_date`, `invalid_reason`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    while (csv.line()) {
      try {
        pstmt.setString(1, csv.cell("drug_concept_id"));
        pstmt.setString(2, csv.cell("ingredient_concept_id"));
        pstmt.setString(3, csv.cell("amount_value"));
        pstmt.setString(4, csv.cell("amount_unit_concept_id"));
        pstmt.setString(5, csv.cell("numerator_value"));
        pstmt.setString(6, csv.cell("numerator_unit_concept_id"));
        pstmt.setString(7, csv.cell("denominator_value"));
        pstmt.setString(8, csv.cell("denominator_unit_concept_id"));
        pstmt.setString(9, csv.cell("box_size"));
        pstmt.setString(10, date(csv.cell("valid_start_date")));
        pstmt.setString(11, date(csv.cell("valid_end_date")));
        pstmt.setString(11, csv.cell("invalid_reason"));
        pstmt.executeUpdate();
      } catch (Exception e) {
        t.error(e.getMessage());
      }
      t.step();
    }
    csv.close();
    t.done();

  }

  private int dmax1(int lid, String cell) {
    int i = cell == null? 0 : cell.indexOf('.');
    return i > lid ? i : lid;
  }

  private int dmax2(int lid, String cell) {
    int i = cell == null? 0 : cell.length() - cell.indexOf('.') - 1;
    return i > lid ? i : lid;
  }

  private void processConcepts(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("Concepts", 5617348);
    if (!process) {
      t.skip();
      return;
    }

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int lname = 0;
    int lstd = 0;
    int lcode = 0;
    int lreason = 0;
    t.scan();
    while (csv.line()) {
      lname = max(lname, csv.cell("concept_name"));
      lstd = max(lstd, csv.cell("standard_concept"));
      lcode = max(lcode, csv.cell("concept_code"));
      lreason = max(lreason, csv.cell("invalid_reason"));
      t.step();
    }
    csv.close();
    t.process();

    Statement stmt = con.createStatement();
    stmt.execute("CREATE TABLE `Concepts` (\r\n"+
        "    `concept_id` bigint NOT NULL,\r\n"+
        "    `concept_name` varchar("+lname+") DEFAULT NULL,\r\n"+
        "    `domain_id` bigint DEFAULT NULL,\r\n"+
        "    `vocabulary_id` bigint DEFAULT NULL,\r\n"+
        "    `concept_class_id` bigint DEFAULT NULL,\r\n"+
        "    `standard_concept` varchar("+lstd+") DEFAULT NULL,\r\n"+
        "    `concept_code` varchar("+lcode+") DEFAULT NULL,\r\n"+
        "    `valid_start_date` date DEFAULT NULL,\r\n"+
        "    `valid_end_date` date DEFAULT NULL,\r\n"+
        "    `invalid_reason` varchar("+lreason+") DEFAULT NULL,\r\n"+
        "    PRIMARY KEY (`concept_id`)\r\n"+
        "  ) \r\n"+
        "\r\n");

    stmt.execute("CREATE INDEX `ConceptDomain` on Concepts (`domain_id`)");
    stmt.execute("CREATE INDEX `ConceptVocabulary` on Concepts (`vocabulary_id`,`concept_code`)");
    stmt.execute("CREATE INDEX `ConceptClass` on Concepts (`concept_class_id`)");

    csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);

    PreparedStatement pstmt = con.prepareStatement(
        "INSERT INTO `Concepts` (`concept_id`, `concept_name`, `domain_id`, `vocabulary_id`, `concept_class_id`, `standard_concept`, `concept_code`, `valid_start_date`, `valid_end_date`, `invalid_reason`) "+
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
    while (csv.line()) {
      try {
        pstmt.setString(1, csv.cell("concept_id"));
        pstmt.setString(2, csv.cell("concept_name"));
        pstmt.setString(3, domains.get(csv.cell("domain_id")));
        pstmt.setString(4, vocabularies.get(csv.cell("vocabulary_id")));
        pstmt.setString(5, classes.get(csv.cell("concept_class_id")));
        pstmt.setString(6, csv.cell("standard_concept"));
        pstmt.setString(7, csv.cell("concept_code"));
        pstmt.setString(8, date(csv.cell("valid_start_date")));
        pstmt.setString(9, date(csv.cell("valid_end_date")));
        pstmt.setString(10, csv.cell("invalid_reason"));
        pstmt.executeUpdate();
      } catch (Exception e) {
        t.error(e.getMessage());
      }
      t.step();
    }
    csv.close();    
    t.done();
  }

  private void processConceptSynonyms(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("ConceptSynonyms", 1933498);
    if (!process) {
      t.skip();
      return;
    }    
    t.scan();

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_SYNONYM.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int lname = 0;
    while (csv.line()) {
      lname = max(lname, csv.cell("concept_synonym_name"));
      t.step();
    }
    csv.close();
    t.process();

    Statement stmt = con.createStatement();
    stmt.execute("CREATE TABLE `ConceptSynonyms` (\r\n"+
        "  `concept_id` bigint NOT NULL,\r\n"+
        "  `concept_synonym_name` varchar("+lname+") DEFAULT NULL,\r\n"+
        "  `language_concept_id` bigint DEFAULT NULL\r\n"+
        ") \r\n"+
        "\r\n");
    stmt.execute("CREATE INDEX `SynonymId` on ConceptSynonyms (`concept_id`)");
    stmt.execute("CREATE INDEX `SynonymLang` on ConceptSynonyms (`language_concept_id`)");

    csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_SYNONYM.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    
    PreparedStatement pstmt = con.prepareStatement("INSERT INTO `ConceptSynonyms` (`concept_id`, `concept_synonym_name`, `language_concept_id`) VALUES (?, ?, ?)");
    while (csv.line()) {
      try {
        pstmt.setString(1, csv.cell("concept_id"));
        pstmt.setString(2, csv.cell("concept_synonym_name"));
        pstmt.setString(3, csv.cell("language_concept_id"));
        pstmt.executeUpdate();
      } catch (Exception e) {
        t.error(e.getMessage());
      }
      t.step();
    }
    csv.close();
    t.done();
  }


  private void processConceptAncestors(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("ConceptAncestors", 67425885);
    if (!process) {
      t.skip();
      return;
    }

    t.process();
    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_ANCESTOR.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    con.createStatement().execute("CREATE TABLE `ConceptAncestors` (\r\n"+
        "    `ancestor_concept_id` bigint NOT NULL,\r\n"+
        "    `descendant_concept_id` bigint NOT NULL,\r\n"+
        "    `min_levels_of_separation` int DEFAULT NULL,\r\n"+
        "    `max_levels_of_separation` int DEFAULT NULL,\r\n"+
        "    PRIMARY KEY (`ancestor_concept_id`,`descendant_concept_id`)\r\n"+
        "  ) \r\n"+
        "\r\n");
    
    PreparedStatement pstmt = con.prepareStatement("INSERT INTO `ConceptAncestors` (`ancestor_concept_id`, `descendant_concept_id`, `min_levels_of_separation`, `max_levels_of_separation`) VALUES (?, ?, ?, ?)");
    while (csv.line()) {
      try {
        pstmt.setString(1, csv.cell("ancestor_concept_id"));
        pstmt.setString(2, csv.cell("descendant_concept_id"));
        pstmt.setString(3, csv.cell("min_levels_of_separation"));
        pstmt.setString(4, csv.cell("max_levels_of_separation"));
        pstmt.executeUpdate();
      } catch (Exception e) {
        t.error(e.getMessage());
      }
      t.step();
    }
    csv.close();
    t.done();
  }


  private void processConceptRelationships(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    Tracker t = new Tracker("ConceptRelationships", 47000000);
    if (!process) {
      t.skip();
      return;
    }

    t.scan();
    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_RELATIONSHIP.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int lreason = 0;
    while (csv.line()) {
      lreason = max(lreason, csv.cell("invalid_reason"));
      t.step();
    }
    csv.close();
    t.process();

    Statement stmt = con.createStatement();
    stmt.execute("CREATE TABLE `ConceptRelationships` (\r\n"+
        "  `concept_id_1` bigint NOT NULL,\r\n"+
        "  `concept_id_2` bigint NOT NULL,\r\n"+
        "  `relationship_id` bigint NOT NULL,\r\n"+
        "  `valid_start_date` date DEFAULT NULL,\r\n"+
        "  `valid_end_date` date DEFAULT NULL,\r\n"+
        "  `invalid_reason` varchar("+lreason+") DEFAULT NULL)\r\n"+
        "  \r\n");

    stmt.execute("CREATE INDEX `Reverse` on ConceptRelationships (`concept_id_2`,`concept_id_1`,`relationship_id`)");
    stmt.execute("CREATE INDEX `Forward` on ConceptRelationships (`concept_id_1`,`concept_id_2`,`relationship_id`)");  
//  stmt.execute("CREATE INDEX `type1` on ConceptRelationships (`relationship_id`,`concept_id_1`,`concept_id_2`)");
//  stmt.execute("CREATE INDEX `type2` on ConceptRelationships (`relationship_id`,`concept_id_2`,`concept_id_1`)");

    csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_RELATIONSHIP.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);

    PreparedStatement pstmt = con.prepareStatement("INSERT INTO `ConceptRelationships` (`concept_id_1`, `concept_id_2`, `relationship_id`, `valid_start_date`, `valid_end_date`, `invalid_reason`) VALUES (?, ?, ?, ?, ?, ?)");
    while (csv.line()) {
      try {
        pstmt.setString(1, csv.cell("concept_id_1"));
        pstmt.setString(2, csv.cell("concept_id_2"));
        pstmt.setString(3, relationships.get(csv.cell("relationship_id")));
        pstmt.setString(4, csv.cell("valid_start_date"));
        pstmt.setString(5, date(csv.cell("valid_end_date")));
        pstmt.setString(6, date(csv.cell("invalid_reason")));
        pstmt.executeUpdate();
      } catch (Exception e) {
        t.error(e.getMessage());
      }
      t.step();
    }
    csv.close();
    t.done();

  }


  private String date(String cell) {
    return cell;
  }

  private String sw(String value) {
    if (value == null) {
      return  "null";
    }
    StringBuilder b = new StringBuilder();
    b.append('"');
    for (char ch : value.toCharArray()) {
      if (ch == '"') {
        b.append('"');        
      }
      b.append(ch);
    }
    b.append('"');
    return b.toString();
  }

  
}
