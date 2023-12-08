package org.hl7.fhir.r4.ips;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r4.ips.IPSRenderer.InternalTemplateEngine;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Composition.SectionComponent;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.terminologies.TerminologyClient;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class IPSRenderer {

  public class InternalTemplateEngine implements ITemplateImplementer {

    @Override
    public String buildPage(Map<String, String> headers, String content) {
      // TODO Auto-generated method stub
      return null;
    }

  }

  private interface ITemplateImplementer {
    public String buildPage(Map<String, String> headers, String content);
  }
  private TerminologyClient tx;
  private String folder; // for images etc
  private Map<String, byte[]> binaries; // from the pubpack
  private ITemplateImplementer templater;
  private Map<String, String> headers;

  public IPSRenderer(TerminologyClient tx, String folder, Map<String, byte[]> binaries, ITemplateImplementer templater) {
    super();
    this.tx = tx;
    this.folder = folder;
    this.binaries = binaries;
    this.templater = templater;
  }
  
  public IPSRenderer(TerminologyClient tx, String folder, Map<String, byte[]> binaries) {
    super();
    this.tx = tx;
    this.folder = folder;
    this.binaries = binaries;
    this.templater = new InternalTemplateEngine();
  }

  public String render(Bundle document) throws IOException {
    headers = new HashMap<>();
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    generate(x, document);
    return templater.buildPage(headers, new XhtmlComposer(false, true).compose(x));
  }

  private void generate(XhtmlNode x, Bundle document) {
    Composition cmp = (Composition) document.getEntryFirstRep().getResource();
    int sectionDepth = findSectionDepth(cmp.getSection());
    XhtmlNode table = x.table("grid");
    
    // row 1: header
    XhtmlNode tr = table.tr();
    XhtmlNode td = tr.td().colspan(1+sectionDepth);
    td.b().tx("Provided");
    td = tr.td().colspan(1+sectionDepth);
    td.b().tx("Generated");
    
    // row 2: Subject
    DomainResource subject = findResource(document, cmp.getSubject());
    tr = table.tr();
    td = tr.td().colspan(1+sectionDepth);
    // genNarrative("subject", subject, td);
    td = tr.td().colspan(1+sectionDepth);
    td.b().tx("Generated");
    
    
    
    
  }

  private DomainResource findResource(Bundle document, Reference subject) {
    // TODO Auto-generated method stub
    return null;
  }

  private int findSectionDepth(List<SectionComponent> list) {
    int i = 1;
    for (SectionComponent sect : list) {
      i = Integer.max(i, 1+findSectionDepth(sect.getSection()));
    }
    return i;
  }
}
