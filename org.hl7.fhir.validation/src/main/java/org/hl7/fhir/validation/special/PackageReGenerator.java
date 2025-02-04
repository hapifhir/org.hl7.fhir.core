package org.hl7.fhir.validation.special;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
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
import org.hl7.fhir.validation.special.PackageReGenerator.TerminologyResourceEntry;

/**
 * Given a package id, and an expansion parameters, 
 * get a list of all the value sets in the package, optionally with expansions. 
 * Parameters:
 * 
 * - scope: this ig | all igs | all igs + core
 * - expansions: true | false
 * - output type: folder | zip | tgz
 */

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

  private List<String> packages = new ArrayList<String>();
  private Parameters expansionParameters = new Parameters(); 
  private ExpansionPackageGeneratorScope scope = ExpansionPackageGeneratorScope.EVERYTHING;
  private String output;
  private ExpansionPackageGeneratorOutputType outputType;
  private boolean hierarchical;
  private boolean json;
  private IWorkerContext context;
  

  public PackageReGenerator addPackage(String packageId) {
    packages.add(packageId);
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


  private ContextUtilities cu;
  
  private Map<String, TerminologyResourceEntry> entries = new HashMap<>();
  private Set<String> modeParams;
  private List<CanonicalResource> resources = new ArrayList<CanonicalResource>();
  
  public void generateExpansionPackage() throws IOException {
    if (output == null) {
      throw new Error("No output");
    }

    var list = load();
    for (NpmPackage npm : list) {
      if (modeParams.contains("api")) {
        System.out.println("Processing CapabilityStatements");
        for (String res : npm.listResources("CapabilityStatement")) {
          CapabilityStatement cs = (CapabilityStatement) new JsonParser().parse(npm.loadResource(res));
          processResource(cs);
        }
        System.out.println("Processing OperationDefinitions");
        for (String res : npm.listResources("OperationDefinition")) {
          OperationDefinition op = (OperationDefinition) new JsonParser().parse(npm.loadResource(res));
          processResource(op);
        }
        System.out.println("Processing SearchParameters");
        for (String res : npm.listResources("SearchParameter")) {
          SearchParameter sp = (SearchParameter) new JsonParser().parse(npm.loadResource(res));
          processResource(sp);
        }        
      }
      if (modeParams.contains("tx")) {
        System.out.println("Processing CodeSystems");
        for (String res : npm.listResources("CodeSystem")) {
          CodeSystem cs = (CodeSystem) new JsonParser().parse(npm.loadResource(res));
          processResource(cs);
        }
        System.out.println("Processing ValueSets");
        for (String res : npm.listResources("ValueSet")) {
          ValueSet vs = (ValueSet) new JsonParser().parse(npm.loadResource(res));
          processResource(vs);
        }
        System.out.println("Processing NamingSystems");
        for (String res : npm.listResources("NamingSystem")) {
          NamingSystem ns = (NamingSystem) new JsonParser().parse(npm.loadResource(res));
          processResource(ns);
        }        
      }
      if (modeParams.contains("cnt")) {
        System.out.println("Processing StructureDefinitions");
        for (String res : npm.listResources("StructureDefinition")) {
          StructureDefinition cs = (StructureDefinition) new JsonParser().parse(npm.loadResource(res));
          processResource(cs);
        }  
      }
      System.out.println("Processing Bindings");
      for (String res : npm.listResources("StructureDefinition")) {
        StructureDefinition sd = (StructureDefinition) new JsonParser().parse(npm.loadResource(res));
        processSD(sd, npm.id());
      }
      if (modeParams.contains("expansions")) {
        System.out.println("Generating Expansions");
        for (String n : Utilities.sorted(entries.keySet())) {
          TerminologyResourceEntry e = entries.get(n);
          try {
            System.out.print("Generate Expansion for "+n+" ... ");
            ValueSetExpansionOutcome exp = context.expandVS(e.valueSet, true, hierarchical);
            if (exp.isOk()) {
              e.valueSet.setExpansion(exp.getValueset().getExpansion());
              System.out.println("OK");
            } else {
              e.valueSet.setExpansion(null);
              e.error = exp.getError();
              System.out.println(exp.getError());
            }
          } catch (Exception ex) {
            System.out.println("Error= "+ex.getMessage());
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
    System.out.println("Done");
  }

  private void processResource(CanonicalResource res) {
    resources.add(res);
    if (modeParams.contains("pin")) {
      processBase(res, res);
    }
  }
  

  private void processBase(CanonicalResource src, Base b) {
    for (Property p : b.children()) {
      for (Base v : p.getValues()) {
        processBase(src, v);
      }
    }
    if (b instanceof CanonicalType) {
      CanonicalType ct = (CanonicalType) b;
      if (!ct.hasVersion()) {
        Resource res = context.fetchResource(Resource.class, ct.getValue(), src);
        if (res != null && res instanceof CanonicalResource) {
          CanonicalResource cr = (CanonicalResource) res;
          ct.addVersion(cr.getVersion());
        }          
      }
    }
  }
  
  private void produceZip() throws IOException {
    System.out.println("Producing Output in Zip "+output);
    ZipGenerator zip = new ZipGenerator(output);
    Set<String> names = new HashSet<>();
    names.add("manifest");
    if (json) {
      zip.addBytes("manifest.json", new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters), false);
    } else {
      zip.addBytes("manifest.xml", new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters), false);
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
    System.out.println("Producing Output Package in "+output);
    JsonObject j = new JsonObject();
    j.add("name", "custom.generated");
    j.add("version", "0.0.1");
    j.add("tools-version", 3);
    j.add("type", "Conformance");
    j.forceArray("fhirVersions").add(context.getVersion());
    j.forceObject("dependencies").add(VersionUtilities.packageForVersion(context.getVersion()), context.getVersion());
    
    NPMPackageGenerator gen = new NPMPackageGenerator(output, j, new Date(), true);

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

  private void produceFolder() throws IOException {
    System.out.println("Producing Output in folder "+output);
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
      FileUtilities.bytesToFile(composeResource(cr), Utilities.path(output, cr.fhirType()+"-"+cr.getIdBase()+(json? ".json" : ".xml")));      
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
      StructureDefinition bsd = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition(), sd);
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
      System.out.println("Unable to resolve value set "+valueSet);
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
        System.out.println("Load FHIR from "+core.name()+"#"+core.version());
        SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(core);
        TerminologyClientFactory factory = new TerminologyClientFactory(ctxt.getVersion());
        ctxt.connectToTSServer(factory, "http://tx.fhir.org", ctxt.getUserAgent(), null, true);
        var loader = new IgLoader(pcm, ctxt, ctxt.getVersion());
        loader.loadPackage(tho, true);
        loader.loadPackage(npm, true);
        context = ctxt;
        context.setExpansionParameters(expansionParameters);
        if (scope == ExpansionPackageGeneratorScope.EVERYTHING) {
//          list.add(core);
//          list.add(tho);
        }
      } else {
        var loader = new IgLoader(pcm, (SimpleWorkerContext) context, context.getVersion());
        loader.loadPackage(npm, true);
        if (scope == ExpansionPackageGeneratorScope.ALL_IGS) {
//          for (NpmPackage p : loader.getPackageList()) {
//            // nothing?
//          }
        }
      }
      list.add(npm);
    }
    if (cu == null) {
      cu = new ContextUtilities(context);
    }
    return list;
  }

  public void setModes(Set<String> modeParams) {
    this.modeParams = modeParams;
    
  }

}
