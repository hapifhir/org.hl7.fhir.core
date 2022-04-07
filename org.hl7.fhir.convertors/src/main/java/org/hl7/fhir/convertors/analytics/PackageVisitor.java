package org.hl7.fhir.convertors.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.json.JSONUtil;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageClient;
import org.hl7.fhir.utilities.npm.PackageInfo;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PackageVisitor {
  
  public interface IPackageVisitorProcessor {
     public void processResource(String pid, String version, String type, byte[] content) throws FHIRException;
  }

  private List<String> resourceTypes = new ArrayList<>();
  private List<String> versions = new ArrayList<>();
  private boolean corePackages;
  private boolean oldVersions;
  private IPackageVisitorProcessor processor;
  private FilesystemPackageCacheManager pcm;
  private PackageClient pc;  
  
  public List<String> getResourceTypes() {
    return resourceTypes;
  }

  public void setResourceTypes(List<String> resourceTypes) {
    this.resourceTypes = resourceTypes;
  }

  public List<String> getVersions() {
    return versions;
  }

  public void setVersions(List<String> versions) {
    this.versions = versions;
  }




  public boolean isCorePackages() {
    return corePackages;
  }




  public void setCorePackages(boolean corePackages) {
    this.corePackages = corePackages;
  }




  public boolean isOldVersions() {
    return oldVersions;
  }




  public void setOldVersions(boolean oldVersions) {
    this.oldVersions = oldVersions;
  }




  public IPackageVisitorProcessor getProcessor() {
    return processor;
  }

  public void setProcessor(IPackageVisitorProcessor processor) {
    this.processor = processor;
  }

  public void visitPackages() throws IOException, ParserConfigurationException, SAXException {
    System.out.println("Finding packages");
    pc = new PackageClient(PackageClient.PRIMARY_SERVER);
    pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    Set<String> pidList = getAllPackages();
    System.out.println("Go: "+pidList.size()+" packages");
    for (String pid : pidList) {
      List<String> vList = listVersions(pid);
      if (oldVersions) {
        for (String v : vList) {
          processPackage(pid, v);          
        }
      } else if (vList.isEmpty()) {
        System.out.println("No Packages for "+pid);
      } else {
        processPackage(pid, vList.get(vList.size() - 1));
      }
    }         
  }

  private List<String> listVersions(String pid) throws IOException {
    List<String> list = new ArrayList<>();
    if (pid !=null) {
      for (PackageInfo i : pc.getVersions(pid)) {
        list.add(i.getVersion());
      }    
    }
    return list;
  }

  private Set<String> getAllPackages() throws IOException, ParserConfigurationException, SAXException {
    Set<String> list = new HashSet<>();
    for (PackageInfo i : pc.search(null, null, null, false)) {
      list.add(i.getId());
    }    
    JsonObject json = JsonTrackingParser.fetchJson("https://raw.githubusercontent.com/FHIR/ig-registry/master/fhir-ig-list.json");
    for (JsonObject ig : JSONUtil.objects(json, "guides")) {
      list.add(JSONUtil.str(ig, "npm-name"));
    }
    json = JsonTrackingParser.fetchJson("https://raw.githubusercontent.com/FHIR/ig-registry/master/package-feeds.json");
    for (JsonObject feed : JSONUtil.objects(json, "feeds")) {
      processFeed(list, JSONUtil.str(feed, "url"));
    }
    
    return list;
  }

  private void processFeed(Set<String> list, String str) throws IOException, ParserConfigurationException, SAXException {
    System.out.println("Feed "+str);
    try {
      SimpleHTTPClient fetcher = new SimpleHTTPClient();
      HTTPResult res = fetcher.get(str+"?nocache=" + System.currentTimeMillis());
      res.checkThrowException();
      Document xml = XMLUtil.parseToDom(res.getContent());
      for (Element channel : XMLUtil.getNamedChildren(xml.getDocumentElement(), "channel")) {
        for (Element item : XMLUtil.getNamedChildren(channel, "item")) {
          String pid = XMLUtil.getNamedChildText(item, "title");
          if (pid.contains("#")) {
            list.add(pid.substring(0, pid.indexOf("#")));
          }
        }
      }
    } catch (Exception e) {
      System.out.println("   "+e.getMessage());
    }
  }


  private void processPackage(String pid, String v) throws IOException {
    NpmPackage npm = null;
    String fv = null;
    try {
      npm = pcm.loadPackage(pid, v);
      fv = npm.fhirVersion();
    } catch (Throwable e) {
      System.out.println("Unable to process: "+pid+"#"+v+": "+e.getMessage());      
    }
    int c = 0;
    if (fv != null && (versions.isEmpty() || versions.contains(fv))) {
      for (String type : resourceTypes) {
        for (String s : npm.listResources(type)) {
          c++;
          processor.processResource(pid+"#"+v, fv, type, TextFile.streamToBytes(npm.load("package", s)));
        }
      }
    }    
    System.out.println("Processed: "+pid+"#"+v+": "+c+" resources");      
  }

}
