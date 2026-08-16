
public CodeableReference(IModelContext context, CodeableConcept cc) {
  super();
  this.modelContext = context;
  setConcept(cc);
}

public CodeableReference(IModelContext context, Reference ref) {
  super();
  this.modelContext = context;
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
