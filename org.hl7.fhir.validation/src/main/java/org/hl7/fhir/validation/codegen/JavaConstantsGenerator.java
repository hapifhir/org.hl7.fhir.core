package org.hl7.fhir.validation.codegen;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.VersionUtilities;

public class JavaConstantsGenerator extends JavaBaseGenerator {


  public JavaConstantsGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String packageName) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, packageName);
  }
  
  public void generate() throws Exception {   
    String seenVersion = null;
    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.hasUserData(Definitions.CORE_MARKER)) {
        continue;
      }
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation()==TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        // the template has a single VERSION constant, so every structure being generated has to
        // carry the same version. That is expected to hold; taking the last one silently would
        // hide a mixed set of definitions rather than reporting it
        if (seenVersion == null) {
          seenVersion = sd.getVersion();
        } else if (!seenVersion.equals(sd.getVersion())) {
          throw new FHIRException("Cannot generate Constants: "+sd.getVersionedUrl()+" has version '"+sd.getVersion()+
              "', but other structures in the same set have version '"+seenVersion+"'");
        }
        version = sd.getVersion();
      }
    }
    
    String template = config.getAdornments().get("Constants");
    template = template.replace("{{pid}}", packageName);
    // the first entry in the packages list is the (primary) package these definitions were loaded from (id#version)
    String npmName = definitions.getPackages().isEmpty() ? "" : definitions.getPackages().get(0);
    if (npmName.contains("#")) {
      npmName = npmName.substring(0, npmName.indexOf("#"));
    }
    template = template.replace("{{package-name}}", npmName);
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());
    template = template.replace("{{generated}}", generatedAnnotationValue());

    String mm = VersionUtilities.getMajMin(version) != null ? VersionUtilities.getMajMin(version) : version;
    String base = version.contains("-") ? version.substring(0, version.indexOf("-")) : version;
    String qualifier = version.substring(base.length());

    // the template declares VERSION in terms of VERSION_MAJOR_MINOR_PATCH, which is in turn declared
    // in terms of VERSION_MAJOR_MINOR, so that consumers can use the parts without re-parsing the
    // whole string. That only holds where the version actually decomposes that way; where it does not
    // - 'current', or an rX alias, where getMajMin() and the raw string diverge - fall back to plain
    // literals, so that each of the three constants stays individually correct rather than silently
    // reassembling into some other string
    String patch = base.startsWith(mm) ? base.substring(mm.length()) : null;
    if (patch != null) {
      template = template.replace("{{version-mm-expr}}", literal(mm));
      template = template.replace("{{version-mmp-expr}}", "VERSION_MAJOR_MINOR"+(patch.isEmpty() ? "" : " + "+literal(patch)));
      template = template.replace("{{version-expr}}", "VERSION_MAJOR_MINOR_PATCH"+(qualifier.isEmpty() ? "" : " + "+literal(qualifier)));
    } else {
      template = template.replace("{{version-mm-expr}}", literal(mm));
      template = template.replace("{{version-mmp-expr}}", literal(base));
      template = template.replace("{{version-expr}}", literal(version));
    }

    // retained for configuration folders that predate the {{version-*-expr}} forms above (the -config
    // folder is user provided). These appear inside a string literal in the template, so the value is
    // escaped but not quoted
    template = template.replace("{{version}}", escapeJavaString(version));
    template = template.replace("{{version-mm}}", escapeJavaString(mm));
    template = template.replace("{{version-base}}", escapeJavaString(base));
    template = template.replace("{{date}}", genDate);

    write(template);
    flush();
    close();
  }

  private String literal(String s) {
    return "\"" + escapeJavaString(s) + "\"";
  }

}