package org.hl7.fhir.r5.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Locale;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.liquid.LiquidEngine;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.testfactory.ProfileBasedFactory;
import org.hl7.fhir.r5.testfactory.TestDataFactory;
import org.hl7.fhir.r5.testfactory.dataprovider.TableDataProvider;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * A test data factory runs Liquid templates and FHIRPath mappings, and walks profiles, all from content: the whole
 * run has one time budget, and the walk can't go deeper than ProfileBasedFactory.MAX_DEPTH
 */
class TestDataFactoryLimitsTests {

  private static final String NESTED_REPEATS = "(1).repeat(iif($this < 1000, $this + 1, {})).select((1).repeat(iif($this < 1000, $this + 1, {})).count())";

  @TempDir
  Path folder;

  private TestDataFactory liquidFactory(String template) throws IOException {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    Files.writeString(folder.resolve("data.csv"), "id\r\na\r\nb\r\n");
    Files.writeString(folder.resolve("template.liquid"), template);
    JsonObject details = new JsonObject();
    details.add("name", "test");
    details.add("mode", "liquid");
    details.add("liquid", "template.liquid");
    details.add("data", "data.csv");
    details.add("filename", "out-$id$.txt");
    FHIRPathEngine fpe = new FHIRPathEngine(context);
    return new TestDataFactory(context, details, new LiquidEngine(context, null), fpe, "http://example.org", folder.toString(), folder.toString(), new HashMap<>(), Locale.ENGLISH);
  }

  @Test
  void aFactoryThatRunsIsFine() throws IOException {
    TestDataFactory factory = liquidFactory("{{ 1 + 1 }}");
    factory.execute();
    assertTrue(Files.readString(folder.resolve("out-a.txt")).contains("2"));
    assertTrue(Files.readString(folder.resolve("out-b.txt")).contains("2"));
  }

  @Test
  void aFactoryThatTakesTooLongIsStopped() throws IOException {
    TestDataFactory factory = liquidFactory("{{ " + NESTED_REPEATS + " }}");
    factory.setMaxExecutionMillis(200);
    long start = System.currentTimeMillis();
    FHIRException e = assertThrows(FHIRException.class, () -> factory.execute());
    assertTrue(e.getMessage().contains("didn't finish"), e.getMessage());
    assertTrue(System.currentTimeMillis() - start < 30000);
  }

  /** base data with nothing in it: every element is populated from its children */
  private String emptyBaseData() throws SQLException {
    String fn = new File(folder.toFile(), "base.db").getAbsolutePath();
    try (Connection c = DriverManager.getConnection("jdbc:sqlite:" + fn); Statement s = c.createStatement()) {
      s.execute("create table TestElements (ElementKey integer, ElementId text)");
      s.execute("create table TestTypes (TypeKey integer, TypeName text)");
      s.execute("create table TestValues (ValueKey integer, ElementKey integer, TypeKey integer, ValueData text)");
    }
    return fn;
  }

  /** a profile that limits its base to what it lists: everything else is max 0 */
  private static StructureDefinition profileOf(IWorkerContext context, String type, String url) {
    StructureDefinition sd = context.fetchTypeDefinition(type).copy();
    sd.setUrl(url);
    sd.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/" + type);
    sd.setDerivation(StructureDefinition.TypeDerivationRule.CONSTRAINT);
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (!ed.getPath().equals(type)) {
        ed.setMin(0);
        ed.setMax("0");
      }
    }
    return sd;
  }

  /** a slice on extension, of type Extension with that profile, that has to be there */
  private static void addExtension(StructureDefinition sd, String path, String profile) {
    for (int i = 0; i < sd.getSnapshot().getElement().size(); i++) {
      ElementDefinition ed = sd.getSnapshot().getElement().get(i);
      if (ed.getPath().equals(path)) {
        ed.setMax("*");
        ed.getSlicing().addDiscriminator().setType(ElementDefinition.DiscriminatorType.VALUE).setPath("url");
        ed.getSlicing().setRules(ElementDefinition.SlicingRules.OPEN);
        ElementDefinition slice = new ElementDefinition(path);
        slice.setId(path + ":child");
        slice.setSliceName("child");
        slice.setMin(1);
        slice.setMax("1");
        slice.setBase(ed.getBase().copy());
        slice.addType().setCode("Extension").addProfile(profile);
        sd.getSnapshot().getElement().add(i + 1, slice);
        return;
      }
    }
    throw new Error("no " + path);
  }

  /**
   * An extension that has itself as an extension, which has to be there: a profile that walks into it goes round
   * forever (the base types don't recurse - Identifier.assigner, the one way they could, isn't walked)
   */
  @Test
  void aProfileThatRecursesIsStopped() throws Exception {
    // a copy, so the profiles stay out of the shared context
    org.hl7.fhir.r5.context.SimpleWorkerContext context = new org.hl7.fhir.r5.context.SimpleWorkerContext((org.hl7.fhir.r5.context.SimpleWorkerContext) TestingUtilities.getSharedWorkerContext());
    StructureDefinition ext = profileOf(context, "Extension", "http://example.org/StructureDefinition/ext");
    ext.setType("Extension");
    addExtension(ext, "Extension.extension", ext.getUrl());
    context.cacheResource(ext);
    StructureDefinition profile = profileOf(context, "Basic", "http://example.org/StructureDefinition/basic");
    addExtension(profile, "Basic.extension", ext.getUrl());
    context.cacheResource(profile);

    Files.writeString(folder.resolve("rows.csv"), "counter\r\n1\r\n");
    TableDataProvider rows = TableDataProvider.forFile(folder.resolve("rows.csv").toString(), new TableDataProvider.SheetInfo(null, null), Locale.ENGLISH);
    rows.nextRow();
    ProfileBasedFactory factory = new ProfileBasedFactory(new FHIRPathEngine(context), emptyBaseData(), rows, new HashMap<>(), new JsonArray());
    factory.setTesting(true);
    FHIRException e = assertThrows(FHIRException.class, () -> factory.generate(profile));
    assertTrue(e.getMessage().contains("nested too deeply"), e.getMessage());
  }
}
