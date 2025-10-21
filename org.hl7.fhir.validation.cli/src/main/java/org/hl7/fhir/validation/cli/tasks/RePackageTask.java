package org.hl7.fhir.validation.cli.tasks;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.utilities.npm.*;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.RePackageParametersParser;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.special.PackageReGenerator;
import org.hl7.fhir.validation.special.PackageReGenerator.ExpansionPackageGeneratorOutputType;
import org.hl7.fhir.validation.special.PackageReGenerator.ExpansionPackageGeneratorScope;
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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return shouldExecuteTask(args);
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
  public void executeTask(
    @Nonnull ValidationService validationService,
    @Nonnull ValidationEngine validationEngine,
    @Nonnull ValidationContext validationContext,
    @Nonnull String[] args) throws Exception {
    boolean json = validationContext.getFormat() != FhirFormat.XML;
    String output = validationContext.getOutput();


    PackageReGenerator packageReGenerator = new PackageReGenerator()
      .setContext(validationEngine.getContext())
      .setOutput(output)
      .setOutputType(getExpansionPackageGeneratorOutputType(output))
      .setJson(json)
      .setModes(validationContext.getModeParams())
      .setNpmId(validationContext.getPackageName())
      .addPackages(validationContext.getIgs());


    switch (Objects.requireNonNull(Params.getParam(args, RePackageParametersParser.SCOPE))) {
      case "ig":
        packageReGenerator.setScope(ExpansionPackageGeneratorScope.IG_ONLY);
        break;
      case "igs":
        packageReGenerator.setScope(ExpansionPackageGeneratorScope.ALL_IGS);
        break;
      case "core":
        packageReGenerator.setScope(ExpansionPackageGeneratorScope.EVERYTHING);
        break;
    }

    if (validationContext.getExpansionParameters() != null) {
      validationEngine.loadExpansionParameters(validationContext.getExpansionParameters());
    }

    String ignoreList = Params.getParam(args, RePackageParametersParser.IGNORE_LIST);
    if (!Strings.isNullOrEmpty(ignoreList)) packageReGenerator.setIgnoreList(List.of(ignoreList.split(",")));

    String includeList = Params.getParam(args, RePackageParametersParser.INCLUDE_LIST);
    if (!Strings.isNullOrEmpty(includeList)) {
      List<CanonicalResource> canonicalResources = loadResources(List.of(includeList.split(",")), validationEngine.getPcm());
      packageReGenerator.setIncludeList(canonicalResources);
    }

    if(Boolean.parseBoolean(Params.getParam(args, RePackageParametersParser.INCLUDE_CONFORMS_TO))){
      packageReGenerator.setIncludeConformsTo(true);
    }

    packageReGenerator.generateExpansionPackage();

  }

  private static ExpansionPackageGeneratorOutputType getExpansionPackageGeneratorOutputType(String output) {

    if (output.endsWith(".zip")) {
      return ExpansionPackageGeneratorOutputType.ZIP;
    } else if (output.endsWith(".tgz")) {
      return ExpansionPackageGeneratorOutputType.TGZ;
    }
    return ExpansionPackageGeneratorOutputType.FOLDER;
  }

  private List<CanonicalResource> loadResources(List<String> canonicals, FilesystemPackageCacheManager pcm) {

    PackageClient packageClient = new PackageClient(PackageServer.primaryServer());

    List<CanonicalResource> canonicalResources = new java.util.ArrayList<>();
    try {
      for (String canonical : canonicals) {

        List<PackageInfo> results = packageClient.search(null, null, null, false, canonical);
        if (results.size() > 0) {

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
