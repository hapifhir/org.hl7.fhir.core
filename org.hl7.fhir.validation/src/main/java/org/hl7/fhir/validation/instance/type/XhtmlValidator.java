package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.UrlUtil;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

public class XhtmlValidator extends BaseValidator {

  private static final HashSet<String> HTML_ELEMENTS = new HashSet<>(Arrays.asList(
      "p", "br", "div", "h1", "h2", "h3", "h4", "h5", "h6", "a", "span", "b", "em", "i", "strong",
      "small", "big", "tt", "small", "dfn", "q", "var", "abbr", "acronym", "cite", "blockquote", "hr", "address", "bdo", "kbd", "q", "sub", "sup",
      "ul", "ol", "li", "dl", "dt", "dd", "pre", "table", "caption", "colgroup", "col", "thead", "tr", "tfoot", "tbody", "th", "td",
      "code", "samp", "img", "map", "area"));
  private static final HashSet<String> HTML_ATTRIBUTES = new HashSet<>(Arrays.asList(
      "title", "style", "class", "id", "lang", "xml:lang", "dir", "accesskey", "tabindex",
      // tables
      "span", "width", "align", "valign", "char", "charoff", "abbr", "axis", "headers", "scope", "rowspan", "colspan"));

  private static final HashSet<String> HTML_COMBO_LIST = new HashSet<>(Arrays.asList(
      "a.href", "a.name", "img.src", "img.border", "div.xmlns", "blockquote.cite", "q.cite",
      "a.charset", "a.type", "a.name", "a.href", "a.hreflang", "a.rel", "a.rev", "a.shape", "a.coords", "img.src",
      "img.alt", "img.longdesc", "img.height", "img.width", "img.usemap", "img.ismap", "map.name", "area.shape",
      "area.coords", "area.href", "area.nohref", "area.alt", "table.summary", "table.width", "table.border",
      "table.frame", "table.rules", "table.cellspacing", "table.cellpadding", "pre.space", "td.nowrap"));
  private static final HashSet<String> HTML_BLOCK_LIST = new HashSet<>(Arrays.asList("div",  "blockquote", "table", "ol", "ul", "p"));

  
  private List<ValidationMessage> errors;
  private NodeStack stack;
  
  public XhtmlValidator(BaseValidator parent, List<ValidationMessage> errors, NodeStack stack) {
    super(parent);
    this.errors = errors;
    this.stack = stack;
  }


  public boolean validate(ValidationContext valContext, Element e, Element resource, String path, XhtmlNode xhtml) {
    boolean ok = true;
 // check that the namespace is there and correct.
    String ns = xhtml.getNsDecl();
    ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, FormatUtilities.XHTML_NS.equals(ns), I18nConstants.XHTML_XHTML_NS_INVALID, ns, FormatUtilities.XHTML_NS) && ok;
    // check that inner namespaces are all correct
    ok = checkInnerNS(errors, e, path, xhtml.getChildNodes()) && ok;
    ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, "div".equals(xhtml.getName()), I18nConstants.XHTML_XHTML_NAME_INVALID, xhtml.getName()) && ok;
    // check that no illegal elements and attributes have been used
    ok = checkInnerNames(errors, e, path, xhtml.getChildNodes(), false) && ok;
    ok = checkUrls(errors, e, path, xhtml.getChildNodes()) && ok;
    ok = checkXhtmlStructure(e.getName(), xhtml) && ok;
    checkMixedLangs(errors, e, path, xhtml.getChildNodes());
    checkForDuplicateIds(errors, e, path, xhtml.getChildNodes());
    return ok;
  }
  
  private boolean checkXhtmlStructure(String path, XhtmlNode x) {
    boolean ok = true;
    for (XhtmlNode c : x.getChildNodes()) {
      switch (c.getNodeType()) {
      case Document: 
        ok = rule(errors, "2025-06-16", IssueType.STRUCTURE, stack, false, I18nConstants.XHTML_XHTML_BAD_ELEMENT_TYPE, c.getNodeType().toCode(), path) && ok;
      case DocType: 
      case Instruction:
        if (x.getNodeType() != NodeType.Document) {
          ok = rule(errors, "2025-06-16", IssueType.STRUCTURE, stack, false, I18nConstants.XHTML_XHTML_BAD_ELEMENT_TYPE, c.getNodeType().toCode(), path) && ok;
        }
        break;
      case Comment: 
        break; // these are always OK
      case Element:
        String cpath = path+"/"+c.getName();
        switch (c.getName()) {
        // switch mode to para:
        case "p": case "h1": case "h2":case "h3": case "h4":  case "h5": case "h6": case "pre": case "address":
          ok = pRules(cpath, c) && ok;
          break;
        // implicitly switch mode to para
        case "br": case "img": case "hr":
          ok = noChildren(cpath, c) && ok;
          break;
        case "a": case "b": case "em": case "i": case "strong": case "small": case "big": case "sub": 
        case "sup": case "code": case "tt": case "dfn": case "q": case "var": case "abbr": case "acronym":
        case "cite": case "bdo": case "kbd": case "samp":
          ok = pRules(cpath, c) && ok;
          ok = noRecursion(cpath, c) && ok;
          break;
        case "span": 
          ok = pRules(cpath, c) && ok;
          break;
        case "div": case "blockquote":
          // no rules
          break;
        case "table":
          ok = onlyChildren(cpath, c, "tbody", "tr", "caption", "thead", "tfoot", "col", "colgroup") && ok;
          break;
        case "tr":
          ok = parent(cpath, c, x, "table", "thead", "tfoot", "tbody") && ok;
          ok = onlyChildren(cpath, c, "td", "th") && ok;
          break;
        case "tbody": case "thead": case "tfoot":
          ok = parent(cpath, c, x, "table") && ok;
          ok = onlyChildren(cpath, c, "tr") && ok;
          break;
        case "ul": case "ol":
          ok = onlyChildren(cpath, c, "li") && ok;
          break;
        case "caption":
          ok = pRules(cpath, c);
          ok = parent(cpath, c, x, "table") && ok;
          break;
        case "colgroup": case "col": 
          ok = parent(cpath, c, x, "table") && ok;
          break;
        case "th": case "td":
          ok = parent(cpath, c, x, "tr", "thead", "tfoot") && ok;
          break;
        case "li":
          ok = parent(cpath, c, x, "ul", "ol") && ok;
          break;
        case "dl" : 
          ok = onlyChildren(cpath, c, "dd", "dt") && ok;
          break;
        case "dd" : case "dt": 
          ok = pRules(cpath, c) && ok;
          ok = parent(cpath, c, x, "dl") && ok;
          break;
        case "map" : 
          ok = onlyChildren(cpath, c, "area") && ok;
          break;
        case "area" : 
          ok = noChildren(cpath, c) && ok;
          break;
        default:
          // nothing
        }
        if (c.hasChildren()) {
          ok = checkXhtmlStructure(cpath, c) && ok;
        }
        break;
      default:
        break;
      }
    }
    return ok;
  }
 
  private boolean pRules( String path, XhtmlNode x) {
    List<String> list = new ArrayList<>();
    findDescendents(list, x.getName(), x, new HashSet<>(Arrays.asList("div", "pre", "table", "ul", "ol")));
    return rule(errors, "2025-06-16", IssueType.STRUCTURE, stack, list.isEmpty(), I18nConstants.XHTML_XHTML_BLOCK_IN_PARA, x.getName(), path, CommaSeparatedStringBuilder.join(",", list));
    // "Found block structures inside a paragraph/text element {0} at {1}: {2}";
  } 

  private boolean noRecursion(String path, XhtmlNode x, String... names) {
    List<String> list = new ArrayList<>();
    findDescendents(list, x.getName(), x, new HashSet<>(Arrays.asList(x.getName())));
    return rule(errors, "2025-06-16", IssueType.STRUCTURE, stack, list.isEmpty(), I18nConstants.XHTML_XHTML_NO_RECURSION, x.getName(), path, CommaSeparatedStringBuilder.join(",", list));
  } 

  private boolean noChildren(String path, XhtmlNode x) {
    return rule(errors, "2025-06-16", IssueType.STRUCTURE, stack, !x.hasChildren(), I18nConstants.XHTML_XHTML_NO_CHILDREN, x.getName(), path);
    // "Elements of type {0} cannot have children";
  }

  private boolean parent(String path, XhtmlNode x, XhtmlNode parent, String... names) {
    return rule(errors, "2025-06-16", IssueType.STRUCTURE, stack, Utilities.existsInList(parent.getName(), names), I18nConstants.XHTML_XHTML_OUT_OF_PLACE, x.getName(), CommaSeparatedStringBuilder.join("|", names), parent.getName(), path);
    // "Elements of type {0} must be in a {1}, not a {2} at {3}";
  }

  private boolean onlyChildren(String path, XhtmlNode x, String... names) {
    Set<String> set = new HashSet<>(Arrays.asList(names));
    List<String> list = new ArrayList<>();
    for (XhtmlNode c : x.getChildNodes()) {
      if (c.getNodeType() == NodeType.Text && c.hasContent()) {
        list.add("@text");
      } else if (c.getNodeType() == NodeType.Element && !set.contains(c.getName())) {
        list.add(c.getName());
      }
    }
    return rule(errors, "2025-06-16", IssueType.STRUCTURE, stack, list.isEmpty(), I18nConstants.XHTML_XHTML_ILLEGAL_CHILDREN, x.getName(), path, CommaSeparatedStringBuilder.join(",", list));
    // "Elements of type {0} at {1} cannot have the following children: {2}";
  }


  private void findDescendents(List<String> list, String path, XhtmlNode x, Set<String> names) {
    for (XhtmlNode c : x.getChildNodes()) {
      if (c.getNodeType() == NodeType.Element) {
        String cpath = path+"/"+c.getName();
        if (names.contains(c.getName())) {
          list.add(cpath);
        }
        if (c.hasChildren()) {
          findDescendents(list, cpath, c, names);
        }
      }
    }
  }



  private boolean checkInnerNS(List<ValidationMessage> errors, Element e, String path, List<XhtmlNode> list) {
    boolean ok = true;
    for (XhtmlNode node : list) {
      if (node.getNodeType() == NodeType.Element) {
        String ns = node.getNsDecl();
        ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, ns == null || FormatUtilities.XHTML_NS.equals(ns), I18nConstants.XHTML_XHTML_NS_INVALID, ns, FormatUtilities.XHTML_NS) && ok;
        checkInnerNS(errors, e, path, node.getChildNodes());
      }
    }
    return ok;
  }

  private void checkForDuplicateIds(List<ValidationMessage> errors, Element e, String path, List<XhtmlNode> list) {
    Set<String> ids = new HashSet<>();
    Map<String, Integer> duplicates = new HashMap<>();
    scanXhtmlIds(list, ids, duplicates);
    if (!duplicates.isEmpty()) {
      List<String> summary = new ArrayList<>();
      for (String k : Utilities.sorted(duplicates.keySet())) {
        summary.add(k+" ("+duplicates.get(k)+"x)");      
      }
      warning(errors, "2025-06-12", IssueType.BUSINESSRULE, e.line(), e.col(), path, false, I18nConstants.XHTML_XHTML_DUPLICATE_IDS, CommaSeparatedStringBuilder.join(", ", summary));
    }
  }
  

  private void scanXhtmlIds(List<XhtmlNode> list, Set<String> ids, Map<String, Integer> duplicates) {
    for (XhtmlNode node : list) {
      String id = null;
      if (node.hasAttribute("id")) {
        id = node.getAttribute("id");
         if (!ids.contains(id)) {
           ids.add(id);
         } else {
           duplicates.put(id, duplicates.getOrDefault(id, 1)+1);
         }
      }
      if ("a".equals(node.getName()) && node.hasAttribute("name")) {
        String name = node.getAttribute("name");
        if (!name.equals(id)) { // it's fine to have the same name and id on the one element
          if (!ids.contains(name)) {
            ids.add(name);
          } else {
            duplicates.put(name, duplicates.getOrDefault(name, 1)+1);
          }
        }
     }
      if (node.hasChildren()) {
        scanXhtmlIds(node.getChildNodes(), ids, duplicates);
      }
    }    
  }

  
  private void checkMixedLangs(List<ValidationMessage> errors, Element e, String path, List<XhtmlNode> list) {
    Set<String> langs = new HashSet<>();
    boolean nonLangContent = false;
    for (XhtmlNode node : list) {
      if (node.getNodeType() == NodeType.Element && "div".equals(node.getName()) && isLangDiv(node)) {
        langs.add(node.getAttribute("xml:lang"));
      } else if(node.hasContent()) {
        nonLangContent = true;
      }
    }
    warning(errors, "2025-06-07", IssueType.BUSINESSRULE, e.line(), e.col(), path, langs.isEmpty() ||!nonLangContent, I18nConstants.XHTML_XHTML_MIXED_LANG, CommaSeparatedStringBuilder.join(", ", langs));
  }
  

  public static boolean isLangDiv(XhtmlNode node) {
    return node.hasAttribute("xml:lang");
  }

  private boolean checkInnerNames(List<ValidationMessage> errors, Element e, String path, List<XhtmlNode> list, boolean inPara) {
    boolean ok = true;
    for (XhtmlNode node : list) {
      if (node.getNodeType() == NodeType.Comment) {
        ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, !node.getContent().startsWith("DOCTYPE"), I18nConstants.XHTML_XHTML_DOCTYPE_ILLEGAL) && ok;
      }
      if (node.getNodeType() == NodeType.Element) {
        ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, HTML_ELEMENTS.contains(node.getName()), I18nConstants.XHTML_XHTML_ELEMENT_ILLEGAL, node.getName()) && ok;
        
        for (String an : node.getAttributes().keySet()) {
          boolean bok = an.startsWith("xmlns") || HTML_ATTRIBUTES.contains(an) || HTML_COMBO_LIST.contains(node.getName() + "." + an);          
          if (!bok) {
            if ("xml:space".equals(an)) {
              hint(errors, "2024-08-03", IssueType.INVALID, e.line(), e.col(), path, false, I18nConstants.XHTML_XHTML_ATTRIBUTE_XML_SPACE, an, node.getName());              
            } else {
              ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, false, I18nConstants.XHTML_XHTML_ATTRIBUTE_ILLEGAL, an, node.getName()) && ok;
            }
          }
        }
        
        ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, !(inPara && HTML_BLOCK_LIST.contains(node.getName())) , I18nConstants.XHTML_XHTML_ELEMENT_ILLEGAL_IN_PARA, node.getName()) && ok;
        
        ok = checkInnerNames(errors, e, path, node.getChildNodes(), inPara || "p".equals(node.getName())) && ok;
      }
    }
    return ok;
  }

  private boolean checkUrls(List<ValidationMessage> errors, Element e, String path, List<XhtmlNode> list) {
    boolean ok = true;
    for (XhtmlNode node : list) {
      if (node.getNodeType() == NodeType.Element) {
        if ("a".equals(node.getName())) {
          String msg = UrlUtil.checkValidUrl(node.getAttribute("href"), context);
          ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, msg == null, I18nConstants.XHTML_URL_INVALID, node.getAttribute("href"), msg) && ok;
        } else if ("img".equals(node.getName())) {
          String msg = UrlUtil.checkValidUrl(node.getAttribute("src"), context);
          ok = rule(errors, NO_RULE_DATE, IssueType.INVALID, e.line(), e.col(), path, msg == null, I18nConstants.XHTML_URL_INVALID, node.getAttribute("src"), msg) && ok;
        }
        ok = checkUrls(errors, e, path, node.getChildNodes()) && ok;
      }
    }
    return ok;
  }
  
}
