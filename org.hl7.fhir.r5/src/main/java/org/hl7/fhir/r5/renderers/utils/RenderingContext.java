package org.hl7.fhir.r5.renderers.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ProfileUtilities.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.renderers.utils.Resolver.IReferenceResolver;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.validation.ValidationOptions;

public class RenderingContext {

  public interface ILiquidTemplateProvider {
    String findTemplate(RenderingContext rcontext, DomainResource r);
    String findTemplate(RenderingContext rcontext, String resourceName);
  }
  
  public interface ITypeParser {
    Base parseType(String xml, String type) throws FHIRFormatError, IOException, FHIRException ;
  }
  
  public enum ResourceRendererMode{
    RESOURCE, IG
  }

  protected IWorkerContext worker;
  protected MarkDownProcessor markdown;
  protected ResourceRendererMode mode;
  private IReferenceResolver resolver;
  private ILiquidTemplateProvider templateProvider;
  private IEvaluationContext services;
  private ITypeParser parser;

  protected String lang;
  protected String prefix;
  private int headerLevelContext;
  private boolean canonicalUrlsAsLinks;
  private boolean pretty;
  private boolean header;

  protected ValidationOptions terminologyServiceOptions;
  private boolean noSlowLookup;
  private String tooCostlyNoteEmpty;
  private String tooCostlyNoteNotEmpty;
  private String tooCostlyNoteEmptyDependent;
  private String tooCostlyNoteNotEmptyDependent;
  private List<String> codeSystemPropList = new ArrayList<>();

  protected ProfileUtilities profileUtilities;
  private String definitionsTarget;
  private String destDir;
  private boolean inlineGraphics;
  

  /**
   * 
   * @param context - access to all related resources that might be needed
   * @param markdown - appropriate markdown processing engine 
   * @param terminologyServiceOptions - options to use when looking up codes
   * @param prefix - path to FHIR specification
   * @param lang - langauage to render in
   */
  public RenderingContext(IWorkerContext worker, MarkDownProcessor markdown, ValidationOptions terminologyServiceOptions, String prefix, String lang, ResourceRendererMode mode) {
    super();
    this.worker = worker;
    this.markdown = markdown;
    this.lang = lang;
    this.prefix = prefix;
    this.mode = mode;
    this.terminologyServiceOptions = terminologyServiceOptions;
    profileUtilities = new ProfileUtilities(worker, null, null);
  }

  public IWorkerContext getContext() {
    return worker;
  }

  // -- 2. Markdown support -------------------------------------------------------

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

  public String getPrefix() {
    return prefix;
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

  public RenderingContext copy() {
    RenderingContext res = new RenderingContext(worker, markdown, terminologyServiceOptions, prefix, lang, mode);

    res.resolver = resolver;
    res.templateProvider = templateProvider;
    res.services = services;
    res.parser = parser;

    res.headerLevelContext = headerLevelContext;
    res.canonicalUrlsAsLinks = canonicalUrlsAsLinks;
    res.pretty = pretty;

    res.noSlowLookup = noSlowLookup;
    res.tooCostlyNoteEmpty = tooCostlyNoteEmpty;
    res.tooCostlyNoteNotEmpty = tooCostlyNoteNotEmpty;
    res.tooCostlyNoteEmptyDependent = tooCostlyNoteEmptyDependent;
    res.tooCostlyNoteNotEmptyDependent = tooCostlyNoteNotEmptyDependent;
    res.codeSystemPropList.addAll(codeSystemPropList);

    res.profileUtilities = profileUtilities;
    res.definitionsTarget = definitionsTarget;
    res.destDir = destDir;

    return res;
  }

  public boolean isInlineGraphics() {
    return inlineGraphics;
  }

  public void setInlineGraphics(boolean inlineGraphics) {
    this.inlineGraphics = inlineGraphics;
  }

  public boolean isHeader() {
    return header;
  }

  public void setHeader(boolean header) {
    this.header = header;
  }
  


}