package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operators.*;
import edu.austral.ingsis.math.values.Expression;
import edu.austral.ingsis.math.values.ExpressionSet;
import edu.austral.ingsis.math.values.Value;
import edu.austral.ingsis.math.values.Variable;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final Expression result = new ExpressionSet(new Value(1), new Value(6), new Addition());

    assertThat(result.getVariables(), empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Expression result = new ExpressionSet(new Value(1), new Variable("div"), new Division());

    assertThat(result.getVariables(), containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final Expression result =
        new ExpressionSet(
            new ExpressionSet(new Value(9), new Variable("x"), new Division()),
            new Variable("y"),
            new Multiplication());

    assertThat(result.getVariables(), containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final Expression result =
        new ExpressionSet(
            new ExpressionSet(new Value(27), new Variable("a"), new Division()),
            new Variable("b"),
            new Exponentiation());

    assertThat(result.getVariables(), containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final Expression result =
        new ExpressionSet(
            new Variable("z"),
            new ExpressionSet(new Value(1), new Value(2), new Division()),
            new Exponentiation());

    assertThat(result.getVariables(), containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final Expression result =
        new ExpressionSet(
            new ExpressionSet(new Variable("value"), new AbsoluteValue()),
            new Value(8),
            new Subtraction());

    assertThat(result.getVariables(), containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final Expression result =
        new ExpressionSet(
            new ExpressionSet(new Variable("value"), new AbsoluteValue()),
            new Value(8),
            new Subtraction());

    assertThat(result.getVariables(), containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final Expression result =
        new ExpressionSet(
            new ExpressionSet(new Value(5), new Variable("i"), new Subtraction()),
            new Value(8),
            new Multiplication());

    assertThat(result.getVariables(), containsInAnyOrder("i"));
  }
}
