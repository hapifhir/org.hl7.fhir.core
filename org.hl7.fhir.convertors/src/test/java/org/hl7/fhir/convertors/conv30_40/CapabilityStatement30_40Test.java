package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.resources30_40.CapabilityStatement30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.dstu3.model.CapabilityStatement;
import org.hl7.fhir.dstu3.model.CodeType;
import org.hl7.fhir.dstu3.model.Coding;
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

    Extension message1 = new Extension(VersionConvertorConstants.EXT_IG_CONFORMANCE_MESSAGE_EVENT);
    message1.addExtension(new Extension("code", new org.hl7.fhir.r4.model.Coding("system", "code", "display")));
    message1.addExtension(new Extension("mode", new StringType("receiver")));
    message1.addExtension(new Extension("focus", new StringType("focus")));
    message1.addExtension(new Extension("request", new org.hl7.fhir.r4.model.Reference("requestRef")));
    message1.addExtension(new Extension("response", new org.hl7.fhir.r4.model.Reference("responseRef")));
    input.addExtension(message1);

    Extension message2 = new Extension(VersionConvertorConstants.EXT_IG_CONFORMANCE_MESSAGE_EVENT);
    message2.addExtension(new Extension("code", new org.hl7.fhir.r4.model.Coding("system", "code", "display")));
    message2.addExtension(new Extension("mode", new StringType("receiver")));
    message2.addExtension(new Extension("focus", new StringType("focus")));
    message2.addExtension(new Extension("request", new org.hl7.fhir.r4.model.Reference("requestRef")));
    message2.addExtension(new Extension("response", new org.hl7.fhir.r4.model.Reference("responseRef")));
    input.addExtension(message2);

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

    assertEquals(2, result.getEvent().size());
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
  public void convertMessageExtensionR4ToMessageEventDstu3() {
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

  @Test
  public void convertCapabilityStatementMessagingComponentDstu3toR4() {
    org.hl7.fhir.dstu3.model.CapabilityStatement capabilityStatementR4 = new org.hl7.fhir.dstu3.model.CapabilityStatement();
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent input = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent();

    input.addEndpoint(new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent(
      new org.hl7.fhir.dstu3.model.Coding("system", "code", "display"), new org.hl7.fhir.dstu3.model.UriType("My Address")));
    input.setReliableCache(1234);
    input.setDocumentation("Some documentation");

    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> enumeration =
      new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityModeEnumFactory());
    enumeration.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.SENDER);
    input.addSupportedMessage(new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent(enumeration, new org.hl7.fhir.dstu3.model.Reference("xyz")));

    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent message1 = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent();
    message1.setCode(new Coding("system", "code", "display"));
    message1.setMode(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.RECEIVER);
    message1.setRequest(new org.hl7.fhir.dstu3.model.Reference("request"));
    message1.setResponse(new org.hl7.fhir.dstu3.model.Reference("response"));
    input.addEvent(message1);

    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent message2 = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent();
    message2.setCode(new Coding("system", "code", "display"));
    message2.setMode(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.RECEIVER);
    message2.setRequest(new org.hl7.fhir.dstu3.model.Reference("request"));
    message2.setResponse(new org.hl7.fhir.dstu3.model.Reference("response"));
    input.addEvent(message2);

    capabilityStatementR4.addMessaging(input);

    //conversion
    org.hl7.fhir.r4.model.CapabilityStatement capabilityStatementDstu3 = (org.hl7.fhir.r4.model.CapabilityStatement) VersionConvertorFactory_30_40.convertResource(capabilityStatementR4);
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent result = capabilityStatementDstu3.getMessagingFirstRep();


    assertEquals(input.getReliableCache(), result.getReliableCache());
    assertEquals(input.getDocumentation(), result.getDocumentation());

    //Verify endpoint
    assertEquals("My Address", result.getEndpointFirstRep().getAddress());
    assertTrue(new org.hl7.fhir.r4.model.Coding("system", "code", "display").equalsDeep(result.getEndpointFirstRep().getProtocol()));

    //Verify support message
    assertEquals(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.SENDER, result.getSupportedMessageFirstRep().getMode());
    assertEquals("xyz", result.getSupportedMessageFirstRep().getDefinition());

    assertEquals(2, result.getExtensionsByUrl(VersionConvertorConstants.EXT_IG_CONFORMANCE_MESSAGE_EVENT).size());
  }

  @Test
  public void convertCapabilityStatementMessageEventDstu3ToExtensionR4() {
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent input = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent();
    input.setCode(new org.hl7.fhir.dstu3.model.Coding("system", "code", "display"));
    input.setCategory(CapabilityStatement.MessageSignificanceCategory.NOTIFICATION);
    input.setMode(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.SENDER);
    input.setFocus("abc");
    input.setRequest(new org.hl7.fhir.dstu3.model.Reference("request ref"));
    input.setResponse(new org.hl7.fhir.dstu3.model.Reference("response ref"));
    input.setDocumentation("Some documentation");

    ConversionContext30_40.INSTANCE.init(new VersionConvertor_30_40(new BaseAdvisor_30_40()), input.fhirType());
    org.hl7.fhir.r4.model.Extension result = CapabilityStatement30_40.convertCapabilityStatementMessageEvent(input);

    assertEquals(VersionConvertorConstants.EXT_IG_CONFORMANCE_MESSAGE_EVENT, result.getUrl());

    org.hl7.fhir.r4.model.Extension codeExtension = result.getExtensionByUrl("code");
    assertNotNull(codeExtension);
    assertTrue(new org.hl7.fhir.r4.model.Coding("system", "code", "display").equalsDeep(codeExtension.getValue()));

    org.hl7.fhir.r4.model.Extension categoryExtension = result.getExtensionByUrl("category");
    assertNotNull(categoryExtension);
    assertTrue(new org.hl7.fhir.r4.model.CodeType(CapabilityStatement.MessageSignificanceCategory.NOTIFICATION.toCode()).equalsDeep(categoryExtension.getValue()));

    org.hl7.fhir.r4.model.Extension modeExtension = result.getExtensionByUrl("mode");
    assertNotNull(modeExtension);
    assertTrue(new org.hl7.fhir.r4.model.CodeType(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.SENDER.toCode()).equalsDeep(modeExtension.getValue()));

    org.hl7.fhir.r4.model.Extension focusExtension = result.getExtensionByUrl("focus");
    assertNotNull(focusExtension);
    assertTrue(new org.hl7.fhir.r4.model.StringType("abc").equalsDeep(focusExtension.getValue()));

    org.hl7.fhir.r4.model.Extension requestExtension = result.getExtensionByUrl("request");
    assertNotNull(requestExtension);
    assertTrue(new org.hl7.fhir.r4.model.Reference("request ref").equalsDeep(requestExtension.getValue()));

    org.hl7.fhir.r4.model.Extension responseExtension = result.getExtensionByUrl("response");
    assertNotNull(responseExtension);
    assertTrue(new org.hl7.fhir.r4.model.Reference("response ref").equalsDeep(responseExtension.getValue()));

    org.hl7.fhir.r4.model.Extension documentationExtension = result.getExtensionByUrl("documentation");
    assertNotNull(documentationExtension);
    assertTrue(new org.hl7.fhir.r4.model.StringType("Some documentation").equalsDeep(documentationExtension.getValue()));
  }

  @Test
  public void convertFocusMessagingEventComponentDstu3ToExtensionR4() {
    ConversionContext30_40.INSTANCE.init(new VersionConvertor_30_40(new BaseAdvisor_30_40()), "");

    org.hl7.fhir.r4.model.Extension result1 = CapabilityStatement30_40.convertFocusMessagingEventComponent(new org.hl7.fhir.dstu3.model.CodeType("someCode"));
    assertNotNull(result1);
    assertEquals("focus", result1.getUrl());
    assertTrue(new org.hl7.fhir.r4.model.StringType("someCode").equalsDeep(result1.getValue()));

    org.hl7.fhir.r4.model.Extension result2 = CapabilityStatement30_40.convertFocusMessagingEventComponent(new org.hl7.fhir.dstu3.model.CodeType());
    assertNotNull(result2);
    assertEquals("focus", result2.getUrl());
    assertTrue(new org.hl7.fhir.r4.model.CodeType().equalsDeep(result2.getValue()));
  }
}
