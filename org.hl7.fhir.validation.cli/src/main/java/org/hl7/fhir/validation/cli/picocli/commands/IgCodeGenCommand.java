package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.codegen.LogicalModelCodeGenerator;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Command to generate a full java model (classes + parsers + extensions support) for the
 * resources and logical models defined in one or more IG packages.
 * <p/>
 * This hidden command runs the {@link LogicalModelCodeGenerator}, which is the generator
 * used to produce the org.hl7.fhir.r5.tools and org.hl7.fhir.r5.openehr models. Unlike the
 * codegen command (which generates PE wrapper classes for profiles), this generates
 * first-class model classes in the style of the core org.hl7.fhir.r5.model classes.
 * <p/>
 * Requires -package-name for the Java package, -output for the output directory, and
 * -config for a configuration folder containing license.txt, configuration.ini and any
 * adornment .java fragments. The IG packages to generate from are listed as parameters
 * (e.g. hl7.fhir.uv.testing#current).
 * <p/>
 * This is an internal development tool for code generation.
 */
@Slf4j
@CommandLine.Command(
  name = "ig-codegen",
  description = """
    Generate a full java model from the resources and logical models in IG package(s).

    Runs the LogicalModelCodeGenerator (the generator used to produce the
    org.hl7.fhir.r5.tools and org.hl7.fhir.r5.openehr models). This is different
    to the codegen command, which generates PE wrapper classes for profiles;
    ig-codegen generates first-class model classes + XML/JSON parsers in the
    style of the core org.hl7.fhir.r5.model classes.

    Requires -package-name for the Java package, -output for the output directory,
    and -config for a configuration folder (license.txt + configuration.ini +
    adornments). List the IG packages to generate from as parameters
    (e.g. hl7.fhir.uv.testing#current).

    Hidden internal tool for code generation.
    """,
  hidden = true
)
public class IgCodeGenCommand extends ValidationServiceCommand implements Callable<Integer> {

  @CommandLine.Option(
    names = {"-package-name"},
    description = "Java package name for generated code (e.g. org.hl7.fhir.r5.igs.testing)",
    required = true
  )
  private String packageName;

  @CommandLine.Option(
    names = {"-output"},
    description = "Output directory for generated Java code",
    required = true
  )
  private String output;

  @CommandLine.Option(
    names = {"-config"},
    description = "Configuration folder containing license.txt, configuration.ini and any adornment .java fragments (e.g. org.hl7.fhir.core.generator/add-ons-config)",
    required = true
  )
  private String config;

  @CommandLine.Parameters(
    description = "The IG package(s) to generate code for (e.g. hl7.fhir.uv.testing#current)",
    arity = "1..*"
  )
  private List<String> packages = new ArrayList<>();

  @Override
  public Integer call() {
    try {
      new LogicalModelCodeGenerator().generate(packageName, output, config, packages);
      log.info("Code generation completed successfully");
      return 0;
    } catch (Exception e) {
      log.error("Error generating code", e);
      return 1;
    }
  }
}
