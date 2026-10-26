package org.hl7.fhir.validation.instance.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.Enumerations.BindingStrength;
import org.hl7.fhir.model.core.ImplementationGuide;
import org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDefinitionResourceComponent;
import org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideDependsOnComponent;
import org.hl7.fhir.model.core.ImplementationGuide.ImplementationGuideGlobalComponent;
import org.hl7.fhir.model.core.PackageInformation;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.model.core.TypeConvertor;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.terminology.ValidationResult;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationOptions;

/**
 * Works out which profiles an implementation guide makes apply to a resource, for FHIRPath conformsTo() when it names an
 * IG rather than a profile (an extension to the FHIR specification's definition of conformsTo()). The IG is named by its
 * canonical URL (optionally |version) or by its package id (optionally #version), and must already be loaded.
 *
 * A profile applies to a resource when, in the IG or any of its dependencies (as far as they are loaded):
 * <ul>
 *   <li>it is a global profile for the resource's type, or</li>
 *   <li>it is a profile on the resource's type that constrains the resource's code (code, vaccineCode or medication), and
 *   the resource's code meets every one of those constraints. The constraints are: a fixed or pattern CodeableConcept on
 *   the code (each of its codings must be in the resource's code); a required binding on the code (the code must be in the
 *   value set); and slices on code.coding with min &gt;= 1 that fix (or pattern) a Coding, or its system (and code) - the
 *   resource's code must have a coding with that system (and code) - or that have a required binding</li>
 * </ul>
 *
 * (An IG can also map profiles to resources with the profile-mapping extension; no IG does that yet, so it is ignored.)
 *
 * What an IG contributes is worked out once per IG and kept: the IGs don't change while a validator is in use.
 */
public class ImplementationGuideProfileSelector {

  private static final String[] CODE_ELEMENTS = { "code", "vaccineCode", "medication" };

  private final IWorkerContext context;
  private final ProfileUtilities profileUtilities;

  private final Map<ImplementationGuide, List<ImplementationGuide>> closures = new IdentityHashMap<>();
  private final Map<ImplementationGuide, List<StructureDefinition>> igProfiles = new IdentityHashMap<>();
  private final Map<StructureDefinition, List<CodeConstraint>> constraints = new IdentityHashMap<>();
  private List<StructureDefinition> allProfiles;

  public ImplementationGuideProfileSelector(IWorkerContext context, ProfileUtilities profileUtilities) {
    this.context = context;
    this.profileUtilities = profileUtilities;
  }

  /**
   * Find the IG named by a URL (with |version or not) or a package id (with #version or not); null if none is loaded.
   */
  public ImplementationGuide findImplementationGuide(String ref) {
    if (Utilities.noString(ref)) {
      return null;
    }
    if (Utilities.isAbsoluteUrl(ref)) {
      return context.fetchResource(ImplementationGuide.class, ref, VersionResolutionRules.defaultRule());
    }
    String id = ref.contains("#") ? ref.substring(0, ref.indexOf('#')) : ref;
    String version = ref.contains("#") ? ref.substring(ref.indexOf('#') + 1) : null;
    return findByPackage(id, version);
  }

  /**
   * The profiles the IG makes apply to the resource, each once
   */
  public List<StructureDefinition> profilesFor(ImplementationGuide ig, Base resource, ValidationOptions options) {
    Map<String, StructureDefinition> result = new LinkedHashMap<>();
    String type = resource.fhirType();
    List<CodeableConcept> codes = null;
    for (ImplementationGuide g : closure(ig)) {
      for (ImplementationGuideGlobalComponent gl : g.getGlobalList()) {
        if (type.equals(gl.getType())) {
          StructureDefinition sd = profileUtilities.findProfile(gl.getProfileElement(), g);
          if (sd != null) {
            result.putIfAbsent(sd.getVersionedUrl(), sd);
          }
        }
      }
      for (StructureDefinition sd : profilesOf(g)) {
        if (type.equals(sd.getType()) && !result.containsKey(sd.getVersionedUrl())) {
          List<CodeConstraint> cl = codeConstraints(sd);
          if (!cl.isEmpty()) {
            if (codes == null) {
              codes = codes(resource);
            }
            if (meetsAll(cl, codes, options)) {
              result.put(sd.getVersionedUrl(), sd);
            }
          }
        }
      }
    }
    return new ArrayList<>(result.values());
  }

  // --- finding IGs -------------------------------------------------------------------------

  private ImplementationGuide findByPackage(String id, String version) {
    ImplementationGuide best = null;
    for (ImplementationGuide ig : context.fetchResourcesByType(ImplementationGuide.class)) {
      PackageInformation pi = ig.getSourcePackage();
      boolean idMatches = id.equals(ig.getPackageId()) || (pi != null && id.equals(pi.getId()));
      if (idMatches && (version == null || version.equals(ig.getVersion()) || (pi != null && version.equals(pi.getVersion())))) {
        if (best == null || isLater(ig.getVersion(), best.getVersion())) {
          best = ig;
        }
      }
    }
    return best;
  }

  private boolean isLater(String v1, String v2) {
    if (v1 == null || v2 == null) {
      return v1 != null;
    }
    try {
      return VersionUtilities.compareVersions(v1, v2) > 0;
    } catch (Exception e) {
      return v1.compareTo(v2) > 0;
    }
  }

  /** the IG and the IGs it depends on, recursively, as far as they are loaded */
  private List<ImplementationGuide> closure(ImplementationGuide ig) {
    List<ImplementationGuide> list = closures.get(ig);
    if (list == null) {
      list = new ArrayList<>();
      Set<ImplementationGuide> seen = Collections.newSetFromMap(new IdentityHashMap<>());
      addToClosure(ig, list, seen);
      closures.put(ig, list);
    }
    return list;
  }

  private void addToClosure(ImplementationGuide ig, List<ImplementationGuide> list, Set<ImplementationGuide> seen) {
    if (ig == null || !seen.add(ig)) {
      return;
    }
    list.add(ig);
    for (ImplementationGuideDependsOnComponent dep : ig.getDependsOnList()) {
      ImplementationGuide d = null;
      if (dep.hasPackageId()) {
        d = findByPackage(dep.getPackageId(), dep.hasVersion() ? dep.getVersion() : null);
      }
      if (d == null && dep.hasUri()) {
        d = context.fetchResource(ImplementationGuide.class, dep.hasVersion() ? dep.getUri() + "|" + dep.getVersion() : dep.getUri(), VersionResolutionRules.defaultRule());
      }
      addToClosure(d, list, seen);
    }
  }

  /**
   * The profiles an IG defines: those from its package, or, when it wasn't loaded from a package, the
   * StructureDefinitions its definition lists
   */
  private List<StructureDefinition> profilesOf(ImplementationGuide ig) {
    List<StructureDefinition> list = igProfiles.get(ig);
    if (list == null) {
      list = new ArrayList<>();
      PackageInformation pi = ig.getSourcePackage();
      if (pi != null) {
        for (StructureDefinition sd : allProfiles()) {
          PackageInformation spi = sd.getSourcePackage();
          if (spi != null && pi.getId().equals(spi.getId()) && Utilities.noString(pi.getVersion()) == Utilities.noString(spi.getVersion())
              && (Utilities.noString(pi.getVersion()) || pi.getVersion().equals(spi.getVersion()))) {
            list.add(sd);
          }
        }
      } else {
        String base = ig.hasUrl() && ig.getUrl().contains("/ImplementationGuide/") ? ig.getUrl().substring(0, ig.getUrl().indexOf("/ImplementationGuide/")) : null;
        for (ImplementationGuideDefinitionResourceComponent r : ig.getDefinition().getResourceList()) {
          String ref = r.getReference().getReference();
          if (base != null && ref != null && ref.startsWith("StructureDefinition/")) {
            StructureDefinition sd = context.fetchResource(StructureDefinition.class, base + "/" + ref, VersionResolutionRules.defaultRule());
            if (sd != null && sd.getDerivation() == TypeDerivationRule.CONSTRAINT && sd.hasSnapshot()) {
              list.add(sd);
            }
          }
        }
      }
      igProfiles.put(ig, list);
    }
    return list;
  }

  private List<StructureDefinition> allProfiles() {
    if (allProfiles == null) {
      allProfiles = new ArrayList<>();
      for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
        if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
          if (!sd.hasSnapshot()) {
            // fetching it by url is what makes the context generate its snapshot
            StructureDefinition f = context.fetchResource(StructureDefinition.class, sd.getVersionedUrl(), VersionResolutionRules.defaultRule());
            sd = f != null ? f : sd;
          }
          if (sd.hasSnapshot()) {
            allProfiles.add(sd);
          }
        }
      }
    }
    return allProfiles;
  }

  // --- constraints on the code -------------------------------------------------------------

  private enum ConstraintKind { CONCEPT, CODING, VALUESET }

  /** one rule a profile makes about a resource's code */
  private static class CodeConstraint {
    private final ConstraintKind kind;
    private final List<Coding> codings; // CONCEPT: all of them must be present; CODING: just the one (code may be null)
    private final String valueSet;      // VALUESET

    private CodeConstraint(ConstraintKind kind, List<Coding> codings, String valueSet) {
      this.kind = kind;
      this.codings = codings;
      this.valueSet = valueSet;
    }
  }

  /** the rules a profile makes about the resource's code; empty if it makes none */
  private List<CodeConstraint> codeConstraints(StructureDefinition sd) {
    List<CodeConstraint> list = constraints.get(sd);
    if (list == null) {
      list = new ArrayList<>();
      String type = sd.getType();
      List<String> conceptPaths = new ArrayList<>();
      for (String n : CODE_ELEMENTS) {
        if ("medication".equals(n)) {
          conceptPaths.add(type + ".medication[x]");
          conceptPaths.add(type + ".medication.concept");
        } else {
          conceptPaths.add(type + "." + n);
        }
      }
      List<ElementDefinition> elements = sd.getSnapshot().getElementList();
      for (ElementDefinition ed : elements) {
        String path = ed.getPath();
        if (conceptPaths.contains(path) && (!ed.hasSliceName() || path.endsWith("[x]"))) {
          addConceptConstraints(list, ed);
        } else if (path.endsWith(".coding") && conceptPaths.contains(path.substring(0, path.length() - 7)) && ed.hasSliceName() && ed.getMin() >= 1) {
          addSliceConstraints(list, ed, elements);
        }
      }
      constraints.put(sd, list);
    }
    return list;
  }

  private void addConceptConstraints(List<CodeConstraint> list, ElementDefinition ed) {
    DataType v = ed.hasFixed() ? ed.getFixed() : ed.hasPattern() ? ed.getPattern() : null;
    if (v instanceof CodeableConcept) {
      List<Coding> codings = new ArrayList<>();
      for (Coding c : ((CodeableConcept) v).getCodingList()) {
        if (c.hasSystem() && c.hasCode()) {
          codings.add(c);
        }
      }
      if (!codings.isEmpty()) {
        list.add(new CodeConstraint(ConstraintKind.CONCEPT, codings, null));
      }
    }
    addRequiredBinding(list, ed);
  }

  private void addSliceConstraints(List<CodeConstraint> list, ElementDefinition slice, List<ElementDefinition> elements) {
    DataType v = slice.hasFixed() ? slice.getFixed() : slice.hasPattern() ? slice.getPattern() : null;
    String system = null;
    String code = null;
    if (v instanceof Coding) {
      system = ((Coding) v).getSystem();
      code = ((Coding) v).getCode();
    } else {
      String prefix = slice.getId() + ".";
      for (ElementDefinition ed : elements) {
        if (ed.hasId() && ed.getId().startsWith(prefix)) {
          String rest = ed.getId().substring(prefix.length());
          DataType cv = ed.hasFixed() ? ed.getFixed() : ed.hasPattern() ? ed.getPattern() : null;
          if (cv != null && cv.isPrimitive()) {
            if ("system".equals(rest)) {
              system = cv.primitiveValue();
            } else if ("code".equals(rest)) {
              code = cv.primitiveValue();
            }
          }
        }
      }
    }
    if (!Utilities.noString(system)) {
      Coding c = new Coding().setSystem(system);
      if (!Utilities.noString(code)) {
        c.setCode(code);
      }
      List<Coding> codings = new ArrayList<>();
      codings.add(c);
      list.add(new CodeConstraint(ConstraintKind.CODING, codings, null));
    }
    addRequiredBinding(list, slice);
  }

  private void addRequiredBinding(List<CodeConstraint> list, ElementDefinition ed) {
    if (ed.hasBinding() && ed.getBinding().getStrength() == BindingStrength.REQUIRED && ed.getBinding().hasValueSet()) {
      list.add(new CodeConstraint(ConstraintKind.VALUESET, null, ed.getBinding().getValueSet()));
    }
  }

  // --- the resource's code -----------------------------------------------------------------

  /** the resource's code: its code, vaccineCode or medication (a CodeableConcept, or a CodeableReference's concept) */
  private List<CodeableConcept> codes(Base resource) {
    List<CodeableConcept> result = new ArrayList<>();
    for (String name : CODE_ELEMENTS) {
      for (Base v : children(resource, name)) {
        Base cc = null;
        if ("CodeableConcept".equals(v.fhirType())) {
          cc = v;
        } else if ("CodeableReference".equals(v.fhirType())) {
          List<Base> l = children(v, "concept");
          cc = l.isEmpty() ? null : l.get(0);
        }
        if (cc != null) {
          result.add(TypeConvertor.castToCodeableConcept(cc));
        }
      }
    }
    return result;
  }

  private List<Base> children(Base item, String name) {
    try {
      return item.getChildValues(name, false);
    } catch (FHIRException e) {
      return new ArrayList<>();
    }
  }

  private boolean meetsAll(List<CodeConstraint> list, List<CodeableConcept> codes, ValidationOptions options) {
    if (codes.isEmpty()) {
      return false;
    }
    for (CodeConstraint c : list) {
      if (!meets(c, codes, options)) {
        return false;
      }
    }
    return true;
  }

  private boolean meets(CodeConstraint c, List<CodeableConcept> codes, ValidationOptions options) {
    switch (c.kind) {
      case CONCEPT:
        for (Coding p : c.codings) {
          if (!hasCoding(codes, p.getSystem(), p.getCode())) {
            return false;
          }
        }
        return true;
      case CODING:
        return hasCoding(codes, c.codings.get(0).getSystem(), c.codings.get(0).getCode());
      case VALUESET:
        ValueSet vs = context.findTxResource(ValueSet.class, c.valueSet, VersionResolutionRules.defaultRule());
        if (vs == null) {
          throw new FHIRException(context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_, c.valueSet));
        }
        for (CodeableConcept cc : codes) {
          if (cc.hasCoding()) {
            ValidationResult vr = context.validateCode(options, cc, vs);
            if (vr.isOk()) {
              return true;
            }
            if (vr.getErrorClass() != null && vr.getErrorClass().isInfrastructure()) {
              throw new FHIRException(vr.getMessage());
            }
          }
        }
        return false;
      default:
        return false;
    }
  }

  /** whether any of the concepts has a coding with the system and (when given) the code */
  private boolean hasCoding(List<CodeableConcept> codes, String system, String code) {
    for (CodeableConcept cc : codes) {
      for (Coding c : cc.getCodingList()) {
        if (system.equals(c.getSystem()) && (code == null || code.equals(c.getCode()))) {
          return true;
        }
      }
    }
    return false;
  }
}
