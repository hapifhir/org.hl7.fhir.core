package org.hl7.fhir.r4.conformance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;
import org.apache.jena.rdf.model.Resource;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.utils.RDFTypeMap;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

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
  private static final String RESOURCE = "Resource";
  private static final String DOMAIN_RESOURCE = "DomainResource";



  private static boolean LOCAL_DEBUG = false;
  private boolean isResourceRoot = false;
  private List<LdContext> ldContextList;

  // Map for all ElementDefinition of a specific backbone element
  private ConcurrentHashMap<String, List<ElementDefinition>> backboneList;
  private ConcurrentHashMap<String, String> renderedJson;

  /**
   * Constructor
   */
  public LDContextGenerator() {
    super();
  }

  /**
   *
   * @param structure
   * @return HashMap<String, String> representation of the name of context and the context jsdonld
   */
  public synchronized ConcurrentHashMap<String, String> generate(StructureDefinition structure) {
    ldContextList = new ArrayList<LdContext>();
    backboneList = new ConcurrentHashMap<String, List<ElementDefinition>>();
    renderedJson = new ConcurrentHashMap<String, String>();

    return generateLDcontext(structure);
  }

  /**
   * For a StructureDefinition. get ElementDefinition generate a LD context.
   * This may return multiple json strings, that will be collected in the HashMap.
   * Multiple JSON renderings will be created if the may SturcturedDefinition contains
   * BackboneElement.
   * @param sd
   * @return HashMap<String, String> key that represents the context jsonld and String the is the JSON.
   */
  private synchronized ConcurrentHashMap<String, String> generateLDcontext(StructureDefinition sd) {

    final List<ElementDefinition> elementDefinitions = sd.getSnapshot().getElement();

    isResourceRoot = isStructuredDefintionRoot(sd);

    elementDefinitions.forEach(elementDefinition -> {
      getNewContextObjects(elementDefinition, false);
    });

    JsonRenderer jsonRenderer = new JsonRenderer(ldContextList);
    String json = jsonRenderer.render();
    renderedJson.put(sd.getId(), json);

    // process any backbone elements
    for (String bbKey : backboneList.keySet()) {
      // clear the list after rendering the json for it.
      ldContextList.clear();

      List<ElementDefinition> bb = backboneList.get(bbKey);

      for (ElementDefinition bbElement : bb) {
        getNewContextObjects(bbElement, true);
      }

      // generate the json for this backbone element
      jsonRenderer = new JsonRenderer(ldContextList);
      json = jsonRenderer.render();
      renderedJson.put(bbKey, json);
    }

    return renderedJson;
  }

  /**
   * Given an ElementDefinition, create a context object from it.
   * @param elementDefinition
   * @param isBBElement boolean to indicate if this is a backbone element
   */
  private synchronized void getNewContextObjects(ElementDefinition elementDefinition, boolean isBBElement) {

    if (!isBBElement && isResourceRoot) {
      createNewContextObject("resourceType", "rdf:type", null, "@id", false);
    }

    String coPrefix = "";
    String contextObject = elementDefinition.toString();
//    System.out.println("contextObject: " + contextObject );

    if (!isBBElement) {
      String[] coStrings = contextObject.split("\\.");
      if (coStrings != null && coStrings.length > 2) {
        // (ex.  AllergyIntolerance.reaction.id)
        addBackboneElement(elementDefinition);
        return;
      }
    }

    contextObject = trimContextObject(contextObject, isBBElement);

    if (elementDefinition.toString().contains(ARRAY_OF_X)){
      coPrefix = contextObject;
    }

    String id = elementDefinition.getBase().getPath();
    String idTrimmed = getTrimmedId(id, isBBElement);


    String elementDefTrimmed = getTrimmedElementDefinition(elementDefinition.toString());
    String mappedEd = mapElementDefinitionToXSDType(elementDefTrimmed);

    Resource resource = null;

    if (contextObject.equals("value") &&
            mappedEd != null) {
      resource = RDFTypeMap.xsd_type_for(mappedEd, false);
    }
    else {
      resource = RDFTypeMap.xsd_type_for(idTrimmed, false);
    }

    //Resource resource = RDFTypeMap.xsd_type_for(idTrimmed, false);
    String resourceUri = resource != null ? resource.getURI() : null;

    String context = null;
    List<ElementDefinition.TypeRefComponent> type = elementDefinition.getType();

    if (type!=null && type.size() == 1) {

      context = type.get(0).getCode();
      if (context != null) {

        if (resourceUri != null) {
          context = context.substring(context.lastIndexOf(".") + 1);
          createNewContextObject(contextObject, contextObject, context,resourceUri);
          } else if (context.equals(CODE_TYPE) &&
                elementDefinition.getBase().getPath().equals(elementDefinition.getId())){
          context = "string";
          createNewContextObject(contextObject, idTrimmed + "." + contextObject, context, resourceUri);
        }

        else if (isBackboneElement(elementDefinition) || isElement(elementDefinition)) {

          context = idTrimmed + "." + contextObject;
          createNewContextObject(contextObject,context, context, resourceUri);
          addToBackboneList(context, elementDefinition);
        }
        else {
            context = context.substring(context.lastIndexOf(".") + 1);
            createNewContextObject(contextObject, idTrimmed + "." + contextObject, context, resourceUri);
        }
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
    else {
      String contentReference = elementDefinition.getContentReference();
      if (contentReference != null) {
        if (contentReference.startsWith("#")) {
          contentReference = contentReference.substring(1);
        }
//        context = contextObject.substring(context.lastIndexOf(".") + 1);
//        contextObject = coPrefix.length() > 0 ?
//          coPrefix + toUpperCaseFirstCharacter(context) :
//          context;
        createNewContextObject(contextObject, idTrimmed + "." + contextObject, contentReference.toLowerCase(), resourceUri);
      }
    }
  }


  private boolean isElement(ElementDefinition elementDefinition){
    boolean isElement = false;

    if (elementDefinition.getType() != null
            && elementDefinition.getType().size() > 0
            && elementDefinition.getType().get(0).getCode() != null
            && elementDefinition.getType().get(0).getCode().equals("Element")) {

      isElement = true;
    }
    return isElement;
  }

  private boolean isBackboneElement(ElementDefinition elementDefinition){
    boolean isBackbone = false;

    if (elementDefinition.getType() != null
            && elementDefinition.getType().size() > 0
            && elementDefinition.getType().get(0).getCode() != null
            && elementDefinition.getType().get(0).getCode().equals("BackboneElement")) {

      isBackbone = true;
    }
    return isBackbone;
  }

  /**
   * Add an elementDefinition to its backbone list.
   * @param elementDefinition
   */
  private synchronized void addBackboneElement(ElementDefinition elementDefinition){

    // ex. name=Patient.contact.id
    String name = elementDefinition.toString();
    String nameTrimmed = name.substring(0, name.lastIndexOf("."));

    // if this is another backbone element, put it in the list for later and don't process.
    if (isBackboneElement(elementDefinition) || isElement(elementDefinition)) {
      addToBackboneList(name, elementDefinition);
    }

    ArrayList<ElementDefinition> bbList = (ArrayList)backboneList.get(nameTrimmed);
    if (bbList != null) {
      bbList.add(elementDefinition);
    }
    else {
      System.out.println("**** could not find backbone element for " + name);
    }
  }

  /**
   * Add a new backbone list to track this new backbone
   * @param context
   * @param elementDefinition
   */
  private void addToBackboneList(String context, ElementDefinition elementDefinition){

    ArrayList<ElementDefinition> bbList =  (ArrayList)backboneList.get(context);

    if (bbList == null) {
      bbList = new ArrayList<ElementDefinition>();
      backboneList.put(context, bbList);
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
      isResourceRoot = defintionType.equals(RESOURCE) || defintionType.equals(DOMAIN_RESOURCE);
    }

    return isResourceRoot;
  }

  /**
   * Trim the ElementDefinition name to contain just the name without any "." to the right.
   * @param id
   * @return
   */
  private String getTrimmedElementDefinition(String id) {
    String idTrimmed = "";
    String[] idStrings = id.split("\\.");

    if (idStrings != null && idStrings.length > 0){
      idTrimmed = idStrings[0];
    }
    return idTrimmed;
  }

  /**
   * Trim the ID to have the correct length based on if its a backbone element.
   * @param id
   * @param isBBElement
   * @return
   */
  private String getTrimmedId(String id, boolean isBBElement) {
    String idTrimmed = "";
    String[] idStrings = id.split("\\.");

    // check if this a backbone element
    if (idStrings != null && isBBElement && idStrings.length > 2){
      idTrimmed = id.substring(0, id.lastIndexOf("."));
    }
    else if (idStrings != null && idStrings.length > 0){
      idTrimmed = idStrings[0];
    }
    return idTrimmed;
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
  private synchronized void createNewContextObject(String contextObject, String id, String context, String resourceUri, boolean addIdPrefix) {

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
   * @param isBBElement is this a backbone element
   * @return
   */
  private String trimContextObject(String co, boolean isBBElement) {
    String trimmedCo = co;

    // remove [x] if present
    if (co.contains(ARRAY_OF_X)){
      trimmedCo = co.substring(0, co.indexOf(ARRAY_OF_X));
    }

    // remove the text up to the first "."
    String[] tempStrings = trimmedCo.split("\\.");
    if (tempStrings.length > 1) {
      if (!isBBElement) {
        trimmedCo = tempStrings[1];
      }
      else {
        int index = tempStrings.length -1;
        trimmedCo = tempStrings[index];
      }
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
   * Map the
   * @param elementDefStr
   * @return
   */
  private String mapElementDefinitionToXSDType(String elementDefStr){
    String type = null;
    if (elementDefStr.equals("boolean"))
      type = "boolean";
    else if (elementDefStr.equals("integer"))
      type = "integer";
    else if (elementDefStr.equals("integer64"))
      type = "long";
    else if (elementDefStr.equals("unsignedInt"))
      type = "nonNegativeInteger";
    else if (elementDefStr.equals("positiveInt"))
      type = "positiveInteger";
    else if (elementDefStr.equals("decimal"))
      type = "decimal";
    else if (elementDefStr.equals("base64Binary"))
      type = "base64Binary";
    else if (elementDefStr.equals("instant"))
      type = "dateTime";
    else if (elementDefStr.equals("time"))
      type = "time";

    return type;
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
    protected synchronized String render() {

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

    public synchronized String getContextObjectName() {
      return contextObjectName;
    }
    public synchronized String getContextId() {
      return contextId;
    }
    public synchronized String getContextContext() {
      return contextContext;
    }
    public synchronized String getResourceUri() {
      return resourceUri;
    }
  }

}
