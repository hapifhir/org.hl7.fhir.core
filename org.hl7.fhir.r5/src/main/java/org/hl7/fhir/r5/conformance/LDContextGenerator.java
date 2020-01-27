package org.hl7.fhir.r5.conformance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.RDFTypeMap;

import org.apache.jena.rdf.model.Resource;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a StructureDefinition, iterate through its ElementDefinition and
 * create a context.jsonld file (JSON String).
 */
public class LDContextGenerator {

  private static final String PREFIX_FHIR = "fhir:";
  private static final String SUFFIX_CONTEXT = ".context.jsonld";
  private static final String ARRAY_OF_X = "[x]";
  private static final String BACKBONE_ELEMENT= "BackboneElement";
  private static final String CODE_TYPE = "code";
  private static final String DOMAIN_RESOURCE = "DomainResource";

  private static boolean LOCAL_DEBUG = false;

  private List<LdContext> ldContextList;

  /**
   * Internal metadata services - retrieving structure definitions, and value set expansion etc
   */
  private IWorkerContext context;
  private JsonWriter jsonWriter;
  private boolean isResourceRoot = false;

  /**
   * Constructor
   * @param context
   */
  public LDContextGenerator(IWorkerContext context) {
    super();
    this.context = context;
  }

  /**
   *
   * @param structure
   * @return String representation of the context jsdonld
   */
  public String generate(StructureDefinition structure) {
    ldContextList = new ArrayList<LdContext>();
    return generateLDcontext(structure);
  }

  /**
   * For a StructureDefinition. get ElementDefinition generate a LD context.
   * @param sd
   * @return String that represents the context jsonld.
   */
  private String generateLDcontext(StructureDefinition sd) {

    final List<ElementDefinition> elementDefinitions = sd.getSnapshot().getElement();

    isResourceRoot = isStructuredDefintionRoot(sd);

    elementDefinitions.forEach(elementDefinition -> {
      getNewContextObjects(elementDefinition);
    });

    JsonRenderer jsonRenderer = new JsonRenderer(ldContextList);
    return jsonRenderer.render();
  }

  /**
   * Given an ElementDefinition, create a context object from it.
   * @param elementDefinition
   */
  private void getNewContextObjects(ElementDefinition elementDefinition) {

    if (isResourceRoot) {
      createNewContextObject("resourceType", "rdf:type", null, "@id", false);
    }

    String coPrefix = "";
    String contextObject = elementDefinition.toString();

    String[] coStrings = contextObject.split("\\.");
    if (coStrings != null && coStrings.length >2) {
      // don't process these (ex.  AllergyIntolerance.reaction.id)
      return;
    }

    contextObject = trimContextObject(contextObject);

    if (elementDefinition.toString().contains(ARRAY_OF_X)){
      coPrefix = contextObject;
    }

    String id = elementDefinition.getBase().getPath();
    String idTrimmed = "";

    String[] idStrings = id.split("\\.");
    // skip if there are 3 in the array
    if (idStrings != null && idStrings.length > 0){
      idTrimmed = idStrings[0];
    }

    Resource resource = RDFTypeMap.xsd_type_for(idTrimmed, false);
    String resourceUri = resource != null ? resource.getURI() : null;

    String context = null;
    List<ElementDefinition.TypeRefComponent> type = elementDefinition.getType();

    if (type!=null && type.size() == 1) {

      context = type.get(0).getCode();

      if (context.equals(CODE_TYPE)  &&
              elementDefinition.getBase().getPath().equals(elementDefinition.getId())){
        context = null;
        createNewContextObject(contextObject, idTrimmed + "." + contextObject, context, resourceUri);
      }
      else if (context.equals(BACKBONE_ELEMENT)) {

        context = idTrimmed + "." + contextObject;
        createNewContextObject(contextObject,context, context, resourceUri);
      }
      else {
        context = context.substring(context.lastIndexOf(".") + 1);
        createNewContextObject(contextObject, idTrimmed + "." + contextObject, context,resourceUri);
      }
    }
    else if (type!=null && type.size() > 1) {

      // if type contains "[x]" then strip it off
      for(ElementDefinition.TypeRefComponent typeRefComponent: type) {

        context = typeRefComponent.getCode();
        context = context.substring(context.lastIndexOf(".") + 1);
        contextObject = coPrefix.length() > 0 ?
          coPrefix + toUpperCaseFirstCharacter(context) :
          context;

        createNewContextObject(contextObject, idTrimmed + "." + contextObject, context, resourceUri);
      }
    }
  }

  /**
   * Determine if the StructuredDefinition is a root resource.
   * @param sd
   * @return true if this is a root resource, else false.
   */
  private boolean isStructuredDefintionRoot(StructureDefinition sd) {
    boolean isResourceRoot = false;
    String baseDef = sd.getBaseDefinition();

    if (baseDef == null){
      return isResourceRoot;
    }

    String[] paths = baseDef.split("/");

    if (paths.length > 0) {
      String defintionType =  paths[paths.length -1];
      isResourceRoot = defintionType.equals(DOMAIN_RESOURCE);
    }

    return isResourceRoot;
  }

  /**
   * Create a new context object and add it to the list.
   * @param contextObject
   * @param id
   * @param context
   * @param resourceUri
   */
  private void createNewContextObject(String contextObject, String id, String context, String resourceUri) {
    createNewContextObject(contextObject, id, context, resourceUri, true);
  }

  /**
   * Create a new context object and add it to the list.
   * @param contextObject
   * @param id
   * @param context
   * @param resourceUri
   * @param addIdPrefix
   */
  private void createNewContextObject(String contextObject, String id, String context, String resourceUri, boolean addIdPrefix) {

    if (addIdPrefix) {
      // add the "fhir:" prefix
      id = LDContextGenerator.PREFIX_FHIR + id;
    }

    if (context != null) {
      // add ".context.jsonld" to the end of the string
      context = (context + LDContextGenerator.SUFFIX_CONTEXT).toLowerCase();
    }

    LdContext ldContext = new LdContext(contextObject, id, context, resourceUri);
    ldContextList.add(ldContext);
  }


  /**
   * Trim the context object.
   * Example: AllergyIntolerance.onset[x] would return onset
   * @param co
   * @return
   */
  private String trimContextObject(String co) {
    String trimmedCo = co;

    // remove [x] if present
    if (co.contains(ARRAY_OF_X)){
      trimmedCo = co.substring(0, co.indexOf(ARRAY_OF_X));
    }

    // remove the text up to the first "."
    String[] tempStrings = trimmedCo.split("\\.");
    if (tempStrings.length > 1) {
      trimmedCo =  tempStrings[1];
    }

    return trimmedCo;
  }

  /**
   * Convert the first character of a string to upper case.
   * ex: "java" -> "Java"
   * @param val
   * @return
   */
  private String toUpperCaseFirstCharacter(String val) {
    String retVal = "";

    if (val != null && val.length() > 0) {
      retVal = val.substring(0, 1).toUpperCase() + val.substring(1);
    }

    return retVal;
  }

  /**
   * class to generate context.jsonld JSON file
   */
  private static class JsonRenderer {

    private List<LdContext> ldContextList;
    private JsonWriter writer;

    public JsonRenderer (List<LdContext> ldContextList) {
      super();
      this.ldContextList = ldContextList;
    }

    /**
     * Create a JSON file that contains a static header and a dynamic list of contexts.
     * @return String representation of the JSON.
     */
    protected String render() {

      String filePath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir")).toString() + "/ldconext.json";
//      String filePath = "/Users/m091864/TEMP/ldconext.json";
      String jsonInString = null;

      try {
        writer = new JsonWriter(new FileWriter(filePath));
        writer.setIndent("  ");

        // root object
        writer.beginObject();

        // static JSON header information
        writer.name("@context");

        // @context object
        writer.beginObject();

        // get static json header info
        renderStaticHeader(writer);

        for (LdContext ldContext : ldContextList) {

          // output debug info
          if (LDContextGenerator.LOCAL_DEBUG) {
            System.out.println("\ncontextObject : " + ldContext.getContextObjectName());
            System.out.println("id : " + ldContext.getContextId());

            if (ldContext.getContextContext() != null) {
              System.out.println("context : " + ldContext.getContextContext());
            }
            System.out.println("resourceUri : " + ldContext.getResourceUri());
          }

          writer.name(ldContext.getContextObjectName());
          writer.beginObject();
          writer.name("@id").value(ldContext.getContextId());


          if(ldContext.getResourceUri() != null) {
            writer.name("@type").value(ldContext.getResourceUri());
          }
          else if(ldContext.getContextContext() != null) {
            writer.name("@context").value(ldContext.getContextContext());
          }
          writer.endObject();
        }

        renderStaticIndexObject(writer);

        // @context object end
        writer.endObject();

        // root object end
        writer.endObject();
        writer.flush();
        writer.close();

        // pretty print
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader(filePath);
        // Convert JSON to JsonElement, and later to String
        JsonElement json = gson.fromJson(reader, JsonElement.class);
        jsonInString = gson.toJson(json);

      } catch (IOException e){
        e.printStackTrace();
      }
      return jsonInString;
    }

    /**
     * Generate the static context information.
     * @param writer
     * @throws IOException
     */
    private void renderStaticHeader(JsonWriter writer) throws IOException {

      writer.name("@version").value(1.1);
      writer.name("@vocab").value("http://example.com/UNKNOWN#");
      writer.name("xsd").value("http://www.w3.org/2001/XMLSchema#");
      writer.name("fhir").value("http://hl7.org/fhir/");
      writer.name("rdf").value("http://www.w3.org/1999/02/22-rdf-syntax-ns#");
    }

    /**
     * Create a static "index" object
     * @param writer
     * @throws IOException
     */
    private void renderStaticIndexObject(JsonWriter writer) throws IOException {
      writer.name("index");
      writer.beginObject();
        writer.name("@id").value("fhir:index");
        writer.name("@type").value("http://www.w3.org/2001/XMLSchema#integer");
      writer.endObject();
    }
  }


  /**
   * class to create json for the LDContext data
   */
  private class LdContext {

    private String contextObjectName;
    private String contextId;
    private String contextContext;
    private String resourceUri;

    public LdContext(String contextObjectName, String contextId, String contextContext, String resourceUri) {
      this.contextObjectName = contextObjectName;
      this.contextId = contextId;
      this.contextContext = contextContext;
      this.resourceUri = resourceUri;
    }

    public String getContextObjectName() {
      return contextObjectName;
    }
    public String getContextId() {
      return contextId;
    }
    public String getContextContext() {
      return contextContext;
    }
    public String getResourceUri() {
      return resourceUri;
    }
  }

}
