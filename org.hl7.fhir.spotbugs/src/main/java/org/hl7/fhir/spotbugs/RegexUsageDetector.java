package org.hl7.fhir.spotbugs;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Priorities;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;
import org.apache.bcel.Const;

/**
 * SpotBugs detector that flags calls to Java regex evaluation methods.
 *
 * Covers the same ground as the checkstyle stringImplicitPatternUsage / patternUsage /
 * regexUtilsUsage rules but is type-aware: a .split() call on a non-String receiver is
 * not flagged.
 */
public class RegexUsageDetector extends OpcodeStackDetector {

    private static final String PATTERN_CLASS = "java/util/regex/Pattern";
    private static final String STRING_CLASS = "java/lang/String";
    private static final String REGEX_UTILS_APACHE = "org/apache/commons/lang3/RegExUtils";
    private static final String REGEX_UTILS_FHIR = "org/hl7/fhir/utilities/regex/RegexUtils";

    private final BugReporter bugReporter;

    public RegexUsageDetector(BugReporter bugReporter) {
        this.bugReporter = bugReporter;
    }

    @Override
    public void sawOpcode(int seen) {
        if (seen != Const.INVOKEVIRTUAL && seen != Const.INVOKESTATIC) {
            return;
        }

        String owner = getClassConstantOperand();
        String name = getNameConstantOperand();

        if (PATTERN_CLASS.equals(owner)
                && ("compile".equals(name) || "matches".equals(name))) {
            report("REGEX_EXPLICIT_PATTERN_USAGE");
        } else if (STRING_CLASS.equals(owner)
                && ("matches".equals(name)
                    || "replaceAll".equals(name)
                    || "replaceFirst".equals(name)
                    || "split".equals(name))) {
            report("REGEX_IMPLICIT_STRING_USAGE");
        } else if (REGEX_UTILS_APACHE.equals(owner) || REGEX_UTILS_FHIR.equals(owner)) {
            report("REGEX_UTILS_USAGE");
        }
    }

    private void report(String bugType) {
        bugReporter.reportBug(
            new BugInstance(this, bugType, Priorities.HIGH_PRIORITY)
                .addClassAndMethod(this)
                .addCalledMethod(this)
                .addSourceLine(this, getPC()));
    }
}
