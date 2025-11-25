package org.hl7.fhir.convertors.analytics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackagedResourceFile;
import org.hl7.fhir.utilities.npm.PackageClient;
import org.hl7.fhir.utilities.npm.PackageInfo;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

@Slf4j
public class PackageVisitor {

  private PackageServer clientPackageServer = null;

  public void setClientPackageServer(PackageServer packageServer) {
    this.clientPackageServer = packageServer;
  }
  private List<PackageServer> cachePackageServers = null;
  public void setCachePackageServers(List<PackageServer> packageServers) {
    this.cachePackageServers = packageServers;
  }

  public static class PackageContext {
    private String pid;
    private NpmPackage npm;
    private String version;
    protected PackageContext(String pid, NpmPackage npm, String version) {
      super();
      this.pid = pid;
      this.npm = npm;
      this.version = version;
    }
    public String getPid() {
      return pid;
    }
    public NpmPackage getNpm() {
      return npm;
    }
    public String getVersion() {
      return version;
    }
  }
  
  public interface IPackageVisitorProcessor {
    public Object startPackage(PackageContext context) throws FHIRException, IOException, EOperationOutcome;
    public void processResource(PackageContext context, Object clientContext, String type, String id, byte[] content) throws FHIRException, IOException, EOperationOutcome;
    public void finishPackage(PackageContext context) throws FHIRException, IOException, EOperationOutcome;

    public void alreadyVisited(String pid) throws FHIRException, IOException, EOperationOutcome;
  }

  private Set<String> resourceTypes = new HashSet<>();
  private List<String> versions = new ArrayList<>();
  private boolean corePackages;
  private boolean oldVersions;
  private boolean current;
  private IPackageVisitorProcessor processor;
  private FilesystemPackageCacheManager pcm;
  private PackageClient pc;
  private String cache;  
  private int step;

  public Set<String> getResourceTypes() {
    return resourceTypes;
  }

  public void setResourceTypes(Set<String> resourceTypes) {
    this.resourceTypes = resourceTypes;
  }

  public void setResourceTypes(String... resourceTypes) {
    this.resourceTypes = new HashSet<String>();
    for (String s : resourceTypes) {
      this.resourceTypes.add(s);
    }
  }

  public List<String> getVersions() {
    return versions;
  }

  public void setVersions(List<String> versions) {
    this.versions = versions;
  }


  public boolean isCurrent() {
    return current;
  }

  public void setCurrent(boolean current) {
    this.current = current;
  }

  public boolean isCorePackages() {
    return corePackages;
  }




  public String getCache() {
    return cache;
  }

  public void setCache(String cache) {
    this.cache = cache;
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

  public void visitPackages() throws IOException, ParserConfigurationException, SAXException, FHIRException, EOperationOutcome {
    log.info("Finding packages");
    pc = clientPackageServer == null
      ? new PackageClient(PackageServer.primaryServer())
      : new PackageClient(clientPackageServer);

    pcm = cachePackageServers == null
      ? new FilesystemPackageCacheManager.Builder().build()
      : new FilesystemPackageCacheManager.Builder().withPackageServers(cachePackageServers).build();

    Set<String> pidList = getAllPackages();

    Map<String, String> cpidMap = getAllCIPackages();
    Set<String> cpidSet = new HashSet<>();
    log.info("Go: "+cpidMap.size()+" current packages");
    int i = 0;
    for (String s : cpidMap.keySet()) {
      processCurrentPackage(cpidMap.get(s), s, cpidSet, i, cpidMap.size()); 
      i++;
    }

    log.info("Go: "+pidList.size()+" published packages");
    i = 0;
    for (String pid : pidList) {  
      if (pid != null) {
        if (!cpidSet.contains(pid)) {
          cpidSet.add(pid);
          if (step == 0 || step == 3) {
            List<String> vList = listVersions(pid);
            if (oldVersions) {
              for (String v : vList) {
                processPackage(pid, v, i, pidList.size());          
              }
            } else if (vList.isEmpty()) {
              log.info("No Packages for "+pid);
            } else {
              processPackage(pid, vList.get(vList.size() - 1), i, pidList.size());
            }
          }
        } else {
          processor.alreadyVisited(pid);
        }
        i++;
      }    
    }

    if (step == 0 || step == 3) {
      JsonObject json = JsonParser.parseObjectFromUrl("https://fhir.github.io/ig-registry/fhir-ig-list.json");
      i = 0;
      List<JsonObject> objects = json.getJsonObjects("guides");
      for (JsonObject o : objects) {
        String pid = o.asString("npm-name");
        if (pid != null && !cpidSet.contains(pid)) {
          cpidSet.add(pid);
          List<String> vList = listVersions(pid);
          if (oldVersions) {
            for (String v : vList) {
              processPackage(pid, v, i, objects.size());          
            }
          } else if (vList.isEmpty()) {
            log.info("No Packages for "+pid);
          } else {
            processPackage(pid, vList.get(vList.size() - 1), i, objects.size());
          }
        }
        i++;
      }
    }
  }

  private void processCurrentPackage(String url, String pid, Set<String> cpidSet, int i, int t) {
    try {
      cpidSet.add(pid);
      if (step == 0 || (step == 1 && i < t/2) || (step == 2 && i >= t/2)) {
        long ms1 = System.currentTimeMillis();
        String[] p = url.split("\\/");
        String repo = "https://build.fhir.org/ig/"+p[0]+"/"+p[1];
        JsonObject manifest = JsonParser.parseObjectFromUrl(repo+"/package.manifest.json");
        File co = ManagedFileAccess.file(Utilities.path(cache, pid+"."+manifest.asString("date")+".tgz"));
        if (!co.exists()) {

          HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), repo+"/package.tgz?nocache=" + System.currentTimeMillis());
          res.checkThrowException();
          FileUtilities.bytesToFile(res.getContent(), co);
        }
        NpmPackage npm = NpmPackage.fromPackage(ManagedFileAccess.inStream(co));          
        String fv = npm.fhirVersion();
        long ms2 = System.currentTimeMillis();

        if (corePackages || !corePackage(npm)) {
          if (fv != null && (versions.isEmpty() || versions.contains(fv))) {
            PackageContext ctxt = new PackageContext(pid+"#current", npm, fv);
            boolean ok = false;
            Object context = null;
            try {
              context = processor.startPackage(ctxt);
              ok = true;
            } catch (Exception e) {
              log.error("####### Error loading "+pid+"#current["+fv+"]: ####### "+e.getMessage());
              //                e.printStackTrace();
            }
            if (ok) {
              int c = 0;
              for (PackagedResourceFile pri : npm.listAllResources(resourceTypes)) {
                c++;
                try {
                  processor.processResource(ctxt, context, pri.getResourceType(), pri.getFilename(), FileUtilities.streamToBytes(npm.load(pri.getFolder(), pri.getFilename())));
                } catch (Exception e) {
                  log.error("####### Error loading "+pid+"#current["+fv+"]/"+pri.getResourceType()+" ####### "+e.getMessage());
                  //                e.printStackTrace();
                }
              }
              processor.finishPackage(ctxt);
              log.info("Processed: "+pid+"#current: "+c+" resources ("+i+" of "+t+", "+(ms2-ms1)+"/"+(System.currentTimeMillis()-ms2)+"ms)");
            }
          } else {
            log.info("Ignored: "+pid+"#current: no version");
          }
        }
      }
    } catch (Exception e) {      
      log.error("Unable to process: "+pid+"#current: "+e.getMessage());
    }
  }

  private Map<String, String> getAllCIPackages() throws IOException {
    log.info("Fetch https://build.fhir.org/ig/qas.json");
    Map<String, String> res = new HashMap<>();
    if (current) {
      JsonArray json = (JsonArray) JsonParser.parseFromUrl("https://build.fhir.org/ig/qas.json");
      for (JsonObject o  : json.asJsonObjects()) {
        String url = o.asString("repo");
        String pid = o.asString("package-id");
        if (url.contains("/branches/master") || url.contains("/branches/main") ) {
          if (!res.containsKey(pid)) {
            res.put(pid, url);
          } else if (!url.equals(res.get(pid))) {
            log.warn("Ignore "+url+" already encountered "+pid +" @ "+res.get(pid));
          }
        }
      }
    }
    return res;
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
    for (PackageInfo i : pc.search(null, null, null, false, null)) {
      list.add(i.getId());
    }    
    JsonObject json = JsonParser.parseObjectFromUrl("https://fhir.github.io/ig-registry/fhir-ig-list.json");
    for (JsonObject ig : json.getJsonObjects("guides")) {
      list.add(ig.asString("npm-name"));
    }
    json = JsonParser.parseObjectFromUrl("https://fhir.github.io/ig-registry/package-feeds.json");
    for (JsonObject feed : json.getJsonObjects("feeds")) {
      processFeed(list, feed.asString("url"));
    }

    return list;
  }

  private void processFeed(Set<String> list, String str) throws IOException, ParserConfigurationException, SAXException {
    log.info("Feed "+str);
    try {

      HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), str+"?nocache=" + System.currentTimeMillis());
      res.checkThrowException();
      Document xml = XMLUtil.parseToDom(res.getContent());
      for (Element channel : XMLUtil.getNamedChildren(xml.getDocumentElement(), "channel")) {
        for (Element item : XMLUtil.getNamedChildren(channel, "item")) {
          String pid = XMLUtil.getNamedChildText(item, "title");
          if (pid != null && pid.contains("#")) {
            list.add(pid.substring(0, pid.indexOf("#")));
          }
        }
      }
    } catch (Exception e) {
      log.error("   "+e.getMessage());
    }
  }


  private void processPackage(String pid, String v, int i, int t) throws IOException, FHIRException, EOperationOutcome {
    NpmPackage npm = null;
    String fv = null;
    try {
      npm = pcm.loadPackage(pid, v);
    } catch (Throwable e) {
      log.error("Unable to load package: "+pid+"#"+v+": "+e.getMessage());
      return;
    }

    try {
      fv = npm.fhirVersion();
    } catch (Throwable e) {
      log.error("Unable to identify package FHIR version:: "+pid+"#"+v+": "+e.getMessage());
    }
    if (corePackages || !corePackage(npm)) {
      PackageContext ctxt = new PackageContext(pid+"#"+v, npm, fv);
      boolean ok = false;
      Object context = null;
      try {
        context = processor.startPackage(ctxt);
        ok = true;
      } catch (Exception e) {
        log.error("####### Error loading package  "+pid+"#"+v +"["+fv+"]: "+e.getMessage(), e);
      }
      if (ok) {
        int c = 0;
        if (fv != null && (versions.isEmpty() || versions.contains(fv))) {
          for (PackagedResourceFile p : npm.listAllResources(resourceTypes)) {
            c++;
            try {
              processor.processResource(ctxt, context, p.getResourceType(), p.getFilename(), FileUtilities.streamToBytes(npm.load(p.getFolder(), p.getFilename())));
            } catch (Exception e) {
              log.error("####### Error loading "+pid+"#"+v +"["+fv+"]/"+p.getResourceType()+" ####### "+e.getMessage(), e);
            }
          }
        }    
        processor.finishPackage(ctxt);
        log.info("Processed: "+pid+"#"+v+": "+c+" resources ("+i+" of "+t+")");
      }
    }
  }

  private boolean corePackage(NpmPackage npm) {
    return npm != null && !Utilities.noString(npm.name()) && (
        npm.name().startsWith("hl7.terminology") || 
        npm.name().startsWith("hl7.fhir.core") || 
        npm.name().startsWith("hl7.fhir.r2.") || 
        npm.name().startsWith("hl7.fhir.r2b.") || 
        npm.name().startsWith("hl7.fhir.r3.") || 
        npm.name().startsWith("hl7.fhir.r4.") || 
        npm.name().startsWith("hl7.fhir.r4b.") || 
        npm.name().startsWith("hl7.fhir.r5."));
  }

  public int getStep() {
    return step;
  }

  public void setStep(int step) {
    this.step = step;
  }

}
