package org.hl7.fhir.r5.context;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

import java.util.*;

public interface IOIDServices {

  public static class OIDDefinitionComparer implements Comparator<OIDDefinition> {

    @Override
    public int compare(OIDDefinition o1, OIDDefinition o2) {
      if (o1.getUrl().equals(o2.getUrl())) {
        return -o1.getVersion().compareTo(o2.getVersion());
      } else {
        return o1.getUrl().compareTo(o2.getUrl());
      }
    }
  }

  public static class OIDDefinition {
    private String type;
    private String oid;
    private String url;
    private String version;
    private String packageSrc;
    private String status;
    protected OIDDefinition(String type, String oid, String url, String version, String status, String packageSrc) {
      super();
      this.type = type;
      this.oid = oid;
      this.url = url;
      this.version = version == null ? "" : version;
      this.packageSrc = packageSrc;
      this.status = status;
    }
    public String getType() {
      return type;
    }
    public String getOid() {
      return oid;
    }
    public String getUrl() {
      return url;
    }
    public String getVersion() {
      return version;
    }
    public String getStatus() {
      return status;
    }
    public String getPackageSrc() {
      return packageSrc;
    }
    public String summary() {
      return url+(version == null ? "" : "|"+version)+(packageSrc != null ? "("+packageSrc+")" : "");
    }
    public boolean matches(OIDDefinition t) {
      return url.equals(t.url) && version.equals(t.version);
    }

  }

  public static class OIDSummary {
    private List<OIDDefinition> definitions = new ArrayList<>();
    private List<String> urls = new ArrayList<>();

    public void addOID(OIDDefinition d) {
      for (OIDDefinition t : definitions) {
        if (d.matches(t)) {
          return;
        }
      }
      definitions.add(d);
      if (!urls.contains(d.getUrl())) {
        urls.add(d.getUrl());
      }
    }

    public void addOIDs(Collection<OIDDefinition> collection) {
      for (OIDDefinition t : collection) {
        addOID(t);
      }
    }

    public List<OIDDefinition> getDefinitions() {
      return definitions;
    }

    public void sort() {
      Collections.sort(definitions, new OIDDefinitionComparer());
      Collections.sort(urls);
    }
    public String describe() {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (OIDDefinition d : definitions) {
        b.append(d.summary());
      }
      return b.toString();
    }

    public String chooseBestUrl() {
      for (OIDDefinition d : definitions) {
        if (d.getPackageSrc() == null) {
          return d.getUrl();
        }
      }
      for (OIDDefinition d : definitions) {
        if (d.getUrl().startsWith("http://hl7.org/fhir/")) {
          return d.getUrl();
        }
      }
      for (OIDDefinition d : definitions) {
        if (!d.getUrl().contains("vsac")) {
          return d.getUrl();
        }
      }
      return null;
    }

    public int urlCount() {
      return urls.size();
    }

    public String getUrl() {
      return urls.iterator().next();
    }
  }

  public IOIDServices.OIDSummary urlsForOid(String oid, String resourceType);

}
