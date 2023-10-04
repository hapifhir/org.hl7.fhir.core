package org.hl7.fhir.r5.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceFactory;
import org.hl7.fhir.r5.sql.SQLOnFhirTestCases.RowSorter;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.sql.Provider;
import org.hl7.fhir.r5.utils.sql.Runner;
import org.hl7.fhir.r5.utils.sql.StorageJson;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

public class SQLOnFhirTestCases {

  public class TestProvider implements Provider {

    @Override
    public List<Base> fetch(String resourceType) {
      List<Base> list = new ArrayList<Base>();
      for (JsonObject res : details.resources) {
        try {
          String src = JsonParser.compose(res, false);
          Resource resource = new org.hl7.fhir.r5.formats.JsonParser().parse(src);
          if (resource.fhirType().equals(resourceType)) {
            list.add(resource);
          }
        } catch (Exception e) {
          throw new FHIRException(e);
        }
      }
      return list;
    }

    @Override
    public Base resolveReference(String ref, String rt) {
      if (ref == null) {
        return null;
      }
      String[] p = ref.split("\\/");
      if (p.length > 1 && TestingUtilities.getSharedWorkerContext().getResourceNamesAsSet().contains(p[p.length-2])) {
        if (rt == null || rt.equals(p[p.length-2])) {
          return ResourceFactory.createResource(p[p.length-2]).setId(p[p.length-1]);
        }
      }
      
      return null;
    }

  }

  private static class TestDetails {
    String name;
    String path;
    List<JsonObject> resources;
    JsonObject testCase;
    protected TestDetails(String name, String path, List<JsonObject> resources, JsonObject testCase) {
      super();
      this.name = name;
      this.path = path;
      this.resources = resources;
      this.testCase = testCase;
    }

  }

  public static Stream<Arguments> data() throws ParserConfigurationException, SAXException, IOException {
    List<Arguments> objects = new ArrayList<>();
    File dir = new File("/Users/grahamegrieve/work/sql-on-fhir-v2/tests/content");
    for (File f : dir.listFiles()) {
      if (f.getName().endsWith(".json")) {
        JsonObject json = JsonParser.parseObject(f);
        String name1 = f.getName().replace(".json", "");
        List<JsonObject> resources = json.getJsonObjects("resources");
        int i = 0;
        for (JsonObject test : json.getJsonObjects("tests")) {
          String name2 = test.asString("title");
          objects.add(Arguments.of(name1+":"+name2, new TestDetails(name1+":"+name2, "$.tests["+i+"]", resources, test)));
          i++;
        }
      }
    }
    return objects.stream();
  }

  private TestDetails details;

  @SuppressWarnings("deprecation")
  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String name, TestDetails test) throws FileNotFoundException, IOException, FHIRException, org.hl7.fhir.exceptions.FHIRException, UcumException {
    this.details = test;
    Runner runner = new Runner();
    runner.setContext(TestingUtilities.getSharedWorkerContext());
    runner.setProvider(new TestProvider());
    StorageJson store = new StorageJson();
    runner.setStorage(store);

    System.out.println("");
    System.out.println("----------------------------------------------------------------------------");
    System.out.println(test.name);
    JsonArray results = null;
    try {
      runner.execute(test.path+".view", test.testCase.getJsonObject("view"));
      results = store.getRows();
    } catch (Exception e) {
      Assertions.assertTrue(test.testCase.has("expectError"), e.getMessage());
    }
    if (results != null) {
      System.out.println(JsonParser.compose(results, true));
      if (test.testCase.has("expect")) {
        JsonObject rows = new JsonObject();
        rows.add("rows", results);
        JsonObject exp = new JsonObject();
        exp.add("rows", test.testCase.getJsonArray("expect"));
        sortResults(exp);
        sortResults(rows);
        String expS = JsonParser.compose(exp, true);
        String rowS = JsonParser.compose(rows, true);
        String c = CompareUtilities.checkJsonSrcIsSame(expS, rowS, null);
        Assertions.assertNull(c, c);
      } else if (test.testCase.has("expectCount")) {
        Assertions.assertEquals(test.testCase.asInteger("expectCount"), results.size());
      } else {
        Assertions.fail("?");
      }
    }
  }


  public class RowSorter implements Comparator<JsonElement> {

    @Override
    public int compare(JsonElement e1, JsonElement e2) {
      String s1 = JsonParser.compose(e1);
      String s2 = JsonParser.compose(e2);
      return s1.compareTo(s2);
    }

  }

  private void sortResults(JsonObject o) {
    Collections.sort(o.getJsonArray("rows").getItems(), new RowSorter());
    
  }

}
