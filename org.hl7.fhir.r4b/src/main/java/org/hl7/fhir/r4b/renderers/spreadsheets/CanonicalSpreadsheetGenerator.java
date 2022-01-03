package org.hl7.fhir.r4b.renderers.spreadsheets;

import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.model.CanonicalResource;
import org.hl7.fhir.r4b.model.CodeableConcept;
import org.hl7.fhir.r4b.model.ContactDetail;
import org.hl7.fhir.r4b.model.ElementDefinition;
import org.hl7.fhir.r4b.model.Identifier;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.r4b.renderers.DataRenderer;

public class CanonicalSpreadsheetGenerator extends SpreadsheetGenerator {

  public CanonicalSpreadsheetGenerator(IWorkerContext context) {
    super(context);
  }

  protected Sheet renderCanonicalResource(CanonicalResource cr) {
    Sheet sheet = makeSheet("Metadata");

    Row headerRow = sheet.createRow(0);
    addCell(headerRow, 0, "Property", styles.get("header"));
    addCell(headerRow, 1, "Value", styles.get("header"));

    addMetadataRow(sheet, "URL", cr.getUrl());
    for (Identifier id : cr.getIdentifier()) {
      addMetadataRow(sheet, "Identifier", dr.display(id));
    }
    addMetadataRow(sheet, "Version", cr.getVersion());
    addMetadataRow(sheet, "Name", cr.getName());
    addMetadataRow(sheet, "Title", cr.getTitle());
    addMetadataRow(sheet, "Status", cr.getStatusElement().asStringValue());
    addMetadataRow(sheet, "Experimental", cr.getExperimentalElement().asStringValue());
    addMetadataRow(sheet, "Date", cr.getDateElement().asStringValue());
    addMetadataRow(sheet, "Publisher", cr.getPublisher());
    for (ContactDetail c : cr.getContact()) {
      addMetadataRow(sheet, "Contact", dr.display(c));
    }
    for (CodeableConcept j : cr.getJurisdiction()) {
      addMetadataRow(sheet, "Jurisdiction", dr.display(j));
    }

    addMetadataRow(sheet, "Description", cr.getDescription());
    addMetadataRow(sheet, "Purpose", cr.getPurpose());
    addMetadataRow(sheet, "Copyright", cr.getCopyright());
    configureSheet(sheet);
    return sheet;
  }

  private void configureSheet(Sheet sheet) {
    sheet.setColumnWidth(0, columnPixels(15));
    sheet.setColumnWidth(1, columnPixels(80));
  }

  protected void addMetadataRow(Sheet sheet, String name, String value) {
    Row row = sheet.createRow(sheet.getLastRowNum()+1);
    addCell(row, 0, name, styles.get("body"));
    addCell(row, 1, value);
  }


  
}
