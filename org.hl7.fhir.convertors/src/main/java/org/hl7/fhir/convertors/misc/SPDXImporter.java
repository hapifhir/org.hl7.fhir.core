package org.hl7.fhir.convertors.misc;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.CodeSystem.PropertyType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class SPDXImporter {

  private StringBuilder b;


  public static void main(String[] args) throws Exception {
    new SPDXImporter().generate(args);
  }
  
  public void generate(String[] args) throws Exception {
    JsonObject json = JsonParser.parseObjectFromUrl("https://raw.githubusercontent.com/spdx/license-list-data/main/json/licenses.json");
    CodeSystem cs = (CodeSystem) new org.hl7.fhir.r4.formats.JsonParser().parse(new FileInputStream(args[0]));
    cs.getConcept().clear();
    cs.getProperty().clear();
    cs.addProperty().setCode("reference").setType(PropertyType.STRING);
    cs.addProperty().setCode("isOsiApproved").setType(PropertyType.BOOLEAN);
    cs.addProperty().setCode("status").setType(PropertyType.CODE).setUri("http://hl7.org/fhir/concept-properties#status");
    cs.addProperty().setCode("seeAlso").setType(PropertyType.STRING);
    cs.setVersion(json.asString("licenseListVersion"));
    for (JsonObject l : json.getJsonObjects("licenses")) {
      ConceptDefinitionComponent cc = cs.addConcept();
      cc.setCode(l.asString("licenseId"));
      cc.setDisplay(l.asString("name"));
      cc.setDefinition(l.asString("name"));
      if (l.has("reference")) {
        cc.addProperty().setCode("reference").setValue(new StringType(l.asString("reference")));
      }
      if (l.has("isOsiApproved")) {
        cc.addProperty().setCode("isOsiApproved").setValue(new BooleanType(l.asBoolean("isOsiApproved")));
      }
      if (l.asBoolean("isDeprecatedLicenseId")) {
        cc.addProperty().setCode("status").setValue(new BooleanType(l.asBoolean("deprecated")));
      }
      for (String s : l.getStrings("seeAlso")) {        
        cc.addProperty().setCode("seeAlso").setValue(new StringType(s));
      }
    }
    CodeSystemUtilities.sortAllCodes(cs);
    new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(args[1]), cs);
    b = new StringBuilder();
    generateEnum("SPDXLicense", cs);
    TextFile.stringToFile(b.toString(), Utilities.changeFileExt(args[1], ".java"));
  }

  private void write(String s) {
    b.append(s);
  }
  
  private boolean allPlusMinus(String cc) {
    for (char c : cc.toCharArray())
      if (!(c == '-' || c == '+'))
        return false;
    return true;
  }
  
  protected String makeConst(String cc) {
    if (cc.equals("*"))
      cc = "ASTERISK";
    if (Utilities.isOid(cc) && Utilities.charCount(cc, '.') > 2)
      cc = "OID_"+cc;
    if (cc.equals("%"))
      cc = "pct";
    else if (cc.equals("<"))
      cc = "less_Than";
    else if (cc.equals("<="))
      cc = "less_Or_Equal";
    else if (cc.equals(">"))
      cc = "greater_Than";
    else if (cc.equals(">="))
      cc = "greater_Or_Equal";
    else if (cc.equals("="))
      cc = "equal";
    else if (cc.equals("!="))
      cc = "not_equal";
    else if (allPlusMinus(cc))
      cc = cc.replace("-", "Minus").replace("+", "Plus");
    else
      cc = cc.replace("-", "_").replace("+", "PLUS");
    cc = cc.replace("(", "_").replace(")", "_");
    cc = cc.replace("{", "_").replace("}", "_");
    cc = cc.replace("<", "_").replace(">", "_");
    cc = cc.replace(".", "_").replace("/", "_");
    cc = cc.replace(":", "_");
    cc = cc.replace("%", "pct");
    if (Utilities.isInteger(cc.substring(0, 1)))
      cc = "_"+cc;
    cc = cc.toUpperCase();
    return cc;
  }

  
  private void generateEnum(String name, CodeSystem cs) throws Exception {
    String url = cs.getUrl();
    CommaSeparatedStringBuilder el = new CommaSeparatedStringBuilder();

    write("    public enum "+name+" {\r\n");
    int l = cs.getConcept().size();
    int i = 0;
    for (ConceptDefinitionComponent c : cs.getConcept()) {
        i++;
        String cc = Utilities.camelCase(c.getCode());
        cc = makeConst(cc);
        el.append(cc);

        write("        /**\r\n");
        write("         * "+c.getDefinition()+"\r\n");
        write("         */\r\n");      
        write("        "+cc.toUpperCase()+", \r\n");
      }
    write("        /**\r\n");
    write("         * added to help the parsers\r\n");
    write("         */\r\n");      
    write("        NULL;\r\n");
    el.append("NULL");


    write("        public static "+name+" fromCode(String codeString) throws FHIRException {\r\n");
    write("            if (codeString == null || \"\".equals(codeString))\r\n");
    write("                return null;\r\n");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
        String cc = Utilities.camelCase(c.getCode());
        cc = makeConst(cc);
        write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
        write("          return "+cc+";\r\n");
      }
    write("        throw new FHIRException(\"Unknown "+name+" code '\"+codeString+\"'\");\r\n");
    write("        }\r\n"); 

    write("        public static boolean isValidCode(String codeString) {\r\n");
    write("            if (codeString == null || \"\".equals(codeString))\r\n");
    write("                return false;\r\n");
    write("          return Utilities.existsInList(codeString");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
        write(", \""+c.getCode()+"\"");
    }
    write(");\r\n");
    write("        }\r\n"); 

    write("        public String toCode() {\r\n");
    write("          switch (this) {\r\n");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
        String cc = Utilities.camelCase(c.getCode());
        cc = makeConst(cc);
        write("            case "+cc+": return \""+c.getCode()+"\";\r\n");
      }
    write("            case NULL: return null;\r\n");
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    write("        public String getSystem() {\r\n");
    write("          switch (this) {\r\n");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("            case "+cc+": return \""+cs.getUrl()+"\";\r\n");
    }
    write("            case NULL: return null;\r\n");
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    write("        public String getDefinition() {\r\n");
    write("          switch (this) {\r\n");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
        String cc = Utilities.camelCase(c.getCode());
        cc = makeConst(cc);
        write("            case "+cc+": return \""+Utilities.escapeJava(c.getDefinition())+"\";\r\n");
      }
    write("            case NULL: return null;\r\n");
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    write("        public String getDisplay() {\r\n");
    write("          switch (this) {\r\n");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
        String cc = Utilities.camelCase(c.getCode());
        cc = makeConst(cc);
        write("            case "+cc+": return \""+Utilities.escapeJava(Utilities.noString(c.getDisplay()) ? c.getCode() : c.getDisplay())+"\";\r\n");
      }
    write("            case NULL: return null;\r\n");
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    write("    }\r\n");
    write("\r\n");

    
    write("  public static class "+name+"EnumFactory implements EnumFactory<"+name+"> {\r\n");
    write("    public "+name+" fromCode(String codeString) throws IllegalArgumentException {\r\n");
    
    write("      if (codeString == null || \"\".equals(codeString))\r\n");
    write("            if (codeString == null || \"\".equals(codeString))\r\n");
    write("                return null;\r\n");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
        String cc = Utilities.camelCase(c.getCode());
        cc = makeConst(cc);
        write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
        write("          return "+name+"."+cc+";\r\n");
      }
    write("        throw new IllegalArgumentException(\"Unknown "+name+" code '\"+codeString+\"'\");\r\n");
    write("        }\r\n"); 
    write("\r\n");
    write("        public Enumeration<"+name+"> fromType(PrimitiveType<?> code) throws FHIRException {\r\n");
    write("          if (code == null)\r\n");
    write("            return null;\r\n");
    write("          if (code.isEmpty())\r\n");
    write("            return new Enumeration<"+name+">(this, "+name+".NULL, code);\r\n");
    write("          String codeString = ((PrimitiveType) code).asStringValue();\r\n");
    write("          if (codeString == null || \"\".equals(codeString))\r\n");
    write("            return new Enumeration<"+name+">(this, "+name+".NULL, code);\r\n");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
      write("          return new Enumeration<"+name+">(this, "+name+"."+cc+", code);\r\n");
    }   
    write("        throw new FHIRException(\"Unknown "+name+" code '\"+codeString+\"'\");\r\n");
    write("        }\r\n"); 
    write("    public String toCode("+name+" code) {\r\n");
    for (ConceptDefinitionComponent c : cs.getConcept()) {
        String cc = Utilities.camelCase(c.getCode());
        cc = makeConst(cc);
        write("      if (code == "+name+"."+cc+")\r\n        return \""+c.getCode()+"\";\r\n");
    }
    write("      return \"?\";\r\n"); 
    write("      }\r\n");
    
    write("    public String toSystem("+name+" code) {\r\n");
    write("      return code.getSystem();\r\n");
    write("      }\r\n"); 

    write("    }\r\n"); 
    write("\r\n");
  }

}

