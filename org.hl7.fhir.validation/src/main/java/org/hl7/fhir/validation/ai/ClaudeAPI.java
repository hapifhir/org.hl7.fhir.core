package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccessor;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class ClaudeAPI extends AIAPI {

  private static final String API_URL = "https://api.anthropic.com/v1/messages";
  private static final String MODEL = "claude-3-5-sonnet-20241022";

  @Override
  public List<CodeAndTextValidationResult> validateCodings(List<CodeAndTextValidationRequest> requests) throws IOException {
    StringBuilder prompt = new StringBuilder();
    prompt.append("For each of the following cases, determine if the text appropriately matches the code. ");
    prompt.append("Respond in JSON format with an array of objects containing 'index', 'isValid', 'explanation', and 'confidence'.\n\n");

    for (int i = 0; i < requests.size(); i++) {
      CodeAndTextValidationRequest req = requests.get(i);
      prompt.append(String.format("%d. Is '%s' a reasonable text to associate with the %s code %s (display = %s)?\n",
          i + 1, req.getText(), getSystemName(req.getSystem()), req.getCode(), req.getDisplay()));
    }

    String systemPrompt = "You are a medical terminology expert. Evaluate whether text descriptions match their\n"+ 
        "associated clinical codes. Provide detailed explanations for any mismatches. "+
        "Express your confidence level based on how certain you are of the relationship.";

    JsonObject json = getResponse(prompt.toString(), systemPrompt);

    return parseValidationResponse(json, requests);
  }


  public JsonObject getResponse(String prompt, String systemPrompt) throws IOException {
    JsonObject j = new JsonObject();
    j.add("model", "claude-3-5-sonnet-20241022");
    j.add("system", systemPrompt);
    j.add("max_tokens", 1024);
    j.forceArray("messages").addObject().add("role", "user").add("content", prompt);
    
    ManagedWebAccessor web = ManagedWebAccess.accessor(Utilities.strings("web"));
    web.getHeaders().put("anthropic-version", "2023-06-01");
    HTTPResult response = web.post(API_URL, JsonParser.composeBytes(j), "application/json", "application/json");
    response.checkThrowException();
    JsonObject json = JsonParser.parseObject(response.getContentAsString());
    String text = json.getJsonArray("content").get(0).asJsonObject().asString("text");
    return JsonParser.parseObject(text);
  }



  private List<CodeAndTextValidationResult> parseValidationResponse(JsonObject json, List<CodeAndTextValidationRequest> requests) {
    List<CodeAndTextValidationResult> res = new ArrayList<>();
    for (JsonObject o : json.getProperties().get(0).getValue().asJsonArray().asJsonObjects()) {
      CodeAndTextValidationRequest request = requests.get(o.asInteger("index")-1);
      res.add(new CodeAndTextValidationResult(request, o.asBoolean("isValid"), o.asString("explanation"), o.asString("confidence")));
    }
    return res;
  }

}
