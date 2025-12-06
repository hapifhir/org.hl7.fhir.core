package org.hl7.fhir.r5.renderers; 
 
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.VersionComparisonAnnotation;
import org.hl7.fhir.r5.conformance.profile.BindingResolution;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.ElementChoiceGroup;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.ExtensionContext;
import org.hl7.fhir.r5.conformance.profile.SnapshotGenerationPreProcessor;
import org.hl7.fhir.r5.context.ExpansionOptions;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
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
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DecimalType;
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
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.renderers.mappings.ConceptMapMappingProvider;
import org.hl7.fhir.r5.renderers.mappings.ModelMappingProvider;
import org.hl7.fhir.r5.renderers.mappings.StructureDefinitionMappingProvider;
import org.hl7.fhir.r5.renderers.utils.ElementTable;
import org.hl7.fhir.r5.renderers.utils.ElementTable.ElementTableGrouping;
import org.hl7.fhir.r5.renderers.utils.ElementTable.ElementTableGroupingEngine;
import org.hl7.fhir.r5.renderers.utils.ElementTable.ElementTableGroupingState;
import org.hl7.fhir.r5.renderers.utils.ElementTable.HintDrivenGroupingEngine;
import org.hl7.fhir.r5.renderers.utils.ElementTable.JsonDrivenGroupingEngine;
import org.hl7.fhir.r5.renderers.utils.ElementTable.TableElement;
import org.hl7.fhir.r5.renderers.utils.ElementTable.TableElementConstraint;
import org.hl7.fhir.r5.renderers.utils.ElementTable.TableElementConstraintType;
import org.hl7.fhir.r5.renderers.utils.ElementTable.TableElementDefinition;
import org.hl7.fhir.r5.renderers.utils.ElementTable.TableElementDefinitionType;
import org.hl7.fhir.r5.renderers.utils.ElementTable.TableGroup;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.FixedValueFormat;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.StructureDefinitionRendererMode;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.PublicationHacker;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableGenerationMode;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
 
@MarkedToMoveToAdjunctPackage
@Slf4j
public class StructureDefinitionRenderer extends ResourceRenderer { 
 
  public enum MapStructureMode {
    IN_LIST, NOT_IN_LIST, OTHER
    
  }
  
  public StructureDefinitionRenderer(RenderingContext context) { 
    super(context); 
    hostMd = new InternalMarkdownProcessor(); 
    corePath = context.getContext().getSpecUrl(); 
  } 
  
  @Override
  protected boolean willRenderId(ResourceWrapper r) {
    if (r.isDirect()) {
      StructureDefinition sd = (StructureDefinition) r.getBase();
      return sd.getIdBase().equals(sd.getSnapshot().getElementFirstRep().getPath());
    }
    return false;
  }


  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (!r.isDirect()) {
      // it seems very unlikely that this will change in the future
      x.para().tx("StructureDefinitionRenderer only renders native resources directly");
    } else {
      renderResourceTechDetails(r, x);
      StructureDefinition sd = (StructureDefinition) r.getBase();
      genSummaryTable(status, x, sd);
      if (context.getStructureMode() == StructureDefinitionRendererMode.DATA_DICT) { 
        renderDict(status, sd, sd.getDifferential().getElement(), x.table("dict", false).markGenerated(!context.forValidResource()), false, GEN_MODE_DIFF, "", r);
      } else {
        XhtmlNode node = generateTable(status, context.getDefinitionsTarget(), sd, true, context.getDestDir(), false, sd.getId(), false,
          context.getLink(KnownLinkType.SPEC, false), "", sd.getKind() == StructureDefinitionKind.LOGICAL, false, null, false, context.withUniqueLocalPrefix(null), "r", r, "X");
        if (node == null) {
//          log("This shouldn't happen?");
        } else {
          x.addChildNode(node);
        }
      } 
      status.setExtensions(true); 
    }
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public static class SourcedElementDefinition {
    private StructureDefinition profile; 
    private ElementDefinition definition; 
     
     
    public SourcedElementDefinition(StructureDefinition profile, ElementDefinition definition) { 
      super(); 
      this.profile = profile; 
      this.definition = definition; 
    } 
    public StructureDefinition getProfile() { 
      return profile; 
    } 
    public ElementDefinition getDefinition() { 
      return definition; 
    } 
     
  } 
 
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
 
  private enum ListItemStatus { New, Unchanged, Removed}
 
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

    @Override
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
        f.ah(context.prefixLocalHref(cr.getWebPath())).tx(cr.present()); 
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
      f.b().attribute("title", context.formatPhrase(RenderingContext.STRUC_DEF_FII)).tx(value.getKey()); 
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
      if (value.hasUserData(UserDataNames.render_link)) { 
        f = f.ah(context.prefixLocalHref(value.getUserString(UserDataNames.render_link))); 
      } 
      f.tx(value.asStringValue()); 
    } 
     
  } 
 
  private class DataValueWithStatus extends ItemWithStatus { 
    DataType value;
    private final DataRenderer renderer;
    private final RenderingStatus status;


    protected DataValueWithStatus(DataType value, DataRenderer renderer, RenderingStatus status) {
      this.value = value;
      this.renderer = renderer;
      this.status = status;
    }

    protected boolean matches(ItemWithStatus other) { 
      return ((ValueWithStatus) other).value.equalsDeep(value); 
    } 
 
    public void renderDetails(XhtmlNode f) throws IOException { 
 
      if (value.hasUserData(UserDataNames.render_link)) { 
        f = f.ah(context.prefixLocalHref(value.getUserString(UserDataNames.render_link))); 
      }
      ResourceWrapper v = ResourceWrapper.forType(renderer.context.getContextUtilities(), value);
      renderer.renderDataType(status, f, v);
    }
 
  } 
   
 
  private List<String> keyRows = new ArrayList<>(); 
  private Map<String, Map<String, ElementDefinition>> sdMapCache = new HashMap<>(); 
  private IMarkdownProcessor hostMd; 
  private Map<String, Integer> anchors = new HashMap<>();
 
   
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
 
 
 
  public void describe(XhtmlNode x, StructureDefinition sd) { 
    x.tx(display(sd)); 
  } 
 
  public String display(StructureDefinition sd) { 
    return sd.present(); 
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
  private static final boolean PREFIX_SLICES = true; 
 
  private final boolean ADD_REFERENCE_TO_TABLE = true; 
 
  private boolean useTableForFixedValues = true; 
  private String corePath;
  private JsonObject resourceGroupings; 
  private MapStructureMode mappingsMode;
  private List<StructureDefinition> mappingTargets = new ArrayList<>();
 
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
        source = context.getProfileUtilities().findProfile(url, source);
        if (source == null) { 
          throw new FHIRException(context.formatPhrase(RenderingContext.STRUC_DEF_REND_UNABLE_RES, url, contentReference)); 
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
    throw new Error(context.formatPhrase(RenderingContext.STRUC_DEF_CANT_FIND, contentReference, elements.toString(), source.getUrl())); 
    //    return null; 
  } 
 
  public XhtmlNode generateGrid(String defFile, StructureDefinition profile, String imageFolder, boolean inlineGraphics, String profileBaseFileName, String corePath, String imagePath, Set<String> outputTracker, boolean diff) throws IOException, FHIRException {
    anchors.clear();
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, imageFolder, inlineGraphics, true, "g"); 
    TableModel model = gen.initGridTable(corePath, profile.getId()); 
    List<ElementDefinition> list = profile.getSnapshot().getElement(); 
    List<StructureDefinition> profiles = new ArrayList<StructureDefinition>(); 
    profiles.add(profile); 
    genGridElement(defFile == null ? null : defFile+"#", gen, model.getRows(), list.get(0), list, profiles, true, profileBaseFileName, null, corePath, imagePath, true, profile.getDerivation() == TypeDerivationRule.CONSTRAINT && usesMustSupport(list), diff);
    try { 
      return gen.generate(model, imagePath, 1, outputTracker); 
    } catch (org.hl7.fhir.exceptions.FHIRException e) { 
      throw new FHIRException(e.getMessage(), e); 
    } 
  } 
 
 
  public static class Column { 
    String id; 
    String title; 
    String hint; 
    private String link; 
 
    public Column(String id, String title, String hint) { 
      super(); 
      this.id = id; 
      this.title = title; 
      this.hint = hint; 
    } 
    public Column(String id, String title, String hint, String link) { 
      super(); 
      this.id = id; 
      this.title = title; 
      this.hint = hint; 
      this.link = link; 
    } 
 
  }

  public XhtmlNode generateTable(RenderingStatus status, String defFile, StructureDefinition profile, boolean diff, String imageFolder, boolean inlineGraphics, String profileBaseFileName, boolean snapshot, String corePath, String imagePath,
                                 boolean logicalModel, boolean allInvariants, Set<String> outputTracker, boolean mustSupport, RenderingContext rc, String anchorPrefix, ResourceWrapper res, String idSfx) throws IOException, FHIRException {
    assert(diff != snapshot);// check it's ok to get rid of one of these 
    anchors.clear();
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, imageFolder, inlineGraphics, true, defFile, rc.getUniqueLocalPrefix());

    TableModel model = generateTableInner(status, defFile, profile, diff, profileBaseFileName, snapshot, corePath, imagePath, logicalModel, allInvariants, mustSupport, rc, anchorPrefix, res, idSfx, gen);
    if (model == null) return null;
    try {
      return gen.generate(model, imagePath, 0, outputTracker);
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(context.getWorker().formatMessage(I18nConstants.ERROR_GENERATING_TABLE_FOR_PROFILE__, profile.getUrl(), e.getMessage()), e);
    }
  }

  public XhtmlNode generateAttributeTable(RenderingStatus status, String defFile, StructureDefinition profile, boolean diff, String imageFolder, boolean inlineGraphics, String profileBaseFileName, boolean snapshot, String corePath, String imagePath,
                                 boolean logicalModel, boolean allInvariants, Set<String> outputTracker, boolean mustSupport, RenderingContext rc, String anchorPrefix, ResourceWrapper res, String idSfx) throws IOException, FHIRException {
    assert(diff != snapshot);// check it's ok to get rid of one of these
    anchors.clear();
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, imageFolder, inlineGraphics, true, defFile, rc.getUniqueLocalPrefix());

    TableModel model = generateTableInner(status, defFile, profile, diff, profileBaseFileName, snapshot, corePath, imagePath, logicalModel, allInvariants, mustSupport, rc, anchorPrefix, res, idSfx, gen);
    if (model == null) {
      return null;
    }
    try {
      return gen.generateAttributeTable(model, imagePath, 0, outputTracker);
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(context.getWorker().formatMessage(I18nConstants.ERROR_GENERATING_TABLE_FOR_PROFILE__, profile.getUrl(), e.getMessage()), e);
    }
  }

  private TableModel generateTableInner(RenderingStatus status, String defFile, StructureDefinition profile, boolean diff, String profileBaseFileName, boolean snapshot, String corePath, String imagePath, boolean logicalModel, boolean allInvariants, boolean mustSupport, RenderingContext rc, String anchorPrefix, ResourceWrapper res, String idSfx, HierarchicalTableGenerator gen) throws IOException {
    List<ElementDefinition> list;
    if (diff) {
      list = new SnapshotGenerationPreProcessor(context.getProfileUtilities()).supplementMissingDiffElements(profile);
    } else {
      list = new ArrayList<>();
      list.addAll(profile.getSnapshot().getElement());
    }

    List<Column> columns = new ArrayList<>();
    List<ModelMappingProvider> mappings = new ArrayList<>();
    TableModel model;
    boolean obLists = false;
    switch (context.getStructureMode()) {
    case BINDINGS:
      scanBindings(columns, list);
      model = initCustomTable(gen, corePath, false, true, profile.getId()+ idSfx, rc.getRules() == GenerationRules.IG_PUBLISHER, columns);
      break;
    case OBLIGATIONS:
      obLists = scanObligations(columns, list);
      model = initCustomTable(gen, corePath, false, true, profile.getId()+ idSfx, rc.getRules() == GenerationRules.IG_PUBLISHER, columns);
      break;
    case MAPPINGS:
      mappings = scanForMappings(profile, list, columns);
      if (mappings.isEmpty()) {
        return null;
      }
      model = initCustomTable(gen, corePath, false, true, profile.getId()+ idSfx, rc.getRules() == GenerationRules.IG_PUBLISHER, columns);
      break;
    case SUMMARY:
      model = gen.initNormalTable(corePath, false, true, profile.getId()+ idSfx, rc.getRules() == GenerationRules.IG_PUBLISHER, rc.getRules() == GenerationRules.IG_PUBLISHER ? TableGenerationMode.XHTML : TableGenerationMode.XML);
      break;
    default:
      throw new Error(context.formatPhrase(RenderingContext.STRUC_DEF_ERROR));
    }

    List<StructureDefinition> profiles = new ArrayList<StructureDefinition>();
    profiles.add(profile);
    keyRows.clear();

    genElement(status, defFile == null ? null : defFile +"#", gen, model.getRows(), list.get(0), list, profiles, diff, profileBaseFileName, null, snapshot, corePath, imagePath, true, logicalModel, profile.getDerivation() == TypeDerivationRule.CONSTRAINT && usesMustSupport(list), allInvariants, null, mustSupport, rc, anchorPrefix, profile, columns, res, obLists, mappings, diff);
    return model;
  }

  private List<ModelMappingProvider> scanForMappings(StructureDefinition profile, List<ElementDefinition> list, List<Column> columns) {
    List<ModelMappingProvider> res = new ArrayList<ModelMappingProvider>();
    List<StructureDefinition> items = new ArrayList<StructureDefinition>();

    // first, does this have mappings to other models?
    for (StructureDefinitionMappingComponent map : profile.getMapping()) {
      if (map.hasUri()) {
        StructureDefinition sd = context.getProfileUtilities().findProfile(map.getUri(), profile);
        if (includeSDForMap(sd, true)) {
          items.add(sd);
          res.add(new StructureDefinitionMappingProvider(context, sd, false, profile, map, context.getProfileUtilities().getFpe()));
        }
      }
    }
    for (ConceptMap cm : context.getContext().fetchResourcesByType(ConceptMap.class)) {
      for (ConceptMapGroupComponent grp : cm.getGroup()) {
        if (grp.hasSource() && grp.getSource().equals(ProfileUtilities.getCSUrl(profile))) {
          boolean matched = true;
          String url = ProfileUtilities.getUrlFromCSUrl(grp.getTarget());
          if (url != null) {
            StructureDefinition sd = context.getProfileUtilities().findProfile(url, profile);
            if (includeSDForMap(sd, false) && !items.contains(sd)) {
              matched = true;
              items.add(sd);
              res.add(new ConceptMapMappingProvider(context, sd, false, cm, grp));
            }
          }
          if (!matched) {
            for (StructureDefinition sd : context.getContextUtilities().allStructures()) {
              if (includeSDForMap(sd, false)) {
                String url2 = ProfileUtilities.getCSUrl(sd);
                if (url2.equals(grp.getTarget()) && !items.contains(sd)) {
                  items.add(sd);
                  res.add(new ConceptMapMappingProvider(context, sd, false, cm, grp));
                  break;
                }
              }
            }
          }
        }
      }
    }

    // now look for reverse mappings but only to things we haven't already got forward mappings too
    for (StructureDefinition src : context.getContextUtilities().allStructures()) {
      if (includeSDForMap(src, true)) {
        for (StructureDefinitionMappingComponent map : src.getMapping()) {
          if (map.hasUri() && map.getUri().equals(profile.getUrl()) && !items.contains(src)) {
            items.add(src);
            res.add(new StructureDefinitionMappingProvider(context, src, true, profile, map, context.getProfileUtilities().getFpe()));
          }
        }
      }
    }

    for (ConceptMap cm : context.getContext().fetchResourcesByType(ConceptMap.class)) {
      for (ConceptMapGroupComponent grp : cm.getGroup()) {
        if (grp.hasTarget() && grp.getTarget().equals(ProfileUtilities.getCSUrl(profile))) {
          boolean matched = true;
          String url = ProfileUtilities.getUrlFromCSUrl(grp.getSource());
          if (url != null) {
            StructureDefinition sd = context.getProfileUtilities().findProfile(url, profile);
            if (includeSDForMap(sd, false) && !items.contains(sd)) {
              matched = true;
              items.add(sd);
              res.add(new ConceptMapMappingProvider(context, sd, true, cm, grp));
            }
          }
          if (!matched) {
            for (StructureDefinition sd : context.getContextUtilities().allStructures()) {
              if (includeSDForMap(sd, false)) {
                String url2 = ProfileUtilities.getCSUrl(sd);
                if (url2.equals(grp.getSource()) && !items.contains(sd)) {
                  items.add(sd);
                  res.add(new ConceptMapMappingProvider(context, sd, true, cm, grp));
                  break;
                }
              }
            }
          }
        }
      }
    }
    int i = 0;
    for (ModelMappingProvider mm : res) {
      columns.add(mm.makeColumn("m"+ ++i));
    }
    profile.setUserData(UserDataNames.PROFILE_RENDERED_MAPPINGS, res.size() >= 0);
    return res;
  }

  private boolean includeSDForMap(StructureDefinition sd, boolean okForNull) {
    if (mappingsMode == null) {
      return false;
    }
    switch (mappingsMode) {
    case IN_LIST: return mappingTargets.contains(sd);
    case NOT_IN_LIST: return sd != null && !mappingTargets.contains(sd);
    case OTHER: return sd == null && okForNull;
    default: return false;
    }
  }

  private void scanBindings(List<Column> columns, List<ElementDefinition> list) { 
    Set<String> cols = new HashSet<>(); 
    scanBindings(cols, list, list.get(0)); 
    if (cols.contains("required")) { 
      columns.add(new Column("required", context.formatPhrase(RenderingContext.GENERAL_REQUIRED), context.formatPhrase(RenderingContext.STRUC_DEF_CONC_SET))); 
    } 
    if (cols.contains("extensible")) { 
      columns.add(new Column("extensible", context.formatPhrase(RenderingContext.STRUC_DEF_EXT), context.formatPhrase(RenderingContext.STRUC_DEF_APPROP_CON))); 
    } 
    if (cols.contains("maximum")) { 
      columns.add(new Column("maximum", context.formatPhrase(RenderingContext.STRUC_DEF_MAX), context.formatPhrase(RenderingContext.STRUC_DEF_REQ_BIND))); 
    } 
    if (cols.contains("minimum")) { 
      columns.add(new Column("minimum", context.formatPhrase(RenderingContext.STRUC_DEF_MIN), context.formatPhrase(RenderingContext.GENERAL_BIND_MIN_ALLOW))); 
    } 
    if (cols.contains("candidate")) { 
      columns.add(new Column("candidate", context.formatPhrase(RenderingContext.STRUC_DEF_CAND), context.formatPhrase(RenderingContext.STRUC_DEF_CAND_SUB))); 
    } 
    if (cols.contains("current")) { 
      columns.add(new Column("current", context.formatPhrase(RenderingContext.STRUC_DEF_CURR), context.formatPhrase(RenderingContext.STRUC_DEF_CURR_RULE))); 
    } 
    if (cols.contains("preferred")) { 
      columns.add(new Column("preferred", context.formatPhrase(RenderingContext.GENERAL_PREFERRED), context.formatPhrase(RenderingContext.STRUC_DEF_PREF_CONT))); 
    } 
    if (cols.contains("ui")) { 
      columns.add(new Column("ui", context.formatPhrase(RenderingContext.STRUC_DEF_UI), context.formatPhrase(RenderingContext.STRUC_DEF_UI_CONT))); 
    } 
    if (cols.contains("starter")) { 
      columns.add(new Column("starter", context.formatPhrase(RenderingContext.GENERAL_STARTER), context.formatPhrase(RenderingContext.ADD_BIND_DESIG_SYS))); 
    } 
    if (cols.contains("component")) { 
      columns.add(new Column("component", context.formatPhrase(RenderingContext.GENERAL_COMPONENT), context.formatPhrase(RenderingContext.STRUC_DEF_COMP_DOC))); 
    } 
    if (cols.contains("example")) { 
      columns.add(new Column("example", context.formatPhrase(RenderingContext.GENERAL_EXAMPLE), context.formatPhrase(RenderingContext.STRUC_DEF_EX_DESC))); 
    } 
  } 
 
  public void scanBindings(Set<String> cols, List<ElementDefinition> list, ElementDefinition ed) { 
    if (ed.hasBinding()) { 
      if (ed.getBinding().hasValueSet() && ed.getBinding().hasStrength()) { 
        switch (ed.getBinding().getStrength()) { 
        case EXAMPLE: 
          cols.add(context.formatPhrase(RenderingContext.STRUC_DEF_EXAM)); 
          break; 
        case EXTENSIBLE: 
          cols.add(context.formatPhrase(RenderingContext.STRUC_DEF_EXTENSIBLE)); 
          break; 
        case PREFERRED: 
          cols.add(context.formatPhrase(RenderingContext.STRUC_DEF_PREFERRED)); 
          break; 
        case REQUIRED: 
          cols.add(context.formatPhrase(RenderingContext.STRUC_DEF_REQUIRED)); 
          break; 
        default: 
          break; 
        } 
      } 
      for (ElementDefinitionBindingAdditionalComponent ab : ed.getBinding().getAdditional()) { 
        cols.add(ab.getPurpose().toCode()); 
      } 
      for (Extension ext : ed.getBinding().getExtensionsByUrl(ExtensionDefinitions.EXT_BINDING_ADDITIONAL)) { 
        cols.add(ext.getExtensionString("purpose"));         
      } 
    } 
 
    List<ElementDefinition> children = getChildren(list, ed); 
    for (ElementDefinition element : children) { 
      scanBindings(cols, list, element); 
    } 
  } 
 
  private boolean scanObligations(List<Column> columns, List<ElementDefinition> list) { 
    Set<String> cols = new HashSet<>(); 
    boolean res = scanObligations(cols, list, list.get(0)); 
 
    if (cols.contains("$all")) { 
      columns.add(new Column("$all", context.formatPhrase(RenderingContext.STRUC_DEF_ALL_ACTORS), context.formatPhrase(RenderingContext.STRUC_DEF_OBLIG_ALL))); 
    } 
    for (String col : cols) { 
      if (!"$all".equals(col)) { 
        ActorDefinition actor = context.getWorker().fetchResource(ActorDefinition.class, col); 
        if (actor == null) { 
          columns.add(new Column(col, urlTail(col), context.formatPhrase(RenderingContext.STRUC_DEF_UNDEF_ACT, col, col)+" "));           
        } else { 
          columns.add(new Column(col, actor.present(), context.formatPhrase(RenderingContext.STRUC_DEF_ACT, actor.present(), actor.getWebPath())+" "));                     
        } 
      } 
    } 
    return res;
  } 
 
  private String urlTail(String url) {
    return url.contains("/") ? url.substring(url.lastIndexOf("/")+1) : url;
  }

  private boolean scanObligations(Set<String> cols, List<ElementDefinition> list, ElementDefinition ed) { 
    boolean res = true;
    Map<String, Integer> nameCounts = new HashMap<>();
    for (Extension ob : ed.getExtensionsByUrl(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)) {
      if (ob.hasExtension("actor", "actorId")) { 
        for (Extension a : ob.getExtensionsByUrl("actor", "actorId")) {
          String name = a.getValueCanonicalType().primitiveValue();
          cols.add(name); 
          nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);
        }
      } else  {
        cols.add("$all");
        nameCounts.put("$all", nameCounts.getOrDefault("$all", 0) + 1);
      }
    } 
    for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
      if (entry.getValue() > 1) {
        res = false;
      }
    }
    List<ElementDefinition> children = getChildren(list, ed); 
    for (ElementDefinition element : children) { 
      res = scanObligations(cols, list, element) && res; 
    } 
    return res;
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
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), (context.formatPhrase(RenderingContext.GENERAL_NAME)), (context.formatPhrase(RenderingContext.GENERAL_LOGICAL_NAME)), null, 0)); 
    for (Column col : columns) { 
      model.getTitles().add(gen.new Title(null, model.getDocoRef(), (col.title), (col.hint), null, 0));       
    } 
    return model; 
  } 
 

  public TableModel initElementTable(HierarchicalTableGenerator gen, String prefix, boolean alternating, String id, boolean isActive, TableGenerationMode mode) throws IOException {
    TableModel model = gen.new TableModel(id, isActive);
    
    model.setAlternating(alternating);
    if (mode == TableGenerationMode.XML) {
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());     
    } else {
      model.setDocoImg(Utilities.pathURL(prefix, "help16.png"));
    }
    model.setDocoRef(Utilities.pathURL("https://build.fhir.org/ig/FHIR/ig-guidance", "readingIgs.html#table-views"));
    // these need to be defined, but they're never going to be shown
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingI18nContext.GENERAL_NAME), context.formatPhrase(RenderingI18nContext.GENERAL_LOGICAL_NAME), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingI18nContext.GENERAL_DESC_CONST), context.formatPhrase(RenderingI18nContext.SD_HEAD_DESC_DESC), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingI18nContext.GENERAL_TYPE), context.formatPhrase(RenderingI18nContext.SD_GRID_HEAD_TYPE_DESC), null, 0));
    return model;
  }
  
  private Row genElement(RenderingStatus status, String defPath, HierarchicalTableGenerator gen, List<Row> rows, ElementDefinition element, List<ElementDefinition> all, List<StructureDefinition> profiles, boolean showMissing, String profileBaseFileName, Boolean extensions,  
      boolean snapshot, String corePath, String imagePath, boolean root, boolean logicalModel, boolean isConstraintMode, boolean allInvariants, Row slicingRow, boolean mustSupport, RenderingContext rc, String anchorPrefix, StructureDefinition srcSD, List<Column> columns, ResourceWrapper res, boolean obLists, List<ModelMappingProvider> mappings, boolean diff) throws IOException, FHIRException {
    Row originalRow = slicingRow; 
    StructureDefinition profile = profiles == null ? null : profiles.get(profiles.size()-1); 
    Row typesRow = null; 
 
    List<ElementDefinition> children = getChildren(all, element); 
    //    if (!snapshot && isExtension && extensions != null && extensions != isExtension) 
    //      return; 
 
    if (!(onlyInformationIsMapping(all, element) || (context.getStructureMode() == StructureDefinitionRendererMode.OBLIGATIONS && !elementOrDescendentsHaveObligations(all, element)))) { 
      Row row = gen.new Row();
      // in deeply sliced things, there can be duplicate paths that are not usefully differentiated by id, and anyway, we want path
      String anchor = element.getPath();
      anchor = makeAnchorUnique(anchor);
      row.setId(context.prefixAnchor(anchor)); 
      row.setAnchor(context.prefixAnchor(anchor)); 
      row.setColor(context.getProfileUtilities().getRowColor(element, isConstraintMode)); 
      if (element.hasSlicing()) 
        row.setLineColor(1); 
      else if (element.hasSliceName()) 
        row.setLineColor(2); 
      else 
        row.setLineColor(0); 
      boolean hasDef = element != null; 
      boolean ext = false; 
      if (tail(element.getPath()).equals("extension") && isExtension(element)) { 
        if (element.hasType() && element.getType().get(0).hasProfile() && extensionIsComplex(element.getType().get(0).getProfile().get(0).getValue(), srcSD))
          row.setIcon("icon_extension_complex.png", context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_COMPLEX)); 
        else 
          row.setIcon("icon_extension_simple.png", context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_SIMPLE)); 
        ext = true; 
      } else if (tail(element.getPath()).equals("modifierExtension")) { 
        if (element.hasType() && element.getType().get(0).hasProfile() && extensionIsComplex(element.getType().get(0).getProfile().get(0).getValue(), srcSD))
          row.setIcon("icon_modifier_extension_complex.png", context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_COMPLEX)); 
        else 
          row.setIcon("icon_modifier_extension_simple.png", context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_SIMPLE));
        ext = true;
      } else if (!hasDef || element.getType().size() == 0) { 
        if (root && profile != null && context.getWorker().getResourceNames().contains(profile.getType())) { 
          row.setIcon("icon_resource.png", context.formatPhrase(RenderingContext.GENERAL_RESOURCE)); 
        } else if (hasDef && element.hasExtension(ExtensionDefinitions.EXT_JSON_PROP_KEY)) { 
          row.setIcon("icon-object-box.png", context.formatPhrase(RenderingContext.TEXT_ICON_OBJECT_BOX)); 
          keyRows.add(element.getId()+"."+ ExtensionUtilities.readStringExtension(element, ExtensionDefinitions.EXT_JSON_PROP_KEY));
        } else { 
          row.setIcon("icon_element.gif", context.formatPhrase(RenderingContext.TEXT_ICON_ELEMENT)); 
        } 
      } else if (hasDef && element.getType().size() > 1) { 
        if (allAreReference(element.getType())) { 
          row.setIcon("icon_reference.png", context.formatPhrase(RenderingContext.TEXT_ICON_REFERENCE)); 
        } else if (element.hasExtension(ExtensionDefinitions.EXT_JSON_PRIMITIVE_CHOICE)) { 
          row.setIcon("icon_choice.gif", context.formatPhrase(RenderingContext.TEXT_ICON_CHOICE)); 
        } else { 
          row.setIcon("icon_choice.gif", context.formatPhrase(RenderingContext.TEXT_ICON_CHOICE)); 
          typesRow = row; 
        } 
      } else if (hasDef && element.getType().get(0).getWorkingCode() != null && element.getType().get(0).getWorkingCode().startsWith("@")) { 
        row.setIcon("icon_reuse.png", context.formatPhrase(RenderingContext.TEXT_ICON_REUSE)); 
      } else if (hasDef && context.getContext().isPrimitiveType(element.getType().get(0).getWorkingCode())) { 
        if (keyRows.contains(element.getId())) { 
          row.setIcon("icon-key.png", context.formatPhrase(RenderingContext.TEXT_ICON_KEY)); 
        } else { 
          row.setIcon("icon_primitive.png", context.formatPhrase(RenderingContext.TEXT_ICON_PRIMITIVE)); 
        } 
      } else if (hasDef && element.getType().get(0).hasTarget()) { 
        row.setIcon("icon_reference.png", context.formatPhrase(RenderingContext.TEXT_ICON_REFERENCE)); 
      } else if (hasDef && context.getContext().isDataType(element.getType().get(0).getWorkingCode())) { 
        row.setIcon("icon_datatype.gif", context.formatPhrase(RenderingContext.TEXT_ICON_DATATYPE)); 
      } else if (hasDef && element.hasExtension(ExtensionDefinitions.EXT_JSON_PROP_KEY)) { 
        row.setIcon("icon-object-box.png", context.formatPhrase(RenderingContext.TEXT_ICON_OBJECT_BOX)); 
        keyRows.add(element.getId()+"."+ExtensionUtilities.readStringExtension(element, ExtensionDefinitions.EXT_JSON_PROP_KEY)); 
      } else if (hasDef && Utilities.existsInList(element.getType().get(0).getWorkingCode(), "Base", "Element", "BackboneElement")) { 
        row.setIcon("icon_element.gif", context.formatPhrase(RenderingContext.TEXT_ICON_ELEMENT)); 
      } else { 
        row.setIcon("icon_resource.png", context.formatPhrase(RenderingContext.GENERAL_RESOURCE)); 
      } 
      if (element.hasUserData(UserDataNames.render_opaque)) { 
        row.setOpacity("0.5"); 
      } 
      UnusedTracker used = new UnusedTracker(); 
      String ref = defPath == null ? null : defPath + element.getId(); 
      String sName = null;
      if (PREFIX_SLICES) {
    	sName = tail(element.getPath());
    	if (element.hasSliceName()) {
    	  sName = sName + ":" + element.getSliceName();
    	}    	  
      } else {
        sName = element.hasSliceName() ? element.getSliceName() : tail(element.getPath());
      }
      used.used = true; 
      if (logicalModel) { 
        if (element.hasRepresentation(PropertyRepresentation.XMLATTR)) { 
          sName = "@"+sName; 
        } else if (element.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER)) { 
          ElementDefinition drv = (ElementDefinition) element.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER); 
          if (drv.hasRepresentation(PropertyRepresentation.XMLATTR)) { 
            sName = "@"+sName; 
          } 
        } 
      } 
      Cell nc = genElementNameCell(gen, element, profileBaseFileName, snapshot, corePath, imagePath, root, logicalModel, allInvariants, profile, typesRow, row, hasDef, ext, used, ref, sName, all); 
      switch (context.getStructureMode()) { 
      case BINDINGS: 
        genElementBindings(gen, element, columns, row, profile, corePath); 
        break; 
      case OBLIGATIONS: 
        genElementObligations(gen, element, columns, row, corePath, profile, obLists); 
        break; 
      case MAPPINGS: 
        genElementMappings(gen, element, columns, row, corePath, profile, mappings); 
        break;         
      case SUMMARY: 
        genElementCells(status, gen, element, profileBaseFileName, snapshot, corePath, imagePath, root, logicalModel, allInvariants, profile, typesRow, row, hasDef, ext, used, ref, nc, mustSupport, true, rc, children.size() > 0, defPath, anchorPrefix, all, res, diff);
        break; 
      } 
      if (element.hasSlicing()) { 
        if (standardExtensionSlicing(element)) { 
          used.used = true; // doesn't matter whether we have a type, we're used if we're setting up slicing ... element.hasType() && element.getType().get(0).hasProfile(); 
          showMissing = false; //? 
          slicingRow = row; 
        } else { 
          row.setIcon("icon_slice.png", context.formatPhrase(RenderingContext.TEXT_ICON_SLICE)); 
          slicingRow = row; 
          for (Cell cell : row.getCells()) 
            for (Piece p : cell.getPieces()) { 
              p.addStyle("font-style: italic"); 
            } 
        } 
      } else if (element.hasSliceName()) { 
        row.setIcon("icon_slice_item.png", context.formatPhrase(RenderingContext.TEXT_ICON_SLICE_ITEM)); 
      } 
      if (used.used || showMissing) 
        rows.add(row); 
      if (!used.used && !element.hasSlicing()) { 
        for (Cell cell : row.getCells()) 
          for (Piece p : cell.getPieces()) {
            if (p.isUnderived()) {
              p.setStyle("font-style: italic");
            } else {
              p.setStyle("text-decoration:line-through");
            }
          }
      } else { 
        if (slicingRow != originalRow && !children.isEmpty()) { 
          // we've entered a slice; we're going to create a holder row for the slice children 
          Row hrow = gen.new Row();
          String anchorE = makeAnchorUnique(element.getPath());
          hrow.setId(context.prefixAnchor(anchorE)); 
          hrow.setAnchor(context.prefixAnchor(anchorE)); 
          hrow.setColor(context.getProfileUtilities().getRowColor(element, isConstraintMode)); 
          hrow.setLineColor(1); 
          hrow.setIcon("icon_element.gif", context.formatPhrase(RenderingContext.TEXT_ICON_ELEMENT)); 
          hrow.getCells().add(gen.new Cell(null, null, sName+ (context.formatPhrase(RenderingContext.STRUC_DEF_ALL_SLICES)), "", null)); 
          switch (context.getStructureMode()) { 
          case BINDINGS: 
          case OBLIGATIONS: 
          case MAPPINGS:
            for (Column col : columns) { 
              hrow.getCells().add(gen.new Cell());               
            } 
            break; 
          case SUMMARY: 
            hrow.getCells().add(gen.new Cell()); 
            hrow.getCells().add(gen.new Cell()); 
            hrow.getCells().add(gen.new Cell()); 
            hrow.getCells().add(gen.new Cell(null, null, context.formatPhrase(RenderingContext.STRUC_DEF_CONT_RULE), "", null)); 
            break;            
          } 
          row.getSubRows().add(hrow); 
          row = hrow; 
        } 
        if (typesRow != null && !children.isEmpty()) { 
          // we've entered a typing slice; we're going to create a holder row for the all types children 
          Row hrow = gen.new Row(); 
          String anchorE = element.getPath();
          anchorE = makeAnchorUnique(anchorE);
          hrow.setId(context.prefixAnchor(anchorE)); 
          hrow.setAnchor(context.prefixAnchor(anchorE)); 
          hrow.setColor(context.getProfileUtilities().getRowColor(element, isConstraintMode)); 
          hrow.setLineColor(1); 
          hrow.setIcon("icon_element.gif", context.formatPhrase(RenderingContext.TEXT_ICON_ELEMENT)); 
          hrow.getCells().add(gen.new Cell(null, null, sName+ context.formatPhrase(RenderingContext.STRUC_DEF_ALL_TYPES), "", null)); 
          switch (context.getStructureMode()) { 
          case BINDINGS: 
          case OBLIGATIONS: 
          case MAPPINGS:
            for (Column col : columns) { 
              hrow.getCells().add(gen.new Cell());               
            } 
            break; 
          case SUMMARY: 
            hrow.getCells().add(gen.new Cell()); 
            hrow.getCells().add(gen.new Cell()); 
            hrow.getCells().add(gen.new Cell()); 
            hrow.getCells().add(gen.new Cell(null, null, context.formatPhrase(RenderingContext.STRUC_DEF_CONT_TYPE), "", null)); 
          } 
          row.getSubRows().add(hrow); 
          row = hrow; 
        } 
 
        Row slicer = null; 
        List<ElementChoiceGroup> groups = readChoices(element, children); 
        boolean isExtension = Utilities.existsInList(tail(element.getPath()), "extension", "modifierExtension"); 
        if (!element.prohibited()) { 
          for (ElementDefinition child : children) { 
            Row parent = null; 
            if (child.hasSliceName()) { 
              // ok, we're a slice 
              if (slicer == null || !noTail(slicer.getId()).equals(child.getPath())) { 
                parent = gen.new Row(); 
                String anchorE = child.getPath();
                anchorE = makeAnchorUnique(anchorE);
                parent.setId(context.prefixAnchor(anchorE)); 
                parent.setAnchor(context.prefixAnchor(anchorE)); 
                parent.setColor(context.getProfileUtilities().getRowColor(child, isConstraintMode)); 
                parent.setLineColor(1); 
                parent.setIcon("icon_slice.png", context.formatPhrase(RenderingContext.TEXT_ICON_SLICE)); 
                parent.getCells().add(gen.new Cell(null, null, context.formatPhrase(RenderingContext.STRUC_DEF_SLICE_FOR, child.getName()), "", null)); 
                switch (context.getStructureMode()) { 
                case BINDINGS: 
                case OBLIGATIONS:
                case MAPPINGS: 
                  for (Column col : columns) { 
                    parent.getCells().add(gen.new Cell());               
                  } 
                  break; 
                case SUMMARY: 
                  parent.getCells().add(gen.new Cell()); 
                  parent.getCells().add(gen.new Cell()); 
                  parent.getCells().add(gen.new Cell()); 
                  parent.getCells().add(gen.new Cell(null, null, context.formatPhrase(RenderingContext.STRUC_DEF_CONT_RULE), "", null)); 
                  break;             
                } 
                row.getSubRows().add(parent); 
                slicer = parent; 
              } else { 
                parent = slicer; 
              } 
            } else { 
              parent = chooseChildRowByGroup(gen, row, groups, child, element, isConstraintMode); 
            } 
 
            if (logicalModel || !child.getPath().endsWith(".id") || (child.getPath().endsWith(".id") && (profile != null) && (profile.getDerivation() == TypeDerivationRule.CONSTRAINT))) {   
              slicer = genElement(status, defPath, gen, parent.getSubRows(), child, all, profiles, showMissing, profileBaseFileName, isExtension, snapshot, corePath, imagePath, false, logicalModel, isConstraintMode, allInvariants, slicer, mustSupport, rc, anchorPrefix, srcSD, columns, res, false, mappings, diff);
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

  private boolean elementOrDescendentsHaveObligations(List<ElementDefinition> all, ElementDefinition element) {
    if (element.hasObligations()) {
      return true;
    }
    int i = all.indexOf(element) + 1;
    while (i < all.size() && all.get(i).getPath().startsWith(element.getPath()+".")) {
      if (all.get(i).hasObligations()) {
        return true;
      }
      i++;
    }
    return false;
  }

  private String noTail(String id) {
    if (id.contains(".")) {
      String t = id.substring(id.lastIndexOf(".")+1);
      if (Utilities.isInteger(t)) {
        return id.substring(0, id.lastIndexOf("."));
      }
    } 
    return id;
  }

  private String makeAnchorUnique(String anchor) {
    if (anchors.containsKey(anchor)) {
      int c = anchors.get(anchor)+1;
      anchors.put(anchor, c);
      anchor = anchor+"."+c;
    } else {
      anchors.put(anchor, 1);
    }
    return anchor;
  } 
 
  private boolean isTypeSlice(ElementDefinition child) { 
    ElementDefinition derived = (ElementDefinition) child.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER); 
    return derived != null && derived.getBase().getPath().endsWith("[x]"); 
  } 
 
  private boolean isExtension(ElementDefinition element) { 
    if (element.getType().isEmpty()) { 
      return true; 
    } 
    String type = element.getTypeFirstRep().getWorkingCode(); 
    return "Extension".equals(type); 
  } 
 
  private void genElementObligations(HierarchicalTableGenerator gen, ElementDefinition element, List<Column> columns, Row row, String corePath, StructureDefinition profile, boolean obLists) throws IOException { 
    for (Column col : columns) {  
      Cell gc = gen.new Cell(); 
      row.getCells().add(gc); 
      ObligationsRenderer obr = new ObligationsRenderer(corePath, profile, element.getPath(), context, null, this, obLists);
      obr.seeObligations(element, col.id); 
      obr.renderList(gen, gc);       
    } 
  } 

  private void genElementMappings(HierarchicalTableGenerator gen, ElementDefinition element, List<Column> columns, Row row, String corePath, StructureDefinition profile, List<ModelMappingProvider> mappings) throws IOException { 
    for (ModelMappingProvider mm : mappings) {  
      Cell gc = gen.new Cell(); 
      row.getCells().add(gc); 
      Piece p = gc.addText("");
      XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
      mm.render(element, div);
      p.addHtml(div);
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
        new AdditionalBindingsRenderer(context.getPkp(), corepath, profile, element.getPath(), context, null, this).render(p.getChildren(), bindings, profile);
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
      if ("maximum".equals(type) && b.hasExtension(ExtensionDefinitions.EXT_MAX_VALUESET)) { 
        ElementDefinitionBindingAdditionalComponent ab = new ElementDefinitionBindingAdditionalComponent(); 
        res.add(ab.setAny(false).setValueSet(ExtensionUtilities.readStringExtension(b, ExtensionDefinitions.EXT_MAX_VALUESET))); 
      } 
      if ("minimum".equals(type) && b.hasExtension(ExtensionDefinitions.EXT_MIN_VALUESET)) { 
        ElementDefinitionBindingAdditionalComponent ab = new ElementDefinitionBindingAdditionalComponent(); 
        res.add(ab.setAny(false).setValueSet(ExtensionUtilities.readStringExtension(b, ExtensionDefinitions.EXT_MIN_VALUESET))); 
      } 
      for (ElementDefinitionBindingAdditionalComponent t : b.getAdditional()) { 
        if (type.equals(t.getPurpose().toCode())) { 
          res.add(t); 
        } 
      } 
      for (Extension ext : b.getExtensionsByUrl(ExtensionDefinitions.EXT_BINDING_ADDITIONAL)) { 
        if (type.equals(ext.getExtensionString("purpose"))) { 
          ElementDefinitionBindingAdditionalComponent ab = new ElementDefinitionBindingAdditionalComponent(); 
          if (ext.hasExtension("any")) { 
            ab.setAny(ExtensionUtilities.readBooleanExtension(ext, "any")); 
          } 
          if (ext.hasExtension("purpose")) { 
            ab.setPurpose(AdditionalBindingPurposeVS.fromCode(ExtensionUtilities.readStringExtension(ext, "purpose"))); 
          } 
          if (ext.hasExtension("documentation")) { 
            ab.setDocumentation(ExtensionUtilities.readStringExtension(ext, "documentation")); 
          } 
          if (ext.hasExtension("shortDoco")) { 
            ab.setShortDoco(ExtensionUtilities.readStringExtension(ext, "shortDoco")); 
          } 
          if (ExtensionUtilities.hasExtension(ext, "usage")) { 
            ab.addUsage(ext.getExtensionByUrl("usage").getValueUsageContext()); 
          } 
          if (ext.hasExtension("valueSet")) { 
            ab.setValueSet(ExtensionUtilities.readStringExtension(ext, "valueSet")); 
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
    hint = checkAdd(hint, element.hasSliceName() ? context.formatPhrase(RenderingContext.STRUC_DEF_SLICE_PAR, element.getSliceName()) : ""); 
    if (hasDef && element.hasDefinition()) { 
      hint = checkAdd(hint, (hasDef && element.hasSliceName() ? ": " : "")); 
      hint = checkAdd(hint, !hasDef ? null : gt(element.getDefinitionElement())); 
    } 
    if (element.hasSlicing() && slicesExist(elements, element)) { // some elements set up slicing but don't actually slice, so we don't augment the name  
      sName = context.formatPhrase(RenderingContext.STRUC_DEF_SLICE_FOR, sName); 
    } 
    Cell left = gen.new Cell(null, ref, sName, hint, null); 
    row.getCells().add(left); 
    if (profile.hasExtension(ExtensionDefinitions.EXT_TYPE_PARAMETER)) {
      Extension etp = profile.getExtensionByUrl(ExtensionDefinitions.EXT_TYPE_PARAMETER);
      String name = etp.getExtensionString("name");
      String type = etp.getExtensionString("type");
      StructureDefinition t = context.getContext().fetchTypeDefinition(type);
      if (t == null) {
        left.addPiece(gen.new Piece(null, "<"+name+" : "+type+">", null));        
      } else if (t.getWebPath() == null) {
        left.addPiece(gen.new Piece(type, "<"+name+" : "+t.present()+">", null));        
      } else {
        left.addPiece(gen.new Piece(t.getWebPath(), "<"+name+" : "+t.present()+">", null));        
      }
    }
    return left; 
  } 
 
  public List<Cell> genElementCells(RenderingStatus status, HierarchicalTableGenerator gen, ElementDefinition element, String profileBaseFileName, boolean snapshot, String corePath, 
      String imagePath, boolean root, boolean logicalModel, boolean allInvariants, StructureDefinition profile, Row typesRow, Row row, boolean hasDef, 
      boolean ext, UnusedTracker used, String ref, Cell nameCell, boolean mustSupport, boolean allowSubRows, RenderingContext rc, boolean walksIntoThis, String defPath, String anchorPrefix, List<ElementDefinition> inScopeElements, ResourceWrapper resource, boolean diff) throws IOException {
    List<Cell> res = new ArrayList<>(); 
    Cell gc = gen.new Cell(); 
    row.getCells().add(gc); 
    res.add(gc); 
    if (element != null && element.getIsModifier()) { 
      checkForNoChange(element.getIsModifierElement(), gc.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_MOD)), "?!", null, null, null, false)); 
    } 
    if (element != null) { 
      if (element.getMustSupport() && element.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)) { 
        checkForNoChange(element.getMustSupportElement(), gc.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_OBLIG_SUPP)), "SO", "white", "red", null, false)); 
      } else if (element.getMustSupport()) { 
          checkForNoChange(element.getMustSupportElement(), gc.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_ELE_MUST_SUPP)), "S", "white", "red", null, false)); 
      } else if (element != null && element.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)) { 
       checkForNoChange(element.getMustSupportElement(), gc.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_OBLIG)), "O", "white", "red", null, false)); 
      } 
    } 
    if (element != null && element.getIsSummary()) { 
      checkForNoChange(element.getIsSummaryElement(), gc.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_ELE_INCLUDED)), "\u03A3", null, null, null, false)); 
    } 
    if (element != null && element.getMustHaveValue()) { 
      checkForNoChange(element.getMustHaveValueElement(), gc.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_ELE)), "V", "maroon", null, null, true)); 
    } 
    if (element != null && (hasNonBaseConstraints(element.getConstraint()) || hasNonBaseConditions(element.getCondition()))) { 
      Piece p = gc.addText(CONSTRAINT_CHAR); 
      p.setHint((context.formatPhrase(RenderingContext.STRUC_DEF_ELE_AFFECTED, listConstraintsAndConditions(element), ")"))); 
      p.addStyle(CONSTRAINT_STYLE); 
      p.setReference(Utilities.pathURL(VersionUtilities.getSpecUrl(context.getWorker().getVersion()), "conformance-rules.html#constraints")); 
    } 
    if (element != null && element.hasExtension(ExtensionDefinitions.EXT_STANDARDS_STATUS)) { 
      StandardsStatus ss = StandardsStatus.fromCode(element.getExtensionString(ExtensionDefinitions.EXT_STANDARDS_STATUS)); 
      gc.addStyledText(context.formatPhrase(RenderingContext.STRUC_DEF_STAND_STATUS) +ss.toDisplay(), ss.getAbbrev(), context.formatPhrase(RenderingContext.STRUC_DEF_BLACK), ss.getColor(), context.getWorker().getSpecUrl()+"versions.html#std-process", true); 
    } 
 
    ExtensionContext extDefn = null; 
    if (ext) { 
      if (element != null) { 
        if (element.getType().size() == 1 && element.getType().get(0).hasProfile()) { 
          String eurl = element.getType().get(0).getProfile().get(0).getValue(); 
          extDefn = locateExtension(StructureDefinition.class, eurl, profile);
          if (extDefn == null) { 
            res.add(genCardinality(gen, element, row, hasDef, used, null)); 
            res.add(addCell(row, gen.new Cell(null, null, "?gen-e1? "+element.getType().get(0).getProfile(), null, null))); 
            res.add(generateDescription(status, gen, row, element, (ElementDefinition) element.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER), profile == null ? "" : profile.getUrl(), eurl, profile, corePath, imagePath, root, logicalModel, allInvariants, snapshot, mustSupport, allowSubRows, rc, inScopeElements, resource));
          } else { 
            String name = element.hasSliceName() ? element.getSliceName() : urlFragmentOrTail(eurl);
//          disable 26-02-2025 GDG - this just makes things inconsistent, and why do this?  nameCell.getPieces().get(0).setText(name); 
            // left.getPieces().get(0).setReference((String) extDefn.getExtensionStructure().getTag("filename")); 
            nameCell.getPieces().get(0).setHint((context.formatPhrase(RenderingContext.STRUC_DEF_EX_URL, extDefn.getUrl()))); 
            res.add(genCardinality(gen, element, row, hasDef, used, extDefn.getElement())); 
            ElementDefinition valueDefn = walksIntoThis ? null : extDefn.getExtensionValueDefinition(); 
            if (valueDefn != null && !"0".equals(valueDefn.getMax())) 
              res.add(genTypes(gen, row, valueDefn, profileBaseFileName, profile, corePath, imagePath, root, mustSupport, diff));
            else // if it's complex, we just call it nothing 
              // genTypes(gen, row, extDefn.getSnapshot().getElement().get(0), profileBaseFileName, profile); 
              res.add(addCell(row, gen.new Cell(null, null, "("+(context.formatPhrase(RenderingContext.STRUC_DEF_COMPLEX))+")", null, null))); 
            res.add(generateDescription(status, gen, row, element, extDefn.getElement(), null, extDefn.getUrl(), profile, corePath, imagePath, root, logicalModel, allInvariants, valueDefn, snapshot, mustSupport, allowSubRows, rc, inScopeElements, resource));
          } 
        } else { 
          res.add(genCardinality(gen, element, row, hasDef, used, null)); 
          if ("0".equals(element.getMax())) 
            res.add(addCell(row, gen.new Cell()));             
          else 
            res.add(genTypes(gen, row, element, profileBaseFileName, profile, corePath, imagePath, root, mustSupport, diff));
          res.add(generateDescription(status, gen, row, element, (ElementDefinition) element.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER), null, null, profile, corePath, imagePath, root, logicalModel, allInvariants, snapshot, mustSupport, allowSubRows, rc, inScopeElements, resource));
        } 
      } 
    } else if (element != null) { 
      res.add(genCardinality(gen, element, row, hasDef, used, null)); 
      if (hasDef && !"0".equals(element.getMax()) && typesRow == null) 
        res.add(genTypes(gen, row, element, profileBaseFileName, profile, corePath, imagePath, root, mustSupport, diff));
      else 
        res.add(addCell(row, gen.new Cell())); 
      res.add(generateDescription(status, gen, row, element, (ElementDefinition) element.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER), null, null, profile, corePath, imagePath, root, logicalModel, allInvariants, snapshot, mustSupport, allowSubRows, rc, inScopeElements, resource));
    } 
    return res; 
  } 
 
  private Cell genCardinality(HierarchicalTableGenerator gen, ElementDefinition definition, Row row, boolean hasDef, UnusedTracker tracker, ElementDefinition fallback) { 
    IntegerType min = !hasDef ? new IntegerType() : definition.hasMinElement() ? definition.getMinElement() : new IntegerType(); 
    StringType max = !hasDef ? new StringType() : definition.hasMaxElement() ? definition.getMaxElement() : new StringType(); 
    if (min.isEmpty() && definition.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER) != null) { 
      ElementDefinition base = (ElementDefinition) definition.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER); 
      if (base.hasMinElement()) { 
        min = base.getMinElement().copy(); 
        min.setUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS, true); 
      } 
    } 
    if (max.isEmpty() && definition.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER) != null) { 
      ElementDefinition base = (ElementDefinition) definition.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER); 
      if (base.hasMaxElement()) { 
        max = base.getMaxElement().copy(); 
        max.setUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS, true); 
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
      if (definition.hasExtension(ExtensionDefinitions.EXT_JSON_EMPTY)) { 
        String code = ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_JSON_EMPTY); 
        if ("present".equals(code)) { 
          hint = context.formatPhrase(RenderingContext.STRUC_DEF_JSON_IS); 
        } else { 
          hint = context.formatPhrase(RenderingContext.STRUC_DEF_JSON_MAY);           
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
    row.setId(context.prefixAnchor(parent.getPath()+"-"+grp.getName())); 
    row.setAnchor(context.prefixAnchor(parent.getPath()+"-"+grp.getName())); 
    row.setColor(context.getProfileUtilities().getRowColor(parent, isConstraintMode)); 
    row.setLineColor(1); 
    row.setIcon("icon_choice.gif", context.formatPhrase(RenderingContext.TEXT_ICON_CHOICE)); 
    row.getCells().add(gen.new Cell(null, null, context.formatPhrase(RenderingContext.STRUC_DEF_CHOICE), "", null)); 
    row.getCells().add(gen.new Cell()); 
    row.getCells().add(gen.new Cell(null, null, (grp.isMandatory() ? "1" : "0")+"..1", "", null)); 
    row.getCells().add(gen.new Cell()); 
    row.getCells().add(gen.new Cell()); 
    prow.getSubRows().add(row); 
    return row; 
  } 
 
 
  private String urlFragmentOrTail(String path) {
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
 
  public Cell generateDescription(RenderingStatus status, HierarchicalTableGenerator gen, Row row, ElementDefinition definition, ElementDefinition fallback, String baseURL, String url, StructureDefinition profile, String corePath, String imagePath, boolean root, boolean logicalModel, boolean allInvariants, boolean snapshot, boolean mustSupportOnly, boolean allowSubRows, RenderingContext rc, ResourceWrapper res) throws IOException, FHIRException {
    return generateDescription(status, gen, row, definition, fallback, baseURL, url, profile, corePath, imagePath, root, logicalModel, allInvariants, null, snapshot, mustSupportOnly, allowSubRows, rc, new ArrayList<ElementDefinition>(), res);
  }

  public Cell generateDescription(RenderingStatus status, HierarchicalTableGenerator gen, Row row, ElementDefinition definition, ElementDefinition fallback, String baseURL, String url, StructureDefinition profile, String corePath, String imagePath, boolean root, boolean logicalModel, boolean allInvariants, boolean snapshot, boolean mustSupportOnly, boolean allowSubRows, RenderingContext rc, List<ElementDefinition> inScopeElements, ResourceWrapper res) throws IOException, FHIRException {
    return generateDescription(status, gen, row, definition, fallback, baseURL, url, profile, corePath, imagePath, root, logicalModel, allInvariants, null, snapshot, mustSupportOnly, allowSubRows, rc, inScopeElements, res);
  }

  public Cell generateDescription(RenderingStatus status, HierarchicalTableGenerator gen, Row row, ElementDefinition definition, ElementDefinition fallback, String baseURL, String url, StructureDefinition profile, String corePath, String imagePath, boolean root, boolean logicalModel, boolean allInvariants, ElementDefinition valueDefn, boolean snapshot, boolean mustSupportOnly, boolean allowSubRows, RenderingContext rc, List<ElementDefinition> inScopeElements, ResourceWrapper res) throws IOException, FHIRException {
    Cell c = gen.new Cell();
    row.getCells().add(c);

    if (logicalModel && ExtensionUtilities.hasAnyOfExtensions(profile, ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED)) {
      if (root) {
        c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_XML_NAME)) + ": ", null).addStyle("font-weight:bold"));
        c.getPieces().add(gen.new Piece(null, ExtensionUtilities.readStringExtension(profile, ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED), null));
      } else if (!root && ExtensionUtilities.hasAnyOfExtensions(definition, ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED) &&
        !ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED).equals(ExtensionUtilities.readStringExtension(profile, ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED))) {
        c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_XML_NAME)) + ": ", null).addStyle("font-weight:bold"));
        c.getPieces().add(gen.new Piece(null, ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED), null));
      }
    }
    if (root) {
      if (profile != null && profile.getAbstract()) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_ABSTRACT) + " " + (profile.getDerivation() == TypeDerivationRule.CONSTRAINT ? "profile" : "type") + ". ", null));

        List<StructureDefinition> children = new ArrayList<>();
        for (StructureDefinition sd : context.getWorker().fetchResourcesByType(StructureDefinition.class)) {
          if (sd.hasBaseDefinition() && sd.getBaseDefinitionNoVersion().equals(profile.getUrl())) {
            children.add(sd);
          }
        }
        if (!children.isEmpty()) {
          c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_CHILD) + " " + (profile.getDerivation() == TypeDerivationRule.CONSTRAINT ? "profiles" : "types") + ": ", null));
          boolean first = true;
          for (StructureDefinition sd : children) {
            if (first) first = false;
            else c.addPiece(gen.new Piece(null, ", ", null));
            c.addPiece(gen.new Piece(sd.getWebPath(), sd.getName(), null));
          }
        }
      }
    }
    if (definition.getPath().endsWith("url") && definition.hasFixed()) {
      c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, "\"" + buildJson(definition.getFixed()) + "\"", null).addStyle("color: darkgreen")));
    } else {
      if (definition != null && definition.hasShort()) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        Piece piece = checkForNoChange(definition.getShortElement(), gen.new Piece(null, gt(definition.getShortElement()), null));
        if (!definition.getShortElement().hasUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS)) {
          piece.setUnderived(true);
        }
        c.addPiece(piece);
      } else if (fallback != null && fallback.hasShort()) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        Piece piece = gen.new Piece(null, gt(fallback.getShortElement()), null).addStyle("opacity: 0.5");
        if (!definition.getShortElement().hasUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS)) {
          piece.setUnderived(true);
        }
        c.addPiece(piece);
      }
      if (url != null) {
        if (!c.getPieces().isEmpty())
          c.addPiece(gen.new Piece("br"));
        String fullUrl = url.startsWith("#") ? baseURL + url : url;
        StructureDefinition ed = context.getProfileUtilities().findProfile(url, profile);
        String ref = null;
        String ref2 = null;
        String fixedUrl = null;
        if (ed != null) {
          ref = ed.getWebPath();
          fixedUrl = getFixedUrl(ed);
          if (fixedUrl != null) {// if its null, we guess that it's not a profiled extension?
            if (fixedUrl.equals(url))
              fixedUrl = null;
            else {
              StructureDefinition ed2 = context.getProfileUtilities().findProfile(fixedUrl, profile);
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
            c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_URL)) + ": ", null).addStyle("font-weight:bold"));
            c.getPieces().add(gen.new Piece(ref, fullUrl, null));
          }
        } else {
          // reference to a profile take on the extension show the base URL
          c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_URL)) + ": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(ref2, fixedUrl, null));
          c.getPieces().add(gen.new Piece(null, (" " + context.formatPhrase(RenderingContext.STRUC_DEF_PROFILED) + " ") + " ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(ref, fullUrl, null));

        }
      }

      if (root) {
        if (profile.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
          List<SourcedElementDefinition> ancestors = new ArrayList<>();
          getAncestorElements(new ArrayList<>(), profile, ancestors);
          if (ancestors.size() > 0) {
            c.addPiece(gen.new Piece("br"));
            c.addPiece(gen.new Piece("br"));
            c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_ELEMENTS), null));
            boolean first = true;
            for (SourcedElementDefinition ed : ancestors) {
              if (first)
                first = false;
              else
                c.addPiece(gen.new Piece(null, ", ", null));
              c.addPiece(gen.new Piece(ed.getProfile().getWebPath(), (isAttr(ed) ? "@" : "") + ed.getDefinition().getName(), ed.getDefinition().getDefinition()));
            }
          }
        }
        if (profile.hasExtension(ExtensionDefinitions.EXT_RESOURCE_IMPLEMENTS)) {
          c.getPieces().add(gen.new Piece("br"));
          c.getPieces().add(gen.new Piece(spec("uml.html#interfaces"), context.formatPhrase(RenderingContext.STRUC_DEF_IMPLEMENTS), null));
          boolean first = true;
          for (Extension fi : profile.getExtensionsByUrl(ExtensionDefinitions.EXT_RESOURCE_IMPLEMENTS)) {
            if (first) {
              c.getPieces().add(gen.new Piece(null, ": ", null));
              first = false;
            } else {
              c.getPieces().add(gen.new Piece(null, ", ", null));
            }
            StructureDefinition sdt = context.getWorker().fetchResource(StructureDefinition.class, fi.getValue().primitiveValue());
            if (sdt != null) {
              c.getPieces().add(gen.new Piece(sdt.getWebPath(), sdt.present(), sdt.getDescription()));
            } else {
              c.getPieces().add(gen.new Piece(null, fi.getValue().primitiveValue(), "Unknown: "+fi.getValue().primitiveValue()));
            }
          }
        }
      }

      if (definition.hasSlicing()) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_SLICE)) + ": ", null).addStyle("font-weight:bold"));
        c.getPieces().add(gen.new Piece(null, describeSlice(definition.getSlicing()), null));
      }
      if (!definition.getPath().contains(".") && ExtensionUtilities.hasExtension(profile, ExtensionDefinitions.EXT_BINDING_STYLE)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_BINDING)) + ": ", null).addStyle("font-weight:bold"));
        c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_SET) + " "), null));
        c.getPieces().add(gen.new Piece(null, ExtensionUtilities.readStringExtension(profile, ExtensionDefinitions.EXT_BINDING_STYLE), null));
        c.getPieces().add(gen.new Piece(null, " " + context.formatPhrase(RenderingContext.STRUC_DEF_BINDING_STYLE), null));
      }
      if (definition.hasValueAlternatives()) {
        addCanonicalList(gen, c, definition.getValueAlternatives(), "The primitive value may be replaced by the extension", true, profile);
      }
      if (definition.hasExtension(ExtensionDefinitions.EXT_IMPLIED_PREFIX)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_ELE_READ) + " "), null));
        Piece piece = gen.new Piece("code");
        piece.addHtml(new XhtmlNode(NodeType.Text).setContent(ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_IMPLIED_PREFIX)));
        c.getPieces().add(piece);
        c.getPieces().add(gen.new Piece(null, " " + (context.formatPhrase(RenderingContext.STRUC_DEF_PREFIXED)), null));
      }
      if (root && ProfileUtilities.isModifierExtension(profile)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_MODIFIER_EXT), null).addStyle("font-weight:bold"));

      }

      if (definition.hasExtension(ExtensionDefinitions.EXT_EXTENSION_STYLE_NEW, ExtensionDefinitions.EXT_EXTENSION_STYLE_DEPRECATED)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        String es = definition.getExtensionString(ExtensionDefinitions.EXT_EXTENSION_STYLE_NEW, ExtensionDefinitions.EXT_EXTENSION_STYLE_DEPRECATED);
        if ("named-elements".equals(es)) {
          if (rc.hasLink(KnownLinkType.JSON_NAMES)) {
            c.getPieces().add(gen.new Piece(rc.getLink(KnownLinkType.JSON_NAMES, true), context.formatPhrase(RenderingContext.STRUC_DEF_EXT_JSON), null));
          } else {
            c.getPieces().add(gen.new Piece(ExtensionDefinitions.WEB_EXTENSION_STYLE, context.formatPhrase(RenderingContext.STRUC_DEF_EXT_JSON), null));
          }
        }
      }
      if (definition.typeSummary().equals("Narrative")) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        Set<String> statusCodes = determineNarrativeStatus(definition, profile, snapshot);
        List<String> langCtrl = ExtensionUtilities.readStringExtensions(definition, ExtensionDefinitions.EXT_NARRATIVE_LANGUAGE_CONTROL);
        String level = ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_NARRATIVE_SOURCE_CONTROL);
        // what do we want to do here?
        // the narrative might be constrained in these ways:
        //  extension http://hl7.org/fhir/StructureDefinition/narrative-language-control
        //  extension http://hl7.org/fhir/StructureDefinition/narrative-source-control
        //  restrictions on status
        // direct linkage to data requirements
        if ((statusCodes.isEmpty() || statusCodes.size() == 4) && level == null && langCtrl.isEmpty()) {
          c.getPieces().add(gen.new Piece(null, "This profile does not constrain the narrative in regard to content, language, or traceability to data elements", null).addStyle("font-weight:bold"));
        } else {
          if ((statusCodes.isEmpty() || statusCodes.size() == 4)) {
            c.getPieces().add(gen.new Piece(null, "This profile does not constrain the narrative content by fixing the status codes", null).addStyle("font-weight:bold"));
          } else {
            c.getPieces().add(gen.new Piece(null, "This profile constrains the narrative content by fixing the status codes to " + CommaSeparatedStringBuilder.join2(", ", " and ", statusCodes), null).addStyle("font-weight:bold"));
          }
          c.addPiece(gen.new Piece("br"));
          String ltx = null;
          if (langCtrl.isEmpty()) {
            ltx = "This profile does not constrain the narrative in regard to language specific sections";
          } else if (langCtrl.size() == 1 && langCtrl.get(0).equals("_no")) {
            ltx = "This profile constrains the narrative to not contain any language specific sections";
          } else if (langCtrl.size() == 1 && langCtrl.get(0).equals("_yes")) {
            ltx = "This profile constrains the narrative to contain language sections, but doesn't make rules about them";
          } else {
            int i = langCtrl.indexOf("_resource");
            if (i == -1) {
              ltx = "This profile constrains the narrative to contain language sections for the languages " + CommaSeparatedStringBuilder.join2(", ", " and ", langCtrl);
            } else {
              langCtrl.remove(i);
              if (langCtrl.size() == 0) {
                ltx = "This profile constrains the narrative to contain a language sections in the same language as the resource";
              } else {
                ltx = "This profile constrains the narrative to contain a language sections in the same language as the resource, and also for the languages " + CommaSeparatedStringBuilder.join2(", ", " and ", langCtrl);
              }
            }
          }
          c.getPieces().add(gen.new Piece(null, ltx, null).addStyle("font-weight:bold"));
          c.addPiece(gen.new Piece("br"));

          if (level == null) {
            c.getPieces().add(gen.new Piece(null, "This profile does not constrain the narrative in regard to traceability to data elements", null).addStyle("font-weight:bold"));
          } else {
            c.getPieces().add(gen.new Piece(null, "This profile indicates that if there are elements in the narrative without a source-type class, and " + level + " will be emitted", null).addStyle("font-weight:bold"));
          }
        }
      }
      if (definition.hasExtension(ExtensionDefinitions.EXT_DATE_FORMAT)) {
        String df = ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_DATE_FORMAT);
        if (df != null) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_DATE, df) + " "), null));
        }
      }
      if (definition.hasExtension(ExtensionDefinitions.EXT_ID_EXPECTATION)) {
        String ide = ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_ID_EXPECTATION);
        if (ide.equals("optional")) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_ID_IS), null));
        } else if (ide.equals("required")) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_ID_MAY), null));
        } else if (ide.equals("required")) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_ID_NOT_ALLOW), null));
        }
      }
      if (definition.hasExtension(ExtensionDefinitions.EXT_ID_CHOICE_GROUP)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_CHOICE_GRP)) + ": ", null).addStyle("font-weight:bold"));
        c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_REPEAT), null));
      }
      if (definition.hasExtension(ExtensionDefinitions.EXT_XML_NAME, ExtensionDefinitions.EXT_XML_NAME_DEPRECATED)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        if (definition.hasExtension(ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED)) {
          c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_XML)) + ": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, definition.getExtensionString(ExtensionDefinitions.EXT_XML_NAME, ExtensionDefinitions.EXT_XML_NAME_DEPRECATED), null));
          c.getPieces().add(gen.new Piece(null, " (", null));
          c.getPieces().add(gen.new Piece(null, definition.getExtensionString(ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED), null));
          c.getPieces().add(gen.new Piece(null, ")", null));
        } else {
          c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_XML_ELE)) + ": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, definition.getExtensionString(ExtensionDefinitions.EXT_XML_NAME, ExtensionDefinitions.EXT_XML_NAME_DEPRECATED), null));
        }
      } else if (definition.hasExtension(ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_XML_NAME)) + ": ", null).addStyle("font-weight:bold"));
        c.getPieces().add(gen.new Piece(null, definition.getExtensionString(ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED), null));
      }
      if (definition.hasExtension(ExtensionDefinitions.EXT_JSON_EMPTY)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        String code = ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_JSON_EMPTY);
        if ("present".equals(code)) {
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_JSON_INFERRED), null));
        } else {
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_JSON_ARRAY), null));
        }
      }
      String jn = ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_JSON_NAME, ExtensionDefinitions.EXT_JSON_NAME_DEPRECATED);
      if (!Utilities.noString(jn)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        if (definition.getPath().contains(".")) {
          c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_JSON_NAME)) + ": ", null).addStyle("font-weight:bold"));
          c.getPieces().add(gen.new Piece(null, jn, null));
        } else {
          c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_JSON_TYPE)) + ": ", null).addStyle("font-weight:bold"));
          Piece piece = gen.new Piece("code");
          piece.addHtml(new XhtmlNode(NodeType.Text).setContent(jn));
          c.getPieces().add(piece);
        }
      }

      if (ExtensionUtilities.readBoolExtension(definition, ExtensionDefinitions.EXT_JSON_PRIMITIVE_CHOICE)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_JSON_INFERRED), null));
      }
      if (ExtensionUtilities.readBoolExtension(definition, ExtensionDefinitions.EXT_JSON_NULLABLE)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_JSON_NULL), null));
      }
      if (definition.hasExtension(ExtensionDefinitions.EXT_JSON_PROP_KEY)) {
        if (!c.getPieces().isEmpty()) {
          c.addPiece(gen.new Piece("br"));
        }
        String code = ExtensionUtilities.readStringExtension(definition, ExtensionDefinitions.EXT_JSON_PROP_KEY);
        c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_SINGLE_JSON_OBJECTS, code), null));
      }
      if (definition.hasExtension(ExtensionDefinitions.EXT_TYPE_SPEC)) {
        for (Extension e : definition.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_SPEC)) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          String cond = ExtensionUtilities.readStringExtension(e, "condition");
          String type = ExtensionUtilities.readStringExtension(e, "type");
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_JSON_IF), null));
          Piece piece = gen.new Piece("code");
          piece.addHtml(new XhtmlNode(NodeType.Text).setContent(cond));
          c.getPieces().add(piece);
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_THEN_TYPE) + " ", null));
          StructureDefinition sd = context.getWorker().fetchTypeDefinition(type);
          if (sd == null) {
            piece = gen.new Piece("code");
            piece.addHtml(new XhtmlNode(NodeType.Text).setContent(type));
            c.getPieces().add(piece);
          } else {
            c.getPieces().add(gen.new Piece(sd.getWebPath(), sd.getTypeName(), null));
          }
        }
      }
      if (root) {
        if (ExtensionUtilities.readBoolExtension(profile, ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_NEW, ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_OLD)) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_OBLIG_ADD), null).addStyle("font-weight:bold"));
        }
        addCanonicalListExt(gen, c, profile.getExtensionsByUrl(ExtensionDefinitions.EXT_OBLIGATION_INHERITS_NEW, ExtensionDefinitions.EXT_OBLIGATION_INHERITS_OLD), "This profile picks up obligations and additional bindings from the profile", true, profile);
        addCanonicalListExt(gen, c, profile.getExtensionsByUrl(ExtensionDefinitions.EXT_SD_IMPOSE_PROFILE), "This profile also imposes the profile", true, profile);
        addCanonicalListExt(gen, c, profile.getExtensionsByUrl(ExtensionDefinitions.EXT_SD_COMPLIES_WITH_PROFILE), "This profile also complies with the profile", true, profile);

        if (profile.getKind() == StructureDefinitionKind.LOGICAL) {
          Extension lt = ExtensionUtilities.getExtension(profile, ExtensionDefinitions.EXT_LOGICAL_TARGET);
          List<Extension> tc = ExtensionUtilities.getExtensions(profile, ExtensionDefinitions.EXT_TYPE_CHARACTERISTICS);
          Boolean canBeTarget = checkCanBeTarget(lt, tc);
          if (canBeTarget == null) {
            // don't say anything
          } else if (canBeTarget) {
            if (!c.getPieces().isEmpty()) {
              c.addPiece(gen.new Piece("br"));
            }
            c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_CAN_TARGET), null).addStyle("font-weight:bold"));
          } else {
            if (!c.getPieces().isEmpty()) {
              c.addPiece(gen.new Piece("br"));
            }
            c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_NOT_MARK), null).addStyle("font-weight:bold"));
          }

          String ps = ExtensionUtilities.readStringExtension(profile, ExtensionDefinitions.EXT_PROFILE_STYLE);
          if (ps != null) {
            if (!c.getPieces().isEmpty()) {
              c.addPiece(gen.new Piece("br"));
            }
            if ("cda".equals(ps)) {
              c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_TEMPLATEID), null).addStyle("font-weight:bold"));
            } else {
              c.addPiece(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_UNKNOWN_APPROACH, ps) + " ", null).addStyle("font-weight:bold"));
            }
          }
          Extension lc = ExtensionUtilities.getExtension(profile, ExtensionDefinitions.EXT_LOGICAL_CONTAINER);
          if (lc != null && lc.hasValueUriType()) {
            if (!c.getPieces().isEmpty()) {
              c.addPiece(gen.new Piece("br"));
            }
            c.getPieces().add(gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_LOGICAL_CONT)) + ": ", context.formatPhrase(RenderingContext.STRUC_DEF_ROOT)).addStyle("font-weight:bold"));

            String uri = lc.getValue().primitiveValue();
            StructureDefinition lct = context.getContext().fetchTypeDefinition(uri);
            if (lct != null) {
              c.addPiece(gen.new Piece(lct.getWebPath(), lct.present(), null));
            } else {
              c.addPiece(gen.new Piece(null, uri, null));
            }
          }
        }
      }
      if (definition != null) {
        ElementDefinitionBindingComponent binding = null;
        if (valueDefn != null && valueDefn.hasBinding() && !valueDefn.getBinding().isEmpty())
          binding = makeUnifiedBinding(valueDefn.getBinding(), valueDefn);
        else if (definition.hasBinding())
          binding = makeUnifiedBinding(definition.getBinding(), definition);
        if (binding != null && !binding.isEmpty()) {
          if (!c.getPieces().isEmpty())
            c.addPiece(gen.new Piece("binding", "br"));
          if (!binding.hasValueSet()) {
            c.getPieces().add(checkForNoChange(binding, gen.new Piece("binding", null, (context.formatPhrase(RenderingContext.GENERAL_BINDING_NO_VS_1)) + ": ", null).addStyle("font-weight:bold")));
            if (binding.hasStrength()) {
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece("binding", null, " (", null)));
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece("binding", corePath + "terminologies.html#" + binding.getStrength().toCode(), egt(binding.getStrengthElement()), binding.getStrength().getDefinition())));
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece("binding", null, ")", null)));
              if (binding.getStrength().testable()) {
                c.getPieces().add(gen.new Piece("binding", null, " ", null));
                c.getPieces().add(checkForNoChange(binding, gen.new Piece("binding", null, "\u26A0", context.formatPhrase(RenderingContext.GENERAL_BINDING_NO_VS_2))).addStyle("font-weight:bold; color: #c97a18"));
              }
            }
            c.getPieces().add(gen.new Piece("binding", null, ": ", null));
            if (binding.hasDescription() && MarkDownProcessor.isSimpleMarkdown(binding.getDescription())) {
              c.addMarkdownNoPara("binding", PublicationHacker.fixBindingDescriptions(context.getWorker(), binding.getDescriptionElement()).asStringValue(), checkForNoChange(PublicationHacker.fixBindingDescriptions(context.getWorker(), binding.getDescriptionElement())));
            } else {
              c.addMarkdownNoPara("binding", context.formatPhrase(RenderingContext.GENERAL_BINDING_NO_DESC));
            }
          } else {
            BindingResolution br = context.getPkp() == null ? makeNullBr(binding) : context.getPkp().resolveBinding(profile, binding, definition.getPath());
            c.getPieces().add(checkForNoChange(binding, gen.new Piece("binding", null, (context.formatPhrase(RenderingContext.GENERAL_BINDING)) + ": ", null).addStyle("font-weight:bold")));
            c.getPieces().add(checkForNoChange(binding.getValueSetElement(), checkAddExternalFlag(br, gen.new Piece("binding", br.url == null ? null : Utilities.isAbsoluteUrl(br.url) || !context.getPkp().prependLinks() ? br.url : corePath + br.url, br.display, br.uri))));
            if (binding.hasStrength()) {
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece("binding", null, " (", null)));
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece("binding", corePath + "terminologies.html#" + binding.getStrength().toCode(), egt(binding.getStrengthElement()), binding.getStrength().getDefinition())));
              c.getPieces().add(checkForNoChange(binding.getStrengthElement(), gen.new Piece("binding", null, ")", null)));
            }
            if (binding.hasDescription() && MarkDownProcessor.isSimpleMarkdown(binding.getDescription())) {
              c.getPieces().add(gen.new Piece("binding", null, ": ", null));
              c.addMarkdownNoPara("binding", PublicationHacker.fixBindingDescriptions(context.getWorker(), binding.getDescriptionElement()).asStringValue(), checkForNoChange(PublicationHacker.fixBindingDescriptions(context.getWorker(), binding.getDescriptionElement())));
            }
          }
          AdditionalBindingsRenderer abr = new AdditionalBindingsRenderer(context.getPkp(), corePath, profile, definition.getPath(), rc, null, this);
          abr.seeAdditionalBindings(definition, null, false);
          if (binding.hasExtension(ExtensionDefinitions.EXT_MAX_VALUESET)) {
            abr.seeMaxBinding(ExtensionUtilities.getExtension(binding, ExtensionDefinitions.EXT_MAX_VALUESET));
          }
          if (binding.hasExtension(ExtensionDefinitions.EXT_MIN_VALUESET)) {
            abr.seeMinBinding(ExtensionUtilities.getExtension(binding, ExtensionDefinitions.EXT_MIN_VALUESET));
          }
          if (binding.hasExtension(ExtensionDefinitions.EXT_BINDING_ADDITIONAL)) {
            abr.seeAdditionalBindings(binding.getExtensionsByUrl(ExtensionDefinitions.EXT_BINDING_ADDITIONAL));
          }
          abr.render(gen, c);
        }

        boolean firstConstraint = true;
        for (ElementDefinitionConstraintComponent inv : definition.getConstraint()) {
//            if (!inv.hasSource() || profile == null || inv.getSource().equals(profile.getUrl()) || allInvariants) { 
          if (!inv.hasSource() || profile == null || inv.getSource().equals(profile.getUrl()) || (allInvariants && !isAbstractBaseProfile(inv.getSource(), profile) && !"http://hl7.org/fhir/StructureDefinition/Extension".equals(inv.getSource()) && !"http://hl7.org/fhir/StructureDefinition/Element".equals(inv.getSource()))) {
            if (firstConstraint) {
              if (!c.getPieces().isEmpty())
                c.addPiece(gen.new Piece("constraint", "br"));
              c.addPiece(gen.new Piece("constraint", null, "Constraints: ", null));
              firstConstraint = false;

            } else
              c.addPiece(gen.new Piece("constraint", null, ", ", null));
            c.getPieces().add(checkForNoChange(inv, gen.new Piece("constraint", null, inv.getKey(), gt(inv.getHumanElement())).addStyle("font-weight:bold")));
          }
        }
        if ((definition.hasBase() && "*".equals(definition.getBase().getMax())) || (definition.hasMax() && "*".equals(definition.getMax()))) {
          if (c.getPieces().size() > 0)
            c.addPiece(gen.new Piece("br"));
          if (definition.hasOrderMeaning()) {
            c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_REPEAT_ELE, definition.getOrderMeaning()), null));
          } else {
            // don't show this, this it's important: c.getPieces().add(gen.new Piece(null, "This repeating element has no defined order", null));
          }
        }
        if (definition.hasFixed()) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_FIXED)) + ": ", null).addStyle("font-weight:bold")));
          if (!useTableForFixedValues || !allowSubRows || definition.getFixed().isPrimitive()) {
            String s = buildJson(definition.getFixed());
            String link = null;
            if (Utilities.isAbsoluteUrl(s) && context.getPkp() != null)
              link = context.getPkp().getLinkForUrl(corePath, s);
            c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(link, s, null).addStyle("color: darkgreen")));
          } else {
            c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_AS_SHOWN), null).addStyle("color: darkgreen")));
            genFixedValue(gen, row, definition.getFixed(), snapshot, false, corePath, false);
          }
          if (isCoded(definition.getFixed()) && !hasDescription(definition.getFixed())) {
            Piece p = describeCoded(gen, definition.getFixed());
            if (p != null)
              c.getPieces().add(p);
          }
        } else if (definition.hasPattern()) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, (context.formatPhrase(RenderingContext.STRUC_DEF_REQ_PATT)) + ": ", null).addStyle("font-weight:bold")));
          if (!useTableForFixedValues || !allowSubRows || definition.getPattern().isPrimitive())
            c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, buildJson(definition.getPattern()), null).addStyle("color: darkgreen")));
          else {
            c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_LEAST_FOLLOW), null).addStyle("color: darkgreen")));
            genFixedValue(gen, row, definition.getPattern(), snapshot, true, corePath, mustSupportOnly);
          }
        } else if (definition.hasExample()) {
          for (ElementDefinitionExampleComponent ex : definition.getExample()) {
            if (!c.getPieces().isEmpty()) {
              c.addPiece(gen.new Piece("br"));
            }
            c.getPieces().add(checkForNoChange(ex, gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_EXAMPLE)) + ("".equals("General") ? "" : " " + ex.getLabel()) + ": ", null).addStyle("font-weight:bold")));
            c.getPieces().add(checkForNoChange(ex, gen.new Piece(null, buildJson(ex.getValue()), null).addStyle("color: darkgreen")));
          }
        }

        ObligationsRenderer obr = new ObligationsRenderer(corePath, profile, definition.getPath(), rc, null, this, false);
        if (definition.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)) {
          obr.seeObligations(definition.getExtensionsByUrl(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS));
        }
        if (!definition.getPath().contains(".") && profile.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)) {
          obr.seeObligations(profile.getExtensionsByUrl(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS));
        }
        obr.renderTable(status, res, gen, c, inScopeElements);
        if (definition.hasMaxLength() && definition.getMaxLength() != 0) {
          if (!c.getPieces().isEmpty()) {
            c.addPiece(gen.new Piece("br"));
          }
          c.getPieces().add(checkForNoChange(definition.getMaxLengthElement(), gen.new Piece(null, context.formatPhrase(RenderingContext.GENERAL_MAX_LENGTH), null).addStyle("font-weight:bold")));
          c.getPieces().add(checkForNoChange(definition.getMaxLengthElement(), gen.new Piece(null, Integer.toString(definition.getMaxLength()), null).addStyle("color: darkgreen")));
        }
        if (definition.hasExtension(ExtensionDefinitions.EXT_MIN_LENGTH)) {
          int min = ExtensionUtilities.readIntegerExtension(definition, ExtensionDefinitions.EXT_MIN_LENGTH, 0);
          if (min > 0) {
            if (!c.getPieces().isEmpty()) {
              c.addPiece(gen.new Piece("br"));
            }
            c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.GENERAL_MIN_LENGTH), null).addStyle("font-weight:bold"));
            c.getPieces().add(gen.new Piece(null, Integer.toString(min), null).addStyle("color: darkgreen"));
          }
        }
        if (profile != null) {
          for (StructureDefinitionMappingComponent md : profile.getMapping()) {
            if (md.hasExtension(ExtensionDefinitions.EXT_TABLE_NAME)) {
              ElementDefinitionMappingComponent map = null;
              for (ElementDefinitionMappingComponent m : definition.getMapping())
                if (m.getIdentity().equals(md.getIdentity()))
                  map = m;
              if (map != null) {
                for (int i = 0; i < definition.getMapping().size(); i++) {
                  c.addPiece(gen.new Piece("br"));
                  c.getPieces().add(gen.new Piece(null, ExtensionUtilities.readStringExtension(md, ExtensionDefinitions.EXT_TABLE_NAME) + ": " + map.getMap(), null));
                }
              }
            }
          }
        }
      }
    }

    return c;
  }

  private Set<String> determineNarrativeStatus(ElementDefinition definition, StructureDefinition profile, boolean snapshot) {
    Set<String> set = new HashSet<>();
    try {
      List<ElementDefinition> children = context.getProfileUtilities().getChildList(profile, definition, !snapshot);
      ElementDefinition status = null;
      for (ElementDefinition t : children) {
        if (t.getName().equals("status")) {
          status = t;
        }
      }
      if (status != null && status.getBinding().hasValueSet()) {
        ValueSetExpansionOutcome exp = context.getContext().expandVS(ExpansionOptions.cacheNoHeirarchy().withLanguage(context.getLocale().getLanguage()).withMaxCount(-1), status.getBinding().getValueSet());
        if (exp.isOk()) {
          for (ValueSetExpansionContainsComponent cc : exp.getValueset().getExpansion().getContains()) {
            set.add(cc.getCode());
          }
        }
      }
    } catch (Exception e) {
      log.error("Error checking Narrative Status: "+e.getMessage(), e);
    }
    return set;
  }

  private Boolean checkCanBeTarget(Extension lt, List<Extension> tc) {
    Boolean res = null;
    if (lt == null || !lt.hasValueBooleanType() || lt.getValue().hasExtension(ExtensionDefinitions.EXT_DAR)) {                  
    } else if (!lt.getValueBooleanType().hasValue()) {
      res = null; // GDG Dec-2024: this is true, but changed to null
    } else if (lt.getValueBooleanType().booleanValue()) {
      res = true;
    } else {
      res = false; // GDG Dec 2024- this was true, but evidently should be false, so fixed
    }             
    if (res == null && !tc.isEmpty()) {
      res = false;
      for (Extension t : tc) {
        if (t.hasValueCodeType() && "can-be-target".equals(t.getValueCodeType().primitiveValue())) {
          res = true;
        }    
      }
    }
    return res;
  }

  private boolean isAbstractBaseProfile(String source, StructureDefinition resource) {
    StructureDefinition sd = context.getProfileUtilities().findProfile(source, resource);
    return (sd != null) && sd.getAbstract() && sd.hasUrl() && sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/"); 
  } 
 
  private Piece checkAddExternalFlag(BindingResolution br, Piece piece) { 
    if (br.external) { 
      piece.setTagImg("external.png"); 
    } 
    return piece; 
  } 
 
  private boolean isAttr(SourcedElementDefinition ed) { 
    for (Enumeration<PropertyRepresentation> t : ed.getDefinition().getRepresentation()) { 
      if (t.getValue() == PropertyRepresentation.XMLATTR) { 
        return true; 
      } 
    } 
    return false; 
  } 
 
  private void getAncestorElements(List<String> inscope, StructureDefinition profile, List<SourcedElementDefinition> ancestors) { 
    StructureDefinition base = context.getProfileUtilities().findProfile(profile.getBaseDefinition(), profile);
    if (base != null) { 
      List<String> newList = Utilities.copyAdd(inscope, base.getVersionedUrl()); 
      if (inscope.contains(base.getVersionedUrl())) {
        throw new FHIRException("Circular Definition detected in derivation hierarchy: "+CommaSeparatedStringBuilder.join("->", newList));
      }
      getAncestorElements(newList, base, ancestors);      
      for (ElementDefinition ed : base.getDifferential().getElement()) { 
        if (Utilities.charCount(ed.getPath(), '.') == 1) { 
          ancestors.add(new SourcedElementDefinition(base, ed)); 
        } 
      } 
    } 
  } 
 
  private void addCanonicalListExt(HierarchicalTableGenerator gen, Cell c, List<Extension> list, String start, boolean bold, StructureDefinition source) throws IOException {
    List<CanonicalType> clist = new ArrayList<>(); 
    for (Extension ext : list) { 
      if (ext.hasValueCanonicalType()) { 
        clist.add(ext.getValueCanonicalType()); 
      } 
    } 
    addCanonicalList(gen, c, clist, start, bold, source);
  } 
   
  private void addCanonicalList(HierarchicalTableGenerator gen, Cell c, List<CanonicalType> list, String start, boolean bold, StructureDefinition source) throws IOException {
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
        StructureDefinition sd = context.getProfileUtilities().findProfile(iu, source);
        if (sd == null) {
          sd = context.findLinkableResource(StructureDefinition.class, iu);
        }
        if (sd == null) { 
          p = gen.new Piece(null, iu, null).addStyle("font-weight:bold"); 
          c.addPiece(p);                       
        } else { 
          String v = ""; 
          if (iu.contains("|") || hasMultipleVersions(context.getContext().fetchResourceVersions(StructureDefinition.class, iu))) {
            v = " ("+sd.getVersion()+")"; 
          } 
          if (sd.hasWebPath()) { 
            p = gen.new Piece(sd.getWebPath(), sd.present()+v, null).addStyle("font-weight:bold"); 
            c.addPiece(p);                       
          } else { 
            p = gen.new Piece(iu, sd.present()+v, null).addStyle("font-weight:bold"); 
            c.addPiece(p);                       
          } 
        } 
        if (bold) {
          p.addStyle("font-weight:bold"); 
        } 
      } 
    }     
  } 
 
  private Piece checkForNoChange(Element source, Piece piece) { 
    if (source.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS)) { 
      piece.addStyle("opacity: 0.5");
    } 
    return piece; 
  } 
 
  private String checkForNoChange(Element source) { 
    if (source.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS)) { 
      return "opacity: 0.5"; 
    } else {  
      return null; 
    } 
  } 
 
  private Cell genTypes(HierarchicalTableGenerator gen, Row r, ElementDefinition e, String profileBaseFileName, StructureDefinition profile, String corePath, String imagePath, boolean root, boolean mustSupportMode, boolean diff) {
    Cell c = gen.new Cell(); 
    r.getCells().add(c); 
    if (e.hasContentReference()) { 
      ElementInStructure ed = getElementByName(diff ? profile.getDifferential().getElement() : profile.getSnapshot().getElement(), e.getContentReference(), profile);
      if (ed == null) 
        c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_UNKNOWN_REF, e.getContentReference())+" ", null)); 
      else { 
        if (ed.getSource() == profile) { 
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_SEE)+" ", null)); 
          c.getPieces().add(gen.new Piece("#"+ed.getElement().getPath(), tail(ed.getElement().getPath()), ed.getElement().getPath())); 
        } else { 
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_SEE)+" ", null)); 
          c.getPieces().add(gen.new Piece(ed.getSource().getWebPath()+"#"+ed.getElement().getPath(), tail(ed.getElement().getPath())+" ("+ed.getSource().getTypeName()+")", ed.getElement().getPath()));
        } 
      } 
      return c; 
    } 
    List<TypeRefComponent> types = e.getType(); 
    if (!e.hasType()) { 
      if (root) { // we'll use base instead of types then 
        StructureDefinition bsd = profile == null ? null : context.getProfileUtilities().findProfile(profile.getBaseDefinition(), profile); 
        if (bsd != null) { 
          String v = ""; 
          if (profile != null && (profile.getBaseDefinition().contains("|") || hasMultipleVersions(context.getWorker().fetchResourceVersions(StructureDefinition.class, profile.getBaseDefinition())))) {
            v = v +"("+bsd.getVersion()+")"; 
          } 
          if (bsd.hasWebPath()) { 
            c.getPieces().add(gen.new Piece(Utilities.isAbsoluteUrl(bsd.getWebPath()) ? bsd.getWebPath() : imagePath +bsd.getWebPath(), bsd.getName()+v, null)); 
          } else { 
            c.getPieces().add(gen.new Piece(null, bsd.getName()+v, null)); 
          } 
        } 
        return c; 
      } else if (e.hasContentReference()) { 
        return c; 
      } else { 
        ElementDefinition d = (ElementDefinition) e.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER); 
        if (d != null && d.hasType()) { 
          types = new ArrayList<ElementDefinition.TypeRefComponent>(); 
          for (TypeRefComponent tr : d.getType()) { 
            TypeRefComponent tt = tr.copy(); 
            tt.setUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS, true); 
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
          if (t.hasProfile()) { 
            String ref = t.getProfile().get(0).asStringValue(); 
            StructureDefinition tsd = context.getProfileUtilities().findProfile(ref, profile);
            if (tsd != null) { 
              // if there's multiple possible matches in scope, we will be explicit about the version 
              if (ref.contains("|") || hasMultipleVersions(context.getContext().fetchResourceVersions(StructureDefinition.class, ref))) {
                c.getPieces().add(gen.new Piece(tsd.getWebPath(), tsd.getName()+"("+tsd.getVersion()+")", tsd.present()));                                 
              } else { 
                c.getPieces().add(gen.new Piece(tsd.getWebPath(), tsd.getName(), tsd.present())); 
              } 
            } else { 
              c.getPieces().add(gen.new Piece(corePath+"references.html", t.getWorkingCode(), null)); 
            } 
          } else { 
            c.getPieces().add(gen.new Piece(corePath+"references.html", t.getWorkingCode(), null)); 
          } 
          if (!mustSupportMode && isMustSupportDirect(t) && e.getMustSupport()) { 
            c.addPiece(gen.new Piece(null, " ", null)); 
            c.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_SUPP)), "S", "white", "red", null, false); 
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
                c.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_SUPP)), "S", "white", "red", null, false); 
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
                  if (p.hasExtension(ExtensionDefinitions.EXT_PROFILE_ELEMENT)) { 
                    String pp = p.getExtensionString(ExtensionDefinitions.EXT_PROFILE_ELEMENT); 
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
                c.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_PROF_SUPP)), "S", "white", "red", null, false); 
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
          if (t.hasExtension(ExtensionDefinitions.EXT_TYPE_PARAMETER)) {
            c.addPiece(checkForNoChange(t, gen.new Piece(null, "<", null)));
            boolean pfirst = true;
            List<Extension> exl = t.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_PARAMETER);
            for (Extension ex : exl) {
              if (pfirst) { pfirst = false; } else { c.addPiece(checkForNoChange(t, gen.new Piece(null, ";", null))); }
              if (exl.size() > 1) {
                c.addPiece(checkForNoChange(t, gen.new Piece(null, ex.getExtensionString("name")+": ", null)));
              }
              String type = ex.getExtensionString("type");
              StructureDefinition psd = context.getContext().fetchTypeDefinition(type);
              if (psd == null) {
                c.addPiece(checkForNoChange(t, gen.new Piece(null, type, null))); 
              } else if (psd.getWebPath() == null) {
                c.addPiece(checkForNoChange(t, gen.new Piece(type, psd.present(), null))); 
              } else {
                c.addPiece(checkForNoChange(t, gen.new Piece(psd.getWebPath(), psd.present(), null))); 
              }
            }
            c.addPiece(checkForNoChange(t, gen.new Piece(null, ">", null))); 

          }
          if (!mustSupportMode && isMustSupportDirect(t) && e.getMustSupport()) { 
            c.addPiece(gen.new Piece(null, " ", null)); 
            c.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_SUPP)), "S", "white", "red", null, false); 
          } 
        } 
      } 
    } 
    return c; 
  } 
 
 
  private String typePath(String cp, StructureDefinition source) {
    if (source.hasUserData(UserDataNames.loader_custom_resource)) {
      return source.getWebPath();
    } else {
      return pfx(cp, source.getWebPath());
    }
  }

  private boolean hasMultipleVersions(List<? extends CanonicalResource> list) { 
    Set<String> vl = new HashSet<>(); 
    for (CanonicalResource cr : list) { 
      vl.add(cr.getVersion()); 
    } 
    return vl.size() > 1; 
  } 
 
  private String pfx(String prefix, String url) { 
    return Utilities.isAbsoluteUrl(url) ? url : prefix + url; 
  } 
 
  private void genTargetLink(HierarchicalTableGenerator gen, String profileBaseFileName, String corePath, Cell c, TypeRefComponent t, String u, StructureDefinition src) {
    if (u.startsWith("http://hl7.org/fhir/StructureDefinition/")) { 
      StructureDefinition sd = context.getProfileUtilities().findProfile(u, src); 
      if (sd != null) { 
        String disp = sd.hasTitle() ? sd.getTitle() : sd.getName(); 
        c.addPiece(checkForNoChange(t, gen.new Piece(checkPrepend(corePath, sd.getWebPath()), disp, null))); 
      } else { 
        String rn = u.substring(40); 
        c.addPiece(checkForNoChange(t, gen.new Piece(context.getPkp().getLinkFor(corePath, rn), rn, null))); 
      } 
    } else if (Utilities.isAbsoluteUrl(u)) { 
      StructureDefinition sd = context.getProfileUtilities().findProfile(u, src); 
      if (sd != null && context.getPkp() != null) { 
        String v = ""; 
        if (u.contains("|") || hasMultipleVersions(context.getWorker().fetchResourceVersions(StructureDefinition.class, u))) {
          v = "("+sd.getVersion()+")"; 
        } 
        String disp = sd.present()+v;
        String ref;
        if (u.contains("|")) {
          ref = sd.getWebPath(); 
        } else {
          ref = context.getPkp().getLinkForProfile(null, sd.getUrl()); 
        }
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
 
 
  private void genGridElement(String defPath, HierarchicalTableGenerator gen, List<Row> rows, ElementDefinition element, List<ElementDefinition> all, List<StructureDefinition> profiles, boolean showMissing, String profileBaseFileName, Boolean extensions, String corePath, String imagePath, boolean root, boolean isConstraintMode, boolean diff) throws IOException, FHIRException {
    StructureDefinition profile = profiles == null ? null : profiles.get(profiles.size()-1); 
    String s = tail(element.getPath()); 
    List<ElementDefinition> children = getChildren(all, element); 
    boolean isExtension = (s.equals("extension") || s.equals("modifierExtension")); 
 
    if (!onlyInformationIsMapping(all, element)) { 
      Row row = gen.new Row(); 
      row.setId(context.prefixAnchor(s)); 
      String anchor = element.getPath();
      anchor = makeAnchorUnique(anchor);
      row.setAnchor(context.prefixAnchor(anchor)); 
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
        genTypes(gen, row, element, profileBaseFileName, profile, corePath, imagePath, root, false, diff);
      else 
        row.getCells().add(gen.new Cell()); 
      generateGridDescription(gen, row, element, null, used.used, null, null, profile, corePath, imagePath, root, null); 
      /*      if (element.hasSlicing()) { 
        if (standardExtensionSlicing(element)) { 
          used.used = element.hasType() && element.getType().get(0).hasProfile(); 
          showMissing = false; 
        } else { 
          row.setIcon("icon_slice.png", context.formatPhrase(RenderingContext.TEXT_ICON_SLICE); 
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
          genGridElement(defPath, gen, row.getSubRows(), child, all, profiles, showMissing, profileBaseFileName, isExtension, corePath, imagePath, false, isConstraintMode, diff);
    } 
  } 
 
 
  private ExtensionContext locateExtension(Class<StructureDefinition> class1, String value, StructureDefinition sd)  {
    if (value.contains("#")) { 
      StructureDefinition ext = context.getProfileUtilities().findProfile(value.substring(0, value.indexOf("#")), sd);
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
      StructureDefinition ext = context.getProfileUtilities().findProfile(value, sd);
      if (ext == null) 
        return null; 
      else  
        return new ExtensionContext(ext, ext.getSnapshot().getElement().get(0)); 
    } 
  } 
 
 
  private boolean extensionIsComplex(String value, StructureDefinition sd) {
    if (value.contains("#")) { 
      StructureDefinition ext = context.getProfileUtilities().findProfile(value.substring(0, value.indexOf("#")), sd);
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
      StructureDefinition ext = context.getProfileUtilities().findProfile(value, sd);
      return ext != null && ext.getSnapshot().getElement().size() > 5; 
    } 
  } 
 
 
 
 
  private BindingResolution makeNullBr(ElementDefinitionBindingComponent binding) { 
    BindingResolution br = new BindingResolution(); 
    br.url = "http://none.none/none"; 
    br.display = context.formatPhrase(RenderingContext.GENERAL_TODO); 
    return br; 
  } 
 
  private ElementDefinitionBindingComponent makeUnifiedBinding(ElementDefinitionBindingComponent binding, ElementDefinition element) { 
    if (!element.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER)) { 
      return binding; 
    } 
    ElementDefinition base = (ElementDefinition) element.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER); 
    if (!base.hasBinding()) { 
      return binding; 
    } 
    ElementDefinitionBindingComponent o = base.getBinding(); 
    ElementDefinitionBindingComponent b = new ElementDefinitionBindingComponent(); 
    b.setUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER, o); 
    if (binding.hasValueSet()) { 
      b.setValueSet(binding.getValueSet()); 
    } else if (o.hasValueSet()) { 
      b.setValueSet(o.getValueSet()); 
      b.getValueSetElement().setUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS, o.getValueSetElement()); 
    } 
    if (binding.hasStrength()) { 
      b.setStrength(binding.getStrength()); 
    } else if (o.hasStrength()) { 
      b.setStrength(o.getStrength()); 
      b.getStrengthElement().setUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS, o.getStrengthElement()); 
    } 
    if (binding.hasDescription()) { 
      b.setDescription(binding.getDescription()); 
    } else if (o.hasDescription()) { 
      b.setDescription(o.getDescription()); 
      b.getDescriptionElement().setUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS, o.getDescriptionElement()); 
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
      ElementDefinition ed = findElementDefinitionOrNull(sd, t.getName()); 
      if (ed != null) { // might be null because of added properties across versions 
        if (t.getValues().size() > 0 || snapshot) { 
          if (t.getValues().size() == 0 || (t.getValues().size() == 1 && t.getValues().get(0).isEmpty())) { 
            if (!skipnoValue) { 
              Row row = gen.new Row(); 
              row.setId(context.prefixAnchor(ed.getPath())); 
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
                row.setIcon("icon_fixed.gif", context.formatPhrase(RenderingContext.STRUC_DEF_FIXED_VALUE) /*context.formatPhrase(RenderingContext.TEXT_ICON_FIXED*/); 
              } else if (context.getContext().isPrimitiveType(t.getTypeCode())) { 
                row.setIcon("icon_primitive.png", context.formatPhrase(RenderingContext.TEXT_ICON_PRIMITIVE)); 
                c.addPiece(gen.new Piece(null, "0.."+(t.getMaxCardinality() == 2147483647 ? "*": Integer.toString(t.getMaxCardinality())), null)); 
              } else if (isReference(t.getTypeCode())) {  
                row.setIcon("icon_reference.png", context.formatPhrase(RenderingContext.TEXT_ICON_REFERENCE)); 
                c.addPiece(gen.new Piece(null, "0.."+(t.getMaxCardinality() == 2147483647 ? "*": Integer.toString(t.getMaxCardinality())), null)); 
              } else {  
                row.setIcon("icon_datatype.gif", context.formatPhrase(RenderingContext.TEXT_ICON_DATATYPE)); 
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
              row.setId(context.prefixAnchor(ed.getPath())); 
              erow.getSubRows().add(row); 
              row.setIcon("icon_fixed.gif", context.formatPhrase(RenderingContext.STRUC_DEF_FIXED) /*context.formatPhrase(RenderingContext.TEXT_ICON_FIXED*/); 
 
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
                c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_FIXED_VALUE)+" ", null).addStyle("font-weight: bold")); 
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
                c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_FIXED_VALUE)+" ", null).addStyle("font-weight: bold")); 
                c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_COMPLEXBRACK), null).addStyle("color: darkgreen")); 
                genFixedValue(gen, row, (DataType) b, snapshot, pattern, corePath, skipnoValue); 
              } 
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
 
 
  private ElementDefinition findElementDefinitionOrNull(StructureDefinition sd, String name) { 
    String path = sd.getTypeName()+"."+name; 
    for (ElementDefinition ed : sd.getSnapshot().getElement()) { 
      if (ed.getPath().equals(path)) 
        return ed; 
    } 
    return null; 
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
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_UNKNOWN_REF, definition.getContentReference()), null)); 
        else { 
          if (ed.getSource() == profile) { 
            c.getPieces().add(gen.new Piece("#"+ed.getElement().getPath(), context.formatPhrase(RenderingContext.STRUC_DEF_SEE, ed.getElement().getPath()), null)); 
          } else { 
            c.getPieces().add(gen.new Piece(ed.getSource().getWebPath()+"#"+ed.getElement().getPath(), context.formatPhrase(RenderingContext.STRUC_DEF_SEE, ed.getSource().getTypeName()) +"."+ed.getElement().getPath(), null)); 
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
          StructureDefinition ed = context.getProfileUtilities().findProfile(url, profile); 
          String ref = null; 
          if (ed != null) { 
            String p = ed.getWebPath(); 
            if (p != null) { 
              ref = p.startsWith("http:") || context.getRules() == GenerationRules.IG_PUBLISHER ? p : Utilities.pathURL(corePath, p); 
            } 
          } 
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_URLS), null).addStyle("font-weight:bold")); 
          c.getPieces().add(gen.new Piece(ref, fullUrl, null)); 
        } 
 
        if (definition.hasSlicing()) { 
          if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
          c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_SLICES), null).addStyle("font-weight:bold")); 
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
            c.getPieces().add(checkForNoChange(binding, gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_BINDINGS), null).addStyle("font-weight:bold"))); 
            c.getPieces().add(checkForNoChange(binding, checkAddExternalFlag(br, gen.new Piece(br.url == null ? null : Utilities.isAbsoluteUrl(br.url) || !context.getPkp().prependLinks() ? br.url : corePath+br.url, br.display, br.uri)))); 
            if (binding.hasStrength()) { 
              c.getPieces().add(checkForNoChange(binding, gen.new Piece(null, " (", null))); 
              c.getPieces().add(checkForNoChange(binding, gen.new Piece(corePath+"terminologies.html#"+binding.getStrength().toCode(), binding.getStrength().toCode(), binding.getStrength().getDefinition())));               
              c.getPieces().add(gen.new Piece(null, ")", null)); 
            } 
            if (binding.hasDescription() && MarkDownProcessor.isSimpleMarkdown(binding.getDescription())) { 
              c.getPieces().add(gen.new Piece(null, ": ", null)); 
              c.addMarkdownNoPara(PublicationHacker.fixBindingDescriptions(context.getWorker(), binding.getDescriptionElement()).asStringValue()); 
            }
            if (binding.hasExtension(ExtensionDefinitions.EXT_CONCEPT_DOMAIN)) { 
              c.getPieces().add(gen.new Piece(null, ". ", null));  
              c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingI18nContext.SDR_CONCEPT_DOMAIN), null));  
              c.getPieces().add(gen.new Piece(null, ": ", null));  
              c.getPieces().add(describeCoded(gen, binding.getExtensionByUrl(ExtensionDefinitions.EXT_CONCEPT_DOMAIN).getValue()));  
            }
          } 
          for (ElementDefinitionConstraintComponent inv : definition.getConstraint()) { 
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
            c.getPieces().add(checkForNoChange(inv, gen.new Piece(null, inv.getKey()+": ", null).addStyle("font-weight:bold"))); 
            if (inv.getHumanElement().hasExtension(ExtensionDefinitions.EXT_REND_MD)) { 
              c.addMarkdown(inv.getHumanElement().getExtensionString(ExtensionDefinitions.EXT_REND_MD)); 
            } else { 
              c.getPieces().add(checkForNoChange(inv, gen.new Piece(null, inv.getHuman(), null))); 
            } 
          } 
          if (definition.hasFixed()) { 
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
            c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_FIXED_VALUE), null).addStyle("font-weight:bold"))); 
            String s = buildJson(definition.getFixed()); 
            String link = null; 
            if (Utilities.isAbsoluteUrl(s)) 
              link = context.getPkp().getLinkForUrl(corePath, s); 
            c.getPieces().add(checkForNoChange(definition.getFixed(), gen.new Piece(link, s, null).addStyle("color: darkgreen"))); 
          } else if (definition.hasPattern()) { 
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
            c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_REQUIRED_PATT), null).addStyle("font-weight:bold"))); 
            c.getPieces().add(checkForNoChange(definition.getPattern(), gen.new Piece(null, buildJson(definition.getPattern()), null).addStyle("color: darkgreen"))); 
          } else if (definition.hasExample()) { 
            for (ElementDefinitionExampleComponent ex : definition.getExample()) { 
              if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
              c.getPieces().add(checkForNoChange(ex, gen.new Piece(null, context.formatPhrase(RenderingContext.GENERAL_EXAMPLE) +"'"+("".equals("General")? "": " "+ex.getLabel()+"'")+": ", "").addStyle("font-weight:bold"))); 
              c.getPieces().add(checkForNoChange(ex, gen.new Piece(null, buildJson(ex.getValue()), null).addStyle("color: darkgreen"))); 
            } 
          } 
          if (definition.hasMaxLength() && definition.getMaxLength()!=0) { 
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
            c.getPieces().add(checkForNoChange(definition.getMaxLengthElement(), gen.new Piece(null, context.formatPhrase(RenderingContext.GENERAL_MAX_LENGTH), null).addStyle("font-weight:bold"))); 
            c.getPieces().add(checkForNoChange(definition.getMaxLengthElement(), gen.new Piece(null, Integer.toString(definition.getMaxLength()), null).addStyle("color: darkgreen"))); 
          } 
          if (definition.hasExtension(ExtensionDefinitions.EXT_MIN_LENGTH)) {
            int min = ExtensionUtilities.readIntegerExtension(definition, ExtensionDefinitions.EXT_MIN_LENGTH, 0);
            if (min > 0) {
              if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
              c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.GENERAL_MIN_LENGTH), null).addStyle("font-weight:bold")); 
              c.getPieces().add(gen.new Piece(null, Integer.toString(min), null).addStyle("color: darkgreen"));
            }
          }
          if (profile != null) { 
            for (StructureDefinitionMappingComponent md : profile.getMapping()) { 
              if (md.hasExtension(ExtensionDefinitions.EXT_TABLE_NAME)) { 
                ElementDefinitionMappingComponent map = null; 
                for (ElementDefinitionMappingComponent m : definition.getMapping())  
                  if (m.getIdentity().equals(md.getIdentity())) 
                    map = m; 
                if (map != null) { 
                  for (int i = 0; i<definition.getMapping().size(); i++){ 
                    c.addPiece(gen.new Piece("br")); 
                    c.getPieces().add(gen.new Piece(null, ExtensionUtilities.readStringExtension(md, ExtensionDefinitions.EXT_TABLE_NAME)+": " + map.getMap(), null)); 
                  } 
                } 
              } 
            } 
          } 
          if (definition.hasDefinition()) { 
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
            c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.GENERAL_DEFINITION_COLON), null).addStyle("font-weight:bold")); 
            c.addPiece(gen.new Piece("br")); 
            c.addMarkdown(definition.getDefinition()); 
            //            c.getPieces().add(checkForNoChange(definition.getCommentElement(), gen.new Piece(null, definition.getComment(), null))); 
          } 
          if (definition.getComment()!=null) { 
            if (!c.getPieces().isEmpty()) { c.addPiece(gen.new Piece("br")); } 
            c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingContext.STRUC_DEF_COMMENT), null).addStyle("font-weight:bold")); 
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
 
  public static boolean hasNonBaseConditions(List<IdType> conditions) { 
    for (IdType c : conditions) { 
      if (!isBaseCondition(c)) { 
        return true; 
      } 
    } 
    return false; 
  } 
 
 
  public static boolean hasNonBaseConstraints(List<ElementDefinitionConstraintComponent> constraints) { 
    for (ElementDefinitionConstraintComponent c : constraints) { 
      if (!isBaseConstraint(c)) { 
        return true; 
      } 
    } 
    return false; 
  } 
 
  public String listConstraintsAndConditions(ElementDefinition element) { 
    Set<String> ids = new HashSet<>(); 
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(); 
    for (ElementDefinitionConstraintComponent con : element.getConstraint()) { 
      if (!isBaseConstraint(con)) { 
        if (!ids.contains(con.getKey())) { 
          ids.add(con.getKey()); 
          b.append(con.getKey()); 
        } 
      } 
    } 
    for (IdType id : element.getCondition()) { 
      if (!isBaseCondition(id)) { 
        if (!ids.contains(id.asStringValue())) { 
          ids.add(id.asStringValue()); 
          b.append(id.asStringValue()); 
        } 
      } 
    } 
    return b.toString(); 
  } 
 
  private static boolean isBaseCondition(IdType c) { 
    String key = c.asStringValue(); 
    return key != null && (key.startsWith("ele-") || key.startsWith("res-") || key.startsWith("ext-") || key.startsWith("dom-") || key.startsWith("dr-")); 
  } 
 
  private static boolean isBaseConstraint(ElementDefinitionConstraintComponent con) { 
    String key = con.getKey(); 
    return key != null && (key.startsWith("ele-") || key.startsWith("res-") || key.startsWith("ext-") || key.startsWith("dom-") || key.startsWith("dr-")); 
  } 
 
  private void makeChoiceRows(List<Row> subRows, ElementDefinition element, HierarchicalTableGenerator gen, String corePath, String profileBaseFileName, boolean mustSupportMode, StructureDefinition src) {
    // create a child for each choice 
    for (TypeRefComponent tr : element.getType()) { 
      if (!mustSupportMode || allTypesMustSupport(element) || isMustSupport(tr)) { 
        boolean used = false; 
        Row choicerow = gen.new Row(); 
        choicerow.setId(context.prefixAnchor(element.getPath())); 
        String ts = tr.getWorkingCode();
        String tu = tr.getWorkingCode();
        if (Utilities.isAbsoluteUrl(ts)) {
          StructureDefinition sd = context.getProfileUtilities().findProfile(ts, src);
          if (sd != null) {
            ts = sd.getType();
          }
        }
        if (Utilities.isAbsoluteUrl(ts)) {
          ts = utail(ts);
        }
        if (isReference(tu)) { 
          used = true; 
          choicerow.getCells().add(gen.new Cell(null, null, tail(element.getPath()).replace("[x]", Utilities.capitalize(ts)), null, null)); 
          choicerow.getCells().add(gen.new Cell()); 
          choicerow.getCells().add(gen.new Cell(null, null, "", null, null)); 
          choicerow.setIcon("icon_reference.png", context.formatPhrase(RenderingContext.TEXT_ICON_REFERENCE)); 
          Cell c = gen.new Cell(); 
          choicerow.getCells().add(c); 
          if (ADD_REFERENCE_TO_TABLE) { 
            if (tr.getWorkingCode().equals("canonical")) 
              c.getPieces().add(gen.new Piece(corePath+"datatypes.html#canonical", "canonical", null)); 
            else 
              c.getPieces().add(gen.new Piece(corePath+"references.html#Reference", "Reference", null)); 
            if (!mustSupportMode && isMustSupportDirect(tr) && element.getMustSupport()) { 
              c.addPiece(gen.new Piece(null, " ", null)); 
              c.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_SUPP)), "S", "white", "red", null, false); 
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
                c.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_TARG_SUPP)), "S", "white", "red", null, false); 
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
          StructureDefinition sd = context.getWorker().fetchTypeDefinition(tu); 
          if (sd == null) { 

            log.debug("Unable to find "+tu);

            sd = context.getWorker().fetchTypeDefinition(tu); 
          } else if (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE) { 
            used = true; 
            choicerow.getCells().add(gen.new Cell(null, null, tail(element.getPath()).replace("[x]",  Utilities.capitalize(ts)), sd.getDescription(), null)); 
            choicerow.getCells().add(gen.new Cell()); 
            choicerow.getCells().add(gen.new Cell(null, null, "", null, null)); 
            choicerow.setIcon("icon_primitive.png", context.formatPhrase(RenderingContext.TEXT_ICON_PRIMITIVE)); 
            Cell c = gen.new Cell(null, corePath+"datatypes.html#"+tu, sd.getTypeName(), null, null); 
            choicerow.getCells().add(c); 
            if (!mustSupportMode && isMustSupport(tr) && element.getMustSupport()) { 
              c.addPiece(gen.new Piece(null, " ", null)); 
              c.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_TARG_SUPP)), "S", "white", "red", null, false); 
            } 
          } else { 
            used = true; 
            choicerow.getCells().add(gen.new Cell(null, null, tail(element.getPath()).replace("[x]",  Utilities.capitalize(ts)), sd.getDescription(), null)); 
            choicerow.getCells().add(gen.new Cell()); 
            choicerow.getCells().add(gen.new Cell(null, null, "", null, null)); 
            choicerow.setIcon("icon_datatype.gif", context.formatPhrase(RenderingContext.TEXT_ICON_DATATYPE)); 
            Cell c = gen.new Cell(null, context.getPkp().getLinkFor(corePath, tu), sd.getTypeName(), null, null); 
            choicerow.getCells().add(c); 
            if (!mustSupportMode && isMustSupport(tr) && element.getMustSupport()) { 
              c.addPiece(gen.new Piece(null, " ", null)); 
              c.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_SUPP)), "S", "white", "red", null, false); 
            } 
          } 
          if (tr.hasProfile() && used) { 
            Cell typeCell = choicerow.getCells().get(3); 
            typeCell.addPiece(gen.new Piece(null, "(", null)); 
            boolean first = true; 
            for (CanonicalType pt : tr.getProfile()) { 
              if (!mustSupportMode || allProfilesMustSupport(tr.getProfile()) || isMustSupport(pt)) { 
                if (first) first = false; else typeCell.addPiece(gen.new Piece(null, " | ", null)); 
                StructureDefinition psd = context.getProfileUtilities().findProfile(pt.getValue(), src); 
                if (psd == null) 
                  typeCell.addPiece(gen.new Piece(null, "?gen-e2?", null)); 
                else 
                  typeCell.addPiece(gen.new Piece(psd.getWebPath(), psd.getName(), psd.present())); 
                if (!mustSupportMode && isMustSupport(pt) && element.getMustSupport()) { 
                  typeCell.addPiece(gen.new Piece(null, " ", null)); 
                  typeCell.addStyledText((context.formatPhrase(RenderingContext.STRUC_DEF_PROF_SUPP)), "S", "white", "red", null, false); 
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
    if (src1.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS) && src2.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS)) { 
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
    return formatPhrase(RenderingContext.SD_SLICING_INFO, slicing.getOrdered() ? (context.formatPhrase(RenderingContext.STRUC_DEF_ORDERED)) : (context.formatPhrase(RenderingContext.STRUC_DEF_UNORDERED)), describe(slicing.getRules()), commas(slicing.getDiscriminator())); 
  } 
 
 
 
  private String commas(List<ElementDefinitionSlicingDiscriminatorComponent> list) { 
    CommaSeparatedStringBuilder c = new CommaSeparatedStringBuilder(); 
    for (ElementDefinitionSlicingDiscriminatorComponent id : list) 
      c.append((id.hasType() ? id.getType().toCode() : "??")+":"+id.getPath()); 
    return c.toString(); 
  } 
 
 
  private String describe(SlicingRules rules) { 
    if (rules == null) 
      return (context.formatPhrase(RenderingContext.STRUC_DEF_UNSPECIFIED)); 
    switch (rules) { 
    case CLOSED : return (context.formatPhrase(RenderingContext.STRUC_DEF_CLOSED)); 
    case OPEN : return (context.formatPhrase(RenderingContext.STRUC_DEF_OPEN)); 
    case OPENATEND : return (context.formatPhrase(RenderingContext.STRUC_DEF_OPEN_END)); 
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
    return ("true".equals(ExtensionUtilities.readStringExtension(tr, ExtensionDefinitions.EXT_MUST_SUPPORT))); 
  } 
 
  public boolean isMustSupport(TypeRefComponent tr) { 
    if ("true".equals(ExtensionUtilities.readStringExtension(tr, ExtensionDefinitions.EXT_MUST_SUPPORT))) { 
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
    return "true".equals(ExtensionUtilities.readStringExtension(profile, ExtensionDefinitions.EXT_MUST_SUPPORT)); 
  } 
 
 
 
  private SpanEntry buildSpanEntryFromProfile(String name, String cardinality, StructureDefinition profile) throws IOException { 
    SpanEntry res = new SpanEntry(); 
    res.setName(name); 
    res.setCardinality(cardinality); 
    res.setProfileLink(profile.getWebPath()); 
    res.setResType(profile.getTypeName()); 
    StructureDefinition base = context.getProfileUtilities().findProfile(res.getResType(), profile);
    if (base != null) 
      res.setResLink(base.getWebPath()); 
    res.setId(context.prefixAnchor(profile.getId())); 
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
      res.setDescription(context.formatPhrase(RenderingContext.STRUC_DEF_FHIR, profile.getName())+" "); 
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
    String system = displaySystem(uri); 
    if (Utilities.isURL(system)) { 
      if (system.equals("http://cap.org/protocols")) 
        system = context.formatPhrase(RenderingContext.STRUC_DEF_CAP); 
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
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingContext.STRUC_DEF_PROPERTY), context.formatPhrase(RenderingContext.STRUC_DEF_PROF_RES), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingContext.GENERAL_CARD), context.formatPhrase(RenderingContext.STRUC_DEF_MAX_MIN), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingContext.GENERAL_CONTENT), context.formatPhrase(RenderingContext.STRUC_DEF_WHAT), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingContext.GENERAL_DESC), context.formatPhrase(RenderingContext.STRUC_DEF_DESC_PROF), null, 0)); 
    return model; 
  } 
 
  private void genSpanEntry(HierarchicalTableGenerator gen, List<Row> rows, SpanEntry span) throws IOException { 
    Row row = gen.new Row(); 
    row.setId(context.prefixAnchor("??")); 
    rows.add(row); 
    row.setAnchor(context.prefixAnchor(span.getId())); 
    //row.setColor(..?); 
    if (span.isProfile()) { 
      row.setIcon("icon_profile.png", context.formatPhrase(RenderingContext.GENERAL_PROF)); 
    } else { 
      row.setIcon("icon_resource.png", context.formatPhrase(RenderingContext.GENERAL_RESOURCE)); 
    } 
 
    row.getCells().add(gen.new Cell(null, null, span.getName(), null, null)); 
    row.getCells().add(gen.new Cell(null, null, span.getCardinality(), null, null)); 
    row.getCells().add(gen.new Cell(null, span.getProfileLink(), span.getType(), null, null)); 
    row.getCells().add(gen.new Cell(null, null, span.getDescription(), null, null)); 
 
    for (SpanEntry child : span.getChildren()) { 
      genSpanEntry(gen, row.getSubRows(), child); 
    } 
  } 
 
 
  public XhtmlNode generateSpanningTable(StructureDefinition profile, String imageFolder, boolean onlyConstraints, String constraintPrefix, Set<String> outputTracker, String anchorPrefix) throws IOException, FHIRException { 
    anchors.clear();
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, imageFolder, false, true, "", anchorPrefix);
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
                StructureDefinition sd = context.getProfileUtilities().findProfile(uri, profile);
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
    for (Extension e : d.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_SPEC)) { 
      if (first) first = false; else x.br(); 
      String cond = ExtensionUtilities.readStringExtension(e, "condition"); 
      String type = ExtensionUtilities.readStringExtension(e, "type"); 
      x.tx(context.formatPhrase(RenderingContext.STRUC_DEF_IF)+" "); 
      x.code().tx(cond); 
      x.tx(" "+(context.formatPhrase(RenderingContext.STRUC_DEF_THEN_TYPE)+" ")); 
      StructureDefinition sd = context.getContext().fetchTypeDefinition(type); 
      if (sd == null) { 
        x.code().tx(type); 
      } else { 
        x.ah(context.prefixLocalHref(sd.getWebPath())).tx(sd.getTypeName()); 
      } 
    } 
    return first ? null : x; 
  } 
 
  public XhtmlNode generateExtensionTable(RenderingStatus status, String defFile, StructureDefinition ed, String imageFolder, boolean inlineGraphics, boolean full, String corePath, String imagePath, Set<String> outputTracker, RenderingContext rc, String defPath, String anchorPrefix, ResourceWrapper res, boolean diff) throws IOException, FHIRException {
    anchors.clear();
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, imageFolder, inlineGraphics, true, defPath, anchorPrefix);
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
    r.setId(context.prefixAnchor("Extension")); 
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
 
      r.setIcon(deep ? "icon_"+m+"extension_complex.png" : "icon_extension_simple.png", deep ? context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_COMPLEX) : context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_SIMPLE)); 
      List<ElementDefinition> children = getChildren(ed.getSnapshot().getElement(), ed.getSnapshot().getElement().get(0)); 
      for (ElementDefinition child : children) 
        if (!child.getPath().endsWith(".id")) { 
          List<StructureDefinition> sdl = new ArrayList<>(); 
          sdl.add(ed); 
          genElement(status, defFile == null ? "" : defFile+"-definitions.html#extension.", gen, r.getSubRows(), child, ed.getSnapshot().getElement(), sdl, true, defFile, true, full, corePath, imagePath, true, false, false, false, null, false, rc, "", ed, null, res, false, null, diff);
        } 
    } else if (deep) { 
      List<ElementDefinition> children = new ArrayList<ElementDefinition>(); 
      for (ElementDefinition ted : ed.getSnapshot().getElement()) { 
        if (ted.getPath().equals("Extension.extension")) 
          children.add(ted); 
      } 
 
      r.getCells().add(gen.new Cell("", "", "Extension", null, null)); 
      r.setIcon("icon_"+m+"extension_complex.png", context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_COMPLEX)); 
 
      for (ElementDefinition c : children) { 
        ved = getValueFor(ed, c); 
        ElementDefinition ued = getUrlFor(ed, c); 
        if (ved != null && ued != null) { 
          Row r1 = gen.new Row(); 
          r1.setId(context.prefixAnchor(ued.getPath())); 
          r.getSubRows().add(r1); 
          r1.getCells().add(gen.new Cell(null, defFile == null ? "" : defFile+"-definitions.html#"+ed.getId()+"."+c.getId(), ((UriType) ued.getFixed()).getValue(), null, null)); 
          r1.getCells().add(gen.new Cell()); 
          r1.getCells().add(gen.new Cell(null, null, describeCardinality(c, null, new UnusedTracker()), null, null)); 
          genTypes(gen, r1, ved, defFile, ed, corePath, imagePath, false, false, diff);
          r1.setIcon("icon_"+m+"extension_simple.png", context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_SIMPLE));       
          generateDescription(status, gen, r1, c, null, corePath, corePath, ed, corePath, imagePath, false, false, false, ved, false, false, false, rc, new ArrayList<ElementDefinition>(), res);
        } 
      } 
    } else  { 
      for (ElementDefinition ted : ed.getSnapshot().getElement()) { 
        if (ted.getPath().startsWith("Extension.value")) 
          ved = ted; 
      } 
 
      genTypes(gen, r, ved, defFile, ed, corePath, imagePath, false, false, diff);
 
      r.setIcon("icon_"+m+"extension_simple.png", context.formatPhrase(RenderingContext.TEXT_ICON_EXTENSION_SIMPLE));       
    } 
    Cell c = gen.new Cell("", "", "URL = "+ed.getUrl(), null, null); 
    Piece cc = gen.new Piece(null, ed.getName()+": ", null); 
    c.addPiece(gen.new Piece("br")).addPiece(cc); 
    c.addMarkdown(ed.getDescription()); 
 
    if (!full && !(deep || vdeep) && ved != null && ved.hasBinding()) {   
      c.addPiece(gen.new Piece("br")); 
      BindingResolution br = context.getPkp().resolveBinding(ed, ved.getBinding(), ved.getPath()); 
      c.getPieces().add(checkForNoChange(ved.getBinding(), gen.new Piece(null, (context.formatPhrase(RenderingContext.GENERAL_BINDING))+": ", null).addStyle("font-weight:bold"))); 
      c.getPieces().add(checkForNoChange(ved.getBinding(), checkAddExternalFlag(br, gen.new Piece(br.url == null ? null : Utilities.isAbsoluteUrl(br.url) || !context.getPkp().prependLinks() ? br.url : corePath+br.url, br.display, br.uri)))); 
      if (ved.getBinding().hasStrength()) { 
        c.getPieces().add(checkForNoChange(ved.getBinding(), gen.new Piece(null, " (", null))); 
        c.getPieces().add(checkForNoChange(ved.getBinding(), gen.new Piece(corePath+"terminologies.html#"+ved.getBinding().getStrength().toCode(), egt(ved.getBinding().getStrengthElement()), ved.getBinding().getStrength().getDefinition())));               
        c.getPieces().add(gen.new Piece(null, ")", null)); 
      } 
      if (ved.getBinding().hasDescription() && MarkDownProcessor.isSimpleMarkdown(ved.getBinding().getDescription())) { 
        c.getPieces().add(gen.new Piece(null, ": ", null)); 
        c.addMarkdownNoPara(PublicationHacker.fixBindingDescriptions(context.getWorker(), ved.getBinding().getDescriptionElement()).asStringValue()); 
      } 

      if (ved.getBinding().hasExtension(ExtensionDefinitions.EXT_CONCEPT_DOMAIN)) { 
        c.getPieces().add(gen.new Piece(null, ". ", null));  
        c.getPieces().add(gen.new Piece(null, context.formatPhrase(RenderingI18nContext.SDR_CONCEPT_DOMAIN), null));  
        c.getPieces().add(gen.new Piece(null, ": ", null));  
        c.getPieces().add(describeCoded(gen, ved.getBinding().getExtensionByUrl(ExtensionDefinitions.EXT_CONCEPT_DOMAIN).getValue()));  
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
 
  public void renderDict(RenderingStatus status, StructureDefinition sd, List<ElementDefinition> elements, XhtmlNode t, boolean incProfiledOut, int mode, String anchorPrefix, ResourceWrapper res) throws FHIRException, IOException { 
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
          compareElement = getBaseElement(ec, sd.getBaseDefinition(), sd);
        else if (mode==GEN_MODE_KEY) 
          compareElement = getRootElement(ec, sd);
 
        List<String> anchors = makeAnchors(ec, anchorPrefix); 
        String title = ec.getId(); 
        XhtmlNode tr = t.tr(); 
        XhtmlNode sp = renderStatus(ec, tr.td("structure").colspan(2).spanClss("self-link-parent")); 
        for (String s : anchors) { 
          sp.an(context.prefixAnchor(s)).tx(" "); 
        } 
        sp.span("color: grey", null).tx(Integer.toString(i++)); 
        sp.b().tx(". "+title); 
        link(sp, ec.getId(), anchorPrefix); 
        if (isProfiledExtension(ec)) { 
          StructureDefinition extDefn = context.getProfileUtilities().findProfile(ec.getType().get(0).getProfile().get(0).getValue(), sd);
          if (extDefn == null) { 
            generateElementInner(status, t, sd, ec, 1, null, compareElement, null, false, "", anchorPrefix, elements, res);
          } else { 
            ElementDefinition valueDefn = getExtensionValueDefinition(extDefn); 
            ElementDefinition compareValueDefn = null; 
            try { 
              StructureDefinition compareExtDefn = context.getProfileUtilities().findProfile(compareElement.getType().get(0).getProfile().get(0).getValue(), sd);
              compareValueDefn = getExtensionValueDefinition(extDefn); 
            } catch (Exception except) {} 
            generateElementInner(status, t, sd, ec, valueDefn == null || valueDefn.prohibited() ? 2 : 3, valueDefn, compareElement, compareValueDefn, false, "", anchorPrefix, elements, res);
            // generateElementInner(b, extDefn, extDefn.getSnapshot().getElement().get(0), valueDefn == null ? 2 : 3, valueDefn); 
          } 
        } else { 
          while (!dstack.isEmpty() && !isParent(dstack.peek(), ec)) {
            finish(status, t, sd, dstack.pop(), mode, "", anchorPrefix, res);
          } 
          dstack.push(ec);             
          generateElementInner(status, t, sd, ec, mode, null, compareElement, null, false, "", anchorPrefix, elements, res);
          if (ec.hasSlicing()) { 
            generateSlicing(t, sd, ec, ec.getSlicing(), compareElement, mode, false); 
          } 
        } 
      } 
      t.tx("\r\n"); 
      i++; 
    } 
    while (!dstack.isEmpty()) { 
      finish(status, t, sd, dstack.pop(), mode, "", anchorPrefix, res);
    } 
    finish(status, t, sd, null, mode, "", anchorPrefix, res);
  } 
 
  private void finish(RenderingStatus status, XhtmlNode t, StructureDefinition sd, ElementDefinition ed, int mode, String defPath, String anchorPrefix, ResourceWrapper res) throws FHIRException, IOException {
    for (Base b : VersionComparisonAnnotation.getDeleted(ed == null ? sd : ed, "element")) { 
      ElementDefinition ec = (ElementDefinition) b; 
      String title = ec.getId(); 
      XhtmlNode tr = t.tr(); 
      XhtmlNode sp = renderStatus(ec, tr.td("structure").colspan(2).spanClss("self-link-parent")); 
      sp.span("color: grey", null).tx("--"); 
      sp.b().tx(". "+title); 
       
      generateElementInner(status, t, sd, ec, mode, null, null, null, true, defPath, anchorPrefix, new ArrayList<ElementDefinition>(), res);
      if (ec.hasSlicing()) { 
        generateSlicing(t, sd, ec, ec.getSlicing(), null, mode, true); 
      }       
    } 
  } 
 
  public ElementDefinition getElementById(String url, String id, StructureDefinition srcSd) {
    Map<String, ElementDefinition> sdCache = sdMapCache.get(url); 
 
    if (sdCache == null) { 
      StructureDefinition sd = (StructureDefinition) context.getProfileUtilities().findProfile(url, srcSd);
      if (sd == null) { 
        if (url.equals("http://hl7.org/fhir/StructureDefinition/Base")) { 
          sd = (StructureDefinition) context.getProfileUtilities().findProfile("http://hl7.org/fhir/StructureDefinition/Element", null);
        } 
        if (sd == null) { 
          throw new FHIRException(context.formatPhrase(RenderingContext.STRUC_DEF_FHIR_EXCEP, url)+" "); 
        } 
      } 
      sdCache = new HashMap<String, ElementDefinition>(); 
      sdMapCache.put(url, sdCache); 
      String webroot = sd.getUserString(UserDataNames.render_webroot); 
      for (ElementDefinition e : sd.getSnapshot().getElement()) { 
        context.getProfileUtilities().updateURLs(sd.getUrl(), webroot, e, false); 
        sdCache.put(e.getId(), e); 
      } 
    } 
    return sdCache.get(id); 
  } 
 
 
  // Returns the ElementDefinition for the 'parent' of the current element 
  private ElementDefinition getBaseElement(ElementDefinition e, String url, StructureDefinition sd) {
    if (e.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER)) { 
      return getElementById(url, e.getUserString(UserDataNames.SNAPSHOT_DERIVATION_POINTER), sd);
    } 
    return null; 
  } 
 
  // Returns the ElementDefinition for the 'root' ancestor of the current element 
  private ElementDefinition getRootElement(ElementDefinition e, StructureDefinition sd) {
    if (!e.hasBase()) 
      return null; 
    String basePath = e.getBase().getPath(); 
    String url = "http://hl7.org/fhir/StructureDefinition/" + (basePath.contains(".") ? basePath.substring(0, basePath.indexOf(".")) : basePath); 
    try { 
      return getElementById(url, basePath, sd);
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
            aliases.add(name.replace("[x]", Utilities.capitalize(tc))+":"+name.replace("[x]", Utilities.capitalize(tc))); 
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
        List<String> other = (List<String>) allAnchors.get(s).getUserData(UserDataNames.render_dict_generator_anchors); 
        other.remove(s); 
        allAnchors.put(s, ed); 
      } 
    } 
    list.removeAll(removed); 
    ed.setUserData(UserDataNames.render_dict_generator_anchors, list); 
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
    List<String> list = (List<String>) ed.getUserData(UserDataNames.render_dict_generator_anchors); 
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
    var ah = x.ah(context.prefixLocalHref("#" + anchorPrefix + id)); 
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
    XhtmlNode ndiv = new XhtmlNode(NodeType.Element, "div"); 
    if (compare == null || mode == GEN_MODE_DIFF) { 
      if (md.hasValue()) { 
        String xhtml = hostMd.processMarkdown(location, md); 
        if (Utilities.noString(xhtml)) { 
          return null; 
        } 
        try { 
          renderStatusDiv(md, ndiv).addChildren(fixFontSizes(new XhtmlParser().parseMDFragment(xhtml), 11)); 
        } catch (Exception e) { 
          ndiv.span("color: maroon").tx(e.getLocalizedMessage());        
          e.printStackTrace(); 
        } 
        return ndiv; 
      } else { 
        return null; 
      } 
    } else if (areEqual(compare, md)) { 
      if (md.hasValue()) { 
        String xhtml = hostMd.processMarkdown(location, md); 
        List<XhtmlNode> nodes = new XhtmlParser().parseMDFragment(xhtml); 
        for (XhtmlNode n : nodes) { 
          if (n.getNodeType() == NodeType.Element) { 
            n.style(unchangedStyle()); 
          } 
        } 
        ndiv.addChildren(nodes); 
        return ndiv; 
      } else { 
        return null; 
      } 
    } else { 
      if (md.hasValue()) { 
        String xhtml = hostMd.processMarkdown(location, md); 
        List<XhtmlNode> div = new XhtmlParser().parseMDFragment(xhtml); 
        ndiv.addChildren(div); 
      } 
      if (compare.hasValue()) { 
        String xhtml = "<div>"+hostMd.processMarkdown(location, compare)+"</div>"; 
        List<XhtmlNode> div = new XhtmlParser().parseMDFragment(xhtml); 
        for (XhtmlNode n : div) { 
          if (n.getNodeType() == NodeType.Element) { 
            n.style(removedStyle()); 
          } 
        } 
        ndiv.br(); 
        ndiv.addChildren(div); 
      } 
      return ndiv; 
    } 
  } 
 
  private List<XhtmlNode> fixFontSizes(List<XhtmlNode> nodes, int size) { 
    for (XhtmlNode x : nodes) { 
      if (Utilities.existsInList(x.getName(), "p", "li") && !x.hasAttribute("style")) { 
        x.style("font-size: "+size+"px"); 
      } 
      if (x.hasChildren()) { 
        fixFontSizes(x.getChildNodes(), size); 
      } 
    } 
    return nodes; 
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
 
  public XhtmlNode compareString(String newStr, Base source, String nLink, String name, Base parent, String oldStr, String oLink, int mode, boolean externalN, boolean externalO) {     
    return compareString(newStr, source, nLink, name, parent, oldStr, oLink, mode, externalN, externalO, false); 
  } 
   
  public XhtmlNode compareString(String newStr, Base source, String nLink, String name, Base parent, String oldStr, String oLink, int mode, boolean externalN, boolean externalO, boolean code) { 
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div"); 
    if (mode != GEN_MODE_KEY) { 
      if (newStr != null) { 
        renderStatus(source, x).ah(context.prefixLocalHref(nLink)).txOrCode(code, newStr).iff(externalN).txN(" ").img("external.png", null); 
      } else if (VersionComparisonAnnotation.hasDeleted(parent, name)) { 
        PrimitiveType p = (PrimitiveType) VersionComparisonAnnotation.getDeletedItem(parent, name); 
        renderStatus(p, x).txOrCode(code, p.primitiveValue());         
      } else { 
        return null; 
      } 
    } else if (oldStr==null || oldStr.isEmpty()) { 
      if (newStr==null || newStr.isEmpty()) { 
        return null; 
      } else { 
        renderStatus(source, x).ah(context.prefixLocalHref(nLink)).txOrCode(code, newStr).iff(externalN).txN(" ").img("external.png", null); 
      } 
    } else if (oldStr!=null && !oldStr.isEmpty() && (newStr==null || newStr.isEmpty())) { 
      if (mode == GEN_MODE_DIFF) { 
        return null; 
      } else { 
        removed(x).ah(context.prefixLocalHref(oLink)).txOrCode(code, oldStr).iff(externalO).txN(" ").img("external.png", null); 
      } 
    } else if (oldStr.equals(newStr)) { 
      if (mode==GEN_MODE_DIFF) { 
        return null; 
      } else { 
        unchanged(x).ah(context.prefixLocalHref(nLink)).txOrCode(code, newStr).iff(externalN).txN(" ").img("external.png", null); 
      } 
    } else if (newStr.startsWith(oldStr)) { 
      unchanged(x).ah(context.prefixLocalHref(oLink)).txOrCode(code, oldStr).iff(externalO).txN(" ").img("external.png", null); 
      renderStatus(source, x).ah(context.prefixLocalHref(nLink)).txN(newStr.substring(oldStr.length())).iff(externalN).txN(" ").img("external.png", null); 
    } else { 
      // TODO: improve comparision in this fall-through case, by looking for matches in sub-paragraphs? 
      renderStatus(source, x).ah(context.prefixLocalHref(nLink)).txOrCode(code, newStr).iff(externalN).txN(" ").img("external.png", null); 
      removed(x).ah(context.prefixLocalHref(oLink)).txOrCode(code, oldStr).iff(externalO).txN(" ").img("external.png", null); 
    } 
    return x; 
  } 
 
  public boolean compareString(XhtmlNode x, String newStr, Base source, String nLink, String name, Base parent, String oldStr, String oLink, int mode, boolean externalN, boolean externalO) { 
    XhtmlNode x1 = compareString(newStr, source, nLink, name, parent, oldStr, oLink, mode, externalN, externalO); 
    if (x1 == null) { 
      return false; 
    } else { 
      x.addChildNodes(x1.getChildNodes()); 
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
 
  private void generateElementInner(RenderingStatus status, XhtmlNode tbl, StructureDefinition sd, ElementDefinition d, int mode, ElementDefinition value, ElementDefinition compare, ElementDefinition compareValue, boolean strikethrough, String defPath, String anchorPrefix, List<ElementDefinition> inScopeElements, ResourceWrapper res) throws FHIRException, IOException {
    boolean root = !d.getPath().contains("."); 
    boolean slicedExtension = d.hasSliceName() && (d.getPath().endsWith(".extension") || d.getPath().endsWith(".modifierExtension")); 
//    int slicedExtensionMode = (mode == GEN_MODE_KEY) && slicedExtension ? GEN_MODE_SNAP : mode; // see ProfileUtilities.checkExtensionDoco / Task 3970 
    if (d.hasSliceName()) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_SLICE_NAME), "profiling.html#slicing", strikethrough, compareString(d.getSliceName(), d.getSliceNameElement(), null, (compare != null ? compare.getSliceName() : null), d, null, "sliceName", mode, false, false));    
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_CONSTRAINING), "profiling.html#slicing", strikethrough, compareString(encodeValue(d.getSliceIsConstrainingElement(), null), d.getSliceIsConstrainingElement(), null, (compare != null ? encodeValue(compare.getSliceIsConstrainingElement(), null) : null), d, null, "sliceName", mode, false, false));    
    } 
 
    tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_DEFINITION), null, strikethrough, compareMarkdown(sd.getName(), d.getDefinitionElement(), (compare==null) || slicedExtension ? null : compare.getDefinitionElement(), mode)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_SHORT), null, strikethrough, compareString(d.hasShort() ? d.getShort() : null, d.getShortElement(), null, "short", d, compare!= null && compare.hasShortElement() ? compare.getShort() : null, null, mode, false, false)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_COMMENTS), null, strikethrough, compareMarkdown(sd.getName(), d.getCommentElement(), (compare==null) || slicedExtension ? null : compare.getCommentElement(), mode)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_NOTE), null, strikethrough, businessIdWarning(sd.getName(), tail(d.getPath()))); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_CONTROL), "conformance-rules.html#conformance", strikethrough, describeCardinality(d, compare, mode));  
    tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_BINDING), "terminologies.html", strikethrough, describeBinding(sd, d, d.getPath(), compare, mode)); 
    if (d.hasContentReference()) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_TYPE), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_SEE) + d.getContentReference().substring(1)); 
    } else { 
      tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_TYPE), "datatypes.html", strikethrough, describeTypes(d.getType(), false, d, compare, mode, value, compareValue, sd));  
    } 
    if (root && sd.hasExtension(ExtensionDefinitions.EXT_TYPE_PARAMETER)) {
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_PARAMETER), "http://hl7.org/fhir/tools/StructureDefinition-type-parameter.html", strikethrough, renderTypeParameter(sd.getExtensionByUrl(ExtensionDefinitions.EXT_TYPE_PARAMETER)));
    }
    if (d.hasExtension(ExtensionDefinitions.EXT_DEF_TYPE)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_DEFAULT_TYPE), "datatypes.html", strikethrough, ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_DEF_TYPE));           
    } 
    if (d.hasExtension(ExtensionDefinitions.EXT_TYPE_SPEC)) { 
      tableRow(tbl, Utilities.pluralize(context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_SPEC), d.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_SPEC).size()), "datatypes.html", strikethrough, formatTypeSpecifiers(d));           
    } 
    if (d.getPath().endsWith("[x]") && !d.prohibited()) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_NOTE_X), null, strikethrough).ahWithText(context.formatPhrase(RenderingContext.STRUC_DEF_SEE) 
    		  , spec("formats.html#choice"), null, context.formatPhrase(RenderingContext.STRUC_DEF_CHOICE_DATA_TYPE), context.formatPhrase(RenderingContext.STRUC_DEF_FURTHER_INFO)); 
    } 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_MODIFIER), "conformance-rules.html#ismodifier", strikethrough, presentModifier(d, mode, compare)); 
    if (d.getMustHaveValue()) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_PRIMITIVE), "elementdefinition.html#primitives", strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_PRIM_TYPE_VALUE)); 
    } else if (d.hasValueAlternatives()) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_PRIMITIVE), "elementdefinition.html#primitives", strikethrough, renderCanonicalList(context.formatPhrase(RenderingContext.STRUC_DEF_PRIM_TYPE_PRESENT), d.getValueAlternatives()));       
    } else if (hasPrimitiveTypes(d)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_PRIMITIVE), "elementdefinition.html#primitives", strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_PRIM_ELE));             
    } 
    if (ExtensionUtilities.hasAllowedUnits(d)) {       
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_ALLOWED), "http://hl7.org/fhir/extensions/StructureDefinition-elementdefinition-allowedUnits.html", strikethrough, describeAllowedUnits(d));         
    } 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_MUST_SUPPORT), "conformance-rules.html#mustSupport", strikethrough, displayBoolean(d.getMustSupport(), d.getMustSupportElement(), "mustSupport", d, compare==null ? null : compare.getMustSupportElement(), mode)); 
    if (d.getMustSupport()) { 
      if (hasMustSupportTypes(d.getType())) { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_MUST_SUPPORT_TYPES), "datatypes.html", strikethrough, describeTypes(d.getType(), true, d, compare, mode, null, null, sd)); 
      } else if (hasChoices(d.getType())) { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_MUST_SUPPORT_TYPES), "datatypes.html", strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_NO_MUST_SUPPORT)); 
      } 
    } 
    if (root && sd.getKind() == StructureDefinitionKind.LOGICAL) { 
      Extension lt = ExtensionUtilities.getExtension(sd, ExtensionDefinitions.EXT_LOGICAL_TARGET); 
      if (lt == null || !lt.hasValue()) { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_LOGICAL), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_NOT_MARK));         
      } else if (lt.getValue().hasExtension(ExtensionDefinitions.EXT_DAR)) {         
      } else if (lt.getValueBooleanType().hasValue()) { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_LOGICAL), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_NOT_MARK));         
      } else if (lt.getValueBooleanType().booleanValue()) { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_LOGICAL), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_CAN_TARGET));         
      } else { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_LOGICAL), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_CANNOT_TARGET)); 
      } 
 
      Extension lc = ExtensionUtilities.getExtension(sd, ExtensionDefinitions.EXT_LOGICAL_CONTAINER); 
      if (lc != null && lc.hasValueUriType()) { 
        String uri = lc.getValue().primitiveValue(); 
        StructureDefinition lct = context.getContext().fetchTypeDefinition(uri); 
        if (lct != null) { 
          tableRowLink(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_LOGICAL_CONT), null, strikethrough, lct.present(), lct.getWebPath());         
        } else { 
          tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_LOGICAL_CONT), null, strikethrough, uri);         
        } 
      } 
       
      String ps = ExtensionUtilities.readStringExtension(sd, ExtensionDefinitions.EXT_PROFILE_STYLE); 
      if (ps != null) { 
        if ("cda".equals(ps)) { 
          tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_VALID), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_TEMPLATEID)); 
        } else { 
          tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_VALID), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_UNKNOWN_APPROACH, ps)+" "); 
        }               
      } 
    } 
 
    if (root && sd.hasExtension(ExtensionDefinitions.EXT_SD_IMPOSE_PROFILE)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_IMPOSE_PROFILE), "http://hl7.org/fhir/extensions/StructureDefinition-structuredefinition-imposeProfile.html", strikethrough,  
          renderCanonicalListExt(context.formatPhrase(RenderingContext.STRUC_DEF_PROF_REQ)+" ", sd.getExtensionsByUrl(ExtensionDefinitions.EXT_SD_IMPOSE_PROFILE))); 
    } 
    if (root && sd.hasExtension(ExtensionDefinitions.EXT_SD_COMPLIES_WITH_PROFILE)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_COMP_PROF), "http://hl7.org/fhir/extensions/StructureDefinition-structuredefinition-compliesWithProfile.html", strikethrough,  
          renderCanonicalListExt(context.formatPhrase(RenderingContext.STRUC_DEF_PROF_COMP)+" ", sd.getExtensionsByUrl(ExtensionDefinitions.EXT_SD_COMPLIES_WITH_PROFILE))); 
    } 
    tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_OBLIG), null, strikethrough, describeObligations(status, d, root, sd, defPath, anchorPrefix, inScopeElements, res));
 
    if (d.hasExtension(ExtensionDefinitions.EXT_EXTENSION_STYLE_NEW, ExtensionDefinitions.EXT_EXTENSION_STYLE_DEPRECATED)) {
      String es = d.getExtensionString(ExtensionDefinitions.EXT_EXTENSION_STYLE_NEW, ExtensionDefinitions.EXT_EXTENSION_STYLE_DEPRECATED);
      if ("named-elements".equals(es)) { 
        if (context.hasLink(KnownLinkType.JSON_NAMES)) { 
          tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_EXT_STYLE), context.getLink(KnownLinkType.JSON_NAMES, true), strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_EXT_JSON)); 
        } else { 
          tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_EXT_STYLE), ExtensionDefinitions.WEB_EXTENSION_STYLE, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_EXT_JSON));
        } 
      } 
    } 
 
    if (!d.getPath().contains(".") && ExtensionUtilities.hasExtension(sd, ExtensionDefinitions.EXT_BINDING_STYLE)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_BINDING_STYLE), ExtensionDefinitions.WEB_BINDING_STYLE, strikethrough,
    		  context.formatPhrase(RenderingContext.STRUC_DEF_TYPE_BOUND, ExtensionUtilities.readStringExtension(sd, ExtensionDefinitions.EXT_BINDING_STYLE)+" binding style")+" ");             
    } 
 
    if (d.hasExtension(ExtensionDefinitions.EXT_DATE_FORMAT)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_DATE_FORM), null, strikethrough, ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_DATE_FORMAT)); 
    } 
    String ide = ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_ID_EXPECTATION); 
    if (ide != null) { 
      if (ide.equals("optional")) { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_ID_EXPECT), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_ID_IS)); 
      } else if (ide.equals("required")) { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_ID_EXPECT), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_ID_MAY)); 
      } else if (ide.equals("required")) { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_ID_EXPECT), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_ID_NOT_ALLOW)); 
      } 
    } 
 
    if (d.hasExtension(ExtensionDefinitions.EXT_ID_CHOICE_GROUP)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_CHOICE_GRP), null, strikethrough, context.formatPhrase(RenderingContext.STRUC_DEF_REPEAT));           
    } 
     
    // tooling extensions for formats 
    if (ExtensionUtilities.hasAnyOfExtensions(d, ExtensionDefinitions.EXT_JSON_EMPTY, ExtensionDefinitions.EXT_JSON_PROP_KEY, ExtensionDefinitions.EXT_JSON_NULLABLE,  
        ExtensionDefinitions.EXT_JSON_NAME, ExtensionDefinitions.EXT_JSON_NAME_DEPRECATED, ExtensionDefinitions.EXT_JSON_PRIMITIVE_CHOICE)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_JSON_FORM), null, strikethrough,  describeJson(d));           
    } 
    if (d.hasExtension(ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED) || sd.hasExtension(ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED) ||  
        d.hasExtension(ExtensionDefinitions.EXT_XML_NAME, ExtensionDefinitions.EXT_XML_NAME_DEPRECATED) || sd.hasExtension(ExtensionDefinitions.EXT_XML_NAME, ExtensionDefinitions.EXT_XML_NAME_DEPRECATED) || 
        d.hasRepresentation()) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_XML_FORM), null, strikethrough, describeXml(sd, d, root));           
    } 
 
    if (d.hasExtension(ExtensionDefinitions.EXT_IMPLIED_PREFIX)) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_STRING_FORM), null, strikethrough).codeWithText(context.formatPhrase(RenderingContext.STRUC_DEF_ELE_READ)+" ", ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_IMPLIED_PREFIX), context.formatPhrase(RenderingContext.STRUC_DEF_PREFIXED));                 
    } 
 
    if (d.hasExtension(ExtensionDefinitions.EXT_STANDARDS_STATUS)) { 
      StandardsStatus ss = StandardsStatus.fromCode(d.getExtensionString(ExtensionDefinitions.EXT_STANDARDS_STATUS)); 
      //      gc.addStyledText("Standards Status = "+ss.toDisplay(), ss.getAbbrev(), "black", ss.getColor(), baseSpecUrl()+, true); 
      StructureDefinition sdb = context.getProfileUtilities().findProfile(sd.getBaseDefinition(), sd);
      if (sdb != null) { 
        StandardsStatus base = determineStandardsStatus(sdb, (ElementDefinition) d.getUserData(UserDataNames.SNAPSHOT_DERIVATION_POINTER)); 
        if (base != null) { 
          tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_STAND_STAT), "versions.html#std-process", strikethrough, ss.toDisplay()+" (from "+base.toDisplay()+")"); 
        } else { 
          tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_STAND_STAT), "versions.html#std-process", strikethrough, ss.toDisplay());           
        } 
      } else { 
        tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_STAND_STAT), "versions.html#std-process", strikethrough, ss.toDisplay()); 
      } 
    } 
    if (mode != GEN_MODE_DIFF && d.hasIsSummary()) { 
      tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_SUMM), "search.html#summary", strikethrough, Boolean.toString(d.getIsSummary())); 
    } 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_REQUIREMENTS), null, strikethrough, compareMarkdown(sd.getName(), d.getRequirementsElement(), (compare==null) || slicedExtension ? null : compare.getRequirementsElement(), mode)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_LABEL), null, strikethrough, compareString(d.getLabel(), d.getLabelElement(), null, "label", d, (compare != null ? compare.getLabel() : null), null, mode, false, false));    
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_ALT_NAME), null, strikethrough, compareSimpleTypeLists(d.getAlias(), ((compare==null) || slicedExtension ? null : compare.getAlias()), mode)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_DEF_CODES), null, strikethrough, compareDataTypeLists(d.getCode(), ((compare==null) || slicedExtension ? null : compare.getCode()), mode)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_MIN_VALUE), null, strikethrough, compareString(d.hasMinValue() ? encodeValue(d.getMinValue(), null) : null, d.getMinValue(), null, "minValue", d, compare!= null && compare.hasMinValue() ? encodeValue(compare.getMinValue(), null) : null, null, mode, false, false)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_MAX_VALUE), null, strikethrough, compareString(d.hasMaxValue() ? encodeValue(d.getMaxValue(), null) : null, d.getMaxValue(), null, "maxValue", d, compare!= null && compare.hasMaxValue() ? encodeValue(compare.getMaxValue(), null) : null, null, mode, false, false)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_MAX_LENGTH), null, strikethrough, compareString(d.hasMaxLength() ? toStr(d.getMaxLength()) : null, d.getMaxLengthElement(), null, "maxLength", d, compare!= null && compare.hasMaxLengthElement() ? toStr(compare.getMaxLength()) : null, null, mode, false, false)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_MIN_LENGTH), null, strikethrough, ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_MIN_LENGTH)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_VALUE_REQ), null, strikethrough, compareString(encodeValue(d.getMustHaveValueElement(), null), d.getMustHaveValueElement(), null, (compare != null ? encodeValue(compare.getMustHaveValueElement(), null) : null), d, null, "mustHaveValueElement", mode, false, false));    
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_VALUE_ALT), null, strikethrough, compareSimpleTypeLists(d.getValueAlternatives(), ((compare==null) || slicedExtension ? null : compare.getValueAlternatives()), mode)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_DEFAULT_VALUE), null, strikethrough, encodeValue(d.getDefaultValue(), "defaultValue", d, compare==null ? null : compare.getDefaultValue(), mode, d.getName())); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_MEAN_MISS), null, strikethrough, d.getMeaningWhenMissing()); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_FIXED), null, strikethrough, encodeValue(d.getFixed(), "fixed", d, compare==null ? null : compare.getFixed(), mode, d.getName())); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_PATT_VALUE), null, strikethrough, encodeValue(d.getPattern(), "pattern", d, compare==null ? null : compare.getPattern(), mode, d.getName())); 
    tableRow(tbl, context.formatPhrase(RenderingContext.GENERAL_EXAMPLE), null, strikethrough, encodeValues(d.getExample()));
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_INVAR), null, strikethrough, invariants(d.getConstraint(), compare==null ? null : compare.getConstraint(), d, mode));
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_LOINC), null, strikethrough, getMapping(sd, d, LOINC_MAPPING, compare, mode)); 
    tableRow(tbl, context.formatPhrase(RenderingContext.STRUC_DEF_SNOMED), null, strikethrough, getMapping(sd, d, SNOMED_MAPPING, compare, mode)); 
    tbl.tx("\r\n"); 
  } 
   
  private XhtmlNode renderTypeParameter(Extension ext) {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div"); 
    x.tx(ext.getExtensionString("name"));
    x.tx(" : ");
    String t = ext.getExtensionString("type");
    StructureDefinition sd = context.getContext().fetchTypeDefinition(t);
    if (sd == null) {
      x.code().tx(t);
    } else {
      x.ah(context.prefixLocalHref(sd.getWebPath()), t).tx(sd.present());
    }
    return x;
  }

  private XhtmlNode presentModifier(ElementDefinition d, int mode, ElementDefinition compare) throws FHIRException, IOException { 
    XhtmlNode x1 = compareString(encodeValue(d.getIsModifierElement(), null), d.getIsModifierElement(), null, "isModifier", d, compare == null ? null : encodeValue(compare.getIsModifierElement(), null), null, mode, false, false); 
    if (x1 != null) { 
      XhtmlNode x2 = compareString(encodeValue(d.getIsModifierReasonElement(), null), d.getIsModifierReasonElement(), null, "isModifierReason", d, compare == null ? null : encodeValue(compare.getIsModifierReasonElement(), null), null, mode, false, false); 
      if (x2 != null) { 
        x1.tx(" "+(context.formatPhrase(RenderingContext.STRUC_DEF_BECAUSE)+" ")); 
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
          ret.tx(context.formatPhrase(RenderingContext.STRUC_DEF_CDA)); 
          break; 
        case TYPEATTR: 
          ret.codeWithText((context.formatPhrase(RenderingContext.STRUC_DEF_XSI)+" "), "xsi:type", "attribute."); 
          break; 
        case XHTML: 
          ret.tx(context.formatPhrase(RenderingContext.STRUC_DEF_XHTML)); 
          break; 
        case XMLATTR: 
          ret.tx(context.formatPhrase(RenderingContext.STRUC_DEF_XML_ATTRIBUTE)); 
          break; 
        case XMLTEXT: 
          ret.tx(context.formatPhrase(RenderingContext.STRUC_DEF_UNADORNED)); 
          break; 
        default: 
        } 
      } 
    } 
    String name = ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED); 
    if (name == null && root) { 
      name = ExtensionUtilities.readStringExtension(profile, ExtensionDefinitions.EXT_XML_NAMESPACE, ExtensionDefinitions.EXT_XML_NAMESPACE_DEPRECATED); 
    } 
    if (name != null) { 
      ret.codeWithText(context.formatPhrase(RenderingContext.STRUC_DEF_NAMESPACE)+" ", name, "."); 
    } 
    name = ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_XML_NAME, ExtensionDefinitions.EXT_XML_NAME_DEPRECATED); 
    if (name != null) { 
      ret.codeWithText(context.formatPhrase(RenderingContext.STRUC_DEF_XML_ACTUAL), name, "."); 
    } 
    return ret; 
  } 
 
  private XhtmlNode describeJson(ElementDefinition d) { 
    XhtmlNode ret = new XhtmlNode(NodeType.Element, "div"); 
    var ul = ret.ul(); 
    boolean list = ExtensionUtilities.countExtensions(d, ExtensionDefinitions.EXT_JSON_EMPTY, ExtensionDefinitions.EXT_JSON_PROP_KEY, ExtensionDefinitions.EXT_JSON_NULLABLE, ExtensionDefinitions.EXT_JSON_NAME, ExtensionDefinitions.EXT_JSON_NAME_DEPRECATED) > 1;
 
    String code = ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_JSON_EMPTY); 
    if (code != null) { 
      switch (code) { 
      case "present": 
        ul.li().tx(context.formatPhrase(RenderingContext.STRUC_DEF_JSON_PRESENT)); 
        break; 
      case "absent": 
        ul.li().tx(context.formatPhrase(RenderingContext.STRUC_DEF_JSON_NOT_PRESENT)); 
        break; 
      case "either": 
        ul.li().tx(context.formatPhrase(RenderingContext.STRUC_DEF_JSON_MAY_PRESENT)); 
        break; 
      } 
    } 
    String jn = ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_JSON_NAME, ExtensionDefinitions.EXT_JSON_NAME_DEPRECATED); 
    if (jn != null) { 
      if (d.getPath().contains(".")) { 
        ul.li().codeWithText(context.formatPhrase(RenderingContext.STRUC_DEF_JSON_PROPERTY_NAME), jn, null); 
      } else { 
        ul.li().codeWithText(context.formatPhrase(RenderingContext.STRUC_DEF_JSON_CAN_NAME), jn, " " + context.formatPhrase(RenderingContext.STRUC_DEF_JSON_EXT));           
      } 
    } 
    code = ExtensionUtilities.readStringExtension(d, ExtensionDefinitions.EXT_JSON_PROP_KEY); 
    if (code != null) { 
      ul.li().codeWithText(context.formatPhrase(RenderingContext.STRUC_DEF_JSON_SINGLE), code, " "+ context.formatPhrase(RenderingContext.STRUC_DEF_JSON_CHILD)); 
    } 
    if (ExtensionUtilities.readBoolExtension(d, ExtensionDefinitions.EXT_JSON_NULLABLE)) { 
      ul.li().tx(context.formatPhrase(RenderingContext.STRUC_DEF_NULL_JSON)); 
    } 
    if (ExtensionUtilities.readBoolExtension(d, ExtensionDefinitions.EXT_JSON_PRIMITIVE_CHOICE)) { 
      ul.li().tx(context.formatPhrase(RenderingContext.STRUC_DEF_INFERRED_JSON)); 
    } 
 
    switch (ul.getChildNodes().size()) { 
    case 0: return null; 
    case 1: return ul.getChildNodes().get(0); 
    default: return ret; 
    } 
  } 
 
  private XhtmlNode describeObligations(RenderingStatus status, ElementDefinition d, boolean root, StructureDefinition sdx, String defPath, String anchorPrefix, List<ElementDefinition> inScopeElements, ResourceWrapper res) throws IOException {
    XhtmlNode ret = new XhtmlNode(NodeType.Element, "div"); 
    ObligationsRenderer obr = new ObligationsRenderer(corePath, sdx, d.getPath(), context, hostMd, this, true); 
    obr.seeObligations(d.getExtensionsByUrl(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)); 
    obr.seeRootObligations(d.getId(), sdx.getExtensionsByUrl(ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)); 
    if (obr.hasObligations() || (root && (sdx.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_NEW, ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_OLD) || sdx.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_INHERITS_NEW, ExtensionDefinitions.EXT_OBLIGATION_INHERITS_OLD)))) {
      XhtmlNode ul = ret.ul(); 
      if (root) { 
        if (sdx.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_NEW, ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_OLD)) {
          ul.li().tx(context.formatPhrase(RenderingContext.STRUC_DEF_OBLIG_ADD));            
        }  
        for (Extension ext : sdx.getExtensionsByUrl(ExtensionDefinitions.EXT_OBLIGATION_INHERITS_NEW, ExtensionDefinitions.EXT_OBLIGATION_INHERITS_OLD)) {
          String iu = ext.getValue().primitiveValue(); 
          XhtmlNode bb = ul.li(); 
          bb.tx(context.formatPhrase(RenderingContext.STRUC_DEF_OBLIG_FROM)+" ");            
          StructureDefinition sd = context.getProfileUtilities().findProfile(iu, sdx);
          if (sd == null) {  
            bb.code().tx(iu);                      
          } else if (sd.hasWebPath()) {  
            bb.ah(context.prefixLocalHref(sd.getWebPath())).tx(sd.present()); 
          } else {  
            bb.ah(context.prefixLocalHref(iu)).tx(sd.present()); 
          }  
        }   
        if (ul.isEmpty()) { 
          ret.remove(ul); 
        } 
      } 
      if (obr.hasObligations()) { 
        XhtmlNode tbl = ret.table("grid", false).markGenerated(!context.forValidResource());
        obr.renderTable(status, res, tbl.getChildNodes(), true, defPath, anchorPrefix, inScopeElements);
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
    DataType au = ExtensionUtilities.getAllowedUnits(d); 
    if (au instanceof CanonicalType) { 
      String url = ((CanonicalType) au).asStringValue(); 
      ValueSet vs = context.getContext().findTxResource(ValueSet.class, url); 
      ret.tx(context.formatPhrase(RenderingContext.GENERAL_VALUESET)+" ");          
      genCT(ret, url, vs); 
      return ret; 
    } else if (au instanceof CodeableConcept) { 
      CodeableConcept cc = (CodeableConcept) au; 
      if (cc.getCoding().size() != 1) { 
        ret.tx(context.formatPhrase(RenderingContext.STRUC_DEF_ONE_OF)); 
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
      x.ah(context.prefixLocalHref(url)).tx(cr.present()); 
    } else { 
      x.ah(context.prefixLocalHref(cr.getWebPath())).tx(cr.present()); 
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
    if (ed != null && ed.hasExtension(ExtensionDefinitions.EXT_STANDARDS_STATUS)) { 
      return StandardsStatus.fromCode(ed.getExtensionString(ExtensionDefinitions.EXT_STANDARDS_STATUS)); 
    } 
    while (sd != null) { 
      if (sd.hasExtension(ExtensionDefinitions.EXT_STANDARDS_STATUS)) { 
        return ExtensionUtilities.getStandardsStatus(sd); 
      } 
      sd = context.getProfileUtilities().findProfile(sd.getBaseDefinition(), sd);
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
      return context.formatPhrase(RenderingContext.STRUC_DEF_ORDERED); 
    else 
      return context.formatPhrase(RenderingContext.STRUC_DEF_UNORDERED); 
  } 
   
  private void generateSlicing(XhtmlNode tbl, StructureDefinition profile, ElementDefinition ed, ElementDefinitionSlicingComponent slicing, ElementDefinition compare, int mode, boolean strikethrough) throws IOException { 
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div"); 
     
    x.codeWithText(context.formatPhrase(RenderingContext.STRUC_DEF_SET_SLICES)+" ", ed.getPath(), context.formatPhrase(RenderingContext.STRUC_DEF_SET_ARE)); 
    String newOrdered = sliceOrderString(slicing); 
    String oldOrdered = (compare==null || !compare.hasSlicing()) ? null : sliceOrderString(compare.getSlicing()); 
    compareString(x, newOrdered, slicing.getOrderedElement(), null, null, null, oldOrdered, null, mode, false, false); 
    x.tx(" "+context.formatPhrase(RenderingContext.STRUC_DEF_AND) + " "); 
    compareString(x, slicing.hasRules() ? slicing.getRules().getDisplay() : null, slicing.getRulesElement(), null, "rules", slicing, compare!=null && compare.hasSlicing() && compare.getSlicing().hasRules() ? compare.getSlicing().getRules().getDisplay() : null, null, mode, false, false); 
     
    if (slicing.hasDiscriminator()) { 
      x.tx(context.formatPhrase(RenderingContext.STRUC_DEF_DESCRIM)); 
      StatusList<DiscriminatorWithStatus> list = new StatusList<>(); 
      for (ElementDefinitionSlicingDiscriminatorComponent d : slicing.getDiscriminator()) { 
        list.add(new DiscriminatorWithStatus(d)); 
      } 
      if (compare != null) {       
        for (ElementDefinitionSlicingDiscriminatorComponent d : slicing.getDiscriminator()) { 
          list.merge(new DiscriminatorWithStatus(d)); 
        } 
      } 
      var ul = x.ul(); 
      for (DiscriminatorWithStatus rc : list) { 
        rc.render(x.li()); 
      } 
    } else { 
      x.tx(context.formatPhrase(RenderingContext.STRUC_DEF_NO_DESCRIM)); 
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
 
  private void tableRowLink(XhtmlNode x, String name, String defRef, boolean strikethrough, String text, String link) throws IOException { 
    if (!Utilities.noString(text)) { 
      var tr = x.tr(); 
      if (strikethrough) { 
        tr.style("text-decoration: line-through"); 
      } 
      addFirstCell(name, defRef, tr); 
      tr.td().ah(context.prefixLocalHref(link)).tx(text); 
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
      td.ah(context.prefixLocalHref(defRef)).tx(name); 
    } else { 
      td.ah(context.prefixLocalHref(corePath+defRef)).tx(name); 
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
      ret.tx(context.formatPhrase(RenderingContext.STRUC_DEF_BUSINESS_ID)+" "); 
      ret.ah(context.prefixLocalHref(corePath + "resource.html#identifiers")).tx(context.formatPhrase(RenderingContext.STRUC_DEF_DISCUSSION)); 
      ret.tx(")"); 
      return ret; 
    }  
    if (name.equals("version")) {// && !resource.equals("Device")) 
      XhtmlNode ret = new XhtmlNode(NodeType.Element, "div"); 
      ret.tx(context.formatPhrase(RenderingContext.STRUC_DEF_BUSINESS_VERID)+" "); 
      ret.ah(context.prefixLocalHref(corePath + "resource.html#versions")).tx(context.formatPhrase(RenderingContext.STRUC_DEF_DISCUSSION)); 
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
        compareString(x, toStr(d.getMin()), d.getMinElement(), null, "min", d, toStr(compare.getMin()), null, mode, false, false); 
      } 
      x.tx(".."); 
      if (!(mode==GEN_MODE_DIFF && (d.getMax().equals(compare.getMax()) || "1".equals(d.getMax())))) { 
        compareString(x, d.getMax(), d.getMaxElement(), null, "max", d, compare.getMax(), null, mode, false, false); 
      } 
    } 
    XhtmlNode t = compareSimpleTypeLists(d.getCondition(), compare == null ? null : compare.getCondition(), mode); 
    if (t != null) { 
      x.br(); 
      x.tx(context.formatPhrase(RenderingContext.STRUC_DEF_INVARIANT)+" ");  
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
        ret.tx(context.formatPhrase(RenderingContext.STRUC_DEF_CHOICE_OF)+" "); 
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
      x.tx(" "+context.formatPhrase(RenderingContext.STRUC_DEF_COMP_EX)); 
      return x; 
    case 3: 
      x = new XhtmlNode(NodeType.Element, "div"); 
      x.tx(" "+context.formatPhrase(RenderingContext.STRUC_DEF_EX_TYPE)+" "); 
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
      ts = compareString(x, t.getWorkingCode(), t, null, "code", t, compare==null ? null : compare.getWorkingCode(), null, mode, false, false); 
    } else { 
      ts = compareString(x, t.getWorkingCode(), t, getTypeLink(t, sd), "code", t, compare==null ? null : compare.getWorkingCode(), compare==null ? null : getTypeLink(compare, sd), mode, false, false); 
    } 
    if (t.hasExtension(ExtensionDefinitions.EXT_TYPE_PARAMETER)) {
      x.tx("<");
      boolean first = true;
      List<Extension> exl = t.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_PARAMETER);
      for (Extension ex : exl) {
        if (first) { first = false; } else { x.tx("; "); }
        if (exl.size() > 1) {
          x.tx(ex.getExtensionString("name"));
          x.tx(":");
        }
        String type = ex.getExtensionString("type");
        StructureDefinition psd = context.getContext().fetchTypeDefinition(type);
        if (psd == null) {
          x.code().tx(type);
        } else if (psd.getWebPath() == null) {
          x.ah(context.prefixLocalHref(type)).tx(type);
        } else {
          x.ah(context.prefixLocalHref(psd.getWebPath())).tx(type);          
        }
      }
      x.tx(">");
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
          a.setUserData(UserDataNames.render_link, corePath + "codesystem-resource-aggregation-mode.html#content"); 
        } 
        if (compare!=null) { 
          for (Enumeration<AggregationMode> a : compare.getAggregation()) { 
            a.setUserData(UserDataNames.render_link, corePath + "codesystem-resource-aggregation-mode.html#content"); 
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
      ResolvedCanonical rc = fetchProfile(pt, mustSupportOnly, null);
      profiles.add(rc); 
    } 
    if (oldProfiles!=null && mode != GEN_MODE_DIFF) { 
      for (CanonicalType pt : oldProfiles) { 
        profiles.merge(fetchProfile(pt, mustSupportOnly, null));
      } 
    } 
    return profiles; 
  } 
 
  private ResolvedCanonical fetchProfile(CanonicalType pt, boolean mustSupportOnly, StructureDefinition sd) {
    if (!pt.hasValue()) { 
      return null; 
    } 
    if (!mustSupportOnly || isMustSupport(pt)) { 
      StructureDefinition p = context.getProfileUtilities().findProfile(pt.getValue(), sd);
      return new ResolvedCanonical(pt.getValue(), p); 
    } else { 
      return null; 
    } 
  } 
// 
//  private String getTypeProfile(CanonicalType pt, boolean mustSupportOnly) { 
//    StringBuilder b = new StringBuilder(); 
//    if (!mustSupportOnly || isMustSupport(pt)) { 
//      StructureDefinition p = context.getProfileUtilities().findProfile(pt.getValue()); 
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
      x.ah(context.prefixLocalHref(s)).tx(t.getWorkingCode()); 
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
    return compareString(newValue, source, null, name, parent, oldValue, null, mode, false, false); 
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
          bindingDesc.addChildren(new XhtmlParser().parseMDFragment(hostMd.processMarkdown("Binding.description", newBinding))); 
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
      if (binding.hasExtension(ExtensionDefinitions.EXT_CONCEPT_DOMAIN)) { 
        x.tx(". "); 
        x.tx(context.formatPhrase(RenderingI18nContext.SDR_CONCEPT_DOMAIN));  
        x.tx(": ");  
        renderCoding(new RenderingStatus(), x, ResourceWrapper.forType(context.getContextUtilities(), binding.getExtensionByUrl(ExtensionDefinitions.EXT_CONCEPT_DOMAIN).getValue()));  
      }
 
      AdditionalBindingsRenderer abr = new AdditionalBindingsRenderer(context.getPkp(), corePath, sd, d.getPath(), context, hostMd, this); 
 
      if (binding.hasExtension(ExtensionDefinitions.EXT_MAX_VALUESET)) { 
        abr.seeMaxBinding(ExtensionUtilities.getExtension(binding, ExtensionDefinitions.EXT_MAX_VALUESET), compBinding==null ? null : ExtensionUtilities.getExtension(compBinding, ExtensionDefinitions.EXT_MAX_VALUESET), mode!=GEN_MODE_SNAP && mode!=GEN_MODE_MS); 
      } 
      if (binding.hasExtension(ExtensionDefinitions.EXT_MIN_VALUESET)) { 
        abr.seeMinBinding(ExtensionUtilities.getExtension(binding, ExtensionDefinitions.EXT_MIN_VALUESET), compBinding==null ? null : ExtensionUtilities.getExtension(compBinding, ExtensionDefinitions.EXT_MIN_VALUESET), mode!=GEN_MODE_SNAP && mode!=GEN_MODE_MS); 
      } 
      if (binding.hasExtension(ExtensionDefinitions.EXT_BINDING_ADDITIONAL)) { 
        abr.seeAdditionalBindings(binding.getExtensionsByUrl(ExtensionDefinitions.EXT_BINDING_ADDITIONAL), compBinding==null ? null : compBinding.getExtensionsByUrl(ExtensionDefinitions.EXT_BINDING_ADDITIONAL), mode!=GEN_MODE_SNAP && mode!=GEN_MODE_MS); 
      } 
 
      if (abr.hasBindings()) { 
        var tbl = x.table("grid", false).markGenerated(!context.forValidResource());
        abr.render(tbl.getChildNodes(), true); 
      } 
      return x; 
    } 
  } 
 
  private boolean isSimpleContent(XhtmlNode bindingDesc) { 
    return bindingDesc.getChildNodes().size() == 1 && bindingDesc.getChildNodes().get(0).isPara(); 
  } 
 
  private void renderBinding(XhtmlNode span, ElementDefinitionBindingComponent binding, ElementDefinitionBindingComponent compare, String path, StructureDefinition sd, int mode) { 
    compareString(span, conf(binding), binding.getStrengthElement(), null, "strength", binding, compare == null ? null : conf(compare), null, mode, false, false); 
    span.tx(" "); 
    BindingResolution br = context.getPkp().resolveBinding(sd, binding, path); 
    compareString(span, br.display, binding.getValueSetElement(), br.url, "valueSet", binding, compare == null ? null : compare.getValueSet(), null, mode, br.external, false); 
    if (binding.hasStrength() || binding.hasValueSet()) { 
      span.br(); 
      span.tx("("); 
      if (binding.hasStrength()) { 
        span.ah(context.prefixLocalHref(Utilities.pathURL(corePath, "terminologies.html#"+binding.getStrength().toCode()))).tx(binding.getStrength().toCode()); 
      } 
      if (binding.hasStrength() && binding.hasValueSet()) { 
        span.tx(" "); 
      } 
      if (binding.hasValueSet()) { 
        span.tx("to "); 
        XhtmlNode ispan = span.spanClss("copy-text-inline"); 
        ispan.code().tx(binding.getValueSet()); 
        ispan.button("btn-copy", context.formatPhrase(RenderingContext.STRUC_DEF_COPY_URL)).attribute("data-clipboard-text", binding.getValueSet()); 
      } 
      span.tx(")"); 
    } 
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
      return context.formatPhrase(RenderingContext.STRUC_DEF_FOR_CODE)+" "; 
    } 
    switch (def.getStrength()) { 
    case EXAMPLE: 
      return context.formatPhrase(RenderingContext.STRUC_DEF_EX_CODE)+" "; 
    case PREFERRED: 
      return context.formatPhrase(RenderingContext.STRUC_DEF_SHOULD_CODE)+" "; 
    case EXTENSIBLE: 
      return context.formatPhrase(RenderingContext.STRUC_DEF_SUIT_SHALL_CODE)+" "; 
    case REQUIRED: 
      return context.formatPhrase(RenderingContext.STRUC_DEF_SHALL_CODE)+" "; 
    default: 
      return "?sd-conf?"; 
    } 
  } 
 
  private XhtmlNode encodeValues(List<ElementDefinitionExampleComponent> examples) throws FHIRException, IOException {
    XhtmlNode x = null;
    for (ElementDefinitionExampleComponent ex : examples) {
      if (x == null)
        x = new XhtmlNode(NodeType.Element, "div");
      else 
        x.br();
      XhtmlNode b = x.b();
      b.tx(ex.getLabel());
      b.tx(": ");
      x.tx(encodeValue(ex.getValue(), null));
    }
    return x;
 
  } 
 
  private XhtmlNode encodeValue(DataType value, String name, Base parent, DataType compare, int mode, String elementName) throws FHIRException, IOException { 
    String oldValue = encodeValue(compare, elementName); 
    String newValue = encodeValue(value, elementName); 
    return compareString(newValue, value, null, name, parent, oldValue, null, mode, false, false, true); 
  } 
 
  private String encodeValue(DataType value, String elementName) throws FHIRException, IOException { 
    if (value == null || value.isEmpty()) { 
      return null; 
    } 
    if (value instanceof PrimitiveType<?> && (context.getFixedFormat().notPrimitives() || elementName == null)) { 
      return ((PrimitiveType<?>) value).asStringValue(); 
    } 
 
    ByteArrayOutputStream bs = new ByteArrayOutputStream(); 
    if (context.getFixedFormat().isXml()) { 
      XmlParser parser = new XmlParser(); 
      parser.setOutputStyle(OutputStyle.PRETTY); 
      parser.compose(bs, value, null); 
    } else if (value instanceof PrimitiveType<?>) { 
      if (value instanceof BooleanType || value instanceof IntegerType || value instanceof DecimalType) { 
        FileUtilities.stringToStream(((PrimitiveType<?>) value).asStringValue(), bs); 
      } else { 
        FileUtilities.stringToStream("\""+Utilities.escapeJson(((PrimitiveType<?>) value).asStringValue())+"\"", bs);         
      } 
    } else { 
      JsonParser parser = new JsonParser(); 
      parser.setOutputStyle(OutputStyle.PRETTY); 
      parser.compose(bs, value, null); 
    } 
    String[] lines = bs.toString().split("\\r?\\n"); 
    StringBuilder b = new StringBuilder(); 
    for (String s : lines) { 
      if (!Utilities.noString(s) && !s.startsWith("<?")) { // eliminate the xml header if it's xml 
        b.append(s.replace(" xmlns=\"http://hl7.org/fhir\"", "")); 
        b.append("\n"); 
      } 
    } 
    boolean prefixWithName = context.getFixedFormat() == FixedValueFormat.JSON_ALL && elementName != null; 
    if (elementName != null && elementName.contains("[x]")) { 
      elementName = elementName.replace("[x]", Utilities.capitalize(value.fhirType()));  
    } 
    return (prefixWithName ? "\""+Utilities.escapeXml(elementName)+"\" : " : "")+ b.toString().trim(); 
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
    if (Utilities.noString(newMap) && compare == null) {
      return null;
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
    if (Utilities.noString(newMap) && Utilities.noString(oldMap)) {
      return null;
    }
    return compareString(Utilities.escapeXml(newMap), null, null, "mapping", d, Utilities.escapeXml(oldMap), null, mode, false, false); 
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
        list.add(new DataValueWithStatus(v, this, new RenderingStatus()));
      } 
    } 
    if (compareList != null && mode != GEN_MODE_DIFF) { 
      for (DataType v : compareList) { 
        list.merge(new DataValueWithStatus(v, this, new RenderingStatus()));
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
      throw new FHIRException(context.formatPhrase(RenderingContext.STRUC_DEF_ERR_DESC)); 
    } 
  } 
 
  private String summarise(Coding coding) throws FHIRException { 
    if ("http://snomed.info/sct".equals(coding.getSystem())) 
      return "" + (context.formatPhrase(RenderingContext.STRUC_DEF_SNOMED_CODE)) + " " + coding.getCode() + (!coding.hasDisplay() ? "" : "(\"" + gt(coding.getDisplayElement()) + "\")"); 
    if ("http://loinc.org".equals(coding.getSystem())) 
      return "" + (context.formatPhrase(RenderingContext.STRUC_DEF_LOINC_CODE)) + " " + coding.getCode() + (!coding.hasDisplay() ? "" : "(\"" + gt(coding.getDisplayElement()) + "\")"); 
    if ("http://unitsofmeasure.org/".equals(coding.getSystem())) 
      return " (" + (context.formatPhrase(RenderingContext.GENERAL_UCUM)) + ": " + coding.getCode() + ")"; 
    CodeSystem cs = context.getContext().fetchCodeSystem(coding.getSystem()); 
    if (cs == null) 
      return "<span title=\"" + coding.getSystem() + "\">" + coding.getCode() + "</a>" + (!coding.hasDisplay() ? "" : "(\"" + gt(coding.getDisplayElement()) + "\")"); 
    else 
      return "<a title=\"" + cs.present() + "\" href=\"" + Utilities.escapeXml(cs.getWebPath()) + "#" + cs.getId() + "-" + coding.getCode() + "\">" + coding.getCode() + "</a>" + (!coding.hasDisplay() ? "" : "(\"" + gt(coding.getDisplayElement()) + "\")"); 
  } 
 
  public XhtmlNode buildElementTable(RenderingStatus status, String defFile, StructureDefinition profile, String imageFolder, boolean inlineGraphics, String profileBaseFileName, boolean snapshot, String corePath, String imagePath, 
      boolean logicalModel, boolean allInvariants, Set<String> outputTracker, boolean mustSupport, RenderingContext rc, String anchorPrefix, ResourceWrapper res) throws IOException {
    // in order to build this, we need to know the base type of the profile 
    ElementTableGroupingEngine groupings = getElementTableGroupings(profile.getType());
    if (groupings == null) {
      XhtmlNode node = new XhtmlNode(NodeType.Element, "div");
      node.para().tx("This view is not supported for this profile because it is of an unsupported type");
      return node;
    } else if (profile.getSnapshot().getElement().isEmpty()) {
      XhtmlNode node = new XhtmlNode(NodeType.Element, "div");
      node.para().tx("This view is not supported for this profile because it doesn't have a snapshot");
      return node;
    } else {
      List<ElementTable.TableGroup> groups = new ArrayList<ElementTable.TableGroup>();
      List<ElementDefinition> children = context.getProfileUtilities().getChildList(profile, profile.getSnapshot().getElementFirstRep());
      buildElementTableRows(profile, groupings, groups, children);
      
      HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, imageFolder, inlineGraphics, true, defFile, rc.getUniqueLocalPrefix());
      gen.setTreelines(false);
      TableModel model = initElementTable(gen, corePath, true, profile.getId()+"e", true, TableGenerationMode.XHTML);
      new ElementTable(context, groups, this, ExtensionUtilities.hasExtensionValue(profile, ExtensionDefinitions.EXT_PROFILE_VIEW_HINT, "element-view-replace-cardinality")).build(gen, model);
          
      try { 
        return gen.generate(model, imagePath, 0, outputTracker); 
      } catch (org.hl7.fhir.exceptions.FHIRException e) { 
        throw new FHIRException(context.getWorker().formatMessage(I18nConstants.ERROR_GENERATING_TABLE_FOR_PROFILE__, profile.getUrl(), e.getMessage()), e); 
      }
    }
  }

  private void buildElementTableRows(StructureDefinition profile, ElementTableGroupingEngine groupings, List<TableGroup> groups, List<ElementDefinition> elements) {
    for (ElementDefinition ed : elements) {
      ElementTableGroupingState state = groupings.groupState(ed);
      ElementTable.TableGroup group = getOrMakeGroup(groupings, groups, ed);
      if (group != null) {
        boolean isLeaf = isLeaf(ed);
        if (isLeaf) {
          if (hasAnyDiff(profile, ed) && !ed.isProhibited()) {
            group.getElements().add(makeElement(profile, null, ed, true));
          }
        } else if (state == ElementTableGroupingState.DEFINES_GROUP) {
          List<ElementDefinition> children = context.getProfileUtilities().getChildList(profile, ed);
          buildElementTableRows(profile, group, children, ed);             
        } else if (hasAnyDiff(profile, ed) && !ed.isProhibited()) {
          TableElement e = makeElement(profile, null, ed, false);
          group.getElements().add(e);
          List<ElementDefinition> children = context.getProfileUtilities().getChildList(profile, ed);
          buildElementTableRows(profile, e, children); 
        }
      } else if (!ed.isProhibited()) {
        // walk the children without creating anything. Will only do anything in a logical model 
        List<ElementDefinition> children = context.getProfileUtilities().getChildList(profile, ed);
        buildElementTableRows(profile, groupings, groups, children);
      }
    }          
  }


  private void buildElementTableRows(StructureDefinition profile, ElementTable.TableGroup group, List<ElementDefinition> elements, ElementDefinition parent) {
    for (ElementDefinition ed : elements) {
      if (hasAnyDiff(profile, ed) && !ed.isProhibited()) {
        boolean isLeaf = isLeaf(ed);
        if (isLeaf) {
          if (useParent(ed) ) {
            group.getElements().add(makeElement(profile, parent, ed, true));
          } else {
            group.getElements().add(makeElement(profile, null, ed, true));
          }
        } else {
          List<ElementDefinition> children = context.getProfileUtilities().getChildList(profile, ed);
          buildElementTableRows(profile, group, children, ed);  
        }
      }
    }          
  }


  private boolean useParent(ElementDefinition ed) {
    for (TypeRefComponent t : ed.getType()) {
      StructureDefinition sd = context.getContext().fetchTypeDefinition(t.getWorkingCode());
      if (sd != null && sd.hasExtension(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT)) {
        for (Extension ext : sd.getExtensionsByUrl(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT)) {
          if (ext.hasValue()) {
            String v = ext.getValue().primitiveValue();
            if ("element-view-defns-parent".equals(v)) {
              return true;
            }
          }
        }
      }
    }
    return true;
  }

  private void buildElementTableRows(StructureDefinition profile, TableElement parent, List<ElementDefinition> elements) {
    for (ElementDefinition ed : elements) {
      if (hasAnyDiff(profile, ed) && !ed.isProhibited()) {
        boolean isLeaf = isLeaf(ed);
        if (isLeaf) {
          parent.getChildElements().add(makeElement(profile, null, ed, true));
        } else {
          TableElement e = makeElement(profile, null, ed, false);
          parent.getChildElements().add(e);
          List<ElementDefinition> children = context.getProfileUtilities().getChildList(profile, ed);
          buildElementTableRows(profile, e, children);  
        }
      }
    }          
  }

  private boolean isLeaf(ElementDefinition element) {
    for (TypeRefComponent t : element.getType()) {
      if (context.getContextUtilities().isDatatype(t.getWorkingCode()) && !Utilities.existsInList(t.getWorkingCode(), "Element", "BackboneElement")) {
        return true;
      }
      StructureDefinition sd = context.getContext().fetchTypeDefinition(t.getWorkingCode());
      if (sd != null && sd.hasExtension(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT)) {
        for (Extension ext : sd.getExtensionsByUrl(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT)) {
          if (ext.hasValue()) {
            String v = ext.getValue().primitiveValue();
            if ("element-view-as-leaf".equals(v)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  private boolean hasAnyDiff(StructureDefinition profile, ElementDefinition e) {
    if (e.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_DIFF)) {
      ElementDefinition diff = (ElementDefinition) e.getUserData(UserDataNames.SNAPSHOT_DERIVATION_DIFF);
      return hasDefinitionalMaterial(diff);
    }
    for (ElementDefinition child : context.getProfileUtilities().getChildList(profile, e.getPath(), e.getId(), false, false)) {
      if (hasAnyDiff(profile, child)) {
        return true;
      }
    }
    return false;
  }

  private boolean hasDefinitionalMaterial(ElementDefinition diff) {
    return diff.hasShort() || diff.hasDefinition() || diff.hasComment() || diff.hasRequirements() || 
        diff.hasBinding() || diff.hasFixed() || diff.hasPattern() || diff.hasMin() || diff.hasMax() ||
        diff.hasMinValue() || diff.hasMaxValue() || diff.hasConstraint() || diff.hasType() || diff.hasMaxLength();
  }

  private ElementTableGroupingEngine getElementTableGroupings(String type) throws JsonException, IOException {
    StructureDefinition sd = context.getContext().fetchTypeDefinition(type);
    if (sd == null) {
      return null;
    }
    if (sd.hasExtension(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT) && "element-view-ready".equals(ExtensionUtilities.readStringExtension(sd, ExtensionDefinitions.EXT_PROFILE_VIEW_HINT))) {
      return new HintDrivenGroupingEngine(context.getProfileUtilities().getChildList(sd, sd.getSnapshot().getElementFirstRep()));
    }
    if (resourceGroupings == null) {
      byte[] cnt = context.getContext().getBinaryForKey("resource-groupings.json");
       if (cnt != null) {
         resourceGroupings = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(cnt, true);
       }
    }
    if (resourceGroupings != null && resourceGroupings.has(type)) {
      return new JsonDrivenGroupingEngine(resourceGroupings.getJsonArray(type));
    } else {
      return null;
    }
  }

  private TableGroup getOrMakeGroup(ElementTableGroupingEngine groupings, List<TableGroup> groups, ElementDefinition element) {
    ElementTableGrouping grouping = groupings.getGroup(element);
    if (grouping == null) {
      return null;
    }
    for (TableGroup g : groups) {
      if (g.getDefinition().getKey() == grouping.getKey()) {
        return g;
      }
    }
    TableGroup g = new TableGroup(groups.size()+1, grouping);
    groups.add(g);
    return g;
  }
  
  private TableElement makeElement(StructureDefinition profile, ElementDefinition parentDefn, ElementDefinition snapDefn, boolean lookAtChildren) {
    ElementDefinition working = parentDefn != null ? parentDefn : snapDefn;
    ElementDefinition diffDefn = (ElementDefinition) snapDefn.getUserData(UserDataNames.SNAPSHOT_DERIVATION_DIFF);
    ElementDefinition diffParentDefn = parentDefn == null ? null : (ElementDefinition) parentDefn.getUserData(UserDataNames.SNAPSHOT_DERIVATION_DIFF);
    ElementDefinition workingDiff = diffParentDefn != null ? diffParentDefn : diffDefn;
    
    
    TableElement e = new TableElement(working.getPath(), working.getShort(), Integer.toString(working.getMin()), working.getMax());
    
    if (snapDefn.getType().size() > 1) {
      List<String> list = new ArrayList<String>();
      for (TypeRefComponent tr : snapDefn.getType()) {
        StructureDefinition sd = context.getContext().fetchTypeDefinition(tr.getWorkingCode());
        list.add(sd == null ? tr.getWorkingCode() : sd.present());
      }
      e.setType("Choice", null, "Choice of "+CommaSeparatedStringBuilder.join(",", list), "icon_choice.gif");     
      e.getConstraints().add(TableElementConstraint.makeTypes(TableElementConstraintType.CHOICE, null, snapDefn.getType(), profile));
    } else {
      StructureDefinition sd = context.getContext().fetchTypeDefinition(snapDefn.getTypeFirstRep().getWorkingCode());
      if (sd == null) {
        e.setType(snapDefn.getTypeFirstRep().getWorkingCode(), null, "Unknown Type", "icon_element.gif");        
      } else if (Utilities.existsInList(sd.getType(), "Element", "BackboneElement")) {
        e.setType("Group", sd.getWebPath(), sd.present(), chooseIcon(profile, snapDefn, snapDefn.getTypeFirstRep()));
      } else {
        e.setType(sd.present(), sd.getWebPath(), sd.present(), chooseIcon(profile, snapDefn, snapDefn.getTypeFirstRep()));
      }
      if (snapDefn.getTypeFirstRep().hasProfile()) {
        e.getConstraints().add(TableElementConstraint.makeList(TableElementConstraintType.PROFILE, null, snapDefn.getTypeFirstRep().getProfile(), profile));
      }
      if (snapDefn.getTypeFirstRep().hasTargetProfile()) {
        e.getConstraints().add(TableElementConstraint.makeList(TableElementConstraintType.TARGET, null, snapDefn.getTypeFirstRep().getTargetProfile(), profile));
      }
    }

    if (working.hasDefinition()) {
      e.getDefinitions().add(new TableElementDefinition(TableElementDefinitionType.DEFINITION, working.getDefinition()));
    } else if (snapDefn.hasDefinition()) {
      e.getDefinitions().add(new TableElementDefinition(TableElementDefinitionType.DEFINITION, snapDefn.getDefinition()));
    } 
    if (workingDiff != null && workingDiff.hasComment()) {
      e.getDefinitions().add(new TableElementDefinition(TableElementDefinitionType.COMMENT, workingDiff.getComment()));
    } else if (diffDefn != null && diffDefn.hasComment()) {
      e.getDefinitions().add(new TableElementDefinition(TableElementDefinitionType.COMMENT, diffDefn.getComment()));
    }
    if (workingDiff != null && workingDiff.hasRequirements()) {
      e.getDefinitions().add(new TableElementDefinition(TableElementDefinitionType.REQUIREMENTS, workingDiff.getRequirements()));
    } else if (diffDefn != null && diffDefn.hasRequirements()) {
      e.getDefinitions().add(new TableElementDefinition(TableElementDefinitionType.REQUIREMENTS, diffDefn.getRequirements()));
    }
    
    checkValueDomainConstraints(snapDefn, diffDefn, null, e, false, profile);
    if (lookAtChildren) {
      List<ElementDefinition> children = context.getProfileUtilities().getChildList(profile, snapDefn);
      for (ElementDefinition child : children) {
        checkValueDomainConstraints(child, (ElementDefinition) child.getUserData(UserDataNames.SNAPSHOT_DERIVATION_DIFF), child.getName(), e, true, profile);
      }
    }
    return e;
  }

  public void checkValueDomainConstraints(ElementDefinition defn, ElementDefinition diffDefn, String path, TableElement e, boolean cardinality, StructureDefinition sd) {
    if (cardinality) {
      if (defn.getBase().getMin() != defn.getMin() || !defn.getBase().getMax().equals(defn.getMax())) {
        e.getConstraints().add(TableElementConstraint.makeRange(TableElementConstraintType.CARDINALITY, path, defn.getMinElement(), defn.getMaxElement(), sd));
      }
    }
    // ok, now we collect constraints on the value domain, which maybe in sub-elements, though at some point we give up 
    if (defn.hasFixed()) {
      e.getConstraints().add(TableElementConstraint.makeValueVS(TableElementConstraintType.FIXED, path, defn.getFixed(), defn.getBinding().getStrength(), defn.getBinding().getValueSet(), sd));
    }
    if (defn.hasPattern()) {
      e.getConstraints().add(TableElementConstraint.makeValueVS(TableElementConstraintType.PATTERN, path, defn.getPattern(), defn.getBinding().getStrength(), defn.getBinding().getValueSet(), sd));
    }
    if (defn.hasMinValue() || defn.hasMaxValue()) {
      e.getConstraints().add(TableElementConstraint.makeRange(TableElementConstraintType.RANGE, path, defn.getMinValue(), defn.getMaxValue(), sd));
    }
    if (defn.hasMaxLength()) {
      e.getConstraints().add(TableElementConstraint.makeValue(TableElementConstraintType.MAXLENGTH, path, defn.getMaxLengthElement(), sd));
    }
    if (defn.hasBinding() && defn.getBinding().hasValueSet() && (!cardinality || (diffDefn != null && diffDefn.hasBinding())) && !defn.hasFixedOrPattern()) {
      e.getConstraints().add(TableElementConstraint.makeBinding(TableElementConstraintType.BINDING, path, defn.getBinding().getStrength(), defn.getBinding().getValueSet(), sd));
    }
  }

  private String chooseIcon(StructureDefinition profile, ElementDefinition element, TypeRefComponent tr) {

    if (tail(element.getPath()).equals("extension") && isExtension(element)) { 
      if (element.hasType() && element.getType().get(0).hasProfile() && extensionIsComplex(element.getType().get(0).getProfile().get(0).getValue(), profile))
        return "icon_extension_complex.png"; 
      else 
        return "icon_extension_simple.png"; 
    } else if (tail(element.getPath()).equals("modifierExtension")) { 
      if (element.hasType() && element.getType().get(0).hasProfile() && extensionIsComplex(element.getType().get(0).getProfile().get(0).getValue(), profile))
        return "icon_modifier_extension_complex.png"; 
      else 
        return "icon_modifier_extension_simple.png"; 
    } else if (element.getType().size() == 0) { 
      if (profile != null && context.getWorker().getResourceNames().contains(profile.getType())) { 
        return "icon_resource.png"; 
      } else if (element.hasExtension(ExtensionDefinitions.EXT_JSON_PROP_KEY)) { 
        return "icon-object-box.png"; 
      } else { 
        return "icon_element.gif"; 
      } 
    } else if (element.getType().size() > 1) { 
      if (allAreReference(element.getType())) { 
        return "icon_reference.png"; 
      } else if (element.hasExtension(ExtensionDefinitions.EXT_JSON_PRIMITIVE_CHOICE)) { 
        return "icon_choice.gif"; 
      } else { 
        return "icon_choice.gif"; 
      } 
    } else if (element.getType().get(0).getWorkingCode() != null && element.getType().get(0).getWorkingCode().startsWith("@")) { 
      return "icon_reuse.png"; 
    } else if (context.getContext().isPrimitiveType(element.getType().get(0).getWorkingCode())) { 
      if (keyRows.contains(element.getId())) { 
        return "icon-key.png"; 
      } else { 
        return "icon_primitive.png"; 
      } 
    } else if (element.getType().get(0).hasTarget()) { 
      return "icon_reference.png"; 
    } else if (Utilities.existsInList(element.getType().get(0).getWorkingCode(), "Element", "BackboneElement")) { 
      return "icon_group.png"; 
    } else if (Utilities.existsInList(element.getType().get(0).getWorkingCode(), "Base", "Element", "BackboneElement")) { 
      return "icon_element.gif"; 
    } else if (context.getContext().isDataType(element.getType().get(0).getWorkingCode())) { 
      return "icon_datatype.gif"; 
    } else if (element.hasExtension(ExtensionDefinitions.EXT_JSON_PROP_KEY)) { 
      return "icon-object-box.png"; 
    } else { 
      return "icon_resource.png"; 
    } 
    
  }

  public MapStructureMode getMappingsMode() {
    return mappingsMode;
  }

  public void setMappingsMode(MapStructureMode mappingsMode) {
    this.mappingsMode = mappingsMode;
  }

  public List<StructureDefinition> getMappingTargets() {
    return mappingTargets;
  }
  
} 
