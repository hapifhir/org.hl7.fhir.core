package org.hl7.fhir.r5.utils.sql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.IHostApplicationServices;
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
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.validation.ValidationMessage;


/**
 * How to use the Runner:
 * 
 * create a resource, and fill out:
 *   the context (supports the FHIRPathEngine)
 *   a store that handles the output 
 *   a tracker - if you want
 *   
 * Once it's created, you either run it as a batch, or in trickle mode
 * 
 *   (1) Batch Mode
 *   
 *    * provide a provider 
 *    * call execute() with a ViewDefinition
 *    * wait... (watch with an observer if you want to track progress)
 *   
 *   (2) Trickle Mode
 *    * call 'prepare', and keep the WorkContext that's returned
 *    * each time there's a resource to process, call processResource and pass in the workContext and the resource
 *    * when done, call finish(WorkContext)
 */

@MarkedToMoveToAdjunctPackage
@Slf4j
public class Runner implements IHostApplicationServices {
  
  public interface IRunnerObserver {
    public void handleRow(Base resource, int total, int cursor);
  }
  
  public class WorkContext {
    private JsonObject vd;
    private Store store;
    protected WorkContext(JsonObject vd) {
      super();
      this.vd = vd;
    }
    
  }
  private IWorkerContext context;
  private Provider provider;
  private Storage storage;
  private IRunnerObserver observer;
  private List<String> prohibitedNames = new ArrayList<String>();
  private FHIRPathEngine fpe;

  private String resourceName;
  private List<ValidationMessage> issues;
  private int resCount;


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
    WorkContext wc = prepare(path, viewDefinition);
    try {
      evaluate(wc);
    } finally {
      finish(wc);
    }
  }

  private void evaluate(WorkContext wc) {
    List<Base> data = provider.fetch(resourceName);

    int i = 0;
    for (Base b : data) {
      if (observer != null) {
        observer.handleRow(b, data.size(), i);
      }
      processResource(wc.vd, wc.store, b);
      i++;
    }
  }

  public WorkContext prepare(String path, JsonObject viewDefinition) {
    WorkContext wc = new WorkContext(viewDefinition);
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
    wc.store = storage.createStore(wc.vd.asString("name"), (List<Column>) wc.vd.getUserData(UserDataNames.db_columns));
    return wc;
  }
  
  public void processResource(WorkContext wc, Base b) {
    if (observer != null) {
      observer.handleRow(b, -1, resCount);
    }
    processResource(wc.vd, wc.store, b);
    resCount++;
    wc.store.flush();
  }
  
  private void processResource(JsonObject vd, Store store, Base b) {
    boolean ok = true;
    for (JsonObject w : vd.getJsonObjects("where")) {
      String expr = w.asString("path");
      ExpressionNode node = fpe.parse(expr);
      boolean pass = fpe.evaluateToBoolean(vd, b, b, b, node);
      if (!pass) {
        ok = false;
        break;
      }  
    }
    if (ok) {
      List<List<Cell>> rows = new ArrayList<>();
      rows.add(new ArrayList<Cell>());

      for (JsonObject select : vd.getJsonObjects("select")) {
        executeSelect(vd, select, b, rows);
      }
      for (List<Cell> row : rows) {
        storage.addRow(store, row);
      }
    }
  }
  
  public void finish(WorkContext wc) {
    storage.finish(wc.store);
  }

  private void executeSelect(JsonObject vd, JsonObject select, Base b, List<List<Cell>> rows) {
    List<Base> focus = new ArrayList<>();

    if (select.has("forEach")) {
      focus.addAll(executeForEach(vd, select, b));
    } else if (select.has("forEachOrNull")) {

      focus.addAll(executeForEachOrNull(vd, select, b));  
      if (focus.isEmpty()) {
        List<Column> columns = (List<Column>) select.getUserData(UserDataNames.db_columns);
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
        executeColumn(vd, column, f, rowsToAdd);
      }

      for (JsonObject sub : select.getJsonObjects("select")) {
        executeSelect(vd, sub, f, rowsToAdd);
      }

      executeUnionAll(vd, select.getJsonObjects("unionAll"), f, rowsToAdd);

      rows.addAll(rowsToAdd);
    }
  }

  private void executeUnionAll(JsonObject vd, List<JsonObject> unionList,  Base b, List<List<Cell>> rows) {
    if (unionList.isEmpty()) {
      return;
    }
    List<List<Cell>> sourceRows = new ArrayList<>();
    sourceRows.addAll(rows);
    rows.clear();

    for (JsonObject union : unionList) {
      List<List<Cell>> tempRows = new ArrayList<>();
      tempRows.addAll(sourceRows);      
      executeSelect(vd, union, b, tempRows);
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

  private List<Base> executeForEach(JsonObject vd, JsonObject focus, Base b) {
    ExpressionNode n = (ExpressionNode) focus.getUserData(UserDataNames.db_forEach);
    List<Base> result = new ArrayList<>();
    result.addAll(fpe.evaluate(vd, b, n));
    return result;  
  }

  private List<Base> executeForEachOrNull(JsonObject vd, JsonObject focus, Base b) {
    ExpressionNode n = (ExpressionNode) focus.getUserData(UserDataNames.db_forEachOrNull);
    List<Base> result = new ArrayList<>();
    result.addAll(fpe.evaluate(vd, b, n));
    return result;  
  }

  private void executeColumn(JsonObject vd, JsonObject column, Base b, List<List<Cell>> rows) {
    ExpressionNode n = (ExpressionNode) column.getUserData(UserDataNames.db_path);
    List<Base> bl2 = new ArrayList<>();
    if (b != null) {
      bl2.addAll(fpe.evaluate(vd, b, n));
    }
    Column col = (Column) column.getUserData(UserDataNames.db_column);
    if (col == null) {
      log.error("Error");
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
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    List<Base> list = new ArrayList<Base>();
    if (mode == FHIRPathConstantEvaluationMode.EXPLICIT) {
      JsonObject vd = (JsonObject) appContext;
      JsonObject constant = findConstant(vd, name);
      if (constant != null) {
        Base b = (Base) constant.getUserData(UserDataNames.db_value);
        if (b != null) {
          list.add(b);
        }
      }
    }
    return list;    
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    if (mode == FHIRPathConstantEvaluationMode.EXPLICIT) {
      if (appContext instanceof JsonObject) {
        JsonObject vd = (JsonObject) appContext;
        JsonObject constant = findConstant(vd, name);
        if (constant != null) {
          Base b = (Base) constant.getUserData(UserDataNames.db_value);
          if (b != null) {
            return new TypeDetails(CollectionStatus.SINGLETON, b.fhirType());
          }
        }
      } else if (appContext instanceof Element) {
        Element vd = (Element) appContext;
        Element constant = findConstant(vd, name);
        if (constant != null) {
          Element v = constant.getNamedChild("value");
          if (v != null) {
            return new TypeDetails(CollectionStatus.SINGLETON, v.fhirType());
          }
        }
      }
    }
    return null;
  }

  private JsonObject findConstant(JsonObject vd, String name) {
    for (JsonObject o : vd.getJsonObjects("constant")) {
      if (name.equals(o.asString("name"))) {
        return o;
      }
    }
    return null;
  }

  private Element findConstant(Element vd, String name) {
    for (Element o : vd.getChildren("constant")) {
      if (name.equals(o.getNamedChildValue("name"))) {
        return o;
      }
    }
    return null;
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
      if (!res.hasUserData(UserDataNames.Storage_key)) {
        String key = storage.getKeyForSourceResource(res);
        if (key == null) {
          throw new FHIRException("Unidentified resource: "+res.fhirType()+"/"+res.getIdBase());
        } else {
          res.setUserData(UserDataNames.Storage_key, key);
        }
      }
      base.add(new StringType(res.getUserString(UserDataNames.Storage_key)));
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
          if (!res.hasUserData(UserDataNames.Storage_key)) {
            String key = storage.getKeyForTargetResource(target);
            if (key == null) {
              throw new FHIRException("Unidentified resource: "+res.fhirType()+"/"+res.getIdBase());
            } else {
              res.setUserData(UserDataNames.Storage_key, key);
            }
          }
          base.add(new StringType(res.getUserString(UserDataNames.Storage_key)));
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


  public Base findContainingResource(Object appContext, Base item) {
    return null;
  }
}
