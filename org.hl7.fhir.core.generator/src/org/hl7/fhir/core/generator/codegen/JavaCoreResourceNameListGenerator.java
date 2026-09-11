package org.hl7.fhir.core.generator.codegen;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;

/**
 * Generates CoreResourceNameList, the list of names of all the concrete resources in the core
 * package
 */
public class JavaCoreResourceNameListGenerator extends JavaBaseGenerator {

  public JavaCoreResourceNameListGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String jid) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, jid);
  }

  public void generate() throws Exception {
    StringBuilder b = new StringBuilder();
    boolean first = true;
    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        if (first) { first = false; } else { b.append(",\r\n"); }
        b.append("      \""+escapeJavaString(sd.getName())+"\"");
      }
    }

    String template = config.getAdornments().get("CoreResourceNameList");
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());
    template = template.replace("{{generated}}", generatedAnnotationValue());
    template = template.replace("{{names}}", b.toString());
    write(template);
    flush();
    close();
  }

}
