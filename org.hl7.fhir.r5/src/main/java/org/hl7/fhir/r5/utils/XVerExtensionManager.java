package org.hl7.fhir.r5.utils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.PackageHacker;

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
      if (context.hasBinaryKey("xver-paths-"+v+".json")) {
        try {
          lists.put(v, JsonParser.parseObject(context.getBinaryForKey("xver-paths-"+v+".json")));
        } catch (IOException e1) {
          throw new FHIRException(e);
        }
      } else {
        return XVerExtensionStatus.BadVersion;
      }
    }
    JsonObject root = lists.get(v);
    JsonObject path = root.getJsonObject(e);
    if (path == null) {
      path = root.getJsonObject(e+"[x]");      
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
    JsonObject path = root.getJsonObject(e);
    if (path == null) {
      path = root.getJsonObject(e+"[x]");
    }
    
    StructureDefinition sd = new StructureDefinition();
    sd.setUserData(XVER_EXT_MARKER, "true");
    sd.setWebPath(PackageHacker.fixPackageUrl("https://hl7.org/fhir/versions.html#extensions"));
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
      for (JsonElement i : path.forceArray("elements").getItems()) {
        String apath = e+"."+i.asString();
        JsonObject elt = root.getJsonObject(apath);
        if (elt != null) {
          genExtensionContents(root, apath, verSource, verTarget, sd, i, elt, "Extension.extension");
        }
      }      
      sd.getDifferential().addElement().setPath("Extension.url").setFixed(new UriType(url));
      sd.getDifferential().addElement().setPath("Extension.value[x]").setMax("0");
    } else {
      throw new FHIRException("Internal error - attempt to define extension for "+url+" when it is invalid");
    }
    if (path.has("modifier") && path.asBoolean("modifier")) {
      ElementDefinition baseDef = new ElementDefinition("Extension");
      sd.getDifferential().getElement().add(0, baseDef);
      baseDef.setIsModifier(true);
    }
    return sd;
  }

  private void genExtensionContents(JsonObject root, String apath, String verSource, String verTarget, StructureDefinition sd, JsonElement i, JsonObject elt, String epath) {
    String s = i.asString().replace("[x]", "");
    sd.getDifferential().addElement().setPath(epath).setSliceName(s);
    if (elt.has("types")) {            
      sd.getDifferential().addElement().setPath(epath+".extension").setMax("0");
      sd.getDifferential().addElement().setPath(epath+".url").setFixed(new UriType(s));
      ElementDefinition val = sd.getDifferential().addElement().setPath(epath+".value[x]").setMin(1);
      populateTypes(elt, val, verSource, verTarget);
    } else if (elt.has("elements")) {
      for (JsonElement ic : elt.forceArray("elements").getItems()) { 
        String apathC = apath+"."+ic.asString();
        JsonObject eltC = root.getJsonObject(apathC);
        if (eltC != null) {
          genExtensionContents(root, apathC, verSource, verTarget, sd, ic, eltC, epath+".extension");
        }
      }
      sd.getDifferential().addElement().setPath(epath+".url").setFixed(new UriType(s));
      sd.getDifferential().addElement().setPath(epath+".value[x]").setMax("0");
    } else {
      throw new FHIRException("Internal error - unknown element "+apath);
    }
  }

  public void populateTypes(JsonObject path, ElementDefinition val, String verSource, String verTarget) {
    for (JsonElement i : path.forceArray("types").getItems()) {
      String s = i.asString();
      if (!s.startsWith("!")) {
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
                  if (isResource(pp)) {
                    tr.addTargetProfile("http://hl7.org/fhir/StructureDefinition/"+pp);
                  }
                }
              } else if (isResource(p)) {
                tr.addTargetProfile("http://hl7.org/fhir/StructureDefinition/"+p);              
              }
            }
          }
        } else {
          val.addType().setCode(translateDataType(verTarget, s));
        }
      }
    }
  }

  // todo: translate names 
  
  private boolean isResource(String p) {
    return context.getResourceNames().contains(p);
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

  public String getReference(String url) {
    String version = getVersion(url);
    String base = VersionUtilities.getSpecUrl(version);
    if (base == null) {
      return null;
    } else {
      String path = url.substring(url.indexOf("-")+1);
      if (!path.contains(".")) {
        return null;
      }
      String type = path.substring(0, path.indexOf("."));
      if (Utilities.existsInList(type, "Annotation", "Attachment", "Identifier", "CodeableConcept", "Coding", "Quantity", "Duration", "Range", "Period", "Ratio", "RatioRange", "SampledData", "Signature", "HumanName", "Address", "ContactPoint", "Timing")) {
        return Utilities.pathURL(base, "datatypes-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      if (Utilities.existsInList(type, "Element", "BackboneElement", "BackboneType", "PrimitiveType", "DataType", "Base")) {
        return Utilities.pathURL(base, "types-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      if (Utilities.existsInList(type, "UsageContext", "RelatedArtifact", "DataRequirement", "ParameterDefinition", "TriggerDefinition", "Expression", "ContactDetail", "ExtendedContactDetail", "VirtualServiceDetail", "Availability", "MonetaryComponent", "Contributor")) {
        return Utilities.pathURL(base, "metadatatypes-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      if (Utilities.existsInList(type, "Reference", "CodeableReference")) {
        return Utilities.pathURL(base, "references-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      if (Utilities.existsInList(type, "Meta")) {
        return Utilities.pathURL(base, "resource-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      return Utilities.pathURL(base, type.toLowerCase()+"-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
    }
  }

  public String getReference(String url) {
    String version = getVersion(url);
    String base = VersionUtilities.getSpecUrl(version);
    if (base == null) {
      return null;
    } else {
      String path = url.substring(url.indexOf("-")+1);
      if (!path.contains(".")) {
        return null;
      }
      String type = path.substring(0, path.indexOf("."));
      if (Utilities.existsInList(type, "Annotation", "Attachment", "Identifier", "CodeableConcept", "Coding", "Quantity", "Duration", "Range", "Period", "Ratio", "RatioRange", "SampledData", "Signature", "HumanName", "Address", "ContactPoint", "Timing")) {
        return Utilities.pathURL(base, "datatypes-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      if (Utilities.existsInList(type, "Element", "BackboneElement", "BackboneType", "PrimitiveType", "DataType", "Base")) {
        return Utilities.pathURL(base, "types-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      if (Utilities.existsInList(type, "UsageContext", "RelatedArtifact", "DataRequirement", "ParameterDefinition", "TriggerDefinition", "Expression", "ContactDetail", "ExtendedContactDetail", "VirtualServiceDetail", "Availability", "MonetaryComponent", "Contributor")) {
        return Utilities.pathURL(base, "metadatatypes-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      if (Utilities.existsInList(type, "Reference", "CodeableReference")) {
        return Utilities.pathURL(base, "references-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      if (Utilities.existsInList(type, "Meta")) {
        return Utilities.pathURL(base, "resource-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
      }
      return Utilities.pathURL(base, type.toLowerCase()+"-definitions.html#"+path+"|"+VersionUtilities.getNameForVersion(version)+" "+path);
    }
  }

}