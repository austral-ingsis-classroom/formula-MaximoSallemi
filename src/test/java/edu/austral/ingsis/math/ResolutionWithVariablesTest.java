package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operators.*;
import edu.austral.ingsis.math.values.ExpressionSet;
import edu.austral.ingsis.math.values.Value;
import edu.austral.ingsis.math.values.Variable;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result =
        new ExpressionSet(new Value(1), new Variable("x"), new Addition())
            .evaluate(Map.of("x", 3d));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result =
        new ExpressionSet(new Value(12), new Variable("div"), new Division())
            .evaluate(Map.of("div", 4d));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result =
        new ExpressionSet(
                new ExpressionSet(new Value(9), new Variable("x"), new Division()),
                new Variable("y"),
                new Multiplication())
            .evaluate(Map.of("x", 3d, "y", 4d));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result =
        new ExpressionSet(
                new ExpressionSet(new Value(27), new Variable("a"), new Division()),
                new Variable("b"),
                new Exponentiation())
            .evaluate(Map.of("a", 9d, "b", 3d));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result =
        new ExpressionSet(new Variable("z"), new Value(0.5), new Exponentiation())
            .evaluate(Map.of("z", 36d));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result =
        new ExpressionSet(
                new ExpressionSet(new Variable("value"), new AbsoluteValue()),
                new Value(8),
                new Subtraction())
            .evaluate(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result =
        new ExpressionSet(
                new ExpressionSet(new Variable("value"), new AbsoluteValue()),
                new Value(8),
                new Subtraction())
            .evaluate(Map.of("value", 8d));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result =
        new ExpressionSet(
                new ExpressionSet(new Value(5), new Variable("i"), new Subtraction()),
                new Value(8),
                new Multiplication())
            .evaluate(Map.of("i", 2d));

    assertThat(result, equalTo(24d));
  }
}
