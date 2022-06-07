package org.hl7.fhir.r4b.elementmodel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.formats.IParser.OutputStyle;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JsonUtilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.json.JsonTrackingParser.LocationData;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * this class is actually a smart health cards validator. 
 * It's going to parse the JWT and assume that it contains 
 * a smart health card, which has a nested bundle in it, and 
 * then validate the bundle. 
 * 
 * See https://spec.smarthealth.cards/#health-cards-are-encoded-as-compact-serialization-json-web-signatures-jws
 * 
 * This parser dose the JWT work, and then passes the JsonObject through to the underlying JsonParser
 *
 * Error locations are in the decoded payload
 * 
 * @author grahame
 *
 */
public class SHCParser extends ParserBase {

  private JsonParser jsonParser;
  private Map<JsonElement, LocationData> map;
  private List<String> types = new ArrayList<>();
  
  public SHCParser(IWorkerContext context) {
    super(context);
    jsonParser = new JsonParser(context);
  }

  public List<NamedElement> parse(InputStream stream) throws IOException, FHIRFormatError, DefinitionException, FHIRException {
    List<NamedElement> res = new ArrayList<>();
    String src = TextFile.streamToString(stream).trim();
    List<String> list = new ArrayList<>();
    String pfx = null;
    if (src.startsWith("{")) {
      JsonObject json = JsonTrackingParser.parseJson(src);
      if (checkProperty(json, "$", "verifiableCredential", true, "Array")) {
       pfx = "verifiableCredential";
       JsonArray arr = json.getAsJsonArray("verifiableCredential");
       int i = 0;
       for (JsonElement e : arr) {
         if (!(e instanceof JsonPrimitive)) {
           logError(line(e), col(e), "$.verifiableCredential["+i+"]", IssueType.STRUCTURE, "Wrong Property verifiableCredential in JSON Payload. Expected : String but found "+JsonUtilities.type(e), IssueSeverity.ERROR);                
         } else {
           list.add(e.getAsString());
         }
         i++;
       }
      } else {
        return res;
      }      
    } else {
      list.add(src);
    }
    int c = 0;
    for (String ssrc : list) {
      String prefix = pfx == null ? "" : pfx+"["+Integer.toString(c)+"].";
      c++;
      JWT jwt = null;
      try {
        jwt = decodeJWT(ssrc);
      } catch (Exception e) {
        logError(1, 1, prefix+"JWT", IssueType.INVALID, "Unable to decode JWT token", IssueSeverity.ERROR);
        return res;      
      }
      map = jwt.map;

      checkNamedProperties(jwt.getPayload(), prefix+"payload", "iss", "nbf", "vc");
      checkProperty(jwt.getPayload(), prefix+"payload", "iss", true, "String");
      logError(1, 1, prefix+"JWT", IssueType.INFORMATIONAL, "The FHIR Validator does not check the JWT signature "+
          "(see https://demo-portals.smarthealth.cards/VerifierPortal.html or https://github.com/smart-on-fhir/health-cards-dev-tools) (Issuer = '"+jwt.getPayload().get("iss").getAsString()+"')", IssueSeverity.INFORMATION);
      checkProperty(jwt.getPayload(), prefix+"payload", "nbf", true, "Number");
      JsonObject vc = jwt.getPayload().getAsJsonObject("vc");
      if (vc == null) {
        logError(1, 1, "JWT", IssueType.STRUCTURE, "Unable to find property 'vc' in the payload", IssueSeverity.ERROR);
        return res;
      }
      String path = prefix+"payload.vc";
      checkNamedProperties(vc, path, "type", "credentialSubject");
      if (!checkProperty(vc, path, "type", true, "Array")) {
        return res;
      }
      JsonArray type = vc.getAsJsonArray("type");
      int i = 0;
      for (JsonElement e : type) {
        if (!(e instanceof JsonPrimitive)) {
          logError(line(e), col(e), path+".type["+i+"]", IssueType.STRUCTURE, "Wrong Property Type in JSON Payload. Expected : String but found "+JsonUtilities.type(e), IssueSeverity.ERROR);
        } else {
          types.add(e.getAsString());
        }
        i++;
      }
      if (!types.contains("https://smarthealth.cards#health-card")) {
        logError(line(vc), col(vc), path, IssueType.STRUCTURE, "Card does not claim to be of type https://smarthealth.cards#health-card, cannot validate", IssueSeverity.ERROR);
        return res;
      }
      if (!checkProperty(vc, path, "credentialSubject", true, "Object")) {
        return res;
      }
      JsonObject cs = vc.getAsJsonObject("credentialSubject");
      path = path+".credentialSubject";
      if (!checkProperty(cs, path, "fhirVersion", true, "String")) {
        return res;
      }
      JsonElement fv = cs.get("fhirVersion");
      if (!VersionUtilities.versionsCompatible(context.getVersion(), fv.getAsString())) {
        logError(line(fv), col(fv), path+".fhirVersion", IssueType.STRUCTURE, "Card claims to be of version "+fv.getAsString()+", cannot be validated against version "+context.getVersion(), IssueSeverity.ERROR);
        return res;
      }
      if (!checkProperty(cs, path, "fhirBundle", true, "Object")) {
        return res;
      }
      // ok. all checks passed, we can now validate the bundle
      Element e = jsonParser.parse(cs.getAsJsonObject("fhirBundle"), map);
      if (e != null) {
        res.add(new NamedElement(path, e));
      }
    }
    return res;
  }
  

  @Override
  public String getImpliedProfile() {
    if (types.contains("https://smarthealth.cards#covid19") && types.contains("https://smarthealth.cards#immunization")) {
      return "http://hl7.org/fhir/uv/shc-vaccination/StructureDefinition/shc-vaccination-bundle-dm";
    }
    if (types.contains("https://smarthealth.cards#covid19") && types.contains("https://smarthealth.cards#laboratory")) {
      return "http://hl7.org/fhir/uv/shc-vaccination/StructureDefinition/shc-covid19-laboratory-bundle-dm";
    }
    if (types.contains("https://smarthealth.cards#laboratory")) {
      return "http://hl7.org/fhir/uv/shc-vaccination/StructureDefinition/shc-infectious-disease-laboratory-bundle-dm";
    }
    return null;
  }
  

  private boolean checkProperty(JsonObject obj, String path, String name, boolean required, String type) {
    JsonElement e = obj.get(name);
    if (e != null) {
      String t = JsonUtilities.type(e);
      if (!type.equals(t)) {
        logError(line(e), col(e), path+"."+name, IssueType.STRUCTURE, "Wrong Property Type in JSON Payload. Expected : "+type+" but found "+t, IssueSeverity.ERROR);                
      } else {
        return true;
      }
    } else if (required) {
      logError(line(obj), col(obj), path, IssueType.STRUCTURE, "Missing Property in JSON Payload: "+name, IssueSeverity.ERROR);                
    } else {
      return true;
    }
    return false;
  }

  private void checkNamedProperties(JsonObject obj, String path, String... names) {
    for (Entry<String, JsonElement> e : obj.entrySet()) {
      if (!Utilities.existsInList(e.getKey(), names)) {
        logError(line(e.getValue()), col(e.getValue()), path+"."+e.getKey(), IssueType.STRUCTURE, "Unknown Property in JSON Payload", IssueSeverity.WARNING);                
      }
    }
  }
  
  private int line(JsonElement e) {
    if (map == null|| !map.containsKey(e))
      return -1;
    else
      return map.get(e).getLine();
  }

  private int col(JsonElement e) {
    if (map == null|| !map.containsKey(e))
      return -1;
    else
      return map.get(e).getCol();
  }



  public void compose(Element e, OutputStream destination, OutputStyle style, String base)  throws FHIRException, IOException {
    throw new FHIRFormatError("Writing resources is not supported for the SHC format");
    // because then we'd have to try to sign, and we're just not going to be doing that from the element model
  }

  
  public static class JWT {

    private JsonObject header;
    private JsonObject payload;
    public Map<JsonElement, LocationData> map = new HashMap<>();
    
    public JsonObject getHeader() {
      return header;
    }
    public void setHeader(JsonObject header) {
      this.header = header;
    }
    public JsonObject getPayload() {
      return payload;
    }
    public void setPayload(JsonObject payload) {
      this.payload = payload;
    }
  }

  private static final int BUFFER_SIZE = 1024;
  public static final String CURRENT_PACKAGE = "hl7.fhir.uv.shc-vaccination#0.6.2";
  private static final int MAX_ALLOWED_SHC_LENGTH = 1195;
  
  // todo: deal with chunking
  public static String decodeQRCode(String src) {
    StringBuilder b = new StringBuilder();
    if (!src.startsWith("shc:/")) {
      throw new FHIRException("Unable to process smart health card (didn't start with shc:/)");
    }
    for (int i = 5; i < src.length(); i = i + 2) {
      String s = src.substring(i, i+2);
      byte v = Byte.parseByte(s);
      char c = (char) (45+v);
      b.append(c);
    }
    return b.toString();
  }

  public JWT decodeJWT(String jwt) throws IOException, DataFormatException {
    if (jwt.startsWith("shc:/")) {
      jwt = decodeQRCode(jwt);
    }
    if (jwt.length() > MAX_ALLOWED_SHC_LENGTH) {
      logError(-1, -1, "jwt", IssueType.TOOLONG, "JWT Payload limit length is "+MAX_ALLOWED_SHC_LENGTH+" bytes for a single image - this has "+jwt.length()+" bytes", IssueSeverity.ERROR);
    }

    String[] parts = splitToken(jwt);
    byte[] headerJson;
    byte[] payloadJson;
    try {
      headerJson = Base64.getUrlDecoder().decode(parts[0]);
      payloadJson = Base64.getUrlDecoder().decode(parts[1]);
    } catch (NullPointerException e) {
      throw new FHIRException("The UTF-8 Charset isn't initialized.", e);
    } catch (IllegalArgumentException e){
      throw new FHIRException("The input is not a valid base 64 encoded string.", e);
    }
    JWT res = new JWT();
    res.header = JsonTrackingParser.parseJson(headerJson);
    if ("DEF".equals(JsonUtilities.str(res.header, "zip"))) {
      payloadJson = inflate(payloadJson);
    }
    res.payload = JsonTrackingParser.parse(TextFile.bytesToString(payloadJson), res.map, true);
    return res;
  }
  
  static String[] splitToken(String token) {
    String[] parts = token.split("\\.");
    if (parts.length == 2 && token.endsWith(".")) {
      //Tokens with alg='none' have empty String as Signature.
      parts = new String[]{parts[0], parts[1], ""};
    }
    if (parts.length != 3) {
      throw new FHIRException(String.format("The token was expected to have 3 parts, but got %s.", parts.length));
    }
    return parts;
  }
  
  public static final byte[] inflate(byte[] data) throws IOException, DataFormatException {
    final Inflater inflater = new Inflater(true);
    inflater.setInput(data);

    try (final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length))
    {
        byte[] buffer = new byte[BUFFER_SIZE];
        while (!inflater.finished())
        {
            final int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }

        return outputStream.toByteArray();
    }
  }


}
