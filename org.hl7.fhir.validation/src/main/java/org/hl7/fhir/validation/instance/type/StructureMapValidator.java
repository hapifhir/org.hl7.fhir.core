package org.hl7.fhir.validation.instance.type;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.ExpressionNode;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.FHIRLexer.FHIRLexerException;
import org.hl7.fhir.r5.utils.FHIRPathEngine.ElementDefinitionMatch;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.type.StructureMapValidator.ElementDefinitionSource;
import org.hl7.fhir.validation.instance.type.StructureMapValidator.RuleInformation;
import org.hl7.fhir.validation.instance.type.StructureMapValidator.VariableDefn;
import org.hl7.fhir.validation.instance.type.StructureMapValidator.VariableSet;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.jvnet.jaxb2_commons.xml.bind.annotation.adapters.CommaDelimitedStringAdapter;

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


  }

  private static final boolean SOURCE = true;
  private static final boolean TARGET = false;

  private FHIRPathEngine fpe;
  private ProfileUtilities profileUtilities;
  private ContextUtilities cu;
  private List<StructureMap> imports = new ArrayList<>();

  public StructureMapValidator(IWorkerContext context, TimeTracker timeTracker, FHIRPathEngine fpe, XVerExtensionManager xverManager, ProfileUtilities profileUtilities, Coding jurisdiction) {
    super(context, xverManager);
    source = Source.InstanceValidator;
    this.fpe = fpe;
    this.timeTracker = timeTracker;
    this.jurisdiction = jurisdiction;
    this.profileUtilities = profileUtilities;
    this.cu = new ContextUtilities(context);

  }
  
  public boolean validateStructureMap(List<ValidationMessage> errors, Element src, NodeStack stack)  {
    boolean ok = true;
    List<Element> imports = src.getChildrenByName("import");
    int cc = 0;
    for (Element import_ : imports) {
      ok = validateImport(errors, src, import_, stack.push(import_, cc, null, null)) && ok;
      cc++;
    }
    
    List<Element> groups = src.getChildrenByName("group");
    cc = 0;
    for (Element group : groups) {
      ok = validateGroup(errors, src, group, stack.push(group, cc, null, null)) && ok;
      cc++;
    }      
    return ok;
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

  private boolean validateGroup(List<ValidationMessage> errors, Element src, Element group, NodeStack stack) {
    String name = group.getChildValue("name");
    boolean ok = rule(errors, "2023-03-01", IssueType.INVALID, group.line(), group.col(), stack.getLiteralPath(), idIsValid(name), I18nConstants.SM_NAME_INVALID, name);
    
    Element extend = group.getNamedChild("extends");
    if (extend != null) {
      StructureMapGroupComponent grp = resolveGroup(extend.primitiveValue(), src);
      if (rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, extend.line(), extend.col(), stack.push(extend, -1, null, null).getLiteralPath(), grp != null, I18nConstants.SM_RULEGROUP_NOT_FOUND, extend.primitiveValue())) {
        // check inputs 
      } else {
        ok = false;
      }
    }
    
    VariableSet variables = new VariableSet(); 

    // first, load all the inputs
    List<Element> inputs = group.getChildrenByName("input");
    List<Element> structures = src.getChildrenByName("structure");
    int cc = 0;
    for (Element input : inputs) {
      ok = validateInput(errors, src, group, input, stack.push(input, cc, null, null), structures, variables) && ok;
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

  private StructureMapGroupComponent resolveGroup(String grpName, Element src) {
    if (grpName == null) {
      return null;
    }
    List<Element> groups = src.getChildrenByName("group");
    for (Element group : groups) {
      String name = group.getChildValue("name");
      if (grpName.equals(name)) {
        return makeGroupComponent(group);
      }
    }  
    for (StructureMap map : imports) {
      for (StructureMapGroupComponent grp : map.getGroup()) {
        if (grpName.equals(grp.getName())) {
          return grp;
        }
      }
    }
    return null;
  }

  private StructureMapGroupComponent makeGroupComponent(Element group) {
    StructureMapGroupComponent grp = new StructureMapGroupComponent();
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

  private boolean validateInput(List<ValidationMessage> errors, Element src, Element group, Element input, NodeStack stack, List<Element> structures, VariableSet variables) {
    boolean ok = false;
    String name = input.getChildValue("name"); 
    String type = input.getChildValue("type"); 
    String mode = input.getChildValue("mode"); 

    if (rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, input.line(), input.col(), stack.getLiteralPath(), idIsValid(name), I18nConstants.SM_NAME_INVALID, name) &&  // the name {0} is not valid)
        rule(errors, "2023-03-01", IssueType.DUPLICATE, input.line(), input.col(), stack.getLiteralPath(), !variables.hasVariable(name), I18nConstants.SM_GROUP_INPUT_DUPLICATE, name)) {  // the name {0} is not valid)      
      VariableDefn v = variables.add(name, mode);
      if (rule(errors, "2023-03-01", IssueType.INVALID, input.line(), input.col(), stack.getLiteralPath(), Utilities.existsInList(mode, "source", "target"), I18nConstants.SM_GROUP_INPUT_MODE_INVALID, name, mode) && // the group parameter {0} mode {1} isn't valid
          warning(errors, "2023-03-01", IssueType.NOTSUPPORTED, input.line(), input.col(), stack.getLiteralPath(), type != null, I18nConstants.SM_GROUP_INPUT_NO_TYPE, name)) { // the group parameter {0} has no type, so the paths cannot be validated
        Element structure = findStructure(structures, type);
        if (rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, input.line(), input.col(), stack.getLiteralPath(), structure != null, I18nConstants.SM_GROUP_INPUT_TYPE_NOT_DECLARED, type)) { // the type {0} was not declared and is unknown
          String url = structure.getChildValue("url");
          String smode = structure.getChildValue("mode");
          StructureDefinition sd = context.fetchResource(StructureDefinition.class, url);
          if (rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, input.line(), input.col(), stack.getLiteralPath(), mode.equals(smode), I18nConstants.SM_GROUP_INPUT_MODE_MISMATCH, type, mode, smode) && // the type {0} has mode {1} which doesn't match the structure definition {2}
            rule(errors, "2023-03-01", IssueType.INVALID, input.line(), input.col(), stack.getLiteralPath(), sd != null, I18nConstants.SM_GROUP_INPUT_TYPE_UNKNOWN, type, url)) { // the type {0} which maps to the canonical URL {1} is not known, so the paths cannot be validated
            v.setType(1, sd, sd.getSnapshot().getElementFirstRep(), null);
            ok = true;
          }
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
      ok = validateRuleSource(errors, src, group, rule, source, stack.push(source, cc, null, null), lvars, ruleInfo) && ok;
      cc++;
    }
    // process the targets
    List<Element> targets = rule.getChildrenByName("target");
    cc = 0;
    for (Element target : targets) {
      ok = validateRuleTarget(errors, src, group, rule, target, stack.push(target, cc, null, null), lvars, ruleInfo) && ok;
      cc++;
    }
    
    // process the targets
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

  private boolean validateRuleSource(List<ValidationMessage> errors, Element src, Element group, Element rule, Element source, NodeStack stack, VariableSet variables, RuleInformation ruleInfo) {
    String context = source.getChildValue("context");
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
        }
        // check condition
        // check check
      }
    }
    return ok;
  }

  private boolean hasType(ElementDefinition ed, String type) {
    for (TypeRefComponent td : ed.getType()) {
      if (type.equals(td.getWorkingCode())) {
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
            if (warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), els.size() == 1, I18nConstants.SM_TARGET_PATH_MULTIPLE_MATCHES, context, element, v.getEd().getPath()+"."+element, render(els))) {
              ElementDefinitionSource el = els.get(0);
              String type = null; // maybe inferred / derived from transform in the future
              String transform = target.getChildValue("transform");
              List<Element> params = target.getChildren("parameter");
              if (transform == null) {
                rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() == 0, I18nConstants.SM_TARGET_NO_TRANSFORM_NO_CHECKED, transform);
              } else {
                switch (transform) {
                case "create":
                  if (rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), params.size() < 2, I18nConstants.SM_TARGET_TRANSFORM_PARAM_COUNT_RANGE, "create", "0", "1", params.size())) {
                    if (params.size() == 1) {
                      type = params.get(0).primitiveValue();
                      warning(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(),type != null, I18nConstants.SM_TARGET_TRANSFORM_TYPE_UNPROCESSIBLE);
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
                    String exp = params.get(0).primitiveValue();
                    if (rule(errors, "2023-03-01", IssueType.INVALID, params.get(0).line(), params.get(0).col(), stack.getLiteralPath(), exp != null, I18nConstants.SM_TARGET_TRANSFORM_PARAM_UNPROCESSIBLE, "0", params.size())) {
                      try {
                        TypeDetails td = fpe.check(null, v.getSd().getType(), v.getEd().getPath(), fpe.parse(exp));
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
                default:
                  rule(errors, "2023-03-01", IssueType.INVALID, target.line(), target.col(), stack.getLiteralPath(), false, I18nConstants.SM_TARGET_TRANSFORM_NOT_CHECKED, transform);
                  ok = false;
                }
              }
//todo: transform / parameter
              if (vn != null) {
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
          result.add(new ElementDefinitionSource(sd, t));
        }
      }
    }
    return result;
  }

  private void getElementDefinitionChildrenFromTypes(List<ElementDefinitionSource> result, StructureDefinition sd, ElementDefinition ed, String type, String element) {
    for (TypeRefComponent td : ed.getType()) {
      if (type == null | td.getWorkingCode().equals(type)) {
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


  private boolean validateDependent(List<ValidationMessage> errors, Element src, Element group, Element dependent, NodeStack stack, VariableSet lvars) {
    boolean ok = true;
    String name = dependent.getChildValue("name");
    StructureMapGroupComponent grp = resolveGroup(name, src);
    if (rule(errors, "2023-03-01", IssueType.NOTSUPPORTED, dependent.line(), dependent.col(), stack.push(dependent, -1, null, null).getLiteralPath(), grp != null, I18nConstants.SM_RULEGROUP_NOT_FOUND, name)) {
      // check inputs 
    } else {
      ok = false;
    }
    return ok;
  }

}
