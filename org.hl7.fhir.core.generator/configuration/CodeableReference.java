
public CodeableReference(IModelContext modelContext, CodeableConcept cc) {
  super();
  this.modelContext = modelContext;
  setConcept(cc);
}

public CodeableReference(IModelContext modelContext, Reference ref) {
  super();
  this.modelContext = modelContext;
  setReference(ref);
}

public CodeableReference(CodeableConcept cc) {
  super();
  setConcept(cc);
}

public CodeableReference(Reference ref) {
  super();
  setReference(ref);
}
