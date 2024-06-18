package edu.austral.ingsis.math.values;

import edu.austral.ingsis.math.operators.Operation;
import edu.austral.ingsis.math.operators.SingleArgumentOperation;
import java.util.ArrayList;
import java.util.Map;

public class ExpressionSet implements Expression {
  public final Expression left;
  public final Expression right;
  public final Operation operation;
  public final SingleArgumentOperation singleArgumentOperation;

  public ExpressionSet(Expression left, Expression right, Operation operation) {
    this.left = left;
    this.right = right;
    this.operation = operation;
    this.singleArgumentOperation = null;
  }

  public ExpressionSet(Expression expression, SingleArgumentOperation operation) {
    this.left = expression;
    this.right = null;
    this.operation = null;
    this.singleArgumentOperation = operation;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    if (operation == null) {
      assert singleArgumentOperation != null;
      return singleArgumentOperation.evaluate(left.evaluate(variables));
    }
    assert right != null;
    return operation.evaluate(left.evaluate(variables), right.evaluate(variables));
  }

  @Override
  public String toString() {
    return nestedToString(false);
  }

  @Override
  public String nestedToString(boolean isNested) {
    String result;
    if (operation == null) {
      assert singleArgumentOperation != null;
      result = singleArgumentOperation.getSymbol().replace(" ", left.toString());
    } else {
      assert right != null;
      result =
          left.nestedToString(true)
              + " "
              + operation.getSymbol()
              + " "
              + right.nestedToString(true);
    }
    return isNested && singleArgumentOperation == null ? "(" + result + ")" : result;
  }

  @Override
  public ArrayList<String> getVariables() {
    ArrayList<String> vars = new ArrayList<>(left.getVariables());
    if (right != null) {
      vars.addAll(right.getVariables());
    }
    return vars;
  }
}
