package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;

@Slf4j
public class CodeAndTextValidator {

  private String aiService;
  private Connection db;
  private PreparedStatement select;
  private PreparedStatement insert;

  public CodeAndTextValidator(String cacheFolder, String aiService) throws FHIRException {
    this.aiService = aiService;
    try {
      String filename = Utilities.path(cacheFolder, "ai-"+aiService+".db");
      db  = DriverManager.getConnection("jdbc:sqlite:"+filename); 
      DatabaseMetaData meta = db.getMetaData();
      ResultSet rs = meta.getTables(null, null, "CodeAndText", new String[] {"TABLE"});
      boolean exists = rs.next(); 
      if (!exists) {
        Statement stmt = db.createStatement();
        stmt.execute("CREATE TABLE CodeAndText (\r\n"+
            "System    nvarchar NOT NULL,\r\n"+
            "Code   nvarchar NOT NULL,\r\n"+
            "Lang   nvarchar NOT NULL,\r\n"+
            "Text  nvarchar NOT NULL,\r\n"+
            "Valid  integer NOT NULL,\r\n"+
            "Explanation  nvarchar NOT NULL,\r\n"+
            "Confidence  nvarchar NOT NULL,\r\n"+
            "PRIMARY KEY (System,Code,Text))\r\n");
      }
      select = db.prepareStatement("Select Valid, Explanation, Confidence from CodeAndText where System = ? and Code = ? and Lang = ? and Text = ?");
      insert = db.prepareStatement("Insert into CodeAndText (System, Code, Lang, Text, Valid , Explanation, Confidence) values (?, ?, ?, ?, ?, ?, ?)");
    } catch (Exception e) {
      throw new FHIRException("Exception opening AI Cache: "+e.getMessage(), e);
    }
  }

  public List<CodeAndTextValidationResult> validateCodings(List<CodeAndTextValidationRequest> requests) throws IOException {
    try {
      // first, split the list by cache
      List<CodeAndTextValidationResult> results = new ArrayList<CodeAndTextValidationResult>();
      List<CodeAndTextValidationRequest> query =  new ArrayList<CodeAndTextValidationRequest>();

      for (CodeAndTextValidationRequest req : requests) {
        CodeAndTextValidationResult cached = findExistingResult(req);
        if (cached != null) {
          results.add(cached);
        } else {
          query.add(req);
        }
      }

      ClassLoader classLoader = HierarchicalTableGenerator.class.getClassLoader();
      InputStream cfg = classLoader.getResourceAsStream("ai-prompts.json");
      JsonObject jcfg = JsonParser.parseObject(cfg);
      
      List<CodeAndTextValidationResult> outcomes = null;
      if (query.size() > 0) {
        switch (aiService.toLowerCase()) {
        case "claude" :
          log.info("Consulting Claude about "+query.size()+" code/text combinations");
          outcomes = new ClaudeAPI(jcfg.forceObject("claude")).validateCodings(query);
          break;
        case "chatgpt" : 
          log.info("Consulting ChatGPT about "+query.size()+" code/text combinations");
          outcomes = new ChatGPTAPI(jcfg.forceObject("chatGPT")).validateCodings(query);
          break;
        case "ollama" : 
          log.info("Consulting Ollama about "+query.size()+" code/text combinations");
          outcomes = new Ollama(jcfg.forceObject("ollama"), null).validateCodings(query);
          break;
        default: 
          if (aiService.toLowerCase().startsWith("ollama:")) {
            Ollama ollama = new Ollama(jcfg.forceObject("ollama"), aiService.substring(7));
            log.info("Consulting Ollama at "+ollama.details()+" "+query.size()+" code/text combinations");
            outcomes = ollama.validateCodings(query);            
          } else {
            throw new FHIRException("Unknown AI Service "+aiService);
          }
        }
        for (CodeAndTextValidationResult o : outcomes) {
          results.add(o);
          storeResult(o);
        }
      }
      return results;
    } catch (IOException e) {
      throw e;
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }


  private CodeAndTextValidationResult findExistingResult(CodeAndTextValidationRequest req) throws SQLException {
    select.setString(1, req.getSystem());
    select.setString(2, req.getCode());
    select.setString(3, req.getLang());
    select.setString(4, req.getText());
    ResultSet rs = select.executeQuery();
    if (rs.next()) {
      return new CodeAndTextValidationResult(req, rs.getInt(1) == 1, rs.getString(2), rs.getString(3));
    } else {
      return null;
    }
  }

  private void storeResult(CodeAndTextValidationResult o) throws SQLException {
    insert.setString(1, o.getRequest().getSystem());
    insert.setString(2, o.getRequest().getCode());
    insert.setString(3, o.getRequest().getLang());
    insert.setString(4, o.getRequest().getText());
    insert.setInt(5, o.isValid() ? 1 : 0);
    insert.setString(6, o.getExplanation());
    insert.setString(7, o.getConfidence());
    insert.execute();
  }


}
