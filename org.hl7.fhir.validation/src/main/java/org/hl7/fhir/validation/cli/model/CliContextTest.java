package org.hl7.fhir.validation.cli.model;

/**
 * A POJO for storing the flags/values for the CLI validator.
 */
public class CliContextTest {

  private boolean doNative = false;
  private boolean anyExtensionsAllowed = true;
  private boolean hintAboutNonMustSupport = false;
  private boolean recursive = false;
  private boolean doDebug = false;
  private boolean assumeValidRestReferences = false;

  public boolean isDoNative() {
    return doNative;
  }

  public CliContextTest setDoNative(boolean doNative) {
    this.doNative = doNative;
    return this;
  }

  public boolean isAnyExtensionsAllowed() {
    return anyExtensionsAllowed;
  }

  public CliContextTest setAnyExtensionsAllowed(boolean anyExtensionsAllowed) {
    this.anyExtensionsAllowed = anyExtensionsAllowed;
    return this;
  }

  public boolean isHintAboutNonMustSupport() {
    return hintAboutNonMustSupport;
  }

  public CliContextTest setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
    return this;
  }

  public boolean isRecursive() {
    return recursive;
  }

  public CliContextTest setRecursive(boolean recursive) {
    this.recursive = recursive;
    return this;
  }

  public boolean isDoDebug() {
    return doDebug;
  }

  public CliContextTest setDoDebug(boolean doDebug) {
    this.doDebug = doDebug;
    return this;
  }

  public boolean isAssumeValidRestReferences() {
    return assumeValidRestReferences;
  }

  public CliContextTest setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
    return this;
  }

  @Override
  public String toString() {
    return "CliContext{" +
      ", doNative=" + doNative +
      ", anyExtensionsAllowed=" + anyExtensionsAllowed +
      ", hintAboutNonMustSupport=" + hintAboutNonMustSupport +
      ", recursive=" + recursive +
      ", doDebug=" + doDebug +
      ", assumeValidRestReferences=" + assumeValidRestReferences +
      '}';
  }
}