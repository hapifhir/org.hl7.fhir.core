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
public class FHIRServersPOJO {

  private List<ServerDetailsPOJO> servers;

  protected FHIRServersPOJO() {
    servers = new ArrayList<>();
  }
}
