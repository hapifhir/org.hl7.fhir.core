package org.hl7.fhir.validation.cli.tasks;

import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.utilities.http.HTTPRequest;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Params;
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
    return Params.hasParam(args, Params.TX_PACK)
      || Params.hasParam(args, Params.RE_PACK) ;
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/tx-pack.txt");
  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
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

    switch (Objects.requireNonNull(Params.getParam(args, Params.SCOPE)))
    {
      case "ig": packageReGenerator.setScope(ExpansionPackageGeneratorScope.IG_ONLY); break;
      case "igs": packageReGenerator.setScope(ExpansionPackageGeneratorScope.ALL_IGS); break;
      case "core": packageReGenerator.setScope(ExpansionPackageGeneratorScope.EVERYTHING); break;
    }

    if (validationContext.getExpansionParameters() != null) {
      validationEngine.loadExpansionParameters(validationContext.getExpansionParameters());
    }

    String ignoreList = Params.getParam(args, Params.IGNORE_LIST);
    if(!Strings.isNullOrEmpty(ignoreList))
      packageReGenerator.addIgnoreList(List.of(ignoreList.split(",")));

    String includeList = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient,http://hl7.dk/fhir/core/StructureDefinition/dk-core-patient";
    if(!Strings.isNullOrEmpty(includeList))
    {
      List<String> canonicals = List.of(includeList.split(","));
      List<CanonicalResource> canonicalResourece = loadPackagesToCache(canonicals, validationEngine.getPcm());
      packageReGenerator.addIncludeList(canonicalResourece);
    }

    packageReGenerator.generateExpansionPackage();
  }

  private List<CanonicalResource> loadPackagesToCache(List<String> canonicals, FilesystemPackageCacheManager pcm) {

    List<CanonicalResource> canonicalResources = new java.util.ArrayList<>();
    try {
      for (String canonical : canonicals) {
        String encoded = URLEncoder.encode(canonical, "UTF-8");
        HTTPRequest request = new HTTPRequest().withUrl("https://packages2.fhir.org/packages/catalog?op=find&canonical=" + encoded).withMethod(HTTPRequest.HttpMethod.GET);
        HTTPResult response = ManagedWebAccess.httpCall(request);

        JsonArray catalogs = new Gson().fromJson(response.getContentAsString(), JsonArray.class);
        JsonObject catalog = catalogs.get(0).getAsJsonObject();
        String packageId = catalog.get("name").getAsString();
        String version = catalog.get("version").getAsString();

        NpmPackage npmPackage = pcm.loadPackage(packageId, version);
        if (npmPackage == null) {
          log.error("Unable to load package {}#{} for canonical {}", packageId, version, canonical);
        } else {
          log.info("Loaded package {}#{} for canonical {}", packageId, version, canonical);
        }
        npmPackage.loadByCanonical(canonical);
        //canonicalResourece.add()
      }
    } catch (Exception e) {
      log.error("Error loading packages for canonicals", e);
    }
    return canonicalResources;
  }

  private static ExpansionPackageGeneratorOutputType getExpansionPackageGeneratorOutputType(String output) {

    if (output.endsWith(".zip")) {
      return ExpansionPackageGeneratorOutputType.ZIP;
    } else if (output.endsWith(".tgz")) {
      return ExpansionPackageGeneratorOutputType.TGZ;
    }
    return ExpansionPackageGeneratorOutputType.FOLDER;
  }
}
