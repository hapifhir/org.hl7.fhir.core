package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.profile.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.renderers.utils.Resolver.IReferenceResolver;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.validation.ValidationOptions;

/**
 * Managing Language when rendering 
 * 
 * You can specify a language to use when rendering resources by setting the setLocale() on 
 * the super class. The locale drives the following:
 * - choice of java supplied rendering phrase, if translations are provided for the locale 
 * - integer and date formats used (but see below for date formats)
 * - automatic translation of coded values, if language supplements are available
 * - choosing text representation considering the FHIR translation extension
 *    
 * By default, the locale is null, and the default locale for the underlying system is used. 
 * If you set locale to a specific value, then that value will be used instead of the default locale.
 *    
 * By default, only a single language is rendered, based on the locale. Where resources contain
 * multiple language content (designations in CodeSystem and ValueSet, or using the translation
 * extension), you can control what languages are presented using the properties multiLanguagePolicy
 * and languages
 * - multiLanguagePolicy: NONE (default), DESIGNATIONS, ALL
 * - languages: a list of allowed languages. Default is empty which means all languages in scope via multiLanguagePolicy
 * 
 * Managing Date/Time Formatting
 * 
 * This class has multiple parameters that influence date/time formatting when rendering resources 
 * 
 * - The default rendering is using the default java locale as above
 * - If you setLocale() to something, then the defaults for the locale will be used 
 * - Else you can set the values of dateTimeFormat, dateFormat, dateYearFormat and dateYearMonthFormat
 * 
 * If you set the value of locale, the values of dateTimeFormat, dateFormat, dateYearFormat and dateYearMonthFormat are 
 * reset to the system defaults 
 * 
 * Timezones: by default, date/times are rendered in their source timezone 
 * 
 */
public class RenderingContext extends RenderingI18nContext {

  // provides liquid templates, if they are available for the content
  public interface ILiquidTemplateProvider {
    String findTemplate(RenderingContext rcontext, DomainResource r);
    String findTemplate(RenderingContext rcontext, String resourceName);
  }

  // parses xml to an XML instance. Whatever codes provides this needs to provide something that parses the right version 
  public interface ITypeParser {
    Base parseType(String xml, String type) throws FHIRFormatError, IOException, FHIRException ;
    Base parseType(Element base) throws FHIRFormatError, IOException, FHIRException ;
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
     * The user has no interest in the contents of the FHIR resource, and just wants to see the data
     * 
     */
    END_USER,
    
    /**
     * The user wants to see the resource, but a technical view so they can see what's going on with the content
     */
    TECHNICAL
  }

  public enum GenerationRules {
    /**
     * The output must be valid XHTML for a resource: no active content, etc. The only external dependency allowed is fhir.css 
     */
    VALID_RESOURCE,
    
    /**
     * The output must be valid for an implementation guide according ot the base FHIR template. 
     * This means active content is allowed, though the default presentation must be *show everything* for balloting purposes
     * Active content is allowed 
     */
    IG_PUBLISHER
  }
  
  public enum StructureDefinitionRendererMode {
    SUMMARY, // 5 cells: tree/name | flags | cardinality | type | details
    BINDINGS, // tree/name + column for each kind of binding found, cells are lists of bindings 
    OBLIGATIONS, // tree/name + column for each actor that has obligations
    DATA_DICT,  // detailed element view 
  }

  public enum ExampleScenarioRendererMode {
    /**
     * A visual presentation of the questionnaire, with a set of property panes that can be toggled on and off.
     * Note that this is not the same as how the questionnaire would like on a form filler, since all dynamic behavior is ignored
     */
    ACTORS,

    /**
     * A table listing all the instances (and versions there-of) used in a scenario
     */
    INSTANCES,

    /**
     * Information about the processes (and sub-processes) defined in a scenario
     */
    PROCESSES,

    /**
     * A diagram showing interactions between the actors as part of the process steps
     */
    DIAGRAM
  }

  public enum QuestionnaireRendererMode {
    /**
     * A visual presentation of the questionnaire, with a set of property panes that can be toggled on and off.
     * Note that this is not the same as how the questionnaire would like on a form filler, since all dynamic behavior is ignored
     */
    FORM,

    /**
     * a structured tree that presents the content of the questionnaire in a logical fashion
     */
    TREE,   

    /**
     * A structured tree that presents the enableWhen, terminology and expression bindings for the questionnaire 
     */
    LOGIC,

    /**
     * A presentation that lists all the items, with full details about them 
     */
    DEFNS, 

    /**
     * Rendered links to various openly available Form Filler applications that know how to render a questionnaire published in a package 
     */
    LINKS
  }


  public enum KnownLinkType {
    SELF,  // absolute link to where the content is to be found (only used in a few circumstances when making external references to tools)
    SPEC,  // version specific link to core specification
    JSON_NAMES
    
  }
  
  public enum FixedValueFormat {
    JSON, JSON_ALL, XML, XML_ALL;

    public static FixedValueFormat fromCode(String value) {
      if (value == null) {
        return JSON;
      }
      switch (value.toLowerCase()) {
      case "json" : return JSON;
      case "json-all" : return JSON_ALL;
      case "xml" : return XML;
      case "xml-all" : return XML_ALL;
      }
      return JSON;
    }

    public boolean notPrimitives() {
      return this == JSON || this == XML;
    }

    public boolean isXml() {
      return this == XML_ALL || this == XML;
    }
  }

  public enum MultiLanguagePolicy {
    NONE, // ONLY render the language in the locale
    DESIGNATIONS,  // in addition to the locale language, render designations from other languages (eg. as found in code systems and value sets
    ALL // in addition to translations in designations, look for an render translations (WIP)
  }

  private IWorkerContext worker;
  private MarkDownProcessor markdown;
  private ResourceRendererMode mode;
  private GenerationRules rules;
  private IReferenceResolver resolver;
  private ILiquidTemplateProvider templateProvider;
  private IEvaluationContext services;
  private ITypeParser parser;

  // i18n related fields
  private MultiLanguagePolicy multiLanguagePolicy = MultiLanguagePolicy.NONE;
  private Set<String> allowedLanguages = new HashSet<>(); 
  private ZoneId timeZoneId;
  private DateTimeFormatter dateTimeFormat;
  private DateTimeFormatter dateFormat;
  private DateTimeFormatter dateYearFormat;
  private DateTimeFormatter dateYearMonthFormat;
  
  private String localPrefix; // relative link within local context
  private int headerLevelContext;
  private boolean canonicalUrlsAsLinks;
  private boolean pretty;
  private boolean header;
  private boolean contained;

  private ValidationOptions terminologyServiceOptions = new ValidationOptions(FhirPublication.R5);
  private boolean noSlowLookup;
  private List<String> codeSystemPropList = new ArrayList<>();

  private ProfileUtilities profileUtilitiesR;
  private String definitionsTarget;
  private String destDir;
  private boolean inlineGraphics;
  private StandardsStatus defaultStandardsStatus;

  private ExampleScenarioRendererMode scenarioMode = null;
  private QuestionnaireRendererMode questionnaireMode = QuestionnaireRendererMode.FORM;
  private StructureDefinitionRendererMode structureMode = StructureDefinitionRendererMode.SUMMARY;
  private FixedValueFormat fixedFormat = FixedValueFormat.JSON;
  
  private boolean addGeneratedNarrativeHeader = true;
  private boolean showComments = false;

  private FhirPublication targetVersion;
  private boolean copyButton;
  private ProfileKnowledgeProvider pkp;
  private String changeVersion;
  private List<String> files = new ArrayList<String>(); // files created as by-products in destDir
  
  private Map<KnownLinkType, String> links = new HashMap<>();
  private Map<String, String> namedLinks = new HashMap<>();
  private boolean addName = false;
  private Map<String, String> typeMap = new HashMap<>(); // type aliases that can be resolved in Markdown type links (mainly for cross-version usage)
  
  /**
   * 
   * @param context - access to all related resources that might be needed
   * @param markdown - appropriate markdown processing engine 
   * @param terminologyServiceOptions - options to use when looking up codes
   * @param specLink - path to FHIR specification
   * @param locale - i18n for rendering
   */
  public RenderingContext(IWorkerContext worker, MarkDownProcessor markdown, ValidationOptions terminologyServiceOptions, String specLink, String localPrefix, Locale locale, ResourceRendererMode mode, GenerationRules rules) {
    super();
    this.worker = worker;
    this.markdown = markdown;
    this.locale = locale;
    this.links.put(KnownLinkType.SPEC, specLink);
    this.localPrefix = localPrefix;
    this.mode = mode;
    this.rules = rules;
    if (terminologyServiceOptions != null) {
      this.terminologyServiceOptions = terminologyServiceOptions;
    }
  }
  
  public RenderingContext copy() {
    RenderingContext res = new RenderingContext(worker, markdown, terminologyServiceOptions, getLink(KnownLinkType.SPEC), localPrefix, locale, mode, rules);

    res.resolver = resolver;
    res.templateProvider = templateProvider;
    res.services = services;
    res.parser = parser;

    res.headerLevelContext = headerLevelContext;
    res.canonicalUrlsAsLinks = canonicalUrlsAsLinks;
    res.pretty = pretty;
    res.contained = contained;
    
    res.noSlowLookup = noSlowLookup;
    res.codeSystemPropList.addAll(codeSystemPropList);

    res.profileUtilitiesR = profileUtilitiesR;
    res.definitionsTarget = definitionsTarget;
    res.destDir = destDir;
    res.addGeneratedNarrativeHeader = addGeneratedNarrativeHeader;
    res.scenarioMode = scenarioMode;
    res.questionnaireMode = questionnaireMode;
    res.structureMode = structureMode;
    res.header = header;
    res.links.putAll(links);
    res.inlineGraphics = inlineGraphics;
    res.timeZoneId = timeZoneId;
    res.dateTimeFormat = dateTimeFormat;
    res.dateFormat = dateFormat;
    res.dateYearFormat = dateYearFormat;
    res.dateYearMonthFormat = dateYearMonthFormat;
    res.targetVersion = targetVersion;
    res.showComments = showComments;
    res.copyButton = copyButton;
    res.pkp = pkp;
    res.defaultStandardsStatus = defaultStandardsStatus;
    res.changeVersion = changeVersion;

    res.terminologyServiceOptions = terminologyServiceOptions.copy();
    res.typeMap.putAll(typeMap);
    res.multiLanguagePolicy = multiLanguagePolicy;
    res.allowedLanguages.addAll(allowedLanguages);
    return res;
  }
  

  public IWorkerContext getContext() {
    return worker;
  }


  
  // -- 2. Markdown support -------------------------------------------------------

  public ProfileUtilities getProfileUtilities() {
    if (profileUtilitiesR == null) {
      profileUtilitiesR = new ProfileUtilities(worker, null, pkp);
    }
    return profileUtilitiesR;
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

  public MultiLanguagePolicy getMultiLanguagePolicy() {
    return multiLanguagePolicy;
  }

  public void setMultiLanguagePolicy(MultiLanguagePolicy multiLanguagePolicy) {
    this.multiLanguagePolicy = multiLanguagePolicy;
  }

  public Set<String> getAllowedLanguages() {
    return allowedLanguages;
  }

  public String getLocalPrefix() {
    return localPrefix;
  }

  public ValidationOptions getTerminologyServiceOptions() {
    return terminologyServiceOptions;
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
    this.profileUtilitiesR = profileUtilities;
    if (pkp == null && profileUtilities.getPkp() != null) {
      pkp = profileUtilities.getPkp();
    }
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

  public ExampleScenarioRendererMode getScenarioMode() {
    return scenarioMode;
  }

  public RenderingContext setScenarioMode(ExampleScenarioRendererMode scenarioMode) {
    this.scenarioMode = scenarioMode;
    return this;
  }

  public QuestionnaireRendererMode getQuestionnaireMode() {
    return questionnaireMode;
  }

  public RenderingContext setQuestionnaireMode(QuestionnaireRendererMode questionnaireMode) {
    this.questionnaireMode = questionnaireMode;
    return this;
  }
  
  public StructureDefinitionRendererMode getStructureMode() {
    return structureMode;
  }

  public RenderingContext setStructureMode(StructureDefinitionRendererMode structureMode) {
    this.structureMode = structureMode;
    return this;
  }

  public String fixReference(String ref) {
    if (!Utilities.isAbsoluteUrl(ref)) {
      return (localPrefix == null ? "" : localPrefix)+ref;
    }
    if (ref.startsWith("http://hl7.org/fhir") && !ref.substring(20).contains("/")) {
      return getLink(KnownLinkType.SPEC)+ref.substring(20);
    }
    return ref;
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

  public RenderingContext setTargetVersion(FhirPublication targetVersion) {
    this.targetVersion = targetVersion;
    return this;
  }

  public boolean isTechnicalMode() {
    return mode == ResourceRendererMode.TECHNICAL;
  }

  /**
   * if the timezone is null, the rendering will default to the source timezone
   * in the resource
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

  public RenderingContext setTimeZoneId(ZoneId timeZoneId) {
    this.timeZoneId = timeZoneId;
    return this;
  }


  /**
   * In the absence of a specified format, the renderers will default to 
   * the FormatStyle.MEDIUM for the current locale.
   * 
   * @return the format to use
   */
  public DateTimeFormatter getDateTimeFormat() {
    return this.dateTimeFormat;
  }

  public RenderingContext setDateTimeFormat(DateTimeFormatter dateTimeFormat) {
    this.dateTimeFormat = dateTimeFormat;
    return this;
  }

  public RenderingContext setDateTimeFormatString(String dateTimeFormat) {
    this.dateTimeFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
    return this;
  }

  /**
   * In the absence of a specified format, the renderers will default to 
   * the FormatStyle.MEDIUM for the current locale.
   * 
   * @return the format to use
   */
  public DateTimeFormatter getDateFormat() {
    return this.dateFormat;
  }

  public RenderingContext setDateFormat(DateTimeFormatter dateFormat) {
    this.dateFormat = dateFormat;
    return this;
  }

  public RenderingContext setDateFormatString(String dateFormat) {
    this.dateFormat = DateTimeFormatter.ofPattern(dateFormat);
    return this;
  }

  public DateTimeFormatter getDateYearFormat() {
    return dateYearFormat;
  }

  public RenderingContext setDateYearFormat(DateTimeFormatter dateYearFormat) {
    this.dateYearFormat = dateYearFormat;
    return this;
  }

  public RenderingContext setDateYearFormatString(String dateYearFormat) {
    this.dateYearFormat = DateTimeFormatter.ofPattern(dateYearFormat);
    return this;
  }

  public DateTimeFormatter getDateYearMonthFormat() {
    return dateYearMonthFormat;
  }

  public RenderingContext setDateYearMonthFormat(DateTimeFormatter dateYearMonthFormat) {
    this.dateYearMonthFormat = dateYearMonthFormat;
    return this;
  }

  public RenderingContext setDateYearMonthFormatString(String dateYearMonthFormat) {
    this.dateYearMonthFormat = DateTimeFormatter.ofPattern(dateYearMonthFormat);
    return this;
  }

  public ResourceRendererMode getMode() {
    return mode;
  }

  public RenderingContext setMode(ResourceRendererMode mode) {
    this.mode = mode;
    return this;
  }

  public boolean isContained() {
    return contained;
  }

  public RenderingContext setContained(boolean contained) {
    this.contained = contained;
    return this;
  }
  public boolean isShowComments() {
    return showComments;
  }
  public RenderingContext setShowComments(boolean showComments) {
    this.showComments = showComments;
    return this;
  }
  public boolean isCopyButton() {
    return copyButton;
  }
  public RenderingContext setCopyButton(boolean copyButton) {
    this.copyButton = copyButton;
    return this;
  }
  
  public RenderingContext setPkp(ProfileKnowledgeProvider pkp) {
    this.pkp = pkp;
    return this;
  }
  public ProfileKnowledgeProvider getPkp() {
    return pkp;
  }
  
  public boolean hasLink(KnownLinkType link) {
    return links.containsKey(link);
  }
  
  public String getLink(KnownLinkType link) {
    return links.get(link);
  }
  public void addLink(KnownLinkType type, String link) {
    links.put(type, link);
    
  }
  public GenerationRules getRules() {
    return rules;
  }
  public RenderingContext setRules(GenerationRules rules) {
    this.rules = rules;
    return this;
  }
  public StandardsStatus getDefaultStandardsStatus() {
    return defaultStandardsStatus;
  }
  public RenderingContext setDefaultStandardsStatus(StandardsStatus defaultStandardsStatus) {
    this.defaultStandardsStatus = defaultStandardsStatus;
    return this;
  }

  public String getChangeVersion() {
    return changeVersion;
  }

  public RenderingContext setChangeVersion(String changeVersion) {
    this.changeVersion = changeVersion;
    return this;
  }

  public Map<String, String> getNamedLinks() {
    return namedLinks;
  }

  public void registerFile(String n) {
    try {
      files.add(Utilities.path(destDir, n));
    } catch (IOException e) {
    }
  }

  public List<String> getFiles() {
    return files;
  }

  public FixedValueFormat getFixedFormat() {
    return fixedFormat;
  }

  public void setFixedFormat(FixedValueFormat fixedFormat) {
    this.fixedFormat = fixedFormat;
  }

  public boolean isAddName() {
    return addName;
  }

  public RenderingContext setAddName(boolean addName) {
    this.addName = addName;
    return this;
  }

  public Map<String, String> getTypeMap() {
    return typeMap;
  }


  public String toStr(int v) {
    NumberFormat nf = NumberFormat.getInstance(locale);
    return nf.format(v);
  }


  public String getTranslated(PrimitiveType<?> t) {
    if (locale != null) {
      String v = ToolingExtensions.getLanguageTranslation(t, locale.toString());
      if (v != null) {
        return v;
      }
    }
    return t.asStringValue();
  }

  public StringType getTranslatedElement(PrimitiveType<?> t) {
    if (locale != null) {
      StringType v = ToolingExtensions.getLanguageTranslationElement(t, locale.toString());
      if (v != null) {
        return v;
      }
    }
    if (t instanceof StringType) {
      return (StringType) t;
    } else {
      return new StringType(t.asStringValue());
    }
  }

  public String getTranslatedCode(Base b, String codeSystem) {

    if (b instanceof org.hl7.fhir.r5.model.Element) {
      org.hl7.fhir.r5.model.Element e = (org.hl7.fhir.r5.model.Element) b;
      if (locale != null) {
        String v = ToolingExtensions.getLanguageTranslation(e, locale.toString());
        if (v != null) {
          return v;
        }
        // no? then see if the tx service can translate it for us 
        try {
          ValidationResult t = getContext().validateCode(getTerminologyServiceOptions().withLanguage(locale.toString()).withVersionFlexible(true),
              codeSystem, null, e.primitiveValue(), null);
          if (t.isOk() && t.getDisplay() != null) {
            return t.getDisplay();
          }
        } catch (Exception ex) {
          // nothing
        }
      }
      if (e instanceof Enumeration<?>) {
        return ((Enumeration<?>) e).getDisplay();
      } else {
        return e.primitiveValue();
      }
    } else if (b instanceof Element) {
      return getTranslatedCode((Element) b, codeSystem);
    } else {
      return "??";
    }
  }

  public String getTranslatedCode(Enumeration<?> e, String codeSystem) {
    if (locale != null) {
      String v = ToolingExtensions.getLanguageTranslation(e, locale.toString());
      if (v != null) {
        return v;
      }
      // no? then see if the tx service can translate it for us 
      try {
        ValidationResult t = getContext().validateCode(getTerminologyServiceOptions().withLanguage(locale.toString()).withVersionFlexible(true),
            codeSystem, null, e.getCode(), null);
        if (t.isOk() && t.getDisplay() != null) {
          return t.getDisplay();
        }
      } catch (Exception ex) {
        // nothing
      }
    }
    try {
      ValidationResult t = getContext().validateCode(getTerminologyServiceOptions().withVersionFlexible(true),
          codeSystem, null, e.getCode(), null);
      if (t.isOk() && t.getDisplay() != null) {
        return t.getDisplay();
      }
    } catch (Exception ex) {
      // nothing
    }
    
    return e.getCode();
  }
  
  public String getTranslatedCode(Element e, String codeSystem) {
    if (locale != null) {
      // first we look through the translation extensions
      for (Element ext : e.getChildrenByName("extension")) {
        String url = ext.getNamedChildValue("url");
        if (url.equals(ToolingExtensions.EXT_TRANSLATION)) {
          Base e1 = ext.getExtensionValue("lang");

          if (e1 != null && e1.primitiveValue() != null && e1.primitiveValue().equals(locale.toString())) {
            e1 = ext.getExtensionValue("content");
            if (e1 != null && e1.isPrimitive()) {
              return e1.primitiveValue();
            }
          }
        }
      }
      // no? then see if the tx service can translate it for us 
      try {
        ValidationResult t = getContext().validateCode(getTerminologyServiceOptions().withLanguage(locale.toString()).withVersionFlexible(true),
            codeSystem, null, e.primitiveValue(), null);
        if (t.isOk() && t.getDisplay() != null) {
          return t.getDisplay();
        }
      } catch (Exception ex) {
        // nothing
      }
    }
    return e.primitiveValue();
  }
  
}