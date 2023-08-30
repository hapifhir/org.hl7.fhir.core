package org.hl7.fhir.r4.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.MetadataResource;
import org.hl7.fhir.utilities.VersionUtilities;

/**
 * This manages a cached list of resources, and provides high speed access by URL / URL+version, and assumes that patch version doesn't matter for access
 * note, though, that not all resources have semver versions
 * 
 * @author graha
 *
 */

public class CanonicalResourceManager<T extends MetadataResource> {

  public class MetadataResourceVersionComparator<T extends MetadataResource> implements Comparator<T> {
    @Override
    public int compare(T arg1, T arg2) {
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
  private List<T> list = new ArrayList<>();
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
  
  public void see(T r) {
    if (!r.hasId()) {
      r.setId(UUID.randomUUID().toString());
    }
    if (enforceUniqueId && map.containsKey(r.getId())) {
      drop(r.getId());      
    }
    list.add(r);
    map.put(r.getId(), r); // we do this so we can drop by id

    if (r.hasUrl()) {
      // first, this is the correct reosurce for this version (if it has a version)
      if (r.hasVersion()) {
        map.put(r.getUrl()+"|"+r.getVersion(), r);
      }
      updateList(r.getUrl(), r.getVersion());
    }
  }

  private void updateList(String url, String version) {
    List<T> rl = new ArrayList<T>();
    for (T t : list) {
      if (url.equals(t.getUrl()) && !rl.contains(t)) {
        rl.add(t);
      }
    }
    if (rl.size() > 0) {
      // sort by version as much as we are able
      Collections.sort(rl, new MetadataResourceVersionComparator<T>());
      // the current is the latest
      map.put(url, rl.get(rl.size()-1));
      // now, also, the latest for major/minor
      if (version != null) {
        T latest = null;
        for (T t : rl) {
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
    return map.get(url);
  }
  
  public boolean has(String url) {
    return map.containsKey(url);
  }
  
  public T get(String system, String version) {
    if (map.containsKey(system+"|"+version))
      return map.get(system+"|"+version);
    String mm = VersionUtilities.getMajMin(version);
    if (mm != null)
      return map.get(system+"|"+mm);
    else
      return null;
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
    T res = null;
    do {
      res = null;
      for (T t : list) {
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
    result.addAll(list);    
  }

  public void listAllM(List<MetadataResource> result) {
    result.addAll(list);    
  }

  public void clear() {
    list.clear();
    map.clear();
    
  }

  public List<T> getList() {
    List<T> res = new ArrayList<>();
    for (T t : list) {
      if (!res.contains(t)) {
        res.add(t);
      }
    }
    return res;
  }

  public Set<String> keys() {
    return map.keySet();
  }

  public boolean isEnforceUniqueId() {
    return enforceUniqueId;
  }
  
}