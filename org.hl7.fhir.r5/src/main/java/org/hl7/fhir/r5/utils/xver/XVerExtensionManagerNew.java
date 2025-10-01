package org.hl7.fhir.r5.utils.xver;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@MarkedToMoveToAdjunctPackage
public class XVerExtensionManagerNew extends XVerExtensionManager {

  public static final String XVER_VERSION_RELEASE = "0.0.1-snapshot-2";
  private Map<String, JsonObject> lists = new HashMap<>();

  public XVerExtensionManagerNew(IWorkerContext context) {
    super(context);
  }

  @Override
  public XVerExtensionStatus status(String url) {
    if (url.length() < 54) {
      return XVerExtensionStatus.Invalid;
    }
    String v = url.substring(20, 23);
    String targetVersion = VersionUtilities.getNameForVersion(v).toLowerCase();
    if (targetVersion.contains("?")) {
      return XVerExtensionStatus.BadVersion;
    }

    String sourceVersion = VersionUtilities.getNameForVersion(context.getVersion()).toLowerCase();
    String pid = "hl7.fhir.uv.xver-"+targetVersion+"."+sourceVersion;
    if (!context.hasPackage(pid, XVER_VERSION_RELEASE)) {
      try {
        context.getManager().loadPackage(pid+"#0.0.1-snapshot-2");
      } catch (IOException e) {
        return XVerExtensionStatus.BadVersion;
      }
    }
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, url);
    if (sd == null) {
      // well, it's not an approved extension, but why? We're going to look in the old
      // version stuff to see whether it's a valid element or not - it'll affect the return value.
      if (isValidPath(v, url)) {
        return XVerExtensionStatus.NotAllowed;
      } else {
        return XVerExtensionStatus.Unknown;
      }
    } else {
      return XVerExtensionStatus.Valid;
    }
  }

  private boolean isValidPath(String v, String url) {
    if (!lists.containsKey(v)) {
      if (context.hasBinaryKey("xver-paths-" + v + ".json")) {
        try {
          lists.put(v, JsonParser.parseObject(context.getBinaryForKey("xver-paths-" + v + ".json")));
        } catch (IOException e1) {
          throw new FHIRException(e1);
        }

        url = url.replace("%5Bx%5D", "[x]");
        String e = url.substring(54);
        JsonObject root = lists.get(v);
        JsonObject path = root.getJsonObject(e);
        if (path == null) {
          path = root.getJsonObject(e + "[x]");
        }
        if (path != null) {
          return true;
        }
      }
    }
    return false;
  }


  @Override
  public StructureDefinition getDefinition(String url) {
    return context.fetchResource(StructureDefinition.class, url);
  }
}

