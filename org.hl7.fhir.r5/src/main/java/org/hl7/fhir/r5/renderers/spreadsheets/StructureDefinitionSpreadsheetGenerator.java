package org.hl7.fhir.r5.renderers.spreadsheets;

import java.io.IOException;
import java.io.OutputStream;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.i18n.I18nConstants;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.common.reflection.qual.ForName;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.AggregationMode;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextStreamWriter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomFilters;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilterColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilters;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFilterOperator;


public class StructureDefinitionSpreadsheetGenerator extends CanonicalSpreadsheetGenerator {
  private XmlParser xml = new XmlParser();
  private JsonParser json = new JsonParser();
  private boolean asXml;
  private boolean hideMustSupportFalse;
  private List<StructureDefinitionMappingComponent> mapKeys = new ArrayList<StructureDefinitionMappingComponent>();

  private static String[] titles = {
      "ID", "Path", "Slice Name", "Alias(s)", "Label", "Min", "Max", "Must Support?", "Is Modifier?", "Is Summary?", "Type(s)", "Short", 
      "Definition", "Comments", "Requirements", "Default Value", "Meaning When Missing", "Fixed Value", "Pattern", "Example",
      "Minimum Value", "Maximum Value", "Maximum Length", "Binding Strength", "Binding Description", "Binding Value Set", "Code",
      "Slicing Discriminator", "Slicing Description", "Slicing Ordered", "Slicing Rules", "Base Path", "Base Min", "Base Max",
      "Condition(s)", "Constraint(s)"};

  public StructureDefinitionSpreadsheetGenerator(IWorkerContext context, boolean valuesAsXml, boolean hideMustSupportFalse) {
    super(context);
    this.asXml = valuesAsXml;
    this.hideMustSupportFalse = hideMustSupportFalse;
  }

  public StructureDefinitionSpreadsheetGenerator renderStructureDefinition(StructureDefinition sd, boolean forMultiple) throws Exception {
    if (sd == null) {
      System.out.println("no structure!");
    }
    if (!sd.hasSnapshot()) {
      throw new DefinitionException(context.formatMessage(I18nConstants.NEEDS_A_SNAPSHOT));
    }
    addStructureDefinitionMetadata(renderCanonicalResource(sd, forMultiple), sd);
    Sheet sheet = forMultiple && hasSheet("Elements") ? getSheet("Elements") : makeSheet("Elements");

    if (sheet.getPhysicalNumberOfRows() == 0) {
      Row headerRow = sheet.createRow(0);
      int coffset = forMultiple ? 1 : 0;
      for (int i = 0; i < titles.length; i++) {
        if (forMultiple) {
          addCell(headerRow, 0, "Structure.ID", styles.get("header"));        
        }
        addCell(headerRow, i+coffset, titles[i], styles.get("header"));
      }
      if (!forMultiple) {
        int i = titles.length - 1;
        for (StructureDefinitionMappingComponent map : sd.getMapping()) {
          i++;
          addCell(headerRow, i+coffset, "Mapping: " + map.getName(), styles.get("header"));
        }
      }
    }

    for (ElementDefinition child : sd.getSnapshot().getElement()) {
      processElement(sheet, sd, child, forMultiple);
    }
    if (!forMultiple) {
      configureSheet(sheet, sd);
    }
    return this;
  }
  
  public StructureDefinitionSpreadsheetGenerator configure() throws Exception {
    Sheet sheet = hasSheet("Elements") ? getSheet("Elements") : makeSheet("Elements");
    configureSheet(sheet, null);
    return this;
  }


  private void addStructureDefinitionMetadata(Sheet sheet, StructureDefinition sd) {
    for (Coding k : sd.getKeyword()) {
      addMetadataRow(sheet, "Keyword", dr.display(k));
    }
    addMetadataRow(sheet, "FHIR Version", sd.getFhirVersionElement().asStringValue());
    addMetadataRow(sheet, "Kind", sd.getKindElement().asStringValue());
    addMetadataRow(sheet, "Type", sd.getType());
    addMetadataRow(sheet, "Base Definition", sd.getBaseDefinition());
    addMetadataRow(sheet, "Abstract", sd.getAbstractElement().asStringValue());
    addMetadataRow(sheet, "Derivation", sd.getDerivationElement().asStringValue());

    for (StructureDefinitionContextComponent k : sd.getContext()) {
      addMetadataRow(sheet, "Context", k.getTypeElement().asStringValue()+":"+k.getExpression());
    }
    for (StringType k : sd.getContextInvariant()) {
      addMetadataRow(sheet, "Context Inv.", k.getValue());
    }
    
  }

  public void processElement(Sheet sheet, StructureDefinition sd, ElementDefinition ed, boolean forMultiple) throws Exception {
    Row row = sheet.createRow(sheet.getLastRowNum()+1);
    int i = 0;
    if (forMultiple) {
      addCell(row, i++, sd.getId(), styles.get("body"));
    }
    addCell(row, i++, ed.getId(), styles.get("body"));
    addCell(row, i++, ed.getPath());
    addCell(row, i++, ed.getSliceName());
    addCell(row, i++, itemList(ed.getAlias()));
    addCell(row, i++, ed.getLabel());
    addCell(row, i++, ed.getMin());
    addCell(row, i++, ed.getMax());
    addCell(row, i++, ed.getMustSupport() ? "Y" : "");
    addCell(row, i++, ed.getIsModifier() ? "Y" : "");
    addCell(row, i++, ed.getIsSummary() ? "Y" : "");
    addCell(row, i++, itemList(ed.getType()));
    addCell(row, i++, ed.getShort());
    addCell(row, i++, ed.getDefinition());
    addCell(row, i++, ed.getComment());
    addCell(row, i++, ed.getRequirements());
    addCell(row, i++, ed.getDefaultValue()!=null ? renderType(ed.getDefaultValue()) : "");
    addCell(row, i++, ed.getMeaningWhenMissing());
    addCell(row, i++, ed.hasFixed() ? renderType(ed.getFixed()) : "");
    addCell(row, i++, ed.hasPattern() ? renderType(ed.getPattern()) : "");
    addCell(row, i++, ed.hasExample() ? renderType(ed.getExample().get(0).getValue()) : ""); // todo...?
    addCell(row, i++, ed.hasMinValue() ? renderType(ed.getMinValue()) : "");
    addCell(row, i++, ed.hasMaxValue() ? renderType(ed.getMaxValue()) : "");
    addCell(row, i++, (ed.hasMaxLength() ? Integer.toString(ed.getMaxLength()) : ""));
    if (ed.hasBinding()) {
      addCell(row, i++, ed.getBinding().getStrength()!=null ? ed.getBinding().getStrength().toCode() : "");
      addCell(row, i++, ed.getBinding().getDescription());
      if (ed.getBinding().getValueSet()==null)
        addCell(row, i++, "");
      else
        addCell(row, i++, ed.getBinding().getValueSet());
    } else {
      addCell(row, i++, "");
      addCell(row, i++, "");
      addCell(row, i++, "");
    }
    addCell(row, i++, itemList(ed.getCode()));
    if (ed.hasSlicing()) {
      addCell(row, i++, itemList(ed.getSlicing().getDiscriminator()));
      addCell(row, i++, ed.getSlicing().getDescription());
      addCell(row, i++, ed.getSlicing().getOrdered());
      addCell(row, i++, ed.getSlicing().getRules()!=null ? ed.getSlicing().getRules().toCode() : "");
    } else {
      addCell(row, i++, "");
      addCell(row, i++, "");
      addCell(row, i++, "");      
      addCell(row, i++, "");      
    }
    if (ed.getBase()!=null) {
      addCell(row, i++, ed.getBase().getPath());
      addCell(row, i++, ed.getBase().getMin());
      addCell(row, i++, ed.getBase().getMax());
    } else {
      addCell(row, i++, "");
      addCell(row, i++, "");
      addCell(row, i++, "");      
    }
    addCell(row, i++, itemList(ed.getCondition()));
    addCell(row, i++, itemList(ed.getConstraint()));
    if (!forMultiple) {
      for (StructureDefinitionMappingComponent mapKey : sd.getMapping()) {
        String mapString = "";
        for (ElementDefinitionMappingComponent map : ed.getMapping()) {
          if (map.getIdentity().equals(mapKey.getIdentity()))
            mapString = map.getMap();        
        }
        addCell(row, i++, mapString);
      }
    }
  }

  private String itemList(List l) {
    StringBuilder s = new StringBuilder();
    for (int i =0; i< l.size(); i++) {
      Object o = l.get(i);
      String val = "";
      if (o instanceof StringType) {
        val = ((StringType)o).getValue();
      } else if (o instanceof UriType) {
        val = ((UriType)o).getValue();
      } else if (o instanceof IdType) {
        val = ((IdType)o).getValue();
      } else if (o instanceof Enumeration<?>) {
        val = o.toString();
      } else if (o instanceof TypeRefComponent) {
        TypeRefComponent t = (TypeRefComponent)o;
        val = t.getWorkingCode();
        if (val == null)
          val = "";
        if (val.startsWith("http://hl7.org/fhir/StructureDefinition/"))
          val = val.substring(40);
        if (t.hasTargetProfile()) 
          val = val+ "(" + canonicalList(t.getTargetProfile()) + ")";
        if (t.hasProfile())
          val = val + " {" + canonicalList(t.getProfile()) + "}";
        if (t.hasAggregation()) 
          val = val + " <<" + aggList(t.getAggregation()) + ">>";
      } else if (o instanceof Coding) {
        Coding t = (Coding)o;
        val = (t.getSystem()==null ? "" : t.getSystem()) + (t.getCode()==null ? "" : "#" + t.getCode()) + (t.getDisplay()==null ? "" : " (" + t.getDisplay() + ")");
      } else if (o instanceof ElementDefinitionConstraintComponent) {
        ElementDefinitionConstraintComponent c = (ElementDefinitionConstraintComponent)o;
        val = c.getKey() + ":" + c.getHuman() + " {" + c.getExpression() + "}";
      } else if (o instanceof ElementDefinitionSlicingDiscriminatorComponent) {
        ElementDefinitionSlicingDiscriminatorComponent c = (ElementDefinitionSlicingDiscriminatorComponent)o;
        val = c.getType().toCode() + ":" + c.getPath() + "}";

      } else {
        val = o.toString();
        val = val.substring(val.indexOf("[")+1);
        val = val.substring(0, val.indexOf("]"));
      }
      s = s.append(val);
      if (i == 0)
        s.append("\n");
    }
    return s.toString();
  }

  private String aggList(List<org.hl7.fhir.r5.model.Enumeration<AggregationMode>> list) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (org.hl7.fhir.r5.model.Enumeration<AggregationMode> c : list)
      b.append(c.getValue().toCode());
    return b.toString();
  }

  private String canonicalList(List<CanonicalType> list) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("|");
    for (CanonicalType c : list) {
      String v = c.getValue();
      if (v.startsWith("http://hl7.org/fhir/StructureDefinition/"))
        v = v.substring(40);
      b.append(v);
    }
    return b.toString();
  }

  private String renderType(DataType value) throws Exception {
    if (value == null)
      return "";
    if (value.isPrimitive())
      return value.primitiveValue();

    String s = null;
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    if (asXml) {
      xml.setOutputStyle(OutputStyle.PRETTY);
      xml.compose(bs, "", value);
      bs.close();
      s = bs.toString();
      s = s.substring(s.indexOf("\n")+2);
    } else {
      json.setOutputStyle(OutputStyle.PRETTY);
      json.compose(bs, value, "");
      bs.close();
      s = bs.toString();
    }
    return s;
  }


  public void configureSheet(Sheet sheet, StructureDefinition sd) throws IOException {
    for (int i=0; i<34; i++) {
      sheet.autoSizeColumn(i);
    }
    sheet.setColumnHidden(2, true);
    sheet.setColumnHidden(3, true);
    sheet.setColumnHidden(30, true);
    sheet.setColumnHidden(31, true);
    sheet.setColumnHidden(32, true);

    sheet.setColumnWidth(9, columnPixels(20));
    sheet.setColumnWidth(11, columnPixels(100));
    sheet.setColumnWidth(12, columnPixels(100));
    sheet.setColumnWidth(13, columnPixels(100));
    sheet.setColumnWidth(15, columnPixels(20));
    sheet.setColumnWidth(16, columnPixels(20));
    sheet.setColumnWidth(17, columnPixels(20));
    sheet.setColumnWidth(18, columnPixels(20));
    sheet.setColumnWidth(34, columnPixels(100));

    if (sd != null) {
      int i = titles.length - 1;
      for (StructureDefinitionMappingComponent map : sd.getMapping()) {
        i++;
        sheet.setColumnWidth(i, columnPixels(50));
        sheet.autoSizeColumn(i);
        //  sheet.setColumnHidden(i,  true);
      }    
    }
    sheet.createFreezePane(2,1);

    if (hideMustSupportFalse) {
      SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
      String address = "A2:AI" + Math.max(Integer.valueOf(sheet.getLastRowNum()), 2);
      CellRangeAddress[] regions = {
          CellRangeAddress.valueOf(address)
      };

      ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("$G2<>\"Y\"");
      PatternFormatting fill1 = rule1.createPatternFormatting();
      fill1.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.index);
      fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

      ConditionalFormattingRule rule2 = sheetCF.createConditionalFormattingRule("$Q2<>\"\"");
      FontFormatting font = rule2.createFontFormatting();
      font.setFontColorIndex(IndexedColors.GREY_25_PERCENT.index);
      font.setFontStyle(true, false);

      sheetCF.addConditionalFormatting(regions, rule1, rule2);

      sheet.setAutoFilter(new CellRangeAddress(0,sheet.getLastRowNum(), 0, titles.length+(sd == null ? 0 : sd.getMapping().size() - 1)));


      XSSFSheet xSheet = (XSSFSheet)sheet;

      CTAutoFilter sheetFilter = xSheet.getCTWorksheet().getAutoFilter();
      CTFilterColumn filterColumn1 = sheetFilter.addNewFilterColumn();
      filterColumn1.setColId(6);
      CTCustomFilters filters = filterColumn1.addNewCustomFilters();
      CTCustomFilter filter1 = filters.addNewCustomFilter();
      filter1.setOperator(STFilterOperator.NOT_EQUAL);
      filter1.setVal(" ");

      CTFilterColumn filterColumn2 = sheetFilter.addNewFilterColumn();
      filterColumn2.setColId(26);
      CTFilters filters2 = filterColumn2.addNewFilters();
      filters2.setBlank(true);

      // We have to apply the filter ourselves by hiding the rows: 
      for (Row row : sheet) {
        if (row.getRowNum()>0 && (!row.getCell(6).getStringCellValue().equals("Y") || !row.getCell(26).getStringCellValue().isEmpty())) {
          ((XSSFRow) row).getCTRow().setHidden(true);
        }
      }
    }
    if (sheet.getLastRowNum() > 0) {
      sheet.setActiveCell(new CellAddress(sheet.getRow(1).getCell(0)));
    }
  }

}
