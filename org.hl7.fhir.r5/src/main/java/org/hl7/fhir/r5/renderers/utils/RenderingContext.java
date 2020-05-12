package org.hl7.fhir.r5.renderers.utils;

import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.IReferenceResolver;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.validation.ValidationOptions;

public class RenderingContext {

  public enum ResourceRendererMode{
    RESOURCE, IG
  }

  protected IWorkerContext worker;
  protected MarkDownProcessor markdown;
  protected String lang;
  protected String prefix;
  protected ValidationOptions terminologyServiceOptions;
  protected ProfileUtilities profileUtilities;
  private boolean canonicalUrlsAsLinks;
  protected ResourceRendererMode mode;
  private IReferenceResolver resolver;
  private int headerLevelContext;
  private String tooCostlyNoteEmpty;
  private String tooCostlyNoteNotEmpty;
  private String tooCostlyNoteEmptyDependent;
  private String tooCostlyNoteNotEmptyDependent;
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

  public void setCanonicalUrlsAsLinks(boolean canonicalUrlsAsLinks) {
    this.canonicalUrlsAsLinks = canonicalUrlsAsLinks;
  }

  public MarkDownProcessor getMarkdown() {
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

  public void setTooCostlyNoteEmpty(String tooCostlyNoteEmpty) {
    this.tooCostlyNoteEmpty = tooCostlyNoteEmpty;
  }

  public String getTooCostlyNoteNotEmpty() {
    return tooCostlyNoteNotEmpty;
  }

  public void setTooCostlyNoteNotEmpty(String tooCostlyNoteNotEmpty) {
    this.tooCostlyNoteNotEmpty = tooCostlyNoteNotEmpty;
  }

  public String getTooCostlyNoteEmptyDependent() {
    return tooCostlyNoteEmptyDependent;
  }

  public void setTooCostlyNoteEmptyDependent(String tooCostlyNoteEmptyDependent) {
    this.tooCostlyNoteEmptyDependent = tooCostlyNoteEmptyDependent;
  }

  public String getTooCostlyNoteNotEmptyDependent() {
    return tooCostlyNoteNotEmptyDependent;
  }

  public void setTooCostlyNoteNotEmptyDependent(String tooCostlyNoteNotEmptyDependent) {
    this.tooCostlyNoteNotEmptyDependent = tooCostlyNoteNotEmptyDependent;
  }

  public int getHeaderLevelContext() {
    return headerLevelContext;
  }

  public void setHeaderLevelContext(int headerLevelContext) {
    this.headerLevelContext = headerLevelContext;
  }

  public IReferenceResolver getResolver() {
    return resolver;
  }

  public void setResolver(IReferenceResolver resolver) {
    this.resolver = resolver;
  }

  public void setTerminologyServiceOptions(ValidationOptions terminologyServiceOptions) {
    this.terminologyServiceOptions = terminologyServiceOptions;
  }
  
  
}