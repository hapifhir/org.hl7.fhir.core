package org.hl7.fhir.core.generator.codegen;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;

/**
 * Generates CoreRegistration, which registers all the concrete resources in the core 
 * package with a ModelContextInformation
 */
public class JavaCoreRegistrationGenerator extends JavaBaseGenerator {

  public JavaCoreRegistrationGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String jid) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, jid);
  }

  public void generate() throws Exception {
    StringBuilder b = new StringBuilder();
    boolean first = true;
    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        if (first) { first = false; } else { b.append("\r\n"); }
        b.append("    modelContextInformation.registerCoreResource(\""+escapeJavaString(sd.getName())+"\", packageName);");
      }
    }

    String template = config.getAdornments().get("CoreRegistration");
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());
    template = template.replace("{{generated}}", generatedAnnotationValue());
    template = template.replace("{{coreregistration}}", b.toString());
    write(template);
    flush();
    close();
  }

}
