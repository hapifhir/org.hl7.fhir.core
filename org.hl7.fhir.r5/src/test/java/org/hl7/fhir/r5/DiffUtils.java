package org.hl7.fhir.r5;

import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DiffUtils {

  public static void testDiff(String expectedPath, String actualPath) throws IOException {
    //build simple lists of the lines of the two testfiles
    List<String> expected = Files.readAllLines(ManagedFileAccess.file(expectedPath).toPath());
    List<String> actual = Files.readAllLines(ManagedFileAccess.file(actualPath).toPath());

//compute the patch: this is the diffutils part
    Patch<String> patch = com.github.difflib.DiffUtils.diff(expected, actual);

//simple output the computed patch to console
    for (AbstractDelta<String> delta : patch.getDeltas()) {
      System.out.println(delta);
    }
  }
}
