package org.hl7.fhir.r5.utils;

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


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapContextType;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode;
import org.hl7.fhir.r5.model.StructureMap.StructureMapTransform;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class MappingSheetParser {

  public class MappingRow {
    private String sequence;
    private String identifier;
    private String name;
    private String dataType;
    private String cardinality;
    private String condition;
    private String attribute;
    private String type;
    private String minMax;
    private String dtMapping;
    private String vocabMapping;
    private String derived;
    private String derivedMapping;
    private String comments;
    public String getSequence() {
      return sequence;
    }
    public String getIdentifier() {
      return identifier;
    }
    public String getName() {
      return name;
    }
    public String getDataType() {
      return dataType;
    }
    public String getCardinality() {
      return cardinality;
    }
    public int getCardinalityMin() {
      return Integer.parseInt(cardinality.split("\\.")[0]);
    }
    public String getCardinalityMax() {
      return cardinality.split("\\.")[2];
    }
    public String getCondition() {
      return condition;
    }
    public String getAttribute() {
      return attribute;
    }
    public String getType() {
      return type;
    }
    public String getMinMax() {
      return minMax;
    }
    public String getDtMapping() {
      return dtMapping;
    }
    public String getVocabMapping() {
      return vocabMapping;
    }
    public String getDerived() {
      return derived;
    }
    public String getDerivedMapping() {
      return derivedMapping;
    }
    public String getComments() {
      return comments;
    }

  }


  private List<MappingRow> rows = new ArrayList<>();
  private Map<String, String> metadata = new HashMap<>();

  public MappingSheetParser() {
    super();    
  }
    
  public void  parse(InputStream stream, String name) throws FHIRException, IOException {
    CSVReader csv = new CSVReader(stream);
    checkHeaders1(csv, name);
    checkHeaders2(csv, name);
    while (csv.line()) {
      processRow(csv); 
    }
  }

  private void checkHeaders1(CSVReader csv, String name) throws FHIRException, IOException {
    csv.readHeaders();
    csv.checkColumn(1, "HL7 v2", "Mapping Sheet "+name);
    csv.checkColumn(6, "Condition (IF True)", "Mapping Sheet "+name);
    csv.checkColumn(7, "HL7 FHIR", "Mapping Sheet "+name);
    csv.checkColumn(14, "Comments", "Mapping Sheet "+name);
    csv.checkColumn(16, "Name", "Mapping Sheet "+name);
    csv.checkColumn(17, "Value", "Mapping Sheet "+name);
  }

  private void checkHeaders2(CSVReader csv, String name) throws FHIRException, IOException {
    csv.readHeaders();
    csv.checkColumn(1, "Display Sequence", "Mapping Sheet "+name);
    csv.checkColumn(2, "Identifier", "Mapping Sheet "+name);
    csv.checkColumn(3, "Name", "Mapping Sheet "+name);
    csv.checkColumn(4, "Data Type", "Mapping Sheet "+name);
    csv.checkColumn(5, "Cardinality", "Mapping Sheet "+name);
    csv.checkColumn(7, "FHIR Attribute", "Mapping Sheet "+name);
    csv.checkColumn(8, "Data Type", "Mapping Sheet "+name);
    csv.checkColumn(9, "Cardinality", "Mapping Sheet "+name);
    csv.checkColumn(10, "Data Type Mapping", "Mapping Sheet "+name);
    csv.checkColumn(11, "Vocabulary Mapping\n(IS, ID, CE, CNE, CWE)", "Mapping Sheet "+name);
    csv.checkColumn(12, "Derived Mapping", "Mapping Sheet "+name);
  }

  private void processRow(CSVReader csv) {
    MappingRow mr = new MappingRow();
    mr.sequence = csv.value(1);
    mr.identifier =  csv.value(2);
    mr.name = csv.value(3);
    mr.dataType = csv.value(4);
    mr.cardinality = csv.value(5);
    mr.condition = csv.value(6);
    mr.attribute = csv.value(7);
    mr.type = csv.value(8);
    mr.minMax = csv.value(9);
    mr.dtMapping = csv.value(10);
    mr.vocabMapping = csv.value(11);
    mr.derived = csv.value(12);
    if (!Utilities.noString(mr.derived)) {
      String[] s = mr.derived.split("\\=");
      mr.derived = s[0].trim();
      mr.derivedMapping = s[1].trim();
    }
    mr.comments = csv.value(14);
    rows.add(mr);
    if (!org.hl7.fhir.utilities.Utilities.noString(csv.value(16)))
      metadata.put(csv.value(16), csv.value(17));
  }

  public List<MappingRow> getRows() {
    return rows;
  }

  public ConceptMap getConceptMap() throws FHIRException {
    ConceptMap map = new ConceptMap();
    loadMetadata(map);
    if (metadata.containsKey("copyright"))
      map.setCopyright(metadata.get("copyright"));
    for (MappingRow row : rows) {
      SourceElementComponent element = map.getGroupFirstRep().addElement();
      element.setCode(row.getIdentifier());
      element.setId(row.getSequence());
      element.setDisplay(row.getName()+" : "+row.getDataType()+" ["+row.getCardinality()+"]");
      element.addExtension(ToolingExtensions.EXT_MAPPING_NAME, new StringType(row.getName()));
      element.addExtension(ToolingExtensions.EXT_MAPPING_TYPE, new StringType(row.getDataType()));
      element.addExtension(ToolingExtensions.EXT_MAPPING_CARD, new StringType(row.getCardinality()));
      if ("N/A".equals(row.getAttribute()))
        element.setNoMap(true);
      else {
        element.getTargetFirstRep().setRelationship(ConceptMapRelationship.RELATEDTO);
        if (row.getCondition() != null)
          element.getTargetFirstRep().addDependsOn().setProperty("http://hl7.org/fhirpath").setValue(processCondition(row.getCondition()));
        element.getTargetFirstRep().setCode(row.getAttribute());
        element.getTargetFirstRep().setDisplay(row.getType()+" : ["+row.getMinMax()+"]");
        element.getTargetFirstRep().addExtension(ToolingExtensions.EXT_MAPPING_TGTTYPE, new StringType(row.getType()));
        element.getTargetFirstRep().addExtension(ToolingExtensions.EXT_MAPPING_TGTCARD, new StringType(row.getMinMax()));
        if (row.getDerived() != null) 
          element.getTargetFirstRep().getProductFirstRep().setProperty(row.getDerived()).setValue(row.getDerivedMapping());
        if (row.getComments() != null)
          element.getTargetFirstRep().setComment(row.getComments());
        if (row.getDtMapping() != null)
          element.getTargetFirstRep().addExtension("http://hl7.org/fhir/StructureDefinition/ConceptMap-type-mapping", new UrlType("todo#"+row.getDtMapping()));
        if (row.getVocabMapping() != null)
          element.getTargetFirstRep().addExtension("http://hl7.org/fhir/StructureDefinition/ConceptMap-vocab-mapping", new UrlType("todo#"+row.getVocabMapping()));
      }
    }
    return map;    
  }

  private String processCondition(String condition) {
    if (condition.startsWith("IF ") && condition.endsWith(" IS VALUED"))
      return "`"+condition.substring(4, condition.length()-10)+"`.exists()";
    if (condition.startsWith("IF ") && condition.endsWith(" DOES NOT EXIST"))
      return "`"+condition.substring(4, condition.length()-15)+"`.exists()";
    throw new Error("not processed yet: "+condition); 
  }

  private void loadMetadata(CanonicalResource mr) throws FHIRException {
    if (metadata.containsKey("id"))
      mr.setId(metadata.get("id"));
    if (metadata.containsKey("url"))
      mr.setUrl(metadata.get("url"));
    if (metadata.containsKey("name"))
      mr.setName(metadata.get("name"));
    if (metadata.containsKey("title"))
      mr.setTitle(metadata.get("title"));
    if (metadata.containsKey("version"))
      mr.setVersion(metadata.get("version"));
    if (metadata.containsKey("status"))
      mr.setStatus(PublicationStatus.fromCode(metadata.get("status")));
    if (metadata.containsKey("date"))
      mr.setDateElement(new DateTimeType(metadata.get("date")));
    if (metadata.containsKey("publisher"))
      mr.setPublisher(metadata.get("publisher"));
    if (metadata.containsKey("description"))
      mr.setDescription(metadata.get("description"));
  }

  public StructureMap getStructureMap() throws FHIRException {
    StructureMap map = new StructureMap();
    loadMetadata(map);
    if (metadata.containsKey("copyright"))
      map.setCopyright(metadata.get("copyright"));
    StructureMapGroupComponent grp = map.addGroup();
    grp.setTypeMode(StructureMapGroupTypeMode.NONE);
    for (MappingRow row : rows) {
      StructureMapGroupRuleComponent rule = grp.addRule();
      rule.setName(row.getSequence());
      StructureMapGroupRuleSourceComponent src = rule.getSourceFirstRep();
      src.setContext("src");
      src.setElement(row.getIdentifier());
      src.setMin(row.getCardinalityMin());
      src.setMax(row.getCardinalityMax());
      src.setType(row.getDataType());
      src.addExtension(ToolingExtensions.EXT_MAPPING_NAME, new StringType(row.getName()));
      if (row.getCondition() != null) {
        src.setCheck(processCondition(row.getCondition()));
      }
      StructureMapGroupRuleTargetComponent tgt = rule.getTargetFirstRep();
      tgt.setContext("tgt");
      tgt.setContextType(StructureMapContextType.VARIABLE);
      tgt.setElement(row.getAttribute());
      tgt.addExtension(ToolingExtensions.EXT_MAPPING_TGTTYPE, new StringType(row.getType()));
      tgt.addExtension(ToolingExtensions.EXT_MAPPING_TGTCARD, new StringType(row.getMinMax()));
      if (row.getDtMapping() != null) {
        src.setVariable("s");
        tgt.setVariable("t");
        tgt.setTransform(StructureMapTransform.CREATE);
        StructureMapGroupRuleDependentComponent dep = rule.addDependent();
        dep.setName(row.getDtMapping());
        dep.addVariable("s");
        dep.addVariable("t");
      } else if (row.getVocabMapping() != null) {
        tgt.setTransform(StructureMapTransform.TRANSLATE);
        tgt.addParameter().setValue(new StringType(row.getVocabMapping()));
        tgt.addParameter().setValue(new IdType("src"));
      } else {
        tgt.setTransform(StructureMapTransform.COPY);
      }
      rule.setDocumentation(row.getComments());
      if (row.getDerived() != null) { 
        tgt = rule.addTarget();
        tgt.setContext("tgt");
        tgt.setContextType(StructureMapContextType.VARIABLE);
        tgt.setElement(row.getDerived());
        tgt.setTransform(StructureMapTransform.COPY);
        tgt.addParameter().setValue(new StringType(row.getDerivedMapping()));
      }
    }
    return map;
  }

  public boolean isSheet(ConceptMap cm) {
    if (cm.getGroup().size() != 1)
      return false;
    ConceptMapGroupComponent grp = cm.getGroupFirstRep();
    for (SourceElementComponent e : grp.getElement()) {
      if (!e.hasExtension(ToolingExtensions.EXT_MAPPING_TYPE))
        return false;
    }
    return true;
  }

  public String genSheet(ConceptMap cm) throws FHIRException {
    StringBuilder b = new StringBuilder();
    readConceptMap(cm);
    b.append("<table class=\"grid\">\r\n");
    addHeaderRow1(b);
    addHeaderRow2(b);
    for (MappingRow row : rows) 
      addRow(b, row);
    b.append("</table>\r\n");
    return b.toString();
  }

  private void addRow(StringBuilder b, MappingRow row) {
    b.append(" <tr>");
    b.append("<td>"+Utilities.escapeXml(nn(row.sequence))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.identifier))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.name))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.dataType))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.cardinality))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.condition))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.attribute))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.type))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.minMax))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.dtMapping))+"</td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.vocabMapping))+"</td>");
    if (row.derived != null)
      b.append("<td>"+Utilities.escapeXml(nn(row.derived+"="+row.derivedMapping))+"</td>");
    else
      b.append("<td></td>");
    b.append("<td>"+Utilities.escapeXml(nn(row.comments))+"</td>");
    b.append("</tr>\r\n");   
    
  }

  private String nn(String s) {
    return s == null ? "" : s;
  }

  private void addHeaderRow1(StringBuilder b) {
    b.append(" <tr>");
    b.append("<td colspan=\"5\" style=\"background-color: lightgreen\"><b>v2</b></td>");
    b.append("<td colspan=\"1\"><b>Condition</b></td>");
    b.append("<td colspan=\"6\" style=\"background-color: orange\"><b>FHIR</b></td>");
    b.append("<td colspan=\"1\"><b>Comments</b></td>");
    b.append("</tr>\r\n");
  }

  private void addHeaderRow2(StringBuilder b) {
    b.append(" <tr>");
    b.append("<td style=\"background-color: lightgreen\"><b>Display Sequence</b></td>");
    b.append("<td style=\"background-color: lightgreen\"><b>Identifier</b></td>");
    b.append("<td style=\"background-color: lightgreen\"><b>Name</b></td>");
    b.append("<td style=\"background-color: lightgreen\"><b>Data Type</b></td>");
    b.append("<td style=\"background-color: lightgreen\"><b>Cardinality</b></td>");
    b.append("<td><b></b></td>");
    b.append("<td style=\"background-color: orange\"><b>FHIR Attribute</b></td>");
    b.append("<td style=\"background-color: orange\"><b>Data Type</b></td>");
    b.append("<td style=\"background-color: orange\"><b>Cardinality</b></td>");
    b.append("<td style=\"background-color: orange\"><b>Data Type Mapping</b></td>");
    b.append("<td style=\"background-color: orange\"><b>Vocabulary Mapping</b></td>");
    b.append("<td style=\"background-color: orange\"><b>Derived Mapping</b></td>");
    b.append("<td><b></b></td>");
    b.append("</tr>\r\n");   
  }

  private void readConceptMap(ConceptMap cm) throws FHIRException {
    for (ConceptMapGroupComponent g : cm.getGroup()) {
      for (SourceElementComponent e : g.getElement()) {
        if (e.hasId() && e.getTarget().size() == 1 && e.hasExtension(ToolingExtensions.EXT_MAPPING_TYPE)) {
          TargetElementComponent t = e.getTargetFirstRep();
          MappingRow row = new MappingRow();
          row.sequence = e.getId();
          row.identifier = e.getCode();
          row.name = e.getExtensionString(ToolingExtensions.EXT_MAPPING_NAME);
          row.dataType = e.getExtensionString(ToolingExtensions.EXT_MAPPING_TYPE);
          row.cardinality = e.getExtensionString(ToolingExtensions.EXT_MAPPING_CARD);
          if (e.getNoMap() == true) {
            row.attribute = "N/A";            
          } else {
            OtherElementComponent dep = getDependency(t, "http://hl7.org/fhirpath");
            if (dep != null)
              row.condition = dep.getValue();
            row.attribute = t.getCode();
            row.type = t.getExtensionString(ToolingExtensions.EXT_MAPPING_TGTTYPE);
            row.minMax = t.getExtensionString(ToolingExtensions.EXT_MAPPING_TGTCARD);
            row.dtMapping = t.getExtensionString("http://hl7.org/fhir/StructureDefinition/ConceptMap-type-mapping");
            row.vocabMapping = t.getExtensionString("http://hl7.org/fhir/StructureDefinition/ConceptMap-vocab-mapping");
            if (t.getProduct().size() > 0) {
              row.derived = t.getProductFirstRep().getProperty();
              row.derivedMapping = t.getProductFirstRep().getValue();
            }
          }
          row.comments = t.getComment();
          rows.add(row);
        }
      }
    }
  }


  private OtherElementComponent getDependency(TargetElementComponent t, String prop) {
    for (OtherElementComponent dep : t.getDependsOn()) {
      if (prop.equals(dep.getProperty()))
        return dep;
    }
    return null;
  }

  private static final String PFX = "<html><link rel=\"stylesheet\" href=\"file:c:\\work\\org.hl7.fhir\\build\\publish\\fhir.css\"/></head><body>\r\n";
  private static final String SFX = "<body></html>";
  public static void main(String[] args) throws FileNotFoundException, IOException, FHIRException {
    MappingSheetParser parser = new MappingSheetParser();
    parser.parse(new FileInputStream("c:\\temp\\v2-pid.csv"), "v2-pid.csv");
    ConceptMap cm = parser.getConceptMap();
    StructureMap sm = parser.getStructureMap();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("c:\\temp\\sm.json"), sm);
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("c:\\temp\\cm.json"), cm);
    TextFile.stringToFile(StructureMapUtilities.render(sm), "c:\\temp\\sm.txt");
    TextFile.stringToFile(PFX+parser.genSheet(cm)+SFX, "c:\\temp\\map.html");
  }

}