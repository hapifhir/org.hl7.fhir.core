package org.hl7.fhir.r5.comparison;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.comparison.ProfileComparer.ProfileComparison;
import org.hl7.fhir.r5.comparison.ResourceComparer.ResourceComparison;
import org.hl7.fhir.r5.comparison.ValueSetComparer.ValueSetComparison;

import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.Tuple;

import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.utils.LiquidEngine;
import org.hl7.fhir.r5.utils.LiquidEngine.LiquidDocument;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;

public class ComparisonRenderer implements IEvaluationContext {

  private IWorkerContext context;
  private ComparisonSession session;
  private Map<String, String> templates = new HashMap<>();
  private String folder;

  public ComparisonRenderer(IWorkerContext context, String folder, ComparisonSession session) {
    super();
    this.context = context;       
    this.folder = folder;
    this.session = session;
  }

  public Map<String, String> getTemplates() {
    return templates;
  }
  
  public void render() throws IOException {
    dumpBinaries();
    StringBuilder b = new StringBuilder();
    
    for (String id : sorted(session.getCompares().keySet())) {
      ResourceComparison comp = session.getCompares().get(id);
      renderComparison(id, comp);
      b.append("<li><a href=\""+comp.getId()+".html\">"+Utilities.escapeXml(comp.summary())+"</a></li>\r\n");      
    }
    Map<String, Base> vars = new HashMap<>();
    CodeSystemComparer cs = new CodeSystemComparer(session);
    vars.put("title", new StringType(session.getTitle()));
    vars.put("list", new StringType(b.toString()));
    String template = templates.get("Index");
    String cnt = processTemplate(template, "CodeSystem", vars);
    TextFile.stringToFile(cnt, file("index.html"));
  }

  private List<String> sorted(Set<String> keySet) {
    List<String> list = new ArrayList<>();
    list.addAll(keySet);
    Collections.sort(list);
    return list;
  }

  private void dumpBinaries() throws IOException {
    for (String k : context.getBinaries().keySet()) {
      TextFile.bytesToFile(context.getBinaries().get(k), Utilities.path(folder, k));
    }
  }

  private void renderComparison(String id, ResourceComparison comp) throws IOException {    
    if (comp instanceof ProfileComparison) {
      renderProfile(id, (ProfileComparison) comp);
    } else if (comp instanceof ValueSetComparison) {
      renderValueSet(id, (ValueSetComparison) comp);
    } else if (comp instanceof CodeSystemComparison) {
      renderCodeSystem(id, (CodeSystemComparison) comp);
    }   
  }

  private void renderCodeSystem(String id, CodeSystemComparison comp) throws IOException {  
    String template = templates.get("CodeSystem");
    Map<String, Base> vars = new HashMap<>();
    CodeSystemComparer cs = new CodeSystemComparer(session);
    vars.put("left", new StringType(comp.getLeft().present()));
    vars.put("right", new StringType(comp.getRight().present()));
    vars.put("leftId", new StringType(comp.getLeft().getId()));
    vars.put("rightId", new StringType(comp.getRight().getId()));
    vars.put("leftUrl", new StringType(comp.getLeft().getUrl()));
    vars.put("rightUrl", new StringType(comp.getRight().getUrl()));
    vars.put("errors", new StringType(new XhtmlComposer(true).compose(cs.renderErrors(comp))));
    vars.put("metadata", new StringType(new XhtmlComposer(true).compose(cs.renderMetadata(comp, "", ""))));
    vars.put("concepts", new StringType(new XhtmlComposer(true).compose(cs.renderConcepts(comp, "", ""))));
    String cnt = processTemplate(template, "CodeSystem", vars);
    TextFile.stringToFile(cnt, file(comp.getId()+".html"));
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", comp.getId() + "-union.json")), comp.getUnion());
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", comp.getId() + "-intersection.json")), comp.getIntersection());
  }

  private String file(String name) throws IOException {
    return Utilities.path(folder, name);
  }

  private void renderValueSet(String id, ValueSetComparison comp) throws FHIRException, IOException {
    String template = templates.get("ValueSet");
    Map<String, Base> vars = new HashMap<>();
    ValueSetComparer cs = new ValueSetComparer(session);
    vars.put("left", new StringType(comp.getLeft().present()));
    vars.put("right", new StringType(comp.getRight().present()));
    vars.put("leftId", new StringType(comp.getLeft().getId()));
    vars.put("rightId", new StringType(comp.getRight().getId()));
    vars.put("leftUrl", new StringType(comp.getLeft().getUrl()));
    vars.put("rightUrl", new StringType(comp.getRight().getUrl()));
    vars.put("errors", new StringType(new XhtmlComposer(true).compose(cs.renderErrors(comp))));
    vars.put("metadata", new StringType(new XhtmlComposer(true).compose(cs.renderMetadata(comp, "", ""))));
    vars.put("compose", new StringType(new XhtmlComposer(true).compose(cs.renderCompose(comp, "", ""))));
    vars.put("expansion", new StringType(new XhtmlComposer(true).compose(cs.renderExpansion(comp, "", ""))));
    String cnt = processTemplate(template, "ValueSet", vars);
    TextFile.stringToFile(cnt, file(comp.getId()+".html"));
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", comp.getId() + "-union.json")), comp.getUnion());
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", comp.getId() + "-intersection.json")), comp.getIntersection());
  }

  private void renderProfile(String id, ProfileComparison comp) throws IOException {
    String template = templates.get("Profile");
    Map<String, Base> vars = new HashMap<>();
    ProfileComparer cs = new ProfileComparer(session, new ProfileUtilities(session.getContext(), null, session.getPkp()));
    vars.put("left", new StringType(comp.getLeft().present()));
    vars.put("right", new StringType(comp.getRight().present()));
    vars.put("leftId", new StringType(comp.getLeft().getId()));
    vars.put("rightId", new StringType(comp.getRight().getId()));
    vars.put("leftUrl", new StringType(comp.getLeft().getUrl()));
    vars.put("rightUrl", new StringType(comp.getRight().getUrl()));
    vars.put("errors", new StringType(new XhtmlComposer(true).compose(cs.renderErrors(comp))));
    vars.put("metadata", new StringType(new XhtmlComposer(true).compose(cs.renderMetadata(comp, "", ""))));
    vars.put("structure", new StringType(new XhtmlComposer(true).compose(cs.renderStructure(comp, "", "", "http://hl7.org/fhir"))));
    String cnt = processTemplate(template, "CodeSystem", vars);
    TextFile.stringToFile(cnt, file(comp.getId()+".html"));
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", comp.getId() + "-union.json")), comp.getUnion());
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", comp.getId() + "-intersection.json")), comp.getIntersection());
  }

  private String processTemplate(String template, String name, Map<String, Base> vars) {
    LiquidEngine engine = new LiquidEngine(context, this);
    LiquidDocument doc = engine.parse(template, name+".template");
    return engine.evaluate(doc, Tuple.fromMap(vars), vars);
  }

  @Override
  public Base resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
    @SuppressWarnings("unchecked")
    Map<String, Base> vars = (Map<String, Base>) appContext;
    return vars.get(name);
  }

  @Override
  public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {
    @SuppressWarnings("unchecked")
    Map<String, Base> vars = (Map<String, Base>) appContext;
    Base b = vars.get(name);
    return new TypeDetails(CollectionStatus.SINGLETON, b == null ? "Base" : b.fhirType());
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    return false;
  }

  @Override
  public FunctionDetails resolveFunction(String functionName) {
    return null;
  }

  @Override
  public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
    return null;
  }

  @Override
  public List<Base> executeFunction(Object appContext, String functionName, List<List<Base>> parameters) {
    return null;
  }

  @Override
  public Base resolveReference(Object appContext, String url, Base refContext) throws FHIRException {
    return null;
  }

  @Override
  public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
    return false;
  }

  @Override
  public ValueSet resolveValueSet(Object appContext, String url) {
    return null;
  }

}
