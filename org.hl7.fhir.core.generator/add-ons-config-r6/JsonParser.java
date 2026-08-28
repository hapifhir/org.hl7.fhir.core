{{startMark}}
package {{pid}};

{{license}}


import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;

import org.hl7.fhir.model.*;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.formats.*;
import org.hl7.fhir.model.utilities.formats.JsonCreator;
import org.hl7.fhir.utilities.Utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

{{generated}}
public class {{jname}}JsonParser extends org.hl7.fhir.model.core.formats.JsonParser {
 
  public {{jname}}JsonParser(IModelContext modelContext, JsonCreator json) {
    super(modelContext);
    this.json = json;
  }

  public {{jname}}JsonParser(IModelContext modelContext, boolean allowUnknownContent, boolean allowComments) {
    super(modelContext);
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