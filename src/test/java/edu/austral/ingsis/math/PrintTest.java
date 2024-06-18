package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operators.*;
import edu.austral.ingsis.math.values.ExpressionSet;
import edu.austral.ingsis.math.values.Value;
import edu.austral.ingsis.math.values.Variable;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    final String result = new ExpressionSet(new Value(1), new Value(6), new Addition()).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final String result = new ExpressionSet(new Value(12), new Value(2), new Division()).toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final String result =
        new ExpressionSet(
                new ExpressionSet(new Value(9), new Value(2), new Division()),
                new Value(3),
                new Multiplication())
            .toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final String result =
        new ExpressionSet(
                new ExpressionSet(new Value(27), new Value(6), new Division()),
                new Value(2),
                new Exponentiation())
            .toString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final String result =
        new ExpressionSet(
                new ExpressionSet(new Variable("value"), new AbsoluteValue()),
                new Value(8),
                new Subtraction())
            .toString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final String result =
        new ExpressionSet(
                new ExpressionSet(new Variable("value"), new AbsoluteValue()),
                new Value(8),
                new Subtraction())
            .toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final String result =
        new ExpressionSet(
                new ExpressionSet(new Value(5), new Variable("i"), new Subtraction()),
                new Value(8),
                new Multiplication())
            .toString();

    assertThat(result, equalTo(expected));
  }
}
