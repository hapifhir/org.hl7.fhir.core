package org.hl7.fhir.r5.formats;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.ZipGenerator;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvFormat {

  public static void main(String[] args) throws Exception {
  }
  private final JsonParser json = new JsonParser();
  private final Map<String, Integer> codingsCache = new HashMap<>();

  public void compose(File folder, String baseName, CodeSystem cs) throws FHIRFormatError, IOException {
    ZipGenerator zip = new ZipGenerator(Utilities.path(folder, baseName + ".zip"));

    // -1-metadata
    CSVWriter metadata = new CSVWriter(false);
    metadata.headings("Field", "Value");
    metadata.line("url", cs.getUrl());
    metadata.line("version", cs.getVersion());
    metadata.line("language", cs.getLanguage());
    metadata.line("name", cs.getName());
    metadata.line("title", cs.getTitle());
    metadata.line("status", cs.getStatus().toCode());
    metadata.line("experimental", cs.getExperimentalElement().primitiveValue());
    metadata.line("date", cs.getDateElement().primitiveValue());
    metadata.line("caseSensitive", cs.getCaseSensitiveElement().primitiveValue());
    metadata.line("valueSet", cs.getValueSet());
    metadata.line("hierarchyMeaning", cs.getHierarchyMeaningElement().primitiveValue());
    metadata.line("compositional", cs.getCompositionalElement().primitiveValue());
    metadata.line("versionNeeded", cs.getVersionNeededElement().primitiveValue());
    metadata.line("content", cs.getContentElement().primitiveValue());
    metadata.line("supplements", cs.getSupplements());
    metadata.line("count", ""+cs.getCount());
    CodeSystem cst = cs.copyHeader();
    cst.setText(null);
    String json = new JsonParser().setOutputStyle(IParser.OutputStyle.NORMAL).composeString(cst);
    metadata.line("json", json);
    metadata.close();
    zip.addBytes("1-metadata.csv", metadata.close(), false);

    CSVWriter codings = new CSVWriter(true);
    codings.headings("System", "Version", "Code", "Display");

    CSVWriter extensions = new CSVWriter(true);
    extensions.headings("Table", "TableKey", "TableColumn", "URL", "Type", "Value");

    CSVWriter filters = new CSVWriter(true);
    filters.headings("Code", "Description", "Value", "Operators");
    for (CodeSystem.CodeSystemFilterComponent filter : cs.getFilter()) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("|");
      for (Enumeration<Enumerations.FilterOperator> op : filter.getOperator()) {
        b.append(op.primitiveValue());
      }
      filters.line(filter.getCode(), filter.getDescription(), filter.getValue(), b.toString());
      encodeExtensions(extensions, filter, "filter", filters.lineCount, null);
      encodeExtensions(extensions, filter.getCodeElement(), "filter", filters.lineCount, "code");
      encodeExtensions(extensions, filter.getDescriptionElement(), "filter", filters.lineCount, "description");
      encodeExtensions(extensions, filter.getValueElement(), "filters", filters.lineCount, "Value");
    }
    zip.addBytes("3-filters.csv", filters.close(), false);
    filters.close();

    CSVWriter properties = new CSVWriter(true);
    properties.headings("Code", "Uri", "Description", "Type", "Column");
    for (CodeSystem.PropertyComponent prop : cs.getProperty()) {
      int count = surveyCodeSystemProperties(cs.getConcept(), prop.getCode());
      if (count == 1) {
        properties.line(prop.getCode(), prop.getUri(), prop.getDescription(), prop.getTypeElement().primitiveValue(), "P-"+prop.getCode());
        prop.setUserData(UserDataNames.db_column, "P-"+prop.getCode());
      } else {
        properties.line(prop.getCode(), prop.getUri(), prop.getDescription(), prop.getTypeElement().primitiveValue());
      }
      encodeExtensions(extensions, prop, "properties", properties.lineCount, null);
      encodeExtensions(extensions, prop.getCodeElement(), "properties", properties.lineCount, "Code");
      encodeExtensions(extensions, prop.getUriElement(), "properties", properties.lineCount, "Uri");
      encodeExtensions(extensions, prop.getDescriptionElement(), "properties", properties.lineCount, "Description");
      encodeExtensions(extensions, prop.getTypeElement(), "properties", properties.lineCount, "Type");
    }
    zip.addBytes("4-properties.csv", properties.close(), false);

    List<String> headers = new ArrayList<>();
    headers.add("Code");
    headers.add("Parent");
    headers.add("Display");
    headers.add("Definition");
    for (CodeSystem.PropertyComponent prop : cs.getProperty()) {
      String col = prop.getUserString(UserDataNames.db_column);
      if (col != null) {
        headers.add(col);
      }
    }

    CSVWriter concepts = new CSVWriter(true);
    concepts.headings(headers.toArray(new String[headers.size()]));

    properties = new CSVWriter(true);
    properties.headings("Code", "Value", "ValueCoding");

    CSVWriter designations = new CSVWriter(true);
    designations.headings("Language", "Use", "AdditionalUse", "Value");

    for (CodeSystem.ConceptDefinitionComponent concept : cs.getConcept()) {
      composeConcept(cs, concept, null, concepts, properties, designations, codings, extensions);
    }

    zip.addBytes("2-codings.csv", codings.close(), false);
    zip.addBytes("5-concepts.csv", concepts.close(), false);
    zip.addBytes("6-concept-properties.csv", properties.close(), false);
    zip.addBytes("7-designations.csv", designations.close(), false);
    zip.addBytes("8-extensions.csv", extensions.close(), false);
    zip.close();
  }

  private void encodeExtensions(CSVWriter extensions, Element element, String table, int tableKey, String tableColumn) throws IOException {
    if (element instanceof BackboneElement) {
      if (((BackboneElement) element).hasModifierExtension()) {
        throw new FHIRFormatError("Modifier Extensions are not supported in the CSV format");
      }
    }
    if (element instanceof BackboneType) {
      if (((BackboneType) element).hasModifierExtension()) {
        throw new FHIRFormatError("Modifier Extensions are not supported in the CSV format");
      }
    }
    for (Extension ext : element.getExtension()) {
      if (ext.getValue() == null) {
        int line = extensions.line(table, ""+tableKey, tableColumn, ext.getUrl(), ext.getValue().fhirType(), null);
        encodeExtensions(extensions, ext, "extensions", line, null);
      } else if (ext.getValue() instanceof PrimitiveType<?>) {
        extensions.line(table, ""+tableKey, tableColumn, ext.getUrl(), ext.getValue().fhirType(), ext.getValue().primitiveValue());
      } else {
        extensions.line(table, ""+tableKey, tableColumn, ext.getUrl(), ext.getValue().fhirType(), json.composeString(ext.getValue(), ext.getValue().fhirType()));
      }
    }
  }

  private void composeConcept(CodeSystem cs, CodeSystem.ConceptDefinitionComponent concept, CodeSystem.ConceptDefinitionComponent parent,
                           CSVWriter concepts, CSVWriter properties, CSVWriter designations, CSVWriter codings, CSVWriter extensions) throws IOException {
    int ckey = concepts.cells(concept.getCode(), parent == null ? null : ""+parent.getUserInt(UserDataNames.db_key), concept.getDisplay(), concept.getDefinition());
    concept.setUserData(UserDataNames.db_key, ckey);
    encodeExtensions(extensions, concept, "concepts", ckey, null);
    encodeExtensions(extensions, concept.getCodeElement(), "concepts", ckey, "Code");
    encodeExtensions(extensions, concept.getDisplayElement(), "concepts", ckey, "Display");
    encodeExtensions(extensions, concept.getDefinitionElement(), "concepts", ckey, "Definition");

    for (CodeSystem.ConceptDefinitionDesignationComponent d : concept.getDesignation()) {
      designations.line(d.getLanguage(), ""+coding(d.getUse(), codings, extensions), null, d.getValue());
      encodeExtensions(extensions, d, "designations", ckey, null);
      encodeExtensions(extensions, d.getLanguageElement(), "designations", ckey, "Language");
      encodeExtensions(extensions, d.getValueElement(), "designations", ckey, "Value");
    }

    List<CodeSystem.ConceptPropertyComponent> handled = new ArrayList<>();
    for (CodeSystem.PropertyComponent prop : cs.getProperty()) {
      String col = prop.getUserString(UserDataNames.db_column);
      if (col != null) {
        CodeSystem.ConceptPropertyComponent pv = CodeSystemUtilities.getProperty(concept, prop.getCode());
        if (pv != null) {
          handled.add(pv);
          concepts.cell(pv.getValue().primitiveValue());
        } else {
          concepts.cell("");
        }
      }
    }
    concepts.closeLine();

    for (CodeSystem.ConceptPropertyComponent pv : concept.getProperty()) {
      if (!handled.contains(pv)) {
        if (pv.getValue() instanceof Coding) {
          properties.line(pv.getCode(), null, ""+coding((Coding) pv.getValue(), codings, extensions));
        } else {
          properties.line(pv.getCode(), pv.getValue().primitiveValue(), null);
          encodeExtensions(extensions, pv.getValue(), "concept-properties", properties.lineCount, "value");
        }
        encodeExtensions(extensions, pv, "concept-properties", properties.lineCount, null);
      }
    }

    for (CodeSystem.ConceptDefinitionComponent c : concept.getConcept()) {
      composeConcept(cs, c, concept, concepts, properties, designations, codings, extensions);
    }
  }

  private int coding(Coding c, CSVWriter codings, CSVWriter extensions) throws IOException {
    String key = json.composeString(c, "Coding");
    if (codingsCache.containsKey(key)) {
      return codingsCache.get(key);
    }
    codings.line(c.getSystem(), c.getVersion(), c.getCode(), c.getDisplay());
    encodeExtensions(extensions, c, "Codings", codings.lineCount, null);
    encodeExtensions(extensions, c.getSystemElement(), "Codings", codings.lineCount, "System");
    encodeExtensions(extensions, c.getVersionElement(), "Codings", codings.lineCount, "Version");
    encodeExtensions(extensions, c.getCodeElement(), "Codings", codings.lineCount, "Code");
    encodeExtensions(extensions, c.getDisplayElement(), "Codings", codings.lineCount, "Display");
    codingsCache.put(key, codings.lineCount);
    return codings.lineCount;
    // extensions
  }

  private int surveyCodeSystemProperties(List<CodeSystem.ConceptDefinitionComponent> concept, String code) {
    int count = 0;
    for (CodeSystem.ConceptDefinitionComponent ct : concept) {
      for (CodeSystem.ConceptPropertyComponent p : ct.getProperty()) {
        int c = 0;
        if (p.getValue() != null && p.getCode().equals(code)) {
          if (p.getValue() instanceof Coding || p.getValue().hasExtension()) {
            return -1;
          } else {
            c++;
          }
        }
        count = Integer.max(count, c);
      }
      count = Integer.max(count, surveyCodeSystemProperties(ct.getConcept(), code));
    }
    return count;
  }

  private class CSVWriter {
    private int lineCount = 0;
    private boolean autoKey;
    private Writer writer;
    private int colCount = 0;
    private ByteArrayOutputStream stream;

    public CSVWriter(boolean autoKey) {
      this.autoKey = autoKey;
      this.stream = new ByteArrayOutputStream();
      this.writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8);
    }

    /**
     * Escapes a cell value according to CSV rules:
     * - Enclose in quotes if contains comma, quote, newline, or carriage return
     * - Double any quotes within the value
     */
    private String escapeCell(String cell) {
      if (cell == null) {
        return "";
      }
      // Check if escaping is needed
      if (cell.contains(",") || cell.contains("\"") ||
        cell.contains("\n") || cell.contains("\r")) {
        // Escape double quotes by doubling them
        cell = cell.replace("\r", "\\r");
        cell = cell.replace("\n", "\\n");
        String escaped = cell.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
      }
      return cell;
    }

    public void headings(String... cells) throws IOException {
      if (autoKey) {
        writer.write("Key");
        colCount++;
      }
      writeCells(cells);
      closeLine();
    }

    public int line(String... cells) throws IOException {
      lineCount++; // Increment when line starts being written
      if (autoKey) {
        writer.write(String.valueOf(lineCount));
        colCount++;
      }
      writeCells(cells);
      closeLine();
      return lineCount;
    }

    public int cells(String... cells) throws IOException {
      lineCount++; // Increment when line starts being written
      if (autoKey) {
        writer.write(String.valueOf(lineCount));
        colCount++;
      }
      writeCells(cells);
      return lineCount;
    }

    public int writeCells(String... cells) throws IOException {
      for (int i = 0; i < cells.length; i++) {
        if (colCount > 0) {
          writer.write(",");
        }
        if (!Utilities.noString(cells[i])) {
          writer.write(escapeCell(cells[i]));
        }
        colCount++;
      }
      return lineCount;
    }

    public byte[] close() throws IOException {
      if (writer != null) {
        writer.close();
      }
      return stream.toByteArray();
    }

    public void cell(String s) throws IOException {
      writeCells(s);
    }

    public void closeLine() throws IOException {
      writer.write("\r\n");
      writer.flush();
      colCount = 0;
    }
  }

}
