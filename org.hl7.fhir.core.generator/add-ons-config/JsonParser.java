package {{pid}};

// generated

{{license}}

{{startMark}}

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.formats.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.exceptions.FHIRFormatError;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.util.Enumeration;

public class JsonParser extends org.hl7.fhir.r5.formats.JsonParser {

  public JsonParser() {
    super();
  }

  public JsonParser(boolean allowUnknownContent) {
    super();
    setAllowUnknownContent(allowUnknownContent);
  }

  public JsonParser(boolean allowUnknownContent, boolean allowComments) {
    super();
    setAllowUnknownContent(allowUnknownContent);
    setAllowComments(allowComments);
  }

{{parser}}
  
  protected Base parseContent(JsonObject json) throws IOException, FHIRFormatError {
    if (!json.has("resourceType")) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
    }
    String t = json.get("resourceType").getAsString();
    if (Utilities.noString(t)) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
{{parse-resource}}
    } else {
      throw new FHIRFormatError("Unknown.Unrecognised resource type '"+t+"' (in property 'resourceType')");
    }
  }

// -- compose ---------------------------------------------------------------------------------------------------------------------


{{composer}}

  protected void composeContent(Base resource) throws IOException {
    if (resource == null) {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
{{compose-resource}} 
    } else
      throw new Error("Unhandled resource type "+resource.getClass().getName());
  }

}