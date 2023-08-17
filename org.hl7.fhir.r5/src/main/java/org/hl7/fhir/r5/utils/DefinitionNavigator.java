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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;

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
  private String path;
  private boolean diff;
  
  public DefinitionNavigator(IWorkerContext context, StructureDefinition structure, boolean diff) throws DefinitionException {
    if (!diff && !structure.hasSnapshot())
      throw new DefinitionException("Snapshot required");
    this.context = context;
    this.structure = structure;
    this.index = 0;
    this.diff = diff;
    if (diff) {
      this.path = structure.getType(); // fragile?
      indexMatches = this.path.equals(list().get(0).getPath());
    } else {
      indexMatches = true;
      this.path = current().getPath(); // first element
    }
    names.add(nameTail());
  }
  
  private DefinitionNavigator(IWorkerContext context, StructureDefinition structure, boolean diff, int index, String path, List<String> names, String type) {
    this.path = path;
    this.context = context;
    this.structure = structure;
    this.diff = diff;
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
    return slices;
  }
  
  public List<DefinitionNavigator> children() throws DefinitionException {
    if (children == null) {
      loadChildren();
    }
    return children;
  }

  private void loadChildren() throws DefinitionException {
    children = new ArrayList<DefinitionNavigator>();
    String prefix = path+".";
    Map<String, DefinitionNavigator> nameMap = new HashMap<String, DefinitionNavigator>();

    DefinitionNavigator last = null;
    for (int i = indexMatches ? index + 1 : index; i < list().size(); i++) {
      String path = list().get(i).getPath();
      if (path.startsWith(prefix)) {
        if (!path.substring(prefix.length()).contains(".")) {
          // immediate child
          DefinitionNavigator dn = new DefinitionNavigator(context, structure, diff, i, this.path+"."+tail(path), names, null);
          last = dn;

          if (nameMap.containsKey(path)) {
            DefinitionNavigator master = nameMap.get(path);
            ElementDefinition cm = master.current();
            if (diff && cm.hasSliceName()) { 
              // slice name - jumped straight into slicing
              children.add(dn);
            } else {
              if (!cm.hasSlicing()) {
                throw new DefinitionException("Found slices with no slicing details at "+dn.current().getPath());
              }
              if (master.slices == null) {
                master.slices = new ArrayList<DefinitionNavigator>();
              }
              master.slices.add(dn);
            }
          } else {
            nameMap.put(path, dn);
            children.add(dn);
          }
        } else if (last == null || !path.startsWith(last.path)) {
          // implied child
          DefinitionNavigator dn = new DefinitionNavigator(context, structure, diff, i, this.path+"."+tail(path), names, null);
          nameMap.put(path, dn);
          children.add(dn);
        }
      } else if (path.length() < prefix.length())
        break;
    }
  }

  public String path() {
    return path;
  }
  
  private String tail(String p) {
    if (p.contains("."))
      return p.substring(p.lastIndexOf('.')+1);
    else
      return p;
  }

  public String nameTail() {
    return tail(path);
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
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, /* GF#13465 : this somehow needs to be revisited type.hasProfile() ? type.getProfile() : */ type.getWorkingCode(), src);
    if (sd != null) {
      DefinitionNavigator dn = new DefinitionNavigator(context, sd, diff, 0, path, names, sd.getType());
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
    return current() == null ? path : current().hasSliceName() ? current().getPath()+":"+current().getSliceName() : current().getPath();
  }

  public Base parent() {
    // TODO Auto-generated method stub
    return null;
  }
  

}