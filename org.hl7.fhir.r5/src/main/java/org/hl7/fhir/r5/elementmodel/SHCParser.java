package org.hl7.fhir.r5.elementmodel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.SHCParser.SHCSignedJWT;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonElementType;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonPrimitive;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.*;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.DefaultJOSEObjectTypeVerifier;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jwt.*;
import com.nimbusds.jwt.proc.*;
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
  private List<String> types = new ArrayList<>();

  public SHCParser(IWorkerContext context) {
    super(context);
    jsonParser = new JsonParser(context);
  }

  public List<ValidatedFragment> parse(InputStream inStream) throws IOException, FHIRFormatError, DefinitionException, FHIRException {
    byte[] content = TextFile.streamToBytes(inStream);
    ByteArrayInputStream stream = new ByteArrayInputStream(content);
    List<ValidatedFragment> res = new ArrayList<>();
    ValidatedFragment shc = new ValidatedFragment("shc", "json", content);
    res.add(shc);

    String src = TextFile.streamToString(stream).trim();
    List<String> list = new ArrayList<>();
    String pfx = null;
    if (src.startsWith("{")) {
      JsonObject json = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(src);
      if (checkProperty(shc.getErrors(), json, "$", "verifiableCredential", true, "Array")) {
        pfx = "verifiableCredential";
        JsonArray arr = json.getJsonArray("verifiableCredential");
        int i = 0;
        for (JsonElement e : arr) {
          if (!(e instanceof JsonPrimitive)) {
            logError(shc.getErrors(), ValidationMessage.NO_RULE_DATE, line(e), col(e), "$.verifiableCredential["+i+"]", IssueType.STRUCTURE, "Wrong Property verifiableCredential in JSON Payload. Expected : String but found "+e.type().toName(), IssueSeverity.ERROR);                
          } else {
            list.add(e.asString());
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
        jwt = decodeJWT(shc.getErrors(), ssrc);
      } catch (Exception e) {
        logError(shc.getErrors(), ValidationMessage.NO_RULE_DATE, 1, 1, prefix+"JWT", IssueType.INVALID, "Unable to decode JWT token", IssueSeverity.ERROR);
        return res;      
      }

      checkNamedProperties(shc.getErrors(), jwt.getPayload(), prefix+"payload", "iss", "nbf", "vc");
      checkProperty(shc.getErrors(), jwt.getPayload(), prefix+"payload", "iss", true, "String");
      checkProperty(shc.getErrors(), jwt.getPayload(), prefix+"payload", "nbf", true, "Number");
      JsonObject vc = jwt.getPayload().getJsonObject("vc");
      if (vc == null) {
        logError(shc.getErrors(), ValidationMessage.NO_RULE_DATE, 1, 1, "JWT", IssueType.STRUCTURE, "Unable to find property 'vc' in the payload", IssueSeverity.ERROR);
        return res;
      }
      String path = prefix+"payload.vc";
      checkNamedProperties(shc.getErrors(), vc, path, "type", "credentialSubject");
      if (!checkProperty(shc.getErrors(), vc, path, "type", true, "Array")) {
        return res;
      }
      JsonArray type = vc.getJsonArray("type");
      int i = 0;
      for (JsonElement e : type) {
        if (e.type() != JsonElementType.STRING) {
          logError(shc.getErrors(), ValidationMessage.NO_RULE_DATE, line(e), col(e), path+".type["+i+"]", IssueType.STRUCTURE, "Wrong Property Type in JSON Payload. Expected : String but found "+e.type().toName(), IssueSeverity.ERROR);
        } else {
          types.add(e.asString());
        }
        i++;
      }
      if (!types.contains("https://smarthealth.cards#health-card")) {
        logError(shc.getErrors(), ValidationMessage.NO_RULE_DATE, line(vc), col(vc), path, IssueType.STRUCTURE, "Card does not claim to be of type https://smarthealth.cards#health-card, cannot validate", IssueSeverity.ERROR);
        return res;
      }
      if (!checkProperty(shc.getErrors(), vc, path, "credentialSubject", true, "Object")) {
        return res;
      }
      JsonObject cs = vc.getJsonObject("credentialSubject");
      path = path+".credentialSubject";
      if (!checkProperty(shc.getErrors(), cs, path, "fhirVersion", true, "String")) {
        return res;
      }
      JsonElement fv = cs.get("fhirVersion");
      if (!VersionUtilities.versionsCompatible(context.getVersion(), fv.asString())) {
        logError(shc.getErrors(), ValidationMessage.NO_RULE_DATE, line(fv), col(fv), path+".fhirVersion", IssueType.STRUCTURE, "Card claims to be of version "+fv.asString()+", cannot be validated against version "+context.getVersion(), IssueSeverity.ERROR);
        return res;
      }
      if (!checkProperty(shc.getErrors(), cs, path, "fhirBundle", true, "Object")) {
        return res;
      }
      // ok. all checks passed, we can now validate the bundle
      ValidatedFragment bnd = new ValidatedFragment(path, "json", org.hl7.fhir.utilities.json.parser.JsonParser.composeBytes(cs.getJsonObject("fhirBundle")));
      res.add(bnd);
      bnd.setElement(jsonParser.parse(bnd.getErrors(), cs.getJsonObject("fhirBundle")));
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


  private boolean checkProperty(List<ValidationMessage> errors, JsonObject obj, String path, String name, boolean required, String type) {
    JsonElement e = obj.get(name);
    if (e != null) {
      String t = e.type().toName();
      if (!type.equals(t)) {
        logError(errors, ValidationMessage.NO_RULE_DATE, line(e), col(e), path+"."+name, IssueType.STRUCTURE, "Wrong Property Type in JSON Payload. Expected : "+type+" but found "+t, IssueSeverity.ERROR);                
      } else {
        return true;
      }
    } else if (required) {
      logError(errors, ValidationMessage.NO_RULE_DATE, line(obj), col(obj), path, IssueType.STRUCTURE, "Missing Property in JSON Payload: "+name, IssueSeverity.ERROR);                
    } else {
      return true;
    }
    return false;
  }

  private void checkNamedProperties(List<ValidationMessage> errors, JsonObject obj, String path, String... names) {
    for (JsonProperty e : obj.getProperties()) {
      if (!Utilities.existsInList(e.getName(), names)) {
        logError(errors, ValidationMessage.NO_RULE_DATE, line(e.getValue()), col(e.getValue()), path+"."+e.getName(), IssueType.STRUCTURE, "Unknown Property in JSON Payload", IssueSeverity.WARNING);                
      }
    }
  }

  private int line(JsonElement e) {
    return e.getStart().getLine();
  }

  private int col(JsonElement e) {
    return e.getStart().getCol();
  }



  public void compose(Element e, OutputStream destination, OutputStyle style, String base)  throws FHIRException, IOException {
    throw new FHIRFormatError("Writing resources is not supported for the SHC format");
    // because then we'd have to try to sign, and we're just not going to be doing that from the element model
  }


  public static class JWT {

    private JsonObject header;
    private JsonObject payload;

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

  public JWT decodeJWT(List<ValidationMessage> errors, String jwt) throws IOException, DataFormatException {
    if (jwt.startsWith("shc:/")) {
      jwt = decodeQRCode(jwt);
    }
    if (jwt.length() > MAX_ALLOWED_SHC_LENGTH) {
      logError(errors, ValidationMessage.NO_RULE_DATE, -1, -1, "jwt", IssueType.TOOLONG, "JWT Payload limit length is "+MAX_ALLOWED_SHC_LENGTH+" bytes for a single image - this has "+jwt.length()+" bytes", IssueSeverity.ERROR);
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
    res.header = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(headerJson);
    if ("DEF".equals(res.header.asString("zip"))) {
      payloadJson = inflate(payloadJson);
    }
    res.payload = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(TextFile.bytesToString(payloadJson), true);

    checkSignature(jwt, res, errors, "jwt", org.hl7.fhir.utilities.json.parser.JsonParser.compose(res.payload));
    return res;
  }

  private void checkSignature(String jwt, JWT res, List<ValidationMessage> errors, String name, String jsonPayload) {
    String iss = res.payload.asString("iss");
    if (iss != null) { // reported elsewhere
      if (!iss.startsWith("https://")) {
        logError(errors, "2023-09-08", 1, 1, name, IssueType.NOTFOUND, "JWT iss '"+iss+"' must start with https://", IssueSeverity.ERROR);
      }
      if (iss.endsWith("/")) {
        logError(errors, "2023-09-08", 1, 1, name, IssueType.NOTFOUND, "JWT iss '"+iss+"' must not have trailing /", IssueSeverity.ERROR);
        iss = iss.substring(0, iss.length()-1);
      }
      String url = Utilities.pathURL(iss, "/.well-known/jwks.json");
      JsonObject jwks = null;
      try {
        jwks = org.hl7.fhir.utilities.json.parser.JsonParser.parseObjectFromUrl(url);
      } catch (Exception e) {
        logError(errors, "2023-09-08", 1, 1, name, IssueType.NOTFOUND, "Unable to verify the signature, because unable to retrieve JWKS from "+url+": "+
           e.getMessage().replace("Connection refused (Connection refused)", "Connection refused"), IssueSeverity.ERROR);    
      }
      if (jwks != null) {
        verifySignature(jwt, errors, name, iss, url, org.hl7.fhir.utilities.json.parser.JsonParser.compose(jwks));
      }

      // TODO Auto-generated method stub

      //
      //    logError(shc.getErrors(), ValidationMessage.NO_RULE_DATE, 1, 1, prefix+"JWT", IssueType.INFORMATIONAL, "The FHIR Validator does not check the JWT signature "+
      //        "(see https://demo-portals.smarthealth.cards/VerifierPortal.html or https://github.com/smart-on-fhir/health-cards-dev-tools) (Issuer = '"+jwt.getPayload().asString("iss")+"')", IssueSeverity.INFORMATION);
    }

  }

  public class SHCSignedJWT extends com.nimbusds.jwt.SignedJWT {
    private static final long serialVersionUID = 1L;
    private JWTClaimsSet claimsSet;

    public SHCSignedJWT(SignedJWT jwtO, String jsonPayload) throws ParseException {
      super(jwtO.getParsedParts()[0], jwtO.getParsedParts()[1], jwtO.getParsedParts()[2]);
      Map<String, Object> json = JSONObjectUtils.parse(jsonPayload);
      claimsSet = JWTClaimsSet.parse(json);
    }

    public JWTClaimsSet getJWTClaimsSet() {
      return claimsSet;
    }
  }

  private void verifySignature(String jwt, List<ValidationMessage> errors, String name, String iss, String url, String jwks) {
    try {
      // Parse the JWS token
      JWSObject jwsObject = JWSObject.parse(jwt);

      // Extract header details
      JWSHeader header = jwsObject.getHeader();
      validateHeader(header);

      // Decompress the payload
      byte[] decodedPayload = jwsObject.getPayload().toBytes();
      String decompressedPayload = decompress(decodedPayload);

      // Extract issuer from the payload
      JsonObject rootNode = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(decompressedPayload);
      String issuer = rootNode.asString("iss");

      // Fetch the public key
      JWKSet jwkSet = JWKSet.parse(jwks);
      JWK publicKey = jwkSet.getKeyByKeyId(header.getKeyID());

      // Verify the JWS token
      JWSVerifier verifier = new ECDSAVerifier((ECKey) publicKey);
      if (jwsObject.verify(verifier)) {
        String vciName = getVCIIssuer(errors, issuer);
        if (vciName == null) {
          logError(errors, "2023-09-08", 1, 1, name, IssueType.BUSINESSRULE, "The signature is valid, but the issuer "+issuer+" is not a trusted issuer", IssueSeverity.WARNING);
        } else {
          logError(errors, "2023-09-08", 1, 1, name, IssueType.INFORMATIONAL, "The signature is valid, signed by the trusted issuer '"+vciName+"' ("+issuer+")", IssueSeverity.INFORMATION);
        } 
      } else {
        logError(errors, "2023-09-08", 1, 1, name, IssueType.BUSINESSRULE, "The signature is not valid", IssueSeverity.ERROR);
      }
    } catch (Exception e) {
      logError(errors, "2023-09-08", 1, 1, name, IssueType.NOTFOUND, "Error validating signature: "+e.getMessage(), IssueSeverity.ERROR);
    }
  }

  private static void validateHeader(JWSHeader header) {
    if (!"ES256".equals(header.getAlgorithm().getName())) {
      throw new IllegalArgumentException("Invalid alg in JWS header. Expected ES256.");
    }
    if (!header.getCustomParam("zip").equals("DEF")) {
      throw new IllegalArgumentException("Invalid zip in JWS header. Expected DEF.");
    }
  }

  private static String decompress(byte[] compressed) throws Exception {
    Inflater inflater = new Inflater(true);
    inflater.setInput(compressed);

    byte[] buffer = new byte[1024];
    int length;
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressed.length)) {
      while (!inflater.finished()) {
        length = inflater.inflate(buffer);
        outputStream.write(buffer, 0, length);
      }
      return outputStream.toString(StandardCharsets.UTF_8.name());
    }
  }


  private String getVCIIssuer(List<ValidationMessage> errors, String issuer) {
    try {
      JsonObject vci = org.hl7.fhir.utilities.json.parser.JsonParser.parseObjectFromUrl("https://raw.githubusercontent.com/the-commons-project/vci-directory/main/vci-issuers.json");
      for (JsonObject j : vci.getJsonObjects("participating_issuers")) {
        if (issuer.equals(j.asString("iss"))) {
          return j.asString("name");
        }
      }
    } catch (Exception e) {
      logError(errors, "2023-09-08", 1, 1, "vci", IssueType.NOTFOUND, "Unable to retrieve/read VCI Trusted Issuer list: "+e.getMessage(), IssueSeverity.WARNING);
    }
    return null;
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
