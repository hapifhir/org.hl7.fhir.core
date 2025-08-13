package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.resources30_40.CapabilityStatement30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.dstu3.model.CapabilityStatement;
import org.hl7.fhir.dstu3.model.CodeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class CapabilityStatement30_40Test {
  @Test
  @DisplayName("Test r4 -> dstu3 CapabilityStatement conversion.")
  public void testR4_Dstu3() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/capability_statement_40_with_30_extensions.json");

    org.hl7.fhir.r4.model.CapabilityStatement r4_actual = (org.hl7.fhir.r4.model.CapabilityStatement) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_40.convertResource(r4_actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();

    InputStream dstu3_input = this.getClass().getResourceAsStream("/capability_statement_40_30.json");
    org.hl7.fhir.dstu3.model.CapabilityStatement dstu3_actual = (org.hl7.fhir.dstu3.model.CapabilityStatement) dstu3_parser.parse(dstu3_input);

    assertTrue(dstu3_actual.equalsDeep(dstu3_conv), "should be the same");
  }

  @Test
  public void convertCapabilityStatementMessagingComponentR4toDstu3() {
    org.hl7.fhir.r4.model.CapabilityStatement capabilityStatementR4 = new org.hl7.fhir.r4.model.CapabilityStatement();
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent input = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent();
    input.addEndpoint(new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent(
      new org.hl7.fhir.r4.model.Coding("system", "code", "display"), new org.hl7.fhir.r4.model.UrlType("My Address")));
    input.setReliableCache(1234);
    input.setDocumentation("Some documentation");

    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> enumeration =
      new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityModeEnumFactory());
    enumeration.setValue(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.SENDER);
    input.addSupportedMessage(new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent(enumeration, new org.hl7.fhir.r4.model.CanonicalType("xyz")));

    Extension message = new Extension(VersionConvertorConstants.EXT_IG_CONFORMANCE_MESSAGE_EVENT);
    message.addExtension(new Extension("code", new org.hl7.fhir.r4.model.Coding("system", "code", "display")));
    message.addExtension(new Extension("mode", new StringType("receiver")));
    message.addExtension(new Extension("focus", new StringType("focus")));
    message.addExtension(new Extension("request", new org.hl7.fhir.r4.model.Reference("requestRef")));
    message.addExtension(new Extension("response", new org.hl7.fhir.r4.model.Reference("responseRef")));
    input.addExtension(message);

    capabilityStatementR4.addMessaging(input);

    //conversion
    org.hl7.fhir.dstu3.model.CapabilityStatement capabilityStatementDstu3 = (org.hl7.fhir.dstu3.model.CapabilityStatement) VersionConvertorFactory_30_40.convertResource(capabilityStatementR4);
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent result = capabilityStatementDstu3.getMessagingFirstRep();


    assertEquals(input.getReliableCache(), result.getReliableCache());
    assertEquals(input.getDocumentation(), result.getDocumentation());

    //Verify endpoint
    assertEquals("My Address", result.getEndpointFirstRep().getAddress());
    assertTrue(new org.hl7.fhir.dstu3.model.Coding("system", "code", "display").equalsDeep(result.getEndpointFirstRep().getProtocol()));

    //Verify support message
    assertEquals(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.SENDER, result.getSupportedMessageFirstRep().getMode());
    assertTrue(new org.hl7.fhir.dstu3.model.Reference("xyz").equalsDeep(result.getSupportedMessageFirstRep().getDefinition()));

    //Verify message events
    assertTrue(new org.hl7.fhir.dstu3.model.Coding("system", "code", "display").equalsDeep(result.getEventFirstRep().getCode()));
    assertEquals(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.RECEIVER, result.getEventFirstRep().getMode());
    assertEquals("focus", result.getEventFirstRep().getFocus());
    assertTrue(new org.hl7.fhir.dstu3.model.Reference("requestRef").equalsDeep(result.getEventFirstRep().getRequest()));
    assertTrue(new org.hl7.fhir.dstu3.model.Reference("responseRef").equalsDeep(result.getEventFirstRep().getResponse()));

    // verify extension is not converted back
    assertFalse(result.hasExtension(VersionConvertorConstants.EXT_IG_CONFORMANCE_MESSAGE_EVENT));
  }

  @Test
  public void convertMessageExtensionToMessageEvent() {
    Extension input = new Extension(VersionConvertorConstants.EXT_IG_CONFORMANCE_MESSAGE_EVENT);
    input.addExtension(new Extension("code", new org.hl7.fhir.r4.model.Coding("system", "code", "display")));
    input.addExtension(new Extension("category", new StringType("Currency")));
    input.addExtension(new Extension("mode", new StringType("receiver")));
    input.addExtension(new Extension("focus", new StringType("focus")));
    input.addExtension(new Extension("request", new org.hl7.fhir.r4.model.Reference("requestRef")));
    input.addExtension(new Extension("response", new org.hl7.fhir.r4.model.Reference("responseRef")));
    input.addExtension(new Extension("documentation", new StringType("some documentation")));

    ConversionContext30_40.INSTANCE.init(new VersionConvertor_30_40(new BaseAdvisor_30_40()), input.fhirType());
    CapabilityStatement.CapabilityStatementMessagingEventComponent result = CapabilityStatement30_40.convertMessageExtensionToMessageEvent(input);

    assertNotNull(result);
    //verify extension does not get mapped
    assertTrue(new org.hl7.fhir.dstu3.model.Coding("system", "code", "display").equalsDeep(result.getCode()));
    assertEquals(CapabilityStatement.MessageSignificanceCategory.CURRENCY, result.getCategory());
    assertEquals(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.RECEIVER, result.getMode());
    assertEquals("focus", result.getFocus());
    assertTrue(new org.hl7.fhir.dstu3.model.Reference("requestRef").equalsDeep(result.getRequest()));
    assertTrue(new org.hl7.fhir.dstu3.model.Reference("responseRef").equalsDeep(result.getResponse()));
    assertEquals("some documentation", result.getDocumentation());
  }

  @Test
  public void convertFocusExtensionR4ToMessageEventDstu3() {
    Extension inputString = new Extension("", new StringType("stringInput"));
    Extension inputCode = new Extension("", new org.hl7.fhir.r4.model.CodeType("codeInput"));

    ConversionContext30_40.INSTANCE.init(new VersionConvertor_30_40(new BaseAdvisor_30_40()), inputString.fhirType());
    CodeType resultString = CapabilityStatement30_40.convertFocusExtensionR4ToMessageEventDstu3(inputString);
    assertEquals("stringInput", resultString.getValue());
    CodeType resultCode = CapabilityStatement30_40.convertFocusExtensionR4ToMessageEventDstu3(inputCode);
    assertEquals("codeInput", resultCode.getValue());
  }

}
