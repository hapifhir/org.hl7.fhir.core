package org.hl7.fhir.r5.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fhir.ucum.Utilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.MetadataResource;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.utilities.CSVReader;

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

  private CSVReader csv;
  private List<MappingRow> rows = new ArrayList<>();
  private Map<String, String> metadata = new HashMap<>();

  public MappingSheetParser(InputStream stream, String name) throws FHIRException, IOException {
    super();
    this.csv = new CSVReader(stream);
    checkHeaders1(name);
    checkHeaders2(name);
    while (csv.line()) {
      processRow(); 
    }
  }

  private void checkHeaders1(String name) throws FHIRException, IOException {
    csv.readHeaders();
    csv.checkColumn(1, "HL7 v2", "Mapping Sheet "+name);
    csv.checkColumn(6, "Condition (IF True)", "Mapping Sheet "+name);
    csv.checkColumn(7, "HL7 FHIR", "Mapping Sheet "+name);
    csv.checkColumn(14, "Comments", "Mapping Sheet "+name);
    csv.checkColumn(16, "Name", "Mapping Sheet "+name);
    csv.checkColumn(17, "Value", "Mapping Sheet "+name);
  }

  private void checkHeaders2(String name) throws FHIRException, IOException {
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

  private void processRow() {
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
      if (row.getCondition() != null)
        element.getTargetFirstRep().addDependsOn().setProperty("http://hl7.org/fhirpath").setValue(processCondition(row.getCondition()));
      element.getTargetFirstRep().setCode(row.getAttribute());
      element.getTargetFirstRep().setDisplay(row.getType()+" : ["+row.getMinMax()+"]");
      if (row.getDerived() != null) 
        element.getTargetFirstRep().getProductFirstRep().setProperty(row.getDerived()).setValue(row.getDerivedMapping());
      if (row.getComments() != null)
        element.getTargetFirstRep().setComment(row.getComments());
      if (row.getDtMapping() != null)
        element.getTargetFirstRep().addExtension("htp://hl7.org/fhir/StructureDefinition/ConceptMap-type-mapping", new UrlType("todo#"+row.getDtMapping()));
      if (row.getVocabMapping() != null)
        element.getTargetFirstRep().addExtension("htp://hl7.org/fhir/StructureDefinition/ConceptMap-vocab-mapping", new UrlType("todo#"+row.getVocabMapping()));      
    }
    return map;    
  }

  private String processCondition(String condition) {
    if (condition.startsWith("IF ") && condition.endsWith(" IS VALUED"))
      return "`"+condition.substring(4, condition.length()-10)+".exists()";
    if (condition.startsWith("IF ") && condition.endsWith(" DOES NOT EXIST"))
      return "`"+condition.substring(4, condition.length()-15)+".exists()";
    throw new Error("not processed yet: "+condition);
  }

  private void loadMetadata(MetadataResource mr) throws FHIRException {
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

  public static void main(String[] args) throws FileNotFoundException, IOException, FHIRException {
    MappingSheetParser parser = new MappingSheetParser(new FileInputStream("c:\\temp\\v2-pid.csv"), "v2-pid.csv");
    ConceptMap cm = parser.getConceptMap();

  }
}
