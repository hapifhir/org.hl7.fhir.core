package org.hl7.fhir.r5.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.hl7.fhir.r5.context.BaseWorkerContext.MetadataResourceVersionComparator;
import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalListSorter;
import org.hl7.fhir.r5.context.IWorkerContext.PackageVersion;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.utilities.VersionUtilities;

/**
 * This manages a cached list of resources, and provides high speed access by URL / URL+version, and assumes that patch version doesn't matter for access
 * note, though, that not all resources have semver versions
 * 
 * @author graha
 *
 */

public class CanonicalResourceManager<T extends CanonicalResource> {

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
    private PackageVersion packageInfo;
    public CachedCanonicalResource(T1 resource, PackageVersion packageInfo) {
      super();
      this.resource = resource;
      this.packageInfo = packageInfo;
    }
    public T1 getResource() {
      return resource;
    }
    public PackageVersion getPackageInfo() {
      return packageInfo;
    }
    public String getUrl() {
      return resource.getUrl();
    }
    public String getId() {
      return resource.getId();
    }
    public String getVersion() {
      return resource.getVersion();
    }
    public boolean hasVersion() {
      return resource.hasVersion();
    }
  }

  public class MetadataResourceVersionComparator<T1 extends CachedCanonicalResource<T>> implements Comparator<T1> {
    @Override
    public int compare(T1 arg1, T1 arg2) {
      String v1 = arg1.getResource().getVersion();
      String v2 = arg2.getResource().getVersion();
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
  private Map<String, T> map = new HashMap<>();
  
  
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
  
  public void see(T r, PackageVersion packgeInfo) {
    if (!r.hasId()) {
      r.setId(UUID.randomUUID().toString());
    }
    if (enforceUniqueId && map.containsKey(r.getId())) {
      drop(r.getId());      
    }
    // special case logic for UTG support prior to version 5
    if (packgeInfo != null && packgeInfo.getId().startsWith("hl7.terminology")) {
      List<CachedCanonicalResource<T>> toDrop = new ArrayList<>();
      for (CachedCanonicalResource<T> n : list) {
        if (n.getResource().getUrl().equals(r.getUrl()) && isBasePackage(n.getPackageInfo())) {
          toDrop.add(n);
        }
      }
      for (CachedCanonicalResource<T> n : toDrop) {
        drop(n.getId());
      }
    }
    list.add(new CachedCanonicalResource<T>(r, packgeInfo));
    map.put(r.getId(), r); // we do this so we can drop by id

    if (r.hasUrl()) {
      // first, this is the correct reosurce for this version (if it has a version)
      if (r.hasVersion()) {
        map.put(r.getUrl()+"|"+r.getVersion(), r);
      }
      updateList(r.getUrl(), r.getVersion());
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
      map.put(url, rl.get(rl.size()-1).getResource());
      // now, also, the latest for major/minor
      if (version != null) {
        T latest = null;
        for (CachedCanonicalResource<T> t : rl) {
          if (VersionUtilities.versionsCompatible(t.getResource().getVersion(), version)) {
            latest = t.getResource();
          }
        }
        if (latest != null) { // might be null if it's not using semver
          String lv = VersionUtilities.getMajMin(latest.getVersion());
          if (lv != null && !lv.equals(version))
            map.put(url+"|"+lv, rl.get(rl.size()-1).getResource());
        }
      }
    }
  }
 

  public T get(String url) {
    return map.get(url);
  }
  
  public boolean has(String url) {
    return map.containsKey(url);
  }
  
  public T get(String system, String version) {
    if (version == null) {
      return get(system);
    } else {
      if (map.containsKey(system+"|"+version))
        return map.get(system+"|"+version);
      String mm = VersionUtilities.getMajMin(version);
      if (mm != null)
        return map.get(system+"|"+mm);
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