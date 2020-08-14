package org.hl7.fhir.core.generator.codegen;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.VersionUtilities;

public class JavaConstantsGenerator extends JavaBaseGenerator {


  public JavaConstantsGenerator(OutputStream out, Definitions definitions, Configuration configuration, Date genDate, String version) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate);
  }
  
  public void generate() throws Exception {   
    StringBuilder rt = new StringBuilder();
    boolean first = true;
    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation()==TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        if (first) first = false; else rt.append("|");
        rt.append(sd.getType());
        version = sd.getVersion();
      }
    }
    
    String template = config.getAdornments().get("Constants");
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());

    template = template.replace("{{rt}}", rt.toString());
    template = template.replace("{{version}}", version);
    template = template.replace("{{version-mm}}", VersionUtilities.getMajMin(version));
    template = template.replace("{{date}}", config.DATE_FORMAT().format(genDate));

    write(template);
    flush();
    close();
  }
  
}