
public RequirementsStatementComponent findStatement(String key) { 
  for (RequirementsStatementComponent t : getStatementList()) { 
    if (key.equals(t.getKey())) { 
      return t; 
    } 
  } 
  return null; 
} 
