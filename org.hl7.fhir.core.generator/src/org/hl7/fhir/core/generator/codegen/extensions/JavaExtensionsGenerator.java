package org.hl7.fhir.core.generator.codegen.extensions;

import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.core.generator.analysis.AnalysisElementInfo;
import org.hl7.fhir.core.generator.codegen.Configuration;
import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.Utilities;

public class JavaExtensionsGenerator {

  private String path;
  private Definitions master;
  private Configuration config;
  private String date;
  private String version;
  private String jid;
  private Map<String, AnalysisElementInfo> elementInfo;
  private Set<String> genClassList;

  public JavaExtensionsGenerator(String path, Definitions master, Configuration config, String date, String version,
      String jid, Map<String, AnalysisElementInfo> elementInfo, Set<String> genClassList) {
    this.path = path;
    this.master = master;
    this.config = config;
    this.date = date;
    this.version = version;
    this.jid = jid;
    this.elementInfo = elementInfo;
    this.genClassList = genClassList;

  }

  public void generate(Map<String, StructureDefinition> extensions) throws Exception {
    List<String> urls = Utilities.sorted(extensions.keySet());
    Set<String> names = new HashSet<>();
    Set<String> dups = new HashSet<>();
    for (StructureDefinition sd : extensions.values()) {
      if (names.contains(sd.getName())) {
        dups.add(sd.getName());
      } else {
        names.add(sd.getName());
      }
    }
    for (StructureDefinition sd : extensions.values()) {
      if (config.getIni().hasProperty("ExtensionNames", sd.getUrl())) {
        sd.setUserData("name", config.getIni().getStringProperty("ExtensionNames", sd.getUrl()));        
      } else if (dups.contains(sd.getName())) {
        sd.setUserData("name", sanitiseName(sd.getName())+Utilities.capitalize(sd.getUserString("source")));
      } else {
        sd.setUserData("name", sanitiseName(sd.getName()));
      }
    }    

    JavaExtensionsFactoryGenerator gen = new JavaExtensionsFactoryGenerator(new FileOutputStream(Utilities.path(path, "Extensions.java")), master, config, version, date, jid, elementInfo, genClassList);
    gen.start();
    JavaConstantsGenerator cgen = new JavaConstantsGenerator(new FileOutputStream(Utilities.path(path, "ExtensionConstants.java")), master, config, version, date, jid);
    cgen.start();
    for (String url : urls) {
      StructureDefinition sd = extensions.get(url);
      String name = sd.getUserString("name");
      String nConst = genConstantName(name);
      cgen.generate(sd, name, nConst);        
      if (ProfileUtilities.isModifierExtension(sd)) {
        cgen.seeModifier(sd);
      }
      if (ProfileUtilities.isSimpleExtension(sd)) {
        gen.generateSimple(sd, name, nConst);
      }
    }
    cgen.finish();
    gen.finish();
  }

  private String sanitiseName(String name) {
    return Utilities.capitalize(name.replace("-", "").replace(" ", ""));
  }

  private String genConstantName(String name) {
    StringBuilder b = new StringBuilder();
    boolean hasLower = false;
    for (int i = 0; i < name.length(); i++) {

      char ch = name.charAt(i);
      if (!Utilities.existsInList(ch, ' ', '-')) {
        if (hasLower && Character.isUpperCase(ch)) {
          b.append("_");
        }
        if (Character.isLowerCase(ch)) {
          hasLower = true;
        }
        b.append(Character.toUpperCase(ch));
      }
    }
    return b.toString();
  }


}
