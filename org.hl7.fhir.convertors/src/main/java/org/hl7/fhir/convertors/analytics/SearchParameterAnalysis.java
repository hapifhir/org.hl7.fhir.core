package org.hl7.fhir.convertors.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.convertors.analytics.PackageVisitor.IPackageVisitorProcessor;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.xml.sax.SAXException;

public class SearchParameterAnalysis implements IPackageVisitorProcessor {

  public static class SearchParameterTypeUsage {
    private Set<String> coreUsage = new HashSet<>(); 
    private Set<String> igUsage = new HashSet<>();
    public String summary() {
      return ""+coreUsage.size()+" / "+igUsage.size();
    }
  }
  
  public static class SearchParameterType {
    private Map<String, SearchParameterTypeUsage> usages = new HashMap<>();
    public void seeUsage(boolean core, String usage, String url) {
      if (!usages.containsKey(usage)) {
        usages.put(usage, new SearchParameterTypeUsage());       
      }
      SearchParameterTypeUsage tu = usages.get(usage);
      if (core) {
        tu.coreUsage.add(url);
      } else {
        tu.igUsage.add(url);
      }
      
    } 
  }
  
  public static class SearchParameterVersionAnalysis {
    private Map<String, SearchParameterType> types = new HashMap<>();
    private String version;
    
    public void seeUsage(boolean core, String type, String usage, String url) {
//      System.out.println("v"+version+" "+Utilities.padRight(url, ' ', 60)+" "+type+"/"+usage);
      if (type == null) {
        type = "n/a";
      }
      if (usage == null) {
        usage = "n/a";
      }
      if (!types.containsKey(type)) {
        types.put(type, new SearchParameterType());
      }
      SearchParameterType tu = types.get(type);
      tu.seeUsage(core, usage, url);
    }

    public void printSummary() {
      Set<String> usages = new HashSet<>();
      for (SearchParameterType tu : types.values()) {
        usages.addAll(tu.usages.keySet());
      }
      List<String> ul = new ArrayList<String>();
      ul.addAll(usages);
      Collections.sort(ul);
      System.out.print(Utilities.padRight("", ' ', 10));
      for (String u : ul) {
        System.out.print(Utilities.padRight(u, ' ', 10));        
      }
      System.out.println();
      for (String t : types.keySet()) {
        System.out.print(Utilities.padRight(t, ' ', 10));
        SearchParameterType tu = types.get(t);
        for (String u : ul) {
          SearchParameterTypeUsage uu = tu.usages.get(u);
          if (uu == null) {
            System.out.print(Utilities.padRight("0 / 0", ' ', 10));
          } else {
            System.out.print(Utilities.padRight(uu.summary(), ' ', 10));            
          }
        }
        System.out.println();
      }
      
    }
    
  }
  
  private Map<String, SearchParameterVersionAnalysis> versions = new HashMap<String, SearchParameterAnalysis.SearchParameterVersionAnalysis>();
  
  @Override
  public void processResource(String pid, NpmPackage npm, String version, String type, String id, byte[] content) throws FHIRException {
//    System.out.println("v"+version+" "+type+" from "+pid);    
    boolean core = pid.startsWith("hl7.fhir.r") && (pid.contains(".core") || pid.contains(".examples"));
    version = VersionUtilities.getMajMin(version);
    if (!versions.containsKey(version)) {
      versions.put(version, new SearchParameterVersionAnalysis());
      versions.get(version).version = version;
    }
    try {
    if (VersionUtilities.isR5Plus(version)) {
      processR5SP(core, versions.get(version), content);
    } else if (VersionUtilities.isR4BVer(version)) {
      processR4SP(core, versions.get(version), content);
    } else if (VersionUtilities.isR4Ver(version)) {
      processR4SP(core, versions.get(version), content);
    } else if (VersionUtilities.isR3Ver(version)) {
      processR3SP(core, versions.get(version), content);
    } else if (VersionUtilities.isR2Ver(version)) {
      processR2SP(core, versions.get(version), content);
    } 
    } catch (IOException e) {
      throw new FHIRException(e);
    }
  }

  private void processR5SP(boolean core, SearchParameterVersionAnalysis analysis, byte[] content) throws FHIRFormatError, IOException {
    org.hl7.fhir.r5.model.Resource res = new org.hl7.fhir.r5.formats.JsonParser().parse(content);
    if (res instanceof org.hl7.fhir.r5.model.Bundle) {
      for (org.hl7.fhir.r5.model.Bundle.BundleEntryComponent bnd : ((org.hl7.fhir.r5.model.Bundle) res).getEntry()) {
        if (bnd.getResource() != null && bnd.getResource() instanceof org.hl7.fhir.r5.model.SearchParameter) {
          org.hl7.fhir.r5.model.SearchParameter sp = (org.hl7.fhir.r5.model.SearchParameter) bnd.getResource();
          analysis.seeUsage(core, sp.getTypeElement().primitiveValue(), sp.getProcessingModeElement().primitiveValue(), sp.getUrl());          
        }
      }
    } else {
      org.hl7.fhir.r5.model.SearchParameter sp = (org.hl7.fhir.r5.model.SearchParameter) res;
      analysis.seeUsage(core, sp.getTypeElement().primitiveValue(), sp.getProcessingModeElement().primitiveValue(), sp.getUrl());
    }
  }

  private void processR4SP(boolean core, SearchParameterVersionAnalysis analysis, byte[] content) throws FHIRFormatError, IOException {
    org.hl7.fhir.r4.model.Resource res = new org.hl7.fhir.r4.formats.JsonParser().parse(content);
    if (res instanceof org.hl7.fhir.r4.model.Bundle) {
      for (org.hl7.fhir.r4.model.Bundle.BundleEntryComponent bnd : ((org.hl7.fhir.r4.model.Bundle) res).getEntry()) {
        if (bnd.getResource() != null && bnd.getResource() instanceof org.hl7.fhir.r4.model.SearchParameter) {
          org.hl7.fhir.r4.model.SearchParameter sp = (org.hl7.fhir.r4.model.SearchParameter) bnd.getResource();
          analysis.seeUsage(core, sp.getTypeElement().primitiveValue(), sp.getXpathUsageElement().primitiveValue(), sp.getUrl());          
        }
      }
    } else {
      org.hl7.fhir.r4.model.SearchParameter sp = (org.hl7.fhir.r4.model.SearchParameter) res;
      analysis.seeUsage(core, sp.getTypeElement().primitiveValue(), sp.getXpathUsageElement().primitiveValue(), sp.getUrl());
    }
  }

  private void processR3SP(boolean core, SearchParameterVersionAnalysis analysis, byte[] content) throws FHIRFormatError, IOException {
    org.hl7.fhir.dstu3.model.Resource res = new org.hl7.fhir.dstu3.formats.JsonParser().parse(content);
    if (res instanceof org.hl7.fhir.dstu3.model.Bundle) {
      for (org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent bnd : ((org.hl7.fhir.dstu3.model.Bundle) res).getEntry()) {
        if (bnd.getResource() != null && bnd.getResource() instanceof org.hl7.fhir.dstu3.model.SearchParameter) {
          org.hl7.fhir.dstu3.model.SearchParameter sp = (org.hl7.fhir.dstu3.model.SearchParameter) bnd.getResource();
          analysis.seeUsage(core, sp.getTypeElement().primitiveValue(), sp.getXpathUsageElement().primitiveValue(), sp.getUrl());          
        }
      }
    } else {
      org.hl7.fhir.dstu3.model.SearchParameter sp = (org.hl7.fhir.dstu3.model.SearchParameter) res;
      analysis.seeUsage(core, sp.getTypeElement().primitiveValue(), sp.getXpathUsageElement().primitiveValue(), sp.getUrl());
    }
  }

  private void processR2SP(boolean core, SearchParameterVersionAnalysis analysis, byte[] content) throws FHIRFormatError, IOException {
    org.hl7.fhir.dstu2.model.Resource res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(content);
    if (res instanceof org.hl7.fhir.dstu2.model.Bundle) {
      for (org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent bnd : ((org.hl7.fhir.dstu2.model.Bundle) res).getEntry()) {
        if (bnd.getResource() != null && bnd.getResource() instanceof org.hl7.fhir.dstu2.model.SearchParameter) {
          org.hl7.fhir.dstu2.model.SearchParameter sp = (org.hl7.fhir.dstu2.model.SearchParameter) bnd.getResource();
          analysis.seeUsage(core, sp.getTypeElement().primitiveValue(), sp.getXpathUsageElement().primitiveValue(), sp.getUrl());          
        }
      }
    } else {
      org.hl7.fhir.dstu2.model.SearchParameter sp = (org.hl7.fhir.dstu2.model.SearchParameter) res;
      analysis.seeUsage(core, sp.getTypeElement().primitiveValue(), sp.getXpathUsageElement().primitiveValue(), sp.getUrl());
    }
  }

  public static void main(String[] args) throws Exception {
    new SearchParameterAnalysis().execute();
  }

  private void execute() throws IOException, ParserConfigurationException, SAXException {
    PackageVisitor pv = new PackageVisitor();
    pv.getResourceTypes().add("SearchParameter");
    pv.getResourceTypes().add("Bundle");
    pv.setOldVersions(false);
    pv.setCorePackages(true);
    pv.setProcessor(this);
    pv.visitPackages();

    printSummary();
  }

  private void printSummary() {
      for (String v : versions.keySet()) {
        System.out.println("-- v"+v+"---------------------");
        versions.get(v).printSummary();
        System.out.println("");
      }
      
  }
}
