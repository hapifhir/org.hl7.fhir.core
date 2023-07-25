package org.hl7.fhir.convertors.misc.utg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Provenance;
import org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;

public class UTGVersionSorter {

  private final Date runTime = new Date();
  private FilesystemPackageCacheManager pcm;

  public static void main(String[] args) throws FHIRException, IOException, ParseException, URISyntaxException {
    new UTGVersionSorter().execute("C:\\work\\org.hl7.fhir.igs\\UTG\\input\\sourceOfTruth");
  }

  private void execute(String source) throws IOException {
    List<CanonicalResourceAnalysis> list = new ArrayList<>();
    System.out.println("Loading UTG");
    loadFromSource(list, new File(source));

    Map<String, CanonicalResource> r2 = loadPackageR2("hl7.fhir.r2.core");
    Map<String, CanonicalResource> r3 = loadPackageR3("hl7.fhir.r3.core");
    Map<String, CanonicalResource> r4 = loadPackageR4("hl7.fhir.r4.core");

    System.out.println("Processing");
    for (CanonicalResourceAnalysis cr : list) {
      cr.analyse(r2, r3, r4);
    }

    Bundle b = (Bundle) new JsonParser().parse(new FileInputStream("C:\\work\\org.hl7.fhir.igs\\UTG\\input\\sourceOfTruth\\history\\utgrel1hx-1-0-6.json"));

    System.out.println("Summary");
    for (CanonicalResourceAnalysis cr : list) {
      System.out.println(cr.summary());
      Provenance p = new Provenance();
      b.addEntry().setResource(p).setFullUrl("http://terminology.hl7.org/fhir/Provenance/fhir-1.0.51-" + cr.getId());
      p.setId("hx-fhir-1.0.51-" + cr.getId());
      p.addTarget().setReference(cr.fhirType() + "/" + cr.getId());
      p.getOccurredPeriod().setEnd(runTime, TemporalPrecisionEnum.DAY);
      p.setRecorded(runTime);
      p.addAuthorization().getConcept().setText("Reset Version after migration to UTG").addCoding("http://terminology.hl7.org/CodeSystem/v3-ActReason", "METAMGT", null);
      p.getActivity().addCoding("http://terminology.hl7.org/CodeSystem/v3-DataOperation", "UPDATE", null);
      ProvenanceAgentComponent pa = p.addAgent();
      pa.getType().addCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "author", null);
      pa.getWho().setDisplay("Grahame Grieve");
      pa = p.addAgent();
      pa.getType().addCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "custodian", null);
      pa.getWho().setDisplay("Vocabulary WG");
      CanonicalResource res = cr.resource;
      res.setVersion(cr.recommendation);
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(cr.filename), res);
    }
    System.out.println();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream("C:\\work\\org.hl7.fhir.igs\\UTG\\input\\sourceOfTruth\\history\\utgrel1hx-1-0-6.json"), b);
    System.out.println("Done");
  }

  private Map<String, CanonicalResource> loadPackageR2(String id) throws IOException {
    Map<String, CanonicalResource> res = new HashMap<>();
    if (pcm == null) {
      pcm = new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER);
    }
    System.out.println("Load " + id);
    NpmPackage npm = pcm.loadPackage(id);
    for (PackageResourceInformation p : npm.listIndexedResources("CodeSystem", "ValueSet")) {
      CanonicalResource r = (CanonicalResource) VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(npm.load(p)));
      res.put(r.getUrl(), r);
    }
    return res;
  }

  private Map<String, CanonicalResource> loadPackageR3(String id) throws IOException {
    Map<String, CanonicalResource> res = new HashMap<>();
    if (pcm == null) {
      pcm = new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER);
    }
    System.out.println("Load " + id);
    NpmPackage npm = pcm.loadPackage(id);
    for (PackageResourceInformation p : npm.listIndexedResources("CodeSystem", "ValueSet")) {
      CanonicalResource r = (CanonicalResource) VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(npm.load(p)));
      res.put(r.getUrl(), r);
    }
    return res;
  }

  private Map<String, CanonicalResource> loadPackageR4(String id) throws IOException {
    Map<String, CanonicalResource> res = new HashMap<>();
    if (pcm == null) {
      pcm = new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER);
    }
    System.out.println("Load " + id);
    NpmPackage npm = pcm.loadPackage(id);
    for (PackageResourceInformation p : npm.listIndexedResources("CodeSystem", "ValueSet")) {
      CanonicalResource r = (CanonicalResource) VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(npm.load(p)));
      res.put(r.getUrl(), r);
    }
    return res;
  }

  private void loadFromSource(List<CanonicalResourceAnalysis> list, File source) {
    for (File f : source.listFiles()) {
      if (f.isDirectory()) {
        loadFromSource(list, f);
      } else if (f.getName().endsWith(".xml")) {
        try {
          Resource r = new XmlParser().parse(new FileInputStream(f));
          if (r instanceof CanonicalResource) {
            CanonicalResource cr = (CanonicalResource) r;
            cr.setWebPath(f.getAbsolutePath());
            if (cr.hasVersion() && cr.getVersion().startsWith("4.") && !Utilities.existsInList(cr.getId(), "v3-DataOperation", "v3-KnowledgeSubjectObservationValue")) {
              list.add(new CanonicalResourceAnalysis(cr, f.getAbsolutePath()));
            }
          }
        } catch (Exception e) {
          System.out.println(f.getAbsolutePath() + " not a resource? " + e.getMessage());
        }
      }
    }

  }

  public class CanonicalResourceAnalysis {

    private final CanonicalResource resource;
    private final String filename;
    private CanonicalResource r2;
    private CanonicalResource r3;
    private CanonicalResource r4;
    private String fmm;
    private boolean normative;
    private String recommendation;

    public CanonicalResourceAnalysis(CanonicalResource cr, String filename) {
      this.resource = cr;
      this.filename = filename;
    }

    public String summary() {
//      return "Relevant: "+resource.getUrl()+" [r2: "+r2Ver+"/"+r2Fmm+"]"+" [r3: "+r3Ver+"/"+r3Fmm+"]"+" [r4: "+r4Ver+"/"+r4Fmm+"/"+r4Normative+"] ---> "+recommendation;
      return resource.getUrl() + " ---> " + recommendation + "   in " + filename;
    }

    public void analyse(Map<String, CanonicalResource> r2l, Map<String, CanonicalResource> r3l, Map<String, CanonicalResource> r4l) {
      r2 = findMatch(r2l);
      r3 = findMatch(r3l);
      r4 = findMatch(r4l);

      fmm = r4 != null ? ToolingExtensions.readStringExtension(r4, ToolingExtensions.EXT_FMM_LEVEL) : null;
      normative = (r4 != null) && ToolingExtensions.readStringExtension(r4, ToolingExtensions.EXT_NORMATIVE_VERSION) != null;
      if (normative) {
        recommendation = "1.0.0";
      } else if (Utilities.existsInList(fmm, "3", "4", "5")) {
        recommendation = "0.5.0";
      } else {
        int i = 1;
        if (r2 != null && r3 != null && !match(r2, r3, r2l, r3l)) {
          i++;
        }
        if (r3 != null && r4 != null && !match(r3, r4, r3l, r4l)) {
          i++;
        }
        recommendation = "0." + i + ".0";
      }
    }

    private boolean match(CanonicalResource l, CanonicalResource r, Map<String, CanonicalResource> ll, Map<String, CanonicalResource> rl) {
      if (l instanceof CodeSystem && r instanceof CodeSystem) {
        return matchCS((CodeSystem) l, (CodeSystem) r);
      } else if (l instanceof ValueSet && r instanceof ValueSet) {
        return matchVS((ValueSet) l, (ValueSet) r, ll, rl);
      } else {
        return false;
      }
    }

    private boolean matchVS(ValueSet l, ValueSet r, Map<String, CanonicalResource> ll, Map<String, CanonicalResource> rl) {
      if (l.getCompose().getInclude().size() == 1 && l.getCompose().getExclude().isEmpty() && l.getCompose().getIncludeFirstRep().hasSystem() && !l.getCompose().getIncludeFirstRep().hasConcept() && !l.getCompose().getIncludeFirstRep().hasFilter() &&
        r.getCompose().getInclude().size() == 1 && r.getCompose().getExclude().isEmpty() && r.getCompose().getIncludeFirstRep().hasSystem() && !r.getCompose().getIncludeFirstRep().hasConcept() && !r.getCompose().getIncludeFirstRep().hasFilter()) {
        CodeSystem lc = (CodeSystem) ll.get(l.getCompose().getIncludeFirstRep().getSystem());
        CodeSystem rc = (CodeSystem) rl.get(l.getCompose().getIncludeFirstRep().getSystem());
        if (lc != null && rc != null) {
          return matchCS(lc, rc);
        }
      }
      return false;
    }

    private boolean matchCS(CodeSystem l, CodeSystem r) {
      return Base.compareDeep(l.getConcept(), r.getConcept(), false);
    }

    public CanonicalResource findMatch(Map<String, CanonicalResource> r2) {
      CanonicalResource r = r2.get(resource.getUrl());
      if (r == null) {
        r = r2.get(resource.getUrl().replaceAll("http://terminology.hl7.org/", "http://hl7.org/fhir/"));
      }
      if (r == null) {
        r = r2.get(resource.getUrl().replaceAll("http://terminology.hl7.org/CodeSystem", "http://hl7.org/fhir/"));
      }
      return r;
    }

    public String getId() {
      return resource.getId();
    }

    public String fhirType() {
      return resource.fhirType();
    }

  }


}
