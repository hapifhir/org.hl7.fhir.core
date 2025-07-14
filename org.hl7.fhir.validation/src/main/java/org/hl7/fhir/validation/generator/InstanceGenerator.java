package org.hl7.fhir.validation.generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.loaders.loaderR5.R4BToR5Loader;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

@SuppressWarnings("checkstyle:systemout")
public class InstanceGenerator {

  public static void main(String[] args) throws FHIRException, IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    NpmPackage npm = pcm.loadPackage("hl7.fhir.r4.core");
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(npm);
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.us.core#6.0.0"), new R4BToR5Loader(null, null, null));
    var gen = new InstanceGenerator(context);
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, args[0]);
    FhirFormat fmt = FhirFormat.valueOf(args[1].toUpperCase());
    FileOutputStream f = ManagedFileAccess.outStream(args[2]);
    List<String> messages = gen.generateInstance(sd, fmt, f);
    if (messages.isEmpty()) {
      System.out.println("Generated OK");
    } else {
      System.out.println("Generation failed:");
      for (String msg : messages) {
        System.out.println(" - "+msg);
      }
    }
  }

  private IWorkerContext context;
  
  protected InstanceGenerator(IWorkerContext context) {
    super();
    this.context = context;
  }

  /**
   * main public entry point. populates the outputstream, or produces at least one error message in the output
   * 
   */
  public List<String> generateInstance(StructureDefinition profile, FhirFormat format, OutputStream destination) {
    List<String> res = new ArrayList<>();
    res.add("Not done yet");
    return res;
    
  }
}
