package org.hl7.fhir.model;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

/**
 * The list used for all repeating elements in the model. Anything added is stamped with the 
 * owning object's model context - adoption, no-op, or FHIRException, as decided by 
 * Base.setModelContext. Extends AbstractList rather than ArrayList so that every mutation path 
 * (add, addAll, iterators, listIterator().add/set, subList views) funnels through add(int, E) 
 * and set(int, E) - there is no way to insert an element without the stamp being applied. 
 * 
 * The list holds its OWNER rather than a context: the owner's context is often assigned after 
 * the list is created (objects are born context-free and adopted), so it is read at add-time, 
 * when it is always current.
 */
public class BaseList<E extends Base> extends AbstractList<E> implements Serializable {

  private static final long serialVersionUID = 1L;

  private final Base owner;
  private final List<E> list = new ArrayList<E>();

  public BaseList(Base owner) {
    this.owner = owner;
  }

  /** create the list and add (and stamp) all the source elements */
  public BaseList(Base owner, Collection<? extends E> source) {
    this.owner = owner;
    if (source != null) {
      addAll(source);
    }
  }

  /**
   * Fill this list with copies of the source list's elements (made with the given options) and 
   * return this - the standard pattern in the generated copyValues methods. Each copy is 
   * stamped with the owner's model context as it is added.
   */
  @SuppressWarnings("unchecked")
  public BaseList<E> copyFrom(List<E> source, EnumSet<Base.CopyObjectOptions> options) {
    for (E e : source) {
      add((E) e.copy(options));
    }
    return this;
  }

  @Override
  public E get(int index) {
    return list.get(index);
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public E set(int index, E element) {
    if (element != null) {
      element.setModelContext(owner.modelContext);
    }
    return list.set(index, element);
  }

  @Override
  public void add(int index, E element) {
    if (element != null) {
      element.setModelContext(owner.modelContext);
    }
    modCount++;
    list.add(index, element);
  }

  @Override
  public E remove(int index) {
    modCount++;
    return list.remove(index);
  }
}
