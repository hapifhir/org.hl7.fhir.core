package org.hl7.fhir.r4b.renderers.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.conformance.ProfileUtilities;
import org.hl7.fhir.r4b.conformance.ProfileUtilities.ProfileKnowledgeProvider;
import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r4b.renderers.utils.Resolver.IReferenceResolver;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r4b.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;

public class RenderingContext {

  // provides liquid templates, if they are available for the content
  public interface ILiquidTemplateProvider {
    String findTemplate(RenderingContext rcontext, DomainResource r);

    String findTemplate(RenderingContext rcontext, String resourceName);
  }

  // parses xml to an XML instance. Whatever codes provides this needs to provide
  // something that parses the right version
  public interface ITypeParser {
    Base parseType(String xml, String type) throws FHIRFormatError, IOException, FHIRException;
  }

  /**
   * What kind of user the renderer is targeting - end users, or technical users
   * 
   * This affects the way codes and references are rendered
   * 
   * @author graha
   *
   */
  public enum ResourceRendererMode {
    /**
     * The user has no interest in the contents of the FHIR resource, and just wants
     * to see the data
     * 
     */
    END_USER,

    /**
     * The user wants to see the resource, but a technical view so they can see
     * what's going on with the content
     */
    TECHNICAL
  }

  public enum QuestionnaireRendererMode {
    /**
     * A visual presentation of the questionnaire, with a set of property panes that
     * can be toggled on and off. Note that this is not the same as how the
     * questionnaire would like on a form filler, since all dynamic behavior is
     * ignored
     */
    FORM,

    /**
     * a structured tree that presents the content of the questionnaire in a logical
     * fashion
     */
    TREE,

    /**
     * A structured tree that presents the enableWhen, terminology and expression
     * bindings for the questionnaire
     */
    LOGIC,

    /**
     * A presentation that lists all the items, with full details about them
     */
    DEFNS,

    /**
     * Rendered links to various openly available Form Filler applications that know
     * how to render a questionnaire published in a package
     */
    LINKS
  }

  private IWorkerContext worker;
  private MarkDownProcessor markdown;
  private ResourceRendererMode mode;
  private IReferenceResolver resolver;
  private ILiquidTemplateProvider templateProvider;
  private IEvaluationContext services;
  private ITypeParser parser;

  private String lang;
  private String localPrefix; // relative link within local context
  private String specificationLink;
  private String selfLink; // absolute link to where the content is to be found (only used in a few
                           // circumstances when making external references to tools)
  private int headerLevelContext;
  private boolean canonicalUrlsAsLinks;
  private boolean pretty;
  private boolean header;
  private boolean contained;

  private ValidationOptions terminologyServiceOptions = new ValidationOptions();
  private boolean noSlowLookup;
  private String tooCostlyNoteEmpty;
  private String tooCostlyNoteNotEmpty;
  private String tooCostlyNoteEmptyDependent;
  private String tooCostlyNoteNotEmptyDependent;
  private List<String> codeSystemPropList = new ArrayList<>();

  private ProfileUtilities profileUtilities;
  private String definitionsTarget;
  private String destDir;
  private boolean inlineGraphics;

  private QuestionnaireRendererMode questionnaireMode = QuestionnaireRendererMode.FORM;
  private boolean addGeneratedNarrativeHeader = true;

  private FhirPublication targetVersion;
  private Locale locale;
  private ZoneId timeZoneId;
  private DateTimeFormatter dateTimeFormat;
  private DateTimeFormatter dateFormat;
  private DateTimeFormatter dateYearFormat;
  private DateTimeFormatter dateYearMonthFormat;

  /**
   * 
   * @param context                   - access to all related resources that might
   *                                  be needed
   * @param markdown                  - appropriate markdown processing engine
   * @param terminologyServiceOptions - options to use when looking up codes
   * @param specLink                  - path to FHIR specification
   * @param lang                      - langauage to render in
   */
  public RenderingContext(IWorkerContext worker, MarkDownProcessor markdown,
      ValidationOptions terminologyServiceOptions, String specLink, String localPrefix, String lang,
      ResourceRendererMode mode) {
    super();
    this.worker = worker;
    this.markdown = markdown;
    this.lang = lang;
    this.specificationLink = specLink;
    this.localPrefix = localPrefix;
    this.mode = mode;
    if (terminologyServiceOptions != null) {
      this.terminologyServiceOptions = terminologyServiceOptions;
    }
    // default to US locale - discussion here:
    // https://github.com/hapifhir/org.hl7.fhir.core/issues/666
    this.locale = new Locale.Builder().setLanguageTag("en-US").build();
    profileUtilities = new ProfileUtilities(worker, null, null);
  }

  public RenderingContext copy() {
    RenderingContext res = new RenderingContext(worker, markdown, terminologyServiceOptions, specificationLink,
        localPrefix, lang, mode);

    res.resolver = resolver;
    res.templateProvider = templateProvider;
    res.services = services;
    res.parser = parser;

    res.headerLevelContext = headerLevelContext;
    res.canonicalUrlsAsLinks = canonicalUrlsAsLinks;
    res.pretty = pretty;
    res.contained = contained;

    res.noSlowLookup = noSlowLookup;
    res.tooCostlyNoteEmpty = tooCostlyNoteEmpty;
    res.tooCostlyNoteNotEmpty = tooCostlyNoteNotEmpty;
    res.tooCostlyNoteEmptyDependent = tooCostlyNoteEmptyDependent;
    res.tooCostlyNoteNotEmptyDependent = tooCostlyNoteNotEmptyDependent;
    res.codeSystemPropList.addAll(codeSystemPropList);

    res.profileUtilities = profileUtilities;
    res.definitionsTarget = definitionsTarget;
    res.destDir = destDir;
    res.addGeneratedNarrativeHeader = addGeneratedNarrativeHeader;
    res.questionnaireMode = questionnaireMode;
    res.header = header;
    res.selfLink = selfLink;
    res.inlineGraphics = inlineGraphics;
    res.timeZoneId = timeZoneId;
    res.dateTimeFormat = dateTimeFormat;
    res.dateFormat = dateFormat;
    res.dateYearFormat = dateYearFormat;
    res.dateYearMonthFormat = dateYearMonthFormat;
    res.targetVersion = targetVersion;
    res.locale = locale;

    res.terminologyServiceOptions = terminologyServiceOptions.copy();
    return res;
  }

  public IWorkerContext getContext() {
    return worker;
  }

  // -- 2. Markdown support
  // -------------------------------------------------------

  public ProfileUtilities getProfileUtilities() {
    return profileUtilities;
  }

  public IWorkerContext getWorker() {
    return worker;
  }

  public boolean isCanonicalUrlsAsLinks() {
    return canonicalUrlsAsLinks;
  }

  public RenderingContext setCanonicalUrlsAsLinks(boolean canonicalUrlsAsLinks) {
    this.canonicalUrlsAsLinks = canonicalUrlsAsLinks;
    return this;
  }

  public MarkDownProcessor getMarkdown() {
    if (markdown == null) {
      markdown = new MarkDownProcessor(Dialect.COMMON_MARK);
    }
    return markdown;
  }

  public String getLang() {
    return lang;
  }

  public String getSpecificationLink() {
    return specificationLink;
  }

  public String getLocalPrefix() {
    return localPrefix;
  }

  public ValidationOptions getTerminologyServiceOptions() {
    return terminologyServiceOptions;
  }

  public String getTooCostlyNoteEmpty() {
    return tooCostlyNoteEmpty;
  }

  public RenderingContext setTooCostlyNoteEmpty(String tooCostlyNoteEmpty) {
    this.tooCostlyNoteEmpty = tooCostlyNoteEmpty;
    return this;
  }

  public String getTooCostlyNoteNotEmpty() {
    return tooCostlyNoteNotEmpty;
  }

  public RenderingContext setTooCostlyNoteNotEmpty(String tooCostlyNoteNotEmpty) {
    this.tooCostlyNoteNotEmpty = tooCostlyNoteNotEmpty;
    return this;
  }

  public String getTooCostlyNoteEmptyDependent() {
    return tooCostlyNoteEmptyDependent;
  }

  public RenderingContext setTooCostlyNoteEmptyDependent(String tooCostlyNoteEmptyDependent) {
    this.tooCostlyNoteEmptyDependent = tooCostlyNoteEmptyDependent;
    return this;
  }

  public String getTooCostlyNoteNotEmptyDependent() {
    return tooCostlyNoteNotEmptyDependent;
  }

  public RenderingContext setTooCostlyNoteNotEmptyDependent(String tooCostlyNoteNotEmptyDependent) {
    this.tooCostlyNoteNotEmptyDependent = tooCostlyNoteNotEmptyDependent;
    return this;
  }

  public int getHeaderLevelContext() {
    return headerLevelContext;
  }

  public RenderingContext setHeaderLevelContext(int headerLevelContext) {
    this.headerLevelContext = headerLevelContext;
    return this;
  }

  public IReferenceResolver getResolver() {
    return resolver;
  }

  public RenderingContext setResolver(IReferenceResolver resolver) {
    this.resolver = resolver;
    return this;
  }

  public RenderingContext setTerminologyServiceOptions(ValidationOptions terminologyServiceOptions) {
    this.terminologyServiceOptions = terminologyServiceOptions;
    return this;
  }

  public boolean isNoSlowLookup() {
    return noSlowLookup;
  }

  public RenderingContext setNoSlowLookup(boolean noSlowLookup) {
    this.noSlowLookup = noSlowLookup;
    return this;
  }

  public String getDefinitionsTarget() {
    return definitionsTarget;
  }

  public RenderingContext setDefinitionsTarget(String definitionsTarget) {
    this.definitionsTarget = definitionsTarget;
    return this;
  }

  public String getDestDir() {
    return destDir;
  }

  public RenderingContext setDestDir(String destDir) {
    this.destDir = destDir;
    return this;
  }

  public RenderingContext setProfileUtilities(ProfileUtilities profileUtilities) {
    this.profileUtilities = profileUtilities;
    return this;
  }

  public ILiquidTemplateProvider getTemplateProvider() {
    return templateProvider;
  }

  public RenderingContext setTemplateProvider(ILiquidTemplateProvider templateProvider) {
    this.templateProvider = templateProvider;
    return this;
  }

  public IEvaluationContext getServices() {
    return services;
  }

  public RenderingContext setServices(IEvaluationContext services) {
    this.services = services;
    return this;
  }

  public boolean isPretty() {
    return pretty;
  }

  public RenderingContext setPretty(boolean pretty) {
    this.pretty = pretty;
    return this;
  }

  public ITypeParser getParser() {
    return parser;
  }

  public RenderingContext setParser(ITypeParser parser) {
    this.parser = parser;
    return this;
  }

  public List<String> getCodeSystemPropList() {
    return codeSystemPropList;
  }

  public RenderingContext setCodeSystemPropList(List<String> codeSystemPropList) {
    this.codeSystemPropList = codeSystemPropList;
    return this;
  }

  public boolean isInlineGraphics() {
    return inlineGraphics;
  }

  public RenderingContext setInlineGraphics(boolean inlineGraphics) {
    this.inlineGraphics = inlineGraphics;
    return this;
  }

  public boolean isHeader() {
    return header;
  }

  public RenderingContext setHeader(boolean header) {
    this.header = header;
    return this;
  }

  public QuestionnaireRendererMode getQuestionnaireMode() {
    return questionnaireMode;
  }

  public RenderingContext setQuestionnaireMode(QuestionnaireRendererMode questionnaireMode) {
    this.questionnaireMode = questionnaireMode;
    return this;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public RenderingContext setSelfLink(String selfLink) {
    this.selfLink = selfLink;
    return this;
  }

  public String fixReference(String ref) {
    if (!Utilities.isAbsoluteUrl(ref)) {
      return (localPrefix == null ? "" : localPrefix) + ref;
    }
    if (ref.startsWith("http://hl7.org/fhir") && !ref.substring(20).contains("/")) {
      return specificationLink + ref.substring(20);
    }
    return ref;
  }

  public RenderingContext setLang(String lang) {
    this.lang = lang;
    return this;
  }

  public RenderingContext setLocalPrefix(String localPrefix) {
    this.localPrefix = localPrefix;
    return this;
  }

  public boolean isAddGeneratedNarrativeHeader() {
    return addGeneratedNarrativeHeader;
  }

  public RenderingContext setAddGeneratedNarrativeHeader(boolean addGeneratedNarrativeHeader) {
    this.addGeneratedNarrativeHeader = addGeneratedNarrativeHeader;
    return this;
  }

  public FhirPublication getTargetVersion() {
    return targetVersion;
  }

  public void setTargetVersion(FhirPublication targetVersion) {
    this.targetVersion = targetVersion;
  }

  public boolean isTechnicalMode() {
    return mode == ResourceRendererMode.TECHNICAL;
  }

  public boolean hasLocale() {
    return locale != null;
  }

  public Locale getLocale() {
    if (locale == null) {
      return Locale.getDefault();
    } else {
      return locale;
    }
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  /**
   * if the timezone is null, the rendering will default to the source timezone in
   * the resource
   * 
   * Note that if you're working server side, the FHIR project recommends the use
   * of the Date header so that clients know what timezone the server defaults to,
   * 
   * There is no standard way for the server to know what the client timezone is.
   * In the case where the client timezone is unknown, the timezone should be null
   *
   * @return the specified timezone to render in
   */
  public ZoneId getTimeZoneId() {
    return timeZoneId;
  }

  public void setTimeZoneId(ZoneId timeZoneId) {
    this.timeZoneId = timeZoneId;
  }

  /**
   * In the absence of a specified format, the renderers will default to the
   * FormatStyle.MEDIUM for the current locale.
   * 
   * @return the format to use
   */
  public DateTimeFormatter getDateTimeFormat() {
    return this.dateTimeFormat;
  }

  public void setDateTimeFormat(DateTimeFormatter dateTimeFormat) {
    this.dateTimeFormat = dateTimeFormat;
  }

  public void setDateTimeFormatString(String dateTimeFormat) {
    this.dateTimeFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
  }

  /**
   * In the absence of a specified format, the renderers will default to the
   * FormatStyle.MEDIUM for the current locale.
   * 
   * @return the format to use
   */
  public DateTimeFormatter getDateFormat() {
    return this.dateFormat;
  }

  public void setDateFormat(DateTimeFormatter dateFormat) {
    this.dateFormat = dateFormat;
  }

  public void setDateFormatString(String dateFormat) {
    this.dateFormat = DateTimeFormatter.ofPattern(dateFormat);
  }

  public DateTimeFormatter getDateYearFormat() {
    return dateYearFormat;
  }

  public void setDateYearFormat(DateTimeFormatter dateYearFormat) {
    this.dateYearFormat = dateYearFormat;
  }

  public void setDateYearFormatString(String dateYearFormat) {
    this.dateYearFormat = DateTimeFormatter.ofPattern(dateYearFormat);
  }

  public DateTimeFormatter getDateYearMonthFormat() {
    return dateYearMonthFormat;
  }

  public void setDateYearMonthFormat(DateTimeFormatter dateYearMonthFormat) {
    this.dateYearMonthFormat = dateYearMonthFormat;
  }

  public void setDateYearMonthFormatString(String dateYearMonthFormat) {
    this.dateYearMonthFormat = DateTimeFormatter.ofPattern(dateYearMonthFormat);
  }

  public ResourceRendererMode getMode() {
    return mode;
  }

  public void setMode(ResourceRendererMode mode) {
    this.mode = mode;
  }

  public boolean isContained() {
    return contained;
  }

  public void setContained(boolean contained) {
    this.contained = contained;
  }

}