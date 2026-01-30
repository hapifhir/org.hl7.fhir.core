package org.hl7.fhir.validation.instance.utils;

import lombok.Getter;

import java.util.*;

public class BoundedSizeList<T> implements List<T> {

  public static class BoundsExceededException extends RuntimeException {
    @Getter
    final int maxSize;
    public BoundsExceededException(String message, int maxSize) {
      super(message);
      this.maxSize = maxSize;
    }
  }

  final int maxSize;

  final List<T> list;

  public BoundedSizeList(List<T> list, int maxSize) {
    this.maxSize = maxSize;
    if (list.size() > maxSize) {
      this.list = new ArrayList<>();
      this.list.addAll(list.subList(0, maxSize));
      throw new BoundsExceededException("Attempt to instantiate a list of size " + list.size() + " when max size is " + maxSize, maxSize);
    }
    this.list = list;

  }

  private void checkIfCanAddWithinBounds() throws BoundsExceededException {
    if (list.size() + 1 > maxSize) {
      throw new BoundsExceededException("Attempt to add an entry to list of size " + list.size() + " when max size is " + maxSize, maxSize);
    }
  }

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
  public boolean add(T entry) {
    checkIfCanAddWithinBounds();
    return list.add(entry);
  }

  @Override
  public boolean remove(Object o) {
    return list.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return list.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    if (list.size() + c.size() > maxSize) {
      final int originalSize = list.size();
      final int truncatedAddSize = maxSize -  list.size();
      Iterator<? extends T> iterator = c.iterator();
      for (int i = 0; i < truncatedAddSize; i++) {
        list.add(iterator.next());
      }
      throw new BoundsExceededException("Attempt to add " + c.size() + " entries to a list of size " + originalSize + " when max size is " + maxSize, maxSize);
    }
    return list.addAll(c);
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    if (list.size() + c.size() > maxSize) {
      final int originalSize = list.size();
      final int truncatedAddSize = maxSize -  list.size();
      Iterator<? extends T> iterator = c.iterator();
      for (int i = 0; i < truncatedAddSize; i++) {
        list.add(index + i, iterator.next());
      }
      throw new BoundsExceededException("Attempt to add " + c.size() + " entries to a list of size " + originalSize + " when max size is " + maxSize, maxSize);
    }
    return list.addAll(index, c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return list.removeAll(c);
  }


  @Override
  public boolean retainAll(Collection<?> c) {
    return list.retainAll(c);
  }

  @Override
  public void clear() {
    list.clear();
  }

  @Override
  public T get(int index) {
    return list.get(index);
  }

  @Override
  public T set(int index, T element) {
    return list.set(index, element);
  }

  @Override
  public void add(int index, T element) {
    checkIfCanAddWithinBounds();
    list.add(index, element);
  }

  @Override
  public T remove(int index) {
    return list.remove(index);
  }

  @Override
  public int indexOf(Object o) {
    return list.indexOf(o);
  }

  @Override
  public int lastIndexOf(Object o) {
    return list.lastIndexOf(o);
  }

  @Override
  public ListIterator<T> listIterator() {
    return list.listIterator();
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    return list.listIterator(index);
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    return list.subList(fromIndex, toIndex);
  }
}
