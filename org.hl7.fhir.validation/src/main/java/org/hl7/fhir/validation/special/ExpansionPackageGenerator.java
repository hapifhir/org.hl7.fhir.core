package org.hl7.fhir.validation.special;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.NPMPackageGenerator;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.ZipGenerator;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.special.ExpansionPackageGenerator.TerminologyResourceEntry;

/**
 * Given a package id, and an expansion parameters, 
 * get a list of all the value sets in the package, optionally with expansions. 
 * Parameters:
 * 
 * - scope: this ig | all igs | all igs + core
 * - expansions: true | false
 * - output type: folder | zip | tgz
 */

public class ExpansionPackageGenerator {

  public static class TerminologyResourceEntry {
    public ValueSet valueSet;
    public Set<String> sources = new HashSet<>();
    public String error;
  }

  public static void main(String[] args) throws Exception {
    new ExpansionPackageGenerator()
      .setPackageId("hl7.fhir.us.davinci-alerts")
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

  private String packageId;
  private Parameters expansionParameters = new Parameters(); 
  private ExpansionPackageGeneratorScope scope = ExpansionPackageGeneratorScope.EVERYTHING;
  private boolean expansions;
  private String output;
  private ExpansionPackageGeneratorOutputType outputType;
  private boolean hierarchical;
  private boolean json;
  private IWorkerContext context;
  
  
  public String getPackageId() {
    return packageId;
  }

  public ExpansionPackageGenerator setPackageId(String packageId) {
    this.packageId = packageId;
    return this;
  }

  public Parameters getExpansionParameters() {
    return expansionParameters;
  }

  public ExpansionPackageGenerator setExpansionParameters(Parameters expansionParameters) {
    this.expansionParameters = expansionParameters;
    return this;
  }

  public ExpansionPackageGeneratorScope getScope() {
    return scope;
  }

  public ExpansionPackageGenerator setScope(ExpansionPackageGeneratorScope scope) {
    this.scope = scope;
    return this;
  }

  public boolean isExpansions() {
    return expansions;
  }

  public ExpansionPackageGenerator setExpansions(boolean expansions) {
    this.expansions = expansions;
    return this;
  }

  public String getOutput() {
    return output;
  }

  public ExpansionPackageGenerator setOutput(String output) {
    this.output = output;
    return this;
  }

  public ExpansionPackageGeneratorOutputType getOutputType() {
    return outputType;
  }

  public ExpansionPackageGenerator setOutputType(ExpansionPackageGeneratorOutputType outputType) {
    this.outputType = outputType;
    return this;
  }

  public boolean isHierarchical() {
    return hierarchical;
  }

  public ExpansionPackageGenerator setHierarchical(boolean hierarchical) {
    this.hierarchical = hierarchical;
    return this;
  }

  public boolean isJson() {
    return json;
  }

  public ExpansionPackageGenerator setJson(boolean json) {
    this.json = json;
    return this;
  }


  public IWorkerContext getContext() {
    return context;
  }

  public ExpansionPackageGenerator setContext(IWorkerContext context) {
    this.context = context;
    return this;
  }


  private ContextUtilities cu;
  
  private Map<String, TerminologyResourceEntry> entries = new HashMap<>();
  
  public void generateExpansionPackage() throws IOException {
    if (output == null) {
      throw new Error("No output");
    }

    
    var npm = load();
    System.out.println("Finding ValueSets");
    for (String res : npm.listResources("StructureDefinition")) {
      StructureDefinition sd = (StructureDefinition) new JsonParser().parse(npm.loadResource(res));
      processSD(sd, npm.id());
      
    }
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

    System.out.println("Producing Output");
    switch (outputType) {
    case FOLDER:
      produceFolder();
      break;
    case TGZ:
      producePackage(npm);
      break;
    case ZIP:
      produceZip();
      break;
    default:
      break;
    
    }
    System.out.println("Done");
  }

  private void produceZip() throws IOException {
    ZipGenerator zip = new ZipGenerator(output);
    Set<String> names = new HashSet<>();
    names.add("manifest");
    if (json) {
      zip.addBytes("manifest.json", new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters), false);
    } else {
      zip.addBytes("manifest.xml", new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters), false);
    }
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
      if (json) {
        zip.addBytes(name+".json", new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(e.valueSet), false);
      } else {
        zip.addBytes(name+".xml", new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(e.valueSet), false);
      }
    }
    zip.addBytes("valuesets.csv", b.toString().getBytes(StandardCharsets.UTF_8), false);
    zip.close();
  }

  private void producePackage(NpmPackage npm) throws FHIRException, IOException {
    JsonObject j = new JsonObject();
    j.add("name", npm.id()+".custom.extensions");
    j.add("version", npm.version());
    j.add("tools-version", 3);
    j.add("type", "Conformance");
    j.forceArray("fhirVersions").add(npm.fhirVersion());
    j.forceObject("dependencies").add(VersionUtilities.packageForVersion(npm.fhirVersion()), npm.fhirVersion());
    
    NPMPackageGenerator gen = new NPMPackageGenerator(output, j, new Date(), true);

    Set<String> names = new HashSet<>();
    names.add("manifest");
    if (json) {
      gen.addFile("package", "manifest.json", new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters));
    } else {
      gen.addFile("package", "manifest.xml", new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(expansionParameters));
    }
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
      if (json) {
        gen.addFile("package",name+".json", new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(e.valueSet));
      } else {
        gen.addFile("package",name+".xml", new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(e.valueSet));
      }
    }
    gen.addFile("other","valuesets.csv", b.toString().getBytes(StandardCharsets.UTF_8));
    gen.finish();
  }

  private void produceFolder() throws IOException {
    Utilities.createDirectory(output);
    Utilities.clearDirectory(output);
    Set<String> names = new HashSet<>();
    names.add("manifest");
    if (json) {
      new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(output, "manifest.json")), expansionParameters);
    } else {
      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(output, "manifest.xml")), expansionParameters);
    }
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
      if (json) {
        new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(output, name+".json")), e.valueSet);
      } else {
        new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(output, name+".xml")), e.valueSet);
      }
    }
    TextFile.stringToFile(b.toString(), Utilities.path(output, "valuesets.csv"));
  }

  private void processSD(StructureDefinition sd, String packageId) {
//    System.out.println("Found Structure: "+sd.getVersionedUrl());
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      if (ed.hasBinding() && ed.getBinding().hasValueSet()) {
//        TerminologyResourceEntry e = new TerminologyResourceEntry();
        processValueSet(ed.getBinding().getValueSet(), packageId+":"+sd.getVersionedUrl()+"#"+ed.getId());
      }
    }
    if (scope != ExpansionPackageGeneratorScope.IG_ONLY && sd.getBaseDefinition() != null) {
      StructureDefinition bsd = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      if (!bsd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition") || scope == ExpansionPackageGeneratorScope.EVERYTHING) {
        processSD(bsd, bsd.getSourcePackage().getVID());
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

  private NpmPackage load() throws IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
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
    } else {
      var loader = new IgLoader(pcm, (SimpleWorkerContext) context, context.getVersion());
      loader.loadPackage(npm, true);
    }
    context.setExpansionParameters(expansionParameters);
    cu = new ContextUtilities(context);
    return npm;
  }

}
