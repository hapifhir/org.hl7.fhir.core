package org.hl7.fhir.r5.liquid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.IHostApplicationServices.FunctionDefinition;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.testfactory.TestDataFactory.DataTable;
import org.hl7.fhir.r5.testfactory.dataprovider.TableDataProvider;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;

// this class exists to allow the Liquid Engine to be used against raw JSON

@MarkedToMoveToAdjunctPackage
public class BaseTableWrapper extends Base {


  private static final long serialVersionUID = 1L;
  private List<String> columns;
  private List<String> values;
  private List<List<String>> rows;
  private String value; 
  private Map<String, DataTable> tables;

  private BaseTableWrapper() {
    super();
  }

  public static BaseTableWrapper forRows(List<String> columns, List<List<String>> rows) {
    BaseTableWrapper self = new BaseTableWrapper();
    self.columns = columns;
    self.rows = rows;
    return self;
  }

  public static BaseTableWrapper forRow(List<String> columns, List<String> values) {
    BaseTableWrapper self = new BaseTableWrapper();
    self.columns = columns;
    self.values = values;
    return self;
  }

  public static BaseTableWrapper forCell(String value) {
    BaseTableWrapper self = new BaseTableWrapper();
    self.value = value;
    return self;
  }

  public static BaseTableWrapper forTable(TableDataProvider dt) {
    BaseTableWrapper self = new BaseTableWrapper();
    self.columns = dt.columns();
    self.rows = new ArrayList<>();
    dt.reset();
    while (dt.nextRow()) {
      self.rows.add(dt.cells());
    }
    return self;
  }

  public static BaseTableWrapper forTable(DataTable dt) {
    BaseTableWrapper self = new BaseTableWrapper();
    self.columns = dt.getColumns();
    self.rows = dt.getRows();
    return self;
  }

  public Map<String, DataTable> getTables() {
    return tables;
  }

  public BaseTableWrapper setTables(Map<String, DataTable> tables) {
    this.tables = tables;
    return this;
  }

  @Override
  public String fhirType() {
    if (values != null || rows != null) {
      return "Object";
    } else if (Utilities.existsInList(value, "true", "false")) {
      return "boolean";
    } else if (Utilities.isInteger(value)) {
      return "integer";
    } else if (Utilities.isDecimal(value, true)) {
      return "decimal";
    } else if (Utilities.isAbsoluteUrl(value)) {
      return "url";
    } else {
      return "string";
    }
  }

  @Override
  public String getIdBase() {
    if (columns == null) {
      return null;
    }

    int i = columns.indexOf("id");
    if (i > -1) {
      return values.get(i);
    } else {
      return null;
    }
  }

  @Override
  public void setIdBase(String value) {
    throw new Error("BaseTableWrapper is read only");
  }

  @Override
  public Base copy() {
    throw new Error("BaseTableWrapper is read only");
  }

  @Override
  public FhirPublication getFHIRPublicationVersion() {
    return FhirPublication.R5;
  }

  public String cell(String name) {
    if (values != null) {
      int i = columns.indexOf(name);
      if (i > -1) {
        return values.get(i);
      }
    }
    return null;
  }

  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    if (rows != null && "rows".equals(name)) {
      Base[] l = new Base[rows.size()];
      for (int i = 0; i < rows.size(); i++) {
        l[i] = BaseTableWrapper.forRow(columns, rows.get(i));
      }
      return l;      
    }
    if (values != null) {
      int i = columns.indexOf(name);
      if (i > -1) {
        Base[] l = new Base[1];
        l[0] = BaseTableWrapper.forCell(values.get(i));
        return l;
      }
    } 
    if ("row".equals(name) && values != null) {
      Base[] l = new Base[1];
      l[0] = this;
      return l;
    }
    if (tables != null && tables.containsKey(name)) {
      Base[] l = new Base[1];
      l[0] = BaseTableWrapper.forTable(tables.get(name)).setTables(tables);
      return l;      
    }
    return super.getProperty(hash, name, checkValid);
  }

  @Override
  public String toString() {
    return value;
  }


  @Override  
  public boolean isPrimitive() {
    return value != null;
  }


  @Override 
  public String primitiveValue() {
    return value;
  }

  public static class TableColumnFunction extends FunctionDefinition {

    @Override
    public String name() {
      return "column";
    }

    @Override
    public FunctionDetails details() {
      return new FunctionDetails("Look up a column by name", 1, 1);
    }

    @Override
    public TypeDetails check(FHIRPathEngine engine, Object appContext, TypeDetails focus, List<TypeDetails> parameters) {
      if (focus.hasType("Table")) {
        return new TypeDetails(CollectionStatus.SINGLETON, "string");
      } else {
        return null;
      }
    }

    @Override
    public List<Base> execute(FHIRPathEngine engine, Object appContext, List<Base> focus, List<List<Base>> parameters) {
      List<Base> list = new ArrayList<>();
      if (focus.size() == 1 && focus.get(0) instanceof BaseTableWrapper && parameters.size() == 1 && parameters.get(0).size() == 1) {
        BaseTableWrapper tbl = (BaseTableWrapper) focus.get(0);
        String name = parameters.get(0).get(0).primitiveValue();
        if (tbl.columns.contains(name)) {
          list.add(new StringType(tbl.cell(name)));
        }
      }
      return list;
    }

  }

  public static class TableDateColumnFunction extends FunctionDefinition {

    @Override
    public String name() {
      return "dateColumn";
    }

    @Override
    public FunctionDetails details() {
      return new FunctionDetails("read a date(/time) column with the specified format", 2, 2);
    }

    @Override
    public TypeDetails check(FHIRPathEngine engine, Object appContext, TypeDetails focus, List<TypeDetails> parameters) {
      if (focus.hasType("Table")) {
        return new TypeDetails(CollectionStatus.SINGLETON, "string");
      } else {
        return null;
      }
    }

    @Override
    public List<Base> execute(FHIRPathEngine engine, Object appContext, List<Base> focus, List<List<Base>> parameters) {
      List<Base> list = new ArrayList<>();
      if (focus.size() == 1 && focus.get(0) instanceof BaseTableWrapper && parameters.size() == 2 && parameters.get(0).size() == 1 && parameters.get(1).size() == 1) {
        BaseTableWrapper tbl = (BaseTableWrapper) focus.get(0);
        String name = parameters.get(0).get(0).primitiveValue();
        String format = parameters.get(1).get(0).primitiveValue();
        if (tbl.columns.contains(name)) {
          String cell = tbl.cell(name);
          if (!Utilities.noString(cell)) {
            if ("excel.date".equals(format)) {
              list.add(new StringType(cell.substring(0, 10)));              
            } else {
              try {
                list.add(new StringType(convertToFhirDateTime(cell, format)));
              } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date-time format: " + cell+" for format "+format, e);
              }
            }
          }
        }
      }
      return list;
    }

    public static String convertToFhirDateTime(String dateTime, String inputFormat) {
      DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat, Locale.ENGLISH);
      DateTimeFormatter outputFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME; // For FHIR DateTime with time zone

      if (inputFormat.contains("Z") || inputFormat.contains("x") || inputFormat.contains("X")) {
        ZonedDateTime parsedDateTime = ZonedDateTime.parse(dateTime, inputFormatter);
        return parsedDateTime.format(outputFormatter);
      } else if (inputFormat.contains("h")) {
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime, inputFormatter);
        return parsedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME); // FHIR DateTime without time zone
      } else {
        LocalDate parsedDate = LocalDate.parse(dateTime, inputFormatter);
        return parsedDate.format(DateTimeFormatter.ISO_LOCAL_DATE); // FHIR DateTime without time zone
      }
    }
  }

}
