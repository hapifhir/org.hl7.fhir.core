{{startMark}}
package org.hl7.fhir.model.core;

import java.util.AbstractList;
import java.util.List;

{{license}}

{{generated}}
public class CoreResourceNameList extends AbstractList<String> {

  private static final List<String> DATA = List.of(
{{names}}
  );

  private static final CoreResourceNameList INSTANCE = new CoreResourceNameList();

  private CoreResourceNameList() {
  }

  public static CoreResourceNameList getInstance() {
    return INSTANCE;
  }

  @Override
  public String get(int index) {
    return DATA.get(index);
  }

  @Override
  public int size() {
    return DATA.size();
  }
}
