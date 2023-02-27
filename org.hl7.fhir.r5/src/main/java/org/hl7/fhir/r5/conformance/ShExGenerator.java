package org.hl7.fhir.r5.conformance;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.terminologies.ValueSetExpander;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.stringtemplate.v4.ST;

public class ShExGenerator {

  public enum HTMLLinkPolicy {
    NONE, EXTERNAL, INTERNAL
  }

  public enum ConstraintTranslationPolicy {
    ALL, // Translate all Extensions found; Default (or when no policy defined)
    GENERIC_ONLY, // Translate all Extensions except constraints with context-of-use
    CONTEXT_OF_USE_ONLY  // Translate only Extensions with context-of-use
  }

  public boolean doDatatypes = false;                 // add data types
  public boolean withComments = true;                // include comments
  public boolean completeModel = false;              // doing complete build (fhir.shex)

  public boolean debugMode = false;     // Used for Debugging and testing the code

  public boolean processConstraints = false;   // set to false - to skip processing constraints

  public ConstraintTranslationPolicy constraintPolicy = ConstraintTranslationPolicy.ALL;

  private static String SHEX_TEMPLATE =
      "$header$\n" +
      "$imports$\n" +
      "$shapeDefinitions$";

  // A header is a list of prefixes, a base declaration and a start node
  private static String FHIR = "http://hl7.org/fhir/";
  private static String FHIR_VS = FHIR + "ValueSet/";
  private static String HEADER_TEMPLATE =
    "PREFIX fhir: <$fhir$> \n" +
      "PREFIX fhirvs: <$fhirvs$>\n" +
      "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> \n" +
      "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
      //"BASE <http://hl7.org/fhir/shape/>\n";

  private static String IMPORT_TEMPLATE = "IMPORT <$import$$fileExt$>\n";

  // Start template for single (open) entry
  private static String START_TEMPLATE = "\n\nstart=@<$id$> AND {fhir:nodeRole [fhir:treeRoot]}\n";

  // Start template for complete (closed) model
  private static String ALL_START_TEMPLATE = "\n\nstart=@<All>\n";

  private static String ALL_TEMPLATE = "\n<All> $all_entries$\n";

  private static String ALL_ENTRY_TEMPLATE = "(NOT { fhir:nodeRole [fhir:treeRoot] ; a [fhir:$id$] } OR @<$id$>)";


  // Shape Definition
  //      the shape name
  //      an optional resource declaration (type + treeRoot)
  //      the list of element declarations
  //      an optional index element (for appearances inside ordered lists)
  private static String SHAPE_DEFINITION_TEMPLATE =
    "$comment$\n<$id$> CLOSED { $fhirType$ " +
      "\n    $resourceDecl$" +
      "\n    $elements$" +
      "\n    $contextOfUse$" +
      "\n} $constraints$ \n";

  // Base DataTypes
  private List<String> baseDataTypes = Arrays.asList(
    "DataType",
    "PrimitiveType",
    "BackboneElement"
  );

  private List<String> shortIdException = Arrays.asList(
    "base64Binary", "boolean",
    "date", "dateTime", "decimal", "instant", "integer64",
    "integer", "string", "time", "uri"
  );

  private List<String> mappedFunctions = Arrays.asList(
    "empty",
    "exists",
    "hasValue",
    "matches",
    "contains",
    //"toString",
    "is"
    //"where"
  );

  private static String ONE_OR_MORE_PREFIX = "OneOrMore_";
  private static String ONE_OR_MORE_CHOICES = "_One-Or-More-Choices_";
  private static String ONE_OR_MORE_TEMPLATE =
    "\n$comment$\n<$oomType$> CLOSED {" +
      "\n    rdf:first @<$origType$> $restriction$ ;" +
      "\n    rdf:rest [rdf:nil] OR @<$oomType$> " +
      "\n}\n";

  // Resource Definition
  //      an open shape of type Resource.  Used when completeModel = false.
  private static String RESOURCE_SHAPE_TEMPLATE =
    "$comment$\n<Resource> {" +
      "\n    $elements$" +
      "\n    $contextOfUse$" +
      "\n} $constraints$ \n";

  // If we have knowledge of all of the possible resources available to us (completeModel = true), we can build
  // a model of all possible resources.
  private static String COMPLETE_RESOURCE_TEMPLATE =
    "<Resource>  @<$resources$>" +
      "\n\n";

  // Resource Declaration
  //      a type node
  //      an optional treeRoot declaration (identifies the entry point)
  private static String RESOURCE_DECL_TEMPLATE = "\na [fhir:$id$]?;$root$";

  // Root Declaration.
  private static String ROOT_TEMPLATE = "\nfhir:nodeRole [fhir:treeRoot]?;\n";

  // Element
  //    a predicate, type and cardinality triple
  private static String ELEMENT_TEMPLATE = "$id$$defn$$card$$comment$";
  private static int COMMENT_COL = 40;
  private static int MAX_CHARS = 35;
  private static int MIN_COMMENT_SEP = 2;

  // Inner Shape Definition
  private static String INNER_SHAPE_TEMPLATE = "($comment$\n    $defn$\n)$card$";

  // Simple Element
  //    a shape reference
  private static String SIMPLE_ELEMENT_DEFN_TEMPLATE = "@<$typ$>$vsdef$";

  // Value Set Element
  private static String VALUESET_DEFN_TEMPLATE = " AND\n\t{fhir:v @$vsn$}";

  // Fixed Value Template
  private static String FIXED_VALUE_TEMPLATE = " AND\n\t{fhir:value [\"$val$\"]}";

  // A primitive element definition
  //    the actual type reference
  private static String PRIMITIVE_ELEMENT_DEFN_TEMPLATE = "$typ$$facets$";

  // Facets
  private static String MINVALUE_TEMPLATE = " MININCLUSIVE $val$";
  private static String MAXVALUE_TEMPLATE = " MAXINCLUSIVE $val$";
  private static String MAXLENGTH_TEMPLATE = " MAXLENGTH $val$";
  private static String PATTERN_TEMPLATE = " PATTERN \"$val$\"";

  // A choice of alternative shape definitions
  //  rendered as an inner anonymous shape
  private static String ALTERNATIVE_SHAPES_TEMPLATE = "fhir:$id$$comment$\n(   $altEntries$\n)$card$";

  // A typed reference definition
  private static String REFERENCE_DEFN_TEMPLATE = "@<$ref$Reference>";

  // What we emit for an xhtml
  private static String XHTML_TYPE_TEMPLATE = "xsd:string";

  // Additional type for Coding
  private static String CONCEPT_REFERENCE_TEMPLATE = "a NONLITERAL?;";

  // Additional type for CodedConcept
  private static String CONCEPT_REFERENCES_TEMPLATE = "a NONLITERAL*;";

  // Untyped resource has the extra link entry
  private static String RESOURCE_LINK_TEMPLATE = "fhir:link IRI?;";

  // Extension template
  // No longer used -- we emit the actual definition
//  private static String EXTENSION_TEMPLATE = "<Extension> {fhir:extension @<Extension>*;" +
//          "\n    fhir:index xsd:integer?" +
//          "\n}\n";

  // A typed reference -- a fhir:uri with an optional type and the possibility of a resolvable shape
  private static String TYPED_REFERENCE_TEMPLATE = "\n<$refType$Reference> CLOSED {" +
    "\n    fhir:Element.id @<id>?;" +
    "\n    fhir:Element.extension @<Extension>*;" +
    "\n    fhir:link @<$refType$> OR CLOSED {a [fhir:$refType$]}?;" +
    "\n    fhir:Reference.reference @<string>?;" +
    "\n    fhir:Reference.display @<string>?;" +
    // "\n    fhir:index xsd:integer?" +
    "\n}";

  private static String TARGET_REFERENCE_TEMPLATE = "\n<$refType$> {" +
    "\n    a [fhir:$refType$];" +
    "\n    fhir:nodeRole [fhir:treeRoot]?" +
    "\n}";

  // A value set definition
  private static String VALUE_SET_DEFINITION = "# $comment$\n$vsuri$$val_list$\n";


  /**
   * this makes internal metadata services available to the generator - retrieving structure definitions, and value set expansion etc
   */
  private IWorkerContext context;
  private ProfileUtilities profileUtilities;

  /**
   * innerTypes -- inner complex types.  Currently flattened in ShEx (doesn't have to be, btw)
   * emittedInnerTypes -- set of inner types that have been generated
   * datatypes, emittedDatatypes -- types used in the definition, types that have been generated
   * references -- Reference types (Patient, Specimen, etc)
   * uniq_structures -- set of structures on the to be generated list...
   * doDataTypes -- whether or not to emit the data types.
   */
  private HashSet<Pair<StructureDefinition, ElementDefinition>> innerTypes, emittedInnerTypes;

  private List<String> oneOrMoreTypes;

  private List<String> constraintsList;

  private List<String> unMappedFunctions;

  private HashSet<String> datatypes, emittedDatatypes;
  private HashSet<String> references;
  private LinkedList<StructureDefinition> uniq_structures;
  private HashSet<String> uniq_structure_urls;
  private HashSet<ValueSet> required_value_sets;
  private HashSet<String> known_resources;          // Used when generating a full definition

  // List of URLs of Excluded Structure Definitions from ShEx Schema generation.
  private List<String> excludedSDUrls;

  // List of URLs of selected Structure Definitions of Extensions from ShEx Schema generation.
  // Extensions are Structure Definitions with type as "Extension".
  private List<StructureDefinition> selectedExtensions;
  private List<String> selectedExtensionUrls;

  private List<String> imports;
  private FHIRPathEngine fpe;

  public ShExGenerator(IWorkerContext context) {
    super();
    this.context = context;
    profileUtilities = new ProfileUtilities(context, null, null);
    innerTypes = new HashSet<Pair<StructureDefinition, ElementDefinition>>();
    oneOrMoreTypes = new ArrayList<String>();
    constraintsList = new ArrayList<String>();
    unMappedFunctions = new ArrayList<String>();
    emittedInnerTypes = new HashSet<Pair<StructureDefinition, ElementDefinition>>();
    datatypes = new HashSet<String>();
    emittedDatatypes = new HashSet<String>();
    references = new HashSet<String>();
    required_value_sets = new HashSet<ValueSet>();
    known_resources = new HashSet<String>();
    excludedSDUrls = new ArrayList<String>();
    selectedExtensions = new ArrayList<StructureDefinition>();
    selectedExtensionUrls = new ArrayList<String>();
    imports = new ArrayList<String>();

    fpe = new FHIRPathEngine(context);
  }

  public String generate(HTMLLinkPolicy links, StructureDefinition structure) {
    List<StructureDefinition> list = new ArrayList<StructureDefinition>();
    list.add(structure);
    innerTypes.clear();
    oneOrMoreTypes.clear();
    constraintsList.clear();
    unMappedFunctions.clear();
    emittedInnerTypes.clear();
    datatypes.clear();
    emittedDatatypes.clear();
    references.clear();
    required_value_sets.clear();
    known_resources.clear();
    imports.clear();
    return generate(links, list);
  }

  public List<String> getExcludedStructureDefinitionUrls(){
    return this.excludedSDUrls;
  }

  public void setExcludedStructureDefinitionUrls(List<String> excludedSDs){
    this.excludedSDUrls = excludedSDs;
  }

  public List<StructureDefinition> getSelectedExtensions(){
    return this.selectedExtensions;
  }

  public void setSelectedExtension(List<StructureDefinition> selectedExtensions){
    this.selectedExtensions = selectedExtensions;

    selectedExtensionUrls.clear();

    for (StructureDefinition eSD : selectedExtensions){
      if (!selectedExtensionUrls.contains(eSD.getUrl()))
        selectedExtensionUrls.add(eSD.getUrl());
    }
  }

  public class SortById implements Comparator<StructureDefinition> {

    @Override
    public int compare(StructureDefinition arg0, StructureDefinition arg1) {
      return arg0.getId().compareTo(arg1.getId());
    }

  }

  private ST tmplt(String template) {
    return new ST(template, '$', '$');
  }

  /**
   * this is called externally to generate a set of structures to a single ShEx file
   * generally, it will be called with a single structure, or a long list of structures (all of them)
   *
   * @param links HTML link rendering policy
   * @param structures list of structure definitions to render
   * @return ShEx definition of structures
   */
  public String generate(HTMLLinkPolicy links, List<StructureDefinition> structures, List<String> excludedSDUrls) {
    this.excludedSDUrls = excludedSDUrls;

    if ((structures != null )&&(this.selectedExtensions != null)){
      structures.addAll(this.selectedExtensions);
    }

    return generate(links, structures);
  }

  /**
   * this is called externally to generate a set of structures to a single ShEx file
   * generally, it will be called with a single structure, or a long list of structures (all of them)
   *
   * @param links HTML link rendering policy
   * @param structures list of structure definitions to render
   * @return ShEx definition of structures
   */
  public String generate(HTMLLinkPolicy links, List<StructureDefinition> structures) {
    ST shex_def = tmplt(SHEX_TEMPLATE);
    String start_cmd;
    if(completeModel || structures.get(0).getKind().equals(StructureDefinition.StructureDefinitionKind.RESOURCE))
      start_cmd = completeModel? tmplt(ALL_START_TEMPLATE).render() :
        tmplt(START_TEMPLATE).add("id", structures.get(0).getId()).render();
    else
      start_cmd = "";

    shex_def.add("header",
      tmplt(HEADER_TEMPLATE).
        add("fhir", FHIR).
        add("fhirvs", FHIR_VS).render());

    Collections.sort(structures, new SortById());
    StringBuilder shapeDefinitions = new StringBuilder();

    // For unknown reasons, the list of structures carries duplicates.
    // We remove them.  Also, it is possible for the same sd to have multiple hashes...
    uniq_structures = new LinkedList<StructureDefinition>();
    uniq_structure_urls = new HashSet<String>();
    StringBuffer allStructures = new StringBuffer("");
    for (StructureDefinition sd : structures) {
      // Exclusion Criteria...
      if ((excludedSDUrls != null) &&
        (excludedSDUrls.contains(sd.getUrl()))) {
        printBuildMessage("SKIPPED Generating ShEx for " + sd.getName() + "  [ " + sd.getUrl() + " ] !");
        printBuildMessage("Reason: It is in excluded list of structures.");
        continue;
      }

      if ("Extension".equals(sd.getType())) {
        if ((!this.selectedExtensionUrls.isEmpty()) && (!this.selectedExtensionUrls.contains(sd.getUrl()))) {
          printBuildMessage("SKIPPED Generating ShEx for " + sd.getName() + "  [ " + sd.getUrl() + " ] !");
          printBuildMessage("Reason: It is NOT included in the list of selected extensions.");
          continue;
        }

        if ((this.constraintPolicy == ConstraintTranslationPolicy.GENERIC_ONLY) && (sd.hasContext())) {
          printBuildMessage("SKIPPED Generating ShEx for " + sd.getName() + "  [ " + sd.getUrl() + " ] !");
          printBuildMessage("Reason: ConstraintTranslationPolicy is set to GENERIC_ONLY, and this Structure has Context of Use.");
          continue;
        }

        if ((this.constraintPolicy == ConstraintTranslationPolicy.CONTEXT_OF_USE_ONLY) && (!sd.hasContext())) {
          printBuildMessage("SKIPPED Generating ShEx for " + sd.getName() + "  [ " + sd.getUrl() + " ] !");
          printBuildMessage("Reason: ConstraintTranslationPolicy is set to CONTEXT_OF_USE_ONLY, and this Structure has no Context of Use.");
          continue;
        }
      }

      if (!uniq_structure_urls.contains(sd.getUrl())) {
        uniq_structures.add(sd);
        uniq_structure_urls.add(sd.getUrl());
      }
    }

    for (StructureDefinition sd : uniq_structures) {
      printBuildMessage(" ---- Generating ShEx for : " + sd.getName() + "  [ " + sd.getUrl() + " ] ...");
      String shapeDefinitionStr = genShapeDefinition(sd, true);

      if (!shapeDefinitionStr.isEmpty()) {
        shapeDefinitions.append(shapeDefinitionStr);
      } else {
        printBuildMessage(" ---- WARNING! EMPTY/No ShEx SCHEMA Body generated for : " + sd.getName() + "  [ " + sd.getUrl() + " ].\n" +
          "This might not be an issue, if this resource is normative base or a meta resource");
        shapeDefinitions.append("<" + sd.getName() + "> CLOSED {\n}");
      }
    }
      shapeDefinitions.append(emitInnerTypes());

      // If data types are to be put in the same file
      if (doDatatypes) {
        shapeDefinitions.append("\n#---------------------- Data Types -------------------\n");
        while (emittedDatatypes.size() < datatypes.size() ||
          emittedInnerTypes.size() < innerTypes.size()) {
          shapeDefinitions.append(emitDataTypes());
          // As process data types, it may introduce some more inner types, so we repeat the call here.
          shapeDefinitions.append(emitInnerTypes());
        }
      }

      if (oneOrMoreTypes.size() > 0) {
        shapeDefinitions.append("\n#---------------------- Cardinality Types (OneOrMore) -------------------\n");
        oneOrMoreTypes.forEach((String oomType) -> {
          shapeDefinitions.append(getOneOrMoreType(oomType));
        });
      }

      if (references.size() > 0) {
        shapeDefinitions.append("\n#---------------------- Reference Types -------------------\n");
        for (String r : references) {
          shapeDefinitions.append("\n").append(tmplt(TYPED_REFERENCE_TEMPLATE).add("refType", r).render()).append("\n");
          if (!"Resource".equals(r) && !known_resources.contains(r))
            shapeDefinitions.append("\n").append(tmplt(TARGET_REFERENCE_TEMPLATE).add("refType", r).render()).append("\n");
        }
      }

      if (completeModel && known_resources.size() > 0) {
        shapeDefinitions.append("\n").append(tmplt(COMPLETE_RESOURCE_TEMPLATE)
          .add("resources", StringUtils.join(known_resources, "> OR\n\t@<")).render());
        List<String> all_entries = new ArrayList<String>();
        for (String kr : known_resources)
          all_entries.add(tmplt(ALL_ENTRY_TEMPLATE).add("id", kr).render());
        shapeDefinitions.append("\n").append(tmplt(ALL_TEMPLATE)
          .add("all_entries", StringUtils.join(all_entries, " OR\n\t")).render());
      }

      if (required_value_sets.size() > 0) {
        shapeDefinitions.append("\n#---------------------- Value Sets ------------------------\n");
        List<String> sortedVS = new ArrayList<String>();
        for (ValueSet vs : required_value_sets)
          sortedVS.add(genValueSet(vs));

        Collections.sort(sortedVS, new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            try {
              return StringUtils.substringBetween(o1, "fhirvs:", " ")
                .compareTo(StringUtils.substringBetween(o2, "fhirvs:", " "));
            }
            catch(Exception e){
              debug("SORT COMPARISON FAILED BETWEEN \n\t\t" + o1 + "\n\t\t and \n\t\t" + o2);
              debug(e.getMessage());
              return 0;
            }
          }
      });

        for (String svs : sortedVS)
          shapeDefinitions.append("\n").append(svs);
      }

      if ((unMappedFunctions != null) && (!unMappedFunctions.isEmpty())) {
        debug("------------------------- Unmapped Functions ---------------------");
        for (String um : unMappedFunctions) {
          debug(um);
        }
      }

      allStructures.append(shapeDefinitions + "\n");

    StringBuffer allImports = new StringBuffer("");
    if (!imports.isEmpty()) {
      uniq_structures.forEach((StructureDefinition sdstruct) -> {
          imports.removeIf(s -> s.contains(sdstruct.getName()));
      });

      imports.sort(Comparator.comparingInt(String::length));
      imports.forEach((String imp) -> {
        ST import_def = tmplt(IMPORT_TEMPLATE);
        import_def.add("import", imp);
        import_def.add("fileExt", ".shex");
        allImports.append(import_def.render());
      });
    }

    allImports.append(start_cmd);
    shex_def.add("imports", allImports);
    shex_def.add("shapeDefinitions", allStructures.toString());

    return shex_def.render();
  }

  private String getBaseTypeName(StructureDefinition sd){
    if (sd == null)
      return null;

    String bd = null;
    if (sd.hasBaseDefinition()) {
      bd = sd.getBaseDefinition();
      String[] els = bd.split("/");
      bd = els[els.length - 1];
    }

    return bd;
  }

  private String getBaseTypeName(ElementDefinition ed){
    if (ed == null)
      return null;

    return (ed.getType().size() > 0)? (ed.getType().get(0).getCode()) : null;
  }

  private String getExtendedType(StructureDefinition sd){
    String bd = getBaseTypeName(sd);
    String sId = sd.getId();

    if (bd!=null) {
      addImport("<" + bd + ">");
      sId += "> EXTENDS @<" + bd;
    }

    return sId;
  }

  private String getExtendedType(ElementDefinition ed){
    String bd = getBaseTypeName(ed);
    //if (bd != null  && !baseDataTypes.contains(bd)) {
    if (bd!=null) {
      addImport("<" + bd + ">");
      bd = "> EXTENDS @<" + bd;
    }
    return bd;
  }

  /**
   * Emit a ShEx definition for the supplied StructureDefinition
   * @param sd Structure definition to emit
   * @param top_level True means outermost type, False means recursively called
   * @return ShEx definition
   */
  private String genShapeDefinition(StructureDefinition sd, boolean top_level) {
    // xhtml is treated as an atom
    if("xhtml".equals(sd.getName()) || (completeModel && "Resource".equals(sd.getName())))
      return "";

    ST shape_defn;
    // Resources are either incomplete items or consist of everything that is defined as a resource (completeModel)
    //    if (sd.getName().equals("ActivityDefinition")){
    //      debug("ActivityDefinition found");
    //    }
      if("Resource".equals(sd.getName())) {
        shape_defn = tmplt(RESOURCE_SHAPE_TEMPLATE);
        known_resources.add(sd.getName());
        } else {
        shape_defn = tmplt(SHAPE_DEFINITION_TEMPLATE).add("id", getExtendedType(sd));
        known_resources.add(sd.getName());

        if (baseDataTypes.contains(sd.getType())) {
          shape_defn.add("resourceDecl", "\n");
        } else {
          if ("Element".equals(sd.getName()))
            shape_defn.add("resourceDecl", tmplt(ROOT_TEMPLATE).render());
          else {
            String rootTmpl = tmplt(ROOT_TEMPLATE).render();
            String btn = getBaseTypeName(sd);
            if ((baseDataTypes.contains(btn))||
              (shortIdException.contains(btn)))
              rootTmpl = "\n";

            ST resource_decl = tmplt(RESOURCE_DECL_TEMPLATE).
              add("id", sd.getId()).
              add("root", rootTmpl);

            shape_defn.add("resourceDecl", resource_decl.render());
          }
        }
      }
      shape_defn.add("fhirType", " ");

    // Generate the defining elements
    List<String> elements = new ArrayList<String>();

    // Add the additional entries for special types
    String sdn = sd.getName();
    if (sdn.equals("Coding"))
      elements.add(tmplt(CONCEPT_REFERENCE_TEMPLATE).render());
    else if (sdn.equals("CodeableConcept"))
      elements.add(tmplt(CONCEPT_REFERENCES_TEMPLATE).render());
    else if (sdn.equals("Reference"))
      elements.add(tmplt(RESOURCE_LINK_TEMPLATE).render());

    String root_comment = null;

    constraintsList.clear();
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if(!ed.getPath().contains("."))
        root_comment = ed.getShort();
      else if (
        (StringUtils.countMatches(ed.getPath(), ".") == 1 && !"0".equals(ed.getMax()))
          && (ed.hasBase()
          && (
          ed.getBase().getPath().startsWith(sdn)
            || (ed.getBase().getPath().startsWith("Extension"))
            || (ed.getBase().getPath().startsWith("Element.extension")&&(ed.hasSliceName()))
        )
        )
      ){
        String elementDefinition = genElementDefinition(sd, ed);

        boolean isInnerType = false;
        if (isInInnerTypes(ed)){
          //debug("This element is already in innerTypes:" + ed.getPath());
          isInnerType = true;
        }

        if (processConstraints) {
          // Process constraints
          for (ElementDefinition.ElementDefinitionConstraintComponent constraint : ed.getConstraint()) {
            String sdType = sd.getType();
            String cstype = constraint.getSource();
            if ((!cstype.isEmpty()) && (cstype.indexOf("/") != -1)) {
              String[] els = cstype.split("/");
              cstype = els[els.length - 1];
            }

            String id = ed.hasBase() ? ed.getBase().getPath() : ed.getPath();
            String shortId = id.substring(id.lastIndexOf(".") + 1);
            if ((ed.hasContentReference() && (!ed.hasType())) || (id.equals(sd.getName() + "." + shortId))) {
              if ((sdType.equals(cstype)) || baseDataTypes.contains(sdType)) {
                if (!isInnerType) {
                  debug("\n        Key: " + constraint.getKey() + " SD type: " + sd.getType() + " Element: " + ed.getPath() + " Constraint Source: " + constraint.getSource() + " Constraint:" + constraint.getExpression());
                  String transl = translateConstraint(sd, ed, constraint);
                  if (transl.isEmpty() || constraintsList.contains(transl))
                    continue;
                  constraintsList.add(transl);
                }
              }
            }
          }
        }
        elements.add(elementDefinition);
      }
      else {
        List<ElementDefinition> children = profileUtilities.getChildList(sd, ed);
        if (children.size() > 0) {
          for (ElementDefinition child : children) {
            if (child.getPath().startsWith(ed.getPath()))
              innerTypes.add(new ImmutablePair<StructureDefinition, ElementDefinition>(sd, ed));
          }
        }
      }
    }

    if (processConstraints) {
      // Constraints for differential to cover constraints on SD itself without any elements of its own
      for (ElementDefinition ded : sd.getDifferential().getElement()) {
        // Process constraints
        for (ElementDefinition.ElementDefinitionConstraintComponent dconstraint : ded.getConstraint()) {
          String sdType = sd.getType();

          String id = ded.hasBase() ? ded.getBase().getPath() : ded.getPath();
          String shortId = id.substring(id.lastIndexOf(".") + 1);

          if (!isInInnerTypes(ded)) {
            debug("\n        Key: " + dconstraint.getKey() + " SD type: " + sd.getType() + " Element: " + ded.getPath() + " Constraint Source: " + dconstraint.getSource() + " Constraint:" + dconstraint.getExpression());
            String dtransl = translateConstraint(sd, ded, dconstraint);
            if (dtransl.isEmpty() || constraintsList.contains(dtransl))
              continue;
            constraintsList.add(dtransl);
          }
        }
      }
    }

    shape_defn.add("elements", StringUtils.join(elements, "\n"));
    shape_defn.add("comment", root_comment == null? " " : "# " + root_comment);

    String constraintStr = "";

    if (!constraintsList.isEmpty()) {
      constraintStr = "AND (\n\n" + StringUtils.join(constraintsList, "\n\n) AND (\n\n") + "\n\n)\n";
    }

    shape_defn.add("constraints", constraintStr);

    String contextOfUseStr = "";
    ArrayList<String> contextOfUse = new ArrayList<String>();
    if (!sd.getContext().isEmpty()) {
      for (StructureDefinition.StructureDefinitionContextComponent uc : sd.getContext()) {
        if (!uc.getExpression().isEmpty()) {
          String toStore = uc.getExpression();
          debug("CONTEXT-OF-USE FOUND: " + toStore);
          if (toStore.indexOf("http") != -1) {
            debug("\t\tWARNING: CONTEXT-OF-USE SKIPPED as it has 'http' in it, might be a URL, instead of '.' delimited string");
            continue;  // some erroneous context of use may use a URL; ignore them
          }
          String[] backRefs = toStore.split("\\.");
          toStore = "a [fhir:" + backRefs[0] + "]";
          for (int i = 1; i < backRefs.length; i++)
            toStore = "^fhir:" + backRefs[i] + " {" + toStore + "}";

          if (!contextOfUse.contains(toStore)) {
            contextOfUse.add(toStore);
          }
        }
      }

      if (!contextOfUse.isEmpty()) {
        if (contextOfUse.size() > 1)
          contextOfUseStr = "^fhir:extension { " + StringUtils.join(contextOfUse, "} OR \n      {") + "}\n";
        else
          contextOfUseStr = "^fhir:extension { " + contextOfUse.get(0) + "}\n";
      }
    }

    shape_defn.add("contextOfUse", contextOfUseStr);

    return shape_defn.render();
  }

  /**
   * @param ed
   * @param constraint
   * @return
   */
  private String translateConstraint(StructureDefinition sd, ElementDefinition ed, ElementDefinition.ElementDefinitionConstraintComponent constraint){
    String translated = "";

    if (constraint != null) {
    //if (false) {
      String ce = constraint.getExpression();
      String constItem = "FHIR-SD-Path:" + ed.getPath() + " Expression: " + ce;
      try {
        translated = "# Constraint UniqueKey:" + constraint.getKey() + "\n# Human readable:" + constraint.getHuman() + "\n\n# Constraint: " + constraint.getExpression() + "\n# ShEx:\n";

        ExpressionNode expr = fpe.parse(ce);
        String shexConstraint = processExpressionNode(sd, ed, expr, false, 0);
        shexConstraint = shexConstraint.replaceAll("CALLER", "");
        debug("        Parsed to ShEx Constraint:" + shexConstraint);
        if (!shexConstraint.isEmpty())
          translated += "\n" + shexConstraint;

        debug("        TRANSLATED\t"+ed.getPath()+"\t"+constraint.getHuman()+"\t"+constraint.getExpression()+"\t"+shexConstraint);

      } catch (Exception e) {
        //String message = "        FAILED to parse the constraint from Structure Definition: " + constItem + " [ " + e.getMessage() + " ]";
        String message = "        FAILED to parse the constraint from Structure Definition: " + constItem;
        e.printStackTrace();

        translated = "";
        debug(message);
      }
    }
    return commentUnmapped(translated);
  }

  /**
   * @param node
   * @param quote
   * @return
   */
  private String processExpressionNode(StructureDefinition sd, ElementDefinition ed, ExpressionNode node, boolean quote, int depth) {
    if (node == null)
      return "";
    boolean toQuote  = quote;

    String innerShEx = "";

    if (node.getInner() != null){
        innerShEx = processExpressionNode(sd, ed, node.getInner(), quote, depth + 1);
    }

    String translatedShEx = "";

    boolean treatBothOpsSame = false;
    // Figure out if there are any operations defined on this node
    String ops = "";
    String endOps = "";
    if (node.getOperation() != null) {
      String opName = node.getOperation().name();
      switch (opName) {
        case "Or":
          ops = " OR ";
          break;
        case "Union":
          //ops = " | ";
          ops = " ";
          break;
        case "In" :
        case "Equals":
        case "Contains":
          if (!node.getOpNext().getKind().equals(ExpressionNode.Kind.Name)) {
            ops = " { fhir:v [";
            endOps = "] } ";
            toQuote = true;
          } else {
            String toStore = "UNMAPPED_OPERATOR_" + opName + " in Node type: " + node.getKind();
            addUnmappedFunction(opName);
            ops = TBD(opName);
          }
          break;
        case "NotEquals":
          if (!node.getOpNext().getKind().equals(ExpressionNode.Kind.Name)) {
            ops = " [fhir:v  . -";
            endOps = "] ";
            toQuote = true;
          } else {
            String toStore = "UNMAPPED_OPERATOR_" + opName + " in Node type: " + node.getKind();
            addUnmappedFunction(opName);
            ops = TBD(opName);
          }
          break;
        case "Greater":
          if (node.getOpNext().getKind().equals(ExpressionNode.Kind.Constant)) {
            ops = " { fhir:v MinExclusive ";
            endOps = " } ";
          } else {
            String toStore = "UNMAPPED_OPERATOR_" + opName + " in Node type: " + node.getKind();
            addUnmappedFunction(opName);
            ops = TBD(opName);
          }
          break;
        case "GreaterOrEqual":
          if (node.getOpNext().getKind().equals(ExpressionNode.Kind.Constant)) {
            ops = " { fhir:v MinInclusive ";
            endOps = " } ";
          } else {
            String toStore = "UNMAPPED_OPERATOR_" + opName + " in Node type: " + node.getKind();
            addUnmappedFunction(opName);
            ops = TBD(opName);
          }
          break;
        case "Less":
        case "LessThan":
          if (node.getOpNext().getKind().equals(ExpressionNode.Kind.Constant)) {
            ops = " { fhir:v MaxExclusive ";
            endOps = " } ";
          } else {
            String toStore = "UNMAPPED_OPERATOR_" + opName + " in Node type: " + node.getKind();
            addUnmappedFunction(opName);
            ops = TBD(opName);
          }
          break;
        case "LessOrEqual":
          if (node.getOpNext().getKind().equals(ExpressionNode.Kind.Constant)) {
            ops = " { fhir:v MaxInclusive ";
            endOps = " } ";
          } else {
            String toStore = "UNMAPPED_OPERATOR_" + opName + " in Node type: " + node.getKind();
            addUnmappedFunction(opName);
            ops = TBD(opName);
          }
          break;
        case "And":
        //case "Implies" :
        ops = " AND ";
        break;
        case "As":
        case "Is":
          ops = " a ";
          break;
        //case "Xor":
          //ops = " XOR ";  // Although I implemented a routine for XOR, but that needs more testing.
         // break;
        default:
          String toStore = "UNMAPPED_OPERATOR_" + opName + " in Node type: " + node.getKind();
          if (!unMappedFunctions.contains(toStore))
            unMappedFunctions.add(toStore);

          ops = TBD(opName);
      }
    }

    // Functions
    String fExp = "";
    String pExp = "";
    boolean isFunctionCall = false;
    ExpressionNode.Kind kind = node.getKind();
    if (kind == ExpressionNode.Kind.Function) {
      String funcName = node.getName();
      if (!mappedFunctions.contains(funcName)) {
        if (node.parameterCount() == 0) {
          if ("not".equals(funcName))
            fExp = " NOT { CALLER }";
          else {
            fExp = " " + TBD(funcName) + "( CALLER )";
            addUnmappedFunction(node.getFunction().toCode());
            String toStore = addUnmappedFunction(node.getFunction().toCode());
          }
        }
      }

      if ("".equals(fExp)) {
        switch (funcName) {
          case "empty":
            //fExp = " .?";
            fExp = " NOT { CALLER {fhir:v .} } " ;
            break;
          case "exists":
          case "hasValue":
            fExp = " .";
            break;
          case "matches":
            ops = " { fhir:v /";
            endOps = "/ } ";
            break;
          //case "where": // 'where' just states an assertion
           // ops = "{ ";
           // endOps = " }";
           // break;
          case "contains":
            ops = " { fhir:v [";
            endOps = "] } ";
            toQuote = true;
            break;
          //case "toString":  // skip this function call because values gets stringitize anyway
           // pExp = "";
           // break;
          case "is":
            ops = " { a [";
            endOps = "] } ";
            break;
          default:
            fExp = TBD(node.getFunction().toCode());
            String toStore = addUnmappedFunction(node.getFunction().toCode());
        }

        if (node.parameterCount() > 0) {
          for (ExpressionNode pen : node.getParameters()) {
            if (!"".equals(pExp))
              pExp += ", ";
            pExp += processExpressionNode(sd, ed, pen, quote, depth);
            isFunctionCall = true;
          }
        }
      }

      if (isFunctionCall) {
        if (!mappedFunctions.contains(funcName))
          translatedShEx += fExp + "(" + pExp + ")";
        else {
          translatedShEx += ops + pExp + endOps;
          ops = "";
          endOps = "";
        }
      }
      else
        translatedShEx += fExp;

      translatedShEx = positionParts(innerShEx, translatedShEx,
        getNextOps(ops , processExpressionNode(sd, ed, node.getOpNext(), toQuote, depth), endOps, treatBothOpsSame),
        depth, false);

    } else  if (kind == ExpressionNode.Kind.Name) {
      String mT = (depth == 0)? "fhir:" + node.getName() : node.getName();
      translatedShEx += positionParts(innerShEx, mT,
        getNextOps(ops, processExpressionNode(sd, ed, node.getOpNext(), toQuote, depth), endOps, treatBothOpsSame),
        depth, true);
      //if (depth == 0)
       // translatedShEx = commentUnmapped(translatedShEx);
    }else if (kind == ExpressionNode.Kind.Group) {
      translatedShEx += positionParts(innerShEx, processExpressionNode(sd, ed, node.getGroup(), toQuote, depth),
        getNextOps(ops , processExpressionNode(sd, ed, node.getOpNext(), toQuote, depth), endOps, treatBothOpsSame),
        depth, true);
      //if (depth == 0)
       // translatedShEx = commentUnmapped(translatedShEx);
    } else if (kind == ExpressionNode.Kind.Constant) {
      Base constantB = node.getConstant();
      boolean toQt = (constantB instanceof StringType) || (!constantB.isPrimitive());
      String constantV = constantB.primitiveValue();

      if (constantV.startsWith("%")) {
        try {
          // Evaluate the expression, this resolves unknowns in the value.
          List<Base> evaluated = fpe.evaluate(null, sd, sd, ed, node);

          if (!evaluated.isEmpty())
            constantV = evaluated.get(0).primitiveValue();
        }
        catch (Exception e) {
          debug("Failed to evaluate constant expression: " + constantV);
        }
      }

      translatedShEx += positionParts(innerShEx, quoteThis(constantV, toQt),
        getNextOps(ops , processExpressionNode(sd, ed, node.getOpNext(), toQuote, depth), endOps, treatBothOpsSame),
        depth, false);
      //translatedShEx += positionParts(innerShEx, node.getConstant().primitiveValue(), ops + processExpressionNode(node.getOpNext(), toQuote, 0) + endOps, depth);
    } else if (kind == ExpressionNode.Kind.Unary) {
      translatedShEx += positionParts(innerShEx, node.getName(),
        getNextOps(ops,processExpressionNode(sd, ed, node.getOpNext(), toQuote, depth), endOps, treatBothOpsSame),
        depth, false);
    } else {
      translatedShEx += positionParts(innerShEx, node.toString(),
        getNextOps(ops, processExpressionNode(sd, ed, node.getOpNext(), toQuote, depth), endOps, treatBothOpsSame),
        depth, false);
    }

    return translatedShEx;
  }

  private String commentUnmapped(String text) {

    String pre = "";
    String token = "NNNNN";
    String temp = text;
    if ((text != null)&&(text.indexOf("SHEX_") != -1)) {
      pre = "\n# This constraint does not have mapping to a ShEx construct yet.";
      temp = text.replaceAll("\n", token);
      while (temp.indexOf("SHEX_") != -1) {
        pre += "\n# Unmapped construct found: " + StringUtils.substringBetween(temp, "SHEX_", "_SHEX");
        temp = temp.replaceFirst("SHEX_", " ").replaceFirst("_SHEX", " ");
      }

      pre += "\n# ";
    }

    if (temp.indexOf(token) != -1) {
      temp = "#" + temp;
      temp = temp.replaceAll(token, "\n#");
      temp = temp.replaceAll("##", "#");
      temp = temp.replaceAll("# #", "#");
      temp = temp.replaceAll("# #", "#");
      temp += "\n{}";
    }

    return pre + temp;
  }

  private String addUnmappedFunction(String func) {
    String toStore = "UNMAPPED_FUNCTION_" + func;
    if (!unMappedFunctions.contains(toStore))
      unMappedFunctions.add(toStore);

    return toStore;
  }

  private String getNextOps(String startOp, String opNext, String endOp, boolean treatBothOps){
    if (treatBothOps)
      return startOp + opNext + " " + endOp + opNext;

    return startOp + opNext + endOp;
  }

  private String positionParts(String funCall, String mainTxt, String nextText, int depth, boolean complete){
    if (funCall.indexOf("CALLER") != -1) {
      if (depth == 0) {
        String toReturn = funCall.replaceFirst("CALLER", mainTxt);
        if (complete)
          toReturn =  toReturn ;

        toReturn = postProcessing(toReturn, nextText);
        return toReturn.replaceAll("CALLER", "");
      }
      else{
        String mT = (mainTxt != null) ? mainTxt.trim() : "";
        String dR = (mT.startsWith(".") || mT.startsWith("{") || mT.startsWith("[")) ? "" : ".";
        return  postProcessing(funCall.replaceFirst("CALLER", Matcher.quoteReplacement("CALLER" + dR + mT )), nextText) ;
      }
    }

    String fc = funCall;
    if (fc.startsWith("fhir:"))
      fc = "." + fc.substring("fhir:".length());

    if ((depth == 0)&&(complete)) {
      if (mainTxt.startsWith("fhir:")) {
        if ("".equals(funCall)) {
          return "{ " + postProcessing(mainTxt, nextText) + " }";
        }

        if ((fc!= null)&&(!fc.isEmpty())) {
          String fT = fc.trim();
          String dR = (fT.startsWith(".") || fT.startsWith("{") || fT.startsWith("[")) ? "" : ".";
          fc = dR + fc;
        }

        return "{" + postProcessing(mainTxt + fc, nextText) + "}";
      }

      if (mainTxt.startsWith("'"))
          mainTxt = mainTxt;
      else
          mainTxt = "(" + mainTxt + ")";

      if ("".equals(funCall)) {
        return postProcessing(mainTxt, nextText);
      }
    }

    if ((fc!= null)&&(!fc.isEmpty())) {
      String fT = fc.trim();
      String dR = (fT.startsWith(".") || fT.startsWith("{") || fT.startsWith("[")) ? "" : ".";
      fc = dR + fc;
    }
    return postProcessing(mainTxt + fc,  nextText);
  }

  private String postProcessing(String p, String q){
    String qp = q;
    if ((q != null)&&(q.trim().startsWith("XOR"))){
      qp = q.split("XOR")[1];

      // because p xor q = ( p and not q) OR (not p and q)
      //return "(" + p + " AND NOT " + qp + ") OR ( NOT " + p + " AND " + qp + ")";
      return "{" + p + "} AND NOT {" + qp + "} OR { NOT {" + p + "} AND " + qp + "} ";
    }

    return p + qp;
  }

  /**
   * @param str
   * @return
   */
  private String TBD(String str){
    return " SHEX_" + str + "_SHEX ";
  }

  /**
   * @param str
   * @param quote
   * @return
   */
  private String quoteThis(String str, boolean quote){

    if (quote)
      return "'" + str + "'";

    return str;
  }

  /**
   * Generate a flattened definition for the inner types
   * @return stringified inner type definitions
   */
  private String emitInnerTypes() {
    StringBuilder itDefs = new StringBuilder();
    while(emittedInnerTypes.size() < innerTypes.size()) {
      for (Pair<StructureDefinition, ElementDefinition> it : new HashSet<Pair<StructureDefinition, ElementDefinition>>(innerTypes)) {
        if ((!emittedInnerTypes.contains(it))
          // && (it.getRight().hasBase() && it.getRight().getBase().getPath().startsWith(it.getLeft().getName()))
        ){
          itDefs.append("\n").append(genInnerTypeDef(it.getLeft(), it.getRight()));
          emittedInnerTypes.add(it);
        }
      }
    }
    return itDefs.toString();
  }

  /**
   * @param ed
   * @return
   */
  private boolean  isInInnerTypes(ElementDefinition ed) {

    if (this.innerTypes.isEmpty())
      return false;

    for (Iterator<Pair<StructureDefinition, ElementDefinition>> itr = this.innerTypes.iterator(); itr.hasNext(); )
      if (itr.next().getRight() == ed)
        return true;

    return false;
  }

  /**
   * Generate a shape definition for the current set of datatypes
   * @return stringified data type definitions
   */
  private String emitDataTypes() {
    StringBuilder dtDefs = new StringBuilder();
    while (emittedDatatypes.size() < datatypes.size()) {
      for (String dt : new HashSet<String>(datatypes)) {
        if (!emittedDatatypes.contains(dt)) {
          StructureDefinition sd = context.fetchResource(StructureDefinition.class,
            ProfileUtilities.sdNs(dt, null));
          // TODO: Figure out why the line below doesn't work
          // if (sd != null && !uniq_structures.contains(sd))
          if(sd != null && !uniq_structure_urls.contains(sd.getUrl()))
            dtDefs.append("\n").append(genShapeDefinition(sd, false));
          emittedDatatypes.add(dt);
        }
      }
    }
    return dtDefs.toString();
  }

  /**
   * @param text
   * @param max_col
   * @return
   */
  private ArrayList<String> split_text(String text, int max_col) {
    int pos = 0;
    ArrayList<String> rval = new ArrayList<String>();
    if (text.length() <= max_col) {
      rval.add(text);
    } else {
      String[] words = text.split(" ");
      int word_idx = 0;
      while(word_idx < words.length) {
        StringBuilder accum = new StringBuilder();
        while (word_idx < words.length && accum.length() + words[word_idx].length() < max_col)
          accum.append(words[word_idx++] + " ");
        if (accum.length() == 0) {
          accum.append(words[word_idx].substring(0, max_col - 3) + "-");
          words[word_idx] = words[word_idx].substring(max_col - 3);
        }
        rval.add(accum.toString());
        accum = new StringBuilder();
      }
    }
    return rval;
  }

  /**
   * @param tmplt
   * @param ed
   */
  private void addComment(ST tmplt, ElementDefinition ed) {
    if(withComments && ed.hasShort() && !ed.getId().startsWith("Extension.")) {
      int nspaces;
      char[] sep;
      nspaces = Integer.max(COMMENT_COL - tmplt.add("comment", "#").render().indexOf('#'), MIN_COMMENT_SEP);
      tmplt.remove("comment");
      sep = new char[nspaces];
      Arrays.fill(sep, ' ');
      ArrayList<String> comment_lines = split_text(ed.getShort().replace("\n", " "), MAX_CHARS);
      StringBuilder comment = new StringBuilder("# ");
      char[] indent = new char[COMMENT_COL];
      Arrays.fill(indent, ' ');
      for(int i = 0; i < comment_lines.size();) {
        comment.append(comment_lines.get(i++));
        if(i < comment_lines.size())
          comment.append("\n" + new String(indent) + "# ");
      }
      tmplt.add("comment", new String(sep) + comment.toString());
    } else {
      tmplt.add("comment", " ");
    }
  }


  /**
   * Generate a ShEx element definition
   * @param sd Containing structure definition
   * @param ed Containing element definition
   * @return ShEx definition
   */
  private String genElementDefinition(StructureDefinition sd,
                                      ElementDefinition ed) {
    String id = ed.hasBase() ? ed.getBase().getPath() : ed.getPath();

    String shortId = id;
    String typ = id;

    if (ed.getType().size() > 0)
      typ = ed.getType().get(0).getCode();

    if (id.equals("Element.extension") && ed.hasSliceName()) {
      shortId = ed.getSliceName();
    }
    else
      shortId = id.substring(id.lastIndexOf(".") + 1);

    if ((ed.getType().size() > 0) &&
      (ed.getType().get(0).getCode().startsWith(Constants.NS_SYSTEM_TYPE))) {

      if (changeShortName(sd, ed)) {
        debug("VALUE NAME CHANGED to v from " + shortId + " for " + sd.getName() + ":" + ed.getPath());
        shortId = "v";
      }

      typ = ed.getType().get(0).getWorkingCode();
    }

    String defn = "";
    ST element_def;
    String card = ("*".equals(ed.getMax()) ? (ed.getMin() == 0 ? "*" : "+") : (ed.getMin() == 0 ? "?" : "")) + ";";

    element_def = tmplt(ELEMENT_TEMPLATE);
    if (id.endsWith("[x]")) {
      element_def.add("id", "fhir:" + shortId.replace("[x]", ""));
    } else {
      element_def.add("id", "fhir:" + shortId + " ");
    }

    List<ElementDefinition> children = profileUtilities.getChildList(sd, ed);
    if (children.size() > 0) {
      String parentPath = sd.getName();
      if ((ed.hasContentReference() && (!ed.hasType())) || (!id.equals(parentPath + "." + shortId))) {
        //debug("Not Adding innerType:" + id + " to " + sd.getName());
      } else
        innerTypes.add(new ImmutablePair<StructureDefinition, ElementDefinition>(sd, ed));
    }

    if ("BackboneElement".equals(typ))
      typ = id;

    defn = simpleElement(sd, ed, typ);

    String refChoices = "";

    if (id.endsWith("[x]")) {
      //defn = " (" + genChoiceTypes(sd, ed, shortId) + ")";
      defn = " " + genChoiceTypes(sd, ed, shortId) + " ";
      //defn += " AND { rdf:type IRI } ";
    } else {
      if (ed.getType().size() == 1) {
        // Single entry
        if ((defn.isEmpty())||(typ.equals(sd.getName())))
          defn = genTypeRef(sd, ed, id, ed.getType().get(0));
      } else if (ed.getContentReference() != null) {
        // Reference to another element
        String ref = ed.getContentReference();
        if (!ref.startsWith("#"))
          throw new AssertionError("Not equipped to deal with absolute path references: " + ref);
        String refPath = null;
        for (ElementDefinition ed1 : sd.getSnapshot().getElement()) {
          if (ed1.getId() != null && ed1.getId().equals(ref.substring(1))) {
            refPath = ed1.getPath();
            break;
          }
        }
        if (refPath == null)
          throw new AssertionError("Reference path not found: " + ref);

        defn = simpleElement(sd, ed, refPath);
      }


      List<String> refValues = new ArrayList<String>();
      if (ed.hasType() && (ed.getType().get(0).getWorkingCode().equals("Reference"))) {
        if (ed.getType().get(0).hasTargetProfile()) {

          ed.getType().get(0).getTargetProfile().forEach((CanonicalType tps) -> {
            String els[] = tps.getValue().split("/");
            refValues.add(els[els.length - 1]);
          });
        }
      }

      if (!refValues.isEmpty()) {
        Collections.sort(refValues);
        refChoices = StringUtils.join(refValues, "_OR_");
      }
    }

    // Adding OneOrMore as prefix to the reference type if cardinality is 1..* or 0..*
    if (card.startsWith("*") || card.startsWith("+")) {
      card = card.replace("+", "");
      card = card.replace("*", "?");
      defn = defn.replace("<", "<" + ONE_OR_MORE_PREFIX);

      String defnToStore = defn;
      if (!refChoices.isEmpty()) {
        defnToStore = defn.replace(">", ONE_OR_MORE_CHOICES + refChoices + ">");
        defn = defn.replace(">", "_" + refChoices + ">");
      }

      defnToStore = StringUtils.substringBetween(defnToStore, "<", ">");
      if (!oneOrMoreTypes.contains(defnToStore))
        oneOrMoreTypes.add(defnToStore);
    } else {
      if (!refChoices.isEmpty()) {
        defn += " AND {fhir:link \n\t\t\t@<" +
          refChoices.replaceAll("_OR_", "> OR \n\t\t\t@<") + "> ? }";
      }
    }

    element_def.add("defn", defn);
    addImport(defn);
    element_def.add("card", card);
    addComment(element_def, ed);

    return element_def.render();
  }

  private boolean changeShortName(StructureDefinition sd, ElementDefinition ed){
      return shortIdException.contains(sd.getName());
  }

  private void addImport(String typeDefn) {
      if ((typeDefn != null) && (!typeDefn.isEmpty())) {
  //        String importType = StringUtils.substringBetween(typeDefn, "<", ">");
  //        if ((importType.indexOf(ONE_OR_MORE_PREFIX) == -1) &&
  //          (!imports.contains(importType)))
  //            imports.add(importType);
  //    }
        Pattern p = Pattern.compile("<([^\\s>/]+)");
        Matcher m = p.matcher(typeDefn);
        while (m.find()) {
          String tag = m.group(1);
          //System.out.println("FOUND IMPORT: " + tag);
          if (tag.indexOf(ONE_OR_MORE_PREFIX) != -1) {
            tag = tag.substring(ONE_OR_MORE_PREFIX.length());
          }

          if ((tag.indexOf("_") != -1)||(tag.indexOf("_OR_") != -1))
            continue;

           if (!imports.contains(tag))
            imports.add(tag);
        }
      }
  }
  private List<ElementDefinition> getChildren(StructureDefinition derived, ElementDefinition element) {
    List<ElementDefinition> elements = derived.getSnapshot().getElement();
    int index = elements.indexOf(element) + 1;
    String path = element.getPath()+".";
    List<ElementDefinition> list = new ArrayList<>();
    while (index < elements.size()) {
      ElementDefinition e = elements.get(index);
      String p = e.getPath();
      if (p.startsWith(path) && !e.hasSliceName()) {
        if (!p.substring(path.length()).contains(".")) {
          list.add(e);
        }
        index++;
      } else  {
        break;
      }
    }
    return list;
  }

  /**
   * Generate a type reference and optional value set definition
   * @param sd Containing StructureDefinition
   * @param ed Element being defined
   * @param typ Element type
   * @return Type definition
   */
  private String simpleElement(StructureDefinition sd, ElementDefinition ed, String typ) {
    String addldef = "";
    ElementDefinition.ElementDefinitionBindingComponent binding = ed.getBinding();
    if(binding.hasStrength() && binding.getStrength() == Enumerations.BindingStrength.REQUIRED && "code".equals(typ)) {
      ValueSet vs = resolveBindingReference(sd, binding.getValueSet());
      if (vs != null) {
        addldef = tmplt(VALUESET_DEFN_TEMPLATE).add("vsn", vsprefix(vs.getUrl())).render();
        required_value_sets.add(vs);
      }
    }
    // TODO: check whether value sets and fixed are mutually exclusive
    if(ed.hasFixed()) {
      addldef = tmplt(FIXED_VALUE_TEMPLATE).add("val", ed.getFixed().primitiveValue()).render();
    }
    return tmplt(SIMPLE_ELEMENT_DEFN_TEMPLATE).add("typ", typ).add("vsdef", addldef).render();
  }

  private String vsprefix(String uri) {
    if(uri.startsWith(FHIR_VS))
      return "fhirvs:" + uri.replace(FHIR_VS, "");
    return "<" + uri + ">";
  }

  /**
   * Generate a type reference
   * @param sd Containing structure definition
   * @param ed Containing element definition
   * @param id Element id
   * @param typ Element type
   * @return Type reference string
   */
  private String genTypeRef(StructureDefinition sd, ElementDefinition ed, String id, ElementDefinition.TypeRefComponent typ) {

    if(typ.hasProfile()) {
      if(typ.getWorkingCode().equals("Reference"))
        return genReference("", typ);
      else if(profileUtilities.getChildList(sd, ed).size() > 0) {
        // inline anonymous type - give it a name and factor it out
        innerTypes.add(new ImmutablePair<StructureDefinition, ElementDefinition>(sd, ed));
        return simpleElement(sd, ed, id);
      }
      else {
        String ref = getTypeName(typ);
        datatypes.add(ref);
        return simpleElement(sd, ed, ref);
      }

    } else if (typ.getCode().startsWith(Constants.NS_SYSTEM_TYPE)) {
      String xt = getShexCode(typ.getWorkingCode());

      // TODO: Remove the next line when the type of token gets switched to string
      // TODO: Add a rdf-type entry for valueInteger to xsd:integer (instead of int)
      ST td_entry = tmplt(PRIMITIVE_ELEMENT_DEFN_TEMPLATE).add("typ", xt);
      StringBuilder facets =  new StringBuilder();
      if(ed.hasMinValue()) {
        DataType mv = ed.getMinValue();
        facets.append(tmplt(MINVALUE_TEMPLATE).add("val", mv.primitiveValue()).render());
      }
      if(ed.hasMaxValue()) {
        DataType mv = ed.getMaxValue();
        facets.append(tmplt(MAXVALUE_TEMPLATE).add("val", mv.primitiveValue()).render());
      }
      if(ed.hasMaxLength()) {
        int ml = ed.getMaxLength();
        facets.append(tmplt(MAXLENGTH_TEMPLATE).add("val", ml).render());
      }
      if(ed.hasPattern()) {
        DataType pat = ed.getPattern();
        facets.append(tmplt(PATTERN_TEMPLATE).add("val",pat.primitiveValue()).render());
      }
      td_entry.add("facets", facets.toString());
      return td_entry.render();

    } else if (typ.getWorkingCode() == null) {
      ST primitive_entry = tmplt(PRIMITIVE_ELEMENT_DEFN_TEMPLATE);
      primitive_entry.add("typ", "xsd:string");
      return primitive_entry.render();

    } else if(typ.getWorkingCode().equals("xhtml")) {
      return tmplt(XHTML_TYPE_TEMPLATE).render();
    } else {
      datatypes.add(typ.getWorkingCode());
      return simpleElement(sd, ed, typ.getWorkingCode());
    }
  }

  /**
   * @param c
   * @return
   */
  private String getShexCode(String c) {
    switch (c) {
      case "boolean" :
        return "xsd:boolean";
      case "integer" :
        return "xsd:int";
      case "integer64" :
        return "xsd:long";
      case "decimal" :
        return "xsd:decimal OR xsd:double";
      case "base64Binary" :
        return "xsd:base64Binary";
      case "instant" :
        return "xsd:dateTime";
      case "string" :
        return "xsd:string";
      case "uri" :
        return "xsd:anyURI";
      case "date" :
        return "xsd:gYear OR xsd:gYearMonth OR xsd:date";
      case "dateTime" :
        return "xsd:gYear OR xsd:gYearMonth OR xsd:date OR xsd:dateTime";
      case "time" :
        return "xsd:time";
      case "code" :
        return "xsd:token";
      case "oid" :
        return "xsd:anyURI";
      case "uuid" :
        return "xsd:anyURI";
      case "url" :
        return "xsd:anyURI";
      case "canonical" :
        return "xsd:anyURI";
      case "id" :
        return "xsd:string";
      case "unsignedInt" :
        return "xsd:nonNegativeInteger";
      case "positiveInt" :
        return "xsd:positiveInteger";
      case "markdown" :
        return "xsd:string";
    }
    throw new Error("Not implemented yet");

  }

  /**
   * Generate a set of alternative shapes
   * @param ed Containing element definition
   * @param id Element definition identifier
   * @param shortId id to use in the actual definition
   * @return ShEx list of alternative anonymous shapes separated by "OR"
   */
  private ST genAlternativeTypes(ElementDefinition ed, String id, String shortId) {
    ST shex_alt = tmplt(ALTERNATIVE_SHAPES_TEMPLATE);
    List<String> altEntries = new ArrayList<String>();


    for(ElementDefinition.TypeRefComponent typ : ed.getType())  {
      altEntries.add(genAltEntry(id, typ));
    }
    shex_alt.add("altEntries", StringUtils.join(altEntries, " OR \n    "));
    return shex_alt;
  }



  /**
   * Generate an alternative shape for a reference
   * @param id reference name
   * @param typ shape type
   * @return ShEx equivalent
   */
  private String genAltEntry(String id, ElementDefinition.TypeRefComponent typ) {
    if(!typ.getWorkingCode().equals("Reference"))
      throw new AssertionError("We do not handle " + typ.getWorkingCode() + " alternatives");

    return genReference(id, typ);
  }

  /**
   * Generate a list of type choices for a "name[x]" style id
   * @param sd Structure containing ed
   * @param ed element definition
   * @param id choice identifier
   * @return ShEx fragment for the set of choices
   */
  private String genChoiceTypes(StructureDefinition sd,
                                ElementDefinition ed,
                                String id) {
    List<String> choiceEntries = new ArrayList<String>();
    List<String> refValues = new ArrayList<String>();
    String base = id.replace("[x]", "");

    for (ElementDefinition.TypeRefComponent typ : ed.getType()) {
      String entry = genChoiceEntry(sd, ed, base, typ);
      refValues.clear();
      if (typ.hasTargetProfile()) {
        typ.getTargetProfile().forEach((CanonicalType tps) -> {
          String els[] = tps.getValue().split("/");
          refValues.add("@<" + els[els.length - 1] + ">");
        });
      }

      if (!refValues.isEmpty())
        choiceEntries.add("(" + entry + " AND {fhir:link " + StringUtils.join(refValues, " OR \n\t\t\t ") + " }) ");
      else
        choiceEntries.add(entry);
    }
    return StringUtils.join(choiceEntries, " OR \n\t\t\t");
  }

  /**
   * Generate an entry in a choice list
   * @param id base identifier
   * @param typ type/discriminant
   * @return ShEx fragment for choice entry
   */
  private String genChoiceEntry(StructureDefinition sd,
                                ElementDefinition ed,
                                String id,
                                ElementDefinition.TypeRefComponent typ) {
    ST shex_choice_entry = tmplt(ELEMENT_TEMPLATE);

    String ext = typ.getWorkingCode();
    // shex_choice_entry.add("id", "fhir:" + base+Character.toUpperCase(ext.charAt(0)) + ext.substring(1) + " ");
    shex_choice_entry.add("id", "");
    shex_choice_entry.add("card", "");
    String typeDefn = genTypeRef(sd, ed, id, typ);
    shex_choice_entry.add("defn", typeDefn);
    addImport(typeDefn);
    shex_choice_entry.add("comment", " ");
    return shex_choice_entry.render();
  }

  /**
   * @param oneOrMoreType
   * @return
   */
  private String getOneOrMoreType(String oneOrMoreType) {
    if ((oneOrMoreType == null)||(oneOrMoreTypes.isEmpty()))
      return "";

    ST one_or_more_type = tmplt(ONE_OR_MORE_TEMPLATE);
    String oomType = oneOrMoreType;
    String origType = oneOrMoreType;
    String restriction = "";
    if (oneOrMoreType.indexOf(ONE_OR_MORE_CHOICES) != -1) {
      oomType = oneOrMoreType.replaceAll(ONE_OR_MORE_CHOICES, "_");
      origType = oneOrMoreType.split(ONE_OR_MORE_CHOICES)[0];
      restriction = "AND {fhir:link \n\t\t\t@<";

      String choices = oneOrMoreType.split(ONE_OR_MORE_CHOICES)[1];
      restriction += choices.replaceAll("_OR_", "> OR \n\t\t\t@<") + "> }";
    }

    origType = origType.replaceAll(ONE_OR_MORE_PREFIX, "");

    one_or_more_type.add("oomType", oomType);
    one_or_more_type.add("origType", origType);
    one_or_more_type.add("restriction", restriction);
    addImport(origType);
    addImport(restriction);
    one_or_more_type.add("comment", "");
    return one_or_more_type.render();
  }

  /**
   * Generate a definition for a referenced element
   * @param sd Containing structure definition
   * @param ed Inner element
   * @return ShEx representation of element reference
   */
  private String genInnerTypeDef(StructureDefinition sd, ElementDefinition ed) {
    String path = ed.hasBase() ? ed.getBase().getPath() : ed.getPath();
    ST element_reference = tmplt(SHAPE_DEFINITION_TEMPLATE);
    element_reference.add("resourceDecl", "");  // Not a resource
    element_reference.add("id", path + getExtendedType(ed));
    element_reference.add("fhirType", " ");
    String comment = ed.getShort();
    element_reference.add("comment", comment == null? " " : "# " + comment);

    List<String> elements = new ArrayList<String>();
    for (ElementDefinition child: profileUtilities.getChildList(sd, path, null))
      if (child.hasBase() && child.getBase().getPath().startsWith(sd.getName())) {
        String elementDefinition = genElementDefinition(sd, child);
        elements.add(elementDefinition);
      }

    element_reference.add("elements", StringUtils.join(elements, "\n"));

    List<String> innerConstraintsList = new ArrayList<String>();

    if (processConstraints) {
      // Process constraints
      for (ElementDefinition.ElementDefinitionConstraintComponent constraint : ed.getConstraint()) {
        String sdType = sd.getType();
        String cstype = constraint.getSource();
        if ((cstype != null) && (cstype.indexOf("/") != -1)) {
          String[] els = cstype.split("/");
          cstype = els[els.length - 1];
        }

        String id = ed.hasBase() ? ed.getBase().getPath() : ed.getPath();
        String shortId = id.substring(id.lastIndexOf(".") + 1);
        if ((ed.hasContentReference() && (!ed.hasType())) || (id.equals(sd.getName() + "." + shortId))) {
          if ((sdType.equals(cstype)) || baseDataTypes.contains(sdType)) {
            //if (!isInInnerTypes(ed)) {
            debug("\n        (INNER ED) Key: " + constraint.getKey() + " SD type: " + sd.getType() + " Element: " + ed.getPath() + " Constraint Source: " + constraint.getSource() + " Constraint:" + constraint.getExpression());
            String transl = translateConstraint(sd, ed, constraint);
            if (transl.isEmpty() || innerConstraintsList.contains(transl))
              continue;
            innerConstraintsList.add(transl);
            //}
          }
        }
      }
    }

    String constraintStr = "";

    if (!innerConstraintsList.isEmpty()) {
      constraintStr = "AND (\n\n" + StringUtils.join(constraintsList, "\n\n) AND (\n\n") + "\n\n)\n";
    }

    element_reference.add("constraints", constraintStr);

    // TODO: See if we need to process contexts
    element_reference.add("contextOfUse", "");

    return element_reference.render();
  }

  /**
   * Generate a reference to a resource
   * @param id attribute identifier
   * @param typ possible reference types
   * @return string that represents the result
   */
  private String genReference(String id, ElementDefinition.TypeRefComponent typ) {
    ST shex_ref = tmplt(REFERENCE_DEFN_TEMPLATE);

    String ref = getTypeName(typ);
    shex_ref.add("id", id);
    shex_ref.add("ref", ref);
    references.add(ref);
    return shex_ref.render();
  }

  /**
   * Return the type name for typ
   * @param typ type to get name for
   * @return name
   */
  private String getTypeName(ElementDefinition.TypeRefComponent typ) {
    // TODO: This is brittle. There has to be a utility to do this...
    if (typ.hasTargetProfile()) {
      String[] els = typ.getTargetProfile().get(0).getValue().split("/");
      return els[els.length - 1];
    } else if (typ.hasProfile()) {
      String[] els = typ.getProfile().get(0).getValue().split("/");
      return els[els.length - 1];
    } else {
      return typ.getWorkingCode();
    }
  }

  /**
   * @param vs
   * @return
   */
  private String genValueSet(ValueSet vs) {
    ST vsd = tmplt(VALUE_SET_DEFINITION).add("vsuri", vsprefix(vs.getUrl())).add("comment", vs.getDescription());
    ValueSetExpander.ValueSetExpansionOutcome vse = context.expandVS(vs, true, false);
    List<String> valid_codes = new ArrayList<String>();
    if(vse != null &&
      vse.getValueset() != null &&
      vse.getValueset().hasExpansion() &&
      vse.getValueset().getExpansion().hasContains()) {
      for(ValueSet.ValueSetExpansionContainsComponent vsec : vse.getValueset().getExpansion().getContains())
        valid_codes.add("\"" + vsec.getCode() + "\"");
    }
    return vsd.add("val_list", valid_codes.size() > 0? " [" + StringUtils.join(valid_codes, " ") + ']' : " xsd:string #EXTERNAL").render();
  }


  /**
   * @param ctxt
   * @param reference
   * @return
   */
  // TODO: find a utility that implements this
  private ValueSet resolveBindingReference(DomainResource ctxt, String reference) {
    try {
      return context.fetchResource(ValueSet.class, reference);
    } catch (Throwable e) {
      return null;
    }
  }

  private void debug(String message) {
    if (this.debugMode)
      System.out.println(message);
  }

  private void printBuildMessage(String message){
    System.out.println("ShExGenerator: " + message);
  }
}