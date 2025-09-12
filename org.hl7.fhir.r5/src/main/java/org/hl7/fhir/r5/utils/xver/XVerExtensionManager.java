package org.hl7.fhir.r5.utils.xver;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;

@MarkedToMoveToAdjunctPackage
public abstract class XVerExtensionManager {

  protected IWorkerContext context;
  public XVerExtensionManager(IWorkerContext context) {
    this.context = context;
  }

  public enum XVerExtensionStatus {
    BadVersion, Unknown, Invalid, NotAllowed, Valid
  }

  public static final String XVER_EXT_MARKER = "XVER_EXT_MARKER";
  public static final String XVER_VER_MARKER = "XVER_VER_MARKER";


  public abstract XVerExtensionStatus status(String url);

  public abstract StructureDefinition getDefinition(String url);

  public boolean isR5(String url) {
    String v = url.substring(20, 23);
    return "5.0".equals(v);
  }

  public String getElementId(String url) {
    return url.substring(54);
  }

  public String getVersion(String url) {
    return url.substring(20, 23);
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

  protected boolean isVersionPattern(String v) {
    return v.length() == 3 && Character.isDigit(v.charAt(0)) && v.charAt(1) == '.' && Character.isDigit(v.charAt(2));
  }
}