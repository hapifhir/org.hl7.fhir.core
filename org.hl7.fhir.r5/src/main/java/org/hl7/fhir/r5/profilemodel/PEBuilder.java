package org.hl7.fhir.r5.profilemodel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceFactory;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

/**
 * Factory class for the ProfiledElement sub-system
 * 
 * This subsystem takes a profile and creates a view of the profile that stitches
 * all the parts together, and presents it as a seemless tree. There's two views:
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

  private IWorkerContext context;
  private ProfileUtilities pu;
  private boolean elementProps;

  /**
   * @param context - must be loaded with R5 definitions
   * @param elementProps - whether to include Element.id and Element.extension in the tree
   */
  public PEBuilder(IWorkerContext context, boolean elementProps) {
    super();
    this.context = context;
    this.elementProps = elementProps;
    pu = new ProfileUtilities(context, null, null);
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
    StructureDefinition base = context.fetchTypeDefinition(profile.getType());
    if (base == null) {
      throw new DefinitionException("Unable to find base type '"+profile.getType()+"' for URL '"+url+"'");
    }
    return new PEDefinitionResource(this, base, profile);
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
    StructureDefinition base = context.fetchTypeDefinition(profile.getType());
    if (base == null) {
      throw new DefinitionException("Unable to find base type '"+profile.getType()+"' for URL '"+url+"'");
    }
    return new PEDefinitionResource(this, base, profile);
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
   * Given a profile, construct an empty resource of the type being profiled (to use as input 
   * to the buildPEInstance method
   * 
   * No version, because the version doesn't change the type of the resource
   */
  public Resource makeProfileBase(String url) {
    StructureDefinition profile = getProfile(url);
    return ResourceFactory.createResource(profile.getType());
  }


  // -- methods below here are only used internally to the package

  private StructureDefinition getProfile(String url) {
    return context.fetchResource(StructureDefinition.class, url);
  }


  private StructureDefinition getProfile(String url, String version) {
    return context.fetchResource(StructureDefinition.class, url, version);
  }

  protected List<PEDefinition> listChildren(StructureDefinition baseStructure, ElementDefinition baseDefinition,
      StructureDefinition profileStructure, ElementDefinition profiledDefinition, TypeRefComponent t, CanonicalType u) {
    // TODO Auto-generated method stub
    return null;
  }

  protected List<PEDefinition> listChildren(StructureDefinition baseStructure, ElementDefinition baseDefinition, StructureDefinition profileStructure, ElementDefinition profileDefinition, String url) {
    StructureDefinition profile = profileStructure;
    List<ElementDefinition> list = pu.getChildList(profile, profileDefinition);
    if (profileDefinition.getType().size() == 1 || (!profileDefinition.getPath().contains(".")) || list.isEmpty()) {
      assert url == null || checkType(profileDefinition, url);
      List<PEDefinition> res = new ArrayList<>();
      if (list.size() == 0) {
        profile = context.fetchResource(StructureDefinition.class, url);
        list = pu.getChildList(profile, profile.getSnapshot().getElementFirstRep());
      }
      if (list.size() > 0) {
        StructureDefinition base = baseStructure;
        List<ElementDefinition> blist = pu.getChildList(baseStructure, baseDefinition);
        if (blist.size() == 0) {
          base = context.fetchTypeDefinition(url);
          blist = pu.getChildList(base, base.getSnapshot().getElementFirstRep());
        }
        int i = 0;
        while (i < list.size()) {
          ElementDefinition defn = list.get(i);
          ElementDefinition bdefn = getByName(blist, defn);
          if (bdefn == null) {
            throw new Error("no base definition for "+defn.getId());
          }
          if (elementProps || (!Utilities.existsInList(bdefn.getBase().getPath(), "Element.id", "Element.extension"))) {
            PEDefinitionElement pe = new PEDefinitionElement(this, base, bdefn, profileStructure, defn);
            pe.setRecursing(profileDefinition == defn || (profile.getDerivation() == TypeDerivationRule.SPECIALIZATION && profile.getType().equals("Extension")));
            if (defn.hasSlicing()) {
              if (defn.getSlicing().getRules() != SlicingRules.CLOSED) {
                res.add(pe);
              }
              i++;
              while (i < list.size() && list.get(i).getPath().equals(defn.getPath())) {
                StructureDefinition ext = getExtensionDefinition(list.get(i));
                if (ext != null) {
                  res.add(new PEDefinitionExtension(this, list.get(i).getSliceName(), baseStructure, getByName(blist, defn), profileStructure, list.get(i), defn, ext));
                } else {
                  res.add(new PEDefinitionSlice(this, list.get(i).getSliceName(), baseStructure, getByName(blist, defn), profileStructure, list.get(i), defn));
                }
                i++;
              }
            } else {
              res.add(pe);
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


  protected List<PEDefinition> listSlices(StructureDefinition baseStructure, ElementDefinition baseDefinition, StructureDefinition profileStructure, ElementDefinition profileDefinition) {
    List<ElementDefinition> list = pu.getSliceList(profileStructure, profileDefinition);
    List<PEDefinition> res = new ArrayList<>();
    for (ElementDefinition ed : list) {
      if (profileStructure.getDerivation() == TypeDerivationRule.CONSTRAINT && profileStructure.getType().equals("Extension")) {
        res.add(new PEDefinitionSubExtension(this, baseStructure, baseDefinition, profileStructure, ed));
      } else {
        PEDefinitionElement pe = new PEDefinitionElement(this, baseStructure, baseDefinition, profileStructure, ed);
        pe.setRecursing(profileDefinition == ed || (profileStructure.getDerivation() == TypeDerivationRule.SPECIALIZATION && profileStructure.getType().equals("Extension")));
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
    return false;
  }


  private StructureDefinition getExtensionDefinition(ElementDefinition ed) {
    if ("Extension".equals(ed.getTypeFirstRep().getWorkingCode()) && ed.getTypeFirstRep().getProfile().size() == 1) {
      return context.fetchResource(StructureDefinition.class, ed.getTypeFirstRep().getProfile().get(0).asStringValue());
    } else {
      return null;
    }
  }


  private ElementDefinition getByName(List<ElementDefinition> blist, ElementDefinition defn) {
    for (ElementDefinition ed : blist) {
      if (ed.getName().equals(defn.getName())) {
        return ed;
      }
    }
    return null;
  }


  public PEType makeType(TypeRefComponent t) {
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

  public PEType makeType(TypeRefComponent t, CanonicalType u) {
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, u.getValue());
    if (sd == null) {
      return new PEType(tail(u.getValue()), t.getWorkingCode(), u.getValue());
    } else {
      return new PEType(sd.getName(), t.getWorkingCode(), u.getValue());
    }
  }


  public PEType makeType(String tn) {
    return new PEType(tn, tn, "http://hl7.org/fhir/StructureDefinition/"+ tn);
  }

  private String tail(String value) {
    return value.contains("/") ? value.substring(value.lastIndexOf("/")+1) : value;
  }


  public List<ElementDefinition> getChildren(StructureDefinition profileStructure, ElementDefinition profiledDefinition) {
    return pu.getChildList(profileStructure, profiledDefinition);
  }

  private PEInstance loadInstance(PEDefinition defn, Resource resource) {
    throw new NotImplementedException("Not done yet");
  }


}
