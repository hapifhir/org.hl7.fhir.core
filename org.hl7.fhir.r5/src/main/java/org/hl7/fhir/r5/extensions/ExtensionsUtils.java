package org.hl7.fhir.r5.extensions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BackboneElement;
import org.hl7.fhir.r5.model.BackboneType;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.Utilities;

public class ExtensionsUtils {

  private static Extension setExtensionE(Element context, String url, DataType value) {
    for (Extension ext : context.getExtension()) {
      if (ext.getUrl().equals(url)) {
        return ext.setValue(value);        
      }
    }
    return context.addExtension().setUrl(url).setValue(value);
  }

  private static Extension setExtensionBE(BackboneElement context, boolean mod, String url, DataType value) {
    if (mod) {
      for (Extension ext : context.getModifierExtension()) {
        if (ext.getUrl().equals(url)) {
          return ext.setValue(value);        
        }
      }
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      return setExtensionE(context, url, value);
    }
  }

  private static Extension setExtensionBT(BackboneType context, boolean mod, String url, DataType value) {
    if (mod) {
      for (Extension ext : context.getModifierExtension()) {
        if (ext.getUrl().equals(url)) {
          return ext.setValue(value);        
        }
      } 
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      return setExtensionE(context, url, value);
    }
  }  

  private static Extension setExtensionR(DomainResource context, boolean mod, String url, DataType value) {
    if (mod) {
      for (Extension ext : context.getModifierExtension()) {
        if (ext.getUrl().equals(url)) {
          return ext.setValue(value);        
        }
      }
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      for (Extension ext : context.getExtension()) {
        if (ext.getUrl().equals(url)) {
          return ext.setValue(value);        
        }
      }
      return context.addExtension().setUrl(url).setValue(value);
    }
  }

  public static Extension setExtension(Base context, String url, DataType value) {
    boolean mod = ExtensionConstants.isModifier(url);
    if (context instanceof BackboneElement) {
      return setExtensionBE((BackboneElement) context, mod, url, value);
    } else if (mod && context instanceof BackboneType) {
      return setExtensionBT((BackboneType) context, mod, url, value);
    } else if (context instanceof Element) {
      if (mod) {
        throw new FHIRException("Can't use a modifier extension on "+context.getClass().getName());
      } else {
        return setExtensionE((Element) context, url, value);
      }
    } else if (context instanceof DomainResource) {
      return setExtensionR((DomainResource) context, mod, url, value);
    } else {
      throw new FHIRException("Can't use an extension on "+context.getClass().getName());
    }
  }


  private static Extension addExtensionE(Element context, String url, DataType value) {
    return context.addExtension().setValue(value);
  }

  private static Extension addExtensionBE(BackboneElement context, boolean mod, String url, DataType value) {
    if (mod) {
      return context.addModifierExtension().setValue(value);
    } else {
      return setExtensionE(context, url, value);
    }
  }

  private static Extension addExtensionBT(BackboneType context, boolean mod, String url, DataType value) {
    if (mod) {
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      return setExtensionE(context, url, value);
    }
  }  

  private static Extension addExtensionR(DomainResource context, boolean mod, String url, DataType value) {
    if (mod) {
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      return context.addExtension().setUrl(url).setValue(value);
    }
  }

  public static Extension addExtension(Base context, String url, DataType value) {
    boolean mod = ExtensionConstants.isModifier(url);
    if (context instanceof BackboneElement) {
      return addExtensionBE((BackboneElement) context, mod, url, value);
    } else if (mod && context instanceof BackboneType) {
      return addExtensionBT((BackboneType) context, mod, url, value);
    } else if (context instanceof Element) {
      if (mod) {
        throw new FHIRException("Can't use a modifier extension on "+context.getClass().getName());
      } else {
        return addExtensionE((Element) context, url, value);
      }
    } else if (context instanceof DomainResource) {
      return addExtensionR((DomainResource) context, mod, url, value);
    } else {
      throw new FHIRException("Can't use an extension on "+context.getClass().getName());
    }
  }

  private static List<Extension> getAllExtensions(Base context, String url) {
    List<Extension> list = new ArrayList<>();
    boolean mod = ExtensionConstants.isModifier(url);
    if (mod) {
      if (context instanceof BackboneElement) {
        list.addAll(((BackboneElement) context).getModifierExtension());
      }
      if (context instanceof BackboneType) {
        list.addAll(((BackboneElement) context).getModifierExtension());
      }
      if (context instanceof DomainResource) {
        list.addAll(((DomainResource) context).getModifierExtension());
      }
    } else {
      if (context instanceof Element) {
        list.addAll(((Element) context).getExtension());
      }
      if (context instanceof DomainResource) {
        list.addAll(((DomainResource) context).getExtension());
      }
    }
    return list;
  }

  public static <T extends DataType> T getExtension(Class<T> class_, Base context, String url) {
    boolean found = false;
    T result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValue() && class_.isInstance(ext.getValue())) {
          found = true;
          result = (T) ext.getValue();
        }
      }
    }
    return result;    
  }

  public static <T extends DataType> List<T> getExtensionList(Class<T> class_, Base context, String url) {
    List<T> result = new ArrayList<>();
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (ext.hasValue() && class_.isInstance(ext.getValue())) {
          result.add((T) ext.getValue());
        }
      }
    }
    return result;    
  }

  public static String getExtensionString(Base context, String url) {
    boolean found = false;
    String result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValue() && ext.getValue().isPrimitive()) {
          found = true;
          result = ext.getValue().primitiveValue();
        }
      }
    }
    return result;  
  }

  public static Boolean getExtensionBoolean(Base context, String url) {
    boolean found = false;
    Boolean result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValueBooleanType()) {
          found = true;
          result = ext.getValueBooleanType().getValue();
        }
      }
    }
    return result;  
  }

  public static Integer getExtensionInt(Base context, String url) {
    boolean found = false;
    Integer result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValueIntegerType()) {
          found = true;
          result = ext.getValueIntegerType().getValue();
        }
      }
    }
    return result;  
  }

  public static BigDecimal getExtensionFloat(Base context, String url) {
    boolean found = false;
    BigDecimal result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValueIntegerType()) {
          found = true;
          result = ext.getValueDecimalType().getValue();
        }
      }
    }
    return result; 
  }

  public static List<String> getExtensionStringList(Base context, String url) {
    List<String> result = new ArrayList<>();
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (ext.hasValue() && ext.getValue().isPrimitive()) {
          result.add(ext.getValue().primitiveValue());
        }
      }
    }
    return result; 
  }

  public static List<Integer> getExtensionIntList(Base context, String url) {
    List<Integer> result = new ArrayList<>();
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (ext.hasValueIntegerType()) {
          result.add(ext.getValueIntegerType().getValue());
        }
      }
    }
    return result; 
  }
  
  public static boolean stripExtensions(Element element, String... exceptions) {
    return stripExtensions(element, Utilities.strings(exceptions));
  }
  
  public static boolean stripExtensions(Element element, List<String> exceptions) {
    boolean res = element.getExtension().removeIf(ex -> !exceptions.contains(ex.getUrl()));
    if (element instanceof BackboneElement) {
      res = ((BackboneElement) element).getModifierExtension().removeIf(ex -> !exceptions.contains(ex.getUrl())) || res;      
    }
    if (element instanceof BackboneElement) {
      res = ((BackboneElement) element).getModifierExtension().removeIf(ex -> !exceptions.contains(ex.getUrl())) || res;      
    }
    for (Property p : element.children()) {
      for (Base v : p.getValues()) {
        if (v instanceof Element) {
          res = stripExtensions((Element) v, exceptions) || res;
        } else if (v instanceof Element) {
          res = stripExtensions((Resource) v, exceptions) || res;
        }
      }
    }
    return res;
  }

  public static boolean stripExtensions(Resource resource, String... exceptions) {
    return stripExtensions(resource, Utilities.strings(exceptions));
  }
  
  public static boolean stripExtensions(Resource resource, List<String> exceptions) {
    boolean res = false;
    if (resource instanceof DomainResource) {
      res = ((DomainResource) resource).getExtension().removeIf(ex -> !exceptions.contains(ex.getUrl())) ||
            ((DomainResource) resource).getModifierExtension().removeIf(ex -> !exceptions.contains(ex.getUrl()));      
    }
    for (Property p : resource.children()) {
      for (Base v : p.getValues()) {
        if (v instanceof Element) {
          res = stripExtensions((Element) v, exceptions) || res;
        } else if (v instanceof Element) {
          res = stripExtensions((Resource) v, exceptions) || res;
        }
      }
    }
    return res;
  }

  public static void copyExtensions(List<Extension> source, List<Extension> dest, String... urls) {
    if (source != null && dest != null) {
      for (Extension ex : source) {
        if (Utilities.existsInList(ex.getUrl(), urls)) {
          dest.add(ex.copy());
        }
      }
    }
  }



  public static DataType getExtensionValue(List<Extension> extensions, String url) {
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url)) {
        return ex.getValue();
      }
    }
    return null;
  }
  

  public static String getExtensionString(List<Extension> extensions, String url) {
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url)) {
        return ex.getValue().primitiveValue();
      }
    }
    return null;
  }
  


  public static Integer getExtensionInteger(List<Extension> extensions, String url) {
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url) && ex.hasValueIntegerType()) {
        return ex.getValueIntegerType().getValue();
      }
    }
    return null;
  }
  
  public static boolean hasExtension(List<Extension> extensions, String url) {
    if (extensions == null) {
      return false;
    }
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url)) {
        return true;
      }
    }
    return false;
  }
}
