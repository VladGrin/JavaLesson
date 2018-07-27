package javalesson.patterns.behavioral;

import java.util.Stack;

public class InterpreterLesson {
    public static void main(String[] args) {
        String expression = "1+2+3-4";
        ExpressionNew evaluator = new Evaluate(expression);
        System.out.println(evaluator.interpret(evaluator));
    }
}

interface ExpressionNew {
    int interpret(ExpressionNew context);
}

class Number implements ExpressionNew {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret(ExpressionNew context) {
        return number;
    }
}

class Plus implements ExpressionNew {
    ExpressionNew expressionLeft;
    ExpressionNew expressionRight;

    public Plus(ExpressionNew expressionLeft, ExpressionNew expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int interpret(ExpressionNew context) {
        return expressionLeft.interpret(context) + expressionRight.interpret(context);
    }
}

class Minus implements ExpressionNew {
    ExpressionNew expressionLeft;
    ExpressionNew expressionRight;

    public Minus(ExpressionNew expressionLeft, ExpressionNew expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int interpret(ExpressionNew context) {
        return expressionLeft.interpret(context) - expressionRight.interpret(context);
    }
}

class Evaluate implements ExpressionNew {
    ExpressionNew evaluate;

    public Evaluate(String expression) {
        Stack<ExpressionNew> expressionNews = new Stack<>();
        String expressionRever = new StringBuilder(expression).reverse().toString();
        for (String s : expressionRever.split("\\D")) {
            expressionNews.push(new Number(Integer.parseInt(s)));
        }
        for (String s : expressionRever.split("\\d")) {
            if (s.equals("+")) {
                expressionNews.push(new Plus(expressionNews.pop(), expressionNews.pop()));
            } else if (s.equals("+")) {
                expressionNews.push(new Minus(expressionNews.pop(), expressionNews.pop()));
            }
            expressionNews.push(new Number(Integer.parseInt(s)));
        }
        evaluate = expressionNews.pop();
    }

    @Override
    public int interpret(ExpressionNew context) {
        return evaluate.interpret(context);
    }
}