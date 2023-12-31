package org.hl7.fhir.r5.utils.sql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.util.Base64;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Base64BinaryType;
import org.hl7.fhir.r5.model.BaseDateTimeType;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.validation.ValidationMessage;


public class Runner implements IEvaluationContext {
  private IWorkerContext context;
  private Provider provider;
  private Storage storage;
  private List<String> prohibitedNames = new ArrayList<String>();
  private FHIRPathEngine fpe;

  private String resourceName;
  private List<ValidationMessage> issues;


  public IWorkerContext getContext() {
    return context;
  }
  public void setContext(IWorkerContext context) {
    this.context = context;
  }


  public Provider getProvider() {
    return provider;
  }
  public void setProvider(Provider provider) {
    this.provider = provider;
  }

  public Storage getStorage() {
    return storage;
  }
  public void setStorage(Storage storage) {
    this.storage = storage;
  }

  public List<String> getProhibitedNames() {
    return prohibitedNames;
  }

  public void execute(JsonObject viewDefinition) {
    execute("$", viewDefinition);
  }

  public void execute(String path, JsonObject viewDefinition) {
    if (context == null) {
      throw new FHIRException("No context provided");
    }
    fpe = new FHIRPathEngine(context);
    fpe.setHostServices(this);
    fpe.setEmitSQLonFHIRWarning(true);
    if (viewDefinition == null) {
      throw new FHIRException("No viewDefinition provided");
    }
    if (provider == null) {
      throw new FHIRException("No provider provided");
    }
    if (storage == null) {
      throw new FHIRException("No storage provided");
    }
    Validator validator = new Validator(context, fpe, prohibitedNames, storage.supportsArrays(), storage.supportsComplexTypes(), storage.needsName());
    validator.checkViewDefinition(path, viewDefinition);
    issues = validator.getIssues();
    validator.dump();
    validator.check();
    resourceName = validator.getResourceName();
    evaluate(viewDefinition);
  }

  private void evaluate(JsonObject vd) {
    Store store = storage.createStore(vd.asString("name"), (List<Column>) vd.getUserData("columns"));

    List<Base> data = provider.fetch(resourceName);

    for (Base b : data) {
      boolean ok = true;
      for (JsonObject w : vd.getJsonObjects("where")) {
        String expr = w.asString("path");
        ExpressionNode node = fpe.parse(expr);
        boolean pass = fpe.evaluateToBoolean(null, b, b, b, node);
        if (!pass) {
          ok = false;
          break;
        }  
      }
      if (ok) {
        List<List<Cell>> rows = new ArrayList<>();
        rows.add(new ArrayList<Cell>());

        for (JsonObject select : vd.getJsonObjects("select")) {
          executeSelect(select, b, rows);
        }
        for (List<Cell> row : rows) {
          storage.addRow(store, row);
        }
      }
    }
    storage.finish(store);
  }
  
  private void executeSelect(JsonObject select, Base b, List<List<Cell>> rows) {
    List<Base> focus = new ArrayList<>();
    
    if (select.has("forEach")) {
      focus.addAll(executeForEach(select, b));
    } else if (select.has("forEachOrNull")) {
      
      focus.addAll(executeForEachOrNull(select, b));  
      if (focus.isEmpty()) {
        List<Column> columns = (List<Column>) select.getUserData("columns");
        for (List<Cell> row : rows) {
          for (Column c : columns) {
            Cell cell = cell(row, c.getName());
            if (cell == null) {
              row.add(new Cell(c, null));
            }
          }
        }
        return;
      }
    } else {
      focus.add(b);
    }

//  } else if (select.has("unionAll")) {
//    focus.addAll(executeUnion(select, b));

    List<List<Cell>> tempRows = new ArrayList<>();
    tempRows.addAll(rows);
    rows.clear();

    for (Base f : focus) {
      List<List<Cell>> rowsToAdd = cloneRows(tempRows);  

      for (JsonObject column : select.getJsonObjects("column")) {
        executeColumn(column, f, rowsToAdd);
      }

      for (JsonObject sub : select.getJsonObjects("select")) {
        executeSelect(sub, f, rowsToAdd);
      }
      
      executeUnionAll(select.getJsonObjects("unionAll"), f, rowsToAdd);
      
      rows.addAll(rowsToAdd);
    }
  }

  private void executeUnionAll(List<JsonObject> unionList,  Base b, List<List<Cell>> rows) {
    if (unionList.isEmpty()) {
      return;
    }
    List<List<Cell>> sourceRows = new ArrayList<>();
    sourceRows.addAll(rows);
    rows.clear();

    for (JsonObject union : unionList) {
      List<List<Cell>> tempRows = new ArrayList<>();
      tempRows.addAll(sourceRows);      
      executeSelect(union, b, tempRows);
      rows.addAll(tempRows);
    }
  }

  private List<List<Cell>> cloneRows(List<List<Cell>> rows) {
    List<List<Cell>> list = new ArrayList<>();
    for (List<Cell> row : rows) {
      list.add(cloneRow(row));
    }
    return list;
  }
  
  private List<Cell> cloneRow(List<Cell> cells) {
    List<Cell> list = new ArrayList<>();
    for (Cell cell : cells) {
      list.add(cell.copy());
    }
    return list;
  }

  private List<Base> executeForEach(JsonObject focus, Base b) {
    ExpressionNode n = (ExpressionNode) focus.getUserData("forEach");
    List<Base> result = new ArrayList<>();
    result.addAll(fpe.evaluate(b, n));
    return result;  
  }

  private List<Base> executeForEachOrNull(JsonObject focus, Base b) {
    ExpressionNode n = (ExpressionNode) focus.getUserData("forEachOrNull");
    List<Base> result = new ArrayList<>();
    result.addAll(fpe.evaluate(b, n));
    return result;  
  }

  private void executeColumn(JsonObject column, Base b, List<List<Cell>> rows) {
    ExpressionNode n = (ExpressionNode) column.getUserData("path");
    List<Base> bl2 = new ArrayList<>();
    if (b != null) {
      bl2.addAll(fpe.evaluate(b, n));
    }
    Column col = (Column) column.getUserData("column");
    if (col == null) {
      System.out.println("Error");
    } else {
      for (List<Cell> row : rows) {
        Cell c = cell(row, col.getName());
        if (c == null) {
          c = new Cell(col);
          row.add(c);
        }      
        if (!bl2.isEmpty()) {
          if (bl2.size() + c.getValues().size() > 1) {
            // this is a problem if collection != true or if the storage can't deal with it 
            // though this should've been picked up before now - but there are circumstances where it wouldn't be
            if (!c.getColumn().isColl()) {
              throw new FHIRException("The column "+c.getColumn().getName()+" is not allowed multiple values, but at least one row has multiple values");
            }
          }
          for (Base b2 : bl2) {
            c.getValues().add(genValue(c.getColumn(), b2));
          }
        }
      }
    }
  }


  private Value genValue(Column column, Base b) {
    if (column.getKind() == null) {
      throw new FHIRException("Attempt to add a type "+b.fhirType()+" to an unknown column type (null) for column "+column.getName()); // can't happen
    }
    switch (column.getKind()) {
    case Binary:
      if (b instanceof Base64BinaryType) {
        Base64BinaryType bb = (Base64BinaryType) b;
        return Value.makeBinary(bb.primitiveValue(), bb.getValue());
      } else if (b.isBooleanPrimitive()) { // ElementModel
        return Value.makeBinary(b.primitiveValue(), Base64.decodeBase64(b.primitiveValue()));
      } else {
        throw new FHIRException("Attempt to add a type "+b.fhirType()+" to a binary column for column "+column.getName());
      }
    case Boolean:
      if (b instanceof BooleanType) {
        BooleanType bb = (BooleanType) b;
        return Value.makeBoolean(bb.primitiveValue(), bb.booleanValue());
      } else if (b.isBooleanPrimitive()) { // ElementModel
        return Value.makeBoolean(b.primitiveValue(), "true".equals(b.primitiveValue()));
      } else {
        throw new FHIRException("Attempt to add a type "+b.fhirType()+" to a boolean column for column "+column.getName());
      }
    case Complex:
      if (b.isPrimitive()) {
        throw new FHIRException("Attempt to add a primitive type "+b.fhirType()+" to a complex column for column "+column.getName());
      } else {
        return Value.makeComplex(b);
      }
    case DateTime:
      if (b instanceof BaseDateTimeType) {
        BaseDateTimeType d = (BaseDateTimeType) b;
        return Value.makeDate(d.primitiveValue(), d.getValue());
      } else if (b.isPrimitive() && b.isDateTime()) { // ElementModel
        return Value.makeDate(b.primitiveValue(), b.dateTimeValue().getValue());
      } else {
        throw new FHIRException("Attempt to add a type "+b.fhirType()+" to an integer column for column "+column.getName());
      }
    case Decimal:
      if (b instanceof DecimalType) {
        DecimalType d = (DecimalType) b;
        return Value.makeDecimal(d.primitiveValue(), d.getValue());
      } else if (b.isPrimitive()) { // ElementModel
        return Value.makeDecimal(b.primitiveValue(), new BigDecimal(b.primitiveValue()));
      } else {
        throw new FHIRException("Attempt to add a type "+b.fhirType()+" to an integer column for column "+column.getName());
      }
    case Integer:
      if (b instanceof IntegerType) {
        IntegerType i = (IntegerType) b;
        return Value.makeInteger(i.primitiveValue(), i.getValue());
      } else if (b.isPrimitive()) { // ElementModel
        return Value.makeInteger(b.primitiveValue(), Integer.valueOf(b.primitiveValue()));
      } else {
        throw new FHIRException("Attempt to add a type "+b.fhirType()+" to an integer column for column "+column.getName());
      }
    case String: 
      if (b.isPrimitive()) {
        return Value.makeString(b.primitiveValue());
      } else {
        throw new FHIRException("Attempt to add a complex type "+b.fhirType()+" to a string column for column "+column.getName());
      }
    case Time:
      if (b.fhirType().equals("time")) {
        return Value.makeString(b.primitiveValue());
      } else {
        throw new FHIRException("Attempt to add a type "+b.fhirType()+" to a time column for column "+column.getName());
      }
    default:
      throw new FHIRException("Attempt to add a type "+b.fhirType()+" to an unknown column type for column "+column.getName());
    }
  }
  
  private Column column(String columnName, List<Column> columns) {
    for (Column t : columns) {
      if (t.getName().equalsIgnoreCase(columnName)) {
        return t;
      }
    }
    return null;
  }

  private Cell cell(List<Cell> cells, String columnName) {
    for (Cell t : cells) {
      if (t.getColumn().getName().equalsIgnoreCase(columnName)) {
        return t;
      }
    }
    return null;
  }
  
  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, boolean beforeContext, boolean explicitConstant) throws PathEngineException {
    throw new Error("Not implemented yet: resolveConstant");
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, boolean explicitConstant) throws PathEngineException {
    throw new Error("Not implemented yet: resolveConstantType");
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    throw new Error("Not implemented yet: log");
  }

  @Override
  public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    switch (functionName) {
    case "getResourceKey" : return new FunctionDetails("Unique Key for resource", 0, 0);
    case "getReferenceKey" : return new FunctionDetails("Unique Key for resource that is the target of the reference", 0, 1);
    default:  return null;
    }
  }
  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
    switch (functionName) {
    case "getResourceKey" : return new TypeDetails(CollectionStatus.SINGLETON, "string");
    case "getReferenceKey" : return new TypeDetails(CollectionStatus.SINGLETON, "string");
    default: throw new Error("Not known: "+functionName);
    }
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    switch (functionName) {
    case "getResourceKey" : return executeResourceKey(focus);
    case "getReferenceKey" : return executeReferenceKey(null, focus, parameters);
    default: throw new Error("Not known: "+functionName);
    }
  }

  private List<Base> executeResourceKey(List<Base> focus) {
    List<Base> base = new ArrayList<Base>();
    if (focus.size() == 1) {
      Base res = focus.get(0);
      if (!res.hasUserData("Storage.key")) {
        String key = storage.getKeyForSourceResource(res);
        if (key == null) {
          throw new FHIRException("Unidentified resource: "+res.fhirType()+"/"+res.getIdBase());
        } else {
          res.setUserData("Storage.key", key);
        }
      }
      base.add(new StringType(res.getUserString("Storage.key")));
    }
    return base;
  }
  
  private List<Base> executeReferenceKey(Base rootResource, List<Base> focus, List<List<Base>> parameters) {
    String rt = null;
    if (parameters.size() > 0) {
      rt = parameters.get(0).get(0).primitiveValue();
      if (rt.startsWith("FHIR.")) {
        rt = rt.substring(5);
      }
    }
    List<Base> base = new ArrayList<Base>();
    if (focus.size() == 1) {
      Base res = focus.get(0);
      String ref = null;
      if (res.fhirType().equals("Reference")) {
        ref = getRef(res);
      } else if (res.isPrimitive()) {
        ref = res.primitiveValue();
      } else {
        throw new FHIRException("Unable to generate a reference key based on a "+res.fhirType());
      }
      if (ref !=  null) {
        Base target = provider.resolveReference(rootResource, ref, rt);
        if (target != null) {
          if (!res.hasUserData("Storage.key")) {
            String key = storage.getKeyForTargetResource(target);
            if (key == null) {
              throw new FHIRException("Unidentified resource: "+res.fhirType()+"/"+res.getIdBase());
            } else {
              res.setUserData("Storage.key", key);
            }
          }
          base.add(new StringType(res.getUserString("Storage.key")));
        }
      }
    }
    return base;
  }

  private String getRef(Base res) {
    Property prop = res.getChildByName("reference");
    if (prop != null && prop.getValues().size() == 1) {
      return prop.getValues().get(0).primitiveValue();
    }
    return null;
  }
  
  @Override
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext) throws FHIRException {
    throw new Error("Not implemented yet: resolveReference");
  }

  @Override
  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException {
    throw new Error("Not implemented yet: conformsToProfile");
  }

  @Override
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
    throw new Error("Not implemented yet: resolveValueSet");
  }
  @Override
  public boolean paramIsType(String name, int index) {
    return "getReferenceKey".equals(name);
  }
  public List<ValidationMessage> getIssues() {
    return issues;
  }


}
