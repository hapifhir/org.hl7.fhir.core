package org.hl7.fhir.r5.renderers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.VersionComparisonAnnotation;
import org.hl7.fhir.r5.conformance.profile.BindingResolution;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.ElementChoiceGroup;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.ExtensionContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.ActorDefinition;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.AdditionalBindingPurposeVS;
import org.hl7.fhir.r5.model.ElementDefinition.AggregationMode;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.StructureDefinitionRenderer.InternalMarkdownProcessor;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.StructureDefinitionRendererMode;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.PublicationHacker;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableGenerationMode;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class StructureDefinitionRenderer extends ResourceRenderer {

  //  public class ObligationWrapper {
  //
  //    private Extension ext;
  //
  //    public ObligationWrapper(Extension ext) {
  //      this.ext = ext;
  //    }
  //
  //    public boolean hasActor() {
  //      return ext.hasExtension("actor");
  //    }
  //
  //    public boolean hasActor(String id) {
  //      return ext.hasExtension("actor") && id.equals(ext.getExtensionByUrl("actor").getValue().primitiveValue());
  //    }
  //
  //    public Coding getCode() {
  //      Extension code = ext.getExtensionByUrl("obligation");
  //      if (code != null && code.hasValueCoding()) {
  //        return code.getValueCoding();
  //      }
  //      if (code != null && code.hasValueCodeType()) {
  //        return new Coding().setSystem("http://hl7.org/fhir/tools/CodeSystem/obligation").setCode(code.getValueCodeType().primitiveValue());
  //      }
  //      return null;
  //    }
  //
  //    public boolean hasFilter() {
  //      return ext.hasExtension("filter");
  //    }
  //
  //    public String getFilter() {
  //      Extension code = ext.getExtensionByUrl("filter");
  //      if (code != null && code.getValue() != null) {
  //        return code.getValue().primitiveValue();
  //      }
  //      return null;
  //    }
  //
  //    public boolean hasUsage() {
  //      return ext.hasExtension("usage");
  //    }
  //
  //    public String getFilterDocumentation() {
  //      Extension code = ext.getExtensionByUrl("filter-desc");
  //      if (code != null && code.getValue() != null) {
  //        return code.getValue().primitiveValue();
  //      }
  //      return null;
  //    }
  //
  //    public List<UsageContext> getUsage() {
  //      List<UsageContext> usage = new ArrayList<>();
  //      for (Extension u : ext.getExtensionsByUrl("usage" )) {
  //        if (u.hasValueUsageContext()) {
  //          usage.add(u.getValueUsageContext());
  //        }
  //      }
  //      return usage;
  //    }
  //
  //  }

  public class InternalMarkdownProcessor implements IMarkdownProcessor {

    @Override
    public String processMarkdown(String location, PrimitiveType md) throws FHIRException {
      return context.getMarkdown().process(md.primitiveValue(), location);
    }

    @Override
    public String processMarkdown(String location, String text) throws FHIRException {
      return context.getMarkdown().process(text, location);
    }
  }

  private enum ListItemStatus { New, Unchanged, Removed};

  private abstract class ItemWithStatus {
    ListItemStatus status = ListItemStatus.New; // new, unchanged, removed    

    protected abstract void renderDetails(XhtmlNode f) throws IOException;
    protected abstract boolean matches(ItemWithStatus other);

    public void render(XhtmlNode x) throws IOException {
      XhtmlNode f = x;
      if (status == ListItemStatus.Unchanged) {
        f = unchanged(f);
      } else if (status == ListItemStatus.Removed) {
        f = removed(f);
      }
      renderDetails(f);
    }
  }

  protected class StatusList<T extends ItemWithStatus> extends ArrayList<T> implements List<T> {

    public boolean merge(T item) {
      if (item == null) {
        return false;
      }
      boolean found = false;
      for (T t : this) {
        if (t.matches(item)) {
          found = true;
          t.status = ListItemStatus.Unchanged;
        }
      }
      if (!found) {
        item.status = ListItemStatus.Removed;
        return add(item);        
      } else {
        return false;
      }
    }
    
    public boolean add(T item) {
      if (item != null) {
        return super.add(item);
      } else {
        return false;
      }
    }
  }

  private class ResolvedCanonical extends ItemWithStatus {
    String url; // what we used to resolve
    CanonicalResource cr; // what we resolved

    public ResolvedCanonical(String url, CanonicalResource cr) {
      this.url = url;
      this.cr = cr;
    }
    public void renderDetails(XhtmlNode f) {
      if (cr != null && cr.hasWebPath()) {
        f.ah(cr.getWebPath()).tx(cr.present());
      } else {
        f.code().tx(url);            
      }
    }
    protected boolean matches(ItemWithStatus other) {
      return ((ResolvedCanonical) other).url.equals(url);
    }
  }

  private class InvariantWithStatus extends ItemWithStatus {
    ElementDefinitionConstraintComponent value;
    protected InvariantWithStatus(ElementDefinitionConstraintComponent value) {
      this.value = value;
    }

    protected boolean matches(ItemWithStatus other) {
      return ((InvariantWithStatus) other).value.equalsDeep(value);
    }
    
    public void renderDetails(XhtmlNode f) {
      f = renderStatus(value, f);
      f.b().attribute("title", "Formal Invariant Identifier").tx(value.getKey());
      f.tx(": ");
      if (value.hasHuman()) {
        renderStatus(value.getHumanElement(), f).tx(value.getHuman());
      } else if (VersionComparisonAnnotation.hasDeleted(value, "human")) {
        Base b =VersionComparisonAnnotation.getDeletedItem(value, "human");
        renderStatus(b, f).tx(b.primitiveValue());        
      }
      f.tx(" (");
      if (status == ListItemStatus.New) {
        if (value.hasExpression()) {
          renderStatus(value.getExpressionElement(), f).code().tx(value.getExpression());
        } else if (VersionComparisonAnnotation.hasDeleted(value, "expression")) {
          Base b = VersionComparisonAnnotation.getDeletedItem(value, "expression");
          renderStatus(b, f).code().tx(b.primitiveValue());        
        }
      } else {
        renderStatus(value.getExpressionElement(), f).tx(value.getExpression());
      }
      f.tx(")");      
    }
  }
  
  private class DiscriminatorWithStatus extends ItemWithStatus {
    ElementDefinitionSlicingDiscriminatorComponent value;
    protected DiscriminatorWithStatus(ElementDefinitionSlicingDiscriminatorComponent value) {
      this.value = value;
    }

    protected boolean matches(ItemWithStatus other) {
      return ((DiscriminatorWithStatus) other).value.equalsDeep(value);
    }
    
    public void renderDetails(XhtmlNode f) {
      f.tx(value.getType().toCode());
      f.tx(" @ ");
      f.tx(value.getPath());
    }
  }
  
  private class ValueWithStatus extends ItemWithStatus {
    PrimitiveType value;
    protected ValueWithStatus(PrimitiveType value) {
      this.value = value;
    }

    protected boolean matches(ItemWithStatus other) {
      return ((ValueWithStatus) other).value.equalsDeep(value);
    }
    
    public void renderDetails(XhtmlNode f) {
      if (value.hasUserData("render.link")) {
        f = f.ah(value.getUserString("render.link"));
      }
      f.tx(value.asStringValue());
    }
    
  }

  private class DataValueWithStatus extends ItemWithStatus {
    DataType value;
    protected DataValueWithStatus(DataType value) {
      this.value = value;
    }

    protected boolean matches(ItemWithStatus other) {
      return ((ValueWithStatus) other).value.equalsDeep(value);
    }

    public void renderDetails(XhtmlNode f) throws IOException {

      if (value.hasUserData("render.link")) {
        f = f.ah(value.getUserString("render.link"));
      }
      f.tx(summarize(value));
    }

  }
  

  private List<String> keyRows = new ArrayList<>();
  private Map<String, Map<String, ElementDefinition>> sdMapCache = new HashMap<>();
  private IMarkdownProcessor hostMd;

  public StructureDefinitionRenderer(RenderingContext context) {
    super(context);
    hostMd = new InternalMarkdownProcessor();
    corePath = context.getContext().getSpecUrl();
  }

  public StructureDefinitionRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  
  public Map<String, Map<String, ElementDefinition>> getSdMapCache() {
    return sdMapCache;
  }

  public void setSdMapCache(Map<String, Map<String, ElementDefinition>> sdMapCache) {
    this.sdMapCache = sdMapCache;
  }

  public IMarkdownProcessor getHostMd() {
    return hostMd;
  }

  public void setHostMd(IMarkdownProcessor hostMd) {
    this.hostMd = hostMd;
  }

  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (StructureDefinition) dr);
  }

  public boolean render(XhtmlNode x, StructureDefinition sd) throws FHIRFormatError, DefinitionException, IOException {
    if (context.getStructureMode() == StructureDefinitionRendererMode.DATA_DICT) {
      renderDict(sd, sd.getDifferential().getElement(), x.table("dict"), false, GEN_MODE_DIFF, "");
    } else {
      x.getChildNodes().add(generateTable(context.getDefinitionsTarget(), sd, true, context.getDestDir(), false, sd.getId(), false, 
        context.getLink(KnownLinkType.SPEC), "", sd.getKind() == StructureDefinitionKind.LOGICAL, false, null, false, context, ""));
    }
    return true;
  }

  public void describe(XhtmlNode x, StructureDefinition sd) {
    x.tx(display(sd));
  }

  public String display(StructureDefinition sd) {
    return sd.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((StructureDefinition) r).present();
  }

  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    if (r.has("title")) {
      return r.children("title").get(0).getBase().primitiveValue();
    }
    if (r.has("name")) {
      return r.children("name").get(0).getBase().primitiveValue();
    }
    return "??";
  }


  //  private static final int AGG_NONE = 0;
  //  private static final int AGG_IND = 1;
  //  private static final int AGG_GR = 2;
  //  private static final boolean TABLE_FORMAT_FOR_FIXED_VALUES = false;
  public static final String CONSTRAINT_CHAR = "C";
  public static final String CONSTRAINT_STYLE = "padding-left: 3px; padding-right: 3px; border: 1px maroon solid; font-weight: bold; color: #301212; background-color: #fdf4f4;";
  public static final int GEN_MODE_SNAP = 1;
  public static final int GEN_MODE_DIFF = 2;
  public static final int GEN_MODE_MS = 3;
  public static final int GEN_MODE_KEY = 4;
  public static final String RIM_MAPPING = "http://hl7.org/v3";
  public static final String v2_MAPPING = "http://hl7.org/v2";
  public static final String LOINC_MAPPING = "http://loinc.org";
  public static final String SNOMED_MAPPING = "http://snomed.info";

  private final boolean ADD_REFERENCE_TO_TABLE = true;

  private boolean useTableForFixedValues = true;
  private String corePath;

  public static class UnusedTracker {
    private boolean used;
  }

  private class SpanEntry {
    private List<SpanEntry> children = new ArrayList<SpanEntry>();
    private boolean profile;
    private String id;
    private String name;
    private String resType;
    private String cardinality;
    private String description;
    private String profileLink;
    private String resLink;
    private String type;

    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getResType() {
      return resType;
    }
    public void setResType(String resType) {
      this.resType = resType;
    }
    public String getCardinality() {
      return cardinality;
    }
    public void setCardinality(String cardinality) {
      this.cardinality = cardinality;
    }
    public String getDescription() {
      return description;
    }
    public void setDescription(String description) {
      this.description = description;
    }
    public String getProfileLink() {
      return profileLink;
    }
    public void setProfileLink(String profileLink) {
      this.profileLink = profileLink;
    }
    public String getResLink() {
      return resLink;
    }
    public void setResLink(String resLink) {
      this.resLink = resLink;
    }
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    public boolean isProfile() {
      return profile;
    }
    public void setProfile(boolean profile) {
      this.profile = profile;
    }
    public List<SpanEntry> getChildren() {
      return children;
    }
    public String getType() {
      return type;
    }
    public void setType(String type) {
      this.type = type;
    }

  }

  private class ElementInStructure {

    private StructureDefinition source;
    private ElementDefinition element;

    public ElementInStructure(StructureDefinition source, ElementDefinition ed) {
      this.source = source;
      this.element = ed;
    }

    public StructureDefinition getSource() {
      return source;
    }

    public ElementDefinition getElement() {
      return element;
    }

  }
  private ElementInStructure getElementByName(List<ElementDefinition> elements, String contentReference, StructureDefinition source) {
    if (contentReference.contains("#")) {
      String url = contentReference.substring(0, contentReference.indexOf("#"));
      contentReference = contentReference.substring(contentReference.indexOf("#"));
      if (Utilities.noString(url)) {
        url = source.getUrl();
      }
      if (!url.equals(source.getUrl())) {
        source = context.getWorker().fetchResource(StructureDefinition.class, url, source);
        if (source == null) {
          throw new FHIRException("Unable to resolve StructureDefinition "+url+" resolving content reference "+contentReference);
        }
        elements = source.getSnapshot().getElement();
      }
    } 
    for (ElementDefinition ed : elements) {
      if (("#"+ed.getPath()).equals(contentReference)) {
        return new ElementInStructure(source, ed);
      }
      if (("#"+ed.getId()).equals(contentReference)) {
        return new ElementInStructure(source, ed);
      }
    }
    throw new Error("getElementByName: can't find "+contentReference+" in "+elements.toString()+" from "+source.getUrl());
    //    return null;
  }

  public XhtmlNode generateGrid(String defFile, StructureDefinition profile, String imageFolder, boolean inlineGraphics, String profileBaseFileName, String corePath, String imagePath, Set<String> outputTracker) throws IOException, FHIRException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(imageFolder, inlineGraphics, true);
    gen.setTranslator(getTranslator());
    TableModel model = gen.initGridTable(corePath, profile.getId());
    List<ElementDefinition> list = profile.getSnapshot().getElement();
    List<StructureDefinition> profiles = new ArrayList<StructureDefinition>();
    profiles.add(profile);
    genGridElement(defFile == null ? null : defFile+"#", gen, model.getRows(), list.get(0), list, profiles, true, profileBaseFileName, null, corePath, imagePath, true, profile.getDerivation() == TypeDerivationRule.CONSTRAINT && usesMustSupport(list));
    try {
      return gen.generate(model, imagePath, 1, outputTracker);
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(e.getMessage(), e);
    }
  }


  private static class Column {
    String id;
    String title;
    String hint;
    private String link;

    protected Column(String id, String title, String hint) {
      super();
      this.id = id;
      this.title = title;
      this.hint = hint;
    }
    protected Column(String id, String title, String hint, String link) {
      super();
      this.id = id;
      this.title = title;
      this.hint = hint;
      this.link = link;
    }

  }
  public XhtmlNode generateTable(String defFile, StructureDefinition profile, boolean diff, String imageFolder, boolean inlineGraphics, String profileBaseFileName, boolean snapshot, String corePath, String imagePath,
      boolean logicalModel, boolean allInvariants, Set<String> outputTracker, boolean mustSupport, RenderingContext rc, String anchorPrefix) throws IOException, FHIRException {
    assert(diff != snapshot);// check it's ok to get rid of one of these
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(imageFolder, inlineGraphics, true);
    gen.setTranslator(getTranslator());

    List<ElementDefinition> list;
    if (diff)
      list = supplementMissingDiffElements(profile);
    else {
      list = new ArrayList<>();
      list.addAll(profile.getSnapshot().getElement());
    }

    List<Column> columns = new ArrayList<>();
    TableModel model;
    switch (context.getStructureMode()) {
    case BINDINGS:
      scanBindings(columns, list);
      model = initCustomTable(gen, corePath, false, true, profile.getId()+(diff ? "d" : "s"), rc.getRules() == GenerationRules.IG_PUBLISHER, columns);    
      break;
    case OBLIGATIONS:
      scanObligations(columns, list);
      model = initCustomTable(gen, corePath, false, true, profile.getId()+(diff ? "d" : "s"), rc.getRules() == GenerationRules.IG_PUBLISHER, columns);    
      break;
    case SUMMARY:
      model = gen.initNormalTable(corePath, false, true, profile.getId()+(diff ? "d" : "s"), rc.getRules() == GenerationRules.IG_PUBLISHER, rc.getRules() == GenerationRules.IG_PUBLISHER ? TableGenerationMode.XHTML : TableGenerationMode.XML);
      break;
    default:
      throw new Error("Unknown structure mode");
    }

    List<StructureDefinition> profiles = new ArrayList<StructureDefinition>();
    profiles.add(profile);
    keyRows.clear();

    genElement(defFile == null ? null : defFile+"#", gen, model.getRows(), list.get(0), list, profiles, diff, profileBaseFileName, null, snapshot, corePath, imagePath, true, logicalModel, profile.getDerivation() == TypeDerivationRule.CONSTRAINT && usesMustSupport(list), allInvariants, null, mustSupport, rc, anchorPrefix, profile, columns);
    try {
      return gen.generate(model, imagePath, 0, outputTracker);
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(context.getWorker().formatMessage(I18nConstants.ERROR_GENERATING_TABLE_FOR_PROFILE__, profile.getUrl(), e.getMessage()), e);
    }
  }

  private void scanBindings(List<Column> columns, List<ElementDefinition> list) {
    Set<String> cols = new HashSet<>();
    scanBindings(cols, list, list.get(0));
    if (cols.contains("required")) {
      columns.add(new Column("required", "Required", "Concepts must come from this value set"));
    }
    if (cols.contains("extensible")) {
      columns.add(new Column("extensible", "Extensible", "Concepts must come from this value set if an appropriate concept is in the value set "));
    }
    if (cols.contains("maximum")) {
      columns.add(new Column("maximum", "Maximum", "A required binding for additional codes, for use when the binding strength is 'extensible' or 'preferred'"));
    }
    if (cols.contains("minimum")) {
      columns.add(new Column("minimum", "Minimum", "The minimum allowable value set - any conformant system SHALL support all these codes"));
    }
    if (cols.contains("candidate")) {
      columns.add(new Column("candidate", "Candidate", "This value set is a candidate to substitute for the overall conformance value set in some situations; usually these are defined in the documentation"));
    }
    if (cols.contains("current")) {
      columns.add(new Column("current", "Current", "New records are required to use this value set, but legacy records may use other codes. The definition of 'new record' is difficult, since systems often create new records based on pre-existing data. Usually 'current' bindings are mandated by an external authority that makes clear rules around this"));
    }
    if (cols.contains("preferred")) {
      columns.add(new Column("preferred", "Preferred", "This is the value set that is preferred in a given context (documentation should explain why)"));
    }
    if (cols.contains("ui")) {
      columns.add(new Column("ui", "UI", "This value set is provided for user look up in a given context. Typically, these valuesets only include a subset of codes relevant for input in a context"));
    }
    if (cols.contains("starter")) {
      columns.add(new Column("starter", "Starter", "This value set is a good set of codes to start with when designing your system"));
    }
    if (cols.contains("component")) {
      columns.add(new Column("component", "Component", "This value set is a component of the base value set. Usually this is called out so that documentation can be written about a portion of the value set"));
    }
    if (cols.contains("example")) {
      columns.add(new Column("example", "Example", "Instances are not expected or even encouraged to draw from the specified value set. The value set merely provides examples of the types of concepts intended to be included."));
    }
  }

  public void scanBindings(Set<String> cols, List<ElementDefinition> list, ElementDefinition ed) {
    if (ed.hasBinding()) {
      if (ed.getBinding().hasValueSet() && ed.getBinding().hasStrength()) {
        switch (ed.getBinding().getStrength()) {
        case EXAMPLE:
          cols.add("example");
          break;
        case EXTENSIBLE:
          cols.add("extensible");
          break;
        case PREFERRED:
          cols.add("preferred");
          break;
        case REQUIRED:
          cols.add("required");
          break;
        default:
          break;
        }
      }
      for (ElementDefinitionBindingAdditionalComponent ab : ed.getBinding().getAdditional()) {
        cols.add(ab.getPurpose().toCode());
      }
      for (Extension ext : ed.getBinding().getExtensionsByUrl(ToolingExtensions.EXT_BINDING_ADDITIONAL)) {
        cols.add(ext.getExtensionString("purpose"));        
      }
    }

    List<ElementDefinition> children = getChildren(list, ed);
    for (ElementDefinition element : children) {
      scanBindings(cols, list, element);
    }
  }

  private void scanObligations(List<Column> columns, List<ElementDefinition> list) {
    Set<String> cols = new HashSet<>();
    scanObligations(cols, list, list.get(0));

    if (cols.contains("$all")) {
      columns.add(new Column("$all", "All Actors", "Obligations that apply to all actors"));
    }
    for (String col : cols) {
      if (!"$all".equals(col)) {
        ActorDefinition actor = context.getWorker().fetchResource(ActorDefinition.class, col);
        if (actor == null) {
          columns.add(new Column(col, tail(col), "Obligations that apply to the undefined actor "+col, col));          
        } else {
          columns.add(new Column(col, actor.getName(), "Obligations that apply to the actor "+actor.present(), actor.getWebPath()));                    
        }
      }
    }
  }

  private void scanObligations(Set<String> cols, List<ElementDefinition> list, ElementDefinition ed) {

    for (Extension ob : ed.getExtensionsByUrl(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS)) {
      if (ob.hasExtension("actor", "actorId")) {
        for (Extension a : ob.getExtensionsByUrl("actor", "actorId")) {
          cols.add(a.getValueCanonicalType().primitiveValue());
        }
      } else 
        cols.add("$all");
    }

    List<ElementDefinition> children = getChildren(list, ed);
    for (ElementDefinition element : children) {
      scanObligations(cols, list, element);
    }
  }

  public TableModel initCustomTable(HierarchicalTableGenerator gen, String prefix, boolean isLogical, boolean alternating, String id, boolean isActive, List<Column> columns) throws IOException {
    TableModel model = gen.new TableModel(id, isActive);

    model.setAlternating(alternating);
    if (context.getRules() == GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) {
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());       
    } else {
      model.setDocoImg(Utilities.pathURL(prefix, "help16.png"));
    }
    model.setDocoRef(Utilities.pathURL("https://build.fhir.org/ig/FHIR/ig-guidance", "readingIgs.html#table-views"));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", "Name"), translate("sd.hint", "The logical name of the element"), null, 0));
    for (Column col : columns) {
      model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("sd.head", col.title), translate("sd.hint", col.hint), null, 0));      
    }
    return model;
  }

  private Row genElement(String defPath, HierarchicalTableGenerator gen, List<Row> rows, ElementDefinition element, List<ElementDefinition> all, List<StructureDefinition> profiles, boolean showMissing, String profileBaseFileName, Boolean extensions, 
      boolean snapshot, String corePath, String imagePath, boolean root, boolean logicalModel, boolean isConstraintMode, boolean allInvariants, Row slicingRow, boolean mustSupport, RenderingContext rc, String anchorPrefix, Resource srcSD, List<Column> columns) throws IOException, FHIRException {
    Row originalRow = slicingRow;
    StructureDefinition profile = profiles == null ? null : profiles.get(profiles.size()-1);
    Row typesRow = null;

    List<ElementDefinition> children = getChildren(all, element);
    //    if (!snapshot && isExtension && extensions != null && extensions != isExtension)
    //      return;

    if (!onlyInformationIsMapping(all, element)) {
      Row row = gen.new Row();
      row.setAnchor(element.getPath());
      row.setColor(context.getProfileUtilities().getRowColor(element, isConstraintMode));
      if (element.hasSlicing())
        row.setLineColor(1);
      else if (element.hasSliceName())
        row.setLineColor(2);
      else
        row.setLineColor(0);
      boolean hasDef = element != null;
      boolean ext = false;
      if (tail(element.getPath()).equals("extension")) {
        if (element.hasType() && element.getType().get(0).hasProfile() && extensionIsComplex(element.getType().get(0).getProfile().get(0).getValue()))
          row.setIcon("icon_extension_complex.png", HierarchicalTableGenerator.TEXT_ICON_EXTENSION_COMPLEX);
        else
          row.setIcon("icon_extension_simple.png", HierarchicalTableGenerator.TEXT_ICON_EXTENSION_SIMPLE);
        ext = true;
      } else if (tail(element.getPath()).equals("modifierExtension")) {
        if (element.hasType() && element.getType().get(0).hasProfile() && extensionIsComplex(element.getType().get(0).getProfile().get(0).getValue()))
          row.setIcon("icon_modifier_extension_complex.png", HierarchicalTableGenerator.TEXT_ICON_EXTENSION_COMPLEX);
        else
          row.setIcon("icon_modifier_extension_simple.png", HierarchicalTableGenerator.TEXT_ICON_EXTENSION_SIMPLE);
      } else if (!hasDef || element.getType().size() == 0) {
        if (root && profile != null && context.getWorker().getResourceNames().contains(profile.getType())) {
          row.setIcon("icon_resource.png", HierarchicalTableGenerator.TEXT_ICON_RESOURCE);
        } else if (hasDef && element.hasExtension(ToolingExtensions.EXT_JSON_PROP_KEY)) {
          row.setIcon("icon-object-box.png", HierarchicalTableGenerator.TEXT_ICON_OBJECT_BOX);
          keyRows.add(element.getId()+"."+ToolingExtensions.readStringExtension(element, ToolingExtensions.EXT_JSON_PROP_KEY));
        } else {
          row.setIcon("icon_element.gif", HierarchicalTableGenerator.TEXT_ICON_ELEMENT);
        }
      } else if (hasDef && element.getType().size() > 1) {
        if (allAreReference(element.getType())) {
          row.setIcon("icon_reference.png", HierarchicalTableGenerator.TEXT_ICON_REFERENCE);
        } else if (element.hasExtension(ToolingExtensions.EXT_JSON_PRIMITIVE_CHOICE)) {
          row.setIcon("icon_choice.gif", HierarchicalTableGenerator.TEXT_ICON_CHOICE);
        } else {
          row.setIcon("icon_choice.gif", HierarchicalTableGenerator.TEXT_ICON_CHOICE);
          typesRow = row;
        }
      } else if (hasDef && element.getType().get(0).getWorkingCode() != null && element.getType().get(0).getWorkingCode().startsWith("@")) {
        row.setIcon("icon_reuse.png", HierarchicalTableGenerator.TEXT_ICON_REUSE);
      } else if (hasDef && context.getContext().isPrimitiveType(element.getType().get(0).getWorkingCode())) {
        if (keyRows.contains(element.getId())) {
          row.setIcon("icon-key.png", HierarchicalTableGenerator.TEXT_ICON_KEY);
        } else {
          row.setIcon("icon_primitive.png", HierarchicalTableGenerator.TEXT_ICON_PRIMITIVE);
        }
      } else if (hasDef && element.getType().get(0).hasTarget()) {
        row.setIcon("icon_reference.png", HierarchicalTableGenerator.TEXT_ICON_REFERENCE);
      } else if (hasDef && context.getContext().isDataType(element.getType().get(0).getWorkingCode())) {
        row.setIcon("icon_datatype.gif", HierarchicalTableGenerator.TEXT_ICON_DATATYPE);
      } else if (hasDef && element.hasExtension(ToolingExtensions.EXT_JSON_PROP_KEY)) {
        row.setIcon("icon-object-box.png", HierarchicalTableGenerator.TEXT_ICON_OBJECT_BOX);
        keyRows.add(element.getId()+"."+ToolingExtensions.readStringExtension(element, ToolingExtensions.EXT_JSON_PROP_KEY));
      } else if (hasDef && Utilities.existsInList(element.getType().get(0).getWorkingCode(), "Base", "Element", "BackboneElement")) {
        row.setIcon("icon_element.gif", HierarchicalTableGenerator.TEXT_ICON_ELEMENT);
      } else {
        row.setIcon("icon_resource.png", HierarchicalTableGenerator.TEXT_ICON_RESOURCE);
      }
      if (element.hasUserData("render.opaque")) {
        row.setOpacity("0.5");
      }
      UnusedTracker used = new UnusedTracker();
      String ref = defPath == null ? null : defPath + anchorPrefix + element.getId();
      String sName = tail(element.getPath());
      if (element.hasSliceName())
        sName = sName +":"+element.getSliceName();
      used.used = true;
      if (logicalModel && element.hasRepresentation(PropertyRepresentation.XMLATTR))
        sName = "@"+sName;
      Cell nc = genElementNameCell(gen, element, profileBaseFileName, snapshot, corePath, imagePath, root, logicalModel, allInvariants, profile, typesRow, row, hasDef, ext, used, ref, sName, all);
      switch (context.getStructureMode()) {
      case BINDINGS:
        genElementBindings(gen, element, columns, row, profile, corePath);
        break;
      case OBLIGATIONS:
        genElementObligations(gen, element, columns, row, corePath, profile);
        break;
      case SUMMARY:
        genElementCells(gen, element, profileBaseFileName, snapshot, corePath, imagePath, root, logicalModel, allInvariants, profile, typesRow, row, hasDef, ext, used, ref, sName, nc, mustSupport, true, rc);
        break;

      }
      if (element.hasSlicing()) {
        if (standardExtensionSlicing(element)) {
          used.used = true; // doesn't matter whether we have a type, we're used if we're setting up slicing ... element.hasType() && element.getType().get(0).hasProfile();
          showMissing = false; //?
        } else {
          row.setIcon("icon_slice.png", HierarchicalTableGenerator.TEXT_ICON_SLICE);
          slicingRow = row;
          for (Cell cell : row.getCells())
            for (Piece p : cell.getPieces()) {
              p.addStyle("font-style: italic");
            }
        }
      } else if (element.hasSliceName()) {
        row.setIcon("icon_slice_item.png", HierarchicalTableGenerator.TEXT_ICON_SLICE_ITEM);
      }
      if (used.used || showMissing)
        rows.add(row);
      if (!used.used && !element.hasSlicing()) {
        for (Cell cell : row.getCells())
          for (Piece p : cell.getPieces()) {
            p.setStyle("text-decoration:line-through");
            p.setReference(null);
          }
      } else {
        if (slicingRow != originalRow && !children.isEmpty()) {
          // we've entered a slice; we're going to create a holder row for the slice children
          Row hrow = gen.new Row();
          hrow.setAnchor(element.getPath());
          hrow.setColor(context.getProfileUtilities().getRowColor(element, isConstraintMode));
          hrow.setLineColor(1);
          hrow.setIcon("icon_element.gif", HierarchicalTableGenerator.TEXT_ICON_ELEMENT);
          hrow.getCells().add(gen.new Cell(null, null, sName+":All Slices", "", null));
          switch (context.getStructureMode()) {
          case BINDINGS:
          case OBLIGATIONS:
            for (Column col : columns) {
              hrow.getCells().add(gen.new Cell());              
            }
            break;
          case SUMMARY:
            hrow.getCells().add(gen.new Cell());
            hrow.getCells().add(gen.new Cell());
            hrow.getCells().add(gen.new Cell());
            hrow.getCells().add(gen.new Cell(null, null, "Content/Rules for all slices", "", null));
            break;            
          }
          row.getSubRows().add(hrow);
          row = hrow;
        }
        if (typesRow != null && !children.isEmpty()) {
          // we've entered a typing slice; we're going to create a holder row for the all types children
          Row hrow = gen.new Row();
          hrow.setAnchor(element.getPath());
          hrow.setColor(context.getProfileUtilities().getRowColor(element, isConstraintMode));
          hrow.setLineColor(1);
          hrow.setIcon("icon_element.gif", HierarchicalTableGenerator.TEXT_ICON_ELEMENT);
          hrow.getCells().add(gen.new Cell(null, null, sName+":All Types", "", null));
          switch (context.getStructureMode()) {
          case BINDINGS:
          case OBLIGATIONS:
            for (Column col : columns) {
              hrow.getCells().add(gen.new Cell());              
            }
            break;
          case SUMMARY:
            hrow.getCells().add(gen.new Cell());
            hrow.getCells().add(gen.new Cell());
            hrow.getCells().add(gen.new Cell());
            hrow.getCells().add(gen.new Cell(null, null, "Content/Rules for all Types", "", null));
          }
          row.getSubRows().add(hrow);
          row = hrow;
        }

        Row currRow = row;
        List<ElementChoiceGroup> groups = readChoices(element, children);
        boolean isExtension = Utilities.existsInList(tail(element.getPath()), "extension", "modifierExtension");
        if (!element.prohibited()) {
          for (ElementDefinition child : children) {
            if (!child.hasSliceName()) {
              currRow = row; 
            }
            Row childRow = chooseChildRowByGroup(gen, currRow, groups, child, element, isConstraintMode);

            if (logicalModel || !child.getPath().endsWith(".id") || (child.getPath().endsWith(".id") && (profile != null) && (profile.getDerivation() == TypeDerivationRule.CONSTRAINT))) {  
              currRow = genElement(defPath, gen, childRow.getSubRows(), child, all, profiles, showMissing, profileBaseFileName, isExtension, snapshot, corePath, imagePath, false, logicalModel, isConstraintMode, allInvariants, currRow, mustSupport, rc, anchorPrefix, srcSD, columns);
            }
          }
        }
        //        if (!snapshot && (extensions == null || !extensions))
        //          for (ElementDefinition child : children)
        //            if (child.getPath().endsWith(".extension") || child.getPath().endsWith(".modifierExtension"))
        //              genElement(defPath, gen, row.getSubRows(), child, all, profiles, showMissing, profileBaseFileName, true, false, corePath, imagePath, false, logicalModel, isConstraintMode, allInvariants);
      }
      if (typesRow != null && !element.prohibited() && context.getStructureMode() == StructureDefinitionRendererMode.SUMMARY) {
        makeChoiceRows(typesRow.getSubRows(), element, gen, corePath, profileBaseFileName, mustSupport, srcSD);
      }
    }
    return slicingRow;
  }

  private void genElementObligations(HierarchicalTableGenerator gen, ElementDefinition element, List<Column> columns, Row row, String corePath, StructureDefinition profile) throws IOException {
    for (Column col : columns) { 
      Cell gc = gen.new Cell();
      row.getCells().add(gc);
      ObligationsRenderer obr = new ObligationsRenderer(corePath, profile, element.getPath(), context, null, this);
      obr.seeObligations(element, col.id);
      obr.renderList(gen, gc);      
    }
  }

  private String displayForUsage(Coding c) {
    if (c.hasDisplay()) {
      return c.getDisplay();
    }
    if ("http://terminology.hl7.org/CodeSystem/usage-context-type".equals(c.getSystem())) {
      return c.getCode();
    }
    return c.getCode();
  }

  private void genElementBindings(HierarchicalTableGenerator gen, ElementDefinition element, List<Column> columns, Row row, StructureDefinition profile, String corepath) {
    for (Column col : columns) { 
      Cell gc = gen.new Cell();
      row.getCells().add(gc);
      List<ElementDefinitionBindingAdditionalComponent> bindings = collectBindings(element, col.id);
      if (bindings.size() > 0) {
        Piece p = gen.new Piece(null);
        gc.addPiece(p);
        new AdditionalBindingsRenderer(context.getPkp(), corepath, profile, element.getPath(), context, null, this).render(p.getChildren(), bindings);
      }
    }
  }

  private List<ElementDefinitionBindingAdditionalComponent> collectBindings(ElementDefinition element, String type) {
    List<ElementDefinitionBindingAdditionalComponent> res = new ArrayList<>();
    if (element.hasBinding()) {
      ElementDefinitionBindingComponent b = element.getBinding();
      if (b.hasStrength() && type.equals(b.getStrength().toCode())) {
        ElementDefinitionBindingAdditionalComponent ab = new ElementDefinitionBindingAdditionalComponent();
        res.add(ab.setAny(false).setDocumentation(b.getDescription()).setValueSet(b.getValueSet()));
      }
      if ("maximum".equals(type) && b.hasExtension(ToolingExtensions.EXT_MAX_VALUESET)) {
        ElementDefinitionBindingAdditionalComponent ab = new ElementDefinitionBindingAdditionalComponent();
        res.add(ab.setAny(false).setValueSet(ToolingExtensions.readStringExtension(b, ToolingExtensions.EXT_MAX_VALUESET)));
      }
      if ("minimum".equals(type) && b.hasExtension(ToolingExtensions.EXT_MIN_VALUESET)) {
        ElementDefinitionBindingAdditionalComponent ab = new ElementDefinitionBindingAdditionalComponent();
        res.add(ab.setAny(false).setValueSet(ToolingExtensions.readStringExtension(b, ToolingExtensions.EXT_MIN_VALUESET)));
      }
      for (ElementDefinitionBindingAdditionalComponent t : b.getAdditional()) {
        if (type.equals(t.getPurpose().toCode())) {
          res.add(t);
        }
      }
      for (Extension ext : b.getExtensionsByUrl(ToolingExtensions.EXT_BINDING_ADDITIONAL)) {
        if (type.equals(ext.getExtensionString("purpose"))) {
          ElementDefinitionBindingAdditionalComponent ab = new ElementDefinitionBindingAdditionalComponent();
          if (ext.hasExtension("any")) {
            ab.setAny(ToolingExtensions.readBooleanExtension(ext, "any"));
          }
          if (ext.hasExtension("purpose")) {
            ab.setPurpose(AdditionalBindingPurposeVS.fromCode(ToolingExtensions.readStringExtension(ext, "purpose")));
          }
          if (ext.hasExtension("documentation")) {
            ab.setDocumentation(ToolingExtensions.readStringExtension(ext, "documentation"));
          }
          if (ext.hasExtension("shortDoco")) {
            ab.setShortDoco(ToolingExtensions.readStringExtension(ext, "shortDoco"));
          }
          if (ToolingExtensions.hasExtension(ext, "usage")) {
            ab.addUsage(ext.getExtensionByUrl("usage").getValueUsageContext());
          }
          if (ext.hasExtension("valueSet")) {
            ab.setValueSet(ToolingExtensions.readStringExtension(ext, "valueSet"));
          }
          res.add(ab);        
        }
      }
    }
    return res;
  }

  public Cell genElementNameCell(HierarchicalTableGenerator gen, ElementDefinition element, String profileBaseFileName, boolean snapshot, String corePath,
      String imagePath, boolean root, boolean logicalModel, boolean allInvariants, StructureDefinition profile, Row typesRow, Row row, boolean hasDef,
      boolean ext, UnusedTracker used, String ref, String sName, List<ElementDefinition> elements) throws IOException {
    String hint = "";
    hint = checkAdd(hint, (element.hasSliceName() ? translate("sd.table", "Slice")+" "+element.getSliceName() : ""));
    if (hasDef && element.hasDefinition()) {
      hint = checkAdd(hint, (hasDef && element.hasSliceName() ? ": " : ""));
      hint = checkAdd(hint, !hasDef ? null : gt(element.getDefinitionElement()));
    }
    if (element.hasSlicing() && slicesExist(elements, element)) { // some elements set up slicing but don't actually slice, so we don't augment the name 
      sName = "Slices for "+sName; 
    }
    Cell left = gen.new Cell(null, ref, sName, hint, null);
    row.getCells().add(left);
    return left;
  }

  public List<Cell> genElementCells(HierarchicalTableGenerator gen, ElementDefinition element, String profileBaseFileName, boolean snapshot, String corePath,
      String imagePath, boolean root, boolean logicalModel, boolean allInvariants, StructureDefinition profile, Row typesRow, Row row, boolean hasDef,
      boolean ext, UnusedTracker used, String ref, String sName, Cell nameCell, boolean mustSupport, boolean allowSubRows, RenderingContext rc) throws IOException {
    List<Cell> res = new ArrayList<>();
    Cell gc = gen.new Cell();
    row.getCells().add(gc);
    res.add(gc);
    if (element != null && element.getIsModifier()) {
      checkForNoChange(element.getIsModifierElement(), gc.addStyledText(translate("sd.table", "This element is a modifier element"), "?!", null, null, null, false));
    }
    if (element != null) {
      if (element.getMustSupport() && element.hasExtension(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS)) {
        checkForNoChange(element.getMustSupportElement(), gc.addStyledText(translate("sd.table", "This element has obligations and must be supported"), "SO", "white", "red", null, false));
      } else if (element.getMustSupport()) {
          checkForNoChange(element.getMustSupportElement(), gc.addStyledText(translate("sd.table", "This element must be supported"), "S", "white", "red", null, false));
      } else if (element != null && element.hasExtension(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS)) {
       checkForNoChange(element.getMustSupportElement(), gc.addStyledText(translate("sd.table", "This element has obligations"), "O", "white", "red", null, false));
      }
    }
    if (element != null && element.getIsSummary()) {
      checkForNoChange(element.getIsSummaryElement(), gc.addStyledText(translate("sd.table", "This element is included in summaries"), "\u03A3", null, null, null, false));
    }
    if (element != null && element.getMustHaveValue()) {
      checkForNoChange(element.getMustHaveValueElement(), gc.addStyledText(translate("sd.table", "This primitive element must have a value"), "V", "maroon", null, null, true));
    }
    if (element != null && (hasNonBaseConstraints(element.getConstraint()) || hasNonBaseConditions(element.getCondition()))) {
      Piece p = gc.addText(CONSTRAINT_CHAR);
      p.setHint(translate("sd.table", "This element has or is affected by constraints ("+listConstraintsAndConditions(element)+")"));
      p.addStyle(CONSTRAINT_STYLE);
      p.setReference(Utilities.pathURL(VersionUtilities.getSpecUrl(context.getWorker().getVersion()), "conformance-rules.html#constraints"));
    }
    if (element != null && element.hasExtension(ToolingExtensions.EXT_STANDARDS_STATUS)) {
      StandardsStatus ss = StandardsStatus.fromCode(element.getExtensionString(ToolingExtensions.EXT_STANDARDS_STATUS));
      gc.addStyledText("Standards Status = "+ss.toDisplay(), ss.getAbbrev(), "black", ss.getColor(), context.getWorker().getSpecUrl()+"versions.html#std-process", true);
    }

    ExtensionContext extDefn = null;
    if (ext) {
      if (element != null) {
        if (element.getType().size() == 1 && element.getType().get(0).hasProfile()) {
          String eurl = element.getType().get(0).getProfile().get(0).getValue();
          extDefn = locateExtension(StructureDefinition.class, eurl);
          if (extDefn == null) {
            res.add(genCardinality(gen, element, row, hasDef, used, null));
            res.add(addCell(row, gen.new Cell(null, null, "?gen-e1? "+element.getType().get(0).getProfile(), null, null)));
            res.add(generateDescription(gen, row, element, (ElementDefinition) element.getUserData(ProfileUtilities.UD_DERIVATION_POINTER), used.used, profile == null ? "" : profile.getUrl(), eurl, profile, corePath, imagePath, root, logicalModel, allInvariants, snapshot, mustSupport, allowSubRows, rc));
          } else {
            String name = element.hasSliceName() ? element.getSliceName() : urltail(eurl);
            nameCell.getPieces().get(0).setText(name);
            // left.getPieces().get(0).setReference((String) extDefn.getExtensionStructure().getTag("filename"));
            nameCell.getPieces().get(0).setHint(translate("sd.table", "Extension URL")+" = "+extDefn.getUrl());
            res.add(genCardinality(gen, element, row, hasDef, used, extDefn.getElement()));
            ElementDefinition valueDefn = extDefn.getExtensionValueDefinition();
            if (valueDefn != null && !"0".equals(valueDefn.getMax()))
              res.add(genTypes(gen, row, valueDefn, profileBaseFileName, profile, corePath, imagePath, root, mustSupport));
            else // if it's complex, we just call it nothing
              // genTypes(gen, row, extDefn.getSnapshot().getElement().get(0), profileBaseFileName, profile);
              res.add(addCell(row, gen.new Cell(null, null, "("+translate("sd.table", "Complex")+")", null, null)));
            res.add(generateDescription(gen, row, element, extDefn.getElement(), used.used, null, extDefn.getUrl(), profile, corePath, imagePath, root, logicalModel, allInvariants, valueDefn, snapshot, mustSupport, allowSubRows, rc));
          }
        } else {
          res.add(genCardinality(gen, element, row, hasDef, used, null));
          if ("0".equals(element.getMax()))
            res.add(addCell(row, gen.new Cell()));            
          else
            res.add(genTypes(gen, row, element, profileBaseFileName, profile, corePath, imagePath, root, mustSupport));
          res.add(generateDescription(gen, row, element, (ElementDefinition) element.getUserData(ProfileUtilities.UD_DERIVATION_POINTER), used.used, null, null, profile, corePath, imagePath, root, logicalModel, allInvariants, snapshot, mustSupport, allowSubRows, rc));
        }
      }
    } else if (element != null) {
      res.add(genCardinality(gen, element, row, hasDef, used, null));
      if (hasDef && !"0".equals(element.getMax()) && typesRow == null)
        res.add(genTypes(gen, row, element, profileBaseFileName, profile, corePath, imagePath, root, mustSupport));
      else
        res.add(addCell(row, gen.new Cell()));
      res.add(generateDescription(gen, row, element, (ElementDefinition) element.getUserData(ProfileUtilities.UD_DERIVATION_POINTER), used.used, null, null, profile, corePath, imagePath, root, logicalModel, allInvariants, snapshot, mustSupport, allowSubRows, rc));
    }
    return res;
  }

  private Cell genCardinality(HierarchicalTableGenerator gen, ElementDefinition definition, Row row, boolean hasDef, UnusedTracker tracker, ElementDefinition fallback) {
    IntegerType min = !hasDef ? new IntegerType() : definition.hasMinElement() ? definition.getMinElement() : new IntegerType();
    StringType max = !hasDef ? new StringType() : definition.hasMaxElement() ? definition.getMaxElement() : new StringType();
    if (min.isEmpty() && definition.getUserData(ProfileUtilities.UD_DERIVATION_POINTER) != null) {
      ElementDefinition base = (ElementDefinition) definition.getUserData(ProfileUtilities.UD_DERIVATION_POINTER);
      if (base.hasMinElement()) {
        min = base.getMinElement().copy();
        min.setUserData(ProfileUtilities.UD_DERIVATION_EQUALS, true);
      }
    }
    if (max.isEmpty() && definition.getUserData(ProfileUtilities.UD_DERIVATION_POINTER) != null) {
      ElementDefinition base = (ElementDefinition) definition.getUserData(ProfileUtilities.UD_DERIVATION_POINTER);
      if (base.hasMaxElement()) {
        max = base.getMaxElement().copy();
        max.setUserData(ProfileUtilities.UD_DERIVATION_EQUALS, true);
      }
    }
    if (min.isEmpty() && fallback != null)
      min = fallback.getMinElement();
    if (max.isEmpty() && fallback != null)
      max = fallback.getMaxElement();

    if (!max.isEmpty())
      tracker.used = !max.getValue().equals("0");

    String hint = null;
    if (max.hasValue() && min.hasValue() && "*".equals(max.getValue()) && 0 == min.getValue()) {
      if (definition.hasExtension(ToolingExtensions.EXT_JSON_EMPTY)) {
        String code = ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_JSON_EMPTY);
        if ("present".equals(code)) {
          hint = "This element is present as a JSON Array even when there are no items in the instance";
        } else {
          hint = "This element may be present as a JSON Array even when there are no items in the instance";          
        }
      }
    }
    Cell cell = gen.new Cell(null, null, null, null, null);
    row.getCells().add(cell);
    if (!min.isEmpty() || !max.isEmpty()) {
      cell.addPiece(checkForNoChange(min, gen.new Piece(null, !min.hasValue() ? "" : Integer.toString(min.getValue()), hint)));
      cell.addPiece(checkForNoChange(min, max, gen.new Piece(null, "..", hint)));
      cell.addPiece(checkForNoChange(max, gen.new Piece(null, !max.hasValue() ? "" : max.getValue(), hint)));
    }
    return cell;
  }

  public List<ElementDefinition> supplementMissingDiffElements(StructureDefinition profile) {
    List<ElementDefinition> list = new ArrayList<>();
    list.addAll(profile.getDifferential().getElement());
    if (list.isEmpty()) {
      ElementDefinition root = new ElementDefinition().setPath(profile.getTypeName());
      root.setId(profile.getTypeName());
      list.add(root);
    } else {
      if (list.get(0).getPath().contains(".")) {
        ElementDefinition root = new ElementDefinition().setPath(profile.getTypeName());
        root.setId(profile.getTypeName());
        list.add(0, root);
      }
    }
    insertMissingSparseElements(list);
    return list;
  }

  private boolean usesMustSupport(List<ElementDefinition> list) {
    for (ElementDefinition ed : list)
      if (ed.hasMustSupport() && ed.getMustSupport())
        return true;
    return false;
  }



  private Row chooseChildRowByGroup(HierarchicalTableGenerator gen, Row row, List<ElementChoiceGroup> groups, ElementDefinition element, ElementDefinition parent, boolean isConstraintMode) {
    String name = tail(element.getPath());
    for (ElementChoiceGroup grp : groups) {
      if (grp.getElements().contains(name)) {
        if (grp.getRow() == null) {
          grp.setRow(makeChoiceElementRow(gen, row, grp, parent, isConstraintMode));
        }
        return grp.getRow();
      }
    }
    return row;
  }

  private Row makeChoiceElementRow(HierarchicalTableGenerator gen, Row prow, ElementChoiceGroup grp, ElementDefinition parent, boolean isConstraintMode) {
    if (context.getStructureMode() != StructureDefinitionRendererMode.SUMMARY) {
      return prow;
    }
    Row row = gen.new Row();
    row.setAnchor(parent.getPath()+"-"+grp.getName());
    row.setColor(context.getProfileUtilities().getRowColor(parent, isConstraintMode));
    row.setLineColor(1);
    row.setIcon("icon_choice.gif", HierarchicalTableGenerator.TEXT_ICON_CHOICE);
    row.getCells().add(gen.new Cell(null, null, "(Choice of one)", "", null));
    row.getCells().add(gen.new Cell());
    row.getCells().add(gen.new Cell(null, null, (grp.isMandatory() ? "1" : "0")+"..1", "", null));
    row.getCells().add(gen.new Cell());
    row.getCells().add(gen.new Cell());
    prow.getSubRows().add(row);
    return row;
  }


  private void insertMissingSparseElements(List<ElementDefinition> list) {
    int i = 1;
    while (i < list.size()) {
      String[] pathCurrent = list.get(i).getPath().split("\\.");
      String[] pathLast = list.get(i-1).getPath().split("\\.");
      int firstDiff = 0; // the first entry must be a match
      while (firstDiff < pathCurrent.length && firstDiff < pathLast.length && pathCurrent[firstDiff].equals(pathLast[firstDiff])) {
        firstDiff++;
      }
      if (!(isSibling(pathCurrent, pathLast, firstDiff) || isChild(pathCurrent, pathLast, firstDiff))) {
        // now work backwards down to lastMatch inserting missing path nodes
        ElementDefinition parent = findParent(list, i, list.get(i).getPath());
        int parentDepth = Utilities.charCount(parent.getPath(), '.')+1;
        int childDepth =  Utilities.charCount(list.get(i).getPath(), '.')+1;
        if (childDepth > parentDepth + 1) {
          String basePath = parent.getPath();
          String baseId = parent.getId();
          for (int index = parentDepth; index >= firstDiff; index--) {
            String mtail = makeTail(pathCurrent, parentDepth, index);
            ElementDefinition root = new ElementDefinition().setPath(basePath+"."+mtail);
            root.setId(baseId+"."+mtail);
            list.add(i, root);
          }
        }
      } 
      i++;
    }
  }


  private String urltail(String path) {
    if (path.contains("#"))
      return path.substring(path.lastIndexOf('#')+1);
    if (path.contains("/"))
      return path.substring(path.lastIndexOf('/')+1);
    else
      return path;

  }

  private boolean standardExtensionSlicing(ElementDefinition element) {
    String t = tail(element.getPath());
    return (t.equals("extension") || t.equals("modifierExtension"))
        && element.getSlicing().getRules() != SlicingRules.CLOSED && element.getSlicing().getDiscriminator().size() == 1 && element.getSlicing().getDiscriminator().get(0).getPath().equals("url") && element.getSlicing().getDiscriminator().get(0).getType().equals(DiscriminatorType.VALUE);
  }

  public Cell generateDescription(HierarchicalTableGenerator gen, Row row, ElementDefinition definition, ElementDefinition fallback, boolean used, String baseURL, String url, StructureDefinition profile, String corePath, String imagePath, boolean root, boolean logicalModel, boolean allInvariants, boolean snapshot, boolean mustSupportOnly, boolean allowSubRows, RenderingContext rc) throws IOException, FHIRException {
    return generateDescription(gen, row, definition, fallback, used, baseURL, url, profile, corePath, imagePath, root, logicalModel, allInvariants, null, snapshot, mustSupportOnly, allowSubRows, rc);
  }

  public Cell generateDescription(HierarchicalTableGenerator gen, Row row, ElementDefinition definition, ElementDefinition fallback, boolean used, String baseURL, String url, StructureDefinition profile, String corePath, String imagePath, boolean root, boolean logicalModel, boolean allInvariants, ElementDefinition valueDefn, boolean snapshot, boolean mustSupportOnly, boolean allowSubRows, RenderingContext rc) throws IOException, FHIRException {
    Cell c = gen.new Cell();
    row.getCells().add(c);

    if (used) {
      if (logicalModel && ToolingExtensions.hasExtension(profile, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace")) {
        if (root) {
          c.getPieces().add(gen.new Piece(null, translate("sd.table", "XML Namespace")+": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, ToolingExtensions.readStringExtension(profile, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace"), null));        
        } else if (!root && ToolingExtensions.hasExtension(definition, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace") && 
            !ToolingExtensions.readStringExtension(definition, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace").equals(ToolingExtensions.readStringExtension(profile, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace"))) {
          c.getPieces().add(gen.new Piece(null, translate("sd.table", "XML Namespace")+": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, ToolingExtensions.readStringExtension(definition, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace"), null));        
        }
      }
      if (root) {
        if (profile != null && profile.getAbstract()) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.addPiece(gen.new Piece(null, "This is an abstract "+(profile.getDerivation() == TypeDerivationRule.CONSTRAINT ? "profile" : "type")+". ", null));

          List<StructureDefinition> children = new ArrayList<>();
          for (StructureDefinition sd : context.getWorker().fetchResourcesByType(StructureDefinition.class)) {
            if (sd.hasBaseDefinition() && sd.getBaseDefinition().equals(profile.getUrl())) {
              children.add(sd);
            }
          }
          if (!children.isEmpty()) {
            c.addPiece(gen.new Piece(null, "Child "+(profile.getDerivation() == TypeDerivationRule.CONSTRAINT ? "profiles" : "types")+": ", null));
            boolean first = true;
            for (StructureDefinition sd : children) {
              if (first) first = false; else c.addPiece(gen.new Piece(null, ", ", null));
              c.addPiece(gen.new Piece(sd.getWebPath(), sd.getName(), null));
            }
          }
        }
      }
      if (definition.getPath().endsWith("url") && definition.hasFixed()) {
        c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, "\""+buildJson(definition.getFixed())+"\"", null).addStyle("color: darkgreen")));
      } else {
        if (definition != null && definition.hasShort()) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.addPiece(checkForNoChange(definition.getShortElement(), gen.new Piece(null, gt(definition.getShortElement()), null)));
        } else if (fallback != null && fallback.hasShort()) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.addPiece(gen.new Piece(null, gt(fallback.getShortElement()), null).addStyle("opacity: 0.5"));
        }
        if (url != null) {
          if (!c.getPieces().isEmpty()) 
            c.addPiece(gen.new Piece("br"));
          String fullUrl = url.startsWith("#") ? baseURL+url : url;
          StructureDefinition ed = context.getWorker().fetchResource(StructureDefinition.class, url, profile);
          String ref = null;
          String ref2 = null;
          String fixedUrl = null;
          if (ed != null) {
            String p = ed.getWebPath();
            if (p != null) {
              ref = p.startsWith("http:") || context.getRules() == GenerationRules.IG_PUBLISHER ? p : Utilities.pathURL(corePath, p);
            }             
            fixedUrl = getFixedUrl(ed);
            if (fixedUrl != null) {// if its null, we guess that it's not a profiled extension?
              if (fixedUrl.equals(url))
                fixedUrl = null;
              else {
                StructureDefinition ed2 = context.getWorker().fetchResource(StructureDefinition.class, fixedUrl);
                if (ed2 != null) {
                  String p2 = ed2.getWebPath();
                  if (p2 != null) {
                    ref2 = p2.startsWith("http:") || context.getRules() == GenerationRules.IG_PUBLISHER ? p2 : Utilities.pathURL(corePath, p2);
                  }                              
                }
              }
            }
          }
          if (fixedUrl == null) {
            if (!Utilities.noString(fullUrl)) {
              c.getPieces().add(gen.new Piece(null, translate("sd.table", "URL")+": ", null).addStyle("font-weight:bold"));
              c.getPieces().add(gen.new Piece(ref, fullUrl, null));
            }
          } else { 
            // reference to a profile take on the extension show the base URL
            c.getPieces().add(gen.new Piece(null, translate("sd.table", "URL")+": ", null).addStyle("font-weight:bold"));
            c.getPieces().add(gen.new Piece(ref2, fixedUrl, null));
            c.getPieces().add(gen.new Piece(null, translate("sd.table", " profiled by ")+" ", null).addStyle("font-weight:bold"));
            c.getPieces().add(gen.new Piece(ref, fullUrl, null));

          }
        }

        if (definition.hasSlicing()) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.getPieces().add(gen.new Piece(null, translate("sd.table", "Slice")+": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, describeSlice(definition.getSlicing()), null));
        }
        if (!definition.getPath().contains(".") && ToolingExtensions.hasExtension(profile, ToolingExtensions.EXT_BINDING_STYLE)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.getPieces().add(gen.new Piece(null, translate("sd.table", "Binding")+": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, "This type can be bound to a value set using the ", null));
          c.getPieces().add(gen.new Piece(null, ToolingExtensions.readStringExtension(profile, ToolingExtensions.EXT_BINDING_STYLE), null));
          c.getPieces().add(gen.new Piece(null, " binding style", null));            
        }
        if (definition.hasValueAlternatives()) {
          addCanonicalList(gen, c, definition.getValueAlternatives(), "The primitive value may be replaced by the extension", true);
        }
        if (definition.hasExtension(ToolingExtensions.EXT_IMPLIED_PREFIX)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.getPieces().add(gen.new Piece(null, "When this element is read ", null));          
          Piece piece = gen.new Piece("code");
          piece.addHtml(new XhtmlNode(NodeType.Text).setContent(ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_IMPLIED_PREFIX)));
          c.getPieces().add(piece);          
          c.getPieces().add(gen.new Piece(null, " is prefixed to the value before validation", null));          
        }

        if (definition.hasExtension(ToolingExtensions.EXT_EXTENSION_STYLE)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          String es = definition.getExtensionString(ToolingExtensions.EXT_EXTENSION_STYLE);
          if ("named-elements".equals(es)) {
            if (rc.hasLink(KnownLinkType.JSON_NAMES)) {
              c.getPieces().add(gen.new Piece(rc.getLink(KnownLinkType.JSON_NAMES), "This element can be extended by named JSON elements", null));                        
            } else {
              c.getPieces().add(gen.new Piece(ToolingExtensions.WEB_EXTENSION_STYLE, "This element can be extended by named JSON elements", null));                        
            }
          }
        }
        if (definition.hasExtension(ToolingExtensions.EXT_DATE_FORMAT)) {
          String df = ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_DATE_FORMAT);
          if (df != null) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(gen.new Piece(null, "Date Format: "+df, null));
          }
        }
        if (definition.hasExtension(ToolingExtensions.EXT_ID_EXPECTATION)) {
          String ide = ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_ID_EXPECTATION);
          if (ide.equals("optional")) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(gen.new Piece(null, "Id may or not be present (this is the default for elements but not resources)", null));     
          } else if (ide.equals("required")) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(gen.new Piece(null, "Id is required to be present (this is the default for resources but not elements)", null));     
          } else if (ide.equals("required")) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(gen.new Piece(null, "An ID is not allowed in this context", null));     
          }
        }
        if (definition.hasExtension(ToolingExtensions.EXT_XML_NAME)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          if (definition.hasExtension(ToolingExtensions.EXT_XML_NAMESPACE)) {
            c.getPieces().add(gen.new Piece(null, translate("sd.table", "XML")+": ", null).addStyle("font-weight:bold"));
            c.getPieces().add(gen.new Piece(null, definition.getExtensionString(ToolingExtensions.EXT_XML_NAME), null));
            c.getPieces().add(gen.new Piece(null, " (", null));
            c.getPieces().add(gen.new Piece(null, definition.getExtensionString(ToolingExtensions.EXT_XML_NAMESPACE), null));
            c.getPieces().add(gen.new Piece(null, ")", null));            
          } else {
            c.getPieces().add(gen.new Piece(null, translate("sd.table", "XML Element Name")+": ", null).addStyle("font-weight:bold"));
            c.getPieces().add(gen.new Piece(null, definition.getExtensionString(ToolingExtensions.EXT_XML_NAME), null));
          }            
        } else if (definition.hasExtension(ToolingExtensions.EXT_XML_NAMESPACE)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.getPieces().add(gen.new Piece(null, translate("sd.table", "XML Namespace")+": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, definition.getExtensionString(ToolingExtensions.EXT_XML_NAMESPACE), null));          
        }
        if (definition.hasExtension(ToolingExtensions.EXT_JSON_EMPTY)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          String code = ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_JSON_EMPTY);
          if ("present".equals(code)) {
            c.getPieces().add(gen.new Piece(null, "JSON: This element is present as a JSON Array even when there are no items in the instance", null));     
          } else {
            c.getPieces().add(gen.new Piece(null, "JSON: This element may be present as a JSON Array even when there are no items in the instance", null));     
          }
        }
        String jn = ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_JSON_NAME);
        if (!Utilities.noString(jn)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          if (definition.getPath().contains(".")) {
            c.getPieces().add(gen.new Piece(null, translate("sd.table", "JSON Property Name")+": ", null).addStyle("font-weight:bold"));
            c.getPieces().add(gen.new Piece(null, jn, null));
          } else {
            c.getPieces().add(gen.new Piece(null, translate("sd.table", "JSON Property Name for Type")+": ", null).addStyle("font-weight:bold"));
            Piece piece = gen.new Piece("code");
            piece.addHtml(new XhtmlNode(NodeType.Text).setContent(jn));
            c.getPieces().add(piece);            
          }
        }

        if (ToolingExtensions.readBoolExtension(definition, ToolingExtensions.EXT_JSON_PRIMITIVE_CHOICE)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.getPieces().add(gen.new Piece(null, "JSON: The type of this element is inferred from the JSON type in the instance", null));     
        }
        if (ToolingExtensions.readBoolExtension(definition, ToolingExtensions.EXT_JSON_NULLABLE)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.getPieces().add(gen.new Piece(null, "JSON: This object can be represented as null in the JSON structure (which counts as 'present' for cardinality purposes)", null));     
        }
        if (definition.hasExtension(ToolingExtensions.EXT_JSON_PROP_KEY)) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          String code = ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_JSON_PROP_KEY);
          c.getPieces().add(gen.new Piece(null, "JSON: Represented as a single JSON Object with named properties using the value of the "+code+" child as the key", null));     
        }      
        if (definition.hasExtension(ToolingExtensions.EXT_TYPE_SPEC)) {
          for (Extension e : definition.getExtensionsByUrl(ToolingExtensions.EXT_TYPE_SPEC)) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            String cond = ToolingExtensions.readStringExtension(e, "condition");
            String type = ToolingExtensions.readStringExtension(e, "type");
            c.getPieces().add(gen.new Piece(null, "JSON: If ", null));          
            Piece piece = gen.new Piece("code");
            piece.addHtml(new XhtmlNode(NodeType.Text).setContent(cond));
            c.getPieces().add(piece);          
            c.getPieces().add(gen.new Piece(null, "then the type is ", null));          
            StructureDefinition sd = context.getWorker().fetchTypeDefinition(type);
            if (sd == null) {
              c.getPieces().add(gen.new Piece("<code>"));          
              c.getPieces().add(gen.new Piece(null, type, null));          
              c.getPieces().add(gen.new Piece("</code>"));          
            } else {
              c.getPieces().add(gen.new Piece(sd.getWebPath(), sd.getTypeName(), null));          
            }
          }
        }
        if (root) {
          if (ToolingExtensions.readBoolExtension(profile, ToolingExtensions.EXT_OBLIGATION_PROFILE_FLAG)) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.addPiece(gen.new Piece(null, "This is an obligation profile that only contains obligations and additional bindings", null).addStyle("font-weight:bold"));          
          }
          addCanonicalListExt(gen, c, profile.getExtensionsByUrl(ToolingExtensions.EXT_OBLIGATION_INHERITS), "This profile picks up obligations and additional bindings from the profile", true);
          addCanonicalListExt(gen, c, profile.getExtensionsByUrl(ToolingExtensions.EXT_SD_IMPOSE_PROFILE), "This profile also imposes the profile", true);
          addCanonicalListExt(gen, c, profile.getExtensionsByUrl(ToolingExtensions.EXT_SD_COMPLIES_WITH_PROFILE), "This profile also complies with the profile", true);

          if (profile.getKind() == StructureDefinitionKind.LOGICAL) {
            Extension lt = ToolingExtensions.getExtension(profile, ToolingExtensions.EXT_LOGICAL_TARGET);
            if (lt == null || !lt.hasValueBooleanType()) {
              if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
              c.addPiece(gen.new Piece(null, "Instances of this logical model are not marked to be the target of a Reference", null).addStyle("font-weight:bold"));  ;        
            } else if (lt.getValue().hasExtension(ToolingExtensions.DAR)) {                 
            } else if (!lt.getValueBooleanType().hasValue()) {
                if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
                c.addPiece(gen.new Piece(null, "Instances of this logical model are not marked to be the target of a Reference", null).addStyle("font-weight:bold"));  ;        
            } else if (lt.getValueBooleanType().booleanValue()) {
              if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
              c.addPiece(gen.new Piece(null, "Instances of this logical model can be the target of a Reference", null).addStyle("font-weight:bold"));        
            } else {
              if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
              c.addPiece(gen.new Piece(null, "Instances of this logical model cannot be the target of a Reference", null).addStyle("font-weight:bold"));  
            }            
          }
        }
        if (definition != null) {
          ElementDefinitionBindingComponent binding = null;
          if (valueDefn != null && valueDefn.hasBinding() && !valueDefn.getBinding().isEmpty())
            binding = makeUnifiedBinding(valueDefn.getBinding(), valueDefn);
          else if (definition.hasBinding())
            binding = makeUnifiedBinding(definition.getBinding(), definition);
          if (binding!=null && !binding.isEmpty()) {
            if (!c.getPieces().isEmpty()) 
              c.addPiece(gen.new Piece("br"));
            BindingResolution br = context.getPkp() == null ? makeNullBr(binding) : context.getPkp().resolveBinding(profile, binding, definition.getPath());
            c.getPieces().add(checkForNoChange(binding, gen.new Piece(null, translate("sd.table", "Binding")+": ", null).addStyle("font-weight:bold")));
            c.getPieces().add(checkForNoChange(binding.getValueSetElement(), gen.new Piece(br.url == null ? null : Utilities.isAbsoluteUrl(br.url) || !context.getPkp().prependLinks() ? br.url : corePath+br.url, br.display, null)));
            if (binding.hasStrength()) {
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece(null, " (", null)));
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece(corePath+"terminologies.html#"+binding.getStrength().toCode(), egt(binding.getStrengthElement()), binding.getStrength().getDefinition())));                            
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece(null, ")", null)));
            }
            if (binding.hasDescription() && MarkDownProcessor.isSimpleMarkdown(binding.getDescription())) {
              c.getPieces().add(gen.new Piece(null, ": ", null));
              c.addMarkdownNoPara(PublicationHacker.fixBindingDescriptions(context.getWorker(), binding.getDescriptionElement()).asStringValue(), checkForNoChange(PublicationHacker.fixBindingDescriptions(context.getWorker(), binding.getDescriptionElement())));
            } 

            AdditionalBindingsRenderer abr = new AdditionalBindingsRenderer(context.getPkp(), corePath, profile, definition.getPath(), rc, null, this);
            if (binding.hasExtension(ToolingExtensions.EXT_MAX_VALUESET)) {
              abr.seeMaxBinding(ToolingExtensions.getExtension(binding, ToolingExtensions.EXT_MAX_VALUESET));
            }
            if (binding.hasExtension(ToolingExtensions.EXT_MIN_VALUESET)) {
              abr.seeMinBinding(ToolingExtensions.getExtension(binding, ToolingExtensions.EXT_MIN_VALUESET));
            }
            if (binding.hasExtension(ToolingExtensions.EXT_BINDING_ADDITIONAL)) {
              abr.seeAdditionalBindings(binding.getExtensionsByUrl(ToolingExtensions.EXT_BINDING_ADDITIONAL));
            }
            abr.render(gen, c);
          }
          for (ElementDefinitionConstraintComponent inv : definition.getConstraint()) {
            if (!inv.hasSource() || profile == null || inv.getSource().equals(profile.getUrl()) || allInvariants) {
              if (!c.getPieces().isEmpty()) 
                c.addPiece(gen.new Piece("br"));
              c.getPieces().add(checkForNoChange(inv, gen.new Piece(null, inv.getKey()+": ", null).addStyle("font-weight:bold")));
              c.getPieces().add(checkForNoChange(inv, gen.new Piece(null, gt(inv.getHumanElement()), null)));
            }
          }
          if ((definition.hasBase() && "*".equals(definition.getBase().getMax())) || (definition.hasMax() && "*".equals(definition.getMax()))) {
            if (c.getPieces().size() > 0)
              c.addPiece(gen.new Piece("br"));
            if (definition.hasOrderMeaning()) {
              c.getPieces().add(gen.new Piece(null, "This repeating element order: "+definition.getOrderMeaning(), null));
            } else {
              // don't show this, this it's important: c.getPieces().add(gen.new Piece(null, "This repeating element has no defined order", null));
            }           
          }
          if (definition.hasFixed()) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, translate("sd.table", "Fixed Value")+": ", null).addStyle("font-weight:bold")));
            if (!useTableForFixedValues || !allowSubRows || definition.getFixed().isPrimitive()) {
              String s = buildJson(definition.getFixed());
              String link = null;
              if (Utilities.isAbsoluteUrl(s) && context.getPkp() != null)
                link = context.getPkp().getLinkForUrl(corePath, s);
              c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(link, s, null).addStyle("color: darkgreen")));
            } else {
              c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, "As shown", null).addStyle("color: darkgreen")));
              genFixedValue(gen, row, definition.getFixed(), snapshot, false, corePath, false);
            }
            if (isCoded(definition.getFixed()) && !hasDescription(definition.getFixed())) {
              Piece p = describeCoded(gen, definition.getFixed());
              if (p != null)
                c.getPieces().add(p);
            }
          } else if (definition.hasPattern()) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, translate("sd.table", "Required Pattern")+": ", null).addStyle("font-weight:bold")));
            if (!useTableForFixedValues || !allowSubRows || definition.getPattern().isPrimitive())
              c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, buildJson(definition.getPattern()), null).addStyle("color: darkgreen")));
            else {
              c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, "At least the following", null).addStyle("color: darkgreen")));
              genFixedValue(gen, row, definition.getPattern(), snapshot, true, corePath, mustSupportOnly);
            }
          } else if (definition.hasExample()) {
            for (ElementDefinitionExampleComponent ex : definition.getExample()) {
              if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
              c.getPieces().add(checkForNoChange(ex, gen.new Piece(null, translate("sd.table", "Example")+("".equals("General")? "" : " "+ex.getLabel())+": ", null).addStyle("font-weight:bold")));
              c.getPieces().add(checkForNoChange(ex, gen.new Piece(null, buildJson(ex.getValue()), null).addStyle("color: darkgreen")));
            }
          }

          ObligationsRenderer obr = new ObligationsRenderer(corePath, profile, definition.getPath(), rc, null, this);
          if (definition.hasExtension(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS)) {
            obr.seeObligations(definition.getExtensionsByUrl(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS));
          }
          if (!definition.getPath().contains(".") && profile.hasExtension(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS)) {
            obr.seeObligations(profile.getExtensionsByUrl(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS));
          }
          obr.renderTable(gen, c);

          if (definition.hasMaxLength() && definition.getMaxLength()!=0) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(checkForNoChange(definition.getMaxLengthElement(), gen.new Piece(null, "Max Length: ", null).addStyle("font-weight:bold")));
            c.getPieces().add(checkForNoChange(definition.getMaxLengthElement(), gen.new Piece(null, Integer.toString(definition.getMaxLength()), null).addStyle("color: darkgreen")));
          }
          if (profile != null) {
            for (StructureDefinitionMappingComponent md : profile.getMapping()) {
              if (md.hasExtension(ToolingExtensions.EXT_TABLE_NAME)) {
                ElementDefinitionMappingComponent map = null;
                for (ElementDefinitionMappingComponent m : definition.getMapping()) 
                  if (m.getIdentity().equals(md.getIdentity()))
                    map = m;
                if (map != null) {
                  for (int i = 0; i<definition.getMapping().size(); i++){
                    c.addPiece(gen.new Piece("br"));
                    c.getPieces().add(gen.new Piece(null, ToolingExtensions.readStringExtension(md, ToolingExtensions.EXT_TABLE_NAME)+": " + map.getMap(), null));
                  }
                }
              }
            }
          }
        }
      }
    }
    return c;
  }


  private void addCanonicalListExt(HierarchicalTableGenerator gen, Cell c, List<Extension> list, String start, boolean bold) {
    List<CanonicalType> clist = new ArrayList<>();
    for (Extension ext : list) {
      if (ext.hasValueCanonicalType()) {
        clist.add(ext.getValueCanonicalType());
      }
    }
    addCanonicalList(gen, c, clist, start, bold);
  }
  
  private void addCanonicalList(HierarchicalTableGenerator gen, Cell c, List<CanonicalType> list, String start, boolean bold) {
    if (!list.isEmpty()) {

      if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
      Piece p = gen.new Piece(null, start+(list.size() != 1 ? "s" : "")+" ", null);
      c.addPiece(p);
      if (bold) p.addStyle("font-weight:bold");
      
      for (int i = 0; i < list.size(); i++) {
        CanonicalType ct = list.get(i);
        if (i > 0) {
          if (i < list.size() - 1) {
            c.addPiece(gen.new Piece(null, ", ", null));                      
          } else {
            c.addPiece(gen.new Piece(null, " and ", null));                      
          }
        }
        String iu = ct.primitiveValue();
        StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, iu);
        if (sd == null) {
          p = gen.new Piece(null, iu, null).addStyle("font-weight:bold");
          c.addPiece(p);                      
        } else if (sd.hasWebPath()) {
          p = gen.new Piece(sd.getWebPath(), sd.present(), null).addStyle("font-weight:bold");
          c.addPiece(p);                      
        } else {
          p = gen.new Piece(iu, sd.present(), null).addStyle("font-weight:bold");
          c.addPiece(p);                      
        }
        if (bold) p.addStyle("font-weight:bold");
      }
    }    
  }

  private Piece checkForNoChange(Element source, Piece piece) {
    if (source.hasUserData(ProfileUtilities.UD_DERIVATION_EQUALS)) {
      piece.addStyle("opacity: 0.5");
    }
    return piece;
  }

  private String checkForNoChange(Element source) {
    if (source.hasUserData(ProfileUtilities.UD_DERIVATION_EQUALS)) {
      return "opacity: 0.5";
    } else { 
      return null;
    }
  }

  private Cell genTypes(HierarchicalTableGenerator gen, Row r, ElementDefinition e, String profileBaseFileName, StructureDefinition profile, String corePath, String imagePath, boolean root, boolean mustSupportMode) {
    Cell c = gen.new Cell();
    r.getCells().add(c);
    if (e.hasContentReference()) {
      ElementInStructure ed = getElementByName(profile.getSnapshot().getElement(), e.getContentReference(), profile);
      if (ed == null)
        c.getPieces().add(gen.new Piece(null, translate("sd.table", "Unknown reference to %s", e.getContentReference()), null));
      else {
        if (ed.getSource() == profile) {
          c.getPieces().add(gen.new Piece(null, translate("sd.table", "See ", ed.getElement().getPath()), null));
          c.getPieces().add(gen.new Piece("#"+ed.getElement().getPath(), tail(ed.getElement().getPath()), ed.getElement().getPath()));
        } else {
          c.getPieces().add(gen.new Piece(null, translate("sd.table", "See ", ed.getElement().getPath()), null));
          c.getPieces().add(gen.new Piece(pfx(corePath, ed.getSource().getWebPath())+"#"+ed.getElement().getPath(), tail(ed.getElement().getPath())+" ("+ed.getSource().getTypeName()+")", ed.getElement().getPath()));
        }
      }
      return c;
    }
    List<TypeRefComponent> types = e.getType();
    if (!e.hasType()) {
      if (root) { // we'll use base instead of types then
        StructureDefinition bsd = profile == null ? null : context.getWorker().fetchResource(StructureDefinition.class, profile.getBaseDefinition(), profile);
        if (bsd != null) {
          if (bsd.hasWebPath()) {
            c.getPieces().add(gen.new Piece(Utilities.isAbsoluteUrl(bsd.getWebPath()) ? bsd.getWebPath() : imagePath +bsd.getWebPath(), bsd.getName(), null));
          } else {
            c.getPieces().add(gen.new Piece(null, bsd.getName(), null));
          }
        }
        return c;
      } else if (e.hasContentReference()) {
        return c;
      } else {
        ElementDefinition d = (ElementDefinition) e.getUserData(ProfileUtilities.UD_DERIVATION_POINTER);
        if (d != null && d.hasType()) {
          types = new ArrayList<ElementDefinition.TypeRefComponent>();
          for (TypeRefComponent tr : d.getType()) {
            TypeRefComponent tt = tr.copy();
            tt.setUserData(ProfileUtilities.UD_DERIVATION_EQUALS, true);
            types.add(tt);
          }
        } else {
          return c;
        }
      }
    }

    boolean first = true;

    TypeRefComponent tl = null;
    for (TypeRefComponent t : types) {
      if (!mustSupportMode || allTypesMustSupport(e) || isMustSupport(t)) {
        if (first) {
          first = false;
        } else {
          c.addPiece(checkForNoChange(tl, gen.new Piece(null,", ", null)));
        }
        tl = t;
        if (t.hasTarget()) {
          c.getPieces().add(gen.new Piece(corePath+"references.html", t.getWorkingCode(), null));
          if (!mustSupportMode && isMustSupportDirect(t) && e.getMustSupport()) {
            c.addPiece(gen.new Piece(null, " ", null));
            c.addStyledText(translate("sd.table", "This type must be supported"), "S", "white", "red", null, false);
          }
          c.getPieces().add(gen.new Piece(null, "(", null));
          boolean tfirst = true;
          for (CanonicalType u : t.getTargetProfile()) {
            if (!mustSupportMode || allProfilesMustSupport(t.getTargetProfile()) || isMustSupport(u)) {
              if (tfirst)
                tfirst = false;
              else
                c.addPiece(gen.new Piece(null, " | ", null));
              genTargetLink(gen, profileBaseFileName, corePath, c, t, u.getValue(), null);
              if (!mustSupportMode && isMustSupport(u) && e.getMustSupport()) {
                c.addPiece(gen.new Piece(null, " ", null));
                c.addStyledText(translate("sd.table", "This target must be supported"), "S", "white", "red", null, false);
              }
            }
          }
          c.getPieces().add(gen.new Piece(null, ")", null));
          if (t.getAggregation().size() > 0) {
            c.getPieces().add(gen.new Piece(corePath+"valueset-resource-aggregation-mode.html", " {", null));
            boolean firstA = true;
            for (Enumeration<AggregationMode> a : t.getAggregation()) {
              if (firstA == true)
                firstA = false;
              else
                c.getPieces().add(gen.new Piece(corePath+"valueset-resource-aggregation-mode.html", ", ", null));
              c.getPieces().add(gen.new Piece(corePath+"valueset-resource-aggregation-mode.html", codeForAggregation(a.getValue()), hintForAggregation(a.getValue())));
            }
            c.getPieces().add(gen.new Piece(corePath+"valueset-resource-aggregation-mode.html", "}", null));
          }
        } else if (t.hasProfile() && (!t.getWorkingCode().equals("Extension") || isProfiledType(t.getProfile()))) { // a profiled type
          String ref;
          boolean pfirst = true;
          for (CanonicalType p : t.getProfile()) {
            if (!mustSupportMode || allProfilesMustSupport(t.getProfile()) || isMustSupport(p)) {
              if (pfirst) {
                pfirst = false;
              } else {
                c.addPiece(checkForNoChange(tl, gen.new Piece(null,", ", null)));
              }          

              ref = context.getPkp() == null ? null : context.getPkp().getLinkForProfile(profile, p.getValue());
              if (ref != null) {
                String[] parts = ref.split("\\|");
                if (parts[0].startsWith("http:") || parts[0].startsWith("https:")) {
                  if (p.hasExtension(ToolingExtensions.EXT_PROFILE_ELEMENT)) {
                    String pp = p.getExtensionString(ToolingExtensions.EXT_PROFILE_ELEMENT);
                    pp = pp.substring(pp.indexOf("."));
                    c.addPiece(checkForNoChange(t, gen.new Piece(parts[0], parts[1]+pp, t.getWorkingCode())));
                  } else {
                    c.addPiece(checkForNoChange(t, gen.new Piece(parts[0], parts[1], t.getWorkingCode())));
                  }
                } else {
                  c.addPiece(checkForNoChange(t, gen.new Piece((p.getValue().startsWith(corePath+"StructureDefinition")? corePath: "")+parts[0], parts[1], t.getWorkingCode())));
                }
              } else {
                c.addPiece(checkForNoChange(t, gen.new Piece((p.getValue().startsWith(corePath)? corePath: "")+ref, t.getWorkingCode(), null)));
              }
              if (!mustSupportMode && isMustSupport(p) && e.getMustSupport()) {
                c.addPiece(gen.new Piece(null, " ", null));
                c.addStyledText(translate("sd.table", "This profile must be supported"), "S", "white", "red", null, false);
              }
            }
          }
        } else {
          String tc = t.getWorkingCode();
          if (Utilities.isAbsoluteUrl(tc)) {
            StructureDefinition sd = context.getWorker().fetchTypeDefinition(tc);
            if (sd == null) {
              c.addPiece(checkForNoChange(t, gen.new Piece(context.getPkp().getLinkFor(corePath, tc), tc, null)));
            } else {
              c.addPiece(checkForNoChange(t, gen.new Piece(context.getPkp().getLinkFor(corePath, tc), sd.getTypeName(), null)));           
            }
          } else if (context.getPkp() != null && context.getPkp().hasLinkFor(tc)) {
            c.addPiece(checkForNoChange(t, gen.new Piece(context.getPkp().getLinkFor(corePath, tc), tc, null)));
          } else {
            c.addPiece(checkForNoChange(t, gen.new Piece(null, tc, null)));
          }
          if (!mustSupportMode && isMustSupportDirect(t) && e.getMustSupport()) {
            c.addPiece(gen.new Piece(null, " ", null));
            c.addStyledText(translate("sd.table", "This type must be supported"), "S", "white", "red", null, false);
          }
        }
      }
    }
    return c;
  }


  private String pfx(String prefix, String url) {
    return Utilities.isAbsoluteUrl(url) ? url : prefix + url;
  }

  private void genTargetLink(HierarchicalTableGenerator gen, String profileBaseFileName, String corePath, Cell c, TypeRefComponent t, String u, Resource src) {
    if (u.startsWith("http://hl7.org/fhir/StructureDefinition/")) {
      StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, u, src);
      if (sd != null) {
        String disp = sd.hasTitle() ? sd.getTitle() : sd.getName();
        c.addPiece(checkForNoChange(t, gen.new Piece(checkPrepend(corePath, sd.getWebPath()), disp, null)));
      } else {
        String rn = u.substring(40);
        c.addPiece(checkForNoChange(t, gen.new Piece(context.getPkp().getLinkFor(corePath, rn), rn, null)));
      }
    } else if (Utilities.isAbsoluteUrl(u)) {
      StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, u, src);
      if (sd != null && context.getPkp() != null) {
        String disp = sd.hasTitle() ? sd.getTitle() : sd.getName();
        String ref = context.getPkp().getLinkForProfile(null, sd.getUrl());
        if (ref != null && ref.contains("|"))
          ref = ref.substring(0,  ref.indexOf("|"));
        c.addPiece(checkForNoChange(t, gen.new Piece(ref, disp, null)));
      } else
        c.addPiece(checkForNoChange(t, gen.new Piece(null, u, null)));        
    } else if (t.hasTargetProfile() && u.startsWith("#"))
      c.addPiece(checkForNoChange(t, gen.new Piece(corePath+profileBaseFileName+"."+u.substring(1).toLowerCase()+".html", u, null)));
  }

  private boolean isProfiledType(List<CanonicalType> theProfile) {
    for (CanonicalType next : theProfile){
      if (StringUtils.defaultString(next.getValueAsString()).contains(":")) {
        return true;
      }
    }
    return false;
  }


  public String codeForAggregation(AggregationMode a) {
    switch (a) {
    case BUNDLED : return "b";
    case CONTAINED : return "c";
    case REFERENCED: return "r";
    default: return "?";
    }
  }

  public String hintForAggregation(AggregationMode a) {
    if (a != null)
      return a.getDefinition();
    else 
      return null;
  }


  private String checkPrepend(String corePath, String path) {
    if (context.getPkp() != null && context.getPkp().prependLinks() && !(path.startsWith("http:") || path.startsWith("https:")))
      return corePath+path;
    else 
      return path;
  }


  private ElementDefinition findParent(List<ElementDefinition> list, int i, String path) {
    while (i > 0 && !path.startsWith(list.get(i).getPath()+".")) {
      i--;
    }
    return list.get(i);
  }

  private boolean isSibling(String[] pathCurrent, String[] pathLast, int firstDiff) {
    return pathCurrent.length == pathLast.length && firstDiff == pathCurrent.length-1;
  }


  private boolean isChild(String[] pathCurrent, String[] pathLast, int firstDiff) {
    return pathCurrent.length == pathLast.length+1 && firstDiff == pathLast.length;
  }

  private String makeTail(String[] pathCurrent, int start, int index) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(".");
    for (int i = start; i <= index; i++) {
      b.append(pathCurrent[i]);
    }
    return b.toString();
  }

  private void genGridElement(String defPath, HierarchicalTableGenerator gen, List<Row> rows, ElementDefinition element, List<ElementDefinition> all, List<StructureDefinition> profiles, boolean showMissing, String profileBaseFileName, Boolean extensions, String corePath, String imagePath, boolean root, boolean isConstraintMode) throws IOException, FHIRException {
    StructureDefinition profile = profiles == null ? null : profiles.get(profiles.size()-1);
    String s = tail(element.getPath());
    List<ElementDefinition> children = getChildren(all, element);
    boolean isExtension = (s.equals("extension") || s.equals("modifierExtension"));

    if (!onlyInformationIsMapping(all, element)) {
      Row row = gen.new Row();
      row.setAnchor(element.getPath());
      row.setColor(context.getProfileUtilities().getRowColor(element, isConstraintMode));
      if (element.hasSlicing())
        row.setLineColor(1);
      else if (element.hasSliceName())
        row.setLineColor(2);
      else
        row.setLineColor(0);
      boolean hasDef = element != null;
      String ref = defPath == null ? null : defPath + element.getId();
      UnusedTracker used = new UnusedTracker();
      used.used = true;
      Cell left = gen.new Cell();
      if (element.getType().size() == 1 && element.getType().get(0).isPrimitive())
        left.getPieces().add(gen.new Piece(ref, "\u00A0\u00A0" + s, !hasDef ? null : gt(element.getDefinitionElement())).addStyle("font-weight:bold"));
      else
        left.getPieces().add(gen.new Piece(ref, "\u00A0\u00A0" + s, !hasDef ? null : gt(element.getDefinitionElement())));
      if (element.hasSliceName()) {
        left.getPieces().add(gen.new Piece("br"));
        String indent = StringUtils.repeat('\u00A0', 1+2*(element.getPath().split("\\.").length));
        left.getPieces().add(gen.new Piece(null, indent + "("+element.getSliceName() + ")", null));
      }
      row.getCells().add(left);

      genCardinality(gen, element, row, hasDef, used, null);
      if (hasDef && !"0".equals(element.getMax()))
        genTypes(gen, row, element, profileBaseFileName, profile, corePath, imagePath, root, false);
      else
        row.getCells().add(gen.new Cell());
      generateGridDescription(gen, row, element, null, used.used, null, null, profile, corePath, imagePath, root, null);
      /*      if (element.hasSlicing()) {
        if (standardExtensionSlicing(element)) {
          used.used = element.hasType() && element.getType().get(0).hasProfile();
          showMissing = false;
        } else {
          row.setIcon("icon_slice.png", HierarchicalTableGenerator.TEXT_ICON_SLICE);
          row.getCells().get(2).getPieces().clear();
          for (Cell cell : row.getCells())
            for (Piece p : cell.getPieces()) {
              p.addStyle("font-style: italic");
            }
        }
      }*/
      rows.add(row);
      for (ElementDefinition child : children)
        if (child.getMustSupport())
          genGridElement(defPath, gen, row.getSubRows(), child, all, profiles, showMissing, profileBaseFileName, isExtension, corePath, imagePath, false, isConstraintMode);
    }
  }


  private ExtensionContext locateExtension(Class<StructureDefinition> class1, String value)  {
    if (value.contains("#")) {
      StructureDefinition ext = context.getWorker().fetchResource(StructureDefinition.class, value.substring(0, value.indexOf("#")));
      if (ext == null)
        return null;
      String tail = value.substring(value.indexOf("#")+1);
      ElementDefinition ed = null;
      for (ElementDefinition ted : ext.getSnapshot().getElement()) {
        if (tail.equals(ted.getSliceName())) {
          ed = ted;
          return new ExtensionContext(ext, ed);
        }
      }
      return null;
    } else {
      StructureDefinition ext = context.getWorker().fetchResource(StructureDefinition.class, value);
      if (ext == null)
        return null;
      else 
        return new ExtensionContext(ext, ext.getSnapshot().getElement().get(0));
    }
  }


  private boolean extensionIsComplex(String value) {
    if (value.contains("#")) {
      StructureDefinition ext = context.getWorker().fetchResource(StructureDefinition.class, value.substring(0, value.indexOf("#")));
      if (ext == null)
        return false;
      String tail = value.substring(value.indexOf("#")+1);
      ElementDefinition ed = null;
      for (ElementDefinition ted : ext.getSnapshot().getElement()) {
        if (tail.equals(ted.getSliceName())) {
          ed = ted;
          break;
        }
      }
      if (ed == null)
        return false;
      int i = ext.getSnapshot().getElement().indexOf(ed);
      int j = i+1;
      while (j < ext.getSnapshot().getElement().size() && !ext.getSnapshot().getElement().get(j).getPath().equals(ed.getPath()))
        j++;
      return j - i > 5;
    } else {
      StructureDefinition ext = context.getWorker().fetchResource(StructureDefinition.class, value);
      return ext != null && ext.getSnapshot().getElement().size() > 5;
    }
  }




  private BindingResolution makeNullBr(ElementDefinitionBindingComponent binding) {
    BindingResolution br = new BindingResolution();
    br.url = "http://none.none/none";
    br.display = "todo";
    return br;
  }

  private ElementDefinitionBindingComponent makeUnifiedBinding(ElementDefinitionBindingComponent binding, ElementDefinition element) {
    if (!element.hasUserData(ProfileUtilities.UD_DERIVATION_POINTER)) {
      return binding;
    }
    ElementDefinition base = (ElementDefinition) element.getUserData(ProfileUtilities.UD_DERIVATION_POINTER);
    if (!base.hasBinding()) {
      return binding;
    }
    ElementDefinitionBindingComponent o = base.getBinding();
    ElementDefinitionBindingComponent b = new ElementDefinitionBindingComponent();
    b.setUserData(ProfileUtilities.UD_DERIVATION_POINTER, o);
    if (binding.hasValueSet()) {
      b.setValueSet(binding.getValueSet());
    } else if (o.hasValueSet()) {
      b.setValueSet(o.getValueSet());
      b.getValueSetElement().setUserData(ProfileUtilities.UD_DERIVATION_EQUALS, o.getValueSetElement());
    }
    if (binding.hasStrength()) {
      b.setStrength(binding.getStrength());
    } else if (o.hasStrength()) {
      b.setStrength(o.getStrength());
      b.getStrengthElement().setUserData(ProfileUtilities.UD_DERIVATION_EQUALS, o.getStrengthElement());
    }
    if (binding.hasDescription()) {
      b.setDescription(binding.getDescription());
    } else if (o.hasDescription()) {
      b.setDescription(o.getDescription());
      b.getDescriptionElement().setUserData(ProfileUtilities.UD_DERIVATION_EQUALS, o.getDescriptionElement());
    }
    // todo: derivation?
    b.getExtension().addAll(binding.getExtension());
    return b;
  }

  private void genFixedValue(HierarchicalTableGenerator gen, Row erow, DataType value, boolean snapshot, boolean pattern, String corePath, boolean skipnoValue) {
    String ref = context.getPkp().getLinkFor(corePath, value.fhirType());
    if (ref != null && ref.contains(".html")) {
      ref = ref.substring(0, ref.indexOf(".html"))+"-definitions.html#";
    } else {
      ref = "?gen-fv?";
    }
    StructureDefinition sd = context.getWorker().fetchTypeDefinition(value.fhirType());

    for (org.hl7.fhir.r5.model.Property t : value.children()) {
      if (t.getValues().size() > 0 || snapshot) {
        ElementDefinition ed = findElementDefinition(sd, t.getName());
        if (t.getValues().size() == 0 || (t.getValues().size() == 1 && t.getValues().get(0).isEmpty())) {
          if (!skipnoValue) {
            Row row = gen.new Row();
            erow.getSubRows().add(row);
            Cell c = gen.new Cell();
            row.getCells().add(c);
            c.addPiece(gen.new Piece((ed.getBase().getPath().equals(ed.getPath()) ? ref+ed.getPath() : corePath+(VersionUtilities.isR5Plus(context.getWorker().getVersion()) ? "types-definitions.html#"+ed.getBase().getPath() : "element-definitions.html#"+ed.getBase().getPath())), t.getName(), null));
            c = gen.new Cell();
            row.getCells().add(c);
            c.addPiece(gen.new Piece(null, null, null));
            c = gen.new Cell();
            row.getCells().add(c);
            if (!pattern) {
              c.addPiece(gen.new Piece(null, "0..0", null));
              row.setIcon("icon_fixed.gif", "Fixed Value" /*HierarchicalTableGenerator.TEXT_ICON_FIXED*/);
            } else if (context.getContext().isPrimitiveType(t.getTypeCode())) {
              row.setIcon("icon_primitive.png", HierarchicalTableGenerator.TEXT_ICON_PRIMITIVE);
              c.addPiece(gen.new Piece(null, "0.."+(t.getMaxCardinality() == 2147483647 ? "*": Integer.toString(t.getMaxCardinality())), null));
            } else if (isReference(t.getTypeCode())) { 
              row.setIcon("icon_reference.png", HierarchicalTableGenerator.TEXT_ICON_REFERENCE);
              c.addPiece(gen.new Piece(null, "0.."+(t.getMaxCardinality() == 2147483647 ? "*": Integer.toString(t.getMaxCardinality())), null));
            } else { 
              row.setIcon("icon_datatype.gif", HierarchicalTableGenerator.TEXT_ICON_DATATYPE);
              c.addPiece(gen.new Piece(null, "0.."+(t.getMaxCardinality() == 2147483647 ? "*": Integer.toString(t.getMaxCardinality())), null));
            }
            c = gen.new Cell();
            row.getCells().add(c);
            if (t.getTypeCode().contains("(")) {
              String tc = t.getTypeCode();
              String tn = tc.substring(0, tc.indexOf("("));
              c.addPiece(gen.new Piece(context.getPkp().getLinkFor(corePath, tn), tn, null));
              c.addPiece(gen.new Piece(null, "(", null));
              String[] p = tc.substring(tc.indexOf("(")+1, tc.indexOf(")")).split("\\|");
              for (String s : p) {
                c.addPiece(gen.new Piece(context.getPkp().getLinkFor(corePath, s), s, null));
              }
              c.addPiece(gen.new Piece(null, ")", null));            
            } else {
              c.addPiece(gen.new Piece(context.getPkp().getLinkFor(corePath, t.getTypeCode()), t.getTypeCode(), null));
            }
            c = gen.new Cell();
            c.addPiece(gen.new Piece(null, ed.getShort(), null));
            row.getCells().add(c);
          }
        } else {
          for (Base b : t.getValues()) {
            Row row = gen.new Row();
            erow.getSubRows().add(row);
            row.setIcon("icon_fixed.gif", "Fixed Value" /*HierarchicalTableGenerator.TEXT_ICON_FIXED*/);

            Cell c = gen.new Cell();
            row.getCells().add(c);
            c.addPiece(gen.new Piece((ed.getBase().getPath().equals(ed.getPath()) ? ref+ed.getPath() : (VersionUtilities.isR5Ver(context.getWorker().getVersion()) ? corePath+"types-definitions.html#"+ed.getBase().getPath() : corePath+"element-definitions.html#"+ed.getBase().getPath())), t.getName(), null));

            c = gen.new Cell();
            row.getCells().add(c);
            c.addPiece(gen.new Piece(null, null, null));

            c = gen.new Cell();
            row.getCells().add(c);
            if (pattern)
              c.addPiece(gen.new Piece(null, "1.."+(t.getMaxCardinality() == 2147483647 ? "*" : Integer.toString(t.getMaxCardinality())), null));
            else
              c.addPiece(gen.new Piece(null, "1..1", null));

            c = gen.new Cell();
            row.getCells().add(c);
            if (b.fhirType().contains("(")) {
              String tc = b.fhirType();
              String tn = tc.substring(0, tc.indexOf("("));
              c.addPiece(gen.new Piece(context.getPkp().getLinkFor(corePath, tn), tn, null));
              c.addPiece(gen.new Piece(null, "(", null));
              String[] p = tc.substring(tc.indexOf("(")+1, tc.indexOf(")")).split("\\|");
              for (String s : p) {
                c.addPiece(gen.new Piece(context.getPkp().getLinkFor(corePath, s), s, null));
              }
              c.addPiece(gen.new Piece(null, ")", null));            
            } else {
              c.addPiece(gen.new Piece(context.getPkp().getLinkFor(corePath, b.fhirType()), b.fhirType(), null));
            }

            if (b.isPrimitive()) {
              c = gen.new Cell();
              row.getCells().add(c);
              c.addPiece(gen.new Piece(null, ed.getShort(), null));
              c.addPiece(gen.new Piece("br"));
              c.getPieces().add(gen.new Piece(null, "Fixed Value: ", null).addStyle("font-weight: bold"));
              String s = b.primitiveValue();
              // ok. let's see if we can find a relevant link for this
              String link = null;
              if (Utilities.isAbsoluteUrl(s)) {
                link = context.getPkp().getLinkForUrl(corePath, s);
              }
              c.getPieces().add(gen.new Piece(link, s, null).addStyle("color: darkgreen"));
            } else {
              c = gen.new Cell();
              row.getCells().add(c);
              c.addPiece(gen.new Piece(null, ed.getShort(), null));
              c.addPiece(gen.new Piece("br"));
              c.getPieces().add(gen.new Piece(null, "Fixed Value: ", null).addStyle("font-weight: bold"));
              c.getPieces().add(gen.new Piece(null, "(complex)", null).addStyle("color: darkgreen"));
              genFixedValue(gen, row, (DataType) b, snapshot, pattern, corePath, skipnoValue);
            }
          }
        }
      }
    }
  }


  private ElementDefinition findElementDefinition(StructureDefinition sd, String name) {
    String path = sd.getTypeName()+"."+name;
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals(path))
        return ed;
    }
    throw new FHIRException(context.getWorker().formatMessage(I18nConstants.UNABLE_TO_FIND_ELEMENT_, path));
  }


  private String getFixedUrl(StructureDefinition sd) {
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals("Extension.url")) {
        if (ed.hasFixed() && ed.getFixed() instanceof UriType)
          return ed.getFixed().primitiveValue();
      }
    }
    return null;
  }


  private Piece describeCoded(HierarchicalTableGenerator gen, DataType fixed) {
    if (fixed instanceof Coding) {
      Coding c = (Coding) fixed;
      ValidationResult vr = context.getWorker().validateCode(context.getTerminologyServiceOptions(), c.getSystem(), c.getVersion(), c.getCode(), c.getDisplay());
      if (vr.getDisplay() != null)
        return gen.new Piece(null, " ("+vr.getDisplay()+")", null).addStyle("color: darkgreen");
    } else if (fixed instanceof CodeableConcept) {
      CodeableConcept cc = (CodeableConcept) fixed;
      for (Coding c : cc.getCoding()) {
        ValidationResult vr = context.getWorker().validateCode(context.getTerminologyServiceOptions(), c.getSystem(), c.getVersion(), c.getCode(), c.getDisplay());
        if (vr.getDisplay() != null)
          return gen.new Piece(null, " ("+vr.getDisplay()+")", null).addStyle("color: darkgreen");
      }
    }
    return null;
  }


  private boolean hasDescription(DataType fixed) {
    if (fixed instanceof Coding) {
      return ((Coding) fixed).hasDisplay();
    } else if (fixed instanceof CodeableConcept) {
      CodeableConcept cc = (CodeableConcept) fixed;
      if (cc.hasText())
        return true;
      for (Coding c : cc.getCoding())
        if (c.hasDisplay())
          return true;
    } // (fixed instanceof CodeType) || (fixed instanceof Quantity);
    return false;
  }


  private boolean isCoded(DataType fixed) {
    return (fixed instanceof Coding) || (fixed instanceof CodeableConcept) || (fixed instanceof CodeType) || (fixed instanceof Quantity);
  }


  private Cell generateGridDescription(HierarchicalTableGenerator gen, Row row, ElementDefinition definition, ElementDefinition fallback, boolean used, String baseURL, String url, StructureDefinition profile, String corePath, String imagePath, boolean root, ElementDefinition valueDefn) throws IOException, FHIRException {
    Cell c = gen.new Cell();
    row.getCells().add(c);

    if (used) {
      if (definition.hasContentReference()) {
        ElementInStructure ed = getElementByName(profile.getSnapshot().getElement(), definition.getContentReference(), profile);
        if (ed == null)
          c.getPieces().add(gen.new Piece(null, "Unknown reference to "+definition.getContentReference(), null));
        else {
          if (ed.getSource() == profile) {
            c.getPieces().add(gen.new Piece("#"+ed.getElement().getPath(), "See "+ed.getElement().getPath(), null));
          } else {
            c.getPieces().add(gen.new Piece(ed.getSource().getWebPath()+"#"+ed.getElement().getPath(), "See "+ed.getSource().getTypeName()+"."+ed.getElement().getPath(), null));
          }          
        }
      }
      if (definition.getPath().endsWith("url") && definition.hasFixed()) {
        c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, "\""+buildJson(definition.getFixed())+"\"", null).addStyle("color: darkgreen")));
      } else {
        if (url != null) {
          if (!c.getPieces().isEmpty()) 
            c.addPiece(gen.new Piece("br"));
          String fullUrl = url.startsWith("#") ? baseURL+url : url;
          StructureDefinition ed = context.getWorker().fetchResource(StructureDefinition.class, url, profile);
          String ref = null;
          if (ed != null) {
            String p = ed.getWebPath();
            if (p != null) {
              ref = p.startsWith("http:") || context.getRules() == GenerationRules.IG_PUBLISHER ? p : Utilities.pathURL(corePath, p);
            }
          }
          c.getPieces().add(gen.new Piece(null, "URL: ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(ref, fullUrl, null));
        }

        if (definition.hasSlicing()) {
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
          c.getPieces().add(gen.new Piece(null, "Slice: ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, describeSlice(definition.getSlicing()), null));
        }
        if (definition != null) {
          ElementDefinitionBindingComponent binding = null;
          if (valueDefn != null && valueDefn.hasBinding() && !valueDefn.getBinding().isEmpty())
            binding = valueDefn.getBinding();
          else if (definition.hasBinding())
            binding = definition.getBinding();
          if (binding!=null && !binding.isEmpty()) {
            if (!c.getPieces().isEmpty()) 
              c.addPiece(gen.new Piece("br"));
            BindingResolution br = context.getPkp().resolveBinding(profile, binding, definition.getPath());
            c.getPieces().add(checkForNoChange(binding, gen.new Piece(null, "Binding: ", null).addStyle("font-weight:bold")));
            c.getPieces().add(checkForNoChange(binding, gen.new Piece(br.url == null ? null : Utilities.isAbsoluteUrl(br.url) || !context.getPkp().prependLinks() ? br.url : corePath+br.url, br.display, null)));
            if (binding.hasStrength()) {
              c.getPieces().add(checkForNoChange(binding, gen.new Piece(null, " (", null)));
              c.getPieces().add(checkForNoChange(binding, gen.new Piece(corePath+"terminologies.html#"+binding.getStrength().toCode(), binding.getStrength().toCode(), binding.getStrength().getDefinition())));              c.getPieces().add(gen.new Piece(null, ")", null));
            }
            if (binding.hasDescription() && MarkDownProcessor.isSimpleMarkdown(binding.getDescription())) {
              c.getPieces().add(gen.new Piece(null, ": ", null));
              c.addMarkdownNoPara(PublicationHacker.fixBindingDescriptions(context.getWorker(), binding.getDescriptionElement()).asStringValue());
            }
          }
          for (ElementDefinitionConstraintComponent inv : definition.getConstraint()) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(checkForNoChange(inv, gen.new Piece(null, inv.getKey()+": ", null).addStyle("font-weight:bold")));
            if (inv.getHumanElement().hasExtension(ToolingExtensions.EXT_REND_MD)) {
              c.addMarkdown(inv.getHumanElement().getExtensionString(ToolingExtensions.EXT_REND_MD));
            } else {
              c.getPieces().add(checkForNoChange(inv, gen.new Piece(null, inv.getHuman(), null)));
            }
          }
          if (definition.hasFixed()) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, "Fixed Value: ", null).addStyle("font-weight:bold")));
            String s = buildJson(definition.getFixed());
            String link = null;
            if (Utilities.isAbsoluteUrl(s))
              link = context.getPkp().getLinkForUrl(corePath, s);
            c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(link, s, null).addStyle("color: darkgreen")));
          } else if (definition.hasPattern()) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, "Required Pattern: ", null).addStyle("font-weight:bold")));
            c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, buildJson(definition.getPattern()), null).addStyle("color: darkgreen")));
          } else if (definition.hasExample()) {
            for (ElementDefinitionExampleComponent ex : definition.getExample()) {
              if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
              c.getPieces().add(checkForNoChange(ex, gen.new Piece(null, "Example'"+("".equals("General")? "": " "+ex.getLabel()+"'")+": ", "").addStyle("font-weight:bold")));
              c.getPieces().add(checkForNoChange(ex, gen.new Piece(null, buildJson(ex.getValue()), null).addStyle("color: darkgreen")));
            }
          }
          if (definition.hasMaxLength() && definition.getMaxLength()!=0) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(checkForNoChange(definition.getMaxLengthElement(), gen.new Piece(null, "Max Length: ", null).addStyle("font-weight:bold")));
            c.getPieces().add(checkForNoChange(definition.getMaxLengthElement(), gen.new Piece(null, Integer.toString(definition.getMaxLength()), null).addStyle("color: darkgreen")));
          }
          if (profile != null) {
            for (StructureDefinitionMappingComponent md : profile.getMapping()) {
              if (md.hasExtension(ToolingExtensions.EXT_TABLE_NAME)) {
                ElementDefinitionMappingComponent map = null;
                for (ElementDefinitionMappingComponent m : definition.getMapping()) 
                  if (m.getIdentity().equals(md.getIdentity()))
                    map = m;
                if (map != null) {
                  for (int i = 0; i<definition.getMapping().size(); i++){
                    c.addPiece(gen.new Piece("br"));
                    c.getPieces().add(gen.new Piece(null, ToolingExtensions.readStringExtension(md, ToolingExtensions.EXT_TABLE_NAME)+": " + map.getMap(), null));
                  }
                }
              }
            }
          }
          if (definition.hasDefinition()) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(gen.new Piece(null, "Definition: ", null).addStyle("font-weight:bold"));
            c.addPiece(gen.new Piece("br"));
            c.addMarkdown(definition.getDefinition());
            //            c.getPieces().add(checkForNoChange(definition.getCommentElement(), gen.new Piece(null, definition.getComment(), null)));
          }
          if (definition.getComment()!=null) {
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); }
            c.getPieces().add(gen.new Piece(null, "Comments: ", null).addStyle("font-weight:bold"));
            c.addPiece(gen.new Piece("br"));
            c.addMarkdown(definition.getComment());
            //            c.getPieces().add(checkForNoChange(definition.getCommentElement(), gen.new Piece(null, definition.getComment(), null)));
          }
        }
      }
    }
    return c;
  }

  private boolean onlyInformationIsMapping(List<ElementDefinition> list, ElementDefinition e) {
    return (!e.hasSliceName() && !e.hasSlicing() && (onlyInformationIsMapping(e))) &&
        getChildren(list, e).isEmpty();
  }

  private boolean onlyInformationIsMapping(ElementDefinition d) {
    return !d.hasShort() && !d.hasDefinition() &&
        !d.hasRequirements() && !d.getAlias().isEmpty() && !d.hasMinElement() &&
        !d.hasMax() && !d.getType().isEmpty() && !d.hasContentReference() &&
        !d.hasExample() && !d.hasFixed() && !d.hasMaxLengthElement() &&
        !d.getCondition().isEmpty() && !d.getConstraint().isEmpty() && !d.hasMustSupportElement() &&
        !d.hasBinding();
  }

  private boolean allAreReference(List<TypeRefComponent> types) {
    for (TypeRefComponent t : types) {
      if (!t.hasTarget())
        return false;
    }
    return true;
  }

  private List<ElementDefinition> getChildren(List<ElementDefinition> all, ElementDefinition element) {
    List<ElementDefinition> result = new ArrayList<ElementDefinition>();
    int i = all.indexOf(element)+1;
    while (i < all.size() && all.get(i).getPath().length() > element.getPath().length()) {
      if ((all.get(i).getPath().substring(0, element.getPath().length()+1).equals(element.getPath()+".")) && !all.get(i).getPath().substring(element.getPath().length()+1).contains("."))
        result.add(all.get(i));
      i++;
    }
    return result;
  }


  protected String tail(String path) {
    if (path == null) {
      return "";
    } else if (path.contains("."))
      return path.substring(path.lastIndexOf('.')+1);
    else
      return path;
  }

  private boolean slicesExist(List<ElementDefinition> elements, ElementDefinition element) {
    if (elements == null) {
      return true;
    }
    boolean found = false;
    int start = elements.indexOf(element);
    if (start < 0) {
      return false;
    }
    for (int i = start; i < elements.size(); i++) {
      ElementDefinition ed = elements.get(i);
      if (ed.getPath().equals(element.getPath())) {
        if (ed.hasSliceName()) {
          found = true;
        }
      }
      if (ed.getPath().length() < element.getPath().length()) {
        break;
      }
    }
    return found;
  }


  private Cell addCell(Row row, Cell cell) {
    row.getCells().add(cell);
    return (cell);
  }

  private String checkAdd(String src, String app) {
    return app == null ? src : src + app;
  }

  public boolean hasNonBaseConditions(List<IdType> conditions) {
    for (IdType c : conditions) {
      if (!isBaseCondition(c)) {
        return true;
      }
    }
    return false;
  }


  public boolean hasNonBaseConstraints(List<ElementDefinitionConstraintComponent> constraints) {
    for (ElementDefinitionConstraintComponent c : constraints) {
      if (!isBaseConstraint(c)) {
        return true;
      }
    }
    return false;
  }

  public String listConstraintsAndConditions(ElementDefinition element) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (ElementDefinitionConstraintComponent con : element.getConstraint()) {
      if (!isBaseConstraint(con)) {
        b.append(con.getKey());
      }
    }
    for (IdType id : element.getCondition()) {
      if (!isBaseCondition(id)) {
        b.append(id.asStringValue());
      }
    }
    return b.toString();
  }

  private boolean isBaseCondition(IdType c) {
    String key = c.asStringValue();
    return key != null && (key.startsWith("ele-") || key.startsWith("res-") || key.startsWith("ext-") || key.startsWith("dom-") || key.startsWith("dr-"));
  }

  private boolean isBaseConstraint(ElementDefinitionConstraintComponent con) {
    String key = con.getKey();
    return key != null && (key.startsWith("ele-") || key.startsWith("res-") || key.startsWith("ext-") || key.startsWith("dom-") || key.startsWith("dr-"));
  }

  private void makeChoiceRows(List<Row> subRows, ElementDefinition element, HierarchicalTableGenerator gen, String corePath, String profileBaseFileName, boolean mustSupportMode, Resource src) {
    // create a child for each choice
    for (TypeRefComponent tr : element.getType()) {
      if (!mustSupportMode || allTypesMustSupport(element) || isMustSupport(tr)) {
        boolean used = false;
        Row choicerow = gen.new Row();
        String t = tr.getWorkingCode();
        if (isReference(t)) {
          used = true;
          choicerow.getCells().add(gen.new Cell(null, null, tail(element.getPath()).replace("[x]", Utilities.capitalize(t)), null, null));
          choicerow.getCells().add(gen.new Cell());
          choicerow.getCells().add(gen.new Cell(null, null, "", null, null));
          choicerow.setIcon("icon_reference.png", HierarchicalTableGenerator.TEXT_ICON_REFERENCE);
          Cell c = gen.new Cell();
          choicerow.getCells().add(c);
          if (ADD_REFERENCE_TO_TABLE) {
            if (tr.getWorkingCode().equals("canonical"))
              c.getPieces().add(gen.new Piece(corePath+"datatypes.html#canonical", "canonical", null));
            else
              c.getPieces().add(gen.new Piece(corePath+"references.html#Reference", "Reference", null));
            if (!mustSupportMode && isMustSupportDirect(tr) && element.getMustSupport()) {
              c.addPiece(gen.new Piece(null, " ", null));
              c.addStyledText(translate("sd.table", "This type must be supported"), "S", "white", "red", null, false);
            }
            c.getPieces().add(gen.new Piece(null, "(", null));
          }
          boolean first = true;
          for (CanonicalType rt : tr.getTargetProfile()) {
            if (!mustSupportMode || allProfilesMustSupport(tr.getTargetProfile()) || isMustSupport(rt)) {
              if (!first)
                c.getPieces().add(gen.new Piece(null, " | ", null));
              genTargetLink(gen, profileBaseFileName, corePath, c, tr, rt.getValue(), src);
              if (!mustSupportMode && isMustSupport(rt) && element.getMustSupport()) {
                c.addPiece(gen.new Piece(null, " ", null));
                c.addStyledText(translate("sd.table", "This target must be supported"), "S", "white", "red", null, false);
              }
              first = false;
            }
          }
          if (first) {
            c.getPieces().add(gen.new Piece(null, "Any", null));
          }

          if (ADD_REFERENCE_TO_TABLE) { 
            c.getPieces().add(gen.new Piece(null, ")", null));
          }

        } else {
          StructureDefinition sd = context.getWorker().fetchTypeDefinition(t);
          if (sd == null) {
            System.out.println("Unable to find "+t);
            sd = context.getWorker().fetchTypeDefinition(t);
          } else if (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
            used = true;
            choicerow.getCells().add(gen.new Cell(null, null, tail(element.getPath()).replace("[x]",  Utilities.capitalize(t)), sd.getDescription(), null));
            choicerow.getCells().add(gen.new Cell());
            choicerow.getCells().add(gen.new Cell(null, null, "", null, null));
            choicerow.setIcon("icon_primitive.png", HierarchicalTableGenerator.TEXT_ICON_PRIMITIVE);
            Cell c = gen.new Cell(null, corePath+"datatypes.html#"+t, sd.getTypeName(), null, null);
            choicerow.getCells().add(c);
            if (!mustSupportMode && isMustSupport(tr) && element.getMustSupport()) {
              c.addPiece(gen.new Piece(null, " ", null));
              c.addStyledText(translate("sd.table", "This type must be supported"), "S", "white", "red", null, false);
            }
          } else {
            used = true;
            choicerow.getCells().add(gen.new Cell(null, null, tail(element.getPath()).replace("[x]",  Utilities.capitalize(t)), sd.getDescription(), null));
            choicerow.getCells().add(gen.new Cell());
            choicerow.getCells().add(gen.new Cell(null, null, "", null, null));
            choicerow.setIcon("icon_datatype.gif", HierarchicalTableGenerator.TEXT_ICON_DATATYPE);
            Cell c = gen.new Cell(null, context.getPkp().getLinkFor(corePath, t), sd.getTypeName(), null, null);
            choicerow.getCells().add(c);
            if (!mustSupportMode && isMustSupport(tr) && element.getMustSupport()) {
              c.addPiece(gen.new Piece(null, " ", null));
              c.addStyledText(translate("sd.table", "This type must be supported"), "S", "white", "red", null, false);
            }
          }
          if (tr.hasProfile() && used) {
            Cell typeCell = choicerow.getCells().get(3);
            typeCell.addPiece(gen.new Piece(null, "(", null));
            boolean first = true;
            for (CanonicalType pt : tr.getProfile()) {
              if (!mustSupportMode || allProfilesMustSupport(tr.getProfile()) || isMustSupport(pt)) {
                if (first) first = false; else typeCell.addPiece(gen.new Piece(null, " | ", null));
                StructureDefinition psd = context.getWorker().fetchResource(StructureDefinition.class, pt.getValue(), src);
                if (psd == null)
                  typeCell.addPiece(gen.new Piece(null, "?gen-e2?", null));
                else
                  typeCell.addPiece(gen.new Piece(psd.getWebPath(), psd.getName(), psd.present()));
                if (!mustSupportMode && isMustSupport(pt) && element.getMustSupport()) {
                  typeCell.addPiece(gen.new Piece(null, " ", null));
                  typeCell.addStyledText(translate("sd.table", "This profile must be supported"), "S", "white", "red", null, false);
                }
              }
            }
            typeCell.addPiece(gen.new Piece(null, ")", null));
          }
        }    
        if (used) {
          choicerow.getCells().add(gen.new Cell());
          subRows.add(choicerow);
        }
      }
    }
  }

  private boolean isReference(String t) {
    return t.equals("Reference") || t.equals("canonical"); 
  }  



  private List<ElementChoiceGroup> readChoices(ElementDefinition ed, List<ElementDefinition> children) {
    List<ElementChoiceGroup> result = new ArrayList<>();
    for (ElementDefinitionConstraintComponent c : ed.getConstraint()) {
      ElementChoiceGroup grp = context.getProfileUtilities().processConstraint(children, c);
      if (grp != null) {
        result.add(grp);
      }
    }
    return result;
  }

  private Piece checkForNoChange(Element src1, Element src2, Piece piece) {
    if (src1.hasUserData(ProfileUtilities.UD_DERIVATION_EQUALS) && src2.hasUserData(ProfileUtilities.UD_DERIVATION_EQUALS)) {
      piece.addStyle("opacity: 0.5");
    }
    return piece;
  }


  private String buildJson(DataType value) throws IOException {
    if (value instanceof PrimitiveType)
      return ((PrimitiveType<?>) value).asStringValue();

    IParser json = new JsonParser();
    return json.composeString(value, null);
  }

  private String describeSlice(ElementDefinitionSlicingComponent slicing) {
    return translate("sd.table", "%s, %s by %s", slicing.getOrdered() ? translate("sd.table", "Ordered") : translate("sd.table", "Unordered"), describe(slicing.getRules()), commas(slicing.getDiscriminator()));
  }



  private String commas(List<ElementDefinitionSlicingDiscriminatorComponent> list) {
    CommaSeparatedStringBuilder c = new CommaSeparatedStringBuilder();
    for (ElementDefinitionSlicingDiscriminatorComponent id : list)
      c.append((id.hasType() ? id.getType().toCode() : "??")+":"+id.getPath());
    return c.toString();
  }


  private String describe(SlicingRules rules) {
    if (rules == null)
      return translate("sd.table", "Unspecified");
    switch (rules) {
    case CLOSED : return translate("sd.table", "Closed");
    case OPEN : return translate("sd.table", "Open");
    case OPENATEND : return translate("sd.table", "Open At End");
    default:
      return "?gen-sr?";
    }
  }

  private boolean allTypesMustSupport(ElementDefinition e) {
    boolean all = true;
    boolean any = false;
    for (TypeRefComponent tr : e.getType()) {
      all = all && isMustSupport(tr);
      any = any || isMustSupport(tr);
    }
    return !all && !any;
  }

  private boolean allProfilesMustSupport(List<CanonicalType> profiles) {
    boolean all = true;
    boolean any = false;
    for (CanonicalType u : profiles) {
      all = all && isMustSupport(u);
      any = any || isMustSupport(u);
    }
    return !all && !any;
  }
  public boolean isMustSupportDirect(TypeRefComponent tr) {
    return ("true".equals(ToolingExtensions.readStringExtension(tr, ToolingExtensions.EXT_MUST_SUPPORT)));
  }

  public boolean isMustSupport(TypeRefComponent tr) {
    if ("true".equals(ToolingExtensions.readStringExtension(tr, ToolingExtensions.EXT_MUST_SUPPORT))) {
      return true;
    }
    if (isMustSupport(tr.getProfile())) {
      return true;
    }
    return isMustSupport(tr.getTargetProfile());
  }

  public boolean isMustSupport(List<CanonicalType> profiles) {
    for (CanonicalType ct : profiles) {
      if (isMustSupport(ct)) {
        return true;
      }
    }
    return false;
  }


  public boolean isMustSupport(CanonicalType profile) {
    return "true".equals(ToolingExtensions.readStringExtension(profile, ToolingExtensions.EXT_MUST_SUPPORT));
  }



  private SpanEntry buildSpanEntryFromProfile(String name, String cardinality, StructureDefinition profile) throws IOException {
    SpanEntry res = new SpanEntry();
    res.setName(name);
    res.setCardinality(cardinality);
    res.setProfileLink(profile.getWebPath());
    res.setResType(profile.getTypeName());
    StructureDefinition base = context.getWorker().fetchResource(StructureDefinition.class, res.getResType());
    if (base != null)
      res.setResLink(base.getWebPath());
    res.setId(profile.getId());
    res.setProfile(profile.getDerivation() == TypeDerivationRule.CONSTRAINT);
    StringBuilder b = new StringBuilder();
    b.append(res.getResType());
    boolean first = true;
    boolean open = false;
    if (profile.getDerivation() == TypeDerivationRule.CONSTRAINT) {
      res.setDescription(profile.getName());
      for (ElementDefinition ed : profile.getSnapshot().getElement()) {
        if (isKeyProperty(ed.getBase().getPath()) && ed.hasFixed()) {
          if (first) {
            open = true;
            first = false;
            b.append("[");
          } else {
            b.append(", ");
          }
          b.append(tail(ed.getBase().getPath()));
          b.append("=");
          b.append(summarize(ed.getFixed()));
        }
      }
      if (open)
        b.append("]");
    } else
      res.setDescription("Base FHIR "+profile.getName());
    res.setType(b.toString());
    return res ;
  }


  private String summarize(DataType value) throws IOException {
    if (value instanceof Coding)
      return summarizeCoding((Coding) value);
    else if (value instanceof CodeableConcept)
      return summarizeCodeableConcept((CodeableConcept) value);
    else
      return buildJson(value);
  }


  private String summarizeCoding(Coding value) {
    String uri = value.getSystem();
    String system = TerminologyRenderer.describeSystem(uri);
    if (Utilities.isURL(system)) {
      if (system.equals("http://cap.org/protocols"))
        system = "CAP Code";
    }
    return system+" "+value.getCode();
  }


  private String summarizeCodeableConcept(CodeableConcept value) {
    if (value.hasCoding())
      return summarizeCoding(value.getCodingFirstRep());
    else
      return value.getText();
  }


  private boolean isKeyProperty(String path) {
    return Utilities.existsInList(path, "Observation.code");
  }


  private TableModel initSpanningTable(HierarchicalTableGenerator gen, String prefix, boolean isLogical, String id) throws IOException {
    TableModel model = gen.new TableModel(id, true);

    if (context.getRules() == GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) {
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());     
    } else {
      model.setDocoImg(Utilities.pathURL(prefix, "help16.png"));
    }
    model.setDocoRef(Utilities.pathURL(prefix, "formats.html#table")); // todo: change to graph definition
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), "Property", "A profiled resource", null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), "Card.", "Minimum and Maximum # of times the the element can appear in the instance", null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), "Content", "What goes here", null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), "Description", "Description of the profile", null, 0));
    return model;
  }

  private void genSpanEntry(HierarchicalTableGenerator gen, List<Row> rows, SpanEntry span) throws IOException {
    Row row = gen.new Row();
    rows.add(row);
    row.setAnchor(span.getId());
    //row.setColor(..?);
    if (span.isProfile()) {
      row.setIcon("icon_profile.png", HierarchicalTableGenerator.TEXT_ICON_PROFILE);
    } else {
      row.setIcon("icon_resource.png", HierarchicalTableGenerator.TEXT_ICON_RESOURCE);
    }

    row.getCells().add(gen.new Cell(null, null, span.getName(), null, null));
    row.getCells().add(gen.new Cell(null, null, span.getCardinality(), null, null));
    row.getCells().add(gen.new Cell(null, span.getProfileLink(), span.getType(), null, null));
    row.getCells().add(gen.new Cell(null, null, span.getDescription(), null, null));

    for (SpanEntry child : span.getChildren()) {
      genSpanEntry(gen, row.getSubRows(), child);
    }
  }


  public XhtmlNode generateSpanningTable(StructureDefinition profile, String imageFolder, boolean onlyConstraints, String constraintPrefix, Set<String> outputTracker) throws IOException, FHIRException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(imageFolder, false, true);
    gen.setTranslator(getTranslator());
    TableModel model = initSpanningTable(gen, "", false, profile.getId());
    Set<String> processed = new HashSet<String>();
    SpanEntry span = buildSpanningTable("(focus)", "", profile, processed, onlyConstraints, constraintPrefix);

    genSpanEntry(gen, model.getRows(), span);
    return gen.generate(model, "", 0, outputTracker);
  }

  private SpanEntry buildSpanningTable(String name, String cardinality, StructureDefinition profile, Set<String> processed, boolean onlyConstraints, String constraintPrefix) throws IOException {
    SpanEntry res = buildSpanEntryFromProfile(name, cardinality, profile);
    boolean wantProcess = !processed.contains(profile.getUrl());
    processed.add(profile.getUrl());
    if (wantProcess && profile.getDerivation() == TypeDerivationRule.CONSTRAINT) {
      for (ElementDefinition ed : profile.getSnapshot().getElement()) {
        if (!"0".equals(ed.getMax()) && ed.getType().size() > 0) {
          String card = getCardinality(ed, profile.getSnapshot().getElement());
          if (!card.endsWith(".0")) {
            List<String> refProfiles = listReferenceProfiles(ed);
            if (refProfiles.size() > 0) {
              String uri = refProfiles.get(0);
              if (uri != null) {
                StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, uri);
                if (sd != null && (!onlyConstraints || (sd.getDerivation() == TypeDerivationRule.CONSTRAINT && (constraintPrefix == null || sd.getUrl().startsWith(constraintPrefix))))) {
                  res.getChildren().add(buildSpanningTable(nameForElement(ed), card, sd, processed, onlyConstraints, constraintPrefix));
                }
              }
            }
          }
        } 
      }
    }
    return res;
  }


  private String getCardinality(ElementDefinition ed, List<ElementDefinition> list) {
    int min = ed.getMin();
    int max = !ed.hasMax() || ed.getMax().equals("*") ? Integer.MAX_VALUE : Integer.parseInt(ed.getMax());
    ElementDefinition ned = ed;
    while (ned != null && ned.getPath().contains(".")) {
      ned = findParent(ned, list);
      if (ned != null) { // todo: this can happen if we've walked into a resoruce. Not sure what to about that?
        if ("0".equals(ned.getMax()))
          max = 0;
        else if (!ned.getMax().equals("1") && !ned.hasSlicing())
          max = Integer.MAX_VALUE;
        if (ned.getMin() == 0) {
          min = 0;
        }
      }
    }
    return Integer.toString(min)+".."+(max == Integer.MAX_VALUE ? "*" : Integer.toString(max));
  }


  private ElementDefinition findParent(ElementDefinition ed, List<ElementDefinition> list) {
    int i = list.indexOf(ed)-1;
    while (i >= 0 && !ed.getPath().startsWith(list.get(i).getPath()+"."))
      i--;
    if (i == -1)
      return null;
    else
      return list.get(i);
  }


  private List<String> listReferenceProfiles(ElementDefinition ed) {
    List<String> res = new ArrayList<String>();
    for (TypeRefComponent tr : ed.getType()) {
      // code is null if we're dealing with "value" and profile is null if we just have Reference()
      if (tr.hasTarget() && tr.hasTargetProfile())
        for (UriType u : tr.getTargetProfile())
          res.add(u.getValue());
    }
    return res;
  }


  private String nameForElement(ElementDefinition ed) {
    return ed.getPath().substring(ed.getPath().indexOf(".")+1);
  }

  public XhtmlNode formatTypeSpecifiers(ElementDefinition d) {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean first = true;
    for (Extension e : d.getExtensionsByUrl(ToolingExtensions.EXT_TYPE_SPEC)) {
      if (first) first = false; else x.br();
      String cond = ToolingExtensions.readStringExtension(e, "condition");
      String type = ToolingExtensions.readStringExtension(e, "type");
      x.tx("If ");
      x.code().tx(cond);
      x.tx(" then the type is ");
      StructureDefinition sd = context.getContext().fetchTypeDefinition(type);
      if (sd == null) {
        x.code().tx(type);
      } else {
        x.ah(sd.getWebPath()).tx(sd.getTypeName());
      }
    }
    return first ? null : x;
  }

  public XhtmlNode generateExtensionTable(String defFile, StructureDefinition ed, String imageFolder, boolean inlineGraphics, boolean full, String corePath, String imagePath, Set<String> outputTracker, RenderingContext rc) throws IOException, FHIRException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(imageFolder, inlineGraphics, true);
    gen.setTranslator(getTranslator());
    TableModel model = gen.initNormalTable(corePath, false, true, ed.getId()+(full ? "f" : "n"), true, TableGenerationMode.XHTML);

    boolean deep = false;
    String m = "";
    boolean vdeep = false;
    if (ed.getSnapshot().getElementFirstRep().getIsModifier())
      m = "modifier_";
    for (ElementDefinition eld : ed.getSnapshot().getElement()) {
      deep = deep || eld.getPath().contains("Extension.extension.");
      vdeep = vdeep || eld.getPath().contains("Extension.extension.extension.");
    }
    Row r = gen.new Row();
    model.getRows().add(r);
    String en;
    if (!full)
      en = ed.getName();
    else if (ed.getSnapshot().getElement().get(0).getIsModifier())
      en = "modifierExtension";
    else 
      en = "extension";

    r.getCells().add(gen.new Cell(null, defFile == null ? "" : defFile+"-definitions.html#extension."+ed.getName(), en, null, null));
    r.getCells().add(gen.new Cell());
    r.getCells().add(gen.new Cell(null, null, describeCardinality(ed.getSnapshot().getElement().get(0), null, new UnusedTracker()), null, null));

    ElementDefinition ved = null;
    if (full || vdeep) {
      r.getCells().add(gen.new Cell("", "", "Extension", null, null));

      r.setIcon(deep ? "icon_"+m+"extension_complex.png" : "icon_extension_simple.png", deep ? HierarchicalTableGenerator.TEXT_ICON_EXTENSION_COMPLEX : HierarchicalTableGenerator.TEXT_ICON_EXTENSION_SIMPLE);
      List<ElementDefinition> children = getChildren(ed.getSnapshot().getElement(), ed.getSnapshot().getElement().get(0));
      for (ElementDefinition child : children)
        if (!child.getPath().endsWith(".id")) {
          List<StructureDefinition> sdl = new ArrayList<>();
          sdl.add(ed);
          genElement(defFile == null ? "" : defFile+"-definitions.html#extension.", gen, r.getSubRows(), child, ed.getSnapshot().getElement(), sdl, true, defFile, true, full, corePath, imagePath, true, false, false, false, null, false, rc, "", ed, null);
        }
    } else if (deep) {
      List<ElementDefinition> children = new ArrayList<ElementDefinition>();
      for (ElementDefinition ted : ed.getSnapshot().getElement()) {
        if (ted.getPath().equals("Extension.extension"))
          children.add(ted);
      }

      r.getCells().add(gen.new Cell("", "", "Extension", null, null));
      r.setIcon("icon_"+m+"extension_complex.png", HierarchicalTableGenerator.TEXT_ICON_EXTENSION_COMPLEX);

      for (ElementDefinition c : children) {
        ved = getValueFor(ed, c);
        ElementDefinition ued = getUrlFor(ed, c);
        if (ved != null && ued != null) {
          Row r1 = gen.new Row();
          r.getSubRows().add(r1);
          r1.getCells().add(gen.new Cell(null, defFile == null ? "" : defFile+"-definitions.html#"+ed.getId()+"."+c.getId(), ((UriType) ued.getFixed()).getValue(), null, null));
          r1.getCells().add(gen.new Cell());
          r1.getCells().add(gen.new Cell(null, null, describeCardinality(c, null, new UnusedTracker()), null, null));
          genTypes(gen, r1, ved, defFile, ed, corePath, imagePath, false, false);
          r1.setIcon("icon_"+m+"extension_simple.png", HierarchicalTableGenerator.TEXT_ICON_EXTENSION_SIMPLE);      
          generateDescription(gen, r1, c, null, true, corePath, corePath, ed, corePath, imagePath, false, false, false, ved, false, false, false, rc);
        }
      }
    } else  {
      for (ElementDefinition ted : ed.getSnapshot().getElement()) {
        if (ted.getPath().startsWith("Extension.value"))
          ved = ted;
      }

      genTypes(gen, r, ved, defFile, ed, corePath, imagePath, false, false);

      r.setIcon("icon_"+m+"extension_simple.png", HierarchicalTableGenerator.TEXT_ICON_EXTENSION_SIMPLE);      
    }
    Cell c = gen.new Cell("", "", "URL = "+ed.getUrl(), null, null);
    Piece cc = gen.new Piece(null, ed.getName()+": ", null);
    c.addPiece(gen.new Piece("br")).addPiece(cc);
    c.addMarkdown(ed.getDescription());

    if (!full && !(deep || vdeep) && ved != null && ved.hasBinding()) {  
      c.addPiece(gen.new Piece("br"));
      BindingResolution br = context.getPkp().resolveBinding(ed, ved.getBinding(), ved.getPath());
      c.getPieces().add(checkForNoChange(ved.getBinding(), gen.new Piece(null, translate("sd.table", "Binding")+": ", null).addStyle("font-weight:bold")));
      c.getPieces().add(checkForNoChange(ved.getBinding(), gen.new Piece(br.url == null ? null : Utilities.isAbsoluteUrl(br.url) || !context.getPkp().prependLinks() ? br.url : corePath+br.url, br.display, null)));
      if (ved.getBinding().hasStrength()) {
        c.getPieces().add(checkForNoChange(ved.getBinding(), gen.new Piece(null, " (", null)));
        c.getPieces().add(checkForNoChange(ved.getBinding(), gen.new Piece(corePath+"terminologies.html#"+ved.getBinding().getStrength().toCode(), egt(ved.getBinding().getStrengthElement()), ved.getBinding().getStrength().getDefinition())));              
        c.getPieces().add(gen.new Piece(null, ")", null));
      }
      if (ved.getBinding().hasDescription() && MarkDownProcessor.isSimpleMarkdown(ved.getBinding().getDescription())) {
        c.getPieces().add(gen.new Piece(null, ": ", null));
        c.addMarkdownNoPara(PublicationHacker.fixBindingDescriptions(context.getWorker(), ved.getBinding().getDescriptionElement()).asStringValue());
      }
    }
    c.addPiece(gen.new Piece("br")).addPiece(gen.new Piece(null, ProfileUtilities.describeExtensionContext(ed), null));
    r.getCells().add(c);

    try {
      return gen.generate(model, corePath, 0, outputTracker);
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(e.getMessage(), e);
    }
  }

  private String describeCardinality(ElementDefinition definition, ElementDefinition fallback, UnusedTracker tracker) {
    IntegerType min = definition.hasMinElement() ? definition.getMinElement() : new IntegerType();
    StringType max = definition.hasMaxElement() ? definition.getMaxElement() : new StringType();
    if (min.isEmpty() && fallback != null)
      min = fallback.getMinElement();
    if (max.isEmpty() && fallback != null)
      max = fallback.getMaxElement();

    tracker.used = !max.isEmpty() && !max.getValue().equals("0");

    if (min.isEmpty() && max.isEmpty())
      return null;
    else
      return (!min.hasValue() ? "" : Integer.toString(min.getValue())) + ".." + (!max.hasValue() ? "" : max.getValue());
  }


  private ElementDefinition getValueFor(StructureDefinition ed, ElementDefinition c) {
    int i = ed.getSnapshot().getElement().indexOf(c) + 1;
    while (i < ed.getSnapshot().getElement().size() && ed.getSnapshot().getElement().get(i).getPath().startsWith(c.getPath()+".")) {
      if (ed.getSnapshot().getElement().get(i).getPath().startsWith(c.getPath()+".value"))
        return ed.getSnapshot().getElement().get(i);
      i++;
    }
    return null;
  }

  private ElementDefinition getUrlFor(StructureDefinition ed, ElementDefinition c) {
    int i = ed.getSnapshot().getElement().indexOf(c) + 1;
    while (i < ed.getSnapshot().getElement().size() && ed.getSnapshot().getElement().get(i).getPath().startsWith(c.getPath()+".")) {
      if (ed.getSnapshot().getElement().get(i).getPath().equals(c.getPath()+".url"))
        return ed.getSnapshot().getElement().get(i);
      i++;
    }
    return null;
  }

  public void renderDict(StructureDefinition sd, List<ElementDefinition> elements, XhtmlNode t, boolean incProfiledOut, int mode, String anchorPrefix) throws FHIRException, IOException {
    int i = 0;
    Map<String, ElementDefinition> allAnchors = new HashMap<>();
    List<ElementDefinition> excluded = new ArrayList<>();
    List<ElementDefinition> stack = new ArrayList<>(); // keeps track of parents, for anchor generation
    
    for (ElementDefinition ec : elements) {
      addToStack(stack, ec);
      generateAnchors(stack, allAnchors);
      checkInScope(stack, excluded);
    }
    Stack<ElementDefinition> dstack = new Stack<>();
    for (ElementDefinition ec : elements) {
      if ((incProfiledOut || !"0".equals(ec.getMax())) && !excluded.contains(ec)) {
        ElementDefinition compareElement = null;
        if (mode==GEN_MODE_DIFF)
          compareElement = getBaseElement(ec, sd.getBaseDefinition());
        else if (mode==GEN_MODE_KEY)
          compareElement = getRootElement(ec);

        List<String> anchors = makeAnchors(ec, anchorPrefix);
        String title = ec.getId();
        XhtmlNode tr = t.tr();
        XhtmlNode sp = renderStatus(ec, tr.td("structure").colspan(2).spanClss("self-link-parent"));
        for (String s : anchors) {
          sp.an(s).tx(" ");
        }
        sp.span("color: grey", null).tx(Integer.toString(i++));
        sp.b().tx(". "+title);
        link(sp, ec.getId(), anchorPrefix);
        if (isProfiledExtension(ec)) {
          StructureDefinition extDefn = context.getContext().fetchResource(StructureDefinition.class, ec.getType().get(0).getProfile().get(0).getValue());
          if (extDefn == null) {
            generateElementInner(t, sd, ec, 1, null, compareElement, null, false);
          } else {
            ElementDefinition valueDefn = getExtensionValueDefinition(extDefn);
            ElementDefinition compareValueDefn = null;
            try {
              StructureDefinition compareExtDefn = context.getContext().fetchResource(StructureDefinition.class, compareElement.getType().get(0).getProfile().get(0).getValue());
              compareValueDefn = getExtensionValueDefinition(extDefn);
            } catch (Exception except) {}
            generateElementInner(t, sd, ec, valueDefn == null || valueDefn.prohibited() ? 2 : 3, valueDefn, compareElement, compareValueDefn, false);
            // generateElementInner(b, extDefn, extDefn.getSnapshot().getElement().get(0), valueDefn == null ? 2 : 3, valueDefn);
          }
        } else {
          while (!dstack.isEmpty() && !isParent(dstack.peek(), ec)) {
            finish(t, sd, dstack.pop(), mode);
          }
          dstack.push(ec);            
          generateElementInner(t, sd, ec, mode, null, compareElement, null, false);
          if (ec.hasSlicing()) {
            generateSlicing(t, sd, ec, ec.getSlicing(), compareElement, mode, false);
          }
        }
      }
      t.tx("\r\n");
      i++;
    }
    while (!dstack.isEmpty()) {
      finish(t, sd, dstack.pop(), mode);
    }
    finish(t, sd, null, mode);
  }

  private void finish(XhtmlNode t, StructureDefinition sd, ElementDefinition ed, int mode) throws FHIRException, IOException {

    for (Base b : VersionComparisonAnnotation.getDeleted(ed == null ? sd : ed, "element")) {
      ElementDefinition ec = (ElementDefinition) b;
      String title = ec.getId();
      XhtmlNode tr = t.tr();
      XhtmlNode sp = renderStatus(ec, tr.td("structure").colspan(2).spanClss("self-link-parent"));
      sp.span("color: grey", null).tx("--");
      sp.b().tx(". "+title);
      
      generateElementInner(t, sd, ec, mode, null, null, null, true);
      if (ec.hasSlicing()) {
        generateSlicing(t, sd, ec, ec.getSlicing(), null, mode, true);
      }      
    }
  }

  public ElementDefinition getElementById(String url, String id) {
    Map<String, ElementDefinition> sdCache = sdMapCache.get(url);

    if (sdCache == null) {
      StructureDefinition sd = (StructureDefinition) context.getContext().fetchResource(StructureDefinition.class, url);
      if (sd == null) {
        if (url.equals("http://hl7.org/fhir/StructureDefinition/Base")) {
          sd = (StructureDefinition) context.getContext().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Element");                
        }
        if (sd == null) {
          throw new FHIRException("Unable to retrieve StructureDefinition with URL " + url);
        }
      }
      sdCache = new HashMap<String, ElementDefinition>();
      sdMapCache.put(url, sdCache);
      String webroot = sd.getUserString("webroot");
      for (ElementDefinition e : sd.getSnapshot().getElement()) {
        context.getProfileUtilities().updateURLs(sd.getUrl(), webroot, e);
        sdCache.put(e.getId(), e);
      }
    }
    return sdCache.get(id);
  }


  // Returns the ElementDefinition for the 'parent' of the current element
  private ElementDefinition getBaseElement(ElementDefinition e, String url) {
    if (e.hasUserData(ProfileUtilities.UD_DERIVATION_POINTER)) {
      return getElementById(url, e.getUserString(ProfileUtilities.UD_DERIVATION_POINTER));
    }
    return null;
  }

  // Returns the ElementDefinition for the 'root' ancestor of the current element
  private ElementDefinition getRootElement(ElementDefinition e) {
    if (!e.hasBase())
      return null;
    String basePath = e.getBase().getPath();
    String url = "http://hl7.org/fhir/StructureDefinition/" + (basePath.contains(".") ? basePath.substring(0, basePath.indexOf(".")) : basePath);
    try {
      return getElementById(url, basePath);
    } catch (FHIRException except) {
      // Likely a logical model, so this is ok
      return null;
    }
  }
  private void checkInScope(List<ElementDefinition> stack, List<ElementDefinition> excluded) {
    if (stack.size() > 2) {
      ElementDefinition parent = stack.get(stack.size()-2);
      ElementDefinition focus = stack.get(stack.size()-1);

      if (excluded.contains(parent) || "0".equals(parent.getMax())) {
        excluded.add(focus);
      }
    }
  }

  private void generateAnchors(List<ElementDefinition> stack, Map<String, ElementDefinition> allAnchors) {
    List<String> list = new ArrayList<>();
    list.add(stack.get(0).getId()); // initialise
    for (int i = 1; i < stack.size(); i++) {
      ElementDefinition ed = stack.get(i);
      List<String> aliases = new ArrayList<>();
      String name = tail(ed.getPath());
      if (name.endsWith("[x]")) {
        aliases.add(name);
        Set<String> tl = new HashSet<String>(); // guard against duplicate type names - can happn in some versions
        for (TypeRefComponent tr : ed.getType()) {
          String tc = tr.getWorkingCode();
          if (!tl.contains(tc)) {
            aliases.add(name.replace("[x]", Utilities.capitalize(tc)));
            aliases.add(name+":"+name.replace("[x]", Utilities.capitalize(tc)));
            tl.add(tc);
          }
        }
      } else if (ed.hasSliceName()) {
        aliases.add(name+":"+ed.getSliceName());
        // names.add(name); no good generating this?
      } else {
        aliases.add(name);
      }
      List<String> generated = new ArrayList<>();
      for (String l : list) {
        for (String a : aliases) {
          generated.add(l+"."+a);
        }
      }
      list.clear();
      list.addAll(generated);
    }
    ElementDefinition ed = stack.get(stack.size()-1);

    // now we have all the possible names, but some of them might be inappropriate if we've
    // already generated a type slicer. On the other hand, if we've already done that, we're
    // going to steal any type specific ones off it.
    List<String> removed = new ArrayList<>();
    for (String s : list) {
      if (!allAnchors.containsKey(s)) {
        allAnchors.put(s, ed);
      } else if (s.endsWith("[x]")) {
        // that belongs on the earlier element
        removed.add(s);
      } else {
        // we delete it from the other
        @SuppressWarnings("unchecked")
        List<String> other = (List<String>) allAnchors.get(s).getUserData("dict.generator.anchors");
        other.remove(s);
        allAnchors.put(s, ed);
      }
    }
    list.removeAll(removed);
    ed.setUserData("dict.generator.anchors", list);
  }

  private void addToStack(List<ElementDefinition> stack, ElementDefinition ec) {
    while (!stack.isEmpty() && !isParent(stack.get(stack.size()-1), ec)) {
      stack.remove(stack.size()-1);
    }
    stack.add(ec);
  }

  private boolean isParent(ElementDefinition ed, ElementDefinition ec) {      
    return ec.getPath().startsWith(ed.getPath()+".");
  }

  private List<String> makeAnchors(ElementDefinition ed, String anchorPrefix) {
    List<String> list = (List<String>) ed.getUserData("dict.generator.anchors");
    List<String>  res = new ArrayList<>();
    res.add(anchorPrefix + ed.getId());
    for (String s : list) {
      if (!s.equals(ed.getId())) {
        res.add(anchorPrefix + s);
      }
    }
    return res;
  }



  private void link(XhtmlNode x, String id, String anchorPrefix) {
    var ah = x.ah("#" + anchorPrefix + id);
    ah.attribute("title", "link to here");
    ah.attribute("class", "self-link");
    var svg = ah.svg();
    svg.attribute("viewBox", "0 0 1792 1792");
    svg.attribute("width", "16");
    svg.attribute("height", "16");
    svg.attribute("class", "self-link");
    svg.path("M1520 1216q0-40-28-68l-208-208q-28-28-68-28-42 0-72 32 3 3 19 18.5t21.5 21.5 15 19 13 25.5 3.5 27.5q0 40-28 68t-68 28q-15 0-27.5-3.5t-25.5-13-19-15-21.5-21.5-18.5-19q-33 31-33 73 0 40 28 68l206 207q27 27 68 27 40 0 68-26l147-146q28-28 28-67zm-703-705q0-40-28-68l-206-207q-28-28-68-28-39 0-68 27l-147 146q-28 28-28 67 0 40 28 68l208 208q27 27 68 27 42 0 72-31-3-3-19-18.5t-21.5-21.5-15-19-13-25.5-3.5-27.5q0-40 28-68t68-28q15 0 27.5 3.5t25.5 13 19 15 21.5 21.5 18.5 19q33-31 33-73zm895 705q0 120-85 203l-147 146q-83 83-203 83-121 0-204-85l-206-207q-83-83-83-203 0-123 88-209l-88-88q-86 88-208 88-120 0-204-84l-208-208q-84-84-84-204t85-203l147-146q83-83 203-83 121 0 204 85l206 207q83 83 83 203 0 123-88 209l88 88q86-88 208-88 120 0 204 84l208 208q84 84 84 204z");     
  }

  private boolean isProfiledExtension(ElementDefinition ec) {
    return ec.getType().size() == 1 && "Extension".equals(ec.getType().get(0).getWorkingCode()) && ec.getType().get(0).hasProfile();
  }

  private ElementDefinition getExtensionValueDefinition(StructureDefinition extDefn) {
    for (ElementDefinition ed : extDefn.getSnapshot().getElement()) {
      if (ed.getPath().startsWith("Extension.value"))
        return ed;
    }
    return null;
  }
      
  public XhtmlNode compareMarkdown(String location, PrimitiveType md, PrimitiveType compare, int mode) throws FHIRException, IOException {
    if (compare == null || mode == GEN_MODE_DIFF) {
      if (md.hasValue()) {
        String xhtml = hostMd.processMarkdown(location, md);
        if (Utilities.noString(xhtml)) {
          return null;
        }
        XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
        try {
          renderStatusDiv(md, x).add(new XhtmlParser().parseFragment(xhtml));
        } catch (Exception e) {
          x.span("color: maroon").tx(e.getLocalizedMessage());          
        }
        return x;
      } else {
        return null;
      }
    } else if (areEqual(compare, md)) {
      if (md.hasValue()) {
        String xhtml = "<div>"+hostMd.processMarkdown(location, md)+"</div>";
        XhtmlNode div = new XhtmlParser().parseFragment(xhtml);
        for (XhtmlNode n : div.getChildNodes()) {
          if (n.getNodeType() == NodeType.Element) {
            n.style(unchangedStyle());
          }
        }
        return div;
      } else {
        return null;
      }
    } else {
      XhtmlNode ndiv = new XhtmlNode(NodeType.Element, "div");
      if (md.hasValue()) {
        String xhtml = "<div>"+hostMd.processMarkdown(location, md)+"</div>";
        XhtmlNode div = new XhtmlParser().parseFragment(xhtml);
        ndiv.copyAllContent(div);
      }
      if (compare.hasValue()) {
        String xhtml = "<div>"+hostMd.processMarkdown(location, compare)+"</div>";
        XhtmlNode div = new XhtmlParser().parseFragment(xhtml);
        for (XhtmlNode n : div.getChildNodes()) {
          if (n.getNodeType() == NodeType.Element) {
            n.style(removedStyle());
          }
        }
        ndiv.br();
        ndiv.copyAllContent(div);
      }
      return ndiv;
    }
  }

  private boolean areEqual(PrimitiveType compare, PrimitiveType md) {
    if (compare == null && md == null) {
      return true;
    } else if (compare != null && md != null) {
      String one = compare.getValueAsString();
      String two = md.getValueAsString();
      if (one == null && two == null) {
        return true;
      } else if (one != null && one.equals(two)) {
        return true;
      }
    }
    return false;
  }

  public XhtmlNode compareString(String newStr, Base source, String nLink, String name, Base parent, String oldStr, String oLink, int mode) {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    if (mode != GEN_MODE_KEY) {
      if (newStr != null) {
        renderStatus(source, x).ah(nLink).tx(newStr);
      } else if (VersionComparisonAnnotation.hasDeleted(parent, name)) {
        PrimitiveType p = (PrimitiveType) VersionComparisonAnnotation.getDeletedItem(parent, name);
        renderStatus(p, x).tx(p.primitiveValue());        
      } else {
        return null;
      }
    } else if (oldStr==null || oldStr.isEmpty()) {
      if (newStr==null || newStr.isEmpty()) {
        return null;
      } else {
        renderStatus(source, x).ah(nLink).tx(newStr);
      }
    } else if (oldStr!=null && !oldStr.isEmpty() && (newStr==null || newStr.isEmpty())) {
      if (mode == GEN_MODE_DIFF) {
        return null;
      } else {
        removed(x).ah(oLink).tx(oldStr);
      }
    } else if (oldStr.equals(newStr)) {
      if (mode==GEN_MODE_DIFF) {
        return null;
      } else {
        unchanged(x).ah(nLink).tx(newStr);
      }
    } else if (newStr.startsWith(oldStr)) {
      unchanged(x).ah(oLink).tx(oldStr);
      renderStatus(source, x).ah(nLink).tx(newStr.substring(oldStr.length()));
    } else {
      // TODO: improve comparision in this fall-through case, by looking for matches in sub-paragraphs?
      renderStatus(source, x).ah(nLink).tx(newStr);
      removed(x).ah(oLink).tx(oldStr);
    }
    return x;
  }

  public boolean compareString(XhtmlNode x, String newStr, Base source, String nLink, String name, Base parent, String oldStr, String oLink, int mode) {
    XhtmlNode x1 = compareString(newStr, source, nLink, name, parent, oldStr, oLink, mode);
    if (x1 == null) {
      return false;
    } else {
      x.getChildNodes().addAll(x1.getChildNodes());
      return true;
    }
  }

  public XhtmlNode unchanged(XhtmlNode x) {
    return x.span(unchangedStyle());
  }

  private String unchangedStyle() {
    return "color:DarkGray";
  }

  public XhtmlNode removed(XhtmlNode x) {
    return x.span(removedStyle());
  }

  private String removedStyle() {
    return "color:DarkGray;text-decoration:line-through";
  }

  private void generateElementInner(XhtmlNode tbl, StructureDefinition sd, ElementDefinition d, int mode, ElementDefinition value, ElementDefinition compare, ElementDefinition compareValue, boolean strikethrough) throws FHIRException, IOException {
    boolean root = !d.getPath().contains(".");
    boolean slicedExtension = d.hasSliceName() && (d.getPath().endsWith(".extension") || d.getPath().endsWith(".modifierExtension"));
//    int slicedExtensionMode = (mode == GEN_MODE_KEY) && slicedExtension ? GEN_MODE_SNAP : mode; // see ProfileUtilities.checkExtensionDoco / Task 3970
    if (d.hasSliceName()) {
      tableRow(tbl, "Slice Name", "profiling.html#slicing", strikethrough, compareString(d.getSliceName(), d.getSliceNameElement(), null, (compare != null ? compare.getSliceName() : null), d, null, "sliceName", mode));   
      tableRow(tbl, "Slice Constraining", "profiling.html#slicing", strikethrough, compareString(encodeValue(d.getSliceIsConstrainingElement()), d.getSliceIsConstrainingElement(), null, (compare != null ? encodeValue(compare.getSliceIsConstrainingElement()) : null), d, null, "sliceName", mode));   
    }

    tableRow(tbl, "Definition", null, strikethrough, compareMarkdown(sd.getName(), d.getDefinitionElement(), (compare==null) || slicedExtension ? null : compare.getDefinitionElement(), mode));
    tableRow(tbl, "Short", null, strikethrough, compareString(d.hasShort() ? d.getShort() : null, d.getShortElement(), null, "short", d, compare!= null && compare.hasShortElement() ? compare.getShort() : null, null, mode));
    tableRow(tbl, "Comments", null, strikethrough, compareMarkdown(sd.getName(), d.getCommentElement(), (compare==null) || slicedExtension ? null : compare.getCommentElement(), mode));
    tableRow(tbl, "Note", null, strikethrough, businessIdWarning(sd.getName(), tail(d.getPath())));
    tableRow(tbl, "Control", "conformance-rules.html#conformance", strikethrough, describeCardinality(d, compare, mode)); 
    tableRow(tbl, "Binding", "terminologies.html", strikethrough, describeBinding(sd, d, d.getPath(), compare, mode));
    if (d.hasContentReference()) {
      tableRow(tbl, "Type", null, strikethrough, "See " + d.getContentReference().substring(1));
    } else {
      tableRow(tbl, "Type", "datatypes.html", strikethrough, describeTypes(d.getType(), false, d, compare, mode, value, compareValue, sd)); 
    }
    if (d.hasExtension(ToolingExtensions.EXT_DEF_TYPE)) {
      tableRow(tbl, "Default Type", "datatypes.html", strikethrough, ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_DEF_TYPE));          
    }
    if (d.hasExtension(ToolingExtensions.EXT_TYPE_SPEC)) {
      tableRow(tbl, Utilities.pluralize("Type Specifier", d.getExtensionsByUrl(ToolingExtensions.EXT_TYPE_SPEC).size()), "datatypes.html", strikethrough, formatTypeSpecifiers(d));          
    }
    if (d.getPath().endsWith("[x]") && !d.prohibited()) {
      tableRow(tbl, "[x] Note", null, strikethrough).ahWithText("See ", spec("formats.html#choice"), null, "Choice of Data Types", " for further information about how to use [x]");
    }
    tableRow(tbl, "Is Modifier", "conformance-rules.html#ismodifier", strikethrough, presentModifier(d, mode, compare));
    if (d.getMustHaveValue()) {
      tableRow(tbl, "Primitive Value", "elementdefinition.html#primitives", strikethrough, "This primitive type must have a value (the value must be present, and cannot be replaced by an extension)");
    } else if (d.hasValueAlternatives()) {
      tableRow(tbl, "Primitive Value", "elementdefinition.html#primitives", strikethrough, renderCanonicalList("This primitive type may be present, or absent if replaced by one of the following extensions: ", d.getValueAlternatives()));      
    } else if (hasPrimitiveTypes(d)) {
      tableRow(tbl, "Primitive Value", "elementdefinition.html#primitives", strikethrough, "This primitive element may be present, or absent, or replaced by an extension");            
    }
    if (ToolingExtensions.hasAllowedUnits(d)) {      
      tableRow(tbl, "Allowed Units", "http://hl7.org/fhir/extensions/StructureDefinition-elementdefinition-allowedUnits.html", strikethrough, describeAllowedUnits(d));        
    }
    tableRow(tbl, "Must Support", "conformance-rules.html#mustSupport", strikethrough, displayBoolean(d.getMustSupport(), d.getMustSupportElement(), "mustSupport", d, compare==null ? null : compare.getMustSupportElement(), mode));
    if (d.getMustSupport()) {
      if (hasMustSupportTypes(d.getType())) {
        tableRow(tbl, "Must Support Types", "datatypes.html", strikethrough, describeTypes(d.getType(), true, d, compare, mode, null, null, sd));
      } else if (hasChoices(d.getType())) {
        tableRow(tbl, "Must Support Types", "datatypes.html", strikethrough, "No must-support rules about the choice of types/profiles");
      }
    }
    if (root && sd.getKind() == StructureDefinitionKind.LOGICAL) {
      Extension lt = ToolingExtensions.getExtension(sd, ToolingExtensions.EXT_LOGICAL_TARGET);
      if (lt == null || !lt.hasValue()) {
        tableRow(tbl, "Logical Model", null, strikethrough, "Instances of this logical model are not marked to be the target of a Reference");        
      } else if (lt.getValue().hasExtension(ToolingExtensions.DAR)) {        
      } else if (lt.getValueBooleanType().hasValue()) {
        tableRow(tbl, "Logical Model", null, strikethrough, "Instances of this logical model are not marked to be the target of a Reference");        
      } else if (lt.getValueBooleanType().booleanValue()) {
        tableRow(tbl, "Logical Model", null, strikethrough, "Instances of this logical model can be the target of a Reference");        
      } else {
        tableRow(tbl, "Logical Model", null, strikethrough, "Instances of this logical model cannot be the target of a Reference");
      }
    }

    if (root && sd.hasExtension(ToolingExtensions.EXT_SD_IMPOSE_PROFILE)) {
      tableRow(tbl, "Impose Profile", "http://hl7.org/fhir/extensions/StructureDefinition-structuredefinition-imposeProfile.html", strikethrough, 
          renderCanonicalListExt("This profile also requires that the instance also conform this additional profile: ", sd.getExtensionsByUrl(ToolingExtensions.EXT_SD_IMPOSE_PROFILE)));
    }
    if (root && sd.hasExtension(ToolingExtensions.EXT_SD_COMPLIES_WITH_PROFILE)) {
      tableRow(tbl, "Complies with Profile", "http://hl7.org/fhir/extensions/StructureDefinition-structuredefinition-compliesWithProfile.html", strikethrough, 
          renderCanonicalListExt("This profile compiles with the profile ", sd.getExtensionsByUrl(ToolingExtensions.EXT_SD_COMPLIES_WITH_PROFILE)));
    }
    tableRow(tbl, "Obligations", null, strikethrough, describeObligations(d, root, sd));   

    if (d.hasExtension(ToolingExtensions.EXT_EXTENSION_STYLE)) {
      String es = d.getExtensionString(ToolingExtensions.EXT_EXTENSION_STYLE);
      if ("named-elements".equals(es)) {
        if (context.hasLink(KnownLinkType.JSON_NAMES)) {
          tableRow(tbl, "Extension Style", context.getLink(KnownLinkType.JSON_NAMES), strikethrough, "This element can be extended by named JSON elements");
        } else {
          tableRow(tbl, "Extension Style", ToolingExtensions.WEB_EXTENSION_STYLE, strikethrough, "This element can be extended by named JSON elements");
        }
      }
    }

    if (!d.getPath().contains(".") && ToolingExtensions.hasExtension(sd, ToolingExtensions.EXT_BINDING_STYLE)) {
      tableRow(tbl, "Binding Style", ToolingExtensions.WEB_BINDING_STYLE, strikethrough, 
          "This type can be bound to a value set using the " + ToolingExtensions.readStringExtension(sd, ToolingExtensions.EXT_BINDING_STYLE)+" binding style");            
    }

    if (d.hasExtension(ToolingExtensions.EXT_DATE_FORMAT)) {
      tableRow(tbl, "Date Format", null, strikethrough, ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_DATE_FORMAT));
    }
    String ide = ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_ID_EXPECTATION);
    if (ide != null) {
      if (ide.equals("optional")) {
        tableRow(tbl, "ID Expectation", null, strikethrough, "Id may or not be present (this is the default for elements but not resources)");
      } else if (ide.equals("required")) {
        tableRow(tbl, "ID Expectation", null, strikethrough, "Id is required to be present (this is the default for resources but not elements)");
      } else if (ide.equals("required")) {
        tableRow(tbl, "ID Expectation", null, strikethrough, "An ID is not allowed in this context");
      }
    }
    // tooling extensions for formats
    if (ToolingExtensions.hasExtensions(d, ToolingExtensions.EXT_JSON_EMPTY, ToolingExtensions.EXT_JSON_PROP_KEY, ToolingExtensions.EXT_JSON_NULLABLE, 
        ToolingExtensions.EXT_JSON_NAME, ToolingExtensions.EXT_JSON_PRIMITIVE_CHOICE)) {
      tableRow(tbl, "JSON Format", null, strikethrough,  describeJson(d));          
    }
    if (d.hasExtension(ToolingExtensions.EXT_XML_NAMESPACE) || sd.hasExtension(ToolingExtensions.EXT_XML_NAMESPACE) || d.hasExtension(ToolingExtensions.EXT_XML_NAME) || (root && sd.hasExtension(ToolingExtensions.EXT_XML_NO_ORDER)) ||
        d.hasRepresentation()) {
      tableRow(tbl, "XML Format", null, strikethrough, describeXml(sd, d, root));          
    }

    if (d.hasExtension(ToolingExtensions.EXT_IMPLIED_PREFIX)) {
      tableRow(tbl, "String Format", null, strikethrough).codeWithText("When this element is read ", ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_IMPLIED_PREFIX), "is prefixed to the value before validation");                
    }

    if (d.hasExtension(ToolingExtensions.EXT_STANDARDS_STATUS)) {
      StandardsStatus ss = StandardsStatus.fromCode(d.getExtensionString(ToolingExtensions.EXT_STANDARDS_STATUS));
      //      gc.addStyledText("Standards Status = "+ss.toDisplay(), ss.getAbbrev(), "black", ss.getColor(), baseSpecUrl()+, true);
      StructureDefinition sdb = context.getContext().fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      if (sdb != null) {
        StandardsStatus base = determineStandardsStatus(sdb, (ElementDefinition) d.getUserData("derived.pointer"));
        if (base != null) {
          tableRow(tbl, "Standards Status", "versions.html#std-process", strikethrough, ss.toDisplay()+" (from "+base.toDisplay()+")");
        } else {
          tableRow(tbl, "Standards Status", "versions.html#std-process", strikethrough, ss.toDisplay());          
        }
      } else {
        tableRow(tbl, "Standards Status", "versions.html#std-process", strikethrough, ss.toDisplay());
      }
    }
    if (mode != GEN_MODE_DIFF && d.hasIsSummary()) {
      tableRow(tbl, "Summary", "search.html#summary", strikethrough, Boolean.toString(d.getIsSummary()));
    }
    tableRow(tbl, "Requirements", null, strikethrough, compareMarkdown(sd.getName(), d.getRequirementsElement(), (compare==null) || slicedExtension ? null : compare.getRequirementsElement(), mode));
    tableRow(tbl, "Label", null, strikethrough, compareString(d.getLabel(), d.getLabelElement(), null, "label", d, (compare != null ? compare.getLabel() : null), null, mode));   
    tableRow(tbl, "Alternate Names", null, strikethrough, compareSimpleTypeLists(d.getAlias(), ((compare==null) || slicedExtension ? null : compare.getAlias()), mode));
    tableRow(tbl, "Definitional Codes", null, strikethrough, compareDataTypeLists(d.getCode(), ((compare==null) || slicedExtension ? null : compare.getCode()), mode));
    tableRow(tbl, "Min Value", null, strikethrough, compareString(d.hasMinValue() ? encodeValue(d.getMinValue()) : null, d.getMinValue(), null, "minValue", d, compare!= null && compare.hasMinValue() ? encodeValue(compare.getMinValue()) : null, null, mode));
    tableRow(tbl, "Max Value", null, strikethrough, compareString(d.hasMaxValue() ? encodeValue(d.getMaxValue()) : null, d.getMaxValue(), null, "maxValue", d, compare!= null && compare.hasMaxValue() ? encodeValue(compare.getMaxValue()) : null, null, mode));
    tableRow(tbl, "Max Length", null, strikethrough, compareString(d.hasMaxLength() ? toStr(d.getMaxLength()) : null, d.getMaxLengthElement(), null, "maxLength", d, compare!= null && compare.hasMaxLengthElement() ? toStr(compare.getMaxLength()) : null, null, mode));
    tableRow(tbl, "Value Required", null, strikethrough, compareString(encodeValue(d.getMustHaveValueElement()), d.getMustHaveValueElement(), null, (compare != null ? encodeValue(compare.getMustHaveValueElement()) : null), d, null, "mustHaveValueElement", mode));   
    tableRow(tbl, "Value Alternatives", null, strikethrough, compareSimpleTypeLists(d.getValueAlternatives(), ((compare==null) || slicedExtension ? null : compare.getValueAlternatives()), mode));
    tableRow(tbl, "Default Value", null, strikethrough, encodeValue(d.getDefaultValue(), "defaultValue", d, compare==null ? null : compare.getDefaultValue(), mode));
    tableRow(tbl, "Meaning if Missing", null, strikethrough, d.getMeaningWhenMissing());
    tableRow(tbl, "Fixed Value", null, strikethrough, encodeValue(d.getFixed(), "fixed", d, compare==null ? null : compare.getFixed(), mode));
    tableRow(tbl, "Pattern Value", null, strikethrough, encodeValue(d.getPattern(), "pattern", d, compare==null ? null : compare.getPattern(), mode));
    tableRow(tbl, "Example", null, strikethrough, encodeValues(d.getExample()));
    tableRow(tbl, "Invariants", null, strikethrough, invariants(d.getConstraint(), compare==null ? null : compare.getConstraint(), d, mode));
    tableRow(tbl, "LOINC Code", null, strikethrough, getMapping(sd, d, LOINC_MAPPING, compare, mode));
    tableRow(tbl, "SNOMED-CT Code", null, strikethrough, getMapping(sd, d, SNOMED_MAPPING, compare, mode));
    tbl.tx("\r\n");
  }
  
  private XhtmlNode presentModifier(ElementDefinition d, int mode, ElementDefinition compare) throws FHIRException, IOException {
    XhtmlNode x1 = compareString(encodeValue(d.getIsModifierElement()), d.getIsModifierElement(), null, "isModifier", d, compare == null ? null : encodeValue(compare.getIsModifierElement()), null, mode);
    if (x1 != null) {
      XhtmlNode x2 = compareString(encodeValue(d.getIsModifierReasonElement()), d.getIsModifierReasonElement(), null, "isModifierReason", d, compare == null ? null : encodeValue(compare.getIsModifierReasonElement()), null, mode);
      if (x2 != null) {
        x1.tx(" because ");
        x1.copyAllContent(x2);
      }
    }
    return x1;
  }  
  
  private String spec(String name) {
    return Utilities.pathURL(VersionUtilities.getSpecUrl(context.getWorker().getVersion()) , name);
  }

  private XhtmlNode describeXml(StructureDefinition profile, ElementDefinition d, boolean root) {
    XhtmlNode ret = new XhtmlNode(NodeType.Element, "div");
    for (PropertyRepresentation pr : PropertyRepresentation.values()) {
      if (d.hasRepresentation(pr)) {
        switch (pr) {
        case CDATEXT:
          ret.tx("This property is represented as CDA Text in the XML.");
          break;
        case TYPEATTR:
          ret.codeWithText("The type of this property is determined using the ", "xsi:type", "attribute.");
          break;
        case XHTML:
          ret.tx("This property is represented as XHTML Text in the XML.");
          break;
        case XMLATTR:
          ret.tx("In the XML format, this property is represented as an attribute.");
          break;
        case XMLTEXT:
          ret.tx("In the XML format, this property is represented as unadorned text.");
          break;
        default:
        }
      }
    }
    String name = ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_XML_NAMESPACE);
    if (name == null && root) {
      name = ToolingExtensions.readStringExtension(profile, ToolingExtensions.EXT_XML_NAMESPACE);
    }
    if (name != null) {
      ret.codeWithText("In the XML format, this property has the namespace ", name, ".");
    }
    name = ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_XML_NAME);
    if (name != null) {
      ret.codeWithText("In the XML format, this property has the actual name", name, ".");
    }
    boolean no = root && ToolingExtensions.readBoolExtension(profile, ToolingExtensions.EXT_XML_NO_ORDER);
    if (no) {
      ret.tx("The children of this property can appear in any order in the XML.");
    }
    return ret;
  }

  private XhtmlNode describeJson(ElementDefinition d) {
    XhtmlNode ret = new XhtmlNode(NodeType.Element, "div");
    var ul = ret.ul();
    boolean list = ToolingExtensions.countExtensions(d, ToolingExtensions.EXT_JSON_EMPTY, ToolingExtensions.EXT_JSON_PROP_KEY, ToolingExtensions.EXT_JSON_NULLABLE, ToolingExtensions.EXT_JSON_NAME) > 1;

    String code = ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_JSON_EMPTY);
    if (code != null) {
      switch (code) {
      case "present":
        ul.li().tx("The JSON Array for this property is present even when there are no items in the instance (e.g. as an empty array)");
        break;
      case "absent":
        ul.li().tx("The JSON Array for this property is not present when there are no items in the instance (e.g. never as an empty array)");
        break;
      case "either":
        ul.li().tx("The JSON Array for this property may be present even when there are no items in the instance (e.g. may be present as an empty array)");
        break;
      }
    }
    String jn = ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_JSON_NAME);
    if (jn != null) {
      if (d.getPath().contains(".")) {
        ul.li().codeWithText("This property appears in JSON with the property name ", jn, null);
      } else {
        ul.li().codeWithText("This type can appear in JSON with the property name ", jn, " (in elements using named extensions)");          
      }
    }
    code = ToolingExtensions.readStringExtension(d, ToolingExtensions.EXT_JSON_PROP_KEY);
    if (code != null) {
      ul.li().codeWithText("This repeating object is represented as a single JSON object with named properties. The name of the property (key) is the value of the ", code, " child");
    }
    if (ToolingExtensions.readBoolExtension(d, ToolingExtensions.EXT_JSON_NULLABLE)) {
      ul.li().tx("This object can be represented as null in the JSON structure (which counts as 'present' for cardinality purposes)");
    }
    if (ToolingExtensions.readBoolExtension(d, ToolingExtensions.EXT_JSON_PRIMITIVE_CHOICE)) {
      ul.li().tx("The type of this element is inferred from the JSON type in the instance");
    }

    switch (ul.getChildNodes().size()) {
    case 0: return null;
    case 1: return ul.getChildNodes().get(0);
    default: return ret;
    }
  }

  private XhtmlNode describeObligations(ElementDefinition d, boolean root, StructureDefinition sdx) throws IOException {
    XhtmlNode ret = new XhtmlNode(NodeType.Element, "div");
    ObligationsRenderer obr = new ObligationsRenderer(corePath, sdx, d.getPath(), context, hostMd, this);
    obr.seeObligations(d.getExtensionsByUrl(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS));
    obr.seeRootObligations(d.getId(), sdx.getExtensionsByUrl(ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS));
    if (obr.hasObligations() || (root && (sdx.hasExtension(ToolingExtensions.EXT_OBLIGATION_PROFILE_FLAG) || sdx.hasExtension(ToolingExtensions.EXT_OBLIGATION_INHERITS)))) {
      XhtmlNode ul = ret.ul();
      if (root) {
        if (sdx.hasExtension(ToolingExtensions.EXT_OBLIGATION_PROFILE_FLAG)) {
          ul.li().tx("This is an obligation profile that only contains obligations and additional bindings");           
        } 
        for (Extension ext : sdx.getExtensionsByUrl(ToolingExtensions.EXT_OBLIGATION_INHERITS)) {
          String iu = ext.getValue().primitiveValue();
          XhtmlNode bb = ul.li();
          bb.tx("This profile picks up obligations and additional bindings from ");           
          StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, iu); 
          if (sd == null) { 
            bb.code().tx(iu);                     
          } else if (sd.hasWebPath()) { 
            bb.ah(sd.getWebPath()).tx(sd.present());
          } else { 
            bb.ah(iu).tx(sd.present());
          } 
        }  
        if (ul.isEmpty()) {
          ret.remove(ul);
        }
      }
      if (obr.hasObligations()) {
        XhtmlNode tbl = ret.table("grid");
        obr.renderTable(tbl.getChildNodes(), true);
        if (tbl.isEmpty()) {
          ret.remove(tbl);
        }
      }
      return ret.hasChildren() ? ret : null;
    } else {
      return null;
    }
  }

  private XhtmlNode describeAllowedUnits(ElementDefinition d) {
    XhtmlNode ret = new XhtmlNode(NodeType.Element, "div");
    DataType au = ToolingExtensions.getAllowedUnits(d);
    if (au instanceof CanonicalType) {
      String url = ((CanonicalType) au).asStringValue();
      ValueSet vs = context.getContext().fetchResource(ValueSet.class, url);
      ret.tx("Value set ");         
      genCT(ret, url, vs);
      return ret;
    } else if (au instanceof CodeableConcept) {
      CodeableConcept cc = (CodeableConcept) au;
      if (cc.getCoding().size() != 1) {
        ret.tx("One of:");
      }
      ret.tx(summarise(cc));
      return ret;
    }
    return null;
  }

  private void genCT(XhtmlNode x, String url, CanonicalResource cr) {
    if (cr == null) {
      x.code().tx(url);
    } else if (!cr.hasWebPath()) {
      x.ah(url).tx(cr.present());
    } else {
      x.ah(cr.getWebPath()).tx(cr.present());
    }
  }

  private boolean hasPrimitiveTypes(ElementDefinition d) {
    for (TypeRefComponent tr : d.getType()) {
      if (context.getContext().isPrimitiveType(tr.getCode())) {
        return true;
      }
    }
    return false;
  }


  private XhtmlNode renderCanonicalListExt(String text, List<Extension> list) {
    List<CanonicalType> clist = new ArrayList<>();
    for (Extension ext : list) {
      if (ext.hasValueCanonicalType()) {
        clist.add(ext.getValueCanonicalType());
      }
    }
    return renderCanonicalList(text, clist);
  }

  private XhtmlNode renderCanonicalList(String text, List<CanonicalType> list) {
    XhtmlNode ret = new XhtmlNode(NodeType.Element, "div");
    ret.tx(text);
    var ul = ret.ul();
    for (CanonicalType ct : list) {
      CanonicalResource cr = (CanonicalResource) context.getContext().fetchResource(Resource.class,  ct.getValue());
      genCT(ul.li(), ct.getValue(), cr);      
    }
    return ret;
  }

  private StandardsStatus determineStandardsStatus(StructureDefinition sd, ElementDefinition ed) {
    if (ed != null && ed.hasExtension(ToolingExtensions.EXT_STANDARDS_STATUS)) {
      return StandardsStatus.fromCode(ed.getExtensionString(ToolingExtensions.EXT_STANDARDS_STATUS));
    }
    while (sd != null) {
      if (sd.hasExtension(ToolingExtensions.EXT_STANDARDS_STATUS)) {
        return ToolingExtensions.getStandardsStatus(sd);
      }
      sd = context.getContext().fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    }
    return null;
  }

  private boolean hasChoices(List<TypeRefComponent> types) {
    for (TypeRefComponent type : types) {
      if (type.getProfile().size() > 1 || type.getTargetProfile().size() > 1) {
        return true;
      }
    }
    return types.size() > 1;
  }

  private String sliceOrderString(ElementDefinitionSlicingComponent slicing) {
    if (slicing.getOrdered())
      return "ordered";
    else
      return "unordered";
  }
  
  private void generateSlicing(XhtmlNode tbl, StructureDefinition profile, ElementDefinition ed, ElementDefinitionSlicingComponent slicing, ElementDefinition compare, int mode, boolean strikethrough) throws IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    
    x.codeWithText("This element introduces a set of slices on ", ed.getPath(), ". The slices are ");
    String newOrdered = sliceOrderString(slicing);
    String oldOrdered = (compare==null || !compare.hasSlicing()) ? null : sliceOrderString(compare.getSlicing());
    compareString(x, newOrdered, slicing.getOrderedElement(), null, null, null, oldOrdered, null, mode);
    x.tx(" and ");
    compareString(x, slicing.hasRules() ? slicing.getRules().getDisplay() : null, slicing.getRulesElement(), null, "rules", slicing, compare!=null && compare.hasSlicing() && compare.getSlicing().hasRules() ? compare.getSlicing().getRules().getDisplay() : null, null, mode);
    
    if (slicing.hasDiscriminator()) {
      x.tx(", and can be differentiated using the following discriminators: ");
      StatusList<DiscriminatorWithStatus> list = new StatusList<>();
      for (ElementDefinitionSlicingDiscriminatorComponent d : slicing.getDiscriminator()) {
        list.add(new DiscriminatorWithStatus(d));
      }
      if (compare != null) {      
        for (ElementDefinitionSlicingDiscriminatorComponent d : slicing.getDiscriminator()) {
          list.merge(new DiscriminatorWithStatus(d));
        }
      }
      x.tx(", and can be differentiated using the following discriminators: ");
      var ul = x.ul();
      for (DiscriminatorWithStatus rc : list) {
        rc.render(x.li());
      }
    } else {
      x.tx(", and defines no discriminators to differentiate the slices");
    }
    tableRow(tbl, "Slicing", "profiling.html#slicing", strikethrough, x);
    tbl.tx("\r\n");
  }

  private XhtmlNode tableRow(XhtmlNode x, String name, String defRef, boolean strikethrough) throws IOException {
    var tr = x.tr();
    if (strikethrough) {
      tr.style("text-decoration: line-through");
    }
    addFirstCell(name, defRef, tr);
    return tr.td();
  }
  

  private void tableRow(XhtmlNode x, String name, String defRef, boolean strikethrough, XhtmlNode possibleTd) throws IOException {
    if (possibleTd != null && !possibleTd.isEmpty()) {
      var tr = x.tr();
      if (strikethrough) {
        tr.style("text-decoration: line-through");
      }
      addFirstCell(name, defRef, tr);
      tr.td().copyAllContent(possibleTd);
    }
  }

  private void tableRow(XhtmlNode x, String name, String defRef, boolean strikethrough, String text) throws IOException {
    if (!Utilities.noString(text)) {
      var tr = x.tr();
      if (strikethrough) {
        tr.style("text-decoration: line-through");
      }
      addFirstCell(name, defRef, tr);
      tr.td().tx(text);
    }
  }

  private void addFirstCell(String name, String defRef, XhtmlNode tr) {
    var td = tr.td();
    if (name.length() <= 16) {
     td.style("white-space: nowrap");
    }
    if (defRef == null) {
      td.tx(name);
    } else if (Utilities.isAbsoluteUrl(defRef)) {
      td.ah(defRef).tx(name);
    } else {
      td.ah(corePath+defRef).tx(name);
    }
  }

  private String head(String path) {
    if (path.contains("."))
      return path.substring(0, path.indexOf("."));
    else
      return path;
  }
  private String nottail(String path) {
    if (path.contains("."))
      return path.substring(0, path.lastIndexOf("."));
    else
      return path;
  }

  private XhtmlNode businessIdWarning(String resource, String name) {
    if (name.equals("identifier")) {
      XhtmlNode ret = new XhtmlNode(NodeType.Element, "div");
      ret.tx("This is a business identifier, not a resource identifier (see ");
      ret.ah(corePath + "resource.html#identifiers").tx("discussion");
      ret.tx(")");
      return ret;
    } 
    if (name.equals("version")) {// && !resource.equals("Device"))
      XhtmlNode ret = new XhtmlNode(NodeType.Element, "div");
      ret.tx("This is a business versionId, not a resource version id (see ");
      ret.ah(corePath + "resource.html#versions").tx("discussion");
      ret.tx(")");
      return ret;
    }
    return null;
  }

  private XhtmlNode describeCardinality(ElementDefinition d, ElementDefinition compare, int mode) throws IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    if (compare==null || mode==GEN_MODE_DIFF) {
      if (!d.hasMax() && !d.hasMin())
        return null;
      else if (d.getMax() == null) {
        renderStatus(d.getMinElement(), x).tx(toStr(d.getMin()));
        x.tx("..?");
      } else {
        renderStatus(d.getMinElement(), x).tx(toStr(d.getMin()));
        x.tx( "..");
        renderStatus(d.getMaxElement(), x).tx( d.getMax());
      }
    } else {
      if (!(mode==GEN_MODE_DIFF && (d.getMin()==compare.getMin() || d.getMin()==0))) {
        compareString(x, toStr(d.getMin()), d.getMinElement(), null, "min", d, toStr(compare.getMin()), null, mode);
      }
      x.tx("..");
      if (!(mode==GEN_MODE_DIFF && (d.getMax().equals(compare.getMax()) || "1".equals(d.getMax())))) {
        compareString(x, d.getMax(), d.getMaxElement(), null, "max", d, compare.getMax(), null, mode);
      }
    }
    XhtmlNode t = compareSimpleTypeLists(d.getCondition(), compare == null ? null : compare.getCondition(), mode);
    if (t != null) {
      x.br();
      x.tx("This element is affected by the following invariants: "); 
      x.copyAllContent(t);
    }    
    return x;
  }
  
  private boolean hasMustSupportTypes(List<TypeRefComponent> types) {
    for (TypeRefComponent tr : types) {
      if (isMustSupport(tr)) {
        return true;
      }
    }
    return false;
  }

  private XhtmlNode describeTypes(List<TypeRefComponent> types, boolean mustSupportOnly, ElementDefinition ed, ElementDefinition compare, int mode, ElementDefinition value, ElementDefinition compareValue, StructureDefinition sd) throws FHIRException, IOException {
    if (types.isEmpty())
      return null;

    List<TypeRefComponent> compareTypes = compare==null ? new ArrayList<>() : compare.getType();
    XhtmlNode ret = new XhtmlNode(NodeType.Element, "div");
    if ((!mustSupportOnly && types.size() == 1 && compareTypes.size() <=1 && (mode != GEN_MODE_DIFF || !VersionComparisonAnnotation.hasDeleted(ed, "type"))) || (mustSupportOnly && mustSupportCount(types) == 1)) {
      if (!mustSupportOnly || isMustSupport(types.get(0))) {
        describeType(ret, types.get(0), mustSupportOnly, compareTypes.size()==0 ? null : compareTypes.get(0), mode, sd);
      }
    } else {
      boolean first = true;
      if (types.size() > 1) {
        ret.tx("Choice of: ");
      }
      Map<String,TypeRefComponent> map = new HashMap<String, TypeRefComponent>();
      for (TypeRefComponent t : compareTypes) {
        map.put(t.getCode(), t);
      }
      for (TypeRefComponent t : types) {
        TypeRefComponent compareType = map.get(t.getCode());
        if (compareType!=null)
          map.remove(t.getCode());
        if (!mustSupportOnly || isMustSupport(t)) {
          if (first) {
            first = false;
          } else {
            ret.tx(", ");
          }
          describeType(ret, t, mustSupportOnly, compareType, mode, sd);
        }
      }
      for (TypeRefComponent t : map.values()) {
        ret.tx(", ");
        describeType(removed(ret), t, mustSupportOnly, null, mode, sd);
      }
      if (mode == GEN_MODE_DIFF) {
        for (Base b : VersionComparisonAnnotation.getDeleted(ed, "type")) {
          TypeRefComponent t = (TypeRefComponent) b;
          ret.tx(", ");
          describeType(ret, t, false, null, mode, sd);
        }
      }
    }
    if (value != null) {
      XhtmlNode xt = processSecondary(mode, value, compareValue, mode, sd);
      if (xt != null) {
        ret.copyAllContent(xt);
      }    
    }
    return ret;
  }
  
  private XhtmlNode processSecondary(int mode, ElementDefinition value, ElementDefinition compareValue, int compMode, StructureDefinition sd) throws FHIRException, IOException {
    switch (mode) {
    case 1:
      return null;
    case 2:
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      x.tx(" (Complex Extension)");
      return x;
    case 3:
      x = new XhtmlNode(NodeType.Element, "div");
      x.tx(" (Extension Type: ");
      x.copyAllContent(describeTypes(value.getType(), false, value, compareValue, compMode, null, null, sd));
      x.tx(")");
      return x;
    default:
      return null;
    }
  }


  private int mustSupportCount(List<TypeRefComponent> types) {
    int c = 0;
    for (TypeRefComponent tr : types) {
      if (isMustSupport(tr)) {
        c++;
      }
    }
    return c;
  }

  
  private void describeType(XhtmlNode x, TypeRefComponent t, boolean mustSupportOnly, TypeRefComponent compare, int mode, StructureDefinition sd) throws FHIRException, IOException {
    if (t.getWorkingCode() == null) {
      return;
    }
    if (t.getWorkingCode().startsWith("=")) {
      return;
    }

    boolean ts = false;
    if (t.getWorkingCode().startsWith("xs:")) {
      ts = compareString(x, t.getWorkingCode(), t, null, "code", t, compare==null ? null : compare.getWorkingCode(), null, mode);
    } else {
      ts = compareString(x, t.getWorkingCode(), t, getTypeLink(t, sd), "code", t, compare==null ? null : compare.getWorkingCode(), compare==null ? null : getTypeLink(compare, sd), mode);
    }
    
    if ((!mustSupportOnly && (t.hasProfile() || (compare!=null && compare.hasProfile()))) || isMustSupport(t.getProfile())) {
      StatusList<ResolvedCanonical> profiles = analyseProfiles(t.getProfile(), compare == null ? null : compare.getProfile(), mustSupportOnly, mode);      
      if (profiles.size() > 0) {
        if (!ts) {
          getTypeLink(unchanged(x), t, sd);
          ts = true;
        }
        x.tx("(");
        boolean first = true;
        for (ResolvedCanonical rc : profiles) {
          if (first) first = false; else x.tx(", ");
          rc.render(x);
        }
        x.tx(")");
      }
    }
    
    if ((!mustSupportOnly && (t.hasTargetProfile() || (compare!=null && compare.hasTargetProfile()))) || isMustSupport(t.getTargetProfile())) {
      List<ResolvedCanonical> profiles = analyseProfiles(t.getTargetProfile(), compare == null ? null : compare.getTargetProfile(), mustSupportOnly, mode);      
      if (profiles.size() > 0) {
        if (!ts) {
          getTypeLink(unchanged(x), t, sd);
        }
        x.tx("("); // todo: double use of "(" is problematic
        boolean first = true;
        for (ResolvedCanonical rc : profiles) {
          if (first) first = false; else x.tx(", ");
          rc.render(x);
        }
        x.tx(")");
      }

      if (!t.getAggregation().isEmpty() || (compare!=null && !compare.getAggregation().isEmpty())) {
        
        for (Enumeration<AggregationMode> a :t.getAggregation()) {
          a.setUserData("render.link", corePath + "codesystem-resource-aggregation-mode.html#content");
        }
        if (compare!=null) {
          for (Enumeration<AggregationMode> a : compare.getAggregation()) {
            a.setUserData("render.link", corePath + "codesystem-resource-aggregation-mode.html#content");
          }
        }
        var xt = compareSimpleTypeLists(t.getAggregation(), compare == null ? null : compare.getAggregation(), mode);
        if (xt != null) {
          x.copyAllContent(xt);
        }
      }
    }
  }

  private StatusList<ResolvedCanonical> analyseProfiles(List<CanonicalType> newProfiles, List<CanonicalType> oldProfiles, boolean mustSupportOnly, int mode) {
    StatusList<ResolvedCanonical> profiles = new StatusList<ResolvedCanonical>();
    for (CanonicalType pt : newProfiles) {
      ResolvedCanonical rc = fetchProfile(pt, mustSupportOnly);
      profiles.add(rc);
    }
    if (oldProfiles!=null && mode != GEN_MODE_DIFF) {
      for (CanonicalType pt : oldProfiles) {
        profiles.merge(fetchProfile(pt, mustSupportOnly));
      }
    }
    return profiles;
  }

  private ResolvedCanonical fetchProfile(CanonicalType pt, boolean mustSupportOnly) {
    if (!pt.hasValue()) {
      return null;
    }
    if (!mustSupportOnly || isMustSupport(pt)) {
      StructureDefinition p = context.getContext().fetchResource(StructureDefinition.class, pt.getValue());
      return new ResolvedCanonical(pt.getValue(), p);
    } else {
      return null;
    }
  }
//
//  private String getTypeProfile(CanonicalType pt, boolean mustSupportOnly) {
//    StringBuilder b = new StringBuilder();
//    if (!mustSupportOnly || isMustSupport(pt)) {
//      StructureDefinition p = context.getContext().fetchResource(StructureDefinition.class, pt.getValue());
//      if (p == null)
//        b.append(pt.getValue());
//      else {
//        String pth = p.getWebPath();
//        b.append("<a href=\"" + Utilities.escapeXml(pth) + "\" title=\"" + pt.getValue() + "\">");
//        b.append(p.getName());
//        b.append("</a>");
//      }
//    }
//    return b.toString();
//  }

  private void getTypeLink(XhtmlNode x, TypeRefComponent t, StructureDefinition sd) {
    String s = context.getPkp().getLinkFor(sd.getWebPath(), t.getWorkingCode());
    if (s != null) {
      x.ah(s).tx(t.getWorkingCode());
    } else {
      x.code().tx(t.getWorkingCode());
    }
  }
  

  private String getTypeLink(TypeRefComponent t, StructureDefinition sd) {
    String s = context.getPkp().getLinkFor(sd.getWebPath(), t.getWorkingCode());
    return s;
  }

  private XhtmlNode displayBoolean(boolean value, BooleanType source, String name, Base parent, BooleanType compare, int mode) {
    String newValue = value ? "true" : source.hasValue() ? "false" : null;
    String oldValue = compare==null || compare.getValue()==null ? null : (compare.getValue()!=true ? null : "true");
    return compareString(newValue, source, null, name, parent, oldValue, null, mode);
  }


  private XhtmlNode invariants(List<ElementDefinitionConstraintComponent> originalList, List<ElementDefinitionConstraintComponent> compareList, ElementDefinition parent, int mode) throws IOException {
    StatusList<InvariantWithStatus> list = new StatusList<>();
    for (ElementDefinitionConstraintComponent v : originalList) {
      if (!v.isEmpty()) {
        list.add(new InvariantWithStatus(v));
      }
    }
    if (compareList != null && mode != GEN_MODE_DIFF) {
      for (ElementDefinitionConstraintComponent v : compareList) {
        list.merge(new InvariantWithStatus(v));
      }
    }
    if (list.size() == 0) {
      return null;
    }
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean first = true;
    for (InvariantWithStatus t : list) {
      if (first) first = false; else x.br();
      t.render(x);
    }
    for (Base b : VersionComparisonAnnotation.getDeleted(parent, "invariant")) {
      if (first) first = false; else x.br();
      InvariantWithStatus ts = new InvariantWithStatus((ElementDefinitionConstraintComponent) b);
      ts.render(x);
    }
    return x;
  }

  private XhtmlNode describeBinding(StructureDefinition sd, ElementDefinition d, String path, ElementDefinition compare, int mode) throws FHIRException, IOException {
    if (!d.hasBinding())
      return null;
    else {
      ElementDefinitionBindingComponent binding = d.getBinding();
      ElementDefinitionBindingComponent compBinding = compare == null ? null : compare.getBinding();
      XhtmlNode bindingDesc = null;
      if (binding.hasDescription()) {
        MarkdownType newBinding = PublicationHacker.fixBindingDescriptions(context.getContext(), binding.getDescriptionElement());
        if (mode == GEN_MODE_SNAP || mode == GEN_MODE_MS) {
          bindingDesc = new XhtmlNode(NodeType.Element, "div");
          bindingDesc.add(new XhtmlParser().parseFragment(hostMd.processMarkdown("Binding.description", newBinding)));
        } else {

          StringType oldBinding = compBinding != null && compBinding.hasDescription() ? PublicationHacker.fixBindingDescriptions(context.getContext(), compBinding.getDescriptionElement()) : null;
          bindingDesc = compareMarkdown("Binding.description", newBinding, oldBinding, mode);
        }
      }
      if (!binding.hasValueSet()) {
        return bindingDesc;
      }
      
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      var nsp = x.span();
      renderBinding(nsp, binding, compBinding, path, sd, mode);      
      if (bindingDesc != null) {
        if (isSimpleContent(bindingDesc)) {
          x.tx(": ");
          x.copyAllContent(bindingDesc.getChildNodes().get(0));
        } else {
          x.br();
          x.copyAllContent(bindingDesc);
        }
      }

      AdditionalBindingsRenderer abr = new AdditionalBindingsRenderer(context.getPkp(), corePath, sd, d.getPath(), context, hostMd, this);

      if (binding.hasExtension(ToolingExtensions.EXT_MAX_VALUESET)) {
        abr.seeMaxBinding(ToolingExtensions.getExtension(binding, ToolingExtensions.EXT_MAX_VALUESET), compBinding==null ? null : ToolingExtensions.getExtension(compBinding, ToolingExtensions.EXT_MAX_VALUESET), mode!=GEN_MODE_SNAP && mode!=GEN_MODE_MS);
      }
      if (binding.hasExtension(ToolingExtensions.EXT_MIN_VALUESET)) {
        abr.seeMinBinding(ToolingExtensions.getExtension(binding, ToolingExtensions.EXT_MIN_VALUESET), compBinding==null ? null : ToolingExtensions.getExtension(compBinding, ToolingExtensions.EXT_MIN_VALUESET), mode!=GEN_MODE_SNAP && mode!=GEN_MODE_MS);
      }
      if (binding.hasExtension(ToolingExtensions.EXT_BINDING_ADDITIONAL)) {
        abr.seeAdditionalBindings(binding.getExtensionsByUrl(ToolingExtensions.EXT_BINDING_ADDITIONAL), compBinding==null ? null : compBinding.getExtensionsByUrl(ToolingExtensions.EXT_BINDING_ADDITIONAL), mode!=GEN_MODE_SNAP && mode!=GEN_MODE_MS);
      }

      if (abr.hasBindings()) {
        var tbl = x.table("grid");
        abr.render(tbl.getChildNodes(), true);
      }
      return x;
    }
  }


  private boolean isSimpleContent(XhtmlNode bindingDesc) {
    return bindingDesc.getChildNodes().size() == 1 && bindingDesc.getChildNodes().get(0).isPara();
  }

  private void renderBinding(XhtmlNode span, ElementDefinitionBindingComponent binding, ElementDefinitionBindingComponent compare, String path, StructureDefinition sd, int mode) {
    compareString(span, conf(binding), binding.getStrengthElement(), null, "strength", binding, compare == null ? null : conf(compare), null, mode);
    span.tx(" ");
    BindingResolution br = context.getPkp().resolveBinding(sd, binding, path);
    compareString(span, br.display, binding.getValueSetElement(), br.url, "valueSet", binding, compare == null ? null : compare.getValueSet(), null, mode);
  }

  private String stripPara(String s) {
    if (s.startsWith("<p>")) {
      s = s.substring(3);
    }
    if (s.trim().endsWith("</p>")) {
      s = s.substring(0, s.lastIndexOf("</p>")-1) + s.substring(s.lastIndexOf("</p>") +4);
    }
    return s;
  }

  private String conf(ElementDefinitionBindingComponent def) {
    if (def.getStrength() == null) {
      return "For codes, see ";
    }
    switch (def.getStrength()) {
    case EXAMPLE:
      return "For example codes, see ";
    case PREFERRED:
      return "The codes SHOULD be taken from ";
    case EXTENSIBLE:
      return "Unless not suitable, these codes SHALL be taken from ";
    case REQUIRED:
      return "The codes SHALL be taken from ";
    default:
      return "?sd-conf?";
    }
  }

  private String encodeValues(List<ElementDefinitionExampleComponent> examples) throws FHIRException, IOException {
    StringBuilder b = new StringBuilder();
    boolean first = false;
    for (ElementDefinitionExampleComponent ex : examples) {
      if (first)
        first = false;
      else
        b.append("<br/>");
      b.append("<b>" + Utilities.escapeXml(ex.getLabel()) + "</b>:" + encodeValue(ex.getValue()) + "\r\n");
    }
    return b.toString();

  }

  private XhtmlNode encodeValue(DataType value, String name, Base parent, DataType compare, int mode) throws FHIRException, IOException {
    String oldValue = encodeValue(compare);
    String newValue = encodeValue(value);
    return compareString(newValue, value, null, name, parent, oldValue, null, mode);
  }

  private String encodeValue(DataType value) throws FHIRException, IOException {
    if (value == null || value.isEmpty())
      return null;
    if (value instanceof PrimitiveType)
      return Utilities.escapeXml(((PrimitiveType) value).asStringValue());

    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    XmlParser parser = new XmlParser();
    parser.setOutputStyle(OutputStyle.PRETTY);
    parser.compose(bs, null, value);
    String[] lines = bs.toString().split("\\r?\\n");
    StringBuilder b = new StringBuilder();
    for (String s : lines) {
      if (!Utilities.noString(s) && !s.startsWith("<?")) { // eliminate the xml header
        b.append(Utilities.escapeXml(s).replace(" ", "&nbsp;") + "<br/>");
      }
    }
    return b.toString();

  }

  private XhtmlNode getMapping(StructureDefinition profile, ElementDefinition d, String uri, ElementDefinition compare, int mode) {
    String id = null;
    for (StructureDefinitionMappingComponent m : profile.getMapping()) {
      if (m.hasUri() && m.getUri().equals(uri))
        id = m.getIdentity();
    }
    if (id == null)
      return null;
    String newMap = null;
    for (ElementDefinitionMappingComponent m : d.getMapping()) {
      if (m.getIdentity().equals(id)) {
        newMap = m.getMap();
        break;
      }
    }
    if (compare==null)
      return new XhtmlNode(NodeType.Element, "div").tx(newMap);
    String oldMap = null;
    for (ElementDefinitionMappingComponent m : compare.getMapping()) {
      if (m.getIdentity().equals(id)) {
        oldMap = m.getMap();
        break;
      }
    }

    return compareString(Utilities.escapeXml(newMap), null, null, "mapping", d, Utilities.escapeXml(oldMap), null, mode);
  }

  private XhtmlNode compareSimpleTypeLists(List<? extends PrimitiveType> original, List<? extends PrimitiveType> compare, int mode) throws IOException {
    return compareSimpleTypeLists(original, compare, mode, ", ");
  }

 
  private XhtmlNode compareSimpleTypeLists(List<? extends PrimitiveType> originalList, List<? extends PrimitiveType> compareList, int mode, String separator) throws IOException {
    StatusList<ValueWithStatus> list = new StatusList<>();
    for (PrimitiveType v : originalList) {
      if (!v.isEmpty()) {
        list.add(new ValueWithStatus(v));
      }
    }
    if (compareList != null && mode != GEN_MODE_DIFF) {
      for (PrimitiveType v : compareList) {
        list.merge(new ValueWithStatus(v));
      }      
    }
    if (list.size() == 0) {
      return null;
    }
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean first = true;
    for (ValueWithStatus t : list) {
      if (first) first = false; else x.tx(separator);
      t.render(x);
    }
    return x;
  }
  

  private XhtmlNode compareDataTypeLists(List<? extends DataType> original, List<? extends DataType> compare, int mode) throws IOException {
    return compareDataTypeLists(original, compare, mode, ", ");
  }

 
  private XhtmlNode compareDataTypeLists(List<? extends DataType> originalList, List<? extends DataType> compareList, int mode, String separator) throws IOException {
    StatusList<DataValueWithStatus> list = new StatusList<>();
    for (DataType v : originalList) {
      if (!v.isEmpty()) {
        list.add(new DataValueWithStatus(v));
      }
    }
    if (compareList != null && mode != GEN_MODE_DIFF) {
      for (DataType v : compareList) {
        list.merge(new DataValueWithStatus(v));
      }      
    }
    if (list.size() == 0) {
      return null;
    }
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean first = true;
    for (DataValueWithStatus t : list) {
      if (first) first = false; else x.tx(separator);
      t.render(x);
    }
    return x;
  }
  

  
  private String summarise(CodeableConcept cc) throws FHIRException {
    if (cc.getCoding().size() == 1 && cc.getText() == null) {
      return summarise(cc.getCoding().get(0));
    } else if (cc.hasText()) {
      return "\"" + cc.getText() + "\"";
    } else if (cc.getCoding().size() > 0) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (Coding c : cc.getCoding()) {
        b.append(summarise(c));
      }
      return b.toString();
    } else {
      throw new FHIRException("Error describing concept - not done yet (no codings, no text)");
    }
  }

  private String summarise(Coding coding) throws FHIRException {
    if ("http://snomed.info/sct".equals(coding.getSystem()))
      return "" + translate("sd.summary", "SNOMED CT code") + " " + coding.getCode() + (!coding.hasDisplay() ? "" : "(\"" + gt(coding.getDisplayElement()) + "\")");
    if ("http://loinc.org".equals(coding.getSystem()))
      return "" + translate("sd.summary", "LOINC code") + " " + coding.getCode() + (!coding.hasDisplay() ? "" : "(\"" + gt(coding.getDisplayElement()) + "\")");
    if ("http://unitsofmeasure.org/".equals(coding.getSystem()))
      return " (" + translate("sd.summary", "UCUM") + ": " + coding.getCode() + ")";
    CodeSystem cs = context.getContext().fetchCodeSystem(coding.getSystem());
    if (cs == null)
      return "<span title=\"" + coding.getSystem() + "\">" + coding.getCode() + "</a>" + (!coding.hasDisplay() ? "" : "(\"" + gt(coding.getDisplayElement()) + "\")");
    else
      return "<a title=\"" + cs.present() + "\" href=\"" + Utilities.escapeXml(cs.getWebPath()) + "#" + cs.getId() + "-" + coding.getCode() + "\">" + coding.getCode() + "</a>" + (!coding.hasDisplay() ? "" : "(\"" + gt(coding.getDisplayElement()) + "\")");
  }

}
