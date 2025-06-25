package org.hl7.fhir.validation.codegen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.context.ContextResourceLoaderFactory;
import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

@Slf4j
public class LogicalModelCodeGenerator {

  public static void main(String[] args) throws Exception {
    String folder = args[0]; 
    String packageName = args[1];
    String cfgPath = args[2];
    List<String> packages = new ArrayList<String>();
    for (int i = 3; i < args.length; i++) {
      packages.add(args[i]);
    }
    
    new LogicalModelCodeGenerator().generate(folder, packageName, cfgPath, packages);
  }

  private void generate(String packageName, String folder, String cfgPath, List<String> packages) throws Exception {
    long start = System.currentTimeMillis();
    Map<String, AnalysisElementInfo> elementInfo = new HashMap<>();
    Set<String> genClassList = new HashSet<>();
    
    log.info("Load Configuration from "+cfgPath);
    Configuration config = new Configuration(cfgPath);
    Date ddate = new Date();
    String date = config.DATE_FORMAT().format(ddate);
    
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    log.info("Load R5");
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r5.core");    
    IContextResourceLoader loader = ContextResourceLoaderFactory.makeLoader(npm.fhirVersion(), new NullLoaderKnowledgeProviderR5());
    SimpleWorkerContext context = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(npm, loader, true);
    String version = context.getVersion();
    context.connectToTSServer(new TerminologyClientFactory(FhirPublication.R5), "http://tx.fhir.org", 
        "CodeGenerator", null, true);
    context.setExpansionParameters(new Parameters());
    
    Definitions master = new Definitions(context);
    for (String pid : packages) {    
      log.info("Load "+pid);
      npm = pcm.loadPackage(pid);    
      loader = ContextResourceLoaderFactory.makeLoader(npm.fhirVersion(), new NullLoaderKnowledgeProviderR5());
      load(master, npm, loader); 
      context.loadFromPackage(npm, loader);
    }
    
//    
//    JavaFactoryGenerator factory = new JavaFactoryGenerator(context, packageName);
//    
//    for (PackagedResourceFile t : npm.listAllResources(Utilities.strings("StructureDefinition"))) {
//      StructureDefinition sd = (StructureDefinition) loader.loadResource(new FileInputStream(t.getFilename()), true);
//      JavaClassGenerator clss = new JavaClassGenerator(context, packageName, factory);
//      clss.generate(sd);
//      clss.save(folder);
//    }
//    factory.save(folder);
//    
    
    master.fix();
    markValueSets(master, config);
    
    log.info("Generate Model in "+folder);
    log.info(" .. Constants");
    JavaConstantsGenerator cgen = new JavaConstantsGenerator(ManagedFileAccess.outStream(Utilities.path(folder, "Constants.java")), master, config, date, npm.version(), packageName);
    cgen.generate();
    cgen.close();
    log.info(" .. Enumerations");
    JavaEnumerationsGenerator egen = new JavaEnumerationsGenerator(ManagedFileAccess.outStream(Utilities.path(folder, "Enumerations.java")), master, config, date, npm.version(), packageName);
    egen.generate();
    egen.close();
    
    JavaFactoryGenerator fgen = new JavaFactoryGenerator(ManagedFileAccess.outStream(Utilities.path(folder, "TypeFactory.java")), master, config, date, npm.version(), packageName);
    String jname = Utilities.capitalize(tail(packageName));
    JavaParserGenerator pgen = new JavaParserGenerator(ManagedFileAccess.outStream(Utilities.path(folder,  jname+"Parser.java")), master, config, date, npm.version(), packageName, jname);
    JavaParserJsonGenerator jgen = new JavaParserJsonGenerator(ManagedFileAccess.outStream(Utilities.path(folder,  jname+"JsonParser.java")), master, config, date, npm.version(), packageName, jname);
    JavaParserXmlGenerator xgen = new JavaParserXmlGenerator(ManagedFileAccess.outStream(Utilities.path(folder, jname+"XmlParser.java")), master, config, date, npm.version(), packageName, jname);

    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE) {
        genClassList.add(Utilities.capitalize(sd.getType())+"Type");
      }
    }

    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && sd.getAbstract()) {
          genClassList.add(genClass(version, folder, date, config, packageName, npm, master, pgen, jgen, xgen, sd, elementInfo, context));
        }
      }
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && !sd.getAbstract()) {
          genClassList.add(genClass(version, folder, date, config, packageName, npm, master, pgen, jgen, xgen, sd, elementInfo, context));
        }
      }
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.RESOURCE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && sd.getAbstract()) {
          genClassList.add(genClass(version, folder, date, config, packageName, npm, master, pgen, jgen, xgen, sd, elementInfo, context));
        }
      }
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.RESOURCE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && !sd.getAbstract()) {
          genClassList.add(genClass(version, folder, date, config, packageName, npm, master, pgen, jgen, xgen, sd, elementInfo, context));
        }
      }
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.LOGICAL) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && sd.getAbstract()) {
          genClassList.add(genClass(version, folder, date, config, packageName, npm, master, pgen, jgen, xgen, sd, elementInfo, context));
        }
      }
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.LOGICAL) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && !sd.getAbstract()) {
          genClassList.add(genClass(version, folder, date, config, packageName, npm, master, pgen, jgen, xgen, sd, elementInfo, context));
        }
      }
    }
    log.info(" .. Factory");
    fgen.generate();
    fgen.close();
    log.info(" .. Parser");
    pgen.generate();
    pgen.close();
    log.info(" .. JsonParser");
    jgen.generate();
    jgen.close();
    log.info(" .. XmlParser");
    xgen.generate();
    xgen.close();
    Map<String, StructureDefinition> extensions = new HashMap<>();
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (ProfileUtilities.isExtensionDefinition(sd)) {
        sd.setUserData("source", "core");
        extensions.put(sd.getUrl(), sd);
      }
    }
    JavaExtensionsGenerator exgen = new JavaExtensionsGenerator(folder, master, config, date, npm.version(), packageName, elementInfo, genClassList);
    exgen.generate(extensions);
    log.info("Done ("+Long.toString(System.currentTimeMillis()-start)+"ms)");
    
  }

  private String tail(String packageName) {
    return packageName.substring(packageName.lastIndexOf(".")+1);
  }

  private Definitions load(Definitions res, NpmPackage npm, IContextResourceLoader loader) throws IOException {    
    for (String t : npm.listResources("CodeSystem")) {
      res.getCodeSystems().see((CodeSystem) load(npm, t, loader), null);
    }
    for (String t : npm.listResources("ValueSet")) {
      res.getValuesets().see((ValueSet) load(npm, t, loader), null);
    }
    for (String t : npm.listResources("ConceptMap")) {
      res.getConceptMaps().see((ConceptMap) load(npm, t, loader), null);
    }
    for (String t : npm.listResources("CapabilityStatement")) {
      res.getStatements().see((CapabilityStatement) load(npm, t, loader), null);
    }
    for (String t : npm.listResources("StructureDefinition")) {
      res.getStructures().see((StructureDefinition) load(npm, t, loader), null);
    }
    for (String t : npm.listResources("OperationDefinition")) {
      res.getOperations().see((OperationDefinition) load(npm, t, loader), null);
    }
    for (String t : npm.listResources("SearchParameter")) {
      res.getSearchParams().see((SearchParameter) load(npm, t, loader), null);
    }
    for (String t : npm.listResources("CompartmentDefinition")) {
      res.getCompartments().see((CompartmentDefinition) load(npm, t, loader), null);
    }
    return res;
  }

  public static Resource load(NpmPackage npm, String t, IContextResourceLoader loader) {
    try {
      return loader.loadResource(npm.loadResource(t), true);
    } catch (Exception e) {
      log.error("Error reading "+t+": "+e.getMessage(), e);
      return null;
    }
  }
  

  @SuppressWarnings("unchecked")
  private void markValueSets(Definitions defns, Configuration config) {
    for (StructureDefinition sd : defns.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() != StructureDefinitionKind.PRIMITIVETYPE && !sd.getName().contains(".")) {
        for (ElementDefinition ed : sd.getSnapshot().getElement()) {
          if (ed.hasBinding() && ed.getBinding().hasValueSet() && ed.getBinding().getStrength() == BindingStrength.REQUIRED) {
            ValueSet vs = defns.getValuesets().get(ed.getBinding().getValueSet());
            if (vs != null) {
              if (!vs.hasUserData("usages")) {
                vs.setUserData("usages", new ArrayList<>());
              }
              List<String> list = (List<String>) vs.getUserData("usages");
              if (!list.contains(sd.getName())) {
                list.add(sd.getName());
              }
            }
          }
        }
      }
    }

    for (ValueSet vs : defns.getValuesets().getList()) {
      List<String> list = (List<String>) vs.getUserData("usages");
      boolean shared = false;
      if (list != null && list.size() > 1) {
        shared = true;
      }
      if (config.getIni().hasProperty("shared", vs.getUrl())) {
        shared = config.getIni().getBooleanProperty("shared", vs.getUrl());
      }
      if (shared) {
        vs.setUserData("shared", true);
      }
    }
  }


  public String genClass(String version, String dest, String date, Configuration config, String jid, NpmPackage npm, Definitions master,

      JavaParserGenerator pgen, 
      JavaParserJsonGenerator jgen, JavaParserXmlGenerator xgen, StructureDefinition sd, Map<String, AnalysisElementInfo> elementInfo, IWorkerContext context)
      throws Exception, IOException, UnsupportedEncodingException, FileNotFoundException {
    String name = javaName(sd.getName());

    log.info(" .. "+name);
    Analyser jca = new Analyser(master, config, version, context);
    Analysis analysis = jca.analyse(sd, elementInfo);
    
    String fn = Utilities.path(dest, name+".java");
    JavaResourceGenerator gen = new JavaResourceGenerator(ManagedFileAccess.outStream(fn), master, config, date, npm.version(), jid);
    gen.generate(analysis); 
    gen.close();
    jgen.seeClass(analysis);
    xgen.seeClass(analysis);
    pgen.seeClass(analysis);
    return name;
  }

  private String javaName(String name) {
    return "List".equals(name) ? "ListResource" : name;
  }

}
