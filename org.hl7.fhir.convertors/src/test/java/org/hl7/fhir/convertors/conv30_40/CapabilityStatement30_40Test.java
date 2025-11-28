package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.resources30_40.CapabilityStatement30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.dstu3.model.CapabilityStatement;
import org.hl7.fhir.dstu3.model.CodeType;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
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
  public void convertCapabilityStatementR4ToDstu3() {
    org.hl7.fhir.r4.model.CapabilityStatement input = new org.hl7.fhir.r4.model.CapabilityStatement();
    input.setUrl("http://example.com");
    input.setVersion("1.0.0");
    input.setName("name");
    input.setTitle("title");
    input.setStatus(Enumerations.PublicationStatus.ACTIVE);
    input.setExperimental(true);
    Date date = Date.from(LocalDate.of(1983, 1, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
    input.setDate(date);
    input.setPublisher("publisher");
    input.addContact(new ContactDetail().setName("contact"));
    input.setDescription("description");
    input.addUseContext(new UsageContext().setCode(new org.hl7.fhir.r4.model.Coding("system", "useContext", "display")));
    input.addJurisdiction(new CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "jurisdiction", "display")));
    input.setPurpose("purpose");
    input.setCopyright("copyricht");
    input.setKind(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY);
    input.addInstantiates("instantiates");
    input.setSoftware(new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent(new StringType("software")));
    input.setImplementation(new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent(new StringType("implementation")));
    input.setFhirVersion(Enumerations.FHIRVersion._4_0);
    input.addExtension(new Extension(VersionConvertorConstants.EXT_ACCEPT_UNKNOWN_EXTENSION_URL, new StringType("elements")));
    input.addFormat("format");
    input.addPatchFormat("patchFormat");
    input.addImplementationGuide("implementationGuide");

    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent restComponent = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent();
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent resourceComponent = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
    resourceComponent.addSupportedProfile("SupportedProfile");
    restComponent.addResource(resourceComponent);
    input.addRest(restComponent);
    input.addExtension(new Extension(VersionConvertorConstants.EXT_CS_PROFILE, new Reference("profile")));
    input.addMessaging(new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent());
    input.addDocument(new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent());

    org.hl7.fhir.dstu3.model.CapabilityStatement result = (org.hl7.fhir.dstu3.model.CapabilityStatement) VersionConvertorFactory_30_40.convertResource(input);

    assertEquals(input.getUrl(), result.getUrl());
    assertEquals(input.getVersion(), result.getVersion());
    assertEquals(input.getName(), result.getName());
    assertEquals(input.getTitle(), result.getTitle());
    assertEquals(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.ACTIVE, result.getStatus());
    assertEquals(date, result.getDate());
    assertEquals(input.getPublisher(), result.getPublisher());
    assertThat(result.getContact()).hasSize(1);
    assertEquals(input.getContact().get(0).getName(), result.getContact().get(0).getName());
    assertEquals(input.getDescription(), result.getDescription());
    assertThat(result.getUseContext()).hasSize(1);
    assertTrue(result.getUseContext().get(0).getCode().equalsDeep(new org.hl7.fhir.dstu3.model.Coding("system", "useContext", "display")));
    assertThat(result.getJurisdiction()).hasSize(1);
    assertTrue(result.getJurisdiction().get(0).getCodingFirstRep().equalsDeep(new org.hl7.fhir.dstu3.model.Coding("system", "jurisdiction", "display")));
    assertEquals(input.getPurpose(), result.getPurpose());
    assertEquals(input.getCopyright(), result.getCopyright());
    assertEquals(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY, result.getKind());
    assertThat(input.getInstantiates()).hasSize(1);
    assertEquals(input.getInstantiates().get(0).getValue(), result.getInstantiates().get(0).getValue());
    assertEquals(input.getSoftware().getName(), result.getSoftware().getName());
    assertEquals(input.getImplementation().getDescription(), result.getImplementation().getDescription());
    assertEquals("4.0", result.getFhirVersion());

    assertEquals(CapabilityStatement.UnknownContentCode.ELEMENTS, result.getAcceptUnknown());
    assertFalse(result.hasExtension(VersionConvertorConstants.EXT_ACCEPT_UNKNOWN_EXTENSION_URL));

    assertThat(result.getFormat()).hasSize(1);
    assertEquals(input.getFormat().get(0).getValue(), result.getFormat().get(0).getValue());
    assertThat(result.getPatchFormat()).hasSize(1);
    assertEquals(input.getPatchFormat().get(0).getValue(), result.getPatchFormat().get(0).getValue());
    assertThat(result.getImplementationGuide()).hasSize(1);
    assertEquals(input.getImplementationGuide().get(0).getValue(), result.getImplementationGuide().get(0).getValue());
    assertThat(result.getRest()).hasSize(1);

    assertThat(result.getProfile()).hasSize(2);
    assertTrue(result.getProfile().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("SupportedProfile")));
    assertTrue(result.getProfile().get(1).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("profile")));
    assertFalse(result.hasExtension(VersionConvertorConstants.EXT_CS_PROFILE));
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
