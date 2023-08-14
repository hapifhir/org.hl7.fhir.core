package org.hl7.fhir.r5.comparison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.comparison.CanonicalResourceComparer.CanonicalResourceComparison;
import org.hl7.fhir.r5.comparison.CanonicalResourceComparer.ChangeAnalysisState;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class VersionComparisonAnnotation {

  public enum AnotationType {
    NoChange, Added, Changed, Deleted;
  }

  public static final String USER_DATA_NAME = "version-annotation";
  
  private AnotationType type;

  private Map<String, List<Base>> deletedChildren;

  private String version;

  private CanonicalResourceComparison<? extends CanonicalResource> comp;
    
  private VersionComparisonAnnotation(AnotationType type, String version) {
    super();
    this.type = type;
    this.version = version;
  }
  

  public static void annotate(Base base, String version, CanonicalResourceComparison<? extends CanonicalResource> comp) {
    if (version != null) {
      VersionComparisonAnnotation vca = new VersionComparisonAnnotation(comp.noChange() ? AnotationType.NoChange : AnotationType.Added, version);
      vca.comp = comp;
      base.setUserData(USER_DATA_NAME, vca);
    }
  }
  

  public static void markAdded(Base focus, String version) {
    if (version != null) {
      focus.setUserData(USER_DATA_NAME, new VersionComparisonAnnotation(AnotationType.Added, version));
    }
  }

  public static void markChanged(Base focus, String version) {
    if (version != null) {
      focus.setUserData(USER_DATA_NAME, new VersionComparisonAnnotation(AnotationType.Changed, version));
    }
  }

  public static void markDeleted(Base parent, String version, String name, Base other) {
    if (version != null) {
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
  }

  public AnotationType getType() {
    return type;
  }
  public void setType(AnotationType type) {
    this.type = type;
  }
  
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
      XhtmlNode spanOuter = x.span("border: solid 1px #dddddd; margin: 2px; padding: 2px", null);
      XhtmlNode spanInner = spanOuter.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
      spanInner.img("icon-change-add.png", "icon");
      spanInner.tx(" Added:");
      return spanOuter;
    case Changed:
      spanOuter = x.span("border: solid 1px #dddddd; margin: 2px; padding: 2px", null);
      spanInner = spanOuter.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
      spanInner.img("icon-change-edit.png", "icon");
      spanInner.tx(" Changed:");
      return spanOuter;
    case Deleted:
      spanOuter = x.span("border: solid 1px #dddddd; margin: 2px; padding: 2px", null);
      spanInner = spanOuter.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
      spanInner.img("icon-change-remove.png", "icon");
      spanInner.tx(" Removed:");
      return spanOuter.strikethrough();
    default:
      return x;
    }
  }

  public static XhtmlNode renderDiv(Base b, XhtmlNode x) {
    if (b.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) b.getUserData(USER_DATA_NAME);
      return self.renderDiv(x);
    } else {
      return x;
    }
  }
  
  private XhtmlNode renderDiv(XhtmlNode x) {
    switch (type) {
    case Added:
      XhtmlNode divOuter = x.div("border: solid 1px #dddddd; margin: 2px; padding: 2px");
      XhtmlNode spanInner = divOuter.para().style("margin: 0").span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
      spanInner.img("icon-change-add.png", "icon");
      spanInner.tx(" Added:");
      return divOuter;
    case Changed:
      divOuter = x.div("border: solid 1px #dddddd; margin: 2px; padding: 2px");
      spanInner = divOuter.para().style("margin: 0").span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
      spanInner.img("icon-change-edit.png", "icon");
      spanInner.tx(" Changed:");
      return divOuter;
    case Deleted:
      divOuter = x.div("border: solid 1px #dddddd; margin: 2px; padding: 2px");
      spanInner = divOuter.para().style("margin: 0").span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
      spanInner.img("icon-change-remove.png", "icon");
      spanInner.tx(" Removed:");
      return divOuter.strikethrough();
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

  public static CanonicalResourceComparison<? extends CanonicalResource> artifactComparison(Base base) {
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      return self.comp;
    } else {
      return null;
    }
  }
  
}