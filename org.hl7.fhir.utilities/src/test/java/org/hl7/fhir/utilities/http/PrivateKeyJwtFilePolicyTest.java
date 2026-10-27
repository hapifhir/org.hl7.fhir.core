package org.hl7.fhir.utilities.http;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess.FileAccessPolicy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

/** Changes the JVM-wide file access policy, so it must not run alongside other tests. */
@Isolated
class PrivateKeyJwtFilePolicyTest {

  @Test
  void fileAccessPolicyRefusalIsReportedAsSuch() {
    FileAccessPolicy previous = ManagedFileAccess.getAccessPolicy();
    ManagedFileAccess.setAccessPolicy(FileAccessPolicy.PROHIBITED);
    try {
      assertThatThrownBy(() -> PrivateKeyJwtAssertion.loadKey("/keys/client.pem", null))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("not allowed by local security policy");
    } finally {
      ManagedFileAccess.setAccessPolicy(previous);
    }
  }
}
