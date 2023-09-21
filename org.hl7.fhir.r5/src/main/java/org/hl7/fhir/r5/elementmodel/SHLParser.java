package org.hl7.fhir.r5.elementmodel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.DataFormatException;
import java.util.Date;
import java.util.zip.Inflater;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonElementType;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonPrimitive;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;

import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.DirectDecrypter;

/**
 * this class is actually a smart health link retreiver. 
 * It's going to parse the link, check it, and then return
 * 2 items, the link with validation information in an Element, and the 
 * parsed whatever that the link pointed to
 * 
 * Error locations in the first item are in the decoded JSON file the URL contains, or 0,0 if not in the json file
 * Error locations in the second item are in the decoded payload
 * 
 * @author grahame
 *
 */
public class SHLParser extends ParserBase {
  private static boolean testMode;
  
  private boolean post = true;
  private String url = null;
  private byte[] key = null;
  private String ct;

  public SHLParser(IWorkerContext context) {
    super(context);
  }

  public List<ValidatedFragment> parse(InputStream inStream) throws IOException, FHIRFormatError, DefinitionException, FHIRException {
    byte[] content = TextFile.streamToBytes(inStream);
    
    List<ValidatedFragment> res = new ArrayList<>();
    ValidatedFragment shl = addNamedElement(res, "shl", "txt", content);
    String src = TextFile.bytesToString(content);
    
    if (src.startsWith("shlink:/")) {
      src = src.substring(8);
    } else if (src.contains("#shlink:/")) {
      String pfx = src.substring(0, src.indexOf("#shlink:/"));
      src = src.substring(src.indexOf("#shlink:/")+9);
      if (!Utilities.isAbsoluteUrlLinkable(pfx)) {        
        logError(shl.getErrors(), "202-08-31", 1, 1, "shl", IssueType.STRUCTURE, "if a prefix is present, it must be a URL, not "+pfx, IssueSeverity.ERROR);                
      }
    } else {
      logError(shl.getErrors(), "202-08-31", 1, 1, "shl", IssueType.STRUCTURE, "This content does not appear to be an Smart Health Link", IssueSeverity.ERROR);
      src = null;
    }
    if (src != null) {
      byte[] cntin = Base64.getUrlDecoder().decode(src);
      ValidatedFragment json = addNamedElement(res, "json", "json", cntin);
      JsonObject j = null;
      try {
        j = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(cntin);
      } catch (Exception e) {
        logError(json.getErrors(), "202-08-31", 1, 1, "shl.json", IssueType.STRUCTURE, "The JSON is not valid: "+e.getMessage(), IssueSeverity.ERROR);        
      }
      if (j != null) {
        byte[] cntout = org.hl7.fhir.utilities.json.parser.JsonParser.composeBytes(j, false);
        if (!Arrays.equals(cntin, cntout)) {
          logError(shl.getErrors(), "202-08-31", 1, 1, "shl", IssueType.STRUCTURE, "The JSON does not seem to be minified properly", IssueSeverity.ERROR);        
        }
        if (checkJson(json.getErrors(), j)) {
          HTTPResult cnt = null;
          if (post) {
            try {
              cnt = fetchManifest();
            } catch (UnknownHostException e) {
              logError(json.getErrors(), "202-08-31", 1, 1, "shl.json", IssueType.STRUCTURE, "The manifest could not be fetched because the host "+e.getMessage()+" is unknown", IssueSeverity.ERROR);
            } catch (Exception e) {
              logError(json.getErrors(), "202-08-31", 1, 1, "shl.json", IssueType.STRUCTURE, "The manifest could not be fetched: "+e.getMessage(), IssueSeverity.ERROR);
            }
            if (cnt != null) {
              if (cnt.getContentType() == null) {
                logError(json.getErrors(), "202-08-31", 1, 1, "shl.json.url.fetch()", IssueType.NOTFOUND, "The server did not return a Content-Type header - should be 'application/json'", IssueSeverity.WARNING);
              } else if (!"application/json".equals(cnt.getContentType())) {
                logError(json.getErrors(), "202-08-31", 1, 1, "shl.json.url.fetch()", IssueType.STRUCTURE, "The server returned the wrong Content-Type header '"+cnt.getContentType()+"' - must be 'application/json'", IssueSeverity.ERROR);
              }
              checkManifest(res, cnt);
            } 
          } else {
            try {
              cnt = fetchFile(url+"?recipient=FHIR%20Validator", "application/jose"); 
            } catch (Exception e) {
              logError(json.getErrors(), "202-08-31", 1, 1, "shl,json.url", IssueType.STRUCTURE, "The document could not be fetched: "+e.getMessage(), IssueSeverity.ERROR);
            }
            if (cnt != null) {
              if (cnt.getContentType() == null) {
                logError(json.getErrors(), "202-08-31", 1, 1, "shl.json.url.fetch()", IssueType.NOTFOUND, "The server did not return a Content-Type header - should be 'application/jose'", IssueSeverity.WARNING);
              } else if (!"application/json".equals(cnt.getContentType())) {
                logError(json.getErrors(), "202-08-31", 1, 1, "shl.json.url.fetch()", IssueType.STRUCTURE, "The server returned the wrong Content-Type header '"+cnt.getContentType()+"' - must be 'application/jose'", IssueSeverity.ERROR);
              }
              processContent(res, json.getErrors(), "shl.url.fetched()", "document", cnt.getContentAsString(), ct);
            } 
          }
        }
      }
    }
    return res;
  }
  

  private void checkManifest(List<ValidatedFragment> res, HTTPResult cnt) throws IOException {
    ValidatedFragment manifest = addNamedElement(res, "manifest", "json", cnt.getContent());
    
    if (!cnt.getContentType().equals("application/json")) {
      logError(manifest.getErrors(), "202-08-31", 1, 1, "manifest", IssueType.STRUCTURE, "The mime type should be application/json not "+cnt.getContentType(), IssueSeverity.ERROR);
    } else {
      JsonObject j = null;
      try {
        j = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(cnt.getContent());
      } catch (Exception e) {
        logError(manifest.getErrors(), "202-08-31", 1, 1, "manifest", IssueType.STRUCTURE, "The JSON is not valid: "+e.getMessage(), IssueSeverity.ERROR);        
      }
      if (j != null) {
        for (JsonProperty p : j.getProperties()) {
         if (!p.getName().equals("files")) {
            logError(manifest.getErrors(), "202-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "manifest."+p.getName(), 
                IssueType.STRUCTURE, "Unexpected property name "+p.getName(), IssueSeverity.WARNING);  
          }
        }
      }
      if (j.has("files")) {
        JsonElement f = j.get("files");
        if (f.isJsonArray()) {
          int i = 0;
          for (JsonElement e : f.asJsonArray()) {
            if (e.isJsonObject()) {
              processManifestEntry(res, manifest.getErrors(), e.asJsonObject(), "manifest.files["+i+"]", "files["+i+"]");
            } else {
              logError(manifest.getErrors(), "202-08-31", e.getStart().getLine(), e.getStart().getCol(), "manifest.files["+i+"]", 
                  IssueType.STRUCTURE, "files must be an object, not a "+f.type().name(), IssueSeverity.ERROR);  
            }
          }
        } else {
          logError(manifest.getErrors(), "202-08-31", f.getStart().getLine(), f.getStart().getCol(), "manifest.files", 
              IssueType.STRUCTURE, "files must be an array, not a "+f.type().name(), IssueSeverity.ERROR);  
        }
      } else {
        logError(manifest.getErrors(), "202-08-31", j.getStart().getLine(), j.getStart().getCol(), "manifest", 
            IssueType.STRUCTURE, "files not found", IssueSeverity.WARNING);  
      }
    }
  }

  private void processManifestEntry(List<ValidatedFragment> res, List<ValidationMessage> errors, JsonObject j, String path, String name) throws FHIRFormatError, DefinitionException, FHIRException, IOException {
    for (JsonProperty p : j.getProperties()) {
      if (!Utilities.existsInList(p.getName(), "contentType", "location", "embedded")) {
        logError(errors, "202-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "manifest."+p.getName(), 
            IssueType.STRUCTURE, "Unexpected property "+p.getName(), IssueSeverity.WARNING);  
      }
    }
    JsonElement cte = j.get("contentType");
    JsonElement loce = j.get("location");
    JsonElement embe = j.get("embedded");
    String ct = null;
    if (cte == null) {
      logError(errors, "202-08-31", j.getStart().getLine(), j.getStart().getCol(), path, IssueType.STRUCTURE, "contentType not found", IssueSeverity.ERROR);  
    } else if (!cte.isJsonString()) {
      logError(errors, "202-08-31", j.getStart().getLine(), j.getStart().getCol(), path+".contentType", IssueType.STRUCTURE, "contentType must be a string not a "+cte.type().name(), IssueSeverity.ERROR);       
    } else { 
      ct = cte.asString();
      if (!Utilities.existsInList(ct, "application/smart-health-card", "application/smart-api-access", "application/fhir+json")) {
        logError(errors, "202-08-31", j.getStart().getLine(), j.getStart().getCol(), path+".contentType", IssueType.STRUCTURE, "contentType must be one of application/smart-health-card, application/smart-api-access or application/fhir+json", IssueSeverity.ERROR);       
        ct = null;
      }
    }
    if (loce != null && !loce.isJsonString()) {
      logError(errors, "202-08-31", j.getStart().getLine(), j.getStart().getCol(), path+".location", IssueType.STRUCTURE, "location must be a string not a "+loce.type().name(), IssueSeverity.ERROR);       
    } 
    if (embe != null && !embe.isJsonString()) {
      logError(errors, "202-08-31", j.getStart().getLine(), j.getStart().getCol(), path+".embedded", IssueType.STRUCTURE, "embedded must be a string not a "+embe.type().name(), IssueSeverity.ERROR);       
    }
    if (loce == null && embe == null) {
      logError(errors, "202-08-31", j.getStart().getLine(), j.getStart().getCol(), path, IssueType.STRUCTURE, "Found neither a location nor an embedded property", IssueSeverity.ERROR);  
    } else if (loce != null && embe != null) {
      logError(errors, "202-08-31", j.getStart().getLine(), j.getStart().getCol(), path, IssueType.STRUCTURE, "Found both a location nor an embedded property - only one can be present", IssueSeverity.ERROR);  
    } else if (ct != null) {
      if (embe != null) {
        processContent(res, errors, path+".embedded", name, embe.asString(), ct);
      } else if (loce != null) { // it will be, just removes a warning
        HTTPResult cnt = null;
        try {
          cnt = fetchFile(loce.asString(), "application/jose"); 
        } catch (Exception e) {
          logError(errors, "202-08-31", 1, 1, "shl", IssueType.STRUCTURE, "The document could not be fetched: "+e.getMessage(), IssueSeverity.ERROR);
        }
        if (cnt != null) {
          if (cnt.getContentType() == null) {
            logError(errors, "202-08-31", 1, 1, "shl.json.url.fetch()", IssueType.NOTFOUND, "The server did not return a Content-Type header - should be 'application/jose'", IssueSeverity.WARNING);
          } else if (!"application/json".equals(cnt.getContentType())) {
            logError(errors, "202-08-31", 1, 1, "shl.json.url.fetch()", IssueType.STRUCTURE, "The server returned the wrong Content-Type header '"+cnt.getContentType()+"' - must be 'application/jose'", IssueSeverity.ERROR);
          }
          processContent(res, errors, path+".url.fetch()", name, cnt.getContentAsString(), ct);            
        } 
      } 
    }
  }

  private void processContent(List<ValidatedFragment> res, List<ValidationMessage> errors, String path, String name, String jose, String ct) throws FHIRFormatError, DefinitionException, FHIRException, IOException {
    ValidatedFragment bin = addNamedElement(res, "encrypted", "jose", TextFile.stringToBytes(jose, false));
    byte[] cnt = null;
    JWEObject jwe;
    try {
      jwe = JWEObject.parse(jose);
      jwe.decrypt(new DirectDecrypter(key));
      cnt = jwe.getPayload().toBytes();
    } catch (Exception e) {
      logError(bin.getErrors(), "202-08-31", 1, 1, path, IssueType.STRUCTURE, "Decruption failed: "+e.getMessage(), IssueSeverity.ERROR);    
    }
    if (cnt != null) {
      switch (ct) {
      case "application/smart-health-card":
        //a JSON file with a .verifiableCredential array containing SMART Health Card JWS strings, as specified by https://spec.smarthealth.cards#via-file-download.
        SHCParser shc = new SHCParser(context);
        res.addAll(shc.parse(new ByteArrayInputStream(cnt)));
        break;
      case "application/fhir+json": 
        ValidatedFragment doc = addNamedElement(res, name, "json", cnt);
        // a JSON file containing any FHIR resource (e.g., an individual resource or a Bundle of resources). Generally this format may not be tamper-proof.
        logError(doc.getErrors(), "202-08-31", 1, 1, name, IssueType.STRUCTURE, "Processing content of type 'application/smart-api-access' is not done yet", IssueSeverity.INFORMATION);
        break;
      case "application/smart-api-access":
        doc = addNamedElement(res, name, "api.json", cnt);
        // a JSON file with a SMART Access Token Response (see SMART App Launch). Two additional properties are defined:
        // aud Required string indicating the FHIR Server Base URL where this token can be used (e.g., "https://server.example.org/fhir")
        // query: Optional array of strings acting as hints to the client, indicating queries it might want to make (e.g., ["Coverage?patient=123&_tag=family-insurance"])
        logError(doc.getErrors(), "202-08-31", 1, 1, name, IssueType.STRUCTURE, "Processing content of type 'application/smart-api-access' is not done yet", IssueSeverity.INFORMATION);
        break;
      default: 
        doc = addNamedElement(res, name, "bin", cnt);
        logError(doc.getErrors(), "202-08-31", 1, 1, name, IssueType.STRUCTURE, "The Content-Type '"+ct+"' is not known", IssueSeverity.INFORMATION);
      }
    }
  }

  private ValidatedFragment addNamedElement(List<ValidatedFragment> res, String name, String type, byte[] content) {
    ValidatedFragment result = new ValidatedFragment(name, type, content);
    res.add(result);
    return result;
  }


  private HTTPResult fetchFile(String url, String ct) throws IOException {
    SimpleHTTPClient fetcher = new SimpleHTTPClient();
    fetcher.addHeader("Accept", ct);
    HTTPResult res = fetcher.get(url);
    res.checkThrowException();
    return res;
  }
  
  private HTTPResult fetchManifest() throws IOException {
    if (testMode) {
      return new HTTPResult(url, 200, "OK", "application/json", TextFile.streamToBytes(TestingUtilities.loadTestResourceStream("validator", "shlink.manifest.json")));
    }
    SimpleHTTPClient fetcher = new SimpleHTTPClient();
    JsonObject j = new JsonObject();
    j.add("recipient", "FHIR Validator");
    HTTPResult res = fetcher.post(url, "application/json", org.hl7.fhir.utilities.json.parser.JsonParser.composeBytes(j), "application/json");        
    res.checkThrowException();
    return res;
  }

  private boolean checkJson(List<ValidationMessage> errors, JsonObject j) {
    boolean ok = true;
    boolean fUrl = false;
    boolean fKey = false;
    boolean fCty = false;
    boolean hp = false;
    boolean hu = false;
    for (JsonProperty p : j.getProperties()) {
      switch (p.getName()) {
      case "url":
        fUrl = true;
        if (!p.getValue().isJsonString()) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "url must be a string", IssueSeverity.ERROR);   
          ok = false;
        } else if (!Utilities.isAbsoluteUrlLinkable(p.getValue().asString())) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "url is not valid: "+p.getValue().asString(), IssueSeverity.ERROR);  
          ok = false;
        } else {
          url = p.getValue().asString();
        }
        break;
      case "key":
        fKey = true;
        if (!p.getValue().isJsonString()) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "key must be a string", IssueSeverity.ERROR);   
          ok = false;
        } else if (p.getValue().asString().length() != 43) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "key must contain 43 chars", IssueSeverity.ERROR);  
          ok = false;
        } else {
          key = Base64.getUrlDecoder().decode(p.getValue().asString());
        }
        break;
      case "exp":
        if (!p.getValue().isJsonNumber()) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "exp must be a number", IssueSeverity.ERROR);   
        } else if (!Utilities.isDecimal(p.getValue().asJsonNumber().getValue(), false)) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "exp must be a valid number", IssueSeverity.ERROR);   
        } else {
          String v = p.getValue().asJsonNumber().getValue();
          if (v.contains(".")) {
            v = v.substring(0, v.indexOf("."));
          }

          long epochSecs = Long.valueOf(v);
          LocalDateTime date = LocalDateTime.ofEpochSecond(epochSecs, 0, ZoneOffset.UTC);
          LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
          Duration duration = Duration.between(date, now);
        
          if (date.isBefore(now)) {          
            logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "The content has expired (by "+Utilities.describeDuration(duration)+")", IssueSeverity.WARNING);  
          }
        }
        break;
      case "flag":
        if (!p.getValue().isJsonString()) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "flag must be a string", IssueSeverity.ERROR);   
        } else {
          String flag = p.getValue().asString();
          for (char c : flag.toCharArray()) {
            switch (c) {
            case 'L': // ok
              break;
            case 'P':
              hp = true;
              break;
            case 'U':
              hu = true;
              break;
            default:
              logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
                  IssueType.STRUCTURE, "Illegal Character "+c+" in flag", IssueSeverity.ERROR);   
            }
          }
          if (hu && hp) {
            logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
                IssueType.STRUCTURE, "Illegal combination in flag: both P and U are present", IssueSeverity.ERROR);               
          }
          if (hp) {
            logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
                IssueType.BUSINESSRULE, "The validator is unable to retrieve the content referred to by the URL because a password is required", IssueSeverity.INFORMATION);  
            ok = false;
          }
          if (hu) {
            post = false;
          }
        }
        break;
      case "label":
        if (!p.getValue().isJsonString()) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "label must be a string", IssueSeverity.ERROR);   
        } else if (p.getValue().asString().length() > 80) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "label must be no longer than 80 chars", IssueSeverity.ERROR);   
        }
        break;
      case "cty" :
        if (!p.getValue().isJsonString()) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "cty must be a string", IssueSeverity.ERROR);   
        } else if (!Utilities.existsInList(p.getValue().asString(), "application/smart-health-card", "application/smart-api-access", "application/fhir+json")) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "cty must be one of 'application/smart-health-card/, 'application/smart-api-access', 'application/fhir+json'", IssueSeverity.ERROR);   
        } else {
          ct = p.getValue().asString();
        }
        break;
      case "v":
        if (!p.getValue().isJsonString()) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "v must be a string", IssueSeverity.ERROR);   
        } else if (p.getValue().asString().length() <= 80) {
          logError(errors, "2023-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
              IssueType.STRUCTURE, "if present, v must be '1'", IssueSeverity.ERROR);   
        }
        break;
      default:
        logError(errors, "202-08-31", p.getValue().getStart().getLine(), p.getValue().getStart().getCol(), "shl."+p.getName(), 
            IssueType.STRUCTURE, "Illegal property name "+p.getName(), IssueSeverity.ERROR);  
      }
    }
    if (hu && !fCty) {
      logError(errors, "202-08-31", 1, 1, "shl", IssueType.STRUCTURE, "Flag 'U' found, but no 'cty' header which is required for the U flag", IssueSeverity.ERROR);  
      ok = false;
    }
    if (!fUrl) {
      logError(errors, "202-08-31", 1, 1, "shl", IssueType.STRUCTURE, "No url found", IssueSeverity.ERROR);  
      ok = false;
    }
    if (!fKey) {
      logError(errors, "202-08-31", 1, 1, "shl", IssueType.STRUCTURE, "No key found", IssueSeverity.ERROR);  
      ok = false;
    }
    return ok;
  }

  public void compose(Element e, OutputStream destination, OutputStyle style, String base)  throws FHIRException, IOException {
    throw new FHIRFormatError("Writing resources is not supported for the SHL format");
    // because then we'd have to try to sign, and we're just not going to be doing that from the element model
  }

  public static boolean isTestMode() {
    return testMode;
  }

  public static void setTestMode(boolean testMode) {
    SHLParser.testMode = testMode;
  }


}
