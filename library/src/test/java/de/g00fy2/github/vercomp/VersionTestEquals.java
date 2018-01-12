package de.g00fy2.github.vercomp;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) public class VersionTestEquals {

  @Parameters public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { "1.2.3", "1.2.3" },
        { "1", "1.0" },
        { "2.0.0", "2" },
        { "2.4.0-beta3", "2.4.beta3" },
        { "2.4.0.beta3", "2.4-beta3" },
        { "hasdh10uadf", "hasdh10uadf" },
        { "?ü+", "?ü+" }
    });
  }

  private String fInputA;
  private String fInputB;

  public VersionTestEquals(String inputA, String inputB) {
    fInputA = inputA;
    fInputB = inputB;
  }

  @Test public void isEqual_isCorrect() throws Exception {
    assertEquals(fInputA + " and " + fInputB + " should be equal", true, new Version(fInputA).isEqual(fInputB));
  }
}