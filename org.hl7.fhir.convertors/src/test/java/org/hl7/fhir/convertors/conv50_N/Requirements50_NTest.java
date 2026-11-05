package org.hl7.fhir.convertors.conv50_N;

import java.io.IOException;

import org.hl7.fhir.convertors.conv50_N.resources50_N.Requirements50_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.hl7.fhir.services.utilities.TestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Requirements50_NTest {

  private static org.hl7.fhir.model.core.Requirements load() throws IOException {
    org.hl7.fhir.r5.model.Requirements r5 = (org.hl7.fhir.r5.model.Requirements) new org.hl7.fhir.r5.formats.JsonParser()
      .parse(TestingUtilities.loadTestResourceBytes("conversion", "requirements-actorkey-r5.json"));
    return (org.hl7.fhir.model.core.Requirements) VersionConvertorFactory_50_N.convertResource(r5);
  }

  @Test
  @DisplayName("Requirements.actor key R5 -> R6 from the 6.0 extension and the tools requirements-actorkey extension")
  void testActorKey50_N() throws IOException {
    org.hl7.fhir.model.core.Requirements r6 = load();

    Assertions.assertEquals(3, r6.getActorList().size());
    Assertions.assertEquals("http://example.org/fhir/ActorDefinition/client", r6.getActorList().get(0).getReference());
    Assertions.assertEquals("client", r6.getActorList().get(0).getKey());
    Assertions.assertEquals("http://example.org/fhir/ActorDefinition/server", r6.getActorList().get(1).getReference());
    Assertions.assertEquals("server", r6.getActorList().get(1).getKey());
    Assertions.assertEquals("http://example.org/fhir/ActorDefinition/other", r6.getActorList().get(2).getReference());
    Assertions.assertFalse(r6.getActorList().get(2).hasKey());
  }

  @Test
  @DisplayName("Requirements.actor key R5 -> R6 -> R5 is written with the 6.0 extension")
  void testActorKeyRoundTrip50_N() throws IOException {
    org.hl7.fhir.r5.model.Requirements back = (org.hl7.fhir.r5.model.Requirements) VersionConvertorFactory_50_N.convertResource(load());

    Assertions.assertEquals(3, back.getActor().size());
    Assertions.assertEquals("client", back.getActor().get(0).getExtensionByUrl(Requirements50_N.ACTOR_KEY_EXTENSION_URL).getValue().primitiveValue());
    Assertions.assertEquals("server", back.getActor().get(1).getExtensionByUrl(Requirements50_N.ACTOR_KEY_EXTENSION_URL).getValue().primitiveValue());
    Assertions.assertFalse(back.getActor().get(2).hasExtension(Requirements50_N.ACTOR_KEY_EXTENSION_URL));
  }
}
