package {{pid}};

// generated

{{license}}

{{startMark}}

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;

import org.hl7.fhir.r5.formats.JsonCreator;
import org.hl7.fhir.r5.formats.JsonParserBase;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.utilities.Utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class {{jname}}JsonParser extends org.hl7.fhir.r5.formats.JsonParser {
 
  public {{jname}}JsonParser(JsonCreator json) {
    super();
    this.json = json;
  }

  public {{jname}}JsonParser(boolean allowUnknownContent, boolean allowComments) {
    super();
    setAllowUnknownContent(allowUnknownContent);
    setAllowComments(allowComments);
  }

  public Resource parseResource(JsonObject json) throws IOException, FHIRFormatError {
    if (!json.has("resourceType")) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
    }
    String t = json.get("resourceType").getAsString();
    if (Utilities.noString(t)) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
{{parse-resource}}
    } else {
      throw new FHIRFormatError("Unknown/Unrecognised resource type '"+t+"' (in property 'resourceType')");
    }
  }

{{parser}}
  

// -- compose ---------------------------------------------------------------------------------------------------------------------


{{composer}}

  @Override
  protected void composeResource(Resource resource) throws IOException {
    if (resource == null) {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
{{compose-resource}} 
    } else
      throw new Error("Unhandled resource type "+resource.getClass().getName());
  }

}