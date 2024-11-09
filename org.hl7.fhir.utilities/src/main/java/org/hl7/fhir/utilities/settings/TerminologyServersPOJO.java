package org.hl7.fhir.utilities.settings;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
public class TerminologyServersPOJO {

  private List<ServerDetailsPOJO> servers;

  protected TerminologyServersPOJO() {
    servers = new ArrayList<>();
  }
}
