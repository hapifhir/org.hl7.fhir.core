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
import org.hl7.fhir.r4b.model.CodeSystem;
import org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r4b.model.ElementDefinition;
import org.hl7.fhir.r4b.model.Enumeration;
import org.hl7.fhir.r4b.model.Enumerations.FilterOperator;
import org.hl7.fhir.r4b.model.ValueSet;
import org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r4b.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.i18n.I18nConstants;

public class CodeSystemSpreadsheetGenerator extends CanonicalSpreadsheetGenerator {

  public CodeSystemSpreadsheetGenerator(IWorkerContext context) {
    super(context);
  }

  public boolean canGenerate(CodeSystem cs) {
    return true;
  }

  public CodeSystemSpreadsheetGenerator renderCodeSystem(CodeSystem cs) throws IOException {
    if (cs == null) {
      System.out.println("no code system!");
    }
    addCodeSystemMetadata(renderCanonicalResource(cs), cs);
    
    if (cs.hasProperty()) {
      addProperties(cs.getProperty());
    }
    if (cs.hasFilter()) {
      addFilters(cs.getFilter());
    }
    if (cs.hasConcept()) {
      addConcepts(cs.getConcept());
    }
    return this;
  }

  private void addCodeSystemMetadata(Sheet sheet, CodeSystem cs) {
    addMetadataRow(sheet, "Case Sensitive", cs.getCaseSensitiveElement().asStringValue());
    addMetadataRow(sheet, "Value Set (all codes)", cs.getValueSet());
    addMetadataRow(sheet, "Hierarchy", cs.getHierarchyMeaningElement().asStringValue());
    addMetadataRow(sheet, "Compositional", cs.getCompositionalElement().asStringValue());
    addMetadataRow(sheet, "Version Needed?", cs.getVersionNeededElement().asStringValue());
    addMetadataRow(sheet, "Content", cs.getContentElement().asStringValue());
    addMetadataRow(sheet, "Supplements", cs.getSupplements());
    addMetadataRow(sheet, "Count", cs.getCountElement().asStringValue());
  }
  
  private void addFilters(List<CodeSystemFilterComponent> filters) {
    Sheet sheet = makeSheet("Filters");
    addHeaders(sheet, "Code", "Description", "Operators", "Value");
    for (CodeSystemFilterComponent f : filters) {
      CommaSeparatedStringBuilder cs = new CommaSeparatedStringBuilder();
      for (Enumeration<FilterOperator> op : f.getOperator()) {
        cs.append(op.asStringValue());
      }
      addRow(sheet, f.getCode(), f.getDescription(), cs.toString(), f.getValue());
    }        
  }

  private void addProperties(List<PropertyComponent> properties) {
    Sheet sheet = makeSheet("Properties");
    addHeaders(sheet, "Code", "Uri", "Description", "Type");
    for (PropertyComponent p : properties) {
      addRow(sheet, p.getCode(), p.getUri(), p.getDescription(), p.getTypeElement().asStringValue());
    }    
  }

  private void addConcepts(List<ConceptDefinitionComponent> concepts) {
    Sheet sheet = makeSheet("Concepts");
    addHeaders(sheet, "Level", "Code", "Display", "Definition"); //todo: properties and designations
    addConcepts(sheet, 1, concepts);    
  }

  private void addConcepts(Sheet sheet, int i, List<ConceptDefinitionComponent> concepts) {
    for (ConceptDefinitionComponent c : concepts) {
      addRow(sheet, Integer.toString(i), c.getCode(), c.getDisplay(), c.getDefinition());
      if (c.hasConcept()) {
        addConcepts(sheet, i+1, c.getConcept());
      }
    }    
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
      addRow(sheet, Integer.toString(level), p.getSystem(), p.getVersion(), p.getCode(), p.getDisplay(), bool(p.getAbstract()), bool(p.getInactive()));  
      if (p.hasContains()) {
        genExpansionEntry(level + 1, p.getContains(), sheet);
      }
    }
  }
  
  private String bool(boolean value) {    
    return value ? "" : "false";
  }

//  private void genInclude(ValueSet vs, ConceptSetComponent inc, String mode) {
//    if (inc.hasSystem()) {
//      genIncludeSystem(vs, inc, mode);
//    } else {
//      genIncludeValueSets(vs, inc, mode);      
//    }
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
//  }

//  private void genIncludeValueSets(ValueSet vs, ConceptSetComponent inc, String mode) {
//    Sheet sheet = makeSheet(mode+" ValueSets");
//    addValueSets(sheet, inc.getValueSet()); 
//    configureSheet(sheet);
//  }
//
//  private void genIncludeSystem(ValueSet vs, ConceptSetComponent inc, String mode) {
//    Sheet sheet = makeSheet(mode+" from "+dr.displaySystem(inc.getSystem()));
//    if (inc.hasValueSet()) {
//      addValueSets(sheet, inc.getValueSet());
//    }
//    if (inc.hasFilter()) {
//      addFilters(sheet, inc.getFilter());
//    }
//    if (inc.hasConcept()) {
//      addConcepts(sheet, inc.getConcept());
//    }
//    if (!inc.hasConcept() && !inc.hasFilter()) {
//      addAllCodes(sheet);
//    }
//    addRow(sheet, "", "");          
//    addRow(sheet, "System URI", inc.getSystem());          
//    
//    configureSheet(sheet);
//  }

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
