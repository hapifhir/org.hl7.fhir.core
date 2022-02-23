package org.hl7.fhir.r4b.utils.formats;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



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
import org.hl7.fhir.r4b.formats.IParser.OutputStyle;
import org.hl7.fhir.r4b.formats.JsonParser;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.CanonicalType;
import org.hl7.fhir.r4b.model.Coding;
import org.hl7.fhir.r4b.model.DataType;
import org.hl7.fhir.r4b.model.ElementDefinition;
import org.hl7.fhir.r4b.model.ElementDefinition.AggregationMode;
import org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r4b.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r4b.model.IdType;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.r4b.model.UriType;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextStreamWriter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomFilters;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilterColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilters;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFilterOperator;

public class XLSXWriter  extends TextStreamWriter  {

  private StructureDefinition def;
  private List<StructureDefinitionMappingComponent> mapKeys = new ArrayList<StructureDefinitionMappingComponent>();
  private Map<String, CellStyle> styles;
  private OutputStream outStream;
  private XSSFWorkbook wb = new XSSFWorkbook();
  private Sheet sheet;
  private XmlParser xml = new XmlParser();
  private JsonParser json = new JsonParser();
  private boolean asXml;
  private boolean hideMustSupportFalse;

  private static String[] titles = {
      "Path", "Slice Name", "Alias(s)", "Label", "Min", "Max", "Must Support?", "Is Modifier?", "Is Summary?", "Type(s)", "Short", 
      "Definition", "Comments", "Requirements", "Default Value", "Meaning When Missing", "Fixed Value", "Pattern", "Example",
      "Minimum Value", "Maximum Value", "Maximum Length", "Binding Strength", "Binding Description", "Binding Value Set", "Code",
      "Slicing Discriminator", "Slicing Description", "Slicing Ordered", "Slicing Rules", "Base Path", "Base Min", "Base Max",
      "Condition(s)", "Constraint(s)"};

  public XLSXWriter(OutputStream out, StructureDefinition def, boolean asXml, boolean hideMustSupportFalse) throws UnsupportedEncodingException {
    super(out);
    outStream = out;
    this.asXml = asXml;
    this.def = def;
    this.hideMustSupportFalse = hideMustSupportFalse;
    sheet = wb.createSheet("Elements");
    styles = createStyles(wb);
    Row headerRow = sheet.createRow(0);
    for (int i = 0; i < titles.length; i++) {
      addCell(headerRow, i, titles[i], styles.get("header"));
    }
    int i = titles.length - 1;
    for (StructureDefinitionMappingComponent map : def.getMapping()) {
      i++;
      addCell(headerRow, i, "Mapping: " + map.getName(), styles.get("header"));
    }    
  }

  private void addCell(Row row, int pos, String content) {
    addCell(row, pos, content, styles.get("body"));
  }
  
  public void addCell(Row row, int pos, boolean b) {
    addCell(row, pos, b ? "Y" : "");
  }

  public void addCell(Row row, int pos, int content) {
    addCell(row, pos, Integer.toString(content));
  }
  
  private void addCell(Row row, int pos, String content, CellStyle style) {
    Cell cell = row.createCell(pos);
    cell.setCellValue(content);
    cell.setCellStyle(style);
  }
  
  /**
   * create a library of cell styles
   */
  private static Map<String, CellStyle> createStyles(Workbook wb){
    Map<String, CellStyle> styles = new HashMap<>();

    CellStyle style;
    Font headerFont = wb.createFont();
    headerFont.setBold(true);
    style = createBorderedStyle(wb);
    style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    style.setVerticalAlignment(VerticalAlignment.TOP);
    style.setWrapText(true);
    style.setFont(headerFont);
    styles.put("header", style);

    style = createBorderedStyle(wb);
    style.setVerticalAlignment(VerticalAlignment.TOP);
    style.setWrapText(true);    
    styles.put("body", style);

    return styles;
  }

  private static CellStyle createBorderedStyle(Workbook wb){
    BorderStyle thin = BorderStyle.THIN;
    short black = IndexedColors.GREY_50_PERCENT.getIndex();
    
    CellStyle style = wb.createCellStyle();
    style.setBorderRight(thin);
    style.setRightBorderColor(black);
    style.setBorderBottom(thin);
    style.setBottomBorderColor(black);
    style.setBorderLeft(thin);
    style.setLeftBorderColor(black);
    style.setBorderTop(thin);
    style.setTopBorderColor(black);
    return style;
  }
  /*  private void findMapKeys(StructureDefinition def, List<StructureDefinitionMappingComponent> maps, IWorkerContext context) {
  	maps.addAll(def.getMapping());
  	if (def.getBaseDefinition()!=null) {
  	  StructureDefinition base = context.fetchResource(StructureDefinition.class, def.getBaseDefinition());
  	  findMapKeys(base, maps, context);
  	}
  }*/

  public void processElement(ElementDefinition ed) throws Exception {
    Row row = sheet.createRow(sheet.getLastRowNum()+1);
    int i = 0;
    addCell(row, i++, ed.getPath(), styles.get("body"));
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
    for (StructureDefinitionMappingComponent mapKey : def.getMapping()) {
      String mapString = "";
      for (ElementDefinitionMappingComponent map : ed.getMapping()) {
        if (map.getIdentity().equals(mapKey.getIdentity()))
          mapString = map.getMap();        
      }
      addCell(row, i++, mapString);
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
  
  private String aggList(List<org.hl7.fhir.r4b.model.Enumeration<AggregationMode>> list) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (org.hl7.fhir.r4b.model.Enumeration<AggregationMode> c : list)
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
  
  private int columnPixels(double columns) {
    double WIDTH_FACTOR = 256;
    double PADDING = 180;
    return (int)Math.floor(columns*WIDTH_FACTOR + PADDING);
  }

  public void dump() throws IOException {
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

    int i = titles.length - 1;
    for (StructureDefinitionMappingComponent map : def.getMapping()) {
      i++;
      sheet.setColumnWidth(i, columnPixels(50));
      sheet.autoSizeColumn(i);
//      sheet.setColumnHidden(i,  true);
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

      sheet.setAutoFilter(new CellRangeAddress(0,sheet.getLastRowNum(), 0, titles.length+def.getMapping().size() - 1));


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
    sheet.setActiveCell(new CellAddress(sheet.getRow(1).getCell(0)));

    wb.write(outStream);
    
    flush();
    close();
  }

}