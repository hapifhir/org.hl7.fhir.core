package org.hl7.fhir.core.generator.codegen.extensions;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.core.generator.codegen.Configuration;
import org.hl7.fhir.core.generator.codegen.JavaBaseGenerator;
import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

public class JavaConstantsGenerator extends JavaBaseGenerator {

  private StringBuilder src;
  private CommaSeparatedStringBuilder mod;

  public JavaConstantsGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String jid) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, jid);
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
    template = template.replace("{{jid}}", jid);
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());

    template = template.replace("{{consts}}", src.toString());
    template = template.replace("{{mod}}", genMod());

    write(template);
    flush();
    close();
  }

  private CharSequence genMod() {
    return 
      "  public static boolean isModifier(String url) {\r\n"+
      "    return Utilities.existsInList(url, "+mod.toString()+");\r\n"+
      "  }\r\n\r\n";
  }

  public void seeModifier(StructureDefinition sd) {
    mod.append("\"" + sd.getUrl()+"\"");
  }
  
}