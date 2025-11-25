package org.hl7.fhir.r5.utils;

// other than render_src_package, all these are intended to be made consistent in format, using
// the standard format scope-name-name where scope is one of 
//  lib - core library (most of them)
//  validator - validator CLI or web functionality
//  pub - IG publisher functionality
//  kindling - kindling related functionality 

public class UserDataNames {
  public static final String loader_urls_patched = "old.load.mode";
  public static final String loader_custom_resource = "loader-custom-resource";

  public static final String SNAPSHOT_BASE_MODEL = "base.model";
  public static final String SNAPSHOT_BASE_PATH = "base.path";
  public static final String SNAPSHOT_DERIVATION_EQUALS = "derivation.equals";
  public static final String SNAPSHOT_DERIVATION_POINTER = "derived.pointer";
  public static final String SNAPSHOT_IS_DERIVED = "derived.fact";
  public static final String SNAPSHOT_GENERATED_IN_SNAPSHOT = "profileutilities.snapshot.processed";
  public static final String SNAPSHOT_DERIVATION_DIFF = "profileutilities.snapshot.diffsource";
  public static final String SNAPSHOT_GENERATED_MESSAGES = "profileutils.snapshot.generated.messages";
  public static final String SNAPSHOT_ERRORS = "profileutils.snapshot.errors";
  public static final String SNAPSHOT_DETAILS = "profileutils.snapshot.details";
  public static final String SNAPSHOT_auto_added_slicing = "auto-added-slicing";
  public static final String SNAPSHOT_messages = "profileutils.snapshot.messages";
  public static final String SNAPSHOT_slice_name = "slice-name";
  public static final String SNAPSHOT_SORT_ed_index = "ed.index";
  public static final String SNAPSHOT_diff_source = "diff-source";
  public static final String SNAPSHOT_regeneration_tracker = "hack.regnerated";
  
  public static final String LANGUTILS_ORPHAN = "translations.orphans";
  public static final String LANGUTILS_SOURCE_SUPPLEMENT = "translations.supplemented";
  public static final String LANGUTILS_SOURCE_TRANSLATIONS = "translations.source-list";
  
  public static final String rendering_xml_decorations = "fhir_decorations";
  public static final String render_extension_slice = "slice";
  public static final String render_opaque = "render.opaque";
  public static final String render_tx_value = "tx.value";
  public static final String render_tx_pattern = "tx.pattern";
  public static final String render_link = "render.link";
  public static final String render_external_link = "External.Link";
  public static final String render_dict_generator_anchors = "dict.generator.anchors";
  public static final String render_presentation = "presentation";
  public static final String render_src_package = "package"; // <--- this value is reused by HAPI and can't change without consultation
  public static final String renderer_is_generated = "renderer.generated";

  public static final String keyview_elementSupported = "elementSupported";
  public static final String keyview_hasFixed = "hasFixed";
  public static final String keyview_usesMustSupport = "usesMustSupport";
  
  public static final String LAYOUT_SvgLeft = "SvgLeft";
  public static final String LAYOUT_SvgTop = "SvgTop";
  public static final String LAYOUT_SvgWidth = "SvgWidth";
  public static final String LAYOUT_UmlBreak = "UmlBreak";
  public static final String LAYOUT_UmlDir = "UmlDir";

  public static final String questionnaire_object = "object";
  public static final String questionnaire_text = "text";
  public static final String mappings_inherited = "private-marked-as-derived";
  
  @Deprecated
  public static final String deprecated_committee = "committee";
  @Deprecated
  public static final String render_filename = "filename";
  public static final String render_webroot = "webroot";
  
  public static final String comparison_match = "match";
  public static final String COMP_VERSION_ANNOTATION = "version-annotation";
  public static final String COMP_CONTEXT = "ctxt"; //!

  public static final String tx_status_msg_name = "status-msg-name";
  public static final String tx_status_msg_value = "status-msg-value";
  public static final String tx_val_sys_error = "val.sys.error";
  public static final String tx_cs_special = "tx.cs.special";
  public static final String TX_ASSOCIATED_CODESYSTEM = "cs";
  public static final String tx_cs_version_notes = "cs.version.notes";
  public static final String tx_known_supplements = "supplements.installed";

  public static final String validator_bundle_resolution = "validator.bundle.resolution";
  public static final String validator_bundle_resolved = "validator.bundle.resolved";
  public static final String validator_expression_cache = "validator.expression.cache";
  public static final String validator_slice_expression_cache = "slice.expression.cache";
  public static final String validator_entry_map = "validator.entrymap";
  public static final String validator_entry_map_reverse = "validator.entrymapR";
  public static final String validation_bundle_error = "bundle.error.noted";
  
  public static final String map_profile = "profile";
  public static final String map_validated = "structuremap.validated";
  public static final String map_parameters = "structuremap.parameters";
  public static final String map_source = "element.source";
  public static final String MAP_slice_name = "map-slice-name";
  
  public static final String Storage_key = "Storage.key";
  public static final String db_key = "db.key";
  public static final String db_columns = "columns";
  public static final String db_column = "column";
  public static final String db_forEach = "forEach";
  public static final String db_forEachOrNull = "forEachOrNull";
  public static final String db_path = "path"; 
  public static final String db_name = "name"; 
  public static final String db_value = "value"; 
  
  public static final String xver_rows = "rows";
  public static final String xver_links = "links";
  public static final String xver_sed = "sed";
  public static final String xver_desc = "desc";
  public static final String xver_cm_used = "cm.used";
  public static final String xver_sliceName = "sliceName";
  public static final String xver_delete = "delete";
  public static final String xver_abstract = "abstract";
  public static final String xver_expression = "expression";


  public static final String java_code = "java.code";
  
  public static final String validator_source_msg = "source.msg";
  public static final String validator_source_vm = "source.vm";
  public static final String validator_contained_Id = "val.contained.id.session";

  
  public static final String PUB_CS_CONVERTED = "conv-vs";
  public static final String pub_xref_used = "xref.used";
  public static final String pub_xref_sources = "xref.sources";
  public static final String pub_resource_config = "config";
  public static final String pub_excel_inv_context = "context";
  public static final String pub_excel_sheet_id = "id";
  public static final String pub_element = "element";
  public static final String pub_loaded_resource = "loaded.resource";
  public static final String pub_source_filename = "source.filename";
  public static final String pub_imposes_compare_id = "imposes.compare.id";
  public static final String pub_analysis = "analysis";
  public static final String pub_logical = "logical";
  public static final String pub_context_file = "igpub.context.file";
  public static final String pub_context_resource = "igpub.context.resource";
  public static final String pub_no_load_deps = "no-load-deps";

  public static final String archetypeSource = "archetype-source";
  public static final String archetypeName = "archetype-name";
  public static final String VS_EXPANSION_SOURCE = "VS_EXPANSION_SOURCE";
  public static final String auto_added_parameter = "auto_added_parameter";
  public static final String SNAPSHOT_PREPROCESS_INJECTED = "SNAPSHOT_PREPROCESS_INJECTED";
  public static final String renderer_title = "renderer_title";
  public static final String matchingParameter = "matchingParameter";
  public static final String SNAPSHOT_SOURCE = "SNAPSHOT_SOURCE";
  public static final String SvgLeft = "SvgLeft";
  public static final String SvgTop = "SvgTop";
  public static final String UmlDir = "UmlDir";
  public static final String SNAPSHOT_FROM_DIFF = "SNAPSHOT_FROM_DIFF";
  public static final String SNAPSHOT_EXTENSION_SOURCE = "SNAPSHOT_EXTENSION_SOURCE";
  public static final String IG_FAKE = "IG_FAKE";
  public static final String DN_TRANSIENT = "DN_TRANSIENT";
  public static final String JGEN_ALL_PRIMITIVE = "JGEN_ALL_PRIMITIVE";
  public static final String IG_DEP_ALIASED = "IG_DEP_ALIASED";
  public static final String CS_MARKDOWN_FLAG = "CS_MARKDOWN_FLAG";
  public static final String PROFILE_RENDERED_MAPPINGS = "PROFILE_RENDERED_MAPPINGS";
  public static final String EXP_REVIEWED = "EXP_REVIEWED";

  public static final String RESOURCE_INTERNAL_USE_ONLY = "RESOURCE_INTERNAL_USE_ONLY";
  public static final String VERSION_PINNED_ON_LOAD = "VERSION_PINNED_ON_LOAD";
}
