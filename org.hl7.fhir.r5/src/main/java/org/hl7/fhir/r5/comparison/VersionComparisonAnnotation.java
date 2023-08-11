package org.hl7.fhir.r5.comparison;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class VersionComparisonAnnotation {

  public enum AnotationType {
    Added, Changed, Deleted;
  }

  public static final String USER_DATA_NAME = "version-annotation";
  
  private AnotationType type;
//  private String comment;
//  private String link;
  private Map<String, List<Base>> deletedChildren;

  private String version;
    
  private VersionComparisonAnnotation(AnotationType type, String version) {
    super();
    this.type = type;
    this.version = version;
  }
//  
//  private VersionComparisonAnnotation(AnotationType type, String comment) {
//    super();
//    this.type = type;
//    this.comment = comment;
//  }
//  private VersionComparisonAnnotation(AnotationType type, String comment, String link) {
//    super();
//    this.type = type;
//    this.comment = comment;
//    this.link = link;
//  }
//  
  public static void markAdded(Base focus, String version) {
    focus.setUserData(USER_DATA_NAME, new VersionComparisonAnnotation(AnotationType.Added, version));
  }

  public static void markDeleted(Base parent, String version, String name, Base other) {
    VersionComparisonAnnotation vca = null;
    if (parent.hasUserData(USER_DATA_NAME)) {
      vca = (VersionComparisonAnnotation) parent.getUserData(USER_DATA_NAME);
      assert vca.type != AnotationType.Added;
    } else {
      vca = new VersionComparisonAnnotation(AnotationType.Changed, version);
      parent.setUserData(USER_DATA_NAME, vca);
    }
    if (vca.deletedChildren == null) {
      vca.deletedChildren = new HashMap<>();
    }
    if (!vca.deletedChildren.containsKey(name)) {
      vca.deletedChildren.put(name, new ArrayList<>());
    }
    other.setUserData(USER_DATA_NAME, new VersionComparisonAnnotation(AnotationType.Deleted, version));
    vca.deletedChildren.get(name).add(other);
  }

  public AnotationType getType() {
    return type;
  }
  public void setType(AnotationType type) {
    this.type = type;
  }
  
//  public String getComment() {
//    return comment;
//  }
//  public void setComment(String comment) {
//    this.comment = comment;
//  }
//  public String getLink() {
//    return link;
//  }
//  public void setLink(String link) {
//    this.link = link;
//  }
  
  public static XhtmlNode render(Base b, XhtmlNode x) {
    if (b.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) b.getUserData(USER_DATA_NAME);
      return self.render(x);
    } else {
      return x;
    }
  }
  
  private XhtmlNode render(XhtmlNode x) {
    switch (type) {
    case Added:
      XhtmlNode span = x.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
      span.img("icon-change-add.png", "icon");
      span.tx(" Added:");
      return x;
    case Changed:
      span = x.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been changed since version "+version);
      span.img("icon-change-edit.png", "icon");
      span.tx(" Changed:");
      return x;
    case Deleted:
      span = x.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been removed since version "+version);
      span.img("icon-change-remove.png", "icon");
      span.tx(" Removed:");
      return x.strikethrough();
    default:
      return x;
    }
  }

  public static boolean hasDeleted(Base base, String... names) {
    boolean result = false;
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      for (String name : names) {
        if (self.deletedChildren != null && self.deletedChildren.containsKey(name))  {
          result = true;
        }
      }
    }
    return result;
  }

  public static List<Base> getDeleted(Base base, String... names) {
    List<Base> result = new ArrayList<>();
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      for (String name : names) {
        if (self.deletedChildren != null && self.deletedChildren.containsKey(name))  {
          result.addAll(self.deletedChildren.get(name));
        }
      }
    }
    return result;
  }
  
}