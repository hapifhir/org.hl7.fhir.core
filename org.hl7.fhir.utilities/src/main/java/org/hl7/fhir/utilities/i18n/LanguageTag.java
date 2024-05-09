package org.hl7.fhir.utilities.i18n;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.subtag.LanguageSubtagRegistry;

public class LanguageTag {

  private String code;
  private String language;
  private String script;
  private String region;
  private String variant;
  private String extension;
  private List<String> extLang;
  private List<String> privateUse;
  private LanguageSubtagRegistry registry;

  public LanguageTag(LanguageSubtagRegistry registry, String code) {
    this.registry = registry;
    this.code = code;

    if (!Utilities.noString(code)) {
      String[] parts = code.split("\\-");
      int c = 0;
      int t = parts.length;
      if (!registry.hasLanguage(parts[c])) {
        throw new FHIRException("Invalid Language code '"+parts[c]+'"');
      } else {
        language = parts[c];
        c++;
        for (int i = 1; i <= 3; i++) {
          if (c < t && registry.hasExtLanguage(parts[c])) {
            if (extLang == null) {
              extLang = new ArrayList<>();
            }
            extLang.add(parts[c]);
            c++;
          }        
        }

        if (c < t && registry.hasScript(parts[c])) {
          script = parts[c];
          c++;
        }

        if (c < t && registry.hasRegion(parts[c])) {
          region = parts[c];
          c++;
        }
        if (c < t && registry.hasVariant(parts[c])) {
          variant = parts[c];
          c++;
        }
        while (c < t && parts[c].startsWith("x")) {
          if (privateUse == null) {
            privateUse = new ArrayList<>();
          }
          privateUse.add(parts[c]);
          c++;
        }
        if (c < t) {
          throw new FHIRException( "Unable to recognise part "+(c+1)+" ('"+parts[c]+"') as a valid language part");
        }

      }                                  
    }
  }

  public String getCode() {
    return code;
  }

  public String getLanguage() {
    return language;
  }

  public String getScript() {
    return script;
  }

  public String getRegion() {
    return region;
  }

  public String getVariant() {
    return variant;
  }

  public String getExtension() {
    return extension;
  }

  public List<String> getExtLang() {
    return extLang;
  }

  public List<String> getPrivateUse() {
    return privateUse;
  }

  public String present() {
    StringBuilder b = new StringBuilder();
    b.append(registry.getLanguage(language).getDisplay());
    if (region != null) {
      b.append("/");
      b.append(registry.getRegion(region).getDisplay()); 
    }
    if (script != null || variant != null) {
      CommaSeparatedStringBuilder cb = new CommaSeparatedStringBuilder();
      if (script != null) {
        cb.append("Script="+ registry.getScript(script).getDisplay());
        if (variant != null) {
          cb.append("Variant="+ registry.getVariant(variant).getDisplay());
        }
        b.append(" (");
        b.append(cb.toString());
        b.append(")");
      }
    }
    return b.toString();

  }

}
