package org.hl7.fhir.r5.conformance;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.hl7.fhir.r5.model.StructureDefinition;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfilePathProcessorBase {

  protected final ProfileUtilities profileUtilities;

  @Getter
  @With
  final String debugIndent;

  @Getter
  final StructureDefinition.StructureDefinitionSnapshotComponent result;

  @Getter
  @With
  final StructureDefinition.StructureDefinitionDifferentialComponent differential;

  @Getter
  @With
  final int baseLimit;

  @Getter
  @With
  final int diffLimit;

  @Getter
  final String url;

  @Getter
  @With
  final String webUrl;

  @Getter
  @With
  final String profileName;

  @Getter
  @With
  final String contextPathSource;

  @Getter
  @With
  final String contextPathTarget;

  @Getter
  @With
  final boolean trimDifferential;

  @Getter
  @With
  final List<ElementRedirection> redirector;

  @Getter
  @With
  final StructureDefinition sourceStructureDefinition;

  @Getter
  final StructureDefinition derived;

  @Getter
  @With
  final ProfilePathProcessor.PathSlicingParams slicing;

  ProfilePathProcessorBase(
    ProfileUtilities profileUtilities,
    StructureDefinition.StructureDefinitionSnapshotComponent result,
    StructureDefinition.StructureDefinitionDifferentialComponent differential,
    int baseLimit,
    int diffLimit,
    String url,
    String webUrl,
    String profileName,
    String contextPathSource,
    String contextPathTarget,
    boolean trimDifferential,
    List<ElementRedirection> redirector,
    StructureDefinition sourceStructureDefinition,
    StructureDefinition derived,
    ProfilePathProcessor.PathSlicingParams slicing) {

    this.profileUtilities = profileUtilities;
    debugIndent = "";
    this.result = result;
    this.differential = differential;
    this.baseLimit = baseLimit;
    this.diffLimit = diffLimit;
    this.url = url;
    this.webUrl = webUrl;
    this.profileName = profileName;
    this.contextPathSource = contextPathSource;
    this.contextPathTarget = contextPathTarget;
    this.trimDifferential = trimDifferential;
    this.redirector = redirector;
    this.sourceStructureDefinition = sourceStructureDefinition;
    this.derived = derived;
    this.slicing = slicing;
  }

  public ProfilePathProcessorBase incrementDebugIndent() {
    return this.withDebugIndent(this.debugIndent + " ".repeat(2));
  }
}
