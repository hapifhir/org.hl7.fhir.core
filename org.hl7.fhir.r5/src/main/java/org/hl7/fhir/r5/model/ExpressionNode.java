package org.hl7.fhir.r5.model;

import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.utilities.SourceLocation;

import java.util.List;

public class ExpressionNode extends org.hl7.fhir.r5.fhirpath.ExpressionNode{
  
  private final org.hl7.fhir.r5.fhirpath.ExpressionNode wrappedExpressionNode;
  public ExpressionNode(int uniqueId) {
    super(0);
    wrappedExpressionNode = new org.hl7.fhir.r5.fhirpath.ExpressionNode(uniqueId);
  }
  
  public ExpressionNode(org.hl7.fhir.r5.fhirpath.ExpressionNode wrappedExpressionNode) {
    super(0);
    this.wrappedExpressionNode = wrappedExpressionNode;
  }

  @Override
  public String toString() {
    return wrappedExpressionNode.toString();
  }

  @Override
  public String getName() {
    return wrappedExpressionNode.getName();
  }

  @Override
  public void setName(String name) {
    wrappedExpressionNode.setName(name);
  }

  @Override
  public Base getConstant() {
    return wrappedExpressionNode.getConstant();
  }

  @Override
  public void setConstant(Base constant) {
    wrappedExpressionNode.setConstant(constant);
  }

  @Override
  public Function getFunction() {
    return wrappedExpressionNode.getFunction();
  }

  @Override
  public void setFunction(Function function) {
    wrappedExpressionNode.setFunction(function);
  }

  @Override
  public boolean isProximal() {
    return wrappedExpressionNode.isProximal();
  }

  @Override
  public void setProximal(boolean proximal) {
    wrappedExpressionNode.setProximal(proximal);
  }

  @Override
  public Operation getOperation() {
    return wrappedExpressionNode.getOperation();
  }

  @Override
  public void setOperation(Operation operation) {
    wrappedExpressionNode.setOperation(operation);
  }

  @Override
  public org.hl7.fhir.r5.fhirpath.ExpressionNode getInner() {
    return wrappedExpressionNode.getInner();
  }

  @Override
  public void setInner(org.hl7.fhir.r5.fhirpath.ExpressionNode value) {
    wrappedExpressionNode.setInner(value);
  }

  @Override
  public org.hl7.fhir.r5.fhirpath.ExpressionNode getOpNext() {
    return wrappedExpressionNode.getOpNext();
  }

  @Override
  public void setOpNext(org.hl7.fhir.r5.fhirpath.ExpressionNode value) {
    wrappedExpressionNode.setOpNext(value);
  }

  @Override
  public List<org.hl7.fhir.r5.fhirpath.ExpressionNode> getParameters() {
    return wrappedExpressionNode.getParameters();
  }

  @Override
  public boolean checkName() {
    return wrappedExpressionNode.checkName();
  }

  @Override
  public Kind getKind() {
    return wrappedExpressionNode.getKind();
  }

  @Override
  public void setKind(Kind kind) {
    wrappedExpressionNode.setKind(kind);
  }

  @Override
  public org.hl7.fhir.r5.fhirpath.ExpressionNode getGroup() {
    return wrappedExpressionNode.getGroup();
  }

  @Override
  public void setGroup(org.hl7.fhir.r5.fhirpath.ExpressionNode group) {
    wrappedExpressionNode.setGroup(group);
  }

  @Override
  public SourceLocation getStart() {
    return wrappedExpressionNode.getStart();
  }

  @Override
  public void setStart(SourceLocation start) {
    wrappedExpressionNode.setStart(start);
  }

  @Override
  public SourceLocation getEnd() {
    return wrappedExpressionNode.getEnd();
  }

  @Override
  public void setEnd(SourceLocation end) {
    wrappedExpressionNode.setEnd(end);
  }

  @Override
  public SourceLocation getOpStart() {
    return wrappedExpressionNode.getOpStart();
  }

  @Override
  public void setOpStart(SourceLocation opStart) {
    wrappedExpressionNode.setOpStart(opStart);
  }

  @Override
  public SourceLocation getOpEnd() {
    return wrappedExpressionNode.getOpEnd();
  }

  @Override
  public void setOpEnd(SourceLocation opEnd) {
    wrappedExpressionNode.setOpEnd(opEnd);
  }

  @Override
  public String getUniqueId() {
    return wrappedExpressionNode.getUniqueId();
  }

  @Override
  public int parameterCount() {
    return wrappedExpressionNode.parameterCount();
  }

  @Override
  public String Canonical() {
    return wrappedExpressionNode.Canonical();
  }

  @Override
  public String summary() {
    return wrappedExpressionNode.summary();
  }

  @Override
  public String check() {
    return wrappedExpressionNode.check();
  }

  @Override
  public TypeDetails getTypes() {
    return wrappedExpressionNode.getTypes();
  }

  @Override
  public void setTypes(TypeDetails types) {
    wrappedExpressionNode.setTypes(types);
  }

  @Override
  public TypeDetails getOpTypes() {
    return wrappedExpressionNode.getOpTypes();
  }

  @Override
  public void setOpTypes(TypeDetails opTypes) {
    wrappedExpressionNode.setOpTypes(opTypes);
  }

  @Override
  public List<String> getDistalNames() {
    return wrappedExpressionNode.getDistalNames();
  }

  @Override
  public boolean isNullSet() {
    return wrappedExpressionNode.isNullSet();
  }
}
