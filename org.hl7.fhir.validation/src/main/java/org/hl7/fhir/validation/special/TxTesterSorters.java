package org.hl7.fhir.validation.special;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.Parameters.ParametersParameterComponent;
import org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent;
import org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent;
import org.hl7.fhir.model.core.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.TerminologyCapabilities;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.model.core.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.model.core.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.ValueSet.ConceptPropertyComponent;
import org.hl7.fhir.model.core.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionPropertyComponent;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.validation.special.TxTesterSorters.CodeTypeSorter;

public class TxTesterSorters {

  public static void sortParameters(Parameters po) {
    Collections.sort(po.getParameterList(), new TxTesterSorters.ParameterSorter());
    for (ParametersParameterComponent p : po.getParameterList()) {
      if (p.getResource() != null && p.getResource() instanceof OperationOutcome) {
        Collections.sort(((OperationOutcome) p.getResource()).getIssueList(), new TxTesterSorters.OperationIssueSorter());
      }
      if (p.getResource() != null && p.getResource() instanceof Parameters) {
        sortParameters(((Parameters) p.getResource()));
      }
      if ("message".equals(p.getName()) && p.hasValuePrimitive()) {
        String pv = p.getValue().primitiveValue();
        if (pv.contains("; ")) {
          List<String> bits = new ArrayList<>();
          @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
          //single literal character split
          String[] pvParts = pv.split("\\; ");
          for (String s : pvParts) {
            bits.add(s);
          }
          Collections.sort(bits);
          p.setValue(new StringType(CommaSeparatedStringBuilder.join("; ", bits)));
        }
      }
    }
  }


  public static void sortOperationOutcome(OperationOutcome oo) {
    Collections.sort(oo.getIssueList(), new TxTesterSorters.OperationIssueSorter());
  }
  
  public static void sortValueSet(ValueSet vs) {
    Collections.sort(vs.getExtension(), new TxTesterSorters.ExtensionSorter());
    if (vs.hasExpansion()) {
      Collections.sort(vs.getExpansion().getParameterList(), new TxTesterSorters.ExpParameterSorter());
      Collections.sort(vs.getExpansion().getPropertyList(), new TxTesterSorters.PropertyDefnSorter());
      Collections.sort(vs.getExpansion().getExtensionList(), new TxTesterSorters.ExtensionSorter());
      Collections.sort(vs.getExpansion().getContainsList(), new TxTesterSorters.ContainsSorter());
      for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContainsList()) {
        sortContainsFeatures(cc);
      }
    }
  }

  public static void sortContainsFeatures(ValueSetExpansionContainsComponent cc) {
    Collections.sort(cc.getContainsList(), new TxTesterSorters.ContainsSorter());
    Collections.sort(cc.getExtensionList(), new TxTesterSorters.ExtensionSorter());
    Collections.sort(cc.getDesignationList(), new TxTesterSorters.DesignationSorter());
    Collections.sort(cc.getPropertyList(), new TxTesterSorters.PropertyValueSorter());
    for (ValueSetExpansionContainsComponent c : cc.getContainsList()) {
      sortContainsFeatures(c);
    }
  }

  public static class OperationIssueSorter implements Comparator<OperationOutcomeIssueComponent> {

    @Override
    public int compare(OperationOutcomeIssueComponent o1, OperationOutcomeIssueComponent o2) {
      String s1 = o1.hasSeverity() ? o1.getSeverity().toCode() : "";
      String s2 = o2.hasSeverity() ? o2.getSeverity().toCode() : "";
      int ret = s1.compareTo(s2);
      if (ret == 0) {
        s1 = o1.hasCode() ? o1.getCode().toCode() : "";
        s2 = o2.hasCode() ? o2.getCode().toCode() : "";
        ret = s1.compareTo(s2);
        if (ret == 0) {
          s1 = o1.hasExpression() ? o1.getExpressionList().get(0).primitiveValue() : "";
          s2 = o2.hasExpression() ? o2.getExpressionList().get(0).primitiveValue() : "";
          ret = s1.compareTo(s2);
          if (ret == 0) {
            s1 = o1.getDetails().hasText() ? o1.getDetails().getText() : "";
            s2 = o2.getDetails().hasText() ? o2.getDetails().getText() : "";
            ret = s1.compareTo(s2);            
          }
        }
      }
      return ret;
    }
  }

  public static class DesignationSorter implements Comparator<ConceptReferenceDesignationComponent> {

    @Override
    public int compare(ConceptReferenceDesignationComponent o1, ConceptReferenceDesignationComponent o2) {
      if (o1.hasLanguage() && o2.hasLanguage()) {
        return o1.getLanguage().compareTo(o2.getLanguage());
      } else {
        return o1.getValue().compareTo(o2.getValue());
      }
    }

  }

  public static class PropertyDefnSorter implements Comparator<ValueSetExpansionPropertyComponent> {

    @Override
    public int compare(ValueSetExpansionPropertyComponent o1, ValueSetExpansionPropertyComponent o2) {
      int i;
      if (o1.getUri() == null || o2.getUri() == null) {
        if (o1.getUri() == null && o2.getUri() == null) {
          i = 0;
        } else if (o1.getUri() == null) {
          i = -1;
        } else {
          i = 1;
        }
      } else {
        i = o1.getUri().compareTo(o2.getUri());
      }
      if (i == 0) {
        return o1.getCode().compareTo(o2.getCode());
      } else {
        return i;
      }
    }
  }

  public static class ExtensionSorter implements Comparator<Extension> {

    @Override
    public int compare(Extension o1, Extension o2) {
      Collections.sort(o1.getExtension(), new ExtensionSorter());
      Collections.sort(o2.getExtension(), new ExtensionSorter());
      return o1.getUrl().compareTo(o2.getUrl());
    }

  }
  public static class PropertyValueSorter implements Comparator<ConceptPropertyComponent> {

    @Override
    public int compare(ConceptPropertyComponent o1, ConceptPropertyComponent o2) {
      return o1.getCode().compareTo(o2.getCode());
    }

  }
  

  public static class ContainsSorter implements Comparator<ValueSetExpansionContainsComponent> {

    @Override
    public int compare(ValueSetExpansionContainsComponent o1, ValueSetExpansionContainsComponent o2) {
      return o1.getCode().compareTo(o2.getCode());
    }

  }


  public static class ExpParameterSorter implements Comparator<ValueSetExpansionParameterComponent> {

    @Override
    public int compare(ValueSetExpansionParameterComponent o1, ValueSetExpansionParameterComponent o2) {
      Collections.sort(o1.getExtension(), new ExtensionSorter());
      Collections.sort(o2.getExtension(), new ExtensionSorter());
      int res = o1.getName().compareTo(o2.getName());
      if (res == 0) {
        res = o1.getValue().primitiveValue().compareTo(o2.getValue().primitiveValue());
      }
      return res;
    }
  }
  
  
  public static class ParameterSorter implements Comparator<ParametersParameterComponent> {

    @Override
    public int compare(ParametersParameterComponent o1, ParametersParameterComponent o2) {
      Collections.sort(o1.getExtension(), new ExtensionSorter());
      Collections.sort(o2.getExtension(), new ExtensionSorter());
      Collections.sort(o1.getPartList(), new ParameterSorter());
      Collections.sort(o2.getPartList(), new ParameterSorter());
      if (o1.getName().equals(o2.getName()) && o1.getName().equals("property")) {
        String code1 = o1.getPart("code").getValue().primitiveValue().toLowerCase();
        String code2 = o2.getPart("code").getValue().primitiveValue().toLowerCase();
        if (code1 != null && code2 != null && !code1.equals(code2)) {
          return code1.compareTo(code2);          
        }           
        String v1 = o1.getPart("value") != null && o1.getPart("value").getValue().hasPrimitiveValue() ? o1.getPart("value").getValue().primitiveValue().toLowerCase() : null;
        String v2 = o2.getPart("value") != null && o2.getPart("value").getValue().hasPrimitiveValue() ? o2.getPart("value").getValue().primitiveValue().toLowerCase() : null;
        if (v1 != null && v2 != null && !v1.equals(v2)) {
          return v1.compareTo(v2);          
        }
      }
      if (o1.getName().equals(o2.getName()) && o1.getName().equals("designation")) {
        String code1 = o1.hasPart("language") && o1.getPart("language").hasValue() && o1.getPart("language").getValue().primitiveValue() != null ? o1.getPart("language").getValue().primitiveValue().toLowerCase() : "";
        String code2 = o2.hasPart("language") && o2.getPart("language").hasValue() && o2.getPart("language").getValue().primitiveValue() != null ? o2.getPart("language").getValue().primitiveValue().toLowerCase() : "";
        if (code1 != null && code2 != null && !code1.equals(code2)) { 
          return code1.compareTo(code2);          
        }           
        String v1 = o1.getPart("value") != null && o1.getPart("value").hasPrimitiveValue() ? o1.getPart("value").getValue().primitiveValue().toLowerCase() : null;
        String v2 = o2.getPart("value") != null && o2.getPart("value").hasPrimitiveValue() ? o2.getPart("value").getValue().primitiveValue().toLowerCase() : null;
        if (v1 != null && v2 != null && !v1.equals(v2)) {
          return v1.compareTo(v2);          
        }           
      }
      return o1.getName().compareTo(o2.getName());
    }

  }

  public static void sortCapStmt(CapabilityStatement cs) {
    Collections.sort(cs.getFormatList(), new CodeTypeSorter());
    Collections.sort(cs.getInstantiatesList(), new CanonicalTypeSorter());
    Collections.sort(cs.getImportsList(), new CanonicalTypeSorter());
    Collections.sort(cs.getAcceptLanguageList(), new CodeTypeSorter());
    Collections.sort(cs.getRestList(), new CSRestSorter());
    for (CapabilityStatementRestComponent r : cs.getRestList()) {
      if (r.hasSecurity()) {
        for (CodeableConcept cc : r.getSecurity().getServiceList()) {
          Collections.sort(cc.getCodingList(), new CodingSorter());
        }
        Collections.sort(r.getSecurity().getServiceList(), new CodeableConceptSorter());
      }
      Collections.sort(r.getResourceList(), new CSRestResourceSorter());
      for (CapabilityStatementRestResourceComponent res : r.getResourceList()) {
        Collections.sort(res.getSupportedProfileList(), new CanonicalTypeSorter());
        Collections.sort(res.getInteractionList(), new CSRestResourceInteractionSorter());
        Collections.sort(res.getSearchIncludeList(), new StringTypeSorter());
        Collections.sort(res.getSearchRevIncludeList(), new StringTypeSorter());
        Collections.sort(res.getSearchParamList(), new SearchParamSorter());
        Collections.sort(res.getOperationList(), new CSRestResourceOperationSorter());
      }
      Collections.sort(r.getInteractionList(), new CSRestInteractionSorter());
      Collections.sort(r.getSearchParamList(), new SearchParamSorter());
      Collections.sort(r.getOperationList(), new CSRestResourceOperationSorter());
      Collections.sort(r.getCompartmentList(), new CanonicalTypeSorter());
    }
  }
  

  public static class CodeTypeSorter implements Comparator<CodeType> {

    @Override
    public int compare(CodeType o1, CodeType o2) {
      return o1.asStringValue().compareTo(o2.asStringValue());
    }

  }

  public static class StringTypeSorter implements Comparator<StringType> {

    @Override
    public int compare(StringType o1, StringType o2) {
      return o1.asStringValue().compareTo(o2.asStringValue());
    }

  }

  public static class CanonicalTypeSorter implements Comparator<CanonicalType> {

    @Override
    public int compare(CanonicalType o1, CanonicalType o2) {
      return o1.asStringValue().compareTo(o2.asStringValue());
    }

  }

  public static class CodingSorter implements Comparator<Coding> {

    @Override
    public int compare(Coding c1, Coding c2) {
      if (c1.getSystem().equals(c2.getSystem())) {
        return c1.getCode().compareTo(c2.getCode());
      } else {
        return c1.getSystem().compareTo(c2.getSystem());        
      }
    }

  }
  public static class CodeableConceptSorter implements Comparator<CodeableConcept> {

    @Override
    public int compare(CodeableConcept o1, CodeableConcept o2) {
      if (o1.hasCoding() && o2.hasCoding()) {
        Coding c1 = o1.getCodingFirstRep();
        Coding c2 = o2.getCodingFirstRep();
        if (c1.getSystem().equals(c2.getSystem())) {
          return c1.getCode().compareTo(c2.getCode());
        } else {
          return c1.getSystem().compareTo(c2.getSystem());        
        }
      } else {
        return o1.getText().compareTo(o2.getText());
      }
    }

  }

  public static class CSRestSorter implements Comparator<CapabilityStatementRestComponent> {

    @Override
    public int compare(CapabilityStatementRestComponent o1, CapabilityStatementRestComponent o2) {
      return o1.getMode().compareTo(o2.getMode());
    }

  }

  public static class CSRestResourceSorter implements Comparator<CapabilityStatementRestResourceComponent> {

    @Override
    public int compare(CapabilityStatementRestResourceComponent o1, CapabilityStatementRestResourceComponent o2) {
      return o1.getType().compareTo(o2.getType());
    }

  }

  public static class CSRestResourceInteractionSorter implements Comparator<ResourceInteractionComponent> {

    @Override
    public int compare(ResourceInteractionComponent o1, ResourceInteractionComponent o2) {
      return o1.getCode().toCode().compareTo(o2.getCode().toCode());
    }

  }

  public static class CSRestInteractionSorter implements Comparator<SystemInteractionComponent> {

    @Override
    public int compare(SystemInteractionComponent o1, SystemInteractionComponent o2) {
      return o1.getCode().compareTo(o2.getCode());
    }

  }
  
  public static class SearchParamSorter implements Comparator<CapabilityStatementRestResourceSearchParamComponent> {

    @Override
    public int compare(CapabilityStatementRestResourceSearchParamComponent o1, CapabilityStatementRestResourceSearchParamComponent o2) {
      return o1.getName().compareTo(o2.getName());
    }

  }

  public static class CSRestResourceOperationSorter implements Comparator<CapabilityStatementRestResourceOperationComponent> {

    @Override
    public int compare(CapabilityStatementRestResourceOperationComponent o1, CapabilityStatementRestResourceOperationComponent o2) {
      return o1.getName().compareTo(o2.getName());
    }

  }

  public static void sortTermCaps(TerminologyCapabilities tc) {
    Collections.sort(tc.getCodeSystemList(), new TCCodeSystemSorter());
    for (TerminologyCapabilitiesCodeSystemComponent t : tc.getCodeSystemList()) {
      Collections.sort(t.getVersionList(), new TCCodeSystemVersionSorter());
      for (TerminologyCapabilitiesCodeSystemVersionComponent v : t.getVersionList()) {
        Collections.sort(v.getLanguageList(), new LanguageSorter());
        Collections.sort(v.getPropertyList(), new CodeTypeSorter());
        Collections.sort(v.getFilterList(), new TCCodeSystemVersionFilterSorter());
      }
    }
    Collections.sort(tc.getExpansion().getParameterList(), new TCExpansionParameterSorter());
  }


  public static class LanguageSorter implements Comparator<CodeType> {

    @Override
    public int compare(CodeType o1, CodeType o2) {
      return o1.asStringValue().compareTo(o2.asStringValue());
    }

  }
  public static class TCCodeSystemSorter implements Comparator<TerminologyCapabilitiesCodeSystemComponent> {

    @Override
    public int compare(TerminologyCapabilitiesCodeSystemComponent o1, TerminologyCapabilitiesCodeSystemComponent o2) {
      return o1.getUri().compareTo(o2.getUri());
    }

  }

  public static class TCCodeSystemVersionSorter implements Comparator<TerminologyCapabilitiesCodeSystemVersionComponent> {

    @Override
    public int compare(TerminologyCapabilitiesCodeSystemVersionComponent o1, TerminologyCapabilitiesCodeSystemVersionComponent o2) {
      return o1.getValue() == null || o2.getValue() == null ? 0 : o1.getValue().compareTo(o2.getValue());
    }

  }

  public static class TCCodeSystemVersionFilterSorter implements Comparator<TerminologyCapabilitiesCodeSystemVersionFilterComponent> {

    @Override
    public int compare(TerminologyCapabilitiesCodeSystemVersionFilterComponent o1, TerminologyCapabilitiesCodeSystemVersionFilterComponent o2) {
      return o1.getCode().compareTo(o2.getCode());
    }
  }

  public static class TCExpansionParameterSorter implements Comparator<TerminologyCapabilitiesExpansionParameterComponent> {

    @Override
    public int compare(TerminologyCapabilitiesExpansionParameterComponent o1, TerminologyCapabilitiesExpansionParameterComponent o2) {
      return o1.getName().compareTo(o2.getName());
    }

  }

    
}
