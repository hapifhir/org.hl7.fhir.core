package org.hl7.fhir.r5.fhirpath;

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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;


public class TypeDetails {
  public class ProfiledTypeSorter implements Comparator<ProfiledType> {

    @Override
    public int compare(ProfiledType o1, ProfiledType o2) {
      return o1.uri.compareTo(o2.uri);
    }

  }

  public static final String FHIR_NS = "http://hl7.org/fhir/StructureDefinition/";
  public static final String FP_NS = "http://hl7.org/fhirpath/";
  public static final String FP_String = "http://hl7.org/fhirpath/System.String";
  public static final String FP_Boolean = "http://hl7.org/fhirpath/System.Boolean";
  public static final String FP_Integer = "http://hl7.org/fhirpath/System.Integer";
  public static final String FP_Decimal = "http://hl7.org/fhirpath/System.Decimal";
  public static final String FP_Quantity = "http://hl7.org/fhirpath/System.Quantity";
  public static final String FP_DateTime = "http://hl7.org/fhirpath/System.DateTime";
  public static final String FP_Time = "http://hl7.org/fhirpath/System.Time";
  public static final String FP_SimpleTypeInfo = "http://hl7.org/fhirpath/System.SimpleTypeInfo";
  public static final String FP_ClassInfo = "http://hl7.org/fhirpath/System.ClassInfo";
  public static final Set<String> FP_NUMBERS = new HashSet<String>(Arrays.asList(FP_Integer, FP_Decimal));

  public static class ProfiledType {
    @Override
    public String toString() {
      return uri;
    }

    private String uri;
    private List<String> profiles; // or, not and
    private List<ElementDefinitionBindingComponent> bindings;
    
    public ProfiledType(String n) {
      uri = ns(n); 
      if (uri.equals("http://hl7.org/fhir/StructureDefinition/CDA")) {
        System.out.println("!"); // #FIXME
      }
    }
    
    public String getUri() {
      return uri;
    }

    public boolean hasProfiles() {
      return profiles != null && profiles.size() > 0;
    }
    public List<String> getProfiles() {
      return profiles;
    }

    public boolean hasBindings() {
      return bindings != null && bindings.size() > 0;
    }
    public List<ElementDefinitionBindingComponent> getBindings() {
      return bindings;
    }

    public static String ns(String n) {
      return Utilities.isAbsoluteUrl(n) ? n : FHIR_NS+n;
    }

    public void addProfile(String profile) {
      if (profiles == null)
        profiles = new ArrayList<String>();
      profiles.add(profile);
    }

    public void addBinding(ElementDefinitionBindingComponent binding) {
      bindings = new ArrayList<ElementDefinitionBindingComponent>();
      bindings.add(binding);
    }

    public boolean hasBinding(ElementDefinitionBindingComponent b) {
      return false; // todo: do we need to do this?
    }

    public void addProfiles(List<CanonicalType> list) {
      if (profiles == null)
        profiles = new ArrayList<String>();
      for (UriType u : list)
        profiles.add(u.getValue());
    }
    public boolean isSystemType() {
      return uri.startsWith(FP_NS);
    }

    public String describeMin() {
      if (uri.startsWith(FP_NS)) {
        return "System."+uri.substring(FP_NS.length());
      }
      if (uri.startsWith("http://hl7.org/fhir/StructureDefinition/")) {
        return "FHIR."+uri.substring("http://hl7.org/fhir/StructureDefinition/".length());
      }
      return uri;
    }
    
  }
  
  private List<ProfiledType> types = new ArrayList<ProfiledType>();
  private CollectionStatus collectionStatus;
  private Set<String> targets; // or, not and, canonical urls
  private boolean choice;

  public TypeDetails(CollectionStatus collectionStatus, String... names) {
    super();
    this.collectionStatus = collectionStatus;
    for (String n : names) {
      this.types.add(new ProfiledType(n));
    }
  }
  public TypeDetails(CollectionStatus collectionStatus, Set<String> names) {
    super();
    this.collectionStatus = collectionStatus;
    for (String n : names) {
      addType(new ProfiledType(n));
    }
  }
  public TypeDetails(CollectionStatus collectionStatus, ProfiledType pt) {
    super();
    this.collectionStatus = collectionStatus;
    this.types.add(pt);
  }
  
  private TypeDetails() {
  }
  
  public String addType(String n) {
    ProfiledType pt = new ProfiledType(n);
    String res = pt.uri;
    addType(pt);
    return res;
  }
  public String addType(String n, String p) {
    ProfiledType pt = new ProfiledType(n);
    pt.addProfile(p);
    String res = pt.uri;
    addType(pt);
    return res;
  }
  
  public void addType(ProfiledType pt) {
    for (ProfiledType et : types) {
      if (et.uri.equals(pt.uri)) {
        if (pt.profiles != null) {
          for (String p : pt.profiles) {
            if (et.profiles == null)
              et.profiles = new ArrayList<String>();
            if (!et.profiles.contains(p))
              et.profiles.add(p);
          }
        }
        if (pt.bindings != null) {
          for (ElementDefinitionBindingComponent b : pt.bindings) {
            if (et.bindings == null)
              et.bindings = new ArrayList<ElementDefinitionBindingComponent>();
            if (!et.hasBinding(b))
              et.bindings.add(b);
          }
        }
        return;
      }
    }
    types.add(pt); 
  }

  public void addType(CollectionStatus status, ProfiledType pt) {
    addType(pt);
    if (collectionStatus == null) {
      collectionStatus = status;      
    } else {
      switch (status) {
      case ORDERED:
        if (collectionStatus == CollectionStatus.SINGLETON) {
          collectionStatus = status;
        }
        break;
      case SINGLETON:
        break;
      case UNORDERED:
        collectionStatus = status;
        break;
      default:
        break;    
      }
    }
  }

  public void addTypes(Collection<String> names) {
    for (String n : names) 
      addType(new ProfiledType(n));
  }
  
  public boolean hasType(IWorkerContext context, String... tn) {
    for (String n: tn) {
      String t = ProfiledType.ns(n);
      if (typesContains(t))
        return true;
      if (Utilities.existsInList(n, "boolean", "string", "integer", "decimal", "Quantity", "dateTime", "time", "ClassInfo", "SimpleTypeInfo")) {
        t = FP_NS+"System."+Utilities.capitalize(n);
        if (typesContains(t)) {
          return true;
        }
      }
      t = ProfiledType.ns(n);
      StructureDefinition sd = context.fetchTypeDefinition(t);
      if (sd != null && sd.getKind() != StructureDefinitionKind.LOGICAL && Utilities.existsInList(sd.getType(), "boolean", "string", "integer", "decimal", "Quantity", "dateTime", "time")) {
        t = FP_NS+"System."+Utilities.capitalize(sd.getType());
        if (typesContains(t)) {
          return true;
        }
      }
    }
    for (String n: tn) {
      String id = n.contains("#") ? n.substring(0, n.indexOf("#")) : n;
      String tail = null;
      if (n.contains("#")) {
        tail = n.substring( n.indexOf("#")+1);
        tail = tail.substring(tail.indexOf("."));
      }
      List<StructureDefinition> list = new ArrayList<>();
      if (!Utilities.isAbsoluteUrl(n)) {
        list.addAll(context.fetchTypeDefinitions(n));
      } else {
        String t = ProfiledType.ns(n);
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, t);
        if (sd != null) {
          list.add(sd);
        }
      }
      for (int i = 0; i < list.size(); i++) {
        StructureDefinition sd = list.get(i);
        while (sd != null) {
          if (tail == null && typesContains(sd.getUrl()))
            return true;
          if (tail == null && getSystemType(sd.getUrl()) != null && typesContains(getSystemType(sd.getUrl())))
            return true;
          if (tail != null && typesContains(sd.getUrl()+"#"+sd.getType()+tail))
            return true;
          if ("http://hl7.org/fhir/StructureDefinition/string".equals(sd.getUrl()) && typesContains(FP_String)) {
            return true; // this is work around for R3
          }
          if (sd.hasBaseDefinition()) {
            if (sd.getType().equals("uri"))
              sd = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/string");
            else
              sd = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
          } else {
            sd = null;
          }
        }
      }
    }
    return false;
  }
  
  private String getSystemType(String url) {
    if (url.startsWith("http://hl7.org/fhir/StructureDefinition/")) {
      String code = url.substring(40);
      if (Utilities.existsInList(code, "string",  "boolean", "integer", "decimal", "dateTime", "time", "Quantity"))
        return FP_NS+"System.."+Utilities.capitalize(code);
    }
    return null;
  }
  
  private boolean typesContains(String t) {
    for (ProfiledType pt : types)
      if (pt.uri.equals(t))
        return true;
    return false;
  }
  
  public void update(TypeDetails source) {
    for (ProfiledType pt : source.types)
      addType(pt);
    if (collectionStatus == null || collectionStatus == CollectionStatus.SINGLETON)
      collectionStatus = source.collectionStatus;
    else if (source.collectionStatus == CollectionStatus.UNORDERED)
      collectionStatus = source.collectionStatus;
    else
      collectionStatus = CollectionStatus.ORDERED;
    if (source.targets != null) {
      if (targets == null) {
        targets = new HashSet<>();
      }
      targets.addAll(source.targets);
    }
    if (source.isChoice()) {
      choice = true;
    }
  }
  
  public TypeDetails union(TypeDetails right) {
    TypeDetails result = new TypeDetails(null);
    if (right.collectionStatus == CollectionStatus.UNORDERED || collectionStatus == CollectionStatus.UNORDERED)
      result.collectionStatus = CollectionStatus.UNORDERED;
    else 
      result.collectionStatus = CollectionStatus.ORDERED;
    for (ProfiledType pt : types)
      result.addType(pt);
    for (ProfiledType pt : right.types)
      result.addType(pt);
    if (targets != null || right.targets != null) {
      result.targets = new HashSet<>();
      if (targets != null) {
        result.targets.addAll(targets);
      }
      if (right.targets != null) {
        result.targets.addAll(right.targets);
      }
    }

    return result;
  }
  
  public TypeDetails intersect(TypeDetails right) {
    TypeDetails result = new TypeDetails(null);
    if (right.collectionStatus == CollectionStatus.UNORDERED || collectionStatus == CollectionStatus.UNORDERED)
      result.collectionStatus = CollectionStatus.UNORDERED;
    else 
      result.collectionStatus = CollectionStatus.ORDERED;
    for (ProfiledType pt : types) {
      boolean found = false;
      for (ProfiledType r : right.types)
        found = found || pt.uri.equals(r.uri);
      if (found)
        result.addType(pt);
    }
    for (ProfiledType pt : right.types)
      result.addType(pt);
    if (targets != null && right.targets != null) {
      result.targets = new HashSet<>();
      for (String s : targets) {
        if (right.targets.contains(s)) {
          result.targets.add(s);
        }
      }
    }

    return result;
  }
  
  public boolean hasNoTypes() {
    return types.isEmpty();
  }
  public Set<String> getTypes() {
    Set<String> res = new HashSet<String>();
    for (ProfiledType pt : types)
      res.add(pt.uri);
    return res;
  }
  public TypeDetails toSingleton() {
    TypeDetails result = new TypeDetails(CollectionStatus.SINGLETON);
    result.types.addAll(types);
    return result;
  }
  public CollectionStatus getCollectionStatus() {
    return collectionStatus;
  }
  
  private boolean hasType(ProfiledType pt) {
    return hasType(pt.uri);
  }
  
  public boolean hasType(String n) {
    String t = ProfiledType.ns(n);
    if (typesContains(t))
      return true;
    if (Utilities.existsInList(n, "boolean", "string", "integer", "decimal", "Quantity", "date", "dateTime", "time", "ClassInfo", "SimpleTypeInfo")) {
      t = FP_NS+"System."+Utilities.capitalize(n);
      if (typesContains(t))
        return true;
    }
    return false;
  }
  
  public boolean hasType(Set<String> tn) {
    for (String n: tn) {
      String t = ProfiledType.ns(n);
      if (typesContains(t))
        return true;
      if (Utilities.existsInList(n, "boolean", "string", "integer", "decimal", "Quantity", "dateTime", "time", "ClassInfo", "SimpleTypeInfo")) {
        t = FP_NS+"System."+Utilities.capitalize(n);
        if (typesContains(t))
          return true;
      }
    }
    return false;
  }
  
  public String describe() {
    return Utilities.sorted(getTypes()).toString();
  }
  
  public String describeMin() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (ProfiledType pt : sortedTypes(types))
      b.append(pt.describeMin());
    return b.toString();
  }
  
  private List<ProfiledType> sortedTypes(List<ProfiledType> types2) {
    List<ProfiledType> list = new ArrayList<>();
    Collections.sort(list, new ProfiledTypeSorter());
    return list;
  }
  
  public String getType() {
    for (ProfiledType pt : types)
      return pt.uri;
    return null;
  }
  
  @Override
  public String toString() {
    return (collectionStatus == null ? collectionStatus.SINGLETON.toString() : collectionStatus.toString()) + getTypes().toString();
  }
  public String getTypeCode() throws DefinitionException {
    if (types.size() != 1)
      throw new DefinitionException("Multiple types? ("+types.toString()+")");
    for (ProfiledType pt : types)
      if (pt.uri.startsWith("http://hl7.org/fhir/StructureDefinition/"))
        return pt.uri.substring(40);
      else
        return pt.uri;
    return null;
  }
  public List<ProfiledType> getProfiledTypes() {
    return types;
  }
  public boolean hasBinding() {
    for (ProfiledType pt : types) {
      if (pt.hasBindings())
        return true;
    }
    return false;
  }
  public ElementDefinitionBindingComponent getBinding() {
    for (ProfiledType pt : types) {
      for (ElementDefinitionBindingComponent b : pt.getBindings())
        return b;
    }
    return null;
  }
 

  public void addTarget(String url) {
    if (targets == null) {
      targets = new HashSet<>();
    }
    targets.add(url);
  }
  public Set<String> getTargets() {
    return targets;
  }
  public boolean typesHaveTargets() {
    for (ProfiledType pt : types) {
      if (Utilities.existsInList(pt.getUri(), "Reference", "CodeableReference", "canonical",  "http://hl7.org/fhir/StructureDefinition/Reference", "http://hl7.org/fhir/StructureDefinition/CodeableReference", "http://hl7.org/fhir/StructureDefinition/canonical")) {
        return true;
      }
    }
    return false;
  }
  public void addTargets(Set<String> src) {
    if (src != null) {
      for (String s : src) {
        addTarget(s);
      }
    }
    
  }
  public TypeDetails copy() {
    TypeDetails td = new TypeDetails();
    td.types.addAll(types);
    td.collectionStatus = collectionStatus;
    if (targets != null ) {
      td.targets = new HashSet<>();
      td.targets.addAll(targets);
    }
    return td;
  }
  
  public boolean matches(TypeDetails other) {
    boolean result = collectionStatus == other.collectionStatus && types.equals(other.types);
    if (targets == null) {
      return result && other.targets == null;
    } else {
      return result && targets.equals(other.targets);
    }
    
  }
  public void addTypes(TypeDetails other) {
    if (other.collectionStatus != CollectionStatus.SINGLETON) {
      if (other.collectionStatus == CollectionStatus.UNORDERED || collectionStatus == CollectionStatus.UNORDERED) {
        collectionStatus = CollectionStatus.UNORDERED;
      } else {
        collectionStatus = CollectionStatus.ORDERED;
      }
    }
    for (ProfiledType pt : other.types) {
      addType(pt);
    }
    if (other.targets != null) {
      if (targets == null) {
        targets = new HashSet<>();
      }
      targets.addAll(other.targets);
    }
  }
  
  public boolean contains(TypeDetails other) {
    // TODO Auto-generated method stub
    if (other.collectionStatus != collectionStatus) {
      return false;
    }
    for (ProfiledType pt : other.types) {
      if (!hasType(pt)) {
        return false;
      }
    }
    return true;
  }
  public static TypeDetails empty() {
    return new TypeDetails(CollectionStatus.SINGLETON);
  }
  public boolean isList() {
    return collectionStatus != null && collectionStatus.isList();
  }
  
  // for SQL-on-FHIR: warnings when .ofType() is not paired with a choice element
  public void setChoice(boolean b) {
    choice = true;
  }
  public boolean isChoice() {
    return choice;
  }
  
}