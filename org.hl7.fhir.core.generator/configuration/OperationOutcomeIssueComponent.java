@Override 
public String toString() { 
  if (getExpression().size() == 1) { 
    return getExpression().get(0)+" "+getDiagnostics()+" "+getSeverity().toCode()+"/"+getCode().toCode()+": "+getDetails().getText(); 
  } else { 
    return getExpression()+" "+getDiagnostics()+" "+getSeverity().toCode()+"/"+getCode().toCode()+": "+getDetails().getText(); 
  } 
} 