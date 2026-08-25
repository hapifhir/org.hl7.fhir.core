package org.hl7.fhir.services.renderers.spreadsheets;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.ContactDetail;
import org.hl7.fhir.model.core.Identifier;
import org.hl7.fhir.services.renderers.RendererFactory;



public class CanonicalSpreadsheetGenerator extends SpreadsheetGenerator {

  public CanonicalSpreadsheetGenerator(IWorkerContext context, RendererFactory renderer) {
    super(context, renderer);
  }

  protected Sheet renderCanonicalResource(CanonicalResource cr, boolean forMultiple) {
    Sheet sheet = forMultiple && hasSheet("Metadata") ? getSheet("Metadata") : makeSheet("Metadata");

    Row headerRow = sheet.createRow(forMultiple ? sheet.getLastRowNum()+1 : 0);
    addCell(headerRow, 0, "Property", styles.get("header"));
    addCell(headerRow, 1, "Value", styles.get("header"));

    if (forMultiple) {
      addMetadataRow(sheet, "ID", cr.getId());      
    }
    addMetadataRow(sheet, "URL", cr.getUrl());
    for (Identifier id : cr.getIdentifierList()) {
      addMetadataRow(sheet, "Identifier", dr.displayDataType(id));
    }
    addMetadataRow(sheet, "Version", cr.getVersion());
    addMetadataRow(sheet, "Name", cr.getName());
    addMetadataRow(sheet, "Title", cr.getTitle());
    addMetadataRow(sheet, "Status", cr.getStatusElement().asStringValue());
    addMetadataRow(sheet, "Experimental", cr.getExperimentalElement().asStringValue());
    addMetadataRow(sheet, "Date", cr.getDateElement().asStringValue());
    addMetadataRow(sheet, "Publisher", cr.getPublisher());
    for (ContactDetail c : cr.getContactList()) {
      addMetadataRow(sheet, "Contact", dr.displayDataType(c));
    }
    for (CodeableConcept j : cr.getJurisdictionList()) {
      addMetadataRow(sheet, "Jurisdiction", dr.displayDataType(j));
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
