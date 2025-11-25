package org.hl7.fhir.validation.cli.tasks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.TransformLangParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.TxTestsParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.ValidationEngineParametersParser;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.special.TxTester;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

@Slf4j
public class TxTestsTask extends StandaloneTask{
  @Override
  public String getName() {
    return "txTests";
  }

  @Override
  public String getDisplayName() {
    return "Terminology Tests";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, TxTestsParametersParser.TX_TESTS);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(@Nonnull String[] args) throws Exception {
      String output = Params.getParam(args, OutputParametersParser.OUTPUT);
      String version = Params.getParam(args, TxTestsParametersParser.TEST_VERSION);
      final String tx = Params.getParam(args, ValidationEngineParametersParser.TERMINOLOGY);
      final String filter = Params.getParam(args, TxTestsParametersParser.FILTER);
      final String externals = Params.getParam(args, TxTestsParametersParser.EXTERNALS);
      if (output == null ) {
        output = Utilities.path("[tmp]");
      }
      if (version == null) {
        version = "current";
      }
      TxTester txTester = new TxTester(new TxTester.InternalTxLoader(version), tx, false, loadExternals(externals));
      List<String> inputs = new ArrayList<>(Params.getMultiValueParam(args, TransformLangParametersParser.INPUT));
      for (String input : inputs) {
        txTester.addLoader(new TxTester.InternalTxLoader(input, true));
      }

    Set<String> modeParams = new HashSet<>(Params.getMultiValueParam(args, TxTestsParametersParser.MODE));
    Set<String> modes = new HashSet<>();
    modes.add("general");
    for (String m : modeParams) {
      if ("!general".equals(m)) {
        modes.remove("general");
      } else {
        modes.add(m);
      }
    }
    log.info("Testing Modes: "+ CommaSeparatedStringBuilder.join(" | ", Utilities.sorted(modes)));

    boolean ok = txTester.setOutput(output).execute(modes, filter);
      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(output, "report.json")), txTester.getTestReport());
      SystemExitManager.setError(ok ? 0 : 1);
      SystemExitManager.finish();
  }

  private JsonObject loadExternals(String externals) throws JsonException, IOException {
    if (externals == null) {
      return null;
    } else {
      return JsonParser.parseObjectFromFile(externals);
    }
  }
}
