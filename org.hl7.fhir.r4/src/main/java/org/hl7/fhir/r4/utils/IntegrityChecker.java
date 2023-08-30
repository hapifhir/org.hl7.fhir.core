package org.hl7.fhir.r4.utils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.SearchParameter;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r4.utils.IntegrityChecker.SearchParameterNode;
import org.hl7.fhir.r4.utils.IntegrityChecker.SearchParameterNodeSorter;
import org.hl7.fhir.r4.utils.IntegrityChecker.SearchParameterParamNode;
import org.hl7.fhir.r4.utils.IntegrityChecker.SearchParameterParamNodeSorter;
import org.hl7.fhir.r4.utils.IntegrityChecker.StructureDefinitionNode;
import org.hl7.fhir.r4.utils.IntegrityChecker.StructureDefinitionNodeComparer;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class IntegrityChecker {

  public class SearchParameterNodeSorter implements Comparator<SearchParameterNode> {

    @Override
    public int compare(SearchParameterNode o1, SearchParameterNode o2) {
      return o1.name.compareTo(o2.name);
    }

  }

  public class SearchParameterParamNodeSorter implements Comparator<SearchParameterParamNode> {

    @Override
    public int compare(SearchParameterParamNode o1, SearchParameterParamNode o2) {
       return o1.sp.getCode().compareTo(o2.sp.getCode());
    }

  }

  public class SearchParameterParamNode {
    SearchParameter sp;
    boolean only;
    public SearchParameterParamNode(SearchParameter sp, boolean only) {
      super();
      this.sp = sp;
      this.only = only;
    }
    

  }

  public class SearchParameterNode {

    private String name;
    private List<SearchParameterParamNode> params = new ArrayList<>();

    public SearchParameterNode(String name) {
      this.name = name;
    }

  }

  public class StructureDefinitionNodeComparer implements Comparator<StructureDefinitionNode> {

    @Override
    public int compare(StructureDefinitionNode arg0, StructureDefinitionNode arg1) {
      if ( arg0.sd.getType().equals(arg1.sd.getType())) {
        return arg0.sd.getName().compareTo(arg1.sd.getName());        
      } else {
        return arg0.sd.getType().compareTo(arg1.sd.getType());
      }
    }

  }

  public class StructureDefinitionNode {
    StructureDefinition sd;
    List<StructureDefinitionNode> children = new ArrayList<>();
    
    public StructureDefinitionNode(StructureDefinition sd) {
      this.sd = sd;
    }

  }

  private NpmPackage npm;

  public static void main(String[] args) throws Exception {
    IntegrityChecker check = new IntegrityChecker();
    check.load(args[0]);
    check.check();
  }

  private void check() throws IOException {
    dumpSD(new FileWriter("/Users/grahamegrieve/temp/r4-dump.txt"));
//    checkSD();
//    checkSP();
  }
  


  private void dumpSD(FileWriter w) throws FHIRFormatError, IOException {
    Map<String, StructureDefinition> map = new HashMap<>();
    for (String sdn : npm.listResources("StructureDefinition")) {
      InputStream s = npm.load(sdn);
      StructureDefinition sd = (StructureDefinition) new JsonParser().parse(s);
      map.put(sd.getUrl(), sd);
    }
    msg("Loaded "+map.size()+" Structures");
    List<String> structures = new ArrayList<>();
    for (StructureDefinition sd : map.values()) {
      structures.add(sd.getUrl());
    }
    Collections.sort(structures);
    
    for (String sdn : structures) {
      dumpSD(map.get(sdn), map, w);
    }
  }

  private void dumpSD(StructureDefinition sd, Map<String, StructureDefinition> map, FileWriter w) throws IOException {
    if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
      StructureDefinition base = sd.hasBaseDefinition() ? map.get(sd.getBaseDefinition()) : null;
      System.out.println(sd.getType()+(base == null ? "" : " : "+base.getType()));
      w.append(sd.getType()+(base == null ? "" : " : "+base.getType())+"\r\n");
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        w.append("  "+Utilities.padLeft("", ' ', Utilities.charCount(ed.getPath(), '.'))+tail(ed.getPath())+" : "+ed.typeSummary()+" ["+ed.getMin()+".."+ed.getMax()+"]"+"\r\n");
      }
    }
  }
  
  private String tail(String path) {
    return path.contains(".") ? path.substring(path.lastIndexOf('.')+1) : path;
  }
  
  private void checkSP() throws IOException {
    List<SearchParameter> list =  new ArrayList<>();
    for (String sdn : npm.listResources("SearchParameter")) {
      InputStream s = npm.load(sdn);
      SearchParameter sp = (SearchParameter) new JsonParser().parse(s);
      list.add(sp);
    }
    msg("Loaded "+list.size()+" resources");
    Map<String, SearchParameterNode> map = new HashMap<>();
    for (SearchParameter sp : list) {
      for (CodeType c : sp.getBase()) {
        String s = c.primitiveValue();
        if (!map.containsKey(s)) {
          map.put(s, new SearchParameterNode(s));
        }
        addNode(sp, sp.getBase().size() == 1, map.get(s));
      }
    }   
    for (SearchParameterNode node : sort(map.values())) {
      dump(node);
    }
  }


  private void dump(SearchParameterNode node) {
    msg(node.name);
    for (SearchParameterParamNode p : sortP(node.params)) {
      String exp = p.sp.getExperimental() ? "  **exp!" : "";
      if (p.only) {
        msg("  "+p.sp.getCode()+exp);
      } else {        
        msg("  *"+p.sp.getCode()+exp);
      }
    }
    
  }

  private List<SearchParameterParamNode> sortP(List<SearchParameterParamNode> params) {
    List<SearchParameterParamNode> res = new ArrayList<>();
    res.addAll(params);
    Collections.sort(res, new SearchParameterParamNodeSorter());
    return res;
  }

  private List<SearchParameterNode> sort(Collection<SearchParameterNode> values) {
    List<SearchParameterNode> res = new ArrayList<>();
    res.addAll(values);
    Collections.sort(res, new SearchParameterNodeSorter());
    return res;
  }

  private void addNode(SearchParameter sp, boolean b, SearchParameterNode node) {
    node.params.add(new SearchParameterParamNode(sp, b));   
  }

  private void checkSD() throws IOException {
    Map<String, StructureDefinition> map = new HashMap<>();
    for (String sdn : npm.listResources("StructureDefinition")) {
      InputStream s = npm.load(sdn);
      StructureDefinition sd = (StructureDefinition) new JsonParser().parse(s);
      map.put(sd.getUrl(), sd);
    }
    msg("Loaded "+map.size()+" resources");
    List<StructureDefinitionNode> roots = new ArrayList<>();
    for (StructureDefinition sd : map.values()) {
      if (sd.getBaseDefinition() == null || !map.containsKey(sd.getBaseDefinition())) {
        StructureDefinitionNode root = new StructureDefinitionNode(sd);
        roots.add(root);
        analyse(root, map);
      }
    }
    sort(roots);
    for (StructureDefinitionNode root : roots) {
      describe(root, 0);
    }
  }

  private void sort(List<StructureDefinitionNode> list) {
    Collections.sort(list, new StructureDefinitionNodeComparer());
    
  }

  private void analyse(StructureDefinitionNode node, Map<String, StructureDefinition> map) {
    for (StructureDefinition sd : map.values()) {
      if (node.sd.getUrl().equals(sd.getBaseDefinition())) {
        StructureDefinitionNode c = new StructureDefinitionNode(sd);
        node.children.add(c);
        analyse(c, map);
      }
    }
    sort(node.children);
  }

  private void describe(StructureDefinitionNode node, int level) {
    describe(node.sd, level);
    for (StructureDefinitionNode c : node.children) {
      describe(c, level+1);
    }
  }

  private void describe(StructureDefinition sd, int level) {
    String exp = sd.getExperimental() ? "  **exp!" : "";
    if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
      msg(Utilities.padLeft("", ' ', level)+sd.getType()+" / "+sd.getName()+" ("+sd.getUrl()+")"+exp);      
    } else {
      msg(Utilities.padLeft("", ' ', level)+sd.getType()+" : "+sd.getKind()+exp);
    }
  }

//  private int analyse(Map<String, StructureDefinition> map, List<StructureDefinition> list, StructureDefinition sd) {
//    if (!list.contains(sd)) {
//      int level = 0;
//      if (sd.hasBaseDefinition()) {
//        StructureDefinition p = map.get(sd.getBaseDefinition());
//        if (p == null) {
//          msg("Can't find parent "+sd.getBaseDefinition()+" for "+sd.getUrl());
//        } else {
//          level = analyse(map, list, p) + 1;
//        }
//      }
//      list.add(sd);
//      sd.setUserData("level", level);
//    }
//  }

  private void msg(String string) {
    System.out.println(string);    
  }

  private void load(String folder) throws IOException {
    msg("Loading resources from "+folder);
    npm = NpmPackage.fromFolder(folder);
  }
}
