package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class ChatGPTAPI extends AIAPI {
  private static final String API_URL = "https://api.openai.com/v1/chat/completions";
  private static final String MODEL = "gpt-4o-mini";
  
  @Override
  public List<CodeAndTextValidationResult> validateCodings(List<CodeAndTextValidationRequest> requests) throws IOException {
    StringBuilder prompt = new StringBuilder();
    prompt.append("For each of the following cases, determine if the text appropriately matches the code. ");
    prompt.append("Respond in JSON format with an array of objects containing 'index', 'isValid', 'explanation', and 'confidence'.\n\n");

    for (int i = 0; i < requests.size(); i++) {
      CodeAndTextValidationRequest req = requests.get(i);
      prompt.append(String.format("%d. Is '%s' a reasonable text to associate with the %s code %s (display '%s')\n",
          i + 1, req.getText(), getSystemName(req.getSystem()), req.getCode(), req.getDisplay()));
    }

    String systemPrompt = "You are a medical terminology expert. Evaluate whether text descriptions match their\n"+ 
        "associated clinical codes. Provide detailed explanations for any mismatches. "+
        "Express your confidence level based on how certain you are of the relationship.";

    JsonArray json = getResponse(prompt.toString(), systemPrompt);

    return parseValidationResponse(json, requests);
  }

  public JsonArray getResponse(String prompt, String systemPrompt) throws IOException {
    JsonObject json = new JsonObject();
    json.add("model", MODEL);
    json.forceArray("messages").addObject().add("role", "system").add("content", systemPrompt);
    json.forceArray("messages").addObject().add("role", "user").add("content", prompt);

    HTTPResult response = ManagedWebAccess.post(Utilities.strings("web") , API_URL, JsonParser.composeBytes(json),
        "application/json", "application/json");
    response.checkThrowException();
    json = JsonParser.parseObject(response.getContentAsString());
    String text = json.getJsonArray("choices").get(0).asJsonObject().getJsonObject("message").asString("content");
    text = text.replace("```", "").substring(4);
    return (JsonArray) JsonParser.parse(text);
  }

  private List<CodeAndTextValidationResult> parseValidationResponse(JsonArray json, List<CodeAndTextValidationRequest> requests) {
    List<CodeAndTextValidationResult> res = new ArrayList<>();
    for (JsonObject o : json.asJsonObjects()) {
      CodeAndTextValidationRequest request = requests.get(o.asInteger("index")-1);
      res.add(new CodeAndTextValidationResult(request, o.asBoolean("isValid"), o.asString("explanation"), o.asString("confidence")));
    }
    return res;
  }
}
