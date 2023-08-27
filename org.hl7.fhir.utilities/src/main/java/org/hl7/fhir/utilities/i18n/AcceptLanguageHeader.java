package org.hl7.fhir.utilities.i18n;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader.LanguagePreference;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader.LanguageSorter;

import net.sf.saxon.functions.Lang;

public class AcceptLanguageHeader {

  public class LanguageSorter implements Comparator<LanguagePreference> {

    @Override
    public int compare(LanguagePreference o1, LanguagePreference o2) {
      if (o1.getValue() == o2.getValue()) {
        return o1.getOrder() - o2.getOrder();
      } else if (o1.getValue() > o2.getValue()) {
        return -1;
      } else {
        return 1;
      }
    }

  }

  public class LanguagePreference {
    private int order;
    private String lang;
    private double value;
    public String getLang() {
      return lang;
    }
    public double getValue() {
      return value;
    }
    
    public int getOrder() {
      return order;
    }
    public LanguagePreference(int order, String lang, double value) {
      super();
      this.order = order;
      this.lang = lang;
      this.value = value;
    }

    @Override
    public String toString() {
      if (value == 1) {
        return lang;
      } else {
        return lang+"; q="+(String.format("%.6f", value).replaceAll("(\\.\\d+?)0*$", "$1")); //Double.toString(value);
      }
    }
  }

  private String source;
  private List<LanguagePreference> langs = new ArrayList<>();
  private boolean doWildcard;
  
  public String getSource() {
    return source;
  }

  public List<LanguagePreference> getLangs() {
    return langs;
  }

  public AcceptLanguageHeader(String source, boolean doWildcard) {
    super();
    this.doWildcard = doWildcard;
    this.source = source;
    process();
  }

  private void process() {
    langs.clear();
    String[] parts = source.split("\\,");
    boolean wildcard = false;
    for (int i = 0; i < parts.length; i++) {
      String lang = parts[i].trim();
      double weight = 1;
      if (lang.contains(";")) {
        String w = lang.substring(lang.indexOf(";")+1);
        if (w.contains("=")) {
          w = w.substring(w.indexOf("=")+1);
        }
        lang = lang.substring(0, lang.indexOf(";"));
        weight = Float.valueOf(w);
      }
      langs.add(new LanguagePreference(i, lang, weight));
      wildcard = wildcard || "*".equals(lang);
    }
    if (!wildcard && doWildcard) {
      langs.add(new LanguagePreference(100, "*", 0.01));
    }
    Collections.sort(langs, new LanguageSorter());

  }

  public boolean hasChosen() {
    for (LanguagePreference lang : langs) {
      if (lang.value == 1) {
        return true;
      }
    }
    return false;
  }
  public String getChosen() {
    for (LanguagePreference lang : langs) {
      if (lang.value == 1) {
        return lang.lang;
      }
    }
    return null;
  }

  public void add(String language) {
    source = toString()+","+language;
    process();
    
  }

  public AcceptLanguageHeader copy() {
    return new AcceptLanguageHeader(toString(), doWildcard);
  }

  @Override
  public String toString() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (LanguagePreference lang : langs) {
      b.append(lang.toString());
    }
    return b.toString();
  }


}
