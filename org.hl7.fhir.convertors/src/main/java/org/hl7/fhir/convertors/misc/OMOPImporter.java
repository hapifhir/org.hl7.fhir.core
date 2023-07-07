package org.hl7.fhir.convertors.misc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

public class OMOPImporter {


  private Connection con;
  private Map<String, String> relationships = new HashMap<>();

  public static void main(String[] args) throws Exception {
    new OMOPImporter().process("/Users/grahamegrieve/Downloads/vocabulary_download_v5_{97cc5432-0dc9-4f14-9da2-d0624129d2f7}_1688068174909");
  }

  private void process(String folder) throws ClassNotFoundException, SQLException, FHIRException, FileNotFoundException, IOException {
    connect();

    loadRelationships(folder, true);
    processVocabularies(folder, false);
    processDomains(folder, false);
    processConceptClasses(folder, false);
    processDrugStrength(folder, false);
    processConcepts(folder, false);
    processConceptRelationships(folder, false);
    processConceptSynonyms(folder, false);
    processConceptAncestors(folder, false);
  }

  private void loadRelationships(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "RELATIONSHIP.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    Statement stmt = con.createStatement();
    stmt.executeUpdate("delete from Relationships");
    while (csv.line()) {
      relationships.put(csv.cell("relationship_id"), csv.cell("relationship_concept_id"));
      if (process) {
        String sql = "INSERT INTO `omop`.`Relationships` (`relationship_concept_id`, `relationship_id`, `relationship_name`, `is_hierarchical`, `defines_ancestry`, `reverse_relationship_id`) VALUES ("+
            sw(csv.cell("relationship_concept_id"))+", "+
            sw(csv.cell("relationship_id"))+", "+
            sw(csv.cell("relationship_name"))+", "+
            sw(csv.cell("is_hierarchical"))+", "+
            sw(csv.cell("defines_ancestry"))+", "+
            sw(csv.cell("reverse_relationship_id"))+")";
        try {
          stmt.executeUpdate(sql);
        } catch (Exception e) {
          System.out.println("error: "+e.getMessage());
          System.out.println("i: "+i);        
          //        System.out.println("sql: "+sql);        
        }
      }
      i++;
      if (i % 1000 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
    
  }

  private void processVocabularies(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    if (!process) {
      return;
    }

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "VOCABULARY.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    Statement stmt = con.createStatement();
    stmt.executeUpdate("delete from Vocabularies");
    while (csv.line()) {
      String sql = "INSERT INTO `omop`.`Vocabularies` (`vocabulary_concept_id`, `vocabulary_id`, `vocabulary_name`, `vocabulary_reference`, `vocabulary_version`) VALUES ("+
          sw(csv.cell("vocabulary_concept_id"))+", "+
          sw(csv.cell("vocabulary_id"))+", "+
          sw(csv.cell("vocabulary_name"))+", "+
          sw(csv.cell("vocabulary_reference"))+", "+
          sw(csv.cell("vocabulary_version"))+")";
      try {
        stmt.executeUpdate(sql);
      } catch (Exception e) {
        System.out.println("error: "+e.getMessage());
        System.out.println("i: "+i);        
        //        System.out.println("sql: "+sql);      
      }
      i++;
      if (i % 1000 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
  }


  private void processDrugStrength(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    if (!process) {
      return;
    }

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "DRUG_STRENGTH.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    Statement stmt = con.createStatement();
    stmt.executeUpdate("delete from DrugStrengths");
    while (csv.line()) {
      String sql = "INSERT INTO `omop`.`DrugStrengths` (`drug_concept_id`, `ingredient_concept_id`, `amount_value`, `amount_unit_concept_id`, `numerator_value`, `numerator_unit_concept_id`, `denominator_value`, "
          + "`denominator_unit_concept_id`, `box_size`, `valid_start_date`, `valid_end_date`, `invalid_reason`) VALUES ("+
          sw(csv.cell("drug_concept_id"))+", "+
          sw(csv.cell("ingredient_concept_id"))+", "+
          sw(csv.cell("amount_value"))+", "+
          sw(csv.cell("amount_unit_concept_id"))+", "+
          sw(csv.cell("numerator_value"))+", "+
          sw(csv.cell("numerator_unit_concept_id"))+", "+
          sw(csv.cell("denominator_value"))+", "+
          sw(csv.cell("denominator_unit_concept_id"))+", "+
          sw(csv.cell("box_size"))+", "+
          sw(csv.cell("valid_start_date"))+", "+
          sw(csv.cell("valid_end_date"))+", "+
          sw(csv.cell("invalid_reason"))+")";
      try {
        stmt.executeUpdate(sql);
      } catch (Exception e) {
        System.out.println("error: "+e.getMessage());
        System.out.println("i: "+i);        
        System.out.println("sql: "+sql);      
      }
      i++;
      if (i % 100 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
  }
  

  private void processDomains(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    if (!process) {
      return;
    }

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "DOMAIN.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    Statement stmt = con.createStatement();
    stmt.executeUpdate("delete from Domains");
    while (csv.line()) {
      String sql = "INSERT INTO `omop`.`Domains` (`domain_concept_id`, `domain_id`, `domain_name`) VALUES ("+
          sw(csv.cell("domain_concept_id"))+", "+
          sw(csv.cell("domain_id"))+", "+
          sw(csv.cell("domain_name"))+")";
      try {
        stmt.executeUpdate(sql);
      } catch (Exception e) {
        System.out.println("error: "+e.getMessage());
        System.out.println("i: "+i);        
        //        System.out.println("sql: "+sql);      
      }
      i++;
      if (i % 1000 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
  }
  

  private void processConceptClasses(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    if (!process) {
      return;
    }

    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_CLASS.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    Statement stmt = con.createStatement();
    stmt.executeUpdate("delete from ConceptClasses");
    while (csv.line()) {
      String sql = "INSERT INTO `omop`.`ConceptClasses` (`concept_class_concept_id`, `concept_class_id`, `concept_class_name`) VALUES ("+
          sw(csv.cell("concept_class_concept_id"))+", "+
          sw(csv.cell("concept_class_id"))+", "+
          sw(csv.cell("concept_class_name"))+")";
      try {
        stmt.executeUpdate(sql);
      } catch (Exception e) {
        System.out.println("error: "+e.getMessage());
        System.out.println("i: "+i);        
        //        System.out.println("sql: "+sql);      
      }
      i++;
      if (i % 1000 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
  }
  
  

  private void processConcepts(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    if (!process) {
      return;
    }
    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    Statement stmt = con.createStatement();
    while (csv.line()) {
      String sql = "INSERT INTO `omop`.`Concepts` (`concept_id`, `concept_name`, `domain_id`, `vocabulary_id`, `concept_class_id`, `standard_concept`, `concept_code`, `valid_start_date`, `valid_end_date`, `invalid_reason`) VALUES ("+
          sw(csv.cell("concept_id"))+", "+
          sw(csv.cell("concept_name"))+", "+
          sw(csv.cell("domain_id"))+", "+
          sw(csv.cell("vocabulary_id"))+", "+
          sw(csv.cell("concept_class_id"))+", "+
          sw(csv.cell("standard_concept"))+", "+
          sw(csv.cell("concept_code"))+", "+
          sw(csv.cell("valid_start_date"))+", "+
          sw(csv.cell("valid_end_date"))+", "+
          sw(csv.cell("invalid_reason"))+")";
      try {
        stmt.executeUpdate(sql);
      } catch (Exception e) {
        System.out.println("error: "+e.getMessage());
        System.out.println("i: "+i);        
//        System.out.println("sql: "+sql);        
      }
      i++;
      if (i % 1000 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
    
  }

  private void processConceptSynonyms(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    if (!process) {
      return;
    }
    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_SYNONYM.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    int ec = 0;
    Statement stmt = con.createStatement();

    stmt.executeUpdate("delete from ConceptSynonyms");
    while (csv.line()) {
      String sql = "INSERT INTO `omop`.`ConceptSynonyms` (`concept_id`, `concept_synonym_name`, `language_concept_id`) VALUES ("+
          sw(csv.cell("concept_id"))+", "+
          sw(csv.cell("concept_synonym_name"))+", "+
          sw(csv.cell("language_concept_id"))+")";
      try {
        stmt.executeUpdate(sql);
      } catch (Exception e) {
        System.out.println("error: "+e.getMessage());
        System.out.println("i: "+i);        
        System.out.println("sql: "+sql);    
        ec++;
      }
      i++;
      if (i % 1000 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
    System.out.println("Finished. "+i+" rows, "+ec+" errors");
  }
  

  private void processConceptAncestors(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    if (!process) {
      return;
    }
    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_ANCESTOR"
        + ".csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    int ec = 0;
    Statement stmt = con.createStatement();

    stmt.executeUpdate("delete from ConceptAncestors");
    while (csv.line()) {
      String sql = "INSERT INTO `omop`.`ConceptAncestors` (`ancestor_concept_id`, `descendant_concept_id`, `min_levels_of_separation`, `max_levels_of_separation`) VALUES ("+
          sw(csv.cell("ancestor_concept_id"))+", "+
          sw(csv.cell("descendant_concept_id"))+", "+
          sw(csv.cell("min_levels_of_separation"))+", "+
          sw(csv.cell("max_levels_of_separation"))+")";
      try {
        stmt.executeUpdate(sql);
      } catch (Exception e) {
        System.out.println("error: "+e.getMessage());
        System.out.println("i: "+i);        
        System.out.println("sql: "+sql);    
        ec++;
      }
      i++;
      if (i % 1000 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
    System.out.println("Finished. "+i+" rows, "+ec+" errors");
  }
  
  
  private void processConceptRelationships(String folder, boolean process) throws FHIRException, FileNotFoundException, IOException, SQLException {
    if (!process) {
      return;
    }
    CSVReader csv = new CSVReader(new FileInputStream(Utilities.path(folder, "CONCEPT_RELATIONSHIP.csv")));
    csv.setDelimiter('\t');
    csv.readHeaders();
    csv.setDoingQuotes(false);
    int i = 0;
    Statement stmt = con.createStatement();
    while (csv.line()) {
      String sql = "INSERT INTO `omop`.`ConceptRelationships` (`concept_id_1`, `concept_id_2`, `relationship_id`, `valid_start_date`, `valid_end_date`, `invalid_reason`) VALUES ("+
          sw(csv.cell("concept_id_1"))+", "+
          sw(csv.cell("concept_id_2"))+", "+
          sw(relationships.get(csv.cell("relationship_id")))+", "+
          sw(csv.cell("valid_start_date"))+", "+
          sw(csv.cell("valid_end_date"))+", "+
          sw(csv.cell("invalid_reason"))+")";
      try {
        stmt.executeUpdate(sql);
      } catch (Exception e) {
        System.out.println("error: "+e.getMessage());
        System.out.println("i: "+i);        
//        System.out.println("sql: "+sql);        
      }
      i++;
      if (i % 100 == 0) {
        System.out.println(i);
      }
    }
    csv.close();    
    
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

  private void connect() throws SQLException, ClassNotFoundException {
//    Class.forName("com.mysql.jdbc.Driver");  
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omop?useSSL=false","root","@AZEq|OzHLl1/[50v[CI"); 
    
  }
  
}
