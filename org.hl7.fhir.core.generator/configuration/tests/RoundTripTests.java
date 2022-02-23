package org.hl7.fhir.core.generator.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.{{jid}}.formats.IParser.OutputStyle;
import org.hl7.fhir.{{jid}}.formats.JsonParser;
import org.hl7.fhir.{{jid}}.formats.XmlParser;
import org.hl7.fhir.{{jid}}.model.DomainResource;
import org.hl7.fhir.{{jid}}.model.Resource;
import org.hl7.fhir.{{jid}}.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

@RunWith(Parameterized.class)
public class RoundTripTests {
  private static final String EXAMPLES_DIR = "R:\\fhir\\publish\\examples";

  @Parameters(name = "{index}: file {0}")
  public static Iterable<Object[]> data() throws ParserConfigurationException, SAXException, IOException {
    File dir = new File(EXAMPLES_DIR);

    String[] list = dir.list();
    List<Object[]> objects = new ArrayList<Object[]>(list.length);

    for (String s : list) {
      objects.add(new Object[] { s, s });
    }

    return objects;
  }
  private String name;

  public RoundTripTests(String name, String unused) {
    this.name = name;
  }
  
  @Test
  public void test() throws FileNotFoundException, IOException {
    byte[] src = TextFile.fileToBytes(Utilities.path(EXAMPLES_DIR, name));
    Resource r = new XmlParser().parse(src);
    assertNotNull(r);
    byte[] cnt = new XmlParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(r);
    Utilities.createDirectory(output());
    save(src, Utilities.path(output(), r.fhirType()+"-"+r.getId()+".src.xml"));
    save(cnt, Utilities.path(output(), r.fhirType()+"-"+r.getId()+".cnt.xml"));
    cnt = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(r);
    save(cnt, Utilities.path(output(), r.fhirType()+"-"+r.getId()+".cnt.json"));
    Resource rj = new JsonParser().parse(cnt);
    assertNotNull(rj);
    if (r instanceof DomainResource) {
      ((DomainResource) r).setText(null);
    }
    if (rj instanceof DomainResource) {
      ((DomainResource) rj).setText(null);
    }
    assertTrue(r.equalsDeep(rj));
  }

  private String output() throws IOException {
    return Utilities.path("[tmp]", "round-trip");
  }

  private void save(byte[] src, String path) throws IOException {
    File f = new File(path);
    if (f.exists()) {
      f.delete();
    }
    TextFile.bytesToFile(src, f);

    
  }

}