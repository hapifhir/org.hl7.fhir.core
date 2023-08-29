package org.hl7.fhir.r4b.renderers.spreadsheets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.context.SimpleWorkerContext;
import org.hl7.fhir.r4b.model.CanonicalType;
import org.hl7.fhir.r4b.model.ElementDefinition;
import org.hl7.fhir.r4b.model.ValueSet;
import org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r4b.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.utilities.i18n.I18nConstants;

public class ValueSetSpreadsheetGenerator extends CanonicalSpreadsheetGenerator {

  public ValueSetSpreadsheetGenerator(IWorkerContext context) {
    super(context);
  }

  public boolean canGenerate(ValueSet vs) {
    return true;
  }

  public ValueSetSpreadsheetGenerator renderValueSet(ValueSet vs) throws IOException {
    if (vs == null) {
      System.out.println("no valueset!");
    }
    addValueSetMetadata(renderCanonicalResource(vs), vs);
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      genInclude(vs, inc, "Include");
    }
    for (ConceptSetComponent exc : vs.getCompose().getExclude()) {
      genInclude(vs, exc, "Exclude");
    }
    if (vs.hasExpansion()) {
      if (vs.getExpansion().hasParameter()) {
        genExpansionParams(vs.getExpansion().getParameter());
      }
      genExpansion(vs.getExpansion().getContains());
    }
    return this;
  }

  private void addValueSetMetadata(Sheet sheet, ValueSet vs) {
    addMetadataRow(sheet, "Immutable", vs.getImmutableElement().toString());
  }

  private void genExpansionParams(List<ValueSetExpansionParameterComponent> params) {
    Sheet sheet = makeSheet("Expansion Parameters");
    addHeaders(sheet, "Parameter", "Value");
    for (ValueSetExpansionParameterComponent p : params) {
      addRow(sheet, p.getName(), dr.display(p.getValue()));
    }
  }

  private void genExpansion(List<ValueSetExpansionContainsComponent> list) {
    Sheet sheet = makeSheet("Expansion");
    addHeaders(sheet, "Level", "System", "version", "Code", "Display", "Abstract", "Inactive");
    genExpansionEntry(1, list, sheet);
  }

  public void genExpansionEntry(int level, List<ValueSetExpansionContainsComponent> list, Sheet sheet) {
    for (ValueSetExpansionContainsComponent p : list) {
      addRow(sheet, Integer.toString(level), p.getSystem(), p.getVersion(), p.getCode(), p.getDisplay(),
          bool(p.getAbstract()), bool(p.getInactive()));
      if (p.hasContains()) {
        genExpansionEntry(level + 1, p.getContains(), sheet);
      }
    }
  }

  private String bool(boolean value) {
    return value ? "" : "false";
  }

  private void genInclude(ValueSet vs, ConceptSetComponent inc, String mode) {
    if (inc.hasSystem()) {
      genIncludeSystem(vs, inc, mode);
    } else {
      genIncludeValueSets(vs, inc, mode);
    }
//    String subname = inc.hasSystem() ?  : "ValueSets";
//    
//
//  Row headerRow = sheet.createRow(0);
//  for (int i = 0; i < titles.length; i++) {
//    addCell(headerRow, i, titles[i], styles.get("header"));
//  }
//  int i = titles.length - 1;
//  for (StructureDefinitionMappingComponent map : sd.getMapping()) {
//    i++;
//    addCell(headerRow, i, "Mapping: " + map.getName(), styles.get("header"));
//  }    
//
//  for (ElementDefinition child : sd.getSnapshot().getElement()) {
//    processElement(sheet, sd, child);
//  }
//  configureSheet(sheet, sd);
  }

  private void genIncludeValueSets(ValueSet vs, ConceptSetComponent inc, String mode) {
    Sheet sheet = makeSheet(mode + " ValueSets");
    addValueSets(sheet, inc.getValueSet());
    configureSheet(sheet);
  }

  private void genIncludeSystem(ValueSet vs, ConceptSetComponent inc, String mode) {
    Sheet sheet = makeSheet(mode + " from " + dr.displaySystem(inc.getSystem()));
    if (inc.hasValueSet()) {
      addValueSets(sheet, inc.getValueSet());
    }
    if (inc.hasFilter()) {
      addFilters(sheet, inc.getFilter());
    }
    if (inc.hasConcept()) {
      addConcepts(sheet, inc.getConcept());
    }
    if (!inc.hasConcept() && !inc.hasFilter()) {
      addAllCodes(sheet);
    }
    addRow(sheet, "", "");
    addRow(sheet, "System URI", inc.getSystem());

    configureSheet(sheet);
  }

  private void addAllCodes(Sheet sheet) {
    addHeaders(sheet, "Codes");
    addRow(sheet, "All codes");
  }

  private void addValueSets(Sheet sheet, List<CanonicalType> valueSets) {
    addHeaders(sheet, "ValueSet URL");
    for (CanonicalType u : valueSets) {
      addRow(sheet, u.getValue());
    }
  }

  private void configureSheet(Sheet sheet) {
    sheet.setColumnWidth(0, columnPixels(30));
    sheet.setColumnWidth(1, columnPixels(40));
    sheet.setColumnWidth(1, columnPixels(50));
  }

  private void addConcepts(Sheet sheet, List<ConceptReferenceComponent> concepts) {
    addHeaders(sheet, "Concept", "Description"); // todo: designations
    for (ConceptReferenceComponent cd : concepts) {
      addRow(sheet, cd.getCode(), cd.getDisplay());
    }
  }

  private void addFilters(Sheet sheet, List<ConceptSetFilterComponent> filters) {
    addHeaders(sheet, "Property", "Operation", "Value");
    for (ConceptSetFilterComponent f : filters) {
      addRow(sheet, f.getProperty(), f.getOpElement().asStringValue(), f.getValue());
    }
  }

}
