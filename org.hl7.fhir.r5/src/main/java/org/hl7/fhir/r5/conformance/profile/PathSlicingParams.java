package org.hl7.fhir.r5.conformance.profile;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@MarkedToMoveToAdjunctPackage
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PathSlicingParams {
  @Getter
  final boolean done;
  @Getter
  final ElementDefinition elementDefinition;
  @Getter
  final String path;

  final List<ElementDefinition> slices = new ArrayList<>();

  public PathSlicingParams() {
    done = false;
    elementDefinition = null;
    path = null;
  }

  public PathSlicingParams withDiffs(List<ElementDefinition> diffMatches) {
    for (int i = 1; i < diffMatches.size(); i++) {
      slices.add(diffMatches.get(i));
    }
    return this;
  }
}
