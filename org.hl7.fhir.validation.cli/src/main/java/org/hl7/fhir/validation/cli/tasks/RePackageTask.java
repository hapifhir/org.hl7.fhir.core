package org.hl7.fhir.validation.cli.tasks;

import java.io.InputStream;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.utilities.npm.*;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.PackageNameParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.RePackageParametersParser;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.model.PackageNameParameters;
import org.hl7.fhir.validation.service.model.RePackageParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.special.PackageReGenerator;
import org.hl7.fhir.validation.special.PackageReGenerator.ExpansionPackageGeneratorOutputType;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

@Slf4j
public class RePackageTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "tx-pack";
  }

  @Override
  public String getDisplayName() {
    return "Generate a terminology pack";
  }

  @Override
  public boolean isHidden() {
    return false;
  }


  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, RePackageParametersParser.TX_PACK) || Params.hasParam(args, RePackageParametersParser.RE_PACK);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger, "help/tx-pack.txt");
  }


  @Override
  protected RePackageTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new RePackageTaskInstance(args);
  }
  @Override
  public boolean usesInstanceValidatorParameters() {
    return true;
  }


  protected class RePackageTaskInstance extends ValidationEngineTaskInstance {

    OutputParameters outputParameters;
    RePackageParameters rePackageParameters;
    PackageNameParameters packageNameParameters;

    RePackageTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      RePackageParametersParser rePackageParametersParser = new RePackageParametersParser();
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      PackageNameParametersParser packageNameParametersParser = new PackageNameParametersParser();
      rePackageParametersParser.parseArgs(args);
      outputParametersParser.parseArgs(args);
      packageNameParametersParser.parseArgs(args);
      rePackageParameters = rePackageParametersParser.getParameterObject();
      outputParameters = outputParametersParser.getParameterObject();
      packageNameParameters = packageNameParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      boolean json = rePackageParameters.getFormat() != FhirFormat.XML;
      String output = outputParameters.getOutput();

      PackageReGenerator packageReGenerator = new PackageReGenerator()
        .setContext(validationEngine.getContext())
        .setOutput(output)
        .setOutputType(getExpansionPackageGeneratorOutputType(output))
        .setJson(json)
        .setModes(rePackageParameters.getModeParams())
        .setNpmId(packageNameParameters.getPackageName())
        .addPackages(rePackageParameters.getPackages());


      if (rePackageParameters.getScope() != null) {
        packageReGenerator.setScope(rePackageParameters.getScope());
      }
      if (instanceValidatorParameters.getExpansionParameters() != null) {
        validationEngine.loadExpansionParameters(instanceValidatorParameters.getExpansionParameters());
      }

     if (rePackageParameters.getIgnoreList() != null && !rePackageParameters.getIgnoreList().isEmpty()) {
       packageReGenerator.setIgnoreList(rePackageParameters.getIgnoreList());
     }

      if (rePackageParameters.getIncludeList() != null && !rePackageParameters.getIncludeList().isEmpty()) {
        List<CanonicalResource> canonicalResources = loadResources(rePackageParameters.getIncludeList(), validationEngine.getPcm());
        packageReGenerator.setIncludeList(canonicalResources);
      }

      if(rePackageParameters.isIncludeConformsTo()){
        packageReGenerator.setIncludeConformsTo(true);
      }

      packageReGenerator.generateExpansionPackage();

    }
    private List<CanonicalResource> loadResources(List<String> canonicals, FilesystemPackageCacheManager pcm) {

      PackageClient packageClient = new PackageClient(PackageServer.primaryServer());

      List<CanonicalResource> canonicalResources = new java.util.ArrayList<>();
      try {
        for (String canonical : canonicals) {

          List<PackageInfo> results = packageClient.search(null, null, null, false, canonical);
          if (!results.isEmpty()) {

            //We'll only take the first one as determine that as the most recent and relevant one
            PackageInfo result = results.get(0);

            NpmPackage npmPackage = pcm.loadPackage(result.getId(), result.getVersion());
            if (npmPackage == null) {
              log.error("Unable to load package {}#{} for canonical {}", result.getId(), result.getVersion(), canonical);
            } else {
              log.info("Loaded package {}#{} for canonical {}", result.getId(), result.getVersion(), canonical);
              CanonicalResource resource = getCanonicalResource(canonical, npmPackage);
              if (resource != null)
                canonicalResources.add(resource);
            }
          }
        }

      } catch (Exception e) {
        log.error("Error loading packages for canonicals", e);
      }
      return canonicalResources;
    }
  }
  
  private static ExpansionPackageGeneratorOutputType getExpansionPackageGeneratorOutputType(String output) {

    if (output.endsWith(".zip")) {
      return ExpansionPackageGeneratorOutputType.ZIP;
    } else if (output.endsWith(".tgz")) {
      return ExpansionPackageGeneratorOutputType.TGZ;
    }
    return ExpansionPackageGeneratorOutputType.FOLDER;
  }


  private static CanonicalResource getCanonicalResource(String canonical, NpmPackage npmPackage) throws Exception {
    InputStream stream = npmPackage.loadByCanonical(canonical);
    CanonicalResource canonicalResource;
    if (stream == null) {
      log.warn("Unable to load package {}#{} for canonical {}", npmPackage.name(), npmPackage.version(), canonical);
      return null;
    }
    if ("4.0.1".equals(npmPackage.fhirVersion())) {
      IBaseResource r4resource = new org.hl7.fhir.r4.formats.JsonParser().parse(stream);
      canonicalResource = (CanonicalResource) VersionConvertorFactory_40_50.convertResource((org.hl7.fhir.r4.model.Resource) r4resource);
    } else if ("5.0.0".equals(npmPackage.fhirVersion())) {
      canonicalResource = (CanonicalResource) new org.hl7.fhir.r5.formats.JsonParser().parse(stream);
    } else {
      log.warn("Unsupported FHIR version {} for package {}", npmPackage.fhirVersion(), npmPackage.name());
      return null;
    }
    canonicalResource.setSourcePackage(new PackageInformation(npmPackage));
    return canonicalResource;
  }


}
