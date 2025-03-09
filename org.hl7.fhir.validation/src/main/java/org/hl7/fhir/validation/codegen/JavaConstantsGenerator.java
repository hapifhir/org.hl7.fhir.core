package org.hl7.fhir.validation.codegen;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.VersionUtilities;

public class JavaConstantsGenerator extends JavaBaseGenerator {


  public JavaConstantsGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String packageName) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, packageName);
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
    template = template.replace("{{pid}}", packageName);
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());

    template = template.replace("{{rt}}", rt.toString());
    template = template.replace("{{version}}", version);
    template = template.replace("{{version-mm}}", VersionUtilities.getMajMin(version) != null ? VersionUtilities.getMajMin(version) : version);
    template = template.replace("{{version-base}}", version.contains("-") ? version.substring(0, version.indexOf("-")) : version) ;
    template = template.replace("{{date}}", genDate);

    write(template);
    flush();
    close();
  }
  
}