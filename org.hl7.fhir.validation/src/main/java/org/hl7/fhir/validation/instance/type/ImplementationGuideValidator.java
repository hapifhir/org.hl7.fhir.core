package org.hl7.fhir.validation.instance.type;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.PackageClient;
import org.hl7.fhir.utilities.npm.PackageInfo;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

public class ImplementationGuideValidator extends BaseValidator {

  private static final int DATE_WARNING_CUTOFF = 3;

  public ImplementationGuideValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateImplementationGuide(ValidationContext valContext, List<ValidationMessage> errors, Element ig, NodeStack stack) {
    boolean ok = true;
    List<Element> el = ig.getChildren("fhirVersion");
    List<String> fvl = new ArrayList<String>();
    for (Element e : el) {
      String fver = e.primitiveValue();
      fvl.add(fver);
    }
    warning(errors, "2024-06-13", IssueType.BUSINESSRULE, ig.line(), ig.col(), stack.getLiteralPath(), !fvl.isEmpty(), I18nConstants.IG_NO_VERSION);
    List<Element> dependencies = ig.getChildrenByName("dependsOn");
    int i = 0;
    for (Element dependency : dependencies) {
      ok = checkDependency(errors, ig, stack.push(dependency, i, null, null), dependency, fvl) && ok;
      i++;
    }

    if (isHL7Org(ig)) {
      ok = rule(errors, "2025-02-13", IssueType.BUSINESSRULE, ig.line(), ig.col(), stack.getLiteralPath(), ig.hasExtension(ExtensionDefinitions.EXT_STANDARDS_STATUS), I18nConstants.IG_HL7_STANDARDS_STATUS_REQUIRED) && ok;
      ok = rule(errors, "2025-02-13", IssueType.BUSINESSRULE, ig.line(), ig.col(), stack.getLiteralPath(), ig.hasExtension(ExtensionDefinitions.EXT_WORKGROUP), I18nConstants.IG_HL7_WG_REQUIRED) && ok;               
      warning(errors, "2025-02-13", IssueType.BUSINESSRULE, ig.line(), ig.col(), stack.getLiteralPath(), ig.hasExtension(ExtensionDefinitions.EXT_FMM_LEVEL), I18nConstants.IG_HL7_FMM_SHOULD);               
    }
    return ok;
  }

  private boolean checkDependency(List<ValidationMessage> errors, Element ig, NodeStack stack, Element dependency, List<String> fvl) {
    boolean ok = true;
    String url = dependency.getNamedChildValue("uri");
    String packageId = dependency.getNamedChildValue("packageId");
    String version = dependency.getNamedChildValue("version");
    if (url != null && url.contains("|")) {
      String uver = url.substring(url.indexOf("|")+1);
      url = url.substring(0, url.indexOf("|"));
      if (Utilities.noString(uver)) {
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(),false, I18nConstants.IG_DEPENDENCY_CAN_VERSION_NONE, uver) && ok;                   
      } else if (version == null) {
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(),false, I18nConstants.IG_DEPENDENCY_CAN_VERSION_ALONE, uver) && ok;                   
      } else if (!uver.equals(version)) {
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), url == null || url.contains("/ImplementationGuide/"), I18nConstants.IG_DEPENDENCY_CAN_VERSION_ERROR, uver, version) && ok;                   
      }
    }
    ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), url == null || url.contains("/ImplementationGuide/"), I18nConstants.IG_DEPENDENCY_DIRECT, url) && ok;         
    ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), packageId == null || packageId.matches(FilesystemPackageCacheManager.PACKAGE_REGEX), I18nConstants.IG_DEPENDENCY_INVALID_PACKAGEID, packageId) && ok;         

    try {
      ImplementationGuide fetchedIgDependency = context.fetchResource(ImplementationGuide.class, url);
      warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), fetchedIgDependency != null, I18nConstants.IG_DEPENDENCY_INVALID_URL, url);                   
      FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
      if (url != null && packageId != null && (fetchedIgDependency == null || !fetchedIgDependency.hasUserData(UserDataNames.IG_FAKE))) {
        String pid = pcm.getPackageId(url);
        String canonical = pcm.getPackageUrl(packageId);
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), pid == null || pid.equals(packageId) || packageId.startsWith(pid+"."+VersionUtilities.getNameForVersion(context.getVersion()).toLowerCase()), I18nConstants.IG_DEPENDENCY_CLASH_PACKAGEID, url, pid, packageId) && ok;         
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), canonical == null || canonical.equals(url) || url.startsWith(Utilities.pathURL(canonical, "ImplementationGuide")), I18nConstants.IG_DEPENDENCY_CLASH_CANONICAL, packageId, canonical, url) && ok;         
      }
      if (packageId == null && ok) {
        packageId = pcm.getPackageId(url);
      }
      if (ok && warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), packageId != null, I18nConstants.IG_DEPENDENCY_NO_PACKAGE) &&
          warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), version != null, I18nConstants.IG_DEPENDENCY_NO_VERSION)) {
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), (packageId+"#"+version).matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX), I18nConstants.IG_DEPENDENCY_INVALID_PACKAGE_VERSION, version) && ok;               
        NpmPackage npm = pcm.loadPackage(packageId, version);
        if (warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), npm != null, I18nConstants.IG_DEPENDENCY_PACKAGE_UNKNOWN, packageId+"#"+version)) {
          if (!fvl.isEmpty()) {
            String pver = npm.fhirVersion();
            if (!VersionUtilities.versionsMatch(pver, fvl)) {
              if (Utilities.existsInList(packageId, "hl7.fhir.uv.extensions", "hl7.fhir.uv.tools", "hl7.terminology")) {
                ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), false, I18nConstants.IG_DEPENDENCY_VERSION_ERROR, CommaSeparatedStringBuilder.join(",", fvl), packageId+"#"+version, pver, 
                    packageId+"."+VersionUtilities.getNameForVersion(fvl.get(0)).toLowerCase()) && ok;                           
              } else {
                warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), false, I18nConstants.IG_DEPENDENCY_VERSION_WARNING, CommaSeparatedStringBuilder.join(",", fvl), packageId+"#"+version, pver);
              }
            }
          }
        }
        if (settings.isForPublication()) { 
          try {
            PackageClient pc = new PackageClient(PackageServer.primaryServer());
            List<PackageInfo> list = pc.getVersions(packageId);
            Collections.sort(list, new org.hl7.fhir.utilities.npm.PackageInfo.PackageInfoVersionSorter());
            String lver = pcm.getLatestVersion(packageId);
            String date = null;
            for (PackageInfo t : list) {
              if (!t.getVersion().contains("-")) {
                lver = t.getVersion();
              }
            }
            if (lver != null && !"current".equals(lver) && !"current".equals(version) && !VersionUtilities.versionsMatch(version, lver) && isMoreThanXMonthsAgo(npm.dateAsLocalDate(), DATE_WARNING_CUTOFF)) {
              warning(errors, "2025-03-06", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), false, I18nConstants.IG_DEPENDENCY_VERSION_WARNING_OLD, packageId+"#"+version, lver, npm.dateAsLocalDate().toString());            
            }
          } catch (Exception e) {
          }
        }
      }
    } catch (Exception e) {
      warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), version != null, I18nConstants.IG_DEPENDENCY_EXCEPTION, e.getMessage());
    }
    return ok;
  }

  public static boolean isMoreThanXMonthsAgo(LocalDate date, int months) {
    LocalDate today = LocalDate.now();
    LocalDate thresholdDate = today.minusMonths(months);
    return date.isBefore(thresholdDate);
  }
}