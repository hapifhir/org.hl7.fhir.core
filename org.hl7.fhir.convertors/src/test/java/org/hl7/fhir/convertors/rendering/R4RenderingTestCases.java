package org.hl7.fhir.convertors.rendering;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.hl7.fhir.convertors.context.ContextResourceLoaderFactory;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.wrapper.ResourceWrapperR4;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.renderers.Renderer;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class R4RenderingTestCases {

  @Test
  void test()  {
    assertDoesNotThrow(() -> {
      Patient patient = makePatient();
      org.hl7.fhir.r5.model.Resource r5p = VersionConvertorFactory_40_50.convertResource(patient);

      RenderingContext rc = makeContext("5.0.0", FhirPublication.R5);
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      ResourceRenderer pr = RendererFactory.factory(r5p.fhirType(), rc);
      pr.buildNarrative(new Renderer.RenderingStatus(), x, ResourceWrapper.forResource(rc, r5p));
      String html = new XhtmlComposer(false, true).compose(x);
      System.out.println(html);
    });
  }

  @Test
  void testR4() {
    assertDoesNotThrow(() -> {
      Patient patient = makePatient();
      RenderingContext rc = makeContext("4.0.1", FhirPublication.R4);

      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      ResourceRenderer pr = RendererFactory.factory(patient.fhirType(), rc);
      pr.buildNarrative(new Renderer.RenderingStatus(), x, ResourceWrapperR4.forResource(rc, patient));
      String html = new XhtmlComposer(false, true).compose(x);
      System.out.println(html);
    });
  }

  public Patient makePatient() {
    Patient patient = new Patient();
    patient.setId("Ik");
    patient.addIdentifier().setSystem("eadnr").setValue("123456");
    patient.addName().setFamily("Geens").addGiven("Tomas").addPrefix("mr");
    patient.addAddress()
            .addLine("Geheime straat 10")
            .setCity("Stad");
    patient.setGender(Enumerations.AdministrativeGender.MALE);
    patient.setActive(true);
    Calendar calendar = Calendar.getInstance();
    calendar.set(1996, Calendar.JANUARY, 1, 20, 0, 0);
    Date d = calendar.getTime();
    patient.setBirthDate(d);
    Patient.ContactComponent contact = new Patient.ContactComponent();
    contact.setName(new HumanName().addGiven("Voornaam").setFamily("Achternaam"));
    contact.setGender(Enumerations.AdministrativeGender.FEMALE);
    contact.addTelecom(new ContactPoint().setSystem(ContactPoint.ContactPointSystem.PHONE).setValue("123"));
    patient.addContact(contact);
    return patient;
  }


  public RenderingContext makeContext(String version, FhirPublication pub) throws IOException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    NpmPackage npm = pcm.loadPackage(VersionUtilities.packageForVersion(version));
    IContextResourceLoader loader = ContextResourceLoaderFactory.makeLoader(npm.fhirVersion(), new NullLoaderKnowledgeProviderR5());
    SimpleWorkerContext context = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(npm, loader, true);

    RenderingContext rc = new RenderingContext(context, new MarkDownProcessor(MarkDownProcessor.Dialect.COMMON_MARK),
            new org.hl7.fhir.utilities.validation.ValidationOptions(pub), "http://hl7.org/fhir",
            "", new Locale("en"), RenderingContext.ResourceRendererMode.END_USER, RenderingContext.GenerationRules.VALID_RESOURCE);
    return rc;
  }



  
}
