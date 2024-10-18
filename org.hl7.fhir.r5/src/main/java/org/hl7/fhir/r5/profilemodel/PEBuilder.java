package org.hl7.fhir.r5.profilemodel;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceFactory;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
//import org.hl7.fhir.utilities.DebugUtilities;
import org.hl7.fhir.utilities.Utilities;

/**
 * Factory class for the ProfiledElement sub-system
 * 
 * *** NOTE: This sub-system is still under development ***
 * 
 * This subsystem takes a profile and creates a view of the profile that stitches
 * all the parts together, and presents it as a seamless tree. There's two views:
 * 
 *  - definition: A logical view of the contents of the profile 
 *  - instance: a logical view of a resource that conforms to the profile
 *  
 * The tree of elements in the profile model is different to the the base resource:
 *  - some elements are removed (max = 0)
 *  - extensions are turned into named elements 
 *  - slices are turned into named elements 
 *  - element properties - doco, cardinality, binding etc is updated for what the profile says
 * 
 * Definition
 * ----------
 * This presents a single view of the contents of a resource as specified by 
 * the profile. It's suitable for use in any kind of tree view. 
 * 
 * Each node has a unique name amongst it's siblings, but this name may not be 
 * the name in the instance, since slicing splits up a single named element into 
 * different definitions.
 * 
 * Each node has:
 *   - name (unique amongst siblings)
 *   - schema name (the actual name in the instance)
 *   - min cardinality 
 *   - max cardinality 
 *   - short documentation (for the tree view)
 *   - full documentation (markdown source)
 *   - profile definition - the full definition in the profile
 *   - base definition - the full definition at the resource level
 *   - types() - a list of possible types
 *   - children(type) - a list of child nodes for the provided type 
 *   - expansion - if there's a binding, the codes in the expansion based on the binding
 *   
 * Note that the tree may not have leaves; the trees recurse indefinitely because 
 * extensions have extensions etc. So you can't do a depth-first search of the tree
 * without some kind of decision to stop at a given point. 
 * 
 * Instance
 * --------
 * 
 * todo
 * 
 * @author grahamegrieve
 *
 */
public class PEBuilder {

  public enum PEElementPropertiesPolicy {
    NONE, EXTENSION, EXTENSION_ID
  }

  private IWorkerContext context;
  private ProfileUtilities pu;
  private ContextUtilities cu;
  private PEElementPropertiesPolicy elementProps;
  private boolean fixedPropsDefault;
  private FHIRPathEngine fpe;

  /**
   * @param context - must be loaded with R5 definitions
   * @param elementProps - whether to include Element.id and Element.extension in the tree. Recommended choice: Extension
   */
  public PEBuilder(IWorkerContext context, PEElementPropertiesPolicy elementProps, boolean fixedPropsDefault) {
    super();
    this.context = context;
    this.elementProps = elementProps;
    this.fixedPropsDefault = fixedPropsDefault;
    pu = new ProfileUtilities(context, null, null);
    cu = new ContextUtilities(context);
    fpe = new FHIRPathEngine(context, pu);
  }
  
  /**
   * Given a profile, return a tree of the elements defined in the profile model. This builds the profile model
   * for the provided version of the nominated profile
   * 
   * The tree of elements in the profile model is different to those defined in the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * Warning: profiles and resources are recursive; you can't iterate this tree until it you get 
   * to the leaves because there are nodes that don't terminate (extensions have extensions)
   * 
   */
  public PEDefinition buildPEDefinition(StructureDefinition profile) {
    if (!profile.hasSnapshot()) {
      throw new DefinitionException("Profile '"+profile.getVersionedUrl()+"' does not have a snapshot");      
    }
    return new PEDefinitionResource(this, profile, profile.getName());
  }
  
  /**
   * Given a profile, return a tree of the elements defined in the profile model. This builds the profile model
   * for the latest version of the nominated profile
   * 
   * The tree of elements in the profile model is different to those defined in the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * Warning: profiles and resources are recursive; you can't iterate this tree until it you get 
   * to the leaves because there are nodes that don't terminate (extensions have extensions)
   * 
   */
  public PEDefinition buildPEDefinition(String url) {
    StructureDefinition profile = getProfile(url);
    if (profile == null) {
      throw new DefinitionException("Unable to find profile for URL '"+url+"'");
    }
    if (!profile.hasSnapshot()) {
      throw new DefinitionException("Profile '"+url+"' does not have a snapshot");      
    }
    return new PEDefinitionResource(this, profile, profile.getName());
  }
  
  /**
   * Given a profile, return a tree of the elements defined in the profile model. This builds the profile model
   * for the nominated version of the nominated profile
   * 
   * The tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * Warning: profiles and resources can be recursive; you can't iterate this tree until it you get 
   * to the leaves because you will never get to a child that doesn't have children
   * 
   */
  public PEDefinition buildPEDefinition(String url, String version) {
    StructureDefinition profile = getProfile(url, version);
    if (profile == null) {
      throw new DefinitionException("Unable to find profile for URL '"+url+"'");
    }
    if (!profile.hasSnapshot()) {
      throw new DefinitionException("Profile '"+url+"' does not have a snapshot");      
    }
    return new PEDefinitionResource(this, profile, profile.getName());
  }
  
  /**
   * Given a resource and a profile, return a tree of instance data as defined by the profile model 
   * using the latest version of the profile
   * 
   * The tree is a facade to the underlying resource - all actual data is stored against the resource,
   * and retrieved on the fly from the resource, so that applications can work at either level, as 
   * convenient. 
   * 
   * Note that there's a risk that deleting something through the resource while holding 
   * a handle to a PEInstance that is a facade on what is deleted leaves an orphan facade 
   * that will continue to function, but is making changes to resource content that is no 
   * longer part of the resource 
   * 
   */
  public PEInstance buildPEInstance(String url, Resource resource) {
    PEDefinition defn = buildPEDefinition(url);
    return loadInstance(defn, resource);
  }
  
  /**
   * Given a resource and a profile, return a tree of instance data as defined by the profile model 
   * using the provided version of the profile
   * 
   * The tree is a facade to the underlying resource - all actual data is stored against the resource,
   * and retrieved on the fly from the resource, so that applications can work at either level, as 
   * convenient. 
   * 
   * Note that there's a risk that deleting something through the resource while holding 
   * a handle to a PEInstance that is a facade on what is deleted leaves an orphan facade 
   * that will continue to function, but is making changes to resource content that is no 
   * longer part of the resource 
   * 
   */
  public PEInstance buildPEInstance(StructureDefinition profile, Resource resource) {
    PEDefinition defn = buildPEDefinition(profile);
    return loadInstance(defn, resource);
  }
  
  /**
   * Given a resource and a profile, return a tree of instance data as defined by the profile model 
   * using the nominated version of the profile
   * 
   * The tree is a facade to the underlying resource - all actual data is stored against the resource,
   * and retrieved on the fly from the resource, so that applications can work at either level, as 
   * convenient. 
   * 
   * Note that there's a risk that deleting something through the resource while holding 
   * a handle to a PEInstance that is a facade on what is deleted leaves an orphan facade 
   * that will continue to function, but is making changes to resource content that is no 
   * longer part of the resource 
   */
  public PEInstance buildPEInstance(String url, String version, Resource resource) {
    PEDefinition defn = buildPEDefinition(url, version);
    return loadInstance(defn, resource);
  }
  
  /**
   * For the current version of a profile, construct a resource and fill out any fixed or required elements
   * 
   * Note that fixed values are filled out irrespective of the value of fixedProps when the builder is created
   * 
   * @param url identifies the profile
   * @param version identifies the version of the profile
   * @param meta whether to mark the profile in Resource.meta.profile 
   * @return constructed resource
   */
  public Resource createResource(String url, String version, boolean meta) {
    PEDefinition definition = buildPEDefinition(url, version);
    Resource res = ResourceFactory.createResource(definition.types().get(0).getType());
    populateByProfile(res, definition);
    if (meta) {
      res.getMeta().addProfile(definition.profile.getUrl());
    }
    return res;
  }

  /**
   * For the provided version of a profile, construct a resource and fill out any fixed or required elements
   * 
   * Note that fixed values are filled out irrespective of the value of fixedProps when the builder is created
   * 
   * @param profile  the profile
   * @param meta whether to mark the profile in Resource.meta.profile 
   * @return constructed resource
   */
  public Resource createResource(StructureDefinition profile, boolean meta) {
    PEDefinition definition = buildPEDefinition(profile);
    Resource res = ResourceFactory.createResource(definition.types().get(0).getType());
    populateByProfile(res, definition);
    if (meta) {
      res.getMeta().addProfile(definition.profile.getUrl());
    }
    return res;
  }

  /**
   * For the current version of a profile, construct a resource and fill out any fixed or required elements
   * 
   * Note that fixed values are filled out irrespective of the value of fixedProps when the builder is created
   * 
   * @param url identifies the profile
   * @param meta whether to mark the profile in Resource.meta.profile 
   * @return constructed resource
   */
  public Resource createResource(String url, boolean meta) {
    PEDefinition definition = buildPEDefinition(url);
    Resource res = ResourceFactory.createResource(definition.types().get(0).getType());
    populateByProfile(res, definition);
    if (meta) {
      res.getMeta().addProfile(definition.profile.getUrl());
    }
    return res;
  }



  // -- methods below here are only used internally to the package

  private StructureDefinition getProfile(String url) {
    return context.fetchResource(StructureDefinition.class, url);
  }


  private StructureDefinition getProfile(String url, String version) {
    return context.fetchResource(StructureDefinition.class, url, version);
  }
//
//  protected List<PEDefinition> listChildren(boolean allFixed, StructureDefinition profileStructure, ElementDefinition definition, TypeRefComponent t, CanonicalType u) {
//    // TODO Auto-generated method stub
//    return null;
//  }

  protected List<PEDefinition> listChildren(boolean allFixed, PEDefinition parent, StructureDefinition profileStructure, ElementDefinition definition, String url, String... omitList) {
    StructureDefinition profile = profileStructure;
    List<ElementDefinition> list = pu.getChildList(profile, definition);
    if (definition.getType().size() == 1 || (!definition.getPath().contains(".")) || list.isEmpty()) {
      assert url == null || checkType(definition, url);
      List<PEDefinition> res = new ArrayList<>();
      if (list.size() == 0) {
        profile = context.fetchResource(StructureDefinition.class, url);
        list = pu.getChildList(profile, profile.getSnapshot().getElementFirstRep());
      }
      if (list.size() > 0) {
        int i = 0;
        while (i < list.size()) {
          ElementDefinition defn = list.get(i);
          if (!defn.getMax().equals("0") && (allFixed || include(defn))) {
            if (passElementPropsCheck(defn) && !Utilities.existsInList(defn.getName(), omitList)) {
              if (defn.getType().size() > 1) {
                // DebugUtilities.breakpoint();
                i++;
              } else {
                PEDefinitionElement pe = new PEDefinitionElement(this, profile, defn, parent.path());
                pe.setRecursing(definition == defn || (profile.getDerivation() == TypeDerivationRule.SPECIALIZATION && profile.getType().equals("Extension")));
                if (context.isPrimitiveType(definition.getTypeFirstRep().getWorkingCode()) && "value".equals(pe.name())) {
                  pe.setMustHaveValue(definition.getMustHaveValue());
                }
                pe.setInFixedValue(definition.hasFixed() || definition.hasPattern() || parent.isInFixedValue());
                if (defn.hasSlicing()) {
                  if (defn.getSlicing().getRules() != SlicingRules.CLOSED) {
                    res.add(pe);
                    pe.setSlicer(true);
                  }
                  i++;
                  while (i < list.size() && list.get(i).getPath().equals(defn.getPath())) {
                    StructureDefinition ext = getExtensionDefinition(list.get(i));
                    if (ext != null) {
                      res.add(new PEDefinitionExtension(this, list.get(i).getSliceName(), profile, list.get(i), defn, ext, parent.path()));
                    } else if (isTypeSlicing(defn)) {
                      res.add(new PEDefinitionTypeSlice(this, list.get(i).getSliceName(), profile, list.get(i), defn, parent.path()));
                    } else {
                      if (ProfileUtilities.isComplexExtension(profile) && defn.getPath().endsWith(".extension")) {
                        res.add(new PEDefinitionSubExtension(this, profile, list.get(i), parent.path()));
                      } else {
                        res.add(new PEDefinitionSlice(this, list.get(i).getSliceName(), profile, list.get(i), defn, parent.path()));
                      }
                    }
                    i++;
                  }
                } else {
                  res.add(pe);
                  i++;
                }
              }
            } else {
              i++;
            } 
          } else {
            i++;
          }
        }
      }
      return res;
    } else if (list.isEmpty()) {
      throw new DefinitionException("not done yet!");
    } else {
      throw new DefinitionException("not done yet");
    }
  }

  protected PEDefinition makeChild(PEDefinition parent, StructureDefinition profileStructure, ElementDefinition definition) {
    PEDefinitionElement pe = new PEDefinitionElement(this, profileStructure, definition, parent.path());
    if (context.isPrimitiveType(definition.getTypeFirstRep().getWorkingCode()) && "value".equals(pe.name())) {
      pe.setMustHaveValue(definition.getMustHaveValue());
    }
    pe.setInFixedValue(definition.hasFixed() || definition.hasPattern() || parent.isInFixedValue());
    return pe;
  }

  private boolean passElementPropsCheck(ElementDefinition bdefn) {
    switch (elementProps) {
    case EXTENSION:
      return !Utilities.existsInList(bdefn.getBase().getPath(), "Element.id");
    case NONE:
      return !Utilities.existsInList(bdefn.getBase().getPath(), "Element.id", "Element.extension");
    case EXTENSION_ID:
    default:
      return true;
    }
  }

  private boolean isTypeSlicing(ElementDefinition defn) {
    ElementDefinitionSlicingComponent sl = defn.getSlicing();
    return sl.getRules() == SlicingRules.CLOSED && sl.getDiscriminator().size() == 1 &&
        sl.getDiscriminatorFirstRep().getType() == DiscriminatorType.TYPE && "$this".equals(sl.getDiscriminatorFirstRep().getPath());
  }

  private boolean include(ElementDefinition defn) {
    if (fixedPropsDefault) { 
      return true;
    } else { 
      return !(defn.hasFixed() || defn.hasPattern());
    }
  }

  protected List<PEDefinition> listSlices(StructureDefinition profileStructure, ElementDefinition definition, PEDefinition parent) {
    List<ElementDefinition> list = pu.getSliceList(profileStructure, definition);
    List<PEDefinition> res = new ArrayList<>();
    for (ElementDefinition ed : list) {
      if (profileStructure.getDerivation() == TypeDerivationRule.CONSTRAINT && profileStructure.getType().equals("Extension")) {
        res.add(new PEDefinitionSubExtension(this, profileStructure, ed, parent.path()));
      } else {
        PEDefinitionElement pe = new PEDefinitionElement(this, profileStructure, ed, parent.path());
        pe.setRecursing(definition == ed || (profileStructure.getDerivation() == TypeDerivationRule.SPECIALIZATION && profileStructure.getType().equals("Extension")));
        res.add(pe);
      }
    }
    return res;
  }


  private boolean checkType(ElementDefinition defn, String url) {
    for (TypeRefComponent t : defn.getType()) {
      if (("http://hl7.org/fhir/StructureDefinition/"+t.getWorkingCode()).equals(url)) {
        return true;
      }
      for (CanonicalType u : t.getProfile()) {
        if (url.equals(u.getValue())) {
          return true;
        }
      }
    }
    return !defn.getPath().contains(".");
  }


  private StructureDefinition getExtensionDefinition(ElementDefinition ed) {
    if ("Extension".equals(ed.getTypeFirstRep().getWorkingCode()) && ed.getTypeFirstRep().getProfile().size() == 1) {
      return context.fetchResource(StructureDefinition.class, ed.getTypeFirstRep().getProfile().get(0).asStringValue());
    } else {
      return null;
    }
  }


  private ElementDefinition getByName(List<ElementDefinition> blist, String name) {
    for (ElementDefinition ed : blist) {
      if (name.equals(ed.getName())) {
        return ed;
      }
    }
    return null;
  }


  protected PEType makeType(TypeRefComponent t) {
    if (t.hasProfile()) {
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, t.getProfile().get(0).getValue());
      if (sd == null) {
        return new PEType(tail(t.getProfile().get(0).getValue()), t.getWorkingCode(), t.getProfile().get(0).getValue());
      } else {
        return new PEType(sd.getName(), t.getWorkingCode(), t.getProfile().get(0).getValue());
      }
    } else {
      return makeType(t.getWorkingCode());
    } 
  }

  protected PEType makeType(TypeRefComponent t, CanonicalType u) {
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, u.getValue());
    if (sd == null) {
      return new PEType(tail(u.getValue()), t.getWorkingCode(), u.getValue());
    } else {
      return new PEType(sd.getName(), t.getWorkingCode(), u.getValue());
    }
  }


  protected PEType makeType(String tn, String url) {
    return new PEType(tn, tn, url);
  }
  
  protected PEType makeType(String tn) {
    return new PEType(tn, tn, "http://hl7.org/fhir/StructureDefinition/"+ tn);
  }

  private String tail(String value) {
    return value.contains("/") ? value.substring(value.lastIndexOf("/")+1) : value;
  }

  protected List<ElementDefinition> getChildren(StructureDefinition profileStructure, ElementDefinition definition) {
    return pu.getChildList(profileStructure, definition);
  }

  private PEInstance loadInstance(PEDefinition defn, Resource resource) {
    return new PEInstance(this, defn, resource, resource, defn.name());
  }

  public IWorkerContext getContext() {
    return context;
  }

  protected void populateByProfile(Base base, PEDefinition definition) {
    if (definition.types().size() == 1) {
      for (PEDefinition pe : definition.directChildren(true)) {
        if (pe.hasFixedValue()) {
          if (pe.definition().hasPattern()) {
            base.setProperty(pe.schemaName(), pe.definition().getPattern());
          } else { 
            base.setProperty(pe.schemaName(), pe.definition().getFixed());
          }
        } else if (!pe.isSlicer() && pe.max() == 1) {
          for (int i = 0; i < pe.min(); i++) {
            Base b = null;
            if (pe.schemaName().endsWith("[x]")) {
              if (pe.types().size() == 1) {
                b = base.addChild(pe.schemaName().replace("[x]", Utilities.capitalize(pe.types().get(0).getType())));
              }
            } else if (!pe.isBaseList()) {
              b = base.makeProperty(pe.schemaName().hashCode(), pe.schemaName());
            } else {
              b = base.addChild(pe.schemaName());
            }
            if (b != null) {
              populateByProfile(b, pe);
            }
          }
        }
      }
    }
  }

  public String makeSliceExpression(StructureDefinition profile, ElementDefinitionSlicingComponent slicing, ElementDefinition definition) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(" and ");
    for (ElementDefinitionSlicingDiscriminatorComponent d : slicing.getDiscriminator()) {
      switch (d.getType()) {
      case EXISTS:
        throw new DefinitionException("The discriminator type 'exists' is not supported by the PEBuilder");
      case PATTERN:
        throw new DefinitionException("The discriminator type 'pattern' is not supported by the PEBuilder");
      case POSITION:
        throw new DefinitionException("The discriminator type 'position' is not supported by the PEBuilder");
      case PROFILE:
        throw new DefinitionException("The discriminator type 'profile' is not supported by the PEBuilder");
      case TYPE:
        throw new DefinitionException("The discriminator type 'type' is not supported by the PEBuilder");
      case VALUE:
        String path = d.getPath();
        if (path.contains(".")) {
          throw new DefinitionException("The discriminator path '"+path+"' is not supported by the PEBuilder");          
        }
        ElementDefinition ed = getChildElement(profile, definition, path);
        if (ed == null) {
          throw new DefinitionException("The discriminator path '"+path+"' could not be resolved by the PEBuilder");          
        }
        if (!ed.hasFixed()) {
          throw new DefinitionException("The discriminator path '"+path+"' has no fixed value - this is not supported by the PEBuilder");          
        }
        if (!ed.getFixed().isPrimitive()) {
          throw new DefinitionException("The discriminator path '"+path+"' has a fixed value that is not a primitive ("+ed.getFixed().fhirType()+") - this is not supported by the PEBuilder");          
        }
        b.append(path+" = '"+ed.getFixed().primitiveValue()+"'");
        break;
      case NULL:
        throw new DefinitionException("The discriminator type 'null' is not supported by the PEBuilder");
      default:
        throw new DefinitionException("The discriminator type '??' is not supported by the PEBuilder"); 
      }
    }
    return b.toString();
  }

  private ElementDefinition getChildElement(StructureDefinition profile, ElementDefinition definition, String path) {
    List<ElementDefinition> elements = pu.getChildList(profile, definition);
    if (elements.size() == 0) {
      profile = definition.getTypeFirstRep().hasProfile() ? context.fetchResource(StructureDefinition.class, definition.getTypeFirstRep().getProfile().get(0).asStringValue()) :
        context.fetchTypeDefinition(definition.getTypeFirstRep().getWorkingCode());
      elements = pu.getChildList(profile, profile.getSnapshot().getElementFirstRep());
    }
    return getByName(elements, path);
  }

  public List<Base> exec(Resource resource, Base data, String fhirpath) {
    return fpe.evaluate(this, resource, resource, data, fhirpath);
  }

  public boolean isResource(String name) {
    return cu.isResource(name);
  }
}
