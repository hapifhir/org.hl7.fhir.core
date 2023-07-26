package org.hl7.fhir.convertors.misc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.R2ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R3ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R4ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R5ToR5Loader;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.ResourceDependencyWalker;
import org.hl7.fhir.r5.utils.ResourceDependencyWalker.IResourceDependencyNotifier;
import org.hl7.fhir.r5.utils.ResourceMinifier;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class ResourceDependencyPackageBuilder {

  private static final List<String> LOADED_TYPES =
      Arrays.asList("StructureDefinition", "CodeSystem", "ValueSet", "CapabilityStatement", "ConceptMap", "NamingSystem", "OperationDefinition", "SearchParameter", "Questionnaire");
  
  public static void main(String[] args) throws IOException {

    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(true);
    System.out.println("Load Core");
    NpmPackage src = pcm.loadPackage(VersionUtilities.packageForVersion(args[0]));
    SimpleWorkerContext ctxt = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(src);
    loadFromPackage(args[0], ctxt, pcm, args[1]);
    
    NpmResourceDependencyCollector pckBuilder = new NpmResourceDependencyCollector();
    pckBuilder.npm = makeNpm(args[3], ctxt.getVersion());
    pckBuilder.minify = "true".equals(args[5]);
    
    new ResourceDependencyWalker(ctxt, pckBuilder).walk(ctxt.fetchResource(CapabilityStatement.class, args[2]));
    
    pckBuilder.npm.save(new FileOutputStream(args[4]));
  }

  private static NpmPackage makeNpm(String vid, String version) throws JsonException, IOException {
    NpmPackage res = NpmPackage.empty();
    String name = vid.substring(0, vid.indexOf('#')); 
    String ver = vid.substring(vid.indexOf("#")+1); 
    res.setNpm(JsonParser.parseObject("{\"name\": \""+name+"\", \"version\": \""+ver+"\",\"fhirVersions\": [\""+version+"\"],\"type\": \"fhir.ig\",\"tools-version\": 3}"));
    return res;
  }


  public static class NpmResourceDependencyCollector implements IResourceDependencyNotifier {

    private NpmPackage npm;
    private boolean minify;
    
    private byte[] toBytes(Resource resource) throws IOException {
      if (VersionUtilities.isR5Ver(npm.fhirVersion())) {
        return new org.hl7.fhir.r5.formats.JsonParser().composeBytes(resource);
      }
      if (VersionUtilities.isR4Plus(npm.fhirVersion())) {
        org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_40_50.convertResource(resource);
        return new org.hl7.fhir.r4.formats.JsonParser().composeBytes(r4);
      }
      if (VersionUtilities.isR3Ver(npm.fhirVersion())) {
        org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertorFactory_30_50.convertResource(resource);
        return new org.hl7.fhir.dstu3.formats.JsonParser().composeBytes(r3);
      }
      if (VersionUtilities.isR2Ver(npm.fhirVersion())) {
        org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertorFactory_10_50.convertResource(resource);
        return new org.hl7.fhir.dstu2.formats.JsonParser().composeBytes(r2);
      }
      throw new Error("Unsupported version");
    }
    
    @Override
    public void seeResource(Resource resource, String summaryId) {
      if (minify) {
        ResourceMinifier min = new ResourceMinifier();
        if (min.isMinified(resource.fhirType())) {
          resource = resource.copy();
          if (!min.minify(resource)) {
            return;
          }
        } else {
          return;
        }
      }
      try {
        npm.addFile("package", resource.fhirType()+"-"+resource.getIdPart()+".json", toBytes(resource), null);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void brokenLink(String link) {
      System.err.println("Broken Link: " +link);      
    }
  }
  
  private static void loadFromPackage(String version, SimpleWorkerContext ctxt, FilesystemPackageCacheManager pcm, String pid) throws FHIRException, IOException {
    NpmPackage npm = pcm.loadPackage(pid);
    for (String dep : npm.dependencies()) {
      if (!VersionUtilities.isCorePackage(dep)) {
        loadFromPackage(version, ctxt, pcm, dep);
      }
    }
    System.out.println("Load "+pid);
    ctxt.loadFromPackage(npm, getLoader(version));
  }

  private static IContextResourceLoader getLoader(String version) {
    if (VersionUtilities.isR2Ver(version)) {
      return new R2ToR5Loader(LOADED_TYPES, new NullLoaderKnowledgeProviderR5());
    }
    if (VersionUtilities.isR3Ver(version)) {
      return new R3ToR5Loader(LOADED_TYPES, new NullLoaderKnowledgeProviderR5());
    }
    if (VersionUtilities.isR4Ver(version)) {
      return new R4ToR5Loader(LOADED_TYPES, new NullLoaderKnowledgeProviderR5(), version);
    }
    if (VersionUtilities.isR5Ver(version)) {
      return new R5ToR5Loader(LOADED_TYPES, new NullLoaderKnowledgeProviderR5());
    }
    return null;
  }


}
