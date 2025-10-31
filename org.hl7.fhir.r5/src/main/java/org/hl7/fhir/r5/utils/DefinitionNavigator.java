package org.hl7.fhir.r5.utils;

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



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;

@MarkedToMoveToAdjunctPackage
public class DefinitionNavigator {

  private IWorkerContext context;
  private StructureDefinition structure;
  private int index;
  private boolean indexMatches; // 
  private List<DefinitionNavigator> children;
  private List<DefinitionNavigator> typeChildren;
  private List<DefinitionNavigator> slices;
  private List<String> names = new ArrayList<String>();
  private TypeRefComponent typeOfChildren;
  private String globalPath;
  private String localPath;
  private boolean diff;
  private boolean followTypes;
  private boolean inlineChildren;
  private ElementDefinitionSlicingComponent manualSlice;
  private TypeRefComponent manualType;
  
  public DefinitionNavigator(IWorkerContext context, StructureDefinition structure, boolean diff, boolean followTypes) throws DefinitionException {
    if (!diff && !structure.hasSnapshot())
      throw new DefinitionException("Snapshot required");
    this.context = context;
    this.structure = structure;
    this.index = 0;
    this.diff = diff;
    this.followTypes = followTypes;
    if (diff) {
      this.globalPath = structure.getType(); // fragile?
      indexMatches = this.globalPath.equals(list().get(0).getPath());
    } else {
      indexMatches = true;
      this.globalPath = current().getPath(); // first element
    }
    this.localPath = this.globalPath;
    names.add(nameTail());
  }
  
  private DefinitionNavigator(IWorkerContext context, StructureDefinition structure, boolean diff, boolean followTypes, int index, String globalPath, String localPath, List<String> names, String type) {
    this.globalPath = globalPath;
    this.localPath = localPath;
    this.context = context;
    this.structure = structure;
    this.diff = diff;
    this.followTypes = followTypes;
    this.index = index;
    this.indexMatches = true;
    if (type == null)
      for (String name : names)
        this.names.add(name+"."+nameTail());
    else {
      this.names.addAll(names);
      this.names.add(type);
    }
  }
  
  /**
   * Special case - changing the value of followTypes, for special use case
   * @param other
   * @param followTypes
   */
  public DefinitionNavigator(DefinitionNavigator other, boolean followTypes) {
    this.context = other.context;
    this.structure =  other.structure;
    this.index =  other.index;
    this.diff =  other.diff;
    this.followTypes = followTypes;
    this.globalPath = other.globalPath;
    this.localPath = other.localPath;
    this.indexMatches = other.indexMatches;
    this.typeOfChildren = other.typeOfChildren;
    this.inlineChildren = other.inlineChildren;
    this.manualSlice = other.manualSlice;
    this.manualType = other.manualType;
  }
  
  /**
   * When you walk a tree, and you walk into a typed structure, an element can simultaineously 
   * be covered by multiple types at once. Take, for example, the string label for an identifer value.
   * It has the following paths:
   *   Patient.identifier.value.value
   *   Identifier.value.value
   *   String.value
   *   value
   * If you started in a bundle, the list might be even longer and deeper
   *   
   * Any of these names might be relevant. This function returns the names in an ordered list
   * in the order above  
   * @return
   */
  public List<String> getNames() {
    return names;
  }
  
  private List<ElementDefinition> list() {
    if (diff) {
      return structure.getDifferential().getElement();      
    } else {
      return structure.getSnapshot().getElement();
    }    
  }
  public ElementDefinition current() {
   return indexMatches ? list().get(index) : null;      
  }
  
  public List<DefinitionNavigator> slices() throws DefinitionException {
    if (children == null) {
      loadChildren();
    }
    // never return null: if no slices were found, give back an empty list
    return slices != null ? slices : Collections.emptyList();
  }
  
  public List<DefinitionNavigator> children() throws DefinitionException {
    if (children == null) {
      loadChildren();
    }
    return children;
  }

  private void loadChildren() throws DefinitionException {
    children = new ArrayList<DefinitionNavigator>();
    String prefix = localPath+".";
    Map<String, DefinitionNavigator> nameMap = new HashMap<String, DefinitionNavigator>();

    int workingIndex = index;
    ElementDefinition curr = current();
    if (curr != null && curr.hasContentReference()) {
      if (!(workingIndex < list().size()-1 && list().get(workingIndex+1).getPath().startsWith(prefix))) {
        String ref = curr.getContentReference();
        if (ref.contains("#")) {
          ref = ref.substring(ref.indexOf("#")+1);
        }
        prefix = ref;
        workingIndex = getById(list(), ref);
      }
    }

    DefinitionNavigator last = null;
    String polymorphicRoot = null;
    DefinitionNavigator polymorphicDN = null;
    for (int i = indexMatches ? workingIndex + 1 : workingIndex; i < list().size(); i++) {
      String path = list().get(i).getPath();
      if (path.startsWith(prefix)) {
        if (!path.substring(prefix.length()).contains(".")) {
          // immediate child
          DefinitionNavigator dn = new DefinitionNavigator(context, structure, diff, followTypes, i, this.globalPath+"."+tail(path), path, names, null);
          last = dn;

          if (nameMap.containsKey(path)) {
            DefinitionNavigator master = nameMap.get(path);
            ElementDefinition cm = master.current();
            // Skip missing slicing error for extensions: they are implicitly sliced by url
            if (!diff && !cm.hasSlicing()) {
              String cmPath = cm.getPath();
              boolean isExtension = cmPath.endsWith(".extension")
                                 || cmPath.endsWith(".modifierExtension");
              if (!isExtension) {
                throw new DefinitionException("Found slices with no slicing details at " + dn.current().getPath());
              }
            }
            if (master.slices == null) {
              master.slices = new ArrayList<DefinitionNavigator>();
            }
            master.slices.add(dn);
          
          } else if (polymorphicRoot != null && path.startsWith(polymorphicRoot) && !path.substring(polymorphicRoot.length()).contains(".")) {
            if (polymorphicDN.slices == null) {
              polymorphicDN.slices = new ArrayList<DefinitionNavigator>();
              polymorphicDN.manualSlice = new ElementDefinitionSlicingComponent();
              polymorphicDN.manualSlice.setUserData(UserDataNames.DN_TRANSIENT, "true");
              polymorphicDN.manualSlice.setRules(SlicingRules.CLOSED);
              polymorphicDN.manualSlice.setOrdered(false);
              polymorphicDN.manualSlice.addDiscriminator().setType(DiscriminatorType.TYPE).setPath("$this");
            }
            polymorphicDN.slices.add(dn);
            if (!dn.current().hasType()) {
              String t = path.substring(polymorphicRoot.length());
              StructureDefinition sd = context.fetchTypeDefinition(t);
              if (sd == null) {
                sd = context.fetchTypeDefinition(Utilities.uncapitalize(t));
              }
              if (sd != null) {
                dn.manualType = new TypeRefComponent(sd.getType());
              }
            }
          } else if (dn.current().hasSliceName()) {
            // this is an error unless we're dealing with extensions, which are auto-sliced (for legacy reasons)
            if (diff && "extension".equals(dn.current().getName())) {
              StructureDefinition vsd = new StructureDefinition(); // fake wrapper for placeholder element
              vsd.getDifferential().getElement().add(makeExtensionDefinitionElement(path));
              DefinitionNavigator master = new DefinitionNavigator(context, vsd, diff, followTypes, 0, this.globalPath+"."+tail(path), path, names, null);
              nameMap.put(path, master);
              children.add(master);
              master.slices = new ArrayList<DefinitionNavigator>();
              master.slices.add(dn);
            } else {
              throw new DefinitionException(context.formatMessage(I18nConstants.DN_SLICE_NO_DEFINITION, path));
            }
          } else {
            nameMap.put(path, dn);
            children.add(dn);
            if (diff && path.endsWith("[x]")) { 
              // we're going to infer slicing if we need to
              polymorphicRoot = path.substring(0, path.length() -3);
              polymorphicDN = dn;
            } else {
              polymorphicRoot = null;
              polymorphicDN = null;
              
            }
          }
        } else if (last == null || !path.startsWith(last.localPath)) {
          // implied child
          DefinitionNavigator dn = new DefinitionNavigator(context, structure, diff, followTypes, i, this.globalPath+"."+tail(path), path, names, null);
          nameMap.put(path, dn);
          children.add(dn);
        }
      } else if (path.length() < prefix.length()) {
        break;
      }
    }
    if (children.isEmpty() && current().hasContentReference()) {
      throw new Error("What?");
    }
    inlineChildren = !children.isEmpty();
    if (children.isEmpty() && followTypes) {
      ElementDefinition ed = current();
      if (ed.getType().size() != 1) {
        // well, we can't walk into it 
        return; // what to do?
      }
      TypeRefComponent tr = ed.getTypeFirstRep();
      StructureDefinition sdt = null;
      if (tr.getProfile().size() > 1) {
        return;
      } else if (tr.getProfile().size() == 1) {
        sdt = context.fetchResource(StructureDefinition.class, tr.getProfile().get(0).asStringValue());        
      } else {
        sdt = context.fetchTypeDefinition(ed.getTypeFirstRep().getWorkingCode());
      }
      if (sdt == null) {
        return;
      }
      List<ElementDefinition> list = diff ? sdt.getDifferential().getElement() : sdt.getSnapshot().getElement();
      for (int i = 0; i < list.size(); i++) {
        ElementDefinition edt = list.get(i);
        if (Utilities.charCount(edt.getPath(), '.') == 1) {
          DefinitionNavigator dn = new DefinitionNavigator(context, sdt, diff, followTypes, i, this.globalPath+"."+tail(edt.getPath()), edt.getPath(), names, null);
          children.add(dn);
        }
      }
    }
  }

  private int getById(List<ElementDefinition> list, String ref) {
    for (ElementDefinition ed : list) {
      if (ref.equals(ed.getPath())) {
        return list.indexOf(ed);
      }
    }
    return -1;
  }

  private ElementDefinition makeExtensionDefinitionElement(String path) {
    ElementDefinition ed = new ElementDefinition(path);
    ed.setUserData(UserDataNames.DN_TRANSIENT, "true");
    ed.getSlicing().setRules(SlicingRules.OPEN).setOrdered(false).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("url");
    return ed;
  }

  public String globalPath() {
    return globalPath;
  }

  public String localPath() {
    return localPath;
  }

  private String tail(String p) {
    if (p.contains("."))
      return p.substring(p.lastIndexOf('.')+1);
    else
      return p;
  }

  public String nameTail() {
    return tail(localPath);
  }

  /**
   * if you have a typed element, the tree might end at that point.
   * And you may or may not want to walk into the tree of that type
   * It depends what you are doing. So this is a choice. You can 
   * ask for the children, and then, if you get no children, you 
   * can see if there are children defined for the type, and then 
   * get them
   * 
   * you have to provide a type if there's more than one type 
   * for current() since this library doesn't know how to choose
   * @param res 
   * @throws DefinitionException 
   * @
   */
  public boolean hasTypeChildren(TypeRefComponent type, Resource res) throws DefinitionException {
    if (typeChildren == null || typeOfChildren != type) {
      loadTypedChildren(type, res);
    }
    return !typeChildren.isEmpty();
  }

  private void loadTypedChildren(TypeRefComponent type, Resource src) throws DefinitionException {
    typeOfChildren = null;
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, /* GF#13465 : this somehow needs to be revisited type.hasProfile() ? type.getProfile() : */ type.getWorkingCode(), null, src);
    if (sd != null) {
      DefinitionNavigator dn = new DefinitionNavigator(context, sd, diff, followTypes, 0, globalPath, localPath, names, sd.getType());
      typeChildren = dn.children();
    } else
      throw new DefinitionException("Unable to find definition for "+type.getWorkingCode()+(type.hasProfile() ? "("+type.getProfile()+")" : ""));
    typeOfChildren = type;
  }

  /**
   * 
   * @param res 
   * @return
   * @throws DefinitionException 
   * @
   */
  public List<DefinitionNavigator> childrenFromType(TypeRefComponent type, Resource res) throws DefinitionException {
    if (typeChildren == null || typeOfChildren != type) {
      loadTypedChildren(type, res);
    }
    return typeChildren;
  }

  public StructureDefinition getStructure() {
    return structure;
  }

  @Override
  public String toString() {
    return getId();
  }

  public String getId() {
    return current() == null ? localPath : current().hasSliceName() ? current().getPath()+":"+current().getSliceName() : current().getPath();
  }

  public Base parent() {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean sliced() {
    if (manualSlice != null) {
      return true;
    } else if (current() == null) {
      return false;
    } else {
      return current().hasSlicing();
    }
  }

  public DefinitionNavigator childByPath(String path) {
    for (DefinitionNavigator child : children()) {
      if (child.globalPath().equals(path)) {
        return child;
      }
    }
    return null;
  }

  public boolean hasChildren() {
    return !children().isEmpty();
  }

  public boolean hasSlices() {
     return sliced() && slices != null && !slices.isEmpty();
  }

  public boolean hasInlineChildren() {
    if (children == null) {
      loadChildren();
    }
    return inlineChildren;
  }

  public DefinitionNavigator childByName(String name) {
    for (DefinitionNavigator child : children()) {
      if (child.current().getName().equals(name)) {
        return child;
      }
      if (child.current().getName().startsWith(name+"[x]")) {
        return child;
      }
    }
    return null;
  }

  public boolean isManualSliced() {
    return manualSlice != null;
  }

  public ElementDefinitionSlicingComponent getSlicing() {
    return manualSlice != null ? manualSlice : current().getSlicing();
  }

  public void setManualSliced(ElementDefinitionSlicingComponent manualSliced) {
    this.manualSlice = manualSliced;
  }

  public TypeRefComponent getManualType() {
    return manualType;
  }
  

}