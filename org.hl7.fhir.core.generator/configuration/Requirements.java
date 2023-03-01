
public RequirementsStatementComponent findStatement(String key) { 
  for (RequirementsStatementComponent t : getStatement()) { 
    if (key.equals(t.getKey())) { 
      return t; 
    } 
  } 
  return null; 
} 
