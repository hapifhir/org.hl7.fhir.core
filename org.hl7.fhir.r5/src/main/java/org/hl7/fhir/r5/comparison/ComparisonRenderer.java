package org.hl7.fhir.r5.comparison;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.comparison.CapabilityStatementComparer.CapabilityStatementComparison;
import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.comparison.ResourceComparer.PlaceHolderComparison;
import org.hl7.fhir.r5.comparison.ResourceComparer.ResourceComparison;
import org.hl7.fhir.r5.comparison.StructureDefinitionComparer.ProfileComparison;
import org.hl7.fhir.r5.comparison.ValueSetComparer.ValueSetComparison;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.IHostApplicationServices;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.liquid.LiquidEngine;
import org.hl7.fhir.r5.liquid.LiquidEngine.LiquidDocument;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.Tuple;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;

@MarkedToMoveToAdjunctPackage
@Slf4j
public class ComparisonRenderer implements IHostApplicationServices {

  private IWorkerContext contextLeft;
  private IWorkerContext contextRight;
  private ComparisonSession session;
  private Map<String, String> templates = new HashMap<>();
  private String folder;
  private String preamble;

  public ComparisonRenderer(IWorkerContext contextLeft, IWorkerContext contextRight, String folder, ComparisonSession session) {
    super();
    this.contextLeft = contextLeft;       
    this.contextRight = contextRight;       
    this.folder = folder;
    this.session = session;
  }
  
  public String getPreamble() {
    return preamble;
  }

  public void setPreamble(String preamble) {
    this.preamble = preamble;
  }

  public Map<String, String> getTemplates() {
    return templates;
  }
  
  public File render(String leftName, String rightName) throws IOException {
    dumpBinaries();
    StringBuilder b = new StringBuilder();
    if (preamble != null) {
      b.append(preamble);
    }
    b.append("<table class=\"grid\">\r\n");
    b.append(" <tr>\r\n");
    b.append("  <td width=\"260\"><b>"+Utilities.escapeXml(leftName)+"</b></td>\r\n");
    b.append("  <td width=\"260\"><b>"+Utilities.escapeXml(rightName)+"</b></td>\r\n");
    b.append("  <td width=\"100\"><b>Difference</b></td>\r\n");
    b.append("  <td width=\"100\"><b>Union</b></td>\r\n");
    b.append("  <td width=\"100\"><b>Intersection</b></td>\r\n");
    b.append("  <td width=\"260\"><b>Notes</b></td>\r\n");
    b.append(" </tr>\r\n");
    
    List<String> list = sorted(session.getCompares().keySet());
    processList(list, b, "CodeSystem");
    processList(list, b, "ValueSet");
    processList(list, b, "StructureDefinition");
    processList(list, b, "CapabilityStatement");
    b.append("</table>\r\n");

    Map<String, Base> vars = new HashMap<>();
    vars.put("title", new StringType(session.getTitle()));
    vars.put("list", new StringType(b.toString()));
    String template = templates.get("Index");
    String cnt = processTemplate(template, "CodeSystem", vars);
    FileUtilities.stringToFile(cnt, file("index.html"));
    return ManagedFileAccess.file(file("index.html"));
  }

  private void processList(List<String> list, StringBuilder b, String name) throws IOException {
    // TODO Auto-generated method stub
    boolean first = true;
    for (String id : list) {
      ResourceComparison comp = session.getCompares().get(id);
      if (comp.fhirType().equals(name)) {
        if (first) {
          first = false;
          b.append("<tr><td colspan=\"6\"><b>"+Utilities.pluralize(name, 2)+"</b></td></tr>\r\n");
        }
        try {
          renderComparison(id, comp);
        } catch (Exception e) {
          log.error("Exception rendering "+id+": "+e.getMessage(), e);
        }
        b.append(comp.toTable());
        //"<li><a href=\""+comp.getId()+".html\">"+Utilities.escapeXml(comp.summary())+"</a></li>\r\n"
      }
    }
  }

  private List<String> sorted(Set<String> keySet) {
    List<String> list = new ArrayList<>();
    list.addAll(keySet);
    Collections.sort(list);
    return list;
  }

  private void dumpBinaries() throws IOException {
    if (contextLeft != null && contextLeft.getBinaryKeysAsSet() != null) {
      for (String k : contextLeft.getBinaryKeysAsSet()) {
        FileUtilities.bytesToFile(contextLeft.getBinaryForKey(k), Utilities.path(folder, k));
      }
    }
    if (contextRight != null && contextRight.getBinaryKeysAsSet() != null) {
      for (String k : contextRight.getBinaryKeysAsSet()) {
        FileUtilities.bytesToFile(contextRight.getBinaryForKey(k), Utilities.path(folder, k));
      }
    }
  }

  private void renderComparison(String id, ResourceComparison comp) throws IOException, FHIRFormatError, DefinitionException, FHIRException, EOperationOutcome {    
    if (comp instanceof ProfileComparison) {
      renderProfile(id, (ProfileComparison) comp);
    } else if (comp instanceof ValueSetComparison) {
      renderValueSet(id, (ValueSetComparison) comp);
    } else if (comp instanceof CodeSystemComparison) {
      renderCodeSystem(id, (CodeSystemComparison) comp);
    } else if (comp instanceof CapabilityStatementComparison) {
      renderCapabilityStatement(id, (CapabilityStatementComparison) comp);
    } else if (comp instanceof PlaceHolderComparison) {
      renderPlaceHolder(id, (PlaceHolderComparison) comp);
    }   
  }

  private void renderPlaceHolder(String id, PlaceHolderComparison comp) throws IOException {  
    String cnt = "";
    if (comp.getE() != null) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      comp.getE().printStackTrace(pw);
      cnt = sw.toString();
    }    
    cnt = "<html><body><pre>"+cnt+"</pre></body></html>\r\n";
    FileUtilities.stringToFile(cnt, file(comp.getId()+".html"));
  }

  private void renderCodeSystem(String id, CodeSystemComparison comp) throws IOException, FHIRFormatError, DefinitionException, FHIRException, EOperationOutcome {  
    String template = templates.get("CodeSystem");
    Map<String, Base> vars = new HashMap<>();
    CodeSystemComparer cs = new CodeSystemComparer(session);
    vars.put("left", new StringType(comp.getLeft().present()));
    vars.put("right", new StringType(comp.getRight().present()));
    vars.put("leftId", new StringType(comp.getLeft().getId()));
    vars.put("rightId", new StringType(comp.getRight().getId()));
    vars.put("leftUrl", new StringType(comp.getLeft().getUrl()));
    vars.put("rightUrl", new StringType(comp.getRight().getUrl()));
    vars.put("summary", new StringType(comp.summary()));
    vars.put("errors", new StringType(new XhtmlComposer(true).compose(cs.renderErrors(comp))));
    vars.put("metadata", new StringType(new XhtmlComposer(true).compose(cs.renderMetadata(comp, "", ""))));
    vars.put("concepts", new StringType(new XhtmlComposer(true).compose(cs.renderConcepts(comp, "", ""))));

    String cnt = processTemplate(template, "CodeSystem", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+".html"));
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(folder, comp.getId() + "-union.json")), comp.getUnion());
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(folder, comp.getId() + "-intersection.json")), comp.getIntersection());

    String union = new XhtmlComposer(true).compose(cs.renderUnion(comp, "", folder, "http://hl7.org/fhir"));
    String intersection = new XhtmlComposer(true).compose(cs.renderIntersection(comp, "", folder, "http://hl7.org/fhir"));
    vars.put("union", new StringType(union));
    vars.put("intersection", new StringType(intersection));

    template = templates.get("CodeSystem-Union");
    cnt = processTemplate(template, "CodeSystem-Union", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+"-union.html"));
    
    template = templates.get("CodeSystem-Intersection");
    cnt = processTemplate(template, "CodeSystem-Intersection", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+"-intersection.html"));
        
  }

  private String file(String name) throws IOException {
    return Utilities.path(folder, name);
  }

  private void renderValueSet(String id, ValueSetComparison comp) throws FHIRException, IOException, EOperationOutcome {
    String template = templates.get("ValueSet");
    Map<String, Base> vars = new HashMap<>();
    ValueSetComparer cs = new ValueSetComparer(session);
    vars.put("left", new StringType(comp.getLeft().present()));
    vars.put("right", new StringType(comp.getRight().present()));
    vars.put("leftId", new StringType(comp.getLeft().getId()));
    vars.put("rightId", new StringType(comp.getRight().getId()));
    vars.put("leftUrl", new StringType(comp.getLeft().getUrl()));
    vars.put("rightUrl", new StringType(comp.getRight().getUrl()));
    vars.put("summary", new StringType(comp.summary()));
    vars.put("errors", new StringType(new XhtmlComposer(true).compose(cs.renderErrors(comp))));
    vars.put("metadata", new StringType(new XhtmlComposer(true).compose(cs.renderMetadata(comp, "", ""))));
    vars.put("compose", new StringType(new XhtmlComposer(true).compose(cs.renderCompose(comp, "", ""))));
    vars.put("expansion", new StringType(new XhtmlComposer(true).compose(cs.renderExpansion(comp, "", ""))));
    String cnt = processTemplate(template, "ValueSet", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+".html"));
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(folder, comp.getId() + "-union.json")), comp.getUnion());
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(folder, comp.getId() + "-intersection.json")), comp.getIntersection());

    String union = new XhtmlComposer(true).compose(cs.renderUnion(comp, "", folder, "http://hl7.org/fhir"));
    String intersection = new XhtmlComposer(true).compose(cs.renderIntersection(comp, "", folder, "http://hl7.org/fhir"));
    vars.put("union", new StringType(union));
    vars.put("intersection", new StringType(intersection));

    template = templates.get("ValueSet-Union");
    cnt = processTemplate(template, "ValueSet-Union", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+"-union.html"));
    
    template = templates.get("ValueSet-Intersection");
    cnt = processTemplate(template, "ValueSet-Intersection", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+"-intersection.html"));        
  }

  private void renderProfile(String id, ProfileComparison comp) throws IOException {
    String template = templates.get("Profile");
    Map<String, Base> vars = new HashMap<>();
    StructureDefinitionComparer cs = new StructureDefinitionComparer(session, new ProfileUtilities(session.getContextLeft(), null, session.getPkpLeft()), 
        new ProfileUtilities(session.getContextRight(), null, session.getPkpRight()));
    vars.put("left", new StringType(comp.getLeft().present()));
    vars.put("right", new StringType(comp.getRight().present()));
    vars.put("leftId", new StringType(comp.getLeft().getId()));
    vars.put("rightId", new StringType(comp.getRight().getId()));
    vars.put("leftUrl", new StringType(comp.getLeft().getUrl()));
    vars.put("rightUrl", new StringType(comp.getRight().getUrl()));
    vars.put("errors", new StringType(new XhtmlComposer(true).compose(cs.renderErrors(comp))));
    vars.put("metadata", new StringType(new XhtmlComposer(true).compose(cs.renderMetadata(comp, "", ""))));
    vars.put("structure", new StringType(new XhtmlComposer(true).compose(cs.renderStructure(comp, "", "", "http://hl7.org/fhir"))));
    String union = new XhtmlComposer(true).compose(cs.renderUnion(comp, "", folder, "http://hl7.org/fhir"));
    String intersection = new XhtmlComposer(true).compose(cs.renderIntersection(comp, "", folder, "http://hl7.org/fhir"));
    vars.put("union", new StringType(union));
    vars.put("intersection", new StringType(intersection));
    
    String cnt = processTemplate(template, "Profile", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+".html"));

    template = templates.get("Profile-Union");
    cnt = processTemplate(template, "Profile-Union", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+"-union.html"));
    
    template = templates.get("Profile-Intersection");
    cnt = processTemplate(template, "Profile-Intersection", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+"-intersection.html"));
    
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(folder, comp.getId() + "-union.json")), comp.getUnion());
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(folder, comp.getId() + "-intersection.json")), comp.getIntersection());
  }
  
  private void renderCapabilityStatement(String id, CapabilityStatementComparison comp) throws IOException {  
    String template = templates.get("CapabilityStatement");
    Map<String, Base> vars = new HashMap<>();
    CapabilityStatementComparer cs = new CapabilityStatementComparer(session);
    vars.put("left", new StringType(comp.getLeft().present()));
    vars.put("right", new StringType(comp.getRight().present()));
    vars.put("leftId", new StringType(comp.getLeft().getId()));
    vars.put("rightId", new StringType(comp.getRight().getId()));
    vars.put("leftUrl", new StringType(comp.getLeft().getUrl()));
    vars.put("rightUrl", new StringType(comp.getRight().getUrl()));
    vars.put("errors", new StringType(new XhtmlComposer(true).compose(cs.renderErrors(comp))));
    vars.put("metadata", new StringType(new XhtmlComposer(true).compose(cs.renderMetadata(comp, "", ""))));
    vars.put("statement", new StringType(new XhtmlComposer(true).compose(cs.renderStatements(comp, "", ""))));
    String cnt = processTemplate(template, "CapabilityStatement", vars);
    FileUtilities.stringToFile(cnt, file(comp.getId()+".html"));
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(folder, comp.getId() + "-union.json")), comp.getUnion());
    new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path(folder, comp.getId() + "-intersection.json")), comp.getIntersection());
  }

  private String processTemplate(String template, String name, Map<String, Base> vars) {
    LiquidEngine engine = new LiquidEngine(contextRight, this);
    LiquidDocument doc = engine.parse(template, name+".template");
    return engine.evaluate(doc, Tuple.fromMap(FhirPublication.R5, vars), vars);
  }

  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    Map<String, Base> vars = (Map<String, Base>) appContext;
    List<Base> res = new ArrayList<>();
    if (mode == FHIRPathConstantEvaluationMode.EXPLICIT) {
      if (vars.containsKey(name)) {
        res.add(vars.get(name));
      }
    }
    return res;
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    Map<String, Base> vars = (Map<String, Base>) appContext;
    Base b = mode == FHIRPathConstantEvaluationMode.EXPLICIT ? vars.get(name) : null;
    return new TypeDetails(CollectionStatus.SINGLETON, b == null ? "Base" : b.fhirType());
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    return false;
  }

  @Override
  public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    return null;
  }

  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
    return null;
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    return null;
  }

  @Override
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext) throws FHIRException {
    return null;
  }

  @Override
  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException {
    return false;
  }

  @Override
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
    return null;
  }

  @Override
  public boolean paramIsType(String name, int index) {
    return false;
  }

  public void loadTemplates(IWorkerContext context) {
    getTemplates().put("CapabilityStatement", new String(context.getBinaryForKey("template-comparison-CapabilityStatement.html")));
    getTemplates().put("CodeSystem-Intersection", new String(context.getBinaryForKey("template-comparison-CodeSystem-Intersection.html")));
    getTemplates().put("CodeSystem-Union", new String(context.getBinaryForKey("template-comparison-CodeSystem-Union.html")));
    getTemplates().put("CodeSystem", new String(context.getBinaryForKey("template-comparison-CodeSystem.html")));
    getTemplates().put("Index", new String(context.getBinaryForKey("template-comparison-index.html")));
    getTemplates().put("Profile-Intersection", new String(context.getBinaryForKey("template-comparison-Profile-Intersection.html")));
    getTemplates().put("Profile-Union", new String(context.getBinaryForKey("template-comparison-Profile-Union.html")));
    getTemplates().put("Profile", new String(context.getBinaryForKey("template-comparison-Profile.html")));
    getTemplates().put("ValueSet-Intersection", new String(context.getBinaryForKey("template-comparison-ValueSet-Intersection.html")));
    getTemplates().put("ValueSet-Union", new String(context.getBinaryForKey("template-comparison-ValueSet-Union.html")));
    getTemplates().put("ValueSet", new String(context.getBinaryForKey("template-comparison-ValueSet.html")));
    
  }

}
