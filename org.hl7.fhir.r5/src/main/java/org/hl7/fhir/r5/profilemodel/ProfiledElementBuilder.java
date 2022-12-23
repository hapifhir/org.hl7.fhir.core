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

public class ProfiledElementBuilder {

  private IWorkerContext context;
  private ProfileUtilities pu;

  public ProfiledElementBuilder(IWorkerContext context) {
    super();
    this.context = context;
    pu = new ProfileUtilities(context, null, null);
  }
  

  /**
   * Given a profile, return a tree of elements in the profile model. This builds the profile model
   * for the latest version of the nominated profile
   * 
   * THe tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * When built with this method, the profile element can't have instance data
   * 
   * Warning: profiles and resources are recursive; you can't iterate this tree until it you get 
   * to the leaves because there are nodes that don't terminate (extensions have extensions)
   * 
   */
  public ProfiledElement buildProfileElement(String url) {
    StructureDefinition profile = getProfile(url);
    if (profile == null) {
      throw new DefinitionException("Unable to find profile for URL '"+url+"'");
    }
    StructureDefinition base = context.fetchTypeDefinition(profile.getType());
    if (base == null) {
      throw new DefinitionException("Unable to find base type '"+profile.getType()+"' for URL '"+url+"'");
    }
    return new PEResource(this, base, profile);
  }
  
  /**
   * Given a profile, return a tree of elements in the profile model. This builds the profile model
   * for the nominated version of the nominated profile
   * 
   * THe tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * When built with this method, the profile element can't have instance data
   * 
   * Warning: profiles and resources can be recursive; you can't iterate this tree until it you get 
   * to the leaves because you will never get to a child that doesn't have children
   * 
   */
  public ProfiledElement buildProfileElement(String url, String version) {
    StructureDefinition profile = getProfile(url, version);
    if (profile == null) {
      throw new DefinitionException("Unable to find profile for URL '"+url+"'");
    }
    StructureDefinition base = context.fetchTypeDefinition(profile.getType());
    if (base == null) {
      throw new DefinitionException("Unable to find base type '"+profile.getType()+"' for URL '"+url+"'");
    }
    return new PEResource(this, base, profile);
  }
  
  /**
   * Given a profile, return a tree of elements in the profile model with matching instance data. 
   * This builds the profile model for the latest version of the nominated profile and matches 
   * the data in the resource against the profile. Data can be added or read from the profile element
   * 
   * THe tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * When built with this method, the profile element can't have instance data
   * 
   * Warning: profiles and resources can be recursive; you can't iterate this tree until it you get 
   * to the leaves because you will never get to a child that doesn't have children
   * 
   */
  public ProfiledElement buildProfileElement(String url, Resource resource) {
    throw new NotImplementedException("NOt done yet");
  }
  
  /**
   * Given a profile, return a tree of elements in the profile model with matching instance data. 
   * This builds the profile model for the nominated version of the nominated profile and matches 
   * the data in the resource against the profile. Data can be added or read from the profile element
   * 
   * THe tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * When built with this method, the profile element can't have instance data
   * 
   */
  public ProfiledElement buildProfileElement(String url, String version, Resource resource) {
    throw new NotImplementedException("NOt done yet");
  }
  
  /**
   * Given a profile, construct an empty resource of the type being profiled (to use as input 
   * to the buildProfileElement method
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

  protected List<ProfiledElement> listChildren(StructureDefinition baseStructure, ElementDefinition baseDefinition,
      StructureDefinition profileStructure, ElementDefinition profiledDefinition, TypeRefComponent t, CanonicalType u) {
    // TODO Auto-generated method stub
    return null;
  }


  protected List<ProfiledElement> listChildren(StructureDefinition baseStructure, ElementDefinition baseDefinition, StructureDefinition profileStructure, ElementDefinition profileDefinition, TypeRefComponent t) {
    if (profileDefinition.getType().size() == 1 || (!profileDefinition.getPath().contains("."))) {
      assert profileDefinition.getType().size() != 1 || profileDefinition.getType().contains(t);
      List<ProfiledElement> res = new ArrayList<>();
      StructureDefinition profile = profileStructure;
      List<ElementDefinition> list = pu.getChildList(profile, profileDefinition);
      if (list.size() == 0) {
        profile = t.hasProfile() ? context.fetchResource(StructureDefinition.class, t.getProfile().get(0).getValue()) : context.fetchTypeDefinition(t.getWorkingCode());
        list = pu.getChildList(profile, profile.getSnapshot().getElementFirstRep());
      }
      if (list.size() > 0) {
        StructureDefinition base = baseStructure;
        List<ElementDefinition> blist = pu.getChildList(baseStructure, baseDefinition);
        if (blist.size() == 0) {
          base = context.fetchTypeDefinition(t.getWorkingCode());
          blist = pu.getChildList(base, base.getSnapshot().getElementFirstRep());
        }
        int i = 0;
        while (i < list.size()) {
          ElementDefinition defn = list.get(i);
          if (defn.hasSlicing()) {
            if (defn.getSlicing().getRules() != SlicingRules.CLOSED) {
              res.add(new PEElement(this, base, getByName(blist, defn), profileStructure, defn));
            }
            i++;
            while (i < list.size() && list.get(i).getPath().equals(defn.getPath())) {
              StructureDefinition ext = getExtensionDefinition(list.get(i));
              if (ext != null) {
                res.add(new PEExtension(this, list.get(i).getSliceName(), baseStructure, getByName(blist, defn), profileStructure, list.get(i), defn, ext));
              } else {
                res.add(new PESlice(this, list.get(i).getSliceName(), baseStructure, getByName(blist, defn), profileStructure, list.get(i), defn));
              }
              i++;
            }
          } else {
            res.add(new PEElement(this, base, getByName(blist, defn), profileStructure, defn));
            i++;
          }
        }
      }
      return res;
    } else {
      throw new DefinitionException("not done yet");
    }
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
 
  
}
