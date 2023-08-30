package org.hl7.fhir.r4b.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r4b.context.IWorkerContext.PackageVersion;
import org.hl7.fhir.r4b.model.CanonicalResource;
import org.hl7.fhir.r4b.model.CodeSystem;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.terminologies.CodeSystemUtilities;
import org.hl7.fhir.utilities.VersionUtilities;

/**
 * This manages a cached list of resources, and provides high speed access by URL / URL+version, and assumes that patch version doesn't matter for access
 * note, though, that not all resources have semver versions
 * 
 * @author graha
 *
 */

public class CanonicalResourceManager<T extends CanonicalResource> {

  public static abstract class CanonicalResourceProxy {
    private String type;
    private String id;
    private String url;
    private String version;
    private CanonicalResource resource;
    
    public CanonicalResourceProxy(String type, String id, String url, String version) {
      super();
      this.type = type;
      this.id = id;
      this.url = url;
      this.version = version;
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
    
    public CanonicalResource getResource() throws FHIRException {
      if (resource == null) {
        resource = loadResource();
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
  }

  public class CanonicalListSorter implements Comparator<CanonicalResource> {

    @Override
    public int compare(CanonicalResource arg0, CanonicalResource arg1) {
      String u0 = arg0.getUrl();
      String u1 = arg1.getUrl();
      return u0.compareTo(u1);
    }
  }

  private class CachedCanonicalResource<T1 extends CanonicalResource> {
    private T1 resource;
    private CanonicalResourceProxy proxy;
    private PackageVersion packageInfo;
    
    public CachedCanonicalResource(T1 resource, PackageVersion packageInfo) {
      super();
      this.resource = resource;
      this.packageInfo = packageInfo;
    }
    
    public CachedCanonicalResource(CanonicalResourceProxy proxy, PackageVersion packageInfo) {
      super();
      this.proxy = proxy;
      this.packageInfo = packageInfo;
    }
    
    public T1 getResource() {
      if (resource == null) {
        @SuppressWarnings("unchecked")
        T1 res = (T1) proxy.getResource();
        synchronized (this) {
          resource = res;
        }
        proxy = null;
      }
      return resource;
    }
    
    public PackageVersion getPackageInfo() {
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
      return resource != null ? resource.fhirType()+"/"+resource.getId()+": "+resource.getUrl()+"|"+resource.getVersion() : proxy.toString();
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

  private boolean enforceUniqueId; 
  private List<CachedCanonicalResource<T>> list = new ArrayList<>();
  private Map<String, CachedCanonicalResource<T>> map = new HashMap<>();
  
  
  public CanonicalResourceManager(boolean enforceUniqueId) {
    super();
    this.enforceUniqueId = enforceUniqueId;
  }

  public void copy(CanonicalResourceManager<T> source) {
    list.clear();
    map.clear();
    list.addAll(source.list);
    map.putAll(source.map);
  }
  
  public void register(CanonicalResourceProxy r, PackageVersion packgeInfo) {
    if (!r.hasId()) {
      throw new FHIRException("An id is required for a deferred load resource");
    }
    CanonicalResourceManager<T>.CachedCanonicalResource<T> cr = new CachedCanonicalResource<T>(r, packgeInfo);
    see(cr);
  }

  public void see(T r, PackageVersion packgeInfo) {
    if (r != null) {
      if (!r.hasId()) {
        r.setId(UUID.randomUUID().toString());
      }
      CanonicalResourceManager<T>.CachedCanonicalResource<T> cr = new CachedCanonicalResource<T>(r, packgeInfo);
      see(cr);
    }
  }

  public void see(CachedCanonicalResource<T> cr) {
    // ignore UTG NUCC erroneous code system
    if (cr.getPackageInfo() != null && cr.getPackageInfo().getId() != null && cr.getPackageInfo().getId().startsWith("hl7.terminology") && "http://nucc.org/provider-taxonomy".equals(cr.getUrl())) {
      return;
    }
        
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
        drop(n.getId());
      }
    }
    CachedCanonicalResource<T> existing = cr.hasVersion() ? map.get(cr.getUrl()+"|"+cr.getVersion()) : map.get(cr.getUrl()+"|#0");
    if (map.get(cr.getUrl()) != null && (cr.getPackageInfo() != null && cr.getPackageInfo().isExamplesPackage())) {
      return;
    }
    if (existing != null) {
      list.remove(existing);
    }
    
    list.add(cr);
    map.put(cr.getId(), cr); // we do this so we can drop by id
    map.put(cr.getUrl(), cr);

    if (cr.getUrl() != null) {
      // first, this is the correct reosurce for this version (if it has a version)
      if (cr.hasVersion()) {
        map.put(cr.getUrl()+"|"+cr.getVersion(), cr);
      } else {
        map.put(cr.getUrl()+"|#0", cr);
      }
      updateList(cr.getUrl(), cr.getVersion());
    }
  }

  private boolean isBasePackage(PackageVersion packageInfo) {
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
      Collections.sort(rl, new MetadataResourceVersionComparator<CachedCanonicalResource<T>>());
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
 

  public T get(String url) {
    return map.containsKey(url) ? map.get(url).getResource() : null;
  }
  
  public PackageVersion getPackageInfo(String system, String version) {
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
  
  public boolean has(String url) {
    return map.containsKey(url);
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
  
  public boolean has(String system, String version) {
    if (map.containsKey(system+"|"+version))
      return true;
    String mm = VersionUtilities.getMajMin(version);
    if (mm != null)
      return map.containsKey(system+"|"+mm);
    else
      return false;
  }
  
  public int size() {
    return list.size();
  }
  
  public void drop(String id) {
    CachedCanonicalResource<T> res = null;
    do {
      res = null;
      for (CachedCanonicalResource<T> t : list) {
        if (t.getId().equals(id)) {
          res = t;
        }
      }
      if (res != null) {
        list.remove(res);
        map.remove(id);
        map.remove(res.getUrl());
        if (res.hasVersion()) {
          map.remove(res.getUrl()+"|"+res.getVersion());
          String mm = VersionUtilities.getMajMin(res.getVersion());
          if (mm != null) {
            map.remove(res.getUrl()+"|"+mm);
          }
        }
        updateList(res.getUrl(), res.getVersion()); 
      }
    } while (res != null);
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

  public void clear() {
    list.clear();
    map.clear();
    
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