package org.hl7.fhir.r4b.utils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.model.Constants;
import org.hl7.fhir.r4b.model.ElementDefinition;
import org.hl7.fhir.r4b.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r4b.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r4b.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType;
import org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r4b.model.UriType;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.npm.PackageHacker;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class XVerExtensionManager {

  public enum XVerExtensionStatus {
    BadVersion, Unknown, Invalid, Valid
  }

  public static final String XVER_EXT_MARKER = "XVER_EXT_MARKER";

  private Map<String, JsonObject> lists = new HashMap<>();
  private IWorkerContext context;

  public XVerExtensionManager(IWorkerContext context) {
    this.context = context;
  }

  public boolean isR5(String url) {
    String v = url.substring(20, 23);
    return "5.0".equals(v);    
  }
  
  public XVerExtensionStatus status(String url) throws FHIRException {
    if (url.length() < 24) {
      return XVerExtensionStatus.Invalid;
    }
    String v = url.substring(20, 23);
    String e = url.substring(54);
    if (!lists.containsKey(v)) {
      if (context.getBinaries().containsKey("xver-paths-"+v+".json")) {
        try {
          lists.put(v, JsonTrackingParser.parseJson(context.getBinaries().get("xver-paths-"+v+".json")));
        } catch (IOException e1) {
          throw new FHIRException(e);
        }
      } else {
        return XVerExtensionStatus.BadVersion;
      }
    }
    JsonObject root = lists.get(v);
    JsonObject path = root.getAsJsonObject(e);
    if (path == null) {
      path = root.getAsJsonObject(e+"[x]");      
    }
    if (path == null) {
      return XVerExtensionStatus.Unknown;
    }
    if (path.has("elements") || path.has("types")) {
      return XVerExtensionStatus.Valid;
    } else {
      return XVerExtensionStatus.Invalid;
    }
  }

  public String getElementId(String url) {
    return url.substring(54);
  }

  public StructureDefinition makeDefinition(String url) {
    String verSource = url.substring(20, 23);
    String verTarget = VersionUtilities.getMajMin(context.getVersion());
    String e = url.substring(54);
    JsonObject root = lists.get(verSource);
    JsonObject path = root.getAsJsonObject(e);
    if (path == null) {
      path = root.getAsJsonObject(e+"[x]");
    }
    
    StructureDefinition sd = new StructureDefinition();
    sd.setUserData(XVER_EXT_MARKER, "true");
    sd.setUserData("path", PackageHacker.fixPackageUrl("https://hl7.org/fhir/versions.html#extensions"));
    sd.setUrl(url);
    sd.setVersion(context.getVersion());
    sd.setFhirVersion(FHIRVersion.fromCode(context.getVersion()));
    sd.setKind(StructureDefinitionKind.COMPLEXTYPE);
    sd.setType("Extension");
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    sd.setName("Extension-"+verSource+"-"+e);
    sd.setTitle("Extension Definition for "+e+" for Version "+verSource);
    sd.setStatus(PublicationStatus.ACTIVE);
    sd.setExperimental(false);
    sd.setDate(new Date());
    sd.setPublisher("FHIR Project");
    sd.setPurpose("Defined so the validator can validate cross version extensions (see http://hl7.org/fhir/versions.html#extensions)");
    sd.setAbstract(false);
    sd.addContext().setType(ExtensionContextType.ELEMENT).setExpression(head(e));
    sd.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Extension");
    if (path.has("types")) {
      sd.getDifferential().addElement().setPath("Extension.extension").setMax("0");
      sd.getDifferential().addElement().setPath("Extension.url").setFixed(new UriType(url));
      ElementDefinition val = sd.getDifferential().addElement().setPath("Extension.value[x]").setMin(1);
      populateTypes(path, val, verSource, verTarget);
    } else if (path.has("elements")) {
      for (JsonElement i : path.getAsJsonArray("elements")) {
        JsonObject elt = root.getAsJsonObject(e+"."+i.getAsString());
        if (elt != null) {
        String s = i.getAsString().replace("[x]", "");
        sd.getDifferential().addElement().setPath("Extension.extension").setSliceName(s);
        sd.getDifferential().addElement().setPath("Extension.extension.extension").setMax("0");
        sd.getDifferential().addElement().setPath("Extension.extension.url").setFixed(new UriType(s));
        ElementDefinition val = sd.getDifferential().addElement().setPath("Extension.extension.value[x]").setMin(1);
        if (!elt.has("types")) {
          throw new FHIRException("Internal error - nested elements not supported yet");
        }
        populateTypes(elt, val, verSource, verTarget);
        }
      }      
      sd.getDifferential().addElement().setPath("Extension.url").setFixed(new UriType(url));
      sd.getDifferential().addElement().setPath("Extension.value[x]").setMax("0");
    } else {
      throw new FHIRException("Internal error - attempt to define extension for "+url+" when it is invalid");
    }
    if (path.has("modifier") && path.get("modifier").getAsBoolean()) {
      ElementDefinition baseDef = new ElementDefinition("Extension");
      sd.getDifferential().getElement().add(0, baseDef);
      baseDef.setIsModifier(true);
    }
    return sd;
  }

  public void populateTypes(JsonObject path, ElementDefinition val, String verSource, String verTarget) {
    for (JsonElement i : path.getAsJsonArray("types")) {
      String s = i.getAsString();
      if (s.contains("(")) {
        String t = s.substring(0, s.indexOf("("));
        TypeRefComponent tr = val.addType().setCode(translateDataType(verTarget, t));
        if (hasTargets(tr.getCode()) ) {
          s = s.substring(t.length()+1);
          for (String p : s.substring(0, s.length()-1).split("\\|")) {
            if ("Any".equals(p)) {
              tr.addTargetProfile("http://hl7.org/fhir/StructureDefinition/Resource");
            } else if (p.contains(",")) {
              for (String pp : p.split("\\,")) {
                tr.addTargetProfile("http://hl7.org/fhir/StructureDefinition/"+pp);                              
              }
            } else  {
              tr.addTargetProfile("http://hl7.org/fhir/StructureDefinition/"+p);              
            }
          }
        }
      } else {
        val.addType().setCode(translateDataType(verTarget, s));
      }
    }
  }

  private boolean hasTargets(String dt) {
    return Utilities.existsInList(dt, "canonical", "Reference", "CodeableReference");
  }

  private String translateDataType(String v, String dt) {
    if (VersionUtilities.versionsCompatible("1.0", v) || VersionUtilities.versionsCompatible("1.4", v)) {
      return translateToR2(dt);
    } else if (VersionUtilities.versionsCompatible("3.0", v)) {
      return translateToR3(dt);
    } else {
      return dt;
    }
  }

  private String translateToR3(String dt) {
    if ("canonical".equals(dt)) {
      return "uri";
    } else if ("url".equals(dt)) {
      return "uri";
    } else {
      return dt;
    }
  }

  private String translateToR2(String dt) {
    if ("canonical".equals(dt)) {
      return "uri";
    } else if ("url".equals(dt)) {
      return "uri";
    } else if ("uuid".equals(dt)) {
      return "id";
    } else {
      return dt;
    }
  }

  private String head(String id) {
    if (id.contains(".")) {
      return id.substring(0, id.lastIndexOf("."));
    } else {
      return id;
    }
  }
  
  public String getVersion(String url) {
    return url.substring(20, 23);
  }

  public boolean matchingUrl(String url) {
    if (url == null || url.length() < 56) {
      return false;
    }
    String pfx = url.substring(0, 20);
    String v = url.substring(20, 23);
    String sfx = url.substring(23, 54);
    return pfx.equals("http://hl7.org/fhir/") &&
       isVersionPattern(v) && sfx.equals("/StructureDefinition/extension-");
  }

  private boolean isVersionPattern(String v) {
    return v.length() == 3 && Character.isDigit(v.charAt(0)) && v.charAt(1) == '.' && Character.isDigit(v.charAt(2));
  }

}