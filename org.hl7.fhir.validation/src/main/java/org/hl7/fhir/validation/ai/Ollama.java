package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccessor;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

@Slf4j
public class Ollama extends AIAPI {

  private static final String MODEL = "llama3.2";

  private String url;
  private String model;
  
  protected Ollama(JsonObject config, String details) throws MalformedURLException {
    super(config);
    model = config.has("model") ? config.asString("model") :  MODEL;
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
  @SuppressWarnings("checkstyle:systemout")
  public List<CodeAndTextValidationResult> validateCodings(List<CodeAndTextValidationRequest> requests) throws IOException {
    List<CodeAndTextValidationResult> res = new ArrayList<>();
    for ( CodeAndTextValidationRequest req : requests) {
      StringBuilder prompt = new StringBuilder();

      for (String s : config.forceArray("prompt").asStrings()) {
        prompt.append(String.format(s,
            Integer.toString(1), req.getText(), getSystemName(req.getSystem()), req.getCode(), req.getDisplay(), req.getContext(), req.getLang()));
          prompt.append("\n");
      }
      
      System.out.print(".");
      log.debug("  processed request");
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
    FileUtilities.stringToFile(text, Utilities.path("[tmp]", "fhir-validator-ollama-response.json"));
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
