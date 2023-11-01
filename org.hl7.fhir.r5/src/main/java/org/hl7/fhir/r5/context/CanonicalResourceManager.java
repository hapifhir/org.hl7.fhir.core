package org.hl7.fhir.r5.context;

import java.util.*;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.utilities.VersionUtilities;

/**
 * This manages a cached list of resources, and provides high speed access by URL / URL+version, and assumes that patch version doesn't matter for access
 * note, though, that not all resources have semver versions
 * 
 * @author graha
 *
 */

public class CanonicalResourceManager<T extends CanonicalResource> {

  private final String[] INVALID_TERMINOLOGY_URLS = {
    "http://snomed.info/sct",
    "http://dicom.nema.org/resources/ontology/DCM",
    "http://nucc.org/provider-taxonomy"
  };

  public static abstract class CanonicalResourceProxy {
    private String type;
    private String id;
    private String url;
    private String version;
    private String supplements;
    private String derivation;
    private CanonicalResource resource;
    private boolean hacked;
    
    public CanonicalResourceProxy(String type, String id, String url, String version, String supplements, String derivation) {
      super();
      this.type = type;
      this.id = id;
      this.url = url;
      this.version = version;
      this.supplements = supplements;
    }
    
    public String getType() {
      return type;
    }

    public String getId() {
      return id;
    }
    
    public String getUrl() {
      return url;
    }
    
    public String getVersion() {
      return version;
    }
    
    public boolean hasId() {
      return id != null;
    }
    
    public boolean hasUrl() {
      return url != null;
    }
    
    public boolean hasVersion() {
      return version != null;
    }
    
    public String getSupplements() {
      return supplements;
    }

    public String getDerivation() {
      return derivation;
    }

    public void setDerivation(String derivation) {
      this.derivation = derivation;
    }

    public CanonicalResource getResource() throws FHIRException {
      if (resource == null) {
        resource = loadResource();
        if (hacked) {
          resource.setUrl(url).setVersion(version);
        }
        if (resource instanceof CodeSystem) {
          CodeSystemUtilities.crossLinkCodeSystem((CodeSystem) resource);
        }
      }
      return resource;
    }

    public void setResource(CanonicalResource resource) {
      this.resource = resource;
    }

    public abstract CanonicalResource loadResource() throws FHIRException;

    @Override
    public String toString() {
      return type+"/"+id+": "+url+"|"+version;
    }

    public void hack(String url, String version) {
      this.url = url;
      this.version = version;
      this.hacked = true;

    }      
  }

  public static class CanonicalListSorter implements Comparator<CanonicalResource> {

    @Override
    public int compare(CanonicalResource arg0, CanonicalResource arg1) {
      String u0 = arg0.getUrl();
      String u1 = arg1.getUrl();
      return u0.compareTo(u1);
    }
  }

  public class CachedCanonicalResource<T1 extends CanonicalResource> {
    private T1 resource;
    private CanonicalResourceProxy proxy;
    private PackageInformation packageInfo;

    public CachedCanonicalResource(T1 resource, PackageInformation packageInfo) {
      super();
      this.resource = resource;
      this.packageInfo = packageInfo;
    }
    
    public CachedCanonicalResource(CanonicalResourceProxy proxy, PackageInformation packageInfo) {
      super();
      this.proxy = proxy;
      this.packageInfo = packageInfo;
    }
    
    public T1 getResource() {
      if (resource == null) {
        @SuppressWarnings("unchecked")
        T1 res = (T1) proxy.getResource();
        if (res == null) {
          throw new Error("Proxy loading a resource from "+packageInfo+" failed and returned null");
        }
        synchronized (this) {
          resource = res;
        }
        resource.setSourcePackage(packageInfo);
        proxy = null;
      }
      return resource;
    }
    
    public PackageInformation getPackageInfo() {
      return packageInfo;
    }
    public String getUrl() {
      return resource != null ? resource.getUrl() : proxy.getUrl();
    }
    public String getId() {
      return resource != null ? resource.getId() : proxy.getId();
    }
    public String getVersion() {
      return resource != null ? resource.getVersion() : proxy.getVersion();
    }
    public boolean hasVersion() {
      return resource != null ? resource.hasVersion() : proxy.getVersion() != null;
    }
    
    @Override
    public String toString() {
      return resource != null ? resource.fhirType()+"/"+resource.getId()+"["+resource.getUrl()+"|"+resource.getVersion()+"]" : proxy.toString();
    }

    public String supplements() {
      if (resource == null) {
        return proxy.getSupplements(); 
      } else {
        return resource instanceof CodeSystem ? ((CodeSystem) resource).getSupplements() : null;
      }
    }

    public Object getDerivation() {
      if (resource == null) {
        return proxy.getDerivation(); 
      } else {
        return resource instanceof StructureDefinition ? ((StructureDefinition) resource).getDerivationElement().primitiveValue() : null;
      }
    }  

  }

  public class MetadataResourceVersionComparator<T1 extends CachedCanonicalResource<T>> implements Comparator<T1> {
    @Override
    public int compare(T1 arg1, T1 arg2) {
      String v1 = arg1.getVersion();
      String v2 = arg2.getVersion();
      if (v1 == null && v2 == null) {
        return Integer.compare(list.indexOf(arg1), list.indexOf(arg2)); // retain original order
      } else if (v1 == null) {
        return -1;
      } else if (v2 == null) {
        return 1;
      } else {
        String mm1 = VersionUtilities.getMajMin(v1);
        String mm2 = VersionUtilities.getMajMin(v2);
        if (mm1 == null || mm2 == null) {
          return v1.compareTo(v2);
        } else {
          return mm1.compareTo(mm2);
        }
      }
    }
  }

  private boolean minimalMemory;
  private boolean enforceUniqueId; 
  private List<CachedCanonicalResource<T>> list = new ArrayList<>();
  private Map<String, List<CachedCanonicalResource<T>>> listForId;
  private Map<String, List<CachedCanonicalResource<T>>> listForUrl;
  private Map<String, CachedCanonicalResource<T>> map;
  private Map<String, List<CachedCanonicalResource<T>>> supplements; // general index based on CodeSystem.supplements
  private String version; // for debugging purposes
  
  
  public CanonicalResourceManager(boolean enforceUniqueId, boolean minimalMemory) {
    super();
    this.enforceUniqueId = enforceUniqueId;
    this.minimalMemory = minimalMemory;
    list = new ArrayList<>();
    listForId = new HashMap<>();
    listForUrl = new HashMap<>();
    map = new HashMap<>();
    supplements = new HashMap<>(); // general index based on CodeSystem.supplements
  }

  
  public String getVersion() {
    return version;
  }


  public void setVersion(String version) {
    this.version = version;
  }


  public void copy(CanonicalResourceManager<T> source) {
    list.clear();
    map.clear();
    list.addAll(source.list);
    map.putAll(source.map);
  }
  
  public void register(CanonicalResourceProxy r, PackageInformation packgeInfo) {
    if (!r.hasId()) {
      throw new FHIRException("An id is required for a deferred load resource");
    }
    CanonicalResourceManager<T>.CachedCanonicalResource<T> cr = new CachedCanonicalResource<T>(r, packgeInfo);
    see(cr);
  }

  public void see(T r, PackageInformation packgeInfo) {
    if (r != null) {
      if (!r.hasId()) {
        r.setId(UUID.randomUUID().toString());
      }
      CanonicalResourceManager<T>.CachedCanonicalResource<T> cr = new CachedCanonicalResource<T>(r, packgeInfo);
      see(cr);
    }
  }

  public void see(CachedCanonicalResource<T> cr) {
    // -- 1. exit conditions -----------------------------------------------------------------------------

    // ignore UTG NUCC erroneous code system
    if (cr.getPackageInfo() != null
      && cr.getPackageInfo().getId() != null
      && cr.getPackageInfo().getId().startsWith("hl7.terminology")
      && Arrays.stream(INVALID_TERMINOLOGY_URLS).anyMatch((it)->it.equals(cr.getUrl()))) {
      return;
    }  
    if (map.get(cr.getUrl()) != null && (cr.getPackageInfo() != null && cr.getPackageInfo().isExamplesPackage())) {
      return;
    }
    
    // -- 2. preparation -----------------------------------------------------------------------------
    if (cr.resource != null && cr.getPackageInfo() != null) {
      cr.resource.setSourcePackage(cr.getPackageInfo());
    }      

    // -- 3. deleting existing content ---------------------------------------------------------------
    if (enforceUniqueId && map.containsKey(cr.getId())) {
      drop(cr.getId());      
    }
    
    // special case logic for UTG support prior to version 5
    if (cr.getPackageInfo() != null && cr.getPackageInfo().getId().startsWith("hl7.terminology")) {
      List<CachedCanonicalResource<T>> toDrop = new ArrayList<>();
      for (CachedCanonicalResource<T> n : list) {
        if (n.getUrl() != null && n.getUrl().equals(cr.getUrl()) && isBasePackage(n.getPackageInfo())) {
          toDrop.add(n);
        }
      }
      for (CachedCanonicalResource<T> n : toDrop) {
        drop(n);
      }
    }
//    CachedCanonicalResource<T> existing = cr.hasVersion() ? map.get(cr.getUrl()+"|"+cr.getVersion()) : map.get(cr.getUrl()+"|#0");
//    if (existing != null) {
//      drop(existing); // was list.remove(existing)
//    }
    
    // -- 4. ok we add it to the list ---------------------------------------------------------------
    if (!enforceUniqueId) {
      if (!listForId.containsKey(cr.getId())) {
        listForId.put(cr.getId(), new ArrayList<>());
      }    
      List<CachedCanonicalResource<T>> set = listForId.get(cr.getId());
      set.add(cr);      
    }
    list.add(cr);
    if (!listForUrl.containsKey(cr.getUrl())) {
      listForUrl.put(cr.getUrl(), new ArrayList<>());
    }    
    addToSupplements(cr);
    List<CachedCanonicalResource<T>> set = listForUrl.get(cr.getUrl());
    set.add(cr);
    Collections.sort(set, new MetadataResourceVersionComparator<CachedCanonicalResource<T>>());

    // -- 4. add to the map all the ways ---------------------------------------------------------------
    String pv = cr.getPackageInfo() != null ? cr.getPackageInfo().getVID() : null;
    map.put(cr.getId(), cr); // we do this so we can drop by id - if not enforcing id, it's just the most recent resource with this id      
    map.put(cr.hasVersion() ? cr.getUrl()+"|"+cr.getVersion() : cr.getUrl()+"|#0", cr);
    if (pv != null) {
      map.put(pv+":"+(cr.hasVersion() ? cr.getUrl()+"|"+cr.getVersion() : cr.getUrl()+"|#0"), cr);      
    }
    int ndx = set.indexOf(cr);
    if (ndx == set.size()-1) {
      map.put(cr.getUrl(), cr);
      if (pv != null) {
        map.put(pv+":"+cr.getUrl(), cr);
      }
    }
    String mm = VersionUtilities.getMajMin(cr.getVersion());
    if (mm != null) {
      if (pv != null) {
        map.put(pv+":"+cr.getUrl()+"|"+mm, cr);                
      }
      if (set.size() - 1 == ndx) {
        map.put(cr.getUrl()+"|"+mm, cr);        
      } else {
        for (int i = set.size() - 1; i > ndx; i--) {
          if (mm.equals(VersionUtilities.getMajMin(set.get(i).getVersion()))) {
            return;
          }
          map.put(cr.getUrl()+"|"+mm, cr);
        }
      }
    }
  }

  private void addToSupplements(CanonicalResourceManager<T>.CachedCanonicalResource<T> cr) {
    String surl = cr.supplements();
    if (surl != null) {
      List<CanonicalResourceManager<T>.CachedCanonicalResource<T>> list = supplements.get(surl);
      if (list == null) {
        list = new ArrayList<>();
        supplements.put(surl, list);
      }
      list.add(cr);
    }    
  }


  public void drop(CachedCanonicalResource<T> cr) {
    while (map.values().remove(cr)); 
    while (listForId.values().remove(cr)); 
    while (listForUrl.values().remove(cr)); 
    String surl = cr.supplements();
    if (surl != null) {
      supplements.get(surl).remove(cr);
    }
    list.remove(cr);
    List<CachedCanonicalResource<T>> set = listForUrl.get(cr.getUrl());
    if (set != null) { // it really should be
      boolean last = set.indexOf(cr) == set.size()-1;
      set.remove(cr);
      if (!set.isEmpty()) {
        CachedCanonicalResource<T> crl = set.get(set.size()-1);
        if (last) {
          map.put(crl.getUrl(), crl);
        }
        String mm = VersionUtilities.getMajMin(cr.getVersion());
        if (mm != null) {
          for (int i = set.size()-1; i >= 0; i--) {
            if (mm.equals(VersionUtilities.getMajMin(set.get(i).getVersion()))) {
              map.put(cr.getUrl()+"|"+mm, set.get(i));
              break;
            }
          }
        }
      }
    }
  }
  
  public void drop(String id) {
    if (enforceUniqueId) {
      CachedCanonicalResource<T> cr = map.get(id);
      if (cr != null) {
        drop(cr);
      }
    } else {
      List<CachedCanonicalResource<T>> set = listForId.get(id);
      if (set != null) { // it really should be
        for (CachedCanonicalResource<T> i : set) {
          drop(i);
        }
      }
    }
  }  

  private boolean isBasePackage(PackageInformation packageInfo) {
    return packageInfo == null ? false : VersionUtilities.isCorePackage(packageInfo.getId());
  }

  private void updateList(String url, String version) {
    List<CachedCanonicalResource<T>> rl = new ArrayList<>();
    for (CachedCanonicalResource<T> t : list) {
      if (url.equals(t.getUrl()) && !rl.contains(t)) {
        rl.add(t);
      }
    }
    if (rl.size() > 0) {
      // sort by version as much as we are able
      // the current is the latest
      map.put(url, rl.get(rl.size()-1));
      // now, also, the latest for major/minor
      if (version != null) {
        CachedCanonicalResource<T> latest = null;
        for (CachedCanonicalResource<T> t : rl) {
          if (VersionUtilities.versionsCompatible(t.getVersion(), version)) {
            latest = t;
          }
        }
        if (latest != null) { // might be null if it's not using semver
          String lv = VersionUtilities.getMajMin(latest.getVersion());
          if (lv != null && !lv.equals(version))
            map.put(url+"|"+lv, rl.get(rl.size()-1));
        }
      }
    }
  }
 

  public boolean has(String url) {
    return map.containsKey(url);
  }

  public boolean has(String system, String version) {
    if (map.containsKey(system+"|"+version))
      return true;
    String mm = VersionUtilities.getMajMin(version);
    if (mm != null)
      return map.containsKey(system+"|"+mm);
    else
      return false;
  }
  
  public T get(String url) {
    return map.containsKey(url) ? map.get(url).getResource() : null;
  }
  
  public T get(String system, String version) {
    if (version == null) {
      return get(system);
    } else {
      if (map.containsKey(system+"|"+version))
        return map.get(system+"|"+version).getResource();
      String mm = VersionUtilities.getMajMin(version);
      if (mm != null && map.containsKey(system+"|"+mm))
        return map.get(system+"|"+mm).getResource();
      else
        return null;
    }
  }
  
  
  /**
   * This is asking for a packaged version aware resolution
   * 
   * if we can resolve the reference in the package dependencies, we will. if we can't
   * then we fall back to the non-package approach
   * 
   *  The context has to prepare the pvlist based on the original package
   * @param url
   * @param srcInfo
   * @return
   */
  public T get(String url, List<String> pvlist) {
    for (String pv : pvlist) {
      if (map.containsKey(pv+":"+url)) {
        return map.get(pv+":"+url).getResource();
      }      
    }
    return map.containsKey(url) ? map.get(url).getResource() : null;
  }
  
  public T get(String system, String version, List<String> pvlist) {
    if (version == null) {
      return get(system, pvlist);
    } else {
      for (String pv : pvlist) {
        if (map.containsKey(pv+":"+system+"|"+version))
          return map.get(pv+":"+system+"|"+version).getResource();
      }
      String mm = VersionUtilities.getMajMin(version);
      if (mm != null && map.containsKey(system+"|"+mm))
        for (String pv : pvlist) {
          if (map.containsKey(pv+":"+system+"|"+mm))
            return map.get(pv+":"+system+"|"+mm).getResource();
      }

      if (map.containsKey(system+"|"+version))
        return map.get(system+"|"+version).getResource();
      if (mm != null && map.containsKey(system+"|"+mm))
        return map.get(system+"|"+mm).getResource();
      else
        return null;
    }
  }
  
  
 
  public PackageInformation getPackageInfo(String system, String version) {
    if (version == null) {
      return map.containsKey(system) ? map.get(system).getPackageInfo() : null;
    } else {
      if (map.containsKey(system+"|"+version))
        return map.get(system+"|"+version).getPackageInfo();
      String mm = VersionUtilities.getMajMin(version);
      if (mm != null && map.containsKey(system+"|"+mm))
        return map.get(system+"|"+mm).getPackageInfo();
      else
        return null;
    }
  }
  
 
  
  
  public int size() {
    return list.size();
  }
  

  
  public void listAll(List<T> result) {
    for (CachedCanonicalResource<T>  t : list) {
      result.add(t.getResource()); 
    }
  }

  public void listAllM(List<CanonicalResource> result) {
    for (CachedCanonicalResource<T>  t : list) {
      result.add(t.getResource()); 
    }
  }

  public List<T> getSupplements(T cr) {
    if (cr.hasSourcePackage()) {
      List<String> pvl = new ArrayList<>();
      pvl.add(cr.getSourcePackage().getVID());
      return getSupplements(cr.getUrl(), cr.getVersion(), pvl);    
    } else {
      return getSupplements(cr.getUrl(), cr.getVersion(), null);
    }
  }
  
  public List<T> getSupplements(String url) {
    return getSupplements(url, null, null);    
  }
  
  public List<T> getSupplements(String url, String version) {
    return getSupplements(url, version, null);    
  }
  
  public List<T> getSupplements(String url, String version, List<String> pvlist) {
    boolean possibleMatches = false;
    List<T> res = new ArrayList<>();
    if (version != null) {
      List<CanonicalResourceManager<T>.CachedCanonicalResource<T>> list = supplements.get(url+"|"+version);
      if (list != null) {
        for (CanonicalResourceManager<T>.CachedCanonicalResource<T> t : list) {
          possibleMatches = true;
          if (pvlist == null || pvlist.contains(t.getPackageInfo().getVID())) {
            res.add(t.getResource());
          }
        }
      }      
    }
    List<CanonicalResourceManager<T>.CachedCanonicalResource<T>> list = supplements.get(url);
    if (list != null) {
      for (CanonicalResourceManager<T>.CachedCanonicalResource<T> t : list) {
        possibleMatches = true;
        if (pvlist == null || t.getPackageInfo() == null || pvlist.contains(t.getPackageInfo().getVID())) {
          res.add(t.getResource());
        }
      }
    }
    if (res.isEmpty() && pvlist != null && possibleMatches) {
      return getSupplements(url, version, null);
    } else {
      return res;
    }
  }
  
  public void clear() {
    list.clear();
    map.clear();
    
  }

  public List<CachedCanonicalResource<T>> getCachedList() {
    return list;
  }

  public List<T> getList() {
    List<T> res = new ArrayList<>();
    for (CachedCanonicalResource<T> t : list) {
      if (!res.contains(t.getResource())) {
        res.add(t.getResource());
      }
    }
    return res;
  }

  public List<T> getSortedList() {
    List<T> res = getList();
    Collections.sort(res, new CanonicalListSorter());
    return res;
  }

  public Set<String> keys() {
    return map.keySet();
  }

  public boolean isEnforceUniqueId() {
    return enforceUniqueId;
  }


}