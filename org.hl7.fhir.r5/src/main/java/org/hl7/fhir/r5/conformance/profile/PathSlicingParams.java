package org.hl7.fhir.r5.conformance.profile;

import org.hl7.fhir.r5.model.ElementDefinition;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PathSlicingParams {
  @Getter
  final boolean done;
  @Getter
  final ElementDefinition elementDefinition;
  @Getter
  final String path;

  public PathSlicingParams() {
    done = false;
    elementDefinition = null;
    path = null;
  }
}
