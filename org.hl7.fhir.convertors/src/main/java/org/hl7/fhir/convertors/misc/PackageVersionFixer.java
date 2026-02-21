package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PackageVersionFixer {
  public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
    new PackageVersionFixer().execute(new File(args[0]));
  }

  private void execute(File file) throws IOException, ParserConfigurationException, SAXException {
    Document feed = XMLUtil.parseFileToDom(Utilities.path(file.getAbsolutePath(), "package-feed.xml"));
    for (Element item : XMLUtil.getNamedChildren(XMLUtil.getNamedChild(feed.getDocumentElement(), "channel"), "item")) {
      processItem(file, item);
    }
  }

  private void processItem(File file, Element item) throws IOException {
    String version = XMLUtil.getNamedChildText(item, "title");
    version = version.substring(version.indexOf("#")+1);
    String link = XMLUtil.getNamedChildText(item, "link");
    String filename = Utilities.path(file.getAbsolutePath(), link.replace("http://hl7.org/fhir/", ""));
    if (filename.contains(version)) {
      if (!new File(filename).exists()) {

      } else {
        NpmPackage npm = NpmPackage.fromPackage(new FileInputStream(filename));
        String pver = npm.version();
        if (pver == null) {
        } else if (!pver.equals(version)) {
          npm.getNpm().set("version", version);
          String nfn = FileUtilities.changeFileExt(filename, ".fixed.tgz");
          npm.save(new FileOutputStream(nfn));
        }
      }
    }
  }
}
