package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operators.*;
import edu.austral.ingsis.math.values.ExpressionSet;
import edu.austral.ingsis.math.values.Value;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double myResult =
        new ExpressionSet(new Value(1), new Value(6), new Addition()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double myResult =
        new ExpressionSet(new Value(12), new Value(2), new Division()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double myResult =
        new ExpressionSet(
                new ExpressionSet(new Value(9), new Value(2), new Division()),
                new Value(3),
                new Multiplication())
            .evaluate(new HashMap<>());

    assertThat(myResult, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double myResult =
        new ExpressionSet(
                new ExpressionSet(new Value(27), new Value(6), new Division()),
                new Value(2),
                new Exponentiation())
            .evaluate(new HashMap<>());

    assertThat(myResult, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double myResult =
        new ExpressionSet(new Value(36), new Value(0.5), new Exponentiation())
            .evaluate(new HashMap<>());

    assertThat(myResult, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double myResult =
        new ExpressionSet(new Value(136), new AbsoluteValue()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double myResult =
        new ExpressionSet(new Value(136), new AbsoluteValue()).evaluate(new HashMap<>());

    assertThat(myResult, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double myResult =
        new ExpressionSet(
                new ExpressionSet(new Value(5), new Value(5), new Subtraction()),
                new Value(8),
                new Multiplication())
            .evaluate(new HashMap<>());

    assertThat(myResult, equalTo(0d));
  }
}
