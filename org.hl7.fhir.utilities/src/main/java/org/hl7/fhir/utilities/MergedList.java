package org.hl7.fhir.utilities;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.MergedList.MergeNode;

/**
 * A list of items that represent 
 * @author graha
 *
 * @param <T>
 */
public class MergedList<T> extends ArrayList<MergeNode<T>> {

  private static final long serialVersionUID = 1L;
  
  public static interface IMatcher<T1> {
    public boolean match(T1 l, T1 r);
  }
  
  public static class MergeNode<T1> {
    private T1 left;
    private T1 right;
    public MergeNode(T1 left, T1 right) {
      super();
      this.left = left;
      this.right = right;
    }
    public T1 getLeft() {
      return left;
    }
    public T1 getRight() {
      return right;
    }

    public boolean hasLeft() {
      return left != null;
    }

    public boolean hasRight() {
      return right != null;
    }
    @Override
    public String toString() {
      return (hasLeft() ? left.toString() : "null") + " :: "+(hasRight() ? right.toString() : "null");
    }
  }

  public MergedList(List<T> left, List<T> right, IMatcher<T> matcher) {
    super();
    List<T> m = new ArrayList<>();
    for (T l : left) {
      T t = null;
      for (T r : right) {
        if (matcher.match(l, r)) {
          t = r;
          m.add(r);
          break;
        }
      }
      this.add(new MergeNode<T>(l, t));
    }
    for (T r : right) {
      if (!m.contains(r)) {
        this.add(new MergeNode<T>(null, r));
      }
    }
  }

  public MergedList(List<T> left, List<T> right) {
    super();
    for (int i = 0; i < Integer.max(left.size(), right.size()); i++) {
      T l = i < left.size() ? left.get(i) : null;
      T r = i < right.size() ? right.get(i) : null;
      this.add(new MergeNode<T>(l, r));
    }
  }

}
