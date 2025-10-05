package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.ExpansionOptions;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.renderers.DataRenderer;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.ElementTable.HintDrivenGroupingEngine;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;


@MarkedToMoveToAdjunctPackage
public class ElementTable {

  public static class ElementTableGrouping {

    private long key;
    private String name;
    private int priority;

    public ElementTableGrouping(long key, String name, int priority) {
      this.key = key;
      this.name = name;
      this.priority = priority;
    }

    public String getName() {
      return name;
    }

    public int getPriority() {
      return priority;
    }

    public long getKey() {
      return key;
    }

  }
  public enum ElementTableGroupingState {
    UNKNOWN, DEFINES_GROUP, IN_GROUP
  }
  public static abstract class ElementTableGroupingEngine {

    public abstract ElementTableGroupingState groupState(ElementDefinition ed);
    public abstract ElementTableGrouping getGroup(ElementDefinition ed);
    

    protected boolean nameMatches(String name, List<String> strings) {
      for (String s : strings) {
        if (nameMatches(name, s)) {
          return true;
        }
      }
      return false;
    }
    
    public boolean nameMatches(String name, String test) {
      if (test.equals(name)) {
        return true;
      }
      if (test.endsWith("[x]") && name.startsWith(test.substring(0, test.length()-3))) {
        return true;
      }
      return false;
    }    
  }

  public static class JsonDrivenGroupingEngine extends ElementTableGroupingEngine {

    private JsonArray groups;
    
    public JsonDrivenGroupingEngine(JsonArray groups) {
      super();
      this.groups = groups;
    }
    
   public ElementTableGroupingState groupState(ElementDefinition ed) {
     String name = ed.getName();
      for (JsonObject o : groups.asJsonObjects()  ) {
        if (nameMatches(name, o.getStrings("elements"))) {
          return ElementTableGroupingState.IN_GROUP;
        }
      }
      for (JsonObject o : groups.asJsonObjects()  ) {
        if (o.asBoolean("all")) {
          return ElementTableGroupingState.IN_GROUP;
        }
      }
      return ElementTableGroupingState.UNKNOWN;
    }
    
    public ElementTableGrouping getGroup(ElementDefinition ed) {
      String name = ed.getName();
      int c = 0;
      for (JsonObject o : groups.asJsonObjects()  ) {
        c++;
        if (nameMatches(name, o.getStrings("elements"))) {
          return new ElementTableGrouping(c, o.asString("name"), groups.size() - c);
        }
      }
      c = 0;
      for (JsonObject o : groups.asJsonObjects()  ) {
        c++;
        if (o.asBoolean("all")) {
          return new ElementTableGrouping(c, o.asString("name"), groups.size() - c);
        }
      }
      return null;
    }
  }

  public static class HintDrivenGroupingEngine extends ElementTableGroupingEngine {

    private List<ElementDefinition> list;
    
    public HintDrivenGroupingEngine(List<ElementDefinition> list) {
      super();
      this.list = list;
    }
    
    public ElementTableGroupingState groupState(ElementDefinition ed) {
      if (ed.hasExtension(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT)) {
        List<Extension> exl = ed.getExtensionsByUrl(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT);
        for (Extension ex : exl) {
          if ("element-view-group".equals(ex.getExtensionString("name")) ) {
            return ElementTableGroupingState.DEFINES_GROUP;
          }
        }
      }
      return ElementTableGroupingState.UNKNOWN;
    }
    
    public ElementTableGrouping getGroup(ElementDefinition ed) {
      if (ed.hasExtension(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT)) {
        String n = null;
        int order = 0;
        List<Extension> exl = ed.getExtensionsByUrl(ExtensionDefinitions.EXT_PROFILE_VIEW_HINT);
        for (Extension ex : exl) {
          if ("element-view-group".equals(ex.getExtensionString("name")) ) {
            n = ex.getExtensionString("value");
          }
          if ("element-view-order".equals(ex.getExtensionString("name")) ) {
            order = ExtensionUtilities.readIntegerExtension(ex, "value", 0);
          }
        }
        if (n != null) {
          return new ElementTableGrouping(ed.getName().hashCode(), n, order);
        }
      }
      return null;
    }
  }

  
  public static enum TableElementDefinitionType {
    DEFINITION, COMMENT, REQUIREMENTS;
  } 
  
  public static class TableElementDefinition {
    private TableElementDefinitionType type;
    private String markdown;
    public TableElementDefinition(TableElementDefinitionType type, String markdown) {
      super();
      this.type = type;
      this.markdown = markdown;
    }
    public TableElementDefinitionType getType() {
      return type;
    }
    public String getMarkdown() {
      return markdown;
    }
    
  }
  
  public enum TableElementConstraintType {
    CHOICE, PROFILE, TARGET, BINDING, RANGE, FIXED, PATTERN, MAXLENGTH, CARDINALITY;
  }
  
  public static class TableElementConstraint {
    private TableElementConstraintType type;
    private DataType value;
    private DataType value2;
    private String path;
    private BindingStrength strength;
    private String valueSet;
    private List<TypeRefComponent> types;
    private List<CanonicalType> list;
    private Resource source;

    public static TableElementConstraint makeValue(TableElementConstraintType type, String path, DataType value, Resource source) {
      TableElementConstraint self = new TableElementConstraint();
      self.type = type;
      self.path = path;
      self.value = value;
      self.source = source;
      return self;
    }

    public static TableElementConstraint makeValueVS(TableElementConstraintType type, String path, DataType value, BindingStrength strength, String valueSet, Resource source) {
      TableElementConstraint self = new TableElementConstraint();
      self.type = type;
      self.path = path;
      self.value = value;
      self.strength = strength;
      self.valueSet = valueSet;
      self.source = source;
      return self;
    }

    public static TableElementConstraint makeRange(TableElementConstraintType type, String path, DataType value, DataType value2, Resource source) {
      TableElementConstraint self = new TableElementConstraint();
      self.type = type;
      self.path = path;
      self.value = value;
      self.value2 = value2;
      self.source = source;
      return self;
    }

    public static TableElementConstraint makeBinding(TableElementConstraintType type, String path, BindingStrength strength, String valueSet, Resource source) {
      TableElementConstraint self = new TableElementConstraint();
      self.type = type;
      self.path = path;
      self.strength = strength;
      self.valueSet = valueSet;
      self.source = source;
      return self;
    }

    public static TableElementConstraint makeTypes(TableElementConstraintType type, String path, List<TypeRefComponent> types, Resource source) {
      TableElementConstraint self = new TableElementConstraint();
      self.type = type;
      self.path = path;
      self.types = types;
      self.source = source;
      return self;
    }

    public static TableElementConstraint makeList(TableElementConstraintType type, String path, List<CanonicalType> list, Resource source) {
      TableElementConstraint self = new TableElementConstraint();
      self.type = type;
      self.path = path;
      self.list = list;
      self.source = source;
      return self;
    }

//    private BindingStrength strength;
//    private ValueSet vs;
//    private List<String> profiles;
//    private List<String> targetProfiles;
//    private DataType fixed;
//    private DataType pattern;
//    private DataType minValue;
//    private DataType maxValue;
  }
  

  public class ConstraintsSorter implements Comparator<TableElementConstraint> {

    @Override
    public int compare(TableElementConstraint o1, TableElementConstraint o2) {
      int r = StringUtils.compare(o1.path, o2.path);
      return r == 0 ? o1.type.compareTo(o2.type) : r;
    }
  }
  
  public static class TableElementInvariant {
    private String level;
    private String human;
    private String fhirPath;
    private String other;
    private String otherFormat;
  }
  
  public static class TableElement {
    // column 1
    private String path;
    private String name;
    private String min;
    private String max;
    private String typeName;
    private String typeIcon;
    private String typeLink;
    private String typeHint;
    
    // column 2
    private List<TableElementDefinition> definitions = new ArrayList<>();
    
    // column 3
    private List<TableElementConstraint> constraints = new ArrayList<>();
    
    private List<TableElementInvariant> invariants = new ArrayList<>();
    
    private List<TableElement> childElements = new ArrayList<ElementTable.TableElement>();

    public TableElement(String path, String name, String min, String max) {
      super();
      this.path = path;
      this.name = name;
      this.min = min;
      this.max = max;
    }

    public String getPath() {
      return path;
    }

    public String getName() {
      return name;
    }

    public String getMin() {
      return min;
    }

    public String getMax() {
      return max;
    }
    public String getTypeName() {
      return typeName;
    }
    public String getTypeIcon() {
      return typeIcon;
    }
    public String getTypeLink() {
      return typeLink;
    }
    public String getTypeHint() {
      return typeHint;
    }

    public List<TableElementDefinition> getDefinitions() {
      return definitions;
    }

    public List<TableElementConstraint> getConstraints() {
      return constraints;
    }

    public List<TableElementInvariant> getInvariants() {
      return invariants;
    }

    public List<TableElement> getChildElements() {
      return childElements;
    }

    public TableElement setPath(String path) {
      this.path = path;
      return this;
    }

    public TableElement setName(String name) {
      this.name = name;
      return this;
    }

    public TableElement setMin(String min) {
      this.min = min;
      return this;
    }

    public TableElement setMax(String max) {
      this.max = max;
      return this;
    }
    
    public void setType(String name, String link, String hint, String icon) {
      this.typeName = name;
      this.typeIcon = icon;
      this.typeLink = link;
      this.typeHint = hint;
    }
    
  }
  
  public static class TableGroup {
    private String name;
    private String documentation;
    private boolean buildIfEmpty;
    private String emptyNote;
    private List<TableElement> elements = new ArrayList<ElementTable.TableElement>();
    private int priorty;
    private int counter;
    private ElementTableGrouping definition;
    
    public TableGroup(int counter, ElementTableGrouping definition) {
      super();
      this.counter = counter;
      this.definition = definition;
      name = definition.getName();
      priorty = definition.getPriority();
      buildIfEmpty = false;            
    }

    public String getName() {
      return name;
    }

    public String getDocumentation() {
      return documentation;
    }

    public boolean isBuildIfEmpty() {
      return buildIfEmpty;
    }

    public String getEmptyNote() {
      return emptyNote;
    }

    public List<TableElement> getElements() {
      return elements;
    }

    public int getPriorty() {
      return priorty;
    }

    public int getCounter() {
      return counter;
    }

    public ElementTableGrouping getDefinition() {
      return definition;
    }
    
    
  }
  
  public static class TableGroupSorter implements Comparator<TableGroup> {

    @Override
    public int compare(TableGroup o1, TableGroup o2) {
      if (o1.priorty == o2.priorty) {
        return Integer.compare(o1.counter, o2.counter);        
      } else {
        return Integer.compare(o2.priorty, o1.priorty); // priorty sorts backwards
      }
    }
  }
  
  private RenderingContext context;
  private List<TableGroup> groups;
  private DataRenderer dr;
  private boolean replaceCardinality;
  
  public ElementTable(RenderingContext context, List<TableGroup> groups, DataRenderer dr, boolean replaceCardinality) {
    this.context = context;
    this.groups = groups;
    this.dr = dr;
    this.replaceCardinality = replaceCardinality;
  }

  public void build(HierarchicalTableGenerator gen, TableModel table) throws FHIRFormatError, DefinitionException, IOException {
    Collections.sort(groups, new TableGroupSorter());
    table.setBorder(true);
    table.setShowHeadings(false);

    
    for (TableGroup grp : groups) {
      if (grp.getElements().size() > 0 || grp.buildIfEmpty) {
        renderGroup(gen, table, grp);
      }
    }
    
  }

  private void renderGroup(HierarchicalTableGenerator gen, TableModel table, TableGroup grp) throws FHIRFormatError, DefinitionException, IOException {
    Row row = gen.new Row();
    table.getRows().add(row);
    Cell cell = gen.new Cell(null, null, grp.getName(), null, null);
    row.getCells().add(cell);
    cell.span(3);
    row.setColor("#dfdfdf");
    cell.addStyle("vertical-align: middle");
    cell.addStyle("font-weight: bold");
    cell.addStyle("font-size: 14px");
    cell.addStyle("padding-top: 10px");
    cell.addStyle("padding-bottom: 10px");

    boolean first = true;
    for (TableElement e : grp.elements) {
      renderElement(gen, row.getSubRows(), e, first);
      first = false;
    }
  }

  private void renderElement(HierarchicalTableGenerator gen, List<Row> rows, TableElement e, boolean first) throws FHIRFormatError, DefinitionException, IOException {
    Row row = gen.new Row();
    rows.add(row);
    if (!first) {
      row.setTopLine("silver");
    }
    renderElementIdentity(gen, row, e);
    renderElementDefinition(gen, row, e);
    renderElementConstraints(gen, row, e);

    
//    if (e.invariants.size() > 0) {
//      tr.style("border-bottom: none");
//      tr = table.tr();
//      tr.style("border-top: none");
//      tr.style("border-left: black 1px solid");
//      tr.style("border-right: black 1px solid");  
//      renderElementInvariants(tr.td().colspan(3), e);
//    } 
//    tr.style("border-bottom: silver 1px solid");
    
    for (TableElement child : e.getChildElements()) {
      renderElement(gen, row.getSubRows(), child, false);
    }
  }

  public void renderElementIdentity(HierarchicalTableGenerator gen, Row row, TableElement e) {
    Cell cell = gen.new Cell();
    cell.addCellStyle("min-width: 220px");
    row.getCells().add(cell);
    cell.setInnerTable(true);
    cell.addText(e.getName()).addStyle("font-weight: bold");
    cell.addPiece(gen.new Piece("br"));
    if (!replaceCardinality) {
      cell.addText("Cardinality: "+e.min+".."+e.max);  
    } else if ("1".equals(e.min) && "1".equals(e.max)) {
      cell.addText("Required");
    } else if ("0".equals(e.min) && "*".equals(e.max)) {
      cell.addText("Optional, Repeating");
    } else if ("0".equals(e.min) && "1".equals(e.max)) {
      cell.addText("Optional");
    } else if ("1".equals(e.min) && "*".equals(e.max)) {
      cell.addText("Repeating");
    } else {
      cell.addText("Cardinality: "+e.min+".."+e.max);      
    }
    cell.addPiece(gen.new Piece("br"));
    cell.addImg(e.getTypeIcon(), e.getTypeHint(), e.getTypeLink());
    cell.addPiece(gen.new Piece(e.getTypeLink(), " "+e.getTypeName(), e.getTypeHint()));      
  }

  public void renderElementConstraints(HierarchicalTableGenerator gen, Row row, TableElement e) throws FHIRFormatError, DefinitionException, IOException {
    Cell cell = gen.new Cell();
    cell.addCellStyle("min-width: 300px");
    row.getCells().add(cell);
    XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
    
    Collections.sort(e.getConstraints(), new ConstraintsSorter());
    boolean first = true;
    for (TableElementConstraint c : e.getConstraints()) {
      if (first) first= false; else div.br();
      switch (c.type) {
      case BINDING:
        renderBindingConstraint(div, c);
        break;
      case CHOICE:
        renderChoiceConstraint(div, c);
        break;
      case FIXED:
        renderValueConstraint(div, c);
        break;
      case MAXLENGTH:
        renderValueConstraint(div, c);
        break;
      case PATTERN:
        renderValueConstraint(div, c);
        break;
      case PROFILE:
        renderListConstraint(div, c);
        break;
      case RANGE:
        renderRangeConstraint(div, c);
        break;
      case TARGET:
        renderListConstraint(div, c);
        break;
      case CARDINALITY:
        renderCardinalityConstraint(div, c);
      break;
      default:
        break;
      
      }
    }
    cell.addXhtml(div);
  }

  private void renderBindingConstraint(XhtmlNode x, TableElementConstraint c) {
    String name = c.path == null ? "value" : c.path;
    x.code().tx(name);
    renderBinding(x, c, " is bound to ");
  }

  private void renderBinding(XhtmlNode x, TableElementConstraint c, String phrase) {
    ValueSet vs = context.getContext().findTxResource(ValueSet.class, c.valueSet, null, c.source);
    if (vs == null) {
      x.tx(phrase+"an unknown valueset ");
      x.code().tx(c.valueSet);      
    } else {
      x.tx(phrase);
      x.ah(vs.getWebPath()).tx(vs.present());
      try {      
        ValueSetExpansionOutcome exp = context.getContext().expandVS(ExpansionOptions.cacheNoHeirarchy().withLanguage(context.getLocale().getLanguage()), vs);
        if (!exp.isOk()) {
          x.span().attribute("title", exp.getError()).tx(" (??)");                  
        } else if (exp.getValueset().getExpansion().getContains().size() == 1000) {
          x.tx(" (>1000 codes)");                            
        } else if (exp.getValueset().getExpansion().getContains().size() > 6) {
          x.tx(" ("+exp.getValueset().getExpansion().getContains().size()+" codes)");                            
        } else {
          x.tx(".  Codes:");
          XhtmlNode ul = x.ul();
          for (ValueSetExpansionContainsComponent cc : exp.getValueset().getExpansion().getContains()) {

            String url = cc.hasSystem() && cc.hasCode() ? dr.getLinkForCode(cc.getSystem(), cc.getVersion(), cc.getCode(), c.source) : null;
            var li = ul.li();
            li.ahOrNot(url).tx(dr.displayCodeSource(cc.getSystem(), cc.getVersion())+": "+cc.getCode());
            if (cc.hasDisplay()) {
              li.tx(" \""+cc.getDisplay()+"\"");
            } 
          }
        }
      } catch (Exception e) {
        x.span().attribute("title", e.getMessage()).tx(" (??)");        
      }
    }
  }

  private void renderChoiceConstraint(XhtmlNode x, TableElementConstraint c) {
    String name = c.path == null ? "value" : c.path;
    x.code().tx(name);
    x.tx(" is a choice of:");
    var ul = x.ul();
    for (TypeRefComponent tr : c.types) {
      if (tr.hasProfile()) {
        for (CanonicalType ct : tr.getProfile()) {
          StructureDefinition sd = context.getContext().fetchTypeDefinition(ct.primitiveValue());
          if (sd == null || !sd.hasWebPath()) {
            ul.li().ah(ct.primitiveValue()).tx(ct.primitiveValue());
          } else {
            ul.li().ah(sd.getWebPath()).tx(sd.present());
          }
        }
      } else if (tr.hasTarget()) {
        StructureDefinition sd = context.getContext().fetchTypeDefinition(tr.getWorkingCode());
        var li = ul.li();
        li.ah(sd.getWebPath()).tx(sd.present());
        li.tx(" pointing to ");
        renderTypeList(x, tr.getTargetProfile());        
        
      } else {
        StructureDefinition sd = context.getContext().fetchTypeDefinition(tr.getWorkingCode());
        if (sd == null || !sd.hasWebPath()) {
          ul.li().code().tx(tr.getWorkingCode());
        } else {
          ul.li().ah(sd.getWebPath()).tx(sd.present());
        }
      }
    }
    
    
  }

  private void renderValueConstraint(XhtmlNode x, TableElementConstraint c) throws FHIRFormatError, DefinitionException, IOException {
    String name = c.path == null ? "value" : c.path;
    x.code().tx(name);
    switch (c.type) {
    case FIXED:
      x.tx(" is fixed to ");
      break;
    case MAXLENGTH:
      x.tx(" is limited  in length to ");

      break;
    case PATTERN:
      if (c.value.isPrimitive()) {
        x.tx(" is fixed to ");
      } else {
        x.tx(" must match ");
      }
      break;
    default:
      break;
    }
    renderValue(x, c.value, c.source);
    if (c.strength != null && c.valueSet != null) {
      renderBinding(x, c, " from ");
    }
  }

  public void renderValue(XhtmlNode x, DataType v, Resource source) throws IOException {
    if (v.isPrimitive()) {
      String s = v.primitiveValue();
      if (Utilities.isAbsoluteUrl(s)) {
        Resource res = context.getContext().fetchResource(Resource.class, s);
        if (res != null && res.hasWebPath()) {
          x.ah(res.getWebPath()).tx(res instanceof CanonicalResource ? ((CanonicalResource) res).present() : s);                    
        } else if (Utilities.isAbsoluteUrlLinkable(s)) {
          x.ah(s).code().tx(s);          
        } else {
          x.code().tx(s);
        }
      } else {
        x.code().tx(s);
      }
    } else if (v instanceof Quantity) {
      genQuantity(x, (Quantity) v, source);
    } else if (v instanceof Coding) {
      genCoding(x, (Coding) v, source);
    } else if (v instanceof CodeableConcept) {
      genCodeableConcept(x, (CodeableConcept) v, source);
    } else {
      dr.renderBase(new RenderingStatus(), x, v);
    }
  }

  private void genCodeableConcept(XhtmlNode div, CodeableConcept cc, Resource source) {
    boolean first = true;
    for (Coding c : cc.getCoding()) {
      if (first) first = false; else div.tx(",");
      genCoding(div, c, source);
    }
    if (cc.hasText()) {
      div.code().tx(" \""+cc.getText()+"\"");      
    }
    
  }

  public void genQuantity(XhtmlNode div, Quantity q, Resource source) {
    String url = q.hasSystem() && q.hasUnit() ? dr.getLinkForCode(q.getSystem(), null, q.getCode(), source) : null;
    var code = div.code();
    if (q.hasComparator()) {
      code.tx(q.getComparator().toCode());
    }
    code.tx(q.getValueElement().asStringValue());
    code.ahOrNot(url).tx(q.getUnit());
  }

  public void genCoding(XhtmlNode div, Coding c, Resource source) {
    String url = c.hasSystem() && c.hasCode() ? dr.getLinkForCode(c.getSystem(), c.getVersion(), c.getCode(), source) : null;
    var code = div.code();
    code.ahOrNot(url).tx(dr.displayCodeSource(c.getSystem(), c.getVersion())+": "+c.getCode());
    if (c.hasDisplay()) {
      code.tx(" \""+c.getDisplay()+"\"");
    } else {
      String s = dr.lookupCode(c.getSystem(), c.getVersion(), c.getCode());
      if (s != null) {
        div.span().style("opacity: 0.5").tx("(\""+s+"\")");
      }
    }
  }

  private void renderRangeConstraint(XhtmlNode x, TableElementConstraint c) throws IOException {
    String name = c.path == null ? "value" : c.path;
    if (c.value != null && c.value2 != null) {
      x.tx(name + " between ");
      renderValue(x, c.value, c.source);
      x.tx(" and " );
      renderValue(x, c.value2, c.source);
    } else if (c.value != null) {
      x.tx(name + " more than ");
      renderValue(x, c.value, c.source);
    } else  {
      x.tx(name + " less than ");
      renderValue(x, c.value2, c.source);
    }
  }

  private void renderCardinalityConstraint(XhtmlNode x, TableElementConstraint c) throws IOException {
    String name = c.path == null ? "value" : c.path;
    x.code().tx(name);
    String min = c.value.primitiveValue();
    String max = c.value2.primitiveValue(); 
    if (!replaceCardinality) {
      x.tx("has cardinality: "+min+".."+max);  
    } else if ("1".equals(min) && "1".equals(max)) {
      x.tx("is required");
    } else if ("0".equals(min) && "*".equals(max)) {
      x.tx("is Optional and repeats");
    } else if ("0".equals(min) && "1".equals(max)) {
      x.tx("is Optional");
    } else if ("1".equals(min) && "*".equals(max)) {
      x.tx("repeats");
    } else {
      x.tx("has cardinality: "+min+".."+max);      
    }
  }

  private void renderListConstraint(XhtmlNode x, TableElementConstraint c) {
    String name = c.path == null ? "value" : c.path;

    x.code().tx(name);
    switch (c.type) {
    case PROFILE:
      x.tx(" must be ");
      break;
    case TARGET:
      x.tx(" must point to ");
      break;
    default:
      break;
    }
    renderTypeList(x, c.list);
  }

  private void renderTypeList(XhtmlNode x, List<CanonicalType> list) {

    if (list.size() == 1) {
      x.tx("a ");
    } else {
      x.tx("one of ");
    }
    boolean first = true;
    for (int i = 0; i < list.size(); i++) {
      if (first) {
        first = false;
      } else if (i == list.size() - 1) {
        x.tx(" or " );
      } else {
        x.tx(", ");
      }
      String s = list.get(i).primitiveValue();
      Resource res = context.getContext().fetchResource(Resource.class, s);
      if (res != null && res.hasWebPath()) {
        x.ah(res.getWebPath()).tx(res instanceof CanonicalResource ? ((CanonicalResource) res).present() : s);
      } else {
        x.ah(s).tx(s);
      }
    }    
  }

  public void renderElementDefinition(HierarchicalTableGenerator gen, Row row, TableElement e) {
    Cell cell = gen.new Cell();    row.getCells().add(cell);
    for (TableElementDefinition d : e.definitions) {
      if (d.getType() == TableElementDefinitionType.DEFINITION) {
        cell.addMarkdown(d.getMarkdown());
      } else if (d.getType() == TableElementDefinitionType.COMMENT) {
        cell.addMarkdown("Comment: "+d.getMarkdown(), "font-style: italic");
      }
    }
  }

  private void renderElementInvariants(XhtmlNode td, TableElement e) {
    XhtmlNode ul = td.ul();
    for (TableElementInvariant t : e.invariants) {
      var li = ul.li();
      li.tx(t.level+": "+t.human);
      li.tx(" ");
      li.code().tx(t.other != null ? t.other : t.fhirPath);
    }
  
  }

}
