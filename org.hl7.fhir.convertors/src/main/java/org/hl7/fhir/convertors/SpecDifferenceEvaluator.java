package org.hl7.fhir.convertors;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.hl7.fhir.convertors.conv40_50.resources40_50.StructureDefinition40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.ValueSet40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class SpecDifferenceEvaluator {

  private final SpecPackage original = new SpecPackage();
  private final SpecPackage revision = new SpecPackage();
  private final Map<String, String> renames = new HashMap<String, String>();
  private final List<String> moves = new ArrayList<String>();
  private XhtmlNode tbl;
  private TypeLinkProvider linker;

  public static void main(String[] args) throws Exception {
    System.out.println("gen diff");
    SpecDifferenceEvaluator self = new SpecDifferenceEvaluator();
    self.loadFromIni(new IniFile("C:\\work\\org.hl7.fhir\\build\\source\\fhir.ini"));
//    loadVS2(self.original.valuesets, "C:\\work\\org.hl7.fhir.dstu2.original\\build\\publish\\valuesets.xml");
//    loadVS(self.revision.valuesets, "C:\\work\\org.hl7.fhir.dstu2.original\\build\\publish\\valuesets.xml");

    loadSD4(self.original.getTypes(), "C:\\work\\org.hl7.fhir\\build\\source\\release4\\profiles-types.xml");
    loadSD(self.revision.getTypes(), "C:\\work\\org.hl7.fhir\\build\\publish\\profiles-types.xml");
    loadSD4(self.original.getResources(), "C:\\work\\org.hl7.fhir\\build\\source\\release4\\profiles-resources.xml");
    loadSD(self.revision.getResources(), "C:\\work\\org.hl7.fhir\\build\\publish\\profiles-resources.xml");
    loadVS4(self.original.getExpansions(), "C:\\work\\org.hl7.fhir\\build\\source\\release4\\expansions.xml");
    loadVS(self.revision.getExpansions(), "C:\\work\\org.hl7.fhir\\build\\publish\\expansions.xml");
    loadVS4(self.original.getValuesets(), "C:\\work\\org.hl7.fhir\\build\\source\\release4\\valuesets.xml");
    loadVS(self.revision.getValuesets(), "C:\\work\\org.hl7.fhir\\build\\publish\\valuesets.xml");
    StringBuilder b = new StringBuilder();
    b.append("<html>\r\n");
    b.append("<head>\r\n");
    b.append("<link href=\"fhir.css\" rel=\"stylesheet\"/>\r\n");
    b.append("</head>\r\n");
    b.append("<body>\r\n");
    b.append(self.getDiffAsHtml(null));
    b.append("</body>\r\n");
    b.append("</html>\r\n");
    TextFile.stringToFile(b.toString(), Utilities.path("[tmp]", "diff.html"));
    System.out.println("done");
  }

  private static void loadSD4(Map<String, StructureDefinition> map, String fn) throws FHIRException, IOException {
    org.hl7.fhir.r4.model.Bundle bundle = (org.hl7.fhir.r4.model.Bundle) new org.hl7.fhir.r4.formats.XmlParser().parse(new FileInputStream(fn));
    for (org.hl7.fhir.r4.model.Bundle.BundleEntryComponent be : bundle.getEntry()) {
      if (be.getResource() instanceof org.hl7.fhir.r4.model.StructureDefinition) {
        org.hl7.fhir.r4.model.StructureDefinition sd = (org.hl7.fhir.r4.model.StructureDefinition) be.getResource();
        map.put(sd.getName(), StructureDefinition40_50.convertStructureDefinition(sd));
      }
    }

  }

  private static void loadSD(Map<String, StructureDefinition> map, String fn) throws FHIRFormatError, IOException {
    Bundle bundle = (Bundle) new XmlParser().parse(new FileInputStream(fn));
    for (BundleEntryComponent be : bundle.getEntry()) {
      if (be.getResource() instanceof StructureDefinition) {
        StructureDefinition sd = (StructureDefinition) be.getResource();
        map.put(sd.getName(), sd);
      }
    }
  }

  private static void loadVS4(Map<String, ValueSet> map, String fn) throws FHIRException, IOException {
    org.hl7.fhir.r4.model.Bundle bundle = (org.hl7.fhir.r4.model.Bundle) new org.hl7.fhir.r4.formats.XmlParser().parse(new FileInputStream(fn));
    for (org.hl7.fhir.r4.model.Bundle.BundleEntryComponent be : bundle.getEntry()) {
      if (be.getResource() instanceof org.hl7.fhir.r4.model.ValueSet) {
        org.hl7.fhir.r4.model.ValueSet sd = (org.hl7.fhir.r4.model.ValueSet) be.getResource();
        map.put(sd.getName(), ValueSet40_50.convertValueSet(sd));
      }
    }
  }

  private static void loadVS(Map<String, ValueSet> map, String fn) throws FHIRFormatError, IOException {
    Bundle bundle = (Bundle) new XmlParser().parse(new FileInputStream(fn));
    for (BundleEntryComponent be : bundle.getEntry()) {
      if (be.getResource() instanceof ValueSet) {
        ValueSet sd = (ValueSet) be.getResource();
        map.put(sd.getName(), sd);
      }
    }
  }

  public void loadFromIni(IniFile ini) {
    String[] names = ini.getPropertyNames("r5-renames");
    if (names != null)
      for (String n : names)
        // note reverse of order
        renames.put(ini.getStringProperty("r5-renames", n), n);
    names = ini.getPropertyNames("r4b-renames");
    if (names != null)
      for (String n : names)
        // note reverse of order
        renames.put(ini.getStringProperty("r4b-renames", n), n);
  }

  public SpecPackage getOriginal() {
    return original;
  }

  public SpecPackage getRevision() {
    return revision;
  }

  public void getDiffAsJson(JsonObject json, StructureDefinition rev) throws IOException {
    this.linker = null;
    StructureDefinition orig = original.getResources().get(checkRename(rev.getName()));
    if (orig == null)
      orig = original.getTypes().get(checkRename(rev.getName()));
    JsonArray types = new JsonArray();
    json.add("types", types);
    types.add(new JsonPrimitive(rev.getName()));
    JsonObject type = new JsonObject();
    json.add(rev.getName(), type);
    if (orig == null)
      type.addProperty("status", "new");
    else {
      start();
      compareJson(type, orig, rev);
    }
  }

  public void getDiffAsXml(Document doc, Element xml, StructureDefinition rev) throws IOException {
    this.linker = null;
    StructureDefinition orig = original.getResources().get(checkRename(rev.getName()));
    if (orig == null)
      orig = original.getTypes().get(checkRename(rev.getName()));
    Element type = doc.createElement("type");
    type.setAttribute("name", rev.getName());
    xml.appendChild(type);
    if (orig == null)
      type.setAttribute("status", "new");
    else {
      start();
      compareXml(doc, type, orig, rev);
    }
  }

  public void getDiffAsJson(JsonObject json) throws IOException {
    this.linker = null;
    JsonArray types = new JsonArray();
    json.add("types", types);

    for (String s : sorted(revision.getTypes().keySet())) {
      StructureDefinition orig = original.getTypes().get(s);
      StructureDefinition rev = revision.getTypes().get(s);
      types.add(new JsonPrimitive(rev.getName()));
      JsonObject type = new JsonObject();
      json.add(rev.getName(), type);
      if (orig == null) {
        type.addProperty("status", "new");
      } else if (rev.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
        type.addProperty("status", "no-change");
      } else if (rev.hasDerivation() && orig.hasDerivation() && rev.getDerivation() != orig.getDerivation()) {
        type.addProperty("status", "status-change");
        type.addProperty("past-status", orig.getDerivation().toCode());
        type.addProperty("current-status", rev.getDerivation().toCode());
      } else {
        compareJson(type, orig, rev);
      }
    }
    for (String s : sorted(original.getTypes().keySet())) {
      StructureDefinition orig = original.getTypes().get(s);
      StructureDefinition rev = revision.getTypes().get(s);
      if (rev == null) {
        types.add(new JsonPrimitive(orig.getName()));
        JsonObject type = new JsonObject();
        json.add(orig.getName(), type);
        type.addProperty("status", "deleted");
      }
    }

    for (String s : sorted(revision.getResources().keySet())) {
      StructureDefinition orig = original.getResources().get(checkRename(s));
      StructureDefinition rev = revision.getResources().get(s);
      types.add(new JsonPrimitive(rev.getName()));
      JsonObject type = new JsonObject();
      json.add(rev.getName(), type);
      if (orig == null) {
        type.addProperty("status", "new");
      } else {
        compareJson(type, orig, rev);
      }
    }
    for (String s : sorted(original.getResources().keySet())) {
      StructureDefinition orig = original.getResources().get(s);
      StructureDefinition rev = revision.getResources().get(s);
      if (rev == null) {
        types.add(new JsonPrimitive(orig.getName()));
        JsonObject type = new JsonObject();
        json.add(orig.getName(), type);
        type.addProperty("status", "deleted");
      }
    }
  }

  public void getDiffAsXml(Document doc, Element xml) throws IOException {
    this.linker = null;

    for (String s : sorted(revision.getTypes().keySet())) {
      StructureDefinition orig = original.getTypes().get(s);
      StructureDefinition rev = revision.getTypes().get(s);
      Element type = doc.createElement("type");
      type.setAttribute("name", rev.getName());
      xml.appendChild(type);
      if (orig == null) {
        type.setAttribute("status", "new");
      } else if (rev.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
        type.setAttribute("status", "no-change");
      } else if (rev.hasDerivation() && orig.hasDerivation() && rev.getDerivation() != orig.getDerivation()) {
        type.setAttribute("status", "status-change");
        type.setAttribute("past-status", orig.getDerivation().toCode());
        type.setAttribute("current-status", rev.getDerivation().toCode());
      } else {
        compareXml(doc, type, orig, rev);
      }
    }
    for (String s : sorted(original.getTypes().keySet())) {
      StructureDefinition orig = original.getTypes().get(s);
      StructureDefinition rev = revision.getTypes().get(s);
      if (rev == null) {
        Element type = doc.createElement("type");
        type.setAttribute("name", orig.getName());
        xml.appendChild(type);
        type.setAttribute("status", "deleted");
      }
    }

    for (String s : sorted(revision.getResources().keySet())) {
      StructureDefinition orig = original.getResources().get(checkRename(s));
      StructureDefinition rev = revision.getResources().get(s);
      Element type = doc.createElement("type");
      type.setAttribute("name", rev.getName());
      xml.appendChild(type);
      if (orig == null) {
        type.setAttribute("status", "new");
      } else {
        compareXml(doc, type, orig, rev);
      }
    }
    for (String s : sorted(original.getResources().keySet())) {
      StructureDefinition orig = original.getResources().get(s);
      StructureDefinition rev = revision.getResources().get(s);
      if (rev == null) {
        Element type = doc.createElement("type");
        type.setAttribute("name", orig.getName());
        xml.appendChild(type);
        type.setAttribute("status", "deleted");
      }
    }
  }

  public String getDiffAsHtml(TypeLinkProvider linker, StructureDefinition rev) throws IOException {
    this.linker = linker;

    StructureDefinition orig = original.getResources().get(checkRename(rev.getName()));
    if (orig == null)
      orig = original.getTypes().get(checkRename(rev.getName()));
    if (orig == null)
      return "<p>This " + rev.getKind().toCode() + " did not exist in Release 3</p>";
    else {
       start();
      compare(orig, rev);
      return new XhtmlComposer(false, true).compose(tbl) + "\r\n<p>See the <a href=\"diff.html\">Full Difference</a> for further information</p>\r\n";
    }
  }

  public String getDiffAsHtml(TypeLinkProvider linker) throws IOException {
    this.linker = linker;
    start();

    header("Types");
    for (String s : sorted(revision.getTypes().keySet())) {
      StructureDefinition orig = original.getTypes().get(s);
      StructureDefinition rev = revision.getTypes().get(s);
      if (orig == null) {
        markNew(rev.getName(), true, false, false);
      } else if (rev.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
        markNoChanges(rev.getName(), true);
      } else if (rev.hasDerivation() && orig.hasDerivation() && rev.getDerivation() != orig.getDerivation()) {
        markChanged(rev.getName(), "Changed from a " + orig.getDerivation().toCode() + " to a " + rev.getDerivation().toCode(), true);
      } else {
        compare(orig, rev);
      }
    }
    for (String s : sorted(original.getTypes().keySet())) {
      StructureDefinition orig = original.getTypes().get(s);
      StructureDefinition rev = revision.getTypes().get(s);
      if (rev == null)
        markDeleted(orig.getName(), true);
    }

    header("Resources");
    for (String s : sorted(revision.getResources().keySet())) {
      StructureDefinition orig = original.getResources().get(checkRename(s));
      StructureDefinition rev = revision.getResources().get(s);
      if (orig == null) {
        markNew(rev.getName(), true, true, false);
      } else {
        compare(orig, rev);
      }
    }
    for (String s : sorted(original.getResources().keySet())) {
      StructureDefinition orig = original.getResources().get(s);
      StructureDefinition rev = revision.getResources().get(s);
      if (rev == null)
        markDeleted(orig.getName(), true);
    }

    return new XhtmlComposer(false, true).compose(tbl);
  }

  private Object checkRename(String s) {
    if (renames.containsKey(s))
      return renames.get(s);
    else
      return s;
  }

  private List<String> sorted(Set<String> keys) {
    List<String> list = new ArrayList<String>();
    list.addAll(keys);
    Collections.sort(list);
    return list;
  }

  private void header(String title) {
    tbl.addTag("tr").setAttribute("class", "diff-title").addTag("td").setAttribute("colspan", "2").addText(title);
  }

  private void start() {
    tbl = new XhtmlNode(NodeType.Element, "table");
    tbl.setAttribute("class", "grid");

  }

  private void markNoChanges(String name, boolean item) {
    XhtmlNode tr = tbl.addTag("tr").setAttribute("class", item ? "diff-item" : "diff-entry");
    XhtmlNode left = tr.addTag("td").setAttribute("class", "diff-left");
    XhtmlNode right = tr.addTag("td").setAttribute("class", "diff-right");
    String link = linker == null ? null : linker.getLink(name);
    if (link != null)
      left.addTag("a").setAttribute("href", link).addText(name);
    else
      left.addText(name);
    right.span("opacity: 0.5", null).addText("(No Changes)");
  }

  private void markChanged(String name, String change, boolean item) {
    XhtmlNode tr = tbl.addTag("tr").setAttribute("class", item ? "diff-item" : "diff-entry");
    XhtmlNode left = tr.addTag("td").setAttribute("class", "diff-left");
    XhtmlNode right = tr.addTag("td").setAttribute("class", "diff-right");
    String link = linker == null ? null : linker.getLink(name);
    if (link != null)
      left.addTag("a").setAttribute("href", link).addText(name);
    else
      left.addText(name);
    right.ul().li().addText(change);
  }

  private void markDeleted(String name, boolean item) {
    XhtmlNode tr = tbl.addTag("tr").setAttribute("class", item ? "diff-del-item" : "diff-del");
    XhtmlNode left = tr.addTag("td").setAttribute("class", "diff-left");
    XhtmlNode right = tr.addTag("td").setAttribute("class", "diff-right");
    left.addText(name);
    right.ul().li().addText("deleted");
  }

  private void markNew(String name, boolean item, boolean res, boolean mand) {
    XhtmlNode tr = tbl.addTag("tr").setAttribute("class", item ? "diff-new-item" : "diff-new");
    XhtmlNode left = tr.addTag("td").setAttribute("class", "diff-left");
    XhtmlNode right = tr.addTag("td").setAttribute("class", "diff-right");
    String link = linker == null ? null : linker.getLink(name);
    if (link != null)
      left.addTag("a").setAttribute("href", link).addText(name);
    else
      left.addText(name);
    if (!res && mand)
      right.ul().li().b().addText("Added Mandatory Element");
    else
      right.ul().li().addText(res ? "Added Resource" : !name.contains(".") ? "Added Type" : mand ? "Added Mandatory Element " : "Added Element");
  }

  private void compare(StructureDefinition orig, StructureDefinition rev) {
    moves.clear();
    XhtmlNode tr = tbl.addTag("tr").setAttribute("class", "diff-item");
    XhtmlNode left = tr.addTag("td").setAttribute("class", "diff-left");
    String link = linker == null ? null : linker.getLink(rev.getName());
    if (link != null)
      left.addTag("a").setAttribute("href", link).addText(rev.getName());
    else
      left.addText(rev.getName());
    XhtmlNode right = tr.addTag("td").setAttribute("class", "diff-right");

    // first, we must match revision elements to old elements
    boolean changed = false;
    if (!orig.getName().equals(rev.getName())) {
      changed = true;
      right.ul().li().addText("Name Changed from " + orig.getName() + " to " + rev.getName());
    }
    for (ElementDefinition ed : rev.getDifferential().getElement()) {
      ElementDefinition oed = getMatchingElement(rev.getName(), orig.getDifferential().getElement(), ed);
      if (oed != null) {
        ed.setUserData("match", oed);
        oed.setUserData("match", ed);
      }
    }

    for (ElementDefinition ed : rev.getDifferential().getElement()) {
      ElementDefinition oed = (ElementDefinition) ed.getUserData("match");
      if (oed == null) {
        changed = true;
        markNew(ed.getPath(), false, false, ed.getMin() > 0);
      } else
        changed = compareElement(ed, oed) || changed;
    }

    List<String> dels = new ArrayList<String>();

    for (ElementDefinition ed : orig.getDifferential().getElement()) {
      if (ed.getUserData("match") == null) {
        changed = true;
        boolean marked = false;
        for (String s : dels)
          if (ed.getPath().startsWith(s + "."))
            marked = true;
        if (!marked) {
          dels.add(ed.getPath());
          markDeleted(ed.getPath(), false);
        }
      }
    }

    if (!changed)
      right.ul().li().addText("No Changes");

    for (ElementDefinition ed : rev.getDifferential().getElement())
      ed.clearUserData("match");
    for (ElementDefinition ed : orig.getDifferential().getElement())
      ed.clearUserData("match");

  }

  private ElementDefinition getMatchingElement(String tn, List<ElementDefinition> list, ElementDefinition target) {
    // now, look for matches by name (ignoring slicing for now)
    String tp = mapPath(tn, target.getPath());
    if (tp.endsWith("[x]"))
      tp = tp.substring(0, tp.length() - 4);
    for (ElementDefinition ed : list) {
      String p = ed.getPath();
      if (p.endsWith("[x]"))
        p = p.substring(0, p.length() - 4);
      if (p.equals(tp))
        return ed;
    }
    return null;
  }

  /**
   * change from rev to original. TODO: make this a config file somewhere?
   *
   * @param tn
   * @return
   */
  private String mapPath(String tn, String path) {
    if (renames.containsKey(path))
      return renames.get(path);
    for (String r : renames.keySet()) {
      if (path.startsWith(r + "."))
        return renames.get(r) + "." + path.substring(r.length() + 1);
    }
    return path;
  }

  private boolean compareElement(ElementDefinition rev, ElementDefinition orig) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("\r\n");
    String rn = tail(rev.getPath());
    String on = tail(orig.getPath());
    String rp = head(rev.getPath());
    String op = head(orig.getPath());
    boolean renamed = false;
    if (!rn.equals(on) && rev.getPath().contains(".")) {
      if (rp.equals(op))
        b.append("Renamed from " + on + " to " + rn);
      else
        b.append("Moved from " + orig.getPath() + " to " + rn);
      renamed = true;
    } else if (!rev.getPath().equals(orig.getPath())) {
      if (!moveAlreadyNoted(rev.getPath(), orig.getPath())) {
        noteMove(rev.getPath(), orig.getPath());
        b.append("Moved from " + head(orig.getPath()) + " to " + head(rev.getPath()));
        renamed = true;
      }
    }

    if (rev.getMin() != orig.getMin())
      b.append("Min Cardinality changed from " + orig.getMin() + " to " + rev.getMin());

    if (!rev.getMax().equals(orig.getMax()))
      b.append("Max Cardinality changed from " + orig.getMax() + " to " + rev.getMax());

    analyseTypes(b, rev, orig);

    if (hasBindingToNote(rev) || hasBindingToNote(orig)) {
      String s = compareBindings(rev, orig);
      if (!Utilities.noString(s))
        b.append(s);
    }

    if (rev.hasDefaultValue() || orig.hasDefaultValue()) {
      if (!rev.hasDefaultValue())
        b.append("Default Value " + describeValue(orig.getDefaultValue()) + " removed");
      else if (!orig.hasDefaultValue())
        b.append("Default Value " + describeValue(rev.getDefaultValue()) + " added");
      else {
        // do not use Base.compare here, because it is subject to type differences
        String s1 = describeValue(orig.getDefaultValue());
        String s2 = describeValue(rev.getDefaultValue());
        if (!s1.equals(s2))
          b.append("Default Value changed from " + s1 + " to " + s2);
      }
    }

    if (rev.getIsModifier() != orig.getIsModifier()) {
      if (rev.getIsModifier())
        b.append("Now marked as Modifier");
      else
        b.append("No longer marked as Modifier");
    }

    if (b.length() > 0) {
      XhtmlNode tr = tbl.addTag("tr").setAttribute("class", renamed ? "diff-changed-item" : "diff-entry");
      XhtmlNode left = tr.addTag("td").setAttribute("class", "diff-left");
      left.addText(rev.getPath());
      XhtmlNode right = tr.addTag("td").setAttribute("class", "diff-right");
      XhtmlNode ul = null;
      for (String s : b.toString().split("\\r?\\n")) {
        if (!Utilities.noString(s)) {
          if (ul == null)
            ul = right.addTag("ul");
          XhtmlNode li = ul.addTag("li").notPretty();
          if (s.contains("`")) {
            String[] p = s.split("\\`");
            boolean code = true;
            li.addText(p[0]);
            for (int i = 1; i < p.length; i++) {
              if (code)
                li.addTag("code").addText(p[i]);
              else
                li.addText(p[i]);
              code = !code;
            }
          } else
            li.addText(s);
        }
      }
    }
    return b.length() > 0;
  }

  private void noteMove(String revpath, String origpath) {
    moves.add(revpath + "=" + origpath);
  }

  private boolean moveAlreadyNoted(String revpath, String origpath) {
    if (moves.contains(revpath + "=" + origpath))
      return true;
    if (!revpath.contains(".") || !origpath.contains("."))
      return false;
    return moveAlreadyNoted(head(revpath), head(origpath));
  }

  @SuppressWarnings("rawtypes")
  private String describeValue(DataType v) {
    if (v instanceof PrimitiveType) {
      return "\"" + ((PrimitiveType) v).asStringValue() + "\"";
    }
    return "{complex}";
  }

  private String compareBindings(ElementDefinition rev, ElementDefinition orig) {
    if (!hasBindingToNote(rev)) {
      return "Remove Binding " + describeBinding(orig);
    } else if (!hasBindingToNote(orig)) {
      return "Add Binding " + describeBinding(rev);
    } else {
      return compareBindings(rev.getBinding(), orig.getBinding());
    }
  }

  private String compareBindings(ElementDefinitionBindingComponent rev, ElementDefinitionBindingComponent orig) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("\r\n");
    if (rev.getStrength() != orig.getStrength())
      b.append("Change binding strength from " + orig.getStrength().toCode() + " to " + rev.getStrength().toCode());
    if (!canonicalsMatch(rev.getValueSet(), orig.getValueSet())) {
      b.append("Change value set from " + describeReference(orig.getValueSet()) + " to " + describeReference(rev.getValueSet()));
    }
    if (!maxValueSetsMatch(rev, orig))
      b.append("Change max value set from " + describeMax(orig) + " to " + describeMax(rev));
    if (rev.getStrength() == BindingStrength.REQUIRED && orig.getStrength() == BindingStrength.REQUIRED) {
      ValueSet vrev = getValueSet(rev.getValueSet(), revision.getExpansions());
      ValueSet vorig = getValueSet(rev.getValueSet(), original.getExpansions());
      CommaSeparatedStringBuilder br = new CommaSeparatedStringBuilder();
      int ir = 0;
      CommaSeparatedStringBuilder bo = new CommaSeparatedStringBuilder();
      int io = 0;
      if (vrev != null && vorig != null) {
        for (ValueSetExpansionContainsComponent cc : vorig.getExpansion().getContains()) {
          if (!hasCode(vrev, cc)) {
            io++;
            bo.append("`" + Utilities.escapeXml(cc.getCode()) + "`");
          }
        }
        for (ValueSetExpansionContainsComponent cc : vrev.getExpansion().getContains()) {
          if (!hasCode(vorig, cc)) {
            ir++;
            br.append("`" + Utilities.escapeXml(cc.getCode()) + "`");
          }
        }
      }
      if (io > 0)
        b.append("Remove " + Utilities.pluralize("Code", io) + " " + bo);
      if (ir > 0)
        b.append("Add " + Utilities.pluralize("Code", ir) + "  " + br);

    }
    if (rev.getStrength() == BindingStrength.EXTENSIBLE && orig.getStrength() == BindingStrength.EXTENSIBLE) {
      ValueSet vrev = getValueSet(rev.getValueSet(), revision.getValuesets());
      ValueSet vorig = getValueSet(orig.getValueSet(), original.getValuesets());
      if (vrev != null && vrev.hasCompose() && vrev.getCompose().getInclude().size() == 1 && vrev.getCompose().getIncludeFirstRep().hasSystem() &&
        vorig != null && vorig.hasCompose() && vorig.getCompose().getInclude().size() == 1 && vorig.getCompose().getIncludeFirstRep().hasSystem()) {
        if (!vorig.getCompose().getIncludeFirstRep().getSystem().equals(vrev.getCompose().getIncludeFirstRep().getSystem())) {
          b.append("Change code system for extensibly bound codes from \"" + vorig.getCompose().getIncludeFirstRep().getSystem() + "\" to \"" + vrev.getCompose().getIncludeFirstRep().getSystem() + "\"");
        }
      }
    }

    return b.toString();
  }

  private boolean canonicalsMatch(String url1, String url2) {

    String rvs = VersionUtilities.removeVersionFromCanonical(url1);
    String ovs = VersionUtilities.removeVersionFromCanonical(url2);

    if (rvs == null && ovs == null) {
      return true;
    } else if (rvs == null) {
      return false;
    } else {
     return rvs.equals(ovs);
    }
  }

  private String describeMax(ElementDefinitionBindingComponent orig) {
    if (!orig.hasExtension(ToolingExtensions.EXT_MAX_VALUESET))
      return "n/a";
    return "`" + ToolingExtensions.readStringExtension(orig, ToolingExtensions.EXT_MAX_VALUESET) + "`";
  }

  private boolean maxValueSetsMatch(ElementDefinitionBindingComponent rev, ElementDefinitionBindingComponent orig) {
    if (!rev.hasExtension(ToolingExtensions.EXT_MAX_VALUESET) && !orig.hasExtension(ToolingExtensions.EXT_MAX_VALUESET))
      return true;
    if (rev.hasExtension(ToolingExtensions.EXT_MAX_VALUESET) != orig.hasExtension(ToolingExtensions.EXT_MAX_VALUESET))
      return false;
    return ToolingExtensions.readStringExtension(rev, ToolingExtensions.EXT_MAX_VALUESET).equals(ToolingExtensions.readStringExtension(orig, ToolingExtensions.EXT_MAX_VALUESET));
  }

//  "Remove code "+
//  "add code "+

  private String describeBinding(ElementDefinition orig) {
    if (orig.getBinding().hasExtension(ToolingExtensions.EXT_MAX_VALUESET))
      return "`" + orig.getBinding().getValueSet() + "` (" + orig.getBinding().getStrength().toCode() + "), max =`" + ToolingExtensions.readStringExtension(orig.getBinding(), ToolingExtensions.EXT_MAX_VALUESET) + "`";
    else
      return "`" + orig.getBinding().getValueSet() + "` (" + orig.getBinding().getStrength().toCode() + ")";
  }

  private void describeBinding(JsonObject element, String name, ElementDefinition orig) {
    JsonObject binding = new JsonObject();
    element.add(name, binding);
    binding.addProperty("reference", describeReference(orig.getBinding().getValueSet()));
    binding.addProperty("strength", orig.getBinding().getStrength().toCode());
    if (orig.getBinding().hasExtension(ToolingExtensions.EXT_MAX_VALUESET))
      binding.addProperty("max", ToolingExtensions.readStringExtension(orig.getBinding(), ToolingExtensions.EXT_MAX_VALUESET));
  }

  private void describeBinding(Document doc, Element element, String name, ElementDefinition orig) {
    Element binding = doc.createElement(name);
    element.appendChild(binding);
    binding.setAttribute("reference", describeReference(orig.getBinding().getValueSet()));
    binding.setAttribute("strength", orig.getBinding().getStrength().toCode());
    if (orig.getBinding().hasExtension(ToolingExtensions.EXT_MAX_VALUESET))
      binding.setAttribute("max", ToolingExtensions.readStringExtension(orig.getBinding(), ToolingExtensions.EXT_MAX_VALUESET));
  }

  private String describeReference(String ref) {
    return ref;
  }

  private ValueSet getValueSet(String ref, Map<String, ValueSet> expansions) {
    if (ref != null) {
      if (Utilities.isAbsoluteUrl(ref)) {
        for (ValueSet ve : expansions.values()) {
          if (ref.equals(ve.getUrl()))
            return ve;
        }
      } else if (ref.startsWith("ValueSet/")) {
        ref = ref.substring(9);
        for (ValueSet ve : expansions.values()) {
          if (ve.getId().equals(ref))
            return ve;
        }
      }
    }
    return null;
  }

  private String listCodes(ValueSet vs) {
    if (vs.getExpansion().getContains().size() > 15)
      return ">15 codes";
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(" | ");
    for (ValueSetExpansionContainsComponent ce : vs.getExpansion().getContains()) {
      if (ce.hasCode())
        b.append(ce.getCode());
    }
    return b.toString();
  }

  private boolean hasBindingToNote(ElementDefinition ed) {
    return ed.hasBinding() &&
      (ed.getBinding().getStrength() == BindingStrength.EXTENSIBLE || ed.getBinding().getStrength() == BindingStrength.REQUIRED || ed.getBinding().hasExtension(ToolingExtensions.EXT_MAX_VALUESET)) &&
      ed.getBinding().hasValueSet();
  }

  private String tail(String path) {
    return path.contains(".") ? path.substring(path.lastIndexOf(".") + 1) : path;
  }

  private String head(String path) {
    return path.contains(".") ? path.substring(0, path.lastIndexOf(".")) : path;
  }

  private void analyseTypes(CommaSeparatedStringBuilder bp, ElementDefinition rev, ElementDefinition orig) {
    if (rev.getType().size() == 1 && orig.getType().size() == 1) {
      String r = describeType(rev.getType().get(0));
      if (Utilities.noString(r) && Utilities.existsInList(rev.getId(), "Element.id"))
        r = "string";
      if (Utilities.noString(r) && Utilities.existsInList(rev.getId(), "Extension.url"))
        r = "uri";
      String o = describeType(orig.getType().get(0));
      if (r == null && o == null)
        System.out.println("null @ " + rev.getPath());
      if (r.contains("(") && o.contains("(") && r.startsWith(o.substring(0, o.indexOf("(") + 1))) {
        compareParameters(bp, rev.getType().get(0), orig.getType().get(0));
      } else if (!r.equals(o))
        bp.append("Type changed from " + o + " to " + r);
    } else {
      CommaSeparatedStringBuilder removed = new CommaSeparatedStringBuilder();
      CommaSeparatedStringBuilder added = new CommaSeparatedStringBuilder();
      CommaSeparatedStringBuilder retargetted = new CommaSeparatedStringBuilder();
      for (TypeRefComponent tr : orig.getType()) {
        if (!hasType(rev.getType(), tr))
          removed.append(describeType(tr));
      }
      for (TypeRefComponent tr : rev.getType()) {
        if (!hasType(orig.getType(), tr) && !isAbstractType(tr.getWorkingCode()))
          added.append(describeType(tr));
      }
      for (TypeRefComponent tr : rev.getType()) {
        TypeRefComponent tm = getType(rev.getType(), tr);
        if (tm != null) {
          compareParameters(bp, tr, tm);
        }
      }
      if (added.length() > 0)
        bp.append("Add " + Utilities.pluralize("Type", added.count()) + " " + added);
      if (removed.length() > 0)
        bp.append("Remove " + Utilities.pluralize("Type", removed.count()) + " " + removed);
      if (retargetted.length() > 0)
        bp.append(retargetted.toString());
    }
  }

  private void compareParameters(CommaSeparatedStringBuilder bp, TypeRefComponent tr, TypeRefComponent tm) {
    List<String> added = new ArrayList<>();
    List<String> removed = new ArrayList<>();

    for (CanonicalType p : tr.getTargetProfile()) {
      if (!hasParam(tm, p.asStringValue())) {
        added.add(trimNS(p.asStringValue()));
      }
    }

    for (CanonicalType p : tm.getTargetProfile()) {
      if (!hasParam(tr, p.asStringValue())) {
        removed.add(trimNS(p.asStringValue()));
      }
    }

    if (!added.isEmpty())
      bp.append("Type " + tr.getWorkingCode() + ": Added Target " + Utilities.pluralize("Type", added.size()) + " " + csv(added));
    if (!removed.isEmpty())
      bp.append("Type " + tr.getWorkingCode() + ": Removed Target " + Utilities.pluralize("Type", removed.size()) + " " + csv(removed));
  }

  private String trimNS(String v) {
    if (v.startsWith("http://hl7.org/fhir/StructureDefinition/"))
      return v.substring(40);
    return v;
  }

  private String csv(List<String> list) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (String s : list)
      b.append(s);
    return b.toString();
  }

  private boolean hasParam(TypeRefComponent tm, String s) {
    for (CanonicalType t : tm.getTargetProfile())
      if (s.equals(t.asStringValue()))
        return true;
    return false;
  }

  private boolean isAbstractType(String code) {
    return Utilities.existsInList(code, "Element", "BackboneElement");
  }

  private boolean hasType(List<TypeRefComponent> types, TypeRefComponent tr) {
    for (TypeRefComponent t : types) {
      if (t.getWorkingCode().equals(tr.getWorkingCode())) {
        if ((!t.hasProfile() && !tr.hasProfile())) {
          return true;
        }
        boolean found = true;
        for (CanonicalType t1 : tr.getProfile()) {
          boolean ok = false;
          for (CanonicalType t2 : t.getProfile()) {
            ok = ok || t2.getValue().equals(t1.getValue());
          }
          found = found && ok;
        }
        return found;
      }
    }
    return false;
  }

  private TypeRefComponent getType(List<TypeRefComponent> types, TypeRefComponent tr) {
    for (TypeRefComponent t : types) {
      if (t.getWorkingCode().equals(tr.getWorkingCode())) {
        return t;
      }
    }
    return null;
  }

  private String describeType(TypeRefComponent tr) {
    if (!tr.hasProfile() && !tr.hasTargetProfile())
      return tr.getWorkingCode();
    else if (Utilities.existsInList(tr.getWorkingCode(), "Reference", "canonical")) {
      StringBuilder b = new StringBuilder(tr.getWorkingCode());
      b.append("(");
      boolean first = true;
      for (UriType u : tr.getTargetProfile()) {
        if (first)
          first = false;
        else
          b.append(" | ");
        if (u.getValue().startsWith("http://hl7.org/fhir/StructureDefinition/"))
          b.append(u.getValue().substring(40));
        else
          b.append(u.getValue());
      }
      b.append(")");
      return b.toString();
    } else {
      StringBuilder b = new StringBuilder(tr.getWorkingCode());
      if (tr.getProfile().size() > 0) {
        b.append("(");
        boolean first = true;
        for (UriType u : tr.getProfile()) {
          if (first)
            first = false;
          else
            b.append(" | ");
          b.append(u.getValue());
        }
        b.append(")");
      }
      return b.toString();
    }
  }

  public void saveR4AsR5(ZipGenerator zip, FhirFormat fmt) throws IOException {
    for (StructureDefinition t : original.getTypes().values())
      saveResource(zip, t, fmt);
    for (StructureDefinition t : original.getResources().values())
      saveResource(zip, t, fmt);
    for (StructureDefinition t : original.getProfiles().values())
      saveResource(zip, t, fmt);
    for (StructureDefinition t : original.getExtensions().values())
      saveResource(zip, t, fmt);
    for (ValueSet t : original.getValuesets().values())
      saveResource(zip, t, fmt);
    for (ValueSet t : original.getExpansions().values())
      saveResource(zip, t, fmt);
  }

  private void saveResource(ZipGenerator zip, Resource t, FhirFormat fmt) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    if (fmt == FhirFormat.JSON)
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(bs, t);
    else
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(bs, t);
    zip.addBytes(t.fhirType() + "-" + t.getId() + "." + fmt.getExtension(), bs.toByteArray(), true);
  }

  private void compareJson(JsonObject type, StructureDefinition orig, StructureDefinition rev) {
    JsonObject elements = new JsonObject();
    // first, we must match revision elements to old elements
    boolean changed = false;
    if (!orig.getName().equals(rev.getName())) {
      changed = true;
      type.addProperty("old-name", orig.getName());
    }
    for (ElementDefinition ed : rev.getDifferential().getElement()) {
      ElementDefinition oed = getMatchingElement(rev.getName(), orig.getDifferential().getElement(), ed);
      if (oed != null) {
        ed.setUserData("match", oed);
        oed.setUserData("match", ed);
      }
    }

    for (ElementDefinition ed : rev.getDifferential().getElement()) {
      ElementDefinition oed = (ElementDefinition) ed.getUserData("match");
      if (oed == null) {
        changed = true;
        JsonObject element = new JsonObject();
        elements.add(ed.getPath(), element);
        element.addProperty("status", "new");
      } else
        changed = compareElementJson(elements, ed, oed) || changed;
    }

    List<String> dels = new ArrayList<String>();

    for (ElementDefinition ed : orig.getDifferential().getElement()) {
      if (ed.getUserData("match") == null) {
        changed = true;
        boolean marked = false;
        for (String s : dels)
          if (ed.getPath().startsWith(s + "."))
            marked = true;
        if (!marked) {
          dels.add(ed.getPath());
          JsonObject element = new JsonObject();
          elements.add(ed.getPath(), element);
          element.addProperty("status", "deleted");
        }
      }
    }

    if (elements.entrySet().size() > 0)
      type.add("elements", elements);

    if (changed)
      type.addProperty("status", "changed");
    else
      type.addProperty("status", "no-change");

    for (ElementDefinition ed : rev.getDifferential().getElement())
      ed.clearUserData("match");
    for (ElementDefinition ed : orig.getDifferential().getElement())
      ed.clearUserData("match");

  }

  private void compareXml(Document doc, Element type, StructureDefinition orig, StructureDefinition rev) {
    // first, we must match revision elements to old elements
    boolean changed = false;
    if (!orig.getName().equals(rev.getName())) {
      changed = true;
      type.setAttribute("old-name", orig.getName());
    }
    for (ElementDefinition ed : rev.getDifferential().getElement()) {
      ElementDefinition oed = getMatchingElement(rev.getName(), orig.getDifferential().getElement(), ed);
      if (oed != null) {
        ed.setUserData("match", oed);
        oed.setUserData("match", ed);
      }
    }

    for (ElementDefinition ed : rev.getDifferential().getElement()) {
      ElementDefinition oed = (ElementDefinition) ed.getUserData("match");
      if (oed == null) {
        changed = true;
        Element element = doc.createElement("element");
        element.setAttribute("path", ed.getPath());
        type.appendChild(element);
        element.setAttribute("status", "new");
      } else
        changed = compareElementXml(doc, type, ed, oed) || changed;
    }

    List<String> dels = new ArrayList<String>();

    for (ElementDefinition ed : orig.getDifferential().getElement()) {
      if (ed.getUserData("match") == null) {
        changed = true;
        boolean marked = false;
        for (String s : dels)
          if (ed.getPath().startsWith(s + "."))
            marked = true;
        if (!marked) {
          dels.add(ed.getPath());
          Element element = doc.createElement("element");
          element.setAttribute("path", ed.getPath());
          type.appendChild(element);
          element.setAttribute("status", "deleted");
        }
      }
    }

    if (changed)
      type.setAttribute("status", "changed");
    else
      type.setAttribute("status", "no-change");

    for (ElementDefinition ed : rev.getDifferential().getElement())
      ed.clearUserData("match");
    for (ElementDefinition ed : orig.getDifferential().getElement())
      ed.clearUserData("match");

  }

  private boolean compareElementJson(JsonObject elements, ElementDefinition rev, ElementDefinition orig) {
    JsonObject element = new JsonObject();

    String rn = tail(rev.getPath());
    String on = tail(orig.getPath());

    if (!rn.equals(on) && rev.getPath().contains("."))
      element.addProperty("old-name", on);

    if (rev.getMin() != orig.getMin()) {
      element.addProperty("old-min", orig.getMin());
      element.addProperty("new-min", rev.getMin());
    }

    if (!rev.getMax().equals(orig.getMax())) {
      element.addProperty("old-max", orig.getMax());
      element.addProperty("new-max", rev.getMax());
    }

    analyseTypes(element, rev, orig);

    if (hasBindingToNote(rev) || hasBindingToNote(orig)) {
      compareBindings(element, rev, orig);
    }

    if (rev.hasDefaultValue() || orig.hasDefaultValue()) {
      boolean changed = true;
      if (!rev.hasDefaultValue())
        element.addProperty("default", "removed");
      else if (!orig.hasDefaultValue())
        element.addProperty("default", "added");
      else {
        String s1 = describeValue(orig.getDefaultValue());
        String s2 = describeValue(rev.getDefaultValue());
        if (!s1.equals(s2))
          element.addProperty("default", "changed");
        else
          changed = false;
      }
      if (changed) {
        if (orig.hasDefaultValue())
          element.addProperty("old-default", describeValue(orig.getDefaultValue()));
        if (rev.hasDefaultValue())
          element.addProperty("new-default", describeValue(rev.getDefaultValue()));
      }
    }

    if (rev.getIsModifier() != orig.getIsModifier()) {
      if (rev.getIsModifier())
        element.addProperty("modifier", "added");
      else
        element.addProperty("modifier", "removed");
    }

    if (element.entrySet().isEmpty())
      return false;
    else {
      elements.add(rev.getPath(), element);
      return true;
    }
  }

  private boolean compareElementXml(Document doc, Element type, ElementDefinition rev, ElementDefinition orig) {
    Element element = doc.createElement("element");

    String rn = tail(rev.getPath());
    String on = tail(orig.getPath());

    if (!rn.equals(on) && rev.getPath().contains("."))
      element.setAttribute("old-name", on);

    if (rev.getMin() != orig.getMin()) {
      element.setAttribute("old-min", Integer.toString(orig.getMin()));
      element.setAttribute("new-min", Integer.toString(rev.getMin()));
    }

    if (!rev.getMax().equals(orig.getMax())) {
      element.setAttribute("old-max", orig.getMax());
      element.setAttribute("new-max", rev.getMax());
    }

    analyseTypes(doc, element, rev, orig);

    if (hasBindingToNote(rev) || hasBindingToNote(orig)) {
      compareBindings(doc, element, rev, orig);
    }

    if (rev.hasDefaultValue() || orig.hasDefaultValue()) {
      boolean changed = true;
      if (!rev.hasDefaultValue())
        element.setAttribute("default", "removed");
      else if (!orig.hasDefaultValue())
        element.setAttribute("default", "added");
      else {
        String s1 = describeValue(orig.getDefaultValue());
        String s2 = describeValue(rev.getDefaultValue());
        if (!s1.equals(s2))
          element.setAttribute("default", "changed");
        else
          changed = false;
      }
      if (changed) {
        if (orig.hasDefaultValue())
          element.setAttribute("old-default", describeValue(orig.getDefaultValue()));
        if (rev.hasDefaultValue())
          element.setAttribute("new-default", describeValue(rev.getDefaultValue()));
      }
    }

    if (rev.getIsModifier() != orig.getIsModifier()) {
      if (rev.getIsModifier())
        element.setAttribute("modifier", "added");
      else
        element.setAttribute("modifier", "removed");
    }

    if (element.getAttributes().getLength() == 0 && element.getChildNodes().getLength() == 0)
      return false;
    else {
      element.setAttribute("path", rev.getPath());
      type.appendChild(element);
      return true;
    }
  }

  private void analyseTypes(JsonObject element, ElementDefinition rev, ElementDefinition orig) {
    JsonArray oa = new JsonArray();
    JsonArray ra = new JsonArray();

    if (rev.getType().size() == 1 && orig.getType().size() == 1) {
      String r = describeType(rev.getType().get(0));
      if (Utilities.noString(r) && Utilities.existsInList(rev.getId(), "Element.id", "Extension.url"))
        r = "string";
      String o = describeType(orig.getType().get(0));
      if (Utilities.noString(o) && Utilities.existsInList(orig.getId(), "Element.id", "Extension.url"))
        o = "string";
      if (!o.equals(r)) {
        oa.add(new JsonPrimitive(o));
        ra.add(new JsonPrimitive(r));
      }
    } else {
      for (TypeRefComponent tr : orig.getType()) {
        if (!hasType(rev.getType(), tr))
          oa.add(new JsonPrimitive(describeType(tr)));
      }
      for (TypeRefComponent tr : rev.getType()) {
        if (!hasType(orig.getType(), tr) && !isAbstractType(tr.getWorkingCode()))
          ra.add(new JsonPrimitive(describeType(tr)));
      }
      for (TypeRefComponent tr : rev.getType()) {
        TypeRefComponent tm = getType(rev.getType(), tr);
        if (tm != null) {
          compareParameters(element, tr, tm);
        }
      }

    }
    if (oa.size() > 0)
      element.add("removed-types", oa);
    if (ra.size() > 0)
      element.add("added-types", ra);
  }

  private void compareParameters(JsonObject element, TypeRefComponent tr, TypeRefComponent tm) {
    JsonArray added = new JsonArray();
    JsonArray removed = new JsonArray();

    for (CanonicalType p : tr.getTargetProfile()) {
      if (!hasParam(tm, p.asStringValue())) {
        added.add(new JsonPrimitive(p.asStringValue()));
      }
    }

    for (CanonicalType p : tm.getTargetProfile()) {
      if (!hasParam(tr, p.asStringValue())) {
        removed.add(new JsonPrimitive(p.asStringValue()));
      }
    }

    if (added.size() > 0)
      element.add(tr.getWorkingCode() + "-target-added", added);
    if (removed.size() > 0)
      element.add(tr.getWorkingCode() + "-target-removed", removed);
  }

  private void analyseTypes(Document doc, Element element, ElementDefinition rev, ElementDefinition orig) {
    if (rev.getType().size() == 1 && orig.getType().size() == 1) {
      String r = describeType(rev.getType().get(0));
      if (Utilities.noString(r) && Utilities.existsInList(rev.getId(), "Element.id", "Extension.url"))
        r = "string";
      String o = describeType(orig.getType().get(0));
      if (Utilities.noString(o) && Utilities.existsInList(orig.getId(), "Element.id", "Extension.url"))
        o = "string";
      if (!o.equals(r)) {
        element.appendChild(makeElementWithAttribute(doc, "removed-type", "name", o));
        element.appendChild(makeElementWithAttribute(doc, "added-type", "name", r));
      }
    } else {
      for (TypeRefComponent tr : orig.getType()) {
        if (!hasType(rev.getType(), tr))
          element.appendChild(makeElementWithAttribute(doc, "removed-type", "name", describeType(tr)));
      }
      for (TypeRefComponent tr : rev.getType()) {
        if (!hasType(orig.getType(), tr) && !isAbstractType(tr.getWorkingCode()))
          element.appendChild(makeElementWithAttribute(doc, "added-type", "name", describeType(tr)));
      }
      for (TypeRefComponent tr : rev.getType()) {
        TypeRefComponent tm = getType(rev.getType(), tr);
        if (tm != null) {
          compareParameters(doc, element, tr, tm);
        }
      }
    }
  }

  private void compareParameters(Document doc, Element element, TypeRefComponent tr, TypeRefComponent tm) {

    for (CanonicalType p : tr.getTargetProfile()) {
      if (!hasParam(tm, p.asStringValue())) {
        element.appendChild(makeElementWithAttribute(doc, tr.getWorkingCode() + "-target-added", "name", p.asStringValue()));
      }
    }

    for (CanonicalType p : tm.getTargetProfile()) {
      if (!hasParam(tr, p.asStringValue())) {
        element.appendChild(makeElementWithAttribute(doc, tr.getWorkingCode() + "-target-removed", "name", p.asStringValue()));
      }
    }
  }

  private Node makeElementWithAttribute(Document doc, String name, String aname, String content) {
    Element e = doc.createElement(name);
    e.setAttribute(aname, content);
    return e;
  }

  private void compareBindings(JsonObject element, ElementDefinition rev, ElementDefinition orig) {
    if (!hasBindingToNote(rev)) {
      element.addProperty("binding-status", "removed");
      describeBinding(element, "old-binding", orig);
    } else if (!hasBindingToNote(orig)) {
      element.addProperty("binding-status", "added");
      describeBinding(element, "new-binding", rev);
    } else if (compareBindings(element, rev.getBinding(), orig.getBinding())) {
      element.addProperty("binding-status", "changed");
      describeBinding(element, "old-binding", orig);
      describeBinding(element, "new-binding", rev);
    }
  }

  private boolean compareBindings(JsonObject element, ElementDefinitionBindingComponent rev, ElementDefinitionBindingComponent orig) {
    boolean res = false;
    if (rev.getStrength() != orig.getStrength()) {
      element.addProperty("binding-strength-changed", true);
      res = true;
    }
    if (!Base.compareDeep(rev.getValueSet(), orig.getValueSet(), false)) {
      element.addProperty("binding-valueset-changed", true);
      res = true;
    }
    if (!maxValueSetsMatch(rev, orig)) {
      element.addProperty("max-valueset-changed", true);
      res = true;
    }

    if (rev.getStrength() == BindingStrength.REQUIRED && orig.getStrength() == BindingStrength.REQUIRED) {
      JsonArray oa = new JsonArray();
      JsonArray ra = new JsonArray();
      ValueSet vrev = getValueSet(rev.getValueSet(), revision.getExpansions());
      ValueSet vorig = getValueSet(rev.getValueSet(), original.getExpansions());
      if (vrev != null && vorig != null) {
        for (ValueSetExpansionContainsComponent cc : vorig.getExpansion().getContains()) {
          if (!hasCode(vrev, cc))
            oa.add(new JsonPrimitive(cc.getCode()));
        }
        for (ValueSetExpansionContainsComponent cc : vrev.getExpansion().getContains()) {
          if (!hasCode(vorig, cc))
            ra.add(new JsonPrimitive(cc.getCode()));
        }
      }
      if (oa.size() > 0 || ra.size() > 0) {
        element.addProperty("binding-codes-changed", true);
        res = true;
      }
      if (oa.size() > 0)
        element.add("removed-codes", oa);
      if (ra.size() > 0)
        element.add("added-codes", ra);
    }
    return res;
  }

  private boolean hasCode(ValueSet vs, ValueSetExpansionContainsComponent cc) {
    for (ValueSetExpansionContainsComponent ct : vs.getExpansion().getContains()) {
      if (ct.getSystem().equals(cc.getSystem()) && ct.getCode().equals(cc.getCode()))
        return true;
    }
    return false;
  }

  private void compareBindings(Document doc, Element element, ElementDefinition rev, ElementDefinition orig) {
    if (!hasBindingToNote(rev)) {
      element.setAttribute("binding-status", "removed");
      describeBinding(doc, element, "old-binding", orig);
    } else if (!hasBindingToNote(orig)) {
      element.setAttribute("binding-status", "added");
      describeBinding(doc, element, "new-binding", rev);
    } else if (compareBindings(doc, element, rev.getBinding(), orig.getBinding())) {
      element.setAttribute("binding-status", "changed");
      describeBinding(doc, element, "old-binding", orig);
      describeBinding(doc, element, "new-binding", rev);
    }
  }

  private boolean compareBindings(Document doc, Element element, ElementDefinitionBindingComponent rev, ElementDefinitionBindingComponent orig) {
    boolean res = false;
    if (rev.getStrength() != orig.getStrength()) {
      element.setAttribute("binding-strength-changed", "true");
      res = true;
    }
    if (!Base.compareDeep(rev.getValueSet(), orig.getValueSet(), false)) {
      element.setAttribute("binding-valueset-changed", "true");
      res = true;
    }
    if (!maxValueSetsMatch(rev, orig)) {
      element.setAttribute("max-valueset-changed", "true");
      res = true;
    }
    if (rev.getStrength() == BindingStrength.REQUIRED && orig.getStrength() == BindingStrength.REQUIRED) {
      ValueSet vrev = getValueSet(rev.getValueSet(), revision.getExpansions());
      ValueSet vorig = getValueSet(rev.getValueSet(), original.getExpansions());
      boolean changed = false;
      if (vrev != null && vorig != null) {
        for (ValueSetExpansionContainsComponent cc : vorig.getExpansion().getContains()) {
          if (!hasCode(vrev, cc)) {
            element.appendChild(makeElementWithAttribute(doc, "removed-code", "code", cc.getCode()));
            changed = true;
          }
        }
        for (ValueSetExpansionContainsComponent cc : vrev.getExpansion().getContains()) {
          if (!hasCode(vorig, cc)) {
            element.appendChild(makeElementWithAttribute(doc, "added-code", "code", cc.getCode()));
            changed = true;
          }
        }
      }
      if (changed) {
        element.setAttribute("binding-codes-changed", "true");
        res = true;
      }
    }
    return res;
  }
}