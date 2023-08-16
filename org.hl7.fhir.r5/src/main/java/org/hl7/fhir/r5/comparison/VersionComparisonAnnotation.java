package org.hl7.fhir.r5.comparison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.comparison.CanonicalResourceComparer.CanonicalResourceComparison;
import org.hl7.fhir.r5.comparison.CanonicalResourceComparer.ChangeAnalysisState;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class VersionComparisonAnnotation {

  public enum AnotationType {
    NoChange, Added, Changed, ChildrenDeleted, Deleted;
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
      VersionComparisonAnnotation vca = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      if (vca == null) {
        vca = new VersionComparisonAnnotation(comp.noUpdates() ? AnotationType.NoChange : AnotationType.Changed, version);
        base.setUserData(USER_DATA_NAME, vca);
      }
      vca.comp = comp;
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
    if (version != null && other != null) {
      VersionComparisonAnnotation vca = null;
      if (parent.hasUserData(USER_DATA_NAME)) {
        vca = (VersionComparisonAnnotation) parent.getUserData(USER_DATA_NAME);
        assert vca.type != AnotationType.Added;
      } else {
        vca = new VersionComparisonAnnotation(AnotationType.ChildrenDeleted, version);
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
      spanInner = spanOuter.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been changed since  "+version);
      spanInner.img("icon-change-edit.png", "icon");
      spanInner.tx(" Changed:");
      return spanOuter;
    case Deleted:
      spanOuter = x.span("border: solid 1px #dddddd; margin: 2px; padding: 2px", null);
      spanInner = spanOuter.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been removed since  "+version);
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
      spanInner = divOuter.para().style("margin: 0").span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been changed since  "+version);
      spanInner.img("icon-change-edit.png", "icon");
      spanInner.tx(" Changed:");
      return divOuter;
    case Deleted:
      divOuter = x.div("border: solid 1px #dddddd; margin: 2px; padding: 2px");
      spanInner = divOuter.para().style("margin: 0").span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been removed since  "+version);
      spanInner.img("icon-change-remove.png", "icon");
      spanInner.tx(" Removed:");
      return divOuter.strikethrough();
    default:
      return x;
    }
  }
  

  public static XhtmlNode renderRow(Base b, XhtmlNode tbl, XhtmlNode tr) {
    if (b.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) b.getUserData(USER_DATA_NAME);
      return self.renderRow(tbl, tr);
    } else {
      return tr.td();
    }
  }
  
  private XhtmlNode renderRow(XhtmlNode tbl, XhtmlNode tr) {
    switch (type) {
    case Added:
      if (tbl.isClass("grid")) {
        tr.style("border: solid 1px #dddddd; margin: 2px; padding: 2px");
      }
      XhtmlNode td = tr.td();
      XhtmlNode span = td.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This row of content has been added since  "+version);
      span.img("icon-change-add.png", "icon");
      span.tx(" Added:");
      XhtmlNode x = new XhtmlNode(NodeType.Element, "holder");
      x.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This row of content has been added since  "+version).tx(" ");
      tr.styleCells(x);
      return td;
    case Changed:
      td = tr.td();
      span = td.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This row of content has been changed since  "+version);
      span.img("icon-change-edit.png", "icon");
      span.tx(" Changed:");
      return td;
    case Deleted:
      tr.style("text-decoration: line-through");
      td = tr.td();
      span = td.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been removed since  "+version);
      span.img("icon-change-remove.png", "icon");
      span.tx(" Removed:");
      x = new XhtmlNode(NodeType.Element, "holder");
      x.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px; text-decoration: none", "This row of content has been added since  "+version).tx(" ");
      tr.styleCells(x);
      return td;
    default:
      return tr.td();
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

  public static Base getDeletedItem(Base base, String name) {
    List<Base> result = new ArrayList<>();
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      if (self.deletedChildren != null && self.deletedChildren.containsKey(name))  {
        result.addAll(self.deletedChildren.get(name));
      }
    }
    return result.isEmpty() ? null : result.get(0);
  }
  
  
  public static CanonicalResourceComparison<? extends CanonicalResource> artifactComparison(Base base) {
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      return self.comp;
    } else {
      return null;
    }
  }

  public static void renderSummary(Base base, XhtmlNode x, String version, String... metadataFields) {
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      switch (self.type) {
      case Added:
        XhtmlNode spanInner = x.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
        spanInner.img("icon-change-add.png", "icon");
        spanInner.tx(" Added");
        return;
      case Changed:
        if (self.comp.noChangeOtherThanMetadata(metadataFields)) {
          x.span("color: #eeeeee").tx("n/c");
          return;
        } else {
          spanInner = x.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
          spanInner.img("icon-change-edit.png", "icon");
          spanInner.tx(" Changed");
        }
        return;
      case Deleted:
        spanInner = x.span("background-color: #fff2ff; border-left: solid 3px #ffa0ff; margin: 2px; padding: 2px", "This content has been added since  "+version);
        spanInner.img("icon-change-remove.png", "icon");
        spanInner.tx(" Removed");
        return;
      default:
        x.span("color: #eeeeee").tx("n/c");
        return;
      }
    } else {
      x.span("color: #eeeeee").tx("--");
    }
  }


  
}