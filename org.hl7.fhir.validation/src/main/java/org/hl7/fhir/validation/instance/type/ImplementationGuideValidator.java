package org.hl7.fhir.validation.instance.type;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.TimeType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier.ValidationContextResourceProxy;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.cli.utils.QuestionnaireMode;
import org.hl7.fhir.validation.instance.utils.EnableWhenEvaluator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;
import org.hl7.fhir.validation.instance.utils.EnableWhenEvaluator.QStack;

import ca.uhn.fhir.util.ObjectUtil;

public class ImplementationGuideValidator extends BaseValidator {

  public ImplementationGuideValidator(IWorkerContext context, XVerExtensionManager xverManager, boolean debug, ValidatorSession session) {
    super(context, xverManager, debug, session);
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

    return ok;
  }

  private boolean checkDependency(List<ValidationMessage> errors, Element ig, NodeStack stack, Element dependency, List<String> fvl) {
    boolean ok = true;
    String url = dependency.getNamedChildValue("url");
    String packageId = dependency.getNamedChildValue("packageId");
    String version = dependency.getNamedChildValue("version");

    ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), url == null || url.contains("/ImplementationGuide/"), I18nConstants.IG_DEPENDENCY_DIRECT, url) && ok;         
    ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), packageId == null || packageId.matches(FilesystemPackageCacheManager.PACKAGE_REGEX), I18nConstants.IG_DEPENDENCY_INVALID_PACKAGEID, packageId) && ok;         

    try {
      FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
      if (url != null && packageId != null) {
        String pid = pcm.getPackageId(url);
        String canonical = pcm.getPackageUrl(packageId);
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), pid == null || pid.equals(packageId), I18nConstants.IG_DEPENDENCY_CLASH_PACKAGEID, url, pid, packageId) && ok;         
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), canonical == null || canonical.equals(url), I18nConstants.IG_DEPENDENCY_CLASH_CANONICAL, packageId, canonical, url) && ok;         
      }
      if (packageId == null && ok) {
        packageId = pcm.getPackageId(url);
      }
      if (ok && warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), packageId != null, I18nConstants.IG_DEPENDENCY_NO_PACKAGE) &&
          warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), version != null, I18nConstants.IG_DEPENDENCY_NO_VERSION)) {
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), (packageId+"#"+version).matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX), I18nConstants.IG_DEPENDENCY_INVALID_PACKAGE_VERSION, version) && ok;               
        NpmPackage npm = pcm.loadPackage(packageId, version);
        if (warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), npm != null, I18nConstants.IG_DEPENDENCY_PACKAGE_UNKNOWN, packageId+"#"+version)) {
          if (fvl.isEmpty()) {
            String pver = npm.fhirVersion();
            if (!VersionUtilities.versionsMatch(pver, fvl)) {
              if ("hl7.fhir.uv.extensions".equals(packageId)) {
                ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), false, I18nConstants.IG_DEPENDENCY_VERSION_ERROR, CommaSeparatedStringBuilder.join(",", fvl), packageId+"#"+version, pver, 
                    "hl7.fhir.uv.extensions."+VersionUtilities.getNameForVersion(fvl.get(0)).toLowerCase()) && ok;                           
              } else {
                warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), false, I18nConstants.IG_DEPENDENCY_VERSION_WARNING, CommaSeparatedStringBuilder.join(",", fvl), packageId+"#"+version, pver);
              }
            }
          }
        }
      }
    } catch (Exception e) {
      warning(errors, "2024-06-13", IssueType.BUSINESSRULE, dependency.line(), dependency.col(), stack.getLiteralPath(), version != null, I18nConstants.IG_DEPENDENCY_EXCEPTION, e.getMessage());
    }
    return ok;
  }


}