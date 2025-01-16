package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccessor;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class Ollama extends AIAPI {

  private static final String MODEL = "llama3.2";

  private String url;
  private String model;
  
  protected Ollama(String details) throws MalformedURLException {
    super();
    model = MODEL;
    if (details == null) {
      url = "http://localhost:11434/api/generate";
    } else {
      if (details.contains("#")) {
        model = details.substring(details.indexOf("#")+1);
        details = details.substring(0, details.indexOf("#"));
      }
      if (Utilities.noString(details)) {
        url = "http://localhost:11434/api/generate";        
      } else if (Utilities.isInteger(details)) {
        url = "http://localhost:"+details+"/api/generate";
      } else {
        url = details;        
      }
    }
  }

  public String details() {    
    return url+" using model "+model;
  }

  @Override
  public List<CodeAndTextValidationResult> validateCodings(List<CodeAndTextValidationRequest> requests) throws IOException {
    List<CodeAndTextValidationResult> res = new ArrayList<>();
    for ( CodeAndTextValidationRequest req : requests) {
      StringBuilder prompt = new StringBuilder();
//      prompt.append("You are a medical terminology expert. Evaluate whether the text description '"+req.getText()+"' matches the\n"+ 
//          "clinical code '"+req.getCode()+"' from '"+getSystemName(req.getSystem())+"' which has a display of '"+req.getDisplay()+"'. Provide detailed explanations for any mismatches. "+
//          "It's ok if the text includes more details than the code. Express your confidence level based on how certain you are of the relationship.\n\n");
//      prompt.append("Respond in JSON format with an object containing 'isValid', 'explanation', and 'confidence'.\n\n");

      prompt.append("Evaluate if B can't be a description of the same situation as the data presented in A.\r\n");
      prompt.append("\r\n");
      prompt.append("* B may be significantly more or less specific than A.\r\n");
      prompt.append("* Provide detailed explanations for your reasoning.\r\n");
      prompt.append("* It's ok if the text includes more or less information than the code.\r\n");
      prompt.append("* Respond in JSON format with an object containing a boolean property 'isCompatible', and string properties 'explanation' and 'confidence'\r\n");
      prompt.append("\r\n");
      prompt.append("A\r\n");
      prompt.append("Code: "+getSystemName(req.getSystem())+", '"+req.getCode()+"'\r\n");
      prompt.append("Text: '"+req.getDisplay()+"'\r\n");
      prompt.append("\r\n");
      prompt.append("B\r\n");
      prompt.append(req.getText()+"\r\n");
      
      System.out.print(".");
      JsonObject json = getResponse(prompt.toString());

      res.add(parseValidationResponse(json, req));
    }
    return res;
  }


  public JsonObject getResponse(String prompt) throws IOException {
    JsonObject j = new JsonObject();
    j.add("model", model);
    j.add("format", "json");
    j.add("stream", false);
    j.add("prompt", prompt);
  
    ManagedWebAccessor web = ManagedWebAccess.accessor(Utilities.strings("web"));
    HTTPResult response = web.post(url, JsonParser.composeBytes(j), "application/json", "application/json");
    response.checkThrowException();
    JsonObject json = JsonParser.parseObject(response.getContentAsString());
    String text = json.asString("response");
    TextFile.stringToFile(text, Utilities.path("[tmp]", "fhir-validator-ollama-response.json"));
    return JsonParser.parseObject(text);
  }



  private CodeAndTextValidationResult parseValidationResponse(JsonObject json, CodeAndTextValidationRequest request) throws IOException {
    // what ollama returns is unpredictable
    if (json.has("explanation") && json.has("isCompatible")) {
      return parseItem(request, json);      
    } else {
      throw new FHIRException("Unable to understand ollama's response json: see "+Utilities.path("[tmp]", "fhir-validator-ollama-response.json"));
    }
  }

  public CodeAndTextValidationResult parseItem(CodeAndTextValidationRequest request, JsonObject o) {
    return new CodeAndTextValidationResult(request, o.asBoolean("isCompatible"), o.asString("explanation"), o.asString("confidence"));
  }


}
