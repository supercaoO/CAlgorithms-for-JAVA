package com.caoO.expression;

import com.caoO.structrue.collection.CArrayStack;

import java.util.ArrayList;

public class ArithmeticalExpression {

    private static final ArrayList<String> ops = new ArrayList<>();
    private static final ArrayList<String> nums = new ArrayList<>();

    static {
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        ops.add("s");
        nums.add(".");
        for (int i = 0; i < 10; i++) {
            nums.add(Integer.valueOf(i).toString());
        }
    }

    public ArithmeticalExpression() {
    }

    public static double evaluate_old(String expression) {
        CArrayStack<String> operations = new CArrayStack<>();
        CArrayStack<Double> values = new CArrayStack<>();
        String[] strs = expression.trim().split(" ");
        for (String str : strs) {
            if (ops.contains(str)) {
                operations.push(str);
            } else if (str.equals(")")) {
                String op = operations.pop();
                double val = values.pop();
                if (op.equals("+"))
                    val = values.pop() + val;
                else if (op.equals("-"))
                    val = values.pop() - val;
                else if (op.equals("*"))
                    val *= values.pop();
                else if (op.equals("/"))
                    val = values.pop() / val;
                else if (op.equals("sqrt"))
                    val = Math.sqrt(val);
                values.push(val);
            } else if (nums.contains(str.substring(0, 1))) {
                values.push(Double.parseDouble(str));
            }
        }
        return values.pop();
    }

    public static double evaluate(String expression) {
        CArrayStack<String> operations = new CArrayStack<>();
        CArrayStack<Double> values = new CArrayStack<>();
        String num = new String();
        for (int i = 0; i < expression.length(); i++) {
            String c = new String(new char[] { expression.charAt(i) });
            if (nums.contains(c)) {
                num += c;
            } else {
                if (!num.equals("")) {
                    values.push(Double.parseDouble(num));
                    num = "";
                }
                if (ops.contains(c)) {
                    if (c.equals("s")) {
                        operations.push("sqrt");
                        i += 3;
                    } else {
                        operations.push(c);
                    }
                }
                else if (c.equals(")")) {
                    String op = operations.pop();
                    double val = values.pop();
                    if (op.equals("+"))
                        val = values.pop() + val;
                    else if (op.equals("-"))
                        val = values.pop() - val;
                    else if (op.equals("*"))
                        val *= values.pop();
                    else if (op.equals("/"))
                        val = values.pop() / val;
                    else if (op.equals("sqrt"))
                        val = Math.sqrt(val);
                    values.push(val);
                }
            }
        }
        return values.pop();
    }
}
