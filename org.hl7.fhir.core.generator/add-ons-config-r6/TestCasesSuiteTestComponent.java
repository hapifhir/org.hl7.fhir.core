
  public String getParameterStr(String name) { 
    for (TestCasesSuiteParameterComponent p : getParameterList()) { 
      if (name.equals(p.getName())) { 
        return p.getValue().primitiveValue(); 
      } 
    } 

    return null; 
  } 

  public DataType getParameter(String name) { 
    for (TestCasesSuiteParameterComponent p : getParameterList()) { 
      if (name.equals(p.getName())) { 
        return p.getValue(); 
      } 
    } 

    return null; 
  } 

  public TestCasesSuiteResourceComponent getInput(String name) { 
    for (TestCasesSuiteResourceComponent input : getInputList()) { 
      if (name.equals(input.getName())) { 
        return input; 
      } 
    } 
    return null; 
  } 