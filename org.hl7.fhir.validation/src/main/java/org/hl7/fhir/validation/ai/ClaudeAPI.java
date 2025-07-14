package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccessor;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

@Slf4j
public class ClaudeAPI extends AIAPI {

  private static final String API_URL = "https://api.anthropic.com/v1/messages";
  private static final String MODEL = "claude-3-5-sonnet-20241022";
  private String model;

  protected ClaudeAPI(JsonObject config) {
    super(config);
    model = config.has("model") ? config.asString("model") :  MODEL;
  }

  @Override
  @SuppressWarnings("checkstyle:systemout")
  public List<CodeAndTextValidationResult> validateCodings(List<CodeAndTextValidationRequest> requests) throws IOException {
    // limit to 5 in a batch 
    List<List<CodeAndTextValidationRequest>> chunks = new ArrayList<>();
    for (int i = 0; i < requests.size(); i += 4) {
      chunks.add(requests.subList(i, Math.min(i + 4, requests.size())));
    }
    List<CodeAndTextValidationResult> results = new ArrayList<CodeAndTextValidationResult>();
    int c = 0;

    for (List<CodeAndTextValidationRequest> chunk : chunks) {

      StringBuilder prompt = new StringBuilder();
      for (String s : config.forceArray("prompt").asStrings()) {
        prompt.append(s);
        prompt.append("\n");
      }

      for (int i = 0; i < chunk.size(); i++) {
        CodeAndTextValidationRequest req = chunk.get(i);
        prompt.append(String.format(config.asString("item"),
            Integer.toString(i + 1), req.getText(), getSystemName(req.getSystem()), req.getCode(), req.getDisplay(), req.getContext(), req.getLang()));
        prompt.append("\n");
      }

      StringBuilder systemPrompt = new StringBuilder();
      for (String s : config.forceArray("prompt").asStrings()) {
        systemPrompt.append(s);
        systemPrompt.append("\n");
      }

      System.out.print(".");
      log.debug("  processed request");
      JsonObject json = getResponse(prompt.toString(), systemPrompt.toString());

      parseValidationResponse(json, chunk, results);
      c+= 4;
    }
    return results;
  }

  public JsonObject getResponse(String prompt, String systemPrompt) throws IOException {
    JsonObject j = new JsonObject();
    j.add("model", model);
    j.add("system", systemPrompt);
    j.add("max_tokens", 1024);
    j.forceArray("messages").addObject().add("role", "user").add("content", prompt);
    
    ManagedWebAccessor web = ManagedWebAccess.accessor(Utilities.strings("web"));
    web.getHeaders().put("anthropic-version", "2023-06-01");
    HTTPResult response = web.post(API_URL, JsonParser.composeBytes(j), "application/json", "application/json");
    response.checkThrowException();
    JsonObject json = JsonParser.parseObject(response.getContentAsString());
    String text = json.getJsonArray("content").get(0).asJsonObject().asString("text");
    FileUtilities.stringToFile(text, Utilities.path("[tmp]", "fhir-validator-claude-response.json"));
    return JsonParser.parseObject(text);
  }



  private void parseValidationResponse(JsonObject json, List<CodeAndTextValidationRequest> requests, List<CodeAndTextValidationResult> res) {
    for (JsonObject o : json.getProperties().get(0).getValue().asJsonArray().asJsonObjects()) {
      CodeAndTextValidationRequest request = requests.get(o.asInteger("index")-1);
      res.add(new CodeAndTextValidationResult(request, o.asBoolean("isCompatible"), o.asString("explanation"), o.asString("confidence")));
    }
  }

}
