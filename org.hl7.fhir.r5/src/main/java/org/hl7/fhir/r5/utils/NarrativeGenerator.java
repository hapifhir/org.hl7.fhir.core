package org.hl7.fhir.r5.utils;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
Copyright (c) 2011+, HL7, Inc
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.HashMultimap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ProfileUtilities.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Address;
import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.Attachment;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Base64BinaryType;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent;
import org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent;
import org.hl7.fhir.r5.model.Bundle.BundleType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction;
import org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent;
import org.hl7.fhir.r5.model.Composition;
import org.hl7.fhir.r5.model.Composition.SectionComponent;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DiagnosticReport;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Dosage;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Encounter;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.ExtensionHelper;
import org.hl7.fhir.r5.model.HumanName;
import org.hl7.fhir.r5.model.HumanName.NameUse;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.InstantType;
import org.hl7.fhir.r5.model.ListResource;
import org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent;
import org.hl7.fhir.r5.model.Meta;
import org.hl7.fhir.r5.model.MetadataResource;
import org.hl7.fhir.r5.model.Narrative;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Period;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Provenance;
import org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Range;
import org.hl7.fhir.r5.model.Ratio;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.RelatedArtifact;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SampledData;
import org.hl7.fhir.r5.model.Signature;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.Timing;
import org.hl7.fhir.r5.model.Timing.EventTiming;
import org.hl7.fhir.r5.model.Timing.TimingRepeatComponent;
import org.hl7.fhir.r5.model.Timing.UnitsOfTime;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemRenderer;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.CodeSystemNavigator;
import org.hl7.fhir.r5.terminologies.ConceptMapRenderer;
import org.hl7.fhir.r5.terminologies.TerminologyRenderer;
import org.hl7.fhir.r5.terminologies.TerminologyRenderer.ConceptMapRenderInstructions;
import org.hl7.fhir.r5.terminologies.TerminologyRenderer.TerminologyRendererMode;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.ValueSetRenderer;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.utils.LiquidEngine.LiquidDocument;
import org.hl7.fhir.r5.utils.NarrativeGenerator.ResourceContext;
import org.hl7.fhir.r5.utils.XVerExtensionManager.XVerExtensionStatus;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.utilities.xml.XmlGenerator;
import org.w3c.dom.Element;

public class NarrativeGenerator implements INarrativeGenerator {

  public interface ILiquidTemplateProvider {

    String findTemplate(ResourceContext rcontext, DomainResource r);

  }

  public interface ITypeParser {
    Base parseType(String xml, String type) throws FHIRFormatError, IOException, FHIRException ;
  }

  public static class ResourceContext {
    Bundle bundleResource;
    org.hl7.fhir.r5.elementmodel.Element bundleElement;

    DomainResource resourceResource;
    org.hl7.fhir.r5.elementmodel.Element resourceElement;

    public ResourceContext(Bundle bundle, DomainResource dr) {
      super();
      this.bundleResource = bundle;
      this.resourceResource = dr;
    }

    public ResourceContext(org.hl7.fhir.r5.elementmodel.Element bundle, org.hl7.fhir.r5.elementmodel.Element dr) {
      this.bundleElement = bundle;
      this.resourceElement = dr;
    }

    public ResourceContext(Object bundle, Element doc) {
      // TODO Auto-generated constructor stub
    }

    public BundleEntryComponent resolve(String value) {
      if (value.startsWith("#")) {
        if (resourceResource != null) {
          for (Resource r : resourceResource.getContained()) {
            if (r.getId().equals(value.substring(1))) {
              BundleEntryComponent be = new BundleEntryComponent();
              be.setResource(r);
              return be;
            }
          }
        }
        return null;
      }
      if (bundleResource != null) {
        for (BundleEntryComponent be : bundleResource.getEntry()) {
          if (be.getFullUrl().equals(value))
            return be;
          if (value.equals(be.getResource().fhirType()+"/"+be.getResource().getId()))
            return be;
        }
      }
      return null;
    }

    public org.hl7.fhir.r5.elementmodel.Element resolveElement(String value) {
      if (value.startsWith("#")) {
        if (resourceElement != null) {
          for (org.hl7.fhir.r5.elementmodel.Element r : resourceElement.getChildrenByName("contained")) {
            if (r.getChildValue("id").equals(value.substring(1)))
              return r;
          }          
        }
        return null;
      }
      if (bundleElement != null) {
        for (org.hl7.fhir.r5.elementmodel.Element be : bundleElement.getChildren("entry")) {
          org.hl7.fhir.r5.elementmodel.Element res = be.getNamedChild("resource");
          if (value.equals(be.getChildValue("fullUrl")))
            return be;
          if (value.equals(res.fhirType()+"/"+res.getChildValue("id")))
            return be;
        }
      }
      return null;
    }
  }

  public interface IReferenceResolver {
    ResourceWithReference resolve(String url);
  }

  private Bundle bundle;
  private String definitionsTarget;
  private String corePath;
  private String destDir;
  private String snomedEdition;
  private ProfileKnowledgeProvider pkp;
  private MarkDownProcessor markdown = new MarkDownProcessor(Dialect.COMMON_MARK);
  private ITypeParser parser; // when generating for an element model
  private ILiquidTemplateProvider templateProvider;
  private IEvaluationContext services;

  public boolean generate(Bundle b, boolean evenIfAlreadyHasNarrative, Set<String> outputTracker) throws EOperationOutcome, FHIRException, IOException {
    boolean res = false;
    this.bundle = b;
    for (BundleEntryComponent be : b.getEntry()) {
      if (be.hasResource() && be.getResource() instanceof DomainResource) {
        DomainResource dr = (DomainResource) be.getResource();
        if (evenIfAlreadyHasNarrative || !dr.getText().hasDiv())
          res = generate(new ResourceContext(b, dr), dr, outputTracker) || res;
      }
    }
    return res;
  }

  public boolean generate(DomainResource r) throws EOperationOutcome, FHIRException, IOException {
    return generate(null, r, new HashSet<>());
  }
  public boolean generate(DomainResource r, Set<String> outputTracker) throws EOperationOutcome, FHIRException, IOException {
    return generate(null, r, outputTracker);
  }

  public boolean generate(ResourceContext rcontext, DomainResource r, Set<String> outputTracker) throws EOperationOutcome, FHIRException, IOException {
    if (rcontext == null)
      rcontext = new ResourceContext(null, r);

    if (templateProvider != null) {
      String liquidTemplate = templateProvider.findTemplate(rcontext, r);
      if (liquidTemplate != null) {
        return generateByLiquid(rcontext, r, liquidTemplate, outputTracker);
      }
    }
    if (r instanceof ConceptMap) {
      return generate(rcontext, (ConceptMap) r); 
    } else if (r instanceof ValueSet) {
      return generate(rcontext, (ValueSet) r, true); 
    } else if (r instanceof CodeSystem) {
      return generate(rcontext, (CodeSystem) r, true, null); 
    } else if (r instanceof OperationOutcome) {
      return generate(rcontext, (OperationOutcome) r); 
    } else if (r instanceof CapabilityStatement) {
      return generate(rcontext, (CapabilityStatement) r);   
    } else if (r instanceof CompartmentDefinition) {
      return generate(rcontext, (CompartmentDefinition) r); 
    } else if (r instanceof OperationDefinition) {
      return generate(rcontext, (OperationDefinition) r);   
    } else if (r instanceof StructureDefinition) {
      return generate(rcontext, (StructureDefinition) r, outputTracker);   
    } else if (r instanceof List) {
      return generate(rcontext, (ListResource) r);    
    } else if (r instanceof ImplementationGuide) {
      return generate(rcontext, (ImplementationGuide) r);   
    } else if (r instanceof Provenance) {
      return generate(rcontext, new ResourceWrapperDirect(r), (Provenance) r);   
    } else if (r instanceof DiagnosticReport) {
      inject(r, generateDiagnosticReport(new ResourceWrapperDirect(r)),  NarrativeStatus.GENERATED);   // Maintainer = Grahame
      return true;
    } else {
      StructureDefinition p = null;
      if (r.hasMeta())
        for (UriType pu : r.getMeta().getProfile())
          if (p == null)
            p = context.fetchResource(StructureDefinition.class, pu.getValue());
      if (p == null)
        p = context.fetchResource(StructureDefinition.class, r.getResourceType().toString());
      if (p == null)
        p = context.fetchTypeDefinition(r.getResourceType().toString().toLowerCase());
      if (p != null)
        return generateByProfile(rcontext, p, true);
      else
        return false;
    }
  }


  private boolean generateByLiquid(ResourceContext rcontext, DomainResource r, String liquidTemplate, Set<String> outputTracker) {

    LiquidEngine engine = new LiquidEngine(context, services);
    XhtmlNode x;
    try {
      LiquidDocument doc = engine.parse(liquidTemplate, "template");
      String html = engine.evaluate(doc, r, rcontext);
      x = new XhtmlParser().parseFragment(html);
      if (!x.getName().equals("div"))
        throw new FHIRException("Error in template: Root element is not 'div'");
    } catch (FHIRException | IOException e) {
      x = new XhtmlNode(NodeType.Element, "div");
      x.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
    }
    inject(r, x,  NarrativeStatus.GENERATED);
    return true;
  }

  private interface PropertyWrapper {
    public String getName();
    public boolean hasValues();
    public List<BaseWrapper> getValues();
    public String getTypeCode();
    public String getDefinition();
    public int getMinCardinality();
    public int getMaxCardinality();
    public StructureDefinition getStructure();
    public BaseWrapper value();
  }

  private interface WrapperBase {
    public boolean has(String name);
    public Base get(String name) throws UnsupportedEncodingException, FHIRException, IOException;
    public List<BaseWrapper> children(String name) throws UnsupportedEncodingException, FHIRException, IOException;
    public List<PropertyWrapper> children();
  }

  private interface ResourceWrapper extends WrapperBase {
    public List<ResourceWrapper> getContained();
    public String getId();
    public XhtmlNode getNarrative() throws FHIRFormatError, IOException, FHIRException;
    public String getName();
    public void display(XhtmlNode x);
  }

  private interface BaseWrapper extends WrapperBase {
    public Base getBase() throws UnsupportedEncodingException, IOException, FHIRException;
    public PropertyWrapper getChildByName(String tail);
  }

  private abstract class WrapperBaseImpl implements WrapperBase {
    @Override
    public boolean has(String name) {
      for (PropertyWrapper p : children()) {
        if (p.getName().equals(name)) {
          return p.hasValues();
        }
      }
      return false;
    }

    @Override
    public Base get(String name) throws UnsupportedEncodingException, FHIRException, IOException {
      for (PropertyWrapper p : children()) {
        if (p.getName().equals(name)) {
          if (p.hasValues()) {
            return p.getValues().get(0).getBase();
          } else {
            return null;
          }
        }
      }
      return null;
    }

    @Override
    public List<BaseWrapper> children(String name) throws UnsupportedEncodingException, FHIRException, IOException {
      for (PropertyWrapper p : children()) {
        if (p.getName().equals(name)) {
          List<BaseWrapper> res = new ArrayList<>();
          for (BaseWrapper b : p.getValues()) {
            res.add(b);
          }
          return res;
        }
      }
      return null;
    }
  }

  private class BaseWrapperElement extends WrapperBaseImpl implements BaseWrapper {
    private Element element;
    private String type;
    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<ElementDefinition> children;
    private List<PropertyWrapper> list;

    public BaseWrapperElement(Element element, String type, StructureDefinition structure, ElementDefinition definition) {
      this.element = element;
      this.type = type;
      this.structure = structure;
      this.definition = definition;
    }

    @Override
    public Base getBase() throws UnsupportedEncodingException, IOException, FHIRException {
      if (type == null || type.equals("Resource") || type.equals("BackboneElement") || type.equals("Element"))
        return null;

      String xml;
      try {
        xml = new XmlGenerator().generate(element);
      } catch (org.hl7.fhir.exceptions.FHIRException e) {
        throw new FHIRException(e.getMessage(), e);
      }
      return parseType(xml, type);
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list == null) {
        children = profileUtilities.getChildList(structure, definition);
        list = new ArrayList<NarrativeGenerator.PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          XMLUtil.getNamedChildrenWithWildcard(element, tail(child.getPath()), elements);
          list.add(new PropertyWrapperElement(structure, child, elements));
        }
      }
      return list;
    }

    @Override
    public PropertyWrapper getChildByName(String name) {
      for (PropertyWrapper p : children())
        if (p.getName().equals(name))
          return p;
      return null;
    }

  }

  private class PropertyWrapperElement implements PropertyWrapper {

    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<Element> values;
    private List<BaseWrapper> list;

    public PropertyWrapperElement(StructureDefinition structure, ElementDefinition definition, List<Element> values) {
      this.structure = structure;
      this.definition = definition;
      this.values = values;
    }

    @Override
    public String getName() {
      return tail(definition.getPath());
    }

    @Override
    public boolean hasValues() {
      return values.size() > 0;
    }

    @Override
    public List<BaseWrapper> getValues() {
      if (list == null) {
        list = new ArrayList<NarrativeGenerator.BaseWrapper>();
        for (Element e : values)
          list.add(new BaseWrapperElement(e, determineType(e), structure, definition));
      }
      return list;
    }
    private String determineType(Element e) {
      if (definition.getType().isEmpty())
        return null;
      if (definition.getType().size() == 1) {
        if (definition.getType().get(0).getWorkingCode().equals("Element") || definition.getType().get(0).getWorkingCode().equals("BackboneElement"))
          return null;
        return definition.getType().get(0).getWorkingCode();
      }
      String t = e.getNodeName().substring(tail(definition.getPath()).length()-3);

      if (isPrimitive(Utilities.uncapitalize(t)))
        return Utilities.uncapitalize(t);
      else
        return t;
    }

    private boolean isPrimitive(String code) {
      StructureDefinition sd = context.fetchTypeDefinition(code);
      return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
    }

    @Override
    public String getTypeCode() {
      if (definition == null || definition.getType().size() != 1)
        throw new Error("not handled");
      return definition.getType().get(0).getWorkingCode();
    }

    @Override
    public String getDefinition() {
      if (definition == null)
        throw new Error("not handled");
      return definition.getDefinition();
    }

    @Override
    public int getMinCardinality() {
      if (definition == null)
        throw new Error("not handled");
      return definition.getMin();
    }

    @Override
    public int getMaxCardinality() {
      if (definition == null)
        throw new Error("not handled");
      return definition.getMax().equals("*") ? Integer.MAX_VALUE : Integer.parseInt(definition.getMax());
    }

    @Override
    public StructureDefinition getStructure() {
      return structure;
    }

    @Override
    public BaseWrapper value() {
      if (getValues().size() != 1)
        throw new Error("Access single value, but value count is "+getValues().size());
      return getValues().get(0);
    }

  }

  private class BaseWrapperMetaElement extends WrapperBaseImpl implements BaseWrapper {
    private org.hl7.fhir.r5.elementmodel.Element element;
    private String type;
    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<ElementDefinition> children;
    private List<PropertyWrapper> list;

    public BaseWrapperMetaElement(org.hl7.fhir.r5.elementmodel.Element element, String type, StructureDefinition structure, ElementDefinition definition) {
      this.element = element;
      this.type = type;
      this.structure = structure;
      this.definition = definition;
    }

    @Override
    public Base getBase() throws UnsupportedEncodingException, IOException, FHIRException {
      if (type == null || type.equals("Resource") || type.equals("BackboneElement") || type.equals("Element"))
        return null;

      if (element.hasElementProperty())
        return null;
      ByteArrayOutputStream xml = new ByteArrayOutputStream();
      try {
        new org.hl7.fhir.r5.elementmodel.XmlParser(context).compose(element, xml, OutputStyle.PRETTY, null);
      } catch (Exception e) {
        throw new FHIRException(e.getMessage(), e);
      }
      return parseType(xml.toString(), type); 
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list == null) {
        children = profileUtilities.getChildList(structure, definition);
        list = new ArrayList<NarrativeGenerator.PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<org.hl7.fhir.r5.elementmodel.Element> elements = new ArrayList<org.hl7.fhir.r5.elementmodel.Element>();
          String name = tail(child.getPath());
          if (name.endsWith("[x]"))
            element.getNamedChildrenWithWildcard(name, elements);
          else
            element.getNamedChildren(name, elements);
          list.add(new PropertyWrapperMetaElement(structure, child, elements));
        }
      }
      return list;
    }

    @Override
    public PropertyWrapper getChildByName(String name) {
      for (PropertyWrapper p : children())
        if (p.getName().equals(name))
          return p;
      return null;
    }

  }
  public class ResourceWrapperMetaElement extends WrapperBaseImpl implements ResourceWrapper {
    private org.hl7.fhir.r5.elementmodel.Element wrapped;
    private List<ResourceWrapper> list;
    private List<PropertyWrapper> list2;
    private StructureDefinition definition;
    public ResourceWrapperMetaElement(org.hl7.fhir.r5.elementmodel.Element wrapped) {
      this.wrapped = wrapped;
      this.definition = wrapped.getProperty().getStructure();
    }

    @Override
    public List<ResourceWrapper> getContained() {
      if (list == null) {
        List<org.hl7.fhir.r5.elementmodel.Element> children = wrapped.getChildrenByName("contained");
        list = new ArrayList<NarrativeGenerator.ResourceWrapper>();
        for (org.hl7.fhir.r5.elementmodel.Element e : children) {
          list.add(new ResourceWrapperMetaElement(e));
        }
      }
      return list;
    }

    @Override
    public String getId() {
      return wrapped.getNamedChildValue("id");
    }

    @Override
    public XhtmlNode getNarrative() throws FHIRFormatError, IOException, FHIRException {
      org.hl7.fhir.r5.elementmodel.Element txt = wrapped.getNamedChild("text");
      if (txt == null)
        return null;
      org.hl7.fhir.r5.elementmodel.Element div = txt.getNamedChild("div");
      if (div == null)
        return null;
      else
        return div.getXhtml();
    }

    @Override
    public String getName() {
      return wrapped.getName();
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list2 == null) {
        List<ElementDefinition> children = profileUtilities.getChildList(definition, definition.getSnapshot().getElement().get(0));
        list2 = new ArrayList<NarrativeGenerator.PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<org.hl7.fhir.r5.elementmodel.Element> elements = new ArrayList<org.hl7.fhir.r5.elementmodel.Element>();
          if (child.getPath().endsWith("[x]"))
            wrapped.getNamedChildrenWithWildcard(tail(child.getPath()), elements);
          else
            wrapped.getNamedChildren(tail(child.getPath()), elements);
          list2.add(new PropertyWrapperMetaElement(definition, child, elements));
        }
      }
      return list2;
    }

    @Override
    public void display(XhtmlNode x) {
      if (wrapped.hasChild("title") && wrapped.getChildValue("title") != null) {
        x.tx(wrapped.getChildValue("title"));
      } else if (wrapped.hasChild("name") && wrapped.getChildValue("name") != null) {
        x.tx(wrapped.getChildValue("name"));       
      } else {
        x.tx("?ngen-1?");
      }
    }
  }

  private class PropertyWrapperMetaElement implements PropertyWrapper {

    private StructureDefinition structure;
    private ElementDefinition definition;
    private List<org.hl7.fhir.r5.elementmodel.Element> values;
    private List<BaseWrapper> list;

    public PropertyWrapperMetaElement(StructureDefinition structure, ElementDefinition definition, List<org.hl7.fhir.r5.elementmodel.Element> values) {
      this.structure = structure;
      this.definition = definition;
      this.values = values;
    }

    @Override
    public String getName() {
      return tail(definition.getPath());
    }

    @Override
    public boolean hasValues() {
      return values.size() > 0;
    }

    @Override
    public List<BaseWrapper> getValues() {
      if (list == null) {
        list = new ArrayList<NarrativeGenerator.BaseWrapper>();
        for (org.hl7.fhir.r5.elementmodel.Element e : values)
          list.add(new BaseWrapperMetaElement(e, e.fhirType(), structure, definition));
      }
      return list;
    }

    @Override
    public String getTypeCode() {
      return definition.typeSummary();
    }

    @Override
    public String getDefinition() {
      return definition.getDefinition();
    }

    @Override
    public int getMinCardinality() {
      return definition.getMin();
    }

    @Override
    public int getMaxCardinality() {
      return "*".equals(definition.getMax()) ? Integer.MAX_VALUE : Integer.valueOf(definition.getMax());
    }

    @Override
    public StructureDefinition getStructure() {
      return structure;
    }

    @Override
    public BaseWrapper value() {
      if (getValues().size() != 1)
        throw new Error("Access single value, but value count is "+getValues().size());
      return getValues().get(0);
    }

  }

  private class ResourceWrapperElement extends WrapperBaseImpl implements ResourceWrapper {

    private Element wrapped;
    private StructureDefinition definition;
    private List<ResourceWrapper> list;
    private List<PropertyWrapper> list2;

    public ResourceWrapperElement(Element wrapped, StructureDefinition definition) {
      this.wrapped = wrapped;
      this.definition = definition;
    }

    @Override
    public List<ResourceWrapper> getContained() {
      if (list == null) {
        List<Element> children = new ArrayList<Element>();
        XMLUtil.getNamedChildren(wrapped, "contained", children);
        list = new ArrayList<NarrativeGenerator.ResourceWrapper>();
        for (Element e : children) {
          Element c = XMLUtil.getFirstChild(e);
          list.add(new ResourceWrapperElement(c, context.fetchTypeDefinition(c.getNodeName())));
        }
      }
      return list;
    }

    @Override
    public String getId() {
      return XMLUtil.getNamedChildValue(wrapped, "id");
    }

    @Override
    public XhtmlNode getNarrative() throws FHIRFormatError, IOException, FHIRException {
      Element txt = XMLUtil.getNamedChild(wrapped, "text");
      if (txt == null)
        return null;
      Element div = XMLUtil.getNamedChild(txt, "div");
      if (div == null)
        return null;
      try {
        return new XhtmlParser().parse(new XmlGenerator().generate(div), "div");
      } catch (org.hl7.fhir.exceptions.FHIRFormatError e) {
        throw new FHIRFormatError(e.getMessage(), e);
      } catch (org.hl7.fhir.exceptions.FHIRException e) {
        throw new FHIRException(e.getMessage(), e);
      }
    }

    @Override
    public String getName() {
      return wrapped.getNodeName();
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list2 == null) {
        List<ElementDefinition> children = profileUtilities.getChildList(definition, definition.getSnapshot().getElement().get(0));
        list2 = new ArrayList<NarrativeGenerator.PropertyWrapper>();
        for (ElementDefinition child : children) {
          List<Element> elements = new ArrayList<Element>();
          XMLUtil.getNamedChildrenWithWildcard(wrapped, tail(child.getPath()), elements);
          list2.add(new PropertyWrapperElement(definition, child, elements));
        }
      }
      return list2;
    }



    @Override
    public void display(XhtmlNode x) {
      throw new Error("Not done yet");      
    }
  }

  private class PropertyWrapperDirect implements PropertyWrapper {
    private Property wrapped;
    private List<BaseWrapper> list;

    private PropertyWrapperDirect(Property wrapped) {
      super();
      if (wrapped == null)
        throw new Error("wrapped == null");
      this.wrapped = wrapped;
    }

    @Override
    public String getName() {
      return wrapped.getName();
    }

    @Override
    public boolean hasValues() {
      return wrapped.hasValues();
    }

    @Override
    public List<BaseWrapper> getValues() {
      if (list == null) {
        list = new ArrayList<NarrativeGenerator.BaseWrapper>();
        for (Base b : wrapped.getValues())
          list.add(b == null ? null : new BaseWrapperDirect(b));
      }
      return list;
    }

    @Override
    public String getTypeCode() {
      return wrapped.getTypeCode();
    }

    @Override
    public String getDefinition() {
      return wrapped.getDefinition();
    }

    @Override
    public int getMinCardinality() {
      return wrapped.getMinCardinality();
    }

    @Override
    public int getMaxCardinality() {
      return wrapped.getMinCardinality();
    }

    @Override
    public StructureDefinition getStructure() {
      return wrapped.getStructure();
    }

    @Override
    public BaseWrapper value() {
      if (getValues().size() != 1)
        throw new Error("Access single value, but value count is "+getValues().size());
      return getValues().get(0);
    }

    public String toString() {
      return "#."+wrapped.toString();
    }
  }

  private class BaseWrapperDirect extends WrapperBaseImpl implements BaseWrapper {
    private Base wrapped;
    private List<PropertyWrapper> list;

    private BaseWrapperDirect(Base wrapped) {
      super();
      if (wrapped == null)
        throw new Error("wrapped == null");
      this.wrapped = wrapped;
    }

    @Override
    public Base getBase() {
      return wrapped;
    }

    @Override
    public List<PropertyWrapper> children() {
      if (list == null) {
        list = new ArrayList<NarrativeGenerator.PropertyWrapper>();
        for (Property p : wrapped.children())
          list.add(new PropertyWrapperDirect(p));
      }
      return list;

    }

    @Override
    public PropertyWrapper getChildByName(String name) {
      Property p = wrapped.getChildByName(name);
      if (p == null)
        return null;
      else
        return new PropertyWrapperDirect(p);
    }

  }

  public class ResourceWrapperDirect extends WrapperBaseImpl implements ResourceWrapper {
    private Resource wrapped;

    public ResourceWrapperDirect(Resource wrapped) {
      super();
      if (wrapped == null)
        throw new Error("wrapped == null");
      this.wrapped = wrapped;
    }

    @Override
    public List<ResourceWrapper> getContained() {
      List<ResourceWrapper> list = new ArrayList<NarrativeGenerator.ResourceWrapper>();
      if (wrapped instanceof DomainResource) {
        DomainResource dr = (DomainResource) wrapped;
        for (Resource c : dr.getContained()) {
          list.add(new ResourceWrapperDirect(c));
        }
      }
      return list;
    }

    @Override
    public String getId() {
      return wrapped.getId();
    }

    @Override
    public XhtmlNode getNarrative() {
      if (wrapped instanceof DomainResource) {
        DomainResource dr = (DomainResource) wrapped;
        if (dr.hasText() && dr.getText().hasDiv())
          return dr.getText().getDiv();
      }
      return null;
    }

    @Override
    public String getName() {
      return wrapped.getResourceType().toString();
    }

    @Override
    public List<PropertyWrapper> children() {
      List<PropertyWrapper> list = new ArrayList<PropertyWrapper>();
      if (wrapped.children() != null) {
        for (Property c : wrapped.children())
          list.add(new PropertyWrapperDirect(c));
      }
      return list;
    }

    @Override
    public void display(XhtmlNode x) {
      if (wrapped instanceof CanonicalResource) {
        x.tx(((CanonicalResource) wrapped).present());
      } else if (wrapped instanceof Patient) {
        displayPatient(x, (Patient) wrapped);
      } else if (wrapped instanceof Encounter) {
        displayEncounter(x, (Encounter) wrapped);
      }
    }
  }

  public static class ResourceWithReference {

    private String reference;
    private ResourceWrapper resource;

    public ResourceWithReference(String reference, ResourceWrapper resource) {
      this.reference = reference;
      this.resource = resource;
    }

    public String getReference() {
      return reference;
    }

    public ResourceWrapper getResource() {
      return resource;
    }
  }

  private String prefix;
  private IWorkerContext context;
  private String basePath;
  private String tooCostlyNoteEmpty;
  private String tooCostlyNoteNotEmpty;
  private String tooCostlyNoteEmptyDependent;
  private String tooCostlyNoteNotEmptyDependent;
  private IReferenceResolver resolver;
  private int headerLevelContext;
  private boolean pretty;
  private boolean canonicalUrlsAsLinks;
  private ValidationOptions terminologyServiceOptions = new ValidationOptions();
  private boolean noSlowLookup;
  private List<String> codeSystemPropList = new ArrayList<>();
  private ProfileUtilities profileUtilities;
  private XVerExtensionManager xverManager;

  public NarrativeGenerator(String prefix, String basePath, IWorkerContext context) {
    super();
    this.prefix = prefix;
    this.context = context;
    this.basePath = basePath;
    init();
  }

  public NarrativeGenerator setLiquidServices(ILiquidTemplateProvider templateProvider, IEvaluationContext services) {
    this.templateProvider = templateProvider;
    this.services = services;
    return this;
  }

  public Base parseType(String xml, String type) throws IOException, FHIRException {
    if (parser != null)
      return parser.parseType(xml, type);
    else
      return new XmlParser().parseAnyType(xml, type);
  }

  public NarrativeGenerator(String prefix, String basePath, IWorkerContext context, IReferenceResolver resolver) {
    super();
    this.prefix = prefix;
    this.context = context;
    this.basePath = basePath;
    this.resolver = resolver;
    init();
  }


  private void init() {
    profileUtilities = new ProfileUtilities(context, null, null); 
  }


  public int getHeaderLevelContext() {
    return headerLevelContext;
  }

  public NarrativeGenerator setHeaderLevelContext(int headerLevelContext) {
    this.headerLevelContext = headerLevelContext;
    return this;
  }

  public String getTooCostlyNoteEmpty() {
    return tooCostlyNoteEmpty;
  }


  public NarrativeGenerator setTooCostlyNoteEmpty(String tooCostlyNoteEmpty) {
    this.tooCostlyNoteEmpty = tooCostlyNoteEmpty;
    return this;
  }


  public String getTooCostlyNoteNotEmpty() {
    return tooCostlyNoteNotEmpty;
  }


  public NarrativeGenerator setTooCostlyNoteNotEmpty(String tooCostlyNoteNotEmpty) {
    this.tooCostlyNoteNotEmpty = tooCostlyNoteNotEmpty;
    return this;
  }


  public String getTooCostlyNoteEmptyDependent() {
    return tooCostlyNoteEmptyDependent;
  }

  public void setTooCostlyNoteEmptyDependent(String tooCostlyNoteEmptyDependent) {
    this.tooCostlyNoteEmptyDependent = tooCostlyNoteEmptyDependent;
  }

  public String getTooCostlyNoteNotEmptyDependent() {
    return tooCostlyNoteNotEmptyDependent;
  }

  public void setTooCostlyNoteNotEmptyDependent(String tooCostlyNoteNotEmptyDependent) {
    this.tooCostlyNoteNotEmptyDependent = tooCostlyNoteNotEmptyDependent;
  }

  // dom based version, for build program
  public String generate(Element doc) throws IOException, org.hl7.fhir.exceptions.FHIRException {
    return generate(null, doc);
  }
  public String generate(ResourceContext rcontext, Element doc) throws IOException, org.hl7.fhir.exceptions.FHIRException {
    if (rcontext == null)
      rcontext = new ResourceContext(null, doc);
    String rt = "http://hl7.org/fhir/StructureDefinition/"+doc.getNodeName();
    StructureDefinition p = context.fetchResource(StructureDefinition.class, rt);
    return generateByProfile(doc, p, true);
  }

  // dom based version, for build program
  public String generate(org.hl7.fhir.r5.elementmodel.Element er, boolean showCodeDetails, ITypeParser parser) throws IOException, FHIRException, EOperationOutcome {
    return generate(null, er, showCodeDetails, parser);
  }

  public String generate(ResourceContext rcontext, org.hl7.fhir.r5.elementmodel.Element er, boolean showCodeDetails, ITypeParser parser) throws IOException, FHIRException, EOperationOutcome {
    if (rcontext == null)
      rcontext = new ResourceContext(null, er);
    this.parser = parser;

    ResourceWrapperMetaElement resw = new ResourceWrapperMetaElement(er);
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    if ("List".equals(resw.getName())) {
      generateList(x, resw); 
    } else {
      x.para().b().tx("Generated Narrative"+(showCodeDetails ? " with Details" : ""));
      try {
        BaseWrapperMetaElement base = new BaseWrapperMetaElement(er, null, er.getProperty().getStructure(), er.getProperty().getDefinition());
        base.children();
        generateByProfile(resw, er.getProperty().getStructure(), base, er.getProperty().getStructure().getSnapshot().getElement(), er.getProperty().getDefinition(), base.children, x, er.fhirType(), showCodeDetails, 0, rcontext);

      } catch (Exception e) {
        e.printStackTrace();
        x.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
      }
    }
    inject(er, x,  NarrativeStatus.GENERATED);
    return new XhtmlComposer(XhtmlComposer.XML, pretty).compose(x);
  }

  private boolean generateByProfile(ResourceContext rc, StructureDefinition profile, boolean showCodeDetails) {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.para().b().tx("Generated Narrative"+(showCodeDetails ? " with Details" : ""));
    try {
      generateByProfile(rc.resourceResource, profile, rc.resourceResource, profile.getSnapshot().getElement(), profile.getSnapshot().getElement().get(0), getChildrenForPath(profile.getSnapshot().getElement(), rc.resourceResource.getResourceType().toString()), x, rc.resourceResource.getResourceType().toString(), showCodeDetails, rc);
    } catch (Exception e) {
      e.printStackTrace();
      x.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
    }
    inject(rc.resourceResource, x,  NarrativeStatus.GENERATED);
    return true;
  }

  private String generateByProfile(Element er, StructureDefinition profile, boolean showCodeDetails) throws IOException, org.hl7.fhir.exceptions.FHIRException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.para().b().tx("Generated Narrative"+(showCodeDetails ? " with Details" : ""));
    try {
      generateByProfile(er, profile, er, profile.getSnapshot().getElement(), profile.getSnapshot().getElement().get(0), getChildrenForPath(profile.getSnapshot().getElement(), er.getLocalName()), x, er.getLocalName(), showCodeDetails);
    } catch (Exception e) {
      e.printStackTrace();
      x.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
    }
    inject(er, x,  NarrativeStatus.GENERATED);
    String b = new XhtmlComposer(XhtmlComposer.XML, pretty).compose(x);
    return b;
  }

  private void generateByProfile(Element eres, StructureDefinition profile, Element ee, List<ElementDefinition> allElements, ElementDefinition defn, List<ElementDefinition> children,  XhtmlNode x, String path, boolean showCodeDetails) throws FHIRException, UnsupportedEncodingException, IOException {

    ResourceWrapperElement resw = new ResourceWrapperElement(eres, profile);
    BaseWrapperElement base = new BaseWrapperElement(ee, null, profile, profile.getSnapshot().getElement().get(0));
    generateByProfile(resw, profile, base, allElements, defn, children, x, path, showCodeDetails, 0, null);
  }


  private void generateByProfile(Resource res, StructureDefinition profile, Base e, List<ElementDefinition> allElements, ElementDefinition defn, List<ElementDefinition> children,  XhtmlNode x, String path, boolean showCodeDetails, ResourceContext rc) throws FHIRException, UnsupportedEncodingException, IOException {
    generateByProfile(new ResourceWrapperDirect(res), profile, new BaseWrapperDirect(e), allElements, defn, children, x, path, showCodeDetails, 0, rc);
  }

  private void generateByProfile(ResourceWrapper res, StructureDefinition profile, BaseWrapper e, List<ElementDefinition> allElements, ElementDefinition defn, List<ElementDefinition> children,  XhtmlNode x, String path, boolean showCodeDetails, int indent, ResourceContext rc) throws FHIRException, UnsupportedEncodingException, IOException {
    if (children.isEmpty()) {
      renderLeaf(res, e, defn, x, false, showCodeDetails, readDisplayHints(defn), path, indent, rc);
    } else {
      for (PropertyWrapper p : splitExtensions(profile, e.children())) {
        if (p.hasValues()) {
          ElementDefinition child = getElementDefinition(children, path+"."+p.getName(), p);
          if (child != null) {
            Map<String, String> displayHints = readDisplayHints(child);
            if (!exemptFromRendering(child)) {
              List<ElementDefinition> grandChildren = getChildrenForPath(allElements, path+"."+p.getName());
              filterGrandChildren(grandChildren, path+"."+p.getName(), p);
              if (p.getValues().size() > 0 && child != null) {
                if (isPrimitive(child)) {
                  XhtmlNode para = x.para();
                  String name = p.getName();
                  if (name.endsWith("[x]"))
                    name = name.substring(0, name.length() - 3);
                  if (showCodeDetails || !isDefaultValue(displayHints, p.getValues())) {
                    para.b().addText(name);
                    para.tx(": ");
                    if (renderAsList(child) && p.getValues().size() > 1) {
                      XhtmlNode list = x.ul();
                      for (BaseWrapper v : p.getValues())
                        renderLeaf(res, v, child, list.li(), false, showCodeDetails, displayHints, path, indent, rc);
                    } else {
                      boolean first = true;
                      for (BaseWrapper v : p.getValues()) {
                        if (first)
                          first = false;
                        else
                          para.tx(", ");
                        renderLeaf(res, v, child, para, false, showCodeDetails, displayHints, path, indent, rc);
                      }
                    }
                  }
                } else if (canDoTable(path, p, grandChildren)) {
                  x.addTag(getHeader()).addText(Utilities.capitalize(Utilities.camelCase(Utilities.pluralizeMe(p.getName()))));
                  XhtmlNode tbl = x.table( "grid");
                  XhtmlNode tr = tbl.tr();
                  tr.td().tx("-"); // work around problem with empty table rows
                  addColumnHeadings(tr, grandChildren);
                  for (BaseWrapper v : p.getValues()) {
                    if (v != null) {
                      tr = tbl.tr();
                      tr.td().tx("*"); // work around problem with empty table rows
                      addColumnValues(res, tr, grandChildren, v, showCodeDetails, displayHints, path, indent, rc);
                    }
                  }
                } else {
                  for (BaseWrapper v : p.getValues()) {
                    if (v != null) {
                      XhtmlNode bq = x.addTag("blockquote");
                      bq.para().b().addText(p.getName());
                      generateByProfile(res, profile, v, allElements, child, grandChildren, bq, path+"."+p.getName(), showCodeDetails, indent+1, rc);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  private String getHeader() {
    int i = 3;
    while (i <= headerLevelContext)
      i++;
    if (i > 6)
      i = 6;
    return "h"+Integer.toString(i);
  }

  private void filterGrandChildren(List<ElementDefinition> grandChildren,  String string, PropertyWrapper prop) {
    List<ElementDefinition> toRemove = new ArrayList<ElementDefinition>();
    toRemove.addAll(grandChildren);
    for (BaseWrapper b : prop.getValues()) {
      List<ElementDefinition> list = new ArrayList<ElementDefinition>();
      for (ElementDefinition ed : toRemove) {
        PropertyWrapper p = b.getChildByName(tail(ed.getPath()));
        if (p != null && p.hasValues())
          list.add(ed);
      }
      toRemove.removeAll(list);
    }
    grandChildren.removeAll(toRemove);
  }

  private List<PropertyWrapper> splitExtensions(StructureDefinition profile, List<PropertyWrapper> children) throws UnsupportedEncodingException, IOException, FHIRException {
    List<PropertyWrapper> results = new ArrayList<PropertyWrapper>();
    Map<String, PropertyWrapper> map = new HashMap<String, PropertyWrapper>();
    for (PropertyWrapper p : children)
      if (p.getName().equals("extension") || p.getName().equals("modifierExtension")) {
        // we're going to split these up, and create a property for each url
        if (p.hasValues()) {
          for (BaseWrapper v : p.getValues()) {
            Extension ex  = (Extension) v.getBase();
            String url = ex.getUrl();
            StructureDefinition ed = context.fetchResource(StructureDefinition.class, url);
            if (ed == null) {
              if (xverManager == null) {
                xverManager = new XVerExtensionManager(context);
              }
              if (xverManager.matchingUrl(url) && xverManager.status(url) == XVerExtensionStatus.Valid) {
                ed = xverManager.makeDefinition(url);
                context.generateSnapshot(ed);
                context.cacheResource(ed);
              }
            }
            if (p.getName().equals("modifierExtension") && ed == null)
              throw new DefinitionException("Unknown modifier extension "+url);
            PropertyWrapper pe = map.get(p.getName()+"["+url+"]");
            if (pe == null) {
              if (ed == null) {
                if (url.startsWith("http://hl7.org/fhir") && !url.startsWith("http://hl7.org/fhir/us"))
                  throw new DefinitionException("unknown extension "+url);
                // System.out.println("unknown extension "+url);
                pe = new PropertyWrapperDirect(new Property(p.getName()+"["+url+"]", p.getTypeCode(), p.getDefinition(), p.getMinCardinality(), p.getMaxCardinality(), ex));
              } else {
                ElementDefinition def = ed.getSnapshot().getElement().get(0);
                pe = new PropertyWrapperDirect(new Property(p.getName()+"["+url+"]", "Extension", def.getDefinition(), def.getMin(), def.getMax().equals("*") ? Integer.MAX_VALUE : Integer.parseInt(def.getMax()), ex));
                ((PropertyWrapperDirect) pe).wrapped.setStructure(ed);
              }
              results.add(pe);
            } else
              pe.getValues().add(v);
          }
        }
      } else
        results.add(p);
    return results;
  }

  @SuppressWarnings("rawtypes")
  private boolean isDefaultValue(Map<String, String> displayHints, List<BaseWrapper> list) throws UnsupportedEncodingException, IOException, FHIRException {
    if (list.size() != 1)
      return false;
    if (list.get(0).getBase() instanceof PrimitiveType)
      return isDefault(displayHints, (PrimitiveType) list.get(0).getBase());
    else
      return false;
  }

  private boolean isDefault(Map<String, String> displayHints, PrimitiveType primitiveType) {
    String v = primitiveType.asStringValue();
    if (!Utilities.noString(v) && displayHints.containsKey("default") && v.equals(displayHints.get("default")))
      return true;
    return false;
  }

  private boolean exemptFromRendering(ElementDefinition child) {
    if (child == null)
      return false;
    if ("Composition.subject".equals(child.getPath()))
      return true;
    if ("Composition.section".equals(child.getPath()))
      return true;
    return false;
  }

  private boolean renderAsList(ElementDefinition child) {
    if (child.getType().size() == 1) {
      String t = child.getType().get(0).getWorkingCode();
      if (t.equals("Address") || t.equals("Reference"))
        return true;
    }
    return false;
  }

  private void addColumnHeadings(XhtmlNode tr, List<ElementDefinition> grandChildren) {
    for (ElementDefinition e : grandChildren)
      tr.td().b().addText(Utilities.capitalize(tail(e.getPath())));
  }

  private void addColumnValues(ResourceWrapper res, XhtmlNode tr, List<ElementDefinition> grandChildren, BaseWrapper v, boolean showCodeDetails, Map<String, String> displayHints, String path, int indent, ResourceContext rc) throws FHIRException, UnsupportedEncodingException, IOException {
    for (ElementDefinition e : grandChildren) {
      PropertyWrapper p = v.getChildByName(e.getPath().substring(e.getPath().lastIndexOf(".")+1));
      if (p == null || p.getValues().size() == 0 || p.getValues().get(0) == null)
        tr.td().tx(" ");
      else
        renderLeaf(res, p.getValues().get(0), e, tr.td(), false, showCodeDetails, displayHints, path, indent, rc);
    }
  }

  private String tail(String path) {
    return path.substring(path.lastIndexOf(".")+1);
  }

  private boolean canDoTable(String path, PropertyWrapper p, List<ElementDefinition> grandChildren) {
    for (ElementDefinition e : grandChildren) {
      List<PropertyWrapper> values = getValues(path, p, e);
      if (values.size() > 1 || !isPrimitive(e) || !canCollapse(e))
        return false;
    }
    return true;
  }

  private List<PropertyWrapper> getValues(String path, PropertyWrapper p, ElementDefinition e) {
    List<PropertyWrapper> res = new ArrayList<PropertyWrapper>();
    for (BaseWrapper v : p.getValues()) {
      for (PropertyWrapper g : v.children()) {
        if ((path+"."+p.getName()+"."+g.getName()).equals(e.getPath()))
          res.add(p);
      }
    }
    return res;
  }

  private boolean canCollapse(ElementDefinition e) {
    // we can collapse any data type
    return !e.getType().isEmpty();
  }

  private boolean isPrimitive(ElementDefinition e) {
    //we can tell if e is a primitive because it has types
    if (e.getType().isEmpty())
      return false;
    if (e.getType().size() == 1 && isBase(e.getType().get(0).getWorkingCode()))
      return false;
    return true;
    //    return !e.getType().isEmpty()
  }

  private boolean isBase(String code) {
    return code.equals("Element") || code.equals("BackboneElement");
  }

  private ElementDefinition getElementDefinition(List<ElementDefinition> elements, String path, PropertyWrapper p) {
    for (ElementDefinition element : elements)
      if (element.getPath().equals(path))
        return element;
    if (path.endsWith("\"]") && p.getStructure() != null)
      return p.getStructure().getSnapshot().getElement().get(0);
    return null;
  }

  private void renderLeaf(ResourceWrapper res, BaseWrapper ew, ElementDefinition defn, XhtmlNode x, boolean title, boolean showCodeDetails, Map<String, String> displayHints, String path, int indent, ResourceContext rc) throws FHIRException, UnsupportedEncodingException, IOException {
    if (ew == null)
      return;


    Base e = ew.getBase();

    if (e instanceof StringType)
      x.addText(((StringType) e).getValue());
    else if (e instanceof CodeType)
      x.addText(((CodeType) e).getValue());
    else if (e instanceof IdType)
      x.addText(((IdType) e).getValue());
    else if (e instanceof Extension)
      return;
    else if (e instanceof InstantType)
      x.addText(((InstantType) e).toHumanDisplay());
    else if (e instanceof DateTimeType) {
      renderDateTime(x, e);
    } else if (e instanceof Base64BinaryType)
      x.addText(new Base64().encodeAsString(((Base64BinaryType) e).getValue()));
    else if (e instanceof org.hl7.fhir.r5.model.DateType)
      x.addText(((org.hl7.fhir.r5.model.DateType) e).toHumanDisplay());
    else if (e instanceof Enumeration) {
      Object ev = ((Enumeration<?>) e).getValue();
      x.addText(ev == null ? "" : ev.toString()); // todo: look up a display name if there is one
    } else if (e instanceof BooleanType)
      x.addText(((BooleanType) e).getValue().toString());
    else if (e instanceof CodeableConcept) {
      renderCodeableConcept((CodeableConcept) e, x, showCodeDetails);
    } else if (e instanceof Coding) {
      renderCoding((Coding) e, x, showCodeDetails);
    } else if (e instanceof Annotation) {
      renderAnnotation((Annotation) e, x);
    } else if (e instanceof Identifier) {
      renderIdentifier((Identifier) e, x);
    } else if (e instanceof org.hl7.fhir.r5.model.IntegerType) {
      x.addText(Integer.toString(((org.hl7.fhir.r5.model.IntegerType) e).getValue()));
    } else if (e instanceof org.hl7.fhir.r5.model.DecimalType) {
      x.addText(((org.hl7.fhir.r5.model.DecimalType) e).getValue().toString());
    } else if (e instanceof HumanName) {
      renderHumanName((HumanName) e, x);
    } else if (e instanceof SampledData) {
      renderSampledData((SampledData) e, x);
    } else if (e instanceof Address) {
      renderAddress((Address) e, x);
    } else if (e instanceof ContactPoint) {
      renderContactPoint((ContactPoint) e, x);
    } else if (e instanceof ContactDetail) {
      ContactDetail cd = (ContactDetail) e;
      if (cd.hasName()) {
        x.tx(cd.getName()+": ");
      }
      boolean first = true;
      for (ContactPoint c : cd.getTelecom()) {
        if (first) first = false; else x.tx(",");
        renderContactPoint(c, x);
      }
    } else if (e instanceof UriType) {
      renderUri((UriType) e, x, defn.getPath(), rc != null && rc.resourceResource != null ? rc.resourceResource.getId() : null);
    } else if (e instanceof Timing) {
      renderTiming((Timing) e, x);
    } else if (e instanceof Range) {
      renderRange((Range) e, x);
    } else if (e instanceof Quantity) {
      renderQuantity((Quantity) e, x, showCodeDetails);
    } else if (e instanceof Ratio) {
      renderQuantity(((Ratio) e).getNumerator(), x, showCodeDetails);
      x.tx("/");
      renderQuantity(((Ratio) e).getDenominator(), x, showCodeDetails);
    } else if (e instanceof Period) {
      Period p = (Period) e;
      renderPeriod(x, p);
    } else if (e instanceof Reference) {
      Reference r = (Reference) e;
      renderReference(rc, res, x, r);
    } else if (e instanceof Resource) {
      return;
    } else if (e instanceof ElementDefinition) {
      x.tx("todo-bundle");
    } else if (e != null && !(e instanceof Attachment) && !(e instanceof Narrative) && !(e instanceof Meta)) {
      StructureDefinition sd = context.fetchTypeDefinition(e.fhirType());
      if (sd == null)
        throw new NotImplementedException("type "+e.getClass().getName()+" not handled yet, and no structure found");
      else
        generateByProfile(res, sd, ew, sd.getSnapshot().getElement(), sd.getSnapshot().getElementFirstRep(),
            getChildrenForPath(sd.getSnapshot().getElement(), sd.getSnapshot().getElementFirstRep().getPath()), x, path, showCodeDetails, indent + 1, rc);
    }
  }

  public void renderReference(ResourceContext rc, ResourceWrapper res, XhtmlNode x, Reference r) throws UnsupportedEncodingException, IOException {
    XhtmlNode c = x;
    ResourceWithReference tr = null;
    if (r.hasReferenceElement()) {
      tr = resolveReference(res, r.getReference(), rc);

      if (!r.getReference().startsWith("#")) {
        if (tr != null && tr.getReference() != null)
          c = x.ah(tr.getReference());
        else
          c = x.ah(r.getReference());
      }
    }
    // what to display: if text is provided, then that. if the reference was resolved, then show the generated narrative
    if (r.hasDisplayElement()) {
      c.addText(r.getDisplay());
      if (tr != null && tr.getResource() != null) {
        c.tx(". Generated Summary: ");
        generateResourceSummary(c, tr.getResource(), true, r.getReference().startsWith("#"), rc);
      }
    } else if (tr != null && tr.getResource() != null) {
      generateResourceSummary(c, tr.getResource(), r.getReference().startsWith("#"), r.getReference().startsWith("#"), rc);
    } else {
      c.addText(r.getReference());
    }
  }

  public void renderDateTime(XhtmlNode x, Base e) {
    if (e.hasPrimitiveValue())
      x.addText(((DateTimeType) e).toHumanDisplay());
  }

  public void renderPeriod(XhtmlNode x, Period p) {
    x.addText(!p.hasStart() ? "??" : p.getStartElement().toHumanDisplay());
    x.tx(" --> ");
    x.addText(!p.hasEnd() ? "(ongoing)" : p.getEndElement().toHumanDisplay());
  }

  private boolean displayLeaf(ResourceWrapper res, BaseWrapper ew, ElementDefinition defn, XhtmlNode x, String name, boolean showCodeDetails, ResourceContext rc) throws FHIRException, UnsupportedEncodingException, IOException {
    if (ew == null)
      return false;
    Base e = ew.getBase();
    if (e == null)
      return false;

    Map<String, String> displayHints = readDisplayHints(defn);

    if (name.endsWith("[x]"))
      name = name.substring(0, name.length() - 3);

    if (!showCodeDetails && e instanceof PrimitiveType && isDefault(displayHints, ((PrimitiveType) e)))
      return false;

    if (e instanceof StringType) {
      x.addText(name+": "+((StringType) e).getValue());
      return true;
    } else if (e instanceof CodeType) {
      x.addText(name+": "+((CodeType) e).getValue());
      return true;
    } else if (e instanceof IdType) {
      x.addText(name+": "+((IdType) e).getValue());
      return true;
    } else if (e instanceof UriType) {
      x.addText(name+": "+((UriType) e).getValue());
      return true;
    } else if (e instanceof DateTimeType) {
      x.addText(name+": "+((DateTimeType) e).toHumanDisplay());
      return true;
    } else if (e instanceof InstantType) {
      x.addText(name+": "+((InstantType) e).toHumanDisplay());
      return true;
    } else if (e instanceof Extension) {
      //      x.tx("Extensions: todo");
      return false;
    } else if (e instanceof org.hl7.fhir.r5.model.DateType) {
      x.addText(name+": "+((org.hl7.fhir.r5.model.DateType) e).toHumanDisplay());
      return true;
    } else if (e instanceof Enumeration) {
      x.addText(((Enumeration<?>) e).getValue().toString()); // todo: look up a display name if there is one
      return true;
    } else if (e instanceof BooleanType) {
      if (((BooleanType) e).getValue()) {
        x.addText(name);
        return true;
      }
    } else if (e instanceof CodeableConcept) {
      renderCodeableConcept((CodeableConcept) e, x, showCodeDetails);
      return true;
    } else if (e instanceof Coding) {
      renderCoding((Coding) e, x, showCodeDetails);
      return true;
    } else if (e instanceof Annotation) {
      renderAnnotation((Annotation) e, x, showCodeDetails);
      return true;
    } else if (e instanceof org.hl7.fhir.r5.model.IntegerType) {
      x.addText(Integer.toString(((org.hl7.fhir.r5.model.IntegerType) e).getValue()));
      return true;
    } else if (e instanceof org.hl7.fhir.r5.model.DecimalType) {
      x.addText(((org.hl7.fhir.r5.model.DecimalType) e).getValue().toString());
      return true;
    } else if (e instanceof Identifier) {
      renderIdentifier((Identifier) e, x);
      return true;
    } else if (e instanceof HumanName) {
      renderHumanName((HumanName) e, x);
      return true;
    } else if (e instanceof SampledData) {
      renderSampledData((SampledData) e, x);
      return true;
    } else if (e instanceof Address) {
      renderAddress((Address) e, x);
      return true;
    } else if (e instanceof ContactPoint) {
      renderContactPoint((ContactPoint) e, x);
      return true;
    } else if (e instanceof Timing) {
      renderTiming((Timing) e, x);
      return true;
    } else if (e instanceof Quantity) {
      renderQuantity((Quantity) e, x, showCodeDetails);
      return true;
    } else if (e instanceof Ratio) {
      renderQuantity(((Ratio) e).getNumerator(), x, showCodeDetails);
      x.tx("/");
      renderQuantity(((Ratio) e).getDenominator(), x, showCodeDetails);
      return true;
    } else if (e instanceof Period) {
      Period p = (Period) e;
      x.addText(name+": ");
      x.addText(!p.hasStart() ? "?ngen-2?" : p.getStartElement().toHumanDisplay());
      x.tx(" --> ");
      x.addText(!p.hasEnd() ? "(ongoing)" : p.getEndElement().toHumanDisplay());
      return true;
    } else if (e instanceof Reference) {
      Reference r = (Reference) e;
      if (r.hasDisplayElement())
        x.addText(r.getDisplay());
      else if (r.hasReferenceElement()) {
        ResourceWithReference tr = resolveReference(res, r.getReference(), rc);
        x.addText(tr == null ? r.getReference() : "?ngen-3"); // getDisplayForReference(tr.getReference()));
      } else
        x.tx("?ngen-4?");
      return true;
    } else if (e instanceof Narrative) {
      return false;
    } else if (e instanceof Resource) {
      return false;
    } else if (e instanceof ContactDetail) {
      ContactDetail cd = (ContactDetail) e;
      if (cd.hasName()) {
        x.tx(cd.getName()+": ");
      }
      boolean first = true;
      for (ContactPoint c : cd.getTelecom()) {
        if (first) first = false; else x.tx(",");
        renderContactPoint(c, x);
      }
      return true;
    } else if (e instanceof Range) {
      return false;
    } else if (e instanceof Meta) {
      return false;
    } else if (e instanceof Dosage) {
      return false;
    } else if (e instanceof Signature) {
      return false;
    } else if (e instanceof UsageContext) {
      return false;
    } else if (e instanceof RelatedArtifact) {
      return false;
    } else if (e instanceof ElementDefinition) {
      return false;
    } else if (e instanceof Base64BinaryType) {
      return false;
    } else if (!(e instanceof Attachment))
      throw new NotImplementedException("type "+e.getClass().getName()+" not handled yet");
    return false;
  }


  private Map<String, String> readDisplayHints(ElementDefinition defn) throws DefinitionException {
    Map<String, String> hints = new HashMap<String, String>();
    if (defn != null) {
      String displayHint = ToolingExtensions.getDisplayHint(defn);
      if (!Utilities.noString(displayHint)) {
        String[] list = displayHint.split(";");
        for (String item : list) {
          String[] parts = item.split(":");
          if (parts.length != 2)
            throw new DefinitionException("error reading display hint: '"+displayHint+"'");
          hints.put(parts[0].trim(), parts[1].trim());
        }
      }
    }
    return hints;
  }

  public static String displayPeriod(Period p) {
    String s = !p.hasStart() ? "?ngen-5?" : p.getStartElement().toHumanDisplay();
    s = s + " --> ";
    return s + (!p.hasEnd() ? "(ongoing)" : p.getEndElement().toHumanDisplay());
  }

  private void generateResourceSummary(XhtmlNode x, ResourceWrapper res, boolean textAlready, boolean showCodeDetails, ResourceContext rc) throws FHIRException, UnsupportedEncodingException, IOException {
    if (!textAlready) {
      XhtmlNode div = res.getNarrative();
      if (div != null) {
        if (div.allChildrenAreText())
          x.getChildNodes().addAll(div.getChildNodes());
        if (div.getChildNodes().size() == 1 && div.getChildNodes().get(0).allChildrenAreText())
          x.getChildNodes().addAll(div.getChildNodes().get(0).getChildNodes());
      }
      x.tx("Generated Summary: ");
    }
    String path = res.getName();
    StructureDefinition profile = context.fetchResource(StructureDefinition.class, path);
    if (profile == null)
      x.tx("unknown resource " +path);
    else {
      boolean firstElement = true;
      boolean last = false;
      for (PropertyWrapper p : res.children()) {
        ElementDefinition child = getElementDefinition(profile.getSnapshot().getElement(), path+"."+p.getName(), p);
        if (p.getValues().size() > 0 && p.getValues().get(0) != null && child != null && isPrimitive(child) && includeInSummary(child)) {
          if (firstElement)
            firstElement = false;
          else if (last)
            x.tx("; ");
          boolean first = true;
          last = false;
          for (BaseWrapper v : p.getValues()) {
            if (first)
              first = false;
            else if (last)
              x.tx(", ");
            last = displayLeaf(res, v, child, x, p.getName(), showCodeDetails, rc) || last;
          }
        }
      }
    }
  }


  private boolean includeInSummary(ElementDefinition child) {
    if (child.getIsModifier())
      return true;
    if (child.getMustSupport())
      return true;
    if (child.getType().size() == 1) {
      String t = child.getType().get(0).getWorkingCode();
      if (t.equals("Address") || t.equals("Contact") || t.equals("Reference") || t.equals("Uri") || t.equals("Url") || t.equals("Canonical"))
        return false;
    }
    return true;
  }

  private ResourceWithReference resolveReference(ResourceWrapper res, String url, ResourceContext rc) {
    if (url == null)
      return null;
    if (url.startsWith("#")) {
      for (ResourceWrapper r : res.getContained()) {
        if (r.getId().equals(url.substring(1)))
          return new ResourceWithReference(null, r);
      }
      return null;
    }

    if (rc!=null) {
      BundleEntryComponent bundleResource = rc.resolve(url);
      if (bundleResource != null) {
        String bundleUrl = "#" + bundleResource.getResource().getResourceType().name().toLowerCase() + "_" + bundleResource.getResource().getId(); 
        return new ResourceWithReference(bundleUrl, new ResourceWrapperDirect(bundleResource.getResource()));
      }
      org.hl7.fhir.r5.elementmodel.Element bundleElement = rc.resolveElement(url);
      if (bundleElement != null) {
        String bundleUrl = null;
        if (bundleElement.getNamedChild("resource").getChildValue("id") != null) {
          bundleUrl = "#" + bundleElement.fhirType().toLowerCase() + "_" + bundleElement.getNamedChild("resource").getChildValue("id");
        } else {
          bundleUrl = "#" +fullUrlToAnchor(bundleElement.getChildValue("fullUrl"));          
        }
        return new ResourceWithReference(bundleUrl, new ResourceWrapperMetaElement(bundleElement));
      }
    }

    Resource ae = context.fetchResource(null, url);
    if (ae != null)
      return new ResourceWithReference(url, new ResourceWrapperDirect(ae));
    else if (resolver != null) {
      return resolver.resolve(url);
    } else
      return null;
  }

  private String fullUrlToAnchor(String url) {
    return url.replace(":", "").replace("/", "_");
  }

  private void renderCodeableConcept(CodeableConcept cc, XhtmlNode x, boolean showCodeDetails) {
    if (cc.isEmpty()) {
      return;
    }

    String s = cc.getText();
    if (Utilities.noString(s)) {
      for (Coding c : cc.getCoding()) {
        if (c.hasDisplayElement()) {
          s = c.getDisplay();
          break;
        }
      }
    }
    if (Utilities.noString(s)) {
      // still? ok, let's try looking it up
      for (Coding c : cc.getCoding()) {
        if (c.hasCodeElement() && c.hasSystemElement()) {
          s = lookupCode(c.getSystem(), c.getCode());
          if (!Utilities.noString(s))
            break;
        }
      }
    }

    if (Utilities.noString(s)) {
      if (cc.getCoding().isEmpty())
        s = "";
      else
        s = cc.getCoding().get(0).getCode();
    }

    if (showCodeDetails) {
      x.addText(s+" ");
      XhtmlNode sp = x.span("background: LightGoldenRodYellow", null);
      sp.tx("(Details ");
      boolean first = true;
      for (Coding c : cc.getCoding()) {
        if (first) {
          sp.tx(": ");
          first = false;
        } else
          sp.tx("; ");
        sp.tx("{"+TerminologyRenderer.describeSystem(c.getSystem())+" code '"+c.getCode()+"' = '"+lookupCode(c.getSystem(), c.getCode())+(c.hasDisplay() ? "', given as '"+c.getDisplay()+"'}" : ""));
      }
      sp.tx(")");
    } else {

      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (Coding c : cc.getCoding()) {
        if (c.hasCodeElement() && c.hasSystemElement()) {
          b.append("{"+c.getSystem()+" "+c.getCode()+"}");
        }
      }

      x.span(null, "Codes: "+b.toString()).addText(s);
    }
  }

  private void renderAnnotation(Annotation a, XhtmlNode x, boolean showCodeDetails) throws FHIRException {
    StringBuilder s = new StringBuilder();
    if (a.hasAuthor()) {
      s.append("Author: ");

      if (a.hasAuthorReference())
        s.append(a.getAuthorReference().getReference());
      else if (a.hasAuthorStringType())
        s.append(a.getAuthorStringType().getValue());
    }


    if (a.hasTimeElement()) {
      if (s.length() > 0)
        s.append("; ");

      s.append("Made: ").append(a.getTimeElement().toHumanDisplay());
    }

    if (a.hasText()) {
      if (s.length() > 0)
        s.append("; ");

      s.append("Annotation: ").append(a.getText());
    }

    x.addText(s.toString());
  }

  public String describeCoding(List<Coding> list, boolean showCodeDetails) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (Coding c : list) {
      b.append(describeCoding(c, showCodeDetails));
    }
    return b.toString();
  }

  public String describeCoding(Coding c, boolean showCodeDetails) {
    String s = "";
    if (c.hasDisplayElement())
      s = c.getDisplay();
    if (Utilities.noString(s))
      s = lookupCode(c.getSystem(), c.getCode());

    if (Utilities.noString(s))
      s = c.getCode();

    if (showCodeDetails) {
      return s+" (Details: "+TerminologyRenderer.describeSystem(c.getSystem())+" code "+c.getCode()+" = '"+lookupCode(c.getSystem(), c.getCode())+"', stated as '"+c.getDisplay()+"')";
    } else
      return "<span title=\"{"+c.getSystem()+" "+c.getCode()+"}\">"+Utilities.escapeXml(s)+"</span>";
  }

  private void renderCoding(Coding c, XhtmlNode x, boolean showCodeDetails) {
    String s = "";
    if (c.hasDisplayElement())
      s = c.getDisplay();
    if (Utilities.noString(s))
      s = lookupCode(c.getSystem(), c.getCode());

    if (Utilities.noString(s))
      s = c.getCode();

    if (showCodeDetails) {
      x.addText(s+" (Details: "+TerminologyRenderer.describeSystem(c.getSystem())+" code "+c.getCode()+" = '"+lookupCode(c.getSystem(), c.getCode())+"', stated as '"+c.getDisplay()+"')");
    } else
      x.span(null, "{"+c.getSystem()+" "+c.getCode()+"}").addText(s);
  }

  private String lookupCode(String system, String code) {
    ValidationResult t = context.validateCode(terminologyServiceOptions , system, code, null);

    if (t != null && t.getDisplay() != null)
      return t.getDisplay();
    else
      return code;

  }

  private ConceptDefinitionComponent findCode(String code, List<ConceptDefinitionComponent> list) {
    for (ConceptDefinitionComponent t : list) {
      if (code.equals(t.getCode()))
        return t;
      ConceptDefinitionComponent c = findCode(code, t.getConcept());
      if (c != null)
        return c;
    }
    return null;
  }

  public String displayCodeableConcept(CodeableConcept cc) {
    String s = cc.getText();
    if (Utilities.noString(s)) {
      for (Coding c : cc.getCoding()) {
        if (c.hasDisplayElement()) {
          s = c.getDisplay();
          break;
        }
      }
    }
    if (Utilities.noString(s)) {
      // still? ok, let's try looking it up
      for (Coding c : cc.getCoding()) {
        if (c.hasCode() && c.hasSystem()) {
          s = lookupCode(c.getSystem(), c.getCode());
          if (!Utilities.noString(s))
            break;
        }
      }
    }

    if (Utilities.noString(s)) {
      if (cc.getCoding().isEmpty())
        s = "";
      else
        s = cc.getCoding().get(0).getCode();
    }
    return s;
  }

  private void renderIdentifier(Identifier ii, XhtmlNode x) {
    x.addText(displayIdentifier(ii));
  }

  private void renderTiming(Timing s, XhtmlNode x) throws FHIRException {
    x.addText(displayTiming(s));
  }

  private void renderQuantity(Quantity q, XhtmlNode x, boolean showCodeDetails) {
    if (q.hasComparator())
      x.addText(q.getComparator().toCode());
    x.addText(q.getValue().toString());
    if (q.hasUnit())
      x.tx(" "+q.getUnit());
    else if (q.hasCode())
      x.tx(" "+q.getCode());
    if (showCodeDetails && q.hasCode()) {
      x.span("background: LightGoldenRodYellow", null).tx(" (Details: "+TerminologyRenderer.describeSystem(q.getSystem())+" code "+q.getCode()+" = '"+lookupCode(q.getSystem(), q.getCode())+"')");
    }
  }

  private void renderRange(Range q, XhtmlNode x) {
    if (q.hasLow())
      x.addText(q.getLow().getValue().toString());
    else
      x.tx("?");
    x.tx("-");
    if (q.hasHigh())
      x.addText(q.getHigh().getValue().toString());
    else
      x.tx("?");
    if (q.getLow().hasUnit())
      x.tx(" "+q.getLow().getUnit());
  }

  public String displayRange(Range q) {
    StringBuilder b = new StringBuilder();
    if (q.hasLow())
      b.append(q.getLow().getValue().toString());
    else
      b.append("?");
    b.append("-");
    if (q.hasHigh())
      b.append(q.getHigh().getValue().toString());
    else
      b.append("?");
    if (q.getLow().hasUnit())
      b.append(" "+q.getLow().getUnit());
    return b.toString();
  }

  private void renderHumanName(HumanName name, XhtmlNode x) {
    x.addText(displayHumanName(name));
  }

  private void renderAnnotation(Annotation annot, XhtmlNode x) {
    x.addText(annot.getText());
  }

  private void renderAddress(Address address, XhtmlNode x) {
    x.addText(displayAddress(address));
  }

  private void renderContactPoint(ContactPoint contact, XhtmlNode x) {
    x.addText(displayContactPoint(contact));
  }

  private void renderUri(XhtmlNode x, UriType uri) {
    if (uri.getValue().startsWith("mailto:"))
      x.ah(uri.getValue()).addText(uri.getValue().substring(7));
    else
      x.ah(uri.getValue()).addText(uri.getValue());
  }
  
  private void renderUri(UriType uri, XhtmlNode x, String path, String id) {
    String url = uri.getValue();
    if (isCanonical(path)) {
      CanonicalResource mr = context.fetchResource(null, url);
      if (mr != null) {
        if (path.startsWith(mr.fhirType()+".") && mr.getId().equals(id)) {
          url = null; // don't link to self whatever
        } else if (mr.hasUserData("path"))
          url = mr.getUserString("path");
      } else if (!canonicalUrlsAsLinks)
        url = null;
    }
    if (url == null)
      x.b().tx(uri.getValue());
    else if (uri.getValue().startsWith("mailto:"))
      x.ah(uri.getValue()).addText(uri.getValue().substring(7));
    else
      x.ah(uri.getValue()).addText(uri.getValue());
  }

  private boolean isCanonical(String path) {
    if (!path.endsWith(".url")) 
      return false;
    StructureDefinition sd = context.fetchTypeDefinition(path.substring(0, path.length()-4));
    if (sd == null)
      return false;
    if (Utilities.existsInList(path.substring(0, path.length()-4), "CapabilityStatement", "StructureDefinition", "ImplementationGuide", "SearchParameter", "MessageDefinition", "OperationDefinition", "CompartmentDefinition", "StructureMap", "GraphDefinition", 
        "ExampleScenario", "CodeSystem", "ValueSet", "ConceptMap", "NamingSystem", "TerminologyCapabilities"))
      return true;
    return sd.getBaseDefinitionElement().hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-codegen-super");
  }

  private void renderSampledData(SampledData sampledData, XhtmlNode x) {
    x.addText(displaySampledData(sampledData));
  }

  private String displaySampledData(SampledData s) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (s.hasOrigin())
      b.append("Origin: "+displayQuantity(s.getOrigin()));

    if (s.hasPeriod())
      b.append("Period: "+s.getPeriod().toString());

    if (s.hasFactor())
      b.append("Factor: "+s.getFactor().toString());

    if (s.hasLowerLimit())
      b.append("Lower: "+s.getLowerLimit().toString());

    if (s.hasUpperLimit())
      b.append("Upper: "+s.getUpperLimit().toString());

    if (s.hasDimensions())
      b.append("Dimensions: "+s.getDimensions());

    if (s.hasData())
      b.append("Data: "+s.getData());

    return b.toString();
  }

  private String displayQuantity(Quantity q) {
    StringBuilder s = new StringBuilder();

    s.append("(system = '").append(TerminologyRenderer.describeSystem(q.getSystem()))
    .append("' code ").append(q.getCode())
    .append(" = '").append(lookupCode(q.getSystem(), q.getCode())).append("')");

    return s.toString();
  }

  private String displayTiming(Timing s) throws FHIRException {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (s.hasCode())
      b.append("Code: "+displayCodeableConcept(s.getCode()));

    if (s.getEvent().size() > 0) {
      CommaSeparatedStringBuilder c = new CommaSeparatedStringBuilder();
      for (DateTimeType p : s.getEvent()) {
        c.append(p.toHumanDisplay());
      }
      b.append("Events: "+ c.toString());
    }

    if (s.hasRepeat()) {
      TimingRepeatComponent rep = s.getRepeat();
      if (rep.hasBoundsPeriod() && rep.getBoundsPeriod().hasStart())
        b.append("Starting "+rep.getBoundsPeriod().getStartElement().toHumanDisplay());
      if (rep.hasCount())
        b.append("Count "+Integer.toString(rep.getCount())+" times");
      if (rep.hasDuration())
        b.append("Duration "+rep.getDuration().toPlainString()+displayTimeUnits(rep.getPeriodUnit()));

      if (rep.hasWhen()) {
        String st = "";
        if (rep.hasOffset()) {
          st = Integer.toString(rep.getOffset())+"min ";
        }
        b.append("Do "+st);
        for (Enumeration<EventTiming> wh : rep.getWhen())
          b.append(displayEventCode(wh.getValue()));
      } else {
        String st = "";
        if (!rep.hasFrequency() || (!rep.hasFrequencyMax() && rep.getFrequency() == 1) )
          st = "Once";
        else {
          st = Integer.toString(rep.getFrequency());
          if (rep.hasFrequencyMax())
            st = st + "-"+Integer.toString(rep.getFrequency());
        }
        if (rep.hasPeriod()) {
          st = st + " per "+rep.getPeriod().toPlainString();
          if (rep.hasPeriodMax())
            st = st + "-"+rep.getPeriodMax().toPlainString();
          st = st + " "+displayTimeUnits(rep.getPeriodUnit());
        }
        b.append("Do "+st);
      }
      if (rep.hasBoundsPeriod() && rep.getBoundsPeriod().hasEnd())
        b.append("Until "+rep.getBoundsPeriod().getEndElement().toHumanDisplay());
    }
    return b.toString();
  }

  private String displayEventCode(EventTiming when) {
    switch (when) {
    case C: return "at meals";
    case CD: return "at lunch";
    case CM: return "at breakfast";
    case CV: return "at dinner";
    case AC: return "before meals";
    case ACD: return "before lunch";
    case ACM: return "before breakfast";
    case ACV: return "before dinner";
    case HS: return "before sleeping";
    case PC: return "after meals";
    case PCD: return "after lunch";
    case PCM: return "after breakfast";
    case PCV: return "after dinner";
    case WAKE: return "after waking";
    default: return "?ngen-6?";
    }
  }

  private String displayTimeUnits(UnitsOfTime units) {
    if (units == null)
      return "?ngen-7?";
    switch (units) {
    case A: return "years";
    case D: return "days";
    case H: return "hours";
    case MIN: return "minutes";
    case MO: return "months";
    case S: return "seconds";
    case WK: return "weeks";
    default: return "?ngen-8?";
    }
  }

  public static String displayHumanName(HumanName name) {
    StringBuilder s = new StringBuilder();
    if (name.hasText())
      s.append(name.getText());
    else {
      for (StringType p : name.getGiven()) {
        s.append(p.getValue());
        s.append(" ");
      }
      if (name.hasFamily()) {
        s.append(name.getFamily());
        s.append(" ");
      }
    }
    if (name.hasUse() && name.getUse() != NameUse.USUAL)
      s.append("("+name.getUse().toString()+")");
    return s.toString();
  }

  private String displayAddress(Address address) {
    StringBuilder s = new StringBuilder();
    if (address.hasText())
      s.append(address.getText());
    else {
      for (StringType p : address.getLine()) {
        s.append(p.getValue());
        s.append(" ");
      }
      if (address.hasCity()) {
        s.append(address.getCity());
        s.append(" ");
      }
      if (address.hasState()) {
        s.append(address.getState());
        s.append(" ");
      }

      if (address.hasPostalCode()) {
        s.append(address.getPostalCode());
        s.append(" ");
      }

      if (address.hasCountry()) {
        s.append(address.getCountry());
        s.append(" ");
      }
    }
    if (address.hasUse())
      s.append("("+address.getUse().toString()+")");
    return s.toString();
  }

  public static String displayContactPoint(ContactPoint contact) {
    StringBuilder s = new StringBuilder();
    s.append(describeSystem(contact.getSystem()));
    if (Utilities.noString(contact.getValue()))
      s.append("-unknown-");
    else
      s.append(contact.getValue());
    if (contact.hasUse())
      s.append("("+contact.getUse().toString()+")");
    return s.toString();
  }

  private static String describeSystem(ContactPointSystem system) {
    if (system == null)
      return "";
    switch (system) {
    case PHONE: return "ph: ";
    case FAX: return "fax: ";
    default:
      return "";
    }
  }

  private String displayIdentifier(Identifier ii) {
    String s = Utilities.noString(ii.getValue()) ? "?ngen-9?" : ii.getValue();

    if (ii.hasType()) {
      if (ii.getType().hasText())
        s = ii.getType().getText()+" = "+s;
      else if (ii.getType().hasCoding() && ii.getType().getCoding().get(0).hasDisplay())
        s = ii.getType().getCoding().get(0).getDisplay()+" = "+s;
      else if (ii.getType().hasCoding() && ii.getType().getCoding().get(0).hasCode())
        s = lookupCode(ii.getType().getCoding().get(0).getSystem(), ii.getType().getCoding().get(0).getCode())+" = "+s;
    }

    if (ii.hasUse())
      s = s + " ("+ii.getUse().toString()+")";
    return s;
  }

  private List<ElementDefinition> getChildrenForPath(List<ElementDefinition> elements, String path) throws DefinitionException {
    // do we need to do a name reference substitution?
    for (ElementDefinition e : elements) {
      if (e.getPath().equals(path) && e.hasContentReference()) {
        String ref = e.getContentReference();
        ElementDefinition t = null;
        // now, resolve the name
        for (ElementDefinition e1 : elements) {
          if (ref.equals("#"+e1.getId()))
            t = e1;
        }
        if (t == null)
          throw new DefinitionException("Unable to resolve content reference "+ref+" trying to resolve "+path);
        path = t.getPath();
        break;
      }
    }

    List<ElementDefinition> results = new ArrayList<ElementDefinition>();
    for (ElementDefinition e : elements) {
      if (e.getPath().startsWith(path+".") && !e.getPath().substring(path.length()+1).contains("."))
        results.add(e);
    }
    return results;
  }


  public boolean generate(ResourceContext rcontext, ConceptMap cm) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    ConceptMapRenderer renderer = new ConceptMapRenderer(TerminologyRendererMode.RESOURCE, context, markdown, prefix, null);
    boolean res = renderer.generate(rcontext, cm, x);
    inject(cm, x, NarrativeStatus.GENERATED);
    return res;
  }


  private void inject(DomainResource r, XhtmlNode x, NarrativeStatus status) {
    if (!x.hasAttribute("xmlns"))
      x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
    if (r.hasLanguage()) {
      // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
      x.setAttribute("lang", r.getLanguage());
      x.setAttribute("xml:lang", r.getLanguage());
    }
    if (!r.hasText() || !r.getText().hasDiv() || r.getText().getDiv().getChildNodes().isEmpty()) {
      r.setText(new Narrative());
      r.getText().setDiv(x);
      r.getText().setStatus(status);
    } else {
      XhtmlNode n = r.getText().getDiv();
      n.hr();
      n.getChildNodes().addAll(x.getChildNodes());
    }
  }

  public Element getNarrative(Element er) {
    Element txt = XMLUtil.getNamedChild(er, "text");
    if (txt == null)
      return null;
    return XMLUtil.getNamedChild(txt, "div");
  }

  public void inject(Element er, XhtmlNode x, NarrativeStatus status) {
    if (!x.hasAttribute("xmlns"))
      x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
    Element le = XMLUtil.getNamedChild(er, "language");
    String l = le == null ? null : le.getAttribute("value");
    if (!Utilities.noString(l)) {
      // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
      x.setAttribute("lang", l);
      x.setAttribute("xml:lang", l);
    }
    Element txt = XMLUtil.getNamedChild(er, "text");
    if (txt == null) {
      txt = er.getOwnerDocument().createElementNS(FormatUtilities.FHIR_NS, "text");
      Element n = XMLUtil.getFirstChild(er);
      while (n != null && (n.getNodeName().equals("id") || n.getNodeName().equals("meta") || n.getNodeName().equals("implicitRules") || n.getNodeName().equals("language")))
        n = XMLUtil.getNextSibling(n);
      if (n == null)
        er.appendChild(txt);
      else
        er.insertBefore(txt, n);
    }
    Element st = XMLUtil.getNamedChild(txt, "status");
    if (st == null) {
      st = er.getOwnerDocument().createElementNS(FormatUtilities.FHIR_NS, "status");
      Element n = XMLUtil.getFirstChild(txt);
      if (n == null)
        txt.appendChild(st);
      else
        txt.insertBefore(st, n);
    }
    st.setAttribute("value", status.toCode());
    Element div = XMLUtil.getNamedChild(txt, "div");
    if (div == null) {
      div = er.getOwnerDocument().createElementNS(FormatUtilities.XHTML_NS, "div");
      div.setAttribute("xmlns", FormatUtilities.XHTML_NS);
      txt.appendChild(div);
    }
    if (div.hasChildNodes())
      div.appendChild(er.getOwnerDocument().createElementNS(FormatUtilities.XHTML_NS, "hr"));
    new XhtmlComposer(XhtmlComposer.XML, pretty).compose(div, x);
  }

  public void inject(org.hl7.fhir.r5.elementmodel.Element er, XhtmlNode x, NarrativeStatus status) throws IOException, FHIRException {
    if (!x.hasAttribute("xmlns"))
      x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
    String l = er.getChildValue("language");
    if (!Utilities.noString(l)) {
      // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
      x.setAttribute("lang", l);
      x.setAttribute("xml:lang", l);
    }
    org.hl7.fhir.r5.elementmodel.Element txt = er.getNamedChild("text");
    if (txt == null) {
      txt = new org.hl7.fhir.r5.elementmodel.Element("text", er.getProperty().getChild(null, "text"));
      int i = 0;
      while (i < er.getChildren().size() && (er.getChildren().get(i).getName().equals("id") || er.getChildren().get(i).getName().equals("meta") || er.getChildren().get(i).getName().equals("implicitRules") || er.getChildren().get(i).getName().equals("language")))
        i++;
      if (i >= er.getChildren().size())
        er.getChildren().add(txt);
      else
        er.getChildren().add(i, txt);
    }
    org.hl7.fhir.r5.elementmodel.Element st = txt.getNamedChild("status");
    if (st == null) {
      st = new org.hl7.fhir.r5.elementmodel.Element("status", txt.getProperty().getChild(null, "status"));
      txt.getChildren().add(0, st);
    }
    st.setValue(status.toCode());
    org.hl7.fhir.r5.elementmodel.Element div = txt.getNamedChild("div");
    if (div == null) {
      div = new org.hl7.fhir.r5.elementmodel.Element("div", txt.getProperty().getChild(null, "div"));
      txt.getChildren().add(div);
      div.setValue(new XhtmlComposer(XhtmlComposer.XML, pretty).compose(x));
    }
    div.setValue(x.toString());
    div.setXhtml(x);
  }

  /**
   * This generate is optimised for the FHIR build process itself in as much as it
   * generates hyperlinks in the narrative that are only going to be correct for
   * the purposes of the build. This is to be reviewed in the future.
   *
   * @param vs
   * @param codeSystems
   * @throws IOException
   * @throws DefinitionException
   * @throws FHIRFormatError
   * @throws Exception
   */
  public boolean generate(ResourceContext rcontext, CodeSystem cs, boolean header, String lang) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    CodeSystemRenderer renderer = new CodeSystemRenderer(TerminologyRendererMode.RESOURCE, context, markdown, prefix, lang);
    renderer.getCodeSystemPropList().addAll(getCodeSystemPropList());
    renderer.setHeaderLevelContext(headerLevelContext);
    renderer.setTerminologyServiceOptions(terminologyServiceOptions);
    boolean hasExtensions = renderer.generate(x, cs, header);
    inject(cs, x, hasExtensions ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
    return true;
  }

  /**
   * This generate is optimised for the FHIR build process itself in as much as it
   * generates hyperlinks in the narrative that are only going to be correct for
   * the purposes of the build. This is to be reviewed in the future.
   *
   * @param vs
   * @param codeSystems
   * @throws FHIRException
   * @throws IOException
   * @throws Exception
   */
  public boolean generate(ResourceContext rcontext, ValueSet vs, boolean header) throws FHIRException, IOException {
    generate(rcontext, vs, null, header);
    return true;
  }

  public void generate(ResourceContext rcontext, ValueSet vs, ValueSet src, boolean header) throws FHIRException, IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    ValueSetRenderer renderer = new ValueSetRenderer(TerminologyRendererMode.RESOURCE, context, markdown, prefix, null);
    renderer.setTooCostlyNoteEmpty(tooCostlyNoteEmpty);
    renderer.setTooCostlyNoteNotEmpty(tooCostlyNoteNotEmpty);
    renderer.setTooCostlyNoteEmptyDependent(tooCostlyNoteEmptyDependent);
    renderer.setTooCostlyNoteNotEmptyDependent(tooCostlyNoteNotEmptyDependent);
    renderer.setNoSlowLookup(noSlowLookup);
    renderer.setHeaderLevelContext(headerLevelContext);
    renderer.setTerminologyServiceOptions(terminologyServiceOptions);

    boolean hasExtensions = renderer.render(rcontext, x, vs, src, header);
    inject(vs, x, hasExtensions ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
  }





  //  private void scanLangs(ConceptDefinitionComponent c, List<String> langs) {
  //    for (ConceptDefinitionDesignationComponent designation : c.getDesignation()) {
  //      if (designation.hasLanguage()) {
  //        String lang = designation.getLanguage();
  //        if (langs != null && !langs.contains(lang) && c.hasDisplay() && !c.getDisplay().equalsIgnoreCase(designation.getValue()))
  //          langs.add(lang);
  //      }
  //    }
  //    for (ConceptDefinitionComponent g : c.getConcept())
  //      scanLangs(g, langs);
  //  }





  /**
   * This generate is optimised for the build tool in that it tracks the source extension.
   * But it can be used for any other use.
   *
   * @param vs
   * @param codeSystems
   * @throws DefinitionException
   * @throws Exception
   */
  public boolean generate(ResourceContext rcontext, OperationOutcome op) throws DefinitionException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean hasSource = false;
    boolean success = true;
    for (OperationOutcomeIssueComponent i : op.getIssue()) {
      success = success && i.getSeverity() == IssueSeverity.INFORMATION;
      hasSource = hasSource || ExtensionHelper.hasExtension(i, ToolingExtensions.EXT_ISSUE_SOURCE);
    }
    if (success)
      x.para().tx("All OK");
    if (op.getIssue().size() > 0) {
      XhtmlNode tbl = x.table("grid"); // on the basis that we'll most likely be rendered using the standard fhir css, but it doesn't really matter
      XhtmlNode tr = tbl.tr();
      tr.td().b().tx("Severity");
      tr.td().b().tx("Location");
      tr.td().b().tx("Code");
      tr.td().b().tx("Details");
      tr.td().b().tx("Diagnostics");
      if (hasSource)
        tr.td().b().tx("Source");
      for (OperationOutcomeIssueComponent i : op.getIssue()) {
        tr = tbl.tr();
        tr.td().addText(i.getSeverity().toString());
        XhtmlNode td = tr.td();
        boolean d = false;
        for (StringType s : i.getLocation()) {
          if (d)
            td.tx(", ");
          else
            d = true;
          td.addText(s.getValue());
        }
        tr.td().addText(i.getCode().getDisplay());
        tr.td().addText(gen(i.getDetails()));
        smartAddText(tr.td(), i.getDiagnostics());
        if (hasSource) {
          Extension ext = ExtensionHelper.getExtension(i, ToolingExtensions.EXT_ISSUE_SOURCE);
          tr.td().addText(ext == null ? "" : gen(ext));
        }
      }
    }
    inject(op, x, hasSource ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
    return true;
  }


  public String genType(DataType type) throws DefinitionException {
    if (type instanceof Coding)
      return gen((Coding) type);
    if (type instanceof CodeableConcept)
      return displayCodeableConcept((CodeableConcept) type);
    if (type instanceof Quantity)
      return displayQuantity((Quantity) type);
    if (type instanceof Range)
      return displayRange((Range) type);
    return null;
  }

  private String gen(Extension extension) throws DefinitionException {
    if (extension.getValue() instanceof CodeType)
      return ((CodeType) extension.getValue()).getValue();
    if (extension.getValue() instanceof Coding)
      return gen((Coding) extension.getValue());

    throw new DefinitionException("Unhandled type "+extension.getValue().getClass().getName());
  }

  public String gen(Reference ref) {	  
    if (ref == null)
      return null;
    if (ref.hasDisplay()) {
      return ref.getDisplay();
    }
    if (ref.hasReference()) {
      return ref.getReference();
    }
    if (ref.hasIdentifier()) {
      return displayIdentifier(ref.getIdentifier());
    }
    return "?ngen-15?";
  }

  public String gen(CodeableConcept code) {
    if (code == null)
      return null;
    if (code.hasText())
      return code.getText();
    if (code.hasCoding())
      return gen(code.getCoding().get(0));
    return null;
  }

  public String gen(Coding code) {
    if (code == null)
      return null;
    if (code.hasDisplayElement())
      return code.getDisplay();
    if (code.hasCodeElement())
      return code.getCode();
    return null;
  }

  public boolean generate(ResourceContext rcontext, StructureDefinition sd, Set<String> outputTracker) throws EOperationOutcome, FHIRException, IOException {
    ProfileUtilities pu = new ProfileUtilities(context, null, pkp);
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.getChildNodes().add(pu.generateTable(definitionsTarget, sd, true, destDir, false, sd.getId(), false, corePath, "", false, false, outputTracker, false));
    inject(sd, x, NarrativeStatus.GENERATED);
    return true;
  }

  public boolean generate(ResourceContext rcontext, ListResource list) throws EOperationOutcome, FHIRException, IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    if (list.hasTitle()) {
      x.h2().tx(list.getTitle());
    }
    XhtmlNode t = x.table("clstu");
    XhtmlNode tr = t.tr();
    if (list.hasDate()) {
      tr.td().tx("Date: "+list.getDate().toLocaleString());
    }
    if (list.hasMode()) {
      tr.td().tx("Mode: "+list.getMode().getDisplay());
    }
    if (list.hasStatus()) {
      tr.td().tx("Status: "+list.getStatus().getDisplay());
    }
    if (list.hasCode()) {
      tr.td().tx("Code: "+gen(list.getCode()));
    }    
    tr = t.tr();
    if (list.hasSubject()) {
      shortForRef(tr.td().tx("Subject: "), list.getSubject());
    }
    if (list.hasEncounter()) {
      shortForRef(tr.td().tx("Encounter: "), list.getEncounter());
    }
    if (list.hasSource()) {
      shortForRef(tr.td().tx("Source: "), list.getEncounter());
    }
    if (list.hasOrderedBy()) {
      tr.td().tx("Order: "+gen(list.getOrderedBy()));
    }
    for (Annotation a : list.getNote()) {
      renderAnnotation(a, x);
    }
    boolean flag = false;
    boolean deleted = false;
    boolean date = false;
    for (ListResourceEntryComponent e : list.getEntry()) {
      flag = flag || e.hasFlag();
      deleted = deleted || e.hasDeleted();
      date = date || e.hasDate();
    }
    t = x.table("grid");
    tr = t.tr().style("backgound-color: #eeeeee");
    tr.td().b().tx("Items");
    if (date) {
      tr.td().tx("Date");      
    }
    if (flag) {
      tr.td().tx("Flag");      
    }
    if (deleted) {
      tr.td().tx("Deleted");      
    }
    for (ListResourceEntryComponent e : list.getEntry()) {
      tr = t.tr();
      shortForRef(tr.td(), e.getItem());
      if (date) {
        tr.td().tx(e.hasDate() ? e.getDate().toLocaleString() : "");      
      }
      if (flag) {
        tr.td().tx(e.hasFlag() ? gen(e.getFlag()) : "");      
      }
      if (deleted) {
        tr.td().tx(e.hasDeleted() ? Boolean.toString(e.getDeleted()) : "");
      }
    }    
    inject(list, x, NarrativeStatus.GENERATED);
    return false;
  }

  public boolean generateList(XhtmlNode x, ResourceWrapper list) throws EOperationOutcome, FHIRException, IOException {
    if (list.has("title")) {
      x.h2().tx(list.get("title").primitiveValue());
    }
    XhtmlNode t = x.table("clstu");
    XhtmlNode tr = t.tr();
    XhtmlNode td = tr.td();
    if (list.has("date")) {
      td.tx("Date: "+list.get("date").dateTimeValue().toHumanDisplay());
    }
    if (list.has("mode")) {
      td.tx("Mode: "+list.get("mode").primitiveValue());
    }
    if (list.has("status")) {
      td.tx("Status: "+list.get("status").primitiveValue());
    }
    if (list.has("code")) {
      td.tx("Code: "+genCC(list.get("code")));
    }    
    tr = t.tr();
    if (list.has("subject")) {
      td.tx("Subject: ");
      shortForRef(td, list.get("subject"));
    }
    if (list.has("encounter")) {
      shortForRef(td.tx("Encounter: "), list.get("encounter"));
    }
    if (list.has("source")) {
      td.tx("Source: ");
      shortForRef(td, list.get("encounter"));
    }
    if (list.has("orderedBy")) {
      td.tx("Order: "+genCC(list.get("orderedBy")));
    }
    //    for (Annotation a : list.getNote()) {
    //      renderAnnotation(a, x);
    //    }
    boolean flag = false;
    boolean deleted = false;
    boolean date = false;
    for (BaseWrapper e : list.children("entry")) {
      flag = flag || e.has("flag");
      deleted = deleted || e.has("deleted");
      date = date || e.has("date");
    }
    t = x.table("grid");
    tr = t.tr().style("backgound-color: #eeeeee");
    td.b().tx("Items");
    if (date) {
      td.tx("Date");      
    }
    if (flag) {
      td.tx("Flag");      
    }
    if (deleted) {
      td.tx("Deleted");      
    }
    for (BaseWrapper e : list.children("entry")) {
      tr = t.tr();
      shortForRef(td, e.get("item"));
      if (date) {
        td.tx(e.has("date") ? e.get("date").dateTimeValue().toHumanDisplay() : "");      
      }
      if (flag) {
        td.tx(e.has("flag") ? genCC(e.get("flag")) : "");      
      }
      if (deleted) {
        td.tx(e.has("deleted") ? e.get("deleted").primitiveValue() : "");
      }
    }    
    return false;
  }

  private String genCC(Base base) {
    if (base instanceof org.hl7.fhir.r5.elementmodel.Element) {
      CodeableConcept cc = ObjectConverter.readAsCodeableConcept((org.hl7.fhir.r5.elementmodel.Element) base);
      return gen(cc);
    } else if (base instanceof CodeableConcept) {
      return gen((CodeableConcept) base);
    } else {
      return "todo";
    }
  }

  private void shortForRef(XhtmlNode x, Reference ref) {
    ResourceWithReference r = resolver.resolve(ref.getReference());
    if (r == null) {
      x.tx(gen(ref));
    } else {
      r.resource.display(x.ah(r.reference));
    }
  }

  private XhtmlNode shortForRef(XhtmlNode x, Base ref) {
    if (ref == null) {
      x.tx("(null)");
    } else {
      String disp = ref.getChildByName("display") != null && ref.getChildByName("display").hasValues() ? ref.getChildByName("display").getValues().get(0).primitiveValue() : null;
      if (ref.getChildByName("reference").hasValues()) {
        String url = ref.getChildByName("reference").getValues().get(0).primitiveValue();
        ResourceWithReference r = resolver.resolve(url);
        if (r == null) {
          if (disp == null) {
            disp = url;
          }
          x.tx(disp);
        } else {
          r.resource.display(x.ah(r.reference));
        }
      } else if (disp != null) {
        x.tx(disp);      
      } else {
        x.tx("?ngen-16?");
      }     
    }
    return x;
  }

  public boolean generate(ResourceContext rcontext, ImplementationGuide ig) throws EOperationOutcome, FHIRException, IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.h2().addText(ig.getName());
    x.para().tx("The official URL for this implementation guide is: ");
    x.pre().tx(ig.getUrl());
    addMarkdown(x, ig.getDescription());
    inject(ig, x, NarrativeStatus.GENERATED);
    return true;
  }

  public boolean generate(ResourceContext rcontext, OperationDefinition opd) throws EOperationOutcome, FHIRException, IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.h2().addText(opd.getName());
    x.para().addText(Utilities.capitalize(opd.getKind().toString())+": "+opd.getName());
    x.para().tx("The official URL for this operation definition is: ");
    x.pre().tx(opd.getUrl());
    addMarkdown(x, opd.getDescription());

    if (opd.getSystem())
      x.para().tx("URL: [base]/$"+opd.getCode());
    for (CodeType c : opd.getResource()) {
      if (opd.getType())
        x.para().tx("URL: [base]/"+c.getValue()+"/$"+opd.getCode());
      if (opd.getInstance())
        x.para().tx("URL: [base]/"+c.getValue()+"/[id]/$"+opd.getCode());
    }

    x.para().tx("Parameters");
    XhtmlNode tbl = x.table( "grid");
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx("Use");
    tr.td().b().tx("Name");
    tr.td().b().tx("Cardinality");
    tr.td().b().tx("Type");
    tr.td().b().tx("Binding");
    tr.td().b().tx("Documentation");
    for (OperationDefinitionParameterComponent p : opd.getParameter()) {
      genOpParam(rcontext, tbl, "", p);
    }
    addMarkdown(x, opd.getComment());
    inject(opd, x, NarrativeStatus.GENERATED);
    return true;
  }

  private void genOpParam(ResourceContext rcontext, XhtmlNode tbl, String path, OperationDefinitionParameterComponent p) throws EOperationOutcome, FHIRException, IOException {
    XhtmlNode tr;
    tr = tbl.tr();
    tr.td().addText(p.getUse().toString());
    tr.td().addText(path+p.getName());
    tr.td().addText(Integer.toString(p.getMin())+".."+p.getMax());
    XhtmlNode td = tr.td();
    StructureDefinition sd = p.getType() != null ? context.fetchTypeDefinition(p.getType().toCode()) : null;
    if (sd == null)
      td.tx(p.hasType() ? p.getType().toCode() : "");
    else if (sd.getAbstract() && p.hasExtension(ToolingExtensions.EXT_ALLOWED_TYPE)) {
      boolean first = true;
      for (Extension ex : p.getExtensionsByUrl(ToolingExtensions.EXT_ALLOWED_TYPE)) {
        if (first) first = false; else td.tx(" | ");
        String s = ex.getValue().primitiveValue();
        StructureDefinition sdt = context.fetchTypeDefinition(s);
        if (sdt == null)
          td.tx(p.hasType() ? p.getType().toCode() : "");
        else
          td.ah(sdt.getUserString("path")).tx(s);         
      }
    } else
      td.ah(sd.getUserString("path")).tx(p.hasType() ? p.getType().toCode() : "");
    if (p.hasSearchType()) {
      td.br();
      td.tx("(");
      td.ah( corePath == null ? "search.html#"+p.getSearchType().toCode() : Utilities.pathURL(corePath, "search.html#"+p.getSearchType().toCode())).tx(p.getSearchType().toCode());       
      td.tx(")");
    }
    td = tr.td();
    if (p.hasBinding() && p.getBinding().hasValueSet()) {
      AddVsRef(rcontext, p.getBinding().getValueSet(), td);
      td.tx(" ("+p.getBinding().getStrength().getDisplay()+")");
    }
    addMarkdown(tr.td(), p.getDocumentation());
    if (!p.hasType()) {
      for (OperationDefinitionParameterComponent pp : p.getPart()) {
        genOpParam(rcontext, tbl, path+p.getName()+".", pp);
      }
    }
  }

  protected void AddVsRef(ResourceContext rcontext, String value, XhtmlNode li) {
    Resource res = null;
    if (rcontext != null) {
      BundleEntryComponent be = rcontext.resolve(value);
      if (be != null) {
        res = be.getResource(); 
      }
    }
    if (res != null && !(res instanceof CanonicalResource)) {
      li.addText(value);
      return;      
    }      
    CanonicalResource vs = (CanonicalResource) res;
    if (vs == null)
      vs = context.fetchResource(ValueSet.class, value);
    if (vs == null)
      vs = context.fetchResource(StructureDefinition.class, value);
    //    if (vs == null)
    //      vs = context.fetchResource(DataElement.class, value);
    if (vs == null)
      vs = context.fetchResource(Questionnaire.class, value);
    if (vs != null) {
      String ref = (String) vs.getUserData("path");

      ref = adjustForPath(ref);
      XhtmlNode a = li.ah(ref == null ? "?ngen-11?" : ref.replace("\\", "/"));
      a.addText(value);
    } else {
      CodeSystem cs = context.fetchCodeSystem(value);
      if (cs != null) {
        String ref = (String) cs.getUserData("path");
        ref = adjustForPath(ref);
        XhtmlNode a = li.ah(ref == null ? "?ngen-12?" : ref.replace("\\", "/"));
        a.addText(value);
      } else if (value.equals("http://snomed.info/sct") || value.equals("http://snomed.info/id")) {
        XhtmlNode a = li.ah(value);
        a.tx("SNOMED-CT");
      }
      else {
        if (value.startsWith("http://hl7.org") && !Utilities.existsInList(value, "http://hl7.org/fhir/sid/icd-10-us"))
          System.out.println("Unable to resolve value set "+value);
        li.addText(value);
      }
    }
  }
  private String adjustForPath(String ref) {
    if (prefix == null)
      return ref;
    else
      return prefix+ref;
  }



  private void addMarkdown(XhtmlNode x, String text) throws FHIRFormatError, IOException, DefinitionException {
    if (text != null) {
      // 1. custom FHIR extensions
      while (text.contains("[[[")) {
        String left = text.substring(0, text.indexOf("[[["));
        String link = text.substring(text.indexOf("[[[")+3, text.indexOf("]]]"));
        String right = text.substring(text.indexOf("]]]")+3);
        String url = link;
        String[] parts = link.split("\\#");
        StructureDefinition p = context.fetchResource(StructureDefinition.class, parts[0]);
        if (p == null)
          p = context.fetchTypeDefinition(parts[0]);
        if (p == null)
          p = context.fetchResource(StructureDefinition.class, link);
        if (p != null) {
          url = p.getUserString("path");
          if (url == null)
            url = p.getUserString("filename");
        } else
          throw new DefinitionException("Unable to resolve markdown link "+link);

        text = left+"["+link+"]("+url+")"+right;
      }

      // 2. markdown
      String s = markdown.process(Utilities.escapeXml(text), "narrative generator");
      XhtmlParser p = new XhtmlParser();
      XhtmlNode m;
      try {
        m = p.parse("<div>"+s+"</div>", "div");
      } catch (org.hl7.fhir.exceptions.FHIRFormatError e) {
        throw new FHIRFormatError(e.getMessage(), e);
      }
      x.getChildNodes().addAll(m.getChildNodes());
    }
  }

  public boolean generate(ResourceContext rcontext, CompartmentDefinition cpd) {
    StringBuilder in = new StringBuilder();
    StringBuilder out = new StringBuilder();
    for (CompartmentDefinitionResourceComponent cc: cpd.getResource()) {
      CommaSeparatedStringBuilder rules = new CommaSeparatedStringBuilder();
      if (!cc.hasParam()) {
        out.append(" <li><a href=\"").append(cc.getCode().toLowerCase()).append(".html\">").append(cc.getCode()).append("</a></li>\r\n");
      } else if (!rules.equals("{def}")) {
        for (StringType p : cc.getParam())
          rules.append(p.asStringValue());
        in.append(" <tr><td><a href=\"").append(cc.getCode().toLowerCase()).append(".html\">").append(cc.getCode()).append("</a></td><td>").append(rules.toString()).append("</td></tr>\r\n");
      }
    }
    XhtmlNode x;
    try {
      x = new XhtmlParser().parseFragment("<div><p>\r\nThe following resources may be in this compartment:\r\n</p>\r\n" +
          "<table class=\"grid\">\r\n"+
          " <tr><td><b>Resource</b></td><td><b>Inclusion Criteria</b></td></tr>\r\n"+
          in.toString()+
          "</table>\r\n"+
          "<p>\r\nA resource is in this compartment if the nominated search parameter (or chain) refers to the patient resource that defines the compartment.\r\n</p>\r\n" +
          "<p>\r\n\r\n</p>\r\n" +
          "<p>\r\nThe following resources are never in this compartment:\r\n</p>\r\n" +
          "<ul>\r\n"+
          out.toString()+
          "</ul></div>\r\n");
      inject(cpd, x, NarrativeStatus.GENERATED);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean generate(ResourceContext rcontext, CapabilityStatement conf) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.h2().addText(conf.getName());
    addMarkdown(x, conf.getDescription());
    if (conf.getRest().size() > 0) {
      CapabilityStatementRestComponent rest = conf.getRest().get(0);
      XhtmlNode t = x.table(null);
      addTableRow(t, "Mode", rest.getMode().toString());
      addTableRow(t, "Description", rest.getDocumentation());

      addTableRow(t, "Transaction", showOp(rest, SystemRestfulInteraction.TRANSACTION));
      addTableRow(t, "System History", showOp(rest, SystemRestfulInteraction.HISTORYSYSTEM));
      addTableRow(t, "System Search", showOp(rest, SystemRestfulInteraction.SEARCHSYSTEM));

      boolean hasVRead = false;
      boolean hasPatch = false;
      boolean hasDelete = false;
      boolean hasHistory = false;
      boolean hasUpdates = false;
      for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
        hasVRead = hasVRead || hasOp(r, TypeRestfulInteraction.VREAD);
        hasPatch = hasPatch || hasOp(r, TypeRestfulInteraction.PATCH);
        hasDelete = hasDelete || hasOp(r, TypeRestfulInteraction.DELETE);
        hasHistory = hasHistory || hasOp(r, TypeRestfulInteraction.HISTORYTYPE);
        hasUpdates = hasUpdates || hasOp(r, TypeRestfulInteraction.HISTORYINSTANCE);
      }

      t = x.table(null);
      XhtmlNode tr = t.tr();
      tr.th().b().tx("Resource Type");
      tr.th().b().tx("Profile");
      tr.th().b().attribute("title", "GET a resource (read interaction)").tx("Read");
      if (hasVRead)
        tr.th().b().attribute("title", "GET past versions of resources (vread interaction)").tx("V-Read");
      tr.th().b().attribute("title", "GET all set of resources of the type (search interaction)").tx("Search");
      tr.th().b().attribute("title", "PUT a new resource version (update interaction)").tx("Update");
      if (hasPatch)
        tr.th().b().attribute("title", "PATCH a new resource version (patch interaction)").tx("Patch");
      tr.th().b().attribute("title", "POST a new resource (create interaction)").tx("Create");
      if (hasDelete)
        tr.th().b().attribute("title", "DELETE a resource (delete interaction)").tx("Delete");
      if (hasUpdates)
        tr.th().b().attribute("title", "GET changes to a resource (history interaction on instance)").tx("Updates");
      if (hasHistory)
        tr.th().b().attribute("title", "GET changes for all resources of the type (history interaction on type)").tx("History");

      for (CapabilityStatementRestResourceComponent r : rest.getResource()) {
        tr = t.tr();
        tr.td().addText(r.getType());
        if (r.hasProfile()) {
          tr.td().ah(prefix+r.getProfile()).addText(r.getProfile());
        }
        tr.td().addText(showOp(r, TypeRestfulInteraction.READ));
        if (hasVRead)
          tr.td().addText(showOp(r, TypeRestfulInteraction.VREAD));
        tr.td().addText(showOp(r, TypeRestfulInteraction.SEARCHTYPE));
        tr.td().addText(showOp(r, TypeRestfulInteraction.UPDATE));
        if (hasPatch)
          tr.td().addText(showOp(r, TypeRestfulInteraction.PATCH));
        tr.td().addText(showOp(r, TypeRestfulInteraction.CREATE));
        if (hasDelete)
          tr.td().addText(showOp(r, TypeRestfulInteraction.DELETE));
        if (hasUpdates)
          tr.td().addText(showOp(r, TypeRestfulInteraction.HISTORYINSTANCE));
        if (hasHistory)
          tr.td().addText(showOp(r, TypeRestfulInteraction.HISTORYTYPE));
      }
    }

    inject(conf, x, NarrativeStatus.GENERATED);
    return true;
  }

  private boolean hasOp(CapabilityStatementRestResourceComponent r, TypeRestfulInteraction on) {
    for (ResourceInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return true;
    }
    return false;
  }

  private String showOp(CapabilityStatementRestResourceComponent r, TypeRestfulInteraction on) {
    for (ResourceInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return "y";
    }
    return "";
  }

  private String showOp(CapabilityStatementRestComponent r, SystemRestfulInteraction on) {
    for (SystemInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == on)
        return "y";
    }
    return "";
  }

  private void addTableRow(XhtmlNode t, String name, String value) {
    XhtmlNode tr = t.tr();
    tr.td().addText(name);
    tr.td().addText(value);
  }

  public XhtmlNode generateDocumentNarrative(Bundle feed) {
    /*
     When the document is presented for human consumption, applications must present the collated narrative portions of the following resources in order:
     * The Composition resource
     * The Subject resource
     * Resources referenced in the section.content
     */
    XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
    Composition comp = (Composition) feed.getEntry().get(0).getResource();
    root.getChildNodes().add(comp.getText().getDiv());
    Resource subject = ResourceUtilities.getById(feed, null, comp.getSubject().getReference());
    if (subject != null && subject instanceof DomainResource) {
      root.hr();
      root.getChildNodes().add(((DomainResource)subject).getText().getDiv());
    }
    List<SectionComponent> sections = comp.getSection();
    renderSections(feed, root, sections, 1);
    return root;
  }

  private void renderSections(Bundle feed, XhtmlNode node, List<SectionComponent> sections, int level) {
    for (SectionComponent section : sections) {
      node.hr();
      if (section.hasTitleElement())
        node.addTag("h"+Integer.toString(level)).addText(section.getTitle());
      //      else if (section.hasCode())
      //        node.addTag("h"+Integer.toString(level)).addText(displayCodeableConcept(section.getCode()));

      //      if (section.hasText()) {
      //        node.getChildNodes().add(section.getText().getDiv());
      //      }
      //
      //      if (!section.getSection().isEmpty()) {
      //        renderSections(feed, node.addTag("blockquote"), section.getSection(), level+1);
      //      }
    }
  }


  public class ObservationNode {
    private String ref;
    private ResourceWrapper obs;
    private List<ObservationNode> contained = new ArrayList<NarrativeGenerator.ObservationNode>();
  }

  public XhtmlNode generateDiagnosticReport(ResourceWrapper dr) {
    XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode h2 = root.h2();
    displayCodeableConcept(h2, getProperty(dr, "code").value());
    h2.tx(" ");
    PropertyWrapper pw = getProperty(dr, "category");
    if (valued(pw)) {
      h2.tx("(");
      displayCodeableConcept(h2, pw.value());
      h2.tx(") ");
    }
    displayDate(h2, getProperty(dr, "issued").value());

    XhtmlNode tbl = root.table( "grid");
    XhtmlNode tr = tbl.tr();
    XhtmlNode tdl = tr.td();
    XhtmlNode tdr = tr.td();
    populateSubjectSummary(tdl, getProperty(dr, "subject").value());
    tdr.b().tx("Report Details");
    tdr.br();
    pw = getProperty(dr, "perfomer");
    if (valued(pw)) {
      tdr.addText(pluralise("Performer", pw.getValues().size())+":");
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        displayReference(tdr, v);
      }
      tdr.br();
    }
    pw = getProperty(dr, "identifier");
    if (valued(pw)) {
      tdr.addText(pluralise("Identifier", pw.getValues().size())+":");
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        displayIdentifier(tdr, v);
      }
      tdr.br();
    }
    pw = getProperty(dr, "request");
    if (valued(pw)) {
      tdr.addText(pluralise("Request", pw.getValues().size())+":");
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        displayReferenceId(tdr, v);
      }
      tdr.br();
    }

    pw = getProperty(dr, "result");
    if (valued(pw)) {
      List<ObservationNode> observations = fetchObservations(pw.getValues());
      buildObservationsTable(root, observations);
    }

    pw = getProperty(dr, "conclusion");
    if (valued(pw))
      displayText(root.para(), pw.value());

    pw = getProperty(dr, "result");
    if (valued(pw)) {
      XhtmlNode p = root.para();
      p.b().tx("Coded Diagnoses :");
      for (BaseWrapper v : pw.getValues()) {
        tdr.tx(" ");
        displayCodeableConcept(tdr, v);
      }
    }
    return root;
  }

  private void buildObservationsTable(XhtmlNode root, List<ObservationNode> observations) {
    XhtmlNode tbl = root.table( "none");
    for (ObservationNode o : observations) {
      addObservationToTable(tbl, o, 0);
    }
  }

  private void addObservationToTable(XhtmlNode tbl, ObservationNode o, int i) {
    XhtmlNode tr = tbl.tr();
    if (o.obs == null) {
      XhtmlNode td = tr.td().colspan("6");
      td.i().tx("This Observation could not be resolved");
    } else {
      addObservationToTable(tr, o.obs, i);
      // todo: contained observations
    }
    for (ObservationNode c : o.contained) {
      addObservationToTable(tbl, c, i+1);
    }
  }

  private void addObservationToTable(XhtmlNode tr, ResourceWrapper obs, int i) {
    // TODO Auto-generated method stub

    // code (+bodysite)
    XhtmlNode td = tr.td();
    PropertyWrapper pw = getProperty(obs, "result");
    if (valued(pw)) {
      displayCodeableConcept(td, pw.value());
    }
    pw = getProperty(obs, "bodySite");
    if (valued(pw)) {
      td.tx(" (");
      displayCodeableConcept(td, pw.value());
      td.tx(")");
    }

    // value / dataAbsentReason (in red)
    td = tr.td();
    pw = getProperty(obs, "value[x]");
    if (valued(pw)) {
      if (pw.getTypeCode().equals("CodeableConcept"))
        displayCodeableConcept(td, pw.value());
      else if (pw.getTypeCode().equals("string"))
        displayText(td, pw.value());
      else
        td.addText(pw.getTypeCode()+" not rendered yet");
    }

    // units
    td = tr.td();
    td.tx("to do");

    // reference range
    td = tr.td();
    td.tx("to do");

    // flags (status other than F, interpretation, )
    td = tr.td();
    td.tx("to do");

    // issued if different to DR
    td = tr.td();
    td.tx("to do");
  }

  private boolean valued(PropertyWrapper pw) {
    return pw != null && pw.hasValues();
  }

  private void displayText(XhtmlNode c, BaseWrapper v) {
    c.addText(v.toString());
  }

  private String pluralise(String name, int size) {
    return size == 1 ? name : name+"s";
  }

  private void displayIdentifier(XhtmlNode c, BaseWrapper v) {
    String hint = "";
    PropertyWrapper pw = v.getChildByName("type");
    if (valued(pw)) {
      hint = genCC(pw.value());
    } else {
      pw = v.getChildByName("system");
      if (valued(pw)) {
        hint = pw.value().toString();
      }
    }
    displayText(c.span(null, hint), v.getChildByName("value").value());
  }

  private String genCoding(BaseWrapper value) {
    PropertyWrapper pw = value.getChildByName("display");
    if (valued(pw))
      return pw.value().toString();
    pw = value.getChildByName("code");
    if (valued(pw))
      return pw.value().toString();
    return "";
  }

  private String genCC(BaseWrapper value) {
    PropertyWrapper pw = value.getChildByName("text");
    if (valued(pw))
      return pw.value().toString();
    pw = value.getChildByName("coding");
    if (valued(pw))
      return genCoding(pw.getValues().get(0));
    return "";
  }

  private void displayReference(XhtmlNode c, BaseWrapper v) {
    c.tx("to do");
  }


  private void displayDate(XhtmlNode c, BaseWrapper baseWrapper) {
    c.tx("to do");
  }

  private void displayCodeableConcept(XhtmlNode c, BaseWrapper property) {
    c.tx("to do");
  }

  private void displayReferenceId(XhtmlNode c, BaseWrapper v) {
    c.tx("to do");
  }

  private PropertyWrapper getProperty(ResourceWrapper res, String name) {
    for (PropertyWrapper t : res.children()) {
      if (t.getName().equals(name))
        return t;
    }
    return null;
  }

  private void populateSubjectSummary(XhtmlNode container, BaseWrapper subject) {
    ResourceWrapper r = fetchResource(subject);
    if (r == null)
      container.tx("Unable to get Patient Details");
    else if (r.getName().equals("Patient"))
      generatePatientSummary(container, r);
    else
      container.tx("Not done yet");
  }

  private void generatePatientSummary(XhtmlNode c, ResourceWrapper r) {
    c.tx("to do");
  }

  private ResourceWrapper fetchResource(BaseWrapper subject) {
    if (resolver == null)
      return null;
    String url = subject.getChildByName("reference").value().toString();
    ResourceWithReference rr = resolver.resolve(url);
    return rr == null ? null : rr.resource;
  }

  private List<ObservationNode> fetchObservations(List<BaseWrapper> list) {
    return new ArrayList<NarrativeGenerator.ObservationNode>();
  }

  public XhtmlNode renderBundle(Bundle b) throws FHIRException {
    if (b.getType() == BundleType.DOCUMENT) {
      if (!b.hasEntry() || !(b.getEntryFirstRep().hasResource() && b.getEntryFirstRep().getResource() instanceof Composition))
        throw new FHIRException("Invalid document - first entry is not a Composition");
      Composition dr = (Composition) b.getEntryFirstRep().getResource();
      return dr.getText().getDiv();
    } else  {
      XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
      root.para().addText("Bundle "+b.getId()+" of type "+b.getType().toCode());
      int i = 0;
      for (BundleEntryComponent be : b.getEntry()) {
        i++;
        if (be.hasFullUrl())
          root.an(makeInternalLink(be.getFullUrl()));
        if (be.hasResource() && be.getResource().hasId())
          root.an(be.getResource().getResourceType().name().toLowerCase() + "_" + be.getResource().getId());
        root.hr();
        root.para().addText("Entry "+Integer.toString(i)+(be.hasFullUrl() ? " - Full URL = " + be.getFullUrl() : ""));
        if (be.hasRequest())
          renderRequest(root, be.getRequest());
        if (be.hasSearch())
          renderSearch(root, be.getSearch());
        if (be.hasResponse())
          renderResponse(root, be.getResponse());
        if (be.hasResource()) {
          root.para().addText("Resource "+be.getResource().fhirType()+":");
          if (be.hasResource() && be.getResource() instanceof DomainResource) {
            DomainResource dr = (DomainResource) be.getResource();
            if ( dr.getText().hasDiv())
              root.blockquote().getChildNodes().addAll(checkInternalLinks(b, dr.getText().getDiv().getChildNodes()));
          }
        }
      }
      return root;
    }
  }

  private List<XhtmlNode> checkInternalLinks(Bundle b, List<XhtmlNode> childNodes) {
    scanNodesForInternalLinks(b, childNodes);
    return childNodes;
  }

  private void scanNodesForInternalLinks(Bundle b, List<XhtmlNode> nodes) {
    for (XhtmlNode n : nodes) {
      if ("a".equals(n.getName()) && n.hasAttribute("href")) {
        scanInternalLink(b, n);
      }
      scanNodesForInternalLinks(b, n.getChildNodes());
    }
  }

  private void scanInternalLink(Bundle b, XhtmlNode n) {
    boolean fix = false;
    for (BundleEntryComponent be : b.getEntry()) {
      if (be.hasFullUrl() && be.getFullUrl().equals(n.getAttribute("href"))) {
        fix = true;
      }
    }
    if (fix) {
      n.setAttribute("href", "#"+makeInternalLink(n.getAttribute("href")));
    }
  }

  private String makeInternalLink(String fullUrl) {
    return fullUrl.replace(":", "-");
  }

  private void renderSearch(XhtmlNode root, BundleEntrySearchComponent search) {
    StringBuilder b = new StringBuilder();
    b.append("Search: ");
    if (search.hasMode())
      b.append("mode = "+search.getMode().toCode());
    if (search.hasScore()) {
      if (search.hasMode())
        b.append(",");
      b.append("score = "+search.getScore());
    }
    root.para().addText(b.toString());    
  }

  private void renderResponse(XhtmlNode root, BundleEntryResponseComponent response) {
    root.para().addText("Request:");
    StringBuilder b = new StringBuilder();
    b.append(response.getStatus()+"\r\n");
    if (response.hasLocation())
      b.append("Location: "+response.getLocation()+"\r\n");
    if (response.hasEtag())
      b.append("E-Tag: "+response.getEtag()+"\r\n");
    if (response.hasLastModified())
      b.append("LastModified: "+response.getEtag()+"\r\n");
    root.pre().addText(b.toString());    
  }

  private void renderRequest(XhtmlNode root, BundleEntryRequestComponent request) {
    root.para().addText("Response:");
    StringBuilder b = new StringBuilder();
    b.append(request.getMethod()+" "+request.getUrl()+"\r\n");
    if (request.hasIfNoneMatch())
      b.append("If-None-Match: "+request.getIfNoneMatch()+"\r\n");
    if (request.hasIfModifiedSince())
      b.append("If-Modified-Since: "+request.getIfModifiedSince()+"\r\n");
    if (request.hasIfMatch())
      b.append("If-Match: "+request.getIfMatch()+"\r\n");
    if (request.hasIfNoneExist())
      b.append("If-None-Exist: "+request.getIfNoneExist()+"\r\n");
    root.pre().addText(b.toString());    
  }

  public XhtmlNode renderBundle(org.hl7.fhir.r5.elementmodel.Element element) throws FHIRException {
    XhtmlNode root = new XhtmlNode(NodeType.Element, "div");
    for (Base b : element.listChildrenByName("entry")) {
      org.hl7.fhir.r5.elementmodel.Element be = ((org.hl7.fhir.r5.elementmodel.Element) b);
      org.hl7.fhir.r5.elementmodel.Element r = be.getNamedChild("resource");
      if (r!=null) {
        if (r.getChildValue("id") != null) {
          root.an(r.getChildValue("id"));
        } else if (be.getChildValue("fullUrl") != null){
          root.an(fullUrlToAnchor(be.getChildValue("fullUrl")));          
        }
        XhtmlNode c = getHtmlForResource(r);
        if (c != null)
          root.getChildNodes().addAll(c.getChildNodes());
        root.hr();
      }
    }
    return root;
  }

  private XhtmlNode getHtmlForResource(org.hl7.fhir.r5.elementmodel.Element element) {
    org.hl7.fhir.r5.elementmodel.Element text = element.getNamedChild("text");
    if (text == null)
      return null;
    org.hl7.fhir.r5.elementmodel.Element div = text.getNamedChild("div");
    if (div == null)
      return null;
    else
      return div.getXhtml();
  }

  public String getDefinitionsTarget() {
    return definitionsTarget;
  }

  public void setDefinitionsTarget(String definitionsTarget) {
    this.definitionsTarget = definitionsTarget;
  }

  public String getCorePath() {
    return corePath;
  }

  public void setCorePath(String corePath) {
    this.corePath = corePath;
  }

  public String getDestDir() {
    return destDir;
  }

  public void setDestDir(String destDir) {
    this.destDir = destDir;
  }

  public ProfileKnowledgeProvider getPkp() {
    return pkp;
  }

  public NarrativeGenerator setPkp(ProfileKnowledgeProvider pkp) {
    this.pkp = pkp;
    return this;
  }

  public boolean isPretty() {
    return pretty;
  }

  public NarrativeGenerator setPretty(boolean pretty) {
    this.pretty = pretty;
    return this;
  }

  public boolean isCanonicalUrlsAsLinks() {
    return canonicalUrlsAsLinks;
  }

  @Override
  public void setCanonicalUrlsAsLinks(boolean canonicalUrlsAsLinks) {
    this.canonicalUrlsAsLinks = canonicalUrlsAsLinks;
  }

  public String getSnomedEdition() {
    return snomedEdition;
  }

  public NarrativeGenerator setSnomedEdition(String snomedEdition) {
    this.snomedEdition = snomedEdition;
    return this;
  }

  public ValidationOptions getTerminologyServiceOptions() {
    return terminologyServiceOptions;
  }

  public void setTerminologyServiceOptions(ValidationOptions terminologyServiceOptions) {
    this.terminologyServiceOptions = terminologyServiceOptions;
  }

  public boolean isNoSlowLookup() {
    return noSlowLookup;
  }

  public void setNoSlowLookup(boolean noSlowLookup) {
    this.noSlowLookup = noSlowLookup;
  }

  public List<String> getCodeSystemPropList() {
    return codeSystemPropList;
  }

  public void displayEncounter(XhtmlNode x, Encounter wrapped) {
    throw new Error("Not done yet");    
  }

  public void displayPatient(XhtmlNode x, Patient wrapped) {
    throw new Error("Not done yet");    
  }

  private void smartAddText(XhtmlNode p, String text) {
    if (text == null)
      return;

    String[] lines = text.split("\\r\\n");
    for (int i = 0; i < lines.length; i++) {
      if (i > 0)
        p.br();
      p.addText(lines[i]);
    }
  }
  
  private boolean generate(ResourceContext rcontext, ResourceWrapper res, Provenance r) throws UnsupportedEncodingException, IOException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean hasExtensions = false;
    
    if (!r.getTarget().isEmpty()) {
      if (r.getTarget().size() == 1) {
        XhtmlNode p = x.para();
        p.tx("This provenance relates to ");
        renderReference(rcontext, res, p, r.getTargetFirstRep());
      } else {
        x.para().tx("This provenance relates to:");
        XhtmlNode ul = x.ul();
        for (Reference ref : r.getTarget()) {
          renderReference(rcontext, res, ul.li(), r.getTargetFirstRep());
        }
      }
    }
    // summary table
    x.para().tx("Summary");
    XhtmlNode t = x.table("grid");
    XhtmlNode tr;
    if (r.hasOccurred()) {
      tr = t.tr();
      tr.td().tx("Occurrence");
      if (r.hasOccurredPeriod()) {
        renderPeriod(tr.td(), r.getOccurredPeriod());
      } else {
        renderDateTime(tr.td(), r.getOccurredDateTimeType());        
      }
    }
    if (r.hasRecorded()) {
      tr = t.tr();
      tr.td().tx("Recorded");
      tr.td().addText(r.getRecordedElement().toHumanDisplay());
    }
    if (r.hasPolicy()) {
      tr = t.tr();
      tr.td().tx("Policy");
      if (r.getPolicy().size() == 1) {
        renderUri(tr.td(), r.getPolicy().get(0));
      } else {
        XhtmlNode ul = tr.td().ul();
        for (UriType u : r.getPolicy()) {
          renderUri(ul.li(), u);
        }
      }
    }
    if (r.hasLocation()) {
      tr = t.tr();
      tr.td().tx("Location");
      renderReference(rcontext, res, tr.td(), r.getLocation());      
    }
    if (r.hasActivity()) {
      tr = t.tr();
      tr.td().tx("Activity");
      renderCodeableConcept(r.getActivity(), tr.td(), false);
    }

    boolean hasType = false;
    boolean hasRole = false;
    boolean hasOnBehalfOf = false;
    for (ProvenanceAgentComponent a : r.getAgent()) {
      hasType = hasType || a.hasType(); 
      hasRole = hasRole || a.hasRole(); 
      hasOnBehalfOf = hasOnBehalfOf || a.hasOnBehalfOf(); 
    }    
    x.para().tx("Agents");
    t = x.table("grid");
    tr = t.tr();
    if (hasType) {
      tr.td().b().tx("type");
    }
    if (hasRole) {
      tr.td().b().tx("role");
    }
    tr.td().b().tx("who");
    if (hasOnBehalfOf) {
      tr.td().b().tx("onBehalfOf");
    }
    for (ProvenanceAgentComponent a : r.getAgent()) {
      tr = t.tr();
      if (hasType) {
        if (a.hasType()) {
          renderCodeableConcept(a.getType(), tr.td(), false);         
        } else {
          tr.td();
        }
      }        
      if (hasRole) {
        if (a.hasRole()) {
          if (a.getRole().size() == 1) {
            renderCodeableConcept(a.getType(), tr.td(), false);
          } else {
            XhtmlNode ul = tr.td().ul();
            for (CodeableConcept cc : a.getRole()) {
              renderCodeableConcept(cc, ul.li(), false);
            }
          }
        } else {
          tr.td();
        }
      }
      if (a.hasWho()) {
        renderReference(rcontext, res, tr.td(), a.getWho());         
      } else {
        tr.td();
      }
      if (hasOnBehalfOf) {
        if (a.hasOnBehalfOf()) {
          renderReference(rcontext, res, tr.td(), a.getOnBehalfOf());         
        } else {
          tr.td();
        }
      }
    }
    // agent table
    
    inject(r, x, hasExtensions ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
    return hasExtensions;
    
  }
}
