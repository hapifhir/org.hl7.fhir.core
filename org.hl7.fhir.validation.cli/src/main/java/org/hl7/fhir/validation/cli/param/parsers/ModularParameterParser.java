package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;

import java.util.*;

public class ModularParameterParser {
  final Map<Class<?>, IParamParser<?>> parsers;

  public ModularParameterParser(List<IParamParser<?>> parsers) {
    HashMap<Class<?>, IParamParser<?>> map = new HashMap<>();
    for (IParamParser<?> p : parsers) {
      map.put(p.getClass(), p);
    }
    this.parsers = Collections.unmodifiableMap(map);
  }

  public <K> IParamParser<K> getParser(Class<? extends IParamParser<K>> parserClass) {
    @SuppressWarnings("unchecked")
    IParamParser<K> parser = (IParamParser<K>) parsers.get(parserClass);
    return parser;
  }

  public void parseArgs(Arg[] args) {
    for (IParamParser<?> p : parsers.values()) {
      p.parseArgs(args);
    }
  }
}
