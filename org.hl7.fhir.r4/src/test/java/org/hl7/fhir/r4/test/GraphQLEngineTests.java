package org.hl7.fhir.r4.test;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseReference;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Bundle.BundleLinkComponent;
import org.hl7.fhir.r4.model.Bundle.SearchEntryMode;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.GraphQLEngine;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.graphql.*;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class GraphQLEngineTests implements IGraphQLStorageServices {

  public static Stream<Arguments> data() throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
    Document tests = XMLUtil.parseFileToDom(TestingUtilities.resourceNameToFile("graphql", "manifest.xml"));
    Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
    List<Arguments> objects = new ArrayList<>();
    while (test != null && test.getNodeName().equals("test")) {
      objects.add(Arguments.of(new Object[]{test.getAttribute("name"), test.getAttribute("source"), test.getAttribute("output"),
        test.getAttribute("context"), test.getAttribute("resource"), test.getAttribute("operation")}));
      test = XMLUtil.getNextSibling(test);
    }
    return objects.stream();
  }

  @Disabled
  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void test(String name, String source, String output, String context, String resource, String operation) throws Exception {
    String filename = null;
    if (!Utilities.noString(context)) {
      String[] parts = context.split("/");
      if (parts.length != 3)
        throw new Exception("not done yet " + source + " " + output + " " + context);
      if (!Utilities.noString(resource))
        filename = TestingUtilities.resourceNameToFile(resource + ".xml");
      else
        filename = TestingUtilities.resourceNameToFile(parts[0].toLowerCase() + "-" + parts[1].toLowerCase() + ".xml");
    }

    Resource parsedResource = !Utilities.noString( filename ) ? new XmlParser().parse(new FileInputStream(filename)) : null;

    testResource(parsedResource, output, source);
  }

  @Test
  public void testReferenceReverseHistory() throws IOException, EGraphEngine, EGraphQLException {

    String context = "Patient/example/$graphql";
    String source = "reference-reverse.gql";
    String output= "reference-reverse-history.json";

    String[] parts = context.split("/");
    String filename = TestingUtilities.resourceNameToFile(parts[0].toLowerCase() + "-" + parts[1].toLowerCase() + ".xml");

    Resource parsedResource = new XmlParser().parse(new FileInputStream(filename));
    parsedResource.setId("example/_history/1");

    testResource(parsedResource, output, source);
  }

  private void testResource(Resource resource, String output, String source) throws IOException, EGraphEngine, EGraphQLException {
    GraphQLEngine gql = new GraphQLEngine(TestingUtilities.context());
    gql.setServices(this);
    if (resource != null) {
      gql.setFocus(resource);
    }
    gql.setGraphQL(Parser.parseFile(TestingUtilities.resourceNameToFile("graphql", source)));
    gql.getGraphQL().setOperationName(null);
    gql.getGraphQL().getVariables().add(new Argument("var", new NameValue("true")));
    boolean ok = false;
    String msg = null;
    try {
      gql.execute();
      ok = true;
    } catch (Exception e) {
      if (!output.equals("$error"))
        e.printStackTrace();
      ok = false;
      msg = e.getMessage();
    }
    if (ok) {
      Assertions.assertTrue(!output.equals("$error"), "Expected to fail, but didn't");
      StringBuilder str = new StringBuilder();
      gql.getOutput().setWriteWrapper(false);
      gql.getOutput().write(str, 0);
      String actualFilePath = TestingUtilities.generateResourcePath("graphql", output + ".out");

      TextFile.stringToFile(str.toString(), actualFilePath);
      msg = TestingUtilities.checkJsonIsSame(actualFilePath, TestingUtilities.resourceNameToFile("graphql", output));
      Assertions.assertTrue(Utilities.noString(msg), msg);
    } else
      Assertions.assertTrue(output.equals("$error"), "Error, but proper output was expected (" + msg + ")");
  }

  @Override
  public Resource lookup(Object appInfo, String type, String id) throws FHIRException {
    try {
      String filename = TestingUtilities.resourceNameToFile(type.toLowerCase() + '-' + id.toLowerCase() + ".xml");
      if (new File(filename).exists())
        return new XmlParser().parse(new FileInputStream(filename));
      else
        return null;
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }

  @Override
  public ReferenceResolution lookup(Object appInfo, IBaseResource context, IBaseReference reference) throws FHIRException {
    try {
      if (reference.getReferenceElement().isLocal()) {
        if (!(context instanceof DomainResource))
          return null;
        for (Resource r : ((DomainResource) context).getContained()) {
          if (('#' + r.getId()).equals(reference.getReferenceElement().getValue())) {
            return new ReferenceResolution(context, r);
          }
        }
      } else {
        String[] parts = reference.getReferenceElement().getValue().split("/");
        String filename = TestingUtilities.resourceNameToFile(parts[0].toLowerCase() + '-' + parts[1].toLowerCase() + ".xml");
        if (new File(filename).exists())
          return new ReferenceResolution(null, new XmlParser().parse(new FileInputStream(filename)));
      }
      return null;
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }

  @Override
  public void listResources(Object appInfo, String type, List<Argument> searchParams, List<IBaseResource> matches) throws FHIRException {

    try {
      if (type.equals("Condition") && searchParams.get(0).hasValue("Patient/example"))
        matches.add(new XmlParser().parse(new FileInputStream(TestingUtilities.resourceNameToFile("condition-example.xml"))));
      else if (type.equals("Patient")) {
        matches.add(new XmlParser().parse(new FileInputStream(TestingUtilities.resourceNameToFile("patient-example.xml"))));
        matches.add(new XmlParser().parse(new FileInputStream(TestingUtilities.resourceNameToFile("patient-example-xds.xml"))));
      }
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }

  @Override
  public Bundle search(Object appInfo, String type, List<Argument> searchParams) throws FHIRException {
    try {
      Bundle bnd = new Bundle();
      BundleLinkComponent bl = bnd.addLink();
      bl.setRelation("next");
      bl.setUrl("http://test.fhir.org/r4/Patient?_format=text/xhtml&search-id=77c97e03-8a6c-415f-a63d-11c80cf73f&&active=true&_sort=_id&search-offset=50&_count=50");
      bl = bnd.addLink();
      bl.setRelation("self");
      bl.setUrl("http://test.fhir.org/r4/Patient?_format=text/xhtml&search-id=77c97e03-8a6c-415f-a63d-11c80cf73f&&active=true&_sort=_id&search-offset=0&_count=50");
      BundleEntryComponent be = bnd.addEntry();
      be.setFullUrl("http://hl7.org/fhir/Patient/example");
      be.setResource(new XmlParser().parse(new FileInputStream(Utilities.path(TestingUtilities.resourceNameToFile("patient-example.xml")))));
      be = bnd.addEntry();
      be.setFullUrl("http://hl7.org/fhir/Patient/example");
      be.setResource(new XmlParser().parse(new FileInputStream(Utilities.path(TestingUtilities.resourceNameToFile("patient-example-xds.xml")))));
      be.getSearch().setScore(0.5);
      be.getSearch().setMode(SearchEntryMode.MATCH);
      bnd.setTotal(50);
      return bnd;
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }

}