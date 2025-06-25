package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
@Slf4j
public class ChatGPTAPI extends AIAPI {
  private static final String API_URL = "https://api.openai.com/v1/chat/completions";
  private static final String MODEL = "gpt-4o-mini";
  private String model;
  
  protected ChatGPTAPI(JsonObject config) {
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
      }

      StringBuilder systemPrompt = new StringBuilder();
      for (String s : config.forceArray("prompt").asStrings()) {
        systemPrompt.append(s);
        systemPrompt.append("\n");
      }
      System.out.print(".");
      log.debug("  processed request");
      JsonArray json = getResponse(prompt.toString(), systemPrompt.toString());

       parseValidationResponse(json, chunk, results);
       c += 4;
    } 
    return results;
  }

  public JsonArray getResponse(String prompt, String systemPrompt) throws IOException {
    JsonObject json = new JsonObject();
    json.add("model", model);
    json.forceArray("messages").addObject().add("role", "system").add("content", systemPrompt);
    json.forceArray("messages").addObject().add("role", "user").add("content", prompt);

    HTTPResult response = ManagedWebAccess.post(Utilities.strings("web") , API_URL, JsonParser.composeBytes(json),
        "application/json", "application/json");
    response.checkThrowException();
    json = JsonParser.parseObject(response.getContentAsString());
    String text = json.getJsonArray("choices").get(0).asJsonObject().getJsonObject("message").asString("content");
    text = text.replace("```", "").substring(4);

    FileUtilities.stringToFile(text, Utilities.path("[tmp]", "fhir-validator-chatgpt-response.json"));
    return (JsonArray) JsonParser.parse(text);
  }

  private void parseValidationResponse(JsonArray json, List<CodeAndTextValidationRequest> requests, List<CodeAndTextValidationResult> res) {
    for (JsonObject o : json.asJsonObjects()) {
      CodeAndTextValidationRequest request = requests.get(o.asInteger("index")-1);
      res.add(new CodeAndTextValidationResult(request, o.asBoolean("isCompatible"), o.asString("explanation"), o.asString("confidence")));
    }
  }
}
