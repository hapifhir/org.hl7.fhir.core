package org.hl7.fhir.r5.terminologies.utilities;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;

public class ValueSetProcessBase {

  protected IWorkerContext context;
  
  public static class AlternateCodesProcessingRules {
    private boolean all;
    private List<String> uses = new ArrayList<>();
    
    public AlternateCodesProcessingRules(boolean b) {
      all = b;
    }

    private void seeParameter(DataType value) {
      if (value != null) {
        if (value instanceof BooleanType) {
          all = ((BooleanType) value).booleanValue();
          uses.clear();
        } else if (value.isPrimitive()) {
          String s = value.primitiveValue();
          if (!Utilities.noString(s)) {
            uses.add(s);
          }
        }
      }
    }

    public void seeParameters(Parameters pp) {
      for (ParametersParameterComponent p : pp.getParameter()) {
        String name = p.getName();
        if ("includeAlternateCodes".equals(name)) {
          DataType value = p.getValue();
          seeParameter(value);
        }
      }
    }

    public void seeValueSet(ValueSet vs) {
      if (vs != null) {
        for (Extension ext : vs.getCompose().getExtension()) {
          if ("http://hl7.org/fhir/tools/StructureDefinion/valueset-expansion-param".equals(ext.getUrl())) {
            String name = ext.getExtensionString("name");
            Extension value = ext.getExtensionByUrl("value");
            if ("includeAlternateCodes".equals(name) && value != null && value.hasValue()) {
              seeParameter(value.getValue());
            }
          }
        }
      }
    }

    public boolean passes(List<Extension> extensions) {
      if (all) {
        return true;
      }

      for (Extension ext : extensions) {
        if (ToolingExtensions.EXT_CS_ALTERNATE_USE.equals(ext.getUrl())) {
          if (ext.hasValueCoding() && Utilities.existsInList(ext.getValueCoding().getCode(), uses)) {
            return true;
          }
        }
      }
      return false;
    }
  }


  protected List<OperationOutcomeIssueComponent> makeIssue(IssueSeverity level, IssueType type, String location, String message) {
    OperationOutcomeIssueComponent result = new OperationOutcomeIssueComponent();
    switch (level) {
    case ERROR:
      result.setSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR);
      break;
    case FATAL:
      result.setSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL);
      break;
    case INFORMATION:
      result.setSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.INFORMATION);
      break;
    case WARNING:
      result.setSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.WARNING);
      break;
    }
    result.setCode(type);
    result.addLocation(location);
    result.getDetails().setText(message);
    ArrayList<OperationOutcomeIssueComponent> list = new ArrayList<>();
    list.add(result);
    return list;
  }
  
  public void checkCanonical(List<OperationOutcomeIssueComponent> issues, String path, CanonicalResource resource) {
    if (resource != null) {
      StandardsStatus standardsStatus = ToolingExtensions.getStandardsStatus(resource);
      if (standardsStatus == StandardsStatus.DEPRECATED) {
        addToIssues(issues, makeStatusIssue(path, "deprecated", I18nConstants.MSG_DEPRECATED, resource));
      } else if (standardsStatus == StandardsStatus.WITHDRAWN) {
        addToIssues(issues, makeStatusIssue(path, "withdrawn", I18nConstants.MSG_WITHDRAWN, resource));
      } else if (resource.getStatus() == PublicationStatus.RETIRED) {
        addToIssues(issues, makeStatusIssue(path, "retired", I18nConstants.MSG_RETIRED, resource));
      }
    }
  }

  private List<OperationOutcomeIssueComponent> makeStatusIssue(String path, String id, String msg, CanonicalResource resource) {
    List<OperationOutcomeIssueComponent> iss = makeIssue(IssueSeverity.INFORMATION, IssueType.EXPIRED, path, context.formatMessage(msg, resource.getVersionedUrl()));

    // this is a testing hack - see TerminologyServiceTests
    iss.get(0).setUserData("status-msg-name", "warning-"+id);
    iss.get(0).setUserData("status-msg-value", new UriType(resource.getVersionedUrl()));
    
    return iss;
  }
  
  private void addToIssues(List<OperationOutcomeIssueComponent> issues, List<OperationOutcomeIssueComponent> toAdd) {
    for (OperationOutcomeIssueComponent t : toAdd) {
      boolean found = false;
      for (OperationOutcomeIssueComponent i : issues) {
        if (i.getSeverity() == t.getSeverity() && i.getCode() == t.getCode() && i.getDetails().getText().equals(t.getDetails().getText())) { // ignore location
          found = true;
        }
      }
      if (!found) {
        issues.add(t);
      }
    }    
  }

  public void checkCanonical(ValueSetExpansionComponent params, CanonicalResource resource) {
    if (resource != null) {
      StandardsStatus standardsStatus = ToolingExtensions.getStandardsStatus(resource);
      if (standardsStatus == StandardsStatus.DEPRECATED) {
        if (!params.hasParameterValue("warning-deprecated", resource.getVersionedUrl())) {
          params.addParameter("warning-deprecated", new UriType(resource.getVersionedUrl()));
        } 
      } else if (standardsStatus == StandardsStatus.WITHDRAWN) {
        if (!params.hasParameterValue("warning-withdrawn", resource.getVersionedUrl())) {
          params.addParameter("warning-withdrawn", new UriType(resource.getVersionedUrl()));
        } 
      } else if (resource.getStatus() == PublicationStatus.RETIRED) {
        if (!params.hasParameterValue("warning-retired", resource.getVersionedUrl())) {
          params.addParameter("warning-retired", new UriType(resource.getVersionedUrl()));
        } 
      }
    }
  }
            
                         
  protected AlternateCodesProcessingRules altCodeParams = new AlternateCodesProcessingRules(false);
  protected AlternateCodesProcessingRules allAltCodes = new AlternateCodesProcessingRules(true);
}
