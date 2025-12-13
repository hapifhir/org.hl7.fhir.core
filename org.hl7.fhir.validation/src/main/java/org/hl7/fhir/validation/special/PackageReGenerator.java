package org.hl7.fhir.validation.special;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.NPMPackageGenerator;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.ZipGenerator;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.validation.IgLoader;
import lombok.Getter;

/**
 * Given a package id, and an expansion parameters, 
 * get a list of all the value sets in the package, optionally with expansions. 
 * Parameters:
 * 
 * - scope: this ig | all igs | all igs + core
 * - expansions: true | false
 * - output type: folder | zip | tgz
 */
@Slf4j
public class PackageReGenerator {

  public static class TerminologyResourceEntry {
    public ValueSet valueSet;
    public Set<String> sources = new HashSet<>();
    public String error;
  }

  public static void main(String[] args) throws Exception {

    new PackageReGenerator()
      .addPackage("hl7.fhir.us.davinci-alerts")
      .setJson(true)
      .setOutputType(ExpansionPackageGeneratorOutputType.TGZ)
      .setOutput("/Users/grahamegrieve/temp/vs-output.tgz")
      .generateExpansionPackage();
  }
  
  public enum ExpansionPackageGeneratorOutputType {
    FOLDER, ZIP, TGZ
  }

  public enum ExpansionPackageGeneratorScope {
    IG_ONLY, ALL_IGS, EVERYTHING
  }

  private boolean includeConformsTo;
  private List<String> packages = new ArrayList<String>();
  private Parameters expansionParameters = new Parameters(); 
  private ExpansionPackageGeneratorScope scope = ExpansionPackageGeneratorScope.EVERYTHING;
  private String output;
  private ExpansionPackageGeneratorOutputType outputType;
  private boolean hierarchical;
  private boolean json;
  private IWorkerContext context;
  private String npmId;
  private List<String> ignoreList = new ArrayList<>();
  private FHIRPathEngine pathEngine;
  private List<CanonicalResource> includeList = new ArrayList<>();

  public PackageReGenerator() {
    super();
  }

  public PackageReGenerator setIncludeConformsTo(boolean includeConformsTo) {
    this.includeConformsTo = includeConformsTo;
    return this;
  }


  public PackageReGenerator setIgnoreList(List<String> ignoreList) {
    this.ignoreList = ignoreList;
    return this;
  }

  public PackageReGenerator setIncludeList(List<CanonicalResource> includeList) {
    this.includeList = includeList;
    return this;
  }


  public PackageReGenerator addPackage(String packageId) {
    addPackages(List.of(packageId));
    return this;
  }

  public PackageReGenerator addPackages(List<String> packageIds) {
    packages.addAll(packageIds);
    return this;
  }
  
  public Parameters getExpansionParameters() {
    return expansionParameters;
  }

  public PackageReGenerator setExpansionParameters(Parameters expansionParameters) {
    this.expansionParameters = expansionParameters;
    return this;
  }

  public ExpansionPackageGeneratorScope getScope() {
    return scope;
  }

  public PackageReGenerator setScope(ExpansionPackageGeneratorScope scope) {
    this.scope = scope;
    return this;
  }

  public String getOutput() {
    return output;
  }

  public PackageReGenerator setOutput(String output) {
    this.output = output;
    return this;
  }

  public ExpansionPackageGeneratorOutputType getOutputType() {
    return outputType;
  }

  public PackageReGenerator setOutputType(ExpansionPackageGeneratorOutputType outputType) {
    this.outputType = outputType;
    return this;
  }

  public boolean isHierarchical() {
    return hierarchical;
  }

  public PackageReGenerator setHierarchical(boolean hierarchical) {
    this.hierarchical = hierarchical;
    return this;
  }

  public boolean isJson() {
    return json;
  }

  public PackageReGenerator setJson(boolean json) {
    this.json = json;
    return this;
  }


  public IWorkerContext getContext() {
    return context;
  }

  public PackageReGenerator setContext(IWorkerContext context) {
    this.context = context;
    return this;
  }


  public String getNpmId() {
    return npmId;
  }

  public PackageReGenerator setNpmId(String npmId) {
    this.npmId = npmId;
    return this;
  }


  private ContextUtilities cu;
  
  private Set<String> sourcePackages = new HashSet<>();
  private Map<String, TerminologyResourceEntry> entries = new HashMap<>();
  private Set<String> modeParams;
  @Getter
  private List<CanonicalResource> resources = new ArrayList<>();
  private Set<String> set = new HashSet<>();
  
  public void generateExpansionPackage() throws IOException {
    if (output == null) {
      throw new Error("No output");
    }

    var list = load();
    for (NpmPackage npm : list) {
      if (modeParams.contains("api")) {
        log.info("Processing CapabilityStatements");
        for (String res : npm.listResources("CapabilityStatement")) {
          CapabilityStatement cs = (CapabilityStatement) new JsonParser().parse(npm.loadResource(res));
          cs.setSourcePackage(new PackageInformation(npm));
          processResource(cs);
        }
        log.info("Processing OperationDefinitions");
        for (String res : npm.listResources("OperationDefinition")) {
          OperationDefinition op = (OperationDefinition) new JsonParser().parse(npm.loadResource(res));
          op.setSourcePackage(new PackageInformation(npm));
          processResource(op);
        }
        log.info("Processing SearchParameters");
        for (String res : npm.listResources("SearchParameter")) {
          SearchParameter sp = (SearchParameter) new JsonParser().parse(npm.loadResource(res));
          sp.setSourcePackage(new PackageInformation(npm));
          processResource(sp);
        }        
      }
      if (modeParams.contains("tx")) {
        log.info("Processing CodeSystems");
        for (String res : npm.listResources("CodeSystem")) {
          CodeSystem cs = (CodeSystem) new JsonParser().parse(npm.loadResource(res));
          cs.setSourcePackage(new PackageInformation(npm));
          processResource(cs);
        }
        log.info("Processing ValueSets");
        for (String res : npm.listResources("ValueSet")) {
          ValueSet vs = (ValueSet) new JsonParser().parse(npm.loadResource(res));
          vs.setSourcePackage(new PackageInformation(npm));
          processResource(vs);
        }
        log.info("Processing NamingSystems");
        for (String res : npm.listResources("NamingSystem")) {
          NamingSystem ns = (NamingSystem) new JsonParser().parse(npm.loadResource(res));
          ns.setSourcePackage(new PackageInformation(npm));
          processResource(ns);
        }        
      }
      if (modeParams.contains("cnt")) {
        log.info("Processing StructureDefinitions");
        for (String res : npm.listResources("StructureDefinition")) {
          StructureDefinition sd = (StructureDefinition) new JsonParser().parse(npm.loadResource(res));
          sd.setSourcePackage(new PackageInformation(npm));
          processResource(sd);
        }  
      }
      log.info("Processing Bindings");
      for (String res : npm.listResources("StructureDefinition")) {
        StructureDefinition sd = (StructureDefinition) new JsonParser().parse(npm.loadResource(res));
        processSD(sd, npm.id());
      }

      for (CanonicalResource res : includeList) {
        processResource(res);
      }
      if (modeParams.contains("expansions")) {
        log.info("Generating Expansions");
        for (String n : Utilities.sorted(entries.keySet())) {
          TerminologyResourceEntry e = entries.get(n);
          try {
            log.info("Generating Expansion for "+n+" ... ");
            ValueSetExpansionOutcome exp = context.expandVS(e.valueSet, true, hierarchical);
            if (exp.isOk()) {
              e.valueSet.setExpansion(exp.getValueset().getExpansion());
              log.info("Generated Expansion for "+n);
            } else {
              e.valueSet.setExpansion(null);
              e.error = exp.getError();
              log.warn(exp.getError());
            }
          } catch (Exception ex) {
            log.warn("Error= "+ex.getMessage());
            e.error = ex.getMessage();
          }
        }
      }
    }
    
    switch (outputType) {
    case FOLDER:
      produceFolder();
      break;
    case TGZ:
      producePackage();
      break;
    case ZIP:
      produceZip();
      break;
    default:
      break;
    
    }
    log.info("Done");
  }

  private void processResource(CanonicalResource res) {
    if (res == null)
      return;
    if(ignoreList.contains(res.getUrl()))
      return;

    if (set.contains(res.getVersionedUrl())) {
      return;
    }
    set.add(res.getVersionedUrl());

    if (scope == ExpansionPackageGeneratorScope.EVERYTHING || !isCore(res.getSourcePackage())) {
      resources.add(res);
      if (res.hasSourcePackage()) {
        sourcePackages.add(res.getSourcePackage().getVID());
      }
      if (modeParams.contains("pin")) {
        processBase(res, res, res.fhirType());
      }
      if (scope != ExpansionPackageGeneratorScope.IG_ONLY) {
        chaseDependencies(res);
      }
    }
  }

  private boolean isCore(PackageInformation spi) {
    if (spi == null) {
      return true;
    }
    String pi = spi.getId();
    if (VersionUtilities.isCorePackage(pi)) {
      return true;
    }
    return Utilities.existsInList(pi, "hl7.terminology");
  }

  private void chaseDependencies(CanonicalResource res) {
    if (res instanceof CodeSystem) {
      chaseDependenciesCS((CodeSystem) res);
    }
    if (res instanceof ValueSet) {
      chaseDependenciesVS((ValueSet) res);
    }
    if (res instanceof StructureDefinition) {
      chaseDependenciesSD((StructureDefinition) res);
    }

    if (res instanceof CapabilityStatement) {
      chaseDependenciesCS((CapabilityStatement) res);
    }
    if (res instanceof OperationDefinition) {
      chaseDependenciesOD((OperationDefinition) res);
    }
    if (res instanceof SearchParameter) {
      chaseDependenciesSP((SearchParameter) res);
    }
  }

  private void chaseDependenciesCS(CodeSystem cs) {
    if (cs.hasSupplements()) {
      processResource(context.fetchResource(CodeSystem.class, cs.getSupplements()));      
    }
    for (CodeSystem css : context.fetchResourcesByType(CodeSystem.class)) {
      if (css.supplements(cs)) {
        processResource(css);  
      }
    }
  }

  private void chaseDependenciesVS(ValueSet vs) {
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      chaseDependenciesVS(inc, vs);
    }
    for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
      chaseDependenciesVS(inc, vs);
    }
  }

  private void chaseDependenciesVS(ConceptSetComponent inc, ValueSet vs) {
    for (CanonicalType c : inc.getValueSet()) {
      processResource(context.fetchResource(ValueSet.class, c.primitiveValue()));
    }
    processResource(context.fetchResource(CodeSystem.class, inc.getSystem(), inc.getVersion(), vs));
  }

  private void chaseDependenciesSD(StructureDefinition sd) {
    if (sd.hasBaseDefinition()) {
      processResource(context.fetchResource(StructureDefinition.class, sd.getBaseDefinition()));
    }
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getBinding().hasValueSet()) {
        processResource(context.fetchResource(ValueSet.class, ed.getBinding().getValueSet()));
        for (ElementDefinitionBindingAdditionalComponent adb : ed.getBinding().getAdditional()) {
          processResource(context.fetchResource(ValueSet.class, adb.getValueSet()));          
        }
      }
      for (TypeRefComponent tr : ed.getType()) {
        if (Utilities.isAbsoluteUrl(tr.getCode())) {
          processResource(context.fetchResource(StructureDefinition.class, tr.getCode()));
        }
        for (CanonicalType c : tr.getProfile()) {
          processResource((CanonicalResource) context.fetchResource(Resource.class, c.primitiveValue()));
        }
        for (CanonicalType c : tr.getTargetProfile()) {
          processResource((CanonicalResource) context.fetchResource(Resource.class, c.primitiveValue()));
        }
      }
      if(includeConformsTo) {
        for (ElementDefinition.ElementDefinitionConstraintComponent inv : ed.getConstraint()) {
          if (inv.hasExpression()) {
            ExpressionNode node = pathEngine.parse(inv.getExpression());
            processExpression(node);
          }
        }
      }
    }
  }

  private void processExpression(ExpressionNode node) {
    if (node != null) {
      if (node.getFunction() == ExpressionNode.Function.ConformsTo || node.getFunction() == ExpressionNode.Function.MemberOf) {
        Base c = getConstantParam(node);
        if (c != null) {
          processResource((CanonicalResource) context.fetchResource(Resource.class, c.primitiveValue()));
        }
      }
      processExpression(node.getInner());
      processExpression(node.getGroup());
      processExpression(node.getOpNext());
      if(node.getParameters() != null) {
        for (ExpressionNode p : node.getParameters()) {
          processExpression(p);
        }
      }
    }
  }

  private Base getConstantParam(ExpressionNode node) {
      if (!node.getParameters().isEmpty()) {
        List<Base> list = pathEngine.evaluate(null, node.getParameters().get(0));
        return list.isEmpty() ? null : list.get(0);
    }
    return null;
  }

  private void chaseDependenciesCS(CapabilityStatement cs) {
    for (CanonicalType c : cs.getInstantiates()) {
      processResource(context.fetchResource(CapabilityStatement.class, c.primitiveValue()));
    }
    for (CanonicalType c : cs.getImports()) {
      processResource(context.fetchResource(CapabilityStatement.class, c.primitiveValue()));
    }
    for (CanonicalType c : cs.getImplementationGuide()) {
      processResource(context.fetchResource(CapabilityStatement.class, c.primitiveValue()));
    }
    for (CapabilityStatementRestComponent r : cs.getRest()) { 
      for (CapabilityStatementRestResourceComponent rr : r.getResource()) {
        if (rr.hasProfile()) {
          processResource(context.fetchResource(StructureDefinition.class, rr.getProfile()));
        }
        for (CanonicalType c : rr.getSupportedProfile()) {
          processResource(context.fetchResource(StructureDefinition.class, c.primitiveValue()));
        }
        for (CapabilityStatementRestResourceSearchParamComponent sp : rr.getSearchParam()) {
          if (sp.hasDefinition()) {
            processResource(context.fetchResource(SearchParameter.class, sp.getDefinition()));
          }
        }
        for (CapabilityStatementRestResourceOperationComponent od : rr.getOperation()) {
          if (od.hasDefinition()) {
            processResource(context.fetchResource(OperationDefinition.class, od.getDefinition()));
          }
        }
      }
      for (CapabilityStatementRestResourceSearchParamComponent sp : r.getSearchParam()) {
        if (sp.hasDefinition()) {
          processResource(context.fetchResource(SearchParameter.class, sp.getDefinition()));
        }
      }
      for (CapabilityStatementRestResourceOperationComponent od : r.getOperation()) {
        if (od.hasDefinition()) {
          processResource(context.fetchResource(OperationDefinition.class, od.getDefinition()));
        }
      }
    }
    for (CapabilityStatementDocumentComponent doc : cs.getDocument()) {
      if (doc.hasProfile()) {
        processResource(context.fetchResource(StructureDefinition.class, doc.getProfile()));
      }
    }
  }

  private void chaseDependenciesOD(OperationDefinition od) {
    if (od.hasBase()) {
      processResource(context.fetchResource(SearchParameter.class, od.getBase()));
    }
    if (od.hasInputProfile()) {
      processResource(context.fetchResource(StructureDefinition.class, od.getInputProfile()));
    }
    if (od.hasOutputProfile()) {
      processResource(context.fetchResource(StructureDefinition.class, od.getOutputProfile()));
    }
    for (OperationDefinitionParameterComponent p : od.getParameter()) {
      for (CanonicalType c : p.getTargetProfile()) {
        processResource(context.fetchResource(StructureDefinition.class, c.primitiveValue()));
      }

      if (p.getBinding().hasValueSet()) {
        processResource(context.fetchResource(ValueSet.class, p.getBinding().getValueSet()));
      }
    }
  }

  private void chaseDependenciesSP(SearchParameter sp) {
    if (sp.hasDerivedFrom()) {
      processResource(context.fetchResource(SearchParameter.class, sp.getDerivedFrom()));
    }
    for (SearchParameterComponentComponent c : sp.getComponent()) {
      if (c.hasDefinition()) {
        processResource(context.fetchResource(SearchParameter.class, c.getDefinition()));
      }      
    }
  }

  private void processBase(CanonicalResource src, Base b, String path) {
    for (Property p : b.children()) {
      for (Base v : p.getValues()) {
        processBase(src, v,  path+"."+p.getName());
      }
    }
    if (b instanceof CanonicalType) {
      CanonicalType ct = (CanonicalType) b;
      if (!ct.hasVersion()) {
        Resource res = context.fetchResource(Resource.class, ct.getValue(), null, src);
        if (res != null && res instanceof CanonicalResource) {
          CanonicalResource cr = (CanonicalResource) res;
          ct.addVersion(cr.getVersion());
        }          
      }
    }
    if (b instanceof ConceptSetComponent) {
      ConceptSetComponent cs = (ConceptSetComponent) b;
      if (!cs.hasVersion()) {
        Resource res = context.fetchResource(Resource.class, cs.getSystem(), null, src);
        if (res != null && res instanceof CanonicalResource) {
          CanonicalResource cr = (CanonicalResource) res;
          cs.setVersion(cr.getVersion());
        }          
      }
    }
  }
  
  private void produceZip() throws IOException {
    log.info("Producing Output in Zip "+output);
    ZipGenerator zip = new ZipGenerator(output);
    Set<String> names = new HashSet<>();
    names.add("manifest");
    if (json) {
      zip.addBytes("manifest.json", new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters), false);
    } else {
      zip.addBytes("manifest.xml", new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters), false);
    }

    for (CanonicalResource cr : resources) {
      zip.addBytes(cr.fhirType()+"-"+cr.getIdBase()+(cr.hasVersion() ? "-"+tokenise(cr.getVersion()): "")+(json? ".json" : ".xml"), composeResource(cr), false);
    }
    if (modeParams.contains("expansions")) {
      StringBuilder b = new StringBuilder();
      for (String n : Utilities.sorted(entries.keySet())) {
        TerminologyResourceEntry e = entries.get(n);
        String name = e.valueSet.getIdBase();
        int i = 0;
        while (names.contains(name)) {
          i++;
          name = e.valueSet.getIdBase()+i;
        }
        names.add(name);
        if (e.error == null) {
          b.append(name+","+n+", , "+CommaSeparatedStringBuilder.join(";",e.sources)+"\r\n");
        } else {
          b.append(name+","+n+", \""+Utilities.escapeCSV(e.error)+"\", "+CommaSeparatedStringBuilder.join(";",e.sources)+"\r\n");
        }
        zip.addBytes(name+".json", composeResource(e.valueSet), false);
      }
      zip.addBytes("valuesets.csv", b.toString().getBytes(StandardCharsets.UTF_8), false);
    }
    zip.close();
  }

  private void producePackage() throws FHIRException, IOException {
    log.info("Producing Output Package in "+output);
    JsonObject j = new JsonObject();
    String id = npmId == null ? "custom.generated" : npmId.contains("#") ? npmId.substring(0, npmId.indexOf("#")) : npmId;
    String ver = npmId  != null && npmId.contains("#") ? npmId.substring(npmId.indexOf("#")+1) : "0.1.0";
    j.add("name", id);
    j.add("version",ver);
    j.add("tools-version", 3);
    j.add("type", "Conformance");
    j.forceArray("fhirVersions").add(context.getVersion());
    for (String pid : sourcePackages) {
      j.forceArray("sourcePackages").add(pid);
    }
    j.forceObject("dependencies").add(VersionUtilities.packageForVersion(context.getVersion()), context.getVersion());
    
    NPMPackageGenerator gen = new NPMPackageGenerator(output, j, new Date(), true);

    for (CanonicalResource cr : resources) {
      gen.addFile("package",cr.fhirType()+"-"+cr.getIdBase()+(cr.hasVersion() ? "-"+tokenise(cr.getVersion()): "")+".json", composeResource(cr));
    }
    Set<String> names = new HashSet<>();
    names.add("manifest");
    if (json) {
      gen.addFile("package", "manifest.json", new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters));
    } else {
      gen.addFile("package", "manifest.xml", new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters));
    }
    if (modeParams.contains("expansions")) {
      StringBuilder b = new StringBuilder();
      for (String n : Utilities.sorted(entries.keySet())) {
        TerminologyResourceEntry e = entries.get(n);
        String name = e.valueSet.getIdBase();
        int i = 0;
        while (names.contains(name)) {
          i++;
          name = e.valueSet.getIdBase()+i;
        }
        names.add(name);
        if (e.error == null) {
          b.append(name+","+n+", , "+CommaSeparatedStringBuilder.join(";",e.sources)+"\r\n");
        } else {
          b.append(name+","+n+", \""+Utilities.escapeCSV(e.error)+"\", "+CommaSeparatedStringBuilder.join(";",e.sources)+"\r\n");
        }
        gen.addFile("package",name+".json", composeResource(e.valueSet));
      }
      gen.addFile("other","valuesets.csv", b.toString().getBytes(StandardCharsets.UTF_8));
    }
    gen.finish();
  }

  private String tokenise(String version) {
    if (version == null)
      return "";
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < version.length(); i++) {
      char c = version.charAt(i);
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '_' || c == '.' || c == '-') {
        b.append(c);
      } else {
        // skip
      }
    }
    return b.toString();
  }

  private void produceFolder() throws IOException {
    log.info("Producing Output in folder "+output);
    FileUtilities.createDirectory(output);
    FileUtilities.clearDirectory(output);
    Set<String> names = new HashSet<>();
    names.add("manifest");
    if (json) {
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(output, "manifest.json")), expansionParameters);
    } else {
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(output, "manifest.xml")), expansionParameters);
    }
    for (CanonicalResource cr : resources) {
      FileUtilities.bytesToFile(composeResource(cr), Utilities.path(output, cr.fhirType()+"-"+cr.getIdBase()+(cr.hasVersion() ? "-"+tokenise(cr.getVersion()): "")+(json? ".json" : ".xml")));      
    }
    if (modeParams.contains("expansions")) {
      StringBuilder b = new StringBuilder();
      for (String n : Utilities.sorted(entries.keySet())) {
        TerminologyResourceEntry e = entries.get(n);
        String name = "ValueSet-"+e.valueSet.getIdBase()+"-expansion";
        int i = 0;
        while (names.contains(name)) {
          i++;
          name = e.valueSet.getIdBase()+i;
        }
        names.add(name);
        if (e.error == null) {
          b.append(name+","+n+", , "+CommaSeparatedStringBuilder.join(";",e.sources)+"\r\n");
        } else {
          b.append(name+","+n+", \""+Utilities.escapeCSV(e.error)+"\", "+CommaSeparatedStringBuilder.join(";",e.sources)+"\r\n");
        }
        FileUtilities.bytesToFile(composeResource(e.valueSet), Utilities.path(output, name+(json? ".json" : ".xml")));
      }
      FileUtilities.stringToFile(b.toString(), Utilities.path(output, "expansions.csv"));
    }
  }


  private byte[] composeResource(CanonicalResource cr) throws IOException {
    if (json) {
      return new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(cr);
    } else {
      return new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(cr);
    }
  }

  private void processSD(StructureDefinition sd, String packageId) {
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      if (ed.hasBinding() && ed.getBinding().hasValueSet()) {
        processValueSet(ed.getBinding().getValueSet(), packageId+":"+sd.getVersionedUrl()+"#"+ed.getId());
      }
    }
    if (scope != ExpansionPackageGeneratorScope.IG_ONLY && sd.getBaseDefinition() != null) {
      StructureDefinition bsd = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition(), null, sd);
      if (bsd != null) { 
        if (!bsd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition") || scope == ExpansionPackageGeneratorScope.EVERYTHING) {
          processSD(bsd, bsd.getSourcePackage().getVID());
        }
      }
    }
  }


  private void processValueSet(String valueSet, String source) {
    String url = cu.pinValueSet(valueSet);
    ValueSet vs = context.fetchResource(ValueSet.class, url);
    if (vs != null) {
      TerminologyResourceEntry e = entries.get(vs.getVersionedUrl());
      if (e == null) {
        e = new TerminologyResourceEntry();
        e.sources.add(source);
        e.valueSet = vs;
        entries.put(vs.getVersionedUrl(), e);
        source = vs.getSourcePackage().getVID()+":"+vs.getVersionedUrl();
        for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
          for (CanonicalType v : inc.getValueSet()) {
            if (v.hasValue()) {
              processValueSet(v.primitiveValue(), source);
            }
          }
        }
        for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
          for (CanonicalType v : inc.getValueSet()) {
            if (v.hasValue()) {
              processValueSet(v.primitiveValue(), source);
            }
          }
        }
      } else {
        e.sources.add(source);
      }
      
    } else {
      log.info("Unable to resolve value set "+valueSet);
    }
    
  }

  private List<NpmPackage> load() throws IOException {
    List<NpmPackage> list = new ArrayList<NpmPackage>();
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    for (String packageId : packages) {
      NpmPackage npm = pcm.loadPackage(packageId);
      if (context == null) {
        String v = npm.fhirVersion();
        NpmPackage core = pcm.loadPackage(VersionUtilities.packageForVersion(v));
        NpmPackage tho = pcm.loadPackage("hl7.terminology");
        log.info("Load FHIR from "+core.name()+"#"+core.version());
        SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(core);
        TerminologyClientFactory factory = new TerminologyClientFactory(ctxt.getVersion());
        ctxt.connectToTSServer(factory, "http://tx.fhir.org", ctxt.getUserAgent(), null, true);
        var loader = new IgLoader(pcm, ctxt, ctxt.getVersion());
        loader.loadPackage(tho, true);
        loader.loadPackage(npm, true);
        context = ctxt;
        context.getManager().setExpansionParameters(expansionParameters);

        loader.loadPackage(npm, true);    
      } else {
        var loader = new IgLoader(pcm, (SimpleWorkerContext) context, context.getVersion());
        loader.loadPackage(npm, true);        
      }
      list.add(npm);
    }
    pathEngine = new FHIRPathEngine(context);
    if (cu == null) {
      cu = new ContextUtilities(context);
    }
    return list;
  }

  public PackageReGenerator setModes(Set<String> modeParams) {
    this.modeParams = modeParams;
    return this;
  }

}
