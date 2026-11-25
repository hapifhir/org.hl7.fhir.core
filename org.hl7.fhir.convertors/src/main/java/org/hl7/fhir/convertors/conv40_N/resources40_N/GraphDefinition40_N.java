package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.*;
import org.hl7.fhir.convertors.conv40_N.resources40_N.Enumerations40_N;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class GraphDefinition40_N {

  /*
   * R4 GraphDefinition is a tree: start (a type) and profile, and links, each with targets (type, profile, params,
   * compartments) that have links of their own. R6 (the API incubator) is a graph: nodes (nodeId, type, profile) and
   * links from one node to another (sourceId, targetId, params, compartments).
   *
   * R4 -> R6: start/profile is a node, and so is each link target; each (link, target) pair is a link from the node
   * the link hangs off to the target's node. Node ids are generated (node0, node1... in the order the tree is
   * walked) unless the R4 has a 5.0 nodeId extension (on the resource for the start node, on the target otherwise).
   *
   * R6 -> R4: the tree is walked from the start node. Links from the same node with the same path, sliceName, min,
   * max and description, one after the other, are one R4 link with several targets. Node ids (unless they're what
   * R4 -> R6 would generate) and node descriptions are 5.0 extensions. Nodes and links the walk doesn't reach (or
   * that would make a cycle) are 5.0 extensions on the resource
   */
  private static final String GD = "GraphDefinition";
  private static final String[] V5 = {"identifier", "versionAlgorithm", "title", "copyright", "copyrightLabel"};
  public static final String NODE_ID_URL = CrossVersionElements40_N.url("GraphDefinition.node", "5.0", "nodeId");
  public static final String NODE_DESCRIPTION_URL = CrossVersionElements40_N.url("GraphDefinition.node", "5.0", "description");

  private static class ToR6 {
    private final org.hl7.fhir.model.api.GraphDefinition tgt;
    private int counter = 0;

    ToR6(org.hl7.fhir.model.api.GraphDefinition tgt) {
      this.tgt = tgt;
    }

    void convert(org.hl7.fhir.r4.model.GraphDefinition src) throws FHIRException {
      if (src.hasStart() || src.hasProfile()) {
        org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent node = node(src.getExtension());
        if (src.hasStart())
          node.getTypeElement().setValueAsString(src.getStart());
        if (src.hasProfile())
          node.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
        tgt.setStart(node.getNodeId());
        for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent link : src.getLink())
          link(node.getNodeId(), link);
      }
      // the nodes and links the R4 tree couldn't hold
      CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "node", "link");
    }

    private org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent node(java.util.List<org.hl7.fhir.r4.model.Extension> extensions) throws FHIRException {
      org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent node = tgt.addNode();
      node.setNodeId("node" + (counter++));
      for (org.hl7.fhir.r4.model.Extension e : extensions) {
        if (NODE_ID_URL.equals(e.getUrl()))
          node.setNodeId(e.getValue().primitiveValue());
        if (NODE_DESCRIPTION_URL.equals(e.getUrl()))
          node.setDescription(e.getValue().primitiveValue());
      }
      return node;
    }

    private void link(String sourceId, org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
      if (!src.hasTarget()) {
        // R4 allows a link with no targets: an R6 link with no targetId (which R6 requires)
        org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent link = tgt.addLink();
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, link);
        CrossVersionElements40_N.copySameElements(src, link, "description", "min", "max", "path", "sliceName");
        link.setSourceId(sourceId);
      }
      boolean first = true;
      for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent target : src.getTarget()) {
        org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent link = tgt.addLink();
        // the R4 link's id and extensions go on the first R6 link (going back, the others are merged into it)
        if (first)
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, link);
        first = false;
        CrossVersionElements40_N.copySameElements(src, link, "description", "min", "max", "path", "sliceName");
        link.setSourceId(sourceId);
        org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent node = node(target.getExtension());
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(target, node, NODE_ID_URL, NODE_DESCRIPTION_URL);
        if (target.hasType())
          node.getTypeElement().setValueAsString(target.getType());
        if (target.hasProfile())
          node.setProfileElement(Canonical40_N.convertCanonical(target.getProfileElement()));
        link.setTargetId(node.getNodeId());
        if (target.hasParams())
          link.setParamsElement(String40_N.convertString(target.getParamsElement()));
        for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent c : target.getCompartment()) {
          org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkCompartmentComponent tc = link.addCompartment();
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(c, tc);
          CrossVersionElements40_N.copySameElements(c, tc, "code", "rule", "expression", "description");
          if (c.hasUse()) {
            // R4 condition | requirement are R6 where | requires
            ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(c.getUseElement(), tc.getUseElement());
            tc.getUseElement().setValueAsString("condition".equals(c.getUseElement().getValueAsString()) ? "where" : "requirement".equals(c.getUseElement().getValueAsString()) ? "requires" : c.getUseElement().getValueAsString());
          }
        }
        for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent child : target.getLink())
          link(node.getNodeId(), child);
      }
    }
  }

  private static class ToR4 {
    private final org.hl7.fhir.model.api.GraphDefinition src;
    private final java.util.Set<org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent> usedNodes = new java.util.HashSet<>();
    private final java.util.Set<org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent> usedLinks = new java.util.HashSet<>();
    private int counter = 0;

    ToR4(org.hl7.fhir.model.api.GraphDefinition src) {
      this.src = src;
    }

    void convert(org.hl7.fhir.r4.model.GraphDefinition tgt) throws FHIRException {
      org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent start = node(src.getStart());
      if (start != null) {
        usedNodes.add(start);
        if (start.hasType())
          tgt.setStart(start.getTypeElement().getValueAsString());
        if (start.hasProfile())
          tgt.setProfileElement(Canonical40_N.convertCanonical(start.getProfileElement()));
        nodeExtensions(start, tgt.getExtension());
        java.util.List<String> path = new java.util.ArrayList<>();
        path.add(start.getNodeId());
        links(start.getNodeId(), tgt.getLink(), path);
      }
      for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent n : src.getNodeList())
        if (!usedNodes.contains(n))
          tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url(GD, "5.0", "node"), n));
      for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent l : src.getLinkList())
        if (!usedLinks.contains(l))
          tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url(GD, "5.0", "link"), l));
    }

    private org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent node(String id) {
      for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent n : src.getNodeList())
        if (n.hasNodeId() && n.getNodeId().equals(id))
          return n;
      return null;
    }

    // the node id, unless it's what R4 -> R6 would generate; and the description
    private void nodeExtensions(org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent node, java.util.List<org.hl7.fhir.r4.model.Extension> tgt) {
      String id = "node" + (counter++);
      if (!id.equals(node.getNodeId()))
        tgt.add(new org.hl7.fhir.r4.model.Extension(NODE_ID_URL, new org.hl7.fhir.r4.model.IdType(node.getNodeId())));
      if (node.hasDescription())
        tgt.add(new org.hl7.fhir.r4.model.Extension(NODE_DESCRIPTION_URL, new org.hl7.fhir.r4.model.StringType(node.getDescription())));
    }

    private void links(String sourceId, java.util.List<org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent> tgtList, java.util.List<String> path) throws FHIRException {
      org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent current = null;
      org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent currentSrc = null;
      for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent l : src.getLinkList()) {
        if (usedLinks.contains(l) || !sourceId.equals(l.getSourceId()))
          continue;
        if (!l.hasTargetId()) {
          // an R4 link with no targets (see ToR6.link)
          usedLinks.add(l);
          org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent link = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent();
          tgtList.add(link);
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(l, link);
          CrossVersionElements40_N.copySameElements(l, link, "description", "min", "max", "path", "sliceName");
          current = null;
          continue;
        }
        org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionNodeComponent node = node(l.getTargetId());
        if (node == null || path.contains(node.getNodeId()) || usedNodes.contains(node))
          continue; // left for the extensions
        usedLinks.add(l);
        usedNodes.add(node);
        if (current == null || !sameLink(currentSrc, l)) {
          current = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent();
          tgtList.add(current);
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(l, current);
          CrossVersionElements40_N.copySameElements(l, current, "description", "min", "max", "path", "sliceName");
          currentSrc = l;
        }
        org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent target = current.addTarget();
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(node, target);
        nodeExtensions(node, target.getExtension());
        if (node.hasType())
          target.setType(node.getTypeElement().getValueAsString());
        if (node.hasProfile())
          target.setProfileElement(Canonical40_N.convertCanonical(node.getProfileElement()));
        if (l.hasParams())
          target.setParamsElement(String40_N.convertString(l.getParamsElement()));
        for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkCompartmentComponent c : l.getCompartmentList()) {
          org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tc = target.addCompartment();
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(c, tc);
          CrossVersionElements40_N.copySameElements(c, tc, "code", "rule", "expression", "description");
          if (c.hasUse()) {
            ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(c.getUseElement(), tc.getUseElement());
            tc.getUseElement().setValueAsString("where".equals(c.getUseElement().getValueAsString()) ? "condition" : "requires".equals(c.getUseElement().getValueAsString()) ? "requirement" : c.getUseElement().getValueAsString());
          }
        }
        path.add(node.getNodeId());
        links(node.getNodeId(), target.getLink(), path);
        path.remove(path.size() - 1);
      }
    }

    // whether two R6 links are the same R4 link (they differ only in what belongs to the target)
    private boolean sameLink(org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent a, org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent b) {
      org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent ca = new org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent();
      org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent cb = new org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent();
      for (String n : new String[] {"description", "min", "max", "path", "sliceName"}) {
        for (org.hl7.fhir.model.Base v : a.getChildByName(n).getValues()) ca.setProperty(n, v);
        for (org.hl7.fhir.model.Base v : b.getChildByName(n).getValues()) cb.setProperty(n, v);
      }
      // (the R4 link's id and extensions are on the first one - see ToR6.link)
      return ca.equalsDeep(cb) && b.getExtensionList().isEmpty() && b.getModifierExtensionList().isEmpty() && !b.hasId();
    }
  }

  public static org.hl7.fhir.model.api.GraphDefinition convertGraphDefinition(org.hl7.fhir.r4.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.api.GraphDefinition tgt = new org.hl7.fhir.model.api.GraphDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls(GD, "5.0", V5,
      CrossVersionElements40_N.urls(GD, "5.0", new String[] {"node", "link"}, NODE_ID_URL, NODE_DESCRIPTION_URL)));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", V5);
    new ToR6(tgt).convert(src);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.model.api.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition tgt = new org.hl7.fhir.r4.model.GraphDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    new ToR4(src).convert(tgt);
    return tgt;
  }
//
//  public static org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasPath())
//      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
//    if (src.hasSliceName())
//      tgt.setSliceNameElement(String40_N.convertString(src.getSliceNameElement()));
//    if (src.hasMin())
//      tgt.setMinElement(Integer40_N.convertInteger(src.getMinElement()));
//    if (src.hasMax())
//      tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
//      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasPath())
//      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
//    if (src.hasSliceName())
//      tgt.setSliceNameElement(String40_N.convertString(src.getSliceNameElement()));
//    if (src.hasMin())
//      tgt.setMinElement(Integer40_N.convertInteger(src.getMinElement()));
//    if (src.hasMax())
//      tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
//      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(Code40_N.convertResourceEnum(src.getTypeElement()));
//    if (src.hasParams())
//      tgt.setParamsElement(String40_N.convertString(src.getParamsElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
//      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
//    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(Code40_N.convertResourceEnum(src.getTypeElement()));
//    if (src.hasParams())
//      tgt.setParamsElement(String40_N.convertString(src.getParamsElement()));
//    if (src.hasProfile())
//      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
//    for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
//      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
//    for (org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
//      tgt.addLink(convertGraphDefinitionLinkComponent(t));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasUse())
//      tgt.setUseElement(CrossVersionElements40_N.toR6Code(src.getUseElement(), convertGraphCompartmentUse(src.getUseElement()), src.fhirType(), "use"));
//    if (src.hasCode())
//      tgt.setCodeElement(CrossVersionElements40_N.toR6Code(src.getCodeElement(), convertCompartmentCode(src.getCodeElement()), src.fhirType(), "code"));
//    if (src.hasRule())
//      tgt.setRuleElement(CrossVersionElements40_N.toR6Code(src.getRuleElement(), convertGraphCompartmentRule(src.getRuleElement()), src.fhirType(), "rule"));
//    if (src.hasExpression())
//      tgt.setExpressionElement(String40_N.convertString(src.getExpressionElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.model.api.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasUse())
//      tgt.setUseElement(CrossVersionElements40_N.toR4Code(src.getUseElement(), convertGraphCompartmentUse(src.getUseElement()), src.fhirType(), "use"));
//    if (src.hasCode())
//      tgt.setCodeElement(CrossVersionElements40_N.toR4Code(src.getCodeElement(), convertCompartmentCode(src.getCodeElement()), src.fhirType(), "code"));
//    if (src.hasRule())
//      tgt.setRuleElement(CrossVersionElements40_N.toR4Code(src.getRuleElement(), convertGraphCompartmentRule(src.getRuleElement()), src.fhirType(), "rule"));
//    if (src.hasExpression())
//      tgt.setExpressionElement(String40_N.convertString(src.getExpressionElement()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse> convertGraphCompartmentUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUseEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case CONDITION:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse.CONDITION);
//        break;
//      case REQUIREMENT:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse.REQUIREMENT);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse> convertGraphCompartmentUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentUse> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUseEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case CONDITION:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.CONDITION);
//        break;
//      case REQUIREMENT:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.REQUIREMENT);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> convertCompartmentCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.CompartmentTypeEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case PATIENT:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.PATIENT);
//        break;
//      case ENCOUNTER:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.ENCOUNTER);
//        break;
//      case RELATEDPERSON:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.RELATEDPERSON);
//        break;
//      case PRACTITIONER:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.PRACTITIONER);
//        break;
//      case DEVICE:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.DEVICE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> convertCompartmentCode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GraphDefinition.CompartmentCodeEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case PATIENT:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PATIENT);
//        break;
//      case ENCOUNTER:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.ENCOUNTER);
//        break;
//      case RELATEDPERSON:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.RELATEDPERSON);
//        break;
//      case PRACTITIONER:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PRACTITIONER);
//        break;
//      case DEVICE:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.DEVICE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRuleEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case IDENTICAL:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.IDENTICAL);
//        break;
//      case MATCHING:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.MATCHING);
//        break;
//      case DIFFERENT:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.DIFFERENT);
//        break;
//      case CUSTOM:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.CUSTOM);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.api.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case IDENTICAL:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.IDENTICAL);
//        break;
//      case MATCHING:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.MATCHING);
//        break;
//      case DIFFERENT:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.DIFFERENT);
//        break;
//      case CUSTOM:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.CUSTOM);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.NULL);
//        break;
//    }
//    return tgt;
//  }
}