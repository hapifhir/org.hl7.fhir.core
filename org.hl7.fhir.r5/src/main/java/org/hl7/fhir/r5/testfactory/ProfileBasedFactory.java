package org.hl7.fhir.r5.testfactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.liquid.BaseTableWrapper;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.profilemodel.PEDefinition;
import org.hl7.fhir.r5.profilemodel.PEType;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.testfactory.TestDataFactory.DataTable;
import org.hl7.fhir.r5.testfactory.dataprovider.BaseDataTableProvider;
import org.hl7.fhir.r5.testfactory.dataprovider.TableDataProvider;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;

/**
 *  
 *  see https://build.fhir.org/ig/FHIR/ig-guidance/testfactory.html for doco
 *  
 */
public class ProfileBasedFactory {

  private BaseDataTableProvider baseData;
  private TableDataProvider data;
  private JsonArray mappings;
  private Map<String, DataTable> tables;
  private FHIRPathEngine fpe;
  private PrintStream log;
  private boolean testing;
  
  private static class LogSet {
    public LogSet(String msg) {
      line.append(msg);
    }
    private StringBuilder line = new StringBuilder();
    private List<String> others = new ArrayList<>();    
  }
  private List<LogSet> logEntries = new ArrayList<>();

  public ProfileBasedFactory(FHIRPathEngine fpe, String baseDataSource) throws JsonException, IOException, SQLException {
    super();
    this.fpe = fpe;
    baseData = new BaseDataTableProvider(baseDataSource);
  }

  public ProfileBasedFactory(FHIRPathEngine fpe, String baseDataSource, TableDataProvider data, Map<String, DataTable> tables, JsonArray mappings) throws JsonException, IOException, SQLException {
    super();
    this.fpe = fpe;
    baseData = new BaseDataTableProvider(baseDataSource);
    this.data = data;
    this.tables = tables;
    this.mappings = mappings;
  }

  public byte[] generateFormat(StructureDefinition profile, FhirFormat format) throws FHIRException, IOException, SQLException {
    PEBuilder builder = new PEBuilder(fpe.getWorker(), PEElementPropertiesPolicy.NONE, true);
    PEDefinition definition = builder.buildPEDefinition(profile);
    Element element = Manager.build(fpe.getWorker(), profile);

    log("--------------------------------");
    log("Build Row "+data.cell("counter")+" for "+profile.getVersionedUrl());
    if (data != null) {
      log("Row Data: "+CommaSeparatedStringBuilder.join(",", data.cells()));
    }
    populateByProfile(element, definition, 0, null, null);
    for (LogSet ls : logEntries) {
      log(ls.line.toString());
      for (String s : ls.others) {
        log("  "+s);
      }
    }
    log("--------------------------------");
    logEntries.clear();
    
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    Manager.compose(fpe.getWorker(), element, ba, format, OutputStyle.PRETTY, null);
    return ba.toByteArray();
  }
  

  public Element generate(StructureDefinition profile) throws FHIRException, IOException, SQLException {
    PEBuilder builder = new PEBuilder(fpe.getWorker(), PEElementPropertiesPolicy.NONE, true);
    PEDefinition definition = builder.buildPEDefinition(profile);
    Element element = Manager.build(fpe.getWorker(), profile);

    log("--------------------------------");
    log("Build Row "+data.cell("counter")+" for "+profile.getVersionedUrl());
    if (data != null) {
      log("Row Data: "+CommaSeparatedStringBuilder.join(",", data.cells()));
    }
    populateByProfile(element, definition, 0, null, null);
    for (LogSet ls : logEntries) {
      log(ls.line.toString());
      for (String s : ls.others) {
        log("  "+s);
      }
    }
    log("--------------------------------");
    logEntries.clear();
    
    return element;
  }
  
  protected void populateByProfile(Element element, PEDefinition definition, int level, String path, Map<String, String> values) throws SQLException, IOException {
    if (definition.types().size() == 1) {
      for (PEDefinition pe : definition.directChildren(true)) {
        if (pe.max() > 0 && (!isIgnoredElement(pe.definition().getBase().getPath()) || pe.hasFixedValue())) {
          populateElement(element, pe, level, path, values);
        }
      }
    }
  }

  private boolean isIgnoredElement(String path) {
    return Utilities.existsInList(path, "Identifier.assigner", "Resource.meta", "DomainResource.text",  "Resource.implicitRules");
  }

  public void populateElement(Element element, PEDefinition pe, int level, String path, Map<String, String> values) throws SQLException, IOException {
    LogSet ls = new LogSet(pe.path()+" : ");
    logEntries.add(ls);
    if (!pe.isExtension() && "Extension".equals(pe.typeSummary())) {      
      ls.line.append("ignore unprofiled extension");
    } else if (pe.isSlicer()) {
      ls.line.append("ignore (slicer)");
    } else if (isNonAbstractType(pe) || pe.hasFixedValue() || pe.definition().getBase().getPath().equals("Resource.id")) {
      if (pe.hasFixedValue()) {
        Element focus = element.addElement(pe.schemaName());
        Base fv = pe.definition().hasPattern() ? pe.definition().getPattern() : pe.definition().getFixed();
        if (fv.isPrimitive()) {
          ls.line.append("fixed value = "+fv.primitiveValue());
          focus.setValue(fv.primitiveValue());
        } else {
          ls.line.append("fixed value = "+new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.NORMAL).composeString((DataType) fv, "data"));
          populateElementFromDataType(focus, fv, null);
        }
      } else {
        if (pe.isSlice() && values != null) {
          values = null;
          ls.others.add("slice, so ignore values from parent");
        }
        makeChildElement(element, pe, level, path, values, ls);
      }
    } else {
      ls.line.append("ignore (type = "+pe.typeSummary()+")");
    }
  }

  private boolean isNonAbstractType(PEDefinition pe) {
    for (PEType t : pe.types()) {
      if (!pe.getBuilder().getContextUtilities().isAbstractType(t.getType()) || Utilities.existsInList(t.getType(), "BackboneElement", "BackboneType")) {
        return true;
      }
    }
    return false;
  }

  public void makeChildElement(Element element, PEDefinition pe, int level, String path, Map<String, String> values, LogSet ls) throws SQLException, IOException {
    Element b = null;
    if (pe.schemaName().endsWith("[x]")) {
      if (pe.types().size() == 1) {
        b = element.makeElement(pe.schemaName().replace("[x]", Utilities.capitalize(pe.types().get(0).getType())));
      } else {
        // we could pick any, but which we pick might be dictated by the value provider 
        String t = getValueType(ls, path, pe.path(), pe.definition().getId(), pe.definition().getPath());
        if (t == null) {
          // all right we just pick one
          t = pe.types().get(testing ? 0 : ThreadLocalRandom.current().nextInt(0, pe.types().size())).getType();
        }
        if (t == null) {
          ls.line.append("ignored because polymorphic and no type");
        } else {
          b = element.makeElement(pe.schemaName().replace("[x]", Utilities.capitalize(t)));          
        }
      }
    } else {
      b = element.makeElement(pe.schemaName());
    }
    if (b != null) {
      if (b.isPrimitive()) {        
        String val = null;
        if (values != null) {
          val = values.get(b.getName());
          if (pe.path().endsWith(".display")) {
            if (!valuesMatch(values.get("system"), b.getNamedChildValue("system")) || !valuesMatch(values.get("code"), b.getNamedChildValue("code"))) {
              val = "";
            }
          }
        }
        if (values == null || val != null || pe.min() > 0) {
          if (val == null && data != null) { 
            val = getPrimitiveValue(ls, b.fhirType(), path, pe.path(), pe.definition().getId(), pe.definition().getPath());
          }
          if (val == null && pe.valueSet() != null) {
            ValueSetExpansionContainsComponent cc = doExpansion(ls, pe.valueSet());
            if (cc != null) {
              val = cc.getCode();
            }
          }
          if (val == null) {
            val = getBasePrimitiveValue(ls, pe, path, b);
          }
          if (val != null) {
            if (Utilities.noString(val)) {
              ls.line.append(" value suppressed");   
              element.removeChild(b);
            } else {
              ls.line.append("from value "+val);
              b.setValue(val);
            }
          } else {
            ls.line.append(" fake value");
            switch (b.fhirType()) {
            case "id": 
              b.setValue(makeUUID());
              break;
            case "string": 
              b.setValue("Some String value");
              break;
            case "base64Binary" : 
              b.setValue(java.util.Base64.getMimeEncoder().encodeToString("Some Binary Value".getBytes(StandardCharsets.UTF_8)));
              break;
            case "boolean" : 
              b.setValue(testing ? "true" : ThreadLocalRandom.current().nextInt(0, 2) == 1 ? "true" : "false");
              break;
            case "date" : 
              b.setValue(new DateType(new Date()).asStringValue());
              break;
            case "dateTime": 
              b.setValue(new DateTimeType(new Date()).asStringValue());
              break;
            case "positiveInt" :
              b.setValue(Integer.toString(testing ? 1 : ThreadLocalRandom.current().nextInt(1, 1000)));
              break;
            case "usignedInt" : 
              b.setValue(Integer.toString(testing ? 2 : ThreadLocalRandom.current().nextInt(0, 1000)));
              break;
            case "url" : 
              b.setValue("http://some.url/path");
              break;

            default:
              ls.others.add("Unhandled type: "+b.fhirType());
            }
          }
        } else {
          ls.line.append(" omitted - not in values");          
        }
      } else {  
        boolean build = true;
        if (values != null) {
          values = filterValues(values, b.getName());
          if (values == null && pe.min() == 0) {
            build = false;
          }
        }
        if (build) {
          if (pe.isExtension()) {
            if (Utilities.isAbsoluteUrl(pe.getExtensionUrl()) || path == null) {
              path = pe.getExtensionUrl();
            } else {
              path = path+"."+pe.getExtensionUrl();
            }
          }
          if (values == null && data != null) {
            values = getComplexValue(ls, b.fhirType(), path, pe.path(), pe.definition().getId(), pe.definition().getPath());
          }
          if (values == null && pe.valueSet() != null) {
            ValueSetExpansionContainsComponent cc = doExpansion(ls, pe.valueSet());
            if (cc != null) {
              values = makeValuesForCodedValue(ls, b.fhirType(), cc);
            }
          }
          if (values == null) {
            if ("Reference".equals(b.fhirType()) && values == null) {
              List<CanonicalType> targets = new ArrayList<>();
              for (TypeRefComponent tr : pe.definition().getType()) {
                if (tr.getWorkingCode().equals("Reference")) {
                  targets.addAll(tr.getTargetProfile());
                }
              }
              List<String> choices = new ArrayList<>();
              for (CanonicalType ct : targets) {
                StructureDefinition sd = fpe.getWorker().fetchResource(StructureDefinition.class, ct.primitiveValue());
                if (!Utilities.existsInList(sd.getType(), "Resource", "DomainResource")) {
                  choices.add(sd.getType());
                }
              }
              if (choices.isEmpty()) {
                choices.addAll(fpe.getWorker().getResourceNames());
              }
              String resType = choices.get(testing ? 0 : ThreadLocalRandom.current().nextInt(0, choices.size()));
              values = new HashMap<String, String>();
              values.put("reference", resType+"/"+makeUUID());
              ls.others.add("construct reference to "+resType+" from choices: "+CommaSeparatedStringBuilder.join("|", choices));
            } else { 
              values = getBaseComplexValue(ls, pe, path, b);
            }
          }
          if (values == null) {
            ls.line.append(" populate children");
          } else if (values.isEmpty()) {
            ls.line.append(" don't populate - no children");            
          } else {
            ls.line.append(" populate children from "+values.toString());            
          }
          if (values == null || !values.isEmpty()) {
            populateByProfile(b, pe, level+1, path, values);
            if (!b.hasChildren() && !b.hasValue()) {
              element.removeChild(b);
            }
          } else {
            element.removeChild(b);
          }
        } else {
          ls.line.append(" omitted - values have no value");
          element.removeChild(b);
        }
      }
    }
  }

  public String makeUUID() {
    return testing ? "6e4d3a43-6642-4a0b-9b67-48c29af581a9" : UUID.randomUUID().toString().toLowerCase();
  }


  private boolean valuesMatch(String v1, String v2) {
    if (v1 == null) {
      return v2 == null;
    } else {
      return v1.equals(v2);
    }
  }

  private boolean hasFixedChildren(PEDefinition definition) {
    if (definition.types().size() != 1) {
      return false;
    }
    for (PEDefinition pe : definition.directChildren(true)) {
      if (pe.hasFixedValue()) {
        return true;
      }
    }
    return false;
  }


  private Map<String, String> makeValuesForCodedValue(LogSet ls, String fhirType, ValueSetExpansionContainsComponent cc) {
    Map<String, String> res = new HashMap<>();
    switch (fhirType) {
    case "Coding":
      res.put("system", cc.getSystem());
      if (cc.hasVersion()) {
        res.put("version", cc.getVersion());
      }
      res.put("code", cc.getCode());
      if (cc.hasDisplay()) {
        res.put("display", cc.getDisplay());
      }
      break;
    case "CodeableConcept":
      res.put("coding.system", cc.getSystem());
      if (cc.hasVersion()) {
        res.put("coding.version", cc.getVersion());
      }
      res.put("coding.code", cc.getCode());
      if (cc.hasDisplay()) {
        res.put("coding.display", cc.getDisplay());
      }
      break;
    case "CodedReference":
      res.put("concept.coding.system", cc.getSystem());
      if (cc.hasVersion()) {
        res.put("concept.coding.version", cc.getVersion());
      }
      res.put("concept.coding.code", cc.getCode());
      if (cc.hasDisplay()) {
        res.put("concept.coding.display", cc.getDisplay());
      }
      break;
    case "Quantity": 
      res.put("system", cc.getSystem());
      res.put("code", cc.getCode());
      if (cc.hasDisplay()) {
        res.put("unit", cc.getDisplay());
      }
      break;
    default: 
      ls.others.add("Unknown type handling coded value: "+fhirType);
      return null;
    }
    return res;
  }

  private ValueSetExpansionContainsComponent doExpansion(LogSet ls, ValueSet vs) {
    ValueSetExpansionOutcome vse = fpe.getWorker().expandVS(vs, true, false, 100);
    if (vse.isOk()) {
      ls.others.add("ValueSet "+vs.getVersionedUrl()+" "+ValueSetUtilities.countExpansion(vse.getValueset().getExpansion().getContains())+" concepts");
      if (testing) {
        for (ValueSetExpansionContainsComponent cc : vse.getValueset().getExpansion().getContains()) {
          ls.others.add(cc.getSystem()+"#"+cc.getCode()+" : \""+cc.getDisplay()+"\" ("+cc.hasContains()+")");   
        }
      }
      return pickRandomConcept(vse.getValueset().getExpansion().getContains());
    } else {
      ls.others.add("ValueSet "+vs.getVersionedUrl()+": error = "+vse.getError());
      return null;
    }
  }

  public Map<String, String> getBaseComplexValue(LogSet ls, PEDefinition pe, String path, Element b) throws SQLException {
    Map<String, String> result = baseData.getComplexValue(path != null ? path : pe.definition().getId(), b.fhirType());
    if (result == null) {
      ls.others.add("No base data for "+path+":"+b.fhirType());
    } else {
      ls.others.add("Base data for "+path+":"+b.fhirType()+" = "+result.toString());
    }
    return result;
  }

  public String getBasePrimitiveValue(LogSet ls, PEDefinition pe, String path, Element b) throws SQLException {
    String result = baseData.getPrimitiveValue(path != null ? path : pe.definition().getId(), b.fhirType());
    if (result == null) {
      ls.others.add("No base data for "+path+":"+b.fhirType());
    } else {
      ls.others.add("Base data for "+path+":"+b.fhirType()+" = "+result);
    }
    return result;
  }


  private Map<String, String> filterValues(Map<String, String> values, String name) {
    Map<String, String> result = new HashMap<>();
    for (String s : values.keySet()) {
      if (s.startsWith(name+".")) {
        result.put(s.substring(name.length()+1), values.get(s));
      }
    }
    if (result.isEmpty()) {      
      return null;
    } else {
      return result;
    }
  }

  private ValueSetExpansionContainsComponent pickRandomConcept(List<ValueSetExpansionContainsComponent> list) {
    ValueSetExpansionContainsComponent res = null;
    int i = 0;
    while (res == null && list.size() > 0) {
      int r = testing ? i : ThreadLocalRandom.current().nextInt(0, list.size());
      if (list.get(r).getAbstract()) {
        if (list.get(r).hasContains()) {
          res = pickRandomConcept(list.get(0).getContains());
        }
      } else {
        res = list.get(r);
      }
      i++;
    }
    return res;
  }

  private void populateElementFromDataType(Element element, Base source, PEDefinition defn) {
    for (Property prop : source.children()) {
      for (Base b : prop.getValues()) {
        Element child = element.makeElement(prop.getName());
        if (b.isPrimitive()) {
          child.setValue(b.primitiveValue());
        } else {
          populateElementFromDataType(child, b, null);
        }
      }
    }    
  }


  private String getValueType(LogSet ls, String... ids) {
    JsonObject entry = findMatchingEntry(ls, ids);
    if (entry != null) {
      JsonElement fhirType = entry.get("fhirType");
      if (fhirType == null || !fhirType.isJsonPrimitive() || Utilities.noString(fhirType.asString())) {
        return "";
      } else {
        String ft = fhirType.asString();
        StructureDefinition sd = fpe.getWorker().fetchTypeDefinition(ft);
        if (sd != null) {
          return ft;
        } else {
          return evaluateExpression(ls.others, fhirType, null);
        }
      }
    }
    return null;    
  }
  
  private String getPrimitiveValue(LogSet ls, String fhirType, String... ids) {
    JsonObject entry = findMatchingEntry(ls, ids);
    if (entry != null) {
      JsonElement expression = entry.get("expression");
      if (expression == null || !expression.isJsonPrimitive() || Utilities.noString(expression.asString())) {
        ls.others.add("Found an entry for "+entry.asString("path")+" but it had no expression");
        return "";
      } else {
        return evaluateExpression(ls.others, expression, null);
      }
    }
    return null;    
  }
  
  public String evaluateExpression(List<String> log, JsonElement expression, String name) {
    ExpressionNode expr = (ExpressionNode) expression.getUserData("compiled");
    if (expr == null) {
      expr = fpe.parse(expression.asString());
      expression.setUserData("compiled", expr);
    }
    BaseTableWrapper csv = BaseTableWrapper.forRow(data.columns(), data.cells()).setTables(tables);
    
    String val = null;
    try {
      val = fpe.evaluateToString(null, null, null, csv, expr);
      log.add(name+" ==> '"+val+"' (from "+expr.toString()+")");
    } catch (Exception e) {
      log.add(name+" ==> null because "+e.getMessage()+" (from "+expr.toString()+")");      
    }
    return val;
  }

  private JsonObject findMatchingEntry(LogSet ls, String[] ids) {
    for (JsonObject entry : mappings.asJsonObjects()) {
      if (Utilities.existsInList(entry.asString("path"), ids)) {
        boolean use = true;
        if (entry.has("if")) {
          use = Utilities.existsInList(evaluateExpression(ls.others, entry.get("if"), "if"), "1", "true");
        }
        if (use) {
          ls.others.add("mapping entry for "+entry.asString("path")+" from ids "+CommaSeparatedStringBuilder.join(";", ids));
          return entry;
        }
      }
    }
    ls.others.add("mapping entry not found for ids "+CommaSeparatedStringBuilder.join(";", ids));
    return null;
  }

  private Map<String, String> getComplexValue(LogSet ls, String fhirType, String... ids) {
    Map<String, String> result = new HashMap<>();
    JsonObject entry = findMatchingEntry(ls, ids);
    if (entry != null) {
      JsonArray a = entry.forceArray("parts");
      if (a.size() == 0) {
        return result;
      } else {
        for (JsonObject src : a.asJsonObjects()) {
          if (!src.has("name")) {
            throw new FHIRException("Found an entry for "+entry.asString("path")+" but it had no proeprty name");            
          } 
          result.put(src.asString("name"), evaluateExpression(ls.others, src.get("expression"), src.asString("name")));
        }
      }
    }
    return result.isEmpty() ? null : result;    
  }


  private void log(String msg) throws IOException {
    if (log != null) {
      log.append(msg+"\r\n");
    }
  }
  
  public PrintStream getLog() {
    return log;
  }

  public void setLog(PrintStream log) {
    this.log = log;
  }

  public boolean isTesting() {
    return testing;
  }

  public void setTesting(boolean testing) {
    this.testing = testing;
    baseData.setTesting(testing);
  }
  
  
}
