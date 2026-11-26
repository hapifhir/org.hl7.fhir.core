package org.hl7.fhir.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class NamedItemList<T extends org.hl7.fhir.utilities.NamedItemList.NamedItem> implements Collection<T> {
  public interface NamedItem {
    public String getListName();
  }


  private static final int SIZE_CUTOFF_MAP = 10;


  private List<T> list = new ArrayList<>();
  // the by-name index, built lazily. Reading the list (getByName) from several threads at once is
  // safe: the index is built into a local map and only published once it's complete, through a
  // volatile field (two threads may both build it; that's harmless). Changing the list is not
  // thread safe, and must not happen while other threads are reading
  private volatile Map<String, List<T>> map = null;

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return list.contains(o);
  }

  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }

  @Override
  public Object[] toArray() {
    return list.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return list.toArray(a);
  }

  @Override
  public boolean add(T e) {
    addToMap(e);
    return list.add(e);
  }
  public void add(int index, T e) {
    addToMap(e);
    list.add(index, e);
  }

  @Override
  public boolean remove(Object o) {
    map = null;  
    return list.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return list.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    for(T e : c) {
      addToMap(e);
    }
    return list.addAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    map = null;  
    return list.removeAll(c);  
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    map = null;  
    return list.retainAll(c);
  }

  @Override
  public void clear() {
    list.clear();
    map = null;    
  }

  public List<T> getByName(String name) {
    List<T> res = new ArrayList<>();
    if (size() > SIZE_CUTOFF_MAP) {
      Map<String, List<T>> m = map;
      if (m == null) {
        m = buildMap();
      }
      List<T> l = m.get(name);
      if (l != null) {
        res.addAll(l);
      }
    } else {
      for (T child : list) {
        if (name.equals(child.getListName())) {
          res.add(child);
        }
      }
    }
    return res;
  }
  
  public int getSizeByName(String name) {
    Map<String, List<T>> m = map;
    if (m == null) {
      m = buildMap();
    }
    List<T> l = m.get(name);
    return l == null ? 0 : l.size();
  }

  public T get(int c) {
    return list.get(c);
  }

  private Map<String, List<T>> buildMap() {
    Map<String, List<T>> m = new HashMap<>();
    for (T child : list) {
      addToMap(m, child);
    }
    map = m;
    return m;
  }
  
  private void addToMap(T child) {
    Map<String, List<T>> m = map;
    if (m == null) {
      // map will be re-built anyway in next call to getByName
      return;
    }
    addToMap(m, child);
  }

  private void addToMap(Map<String, List<T>> m, T child) {
    String n = child.getListName();
    List<T> l = m.get(n);
    if (l == null) {
      l = new ArrayList<>();
      m.put(n,l);
    }
    l.add(child);
  }

  public void sort(Comparator<? super T> sorter) {
    Collections.sort(list, sorter);
  }

  public void clearMap() {
    map = null;
  }

  public int indexOf(T child) {
    return list.indexOf(child);
  }
}
