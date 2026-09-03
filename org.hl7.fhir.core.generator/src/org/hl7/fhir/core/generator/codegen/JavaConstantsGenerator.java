package org.hl7.fhir.core.generator.codegen;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.VersionUtilities;

public class JavaConstantsGenerator extends JavaBaseGenerator {


  public JavaConstantsGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String jid) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, jid);
  }
  
  public void generate() throws Exception {   
    StringBuilder rt = new StringBuilder();
    boolean first = true;
    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation()==TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        if (first) first = false; else rt.append("|");
        // substituted into {{rt}}, which the Constants template uses inside a regex alternation - 
        // neither java-string nor regex escaping applies, so the value is validated instead
        checkJavaIdentifier(sd.getType(), "the type of "+sd.getVersionedUrl());
        rt.append(sd.getType());
        version = sd.getVersion();
      }
    }
    
    String template = config.getAdornments().get("Constants");
    template = template.replace("{{jid}}", jid);
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());
    template = template.replace("{{generated}}", generatedAnnotationValue());

    template = template.replace("{{rt}}", rt.toString());
    // the first entry in the packages list is the core package these definitions were loaded from (id#version)
    String packageName = definitions.getPackages().isEmpty() ? "" : definitions.getPackages().get(0);
    if (packageName.contains("#")) {
      packageName = packageName.substring(0, packageName.indexOf("#"));
    }
    template = template.replace("{{package-name}}", packageName);
    template = template.replace("{{version}}", version);
    template = template.replace("{{version-mm}}", VersionUtilities.getMajMin(version));
    template = template.replace("{{version-base}}", version.contains("-") ? version.substring(0, version.indexOf("-")) : version) ;
    template = template.replace("{{date}}", genDate);

    write(template);
    flush();
    close();
  }
  
}