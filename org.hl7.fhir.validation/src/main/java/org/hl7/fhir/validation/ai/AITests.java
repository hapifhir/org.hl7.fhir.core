package org.hl7.fhir.validation.ai;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;

/**
 *
 */
@Slf4j
public class AITests {

  public class StatsRecord {

    public int total;
    public int correct;
    public int correctNeg;
    public int correctPos;
    public int wrong;
    public int falseNegative;
    public int actualNegatives;
    public int falsePositive;

    public String summary() {
      //  % corr. 9| %false+ 9| %false- 9| sensitivity 13| specificity 13| PPV 5
      StringBuilder b = new StringBuilder();
      b.append("| ");
      b.append(Utilities.padRight((correct * 100) / total, ' ', 7));
      b.append("| ");
      b.append(Utilities.padRight((correctNeg * 100) / total, ' ', 5));
      b.append("| ");
      b.append(Utilities.padRight((correctPos * 100) / total, ' ', 5));
      b.append("| ");
      b.append(Utilities.padRight(falsePosRate(), ' ', 7));
      b.append("| ");
      b.append(Utilities.padRight(falseNegRate(), ' ', 7));
      b.append("| ");
      b.append(Utilities.padRight(sensitivity(), ' ', 12));
      b.append("| ");
      b.append(Utilities.padRight(specificity(), ' ', 12));
      b.append("| ");
      b.append(Utilities.padRight(ppv(), ' ', 5));
      b.append("|");
      return b.toString();
    }

    private int ppv() {
      double tp = total - actualNegatives;
      double fp = falsePositive;
      double ppv = tp / (tp + fp);
      return (int) (ppv * 100);
    }

    private int specificity() {
      double tn = actualNegatives;
      double fp = falsePositive;
      double specificity = tn / (tn + fp); 
      return (int) (specificity * 100);
    }

    private int sensitivity() {
      double tp = total = actualNegatives;
      double fn = falseNegative;
      double sensitivity = tp / (tp + fn);
      return (int) (sensitivity * 100);
    }

    private int falseNegRate() {
      double fn = falseNegative;
      double tp = total - actualNegatives;
      double fnr = fn / (fn + tp); 
      return (int) (fnr * 100);
    }

    private int falsePosRate() {
      double fp = falsePositive;  
      double tn = actualNegatives;
      double fpr = fp / (fp + tn); 
      return (int) (fpr * 100);
    }

    public void update(boolean expected, boolean passed) {
      total++;
      if (expected) {
        if (passed == expected) {
          correctPos++;
        }        
      } else {
        if (passed == expected) {
          correctNeg++;
        }
        actualNegatives++;
      }
      if (passed == expected) {
        correct++;
      } else {
        wrong++;
        if (expected) {
          falseNegative++;
        } else {
          falsePositive++;
        }
      }      
    }
  }

  public static void main(String[] args) throws IOException {
    new AITests().execute(args[0], args.length == 1 ? null : args[1], args.length == 2 ? true : "true".equals(args[2]));
  }

  @SuppressWarnings("checkstyle:systemout")
  public void execute(String testFilename, String config, boolean useServers) throws IOException {
    ManagedWebAccess.loadFromFHIRSettings();

    InputStream cfg = null;
    if (config == null) {
      ClassLoader classLoader = HierarchicalTableGenerator.class.getClassLoader();
      cfg = classLoader.getResourceAsStream("ai-prompts.json");
    } else { 
      cfg = new FileInputStream(config);
    }
    JsonObject jcfg = JsonParser.parseObject(cfg);
    
    JsonObject tests = JsonParser.parseObject(new File(testFilename));
    List<CodeAndTextValidationRequest> requests = new ArrayList<>();
    int c = 0;
    for (JsonObject test : tests.getJsonArray("cases").asJsonObjects()) {
      requests.add(new CodeAndTextValidationRequest(null, test.asString("path"), test.asString("lang"), test.asString("system"), test.asString("code"), 
          test.asString("display"),test.asString("text")).setData(test));   
      boolean expected = test.asString("goal").startsWith("valid");  
      if (expected) {
        c++;
      }
    }
    log.info("Found "+requests.size()+" tests, "+c+" should be valid");

    long t;
    if (useServers) {

      System.out.print("Ollama");
      log.debug("Ollama");
      t = System.currentTimeMillis();
      List<CodeAndTextValidationResult> resOllama = new Ollama(jcfg.forceObject("ollama"), null).validateCodings(requests);
      log.info(": "+Utilities.describeDuration(System.currentTimeMillis() - t));
      
      System.out.print("ChatGPT");
      log.debug("ChatGPT");
      t = System.currentTimeMillis();
      List<CodeAndTextValidationResult> resChatGPT = new ChatGPTAPI(jcfg.forceObject("chatGPT")).validateCodings(requests);
      log.info(": "+Utilities.describeDuration(System.currentTimeMillis() - t));

      System.out.print("Claude");
      log.debug("Claude");
      t = System.currentTimeMillis();
      List<CodeAndTextValidationResult> resClaude = new ClaudeAPI(jcfg.forceObject("claude")).validateCodings(requests);
      log.info(": "+Utilities.describeDuration(System.currentTimeMillis() - t));


      log.info("");

      for (int i = 0; i < requests.size(); i++) {
        CodeAndTextValidationRequest req = requests.get(i);
        JsonObject test = (JsonObject) req.getData();
        log.info("Case "+req.getSystem()+"#"+req.getCode()+" ('"+req.getDisplay()+"') :: '"+req.getText()+"'");
        CodeAndTextValidationResult res = resClaude.get(i);
        log.info("  Claude : "+check(test, res, "claude")+"; "+res.summary());
        res = resChatGPT.get(i);
        log.info("  ChatGPT: "+check(test, res, "chatgpt")+"; "+res.summary());
        res = resOllama.get(i);
        log.info("  Ollama : "+check(test, res, "ollama")+"; "+res.summary());
        log.info("");
      }
    }

    StatsRecord claude = new StatsRecord();
    StatsRecord chatGPT = new StatsRecord();
    StatsRecord ollama = new StatsRecord();

    for (int i = 0; i < requests.size(); i++) {
      System.out.print(".");
      CodeAndTextValidationRequest req = requests.get(i);
      JsonObject test = (JsonObject) req.getData();
      test.remove("disagrement");
      test.remove("unanimous");
      boolean expected = test.asString("goal").startsWith("valid");
      boolean bClaude = test.getJsonObject("claude").asBoolean("valid");
      boolean bChatGPT = test.getJsonObject("chatgpt").asBoolean("valid");
      boolean bOllama = test.getJsonObject("ollama").asBoolean("valid");
      claude.update(expected, bClaude);
      chatGPT.update(expected, bChatGPT);
      ollama.update(expected, bOllama);
//      boolean agreement = (bClaude == expected) && (bChatGPT == expected) && (bOllama == expected);
//      boolean unanimous = (bClaude == bChatGPT) && (bClaude == bOllama);
//      if (!agreement) {
//        test.add("disagrement", true);
//        if (unanimous) {
//          test.add("unanimous", true);        
//        }
//      }
    }
//    JsonParser.compose(tests, new File(testFilename), true);

    log.info("");
    log.info("        | Number tests correct | %False results  | Classic Diagnostic Statistics    |");
    log.info("        | #All  | #Neg  | #Pos | %F.Pos | %F.Neg | sensitivity | specificity | PPV  |");
    log.info("-------------------------------------------------------------------------------------");
    log.info("Claude  "+claude.summary());
    log.info("ChatGPT "+chatGPT.summary());
    log.info("Ollama  "+ollama.summary());

    doTable("Claude", claude);
    doTable("ChatGPT", chatGPT);
    doTable("Ollama", ollama);
  }

  private void doTable(String name, StatsRecord rec) {
    log.info("");
    log.info("");
    log.info(Utilities.padRight(name, ' ', 7)+" | Valid | Invalid |");
    log.info("--------------------------|");
    log.info("Correct | "+Utilities.padRight(rec.correctPos, ' ', 5)+" | "+Utilities.padRight(rec.correctNeg, ' ', 7)+" |");
    log.info("Wrong   | "+Utilities.padRight(rec.falsePositive, ' ', 5)+" | "+Utilities.padRight(rec.falseNegative, ' ', 7)+" |");
  }

  private String check(JsonObject test, CodeAndTextValidationResult res, String code) {
    boolean passed = res.isValid();
    boolean expected = test.asString("goal").startsWith("valid");
    JsonObject o = test.forceObject(code);
    o.set("valid", res.isValid());
    o.set("explanation", res.getExplanation());
    o.set("confidence", res.getConfidence());
    if (passed == expected) {
      return "T ";
    } else {
      return "F:"+(passed ? "T" : "F");
    }
  }

}
