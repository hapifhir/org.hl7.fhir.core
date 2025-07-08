package org.hl7.fhir.validation.special;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesCodeSystemVersionFilterComponent;
import org.hl7.fhir.r5.model.TerminologyCapabilities.TerminologyCapabilitiesExpansionParameterComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.r5.model.Enumerations.CommonLanguages;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.validation.special.TxTesterSorters.CodeTypeSorter;

public class TxTesterSorters {


  public static void main(String[] args) throws JsonException, IOException {
    Resource r = new JsonParser().parse(new FileInputStream(args[0]));
    switch (r.fhirType()) {
    case "Parameters" :
      sortParameters((Parameters) r);
      break;
    default:
      return;
    }
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(args[0]), r);
  }

  public static void sortParameters(Parameters po) {
    Collections.sort(po.getParameter(), new TxTesterSorters.ParameterSorter());
    for (ParametersParameterComponent p : po.getParameter()) {
      if (p.getResource() != null && p.getResource() instanceof OperationOutcome) {
        Collections.sort(((OperationOutcome) p.getResource()).getIssue(), new TxTesterSorters.OperationIssueSorter());
      }
      if (p.getResource() != null && p.getResource() instanceof Parameters) {
        sortParameters(((Parameters) p.getResource()));
      }
      if ("message".equals(p.getName()) && p.hasValuePrimitive()) {
        String pv = p.getValue().primitiveValue();
        if (pv.contains("; ")) {
          List<String> bits = new ArrayList<>();
          for (String s : pv.split("\\; ")) {
            bits.add(s);
          }
          Collections.sort(bits);
          p.setValue(new StringType(CommaSeparatedStringBuilder.join("; ", bits)));
        }
      }
    }
  }


  public static void sortOperationOutcome(OperationOutcome oo) {
    Collections.sort(oo.getIssue(), new TxTesterSorters.OperationIssueSorter());
  }
  
  public static void sortValueSet(ValueSet vs) {
    Collections.sort(vs.getExtension(), new TxTesterSorters.ExtensionSorter());
    if (vs.hasExpansion()) {
      Collections.sort(vs.getExpansion().getParameter(), new TxTesterSorters.ExpParameterSorter());
      Collections.sort(vs.getExpansion().getProperty(), new TxTesterSorters.PropertyDefnSorter());
      Collections.sort(vs.getExpansion().getExtension(), new TxTesterSorters.ExtensionSorter());
      Collections.sort(vs.getExpansion().getContains(), new TxTesterSorters.ContainsSorter());
      for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContains()) {
        sortContainsFeatures(cc);
      }
    }
  }

  public static void sortContainsFeatures(ValueSetExpansionContainsComponent cc) {
    Collections.sort(cc.getContains(), new TxTesterSorters.ContainsSorter());
    Collections.sort(cc.getExtension(), new TxTesterSorters.ExtensionSorter());
    Collections.sort(cc.getDesignation(), new TxTesterSorters.DesignationSorter());
    Collections.sort(cc.getProperty(), new TxTesterSorters.PropertyValueSorter());
    for (ValueSetExpansionContainsComponent c : cc.getContains()) {
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
          s1 = o1.hasExpressionOrLocation() ? o1.getExpressionOrLocation().get(0).primitiveValue() : "";
          s2 = o2.hasExpressionOrLocation() ? o2.getExpressionOrLocation().get(0).primitiveValue() : "";
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
      Collections.sort(o1.getPart(), new ParameterSorter());
      Collections.sort(o2.getPart(), new ParameterSorter());
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
    Collections.sort(cs.getFormat(), new CodeTypeSorter());
    Collections.sort(cs.getInstantiates(), new CanonicalTypeSorter());
    Collections.sort(cs.getImports(), new CanonicalTypeSorter());
    Collections.sort(cs.getAcceptLanguage(), new CodeTypeSorter());
    Collections.sort(cs.getRest(), new CSRestSorter());
    for (CapabilityStatementRestComponent r : cs.getRest()) {
      if (r.hasSecurity()) {
        for (CodeableConcept cc : r.getSecurity().getService()) {
          Collections.sort(cc.getCoding(), new CodingSorter());
        }
        Collections.sort(r.getSecurity().getService(), new CodeableConceptSorter());        
      }
      Collections.sort(r.getResource(), new CSRestResourceSorter());
      for (CapabilityStatementRestResourceComponent res : r.getResource()) {
        Collections.sort(res.getSupportedProfile(), new CanonicalTypeSorter());
        Collections.sort(res.getInteraction(), new CSRestResourceInteractionSorter());
        Collections.sort(res.getSearchInclude(), new StringTypeSorter());
        Collections.sort(res.getSearchRevInclude(), new StringTypeSorter());
        Collections.sort(res.getSearchParam(), new SearchParamSorter());
        Collections.sort(res.getOperation(), new CSRestResourceOperationSorter());
      }
      Collections.sort(r.getInteraction(), new CSRestInteractionSorter());
      Collections.sort(r.getSearchParam(), new SearchParamSorter());
      Collections.sort(r.getOperation(), new CSRestResourceOperationSorter());
      Collections.sort(r.getCompartment(), new CanonicalTypeSorter());
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
    Collections.sort(tc.getCodeSystem(), new TCCodeSystemSorter());
    for (TerminologyCapabilitiesCodeSystemComponent t : tc.getCodeSystem()) {
      Collections.sort(t.getVersion(), new TCCodeSystemVersionSorter());
      for (TerminologyCapabilitiesCodeSystemVersionComponent v : t.getVersion()) {
        Collections.sort(v.getLanguage(), new LanguageSorter());
        Collections.sort(v.getProperty(), new CodeTypeSorter());
        Collections.sort(v.getFilter(), new TCCodeSystemVersionFilterSorter());
      }
    }
    Collections.sort(tc.getExpansion().getParameter(), new TCExpansionParameterSorter());
  }


  public static class LanguageSorter implements Comparator<Enumeration<CommonLanguages>> {

    @Override
    public int compare(Enumeration<CommonLanguages> o1, Enumeration<CommonLanguages> o2) {
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
      return o1.getCode() == null || o2.getCode() == null ? 0 : o1.getCode().compareTo(o2.getCode());
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
