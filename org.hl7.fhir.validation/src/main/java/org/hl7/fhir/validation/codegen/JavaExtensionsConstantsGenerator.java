package org.hl7.fhir.validation.codegen;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

public class JavaExtensionsConstantsGenerator extends JavaBaseGenerator {

  private StringBuilder src;
  private CommaSeparatedStringBuilder mod;

  public JavaExtensionsConstantsGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String packageName) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, packageName);
  }
  
  public void start() throws Exception {
    src = new StringBuilder(); 
    mod = new CommaSeparatedStringBuilder();
  }
  
  public void generate(StructureDefinition sd, String name, String constName) throws Exception {  
    src.append("  public static final String EXT_"+constName+" = \""+sd.getUrl()+"\"; // "+sd.getTitle()+"\r\n");
  }
  
  public void finish() throws Exception {   
    
    String template = config.getAdornments().get("Extensions.Constants");
    template = template.replace("{{pid}}", packageName);
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());

    template = template.replace("{{consts}}", src.toString());
    template = template.replace("{{mod}}", genMod());

    write(template);
    flush();
    close();
  }

  private CharSequence genMod() {
    if (mod.length() == 0) {
      return 
        "  public static boolean isModifier(String url) {\r\n"+
        "    return false;\r\n"+
        "  }\r\n\r\n";
    } else {
      return 
        "  public static boolean isModifier(String url) {\r\n"+
        "    return Utilities.existsInList(url, "+mod.toString()+");\r\n"+
        "  }\r\n\r\n";
    }
  }

  public void seeModifier(StructureDefinition sd) {
    mod.append("\"" + sd.getUrl()+"\"");
  }
  
}