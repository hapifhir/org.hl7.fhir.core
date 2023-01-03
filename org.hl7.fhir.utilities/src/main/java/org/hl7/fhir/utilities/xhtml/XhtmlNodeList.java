package org.hl7.fhir.utilities.xhtml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class XhtmlNodeList extends XhtmlFluent implements List<XhtmlNode>, java.io.Serializable {

  private static final long serialVersionUID = 1L;
  private List<XhtmlNode> list = new ArrayList<>();
  private boolean inPara;
  private boolean inLink;
  
  
  public boolean isInPara() {
    return inPara;
  }

  public void setInPara(boolean inPara) {
    this.inPara = inPara;
  }

  public boolean isInLink() {
    return inLink;
  }

  public void setInLink(boolean inLink) {
    this.inLink = inLink;
  }
  

  public XhtmlNode addTag(String name)
  {
    
//    if (inPara && name.equals("p")) {
//      throw new FHIRException("nested Para");
//    }
//    if (inLink && name.equals("a")) {
//      throw new FHIRException("Nested Link");
//    }
    XhtmlNode node = new XhtmlNode(NodeType.Element);
    node.setName(name);
    if (isInPara() || name.equals("p")) {
      node.getChildNodes().setInPara(true);
    }
    if (isInLink() || name.equals("a")) {
      node.getChildNodes().setInLink(true);
    }
    add(node);
    return node;
  }

  public XhtmlNode addText(String content) {
    if (content != null) {
      XhtmlNode node = new XhtmlNode(NodeType.Text);
      node.setContent(content);
      add(node);
      return node;
    } else {
      return null;
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
  public Iterator<XhtmlNode> iterator() {
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
  public boolean add(XhtmlNode e) {
    return list.add(e);
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
  public boolean addAll(Collection<? extends XhtmlNode> c) {
    return list.addAll(c);
  }

  @Override
  public boolean addAll(int index, Collection<? extends XhtmlNode> c) {
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
  public XhtmlNode get(int index) {
    return list.get(index);
  }

  @Override
  public XhtmlNode set(int index, XhtmlNode element) {
    return list.set(index, element);
  }

  @Override
  public void add(int index, XhtmlNode element) {
    list.add(index, element);    
  }

  @Override
  public XhtmlNode remove(int index) {
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
  public ListIterator<XhtmlNode> listIterator() {
    return list.listIterator();
  }

  @Override
  public ListIterator<XhtmlNode> listIterator(int index) {
    return list.listIterator(index);
  }

  @Override
  public List<XhtmlNode> subList(int fromIndex, int toIndex) {
    return list.subList(fromIndex, toIndex);
  }


  @Override
  protected void addChildren(XhtmlNodeList childNodes) {
    this.addAll(childNodes);    
  }
}