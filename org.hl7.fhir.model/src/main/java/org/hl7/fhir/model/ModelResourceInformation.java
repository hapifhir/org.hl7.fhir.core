package org.hl7.fhir.model;

import lombok.Getter;
import org.hl7.fhir.model.core.formats.ParserBase;

public class ModelResourceInformation {

  /**
   * The name of the resource e.g. TestPlan
   */
  @Getter
  private String name;

  /**
   * The package name it came from e.g. hl7.fhir.uv.testing@0.1.0
   */
  @Getter
  private String packageName;

  /**
   * true if this is intended to override the core resource
   * <p>
   * THis is sometimes needed if you want to support incubation versions of core resources
   */
  @Getter
  private boolean overrides = false;
  /**
   * The custom resource handler, which is responsible for creating and parsing, and serialising
   * <p>
   * this is null for core resources
   */
  @Getter
  private ParserBase.CustomResourceHandler handler;

  /** lazily built, then immutable - the registration is never mutated after construction */
  private String canonicalKey;

  public ModelResourceInformation(String name, String packageName, boolean overrides, ParserBase.CustomResourceHandler handler) {
    this.name = name;
    this.packageName = packageName;
    this.overrides = overrides;
    this.handler = handler;
  }

  /**
   * check if the registrations are the same
   * <p>
   * this is a value comparison, not an identity comparison: two contexts that registered the
   * same package independently get different ModelResourceInformation and CustomResourceHandler
   * instances, but they are the same registration, and the objects they produce are
   * interchangeable
   *
   * @param mri
   * @return
   */
  public boolean matches(ModelResourceInformation mri) {
    return mri != null && canonicalKey().equals(mri.canonicalKey());
  }

  /**
   * A stable string that captures everything that makes this registration meaningfully
   * different from another one. Two registrations with the same key are interchangeable
   * <p>
   * The handler is identified by the class of its parser factory rather than by object
   * identity, because every call to a generated XXXRegistration.register() constructs a fresh
   * factory and a fresh handler. The factory classes are stateless, so the class (and the
   * overridesBase flag, which is the only state the handler carries) is what actually matters.
   * Note that the class name is not enough on its own if the same class can be loaded by two
   * different class loaders - the loader identity is folded in for that case
   */
  String canonicalKey() {
    if (canonicalKey == null) {
      StringBuilder b = new StringBuilder();
      b.append(name).append('|').append(packageName).append('|').append(overrides ? '1' : '0').append('|');
      if (handler == null) {
        b.append('-');
      } else {
        Class<?> fc = handler.getFactory().getClass();
        b.append(fc.getName()).append('@');
        b.append(fc.getClassLoader() == null ? "boot" : Integer.toHexString(System.identityHashCode(fc.getClassLoader())));
        b.append('/').append(handler.isOverridesBase() ? '1' : '0');
      }
      canonicalKey = b.toString();
    }
    return canonicalKey;
  }
}
