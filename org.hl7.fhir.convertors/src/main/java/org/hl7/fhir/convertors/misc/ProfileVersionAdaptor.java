package org.hl7.fhir.convertors.misc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.convertors.misc.ProfileVersionAdaptor.ConversionMessageStatus;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

public class ProfileVersionAdaptor {
  public enum ConversionMessageStatus {
    ERROR, WARNING, NOTE
  }

  public static class ConversionMessage {
    private String message;
    private ConversionMessageStatus status;
    public ConversionMessage(String message, ConversionMessageStatus status) {
      super();
      this.message = message;
      this.status = status;
    }
    public String getMessage() {
      return message;
    }
    public ConversionMessageStatus getStatus() {
      return status;
    } 
  }

  private IWorkerContext sCtxt;
  private IWorkerContext tCtxt;
  private ProfileUtilities tpu;
  private ContextUtilities tcu;

  public ProfileVersionAdaptor(IWorkerContext sourceContext, IWorkerContext targetContext) {
    super();
    this.sCtxt = sourceContext;
    this.tCtxt = targetContext;
    if (VersionUtilities.versionsMatch(sourceContext.getVersion(), targetContext.getVersion())) {
      throw new DefinitionException("Cannot convert profile from "+sourceContext.getVersion()+" to "+targetContext.getVersion());
    } else if (VersionUtilities.compareVersions(sourceContext.getVersion(), targetContext.getVersion()) < 1) {
      throw new DefinitionException("Only converts backwards - cannot do "+sourceContext.getVersion()+" to "+targetContext.getVersion());
    }
    tcu = new ContextUtilities(tCtxt);
    tpu = new ProfileUtilities(tCtxt, null, tcu);
  }

  public StructureDefinition convert(StructureDefinition sd, List<ConversionMessage> log) throws FileNotFoundException, IOException {
    if (sd.getKind() == StructureDefinitionKind.LOGICAL) {
      return convertLogical(sd, log);
    }
    if (sd.getDerivation() != TypeDerivationRule.CONSTRAINT || !"Extension".equals(sd.getType())) {
      return null; // nothing to say right now
    }
    sd = sd.copy();
    convertContext(sd, log);
    if (sd.getContext().isEmpty()) {
      log.clear();
      log.add(new ConversionMessage("There are no valid contexts for this extension", ConversionMessageStatus.WARNING));
      return null; // didn't convert successfully
    }
    sd.setFhirVersion(FHIRVersion.fromCode(tCtxt.getVersion()));

    sd.setSnapshot(null);

    // first pass, targetProfiles
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      for (TypeRefComponent td : ed.getType()) {
        List<CanonicalType> toRemove = new ArrayList<CanonicalType>();
        for (CanonicalType c : td.getTargetProfile()) {
          String tp = getCorrectedProfile(c);
          if (tp == null) {
            log.add(new ConversionMessage("Remove the target profile "+c.getValue()+" from the element "+ed.getIdOrPath(), ConversionMessageStatus.WARNING));
            toRemove.add(c);
          } else if (!tp.equals(c.getValue())) {
            log.add(new ConversionMessage("Change the target profile "+c.getValue()+" to "+tp+" on the element "+ed.getIdOrPath(), ConversionMessageStatus.WARNING));
            c.setValue(tp);
          }
        }
        td.getTargetProfile().removeAll(toRemove);
      }
    }
    // second pass, unsupported primitive data types
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      for (TypeRefComponent tr : ed.getType()) {
        String mappedDT = getMappedDT(tr.getCode());
        if (mappedDT != null) {
          log.add(new ConversionMessage("Map the type "+tr.getCode()+" to "+mappedDT+" on the element "+ed.getIdOrPath(), ConversionMessageStatus.WARNING));
          tr.setCode(mappedDT);
        }
      }
    }

    // third pass, unsupported complex data types
    ElementDefinition lastExt = null;
    ElementDefinition group = null;
    for (int i = 0; i < sd.getDifferential().getElement().size(); i++) {
      ElementDefinition ed = sd.getDifferential().getElement().get(i);
      if (ed.getPath().contains(".value")) {
        if (ed.getType().size() > 1) {
          if (ed.getType().removeIf(tr -> !tcu.isDatatype(tr.getWorkingCode()))) {
            log.add(new ConversionMessage("Remove types from the element "+ed.getIdOrPath(), ConversionMessageStatus.WARNING));
          }
        } else if (ed.getType().size() == 1) {
          TypeRefComponent tr = ed.getTypeFirstRep();
          if (!tcu.isDatatype(tr.getWorkingCode()) || !isValidExtensionType(tr.getWorkingCode())) {
            if (ed.hasBinding()) {
              if (!"CodeableReference".equals(tr.getWorkingCode())) {
                throw new DefinitionException("not handled: Unknown type "+tr.getWorkingCode()+" has a binding");
              }
            }
            ed.getType().clear();
            ed.setMin(0);
            ed.setMax("0");
            lastExt.setDefinition(ed.getDefinition());
            lastExt.setShort(ed.getShort());
            lastExt.setMax("*");
            lastExt.getSlicing().setRules(SlicingRules.OPEN).setOrdered(false).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("url");
            StructureDefinition type = sCtxt.fetchTypeDefinition(tr.getCode());
            if (type == null) {
              throw new DefinitionException("unable to find definition for "+tr.getCode());
            }
            log.add(new ConversionMessage("Replace the type "+tr.getCode()+" with a set of extensions for the content of the type along with the _datatype extension", ConversionMessageStatus.WARNING));
            int insPoint = sd.getDifferential().getElement().indexOf(lastExt);
            int offset = 1;

            // a slice extension for _datatype
            offset = addDatatypeSlice(sd, offset, insPoint, lastExt, tr.getCode());

            // now, a slice extension for each thing in the data type differential
            for (ElementDefinition ted : type.getDifferential().getElement()) {
              if (ted.getPath().contains(".")) { // skip the root
                ElementDefinition base = lastExt;
                int bo = 0;
                int cc = Utilities.charCount(ted.getPath(), '.');
                if (cc > 2) {
                  throw new DefinitionException("type is deeper than 2?");                  
                } else if (cc == 2) {
                  base = group;
                  bo = 2;
                } else {
                  // nothing
                }
                ElementDefinition ned = new ElementDefinition(base.getPath());
                ned.setSliceName(ted.getName());
                ned.setShort(ted.getShort());
                ned.setDefinition(ted.getDefinition());
                ned.setComment(ted.getComment());
                ned.setMin(ted.getMin());
                ned.setMax(ted.getMax());
                offset = addDiffElement(sd, insPoint-bo, offset, ned);
                // set the extensions to 0
                ElementDefinition need = new ElementDefinition(base.getPath()+".extension");
                need.setMax("0");
                offset = addDiffElement(sd, insPoint-bo, offset, need);
                // fix the url 
                ned = new ElementDefinition(base.getPath()+".url");
                ned.setFixed(new UriType(ted.getName()));
                offset = addDiffElement(sd, insPoint-bo, offset, ned);
                // set the value 
                ned = new ElementDefinition(base.getPath()+".value[x]");
                ned.setMin(1);
                offset = addDiffElement(sd, insPoint-bo, offset, ned);
                if (ted.getType().size() == 1 && Utilities.existsInList(ted.getTypeFirstRep().getWorkingCode(), "Element", "BackboneElement")) {
                  need.setMax("*");
                  ned.setMin(0);
                  ned.setMax("0");
                  ned.getType().clear();
                  group = need;
                  group.getSlicing().setRules(SlicingRules.OPEN).setOrdered(false).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("url");
                } else {
                  Set<String> types = new HashSet<>();
                  for (TypeRefComponent ttr : ted.getType()) {
                    TypeRefComponent ntr = checkTypeReference(ttr, types);
                    if (ntr != null) {
                      types.add(ntr.getWorkingCode());
                      ned.addType(ntr);
                    }
                  }
                  if (ned.getType().isEmpty()) {
                    throw new DefinitionException("No types?");
                  }
                  if (ed.hasBinding() && "concept".equals(ted.getName())) {
                    ned.setBinding(ed.getBinding());
                  } else {
                    ned.setBinding(ted.getBinding());
                  }
                }
              }
            }
          }          
        }
      }
      if (ed.getPath().endsWith(".extension")) {
        lastExt = ed;
      }
    }
    if (!log.isEmpty()) {
      if (!sd.hasExtension(ToolingExtensions.EXT_FMM_LEVEL) || ToolingExtensions.readIntegerExtension(sd, ToolingExtensions.EXT_FMM_LEVEL, 0) > 2) {
        ToolingExtensions.setCodeExtension(sd, ToolingExtensions.EXT_FMM_LEVEL, "2");
      }
      ToolingExtensions.setCodeExtension(sd, ToolingExtensions.EXT_STANDARDS_STATUS, "draft");
      ToolingExtensions.setCodeExtension(sd, ToolingExtensions.EXT_STANDARDS_STATUS_REASON, "Extensions that have been modified for "+VersionUtilities.getNameForVersion(tCtxt.getVersion())+" are still draft while real-world experience is collected");
      log.add(new ConversionMessage("Note: Extensions that have been modified for "+VersionUtilities.getNameForVersion(tCtxt.getVersion())+" are still draft while real-world experience is collected", ConversionMessageStatus.NOTE));
    }

    StructureDefinition base = tCtxt.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    tpu.generateSnapshot(base, sd, sd.getUrl(), "http://hl7.org/"+VersionUtilities.getNameForVersion(tCtxt.getVersion())+"/", sd.getName());  
    return sd;
  }

  private StructureDefinition convertLogical(StructureDefinition sdSrc, List<ConversionMessage> log) {
    StructureDefinition sd = sdSrc.copy();
    sd.setFhirVersion(FHIRVersion.fromCode(tCtxt.getVersion()));
    sd.setSnapshot(null);

    // first pass, targetProfiles
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      for (TypeRefComponent td : ed.getType()) {
        List<CanonicalType> toRemove = new ArrayList<CanonicalType>();
        for (CanonicalType c : td.getTargetProfile()) {
          String tp = getCorrectedProfile(c);
          if (tp == null) {
            log.add(new ConversionMessage("Remove the target profile "+c.getValue()+" from the element "+ed.getIdOrPath(), ConversionMessageStatus.WARNING));
            toRemove.add(c);
          } else if (!tp.equals(c.getValue())) {
            log.add(new ConversionMessage("Change the target profile "+c.getValue()+" to "+tp+" on the element "+ed.getIdOrPath(), ConversionMessageStatus.WARNING));
            c.setValue(tp);
          }
        }
        td.getTargetProfile().removeAll(toRemove);
      }
    }
    // second pass, unsupported primitive data types
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      for (TypeRefComponent tr : ed.getType()) {
        String mappedDT = getMappedDT(tr.getCode());
        if (mappedDT != null) {
          log.add(new ConversionMessage("Map the type "+tr.getCode()+" to "+mappedDT+" on the element "+ed.getIdOrPath(), ConversionMessageStatus.WARNING));
          tr.setCode(mappedDT);
        }
      }
    }

    // third pass, unsupported complex data types
    for (int i = 0; i < sd.getDifferential().getElement().size(); i++) {
      ElementDefinition ed = sd.getDifferential().getElement().get(i);
      if (ed.getType().size() > 1) {
        if (ed.getType().removeIf(tr -> !tcu.isDatatype(tr.getWorkingCode()))) {
          log.add(new ConversionMessage("Remove types from the element " + ed.getIdOrPath(), ConversionMessageStatus.WARNING));
        }
      } else if (ed.getType().size() == 1) {
        TypeRefComponent tr = ed.getTypeFirstRep();
        if (!tcu.isDatatype(tr.getWorkingCode()) && !isValidLogicalType(tr.getWorkingCode())) {
          log.add(new ConversionMessage("Illegal type "+tr.getWorkingCode(), ConversionMessageStatus.ERROR));
          return null;
        }
      }
    }

    if (!log.isEmpty()) {
      if (!sd.hasExtension(ToolingExtensions.EXT_FMM_LEVEL) || ToolingExtensions.readIntegerExtension(sd, ToolingExtensions.EXT_FMM_LEVEL, 0) > 2) {
        ToolingExtensions.setCodeExtension(sd, ToolingExtensions.EXT_FMM_LEVEL, "2");
      }
      ToolingExtensions.setCodeExtension(sd, ToolingExtensions.EXT_STANDARDS_STATUS, "draft");
      ToolingExtensions.setCodeExtension(sd, ToolingExtensions.EXT_STANDARDS_STATUS_REASON, "Logical Models that have been modified for "+VersionUtilities.getNameForVersion(tCtxt.getVersion())+" are still draft while real-world experience is collected");
      log.add(new ConversionMessage("Note: Logical Models that have been modified for "+VersionUtilities.getNameForVersion(tCtxt.getVersion())+" are still draft while real-world experience is collected", ConversionMessageStatus.NOTE));
    }

    StructureDefinition base = tCtxt.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    if (base == null) {
      base = sCtxt.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    }
    if (base == null) {
      throw new FHIRException("Unable to find base for Logical Model from "+sd.getBaseDefinition());
    }
    tpu.generateSnapshot(base, sd, sd.getUrl(), "http://hl7.org/"+VersionUtilities.getNameForVersion(tCtxt.getVersion())+"/", sd.getName());
    return sd;
  }

  private boolean isValidLogicalType(String code) {
    StructureDefinition sd = tCtxt.fetchTypeDefinition(code);
    if (sd != null) {
      return true;
    }
    sd = sCtxt.fetchTypeDefinition(code);
    if (sd != null && !sd.getSourcePackage().isCore()) {
      return true;
    }
    return false;
  }

  private int addDatatypeSlice(StructureDefinition sd, int offset, int insPoint, ElementDefinition base, String type) {
    ElementDefinition ned = new ElementDefinition(base.getPath());
    ned.setSliceName("_datatype");
    ned.setShort("DataType name '"+type+"' from "+VersionUtilities.getNameForVersion(sCtxt.getVersion()));
    ned.setDefinition(ned.getShort());
    ned.setMin(1);
    ned.setMax("1");
    ned.addType().setCode("Extension").addProfile("http://hl7.org/fhir/StructureDefinition/_datatype");
    offset = addDiffElement(sd, insPoint, offset, ned);
    //    // set the extensions to 0
    //    ElementDefinition need = new ElementDefinition(base.getPath()+".extension");
    //    need.setMax("0");
    //    offset = addDiffElement(sd, insPoint, offset, need);
    //    // fix the url 
    //    ned = new ElementDefinition(base.getPath()+".url");
    //    ned.setFixed(new UriType("http://hl7.org/fhir/StructureDefinition/_datatype"));
    //    offset = addDiffElement(sd, insPoint, offset, ned);
    // set the value 
    ned = new ElementDefinition(base.getPath()+".value[x]");
    ned.setMin(1);
    offset = addDiffElement(sd, insPoint, offset, ned);
    ned.addType().setCode("string");
    ned.setFixed(new StringType(type));
    return offset;
  }

  private int addDiffElement(StructureDefinition sd, int insPoint, int offset, ElementDefinition ned) {
    sd.getDifferential().getElement().add(insPoint+offset, ned);
    offset++;
    return offset;
  }

  private boolean isValidExtensionType(String type) {
    StructureDefinition extDef = tCtxt.fetchTypeDefinition("Extension");
    ElementDefinition ed = extDef.getSnapshot().getElementByPath("Extension.value");
    for (TypeRefComponent tr : ed.getType()) {
      if (type.equals(tr.getCode())) {
        return true;
      }
    }
    return false;
  }

  private TypeRefComponent checkTypeReference(TypeRefComponent tr, Set<String> types) {
    String dt = getMappedDT(tr.getCode());
    if (dt != null) {
      if (types.contains(dt)) {
        return null;
      } else {
        return tr.copy().setCode(dt);
      }
    } else if (tcu.isDatatype(tr.getWorkingCode())) {
      return tr.copy();
    } else {
      return null;
    }
  }

  private String getCorrectedProfile(CanonicalType c) {
    StructureDefinition sd = tCtxt.fetchResource(StructureDefinition.class, c.getValue());
    if (sd != null) {
      return c.getValue();
    }
    // or it might be something defined in the IG or it's dependencies
    sd = sCtxt.fetchResource(StructureDefinition.class, c.getValue());
    if (sd != null && !sd.getSourcePackage().isCore()) {
      return c.getValue();
    }
    return null;
  }

  private String getMappedDT(String code) {
    if (VersionUtilities.isR5Plus(tCtxt.getVersion())) {
      return code;
    }
    if (VersionUtilities.isR4Plus(tCtxt.getVersion())) {
      switch (code) {
      case "integer64" : return "version";
      default:
        return null;
      }
    }
    if (VersionUtilities.isR3Ver(tCtxt.getVersion())) {
      switch (code) {
      case "integer64" : return "string";
      case "canonical" : return "uri";
      case "url" : return "uri";
      default:
        return null;
      }
    }
    return null;
  }

  public void convertContext(StructureDefinition sd, List<ConversionMessage> log) {
    List<StructureDefinitionContextComponent> toRemove = new ArrayList<>();
    for (StructureDefinitionContextComponent ctxt : sd.getContext()) {
      if (ctxt.getType() != null) {
        switch (ctxt.getType()) {
        case ELEMENT:
          String np = adaptPath(ctxt.getExpression());
          if (np == null) {
            log.add(new ConversionMessage("Remove the extension context "+ctxt.getExpression(), ConversionMessageStatus.WARNING));
            toRemove.add(ctxt);
          } else if (!np.equals(ctxt.getExpression())) {
            log.add(new ConversionMessage("Adjust the extension context "+ctxt.getExpression()+" to "+np, ConversionMessageStatus.WARNING));
            ctxt.setExpression(np);
          }
          break;
        case EXTENSION:
          // nothing. for now
          break;
        case FHIRPATH:
          // nothing. for now ?
          break;
        case NULL:
          break;
        default:
          break;
        }
      }
    }
    sd.getContext().removeAll(toRemove);
  }

  private String adaptPath(String path) {
    String base = path.contains(".") ? path.substring(0, path.indexOf(".")) : path;
    StructureDefinition sd = tCtxt.fetchTypeDefinition(base);
    if (sd == null) {
      StructureDefinition ssd = sCtxt.fetchTypeDefinition(base);
      if (ssd != null && ssd.getKind() == StructureDefinitionKind.RESOURCE) {
        return "Basic";
      } else if (ssd != null && ssd.getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        return null;
      } else {
        return null;
      }
    } else {
      ElementDefinition ed = sd.getSnapshot().getElementByPath(base);
      if (ed == null) {
        return null;
      } else {
        return path;
      }
    }
  }

  public SearchParameter convert(SearchParameter resource, List<ConversionMessage> log) {
    SearchParameter res = resource.copy();
    // todo: translate resource types
    res.getBase().removeIf(t -> { 
      String rt = t.asStringValue();
      boolean r = !tcu.isResource(rt);
      if (r) {
        log.add(new ConversionMessage("Remove search base "+rt, ConversionMessageStatus.WARNING));
      }
      return r;
    }
        );
    return res;
  }

}
