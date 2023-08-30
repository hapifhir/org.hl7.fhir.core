package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ExpressionNode;
import org.hl7.fhir.r5.model.ExpressionNode.Kind;
import org.hl7.fhir.r5.model.ExpressionNode.Operation;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class SearchParameterValidator extends BaseValidator {

  public class FhirPathSorter implements Comparator<ExpressionNode> {

    @Override
    public int compare(ExpressionNode arg0, ExpressionNode arg1) {
      return arg0.toString().compareTo(arg1.toString());
    }

  }

  private FHIRPathEngine fpe;

  public SearchParameterValidator(IWorkerContext context, boolean debug, TimeTracker timeTracker, FHIRPathEngine fpe, XVerExtensionManager xverManager, Coding jurisdiction) {
    super(context, xverManager, debug);
    source = Source.InstanceValidator;
    this.fpe = fpe;
    this.timeTracker = timeTracker;
    this.jurisdiction = jurisdiction;
  }
  
  public boolean validateSearchParameter(List<ValidationMessage> errors, Element cs, NodeStack stack) {
    boolean ok = true;
    String url = cs.getNamedChildValue("url");
    String master = cs.getNamedChildValue("derivedFrom");
    
    if (!Utilities.noString(master)) {
      SearchParameter sp = context.fetchResource(SearchParameter.class, master);
      if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE,stack.getLiteralPath(), sp != null, I18nConstants.SEARCHPARAMETER_NOTFOUND, master)) {
        // base must be in the master list of base
        List<Element> bl = cs.getChildren("base");
        for (Element b : bl) {
          ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE,stack.getLiteralPath(), sp.hasBase(b.primitiveValue()) || sp.hasBase("Resource"), I18nConstants.SEARCHPARAMETER_BASE_WRONG, master, b.primitiveValue()) && ok;
        }
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE,stack.getLiteralPath(), !cs.hasChild("type") || sp.getType().toCode().equals(cs.getNamedChildValue("type")), I18nConstants.SEARCHPARAMETER_TYPE_WRONG, master, sp.getType().toCode(), cs.getNamedChildValue("type")) && ok;
        if (sp.hasExpression() && cs.hasChild("expression") && !sp.getExpression().equals(cs.getNamedChildValue("expression"))) {
          List<String> bases = new ArrayList<>();
          for (Element b : cs.getChildren("base")) {
            bases.add(b.primitiveValue());
          }
          String expThis = canonicalise(cs.getNamedChildValue("expression"), bases);
          String expOther = canonicalise(sp.getExpression(), bases); 
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE,stack.getLiteralPath(), expThis.equals(expOther), I18nConstants.SEARCHPARAMETER_EXP_WRONG, master, sp.getExpression(), cs.getNamedChildValue("expression"));
        }
        // todo: check compositions
      }
    }
    return ok;
  }

  private String canonicalise(String path, List<String> bases) {   
    ExpressionNode exp = fpe.parse(path);
    List<ExpressionNode> pass = new ArrayList<>();
    while (exp != null) {
      if ((exp.getKind() != Kind.Name && !(exp.getKind() == Kind.Group && exp.getGroup().getKind() == Kind.Name))) {
        return path;
      }
      if (exp.getOperation() != null && exp.getOperation() != Operation.Union) {
        return path;
      }
      ExpressionNode nexp = exp.getOpNext();
      exp.setOperation(null);
      exp.setOpNext(null);  
      String name = exp.getKind() == Kind.Name ? exp.getName() : exp.getGroup().getName(); 
      if (context.getResourceNames().contains(name)) {
        if (bases.contains(name)) {
          pass.add(exp);
        }
      } else {
        pass.add(exp);
      }     
      exp = nexp; 
    }
    Collections.sort(pass, new FhirPathSorter());
    for (int i = 0; i < pass.size()-1; i++) {
      pass.get(i).setOperation(Operation.Union);
      pass.get(i).setOpNext(pass.get(i+1));
    }
    return pass.size() > 0 ? pass.get(0).toString() : null;
  }

}
