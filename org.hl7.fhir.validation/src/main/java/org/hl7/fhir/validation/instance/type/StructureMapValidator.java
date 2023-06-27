package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode;
import org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode;
import org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode;
import org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.ConceptMapUtilities;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.structuremap.ResolvedGroup;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class StructureMapValidator extends BaseValidator {

  public class ElementDefinitionSource {
    private StructureDefinition sd;
    private ElementDefinition ed;
    protected ElementDefinitionSource(StructureDefinition sd, ElementDefinition ed) {
      super();
      this.sd = sd;
      this.ed = ed;
    }
    public StructureDefinition getSd() {
      return sd;
    }
    public ElementDefinition getEd() {
      return ed;
    }
    
  }

  public class RuleInformation {

    int maxCount = 1;
    String defVariable;
    
    public void seeCardinality(int max) {
      if (max == Integer.MAX_VALUE || maxCount == Integer.MAX_VALUE) {
        maxCount = Integer.MAX_VALUE;
      } else {
        maxCount = maxCount * max;
      }      
    }

    public boolean isList() {
      return maxCount > 1;
    }

    public int getMaxCount() {
      return maxCount;
    }

    public String getDefVariable() {
      return defVariable;
    }

    public void setDefVariable(String defVariable) {
      this.defVariable = defVariable;
    }
  }

  public class VariableDefn {

    private String name;
    private String mode;
    private int max;
    private StructureDefinition sd;
    private ElementDefinition ed;
    private String type;
    
    
    protected VariableDefn(String name, String mode) {
      super();
      this.name = name;
      this.mode = mode;
    }

    public VariableDefn setType(int max, StructureDefinition sd, ElementDefinition ed, String type) {
      this.max = max;
      this.sd = sd;
      this.ed = ed;
      this.type = type;
      return this;
    }

    public String getName() {
      return name;
    }

    public String getMode() {
      return mode;
    }

    public VariableDefn copy() {
      VariableDefn n = new VariableDefn(name, mode);
      n.max = max;
      n.sd = sd;
      n.ed = ed;
      n.type = type;
      return n;
    }

    public boolean hasTypeInfo() {
      return sd != null;
    }

    public int getMax() {
      return max;
    }

    public StructureDefinition getSd() {
      return sd;
    }

    public ElementDefinition getEd() {
      return ed;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getWorkingType() {
      if (type != null) {
        if (ed != null) {
          for (TypeRefComponent td : ed.getType()) {
            StructureDefinition sd = context.fetchTypeDefinition(td.getWorkingCode());
            if (sd != null && sd.getType().equals(type)) {
              return td.getWorkingCode();
            }
          }
        }
        return type;
      }
      if (ed != null) {
        if (!ed.getPath().contains(".")) {
          return ed.getPath();
        } else if (isAbstractType(ed.getType())) {
          return sd.getUrl()+"#"+ed.getPath();
        } else if (ed.getType().size() == 1) {
          return ed.getType().get(0).getWorkingCode();
        }
      }
      return null;
    }

    public String summary() {
      return mode+" "+getWorkingType()+" "+name;
    }

    public boolean matches(VariableDefn other) {
      if (!(name.equals(other.name) && mode.equals(other.mode))) {
        return false;
      }
      if (sd == null && other.sd == null) {
        return true;
      } else if (sd == null || other.sd == null) {
        return false;
      }
      return sd.getUrl().equals(other.sd.getUrl()) && ed.getPath().equals(other.ed.getPath()) && Utilities.stringsEqual(type, other.type);
    }

    @Override
    public String toString() {
      return summary();
    }

  }

  public class VariableSet {

    private List<VariableDefn> list = new ArrayList<>();
    
    public boolean hasVariable(String name) {
      for (VariableDefn v : list) {
        if (name.equals(v.getName())) {
          return true;
        }
      }
      return false;
    }

    public boolean hasVariable(String name, boolean source) {
      for (VariableDefn v : list) {
        if (name.equals(v.getName()) && source == ("source".equals(v.getMode()))) {
          return true;
        }
      }
      return false;
    }

    public VariableDefn add(String name, String mode) {
      list.removeIf(item -> item.getName().equals(name) && item.getMode().equals(mode));
      VariableDefn v = new VariableDefn(name, mode);
      list.add(v);
      return v;
    }
//
//    public void add(VariableDefn v) {
//      list.removeIf(item -> item.getName().equals(v.getName()) && item.getMode().equals(v.getMode()));
//      list.add(v);      
//    }
//    
    public VariableSet copy() {
      VariableSet set = new VariableSet();
      for (VariableDefn v : list) {
        set.list.add(v.copy());
      }
      return set;
    }

    public VariableDefn getVariable(String name, boolean source) {
      for (VariableDefn v : list) {
        if (name.equals(v.getName()) && source == ("source".equals(v.getMode()))) {
          return v;
        }
      }
      return null;
    }

    public VariableDefn getVariable(String name) {
      VariableDefn t = null;
      for (VariableDefn v : list) {
        if (name.equals(v.getName())) {
          t = (t == null) ? v : null;
        }
      }
      return t;
    }

    public void add(String pname, VariableDefn v) {
      VariableDefn vn = v.copy();
      vn.name = pname;
      list.add(vn);
    }

    public String summary() {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (VariableDefn v : list) {
        b.append(v.summary());
      }
      return b.toString();
    }

    public boolean matches(VariableSet other) {
      if (list.size() != other.list.size()) {
        return false;
      }
      for (int i = 0; i < list.size(); i++) {
        if (!list.get(i).matches(other.list.get(i))) {
          return false;
        }
      }
      return true;
    }
  }

  private static final boolean SOURCE = true;
  private static final boolean TARGET = false;

  private FHIRPathEngine fpe;
  private ProfileUtilities profileUtilities;
  private ContextUtilities cu;
  private List<StructureMap> imports = new ArrayList<>();

  public StructureMapValidator(IWorkerContext context, boolean debug, TimeTracker timeTracker, FHIRPathEngine fpe, XVerExtensionManager xverManager, ProfileUtilities profileUtilities, Coding jurisdiction) {
    super(context, xverManager, debug);
    source = Source.InstanceValidator;
    this.fpe = fpe;
    this.timeTracker = timeTracker;
    this.jurisdiction = jurisdiction;
    this.profileUtilities = profileUtilities;
    this.cu = new ContextUtilities(context);

  }
  
  public boolean isAbstractType(List<TypeRefComponent> list) {
      if (list.size() != 1) {
        return false;
      } else {
        StructureDefinition sd = context.fetchTypeDefinition(list.get(0).getCode());
        return sd != null && sd.getAbstract();
      }

  }

  public boolean validateStructureMap(List<ValidationMessage> errors, Element src, NodeStack stack)  {
    boolean ok = true;
    List<Element> imports = src.getChildrenByName("import");
    int cc = 0;
    for (Element import_ : imports) {
      ok = validateImport(errors, src, import_, stack.push(import_, cc, null, null)) && ok;
      cc++;
    }
    
    List<String> grpNames = new ArrayList<>();
    List<Element> groups = src.getChildrenByName("group");
    // we iterate the groups repeatedly, validating them if they have stated types or found types, until nothing happens
    boolean fired = false;
    do {
      fired = false;
      cc = 0;
      for (Element group : groups) {
        if (!group.hasUserData("structuremap.validated")) {
          if (hasInputTypes(group) || group.hasUserData("structuremap.parameters")) {
            group.setUserData("structuremap.validated", true);
            fired = true;
            ok = validateGroup(errors, src, group, stack.push(group, cc, null, null), grpNames) && ok;
          }
        }
        cc++;
      }            
    } while (fired);
    
    cc = 0;
    for (Element group : groups) {
      if (!group.hasUserData("structuremap.validated")) {
        hint(errors, "2023-03-01", IssueType.INFORMATIONAL, group.line(), group.col(), stack.push(group, cc, null, null).getLiteralPath(), ok, I18nConstants.SM_ORPHAN_GROUP, group.getChildValue("name"));
        ok = validateGroup(errors, src, group, stack.push(group, cc, null, null), grpNames) && ok;
      }
      cc++;
    }            
    return ok;
  }

  private boolean hasInputTypes(Element group) {
    List<Element> inputs = group.getChildrenByName("input");
    for (Element input : inputs) {
      if (!input.hasChild("type")) {
        return false;
      }
    }
    return true;
  }

  private boolean validateImport(List<ValidationMessage> errors, Element src, Element import_, NodeStack stack) {
    String url = import_.primitiveValue();
    boolean ok = false;
    StructureMap map = context.fetchResource(StructureMap.class, url);
    if (map != null) {
      imports.add(map);
      ok = true;
    } else if (url.contains("*")) {
      List<StructureMap> maps = cu.listMaps(url);
      ok = !maps.isEmpty();
      imports.addAll(maps);
    }
    warning(errors, "2023-03-01", IssueType.INVALID, import_.line(), import_.col(), stack.getLiteralPath(), ok, I18nConstants.SM_IMPORT_NOT_FOUND, url);
    return true;
  }

  private boolean validateGroup(List<ValidationMessage> errors, Element src, Element group, NodeStack stack, List<String> grpNames) {
    String name = group.getChildValue("name");
    boolean ok = rule(errors, "2023-03-01", IssueType.INVALID, group.line(), group.col(), stack.getLiteralPath(), idIsValid(name), I18nConstants.SM_NAME_INVALID, name);
    if (!rule(errors, "2023-03-01", IssueType.INVALID, group.line(), group.col(), stack.getLiteralPath(), !grpNames.contains(name), I18nConstants.SM_GROUP_NAME_DUPLICATE, name)) {
      grpNames.add(name);
    }
    
    Element extend = group.getNamedChild("extends");
    if (extend != null) {
      ResolvedGroup grp = resolveGroup(extend.primitiveValue(), src);
      if (rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, extend.line(), extend.col(), stack.push(extend, -1, null, null).getLiteralPath(), grp != null, I18nConstants.SM_RULEGROUP_NOT_FOUND, extend.primitiveValue())) {
        // check inputs 
      } else {
        ok = false;
      }
    }
    
    VariableSet variables = new VariableSet(); 
    VariableSet pvars = (VariableSet) group.getUserData("structuremap.parameters");

    // first, load all the inputs
    List<Element> inputs = group.getChildrenByName("input");
    List<Element> structures = src.getChildrenByName("structure");
    int cc = 0;
    for (Element input : inputs) {
      ok = validateInput(errors, src, group, input, stack.push(input, cc, null, null), structures, variables, pvars) && ok;
      cc++;
    }      
    
    // now check the rules.  
    List<Element> rules = group.getChildrenByName("rule");
    cc = 0;
    for (Element rule : rules) {
      ok = validateRule(errors, src, group, rule, stack.push(rule, cc, null, null), variables) && ok;
      cc++;
    }              
    
    return ok;
  }

  private ResolvedGroup resolveGroup(String grpName, Element src) {
    if (grpName == null) {
      return null;
    }
    List<Element> groups = src.getChildrenByName("group");
    for (Element group : groups) {
      String name = group.getChildValue("name");
      if (grpName.equals(name)) {
        return new ResolvedGroup(null, makeGroupComponent(group));
      } 
    }  
    for (StructureMap map : imports) {
      for (StructureMapGroupComponent grp : map.getGroup()) {
        if (grpName.equals(grp.getName())) {
          return new ResolvedGroup(map, grp);
        }
      }
    }
    return null;
  }

  private StructureMapGroupComponent makeGroupComponent(Element group) {
    StructureMapGroupComponent grp = new StructureMapGroupComponent();
    grp.setUserData("element.source", group);
    grp.setName(group.getChildValue("name"));
    List<Element> inputs = group.getChildrenByName("input");
    for (Element input : inputs) {
      StructureMapGroupInputComponent inp = grp.addInput();
      inp.setName(input.getChildValue("name"));
      inp.setType(input.getChildValue("type"));
      try {
        inp.setMode(StructureMapInputMode.fromCode(input.getChildValue("mode")));
      } catch (Exception e) {
        // nothing; will be an error elsewhere
      }
    }
    return grp;
  }

  private boolean validateInput(List<ValidationMessage> errors, Element src, Element group, Element input, NodeStack stack, List<Element> structures, VariableSet variables, VariableSet pvars) {
    boolean ok = false;
    String name = input.getChildValue("name"); 
    String mode = input.getChildValue("mode"); 
    String type = input.getChildValue("type");
    VariableDefn pv = null;
    if (type == null && pvars != null) {
      pv = pvars.getVariable(name, mode.equals("source"));
      if (pv != null) {
        type = pv.getWorkingType();
      }
    }

    if (rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, input.line(), input.col(), stack.getLiteralPath(), idIsValid(name), I18nConstants.SM_NAME_INVALID, name) &&  // the name {0} is not valid)
        rule(errors, "2023-03-01", IssueType.DUPLICATE, input.line(), input.col(), stack.getLiteralPath(), !variables.hasVariable(name), I18nConstants.SM_GROUP_INPUT_DUPLICATE, name)) {  // the name {0} is not valid)      
      VariableDefn v = variables.add(name, mode);
      if (rule(errors, "2023-03-01", IssueType.INVALID, input.line(), input.col(), stack.getLiteralPath(), Utilities.existsInList(mode, "source", "target"), I18nConstants.SM_GROUP_INPUT_MODE_INVALID, name, mode) && // the group parameter {0} mode {1} isn't valid
          warning(errors, "2023-03-01", IssueType.NOTSUPPORTED, input.line(), input.col(), stack.getLiteralPath(), type != null, I18nConstants.SM_GROUP_INPUT_NO_TYPE, name)) { // the group parameter {0} has no type, so the paths cannot be validated
        String smode = null;
        StructureDefinition sd = null;
        ElementDefinition ed = null;
        if (pv != null) {
          sd = pv.getSd();
          ed = pv.getEd();
        } else {
          Element structure = findStructure(structures, type);
          if (structure != null) {
            smode = structure.getChildValue("mode");
            String url = structure.getChildValue("url");
            sd = context.fetchResource(StructureDefinition.class, url);
            if (sd == null) {              
              rule(errors, "2023-03-01", IssueType.INVALID, input.line(), input.col(), stack.getLiteralPath(), sd != null, I18nConstants.SM_GROUP_INPUT_TYPE_UNKNOWN_STRUCTURE, type, url);
            }
          } else if (type != null) {
            sd = context.fetchTypeDefinition(type);
            if (sd == null) {              
              rule(errors, "2023-03-01", IssueType.INVALID, input.line(), input.col(), stack.getLiteralPath(), sd != null, I18nConstants.SM_GROUP_INPUT_TYPE_UNKNOWN_TYPE, type);
            }
          } else {
            rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, input.line(), input.col(), stack.getLiteralPath(), structure != null, I18nConstants.SM_GROUP_INPUT_TYPE_NOT_DECLARED, type);
            ok = false;
          }
          if (sd != null) {
            ed = sd.getSnapshot().getElementFirstRep();
          }
        }
        if (rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, input.line(), input.col(), stack.getLiteralPath(), smode == null || mode.equals(smode), I18nConstants.SM_GROUP_INPUT_MODE_MISMATCH, type, mode, smode)) { // the type {0} has mode {1} which doesn't match the structure definition {2}
          v.setType(1, sd, ed, null);
          ok = true;
        }
      }
    }
    return ok;
  }

  private Element findStructure(List<Element> structures, String type) {
    for (Element structure : structures ) {
      String t = structure.getChildValue("alias");
      if (type.equals(t)) {
        return structure;
      }
    }
    return null;
  }

  private boolean idIsValid(String name) {
    return name != null && name.matches("[a-zA-Z][a-zA-Z0-9]*");
  }

  private boolean validateRule(List<ValidationMessage> errors, Element src, Element group, Element rule, NodeStack stack, VariableSet variables) {
    String name = rule.getChildValue("name");
    boolean ok = rule(errors, "2023-03-01", IssueType.INVALID, rule.line(), rule.col(), stack.getLiteralPath(), idIsValid(name), I18nConstants.SM_NAME_INVALID, name);
    
    RuleInformation ruleInfo = new RuleInformation();
    // process the sources
    VariableSet lvars = variables.copy();
    List<Element> sources = rule.getChildrenByName("source");
    int cc = 0;
    for (Element source : sources) {
      ok = validateRuleSource(errors, src, group, rule, source, stack.push(source, cc, null, null), lvars, ruleInfo, cc) && ok;
      cc++;
    }
    // process the targets
    List<Element> targets = rule.getChildrenByName("target");
    cc = 0;
    for (Element target : targets) {
      ok = validateRuleTarget(errors, src, group, rule, target, stack.push(target, cc, null, null), lvars, ruleInfo) && ok;
      cc++;
    }
    
    // process the nested rules
    List<Element> rules = rule.getChildrenByName("rule");
    cc = 0;
    for (Element child : rules) {
      ok = validateRule(errors, src, group, child, stack.push(child, cc, null, null), lvars) && ok;
      cc++;
    }
    // todo: check dependents
    List<Element> dependents = rule.getChildrenByName("dependent");
    cc = 0;
    for (Element dependent : dependents) {
      ok = validateDependent(errors, src, group, dependent, stack.push(dependent, cc, null, null), lvars) && ok;
      cc++;
    }
    return ok;
  }

  private boolean validateRuleSource(List<ValidationMessage> errors, Element src, Element group, Element rule, Element source, NodeStack stack, VariableSet variables, RuleInformation ruleInfo, int loopCounter) {
    String context = source.getChildValue("context");
    if (loopCounter > 0) {
      ruleInfo.setDefVariable(null);
    }
    boolean ok = rule(errors, "2023-03-01", IssueType.INVALID, source.line(), source.col(), stack.getLiteralPath(), idIsValid(context), I18nConstants.SM_NAME_INVALID, context) &&
        rule(errors, "2023-03-01", IssueType.UNKNOWN, source.line(), source.col(), stack.getLiteralPath(), variables.hasVariable(context, SOURCE), I18nConstants.SM_SOURCE_CONTEXT_UNKNOWN, context);
    if (ok) {
      VariableDefn v = variables.getVariable(context, SOURCE);
      if (v.hasTypeInfo()) { // if it doesn't, that's already an issue elsewhere 
        // check type
        // check defaultValue
        // check element
        String element = source.getChildValue("element");
        if (element != null) {
          String path = v.getEd().getPath()+"."+element;
          String variable = source.getChildValue("variable");
          VariableDefn vn = null;
          if (hint(errors, "2023-03-01", IssueType.INVALID, source.line(), source.col(), stack.getLiteralPath(), variable != null, I18nConstants.SM_RULE_SOURCE_UNASSIGNED)) {
            if (rule(errors, "2023-03-01", IssueType.INVALID, source.line(), source.col(), stack.getLiteralPath(), idIsValid(variable), I18nConstants.SM_NAME_INVALID, variable)) {
              vn = variables.add(variable, v.getMode()); // may overwrite
              if (loopCounter == 0) {
                ruleInfo.setDefVariable(variable);
              }
            } else {
              ok = false;
            }
          }            
          
          List<ElementDefinitionSource> els = getElementDefinitions(v.getSd(), v.getEd(), v.getType(), element);
          if (rule(errors, "2023-03-01", IssueType.INVALID, source.line(), source.col(), stack.getLiteralPath(), !els.isEmpty(), I18nConstants.SM_SOURCE_PATH_INVALID, context, element, path)) {
            if (warning(errors, "2023-03-01", IssueType.INVALID, source.line(), source.col(), stack.getLiteralPath(), els.size() == 1, I18nConstants.SM_TARGET_PATH_MULTIPLE_MATCHES, context, element, v.getEd().getPath()+"."+element, render(els))) {
              ElementDefinitionSource el = els.get(0);
              String type = source.getChildValue("type"); 
              if (type != null) {
                ok = rule(errors, "2023-03-01", IssueType.INVALID, source.line(), source.col(), stack.getLiteralPath(), hasType(el.getEd(), type), I18nConstants.SM_SOURCE_TYPE_INVALID, type, path, el.getEd().typeSummary()) && ok;
              }
              String min = source.getChildValue("min");
              hint(errors, "2023-03-01", IssueType.INVALID, source.line(), source.col(), stack.getLiteralPath(), min == null || isMoreOrEqual(min, v.getEd().getMin()), I18nConstants.SM_RULE_SOURCE_MIN_REDUNDANT, min, v.getEd().getMin());

              int existingMax = multiplyCardinality(v.getMax(), el.getEd().getMax());
              String max = source.getChildValue("max");
              int iMax = readMax(max, existingMax);
              warning(errors, "2023-03-01", IssueType.INVALID, source.line(), source.col(), stack.getLiteralPath(), iMax <= existingMax, I18nConstants.SM_RULE_SOURCE_MAX_REDUNDANT, max, v.getMax());
              ruleInfo.seeCardinality(iMax);


              if (vn != null) {
                vn.setType(iMax, el.getSd(), el.getEd(), type); // may overwrite
              }
            }
          } else {
            ok = false;
          }
          // check condition
          // check check
        }
      } else {
        String variable = source.getChildValue("variable");
        if (variable != null) {
          variables.add(variable, v.getMode()); // may overwrite

        }      
      }
    } 
    return ok;
  }

  private boolean hasType(ElementDefinition ed, String type) {
    for (TypeRefComponent td : ed.getType()) {
      StructureDefinition sd = context.fetchTypeDefinition(td.getWorkingCode());
      if (sd != null && type.equals(sd.getType())) {
        return true;
      }
    }
    return false;
  }

  private int readMax(String max, int existingMax) {
    if (max == null || !Utilities.isInteger(max)) {
      return existingMax;
    } else {
      return Integer.parseInt(max);
    }
  }

  private int multiplyCardinality(int max, String max2) {
    if (max == Integer.MAX_VALUE || "*".equals(max2)) {
      return Integer.MAX_VALUE;
    } else {
      return max * Integer.parseInt(max2);
    }
  }

  private boolean validateRuleTarget(List<ValidationMessage> errors, Element src, Element group, Element rule, Element target, NodeStack stack, VariableSet variables, RuleInformation ruleInfo) {
    String context = target.getChildValue("context");
    if (context == null) {
      return true;
    }
    boolean ok = rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), idIsValid(context), I18nConstants.SM_NAME_INVALID, context) &&
        rule(errors, "2023-03-01", IssueType.UNKNOWN, target.line(), target.col(), stack.getLiteralPath(), variables.hasVariable(context, TARGET), I18nConstants.SM_TARGET_CONTEXT_UNKNOWN, context);
    if (ok) {
      VariableDefn v = variables.getVariable(context, TARGET);
      if (v.hasTypeInfo()) {
        String listMode = target.getChildValue("listMode");
        String listRuleId = target.getChildValue("listRuleId");
        warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), listRuleId == null || "share".equals(listMode), I18nConstants.SM_LIST_RULE_ID_ONLY_WHEN_SHARE);
        if (!ruleInfo.isList()) {
          warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), listMode == null, I18nConstants.SM_NO_LIST_MODE_NEEDED);
          warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), listRuleId == null, I18nConstants.SM_NO_LIST_RULE_ID_NEEDED);
        }
        VariableDefn vn = null;
        String variable = target.getChildValue("variable");
        if (variable != null) {
          if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), idIsValid(variable), I18nConstants.SM_NAME_INVALID, variable)) {
            vn = variables.add(variable, v.getMode()); // may overwrite
          } else {
            ok = false;
          }
        }

        String element = target.getChildValue("element");
        if (element != null) {
          List<ElementDefinitionSource> els = getElementDefinitions(v.getSd(), v.getEd(), v.getType(), element);
          if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), !els.isEmpty(), I18nConstants.SM_TARGET_PATH_INVALID, context, element, v.getEd().getPath()+"."+element)) {
            if (warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), els.size() == 1 || isElementandSlicing(els), I18nConstants.SM_TARGET_PATH_MULTIPLE_MATCHES, context, element, v.getEd().getPath()+"."+element, render(els))) {
              ElementDefinitionSource el = els.get(0);
              String transform = target.getChildValue("transform");
              List<Element> params = target.getChildren("parameter");
              if (transform == null) {
                transform = "create"; // implied
                rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() == 0, I18nConstants.SM_TARGET_NO_TRANSFORM_NO_CHECKED, transform);
              } 
              // List<String> types = listTypes(el.getEd().getType());
              String type = null;
              if (el.getEd().getType().size() == 1) {
                type = el.getEd().getTypeFirstRep().getWorkingCode();
              } else {                  
                type = inferType(ruleInfo, variables, rule, transform, params);
              }

              switch (transform) {
              case "create":
                if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() < 2, I18nConstants.SM_TARGET_TRANSFORM_PARAM_COUNT_RANGE, "create", "0", "1", params.size())) {
                  if (params.size() == 1) {
                    type = params.get(0).getChildValue("value");
                    // type can be a url, a native type, or an alias 
                    if (!Utilities.isAbsoluteUrl(type)) {
                      type = resolveType(type, "target", src);
                      if (!Utilities.isAbsoluteUrl(type)) {
                        StructureDefinition sdt = this.context.fetchTypeDefinition(type);
                        if (sdt != null) {
                          type = sdt.getType();
                        }
                      }
                    }
                    warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(),type != null, I18nConstants.SM_TARGET_TRANSFORM_TYPE_UNPROCESSIBLE, "create");
                  } else {
                    // maybe can guess? maybe not ... type = 
                  }
                } else {
                  ok = false;
                }
                break;
              case "copy": // logic is the same as create?
                if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() < 2, I18nConstants.SM_TARGET_TRANSFORM_PARAM_COUNT_RANGE, "create", "0", "1", params.size())) {
                  if (params.size() == 1) {
                    type = params.get(0).getChildValue("value");
                    warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(),type != null, I18nConstants.SM_TARGET_TRANSFORM_TYPE_UNPROCESSIBLE, "copy");
                  } else {
                    // maybe can guess? maybe not ... type = 
                  }
                } else {
                  ok = false;
                }
                break;
              case "reference":
                if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() == 1, I18nConstants.SM_TARGET_TRANSFORM_PARAM_COUNT_RANGE, "reference", "0", "1", params.size())) {
                  type = "string";
                } else {
                  ok = false;
                }
                break;
              case "evaluate":
                if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() == 1, I18nConstants.SM_TARGET_TRANSFORM_PARAM_COUNT_SINGLE, "evaluate", "1", params.size())) {
                  String exp = params.get(0).getChildValue("value");
                  if (rule(errors, "2023-03-01", IssueType.INVALID, params.get(0).line(), params.get(0).col(), stack.getLiteralPath(), exp != null, I18nConstants.SM_TARGET_TRANSFORM_PARAM_UNPROCESSIBLE, "0", params.size())) {
                    try {
                      TypeDetails td = fpe.check(variables, v.getSd().getUrl(), v.getEd().getPath(), fpe.parse(exp));
                      if (td.getTypes().size() == 1) {
                        type = td.getType();
                      }
                    } catch (Exception e) {
                      rule(errors, "2023-03-01", IssueType.INVALID, params.get(0).line(), params.get(0).col(), stack.getLiteralPath(), false, I18nConstants.SM_TARGET_TRANSFORM_EXPRESSION_ERROR, e.getMessage());
                    }
                  } else {
                    ok = false;
                  }
                } else {
                  ok = false;
                }
                break;
              case "cc" :
                ok = rule(errors, "2023-05-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() == 2 || params.size() == 3, I18nConstants.SM_TARGET_TRANSFORM_MISSING_PARAMS, transform) && ok;
                ok = checkParamExistsOrPrimitive(errors, params.size() > 0 ? params.get(0).getNamedChild("value") : null, "cc", "system", target, variables, stack, ok, true);
                ok = checkParamExistsOrPrimitive(errors, params.size() > 1 ? params.get(1).getNamedChild("value") : null, "cc", "code", target, variables, stack, ok, true);
                ok = checkParamExistsOrPrimitive(errors, params.size() > 2 ? params.get(2).getNamedChild("value") : null, "cc", "display", target, variables, stack, ok, false);
                break;                
              case "append" :
                ok = rule(errors, "2023-05-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() > 0, I18nConstants.SM_TARGET_TRANSFORM_MISSING_PARAMS, transform) && ok;
                for (int i = 0; i  < params.size(); i++) {
                  ok = checkParamExistsOrPrimitive(errors, params.get(1).getNamedChild("value"), "cc", "parameter "+i, target, variables, stack, ok, false);
                }
                break;                
              case "uuid" :
                ok = rule(errors, "2023-05-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() == 0, I18nConstants.SM_TARGET_TRANSFORM_MISSING_PARAMS, transform) && ok;
                break;                
              case "translate":
                ok = rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() == 3, I18nConstants.SM_TARGET_TRANSFORM_MISSING_PARAMS, transform) && ok;
                Element srcE = params.size() > 0 ? params.get(0).getNamedChild("value") : null;
                Element mapE = params.size() > 1? params.get(1).getNamedChild("value") : null;
                Element modeE = params.size() > 2 ? params.get(2).getNamedChild("value") : null;
                VariableDefn sv = null;
                // srcE - if it's an id, the variable must exist
                if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), srcE != null, I18nConstants.SM_TARGET_TRANSFORM_TRANSLATE_NO_PARAM, "source")) {
                  if ("id".equals(srcE.fhirType())) {
                    sv = variables.getVariable(srcE.getValue(), true);
                    rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), sv != null, I18nConstants.SM_TARGET_TRANSFORM_TRANSLATE_UNKNOWN_SOURCE, srcE.getValue());
                  }
                } else { 
                  ok = false; 
                }
                // mapE - it must resolve (may be reference to contained)
                if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), mapE != null, I18nConstants.SM_TARGET_TRANSFORM_TRANSLATE_NO_PARAM, "map_uri")) {
                  String ref = mapE.getValue();
                  ConceptMap cm = null;
                  if (ref.startsWith("#")) {
                    cm = (ConceptMap) loadContainedResource(errors, stack.getLiteralPath(), src, ref.substring(1), ConceptMap.class);
                    ok = rule(errors, "2023-03-01", IssueType.NOTFOUND, target.line(), target.col(), stack.getLiteralPath(), srcE != null, I18nConstants.SM_TARGET_TRANSFORM_TRANSLATE_CM_NOT_FOUND, ref) && ok;                          
                  } else {
                    // todo: look in Bundle?
                    cm = this.context.fetchResource(ConceptMap.class, ref);
                    warning(errors, "2023-03-01", IssueType.NOTFOUND, target.line(), target.col(), stack.getLiteralPath(), srcE != null, I18nConstants.SM_TARGET_TRANSFORM_TRANSLATE_CM_NOT_FOUND, ref);                          
                  }
                  if (cm != null && (v != null && v.hasTypeInfo() || (sv != null && sv.hasTypeInfo()))) {
                    ok = checkConceptMap(errors, target.line(), target.col(), stack.getLiteralPath(), cm, sv == null ? null : sv.getEd(), el == null ? null : el.getEd()) && ok;
                  }
                }
                if (modeE != null) {
                  String t = modeE.getValue();
                  if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), Utilities.existsInList(t, "code", "system", "display", "Coding", "CodeableConcept"), I18nConstants.SM_TARGET_TRANSFORM_TRANSLATE_CM_BAD_MODE, t)) {
                    // cross check the type
                  } else {
                    ok = false;
                  }
                }
                break;
              default:
                rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), false, I18nConstants.SM_TARGET_TRANSFORM_NOT_CHECKED, transform);
                ok = false;
              }
              if (vn != null) {
                // it's just a warning: maybe this'll work out at run time?
                warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), type != null, I18nConstants.SM_TARGET_TYPE_MULTIPLE_POSSIBLE, el.getEd().typeSummary());

                vn.setType(ruleInfo.getMaxCount(), el.getSd(), el.getEd(), type); // may overwrite
              }

            }
          } else {
            ok = false;
          }
        }
        //      
      }
    }
    return ok;
  
  }

  private boolean checkParamExistsOrPrimitive(List<ValidationMessage> errors, Element e, String string, String string2, Element target, VariableSet variables, NodeStack stack, boolean ok, boolean mandatory) {
    if (!mandatory && e == null) {
      return ok;
    } else if (rule(errors, "2023-05-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), e != null, I18nConstants.SM_TARGET_TRANSFORM_TRANSLATE_NO_PARAM, "system")) {
      if ("id".equals(e.fhirType())) {
        VariableDefn sv = variables.getVariable(e.getValue(), true);
        rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), e != null, I18nConstants.SM_TARGET_TRANSFORM_OP_UNKNOWN_SOURCE, "cc", "system", e.getValue());
      } else {
        rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), e.isPrimitive(), I18nConstants.SM_TARGET_TRANSFORM_OP_INVALID_TYPE, "cc", "system",e.fhirType());
      }
      return ok;
    } else { 
      return false; 
    }
 
  }

  private boolean isElementandSlicing(List<ElementDefinitionSource> els) {
    if (els.size()== 0) {
      return false;
    }
    String path = els.get(0).getEd().getPath();
    for (int i = 1; i < els.size(); i++ ) {
      if (!els.get(i).getEd().hasSliceName() || !els.get(i).getEd().getPath().equals(path)) {
        return false;
      }
    }
    return true;
  }

  private boolean checkConceptMap(List<ValidationMessage> errors, int line, int col, String literalPath, ConceptMap cm, ElementDefinition srcED, ElementDefinition tgtED) { 
    boolean ok = true;
    ValueSet srcVS = null;
    if (srcED != null) {
      if (warning(errors, "2023-03-01", IssueType.INVALID, line, col, literalPath, srcED.getBinding().hasValueSet() && srcED.getBinding().getStrength() == BindingStrength.REQUIRED, I18nConstants.SM_TARGET_TRANSLATE_BINDING_SOURCE)) {
        srcVS = context.fetchResource(ValueSet.class, srcED.getBinding().getValueSet());
        if (warning(errors, "2023-03-01", IssueType.INVALID, line, col, literalPath, srcVS != null, I18nConstants.SM_TARGET_TRANSLATE_BINDING_VS_SOURCE)) {
          ValueSetExpansionOutcome vse = context.expandVS(srcVS, true, false);
          if (warning(errors, "2023-03-01", IssueType.INVALID, line, col, literalPath, vse.isOk(), I18nConstants.SM_TARGET_TRANSLATE_BINDING_VSE_SOURCE, vse.getError())) {
            CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
            for (ValueSetExpansionContainsComponent c : vse.getValueset().getExpansion().getContains()) {
              if (ConceptMapUtilities.hasMappingForSource(cm, c.getSystem(), c.getVersion(), c.getCode())) {
                b.append(c.getCode());
              }
            }
            if (b.count() > 0) {
              warning(errors, "2023-03-01", IssueType.INVALID, line, col, literalPath, srcED.getBinding().hasValueSet() && srcED.getBinding().getStrength() == BindingStrength.REQUIRED, I18nConstants.SM_TARGET_TRANSLATE_BINDING_SOURCE_UNMAPPED, b.toString());
            }
          }          
        }        
      }
    }
    if (srcED != null) {
      if (warning(errors, "2023-03-01", IssueType.INVALID, line, col, literalPath, tgtED.getBinding().hasValueSet() && tgtED.getBinding().getStrength() == BindingStrength.REQUIRED, I18nConstants.SM_TARGET_TRANSLATE_BINDING_TARGET)) {
        ValueSet vs = context.fetchResource(ValueSet.class, tgtED.getBinding().getValueSet());
        if (warning(errors, "2023-03-01", IssueType.INVALID, line, col, literalPath, vs != null, I18nConstants.SM_TARGET_TRANSLATE_BINDING_VS_TARGET)) {
          ValueSetExpansionOutcome vse = context.expandVS(vs, true, false);
          if (warning(errors, "2023-03-01", IssueType.INVALID, line, col, literalPath, vse.isOk(), I18nConstants.SM_TARGET_TRANSLATE_BINDING_VSE_TARGET, vse.getError())) {
            List<String> systems = new ArrayList<>();
            if (srcVS != null) {
              for (ConceptSetComponent  inc : srcVS.getCompose().getInclude()) {
                systems.add(inc.getSystem());
              }
            }
            List<Coding> codes = ConceptMapUtilities.listTargets(cm, systems);
            CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
            for (Coding code : codes) {
              if (ValueSetUtilities.hasCodeInExpansion(vse.getValueset(), code)) {
                b.append(code.getCode());
              }
            }
            if (b.count() > 0) {
              warning(errors, "2023-03-01", IssueType.INVALID, line, col, literalPath, srcED.getBinding().hasValueSet() && srcED.getBinding().getStrength() == BindingStrength.REQUIRED, I18nConstants.SM_TARGET_TRANSLATE_BINDING_TARGET_WRONG, b.toString());
            }
          }          
        }        
      }
    }
    return ok;
  }

  private String inferType(RuleInformation ruleInfo, VariableSet variables, Element rule, String transform, List<Element> params) {
    // under some special conditions, we can infer what the type will be:
    //  * there's a nominated default variable 
    //  * that variable has as single type
    //  * there's a create/copy with no param
    //  * there's a single dependent rule with name = StructureMapUtilities.DEF_GROUP_NAME
    //  * there's a default type group for the type of the source type 
    // otherwise, we can't know the target type. 
    
    if (ruleInfo.getDefVariable() != null && Utilities.existsInList(transform, "create", "copy") && params.isEmpty()) {
      VariableDefn v = variables.getVariable(ruleInfo.getDefVariable(), SOURCE);
      if (v != null && v.getEd() != null  && (v.getEd().getType().size() == 1 || v.getType() != null)) {
        List<Element> dependents = rule.getChildrenByName("dependent");
        String type = v.getType() != null ? getTypeFromDefn(v.getEd(), v.getType()) : v.getEd().getTypeFirstRep().getWorkingCode();
        if (dependents.size() == 1 && StructureMapUtilities.DEF_GROUP_NAME.equals(dependents.get(0).getChildValue("name"))) {
          // now, we look for a default group.
          // todo: look in this source
          // now look through the inputs
          for (StructureMap map : imports) {
            for (StructureMapGroupComponent grp : map.getGroup()) {
              if (grp.getTypeMode() != StructureMapGroupTypeMode.NULL && grp.getInput().size() == 2) {
                String grpType = getTypeForGroupInput(map, grp, grp.getInput().get(0));
                if (sameTypes(type, grpType)) {
                  String tgtType = getTypeForGroupInput(map, grp, grp.getInput().get(1));
                  if (tgtType != null) {
                    return tgtType;
                  }
                }
              }
            }
          }
        } else if (dependents.size() == 0) {
          for (StructureMap map : imports) {
            for (StructureMapGroupComponent grp : map.getGroup()) {
              if (grp.getTypeMode() == StructureMapGroupTypeMode.TYPEANDTYPES && grp.getInput().size() == 2) {
                String grpType = getTypeForGroupInput(map, grp, grp.getInput().get(0));
                if (sameTypes(type, grpType)) {
                  String tgtType = getTypeForGroupInput(map, grp, grp.getInput().get(1));
                  if (tgtType != null) {
                    return tgtType;
                  }
                }
              }
            }
          }
          
        }
      }
    }
    return null;
  }

  private String getTypeFromDefn(ElementDefinition ed, String type) {
    for (TypeRefComponent td : ed.getType()) {
      StructureDefinition sd = context.fetchTypeDefinition(td.getWorkingCode());
      if (sd != null && type.equals(sd.getType())) {
        return td.getWorkingCode();
      }
    }
    return type;
  }

  private boolean sameTypes(String type1, String type2) {
    if (type1 == null || type2 == null) {
      return false;
    }
    if (!Utilities.isAbsoluteUrl(type1)) {
      type1 = "http://hl7.org/fhir/StructureDefinition/"+type1;
    }
    if (!Utilities.isAbsoluteUrl(type2)) {
      type2 = "http://hl7.org/fhir/StructureDefinition/"+type2;
    }
    return type1.equals(type2);
  }

  private String getTypeForGroupInput(StructureMap map, StructureMapGroupComponent grp,  StructureMapGroupInputComponent input) {
    if (input == null) {
      return null;
    }
    String type = input.getType();
    if (type == null) {
      return null;
    }
    StructureMapModelMode mode = input.getMode() == StructureMapInputMode.SOURCE ? StructureMapModelMode.SOURCE : StructureMapModelMode.TARGET;
    for (StructureMapStructureComponent st : map.getStructure()) {
      if (type.equals(st.getAlias()) && mode == st.getMode()) {
        return st.getUrl();
      }
    }
    return type;
  }

  private List<String> listTypes(List<TypeRefComponent> types) {
    List<String> res = new ArrayList<>();
    for (TypeRefComponent td : types) {
      res.add(td.getWorkingCode());
    }
    Collections.sort(res);
    return res;
  }

  private String render(List<ElementDefinitionSource> list) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (ElementDefinitionSource t : list) {
      b.append(t.getEd().getId());
    }
    return b.toString();
  }

  private List<ElementDefinitionSource> getElementDefinitions(StructureDefinition sd, ElementDefinition ed, String type, String element) {
    List<ElementDefinitionSource> result = new ArrayList<>();
    List<ElementDefinition> children = profileUtilities.getChildList(sd, ed);
    if (children == null || children.isEmpty()) {
      getElementDefinitionChildrenFromTypes(result, sd, ed, type, element);
    } else {
      for (ElementDefinition t : children) {
        if (t.getNameBase().equals(element)) {
          if (t.hasContentReference()) {
            String url = t.getContentReference().substring(0, t.getContentReference().indexOf("#"));
            String path = t.getContentReference().substring(t.getContentReference().indexOf("#")+1);
            StructureDefinition sdt = "".equals(url) || url.equals(sd.getUrl()) ? sd : context.fetchResource(StructureDefinition.class, url);
            if (sdt == null) {
              throw new Error("Unable to resolve "+url);
            } else {
              ElementDefinition t2 = sdt.getSnapshot().getElementByPath(path);
              if (t2 == null) {
                throw new Error("Unable to resolve "+path+" in "+url);
              } else {
                result.add(new ElementDefinitionSource(sdt, t2));
              }
            }
          } else {
            result.add(new ElementDefinitionSource(sd, t));
          }
        }
      }
    }
    return result;
  }

  private void getElementDefinitionChildrenFromTypes(List<ElementDefinitionSource> result, StructureDefinition sd, ElementDefinition ed, String type, String element) {
    for (TypeRefComponent td : ed.getType()) {
      String tn = td.getWorkingCode();
      StructureDefinition sdt = context.fetchTypeDefinition(tn);
      if (type == null || tn.equals(type) || (sdt != null && sdt.getType().equals(type))) {
        StructureDefinition tsd = context.fetchTypeDefinition(td.getWorkingCode());
        if (tsd != null) {
          for (ElementDefinition t : tsd.getSnapshot().getElement()) {
            if (Utilities.charCount(t.getPath(), '.') == 1 && t.getNameBase().equals(element)) {
              result.add(new ElementDefinitionSource(tsd, t));
            }
          }
        } else {
          System.out.println("Unable to find type "+type);
        }
      }
    }    
  }

  private boolean isLessOrEqual(String value, String limit) {
    if (Utilities.isInteger(value) || !Utilities.isInteger(limit)) {
      int v = Integer.parseInt(value);
      int l = Integer.parseInt(limit);
      return v <= l;
    }
    return true; // no issue in this case
  }

  private boolean isMoreOrEqual(String value, int limit) {
    if (Utilities.isInteger(value)) {
      int v = Integer.parseInt(value);
      return v >= limit;
    }
    return true; // no issue in this case
  }


  private boolean validateDependent(List<ValidationMessage> errors, Element src, Element group, Element dependent, NodeStack stack, VariableSet variables) {
    boolean ok = true;
    String name = dependent.getChildValue("name");
    if (StructureMapUtilities.DEF_GROUP_NAME.equals(name)) {
      VariableDefn srcVar = variables.getVariable(StructureMapUtilities.AUTO_VAR_NAME, true);
      VariableDefn tgtVar = variables.getVariable(StructureMapUtilities.AUTO_VAR_NAME, false);
      if (srcVar != null && srcVar.hasTypeInfo() && tgtVar != null && tgtVar.hasTypeInfo()) {
        String srcType = srcVar.getWorkingType();
        String tgtType = tgtVar.getWorkingType();
        if (rule(errors, "2023-03-01", IssueType.NOTFOUND, dependent.line(), dependent.col(), stack.getLiteralPath(), srcType != null, I18nConstants.SM_SOURCE_TYPE_NOT_FOUND) &&
            rule(errors, "2023-03-01", IssueType.NOTFOUND, dependent.line(), dependent.col(), stack.getLiteralPath(), tgtType != null, I18nConstants.SM_TARGET_TYPE_NOT_FOUND)) {
          StructureMapGroupComponent grp = findDefaultGroup(src, srcType, tgtType);
          ok = rule(errors, "2023-03-01", IssueType.NOTFOUND, dependent.line(), dependent.col(), stack.getLiteralPath(), grp != null, I18nConstants.SM_MATCHING_RULEGROUP_NOT_FOUND, srcType, tgtType) && ok;
        } else {
          ok = false;
        }      
      }
    } else {
      ResolvedGroup grp = resolveGroup(name, src);
      if (rule(errors, "2023-03-01", IssueType.NOTFOUND, dependent.line(), dependent.col(), stack.getLiteralPath(), grp != null, I18nConstants.SM_RULEGROUP_NOT_FOUND, name)) {
        List<Element> params = dependent.getChildren(VersionUtilities.isR5Plus(context.getVersion()) ? "parameter" : "variable");
        if (rule(errors, "2023-03-01", IssueType.INVALID, dependent.line(), dependent.col(), stack.getLiteralPath(), params.size() == grp.getTargetGroup().getInput().size(), I18nConstants.SM_RULEGROUP_PARAM_COUNT_MISMATCH, name, params.size(), grp.getTargetGroup().getInput().size())) {
          VariableSet lvars = new VariableSet();
          int cc = 0;
          for (Element param : params) {
            NodeStack pstack = stack.push(param, cc, null, null);
            StructureMapGroupInputComponent input = grp.getTargetGroup().getInput().get(cc);
            String iType = resolveType(grp, input, src);
            String pname = input.getName();
            VariableDefn v = getParameter(errors, param, pstack, variables, input.getMode());
            if (rule(errors, "2023-06-27", IssueType.INVALID, param.line(), param.col(), pstack.getLiteralPath(), v != null, I18nConstants.SM_DEPENDENT_PARAM_NOT_FOUND, pname, input.getMode().toCode())) {
              if (rule(errors, "2023-03-01", IssueType.INVALID, param.line(), param.col(), pstack.getLiteralPath(), v.mode.equals(input.getMode().toCode()), I18nConstants.SM_DEPENDENT_PARAM_MODE_MISMATCH, param.getChildValue("name"), v.mode, input.getMode().toCode(), grp.getTargetGroup().getName()) &&
                rule(errors, "2023-03-01", IssueType.INVALID, param.line(), param.col(), pstack.getLiteralPath(), typesMatch(v, iType), I18nConstants.SM_DEPENDENT_PARAM_TYPE_MISMATCH, 
                    pname, v.summary(), input.getType(), grp.getTargetGroup().getName(), input.getType(), grp.getTargetMap() == null ? "$this" : grp.getTargetMap().getVersionedUrl())) {
                lvars.add(pname, v);  
              } else {
                ok = false;
              }
            } else {
              ok = false;
            }
            cc++;
          }
          if (ok && grp.getTargetGroup().hasUserData("element.source")) {
            Element g = (Element) grp.getTargetGroup().getUserData("element.source");
            if (g.hasUserData("structuremap.parameters")) {
              VariableSet pvars = (VariableSet) g.getUserData("structuremap.parameters");
              rule(errors, "2023-03-01", IssueType.INVALID, dependent.line(), dependent.col(), stack.getLiteralPath(), pvars.matches(lvars), I18nConstants.SM_DEPENDENT_PARAM_TYPE_MISMATCH_DUPLICATE, grp.getTargetGroup().getName(), pvars.summary(), lvars.summary());
            } else {
              g.setUserData("structuremap.parameters", lvars);
            }
          }
        }
      } else {
        ok = false;
      }
    }
    return ok;
  }

  private String resolveType(ResolvedGroup grp, StructureMapGroupInputComponent input, Element map) {
    if (grp.getTargetMap() == null) {
      List<Element> structures = map.getChildrenByName("structure");
      for (Element structure : structures) {
        String alias = structure.getChildValue("alias");
        if (alias != null && alias.equals(input.getType())) {
          return structure.getChildValue("url");
        }
      }      
    } else {
      for (StructureMapStructureComponent struc : grp.getTargetMap().getStructure()) {
        if (struc.hasAlias() && struc.getAlias().equals(input.getType())) {
          return struc.getUrl();
        }
      }
    }
    return input.getType();
  }

  private String resolveType(String type, String mode, Element map) {
    List<Element> structures = map.getChildrenByName("structure");
    for (Element structure : structures) {
      String alias = structure.getChildValue("alias");
      if ((alias != null && alias.equals(type)) && (mode == null || mode.equals(structure.getNamedChildValue("mode")))) {
        return structure.getChildValue("url");
      }
    }      

    return type;
  }
  
  private StructureMapGroupComponent findDefaultGroup(Element src, String srcType, String tgtType) {    
    List<Element> groups = src.getChildrenByName("group");
    for (Element group : groups) {
      if (Utilities.existsInList(group.getChildValue("typeMode"), "types", "type-and-types")) {
        List<Element> inputs = group.getChildrenByName("input");
        if (inputs.size() == 2 && "source".equals(inputs.get(0).getChildValue("mode")) && "source".equals(inputs.get(0).getChildValue("mode"))) {
          String srcT = resolveInputType(src, inputs.get(0));
          String tgtT = resolveInputType(src, inputs.get(1));
          if (sameTypes(srcT, srcType) && sameTypes(tgtT, tgtType)) {
            return makeGroupComponent(group);
          }
        }
      }
    }
    for (StructureMap map : imports) {
      for (StructureMapGroupComponent grp : map.getGroup()) {
        if ((grp.getTypeMode() == StructureMapGroupTypeMode.TYPES || grp.getTypeMode() == StructureMapGroupTypeMode.TYPEANDTYPES) &&
            grp.getInput().size() == 2 && grp.getInput().get(0).getMode() == StructureMapInputMode.SOURCE && grp.getInput().get(1).getMode() == StructureMapInputMode.TARGET) {
          String srcT = resolveInputType(map, grp.getInput().get(0));
          String tgtT = resolveInputType(map, grp.getInput().get(1));
          if (sameTypes(srcT, srcType) && sameTypes(tgtT, tgtType)) {
            return grp;
          }
        }
      }
    }
    return null;
  }


  private String resolveInputType(StructureMap map, StructureMapGroupInputComponent input) {
    String type = input.getType();
    if (type == null) {
      return null;
    }
    for (StructureMapStructureComponent structure : map.getStructure()) {
      if (type.equals(structure.getAlias())) {
        return structure.getUrl();
      }
    }
    StructureDefinition sd = context.fetchTypeDefinition(type);
    return sd == null ? null : sd.getUrl();
  }

  private String resolveInputType(Element src, Element input) {
    String type = input.getChildValue("type");
    if (type == null) {
      return null;
    }
    for (Element structure : input.getChildren("structure")) {
      if (type.equals(structure.getChildValue("alias"))) {
        return structure.getChildValue("url");
      }
    }
    StructureDefinition sd = context.fetchTypeDefinition(type);
    return sd == null ? null : sd.getUrl();
  }

  private boolean typesMatch(VariableDefn v, String type) {
    if (type == null || !v.hasTypeInfo()) {
      return true;
    } else if (v.getSd().getUrl().equals(type) || v.getSd().getType().equals(type)) {
      return true;
    } else if (v.getType() != null && v.getType().equals(type)) {
      return true;
    } else {
      for (TypeRefComponent tr : v.getEd().getType()) {
        if (type.equals(tr.getWorkingCode()) || type.equals("http://hl7.org/fhir/StructureDefinition/"+tr.getWorkingCode())) {
          return true;
        }
      }
      StructureDefinition tsd = context.fetchTypeDefinition(type);
      if (tsd == null) {
        return false;
      }
      StructureDefinition sd = context.fetchTypeDefinition(v.getType());
      while (sd != null) {
        if (sd.getUrl().equals(tsd.getUrl())) {
          return true;
        }
        sd = context.fetchTypeDefinition(sd.getBaseDefinition());
      }
      return false;
    }
  }

  private VariableDefn getParameter(List<ValidationMessage> errors, Element param, NodeStack pstack, VariableSet variables, StructureMapInputMode mode) {
    if (VersionUtilities.isR5Plus(context.getVersion())) {
      Element v = param.getNamedChild("value");
      if (v.fhirType().equals("id")) {
        return variables.getVariable(v.primitiveValue(), mode == StructureMapInputMode.SOURCE);
      } else {
        String type = v.fhirType();
        StructureDefinition sd = context.fetchTypeDefinition(type);
        return new VariableDefn("$", "source").setType(1, sd, sd.getSnapshot().getElementFirstRep(), null);
      }
    } else {
      return variables.getVariable(param.primitiveValue(), mode == StructureMapInputMode.SOURCE);
    }
  }

}
