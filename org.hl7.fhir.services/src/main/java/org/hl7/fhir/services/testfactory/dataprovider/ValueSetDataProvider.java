package org.hl7.fhir.services.testfactory.dataprovider;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.ValueSet.ConceptPropertyComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent;

import java.util.ArrayList;
import java.util.List;


public class ValueSetDataProvider extends TableDataProvider {

  public enum ColumnSpecifierType {
    COUNTER, SYSTEM, VERSION, CODE, DISPLAY, ABSTRACT, INACTIVE, PROPERTY

  }

  public class ColumnSpecifier {

    private String name;
    private ColumnSpecifierType type;
    private String details;

    public ColumnSpecifier(String name, ColumnSpecifierType type) {
     this.name = name;
     this.type = type;
    }

    public ColumnSpecifier(String name, ColumnSpecifierType type, String details) {
      this.name = name;
      this.type = type;
      this.details = details;
    }

  }

  ValueSetExpansionComponent expansion;
  private List<ColumnSpecifier> columns;
  private List<String> columnNames;
  private int cursor;

  public ValueSetDataProvider(ValueSetExpansionComponent expansion) {
    super();
    this.expansion = expansion;
    process();
  }



  private void process() {
    columns = new ArrayList<ColumnSpecifier>();
    columns.add(new ColumnSpecifier("counter", ColumnSpecifierType.COUNTER));
    columns.add(new ColumnSpecifier("system", ColumnSpecifierType.SYSTEM));
    columns.add(new ColumnSpecifier("version", ColumnSpecifierType.VERSION));
    columns.add(new ColumnSpecifier("code", ColumnSpecifierType.CODE));
    columns.add(new ColumnSpecifier("display", ColumnSpecifierType.DISPLAY));
    columns.add(new ColumnSpecifier("abstract", ColumnSpecifierType.ABSTRACT));
    columns.add(new ColumnSpecifier("inactive", ColumnSpecifierType.INACTIVE));
    for (ValueSetExpansionContainsComponent cc : expansion.getContainsList()) {
//      for (ConceptReferenceDesignationComponent d : cc.getDesignation()) {
//        if (!hasColumn(d.getLanguage(), d.getUse())) {
//          
//        }
//      }
      for (ConceptPropertyComponent p : cc.getPropertyList()) {
        if (!hasColumn(ColumnSpecifierType.PROPERTY, p.getCode()) ) {
          columns.add(new ColumnSpecifier("property."+p.getCode(), ColumnSpecifierType.PROPERTY, p.getCode()));
        }
      }
    }
    columnNames = new ArrayList<>();    
    for (ColumnSpecifier sp : columns) {
      columnNames.add(sp.name);
    }
  }

  private boolean hasColumn(ColumnSpecifierType type, String details) {
    for (ColumnSpecifier sp : columns) {
      if (sp.type == type && details.equals(sp.details)) {
        return true;
      }
    }
    return false;
  }



  @Override
  public List<String> columns() {
    return columnNames;
  }

  @Override
  public boolean nextRow() throws FHIRException {
    cursor++;
    return cursor < expansion.getContainsList().size();
  }

  @Override
  public List<String> cells() throws FHIRException {
    List<String> cells = new ArrayList<>();
    ValueSetExpansionContainsComponent cc = expansion.getContainsList().get(cursor);
    for (ColumnSpecifier sp : columns) {
      switch (sp.type) {
      case ABSTRACT:
        cells.add(""+cc.getAbstract());
        break;
      case CODE:
        cells.add(cc.getCode());
        break;
      case COUNTER:
        cells.add(""+cursor);
        break;
      case DISPLAY:
        cells.add(cc.getDisplay());
        break;
      case INACTIVE:
        cells.add(""+cc.getInactive());
        break;
      case PROPERTY:
        for (ConceptPropertyComponent p : cc.getPropertyList()) {
          if (sp.details.equals(p.getCode())) {
            cells.add(p.getValue().primitiveValue());
          }
        }
        break;
      case SYSTEM:
        cells.add(cc.getSystem());
        break;
      case VERSION:
        cells.add(cc.getVersion());
        break;
      default:
        break;
      }
    }
    return cells;
  }

  @Override
  public String cell(String name) throws FHIRException {
    int i = columnNames.indexOf(name);
    return i == -1 ? null : cells().get(i);
  }

  @Override
  public void reset() throws FHIRException {
    cursor = -1;
  }

}
