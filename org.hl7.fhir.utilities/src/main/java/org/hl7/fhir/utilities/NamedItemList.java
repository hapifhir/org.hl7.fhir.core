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
  private Map<String, List<T>> map = null;

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
    map = null;  
    return list.add(e);
  }
  public void add(int index, T e) {
    list.add(index, e);
    map = null;  
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
    map = null;  
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
      if (map == null) {
        buildMap();
      }
      List<T> l = map.get(name);
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

  public T get(int c) {
    return list.get(c);
  }

  private void buildMap() {
    map = new HashMap<>();
    for (T child : list) {
      String n = child.getListName();
      List<T> l = map.get(n);
      if (l == null) {
        l = new ArrayList<>();
        map.put(n,l);
      }
      l.add(child);         
    }
  }

  public void sort(Comparator<? super T> sorter) {
    Collections.sort(list, sorter);
  }

}
