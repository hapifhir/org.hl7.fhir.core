package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackageResourceInformation;
import org.hl7.fhir.utilities.npm.ToolsVersion;

public class UTGVersionSorter {

  private FilesystemPackageCacheManager pcm;

  public class CanonicalResourceAnalysis {

    private CanonicalResource resource;
    private CanonicalResource r2;
    private CanonicalResource r3;
    private CanonicalResource r4;
    private String fmm;
    private boolean normative;
    private String recommendation;

    public CanonicalResourceAnalysis(CanonicalResource cr) {
      this.resource = cr;
    }

    public String summary() {
//      return "Relevant: "+resource.getUrl()+" [r2: "+r2Ver+"/"+r2Fmm+"]"+" [r3: "+r3Ver+"/"+r3Fmm+"]"+" [r4: "+r4Ver+"/"+r4Fmm+"/"+r4Normative+"] ---> "+recommendation;
      return resource.getUrl()+" ---> "+recommendation;
    }

    public void analyse(Map<String, CanonicalResource> r2l, Map<String, CanonicalResource> r3l, Map<String, CanonicalResource> r4l) {
      r2 = findMatch(r2l);
      r3 = findMatch(r3l);
      r4 = findMatch(r4l);
      
      fmm = r4 != null ? ToolingExtensions.readStringExtension(r4, ToolingExtensions.EXT_FMM_LEVEL) : null;
      normative = (r4 != null) && ToolingExtensions.readStringExtension(r4, ToolingExtensions.EXT_NORMATIVE_VERSION) != null;
      if (normative) {
        recommendation = "1.0.0";
      } else if (Utilities.existsInList(fmm,"3", "4", "5")) {
        recommendation = "0.5.0";        
      } else {
        int i = 1;
        if (r2 != null && r3 != null && !match(r2, r3, r2l, r3l)) {
          i++;
        }
        if (r3 != null && r4 != null && !match(r3, r4, r3l, r4l)) {
          i++;
        }
        recommendation = "0."+i+".0";
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

  }

  public static void main(String[] args) throws FileNotFoundException, FHIRException, IOException, ParseException, URISyntaxException {
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
      cr.analyse(r2,r3,r4);
    }
    
    System.out.println("Summary");
    for (CanonicalResourceAnalysis cr : list) {
      System.out.println(cr.summary());
    }
    System.out.println();
    System.out.println("Done");
  }

  private Map<String, CanonicalResource> loadPackageR2(String id) throws IOException {
    Map<String, CanonicalResource>res = new HashMap<>();
    if (pcm == null) {
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    }
    System.out.println("Load "+id);
    NpmPackage npm = pcm.loadPackage(id);
    for (PackageResourceInformation p : npm.listIndexedResources("CodeSystem", "ValueSet")) {
      CanonicalResource r = (CanonicalResource) VersionConvertor_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(npm.load(p)));
      res.put(r.getUrl(), r);
    }
    return res;
  }

  private Map<String, CanonicalResource> loadPackageR3(String id) throws IOException {
    Map<String, CanonicalResource>res = new HashMap<>();
    if (pcm == null) {
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    }
    System.out.println("Load "+id);
    NpmPackage npm = pcm.loadPackage(id);
    for (PackageResourceInformation p : npm.listIndexedResources("CodeSystem", "ValueSet")) {
      CanonicalResource r = (CanonicalResource) VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(npm.load(p)), false);
      res.put(r.getUrl(), r);
    }
    return res;
  }

  private Map<String, CanonicalResource> loadPackageR4(String id) throws IOException {
    Map<String, CanonicalResource>res = new HashMap<>();
    if (pcm == null) {
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    }
    System.out.println("Load "+id);
    NpmPackage npm = pcm.loadPackage(id);
    for (PackageResourceInformation p : npm.listIndexedResources("CodeSystem", "ValueSet")) {
      CanonicalResource r = (CanonicalResource) VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(npm.load(p)));
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
            cr.setUserData("path", f.getAbsolutePath());
            if (cr.hasVersion() && cr.getVersion().startsWith("4.")) {
              list.add(new CanonicalResourceAnalysis(cr));
            }
          }
        } catch (Exception e) {
          System.out.println(f.getAbsolutePath()+" not a resource? "+e.getMessage());
        }
      }
    }
    
  }
  
  
  
}
